package com.sun.mail.smtp;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import com.tencent.smtt.sdk.TbsListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class SMTPTransport extends Transport {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String UNKNOWN = "UNKNOWN";
    private Address[] addresses;
    private SMTPOutputStream dataStream;
    private int defaultPort;
    private MessagingException exception;
    private Hashtable extMap;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private DigestMD5 md5support;
    private MimeMessage message;
    private String name;
    private PrintStream out;
    private boolean quitWait;
    private boolean reportSuccess;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;
    private static final String[] ignoreList = {"Bcc", "Content-Length"};
    private static final byte[] CRLF = {13, 10};
    private static char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", 25, false);
    }

    private void closeConnection() throws MessagingException {
        try {
            try {
                Socket socket = this.serverSocket;
                if (socket != null) {
                    socket.close();
                }
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (super.isConnected()) {
                    super.close();
                }
            } catch (IOException e) {
                throw new MessagingException("Server Close Failed", e);
            }
        } catch (Throwable th) {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean convertTo8Bit(MimePart mimePart) {
        boolean z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        try {
            if (mimePart.isMimeType("text/*")) {
                String encoding = mimePart.getEncoding();
                if (encoding != null && ((encoding.equalsIgnoreCase("quoted-printable") || encoding.equalsIgnoreCase("base64")) && is8Bit(mimePart.getInputStream()))) {
                    mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                    mimePart.setHeader("Content-Transfer-Encoding", "8bit");
                    z = true;
                }
            } else if (mimePart.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
                int count = mimeMultipart.getCount();
                boolean z2 = false;
                for (int i = 0; i < count; i++) {
                    try {
                        if (convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i))) {
                            z2 = true;
                        }
                    } catch (IOException | MessagingException unused) {
                    }
                }
                z = z2;
            }
        } catch (IOException | MessagingException unused2) {
        }
        return z;
    }

    private void expandGroups() {
        Vector vector = null;
        int i = 0;
        while (true) {
            Address[] addressArr = this.addresses;
            if (i >= addressArr.length) {
                break;
            }
            InternetAddress internetAddress = (InternetAddress) addressArr[i];
            if (internetAddress.isGroup()) {
                if (vector == null) {
                    Vector vector2 = new Vector();
                    for (int i2 = 0; i2 < i; i2++) {
                        vector2.addElement(this.addresses[i2]);
                    }
                    vector = vector2;
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (InternetAddress internetAddress2 : group) {
                            vector.addElement(internetAddress2);
                        }
                    } else {
                        vector.addElement(internetAddress);
                    }
                } catch (ParseException unused) {
                    vector.addElement(internetAddress);
                }
            } else if (vector != null) {
                vector.addElement(internetAddress);
            }
            i++;
        }
        if (vector != null) {
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            this.addresses = internetAddressArr;
        }
    }

    private synchronized DigestMD5 getMD5() {
        if (this.md5support == null) {
            this.md5support = new DigestMD5(this.debug ? this.out : null);
        }
        return this.md5support;
    }

    private void initStreams() throws IOException {
        Properties properties = this.session.getProperties();
        PrintStream debugOut = this.session.getDebugOut();
        boolean debug = this.session.getDebug();
        String property = properties.getProperty("mail.debug.quote");
        boolean z = property != null && property.equalsIgnoreCase("true");
        TraceInputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), debugOut);
        traceInputStream.setTrace(debug);
        traceInputStream.setQuote(z);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), debugOut);
        traceOutputStream.setTrace(debug);
        traceOutputStream.setQuote(z);
        this.serverOutput = new BufferedOutputStream(traceOutputStream);
        this.serverInput = new BufferedInputStream(traceInputStream);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z = false;
        int i = 0;
        while (true) {
            try {
                int i2 = inputStream.read();
                if (i2 < 0) {
                    if (this.debug && z) {
                        this.out.println("DEBUG SMTP: found an 8bit part");
                    }
                    return z;
                }
                int i3 = i2 & 255;
                if (i3 == 13 || i3 == 10) {
                    i = 0;
                } else if (i3 == 0 || (i = i + 1) > 998) {
                    return false;
                }
                if (i3 > 127) {
                    z = true;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private boolean isNotLastLine(String str) {
        return str != null && str.length() >= 4 && str.charAt(3) == '-';
    }

    private void issueSendCommand(String str, int i) throws MessagingException {
        sendCommand(str);
        int serverResponse = readServerResponse();
        if (serverResponse != i) {
            Address[] addressArr = this.validSentAddr;
            int length = addressArr == null ? 0 : addressArr.length;
            Address[] addressArr2 = this.validUnsentAddr;
            int length2 = addressArr2 == null ? 0 : addressArr2.length;
            Address[] addressArr3 = new Address[length + length2];
            if (length > 0) {
                System.arraycopy(addressArr, 0, addressArr3, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, addressArr3, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = addressArr3;
            if (this.debug) {
                this.out.println("DEBUG SMTP: got response code " + serverResponse + ", with response: " + this.lastServerResponse);
            }
            String str2 = this.lastServerResponse;
            int i2 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", 250);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i2;
            throw new SMTPSendFailedException(str, serverResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    private String normalizeAddress(String str) {
        if (str.startsWith("<") || str.endsWith(">")) {
            return str;
        }
        return "<" + str + ">";
    }

    private void openServer(String str, int i) throws MessagingException {
        if (this.debug) {
            this.out.println("DEBUG SMTP: trying to connect to host \"" + str + "\", port " + i + ", isSSL " + this.isSSL);
        }
        try {
            Socket socket = SocketFetcher.getSocket(str, i, this.session.getProperties(), "mail." + this.name, this.isSSL);
            this.serverSocket = socket;
            int port = socket.getPort();
            initStreams();
            int serverResponse = readServerResponse();
            if (serverResponse == 220) {
                if (this.debug) {
                    this.out.println("DEBUG SMTP: connected to host \"" + str + "\", port: " + port + "\n");
                    return;
                }
                return;
            }
            this.serverSocket.close();
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (this.debug) {
                this.out.println("DEBUG SMTP: could not connect to host \"" + str + "\", port: " + port + ", response: " + serverResponse + "\n");
            }
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + port + ", response: " + serverResponse);
        } catch (UnknownHostException e) {
            throw new MessagingException("Unknown SMTP host: " + str, e);
        } catch (IOException e2) {
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i, e2);
        }
    }

    public static String xtext(String str) {
        StringBuffer stringBuffer = null;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 128) {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
            if (cCharAt < '!' || cCharAt > '~' || cCharAt == '+' || cCharAt == '=') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.length() + 4);
                    stringBuffer.append(str.substring(0, i));
                }
                stringBuffer.append('+');
                stringBuffer.append(hexchar[(cCharAt & 240) >> 4]);
                stringBuffer.append(hexchar[cCharAt & 15]);
            } else if (stringBuffer != null) {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    public void checkConnected() {
        if (!super.isConnected()) {
            throw new IllegalStateException("Not connected");
        }
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        int serverResponse;
        if (super.isConnected()) {
            try {
                if (this.serverSocket != null) {
                    sendCommand("QUIT");
                    if (this.quitWait && (serverResponse = readServerResponse()) != 221 && serverResponse != -1) {
                        this.out.println("DEBUG SMTP: QUIT failed with " + serverResponse);
                    }
                }
                closeConnection();
            } catch (Throwable th) {
                closeConnection();
                throw th;
            }
        }
    }

    public synchronized void connect(Socket socket) throws MessagingException {
        this.serverSocket = socket;
        super.connect();
    }

    public OutputStream data() throws MessagingException {
        issueSendCommand("DATA", 354);
        SMTPOutputStream sMTPOutputStream = new SMTPOutputStream(this.serverOutput);
        this.dataStream = sMTPOutputStream;
        return sMTPOutputStream;
    }

    public boolean ehlo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "EHLO " + str;
        } else {
            str2 = "EHLO";
        }
        sendCommand(str2);
        int serverResponse = readServerResponse();
        if (serverResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable();
            boolean z = true;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (z) {
                        z = false;
                    } else if (line.length() >= 5) {
                        String strSubstring = line.substring(4);
                        int iIndexOf = strSubstring.indexOf(32);
                        String strSubstring2 = BuildConfig.FLAVOR;
                        if (iIndexOf > 0) {
                            strSubstring2 = strSubstring.substring(iIndexOf + 1);
                            strSubstring = strSubstring.substring(0, iIndexOf);
                        }
                        if (this.debug) {
                            this.out.println("DEBUG SMTP: Found extension \"" + strSubstring + "\", arg \"" + strSubstring2 + "\"");
                        }
                        this.extMap.put(strSubstring.toUpperCase(Locale.ENGLISH), strSubstring2);
                    }
                } catch (IOException unused) {
                }
            }
        }
        return serverResponse == 250;
    }

    @Override // javax.mail.Service
    public void finalize() throws Throwable {
        super.finalize();
        try {
            closeConnection();
        } catch (MessagingException unused) {
        }
    }

    public void finishData() throws MessagingException, IOException {
        this.dataStream.ensureAtBOL();
        issueSendCommand(".", 250);
    }

    public String getExtensionParameter(String str) {
        Hashtable hashtable = this.extMap;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    public synchronized String getLocalHost() {
        try {
            String str = this.localHostName;
            if (str == null || str.length() <= 0) {
                this.localHostName = this.session.getProperty("mail." + this.name + ".localhost");
            }
            String str2 = this.localHostName;
            if (str2 == null || str2.length() <= 0) {
                this.localHostName = this.session.getProperty("mail." + this.name + ".localaddress");
            }
            String str3 = this.localHostName;
            if (str3 == null || str3.length() <= 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String hostName = localHost.getHostName();
                this.localHostName = hostName;
                if (hostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        return this.localHostName;
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized String getSASLRealm() {
        if (this.saslRealm == "UNKNOWN") {
            String property = this.session.getProperty("mail." + this.name + ".sasl.realm");
            this.saslRealm = property;
            if (property == null) {
                this.saslRealm = this.session.getProperty("mail." + this.name + ".saslrealm");
            }
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    public void helo(String str) throws MessagingException {
        if (str == null) {
            issueCommand("HELO", 250);
            return;
        }
        issueCommand("HELO " + str, 250);
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!super.isConnected()) {
            return false;
        }
        try {
            try {
                if (this.useRset) {
                    sendCommand("RSET");
                } else {
                    sendCommand("NOOP");
                }
                int serverResponse = readServerResponse();
                if (serverResponse >= 0 && serverResponse != 421) {
                    return true;
                }
                try {
                    closeConnection();
                } catch (MessagingException unused) {
                }
                return false;
            } catch (MessagingException unused2) {
            }
        } catch (Exception unused3) {
            closeConnection();
            return false;
        }
        return false;
    }

    public synchronized void issueCommand(String str, int i) throws MessagingException {
        sendCommand(str);
        if (readServerResponse() != i) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    public void mailFrom() throws MessagingException {
        Address[] from;
        MimeMessage mimeMessage = this.message;
        String envelopeFrom = mimeMessage instanceof SMTPMessage ? ((SMTPMessage) mimeMessage).getEnvelopeFrom() : null;
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".from");
        }
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            MimeMessage mimeMessage2 = this.message;
            Address localAddress = (mimeMessage2 == null || (from = mimeMessage2.getFrom()) == null || from.length <= 0) ? InternetAddress.getLocalAddress(this.session) : from[0];
            if (localAddress == null) {
                throw new MessagingException("can't determine local email address");
            }
            envelopeFrom = ((InternetAddress) localAddress).getAddress();
        }
        String str = "MAIL FROM:" + normalizeAddress(envelopeFrom);
        if (supportsExtension("DSN")) {
            MimeMessage mimeMessage3 = this.message;
            String dSNRet = mimeMessage3 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage3).getDSNRet() : null;
            if (dSNRet == null) {
                dSNRet = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (dSNRet != null) {
                str = String.valueOf(str) + " RET=" + dSNRet;
            }
        }
        if (supportsExtension("AUTH")) {
            MimeMessage mimeMessage4 = this.message;
            String submitter = mimeMessage4 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage4).getSubmitter() : null;
            if (submitter == null) {
                submitter = this.session.getProperty("mail." + this.name + ".submitter");
            }
            if (submitter != null) {
                try {
                    str = String.valueOf(str) + " AUTH=" + xtext(submitter);
                } catch (IllegalArgumentException e) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: ignoring invalid submitter: " + submitter + ", Exception: " + e);
                    }
                }
            }
        }
        MimeMessage mimeMessage5 = this.message;
        String mailExtension = mimeMessage5 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage5).getMailExtension() : null;
        if (mailExtension == null) {
            mailExtension = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (mailExtension != null && mailExtension.length() > 0) {
            str = String.valueOf(str) + " " + mailExtension;
        }
        issueSendCommand(str, 250);
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01df A[PHI: r13
  0x01df: PHI (r13v4 int) = (r13v0 int), (r13v3 int) binds: [B:90:0x0190, B:92:0x01a6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // javax.mail.Service
    public boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        int i2;
        DigestMD5 md5;
        String property = this.session.getProperty("mail." + this.name + ".ehlo");
        boolean z = property == null || !property.equalsIgnoreCase("false");
        String property2 = this.session.getProperty("mail." + this.name + ".auth");
        boolean z2 = property2 != null && property2.equalsIgnoreCase("true");
        if (this.debug) {
            this.out.println("DEBUG SMTP: useEhlo " + z + ", useAuth " + z2);
        }
        if (z2 && (str2 == null || str3 == null)) {
            return false;
        }
        int iSimpleCommand = -1;
        if (i == -1) {
            String property3 = this.session.getProperty("mail." + this.name + ".port");
            i2 = property3 != null ? Integer.parseInt(property3) : this.defaultPort;
        } else {
            i2 = i;
        }
        String str4 = (str == null || str.length() == 0) ? "localhost" : str;
        if (this.serverSocket != null) {
            openServer();
        } else {
            openServer(str4, i2);
        }
        if (!(z ? ehlo(getLocalHost()) : false)) {
            helo(getLocalHost());
        }
        if (this.useStartTLS && supportsExtension("STARTTLS")) {
            startTLS();
            ehlo(getLocalHost());
        }
        if ((z2 || (str2 != null && str3 != null)) && (supportsExtension("AUTH") || supportsExtension("AUTH=LOGIN"))) {
            if (this.debug) {
                this.out.println("DEBUG SMTP: Attempt to authenticate");
                if (!supportsAuthentication("LOGIN") && supportsExtension("AUTH=LOGIN")) {
                    this.out.println("DEBUG SMTP: use AUTH=LOGIN hack");
                }
            }
            if (supportsAuthentication("LOGIN") || supportsExtension("AUTH=LOGIN")) {
                int iSimpleCommand2 = simpleCommand("AUTH LOGIN");
                if (iSimpleCommand2 == 530) {
                    startTLS();
                    iSimpleCommand2 = simpleCommand("AUTH LOGIN");
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
                    if (iSimpleCommand2 == 334) {
                        bASE64EncoderStream.write(ASCIIUtility.getBytes(str2));
                        bASE64EncoderStream.flush();
                        iSimpleCommand2 = simpleCommand(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.reset();
                    }
                    if (iSimpleCommand2 == 334) {
                        bASE64EncoderStream.write(ASCIIUtility.getBytes(str3));
                        bASE64EncoderStream.flush();
                        iSimpleCommand2 = simpleCommand(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.reset();
                    }
                    if (iSimpleCommand2 != 235) {
                        closeConnection();
                        return false;
                    }
                } catch (IOException unused) {
                    if (iSimpleCommand2 != 235) {
                        closeConnection();
                        return false;
                    }
                } catch (Throwable th) {
                    if (iSimpleCommand2 == 235) {
                        throw th;
                    }
                    closeConnection();
                    return false;
                }
            } else if (supportsAuthentication("PLAIN")) {
                int iSimpleCommand3 = simpleCommand("AUTH PLAIN");
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    BASE64EncoderStream bASE64EncoderStream2 = new BASE64EncoderStream(byteArrayOutputStream2, Integer.MAX_VALUE);
                    if (iSimpleCommand3 == 334) {
                        bASE64EncoderStream2.write(0);
                        bASE64EncoderStream2.write(ASCIIUtility.getBytes(str2));
                        bASE64EncoderStream2.write(0);
                        bASE64EncoderStream2.write(ASCIIUtility.getBytes(str3));
                        bASE64EncoderStream2.flush();
                        iSimpleCommand3 = simpleCommand(byteArrayOutputStream2.toByteArray());
                    }
                    if (iSimpleCommand3 != 235) {
                        closeConnection();
                        return false;
                    }
                } catch (IOException unused2) {
                    if (iSimpleCommand3 != 235) {
                        closeConnection();
                        return false;
                    }
                } catch (Throwable th2) {
                    if (iSimpleCommand3 == 235) {
                        throw th2;
                    }
                    closeConnection();
                    return false;
                }
            } else if (supportsAuthentication("DIGEST-MD5") && (md5 = getMD5()) != null) {
                int iSimpleCommand4 = simpleCommand("AUTH DIGEST-MD5");
                if (iSimpleCommand4 == 334) {
                    try {
                        try {
                            iSimpleCommand4 = simpleCommand(md5.authClient(str4, str2, str3, getSASLRealm(), this.lastServerResponse));
                            if (iSimpleCommand4 != 334) {
                                iSimpleCommand = iSimpleCommand4;
                            } else if (md5.authServer(this.lastServerResponse)) {
                                iSimpleCommand = simpleCommand(new byte[0]);
                            }
                        } catch (Exception e) {
                            if (this.debug) {
                                this.out.println("DEBUG SMTP: DIGEST-MD5: " + e);
                            }
                            if (iSimpleCommand4 != 235) {
                                closeConnection();
                                return false;
                            }
                        }
                    } catch (Throwable th3) {
                        if (iSimpleCommand4 == 235) {
                            throw th3;
                        }
                        closeConnection();
                        return false;
                    }
                } else {
                    iSimpleCommand = iSimpleCommand4;
                }
                if (iSimpleCommand != 235) {
                    closeConnection();
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x020f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x0210  */
    /* JADX WARN: Code duplicated, block: B:112:0x022c  */
    /* JADX WARN: Code duplicated, block: B:141:0x028a  */
    /* JADX WARN: Code duplicated, block: B:144:0x02af  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:158:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:159:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:162:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:164:0x02f5 A[PHI: r8 r10
  0x02f5: PHI (r8v6 java.lang.Exception) = (r8v5 java.lang.Exception), (r8v10 java.lang.Exception), (r8v12 java.lang.Exception), (r8v16 java.lang.Exception) binds: [B:163:0x02f3, B:156:0x02dd, B:150:0x02c9, B:136:0x027d] A[DONT_GENERATE, DONT_INLINE]
  0x02f5: PHI (r10v5 boolean) = (r10v1 boolean), (r10v7 boolean), (r10v9 boolean), (r10v11 boolean) binds: [B:163:0x02f3, B:156:0x02dd, B:150:0x02c9, B:136:0x027d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:165:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:173:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x02fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d4 A[LOOP:2: B:42:0x00cd->B:45:0x00d4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4 A[LOOP:1: B:39:0x00c6->B:46:0x00e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:56:0x010c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0135  */
    /* JADX WARN: Code duplicated, block: B:67:0x014c A[LOOP:3: B:64:0x0146->B:67:0x014c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x0179 A[LOOP:4: B:73:0x0173->B:76:0x0179, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a6 A[LOOP:5: B:82:0x01a0->B:85:0x01a6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e1 A[Catch: all -> 0x01e9, MessagingException -> 0x01eb, TRY_LEAVE, TryCatch #0 {MessagingException -> 0x01eb, blocks: (B:91:0x01dd, B:93:0x01e1), top: B:167:0x01dd }] */
    /* JADX WARN: Instruction removed from duplicated block: B:110:0x0210, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:112:0x022c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:141:0x028a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x014c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:76:0x0179, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:85:0x01a6, please report this as an issue */
    public void rcptTo() throws MessagingException {
        String dSNNotify;
        boolean z;
        MessagingException messagingException;
        int i;
        boolean z2;
        Address[] addressArr;
        Address[] addressArr2;
        Address[] addressArr3;
        Address[] addressArr4;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        InternetAddress internetAddress;
        String str;
        int serverResponse;
        Exception sMTPAddressSucceededException;
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        this.invalidAddr = null;
        this.validUnsentAddr = null;
        this.validSentAddr = null;
        MimeMessage mimeMessage = this.message;
        boolean sendPartial = mimeMessage instanceof SMTPMessage ? ((SMTPMessage) mimeMessage).getSendPartial() : false;
        boolean z3 = true;
        if (!sendPartial) {
            String property = this.session.getProperty("mail." + this.name + ".sendpartial");
            sendPartial = property != null && property.equalsIgnoreCase("true");
        }
        if (this.debug && sendPartial) {
            this.out.println("DEBUG SMTP: sendPartial set");
        }
        if (supportsExtension("DSN")) {
            MimeMessage mimeMessage2 = this.message;
            dSNNotify = mimeMessage2 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage2).getDSNNotify() : null;
            if (dSNNotify == null) {
                dSNNotify = this.session.getProperty("mail." + this.name + ".dsn.notify");
            }
            z = dSNNotify != null;
            messagingException = null;
            i = 0;
            z2 = false;
            while (true) {
                addressArr = this.addresses;
                if (i >= addressArr.length) {
                    if (sendPartial && vector.size() == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        Address[] addressArr5 = new Address[vector3.size()];
                        this.invalidAddr = addressArr5;
                        vector3.copyInto(addressArr5);
                        this.validUnsentAddr = new Address[vector.size() + vector2.size()];
                        i5 = 0;
                        i6 = 0;
                        while (i5 < vector.size()) {
                            this.validUnsentAddr[i6] = (Address) vector.elementAt(i5);
                            i5++;
                            i6++;
                        }
                        i7 = 0;
                        while (i7 < vector2.size()) {
                            this.validUnsentAddr[i6] = (Address) vector2.elementAt(i7);
                            i7++;
                            i6++;
                        }
                    } else if (!this.reportSuccess || (sendPartial && (vector3.size() > 0 || vector2.size() > 0))) {
                        this.sendPartiallyFailed = z3;
                        this.exception = messagingException;
                        Address[] addressArr6 = new Address[vector3.size()];
                        this.invalidAddr = addressArr6;
                        vector3.copyInto(addressArr6);
                        Address[] addressArr7 = new Address[vector2.size()];
                        this.validUnsentAddr = addressArr7;
                        vector2.copyInto(addressArr7);
                        Address[] addressArr8 = new Address[vector.size()];
                        this.validSentAddr = addressArr8;
                        vector.copyInto(addressArr8);
                    } else {
                        this.validSentAddr = this.addresses;
                    }
                    if (this.debug) {
                        addressArr2 = this.validSentAddr;
                        if (addressArr2 != null && addressArr2.length > 0) {
                            this.out.println("DEBUG SMTP: Verified Addresses");
                            for (i4 = 0; i4 < this.validSentAddr.length; i4++) {
                                this.out.println("DEBUG SMTP:   " + this.validSentAddr[i4]);
                            }
                        }
                        addressArr3 = this.validUnsentAddr;
                        if (addressArr3 != null && addressArr3.length > 0) {
                            this.out.println("DEBUG SMTP: Valid Unsent Addresses");
                            for (i3 = 0; i3 < this.validUnsentAddr.length; i3++) {
                                this.out.println("DEBUG SMTP:   " + this.validUnsentAddr[i3]);
                            }
                        }
                        addressArr4 = this.invalidAddr;
                        if (addressArr4 != null && addressArr4.length > 0) {
                            this.out.println("DEBUG SMTP: Invalid Addresses");
                            for (i2 = 0; i2 < this.invalidAddr.length; i2++) {
                                this.out.println("DEBUG SMTP:   " + this.invalidAddr[i2]);
                            }
                        }
                    }
                    if (z2) {
                        if (this.debug) {
                            this.out.println("DEBUG SMTP: Sending failed because of invalid destination addresses");
                        }
                        notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                        String str2 = this.lastServerResponse;
                        int i8 = this.lastReturnCode;
                        try {
                            try {
                                try {
                                    if (this.serverSocket != null) {
                                        issueCommand("RSET", 250);
                                    }
                                } catch (MessagingException e) {
                                    if (this.debug) {
                                        e.printStackTrace(this.out);
                                    }
                                }
                            } finally {
                                this.lastServerResponse = str2;
                                this.lastReturnCode = i8;
                            }
                        } catch (MessagingException unused) {
                            close();
                        }
                        throw new SendFailedException("Invalid Addresses", messagingException, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                    }
                    return;
                }
                internetAddress = (InternetAddress) addressArr[i];
                str = "RCPT TO:" + normalizeAddress(internetAddress.getAddress());
                if (z) {
                    str = String.valueOf(str) + " NOTIFY=" + dSNNotify;
                }
                sendCommand(str);
                serverResponse = readServerResponse();
                if (serverResponse != 250 || serverResponse == 251) {
                    vector.addElement(internetAddress);
                    if (this.reportSuccess) {
                        sMTPAddressSucceededException = new SMTPAddressSucceededException(internetAddress, str, serverResponse, this.lastServerResponse);
                        if (messagingException == null) {
                            messagingException = sMTPAddressSucceededException;
                        } else {
                            messagingException.setNextException(sMTPAddressSucceededException);
                        }
                    }
                } else if (serverResponse != 501 && serverResponse != 503) {
                    switch (serverResponse) {
                        default:
                            switch (serverResponse) {
                                case Videoio.CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_SIZE /* 550 */:
                                case Videoio.CAP_PROP_XI_BUFFERS_QUEUE_SIZE /* 551 */:
                                case Videoio.CAP_PROP_XI_RECENT_FRAME /* 553 */:
                                    if (!sendPartial) {
                                        z2 = true;
                                    }
                                    vector3.addElement(internetAddress);
                                    sMTPAddressSucceededException = new SMTPAddressFailedException(internetAddress, str, serverResponse, this.lastServerResponse);
                                    if (messagingException == null) {
                                        messagingException = sMTPAddressSucceededException;
                                    } else {
                                        messagingException.setNextException(sMTPAddressSucceededException);
                                    }
                                    break;
                                case Videoio.CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_COMMIT /* 552 */:
                                    break;
                                default:
                                    if (serverResponse >= 400 && serverResponse <= 499) {
                                        vector2.addElement(internetAddress);
                                    } else if (serverResponse >= 500 && serverResponse <= 599) {
                                        vector3.addElement(internetAddress);
                                    }
                                    if (!sendPartial) {
                                        z2 = true;
                                    }
                                    sMTPAddressSucceededException = new SMTPAddressFailedException(internetAddress, str, serverResponse, this.lastServerResponse);
                                    if (messagingException == null) {
                                        messagingException = sMTPAddressSucceededException;
                                    } else {
                                        messagingException.setNextException(sMTPAddressSucceededException);
                                    }
                                    break;
                            }
                        case Videoio.CAP_PROP_XI_WB_KB /* 450 */:
                        case Videoio.CAP_PROP_XI_WIDTH /* 451 */:
                        case Videoio.CAP_PROP_XI_HEIGHT /* 452 */:
                            if (!sendPartial) {
                                z2 = true;
                            }
                            vector2.addElement(internetAddress);
                            sMTPAddressSucceededException = new SMTPAddressFailedException(internetAddress, str, serverResponse, this.lastServerResponse);
                            if (messagingException == null) {
                                messagingException = sMTPAddressSucceededException;
                            } else {
                                messagingException.setNextException(sMTPAddressSucceededException);
                            }
                            break;
                    }
                } else {
                    if (!sendPartial) {
                        z2 = true;
                    }
                    vector3.addElement(internetAddress);
                    sMTPAddressSucceededException = new SMTPAddressFailedException(internetAddress, str, serverResponse, this.lastServerResponse);
                    if (messagingException == null) {
                        messagingException = sMTPAddressSucceededException;
                    } else {
                        messagingException.setNextException(sMTPAddressSucceededException);
                    }
                }
                i++;
                z3 = true;
            }
            if (this.debug) {
                this.out.println("DEBUG SMTP: got response code " + serverResponse + ", with response: " + this.lastServerResponse);
            }
            String str3 = this.lastServerResponse;
            int i9 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", 250);
            }
            this.lastServerResponse = str3;
            this.lastReturnCode = i9;
            throw new SMTPAddressFailedException(internetAddress, str, serverResponse, str3);
        }
        dSNNotify = null;
        messagingException = null;
        i = 0;
        z2 = false;
        while (true) {
            addressArr = this.addresses;
            if (i >= addressArr.length) {
                if (sendPartial) {
                    z2 = true;
                }
                if (z2) {
                    Address[] addressArr9 = new Address[vector3.size()];
                    this.invalidAddr = addressArr9;
                    vector3.copyInto(addressArr9);
                    this.validUnsentAddr = new Address[vector.size() + vector2.size()];
                    i5 = 0;
                    i6 = 0;
                    while (i5 < vector.size()) {
                        this.validUnsentAddr[i6] = (Address) vector.elementAt(i5);
                        i5++;
                        i6++;
                    }
                    i7 = 0;
                    while (i7 < vector2.size()) {
                        this.validUnsentAddr[i6] = (Address) vector2.elementAt(i7);
                        i7++;
                        i6++;
                    }
                } else if (this.reportSuccess) {
                    this.sendPartiallyFailed = z3;
                    this.exception = messagingException;
                    Address[] addressArr10 = new Address[vector3.size()];
                    this.invalidAddr = addressArr10;
                    vector3.copyInto(addressArr10);
                    Address[] addressArr11 = new Address[vector2.size()];
                    this.validUnsentAddr = addressArr11;
                    vector2.copyInto(addressArr11);
                    Address[] addressArr12 = new Address[vector.size()];
                    this.validSentAddr = addressArr12;
                    vector.copyInto(addressArr12);
                } else {
                    this.sendPartiallyFailed = z3;
                    this.exception = messagingException;
                    Address[] addressArr13 = new Address[vector3.size()];
                    this.invalidAddr = addressArr13;
                    vector3.copyInto(addressArr13);
                    Address[] addressArr14 = new Address[vector2.size()];
                    this.validUnsentAddr = addressArr14;
                    vector2.copyInto(addressArr14);
                    Address[] addressArr15 = new Address[vector.size()];
                    this.validSentAddr = addressArr15;
                    vector.copyInto(addressArr15);
                }
                if (this.debug) {
                    addressArr2 = this.validSentAddr;
                    if (addressArr2 != null) {
                        this.out.println("DEBUG SMTP: Verified Addresses");
                        while (i4 < this.validSentAddr.length) {
                            this.out.println("DEBUG SMTP:   " + this.validSentAddr[i4]);
                        }
                    }
                    addressArr3 = this.validUnsentAddr;
                    if (addressArr3 != null) {
                        this.out.println("DEBUG SMTP: Valid Unsent Addresses");
                        while (i3 < this.validUnsentAddr.length) {
                            this.out.println("DEBUG SMTP:   " + this.validUnsentAddr[i3]);
                        }
                    }
                    addressArr4 = this.invalidAddr;
                    if (addressArr4 != null) {
                        this.out.println("DEBUG SMTP: Invalid Addresses");
                        while (i2 < this.invalidAddr.length) {
                            this.out.println("DEBUG SMTP:   " + this.invalidAddr[i2]);
                        }
                    }
                }
                if (z2) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: Sending failed because of invalid destination addresses");
                    }
                    notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    String str4 = this.lastServerResponse;
                    int i10 = this.lastReturnCode;
                    if (this.serverSocket != null) {
                        issueCommand("RSET", 250);
                    }
                    throw new SendFailedException("Invalid Addresses", messagingException, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                }
                return;
            }
            internetAddress = (InternetAddress) addressArr[i];
            str = "RCPT TO:" + normalizeAddress(internetAddress.getAddress());
            if (z) {
                str = String.valueOf(str) + " NOTIFY=" + dSNNotify;
            }
            sendCommand(str);
            serverResponse = readServerResponse();
            if (serverResponse != 250) {
                vector.addElement(internetAddress);
                if (this.reportSuccess) {
                    sMTPAddressSucceededException = new SMTPAddressSucceededException(internetAddress, str, serverResponse, this.lastServerResponse);
                    if (messagingException == null) {
                        messagingException = sMTPAddressSucceededException;
                    } else {
                        messagingException.setNextException(sMTPAddressSucceededException);
                    }
                }
            } else {
                vector.addElement(internetAddress);
                if (this.reportSuccess) {
                    sMTPAddressSucceededException = new SMTPAddressSucceededException(internetAddress, str, serverResponse, this.lastServerResponse);
                    if (messagingException == null) {
                        messagingException = sMTPAddressSucceededException;
                    } else {
                        messagingException.setNextException(sMTPAddressSucceededException);
                    }
                }
            }
            i++;
            z3 = true;
        }
        if (this.debug) {
            this.out.println("DEBUG SMTP: got response code " + serverResponse + ", with response: " + this.lastServerResponse);
        }
        String str5 = this.lastServerResponse;
        int i11 = this.lastReturnCode;
        if (this.serverSocket != null) {
            issueCommand("RSET", 250);
        }
        this.lastServerResponse = str5;
        this.lastReturnCode = i11;
        throw new SMTPAddressFailedException(internetAddress, str, serverResponse, str5);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007d  */
    public int readServerResponse() throws MessagingException {
        String line;
        int i;
        StringBuffer stringBuffer = new StringBuffer(100);
        do {
            try {
                line = this.lineInputStream.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    if (string.length() == 0) {
                        string = "[EOF]";
                    }
                    this.lastServerResponse = string;
                    this.lastReturnCode = -1;
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: EOF: " + string);
                    }
                    return -1;
                }
                stringBuffer.append(line);
                stringBuffer.append("\n");
            } catch (IOException e) {
                if (this.debug) {
                    this.out.println("DEBUG SMTP: exception reading response: " + e);
                }
                this.lastServerResponse = BuildConfig.FLAVOR;
                this.lastReturnCode = 0;
                throw new MessagingException("Exception reading response", e);
            }
        } while (isNotLastLine(line));
        String string2 = stringBuffer.toString();
        if (string2 == null || string2.length() < 3) {
            i = -1;
        } else {
            try {
                try {
                    try {
                        i = Integer.parseInt(string2.substring(0, 3));
                    } catch (NumberFormatException unused) {
                        close();
                        i = -1;
                        if (i == -1) {
                            this.out.println("DEBUG SMTP: bad server response: " + string2);
                        }
                        this.lastServerResponse = string2;
                        this.lastReturnCode = i;
                        return i;
                    } catch (StringIndexOutOfBoundsException unused2) {
                        close();
                        i = -1;
                        if (i == -1) {
                            this.out.println("DEBUG SMTP: bad server response: " + string2);
                        }
                        this.lastServerResponse = string2;
                        this.lastReturnCode = i;
                        return i;
                    }
                } catch (MessagingException e2) {
                    if (this.debug) {
                        e2.printStackTrace(this.out);
                    }
                    i = -1;
                }
            } catch (MessagingException e3) {
                if (this.debug) {
                    e3.printStackTrace(this.out);
                }
                i = -1;
            }
        }
        if (i == -1 && this.debug) {
            this.out.println("DEBUG SMTP: bad server response: " + string2);
        }
        this.lastServerResponse = string2;
        this.lastReturnCode = i;
        return i;
    }

    public void sendCommand(String str) throws MessagingException {
        sendCommand(ASCIIUtility.getBytes(str));
    }

    @Override // javax.mail.Transport
    public synchronized void sendMessage(Message message, Address[] addressArr) throws MessagingException {
        checkConnected();
        if (!(message instanceof MimeMessage)) {
            if (this.debug) {
                this.out.println("DEBUG SMTP: Can only send RFC822 msgs");
            }
            throw new MessagingException("SMTP can only send RFC822 messages");
        }
        for (int i = 0; i < addressArr.length; i++) {
            if (!(addressArr[i] instanceof InternetAddress)) {
                throw new MessagingException(addressArr[i] + " is not an InternetAddress");
            }
        }
        this.message = (MimeMessage) message;
        this.addresses = addressArr;
        this.validUnsentAddr = addressArr;
        expandGroups();
        boolean allow8bitMIME = message instanceof SMTPMessage ? ((SMTPMessage) message).getAllow8bitMIME() : false;
        if (!allow8bitMIME) {
            String property = this.session.getProperty("mail." + this.name + ".allow8bitmime");
            allow8bitMIME = property != null && property.equalsIgnoreCase("true");
        }
        if (this.debug) {
            this.out.println("DEBUG SMTP: use8bit " + allow8bitMIME);
        }
        if (allow8bitMIME && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
            try {
                this.message.saveChanges();
            } catch (MessagingException unused) {
            }
        }
        try {
            try {
                mailFrom();
                rcptTo();
                this.message.writeTo(data(), ignoreList);
                finishData();
                if (this.sendPartiallyFailed) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: Sending partially failed because of invalid destination addresses");
                    }
                    notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                }
                notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = false;
            } catch (IOException e) {
                if (this.debug) {
                    e.printStackTrace(this.out);
                }
                try {
                    closeConnection();
                } catch (MessagingException unused2) {
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw new MessagingException("IOException while sending message", e);
            } catch (MessagingException e2) {
                if (this.debug) {
                    e2.printStackTrace(this.out);
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw e2;
            }
        } catch (Throwable th) {
            this.invalidAddr = null;
            this.validUnsentAddr = null;
            this.validSentAddr = null;
            this.addresses = null;
            this.message = null;
            this.exception = null;
            this.sendPartiallyFailed = false;
            throw th;
        }
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setReportSuccess(boolean z) {
        this.reportSuccess = z;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z) {
        this.useStartTLS = z;
    }

    public synchronized void setUseRset(boolean z) {
        this.useRset = z;
    }

    public synchronized int simpleCommand(String str) throws MessagingException {
        sendCommand(str);
        return readServerResponse();
    }

    public void startTLS() throws MessagingException {
        issueCommand("STARTTLS", TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
        try {
            this.serverSocket = SocketFetcher.startTLS(this.serverSocket, this.session.getProperties(), "mail." + this.name);
            initStreams();
        } catch (IOException e) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e);
        }
    }

    public boolean supportsAuthentication(String str) {
        String str2;
        Hashtable hashtable = this.extMap;
        if (hashtable == null || (str2 = (String) hashtable.get("AUTH")) == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsExtension(String str) {
        Hashtable hashtable = this.extMap;
        return (hashtable == null || hashtable.get(str.toUpperCase(Locale.ENGLISH)) == null) ? false : true;
    }

    public SMTPTransport(Session session, URLName uRLName, String str, int i, boolean z) {
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        boolean z2 = false;
        this.isSSL = false;
        this.sendPartiallyFailed = false;
        this.quitWait = false;
        this.saslRealm = "UNKNOWN";
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        this.defaultPort = i;
        this.isSSL = z;
        this.out = session.getDebugOut();
        String property = session.getProperty("mail." + str + ".quitwait");
        this.quitWait = property == null || property.equalsIgnoreCase("true");
        String property2 = session.getProperty("mail." + str + ".reportsuccess");
        this.reportSuccess = property2 != null && property2.equalsIgnoreCase("true");
        String property3 = session.getProperty("mail." + str + ".starttls.enable");
        this.useStartTLS = property3 != null && property3.equalsIgnoreCase("true");
        String property4 = session.getProperty("mail." + str + ".userset");
        if (property4 != null && property4.equalsIgnoreCase("true")) {
            z2 = true;
        }
        this.useRset = z2;
    }

    private void sendCommand(byte[] bArr) throws MessagingException {
        try {
            this.serverOutput.write(bArr);
            this.serverOutput.write(CRLF);
            this.serverOutput.flush();
        } catch (IOException e) {
            throw new MessagingException("Can't send command to SMTP host", e);
        }
    }

    public int simpleCommand(byte[] bArr) throws MessagingException {
        sendCommand(bArr);
        return readServerResponse();
    }

    private void openServer() throws MessagingException {
        try {
            int port = this.serverSocket.getPort();
            String hostName = this.serverSocket.getInetAddress().getHostName();
            if (this.debug) {
                this.out.println("DEBUG SMTP: starting protocol to host \"" + hostName + "\", port " + port);
            }
            initStreams();
            int serverResponse = readServerResponse();
            if (serverResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    this.out.println("DEBUG SMTP: got bad greeting from host \"" + hostName + "\", port: " + port + ", response: " + serverResponse + "\n");
                }
                throw new MessagingException("Got bad greeting from SMTP host: " + hostName + ", port: " + port + ", response: " + serverResponse);
            }
            if (this.debug) {
                this.out.println("DEBUG SMTP: protocol started to host \"" + hostName + "\", port: " + port + "\n");
            }
        } catch (IOException e) {
            throw new MessagingException("Could not start protocol to SMTP host: UNKNOWN, port: -1", e);
        }
    }
}
