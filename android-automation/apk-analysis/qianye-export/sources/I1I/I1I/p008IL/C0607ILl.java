package I1I.I1I.p008IL;

import android.content.Context;
import android.preference.PreferenceManager;

/* JADX INFO: renamed from: I1I.I1I.I丨L.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: PreferenceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0607ILl {
    public static String I1I(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static boolean IL1Iii(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static int ILil(Context context, String str, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i);
    }

    public static void Ilil(Context context, String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(str, i).commit();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1065IL(Context context, String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1066lLi1LL(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).commit();
    }
}
