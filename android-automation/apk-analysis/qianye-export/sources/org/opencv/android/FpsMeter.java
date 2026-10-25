package org.opencv.android;

import I1I.IL1Iii;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import java.text.DecimalFormat;
import org.opencv.core.Core;

/* JADX INFO: loaded from: classes.dex */
public class FpsMeter {
    private static final int STEP = 20;
    private int mFramesCounter;
    private double mFrequency;
    public Paint mPaint;
    private String mStrfps;
    private long mprevFrameTime;
    private static final String TAG = IL1Iii.IL1Iii(new byte[]{127, 66, 74, 120, 80, 21, 92, 64}, IL1Iii.IL1Iii(new byte[]{9, 87, 88, 13, 5, 84}, IL1Iii.IL1Iii(new byte[]{1, 80, 84, 92, 81, 6}, "155da3")));
    private static final DecimalFormat FPS_FORMAT = new DecimalFormat(IL1Iii.IL1Iii(new byte[]{8, 25, 6, 9}, IL1Iii.IL1Iii(new byte[]{14, 84, 2, 0, 85, 0}, IL1Iii.IL1Iii(new byte[]{2, 83, 2, 11, 5, 7}, "40622c"))));
    public boolean mIsInitialized = false;
    public int mWidth = 0;
    public int mHeight = 0;

    public void draw(Canvas canvas, float f, float f2) {
        Log.d(TAG, this.mStrfps);
        canvas.drawText(this.mStrfps, f, f2, this.mPaint);
    }

    public void init() {
        this.mFramesCounter = 0;
        this.mFrequency = Core.getTickFrequency();
        this.mprevFrameTime = Core.getTickCount();
        this.mStrfps = BuildConfig.FLAVOR;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-16776961);
        this.mPaint.setTextSize(20.0f);
    }

    public void measure() {
        if (!this.mIsInitialized) {
            init();
            this.mIsInitialized = true;
            return;
        }
        int i = this.mFramesCounter + 1;
        this.mFramesCounter = i;
        if (i % 20 == 0) {
            long tickCount = Core.getTickCount();
            double d = (this.mFrequency * 20.0d) / (tickCount - this.mprevFrameTime);
            this.mprevFrameTime = tickCount;
            if (this.mWidth == 0 || this.mHeight == 0) {
                this.mStrfps = FPS_FORMAT.format(d) + IL1Iii.IL1Iii(new byte[]{25, 34, 53, 53}, IL1Iii.IL1Iii(new byte[]{92, 87, 81, 3, 91, 80}, IL1Iii.IL1Iii(new byte[]{4, 86, 3, 7, 12, 7}, "ae7b41")));
            } else {
                this.mStrfps = FPS_FORMAT.format(d) + IL1Iii.IL1Iii(new byte[]{20, 113, 105, 55, 113}, IL1Iii.IL1Iii(new byte[]{87, 0, 93, 87, 8, 2}, IL1Iii.IL1Iii(new byte[]{5, 3, 81, 4, 88, 0}, "f457a1"))) + Integer.valueOf(this.mWidth) + IL1Iii.IL1Iii(new byte[]{74}, IL1Iii.IL1Iii(new byte[]{6, 81, 0, 6, 4, 87}, IL1Iii.IL1Iii(new byte[]{4, 92, 86, 1, 81, 86}, "09e3ab"))) + Integer.valueOf(this.mHeight);
            }
            Log.i(TAG, this.mStrfps);
        }
    }

    public void setResolution(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }
}
