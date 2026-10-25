package ILil.p042lIiI;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: ILil.lIi丨I.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: LifecycleRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I extends IL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final WeakReference<IiL> f4346I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ILil.I1I.IL1Iii.ILil.IL1Iii<iILLL1, ILil> f4347IL1Iii = new ILil.I1I.IL1Iii.ILil.IL1Iii<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1793IL = 0;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f4349Ilil = false;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1795lLi1LL = false;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ArrayList<IL.ILil> f1794iILLL1 = new ArrayList<>();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IL.ILil f4348ILil = IL.ILil.INITIALIZED;

    /* JADX INFO: renamed from: ILil.lIi丨I.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: LifecycleRegistry.java */
    public static /* synthetic */ class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f4350IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final /* synthetic */ int[] f4351ILil;

        static {
            int[] iArr = new int[IL.ILil.values().length];
            f4351ILil = iArr;
            try {
                iArr[IL.ILil.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4351ILil[IL.ILil.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4351ILil[IL.ILil.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4351ILil[IL.ILil.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4351ILil[IL.ILil.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[IL.IL1Iii.values().length];
            f4350IL1Iii = iArr2;
            try {
                iArr2[IL.IL1Iii.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4350IL1Iii[IL.IL1Iii.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4350IL1Iii[IL.IL1Iii.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4350IL1Iii[IL.IL1Iii.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4350IL1Iii[IL.IL1Iii.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4350IL1Iii[IL.IL1Iii.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4350IL1Iii[IL.IL1Iii.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: renamed from: ILil.lIi丨I.L丨1丨1丨I$ILil */
    /* JADX INFO: compiled from: LifecycleRegistry.java */
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public IL.ILil f4352IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public lLi1LL f4353ILil;

        public ILil(iILLL1 iilll1, IL.ILil iLil) {
            this.f4353ILil = ILL.m2497lLi1LL(iilll1);
            this.f4352IL1Iii = iLil;
        }

        public void IL1Iii(IiL iiL, IL.IL1Iii iL1Iii) {
            IL.ILil iLilM2501IiL = L11I.m2501IiL(iL1Iii);
            this.f4352IL1Iii = L11I.m2502Ll1(this.f4352IL1Iii, iLilM2501IiL);
            this.f4353ILil.I1I(iiL, iL1Iii);
            this.f4352IL1Iii = iLilM2501IiL;
        }
    }

    public L11I(IiL iiL) {
        this.f4346I1I = new WeakReference<>(iiL);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static IL.ILil m2501IiL(IL.IL1Iii iL1Iii) {
        switch (IL1Iii.f4350IL1Iii[iL1Iii.ordinal()]) {
            case 1:
            case 2:
                return IL.ILil.CREATED;
            case 3:
            case 4:
                return IL.ILil.STARTED;
            case 5:
                return IL.ILil.RESUMED;
            case 6:
                return IL.ILil.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + iL1Iii);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static IL.ILil m2502Ll1(IL.ILil iLil, IL.ILil iLil2) {
        return (iLil2 == null || iLil2.compareTo(iLil) >= 0) ? iLil : iLil2;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static IL.IL1Iii m2503lIlii(IL.ILil iLil) {
        int i = IL1Iii.f4351ILil[iLil.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return IL.IL1Iii.ON_START;
            }
            if (i == 3) {
                return IL.IL1Iii.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + iLil);
            }
        }
        return IL.IL1Iii.ON_CREATE;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static IL.IL1Iii m2504lLi1LL(IL.ILil iLil) {
        int i = IL1Iii.f4351ILil[iLil.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            return IL.IL1Iii.ON_DESTROY;
        }
        if (i == 3) {
            return IL.IL1Iii.ON_STOP;
        }
        if (i == 4) {
            return IL.IL1Iii.ON_PAUSE;
        }
        if (i == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + iLil);
    }

    @Override // ILil.p042lIiI.IL
    public void I1I(iILLL1 iilll1) {
        this.f4347IL1Iii.mo1438IiL(iilll1);
    }

    @Override // ILil.p042lIiI.IL
    public void IL1Iii(iILLL1 iilll1) {
        IiL iiL;
        IL.ILil iLil = this.f4348ILil;
        IL.ILil iLil2 = IL.ILil.DESTROYED;
        if (iLil != iLil2) {
            iLil2 = IL.ILil.INITIALIZED;
        }
        ILil iLil3 = new ILil(iilll1, iLil2);
        if (this.f4347IL1Iii.mo1440iILLL1(iilll1, iLil3) == null && (iiL = this.f4346I1I.get()) != null) {
            boolean z = this.f1793IL != 0 || this.f4349Ilil;
            IL.ILil Ilil2 = Ilil(iilll1);
            this.f1793IL++;
            while (iLil3.f4352IL1Iii.compareTo(Ilil2) < 0 && this.f4347IL1Iii.contains(iilll1)) {
                Lil(iLil3.f4352IL1Iii);
                iLil3.IL1Iii(iiL, m2503lIlii(iLil3.f4352IL1Iii));
                m2505ILl();
                Ilil2 = Ilil(iilll1);
            }
            if (!z) {
                m2510llL1ii();
            }
            this.f1793IL--;
        }
    }

    @Deprecated
    public void ILL(IL.ILil iLil) {
        LlLI1(iLil);
    }

    @Override // ILil.p042lIiI.IL
    public IL.ILil ILil() {
        return this.f4348ILil;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m2505ILl() {
        ArrayList<IL.ILil> arrayList = this.f1794iILLL1;
        arrayList.remove(arrayList.size() - 1);
    }

    public final IL.ILil Ilil(iILLL1 iilll1) {
        Map.Entry<iILLL1, ILil> entryM1439L11I = this.f4347IL1Iii.m1439L11I(iilll1);
        IL.ILil iLil = null;
        IL.ILil iLil2 = entryM1439L11I != null ? entryM1439L11I.getValue().f4352IL1Iii : null;
        if (!this.f1794iILLL1.isEmpty()) {
            ArrayList<IL.ILil> arrayList = this.f1794iILLL1;
            iLil = arrayList.get(arrayList.size() - 1);
        }
        return m2502Ll1(m2502Ll1(this.f4348ILil, iLil2), iLil);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m2506IL(IiL iiL) {
        Iterator<Map.Entry<iILLL1, ILil>> itIL1Iii = this.f4347IL1Iii.IL1Iii();
        while (itIL1Iii.hasNext() && !this.f1795lLi1LL) {
            Map.Entry<iILLL1, ILil> next = itIL1Iii.next();
            ILil value = next.getValue();
            while (value.f4352IL1Iii.compareTo(this.f4348ILil) > 0 && !this.f1795lLi1LL && this.f4347IL1Iii.contains(next.getKey())) {
                IL.IL1Iii iL1IiiM2504lLi1LL = m2504lLi1LL(value.f4352IL1Iii);
                Lil(m2501IiL(iL1IiiM2504lLi1LL));
                value.IL1Iii(iiL, iL1IiiM2504lLi1LL);
                m2505ILl();
            }
        }
    }

    public final void Lil(IL.ILil iLil) {
        this.f1794iILLL1.add(iLil);
    }

    public void LlLI1(IL.ILil iLil) {
        m2509lIiI(iLil);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m2507L11I(IL.IL1Iii iL1Iii) {
        m2509lIiI(m2501IiL(iL1Iii));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2508iILLL1(IiL iiL) {
        ILil.I1I.IL1Iii.ILil.ILil<iILLL1, ILil>.IL ilM1441IL = this.f4347IL1Iii.m1441IL();
        while (ilM1441IL.hasNext() && !this.f1795lLi1LL) {
            Map.Entry next = ilM1441IL.next();
            ILil iLil = (ILil) next.getValue();
            while (iLil.f4352IL1Iii.compareTo(this.f4348ILil) < 0 && !this.f1795lLi1LL && this.f4347IL1Iii.contains((iILLL1) next.getKey())) {
                Lil(iLil.f4352IL1Iii);
                iLil.IL1Iii(iiL, m2503lIlii(iLil.f4352IL1Iii));
                m2505ILl();
            }
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final void m2509lIiI(IL.ILil iLil) {
        if (this.f4348ILil == iLil) {
            return;
        }
        this.f4348ILil = iLil;
        if (this.f4349Ilil || this.f1793IL != 0) {
            this.f1795lLi1LL = true;
            return;
        }
        this.f4349Ilil = true;
        m2510llL1ii();
        this.f4349Ilil = false;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m2510llL1ii() {
        IiL iiL = this.f4346I1I.get();
        if (iiL == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!m2511il()) {
            this.f1795lLi1LL = false;
            if (this.f4348ILil.compareTo(this.f4347IL1Iii.ILil().getValue().f4352IL1Iii) < 0) {
                m2506IL(iiL);
            }
            Map.Entry<iILLL1, ILil> entryIlil = this.f4347IL1Iii.Ilil();
            if (!this.f1795lLi1LL && entryIlil != null && this.f4348ILil.compareTo(entryIlil.getValue().f4352IL1Iii) > 0) {
                m2508iILLL1(iiL);
            }
        }
        this.f1795lLi1LL = false;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final boolean m2511il() {
        if (this.f4347IL1Iii.size() == 0) {
            return true;
        }
        IL.ILil iLil = this.f4347IL1Iii.ILil().getValue().f4352IL1Iii;
        IL.ILil iLil2 = this.f4347IL1Iii.Ilil().getValue().f4352IL1Iii;
        return iLil == iLil2 && this.f4348ILil == iLil2;
    }
}
