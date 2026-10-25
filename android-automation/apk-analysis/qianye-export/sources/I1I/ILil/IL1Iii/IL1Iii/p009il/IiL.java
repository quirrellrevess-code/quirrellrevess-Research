package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: LenovoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3411IL1Iii;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: LenovoImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii(IiL iiL) {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface == null) {
                throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{124, 119, 1, 65, 13, 2, 80, 90, 0, 126, 10, 21, 80, 65, 2, 86, 7, 4, 21, 90, 23, 23, 10, 20, 89, 95}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 86, 81, 80, 81}, I1I.IL1Iii.IL1Iii(new byte[]{84, 10, 3, 2, 0, 84}, "c81d4d"))));
            }
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{45, 119, 82, 18, 10, 90, 1, 90, 83, 45, 13, 77, 1, 65, 81, 5, 0, 92, 71, 90, 68, 55, 22, 73, 20, 92, 69, 16, 67, 75, 1, 71, 66, 22, 13, 25, 2, 82, 91, 23, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 6, 80, 87, 90}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 83, 82, 1, 91}, "55bf58"))));
        }
    }

    public IiL(Context context) {
        this.f3411IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3411IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{0, 86, 90, 74, 66, 69, 10, 23, 83, 1, 78, 89, 0, 92, 94, 0, 75, 85, 17, 79, 94, 7, 93}, I1I.IL1Iii.IL1Iii(new byte[]{7, 88, 85, 84, 10, 83}, I1I.IL1Iii.IL1Iii(new byte[]{93, 85, 85, 82, 86, 84}, "947bd7"))), 0) != null;
        } catch (Exception e) {
            I1I.ILil.IL1Iii.IL1Iii.IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3411IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(I1I.IL1Iii.IL1Iii(new byte[]{80, 91, 9, 31, 30, 64, 90, 26, 0, 84, 18, 92, 80, 81, 13, 85, 23, 80, 65, 66, 13, 82, 1}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 2, 3, 81, 4}, I1I.IL1Iii.IL1Iii(new byte[]{4, 4, 82, 10, 7, 6}, "724827"))), I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 93, 22, 78, 70, 94, 22, 84, 93, 66, 90, 84, 93, 89, 92, 71, 86, 69, 78, 89, 91, 81, 29, 115, 93, 70, 81, 87, 86, 94, 92, 99, 93, 70, 69, 94, 91, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 8, 4, 93, 86, 80}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 86, 83, 1, 90}, "31b6c9"))));
        lIiI.IL1Iii(this.f3411IL1Iii, intent, i1i, new IL1Iii(this));
    }
}
