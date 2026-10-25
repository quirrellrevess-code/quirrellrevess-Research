package ILil.p028IiL.p031Ll1;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: PrecomputedTextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I implements Spannable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final IL1Iii f4140I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Spannable f4141ILil;

    public IL1Iii IL1Iii() {
        return this.f4140I1I;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f4141ILil.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f4141ILil.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f4141ILil.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f4141ILil.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.f4141ILil.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f4141ILil.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f4141ILil.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        this.f4141ILil.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        this.f4141ILil.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f4141ILil.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f4141ILil.toString();
    }

    /* JADX INFO: compiled from: PrecomputedTextCompat.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4142I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final TextPaint f4143IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final TextDirectionHeuristic f4144ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final PrecomputedText.Params f4145Ilil = null;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final int f1697IL;

        /* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.I1I$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PrecomputedTextCompat.java */
        public static class C0569IL1Iii {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public int f4146I1I;

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public final TextPaint f4147IL1Iii;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public TextDirectionHeuristic f4148ILil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public int f1698IL;

            public C0569IL1Iii(TextPaint textPaint) {
                this.f4147IL1Iii = textPaint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.f4146I1I = 1;
                    this.f1698IL = 1;
                } else {
                    this.f1698IL = 0;
                    this.f4146I1I = 0;
                }
                if (i >= 18) {
                    this.f4148ILil = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f4148ILil = null;
                }
            }

            public C0569IL1Iii I1I(int i) {
                this.f1698IL = i;
                return this;
            }

            public IL1Iii IL1Iii() {
                return new IL1Iii(this.f4147IL1Iii, this.f4148ILil, this.f4146I1I, this.f1698IL);
            }

            public C0569IL1Iii ILil(int i) {
                this.f4146I1I = i;
                return this;
            }

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public C0569IL1Iii m2234IL(TextDirectionHeuristic textDirectionHeuristic) {
                this.f4148ILil = textDirectionHeuristic;
                return this;
            }
        }

        public IL1Iii(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.f4143IL1Iii = textPaint;
            this.f4144ILil = textDirectionHeuristic;
            this.f4142I1I = i;
            this.f1697IL = i2;
        }

        public int I1I() {
            return this.f1697IL;
        }

        public boolean IL1Iii(IL1Iii iL1Iii) {
            PrecomputedText.Params params = this.f4145Ilil;
            if (params != null) {
                return params.equals(iL1Iii.f4145Ilil);
            }
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.f4142I1I != iL1Iii.ILil() || this.f1697IL != iL1Iii.I1I())) || this.f4143IL1Iii.getTextSize() != iL1Iii.Ilil().getTextSize() || this.f4143IL1Iii.getTextScaleX() != iL1Iii.Ilil().getTextScaleX() || this.f4143IL1Iii.getTextSkewX() != iL1Iii.Ilil().getTextSkewX()) {
                return false;
            }
            if ((i >= 21 && (this.f4143IL1Iii.getLetterSpacing() != iL1Iii.Ilil().getLetterSpacing() || !TextUtils.equals(this.f4143IL1Iii.getFontFeatureSettings(), iL1Iii.Ilil().getFontFeatureSettings()))) || this.f4143IL1Iii.getFlags() != iL1Iii.Ilil().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.f4143IL1Iii.getTextLocales().equals(iL1Iii.Ilil().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f4143IL1Iii.getTextLocale().equals(iL1Iii.Ilil().getTextLocale())) {
                return false;
            }
            if (this.f4143IL1Iii.getTypeface() == null) {
                return iL1Iii.Ilil().getTypeface() == null;
            }
            return this.f4143IL1Iii.getTypeface().equals(iL1Iii.Ilil().getTypeface());
        }

        public int ILil() {
            return this.f4142I1I;
        }

        public TextPaint Ilil() {
            return this.f4143IL1Iii;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public TextDirectionHeuristic m2233IL() {
            return this.f4144ILil;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IL1Iii)) {
                return false;
            }
            IL1Iii iL1Iii = (IL1Iii) obj;
            if (IL1Iii(iL1Iii)) {
                return Build.VERSION.SDK_INT < 18 || this.f4144ILil == iL1Iii.m2233IL();
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return ILil.p028IiL.p034lIiI.I1I.ILil(Float.valueOf(this.f4143IL1Iii.getTextSize()), Float.valueOf(this.f4143IL1Iii.getTextScaleX()), Float.valueOf(this.f4143IL1Iii.getTextSkewX()), Float.valueOf(this.f4143IL1Iii.getLetterSpacing()), Integer.valueOf(this.f4143IL1Iii.getFlags()), this.f4143IL1Iii.getTextLocales(), this.f4143IL1Iii.getTypeface(), Boolean.valueOf(this.f4143IL1Iii.isElegantTextHeight()), this.f4144ILil, Integer.valueOf(this.f4142I1I), Integer.valueOf(this.f1697IL));
            }
            if (i >= 21) {
                return ILil.p028IiL.p034lIiI.I1I.ILil(Float.valueOf(this.f4143IL1Iii.getTextSize()), Float.valueOf(this.f4143IL1Iii.getTextScaleX()), Float.valueOf(this.f4143IL1Iii.getTextSkewX()), Float.valueOf(this.f4143IL1Iii.getLetterSpacing()), Integer.valueOf(this.f4143IL1Iii.getFlags()), this.f4143IL1Iii.getTextLocale(), this.f4143IL1Iii.getTypeface(), Boolean.valueOf(this.f4143IL1Iii.isElegantTextHeight()), this.f4144ILil, Integer.valueOf(this.f4142I1I), Integer.valueOf(this.f1697IL));
            }
            if (i >= 18) {
                return ILil.p028IiL.p034lIiI.I1I.ILil(Float.valueOf(this.f4143IL1Iii.getTextSize()), Float.valueOf(this.f4143IL1Iii.getTextScaleX()), Float.valueOf(this.f4143IL1Iii.getTextSkewX()), Integer.valueOf(this.f4143IL1Iii.getFlags()), this.f4143IL1Iii.getTextLocale(), this.f4143IL1Iii.getTypeface(), this.f4144ILil, Integer.valueOf(this.f4142I1I), Integer.valueOf(this.f1697IL));
            }
            return i >= 17 ? ILil.p028IiL.p034lIiI.I1I.ILil(Float.valueOf(this.f4143IL1Iii.getTextSize()), Float.valueOf(this.f4143IL1Iii.getTextScaleX()), Float.valueOf(this.f4143IL1Iii.getTextSkewX()), Integer.valueOf(this.f4143IL1Iii.getFlags()), this.f4143IL1Iii.getTextLocale(), this.f4143IL1Iii.getTypeface(), this.f4144ILil, Integer.valueOf(this.f4142I1I), Integer.valueOf(this.f1697IL)) : ILil.p028IiL.p034lIiI.I1I.ILil(Float.valueOf(this.f4143IL1Iii.getTextSize()), Float.valueOf(this.f4143IL1Iii.getTextScaleX()), Float.valueOf(this.f4143IL1Iii.getTextSkewX()), Integer.valueOf(this.f4143IL1Iii.getFlags()), this.f4143IL1Iii.getTypeface(), this.f4144ILil, Integer.valueOf(this.f4142I1I), Integer.valueOf(this.f1697IL));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f4143IL1Iii.getTextSize());
            sb.append(", textScaleX=" + this.f4143IL1Iii.getTextScaleX());
            sb.append(", textSkewX=" + this.f4143IL1Iii.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                sb.append(", letterSpacing=" + this.f4143IL1Iii.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f4143IL1Iii.isElegantTextHeight());
            }
            if (i >= 24) {
                sb.append(", textLocale=" + this.f4143IL1Iii.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f4143IL1Iii.getTextLocale());
            }
            sb.append(", typeface=" + this.f4143IL1Iii.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.f4143IL1Iii.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f4144ILil);
            sb.append(", breakStrategy=" + this.f4142I1I);
            sb.append(", hyphenationFrequency=" + this.f1697IL);
            sb.append("}");
            return sb.toString();
        }

        public IL1Iii(PrecomputedText.Params params) {
            this.f4143IL1Iii = params.getTextPaint();
            this.f4144ILil = params.getTextDirection();
            this.f4142I1I = params.getBreakStrategy();
            this.f1697IL = params.getHyphenationFrequency();
        }
    }
}
