package ILil.p028IiL.p033iILLL1.ILL;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.ILL.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: WrappedDrawableApi14.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends Drawable implements Drawable.Callback, I1I, ILil {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final PorterDuff.Mode f1707IiL = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public PorterDuff.Mode f4177I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4178ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public iILLL1 f4179Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f1708IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Drawable f1709iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1710lLi1LL;

    public IL(iILLL1 iilll1, Resources resources) {
        this.f4179Ilil = iilll1;
        Ilil(resources);
    }

    public boolean I1I() {
        return true;
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.I1I
    public final void IL1Iii(Drawable drawable) {
        Drawable drawable2 = this.f1709iILLL1;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1709iILLL1 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            iILLL1 iilll1 = this.f4179Ilil;
            if (iilll1 != null) {
                iilll1.f4182ILil = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.I1I
    public final Drawable ILil() {
        return this.f1709iILLL1;
    }

    public final void Ilil(Resources resources) {
        Drawable.ConstantState constantState;
        iILLL1 iilll1 = this.f4179Ilil;
        if (iilll1 == null || (constantState = iilll1.f4182ILil) == null) {
            return;
        }
        IL1Iii(constantState.newDrawable(resources));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final iILLL1 m2260IL() {
        return new iILLL1(this.f4179Ilil);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1709iILLL1.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        iILLL1 iilll1 = this.f4179Ilil;
        return changingConfigurations | (iilll1 != null ? iilll1.getChangingConfigurations() : 0) | this.f1709iILLL1.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        iILLL1 iilll1 = this.f4179Ilil;
        if (iilll1 == null || !iilll1.IL1Iii()) {
            return null;
        }
        this.f4179Ilil.f4181IL1Iii = getChangingConfigurations();
        return this.f4179Ilil;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1709iILLL1.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1709iILLL1.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1709iILLL1.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1709iILLL1.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1709iILLL1.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1709iILLL1.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1709iILLL1.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1709iILLL1.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1709iILLL1.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1709iILLL1.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        iILLL1 iilll1;
        ColorStateList colorStateList = (!I1I() || (iilll1 = this.f4179Ilil) == null) ? null : iilll1.f4180I1I;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1709iILLL1.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1709iILLL1.jumpToCurrentState();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m2261lLi1LL(int[] iArr) {
        if (!I1I()) {
            return false;
        }
        iILLL1 iilll1 = this.f4179Ilil;
        ColorStateList colorStateList = iilll1.f4180I1I;
        PorterDuff.Mode mode = iilll1.f1711IL;
        if (colorStateList == null || mode == null) {
            this.f1708IL = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f1708IL || colorForState != this.f4178ILil || mode != this.f4177I1I) {
                setColorFilter(colorForState, mode);
                this.f4178ILil = colorForState;
                this.f4177I1I = mode;
                this.f1708IL = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1710lLi1LL && super.mutate() == this) {
            this.f4179Ilil = m2260IL();
            Drawable drawable = this.f1709iILLL1;
            if (drawable != null) {
                drawable.mutate();
            }
            iILLL1 iilll1 = this.f4179Ilil;
            if (iilll1 != null) {
                Drawable drawable2 = this.f1709iILLL1;
                iilll1.f4182ILil = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1710lLi1LL = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1709iILLL1;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f1709iILLL1.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1709iILLL1.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f1709iILLL1.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f1709iILLL1.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1709iILLL1.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1709iILLL1.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1709iILLL1.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m2261lLi1LL(iArr) || this.f1709iILLL1.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintList(ColorStateList colorStateList) {
        this.f4179Ilil.f4180I1I = colorStateList;
        m2261lLi1LL(getState());
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4179Ilil.f1711IL = mode;
        m2261lLi1LL(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1709iILLL1.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public IL(Drawable drawable) {
        this.f4179Ilil = m2260IL();
        IL1Iii(drawable);
    }
}
