package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class OperationNotSupportedException extends SQLException {
    public static final long serialVersionUID = 474918612056813430L;

    public OperationNotSupportedException() {
        super(Messages.getString("RowDataDynamic.10"), SQLError.SQL_STATE_ILLEGAL_ARGUMENT);
    }
}
