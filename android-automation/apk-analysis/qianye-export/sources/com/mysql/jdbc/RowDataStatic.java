package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RowDataStatic implements RowData {
    private int index = -1;
    private Field[] metadata;
    public ResultSetImpl owner;
    private List<ResultSetRow> rows;

    public RowDataStatic(List<ResultSetRow> list) {
        this.rows = list;
    }

    @Override // com.mysql.jdbc.RowData
    public void addRow(ResultSetRow resultSetRow) {
        this.rows.add(resultSetRow);
    }

    @Override // com.mysql.jdbc.RowData
    public void afterLast() {
        if (this.rows.size() > 0) {
            this.index = this.rows.size();
        }
    }

    @Override // com.mysql.jdbc.RowData
    public void beforeFirst() {
        if (this.rows.size() > 0) {
            this.index = -1;
        }
    }

    @Override // com.mysql.jdbc.RowData
    public void beforeLast() {
        if (this.rows.size() > 0) {
            this.index = this.rows.size() - 2;
        }
    }

    @Override // com.mysql.jdbc.RowData
    public void close() {
    }

    @Override // com.mysql.jdbc.RowData
    public ResultSetRow getAt(int i) throws SQLException {
        if (i < 0 || i >= this.rows.size()) {
            return null;
        }
        return this.rows.get(i).setMetadata(this.metadata);
    }

    @Override // com.mysql.jdbc.RowData
    public int getCurrentRowNumber() {
        return this.index;
    }

    @Override // com.mysql.jdbc.RowData
    public ResultSetInternalMethods getOwner() {
        return this.owner;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean hasNext() {
        return this.index + 1 < this.rows.size();
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isAfterLast() {
        return this.index >= this.rows.size() && this.rows.size() != 0;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isBeforeFirst() {
        return this.index == -1 && this.rows.size() != 0;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isDynamic() {
        return false;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isEmpty() {
        return this.rows.size() == 0;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isFirst() {
        return this.index == 0;
    }

    @Override // com.mysql.jdbc.RowData
    public boolean isLast() {
        return this.rows.size() != 0 && this.index == this.rows.size() - 1;
    }

    @Override // com.mysql.jdbc.RowData
    public void moveRowRelative(int i) {
        if (this.rows.size() > 0) {
            int i2 = this.index + i;
            this.index = i2;
            if (i2 < -1) {
                beforeFirst();
            } else if (i2 > this.rows.size()) {
                afterLast();
            }
        }
    }

    @Override // com.mysql.jdbc.RowData
    public ResultSetRow next() throws SQLException {
        int i = this.index + 1;
        this.index = i;
        if (i > this.rows.size()) {
            afterLast();
            return null;
        }
        if (this.index < this.rows.size()) {
            return this.rows.get(this.index).setMetadata(this.metadata);
        }
        return null;
    }

    @Override // com.mysql.jdbc.RowData
    public void removeRow(int i) {
        this.rows.remove(i);
    }

    @Override // com.mysql.jdbc.RowData
    public void setCurrentRow(int i) {
        this.index = i;
    }

    @Override // com.mysql.jdbc.RowData
    public void setMetadata(Field[] fieldArr) {
        this.metadata = fieldArr;
    }

    @Override // com.mysql.jdbc.RowData
    public void setOwner(ResultSetImpl resultSetImpl) {
        this.owner = resultSetImpl;
    }

    @Override // com.mysql.jdbc.RowData
    public int size() {
        return this.rows.size();
    }

    @Override // com.mysql.jdbc.RowData
    public boolean wasEmpty() {
        List<ResultSetRow> list = this.rows;
        return list != null && list.size() == 0;
    }
}
