package javax.mail;

/* JADX INFO: loaded from: classes.dex */
public interface UIDFolder {
    public static final long LASTUID = -1;

    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem UID = new FetchProfileItem("UID");

        public FetchProfileItem(String str) {
            super(str);
        }
    }

    Message getMessageByUID(long j) throws MessagingException;

    Message[] getMessagesByUID(long j, long j2) throws MessagingException;

    Message[] getMessagesByUID(long[] jArr) throws MessagingException;

    long getUID(Message message) throws MessagingException;

    long getUIDValidity() throws MessagingException;
}
