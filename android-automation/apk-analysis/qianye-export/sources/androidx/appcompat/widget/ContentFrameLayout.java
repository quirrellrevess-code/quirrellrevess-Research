package androidx.appcompat.widget;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public TypedValue f4873I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public TypedValue f4874ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public TypedValue f4875Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public TypedValue f2410IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final Rect f2411IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public IL1Iii f2412L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public TypedValue f2413iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public TypedValue f2414lLi1LL;

    public interface IL1Iii {
        void IL1Iii();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void IL1Iii(Rect rect) {
        fitSystemWindows(rect);
    }

    public void ILil(int i, int i2, int i3, int i4) {
        this.f2411IiL.set(i, i2, i3, i4);
        if (iIlLiL.m2103LlIl(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2414lLi1LL == null) {
            this.f2414lLi1LL = new TypedValue();
        }
        return this.f2414lLi1LL;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2413iILLL1 == null) {
            this.f2413iILLL1 = new TypedValue();
        }
        return this.f2413iILLL1;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2410IL == null) {
            this.f2410IL = new TypedValue();
        }
        return this.f2410IL;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f4875Ilil == null) {
            this.f4875Ilil = new TypedValue();
        }
        return this.f4875Ilil;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f4874ILil == null) {
            this.f4874ILil = new TypedValue();
        }
        return this.f4874ILil;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f4873I1I == null) {
            this.f4873I1I = new TypedValue();
        }
        return this.f4873I1I;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IL1Iii iL1Iii = this.f2412L11I;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IL1Iii iL1Iii = this.f2412L11I;
        if (iL1Iii != null) {
            iL1Iii.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        float fraction;
        int i5;
        int i6;
        float fraction2;
        int i7;
        int i8;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            z = false;
        } else {
            TypedValue typedValue = z3 ? this.f4875Ilil : this.f2410IL;
            if (typedValue == null || (i7 = typedValue.type) == 0) {
                z = false;
            } else {
                if (i7 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i7 == 6) {
                        int i9 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i9, i9);
                    } else {
                        i8 = 0;
                    }
                    if (i8 > 0) {
                        Rect rect = this.f2411IiL;
                        i = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect.left + rect.right), View.MeasureSpec.getSize(i)), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                        z = true;
                    } else {
                        z = false;
                    }
                }
                i8 = (int) fraction3;
                if (i8 > 0) {
                    Rect rect2 = this.f2411IiL;
                    i = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect2.left + rect2.right), View.MeasureSpec.getSize(i)), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.f2414lLi1LL : this.f2413iILLL1;
            if (typedValue2 != null && (i5 = typedValue2.type) != 0) {
                if (i5 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i5 == 6) {
                        int i10 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i10, i10);
                    } else {
                        i6 = 0;
                    }
                    if (i6 > 0) {
                        Rect rect3 = this.f2411IiL;
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i6 - (rect3.top + rect3.bottom), View.MeasureSpec.getSize(i2)), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                    }
                }
                i6 = (int) fraction2;
                if (i6 > 0) {
                    Rect rect4 = this.f2411IiL;
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i6 - (rect4.top + rect4.bottom), View.MeasureSpec.getSize(i2)), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                }
            }
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        if (z || mode != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            TypedValue typedValue3 = z3 ? this.f4873I1I : this.f4874ILil;
            if (typedValue3 == null || (i3 = typedValue3.type) == 0) {
                z2 = false;
            } else {
                if (i3 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i3 == 6) {
                        int i11 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i11, i11);
                    } else {
                        i4 = 0;
                    }
                    if (i4 > 0) {
                        Rect rect5 = this.f2411IiL;
                        i4 -= rect5.left + rect5.right;
                    }
                    if (measuredWidth < i4) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                    } else {
                        z2 = false;
                    }
                }
                i4 = (int) fraction;
                if (i4 > 0) {
                    Rect rect6 = this.f2411IiL;
                    i4 -= rect6.left + rect6.right;
                }
                if (measuredWidth < i4) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                } else {
                    z2 = false;
                }
            }
        }
        if (z2) {
            super.onMeasure(iMakeMeasureSpec, i2);
        }
    }

    public void setAttachListener(IL1Iii iL1Iii) {
        this.f2412L11I = iL1Iii;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2411IiL = new Rect();
    }
}
