package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.p028IiL.Lil.lLi1LL;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatImageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public C0627LLlI1 f3778I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ImageView f3779IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public C0627LLlI1 f3780ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public C0627LLlI1 f1366IL;

    public L11I(ImageView imageView) {
        this.f3779IL1Iii = imageView;
    }

    public ColorStateList I1I() {
        C0627LLlI1 c0627LLlI1 = this.f3778I1I;
        if (c0627LLlI1 != null) {
            return c0627LLlI1.f3850IL1Iii;
        }
        return null;
    }

    public final boolean IL1Iii(Drawable drawable) {
        if (this.f1366IL == null) {
            this.f1366IL = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f1366IL;
        c0627LLlI1.IL1Iii();
        ColorStateList colorStateListIL1Iii = lLi1LL.IL1Iii(this.f3779IL1Iii);
        if (colorStateListIL1Iii != null) {
            c0627LLlI1.f1431IL = true;
            c0627LLlI1.f3850IL1Iii = colorStateListIL1Iii;
        }
        PorterDuff.Mode modeILil = lLi1LL.ILil(this.f3779IL1Iii);
        if (modeILil != null) {
            c0627LLlI1.f3849I1I = true;
            c0627LLlI1.f3851ILil = modeILil;
        }
        if (!c0627LLlI1.f1431IL && !c0627LLlI1.f3849I1I) {
            return false;
        }
        iILLL1.m1781L11I(drawable, c0627LLlI1, this.f3779IL1Iii.getDrawableState());
        return true;
    }

    public void ILil() {
        Drawable drawable = this.f3779IL1Iii.getDrawable();
        if (drawable != null) {
            llL1ii.ILil(drawable);
        }
        if (drawable != null) {
            if (m1761il() && IL1Iii(drawable)) {
                return;
            }
            C0627LLlI1 c0627LLlI1 = this.f3778I1I;
            if (c0627LLlI1 != null) {
                iILLL1.m1781L11I(drawable, c0627LLlI1, this.f3779IL1Iii.getDrawableState());
                return;
            }
            C0627LLlI1 c0627LLlI2 = this.f3780ILil;
            if (c0627LLlI2 != null) {
                iILLL1.m1781L11I(drawable, c0627LLlI2, this.f3779IL1Iii.getDrawableState());
            }
        }
    }

    public boolean Ilil() {
        return Build.VERSION.SDK_INT < 21 || !(this.f3779IL1Iii.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public PorterDuff.Mode m1756IL() {
        C0627LLlI1 c0627LLlI1 = this.f3778I1I;
        if (c0627LLlI1 != null) {
            return c0627LLlI1.f3851ILil;
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1757IiL(ColorStateList colorStateList) {
        if (this.f3778I1I == null) {
            this.f3778I1I = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f3778I1I;
        c0627LLlI1.f3850IL1Iii = colorStateList;
        c0627LLlI1.f1431IL = true;
        ILil();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1758L11I(PorterDuff.Mode mode) {
        if (this.f3778I1I == null) {
            this.f3778I1I = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f3778I1I;
        c0627LLlI1.f3851ILil = mode;
        c0627LLlI1.f3849I1I = true;
        ILil();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1759iILLL1(int i) {
        if (i != 0) {
            Drawable drawableM1686IL = IL1Iii.m1686IL(this.f3779IL1Iii.getContext(), i);
            if (drawableM1686IL != null) {
                llL1ii.ILil(drawableM1686IL);
            }
            this.f3779IL1Iii.setImageDrawable(drawableM1686IL);
        } else {
            this.f3779IL1Iii.setImageDrawable(null);
        }
        ILil();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1760lLi1LL(AttributeSet attributeSet, int i) {
        int iM1822ILl;
        llI lliI11li1 = llI.I11li1(this.f3779IL1Iii.getContext(), attributeSet, ILL.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f3779IL1Iii.getDrawable();
            if (drawable == null && (iM1822ILl = lliI11li1.m1822ILl(ILL.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = IL1Iii.m1686IL(this.f3779IL1Iii.getContext(), iM1822ILl)) != null) {
                this.f3779IL1Iii.setImageDrawable(drawable);
            }
            if (drawable != null) {
                llL1ii.ILil(drawable);
            }
            int i2 = ILL.AppCompatImageView_tint;
            if (lliI11li1.m1829lIlii(i2)) {
                lLi1LL.I1I(this.f3779IL1Iii, lliI11li1.I1I(i2));
            }
            int i3 = ILL.AppCompatImageView_tintMode;
            if (lliI11li1.m1829lIlii(i3)) {
                lLi1LL.m2219IL(this.f3779IL1Iii, llL1ii.Ilil(lliI11li1.ILL(i3, -1), null));
            }
        } finally {
            lliI11li1.m1833lL();
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final boolean m1761il() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            return this.f3780ILil != null;
        }
        return i == 21;
    }
}
