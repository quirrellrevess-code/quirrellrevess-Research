package ILil.Lil.p037IL;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: ILil.Lil.I丨L.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: PagerSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class Ll1 extends LlLI1 {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ILL f4280Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f1765IL;

    /* JADX INFO: renamed from: ILil.Lil.I丨L.Ll丨1$IL1Iii */
    /* JADX INFO: compiled from: PagerSnapHelper.java */
    public class IL1Iii extends IiL {
        public IL1Iii(Context context) {
            super(context);
        }

        @Override // ILil.Lil.p037IL.IiL
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // ILil.Lil.p037IL.IiL
        public int calculateTimeForScrolling(int i) {
            return Math.min(100, super.calculateTimeForScrolling(i));
        }

        @Override // ILil.Lil.p037IL.IiL, androidx.recyclerview.widget.RecyclerView.l
        public void onTargetFound(View view, RecyclerView.C1 c1, RecyclerView.l.IL1Iii iL1Iii) {
            Ll1 ll1 = Ll1.this;
            int[] iArrI1I = ll1.I1I(ll1.f4275IL1Iii.getLayoutManager(), view);
            int i = iArrI1I[0];
            int i2 = iArrI1I[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (iCalculateTimeForDeceleration > 0) {
                iL1Iii.m3298IL(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    @Override // ILil.Lil.p037IL.LlLI1
    public int[] I1I(RecyclerView.LlLI1 llLI1, View view) {
        int[] iArr = new int[2];
        if (llLI1.canScrollHorizontally()) {
            iArr[0] = m2420lIiI(llLI1, view, Lil(llLI1));
        } else {
            iArr[0] = 0;
        }
        if (llLI1.canScrollVertically()) {
            iArr[1] = m2420lIiI(llLI1, view, m2422llL1ii(llLI1));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final View m2419ILl(RecyclerView.LlLI1 llLI1, ILL ill) {
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

    @Override // ILil.Lil.p037IL.LlLI1
    /* JADX INFO: renamed from: I丨iL */
    public View mo2413IiL(RecyclerView.LlLI1 llLI1) {
        if (llLI1.canScrollVertically()) {
            return m2419ILl(llLI1, m2422llL1ii(llLI1));
        }
        if (llLI1.canScrollHorizontally()) {
            return m2419ILl(llLI1, Lil(llLI1));
        }
        return null;
    }

    public final ILL Lil(RecyclerView.LlLI1 llLI1) {
        ILL ill = this.f4280Ilil;
        if (ill == null || ill.f4258IL1Iii != llLI1) {
            this.f4280Ilil = ILL.IL1Iii(llLI1);
        }
        return this.f4280Ilil;
    }

    public final ILL LlLI1(RecyclerView.LlLI1 llLI1) {
        if (llLI1.canScrollVertically()) {
            return m2422llL1ii(llLI1);
        }
        if (llLI1.canScrollHorizontally()) {
            return Lil(llLI1);
        }
        return null;
    }

    @Override // ILil.Lil.p037IL.LlLI1
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public int mo2415L11I(RecyclerView.LlLI1 llLI1, int i, int i2) {
        ILL illLlLI1;
        int itemCount = llLI1.getItemCount();
        if (itemCount == 0 || (illLlLI1 = LlLI1(llLI1)) == null) {
            return -1;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int childCount = llLI1.getChildCount();
        View view = null;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = llLI1.getChildAt(i5);
            if (childAt != null) {
                int iM2420lIiI = m2420lIiI(llLI1, childAt, illLlLI1);
                if (iM2420lIiI <= 0 && iM2420lIiI > i3) {
                    view2 = childAt;
                    i3 = iM2420lIiI;
                }
                if (iM2420lIiI >= 0 && iM2420lIiI < i4) {
                    view = childAt;
                    i4 = iM2420lIiI;
                }
            }
        }
        boolean zM2421lIlii = m2421lIlii(llLI1, i, i2);
        if (zM2421lIlii && view != null) {
            return llLI1.getPosition(view);
        }
        if (!zM2421lIlii && view2 != null) {
            return llLI1.getPosition(view2);
        }
        if (zM2421lIlii) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = llLI1.getPosition(view) + (iIi1(llLI1) == zM2421lIlii ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean iIi1(RecyclerView.LlLI1 llLI1) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = llLI1.getItemCount();
        if (!(llLI1 instanceof RecyclerView.l.ILil) || (pointFComputeScrollVectorForPosition = ((RecyclerView.l.ILil) llLI1).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final int m2420lIiI(RecyclerView.LlLI1 llLI1, View view, ILL ill) {
        return (ill.mo2358iILLL1(view) + (ill.Ilil(view) / 2)) - (ill.mo2359lIiI() + (ill.mo2353ILl() / 2));
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final boolean m2421lIlii(RecyclerView.LlLI1 llLI1, int i, int i2) {
        if (llLI1.canScrollHorizontally()) {
            return i > 0;
        }
        return i2 > 0;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final ILL m2422llL1ii(RecyclerView.LlLI1 llLI1) {
        ILL ill = this.f1765IL;
        if (ill == null || ill.f4258IL1Iii != llLI1) {
            this.f1765IL = ILL.I1I(llLI1);
        }
        return this.f1765IL;
    }

    @Override // ILil.Lil.p037IL.LlLI1
    /* JADX INFO: renamed from: l丨Li1LL */
    public IiL mo2417lLi1LL(RecyclerView.LlLI1 llLI1) {
        if (llLI1 instanceof RecyclerView.l.ILil) {
            return new IL1Iii(this.f4275IL1Iii.getContext());
        }
        return null;
    }
}
