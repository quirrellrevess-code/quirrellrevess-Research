package androidx.transition;

import ILil.p028IiL.p033iILLL1.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p044llL1ii.I11li1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Path f5182IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Matrix f5183ILil;

    public PatternPathMotion() {
        Path path = new Path();
        this.f5182IL1Iii = path;
        this.f5183ILil = new Matrix();
        path.lineTo(1.0f, 0.0f);
    }

    public static float ILil(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public void I1I(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f5183ILil.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fILil = 1.0f / ILil(f5, f6);
        this.f5183ILil.postScale(fILil, fILil);
        this.f5183ILil.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.f5183ILil, this.f5182IL1Iii);
    }

    @Override // androidx.transition.PathMotion
    public Path IL1Iii(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float fILil = ILil(f5, f6);
        double dAtan2 = Math.atan2(f6, f5);
        this.f5183ILil.setScale(fILil, fILil);
        this.f5183ILil.postRotate((float) Math.toDegrees(dAtan2));
        this.f5183ILil.postTranslate(f, f2);
        Path path = new Path();
        this.f5182IL1Iii.transform(this.f5183ILil, path);
        return path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f5182IL1Iii = new Path();
        this.f5183ILil = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f1848L11I);
        try {
            String strM2315L11I = IiL.m2315L11I(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strM2315L11I != null) {
                I1I(ILil.Ilil(strM2315L11I));
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
