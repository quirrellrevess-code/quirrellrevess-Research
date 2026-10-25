package ILil.ILil.p021Ll1;

import ILil.p028IiL.p035lLi1LL.ILil;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: renamed from: ILil.ILil.Ll丨1.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static L11I f1309IL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final IL1Iii f3723I1I = new IL1Iii();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3724IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final LocationManager f3725ILil;

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: TwilightManager.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public long f3726I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f3727IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public long f3728ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public long f3729Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public long f1310IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public long f1311lLi1LL;
    }

    public L11I(Context context, LocationManager locationManager) {
        this.f3724IL1Iii = context;
        this.f3725ILil = locationManager;
    }

    public static L11I IL1Iii(Context context) {
        if (f1309IL == null) {
            Context applicationContext = context.getApplicationContext();
            f1309IL = new L11I(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1309IL;
    }

    public final Location I1I(String str) {
        try {
            if (this.f3725ILil.isProviderEnabled(str)) {
                return this.f3725ILil.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final Location ILil() {
        Location locationI1I = ILil.ILil(this.f3724IL1Iii, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? I1I("network") : null;
        Location locationI1I2 = ILil.ILil(this.f3724IL1Iii, "android.permission.ACCESS_FINE_LOCATION") == 0 ? I1I("gps") : null;
        if (locationI1I2 == null || locationI1I == null) {
            return locationI1I2 != null ? locationI1I2 : locationI1I;
        }
        return locationI1I2.getTime() > locationI1I.getTime() ? locationI1I2 : locationI1I;
    }

    public final boolean Ilil() {
        return this.f3723I1I.f1311lLi1LL > System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1655IL() {
        IL1Iii iL1Iii = this.f3723I1I;
        if (Ilil()) {
            return iL1Iii.f3727IL1Iii;
        }
        Location locationILil = ILil();
        if (locationILil != null) {
            m1656lLi1LL(locationILil);
            return iL1Iii.f3727IL1Iii;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1656lLi1LL(Location location) {
        long j;
        long j2;
        IL1Iii iL1Iii = this.f3723I1I;
        long jCurrentTimeMillis = System.currentTimeMillis();
        IiL iiLILil = IiL.ILil();
        iiLILil.IL1Iii(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = iiLILil.f3721IL1Iii;
        iiLILil.IL1Iii(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = iiLILil.f3720I1I == 1;
        long j4 = iiLILil.f3722ILil;
        long j5 = iiLILil.f3721IL1Iii;
        boolean z2 = z;
        iiLILil.IL1Iii(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = iiLILil.f3722ILil;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j5) {
                j2 = 0 + j6;
            } else {
                j2 = jCurrentTimeMillis > j4 ? 0 + j5 : 0 + j4;
            }
            j = j2 + 60000;
        }
        iL1Iii.f3727IL1Iii = z2;
        iL1Iii.f3728ILil = j3;
        iL1Iii.f3726I1I = j4;
        iL1Iii.f1310IL = j5;
        iL1Iii.f3729Ilil = j6;
        iL1Iii.f1311lLi1LL = j;
    }
}
