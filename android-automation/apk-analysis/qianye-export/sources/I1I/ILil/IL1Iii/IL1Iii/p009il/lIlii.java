package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.IL1Iii;
import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: I1I.ILil.IL1Iii.IL1Iii.丨il.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: XiaomiImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class lIlii implements IL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Object f3422I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3423IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Class<?> f3424ILil;

    @SuppressLint({"PrivateApi"})
    public lIlii(Context context) {
        this.f3423IL1Iii = context;
        try {
            Class<?> cls = Class.forName(IL1Iii.IL1Iii(new byte[]{85, 93, 14, 72, 82, 87, 82, 64, 12, 15, 87, 23, 95, 86, 77, 15, 94, 73, 90, 28, 42, 2, 99, 75, 89, 68, 10, 2, 86, 75, 127, 95, 19, 10}, IL1Iii.IL1Iii(new byte[]{5, 1, 1, 2, 2, 92}, IL1Iii.IL1Iii(new byte[]{7, 4, 84, 81, 3, 82}, "476527"))));
            this.f3424ILil = cls;
            this.f3422I1I = cls.newInstance();
        } catch (Exception e) {
            IiL.IL1Iii(e);
        }
    }

    public final String I1I() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.f3424ILil.getMethod(IL1Iii.IL1Iii(new byte[]{85, 6, 77, 42, 121, 40, 118}, IL1Iii.IL1Iii(new byte[]{83, 7, 9, 82, 13, 7}, IL1Iii.IL1Iii(new byte[]{86, 1, 84, 6, 7, 80}, "7ed126"))), Context.class).invoke(this.f3422I1I, this.f3423IL1Iii);
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public boolean IL1Iii() {
        return this.f3422I1I != null;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3423IL1Iii == null || i1i == null) {
            return;
        }
        if (this.f3424ILil == null || this.f3422I1I == null) {
            i1i.ILil(new iILLL1(IL1Iii.IL1Iii(new byte[]{106, 92, 2, 95, 92, 93, 18, 124, 7, 96, 67, 91, 68, 92, 7, 85, 67, 20, 92, 90, 23, 16, 84, 76, 91, 70, 23, 67}, IL1Iii.IL1Iii(new byte[]{80, 7, 6, 4, 1, 7}, IL1Iii.IL1Iii(new byte[]{4, 81, 4, 82, 4, 82}, "fcaf4a")))));
            return;
        }
        try {
            String strI1I = I1I();
            if (strI1I == null || strI1I.length() == 0) {
                throw new iILLL1(IL1Iii.IL1Iii(new byte[]{41, 121, 113, 124, 18, 21, 19, 93, 74, 65, 18, 2, 7, 81, 84, 93, 86}, IL1Iii.IL1Iii(new byte[]{82, 14, 8, 92, 2, 7}, IL1Iii.IL1Iii(new byte[]{82, 84, 83, 2, 7, 90}, "fbcf79"))));
            }
            IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{122, 36, 113, 114, 17, 71, 64, 0, 74, 79, 17, 69, 64, 6, 91, 83, 66, 69, 15, 69}, IL1Iii.IL1Iii(new byte[]{4, 81, 8, 82, 8, 15}, IL1Iii.IL1Iii(new byte[]{6, 87, 86, 84, 91, 90}, "7cf0bc"))) + strI1I);
            i1i.IL1Iii(strI1I);
        } catch (Exception e) {
            IiL.IL1Iii(e);
            i1i.ILil(e);
        }
    }
}
