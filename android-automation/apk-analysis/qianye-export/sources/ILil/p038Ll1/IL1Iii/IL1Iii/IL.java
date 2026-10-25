package ILil.p038Ll1.IL1Iii.IL1Iii;

import android.view.animation.Interpolator;

/* JADX INFO: renamed from: ILil.Ll丨1.IL1Iii.IL1Iii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: LookupTableInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL implements Interpolator {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final float[] f4316IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final float f4317ILil;

    public IL(float[] fArr) {
        this.f4316IL1Iii = fArr;
        this.f4317ILil = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f4316IL1Iii;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f4317ILil;
        float f3 = (f - (iMin * f2)) / f2;
        float[] fArr2 = this.f4316IL1Iii;
        return fArr2[iMin] + (f3 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
