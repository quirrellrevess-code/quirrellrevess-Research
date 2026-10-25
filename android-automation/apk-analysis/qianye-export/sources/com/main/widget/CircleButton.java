package com.main.widget;

import I1I.IL1Iii;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes.dex */
public class CircleButton extends ImageView {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f5372I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5373ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public Typeface f2898ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5374Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2899IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Paint f2900IiL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public String f2901Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public float f2902L11I;
    public ObjectAnimator iIi1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Paint f2903iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f2904lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public Context f2905lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public Drawable f2906llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Paint f2907lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f2908il;

    public CircleButton(Context context) {
        super(context);
        this.ILL = WebView.NIGHT_MODE_COLOR;
        this.f2901Ll1 = IL1Iii.IL1Iii(new byte[]{81, 84, 84, 81, 67, 88, 65}, IL1Iii.IL1Iii(new byte[]{81, 8, 84, 8, 5, 86}, IL1Iii.IL1Iii(new byte[]{80, 11, 86, 89, 80, 4}, "420acf")));
        this.f2904lIiI = WebView.NIGHT_MODE_COLOR;
        this.f2898ILl = Typeface.DEFAULT;
        this.Lil = 12;
        I1I(context, null);
    }

    public final void I1I(Context context, AttributeSet attributeSet) {
        setFocusable(true);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f2905lIlii = context;
        setClickable(true);
        Paint paint = new Paint(1);
        this.f2907lLi1LL = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f2903iILLL1 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f2900IiL = new Paint(1);
        this.f2908il = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        int color = WebView.NIGHT_MODE_COLOR;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I1I.p062Ilil.p013IL.IL1Iii.CircleButton);
            color = typedArrayObtainStyledAttributes.getColor(0, WebView.NIGHT_MODE_COLOR);
            this.f2908il = (int) typedArrayObtainStyledAttributes.getDimension(1, this.f2908il);
            this.f2901Ll1 = typedArrayObtainStyledAttributes.getString(2);
            this.Lil = (int) typedArrayObtainStyledAttributes.getDimension(4, this.Lil);
            this.f2904lIiI = typedArrayObtainStyledAttributes.getColor(3, this.f2904lIiI);
            typedArrayObtainStyledAttributes.recycle();
        }
        float f = context.getResources().getDisplayMetrics().density;
        Log.e(IL1Iii.IL1Iii(new byte[]{109, 122, 116, 33, 98, 107, 108, 117, 126, 32}, IL1Iii.IL1Iii(new byte[]{90, 0, 83, 81, 3, 0}, IL1Iii.IL1Iii(new byte[]{80, 87, 5, 0, 3, 89}, "2cf50a"))), IL1Iii.IL1Iii(new byte[]{65, 82, 26, 18, 55, 80, 79, 82, 88}, IL1Iii.IL1Iii(new byte[]{81, 2, 0, 87, 2, 0}, IL1Iii.IL1Iii(new byte[]{92, 12, 83, 2, 0, 0}, "8913f9"))) + this.Lil + IL1Iii.IL1Iii(new byte[]{70, 74, 90, 3, 95, 0, 92}, IL1Iii.IL1Iii(new byte[]{2, 11, 90, 83, 11, 3}, IL1Iii.IL1Iii(new byte[]{7, 7, 80, 9, 91, 81}, "c538c7"))) + f);
        set_bg_color(color);
        m3489IL();
        this.f2903iILLL1.setStrokeWidth((float) this.f2908il);
        int integer = getResources().getInteger(R.integer.config_shortAnimTime);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, IL1Iii.IL1Iii(new byte[]{82, 93, 91, 89, 7, 17, 90, 92, 92, 100, 20, 10, 84, 65, 87, 71, 21}, IL1Iii.IL1Iii(new byte[]{10, 87, 7, 2, 7, 84}, IL1Iii.IL1Iii(new byte[]{12, 86, 4, 83, 4, 80}, "521eea"))), 0.0f, 0.0f);
        this.iIi1 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(integer);
    }

    public final int IL1Iii(int i, int i2) {
        return Color.argb(Math.min(255, Color.alpha(i)), Math.min(255, Color.red(i) + i2), Math.min(255, Color.green(i) + i2), Math.min(255, Color.blue(i) + i2));
    }

    public final void ILil() {
        this.iIi1.setFloatValues(this.f2908il, 0.0f);
        this.iIi1.start();
    }

    public final void Ilil() {
        this.iIi1.setFloatValues(this.f2902L11I, this.f2908il);
        this.iIi1.start();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3489IL() {
        this.f2900IiL.setTextSize(this.Lil);
        this.f2900IiL.setTypeface(this.f2898ILl);
        this.f2900IiL.setTextAlign(Paint.Align.CENTER);
        this.f2900IiL.setColor(this.f2904lIiI);
        invalidate();
    }

    public float getAnimationProgress() {
        return this.f2902L11I;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.f2899IL;
        int i2 = this.f2908il;
        this.f5374Ilil = (i - i2) - (i2 / 2);
        this.f2903iILLL1.setStrokeWidth(i2);
        canvas.drawCircle(this.f5373ILil, this.f5372I1I, this.f5374Ilil + this.f2902L11I, this.f2903iILLL1);
        canvas.drawCircle(this.f5373ILil, this.f5372I1I, this.f2899IL - this.f2908il, this.f2907lLi1LL);
        if (this.f2901Ll1 != null) {
            Paint.FontMetrics fontMetrics = this.f2900IiL.getFontMetrics();
            canvas.drawText(this.f2901Ll1, this.f5373ILil, this.f5372I1I - ((((int) (fontMetrics.top - fontMetrics.bottom)) / 2) / 2), this.f2900IiL);
            Log.e(IL1Iii.IL1Iii(new byte[]{53, 86, 21, 71}, IL1Iii.IL1Iii(new byte[]{87, 82, 95, 3, 83, 93}, IL1Iii.IL1Iii(new byte[]{87, 84, 91, 6, 84, 5}, "a5b6da"))), IL1Iii.IL1Iii(new byte[]{17, 82, 78, 67, 65, 93, 31, 82, 12}, IL1Iii.IL1Iii(new byte[]{93, 82, 14, 1, 6, 5}, IL1Iii.IL1Iii(new byte[]{89, 93, 0, 5, 0, 83}, "a8834b"))) + this.Lil);
        } else {
            Drawable drawable = this.f2906llL1ii;
            if (drawable != null) {
                set_fg_drawable(drawable);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5373ILil = i / 2;
        this.f5372I1I = i2 / 2;
        int iMin = Math.min(i, i2) / 2;
        this.f2899IL = iMin;
        int i5 = this.f2908il;
        this.f5374Ilil = (iMin - i5) - (i5 / 2);
    }

    public void setAnimationProgress(float f) {
        this.f2902L11I = f;
        invalidate();
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        Paint paint = this.f2907lLi1LL;
        if (paint != null) {
            paint.setColor(z ? this.LlLI1 : this.ILL);
        }
        if (z) {
            Ilil();
        } else {
            ILil();
        }
    }

    public void set_bg_color(int i) {
        this.ILL = i;
        this.LlLI1 = IL1Iii(i, 10);
        this.f2907lLi1LL.setColor(this.ILL);
        this.f2903iILLL1.setColor(this.ILL);
        this.f2903iILLL1.setAlpha(75);
        invalidate();
    }

    public void set_fg_drawable(Drawable drawable) {
        setImageDrawable(drawable);
        invalidate();
    }

    public void set_pressed_ring_width(int i) {
        this.f2908il = (int) TypedValue.applyDimension(1, i, this.f2905lIlii.getResources().getDisplayMetrics());
        invalidate();
    }

    public void set_text(String str) {
        this.f2901Ll1 = str;
        invalidate();
    }

    public void set_text_color(int i) {
        this.f2904lIiI = i;
        this.f2900IiL.setColor(i);
        invalidate();
    }

    public void set_text_size_dp(int i) {
        int i2 = (int) ((i * this.f2905lIlii.getResources().getDisplayMetrics().density) + 0.5f);
        this.Lil = i2;
        this.f2900IiL.setTextSize(i2);
        invalidate();
    }

    public void set_typeface(Typeface typeface) {
        this.f2898ILl = typeface;
        this.f2900IiL.setTypeface(typeface);
        invalidate();
    }

    public CircleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ILL = WebView.NIGHT_MODE_COLOR;
        this.f2901Ll1 = IL1Iii.IL1Iii(new byte[]{92, 81, 94, 82, 66, 13, 76}, IL1Iii.IL1Iii(new byte[]{94, 5, 12, 80, 3, 86}, IL1Iii.IL1Iii(new byte[]{94, 3, 12, 5, 81, 1}, "828fe6")));
        this.f2904lIiI = WebView.NIGHT_MODE_COLOR;
        this.f2898ILl = Typeface.DEFAULT;
        this.Lil = 12;
        I1I(context, attributeSet);
    }

    public CircleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ILL = WebView.NIGHT_MODE_COLOR;
        this.f2901Ll1 = IL1Iii.IL1Iii(new byte[]{6, 3, 84, 84, 16, 13, 22}, IL1Iii.IL1Iii(new byte[]{80, 86, 2, 13, 87, 0}, IL1Iii.IL1Iii(new byte[]{6, 82, 6, 15, 0, 81}, "4b6720")));
        this.f2904lIiI = WebView.NIGHT_MODE_COLOR;
        this.f2898ILl = Typeface.DEFAULT;
        this.Lil = 12;
        I1I(context, attributeSet);
    }
}
