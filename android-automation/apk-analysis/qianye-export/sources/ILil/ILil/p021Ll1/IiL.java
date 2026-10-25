package ILil.ILil.p021Ll1;

/* JADX INFO: renamed from: ILil.ILil.Ll丨1.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: TwilightCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static IiL f1308IL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3720I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public long f3721IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f3722ILil;

    public static IiL ILil() {
        if (f1308IL == null) {
            f1308IL = new IiL();
        }
        return f1308IL;
    }

    public void IL1Iii(long j, double d, double d2) {
        float f = (j - 946728000000L) / 8.64E7f;
        float f2 = (0.01720197f * f) + 6.24006f;
        double d3 = f2;
        double dSin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin(2.0f * f2) * 3.4906598739326E-4d) + (Math.sin(f2 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double dRound = ((double) (Math.round(((double) (f - 9.0E-4f)) - d4) + 9.0E-4f)) + d4 + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(dAsin))) / (Math.cos(d5) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f3720I1I = 1;
            this.f3721IL1Iii = -1L;
            this.f3722ILil = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f3720I1I = 0;
                this.f3721IL1Iii = -1L;
                this.f3722ILil = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f3721IL1Iii = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f3722ILil = jRound;
            if (jRound >= j || this.f3721IL1Iii <= j) {
                this.f3720I1I = 1;
            } else {
                this.f3720I1I = 0;
            }
        }
    }
}
