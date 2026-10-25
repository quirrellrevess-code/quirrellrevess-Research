package javax.mail.internet;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.StringUtils;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ParameterList {
    private static boolean applehack = false;
    private static boolean decodeParameters = false;
    private static boolean decodeParametersStrict = false;
    private static boolean encodeParameters = false;
    private static final char[] hex;
    private String lastName;
    private Map list;
    private Set multisegmentNames;
    private Map slist;

    public static class MultiValue extends ArrayList {
        public String value;

        private MultiValue() {
        }

        public /* synthetic */ MultiValue(MultiValue multiValue) {
            this();
        }
    }

    public static class ParamEnum implements Enumeration {

        /* JADX INFO: renamed from: it */
        private Iterator f869it;

        public ParamEnum(Iterator it) {
            this.f869it = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f869it.hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.f869it.next();
        }
    }

    public static class ToStringBuffer {

        /* JADX INFO: renamed from: sb */
        private StringBuffer f870sb = new StringBuffer();
        private int used;

        public ToStringBuffer(int i) {
            this.used = i;
        }

        public void addNV(String str, String str2) {
            String strQuote = ParameterList.quote(str2);
            this.f870sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + strQuote.length() + 1 > 76) {
                this.f870sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuffer stringBuffer = this.f870sb;
            stringBuffer.append(str);
            stringBuffer.append('=');
            int length = this.used + str.length() + 1;
            this.used = length;
            if (length + strQuote.length() <= 76) {
                this.f870sb.append(strQuote);
                this.used += strQuote.length();
                return;
            }
            String strFold = MimeUtility.fold(this.used, strQuote);
            this.f870sb.append(strFold);
            int iLastIndexOf = strFold.lastIndexOf(10);
            if (iLastIndexOf >= 0) {
                this.used += (strFold.length() - iLastIndexOf) - 1;
            } else {
                this.used += strFold.length();
            }
        }

        public String toString() {
            return this.f870sb.toString();
        }
    }

    public static class Value {
        public String charset;
        public String encodedValue;
        public String value;

        private Value() {
        }

        public /* synthetic */ Value(Value value) {
            this();
        }
    }

    static {
        try {
            String property = System.getProperty("mail.mime.encodeparameters");
            boolean z = true;
            encodeParameters = property != null && property.equalsIgnoreCase("true");
            String property2 = System.getProperty("mail.mime.decodeparameters");
            decodeParameters = property2 != null && property2.equalsIgnoreCase("true");
            String property3 = System.getProperty("mail.mime.decodeparameters.strict");
            decodeParametersStrict = property3 != null && property3.equalsIgnoreCase("true");
            String property4 = System.getProperty("mail.mime.applefilenames");
            if (property4 == null || !property4.equalsIgnoreCase("true")) {
                z = false;
            }
            applehack = z;
        } catch (SecurityException unused) {
        }
        hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:97:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00ff A[SYNTHETIC] */
    private void combineMultisegmentNames(boolean z) throws ParseException {
        String str;
        String str2;
        StringIndexOutOfBoundsException e;
        NumberFormatException e2;
        UnsupportedEncodingException e3;
        String str3;
        try {
            for (String str4 : this.multisegmentNames) {
                StringBuffer stringBuffer = new StringBuffer();
                MultiValue multiValue = new MultiValue(null);
                int i = 0;
                String str5 = null;
                while (true) {
                    String str6 = String.valueOf(str4) + "*" + i;
                    Object obj = this.slist.get(str6);
                    if (obj == null) {
                        break;
                    }
                    multiValue.add(obj);
                    if (obj instanceof Value) {
                        try {
                            Value value = (Value) obj;
                            str = value.encodedValue;
                            if (i == 0) {
                                try {
                                    Value valueDecodeValue = decodeValue(str);
                                    str2 = valueDecodeValue.charset;
                                    value.charset = str2;
                                    try {
                                        str3 = valueDecodeValue.value;
                                        value.value = str3;
                                    } catch (UnsupportedEncodingException e4) {
                                        e3 = e4;
                                        if (!decodeParametersStrict) {
                                            throw new ParseException(e3.toString());
                                        }
                                        str3 = str;
                                    } catch (NumberFormatException e5) {
                                        e2 = e5;
                                        if (decodeParametersStrict) {
                                            throw new ParseException(e2.toString());
                                        }
                                        str3 = str;
                                    } catch (StringIndexOutOfBoundsException e6) {
                                        e = e6;
                                        if (!decodeParametersStrict) {
                                            throw new ParseException(e.toString());
                                        }
                                        str3 = str;
                                    }
                                } catch (UnsupportedEncodingException e7) {
                                    e = e7;
                                    str2 = str5;
                                    e3 = e;
                                    if (!decodeParametersStrict) {
                                        throw new ParseException(e3.toString());
                                    }
                                    str3 = str;
                                    stringBuffer.append(str3);
                                    this.slist.remove(str6);
                                    i++;
                                    str5 = str2;
                                } catch (NumberFormatException e8) {
                                    e = e8;
                                    str2 = str5;
                                    e2 = e;
                                    if (decodeParametersStrict) {
                                        throw new ParseException(e2.toString());
                                    }
                                    str3 = str;
                                    stringBuffer.append(str3);
                                    this.slist.remove(str6);
                                    i++;
                                    str5 = str2;
                                } catch (StringIndexOutOfBoundsException e9) {
                                    e = e9;
                                    str2 = str5;
                                    e = e;
                                    if (!decodeParametersStrict) {
                                        throw new ParseException(e.toString());
                                    }
                                    str3 = str;
                                    stringBuffer.append(str3);
                                    this.slist.remove(str6);
                                    i++;
                                    str5 = str2;
                                }
                            } else {
                                if (str5 == null) {
                                    this.multisegmentNames.remove(str4);
                                    break;
                                }
                                String strDecodeBytes = decodeBytes(str, str5);
                                value.value = strDecodeBytes;
                                str2 = str5;
                                str3 = strDecodeBytes;
                            }
                        } catch (UnsupportedEncodingException e10) {
                            e = e10;
                            str = null;
                        } catch (NumberFormatException e11) {
                            e = e11;
                            str = null;
                        } catch (StringIndexOutOfBoundsException e12) {
                            e = e12;
                            str = null;
                        }
                    } else {
                        str2 = str5;
                        str3 = (String) obj;
                    }
                    stringBuffer.append(str3);
                    this.slist.remove(str6);
                    i++;
                    str5 = str2;
                }
                if (i == 0) {
                    this.list.remove(str4);
                } else {
                    multiValue.value = stringBuffer.toString();
                    this.list.put(str4, multiValue);
                }
            }
            if (this.slist.size() > 0) {
                for (Object obj2 : this.slist.values()) {
                    if (obj2 instanceof Value) {
                        Value value2 = (Value) obj2;
                        Value valueDecodeValue2 = decodeValue(value2.encodedValue);
                        value2.charset = valueDecodeValue2.charset;
                        value2.value = valueDecodeValue2.value;
                    }
                }
                this.list.putAll(this.slist);
            }
            this.multisegmentNames.clear();
            this.slist.clear();
        } catch (Throwable th) {
            if (z) {
                if (this.slist.size() > 0) {
                    for (Object obj3 : this.slist.values()) {
                        if (obj3 instanceof Value) {
                            Value value3 = (Value) obj3;
                            Value valueDecodeValue3 = decodeValue(value3.encodedValue);
                            value3.charset = valueDecodeValue3.charset;
                            value3.value = valueDecodeValue3.value;
                        }
                    }
                    this.list.putAll(this.slist);
                }
                this.multisegmentNames.clear();
                this.slist.clear();
            }
            throw th;
        }
    }

    private static String decodeBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%') {
                cCharAt = (char) Integer.parseInt(str.substring(i + 1, i + 3), 16);
                i += 2;
            }
            bArr[i2] = (byte) cCharAt;
            i++;
            i2++;
        }
        return new String(bArr, 0, i2, MimeUtility.javaCharset(str2));
    }

    private static Value decodeValue(String str) throws ParseException {
        Value value = new Value(null);
        value.encodedValue = str;
        value.value = str;
        try {
            int iIndexOf = str.indexOf(39);
            if (iIndexOf <= 0) {
                if (!decodeParametersStrict) {
                    return value;
                }
                throw new ParseException("Missing charset in encoded value: " + str);
            }
            String strSubstring = str.substring(0, iIndexOf);
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(39, i);
            if (iIndexOf2 < 0) {
                if (!decodeParametersStrict) {
                    return value;
                }
                throw new ParseException("Missing language in encoded value: " + str);
            }
            str.substring(i, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            value.charset = strSubstring;
            value.value = decodeBytes(strSubstring2, strSubstring);
            return value;
        } catch (UnsupportedEncodingException e) {
            if (decodeParametersStrict) {
                throw new ParseException(e.toString());
            }
        } catch (NumberFormatException e2) {
            if (decodeParametersStrict) {
                throw new ParseException(e2.toString());
            }
        } catch (StringIndexOutOfBoundsException e3) {
            if (decodeParametersStrict) {
                throw new ParseException(e3.toString());
            }
        }
    }

    private static Value encodeValue(String str, String str2) {
        Value value = null;
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b : bytes) {
                char c = (char) (b & StatementImpl.USES_VARIABLES_UNKNOWN);
                if (c <= ' ' || c >= 127 || c == '*' || c == '\'' || c == '%' || HeaderTokenizer.MIME.indexOf(c) >= 0) {
                    stringBuffer.append(StringUtils.WILDCARD_MANY);
                    char[] cArr = hex;
                    stringBuffer.append(cArr[c >> 4]);
                    stringBuffer.append(cArr[c & 15]);
                } else {
                    stringBuffer.append(c);
                }
            }
            Value value2 = new Value(value);
            value2.charset = str2;
            value2.value = str;
            value2.encodedValue = stringBuffer.toString();
            return value2;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void putEncodedName(String str, String str2) throws ParseException {
        Object obj;
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            this.list.put(str, str2);
            return;
        }
        if (iIndexOf == str.length() - 1) {
            this.list.put(str.substring(0, iIndexOf), decodeValue(str2));
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        this.multisegmentNames.add(strSubstring);
        this.list.put(strSubstring, BuildConfig.FLAVOR);
        if (str.endsWith("*")) {
            obj = str2;
            Value value = new Value(null);
            value.encodedValue = str2;
            value.value = str2;
            str = str.substring(0, str.length() - 1);
            obj = value;
        }
        obj = str2;
        this.slist.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        if (obj instanceof MultiValue) {
            return ((MultiValue) obj).value;
        }
        return obj instanceof Value ? ((Value) obj).value : (String) obj;
    }

    public Enumeration getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        if (str == null && str2 != null && str2.equals("DONE")) {
            if (!decodeParameters || this.multisegmentNames.size() <= 0) {
                return;
            }
            try {
                combineMultisegmentNames(true);
                return;
            } catch (ParseException unused) {
                return;
            }
        }
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        if (!decodeParameters) {
            this.list.put(lowerCase, str2);
            return;
        }
        try {
            putEncodedName(lowerCase, str2);
        } catch (ParseException unused2) {
            this.list.put(lowerCase, str2);
        }
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        ToStringBuffer toStringBuffer = new ToStringBuffer(i);
        for (String str : this.list.keySet()) {
            Object obj = this.list.get(str);
            if (obj instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) obj;
                String str2 = String.valueOf(str) + "*";
                for (int i2 = 0; i2 < multiValue.size(); i2++) {
                    Object obj2 = multiValue.get(i2);
                    if (obj2 instanceof Value) {
                        toStringBuffer.addNV(String.valueOf(str2) + i2 + "*", ((Value) obj2).encodedValue);
                    } else {
                        toStringBuffer.addNV(String.valueOf(str2) + i2, (String) obj2);
                    }
                }
            } else if (obj instanceof Value) {
                toStringBuffer.addNV(String.valueOf(str) + "*", ((Value) obj).encodedValue);
            } else {
                toStringBuffer.addNV(str, (String) obj);
            }
        }
        return toStringBuffer.toString();
    }

    public ParameterList(String str) throws ParseException {
        String str2;
        this();
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(str, HeaderTokenizer.MIME);
        while (true) {
            HeaderTokenizer.Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            }
            if (((char) type) == ';') {
                HeaderTokenizer.Token next2 = headerTokenizer.next();
                if (next2.getType() == -4) {
                    break;
                }
                if (next2.getType() == -1) {
                    String lowerCase = next2.getValue().toLowerCase(Locale.ENGLISH);
                    HeaderTokenizer.Token next3 = headerTokenizer.next();
                    if (((char) next3.getType()) == '=') {
                        HeaderTokenizer.Token next4 = headerTokenizer.next();
                        int type2 = next4.getType();
                        if (type2 != -1 && type2 != -2) {
                            throw new ParseException("Expected parameter value, got \"" + next4.getValue() + "\"");
                        }
                        String value = next4.getValue();
                        this.lastName = lowerCase;
                        if (decodeParameters) {
                            putEncodedName(lowerCase, value);
                        } else {
                            this.list.put(lowerCase, value);
                        }
                    } else {
                        throw new ParseException("Expected '=', got \"" + next3.getValue() + "\"");
                    }
                } else {
                    throw new ParseException("Expected parameter name, got \"" + next2.getValue() + "\"");
                }
            } else if (applehack && type == -1 && (str2 = this.lastName) != null && (str2.equals("name") || this.lastName.equals(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME))) {
                this.list.put(this.lastName, String.valueOf((String) this.list.get(this.lastName)) + " " + next.getValue());
            } else {
                throw new ParseException("Expected ';', got \"" + next.getValue() + "\"");
            }
        }
        if (decodeParameters) {
            combineMultisegmentNames(false);
        }
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value valueEncodeValue = encodeValue(str2, str3);
            if (valueEncodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), valueEncodeValue);
                return;
            } else {
                set(str, str2);
                return;
            }
        }
        set(str, str2);
    }
}
