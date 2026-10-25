package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.samsung.android.deviceidservice.IDeviceIdService;

/* JADX INFO: compiled from: SamsungImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3415IL1Iii;

    /* JADX INFO: compiled from: SamsungImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii(LlLI1 llLI1) {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (iDeviceIdServiceAsInterface != null) {
                return iDeviceIdServiceAsInterface.getOAID();
            }
            throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{43, 34, 83, 21, 94, 87, 7, 47, 82, 48, 82, 70, 20, 15, 85, 6, 23, 93, 17, 70, 88, 22, 91, 88}, I1I.IL1Iii.IL1Iii(new byte[]{86, 82, 87, 87, 15, 6}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 89, 7, 0, 86}, "62838d"))));
        }
    }

    public LlLI1(Context context) {
        this.f3415IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3415IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{2, 9, 14, 23, 69, 89, 12, 21, 22, 87, 81, 22, 0, 8, 7, 75, 89, 81, 5, 72, 7, 92, 64, 81, 2, 3, 10, 93, 69, 93, 19, 16, 10, 90, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 84, 95, 2, 8}, I1I.IL1Iii.IL1Iii(new byte[]{85, 80, 84, 84, 4, 83}, "aec20c"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3415IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(I1I.IL1Iii.IL1Iii(new byte[]{90, 88, 84, 24, 70, 89, 84, 68, 76, 88, 82, 22, 88, 89, 93, 68, 90, 81, 93, 25, 93, 83, 67, 81, 90, 82, 80, 82, 70, 93, 75, 65, 80, 85, 80}, I1I.IL1Iii.IL1Iii(new byte[]{14, 81, 0, 0, 7, 93}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 9, 5, 81, 0}, "3603ce"))), I1I.IL1Iii.IL1Iii(new byte[]{86, 90, 91, 22, 16, 3, 88, 70, 67, 86, 4, 76, 84, 91, 82, 74, 12, 11, 81, 27, 82, 93, 21, 11, 86, 80, 95, 92, 16, 7, 71, 67, 95, 91, 6, 76, 113, 80, 64, 81, 0, 7, 124, 81, 101, 93, 17, 20, 92, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{83, 12, 4, 93, 5, 3}, I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 81, 86, 7, 83}, "fec3a2"))));
        lIiI.IL1Iii(this.f3415IL1Iii, intent, i1i, new IL1Iii(this));
    }
}
