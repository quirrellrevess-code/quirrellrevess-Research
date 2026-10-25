package ILil.Lil.p037IL;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final InterfaceC0577ILil f4261IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final IL1Iii f4262ILil = new IL1Iii();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final List<View> f4260I1I = new ArrayList();

    /* JADX INFO: compiled from: ChildHelper.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public long f4263IL1Iii = 0;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public IL1Iii f4264ILil;

        public final void I1I() {
            if (this.f4264ILil == null) {
                this.f4264ILil = new IL1Iii();
            }
        }

        public void IL1Iii(int i) {
            if (i < 64) {
                this.f4263IL1Iii &= ~(1 << i);
                return;
            }
            IL1Iii iL1Iii = this.f4264ILil;
            if (iL1Iii != null) {
                iL1Iii.IL1Iii(i - 64);
            }
        }

        public int ILil(int i) {
            IL1Iii iL1Iii = this.f4264ILil;
            if (iL1Iii == null) {
                return i >= 64 ? Long.bitCount(this.f4263IL1Iii) : Long.bitCount(this.f4263IL1Iii & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.f4263IL1Iii & ((1 << i) - 1)) : iL1Iii.ILil(i - 64) + Long.bitCount(this.f4263IL1Iii);
        }

        public void Ilil(int i, boolean z) {
            if (i >= 64) {
                I1I();
                this.f4264ILil.Ilil(i - 64, z);
                return;
            }
            long j = this.f4263IL1Iii;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.f4263IL1Iii = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                m2376IiL(i);
            } else {
                IL1Iii(i);
            }
            if (z2 || this.f4264ILil != null) {
                I1I();
                this.f4264ILil.Ilil(0, z2);
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m2375IL(int i) {
            if (i < 64) {
                return (this.f4263IL1Iii & (1 << i)) != 0;
            }
            I1I();
            return this.f4264ILil.m2375IL(i - 64);
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m2376IiL(int i) {
            if (i < 64) {
                this.f4263IL1Iii |= 1 << i;
            } else {
                I1I();
                this.f4264ILil.m2376IiL(i - 64);
            }
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m2377iILLL1() {
            this.f4263IL1Iii = 0L;
            IL1Iii iL1Iii = this.f4264ILil;
            if (iL1Iii != null) {
                iL1Iii.m2377iILLL1();
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean m2378lLi1LL(int i) {
            if (i >= 64) {
                I1I();
                return this.f4264ILil.m2378lLi1LL(i - 64);
            }
            long j = 1 << i;
            long j2 = this.f4263IL1Iii;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.f4263IL1Iii = j3;
            long j4 = j - 1;
            this.f4263IL1Iii = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            IL1Iii iL1Iii = this.f4264ILil;
            if (iL1Iii != null) {
                if (iL1Iii.m2375IL(0)) {
                    m2376IiL(63);
                }
                this.f4264ILil.m2378lLi1LL(0);
            }
            return z;
        }

        public String toString() {
            if (this.f4264ILil == null) {
                return Long.toBinaryString(this.f4263IL1Iii);
            }
            return this.f4264ILil.toString() + "xx" + Long.toBinaryString(this.f4263IL1Iii);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChildHelper.java */
    public interface InterfaceC0577ILil {
        int I1I();

        View IL1Iii(int i);

        void ILL(View view, int i, ViewGroup.LayoutParams layoutParams);

        void ILil(View view);

        int Ilil(View view);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        void mo2379IL();

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        void mo2380IiL(View view);

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        void mo2381L11I(View view, int i);

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        void mo2382iILLL1(int i);

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        RecyclerView.LL1IL mo2383lLi1LL(View view);

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        void mo2384il(int i);
    }

    public ILil(InterfaceC0577ILil interfaceC0577ILil) {
        this.f4261IL1Iii = interfaceC0577ILil;
    }

    public void I1I(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iI1I = i < 0 ? this.f4261IL1Iii.I1I() : m2366IiL(i);
        this.f4262ILil.Ilil(iI1I, z);
        if (z) {
            m2367Ll1(view);
        }
        this.f4261IL1Iii.ILL(view, iI1I, layoutParams);
    }

    public void IL1Iii(View view, int i, boolean z) {
        int iI1I = i < 0 ? this.f4261IL1Iii.I1I() : m2366IiL(i);
        this.f4262ILil.Ilil(iI1I, z);
        if (z) {
            m2367Ll1(view);
        }
        this.f4261IL1Iii.mo2381L11I(view, iI1I);
    }

    public void ILL(View view) {
        int iIlil = this.f4261IL1Iii.Ilil(view);
        if (iIlil >= 0) {
            this.f4262ILil.m2376IiL(iIlil);
            m2367Ll1(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public void ILil(View view, boolean z) {
        IL1Iii(view, -1, z);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m2364ILl(View view) {
        return this.f4260I1I.contains(view);
    }

    public View Ilil(int i) {
        int size = this.f4260I1I.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f4260I1I.get(i2);
            RecyclerView.LL1IL ll1ilMo2383lLi1LL = this.f4261IL1Iii.mo2383lLi1LL(view);
            if (ll1ilMo2383lLi1LL.getLayoutPosition() == i && !ll1ilMo2383lLi1LL.isInvalid() && !ll1ilMo2383lLi1LL.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2365IL(int i) {
        int iM2366IiL = m2366IiL(i);
        this.f4262ILil.m2378lLi1LL(iM2366IiL);
        this.f4261IL1Iii.mo2382iILLL1(iM2366IiL);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final int m2366IiL(int i) {
        if (i < 0) {
            return -1;
        }
        int iI1I = this.f4261IL1Iii.I1I();
        int i2 = i;
        while (i2 < iI1I) {
            int iILil = i - (i2 - this.f4262ILil.ILil(i2));
            if (iILil == 0) {
                while (this.f4262ILil.m2375IL(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iILil;
        }
        return -1;
    }

    public void Lil() {
        this.f4262ILil.m2377iILLL1();
        for (int size = this.f4260I1I.size() - 1; size >= 0; size--) {
            this.f4261IL1Iii.mo2380IiL(this.f4260I1I.get(size));
            this.f4260I1I.remove(size);
        }
        this.f4261IL1Iii.mo2379IL();
    }

    public void LlLI1(View view) {
        int iIlil = this.f4261IL1Iii.Ilil(view);
        if (iIlil < 0) {
            return;
        }
        if (this.f4262ILil.m2378lLi1LL(iIlil)) {
            iIlLiL(view);
        }
        this.f4261IL1Iii.mo2384il(iIlil);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m2367Ll1(View view) {
        this.f4260I1I.add(view);
        this.f4261IL1Iii.ILil(view);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public View m2368L11I(int i) {
        return this.f4261IL1Iii.IL1Iii(i);
    }

    public void iIi1(View view) {
        int iIlil = this.f4261IL1Iii.Ilil(view);
        if (iIlil < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f4262ILil.m2375IL(iIlil)) {
            this.f4262ILil.IL1Iii(iIlil);
            iIlLiL(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean iIlLiL(View view) {
        if (!this.f4260I1I.remove(view)) {
            return false;
        }
        this.f4261IL1Iii.mo2380IiL(view);
        return true;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m2369iILLL1() {
        return this.f4261IL1Iii.I1I() - this.f4260I1I.size();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int m2370lIiI(View view) {
        int iIlil = this.f4261IL1Iii.Ilil(view);
        if (iIlil == -1 || this.f4262ILil.m2375IL(iIlil)) {
            return -1;
        }
        return iIlil - this.f4262ILil.ILil(iIlil);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m2371lIlii(View view) {
        int iIlil = this.f4261IL1Iii.Ilil(view);
        if (iIlil == -1) {
            iIlLiL(view);
            return true;
        }
        if (!this.f4262ILil.m2375IL(iIlil)) {
            return false;
        }
        this.f4262ILil.m2378lLi1LL(iIlil);
        iIlLiL(view);
        this.f4261IL1Iii.mo2384il(iIlil);
        return true;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m2372llL1ii(int i) {
        int iM2366IiL = m2366IiL(i);
        View viewIL1Iii = this.f4261IL1Iii.IL1Iii(iM2366IiL);
        if (viewIL1Iii == null) {
            return;
        }
        if (this.f4262ILil.m2378lLi1LL(iM2366IiL)) {
            iIlLiL(viewIL1Iii);
        }
        this.f4261IL1Iii.mo2384il(iM2366IiL);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public View m2373lLi1LL(int i) {
        return this.f4261IL1Iii.IL1Iii(m2366IiL(i));
    }

    public String toString() {
        return this.f4262ILil.toString() + ", hidden list:" + this.f4260I1I.size();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m2374il() {
        return this.f4261IL1Iii.I1I();
    }
}
