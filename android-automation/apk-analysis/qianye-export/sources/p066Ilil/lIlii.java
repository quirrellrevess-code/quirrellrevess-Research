package p066Ilil;

import javax.annotation.Nullable;

/* JADX INFO: renamed from: Ilil.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: SegmentPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    @Nullable
    public static llL1ii f4592IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static long f4593ILil;

    public static void IL1Iii(llL1ii lll1ii) {
        if (lll1ii.f2068lLi1LL != null || lll1ii.f2067iILLL1 != null) {
            throw new IllegalArgumentException();
        }
        if (lll1ii.f2066IL) {
            return;
        }
        synchronized (lIlii.class) {
            long j = f4593ILil;
            if (j + 8192 > 65536) {
                return;
            }
            f4593ILil = j + 8192;
            lll1ii.f2068lLi1LL = f4592IL1Iii;
            lll1ii.f4594I1I = 0;
            lll1ii.f4596ILil = 0;
            f4592IL1Iii = lll1ii;
        }
    }

    public static llL1ii ILil() {
        synchronized (lIlii.class) {
            llL1ii lll1ii = f4592IL1Iii;
            if (lll1ii == null) {
                return new llL1ii();
            }
            f4592IL1Iii = lll1ii.f2068lLi1LL;
            lll1ii.f2068lLi1LL = null;
            f4593ILil -= 8192;
            return lll1ii;
        }
    }
}
