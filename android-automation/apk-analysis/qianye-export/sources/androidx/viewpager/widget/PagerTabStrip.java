package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public int I11L;
    public int I11li1;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean f2783L111;
    public int LL1IL;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean f2784LlLLL;
    public int iIi1;
    public int iIlLiL;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean f2785lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2786lIlii;
    public int llI;
    public final Paint llliI;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public int f2787lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final Rect f2788l;

    /* JADX INFO: renamed from: 丨丨 */
    public float f44;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public float f2789LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public int f27901;

    public class IL1Iii implements View.OnClickListener {
        public IL1Iii() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f5214ILil;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public class ILil implements View.OnClickListener {
        public ILil() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f5214ILil;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void mo3386IL(int i, float f, boolean z) {
        Rect rect = this.f2788l;
        int height = getHeight();
        int left = this.f2793IL.getLeft() - this.I11L;
        int right = this.f2793IL.getRight() + this.I11L;
        int i2 = height - this.iIi1;
        rect.set(left, i2, right, height);
        super.mo3386IL(i, f, z);
        this.f27901 = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f2793IL.getLeft() - this.I11L, i2, this.f2793IL.getRight() + this.I11L, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f2784LlLLL;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f2787lL);
    }

    public int getTabIndicatorColor() {
        return this.f2786lIlii;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f2793IL.getLeft() - this.I11L;
        int right = this.f2793IL.getRight() + this.I11L;
        int i = height - this.iIi1;
        this.llliI.setColor((this.f27901 << 24) | (this.f2786lIlii & 16777215));
        float f = height;
        canvas.drawRect(left, i, right, f, this.llliI);
        if (this.f2784LlLLL) {
            this.llliI.setColor((-16777216) | (this.f2786lIlii & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.LL1IL, getWidth() - getPaddingRight(), f, this.llliI);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f2783L111) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.f2789LLlI1 = x;
            this.f44 = y;
            this.f2783L111 = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.f2789LLlI1) > this.llI || Math.abs(y - this.f44) > this.llI)) {
                this.f2783L111 = true;
            }
        } else if (x < this.f2793IL.getLeft() - this.I11L) {
            ViewPager viewPager = this.f5214ILil;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x > this.f2793IL.getRight() + this.I11L) {
            ViewPager viewPager2 = this.f5214ILil;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.f2785lIII) {
            return;
        }
        this.f2784LlLLL = (i & WebView.NIGHT_MODE_COLOR) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2785lIII) {
            return;
        }
        this.f2784LlLLL = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2785lIII) {
            return;
        }
        this.f2784LlLLL = i == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.f2784LlLLL = z;
        this.f2785lIII = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.iIlLiL;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.f2786lIlii = i;
        this.llliI.setColor(i);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(ILil.p028IiL.p035lLi1LL.IL1Iii.ILil(getContext(), i));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        int i2 = this.I11li1;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.llliI = paint;
        this.f2788l = new Rect();
        this.f27901 = 255;
        this.f2784LlLLL = false;
        this.f2785lIII = false;
        int i = this.Lil;
        this.f2786lIlii = i;
        paint.setColor(i);
        float f = context.getResources().getDisplayMetrics().density;
        this.iIi1 = (int) ((3.0f * f) + 0.5f);
        this.iIlLiL = (int) ((6.0f * f) + 0.5f);
        this.I11li1 = (int) (64.0f * f);
        this.I11L = (int) ((16.0f * f) + 0.5f);
        this.LL1IL = (int) ((1.0f * f) + 0.5f);
        this.f2787lL = (int) ((f * 32.0f) + 0.5f);
        this.llI = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f5213I1I.setFocusable(true);
        this.f5213I1I.setOnClickListener(new IL1Iii());
        this.f5215Ilil.setFocusable(true);
        this.f5215Ilil.setOnClickListener(new ILil());
        if (getBackground() == null) {
            this.f2784LlLLL = true;
        }
    }
}
