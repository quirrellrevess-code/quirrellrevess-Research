package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final View f3768IL1Iii;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public C0627LLlI1 f3770Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public C0627LLlI1 f1363IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public C0627LLlI1 f1364lLi1LL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3767I1I = -1;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final iILLL1 f3769ILil = iILLL1.ILil();

    public IL(View view) {
        this.f3768IL1Iii = view;
    }

    public ColorStateList I1I() {
        C0627LLlI1 c0627LLlI1 = this.f3770Ilil;
        if (c0627LLlI1 != null) {
            return c0627LLlI1.f3850IL1Iii;
        }
        return null;
    }

    public final boolean IL1Iii(Drawable drawable) {
        if (this.f1364lLi1LL == null) {
            this.f1364lLi1LL = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f1364lLi1LL;
        c0627LLlI1.IL1Iii();
        ColorStateList colorStateListLlLI1 = iIlLiL.LlLI1(this.f3768IL1Iii);
        if (colorStateListLlLI1 != null) {
            c0627LLlI1.f1431IL = true;
            c0627LLlI1.f3850IL1Iii = colorStateListLlLI1;
        }
        PorterDuff.Mode modeM2124llL1ii = iIlLiL.m2124llL1ii(this.f3768IL1Iii);
        if (modeM2124llL1ii != null) {
            c0627LLlI1.f3849I1I = true;
            c0627LLlI1.f3851ILil = modeM2124llL1ii;
        }
        if (!c0627LLlI1.f1431IL && !c0627LLlI1.f3849I1I) {
            return false;
        }
        iILLL1.m1781L11I(drawable, c0627LLlI1, this.f3768IL1Iii.getDrawableState());
        return true;
    }

    public final boolean ILL() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            return this.f1363IL != null;
        }
        return i == 21;
    }

    public void ILil() {
        Drawable background = this.f3768IL1Iii.getBackground();
        if (background != null) {
            if (ILL() && IL1Iii(background)) {
                return;
            }
            C0627LLlI1 c0627LLlI1 = this.f3770Ilil;
            if (c0627LLlI1 != null) {
                iILLL1.m1781L11I(background, c0627LLlI1, this.f3768IL1Iii.getDrawableState());
                return;
            }
            C0627LLlI1 c0627LLlI2 = this.f1363IL;
            if (c0627LLlI2 != null) {
                iILLL1.m1781L11I(background, c0627LLlI2, this.f3768IL1Iii.getDrawableState());
            }
        }
    }

    public void Ilil(AttributeSet attributeSet, int i) {
        llI lliI11li1 = llI.I11li1(this.f3768IL1Iii.getContext(), attributeSet, ILL.ViewBackgroundHelper, i, 0);
        try {
            int i2 = ILL.ViewBackgroundHelper_android_background;
            if (lliI11li1.m1829lIlii(i2)) {
                this.f3767I1I = lliI11li1.m1822ILl(i2, -1);
                ColorStateList colorStateListM1784lLi1LL = this.f3769ILil.m1784lLi1LL(this.f3768IL1Iii.getContext(), this.f3767I1I);
                if (colorStateListM1784lLi1LL != null) {
                    m1735IiL(colorStateListM1784lLi1LL);
                }
            }
            int i3 = ILL.ViewBackgroundHelper_backgroundTint;
            if (lliI11li1.m1829lIlii(i3)) {
                iIlLiL.m2120lIIiIlL(this.f3768IL1Iii, lliI11li1.I1I(i3));
            }
            int i4 = ILL.ViewBackgroundHelper_backgroundTintMode;
            if (lliI11li1.m1829lIlii(i4)) {
                iIlLiL.m2130i11LL(this.f3768IL1Iii, llL1ii.Ilil(lliI11li1.ILL(i4, -1), null));
            }
        } finally {
            lliI11li1.m1833lL();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public PorterDuff.Mode m1734IL() {
        C0627LLlI1 c0627LLlI1 = this.f3770Ilil;
        if (c0627LLlI1 != null) {
            return c0627LLlI1.f3851ILil;
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1735IiL(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1363IL == null) {
                this.f1363IL = new C0627LLlI1();
            }
            C0627LLlI1 c0627LLlI1 = this.f1363IL;
            c0627LLlI1.f3850IL1Iii = colorStateList;
            c0627LLlI1.f1431IL = true;
        } else {
            this.f1363IL = null;
        }
        ILil();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1736L11I(ColorStateList colorStateList) {
        if (this.f3770Ilil == null) {
            this.f3770Ilil = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f3770Ilil;
        c0627LLlI1.f3850IL1Iii = colorStateList;
        c0627LLlI1.f1431IL = true;
        ILil();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1737iILLL1(int i) {
        this.f3767I1I = i;
        iILLL1 iilll1 = this.f3769ILil;
        m1735IiL(iilll1 != null ? iilll1.m1784lLi1LL(this.f3768IL1Iii.getContext(), i) : null);
        ILil();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1738lLi1LL(Drawable drawable) {
        this.f3767I1I = -1;
        m1735IiL(null);
        ILil();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1739il(PorterDuff.Mode mode) {
        if (this.f3770Ilil == null) {
            this.f3770Ilil = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f3770Ilil;
        c0627LLlI1.f3851ILil = mode;
        c0627LLlI1.f3849I1I = true;
        ILil();
    }
}
