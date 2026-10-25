package com.sun.mail.imap;

import com.mysql.jdbc.StatementImpl;
import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;

/* JADX INFO: loaded from: classes.dex */
public class IMAPInputStream extends InputStream {
    private static final int slop = 64;
    private int blksize;
    private byte[] buf;
    private int bufcount;
    private int bufpos;
    private int max;
    private IMAPMessage msg;
    private boolean peek;
    private int pos = 0;
    private ByteArray readbuf;
    private String section;

    public IMAPInputStream(IMAPMessage iMAPMessage, String str, int i, boolean z) {
        this.msg = iMAPMessage;
        this.section = str;
        this.max = i;
        this.peek = z;
        this.blksize = iMAPMessage.getFetchBlockSize();
    }

    private void checkSeen() {
        if (this.peek) {
            return;
        }
        try {
            Folder folder = this.msg.getFolder();
            if (folder == null || folder.getMode() == 1) {
                return;
            }
            IMAPMessage iMAPMessage = this.msg;
            Flags.Flag flag = Flags.Flag.SEEN;
            if (iMAPMessage.isSet(flag)) {
                return;
            }
            this.msg.setFlag(flag, true);
        } catch (MessagingException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    private void fill() throws IOException {
        int i;
        ByteArray byteArray;
        int i2;
        int i3 = this.max;
        if (i3 != -1 && (i2 = this.pos) >= i3) {
            if (i2 == 0) {
                checkSeen();
            }
            this.readbuf = null;
            return;
        }
        if (this.readbuf == null) {
            this.readbuf = new ByteArray(this.blksize + 64);
        }
        synchronized (this.msg.getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = this.msg.getProtocol();
                    if (this.msg.isExpunged()) {
                        throw new MessageRemovedIOException("No content for expunged message");
                    }
                    int sequenceNumber = this.msg.getSequenceNumber();
                    int i4 = this.blksize;
                    int i5 = this.max;
                    if (i5 != -1) {
                        int i6 = this.pos;
                        if (i6 + i4 > i5) {
                            i = i5 - i6;
                        } else {
                            i = i4;
                        }
                    } else {
                        i = i4;
                    }
                    BODY bodyPeekBody = this.peek ? protocol.peekBody(sequenceNumber, this.section, this.pos, i, this.readbuf) : protocol.fetchBody(sequenceNumber, this.section, this.pos, i, this.readbuf);
                    if (bodyPeekBody == null || (byteArray = bodyPeekBody.getByteArray()) == null) {
                        forceCheckExpunged();
                        throw new IOException("No content");
                    }
                } catch (FolderClosedException e) {
                    throw new FolderClosedIOException(e.getFolder(), e.getMessage());
                }
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new IOException(e2.getMessage());
            }
        }
        if (this.pos == 0) {
            checkSeen();
        }
        this.buf = byteArray.getBytes();
        this.bufpos = byteArray.getStart();
        int count = byteArray.getCount();
        this.bufcount = this.bufpos + count;
        this.pos += count;
    }

    private void forceCheckExpunged() throws MessageRemovedIOException, FolderClosedIOException {
        synchronized (this.msg.getMessageCacheLock()) {
            try {
                try {
                    this.msg.getProtocol().noop();
                } catch (ProtocolException unused) {
                } catch (FolderClosedException e) {
                    throw new FolderClosedIOException(e.getFolder(), e.getMessage());
                }
            } catch (ConnectionException e2) {
                throw new FolderClosedIOException(this.msg.getFolder(), e2.getMessage());
            }
        }
        if (this.msg.isExpunged()) {
            throw new MessageRemovedIOException();
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return this.bufcount - this.bufpos;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.bufpos >= this.bufcount) {
            fill();
            if (this.bufpos >= this.bufcount) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i = this.bufpos;
        this.bufpos = i + 1;
        return bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.bufcount - this.bufpos;
        if (i3 <= 0) {
            fill();
            i3 = this.bufcount - this.bufpos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.bufpos, bArr, i, i2);
        this.bufpos += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
