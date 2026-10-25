package I1I.I1I.p008IL;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: MyTimerToast.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f3326I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public TimerTask f3328ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Timer f3327IL1Iii = new Timer();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1063IL = BuildConfig.FLAVOR;

    /* JADX INFO: compiled from: MyTimerToast.java */
    public class IL1Iii extends TimerTask {
        public IL1Iii() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ILL.this.I1I();
        }
    }

    public ILL(Context context) {
        this.f3326I1I = context;
    }

    public final synchronized void I1I() {
        if (!TextUtils.isEmpty(this.f1063IL)) {
            lIlii.lILi1lLl(this.f3326I1I, this.f1063IL);
        }
    }

    public synchronized void ILil(String str) {
        this.f1063IL = str;
    }

    public synchronized void Ilil() {
        TimerTask timerTask = this.f3328ILil;
        if (timerTask != null) {
            timerTask.cancel();
            this.f3328ILil = null;
            this.f1063IL = BuildConfig.FLAVOR;
            Ll1.m1071IL(this.f3326I1I).Ilil();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public synchronized void m1063IL(String str) {
        ILil(str);
        Ilil();
        IL1Iii iL1Iii = new IL1Iii();
        this.f3328ILil = iL1Iii;
        this.f3327IL1Iii.scheduleAtFixedRate(iL1Iii, 10L, 1000L);
    }
}
