package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import I1I.I1I.p008IL.lIlii;
import android.os.Build;
import android.os.IInterface;
import android.util.Log;
import android.view.IRotationWatcher;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: WindowManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class l1Lll {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final String f1033IL = "I1I.I1I.ILil.l1Lll";

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Method f3258I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IInterface f3259IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Method f3260ILil;

    public l1Lll(IInterface iInterface) {
        this.f3259IL1Iii = iInterface;
    }

    public int I1I() {
        try {
            return ((Integer) ILil().invoke(this.f3259IL1Iii, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            IiL.IL1Iii(f1033IL, I1I.IL1Iii.IL1Iii(new byte[]{37, 9, 23, 13, 5, 69, 8, 9, 22, 65, 8, 11, 16, 9, 9, 4, 65, 8, 3, 18, 10, 14, 5}, I1I.IL1Iii.IL1Iii(new byte[]{94, 0, 82, 87, 0, 81}, I1I.IL1Iii.IL1Iii(new byte[]{13, 86, 5, 7, 82, 6}, "505132"))) + e.toString());
            return 0;
        }
    }

    public int IL1Iii(IRotationWatcher iRotationWatcher) {
        try {
            if (this.f3258I1I == null) {
                Method declaredMethod = this.f3259IL1Iii.getClass().getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{65, 82, 22, 81, 12, 107, 89, 71, 3, 70, 13, 86, 88}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 80, 11, 93, 11}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 2, 8, 13, 83}, "1c014a"))), lIlii.ill1LI1l(this.f3259IL1Iii.getClass(), I1I.IL1Iii.IL1Iii(new byte[]{68, 88, 77, 7, 94, 97, 92, 77, 88, 16, 95, 92, 93}, I1I.IL1Iii.IL1Iii(new byte[]{85, 90, 8, 7, 6, 11}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 80, 85, 82, 8}, "c7a6b0")))));
                if (declaredMethod != null) {
                    this.f3258I1I = declaredMethod;
                }
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.f3258I1I.invoke(this.f3259IL1Iii, iRotationWatcher, 0);
            } else {
                this.f3258I1I.invoke(this.f3259IL1Iii, iRotationWatcher);
            }
            return 0;
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 105}, I1I.IL1Iii.IL1Iii(new byte[]{82, 3, 3, 82, 82, 8}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 80, 2, 5, 92}, "02b3de"))), I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 84, 110, 82, 70, 81, 90, 85, 75, 19, 119, 64, 64, 13, 4, 13}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 85, 91, 3, 80}, I1I.IL1Iii.IL1Iii(new byte[]{6, 83, 80, 4, 8, 87}, "555f85"))) + e.toString());
            return -1;
        }
    }

    public final Method ILil() throws NoSuchMethodException {
        if (this.f3260ILil == null) {
            Class<?> cls = this.f3259IL1Iii.getClass();
            try {
                this.f3260ILil = cls.getMethod(I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 65, 117, 7, 5, 80, 19, 89, 69, 38, 10, 66, 22, 89, 80, 27, 49, 94, 18, 84, 69, 11, 12, 95}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 83, 4, 7, 90}, I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 87, 13, 80, 92}, "cd185e"))), new Class[0]);
            } catch (NoSuchMethodException unused) {
                this.f3260ILil = cls.getMethod(I1I.IL1Iii.IL1Iii(new byte[]{87, 92, 66, 106, 12, 66, 81, 77, 95, 87, 13}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 14, 89, 82, 7}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 10, 7, 83, 80}, "692fba"))), new Class[0]);
            }
        }
        return this.f3260ILil;
    }
}
