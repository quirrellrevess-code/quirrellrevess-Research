package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.SharedInputStream;

/* JADX INFO: loaded from: classes.dex */
public class POP3Message extends MimeMessage {
    public static final String UNKNOWN = "UNKNOWN";
    private POP3Folder folder;
    private int hdrSize;
    private int msgSize;
    public String uid;

    public POP3Message(Folder folder, int i) throws MessagingException {
        super(folder, i);
        this.hdrSize = -1;
        this.msgSize = -1;
        this.uid = UNKNOWN;
        this.folder = (POP3Folder) folder;
    }

    private void loadHeaders() throws MessagingException {
        InputStream pVar;
        try {
            synchronized (this) {
                if (this.headers != null) {
                    return;
                }
                if (((POP3Store) this.folder.getStore()).disableTop || (pVar = this.folder.getProtocol().top(this.msgnum, 0)) == null) {
                    getContentStream().close();
                } else {
                    this.hdrSize = pVar.available();
                    this.headers = new InternetHeaders(pVar);
                }
            }
        } catch (EOFException e) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error loading POP3 headers", e2);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getAllHeaders();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        int i;
        try {
            synchronized (this) {
                if (this.contentStream == null) {
                    Protocol protocol = this.folder.getProtocol();
                    int i2 = this.msgnum;
                    int i3 = this.msgSize;
                    InputStream inputStreamRetr = protocol.retr(i2, i3 > 0 ? i3 + this.hdrSize : 0);
                    if (inputStreamRetr == 0) {
                        this.expunged = true;
                        throw new MessageRemovedException();
                    }
                    if (this.headers == null || ((POP3Store) this.folder.getStore()).forgetTopHeaders) {
                        this.headers = new InternetHeaders(inputStreamRetr);
                        this.hdrSize = (int) ((SharedInputStream) inputStreamRetr).getPosition();
                    } else {
                        do {
                            i = 0;
                            while (true) {
                                int i4 = inputStreamRetr.read();
                                if (i4 < 0 || i4 == 10) {
                                    break;
                                    break;
                                }
                                if (i4 == 13) {
                                    if (inputStreamRetr.available() <= 0) {
                                        break;
                                    }
                                    inputStreamRetr.mark(1);
                                    if (inputStreamRetr.read() == 10) {
                                        break;
                                    }
                                    inputStreamRetr.reset();
                                    break;
                                }
                                i++;
                            }
                            if (inputStreamRetr.available() == 0) {
                                break;
                            }
                        } while (i != 0);
                        this.hdrSize = (int) ((SharedInputStream) inputStreamRetr).getPosition();
                    }
                    this.contentStream = ((SharedInputStream) inputStreamRetr).newStream(this.hdrSize, -1L);
                }
            }
            return super.getContentStream();
        } catch (EOFException e) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error fetching POP3 content", e2);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        try {
            synchronized (this) {
                int i = this.msgSize;
                if (i >= 0) {
                    return i;
                }
                if (i < 0) {
                    if (this.headers == null) {
                        loadHeaders();
                    }
                    InputStream inputStream = this.contentStream;
                    if (inputStream != null) {
                        this.msgSize = inputStream.available();
                    } else {
                        this.msgSize = this.folder.getProtocol().list(this.msgnum) - this.hdrSize;
                    }
                }
                return this.msgSize;
            }
        } catch (EOFException e) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error getting size", e2);
        }
    }

    public synchronized void invalidate(boolean z) {
        this.content = null;
        this.contentStream = null;
        this.msgSize = -1;
        if (z) {
            this.headers = null;
            this.hdrSize = -1;
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void saveChanges() throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFlags(Flags flags, boolean z) throws MessagingException {
        Flags flags2 = (Flags) this.flags.clone();
        super.setFlags(flags, z);
        if (this.flags.equals(flags2)) {
            return;
        }
        this.folder.notifyMessageChangedListeners(1, this);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public InputStream top(int i) throws MessagingException {
        InputStream pVar;
        try {
            synchronized (this) {
                pVar = this.folder.getProtocol().top(this.msgnum, i);
            }
            return pVar;
        } catch (EOFException e) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error getting size", e2);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getHeader(str, str2);
    }
}
