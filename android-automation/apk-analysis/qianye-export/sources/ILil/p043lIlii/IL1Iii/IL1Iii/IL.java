package ILil.p043lIlii.IL1Iii.IL1Iii;

import ILil.p028IiL.p033iILLL1.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.google.android.flexbox.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: AnimatorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.I丨L$IL1Iii */
    /* JADX INFO: compiled from: AnimatorInflaterCompat.java */
    public static class IL1Iii implements TypeEvaluator<ILil.C0572ILil[]> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public ILil.C0572ILil[] f4369IL1Iii;

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public ILil.C0572ILil[] evaluate(float f, ILil.C0572ILil[] c0572ILilArr, ILil.C0572ILil[] c0572ILilArr2) {
            if (!ILil.ILil(c0572ILilArr, c0572ILilArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!ILil.ILil(this.f4369IL1Iii, c0572ILilArr)) {
                this.f4369IL1Iii = ILil.m2267lLi1LL(c0572ILilArr);
            }
            for (int i = 0; i < c0572ILilArr.length; i++) {
                this.f4369IL1Iii[i].m2269IL(c0572ILilArr[i], c0572ILilArr2[i], f);
            }
            return this.f4369IL1Iii;
        }
    }

    public static Keyframe I1I(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        return keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    public static Animator IL1Iii(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return ILil(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    public static Animator ILL(Context context, Resources resources, Resources.Theme theme, int i, float f) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i);
                    Animator animatorIL1Iii = IL1Iii(context, resources, theme, animation, f);
                    if (animation != null) {
                        animation.close();
                    }
                    return animatorIL1Iii;
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    public static Animator ILil(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        int i2;
        int depth = xmlPullParser.getDepth();
        Animator animatorM2515Ll1 = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorM2515Ll1 = m2512ILl(context, resources, theme, attributeSet, f, xmlPullParser);
                } else {
                    if (name.equals("animator")) {
                        animatorM2515Ll1 = m2515Ll1(context, resources, theme, attributeSet, null, f, xmlPullParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1797IiL);
                        ILil(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, IiL.m2316iILLL1(typedArrayILL, xmlPullParser, "ordering", 0, 0), f);
                        typedArrayILL.recycle();
                        animatorM2515Ll1 = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] propertyValuesHolderArrLlLI1 = LlLI1(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (propertyValuesHolderArrLlLI1 != null && (animatorM2515Ll1 instanceof ValueAnimator)) {
                            ((ValueAnimator) animatorM2515Ll1).setValues(propertyValuesHolderArrLlLI1);
                        }
                        i2 = 1;
                    }
                    if (animatorSet == null && i2 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorM2515Ll1);
                    }
                }
                if (animatorSet == null) {
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorM2515Ll1;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static ObjectAnimator m2512ILl(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m2515Ll1(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    public static PropertyValuesHolder Ilil(TypedArray typedArray, int i, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && m2514IiL(i4)) || (z2 && m2514IiL(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            ILil.C0572ILil[] c0572ILilArrM2263IL = ILil.m2263IL(string);
            ILil.C0572ILil[] c0572ILilArrM2263IL2 = ILil.m2263IL(string2);
            if (c0572ILilArrM2263IL == null && c0572ILilArrM2263IL2 == null) {
                return null;
            }
            if (c0572ILilArrM2263IL == null) {
                if (c0572ILilArrM2263IL2 != null) {
                    return PropertyValuesHolder.ofObject(str, new IL1Iii(), c0572ILilArrM2263IL2);
                }
                return null;
            }
            IL1Iii iL1Iii = new IL1Iii();
            if (c0572ILilArrM2263IL2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, iL1Iii, c0572ILilArrM2263IL);
            } else {
                if (!ILil.ILil(c0572ILilArrM2263IL, c0572ILilArrM2263IL2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, iL1Iii, c0572ILilArrM2263IL, c0572ILilArrM2263IL2);
            }
            return propertyValuesHolderOfObject;
        }
        lLi1LL lli1llIL1Iii = i == 3 ? lLi1LL.IL1Iii() : null;
        if (z3) {
            if (z) {
                float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, 0.0f);
            } else {
                color2 = m2514IiL(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, 0.0f);
                } else {
                    color3 = m2514IiL(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color = m2514IiL(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || lli1llIL1Iii == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(lli1llIL1Iii);
        return propertyValuesHolderOfInt;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2513IL(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m2514IiL(int i) {
        return i >= 28 && i <= 31;
    }

    public static PropertyValuesHolder Lil(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = m2517iILLL1(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM2518lIiI = m2518lIiI(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (keyframeM2518lIiI != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeM2518lIiI);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), I1I(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, I1I(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            m2513IL(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(lLi1LL.IL1Iii());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    public static PropertyValuesHolder[] LlLI1(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1799L11I);
                    String strM2315L11I = IiL.m2315L11I(typedArrayILL, xmlPullParser, "propertyName", 3);
                    int iM2316iILLL1 = IiL.m2316iILLL1(typedArrayILL, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderLil = Lil(context, resources, theme, xmlPullParser, strM2315L11I, iM2316iILLL1);
                    if (propertyValuesHolderLil == null) {
                        propertyValuesHolderLil = Ilil(typedArrayILL, iM2316iILLL1, 0, 1, strM2315L11I);
                    }
                    if (propertyValuesHolderLil != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderLil);
                    }
                    typedArrayILL.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static ValueAnimator m2515Ll1(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1800iILLL1);
        TypedArray typedArrayILL2 = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.ILL);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m2520llL1ii(valueAnimator, typedArrayILL, typedArrayILL2, f, xmlPullParser);
        int iM2313IiL = IiL.m2313IiL(typedArrayILL, xmlPullParser, "interpolator", 0, 0);
        if (iM2313IiL > 0) {
            valueAnimator.setInterpolator(I1I.ILil(context, iM2313IiL));
        }
        typedArrayILL.recycle();
        if (typedArrayILL2 != null) {
            typedArrayILL2.recycle();
        }
        return valueAnimator;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static Animator m2516L11I(Context context, int i) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : m2522il(context, context.getResources(), context.getTheme(), i);
    }

    public static void iIi1(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f3 = length / (iMin - 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f2 += f3;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f2 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static int m2517iILLL1(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1802il);
        int i = 0;
        TypedValue typedValueM2314Ll1 = IiL.m2314Ll1(typedArrayILL, xmlPullParser, "value", 0);
        if ((typedValueM2314Ll1 != null) && m2514IiL(typedValueM2314Ll1.type)) {
            i = 3;
        }
        typedArrayILL.recycle();
        return i;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static Keyframe m2518lIiI(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe keyframeOfFloat;
        TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1802il);
        float fM2317lLi1LL = IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueM2314Ll1 = IiL.m2314Ll1(typedArrayILL, xmlPullParser, "value", 0);
        boolean z = typedValueM2314Ll1 != null;
        if (i == 4) {
            i = (z && m2514IiL(typedValueM2314Ll1.type)) ? 3 : 0;
        }
        if (!z) {
            keyframeOfFloat = i == 0 ? Keyframe.ofFloat(fM2317lLi1LL) : Keyframe.ofInt(fM2317lLi1LL);
        } else if (i != 0) {
            keyframeOfFloat = (i == 1 || i == 3) ? Keyframe.ofInt(fM2317lLi1LL, IiL.m2316iILLL1(typedArrayILL, xmlPullParser, "value", 0, 0)) : null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(fM2317lLi1LL, IiL.m2317lLi1LL(typedArrayILL, xmlPullParser, "value", 0, 0.0f));
        }
        int iM2313IiL = IiL.m2313IiL(typedArrayILL, xmlPullParser, "interpolator", 1, 0);
        if (iM2313IiL > 0) {
            keyframeOfFloat.setInterpolator(I1I.ILil(context, iM2313IiL));
        }
        typedArrayILL.recycle();
        return keyframeOfFloat;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static void m2519lIlii(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strM2315L11I = IiL.m2315L11I(typedArray, xmlPullParser, "pathData", 1);
        if (strM2315L11I == null) {
            objectAnimator.setPropertyName(IiL.m2315L11I(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String strM2315L11I2 = IiL.m2315L11I(typedArray, xmlPullParser, "propertyXName", 2);
        String strM2315L11I3 = IiL.m2315L11I(typedArray, xmlPullParser, "propertyYName", 3);
        if (i != 2) {
        }
        if (strM2315L11I2 != null || strM2315L11I3 != null) {
            iIi1(ILil.Ilil(strM2315L11I), objectAnimator, f * 0.5f, strM2315L11I2, strM2315L11I3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static void m2520llL1ii(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long jM2316iILLL1 = IiL.m2316iILLL1(typedArray, xmlPullParser, "duration", 1, 300);
        long jM2316iILLL2 = IiL.m2316iILLL1(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iM2316iILLL1 = IiL.m2316iILLL1(typedArray, xmlPullParser, "valueType", 7, 4);
        if (IiL.m2318il(xmlPullParser, "valueFrom") && IiL.m2318il(xmlPullParser, "valueTo")) {
            if (iM2316iILLL1 == 4) {
                iM2316iILLL1 = m2521lLi1LL(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderIlil = Ilil(typedArray, iM2316iILLL1, 5, 6, BuildConfig.FLAVOR);
            if (propertyValuesHolderIlil != null) {
                valueAnimator.setValues(propertyValuesHolderIlil);
            }
        }
        valueAnimator.setDuration(jM2316iILLL1);
        valueAnimator.setStartDelay(jM2316iILLL2);
        valueAnimator.setRepeatCount(IiL.m2316iILLL1(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(IiL.m2316iILLL1(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m2519lIlii(valueAnimator, typedArray2, iM2316iILLL1, f, xmlPullParser);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m2521lLi1LL(TypedArray typedArray, int i, int i2) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && m2514IiL(i3)) || (z2 && m2514IiL(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static Animator m2522il(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return ILL(context, resources, theme, i, 1.0f);
    }
}
