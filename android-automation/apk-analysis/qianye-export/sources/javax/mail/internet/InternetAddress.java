package javax.mail.internet;

import com.mysql.jdbc.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Session;

/* JADX INFO: loaded from: classes.dex */
public class InternetAddress extends Address implements Cloneable {
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace(' ', (char) 0).replace('\t', (char) 0);
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    public String address;
    public String encodedPersonal;
    public String personal;

    public InternetAddress() {
    }

    private static void checkAddress(String str, boolean z, boolean z2) throws AddressException {
        String strSubstring;
        String strSubstring2;
        if (str.indexOf(34) >= 0) {
            return;
        }
        int i = 0;
        if (z) {
            while (true) {
                int iIndexOfAny = indexOfAny(str, ",:", i);
                if (iIndexOfAny < 0) {
                    break;
                }
                if (str.charAt(i) != '@') {
                    throw new AddressException("Illegal route-addr", str);
                }
                if (str.charAt(iIndexOfAny) == ':') {
                    i = iIndexOfAny + 1;
                    break;
                }
                i = iIndexOfAny + 1;
            }
        }
        int iIndexOf = str.indexOf(64, i);
        if (iIndexOf >= 0) {
            if (iIndexOf == i) {
                throw new AddressException("Missing local name", str);
            }
            if (iIndexOf == str.length() - 1) {
                throw new AddressException("Missing domain", str);
            }
            strSubstring2 = str.substring(i, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1);
        } else {
            if (z2) {
                throw new AddressException("Missing final '@domain'", str);
            }
            strSubstring = null;
            strSubstring2 = str;
        }
        if (indexOfAny(str, " \t\n\r") >= 0) {
            throw new AddressException("Illegal whitespace in address", str);
        }
        if (indexOfAny(strSubstring2, specialsNoDot) >= 0) {
            throw new AddressException("Illegal character in local name", str);
        }
        if (strSubstring != null && strSubstring.indexOf(91) < 0 && indexOfAny(strSubstring, specialsNoDot) >= 0) {
            throw new AddressException("Illegal character in domain", str);
        }
    }

