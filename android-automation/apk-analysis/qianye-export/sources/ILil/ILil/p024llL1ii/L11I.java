package ILil.ILil.p024llL1ii;

import ILil.p028IiL.p029ILl.C1;
import ILil.p028IiL.p029ILl.l;
import ILil.p028IiL.p029ILl.llliI;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Interpolator f3939I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f3942Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public l f1546IL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f3941ILil = -1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final C1 f1547lLi1LL = new IL1Iii();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ArrayList<llliI> f3940IL1Iii = new ArrayList<>();

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
    public class IL1Iii extends C1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f3944IL1Iii = false;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3945ILil = 0;

        public IL1Iii() {
        }

        @Override // ILil.p028IiL.p029ILl.C1, ILil.p028IiL.p029ILl.l
        public void I1I(View view) {
            if (this.f3944IL1Iii) {
                return;
            }
            this.f3944IL1Iii = true;
            l lVar = L11I.this.f1546IL;
            if (lVar != null) {
                lVar.I1I(null);
            }
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            int i = this.f3945ILil + 1;
            this.f3945ILil = i;
            if (i == L11I.this.f3940IL1Iii.size()) {
                l lVar = L11I.this.f1546IL;
                if (lVar != null) {
                    lVar.ILil(null);
                }
                m1929IL();
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m1929IL() {
            this.f3945ILil = 0;
            this.f3944IL1Iii = false;
            L11I.this.ILil();
        }
    }

    public L11I I1I(llliI lllii) {
        if (!this.f3942Ilil) {
            this.f3940IL1Iii.add(lllii);
        }
        return this;
    }

    public void IL1Iii() {
        if (this.f3942Ilil) {
            Iterator<llliI> it = this.f3940IL1Iii.iterator();
            while (it.hasNext()) {
                it.next().ILil();
            }
            this.f3942Ilil = false;
        }
    }

    public void ILil() {
        this.f3942Ilil = false;
    }

    public L11I Ilil(long j) {
        if (!this.f3942Ilil) {
            this.f3941ILil = j;
        }
        return this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public L11I m1925IL(llliI lllii, llliI lllii2) {
        this.f3940IL1Iii.add(lllii);
        lllii2.m2159IiL(lllii.I1I());
        this.f3940IL1Iii.add(lllii2);
        return this;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1926IiL() {
        if (this.f3942Ilil) {
            return;
        }
        for (llliI lllii : this.f3940IL1Iii) {
            long j = this.f3941ILil;
            if (j >= 0) {
                lllii.m2158IL(j);
            }
            Interpolator interpolator = this.f3939I1I;
            if (interpolator != null) {
                lllii.Ilil(interpolator);
            }
            if (this.f1546IL != null) {
                lllii.m2162lLi1LL(this.f1547lLi1LL);
            }
            lllii.m2163il();
        }
        this.f3942Ilil = true;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public L11I m1927iILLL1(l lVar) {
        if (!this.f3942Ilil) {
            this.f1546IL = lVar;
        }
        return this;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public L11I m1928lLi1LL(Interpolator interpolator) {
        if (!this.f3942Ilil) {
            this.f3939I1I = interpolator;
        }
        return this;
    }
}
