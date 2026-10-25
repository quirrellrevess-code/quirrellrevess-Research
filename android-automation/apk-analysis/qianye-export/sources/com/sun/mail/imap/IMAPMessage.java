package com.sun.mail.imap;

import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.INTERNALDATE;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.RFC822DATA;
import com.sun.mail.imap.protocol.RFC822SIZE;
import com.sun.mail.imap.protocol.UID;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.UIDFolder;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes.dex */
public class IMAPMessage extends MimeMessage {
    private static String EnvelopeCmd = "ENVELOPE INTERNALDATE RFC822.SIZE";

    /* JADX INFO: renamed from: bs */
    public BODYSTRUCTURE f122bs;
    private String description;
    public ENVELOPE envelope;
    private boolean headersLoaded;
    private Hashtable loadedHeaders;
    private boolean peek;
    private Date receivedDate;
    public String sectionId;
    private int seqnum;
    private int size;
    private String subject;
    private String type;
    private long uid;

    public IMAPMessage(IMAPFolder iMAPFolder, int i, int i2) {
        super(iMAPFolder, i);
        this.size = -1;
        this.uid = -1L;
        this.headersLoaded = false;
        this.seqnum = i2;
        this.flags = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BODYSTRUCTURE _getBodyStructure() {
        return this.f122bs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ENVELOPE _getEnvelope() {
        return this.envelope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flags _getFlags() {
        return this.flags;
    }

    private InternetAddress[] aaclone(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean areHeadersLoaded() {
        return this.headersLoaded;
    }

    private static String craftHeaderCmd(IMAPProtocol iMAPProtocol, String[] strArr) {
        StringBuffer stringBuffer = iMAPProtocol.isREV1() ? new StringBuffer("BODY.PEEK[HEADER.FIELDS (") : new StringBuffer("RFC822.HEADER.LINES (");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(strArr[i]);
        }
        if (iMAPProtocol.isREV1()) {
            stringBuffer.append(")]");
        } else {
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    public static void fetch(IMAPFolder iMAPFolder, Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        boolean z;
        boolean z2;
        String[] headerNames;
        int i;
        FetchResponse fetchResponse;
        StringBuffer stringBuffer = new StringBuffer();
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            stringBuffer.append(EnvelopeCmd);
            z = false;
        } else {
            z = true;
        }
        if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
            stringBuffer.append(z ? "FLAGS" : " FLAGS");
            z = false;
        }
        if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
            stringBuffer.append(z ? "BODYSTRUCTURE" : " BODYSTRUCTURE");
            z = false;
        }
        if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            stringBuffer.append(z ? "UID" : " UID");
            z = false;
        }
        if (fetchProfile.contains(IMAPFolder.FetchProfileItem.HEADERS)) {
            if (iMAPFolder.protocol.isREV1()) {
                stringBuffer.append(z ? "BODY.PEEK[HEADER]" : " BODY.PEEK[HEADER]");
            } else {
                stringBuffer.append(z ? "RFC822.HEADER" : " RFC822.HEADER");
            }
            z = false;
            z2 = true;
        } else {
            z2 = false;
        }
        if (fetchProfile.contains(IMAPFolder.FetchProfileItem.SIZE)) {
            stringBuffer.append(z ? "RFC822.SIZE" : " RFC822.SIZE");
            z = false;
        }
        Response[] responseArrFetch = null;
        if (z2) {
            headerNames = null;
        } else {
            headerNames = fetchProfile.getHeaderNames();
            if (headerNames.length > 0) {
                if (!z) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(craftHeaderCmd(iMAPFolder.protocol, headerNames));
            }
        }
        Utility.Condition condition = new Utility.Condition(fetchProfile) { // from class: com.sun.mail.imap.IMAPMessage.1FetchProfileCondition
            private String[] hdrs;
            private boolean needBodyStructure;
            private boolean needEnvelope;
            private boolean needFlags;
            private boolean needHeaders;
            private boolean needSize;
            private boolean needUID;

            {
                this.needEnvelope = false;
                this.needFlags = false;
                this.needBodyStructure = false;
                this.needUID = false;
                this.needHeaders = false;
                this.needSize = false;
                this.hdrs = null;
                if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                    this.needEnvelope = true;
                }
                if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
                    this.needFlags = true;
                }
                if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
                    this.needBodyStructure = true;
                }
                if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                    this.needUID = true;
                }
                if (fetchProfile.contains(IMAPFolder.FetchProfileItem.HEADERS)) {
                    this.needHeaders = true;
                }
                if (fetchProfile.contains(IMAPFolder.FetchProfileItem.SIZE)) {
                    this.needSize = true;
                }
                this.hdrs = fetchProfile.getHeaderNames();
            }

            @Override // com.sun.mail.imap.Utility.Condition
            public boolean test(IMAPMessage iMAPMessage) {
                if (this.needEnvelope && iMAPMessage._getEnvelope() == null) {
                    return true;
                }
                if (this.needFlags && iMAPMessage._getFlags() == null) {
                    return true;
                }
                if (this.needBodyStructure && iMAPMessage._getBodyStructure() == null) {
                    return true;
                }
                if (this.needUID && iMAPMessage.getUID() == -1) {
                    return true;
                }
                if (this.needHeaders && !iMAPMessage.areHeadersLoaded()) {
                    return true;
                }
                if (this.needSize && iMAPMessage.size == -1) {
                    return true;
                }
                int i2 = 0;
                while (true) {
                    String[] strArr = this.hdrs;
                    if (i2 >= strArr.length) {
                        return false;
                    }
                    if (!iMAPMessage.isHeaderLoaded(strArr[i2])) {
                        return true;
                    }
                    i2++;
                }
            }
        };
        synchronized (iMAPFolder.messageCacheLock) {
            try {
                MessageSet[] messageSet = Utility.toMessageSet(messageArr, condition);
                if (messageSet == null) {
                    return;
                }
                Vector vector = new Vector();
                try {
                    try {
                        responseArrFetch = iMAPFolder.protocol.fetch(messageSet, stringBuffer.toString());
                    } catch (CommandFailedException unused) {
                    } catch (ConnectionException e) {
                        throw new FolderClosedException(iMAPFolder, e.getMessage());
                    }
                    if (responseArrFetch == null) {
                        return;
                    }
                    int i2 = 0;
                    while (i2 < responseArrFetch.length) {
                        if (responseArrFetch[i2] != null) {
                            if (responseArrFetch[i2] instanceof FetchResponse) {
                                FetchResponse fetchResponse2 = (FetchResponse) responseArrFetch[i2];
                                IMAPMessage messageBySeqNumber = iMAPFolder.getMessageBySeqNumber(fetchResponse2.getNumber());
                                int itemCount = fetchResponse2.getItemCount();
                                int i3 = 0;
                                boolean z3 = false;
                                while (i3 < itemCount) {
                                    Object item = fetchResponse2.getItem(i3);
                                    if (!(item instanceof Flags)) {
                                        if (item instanceof ENVELOPE) {
                                            messageBySeqNumber.envelope = (ENVELOPE) item;
                                        } else if (item instanceof INTERNALDATE) {
                                            messageBySeqNumber.receivedDate = ((INTERNALDATE) item).getDate();
                                        } else if (item instanceof RFC822SIZE) {
                                            messageBySeqNumber.size = ((RFC822SIZE) item).size;
                                        } else if (item instanceof BODYSTRUCTURE) {
                                            messageBySeqNumber.f122bs = (BODYSTRUCTURE) item;
                                        } else if (item instanceof UID) {
                                            UID uid = (UID) item;
                                            messageBySeqNumber.uid = uid.uid;
                                            if (iMAPFolder.uidTable == null) {
                                                iMAPFolder.uidTable = new Hashtable();
                                            }
                                            i = i2;
                                            fetchResponse = fetchResponse2;
                                            iMAPFolder.uidTable.put(new Long(uid.uid), messageBySeqNumber);
                                        } else {
                                            i = i2;
                                            fetchResponse = fetchResponse2;
                                            if ((item instanceof RFC822DATA) || (item instanceof BODY)) {
                                                ByteArrayInputStream byteArrayInputStream = item instanceof RFC822DATA ? ((RFC822DATA) item).getByteArrayInputStream() : ((BODY) item).getByteArrayInputStream();
                                                InternetHeaders internetHeaders = new InternetHeaders();
                                                internetHeaders.load(byteArrayInputStream);
                                                if (messageBySeqNumber.headers == null || z2) {
                                                    messageBySeqNumber.headers = internetHeaders;
                                                } else {
                                                    Enumeration allHeaders = internetHeaders.getAllHeaders();
                                                    while (allHeaders.hasMoreElements()) {
                                                        Header header = (Header) allHeaders.nextElement();
                                                        if (!messageBySeqNumber.isHeaderLoaded(header.getName())) {
                                                            messageBySeqNumber.headers.addHeader(header.getName(), header.getValue());
                                                        }
                                                    }
                                                }
                                                if (z2) {
                                                    messageBySeqNumber.setHeadersLoaded(true);
                                                } else {
                                                    for (String str : headerNames) {
                                                        messageBySeqNumber.setHeaderLoaded(str);
                                                    }
                                                }
                                            }
                                        }
                                        i = i2;
                                        fetchResponse = fetchResponse2;
                                    } else if (!fetchProfile.contains(FetchProfile.Item.FLAGS) || messageBySeqNumber == null) {
                                        i = i2;
                                        fetchResponse = fetchResponse2;
                                        z3 = true;
                                    } else {
                                        messageBySeqNumber.flags = (Flags) item;
                                        i = i2;
                                        fetchResponse = fetchResponse2;
                                    }
                                    i3++;
                                    i2 = i;
                                    fetchResponse2 = fetchResponse;
                                }
                                if (z3) {
                                    vector.addElement(fetchResponse2);
                                }
                            } else {
                                vector.addElement(responseArrFetch[i2]);
                            }
                        }
                        i2++;
                    }
                    int size = vector.size();
                    if (size != 0) {
                        Response[] responseArr = new Response[size];
                        vector.copyInto(responseArr);
                        iMAPFolder.handleResponses(responseArr);
                    }
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isHeaderLoaded(String str) {
        if (this.headersLoaded) {
            return true;
        }
        Hashtable hashtable = this.loadedHeaders;
        return hashtable != null ? hashtable.containsKey(str.toUpperCase(Locale.ENGLISH)) : false;
    }

    private synchronized void loadBODYSTRUCTURE() throws MessagingException {
        if (this.f122bs != null) {
            return;
        }
        synchronized (getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    BODYSTRUCTURE bodystructureFetchBodyStructure = protocol.fetchBodyStructure(getSequenceNumber());
                    this.f122bs = bodystructureFetchBodyStructure;
                    if (bodystructureFetchBodyStructure == null) {
                        forceCheckExpunged();
                        throw new MessagingException("Unable to load BODYSTRUCTURE");
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void loadEnvelope() throws MessagingException {
        if (this.envelope != null) {
            return;
        }
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                int sequenceNumber = getSequenceNumber();
                Response[] responseArrFetch = protocol.fetch(sequenceNumber, EnvelopeCmd);
                for (int i = 0; i < responseArrFetch.length; i++) {
                    if (responseArrFetch[i] != null && (responseArrFetch[i] instanceof FetchResponse) && ((FetchResponse) responseArrFetch[i]).getNumber() == sequenceNumber) {
                        FetchResponse fetchResponse = (FetchResponse) responseArrFetch[i];
                        int itemCount = fetchResponse.getItemCount();
                        for (int i2 = 0; i2 < itemCount; i2++) {
                            Item item = fetchResponse.getItem(i2);
                            if (item instanceof ENVELOPE) {
                                this.envelope = (ENVELOPE) item;
                            } else if (item instanceof INTERNALDATE) {
                                this.receivedDate = ((INTERNALDATE) item).getDate();
                            } else if (item instanceof RFC822SIZE) {
                                this.size = ((RFC822SIZE) item).size;
                            }
                        }
                    }
                }
                protocol.notifyResponseHandlers(responseArrFetch);
                protocol.handleResult(responseArrFetch[responseArrFetch.length - 1]);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (this.envelope == null) {
            throw new MessagingException("Failed to load IMAP envelope");
        }
    }

    private synchronized void loadFlags() throws MessagingException {
        if (this.flags != null) {
            return;
        }
        synchronized (getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    this.flags = protocol.fetchFlags(getSequenceNumber());
                } catch (ProtocolException e) {
                    forceCheckExpunged();
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (ConnectionException e2) {
                throw new FolderClosedException(this.folder, e2.getMessage());
            }
        }
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (this.headersLoaded) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                if (protocol.isREV1()) {
                    BODY bodyPeekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER"));
                    if (bodyPeekBody != null) {
                        byteArrayInputStream = bodyPeekBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA rfc822dataFetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER");
                    if (rfc822dataFetchRFC822 != null) {
                        byteArrayInputStream = rfc822dataFetchRFC822.getByteArrayInputStream();
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            throw new MessagingException("Cannot load header");
        }
        this.headers = new InternetHeaders(byteArrayInputStream);
        this.headersLoaded = true;
    }

    private synchronized void setHeaderLoaded(String str) {
        if (this.loadedHeaders == null) {
            this.loadedHeaders = new Hashtable(1);
        }
        this.loadedHeaders.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    private synchronized void setHeadersLoaded(boolean z) {
        this.headersLoaded = z;
    }

    private String toSection(String str) {
        String str2 = this.sectionId;
        if (str2 == null) {
            return str;
        }
        return String.valueOf(str2) + "." + str;
    }

    public Session _getSession() {
        return this.session;
    }

    public void _setFlags(Flags flags) {
        this.flags = flags;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void checkExpunged() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    public void forceCheckExpunged() throws FolderClosedException, MessageRemovedException {
        synchronized (getMessageCacheLock()) {
            try {
                getProtocol().noop();
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException unused) {
            }
        }
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f122bs.f123id;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        String[] strArr = this.f122bs.language;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f122bs.md5;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        boolean peek = getPeek();
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                if (protocol.isREV1()) {
                    if (getFetchBlockSize() != -1) {
                        String section = toSection("TEXT");
                        BODYSTRUCTURE bodystructure = this.f122bs;
                        return new IMAPInputStream(this, section, bodystructure != null ? bodystructure.size : -1, peek);
                    }
                }
                if (protocol.isREV1()) {
                    BODY bodyPeekBody = peek ? protocol.peekBody(getSequenceNumber(), toSection("TEXT")) : protocol.fetchBody(getSequenceNumber(), toSection("TEXT"));
                    if (bodyPeekBody != null) {
                        byteArrayInputStream = bodyPeekBody.getByteArrayInputStream();
                    } else {
                        byteArrayInputStream = null;
                    }
                } else {
                    RFC822DATA rfc822dataFetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "TEXT");
                    if (rfc822dataFetchRFC822 != null) {
                        byteArrayInputStream = rfc822dataFetchRFC822.getByteArrayInputStream();
                    } else {
                        byteArrayInputStream = null;
                    }
                }
                if (byteArrayInputStream != null) {
                    return byteArrayInputStream;
                }
                throw new MessagingException("No content");
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getContentType() throws MessagingException {
        checkExpunged();
        if (this.type == null) {
            loadBODYSTRUCTURE();
            BODYSTRUCTURE bodystructure = this.f122bs;
            this.type = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
        }
        return this.type;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        String str;
        checkExpunged();
        if (this.f867dh == null) {
            loadBODYSTRUCTURE();
            if (this.type == null) {
                BODYSTRUCTURE bodystructure = this.f122bs;
                this.type = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
            }
            if (this.f122bs.isMulti()) {
                this.f867dh = new DataHandler(new IMAPMultipartDataSource(this, this.f122bs.bodies, this.sectionId, this));
            } else if (this.f122bs.isNested() && isREV1()) {
                BODYSTRUCTURE bodystructure2 = this.f122bs;
                BODYSTRUCTURE bodystructure3 = bodystructure2.bodies[0];
                ENVELOPE envelope = bodystructure2.envelope;
                String str2 = this.sectionId;
                if (str2 == null) {
                    str = DiskLruCache.VERSION_1;
                } else {
                    str = String.valueOf(str2) + ".1";
                }
                this.f867dh = new DataHandler(new IMAPNestedMessage(this, bodystructure3, envelope, str), this.type);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDescription() throws MessagingException {
        checkExpunged();
        String str = this.description;
        if (str != null) {
            return str;
        }
        loadBODYSTRUCTURE();
        String str2 = this.f122bs.description;
        if (str2 == null) {
            return null;
        }
        try {
            this.description = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.description = this.f122bs.description;
        }
        return this.description;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDisposition() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f122bs.disposition;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f122bs.encoding;
    }

    public int getFetchBlockSize() {
        return ((IMAPStore) this.folder.getStore()).getFetchBlockSize();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getFileName() throws MessagingException {
        ParameterList parameterList;
        checkExpunged();
        loadBODYSTRUCTURE();
        ParameterList parameterList2 = this.f122bs.dParams;
        String str = parameterList2 != null ? parameterList2.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME) : null;
        return (str != null || (parameterList = this.f122bs.cParams) == null) ? str : parameterList.get("name");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized Flags getFlags() throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.getFlags();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getFrom() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return aaclone(this.envelope.from);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006b  */
    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        checkExpunged();
        if (isHeaderLoaded(str)) {
            return this.headers.getHeader(str);
        }
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                if (protocol.isREV1()) {
                    BODY bodyPeekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER.FIELDS (" + str + ")"));
                    if (bodyPeekBody != null) {
                        byteArrayInputStream = bodyPeekBody.getByteArrayInputStream();
                    } else {
                        byteArrayInputStream = null;
                    }
                } else {
                    RFC822DATA rfc822dataFetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER.LINES (" + str + ")");
                    if (rfc822dataFetchRFC822 != null) {
                        byteArrayInputStream = rfc822dataFetchRFC822.getByteArrayInputStream();
                    } else {
                        byteArrayInputStream = null;
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            return null;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        this.headers.load(byteArrayInputStream);
        setHeaderLoaded(str);
        return this.headers.getHeader(str);
    }

    public String getInReplyTo() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return this.envelope.inReplyTo;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getLineCount() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f122bs.lines;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    public Object getMessageCacheLock() {
        return ((IMAPFolder) this.folder).messageCacheLock;
    }

    @Override // javax.mail.internet.MimeMessage
    public String getMessageID() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return this.envelope.messageId;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    public synchronized boolean getPeek() {
        return this.peek;
    }

    public IMAPProtocol getProtocol() throws ProtocolException, FolderClosedException {
        ((IMAPFolder) this.folder).waitIfIdle();
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol;
        }
        throw new FolderClosedException(this.folder);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getReceivedDate() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.receivedDate == null) {
            return null;
        }
        return new Date(this.receivedDate.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (recipientType == Message.RecipientType.f862TO) {
            return aaclone(this.envelope.f125to);
        }
        if (recipientType == Message.RecipientType.f861CC) {
            return aaclone(this.envelope.f124cc);
        }
        return recipientType == Message.RecipientType.BCC ? aaclone(this.envelope.bcc) : super.getRecipients(recipientType);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getReplyTo() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return aaclone(this.envelope.replyTo);
    }

    @Override // javax.mail.internet.MimeMessage
    public Address getSender() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        InternetAddress[] internetAddressArr = this.envelope.sender;
        if (internetAddressArr != null) {
            return internetAddressArr[0];
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getSentDate() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.envelope.date == null) {
            return null;
        }
        return new Date(this.envelope.date.getTime());
    }

    public int getSequenceNumber() {
        return this.seqnum;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        checkExpunged();
        if (this.size == -1) {
            loadEnvelope();
        }
        return this.size;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public String getSubject() throws MessagingException {
        checkExpunged();
        String str = this.subject;
        if (str != null) {
            return str;
        }
        loadEnvelope();
        String str2 = this.envelope.subject;
        if (str2 == null) {
            return null;
        }
        try {
            this.subject = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.subject = this.envelope.subject;
        }
        return this.subject;
    }

    public long getUID() {
        return this.uid;
    }

    public synchronized void invalidateHeaders() {
        this.headersLoaded = false;
        this.loadedHeaders = null;
        this.envelope = null;
        this.f122bs = null;
        this.receivedDate = null;
        this.size = -1;
        this.type = null;
        this.subject = null;
        this.description = null;
    }

    public boolean isREV1() throws FolderClosedException {
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol.isREV1();
        }
        throw new FolderClosedException(this.folder);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.isSet(flag);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.Message
    public void setExpunged(boolean z) {
        super.setExpunged(z);
        this.seqnum = -1;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z) throws MessagingException {
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                protocol.storeFlags(getSequenceNumber(), flags, z);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.Message
    public void setMessageNumber(int i) {
        super.setMessageNumber(i);
    }

    public synchronized void setPeek(boolean z) {
        this.peek = z;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setSequenceNumber(int i) {
        this.seqnum = i;
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setUID(long j) {
        this.uid = j;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws MessagingException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        boolean peek = getPeek();
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                byteArrayInputStream = null;
                if (protocol.isREV1()) {
                    BODY bodyPeekBody = peek ? protocol.peekBody(getSequenceNumber(), this.sectionId) : protocol.fetchBody(getSequenceNumber(), this.sectionId);
                    if (bodyPeekBody != null) {
                        byteArrayInputStream = bodyPeekBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA rfc822dataFetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), null);
                    if (rfc822dataFetchRFC822 != null) {
                        byteArrayInputStream = rfc822dataFetchRFC822.getByteArrayInputStream();
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            throw new MessagingException("No content");
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int i = byteArrayInputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public IMAPMessage(Session session) {
        super(session);
        this.size = -1;
        this.uid = -1L;
        this.headersLoaded = false;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        checkExpunged();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }
}
