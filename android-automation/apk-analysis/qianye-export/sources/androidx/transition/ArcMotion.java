package androidx.transition;

import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p044llL1ii.I11li1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final float f2737IL = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public float f5134I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public float f5135IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float f5136ILil;

    public ArcMotion() {
        this.f5135IL1Iii = 0.0f;
        this.f5136ILil = 0.0f;
        this.f5134I1I = f2737IL;
    }

    public static float Ilil(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    public void I1I(float f) {
        this.f5135IL1Iii = Ilil(f);
    }

    @Override // androidx.transition.PathMotion
    public Path IL1Iii(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Path path = new Path();
        path.moveTo(f, f2);
        float f8 = f3 - f;
        float f9 = f4 - f2;
        float f10 = (f8 * f8) + (f9 * f9);
        float f11 = (f + f3) / 2.0f;
        float f12 = (f2 + f4) / 2.0f;
        float f13 = 0.25f * f10;
        boolean z = f2 > f4;
        if (Math.abs(f8) < Math.abs(f9)) {
            float fAbs = Math.abs(f10 / (f9 * 2.0f));
            if (z) {
                f6 = fAbs + f4;
                f5 = f3;
            } else {
                f6 = fAbs + f2;
                f5 = f;
            }
            f7 = this.f5136ILil;
        } else {
            float f14 = f10 / (f8 * 2.0f);
            if (z) {
                f6 = f2;
                f5 = f14 + f;
            } else {
                f5 = f3 - f14;
                f6 = f4;
            }
            f7 = this.f5135IL1Iii;
        }
        float f15 = f13 * f7 * f7;
        float f16 = f11 - f5;
        float f17 = f12 - f6;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.f5134I1I;
        float f20 = f13 * f19 * f19;
        if (f18 >= f15) {
            f15 = f18 > f20 ? f20 : 0.0f;
        }
        if (f15 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f15 / f18);
            f5 = ((f5 - f11) * fSqrt) + f11;
            f6 = f12 + (fSqrt * (f6 - f12));
        }
        path.cubicTo((f + f5) / 2.0f, (f2 + f6) / 2.0f, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f, f3, f4);
        return path;
    }

    public void ILil(float f) {
        this.f5134I1I = Ilil(f);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3359IL(float f) {
        this.f5136ILil = Ilil(f);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5135IL1Iii = 0.0f;
        this.f5136ILil = 0.0f;
        this.f5134I1I = f2737IL;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f1847IiL);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        m3359IL(IiL.m2317lLi1LL(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        I1I(IiL.m2317lLi1LL(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        ILil(IiL.m2317lLi1LL(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        typedArrayObtainStyledAttributes.recycle();
    }
}
