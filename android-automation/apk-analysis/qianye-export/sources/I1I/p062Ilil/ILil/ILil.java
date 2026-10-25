package I1I.p062Ilil.ILil;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.p000nx.baseui.SlidingTabLayout;

/* JADX INFO: compiled from: SlidingTabStrip.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends LinearLayout {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int f3476I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Paint f3477ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final C0538ILil f3478Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public SlidingTabLayout.IL f1118IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1119IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public float f1120L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int f1121iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Paint f1122lLi1LL;

    /* JADX INFO: renamed from: I1I.Ilil.ILil.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SlidingTabStrip.java */
    public static class C0538ILil implements SlidingTabLayout.IL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int[] f3479IL1Iii;

        @Override // com.p000nx.baseui.SlidingTabLayout.IL
        public final int IL1Iii(int i) {
            int[] iArr = this.f3479IL1Iii;
            return iArr[i % iArr.length];
        }

        public void ILil(int... iArr) {
            this.f3479IL1Iii = iArr;
        }

        public C0538ILil() {
        }
    }

    public ILil(Context context) {
        this(context, null);
    }

    public static int I1I(int i, byte b) {
        return Color.argb((int) b, Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int IL1Iii(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((Color.red(i) * f) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f) + (Color.blue(i2) * f2)));
    }

    public void ILil(int i, float f) {
        this.f1119IiL = i;
        this.f1120L11I = f;
        invalidate();
    }

    public void Ilil(int... iArr) {
        this.f1118IL = null;
        this.f3478Ilil.ILil(iArr);
        invalidate();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1281IL(SlidingTabLayout.IL il) {
        this.f1118IL = il;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        SlidingTabLayout.IL il = this.f1118IL;
        if (il == null) {
            il = this.f3478Ilil;
        }
        if (childCount > 0) {
            View childAt = getChildAt(this.f1119IiL);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int iIL1Iii = il.IL1Iii(this.f1119IiL);
            if (this.f1120L11I > 0.0f && this.f1119IiL < getChildCount() - 1) {
                int iIL1Iii2 = il.IL1Iii(this.f1119IiL + 1);
                if (iIL1Iii != iIL1Iii2) {
                    iIL1Iii = IL1Iii(iIL1Iii2, iIL1Iii, this.f1120L11I);
                }
                View childAt2 = getChildAt(this.f1119IiL + 1);
                float left2 = this.f1120L11I * childAt2.getLeft();
                float f = this.f1120L11I;
                left = (int) (left2 + ((1.0f - f) * left));
                right = (int) ((f * childAt2.getRight()) + ((1.0f - this.f1120L11I) * right));
            }
            this.f1122lLi1LL.setColor(iIL1Iii);
            canvas.drawRect(left, height - this.f1121iILLL1, right, height, this.f1122lLi1LL);
        }
        canvas.drawRect(0.0f, height - this.f3476I1I, getWidth(), height, this.f3477ILil);
    }

    public ILil(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorForeground, typedValue, true);
        int iI1I = I1I(typedValue.data, (byte) 38);
        C0538ILil c0538ILil = new C0538ILil();
        this.f3478Ilil = c0538ILil;
        c0538ILil.ILil(-13388315);
        this.f3476I1I = (int) (0.0f * f);
        Paint paint = new Paint();
        this.f3477ILil = paint;
        paint.setColor(iI1I);
        this.f1121iILLL1 = (int) (f * 3.0f);
        this.f1122lLi1LL = new Paint();
    }
}
