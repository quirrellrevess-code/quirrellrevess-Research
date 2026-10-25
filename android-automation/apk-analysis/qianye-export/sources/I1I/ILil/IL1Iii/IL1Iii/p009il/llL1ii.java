package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.IL1Iii;
import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.L11I;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: VivoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3425IL1Iii;

    public llL1ii(Context context) {
        this.f3425IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return L11I.LlLI1(IL1Iii.IL1Iii(new byte[]{18, 82, 20, 66, 92, 23, 22, 25, 21, 72, 70, 74, 11, 83, 3, 95, 65, 13, 4, 94, 3, 67, 92, 0, 76, 68, 19, 65, 69, 11, 16, 67, 3, 85}, IL1Iii.IL1Iii(new byte[]{84, 2, 87, 80, 80, 81}, IL1Iii.IL1Iii(new byte[]{0, 3, 1, 5, 87, 86}, "660d2c"))), IL1Iii.IL1Iii(new byte[]{85}, IL1Iii.IL1Iii(new byte[]{92, 0, 81, 7, 3, 93}, IL1Iii.IL1Iii(new byte[]{8, 83, 83, 1, 84, 2}, "110c1f")))).equals(IL1Iii.IL1Iii(new byte[]{9}, IL1Iii.IL1Iii(new byte[]{1, 90, 9, 2, 4, 0}, IL1Iii.IL1Iii(new byte[]{15, 87, 6, 85, 1, 92}, "656cc8"))));
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3425IL1Iii == null || i1i == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f3425IL1Iii.getContentResolver().query(Uri.parse(IL1Iii.IL1Iii(new byte[]{82, 9, 13, 68, 81, 91, 69, 92, 76, 31, 87, 90, 92, 72, 21, 89, 66, 90, 31, 16, 14, 67, 26, 124, 85, 54, 17, 95, 66, 92, 85, 3, 17, 31, 125, 81, 84, 8, 23, 89, 82, 92, 84, 20, 42, 84, 27, 122, 112, 47, 39}, IL1Iii.IL1Iii(new byte[]{7, 86, 5, 81, 1, 2}, IL1Iii.IL1Iii(new byte[]{87, 0, 0, 85, 6, 3}, "a0f434")))), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(IL1Iii.IL1Iii(new byte[]{64, 89, 93, 20, 82}, IL1Iii.IL1Iii(new byte[]{5, 8, 87, 0, 0, 2}, IL1Iii.IL1Iii(new byte[]{4, 85, 82, 0, 81, 0}, "7e4af5")))));
                if (string == null || string.length() == 0) {
                    throw new iILLL1(IL1Iii.IL1Iii(new byte[]{125, 32, 123, 32, 16, 19, 71, 4, 64, 29, 16, 4, 83, 8, 94, 1, 84}, IL1Iii.IL1Iii(new byte[]{6, 2, 83, 81, 81, 1}, IL1Iii.IL1Iii(new byte[]{80, 2, 80, 6, 83, 90}, "da1329"))));
                }
                IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{122, 118, 125, 112, 65, 16, 64, 82, 70, 77, 65, 18, 64, 84, 87, 81, 18, 18, 15, 23}, IL1Iii.IL1Iii(new byte[]{80, 6, 81, 80, 7, 4}, IL1Iii.IL1Iii(new byte[]{7, 8, 86, 83, 82, 80}, "b93745"))) + string);
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
