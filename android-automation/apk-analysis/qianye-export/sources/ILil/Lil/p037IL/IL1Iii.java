package ILil.Lil.p037IL;

import ILil.p028IiL.p034lIiI.iILLL1;
import ILil.p028IiL.p034lIiI.lLi1LL;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AdapterHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements C0640il.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final ArrayList<ILil> f4250I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public lLi1LL<ILil> f4251IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ArrayList<ILil> f4252ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Runnable f4253Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final InterfaceC0576IL1Iii f1741IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1742IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final C0640il f1743iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean f1744lLi1LL;

    /* JADX INFO: renamed from: ILil.Lil.I丨L.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdapterHelper.java */
    public interface InterfaceC0576IL1Iii {
        void I1I(int i, int i2, Object obj);

        void IL1Iii(int i, int i2);

        void ILil(ILil iLil);

        RecyclerView.LL1IL Ilil(int i);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        void mo2349IL(ILil iLil);

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        void mo2350IiL(int i, int i2);

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        void mo2351iILLL1(int i, int i2);

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        void mo2352lLi1LL(int i, int i2);
    }

    /* JADX INFO: compiled from: AdapterHelper.java */
    public static class ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public Object f4254I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4255IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4256ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1745IL;

        public ILil(int i, int i2, int i3, Object obj) {
            this.f4255IL1Iii = i;
            this.f4256ILil = i2;
            this.f1745IL = i3;
            this.f4254I1I = obj;
        }

        public String IL1Iii() {
            int i = this.f4255IL1Iii;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return "rm";
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ILil.class != obj.getClass()) {
                return false;
            }
            ILil iLil = (ILil) obj;
            int i = this.f4255IL1Iii;
            if (i != iLil.f4255IL1Iii) {
                return false;
            }
            if (i == 8 && Math.abs(this.f1745IL - this.f4256ILil) == 1 && this.f1745IL == iLil.f4256ILil && this.f4256ILil == iLil.f1745IL) {
                return true;
            }
            if (this.f1745IL != iLil.f1745IL || this.f4256ILil != iLil.f4256ILil) {
                return false;
            }
            Object obj2 = this.f4254I1I;
            if (obj2 != null) {
                if (!obj2.equals(iLil.f4254I1I)) {
                    return false;
                }
            } else if (iLil.f4254I1I != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4255IL1Iii * 31) + this.f4256ILil) * 31) + this.f1745IL;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + IL1Iii() + ",s:" + this.f4256ILil + "c:" + this.f1745IL + ",p:" + this.f4254I1I + "]";
        }
    }

    public IL1Iii(InterfaceC0576IL1Iii interfaceC0576IL1Iii) {
        this(interfaceC0576IL1Iii, false);
    }

    public void I11L() {
        this.f1743iILLL1.ILil(this.f4252ILil);
        int size = this.f4252ILil.size();
        for (int i = 0; i < size; i++) {
            ILil iLil = this.f4252ILil.get(i);
            int i2 = iLil.f4255IL1Iii;
            if (i2 == 1) {
                I1I(iLil);
            } else if (i2 == 2) {
                m2344lLi1LL(iLil);
            } else if (i2 == 4) {
                m2340iILLL1(iLil);
            } else if (i2 == 8) {
                m2336IL(iLil);
            }
            Runnable runnable = this.f4253Ilil;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f4252ILil.clear();
    }

    public boolean I11li1(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f4252ILil.add(ILil(2, i, i2, null));
        this.f1742IiL |= 2;
        return this.f4252ILil.size() == 1;
    }

    public final void I1I(ILil iLil) {
        m2346lL(iLil);
    }

    @Override // ILil.Lil.p037IL.C0640il.IL1Iii
    public void IL1Iii(ILil iLil) {
        if (this.f1744lLi1LL) {
            return;
        }
        iLil.f4254I1I = null;
        this.f4251IL1Iii.IL1Iii(iLil);
    }

    public final void ILL(ILil iLil) {
        int i;
        int i2 = iLil.f4255IL1Iii;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM23481 = m23481(iLil.f4256ILil, i2);
        int i3 = iLil.f4256ILil;
        int i4 = iLil.f4255IL1Iii;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + iLil);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < iLil.f1745IL; i6++) {
            int iM23482 = m23481(iLil.f4256ILil + (i * i6), iLil.f4255IL1Iii);
            int i7 = iLil.f4255IL1Iii;
            if (i7 == 2 ? iM23482 == iM23481 : i7 == 4 && iM23482 == iM23481 + 1) {
                i5++;
            } else {
                ILil ILil2 = ILil(i7, iM23481, i5, iLil.f4254I1I);
                m2338Ll1(ILil2, i3);
                IL1Iii(ILil2);
                if (iLil.f4255IL1Iii == 4) {
                    i3 += i5;
                }
                iM23481 = iM23482;
                i5 = 1;
            }
        }
        Object obj = iLil.f4254I1I;
        IL1Iii(iLil);
        if (i5 > 0) {
            ILil ILil3 = ILil(iLil.f4255IL1Iii, iM23481, i5, obj);
            m2338Ll1(ILil3, i3);
            IL1Iii(ILil3);
        }
    }

    @Override // ILil.Lil.p037IL.C0640il.IL1Iii
    public ILil ILil(int i, int i2, int i3, Object obj) {
        ILil ILil2 = this.f4251IL1Iii.ILil();
        if (ILil2 == null) {
            return new ILil(i, i2, i3, obj);
        }
        ILil2.f4255IL1Iii = i;
        ILil2.f4256ILil = i2;
        ILil2.f1745IL = i3;
        ILil2.f4254I1I = obj;
        return ILil2;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int m2335ILl(int i, int i2) {
        int size = this.f4250I1I.size();
        while (i2 < size) {
            ILil iLil = this.f4250I1I.get(i2);
            int i3 = iLil.f4255IL1Iii;
            if (i3 == 8) {
                int i4 = iLil.f4256ILil;
                if (i4 == i) {
                    i = iLil.f1745IL;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (iLil.f1745IL <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = iLil.f4256ILil;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = iLil.f1745IL;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += iLil.f1745IL;
                }
            }
            i2++;
        }
        return i;
    }

    public int Ilil(int i) {
        int size = this.f4252ILil.size();
        for (int i2 = 0; i2 < size; i2++) {
            ILil iLil = this.f4252ILil.get(i2);
            int i3 = iLil.f4255IL1Iii;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = iLil.f4256ILil;
                    if (i4 <= i) {
                        int i5 = iLil.f1745IL;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = iLil.f4256ILil;
                    if (i6 == i) {
                        i = iLil.f1745IL;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (iLil.f1745IL <= i) {
                            i++;
                        }
                    }
                }
            } else if (iLil.f4256ILil <= i) {
                i += iLil.f1745IL;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m2336IL(ILil iLil) {
        m2346lL(iLil);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m2337IiL(int i) {
        int size = this.f4250I1I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ILil iLil = this.f4250I1I.get(i2);
            int i3 = iLil.f4255IL1Iii;
            if (i3 == 8) {
                if (m2335ILl(iLil.f1745IL, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = iLil.f4256ILil;
                int i5 = iLil.f1745IL + i4;
                while (i4 < i5) {
                    if (m2335ILl(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean Lil(int i) {
        return (i & this.f1742IiL) != 0;
    }

    public boolean LlLI1() {
        return this.f4252ILil.size() > 0;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2338Ll1(ILil iLil, int i) {
        this.f1741IL.ILil(iLil);
        int i2 = iLil.f4255IL1Iii;
        if (i2 == 2) {
            this.f1741IL.mo2350IiL(i, iLil.f1745IL);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1741IL.I1I(i, iLil.f1745IL, iLil.f4254I1I);
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m2339L11I() {
        int size = this.f4250I1I.size();
        for (int i = 0; i < size; i++) {
            this.f1741IL.mo2349IL(this.f4250I1I.get(i));
        }
        llliI(this.f4250I1I);
        this.f1742IiL = 0;
    }

    public boolean iIi1(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f4252ILil.add(ILil(1, i, i2, null));
        this.f1742IiL |= 1;
        return this.f4252ILil.size() == 1;
    }

    public boolean iIlLiL(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f4252ILil.add(ILil(8, i, i2, null));
        this.f1742IiL |= 8;
        return this.f4252ILil.size() == 1;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2340iILLL1(ILil iLil) {
        int i = iLil.f4256ILil;
        int i2 = iLil.f1745IL + i;
        int i3 = i;
        byte b = -1;
        int i4 = 0;
        while (i < i2) {
            if (this.f1741IL.Ilil(i) != null || m2337IiL(i)) {
                if (b == 0) {
                    ILL(ILil(4, i3, i4, iLil.f4254I1I));
                    i3 = i;
                    i4 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    m2346lL(ILil(4, i3, i4, iLil.f4254I1I));
                    i3 = i;
                    i4 = 0;
                }
                b = 0;
            }
            i4++;
            i++;
        }
        if (i4 != iLil.f1745IL) {
            Object obj = iLil.f4254I1I;
            IL1Iii(iLil);
            iLil = ILil(4, i3, i4, obj);
        }
        if (b == 0) {
            ILL(iLil);
        } else {
            m2346lL(iLil);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int m2341lIiI(int i) {
        return m2335ILl(i, 0);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m2342lIlii(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f4252ILil.add(ILil(4, i, i2, obj));
        this.f1742IiL |= 4;
        return this.f4252ILil.size() == 1;
    }

    public void llliI(List<ILil> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            IL1Iii(list.get(i));
        }
        list.clear();
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m2343llL1ii() {
        return (this.f4250I1I.isEmpty() || this.f4252ILil.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m2344lLi1LL(ILil iLil) {
        boolean z;
        byte b;
        int i = iLil.f4256ILil;
        int i2 = iLil.f1745IL + i;
        byte b2 = -1;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f1741IL.Ilil(i3) != null || m2337IiL(i3)) {
                if (b2 == 0) {
                    ILL(ILil(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    m2346lL(ILil(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b2 = b;
        }
        if (i4 != iLil.f1745IL) {
            IL1Iii(iLil);
            iLil = ILil(2, i, i4, null);
        }
        if (b2 == 0) {
            ILL(iLil);
        } else {
            m2346lL(iLil);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m2345il() {
        m2339L11I();
        int size = this.f4252ILil.size();
        for (int i = 0; i < size; i++) {
            ILil iLil = this.f4252ILil.get(i);
            int i2 = iLil.f4255IL1Iii;
            if (i2 == 1) {
                this.f1741IL.mo2349IL(iLil);
                this.f1741IL.mo2351iILLL1(iLil.f4256ILil, iLil.f1745IL);
            } else if (i2 == 2) {
                this.f1741IL.mo2349IL(iLil);
                this.f1741IL.mo2350IiL(iLil.f4256ILil, iLil.f1745IL);
            } else if (i2 == 4) {
                this.f1741IL.mo2349IL(iLil);
                this.f1741IL.I1I(iLil.f4256ILil, iLil.f1745IL, iLil.f4254I1I);
            } else if (i2 == 8) {
                this.f1741IL.mo2349IL(iLil);
                this.f1741IL.IL1Iii(iLil.f4256ILil, iLil.f1745IL);
            }
            Runnable runnable = this.f4253Ilil;
            if (runnable != null) {
                runnable.run();
            }
        }
        llliI(this.f4252ILil);
        this.f1742IiL = 0;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final void m2346lL(ILil iLil) {
        this.f4250I1I.add(iLil);
        int i = iLil.f4255IL1Iii;
        if (i == 1) {
            this.f1741IL.mo2351iILLL1(iLil.f4256ILil, iLil.f1745IL);
            return;
        }
        if (i == 2) {
            this.f1741IL.mo2352lLi1LL(iLil.f4256ILil, iLil.f1745IL);
            return;
        }
        if (i == 4) {
            this.f1741IL.I1I(iLil.f4256ILil, iLil.f1745IL, iLil.f4254I1I);
        } else {
            if (i == 8) {
                this.f1741IL.IL1Iii(iLil.f4256ILil, iLil.f1745IL);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + iLil);
        }
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m2347l() {
        llliI(this.f4252ILil);
        llliI(this.f4250I1I);
        this.f1742IiL = 0;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final int m23481(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f4250I1I.size() - 1; size >= 0; size--) {
            ILil iLil = this.f4250I1I.get(size);
            int i5 = iLil.f4255IL1Iii;
            if (i5 == 8) {
                int i6 = iLil.f4256ILil;
                int i7 = iLil.f1745IL;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            iLil.f4256ILil = i6 + 1;
                            iLil.f1745IL = i7 + 1;
                        } else if (i2 == 2) {
                            iLil.f4256ILil = i6 - 1;
                            iLil.f1745IL = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        iLil.f1745IL = i7 + 1;
                    } else if (i2 == 2) {
                        iLil.f1745IL = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        iLil.f4256ILil = i6 + 1;
                    } else if (i2 == 2) {
                        iLil.f4256ILil = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = iLil.f4256ILil;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= iLil.f1745IL;
                    } else if (i5 == 2) {
                        i += iLil.f1745IL;
                    }
                } else if (i2 == 1) {
                    iLil.f4256ILil = i8 + 1;
                } else if (i2 == 2) {
                    iLil.f4256ILil = i8 - 1;
                }
            }
        }
        for (int size2 = this.f4250I1I.size() - 1; size2 >= 0; size2--) {
            ILil iLil2 = this.f4250I1I.get(size2);
            if (iLil2.f4255IL1Iii == 8) {
                int i9 = iLil2.f1745IL;
                if (i9 == iLil2.f4256ILil || i9 < 0) {
                    this.f4250I1I.remove(size2);
                    IL1Iii(iLil2);
                }
            } else if (iLil2.f1745IL <= 0) {
                this.f4250I1I.remove(size2);
                IL1Iii(iLil2);
            }
        }
        return i;
    }

    public IL1Iii(InterfaceC0576IL1Iii interfaceC0576IL1Iii, boolean z) {
        this.f4251IL1Iii = new iILLL1(30);
        this.f4252ILil = new ArrayList<>();
        this.f4250I1I = new ArrayList<>();
        this.f1742IiL = 0;
        this.f1741IL = interfaceC0576IL1Iii;
        this.f1744lLi1LL = z;
        this.f1743iILLL1 = new C0640il(this);
    }
}
