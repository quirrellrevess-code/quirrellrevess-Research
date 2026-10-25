package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import I1I.I1I.p008IL.lIlii;
import android.app.INXCoreNative;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.main.engine.BinderContainer;

/* JADX INFO: renamed from: I1I.I1I.ILil.I丨 */
/* JADX INFO: compiled from: UiAutoProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0000I extends lIlii implements Runnable {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final String f938IiL = I1I.IL1Iii.IL1Iii(new byte[]{121, 61}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 10, 7, 5, 83}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 4, 3, 83, 5}, "cc6270")));

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public String f3114Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Handler f939IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public i11i f940iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public L1iI1 f941lLi1LL;

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨$I1I */
    /* JADX INFO: compiled from: UiAutoProxy.java */
    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RunnableC0000I runnableC0000I = RunnableC0000I.this;
            if (runnableC0000I.m888llL1ii(runnableC0000I, I1I.IL1Iii.IL1Iii(new byte[]{93, 93, 89, 93, 89}, I1I.IL1Iii.IL1Iii(new byte[]{80, 15, 83, 6, 5, 94}, I1I.IL1Iii.IL1Iii(new byte[]{93, 15, 87, 84, 6, 7}, "881c5a"))))) {
                return;
            }
            RunnableC0000I.this.f939IL.postDelayed(this, 300L);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨$IL1Iii */
    /* JADX INFO: compiled from: UiAutoProxy.java */
    public class IL1Iii implements L1l.IL1Iii {
        public IL1Iii(RunnableC0000I runnableC0000I) {
        }

        @Override // I1I.I1I.ILil.L1l.IL1Iii
        public void IL1Iii() {
            if (iILilI.I1I().m1013lLi1LL()) {
                return;
            }
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 104}, I1I.IL1Iii.IL1Iii(new byte[]{81, 82, 81, 82, 7, 1}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 12, 0, 90, 12}, "a49a95"))), I1I.IL1Iii.IL1Iii(new byte[]{85, 92, 90, 88, 1, 90, 66, 18, 21, 23}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 82, 3, 7, 15}, I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 94, 2, 80, 3}, "a78735"))));
            iILilI.I1I().IL1Iii();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨$ILil */
    /* JADX INFO: compiled from: UiAutoProxy.java */
    public class ILil implements C0003lL.ILil {
        public ILil(RunnableC0000I runnableC0000I) {
        }

        @Override // I1I.I1I.ILil.C0003lL.ILil
        public void IL1Iii(int i, int i2, int i3, int i4, int i5) {
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.I丨$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: UiAutoProxy.java */
    public class IL implements IBinder.DeathRecipient {
        public IL() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            RunnableC0000I.this.LlLI1();
        }
    }

    public RunnableC0000I(String str) {
        this.f939IL = null;
        this.f3114Ilil = BuildConfig.FLAVOR;
        this.f941lLi1LL = null;
        this.f940iILLL1 = null;
        this.f3114Ilil = str;
        this.f939IL = new Handler();
        L1iI1 l1iI1 = new L1iI1();
        this.f941lLi1LL = l1iI1;
        l1iI1.Lil(new IL1Iii(this));
        this.f940iILLL1 = i11i.ILL();
        C0003lL.I1I().m1031IL(new ILil(this));
    }

    public final void LlLI1() {
        this.f939IL.postDelayed(new I1I(), 300L);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m887lIlii() {
        try {
            try {
                if (m888llL1ii(this, I1I.IL1Iii.IL1Iii(new byte[]{9, 82, 8, 13, 12}, I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 6, 3, 81, 4}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 85, 7, 7, 3}, "f47e50"))))) {
                    return;
                }
                Log.i(f938IiL, I1I.IL1Iii.IL1Iii(new byte[]{11, 5, 70, 6, 93, 82, 116, 81, 91, 7, 86, 68, 22, 86, 64, 15, 95, 11, 11}, I1I.IL1Iii.IL1Iii(new byte[]{84, 13, 13, 80, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 94, 80, 5, 4}, "fdfc32"))));
                lIlii.m24L();
            } catch (Throwable th) {
                th = th;
                IiL.IL1Iii(f938IiL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{23, 89, 5, 82, 88, 83, 66, 67, 11, 16, 71, 66, 3, 69, 16, 16, 71, 83, 16, 65, 13, 83, 81, 22, 71, 68, 68}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 82, 6, 4, 82}, I1I.IL1Iii.IL1Iii(new byte[]{92, 85, 85, 3, 83, 86}, "93c5c2"))) + th.toString(), lIlii.LiL1()));
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final boolean m888llL1ii(IBinder iBinder, String str) {
        IiL iiLIL1Iii;
        String str2 = this.f3114Ilil + I1I.IL1Iii.IL1Iii(new byte[]{77, 32, 9, 69, 83, 100, 17, 12, 16, 94, 82, 81, 17}, I1I.IL1Iii.IL1Iii(new byte[]{2, 91, 5, 85, 5, 6}, I1I.IL1Iii.IL1Iii(new byte[]{4, 94, 91, 80, 3, 87}, "ef820e")));
        try {
            iiLIL1Iii = C0001i1.Ilil().IL1Iii().IL1Iii(str2, iBinder);
            try {
                if (iiLIL1Iii == null) {
                    IiL.IL1Iii(f938IiL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{65, 17, 90, 20, 89, 83, 84, 17, 21, 11, 67, 23, 95, 22, 89, 14, 16, 18, 66, 67, 16, 6}, I1I.IL1Iii.IL1Iii(new byte[]{80, 90, 12, 7, 6, 84}, I1I.IL1Iii.IL1Iii(new byte[]{83, 93, 15, 3, 83, 83}, "2d6fe0"))), str2, 0));
                    C0603ill c0603illM955lLi1LL = C0001i1.Ilil().m955lLi1LL();
                    if (c0603illM955lLi1LL != null && c0603illM955lLi1LL.IL1Iii(this.f3114Ilil, 0, 0) == null) {
                        lIlii.m24L();
                    }
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th) {
                            IiL.I1I(f938IiL, I1I.IL1Iii.IL1Iii(new byte[]{64, 85, 14, 12, 65, 3, 113, 95, 13, 23, 82, 8, 70, 96, 17, 12, 65, 15, 86, 85, 17, 38, 79, 18, 87, 66, 13, 2, 91}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 91, 85, 81, 2}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 12, 84, 86, 86}, "fc4b02"))) + th.toString());
                        }
                    }
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{90, 13, 95, 74, 15, 65, 23, 1, 93, 22, 4, 23, 78, 16, 83, 20, 17, 92, 75, 17, 28, 13, 15, 77, 92, 12, 70, 74, 4, 65, 77, 16, 83, 74, 35, 112, 119, 38, 119, 54}, I1I.IL1Iii.IL1Iii(new byte[]{14, 82, 84, 83, 5, 9}, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 82, 85, 80, 82}, "d34b4b"))), new BinderContainer(iBinder));
                bundle.putString(I1I.IL1Iii.IL1Iii(new byte[]{1, 88, 9, 31, 8, 28, 76, 84, 11, 67, 3, 74, 22, 88, 15, 84, 8}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 85, 6, 83, 93}, I1I.IL1Iii.IL1Iii(new byte[]{12, 0, 6, 7, 4, 88}, "8b701a"))), str);
                Bundle bundleM893IiL = iiLIL1Iii.m893IiL(str2, I1I.IL1Iii.IL1Iii(new byte[]{22, 3, 15, 93, 99, 17, 0, 20, 50, 92, 68, 20, 12, 5, 4, 108, 95, 35, 16, 18, 14}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 82, 90, 82, 83}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 82, 84, 87, 85}, "c2a73d"))), null, bundle);
                if (bundleM893IiL == null) {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th2) {
                            IiL.I1I(f938IiL, I1I.IL1Iii.IL1Iii(new byte[]{70, 6, 84, 88, 79, 82, 119, 12, 87, 67, 92, 89, 64, 51, 75, 88, 79, 94, 80, 6, 75, 114, 65, 67, 81, 17, 87, 86, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 2, 14, 4, 10, 2}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 81, 4, 1, 4}, "dff721"))) + th2.toString());
                        }
                    }
                    return false;
                }
                new ILL(null, bundleM893IiL, new IL());
                if (iiLIL1Iii != null) {
                    try {
                        C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                    } catch (Throwable th3) {
                        IiL.I1I(f938IiL, I1I.IL1Iii.IL1Iii(new byte[]{68, 6, 9, 10, 67, 1, 117, 12, 10, 17, 80, 10, 66, 51, 22, 10, 67, 13, 82, 6, 22, 32, 77, 16, 83, 17, 10, 4, 89}, I1I.IL1Iii.IL1Iii(new byte[]{14, 2, 83, 85, 5, 85}, I1I.IL1Iii.IL1Iii(new byte[]{15, 4, 86, 0, 3, 83}, "7ea03b"))) + th3.toString());
                    }
                }
                return true;
            } catch (Throwable unused) {
                try {
                    IiL.IL1Iii(f938IiL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 90, 88, 81, 82, 16, 65, 86, 90, 80, 22, 82, 91, 93, 80, 81, 68, 16, 70, 92, 20, 17, 69, 16, 91, 93, 20, 65, 69, 85, 64, 19, 17, 80}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 80, 3, 2, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 81, 86, 82, 3, 3}, "f55e5f"))), str2, 0));
                    if (iiLIL1Iii != null) {
                        try {
                        } catch (Throwable th4) {
                            String str3 = f938IiL;
                            StringBuilder sb = new StringBuilder();
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{66, 0, 92, 91, 78, 3, 115, 10, 95, 64, 93, 8, 68, 53, 67, 91, 78, 15, 84, 0, 67, 113, 64, 18, 85, 23, 95, 85, 84}, I1I.IL1Iii.IL1Iii(new byte[]{86, 82, 82, 6, 93, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 90, 2, 7, 88}, "2690b9")));
                        }
                    }
                    return false;
                } finally {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th5) {
                            IiL.I1I(f938IiL, I1I.IL1Iii.IL1Iii(new byte[]{68, 86, 14, 89, 20, 0, 117, 92, 13, 66, 7, 11, 66, 99, 17, 89, 20, 12, 82, 86, 17, 115, 26, 17, 83, 65, 13, 87, 14}, I1I.IL1Iii.IL1Iii(new byte[]{5, 11, 82, 84, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 93, 80, 85, 3, 85}, "aea7e3"))) + th5.toString());
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            iiLIL1Iii = null;
        }
    }

    @Override // android.app.INXCoreNative
    public l obtainDataTask() throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public L111 obtainUiObjectProxy(int i) throws RemoteException {
        return this.f940iILLL1;
    }

    @Override // android.app.INXCoreNative
    public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
        return this.f941lLi1LL;
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
        if (i == 21) {
            iILilI.I1I().IL1Iii();
        } else if (i == 1) {
            lIlii.m24L();
        }
        if (i == 23 || i != 24) {
            return null;
        }
        lIlii.LLlIiil(i2, i3);
        return null;
    }
}
