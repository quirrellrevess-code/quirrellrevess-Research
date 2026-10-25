package com.sun.mail.imap;

import com.google.android.flexbox.BuildConfig;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.ListInfo;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* JADX INFO: loaded from: classes.dex */
public class DefaultFolder extends IMAPFolder {
    public DefaultFolder(IMAPStore iMAPStore) {
        super(BuildConfig.FLAVOR, IMAPFolder.UNKNOWN_SEPARATOR, iMAPStore);
        this.exists = true;
        this.type = 2;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        return new IMAPFolder(str, IMAPFolder.UNKNOWN_SEPARATOR, (IMAPStore) this.store);
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public String getName() {
        return this.fullName;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder[] list(final String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() { // from class: com.sun.mail.imap.DefaultFolder.1
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list(BuildConfig.FLAVOR, str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i = 0; i < length; i++) {
            iMAPFolderArr[i] = new IMAPFolder(listInfoArr[i], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder[] listSubscribed(final String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() { // from class: com.sun.mail.imap.DefaultFolder.2
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.lsub(BuildConfig.FLAVOR, str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i = 0; i < length; i++) {
            iMAPFolderArr[i] = new IMAPFolder(listInfoArr[i], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
