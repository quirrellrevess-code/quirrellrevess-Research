package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import I1I.I1I.p008IL.lIlii;
import android.app.INXCoreNative;
import android.content.IOnPrimaryClipChangedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.flexbox.BuildConfig;
import com.main.engine.BinderContainer;
import com.main.engine.TsEventNative;
import org.json.JSONObject;

/* JADX INFO: renamed from: I1I.I1I.ILil.l丨丨i11, reason: invalid class name */
/* JADX INFO: compiled from: ScriptCoreProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class li11 extends lIlii implements Runnable {

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final String f1044iILLL1 = li11.class.getName();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Handler f3296Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1045IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String f1046lLi1LL = null;

    /* JADX INFO: renamed from: I1I.I1I.ILil.l丨丨i11$I1I */
    /* JADX INFO: compiled from: ScriptCoreProxy.java */
    public class I1I implements IBinder.DeathRecipient {
        public I1I() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            li11.this.m1042lIlii();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.l丨丨i11$IL1Iii */
    /* JADX INFO: compiled from: ScriptCoreProxy.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            li11 li11Var = li11.this;
            if (li11Var.iIi1(li11Var, I1I.IL1Iii.IL1Iii(new byte[]{90, 80, 8, 14, 13}, I1I.IL1Iii.IL1Iii(new byte[]{86, 13, 93, 3, 80, 4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 12, 1, 86, 11, 0}, "f48790"))))) {
                return;
            }
            li11.this.f3296Ilil.postDelayed(this, 300L);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.l丨丨i11$ILil */
    /* JADX INFO: compiled from: ScriptCoreProxy.java */
    public class ILil extends IOnPrimaryClipChangedListener.Stub {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ iILLL1 f3300ILil;

        public ILil(iILLL1 iilll1) {
            this.f3300ILil = iilll1;
        }

        @Override // android.content.IOnPrimaryClipChangedListener
        public void dispatchPrimaryClipChanged() {
            try {
                li11.this.f1046lLi1LL = this.f3300ILil.m1008iILLL1().toString();
            } catch (Exception unused) {
            }
        }
    }

    public li11(String str) {
        this.f1045IL = BuildConfig.FLAVOR;
        this.f3296Ilil = null;
        this.f1045IL = str;
        this.f3296Ilil = new Handler();
        TsEventNative.start();
        LlLiLL.IL1Iii().ILil();
        m1043llL1ii();
    }

    public final boolean iIi1(IBinder iBinder, String str) {
        IiL iiLIL1Iii;
        String str2 = this.f1045IL + I1I.IL1Iii.IL1Iii(new byte[]{23, 112, 14, 22, 82, 99, 75, 92, 23, 13, 83, 86, 75}, I1I.IL1Iii.IL1Iii(new byte[]{12, 87, 83, 83, 15, 87}, I1I.IL1Iii.IL1Iii(new byte[]{86, 5, 81, 15, 90, 83}, "cac8b7")));
        try {
            iiLIL1Iii = C0001i1.Ilil().IL1Iii().IL1Iii(str2, iBinder);
            try {
                if (iiLIL1Iii == null) {
                    IiL.IL1Iii(f1044iILLL1, String.format(I1I.IL1Iii.IL1Iii(new byte[]{73, 66, 86, 78, 12, 85, 92, 66, 25, 81, 22, 17, 87, 69, 85, 84, 69, 20, 74, 16, 28, 92}, I1I.IL1Iii.IL1Iii(new byte[]{13, 1, 8, 9, 4, 9}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 87, 84, 88, 93}, "6cfe9e"))), str2, 0));
                    C0603ill c0603illM955lLi1LL = C0001i1.Ilil().m955lLi1LL();
                    if (c0603illM955lLi1LL != null && c0603illM955lLi1LL.IL1Iii(this.f1045IL, 0, 0) == null) {
                        lIlii.m24L();
                    }
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th) {
                            IiL.I1I(f1044iILLL1, I1I.IL1Iii.IL1Iii(new byte[]{75, 82, 94, 86, 19, 83, 122, 88, 93, 77, 0, 88, 77, 103, 65, 86, 19, 95, 93, 82, 65, 124, 29, 66, 92, 69, 93, 88, 9}, I1I.IL1Iii.IL1Iii(new byte[]{88, 85, 86, 13, 4, 4}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 6, 81, 81, 2}, "0fce00"))) + th.toString());
                        }
                    }
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{87, 88, 90, 31, 8, 79, 26, 84, 88, 67, 3, 25, 67, 69, 86, 65, 22, 82, 70, 68, 25, 88, 8, 67, 81, 89, 67, 31, 3, 79, 64, 69, 86, 31, 36, 126, 122, 115, 114, 99}, I1I.IL1Iii.IL1Iii(new byte[]{12, 84, 81, 87, 7, 7}, I1I.IL1Iii.IL1Iii(new byte[]{15, 6, 82, 5, 0, 85}, "7e4cae"))), new BinderContainer(iBinder));
                bundle.putString(I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 90, 28, 8, 75, 74, 1, 88, 64, 3, 29, 16, 13, 92, 87, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 86, 6, 80, 5}, I1I.IL1Iii.IL1Iii(new byte[]{90, 7, 7, 13, 84, 82}, "9ff9bd"))), str);
                Bundle bundleM893IiL = iiLIL1Iii.m893IiL(str2, I1I.IL1Iii.IL1Iii(new byte[]{22, 82, 95, 83, 52, 68, 0, 69, 98, 82, 19, 65, 12, 84, 84, 103, 19, 88, 29, 78}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 5, 15, 3, 86}, I1I.IL1Iii.IL1Iii(new byte[]{10, 3, 1, 1, 84, 5}, "96596d"))), null, bundle);
                if (bundleM893IiL == null) {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th2) {
                            IiL.I1I(f1044iILLL1, I1I.IL1Iii.IL1Iii(new byte[]{65, 83, 84, 11, 21, 83, 112, 89, 87, 16, 6, 88, 71, 102, 75, 11, 21, 95, 87, 83, 75, 33, 27, 66, 86, 68, 87, 5, 15}, I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 1, 81, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 14, 1, 81, 0}, "0b64d7"))) + th2.toString());
                        }
                    }
                    return false;
                }
                new ILL(null, bundleM893IiL, new I1I());
                if (iiLIL1Iii != null) {
                    try {
                        C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                    } catch (Throwable th3) {
                        IiL.I1I(f1044iILLL1, I1I.IL1Iii.IL1Iii(new byte[]{19, 4, 93, 94, 21, 92, 34, 14, 94, 69, 6, 87, 21, 49, 66, 94, 21, 80, 5, 4, 66, 116, 27, 77, 4, 19, 94, 80, 15}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 84, 84, 81, 93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 7, 84, 5, 84}, "07c170"))) + th3.toString());
                    }
                }
                return true;
            } catch (Throwable unused) {
                try {
                    IiL.IL1Iii(f1044iILLL1, String.format(I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 81, 84, 81, 5, 68, 69, 93, 86, 80, 65, 6, 95, 86, 92, 81, 19, 68, 66, 87, 24, 17, 18, 68, 95, 86, 24, 65, 18, 1, 68, 24, 29, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 94, 91, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 3, 83, 86, 83}, "3ce032"))), str2, 0));
                    if (iiLIL1Iii != null) {
                        try {
                        } catch (Throwable th4) {
                            String str3 = f1044iILLL1;
                            StringBuilder sb = new StringBuilder();
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{70, 1, 84, 13, 78, 93, 119, 11, 87, 22, 93, 86, 64, 52, 75, 13, 78, 81, 80, 1, 75, 39, 64, 76, 81, 22, 87, 3, 84}, I1I.IL1Iii.IL1Iii(new byte[]{12, 7, 9, 0, 89, 14}, I1I.IL1Iii.IL1Iii(new byte[]{8, 80, 8, 87, 87, 5}, "038563")));
                        }
                    }
                    return false;
                } finally {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th5) {
                            IiL.I1I(f1044iILLL1, I1I.IL1Iii.IL1Iii(new byte[]{16, 4, 11, 14, 79, 84, 33, 14, 8, 21, 92, 95, 22, 49, 20, 14, 79, 88, 6, 4, 20, 36, 65, 69, 7, 19, 8, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 89, 3, 4, 0, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 94, 1, 93, 91, 7}, "0fd8b6"))) + th5.toString());
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            iiLIL1Iii = null;
        }
    }

    public void iIlLiL() {
        try {
            if (iIi1(this, I1I.IL1Iii.IL1Iii(new byte[]{91, 85, 15, 84, 90}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 86, 92, 7, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 81, 87, 10, 86}, "6fd38f"))))) {
                return;
            }
            lIlii.m24L();
        } catch (Throwable th) {
            IiL.IL1Iii(f1044iILLL1, String.format(I1I.IL1Iii.IL1Iii(new byte[]{23, 89, 0, 0, 85, 1, 66, 67, 14, 66, 74, 16, 3, 69, 21, 66, 74, 1, 16, 65, 8, 1, 92, 68, 71, 68, 65}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 87, 83, 88, 0}, I1I.IL1Iii.IL1Iii(new byte[]{81, 5, 83, 4, 85, 7}, "3ae54c"))) + th.toString(), lIlii.LiL1()));
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m1042lIlii() {
        this.f3296Ilil.postDelayed(new IL1Iii(), 300L);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m1043llL1ii() {
        try {
            iILLL1 iilll1ILil = C0001i1.Ilil().ILil();
            iilll1ILil.ILil(new ILil(iilll1ILil));
        } catch (Exception unused) {
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
        return null;
    }

    @Override // android.app.INXCoreNative
    public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws Throwable {
        if (i == 1) {
            lIlii.m24L();
        } else {
            String string = BuildConfig.FLAVOR;
            if (i != 11) {
                if (i != 10) {
                    return null;
                }
                if (i2 == 6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(BuildConfig.FLAVOR);
                    sb.append(lIlii.L11LlL(i3 == 1));
                    return sb.toString();
                }
                if (i2 == 7) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(BuildConfig.FLAVOR);
                    sb2.append(lIlii.LLii1I(i3 == 1));
                    return sb2.toString();
                }
                if (i2 == 5) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(BuildConfig.FLAVOR);
                    sb3.append(lIlii.m1126IiILI(i3 == 1));
                    return sb3.toString();
                }
                if (i2 != 9) {
                    return null;
                }
                String str2 = I1I.IL1Iii.IL1Iii(new byte[]{30, 83, 82, 76, 4, 76, 93, 88, 80, 89, 9, 76, 69, 90, 67, 23}, I1I.IL1Iii.IL1Iii(new byte[]{2, 15, 11, 93, 83, 81}, I1I.IL1Iii.IL1Iii(new byte[]{10, 93, 8, 3, 3, 0}, "9e0f52"))) + System.currentTimeMillis() + I1I.IL1Iii.IL1Iii(new byte[]{77, 89, 68, 90}, I1I.IL1Iii.IL1Iii(new byte[]{85, 92, 0, 80, 87, 81}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 6, 89, 1, 0}, "1728b2")));
                String strIIlLiL = lIlii.iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{6, 19, 16}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 1, 85, 9, 4}, I1I.IL1Iii.IL1Iii(new byte[]{83, 9, 87, 87, 85, 81}, "19fded"))) + str + " " + str2, I1I.IL1Iii.IL1Iii(new byte[]{71, 90, 67, 95, 12, 64, 67, 86, 15, 90, 66, 30, 69, 23}, I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 6, 5, 82, 11}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 83, 3, 84, 0}, "9760d8"))) + str2}, 0L);
                return (strIIlLiL == null || !strIIlLiL.contains(I1I.IL1Iii.IL1Iii(new byte[]{103, 71, 84, 82, 92, 65, 71}, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 82, 83, 90, 7}, I1I.IL1Iii.IL1Iii(new byte[]{91, 92, 82, 91, 84, 87}, "9d797b"))))) ? I1I.IL1Iii.IL1Iii(new byte[]{83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 80, 0, 13, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{5, 7, 6, 86, 7, 10}, "313c39"))) : I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 83, 86, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{15, 80, 8, 6, 81, 0}, "8b9d49")));
            }
            if (i2 == 7) {
                return lIlii.iIi1(str, 0L, i3 == 1);
            }
            if (i2 != 11) {
                if (i2 == 12) {
                    lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{85, 88, 21, 94, 9, 23, 87, 80, 24, 75, 18, 10, 68, 21}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 3, 15, 2, 3}, I1I.IL1Iii.IL1Iii(new byte[]{91, 81, 1, 85, 86, 86}, "877b20"))) + str, 5000L, true);
                    return I1I.IL1Iii.IL1Iii(new byte[]{7}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 85, 85, 7, 86}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 0, 86, 80, 3}, "4ae4b3")));
                }
                if (i2 == 15) {
                    return lIlii.m1140LlLiLL();
                }
                if (i2 == 16) {
                    return lIlii.m18iI();
                }
                if (i2 == 17) {
                    return BuildConfig.FLAVOR + lIlii.m1166iLI(str);
                }
                if (i2 == 18) {
                    String strLlI = lIlii.llI();
                    return strLlI != null ? strLlI : this.f1046lLi1LL;
                }
                if (i2 == 19) {
                    return lIlii.m1118IiL(str) ? I1I.IL1Iii.IL1Iii(new byte[]{82}, I1I.IL1Iii.IL1Iii(new byte[]{90, 7, 6, 0, 84, 3}, I1I.IL1Iii.IL1Iii(new byte[]{92, 4, 14, 82, 7, 0}, "e48ec0"))) : I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{81, 91, 93, 85, 7, 80}, I1I.IL1Iii.IL1Iii(new byte[]{86, 12, 10, 85, 4, 91}, "453028")));
                }
                if (i2 != 19) {
                    return null;
                }
                I1I.I1I.ILil.I1I.ILil(str);
                return I1I.IL1Iii.IL1Iii(new byte[]{84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 0, 80, 81, 12, 5}, I1I.IL1Iii.IL1Iii(new byte[]{2, 13, 12, 3, 10, 83}, "388432")));
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string2 = jSONObject.has(I1I.IL1Iii.IL1Iii(new byte[]{18, 15, 5}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 87, 0, 80, 92}, I1I.IL1Iii.IL1Iii(new byte[]{86, 87, 80, 0, 8, 14}, "2fed97")))) ? jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{65, 89, 6}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 5, 93, 11, 94}, I1I.IL1Iii.IL1Iii(new byte[]{3, 15, 85, 6, 7, 95}, "281c49")))) : BuildConfig.FLAVOR;
                if (jSONObject.has(I1I.IL1Iii.IL1Iii(new byte[]{81, 8, 18}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 3, 83, 92, 81}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 81, 87, 80, 2}, "fa325f"))))) {
                    string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{72, 90, 85}, I1I.IL1Iii.IL1Iii(new byte[]{15, 84, 6, 90, 90, 13}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 85, 86, 1, 80}, "d1a5ce"))));
                }
                if (i3 != 1) {
                    return I1I.IL1Iii.IL1Iii(new byte[]{82}, I1I.IL1Iii.IL1Iii(new byte[]{6, 10, 85, 89, 3, 88}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 2, 83, 82, 2}, "44c2bc")));
                }
                if (string.length() > 0) {
                    lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{81, 11, 23, 21, 76, 87, 66, 18, 23, 75, 86, 22}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 81, 81, 9, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 80, 6, 1, 7}, "2f610d"))) + string2 + I1I.IL1Iii.IL1Iii(new byte[]{27}, I1I.IL1Iii.IL1Iii(new byte[]{12, 8, 3, 7, 86, 4}, I1I.IL1Iii.IL1Iii(new byte[]{91, 6, 82, 2, 4, 89}, "c6ece8"))) + string, 5000L, true);
                } else {
                    lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{70, 85, 91, 15, 8, 87, 31, 24, 25, 17, 67}, I1I.IL1Iii.IL1Iii(new byte[]{2, 90, 0, 86, 1, 10}, I1I.IL1Iii.IL1Iii(new byte[]{93, 91, 6, 81, 87, 14}, "992f56"))) + string2 + I1I.IL1Iii.IL1Iii(new byte[]{21, 30, 81, 18, 89, 11, 81, 65, 93, 91, 92, 75, 92, 93, 70, 87, 86, 17, 27, 80, 83, 70, 93, 2, 90, 65, 75, 28, 116, 36, 96, 125, 113, 122, 125, 55, 21, 2}, I1I.IL1Iii.IL1Iii(new byte[]{5, 10, 86, 84, 14, 92}, I1I.IL1Iii.IL1Iii(new byte[]{85, 8, 7, 94, 3, 11}, "e1c852"))), 5000L, true);
                }
                return I1I.IL1Iii.IL1Iii(new byte[]{80}, I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 3, 12, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 12, 90, 12, 80}, "4e8c8a")));
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
