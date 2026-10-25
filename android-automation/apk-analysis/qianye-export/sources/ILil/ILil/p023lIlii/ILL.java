package ILil.ILil.p023lIlii;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p033iILLL1.ILL.IL1Iii;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL extends C0626il {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Drawable f3757Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final SeekBar f1347IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1348IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f1349L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public PorterDuff.Mode f1350iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ColorStateList f1351lLi1LL;

    public ILL(SeekBar seekBar) {
        super(seekBar);
        this.f1351lLi1LL = null;
        this.f1350iILLL1 = null;
        this.f1348IiL = false;
        this.f1349L11I = false;
        this.f1347IL = seekBar;
    }

    @Override // ILil.ILil.p023lIlii.C0626il
    public void I1I(AttributeSet attributeSet, int i) {
        super.I1I(attributeSet, i);
        llI lliI11li1 = llI.I11li1(this.f1347IL.getContext(), attributeSet, ILil.ILil.ILL.AppCompatSeekBar, i, 0);
        Drawable drawableM1824IiL = lliI11li1.m1824IiL(ILil.ILil.ILL.AppCompatSeekBar_android_thumb);
        if (drawableM1824IiL != null) {
            this.f1347IL.setThumb(drawableM1824IiL);
        }
        m1714il(lliI11li1.m1827iILLL1(ILil.ILil.ILL.AppCompatSeekBar_tickMark));
        int i2 = ILil.ILil.ILL.AppCompatSeekBar_tickMarkTintMode;
        if (lliI11li1.m1829lIlii(i2)) {
            this.f1350iILLL1 = llL1ii.Ilil(lliI11li1.ILL(i2, -1), this.f1350iILLL1);
            this.f1349L11I = true;
        }
        int i3 = ILil.ILil.ILL.AppCompatSeekBar_tickMarkTint;
        if (lliI11li1.m1829lIlii(i3)) {
            this.f1351lLi1LL = lliI11li1.I1I(i3);
            this.f1348IiL = true;
        }
        lliI11li1.m1833lL();
        m1713lLi1LL();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1710IiL() {
        Drawable drawable = this.f3757Ilil;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1347IL.getDrawableState())) {
            this.f1347IL.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1711L11I() {
        Drawable drawable = this.f3757Ilil;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1712iILLL1(Canvas canvas) {
        if (this.f3757Ilil != null) {
            int max = this.f1347IL.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f3757Ilil.getIntrinsicWidth();
                int intrinsicHeight = this.f3757Ilil.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f3757Ilil.setBounds(-i, -i2, i, i2);
                float width = ((this.f1347IL.getWidth() - this.f1347IL.getPaddingLeft()) - this.f1347IL.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1347IL.getPaddingLeft(), this.f1347IL.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f3757Ilil.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1713lLi1LL() {
        Drawable drawable = this.f3757Ilil;
        if (drawable != null) {
            if (this.f1348IiL || this.f1349L11I) {
                Drawable drawableM2256lIlii = IL1Iii.m2256lIlii(drawable.mutate());
                this.f3757Ilil = drawableM2256lIlii;
                if (this.f1348IiL) {
                    IL1Iii.Lil(drawableM2256lIlii, this.f1351lLi1LL);
                }
                if (this.f1349L11I) {
                    IL1Iii.LlLI1(this.f3757Ilil, this.f1350iILLL1);
                }
                if (this.f3757Ilil.isStateful()) {
                    this.f3757Ilil.setState(this.f1347IL.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1714il(Drawable drawable) {
        Drawable drawable2 = this.f3757Ilil;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3757Ilil = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1347IL);
            IL1Iii.m2255lIiI(drawable, iIlLiL.m2134l(this.f1347IL));
            if (drawable.isStateful()) {
                drawable.setState(this.f1347IL.getDrawableState());
            }
            m1713lLi1LL();
        }
        this.f1347IL.invalidate();
    }
}
