package p051lLi1LL.ILil.IL1Iii;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: PendingPostQueue.java */
/* JADX INFO: loaded from: classes.dex */
public final class Ll1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ILL f5567IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ILL f5568ILil;

    public synchronized ILL I1I(int i) throws InterruptedException {
        if (this.f5567IL1Iii == null) {
            wait(i);
        }
        return ILil();
    }

    public synchronized void IL1Iii(ILL ill) {
        try {
            if (ill == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            ILL ill2 = this.f5568ILil;
            if (ill2 != null) {
                ill2.f5551I1I = ill;
                this.f5568ILil = ill;
            } else {
                if (this.f5567IL1Iii != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f5568ILil = ill;
                this.f5567IL1Iii = ill;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ILL ILil() {
        ILL ill;
        ill = this.f5567IL1Iii;
        if (ill != null) {
            ILL ill2 = ill.f5551I1I;
            this.f5567IL1Iii = ill2;
            if (ill2 == null) {
                this.f5568ILil = null;
            }
        }
        return ill;
    }
}
