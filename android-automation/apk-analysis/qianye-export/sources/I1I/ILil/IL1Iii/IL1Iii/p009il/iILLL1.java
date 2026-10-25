package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: GmsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3418IL1Iii;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.iI丨LLL1$IL1Iii */
    /* JADX INFO: compiled from: GmsImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii(iILLL1 iilll1) {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws I1I.ILil.IL1Iii.IL1Iii.iILLL1, RemoteException {
            IAdvertisingIdService iAdvertisingIdServiceAsInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
            if (iAdvertisingIdServiceAsInterface.isLimitAdTrackingEnabled(true)) {
                IiL.IL1Iii(I1I.IL1Iii.IL1Iii(new byte[]{99, 64, 0, 70, 68, 95, 87, 64, 69, 80, 13, 68, 87, 81, 9, 81, 0, 23, 87, 87, 19, 81, 22, 67, 95, 64, 12, 90, 3, 23, 95, 87, 0, 90, 16, 94, 80, 90, 0, 70}, I1I.IL1Iii.IL1Iii(new byte[]{15, 6, 85, 85, 80, 81}, I1I.IL1Iii.IL1Iii(new byte[]{14, 13, 9, 89, 87, 82}, "7898c4"))));
            }
            return iAdvertisingIdServiceAsInterface.getId();
        }
    }

    public iILLL1(Context context) {
        this.f3418IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3418IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{81, 89, 15, 26, 4, 92, 86, 68, 13, 93, 1, 28, 68, 83, 12, 80, 12, 92, 85}, I1I.IL1Iii.IL1Iii(new byte[]{83, 4, 4, 6, 92, 83}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 82, 84, 11, 81}, "534f20"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3418IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{7, 92, 8, 77, 5, 86, 11, 84, 9, 6, 76, 88, 10, 87, 23, 12, 11, 93, 74, 84, 8, 16, 76, 88, 0, 64, 75, 10, 6, 92, 10, 71, 12, 5, 11, 92, 22, 29, 22, 6, 16, 79, 13, 80, 0, 77, 49, 109, 37, 97, 49}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 80, 5, 4, 90}, I1I.IL1Iii.IL1Iii(new byte[]{10, 2, 3, 86, 81, 0}, "94607c"))));
        intent.setPackage(I1I.IL1Iii.IL1Iii(new byte[]{2, 92, 92, 25, 83, 9, 14, 84, 93, 82, 26, 7, 15, 87, 67, 88, 93, 2, 79, 84, 92, 68}, I1I.IL1Iii.IL1Iii(new byte[]{5, 81, 7, 1, 12, 95}, I1I.IL1Iii.IL1Iii(new byte[]{82, 90, 80, 0, 11, 1}, "68f638"))));
        lIiI.IL1Iii(this.f3418IL1Iii, intent, i1i, new IL1Iii(this));
    }
}
