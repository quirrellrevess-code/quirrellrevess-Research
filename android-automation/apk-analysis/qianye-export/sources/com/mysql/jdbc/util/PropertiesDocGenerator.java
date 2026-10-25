package com.mysql.jdbc.util;

import com.mysql.jdbc.ConnectionPropertiesImpl;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class PropertiesDocGenerator extends ConnectionPropertiesImpl {
    public static final long serialVersionUID = -4869689139143855383L;

    public static void main(String[] strArr) throws SQLException {
        System.out.println(new PropertiesDocGenerator().exposeAsXml());
    }
}
