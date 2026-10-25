package I1I.ILil.IL1Iii.IL1Iii;

import I1I.ILil.IL1Iii.IL1Iii.p009il.Ll1;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

/* JADX INFO: compiled from: DeviceID.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public String f3390I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Application f3391IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f3392ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1094IL;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DeviceID.java */
    public static class C0533IL1Iii implements I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ lLi1LL f3393I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Application f3394IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ boolean f3395ILil;

        public C0533IL1Iii(Application application, boolean z, lLi1LL lli1ll) {
            this.f3394IL1Iii = application;
            this.f3395ILil = z;
            this.f3393I1I = lli1ll;
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.I1I
        public void IL1Iii(String str) {
            if (TextUtils.isEmpty(str)) {
                ILil(new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{41, 119, 124, 117, 22, 80, 21, 22, 80, 92, 70, 77, 31}, I1I.IL1Iii.IL1Iii(new byte[]{95, 87, 0, 85, 2, 91}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 5, 81, 6, 80}, "9c0522")))));
                return;
            }
            IL1Iii iL1Iii = ILil.f3396IL1Iii;
            iL1Iii.f3390I1I = str;
            iL1Iii.f1094IL = str;
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{34, 8, 88, 82, 13, 66, 65, 13, 85, 23, 10, 69, 65, 43, 112, 126, 39, 25, 32, 37, 120, 115, 89, 22}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 84, 7, 5, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 4, 1, 4, 4}, "a0a1bb"))) + str);
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.I1I
        public void ILil(Exception exc) {
            IL1Iii.m1216il(exc, this.f3394IL1Iii, this.f3395ILil, this.f3393I1I);
        }
    }

    /* JADX INFO: compiled from: DeviceID.java */
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final IL1Iii f3396IL1Iii = new IL1Iii(null);
    }

    public /* synthetic */ IL1Iii(C0533IL1Iii c0533IL1Iii) {
        this();
    }

    public static String ILL(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{123, 43, 117, 40, 30, 117, 119, 47, 116, 65, 95, 87, 70, 70, 81, 13, 93, 87, 69, 3, 84, 65, 94, 86, 18, 39, 94, 5, 67, 87, 91, 2, 16, 80, 1, 19}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 8, 86, 87, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 11, 2, 87, 81}, "4b351a"))));
            return BuildConfig.FLAVOR;
        }
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        if (i < 23 || context.checkSelfPermission(I1I.IL1Iii.IL1Iii(new byte[]{89, 90, 7, 65, 94, 88, 92, 26, 19, 86, 67, 92, 81, 71, 16, 90, 94, 95, 22, 102, 38, 114, 117, 110, 104, 124, 44, 125, 116, 110, 107, 96, 34, 103, 116}, I1I.IL1Iii.IL1Iii(new byte[]{90, 86, 91, 2, 2, 8}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 89, 3, 11, 90}, "f4a28c")))) == 0) {
            return m1211iILLL1(context);
        }
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{88, 88, 2, 68, 12, 91, 93, 24, 22, 83, 17, 95, 80, 69, 21, 95, 12, 92, 23, 100, 35, 119, 39, 109, 105, 126, 41, 120, 38, 109, 106, 98, 39, 98, 38, 18, 87, 89, 18, 22, 4, 64, 88, 88, 18, 83, 7}, I1I.IL1Iii.IL1Iii(new byte[]{90, 4, 82, 80, 6, 10}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 80, 95, 83, 89}, "aad96a"))));
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static String m1206ILl(Context context) {
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        String string = Settings.System.getString(context.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{38, 98, 42, 115, 102, 16, 20, 94, 7}, I1I.IL1Iii.IL1Iii(new byte[]{88, 7, 81, 82, 88, 83}, I1I.IL1Iii.IL1Iii(new byte[]{95, 3, 86, 81, 85, 87}, "f3d44a"))));
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{113, 7, 64, 65, 69, 67, 95, 6, 20, 7, 66, 89, 91, 66, 71, 24, 67, 66, 83, 15, 20, 18, 85, 66, 66, 11, 90, 6, 67, 12, 22}, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 1, 85, 85, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 88, 2, 6, 85, 3}, "197202"))) + string);
        return string;
    }

    public static String Ilil(Context context) {
        String strM1206ILl = m1206ILl(context);
        if (TextUtils.isEmpty(strM1206ILl)) {
            strM1206ILl = m1209Ll1(context);
        }
        if (TextUtils.isEmpty(strM1206ILl)) {
            strM1206ILl = m1212lIiI(context);
        }
        if (!TextUtils.isEmpty(strM1206ILl)) {
            return strM1206ILl;
        }
        String string = UUID.randomUUID().toString();
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{115, 80, 87, 1, 74, 5, 64, 80, 25, 17, 77, 13, 80, 21, 91, 29, 24, 22, 85, 91, 93, 11, 85, 94, 20}, I1I.IL1Iii.IL1Iii(new byte[]{1, 5, 8, 82, 1, 2}, I1I.IL1Iii.IL1Iii(new byte[]{83, 5, 1, 2, 13, 83}, "f50445"))) + string);
        m1213lIlii(context, string);
        iIi1(context, string);
        m1214llL1ii(context, string);
        return string;
    }

    @SuppressLint({"HardwareIds"})
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static String m1207IL(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 6, 67, 87, 94, 5, 102, 11, 85}, I1I.IL1Iii.IL1Iii(new byte[]{88, 88, 83, 2, 11, 7}, I1I.IL1Iii.IL1Iii(new byte[]{92, 4, 82, 11, 7, 1}, "eec841"))))) == null || I1I.IL1Iii.IL1Iii(new byte[]{88, 7, 5, 3, 83, 81, 87, 84, 4, 15, 5, 1, 84, 4, 11, 84}, I1I.IL1Iii.IL1Iii(new byte[]{88, 8, 2, 6, 83, 81}, I1I.IL1Iii.IL1Iii(new byte[]{13, 91, 3, 4, 82, 4}, "4c3561"))).equals(string)) ? BuildConfig.FLAVOR : string;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m1208IiL(Context context, I1I i1i) {
        Ll1.IL1Iii(context).ILil(i1i);
    }

    @Deprecated
    public static String Lil() {
        try {
            byte b = 81;
            char c = 2;
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray(I1I.IL1Iii.IL1Iii(new byte[]{81, 93, 71, 90, 91, 82, 96, 86, 88, 66, 77, 82, 124, 92}, I1I.IL1Iii.IL1Iii(new byte[]{13, 15, 83, 85, 93, 14}, I1I.IL1Iii.IL1Iii(new byte[]{92, 81, 6, 80, 3, 9}, "dfd6f0"))));
            if (propertyByteArray == null) {
                return BuildConfig.FLAVOR;
            }
            StringBuilder sb = new StringBuilder();
            int length = propertyByteArray.length;
            int i = 0;
            while (i < length) {
                byte b2 = propertyByteArray[i];
                byte[] bArr = new byte[4];
                bArr[0] = 22;
                bArr[1] = 7;
                bArr[c] = 1;
                bArr[3] = 77;
                byte[] bArr2 = new byte[6];
                bArr2[0] = 7;
                bArr2[1] = 1;
                bArr2[c] = b;
                bArr2[3] = 12;
                bArr2[4] = 6;
                bArr2[5] = 6;
                byte[] bArr3 = new byte[6];
                bArr3[0] = 13;
                bArr3[1] = 0;
                bArr3[c] = 86;
                bArr3[3] = 12;
                bArr3[4] = 6;
                bArr3[5] = 86;
                sb.append(String.format(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "9645ca"))), Byte.valueOf(b2)));
                i++;
                b = 81;
                c = 2;
            }
            return sb.toString();
        } catch (Throwable th) {
            IiL.IL1Iii(th);
            return BuildConfig.FLAVOR;
        }
    }

    public static void LlLI1(Application application, boolean z, lLi1LL lli1ll) {
        if (application == null) {
            if (lli1ll != null) {
                lli1ll.IL1Iii(BuildConfig.FLAVOR, new RuntimeException(I1I.IL1Iii.IL1Iii(new byte[]{5, 20, 64, 84, 92, 91, 5, 16, 89, 87, 91, 24, 13, 23, 16, 86, 64, 84, 8, 8}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 81, 9, 87, 12}, I1I.IL1Iii.IL1Iii(new byte[]{9, 5, 4, 84, 1, 7}, "91eec3")))));
                return;
            }
            return;
        }
        IL1Iii iL1Iii = ILil.f3396IL1Iii;
        iL1Iii.f3391IL1Iii = application;
        iL1Iii.f3392ILil = z;
        String strILL = ILL(application);
        if (TextUtils.isEmpty(strILL)) {
            m1210L11I(application, z, lli1ll);
            return;
        }
        iL1Iii.f3390I1I = strILL;
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{32, 93, 95, 87, 94, 16, 67, 88, 82, 18, 89, 23, 67, 120, 123, 119, 121, 75, 46, 116, 127, 118, 10, 68}, I1I.IL1Iii.IL1Iii(new byte[]{90, 2, 15, 87, 4, 86}, I1I.IL1Iii.IL1Iii(new byte[]{12, 5, 15, 80, 0, 5}, "566547"))) + iL1Iii.f3390I1I);
        if (lli1ll != null) {
            lli1ll.IL1Iii(strILL, null);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static String m1209Ll1(Context context) {
        String line = BuildConfig.FLAVOR;
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        File fileM1215lLi1LL = m1215lLi1LL(context);
        if (fileM1215lLi1LL != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileM1215lLi1LL));
                try {
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Exception e) {
                IiL.IL1Iii(e);
            }
        }
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{33, 3, 77, 17, 20, 23, 15, 2, 25, 87, 19, 13, 11, 70, 92, 73, 21, 7, 20, 8, 88, 93, 65, 17, 18, 9, 75, 80, 6, 7, 92, 70}, I1I.IL1Iii.IL1Iii(new byte[]{0, 94, 12, 80, 89, 6}, I1I.IL1Iii.IL1Iii(new byte[]{84, 90, 12, 5, 92, 1}, "2b9dde"))) + line);
        return line;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static void m1210L11I(Application application, boolean z, lLi1LL lli1ll) {
        m1208IiL(application, new C0533IL1Iii(application, z, lli1ll));
    }

    public static void iIi1(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context)) {
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{4, 89, 0, 19, 92, 88, 1, 25, 20, 4, 65, 92, 12, 68, 23, 8, 92, 95, 75, 96, 54, 40, 103, 116, 58, 100, 33, 53, 103, 120, 43, 112, 55, 65, 93, 94, 17, 23, 3, 19, 82, 95, 17, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 0, 5, 83, 11, 0}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 85, 2, 93, 2}, "7140e3"))));
            return;
        }
        try {
            Settings.System.putString(context.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{119, 102, 126, 33, 59, 70, 69, 90, 83}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 0, 93, 7, 4}, I1I.IL1Iii.IL1Iii(new byte[]{92, 6, 85, 89, 2, 3}, "8bbaa4"))), str);
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{54, 4, 68, 84, 67, 67, 16, 12, 86, 17, 23, 89, 69, 22, 75, 66, 23, 83, 8, 69, 65, 84, 23, 66, 12, 11, 85, 66, 89, 22}, I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 6, 4, 0, 15}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 7, 2, 0, 9}, "a437c0"))) + str);
        } catch (Exception e) {
            IiL.IL1Iii(e);
        }
    }

    public static boolean iIlLiL(Context context) {
        return Ll1.IL1Iii(context).IL1Iii();
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m1211iILLL1(Context context) {
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{70, 92, 13, 93, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 1, 82, 8, 90}, I1I.IL1Iii.IL1Iii(new byte[]{6, 91, 0, 7, 10, 0}, "08cf2c"))));
            String imei = telephonyManager.getImei();
            return TextUtils.isEmpty(imei) ? telephonyManager.getMeid() : imei;
        } catch (Error e) {
            IiL.IL1Iii(e);
            return BuildConfig.FLAVOR;
        } catch (Exception e2) {
            IiL.IL1Iii(e2);
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static String m1212lIiI(Context context) {
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        String string = context.getSharedPreferences(I1I.IL1Iii.IL1Iii(new byte[]{114, 51, 112, 119}, I1I.IL1Iii.IL1Iii(new byte[]{6, 0, 9, 6, 84, 1}, I1I.IL1Iii.IL1Iii(new byte[]{87, 95, 83, 86, 14, 3}, "d9cc92"))), 0).getString(I1I.IL1Iii.IL1Iii(new byte[]{69, 22, 93, 80}, I1I.IL1Iii.IL1Iii(new byte[]{9, 5, 13, 6, 13, 86}, I1I.IL1Iii.IL1Iii(new byte[]{90, 82, 8, 10, 1, 0}, "c4189a"))), BuildConfig.FLAVOR);
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{117, 92, 18, 21, 65, 69, 91, 93, 70, 83, 70, 95, 95, 25, 21, 93, 85, 66, 87, 93, 70, 69, 70, 85, 84, 92, 20, 80, 90, 83, 87, 74, 92, 21}, I1I.IL1Iii.IL1Iii(new byte[]{3, 15, 85, 81, 7, 81}, I1I.IL1Iii.IL1Iii(new byte[]{8, 2, 5, 83, 5, 87}, "946766"))) + string);
        return string;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static void m1213lIlii(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(I1I.IL1Iii.IL1Iii(new byte[]{117, 52, 42, 112}, I1I.IL1Iii.IL1Iii(new byte[]{87, 88, 91, 80, 3, 15}, I1I.IL1Iii.IL1Iii(new byte[]{93, 95, 0, 84, 0, 85}, "8f802b"))), 0).edit().putString(I1I.IL1Iii.IL1Iii(new byte[]{23, 23, 12, 84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 7, 8, 14, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 81, 90, 8, 81}, "163b1e"))), str).apply();
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{106, 83, 69, 85, 23, 69, 76, 91, 87, 16, 67, 95, 25, 65, 91, 81, 69, 85, 93, 18, 67, 66, 82, 86, 92, 64, 86, 94, 84, 85, 74, 8, 19}, I1I.IL1Iii.IL1Iii(new byte[]{8, 80, 3, 8, 2, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 4, 94, 1, 1}, "fb4f45"))) + str);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static void m1214llL1ii(Context context, String str) {
        if (context == null) {
            return;
        }
        File fileM1215lLi1LL = m1215lLi1LL(context);
        if (fileM1215lLi1LL == null) {
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{98, 97, 45, 112, 16, 4, 94, 88, 1, 20, 89, 12, 23, 81, 28, 64, 85, 16, 89, 85, 8, 20, 67, 22, 88, 70, 5, 83, 85, 66, 94, 71, 68, 90, 69, 14, 91}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 82, 82, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 87, 14, 95, 0, 87}, "7d89db"))));
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileM1215lLi1LL));
            try {
                if (!fileM1215lLi1LL.exists()) {
                    fileM1215lLi1LL.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{53, 3, 66, 84, 18, 20, 19, 11, 80, 17, 70, 14, 70, 7, 76, 69, 87, 19, 8, 3, 88, 17, 65, 21, 9, 16, 85, 86, 87, 91, 70}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 3, 87, 11, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 15, 0, 10, 3}, "cf8f32"))) + str);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        bufferedWriter.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        } catch (Exception e) {
            IiL.IL1Iii(e);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static File m1215lLi1LL(Context context) {
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i >= 23 && (i >= 30 || context == null || context.checkSelfPermission(I1I.IL1Iii.IL1Iii(new byte[]{86, 15, 1, 71, 93, 81, 83, 79, 21, 80, 64, 85, 94, 18, 22, 92, 93, 86, 25, 54, 55, 124, 102, 125, 104, 36, 61, 97, 119, 106, 121, 32, 41, 106, 97, 108, 120, 51, 36, 114, 119}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 4, 5, 2, 12}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 82, 86, 2, 82}, "323f2f")))) != 0)) {
            z = false;
        }
        if (z && I1I.IL1Iii.IL1Iii(new byte[]{91, 87, 20, 12, 66, 86, 82}, I1I.IL1Iii.IL1Iii(new byte[]{0, 12, 7, 84, 7, 0}, I1I.IL1Iii.IL1Iii(new byte[]{83, 5, 0, 82, 87, 87}, "e1fdfd"))).equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), I1I.IL1Iii.IL1Iii(new byte[]{114, 88, 85, 68, 92, 93, 87, 25, 31, 113, 102, 125, 119, 105, 68, 67, 90, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 1, 6, 86, 13}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 0, 84, 85, 95}, "420d0f"))));
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m1216il(Exception exc, Application application, boolean z, lLi1LL lli1ll) {
        if (z) {
            String strLil = Lil();
            if (!TextUtils.isEmpty(strLil)) {
                ILil.f3396IL1Iii.f3390I1I = strLil;
                IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{122, 85, 95, 86, 12, 65, 25, 80, 82, 19, 11, 70, 25, 110, 95, 87, 7, 67, 80, 87, 83, 122, 38, 15, 25}, I1I.IL1Iii.IL1Iii(new byte[]{10, 1, 85, 10, 83, 4}, I1I.IL1Iii.IL1Iii(new byte[]{5, 13, 2, 90, 85, 4}, "65acd5"))) + strLil);
                if (lli1ll != null) {
                    lli1ll.IL1Iii(strLil, exc);
                    return;
                }
                return;
            }
        }
        String strM1207IL = m1207IL(application);
        if (!TextUtils.isEmpty(strM1207IL)) {
            ILil.f3396IL1Iii.f3390I1I = strM1207IL;
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{39, 92, 90, 4, 87, 22, 68, 89, 87, 65, 80, 17, 68, 113, 93, 5, 75, 13, 13, 84, 122, 37, 3, 66}, I1I.IL1Iii.IL1Iii(new byte[]{81, 9, 0, 4, 15, 4}, I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 11, 86, 7, 2}, "da831d"))) + strM1207IL);
            if (lli1ll != null) {
                lli1ll.IL1Iii(strM1207IL, exc);
                return;
            }
            return;
        }
        String strIlil = Ilil(application);
        ILil.f3396IL1Iii.f3390I1I = strIlil;
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{118, 89, 8, 87, 88, 21, 21, 92, 5, 18, 95, 18, 21, 114, 52, 123, 114, 91, 21}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 86, 6, 3, 84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 7, 87, 13, 80}, "eb0c8e"))) + strIlil);
        if (lli1ll != null) {
            lli1ll.IL1Iii(strIlil, exc);
        }
    }

    public IL1Iii() {
    }
}
