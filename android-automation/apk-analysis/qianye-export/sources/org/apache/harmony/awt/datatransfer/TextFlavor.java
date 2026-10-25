package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes.dex */
public class TextFlavor {
    public static final Class[] unicodeTextClasses = {String.class, Reader.class, CharBuffer.class, char[].class};
    public static final Class[] charsetTextClasses = {InputStream.class, ByteBuffer.class, byte[].class};

    public static void addCharsetClasses(SystemFlavorMap systemFlavorMap, String str, String str2, String str3) {
        int i = 0;
        while (true) {
            Class[] clsArr = charsetTextClasses;
            if (i >= clsArr.length) {
                return;
            }
            String str4 = "text/" + str2;
            DataFlavor dataFlavor = new DataFlavor(String.valueOf(str4) + (";class=\"" + clsArr[i].getName() + "\";charset=\"" + str3 + "\""), str4);
            systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
            systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
            i++;
        }
    }

    public static void addUnicodeClasses(SystemFlavorMap systemFlavorMap, String str, String str2) {
        int i = 0;
        while (true) {
            Class[] clsArr = unicodeTextClasses;
            if (i >= clsArr.length) {
                return;
            }
            String str3 = "text/" + str2;
            DataFlavor dataFlavor = new DataFlavor(String.valueOf(str3) + (";class=\"" + clsArr[i].getName() + "\""), str3);
            systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
            systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
            i++;
        }
    }
}
