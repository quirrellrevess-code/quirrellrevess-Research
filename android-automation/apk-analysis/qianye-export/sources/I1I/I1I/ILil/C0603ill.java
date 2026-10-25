package I1I.I1I.ILil;

import android.content.pm.PackageInfo;
import android.os.IInterface;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.il丨l丨, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: PkgManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C0603ill {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IInterface f3252IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Method f3253ILil = null;

    public C0603ill(IInterface iInterface) {
        this.f3252IL1Iii = iInterface;
    }

    public PackageInfo IL1Iii(String str, int i, int i2) {
        try {
            if (this.f3253ILil == null) {
                Class<?> cls = this.f3252IL1Iii.getClass();
                String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{94, 93, 18, 100, 89, 87, 82, 89, 1, 81, 113, 90, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{11, 0, 95, 7, 10, 5}, I1I.IL1Iii.IL1Iii(new byte[]{4, 10, 9, 7, 83, 82}, "6204ac")));
                Class<?> cls2 = Integer.TYPE;
                this.f3253ILil = cls.getMethod(strIL1Iii, String.class, cls2, cls2);
            }
            Method method = this.f3253ILil;
            if (method != null) {
                return (PackageInfo) method.invoke(this.f3252IL1Iii, str, Integer.valueOf(i), Integer.valueOf(i2));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
