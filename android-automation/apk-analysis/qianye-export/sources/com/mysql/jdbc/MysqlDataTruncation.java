package com.mysql.jdbc;

import java.sql.DataTruncation;

/* JADX INFO: loaded from: classes.dex */
public class MysqlDataTruncation extends DataTruncation {
    public static final long serialVersionUID = 3263928195256986226L;
    private String message;
    private int vendorErrorCode;

    public MysqlDataTruncation(String str, int i, boolean z, boolean z2, int i2, int i3, int i4) {
        super(i, z, z2, i2, i3);
        this.message = str;
        this.vendorErrorCode = i4;
    }

    @Override // java.sql.SQLException
    public int getErrorCode() {
        return this.vendorErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + ": " + this.message;
    }
}
