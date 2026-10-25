package com.mysql.jdbc;

/* JADX INFO: compiled from: CharsetMapping.java */
/* JADX INFO: loaded from: classes.dex */
public class Collation {
    public final String collationName;
    public final int index;
    public final MysqlCharset mysqlCharset;
    public final int priority;

    public Collation(int i, String str, int i2, String str2) {
        this.index = i;
        this.collationName = str;
        this.priority = i2;
        this.mysqlCharset = CharsetMapping.CHARSET_NAME_TO_CHARSET.get(str2);
    }

    public String toString() {
        return "[index=" + this.index + ",collationName=" + this.collationName + ",charsetName=" + this.mysqlCharset.charsetName + ",javaCharsetName=" + this.mysqlCharset.getMatchingJavaEncoding(null) + "]";
    }
}
