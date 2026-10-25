package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: compiled from: AsusImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3404IL1Iii;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsusImpl.java */
    public class C0534IL1Iii implements lIiI.IL1Iii {
        public C0534IL1Iii(IL1Iii iL1Iii) {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (iDidAidlInterfaceAsInterface == null) {
                throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{43, 118, 13, 93, 32, 8, 6, 94, 45, 87, 21, 4, 16, 84, 5, 90, 4, 65, 11, 65, 68, 87, 20, 13, 14}, I1I.IL1Iii.IL1Iii(new byte[]{86, 6, 5, 95, 84, 84}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 7, 84, 81, 2}, "4ff2d7"))));
            }
            if (iDidAidlInterfaceAsInterface.isSupport()) {
                return iDidAidlInterfaceAsInterface.getOAID();
            }
            throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{43, 38, 81, 2, 113, 90, 6, 14, 113, 8, 68, 86, 16, 4, 89, 5, 85, 16, 11, 17, 107, 19, 64, 67, 13, 16, 76, 70, 66, 86, 22, 23, 74, 8, 16, 85, 3, 14, 75, 3}, I1I.IL1Iii.IL1Iii(new byte[]{81, 82, 8, 95, 3, 85}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 81, 0, 10, 84}, "26a992"))));
        }
    }

    public IL1Iii(Context context) {
        this.f3404IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3404IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 88, 76, 84, 71, 71, 68, 27, 15, 70, 85, 28, 100, 64, 18, 69, 88, 87, 90, 80, 12, 65, 85, 64, 78, 113, 43, 113}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 0, 3, 80, 13}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 7, 80, 3, 88}, "4321fa"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3404IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{7, 94, 89, 77, 7, 21, 17, 66, 26, 14, 21, 7, 74, 80, 87, 23, 15, 9, 10, 31, 117, 32, 37, 35, 55, 98, 107, 39, 47, 34}, I1I.IL1Iii.IL1Iii(new byte[]{83, 9, 12, 7, 3, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 8, 85, 86, 3}, "b90136"))));
        intent.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{6, 95, 8, 72, 3, 74, 16, 67, 75, 11, 17, 88, 75, 99, 16, 22, 18, 85, 0, 93, 0, 8, 22, 88, 23, 73, 33, 47, 38}, I1I.IL1Iii.IL1Iii(new byte[]{92, 7, 4, 94, 6, 88}, I1I.IL1Iii.IL1Iii(new byte[]{95, 84, 88, 92, 82, 88}, "fc9d69"))), I1I.IL1Iii.IL1Iii(new byte[]{6, 93, 14, 25, 3, 69, 16, 65, 77, 90, 17, 87, 75, 97, 22, 71, 18, 90, 0, 95, 6, 89, 22, 87, 23, 75, 39, 126, 38, 24, 54, 71, 19, 71, 14, 83, 8, 87, 13, 67, 3, 68, 28, 118, 42, 115, 49, 83, 23, 68, 10, 84, 7}, I1I.IL1Iii.IL1Iii(new byte[]{92, 11, 83, 81, 7, 15}, I1I.IL1Iii.IL1Iii(new byte[]{12, 14, 9, 5, 1, 15}, "579cd6")))));
        lIiI.IL1Iii(this.f3404IL1Iii, intent, i1i, new C0534IL1Iii(this));
    }
}
