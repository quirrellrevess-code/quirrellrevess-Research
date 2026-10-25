package androidx.constraintlayout.widget;

import ILil.p045lLi1LL.IL1Iii.ILL.C0650il;
import ILil.p045lLi1LL.IL1Iii.ILL.IiL;
import ILil.p045lLi1LL.IL1Iii.ILL.iILLL1;
import ILil.p045lLi1LL.IL1Iii.ILL.lIiI;
import ILil.p045lLi1LL.IL1Iii.ILL.lLi1LL;
import ILil.p045lLi1LL.ILil.I1I;
import ILil.p045lLi1LL.ILil.IL1Iii;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.http2.Http2Connection;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ArrayList<ConstraintHelper> f4928I1I;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public SparseArray<View> f4929ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public HashMap<String, Integer> f2483ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public IiL f4930Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final ArrayList<iILLL1> f2484IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2485IiL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public IL1Iii f2486Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2487L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2488iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f2489lIiI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public ILil.p045lLi1LL.IL1Iii.iILLL1 f2490llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2491lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2492il;

    public ConstraintLayout(Context context) {
        super(context);
        this.f4929ILil = new SparseArray<>();
        this.f4928I1I = new ArrayList<>(4);
        this.f2484IL = new ArrayList<>(100);
        this.f4930Ilil = new IiL();
        this.f2491lLi1LL = 0;
        this.f2488iILLL1 = 0;
        this.f2485IiL = Integer.MAX_VALUE;
        this.f2487L11I = Integer.MAX_VALUE;
        this.f2492il = true;
        this.ILL = 7;
        this.f2486Ll1 = null;
        this.f2489lIiI = -1;
        this.f2483ILl = new HashMap<>();
        this.Lil = -1;
        this.LlLI1 = -1;
        m3142iILLL1(null);
    }

    public Object I1I(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.f2483ILl;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f2483ILl.get(str);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void ILL(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f2483ILl == null) {
                this.f2483ILl = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f2483ILl.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m3137ILl() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
        }
        if (z) {
            this.f2484IL.clear();
            m3145il();
        }
    }

    public View Ilil(int i) {
        return this.f4929ILil.get(i);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final iILLL1 m3138IL(int i) {
        if (i == 0) {
            return this.f4930Ilil;
        }
        View viewFindViewById = this.f4929ILil.get(i);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f4930Ilil;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((LayoutParams) viewFindViewById.getLayoutParams()).l1Lll;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3139IiL(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z3;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                iILLL1 iilll1 = layoutParams.l1Lll;
                if (!layoutParams.iIilII1 && !layoutParams.f37i1) {
                    iilll1.m2648iILiiLl(childAt.getVisibility());
                    int measuredWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    int measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    boolean z4 = layoutParams.f2493I1L11L;
                    if (z4 || (z3 = layoutParams.f2495ILLIi) || (!z4 && layoutParams.f2516l1IIi1 == 1) || measuredWidth == -1 || (!z3 && (layoutParams.f2507L1l == 1 || measuredHeight == -1))) {
                        if (measuredWidth == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -2);
                            z = true;
                        } else if (measuredWidth == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, -1);
                            z = false;
                        } else {
                            z = measuredWidth == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i, paddingLeft, measuredWidth);
                        }
                        if (measuredHeight == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
                            z2 = true;
                        } else if (measuredHeight == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = measuredHeight == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, paddingTop, measuredHeight);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        ILil.p045lLi1LL.IL1Iii.iILLL1 iilll2 = this.f2490llL1ii;
                        if (iilll2 != null) {
                            iilll2.f4530IL1Iii++;
                        }
                        iilll1.m90l(measuredWidth == -2);
                        iilll1.m2633LlLiLL(measuredHeight == -2);
                        measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    iilll1.ILI1Ll(measuredWidth);
                    iilll1.m87iI(measuredHeight);
                    if (z) {
                        iilll1.LII(measuredWidth);
                    }
                    if (z2) {
                        iilll1.m26581iIl(measuredHeight);
                    }
                    if (layoutParams.f2523li11 && (baseline = childAt.getBaseline()) != -1) {
                        iilll1.m2624ILLIi(baseline);
                    }
                }
            }
        }
    }

    public final void Lil() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).ILil(this);
            }
        }
        int size = this.f4928I1I.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f4928I1I.get(i2).m3135IL(this);
            }
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3140Ll1(int i, int i2) {
        int iMin;
        iILLL1.ILil iLil;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        iILLL1.ILil iLil2 = iILLL1.ILil.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                iLil = iILLL1.ILil.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                iLil = iLil2;
            } else {
                iMin = Math.min(this.f2485IiL, size) - paddingLeft;
                iLil = iLil2;
            }
            iMin = 0;
        } else {
            iMin = size;
            iLil = iILLL1.ILil.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                iLil2 = iILLL1.ILil.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f2487L11I, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            iLil2 = iILLL1.ILil.WRAP_CONTENT;
        }
        this.f4930Ilil.ill1LI1l(0);
        this.f4930Ilil.I1IILIIL(0);
        this.f4930Ilil.m83I1(iLil);
        this.f4930Ilil.ILI1Ll(iMin);
        this.f4930Ilil.m2647i1I1I1l(iLil2);
        this.f4930Ilil.m87iI(size2);
        this.f4930Ilil.ill1LI1l((this.f2491lLi1LL - getPaddingLeft()) - getPaddingRight());
        this.f4930Ilil.I1IILIIL((this.f2488iILLL1 - getPaddingTop()) - getPaddingBottom());
    }

    /* JADX WARN: Code duplicated, block: B:163:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d4  */
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3141L11I(int i, int i2) {
        long j;
        int i3;
        int i4;
        int i5;
        long j2;
        boolean z;
        int childMeasureSpec;
        boolean z2;
        int childMeasureSpec2;
        int i6;
        int baseline;
        int i7;
        int baseline2;
        ConstraintLayout constraintLayout = this;
        int i8 = i;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i9 = 0;
        while (true) {
            j = 1;
            i3 = 8;
            if (i9 >= childCount) {
                break;
            }
            View childAt = constraintLayout.getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i7 = paddingTop;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                iILLL1 iilll1 = layoutParams.l1Lll;
                if (layoutParams.iIilII1 || layoutParams.f37i1) {
                    i7 = paddingTop;
                } else {
                    iilll1.m2648iILiiLl(childAt.getVisibility());
                    int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i10 == 0 || i11 == 0) {
                        i7 = paddingTop;
                        iilll1.llliI().I1I();
                        iilll1.I11L().I1I();
                    } else {
                        boolean z3 = i10 == -2;
                        int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i8, paddingLeft, i10);
                        boolean z4 = i11 == -2;
                        childAt.measure(childMeasureSpec3, ViewGroup.getChildMeasureSpec(i2, paddingTop, i11));
                        ILil.p045lLi1LL.IL1Iii.iILLL1 iilll2 = constraintLayout.f2490llL1ii;
                        i7 = paddingTop;
                        if (iilll2 != null) {
                            iilll2.f4530IL1Iii++;
                        }
                        iilll1.m90l(i10 == -2);
                        iilll1.m2633LlLiLL(i11 == -2);
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        iilll1.ILI1Ll(measuredWidth);
                        iilll1.m87iI(measuredHeight);
                        if (z3) {
                            iilll1.LII(measuredWidth);
                        }
                        if (z4) {
                            iilll1.m26581iIl(measuredHeight);
                        }
                        if (layoutParams.f2523li11 && (baseline2 = childAt.getBaseline()) != -1) {
                            iilll1.m2624ILLIi(baseline2);
                        }
                        if (layoutParams.f2493I1L11L && layoutParams.f2495ILLIi) {
                            iilll1.llliI().m2604IiL(measuredWidth);
                            iilll1.I11L().m2604IiL(measuredHeight);
                        }
                    }
                }
            }
            i9++;
            paddingTop = i7;
        }
        int i12 = paddingTop;
        constraintLayout.f4930Ilil.Ll1();
        int i13 = 0;
        while (i13 < childCount) {
            View childAt2 = constraintLayout.getChildAt(i13);
            if (childAt2.getVisibility() == i3) {
                i4 = i13;
                i5 = childCount;
                j2 = j;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                iILLL1 iilll3 = layoutParams2.l1Lll;
                if (layoutParams2.iIilII1 || layoutParams2.f37i1) {
                    i4 = i13;
                    i5 = childCount;
                    j2 = j;
                } else {
                    iilll3.m2648iILiiLl(childAt2.getVisibility());
                    int iILL = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
                    int i14 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                    if (iILL == 0 || i14 == 0) {
                        lLi1LL.IL il = lLi1LL.IL.LEFT;
                        lIiI liiiM2687lLi1LL = iilll3.mo2627IiL(il).m2687lLi1LL();
                        lLi1LL.IL il2 = lLi1LL.IL.RIGHT;
                        lIiI liiiM2687lLi1LL2 = iilll3.mo2627IiL(il2).m2687lLi1LL();
                        boolean z5 = (iilll3.mo2627IiL(il).m2684L11I() == null || iilll3.mo2627IiL(il2).m2684L11I() == null) ? false : true;
                        lLi1LL.IL il3 = lLi1LL.IL.TOP;
                        lIiI liiiM2687lLi1LL3 = iilll3.mo2627IiL(il3).m2687lLi1LL();
                        lLi1LL.IL il4 = lLi1LL.IL.BOTTOM;
                        lIiI liiiM2687lLi1LL4 = iilll3.mo2627IiL(il4).m2687lLi1LL();
                        boolean z6 = (iilll3.mo2627IiL(il3).m2684L11I() == null || iilll3.mo2627IiL(il4).m2684L11I() == null) ? false : true;
                        if (iILL == 0 && i14 == 0 && z5 && z6) {
                            i4 = i13;
                            i5 = childCount;
                            j2 = 1;
                        } else {
                            iILLL1.ILil iLilIIi1 = constraintLayout.f4930Ilil.iIi1();
                            i5 = childCount;
                            iILLL1.ILil iLil = iILLL1.ILil.WRAP_CONTENT;
                            i4 = i13;
                            boolean z7 = iLilIIi1 != iLil;
                            boolean z8 = constraintLayout.f4930Ilil.m2652lIII() != iLil;
                            if (!z7) {
                                iilll3.llliI().I1I();
                            }
                            if (!z8) {
                                iilll3.I11L().I1I();
                            }
                            if (iILL == 0) {
                                if (z7 && iilll3.m2632LlIl() && z5 && liiiM2687lLi1LL.m2618IL() && liiiM2687lLi1LL2.m2618IL()) {
                                    iILL = (int) (liiiM2687lLi1LL2.ILL() - liiiM2687lLi1LL.ILL());
                                    iilll3.llliI().m2604IiL(iILL);
                                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingLeft, iILL);
                                    z = false;
                                } else {
                                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingLeft, -2);
                                    z = true;
                                    z7 = false;
                                }
                            } else if (iILL == -1) {
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingLeft, -1);
                                z = false;
                            } else {
                                z = iILL == -2;
                                childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingLeft, iILL);
                            }
                            if (i14 == 0) {
                                if (z8 && iilll3.m2628L11() && z6 && liiiM2687lLi1LL3.m2618IL() && liiiM2687lLi1LL4.m2618IL()) {
                                    int iILL2 = (int) (liiiM2687lLi1LL4.ILL() - liiiM2687lLi1LL3.ILL());
                                    iilll3.I11L().m2604IiL(iILL2);
                                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, i12, iILL2);
                                    i6 = iILL2;
                                    z2 = false;
                                } else {
                                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, i12, -2);
                                    i6 = i14;
                                    z8 = false;
                                    z2 = true;
                                }
                            } else if (i14 == -1) {
                                i6 = i14;
                                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, i12, -1);
                                z2 = false;
                            } else {
                                boolean z9 = i14 == -2;
                                int childMeasureSpec4 = ViewGroup.getChildMeasureSpec(i2, i12, i14);
                                z2 = z9;
                                childMeasureSpec2 = childMeasureSpec4;
                                i6 = i14;
                            }
                            childAt2.measure(childMeasureSpec, childMeasureSpec2);
                            ILil.p045lLi1LL.IL1Iii.iILLL1 iilll4 = constraintLayout.f2490llL1ii;
                            if (iilll4 != null) {
                                j2 = 1;
                                iilll4.f4530IL1Iii++;
                            } else {
                                j2 = 1;
                            }
                            iilll3.m90l(iILL == -2);
                            iilll3.m2633LlLiLL(i6 == -2);
                            int measuredWidth2 = childAt2.getMeasuredWidth();
                            int measuredHeight2 = childAt2.getMeasuredHeight();
                            iilll3.ILI1Ll(measuredWidth2);
                            iilll3.m87iI(measuredHeight2);
                            if (z) {
                                iilll3.LII(measuredWidth2);
                            }
                            if (z2) {
                                iilll3.m26581iIl(measuredHeight2);
                            }
                            if (z7) {
                                iilll3.llliI().m2604IiL(measuredWidth2);
                            } else {
                                iilll3.llliI().m2605iILLL1();
                            }
                            if (z8) {
                                iilll3.I11L().m2604IiL(measuredHeight2);
                            } else {
                                iilll3.I11L().m2605iILLL1();
                            }
                            if (layoutParams2.f2523li11 && (baseline = childAt2.getBaseline()) != -1) {
                                iilll3.m2624ILLIi(baseline);
                            }
                        }
                    } else {
                        i4 = i13;
                        i5 = childCount;
                        j2 = j;
                    }
                }
            }
            constraintLayout = this;
            i13 = i4 + 1;
            j = j2;
            childCount = i5;
            i3 = 8;
            i8 = i;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i2 = Integer.parseInt(strArrSplit[0]);
                        int i3 = Integer.parseInt(strArrSplit[1]);
                        int i4 = Integer.parseInt(strArrSplit[2]);
                        int i5 = (int) ((i2 / 1080.0f) * width);
                        int i6 = (int) ((i3 / 1920.0f) * height);
                        int i7 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i5;
                        float f2 = i6;
                        float f3 = i5 + ((int) ((i4 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i6 + i7;
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public int getMaxHeight() {
        return this.f2487L11I;
    }

    public int getMaxWidth() {
        return this.f2485IiL;
    }

    public int getMinHeight() {
        return this.f2488iILLL1;
    }

    public int getMinWidth() {
        return this.f2491lLi1LL;
    }

    public int getOptimizationLevel() {
        return this.f4930Ilil.L1li1();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m3142iILLL1(AttributeSet attributeSet) {
        this.f4930Ilil.m2657li11(this);
        this.f4929ILil.put(getId(), this);
        this.f2486Ll1 = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, I1I.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == I1I.ConstraintLayout_Layout_android_minWidth) {
                    this.f2491lLi1LL = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2491lLi1LL);
                } else if (index == I1I.ConstraintLayout_Layout_android_minHeight) {
                    this.f2488iILLL1 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2488iILLL1);
                } else if (index == I1I.ConstraintLayout_Layout_android_maxWidth) {
                    this.f2485IiL = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2485IiL);
                } else if (index == I1I.ConstraintLayout_Layout_android_maxHeight) {
                    this.f2487L11I = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2487L11I);
                } else if (index == I1I.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.ILL = typedArrayObtainStyledAttributes.getInt(index, this.ILL);
                } else if (index == I1I.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        IL1Iii iL1Iii = new IL1Iii();
                        this.f2486Ll1 = iL1Iii;
                        iL1Iii.Ilil(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f2486Ll1 = null;
                    }
                    this.f2489lIiI = resourceId;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4930Ilil.m2611LllI11(this.ILL);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3143lIiI(String str) {
        this.f4930Ilil.mo2612iI1L1Ll();
        ILil.p045lLi1LL.IL1Iii.iILLL1 iilll1 = this.f2490llL1ii;
        if (iilll1 != null) {
            iilll1.f4529I1I++;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final iILLL1 m3144lLi1LL(View view) {
        if (view == this) {
            return this.f4930Ilil;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).l1Lll;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            iILLL1 iilll1 = layoutParams.l1Lll;
            if ((childAt.getVisibility() != 8 || layoutParams.iIilII1 || layoutParams.f37i1 || zIsInEditMode) && !layoutParams.f2514ili11) {
                int iLlLI1 = iilll1.LlLI1();
                int iM2654llL1ii = iilll1.m2654llL1ii();
                int iM2629L111 = iilll1.m2629L111() + iLlLI1;
                int iM2653lIlii = iilll1.m2653lIlii() + iM2654llL1ii;
                childAt.layout(iLlLI1, iM2654llL1ii, iM2629L111, iM2653lIlii);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iLlLI1, iM2654llL1ii, iM2629L111, iM2653lIlii);
                }
            }
        }
        int size = this.f4928I1I.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.f4928I1I.get(i6).I1I(this);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x011d  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        int baseline;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f4930Ilil.LIlLi(paddingLeft);
        this.f4930Ilil.lI1I1(paddingTop);
        this.f4930Ilil.l1Lll(this.f2485IiL);
        this.f4930Ilil.m88lL(this.f2487L11I);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f4930Ilil.IL1(getLayoutDirection() == 1);
        }
        m3140Ll1(i, i2);
        int iM2629L111 = this.f4930Ilil.m2629L111();
        int iM2653lIlii = this.f4930Ilil.m2653lIlii();
        if (this.f2492il) {
            this.f2492il = false;
            m3137ILl();
            z = true;
        } else {
            z = false;
        }
        boolean z6 = (this.ILL & 8) == 8;
        if (z6) {
            this.f4930Ilil.lI11lLL();
            this.f4930Ilil.m2615IL1iLI(iM2629L111, iM2653lIlii);
            m3141L11I(i, i2);
        } else {
            m3139IiL(i, i2);
        }
        Lil();
        if (getChildCount() > 0 && z) {
            ILil.p045lLi1LL.IL1Iii.ILL.IL1Iii.IL1Iii(this.f4930Ilil);
        }
        IiL iiL = this.f4930Ilil;
        if (iiL.f1899iILiiLl) {
            if (iiL.ILI1Ll && mode == Integer.MIN_VALUE) {
                int i8 = iiL.f19011iIl;
                if (i8 < size) {
                    iiL.ILI1Ll(i8);
                }
                this.f4930Ilil.m83I1(iILLL1.ILil.FIXED);
            }
            IiL iiL2 = this.f4930Ilil;
            if (iiL2.f11l && mode2 == Integer.MIN_VALUE) {
                int i9 = iiL2.LII;
                if (i9 < size2) {
                    iiL2.m87iI(i9);
                }
                this.f4930Ilil.m2647i1I1I1l(iILLL1.ILil.FIXED);
            }
        }
        if ((this.ILL & 32) == 32) {
            int iM2629L112 = this.f4930Ilil.m2629L111();
            int iM2653lIlii2 = this.f4930Ilil.m2653lIlii();
            if (this.Lil != iM2629L112 && mode == 1073741824) {
                ILil.p045lLi1LL.IL1Iii.ILL.IL1Iii.m2595L11I(this.f4930Ilil.f121, 0, iM2629L112);
            }
            if (this.LlLI1 != iM2653lIlii2 && mode2 == 1073741824) {
                ILil.p045lLi1LL.IL1Iii.ILL.IL1Iii.m2595L11I(this.f4930Ilil.f121, 1, iM2653lIlii2);
            }
            IiL iiL3 = this.f4930Ilil;
            if (iiL3.ILI1Ll && iiL3.f19011iIl > size) {
                ILil.p045lLi1LL.IL1Iii.ILL.IL1Iii.m2595L11I(iiL3.f121, 0, size);
            }
            IiL iiL4 = this.f4930Ilil;
            if (iiL4.f11l && iiL4.LII > size2) {
                ILil.p045lLi1LL.IL1Iii.ILL.IL1Iii.m2595L11I(iiL4.f121, 1, size2);
            }
        }
        if (getChildCount() > 0) {
            m3143lIiI("First pass");
        }
        int size3 = this.f2484IL.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size3 > 0) {
            iILLL1.ILil iLilIIi1 = this.f4930Ilil.iIi1();
            iILLL1.ILil iLil = iILLL1.ILil.WRAP_CONTENT;
            boolean z7 = iLilIIi1 == iLil;
            boolean z8 = this.f4930Ilil.m2652lIII() == iLil;
            int iMax = Math.max(this.f4930Ilil.m2629L111(), this.f2491lLi1LL);
            int iMax2 = Math.max(this.f4930Ilil.m2653lIlii(), this.f2488iILLL1);
            int i10 = 0;
            boolean z9 = false;
            int iCombineMeasuredStates = 0;
            while (i10 < size3) {
                iILLL1 iilll1 = this.f2484IL.get(i10);
                int i11 = size3;
                View view = (View) iilll1.m2651lIiI();
                if (view == null) {
                    i6 = iM2629L111;
                    i5 = iM2653lIlii;
                } else {
                    i5 = iM2653lIlii;
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    i6 = iM2629L111;
                    if (!layoutParams.f37i1 && !layoutParams.iIilII1) {
                        z4 = z9;
                        if (view.getVisibility() != 8 && (!z6 || !iilll1.llliI().m2618IL() || !iilll1.I11L().m2618IL())) {
                            int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                            int childMeasureSpec = (i12 == -2 && layoutParams.f2493I1L11L) ? ViewGroup.getChildMeasureSpec(i, paddingRight, i12) : View.MeasureSpec.makeMeasureSpec(iilll1.m2629L111(), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                            int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                            view.measure(childMeasureSpec, (i13 == -2 && layoutParams.f2495ILLIi) ? ViewGroup.getChildMeasureSpec(i2, paddingBottom, i13) : View.MeasureSpec.makeMeasureSpec(iilll1.m2653lIlii(), Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                            ILil.p045lLi1LL.IL1Iii.iILLL1 iilll2 = this.f2490llL1ii;
                            if (iilll2 != null) {
                                iilll2.f4531ILil++;
                            }
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredWidth != iilll1.m2629L111()) {
                                iilll1.ILI1Ll(measuredWidth);
                                if (z6) {
                                    iilll1.llliI().m2604IiL(measuredWidth);
                                }
                                if (z7 && iilll1.m2665l() > iMax) {
                                    iMax = Math.max(iMax, iilll1.m2665l() + iilll1.mo2627IiL(lLi1LL.IL.RIGHT).m2681IL());
                                }
                                z4 = true;
                            }
                            if (measuredHeight != iilll1.m2653lIlii()) {
                                iilll1.m87iI(measuredHeight);
                                if (z6) {
                                    iilll1.I11L().m2604IiL(measuredHeight);
                                }
                                if (z8 && iilll1.m2634Ll1() > iMax2) {
                                    iMax2 = Math.max(iMax2, iilll1.m2634Ll1() + iilll1.mo2627IiL(lLi1LL.IL.BOTTOM).m2681IL());
                                }
                                i7 = iMax2;
                                z5 = true;
                            } else {
                                i7 = iMax2;
                                z5 = z4;
                            }
                            if (layoutParams.f2523li11 && (baseline = view.getBaseline()) != -1 && baseline != iilll1.m2663il()) {
                                iilll1.m2624ILLIi(baseline);
                                z5 = true;
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                iCombineMeasuredStates = ViewGroup.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                            }
                            z4 = z5;
                            iMax2 = i7;
                        }
                        i10++;
                        paddingBottom = paddingBottom;
                        iM2629L111 = i6;
                        size3 = i11;
                        iM2653lIlii = i5;
                        z9 = z4;
                    }
                    iCombineMeasuredStates = iCombineMeasuredStates;
                    i10++;
                    paddingBottom = paddingBottom;
                    iM2629L111 = i6;
                    size3 = i11;
                    iM2653lIlii = i5;
                    z9 = z4;
                }
                z4 = z9;
                iCombineMeasuredStates = iCombineMeasuredStates;
                i10++;
                paddingBottom = paddingBottom;
                iM2629L111 = i6;
                size3 = i11;
                iM2653lIlii = i5;
                z9 = z4;
            }
            int i14 = size3;
            int i15 = iM2629L111;
            int i16 = iM2653lIlii;
            boolean z10 = z9;
            i3 = paddingBottom;
            int i17 = iCombineMeasuredStates;
            if (z10) {
                this.f4930Ilil.ILI1Ll(i15);
                this.f4930Ilil.m87iI(i16);
                if (z6) {
                    this.f4930Ilil.Ll1();
                }
                m3143lIiI("2nd pass");
                if (this.f4930Ilil.m2629L111() < iMax) {
                    this.f4930Ilil.ILI1Ll(iMax);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.f4930Ilil.m2653lIlii() < iMax2) {
                    this.f4930Ilil.m87iI(iMax2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    m3143lIiI("3rd pass");
                }
            }
            for (int i18 = 0; i18 < i14; i18++) {
                iILLL1 iilll3 = this.f2484IL.get(i18);
                View view2 = (View) iilll3.m2651lIiI();
                if (view2 != null && (view2.getMeasuredWidth() != iilll3.m2629L111() || view2.getMeasuredHeight() != iilll3.m2653lIlii())) {
                    if (iilll3.LL1IL() != 8) {
                        view2.measure(View.MeasureSpec.makeMeasureSpec(iilll3.m2629L111(), Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(iilll3.m2653lIlii(), Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                        ILil.p045lLi1LL.IL1Iii.iILLL1 iilll4 = this.f2490llL1ii;
                        if (iilll4 != null) {
                            iilll4.f4531ILil++;
                        }
                    }
                }
            }
            i4 = i17;
        } else {
            i3 = paddingBottom;
            i4 = 0;
        }
        int iM2629L113 = this.f4930Ilil.m2629L111() + paddingRight;
        int iM2653lIlii3 = this.f4930Ilil.m2653lIlii() + i3;
        if (Build.VERSION.SDK_INT < 11) {
            setMeasuredDimension(iM2629L113, iM2653lIlii3);
            this.Lil = iM2629L113;
            this.LlLI1 = iM2653lIlii3;
            return;
        }
        int iResolveSizeAndState = ViewGroup.resolveSizeAndState(iM2629L113, i, i4);
        int iResolveSizeAndState2 = ViewGroup.resolveSizeAndState(iM2653lIlii3, i2, i4 << 16) & 16777215;
        int iMin = Math.min(this.f2485IiL, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f2487L11I, iResolveSizeAndState2);
        if (this.f4930Ilil.m2617llI11I()) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (this.f4930Ilil.L1ii1()) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
        this.Lil = iMin;
        this.LlLI1 = iMin2;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        iILLL1 iilll1M3144lLi1LL = m3144lLi1LL(view);
        if ((view instanceof Guideline) && !(iilll1M3144lLi1LL instanceof C0650il)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            C0650il c0650il = new C0650il();
            layoutParams.l1Lll = c0650il;
            layoutParams.iIilII1 = true;
            c0650il.m2692ili(layoutParams.f2522lliiI1);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.m3136lLi1LL();
            ((LayoutParams) view.getLayoutParams()).f37i1 = true;
            if (!this.f4928I1I.contains(constraintHelper)) {
                this.f4928I1I.add(constraintHelper);
            }
        }
        this.f4929ILil.put(view.getId(), view);
        this.f2492il = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f4929ILil.remove(view.getId());
        iILLL1 iilll1M3144lLi1LL = m3144lLi1LL(view);
        this.f4930Ilil.m2677iLiLI(iilll1M3144lLi1LL);
        this.f4928I1I.remove(view);
        this.f2484IL.remove(iilll1M3144lLi1LL);
        this.f2492il = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f2492il = true;
        this.Lil = -1;
        this.LlLI1 = -1;
    }

    public void setConstraintSet(IL1Iii iL1Iii) {
        this.f2486Ll1 = iL1Iii;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f4929ILil.remove(getId());
        super.setId(i);
        this.f4929ILil.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f2487L11I) {
            return;
        }
        this.f2487L11I = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f2485IiL) {
            return;
        }
        this.f2485IiL = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f2488iILLL1) {
            return;
        }
        this.f2488iILLL1 = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f2491lLi1LL) {
            return;
        }
        this.f2491lLi1LL = i;
        requestLayout();
    }

    public void setOptimizationLevel(int i) {
        this.f4930Ilil.m2611LllI11(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:148:0x023c  */
    /* JADX WARN: Code duplicated, block: B:150:0x0242  */
    /* JADX WARN: Code duplicated, block: B:151:0x024f  */
    /* JADX WARN: Code duplicated, block: B:157:0x0267  */
    /* JADX WARN: Code duplicated, block: B:159:0x026d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0279  */
    /* JADX WARN: Code duplicated, block: B:167:0x0295  */
    /* JADX WARN: Code duplicated, block: B:169:0x029b  */
    /* JADX WARN: Code duplicated, block: B:170:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:177:0x02c3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m3145il() {
        int i;
        int i2;
        int i3;
        int i4;
        iILLL1 iilll1M3138IL;
        int i5;
        int i6;
        iILLL1 iilll1M3138IL2;
        int i7;
        int i8;
        iILLL1 iilll1M3138IL3;
        int i9;
        float f;
        View view;
        iILLL1 iilll1M3138IL4;
        iILLL1 iilll1M3138IL5;
        iILLL1 iilll1M3138IL6;
        iILLL1 iilll1M3138IL7;
        int i10;
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        ?? r3 = 0;
        int i11 = -1;
        if (zIsInEditMode) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    ILL(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    m3138IL(childAt.getId()).iIilII1(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            iILLL1 iilll1M3144lLi1LL = m3144lLi1LL(getChildAt(i13));
            if (iilll1M3144lLi1LL != null) {
                iilll1M3144lLi1LL.mo2607IIiI();
            }
        }
        if (this.f2489lIiI != -1) {
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt2 = getChildAt(i14);
                if (childAt2.getId() == this.f2489lIiI && (childAt2 instanceof Constraints)) {
                    this.f2486Ll1 = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        IL1Iii iL1Iii = this.f2486Ll1;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(this);
        }
        this.f4930Ilil.m2679ili();
        int size = this.f4928I1I.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.f4928I1I.get(i15).Ilil(this);
            }
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt3 = getChildAt(i16);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).I1I(this);
            }
        }
        int i17 = 0;
        while (i17 < childCount) {
            View childAt4 = getChildAt(i17);
            iILLL1 iilll1M3144lLi1LL2 = m3144lLi1LL(childAt4);
            if (iilll1M3144lLi1LL2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt4.getLayoutParams();
                layoutParams.IL1Iii();
                if (layoutParams.I1IILIIL) {
                    layoutParams.I1IILIIL = r3;
                } else if (zIsInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        ILL(r3, resourceName2, Integer.valueOf(childAt4.getId()));
                        m3138IL(childAt4.getId()).iIilII1(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                iilll1M3144lLi1LL2.m2648iILiiLl(childAt4.getVisibility());
                if (layoutParams.f2514ili11) {
                    iilll1M3144lLi1LL2.m2648iILiiLl(8);
                }
                iilll1M3144lLi1LL2.m2657li11(childAt4);
                this.f4930Ilil.m2678ILI(iilll1M3144lLi1LL2);
                if (!layoutParams.f2495ILLIi || !layoutParams.f2493I1L11L) {
                    this.f2484IL.add(iilll1M3144lLi1LL2);
                }
                if (layoutParams.iIilII1) {
                    C0650il c0650il = (C0650il) iilll1M3144lLi1LL2;
                    int i18 = layoutParams.f2524i11i;
                    int i19 = layoutParams.L1iI1;
                    float f2 = layoutParams.f39lL;
                    if (Build.VERSION.SDK_INT < 17) {
                        i18 = layoutParams.f4932IL1Iii;
                        i19 = layoutParams.f4933ILil;
                        f2 = layoutParams.f4931I1I;
                    }
                    if (f2 != -1.0f) {
                        c0650il.m2690iLiLI(f2);
                    } else if (i18 != i11) {
                        c0650il.lLIL1(i18);
                    } else if (i19 != i11) {
                        c0650il.m2689iI1L1Ll(i19);
                    }
                } else {
                    int i20 = layoutParams.f2498IL;
                    if (i20 != i11 || layoutParams.f4934Ilil != i11 || layoutParams.f2521lLi1LL != i11 || layoutParams.f2511iILLL1 != i11 || layoutParams.f2520llL1ii != i11 || layoutParams.LlLI1 != i11 || layoutParams.f2519lIlii != i11 || layoutParams.iIi1 != i11 || layoutParams.f2499IiL != i11 || layoutParams.f2508L11I != i11 || layoutParams.f2526il != i11 || layoutParams.ILL != i11 || layoutParams.f2506Ll1 != i11 || layoutParams.f2504LlIl != i11 || layoutParams.f2494IIiI != i11 || layoutParams.f2517lIiI != i11 || ((ViewGroup.MarginLayoutParams) layoutParams).width == i11 || ((ViewGroup.MarginLayoutParams) layoutParams).height == i11) {
                        i20 = layoutParams.f2502LIl;
                        int i21 = layoutParams.f38iI;
                        int i22 = layoutParams.f2505LlLiLL;
                        int i23 = layoutParams.f36I;
                        int i24 = layoutParams.f2513iiIIi11;
                        int i25 = layoutParams.f2512iILilI;
                        float f3 = layoutParams.f35I1;
                        if (Build.VERSION.SDK_INT < 17) {
                            i21 = layoutParams.f4934Ilil;
                            int i26 = layoutParams.f2521lLi1LL;
                            int i27 = layoutParams.f2511iILLL1;
                            i24 = layoutParams.iIlLiL;
                            i3 = layoutParams.f2527lL;
                            f3 = layoutParams.f25301;
                            if (i20 == -1 && i21 == -1) {
                                int i28 = layoutParams.f2520llL1ii;
                                if (i28 != -1) {
                                    i20 = i28;
                                } else {
                                    int i29 = layoutParams.LlLI1;
                                    if (i29 != -1) {
                                        i21 = i29;
                                    }
                                }
                            }
                            if (i26 == -1 && i27 == -1) {
                                int i30 = layoutParams.f2519lIlii;
                                if (i30 != -1) {
                                    i4 = i27;
                                    i2 = i30;
                                } else {
                                    int i31 = layoutParams.iIi1;
                                    if (i31 != -1) {
                                        i4 = i31;
                                        i2 = i26;
                                    } else {
                                        i21 = i21;
                                        i24 = i24;
                                        i3 = i3;
                                        f3 = f3;
                                        i4 = i27;
                                        i = -1;
                                        i20 = i20;
                                        i2 = i26;
                                    }
                                }
                                i = -1;
                            } else {
                                i21 = i21;
                                i24 = i24;
                                i3 = i3;
                                f3 = f3;
                                i4 = i27;
                                i = -1;
                                i20 = i20;
                                i2 = i26;
                            }
                        } else {
                            i = -1;
                            i2 = i22;
                            i3 = i25;
                            i4 = i23;
                        }
                        int i32 = layoutParams.f2517lIiI;
                        if (i32 != i) {
                            iILLL1 iilll1M3138IL8 = m3138IL(i32);
                            if (iilll1M3138IL8 != null) {
                                iilll1M3144lLi1LL2.m2655lLi1LL(iilll1M3138IL8, layoutParams.Lil, layoutParams.f2496ILl);
                            }
                        } else {
                            if (i20 != i) {
                                iILLL1 iilll1M3138IL9 = m3138IL(i20);
                                if (iilll1M3138IL9 != null) {
                                    lLi1LL.IL il = lLi1LL.IL.LEFT;
                                    iilll1M3144lLi1LL2.m2662iILLl(il, iilll1M3138IL9, il, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i24);
                                }
                            } else if (i21 == i) {
                                if (i2 != i) {
                                    iilll1M3138IL7 = m3138IL(i2);
                                    if (iilll1M3138IL7 != null) {
                                        iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.RIGHT, iilll1M3138IL7, lLi1LL.IL.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3);
                                    }
                                } else if (i4 != i && (iilll1M3138IL = m3138IL(i4)) != null) {
                                    lLi1LL.IL il2 = lLi1LL.IL.RIGHT;
                                    iilll1M3144lLi1LL2.m2662iILLl(il2, iilll1M3138IL, il2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3);
                                }
                                i5 = layoutParams.f2499IiL;
                                if (i5 != -1) {
                                    iilll1M3138IL6 = m3138IL(i5);
                                    if (iilll1M3138IL6 != null) {
                                        lLi1LL.IL il3 = lLi1LL.IL.TOP;
                                        iilll1M3144lLi1LL2.m2662iILLl(il3, iilll1M3138IL6, il3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.I11li1);
                                    }
                                } else {
                                    i6 = layoutParams.f2508L11I;
                                    if (i6 != -1 && (iilll1M3138IL2 = m3138IL(i6)) != null) {
                                        iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.TOP, iilll1M3138IL2, lLi1LL.IL.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.I11li1);
                                    }
                                }
                                i7 = layoutParams.f2526il;
                                if (i7 != -1) {
                                    iilll1M3138IL5 = m3138IL(i7);
                                    if (iilll1M3138IL5 != null) {
                                        iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.BOTTOM, iilll1M3138IL5, lLi1LL.IL.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.I11L);
                                    }
                                } else {
                                    i8 = layoutParams.ILL;
                                    if (i8 != -1 && (iilll1M3138IL3 = m3138IL(i8)) != null) {
                                        lLi1LL.IL il4 = lLi1LL.IL.BOTTOM;
                                        iilll1M3144lLi1LL2.m2662iILLl(il4, iilll1M3138IL3, il4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.I11L);
                                    }
                                }
                                i9 = layoutParams.f2506Ll1;
                                if (i9 != -1) {
                                    view = this.f4929ILil.get(i9);
                                    iilll1M3138IL4 = m3138IL(layoutParams.f2506Ll1);
                                    if (iilll1M3138IL4 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
                                        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                                        layoutParams.f2523li11 = true;
                                        layoutParams2.f2523li11 = true;
                                        lLi1LL.IL il5 = lLi1LL.IL.BASELINE;
                                        iilll1M3144lLi1LL2.mo2627IiL(il5).IL1Iii(iilll1M3138IL4.mo2627IiL(il5), 0, -1, lLi1LL.I1I.STRONG, 0, true);
                                        iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.TOP).m2686lIiI();
                                        iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.BOTTOM).m2686lIiI();
                                    }
                                }
                                if (f3 >= 0.0f && f3 != 0.5f) {
                                    iilll1M3144lLi1LL2.m84I(f3);
                                }
                                f = layoutParams.f2509LlLLL;
                                if (f >= 0.0f && f != 0.5f) {
                                    iilll1M3144lLi1LL2.LiL1(f);
                                }
                            } else {
                                iILLL1 iilll1M3138IL10 = m3138IL(i21);
                                if (iilll1M3138IL10 != null) {
                                    iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.LEFT, iilll1M3138IL10, lLi1LL.IL.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i24);
                                }
                            }
                            i = -1;
                            if (i2 != i) {
                                iilll1M3138IL7 = m3138IL(i2);
                                if (iilll1M3138IL7 != null) {
                                    iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.RIGHT, iilll1M3138IL7, lLi1LL.IL.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3);
                                }
                            } else if (i4 != i) {
                                lLi1LL.IL il6 = lLi1LL.IL.RIGHT;
                                iilll1M3144lLi1LL2.m2662iILLl(il6, iilll1M3138IL, il6, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i3);
                            }
                            i5 = layoutParams.f2499IiL;
                            if (i5 != -1) {
                                iilll1M3138IL6 = m3138IL(i5);
                                if (iilll1M3138IL6 != null) {
                                    lLi1LL.IL il7 = lLi1LL.IL.TOP;
                                    iilll1M3144lLi1LL2.m2662iILLl(il7, iilll1M3138IL6, il7, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.I11li1);
                                }
                            } else {
                                i6 = layoutParams.f2508L11I;
                                if (i6 != -1) {
                                    iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.TOP, iilll1M3138IL2, lLi1LL.IL.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.I11li1);
                                }
                            }
                            i7 = layoutParams.f2526il;
                            if (i7 != -1) {
                                iilll1M3138IL5 = m3138IL(i7);
                                if (iilll1M3138IL5 != null) {
                                    iilll1M3144lLi1LL2.m2662iILLl(lLi1LL.IL.BOTTOM, iilll1M3138IL5, lLi1LL.IL.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.I11L);
                                }
                            } else {
                                i8 = layoutParams.ILL;
                                if (i8 != -1) {
                                    lLi1LL.IL il8 = lLi1LL.IL.BOTTOM;
                                    iilll1M3144lLi1LL2.m2662iILLl(il8, iilll1M3138IL3, il8, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.I11L);
                                }
                            }
                            i9 = layoutParams.f2506Ll1;
                            if (i9 != -1) {
                                view = this.f4929ILil.get(i9);
                                iilll1M3138IL4 = m3138IL(layoutParams.f2506Ll1);
                                if (iilll1M3138IL4 != null) {
                                    LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                                    layoutParams.f2523li11 = true;
                                    layoutParams3.f2523li11 = true;
                                    lLi1LL.IL il9 = lLi1LL.IL.BASELINE;
                                    iilll1M3144lLi1LL2.mo2627IiL(il9).IL1Iii(iilll1M3138IL4.mo2627IiL(il9), 0, -1, lLi1LL.I1I.STRONG, 0, true);
                                    iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.TOP).m2686lIiI();
                                    iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.BOTTOM).m2686lIiI();
                                }
                            }
                            if (f3 >= 0.0f) {
                                iilll1M3144lLi1LL2.m84I(f3);
                            }
                            f = layoutParams.f2509LlLLL;
                            if (f >= 0.0f) {
                                iilll1M3144lLi1LL2.LiL1(f);
                            }
                        }
                        if (zIsInEditMode) {
                            int i33 = layoutParams.f2504LlIl;
                            i10 = -1;
                            if (i33 != -1 || layoutParams.f2494IIiI != -1) {
                                iilll1M3144lLi1LL2.m2661i11LL(i33, layoutParams.f2494IIiI);
                            }
                        } else {
                            i10 = -1;
                        }
                        if (layoutParams.f2493I1L11L) {
                            iilll1M3144lLi1LL2.m83I1(iILLL1.ILil.FIXED);
                            iilll1M3144lLi1LL2.ILI1Ll(((ViewGroup.MarginLayoutParams) layoutParams).width);
                        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == i10) {
                            iilll1M3144lLi1LL2.m83I1(iILLL1.ILil.MATCH_PARENT);
                            iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.LEFT).f4517Ilil = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                            iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.RIGHT).f4517Ilil = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            iilll1M3144lLi1LL2.m83I1(iILLL1.ILil.MATCH_CONSTRAINT);
                            iilll1M3144lLi1LL2.ILI1Ll(0);
                        }
                        if (layoutParams.f2495ILLIi) {
                            r3 = 0;
                            i11 = -1;
                            iilll1M3144lLi1LL2.m2647i1I1I1l(iILLL1.ILil.FIXED);
                            iilll1M3144lLi1LL2.m87iI(((ViewGroup.MarginLayoutParams) layoutParams).height);
                        } else {
                            i11 = -1;
                            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                                iilll1M3144lLi1LL2.m2647i1I1I1l(iILLL1.ILil.MATCH_PARENT);
                                iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.TOP).f4517Ilil = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                                iilll1M3144lLi1LL2.mo2627IiL(lLi1LL.IL.BOTTOM).f4517Ilil = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                r3 = 0;
                            } else {
                                iilll1M3144lLi1LL2.m2647i1I1I1l(iILLL1.ILil.MATCH_CONSTRAINT);
                                r3 = 0;
                                iilll1M3144lLi1LL2.m87iI(0);
                            }
                        }
                        String str = layoutParams.f2518lIII;
                        if (str != null) {
                            iilll1M3144lLi1LL2.m86i1(str);
                        }
                        iilll1M3144lLi1LL2.L1iI1(layoutParams.f2501L111);
                        iilll1M3144lLi1LL2.m911(layoutParams.f2529LLlI1);
                        iilll1M3144lLi1LL2.m2643iiIIi11(layoutParams.f40);
                        iilll1M3144lLi1LL2.Liil1L1l(layoutParams.llI);
                        iilll1M3144lLi1LL2.m2660i11i(layoutParams.f2516l1IIi1, layoutParams.f2525iILLl, layoutParams.f2503LIll, layoutParams.f2531);
                        iilll1M3144lLi1LL2.m2640iI1LI(layoutParams.f2507L1l, layoutParams.f2497IIi, layoutParams.f2515ill, layoutParams.f2500L11);
                    }
                }
            }
            i17++;
            r3 = r3;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4929ILil = new SparseArray<>();
        this.f4928I1I = new ArrayList<>(4);
        this.f2484IL = new ArrayList<>(100);
        this.f4930Ilil = new IiL();
        this.f2491lLi1LL = 0;
        this.f2488iILLL1 = 0;
        this.f2485IiL = Integer.MAX_VALUE;
        this.f2487L11I = Integer.MAX_VALUE;
        this.f2492il = true;
        this.ILL = 7;
        this.f2486Ll1 = null;
        this.f2489lIiI = -1;
        this.f2483ILl = new HashMap<>();
        this.Lil = -1;
        this.LlLI1 = -1;
        m3142iILLL1(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4929ILil = new SparseArray<>();
        this.f4928I1I = new ArrayList<>(4);
        this.f2484IL = new ArrayList<>(100);
        this.f4930Ilil = new IiL();
        this.f2491lLi1LL = 0;
        this.f2488iILLL1 = 0;
        this.f2485IiL = Integer.MAX_VALUE;
        this.f2487L11I = Integer.MAX_VALUE;
        this.f2492il = true;
        this.ILL = 7;
        this.f2486Ll1 = null;
        this.f2489lIiI = -1;
        this.f2483ILl = new HashMap<>();
        this.Lil = -1;
        this.LlLI1 = -1;
        m3142iILLL1(attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: I1 */
        public float f35I1;
        public int I11L;
        public int I11li1;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f4931I1I;
        public boolean I1IILIIL;

        /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
        public boolean f2493I1L11L;

        /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
        public int f2494IIiI;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4932IL1Iii;
        public int ILL;

        /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
        public boolean f2495ILLIi;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4933ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public int f2496ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4934Ilil;

        /* JADX INFO: renamed from: I丨 */
        public int f36I;

        /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
        public int f2497IIi;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2498IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f2499IiL;

        /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
        public float f2500L11;

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public float f2501L111;
        public int L1iI1;

        /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
        public int f2502LIl;

        /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
        public int f2503LIll;
        public int LL1IL;
        public boolean LLL;
        public float Lil;

        /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
        public int f2504LlIl;
        public int LlLI1;

        /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
        public int f2505LlLiLL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public int f2506Ll1;

        /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
        public int f2507L1l;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f2508L11I;

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public float f2509LlLLL;

        /* JADX INFO: renamed from: i1 */
        public boolean f37i1;

        /* JADX INFO: renamed from: iI */
        public int f38iI;

        /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
        public boolean f2510iI1iI;
        public int iIi1;
        public boolean iIilII1;
        public int iIlLiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f2511iILLL1;

        /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
        public int f2512iILilI;

        /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
        public int f2513iiIIi11;

        /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
        public boolean f2514ili11;

        /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
        public int f2515ill;

        /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
        public int f2516l1IIi1;
        public iILLL1 l1Lll;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public int f2517lIiI;

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public String f2518lIII;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public int f2519lIlii;

        /* JADX INFO: renamed from: lL */
        public float f39lL;
        public int llI;
        public int llliI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public int f2520llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2521lLi1LL;

        /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
        public int f2522lliiI1;

        /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
        public boolean f2523li11;

        /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
        public int f2524i11i;

        /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
        public int f2525iILLl;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int f2526il;

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public int f2527lL;

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public int f2528l;

        /* JADX INFO: renamed from: 丨丨 */
        public int f40;

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public float f2529LLlI1;

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public float f25301;

        /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
        public float f2531;

        public static class IL1Iii {

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public static final SparseIntArray f4935IL1Iii;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f4935IL1Iii = sparseIntArray;
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(I1I.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            int i;
            super(context, attributeSet);
            this.f4932IL1Iii = -1;
            this.f4933ILil = -1;
            this.f4931I1I = -1.0f;
            this.f2498IL = -1;
            this.f4934Ilil = -1;
            this.f2521lLi1LL = -1;
            this.f2511iILLL1 = -1;
            this.f2499IiL = -1;
            this.f2508L11I = -1;
            this.f2526il = -1;
            this.ILL = -1;
            this.f2506Ll1 = -1;
            this.f2517lIiI = -1;
            this.f2496ILl = 0;
            this.Lil = 0.0f;
            this.LlLI1 = -1;
            this.f2520llL1ii = -1;
            this.f2519lIlii = -1;
            this.iIi1 = -1;
            this.iIlLiL = -1;
            this.I11li1 = -1;
            this.f2527lL = -1;
            this.I11L = -1;
            this.llliI = -1;
            this.f2528l = -1;
            this.f25301 = 0.5f;
            this.f2509LlLLL = 0.5f;
            this.f2518lIII = null;
            this.LL1IL = 1;
            this.f2501L111 = -1.0f;
            this.f2529LLlI1 = -1.0f;
            this.f40 = 0;
            this.llI = 0;
            this.f2516l1IIi1 = 0;
            this.f2507L1l = 0;
            this.f2525iILLl = 0;
            this.f2497IIi = 0;
            this.f2503LIll = 0;
            this.f2515ill = 0;
            this.f2531 = 1.0f;
            this.f2500L11 = 1.0f;
            this.f2504LlIl = -1;
            this.f2494IIiI = -1;
            this.f2522lliiI1 = -1;
            this.LLL = false;
            this.f2510iI1iI = false;
            this.f2493I1L11L = true;
            this.f2495ILLIi = true;
            this.f2523li11 = false;
            this.iIilII1 = false;
            this.f37i1 = false;
            this.f2514ili11 = false;
            this.f2502LIl = -1;
            this.f38iI = -1;
            this.f2505LlLiLL = -1;
            this.f36I = -1;
            this.f2513iiIIi11 = -1;
            this.f2512iILilI = -1;
            this.f35I1 = 0.5f;
            this.l1Lll = new iILLL1();
            this.I1IILIIL = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I1I.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                int i3 = IL1Iii.f4935IL1Iii.get(index);
                switch (i3) {
                    case 1:
                        this.f2522lliiI1 = typedArrayObtainStyledAttributes.getInt(index, this.f2522lliiI1);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2517lIiI);
                        this.f2517lIiI = resourceId;
                        if (resourceId == -1) {
                            this.f2517lIiI = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f2496ILl = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2496ILl);
                        break;
                    case 4:
                        float f = typedArrayObtainStyledAttributes.getFloat(index, this.Lil) % 360.0f;
                        this.Lil = f;
                        if (f < 0.0f) {
                            this.Lil = (360.0f - f) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f4932IL1Iii = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4932IL1Iii);
                        break;
                    case 6:
                        this.f4933ILil = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4933ILil);
                        break;
                    case 7:
                        this.f4931I1I = typedArrayObtainStyledAttributes.getFloat(index, this.f4931I1I);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2498IL);
                        this.f2498IL = resourceId2;
                        if (resourceId2 == -1) {
                            this.f2498IL = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4934Ilil);
                        this.f4934Ilil = resourceId3;
                        if (resourceId3 == -1) {
                            this.f4934Ilil = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2521lLi1LL);
                        this.f2521lLi1LL = resourceId4;
                        if (resourceId4 == -1) {
                            this.f2521lLi1LL = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2511iILLL1);
                        this.f2511iILLL1 = resourceId5;
                        if (resourceId5 == -1) {
                            this.f2511iILLL1 = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2499IiL);
                        this.f2499IiL = resourceId6;
                        if (resourceId6 == -1) {
                            this.f2499IiL = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2508L11I);
                        this.f2508L11I = resourceId7;
                        if (resourceId7 == -1) {
                            this.f2508L11I = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2526il);
                        this.f2526il = resourceId8;
                        if (resourceId8 == -1) {
                            this.f2526il = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.ILL);
                        this.ILL = resourceId9;
                        if (resourceId9 == -1) {
                            this.ILL = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2506Ll1);
                        this.f2506Ll1 = resourceId10;
                        if (resourceId10 == -1) {
                            this.f2506Ll1 = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.LlLI1);
                        this.LlLI1 = resourceId11;
                        if (resourceId11 == -1) {
                            this.LlLI1 = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2520llL1ii);
                        this.f2520llL1ii = resourceId12;
                        if (resourceId12 == -1) {
                            this.f2520llL1ii = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2519lIlii);
                        this.f2519lIlii = resourceId13;
                        if (resourceId13 == -1) {
                            this.f2519lIlii = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.iIi1);
                        this.iIi1 = resourceId14;
                        if (resourceId14 == -1) {
                            this.iIi1 = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.iIlLiL = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.iIlLiL);
                        break;
                    case 22:
                        this.I11li1 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I11li1);
                        break;
                    case 23:
                        this.f2527lL = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2527lL);
                        break;
                    case 24:
                        this.I11L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I11L);
                        break;
                    case 25:
                        this.llliI = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.llliI);
                        break;
                    case 26:
                        this.f2528l = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2528l);
                        break;
                    case 27:
                        this.LLL = typedArrayObtainStyledAttributes.getBoolean(index, this.LLL);
                        break;
                    case 28:
                        this.f2510iI1iI = typedArrayObtainStyledAttributes.getBoolean(index, this.f2510iI1iI);
                        break;
                    case 29:
                        this.f25301 = typedArrayObtainStyledAttributes.getFloat(index, this.f25301);
                        break;
                    case 30:
                        this.f2509LlLLL = typedArrayObtainStyledAttributes.getFloat(index, this.f2509LlLLL);
                        break;
                    case 31:
                        int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f2516l1IIi1 = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f2507L1l = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.f2525iILLl = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2525iILLl);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2525iILLl) == -2) {
                                this.f2525iILLl = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.f2503LIll = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2503LIll);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2503LIll) == -2) {
                                this.f2503LIll = -2;
                            }
                        }
                        break;
                    case 35:
                        this.f2531 = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2531));
                        break;
                    case 36:
                        try {
                            this.f2497IIi = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2497IIi);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2497IIi) == -2) {
                                this.f2497IIi = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.f2515ill = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2515ill);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2515ill) == -2) {
                                this.f2515ill = -2;
                            }
                        }
                        break;
                    case 38:
                        this.f2500L11 = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2500L11));
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f2518lIII = string;
                                this.LL1IL = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f2518lIII.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String strSubstring = this.f2518lIII.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.LL1IL = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.LL1IL = 1;
                                        }
                                        i = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f2518lIII.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f2518lIII.substring(i);
                                        if (strSubstring2.length() > 0) {
                                            Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.f2518lIII.substring(i, iIndexOf2);
                                        String strSubstring4 = this.f2518lIII.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f2 = Float.parseFloat(strSubstring3);
                                                float f3 = Float.parseFloat(strSubstring4);
                                                if (f2 > 0.0f && f3 > 0.0f) {
                                                    if (this.LL1IL == 1) {
                                                        Math.abs(f3 / f2);
                                                    } else {
                                                        Math.abs(f2 / f3);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.f2501L111 = typedArrayObtainStyledAttributes.getFloat(index, this.f2501L111);
                                break;
                            case 46:
                                this.f2529LLlI1 = typedArrayObtainStyledAttributes.getFloat(index, this.f2529LLlI1);
                                break;
                            case 47:
                                this.f40 = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.llI = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f2504LlIl = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2504LlIl);
                                break;
                            case 50:
                                this.f2494IIiI = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2494IIiI);
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            IL1Iii();
        }

        public void IL1Iii() {
            this.iIilII1 = false;
            this.f2493I1L11L = true;
            this.f2495ILLIi = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.LLL) {
                this.f2493I1L11L = false;
                this.f2516l1IIi1 = 1;
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.f2510iI1iI) {
                this.f2495ILLIi = false;
                this.f2507L1l = 1;
            }
            if (i == 0 || i == -1) {
                this.f2493I1L11L = false;
                if (i == 0 && this.f2516l1IIi1 == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.LLL = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.f2495ILLIi = false;
                if (i2 == 0 && this.f2507L1l == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f2510iI1iI = true;
                }
            }
            if (this.f4931I1I == -1.0f && this.f4932IL1Iii == -1 && this.f4933ILil == -1) {
                return;
            }
            this.iIilII1 = true;
            this.f2493I1L11L = true;
            this.f2495ILLIi = true;
            if (!(this.l1Lll instanceof C0650il)) {
                this.l1Lll = new C0650il();
            }
            ((C0650il) this.l1Lll).m2692ili(this.f2522lliiI1);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004c  */
        /* JADX WARN: Code duplicated, block: B:19:0x0053  */
        /* JADX WARN: Code duplicated, block: B:22:0x005a  */
        /* JADX WARN: Code duplicated, block: B:25:0x0060  */
        /* JADX WARN: Code duplicated, block: B:28:0x0066  */
        /* JADX WARN: Code duplicated, block: B:35:0x007c  */
        /* JADX WARN: Code duplicated, block: B:36:0x0084  */
        /* JADX WARN: Code duplicated, block: B:38:0x0088  */
        /* JADX WARN: Code duplicated, block: B:39:0x008f  */
        /* JADX WARN: Code duplicated, block: B:41:0x0093  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            float f;
            int i6;
            int i7;
            int i8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            this.f2505LlLiLL = -1;
            this.f36I = -1;
            this.f2502LIl = -1;
            this.f38iI = -1;
            this.f2513iiIIi11 = -1;
            this.f2512iILilI = -1;
            this.f2513iiIIi11 = this.iIlLiL;
            this.f2512iILilI = this.f2527lL;
            this.f35I1 = this.f25301;
            this.f2524i11i = this.f4932IL1Iii;
            this.L1iI1 = this.f4933ILil;
            this.f39lL = this.f4931I1I;
            boolean z = false;
            if (1 == getLayoutDirection()) {
                int i10 = this.LlLI1;
                if (i10 != -1) {
                    this.f2505LlLiLL = i10;
                } else {
                    int i11 = this.f2520llL1ii;
                    if (i11 != -1) {
                        this.f36I = i11;
                    } else {
                        i2 = this.f2519lIlii;
                        if (i2 != -1) {
                            this.f38iI = i2;
                            z = true;
                        }
                        i3 = this.iIi1;
                        if (i3 != -1) {
                            this.f2502LIl = i3;
                            z = true;
                        }
                        i4 = this.llliI;
                        if (i4 != -1) {
                            this.f2512iILilI = i4;
                        }
                        i5 = this.f2528l;
                        if (i5 != -1) {
                            this.f2513iiIIi11 = i5;
                        }
                        if (z) {
                            this.f35I1 = 1.0f - this.f25301;
                        }
                        if (this.iIilII1 && this.f2522lliiI1 == 1) {
                            f = this.f4931I1I;
                            if (f != -1.0f) {
                                this.f39lL = 1.0f - f;
                                this.f2524i11i = -1;
                                this.L1iI1 = -1;
                            } else {
                                i6 = this.f4932IL1Iii;
                                if (i6 != -1) {
                                    this.L1iI1 = i6;
                                    this.f2524i11i = -1;
                                    this.f39lL = -1.0f;
                                } else {
                                    i7 = this.f4933ILil;
                                    if (i7 != -1) {
                                        this.f2524i11i = i7;
                                        this.L1iI1 = -1;
                                        this.f39lL = -1.0f;
                                    }
                                }
                            }
                        }
                    }
                }
                z = true;
                i2 = this.f2519lIlii;
                if (i2 != -1) {
                    this.f38iI = i2;
                    z = true;
                }
                i3 = this.iIi1;
                if (i3 != -1) {
                    this.f2502LIl = i3;
                    z = true;
                }
                i4 = this.llliI;
                if (i4 != -1) {
                    this.f2512iILilI = i4;
                }
                i5 = this.f2528l;
                if (i5 != -1) {
                    this.f2513iiIIi11 = i5;
                }
                if (z) {
                    this.f35I1 = 1.0f - this.f25301;
                }
                if (this.iIilII1) {
                    f = this.f4931I1I;
                    if (f != -1.0f) {
                        this.f39lL = 1.0f - f;
                        this.f2524i11i = -1;
                        this.L1iI1 = -1;
                    } else {
                        i6 = this.f4932IL1Iii;
                        if (i6 != -1) {
                            this.L1iI1 = i6;
                            this.f2524i11i = -1;
                            this.f39lL = -1.0f;
                        } else {
                            i7 = this.f4933ILil;
                            if (i7 != -1) {
                                this.f2524i11i = i7;
                                this.L1iI1 = -1;
                                this.f39lL = -1.0f;
                            }
                        }
                    }
                }
            } else {
                int i12 = this.LlLI1;
                if (i12 != -1) {
                    this.f38iI = i12;
                }
                int i13 = this.f2520llL1ii;
                if (i13 != -1) {
                    this.f2502LIl = i13;
                }
                int i14 = this.f2519lIlii;
                if (i14 != -1) {
                    this.f2505LlLiLL = i14;
                }
                int i15 = this.iIi1;
                if (i15 != -1) {
                    this.f36I = i15;
                }
                int i16 = this.llliI;
                if (i16 != -1) {
                    this.f2513iiIIi11 = i16;
                }
                int i17 = this.f2528l;
                if (i17 != -1) {
                    this.f2512iILilI = i17;
                }
            }
            if (this.f2519lIlii == -1 && this.iIi1 == -1 && this.f2520llL1ii == -1 && this.LlLI1 == -1) {
                int i18 = this.f2521lLi1LL;
                if (i18 != -1) {
                    this.f2505LlLiLL = i18;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                    }
                } else {
                    int i19 = this.f2511iILLL1;
                    if (i19 != -1) {
                        this.f36I = i19;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i9 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i9;
                        }
                    }
                }
                int i20 = this.f2498IL;
                if (i20 != -1) {
                    this.f2502LIl = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                    return;
                }
                int i21 = this.f4934Ilil;
                if (i21 != -1) {
                    this.f38iI = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i8 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i8;
                }
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4932IL1Iii = -1;
            this.f4933ILil = -1;
            this.f4931I1I = -1.0f;
            this.f2498IL = -1;
            this.f4934Ilil = -1;
            this.f2521lLi1LL = -1;
            this.f2511iILLL1 = -1;
            this.f2499IiL = -1;
            this.f2508L11I = -1;
            this.f2526il = -1;
            this.ILL = -1;
            this.f2506Ll1 = -1;
            this.f2517lIiI = -1;
            this.f2496ILl = 0;
            this.Lil = 0.0f;
            this.LlLI1 = -1;
            this.f2520llL1ii = -1;
            this.f2519lIlii = -1;
            this.iIi1 = -1;
            this.iIlLiL = -1;
            this.I11li1 = -1;
            this.f2527lL = -1;
            this.I11L = -1;
            this.llliI = -1;
            this.f2528l = -1;
            this.f25301 = 0.5f;
            this.f2509LlLLL = 0.5f;
            this.f2518lIII = null;
            this.LL1IL = 1;
            this.f2501L111 = -1.0f;
            this.f2529LLlI1 = -1.0f;
            this.f40 = 0;
            this.llI = 0;
            this.f2516l1IIi1 = 0;
            this.f2507L1l = 0;
            this.f2525iILLl = 0;
            this.f2497IIi = 0;
            this.f2503LIll = 0;
            this.f2515ill = 0;
            this.f2531 = 1.0f;
            this.f2500L11 = 1.0f;
            this.f2504LlIl = -1;
            this.f2494IIiI = -1;
            this.f2522lliiI1 = -1;
            this.LLL = false;
            this.f2510iI1iI = false;
            this.f2493I1L11L = true;
            this.f2495ILLIi = true;
            this.f2523li11 = false;
            this.iIilII1 = false;
            this.f37i1 = false;
            this.f2514ili11 = false;
            this.f2502LIl = -1;
            this.f38iI = -1;
            this.f2505LlLiLL = -1;
            this.f36I = -1;
            this.f2513iiIIi11 = -1;
            this.f2512iILilI = -1;
            this.f35I1 = 0.5f;
            this.l1Lll = new iILLL1();
            this.I1IILIIL = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4932IL1Iii = -1;
            this.f4933ILil = -1;
            this.f4931I1I = -1.0f;
            this.f2498IL = -1;
            this.f4934Ilil = -1;
            this.f2521lLi1LL = -1;
            this.f2511iILLL1 = -1;
            this.f2499IiL = -1;
            this.f2508L11I = -1;
            this.f2526il = -1;
            this.ILL = -1;
            this.f2506Ll1 = -1;
            this.f2517lIiI = -1;
            this.f2496ILl = 0;
            this.Lil = 0.0f;
            this.LlLI1 = -1;
            this.f2520llL1ii = -1;
            this.f2519lIlii = -1;
            this.iIi1 = -1;
            this.iIlLiL = -1;
            this.I11li1 = -1;
            this.f2527lL = -1;
            this.I11L = -1;
            this.llliI = -1;
            this.f2528l = -1;
            this.f25301 = 0.5f;
            this.f2509LlLLL = 0.5f;
            this.f2518lIII = null;
            this.LL1IL = 1;
            this.f2501L111 = -1.0f;
            this.f2529LLlI1 = -1.0f;
            this.f40 = 0;
            this.llI = 0;
            this.f2516l1IIi1 = 0;
            this.f2507L1l = 0;
            this.f2525iILLl = 0;
            this.f2497IIi = 0;
            this.f2503LIll = 0;
            this.f2515ill = 0;
            this.f2531 = 1.0f;
            this.f2500L11 = 1.0f;
            this.f2504LlIl = -1;
            this.f2494IIiI = -1;
            this.f2522lliiI1 = -1;
            this.LLL = false;
            this.f2510iI1iI = false;
            this.f2493I1L11L = true;
            this.f2495ILLIi = true;
            this.f2523li11 = false;
            this.iIilII1 = false;
            this.f37i1 = false;
            this.f2514ili11 = false;
            this.f2502LIl = -1;
            this.f38iI = -1;
            this.f2505LlLiLL = -1;
            this.f36I = -1;
            this.f2513iiIIi11 = -1;
            this.f2512iILilI = -1;
            this.f35I1 = 0.5f;
            this.l1Lll = new iILLL1();
            this.I1IILIIL = false;
        }
    }
}
