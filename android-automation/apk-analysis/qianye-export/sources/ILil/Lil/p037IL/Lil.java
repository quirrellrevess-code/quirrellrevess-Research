package ILil.Lil.p037IL;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SimpleItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lil extends RecyclerView.lIiI {

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1764iILLL1 = true;

    public abstract boolean I11L(RecyclerView.LL1IL ll1il);

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    public boolean I1I(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2) {
        int i = i1i.f5088IL1Iii;
        int i2 = i1i.f5089ILil;
        View view = ll1il.itemView;
        int left = i1i2 == null ? view.getLeft() : i1i2.f5088IL1Iii;
        int top = i1i2 == null ? view.getTop() : i1i2.f5089ILil;
        if (ll1il.isRemoved() || (i == left && i2 == top)) {
            return mo23341(ll1il);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo2333l(ll1il, i, i2, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    public boolean IL1Iii(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2) {
        int i;
        int i2;
        return (i1i == null || ((i = i1i.f5088IL1Iii) == (i2 = i1i2.f5088IL1Iii) && i1i.f5089ILil == i1i2.f5089ILil)) ? I11L(ll1il) : mo2333l(ll1il, i, i1i.f5089ILil, i2, i1i2.f5089ILil);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    public boolean ILil(RecyclerView.LL1IL ll1il, RecyclerView.LL1IL ll1il2, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2) {
        int i;
        int i2;
        int i3 = i1i.f5088IL1Iii;
        int i4 = i1i.f5089ILil;
        if (ll1il2.shouldIgnore()) {
            int i5 = i1i.f5088IL1Iii;
            i2 = i1i.f5089ILil;
            i = i5;
        } else {
            i = i1i2.f5088IL1Iii;
            i2 = i1i2.f5089ILil;
        }
        return llliI(ll1il, ll1il2, i3, i4, i, i2);
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public void m2397IIi(RecyclerView.LL1IL ll1il, boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean mo2398IL(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2) {
        int i = i1i.f5088IL1Iii;
        int i2 = i1i2.f5088IL1Iii;
        if (i != i2 || i1i.f5089ILil != i1i2.f5089ILil) {
            return mo2333l(ll1il, i, i1i.f5089ILil, i2, i1i2.f5089ILil);
        }
        m2410LLlI1(ll1il);
        return false;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m2399L11(RecyclerView.LL1IL ll1il) {
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m2400L111(RecyclerView.LL1IL ll1il, boolean z) {
        m2401LIll(ll1il, z);
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m2401LIll(RecyclerView.LL1IL ll1il, boolean z) {
    }

    public final void LL1IL(RecyclerView.LL1IL ll1il, boolean z) {
        m2397IIi(ll1il, z);
        m3264IiL(ll1il);
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public void m2402LlIl(RecyclerView.LL1IL ll1il) {
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m2403L1l(RecyclerView.LL1IL ll1il) {
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m2404LlLLL(RecyclerView.LL1IL ll1il) {
        m2403L1l(ll1il);
        m3264IiL(ll1il);
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public void m2405ill(RecyclerView.LL1IL ll1il) {
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final void m2406l1IIi1(RecyclerView.LL1IL ll1il) {
        m2402LlIl(ll1il);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final void m2407lIII(RecyclerView.LL1IL ll1il) {
        m2409iILLl(ll1il);
    }

    public final void llI(RecyclerView.LL1IL ll1il) {
        m2399L11(ll1il);
        m3264IiL(ll1il);
    }

    public abstract boolean llliI(RecyclerView.LL1IL ll1il, RecyclerView.LL1IL ll1il2, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean mo2408lLi1LL(RecyclerView.LL1IL ll1il) {
        return !this.f1764iILLL1 || ll1il.isInvalid();
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m2409iILLl(RecyclerView.LL1IL ll1il) {
    }

    /* JADX INFO: renamed from: 丨l丨 */
    public abstract boolean mo2333l(RecyclerView.LL1IL ll1il, int i, int i2, int i3, int i4);

    /* JADX INFO: renamed from: 丨丨 */
    public final void m80(RecyclerView.LL1IL ll1il) {
        m2411(ll1il);
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m2410LLlI1(RecyclerView.LL1IL ll1il) {
        m2405ill(ll1il);
        m3264IiL(ll1il);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨 */
    public abstract boolean mo23341(RecyclerView.LL1IL ll1il);

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m2411(RecyclerView.LL1IL ll1il) {
    }
}
