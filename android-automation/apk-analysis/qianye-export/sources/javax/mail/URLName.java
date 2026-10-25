package javax.mail;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.BitSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class URLName {
    public static final int caseDiff = 32;
    private static boolean doEncode = true;
    public static BitSet dontNeedEncoding;
    private String file;
    public String fullURL;
    private int hashCode;
    private String host;
    private InetAddress hostAddress;
    private boolean hostAddressKnown;
    private String password;
    private int port;
    private String protocol;
    private String ref;
    private String username;

    static {
        try {
            doEncode = !Boolean.getBoolean("mail.URLName.dontencode");
        } catch (Exception unused) {
        }
        dontNeedEncoding = new BitSet(256);
        for (int i = 97; i <= 122; i++) {
            dontNeedEncoding.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            dontNeedEncoding.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            dontNeedEncoding.set(i3);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
    }

    public URLName(String str, String str2, int i, String str3, String str4, String str5) {
        int iIndexOf;
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        this.protocol = str;
        this.host = str2;
        this.port = i;
        if (str3 == null || (iIndexOf = str3.indexOf(35)) == -1) {
            this.file = str3;
            this.ref = null;
        } else {
            this.file = str3.substring(0, iIndexOf);
            this.ref = str3.substring(iIndexOf + 1);
        }
        this.username = doEncode ? encode(str4) : str4;
        this.password = doEncode ? encode(str5) : str5;
    }

    private static String _encode(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (dontNeedEncoding.get(cCharAt)) {
                if (cCharAt == ' ') {
                    cCharAt = '+';
                }
                stringBuffer.append(cCharAt);
            } else {
                try {
                    outputStreamWriter.write(cCharAt);
                    outputStreamWriter.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i2 = 0; i2 < byteArray.length; i2++) {
                        stringBuffer.append(StringUtils.WILDCARD_MANY);
                        char cForDigit = Character.forDigit((byteArray[i2] >> 4) & 15, 16);
                        if (Character.isLetter(cForDigit)) {
                            cForDigit = (char) (cForDigit - ' ');
                        }
                        stringBuffer.append(cForDigit);
                        char cForDigit2 = Character.forDigit(byteArray[i2] & 15, 16);
                        if (Character.isLetter(cForDigit2)) {
                            cForDigit2 = (char) (cForDigit2 - ' ');
                        }
                        stringBuffer.append(cForDigit2);
                    }
                    byteArrayOutputStream.reset();
                } catch (IOException unused) {
                    byteArrayOutputStream.reset();
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (indexOfAny(str, "+%") == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%') {
                try {
                    stringBuffer.append((char) Integer.parseInt(str.substring(i + 1, i + 3), 16));
                    i += 2;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException();
                }
            } else if (cCharAt != '+') {
                stringBuffer.append(cCharAt);
            } else {
                stringBuffer.append(' ');
            }
            i++;
        }
        String string = stringBuffer.toString();
        try {
            return new String(string.getBytes("8859_1"));
        } catch (UnsupportedEncodingException unused2) {
            return string;
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ' || !dontNeedEncoding.get(cCharAt)) {
                return _encode(str);
            }
        }
        return str;
    }

    private synchronized InetAddress getHostAddress() {
        if (this.hostAddressKnown) {
            return this.hostAddress;
        }
        String str = this.host;
        if (str == null) {
            return null;
        }
        try {
            this.hostAddress = InetAddress.getByName(str);
        } catch (UnknownHostException unused) {
            this.hostAddress = null;
        }
        this.hostAddressKnown = true;
        return this.hostAddress;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    public boolean equals(Object obj) {
        URLName uRLName;
        String str;
        String str2;
        if (!(obj instanceof URLName) || (str = (uRLName = (URLName) obj).protocol) == null || !str.equals(this.protocol)) {
            return false;
        }
        InetAddress hostAddress = getHostAddress();
        InetAddress hostAddress2 = uRLName.getHostAddress();
        if (hostAddress == null || hostAddress2 == null) {
            String str3 = this.host;
            if (str3 == null || (str2 = uRLName.host) == null) {
                if (str3 != uRLName.host) {
                    return false;
                }
            } else if (!str3.equalsIgnoreCase(str2)) {
                return false;
            }
        } else if (!hostAddress.equals(hostAddress2)) {
            return false;
        }
        String str4 = this.username;
        String str5 = uRLName.username;
        if (str4 != str5 && (str4 == null || !str4.equals(str5))) {
            return false;
        }
        String str6 = this.file;
        String str7 = BuildConfig.FLAVOR;
        if (str6 == null) {
            str6 = BuildConfig.FLAVOR;
        }
        String str8 = uRLName.file;
        if (str8 != null) {
            str7 = str8;
        }
        return str6.equals(str7) && this.port == uRLName.port;
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return doEncode ? decode(this.password) : this.password;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRef() {
        return this.ref;
    }

    public URL getURL() throws MalformedURLException {
        return new URL(getProtocol(), getHost(), getPort(), getFile());
    }

    public String getUsername() {
        return doEncode ? decode(this.username) : this.username;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.protocol;
        if (str != null) {
            this.hashCode = i + str.hashCode();
        }
        InetAddress hostAddress = getHostAddress();
        if (hostAddress != null) {
            this.hashCode += hostAddress.hashCode();
        } else {
            String str2 = this.host;
            if (str2 != null) {
                this.hashCode += str2.toLowerCase(Locale.ENGLISH).hashCode();
            }
        }
        String str3 = this.username;
        if (str3 != null) {
            this.hashCode += str3.hashCode();
        }
        String str4 = this.file;
        if (str4 != null) {
            this.hashCode += str4.hashCode();
        }
        int i2 = this.hashCode + this.port;
        this.hashCode = i2;
        return i2;
    }

    public void parseString(String str) {
        int iIndexOf;
        String strSubstring;
        this.password = null;
        this.username = null;
        this.host = null;
        this.ref = null;
        this.file = null;
        this.protocol = null;
        this.port = -1;
        int length = str.length();
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 != -1) {
            this.protocol = str.substring(0, iIndexOf2);
        }
        int i = iIndexOf2 + 1;
        if (str.regionMatches(i, "//", 0, 2)) {
            int i2 = iIndexOf2 + 3;
            int iIndexOf3 = str.indexOf(47, i2);
            if (iIndexOf3 != -1) {
                strSubstring = str.substring(i2, iIndexOf3);
                int i3 = iIndexOf3 + 1;
                if (i3 < length) {
                    this.file = str.substring(i3);
                } else {
                    this.file = BuildConfig.FLAVOR;
                }
            } else {
                strSubstring = str.substring(i2);
            }
            int iIndexOf4 = strSubstring.indexOf(64);
            if (iIndexOf4 != -1) {
                String strSubstring2 = strSubstring.substring(0, iIndexOf4);
                strSubstring = strSubstring.substring(iIndexOf4 + 1);
                int iIndexOf5 = strSubstring2.indexOf(58);
                if (iIndexOf5 != -1) {
                    this.username = strSubstring2.substring(0, iIndexOf5);
                    this.password = strSubstring2.substring(iIndexOf5 + 1);
                } else {
                    this.username = strSubstring2;
                }
            }
            int iIndexOf6 = (strSubstring.length() <= 0 || strSubstring.charAt(0) != '[') ? strSubstring.indexOf(58) : strSubstring.indexOf(58, strSubstring.indexOf(93));
            if (iIndexOf6 != -1) {
                String strSubstring3 = strSubstring.substring(iIndexOf6 + 1);
                if (strSubstring3.length() > 0) {
                    try {
                        this.port = Integer.parseInt(strSubstring3);
                    } catch (NumberFormatException unused) {
                        this.port = -1;
                    }
                }
                this.host = strSubstring.substring(0, iIndexOf6);
            } else {
                this.host = strSubstring;
            }
        } else if (i < length) {
            this.file = str.substring(i);
        }
        String str2 = this.file;
        if (str2 == null || (iIndexOf = str2.indexOf(35)) == -1) {
            return;
        }
        this.ref = this.file.substring(iIndexOf + 1);
        this.file = this.file.substring(0, iIndexOf);
    }

    public String toString() {
        if (this.fullURL == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = this.protocol;
            if (str != null) {
                stringBuffer.append(str);
                stringBuffer.append(":");
            }
            if (this.username != null || this.host != null) {
                stringBuffer.append("//");
                String str2 = this.username;
                if (str2 != null) {
                    stringBuffer.append(str2);
                    if (this.password != null) {
                        stringBuffer.append(":");
                        stringBuffer.append(this.password);
                    }
                    stringBuffer.append("@");
                }
                String str3 = this.host;
                if (str3 != null) {
                    stringBuffer.append(str3);
                }
                if (this.port != -1) {
                    stringBuffer.append(":");
                    stringBuffer.append(Integer.toString(this.port));
                }
                if (this.file != null) {
                    stringBuffer.append("/");
                }
            }
            String str4 = this.file;
            if (str4 != null) {
                stringBuffer.append(str4);
            }
            if (this.ref != null) {
                stringBuffer.append("#");
                stringBuffer.append(this.ref);
            }
            this.fullURL = stringBuffer.toString();
        }
        return this.fullURL;
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            while (i < length) {
                if (str2.indexOf(str.charAt(i)) >= 0) {
                    return i;
                }
                i++;
            }
            return -1;
        } catch (StringIndexOutOfBoundsException unused) {
            return -1;
        }
    }

    public URLName(URL url) {
        this(url.toString());
    }

    public URLName(String str) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        parseString(str);
    }
}
