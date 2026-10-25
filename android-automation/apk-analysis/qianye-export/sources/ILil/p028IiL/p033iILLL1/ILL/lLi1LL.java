package ILil.p028IiL.p033iILLL1.ILL;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.ILL.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: WrappedDrawableApi21.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL extends IL {

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static Method f1712L11I;

    public lLi1LL(Drawable drawable) {
        super(drawable);
        m2262iILLL1();
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.IL
    public boolean I1I() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f1709iILLL1;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f1709iILLL1.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f1709iILLL1.getOutline(outline);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2262iILLL1() {
        if (f1712L11I == null) {
            try {
                f1712L11I = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f1709iILLL1;
        if (drawable != null && (method = f1712L11I) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.f1709iILLL1.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f1709iILLL1.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.IL, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.IL, android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTint(int i) {
        if (I1I()) {
            super.setTint(i);
        } else {
            this.f1709iILLL1.setTint(i);
        }
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.IL, android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintList(ColorStateList colorStateList) {
        if (I1I()) {
            super.setTintList(colorStateList);
        } else {
            this.f1709iILLL1.setTintList(colorStateList);
        }
    }

    @Override // ILil.p028IiL.p033iILLL1.ILL.IL, android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintMode(PorterDuff.Mode mode) {
        if (I1I()) {
            super.setTintMode(mode);
        } else {
            this.f1709iILLL1.setTintMode(mode);
        }
    }

    public lLi1LL(iILLL1 iilll1, Resources resources) {
        super(iilll1, resources);
        m2262iILLL1();
    }
}
