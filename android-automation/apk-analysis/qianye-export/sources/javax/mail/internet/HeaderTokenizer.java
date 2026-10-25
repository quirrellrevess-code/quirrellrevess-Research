package javax.mail.internet;

import com.google.android.flexbox.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    public static class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public Token(int i, String str) {
            this.type = i;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public HeaderTokenizer(String str, String str2, boolean z) {
        str = str == null ? BuildConfig.FLAVOR : str;
        this.string = str;
        this.skipComments = z;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = str.length();
    }

    private static String filterToken(String str, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        boolean z2 = false;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n' && z) {
                z = false;
            } else if (z2) {
                stringBuffer.append(cCharAt);
                z = false;
                z2 = false;
            } else if (cCharAt == '\\') {
                z = false;
                z2 = true;
            } else if (cCharAt == '\r') {
                z = true;
            } else {
                stringBuffer.append(cCharAt);
                z = false;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private Token getNext() throws ParseException {
        char cCharAt;
        if (this.currentPos >= this.maxPos) {
            return EOFToken;
        }
        if (skipWhiteSpace() == -4) {
            return EOFToken;
        }
        char cCharAt2 = this.string.charAt(this.currentPos);
        boolean z = false;
        while (cCharAt2 == '(') {
            int i = this.currentPos + 1;
            this.currentPos = i;
            int i2 = 1;
            while (i2 > 0) {
                int i3 = this.currentPos;
                if (i3 >= this.maxPos) {
                    break;
                }
                char cCharAt3 = this.string.charAt(i3);
                if (cCharAt3 == '\\') {
                    this.currentPos++;
                } else {
                    if (cCharAt3 != '\r') {
                        if (cCharAt3 == '(') {
                            i2++;
                        } else if (cCharAt3 == ')') {
                            i2--;
                        }
                    }
                    this.currentPos++;
                }
                z = true;
                this.currentPos++;
            }
            if (i2 != 0) {
                throw new ParseException("Unbalanced comments");
            }
            if (!this.skipComments) {
                return new Token(-3, z ? filterToken(this.string, i, this.currentPos - 1) : this.string.substring(i, this.currentPos - 1));
            }
            if (skipWhiteSpace() == -4) {
                return EOFToken;
            }
            cCharAt2 = this.string.charAt(this.currentPos);
        }
        if (cCharAt2 != '\"') {
            if (cCharAt2 < ' ' || cCharAt2 >= 127 || this.delimiters.indexOf(cCharAt2) >= 0) {
                this.currentPos++;
                return new Token(cCharAt2, new String(new char[]{cCharAt2}));
            }
            int i4 = this.currentPos;
            while (true) {
                int i5 = this.currentPos;
                if (i5 >= this.maxPos || (cCharAt = this.string.charAt(i5)) < ' ' || cCharAt >= 127 || cCharAt == '(' || cCharAt == ' ' || cCharAt == '\"' || this.delimiters.indexOf(cCharAt) >= 0) {
                    break;
                }
                this.currentPos++;
            }
            return new Token(-1, this.string.substring(i4, this.currentPos));
        }
        int i6 = this.currentPos + 1;
        this.currentPos = i6;
        while (true) {
            int i7 = this.currentPos;
            if (i7 >= this.maxPos) {
                throw new ParseException("Unbalanced quoted string");
            }
            char cCharAt4 = this.string.charAt(i7);
            if (cCharAt4 == '\\') {
                this.currentPos++;
            } else {
                if (cCharAt4 != '\r') {
                    if (cCharAt4 == '\"') {
                        int i8 = this.currentPos + 1;
                        this.currentPos = i8;
                        return new Token(-2, z ? filterToken(this.string, i6, i8 - 1) : this.string.substring(i6, i8 - 1));
                    }
                }
                this.currentPos++;
            }
            z = true;
            this.currentPos++;
        }
    }

    private int skipWhiteSpace() {
        while (true) {
            int i = this.currentPos;
            if (i >= this.maxPos) {
                return -4;
            }
            char cCharAt = this.string.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                return this.currentPos;
            }
            this.currentPos++;
        }
    }

    public String getRemainder() {
        return this.string.substring(this.nextPos);
    }

    public Token next() throws ParseException {
        this.currentPos = this.nextPos;
        Token next = getNext();
        int i = this.currentPos;
        this.peekPos = i;
        this.nextPos = i;
        return next;
    }

    public Token peek() throws ParseException {
        this.currentPos = this.peekPos;
        Token next = getNext();
        this.peekPos = this.currentPos;
        return next;
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str) {
        this(str, RFC822);
    }
}
