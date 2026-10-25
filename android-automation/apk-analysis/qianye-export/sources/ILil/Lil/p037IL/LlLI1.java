package ILil.Lil.p037IL;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class LlLI1 extends RecyclerView.lIlii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final RecyclerView.iIlLiL f4274I1I = new IL1Iii();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public RecyclerView f4275IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Scroller f4276ILil;

    /* JADX INFO: compiled from: SnapHelper.java */
    public class IL1Iii extends RecyclerView.iIlLiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4277IL1Iii = false;

        public IL1Iii() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.iIlLiL
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f4277IL1Iii) {
                this.f4277IL1Iii = false;
                LlLI1.this.m2414Ll1();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.iIlLiL
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f4277IL1Iii = true;
        }
    }

    /* JADX INFO: compiled from: SnapHelper.java */
    public class ILil extends IiL {
        public ILil(Context context) {
            super(context);
        }

        @Override // ILil.Lil.p037IL.IiL
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // ILil.Lil.p037IL.IiL, androidx.recyclerview.widget.RecyclerView.l
        public void onTargetFound(View view, RecyclerView.C1 c1, RecyclerView.l.IL1Iii iL1Iii) {
            LlLI1 llLI1 = LlLI1.this;
            RecyclerView recyclerView = llLI1.f4275IL1Iii;
            if (recyclerView == null) {
                return;
            }
            int[] iArrI1I = llLI1.I1I(recyclerView.getLayoutManager(), view);
            int i = iArrI1I[0];
            int i2 = iArrI1I[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (iCalculateTimeForDeceleration > 0) {
                iL1Iii.m3298IL(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public abstract int[] I1I(RecyclerView.LlLI1 llLI1, View view);

    @Override // androidx.recyclerview.widget.RecyclerView.lIlii
    public boolean IL1Iii(int i, int i2) {
        RecyclerView.LlLI1 layoutManager = this.f4275IL1Iii.getLayoutManager();
        if (layoutManager == null || this.f4275IL1Iii.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f4275IL1Iii.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && ILL(layoutManager, i, i2);
    }

    public final boolean ILL(RecyclerView.LlLI1 llLI1, int i, int i2) {
        RecyclerView.l lVarIlil;
        int iMo2415L11I;
        if (!(llLI1 instanceof RecyclerView.l.ILil) || (lVarIlil = Ilil(llLI1)) == null || (iMo2415L11I = mo2415L11I(llLI1, i, i2)) == -1) {
            return false;
        }
        lVarIlil.setTargetPosition(iMo2415L11I);
        llLI1.startSmoothScroll(lVarIlil);
        return true;
    }

    public void ILil(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f4275IL1Iii;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m2416iILLL1();
        }
        this.f4275IL1Iii = recyclerView;
        if (recyclerView != null) {
            m2418il();
            this.f4276ILil = new Scroller(this.f4275IL1Iii.getContext(), new DecelerateInterpolator());
            m2414Ll1();
        }
    }

    public RecyclerView.l Ilil(RecyclerView.LlLI1 llLI1) {
        return mo2417lLi1LL(llLI1);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int[] m2412IL(int i, int i2) {
        this.f4276ILil.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f4276ILil.getFinalX(), this.f4276ILil.getFinalY()};
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public abstract View mo2413IiL(RecyclerView.LlLI1 llLI1);

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2414Ll1() {
        RecyclerView.LlLI1 layoutManager;
        View viewMo2413IiL;
        RecyclerView recyclerView = this.f4275IL1Iii;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewMo2413IiL = mo2413IiL(layoutManager)) == null) {
            return;
        }
        int[] iArrI1I = I1I(layoutManager, viewMo2413IiL);
        if (iArrI1I[0] == 0 && iArrI1I[1] == 0) {
            return;
        }
        this.f4275IL1Iii.smoothScrollBy(iArrI1I[0], iArrI1I[1]);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public abstract int mo2415L11I(RecyclerView.LlLI1 llLI1, int i, int i2);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2416iILLL1() {
        this.f4275IL1Iii.removeOnScrollListener(this.f4274I1I);
        this.f4275IL1Iii.setOnFlingListener(null);
    }

    @Deprecated
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public IiL mo2417lLi1LL(RecyclerView.LlLI1 llLI1) {
        if (llLI1 instanceof RecyclerView.l.ILil) {
            return new ILil(this.f4275IL1Iii.getContext());
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m2418il() throws IllegalStateException {
        if (this.f4275IL1Iii.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f4275IL1Iii.addOnScrollListener(this.f4274I1I);
        this.f4275IL1Iii.setOnFlingListener(this);
    }
}
