package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: compiled from: CoolpadImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3406IL1Iii;

    /* JADX INFO: compiled from: CoolpadImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii() {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(ILil.this.f3406IL1Iii.getPackageName());
            }
            throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{42, 37, 92, 20, 81, 85, 6, 40, 93, 47, 89, 88, 2, 6, 92, 16, 24, 95, 16, 65, 87, 23, 84, 90}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 92, 80, 13, 7}, I1I.IL1Iii.IL1Iii(new byte[]{15, 6, 86, 2, 0, 3}, "903052"))));
        }
    }

    public ILil(Context context) {
        if (context instanceof Application) {
            this.f3406IL1Iii = context;
        } else {
            this.f3406IL1Iii = context.getApplicationContext();
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3406IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 84, 28, 83, 93, 95, 85, 73, 83, 84, 28, 84, 92, 79, 91, 83, 87, 89, 93, 74, 71, 64, 66, 95, 75, 77}, I1I.IL1Iii.IL1Iii(new byte[]{9, 8, 1, 7, 83, 80}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 15, 13, 1, 81}, "9b78b3"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3406IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 84, 26, 0, 89, 9, 85, 73, 85, 7, 24, 2, 92, 79, 93, 0, 83, 15, 93, 74, 65, 19, 70, 9, 75, 77}, I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 13, 3, 2, 84}, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 12, 6, 80, 7}, "13811e"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 90, 29, 90, 90, 92, 85, 71, 82, 93, 27, 87, 92, 65, 90, 90, 80, 90, 93, 68, 70, 73, 69, 92, 75, 67, 29, 125, 80, 69, 80, 84, 86, 112, 81, 96, 92, 69, 69, 80, 86, 86}, I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 6, 82, 14, 0}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 82, 83, 0, 4}, "5bc271")))));
        lIiI.IL1Iii(this.f3406IL1Iii, intent, i1i, new IL1Iii());
    }
}
