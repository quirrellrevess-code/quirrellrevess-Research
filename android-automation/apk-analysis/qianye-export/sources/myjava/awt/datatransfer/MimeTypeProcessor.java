package myjava.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public final class MimeTypeProcessor {
    private static MimeTypeProcessor instance;

    private MimeTypeProcessor() {
    }

    public static String assemble(MimeType mimeType) {
        StringBuilder sb = new StringBuilder();
        sb.append(mimeType.getFullType());
        Enumeration enumerationKeys = mimeType.parameters.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            String str2 = (String) mimeType.parameters.get(str);
            sb.append("; ");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append('\"');
        }
        return sb.toString();
    }

    private static int getNextMeaningfulIndex(String str, int i) {
        while (i < str.length() && !isMeaningfulChar(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static boolean isMeaningfulChar(char c) {
        return c >= '!' && c <= '~';
    }

    private static boolean isTSpecialChar(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' || c == '<' || c == '>' || c == '@' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '\"' || c == '/' || c == '?' || c == '=';
    }

    public static MimeType parse(String str) {
        if (instance == null) {
            instance = new MimeTypeProcessor();
        }
        MimeType mimeType = new MimeType();
        if (str != null) {
            StringPosition stringPosition = new StringPosition(null);
            retrieveType(str, mimeType, stringPosition);
            retrieveParams(str, mimeType, stringPosition);
        }
        return mimeType;
    }

    private static void retrieveParam(String str, MimeType mimeType, StringPosition stringPosition) {
        String lowerCase = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f881i);
        stringPosition.f881i = nextMeaningfulIndex;
        if (nextMeaningfulIndex >= str.length() || str.charAt(stringPosition.f881i) != '=') {
            throw new IllegalArgumentException();
        }
        int i = stringPosition.f881i + 1;
        stringPosition.f881i = i;
        int nextMeaningfulIndex2 = getNextMeaningfulIndex(str, i);
        stringPosition.f881i = nextMeaningfulIndex2;
        if (nextMeaningfulIndex2 >= str.length()) {
            throw new IllegalArgumentException();
        }
        mimeType.parameters.put(lowerCase, str.charAt(stringPosition.f881i) == '\"' ? retrieveQuoted(str, stringPosition) : retrieveToken(str, stringPosition));
    }

    private static void retrieveParams(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.parameters = new Hashtable();
        mimeType.systemParameters = new Hashtable();
        while (true) {
            int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f881i);
            stringPosition.f881i = nextMeaningfulIndex;
            if (nextMeaningfulIndex >= str.length()) {
                return;
            }
            if (str.charAt(stringPosition.f881i) != ';') {
                throw new IllegalArgumentException();
            }
            stringPosition.f881i++;
            retrieveParam(str, mimeType, stringPosition);
        }
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        stringPosition.f881i++;
        boolean z = true;
        do {
            if (str.charAt(stringPosition.f881i) == '\"' && z) {
                stringPosition.f881i++;
                return sb.toString();
            }
            int i = stringPosition.f881i;
            stringPosition.f881i = i + 1;
            char cCharAt = str.charAt(i);
            if (!z) {
                z = true;
            } else if (cCharAt == '\\') {
                z = false;
            }
            if (z) {
                sb.append(cCharAt);
            }
        } while (stringPosition.f881i != str.length());
        throw new IllegalArgumentException();
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f881i);
        stringPosition.f881i = nextMeaningfulIndex;
        if (nextMeaningfulIndex >= str.length() || isTSpecialChar(str.charAt(stringPosition.f881i))) {
            throw new IllegalArgumentException();
        }
        do {
            int i = stringPosition.f881i;
            stringPosition.f881i = i + 1;
            sb.append(str.charAt(i));
            if (stringPosition.f881i >= str.length() || !isMeaningfulChar(str.charAt(stringPosition.f881i))) {
                break;
            }
        } while (!isTSpecialChar(str.charAt(stringPosition.f881i)));
        return sb.toString();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.primaryType = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f881i);
        stringPosition.f881i = nextMeaningfulIndex;
        if (nextMeaningfulIndex >= str.length() || str.charAt(stringPosition.f881i) != '/') {
            throw new IllegalArgumentException();
        }
        stringPosition.f881i++;
        mimeType.subType = retrieveToken(str, stringPosition).toLowerCase();
    }

    public static final class StringPosition {

        /* JADX INFO: renamed from: i */
        public int f881i;

        private StringPosition() {
            this.f881i = 0;
        }

        public /* synthetic */ StringPosition(StringPosition stringPosition) {
            this();
        }
    }

    public static final class MimeType implements Cloneable, Serializable {
        private static final long serialVersionUID = -6693571907475992044L;
        private Hashtable<String, String> parameters;
        private String primaryType;
        private String subType;
        private Hashtable<String, Object> systemParameters;

        public MimeType() {
            this.primaryType = null;
            this.subType = null;
            this.parameters = null;
            this.systemParameters = null;
        }

        public void addParameter(String str, String str2) {
            if (str2 == null) {
                return;
            }
            if (str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                str2 = str2.substring(1, str2.length() - 2);
            }
            if (str2.length() == 0) {
                return;
            }
            this.parameters.put(str, str2);
        }

        public void addSystemParameter(String str, Object obj) {
            this.systemParameters.put(str, obj);
        }

        public Object clone() {
            MimeType mimeType = new MimeType(this.primaryType, this.subType);
            mimeType.parameters = (Hashtable) this.parameters.clone();
            mimeType.systemParameters = (Hashtable) this.systemParameters.clone();
            return mimeType;
        }

        public boolean equals(MimeType mimeType) {
            if (mimeType == null) {
                return false;
            }
            return getFullType().equals(mimeType.getFullType());
        }

        public String getFullType() {
            return String.valueOf(this.primaryType) + "/" + this.subType;
        }

        public String getParameter(String str) {
            return this.parameters.get(str);
        }

        public String getPrimaryType() {
            return this.primaryType;
        }

        public String getSubType() {
            return this.subType;
        }

        public Object getSystemParameter(String str) {
            return this.systemParameters.get(str);
        }

        public void removeParameter(String str) {
            this.parameters.remove(str);
        }

        public MimeType(String str, String str2) {
            this.primaryType = str;
            this.subType = str2;
            this.parameters = new Hashtable<>();
            this.systemParameters = new Hashtable<>();
        }
    }
}
