package ILil.p028IiL.p029ILl;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: NestedScrollingChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final View f4035I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ViewParent f4036IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ViewParent f4037ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int[] f4038Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f1611IL;

    public ILL(View view) {
        this.f4035I1I = view;
    }

    public boolean I1I(int i, int i2, int[] iArr, int[] iArr2) {
        return m2027IL(i, i2, iArr, iArr2, 0);
    }

    public boolean IL1Iii(float f, float f2, boolean z) {
        ViewParent viewParentM2030L11I;
        if (!m2032lIiI() || (viewParentM2030L11I = m2030L11I(0)) == null) {
            return false;
        }
        return I11L.IL1Iii(viewParentM2030L11I, this.f4035I1I, f, f2, z);
    }

    public boolean ILL() {
        return m2029Ll1(0);
    }

    public boolean ILil(float f, float f2) {
        ViewParent viewParentM2030L11I;
        if (!m2032lIiI() || (viewParentM2030L11I = m2030L11I(0)) == null) {
            return false;
        }
        return I11L.ILil(viewParentM2030L11I, this.f4035I1I, f, f2);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2026ILl(boolean z) {
        if (this.f1611IL) {
            iIlLiL.LII(this.f4035I1I);
        }
        this.f1611IL = z;
    }

    public void Ilil(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m2028IiL(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2027IL(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentM2030L11I;
        int i4;
        int i5;
        if (!m2032lIiI() || (viewParentM2030L11I = m2030L11I(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f4035I1I.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = m2036il();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        I11L.I1I(viewParentM2030L11I, this.f4035I1I, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f4035I1I.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m2028IiL(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentM2030L11I;
        int i6;
        int i7;
        int[] iArr3;
        if (!m2032lIiI() || (viewParentM2030L11I = m2030L11I(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f4035I1I.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] iArrM2036il = m2036il();
            iArrM2036il[0] = 0;
            iArrM2036il[1] = 0;
            iArr3 = iArrM2036il;
        } else {
            iArr3 = iArr2;
        }
        I11L.m2021IL(viewParentM2030L11I, this.f4035I1I, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f4035I1I.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public final void Lil(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f4036IL1Iii = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.f4037ILil = viewParent;
        }
    }

    public boolean LlLI1(int i) {
        return m2034llL1ii(i, 0);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m2029Ll1(int i) {
        return m2030L11I(i) != null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ViewParent m2030L11I(int i) {
        if (i == 0) {
            return this.f4036IL1Iii;
        }
        if (i != 1) {
            return null;
        }
        return this.f4037ILil;
    }

    public void iIi1(int i) {
        ViewParent viewParentM2030L11I = m2030L11I(i);
        if (viewParentM2030L11I != null) {
            I11L.m2023iILLL1(viewParentM2030L11I, this.f4035I1I, i);
            Lil(i, null);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m2031iILLL1(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return m2028IiL(i, i2, i3, i4, iArr, i5, null);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m2032lIiI() {
        return this.f1611IL;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m2033lIlii() {
        iIi1(0);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m2034llL1ii(int i, int i2) {
        if (m2029Ll1(i2)) {
            return true;
        }
        if (!m2032lIiI()) {
            return false;
        }
        View view = this.f4035I1I;
        for (ViewParent parent = this.f4035I1I.getParent(); parent != null; parent = parent.getParent()) {
            if (I11L.m2024lLi1LL(parent, view, this.f4035I1I, i, i2)) {
                Lil(i2, parent);
                I11L.Ilil(parent, view, this.f4035I1I, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m2035lLi1LL(int i, int i2, int i3, int i4, int[] iArr) {
        return m2028IiL(i, i2, i3, i4, iArr, 0, null);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int[] m2036il() {
        if (this.f4038Ilil == null) {
            this.f4038Ilil = new int[2];
        }
        return this.f4038Ilil;
    }
}
