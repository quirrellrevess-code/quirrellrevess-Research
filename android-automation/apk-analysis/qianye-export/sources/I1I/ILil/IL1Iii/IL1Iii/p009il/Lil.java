package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.mysql.jdbc.StatementImpl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import repeackage.com.heytap.openid.IOpenID;

/* JADX INFO: compiled from: OppoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3412IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public String f3413ILil;

    /* JADX INFO: compiled from: OppoImpl.java */
    public class IL1Iii implements lIiI.IL1Iii {
        public IL1Iii() {
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.p009il.lIiI.IL1Iii
        public String IL1Iii(IBinder iBinder) throws iILLL1, RemoteException {
            try {
                return Lil.this.m1228IL(iBinder);
            } catch (iILLL1 e) {
                throw e;
            } catch (RemoteException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new iILLL1(e3);
            }
        }
    }

    public Lil(Context context) {
        if (context instanceof Application) {
            this.f3412IL1Iii = context;
        } else {
            this.f3412IL1Iii = context.getApplicationContext();
        }
    }

    public String I1I(IBinder iBinder, String str, String str2) throws iILLL1, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, I1I.IL1Iii.IL1Iii(new byte[]{121, 55, 127, 38}, I1I.IL1Iii.IL1Iii(new byte[]{85, 3, 84, 7, 84, 12}, I1I.IL1Iii.IL1Iii(new byte[]{91, 88, 0, 83, 80, 83}, "89b6ff"))));
        }
        throw new iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{120, 124, 18, 87, 90, 124, 117, 19, 11, 65, 20, 91, 68, 95, 14}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 87, 86, 3, 5}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 2, 81, 7, 1}, "c77501"))));
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3412IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(I1I.IL1Iii.IL1Iii(new byte[]{90, 90, 11, 79, 80, 85, 64, 65, 7, 17, 22, 95, 73, 80, 8, 8, 92}, I1I.IL1Iii.IL1Iii(new byte[]{14, 12, 85, 84, 10, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 95, 5, 86, 80, 82}, "af6cbc"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3412IL1Iii == null || i1i == null) {
            return;
        }
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 67, 92, 95, 92, 72, 87, 88, 88, 30, 90, 3, 77, 67, 84, 64, 28, 9, 68, 82, 91, 89, 86, 72, 123, 103, 112, 126, 109, 47, 112, 104, 102, 117, 96, 48, 125, 116, 112}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 81, 6, 86, 7}, I1I.IL1Iii.IL1Iii(new byte[]{1, 4, 2, 87, 86, 80}, "06dd0e"))));
        intent.setComponent(new ComponentName(I1I.IL1Iii.IL1Iii(new byte[]{84, 88, 95, 72, 81, 87, 78, 67, 83, 22, 23, 93, 71, 82, 92, 15, 93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 84, 7, 92, 86}, I1I.IL1Iii.IL1Iii(new byte[]{5, 85, 5, 0, 6, 92}, "2dcac8"))), I1I.IL1Iii.IL1Iii(new byte[]{0, 9, 9, 74, 91, 83, 26, 18, 5, 20, 29, 89, 19, 3, 10, 13, 87, 24, 42, 2, 1, 10, 71, 95, 5, 31, 55, 1, 65, 64, 10, 5, 1}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 87, 6, 11, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 81, 86, 6, 12, 83}, "7eed47")))));
        lIiI.IL1Iii(this.f3412IL1Iii, intent, i1i, new IL1Iii());
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String m1228IL(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, iILLL1, RemoteException {
        String packageName = this.f3412IL1Iii.getPackageName();
        String str = this.f3413ILil;
        if (str != null) {
            return I1I(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance(I1I.IL1Iii.IL1Iii(new byte[]{54, 121, 121, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 89, 80, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 0, 93, 15, 86}, "70a965")))).digest(this.f3412IL1Iii.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & StatementImpl.USES_VARIABLES_UNKNOWN) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.f3413ILil = string;
        return I1I(iBinder, packageName, string);
    }
}
