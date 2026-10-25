package androidx.lifecycle;

import ILil.I1I.IL1Iii.ILil.ILil;
import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.InterfaceC0641ILl;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final Object f2659L11I = new Object();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public volatile Object f5035Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public volatile Object f2660IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2661IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f2662iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2663lLi1LL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f5033IL1Iii = new Object();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ILil<InterfaceC0641ILl<? super T>, LiveData<T>.IL1Iii> f5034ILil = new ILil<>();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f5032I1I = 0;

    public abstract class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5036I1I = -1;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final InterfaceC0641ILl<? super T> f5037IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f5038ILil;

        public IL1Iii(InterfaceC0641ILl<? super T> interfaceC0641ILl) {
            this.f5037IL1Iii = interfaceC0641ILl;
        }

        public abstract boolean ILL();

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m3228IiL(boolean z) {
            if (z == this.f5038ILil) {
                return;
            }
            this.f5038ILil = z;
            LiveData liveData = LiveData.this;
            int i = liveData.f5032I1I;
            boolean z2 = i == 0;
            liveData.f5032I1I = i + (z ? 1 : -1);
            if (z2 && z) {
                liveData.Ilil();
            }
            LiveData liveData2 = LiveData.this;
            if (liveData2.f5032I1I == 0 && !this.f5038ILil) {
                liveData2.mo1936lLi1LL();
            }
            if (this.f5038ILil) {
                LiveData.this.I1I(this);
            }
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void mo3229L11I() {
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean mo3230il(IiL iiL) {
            return false;
        }
    }

    public class LifecycleBoundObserver extends LiveData<T>.IL1Iii implements Object {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final IiL f5039Ilil;

        public LifecycleBoundObserver(IiL iiL, InterfaceC0641ILl<? super T> interfaceC0641ILl) {
            super(interfaceC0641ILl);
            this.f5039Ilil = iiL;
        }

        public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
            if (this.f5039Ilil.getLifecycle().ILil() == IL.ILil.DESTROYED) {
                LiveData.this.mo1935iILLL1(this.f5037IL1Iii);
            } else {
                m3228IiL(ILL());
            }
        }

        @Override // androidx.lifecycle.LiveData.IL1Iii
        public boolean ILL() {
            return this.f5039Ilil.getLifecycle().ILil().isAtLeast(IL.ILil.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.IL1Iii
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo3229L11I() {
            this.f5039Ilil.getLifecycle().I1I(this);
        }

        @Override // androidx.lifecycle.LiveData.IL1Iii
        /* JADX INFO: renamed from: 丨il */
        public boolean mo3230il(IiL iiL) {
            return this.f5039Ilil == iiL;
        }
    }

    public LiveData() {
        Object obj = f2659L11I;
        this.f2660IL = obj;
        this.f5035Ilil = obj;
        this.f2663lLi1LL = -1;
    }

    public static void IL1Iii(String str) {
        if (ILil.I1I.IL1Iii.IL1Iii.IL1Iii.ILil().IL1Iii()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void I1I(LiveData<T>.IL1Iii iL1Iii) {
        if (this.f2662iILLL1) {
            this.f2661IiL = true;
            return;
        }
        this.f2662iILLL1 = true;
        do {
            this.f2661IiL = false;
            if (iL1Iii != null) {
                ILil(iL1Iii);
                iL1Iii = null;
            } else {
                ILil<InterfaceC0641ILl<? super T>, LiveData<T>.IL1Iii>.IL ilM1441IL = this.f5034ILil.m1441IL();
                while (ilM1441IL.hasNext()) {
                    ILil((IL1Iii) ilM1441IL.next().getValue());
                    if (this.f2661IiL) {
                        break;
                    }
                }
            }
        } while (this.f2661IiL);
        this.f2662iILLL1 = false;
    }

    public final void ILil(LiveData<T>.IL1Iii iL1Iii) {
        if (iL1Iii.f5038ILil) {
            if (!iL1Iii.ILL()) {
                iL1Iii.m3228IiL(false);
                return;
            }
            int i = iL1Iii.f5036I1I;
            int i2 = this.f2663lLi1LL;
            if (i >= i2) {
                return;
            }
            iL1Iii.f5036I1I = i2;
            iL1Iii.f5037IL1Iii.IL1Iii((Object) this.f2660IL);
        }
    }

    public void Ilil() {
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3227IL(IiL iiL, InterfaceC0641ILl<? super T> interfaceC0641ILl) {
        IL1Iii("observe");
        if (iiL.getLifecycle().ILil() == IL.ILil.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(iiL, interfaceC0641ILl);
        LiveData<T>.IL1Iii iL1IiiMo1440iILLL1 = this.f5034ILil.mo1440iILLL1(interfaceC0641ILl, lifecycleBoundObserver);
        if (iL1IiiMo1440iILLL1 != null && !iL1IiiMo1440iILLL1.mo3230il(iiL)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (iL1IiiMo1440iILLL1 != null) {
            return;
        }
        iiL.getLifecycle().IL1Iii(lifecycleBoundObserver);
    }

    /* JADX INFO: renamed from: I丨iL */
    public void mo1933IiL(T t) {
        IL1Iii("setValue");
        this.f2663lLi1LL++;
        this.f2660IL = t;
        I1I(null);
    }

    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo1935iILLL1(InterfaceC0641ILl<? super T> interfaceC0641ILl) {
        IL1Iii("removeObserver");
        LiveData<T>.IL1Iii iL1IiiMo1438IiL = this.f5034ILil.mo1438IiL(interfaceC0641ILl);
        if (iL1IiiMo1438IiL == null) {
            return;
        }
        iL1IiiMo1438IiL.mo3229L11I();
        iL1IiiMo1438IiL.m3228IiL(false);
    }

    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo1936lLi1LL() {
    }
}
