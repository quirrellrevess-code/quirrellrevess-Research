package I1I.p062Ilil.p064Ilil.I1I;

/* JADX INFO: compiled from: VolatileDispose.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil<T> {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public volatile T f3512IL1Iii;

    public T IL1Iii() {
        synchronized (this) {
            if (this.f3512IL1Iii != null) {
                return this.f3512IL1Iii;
            }
            try {
                wait();
                return this.f3512IL1Iii;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ILil(T t) {
        synchronized (this) {
            this.f3512IL1Iii = t;
            notify();
        }
    }
}
