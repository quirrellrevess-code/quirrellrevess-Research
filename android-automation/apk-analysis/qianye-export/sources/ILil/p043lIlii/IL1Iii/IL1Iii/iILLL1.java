package ILil.p043lIlii.IL1Iii.IL1Iii;

import ILil.p028IiL.p033iILLL1.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: PathInterpolatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 implements Interpolator {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public float[] f4390IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float[] f4391ILil;

    public iILLL1(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public final void I1I(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        ILil(path);
    }

    public final void IL1Iii(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        ILil(path);
    }

    public final void ILil(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f4390IL1Iii = new float[iMin];
        this.f4391ILil = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.f4390IL1Iii[i2] = fArr[0];
            this.f4391ILil[i2] = fArr[1];
        }
        if (Math.abs(this.f4390IL1Iii[0]) <= 1.0E-5d && Math.abs(this.f4391ILil[0]) <= 1.0E-5d) {
            int i3 = iMin - 1;
            if (Math.abs(this.f4390IL1Iii[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f4391ILil[i3] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i4 = 0;
                while (i < iMin) {
                    float[] fArr2 = this.f4390IL1Iii;
                    int i5 = i4 + 1;
                    float f2 = fArr2[i4];
                    if (f2 < f) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                    }
                    fArr2[i] = f2;
                    i++;
                    f = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f4390IL1Iii[0]);
        sb.append(",");
        sb.append(this.f4391ILil[0]);
        sb.append(" end:");
        int i6 = iMin - 1;
        sb.append(this.f4390IL1Iii[i6]);
        sb.append(",");
        sb.append(this.f4391ILil[i6]);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m2544IL(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (IiL.m2318il(xmlPullParser, "pathData")) {
            String strM2315L11I = IiL.m2315L11I(typedArray, xmlPullParser, "pathData", 4);
            Path pathIlil = ILil.Ilil(strM2315L11I);
            if (pathIlil != null) {
                ILil(pathIlil);
                return;
            }
            throw new InflateException("The path is null, which is created from " + strM2315L11I);
        }
        if (!IiL.m2318il(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!IiL.m2318il(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fM2317lLi1LL = IiL.m2317lLi1LL(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fM2317lLi1LL2 = IiL.m2317lLi1LL(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zM2318il = IiL.m2318il(xmlPullParser, "controlX2");
        if (zM2318il != IiL.m2318il(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zM2318il) {
            IL1Iii(fM2317lLi1LL, fM2317lLi1LL2, IiL.m2317lLi1LL(typedArray, xmlPullParser, "controlX2", 2, 0.0f), IiL.m2317lLi1LL(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            I1I(fM2317lLi1LL, fM2317lLi1LL2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f4390IL1Iii.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f4390IL1Iii[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f4390IL1Iii;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f4391ILil[i];
        }
        float f3 = (f - fArr[i]) / f2;
        float[] fArr2 = this.f4391ILil;
        float f4 = fArr2[i];
        return f4 + (f3 * (fArr2[length] - f4));
    }

    public iILLL1(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, IL1Iii.f1798Ll1);
        m2544IL(typedArrayILL, xmlPullParser);
        typedArrayILL.recycle();
    }
}
