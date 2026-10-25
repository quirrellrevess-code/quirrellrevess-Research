package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0623ILl {
    public static final RectF ILL = new RectF();

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static ConcurrentHashMap<String, Method> f1352Ll1 = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static ConcurrentHashMap<String, Field> f1353lIiI = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public TextPaint f1355IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final TextView f1356L11I;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final Context f1359il;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f3760IL1Iii = 0;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f3761ILil = false;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public float f3759I1I = -1.0f;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public float f1354IL = -1.0f;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public float f3762Ilil = -1.0f;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int[] f1358lLi1LL = new int[0];

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1357iILLL1 = false;

    public C0623ILl(TextView textView) {
        this.f1356L11I = textView;
        this.f1359il = textView.getContext();
    }

    public static <T> T IL1Iii(Object obj, String str, T t) {
        try {
            Field fieldLil = Lil(str);
            return fieldLil == null ? t : (T) fieldLil.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    public static Field Lil(String str) {
        try {
            Field declaredField = f1353lIiI.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f1353lIiI.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }

    public static Method LlLI1(String str) {
        try {
            Method declaredMethod = f1352Ll1.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f1352Ll1.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static <T> T m1715lIlii(Object obj, String str, T t) {
        try {
            return (T) LlLI1(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    public void I11L(int i) {
        if (m1719L111()) {
            if (i == 0) {
                m1717IL();
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            DisplayMetrics displayMetrics = this.f1359il.getResources().getDisplayMetrics();
            m1731LLlI1(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (m17321()) {
                ILil();
            }
        }
    }

    public void I11li1(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (m1719L111()) {
            DisplayMetrics displayMetrics = this.f1359il.getResources().getDisplayMetrics();
            m1731LLlI1(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m17321()) {
                ILil();
            }
        }
    }

    public final int[] I1I(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    public int ILL() {
        return Math.round(this.f1354IL);
    }

    public void ILil() {
        if (iIi1()) {
            if (this.f3761ILil) {
                if (this.f1356L11I.getMeasuredHeight() <= 0 || this.f1356L11I.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = Build.VERSION.SDK_INT >= 29 ? this.f1356L11I.isHorizontallyScrollable() : ((Boolean) m1715lIlii(this.f1356L11I, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue() ? 1048576 : (this.f1356L11I.getMeasuredWidth() - this.f1356L11I.getTotalPaddingLeft()) - this.f1356L11I.getTotalPaddingRight();
                int height = (this.f1356L11I.getHeight() - this.f1356L11I.getCompoundPaddingBottom()) - this.f1356L11I.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = ILL;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fM1721L11I = m1721L11I(rectF);
                    if (fM1721L11I != this.f1356L11I.getTextSize()) {
                        m1730l(0, fM1721L11I);
                    }
                }
            }
            this.f3761ILil = true;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int m1716ILl() {
        return this.f3760IL1Iii;
    }

    public StaticLayout Ilil(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return m1727lLi1LL(charSequence, alignment, i, i2);
        }
        return i3 >= 16 ? m1718IiL(charSequence, alignment, i) : m1723iILLL1(charSequence, alignment, i);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1717IL() {
        this.f3760IL1Iii = 0;
        this.f1354IL = -1.0f;
        this.f3762Ilil = -1.0f;
        this.f3759I1I = -1.0f;
        this.f1358lLi1LL = new int[0];
        this.f3761ILil = false;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final StaticLayout m1718IiL(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1355IiL, i, alignment, this.f1356L11I.getLineSpacingMultiplier(), this.f1356L11I.getLineSpacingExtra(), this.f1356L11I.getIncludeFontPadding());
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final boolean m1719L111() {
        return !(this.f1356L11I instanceof AppCompatEditText);
    }

    public final boolean LL1IL(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1356L11I.getText();
        TransformationMethod transformationMethod = this.f1356L11I.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1356L11I)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1356L11I.getMaxLines() : -1;
        m1726llL1ii(i);
        StaticLayout staticLayoutIlil = Ilil(text, (Layout.Alignment) m1715lIlii(this.f1356L11I, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutIlil.getLineCount() <= maxLines && staticLayoutIlil.getLineEnd(staticLayoutIlil.getLineCount() - 1) == text.length())) && ((float) staticLayoutIlil.getHeight()) <= rectF.bottom;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int m1720Ll1() {
        return Math.round(this.f3759I1I);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int m1721L11I(RectF rectF) {
        int length = this.f1358lLi1LL.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = length - 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = (i2 + i) / 2;
            if (LL1IL(this.f1358lLi1LL[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i2;
                i2 = i5;
            } else {
                i3 = i4 - 1;
                i = i3;
            }
        }
        return this.f1358lLi1LL[i3];
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m1722LlLLL(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1358lLi1LL = I1I(iArr);
            m1725lIII();
        }
    }

    public boolean iIi1() {
        return m1719L111() && this.f3760IL1Iii != 0;
    }

    public void iIlLiL(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1359il.obtainStyledAttributes(attributeSet, ILL.AppCompatTextView, i, 0);
        int i2 = ILL.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.f3760IL1Iii = typedArrayObtainStyledAttributes.getInt(i2, 0);
        }
        int i3 = ILL.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i3) ? typedArrayObtainStyledAttributes.getDimension(i3, -1.0f) : -1.0f;
        int i4 = ILL.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = ILL.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i5) ? typedArrayObtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = ILL.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i6) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i6, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m1722LlLLL(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!m1719L111()) {
            this.f3760IL1Iii = 0;
            return;
        }
        if (this.f3760IL1Iii == 1) {
            if (!this.f1357iILLL1) {
                DisplayMetrics displayMetrics = this.f1359il.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m1731LLlI1(dimension2, dimension3, dimension);
            }
            m17321();
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final StaticLayout m1723iILLL1(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1355IiL, i, alignment, ((Float) IL1Iii(this.f1356L11I, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) IL1Iii(this.f1356L11I, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) IL1Iii(this.f1356L11I, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int[] m1724lIiI() {
        return this.f1358lLi1LL;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final boolean m1725lIII() {
        int[] iArr = this.f1358lLi1LL;
        int length = iArr.length;
        boolean z = length > 0;
        this.f1357iILLL1 = z;
        if (z) {
            this.f3760IL1Iii = 1;
            this.f1354IL = iArr[0];
            this.f3762Ilil = iArr[length - 1];
            this.f3759I1I = -1.0f;
        }
        return z;
    }

    public final void llliI(float f) {
        if (f != this.f1356L11I.getPaint().getTextSize()) {
            this.f1356L11I.getPaint().setTextSize(f);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1356L11I.isInLayout() : false;
            if (this.f1356L11I.getLayout() != null) {
                this.f3761ILil = false;
                try {
                    Method methodLlLI1 = LlLI1("nullLayouts");
                    if (methodLlLI1 != null) {
                        methodLlLI1.invoke(this.f1356L11I, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zIsInLayout) {
                    this.f1356L11I.forceLayout();
                } else {
                    this.f1356L11I.requestLayout();
                }
                this.f1356L11I.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m1726llL1ii(int i) {
        TextPaint textPaint = this.f1355IiL;
        if (textPaint == null) {
            this.f1355IiL = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1355IiL.set(this.f1356L11I.getPaint());
        this.f1355IiL.setTextSize(i);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final StaticLayout m1727lLi1LL(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1355IiL, i);
        StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(this.f1356L11I.getLineSpacingExtra(), this.f1356L11I.getLineSpacingMultiplier()).setIncludePad(this.f1356L11I.getIncludeFontPadding()).setBreakStrategy(this.f1356L11I.getBreakStrategy()).setHyphenationFrequency(this.f1356L11I.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            builderObtain.setTextDirection(Build.VERSION.SDK_INT >= 29 ? this.f1356L11I.getTextDirectionHeuristic() : (TextDirectionHeuristic) m1715lIlii(this.f1356L11I, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return builderObtain.build();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m1728il() {
        return Math.round(this.f3762Ilil);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1729lL(int[] iArr, int i) throws IllegalArgumentException {
        if (m1719L111()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1359il.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f1358lLi1LL = I1I(iArrCopyOf);
                if (!m1725lIII()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1357iILLL1 = false;
            }
            if (m17321()) {
                ILil();
            }
        }
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m1730l(int i, float f) {
        Context context = this.f1359il;
        llliI(TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m1731LLlI1(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f3760IL1Iii = 1;
        this.f1354IL = f;
        this.f3762Ilil = f2;
        this.f3759I1I = f3;
        this.f1357iILLL1 = false;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final boolean m17321() {
        if (m1719L111() && this.f3760IL1Iii == 1) {
            if (!this.f1357iILLL1 || this.f1358lLi1LL.length == 0) {
                int iFloor = ((int) Math.floor((this.f3762Ilil - this.f1354IL) / this.f3759I1I)) + 1;
                int[] iArr = new int[iFloor];
                for (int i = 0; i < iFloor; i++) {
                    iArr[i] = Math.round(this.f1354IL + (i * this.f3759I1I));
                }
                this.f1358lLi1LL = I1I(iArr);
            }
            this.f3761ILil = true;
        } else {
            this.f3761ILil = false;
        }
        return this.f3761ILil;
    }
}
