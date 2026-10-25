package com.maning.mndialoglibrary.view;

import I1I.p014IL.IL1Iii.lLi1LL;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes.dex */
public class MNHudCircularProgressBar extends View {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public float f5379I1I;
    public Paint ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float f5380ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public float f5381Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public float f2910IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public long f2911IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Paint f2912Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2913L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2914iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2915lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public RectF f2916il;

    public class IL1Iii implements ValueAnimator.AnimatorUpdateListener {
        public IL1Iii() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MNHudCircularProgressBar.this.f5380ILil = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MNHudCircularProgressBar.this.postInvalidate();
        }
    }

    public MNHudCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5380ILil = 0.0f;
        this.f5379I1I = 0.0f;
        this.f2910IL = 10.0f;
        this.f5381Ilil = 10.0f;
        this.f2915lLi1LL = WebView.NIGHT_MODE_COLOR;
        this.f2914iILLL1 = -7829368;
        this.f2911IiL = 300L;
        this.f2913L11I = -90;
        ILil(context, attributeSet);
    }

    public void I1I(float f, boolean z) {
        this.f5380ILil = f <= 100.0f ? f : 100.0f;
        if (!z) {
            invalidate();
        } else {
            Ilil();
            this.f5379I1I = f;
        }
    }

    public final void ILil(Context context, AttributeSet attributeSet) {
        this.f2916il = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, lLi1LL.MNHudCircularProgressBar, 0, 0);
        try {
            this.f5380ILil = typedArrayObtainStyledAttributes.getFloat(lLi1LL.MNHudCircularProgressBar_mn_progress, this.f5380ILil);
            this.f2910IL = typedArrayObtainStyledAttributes.getDimension(lLi1LL.MNHudCircularProgressBar_mn_progressbar_width, this.f2910IL);
            this.f5381Ilil = typedArrayObtainStyledAttributes.getDimension(lLi1LL.MNHudCircularProgressBar_mn_background_progressbar_width, this.f5381Ilil);
            this.f2915lLi1LL = typedArrayObtainStyledAttributes.getInt(lLi1LL.MNHudCircularProgressBar_mn_progressbar_color, this.f2915lLi1LL);
            this.f2914iILLL1 = typedArrayObtainStyledAttributes.getInt(lLi1LL.MNHudCircularProgressBar_mn_background_progressbar_color, this.f2914iILLL1);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.ILL = paint;
            paint.setColor(this.f2914iILLL1);
            this.ILL.setStyle(Paint.Style.STROKE);
            this.ILL.setStrokeWidth(this.f5381Ilil);
            Paint paint2 = new Paint(1);
            this.f2912Ll1 = paint2;
            paint2.setColor(this.f2915lLi1LL);
            this.f2912Ll1.setStyle(Paint.Style.STROKE);
            this.f2912Ll1.setStrokeWidth(this.f2910IL);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void Ilil() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f5379I1I, this.f5380ILil);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.setDuration(this.f2911IiL);
        valueAnimatorOfFloat.addUpdateListener(new IL1Iii());
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3490IL(float f, int i) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", f);
        objectAnimatorOfFloat.setDuration(i);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.start();
    }

    public int getBackgroundColor() {
        return this.f2914iILLL1;
    }

    public float getBackgroundProgressBarWidth() {
        return this.f5381Ilil;
    }

    public int getColor() {
        return this.f2915lLi1LL;
    }

    public float getProgress() {
        return this.f5380ILil;
    }

    public float getProgressBarWidth() {
        return this.f2910IL;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.f2916il, this.ILL);
        canvas.drawArc(this.f2916il, this.f2913L11I, (this.f5380ILil * 360.0f) / 100.0f, false, this.f2912Ll1);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int iMin = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(iMin, iMin);
        float f = this.f2910IL;
        float f2 = this.f5381Ilil;
        if (f <= f2) {
            f = f2;
        }
        float f3 = f / 2.0f;
        float f4 = 0.0f + f3;
        float f5 = iMin - f3;
        this.f2916il.set(f4, f4, f5, f5);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f2914iILLL1 = i;
        this.ILL.setColor(i);
        invalidate();
        requestLayout();
    }

    public void setBackgroundProgressBarWidth(float f) {
        this.f5381Ilil = f;
        this.ILL.setStrokeWidth(f);
        requestLayout();
        invalidate();
    }

    public void setColor(int i) {
        this.f2915lLi1LL = i;
        this.f2912Ll1.setColor(i);
        invalidate();
        requestLayout();
    }

    public void setProgress(float f) {
        I1I(f, true);
    }

    public void setProgressBarWidth(float f) {
        this.f2910IL = f;
        this.f2912Ll1.setStrokeWidth(f);
        requestLayout();
        invalidate();
    }

    public void setProgressWithAnimation(float f) {
        m3490IL(f, 1500);
    }
}
