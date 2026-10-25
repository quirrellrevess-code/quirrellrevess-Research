package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Argument;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Literal;
import com.sun.mail.iap.LiteralException;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.ACL;
import com.sun.mail.imap.AppendUID;
import com.sun.mail.imap.Rights;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Quota;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* JADX INFO: loaded from: classes.dex */
public class IMAPProtocol extends Protocol {
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DONE = {68, 79, 78, 69, 13, 10};
    private boolean authenticated;
    private List authmechs;

    /* JADX INFO: renamed from: ba */
    private ByteArray f126ba;
    private Map capabilities;
    private boolean connected;
    private String idleTag;
    private String name;
    private boolean rev1;
    private SaslAuthenticator saslAuthenticator;
    private String[] searchCharsets;

    public IMAPProtocol(String str, String str2, int i, boolean z, PrintStream printStream, Properties properties, boolean z2) throws ProtocolException, IOException {
        super(str2, i, z, printStream, properties, "mail." + str, z2);
        this.connected = false;
        this.rev1 = false;
        this.capabilities = null;
        this.authmechs = null;
        try {
            this.name = str;
            capability();
            if (hasCapability("IMAP4rev1")) {
                this.rev1 = true;
            }
            this.searchCharsets = new String[]{"UTF-8", MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset())};
            this.connected = true;
        } catch (Throwable th) {
            if (!this.connected) {
                disconnect();
            }
            throw th;
        }
    }

    private String createFlagList(Flags flags) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        boolean z = true;
        for (Flags.Flag flag : flags.getSystemFlags()) {
            if (flag == Flags.Flag.ANSWERED) {
                str = "\\Answered";
            } else if (flag == Flags.Flag.DELETED) {
                str = "\\Deleted";
            } else if (flag == Flags.Flag.DRAFT) {
                str = "\\Draft";
            } else if (flag == Flags.Flag.FLAGGED) {
                str = "\\Flagged";
            } else if (flag == Flags.Flag.RECENT) {
                str = "\\Recent";
            } else {
                if (flag == Flags.Flag.SEEN) {
                    str = "\\Seen";
                }
            }
            if (z) {
                z = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str);
        }
        String[] userFlags = flags.getUserFlags();
        for (String str2 : userFlags) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str2);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private ListInfo[] doList(String str, String str2, String str3) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str2);
        String strEncode2 = BASE64MailboxEncoder.encode(str3);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        argument.writeString(strEncode2);
        Response[] responseArrCommand = command(str, argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        ListInfo[] listInfoArr = null;
        if (response.isOK()) {
            Vector vector = new Vector(1);
            int length = responseArrCommand.length;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals(str)) {
                        vector.addElement(new ListInfo(iMAPResponse));
                        responseArrCommand[i] = null;
                    }
                }
            }
            if (vector.size() > 0) {
                listInfoArr = new ListInfo[vector.size()];
                vector.copyInto(listInfoArr);
            }
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        return listInfoArr;
    }

    private AppendUID getAppendUID(Response response) {
        byte b;
        if (!response.isOK()) {
            return null;
        }
        do {
            b = response.readByte();
            if (b <= 0) {
                break;
            }
        } while (b != 91);
        if (b != 0 && response.readAtom().equalsIgnoreCase("APPENDUID")) {
            return new AppendUID(response.readLong(), response.readLong());
        }
        return null;
    }

    private int[] issueSearch(String str, SearchTerm searchTerm, String str2) throws SearchException, ProtocolException, IOException {
        int[] iArr = null;
        Argument argumentGenerateSequence = SearchSequence.generateSequence(searchTerm, str2 == null ? null : MimeUtility.javaCharset(str2));
        argumentGenerateSequence.writeAtom(str);
        Response[] responseArrCommand = str2 == null ? command("SEARCH", argumentGenerateSequence) : command("SEARCH CHARSET " + str2, argumentGenerateSequence);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        if (response.isOK()) {
            Vector vector = new Vector();
            int length = responseArrCommand.length;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("SEARCH")) {
                        while (true) {
                            int number = iMAPResponse.readNumber();
                            if (number == -1) {
                                break;
                            }
                            vector.addElement(new Integer(number));
                        }
                        responseArrCommand[i] = null;
                    }
                }
            }
            int size = vector.size();
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr2[i2] = ((Integer) vector.elementAt(i2)).intValue();
            }
            iArr = iArr2;
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        return iArr;
    }

    private Quota parseQuota(Response response) throws ParsingException {
        Quota quota = new Quota(response.readAtomString());
        response.skipSpaces();
        if (response.readByte() != 40) {
            throw new ParsingException("parse error in QUOTA");
        }
        Vector vector = new Vector();
        while (response.peekByte() != 41) {
            String atom = response.readAtom();
            if (atom != null) {
                vector.addElement(new Quota.Resource(atom, response.readLong(), response.readLong()));
            }
        }
        response.readByte();
        Quota.Resource[] resourceArr = new Quota.Resource[vector.size()];
        quota.resources = resourceArr;
        vector.copyInto(resourceArr);
        return quota;
    }

    public void append(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        appenduid(str, flags, date, literal, false);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        return appenduid(str, flags, date, literal, true);
    }

    public synchronized void authlogin(String str, String str2) throws ProtocolException, IOException {
        Response responseByeResponse;
        boolean z;
        String str3;
        Vector vector = new Vector();
        String strWriteCommand = null;
        try {
            z = false;
            responseByeResponse = null;
            strWriteCommand = writeCommand("AUTHENTICATE LOGIN", null);
        } catch (Exception e) {
            responseByeResponse = Response.byeResponse(e);
            z = true;
        }
        OutputStream outputStream = getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        boolean z2 = true;
        while (!z) {
            try {
                responseByeResponse = readResponse();
                if (responseByeResponse.isContinuation()) {
                    if (z2) {
                        str3 = str;
                        z2 = false;
                    } else {
                        str3 = str2;
                    }
                    bASE64EncoderStream.write(ASCIIUtility.getBytes(str3));
                    bASE64EncoderStream.flush();
                    byteArrayOutputStream.write(CRLF);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.flush();
                    byteArrayOutputStream.reset();
                } else if ((responseByeResponse.isTagged() && responseByeResponse.getTag().equals(strWriteCommand)) || responseByeResponse.isBYE()) {
                    z = true;
                } else {
                    vector.addElement(responseByeResponse);
                }
            } catch (Exception e2) {
                responseByeResponse = Response.byeResponse(e2);
            }
        }
        Response[] responseArr = new Response[vector.size()];
        vector.copyInto(responseArr);
        notifyResponseHandlers(responseArr);
        handleResult(responseByeResponse);
        setCapabilities(responseByeResponse);
        this.authenticated = true;
    }

    public synchronized void authplain(String str, String str2, String str3) throws ProtocolException, IOException {
        Response responseByeResponse;
        Vector vector = new Vector();
        boolean z = false;
        String strWriteCommand = null;
        try {
            responseByeResponse = null;
            strWriteCommand = writeCommand("AUTHENTICATE PLAIN", null);
        } catch (Exception e) {
            responseByeResponse = Response.byeResponse(e);
            z = true;
        }
        OutputStream outputStream = getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        while (!z) {
            try {
                responseByeResponse = readResponse();
                if (responseByeResponse.isContinuation()) {
                    bASE64EncoderStream.write(ASCIIUtility.getBytes(String.valueOf(str) + "\u0000" + str2 + "\u0000" + str3));
                    bASE64EncoderStream.flush();
                    byteArrayOutputStream.write(CRLF);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.flush();
                    byteArrayOutputStream.reset();
                } else if ((responseByeResponse.isTagged() && responseByeResponse.getTag().equals(strWriteCommand)) || responseByeResponse.isBYE()) {
                    z = true;
                } else {
                    vector.addElement(responseByeResponse);
                }
            } catch (Exception e2) {
                responseByeResponse = Response.byeResponse(e2);
            }
        }
        Response[] responseArr = new Response[vector.size()];
        vector.copyInto(responseArr);
        notifyResponseHandlers(responseArr);
        handleResult(responseByeResponse);
        setCapabilities(responseByeResponse);
        this.authenticated = true;
    }

    public void capability() throws ProtocolException {
        Response[] responseArrCommand = command("CAPABILITY", null);
        if (!responseArrCommand[responseArrCommand.length - 1].isOK()) {
            throw new ProtocolException(responseArrCommand[responseArrCommand.length - 1].toString());
        }
        this.capabilities = new HashMap(10);
        this.authmechs = new ArrayList(5);
        int length = responseArrCommand.length;
        for (int i = 0; i < length; i++) {
            if (responseArrCommand[i] instanceof IMAPResponse) {
                IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                if (iMAPResponse.keyEquals("CAPABILITY")) {
                    parseCapabilities(iMAPResponse);
                }
            }
        }
    }

    public void check() throws ProtocolException {
        simpleCommand("CHECK", null);
    }

    public void close() throws ProtocolException {
        simpleCommand("CLOSE", null);
    }

    public void copy(MessageSet[] messageSetArr, String str) throws ProtocolException {
        copy(MessageSet.toString(messageSetArr), str);
    }

    public void create(String str) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        simpleCommand("CREATE", argument);
    }

    public void delete(String str) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        simpleCommand("DELETE", argument);
    }

    public void deleteACL(String str, String str2) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        argument.writeString(str2);
        Response[] responseArrCommand = command("DELETEACL", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
    }

    @Override // com.sun.mail.iap.Protocol
    public void disconnect() {
        super.disconnect();
        this.authenticated = false;
    }

    public MailboxInfo examine(String str) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        Response[] responseArrCommand = command("EXAMINE", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(responseArrCommand);
        mailboxInfo.mode = 1;
        notifyResponseHandlers(responseArrCommand);
        handleResult(responseArrCommand[responseArrCommand.length - 1]);
        return mailboxInfo;
    }

    public void expunge() throws ProtocolException {
        simpleCommand("EXPUNGE", null);
    }

    public Response[] fetch(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return fetch(MessageSet.toString(messageSetArr), str, false);
    }

    public BODY fetchBody(int i, String str) throws ProtocolException {
        return fetchBody(i, str, false);
    }

    public BODYSTRUCTURE fetchBodyStructure(int i) throws ProtocolException {
        Response[] responseArrFetch = fetch(i, "BODYSTRUCTURE");
        notifyResponseHandlers(responseArrFetch);
        Response response = responseArrFetch[responseArrFetch.length - 1];
        if (response.isOK()) {
            return (BODYSTRUCTURE) FetchResponse.getItem(responseArrFetch, i, BODYSTRUCTURE.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public Flags fetchFlags(int i) throws ProtocolException {
        Response[] responseArrFetch = fetch(i, "FLAGS");
        int length = responseArrFetch.length;
        Flags flags = null;
        for (int i2 = 0; i2 < length; i2++) {
            if (responseArrFetch[i2] != null && (responseArrFetch[i2] instanceof FetchResponse) && ((FetchResponse) responseArrFetch[i2]).getNumber() == i && (flags = (Flags) ((FetchResponse) responseArrFetch[i2]).getItem(Flags.class)) != null) {
                responseArrFetch[i2] = null;
                break;
            }
        }
        notifyResponseHandlers(responseArrFetch);
        handleResult(responseArrFetch[responseArrFetch.length - 1]);
        return flags;
    }

    public RFC822DATA fetchRFC822(int i, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        Response[] responseArrFetch = fetch(i, str2);
        notifyResponseHandlers(responseArrFetch);
        Response response = responseArrFetch[responseArrFetch.length - 1];
        if (response.isOK()) {
            return (RFC822DATA) FetchResponse.getItem(responseArrFetch, i, RFC822DATA.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public UID fetchSequenceNumber(long j) throws ProtocolException {
        Response[] responseArrFetch = fetch(String.valueOf(j), "UID", true);
        int length = responseArrFetch.length;
        UID uid = null;
        for (int i = 0; i < length; i++) {
            if (responseArrFetch[i] != null && (responseArrFetch[i] instanceof FetchResponse) && (uid = (UID) ((FetchResponse) responseArrFetch[i]).getItem(UID.class)) != null) {
                if (uid.uid == j) {
                    break;
                }
                uid = null;
            }
        }
        notifyResponseHandlers(responseArrFetch);
        handleResult(responseArrFetch[responseArrFetch.length - 1]);
        return uid;
    }

    public UID[] fetchSequenceNumbers(long j, long j2) throws ProtocolException {
        UID uid;
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(j)));
        sb.append(":");
        sb.append(j2 == -1 ? "*" : String.valueOf(j2));
        Response[] responseArrFetch = fetch(sb.toString(), "UID", true);
        Vector vector = new Vector();
        int length = responseArrFetch.length;
        for (int i = 0; i < length; i++) {
            if (responseArrFetch[i] != null && (responseArrFetch[i] instanceof FetchResponse) && (uid = (UID) ((FetchResponse) responseArrFetch[i]).getItem(UID.class)) != null) {
                vector.addElement(uid);
            }
        }
        notifyResponseHandlers(responseArrFetch);
        handleResult(responseArrFetch[responseArrFetch.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    public UID fetchUID(int i) throws ProtocolException {
        Response[] responseArrFetch = fetch(i, "UID");
        notifyResponseHandlers(responseArrFetch);
        Response response = responseArrFetch[responseArrFetch.length - 1];
        if (response.isOK()) {
            return (UID) FetchResponse.getItem(responseArrFetch, i, UID.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public ACL[] getACL(String str) throws ProtocolException {
        String atomString;
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        Response[] responseArrCommand = command("GETACL", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        Vector vector = new Vector();
        if (response.isOK()) {
            int length = responseArrCommand.length;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("ACL")) {
                        iMAPResponse.readAtomString();
                        while (true) {
                            String atomString2 = iMAPResponse.readAtomString();
                            if (atomString2 == null || (atomString = iMAPResponse.readAtomString()) == null) {
                                break;
                            }
                            vector.addElement(new ACL(atomString2, new Rights(atomString)));
                        }
                        responseArrCommand[i] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        ACL[] aclArr = new ACL[vector.size()];
        vector.copyInto(aclArr);
        return aclArr;
    }

    public Map getCapabilities() {
        return this.capabilities;
    }

    public OutputStream getIMAPOutputStream() {
        return getOutputStream();
    }

    public Quota[] getQuota(String str) throws ProtocolException {
        if (!hasCapability("QUOTA")) {
            throw new BadCommandException("QUOTA not supported");
        }
        Argument argument = new Argument();
        argument.writeString(str);
        Response[] responseArrCommand = command("GETQUOTA", argument);
        Vector vector = new Vector();
        Response response = responseArrCommand[responseArrCommand.length - 1];
        if (response.isOK()) {
            int length = responseArrCommand.length;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("QUOTA")) {
                        vector.addElement(parseQuota(iMAPResponse));
                        responseArrCommand[i] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        Quota[] quotaArr = new Quota[vector.size()];
        vector.copyInto(quotaArr);
        return quotaArr;
    }

    public Quota[] getQuotaRoot(String str) throws ProtocolException {
        if (!hasCapability("QUOTA")) {
            throw new BadCommandException("GETQUOTAROOT not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        Response[] responseArrCommand = command("GETQUOTAROOT", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        Hashtable hashtable = new Hashtable();
        int i = 0;
        if (response.isOK()) {
            int length = responseArrCommand.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (responseArrCommand[i2] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i2];
                    if (iMAPResponse.keyEquals("QUOTAROOT")) {
                        iMAPResponse.readAtomString();
                        while (true) {
                            String atomString = iMAPResponse.readAtomString();
                            if (atomString == null) {
                                break;
                            }
                            hashtable.put(atomString, new Quota(atomString));
                        }
                        responseArrCommand[i2] = null;
                    } else if (iMAPResponse.keyEquals("QUOTA")) {
                        Quota quota = parseQuota(iMAPResponse);
                        Quota quota2 = (Quota) hashtable.get(quota.quotaRoot);
                        if (quota2 != null) {
                            Quota.Resource[] resourceArr = quota2.resources;
                        }
                        hashtable.put(quota.quotaRoot, quota);
                        responseArrCommand[i2] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        Quota[] quotaArr = new Quota[hashtable.size()];
        Enumeration enumerationElements = hashtable.elements();
        while (enumerationElements.hasMoreElements()) {
            quotaArr[i] = (Quota) enumerationElements.nextElement();
            i++;
        }
        return quotaArr;
    }

    @Override // com.sun.mail.iap.Protocol
    public ByteArray getResponseBuffer() {
        ByteArray byteArray = this.f126ba;
        this.f126ba = null;
        return byteArray;
    }

    public boolean hasCapability(String str) {
        return this.capabilities.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    public void idleAbort() throws ProtocolException {
        OutputStream outputStream = getOutputStream();
        try {
            outputStream.write(DONE);
            outputStream.flush();
        } catch (IOException unused) {
        }
    }

    public synchronized void idleStart() throws ProtocolException {
        Response responseByeResponse;
        if (!hasCapability("IDLE")) {
            throw new BadCommandException("IDLE not supported");
        }
        try {
            this.idleTag = writeCommand("IDLE", null);
            responseByeResponse = readResponse();
        } catch (LiteralException e) {
            responseByeResponse = e.getResponse();
        } catch (Exception e2) {
            responseByeResponse = Response.byeResponse(e2);
        }
        if (!responseByeResponse.isContinuation()) {
            handleResult(responseByeResponse);
        }
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public boolean isREV1() {
        return this.rev1;
    }

    public ListInfo[] list(String str, String str2) throws ProtocolException {
        return doList("LIST", str, str2);
    }

    public Rights[] listRights(String str, String str2) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        argument.writeString(str2);
        Response[] responseArrCommand = command("LISTRIGHTS", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        Vector vector = new Vector();
        if (response.isOK()) {
            int length = responseArrCommand.length;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("LISTRIGHTS")) {
                        iMAPResponse.readAtomString();
                        iMAPResponse.readAtomString();
                        while (true) {
                            String atomString = iMAPResponse.readAtomString();
                            if (atomString == null) {
                                break;
                            }
                            vector.addElement(new Rights(atomString));
                        }
                        responseArrCommand[i] = null;
                    }
                }
            }
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        Rights[] rightsArr = new Rights[vector.size()];
        vector.copyInto(rightsArr);
        return rightsArr;
    }

    public void login(String str, String str2) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        argument.writeString(str2);
        Response[] responseArrCommand = command("LOGIN", argument);
        notifyResponseHandlers(responseArrCommand);
        handleResult(responseArrCommand[responseArrCommand.length - 1]);
        setCapabilities(responseArrCommand[responseArrCommand.length - 1]);
        this.authenticated = true;
    }

    public void logout() throws ProtocolException {
        Response[] responseArrCommand = command("LOGOUT", null);
        this.authenticated = false;
        notifyResponseHandlers(responseArrCommand);
        disconnect();
    }

    public ListInfo[] lsub(String str, String str2) throws ProtocolException {
        return doList("LSUB", str, str2);
    }

    public Rights myRights(String str) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        Response[] responseArrCommand = command("MYRIGHTS", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        Rights rights = null;
        if (response.isOK()) {
            int length = responseArrCommand.length;
            Rights rights2 = null;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("MYRIGHTS")) {
                        iMAPResponse.readAtomString();
                        String atomString = iMAPResponse.readAtomString();
                        if (rights2 == null) {
                            rights2 = new Rights(atomString);
                        }
                        responseArrCommand[i] = null;
                    }
                }
            }
            rights = rights2;
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        return rights;
    }

    public Namespaces namespace() throws ProtocolException {
        if (!hasCapability("NAMESPACE")) {
            throw new BadCommandException("NAMESPACE not supported");
        }
        Namespaces namespaces = null;
        Response[] responseArrCommand = command("NAMESPACE", null);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        if (response.isOK()) {
            int length = responseArrCommand.length;
            Namespaces namespaces2 = null;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("NAMESPACE")) {
                        if (namespaces2 == null) {
                            namespaces2 = new Namespaces(iMAPResponse);
                        }
                        responseArrCommand[i] = null;
                    }
                }
            }
            namespaces = namespaces2;
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        return namespaces;
    }

    public void noop() throws ProtocolException {
        if (this.debug) {
            this.out.println("IMAP DEBUG: IMAPProtocol noop");
        }
        simpleCommand("NOOP", null);
    }

    public void parseCapabilities(Response response) {
        while (true) {
            String atom = response.readAtom(']');
            if (atom == null) {
                return;
            }
            if (atom.length() != 0) {
                this.capabilities.put(atom.toUpperCase(Locale.ENGLISH), atom);
                if (atom.regionMatches(true, 0, "AUTH=", 0, 5)) {
                    this.authmechs.add(atom.substring(5));
                    if (this.debug) {
                        this.out.println("IMAP DEBUG: AUTH: " + atom.substring(5));
                    }
                }
            } else if (response.peekByte() == 93) {
                return;
            } else {
                response.skipToken();
            }
        }
    }

    public BODY peekBody(int i, String str) throws ProtocolException {
        return fetchBody(i, str, true);
    }

    @Override // com.sun.mail.iap.Protocol
    public void processGreeting(Response response) throws ProtocolException {
        super.processGreeting(response);
        if (response.isOK()) {
            setCapabilities(response);
        } else {
            if (!((IMAPResponse) response).keyEquals("PREAUTH")) {
                throw new ConnectionException(this, response);
            }
            this.authenticated = true;
            setCapabilities(response);
        }
    }

    public boolean processIdleResponse(Response response) throws ProtocolException {
        notifyResponseHandlers(new Response[]{response});
        boolean zIsBYE = response.isBYE();
        if (response.isTagged() && response.getTag().equals(this.idleTag)) {
            zIsBYE = true;
        }
        if (zIsBYE) {
            this.idleTag = null;
        }
        handleResult(response);
        return !zIsBYE;
    }

    public void proxyauth(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        simpleCommand("PROXYAUTH", argument);
    }

    public synchronized Response readIdleResponse() {
        Response responseByeResponse;
        if (this.idleTag == null) {
            return null;
        }
        try {
            responseByeResponse = readResponse();
        } catch (ProtocolException e) {
            responseByeResponse = Response.byeResponse(e);
        } catch (IOException e2) {
            responseByeResponse = Response.byeResponse(e2);
        }
        return responseByeResponse;
    }

    @Override // com.sun.mail.iap.Protocol
    public Response readResponse() throws ProtocolException, IOException {
        return IMAPResponse.readResponse(this);
    }

    public void rename(String str, String str2) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str);
        String strEncode2 = BASE64MailboxEncoder.encode(str2);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        argument.writeString(strEncode2);
        simpleCommand("RENAME", argument);
    }

    public void sasllogin(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        List arrayList;
        if (this.saslAuthenticator == null) {
            try {
                Constructor<?> constructor = Class.forName("com.sun.mail.imap.protocol.IMAPSaslAuthenticator").getConstructor(IMAPProtocol.class, String.class, Properties.class, Boolean.TYPE, PrintStream.class, String.class);
                Object[] objArr = new Object[6];
                objArr[0] = this;
                objArr[1] = this.name;
                objArr[2] = this.props;
                objArr[3] = this.debug ? Boolean.TRUE : Boolean.FALSE;
                objArr[4] = this.out;
                objArr[5] = this.host;
                this.saslAuthenticator = (SaslAuthenticator) constructor.newInstance(objArr);
            } catch (Exception e) {
                if (this.debug) {
                    this.out.println("IMAP DEBUG: Can't load SASL authenticator: " + e);
                    return;
                }
                return;
            }
        }
        if (strArr == null || strArr.length <= 0) {
            arrayList = this.authmechs;
        } else {
            arrayList = new ArrayList(strArr.length);
            for (int i = 0; i < strArr.length; i++) {
                if (this.authmechs.contains(strArr[i])) {
                    arrayList.add(strArr[i]);
                }
            }
        }
        if (this.saslAuthenticator.authenticate((String[]) arrayList.toArray(new String[arrayList.size()]), str, str2, str3, str4)) {
            this.authenticated = true;
        }
    }

    public int[] search(MessageSet[] messageSetArr, SearchTerm searchTerm) throws SearchException, ProtocolException {
        return search(MessageSet.toString(messageSetArr), searchTerm);
    }

    public MailboxInfo select(String str) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        Response[] responseArrCommand = command("SELECT", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(responseArrCommand);
        notifyResponseHandlers(responseArrCommand);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        if (response.isOK()) {
            if (response.toString().indexOf("READ-ONLY") != -1) {
                mailboxInfo.mode = 1;
            } else {
                mailboxInfo.mode = 2;
            }
        }
        handleResult(response);
        return mailboxInfo;
    }

    public void setACL(String str, char c, ACL acl) throws ProtocolException {
        if (!hasCapability("ACL")) {
            throw new BadCommandException("ACL not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        argument.writeString(acl.getName());
        String string = acl.getRights().toString();
        if (c == '+' || c == '-') {
            string = String.valueOf(c) + string;
        }
        argument.writeString(string);
        Response[] responseArrCommand = command("SETACL", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
    }

    public void setCapabilities(Response response) {
        byte b;
        do {
            b = response.readByte();
            if (b <= 0) {
                break;
            }
        } while (b != 91);
        if (b != 0 && response.readAtom().equalsIgnoreCase("CAPABILITY")) {
            this.capabilities = new HashMap(10);
            this.authmechs = new ArrayList(5);
            parseCapabilities(response);
        }
    }

    public void setQuota(Quota quota) throws ProtocolException {
        if (!hasCapability("QUOTA")) {
            throw new BadCommandException("QUOTA not supported");
        }
        Argument argument = new Argument();
        argument.writeString(quota.quotaRoot);
        Argument argument2 = new Argument();
        if (quota.resources != null) {
            int i = 0;
            while (true) {
                Quota.Resource[] resourceArr = quota.resources;
                if (i >= resourceArr.length) {
                    break;
                }
                argument2.writeAtom(resourceArr[i].name);
                argument2.writeNumber(quota.resources[i].limit);
                i++;
            }
        }
        argument.writeArgument(argument2);
        Response[] responseArrCommand = command("SETQUOTA", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
    }

    public void startTLS() throws ProtocolException {
        try {
            super.startTLS("STARTTLS");
        } catch (ProtocolException e) {
            throw e;
        } catch (Exception e2) {
            notifyResponseHandlers(new Response[]{Response.byeResponse(e2)});
            disconnect();
        }
    }

    public Status status(String str, String[] strArr) throws ProtocolException {
        if (!isREV1() && !hasCapability("IMAP4SUNVERSION")) {
            throw new BadCommandException("STATUS not supported");
        }
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        Argument argument2 = new Argument();
        if (strArr == null) {
            strArr = Status.standardItems;
        }
        for (String str2 : strArr) {
            argument2.writeAtom(str2);
        }
        argument.writeArgument(argument2);
        Response[] responseArrCommand = command("STATUS", argument);
        Response response = responseArrCommand[responseArrCommand.length - 1];
        Status status = null;
        if (response.isOK()) {
            int length = responseArrCommand.length;
            Status status2 = null;
            for (int i = 0; i < length; i++) {
                if (responseArrCommand[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) responseArrCommand[i];
                    if (iMAPResponse.keyEquals("STATUS")) {
                        if (status2 == null) {
                            status2 = new Status(iMAPResponse);
                        } else {
                            Status.add(status2, new Status(iMAPResponse));
                        }
                        responseArrCommand[i] = null;
                    }
                }
            }
            status = status2;
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(response);
        return status;
    }

    public void storeFlags(MessageSet[] messageSetArr, Flags flags, boolean z) throws ProtocolException {
        storeFlags(MessageSet.toString(messageSetArr), flags, z);
    }

    public void subscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(BASE64MailboxEncoder.encode(str));
        simpleCommand("SUBSCRIBE", argument);
    }

    @Override // com.sun.mail.iap.Protocol
    public boolean supportsNonSyncLiterals() {
        return hasCapability("LITERAL+");
    }

    public void uidexpunge(UIDSet[] uIDSetArr) throws ProtocolException {
        if (!hasCapability("UIDPLUS")) {
            throw new BadCommandException("UID EXPUNGE not supported");
        }
        simpleCommand("UID EXPUNGE " + UIDSet.toString(uIDSetArr), null);
    }

    public void unsubscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(BASE64MailboxEncoder.encode(str));
        simpleCommand("UNSUBSCRIBE", argument);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal, boolean z) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str);
        Argument argument = new Argument();
        argument.writeString(strEncode);
        if (flags != null) {
            Flags.Flag flag = Flags.Flag.RECENT;
            if (flags.contains(flag)) {
                Flags flags2 = new Flags(flags);
                flags2.remove(flag);
                flags = flags2;
            }
            argument.writeAtom(createFlagList(flags));
        }
        if (date != null) {
            argument.writeString(INTERNALDATE.format(date));
        }
        argument.writeBytes(literal);
        Response[] responseArrCommand = command("APPEND", argument);
        notifyResponseHandlers(responseArrCommand);
        handleResult(responseArrCommand[responseArrCommand.length - 1]);
        if (z) {
            return getAppendUID(responseArrCommand[responseArrCommand.length - 1]);
        }
        return null;
    }

    public void copy(int i, int i2, String str) throws ProtocolException {
        copy(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), str);
    }

    public Response[] fetch(int i, int i2, String str) throws ProtocolException {
        return fetch(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), str, false);
    }

    public BODY fetchBody(int i, String str, boolean z) throws ProtocolException {
        Response[] responseArrFetch;
        String str2 = "]";
        if (z) {
            StringBuilder sb = new StringBuilder("BODY.PEEK[");
            if (str != null) {
                str2 = String.valueOf(str) + "]";
            }
            sb.append(str2);
            responseArrFetch = fetch(i, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder("BODY[");
            if (str != null) {
                str2 = String.valueOf(str) + "]";
            }
            sb2.append(str2);
            responseArrFetch = fetch(i, sb2.toString());
        }
        notifyResponseHandlers(responseArrFetch);
        Response response = responseArrFetch[responseArrFetch.length - 1];
        if (response.isOK()) {
            return (BODY) FetchResponse.getItem(responseArrFetch, i, BODY.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public BODY peekBody(int i, String str, int i2, int i3) throws ProtocolException {
        return fetchBody(i, str, i2, i3, true, null);
    }

    public int[] search(SearchTerm searchTerm) throws SearchException, ProtocolException {
        return search("ALL", searchTerm);
    }

    public void storeFlags(int i, int i2, Flags flags, boolean z) throws ProtocolException {
        storeFlags(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), flags, z);
    }

    private void copy(String str, String str2) throws ProtocolException {
        String strEncode = BASE64MailboxEncoder.encode(str2);
        Argument argument = new Argument();
        argument.writeAtom(str);
        argument.writeString(strEncode);
        simpleCommand("COPY", argument);
    }

    private int[] search(String str, SearchTerm searchTerm) throws SearchException, ProtocolException {
        if (SearchSequence.isAscii(searchTerm)) {
            try {
                return issueSearch(str, searchTerm, null);
            } catch (IOException unused) {
            }
        }
        int i = 0;
        while (true) {
            String[] strArr = this.searchCharsets;
            if (i < strArr.length) {
                if (strArr[i] != null) {
                    try {
                        return issueSearch(str, searchTerm, strArr[i]);
                    } catch (CommandFailedException unused2) {
                        this.searchCharsets[i] = null;
                    } catch (ProtocolException e) {
                        throw e;
                    } catch (IOException unused3) {
                        continue;
                    } catch (SearchException e2) {
                        throw e2;
                    }
                }
                i++;
            } else {
                throw new SearchException("Search failed");
            }
        }
    }

    public Response[] fetch(int i, String str) throws ProtocolException {
        return fetch(String.valueOf(i), str, false);
    }

    public BODY peekBody(int i, String str, int i2, int i3, ByteArray byteArray) throws ProtocolException {
        return fetchBody(i, str, i2, i3, true, byteArray);
    }

    public void storeFlags(int i, Flags flags, boolean z) throws ProtocolException {
        storeFlags(String.valueOf(i), flags, z);
    }

    private Response[] fetch(String str, String str2, boolean z) throws ProtocolException {
        if (z) {
            return command("UID FETCH " + str + " (" + str2 + ")", null);
        }
        return command("FETCH " + str + " (" + str2 + ")", null);
    }

    private void storeFlags(String str, Flags flags, boolean z) throws ProtocolException {
        Response[] responseArrCommand;
        if (z) {
            responseArrCommand = command("STORE " + str + " +FLAGS " + createFlagList(flags), null);
        } else {
            responseArrCommand = command("STORE " + str + " -FLAGS " + createFlagList(flags), null);
        }
        notifyResponseHandlers(responseArrCommand);
        handleResult(responseArrCommand[responseArrCommand.length - 1]);
    }

    public BODY fetchBody(int i, String str, int i2, int i3) throws ProtocolException {
        return fetchBody(i, str, i2, i3, false, null);
    }

    public BODY fetchBody(int i, String str, int i2, int i3, ByteArray byteArray) throws ProtocolException {
        return fetchBody(i, str, i2, i3, false, byteArray);
    }

    public BODY fetchBody(int i, String str, int i2, int i3, boolean z, ByteArray byteArray) throws ProtocolException {
        this.f126ba = byteArray;
        StringBuilder sb = new StringBuilder(z ? "BODY.PEEK[" : "BODY[");
        String str2 = "]<";
        if (str != null) {
            str2 = String.valueOf(str) + "]<";
        }
        sb.append(str2);
        sb.append(String.valueOf(i2));
        sb.append(".");
        sb.append(String.valueOf(i3));
        sb.append(">");
        Response[] responseArrFetch = fetch(i, sb.toString());
        notifyResponseHandlers(responseArrFetch);
        Response response = responseArrFetch[responseArrFetch.length - 1];
        if (response.isOK()) {
            return (BODY) FetchResponse.getItem(responseArrFetch, i, BODY.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public UID[] fetchSequenceNumbers(long[] jArr) throws ProtocolException {
        UID uid;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(jArr[i]));
        }
        Response[] responseArrFetch = fetch(stringBuffer.toString(), "UID", true);
        Vector vector = new Vector();
        int length = responseArrFetch.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (responseArrFetch[i2] != null && (responseArrFetch[i2] instanceof FetchResponse) && (uid = (UID) ((FetchResponse) responseArrFetch[i2]).getItem(UID.class)) != null) {
                vector.addElement(uid);
            }
        }
        notifyResponseHandlers(responseArrFetch);
        handleResult(responseArrFetch[responseArrFetch.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }
}
