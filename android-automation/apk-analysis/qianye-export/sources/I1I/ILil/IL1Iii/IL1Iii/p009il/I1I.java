package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.IL1Iii;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: CooseaImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3402IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final KeyguardManager f3403ILil;

    public I1I(Context context) {
        this.f3402IL1Iii = context;
        this.f3403ILil = (KeyguardManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{89, 84, 78, 87, 22, 4, 64, 85}, IL1Iii.IL1Iii(new byte[]{10, 84, 84, 84, 7, 93}, IL1Iii.IL1Iii(new byte[]{94, 92, 80, 87, 80, 12}, "f93344"))));
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        KeyguardManager keyguardManager;
        if (this.f3402IL1Iii == null || (keyguardManager = this.f3403ILil) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod(IL1Iii.IL1Iii(new byte[]{10, 75, 48, 68, 21, 17, 12, 74, 23, 84, 1}, IL1Iii.IL1Iii(new byte[]{85, 90, 80, 7, 1, 88}, IL1Iii.IL1Iii(new byte[]{6, 0, 11, 82, 84, 8}, "0b8d01"))), new Class[0]).invoke(this.f3403ILil, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            IiL.IL1Iii(e);
            return false;
        }
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I.ILil.IL1Iii.IL1Iii.I1I i1i) {
        if (this.f3402IL1Iii == null || i1i == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f3403ILil;
        if (keyguardManager == null) {
            i1i.ILil(new iILLL1(IL1Iii.IL1Iii(new byte[]{127, 81, 77, 81, 69, 83, 70, 80, 121, 87, 94, 83, 83, 81, 70, 22, 94, 93, 64, 20, 82, 89, 69, 92, 80}, IL1Iii.IL1Iii(new byte[]{3, 5, 6, 87, 9, 10}, IL1Iii.IL1Iii(new byte[]{86, 9, 5, 4, 1, 9}, "a87e81")))));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod(IL1Iii.IL1Iii(new byte[]{14, 7, 21, 87, 8, 88, 46, 4, 8, 82}, IL1Iii.IL1Iii(new byte[]{4, 82, 7, 6, 5, 3}, IL1Iii.IL1Iii(new byte[]{87, 83, 80, 1, 0, 80}, "2d61de"))), new Class[0]).invoke(this.f3403ILil, new Object[0]);
            if (objInvoke == null) {
                throw new iILLL1(IL1Iii.IL1Iii(new byte[]{45, 116, 47, 112, 24, 88, 0, 65, 7, 93, 86, 23, 4, 84, 15, 88, 93, 83}, IL1Iii.IL1Iii(new byte[]{0, 4, 2, 13, 1, 85}, IL1Iii.IL1Iii(new byte[]{0, 80, 93, 8, 93, 4}, "ba91df"))));
            }
            String string = objInvoke.toString();
            IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{41, 34, 121, 119, 25, 94, 4, 23, 81, 90, 87, 17, 21, 22, 83, 80, 92, 66, 21, 89, 16}, IL1Iii.IL1Iii(new byte[]{86, 85, 6, 5, 9, 83}, IL1Iii.IL1Iii(new byte[]{82, 3, 7, 84, 1, 91}, "b51b19"))) + string);
            i1i.IL1Iii(string);
        } catch (Exception e) {
            IiL.IL1Iii(e);
        }
    }
}
