package com.mysql.jdbc;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: CharsetMapping.java */
/* JADX INFO: loaded from: classes.dex */
public class MysqlCharset {
    public final String charsetName;
    public final List<String> javaEncodingsUc;
    public int major;
    public final int mblen;
    public int minor;
    public final int priority;
    public int subminor;

    public MysqlCharset(String str, int i, int i2, String[] strArr) {
        this.javaEncodingsUc = new ArrayList();
        this.major = 4;
        this.minor = 1;
        this.subminor = 0;
        this.charsetName = str;
        this.mblen = i;
        this.priority = i2;
        for (String str2 : strArr) {
            try {
                Charset charsetForName = Charset.forName(str2);
                addEncodingMapping(charsetForName.name());
                Iterator<String> it = charsetForName.aliases().iterator();
                while (it.hasNext()) {
                    addEncodingMapping(it.next());
                }
            } catch (Exception unused) {
                if (i == 1) {
                    addEncodingMapping(str2);
                }
            }
        }
        if (this.javaEncodingsUc.size() == 0) {
            if (i > 1) {
                addEncodingMapping("UTF-8");
            } else {
                addEncodingMapping("Cp1252");
            }
        }
    }

    private void addEncodingMapping(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (this.javaEncodingsUc.contains(upperCase)) {
            return;
        }
        this.javaEncodingsUc.add(upperCase);
    }

    public String getMatchingJavaEncoding(String str) {
        return (str == null || !this.javaEncodingsUc.contains(str.toUpperCase(Locale.ENGLISH))) ? this.javaEncodingsUc.get(0) : str;
    }

    public boolean isOkayForVersion(Connection connection) throws SQLException {
        return connection.versionMeetsMinimum(this.major, this.minor, this.subminor);
    }

    public String toString() {
        return "[charsetName=" + this.charsetName + ",mblen=" + this.mblen + "]";
    }

    public MysqlCharset(String str, int i, int i2, String[] strArr, int i3, int i4) {
        this(str, i, i2, strArr);
        this.major = i3;
        this.minor = i4;
    }

    public MysqlCharset(String str, int i, int i2, String[] strArr, int i3, int i4, int i5) {
        this(str, i, i2, strArr);
        this.major = i3;
        this.minor = i4;
        this.subminor = i5;
    }
}
