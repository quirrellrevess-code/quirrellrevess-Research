package I1I.I1I.p008IL;

import I1I.IL1Iii;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: compiled from: AppUpgradeHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static volatile ILil f1064IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3332IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String f3331ILil = IL1Iii.IL1Iii(new byte[]{115, 71, 22, 96, 73, 81, 64, 86, 2, 80, 105, 68, 87, 81, 21}, IL1Iii.IL1Iii(new byte[]{0, 15, 87, 4, 12, 2}, IL1Iii.IL1Iii(new byte[]{2, 14, 4, 5, 2, 81}, "06547e")));

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final String f3330I1I = IL1Iii.IL1Iii(new byte[]{68, 82, 19, 75, 91, 93, 92, 104, 2, 87, 86, 87}, IL1Iii.IL1Iii(new byte[]{2, 86, 84, 8, 87, 81}, IL1Iii.IL1Iii(new byte[]{3, 0, 1, 0, 82, 5}, "3a407f")));

    public ILil(Context context) {
        this.f3332IL1Iii = context.getApplicationContext();
    }

    public static ILil IL1Iii(Context context) {
        if (f1064IL == null) {
            synchronized (ILil.class) {
                if (f1064IL == null) {
                    f1064IL = new ILil(context);
                }
            }
        }
        return f1064IL;
    }

    public final int I1I() {
        try {
            return this.f3332IL1Iii.getPackageManager().getPackageInfo(this.f3332IL1Iii.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(IL1Iii.IL1Iii(new byte[]{115, 20, 69, 51, 69, 87, 64, 5, 81, 3, 125, 85, 94, 20, 80, 20}, IL1Iii.IL1Iii(new byte[]{7, 85, 5, 83, 86, 8}, IL1Iii.IL1Iii(new byte[]{81, 80, 8, 12, 5, 10}, "da89f2"))), IL1Iii.IL1Iii(new byte[]{116, 85, 11, 95, 7, 1, 18, 64, 13, 19, 5, 0, 70, 20, 20, 86, 16, 22, 91, 91, 12, 19, 1, 10, 86, 81}, IL1Iii.IL1Iii(new byte[]{1, 5, 86, 0, 81, 3}, IL1Iii.IL1Iii(new byte[]{2, 3, 12, 6, 11, 81}, "128587"))), e);
            return -1;
        }
    }

    public final int ILil() {
        return this.f3332IL1Iii.getSharedPreferences(f3331ILil, 0).getInt(f3330I1I, -1);
    }

    public void Ilil() {
        this.f3332IL1Iii.getSharedPreferences(f3331ILil, 0).edit().putInt(f3330I1I, I1I()).apply();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1064IL() {
        if (ILil() != I1I()) {
            Ilil();
            return true;
        }
        Ilil();
        return false;
    }
}
