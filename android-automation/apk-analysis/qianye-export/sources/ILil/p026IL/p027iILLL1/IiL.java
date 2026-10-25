package ILil.p026IL.p027iILLL1;

import ILil.p026IL.I1I;
import ILil.p026IL.ILil;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: ILil.I丨L.iI丨LLL1.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends Drawable {

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static IL1Iii f1582lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static final double f1583llL1ii = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Paint f3991I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final int f3992IL1Iii;
    public ColorStateList ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final int f1584ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final RectF f3994Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Paint f1585IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public float f1586IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public float f1588L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Path f1589iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final int f1590lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public float f1591lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public float f1592il;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f1587Ll1 = true;
    public boolean Lil = true;
    public boolean LlLI1 = false;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Paint f3993ILil = new Paint(5);

    /* JADX INFO: renamed from: ILil.I丨L.iI丨LLL1.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
    public interface IL1Iii {
        void IL1Iii(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public IiL(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f1590lIiI = resources.getColor(ILil.cardview_shadow_start_color);
        this.f1584ILl = resources.getColor(ILil.cardview_shadow_end_color);
        this.f3992IL1Iii = resources.getDimensionPixelSize(I1I.cardview_compat_inset_shadow);
        m1997ILl(colorStateList);
        Paint paint = new Paint(5);
        this.f3991I1I = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1591lLi1LL = (int) (f + 0.5f);
        this.f3994Ilil = new RectF();
        Paint paint2 = new Paint(this.f3991I1I);
        this.f1585IL = paint2;
        paint2.setAntiAlias(false);
        iIi1(f2, f3);
    }

    public static float I1I(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f1583llL1ii) * ((double) f2))) : f;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static float m1996IL(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f1583llL1ii) * ((double) f2))) : f * 1.5f;
    }

    public final void IL1Iii(Rect rect) {
        float f = this.f1586IiL;
        float f2 = 1.5f * f;
        this.f3994Ilil.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        ILil();
    }

    public float ILL() {
        float f = this.f1586IiL;
        return (Math.max(f, this.f1591lLi1LL + this.f3992IL1Iii + (f / 2.0f)) * 2.0f) + ((this.f1586IiL + this.f3992IL1Iii) * 2.0f);
    }

    public final void ILil() {
        float f = this.f1591lLi1LL;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f1588L11I;
        rectF2.inset(-f2, -f2);
        Path path = this.f1589iILLL1;
        if (path == null) {
            this.f1589iILLL1 = new Path();
        } else {
            path.reset();
        }
        this.f1589iILLL1.setFillType(Path.FillType.EVEN_ODD);
        this.f1589iILLL1.moveTo(-this.f1591lLi1LL, 0.0f);
        this.f1589iILLL1.rLineTo(-this.f1588L11I, 0.0f);
        this.f1589iILLL1.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1589iILLL1.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1589iILLL1.close();
        float f3 = this.f1591lLi1LL;
        float f4 = f3 / (this.f1588L11I + f3);
        Paint paint = this.f3991I1I;
        float f5 = this.f1591lLi1LL + this.f1588L11I;
        int i = this.f1590lIiI;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f1584ILl}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1585IL;
        float f6 = this.f1591lLi1LL;
        float f7 = this.f1588L11I;
        int i2 = this.f1590lIiI;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f1584ILl}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1585IL.setAntiAlias(false);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m1997ILl(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.ILL = colorStateList;
        this.f3993ILil.setColor(colorStateList.getColorForState(getState(), this.ILL.getDefaultColor()));
    }

    public final void Ilil(Canvas canvas) {
        float f = this.f1591lLi1LL;
        float f2 = (-f) - this.f1588L11I;
        float f3 = f + this.f3992IL1Iii + (this.f1592il / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f3994Ilil.width() - f4 > 0.0f;
        boolean z2 = this.f3994Ilil.height() - f4 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f3994Ilil;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.f1589iILLL1, this.f3991I1I);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f3994Ilil.width() - f4, -this.f1591lLi1LL, this.f1585IL);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f3994Ilil;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1589iILLL1, this.f3991I1I);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f3994Ilil.width() - f4, (-this.f1591lLi1LL) + this.f1588L11I, this.f1585IL);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f3994Ilil;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1589iILLL1, this.f3991I1I);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f3994Ilil.height() - f4, -this.f1591lLi1LL, this.f1585IL);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f3994Ilil;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1589iILLL1, this.f3991I1I);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f3994Ilil.height() - f4, -this.f1591lLi1LL, this.f1585IL);
        }
        canvas.restoreToCount(iSave4);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1998IiL(Rect rect) {
        getPadding(rect);
    }

    public void Lil(ColorStateList colorStateList) {
        m1997ILl(colorStateList);
        invalidateSelf();
    }

    public void LlLI1(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (f + 0.5f);
        if (this.f1591lLi1LL == f2) {
            return;
        }
        this.f1591lLi1LL = f2;
        this.f1587Ll1 = true;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public float m1999Ll1() {
        return this.f1592il;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public float m2000L11I() {
        return this.f1586IiL;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1587Ll1) {
            IL1Iii(getBounds());
            this.f1587Ll1 = false;
        }
        canvas.translate(0.0f, this.f1592il / 2.0f);
        Ilil(canvas);
        canvas.translate(0.0f, (-this.f1592il) / 2.0f);
        f1582lIlii.IL1Iii(canvas, this.f3994Ilil, this.f1591lLi1LL, this.f3993ILil);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(m1996IL(this.f1586IiL, this.f1591lLi1LL, this.Lil));
        int iCeil2 = (int) Math.ceil(I1I(this.f1586IiL, this.f1591lLi1LL, this.Lil));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public final void iIi1(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fIIlLiL = iIlLiL(f);
        float fIIlLiL2 = iIlLiL(f2);
        if (fIIlLiL > fIIlLiL2) {
            if (!this.LlLI1) {
                this.LlLI1 = true;
            }
            fIIlLiL = fIIlLiL2;
        }
        if (this.f1592il == fIIlLiL && this.f1586IiL == fIIlLiL2) {
            return;
        }
        this.f1592il = fIIlLiL;
        this.f1586IiL = fIIlLiL2;
        this.f1588L11I = (int) ((fIIlLiL * 1.5f) + this.f3992IL1Iii + 0.5f);
        this.f1587Ll1 = true;
        invalidateSelf();
    }

    public final int iIlLiL(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public float m2001iILLL1() {
        return this.f1591lLi1LL;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.ILL;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m2002lIiI(boolean z) {
        this.Lil = z;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m2003lIlii(float f) {
        iIi1(f, this.f1586IiL);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m2004llL1ii(float f) {
        iIi1(this.f1592il, f);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ColorStateList m2005lLi1LL() {
        return this.ILL;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1587Ll1 = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.ILL;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f3993ILil.getColor() == colorForState) {
            return false;
        }
        this.f3993ILil.setColor(colorForState);
        this.f1587Ll1 = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3993ILil.setAlpha(i);
        this.f3991I1I.setAlpha(i);
        this.f1585IL.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3993ILil.setColorFilter(colorFilter);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public float m2006il() {
        float f = this.f1586IiL;
        return (Math.max(f, this.f1591lLi1LL + this.f3992IL1Iii + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f1586IiL * 1.5f) + this.f3992IL1Iii) * 2.0f);
    }
}