    public static InternetAddress getLocalAddress(Session session) {
        String property;
        String property2;
        String hostName;
        InetAddress localHost;
        try {
            if (session == null) {
                property2 = System.getProperty("user.name");
                hostName = InetAddress.getLocalHost().getHostName();
                property = null;
            } else {
                property = session.getProperty("mail.from");
                if (property == null) {
                    String property3 = session.getProperty("mail.user");
                    if (property3 == null || property3.length() == 0) {
                        property3 = session.getProperty("user.name");
                    }
                    String property4 = (property3 == null || property3.length() == 0) ? System.getProperty("user.name") : property3;
                    String property5 = session.getProperty("mail.host");
                    if ((property5 == null || property5.length() == 0) && (localHost = InetAddress.getLocalHost()) != null) {
                        property5 = localHost.getHostName();
                    }
                    String str = property4;
                    hostName = property5;
                    property2 = str;
                } else {
                    property2 = null;
                    hostName = null;
                }
            }
            if (property == null && property2 != null && property2.length() != 0 && hostName != null && hostName.length() != 0) {
                property = String.valueOf(property2) + "@" + hostName;
            }
            if (property != null) {
                return new InternetAddress(property);
            }
        } catch (SecurityException | UnknownHostException | AddressException unused) {
        }
        return null;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private boolean isSimple() {
        String str = this.address;
        return str == null || indexOfAny(str, specialsNoDotNoAt) < 0;
    }

    private static int lengthOfFirstSegment(String str) {
        int iIndexOf = str.indexOf("\r\n");
        return iIndexOf != -1 ? iIndexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i) {
        int iLastIndexOf = str.lastIndexOf("\r\n");
        return iLastIndexOf != -1 ? (str.length() - iLastIndexOf) - 2 : str.length() + i;
    }

    public static InternetAddress[] parse(String str) throws AddressException {
        return parse(str, true);
    }

    public static InternetAddress[] parseHeader(String str, boolean z) throws AddressException {
        return parse(str, z, true);
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"' || cCharAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == '\"' || cCharAt2 == '\\') {
                        stringBuffer.append(StringUtils.WILDCARD_ESCAPE);
                    }
                    stringBuffer.append(cCharAt2);
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
            if ((cCharAt < ' ' && cCharAt != '\r' && cCharAt != '\n' && cCharAt != '\t') || cCharAt >= 127 || rfc822phrase.indexOf(cCharAt) >= 0) {
                z = true;
            }
        }
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer(length + 2);
        stringBuffer2.append('\"');
        stringBuffer2.append(str);
        stringBuffer2.append('\"');
        return stringBuffer2.toString();
    }

    private static String unquote(String str) {
        if (!str.startsWith("\"") || !str.endsWith("\"")) {
            return str;
        }
        String strSubstring = str.substring(1, str.length() - 1);
        if (strSubstring.indexOf(92) < 0) {
            return strSubstring;
        }
        StringBuffer stringBuffer = new StringBuffer(strSubstring.length());
        int i = 0;
        while (i < strSubstring.length()) {
            char cCharAt = strSubstring.charAt(i);
            if (cCharAt == '\\' && i < strSubstring.length() - 1) {
                i++;
                cCharAt = strSubstring.charAt(i);
            }
            stringBuffer.append(cCharAt);
            i++;
        }
        return stringBuffer.toString();
    }

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // javax.mail.Address
    public boolean equals(Object obj) {
        if (!(obj instanceof InternetAddress)) {
            return false;
        }
        String address = ((InternetAddress) obj).getAddress();
        String str = this.address;
        if (address == str) {
            return true;
        }
        return str != null && str.equalsIgnoreCase(address);
    }

    public String getAddress() {
        return this.address;
    }

    public InternetAddress[] getGroup(boolean z) throws AddressException {
        int iIndexOf;
        String address = getAddress();
        if (address.endsWith(";") && (iIndexOf = address.indexOf(58)) >= 0) {
            return parseHeader(address.substring(iIndexOf + 1, address.length() - 1), z);
        }
        return null;
    }

    public String getPersonal() {
        String str = this.personal;
        if (str != null) {
            return str;
        }
        String str2 = this.encodedPersonal;
        if (str2 == null) {
            return null;
        }
        try {
            String strDecodeText = MimeUtility.decodeText(str2);
            this.personal = strDecodeText;
            return strDecodeText;
        } catch (Exception unused) {
            return this.encodedPersonal;
        }
    }

    @Override // javax.mail.Address
    public String getType() {
        return "rfc822";
    }

    public int hashCode() {
        String str = this.address;
        if (str == null) {
            return 0;
        }
        return str.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public boolean isGroup() {
        String str = this.address;
        return str != null && str.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPersonal(String str, String str2) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, null);
        } else {
            this.encodedPersonal = null;
        }
    }

    @Override // javax.mail.Address
    public String toString() {
        String str;
        if (this.encodedPersonal == null && (str = this.personal) != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        String str2 = this.encodedPersonal;
        if (str2 != null) {
            return String.valueOf(quotePhrase(str2)) + " <" + this.address + ">";
        }
        if (isGroup() || isSimple()) {
            return this.address;
        }
        return "<" + this.address + ">";
    }

    public String toUnicodeString() {
        String personal = getPersonal();
        if (personal != null) {
            return String.valueOf(quotePhrase(personal)) + " <" + this.address + ">";
        }
        if (isGroup() || isSimple()) {
            return this.address;
        }
        return "<" + this.address + ">";
    }

    public void validate() throws AddressException {
        checkAddress(getAddress(), true, true);
    }

    public InternetAddress(String str) throws AddressException {
        InternetAddress[] internetAddressArr = parse(str, true);
        if (internetAddressArr.length != 1) {
            throw new AddressException("Illegal address", str);
        }
        this.address = internetAddressArr[0].address;
        this.personal = internetAddressArr[0].personal;
        this.encodedPersonal = internetAddressArr[0].encodedPersonal;
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

    public static InternetAddress[] parse(String str, boolean z) throws AddressException {
        return parse(str, z, false);
    }

    /* JADX WARN: Code duplicated, block: B:178:0x0239  */
    /* JADX WARN: Code duplicated, block: B:187:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x023c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:70:0x00de  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ec  */
    private static InternetAddress[] parse(String str, boolean z, boolean z2) throws AddressException {
        int i;
        int length = str.length();
        Vector vector = new Vector();
        boolean z3 = false;
        int i2 = 0;
        int i3 = -1;
        boolean z4 = false;
        boolean z5 = false;
        int i4 = -1;
        boolean z6 = false;
        int i5 = -1;
        int i6 = -1;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ') {
                i = 1;
            } else if (cCharAt == '\"') {
                if (i3 == -1) {
                    i3 = i2;
                }
                i2++;
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 != '\"') {
                        if (cCharAt2 == '\\') {
                            i2++;
                        }
                        i2++;
                    } else {
                        if (i2 < length) {
                            throw new AddressException("Missing '\"'", str, i2);
                        }
                        i = 1;
                        z6 = true;
                    }
                }
                if (i2 < length) {
                    throw new AddressException("Missing '\"'", str, i2);
                }
                i = 1;
                z6 = true;
            } else if (cCharAt != ',') {
                if (cCharAt == '>') {
                    throw new AddressException("Missing '<'", str, i2);
                }
                if (cCharAt != '[') {
                    if (cCharAt != '(') {
                        if (cCharAt == ')') {
                            throw new AddressException("Missing '('", str, i2);
                        }
                        switch (cCharAt) {
                            case ':':
                                if (z4) {
                                    throw new AddressException("Nested group", str, i2);
                                }
                                if (i3 == -1) {
                                    i3 = i2;
                                }
                                i = 1;
                                z4 = true;
                                z6 = true;
                                break;
                            case ';':
                                if (i3 == -1) {
                                    i3 = i2;
                                }
                                if (z4) {
                                    if (i3 == -1) {
                                        i3 = i2;
                                    }
                                    InternetAddress internetAddress = new InternetAddress();
                                    internetAddress.setAddress(str.substring(i3, i2 + 1).trim());
                                    vector.addElement(internetAddress);
                                    i = 1;
                                    i3 = -1;
                                    z4 = false;
                                    z5 = false;
                                    i4 = -1;
                                } else {
                                    throw new AddressException("Illegal semicolon, not in group", str, i2);
                                }
                                break;
                            case '<':
                                if (z5) {
                                    throw new AddressException("Extra route-addr", str, i2);
                                }
                                if (!z4) {
                                    if (i3 >= 0) {
                                        i6 = i2;
                                    }
                                    i5 = i3;
                                    i3 = i2 + 1;
                                }
                                i2++;
                                boolean z7 = false;
                                while (i2 < length) {
                                    char cCharAt3 = str.charAt(i2);
                                    if (cCharAt3 == '\"') {
                                        z7 = !z7;
                                    } else if (cCharAt3 == '>') {
                                        if (!z7) {
                                            if (i2 >= length) {
                                                if (z7) {
                                                    throw new AddressException("Missing '\"'", str, i2);
                                                }
                                                throw new AddressException("Missing '>'", str, i2);
                                            }
                                            i4 = i2;
                                            i = 1;
                                            z5 = true;
                                            z6 = true;
                                        }
                                    } else if (cCharAt3 == '\\') {
                                        i2++;
                                    }
                                    i2++;
                                    break;
                                }
                                if (i2 >= length) {
                                    if (z7) {
                                        throw new AddressException("Missing '\"'", str, i2);
                                    }
                                    throw new AddressException("Missing '>'", str, i2);
                                }
                                i4 = i2;
                                i = 1;
                                z5 = true;
                                z6 = true;
                                break;
                            default:
                                if (i3 != -1) {
                                    i = 1;
                                } else {
                                    i3 = i2;
                                    i = 1;
                                }
                                break;
                        }
                    } else {
                        if (i3 >= 0 && i4 == -1) {
                            i4 = i2;
                        }
                        if (i5 == -1) {
                            i5 = i2 + 1;
                        }
                        int i7 = i2 + 1;
                        int i8 = 1;
                        while (i7 < length && i8 > 0) {
                            char cCharAt4 = str.charAt(i7);
                            if (cCharAt4 == '(') {
                                i8++;
                            } else if (cCharAt4 == ')') {
                                i8--;
                            } else if (cCharAt4 == '\\') {
                                i7++;
                            }
                            i7++;
                        }
                        if (i8 > 0) {
                            throw new AddressException("Missing ')'", str, i7);
                        }
                        i2 = i7 - 1;
                        if (i6 == -1) {
                            i6 = i2;
                        }
                    }
                } else {
                    i2++;
                    while (i2 < length) {
                        char cCharAt5 = str.charAt(i2);
                        if (cCharAt5 == '\\') {
                            i2++;
                        } else if (cCharAt5 == ']') {
                            if (i2 >= length) {
                                throw new AddressException("Missing ']'", str, i2);
                            }
                        }
                        i2++;
                    }
                    if (i2 >= length) {
                        throw new AddressException("Missing ']'", str, i2);
                    }
                }
                i = 1;
                z6 = true;
            } else if (i3 == -1) {
                i = 1;
                i3 = -1;
                z5 = false;
                i4 = -1;
                z6 = false;
            } else if (z4) {
                i = 1;
                z5 = false;
            } else {
                if (i4 == -1) {
                    i4 = i2;
                }
                String strTrim = str.substring(i3, i4).trim();
                if (!z6 && !z && !z2) {
                    StringTokenizer stringTokenizer = new StringTokenizer(strTrim);
                    while (stringTokenizer.hasMoreTokens()) {
                        String strNextToken = stringTokenizer.nextToken();
                        checkAddress(strNextToken, false, false);
                        InternetAddress internetAddress2 = new InternetAddress();
                        internetAddress2.setAddress(strNextToken);
                        vector.addElement(internetAddress2);
                    }
                } else {
                    if (z || !z2) {
                        checkAddress(strTrim, z5, false);
                    }
                    InternetAddress internetAddress3 = new InternetAddress();
                    internetAddress3.setAddress(strTrim);
                    if (i5 >= 0) {
                        internetAddress3.encodedPersonal = unquote(str.substring(i5, i6).trim());
                        i5 = -1;
                        i6 = -1;
                    }
                    vector.addElement(internetAddress3);
                }
                i = 1;
                i3 = -1;
                z5 = false;
                i4 = -1;
                z6 = false;
            }
            i2 += i;
            z3 = false;
        }
        if (i3 >= 0) {
            if (i4 != -1) {
                i2 = i4;
            }
            String strTrim2 = str.substring(i3, i2).trim();
            if (!z6 && !z && !z2) {
                StringTokenizer stringTokenizer2 = new StringTokenizer(strTrim2);
                while (stringTokenizer2.hasMoreTokens()) {
                    String strNextToken2 = stringTokenizer2.nextToken();
                    checkAddress(strNextToken2, z3, z3);
                    InternetAddress internetAddress4 = new InternetAddress();
                    internetAddress4.setAddress(strNextToken2);
                    vector.addElement(internetAddress4);
                }
            } else {
                if (z || !z2) {
                    checkAddress(strTrim2, z5, z3);
                }
                InternetAddress internetAddress5 = new InternetAddress();
                internetAddress5.setAddress(strTrim2);
                if (i5 >= 0) {
                    internetAddress5.encodedPersonal = unquote(str.substring(i5, i6).trim());
                }
                vector.addElement(internetAddress5);
            }
        }
        InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
        vector.copyInto(internetAddressArr);
        return internetAddressArr;
    }

    public void setPersonal(String str) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str);
        } else {
            this.encodedPersonal = null;
        }
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public InternetAddress(String str, boolean z) throws AddressException {
        this(str);
        if (z) {
            checkAddress(this.address, true, true);
        }
    }

    public static String toString(Address[] addressArr, int i) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
                i += 2;
            }
            String string = addressArr[i2].toString();
            if (lengthOfFirstSegment(string) + i > 76) {
                stringBuffer.append("\r\n\t");
                i = 8;
            }
            stringBuffer.append(string);
            i = lengthOfLastSegment(string, i);
        }
        return stringBuffer.toString();
    }

    public InternetAddress(String str, String str2) throws UnsupportedEncodingException {
        this(str, str2, null);
    }

    public InternetAddress(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.address = str;
        setPersonal(str2, str3);
    }
}
