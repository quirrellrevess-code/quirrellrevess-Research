package com.mysql.jdbc.util;

import com.mysql.jdbc.NonRegisteringDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class VersionFSHierarchyMaker {
    public static void main(String[] strArr) throws Exception {
        String str;
        if (strArr.length < 3) {
            usage();
            System.exit(1);
        }
        String strRemoveWhitespaceChars = removeWhitespaceChars(System.getProperty("java.version"));
        String strRemoveWhitespaceChars2 = removeWhitespaceChars(System.getProperty("java.vendor"));
        String strRemoveWhitespaceChars3 = removeWhitespaceChars(System.getProperty("os.name"));
        String strRemoveWhitespaceChars4 = removeWhitespaceChars(System.getProperty("os.arch"));
        String strRemoveWhitespaceChars5 = removeWhitespaceChars(System.getProperty("os.version"));
        String property = System.getProperty("com.mysql.jdbc.testsuite.url");
        String str2 = "MySQL" + strArr[2] + "_";
        try {
            Properties properties = new Properties();
            properties.setProperty("allowPublicKeyRetrieval", "true");
            ResultSet resultSetExecuteQuery = new NonRegisteringDriver().connect(property, properties).createStatement().executeQuery("SELECT VERSION()");
            resultSetExecuteQuery.next();
            str = str2 + removeWhitespaceChars(resultSetExecuteQuery.getString(1));
        } catch (Throwable unused) {
            str = str2 + "no-server-running-on-" + removeWhitespaceChars(property);
        }
        String str3 = strRemoveWhitespaceChars2 + "-" + strRemoveWhitespaceChars;
        String str4 = strRemoveWhitespaceChars3 + "-" + strRemoveWhitespaceChars4 + "-" + strRemoveWhitespaceChars5;
        File file = new File(strArr[0]);
        File file2 = new File(new File(new File(file, str), str4), str3);
        file2.mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(strArr[1]);
            try {
                String absolutePath = file.getAbsolutePath();
                String absolutePath2 = file2.getAbsolutePath();
                if (absolutePath2.startsWith(absolutePath)) {
                    absolutePath2 = absolutePath2.substring(absolutePath.length() + 1);
                }
                fileOutputStream2.write(absolutePath2.getBytes());
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String removeWhitespaceChars(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt) || Character.isLetter(cCharAt)) {
                sb.append(cCharAt);
            } else if (Character.isWhitespace(cCharAt)) {
                sb.append("_");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static void usage() {
        System.err.println("Creates a fs hierarchy representing MySQL version, OS version and JVM version.");
        System.err.println("Stores the full path as 'outputDirectory' property in file 'directoryPropPath'");
        System.err.println();
        System.err.println("Usage: java VersionFSHierarchyMaker baseDirectory directoryPropPath jdbcUrlIter");
    }
}
