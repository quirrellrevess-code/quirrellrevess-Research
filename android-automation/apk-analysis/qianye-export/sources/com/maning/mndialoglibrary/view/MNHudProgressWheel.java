package com.maning.mndialoglibrary.view;

import I1I.p014IL.IL1Iii.lLi1LL;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class MNHudProgressWheel extends View {
    public boolean I11L;
    public boolean I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f5383I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5384ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public Paint f2917ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f5385Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2918IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public float f2919IiL;
    public RectF Lil;
    public float LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2920Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2921L11I;
    public float iIi1;
    public float iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public double f2922iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public Paint f2923lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f2924lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public long f2925llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public double f2926lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public long f2927il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public ILil f2928lL;

    public interface ILil {
        void IL1Iii(float f);
    }

    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f5386I1I;
        public boolean ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public float f5387ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public float f5388Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2929IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f2930IiL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public boolean f2931Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f2932L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f2933iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2934lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int f2935il;

        public static class IL1Iii implements Parcelable.Creator<WheelSavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f5387ILil);
            parcel.writeFloat(this.f5386I1I);
            parcel.writeByte(this.f2929IL ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f5388Ilil);
            parcel.writeInt(this.f2934lLi1LL);
            parcel.writeInt(this.f2933iILLL1);
            parcel.writeInt(this.f2930IiL);
            parcel.writeInt(this.f2932L11I);
            parcel.writeInt(this.f2935il);
            parcel.writeByte(this.ILL ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f2931Ll1 ? (byte) 1 : (byte) 0);
        }

        public WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f5387ILil = parcel.readFloat();
            this.f5386I1I = parcel.readFloat();
            this.f2929IL = parcel.readByte() != 0;
            this.f5388Ilil = parcel.readFloat();
            this.f2934lLi1LL = parcel.readInt();
            this.f2933iILLL1 = parcel.readInt();
            this.f2930IiL = parcel.readInt();
            this.f2932L11I = parcel.readInt();
            this.f2935il = parcel.readInt();
            this.ILL = parcel.readByte() != 0;
            this.f2931Ll1 = parcel.readByte() != 0;
        }
    }

    public MNHudProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5384ILil = 28;
        this.f5383I1I = 4;
        this.f2918IL = 4;
        this.f5385Ilil = false;
        this.f2926lLi1LL = 0.0d;
        this.f2922iILLL1 = 460.0d;
        this.f2919IiL = 0.0f;
        this.f2921L11I = true;
        this.f2927il = 0L;
        this.ILL = -1442840576;
        this.f2920Ll1 = 16777215;
        this.f2923lIiI = new Paint();
        this.f2917ILl = new Paint();
        this.Lil = new RectF();
        this.LlLI1 = 230.0f;
        this.f2925llL1ii = 0L;
        this.iIi1 = 0.0f;
        this.iIlLiL = 0.0f;
        this.I11li1 = false;
        IL1Iii(context.obtainStyledAttributes(attributeSet, lLi1LL.MNHudProgressWheel));
        m3491IL();
    }

    public final void I1I(float f) {
        ILil iLil = this.f2928lL;
        if (iLil != null) {
            iLil.IL1Iii(f);
        }
    }

    public final void IL1Iii(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f5383I1I = (int) TypedValue.applyDimension(1, this.f5383I1I, displayMetrics);
        this.f2918IL = (int) TypedValue.applyDimension(1, this.f2918IL, displayMetrics);
        int iApplyDimension = (int) TypedValue.applyDimension(1, this.f5384ILil, displayMetrics);
        this.f5384ILil = iApplyDimension;
        this.f5384ILil = (int) typedArray.getDimension(lLi1LL.MNHudProgressWheel_mn_circleRadius, iApplyDimension);
        this.f5385Ilil = typedArray.getBoolean(lLi1LL.MNHudProgressWheel_mn_fillRadius, false);
        this.f5383I1I = (int) typedArray.getDimension(lLi1LL.MNHudProgressWheel_mn_barWidth, this.f5383I1I);
        this.f2918IL = (int) typedArray.getDimension(lLi1LL.MNHudProgressWheel_mn_rimWidth, this.f2918IL);
        this.LlLI1 = typedArray.getFloat(lLi1LL.MNHudProgressWheel_mn_spinSpeed, this.LlLI1 / 360.0f) * 360.0f;
        this.f2922iILLL1 = typedArray.getInt(lLi1LL.MNHudProgressWheel_mn_barSpinCycleTime, (int) this.f2922iILLL1);
        this.ILL = typedArray.getColor(lLi1LL.MNHudProgressWheel_mn_barColor, this.ILL);
        this.f2920Ll1 = typedArray.getColor(lLi1LL.MNHudProgressWheel_mn_rimColor, this.f2920Ll1);
        this.f2924lIlii = typedArray.getBoolean(lLi1LL.MNHudProgressWheel_mn_linearProgress, false);
        if (typedArray.getBoolean(lLi1LL.MNHudProgressWheel_mn_progressIndeterminate, false)) {
            m3493iILLL1();
        }
        typedArray.recycle();
    }

    public final void ILil() {
        if (this.f2928lL != null) {
            this.f2928lL.IL1Iii(Math.round((this.iIi1 * 100.0f) / 360.0f) / 100.0f);
        }
    }

    public final void Ilil(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.f5385Ilil) {
            int i3 = this.f5383I1I;
            this.Lil = new RectF(paddingLeft + i3, paddingTop + i3, (i - paddingRight) - i3, (i2 - paddingBottom) - i3);
            return;
        }
        int i4 = (i - paddingLeft) - paddingRight;
        int iMin = Math.min(Math.min(i4, (i2 - paddingBottom) - paddingTop), (this.f5384ILil * 2) - (this.f5383I1I * 2));
        int i5 = ((i4 - iMin) / 2) + paddingLeft;
        int i6 = ((((i2 - paddingTop) - paddingBottom) - iMin) / 2) + paddingTop;
        int i7 = this.f5383I1I;
        this.Lil = new RectF(i5 + i7, i6 + i7, (i5 + iMin) - i7, (i6 + iMin) - i7);
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3491IL() {
        this.I11L = (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) != 0.0f;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3492IiL(long j) {
        long j2 = this.f2927il;
        if (j2 < 200) {
            this.f2927il = j2 + j;
            return;
        }
        double d = this.f2926lLi1LL + j;
        this.f2926lLi1LL = d;
        double d2 = this.f2922iILLL1;
        if (d > d2) {
            this.f2926lLi1LL = d - d2;
            this.f2927il = 0L;
            this.f2921L11I = !this.f2921L11I;
        }
        float fCos = (((float) Math.cos(((this.f2926lLi1LL / d2) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
        if (this.f2921L11I) {
            this.f2919IiL = fCos * 254.0f;
            return;
        }
        float f = (1.0f - fCos) * 254.0f;
        this.iIi1 += this.f2919IiL - f;
        this.f2919IiL = f;
    }

    public int getBarColor() {
        return this.ILL;
    }

    public int getBarWidth() {
        return this.f5383I1I;
    }

    public int getCircleRadius() {
        return this.f5384ILil;
    }

    public float getProgress() {
        if (this.I11li1) {
            return -1.0f;
        }
        return this.iIi1 / 360.0f;
    }

    public int getRimColor() {
        return this.f2920Ll1;
    }

    public int getRimWidth() {
        return this.f2918IL;
    }

    public float getSpinSpeed() {
        return this.LlLI1 / 360.0f;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3493iILLL1() {
        this.f2925llL1ii = SystemClock.uptimeMillis();
        this.I11li1 = true;
        invalidate();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m3494lLi1LL() {
        this.f2923lIiI.setColor(this.ILL);
        this.f2923lIiI.setAntiAlias(true);
        this.f2923lIiI.setStyle(Paint.Style.STROKE);
        this.f2923lIiI.setStrokeWidth(this.f5383I1I);
        this.f2917ILl.setColor(this.f2920Ll1);
        this.f2917ILl.setAntiAlias(true);
        this.f2917ILl.setStyle(Paint.Style.STROKE);
        this.f2917ILl.setStrokeWidth(this.f2918IL);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        canvas.drawArc(this.Lil, 360.0f, 360.0f, false, this.f2917ILl);
        if (this.I11L) {
            float fPow = 0.0f;
            boolean z = true;
            if (this.I11li1) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.f2925llL1ii;
                float f3 = (jUptimeMillis * this.LlLI1) / 1000.0f;
                m3492IiL(jUptimeMillis);
                float f4 = this.iIi1 + f3;
                this.iIi1 = f4;
                if (f4 > 360.0f) {
                    this.iIi1 = f4 - 360.0f;
                    I1I(-1.0f);
                }
                this.f2925llL1ii = SystemClock.uptimeMillis();
                float f5 = this.iIi1 - 90.0f;
                float f6 = this.f2919IiL + 16.0f;
                if (isInEditMode()) {
                    f = 0.0f;
                    f2 = 135.0f;
                } else {
                    f = f5;
                    f2 = f6;
                }
                canvas.drawArc(this.Lil, f, f2, false, this.f2923lIiI);
            } else {
                float f7 = this.iIi1;
                if (f7 != this.iIlLiL) {
                    this.iIi1 = Math.min(this.iIi1 + (((SystemClock.uptimeMillis() - this.f2925llL1ii) / 1000.0f) * this.LlLI1), this.iIlLiL);
                    this.f2925llL1ii = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (f7 != this.iIi1) {
                    ILil();
                }
                float fPow2 = this.iIi1;
                if (!this.f2924lIlii) {
                    fPow = ((float) (1.0d - Math.pow(1.0f - (fPow2 / 360.0f), 4.0f))) * 360.0f;
                    fPow2 = ((float) (1.0d - Math.pow(1.0f - (this.iIi1 / 360.0f), 2.0f))) * 360.0f;
                }
                canvas.drawArc(this.Lil, fPow - 90.0f, isInEditMode() ? 360.0f : fPow2, false, this.f2923lIiI);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.f5384ILil + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f5384ILil + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.iIi1 = wheelSavedState.f5387ILil;
        this.iIlLiL = wheelSavedState.f5386I1I;
        this.I11li1 = wheelSavedState.f2929IL;
        this.LlLI1 = wheelSavedState.f5388Ilil;
        this.f5383I1I = wheelSavedState.f2934lLi1LL;
        this.ILL = wheelSavedState.f2933iILLL1;
        this.f2918IL = wheelSavedState.f2930IiL;
        this.f2920Ll1 = wheelSavedState.f2932L11I;
        this.f5384ILil = wheelSavedState.f2935il;
        this.f2924lIlii = wheelSavedState.ILL;
        this.f5385Ilil = wheelSavedState.f2931Ll1;
        this.f2925llL1ii = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f5387ILil = this.iIi1;
        wheelSavedState.f5386I1I = this.iIlLiL;
        wheelSavedState.f2929IL = this.I11li1;
        wheelSavedState.f5388Ilil = this.LlLI1;
        wheelSavedState.f2934lLi1LL = this.f5383I1I;
        wheelSavedState.f2933iILLL1 = this.ILL;
        wheelSavedState.f2930IiL = this.f2918IL;
        wheelSavedState.f2932L11I = this.f2920Ll1;
        wheelSavedState.f2935il = this.f5384ILil;
        wheelSavedState.ILL = this.f2924lIlii;
        wheelSavedState.f2931Ll1 = this.f5385Ilil;
        return wheelSavedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Ilil(i, i2);
        m3494lLi1LL();
        invalidate();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f2925llL1ii = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.ILL = i;
        m3494lLi1LL();
        if (this.I11li1) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i) {
        this.f5383I1I = i;
        if (this.I11li1) {
            return;
        }
        invalidate();
    }

    public void setCallback(ILil iLil) {
        this.f2928lL = iLil;
        if (this.I11li1) {
            return;
        }
        ILil();
    }

    public void setCircleRadius(int i) {
        this.f5384ILil = i;
        if (this.I11li1) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f) {
        if (this.I11li1) {
            this.iIi1 = 0.0f;
            this.I11li1 = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f == this.iIlLiL) {
            return;
        }
        float fMin = Math.min(f * 360.0f, 360.0f);
        this.iIlLiL = fMin;
        this.iIi1 = fMin;
        this.f2925llL1ii = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z) {
        this.f2924lIlii = z;
        if (this.I11li1) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f) {
        if (this.I11li1) {
            this.iIi1 = 0.0f;
            this.I11li1 = false;
            ILil();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = this.iIlLiL;
        if (f == f2) {
            return;
        }
        if (this.iIi1 == f2) {
            this.f2925llL1ii = SystemClock.uptimeMillis();
        }
        this.iIlLiL = Math.min(f * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i) {
        this.f2920Ll1 = i;
        m3494lLi1LL();
        if (this.I11li1) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i) {
        this.f2918IL = i;
        if (this.I11li1) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f) {
        this.LlLI1 = f * 360.0f;
    }

    public MNHudProgressWheel(Context context) {
        super(context);
        this.f5384ILil = 28;
        this.f5383I1I = 4;
        this.f2918IL = 4;
        this.f5385Ilil = false;
        this.f2926lLi1LL = 0.0d;
        this.f2922iILLL1 = 460.0d;
        this.f2919IiL = 0.0f;
        this.f2921L11I = true;
        this.f2927il = 0L;
        this.ILL = -1442840576;
        this.f2920Ll1 = 16777215;
        this.f2923lIiI = new Paint();
        this.f2917ILl = new Paint();
        this.Lil = new RectF();
        this.LlLI1 = 230.0f;
        this.f2925llL1ii = 0L;
        this.iIi1 = 0.0f;
        this.iIlLiL = 0.0f;
        this.I11li1 = false;
        m3491IL();
    }
}
