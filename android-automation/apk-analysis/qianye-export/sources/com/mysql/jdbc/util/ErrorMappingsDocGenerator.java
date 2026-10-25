package com.mysql.jdbc.util;

import com.mysql.jdbc.SQLError;

/* JADX INFO: loaded from: classes.dex */
public class ErrorMappingsDocGenerator {
    public static void main(String[] strArr) throws Exception {
        SQLError.dumpSqlStatesMappingsAsXml();
    }
}
