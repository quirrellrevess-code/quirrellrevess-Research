package com.mysql.jdbc.jdbc2.optional;

import javax.transaction.xa.XAException;

/* JADX INFO: loaded from: classes.dex */
public class MysqlXAException extends XAException {
    private static final long serialVersionUID = -9075817535836563004L;
    private String message;
    public String xidAsString;

    public MysqlXAException(int i, String str, String str2) {
        super(i);
        this.message = str;
        this.xidAsString = str2;
    }

    public String getMessage() {
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder();
        if (message != null) {
            sb.append(message);
            sb.append(":");
        }
        String str = this.message;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public MysqlXAException(String str, String str2) {
        this.message = str;
        this.xidAsString = str2;
    }
}
