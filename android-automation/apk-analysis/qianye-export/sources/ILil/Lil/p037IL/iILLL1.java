package ILil.Lil.p037IL;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: ILil.Lil.I丨L.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4283I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4285ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4286Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1767IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1768IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f1769L11I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f4284IL1Iii = true;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1771lLi1LL = 0;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1770iILLL1 = 0;

    public boolean IL1Iii(RecyclerView.C1 c1) {
        int i = this.f4283I1I;
        return i >= 0 && i < c1.ILil();
    }

    public View ILil(RecyclerView.lL lLVar) {
        View viewLil = lLVar.Lil(this.f4283I1I);
        this.f4283I1I += this.f1767IL;
        return viewLil;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f4285ILil + ", mCurrentPosition=" + this.f4283I1I + ", mItemDirection=" + this.f1767IL + ", mLayoutDirection=" + this.f4286Ilil + ", mStartLine=" + this.f1771lLi1LL + ", mEndLine=" + this.f1770iILLL1 + '}';
    }
}
