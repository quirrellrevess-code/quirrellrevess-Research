package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: OAIDService.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI implements ServiceConnection {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final IL1Iii f3419I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3420IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I1I f3421ILil;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: OAIDService.java */
    @FunctionalInterface
    public interface IL1Iii {
        String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException;
    }

    public lIiI(Context context, I1I i1i, IL1Iii iL1Iii) {
        if (context instanceof Application) {
            this.f3420IL1Iii = context;
        } else {
            this.f3420IL1Iii = context.getApplicationContext();
        }
        this.f3421ILil = i1i;
        this.f3419I1I = iL1Iii;
    }

    public static void IL1Iii(Context context, Intent intent, I1I i1i, IL1Iii iL1Iii) {
        new lIiI(context, i1i, iL1Iii).ILil(intent);
    }

    public final void ILil(Intent intent) {
        try {
            if (!this.f3420IL1Iii.bindService(intent, this, 1)) {
                throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{99, 87, 17, 71, 94, 80, 85, 18, 1, 88, 89, 87, 89, 92, 4, 17, 81, 82, 89, 94, 6, 85}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 91, 1, 86, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 85, 0, 6, 81, 2}, "ba8606"))));
            }
            IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{49, 82, 67, 65, 81, 6, 7, 23, 89, 86, 75, 69, 0, 82, 84, 89, 24, 7, 13, 66, 95, 83, 2, 69}, I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 85, 6, 94, 7}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 86, 9, 4, 84}, "5028b6"))) + intent);
        } catch (Exception e) {
            this.f3421ILil.ILil(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{103, 3, 23, 66, 89, 91, 81, 70, 13, 85, 67, 24, 86, 3, 0, 90, 16, 91, 91, 8, 11, 81, 83, 76, 81, 2, 95, 20}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 82, 1, 4, 15}, I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 82, 0, 85, 81}, "ebe5af"))) + componentName.getClassName());
        try {
            try {
                try {
                    String strIL1Iii = this.f3419I1I.IL1Iii(iBinder);
                    if (strIL1Iii == null || strIL1Iii.length() == 0) {
                        throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{126, 120, 123, 33, 29, 34, 112, 112, 118, 69, 83, 0, 64, 76, 91, 23, 87, 67, 87, 88, 91, 9, 87, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 95, 84, 87, 81, 1}, I1I.IL1Iii.IL1Iii(new byte[]{90, 0, 83, 11, 6, 87}, "8f59e5"))));
                    }
                    IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{44, 121, 121, 114, 22, 32, 34, 113, 116, 22, 88, 2, 18, 77, 89, 68, 92, 65, 16, 77, 83, 85, 92, 18, 16, 2, 16}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 2, 82, 12, 2}, I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 6, 85, 80, 81}, "5441e2"))) + strIL1Iii);
                    this.f3421ILil.IL1Iii(strIL1Iii);
                    this.f3420IL1Iii.unbindService(this);
                    IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{102, 92, 20, 70, 95, 81, 80, 25, 14, 81, 69, 18, 87, 92, 3, 94, 22, 71, 91, 91, 9, 69, 88, 86, 15, 25}, I1I.IL1Iii.IL1Iii(new byte[]{83, 13, 83, 86, 5, 5}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 80, 87, 85, 85}, "bfe1fb"))) + componentName.getClassName());
                } catch (Exception e) {
                    IiL.IL1Iii(e);
                    this.f3421ILil.ILil(e);
                    this.f3420IL1Iii.unbindService(this);
                    IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{96, 85, 67, 64, 10, 84, 86, 16, 89, 87, 16, 23, 81, 85, 84, 88, 67, 66, 93, 82, 94, 67, 13, 83, 9, 16}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 5, 5, 1, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 5, 6, 90, 7}, "5b158c"))) + componentName.getClassName());
                }
            } catch (Exception e2) {
                IiL.IL1Iii(e2);
            }
        } catch (Throwable th) {
            try {
                this.f3420IL1Iii.unbindService(this);
                IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{97, 85, 75, 21, 90, 6, 87, 16, 81, 2, 64, 69, 80, 85, 92, 13, 19, 16, 92, 82, 86, 22, 93, 1, 8, 16}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 1, 84, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 14, 2, 5, 3}, "036573"))) + componentName.getClassName());
                throw th;
            } catch (Exception e3) {
                IiL.IL1Iii(e3);
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{55, 86, 65, 67, 94, 5, 1, 19, 91, 84, 68, 70, 6, 86, 86, 91, 23, 2, 13, 64, 80, 90, 89, 8, 1, 80, 71, 80, 83, 92, 68}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 86, 12, 5, 95}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 87, 12, 1, 90}, "62253c"))) + componentName.getClassName());
    }
}
