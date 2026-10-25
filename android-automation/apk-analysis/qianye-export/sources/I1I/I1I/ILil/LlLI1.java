package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.content.Context;

/* JADX INFO: compiled from: EngineManager.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final LlLI1 f962lLi1LL = new LlLI1();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public I11li1 f3160I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public lliiI1 f3161IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IL f3162ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public LLL f3163Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public iIilII1 f963IL;

    /* JADX INFO: compiled from: EngineManager.java */
    public enum IL1Iii {
        ROOT,
        ACC,
        HANDLE
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static LlLI1 m925IL() {
        return f962lLi1LL;
    }

    public synchronized C1 I1I(Context context) {
        IL1Iii iL1IiiM1160ili11 = lIlii.m1160ili11(context);
        if (iL1IiiM1160ili11 == IL1Iii.ROOT) {
            return Ilil();
        }
        if (iL1IiiM1160ili11 == IL1Iii.ACC) {
            return IL1Iii();
        }
        return ILil();
    }

    public synchronized C1 IL1Iii() {
        if (this.f3162ILil == null) {
            this.f3162ILil = new IL();
        }
        return this.f3162ILil;
    }

    public synchronized C1 ILil() {
        if (this.f3160I1I == null) {
            this.f3160I1I = new I11li1();
        }
        return this.f3160I1I;
    }

    public synchronized C1 Ilil() {
        if (this.f3161IL1Iii == null) {
            this.f3161IL1Iii = new lliiI1();
        }
        return this.f3161IL1Iii;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public synchronized LLL m926iILLL1() {
        if (this.f3163Ilil == null) {
            this.f3163Ilil = LLL.ILL();
        }
        return this.f3163Ilil;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public synchronized C1 m927lLi1LL() {
        if (this.f963IL == null) {
            this.f963IL = iIilII1.LLL();
        }
        return this.f963IL;
    }
}
