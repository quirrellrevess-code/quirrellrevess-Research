package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class BufferRow extends ResultSetRow {
    private int homePosition;
    private boolean isBinaryEncoded;
    private boolean[] isNull;
    private int lastRequestedIndex;
    private int lastRequestedPos;
    private Field[] metadata;
    private List<InputStream> openStreams;
    private int preNullBitmaskHomePosition;
    private Buffer rowFromServer;

    public BufferRow(Buffer buffer, Field[] fieldArr, boolean z, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        super(exceptionInterceptor);
        this.homePosition = 0;
        this.preNullBitmaskHomePosition = 0;
        this.lastRequestedIndex = -1;
        this.rowFromServer = buffer;
        this.metadata = fieldArr;
        this.isBinaryEncoded = z;
        int position = buffer.getPosition();
        this.homePosition = position;
        this.preNullBitmaskHomePosition = position;
        if (fieldArr != null) {
            setMetadata(fieldArr);
        }
    }

    private int findAndSeekToOffset(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return findAndSeekToOffsetForBinaryEncoding(i);
        }
        int i2 = 0;
        if (i == 0) {
            this.lastRequestedIndex = 0;
            int i3 = this.homePosition;
            this.lastRequestedPos = i3;
            this.rowFromServer.setPosition(i3);
            return 0;
        }
        int i4 = this.lastRequestedIndex;
        if (i == i4) {
            this.rowFromServer.setPosition(this.lastRequestedPos);
            return this.lastRequestedPos;
        }
        if (i > i4) {
            i2 = i4 >= 0 ? i4 : 0;
            this.rowFromServer.setPosition(this.lastRequestedPos);
        } else {
            this.rowFromServer.setPosition(this.homePosition);
        }
        while (i2 < i) {
            this.rowFromServer.fastSkipLenByteArray();
            i2++;
        }
        this.lastRequestedIndex = i;
        int position = this.rowFromServer.getPosition();
        this.lastRequestedPos = position;
        return position;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x00f2  */
    /* JADX WARN: Switch 'out' block B:41:0x00f2 for B:28:0x005e already processed. Defaulting to fallback option. */
    private int findAndSeekToOffsetForBinaryEncoding(int i) throws SQLException {
        int i2 = 0;
        if (i == 0) {
            this.lastRequestedIndex = 0;
            int i3 = this.homePosition;
            this.lastRequestedPos = i3;
            this.rowFromServer.setPosition(i3);
            return 0;
        }
        int i4 = this.lastRequestedIndex;
        if (i == i4) {
            this.rowFromServer.setPosition(this.lastRequestedPos);
            return this.lastRequestedPos;
        }
        if (i > i4) {
            if (i4 >= 0) {
                i2 = i4;
            } else {
                this.lastRequestedPos = this.homePosition;
            }
            this.rowFromServer.setPosition(this.lastRequestedPos);
        } else {
            this.rowFromServer.setPosition(this.homePosition);
        }
        while (i2 < i) {
            if (!this.isNull[i2]) {
                int position = this.rowFromServer.getPosition();
                int mysqlType = this.metadata[i2].getMysqlType();
                if (mysqlType != 15 && mysqlType != 16 && mysqlType != 245 && mysqlType != 246) {
                    switch (mysqlType) {
                        case 0:
                            this.rowFromServer.fastSkipLenByteArray();
                            break;
                        case 1:
                            this.rowFromServer.setPosition(position + 1);
                            continue;
                        case 2:
                        case 13:
                            this.rowFromServer.setPosition(position + 2);
                            continue;
                        case 3:
                        case 9:
                            this.rowFromServer.setPosition(position + 4);
                            continue;
                        case 4:
                            this.rowFromServer.setPosition(position + 4);
                            continue;
                        case 5:
                            this.rowFromServer.setPosition(position + 8);
                            continue;
                        case 6:
                            continue;
                        case 7:
                        case 12:
                            this.rowFromServer.fastSkipLenByteArray();
                            continue;
                        case 8:
                            this.rowFromServer.setPosition(position + 8);
                            continue;
                        case 10:
                            this.rowFromServer.fastSkipLenByteArray();
                            continue;
                        case 11:
                            this.rowFromServer.fastSkipLenByteArray();
                            continue;
                        default:
                            switch (mysqlType) {
                                case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
                                case 250:
                                case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                                case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                                case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                                case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                                case 255:
                                    this.rowFromServer.fastSkipLenByteArray();
                                    break;
                                default:
                                    throw SQLError.createSQLException(Messages.getString("MysqlIO.97") + this.metadata[i2].getMysqlType() + Messages.getString("MysqlIO.98") + (i2 + 1) + Messages.getString("MysqlIO.99") + this.metadata.length + Messages.getString("MysqlIO.100"), SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
                            }
                            break;
                    }
                } else {
                    this.rowFromServer.fastSkipLenByteArray();
                }
            }
            i2++;
        }
        this.lastRequestedIndex = i;
        int position2 = this.rowFromServer.getPosition();
        this.lastRequestedPos = position2;
        return position2;
    }

    private void setupIsNullBitmask() throws SQLException {
        if (this.isNull != null) {
            return;
        }
        this.rowFromServer.setPosition(this.preNullBitmaskHomePosition);
        int length = (this.metadata.length + 9) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = this.rowFromServer.readByte();
        }
        this.homePosition = this.rowFromServer.getPosition();
        this.isNull = new boolean[this.metadata.length];
        int i2 = 4;
        int i3 = 0;
        for (int i4 = 0; i4 < this.metadata.length; i4++) {
            this.isNull[i4] = (bArr[i3] & i2) != 0;
            i2 <<= 1;
            if ((i2 & 255) == 0) {
                i3++;
                i2 = 1;
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public synchronized void closeOpenStreams() {
        List<InputStream> list = this.openStreams;
        if (list != null) {
            Iterator<InputStream> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().close();
                } catch (IOException unused) {
                }
            }
            this.openStreams.clear();
        }
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public synchronized InputStream getBinaryInputStream(int i) throws SQLException {
        if (this.isBinaryEncoded && isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        int position = this.rowFromServer.getPosition();
        if (fieldLength == -1) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rowFromServer.getByteBuffer(), position, (int) fieldLength);
        if (this.openStreams == null) {
            this.openStreams = new LinkedList();
        }
        return byteArrayInputStream;
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public int getBytesSize() {
        return this.rowFromServer.getBufLength();
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public byte[] getColumnValue(int i) throws SQLException {
        findAndSeekToOffset(i);
        if (!this.isBinaryEncoded) {
            return this.rowFromServer.readLenByteArray(0);
        }
        if (this.isNull[i]) {
            return null;
        }
        int mysqlType = this.metadata[i].getMysqlType();
        if (mysqlType != 15 && mysqlType != 16 && mysqlType != 245 && mysqlType != 246) {
            switch (mysqlType) {
                case 0:
                case 7:
                case 10:
                case 11:
                case 12:
                    break;
                case 1:
                    return new byte[]{this.rowFromServer.readByte()};
                case 2:
                case 13:
                    return this.rowFromServer.getBytes(2);
                case 3:
                case 9:
                    return this.rowFromServer.getBytes(4);
                case 4:
                    return this.rowFromServer.getBytes(4);
                case 5:
                    return this.rowFromServer.getBytes(8);
                case 6:
                    return null;
                case 8:
                    return this.rowFromServer.getBytes(8);
                default:
                    switch (mysqlType) {
                        case MysqlDefs.FIELD_TYPE_TINY_BLOB /* 249 */:
                        case 250:
                        case MysqlDefs.FIELD_TYPE_LONG_BLOB /* 251 */:
                        case MysqlDefs.FIELD_TYPE_BLOB /* 252 */:
                        case MysqlDefs.FIELD_TYPE_VAR_STRING /* 253 */:
                        case MysqlDefs.FIELD_TYPE_STRING /* 254 */:
                        case 255:
                            break;
                        default:
                            throw SQLError.createSQLException(Messages.getString("MysqlIO.97") + this.metadata[i].getMysqlType() + Messages.getString("MysqlIO.98") + (i + 1) + Messages.getString("MysqlIO.99") + this.metadata.length + Messages.getString("MysqlIO.100"), SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
                    }
                    break;
            }
        }
        return this.rowFromServer.readLenByteArray(0);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Date getDateFast(int i, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, Calendar calendar) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getDateFast(i, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, mySQLConnection, resultSetImpl, calendar);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public int getInt(int i) throws SQLException {
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        int position = this.rowFromServer.getPosition();
        if (fieldLength == -1) {
            return 0;
        }
        return StringUtils.getInt(this.rowFromServer.getByteBuffer(), position, ((int) fieldLength) + position);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public long getLong(int i) throws SQLException {
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        int position = this.rowFromServer.getPosition();
        if (fieldLength == -1) {
            return 0L;
        }
        return StringUtils.getLong(this.rowFromServer.getByteBuffer(), position, ((int) fieldLength) + position);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Date getNativeDate(int i, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, Calendar calendar) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getNativeDate(i, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, mySQLConnection, resultSetImpl, calendar);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Object getNativeDateTimeValue(int i, Calendar calendar, int i2, int i3, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getNativeDateTimeValue(i, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, calendar, i2, i3, timeZone, z, mySQLConnection, resultSetImpl);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public double getNativeDouble(int i) throws SQLException {
        if (isNull(i)) {
            return 0.0d;
        }
        findAndSeekToOffset(i);
        return getNativeDouble(this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition());
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public float getNativeFloat(int i) throws SQLException {
        if (isNull(i)) {
            return 0.0f;
        }
        findAndSeekToOffset(i);
        return getNativeFloat(this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition());
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public int getNativeInt(int i) throws SQLException {
        if (isNull(i)) {
            return 0;
        }
        findAndSeekToOffset(i);
        return getNativeInt(this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition());
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public long getNativeLong(int i) throws SQLException {
        if (isNull(i)) {
            return 0L;
        }
        findAndSeekToOffset(i);
        return getNativeLong(this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition());
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public short getNativeShort(int i) throws SQLException {
        if (isNull(i)) {
            return (short) 0;
        }
        findAndSeekToOffset(i);
        return getNativeShort(this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition());
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Time getNativeTime(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getNativeTime(i, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, calendar, timeZone, z, mySQLConnection, resultSetImpl);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Timestamp getNativeTimestamp(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getNativeTimestamp(this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, calendar, timeZone, z, mySQLConnection, resultSetImpl);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Reader getReader(int i) throws SQLException {
        InputStream binaryInputStream = getBinaryInputStream(i);
        if (binaryInputStream == null) {
            return null;
        }
        try {
            return new InputStreamReader(binaryInputStream, this.metadata[i].getEncoding());
        } catch (UnsupportedEncodingException e) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(BuildConfig.FLAVOR, this.exceptionInterceptor);
            sQLExceptionCreateSQLException.initCause(e);
            throw sQLExceptionCreateSQLException;
        }
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public String getString(int i, String str, MySQLConnection mySQLConnection) throws SQLException {
        if (this.isBinaryEncoded && isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        if (fieldLength == -1) {
            return null;
        }
        if (fieldLength == 0) {
            return BuildConfig.FLAVOR;
        }
        return getString(str, mySQLConnection, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Time getTimeFast(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getTimeFast(i, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, calendar, timeZone, z, mySQLConnection, resultSetImpl);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public Timestamp getTimestampFast(int i, Calendar calendar, TimeZone timeZone, boolean z, MySQLConnection mySQLConnection, ResultSetImpl resultSetImpl, boolean z2, boolean z3) throws SQLException {
        if (isNull(i)) {
            return null;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        return getTimestampFast(i, this.rowFromServer.getByteBuffer(), this.rowFromServer.getPosition(), (int) fieldLength, calendar, timeZone, z, mySQLConnection, resultSetImpl, z2, z3);
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public boolean isFloatingPointNumber(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            int sQLType = this.metadata[i].getSQLType();
            return sQLType == 2 || sQLType == 3 || sQLType == 6 || sQLType == 8;
        }
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        if (fieldLength == -1 || fieldLength == 0) {
            return false;
        }
        int position = this.rowFromServer.getPosition();
        byte[] byteBuffer = this.rowFromServer.getByteBuffer();
        for (int i2 = 0; i2 < ((int) fieldLength); i2++) {
            char c = (char) byteBuffer[position + i2];
            if (c == 'e' || c == 'E') {
                return true;
            }
        }
        return false;
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public boolean isNull(int i) throws SQLException {
        if (this.isBinaryEncoded) {
            return this.isNull[i];
        }
        findAndSeekToOffset(i);
        return this.rowFromServer.readFieldLength() == -1;
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public long length(int i) throws SQLException {
        findAndSeekToOffset(i);
        long fieldLength = this.rowFromServer.readFieldLength();
        if (fieldLength == -1) {
            return 0L;
        }
        return fieldLength;
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public void setColumnValue(int i, byte[] bArr) throws SQLException {
        throw new OperationNotSupportedException();
    }

    @Override // com.mysql.jdbc.ResultSetRow
    public ResultSetRow setMetadata(Field[] fieldArr) throws SQLException {
        super.setMetadata(fieldArr);
        if (this.isBinaryEncoded) {
            setupIsNullBitmask();
        }
        return this;
    }
}
