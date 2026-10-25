package p051lLi1LL.ILil.IL1Iii;

import java.util.logging.Level;

/* JADX INFO: compiled from: BackgroundPoster.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILil implements Runnable, lIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final I1I f5554I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Ll1 f5555ILil = new Ll1();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public volatile boolean f3048IL;

    public ILil(I1I i1i) {
        this.f5554I1I = i1i;
    }

    @Override // p051lLi1LL.ILil.IL1Iii.lIiI
    public void IL1Iii(lIlii lilii, Object obj) {
        ILL illIL1Iii = ILL.IL1Iii(lilii, obj);
        synchronized (this) {
            this.f5555ILil.IL1Iii(illIL1Iii);
            if (!this.f3048IL) {
                this.f3048IL = true;
                this.f5554I1I.m3663IL().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    ILL illI1I = this.f5555ILil.I1I(1000);
                    if (illI1I == null) {
                        synchronized (this) {
                            illI1I = this.f5555ILil.ILil();
                            if (illI1I == null) {
                                this.f3048IL = false;
                                this.f3048IL = false;
                                return;
                            }
                        }
                    }
                    this.f5554I1I.m3667iILLL1(illI1I);
                } catch (InterruptedException e) {
                    this.f5554I1I.Ilil().ILil(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.f3048IL = false;
                    return;
                }
            } catch (Throwable th) {
                this.f3048IL = false;
                throw th;
            }
        }
    }
}
