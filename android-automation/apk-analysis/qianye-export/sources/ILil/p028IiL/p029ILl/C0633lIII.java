package ILil.p028IiL.p029ILl;

import android.os.Build;
import android.view.WindowInsets;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.lI丨II, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: WindowInsetsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C0633lIII {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f4071IL1Iii;

    public C0633lIII(Object obj) {
        this.f4071IL1Iii = obj;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static Object m2152L11I(C0633lIII c0633lIII) {
        if (c0633lIII == null) {
            return null;
        }
        return c0633lIII.f4071IL1Iii;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static C0633lIII m2153il(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0633lIII(obj);
    }

    public int I1I() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f4071IL1Iii).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public C0633lIII IL1Iii() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C0633lIII(((WindowInsets) this.f4071IL1Iii).consumeSystemWindowInsets());
        }
        return null;
    }

    public int ILil() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f4071IL1Iii).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int Ilil() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f4071IL1Iii).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m2154IL() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f4071IL1Iii).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public C0633lIII m2155IiL(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C0633lIII(((WindowInsets) this.f4071IL1Iii).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0633lIII.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f4071IL1Iii;
        Object obj3 = ((C0633lIII) obj).f4071IL1Iii;
        if (obj2 == null) {
            return obj3 == null;
        }
        return obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f4071IL1Iii;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m2156iILLL1() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f4071IL1Iii).isConsumed();
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m2157lLi1LL() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f4071IL1Iii).hasSystemWindowInsets();
        }
        return false;
    }
}
