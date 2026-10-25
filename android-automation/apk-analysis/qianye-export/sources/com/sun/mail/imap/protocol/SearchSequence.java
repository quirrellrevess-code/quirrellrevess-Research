package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Argument;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.search.AddressTerm;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.DateTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.HeaderTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.NotTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SizeTerm;
import javax.mail.search.StringTerm;
import javax.mail.search.SubjectTerm;

/* JADX INFO: loaded from: classes.dex */
public class SearchSequence {
    private static String[] monthTable = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static Calendar cal = new GregorianCalendar();

    private static Argument and(AndTerm andTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = andTerm.getTerms();
        Argument argumentGenerateSequence = generateSequence(terms[0], str);
        for (int i = 1; i < terms.length; i++) {
            argumentGenerateSequence.append(generateSequence(terms[i], str));
        }
        return argumentGenerateSequence;
    }

    private static Argument body(BodyTerm bodyTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("BODY");
        argument.writeString(bodyTerm.getPattern(), str);
        return argument;
    }

    private static Argument flag(FlagTerm flagTerm) throws SearchException {
        boolean testSet = flagTerm.getTestSet();
        Argument argument = new Argument();
        Flags flags = flagTerm.getFlags();
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        String[] userFlags = flags.getUserFlags();
        if (systemFlags.length == 0 && userFlags.length == 0) {
            throw new SearchException("Invalid FlagTerm");
        }
        for (int i = 0; i < systemFlags.length; i++) {
            if (systemFlags[i] == Flags.Flag.DELETED) {
                argument.writeAtom(testSet ? "DELETED" : "UNDELETED");
            } else if (systemFlags[i] == Flags.Flag.ANSWERED) {
                argument.writeAtom(testSet ? "ANSWERED" : "UNANSWERED");
            } else if (systemFlags[i] == Flags.Flag.DRAFT) {
                argument.writeAtom(testSet ? "DRAFT" : "UNDRAFT");
            } else if (systemFlags[i] == Flags.Flag.FLAGGED) {
                argument.writeAtom(testSet ? "FLAGGED" : "UNFLAGGED");
            } else if (systemFlags[i] == Flags.Flag.RECENT) {
                argument.writeAtom(testSet ? "RECENT" : "OLD");
            } else if (systemFlags[i] == Flags.Flag.SEEN) {
                argument.writeAtom(testSet ? "SEEN" : "UNSEEN");
            }
        }
        for (String str : userFlags) {
            argument.writeAtom(testSet ? "KEYWORD" : "UNKEYWORD");
            argument.writeAtom(str);
        }
        return argument;
    }

