package ILil.p044llL1ii;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: compiled from: PathProperty.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final float f4420I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Property<T, PointF> f4421IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final PathMeasure f4422ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final PointF f4423Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final float[] f1853IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public float f1854lLi1LL;

    public Lil(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1853IL = new float[2];
        this.f4423Ilil = new PointF();
        this.f4421IL1Iii = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f4422ILil = pathMeasure;
        this.f4420I1I = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f1854lLi1LL);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.f1854lLi1LL = f.floatValue();
        this.f4422ILil.getPosTan(this.f4420I1I * f.floatValue(), this.f1853IL, null);
        PointF pointF = this.f4423Ilil;
        float[] fArr = this.f1853IL;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f4421IL1Iii.set(t, pointF);
    }
}
