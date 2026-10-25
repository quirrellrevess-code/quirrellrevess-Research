package com.mysql.jdbc;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class Buffer {
    public static final int MAX_BYTES_TO_DUMP = 512;
    public static final int NO_LENGTH_LIMIT = -1;
    public static final long NULL_LENGTH = -1;
    public static final short TYPE_ID_AUTH_SWITCH = 254;
    public static final short TYPE_ID_EOF = 254;
    public static final short TYPE_ID_ERROR = 255;
    public static final short TYPE_ID_LOCAL_INFILE = 251;
    public static final short TYPE_ID_OK = 0;
    private int bufLength;
    private byte[] byteBuffer;
    private int position;
    public boolean wasMultiPacket;

    public Buffer(byte[] bArr) {
        this.bufLength = 0;
        this.position = 0;
        this.wasMultiPacket = false;
        this.byteBuffer = bArr;
        setBufLength(bArr.length);
    }

    public final void clear() {
        this.position = 4;
    }

    public final void dump() {
        dump(getBufLength());
    }

    public final String dumpClampedBytes(int i) {
        int i2 = i < 512 ? i : 512;
        String strDumpAsHex = StringUtils.dumpAsHex(getBytes(0, i2 > getBufLength() ? getBufLength() : i2), i2 > getBufLength() ? getBufLength() : i2);
        if (i2 >= i) {
            return strDumpAsHex;
        }
        return strDumpAsHex + " ....(packet exceeds max. dump length)";
    }

    public final void dumpHeader() {
        for (int i = 0; i < 4; i++) {
            String hexString = Integer.toHexString(readByte(i) & StatementImpl.USES_VARIABLES_UNKNOWN);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            System.out.print(hexString + " ");
        }
    }

    public final void dumpNBytes(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i + i2 && i3 < getBufLength(); i3++) {
            String hexString = Integer.toHexString(readByte(i3) & StatementImpl.USES_VARIABLES_UNKNOWN);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            System.out.print(hexString + " ");
            if (readByte(i3) <= 32 || readByte(i3) >= 127) {
                sb.append(".");
            } else {
                sb.append((char) readByte(i3));
            }
            sb.append(" ");
        }
        System.out.println("    " + sb.toString());
    }

    public final void ensureCapacity(int i) throws SQLException {
        if (this.position + i > getBufLength()) {
            int i2 = this.position + i;
            byte[] bArr = this.byteBuffer;
            if (i2 < bArr.length) {
                setBufLength(bArr.length);
                return;
            }
            int length = (int) (((double) bArr.length) * 1.25d);
            if (length < bArr.length + i) {
                length = bArr.length + ((int) (((double) i) * 1.25d));
            }
            if (length < bArr.length) {
                length = bArr.length + i;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.byteBuffer = bArr2;
            setBufLength(bArr2.length);
        }
    }

    public void fastSkipLenByteArray() {
        long fieldLength = readFieldLength();
        if (fieldLength == -1 || fieldLength == 0) {
            return;
        }
        this.position = (int) (((long) this.position) + fieldLength);
    }

    public int fastSkipLenString() {
        long fieldLength = readFieldLength();
        this.position = (int) (((long) this.position) + fieldLength);
        return (int) fieldLength;
    }

    public int getBufLength() {
        return this.bufLength;
    }

    public final byte[] getBufferSource() {
        return this.byteBuffer;
    }

    public byte[] getByteBuffer() {
        return this.byteBuffer;
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.byteBuffer, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public int getCapacity() {
        return this.byteBuffer.length;
    }

    public ByteBuffer getNioBuffer() {
        throw new IllegalArgumentException(Messages.getString("ByteArrayBuffer.0"));
    }

    public int getPosition() {
        return this.position;
    }

    public final boolean isAuthMethodSwitchRequestPacket() {
        return (this.byteBuffer[0] & StatementImpl.USES_VARIABLES_UNKNOWN) == 254;
    }

    public final boolean isEOFPacket() {
        return (this.byteBuffer[0] & StatementImpl.USES_VARIABLES_UNKNOWN) == 254 && getBufLength() <= 5;
    }

    public final boolean isOKPacket() {
        return (this.byteBuffer[0] & StatementImpl.USES_VARIABLES_UNKNOWN) == 0;
    }

    public final boolean isRawPacket() {
        return (this.byteBuffer[0] & StatementImpl.USES_VARIABLES_UNKNOWN) == 1;
    }

    public final boolean isResultSetOKPacket() {
        return (this.byteBuffer[0] & StatementImpl.USES_VARIABLES_UNKNOWN) == 254 && getBufLength() < 16777215;
    }

    public final long newReadLength() {
        int longInt;
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        switch (i2) {
            case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                return 0L;
            case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                longInt = readInt();
                break;
            case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                longInt = readLongInt();
                break;
            case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                return readLongLong();
            default:
                return i2;
        }
        return longInt;
    }

    public final byte readByte() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final long readFieldLength() {
        int longInt;
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        switch (i2) {
            case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                return -1L;
            case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                longInt = readInt();
                break;
            case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                longInt = readLongInt();
                break;
            case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                return readLongLong();
            default:
                return i2;
        }
        return longInt;
    }

    public final int readInt() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        this.position = i2 + 1;
        return ((bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8) | i3;
    }

    public final int readIntAsLong() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        int i4 = i2 + 1;
        this.position = i4;
        int i5 = i3 | ((bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
        int i6 = i4 + 1;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16);
        this.position = i6 + 1;
        return ((bArr[i6] & StatementImpl.USES_VARIABLES_UNKNOWN) << 24) | i7;
    }

    public final byte[] readLenByteArray(int i) {
        long fieldLength = readFieldLength();
        if (fieldLength == -1) {
            return null;
        }
        if (fieldLength == 0) {
            return Constants.EMPTY_BYTE_ARRAY;
        }
        this.position += i;
        return getBytes((int) fieldLength);
    }

    public final long readLength() {
        int longInt;
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        switch (i2) {
            case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                return 0L;
            case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                longInt = readInt();
                break;
            case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                longInt = readLongInt();
                break;
            case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                return readLong();
            default:
                return i2;
        }
        return longInt;
    }

    public final long readLong() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        this.position = i3;
        long j2 = j | ((255 & ((long) bArr[i2])) << 8);
        int i4 = i3 + 1;
        this.position = i4;
        long j3 = j2 | (((long) (bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 16);
        this.position = i4 + 1;
        return j3 | (((long) (bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 24);
    }

    public final int readLongInt() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        int i4 = i2 + 1;
        this.position = i4;
        int i5 = i3 | ((bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) << 8);
        this.position = i4 + 1;
        return ((bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN) << 16) | i5;
    }

    public final long readLongLong() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        int i3 = i2 + 1;
        this.position = i3;
        long j2 = j | (((long) (bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 8);
        int i4 = i3 + 1;
        this.position = i4;
        long j3 = j2 | (((long) (bArr[i3] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 16);
        int i5 = i4 + 1;
        this.position = i5;
        long j4 = j3 | (((long) (bArr[i4] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 24);
        int i6 = i5 + 1;
        this.position = i6;
        long j5 = j4 | (((long) (bArr[i5] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 32);
        int i7 = i6 + 1;
        this.position = i7;
        long j6 = j5 | (((long) (bArr[i6] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 40);
        int i8 = i7 + 1;
        this.position = i8;
        long j7 = j6 | (((long) (bArr[i7] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 48);
        this.position = i8 + 1;
        return j7 | (((long) (bArr[i8] & StatementImpl.USES_VARIABLES_UNKNOWN)) << 56);
    }

    public final String readString() {
        int bufLength = getBufLength();
        int i = 0;
        for (int i2 = this.position; i2 < bufLength && this.byteBuffer[i2] != 0; i2++) {
            i++;
        }
        String string = StringUtils.toString(this.byteBuffer, this.position, i);
        this.position += i + 1;
        return string;
    }

    public final int readnBytes() {
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
        if (i3 == 1) {
            this.position = i2 + 1;
            return bArr[i2] & StatementImpl.USES_VARIABLES_UNKNOWN;
        }
        if (i3 == 2) {
            return readInt();
        }
        if (i3 == 3) {
            return readLongInt();
        }
        if (i3 != 4) {
            return 255;
        }
        return (int) readLong();
    }

    public void setBufLength(int i) {
        this.bufLength = i;
    }

    public void setByteBuffer(byte[] bArr) {
        this.byteBuffer = bArr;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setWasMultiPacket(boolean z) {
        this.wasMultiPacket = z;
    }

    public String toString() {
        return dumpClampedBytes(getPosition());
    }

    public String toSuperString() {
        return super.toString();
    }

    public boolean wasMultiPacket() {
        return this.wasMultiPacket;
    }

    public final void writeByte(byte b) throws SQLException {
        ensureCapacity(1);
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final void writeBytesNoNull(byte[] bArr) throws SQLException {
        int length = bArr.length;
        ensureCapacity(length);
        System.arraycopy(bArr, 0, this.byteBuffer, this.position, length);
        this.position += length;
    }

    public final void writeDouble(double d) throws SQLException {
        writeLongLong(Double.doubleToLongBits(d));
    }

    public final void writeFieldLength(long j) throws SQLException {
        if (j < 251) {
            writeByte((byte) j);
            return;
        }
        if (j < 65536) {
            ensureCapacity(3);
            writeByte((byte) -4);
            writeInt((int) j);
        } else if (j < 16777216) {
            ensureCapacity(4);
            writeByte((byte) -3);
            writeLongInt((int) j);
        } else {
            ensureCapacity(9);
            writeByte((byte) -2);
            writeLongLong(j);
        }
    }

    public final void writeFloat(float f) throws SQLException {
        ensureCapacity(4);
        int iFloatToIntBits = Float.floatToIntBits(f);
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) (iFloatToIntBits & 255);
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (iFloatToIntBits >>> 8);
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (iFloatToIntBits >>> 16);
        this.position = i4 + 1;
        bArr[i4] = (byte) (iFloatToIntBits >>> 24);
    }

    public final void writeInt(int i) throws SQLException {
        ensureCapacity(2);
        byte[] bArr = this.byteBuffer;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (i & 255);
        this.position = i3 + 1;
        bArr[i3] = (byte) (i >>> 8);
    }

    public final void writeLenBytes(byte[] bArr) throws SQLException {
        int length = bArr.length;
        ensureCapacity(length + 9);
        writeFieldLength(length);
        System.arraycopy(bArr, 0, this.byteBuffer, this.position, length);
        this.position += length;
    }

    public final void writeLenString(String str, String str2, String str3, SingleByteCharsetConverter singleByteCharsetConverter, boolean z, MySQLConnection mySQLConnection) throws SQLException, UnsupportedEncodingException {
        byte[] bytes = singleByteCharsetConverter != null ? singleByteCharsetConverter.toBytes(str) : StringUtils.getBytes(str, str2, str3, z, mySQLConnection, mySQLConnection.getExceptionInterceptor());
        int length = bytes.length;
        ensureCapacity(length + 9);
        writeFieldLength(length);
        System.arraycopy(bytes, 0, this.byteBuffer, this.position, length);
        this.position += length;
    }

    public final void writeLong(long j) throws SQLException {
        ensureCapacity(4);
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) (255 & j);
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (j >>> 8);
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (j >>> 16);
        this.position = i4 + 1;
        bArr[i4] = (byte) (j >>> 24);
    }

    public final void writeLongInt(int i) throws SQLException {
        ensureCapacity(3);
        byte[] bArr = this.byteBuffer;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (i >>> 8);
        this.position = i4 + 1;
        bArr[i4] = (byte) (i >>> 16);
    }

    public final void writeLongLong(long j) throws SQLException {
        ensureCapacity(8);
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) (255 & j);
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (j >>> 8);
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (j >>> 16);
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (j >>> 24);
        int i6 = i5 + 1;
        this.position = i6;
        bArr[i5] = (byte) (j >>> 32);
        int i7 = i6 + 1;
        this.position = i7;
        bArr[i6] = (byte) (j >>> 40);
        int i8 = i7 + 1;
        this.position = i8;
        bArr[i7] = (byte) (j >>> 48);
        this.position = i8 + 1;
        bArr[i8] = (byte) (j >>> 56);
    }

    public final void writeString(String str) throws SQLException {
        ensureCapacity((str.length() * 3) + 1);
        writeStringNoNull(str);
        byte[] bArr = this.byteBuffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = 0;
    }

    public final void writeStringNoNull(String str) throws SQLException {
        int length = str.length();
        ensureCapacity(length * 3);
        System.arraycopy(StringUtils.getBytes(str), 0, this.byteBuffer, this.position, length);
        this.position += length;
    }

    public final String dump(int i) {
        byte[] bytes = getBytes(0, i > getBufLength() ? getBufLength() : i);
        if (i > getBufLength()) {
            i = getBufLength();
        }
        return StringUtils.dumpAsHex(bytes, i);
    }

    public final byte readByte(int i) {
        return this.byteBuffer[i];
    }

    public byte[] getBytes(int i, int i2) {
        byte[] bArr = new byte[i2];
        System.arraycopy(this.byteBuffer, i, bArr, 0, i2);
        return bArr;
    }

    public final void writeString(String str, String str2, MySQLConnection mySQLConnection) throws SQLException {
        ensureCapacity((str.length() * 3) + 1);
        try {
            writeStringNoNull(str, str2, str2, false, mySQLConnection);
            byte[] bArr = this.byteBuffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = 0;
        } catch (UnsupportedEncodingException e) {
            throw new SQLException(e.toString(), SQLError.SQL_STATE_GENERAL_ERROR);
        }
    }

    public final void writeBytesNoNull(byte[] bArr, int i, int i2) throws SQLException {
        ensureCapacity(i2);
        System.arraycopy(bArr, i, this.byteBuffer, this.position, i2);
        this.position += i2;
    }

    public final void writeStringNoNull(String str, String str2, String str3, boolean z, MySQLConnection mySQLConnection) throws SQLException, UnsupportedEncodingException {
        byte[] bytes = StringUtils.getBytes(str, str2, str3, z, mySQLConnection, mySQLConnection.getExceptionInterceptor());
        int length = bytes.length;
        ensureCapacity(length);
        System.arraycopy(bytes, 0, this.byteBuffer, this.position, length);
        this.position += length;
    }

    public final String readString(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        int bufLength = getBufLength();
        int i = 0;
        for (int i2 = this.position; i2 < bufLength && this.byteBuffer[i2] != 0; i2++) {
            i++;
        }
        try {
            try {
                String string = StringUtils.toString(this.byteBuffer, this.position, i, str);
                this.position += i + 1;
                return string;
            } catch (UnsupportedEncodingException unused) {
                throw SQLError.createSQLException(Messages.getString("ByteArrayBuffer.1") + str + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
            }
        } catch (Throwable th) {
            this.position += i + 1;
            throw th;
        }
    }

    public Buffer(int i) {
        this.bufLength = 0;
        this.position = 0;
        this.wasMultiPacket = false;
        byte[] bArr = new byte[i];
        this.byteBuffer = bArr;
        setBufLength(bArr.length);
        this.position = 4;
    }

    public final String readString(String str, ExceptionInterceptor exceptionInterceptor, int i) throws SQLException {
        if (this.position + i <= getBufLength()) {
            try {
                try {
                    String string = StringUtils.toString(this.byteBuffer, this.position, i, str);
                    this.position += i;
                    return string;
                } catch (UnsupportedEncodingException unused) {
                    throw SQLError.createSQLException(Messages.getString("ByteArrayBuffer.1") + str + "'", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
                }
            } catch (Throwable th) {
                this.position += i;
                throw th;
            }
        }
        throw SQLError.createSQLException(Messages.getString("ByteArrayBuffer.2"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, exceptionInterceptor);
    }
}