    private static Argument from(String str, String str2) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("FROM");
        argument.writeString(str, str2);
        return argument;
    }

    public static Argument generateSequence(SearchTerm searchTerm, String str) throws SearchException, IOException {
        if (searchTerm instanceof AndTerm) {
            return and((AndTerm) searchTerm, str);
        }
        if (searchTerm instanceof OrTerm) {
            return m128or((OrTerm) searchTerm, str);
        }
        if (searchTerm instanceof NotTerm) {
            return not((NotTerm) searchTerm, str);
        }
        if (searchTerm instanceof HeaderTerm) {
            return header((HeaderTerm) searchTerm, str);
        }
        if (searchTerm instanceof FlagTerm) {
            return flag((FlagTerm) searchTerm);
        }
        if (searchTerm instanceof FromTerm) {
            return from(((FromTerm) searchTerm).getAddress().toString(), str);
        }
        if (searchTerm instanceof FromStringTerm) {
            return from(((FromStringTerm) searchTerm).getPattern(), str);
        }
        if (searchTerm instanceof RecipientTerm) {
            RecipientTerm recipientTerm = (RecipientTerm) searchTerm;
            return recipient(recipientTerm.getRecipientType(), recipientTerm.getAddress().toString(), str);
        }
        if (searchTerm instanceof RecipientStringTerm) {
            RecipientStringTerm recipientStringTerm = (RecipientStringTerm) searchTerm;
            return recipient(recipientStringTerm.getRecipientType(), recipientStringTerm.getPattern(), str);
        }
        if (searchTerm instanceof SubjectTerm) {
            return subject((SubjectTerm) searchTerm, str);
        }
        if (searchTerm instanceof BodyTerm) {
            return body((BodyTerm) searchTerm, str);
        }
        if (searchTerm instanceof SizeTerm) {
            return size((SizeTerm) searchTerm);
        }
        if (searchTerm instanceof SentDateTerm) {
            return sentdate((SentDateTerm) searchTerm);
        }
        if (searchTerm instanceof ReceivedDateTerm) {
            return receiveddate((ReceivedDateTerm) searchTerm);
        }
        if (searchTerm instanceof MessageIDTerm) {
            return messageid((MessageIDTerm) searchTerm, str);
        }
        throw new SearchException("Search too complex");
    }

    private static Argument header(HeaderTerm headerTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("HEADER");
        argument.writeString(headerTerm.getHeaderName());
        argument.writeString(headerTerm.getPattern(), str);
        return argument;
    }

    public static boolean isAscii(SearchTerm searchTerm) {
        boolean z = searchTerm instanceof AndTerm;
        if (z || (searchTerm instanceof OrTerm)) {
            for (SearchTerm searchTerm2 : z ? ((AndTerm) searchTerm).getTerms() : ((OrTerm) searchTerm).getTerms()) {
                if (!isAscii(searchTerm2)) {
                    return false;
                }
            }
            return true;
        }
        if (searchTerm instanceof NotTerm) {
            return isAscii(((NotTerm) searchTerm).getTerm());
        }
        if (searchTerm instanceof StringTerm) {
            return isAscii(((StringTerm) searchTerm).getPattern());
        }
        if (searchTerm instanceof AddressTerm) {
            return isAscii(((AddressTerm) searchTerm).getAddress().toString());
        }
        return true;
    }

    private static Argument messageid(MessageIDTerm messageIDTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("HEADER");
        argument.writeString("Message-ID");
        argument.writeString(messageIDTerm.getPattern(), str);
        return argument;
    }

    private static Argument not(NotTerm notTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("NOT");
        SearchTerm term = notTerm.getTerm();
        if ((term instanceof AndTerm) || (term instanceof FlagTerm)) {
            argument.writeArgument(generateSequence(term, str));
        } else {
            argument.append(generateSequence(term, str));
        }
        return argument;
    }

    /* JADX INFO: renamed from: or */
    private static Argument m128or(OrTerm orTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = orTerm.getTerms();
        if (terms.length > 2) {
            SearchTerm searchTerm = terms[0];
            int i = 1;
            while (i < terms.length) {
                OrTerm orTerm2 = new OrTerm(searchTerm, terms[i]);
                i++;
                searchTerm = orTerm2;
            }
            terms = ((OrTerm) searchTerm).getTerms();
        }
        Argument argument = new Argument();
        if (terms.length > 1) {
            argument.writeAtom("OR");
        }
        if ((terms[0] instanceof AndTerm) || (terms[0] instanceof FlagTerm)) {
            argument.writeArgument(generateSequence(terms[0], str));
        } else {
            argument.append(generateSequence(terms[0], str));
        }
        if (terms.length > 1) {
            if ((terms[1] instanceof AndTerm) || (terms[1] instanceof FlagTerm)) {
                argument.writeArgument(generateSequence(terms[1], str));
            } else {
                argument.append(generateSequence(terms[1], str));
            }
        }
        return argument;
    }

    private static Argument receiveddate(DateTerm dateTerm) throws SearchException {
        Argument argument = new Argument();
        String iMAPDate = toIMAPDate(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                argument.writeAtom("OR BEFORE " + iMAPDate + " ON " + iMAPDate);
                return argument;
            case 2:
                argument.writeAtom("BEFORE " + iMAPDate);
                return argument;
            case 3:
                argument.writeAtom("ON " + iMAPDate);
                return argument;
            case 4:
                argument.writeAtom("NOT ON " + iMAPDate);
                return argument;
            case 5:
                argument.writeAtom("SINCE " + iMAPDate);
                return argument;
            case 6:
                argument.writeAtom("OR SINCE " + iMAPDate + " ON " + iMAPDate);
                return argument;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
    }

    private static Argument recipient(Message.RecipientType recipientType, String str, String str2) throws SearchException, IOException {
        Argument argument = new Argument();
        if (recipientType == Message.RecipientType.f862TO) {
            argument.writeAtom("TO");
        } else if (recipientType == Message.RecipientType.f861CC) {
            argument.writeAtom("CC");
        } else {
            if (recipientType != Message.RecipientType.BCC) {
                throw new SearchException("Illegal Recipient type");
            }
            argument.writeAtom("BCC");
        }
        argument.writeString(str, str2);
        return argument;
    }

    private static Argument sentdate(DateTerm dateTerm) throws SearchException {
        Argument argument = new Argument();
        String iMAPDate = toIMAPDate(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                argument.writeAtom("OR SENTBEFORE " + iMAPDate + " SENTON " + iMAPDate);
                return argument;
            case 2:
                argument.writeAtom("SENTBEFORE " + iMAPDate);
                return argument;
            case 3:
                argument.writeAtom("SENTON " + iMAPDate);
                return argument;
            case 4:
                argument.writeAtom("NOT SENTON " + iMAPDate);
                return argument;
            case 5:
                argument.writeAtom("SENTSINCE " + iMAPDate);
                return argument;
            case 6:
                argument.writeAtom("OR SENTSINCE " + iMAPDate + " SENTON " + iMAPDate);
                return argument;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
    }

    private static Argument size(SizeTerm sizeTerm) throws SearchException {
        Argument argument = new Argument();
        int comparison = sizeTerm.getComparison();
        if (comparison == 2) {
            argument.writeAtom("SMALLER");
        } else {
            if (comparison != 5) {
                throw new SearchException("Cannot handle Comparison");
            }
            argument.writeAtom("LARGER");
        }
        argument.writeNumber(sizeTerm.getNumber());
        return argument;
    }

    private static Argument subject(SubjectTerm subjectTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("SUBJECT");
        argument.writeString(subjectTerm.getPattern(), str);
        return argument;
    }

    private static String toIMAPDate(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        cal.setTime(date);
        stringBuffer.append(cal.get(5));
        stringBuffer.append("-");
        stringBuffer.append(monthTable[cal.get(2)]);
        stringBuffer.append('-');
        stringBuffer.append(cal.get(1));
        return stringBuffer.toString();
    }

    private static boolean isAscii(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }
}
