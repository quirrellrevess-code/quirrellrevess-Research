package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import repeackage.com.oplus.stdid.IStdID;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: OppoExtImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0611ILl extends Lil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Context f3409I1I;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final String f1096IL = I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 69, 13, 9, 11, 76, 81, 94, 9, 72, 10, 18, 94, 68, 23, 72, 22, 22, 86, 88, 0, 72, 44, 38, 109, 98, 33, 52, 51, 43, 113, 116}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 3, 92, 80, 82}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 5, 91, 6, 4}, "c27c03")));

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String f3408Ilil = I1I.IL1Iii.IL1Iii(new byte[]{1, 91, 89, 77, 87, 14, 14, 91, 70, 12, 71, 79, 15, 87, 71}, I1I.IL1Iii.IL1Iii(new byte[]{81, 13, 2, 81, 82, 80}, I1I.IL1Iii.IL1Iii(new byte[]{4, 9, 1, 80, 0, 1}, "707bf0")));

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f1097lLi1LL = I1I.IL1Iii.IL1Iii(new byte[]{90, 12, 94, 29, 86, 73, 85, 22, 64, 29, 74, 77, 93, 10, 87, 29, 112, 93, 92, 13, 71, 90, 95, 64, 106, 6, 65, 69, 80, 90, 92}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 11, 7, 91, 93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 10, 87, 81, 93}, "862c39")));

    /* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.IL丨丨l$IL1Iii */
    /* JADX INFO: compiled from: OppoExtImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii() {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            try {
                return C0611ILl.this.m1228IL(iBinder);
            } catch (iILLL1 e) {
                throw e;
            } catch (RemoteException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new iILLL1(e3);
            }
        }
    }

    public C0611ILl(Context context) {
        super(context);
        this.f3409I1I = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.Lil
    public String I1I(IBinder iBinder, String str, String str2) throws iILLL1, RemoteException {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, I1I.IL1Iii.IL1Iii(new byte[]{124, 102, 124, 113}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 4, 87, 13, 85}, I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 87, 0, 13, 82}, "d4fb5e"))));
        }
        throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{124, 97, 70, 0, 124, 32, 21, 91, 65, 68, 91, 17, 89, 94}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 83, 86, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 83, 4, 87, 0}, "35264d"))));
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.Lil, I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3409I1I;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(f3408Ilil, 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.Lil, I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3409I1I == null || i1i == null) {
            return;
        }
        Intent intent = new Intent(f1096IL);
        intent.setComponent(new ComponentName(f3408Ilil, f1097lLi1LL));
        lIiI.IL1Iii(this.f3409I1I, intent, i1i, new IL1Iii());
    }
}
