package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.io.Closeable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: ContentProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL implements Closeable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Object f3128I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lLi1LL f3129ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final IBinder f3130Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final String f945IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Class f946IiL = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f947iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Method f948lLi1LL;

    static {
        I1I.IL1Iii.IL1Iii(new byte[]{64, 26, 16, 69, 86, 89}, I1I.IL1Iii.IL1Iii(new byte[]{3, 82, 0, 1, 87, 0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 81, 8, 1, 7}, "4e28e3")));
        I1I.IL1Iii.IL1Iii(new byte[]{74, 80, 91, 67, 64, 84}, I1I.IL1Iii.IL1Iii(new byte[]{9, 87, 11, 84, 2, 82}, I1I.IL1Iii.IL1Iii(new byte[]{84, 83, 80, 7, 83, 7}, "d1cecd")));
        I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 86, 84, 85, 8}, I1I.IL1Iii.IL1Iii(new byte[]{85, 13, 93, 80, 5, 80}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 84, 7, 84, 80}, "b30aed")));
        I1I.IL1Iii.IL1Iii(new byte[]{117, 115, 49, 62, 67, 24, 65, 66, 0, 12}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 87, 82, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 87, 2, 95, 6}, "b3e194")));
        I1I.IL1Iii.IL1Iii(new byte[]{37, 116, 48, 109, 17, 82, 1, 68, 22, 87}, I1I.IL1Iii.IL1Iii(new byte[]{3, 85, 84, 7, 81, 85}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 6, 7, 11, 86}, "b06284")));
        I1I.IL1Iii.IL1Iii(new byte[]{127, 116, 99, 103, 5, 84, 87, 83, 86, 84}, I1I.IL1Iii.IL1Iii(new byte[]{13, 80, 84, 15, 85, 13}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 0, 7, 81, 3}, "0ac0f6")));
        I1I.IL1Iii.IL1Iii(new byte[]{50, 99, 102, 106, 68, 74, 17, 66, 87, 88}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 81, 3, 15, 81}, I1I.IL1Iii.IL1Iii(new byte[]{82, 14, 90, 7, 9, 86}, "d99114")));
        I1I.IL1Iii.IL1Iii(new byte[]{99, 108, 53, 57, 16, 81, 80, 76, 19, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 95, 3, 7, 83, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 86, 2, 0, 82}, "7d4c04")));
        I1I.IL1Iii.IL1Iii(new byte[]{49, 48, 109, 60, 81, 91, 14, 7, 88, 15}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 13, 5, 3, 5}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 0, 94, 81, 2}, "0548d0")));
        I1I.IL1Iii.IL1Iii(new byte[]{58, 68, 65, 4, 69}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 2, 3, 81, 6}, I1I.IL1Iii.IL1Iii(new byte[]{9, 88, 0, 90, 81, 3}, "890875")));
        I1I.IL1Iii.IL1Iii(new byte[]{69, 0, 92, 76, 86}, I1I.IL1Iii.IL1Iii(new byte[]{10, 85, 8, 13, 0, 84}, I1I.IL1Iii.IL1Iii(new byte[]{8, 81, 10, 80, 87, 81}, "1e2dd3")));
    }

    public IiL(lLi1LL lli1ll, Object obj, String str, IBinder iBinder) {
        this.f3129ILil = lli1ll;
        this.f3128I1I = obj;
        this.f945IL = str;
        this.f3130Ilil = iBinder;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Bundle m893IiL(String str, String str2, String str3, Bundle bundle) {
        Object[] objArr;
        try {
            Method methodM894 = m894();
            int i = this.f947iILLL1;
            if (i == 0) {
                objArr = new Object[6];
                objArr[0] = I1I.IL1Iii.IL1Iii(new byte[]{80, 92, 15, 30, 0, 93, 87, 65, 13, 89, 5, 29, 64, 91, 7, 92, 13}, I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 87, 84, 82, 87}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 6, 86, 0, 87}, "2b3233")));
                try {
                    objArr[1] = null;
                    objArr[2] = str;
                    objArr[3] = str2;
                    objArr[4] = str3;
                    objArr[5] = bundle;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    return null;
                }
            } else if (i == 1) {
                objArr = new Object[]{I1I.IL1Iii.IL1Iii(new byte[]{87, 87, 90, 23, 82, 88, 80, 74, 88, 80, 87, 24, 71, 80, 82, 85, 95}, I1I.IL1Iii.IL1Iii(new byte[]{5, 13, 83, 9, 86, 4}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 80, 6, 85, 86}, "c4460d"))), str, str2, str3, bundle};
            } else if (i != 3) {
                objArr = new Object[]{I1I.IL1Iii.IL1Iii(new byte[]{7, 14, 15, 29, 0, 95, 0, 19, 13, 90, 5, 31, 23, 9, 7, 95, 13}, I1I.IL1Iii.IL1Iii(new byte[]{87, 81, 4, 4, 80, 84}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 0, 15, 4, 81}, "11f854"))), str2, str3, bundle};
            } else {
                try {
                    String strLiL1 = lIlii.LiL1();
                    Constructor constructor = this.f946IiL.getConstructor(Integer.TYPE, String.class, String.class);
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(Binder.getCallingUid());
                    objArr2[1] = strLiL1;
                    try {
                        objArr2[2] = null;
                        objArr = new Object[]{constructor.newInstance(objArr2), str, str2, str3, bundle};
                    } catch (Exception unused2) {
                        return null;
                    }
                } catch (Exception unused3) {
                    return null;
                }
            }
            return (Bundle) methodM894.invoke(this.f3128I1I, objArr);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused4) {
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3129ILil.Ilil(this.f945IL, this.f3130Ilil);
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final Method m894() throws NoSuchMethodException {
        if (this.f948lLi1LL == null) {
            try {
                try {
                    try {
                        if (this.f946IiL == null) {
                            this.f946IiL = Class.forName(I1I.IL1Iii.IL1Iii(new byte[]{82, 11, 6, 17, 89, 90, 87, 75, 1, 12, 88, 71, 86, 11, 22, 77, 119, 71, 71, 23, 11, 1, 67, 71, 90, 10, 12, 48, 89, 70, 65, 6, 7}, I1I.IL1Iii.IL1Iii(new byte[]{85, 3, 85, 86, 85, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 83, 6, 86, 0}, "21d356"))));
                        }
                        this.f948lLi1LL = this.f3128I1I.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{90, 4, 93, 8}, I1I.IL1Iii.IL1Iii(new byte[]{91, 93, 7, 2, 3, 4}, I1I.IL1Iii.IL1Iii(new byte[]{1, 14, 2, 0, 3, 13}, "c64ff8"))), this.f946IiL, String.class, String.class, String.class, Bundle.class);
                        this.f947iILLL1 = 3;
                        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 104}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 84, 6, 8, 86}, I1I.IL1Iii.IL1Iii(new byte[]{90, 3, 5, 7, 84, 86}, "9754e3"))), I1I.IL1Iii.IL1Iii(new byte[]{34, 65, 17, 71, 8, 85, 22, 65, 12, 90, 15, 100, 12, 64, 23, 86, 4, 23, 1, 80, 69, 64, 18, 82, 7}, I1I.IL1Iii.IL1Iii(new byte[]{91, 2, 86, 2, 88, 82}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 7, 84, 12, 84}, "804c51"))));
                        return this.f948lLi1LL;
                    } catch (NoSuchMethodException unused) {
                        this.f948lLi1LL = this.f3128I1I.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 89, 92}, I1I.IL1Iii.IL1Iii(new byte[]{9, 83, 84, 7, 0, 80}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 2, 0, 1, 94}, "94c788"))), String.class, String.class, String.class, Bundle.class);
                        this.f947iILLL1 = 2;
                    }
                } catch (NoSuchMethodException unused2) {
                    this.f948lLi1LL = this.f3128I1I.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 9, 15}, I1I.IL1Iii.IL1Iii(new byte[]{15, 8, 93, 82, 13, 4}, I1I.IL1Iii.IL1Iii(new byte[]{15, 14, 94, 84, 94, 7}, "66fef6"))), String.class, String.class, String.class, String.class, Bundle.class);
                    this.f947iILLL1 = 1;
                    return this.f948lLi1LL;
                }
            } catch (Exception unused3) {
                this.f948lLi1LL = this.f3128I1I.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 91, 93}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 7, 2, 1, 87}, I1I.IL1Iii.IL1Iii(new byte[]{3, 88, 6, 11, 83, 81}, "e9686c"))), String.class, String.class, String.class, String.class, String.class, Bundle.class);
                this.f947iILLL1 = 0;
                return this.f948lLi1LL;
            }
        }
        return this.f948lLi1LL;
    }
}
