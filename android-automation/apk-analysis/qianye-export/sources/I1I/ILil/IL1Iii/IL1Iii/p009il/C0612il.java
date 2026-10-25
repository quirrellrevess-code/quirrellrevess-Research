package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.bun.lib.MsaIdInterface;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: MsaImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0612il implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3427IL1Iii;

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.丨il$IL1Iii */
    /* JADX INFO: compiled from: MsaImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii(C0612il c0612il) {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{120, 67, 7, 45, 82, 112, 91, 68, 3, 22, 80, 88, 86, 85, 70, 13, 69, 25, 91, 69, 10, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 8, 80, 84, 14, 13}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 0, 85, 12, 4}, "386e40"))));
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{41, 65, 80, 42, 84, 125, 10, 70, 84, 17, 86, 85, 7, 87, 18, 10, 67, 103, 17, 66, 65, 12, 66, 64, 1, 86, 17, 17, 85, 64, 17, 64, 95, 67, 86, 85, 8, 65, 84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 83, 84, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 84, 0, 85, 2}, "f167ec"))));
        }
    }

    public C0612il(Context context) {
        this.f3427IL1Iii = context;
    }

    public final void I1I() {
        try {
            Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 92, 29, 3, 64, 88, 22, 92, 64, 0, 27, 87, 91, 69, 90, 14, 91, 24, 75, 69, 82, 19, 65, 24, 75, 84, 65, 23, 92, 85, 93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 0, 1, 88, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 0, 81, 15, 4}, "a41c6b"))));
            intent.setClassName(I1I.IL1Iii.IL1Iii(new byte[]{90, 13, 84, 25, 15, 0, 80, 6, 23, 90, 17, 5}, I1I.IL1Iii.IL1Iii(new byte[]{93, 85, 14, 7, 82, 84}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 81, 84, 4, 7}, "42fd47"))), I1I.IL1Iii.IL1Iii(new byte[]{82, 14, 92, 31, 91, 87, 88, 5, 31, 92, 69, 82, 31, 18, 84, 67, 64, 90, 82, 4, 31, 124, 69, 82, 122, 13, 98, 84, 68, 69, 88, 2, 84}, I1I.IL1Iii.IL1Iii(new byte[]{2, 2, 6, 83, 84, 2}, I1I.IL1Iii.IL1Iii(new byte[]{10, 83, 5, 91, 0, 5}, "9029b4"))));
            intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{81, 9, 89, 23, 86, 77, 92, 72, 89, 74, 85, 22, 66, 7, 70, 88, 89, 22, 66, 13, 83, 87, 85, 85, 87}, I1I.IL1Iii.IL1Iii(new byte[]{6, 87, 2, 10, 2, 8}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 7, 1, 84, 86}, "4b12bf"))), this.f3427IL1Iii.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f3427IL1Iii.startService(intent);
            } else {
                this.f3427IL1Iii.startForegroundService(intent);
            }
        } catch (Exception e) {
            IiL.IL1Iii(e);
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3427IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 94, 23, 93, 80, 90, 6, 29, 84, 67, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 80, 13, 9, 7}, I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 81, 3, 93, 82}, "5327da"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3427IL1Iii == null || i1i == null) {
            return;
        }
        I1I();
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{86, 14, 14, 72, 81, 70, 91, 79, 14, 21, 82, 29, 84, 2, 23, 15, 92, 93, 27, 3, 10, 8, 87, 71, 90, 79, 16, 3, 65, 69, 92, 2, 6}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 0, 82, 86, 11}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 84, 2, 82, 8}, "7c7670"))));
        intent.setClassName(I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 94, 74, 9, 81, 90, 93, 29, 9, 23, 84}, I1I.IL1Iii.IL1Iii(new byte[]{11, 10, 1, 86, 92, 86}, I1I.IL1Iii.IL1Iii(new byte[]{89, 86, 5, 0, 92, 81}, "ae72d2"))), I1I.IL1Iii.IL1Iii(new byte[]{81, 92, 8, 25, 94, 6, 91, 87, 75, 90, 64, 3, 28, 64, 0, 69, 69, 11, 81, 86, 75, 122, 64, 3, 123, 87, 54, 82, 65, 20, 91, 80, 0}, I1I.IL1Iii.IL1Iii(new byte[]{3, 10, 86, 82, 80, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 11, 7, 80, 82, 6}, "f24517"))));
        intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{2, 13, 12, 26, 7, 64, 15, 76, 12, 71, 4, 27, 17, 3, 19, 85, 8, 27, 17, 9, 6, 90, 4, 88, 4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 86, 4, 81, 84, 13}, I1I.IL1Iii.IL1Iii(new byte[]{82, 3, 1, 93, 4, 0}, "f7d858"))), this.f3427IL1Iii.getPackageName());
        lIiI.IL1Iii(this.f3427IL1Iii, intent, i1i, new IL1Iii(this));
    }
}
