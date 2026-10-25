package androidx.recyclerview.widget;

import ILil.p028IiL.p029ILl.LL1IL.I1I;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int[] f5044I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f5045IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5046ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final SparseIntArray f5047Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public View[] f2666IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final Rect f2667IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2668L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ILil f2669iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final SparseIntArray f2670lLi1LL;

    public static final class IL1Iii extends ILil {
        @Override // androidx.recyclerview.widget.GridLayoutManager.ILil
        public int Ilil(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.ILil
        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int mo3243lLi1LL(int i) {
            return 1;
        }
    }

    public static abstract class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final SparseIntArray f5049IL1Iii = new SparseIntArray();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final SparseIntArray f5050ILil = new SparseIntArray();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f5048I1I = false;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2671IL = false;

        public static int IL1Iii(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int I1I(int i, int i2) {
            if (!this.f5048I1I) {
                return Ilil(i, i2);
            }
            int i3 = this.f5049IL1Iii.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iIlil = Ilil(i, i2);
            this.f5049IL1Iii.put(i, iIlil);
            return iIlil;
        }

        public int ILil(int i, int i2) {
            if (!this.f2671IL) {
                return m3244IL(i, i2);
            }
            int i3 = this.f5050ILil.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iM3244IL = m3244IL(i, i2);
            this.f5050ILil.put(i, iM3244IL);
            return iM3244IL;
        }

        public abstract int Ilil(int i, int i2);

        /* JADX WARN: Code duplicated, block: B:13:0x002d  */
        /* JADX WARN: Code duplicated, block: B:15:0x0034  */
        /* JADX WARN: Code duplicated, block: B:16:0x0038 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x003a  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:26:0x003d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int m3244IL(int i, int i2) {
            int i3;
            int iI1I;
            int i4;
            int iMo3243lLi1LL;
            int iMo3243lLi1LL2;
            int iIL1Iii;
            if (this.f2671IL && (iIL1Iii = IL1Iii(this.f5050ILil, i)) != -1) {
                i4 = this.f5050ILil.get(iIL1Iii);
                i3 = iIL1Iii + 1;
                iI1I = I1I(iIL1Iii, i2) + mo3243lLi1LL(iIL1Iii);
                i4 = iI1I == i2 ? i4 + 1 : 0;
                iMo3243lLi1LL = mo3243lLi1LL(i);
                while (i3 < i) {
                    iMo3243lLi1LL2 = mo3243lLi1LL(i3);
                    iI1I += iMo3243lLi1LL2;
                    if (iI1I == i2) {
                        i4++;
                        iI1I = 0;
                    } else if (iI1I > i2) {
                        i4++;
                        iI1I = iMo3243lLi1LL2;
                    }
                    i3++;
                }
                if (iI1I + iMo3243lLi1LL > i2) {
                    return i4 + 1;
                }
                return i4;
            }
            i3 = 0;
            iI1I = 0;
            iMo3243lLi1LL = mo3243lLi1LL(i);
            while (i3 < i) {
                iMo3243lLi1LL2 = mo3243lLi1LL(i3);
                iI1I += iMo3243lLi1LL2;
                if (iI1I == i2) {
                    i4++;
                    iI1I = 0;
                } else if (iI1I > i2) {
                    i4++;
                    iI1I = iMo3243lLi1LL2;
                }
                i3++;
            }
            if (iI1I + iMo3243lLi1LL > i2) {
                return i4 + 1;
            }
            return i4;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m3245IiL() {
            this.f5049IL1Iii.clear();
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m3246iILLL1() {
            this.f5050ILil.clear();
        }

        /* JADX INFO: renamed from: l丨Li1LL */
        public abstract int mo3243lLi1LL(int i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5045IL1Iii = false;
        this.f5046ILil = -1;
        this.f5047Ilil = new SparseIntArray();
        this.f2670lLi1LL = new SparseIntArray();
        this.f2669iILLL1 = new IL1Iii();
        this.f2667IiL = new Rect();
        m3239lIlii(RecyclerView.LlLI1.getProperties(context, attributeSet, i, i2).f5081ILil);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int[] m3232IL(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    public final void I1I(int i) {
        this.f5044I1I = m3232IL(this.f5044I1I, this.f5046ILil, i);
    }

    public final void IL1Iii(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.f2666IL[i2];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iM3233ILl = m3233ILl(lLVar, c1, getPosition(view));
            layoutParams.f2672lLi1LL = iM3233ILl;
            layoutParams.f5051Ilil = i4;
            i4 += iM3233ILl;
            i2 += i3;
        }
    }

    public int ILL() {
        return this.f5046ILil;
    }

    public final void ILil() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int iIL1Iii = layoutParams.IL1Iii();
            this.f5047Ilil.put(iIL1Iii, layoutParams.m3247lLi1LL());
            this.f2670lLi1LL.put(iIL1Iii, layoutParams.Ilil());
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final int m3233ILl(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i) {
        if (!c1.Ilil()) {
            return this.f2669iILLL1.mo3243lLi1LL(i);
        }
        int i2 = this.f5047Ilil.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM3291lLi1LL = lLVar.m3291lLi1LL(i);
        if (iM3291lLi1LL != -1) {
            return this.f2669iILLL1.mo3243lLi1LL(iM3291lLi1LL);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void Ilil() {
        this.f5047Ilil.clear();
        this.f2670lLi1LL.clear();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3234IiL(RecyclerView.lL lLVar, RecyclerView.C1 c1, LinearLayoutManager.IL1Iii iL1Iii, int i) {
        boolean z = i == 1;
        int iM3238lIiI = m3238lIiI(lLVar, c1, iL1Iii.f5058ILil);
        if (z) {
            while (iM3238lIiI > 0) {
                int i2 = iL1Iii.f5058ILil;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                iL1Iii.f5058ILil = i3;
                iM3238lIiI = m3238lIiI(lLVar, c1, i3);
            }
            return;
        }
        int iILil = c1.ILil() - 1;
        int i4 = iL1Iii.f5058ILil;
        while (i4 < iILil) {
            int i5 = i4 + 1;
            int iM3238lIiI2 = m3238lIiI(lLVar, c1, i5);
            if (iM3238lIiI2 <= iM3238lIiI) {
                break;
            }
            i4 = i5;
            iM3238lIiI = iM3238lIiI2;
        }
        iL1Iii.f5058ILil = i4;
    }

    public final void Lil(float f, int i) {
        I1I(Math.max(Math.round(f * this.f5046ILil), i));
    }

    public final void LlLI1(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f5076ILil;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iM3242il = m3242il(layoutParams.f5051Ilil, layoutParams.f2672lLi1LL);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.LlLI1.getChildMeasureSpec(iM3242il, i, i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            childMeasureSpec = RecyclerView.LlLI1.getChildMeasureSpec(this.mOrientationHelper.mo2353ILl(), getHeightMode(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.LlLI1.getChildMeasureSpec(iM3242il, i, i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec4 = RecyclerView.LlLI1.getChildMeasureSpec(this.mOrientationHelper.mo2353ILl(), getWidthMode(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        m3240llL1ii(view, childMeasureSpec2, childMeasureSpec, z);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final int m3235Ll1(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i) {
        if (!c1.Ilil()) {
            return this.f2669iILLL1.ILil(i, this.f5046ILil);
        }
        int iM3291lLi1LL = lLVar.m3291lLi1LL(i);
        if (iM3291lLi1LL != -1) {
            return this.f2669iILLL1.ILil(iM3291lLi1LL, this.f5046ILil);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3236L11I() {
        View[] viewArr = this.f2666IL;
        if (viewArr == null || viewArr.length != this.f5046ILil) {
            this.f2666IL = new View[this.f5046ILil];
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.C1 c1, LinearLayoutManager.I1I i1i, RecyclerView.LlLI1.I1I i1i2) {
        int iMo3243lLi1LL = this.f5046ILil;
        for (int i = 0; i < this.f5046ILil && i1i.I1I(c1) && iMo3243lLi1LL > 0; i++) {
            int i2 = i1i.f2673IL;
            i1i2.IL1Iii(i2, Math.max(0, i1i.f2677iILLL1));
            iMo3243lLi1LL -= this.f2669iILLL1.mo3243lLi1LL(i2);
            i1i.f2673IL += i1i.f5055Ilil;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollOffset(RecyclerView.C1 c1) {
        return this.f2668L11I ? m3241lLi1LL(c1) : super.computeHorizontalScrollOffset(c1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollRange(RecyclerView.C1 c1) {
        return this.f2668L11I ? m3237iILLL1(c1) : super.computeHorizontalScrollRange(c1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollOffset(RecyclerView.C1 c1) {
        return this.f2668L11I ? m3241lLi1LL(c1) : super.computeVerticalScrollOffset(c1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollRange(RecyclerView.C1 c1) {
        return this.f2668L11I ? m3237iILLL1(c1) : super.computeVerticalScrollRange(c1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i, int i2, int i3) {
        ensureLayoutState();
        int iMo2359lIiI = this.mOrientationHelper.mo2359lIiI();
        int iMo2357L11I = this.mOrientationHelper.mo2357L11I();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && m3238lIiI(lLVar, c1, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).I1I()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.mo2358iILLL1(childAt) < iMo2357L11I && this.mOrientationHelper.mo2354IL(childAt) >= iMo2359lIiI) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int getColumnCountForAccessibility(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (this.mOrientation == 1) {
            return this.f5046ILil;
        }
        if (c1.ILil() < 1) {
            return 0;
        }
        return m3235Ll1(lLVar, c1, c1.ILil() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int getRowCountForAccessibility(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (this.mOrientation == 0) {
            return this.f5046ILil;
        }
        if (c1.ILil() < 1) {
            return 0;
        }
        return m3235Ll1(lLVar, c1, c1.ILil() - 1) + 1;
    }

    public final void iIi1() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        I1I(height - paddingTop);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int m3237iILLL1(RecyclerView.C1 c1) {
        if (getChildCount() != 0 && c1.ILil() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f2669iILLL1.ILil(c1.ILil() - 1, this.f5046ILil) + 1;
                }
                return (int) (((this.mOrientationHelper.mo2354IL(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo2358iILLL1(viewFindFirstVisibleChildClosestToStart)) / ((this.f2669iILLL1.ILil(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f5046ILil) - this.f2669iILLL1.ILil(getPosition(viewFindFirstVisibleChildClosestToStart), this.f5046ILil)) + 1)) * (this.f2669iILLL1.ILil(c1.ILil() - 1, this.f5046ILil) + 1));
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final int m3238lIiI(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i) {
        if (!c1.Ilil()) {
            return this.f2669iILLL1.I1I(i, this.f5046ILil);
        }
        int i2 = this.f2670lLi1LL.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM3291lLi1LL = lLVar.m3291lLi1LL(i);
        if (iM3291lLi1LL != -1) {
            return this.f2669iILLL1.I1I(iM3291lLi1LL, this.f5046ILil);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m3239lIlii(int i) {
        if (i == this.f5046ILil) {
            return;
        }
        this.f5045IL1Iii = true;
        if (i >= 1) {
            this.f5046ILil = i;
            this.f2669iILLL1.m3245IiL();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:98:0x0219  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.lL lLVar, RecyclerView.C1 c1, LinearLayoutManager.I1I i1i, LinearLayoutManager.ILil iLil) {
        int i;
        int iMo2362lLi1LL;
        int i2;
        int i3;
        int i4;
        int iMo2362lLi1LL2;
        int iMo2362lLi1LL3;
        int i5;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewM3248IL;
        int iMo2356Ll1 = this.mOrientationHelper.mo2356Ll1();
        ?? r5 = 0;
        boolean z = iMo2356Ll1 != 1073741824;
        int i6 = getChildCount() > 0 ? this.f5044I1I[this.f5046ILil] : 0;
        if (z) {
            iIi1();
        }
        boolean z2 = i1i.f5055Ilil == 1;
        int iM3238lIiI = this.f5046ILil;
        if (!z2) {
            iM3238lIiI = m3238lIiI(lLVar, c1, i1i.f2673IL) + m3233ILl(lLVar, c1, i1i.f2673IL);
        }
        int i7 = 0;
        while (i7 < this.f5046ILil && i1i.I1I(c1) && iM3238lIiI > 0) {
            int i8 = i1i.f2673IL;
            int iM3233ILl = m3233ILl(lLVar, c1, i8);
            if (iM3233ILl > this.f5046ILil) {
                throw new IllegalArgumentException("Item at position " + i8 + " requires " + iM3233ILl + " spans but GridLayoutManager has only " + this.f5046ILil + " spans.");
            }
            iM3238lIiI -= iM3233ILl;
            if (iM3238lIiI < 0 || (viewM3248IL = i1i.m3248IL(lLVar)) == null) {
                break;
            }
            this.f2666IL[i7] = viewM3248IL;
            i7++;
        }
        if (i7 == 0) {
            iLil.f5062ILil = true;
            return;
        }
        float f = 0.0f;
        IL1Iii(lLVar, c1, i7, z2);
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            View view = this.f2666IL[i9];
            if (i1i.f2675Ll1 == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.f2667IiL);
            LlLI1(view, iMo2356Ll1, r5);
            int iIlil = this.mOrientationHelper.Ilil(view);
            if (iIlil > i10) {
                i10 = iIlil;
            }
            float fMo2362lLi1LL = (this.mOrientationHelper.mo2362lLi1LL(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f2672lLi1LL;
            if (fMo2362lLi1LL > f) {
                f = fMo2362lLi1LL;
            }
            i9++;
            r5 = 0;
        }
        if (z) {
            Lil(f, i6);
            i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                View view2 = this.f2666IL[i11];
                LlLI1(view2, Videoio.CAP_OPENNI_IMAGE_GENERATOR, true);
                int iIlil2 = this.mOrientationHelper.Ilil(view2);
                if (iIlil2 > i10) {
                    i10 = iIlil2;
                }
            }
        }
        for (int i12 = 0; i12 < i7; i12++) {
            View view3 = this.f2666IL[i12];
            if (this.mOrientationHelper.Ilil(view3) != i10) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f5076ILil;
                int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int iM3242il = m3242il(layoutParams.f5051Ilil, layoutParams.f2672lLi1LL);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.LlLI1.getChildMeasureSpec(iM3242il, Videoio.CAP_OPENNI_IMAGE_GENERATOR, i14, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - i13, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - i14, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
                    childMeasureSpec = RecyclerView.LlLI1.getChildMeasureSpec(iM3242il, Videoio.CAP_OPENNI_IMAGE_GENERATOR, i13, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                m3240llL1ii(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        int i15 = 0;
        iLil.f5061IL1Iii = i10;
        if (this.mOrientation == 1) {
            if (i1i.f2679lLi1LL == -1) {
                i2 = i1i.f5054ILil;
                i3 = i2 - i10;
            } else {
                int i16 = i1i.f5054ILil;
                i3 = i16;
                i2 = i10 + i16;
            }
            i = 0;
            iMo2362lLi1LL = 0;
        } else if (i1i.f2679lLi1LL == -1) {
            int i17 = i1i.f5054ILil;
            iMo2362lLi1LL = i17 - i10;
            i3 = 0;
            i = i17;
            i2 = 0;
        } else {
            int i18 = i1i.f5054ILil;
            i = i10 + i18;
            iMo2362lLi1LL = i18;
            i2 = 0;
            i3 = 0;
        }
        while (i15 < i7) {
            View view4 = this.f2666IL[i15];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f5044I1I[this.f5046ILil - layoutParams2.f5051Ilil];
                    iMo2362lLi1LL = paddingLeft - this.mOrientationHelper.mo2362lLi1LL(view4);
                    iMo2362lLi1LL3 = i2;
                    iMo2362lLi1LL2 = paddingLeft;
                    i4 = i3;
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f5044I1I[layoutParams2.f5051Ilil];
                    iMo2362lLi1LL3 = i2;
                    i5 = paddingLeft2;
                    i4 = i3;
                    iMo2362lLi1LL2 = this.mOrientationHelper.mo2362lLi1LL(view4) + paddingLeft2;
                }
                layoutDecoratedWithMargins(view4, i5, i4, iMo2362lLi1LL2, iMo2362lLi1LL3);
                if (layoutParams2.I1I() || layoutParams2.ILil()) {
                    iLil.f5060I1I = true;
                }
                iLil.f2682IL |= view4.hasFocusable();
                i15++;
                i2 = iMo2362lLi1LL3;
                i = iMo2362lLi1LL2;
                i3 = i4;
                iMo2362lLi1LL = i5;
            } else {
                int paddingTop = getPaddingTop() + this.f5044I1I[layoutParams2.f5051Ilil];
                i4 = paddingTop;
                iMo2362lLi1LL2 = i;
                iMo2362lLi1LL3 = this.mOrientationHelper.mo2362lLi1LL(view4) + paddingTop;
            }
            i5 = iMo2362lLi1LL;
            layoutDecoratedWithMargins(view4, i5, i4, iMo2362lLi1LL2, iMo2362lLi1LL3);
            if (layoutParams2.I1I()) {
                iLil.f5060I1I = true;
            } else {
                iLil.f5060I1I = true;
            }
            iLil.f2682IL |= view4.hasFocusable();
            i15++;
            i2 = iMo2362lLi1LL3;
            i = iMo2362lLi1LL2;
            i3 = i4;
            iMo2362lLi1LL = i5;
        }
        Arrays.fill(this.f2666IL, (Object) null);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m3240llL1ii(View view, int i, int i2, boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, layoutParams) : shouldMeasureChild(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int m3241lLi1LL(RecyclerView.C1 c1) {
        if (getChildCount() != 0 && c1.ILil() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int iILil = this.f2669iILLL1.ILil(getPosition(viewFindFirstVisibleChildClosestToStart), this.f5046ILil);
                int iILil2 = this.f2669iILLL1.ILil(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f5046ILil);
                int iMax = this.mShouldReverseLayout ? Math.max(0, ((this.f2669iILLL1.ILil(c1.ILil() - 1, this.f5046ILil) + 1) - Math.max(iILil, iILil2)) - 1) : Math.max(0, Math.min(iILil, iILil2));
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.mo2354IL(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo2358iILLL1(viewFindFirstVisibleChildClosestToStart)) / ((this.f2669iILLL1.ILil(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f5046ILil) - this.f2669iILLL1.ILil(getPosition(viewFindFirstVisibleChildClosestToStart), this.f5046ILil)) + 1))) + (this.mOrientationHelper.mo2359lIiI() - this.mOrientationHelper.mo2358iILLL1(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.lL lLVar, RecyclerView.C1 c1, LinearLayoutManager.IL1Iii iL1Iii, int i) {
        super.onAnchorReady(lLVar, c1, iL1Iii, i);
        iIi1();
        if (c1.ILil() > 0 && !c1.Ilil()) {
            m3234IiL(lLVar, c1, iL1Iii, i);
        }
        m3236L11I();
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.lL r26, androidx.recyclerview.widget.RecyclerView.C1 r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$丨lL, androidx.recyclerview.widget.RecyclerView$丨丨丨1丨):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.lL lLVar, RecyclerView.C1 c1, View view, I1I i1i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, i1i);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iM3235Ll1 = m3235Ll1(lLVar, c1, layoutParams2.IL1Iii());
        if (this.mOrientation == 0) {
            i1i.m62I(I1I.C0564I1I.IL1Iii(layoutParams2.Ilil(), layoutParams2.m3247lLi1LL(), iM3235Ll1, 1, false, false));
        } else {
            i1i.m62I(I1I.C0564I1I.IL1Iii(iM3235Ll1, 1, layoutParams2.Ilil(), layoutParams2.m3247lLi1LL(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f2669iILLL1.m3245IiL();
        this.f2669iILLL1.m3246iILLL1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f2669iILLL1.m3245IiL();
        this.f2669iILLL1.m3246iILLL1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f2669iILLL1.m3245IiL();
        this.f2669iILLL1.m3246iILLL1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f2669iILLL1.m3245IiL();
        this.f2669iILLL1.m3246iILLL1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f2669iILLL1.m3245IiL();
        this.f2669iILLL1.m3246iILLL1();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onLayoutChildren(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (c1.Ilil()) {
            ILil();
        }
        super.onLayoutChildren(lLVar, c1);
        Ilil();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onLayoutCompleted(RecyclerView.C1 c1) {
        super.onLayoutCompleted(c1);
        this.f5045IL1Iii = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public int scrollHorizontallyBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        iIi1();
        m3236L11I();
        return super.scrollHorizontallyBy(i, lLVar, c1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public int scrollVerticallyBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        iIi1();
        m3236L11I();
        return super.scrollVerticallyBy(i, lLVar, c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.f5044I1I == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.LlLI1.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f5044I1I;
            iChooseSize = RecyclerView.LlLI1.chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.LlLI1.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f5044I1I;
            iChooseSize2 = RecyclerView.LlLI1.chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f5045IL1Iii;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m3242il(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f5044I1I;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f5044I1I;
        int i3 = this.f5046ILil;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5051Ilil;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2672lLi1LL;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5051Ilil = -1;
            this.f2672lLi1LL = 0;
        }

        public int Ilil() {
            return this.f5051Ilil;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int m3247lLi1LL() {
            return this.f2672lLi1LL;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f5051Ilil = -1;
            this.f2672lLi1LL = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5051Ilil = -1;
            this.f2672lLi1LL = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5051Ilil = -1;
            this.f2672lLi1LL = 0;
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f5045IL1Iii = false;
        this.f5046ILil = -1;
        this.f5047Ilil = new SparseIntArray();
        this.f2670lLi1LL = new SparseIntArray();
        this.f2669iILLL1 = new IL1Iii();
        this.f2667IiL = new Rect();
        m3239lIlii(i);
    }
}
