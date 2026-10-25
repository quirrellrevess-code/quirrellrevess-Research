package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;

/* JADX INFO: loaded from: classes.dex */
public class MimeBodyPart extends BodyPart implements MimePart {
    public static boolean cacheMultipart = true;
    private static boolean decodeFileName = false;
    private static boolean encodeFileName = false;
    private static boolean setContentTypeFileName = true;
    private static boolean setDefaultTextCharset = true;
    private Object cachedContent;
    public byte[] content;
    public InputStream contentStream;

    /* JADX INFO: renamed from: dh */
    public DataHandler f866dh;
    public InternetHeaders headers;

    static {
        try {
            String property = System.getProperty("mail.mime.setdefaulttextcharset");
            boolean z = false;
            setDefaultTextCharset = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.setcontenttypefilename");
            setContentTypeFileName = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.encodefilename");
            encodeFileName = (property3 == null || property3.equalsIgnoreCase("false")) ? false : true;
            String property4 = System.getProperty("mail.mime.decodefilename");
            decodeFileName = (property4 == null || property4.equalsIgnoreCase("false")) ? false : true;
            String property5 = System.getProperty("mail.mime.cachemultipart");
            if (property5 == null || !property5.equalsIgnoreCase("false")) {
                z = true;
            }
            cacheMultipart = z;
        } catch (SecurityException unused) {
        }
    }

    public MimeBodyPart() {
        this.headers = new InternetHeaders();
    }

    public static void invalidateContentHeaders(MimePart mimePart) throws MessagingException {
        mimePart.removeHeader("Content-Type");
        mimePart.removeHeader("Content-Transfer-Encoding");
    }

    public static void setEncoding(MimePart mimePart, String str) throws MessagingException {
        mimePart.setHeader("Content-Transfer-Encoding", str);
    }

