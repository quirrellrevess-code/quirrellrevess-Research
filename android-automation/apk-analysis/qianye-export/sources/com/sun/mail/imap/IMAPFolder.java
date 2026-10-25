package com.sun.mail.imap;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPResponse;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.MailboxInfo;
import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.Status;
import com.sun.mail.imap.protocol.UID;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.ReadOnlyFolderException;
import javax.mail.StoreClosedException;
import javax.mail.UIDFolder;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* JADX INFO: loaded from: classes.dex */
public class IMAPFolder extends Folder implements UIDFolder, ResponseHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ABORTING = 2;
    private static final int IDLE = 1;
    private static final int RUNNING = 0;
    public static final char UNKNOWN_SEPARATOR = 65535;
    public String[] attributes;
    public Flags availableFlags;
    private Status cachedStatus;
    private long cachedStatusTime;
    private boolean connectionPoolDebug;
    private boolean debug;
    private boolean doExpungeNotification;
    public boolean exists;
    public String fullName;
    private int idleState;
    public boolean isNamespace;
    public Vector messageCache;
    public Object messageCacheLock;
    public String name;
    private boolean opened;
    private PrintStream out;
    public Flags permanentFlags;
    public IMAPProtocol protocol;
    private int realTotal;
    private boolean reallyClosed;
    private int recent;
    public char separator;
    private int total;
    public int type;
    public Hashtable uidTable;
    private long uidnext;
    private long uidvalidity;

    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem HEADERS = new FetchProfileItem("HEADERS");
        public static final FetchProfileItem SIZE = new FetchProfileItem("SIZE");

        public FetchProfileItem(String str) {
            super(str);
        }
    }

    public interface ProtocolCommand {
        Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException;
    }

    public IMAPFolder(String str, char c, IMAPStore iMAPStore) {
        int iIndexOf;
        super(iMAPStore);
        this.exists = false;
        this.isNamespace = false;
        this.opened = false;
        this.reallyClosed = true;
        this.idleState = 0;
        this.total = -1;
        this.recent = -1;
        this.realTotal = -1;
        this.uidvalidity = -1L;
        this.uidnext = -1L;
        this.doExpungeNotification = true;
        this.cachedStatus = null;
        this.cachedStatusTime = 0L;
        this.debug = false;
        Objects.requireNonNull(str, "Folder name is null");
        this.fullName = str;
        this.separator = c;
        this.messageCacheLock = new Object();
        this.debug = iMAPStore.getSession().getDebug();
        this.connectionPoolDebug = iMAPStore.getConnectionPoolDebug();
        PrintStream debugOut = iMAPStore.getSession().getDebugOut();
        this.out = debugOut;
        if (debugOut == null) {
            this.out = System.out;
        }
        this.isNamespace = false;
        if (c == 65535 || c == 0 || (iIndexOf = this.fullName.indexOf(c)) <= 0 || iIndexOf != this.fullName.length() - 1) {
            return;
        }
        this.fullName = this.fullName.substring(0, iIndexOf);
        this.isNamespace = true;
    }

    private void checkClosed() {
        if (this.opened) {
            throw new IllegalStateException("This operation is not allowed on an open folder");
        }
    }

    private void checkExists() throws MessagingException {
        if (this.exists || exists()) {
            return;
        }
        throw new FolderNotFoundException(this, String.valueOf(this.fullName) + " not found");
    }

    private void checkFlags(Flags flags) throws MessagingException {
        if (this.mode == 2) {
            return;
        }
        throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.fullName);
    }

    private void checkOpened() throws FolderClosedException {
        if (this.opened) {
            return;
        }
        if (!this.reallyClosed) {
            throw new FolderClosedException(this, "Lost folder connection to server");
        }
        throw new IllegalStateException("This operation is not allowed on a closed folder");
    }

    private void checkRange(int i) throws MessagingException {
        if (i < 1) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= this.total) {
            return;
        }
        synchronized (this.messageCacheLock) {
            try {
                keepConnectionAlive(false);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (i > this.total) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void cleanup(boolean z) {
        releaseProtocol(z);
        this.protocol = null;
        this.messageCache = null;
        this.uidTable = null;
        this.exists = false;
        this.attributes = null;
        this.opened = false;
        this.idleState = 0;
        notifyConnectionListeners(3);
    }

    private synchronized Folder[] doList(final String str, final boolean z) throws MessagingException {
        checkExists();
        int i = 0;
        if (!isDirectory()) {
            return new Folder[0];
        }
        final char separator = getSeparator();
        ListInfo[] listInfoArr = (ListInfo[]) doCommandIgnoreFailure(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.2
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                if (z) {
                    return iMAPProtocol.lsub(BuildConfig.FLAVOR, String.valueOf(IMAPFolder.this.fullName) + separator + str);
                }
                return iMAPProtocol.list(BuildConfig.FLAVOR, String.valueOf(IMAPFolder.this.fullName) + separator + str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        if (listInfoArr.length > 0) {
            if (listInfoArr[0].name.equals(String.valueOf(this.fullName) + separator)) {
                i = 1;
            }
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[listInfoArr.length - i];
        for (int i2 = i; i2 < listInfoArr.length; i2++) {
            iMAPFolderArr[i2 - i] = new IMAPFolder(listInfoArr[i2], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    private int findName(ListInfo[] listInfoArr, String str) {
        int i = 0;
        while (i < listInfoArr.length && !listInfoArr[i].name.equals(str)) {
            i++;
        }
        if (i >= listInfoArr.length) {
            return 0;
        }
        return i;
    }

    private IMAPProtocol getProtocol() throws ProtocolException {
        waitIfIdle();
        return this.protocol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Status getStatus() throws Throwable {
        int statusCacheTimeout = ((IMAPStore) this.store).getStatusCacheTimeout();
        if (statusCacheTimeout > 0 && this.cachedStatus != null && System.currentTimeMillis() - this.cachedStatusTime < statusCacheTimeout) {
            return this.cachedStatus;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            IMAPProtocol storeProtocol = getStoreProtocol();
            try {
                Status status = storeProtocol.status(this.fullName, null);
                if (statusCacheTimeout > 0) {
                    this.cachedStatus = status;
                    this.cachedStatusTime = System.currentTimeMillis();
                }
                releaseStoreProtocol(storeProtocol);
                return status;
            } catch (Throwable th) {
                th = th;
                iMAPProtocol = storeProtocol;
                releaseStoreProtocol(iMAPProtocol);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean isDirectory() {
        return (this.type & 2) != 0;
    }

    private void keepConnectionAlive(boolean z) throws ProtocolException {
        if (System.currentTimeMillis() - this.protocol.getTimestamp() > 1000) {
            waitIfIdle();
            this.protocol.noop();
        }
        if (z && ((IMAPStore) this.store).hasSeparateStoreConnection()) {
            IMAPProtocol storeProtocol = null;
            try {
                storeProtocol = ((IMAPStore) this.store).getStoreProtocol();
                if (System.currentTimeMillis() - storeProtocol.getTimestamp() > 1000) {
                    storeProtocol.noop();
                }
            } finally {
                ((IMAPStore) this.store).releaseStoreProtocol(storeProtocol);
            }
        }
    }

    private void releaseProtocol(boolean z) {
        IMAPProtocol iMAPProtocol = this.protocol;
        if (iMAPProtocol != null) {
            iMAPProtocol.removeResponseHandler(this);
            if (z) {
                ((IMAPStore) this.store).releaseProtocol(this, this.protocol);
            } else {
                ((IMAPStore) this.store).releaseProtocol(this, null);
            }
        }
    }

    private void setACL(final ACL acl, final char c) throws MessagingException {
        doOptionalCommand("ACL not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.18
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.setACL(IMAPFolder.this.fullName, c, acl);
                return null;
            }
        });
    }

    private synchronized void throwClosedException(ConnectionException connectionException) throws StoreClosedException, FolderClosedException {
        if ((this.protocol != null && connectionException.getProtocol() == this.protocol) || (this.protocol == null && !this.reallyClosed)) {
            throw new FolderClosedException(this, connectionException.getMessage());
        }
        throw new StoreClosedException(this.store, connectionException.getMessage());
    }

    public void addACL(ACL acl) throws MessagingException {
        setACL(acl, (char) 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Message[] addMessages(Message[] messageArr) throws MessagingException {
        MimeMessage[] mimeMessageArr;
        checkOpened();
        mimeMessageArr = new MimeMessage[messageArr.length];
        AppendUID[] appendUIDArrAppendUIDMessages = appendUIDMessages(messageArr);
        for (int i = 0; i < appendUIDArrAppendUIDMessages.length; i++) {
            AppendUID appendUID = appendUIDArrAppendUIDMessages[i];
            if (appendUID != null && appendUID.uidvalidity == this.uidvalidity) {
                try {
                    mimeMessageArr[i] = getMessageByUID(appendUID.uid);
                } catch (MessagingException unused) {
                }
            }
        }
        return mimeMessageArr;
    }

    public void addRights(ACL acl) throws MessagingException {
        setACL(acl, '+');
    }

    @Override // javax.mail.Folder
    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        checkExists();
        int appendBufferSize = ((IMAPStore) this.store).getAppendBufferSize();
        for (Message message : messageArr) {
            try {
                final MessageLiteral messageLiteral = new MessageLiteral(message, message.getSize() > appendBufferSize ? 0 : appendBufferSize);
                final Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                final Flags flags = message.getFlags();
                doCommand(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.10
                    @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
                    public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                        iMAPProtocol.append(IMAPFolder.this.fullName, flags, receivedDate, messageLiteral);
                        return null;
                    }
                });
            } catch (IOException e) {
                throw new MessagingException("IOException while appending messages", e);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized AppendUID[] appendUIDMessages(Message[] messageArr) throws MessagingException {
        AppendUID[] appendUIDArr;
        checkExists();
        int appendBufferSize = ((IMAPStore) this.store).getAppendBufferSize();
        appendUIDArr = new AppendUID[messageArr.length];
        for (int i = 0; i < messageArr.length; i++) {
            Message message = messageArr[i];
            try {
                final MessageLiteral messageLiteral = new MessageLiteral(message, message.getSize() > appendBufferSize ? 0 : appendBufferSize);
                final Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                final Flags flags = message.getFlags();
                appendUIDArr[i] = (AppendUID) doCommand(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.11
                    @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
                    public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                        return iMAPProtocol.appenduid(IMAPFolder.this.fullName, flags, receivedDate, messageLiteral);
                    }
                });
            } catch (IOException e) {
                throw new MessagingException("IOException while appending messages", e);
            } catch (MessageRemovedException unused) {
            }
        }
        return appendUIDArr;
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z) throws MessagingException {
        close(z, false);
    }

    @Override // javax.mail.Folder
    public synchronized void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        checkOpened();
        if (messageArr.length == 0) {
            return;
        }
        if (folder.getStore() == this.store) {
            synchronized (this.messageCacheLock) {
                try {
                    try {
                        try {
                            IMAPProtocol protocol = getProtocol();
                            MessageSet[] messageSet = Utility.toMessageSet(messageArr, null);
                            if (messageSet == null) {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                            protocol.copy(messageSet, folder.getFullName());
                        } catch (ConnectionException e) {
                            throw new FolderClosedException(this, e.getMessage());
                        }
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                } catch (CommandFailedException e3) {
                    if (e3.getMessage().indexOf("TRYCREATE") == -1) {
                        throw new MessagingException(e3.getMessage(), e3);
                    }
                    throw new FolderNotFoundException(folder, String.valueOf(folder.getFullName()) + " does not exist");
                }
            }
        } else {
            super.copyMessages(messageArr, folder);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean create(final int i) throws MessagingException {
        final char separator = (i & 1) == 0 ? getSeparator() : (char) 0;
        if (doCommandIgnoreFailure(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.6
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                ListInfo[] list;
                if ((i & 1) == 0) {
                    iMAPProtocol.create(String.valueOf(IMAPFolder.this.fullName) + separator);
                } else {
                    iMAPProtocol.create(IMAPFolder.this.fullName);
                    if ((i & 2) != 0 && (list = iMAPProtocol.list(BuildConfig.FLAVOR, IMAPFolder.this.fullName)) != null && !list[0].hasInferiors) {
                        iMAPProtocol.delete(IMAPFolder.this.fullName);
                        throw new ProtocolException("Unsupported type");
                    }
                }
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        }
        boolean zExists = exists();
        if (zExists) {
            notifyFolderListeners(1);
        }
        return zExists;
    }

    @Override // javax.mail.Folder
    public synchronized boolean delete(boolean z) throws MessagingException {
        checkClosed();
        if (z) {
            for (Folder folder : list()) {
                folder.delete(z);
            }
        }
        if (doCommandIgnoreFailure(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.8
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.delete(IMAPFolder.this.fullName);
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        }
        this.exists = false;
        this.attributes = null;
        notifyFolderListeners(2);
        return true;
    }

    public Object doCommand(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (ConnectionException e) {
            throwClosedException(e);
            return null;
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    public Object doCommandIgnoreFailure(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e) {
            throwClosedException(e);
            return null;
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    public Object doOptionalCommand(String str, ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (BadCommandException e) {
            throw new MessagingException(str, e);
        } catch (ConnectionException e2) {
            throwClosedException(e2);
            return null;
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    public Object doProtocolCommand(ProtocolCommand protocolCommand) throws ProtocolException {
        Object objDoCommand;
        synchronized (this) {
            if (this.opened && !((IMAPStore) this.store).hasSeparateStoreConnection()) {
                synchronized (this.messageCacheLock) {
                    objDoCommand = protocolCommand.doCommand(getProtocol());
                }
                return objDoCommand;
            }
            IMAPProtocol storeProtocol = null;
            try {
                storeProtocol = getStoreProtocol();
                return protocolCommand.doCommand(storeProtocol);
            } finally {
                releaseStoreProtocol(storeProtocol);
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean exists() throws MessagingException {
        final String str;
        if (!this.isNamespace || this.separator == 0) {
            str = this.fullName;
        } else {
            str = String.valueOf(this.fullName) + this.separator;
        }
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.1
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list(BuildConfig.FLAVOR, str);
            }
        });
        if (listInfoArr != null) {
            int iFindName = findName(listInfoArr, str);
            String str2 = listInfoArr[iFindName].name;
            this.fullName = str2;
            this.separator = listInfoArr[iFindName].separator;
            int length = str2.length();
            if (this.separator != 0 && length > 0) {
                int i = length - 1;
                if (this.fullName.charAt(i) == this.separator) {
                    this.fullName = this.fullName.substring(0, i);
                }
            }
            this.type = 0;
            if (listInfoArr[iFindName].hasInferiors) {
                this.type = 0 | 2;
            }
            if (listInfoArr[iFindName].canOpen) {
                this.type |= 1;
            }
            this.exists = true;
            this.attributes = listInfoArr[iFindName].attrs;
        } else {
            this.exists = this.opened;
            this.attributes = null;
        }
        return this.exists;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] expunge() throws MessagingException {
        return expunge(null);
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        checkOpened();
        IMAPMessage.fetch(this, messageArr, fetchProfile);
    }

    public synchronized void forceClose() throws MessagingException {
        close(false, true);
    }

    public ACL[] getACL() throws MessagingException {
        return (ACL[]) doOptionalCommand("ACL not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.14
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.getACL(IMAPFolder.this.fullName);
            }
        });
    }

    public String[] getAttributes() throws MessagingException {
        if (this.attributes == null) {
            exists();
        }
        return (String[]) this.attributes.clone();
    }

    @Override // javax.mail.Folder
    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.opened) {
            checkExists();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.messageCacheLock) {
                length = getProtocol().search(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (this.attributes != null && !isDirectory()) {
            throw new MessagingException("Cannot contain subfolders");
        }
        char separator = getSeparator();
        return new IMAPFolder(String.valueOf(this.fullName) + separator + str, separator, (IMAPStore) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized String getFullName() {
        return this.fullName;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i) throws MessagingException {
        checkOpened();
        checkRange(i);
        return (Message) this.messageCache.elementAt(i - 1);
    }

    public IMAPMessage getMessageBySeqNumber(int i) {
        for (int i2 = i - 1; i2 < this.total; i2++) {
            IMAPMessage iMAPMessage = (IMAPMessage) this.messageCache.elementAt(i2);
            if (iMAPMessage.getSequenceNumber() == i) {
                return iMAPMessage;
            }
        }
        return null;
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message getMessageByUID(long j) throws MessagingException {
        int i;
        checkOpened();
        IMAPMessage messageBySeqNumber = null;
        try {
            synchronized (this.messageCacheLock) {
                Long l = new Long(j);
                Hashtable hashtable = this.uidTable;
                if (hashtable != null) {
                    messageBySeqNumber = (IMAPMessage) hashtable.get(l);
                    if (messageBySeqNumber != null) {
                        return messageBySeqNumber;
                    }
                } else {
                    this.uidTable = new Hashtable();
                }
                UID uidFetchSequenceNumber = getProtocol().fetchSequenceNumber(j);
                if (uidFetchSequenceNumber != null && (i = uidFetchSequenceNumber.seqnum) <= this.total) {
                    messageBySeqNumber = getMessageBySeqNumber(i);
                    messageBySeqNumber.setUID(uidFetchSequenceNumber.uid);
                    this.uidTable.put(l, messageBySeqNumber);
                }
                return messageBySeqNumber;
            }
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        int i;
        if (this.opened) {
            synchronized (this.messageCacheLock) {
                try {
                    keepConnectionAlive(true);
                    i = this.total;
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            return i;
        }
        checkExists();
        try {
            try {
                try {
                    return getStatus().total;
                } catch (ConnectionException e3) {
                    throw new StoreClosedException(this.store, e3.getMessage());
                }
            } catch (BadCommandException unused) {
                IMAPProtocol storeProtocol = null;
                try {
                    try {
                        storeProtocol = getStoreProtocol();
                        MailboxInfo mailboxInfoExamine = storeProtocol.examine(this.fullName);
                        storeProtocol.close();
                        int i2 = mailboxInfoExamine.total;
                        releaseStoreProtocol(storeProtocol);
                        return i2;
                    } catch (Throwable th) {
                        releaseStoreProtocol(storeProtocol);
                        throw th;
                    }
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            }
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
        throw th;
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long j, long j2) throws MessagingException {
        Message[] messageArr;
        checkOpened();
        try {
            synchronized (this.messageCacheLock) {
                if (this.uidTable == null) {
                    this.uidTable = new Hashtable();
                }
                UID[] uidArrFetchSequenceNumbers = getProtocol().fetchSequenceNumbers(j, j2);
                messageArr = new Message[uidArrFetchSequenceNumbers.length];
                for (int i = 0; i < uidArrFetchSequenceNumbers.length; i++) {
                    IMAPMessage messageBySeqNumber = getMessageBySeqNumber(uidArrFetchSequenceNumbers[i].seqnum);
                    messageBySeqNumber.setUID(uidArrFetchSequenceNumbers[i].uid);
                    messageArr[i] = messageBySeqNumber;
                    this.uidTable.put(new Long(uidArrFetchSequenceNumbers[i].uid), messageBySeqNumber);
                }
            }
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
        return messageArr;
    }

    @Override // javax.mail.Folder
    public synchronized String getName() {
        if (this.name == null) {
            try {
                String str = this.fullName;
                this.name = str.substring(str.lastIndexOf(getSeparator()) + 1);
            } catch (MessagingException unused) {
            }
        }
        return this.name;
    }

    @Override // javax.mail.Folder
    public synchronized int getNewMessageCount() throws MessagingException {
        int i;
        if (this.opened) {
            synchronized (this.messageCacheLock) {
                try {
                    keepConnectionAlive(true);
                    i = this.recent;
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            return i;
        }
        checkExists();
        try {
            try {
                try {
                    return getStatus().recent;
                } catch (ConnectionException e3) {
                    throw new StoreClosedException(this.store, e3.getMessage());
                }
            } catch (BadCommandException unused) {
                IMAPProtocol storeProtocol = null;
                try {
                    try {
                        storeProtocol = getStoreProtocol();
                        MailboxInfo mailboxInfoExamine = storeProtocol.examine(this.fullName);
                        storeProtocol.close();
                        int i2 = mailboxInfoExamine.recent;
                        releaseStoreProtocol(storeProtocol);
                        return i2;
                    } catch (Throwable th) {
                        releaseStoreProtocol(storeProtocol);
                        throw th;
                    }
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            }
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
        throw th;
    }

    @Override // javax.mail.Folder
    public synchronized Folder getParent() throws MessagingException {
        char separator = getSeparator();
        int iLastIndexOf = this.fullName.lastIndexOf(separator);
        if (iLastIndexOf != -1) {
            return new IMAPFolder(this.fullName.substring(0, iLastIndexOf), separator, (IMAPStore) this.store);
        }
        return new DefaultFolder((IMAPStore) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized Flags getPermanentFlags() {
        return (Flags) this.permanentFlags.clone();
    }

    public Quota[] getQuota() throws MessagingException {
        return (Quota[]) doOptionalCommand("QUOTA not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.12
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.getQuotaRoot(IMAPFolder.this.fullName);
            }
        });
    }

    @Override // javax.mail.Folder
    public synchronized char getSeparator() throws MessagingException {
        if (this.separator == 65535) {
            ListInfo[] listInfoArr = (ListInfo[]) doCommand(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.3
                @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    return iMAPProtocol.isREV1() ? iMAPProtocol.list(IMAPFolder.this.fullName, BuildConfig.FLAVOR) : iMAPProtocol.list(BuildConfig.FLAVOR, IMAPFolder.this.fullName);
                }
            });
            if (listInfoArr != null) {
                this.separator = listInfoArr[0].separator;
            } else {
                this.separator = '/';
            }
        }
        return this.separator;
    }

    public synchronized IMAPProtocol getStoreProtocol() throws ProtocolException {
        if (this.connectionPoolDebug) {
            this.out.println("DEBUG: getStoreProtocol() - borrowing a connection");
        }
        return ((IMAPStore) this.store).getStoreProtocol();
    }

    @Override // javax.mail.Folder
    public synchronized int getType() throws MessagingException {
        if (!this.opened) {
            checkExists();
        } else if (this.attributes == null) {
            exists();
        }
        return this.type;
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUID(Message message) throws MessagingException {
        if (message.getFolder() != this) {
            throw new NoSuchElementException("Message does not belong to this folder");
        }
        checkOpened();
        IMAPMessage iMAPMessage = (IMAPMessage) message;
        long uid = iMAPMessage.getUID();
        if (uid != -1) {
            return uid;
        }
        synchronized (this.messageCacheLock) {
            try {
                IMAPProtocol protocol = getProtocol();
                iMAPMessage.checkExpunged();
                UID uidFetchUID = protocol.fetchUID(iMAPMessage.getSequenceNumber());
                if (uidFetchUID != null) {
                    uid = uidFetchUID.uid;
                    iMAPMessage.setUID(uid);
                    if (this.uidTable == null) {
                        this.uidTable = new Hashtable();
                    }
                    this.uidTable.put(new Long(uid), iMAPMessage);
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        return uid;
    }

    public synchronized long getUIDNext() throws MessagingException {
        Throwable th;
        ProtocolException e;
        IMAPProtocol storeProtocol;
        BadCommandException e2;
        if (this.opened) {
            return this.uidnext;
        }
        Status status = null;
        try {
            try {
                storeProtocol = getStoreProtocol();
                try {
                    status = storeProtocol.status(this.fullName, new String[]{"UIDNEXT"});
                } catch (BadCommandException e3) {
                    e2 = e3;
                    throw new MessagingException("Cannot obtain UIDNext", e2);
                } catch (ConnectionException e4) {
                    e = e4;
                    throwClosedException(e);
                } catch (ProtocolException e5) {
                    e = e5;
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (BadCommandException e6) {
                e2 = e6;
            } catch (ConnectionException e7) {
                e = e7;
                storeProtocol = null;
            } catch (ProtocolException e8) {
                e = e8;
            } catch (Throwable th2) {
                th = th2;
                releaseStoreProtocol(null);
                throw th;
            }
            releaseStoreProtocol(storeProtocol);
            return status.uidnext;
        } catch (Throwable th3) {
            th = th3;
            releaseStoreProtocol(null);
            throw th;
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUIDValidity() throws MessagingException {
        Throwable th;
        ProtocolException e;
        IMAPProtocol storeProtocol;
        BadCommandException e2;
        if (this.opened) {
            return this.uidvalidity;
        }
        Status status = null;
        try {
            try {
                storeProtocol = getStoreProtocol();
                try {
                    status = storeProtocol.status(this.fullName, new String[]{"UIDVALIDITY"});
                } catch (BadCommandException e3) {
                    e2 = e3;
                    throw new MessagingException("Cannot obtain UIDValidity", e2);
                } catch (ConnectionException e4) {
                    e = e4;
                    throwClosedException(e);
                } catch (ProtocolException e5) {
                    e = e5;
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (BadCommandException e6) {
                e2 = e6;
            } catch (ConnectionException e7) {
                e = e7;
                storeProtocol = null;
            } catch (ProtocolException e8) {
                e = e8;
            } catch (Throwable th2) {
                th = th2;
                releaseStoreProtocol(null);
                throw th;
            }
            releaseStoreProtocol(storeProtocol);
            return status.uidvalidity;
        } catch (Throwable th3) {
            th = th3;
            releaseStoreProtocol(null);
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.opened) {
            checkExists();
            try {
                try {
                    return getStatus().unseen;
                } catch (BadCommandException unused) {
                    return -1;
                } catch (ProtocolException e) {
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this.store, e2.getMessage());
            }
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.SEEN);
        try {
            synchronized (this.messageCacheLock) {
                length = getProtocol().search(new FlagTerm(flags, false)).length;
            }
            return length;
        } catch (ConnectionException e3) {
            throw new FolderClosedException(this, e3.getMessage());
        } catch (ProtocolException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        }
        throw th;
    }

    @Override // com.sun.mail.iap.ResponseHandler
    public void handleResponse(Response response) {
        IMAPMessage messageBySeqNumber;
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            ((IMAPStore) this.store).handleResponseCode(response);
        }
        if (response.isBYE()) {
            if (this.opened) {
                cleanup(false);
                return;
            }
            return;
        }
        if (!response.isOK() && response.isUnTagged()) {
            if (!(response instanceof IMAPResponse)) {
                this.out.println("UNEXPECTED RESPONSE : " + response.toString());
                this.out.println("CONTACT javamail@sun.com");
                return;
            }
            IMAPResponse iMAPResponse = (IMAPResponse) response;
            if (iMAPResponse.keyEquals("EXISTS")) {
                int number = iMAPResponse.getNumber();
                int i = this.realTotal;
                if (number <= i) {
                    return;
                }
                int i2 = number - i;
                Message[] messageArr = new Message[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = this.total + 1;
                    this.total = i4;
                    int i5 = this.realTotal + 1;
                    this.realTotal = i5;
                    IMAPMessage iMAPMessage = new IMAPMessage(this, i4, i5);
                    messageArr[i3] = iMAPMessage;
                    this.messageCache.addElement(iMAPMessage);
                }
                notifyMessageAddedListeners(messageArr);
                return;
            }
            if (iMAPResponse.keyEquals("EXPUNGE")) {
                IMAPMessage messageBySeqNumber2 = getMessageBySeqNumber(iMAPResponse.getNumber());
                messageBySeqNumber2.setExpunged(true);
                for (int messageNumber = messageBySeqNumber2.getMessageNumber(); messageNumber < this.total; messageNumber++) {
                    IMAPMessage iMAPMessage2 = (IMAPMessage) this.messageCache.elementAt(messageNumber);
                    if (!iMAPMessage2.isExpunged()) {
                        iMAPMessage2.setSequenceNumber(iMAPMessage2.getSequenceNumber() - 1);
                    }
                }
                this.realTotal--;
                if (this.doExpungeNotification) {
                    notifyMessageRemovedListeners(false, new Message[]{messageBySeqNumber2});
                    return;
                }
                return;
            }
            if (!iMAPResponse.keyEquals("FETCH")) {
                if (iMAPResponse.keyEquals("RECENT")) {
                    this.recent = iMAPResponse.getNumber();
                    return;
                }
                return;
            }
            FetchResponse fetchResponse = (FetchResponse) iMAPResponse;
            Flags flags = (Flags) fetchResponse.getItem(Flags.class);
            if (flags == null || (messageBySeqNumber = getMessageBySeqNumber(fetchResponse.getNumber())) == null) {
                return;
            }
            messageBySeqNumber._setFlags(flags);
            notifyMessageChangedListeners(1, messageBySeqNumber);
        }
    }

    public void handleResponses(Response[] responseArr) {
        for (int i = 0; i < responseArr.length; i++) {
            if (responseArr[i] != null) {
                handleResponse(responseArr[i]);
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean hasNewMessages() throws MessagingException {
        boolean z;
        if (!this.opened) {
            checkExists();
            Boolean bool = (Boolean) doCommandIgnoreFailure(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.7
                @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    ListInfo[] list = iMAPProtocol.list(BuildConfig.FLAVOR, IMAPFolder.this.fullName);
                    if (list != null) {
                        if (list[0].changeState == 1) {
                            return Boolean.TRUE;
                        }
                        if (list[0].changeState == 2) {
                            return Boolean.FALSE;
                        }
                    }
                    return IMAPFolder.this.getStatus().recent > 0 ? Boolean.TRUE : Boolean.FALSE;
                }
            });
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        synchronized (this.messageCacheLock) {
            try {
                keepConnectionAlive(true);
                z = this.recent > 0;
            } catch (ConnectionException e) {
                throw new FolderClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r0 = ((com.sun.mail.imap.IMAPStore) r3.store).getMinIdleTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        if (r0 <= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        java.lang.Thread.sleep(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void idle() throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkOpened()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = "IDLE not supported"
            com.sun.mail.imap.IMAPFolder$19 r1 = new com.sun.mail.imap.IMAPFolder$19     // Catch: java.lang.Throwable -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r3.doOptionalCommand(r0, r1)     // Catch: java.lang.Throwable -> L5d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L5d
            if (r0 != 0) goto L19
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
            return
        L19:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
        L1a:
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r3.protocol
            com.sun.mail.iap.Response r0 = r0.readIdleResponse()
            java.lang.Object r1 = r3.messageCacheLock     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
            monitor-enter(r1)     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
            if (r0 == 0) goto L32
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r3.protocol     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L32
            boolean r0 = r2.processIdleResponse(r0)     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L30
            goto L32
        L30:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            goto L1a
        L32:
            r0 = 0
            r3.idleState = r0     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r0 = r3.messageCacheLock     // Catch: java.lang.Throwable -> L4a
            r0.notifyAll()     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            javax.mail.Store r0 = r3.store
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0
            int r0 = r0.getMinIdleTime()
            if (r0 <= 0) goto L49
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> L49
        L49:
            return
        L4a:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            throw r0     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
        L4d:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L58:
            r0 = move-exception
            r3.throwClosedException(r0)
            goto L1a
        L5d:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.idle():void");
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        synchronized (this.messageCacheLock) {
            if (this.opened) {
                try {
                    keepConnectionAlive(false);
                } catch (ProtocolException unused) {
                }
            }
        }
        return this.opened;
    }

    @Override // javax.mail.Folder
    public synchronized boolean isSubscribed() {
        final String str;
        ListInfo[] listInfoArr = null;
        if (!this.isNamespace || this.separator == 0) {
            str = this.fullName;
        } else {
            str = String.valueOf(this.fullName) + this.separator;
        }
        try {
            listInfoArr = (ListInfo[]) doProtocolCommand(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.4
                @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    return iMAPProtocol.lsub(BuildConfig.FLAVOR, str);
                }
            });
        } catch (ProtocolException unused) {
        }
        if (listInfoArr == null) {
            return false;
        }
        return listInfoArr[findName(listInfoArr, str)].canOpen;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return doList(str, false);
    }

    public Rights[] listRights(final String str) throws MessagingException {
        return (Rights[]) doOptionalCommand("ACL not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.16
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.listRights(IMAPFolder.this.fullName, str);
            }
        });
    }

    @Override // javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        return doList(str, true);
    }

    public Rights myRights() throws MessagingException {
        return (Rights) doOptionalCommand("ACL not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.17
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.myRights(IMAPFolder.this.fullName);
            }
        });
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i) throws MessagingException {
        checkClosed();
        this.protocol = ((IMAPStore) this.store).getProtocol(this);
        synchronized (this.messageCacheLock) {
            this.protocol.addResponseHandler(this);
            int i2 = 0;
            boolean z = false;
            try {
                MailboxInfo mailboxInfoExamine = i == 1 ? this.protocol.examine(this.fullName) : this.protocol.select(this.fullName);
                int i3 = mailboxInfoExamine.mode;
                if (i3 != i && (i != 2 || i3 != 1 || !((IMAPStore) this.store).allowReadOnlySelect())) {
                    try {
                        try {
                            try {
                                this.protocol.close();
                                releaseProtocol(true);
                            } catch (ProtocolException unused) {
                            } finally {
                                releaseProtocol(false);
                            }
                        } catch (Throwable unused2) {
                        }
                    } catch (ProtocolException unused3) {
                        this.protocol.logout();
                        this.protocol = null;
                        throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                    }
                    this.protocol = null;
                    throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                }
                this.opened = true;
                this.reallyClosed = false;
                this.mode = mailboxInfoExamine.mode;
                this.availableFlags = mailboxInfoExamine.availableFlags;
                this.permanentFlags = mailboxInfoExamine.permanentFlags;
                int i4 = mailboxInfoExamine.total;
                this.realTotal = i4;
                this.total = i4;
                this.recent = mailboxInfoExamine.recent;
                this.uidvalidity = mailboxInfoExamine.uidvalidity;
                this.uidnext = mailboxInfoExamine.uidnext;
                this.messageCache = new Vector(this.total);
                while (i2 < this.total) {
                    i2++;
                    this.messageCache.addElement(new IMAPMessage(this, i2, i2));
                }
            } catch (CommandFailedException e) {
                e = e;
                releaseProtocol(true);
                this.protocol = null;
            } catch (ProtocolException e2) {
                try {
                    this.protocol.logout();
                } catch (Throwable unused4) {
                }
                releaseProtocol(false);
                this.protocol = null;
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        e = null;
        if (e != null) {
            checkExists();
            if ((this.type & 1) != 0) {
                throw new MessagingException(e.getMessage(), e);
            }
            throw new MessagingException("folder cannot contain messages");
        }
        this.exists = true;
        this.attributes = null;
        this.type = 1;
        notifyConnectionListeners(1);
    }

    public synchronized void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != this.protocol) {
            ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
        }
    }

    public void removeACL(final String str) throws MessagingException {
        doOptionalCommand("ACL not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.15
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.deleteACL(IMAPFolder.this.fullName, str);
                return null;
            }
        });
    }

    public void removeRights(ACL acl) throws MessagingException {
        setACL(acl, '-');
    }

    @Override // javax.mail.Folder
    public synchronized boolean renameTo(final Folder folder) throws MessagingException {
        checkClosed();
        checkExists();
        if (folder.getStore() != this.store) {
            throw new MessagingException("Can't rename across Stores");
        }
        if (doCommandIgnoreFailure(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.9
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.rename(IMAPFolder.this.fullName, folder.getFullName());
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        }
        this.exists = false;
        this.attributes = null;
        notifyFolderRenamedListeners(folder);
        return true;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm) throws MessagingException {
        IMAPMessage[] iMAPMessageArr;
        checkOpened();
        iMAPMessageArr = null;
        try {
            try {
                synchronized (this.messageCacheLock) {
                    int[] iArrSearch = getProtocol().search(searchTerm);
                    if (iArrSearch != null) {
                        iMAPMessageArr = new IMAPMessage[iArrSearch.length];
                        for (int i = 0; i < iArrSearch.length; i++) {
                            iMAPMessageArr[i] = getMessageBySeqNumber(iArrSearch[i]);
                        }
                    }
                }
            } catch (ProtocolException e) {
                throw new MessagingException(e.getMessage(), e);
            } catch (SearchException unused) {
                return super.search(searchTerm);
            }
        } catch (CommandFailedException unused2) {
            return super.search(searchTerm);
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        }
        return iMAPMessageArr;
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z) throws MessagingException {
        checkOpened();
        checkFlags(flags);
        if (messageArr.length == 0) {
            return;
        }
        synchronized (this.messageCacheLock) {
            try {
                IMAPProtocol protocol = getProtocol();
                MessageSet[] messageSet = Utility.toMessageSet(messageArr, null);
                if (messageSet == null) {
                    throw new MessageRemovedException("Messages have been removed");
                }
                protocol.storeFlags(messageSet, flags, z);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    public void setQuota(final Quota quota) throws MessagingException {
        doOptionalCommand("QUOTA not supported", new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.13
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.setQuota(quota);
                return null;
            }
        });
    }

    @Override // javax.mail.Folder
    public synchronized void setSubscribed(final boolean z) throws MessagingException {
        doCommandIgnoreFailure(new ProtocolCommand() { // from class: com.sun.mail.imap.IMAPFolder.5
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                if (z) {
                    iMAPProtocol.subscribe(IMAPFolder.this.fullName);
                    return null;
                }
                iMAPProtocol.unsubscribe(IMAPFolder.this.fullName);
                return null;
            }
        });
    }

    public void waitIfIdle() throws ProtocolException {
        while (true) {
            int i = this.idleState;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                this.protocol.idleAbort();
                this.idleState = 2;
            }
            try {
                this.messageCacheLock.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public synchronized Message[] expunge(Message[] messageArr) throws MessagingException {
        Message[] messageArr2;
        checkOpened();
        Vector vector = new Vector();
        if (messageArr != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(UIDFolder.FetchProfileItem.UID);
            fetch(messageArr, fetchProfile);
        }
        synchronized (this.messageCacheLock) {
            int i = 0;
            this.doExpungeNotification = false;
            try {
                try {
                    try {
                        IMAPProtocol protocol = getProtocol();
                        if (messageArr != null) {
                            protocol.uidexpunge(Utility.toUIDSet(messageArr));
                        } else {
                            protocol.expunge();
                        }
                        this.doExpungeNotification = true;
                        while (i < this.messageCache.size()) {
                            IMAPMessage iMAPMessage = (IMAPMessage) this.messageCache.elementAt(i);
                            if (iMAPMessage.isExpunged()) {
                                vector.addElement(iMAPMessage);
                                this.messageCache.removeElementAt(i);
                                if (this.uidTable != null) {
                                    long uid = iMAPMessage.getUID();
                                    if (uid != -1) {
                                        this.uidTable.remove(new Long(uid));
                                    }
                                }
                            } else {
                                iMAPMessage.setMessageNumber(iMAPMessage.getSequenceNumber());
                                i++;
                            }
                        }
                    } catch (CommandFailedException e) {
                        if (this.mode == 2) {
                            throw new MessagingException(e.getMessage(), e);
                        }
                        throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.fullName);
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                } catch (ConnectionException e3) {
                    throw new FolderClosedException(this, e3.getMessage());
                }
            } catch (Throwable th) {
                this.doExpungeNotification = true;
                throw th;
            }
        }
        this.total = this.messageCache.size();
        int size = vector.size();
        messageArr2 = new Message[size];
        vector.copyInto(messageArr2);
        if (size > 0) {
            notifyMessageRemovedListeners(true, messageArr2);
        }
        return messageArr2;
    }

    private void close(boolean z, boolean z2) throws MessagingException {
        synchronized (this.messageCacheLock) {
            boolean z3 = this.opened;
            if (!z3 && this.reallyClosed) {
                throw new IllegalStateException("This operation is not allowed on a closed folder");
            }
            this.reallyClosed = true;
            try {
                if (z3) {
                    try {
                        waitIfIdle();
                        if (z2) {
                            if (this.debug) {
                                this.out.println("DEBUG: forcing folder " + this.fullName + " to close");
                            }
                            IMAPProtocol iMAPProtocol = this.protocol;
                            if (iMAPProtocol != null) {
                                iMAPProtocol.disconnect();
                            }
                        } else if (((IMAPStore) this.store).isConnectionPoolFull()) {
                            if (this.debug) {
                                this.out.println("DEBUG: pool is full, not adding an Authenticated connection");
                            }
                            if (z) {
                                this.protocol.close();
                            }
                            IMAPProtocol iMAPProtocol2 = this.protocol;
                            if (iMAPProtocol2 != null) {
                                iMAPProtocol2.logout();
                            }
                        } else {
                            if (!z && this.mode == 2) {
                                try {
                                    this.protocol.examine(this.fullName);
                                } catch (ProtocolException unused) {
                                    IMAPProtocol iMAPProtocol3 = this.protocol;
                                    if (iMAPProtocol3 != null) {
                                        iMAPProtocol3.disconnect();
                                    }
                                }
                            }
                            IMAPProtocol iMAPProtocol4 = this.protocol;
                            if (iMAPProtocol4 != null) {
                                iMAPProtocol4.close();
                            }
                        }
                        if (this.opened) {
                            cleanup(true);
                        }
                    } catch (ProtocolException e) {
                        throw new MessagingException(e.getMessage(), e);
                    }
                }
            } catch (Throwable th) {
                if (this.opened) {
                    cleanup(true);
                }
                throw th;
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        IMAPMessage[] iMAPMessageArr;
        checkOpened();
        if (messageArr.length == 0) {
            return messageArr;
        }
        try {
            try {
                try {
                    try {
                        synchronized (this.messageCacheLock) {
                            IMAPProtocol protocol = getProtocol();
                            iMAPMessageArr = null;
                            MessageSet[] messageSet = Utility.toMessageSet(messageArr, null);
                            if (messageSet != null) {
                                int[] iArrSearch = protocol.search(messageSet, searchTerm);
                                if (iArrSearch != null) {
                                    iMAPMessageArr = new IMAPMessage[iArrSearch.length];
                                    for (int i = 0; i < iArrSearch.length; i++) {
                                        iMAPMessageArr[i] = getMessageBySeqNumber(iArrSearch[i]);
                                    }
                                }
                            } else {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                        }
                        return iMAPMessageArr;
                    } catch (ConnectionException e) {
                        throw new FolderClosedException(this, e.getMessage());
                    }
                } catch (SearchException unused) {
                    return super.search(searchTerm, messageArr);
                }
            } catch (CommandFailedException unused2) {
                return super.search(searchTerm, messageArr);
            }
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        checkOpened();
        try {
            try {
                synchronized (this.messageCacheLock) {
                    if (this.uidTable != null) {
                        Vector vector = new Vector();
                        for (long j : jArr) {
                            Hashtable hashtable = this.uidTable;
                            Long l = new Long(j);
                            if (!hashtable.containsKey(l)) {
                                vector.addElement(l);
                            }
                        }
                        int size = vector.size();
                        jArr2 = new long[size];
                        for (int i = 0; i < size; i++) {
                            jArr2[i] = ((Long) vector.elementAt(i)).longValue();
                        }
                    } else {
                        this.uidTable = new Hashtable();
                        jArr2 = jArr;
                    }
                    if (jArr2.length > 0) {
                        UID[] uidArrFetchSequenceNumbers = getProtocol().fetchSequenceNumbers(jArr2);
                        for (int i2 = 0; i2 < uidArrFetchSequenceNumbers.length; i2++) {
                            IMAPMessage messageBySeqNumber = getMessageBySeqNumber(uidArrFetchSequenceNumbers[i2].seqnum);
                            messageBySeqNumber.setUID(uidArrFetchSequenceNumbers[i2].uid);
                            this.uidTable.put(new Long(uidArrFetchSequenceNumbers[i2].uid), messageBySeqNumber);
                        }
                    }
                    messageArr = new Message[jArr.length];
                    for (int i3 = 0; i3 < jArr.length; i3++) {
                        messageArr[i3] = (Message) this.uidTable.get(new Long(jArr[i3]));
                    }
                }
            } catch (ProtocolException e) {
                throw new MessagingException(e.getMessage(), e);
            }
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        }
        return messageArr;
    }

    public IMAPFolder(String str, char c, IMAPStore iMAPStore, boolean z) {
        this(str, c, iMAPStore);
        this.isNamespace = z;
    }

    public IMAPFolder(ListInfo listInfo, IMAPStore iMAPStore) {
        this(listInfo.name, listInfo.separator, iMAPStore);
        if (listInfo.hasInferiors) {
            this.type |= 2;
        }
        if (listInfo.canOpen) {
            this.type |= 1;
        }
        this.exists = true;
        this.attributes = listInfo.attrs;
    }
}
