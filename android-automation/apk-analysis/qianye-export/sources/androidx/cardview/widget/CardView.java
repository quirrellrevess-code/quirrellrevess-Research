package androidx.cardview.widget;

import ILil.p026IL.p027iILLL1.I1I;
import ILil.p026IL.p027iILLL1.IL;
import ILil.p026IL.p027iILLL1.ILil;
import ILil.p026IL.p027iILLL1.lLi1LL;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private static final lLi1LL IMPL;
    private final IL mCardViewDelegate;
    private boolean mCompatPadding;
    public final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    public final Rect mShadowBounds;
    public int mUserSetMinHeight;
    public int mUserSetMinWidth;

    public class IL1Iii implements IL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Drawable f4923IL1Iii;

        public IL1Iii() {
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        public boolean I1I() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        public void IL1Iii(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.mUserSetMinWidth) {
                CardView.super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.mUserSetMinHeight) {
                CardView.super.setMinimumHeight(i2);
            }
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        public void ILil(Drawable drawable) {
            this.f4923IL1Iii = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        public Drawable Ilil() {
            return this.f4923IL1Iii;
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        /* JADX INFO: renamed from: I丨L */
        public boolean mo1994IL() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        /* JADX INFO: renamed from: l丨Li1LL */
        public View mo1995lLi1LL() {
            return CardView.this;
        }

        @Override // ILil.p026IL.p027iILLL1.IL
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            CardView.this.mShadowBounds.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.mContentPadding;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new ILil();
        } else if (i >= 17) {
            IMPL = new ILil.p026IL.p027iILLL1.IL1Iii();
        } else {
            IMPL = new I1I();
        }
        IMPL.mo1993il();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.mo1986IiL(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.I1I(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.mo1989iILLL1(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.mo1985IL(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        lLi1LL lli1ll = IMPL;
        if (lli1ll instanceof ILil) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(lli1ll.mo1987Ll1(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(lli1ll.ILL(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.mo1984ILl(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f) {
        IMPL.mo1992lLi1LL(this.mCardViewDelegate, f);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.mo1988L11I(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.Lil(this.mCardViewDelegate, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.mo1990lIiI(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f) {
        IMPL.ILil(this.mCardViewDelegate, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.Ilil(this.mCardViewDelegate);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.p026IL.IL1Iii.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.mo1984ILl(this.mCardViewDelegate, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        IL1Iii iL1Iii = new IL1Iii();
        this.mCardViewDelegate = iL1Iii;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILil.p026IL.lLi1LL.CardView, i, ILil.p026IL.IL.CardView);
        int i2 = ILil.p026IL.lLi1LL.CardView_cardBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(ILil.p026IL.ILil.cardview_light_background);
            } else {
                color = getResources().getColor(ILil.p026IL.ILil.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(ILil.p026IL.lLi1LL.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(ILil.p026IL.lLi1LL.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(ILil.p026IL.lLi1LL.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = typedArrayObtainStyledAttributes.getBoolean(ILil.p026IL.lLi1LL.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = typedArrayObtainStyledAttributes.getBoolean(ILil.p026IL.lLi1LL.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILil.p026IL.lLi1LL.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        IMPL.IL1Iii(iL1Iii, context, colorStateList, dimension, dimension2, f);
    }
}
