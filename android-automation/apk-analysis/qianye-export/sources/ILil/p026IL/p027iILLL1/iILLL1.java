package ILil.p026IL.p027iILLL1;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: ILil.I丨L.iI丨LLL1.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: RoundRectDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends Drawable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final RectF f3995I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public float f3996IL1Iii;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public float f3998Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Rect f1593IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ColorStateList f1594IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public PorterDuffColorFilter f1595L11I;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ColorStateList f1598il;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1597lLi1LL = false;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1596iILLL1 = true;
    public PorterDuff.Mode ILL = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Paint f3997ILil = new Paint(5);

    public iILLL1(ColorStateList colorStateList, float f) {
        this.f3996IL1Iii = f;
        Ilil(colorStateList);
        this.f3995I1I = new RectF();
        this.f1593IL = new Rect();
    }

    public float I1I() {
        return this.f3998Ilil;
    }

    public final PorterDuffColorFilter IL1Iii(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList ILil() {
        return this.f1594IiL;
    }

    public final void Ilil(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1594IiL = colorStateList;
        this.f3997ILil.setColor(colorStateList.getColorForState(getState(), this.f1594IiL.getDefaultColor()));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public float m2007IL() {
        return this.f3996IL1Iii;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m2008IiL(float f) {
        if (f == this.f3996IL1Iii) {
            return;
        }
        this.f3996IL1Iii = f;
        m2009L11I(null);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m2009L11I(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3995I1I.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1593IL.set(rect);
        if (this.f1597lLi1LL) {
            this.f1593IL.inset((int) Math.ceil(IiL.I1I(this.f3998Ilil, this.f3996IL1Iii, this.f1596iILLL1)), (int) Math.ceil(IiL.m1996IL(this.f3998Ilil, this.f3996IL1Iii, this.f1596iILLL1)));
            this.f3995I1I.set(this.f1593IL);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f3997ILil;
        if (this.f1595L11I == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1595L11I);
            z = true;
        }
        RectF rectF = this.f3995I1I;
        float f = this.f3996IL1Iii;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1593IL, this.f3996IL1Iii);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m2010iILLL1(float f, boolean z, boolean z2) {
        if (f == this.f3998Ilil && this.f1597lLi1LL == z && this.f1596iILLL1 == z2) {
            return;
        }
        this.f3998Ilil = f;
        this.f1597lLi1LL = z;
        this.f1596iILLL1 = z2;
        m2009L11I(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1598il;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1594IiL) != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2011lLi1LL(ColorStateList colorStateList) {
        Ilil(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m2009L11I(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1594IiL;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f3997ILil.getColor();
        if (z) {
            this.f3997ILil.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1598il;
        if (colorStateList2 == null || (mode = this.ILL) == null) {
            return z;
        }
        this.f1595L11I = IL1Iii(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3997ILil.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3997ILil.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1598il = colorStateList;
        this.f1595L11I = IL1Iii(colorStateList, this.ILL);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.ILL = mode;
        this.f1595L11I = IL1Iii(this.f1598il, mode);
        invalidateSelf();
    }
}
