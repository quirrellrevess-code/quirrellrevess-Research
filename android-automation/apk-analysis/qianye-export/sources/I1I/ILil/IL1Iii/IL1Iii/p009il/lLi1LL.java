package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.android.creator.IdsSupplier;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: FreemeImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3426IL1Iii;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: FreemeImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii(lLi1LL lli1ll) {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (idsSupplierAsInterface != null) {
                return idsSupplierAsInterface.getOAID();
            }
            throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{127, 85, 67, 99, 17, 72, 70, 93, 89, 85, 22, 24, 95, 66, 16, 94, 17, 84, 90}, I1I.IL1Iii.IL1Iii(new byte[]{7, 7, 3, 2, 82, 8}, I1I.IL1Iii.IL1Iii(new byte[]{0, 15, 10, 80, 14, 81}, "199b8a"))));
        }
    }

    public lLi1LL(Context context) {
        this.f3426IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3426IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{80, 10, 11, 79, 2, 87, 87, 23, 9, 8, 7, 23, 80, 23, 3, 0, 23, 86, 65}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 83, 86, 82, 88}, I1I.IL1Iii.IL1Iii(new byte[]{87, 87, 3, 86, 82, 80}, "d56ac1"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3426IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{4, 89, 1, 75, 13, 11, 1, 25, 22, 92, 16, 20, 12, 84, 0, 23, 3, 1, 17, 94, 10, 87, 76, 15, 22, 86}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 81, 15, 7, 90}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 86, 5, 87, 91}, "67b32c"))));
        intent.setPackage(I1I.IL1Iii.IL1Iii(new byte[]{0, 95, 9, 26, 5, 10, 7, 66, 11, 93, 0, 74, 0, 66, 1, 85, 16, 11, 17}, I1I.IL1Iii.IL1Iii(new byte[]{1, 4, 6, 87, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 82, 0, 86, 12}, "6b0c39"))));
        lIiI.IL1Iii(this.f3426IL1Iii, intent, i1i, new IL1Iii(this));
    }
}
