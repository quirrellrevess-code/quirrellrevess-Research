package ILil.Lil.p037IL;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: ILil.Lil.I丨L.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: LinearSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I extends LlLI1 {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ILL f4282Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f1766IL;

    @Override // ILil.Lil.p037IL.LlLI1
    public int[] I1I(RecyclerView.LlLI1 llLI1, View view) {
        int[] iArr = new int[2];
        if (llLI1.canScrollHorizontally()) {
            iArr[0] = m2423ILl(llLI1, view, m2426llL1ii(llLI1));
        } else {
            iArr[0] = 0;
        }
        if (llLI1.canScrollVertically()) {
            iArr[1] = m2423ILl(llLI1, view, m2425lIlii(llLI1));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final int m2423ILl(RecyclerView.LlLI1 llLI1, View view, ILL ill) {
        return (ill.mo2358iILLL1(view) + (ill.Ilil(view) / 2)) - (ill.mo2359lIiI() + (ill.mo2353ILl() / 2));
    }

    @Override // ILil.Lil.p037IL.LlLI1
    /* JADX INFO: renamed from: I丨iL */
    public View mo2413IiL(RecyclerView.LlLI1 llLI1) {
        if (llLI1.canScrollVertically()) {
            return LlLI1(llLI1, m2425lIlii(llLI1));
        }
        if (llLI1.canScrollHorizontally()) {
            return LlLI1(llLI1, m2426llL1ii(llLI1));
        }
        return null;
    }

    public final int Lil(RecyclerView.LlLI1 llLI1, ILL ill, int i, int i2) {
        int[] iArrM2412IL = m2412IL(i, i2);
        float fM2424lIiI = m2424lIiI(llLI1, ill);
        if (fM2424lIiI <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrM2412IL[0]) > Math.abs(iArrM2412IL[1]) ? iArrM2412IL[0] : iArrM2412IL[1]) / fM2424lIiI);
    }

    public final View LlLI1(RecyclerView.LlLI1 llLI1, ILL ill) {
        int childCount = llLI1.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iMo2359lIiI = ill.mo2359lIiI() + (ill.mo2353ILl() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = llLI1.getChildAt(i2);
            int iAbs = Math.abs((ill.mo2358iILLL1(childAt) + (ill.Ilil(childAt) / 2)) - iMo2359lIiI);
            if (iAbs < i) {
                view = childAt;
                i = iAbs;
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ILil.Lil.p037IL.LlLI1
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public int mo2415L11I(RecyclerView.LlLI1 llLI1, int i, int i2) {
        int itemCount;
        View viewMo2413IiL;
        int position;
        int i3;
        PointF pointFComputeScrollVectorForPosition;
        int iLil;
        int iLil2;
        if (!(llLI1 instanceof RecyclerView.l.ILil) || (itemCount = llLI1.getItemCount()) == 0 || (viewMo2413IiL = mo2413IiL(llLI1)) == null || (position = llLI1.getPosition(viewMo2413IiL)) == -1 || (pointFComputeScrollVectorForPosition = ((RecyclerView.l.ILil) llLI1).computeScrollVectorForPosition((i3 = itemCount - 1))) == null) {
            return -1;
        }
        if (llLI1.canScrollHorizontally()) {
            iLil = Lil(llLI1, m2426llL1ii(llLI1), i, 0);
            if (pointFComputeScrollVectorForPosition.x < 0.0f) {
                iLil = -iLil;
            }
        } else {
            iLil = 0;
        }
        if (llLI1.canScrollVertically()) {
            iLil2 = Lil(llLI1, m2425lIlii(llLI1), 0, i2);
            if (pointFComputeScrollVectorForPosition.y < 0.0f) {
                iLil2 = -iLil2;
            }
        } else {
            iLil2 = 0;
        }
        if (llLI1.canScrollVertically()) {
            iLil = iLil2;
        }
        if (iLil == 0) {
            return -1;
        }
        int i4 = position + iLil;
        int i5 = i4 >= 0 ? i4 : 0;
        return i5 >= itemCount ? i3 : i5;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final float m2424lIiI(RecyclerView.LlLI1 llLI1, ILL ill) {
        int childCount = llLI1.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = llLI1.getChildAt(i3);
            int position = llLI1.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(ill.mo2354IL(view), ill.mo2354IL(view2)) - Math.min(ill.mo2358iILLL1(view), ill.mo2358iILLL1(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i2 - i) + 1);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final ILL m2425lIlii(RecyclerView.LlLI1 llLI1) {
        ILL ill = this.f1766IL;
        if (ill == null || ill.f4258IL1Iii != llLI1) {
            this.f1766IL = ILL.I1I(llLI1);
        }
        return this.f1766IL;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final ILL m2426llL1ii(RecyclerView.LlLI1 llLI1) {
        ILL ill = this.f4282Ilil;
        if (ill == null || ill.f4258IL1Iii != llLI1) {
            this.f4282Ilil = ILL.IL1Iii(llLI1);
        }
        return this.f4282Ilil;
    }
}
