package androidx.appcompat.widget;

import ILil.ILil.ILL;
import ILil.ILil.iILLL1;
import ILil.ILil.p023lIlii.C1;
import ILil.ILil.p023lIlii.ILil;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import org.opencv.calib3d.Calib3d;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public View f4815I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f4816ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public View f4817Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public View f2332IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Drawable f2333IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2334L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Drawable f2335iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Drawable f2336lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2337il;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public final int IL1Iii(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean ILil(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2336lLi1LL;
        if (drawable != null && drawable.isStateful()) {
            this.f2336lLi1LL.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2335iILLL1;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2335iILLL1.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2333IiL;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2333IiL.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f4815I1I;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2336lLi1LL;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2335iILLL1;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2333IiL;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2332IL = findViewById(iILLL1.action_bar);
        this.f4817Ilil = findViewById(iILLL1.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4816ILil || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f4815I1I;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i5 = layoutParams.bottomMargin;
            view.layout(i, measuredHeight2 - i5, i3, measuredHeight - i5);
        }
        if (this.f2334L11I) {
            Drawable drawable2 = this.f2333IiL;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f2336lLi1LL != null) {
                if (this.f2332IL.getVisibility() == 0) {
                    this.f2336lLi1LL.setBounds(this.f2332IL.getLeft(), this.f2332IL.getTop(), this.f2332IL.getRight(), this.f2332IL.getBottom());
                } else {
                    View view2 = this.f4817Ilil;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f2336lLi1LL.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2336lLi1LL.setBounds(this.f4817Ilil.getLeft(), this.f4817Ilil.getTop(), this.f4817Ilil.getRight(), this.f4817Ilil.getBottom());
                    }
                }
                z3 = true;
            }
            this.f2337il = z4;
            if (!z4 || (drawable = this.f2335iILLL1) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iIL1Iii;
        int i3;
        if (this.f2332IL == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.ILL) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f2332IL == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f4815I1I;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (ILil(this.f2332IL)) {
            iIL1Iii = !ILil(this.f4817Ilil) ? IL1Iii(this.f4817Ilil) : 0;
        } else {
            iIL1Iii = IL1Iii(this.f2332IL);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iIL1Iii + IL1Iii(this.f4815I1I), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2336lLi1LL;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2336lLi1LL);
        }
        this.f2336lLi1LL = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2332IL;
            if (view != null) {
                this.f2336lLi1LL.setBounds(view.getLeft(), this.f2332IL.getTop(), this.f2332IL.getRight(), this.f2332IL.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2334L11I ? this.f2336lLi1LL != null || this.f2335iILLL1 != null : this.f2333IiL != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2333IiL;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2333IiL);
        }
        this.f2333IiL = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2334L11I && (drawable2 = this.f2333IiL) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2334L11I ? !(this.f2336lLi1LL != null || this.f2335iILLL1 != null) : this.f2333IiL == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2335iILLL1;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2335iILLL1);
        }
        this.f2335iILLL1 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2337il && (drawable2 = this.f2335iILLL1) != null) {
                drawable2.setBounds(this.f4815I1I.getLeft(), this.f4815I1I.getTop(), this.f4815I1I.getRight(), this.f4815I1I.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2334L11I ? this.f2336lLi1LL != null || this.f2335iILLL1 != null : this.f2333IiL != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(C1 c1) {
        View view = this.f4815I1I;
        if (view != null) {
            removeView(view);
        }
        this.f4815I1I = c1;
        if (c1 != null) {
            addView(c1);
            ViewGroup.LayoutParams layoutParams = c1.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            c1.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f4816ILil = z;
        setDescendantFocusability(z ? 393216 : Calib3d.CALIB_TILTED_MODEL);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f2336lLi1LL;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f2335iILLL1;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f2333IiL;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f2336lLi1LL && !this.f2334L11I) || (drawable == this.f2335iILLL1 && this.f2337il) || ((drawable == this.f2333IiL && this.f2334L11I) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        iIlLiL.ill1LI1l(this, new ILil(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.ActionBar);
        this.f2336lLi1LL = typedArrayObtainStyledAttributes.getDrawable(ILL.ActionBar_background);
        this.f2335iILLL1 = typedArrayObtainStyledAttributes.getDrawable(ILL.ActionBar_backgroundStacked);
        this.ILL = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILL.ActionBar_height, -1);
        boolean z = true;
        if (getId() == iILLL1.split_action_bar) {
            this.f2334L11I = true;
            this.f2333IiL = typedArrayObtainStyledAttributes.getDrawable(ILL.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2334L11I ? this.f2336lLi1LL != null || this.f2335iILLL1 != null : this.f2333IiL != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
