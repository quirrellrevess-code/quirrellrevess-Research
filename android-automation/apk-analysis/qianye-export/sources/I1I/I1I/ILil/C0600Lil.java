package I1I.I1I.ILil;

import android.os.IInterface;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.Lil, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DisplayManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0600Lil {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Method f3157ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IInterface f3158IL1Iii;

    public C0600Lil(IInterface iInterface) {
        this.f3158IL1Iii = iInterface;
    }

    public C0599ILl IL1Iii(int i) {
        try {
            if (f3157ILil == null) {
                f3157ILil = this.f3158IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 69, 32, 91, 17, 21, 13, 80, 29, 123, 12, 3, 14}, I1I.IL1Iii.IL1Iii(new byte[]{81, 5, 82, 83, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 5, 85, 83, 83}, "bcfb71"))), Integer.TYPE);
            }
            Object objInvoke = f3157ILil.invoke(this.f3158IL1Iii, Integer.valueOf(i));
            if (objInvoke == null) {
                return null;
            }
            Class<?> cls = objInvoke.getClass();
            return new C0599ILl(i, new ili11(cls.getDeclaredField(I1I.IL1Iii.IL1Iii(new byte[]{8, 12, 5, 90, 5, 82, 8, 52, 11, 87, 18, 91}, I1I.IL1Iii.IL1Iii(new byte[]{83, 83, 81, 3, 5, 10}, I1I.IL1Iii.IL1Iii(new byte[]{81, 6, 85, 8, 85, 12}, "f6f865")))).getInt(objInvoke), cls.getDeclaredField(I1I.IL1Iii.IL1Iii(new byte[]{85, 90, 1, 80, 1, 89, 85, 125, 3, 80, 5, 80, 77}, I1I.IL1Iii.IL1Iii(new byte[]{10, 7, 81, 95, 83, 10}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 7, 95, 84, 3}, "db09e1")))).getInt(objInvoke)), cls.getDeclaredField(I1I.IL1Iii.IL1Iii(new byte[]{65, 11, 70, 87, 18, 8, 92, 10}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 86, 87, 87, 83}, I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 5, 7, 87, 87}, "4aaffe")))).getInt(objInvoke), 0, 0);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
