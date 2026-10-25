package ILil.p028IiL.Ilil;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Field f4089I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Class<?> f4090IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final Field f4091ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Method f4092Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Method f1636IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final Handler f1637iILLL1 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Method f1638lLi1LL;

    /* JADX INFO: compiled from: ActivityRecreator.java */
    public static class I1I implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Object f4093I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Object f4094ILil;

        public I1I(Object obj, Object obj2) {
            this.f4094ILil = obj;
            this.f4093I1I = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = ILil.f1636IL;
                if (method != null) {
                    method.invoke(this.f4094ILil, this.f4093I1I, Boolean.FALSE, "AppCompat recreation");
                } else {
                    ILil.f4092Ilil.invoke(this.f4094ILil, this.f4093I1I, Boolean.FALSE);
                }
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* JADX INFO: compiled from: ActivityRecreator.java */
    public static class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Object f4095I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ IL f4096ILil;

        public IL1Iii(IL il, Object obj) {
            this.f4096ILil = il;
            this.f4095I1I = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4096ILil.f4100ILil = this.f4095I1I;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ilil.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityRecreator.java */
    public static class RunnableC0567ILil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ IL f4097I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Application f4098ILil;

        public RunnableC0567ILil(Application application, IL il) {
            this.f4098ILil = application;
            this.f4097I1I = il;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4098ILil.unregisterActivityLifecycleCallbacks(this.f4097I1I);
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.Ilil.ILil$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityRecreator.java */
    public static final class IL implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public Activity f4099I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Object f4100ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f1639IL = false;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f4101Ilil = false;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f1640lLi1LL = false;

        public IL(Activity activity) {
            this.f4099I1I = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f4099I1I == activity) {
                this.f4099I1I = null;
                this.f4101Ilil = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f4101Ilil || this.f1640lLi1LL || this.f1639IL || !ILil.m2171IiL(this.f4100ILil, activity)) {
                return;
            }
            this.f1640lLi1LL = true;
            this.f4100ILil = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f4099I1I == activity) {
                this.f1639IL = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsIL1Iii = IL1Iii();
        f4090IL1Iii = clsIL1Iii;
        f4091ILil = ILil();
        f4089I1I = m2174lLi1LL();
        f1636IL = m2170IL(clsIL1Iii);
        f4092Ilil = I1I(clsIL1Iii);
        f1638lLi1LL = Ilil(clsIL1Iii);
    }

    public static Method I1I(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> IL1Iii() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field ILil() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method Ilil(Class<?> cls) {
        if (m2173iILLL1() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Method m2170IL(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m2171IiL(Object obj, Activity activity) {
        try {
            Object obj2 = f4089I1I.get(activity);
            if (obj2 != obj) {
                return false;
            }
            f1637iILLL1.postAtFrontOfQueue(new I1I(f4091ILil.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean m2172L11I(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (m2173iILLL1() && f1638lLi1LL == null) {
            return false;
        }
        if (f4092Ilil == null && f1636IL == null) {
            return false;
        }
        try {
            Object obj2 = f4089I1I.get(activity);
            if (obj2 == null || (obj = f4091ILil.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            IL il = new IL(activity);
            application.registerActivityLifecycleCallbacks(il);
            f1637iILLL1.post(new IL1Iii(il, obj2));
            try {
                if (m2173iILLL1()) {
                    Method method = f1638lLi1LL;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f1637iILLL1.post(new RunnableC0567ILil(application, il));
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m2173iILLL1() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Field m2174lLi1LL() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
