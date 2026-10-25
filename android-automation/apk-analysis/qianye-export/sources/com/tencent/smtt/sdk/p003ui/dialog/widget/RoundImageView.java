package com.tencent.smtt.sdk.p003ui.dialog.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.p003ui.dialog.C0432a;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class RoundImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    private Paint f652a;

    /* JADX INFO: renamed from: b */
    private Xfermode f653b;

    /* JADX INFO: renamed from: c */
    private Bitmap f654c;

    /* JADX INFO: renamed from: d */
    private float[] f655d;

    /* JADX INFO: renamed from: e */
    private RectF f656e;

    /* JADX INFO: renamed from: f */
    private int f657f;

    /* JADX INFO: renamed from: g */
    private WeakReference<Bitmap> f658g;

    /* JADX INFO: renamed from: h */
    private float f659h;

    /* JADX INFO: renamed from: i */
    private Path f660i;

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f653b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f657f = Color.parseColor("#eaeaea");
        Paint paint = new Paint();
        this.f652a = paint;
        paint.setAntiAlias(true);
        this.f660i = new Path();
        this.f655d = new float[8];
        this.f656e = new RectF();
        this.f659h = C0432a.m537a(context, 16.46f);
        int i = 0;
        while (true) {
            float[] fArr = this.f655d;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = this.f659h;
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m540a() {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(1);
            paint.setColor(WebView.NIGHT_MODE_COLOR);
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f = this.f659h;
            canvas.drawRoundRect(rectF, f, f, paint);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m541a(int i, int i2) {
        this.f660i.reset();
        this.f652a.setStrokeWidth(i);
        this.f652a.setColor(i2);
        this.f652a.setStyle(Paint.Style.STROKE);
    }

    /* JADX INFO: renamed from: a */
    private void m542a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        m541a(i, i2);
        this.f660i.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.f660i, this.f652a);
    }

    @Override // android.view.View
    public void invalidate() {
        this.f658g = null;
        Bitmap bitmap = this.f654c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f654c = null;
        }
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        WeakReference<Bitmap> weakReference = this.f658g;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.isRecycled()) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f = intrinsicWidth;
                float f2 = intrinsicHeight;
                float fMax = Math.max((getWidth() * 1.0f) / f, (getHeight() * 1.0f) / f2);
                drawable.setBounds(0, 0, (int) (f * fMax), (int) (fMax * f2));
                drawable.draw(canvas2);
                Bitmap bitmap2 = this.f654c;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    this.f654c = m540a();
                }
                this.f652a.reset();
                this.f652a.setFilterBitmap(false);
                this.f652a.setXfermode(this.f653b);
                Bitmap bitmap3 = this.f654c;
                if (bitmap3 != null) {
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, this.f652a);
                }
                this.f652a.setXfermode(null);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
                this.f658g = new WeakReference<>(bitmapCreateBitmap);
            }
        } else {
            this.f652a.setXfermode(null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f652a);
        }
        m542a(canvas, 1, this.f657f, this.f656e, this.f655d);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f656e.set(0.5f, 0.5f, i - 0.5f, i2 - 0.5f);
    }
}
