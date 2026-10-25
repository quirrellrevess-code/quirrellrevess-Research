package ILil.p028IiL.Ilil;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: ActivityCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends ILil.p028IiL.p035lLi1LL.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static I1I f4086I1I;

    /* JADX INFO: compiled from: ActivityCompat.java */
    public interface I1I {
        boolean IL1Iii(Activity activity, int i, int i2, Intent intent);

        boolean ILil(Activity activity, String[] strArr, int i);
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ilil.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityCompat.java */
    public static class RunnableC0566IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Activity f4087I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String[] f4088ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f1635IL;

        public RunnableC0566IL1Iii(String[] strArr, Activity activity, int i) {
            this.f4088ILil = strArr;
            this.f4087I1I = activity;
            this.f1635IL = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f4088ILil.length];
            PackageManager packageManager = this.f4087I1I.getPackageManager();
            String packageName = this.f4087I1I.getPackageName();
            int length = this.f4088ILil.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f4088ILil[i], packageName);
            }
            ((ILil) this.f4087I1I).onRequestPermissionsResult(this.f1635IL, this.f4088ILil, iArr);
        }
    }

    /* JADX INFO: compiled from: ActivityCompat.java */
    public interface ILil {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ilil.IL1Iii$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityCompat.java */
    public interface IL {
        void IL1Iii(int i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void ILL(Activity activity, String[] strArr, int i) {
        I1I i1i = f4086I1I;
        if (i1i == null || !i1i.ILil(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof IL) {
                    ((IL) activity).IL1Iii(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof ILil) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0566IL1Iii(strArr, activity, i));
            }
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static void m2164ILl(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m2165IiL(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static boolean m2166Ll1(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static I1I m2167L11I() {
        return f4086I1I;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static void m2168lIiI(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m2169il(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            if (ILil.p028IiL.Ilil.ILil.m2172L11I(activity)) {
                return;
            }
            activity.recreate();
        }
    }
}
