package ILil.p028IiL.p035lLi1LL.I1I;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: GradientColorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL {
    public static IL1Iii I1I(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p028IiL.IL.GradientColorItem);
                int i = ILil.p028IiL.IL.GradientColorItem_android_color;
                boolean zHasValue = typedArrayILL.hasValue(i);
                int i2 = ILil.p028IiL.IL.GradientColorItem_android_offset;
                boolean zHasValue2 = typedArrayILL.hasValue(i2);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayILL.getColor(i, 0);
                float f = typedArrayILL.getFloat(i2, 0.0f);
                typedArrayILL.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new IL1Iii(arrayList2, arrayList);
        }
        return null;
    }

    public static IL1Iii IL1Iii(IL1Iii iL1Iii, int i, int i2, boolean z, int i3) {
        if (iL1Iii != null) {
            return iL1Iii;
        }
        return z ? new IL1Iii(i, i3, i2) : new IL1Iii(i, i2);
    }

    public static Shader ILil(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p028IiL.IL.GradientColor);
        float fM2317lLi1LL = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "startX", ILil.p028IiL.IL.GradientColor_android_startX, 0.0f);
        float fM2317lLi1LL2 = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "startY", ILil.p028IiL.IL.GradientColor_android_startY, 0.0f);
        float fM2317lLi1LL3 = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "endX", ILil.p028IiL.IL.GradientColor_android_endX, 0.0f);
        float fM2317lLi1LL4 = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "endY", ILil.p028IiL.IL.GradientColor_android_endY, 0.0f);
        float fM2317lLi1LL5 = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "centerX", ILil.p028IiL.IL.GradientColor_android_centerX, 0.0f);
        float fM2317lLi1LL6 = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "centerY", ILil.p028IiL.IL.GradientColor_android_centerY, 0.0f);
        int iM2316iILLL1 = IiL.m2316iILLL1(typedArrayILL, xmlPullParser, "type", ILil.p028IiL.IL.GradientColor_android_type, 0);
        int iILil = IiL.ILil(typedArrayILL, xmlPullParser, "startColor", ILil.p028IiL.IL.GradientColor_android_startColor, 0);
        boolean zM2318il = IiL.m2318il(xmlPullParser, "centerColor");
        int iILil2 = IiL.ILil(typedArrayILL, xmlPullParser, "centerColor", ILil.p028IiL.IL.GradientColor_android_centerColor, 0);
        int iILil3 = IiL.ILil(typedArrayILL, xmlPullParser, "endColor", ILil.p028IiL.IL.GradientColor_android_endColor, 0);
        int iM2316iILLL2 = IiL.m2316iILLL1(typedArrayILL, xmlPullParser, "tileMode", ILil.p028IiL.IL.GradientColor_android_tileMode, 0);
        float fM2317lLi1LL7 = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "gradientRadius", ILil.p028IiL.IL.GradientColor_android_gradientRadius, 0.0f);
        typedArrayILL.recycle();
        IL1Iii IL1Iii2 = IL1Iii(I1I(resources, xmlPullParser, attributeSet, theme), iILil, iILil3, zM2318il, iILil2);
        if (iM2316iILLL1 != 1) {
            return iM2316iILLL1 != 2 ? new LinearGradient(fM2317lLi1LL, fM2317lLi1LL2, fM2317lLi1LL3, fM2317lLi1LL4, IL1Iii2.f4212IL1Iii, IL1Iii2.f4213ILil, m2311IL(iM2316iILLL2)) : new SweepGradient(fM2317lLi1LL5, fM2317lLi1LL6, IL1Iii2.f4212IL1Iii, IL1Iii2.f4213ILil);
        }
        if (fM2317lLi1LL7 > 0.0f) {
            return new RadialGradient(fM2317lLi1LL5, fM2317lLi1LL6, fM2317lLi1LL7, IL1Iii2.f4212IL1Iii, IL1Iii2.f4213ILil, m2311IL(iM2316iILLL2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Shader.TileMode m2311IL(int i) {
        if (i != 1) {
            return i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.I丨L$IL1Iii */
    /* JADX INFO: compiled from: GradientColorInflaterCompat.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int[] f4212IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final float[] f4213ILil;

        public IL1Iii(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f4212IL1Iii = new int[size];
            this.f4213ILil = new float[size];
            for (int i = 0; i < size; i++) {
                this.f4212IL1Iii[i] = list.get(i).intValue();
                this.f4213ILil[i] = list2.get(i).floatValue();
            }
        }

        public IL1Iii(int i, int i2) {
            this.f4212IL1Iii = new int[]{i, i2};
            this.f4213ILil = new float[]{0.0f, 1.0f};
        }

        public IL1Iii(int i, int i2, int i3) {
            this.f4212IL1Iii = new int[]{i, i2, i3};
            this.f4213ILil = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
