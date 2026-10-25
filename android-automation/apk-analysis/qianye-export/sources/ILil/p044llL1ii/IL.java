package ILil.p044llL1ii;

import android.animation.TypeEvaluator;

/* JADX INFO: renamed from: ILil.ll丨L1ii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: FloatArrayEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
public class IL implements TypeEvaluator<float[]> {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public float[] f4415IL1Iii;

    public IL(float[] fArr) {
        this.f4415IL1Iii = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f4415IL1Iii;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return fArr3;
    }
}
