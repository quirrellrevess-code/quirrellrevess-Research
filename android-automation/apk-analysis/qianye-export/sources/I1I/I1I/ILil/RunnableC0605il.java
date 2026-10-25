package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.app.INXCoreNative;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.main.app.Native;
import com.main.engine.BinderContainer;
import com.main.engine.RotateMgr;
import com.main.engine.ScriptMain;
import com.main.engine.SharedMem;
import com.main.engine.TsEventNative;
import com.main.engine.UiAutoMain;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: CoreService.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0605il extends lIlii implements Runnable {
    public RotateMgr ILL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ILL f1051IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public SharedMem f1052Ll1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1054iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String f1058lLi1LL;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1050IL = RunnableC0605il.class.getName();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Handler f3304Ilil = null;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Process f1053L11I = null;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Process f1059il = null;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1055lIiI = false;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public Process f1049ILl = null;
    public Thread Lil = null;
    public boolean LlLI1 = false;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public Object f1057llL1ii = new Object();

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final Object f1056lIlii = new Object();
    public boolean iIi1 = false;

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$I1I */
    /* JADX INFO: compiled from: CoreService.java */
    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RunnableC0605il.this.I11li1();
            RunnableC0605il runnableC0605il = RunnableC0605il.this;
            if (runnableC0605il.m1053l(runnableC0605il, I1I.IL1Iii.IL1Iii(new byte[]{94, 87, 85, 91, 14}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 14, 86, 89, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 84, 81, 15, 2}, "e7c07d"))))) {
                return;
            }
            RunnableC0605il.this.f3304Ilil.postDelayed(this, 300L);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$IL1Iii */
    /* JADX INFO: compiled from: CoreService.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RunnableC0605il.this.m1052lL();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$ILil */
    /* JADX INFO: compiled from: CoreService.java */
    public class ILil implements RotateMgr.IL1Iii {
        public ILil(RunnableC0605il runnableC0605il) {
        }

        @Override // com.main.engine.RotateMgr.IL1Iii
        public void IL1Iii(int i) {
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: CoreService.java */
    public class IL implements IBinder.DeathRecipient {
        public IL() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            RunnableC0605il.this.llliI();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: CoreService.java */
    public class IiL implements Runnable {
        public IiL(RunnableC0605il runnableC0605il) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: CoreService.java */
    public class iILLL1 implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3309ILil;

        public iILLL1(String str) {
            this.f3309ILil = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RunnableC0605il.this.m1050LlLLL(this.f3309ILil);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨il$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: CoreService.java */
    public class lLi1LL implements Runnable {
        public lLi1LL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (RunnableC0605il.this.LlLI1) {
                RunnableC0605il.this.LL1IL();
                try {
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public RunnableC0605il(int i) {
        this.f1054iILLL1 = i;
        TsEventNative.start();
    }

    public final void I11L() {
        int i;
        try {
            LlLiLL.IL1Iii().ILil();
        } catch (Exception unused) {
        }
        C0001i1.Ilil();
        this.ILL = RotateMgr.m3485IL();
        Context contextLI1I1 = lIlii.lI1I1();
        try {
            File file = new File(new File(lIlii.m1172lIII()).getParentFile(), I1I.IL1Iii.IL1Iii(new byte[]{17, 81, 82, 19, 7, 88, 7, 84}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 80, 3, 85, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 10, 6, 81, 2, 84}, "12e35b"))));
            C0599ILl c0599ILlIL1Iii = C0001i1.Ilil().I1I().IL1Iii(0);
            int iILil = c0599ILlIL1Iii.ILil().ILil();
            int iIL1Iii = c0599ILlIL1Iii.ILil().IL1Iii();
            Point pointM1180ILI = lIlii.m1180ILI();
            int i2 = pointM1180ILI.x;
            if (i2 > 0 && (i = pointM1180ILI.y) > 0) {
                iILil = i2 < 16 ? 16 : i2;
                iIL1Iii = i < 16 ? 16 : i;
            }
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 61}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 85, 2, 0, 86}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 82, 3, 1, 6}, "f1f66d"))), I1I.IL1Iii.IL1Iii(new byte[]{21, 8, 74, 0, 94}, I1I.IL1Iii.IL1Iii(new byte[]{2, 88, 6, 92, 80, 87}, I1I.IL1Iii.IL1Iii(new byte[]{84, 11, 6, 14, 5, 4}, "020712"))) + iILil + I1I.IL1Iii.IL1Iii(new byte[]{29}, I1I.IL1Iii.IL1Iii(new byte[]{8, 87, 0, 91, 6, 12}, I1I.IL1Iii.IL1Iii(new byte[]{10, 85, 80, 89, 2, 1}, "3dbaa4"))) + iIL1Iii);
            SharedMem sharedMem = new SharedMem(file.getAbsolutePath(), (long) (iILil * iIL1Iii * 5));
            this.f1052Ll1 = sharedMem;
            sharedMem.m3486IL();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{40, 60}, I1I.IL1Iii.IL1Iii(new byte[]{83, 93, 0, 4, 87, 4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 82, 5, 6, 1}, "79b432"))), I1I.IL1Iii.IL1Iii(new byte[]{3, 71, 88, 65, 84, 70, 16, 13}, I1I.IL1Iii.IL1Iii(new byte[]{80, 15, 87, 89, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{80, 10, 87, 90, 1, 5}, "b23be5"))) + e.toString());
        }
        I1L11L.m850lLi1LL().m855il();
        this.ILL.Ilil(new ILil(this));
        try {
            lL.IL1Iii(contextLI1I1, lIlii.LiL1(), 3, lL.ILil(0));
            m1053l(this, I1I.IL1Iii.IL1Iii(new byte[]{92, 1, 13, 95, 14}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 2, 86, 7, 8}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 82, 93, 4, 90}, "cf18bb"))));
        } catch (Throwable th) {
            I1I.I1I.p008IL.IiL.IL1Iii(this.f1050IL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{77, 87, 87, 7, 94, 83, 24, 77, 89, 69, 65, 66, 89, 75, 66, 69, 65, 83, 74, 79, 95, 6, 87, 22, 29, 74, 22}, I1I.IL1Iii.IL1Iii(new byte[]{11, 92, 15, 85, 10, 4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 92, 11, 0, 14, 7}, "f92065"))) + th.toString(), lIlii.LiL1()));
        }
    }

    public final void I11li1() {
        try {
            boolean zM1035lLi1LL = C0001i1.Ilil().IL1Iii().m1035lLi1LL(String.format(I1I.IL1Iii.IL1Iii(new byte[]{21, 68, 23, 91, 93, 90, 30, 90, 89, 81, 92, 25, 81, 71, 72, 22, 127, 86, 89, 89, 107, 93, 64, 65, 89, 84, 93}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 10, 0, 1, 86}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 87, 12, 81, 3}, "50e4bb"))), lIlii.LiL1()));
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 107}, I1I.IL1Iii.IL1Iii(new byte[]{5, 10, 8, 80, 82, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 95, 92, 7, 90, 84}, "0fdc80"))), I1I.IL1Iii.IL1Iii(new byte[]{90, 92, 1, 22, 95, 91, 71, 92, 89, 88}, I1I.IL1Iii.IL1Iii(new byte[]{1, 8, 82, 7, 11, 83}, I1I.IL1Iii.IL1Iii(new byte[]{9, 8, 15, 83, 93, 5}, "9992ed"))) + zM1035lLi1LL);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m1049L111() {
        try {
            Process process = this.f1059il;
            if (process != null) {
                process.destroy();
                this.f1059il = null;
            }
        } catch (Exception unused) {
        }
        try {
            Process process2 = this.f1053L11I;
            if (process2 != null) {
                process2.destroy();
                this.f1053L11I = null;
            }
        } catch (Exception e) {
            I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{43, 58}, I1I.IL1Iii.IL1Iii(new byte[]{86, 0, 82, 0, 86, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 87, 8, 85, 7}, "a4f91f"))), I1I.IL1Iii.IL1Iii(new byte[]{22, 64, 94, 70, 50, 87, 23, 93, 65, 66, 65, 81, 23, 70, 11}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 6, 7, 86, 4}, I1I.IL1Iii.IL1Iii(new byte[]{9, 84, 84, 80, 81, 83}, "86cafc"))) + e.toString());
        }
    }

    public final void LL1IL() {
        String[] strArr;
        Process processStart;
        synchronized (this.f1056lIlii) {
            if (this.iIi1) {
                return;
            }
            this.iIi1 = true;
            try {
                try {
                    String strIL1Iii = (lIlii.m1189iILLl() == 1 || lIlii.m1189iILLl() == 3) ? I1I.IL1Iii.IL1Iii(new byte[]{5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 13, 3, 6, 5}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 82, 80, 82, 0}, "0af216"))) : I1I.IL1Iii.IL1Iii(new byte[]{14, 1}, I1I.IL1Iii.IL1Iii(new byte[]{8, 81, 1, 84, 6, 80}, I1I.IL1Iii.IL1Iii(new byte[]{5, 92, 81, 80, 6, 83}, "58a15b")));
                    if (lIlii.m1203l1L()) {
                        strArr = new String[]{I1I.IL1Iii.IL1Iii(new byte[]{89, 19, 20, 105, 68, 23, 87, 0, 1, 69, 71}, I1I.IL1Iii.IL1Iii(new byte[]{91, 84, 85, 7, 80, 83}, I1I.IL1Iii.IL1Iii(new byte[]{6, 83, 0, 4, 2, 14}, "ed15f8"))) + strIL1Iii, lIlii.lLIL1(), I1I.IL1Iii.IL1Iii(new byte[]{21, 97, 89, 93, 86, 86, 64, 11, 88, 83, 70}, I1I.IL1Iii.IL1Iii(new byte[]{90, 9, 85, 81, 87, 10}, I1I.IL1Iii.IL1Iii(new byte[]{90, 6, 91, 82, 1, 11}, "8691d2"))), UiAutoMain.class.getName(), lIlii.m1189iILLl() + BuildConfig.FLAVOR, lIlii.LiL1(), lIlii.m1172lIII()};
                    } else {
                        strArr = new String[]{I1I.IL1Iii.IL1Iii(new byte[]{0, 19, 69, 102, 19, 23, 14, 0, 80, 74, 16}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 86, 12, 2, 6}, I1I.IL1Iii.IL1Iii(new byte[]{83, 1, 86, 2, 89, 7}, "21578d"))) + strIL1Iii, lIlii.lLIL1(), UiAutoMain.class.getName(), lIlii.m1189iILLl() + BuildConfig.FLAVOR, lIlii.LiL1(), lIlii.m1172lIII()};
                    }
                    ProcessBuilder processBuilder = new ProcessBuilder(strArr);
                    Point pointM1180ILI = lIlii.m1180ILI();
                    Point pointILI1Ll = lIlii.ILI1Ll();
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{33, 45, 116, 98, 50, 54, 35, 53, 125}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 3, 5, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 85, 80, 8, 86}, "33cd8c"))), lIlii.m1172lIII());
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{54, 115, 113}, I1I.IL1Iii.IL1Iii(new byte[]{3, 8, 3, 92, 5, 81}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 80, 87, 3, 2}, "bce200"))), lIlii.LiL1());
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{50, 40, 99, 62, 98}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 0, 81, 1, 87}, I1I.IL1Iii.IL1Iii(new byte[]{82, 6, 0, 86, 6, 4}, "fd1f2e"))), pointM1180ILI.x + BuildConfig.FLAVOR);
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{111, 120, 49, 107, 43}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 5, 87, 83, 82}, I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 86, 85, 3, 2}, "640635"))), pointM1180ILI.y + BuildConfig.FLAVOR);
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{112, 112, 100, 53, 103, 52}, I1I.IL1Iii.IL1Iii(new byte[]{1, 9, 84, 83, 92, 91}, I1I.IL1Iii.IL1Iii(new byte[]{87, 81, 91, 82, 87, 93}, "ba8d3e"))), pointILI1Ll.x + BuildConfig.FLAVOR);
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{119, 45, 55, 104, 102, 122}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 87, 94, 9, 1}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 81, 95, 82, 86}, "0bb9be"))), pointILI1Ll.y + BuildConfig.FLAVOR);
                    synchronized (this.f1057llL1ii) {
                        processStart = processBuilder.start();
                        this.f1049ILl = processStart;
                    }
                    processStart.waitFor();
                    synchronized (this.f1056lIlii) {
                        this.iIi1 = false;
                    }
                } catch (Exception e) {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 104}, I1I.IL1Iii.IL1Iii(new byte[]{10, 86, 5, 87, 82, 11}, I1I.IL1Iii.IL1Iii(new byte[]{7, 94, 0, 86, 4, 11}, "487502"))), I1I.IL1Iii.IL1Iii(new byte[]{20, 88, 4, 69, 64, 11, 65, 84, 23, 66, 14}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 92, 85, 82, 84}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 8, 93, 2, 81}, "5318da"))) + e.toString());
                    synchronized (this.f1056lIlii) {
                        this.iIi1 = false;
                    }
                }
            } catch (Throwable th) {
                synchronized (this.f1056lIlii) {
                    this.iIi1 = false;
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m1050LlLLL(String str) {
        String[] strArr;
        m1049L111();
        try {
            String strIL1Iii = TextUtils.isEmpty(str) ? I1I.IL1Iii.IL1Iii(new byte[]{17, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 87, 82, 94, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 83, 7, 0, 2}, "beea84"))) : str;
            String strIL1Iii2 = (lIlii.m1189iILLl() == 1 || lIlii.m1189iILLl() == 3) ? I1I.IL1Iii.IL1Iii(new byte[]{81, 6}, I1I.IL1Iii.IL1Iii(new byte[]{90, 13, 0, 10, 1, 87}, I1I.IL1Iii.IL1Iii(new byte[]{12, 8, 91, 93, 13, 0}, "418e8f"))) : I1I.IL1Iii.IL1Iii(new byte[]{84, 2}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 82, 5, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 5, 6, 87, 6}, "c14ee1")));
            if (lIlii.m1203l1L()) {
                strArr = new String[]{I1I.IL1Iii.IL1Iii(new byte[]{5, 73, 17, 108, 70, 16, 11, 90, 4, 64, 69}, I1I.IL1Iii.IL1Iii(new byte[]{86, 13, 84, 7, 85, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 13, 4, 80, 90, 10}, "c91d93"))) + strIL1Iii2, I1I.IL1Iii.IL1Iii(new byte[]{78, 107, 88, 87, 84, 87, 27, 1, 89, 89, 68}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 3, 10, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 12, 80, 6, 80}, "269b3b"))), lIlii.lLIL1(), ScriptMain.class.getName(), I1I.IL1Iii.IL1Iii(new byte[]{80}, I1I.IL1Iii.IL1Iii(new byte[]{81, 90, 3, 86, 85, 11}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 4, 85, 83, 83}, "75246a"))), lIlii.m1189iILLl() + BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 8, 7, 86, 86, 81}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 3, 82, 92, 86}, "29409a"))), lIlii.LiL1(), lIlii.m1172lIII(), strIL1Iii};
            } else {
                strArr = new String[]{I1I.IL1Iii.IL1Iii(new byte[]{85, 19, 22, 61, 19, 66, 91, 0, 3, 17, 16}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 95, 3, 5, 7}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 0, 3, 87, 3}, "3c9b14"))) + strIL1Iii2, lIlii.lLIL1(), ScriptMain.class.getName(), I1I.IL1Iii.IL1Iii(new byte[]{7}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 86, 5, 6, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 0, 85, 4, 87}, "32bd7a"))), lIlii.m1189iILLl() + BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 7, 85, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 4, 80, 1, 85, 12}, "03c1e8"))), lIlii.LiL1(), lIlii.m1172lIII(), strIL1Iii};
            }
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            Map<String, String> map = System.getenv();
            if (map != null) {
                String str2 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{125, 116, 109, 46, 44, 123, 99, 113, 96, 59, 58, 105, 112, 100, 122}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 7, 6, 82, 14}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 6, 93, 0, 84}, "61397c"))));
                if (!TextUtils.isEmpty(str2) && processBuilder.environment() != null) {
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{122, 34, 104, 124, 124, 118, 100, 39, 101, 105, 106, 100, 119, 50, 127}, I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 5, 2, 5, 86}, I1I.IL1Iii.IL1Iii(new byte[]{8, 7, 80, 4, 85, 0}, "9cb6eb"))), str2);
                }
                String str3 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{52, 124, 103, 110, 101}, I1I.IL1Iii.IL1Iii(new byte[]{90, 83, 5, 9, 1, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 4, 89, 1, 1}, "9f4a2d"))));
                String str4 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{110, 126, 99, 103, 120}, I1I.IL1Iii.IL1Iii(new byte[]{93, 83, 4, 93, 3, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 4, 83, 11, 85}, "b3168d"))));
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{51, 40, 101, 107, 96}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 81, 6, 15, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 87, 86, 14, 80}, "db1d62"))), str3);
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{48, 123, 49, 110, 43}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 86, 85, 83, 4}, I1I.IL1Iii.IL1Iii(new byte[]{6, 83, 6, 86, 4, 81}, "473243"))), str4);
                }
                String str5 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{118, 112, 100, 98, 109, 98}, I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 15, 81, 7, 86}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 14, 91, 84, 83}, "f668a0"))));
                String str6 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{118, 127, 103, 49, 110, 124}, I1I.IL1Iii.IL1Iii(new byte[]{81, 14, 85, 4, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 81, 80, 83, 2}, "5205b4"))));
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{37, 124, 53, 102, 107, 99}, I1I.IL1Iii.IL1Iii(new byte[]{80, 80, 7, 80, 13, 86}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 88, 94, 11, 91}, "be9829"))), str5);
                    processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{115, 124, 102, 50, 103, 43}, I1I.IL1Iii.IL1Iii(new byte[]{81, 12, 6, 90, 1, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 95, 11, 91, 9, 87}, "3f8c0d"))), str6);
                }
            }
            processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{37, 40, 116, 54, 103, 51, 39, 48, 125}, I1I.IL1Iii.IL1Iii(new byte[]{80, 92, 87, 85, 5, 2}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 82, 82, 4, 0}, "d90b5a"))), lIlii.m1172lIII());
            Process processStart = processBuilder.start();
            this.f1053L11I = processStart;
            processStart.waitFor();
            try {
                ILL ill = this.f1051IiL;
                if (ill != null) {
                    ill.iIlLiL(4);
                }
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 57}, I1I.IL1Iii.IL1Iii(new byte[]{10, 87, 86, 86, 1, 82}, I1I.IL1Iii.IL1Iii(new byte[]{94, 82, 6, 3, 85, 7}, "fdc4c4"))), e.toString());
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final synchronized String m1051lIII() {
        m12();
        this.LlLI1 = true;
        if (this.Lil != null) {
            return null;
        }
        Thread thread = new Thread(new lLi1LL());
        this.Lil = thread;
        thread.start();
        return I1I.IL1Iii.IL1Iii(new byte[]{9}, I1I.IL1Iii.IL1Iii(new byte[]{14, 86, 7, 80, 2, 1}, I1I.IL1Iii.IL1Iii(new byte[]{87, 3, 7, 82, 85, 82}, "aa07d0")));
    }

    public final void llliI() {
        I1I.I1I.p008IL.IiL.IL1Iii(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{73, 23, 11, 18, 81, 86, 92, 23, 68, 13, 75, 18, 87, 10, 16, 13, 94, 75, 122, 9, 13, 1, 86, 70, 125, 0, 5, 16, 80}, I1I.IL1Iii.IL1Iii(new byte[]{13, 85, 86, 83, 11, 10}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 1, 4, 11, 9}, "053381"))));
        this.f3304Ilil.postDelayed(new I1I(), 300L);
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public Bundle obtainData(int i) {
        int height;
        int i2;
        int i3 = 1;
        if (i != 1 || this.f1052Ll1 == null) {
            return null;
        }
        C0004 c0004M852IiL = I1L11L.m850lLi1LL().m852IiL();
        Bitmap bitmap = c0004M852IiL != null ? c0004M852IiL.toBitmap() : null;
        int i4 = 0;
        if (bitmap == null) {
            Point pointM1180ILI = lIlii.m1180ILI();
            i3 = pointM1180ILI.x;
            bitmap = (i3 <= 0 || (i2 = pointM1180ILI.y) <= 0) ? Native.snapShot(0, 0, 0) : Native.snapShot(i3, i2, 0);
        }
        try {
            if (bitmap != null) {
                try {
                    try {
                        int width = bitmap.getWidth();
                        try {
                            height = bitmap.getHeight();
                            try {
                                int rowBytes = bitmap.getRowBytes();
                                try {
                                    ByteBuffer byteBufferI1I = this.f1052Ll1.I1I();
                                    bitmap.copyPixelsToBuffer(byteBufferI1I);
                                    byteBufferI1I.flip();
                                    i3 = rowBytes;
                                    i4 = width;
                                } catch (Exception unused) {
                                    i3 = rowBytes;
                                    i4 = width;
                                    if (bitmap != null && !bitmap.isRecycled()) {
                                    }
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{15, 94, 2, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 84, 92, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 15, 86, 84, 0}, "7a82b1"))), this.f1052Ll1);
                                    bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{67, 81, 81, 77, 88}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 7, 9, 2, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 80, 9, 3, 87}, "a4b914"))), i4);
                                    bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{94, 87, 80, 84, 80, 21}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 92, 2, 93, 2}, I1I.IL1Iii.IL1Iii(new byte[]{0, 94, 84, 87, 4, 0}, "a81fac"))), height);
                                    bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{65, 92, 78, 74, 23, 66, 90, 87, 92}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 10, 0, 82, 85}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 3, 95, 85, 1}, "ff0fdd"))), i3);
                                    return bundle;
                                }
                            } catch (Exception unused2) {
                                i4 = width;
                                i3 = 0;
                            }
                        } catch (Exception unused3) {
                            i4 = width;
                            i3 = 0;
                            height = 0;
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{15, 94, 2, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 84, 92, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 15, 86, 84, 0}, "7a82b1"))), this.f1052Ll1);
                            bundle2.putInt(I1I.IL1Iii.IL1Iii(new byte[]{67, 81, 81, 77, 88}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 7, 9, 2, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 80, 9, 3, 87}, "a4b914"))), i4);
                            bundle2.putInt(I1I.IL1Iii.IL1Iii(new byte[]{94, 87, 80, 84, 80, 21}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 92, 2, 93, 2}, I1I.IL1Iii.IL1Iii(new byte[]{0, 94, 84, 87, 4, 0}, "a81fac"))), height);
                            bundle2.putInt(I1I.IL1Iii.IL1Iii(new byte[]{65, 92, 78, 74, 23, 66, 90, 87, 92}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 10, 0, 82, 85}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 3, 95, 85, 1}, "ff0fdd"))), i3);
                            return bundle2;
                        }
                    } catch (Exception unused4) {
                    }
                } catch (Throwable th) {
                    if (bitmap != null) {
                        try {
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } else {
                i3 = 0;
                height = 0;
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (Exception unused6) {
        }
        Bundle bundle3 = new Bundle();
        bundle3.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{15, 94, 2, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 84, 92, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 15, 86, 84, 0}, "7a82b1"))), this.f1052Ll1);
        bundle3.putInt(I1I.IL1Iii.IL1Iii(new byte[]{67, 81, 81, 77, 88}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 7, 9, 2, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 80, 9, 3, 87}, "a4b914"))), i4);
        bundle3.putInt(I1I.IL1Iii.IL1Iii(new byte[]{94, 87, 80, 84, 80, 21}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 92, 2, 93, 2}, I1I.IL1Iii.IL1Iii(new byte[]{0, 94, 84, 87, 4, 0}, "a81fac"))), height);
        bundle3.putInt(I1I.IL1Iii.IL1Iii(new byte[]{65, 92, 78, 74, 23, 66, 90, 87, 92}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 10, 0, 82, 85}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 3, 95, 85, 1}, "ff0fdd"))), i3);
        return bundle3;
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

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new IL1Iii()).start();
        Looper.prepare();
        this.f3304Ilil = new Handler();
        try {
            I11L();
        } catch (Exception unused) {
        }
        Looper.loop();
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws Throwable {
        if (i == 1) {
            lIlii.m24L();
            return null;
        }
        if (i == 2) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 111}, I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 85, 9, 80, 5}, I1I.IL1Iii.IL1Iii(new byte[]{4, 9, 80, 91, 0, 0}, "605ba6"))), I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 3, 85, 88, 96, 87, 75, 78}, I1I.IL1Iii.IL1Iii(new byte[]{1, 8, 87, 82, 82, 5}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 7, 82, 86, 81}, "27667b"))) + i2 + I1I.IL1Iii.IL1Iii(new byte[]{30}, I1I.IL1Iii.IL1Iii(new byte[]{6, 93, 11, 2, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{1, 9, 81, 1, 85, 0}, "50b572"))) + this.f1054iILLL1 + I1I.IL1Iii.IL1Iii(new byte[]{30}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 87, 85, 1, 1}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 7, 0, 7, 2}, "5ec772"))));
            if (i2 == this.f1054iILLL1) {
                return I1I.IL1Iii.IL1Iii(new byte[]{9, 95}, I1I.IL1Iii.IL1Iii(new byte[]{95, 12, 9, 1, 87, 92}, I1I.IL1Iii.IL1Iii(new byte[]{14, 8, 8, 85, 7, 94}, "701a5f")));
            }
            lIlii.m24L();
            return null;
        }
        if (i == 3) {
            m1052lL();
            new Thread(new iILLL1(str)).start();
            return I1I.IL1Iii.IL1Iii(new byte[]{12, 92}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 85, 86, 92, 3}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 15, 86, 94, 86}, "0a95fa")));
        }
        if (i == 13) {
            m1052lL();
            new Thread(new IiL(this)).start();
            return I1I.IL1Iii.IL1Iii(new byte[]{86, 88}, I1I.IL1Iii.IL1Iii(new byte[]{95, 3, 9, 4, 7, 82}, I1I.IL1Iii.IL1Iii(new byte[]{94, 4, 94, 6, 1, 3}, "84f412")));
        }
        if (i == 4) {
            m1049L111();
            return null;
        }
        if (i == 6) {
            return null;
        }
        String string = BuildConfig.FLAVOR;
        if (i != 11) {
            if (i != 10) {
                if (i == 21) {
                    return m1051lIII();
                }
                if (i != 22) {
                    return null;
                }
                m1054LLlI1();
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
            if (i2 != 5) {
                if (i2 == 9) {
                    return lIlii.m1115IL11L(str);
                }
                return null;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(BuildConfig.FLAVOR);
            sb3.append(lIlii.m1126IiILI(i3 == 1));
            return sb3.toString();
        }
        if (i2 == 7) {
            return lIlii.iIi1(str, 0L, i3 == 1);
        }
        if (i2 == 11) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string2 = jSONObject.has(I1I.IL1Iii.IL1Iii(new byte[]{66, 90, 83}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 80, 1, 87, 95}, I1I.IL1Iii.IL1Iii(new byte[]{92, 5, 83, 2, 5, 87}, "8a76a1")))) ? jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{21, 90, 5}, I1I.IL1Iii.IL1Iii(new byte[]{82, 8, 1, 95, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{82, 95, 86, 82, 87, 84}, "ef5432")))) : BuildConfig.FLAVOR;
                if (jSONObject.has(I1I.IL1Iii.IL1Iii(new byte[]{91, 9, 18}, I1I.IL1Iii.IL1Iii(new byte[]{9, 7, 4, 95, 85, 93}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 83, 1, 85, 9}, "0668e0"))))) {
                    string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{68, 95, 5}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 1, 80, 91, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 4, 1, 84, 86, 4}, "67b64f"))));
                }
                if (i3 != 1) {
                    return I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{1, 11, 13, 86, 5, 6}, I1I.IL1Iii.IL1Iii(new byte[]{2, 88, 93, 7, 80, 14}, "6aebd9")));
                }
                if (string.length() > 0) {
                    lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{81, 9, 23, 16, 77, 7, 66, 16, 23, 78, 87, 70}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 5, 85, 15, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 85, 1, 7, 85, 0}, "da31c6"))) + string2 + I1I.IL1Iii.IL1Iii(new byte[]{74}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 90, 0, 4, 1}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 91, 2, 87, 82}, "b39dec"))) + string, 5000L, true);
                } else {
                    lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{18, 89, 90, 10, 95, 7, 75, 20, 24, 20, 20}, I1I.IL1Iii.IL1Iii(new byte[]{86, 81, 83, 7, 13, 1}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 82, 84, 93, 91}, "6d47d8"))) + string2 + I1I.IL1Iii.IL1Iii(new byte[]{22, 30, 90, 20, 0, 94, 82, 65, 86, 93, 5, 30, 95, 93, 77, 81, 15, 68, 24, 80, 88, 64, 4, 87, 89, 65, 64, 26, 45, 113, 99, 125, 122, 124, 36, 98, 22, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 90, 6, 82, 8}, I1I.IL1Iii.IL1Iii(new byte[]{85, 13, 7, 1, 4, 8}, "b9d370"))), 5000L, true);
                }
                return I1I.IL1Iii.IL1Iii(new byte[]{80}, I1I.IL1Iii.IL1Iii(new byte[]{4, 13, 91, 6, 86, 86}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 1, 84, 1, 1}, "4f8dec")));
            } catch (Exception unused) {
                return null;
            }
        }
        if (i2 == 12) {
            lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{82, 93, 16, 80, 87, 67, 80, 85, 29, 69, 76, 94, 67, 16}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 5, 7, 11, 82}, I1I.IL1Iii.IL1Iii(new byte[]{2, 2, 13, 0, 7, 91}, "438148"))) + str, 5000L, false);
            return I1I.IL1Iii.IL1Iii(new byte[]{82}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 6, 8, 11, 7}, I1I.IL1Iii.IL1Iii(new byte[]{92, 2, 92, 84, 94, 7}, "869dfa")));
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
            return lIlii.llI();
        }
        if (i2 == 19) {
            if (i3 == 1) {
                I1I.I1I.ILil.I1I.ILil(str);
            } else {
                I1I.I1I.ILil.I1I.IL1Iii(str);
            }
            return I1I.IL1Iii.IL1Iii(new byte[]{5}, I1I.IL1Iii.IL1Iii(new byte[]{3, 80, 81, 87, 87, 84}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 11, 86, 4, 3}, "229ef3")));
        }
        if (i2 != 39) {
            return null;
        }
        try {
            return lIlii.m1119IiLi(i3 == 1) ? I1I.IL1Iii.IL1Iii(new byte[]{7}, I1I.IL1Iii.IL1Iii(new byte[]{6, 10, 83, 4, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 94, 82, 86, 8, 86}, "bf4a9a"))) : I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{13, 0, 7, 85, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{93, 84, 2, 4, 86, 7}, "d52534")));
        } catch (Exception unused2) {
            return I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{93, 84, 0, 83, 83, 87}, I1I.IL1Iii.IL1Iii(new byte[]{12, 5, 86, 3, 82, 86}, "4cf440")));
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final synchronized void m1052lL() {
        if (!this.f1055lIiI) {
            this.f1055lIiI = true;
            lIlii.L1ii1(null);
        }
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final boolean m1053l(IBinder iBinder, String str) {
        I1I.I1I.ILil.IiL iiLIL1Iii;
        String str2 = this.f1058lLi1LL + I1I.IL1Iii.IL1Iii(new byte[]{79, 117, 94, 22, 6, 99, 19, 89, 71, 13, 7, 86, 19}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 8, 6, 82, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 93, 7, 87, 88}, "c1def9")));
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 110}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 87, 7, 7, 0}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 6, 5, 1, 1}, "27eae6"))), I1I.IL1Iii.IL1Iii(new byte[]{95, 85, 9, 86, 12}, I1I.IL1Iii.IL1Iii(new byte[]{2, 13, 82, 3, 87, 10}, I1I.IL1Iii.IL1Iii(new byte[]{2, 11, 2, 0, 5, 13}, "1240d5"))) + str2);
        try {
            iiLIL1Iii = C0001i1.Ilil().IL1Iii().IL1Iii(str2, iBinder);
            try {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{45, 110}, I1I.IL1Iii.IL1Iii(new byte[]{91, 82, 84, 0, 3, 13}, I1I.IL1Iii.IL1Iii(new byte[]{90, 7, 2, 3, 1, 12}, "bcc224"))), I1I.IL1Iii.IL1Iii(new byte[]{18, 74, 14, 18, 80, 87, 7, 74, 91}, I1I.IL1Iii.IL1Iii(new byte[]{82, 90, 83, 86, 93, 6}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 10, 3, 85, 80}, "56811e"))) + iiLIL1Iii);
                if (iiLIL1Iii == null) {
                    I1I.I1I.p008IL.IiL.IL1Iii(this.f1050IL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{73, 64, 95, 78, 89, 6, 92, 64, 16, 81, 67, 66, 87, 71, 92, 84, 16, 71, 74, 18, 21, 92}, I1I.IL1Iii.IL1Iii(new byte[]{92, 10, 82, 93, 5, 1}, I1I.IL1Iii.IL1Iii(new byte[]{93, 12, 86, 6, 0, 5}, "844c5f"))), str2, 0));
                    C0603ill c0603illM955lLi1LL = C0001i1.Ilil().m955lLi1LL();
                    if (c0603illM955lLi1LL != null && c0603illM955lLi1LL.IL1Iii(this.f1058lLi1LL, 0, 0) == null) {
                        lIlii.m24L();
                    }
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th) {
                            I1I.I1I.p008IL.IiL.I1I(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{66, 87, 84, 90, 23, 6, 115, 93, 87, 65, 4, 13, 68, 98, 75, 90, 23, 10, 84, 87, 75, 112, 25, 23, 85, 64, 87, 84, 13}, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 10, 3, 0, 1}, I1I.IL1Iii.IL1Iii(new byte[]{83, 7, 87, 5, 87, 80}, "06d362"))) + th.toString());
                        }
                    }
                    return false;
                }
                I1I.I1I.p008IL.IiL.IL1Iii(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{65, 70, 12, 64, 94, 87, 84, 70, 67, 95, 68, 19}, I1I.IL1Iii.IL1Iii(new byte[]{8, 0, 83, 1, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{8, 80, 7, 15, 5, 1}, "1d7861"))) + iiLIL1Iii);
                Bundle bundle = new Bundle();
                bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 93, 77, 90, 75, 29, 1, 95, 17, 81, 29, 68, 16, 81, 19, 68, 86, 65, 17, 30, 10, 90, 71, 86, 12, 68, 77, 81, 75, 71, 16, 81, 77, 118, 122, 125, 38, 117, 49}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 8, 6, 86, 10}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 15, 81, 3, 91}, "d474ab"))), new BinderContainer(iBinder));
                bundle.putString(I1I.IL1Iii.IL1Iii(new byte[]{86, 87, 8, 31, 94, 26, 27, 91, 10, 67, 85, 76, 65, 87, 14, 84, 94}, I1I.IL1Iii.IL1Iii(new byte[]{5, 10, 81, 7, 86, 87}, I1I.IL1Iii.IL1Iii(new byte[]{3, 2, 80, 82, 85, 1}, "30dd34"))), str);
                Bundle bundleM893IiL = iiLIL1Iii.m893IiL(str2, I1I.IL1Iii.IL1Iii(new byte[]{71, 1, 92, 81, 97, 64, 81, 22, 97, 80, 70, 69, 93, 7, 87}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 7, 7, 4, 81}, I1I.IL1Iii.IL1Iii(new byte[]{93, 86, 83, 4, 6, 3}, "85f66a"))), null, bundle);
                I1I.I1I.p008IL.IiL.IL1Iii(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{74, 83, 20, 91, 76, 17, 81, 69, 68}, I1I.IL1Iii.IL1Iii(new byte[]{9, 82, 86, 7, 83, 80}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 80, 1, 4, 2}, "b4b1bc"))) + bundleM893IiL);
                if (bundleM893IiL == null) {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th2) {
                            I1I.I1I.p008IL.IiL.I1I(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{17, 93, 88, 9, 64, 1, 32, 87, 91, 18, 83, 10, 23, 104, 71, 9, 64, 13, 7, 93, 71, 35, 78, 16, 6, 74, 91, 7, 90}, I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 1, 7, 3, 86}, I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 2, 87, 83, 3}, "f766f1"))) + th2.toString());
                        }
                    }
                    return false;
                }
                this.f1051IiL = new ILL(null, bundleM893IiL, new IL());
                if (iiLIL1Iii != null) {
                    try {
                        C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                    } catch (Throwable th3) {
                        I1I.I1I.p008IL.IiL.I1I(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{66, 93, 92, 12, 70, 4, 115, 87, 95, 23, 85, 15, 68, 104, 67, 12, 70, 8, 84, 93, 67, 38, 72, 21, 85, 74, 95, 2, 92}, I1I.IL1Iii.IL1Iii(new byte[]{9, 10, 6, 80, 83, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 5, 7, 82, 84}, "8b241f"))) + th3.toString());
                    }
                }
                return true;
            } catch (Throwable unused) {
                try {
                    I1I.I1I.p008IL.IiL.IL1Iii(this.f1050IL, String.format(I1I.IL1Iii.IL1Iii(new byte[]{3, 88, 80, 13, 84, 80, 69, 74, 92, 15, 85, 20, 7, 80, 87, 5, 84, 70, 69, 77, 86, 65, 20, 71, 69, 80, 87, 65, 68, 71, 0, 75, 25, 68, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 10, 1, 84, 83, 1}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 0, 13, 0, 86}, "bd88bc"))), str2, 0));
                    if (iiLIL1Iii != null) {
                        try {
                        } catch (Throwable th4) {
                            String str3 = this.f1050IL;
                            StringBuilder sb = new StringBuilder();
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{71, 93, 84, 94, 20, 84, 118, 87, 87, 69, 7, 95, 65, 104, 75, 94, 20, 88, 81, 93, 75, 116, 26, 69, 80, 74, 87, 80, 14}, I1I.IL1Iii.IL1Iii(new byte[]{80, 10, 9, 83, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{84, 83, 85, 3, 84, 1}, "1aeabb")));
                        }
                    }
                    return false;
                } finally {
                    if (iiLIL1Iii != null) {
                        try {
                            C0001i1.Ilil().IL1Iii().Ilil(str2, null);
                        } catch (Throwable th5) {
                            I1I.I1I.p008IL.IiL.I1I(this.f1050IL, I1I.IL1Iii.IL1Iii(new byte[]{71, 0, 14, 14, 69, 86, 118, 10, 13, 21, 86, 93, 65, 53, 17, 14, 69, 90, 81, 0, 17, 36, 75, 71, 80, 23, 13, 0, 95}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 87, 89, 87, 11}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 12, 11, 93, 14}, "de8396"))) + th5.toString());
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            iiLIL1Iii = null;
        }
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m12() {
        this.LlLI1 = false;
        try {
            synchronized (this.f1057llL1ii) {
                Process process = this.f1049ILl;
                if (process != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        process.destroyForcibly();
                    } else {
                        process.destroy();
                    }
                    this.f1049ILl = null;
                }
            }
        } catch (Exception unused) {
        }
        try {
            Thread thread = this.Lil;
            if (thread != null && thread.isAlive()) {
                this.Lil.interrupt();
            }
        } catch (Exception unused2) {
        }
        try {
            synchronized (this.f1057llL1ii) {
                Process process2 = this.f1049ILl;
                if (process2 != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        process2.destroyForcibly();
                    } else {
                        process2.destroy();
                    }
                }
            }
        } catch (Exception unused3) {
        }
        this.Lil = null;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final synchronized void m1054LLlI1() {
        m12();
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m10551(String str) {
        this.f1058lLi1LL = str;
        new Thread(this).start();
    }
}
