package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.IL1Iii;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.L11I;
import android.app.Application;
import android.content.Context;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: OAIDFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class Ll1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static IL f3416IL1Iii;

    public static IL I1I(Context context) {
        C0612il c0612il = new C0612il(context);
        if (c0612il.IL1Iii()) {
            IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{125, 90, 0, 10, 94, 82, 16, 102, 7, 0, 71, 69, 89, 65, 27, 67, 115, 91, 92, 92, 3, 13, 81, 82, 16, 93, 3, 16, 18, 85, 85, 80, 12, 67, 84, 88, 69, 91, 6, 89, 18}, IL1Iii.IL1Iii(new byte[]{1, 2, 90, 7, 0, 0}, IL1Iii.IL1Iii(new byte[]{82, 81, 94, 81, 2, 83}, "cff50d"))) + C0612il.class.getName());
            return c0612il;
        }
        iILLL1 iilll1 = new iILLL1(context);
        if (iilll1.IL1Iii()) {
            IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{115, 13, 14, 86, 15, 84, 20, 50, 13, 80, 26, 17, 103, 7, 19, 71, 10, 82, 81, 66, 9, 80, 16, 17, 86, 7, 4, 95, 67, 87, 91, 23, 15, 85, 89, 17}, IL1Iii.IL1Iii(new byte[]{3, 84, 86, 2, 7, 6}, IL1Iii.IL1Iii(new byte[]{6, 2, 83, 5, 84, 6}, "14d601"))) + iILLL1.class.getName());
            return iilll1;
        }
        IL il = new IL();
        IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{44, 112, 126, 34, 74, 37, 34, 120, 115, 70, 18, 5, 16, 17, 89, 9, 17, 68, 16, 68, 71, 22, 10, 22, 23, 84, 83, 92, 69}, IL1Iii.IL1Iii(new byte[]{80, 2, 5, 4, 1, 83}, IL1Iii.IL1Iii(new byte[]{10, 11, 4, 1, 7, 14}, "986cc9"))) + IL.class.getName());
        return il;
    }

    public static IL IL1Iii(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        IL il = f3416IL1Iii;
        if (il != null) {
            return il;
        }
        IL ilILil = ILil(context);
        f3416IL1Iii = ilILil;
        if (ilILil == null || !ilILil.IL1Iii()) {
            IL ilI1I = I1I(context);
            f3416IL1Iii = ilI1I;
            return ilI1I;
        }
        IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{124, 5, 10, 22, 4, 85, 82, 16, 17, 17, 7, 70, 17, 13, 10, 23, 7, 70, 87, 5, 7, 6, 66, 92, 80, 23, 68, 1, 7, 81, 95, 68, 2, 12, 23, 90, 85, 94, 68}, IL1Iii.IL1Iii(new byte[]{82, 0, 2, 1, 90, 4}, IL1Iii.IL1Iii(new byte[]{80, 83, 94, 3, 9, 3}, "378a13"))) + f3416IL1Iii.getClass().getName());
        return f3416IL1Iii;
    }

    public static IL ILil(Context context) {
        if (L11I.m1226lLi1LL() || L11I.m1223L11I()) {
            return new IiL(context);
        }
        if (L11I.m1224iILLL1()) {
            return new L11I(context);
        }
        if (L11I.m1227il()) {
            return new ILL(context);
        }
        if (L11I.Lil() || L11I.m1221IiL() || L11I.ILil()) {
            return new lIlii(context);
        }
        if (L11I.m1225lIiI()) {
            return new LlLI1(context);
        }
        if (L11I.m1219ILl()) {
            return new llL1ii(context);
        }
        if (L11I.IL1Iii()) {
            return new IL1Iii(context);
        }
        if (L11I.m1222Ll1() || L11I.ILL()) {
            Lil lil = new Lil(context);
            return lil.IL1Iii() ? lil : new C0611ILl(context);
        }
        if (L11I.I1I(context)) {
            return new ILil(context);
        }
        if (L11I.m1220IL()) {
            return new I1I(context);
        }
        if (L11I.Ilil()) {
            return new lLi1LL(context);
        }
        return null;
    }
}
