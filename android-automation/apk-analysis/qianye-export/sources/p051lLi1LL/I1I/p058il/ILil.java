package p051lLi1LL.I1I.p058il;

/* JADX INFO: compiled from: IncompleteHandshakeException.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private final int preferredSize;

    public ILil(int i) {
        this.preferredSize = i;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }

    public ILil() {
        this.preferredSize = 0;
    }
}
