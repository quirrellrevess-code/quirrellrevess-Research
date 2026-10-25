package com.mysql.jdbc;

/* JADX INFO: loaded from: classes.dex */
public class EscapeTokenizer {
    private static final char CHR_BEGIN_TOKEN = '{';
    private static final char CHR_COMMENT = '-';
    private static final char CHR_CR = '\r';
    private static final char CHR_DBL_QUOTE = '\"';
    private static final char CHR_END_TOKEN = '}';
    private static final char CHR_ESCAPE = '\\';
    private static final char CHR_LF = '\n';
    private static final char CHR_SGL_QUOTE = '\'';
    private static final char CHR_VARIABLE = '@';
    private int pos;
    private String source;
    private int sourceLength;
    private boolean emittingEscapeCode = false;
    private boolean sawVariableUse = false;
    private int bracesLevel = 0;
    private boolean inQuotes = false;
    private char quoteChar = 0;

    public EscapeTokenizer(String str) {
        this.source = null;
        this.sourceLength = 0;
        this.pos = 0;
        this.source = str;
        this.sourceLength = str.length();
        this.pos = 0;
    }

    public synchronized boolean hasMoreTokens() {
        return this.pos < this.sourceLength;
    }

    public synchronized String nextToken() {
        int i;
        StringBuilder sb = new StringBuilder();
        if (this.emittingEscapeCode) {
            sb.append("{");
            this.emittingEscapeCode = false;
        }
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.sourceLength) {
                return sb.toString();
            }
            char cCharAt = this.source.charAt(i2);
            if (cCharAt == '\\') {
                sb.append(cCharAt);
                z = !z;
            } else if ((cCharAt == '\'' || cCharAt == '\"') && !z) {
                sb.append(cCharAt);
                if (!this.inQuotes) {
                    this.inQuotes = true;
                    this.quoteChar = cCharAt;
                } else if (cCharAt == this.quoteChar) {
                    int i3 = this.pos;
                    if (i3 + 1 >= this.sourceLength || this.source.charAt(i3 + 1) != this.quoteChar) {
                        this.inQuotes = false;
                    } else {
                        sb.append(cCharAt);
                        this.pos++;
                    }
                }
            } else {
                if (cCharAt != '\n' && cCharAt != '\r' && !this.inQuotes && !z) {
                    if (cCharAt == '-') {
                        sb.append(cCharAt);
                        int i4 = this.pos;
                        if (i4 + 1 < this.sourceLength && this.source.charAt(i4 + 1) == '-') {
                            while (true) {
                                i = this.pos + 1;
                                this.pos = i;
                                if (i >= this.sourceLength || cCharAt == '\n' || cCharAt == '\r') {
                                    break;
                                }
                                cCharAt = this.source.charAt(i);
                                sb.append(cCharAt);
                            }
                            this.pos = i - 1;
                        }
                    } else if (cCharAt == '{') {
                        int i5 = this.bracesLevel + 1;
                        this.bracesLevel = i5;
                        if (i5 == 1) {
                            this.emittingEscapeCode = true;
                            this.pos++;
                            return sb.toString();
                        }
                        sb.append(cCharAt);
                    } else if (cCharAt == '}') {
                        sb.append(cCharAt);
                        int i6 = this.bracesLevel - 1;
                        this.bracesLevel = i6;
                        if (i6 == 0) {
                            this.pos++;
                            return sb.toString();
                        }
                    } else if (cCharAt == '@') {
                        this.sawVariableUse = true;
                    }
                }
                sb.append(cCharAt);
                z = false;
            }
            this.pos++;
        }
    }

    public boolean sawVariableUse() {
        return this.sawVariableUse;
    }
}
