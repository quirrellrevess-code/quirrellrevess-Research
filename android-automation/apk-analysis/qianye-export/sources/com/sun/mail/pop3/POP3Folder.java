package com.sun.mail.pop3;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.util.LineInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes.dex */
public class POP3Folder extends Folder {
    private boolean doneUidl;
    private boolean exists;
    private Vector message_cache;
    private String name;
    private boolean opened;
    private Protocol port;
    private int size;
    private int total;

    public POP3Folder(POP3Store pOP3Store, String str) {
        super(pOP3Store);
        this.exists = false;
        this.opened = false;
        this.doneUidl = false;
        this.name = str;
        if (str.equalsIgnoreCase("INBOX")) {
            this.exists = true;
        }
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    public void checkClosed() throws IllegalStateException {
        if (this.opened) {
            throw new IllegalStateException("Folder is Open");
        }
    }

    public void checkOpen() throws IllegalStateException {
        if (!this.opened) {
            throw new IllegalStateException("Folder is not Open");
        }
    }

    public void checkReadable() throws IllegalStateException {
        int i;
        if (!this.opened || ((i = this.mode) != 1 && i != 2)) {
            throw new IllegalStateException("Folder is not Readable");
        }
    }

    public void checkWritable() throws IllegalStateException {
        if (!this.opened || this.mode != 2) {
            throw new IllegalStateException("Folder is not Writable");
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z) throws MessagingException {
        checkOpen();
        try {
            try {
                if (((POP3Store) this.store).rsetBeforeQuit) {
                    this.port.rset();
                }
                if (z && this.mode == 2) {
                    for (int i = 0; i < this.message_cache.size(); i++) {
                        POP3Message pOP3Message = (POP3Message) this.message_cache.elementAt(i);
                        if (pOP3Message != null && pOP3Message.isSet(Flags.Flag.DELETED)) {
                            try {
                                this.port.dele(i + 1);
                            } catch (IOException e) {
                                throw new MessagingException("Exception deleting messages during close", e);
                            }
                        }
                    }
                }
                this.port.quit();
                this.port = null;
                ((POP3Store) this.store).closePort(this);
                this.message_cache = null;
                this.opened = false;
            } catch (IOException unused) {
                this.port = null;
                ((POP3Store) this.store).closePort(this);
                this.message_cache = null;
                this.opened = false;
            }
            notifyConnectionListeners(3);
        } catch (Throwable th) {
            this.port = null;
            ((POP3Store) this.store).closePort(this);
            this.message_cache = null;
            this.opened = false;
            notifyConnectionListeners(3);
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public boolean create(int i) throws MessagingException {
        return false;
    }

    public POP3Message createMessage(Folder folder, int i) throws MessagingException {
        POP3Message pOP3Message;
        Constructor constructor = ((POP3Store) this.store).messageConstructor;
        if (constructor != null) {
            try {
                pOP3Message = (POP3Message) constructor.newInstance(this, new Integer(i));
            } catch (Exception unused) {
                pOP3Message = null;
            }
        } else {
            pOP3Message = null;
        }
        return pOP3Message == null ? new POP3Message(this, i) : pOP3Message;
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return this.exists;
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        checkReadable();
        if (!this.doneUidl && fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            int size = this.message_cache.size();
            String[] strArr = new String[size];
            try {
                try {
                    if (!this.port.uidl(strArr)) {
                        return;
                    }
                    for (int i = 0; i < size; i++) {
                        if (strArr[i] != null) {
                            ((POP3Message) getMessage(i + 1)).uid = strArr[i];
                        }
                    }
                    this.doneUidl = true;
                } catch (IOException e) {
                    throw new MessagingException("error getting UIDL", e);
                }
            } catch (EOFException e2) {
                close(false);
                throw new FolderClosedException(this, e2.toString());
            }
        }
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            for (Message message : messageArr) {
                try {
                    POP3Message pOP3Message = (POP3Message) message;
                    pOP3Message.getHeader(BuildConfig.FLAVOR);
                    pOP3Message.getSize();
                } catch (MessageRemovedException unused) {
                }
            }
        }
    }

    @Override // javax.mail.Folder
    public void finalize() throws Throwable {
        super.finalize();
        close(false);
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.name;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i) throws MessagingException {
        POP3Message pOP3MessageCreateMessage;
        checkOpen();
        int i2 = i - 1;
        pOP3MessageCreateMessage = (POP3Message) this.message_cache.elementAt(i2);
        if (pOP3MessageCreateMessage == null) {
            pOP3MessageCreateMessage = createMessage(this, i);
            this.message_cache.setElementAt(pOP3MessageCreateMessage, i2);
        }
        return pOP3MessageCreateMessage;
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        if (!this.opened) {
            return -1;
        }
        checkReadable();
        return this.total;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return this.name;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return new DefaultFolder((POP3Store) this.store);
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    public Protocol getProtocol() throws MessagingException {
        checkOpen();
        return this.port;
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return (char) 0;
    }

    public synchronized int getSize() throws MessagingException {
        checkOpen();
        return this.size;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0021 A[EXC_TOP_SPLITTER, PHI: r2
  0x0021: PHI (r2v4 java.io.InputStream) = (r2v2 java.io.InputStream), (r2v6 java.io.InputStream) binds: [B:40:0x0063, B:12:0x001f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public synchronized int[] getSizes() throws MessagingException {
        int[] iArr;
        InputStream list;
        checkOpen();
        iArr = new int[this.total];
        LineInputStream lineInputStream = null;
        try {
            list = this.port.list();
            try {
                LineInputStream lineInputStream2 = new LineInputStream(list);
                while (true) {
                    try {
                        try {
                            String line = lineInputStream2.readLine();
                            if (line == null) {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            } else {
                                try {
                                    StringTokenizer stringTokenizer = new StringTokenizer(line);
                                    int i = Integer.parseInt(stringTokenizer.nextToken());
                                    int i2 = Integer.parseInt(stringTokenizer.nextToken());
                                    if (i > 0 && i <= this.total) {
                                        iArr[i - 1] = i2;
                                    }
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (IOException unused3) {
                            lineInputStream = lineInputStream2;
                            if (lineInputStream != null) {
                                try {
                                    lineInputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (list != null) {
                                try {
                                    list.close();
                                } catch (IOException unused5) {
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        lineInputStream = lineInputStream2;
                        if (lineInputStream != null) {
                            try {
                                lineInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (list == null) {
                            throw th;
                        }
                        try {
                            list.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                }
                lineInputStream2.close();
                if (list != null) {
                    list.close();
                }
            } catch (IOException unused8) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused9) {
            list = null;
        } catch (Throwable th3) {
            th = th3;
            list = null;
        }
        return iArr;
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 1;
    }

    public synchronized String getUID(Message message) throws MessagingException {
        POP3Message pOP3Message;
        checkOpen();
        pOP3Message = (POP3Message) message;
        try {
            try {
                if (pOP3Message.uid == POP3Message.UNKNOWN) {
                    pOP3Message.uid = this.port.uidl(pOP3Message.getMessageNumber());
                }
            } catch (IOException e) {
                throw new MessagingException("error getting UIDL", e);
            }
        } catch (EOFException e2) {
            close(false);
            throw new FolderClosedException(this, e2.toString());
        }
        return pOP3Message.uid;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        if (!this.opened) {
            return false;
        }
        if (this.store.isConnected()) {
            return true;
        }
        try {
            close(false);
        } catch (MessagingException unused) {
        }
        return false;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    public synchronized InputStream listCommand() throws MessagingException, IOException {
        checkOpen();
        return this.port.list();
    }

    @Override // javax.mail.Folder
    public void notifyMessageChangedListeners(int i, Message message) {
        super.notifyMessageChangedListeners(i, message);
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i) throws MessagingException {
        POP3Store pOP3Store;
        checkClosed();
        if (!this.exists) {
            throw new FolderNotFoundException(this, "folder is not INBOX");
        }
        try {
            Protocol port = ((POP3Store) this.store).getPort(this);
            this.port = port;
            Status statusStat = port.stat();
            this.total = statusStat.total;
            this.size = statusStat.size;
            this.mode = i;
            this.opened = true;
            Vector vector = new Vector(this.total);
            this.message_cache = vector;
            vector.setSize(this.total);
            this.doneUidl = false;
            notifyConnectionListeners(1);
        } catch (IOException e) {
            try {
                Protocol protocol = this.port;
                if (protocol != null) {
                    protocol.quit();
                }
                this.port = null;
                pOP3Store = (POP3Store) this.store;
            } catch (IOException unused) {
                this.port = null;
                pOP3Store = (POP3Store) this.store;
            } catch (Throwable th) {
                this.port = null;
                ((POP3Store) this.store).closePort(this);
                throw th;
            }
            pOP3Store.closePort(this);
            throw new MessagingException("Open failed", e);
        }
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }
}
