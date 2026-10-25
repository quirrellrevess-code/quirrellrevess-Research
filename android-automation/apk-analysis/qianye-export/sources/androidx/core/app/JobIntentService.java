package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final HashMap<ComponentName, L11I> f2550IiL = new HashMap<>();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public L11I f4948I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ILil f4949ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IL1Iii f2551IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final ArrayList<IL> f2552iILLL1;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4950Ilil = false;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f2553lLi1LL = false;

    public static final class I1I extends L11I {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final PowerManager.WakeLock f4951Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final PowerManager.WakeLock f2554IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f2555iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2556lLi1LL;

        public I1I(Context context, ComponentName componentName) {
            super(componentName);
            context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2554IL = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f4951Ilil = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.L11I
        public void I1I() {
            synchronized (this) {
                if (!this.f2555iILLL1) {
                    this.f2555iILLL1 = true;
                    this.f4951Ilil.acquire(600000L);
                    this.f2554IL.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.L11I
        public void ILil() {
            synchronized (this) {
                if (this.f2555iILLL1) {
                    if (this.f2556lLi1LL) {
                        this.f2554IL.acquire(60000L);
                    }
                    this.f2555iILLL1 = false;
                    this.f4951Ilil.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.L11I
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void mo3160IL() {
            synchronized (this) {
                this.f2556lLi1LL = false;
            }
        }
    }

    public final class IL1Iii extends AsyncTask<Void, Void, Void> {
        public IL1Iii() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.m3158iILLL1();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                lLi1LL lli1llIL1Iii = JobIntentService.this.IL1Iii();
                if (lli1llIL1Iii == null) {
                    return null;
                }
                JobIntentService.this.Ilil(lli1llIL1Iii.getIntent());
                lli1llIL1Iii.IL1Iii();
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.m3158iILLL1();
        }
    }

    public interface ILil {
        IBinder IL1Iii();

        lLi1LL ILil();
    }

    /* JADX INFO: renamed from: androidx.core.app.JobIntentService$I丨L, reason: invalid class name */
    public final class IL implements lLi1LL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Intent f4954IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f4955ILil;

        public IL(Intent intent, int i) {
            this.f4954IL1Iii = intent;
            this.f4955ILil = i;
        }

        @Override // androidx.core.app.JobIntentService.lLi1LL
        public void IL1Iii() {
            JobIntentService.this.stopSelf(this.f4955ILil);
        }

        @Override // androidx.core.app.JobIntentService.lLi1LL
        public Intent getIntent() {
            return this.f4954IL1Iii;
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.JobIntentService$I丨iL, reason: invalid class name */
    public static final class IiL extends L11I {
        public IiL(Context context, ComponentName componentName, int i) {
            super(componentName);
            IL1Iii(i);
            new JobInfo.Builder(i, this.f4957IL1Iii).setOverrideDeadline(0L).build();
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.JobIntentService$L丨1丨1丨I, reason: invalid class name */
    public static abstract class L11I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4956I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ComponentName f4957IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f4958ILil;

        public L11I(ComponentName componentName) {
            this.f4957IL1Iii = componentName;
        }

        public void I1I() {
        }

        public void IL1Iii(int i) {
            if (!this.f4958ILil) {
                this.f4958ILil = true;
                this.f4956I1I = i;
            } else {
                if (this.f4956I1I == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f4956I1I);
            }
        }

        public void ILil() {
        }

        /* JADX INFO: renamed from: I丨L */
        public void mo3160IL() {
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.JobIntentService$iI丨LLL1, reason: invalid class name */
    public static final class iILLL1 extends JobServiceEngine implements ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public JobParameters f4959I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final JobIntentService f4960IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Object f4961ILil;

        /* JADX INFO: renamed from: androidx.core.app.JobIntentService$iI丨LLL1$IL1Iii */
        public final class IL1Iii implements lLi1LL {

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public final JobWorkItem f4962IL1Iii;

            public IL1Iii(JobWorkItem jobWorkItem) {
                this.f4962IL1Iii = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.lLi1LL
            public void IL1Iii() {
                synchronized (iILLL1.this.f4961ILil) {
                    JobParameters jobParameters = iILLL1.this.f4959I1I;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f4962IL1Iii);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.lLi1LL
            public Intent getIntent() {
                return this.f4962IL1Iii.getIntent();
            }
        }

        public iILLL1(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f4961ILil = new Object();
            this.f4960IL1Iii = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.ILil
        public IBinder IL1Iii() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.ILil
        public lLi1LL ILil() {
            synchronized (this.f4961ILil) {
                JobParameters jobParameters = this.f4959I1I;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f4960IL1Iii.getClassLoader());
                return new IL1Iii(jobWorkItemDequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f4959I1I = jobParameters;
            this.f4960IL1Iii.I1I(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zILil = this.f4960IL1Iii.ILil();
            synchronized (this.f4961ILil) {
                this.f4959I1I = null;
            }
            return zILil;
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.JobIntentService$l丨Li1LL, reason: invalid class name */
    public interface lLi1LL {
        void IL1Iii();

        Intent getIntent();
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2552iILLL1 = null;
        } else {
            this.f2552iILLL1 = new ArrayList<>();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static L11I m3157IL(Context context, ComponentName componentName, boolean z, int i) {
        L11I i1i;
        HashMap<ComponentName, L11I> map = f2550IiL;
        L11I l11i = map.get(componentName);
        if (l11i != null) {
            return l11i;
        }
        if (Build.VERSION.SDK_INT < 26) {
            i1i = new I1I(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            i1i = new IiL(context, componentName, i);
        }
        L11I l11i2 = i1i;
        map.put(componentName, l11i2);
        return l11i2;
    }

    public void I1I(boolean z) {
        if (this.f2551IL == null) {
            this.f2551IL = new IL1Iii();
            L11I l11i = this.f4948I1I;
            if (l11i != null && z) {
                l11i.I1I();
            }
            this.f2551IL.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public lLi1LL IL1Iii() {
        ILil iLil = this.f4949ILil;
        if (iLil != null) {
            return iLil.ILil();
        }
        synchronized (this.f2552iILLL1) {
            if (this.f2552iILLL1.size() <= 0) {
                return null;
            }
            return this.f2552iILLL1.remove(0);
        }
    }

    public boolean ILil() {
        IL1Iii iL1Iii = this.f2551IL;
        if (iL1Iii != null) {
            iL1Iii.cancel(this.f4950Ilil);
        }
        return m3159lLi1LL();
    }

    public abstract void Ilil(Intent intent);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3158iILLL1() {
        ArrayList<IL> arrayList = this.f2552iILLL1;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2551IL = null;
                ArrayList<IL> arrayList2 = this.f2552iILLL1;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    I1I(false);
                } else if (!this.f2553lLi1LL) {
                    this.f4948I1I.ILil();
                }
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m3159lLi1LL() {
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ILil iLil = this.f4949ILil;
        if (iLil != null) {
            return iLil.IL1Iii();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4949ILil = new iILLL1(this);
            this.f4948I1I = null;
        } else {
            this.f4949ILil = null;
            this.f4948I1I = m3157IL(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<IL> arrayList = this.f2552iILLL1;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2553lLi1LL = true;
                this.f4948I1I.ILil();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f2552iILLL1 == null) {
            return 2;
        }
        this.f4948I1I.mo3160IL();
        synchronized (this.f2552iILLL1) {
            ArrayList<IL> arrayList = this.f2552iILLL1;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new IL(intent, i2));
            I1I(true);
        }
        return 3;
    }
}
