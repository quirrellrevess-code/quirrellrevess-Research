package p051lLi1LL.I1I.p058il;

/* JADX INFO: compiled from: InvalidDataException.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I extends Exception {
    private static final long serialVersionUID = 3731842424390998726L;
    private final int closecode;

    public I1I(int i) {
        this.closecode = i;
    }

    public int getCloseCode() {
        return this.closecode;
    }

    public I1I(int i, String str) {
        super(str);
        this.closecode = i;
    }

    public I1I(int i, Throwable th) {
        super(th);
        this.closecode = i;
    }

    public I1I(int i, String str, Throwable th) {
        super(str, th);
        this.closecode = i;
    }
}
