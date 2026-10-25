package androidx.appcompat.view.menu;

import ILil.ILil.ILL;
import ILil.ILil.p023lIlii.L1l;
import ILil.ILil.p023lIlii.iIlLiL;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.Lil;
import ILil.ILil.p024llL1ii.ILL.llL1ii;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements Lil.IL1Iii, View.OnClickListener, ActionMenuView.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public CharSequence f4807I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public C0629il f4808ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public IiL.ILil f4809Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Drawable f2313IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2314IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2315Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2316L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ILil f2317iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public iIlLiL f2318lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f2319il;

    public class IL1Iii extends iIlLiL {
        public IL1Iii() {
            super(ActionMenuItemView.this);
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        public boolean I1I() {
            llL1ii lll1iiILil;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            IiL.ILil iLil = actionMenuItemView.f4809Ilil;
            return iLil != null && iLil.IL1Iii(actionMenuItemView.f4808ILil) && (lll1iiILil = ILil()) != null && lll1iiILil.IL1Iii();
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        public llL1ii ILil() {
            ILil iLil = ActionMenuItemView.this.f2317iILLL1;
            if (iLil != null) {
                return iLil.IL1Iii();
            }
            return null;
        }
    }

    public static abstract class ILil {
        public abstract llL1ii IL1Iii();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public boolean I1I() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.ActionMenuView.IL1Iii
    public boolean IL1Iii() {
        return I1I();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.IL1Iii
    public boolean ILil() {
        return I1I() && this.f4808ILil.getIcon() == null;
    }

    public final void Ilil() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f4807I1I);
        if (this.f2313IL != null && (!this.f4808ILil.m1907lIII() || (!this.f2314IiL && !this.f2316L11I))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f4807I1I : null);
        CharSequence contentDescription = this.f4808ILil.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f4808ILil.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f4808ILil.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            L1l.IL1Iii(this, z3 ? null : this.f4808ILil.getTitle());
        } else {
            L1l.IL1Iii(this, tooltipText);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final boolean m3044IL() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public C0629il getItemData() {
        return this.f4808ILil;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public void initialize(C0629il c0629il, int i) {
        this.f4808ILil = c0629il;
        setIcon(c0629il.getIcon());
        setTitle(c0629il.m1903L11I(this));
        setId(c0629il.getItemId());
        setVisibility(c0629il.isVisible() ? 0 : 8);
        setEnabled(c0629il.isEnabled());
        if (c0629il.hasSubMenu() && this.f2318lLi1LL == null) {
            this.f2318lLi1LL = new IL1Iii();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IiL.ILil iLil = this.f4809Ilil;
        if (iLil != null) {
            iLil.IL1Iii(this.f4808ILil);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2314IiL = m3044IL();
        Ilil();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean zI1I = I1I();
        if (zI1I && (i3 = this.ILL) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f2319il) : this.f2319il;
        if (mode != 1073741824 && this.f2319il > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, Videoio.CAP_OPENNI_IMAGE_GENERATOR), i2);
        }
        if (zI1I || this.f2313IL == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2313IL.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        iIlLiL iillil;
        if (this.f4808ILil.hasSubMenu() && (iillil = this.f2318lLi1LL) != null && iillil.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f2316L11I != z) {
            this.f2316L11I = z;
            C0629il c0629il = this.f4808ILil;
            if (c0629il != null) {
                c0629il.I1I();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2313IL = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f2315Ll1;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        Ilil();
    }

    public void setItemInvoker(IiL.ILil iLil) {
        this.f4809Ilil = iLil;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.ILL = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(ILil iLil) {
        this.f2317iILLL1 = iLil;
    }

    public void setTitle(CharSequence charSequence) {
        this.f4807I1I = charSequence;
        Ilil();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f2314IiL = m3044IL();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.ActionMenuItemView, i, 0);
        this.f2319il = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILL.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f2315Ll1 = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.ILL = -1;
        setSaveEnabled(false);
    }
}
