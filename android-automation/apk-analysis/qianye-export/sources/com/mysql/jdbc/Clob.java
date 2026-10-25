package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class Clob implements java.sql.Clob, OutputStreamWatcher, WriterWatcher {
    private String charData;
    private ExceptionInterceptor exceptionInterceptor;

    public Clob(ExceptionInterceptor exceptionInterceptor) {
        this.charData = BuildConfig.FLAVOR;
        this.exceptionInterceptor = exceptionInterceptor;
    }

    @Override // java.sql.Clob
    public void free() throws SQLException {
        this.charData = null;
    }

    @Override // java.sql.Clob
    public InputStream getAsciiStream() throws SQLException {
        if (this.charData != null) {
            return new ByteArrayInputStream(StringUtils.getBytes(this.charData));
        }
        return null;
    }

    @Override // java.sql.Clob
    public Reader getCharacterStream() throws SQLException {
        if (this.charData != null) {
            return new StringReader(this.charData);
        }
        return null;
    }

    @Override // java.sql.Clob
    public String getSubString(long j, int i) throws SQLException {
        if (j < 1) {
            throw SQLError.createSQLException(Messages.getString("Clob.6"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        int i2 = ((int) j) - 1;
        int i3 = i + i2;
        String str = this.charData;
        if (str == null) {
            return null;
        }
        if (i3 <= str.length()) {
            return this.charData.substring(i2, i3);
        }
        throw SQLError.createSQLException(Messages.getString("Clob.7"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
    }

    @Override // java.sql.Clob
    public long length() throws SQLException {
        String str = this.charData;
        if (str != null) {
            return str.length();
        }
        return 0L;
    }

    @Override // java.sql.Clob
    public long position(java.sql.Clob clob, long j) throws SQLException {
        return position(clob.getSubString(1L, (int) clob.length()), j);
    }

    @Override // java.sql.Clob
    public OutputStream setAsciiStream(long j) throws SQLException {
        if (j < 1) {
            throw SQLError.createSQLException(Messages.getString("Clob.0"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        WatchableOutputStream watchableOutputStream = new WatchableOutputStream();
        watchableOutputStream.setWatcher(this);
        if (j > 0) {
            watchableOutputStream.write(StringUtils.getBytes(this.charData), 0, (int) (j - 1));
        }
        return watchableOutputStream;
    }

    @Override // java.sql.Clob
    public Writer setCharacterStream(long j) throws SQLException {
        if (j < 1) {
            throw SQLError.createSQLException(Messages.getString("Clob.1"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        WatchableWriter watchableWriter = new WatchableWriter();
        watchableWriter.setWatcher(this);
        if (j > 1) {
            watchableWriter.write(this.charData, 0, (int) (j - 1));
        }
        return watchableWriter;
    }

    @Override // java.sql.Clob
    public int setString(long j, String str) throws SQLException {
        if (j < 1) {
            throw SQLError.createSQLException(Messages.getString("Clob.2"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        if (str == null) {
            throw SQLError.createSQLException(Messages.getString("Clob.3"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        StringBuilder sb = new StringBuilder(this.charData);
        long j2 = j - 1;
        int length = str.length();
        sb.replace((int) j2, (int) (j2 + ((long) length)), str);
        this.charData = sb.toString();
        return length;
    }

    @Override // com.mysql.jdbc.OutputStreamWatcher
    public void streamClosed(WatchableOutputStream watchableOutputStream) {
        int size = watchableOutputStream.size();
        if (size < this.charData.length()) {
            try {
                watchableOutputStream.write(StringUtils.getBytes(this.charData, (String) null, (String) null, false, (MySQLConnection) null, this.exceptionInterceptor), size, this.charData.length() - size);
            } catch (SQLException unused) {
            }
        }
        this.charData = StringUtils.toAsciiString(watchableOutputStream.toByteArray());
    }

    @Override // java.sql.Clob
    public void truncate(long j) throws SQLException {
        if (j <= this.charData.length()) {
            this.charData = this.charData.substring(0, (int) j);
            return;
        }
        throw SQLError.createSQLException(Messages.getString("Clob.11") + this.charData.length() + Messages.getString("Clob.12") + j + Messages.getString("Clob.13"), this.exceptionInterceptor);
    }

    public void writerClosed(char[] cArr) {
        this.charData = new String(cArr);
    }

    @Override // java.sql.Clob
    public long position(String str, long j) throws SQLException {
        if (j < 1) {
            throw SQLError.createSQLException(Messages.getString("Clob.8") + j + Messages.getString("Clob.9"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        String str2 = this.charData;
        if (str2 == null) {
            return -1L;
        }
        long j2 = j - 1;
        if (j2 > str2.length()) {
            throw SQLError.createSQLException(Messages.getString("Clob.10"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        int iIndexOf = this.charData.indexOf(str, (int) j2);
        if (iIndexOf == -1) {
            return -1L;
        }
        return iIndexOf + 1;
    }

    @Override // com.mysql.jdbc.WriterWatcher
    public void writerClosed(WatchableWriter watchableWriter) {
        int size = watchableWriter.size();
        if (size < this.charData.length()) {
            String str = this.charData;
            watchableWriter.write(str, size, str.length() - size);
        }
        this.charData = watchableWriter.toString();
    }

    @Override // java.sql.Clob
    public Reader getCharacterStream(long j, long j2) throws SQLException {
        return new StringReader(getSubString(j, (int) j2));
    }

    public Clob(String str, ExceptionInterceptor exceptionInterceptor) {
        this.charData = str;
        this.exceptionInterceptor = exceptionInterceptor;
    }

    @Override // java.sql.Clob
    public int setString(long j, String str, int i, int i2) throws SQLException {
        if (j < 1) {
            throw SQLError.createSQLException(Messages.getString("Clob.4"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
        if (str != null) {
            StringBuilder sb = new StringBuilder(this.charData);
            long j2 = j - 1;
            try {
                String strSubstring = str.substring(i, i + i2);
                sb.replace((int) j2, (int) (j2 + ((long) strSubstring.length())), strSubstring);
                this.charData = sb.toString();
                return i2;
            } catch (StringIndexOutOfBoundsException e) {
                throw SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, e, this.exceptionInterceptor);
            }
        }
        throw SQLError.createSQLException(Messages.getString("Clob.5"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
    }
}
