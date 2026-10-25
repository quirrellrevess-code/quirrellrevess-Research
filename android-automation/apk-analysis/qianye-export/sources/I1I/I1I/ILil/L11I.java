package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.app.IAccessibServiceProxy;
import android.app.INXCoreNative;
import android.app.INXOpenFdEvent;
import android.content.Context;
import android.content.IOnPrimaryClipChangedListener;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.main.app.Native;
import com.main.engine.BinderContainer;
import com.main.engine.Engine;
import com.main.engine.SharedMem;
import com.main.engine.TsEventNative;
import com.main.engine.UiAccActionNative;
import com.main.engine.UiObjNative;
import com.main.engine.UiSelNative;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;

/* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: CoreScript.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I extends lIlii implements Runnable {

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public static final String f968LlLLL = L11I.class.getName();

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static L11I f969lIII = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public String f3171Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f971IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f972IiL;
    public UiSelNative LlLI1;
    public IAccessibServiceProxy iIi1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public String f975iILLL1;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public UiAccActionNative f977lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public UiObjNative f978llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String f979lLi1LL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Handler f974L11I = null;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public File f980il = null;
    public File ILL = null;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public File f973Ll1 = null;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public File f976lIiI = null;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public INXCoreNative f970ILl = null;
    public String Lil = null;
    public boolean iIlLiL = false;
    public boolean I11li1 = false;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f981lL = false;
    public String I11L = null;
    public boolean llliI = false;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public long f982l = 0;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public BinderC0525L11I f9831 = new BinderC0525L11I(this, null);

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$I1I */
    /* JADX INFO: compiled from: CoreScript.java */
    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L11I l11i = L11I.this;
            if (l11i.m943ill(l11i, I1I.IL1Iii.IL1Iii(new byte[]{94, 82, 88, 85, 88}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 81, 0, 83, 86}, I1I.IL1Iii.IL1Iii(new byte[]{3, 80, 1, 93, 80, 5}, "1fdd40"))))) {
                return;
            }
            L11I.this.f974L11I.postDelayed(this, 300L);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: CoreScript.java */
    public class IL1Iii extends IOnPrimaryClipChangedListener.Stub {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ I1I.I1I.ILil.iILLL1 f3174ILil;

        public IL1Iii(I1I.I1I.ILil.iILLL1 iilll1) {
            this.f3174ILil = iilll1;
        }

        @Override // android.content.IOnPrimaryClipChangedListener
        public void dispatchPrimaryClipChanged() {
            try {
                L11I.this.I11L = this.f3174ILil.m1008iILLL1().toString();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$ILil */
    /* JADX INFO: compiled from: CoreScript.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L11I.this.m939LIll();
            lIlii.m24L();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: CoreScript.java */
    public class IL implements IBinder.DeathRecipient {
        public IL() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            L11I.this.llI();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: CoreScript.java */
    public class IiL extends INXOpenFdEvent.Stub {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ File f3178ILil;

        public IiL(File file) {
            this.f3178ILil = file;
        }

        @Override // android.app.INXOpenFdEvent
        public boolean onOpend(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
            try {
                if (Native.unZipFd(parcelFileDescriptor.detachFd(), L11I.this.ILL.getAbsolutePath()) == 0) {
                    return true;
                }
                throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{23, 86, 66, 12, 73, 70}, I1I.IL1Iii.IL1Iii(new byte[]{3, 8, 8, 4, 92, 95}, I1I.IL1Iii.IL1Iii(new byte[]{85, 9, 5, 83, 3, 10}, "4952f3"))) + this.f3178ILil.getAbsolutePath() + I1I.IL1Iii.IL1Iii(new byte[]{69, 80, 83, 12, 85, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{83, 14, 2, 7, 13, 85}, I1I.IL1Iii.IL1Iii(new byte[]{3, 92, 81, 3, 1, 80}, "5daa56"))));
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$L丨1丨1丨I, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: CoreScript.java */
    public class BinderC0525L11I extends LL1IL.IL1Iii {
        public BinderC0525L11I(L11I l11i) {
        }

        @Override // I1I.I1I.ILil.LL1IL
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo917L11I(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Engine.onTouchEvent(i, i2, i3, i4, i5);
        }

        public /* synthetic */ BinderC0525L11I(L11I l11i, IL1Iii iL1Iii) {
            this(l11i);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: CoreScript.java */
    public class iILLL1 implements C0003lL.ILil {
        public iILLL1(L11I l11i) {
        }

        @Override // I1I.I1I.ILil.C0003lL.ILil
        public void IL1Iii(int i, int i2, int i3, int i4, int i5) {
            Engine.setDisplayInfo(i, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1丨1丨I$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: CoreScript.java */
    public class lLi1LL implements IBinder.DeathRecipient {
        public lLi1LL() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            L11I.this.llI();
        }
    }

    public L11I(int i, int i2, int i3, String str, String str2, String str3) {
        this.f972IiL = i3;
        this.f979lLi1LL = str2;
        this.f975iILLL1 = str3;
        this.f3171Ilil = str;
        m9501();
        f969lIII = this;
        if (!lIlii.m1183IlL1ll1() || lIlii.m1189iILLl() == 3 || lIlii.m1189iILLl() == 4) {
            return;
        }
        m949LLlI1();
    }

    public static L11I I11L() {
        return f969lIII;
    }

    public File I11li1() {
        return this.f976lIiI;
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public final void m935IIiI() {
        try {
            INXCoreNative iNXCoreNative = this.f970ILl;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                this.f970ILl = obtainScriptProxy(1);
            }
            INXCoreNative iNXCoreNative2 = this.f970ILl;
            if (iNXCoreNative2 == null || iNXCoreNative2.asBinder() == null || !this.f970ILl.asBinder().isBinderAlive()) {
                return;
            }
            this.f970ILl.setTsEventListener(1, this.f9831);
        } catch (Exception unused) {
        }
    }

    public void ILil(INXCoreNative iNXCoreNative) {
    }

    public String Ilil(int i, int i2, int i3, String str) {
        try {
            if (i == 11) {
                if (i2 == 48) {
                    try {
                        UiSelNative uiSelNative = this.LlLI1;
                        if (uiSelNative == null) {
                            return BuildConfig.FLAVOR;
                        }
                        uiSelNative.setMode(i3);
                        return I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{2, 89, 91, 13, 85, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 85, 13, 82, 82}, "b875ed")));
                    } catch (Exception unused) {
                        return BuildConfig.FLAVOR;
                    }
                }
                if (i2 == 49) {
                    if (i2 != 1) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{87}, I1I.IL1Iii.IL1Iii(new byte[]{83, 9, 82, 3, 86, 2}, I1I.IL1Iii.IL1Iii(new byte[]{84, 12, 81, 1, 82, 3}, "a52413")));
                    }
                    for (int i4 = 0; i4 < 50; i4++) {
                        Point pointILI1Ll = lIlii.ILI1Ll();
                        Point pointM1180ILI = lIlii.m1180ILI();
                        if (pointILI1Ll != null && pointM1180ILI != null && pointILI1Ll.x == pointM1180ILI.x && pointILI1Ll.y == pointM1180ILI.y) {
                            return I1I.IL1Iii.IL1Iii(new byte[]{6}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 86, 2, 2, 4}, I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 85, 85, 81, 83}, "17fbab")));
                        }
                        Thread.sleep(100L);
                    }
                    return I1I.IL1Iii.IL1Iii(new byte[]{8}, I1I.IL1Iii.IL1Iii(new byte[]{10, 13, 3, 82, 6, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 15, 87, 3, 14, 82}, "56b78b")));
                }
            }
            if (this.f972IiL == 0) {
                if (i == 11) {
                    if (i2 == 7) {
                        return m937L11(i, i2, i3, str);
                    }
                    if (i2 == 11 && i3 == 1) {
                        return m937L11(i, i2, i3, str);
                    }
                    if (i2 != 12 && i2 != 15 && i2 != 16) {
                        if (i2 == 17 || i2 == 18 || i2 == 19) {
                            if (i2 == 18) {
                                String str2 = this.I11L;
                                if (str2 != null) {
                                    return str2;
                                }
                                if (lIlii.m1183IlL1ll1()) {
                                    ILL ill = this.f971IL;
                                    if (ill != null) {
                                        return ill.I11L(i, i2, i3, str);
                                    }
                                    return null;
                                }
                            }
                            String strM937L11 = m937L11(i, i2, i3, str);
                            if (!TextUtils.isEmpty(strM937L11)) {
                                return strM937L11;
                            }
                        } else if (i2 == 39) {
                            return m937L11(i, i2, i3, str);
                        }
                    }
                    return m937L11(i, i2, i3, str);
                }
                if (i == 10) {
                    if (i2 >= 5 && i2 <= 7) {
                        String strM937L12 = m937L11(i, i2, i3, str);
                        if (i2 != 6) {
                            return strM937L12;
                        }
                    } else if (i2 == 9) {
                        return m937L11(i, i2, i3, str);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        ILL ill2 = this.f971IL;
        if (ill2 != null) {
            return ill2.I11L(i, i2, i3, str);
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public boolean m936IIi() {
        try {
            String strI11L = this.f971IL.I11L(8, 0, 0, BuildConfig.FLAVOR);
            return strI11L != null && strI11L.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{83}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 81, 15, 81, 94}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 7, 8, 4, 89}, "1fe0ea")))) == 0;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public String m937L11(int i, int i2, int i3, String str) {
        try {
            INXCoreNative iNXCoreNative = this.f970ILl;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                this.f970ILl = obtainScriptProxy(1);
            }
            INXCoreNative iNXCoreNative2 = this.f970ILl;
            if (iNXCoreNative2 == null || iNXCoreNative2.asBinder() == null || !this.f970ILl.asBinder().isBinderAlive()) {
                return null;
            }
            return this.f970ILl.sendCmd(i, i2, i3, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean m938L111() {
        return this.llliI;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m939LIll() {
        try {
            iIi1();
            lIlii.Li1l(llliI(), lIlii.LiL1(), lIlii.m1172lIII(), lIlii.m1189iILLl());
            if (lIlii.m1183IlL1ll1()) {
                LlLiLL.IL1Iii().ILil();
            }
            m941L1l(0);
            File file = this.f976lIiI;
            Engine.setWorkPath(file != null ? file.getAbsolutePath() : BuildConfig.FLAVOR, this.f980il.getPath());
            if (!this.ILL.exists()) {
                this.ILL.mkdir();
            }
            C0003lL.I1I().m1031IL(new iILLL1(this));
            File file2 = new File(this.f973Ll1, I1I.IL1Iii.IL1Iii(new byte[]{68, 5, 19, 94, 20, 16, 25, 10, 19}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 81, 7, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 82, 84, 11, 7}, "e0bd9b"))));
            if (!new File(this.f975iILLL1).exists()) {
                try {
                    if (!this.f971IL.m860ILl(this.f975iILLL1, new IiL(file2))) {
                        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 108}, I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 3, 6, 80, 1}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 82, 8, 6, 89}, "25e8ba"))), I1I.IL1Iii.IL1Iii(new byte[]{94, 68, 86, 10, 21}, I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 86, 6, 1, 86}, I1I.IL1Iii.IL1Iii(new byte[]{7, 10, 82, 1, 82, 2}, "137cfc"))) + this.f975iILLL1 + I1I.IL1Iii.IL1Iii(new byte[]{19, 82, 86, 93, 9, 80, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 85, 3, 81, 87}, I1I.IL1Iii.IL1Iii(new byte[]{11, 81, 4, 4, 80, 86}, "97f3d4"))));
                        return;
                    }
                } catch (Exception unused) {
                }
            } else {
                if (Native.unZip(new File(this.f975iILLL1).getAbsolutePath(), this.ILL.getAbsolutePath()) != 0) {
                    throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{65, 12, 31, 93, 72, 16}, I1I.IL1Iii.IL1Iii(new byte[]{13, 91, 82, 80, 11, 85}, I1I.IL1Iii.IL1Iii(new byte[]{9, 13, 1, 6, 1, 87}, "046b22"))) + file2.getAbsolutePath() + I1I.IL1Iii.IL1Iii(new byte[]{70, 80, 2, 92, 93, 80, 2}, I1I.IL1Iii.IL1Iii(new byte[]{84, 84, 1, 2, 6, 83}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 81, 2, 86, 7}, "7f35aa"))));
                }
                Ilil(10, 14, 0, BuildConfig.FLAVOR);
                Engine.start(0L, this.f972IiL, this.ILL.getAbsolutePath(), file2.getAbsolutePath());
            }
            Ilil(10, 14, 0, BuildConfig.FLAVOR);
            Engine.start(0L, this.f972IiL, this.ILL.getAbsolutePath(), file2.getAbsolutePath());
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{120, 109}, I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 83, 84, 86, 84}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 9, 6, 86, 0}, "f09ec1"))), I1I.IL1Iii.IL1Iii(new byte[]{16, 68, 90, 102, 91, 70, 11, 65, 64, 21, 93, 70, 16, 11}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 5, 7, 91, 2}, I1I.IL1Iii.IL1Iii(new byte[]{83, 7, 5, 11, 82, 5}, "ef4913"))) + e.toString());
            e.printStackTrace();
        }
    }

    public boolean LL1IL() {
        return this.f972IiL == 0;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public void m940LlIl() {
        new Thread(this).start();
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public final synchronized void m941L1l(int i) throws Exception {
        C0002iI.I1I();
        if (i == 0 || this.I11li1) {
            if (this.f972IiL == 0) {
                this.f970ILl = obtainScriptProxy(1);
            }
            obtainDataTask();
            boolean zM938L111 = m938L111();
            if (i == 0) {
                this.LlLI1 = new UiSelNative(obtainUiSelectorProxy(zM938L111 ? 1 : 0));
                this.f978llL1ii = new UiObjNative(obtainUiObjectProxy(zM938L111 ? 1 : 0));
                this.f977lIlii = new UiAccActionNative(obtainAccessibityActionProxy());
                this.iIi1 = obtainAccessibityService();
                Engine.init(this.LlLI1, this.f978llL1ii, this.f977lIlii);
                this.I11li1 = true;
            } else {
                UiSelNative uiSelNative = this.LlLI1;
                if (uiSelNative != null) {
                    uiSelNative.setProxy(obtainUiSelectorProxy(zM938L111 ? 1 : 0));
                }
                UiObjNative uiObjNative = this.f978llL1ii;
                if (uiObjNative != null) {
                    uiObjNative.setProxy(obtainUiObjectProxy(zM938L111 ? 1 : 0));
                }
                UiAccActionNative uiAccActionNative = this.f977lIlii;
                if (uiAccActionNative != null) {
                    uiAccActionNative.setProxy(obtainAccessibityActionProxy());
                }
                this.iIi1 = obtainAccessibityService();
                Engine.reset();
            }
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 106}, I1I.IL1Iii.IL1Iii(new byte[]{10, 2, 5, 84, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 8, 0, 86, 5, 82}, "481d0f"))), I1I.IL1Iii.IL1Iii(new byte[]{14, 12, 91, 10, 14, 8, 14, 12, 91, 10, 14, 8, 14, 12, 9, 85, 71, 84, 90, 95, 54, 69, 92, 77, 74, 2, 91, 10, 14, 8, 14, 12, 91, 10, 14, 8, 14, 12, 91, 10, 14, 8, 14, 12, 91, 10, 14, 8, 14, 12, 91, 10, 14, 8, 14}, I1I.IL1Iii.IL1Iii(new byte[]{5, 5, 82, 14, 82, 2}, I1I.IL1Iii.IL1Iii(new byte[]{80, 81, 1, 92, 89, 1}, "fe5e86"))));
        }
        try {
            String strIIlLiL = this.f971IL.iIlLiL(18);
            if (strIIlLiL != null) {
                Integer.parseInt(strIIlLiL);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m942LlLLL(String str) {
        File file = new File(new File(this.f975iILLL1).getParent(), I1I.IL1Iii.IL1Iii(new byte[]{18, 7, 65, 93, 19, 68, 79, 8, 65, 26, 23, 93, 17}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 4, 6, 5, 2}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 2, 81, 87, 84}, "b05c1f"))));
        if (this.f971IL.m868lIlii(str, file.getAbsolutePath())) {
            String strI11L = this.f971IL.I11L(8, 0, 0, file.getAbsolutePath());
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 107}, I1I.IL1Iii.IL1Iii(new byte[]{82, 80, 86, 85, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 85, 82, 2, 85}, "6aea56"))), I1I.IL1Iii.IL1Iii(new byte[]{121, 48, 36, 58, 49, 32, 103, 55, 34, 55, 55, 58, 103, 32, 89}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 82, 86, 0, 3}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 87, 1, 87, 7}, "6ef24a"))) + strI11L);
            if (strI11L.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{82}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 6, 0, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 14, 0, 84, 83}, "e4996b")))) == 0) {
                try {
                    Thread.sleep(600000L);
                } catch (Exception unused) {
                }
                return true;
            }
        } else {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 107}, I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 12, 80, 4, 15}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 13, 4, 11, 80}, "e78f8f"))), I1I.IL1Iii.IL1Iii(new byte[]{22, 4, 86, 82, 117, 12, 9, 4, 24}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 11, 4, 85, 92}, I1I.IL1Iii.IL1Iii(new byte[]{3, 2, 4, 6, 3, 93}, "1774ed"))) + str + I1I.IL1Iii.IL1Iii(new byte[]{23, 4, 2, 11, 94, 93, 83, 104}, I1I.IL1Iii.IL1Iii(new byte[]{82, 84, 83, 86, 0, 10}, I1I.IL1Iii.IL1Iii(new byte[]{93, 3, 8, 86, 1, 86}, "858b3d"))));
        }
        return false;
    }

    public final void iIi1() {
        try {
            if (!LL1IL() || this.f971IL.iIlLiL(20) == null) {
                return;
            }
            this.llliI = true;
            m937L11(21, 0, 0, BuildConfig.FLAVOR);
        } catch (Exception unused) {
        }
    }

    public boolean iIlLiL(String str, String str2) {
        try {
            if (new File(str).exists() && lIlii.m1144L11I(str, str2) && new File(str2).exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            boolean zIlil = this.f971IL.Ilil(str, str2);
            if (zIlil) {
                return zIlil;
            }
        } catch (Exception unused2) {
        }
        return this.f971IL.m861IL(str, str2) && new File(str2).exists();
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final boolean m943ill(IBinder iBinder, String str) {
        Bundle bundleCall;
        String str2 = this.f3171Ilil + I1I.IL1Iii.IL1Iii(new byte[]{24, 122, 9, 75, 83, 98, 68, 86, 16, 80, 82, 87, 68}, I1I.IL1Iii.IL1Iii(new byte[]{3, 92, 7, 11, 84, 10}, I1I.IL1Iii.IL1Iii(new byte[]{6, 92, 83, 5, 91, 10}, "392792")));
        I1I.I1I.ILil.IiL iiL = null;
        try {
            Context contextM1143L1l = lIlii.m1143L1l();
            if (contextM1143L1l != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 93, 74, 10, 72, 77, 80, 95, 22, 1, 30, 20, 65, 81, 20, 20, 85, 17, 64, 30, 13, 10, 68, 6, 93, 68, 74, 1, 72, 23, 65, 81, 74, 38, 121, 45, 119, 117, 54}, I1I.IL1Iii.IL1Iii(new byte[]{83, 4, 84, 1, 6, 4}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 86, 86, 7, 5}, "cf23e1"))), new BinderContainer(iBinder));
                bundle.putString(I1I.IL1Iii.IL1Iii(new byte[]{83, 14, 95, 30, 11, 77, 30, 2, 93, 66, 0, 27, 68, 14, 89, 85, 11}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 1, 3, 87, 1}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 87, 87, 80, 81}, "bcddbe"))), str);
                if (Build.VERSION.SDK_INT >= 29) {
                    bundleCall = contextM1143L1l.getContentResolver().call(str2, I1I.IL1Iii.IL1Iii(new byte[]{65, 0, 88, 84, 54, 68, 87, 23, 101, 85, 17, 65, 91, 6, 83, 99, 0, 69, 91, 21, 66}, I1I.IL1Iii.IL1Iii(new byte[]{81, 86, 0, 81, 87, 4}, I1I.IL1Iii.IL1Iii(new byte[]{90, 87, 84, 3, 80, 2}, "9dbbd1"))), (String) null, bundle);
                } else {
                    bundleCall = contextM1143L1l.getContentResolver().call(Uri.parse(I1I.IL1Iii.IL1Iii(new byte[]{2, 14, 90, 70, 85, 90, 21, 91, 27, 29}, I1I.IL1Iii.IL1Iii(new byte[]{86, 88, 12, 84, 9, 4}, I1I.IL1Iii.IL1Iii(new byte[]{0, 15, 15, 94, 90, 86}, "7678cf"))) + str2), I1I.IL1Iii.IL1Iii(new byte[]{75, 1, 93, 6, 100, 17, 93, 22, 96, 7, 67, 20, 81, 7, 86, 49, 82, 16, 81, 20, 71}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 80, 3, 80, 6}, I1I.IL1Iii.IL1Iii(new byte[]{93, 6, 91, 7, 83, 93}, "ed8f29"))), (String) null, bundle);
                }
                if (bundleCall == null) {
                    return false;
                }
                this.f971IL = new ILL(null, bundleCall, new IL());
                try {
                    m941L1l(1);
                } catch (Exception unused) {
                }
                return true;
            }
            I1I.I1I.ILil.IiL iiLIL1Iii = C0001i1.Ilil().IL1Iii().IL1Iii(str2, iBinder);
            try {
                if (iiLIL1Iii == null) {
                    I1I.I1I.p008IL.IiL.IL1Iii(f968LlLLL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{70, 71, 92, 65, 93, 86, 83, 71, 19, 94, 71, 18, 88, 64, 95, 91, 20, 23, 69, 21, 22, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 86, 84, 4, 0}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 80, 86, 3, 86}, "66553d"))), str2, 0));
                    C0603ill c0603illM955lLi1LL = C0001i1.Ilil().m955lLi1LL();
                    if (c0603illM955lLi1LL != null && c0603illM955lLi1LL.IL1Iii(this.f3171Ilil, 0, 0) == null) {
                        lIlii.m24L();
                    }
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th) {
                            I1I.I1I.p008IL.IiL.I1I(f968LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{17, 93, 94, 11, 79, 86, 32, 87, 93, 16, 92, 93, 23, 104, 65, 11, 79, 90, 7, 93, 65, 33, 65, 71, 6, 74, 93, 5, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 1, 2, 93, 0, 7}, I1I.IL1Iii.IL1Iii(new byte[]{12, 15, 80, 93, 15, 5}, "96ad61"))) + th.toString());
                        }
                    }
                    return false;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 93, 29, 86, 76, 24, 87, 95, 65, 93, 26, 65, 70, 81, 67, 72, 81, 68, 71, 30, 90, 86, 64, 83, 90, 68, 29, 93, 76, 66, 70, 81, 29, 122, 125, 120, 112, 117, 97}, I1I.IL1Iii.IL1Iii(new byte[]{7, 80, 8, 85, 14, 87}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 0, 82, 6, 86}, "c18405"))), new BinderContainer(iBinder));
                bundle2.putString(I1I.IL1Iii.IL1Iii(new byte[]{0, 11, 88, 79, 12, 26, 77, 7, 90, 19, 7, 76, 23, 11, 94, 4, 12}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 13, 5, 3, 91}, I1I.IL1Iii.IL1Iii(new byte[]{0, 86, 1, 86, 85, 15}, "ff9246"))), str);
                Bundle bundleM893IiL = iiLIL1Iii.m893IiL(str2, I1I.IL1Iii.IL1Iii(new byte[]{69, 84, 86, 93, 52, 23, 83, 67, 107, 92, 19, 18, 95, 82, 93, 106, 2, 22, 95, 65, 76}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 11, 9, 89, 92}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 2, 3, 8, 11}, "c11303"))), null, bundle2);
                if (bundleM893IiL == null) {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th2) {
                            I1I.I1I.p008IL.IiL.I1I(f968LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{23, 80, 84, 9, 78, 84, 38, 90, 87, 18, 93, 95, 17, 101, 75, 9, 78, 88, 1, 80, 75, 35, 64, 69, 0, 71, 87, 7, 84}, I1I.IL1Iii.IL1Iii(new byte[]{80, 80, 9, 7, 89, 9}, I1I.IL1Iii.IL1Iii(new byte[]{80, 1, 7, 86, 89, 91}, "ed778c"))) + th2.toString());
                        }
                    }
                    return false;
                }
                this.f971IL = new ILL(null, bundleM893IiL, new lLi1LL());
                try {
                    m941L1l(1);
                } catch (Exception unused2) {
                }
                if (iiLIL1Iii != null) {
                    try {
                        C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                    } catch (Throwable th3) {
                        I1I.I1I.p008IL.IiL.I1I(f968LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{64, 7, 85, 89, 20, 6, 113, 13, 86, 66, 7, 13, 70, 50, 74, 89, 20, 10, 86, 7, 74, 115, 26, 23, 87, 16, 86, 87, 14}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 93, 14, 80, 7}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 1, 89, 83, 7}, "d5daac"))) + th3.toString());
                    }
                }
                return true;
            } catch (Throwable unused3) {
                iiL = iiLIL1Iii;
                try {
                    I1I.I1I.p008IL.IiL.IL1Iii(f968LlLLL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{80, 83, 95, 84, 0, 6, 22, 65, 83, 86, 1, 66, 84, 91, 88, 92, 0, 16, 22, 70, 89, 24, 64, 17, 22, 91, 88, 24, 16, 17, 83, 64, 22, 29, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 2, 1, 0, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 82, 94, 87, 83}, "aaef66"))), str2, 0));
                    if (iiL != null) {
                        try {
                        } catch (Throwable th4) {
                            String str3 = f968LlLLL;
                            StringBuilder sb = new StringBuilder();
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{22, 93, 92, 10, 21, 7, 39, 87, 95, 17, 6, 12, 16, 104, 67, 10, 21, 11, 0, 93, 67, 32, 27, 22, 1, 74, 95, 4, 15}, I1I.IL1Iii.IL1Iii(new byte[]{1, 14, 1, 4, 81, 80}, I1I.IL1Iii.IL1Iii(new byte[]{6, 80, 1, 83, 86, 81}, "cf12dc")));
                        }
                    }
                    return false;
                } finally {
                    if (iiL != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th5) {
                            I1I.I1I.p008IL.IiL.I1I(f968LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{17, 0, 15, 14, 23, 87, 32, 10, 12, 21, 4, 92, 23, 53, 16, 14, 23, 91, 7, 0, 16, 36, 25, 70, 6, 23, 12, 0, 13}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 82, 84, 4, 5}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 8, 3, 82, 2}, "1f8675"))) + th5.toString());
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public int m944l1IIi1(int[] iArr, int[] iArr2, int[] iArr3) {
        INXCoreNative iNXCoreNativeM864L11I;
        SharedMem sharedMem;
        if (this.f972IiL == 0) {
            INXCoreNative iNXCoreNative = this.f970ILl;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                try {
                    this.f970ILl = obtainScriptProxy(1);
                } catch (Exception unused) {
                }
            }
            iNXCoreNativeM864L11I = this.f970ILl;
        } else {
            iNXCoreNativeM864L11I = this.f971IL.m864L11I();
        }
        if (iNXCoreNativeM864L11I == null || iNXCoreNativeM864L11I == null) {
            return -1;
        }
        try {
            if (!iNXCoreNativeM864L11I.asBinder().isBinderAlive()) {
                return -1;
            }
            Bundle bundleObtainData = iNXCoreNativeM864L11I.obtainData(1);
            bundleObtainData.setClassLoader(SharedMem.class.getClassLoader());
            if (bundleObtainData == null) {
                return -1;
            }
            sharedMem = (SharedMem) bundleObtainData.get(I1I.IL1Iii.IL1Iii(new byte[]{10, 89, 84, 85, 93}, I1I.IL1Iii.IL1Iii(new byte[]{90, 80, 3, 81, 11, 9}, I1I.IL1Iii.IL1Iii(new byte[]{9, 7, 2, 81, 1, 80}, "0c422a"))));
            try {
                int i = bundleObtainData.getInt(I1I.IL1Iii.IL1Iii(new byte[]{17, 93, 84, 64, 94}, I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 83, 1, 14, 14}, I1I.IL1Iii.IL1Iii(new byte[]{80, 6, 85, 81, 12, 90}, "f06d4b"))));
                int i2 = bundleObtainData.getInt(I1I.IL1Iii.IL1Iii(new byte[]{90, 1, 15, 95, 91, 16}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 80, 91, 4, 93}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 15, 0, 0, 14}, "039c77"))));
                int i3 = bundleObtainData.getInt(I1I.IL1Iii.IL1Iii(new byte[]{22, 89, 66, 18, 64, 65, 13, 82, 80}, I1I.IL1Iii.IL1Iii(new byte[]{92, 6, 81, 83, 13, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 6, 2, 14, 94}, "85b078"))));
                if (iArr != null && iArr2 != null && iArr3 != null) {
                    iArr[0] = i;
                    iArr2[0] = i2;
                    iArr3[0] = i3;
                }
                return sharedMem.ILil();
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            sharedMem = null;
        }
        if (sharedMem == null) {
            return -1;
        }
        try {
            sharedMem.IL1Iii();
            return -1;
        } catch (Exception unused4) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public synchronized void m945lIII() {
        if (!this.iIlLiL) {
            this.iIlLiL = true;
            if (lIlii.m1183IlL1ll1()) {
                TsEventNative.start();
                TsEventNative.setITsEventListener(1, this.f9831);
            } else if (this.f972IiL == 0) {
                m935IIiI();
            }
        }
    }

    public final void llI() {
        this.f974L11I.postDelayed(new I1I(), 300L);
    }

    public String llliI() {
        String str = this.Lil;
        if (str != null) {
            return str;
        }
        try {
            this.Lil = this.f971IL.iIlLiL(14);
        } catch (Exception unused) {
        }
        return this.Lil;
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public llliI obtainAccessibityActionProxy() {
        ILL ill = this.f971IL;
        if (ill != null) {
            return ill.m866iILLL1();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public IAccessibServiceProxy obtainAccessibityService() {
        ILL ill = this.f971IL;
        if (ill != null) {
            return ill.m862IiL();
        }
        return null;
    }

    @Override // android.app.INXCoreNative
    public l obtainDataTask() {
        ILL ill = this.f971IL;
        if (ill != null) {
            return ill.m871il();
        }
        return null;
    }

    @Override // android.app.INXCoreNative
    public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
        if (this.f971IL == null) {
            return null;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            INXCoreNative iNXCoreNativeILL = this.f971IL.ILL(i);
            if (iNXCoreNativeILL != null) {
                return iNXCoreNativeILL;
            }
            try {
                Thread.sleep(500L);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // android.app.INXCoreNative
    public L111 obtainUiObjectProxy(int i) throws RemoteException {
        ILL ill = this.f971IL;
        if (ill != null) {
            return ill.m867lIiI(i);
        }
        return null;
    }

    @Override // android.app.INXCoreNative
    public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
        ILL ill = this.f971IL;
        if (ill != null) {
            return ill.m863Ll1(i);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f974L11I = new Handler();
        try {
            m3();
        } catch (Exception unused) {
        }
        Looper.loop();
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
        if (i == 5) {
            return I1I.IL1Iii.IL1Iii(new byte[]{66, 67, 17, 3}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 86, 95, 7, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 11, 8, 80, 6}, "c491dc")));
        }
        if (i == 4) {
            try {
                Engine.sendEvent(-1, 200, BuildConfig.FLAVOR);
            } catch (Exception unused) {
            }
            return I1I.IL1Iii.IL1Iii(new byte[]{9}, I1I.IL1Iii.IL1Iii(new byte[]{12, 5, 1, 90, 7, 87}, I1I.IL1Iii.IL1Iii(new byte[]{12, 85, 85, 92, 91, 7}, "81ed86")));
        }
        if (i == 12) {
            return Engine.sendEvent(i2, i3, str);
        }
        if (i == 15) {
            this.f981lL = true;
            Engine.pause();
            return I1I.IL1Iii.IL1Iii(new byte[]{82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 81, 86, 1, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 93, 89, 85, 82}, "05980b")));
        }
        if (i == 16) {
            Engine.resume();
            this.f981lL = false;
            return I1I.IL1Iii.IL1Iii(new byte[]{0}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 81, 15, 80, 1}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 80, 1, 5, 4}, "44b703")));
        }
        if (i == 17) {
            return this.f981lL ? I1I.IL1Iii.IL1Iii(new byte[]{80}, I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 80, 2, 83, 6}, I1I.IL1Iii.IL1Iii(new byte[]{83, 9, 2, 4, 87, 84}, "b9cbfb"))) : I1I.IL1Iii.IL1Iii(new byte[]{0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 92, 87, 13, 82, 81}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 2, 12, 80, 82}, "b5c4ff")));
        }
        if (i == 24) {
            lIlii.LLlIiil(i2, i3);
            return null;
        }
        if (i != 25) {
            return null;
        }
        try {
            Engine.sendEvent(-1, TbsListener.ErrorCode.EXCEED_UNZIP_RETRY_NUM, BuildConfig.FLAVOR);
        } catch (Exception unused2) {
        }
        return I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 8, 9, 82, 82}, I1I.IL1Iii.IL1Iii(new byte[]{82, 88, 1, 10, 6, 2}, "b99261")));
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public boolean sendKeyEvent(int i, int i2) {
        if (lIlii.m1183IlL1ll1()) {
            LlLiLL.IL1Iii().Ilil(i, i2);
            return false;
        }
        int i3 = this.f972IiL;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    return this.f971IL.iIi1(i, i2);
                }
                return false;
            }
            INXCoreNative iNXCoreNative = this.f970ILl;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                this.f970ILl = obtainScriptProxy(1);
            }
            INXCoreNative iNXCoreNative2 = this.f970ILl;
            if (iNXCoreNative2 == null || iNXCoreNative2.asBinder() == null || !this.f970ILl.asBinder().isBinderAlive()) {
                return false;
            }
            return this.f970ILl.sendKeyEvent(i, i2);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public void sendTaskResultBundle(int i, long j, Bundle bundle) {
        try {
            C0002iI.m956IL(i, j, bundle);
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public boolean sendTouchEvent(int i, int i2, int i3, int i4) {
        if (lIlii.m1183IlL1ll1()) {
            return LlLiLL.IL1Iii().m929lLi1LL(i, i2, i3, i4);
        }
        int i5 = this.f972IiL;
        try {
            if (i5 != 0) {
                if (i5 == 1) {
                    return this.f971IL.m8741(i, i2, i3, i4);
                }
                return false;
            }
            INXCoreNative iNXCoreNative = this.f970ILl;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                this.f970ILl = obtainScriptProxy(1);
            }
            INXCoreNative iNXCoreNative2 = this.f970ILl;
            if (iNXCoreNative2 == null || iNXCoreNative2.asBinder() == null || !this.f970ILl.asBinder().isBinderAlive()) {
                return false;
            }
            return this.f970ILl.sendTouchEvent(i, i2, i3, i4);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m946iILLl() {
        boolean zM938L111 = m938L111();
        boolean z = false;
        try {
            if (this.LlLI1 != null) {
                InterfaceC0606LLlI1 interfaceC0606LLlI1ObtainUiSelectorProxy = obtainUiSelectorProxy(zM938L111 ? 1 : 0);
                if (interfaceC0606LLlI1ObtainUiSelectorProxy != null && interfaceC0606LLlI1ObtainUiSelectorProxy.asBinder() != null && interfaceC0606LLlI1ObtainUiSelectorProxy.asBinder().isBinderAlive()) {
                    z = true;
                }
                this.LlLI1.setProxy(interfaceC0606LLlI1ObtainUiSelectorProxy);
            }
            if (this.f978llL1ii != null) {
                L111 l111ObtainUiObjectProxy = obtainUiObjectProxy(zM938L111 ? 1 : 0);
                if (l111ObtainUiObjectProxy != null && l111ObtainUiObjectProxy.asBinder() != null && l111ObtainUiObjectProxy.asBinder().isBinderAlive()) {
                    z = true;
                }
                this.f978llL1ii.setProxy(l111ObtainUiObjectProxy);
            }
        } catch (Exception unused) {
        }
        if (zM938L111) {
            if (z) {
                this.f982l = 0L;
                return;
            }
            if (this.f982l == 0) {
                this.f982l = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - this.f982l > 30000) {
                this.f982l = 0L;
                iIi1();
            }
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public File m947lL() {
        return this.ILL;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public Bundle m948l() {
        UiSelNative uiSelNative = this.LlLI1;
        if (uiSelNative != null) {
            return uiSelNative.obtainXml();
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m3() {
        try {
            if (m943ill(this, I1I.IL1Iii.IL1Iii(new byte[]{89, 92, 92, 14, 90}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 1, 82, 7, 14}, I1I.IL1Iii.IL1Iii(new byte[]{95, 15, 1, 85, 80, 1}, "960eb8"))))) {
                new Thread(new ILil()).start();
            } else {
                lIlii.m24L();
            }
        } catch (Throwable th) {
            I1I.I1I.p008IL.IiL.IL1Iii(f968LlLLL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{20, 91, 83, 3, 10, 82, 65, 65, 93, 65, 21, 67, 0, 71, 70, 65, 21, 82, 19, 67, 91, 2, 3, 23, 68, 70, 18}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 84, 4, 7, 6}, I1I.IL1Iii.IL1Iii(new byte[]{92, 81, 0, 6, 83, 84}, "87fc2e"))) + th.toString(), lIlii.LiL1()));
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m949LLlI1() {
        try {
            I1I.I1I.ILil.iILLL1 iilll1ILil = C0001i1.Ilil().ILil();
            iilll1ILil.ILil(new IL1Iii(iilll1ILil));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final void m9501() {
        File filesDir = lIlii.m1143L1l() != null ? lIlii.m1143L1l().getFilesDir() : new File(this.f979lLi1LL).getParentFile();
        if (filesDir != null) {
            if (!filesDir.exists()) {
                filesDir.mkdir();
            }
            File file = new File(filesDir, I1I.IL1Iii.IL1Iii(new byte[]{0, 74, 17, 0, 16, 67}, I1I.IL1Iii.IL1Iii(new byte[]{86, 13, 7, 87, 92, 7}, I1I.IL1Iii.IL1Iii(new byte[]{14, 12, 84, 5, 92, 86}, "9817da"))));
            this.f976lIiI = file;
            if (!file.exists()) {
                this.f976lIiI.mkdirs();
            }
            File file2 = new File(filesDir, I1I.IL1Iii.IL1Iii(new byte[]{23, 90, 22, 13, 20, 67}, I1I.IL1Iii.IL1Iii(new byte[]{86, 15, 6, 82, 85, 0}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 81, 82, 87, 2}, "4b3df5"))));
            this.f973Ll1 = file2;
            if (!file2.exists()) {
                this.f973Ll1.mkdir();
            }
            File file3 = new File(this.f973Ll1, I1I.IL1Iii.IL1Iii(new byte[]{18, 86, 66, 9}, I1I.IL1Iii.IL1Iii(new byte[]{3, 12, 1, 1, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 2, 84, 87, 80}, "6037cd"))));
            this.f980il = file3;
            if (!file3.exists()) {
                this.f980il.mkdir();
            }
            File file4 = new File(this.f973Ll1, I1I.IL1Iii.IL1Iii(new byte[]{3, 13, 8}, I1I.IL1Iii.IL1Iii(new byte[]{80, 81, 87, 83, 85, 92}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 2, 4, 0, 11}, "db32d3"))));
            this.ILL = file4;
            try {
                lIlii.m1142Ll1(file4);
            } catch (Exception unused) {
            }
            if (this.ILL.exists()) {
                return;
            }
            this.ILL.mkdir();
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m951(int i, String str, String str2) {
        if (this.f971IL != null) {
            String absolutePath = this.ILL.getAbsolutePath();
            int iIndexOf = str.indexOf(absolutePath);
            if (iIndexOf >= 0) {
                str = str.substring(iIndexOf + absolutePath.length() + 1);
            }
            this.f971IL.Lil(i, str, str2);
        }
    }
}
