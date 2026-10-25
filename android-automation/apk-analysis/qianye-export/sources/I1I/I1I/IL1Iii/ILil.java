package I1I.I1I.IL1Iii;

import I1I.I1I.ILil.C1;
import I1I.I1I.ILil.InterfaceC0604lIII;
import I1I.I1I.ILil.LlLI1;
import I1I.I1I.ILil.LlLLL;
import I1I.I1I.ILil.lliiI1;
import I1I.I1I.p008IL.lIlii;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.main.app.MainService;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: ScriptRunner.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Activity f3082I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public InterfaceC0604lIII f3083IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Intent f3084ILil = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ServiceConnection f921IL = new IL1Iii();

    /* JADX INFO: compiled from: ScriptRunner.java */
    public class IL1Iii implements ServiceConnection {
        public IL1Iii() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ILil.this.f3083IL1Iii = ((MainService.IiL) iBinder).IL1Iii();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.IL1Iii.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScriptRunner.java */
    public class C0521ILil implements LlLLL {
        public C0521ILil() {
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void IL1Iii() {
            lIlii.lILi1lLl(ILil.this.f3082I1I, I1I.IL1Iii.IL1Iii(new byte[]{-46, -35, -16, -121, -91, -68, -46, -15, -54, -124, -68, -102, -46, -59, -44, -119, -126, -105}, I1I.IL1Iii.IL1Iii(new byte[]{86, 81, 87, 87, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 86, 82, 91, 7}, "3cdd81"))));
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void ILil() {
        }
    }

    public ILil(Activity activity) {
        this.f3082I1I = activity;
    }

    public void I1I() {
        m845iILLL1();
        m842IL();
        Ilil();
    }

    public final void Ilil() {
        C1 c1I1I = LlLI1.m925IL().I1I(this.f3082I1I);
        if (c1I1I == null || !(c1I1I instanceof lliiI1)) {
            return;
        }
        c1I1I.ILL(this.f3082I1I, new C0521ILil());
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m842IL() {
        Activity activity = this.f3082I1I;
        activity.bindService(new Intent(activity, (Class<?>) MainService.class), this.f921IL, 3);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m843IiL() {
        Intent intent = new Intent(this.f3082I1I, (Class<?>) MainService.class);
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{2, 90, 65, 92, 12, 11}, I1I.IL1Iii.IL1Iii(new byte[]{84, 8, 7, 3, 83, 7}, I1I.IL1Iii.IL1Iii(new byte[]{85, 9, 5, 15, 4, 85}, "b87947"))), I1I.IL1Iii.IL1Iii(new byte[]{16, 89, 13, 69, 84, 14, 12, 80, 22}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 3, 81, 10, 87}, I1I.IL1Iii.IL1Iii(new byte[]{88, 80, 80, 82, 14, 4}, "921161"))));
        this.f3082I1I.startService(intent);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m844L11I() {
        try {
            this.f3082I1I.unbindService(this.f921IL);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m845iILLL1() {
        Intent intent = new Intent(this.f3082I1I, (Class<?>) MainService.class);
        this.f3084ILil = intent;
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        this.f3082I1I.startService(this.f3084ILil);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m846lLi1LL() {
        InterfaceC0604lIII interfaceC0604lIII = this.f3083IL1Iii;
        if (interfaceC0604lIII == null) {
            lIlii.lILi1lLl(this.f3082I1I, I1I.IL1Iii.IL1Iii(new byte[]{-128, -6, -23, -46, -66, -109, -128, -44, -59, -47, -88, -69, -125, -10, -53, -46, -66, -102}, I1I.IL1Iii.IL1Iii(new byte[]{80, 0, 93, 5, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{15, 85, 91, 11, 7, 84}, "93b9a0"))));
        } else {
            try {
                interfaceC0604lIII.mo1026lLi1LL(-1, null);
            } catch (Exception unused) {
            }
        }
    }
}
