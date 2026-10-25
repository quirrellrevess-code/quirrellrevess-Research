package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.Date;
import java.util.Vector;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;

/* JADX INFO: loaded from: classes.dex */
public class ENVELOPE implements Item {
    public InternetAddress[] bcc;

    /* JADX INFO: renamed from: cc */
    public InternetAddress[] f124cc;
    public Date date;
    public InternetAddress[] from;
    public String inReplyTo;
    public String messageId;
    public int msgno;
    public InternetAddress[] replyTo;
    public InternetAddress[] sender;
    public String subject;

    /* JADX INFO: renamed from: to */
    public InternetAddress[] f125to;
    public static final char[] name = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};
    private static MailDateFormat mailDateFormat = new MailDateFormat();

    public ENVELOPE(FetchResponse fetchResponse) throws ParsingException {
        this.date = null;
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() != 40) {
            throw new ParsingException("ENVELOPE parse error");
        }
        String string = fetchResponse.readString();
        if (string != null) {
            try {
                this.date = mailDateFormat.parse(string);
            } catch (Exception unused) {
            }
        }
        this.subject = fetchResponse.readString();
        this.from = parseAddressList(fetchResponse);
        this.sender = parseAddressList(fetchResponse);
        this.replyTo = parseAddressList(fetchResponse);
        this.f125to = parseAddressList(fetchResponse);
        this.f124cc = parseAddressList(fetchResponse);
        this.bcc = parseAddressList(fetchResponse);
        this.inReplyTo = fetchResponse.readString();
        this.messageId = fetchResponse.readString();
        if (fetchResponse.readByte() != 41) {
            throw new ParsingException("ENVELOPE parse error");
        }
    }

    private InternetAddress[] parseAddressList(Response response) throws ParsingException {
        response.skipSpaces();
        byte b = response.readByte();
        if (b != 40) {
            if (b != 78 && b != 110) {
                throw new ParsingException("ADDRESS parse error");
            }
            response.skip(2);
            return null;
        }
        Vector vector = new Vector();
        do {
            IMAPAddress iMAPAddress = new IMAPAddress(response);
            if (!iMAPAddress.isEndOfGroup()) {
                vector.addElement(iMAPAddress);
            }
        } while (response.peekByte() != 41);
        response.skip(1);
        InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
        vector.copyInto(internetAddressArr);
        return internetAddressArr;
    }
}
