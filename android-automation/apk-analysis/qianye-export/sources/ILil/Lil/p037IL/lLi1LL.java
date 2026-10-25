package ILil.Lil.p037IL;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: ILil.Lil.I丨L.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class lLi1LL implements Runnable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long f4300I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ArrayList<RecyclerView> f4301ILil = new ArrayList<>();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ArrayList<I1I> f4302Ilil = new ArrayList<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public long f1776IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final ThreadLocal<lLi1LL> f1775lLi1LL = new ThreadLocal<>();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Comparator<I1I> f1774iILLL1 = new IL1Iii();

    /* JADX INFO: renamed from: ILil.Lil.I丨L.l丨Li1LL$I1I */
    /* JADX INFO: compiled from: GapWorker.java */
    public static class I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4303I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4304IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4305ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4306Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public RecyclerView f1777IL;

        public void IL1Iii() {
            this.f4304IL1Iii = false;
            this.f4305ILil = 0;
            this.f4303I1I = 0;
            this.f1777IL = null;
            this.f4306Ilil = 0;
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: GapWorker.java */
    public static class IL1Iii implements Comparator<I1I> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compare(I1I i1i, I1I i1i2) {
            RecyclerView recyclerView = i1i.f1777IL;
            if ((recyclerView == null) != (i1i2.f1777IL == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = i1i.f4304IL1Iii;
            if (z != i1i2.f4304IL1Iii) {
                return z ? -1 : 1;
            }
            int i = i1i2.f4305ILil - i1i.f4305ILil;
            if (i != 0) {
                return i;
            }
            int i2 = i1i.f4303I1I - i1i2.f4303I1I;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.l丨Li1LL$ILil */
    /* JADX INFO: compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    public static class ILil implements RecyclerView.LlLI1.I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int[] f4307I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4308IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4309ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1778IL;

        public void I1I(RecyclerView recyclerView, boolean z) {
            this.f1778IL = 0;
            int[] iArr = this.f4307I1I;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LlLI1 llLI1 = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || llLI1 == null || !llLI1.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.LlLI1()) {
                    llLI1.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                llLI1.collectAdjacentPrefetchPositions(this.f4308IL1Iii, this.f4309ILil, recyclerView.mState, this);
            }
            int i = this.f1778IL;
            if (i > llLI1.mPrefetchMaxCountObserved) {
                llLI1.mPrefetchMaxCountObserved = i;
                llLI1.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.m3275IIi();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LlLI1.I1I
        public void IL1Iii(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f1778IL * 2;
            int[] iArr = this.f4307I1I;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f4307I1I = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f4307I1I = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f4307I1I;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.f1778IL++;
        }

        public void ILil() {
            int[] iArr = this.f4307I1I;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1778IL = 0;
        }

        public void Ilil(int i, int i2) {
            this.f4308IL1Iii = i;
            this.f4309ILil = i2;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m2446IL(int i) {
            if (this.f4307I1I != null) {
                int i2 = this.f1778IL * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f4307I1I[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean Ilil(RecyclerView recyclerView, int i) {
        int iM2374il = recyclerView.mChildHelper.m2374il();
        for (int i2 = 0; i2 < iM2374il; i2++) {
            RecyclerView.LL1IL childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m2368L11I(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public final void I1I(I1I i1i, long j) {
        RecyclerView.LL1IL ll1ilM2442L11I = m2442L11I(i1i.f1777IL, i1i.f4306Ilil, i1i.f4304IL1Iii ? RecyclerView.FOREVER_NS : j);
        if (ll1ilM2442L11I == null || ll1ilM2442L11I.mNestedRecyclerView == null || !ll1ilM2442L11I.isBound() || ll1ilM2442L11I.isInvalid()) {
            return;
        }
        m2441IiL(ll1ilM2442L11I.mNestedRecyclerView.get(), j);
    }

    public void IL1Iii(RecyclerView recyclerView) {
        this.f4301ILil.add(recyclerView);
    }

    public final void ILil() {
        I1I i1i;
        int size = this.f4301ILil.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f4301ILil.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.I1I(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f1778IL;
            }
        }
        this.f4302Ilil.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f4301ILil.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                ILil iLil = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(iLil.f4308IL1Iii) + Math.abs(iLil.f4309ILil);
                for (int i5 = 0; i5 < iLil.f1778IL * 2; i5 += 2) {
                    if (i3 >= this.f4302Ilil.size()) {
                        i1i = new I1I();
                        this.f4302Ilil.add(i1i);
                    } else {
                        i1i = this.f4302Ilil.get(i3);
                    }
                    int[] iArr = iLil.f4307I1I;
                    int i6 = iArr[i5 + 1];
                    i1i.f4304IL1Iii = i6 <= iAbs;
                    i1i.f4305ILil = iAbs;
                    i1i.f4303I1I = i6;
                    i1i.f1777IL = recyclerView2;
                    i1i.f4306Ilil = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f4302Ilil, f1774iILLL1);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m2440IL(long j) {
        for (int i = 0; i < this.f4302Ilil.size(); i++) {
            I1I i1i = this.f4302Ilil.get(i);
            if (i1i.f1777IL == null) {
                return;
            }
            I1I(i1i, j);
            i1i.IL1Iii();
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m2441IiL(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.m2374il() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        ILil iLil = recyclerView.mPrefetchRegistry;
        iLil.I1I(recyclerView, true);
        if (iLil.f1778IL != 0) {
            try {
                ILil.p028IiL.p036il.IL1Iii.IL1Iii(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                recyclerView.mState.m3301lLi1LL(recyclerView.mAdapter);
                for (int i = 0; i < iLil.f1778IL * 2; i += 2) {
                    m2442L11I(recyclerView, iLil.f4307I1I[i], j);
                }
                ILil.p028IiL.p036il.IL1Iii.ILil();
            } catch (Throwable th) {
                ILil.p028IiL.p036il.IL1Iii.ILil();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final RecyclerView.LL1IL m2442L11I(RecyclerView recyclerView, int i, long j) {
        if (Ilil(recyclerView, i)) {
            return null;
        }
        RecyclerView.lL lLVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.LL1IL ll1ilM3281L1l = lLVar.m3281L1l(i, false, j);
            if (ll1ilM3281L1l != null) {
                if (!ll1ilM3281L1l.isBound() || ll1ilM3281L1l.isInvalid()) {
                    lLVar.IL1Iii(ll1ilM3281L1l, false);
                } else {
                    lLVar.m3288lIII(ll1ilM3281L1l.itemView);
                }
            }
            return ll1ilM3281L1l;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m2443iILLL1(long j) {
        ILil();
        m2440IL(j);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2444lLi1LL(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f4300I1I == 0) {
            this.f4300I1I = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.Ilil(i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ILil.p028IiL.p036il.IL1Iii.IL1Iii(RecyclerView.TRACE_PREFETCH_TAG);
            if (!this.f4301ILil.isEmpty()) {
                int size = this.f4301ILil.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f4301ILil.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    m2443iILLL1(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f1776IL);
                }
            }
        } finally {
            this.f4300I1I = 0L;
            ILil.p028IiL.p036il.IL1Iii.ILil();
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2445il(RecyclerView recyclerView) {
        this.f4301ILil.remove(recyclerView);
    }
}
