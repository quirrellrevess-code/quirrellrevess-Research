package I1I.ILil.IL1Iii.IL1Iii;

import android.app.Application;
import android.content.Context;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: compiled from: DeviceIdentifier.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static volatile String f3397I1I = null;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static volatile boolean f3398IL1Iii = false;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static volatile String f3399ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static volatile String f1095IL;

    @Deprecated
    public static String I1I() {
        if (f1095IL == null) {
            synchronized (ILil.class) {
                if (f1095IL == null) {
                    f1095IL = IL1Iii.Lil();
                }
            }
        }
        if (f1095IL == null) {
            f1095IL = BuildConfig.FLAVOR;
        }
        return f1095IL;
    }

    public static String IL1Iii(Context context) {
        if (f3397I1I == null) {
            synchronized (ILil.class) {
                if (f3397I1I == null) {
                    f3397I1I = IL1Iii.m1207IL(context);
                }
            }
        }
        if (f3397I1I == null) {
            f3397I1I = BuildConfig.FLAVOR;
        }
        return f3397I1I;
    }

    public static String ILil(Context context) {
        if (f3399ILil == null) {
            synchronized (ILil.class) {
                if (f3399ILil == null) {
                    f3399ILil = IL1Iii.ILL(context);
                }
            }
        }
        if (f3399ILil == null) {
            f3399ILil = BuildConfig.FLAVOR;
        }
        return f3399ILil;
    }

    public static void Ilil(Application application, lLi1LL lli1ll) {
        m1218lLi1LL(application, false, lli1ll);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1217IL(Application application) {
        Ilil(application, null);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1218lLi1LL(Application application, boolean z, lLi1LL lli1ll) {
        if (f3398IL1Iii || application == null) {
            return;
        }
        synchronized (ILil.class) {
            if (!f3398IL1Iii) {
                IL1Iii.LlLI1(application, z, lli1ll);
                f3398IL1Iii = true;
            }
        }
    }
}
