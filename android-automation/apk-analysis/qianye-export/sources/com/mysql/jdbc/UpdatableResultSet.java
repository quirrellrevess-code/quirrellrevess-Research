package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class UpdatableResultSet extends ResultSetImpl {
    public static final byte[] STREAM_DATA_MARKER = StringUtils.getBytes("** STREAM DATA **");
    public SingleByteCharsetConverter charConverter;
    private String charEncoding;
    private Map<String, Map<String, Map<String, Integer>>> databasesUsedToTablesUsed;
    private byte[][] defaultColumnValue;
    private String deleteSQL;
    private PreparedStatement deleter;
    private boolean initializedCharConverter;
    private String insertSQL;
    public PreparedStatement inserter;
    private boolean isUpdatable;
    private String notUpdatableReason;
    private boolean populateInserterWithDefaultValues;
    private List<Integer> primaryKeyIndicies;
    private String qualifiedAndQuotedTableName;
    private String quotedIdChar;
    private String refreshSQL;
    private PreparedStatement refresher;
    private ResultSetRow savedCurrentRow;
    private String updateSQL;
    public PreparedStatement updater;

    public UpdatableResultSet(String str, Field[] fieldArr, RowData rowData, MySQLConnection mySQLConnection, StatementImpl statementImpl) throws SQLException {
        super(str, fieldArr, rowData, mySQLConnection, statementImpl);
        this.deleter = null;
        this.deleteSQL = null;
        this.initializedCharConverter = false;
        this.inserter = null;
        this.insertSQL = null;
        this.isUpdatable = false;
        this.notUpdatableReason = null;
        this.primaryKeyIndicies = null;
        this.quotedIdChar = null;
        this.refreshSQL = null;
        this.updater = null;
        this.updateSQL = null;
        this.populateInserterWithDefaultValues = false;
        this.databasesUsedToTablesUsed = null;
        checkUpdatability();
        this.populateInserterWithDefaultValues = this.connection.getPopulateInsertRowWithDefaultValues();
    }

    private void extractDefaultValues() throws SQLException {
        java.sql.DatabaseMetaData metaData = this.connection.getMetaData();
        this.defaultColumnValue = new byte[this.fields.length][];
        Iterator<Map.Entry<String, Map<String, Map<String, Integer>>>> it = this.databasesUsedToTablesUsed.entrySet().iterator();
        ResultSet columns = null;
        while (it.hasNext()) {
            for (Map.Entry<String, Map<String, Integer>> entry : it.next().getValue().entrySet()) {
                String key = entry.getKey();
                Map<String, Integer> value = entry.getValue();
                try {
                    columns = metaData.getColumns(this.catalog, null, key, "%");
                    while (columns.next()) {
                        String string = columns.getString("COLUMN_NAME");
                        byte[] bytes = columns.getBytes("COLUMN_DEF");
                        if (value.containsKey(string)) {
                            this.defaultColumnValue[value.get(string).intValue()] = bytes;
                        }
                    }
                    if (columns != null) {
                        columns.close();
                        columns = null;
                    }
                } catch (Throwable th) {
                    if (columns != null) {
                        columns.close();
                    }
                    throw th;
                }
            }
        }
    }

    private SingleByteCharsetConverter getCharConverter() throws SQLException {
        if (!this.initializedCharConverter) {
            this.initializedCharConverter = true;
            if (this.connection.getUseUnicode()) {
                this.charEncoding = this.connection.getEncoding();
                this.charConverter = this.connection.getCharsetConverter(this.charEncoding);
            }
        }
        return this.charConverter;
    }

    private Map<String, Integer> getColumnsToIndexMapForTableAndDB(String str, String str2) {
        Map<String, Map<String, Integer>> treeMap = this.databasesUsedToTablesUsed.get(str);
        if (treeMap == null) {
            treeMap = this.connection.lowerCaseTableNames() ? new TreeMap<>(String.CASE_INSENSITIVE_ORDER) : new TreeMap<>();
            this.databasesUsedToTablesUsed.put(str, treeMap);
        }
        Map<String, Integer> map = treeMap.get(str2);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        treeMap.put(str2, map2);
        return map2;
    }

    private String getQuotedIdChar() throws SQLException {
        if (this.quotedIdChar == null) {
            if (this.connection.supportsQuotedIdentifiers()) {
                this.quotedIdChar = this.connection.getMetaData().getIdentifierQuoteString();
            } else {
                this.quotedIdChar = BuildConfig.FLAVOR;
            }
        }
        return this.quotedIdChar;
    }

    private void resetInserter() throws SQLException {
        this.inserter.clearParameters();
        int i = 0;
        while (i < this.fields.length) {
            i++;
            this.inserter.setNull(i, 0);
        }
    }

    private void setParamValue(PreparedStatement preparedStatement, int i, ResultSetRow resultSetRow, int i2, Field field) throws SQLException {
        byte[] columnValue = resultSetRow.getColumnValue(i2);
        if (columnValue == null) {
            preparedStatement.setNull(i, 0);
            return;
        }
        int sQLType = field.getSQLType();
        if (sQLType != -6) {
            if (sQLType == -5) {
                preparedStatement.setLong(i, resultSetRow.getLong(i2));
                return;
            }
            if (sQLType != 12) {
                if (sQLType != 16) {
                    switch (sQLType) {
                        case -1:
                        case 1:
                        case 2:
                        case 3:
                            break;
                        case 0:
                            preparedStatement.setNull(i, 0);
                            break;
                        case 4:
                        case 5:
                            break;
                        case 6:
                        case 7:
                        case 8:
                            break;
                        default:
                            switch (sQLType) {
                                case 91:
                                    preparedStatement.setDate(i, resultSetRow.getDateFast(i2, this.connection, this, this.fastDefaultCal), this.fastDefaultCal);
                                    break;
                                case 92:
                                    preparedStatement.setTime(i, resultSetRow.getTimeFast(i2, this.fastDefaultCal, this.connection.getServerTimezoneTZ(), false, this.connection, this));
                                    break;
                                case 93:
                                    preparedStatement.setTimestampInternal(i, resultSetRow.getTimestampFast(i2, this.fastDefaultCal, this.connection.getServerTimezoneTZ(), false, this.connection, this, false, false), null, this.connection.getDefaultTimeZone(), false, field.getDecimals(), false);
                                    break;
                                default:
                                    preparedStatement.setBytes(i, columnValue);
                                    break;
                            }
                            break;
                    }
                    return;
                }
                preparedStatement.setBytesNoEscapeNoQuotes(i, columnValue);
                return;
            }
            preparedStatement.setString(i, resultSetRow.getString(i2, this.fields[i2].getEncoding(), this.connection));
            return;
        }
        preparedStatement.setInt(i, resultSetRow.getInt(i2));
    }

    private byte[] stripBinaryPrefix(byte[] bArr) {
        return StringUtils.stripEnclosure(bArr, "_binary'", "'");
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean absolute(int i) throws SQLException {
        return super.absolute(i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void afterLast() throws SQLException {
        super.afterLast();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void beforeFirst() throws SQLException {
        super.beforeFirst();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void cancelRowUpdates() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.doingUpdates) {
                this.doingUpdates = false;
                this.updater.clearParameters();
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl
    public void checkRowPos() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.onInsertRow) {
                super.checkRowPos();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    public void checkUpdatability() throws SQLException {
        String originalName;
        try {
            if (this.fields == null) {
                return;
            }
            String str = this.catalog;
            if (str == null || str.length() == 0) {
                String databaseName = this.fields[0].getDatabaseName();
                this.catalog = databaseName;
                if (databaseName == null || databaseName.length() == 0) {
                    throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.43"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
                }
            }
            Field[] fieldArr = this.fields;
            if (fieldArr.length <= 0) {
                this.isUpdatable = false;
                this.notUpdatableReason = Messages.getString("NotUpdatableReason.3");
                return;
            }
            String originalTableName = fieldArr[0].getOriginalTableName();
            String databaseName2 = this.fields[0].getDatabaseName();
            if (originalTableName == null) {
                originalTableName = this.fields[0].getTableName();
                databaseName2 = this.catalog;
            }
            if (originalTableName != null && originalTableName.length() == 0) {
                this.isUpdatable = false;
                this.notUpdatableReason = Messages.getString("NotUpdatableReason.3");
                return;
            }
            int i = 1;
            int iIsPrimaryKey = this.fields[0].isPrimaryKey();
            while (true) {
                Field[] fieldArr2 = this.fields;
                if (i < fieldArr2.length) {
                    String originalTableName2 = fieldArr2[i].getOriginalTableName();
                    String databaseName3 = this.fields[i].getDatabaseName();
                    if (originalTableName2 == null) {
                        originalTableName2 = this.fields[i].getTableName();
                        databaseName3 = this.catalog;
                    }
                    if (originalTableName2 != null && originalTableName2.length() == 0) {
                        this.isUpdatable = false;
                        this.notUpdatableReason = Messages.getString("NotUpdatableReason.3");
                        return;
                    }
                    if (originalTableName != null && originalTableName2.equals(originalTableName)) {
                        if (databaseName2 != null && databaseName3.equals(databaseName2)) {
                            if (this.fields[i].isPrimaryKey()) {
                                iIsPrimaryKey++;
                            }
                            i++;
                            iIsPrimaryKey = iIsPrimaryKey;
                        }
                        this.isUpdatable = false;
                        this.notUpdatableReason = Messages.getString("NotUpdatableReason.1");
                        return;
                    }
                    this.isUpdatable = false;
                    this.notUpdatableReason = Messages.getString("NotUpdatableReason.0");
                    return;
                }
                if (originalTableName != null && originalTableName.length() != 0) {
                    ResultSet resultSet = null;
                    if (this.connection.getStrictUpdates()) {
                        java.sql.DatabaseMetaData metaData = this.connection.getMetaData();
                        HashMap map = new HashMap();
                        try {
                            ResultSet primaryKeys = metaData.getPrimaryKeys(databaseName2, null, originalTableName);
                            while (primaryKeys.next()) {
                                try {
                                    String upperCase = primaryKeys.getString(4).toUpperCase();
                                    map.put(upperCase, upperCase);
                                } catch (Throwable th) {
                                    th = th;
                                    resultSet = primaryKeys;
                                    if (resultSet != null) {
                                        try {
                                            resultSet.close();
                                        } catch (Exception e) {
                                            AssertionFailedException.shouldNotHappen(e);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (primaryKeys != null) {
                                try {
                                    primaryKeys.close();
                                } catch (Exception e2) {
                                    AssertionFailedException.shouldNotHappen(e2);
                                }
                            }
                            int size = map.size();
                            if (size != 0) {
                                int i2 = 0;
                                while (true) {
                                    Field[] fieldArr3 = this.fields;
                                    if (i2 >= fieldArr3.length) {
                                        boolean zIsEmpty = map.isEmpty();
                                        this.isUpdatable = zIsEmpty;
                                        if (zIsEmpty) {
                                            break;
                                        }
                                        if (size > 1) {
                                            this.notUpdatableReason = Messages.getString("NotUpdatableReason.7");
                                            return;
                                        } else {
                                            this.notUpdatableReason = Messages.getString("NotUpdatableReason.4");
                                            return;
                                        }
                                    }
                                    if (fieldArr3[i2].isPrimaryKey() && map.remove(this.fields[i2].getName().toUpperCase()) == null && (originalName = this.fields[i2].getOriginalName()) != null && map.remove(originalName.toUpperCase()) == null) {
                                        this.isUpdatable = false;
                                        this.notUpdatableReason = Messages.getString("NotUpdatableReason.6", new Object[]{originalName});
                                        return;
                                    }
                                    i2++;
                                }
                            } else {
                                this.isUpdatable = false;
                                this.notUpdatableReason = Messages.getString("NotUpdatableReason.5");
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (iIsPrimaryKey == 0) {
                        this.isUpdatable = false;
                        this.notUpdatableReason = Messages.getString("NotUpdatableReason.4");
                        return;
                    } else {
                        this.isUpdatable = true;
                        this.notUpdatableReason = null;
                        return;
                    }
                }
                this.isUpdatable = false;
                this.notUpdatableReason = Messages.getString("NotUpdatableReason.2");
                return;
            }
        } catch (SQLException e3) {
            this.isUpdatable = false;
            this.notUpdatableReason = e3.getMessage();
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void deleteRow() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.isUpdatable) {
                throw new NotUpdatable(this.notUpdatableReason);
            }
            if (this.onInsertRow) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.1"), getExceptionInterceptor());
            }
            if (this.rowData.size() == 0) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.2"), getExceptionInterceptor());
            }
            if (isBeforeFirst()) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.3"), getExceptionInterceptor());
            }
            if (isAfterLast()) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.4"), getExceptionInterceptor());
            }
            if (this.deleter == null) {
                if (this.deleteSQL == null) {
                    generateStatements();
                }
                this.deleter = (PreparedStatement) this.connection.clientPrepareStatement(this.deleteSQL);
            }
            this.deleter.clearParameters();
            int size = this.primaryKeyIndicies.size();
            int i = 0;
            while (i < size) {
                int iIntValue = this.primaryKeyIndicies.get(i).intValue();
                i++;
                setParamValue(this.deleter, i, this.thisRow, iIntValue, this.fields[iIntValue]);
            }
            this.deleter.executeUpdate();
            RowData rowData = this.rowData;
            rowData.removeRow(rowData.getCurrentRowNumber());
            previous();
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean first() throws SQLException {
        return super.first();
    }

    public void generateStatements() throws SQLException {
        TreeMap treeMap;
        Map<String, Integer> columnsToIndexMapForTableAndDB;
        char c;
        StringBuilder sb;
        if (!this.isUpdatable) {
            this.doingUpdates = false;
            this.onInsertRow = false;
            throw new NotUpdatable(this.notUpdatableReason);
        }
        String quotedIdChar = getQuotedIdChar();
        if (this.connection.lowerCaseTableNames()) {
            Comparator comparator = String.CASE_INSENSITIVE_ORDER;
            treeMap = new TreeMap(comparator);
            this.databasesUsedToTablesUsed = new TreeMap(comparator);
        } else {
            treeMap = new TreeMap();
            this.databasesUsedToTablesUsed = new TreeMap();
        }
        this.primaryKeyIndicies = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        HashMap map = new HashMap();
        String str = this.connection.versionMeetsMinimum(3, 23, 0) ? "<=>" : "=";
        boolean z = true;
        boolean z2 = true;
        int i = 0;
        while (i < this.fields.length) {
            StringBuilder sb7 = new StringBuilder();
            if (this.fields[i].getOriginalTableName() != null) {
                String databaseName = this.fields[i].getDatabaseName();
                if (databaseName != null && databaseName.length() > 0) {
                    sb7.append(quotedIdChar);
                    sb7.append(databaseName);
                    sb7.append(quotedIdChar);
                    sb7.append('.');
                }
                String originalTableName = this.fields[i].getOriginalTableName();
                sb7.append(quotedIdChar);
                sb7.append(originalTableName);
                sb7.append(quotedIdChar);
                String string = sb7.toString();
                if (!treeMap.containsKey(string)) {
                    if (!treeMap.isEmpty()) {
                        sb6.append(',');
                    }
                    sb6.append(string);
                    treeMap.put(string, string);
                }
                map.put(Integer.valueOf(i), string);
                columnsToIndexMapForTableAndDB = getColumnsToIndexMapForTableAndDB(databaseName, originalTableName);
            } else {
                sb5 = sb5;
                String tableName = this.fields[i].getTableName();
                if (tableName != null) {
                    sb7.append(quotedIdChar);
                    sb7.append(tableName);
                    sb7.append(quotedIdChar);
                    String string2 = sb7.toString();
                    if (!treeMap.containsKey(string2)) {
                        if (!treeMap.isEmpty()) {
                            sb6.append(',');
                        }
                        sb6.append(string2);
                        treeMap.put(string2, string2);
                    }
                    map.put(Integer.valueOf(i), string2);
                    columnsToIndexMapForTableAndDB = getColumnsToIndexMapForTableAndDB(this.catalog, tableName);
                } else {
                    columnsToIndexMapForTableAndDB = null;
                }
            }
            String originalName = this.fields[i].getOriginalName();
            if (!this.connection.getIO().hasLongColumnInfo() || originalName == null || originalName.length() <= 0) {
                originalName = this.fields[i].getName();
            }
            if (columnsToIndexMapForTableAndDB != null && originalName != null) {
                columnsToIndexMapForTableAndDB.put(originalName, Integer.valueOf(i));
            }
            String originalTableName2 = this.fields[i].getOriginalTableName();
            if (!this.connection.getIO().hasLongColumnInfo() || originalTableName2 == null || originalTableName2.length() <= 0) {
                originalTableName2 = this.fields[i].getTableName();
            }
            StringBuilder sb8 = new StringBuilder();
            String databaseName2 = this.fields[i].getDatabaseName();
            if (databaseName2 == null || databaseName2.length() <= 0) {
                c = '.';
            } else {
                sb8.append(quotedIdChar);
                sb8.append(databaseName2);
                sb8.append(quotedIdChar);
                c = '.';
                sb8.append('.');
            }
            sb8.append(quotedIdChar);
            sb8.append(originalTableName2);
            sb8.append(quotedIdChar);
            sb8.append(c);
            sb8.append(quotedIdChar);
            sb8.append(originalName);
            sb8.append(quotedIdChar);
            String string3 = sb8.toString();
            if (this.fields[i].isPrimaryKey()) {
                this.primaryKeyIndicies.add(Integer.valueOf(i));
                if (z) {
                    z = false;
                } else {
                    sb3.append(" AND ");
                }
                sb3.append(string3);
                sb3.append(str);
                sb3.append("?");
            }
            if (z2) {
                sb2.append("SET ");
                sb = sb5;
                z2 = false;
            } else {
                sb2.append(",");
                sb4.append(",");
                sb = sb5;
                sb.append(",");
            }
            sb.append("?");
            sb4.append(string3);
            sb2.append(string3);
            sb2.append("=?");
            i++;
            sb5 = sb;
        }
        this.qualifiedAndQuotedTableName = sb6.toString();
        this.updateSQL = "UPDATE " + this.qualifiedAndQuotedTableName + " " + sb2.toString() + " WHERE " + sb3.toString();
        this.insertSQL = "INSERT INTO " + this.qualifiedAndQuotedTableName + " (" + sb4.toString() + ") VALUES (" + sb5.toString() + ")";
        StringBuilder sb9 = new StringBuilder();
        sb9.append("SELECT ");
        sb9.append(sb4.toString());
        sb9.append(" FROM ");
        sb9.append(this.qualifiedAndQuotedTableName);
        sb9.append(" WHERE ");
        sb9.append(sb3.toString());
        this.refreshSQL = sb9.toString();
        this.deleteSQL = "DELETE FROM " + this.qualifiedAndQuotedTableName + " WHERE " + sb3.toString();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public int getConcurrency() throws SQLException {
        int i;
        synchronized (checkClosed().getConnectionMutex()) {
            i = this.isUpdatable ? MysqlErrorNumbers.ER_DB_DROP_EXISTS : MysqlErrorNumbers.ER_DB_CREATE_EXISTS;
        }
        return i;
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void insertRow() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.onInsertRow) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.7"), getExceptionInterceptor());
            }
            this.inserter.executeUpdate();
            long lastInsertID = this.inserter.getLastInsertID();
            int length = this.fields.length;
            byte[][] bArr = new byte[length][];
            for (int i = 0; i < length; i++) {
                if (this.inserter.isNull(i)) {
                    bArr[i] = null;
                } else {
                    bArr[i] = this.inserter.getBytesRepresentation(i);
                }
                if (this.fields[i].isAutoIncrement() && lastInsertID > 0) {
                    bArr[i] = StringUtils.getBytes(String.valueOf(lastInsertID));
                    this.inserter.setBytesNoEscapeNoQuotes(i + 1, bArr[i]);
                }
            }
            ByteArrayRow byteArrayRow = new ByteArrayRow(bArr, getExceptionInterceptor());
            refreshRow(this.inserter, byteArrayRow);
            this.rowData.addRow(byteArrayRow);
            resetInserter();
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean isAfterLast() throws SQLException {
        return super.isAfterLast();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean isBeforeFirst() throws SQLException {
        return super.isBeforeFirst();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean isFirst() throws SQLException {
        return super.isFirst();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean isLast() throws SQLException {
        return super.isLast();
    }

    public boolean isUpdatable() {
        return this.isUpdatable;
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean last() throws SQLException {
        return super.last();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void moveToCurrentRow() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.isUpdatable) {
                throw new NotUpdatable(this.notUpdatableReason);
            }
            if (this.onInsertRow) {
                this.onInsertRow = false;
                this.thisRow = this.savedCurrentRow;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009b A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:8:0x0011, B:10:0x0015, B:11:0x0018, B:13:0x0036, B:14:0x0039, B:16:0x0040, B:18:0x0062, B:20:0x0067, B:51:0x0110, B:21:0x0077, B:23:0x007d, B:27:0x008c, B:28:0x008f, B:49:0x00f8, B:29:0x009b, B:31:0x00a2, B:33:0x00aa, B:35:0x00b2, B:37:0x00bb, B:39:0x00c2, B:41:0x00cb, B:43:0x00d4, B:45:0x00dd, B:47:0x00e5, B:48:0x00ef, B:50:0x0107, B:52:0x0114, B:15:0x003d, B:54:0x0116, B:55:0x011d), top: B:59:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00ef A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:8:0x0011, B:10:0x0015, B:11:0x0018, B:13:0x0036, B:14:0x0039, B:16:0x0040, B:18:0x0062, B:20:0x0067, B:51:0x0110, B:21:0x0077, B:23:0x007d, B:27:0x008c, B:28:0x008f, B:49:0x00f8, B:29:0x009b, B:31:0x00a2, B:33:0x00aa, B:35:0x00b2, B:37:0x00bb, B:39:0x00c2, B:41:0x00cb, B:43:0x00d4, B:45:0x00dd, B:47:0x00e5, B:48:0x00ef, B:50:0x0107, B:52:0x0114, B:15:0x003d, B:54:0x0116, B:55:0x011d), top: B:59:0x0009 }] */
    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void moveToInsertRow() throws SQLException {
        byte[][] bArr;
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.isUpdatable) {
                throw new NotUpdatable(this.notUpdatableReason);
            }
            if (this.inserter == null) {
                if (this.insertSQL == null) {
                    generateStatements();
                }
                PreparedStatement preparedStatement = (PreparedStatement) this.connection.clientPrepareStatement(this.insertSQL);
                this.inserter = preparedStatement;
                Field[] fieldArr = this.fields;
                preparedStatement.parameterMetaData = new MysqlParameterMetadata(fieldArr, fieldArr.length, getExceptionInterceptor());
                if (this.populateInserterWithDefaultValues) {
                    extractDefaultValues();
                }
                resetInserter();
            } else {
                resetInserter();
            }
            int length = this.fields.length;
            this.onInsertRow = true;
            this.doingUpdates = false;
            this.savedCurrentRow = this.thisRow;
            byte[][] bArr2 = new byte[length][];
            ByteArrayRow byteArrayRow = new ByteArrayRow(bArr2, getExceptionInterceptor());
            this.thisRow = byteArrayRow;
            byteArrayRow.setMetadata(this.fields);
            for (int i = 0; i < length; i++) {
                if (!this.populateInserterWithDefaultValues) {
                    this.inserter.setBytesNoEscapeNoQuotes(i + 1, StringUtils.getBytes("DEFAULT"));
                    bArr2 = null;
                } else if (this.defaultColumnValue[i] != null) {
                    int mysqlType = this.fields[i].getMysqlType();
                    if (mysqlType != 7 && mysqlType != 14) {
                        switch (mysqlType) {
                            case 10:
                            case 11:
                            case 12:
                                bArr = this.defaultColumnValue;
                                if (bArr[i].length <= 7) {
                                    this.inserter.setBytes(i + 1, bArr[i], false, false);
                                } else {
                                    this.inserter.setBytes(i + 1, bArr[i], false, false);
                                }
                                break;
                            default:
                                this.inserter.setBytes(i + 1, this.defaultColumnValue[i], false, false);
                                break;
                        }
                    } else {
                        bArr = this.defaultColumnValue;
                        if (bArr[i].length <= 7 && bArr[i][0] == 67 && bArr[i][1] == 85 && bArr[i][2] == 82 && bArr[i][3] == 82 && bArr[i][4] == 69 && bArr[i][5] == 78 && bArr[i][6] == 84 && bArr[i][7] == 95) {
                            this.inserter.setBytesNoEscapeNoQuotes(i + 1, bArr[i]);
                        } else {
                            this.inserter.setBytes(i + 1, bArr[i], false, false);
                        }
                    }
                    byte[][] bArr3 = this.defaultColumnValue;
                    int length2 = bArr3[i].length;
                    byte[] bArr4 = new byte[length2];
                    System.arraycopy(bArr3[i], 0, bArr4, 0, length2);
                    bArr2[i] = bArr4;
                } else {
                    this.inserter.setNull(i + 1, 0);
                    bArr2[i] = null;
                }
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean next() throws SQLException {
        return super.next();
    }

    @Override // com.mysql.jdbc.ResultSetImpl
    public boolean prev() throws SQLException {
        return super.prev();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean previous() throws SQLException {
        return super.previous();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, com.mysql.jdbc.ResultSetInternalMethods
    public void realClose(boolean z) throws SQLException {
        if (this.connection == null) {
            return;
        }
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.useUsageAdvisor && this.deleter == null && this.inserter == null && this.refresher == null && this.updater == null) {
                this.eventSink = ProfilerEventHandlerFactory.getInstance(this.connection);
                String string = Messages.getString("UpdatableResultSet.34");
                ProfilerEventHandler profilerEventHandler = this.eventSink;
                StatementImpl statementImpl = this.owningStatement;
                profilerEventHandler.consumeEvent(new ProfilerEvent((byte) 0, BuildConfig.FLAVOR, statementImpl == null ? "N/A" : statementImpl.currentCatalog, this.connectionId, statementImpl == null ? -1 : statementImpl.getId(), this.resultId, System.currentTimeMillis(), 0L, Constants.MILLIS_I18N, null, this.pointOfOrigin, string));
            }
            try {
                PreparedStatement preparedStatement = this.deleter;
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                e = null;
            } catch (SQLException e) {
                e = e;
            }
            try {
                PreparedStatement preparedStatement2 = this.inserter;
                if (preparedStatement2 != null) {
                    preparedStatement2.close();
                }
            } catch (SQLException e2) {
                e = e2;
            }
            try {
                PreparedStatement preparedStatement3 = this.refresher;
                if (preparedStatement3 != null) {
                    preparedStatement3.close();
                }
            } catch (SQLException e3) {
                e = e3;
            }
            try {
                PreparedStatement preparedStatement4 = this.updater;
                if (preparedStatement4 != null) {
                    preparedStatement4.close();
                }
            } catch (SQLException e4) {
                e = e4;
            }
            super.realClose(z);
            if (e != null) {
                throw e;
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void refreshRow() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.isUpdatable) {
                throw new NotUpdatable();
            }
            if (this.onInsertRow) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.8"), getExceptionInterceptor());
            }
            if (this.rowData.size() == 0) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.9"), getExceptionInterceptor());
            }
            if (isBeforeFirst()) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.10"), getExceptionInterceptor());
            }
            if (isAfterLast()) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.11"), getExceptionInterceptor());
            }
            refreshRow(this.updater, this.thisRow);
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean relative(int i) throws SQLException {
        return super.relative(i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean rowDeleted() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean rowInserted() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public boolean rowUpdated() throws SQLException {
        throw SQLError.createSQLFeatureNotSupportedException();
    }

    @Override // com.mysql.jdbc.ResultSetImpl
    public void setResultSetConcurrency(int i) {
        super.setResultSetConcurrency(i);
    }

    public void syncUpdate() throws SQLException {
        if (this.updater == null) {
            if (this.updateSQL == null) {
                generateStatements();
            }
            PreparedStatement preparedStatement = (PreparedStatement) this.connection.clientPrepareStatement(this.updateSQL);
            this.updater = preparedStatement;
            Field[] fieldArr = this.fields;
            preparedStatement.parameterMetaData = new MysqlParameterMetadata(fieldArr, fieldArr.length, getExceptionInterceptor());
        }
        int length = this.fields.length;
        this.updater.clearParameters();
        for (int i = 0; i < length; i++) {
            if (this.thisRow.getColumnValue(i) == null) {
                this.updater.setNull(i + 1, 0);
            } else if (!this.fields[i].getvalueNeedsQuoting()) {
                this.updater.setBytesNoEscapeNoQuotes(i + 1, this.thisRow.getColumnValue(i));
            } else if (!this.fields[i].isCharsetApplicableType() || this.fields[i].getEncoding().equals(this.connection.getEncoding())) {
                this.updater.setBytes(i + 1, this.thisRow.getColumnValue(i), this.fields[i].isBinary(), false);
            } else {
                this.updater.setString(i + 1, this.thisRow.getString(i, this.fields[i].getEncoding(), this.connection));
            }
        }
        int size = this.primaryKeyIndicies.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iIntValue = this.primaryKeyIndicies.get(i2).intValue();
            setParamValue(this.updater, length + i2 + 1, this.thisRow, iIntValue, this.fields[iIntValue]);
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setAsciiStream(i, inputStream, i2);
                this.thisRow.setColumnValue(i - 1, STREAM_DATA_MARKER);
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setAsciiStream(i, inputStream, i2);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setBigDecimal(i, bigDecimal);
                if (bigDecimal == null) {
                    this.thisRow.setColumnValue(i - 1, null);
                } else {
                    this.thisRow.setColumnValue(i - 1, StringUtils.getBytes(bigDecimal.toString()));
                }
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setBigDecimal(i, bigDecimal);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setBinaryStream(i, inputStream, i2);
                if (inputStream == null) {
                    this.thisRow.setColumnValue(i - 1, null);
                } else {
                    this.thisRow.setColumnValue(i - 1, STREAM_DATA_MARKER);
                }
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setBinaryStream(i, inputStream, i2);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBlob(int i, java.sql.Blob blob) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setBlob(i, blob);
                if (blob == null) {
                    this.thisRow.setColumnValue(i - 1, null);
                } else {
                    this.thisRow.setColumnValue(i - 1, STREAM_DATA_MARKER);
                }
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setBlob(i, blob);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBoolean(int i, boolean z) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setBoolean(i, z);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setBoolean(i, z);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateByte(int i, byte b) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setByte(i, b);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setByte(i, b);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBytes(int i, byte[] bArr) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setBytes(i, bArr);
                this.thisRow.setColumnValue(i - 1, bArr);
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setBytes(i, bArr);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setCharacterStream(i, reader, i2);
                if (reader == null) {
                    this.thisRow.setColumnValue(i - 1, null);
                } else {
                    this.thisRow.setColumnValue(i - 1, STREAM_DATA_MARKER);
                }
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setCharacterStream(i, reader, i2);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateClob(int i, java.sql.Clob clob) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            try {
                if (clob == null) {
                    updateNull(i);
                } else {
                    updateCharacterStream(i, clob.getCharacterStream(), (int) clob.length());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateDate(int i, Date date) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setDate(i, date);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setDate(i, date);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateDouble(int i, double d) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setDouble(i, d);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setDouble(i, d);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateFloat(int i, float f) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setFloat(i, f);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setFloat(i, f);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateInt(int i, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setInt(i, i2);
                int i3 = i - 1;
                this.thisRow.setColumnValue(i3, this.inserter.getBytesRepresentation(i3));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setInt(i, i2);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateLong(int i, long j) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setLong(i, j);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setLong(i, j);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateNull(int i) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setNull(i, 0);
                this.thisRow.setColumnValue(i - 1, null);
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setNull(i, 0);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(int i, Object obj) throws SQLException {
        updateObjectInternal(i, obj, null, 0);
    }

    public void updateObjectInternal(int i, Object obj, Integer num, int i2) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                if (num == null) {
                    this.inserter.setObject(i, obj);
                } else {
                    this.inserter.setObject(i, obj, num.intValue());
                }
                int i3 = i - 1;
                this.thisRow.setColumnValue(i3, this.inserter.getBytesRepresentation(i3));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                if (num == null) {
                    this.updater.setObject(i, obj);
                } else {
                    this.updater.setObject(i, obj, num.intValue());
                }
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateRow() throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (!this.isUpdatable) {
                throw new NotUpdatable(this.notUpdatableReason);
            }
            if (this.doingUpdates) {
                this.updater.executeUpdate();
                refreshRow();
                this.doingUpdates = false;
            } else if (this.onInsertRow) {
                throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.44"), getExceptionInterceptor());
            }
            syncUpdate();
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateShort(int i, short s) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setShort(i, s);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setShort(i, s);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateString(int i, String str) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setString(i, str);
                if (str == null) {
                    this.thisRow.setColumnValue(i - 1, null);
                } else if (getCharConverter() != null) {
                    this.thisRow.setColumnValue(i - 1, StringUtils.getBytes(str, this.charConverter, this.charEncoding, this.connection.getServerCharset(), this.connection.parserKnowsUnicode(), getExceptionInterceptor()));
                } else {
                    this.thisRow.setColumnValue(i - 1, StringUtils.getBytes(str));
                }
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setString(i, str);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateTime(int i, Time time) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setTime(i, time);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setTime(i, time);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateTimestamp(int i, Timestamp timestamp) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (this.onInsertRow) {
                this.inserter.setTimestamp(i, timestamp);
                int i2 = i - 1;
                this.thisRow.setColumnValue(i2, this.inserter.getBytesRepresentation(i2));
            } else {
                if (!this.doingUpdates) {
                    this.doingUpdates = true;
                    syncUpdate();
                }
                this.updater.setTimestamp(i, timestamp);
            }
        }
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(int i, Object obj, int i2) throws SQLException {
        updateObjectInternal(i, obj, null, i2);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(String str, Object obj) throws SQLException {
        updateObject(findColumn(str), obj);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateObject(String str, Object obj, int i) throws SQLException {
        updateObject(findColumn(str), obj);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream, int i) throws SQLException {
        updateAsciiStream(findColumn(str), inputStream, i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBoolean(String str, boolean z) throws SQLException {
        updateBoolean(findColumn(str), z);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateByte(String str, byte b) throws SQLException {
        updateByte(findColumn(str), b);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBytes(String str, byte[] bArr) throws SQLException {
        updateBytes(findColumn(str), bArr);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateDate(String str, Date date) throws SQLException {
        updateDate(findColumn(str), date);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateDouble(String str, double d) throws SQLException {
        updateDouble(findColumn(str), d);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateFloat(String str, float f) throws SQLException {
        updateFloat(findColumn(str), f);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateInt(String str, int i) throws SQLException {
        updateInt(findColumn(str), i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateLong(String str, long j) throws SQLException {
        updateLong(findColumn(str), j);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateNull(String str) throws SQLException {
        updateNull(findColumn(str));
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateShort(String str, short s) throws SQLException {
        updateShort(findColumn(str), s);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateTime(String str, Time time) throws SQLException {
        updateTime(findColumn(str), time);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateTimestamp(String str, Timestamp timestamp) throws SQLException {
        updateTimestamp(findColumn(str), timestamp);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBigDecimal(String str, BigDecimal bigDecimal) throws SQLException {
        updateBigDecimal(findColumn(str), bigDecimal);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream, int i) throws SQLException {
        updateBinaryStream(findColumn(str), inputStream, i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateBlob(String str, java.sql.Blob blob) throws SQLException {
        updateBlob(findColumn(str), blob);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader, int i) throws SQLException {
        updateCharacterStream(findColumn(str), reader, i);
    }

    @Override // com.mysql.jdbc.ResultSetImpl, java.sql.ResultSet
    public void updateString(String str, String str2) throws SQLException {
        updateString(findColumn(str), str2);
    }

    private void refreshRow(PreparedStatement preparedStatement, ResultSetRow resultSetRow) throws Throwable {
        byte[] columnValue;
        ResultSet resultSetExecuteQuery;
        Throwable th;
        byte[] columnValue2;
        if (this.refresher == null) {
            if (this.refreshSQL == null) {
                generateStatements();
            }
            PreparedStatement preparedStatement2 = (PreparedStatement) this.connection.clientPrepareStatement(this.refreshSQL);
            this.refresher = preparedStatement2;
            Field[] fieldArr = this.fields;
            preparedStatement2.parameterMetaData = new MysqlParameterMetadata(fieldArr, fieldArr.length, getExceptionInterceptor());
        }
        this.refresher.clearParameters();
        int size = this.primaryKeyIndicies.size();
        int i = 0;
        if (size == 1) {
            int iIntValue = this.primaryKeyIndicies.get(0).intValue();
            if (!this.doingUpdates && !this.onInsertRow) {
                columnValue2 = resultSetRow.getColumnValue(iIntValue);
            } else {
                byte[] bytesRepresentation = preparedStatement.getBytesRepresentation(iIntValue);
                if (!preparedStatement.isNull(iIntValue) && bytesRepresentation.length != 0) {
                    columnValue2 = stripBinaryPrefix(bytesRepresentation);
                } else {
                    columnValue2 = resultSetRow.getColumnValue(iIntValue);
                }
            }
            if (this.fields[iIntValue].getvalueNeedsQuoting()) {
                this.refresher.setBytesNoEscape(1, columnValue2);
            } else {
                this.refresher.setBytesNoEscapeNoQuotes(1, columnValue2);
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                int iIntValue2 = this.primaryKeyIndicies.get(i2).intValue();
                if (!this.doingUpdates && !this.onInsertRow) {
                    columnValue = resultSetRow.getColumnValue(iIntValue2);
                } else {
                    byte[] bytesRepresentation2 = preparedStatement.getBytesRepresentation(iIntValue2);
                    if (!preparedStatement.isNull(iIntValue2) && bytesRepresentation2.length != 0) {
                        columnValue = stripBinaryPrefix(bytesRepresentation2);
                    } else {
                        columnValue = resultSetRow.getColumnValue(iIntValue2);
                    }
                }
                i2++;
                this.refresher.setBytesNoEscape(i2, columnValue);
            }
        }
        try {
            resultSetExecuteQuery = this.refresher.executeQuery();
            try {
                int columnCount = resultSetExecuteQuery.getMetaData().getColumnCount();
                if (!resultSetExecuteQuery.next()) {
                    throw SQLError.createSQLException(Messages.getString("UpdatableResultSet.12"), SQLError.SQL_STATE_GENERAL_ERROR, getExceptionInterceptor());
                }
                while (i < columnCount) {
                    int i3 = i + 1;
                    if (resultSetExecuteQuery.getBytes(i3) != null && !resultSetExecuteQuery.wasNull()) {
                        resultSetRow.setColumnValue(i, resultSetExecuteQuery.getBytes(i3));
                    } else {
                        resultSetRow.setColumnValue(i, null);
                    }
                    i = i3;
                }
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (SQLException unused) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (resultSetExecuteQuery != null) {
                    try {
                        resultSetExecuteQuery.close();
                    } catch (SQLException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            resultSetExecuteQuery = null;
            th = th3;
        }
    }
}
