package p051lLi1LL.I1I.p058il;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: l丨Li1LL.I1I.丨il.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: InvalidEncodingException.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends RuntimeException {
    private final UnsupportedEncodingException encodingException;

    public IL(UnsupportedEncodingException unsupportedEncodingException) {
        if (unsupportedEncodingException == null) {
            throw new IllegalArgumentException();
        }
        this.encodingException = unsupportedEncodingException;
    }

    public UnsupportedEncodingException getEncodingException() {
        return this.encodingException;
    }
}
