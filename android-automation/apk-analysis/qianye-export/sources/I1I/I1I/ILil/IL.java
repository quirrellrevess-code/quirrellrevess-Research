package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.app.INXCoreNative;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.RemoteException;
import com.main.app.AccRequestActivity;
import com.main.app.RSNativeActivity;

/* JADX INFO: renamed from: I1I.I1I.ILil.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: AccessibiltyEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends lIlii implements C1 {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f942IL;

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨L$I1I */
    /* JADX INFO: compiled from: AccessibiltyEngine.java */
    public abstract class I1I {
        public I1I(IL il) {
        }

        public abstract void I1I();

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public abstract void mo891IL(long j);
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨L$ILil */
    /* JADX INFO: compiled from: AccessibiltyEngine.java */
    public class ILil extends I1I implements I11L {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public lLi1LL f3120I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Context f3121IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public LlLLL f3122ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f943IL;

        public ILil(Context context, LlLLL llLLL) {
            super();
            this.f943IL = false;
            this.f3121IL1Iii = context;
            this.f3122ILil = llLLL;
            lLi1LL lli1ll = new lLi1LL(IL.this, 6000L, 500L, this);
            this.f3120I1I = lli1ll;
            lli1ll.start();
        }

        @Override // I1I.I1I.ILil.IL.I1I
        public synchronized void I1I() {
            Ilil();
        }

        @Override // I1I.I1I.ILil.I11L
        public synchronized void IL1Iii() {
            lLi1LL lli1ll = this.f3120I1I;
            if (lli1ll != null) {
                lli1ll.cancel();
            }
            Ilil();
        }

        @Override // I1I.I1I.ILil.I11L
        public synchronized void ILil() {
            if (lIlii.Ilil()) {
                if (!this.f943IL) {
                    this.f943IL = true;
                    IL.this.Lil(this.f3121IL1Iii, this.f3122ILil);
                }
                this.f3120I1I.cancel();
                return;
            }
            this.f3120I1I.cancel();
            lLi1LL lli1ll = new lLi1LL(IL.this, 30000L, 500L, this);
            this.f3120I1I = lli1ll;
            lli1ll.start();
        }

        public final void Ilil() {
            if (lIlii.Ilil()) {
                if (this.f943IL) {
                    return;
                }
                this.f943IL = true;
                IL.this.Lil(this.f3121IL1Iii, this.f3122ILil);
                return;
            }
            if (this.f943IL) {
                return;
            }
            this.f943IL = true;
            this.f3122ILil.IL1Iii();
        }

        @Override // I1I.I1I.ILil.IL.I1I
        /* JADX INFO: renamed from: I丨L */
        public synchronized void mo891IL(long j) {
            if (lIlii.Ilil()) {
                IL.this.Lil(this.f3121IL1Iii, this.f3122ILil);
                lLi1LL lli1ll = this.f3120I1I;
                if (lli1ll != null) {
                    lli1ll.cancel();
                }
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨L$I丨L, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: AccessibiltyEngine.java */
    public class C0522IL extends I1I implements I11L {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f3124I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public LlLLL f3125IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public lLi1LL f3126ILil;

        public C0522IL(Context context, LlLLL llLLL) {
            super();
            this.f3124I1I = false;
            this.f3125IL1Iii = llLLL;
            lLi1LL lli1ll = new lLi1LL(IL.this, 6000L, 500L, this);
            this.f3126ILil = lli1ll;
            lli1ll.start();
        }

        @Override // I1I.I1I.ILil.IL.I1I
        public synchronized void I1I() {
            m892lLi1LL();
        }

        @Override // I1I.I1I.ILil.I11L
        public synchronized void IL1Iii() {
            this.f3126ILil.cancel();
            m892lLi1LL();
        }

        @Override // I1I.I1I.ILil.I11L
        public synchronized void ILil() {
            if (iIilII1.LLL().m970I1L11L()) {
                if (!this.f3124I1I) {
                    this.f3124I1I = true;
                    this.f3125IL1Iii.ILil();
                }
                this.f3126ILil.cancel();
                return;
            }
            this.f3126ILil.cancel();
            lLi1LL lli1ll = new lLi1LL(IL.this, 30000L, 500L, this);
            this.f3126ILil = lli1ll;
            lli1ll.start();
        }

        public final void Ilil() {
            try {
                if (lIlii.Ilil()) {
                    InterfaceC0606LLlI1 interfaceC0606LLlI1ObtainUiSelectorProxy = iIilII1.LLL().obtainUiSelectorProxy(0);
                    long jObtain = interfaceC0606LLlI1ObtainUiSelectorProxy.obtain();
                    interfaceC0606LLlI1ObtainUiSelectorProxy.text(jObtain, I1I.IL1Iii.IL1Iii(new byte[]{-126, -97, -72, -122, -76, -124, -128, -120, -77, -122, -98, -68}, I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 6, 90, 8, 2}, I1I.IL1Iii.IL1Iii(new byte[]{13, 1, 4, 92, 1, 6}, "881e03"))));
                    long jFindOneEx = interfaceC0606LLlI1ObtainUiSelectorProxy.findOneEx(jObtain, 10L);
                    if (jFindOneEx != 0) {
                        i11i.ILL().click(jFindOneEx);
                        i11i.ILL().mo0gc(jFindOneEx);
                    }
                    L1iI1.m900lIiI().release(jObtain);
                }
            } catch (Exception unused) {
            }
        }

        @Override // I1I.I1I.ILil.IL.I1I
        /* JADX INFO: renamed from: I丨L */
        public synchronized void mo891IL(long j) {
            Ilil();
            if (iIilII1.LLL().m970I1L11L()) {
                if (!this.f3124I1I) {
                    this.f3124I1I = true;
                    this.f3125IL1Iii.ILil();
                }
                this.f3126ILil.cancel();
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final void m892lLi1LL() {
            if (this.f3124I1I) {
                return;
            }
            this.f3124I1I = true;
            if (iIilII1.LLL().m970I1L11L()) {
                this.f3125IL1Iii.ILil();
            } else {
                this.f3125IL1Iii.IL1Iii();
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨L$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: AccessibiltyEngine.java */
    public class lLi1LL extends CountDownTimer {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public I1I f3127IL1Iii;

        public lLi1LL(IL il, long j, long j2, I1I i1i) {
            super(j, j2);
            this.f3127IL1Iii = i1i;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f3127IL1Iii.I1I();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.f3127IL1Iii.mo891IL(j);
        }
    }

    @Override // I1I.I1I.ILil.C1
    public void ILL(Context context, LlLLL llLLL) {
        if (lIlii.Ilil()) {
            Lil(context, llLLL);
        } else {
            m890ILl(context, llLLL);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m890ILl(Context context, LlLLL llLLL) {
        AccRequestActivity.ILil(context, new ILil(context, llLLL));
    }

    @Override // I1I.I1I.ILil.C1
    public String Ilil(int i, int i2, int i3, String str) {
        return null;
    }

    @Override // I1I.I1I.ILil.C1
    /* JADX INFO: renamed from: I丨L */
    public void mo848IL(Context context, Bundle bundle) {
        ILL ill = this.f942IL;
        if (ill != null) {
            ill.I1I();
        }
        this.f942IL = new ILL(this, bundle, null);
    }

    public final void Lil(Context context, LlLLL llLLL) {
        if (iIilII1.LLL().m970I1L11L()) {
            llLLL.ILil();
        } else {
            RSNativeActivity.ILil(context, new C0522IL(context, llLLL));
        }
    }

    public boolean LlLI1() {
        return lIlii.Ilil();
    }

    @Override // android.app.INXCoreNative
    public l obtainDataTask() {
        return null;
    }

    @Override // android.app.INXCoreNative
    public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public L111 obtainUiObjectProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
        return null;
    }
}
