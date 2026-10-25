package ILil.Lil.p037IL;

import ILil.p028IiL.p034lIiI.iILLL1;
import ILil.p028IiL.p034lIiI.lLi1LL;
import ILil.p065Ilil.Lil;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: ILil.Lil.I丨L.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: ViewInfoStore.java */
/* JADX INFO: loaded from: classes.dex */
public class lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ILil.p065Ilil.lIlii<RecyclerView.LL1IL, IL1Iii> f4289IL1Iii = new ILil.p065Ilil.lIlii<>();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Lil<RecyclerView.LL1IL> f4290ILil = new Lil<>();

    /* JADX INFO: renamed from: ILil.Lil.I丨L.lI丨lii$IL1Iii */
    /* JADX INFO: compiled from: ViewInfoStore.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static lLi1LL<IL1Iii> f1772IL = new iILLL1(20);

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public RecyclerView.lIiI.I1I f4291I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4292IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public RecyclerView.lIiI.I1I f4293ILil;

        public static void I1I(IL1Iii iL1Iii) {
            iL1Iii.f4292IL1Iii = 0;
            iL1Iii.f4293ILil = null;
            iL1Iii.f4291I1I = null;
            f1772IL.IL1Iii(iL1Iii);
        }

        public static void IL1Iii() {
            while (f1772IL.ILil() != null) {
            }
        }

        public static IL1Iii ILil() {
            IL1Iii iL1IiiILil = f1772IL.ILil();
            return iL1IiiILil == null ? new IL1Iii() : iL1IiiILil;
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.lI丨lii$ILil */
    /* JADX INFO: compiled from: ViewInfoStore.java */
    public interface ILil {
        void I1I(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2);

        void IL1Iii(RecyclerView.LL1IL ll1il);

        void ILil(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        void mo2437IL(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i, RecyclerView.lIiI.I1I i1i2);
    }

    public void I1I(long j, RecyclerView.LL1IL ll1il) {
        this.f4290ILil.ILL(j, ll1il);
    }

    public void IL1Iii(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i) {
        IL1Iii iL1IiiILil = this.f4289IL1Iii.get(ll1il);
        if (iL1IiiILil == null) {
            iL1IiiILil = IL1Iii.ILil();
            this.f4289IL1Iii.put(ll1il, iL1IiiILil);
        }
        iL1IiiILil.f4292IL1Iii |= 2;
        iL1IiiILil.f4293ILil = i1i;
    }

    public void ILL(RecyclerView.LL1IL ll1il) {
        LlLI1(ll1il);
    }

    public void ILil(RecyclerView.LL1IL ll1il) {
        IL1Iii iL1IiiILil = this.f4289IL1Iii.get(ll1il);
        if (iL1IiiILil == null) {
            iL1IiiILil = IL1Iii.ILil();
            this.f4289IL1Iii.put(ll1il, iL1IiiILil);
        }
        iL1IiiILil.f4292IL1Iii |= 1;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public RecyclerView.lIiI.I1I m2427ILl(RecyclerView.LL1IL ll1il) {
        return m2430Ll1(ll1il, 4);
    }

    public void Ilil(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i) {
        IL1Iii iL1IiiILil = this.f4289IL1Iii.get(ll1il);
        if (iL1IiiILil == null) {
            iL1IiiILil = IL1Iii.ILil();
            this.f4289IL1Iii.put(ll1il, iL1IiiILil);
        }
        iL1IiiILil.f4293ILil = i1i;
        iL1IiiILil.f4292IL1Iii |= 4;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2428IL(RecyclerView.LL1IL ll1il, RecyclerView.lIiI.I1I i1i) {
        IL1Iii iL1IiiILil = this.f4289IL1Iii.get(ll1il);
        if (iL1IiiILil == null) {
            iL1IiiILil = IL1Iii.ILil();
            this.f4289IL1Iii.put(ll1il, iL1IiiILil);
        }
        iL1IiiILil.f4291I1I = i1i;
        iL1IiiILil.f4292IL1Iii |= 8;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m2429IiL(RecyclerView.LL1IL ll1il) {
        IL1Iii iL1Iii = this.f4289IL1Iii.get(ll1il);
        return (iL1Iii == null || (iL1Iii.f4292IL1Iii & 1) == 0) ? false : true;
    }

    public void Lil(ILil iLil) {
        for (int size = this.f4289IL1Iii.size() - 1; size >= 0; size--) {
            RecyclerView.LL1IL ll1ilM1973L11I = this.f4289IL1Iii.m1973L11I(size);
            IL1Iii iL1IiiILL = this.f4289IL1Iii.ILL(size);
            int i = iL1IiiILL.f4292IL1Iii;
            if ((i & 3) == 3) {
                iLil.IL1Iii(ll1ilM1973L11I);
            } else if ((i & 1) != 0) {
                RecyclerView.lIiI.I1I i1i = iL1IiiILL.f4293ILil;
                if (i1i == null) {
                    iLil.IL1Iii(ll1ilM1973L11I);
                } else {
                    iLil.I1I(ll1ilM1973L11I, i1i, iL1IiiILL.f4291I1I);
                }
            } else if ((i & 14) == 14) {
                iLil.ILil(ll1ilM1973L11I, iL1IiiILL.f4293ILil, iL1IiiILL.f4291I1I);
            } else if ((i & 12) == 12) {
                iLil.mo2437IL(ll1ilM1973L11I, iL1IiiILL.f4293ILil, iL1IiiILL.f4291I1I);
            } else if ((i & 4) != 0) {
                iLil.I1I(ll1ilM1973L11I, iL1IiiILL.f4293ILil, null);
            } else if ((i & 8) != 0) {
                iLil.ILil(ll1ilM1973L11I, iL1IiiILL.f4293ILil, iL1IiiILL.f4291I1I);
            }
            IL1Iii.I1I(iL1IiiILL);
        }
    }

    public void LlLI1(RecyclerView.LL1IL ll1il) {
        IL1Iii iL1Iii = this.f4289IL1Iii.get(ll1il);
        if (iL1Iii == null) {
            return;
        }
        iL1Iii.f4292IL1Iii &= -2;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final RecyclerView.lIiI.I1I m2430Ll1(RecyclerView.LL1IL ll1il, int i) {
        IL1Iii iL1IiiM1975lIiI;
        RecyclerView.lIiI.I1I i1i;
        int iM1976lLi1LL = this.f4289IL1Iii.m1976lLi1LL(ll1il);
        if (iM1976lLi1LL >= 0 && (iL1IiiM1975lIiI = this.f4289IL1Iii.m1975lIiI(iM1976lLi1LL)) != null) {
            int i2 = iL1IiiM1975lIiI.f4292IL1Iii;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                iL1IiiM1975lIiI.f4292IL1Iii = i3;
                if (i == 4) {
                    i1i = iL1IiiM1975lIiI.f4293ILil;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    i1i = iL1IiiM1975lIiI.f4291I1I;
                }
                if ((i3 & 12) == 0) {
                    this.f4289IL1Iii.ILL(iM1976lLi1LL);
                    IL1Iii.I1I(iL1IiiM1975lIiI);
                }
                return i1i;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean m2431L11I(RecyclerView.LL1IL ll1il) {
        IL1Iii iL1Iii = this.f4289IL1Iii.get(ll1il);
        return (iL1Iii == null || (iL1Iii.f4292IL1Iii & 4) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public RecyclerView.LL1IL m2432iILLL1(long j) {
        return this.f4290ILil.m1947lLi1LL(j);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public RecyclerView.lIiI.I1I m2433lIiI(RecyclerView.LL1IL ll1il) {
        return m2430Ll1(ll1il, 8);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m2434llL1ii(RecyclerView.LL1IL ll1il) {
        for (int iM1941ILl = this.f4290ILil.m1941ILl() - 1; iM1941ILl >= 0; iM1941ILl--) {
            if (ll1il == this.f4290ILil.Lil(iM1941ILl)) {
                this.f4290ILil.m1946lIiI(iM1941ILl);
                break;
            }
        }
        IL1Iii iL1IiiRemove = this.f4289IL1Iii.remove(ll1il);
        if (iL1IiiRemove != null) {
            IL1Iii.I1I(iL1IiiRemove);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2435lLi1LL() {
        this.f4289IL1Iii.clear();
        this.f4290ILil.ILil();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2436il() {
        IL1Iii.IL1Iii();
    }
}
