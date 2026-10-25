package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.IL1Iii;
import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: MeizuImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3417IL1Iii;

    public L11I(Context context) {
        this.f3417IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        Context context = this.f3417IL1Iii;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider(IL1Iii.IL1Iii(new byte[]{82, 88, 92, 26, 8, 93, 88, 77, 68, 26, 3, 84, 72, 90, 84, 26, 10, 72, 84, 89, 88, 80, 22, 92, 90}, IL1Iii.IL1Iii(new byte[]{0, 84, 84, 7, 87, 11}, IL1Iii.IL1Iii(new byte[]{85, 86, 93, 7, 87, 5}, "d584e6"))), 0) != null;
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3417IL1Iii == null || i1i == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f3417IL1Iii.getContentResolver().query(Uri.parse(IL1Iii.IL1Iii(new byte[]{87, 88, 10, 18, 82, 94, 64, 13, 75, 73, 84, 95, 89, 25, 9, 3, 94, 74, 65, 25, 2, 10, 78, 93, 81, 25, 11, 22, 82, 94, 93, 83, 23, 2, 92, 31}, IL1Iii.IL1Iii(new byte[]{1, 84, 1, 95, 81, 3}, IL1Iii.IL1Iii(new byte[]{81, 85, 84, 90, 7, 85}, "d61caf")))), null, null, new String[]{IL1Iii.IL1Iii(new byte[]{86, 84, 10, 85}, IL1Iii.IL1Iii(new byte[]{12, 13, 80, 2, 81, 1}, IL1Iii.IL1Iii(new byte[]{0, 13, 5, 7, 1, 13}, "556445")))}, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(IL1Iii.IL1Iii(new byte[]{19, 88, 90, 19, 86}, IL1Iii.IL1Iii(new byte[]{4, 1, 82, 4, 0, 13}, IL1Iii.IL1Iii(new byte[]{0, 14, 84, 85, 7, 81}, "a6074d")))));
                if (string == null || string.length() == 0) {
                    throw new iILLL1(IL1Iii.IL1Iii(new byte[]{43, 121, 40, 118, 70, 16, 17, 93, 19, 75, 70, 7, 5, 81, 13, 87, 2}, IL1Iii.IL1Iii(new byte[]{80, 92, 88, 11, 5, 81}, IL1Iii.IL1Iii(new byte[]{12, 83, 11, 13, 7, 86}, "8724df"))));
                }
                IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{124, 32, 120, 32, 21, 18, 70, 4, 67, 29, 21, 16, 70, 2, 82, 1, 70, 16, 9, 65}, IL1Iii.IL1Iii(new byte[]{7, 82, 80, 83, 1, 5}, IL1Iii.IL1Iii(new byte[]{85, 6, 89, 86, 80, 4}, "a58adb"))) + string);
                i1i.IL1Iii(string);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (cursorQuery == null) {
                        throw th2;
                    }
                    try {
                        cursorQuery.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        } catch (Exception e) {
            IiL.IL1Iii(e);
            i1i.ILil(e);
        }
    }
}
