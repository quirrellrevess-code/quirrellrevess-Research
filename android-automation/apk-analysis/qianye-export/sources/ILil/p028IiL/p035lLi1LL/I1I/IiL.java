package ILil.p028IiL.p035lLi1LL.I1I;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: TypedArrayUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL {
    public static ColorStateList I1I(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        if (!m2318il(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        int i2 = typedValue.type;
        if (i2 != 2) {
            return (i2 < 28 || i2 > 31) ? IL1Iii.I1I(typedArray.getResources(), typedArray.getResourceId(i, 0), theme) : m2312IL(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
    }

    public static boolean IL1Iii(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m2318il(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static TypedArray ILL(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static int ILil(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m2318il(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    public static ILil Ilil(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (m2318il(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return ILil.ILil(typedValue.data);
            }
            ILil iLilM2305iILLL1 = ILil.m2305iILLL1(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (iLilM2305iILLL1 != null) {
                return iLilM2305iILLL1;
            }
        }
        return ILil.ILil(i2);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static ColorStateList m2312IL(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static int m2313IiL(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m2318il(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static TypedValue m2314Ll1(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m2318il(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static String m2315L11I(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m2318il(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static int m2316iILLL1(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m2318il(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static float m2317lLi1LL(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m2318il(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static boolean m2318il(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }
}
