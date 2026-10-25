package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import ILil.p028IiL.Lil.C0636il;
import ILil.p028IiL.Lil.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.iILLL1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public C0627LLlI1 f3807I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final TextView f3808IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public C0627LLlI1 f3809ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public C0627LLlI1 f3810Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public C0627LLlI1 f1393IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public C0627LLlI1 f1394IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Typeface f1395Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final C0623ILl f1396L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public C0627LLlI1 f1397iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1398lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public C0627LLlI1 f1399lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1400il = 0;
    public int ILL = -1;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    public static class IL1Iii extends iILLL1.IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f3811I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final WeakReference<lIiI> f3812IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f3813ILil;

        /* JADX INFO: renamed from: ILil.ILil.lI丨lii.lIi丨I$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppCompatTextHelper.java */
        public class RunnableC0555IL1Iii implements Runnable {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final Typeface f3814I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final WeakReference<lIiI> f3815ILil;

            public RunnableC0555IL1Iii(IL1Iii iL1Iii, WeakReference<lIiI> weakReference, Typeface typeface) {
                this.f3815ILil = weakReference;
                this.f3814I1I = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                lIiI liii = this.f3815ILil.get();
                if (liii == null) {
                    return;
                }
                liii.m1807lIII(this.f3814I1I);
            }
        }

        public IL1Iii(lIiI liii, int i, int i2) {
            this.f3812IL1Iii = new WeakReference<>(liii);
            this.f3813ILil = i;
            this.f3811I1I = i2;
        }

        @Override // ILil.p028IiL.p035lLi1LL.I1I.iILLL1.IL1Iii
        public void onFontRetrievalFailed(int i) {
        }

        @Override // ILil.p028IiL.p035lLi1LL.I1I.iILLL1.IL1Iii
        public void onFontRetrieved(Typeface typeface) {
            int i;
            lIiI liii = this.f3812IL1Iii.get();
            if (liii == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f3813ILil) != -1) {
                typeface = Typeface.create(typeface, i, (this.f3811I1I & 2) != 0);
            }
            liii.m1809llL1ii(new RunnableC0555IL1Iii(this, this.f3812IL1Iii, typeface));
        }
    }

    public lIiI(TextView textView) {
        this.f3808IL1Iii = textView;
        this.f1396L11I = new C0623ILl(textView);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static C0627LLlI1 m1799IL(Context context, iILLL1 iilll1, int i) {
        ColorStateList colorStateListM1784lLi1LL = iilll1.m1784lLi1LL(context, i);
        if (colorStateListM1784lLi1LL == null) {
            return null;
        }
        C0627LLlI1 c0627LLlI1 = new C0627LLlI1();
        c0627LLlI1.f1431IL = true;
        c0627LLlI1.f3850IL1Iii = colorStateListM1784lLi1LL;
        return c0627LLlI1;
    }

    public void I11L(PorterDuff.Mode mode) {
        if (this.f1394IiL == null) {
            this.f1394IiL = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f1394IiL;
        c0627LLlI1.f3851ILil = mode;
        c0627LLlI1.f3849I1I = mode != null;
        m1813l();
    }

    public void I11li1(int i) {
        this.f1396L11I.I11L(i);
    }

    public void I1I() {
        this.f1396L11I.ILil();
    }

    public final void IL1Iii(Drawable drawable, C0627LLlI1 c0627LLlI1) {
        if (drawable == null || c0627LLlI1 == null) {
            return;
        }
        iILLL1.m1781L11I(drawable, c0627LLlI1, this.f3808IL1Iii.getDrawableState());
    }

    public PorterDuff.Mode ILL() {
        C0627LLlI1 c0627LLlI1 = this.f1394IiL;
        if (c0627LLlI1 != null) {
            return c0627LLlI1.f3851ILil;
        }
        return null;
    }

    public void ILil() {
        if (this.f3809ILil != null || this.f3807I1I != null || this.f1393IL != null || this.f3810Ilil != null) {
            Drawable[] compoundDrawables = this.f3808IL1Iii.getCompoundDrawables();
            IL1Iii(compoundDrawables[0], this.f3809ILil);
            IL1Iii(compoundDrawables[1], this.f3807I1I);
            IL1Iii(compoundDrawables[2], this.f1393IL);
            IL1Iii(compoundDrawables[3], this.f3810Ilil);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f1399lLi1LL == null && this.f1397iILLL1 == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f3808IL1Iii.getCompoundDrawablesRelative();
            IL1Iii(compoundDrawablesRelative[0], this.f1399lLi1LL);
            IL1Iii(compoundDrawablesRelative[2], this.f1397iILLL1);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m1800ILl(boolean z, int i, int i2, int i3, int i4) {
        if (ILil.f4129IL1Iii) {
            return;
        }
        I1I();
    }

    public int Ilil() {
        return this.f1396L11I.m1728il();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int[] m1801IiL() {
        return this.f1396L11I.m1724lIiI();
    }

    public final void LL1IL(Context context, llI lli) {
        String strLil;
        this.f1400il = lli.ILL(ILL.TextAppearance_android_textStyle, this.f1400il);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int iILL = lli.ILL(ILL.TextAppearance_android_textFontWeight, -1);
            this.ILL = iILL;
            if (iILL != -1) {
                this.f1400il = (this.f1400il & 2) | 0;
            }
        }
        int i2 = ILL.TextAppearance_android_fontFamily;
        if (!lli.m1829lIlii(i2) && !lli.m1829lIlii(ILL.TextAppearance_fontFamily)) {
            int i3 = ILL.TextAppearance_android_typeface;
            if (lli.m1829lIlii(i3)) {
                this.f1398lIiI = false;
                int iILL2 = lli.ILL(i3, 1);
                if (iILL2 == 1) {
                    this.f1395Ll1 = Typeface.SANS_SERIF;
                    return;
                } else if (iILL2 == 2) {
                    this.f1395Ll1 = Typeface.SERIF;
                    return;
                } else {
                    if (iILL2 != 3) {
                        return;
                    }
                    this.f1395Ll1 = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1395Ll1 = null;
        int i4 = ILL.TextAppearance_fontFamily;
        if (lli.m1829lIlii(i4)) {
            i2 = i4;
        }
        int i5 = this.ILL;
        int i6 = this.f1400il;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM1832il = lli.m1832il(i2, this.f1400il, new IL1Iii(this, i5, i6));
                if (typefaceM1832il != null) {
                    if (i < 28 || this.ILL == -1) {
                        this.f1395Ll1 = typefaceM1832il;
                    } else {
                        this.f1395Ll1 = Typeface.create(Typeface.create(typefaceM1832il, 0), this.ILL, (this.f1400il & 2) != 0);
                    }
                }
                this.f1398lIiI = this.f1395Ll1 == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1395Ll1 != null || (strLil = lli.Lil(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.ILL == -1) {
            this.f1395Ll1 = Typeface.create(strLil, this.f1400il);
        } else {
            this.f1395Ll1 = Typeface.create(Typeface.create(strLil, 0), this.ILL, (this.f1400il & 2) != 0);
        }
    }

    public void Lil() {
        ILil();
    }

    public void LlLI1(Context context, int i) {
        String strLil;
        ColorStateList colorStateListI1I;
        llI lliIIi1 = llI.iIi1(context, i, ILL.TextAppearance);
        int i2 = ILL.TextAppearance_textAllCaps;
        if (lliIIi1.m1829lIlii(i2)) {
            m1808lIlii(lliIIi1.IL1Iii(i2, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            int i4 = ILL.TextAppearance_android_textColor;
            if (lliIIi1.m1829lIlii(i4) && (colorStateListI1I = lliIIi1.I1I(i4)) != null) {
                this.f3808IL1Iii.setTextColor(colorStateListI1I);
            }
        }
        int i5 = ILL.TextAppearance_android_textSize;
        if (lliIIi1.m1829lIlii(i5) && lliIIi1.m1831lLi1LL(i5, -1) == 0) {
            this.f3808IL1Iii.setTextSize(0, 0.0f);
        }
        LL1IL(context, lliIIi1);
        if (i3 >= 26) {
            int i6 = ILL.TextAppearance_fontVariationSettings;
            if (lliIIi1.m1829lIlii(i6) && (strLil = lliIIi1.Lil(i6)) != null) {
                this.f3808IL1Iii.setFontVariationSettings(strLil);
            }
        }
        lliIIi1.m1833lL();
        Typeface typeface = this.f1395Ll1;
        if (typeface != null) {
            this.f3808IL1Iii.setTypeface(typeface, this.f1400il);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m1802Ll1() {
        return this.f1396L11I.iIi1();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int m1803L11I() {
        return this.f1396L11I.m1716ILl();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m1804LlLLL(int i, float f) {
        this.f1396L11I.m1730l(i, f);
    }

    public void iIi1(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.f1396L11I.I11li1(i, i2, i3, i4);
    }

    public void iIlLiL(int[] iArr, int i) throws IllegalArgumentException {
        this.f1396L11I.m1729lL(iArr, i);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m1805iILLL1() {
        return this.f1396L11I.m1720Ll1();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:53:0x0109  */
    /* JADX WARN: Code duplicated, block: B:61:0x0130  */
    /* JADX WARN: Code duplicated, block: B:72:0x015b A[PHI: r11 r13
  0x015b: PHI (r11v2 android.content.res.ColorStateList) = (r11v1 android.content.res.ColorStateList), (r11v7 android.content.res.ColorStateList) binds: [B:62:0x0134, B:70:0x0154] A[DONT_GENERATE, DONT_INLINE]
  0x015b: PHI (r13v2 android.content.res.ColorStateList) = (r13v1 android.content.res.ColorStateList), (r13v4 android.content.res.ColorStateList) binds: [B:62:0x0134, B:70:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x0196  */
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1806lIiI(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListI1I;
        String strLil;
        ColorStateList colorStateListI1I2;
        String strLil2;
        ColorStateList colorStateListI1I3;
        boolean zIL1Iii;
        boolean z;
        int i2;
        ColorStateList colorStateListI1I4;
        iILLL1 iilll1;
        int i3;
        Context context = this.f3808IL1Iii.getContext();
        iILLL1 iilll1ILil = iILLL1.ILil();
        llI lliI11li1 = llI.I11li1(context, attributeSet, ILL.AppCompatTextHelper, i, 0);
        int iM1822ILl = lliI11li1.m1822ILl(ILL.AppCompatTextHelper_android_textAppearance, -1);
        int i4 = ILL.AppCompatTextHelper_android_drawableLeft;
        if (lliI11li1.m1829lIlii(i4)) {
            this.f3809ILil = m1799IL(context, iilll1ILil, lliI11li1.m1822ILl(i4, 0));
        }
        int i5 = ILL.AppCompatTextHelper_android_drawableTop;
        if (lliI11li1.m1829lIlii(i5)) {
            this.f3807I1I = m1799IL(context, iilll1ILil, lliI11li1.m1822ILl(i5, 0));
        }
        int i6 = ILL.AppCompatTextHelper_android_drawableRight;
        if (lliI11li1.m1829lIlii(i6)) {
            this.f1393IL = m1799IL(context, iilll1ILil, lliI11li1.m1822ILl(i6, 0));
        }
        int i7 = ILL.AppCompatTextHelper_android_drawableBottom;
        if (lliI11li1.m1829lIlii(i7)) {
            this.f3810Ilil = m1799IL(context, iilll1ILil, lliI11li1.m1822ILl(i7, 0));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 17) {
            int i9 = ILL.AppCompatTextHelper_android_drawableStart;
            if (lliI11li1.m1829lIlii(i9)) {
                this.f1399lLi1LL = m1799IL(context, iilll1ILil, lliI11li1.m1822ILl(i9, 0));
            }
            int i10 = ILL.AppCompatTextHelper_android_drawableEnd;
            if (lliI11li1.m1829lIlii(i10)) {
                this.f1397iILLL1 = m1799IL(context, iilll1ILil, lliI11li1.m1822ILl(i10, 0));
            }
        }
        lliI11li1.m1833lL();
        boolean z2 = this.f3808IL1Iii.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iM1822ILl != -1) {
            llI lliIIi1 = llI.iIi1(context, iM1822ILl, ILL.TextAppearance);
            if (z2) {
                zIL1Iii = false;
                z = false;
            } else {
                int i11 = ILL.TextAppearance_textAllCaps;
                if (lliIIi1.m1829lIlii(i11)) {
                    zIL1Iii = lliIIi1.IL1Iii(i11, false);
                    z = true;
                } else {
                    zIL1Iii = false;
                    z = false;
                }
            }
            LL1IL(context, lliIIi1);
            if (i8 < 23) {
                int i12 = ILL.TextAppearance_android_textColor;
                colorStateListI1I2 = lliIIi1.m1829lIlii(i12) ? lliIIi1.I1I(i12) : null;
                int i13 = ILL.TextAppearance_android_textColorHint;
                colorStateListI1I3 = lliIIi1.m1829lIlii(i13) ? lliIIi1.I1I(i13) : null;
                int i14 = ILL.TextAppearance_android_textColorLink;
                colorStateListI1I = lliIIi1.m1829lIlii(i14) ? lliIIi1.I1I(i14) : null;
            } else {
                colorStateListI1I = null;
                colorStateListI1I2 = null;
                colorStateListI1I3 = null;
            }
            int i15 = ILL.TextAppearance_textLocale;
            strLil2 = lliIIi1.m1829lIlii(i15) ? lliIIi1.Lil(i15) : null;
            if (i8 >= 26) {
                int i16 = ILL.TextAppearance_fontVariationSettings;
                if (lliIIi1.m1829lIlii(i16)) {
                    strLil = lliIIi1.Lil(i16);
                } else {
                    strLil = null;
                }
            } else {
                strLil = null;
            }
            lliIIi1.m1833lL();
        } else {
            colorStateListI1I = null;
            strLil = null;
            colorStateListI1I2 = null;
            strLil2 = null;
            colorStateListI1I3 = null;
            zIL1Iii = false;
            z = false;
        }
        llI lliI11li2 = llI.I11li1(context, attributeSet, ILL.TextAppearance, i, 0);
        if (z2) {
            i2 = 23;
        } else {
            int i17 = ILL.TextAppearance_textAllCaps;
            if (lliI11li2.m1829lIlii(i17)) {
                zIL1Iii = lliI11li2.IL1Iii(i17, false);
                i2 = 23;
                z = true;
            } else {
                i2 = 23;
            }
        }
        if (i8 < i2) {
            int i18 = ILL.TextAppearance_android_textColor;
            if (lliI11li2.m1829lIlii(i18)) {
                colorStateListI1I2 = lliI11li2.I1I(i18);
            }
            int i19 = ILL.TextAppearance_android_textColorHint;
            if (lliI11li2.m1829lIlii(i19)) {
                colorStateListI1I3 = lliI11li2.I1I(i19);
            }
            int i20 = ILL.TextAppearance_android_textColorLink;
            if (lliI11li2.m1829lIlii(i20)) {
                colorStateListI1I4 = lliI11li2.I1I(i20);
            } else {
                colorStateListI1I4 = colorStateListI1I;
            }
        } else {
            colorStateListI1I4 = colorStateListI1I;
        }
        int i21 = ILL.TextAppearance_textLocale;
        if (lliI11li2.m1829lIlii(i21)) {
            strLil2 = lliI11li2.Lil(i21);
        }
        if (i8 >= 26) {
            int i22 = ILL.TextAppearance_fontVariationSettings;
            if (lliI11li2.m1829lIlii(i22)) {
                strLil = lliI11li2.Lil(i22);
            }
        }
        if (i8 >= 28) {
            int i23 = ILL.TextAppearance_android_textSize;
            if (lliI11li2.m1829lIlii(i23)) {
                iilll1 = iilll1ILil;
                if (lliI11li2.m1831lLi1LL(i23, -1) == 0) {
                    this.f3808IL1Iii.setTextSize(0, 0.0f);
                }
            } else {
                iilll1 = iilll1ILil;
            }
        } else {
            iilll1 = iilll1ILil;
        }
        LL1IL(context, lliI11li2);
        lliI11li2.m1833lL();
        if (colorStateListI1I2 != null) {
            this.f3808IL1Iii.setTextColor(colorStateListI1I2);
        }
        if (colorStateListI1I3 != null) {
            this.f3808IL1Iii.setHintTextColor(colorStateListI1I3);
        }
        if (colorStateListI1I4 != null) {
            this.f3808IL1Iii.setLinkTextColor(colorStateListI1I4);
        }
        if (!z2 && z) {
            m1808lIlii(zIL1Iii);
        }
        Typeface typeface = this.f1395Ll1;
        if (typeface != null) {
            if (this.ILL == -1) {
                this.f3808IL1Iii.setTypeface(typeface, this.f1400il);
            } else {
                this.f3808IL1Iii.setTypeface(typeface);
            }
        }
        if (strLil != null) {
            this.f3808IL1Iii.setFontVariationSettings(strLil);
        }
        if (strLil2 != null) {
            if (i8 >= 24) {
                this.f3808IL1Iii.setTextLocales(LocaleList.forLanguageTags(strLil2));
            } else if (i8 >= 21) {
                this.f3808IL1Iii.setTextLocale(Locale.forLanguageTag(strLil2.substring(0, strLil2.indexOf(44))));
            }
        }
        this.f1396L11I.iIlLiL(attributeSet, i);
        if (ILil.f4129IL1Iii && this.f1396L11I.m1716ILl() != 0) {
            int[] iArrM1724lIiI = this.f1396L11I.m1724lIiI();
            if (iArrM1724lIiI.length > 0) {
                if (this.f3808IL1Iii.getAutoSizeStepGranularity() != -1.0f) {
                    this.f3808IL1Iii.setAutoSizeTextTypeUniformWithConfiguration(this.f1396L11I.ILL(), this.f1396L11I.m1728il(), this.f1396L11I.m1720Ll1(), 0);
                } else {
                    this.f3808IL1Iii.setAutoSizeTextTypeUniformWithPresetSizes(iArrM1724lIiI, 0);
                }
            }
        }
        llI lliIIlLiL = llI.iIlLiL(context, attributeSet, ILL.AppCompatTextView);
        int iM1822ILl2 = lliIIlLiL.m1822ILl(ILL.AppCompatTextView_drawableLeftCompat, -1);
        iILLL1 iilll2 = iilll1;
        Drawable drawableI1I = iM1822ILl2 != -1 ? iilll2.I1I(context, iM1822ILl2) : null;
        int iM1822ILl3 = lliIIlLiL.m1822ILl(ILL.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableI1I2 = iM1822ILl3 != -1 ? iilll2.I1I(context, iM1822ILl3) : null;
        int iM1822ILl4 = lliIIlLiL.m1822ILl(ILL.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableI1I3 = iM1822ILl4 != -1 ? iilll2.I1I(context, iM1822ILl4) : null;
        int iM1822ILl5 = lliIIlLiL.m1822ILl(ILL.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableI1I4 = iM1822ILl5 != -1 ? iilll2.I1I(context, iM1822ILl5) : null;
        int iM1822ILl6 = lliIIlLiL.m1822ILl(ILL.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableI1I5 = iM1822ILl6 != -1 ? iilll2.I1I(context, iM1822ILl6) : null;
        int iM1822ILl7 = lliIIlLiL.m1822ILl(ILL.AppCompatTextView_drawableEndCompat, -1);
        llliI(drawableI1I, drawableI1I2, drawableI1I3, drawableI1I4, drawableI1I5, iM1822ILl7 != -1 ? iilll2.I1I(context, iM1822ILl7) : null);
        int i24 = ILL.AppCompatTextView_drawableTint;
        if (lliIIlLiL.m1829lIlii(i24)) {
            C0636il.m2230il(this.f3808IL1Iii, lliIIlLiL.I1I(i24));
        }
        int i25 = ILL.AppCompatTextView_drawableTintMode;
        if (lliIIlLiL.m1829lIlii(i25)) {
            i3 = -1;
            C0636il.ILL(this.f3808IL1Iii, llL1ii.Ilil(lliIIlLiL.ILL(i25, -1), null));
        } else {
            i3 = -1;
        }
        int iM1831lLi1LL = lliIIlLiL.m1831lLi1LL(ILL.AppCompatTextView_firstBaselineToTopHeight, i3);
        int iM1831lLi1LL2 = lliIIlLiL.m1831lLi1LL(ILL.AppCompatTextView_lastBaselineToBottomHeight, i3);
        int iM1831lLi1LL3 = lliIIlLiL.m1831lLi1LL(ILL.AppCompatTextView_lineHeight, i3);
        lliIIlLiL.m1833lL();
        if (iM1831lLi1LL != i3) {
            C0636il.m2226lIiI(this.f3808IL1Iii, iM1831lLi1LL);
        }
        if (iM1831lLi1LL2 != i3) {
            C0636il.m2220ILl(this.f3808IL1Iii, iM1831lLi1LL2);
        }
        if (iM1831lLi1LL3 != i3) {
            C0636il.Lil(this.f3808IL1Iii, iM1831lLi1LL3);
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m1807lIII(Typeface typeface) {
        if (this.f1398lIiI) {
            this.f3808IL1Iii.setTypeface(typeface);
            this.f1395Ll1 = typeface;
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m1808lIlii(boolean z) {
        this.f3808IL1Iii.setAllCaps(z);
    }

    public final void llliI(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f3808IL1Iii.getCompoundDrawablesRelative();
            TextView textView = this.f3808IL1Iii;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f3808IL1Iii.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f3808IL1Iii;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f3808IL1Iii.getCompoundDrawables();
        TextView textView3 = this.f3808IL1Iii;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m1809llL1ii(Runnable runnable) {
        this.f3808IL1Iii.post(runnable);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1810lLi1LL() {
        return this.f1396L11I.ILL();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ColorStateList m1811il() {
        C0627LLlI1 c0627LLlI1 = this.f1394IiL;
        if (c0627LLlI1 != null) {
            return c0627LLlI1.f3850IL1Iii;
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1812lL(ColorStateList colorStateList) {
        if (this.f1394IiL == null) {
            this.f1394IiL = new C0627LLlI1();
        }
        C0627LLlI1 c0627LLlI1 = this.f1394IiL;
        c0627LLlI1.f3850IL1Iii = colorStateList;
        c0627LLlI1.f1431IL = colorStateList != null;
        m1813l();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final void m1813l() {
        C0627LLlI1 c0627LLlI1 = this.f1394IiL;
        this.f3809ILil = c0627LLlI1;
        this.f3807I1I = c0627LLlI1;
        this.f1393IL = c0627LLlI1;
        this.f3810Ilil = c0627LLlI1;
        this.f1399lLi1LL = c0627LLlI1;
        this.f1397iILLL1 = c0627LLlI1;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m18141(int i, float f) {
        if (ILil.f4129IL1Iii || m1802Ll1()) {
            return;
        }
        m1804LlLLL(i, f);
    }
}
