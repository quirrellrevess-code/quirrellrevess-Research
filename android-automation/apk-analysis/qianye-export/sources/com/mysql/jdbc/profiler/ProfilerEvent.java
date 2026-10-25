package com.mysql.jdbc.profiler;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.StringUtils;
import com.sun.mail.pop3.POP3Message;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ProfilerEvent {
    public static final byte TYPE_EXECUTE = 4;
    public static final byte TYPE_FETCH = 5;
    public static final byte TYPE_OBJECT_CREATION = 1;
    public static final byte TYPE_PREPARE = 2;
    public static final byte TYPE_QUERY = 3;
    public static final byte TYPE_SLOW_QUERY = 6;
    public static final byte TYPE_WARN = 0;
    public String catalog;
    public int catalogIndex;
    public long connectionId;
    public String durationUnits;
    public String eventCreationPointDesc;
    public int eventCreationPointIndex;
    public long eventCreationTime;
    public long eventDuration;
    public byte eventType;
    public String hostName;
    public int hostNameIndex;
    public String message;
    public int resultSetId;
    public int statementId;

    public ProfilerEvent(byte b, String str, String str2, long j, int i, int i2, long j2, long j3, String str3, String str4, String str5, String str6) {
        this.eventType = b;
        this.connectionId = j;
        this.statementId = i;
        this.resultSetId = i2;
        this.eventCreationTime = j2;
        this.eventDuration = j3;
        this.durationUnits = str3;
        this.eventCreationPointDesc = str4;
        this.message = str6;
    }

    private static byte[] readBytes(byte[] bArr, int i) {
        int i2 = readInt(bArr, i);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i + 4, bArr2, 0, i2);
        return bArr2;
    }

    private static int readInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN) | ((bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
        int i5 = i3 + 1;
        return ((bArr[i5] & StatementImpl.USES_VARIABLES_UNKNOWN) << 24) | i4 | ((bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16);
    }

    private static long readLong(byte[] bArr, int i) {
        int i2 = i + 1;
        long j = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | (((long) (bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 8) | (((long) (bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 16);
        int i5 = i4 + 1;
        long j3 = j2 | (((long) (bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 24);
        int i6 = i5 + 1;
        long j4 = j3 | (((long) (bArr[i5] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 32);
        int i7 = i6 + 1;
        long j5 = j4 | (((long) (bArr[i6] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 40);
        return (((long) (bArr[i7 + 1] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 56) | j5 | (((long) (bArr[i7] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 48);
    }

    public static ProfilerEvent unpack(byte[] bArr) throws Exception {
        byte b = bArr[0];
        long j = readInt(bArr, 1);
        int i = readInt(bArr, 9);
        int i2 = readInt(bArr, 13);
        long j2 = readLong(bArr, 17);
        long j3 = readLong(bArr, 25);
        byte[] bytes = readBytes(bArr, 29);
        int length = bytes != null ? 33 + bytes.length : 33;
        readInt(bArr, length);
        int i3 = length + 4;
        byte[] bytes2 = readBytes(bArr, i3);
        int length2 = i3 + 4;
        if (bytes2 != null) {
            length2 += bytes2.length;
        }
        byte[] bytes3 = readBytes(bArr, length2);
        if (bytes3 != null) {
            int length3 = bytes3.length;
        }
        return new ProfilerEvent(b, BuildConfig.FLAVOR, BuildConfig.FLAVOR, j, i, i2, j2, j3, StringUtils.toString(bytes, "ISO8859_1"), StringUtils.toString(bytes2, "ISO8859_1"), null, StringUtils.toString(bytes3, "ISO8859_1"));
    }

    private static int writeBytes(byte[] bArr, byte[] bArr2, int i) {
        int iWriteInt = writeInt(bArr.length, bArr2, i);
        System.arraycopy(bArr, 0, bArr2, iWriteInt, bArr.length);
        return iWriteInt + bArr.length;
    }

    private static int writeInt(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i >>> 24);
        return i6;
    }

    private static int writeLong(long j, byte[] bArr, int i) {
        int i2 = i + 1;
        bArr[i] = (byte) (255 & j);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >>> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >>> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >>> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >>> 40);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j >>> 48);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (j >>> 56);
        return i9;
    }

    public String getCatalog() {
        return this.catalog;
    }

    public long getConnectionId() {
        return this.connectionId;
    }

    public String getDurationUnits() {
        return this.durationUnits;
    }

    public String getEventCreationPointAsString() {
        return this.eventCreationPointDesc;
    }

    public long getEventCreationTime() {
        return this.eventCreationTime;
    }

    public long getEventDuration() {
        return this.eventDuration;
    }

    public byte getEventType() {
        return this.eventType;
    }

    public String getMessage() {
        return this.message;
    }

    public int getResultSetId() {
        return this.resultSetId;
    }

    public int getStatementId() {
        return this.statementId;
    }

    public byte[] pack() throws Exception {
        int length;
        byte[] bytes;
        int length2;
        int length3;
        byte[] bytes2;
        getEventCreationPointAsString();
        String str = this.eventCreationPointDesc;
        byte[] bytes3 = null;
        if (str != null) {
            bytes = StringUtils.getBytes(str, "ISO8859_1");
            length = bytes.length + 4 + 29;
        } else {
            length = 33;
            bytes = null;
        }
        String str2 = this.message;
        if (str2 != null) {
            bytes3 = StringUtils.getBytes(str2, "ISO8859_1");
            length2 = length + bytes3.length + 4;
        } else {
            length2 = length + 4;
        }
        String str3 = this.durationUnits;
        if (str3 != null) {
            bytes2 = StringUtils.getBytes(str3, "ISO8859_1");
            length3 = length2 + bytes2.length + 4;
        } else {
            length3 = length2 + 4;
            bytes2 = StringUtils.getBytes(BuildConfig.FLAVOR, "ISO8859_1");
        }
        byte[] bArr = new byte[length3];
        bArr[0] = this.eventType;
        int iWriteInt = writeInt(this.eventCreationPointIndex, bArr, writeBytes(bytes2, bArr, writeLong(this.eventDuration, bArr, writeLong(this.eventCreationTime, bArr, writeInt(this.resultSetId, bArr, writeInt(this.statementId, bArr, writeLong(this.connectionId, bArr, 1)))))));
        int iWriteBytes = bytes != null ? writeBytes(bytes, bArr, iWriteInt) : writeInt(0, bArr, iWriteInt);
        if (bytes3 != null) {
            writeBytes(bytes3, bArr, iWriteBytes);
        } else {
            writeInt(0, bArr, iWriteBytes);
        }
        return bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        switch (this.eventType) {
            case 0:
                sb.append("WARN");
                break;
            case 1:
                sb.append("CONSTRUCT");
                break;
            case 2:
                sb.append("PREPARE");
                break;
            case 3:
                sb.append("QUERY");
                break;
            case 4:
                sb.append("EXECUTE");
                break;
            case 5:
                sb.append("FETCH");
                break;
            case 6:
                sb.append("SLOW QUERY");
                break;
            default:
                sb.append(POP3Message.UNKNOWN);
                break;
        }
        sb.append(" created: ");
        sb.append(new Date(this.eventCreationTime));
        sb.append(" duration: ");
        sb.append(this.eventDuration);
        sb.append(" connection: ");
        sb.append(this.connectionId);
        sb.append(" statement: ");
        sb.append(this.statementId);
        sb.append(" resultset: ");
        sb.append(this.resultSetId);
        if (this.message != null) {
            sb.append(" message: ");
            sb.append(this.message);
        }
        if (this.eventCreationPointDesc != null) {
            sb.append("\n\nEvent Created at:\n");
            sb.append(this.eventCreationPointDesc);
        }
        return sb.toString();
    }
}
