package androidx.lifecycle;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.ILil;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ILil f5028IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lLi1LL f5029ILil;

    public static /* synthetic */ class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f5030IL1Iii;

        static {
            int[] iArr = new int[IL.IL1Iii.values().length];
            f5030IL1Iii = iArr;
            try {
                iArr[IL.IL1Iii.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5030IL1Iii[IL.IL1Iii.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5030IL1Iii[IL.IL1Iii.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5030IL1Iii[IL.IL1Iii.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5030IL1Iii[IL.IL1Iii.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5030IL1Iii[IL.IL1Iii.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5030IL1Iii[IL.IL1Iii.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public FullLifecycleObserverAdapter(ILil iLil, lLi1LL lli1ll) {
        this.f5028IL1Iii = iLil;
        this.f5029ILil = lli1ll;
    }

    @Override // ILil.p042lIiI.lLi1LL
    public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
        switch (IL1Iii.f5030IL1Iii[iL1Iii.ordinal()]) {
            case 1:
                this.f5028IL1Iii.ILil(iiL);
                break;
            case 2:
                this.f5028IL1Iii.m2499iILLL1(iiL);
                break;
            case 3:
                this.f5028IL1Iii.IL1Iii(iiL);
                break;
            case 4:
                this.f5028IL1Iii.m2498IL(iiL);
                break;
            case 5:
                this.f5028IL1Iii.Ilil(iiL);
                break;
            case 6:
                this.f5028IL1Iii.m2500lLi1LL(iiL);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        lLi1LL lli1ll = this.f5029ILil;
        if (lli1ll != null) {
            lli1ll.I1I(iiL, iL1Iii);
        }
    }
}