    @Override // javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) throws MessagingException {
        this.headers.addHeaderLine(str);
    }

    public void attachFile(File file) throws MessagingException, IOException {
        FileDataSource fileDataSource = new FileDataSource(file);
        setDataHandler(new DataHandler(fileDataSource));
        setFileName(fileDataSource.getName());
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        return this.headers.getAllHeaders();
    }

    @Override // javax.mail.Part
    public Object getContent() throws MessagingException, IOException {
        Object obj = this.cachedContent;
        if (obj != null) {
            return obj;
        }
        try {
            Object content = getDataHandler().getContent();
            if (cacheMultipart && (((content instanceof Multipart) || (content instanceof Message)) && (this.content != null || this.contentStream != null))) {
                this.cachedContent = content;
            }
            return content;
        } catch (FolderClosedIOException e) {
            throw new FolderClosedException(e.getFolder(), e.getMessage());
        } catch (MessageRemovedIOException e2) {
            throw new MessageRemovedException(e2.getMessage());
        }
    }

    public String getContentID() throws MessagingException {
        return getHeader("Content-Id", null);
    }

    @Override // javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        return getContentLanguage(this);
    }

    public String getContentMD5() throws MessagingException {
        return getHeader("Content-MD5", null);
    }

    public InputStream getContentStream() throws MessagingException {
        Closeable closeable = this.contentStream;
        if (closeable != null) {
            return ((SharedInputStream) closeable).newStream(0L, -1L);
        }
        if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    @Override // javax.mail.Part
    public String getContentType() throws MessagingException {
        String header = getHeader("Content-Type", null);
        return header == null ? "text/plain" : header;
    }

    @Override // javax.mail.Part
    public DataHandler getDataHandler() throws MessagingException {
        if (this.f866dh == null) {
            this.f866dh = new DataHandler(new MimePartDataSource(this));
        }
        return this.f866dh;
    }

    @Override // javax.mail.Part
    public String getDescription() throws MessagingException {
        return getDescription(this);
    }

    @Override // javax.mail.Part
    public String getDisposition() throws MessagingException {
        return getDisposition(this);
    }

    public String getEncoding() throws MessagingException {
        return getEncoding(this);
    }

    @Override // javax.mail.Part
    public String getFileName() throws MessagingException {
        return getFileName(this);
    }

    @Override // javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.Part
    public InputStream getInputStream() throws MessagingException, IOException {
        return getDataHandler().getInputStream();
    }

    @Override // javax.mail.Part
    public int getLineCount() throws MessagingException {
        return -1;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public InputStream getRawInputStream() throws MessagingException {
        return getContentStream();
    }

    @Override // javax.mail.Part
    public int getSize() throws MessagingException {
        byte[] bArr = this.content;
        if (bArr != null) {
            return bArr.length;
        }
        InputStream inputStream = this.contentStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            int iAvailable = inputStream.available();
            if (iAvailable > 0) {
                return iAvailable;
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }

    @Override // javax.mail.Part
    public boolean isMimeType(String str) throws MessagingException {
        return isMimeType(this, str);
    }

    @Override // javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        this.headers.removeHeader(str);
    }

    public void saveFile(File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                inputStream = getInputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (bufferedOutputStream == null) {
                    throw th;
                }
                try {
                    bufferedOutputStream.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    @Override // javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        if (obj instanceof Multipart) {
            setContent((Multipart) obj);
        } else {
            setDataHandler(new DataHandler(obj, str));
        }
    }

    public void setContentID(String str) throws MessagingException {
        if (str == null) {
            removeHeader("Content-ID");
        } else {
            setHeader("Content-ID", str);
        }
    }

    @Override // javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) throws MessagingException {
        setHeader("Content-MD5", str);
    }

    @Override // javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        this.f866dh = dataHandler;
        this.cachedContent = null;
        invalidateContentHeaders(this);
    }

    @Override // javax.mail.Part
    public void setDescription(String str) throws MessagingException {
        setDescription(str, null);
    }

    @Override // javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        setDisposition(this, str);
    }

    @Override // javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        setFileName(this, str);
    }

    @Override // javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        this.headers.setHeader(str, str2);
    }

    @Override // javax.mail.Part, javax.mail.internet.MimePart
    public void setText(String str) throws MessagingException {
        setText(str, null);
    }

    public void updateHeaders() throws MessagingException {
        updateHeaders(this);
        if (this.cachedContent != null) {
            this.f866dh = new DataHandler(this.cachedContent, getContentType());
            this.cachedContent = null;
            this.content = null;
            InputStream inputStream = this.contentStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            this.contentStream = null;
        }
    }

    @Override // javax.mail.Part
    public void writeTo(OutputStream outputStream) throws MessagingException, IOException {
        writeTo(this, outputStream, null);
    }

    public static String[] getContentLanguage(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Language", null);
        if (header == null) {
            return null;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(header, HeaderTokenizer.MIME);
        Vector vector = new Vector();
        while (true) {
            HeaderTokenizer.Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            }
            if (type == -1) {
                vector.addElement(next.getValue());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public static String getDescription(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Description", null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException unused) {
            return header;
        }
    }

    public static String getDisposition(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Disposition", null);
        if (header == null) {
            return null;
        }
        return new ContentDisposition(header).getDisposition();
    }

    public static String getEncoding(MimePart mimePart) throws MessagingException {
        HeaderTokenizer.Token next;
        int type;
        String header = mimePart.getHeader("Content-Transfer-Encoding", null);
        if (header == null) {
            return null;
        }
        String strTrim = header.trim();
        if (strTrim.equalsIgnoreCase("7bit") || strTrim.equalsIgnoreCase("8bit") || strTrim.equalsIgnoreCase("quoted-printable") || strTrim.equalsIgnoreCase("binary") || strTrim.equalsIgnoreCase("base64")) {
            return strTrim;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(strTrim, HeaderTokenizer.MIME);
        do {
            next = headerTokenizer.next();
            type = next.getType();
            if (type == -4) {
                return strTrim;
            }
        } while (type != -1);
        return next.getValue();
    }

    public static String getFileName(MimePart mimePart) throws MessagingException {
        String header;
        String header2 = mimePart.getHeader("Content-Disposition", null);
        String parameter = header2 != null ? new ContentDisposition(header2).getParameter(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME) : null;
        if (parameter == null && (header = mimePart.getHeader("Content-Type", null)) != null) {
            try {
                parameter = new ContentType(header).getParameter("name");
            } catch (ParseException unused) {
            }
        }
        if (!decodeFileName || parameter == null) {
            return parameter;
        }
        try {
            return MimeUtility.decodeText(parameter);
        } catch (UnsupportedEncodingException e) {
            throw new MessagingException("Can't decode filename", e);
        }
    }

    public static boolean isMimeType(MimePart mimePart, String str) throws MessagingException {
        try {
            return new ContentType(mimePart.getContentType()).match(str);
        } catch (ParseException unused) {
            return mimePart.getContentType().equalsIgnoreCase(str);
        }
    }

    public static void setContentLanguage(MimePart mimePart, String[] strArr) throws MessagingException {
        StringBuffer stringBuffer = new StringBuffer(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(strArr[i]);
        }
        mimePart.setHeader("Content-Language", stringBuffer.toString());
    }

    public static void setDisposition(MimePart mimePart, String str) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Disposition");
            return;
        }
        String header = mimePart.getHeader("Content-Disposition", null);
        if (header != null) {
            ContentDisposition contentDisposition = new ContentDisposition(header);
            contentDisposition.setDisposition(str);
            str = contentDisposition.toString();
        }
        mimePart.setHeader("Content-Disposition", str);
    }

    public static void setFileName(MimePart mimePart, String str) throws MessagingException {
        String header;
        if (encodeFileName && str != null) {
            try {
                str = MimeUtility.encodeText(str);
            } catch (UnsupportedEncodingException e) {
                throw new MessagingException("Can't encode filename", e);
            }
        }
        String header2 = mimePart.getHeader("Content-Disposition", null);
        if (header2 == null) {
            header2 = Part.ATTACHMENT;
        }
        ContentDisposition contentDisposition = new ContentDisposition(header2);
        contentDisposition.setParameter(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, str);
        mimePart.setHeader("Content-Disposition", contentDisposition.toString());
        if (!setContentTypeFileName || (header = mimePart.getHeader("Content-Type", null)) == null) {
            return;
        }
        try {
            ContentType contentType = new ContentType(header);
            contentType.setParameter("name", str);
            mimePart.setHeader("Content-Type", contentType.toString());
        } catch (ParseException unused) {
        }
    }

    public static void writeTo(MimePart mimePart, OutputStream outputStream, String[] strArr) throws MessagingException, IOException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration nonMatchingHeaderLines = mimePart.getNonMatchingHeaderLines(strArr);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        OutputStream outputStreamEncode = MimeUtility.encode(outputStream, mimePart.getEncoding());
        mimePart.getDataHandler().writeTo(outputStreamEncode);
        outputStreamEncode.flush();
    }

    @Override // javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        return this.headers.getHeader(str, str2);
    }

    public void setDescription(String str, String str2) throws MessagingException {
        setDescription(this, str, str2);
    }

    @Override // javax.mail.internet.MimePart
    public void setText(String str, String str2) throws MessagingException {
        setText(this, str, str2, "plain");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MimeBodyPart(InputStream inputStream) throws MessagingException {
        boolean z = inputStream instanceof ByteArrayInputStream;
        InputStream bufferedInputStream = inputStream;
        if (!z && !(inputStream instanceof BufferedInputStream) && !(inputStream instanceof SharedInputStream)) {
            bufferedInputStream = inputStream;
            bufferedInputStream = inputStream;
            bufferedInputStream = new BufferedInputStream(inputStream);
        }
        bufferedInputStream = inputStream;
        bufferedInputStream = inputStream;
        bufferedInputStream = inputStream;
        this.headers = new InternetHeaders(bufferedInputStream);
        if (bufferedInputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) bufferedInputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1L);
        } else {
            try {
                this.content = ASCIIUtility.getBytes(bufferedInputStream);
            } catch (IOException e) {
                throw new MessagingException("Error reading input stream", e);
            }
        }
    }

    public static void setDescription(MimePart mimePart, String str, String str2) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Description");
            return;
        }
        try {
            mimePart.setHeader("Content-Description", MimeUtility.fold(21, MimeUtility.encodeText(str, str2, null)));
        } catch (UnsupportedEncodingException e) {
            throw new MessagingException("Encoding error", e);
        }
    }

    @Override // javax.mail.internet.MimePart
    public void setText(String str, String str2, String str3) throws MessagingException {
        setText(this, str, str2, str3);
    }

    public static void setText(MimePart mimePart, String str, String str2, String str3) throws MessagingException {
        if (str2 == null) {
            str2 = MimeUtility.checkAscii(str) != 1 ? MimeUtility.getDefaultMIMECharset() : "us-ascii";
        }
        mimePart.setContent(str, "text/" + str3 + "; charset=" + MimeUtility.quote(str2, HeaderTokenizer.MIME));
    }

    public void attachFile(String str) throws MessagingException, IOException {
        attachFile(new File(str));
    }

    @Override // javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        setDataHandler(new DataHandler(multipart, multipart.getContentType()));
        multipart.setParent(this);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008b A[Catch: IOException -> 0x00ef, TryCatch #0 {IOException -> 0x00ef, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:33:0x008b, B:35:0x0093, B:37:0x009c, B:39:0x00a0, B:41:0x00a8, B:43:0x00ae, B:45:0x00b4, B:49:0x00c3, B:48:0x00bf, B:51:0x00cc, B:53:0x00d5, B:55:0x00e2, B:56:0x00eb, B:27:0x0057, B:28:0x007f, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0080), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0093 A[Catch: IOException -> 0x00ef, TryCatch #0 {IOException -> 0x00ef, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:33:0x008b, B:35:0x0093, B:37:0x009c, B:39:0x00a0, B:41:0x00a8, B:43:0x00ae, B:45:0x00b4, B:49:0x00c3, B:48:0x00bf, B:51:0x00cc, B:53:0x00d5, B:55:0x00e2, B:56:0x00eb, B:27:0x0057, B:28:0x007f, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0080), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf A[Catch: IOException -> 0x00ef, TryCatch #0 {IOException -> 0x00ef, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:33:0x008b, B:35:0x0093, B:37:0x009c, B:39:0x00a0, B:41:0x00a8, B:43:0x00ae, B:45:0x00b4, B:49:0x00c3, B:48:0x00bf, B:51:0x00cc, B:53:0x00d5, B:55:0x00e2, B:56:0x00eb, B:27:0x0057, B:28:0x007f, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0080), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00cc A[Catch: IOException -> 0x00ef, TryCatch #0 {IOException -> 0x00ef, blocks: (B:5:0x000b, B:9:0x001a, B:11:0x0027, B:13:0x002b, B:24:0x004d, B:26:0x0051, B:33:0x008b, B:35:0x0093, B:37:0x009c, B:39:0x00a0, B:41:0x00a8, B:43:0x00ae, B:45:0x00b4, B:49:0x00c3, B:48:0x00bf, B:51:0x00cc, B:53:0x00d5, B:55:0x00e2, B:56:0x00eb, B:27:0x0057, B:28:0x007f, B:16:0x0033, B:17:0x0038, B:19:0x003c, B:22:0x0044, B:23:0x0049, B:29:0x0080), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    public static void updateHeaders(MimePart mimePart) throws MessagingException {
        String header;
        String parameter;
        String encoding;
        String defaultMIMECharset;
        Object content;
        DataHandler dataHandler = mimePart.getDataHandler();
        if (dataHandler == null) {
            return;
        }
        try {
            String contentType = dataHandler.getContentType();
            boolean z = false;
            boolean z2 = mimePart.getHeader("Content-Type") == null;
            ContentType contentType2 = new ContentType(contentType);
            if (contentType2.match("multipart/*")) {
                if (mimePart instanceof MimeBodyPart) {
                    content = ((MimeBodyPart) mimePart).cachedContent;
                    if (content == null) {
                        content = dataHandler.getContent();
                    }
                } else if (!(mimePart instanceof MimeMessage) || (content = ((MimeMessage) mimePart).cachedContent) == null) {
                    content = dataHandler.getContent();
                }
                if (content instanceof MimeMultipart) {
                    ((MimeMultipart) content).updateHeaders();
                } else {
                    throw new MessagingException("MIME part of type \"" + contentType + "\" contains object of type " + content.getClass().getName() + " instead of MimeMultipart");
                }
            } else {
                if (contentType2.match("message/rfc822")) {
                }
                if (!z) {
                    if (mimePart.getHeader("Content-Transfer-Encoding") == null) {
                        setEncoding(mimePart, MimeUtility.getEncoding(dataHandler));
                    }
                    if (z2 && setDefaultTextCharset && contentType2.match("text/*") && contentType2.getParameter("charset") == null) {
                        encoding = mimePart.getEncoding();
                        if (encoding == null && encoding.equalsIgnoreCase("7bit")) {
                            defaultMIMECharset = "us-ascii";
                        } else {
                            defaultMIMECharset = MimeUtility.getDefaultMIMECharset();
                        }
                        contentType2.setParameter("charset", defaultMIMECharset);
                        contentType = contentType2.toString();
                    }
                }
                if (z2) {
                    header = mimePart.getHeader("Content-Disposition", null);
                    if (header != null && (parameter = new ContentDisposition(header).getParameter(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME)) != null) {
                        contentType2.setParameter("name", parameter);
                        contentType = contentType2.toString();
                    }
                    mimePart.setHeader("Content-Type", contentType);
                }
            }
            z = true;
            if (!z) {
                if (mimePart.getHeader("Content-Transfer-Encoding") == null) {
                    setEncoding(mimePart, MimeUtility.getEncoding(dataHandler));
                }
                if (z2) {
                    encoding = mimePart.getEncoding();
                    if (encoding == null) {
                        defaultMIMECharset = MimeUtility.getDefaultMIMECharset();
                    } else {
                        defaultMIMECharset = MimeUtility.getDefaultMIMECharset();
                    }
                    contentType2.setParameter("charset", defaultMIMECharset);
                    contentType = contentType2.toString();
                }
            }
            if (z2) {
                header = mimePart.getHeader("Content-Disposition", null);
                if (header != null) {
                    contentType2.setParameter("name", parameter);
                    contentType = contentType2.toString();
                }
                mimePart.setHeader("Content-Type", contentType);
            }
        } catch (IOException e) {
            throw new MessagingException("IOException updating headers", e);
        }
    }

    public void saveFile(String str) throws Throwable {
        saveFile(new File(str));
    }

    public MimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        this.headers = internetHeaders;
        this.content = bArr;
    }
}
