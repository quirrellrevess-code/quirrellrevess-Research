package I1I.I1I.p008IL.iIi1.ILil;

import I1I.IL1Iii;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: renamed from: I1I.I1I.I丨L.iIi1.ILil.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3359IL1Iii = IL1Iii.IL1Iii(new byte[]{54, 10, 90, 55, 66, 11, 8, 22}, IL1Iii.IL1Iii(new byte[]{6, 6, 4, 91, 15, 82}, IL1Iii.IL1Iii(new byte[]{6, 81, 10, 14, 9, 0}, "d29700")));

    public static boolean I1I() throws Throwable {
        String strM1093iILLL1 = m1093iILLL1(IL1Iii.IL1Iii(new byte[]{70, 12, 77, 90, 19, 88, 88, 7, 77, 92, 15, 66, 68, 15, 2, 65, 72, 88, 80}, IL1Iii.IL1Iii(new byte[]{86, 83, 1, 0, 7, 3}, IL1Iii.IL1Iii(new byte[]{86, 85, 7, 0, 5, 10}, "4ee8d8"))));
        if (TextUtils.isEmpty(strM1093iILLL1)) {
            return false;
        }
        return strM1093iILLL1.contains(IL1Iii.IL1Iii(new byte[]{2, 84, 24, 88, 92}, IL1Iii.IL1Iii(new byte[]{7, 92, 83, 83, 0, 80}, IL1Iii.IL1Iii(new byte[]{1, 84, 84, 3, 8, 87}, "b0fe1b")))) || strM1093iILLL1.toLowerCase().contains(IL1Iii.IL1Iii(new byte[]{86, 84, 79, 85, 6}, IL1Iii.IL1Iii(new byte[]{2, 93, 7, 89, 82, 87}, IL1Iii.IL1Iii(new byte[]{6, 92, 8, 0, 7, 6}, "499a63"))));
    }

    public static boolean IL1Iii() {
        String str = Build.MANUFACTURER;
        return str.contains(IL1Iii.IL1Iii(new byte[]{52, 11, 123, 109}, IL1Iii.IL1Iii(new byte[]{81, 81, 84, 1, 87, 85}, IL1Iii.IL1Iii(new byte[]{1, 85, 7, 11, 4, 88}, "5fc209")))) || str.contains(IL1Iii.IL1Iii(new byte[]{87, 85, 4}, IL1Iii.IL1Iii(new byte[]{80, 84, 86, 13, 82, 91}, IL1Iii.IL1Iii(new byte[]{86, 0, 0, 10, 7, 89}, "b7b33a"))));
    }

    public static boolean ILil() {
        return Build.MANUFACTURER.contains(IL1Iii.IL1Iii(new byte[]{113, 99, 116, 96, 38, 112}, IL1Iii.IL1Iii(new byte[]{9, 0, 86, 14, 90, 92}, IL1Iii.IL1Iii(new byte[]{9, 6, 81, 0, 1, 0}, "90298e"))));
    }

    public static boolean Ilil() {
        String str = Build.MANUFACTURER;
        return str.contains(IL1Iii.IL1Iii(new byte[]{120, 100, 51, 120}, IL1Iii.IL1Iii(new byte[]{85, 6, 80, 0, 0, 2}, IL1Iii.IL1Iii(new byte[]{84, 84, 2, 2, 87, 85}, "6f1561")))) || str.contains(IL1Iii.IL1Iii(new byte[]{14, 19, 21, 92}, IL1Iii.IL1Iii(new byte[]{89, 91, 83, 86, 85, 85}, IL1Iii.IL1Iii(new byte[]{8, 12, 87, 4, 93, 81}, "04aa92"))));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean m1092IL() {
        return !TextUtils.isEmpty(m1093iILLL1(IL1Iii.IL1Iii(new byte[]{68, 86, 25, 92, 15, 65, 95, 23, 66, 88, 72, 66, 83, 75, 68, 88, 9, 90, 24, 87, 86, 92, 3}, IL1Iii.IL1Iii(new byte[]{15, 15, 1, 2, 80, 81}, IL1Iii.IL1Iii(new byte[]{9, 5, 3, 81, 82, 80}, "035bd5")))));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m1093iILLL1(String str) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        ?? r2 = 81;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(IL1Iii.IL1Iii(new byte[]{84, 3, 17, 64, 19, 13, 67, 70}, IL1Iii.IL1Iii(new byte[]{81, 95, 3, 3, 2, 3}, IL1Iii.IL1Iii(new byte[]{7, 15, 87, 7, 87, 0}, "e6144a"))) + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        Log.e(f3359IL1Iii, IL1Iii.IL1Iii(new byte[]{125, 30, 7, 83, 73, 17, 81, 9, 10, 22, 78, 13, 81, 10, 1, 22, 90, 9, 87, 21, 13, 88, 94, 69, 113, 8, 20, 67, 77, 54, 76, 20, 1, 87, 84}, IL1Iii.IL1Iii(new byte[]{12, 7, 85, 6, 8, 7}, IL1Iii.IL1Iii(new byte[]{13, 87, 84, 3, 82, 1}, "96e3cc"))), e);
                    }
                    return line;
                } catch (IOException e2) {
                    e = e2;
                    Log.e(f3359IL1Iii, IL1Iii.IL1Iii(new byte[]{49, 88, 83, 90, 91, 92, 68, 66, 93, 24, 69, 92, 5, 82, 18, 75, 78, 74, 20, 68, 93, 72, 23}, IL1Iii.IL1Iii(new byte[]{81, 3, 3, 14, 0, 90}, IL1Iii.IL1Iii(new byte[]{80, 2, 84, 7, 15, 5}, "e7e18f"))) + str, e);
                    if (bufferedReader == null) {
                        return null;
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (IOException e3) {
                        Log.e(f3359IL1Iii, IL1Iii.IL1Iii(new byte[]{117, 25, 6, 84, 20, 66, 89, 14, 11, 17, 19, 94, 89, 13, 0, 17, 7, 90, 95, 18, 12, 95, 3, 22, 121, 15, 21, 68, 16, 101, 68, 19, 0, 80, 9}, IL1Iii.IL1Iii(new byte[]{82, 81, 0, 3, 82, 84}, IL1Iii.IL1Iii(new byte[]{4, 81, 81, 6, 3, 85}, "fa4457"))), e3);
                        return null;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                if (r2 != 0) {
                    throw th;
                }
                try {
                    r2.close();
                    throw th;
                } catch (IOException e5) {
                    Log.e(f3359IL1Iii, IL1Iii.IL1Iii(new byte[]{115, 79, 0, 86, 73, 18, 95, 88, 13, 19, 78, 14, 95, 91, 6, 19, 90, 10, 89, 68, 10, 93, 94, 70, 127, 89, 19, 70, 77, 53, 66, 69, 6, 82, 84}, IL1Iii.IL1Iii(new byte[]{4, 81, 0, 1, 10, 95}, IL1Iii.IL1Iii(new byte[]{0, 94, 90, 5, 1, 91}, "28972b"))), e5);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (r2 != 0) {
                throw th;
            }
            r2.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static double m1094lLi1LL() throws Throwable {
        try {
            String strM1093iILLL1 = m1093iILLL1(IL1Iii.IL1Iii(new byte[]{66, 95, 22, 91, 66, 8, 92, 84, 22, 79, 82, 19, 67, 89, 87, 87, 25, 4, 93, 69, 81}, IL1Iii.IL1Iii(new byte[]{84, 3, 89, 9, 2, 88}, IL1Iii.IL1Iii(new byte[]{86, 80, 87, 0, 83, 14}, "2c60f7"))));
            return Double.parseDouble(strM1093iILLL1.substring(strM1093iILLL1.indexOf(IL1Iii.IL1Iii(new byte[]{103}, IL1Iii.IL1Iii(new byte[]{10, 84, 80, 80, 9, 6}, IL1Iii.IL1Iii(new byte[]{86, 85, 85, 91, 3, 0}, "d1182e")))) + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }
}
