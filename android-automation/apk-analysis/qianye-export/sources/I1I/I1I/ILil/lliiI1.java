package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import I1I.I1I.p008IL.lIlii;
import android.app.INXCoreNative;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.main.app.Native;
import com.qyzs.smn2.R;
import java.io.File;

/* JADX INFO: renamed from: I1I.I1I.ILil.l丨liiI1, reason: invalid class name */
/* JADX INFO: compiled from: RootEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class lliiI1 extends lIlii implements C1 {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1042lLi1LL;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f1040IL = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Object f3290Ilil = new Object();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public I1I f1041iILLL1 = new I1I(this, null);

    /* JADX INFO: renamed from: I1I.I1I.ILil.l丨liiI1$I1I */
    /* JADX INFO: compiled from: RootEngine.java */
    public class I1I extends LL1IL.IL1Iii {
        public I1I(lliiI1 lliii1) {
        }

        @Override // I1I.I1I.ILil.LL1IL
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo917L11I(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            if (i == 0) {
                if (i2 == 115 && i3 == 1) {
                    p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(105, I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 88, 82, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 15, 90, 13, 87}, "fe6995"))), BuildConfig.FLAVOR));
                } else if (i2 == 114 && i3 == 1) {
                    p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(105, I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 84, 92, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 3, 90, 3, 87}, "706b5a"))), BuildConfig.FLAVOR));
                }
            }
        }

        public /* synthetic */ I1I(lliiI1 lliii1, IL1Iii iL1Iii) {
            this(lliii1);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.l丨liiI1$IL1Iii */
    /* JADX INFO: compiled from: RootEngine.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ LlLLL f3291I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Context f3292ILil;

        /* JADX INFO: renamed from: I1I.I1I.ILil.l丨liiI1$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RootEngine.java */
        public class C0528IL1Iii implements LlLLL {
            public C0528IL1Iii() {
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void IL1Iii() {
                lliiI1.this.f1042lLi1LL = false;
                LlLLL llLLL = IL1Iii.this.f3291I1I;
                if (llLLL != null) {
                    llLLL.IL1Iii();
                }
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void ILil() {
                lliiI1.this.f1042lLi1LL = true;
                LlLLL llLLL = IL1Iii.this.f3291I1I;
                if (llLLL != null) {
                    llLLL.ILil();
                }
            }
        }

        public IL1Iii(Context context, LlLLL llLLL) {
            this.f3292ILil = context;
            this.f3291I1I = llLLL;
        }

        @Override // java.lang.Runnable
        public void run() {
            lliiI1.this.m1039llL1ii(this.f3292ILil, new C0528IL1Iii());
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.l丨liiI1$ILil */
    /* JADX INFO: compiled from: RootEngine.java */
    public class ILil implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Context f3294IL1Iii;

        /* JADX INFO: renamed from: I1I.I1I.ILil.l丨liiI1$ILil$IL1Iii */
        /* JADX INFO: compiled from: RootEngine.java */
        public class IL1Iii implements LlLLL {
            public IL1Iii(ILil iLil) {
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void IL1Iii() {
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void ILil() {
            }
        }

        public ILil(Context context) {
            this.f3294IL1Iii = context;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            lliiI1.this.f1042lLi1LL = false;
            lliiI1.this.ILL(this.f3294IL1Iii, new IL1Iii(this));
        }
    }

    @Override // I1I.I1I.ILil.C1
    public void ILL(Context context, LlLLL llLLL) {
        new Thread(new IL1Iii(context, llLLL)).start();
    }

    @Override // I1I.I1I.ILil.C1
    public String Ilil(int i, int i2, int i3, String str) {
        try {
            ILL ill = this.f1040IL;
            if (ill == null) {
                return null;
            }
            return ill.I11L(i, i2, i3, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.C1
    /* JADX INFO: renamed from: I丨L */
    public void mo848IL(Context context, Bundle bundle) {
        synchronized (this.f3290Ilil) {
            try {
                ILL ill = this.f1040IL;
                if (ill != null) {
                    ill.I1I();
                }
            } catch (Exception unused) {
            }
            ILL ill2 = new ILL(this, bundle, new ILil(context));
            this.f1040IL = ill2;
            ill2.m865LlLLL(0, this.f1041iILLL1);
        }
    }

    public final boolean Lil(Context context) {
        try {
            synchronized (this.f3290Ilil) {
                ILL ill = this.f1040IL;
                if (ill == null) {
                    return false;
                }
                String strI11li1 = ill.I11li1(2, lIlii.m21li(context));
                return strI11li1 != null && strI11li1.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{12, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 93, 3, 80, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 14, 7, 85, 14}, "7d7468")))) == 0;
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 58}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 1, 7, 0, 3}, I1I.IL1Iii.IL1Iii(new byte[]{2, 13, 9, 93, 1, 9}, "c998b9"))), I1I.IL1Iii.IL1Iii(new byte[]{94, 92, 14, 94, 83, 71, 17, 92, 14, 94}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 86, 82, 85, 83}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 82, 8, 85, 87}, "d17961"))) + e.toString());
        }
    }

    public final boolean LlLI1() {
        return Native.checkProxy() != 0 || LLL.ILL().Ilil();
    }

    public boolean iIi1() {
        for (String str : System.getenv(I1I.IL1Iii.IL1Iii(new byte[]{102, 121, 49, 112}, I1I.IL1Iii.IL1Iii(new byte[]{15, 10, 80, 91, 87, 90}, I1I.IL1Iii.IL1Iii(new byte[]{15, 80, 5, 87, 1, 0}, "6b044b")))).split(I1I.IL1Iii.IL1Iii(new byte[]{12}, I1I.IL1Iii.IL1Iii(new byte[]{5, 15, 7, 7, 82, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 83, 85, 7, 5}, "54f160"))))) {
            File file = new File(str, I1I.IL1Iii.IL1Iii(new byte[]{16, 17}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 13, 0, 0, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 7, 10, 0, 81}, "163910"))));
            if (file.exists() && file.canExecute()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m1038lIlii() {
        try {
            ILL ill = this.f1040IL;
            return (ill == null || ill.m864L11I() == null || !this.f1040IL.m864L11I().asBinder().isBinderAlive()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final synchronized void m1039llL1ii(Context context, LlLLL llLLL) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        int iRunRootEngine;
        boolean z;
        if (Lil(context)) {
            llLLL.ILil();
            return;
        }
        lIlii.lILi1lLl(context, I1I.IL1Iii.IL1Iii(new byte[]{106, 41, 123, 48, -46, -117, -83, -128, -89, -22, -46, -117, -72, -125, -109, -17, -46, -89, -105, -125, -66, -52, -45, -113, -107, -119, -120, -24, -33, -104, -113, -127, -100, -23, -48, -102, -79}, I1I.IL1Iii.IL1Iii(new byte[]{94, 4, 7, 86, 15, 4}, I1I.IL1Iii.IL1Iii(new byte[]{0, 91, 86, 83, 92, 7}, "f9ead4"))));
        boolean zLlLI1 = LlLI1();
        IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{126, 109}, I1I.IL1Iii.IL1Iii(new byte[]{82, 6, 5, 93, 0, 3}, I1I.IL1Iii.IL1Iii(new byte[]{87, 11, 6, 1, 84, 15}, "583e68"))), I1I.IL1Iii.IL1Iii(new byte[]{5, 88, 3, 91, 92, 103, 20, 95, 30, 65, 10, 9}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 80, 1, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 5, 9, 13, 2}, "033085"))) + zLlLI1);
        if (!zLlLI1) {
            if (iIi1()) {
                IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{127, 59}, I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 1, 8, 85, 95}, I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 0, 2, 0, 87}, "1c32c1"))), I1I.IL1Iii.IL1Iii(new byte[]{74, 76, 89, 69, 65, 17, 75, 87, 87, 67}, I1I.IL1Iii.IL1Iii(new byte[]{10, 1, 93, 7, 1, 5}, I1I.IL1Iii.IL1Iii(new byte[]{2, 91, 4, 5, 4, 1}, "1ba505"))));
                if (!iI1iI.I1I().m958IL()) {
                    lIlii.lILi1lLl(context, I1I.IL1Iii.IL1Iii(new byte[]{51, 126, 119, 101, -42, -113, -12, -41, -85, -65, -37, -125, -30, -42, -84, -103, 96, 102, -124, -107, -119, -39, -121, -106}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 0, 83, 10, 86}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 14, 1, 12, 6}, "566c5c"))));
                    llLLL.IL1Iii();
                    return;
                }
            }
            String strM1165iILiiLl = lIlii.m1165iILiiLl(context);
            if (strM1165iILiiLl != null) {
                String str = String.format(I1I.IL1Iii.IL1Iii(new byte[]{23, 86, 87, 69, 82, 22, 84, 93, 85, 80, 95, 22, 76, 95, 70, 30, 22, 74}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 84, 87, 10, 95}, I1I.IL1Iii.IL1Iii(new byte[]{9, 3, 0, 81, 9, 2}, "02b70d"))), context.getPackageName());
                iI1iI.I1I().ILil(strM1165iILiiLl + I1I.IL1Iii.IL1Iii(new byte[]{70, 29, 28, 95, 11, 69, 18, 81, 93, 90, 69}, I1I.IL1Iii.IL1Iii(new byte[]{80, 8, 80, 2, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{6, 15, 2, 86, 7, 0}, "07cbc2"))) + context.getPackageName(), false);
                try {
                    Thread.sleep(500L);
                } catch (Exception unused) {
                }
                iI1iI.I1I().ILil(str, false);
                String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{-125, -117, -77, -45, -110, -69, -127, -102, -70, -45, -117, -75, 52, 120, 124, 98, -48, -116, -13, -47, -96, -72, -48, -96, -55, -46, -71, -98}, I1I.IL1Iii.IL1Iii(new byte[]{84, 0, 86, 2, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{87, 15, 92, 85, 90, 81}, "e89a9a")));
                for (int i = 0; i < 20; i++) {
                    lIlii.lILi1lLl(context, strIL1Iii);
                    if (LlLI1()) {
                        break;
                    }
                    if (i == 10) {
                        strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{-45, -107, -97, -45, -120, -66, -46, -107, -110, -46, -126, -81, -36, -106, -90, -46, -94, -99, -47, -77, -101, 101, 125, 125, 96, -36, -113, -94, -44, -95, -70, -47, -100, -128, -38, -78, -92, -36, -116, -76, -43, -97, -67, -36, -115, -78}, I1I.IL1Iii.IL1Iii(new byte[]{13, 14, 85, 5, 7, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 84, 80, 7, 6}, "8d2b22")));
                        iI1iI.I1I().ILil(String.format(I1I.IL1Iii.IL1Iii(new byte[]{63, 70, 21, 94, 25, 20, 75, 2, 89, 76, 88, 25, 8, 9, 91, 89, 85, 25, 16, 11, 72, 23, 28, 69, 70, 70, 101, 24, 31, 16, 68, 21, 93, 76, 92, 88, 2, 9, 74, 91, 92, 22, 84, 70, 30, 30, 25, 19, 23}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 15, 92, 8, 14}, I1I.IL1Iii.IL1Iii(new byte[]{7, 12, 82, 80, 80, 8}, "48e4a0"))), context.getPackageName(), str), false);
                    }
                    try {
                        Thread.sleep(500L);
                    } catch (Exception unused2) {
                    }
                }
            }
            if (!LlLI1()) {
                IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{40, 61}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 4, 9, 10, 82}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 84, 84, 13, 5}, "a5ae55"))), I1I.IL1Iii.IL1Iii(new byte[]{70, 17, 4, 65, 77, 20, 69, 23, 10, 75, 64, 20, 83, 4, 12, 95, 92, 80}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 81, 5, 15, 0}, I1I.IL1Iii.IL1Iii(new byte[]{13, 84, 4, 2, 15, 80}, "85049d"))));
                llLLL.IL1Iii();
                lIlii.lILi1lLl(context, I1I.IL1Iii.IL1Iii(new byte[]{54, 119, 42, 101, -36, -118, -15, -34, -10, -65, -36, -90, -53, -35, -17, -103, -47, -128, -31, -34, -14, -121}, I1I.IL1Iii.IL1Iii(new byte[]{87, 92, 1, 84, 15, 4}, I1I.IL1Iii.IL1Iii(new byte[]{10, 1, 92, 7, 15, 2}, "9e8b90"))));
                return;
            }
            IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{124, 97}, I1I.IL1Iii.IL1Iii(new byte[]{81, 14, 0, 1, 7, 92}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 2, 7, 7, 15}, "2cdcc7"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 76, 86, 68, 22, 69, 20, 74, 88, 78, 27, 69, 11, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 91, 14, 80, 90, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 6, 95, 80, 93, 81}, "fef6e0"))));
        }
        IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{121, 108}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 4, 83, 80, 8}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 4, 5, 89, 85}, "f3708d"))), I1I.IL1Iii.IL1Iii(new byte[]{16, 17, 91, 69, 70, 10, 13, 16, 21, 0, 90, 2, 11, 10, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 86, 5, 7, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{14, 5, 9, 87, 87, 81}, "979514"))));
        Point point = new Point();
        lIlii.m1116ILLIi(context, point);
        if (LLL.ILL().Ilil()) {
            b2 = 15;
            b = 12;
            b3 = 11;
            b4 = 10;
            iRunRootEngine = LLL.ILL().m920Ll1(context, lIlii.m21li(context), context.getResources().getInteger(R.integer.vir_width), context.getResources().getInteger(R.integer.vir_height), point.x, point.y);
        } else {
            b = 12;
            b2 = 15;
            b3 = 11;
            b4 = 10;
            iRunRootEngine = Native.runRootEngine(context, lIlii.m21li(context), context.getResources().getInteger(R.integer.vir_width), context.getResources().getInteger(R.integer.vir_height), point.x, point.y);
        }
        String strIL1Iii2 = I1I.IL1Iii.IL1Iii(new byte[]{42, 106}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 2, 91, 80, 3}, I1I.IL1Iii.IL1Iii(new byte[]{81, b2, 7, 94, 0, 1}, "b80fe0")));
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[20];
        bArr[0] = 17;
        bArr[1] = 77;
        bArr[2] = 89;
        bArr[3] = 19;
        bArr[4] = 19;
        bArr[5] = 94;
        bArr[6] = b;
        bArr[7] = 76;
        bArr[8] = 23;
        bArr[9] = 86;
        bArr[b4] = b2;
        bArr[b3] = 86;
        bArr[b] = b4;
        bArr[13] = 86;
        bArr[14] = 82;
        bArr[b2] = 19;
        bArr[16] = 19;
        bArr[17] = 84;
        bArr[18] = 23;
        bArr[19] = 2;
        sb.append(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(new byte[]{0, 93, 6, 5, 82, 82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 87, 83, 0, 91}, "0cfe38"))));
        sb.append(iRunRootEngine);
        IiL.I1I(strIL1Iii2, sb.toString());
        if (iRunRootEngine == 1) {
            int i2 = 0;
            while (true) {
                if (i2 >= 300) {
                    z = false;
                    break;
                }
                byte[] bArr2 = new byte[39];
                bArr2[0] = -34;
                bArr2[1] = -67;
                bArr2[2] = -88;
                bArr2[3] = -125;
                bArr2[4] = -6;
                bArr2[5] = -101;
                bArr2[6] = -45;
                bArr2[7] = -123;
                bArr2[8] = -89;
                bArr2[9] = -125;
                bArr2[b4] = -11;
                bArr2[b3] = -71;
                bArr2[b] = -45;
                bArr2[13] = -123;
                bArr2[14] = -78;
                bArr2[b2] = -128;
                bArr2[16] = -63;
                bArr2[17] = -68;
                bArr2[18] = -45;
                bArr2[19] = -87;
                bArr2[20] = -99;
                bArr2[21] = -128;
                bArr2[22] = -20;
                bArr2[23] = -97;
                bArr2[24] = -46;
                bArr2[25] = -127;
                bArr2[26] = -97;
                bArr2[27] = -118;
                bArr2[28] = -38;
                bArr2[29] = -69;
                bArr2[30] = -34;
                bArr2[31] = -106;
                bArr2[32] = -123;
                bArr2[33] = -126;
                bArr2[34] = -50;
                bArr2[35] = -70;
                bArr2[36] = -47;
                bArr2[37] = -108;
                bArr2[38] = -69;
                lIlii.lILi1lLl(context, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 83, 0, 83, 0}, I1I.IL1Iii.IL1Iii(new byte[]{86, 94, 5, 87, 4, 82}, "afd21e"))));
                if (Lil(context)) {
                    String strIL1Iii3 = I1I.IL1Iii.IL1Iii(new byte[]{42, 60}, I1I.IL1Iii.IL1Iii(new byte[]{86, 92, 84, 5, 0, 83}, I1I.IL1Iii.IL1Iii(new byte[]{80, 8, 86, b, 81, 85}, "b0d924")));
                    byte[] bArr3 = new byte[18];
                    bArr3[0] = 19;
                    bArr3[1] = 20;
                    bArr3[2] = 8;
                    bArr3[3] = 67;
                    bArr3[4] = 75;
                    bArr3[5] = 90;
                    bArr3[6] = 14;
                    bArr3[7] = 21;
                    bArr3[8] = 70;
                    bArr3[9] = 6;
                    bArr3[b4] = 87;
                    bArr3[b3] = 82;
                    bArr3[b] = 8;
                    bArr3[13] = b2;
                    bArr3[14] = 3;
                    bArr3[b2] = 67;
                    bArr3[16] = 86;
                    bArr3[17] = 94;
                    IiL.I1I(strIL1Iii3, I1I.IL1Iii.IL1Iii(bArr3, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 3, 91, 93, 1}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 84, b, 5, 82}, "5d14af"))));
                    z = true;
                    break;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused3) {
                }
                i2++;
            }
            if (z) {
                byte[] bArr4 = new byte[24];
                bArr4[0] = -118;
                bArr4[1] = -73;
                bArr4[2] = -88;
                bArr4[3] = -41;
                bArr4[4] = -1;
                bArr4[5] = -49;
                bArr4[6] = -121;
                bArr4[7] = -113;
                bArr4[8] = -89;
                bArr4[9] = -41;
                bArr4[b4] = -16;
                bArr4[b3] = -19;
                bArr4[b] = -121;
                bArr4[13] = -93;
                bArr4[14] = -99;
                bArr4[b2] = -44;
                bArr4[16] = -23;
                bArr4[17] = -53;
                bArr4[18] = -121;
                bArr4[19] = -99;
                bArr4[20] = -66;
                bArr4[21] = -41;
                bArr4[22] = -21;
                bArr4[23] = -13;
                lIlii.lILi1lLl(context, I1I.IL1Iii.IL1Iii(bArr4, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 81, 82, 1, 90}, I1I.IL1Iii.IL1Iii(new byte[]{9, 3, 5, 90, 1, 8}, "83f9c1"))));
                llLLL.ILil();
                return;
            }
        }
        byte[] bArr5 = new byte[24];
        bArr5[0] = -39;
        bArr5[1] = -78;
        bArr5[2] = -7;
        bArr5[3] = -44;
        bArr5[4] = -85;
        bArr5[5] = -54;
        bArr5[6] = -44;
        bArr5[7] = -118;
        bArr5[8] = -10;
        bArr5[9] = -44;
        bArr5[b4] = -92;
        bArr5[b3] = -24;
        bArr5[b] = -44;
        bArr5[13] = -90;
        bArr5[14] = -52;
        bArr5[b2] = -41;
        bArr5[16] = -67;
        bArr5[17] = -50;
        bArr5[18] = -39;
        bArr5[19] = -128;
        bArr5[20] = -26;
        bArr5[21] = -44;
        bArr5[22] = -96;
        bArr5[23] = -48;
        lIlii.lILi1lLl(context, I1I.IL1Iii.IL1Iii(bArr5, I1I.IL1Iii.IL1Iii(new byte[]{1, b2, 90, 2, 2, 80}, I1I.IL1Iii.IL1Iii(new byte[]{4, 92, b3, 84, 5, 7}, "4e2d01"))));
        String strIL1Iii4 = I1I.IL1Iii.IL1Iii(new byte[]{44, 97}, I1I.IL1Iii.IL1Iii(new byte[]{83, 90, 80, 87, 85, 81}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 2, 81, 4, 2}, "d41d55")));
        byte[] bArr6 = new byte[22];
        bArr6[0] = 66;
        bArr6[1] = 23;
        bArr6[2] = 13;
        bArr6[3] = 69;
        bArr6[4] = 20;
        bArr6[5] = 14;
        bArr6[6] = 95;
        bArr6[7] = 22;
        bArr6[8] = 67;
        bArr6[9] = 0;
        bArr6[b4] = 8;
        bArr6[b3] = 6;
        bArr6[b] = 89;
        bArr6[13] = b;
        bArr6[14] = 6;
        bArr6[b2] = 69;
        bArr6[16] = 0;
        bArr6[17] = 0;
        bArr6[18] = 89;
        bArr6[19] = 14;
        bArr6[20] = 6;
        bArr6[21] = 1;
        IiL.I1I(strIL1Iii4, I1I.IL1Iii.IL1Iii(bArr6, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 80, 7, 81, 2}, I1I.IL1Iii.IL1Iii(new byte[]{b, 82, 4, 0, 5, 80}, "8a7b23"))));
        llLLL.IL1Iii();
    }

    @Override // android.app.INXCoreNative
    public l obtainDataTask() {
        return null;
    }

    @Override // android.app.INXCoreNative
    public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
        ILL ill = this.f1040IL;
        if (ill != null) {
            return ill.m864L11I();
        }
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
        if (i != 4) {
            return null;
        }
        lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-121, -15, -46, -48, -21, -45, -119, -31, -2, -45, -1, -49, -119, -38, -1, -46, -53, -24, -122, -34, -9, -45, -2, -4, -120, -27, -2, -46, -4, -58}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 80, 1, 91, 2}, I1I.IL1Iii.IL1Iii(new byte[]{80, 1, 4, 80, 14, 80}, "3b0d61"))));
        lIlii.m1148iIL(false, 1);
        return null;
    }
}
