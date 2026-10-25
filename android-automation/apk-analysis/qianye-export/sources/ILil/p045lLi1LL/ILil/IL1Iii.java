package ILil.p045lLi1LL.ILil;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.Guideline;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintSet.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static SparseIntArray f4542I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final int[] f4543ILil = {0, 4, 8};

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public HashMap<Integer, ILil> f4544IL1Iii = new HashMap<>();

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class ILil {

        /* JADX INFO: renamed from: I1 */
        public float f19I1;
        public String I11L;
        public float I11li1;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4545I1I;
        public int I1IILIIL;

        /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
        public float f1999I1L11L;

        /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
        public float f2000IIiI;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f4546IL1Iii;
        public int ILL;

        /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
        public boolean f2001ILLIi;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4547ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public int f2002ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4548Ilil;

        /* JADX INFO: renamed from: I丨 */
        public float f20I;

        /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
        public int f2003IIi;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2004IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f2005IiL;

        /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
        public int f2006L11;

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public int f2007L111;
        public boolean L1iI1;
        public float LI11;

        /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
        public float f2008LIl;

        /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
        public int f2009LIll;

        /* JADX INFO: renamed from: LL */
        public int f21LL;
        public int LL1IL;
        public int LLL;
        public boolean LiL1;
        public int Liil1L1l;
        public int Lil;

        /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
        public int f2010LlIl;
        public int LlLI1;

        /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
        public float f2011LlLiLL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public int f2012Ll1;

        /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
        public int f2013L1l;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f2014L11I;

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public int f2015LlLLL;

        /* JADX INFO: renamed from: i1 */
        public float f22i1;

        /* JADX INFO: renamed from: iI */
        public float f23iI;

        /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
        public int f2016iI1iI;
        public int iIi1;
        public float iIilII1;

        /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
        public float f2017iIl1il;
        public int iIlLiL;

        /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
        public String f2018iI1LI;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public float f2019iILLL1;

        /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
        public float f2020iILilI;

        /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
        public float f2021iiIIi11;

        /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
        public float f2022ili11;
        public int ill1LI1l;

        /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
        public int f2023ill;

        /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
        public int[] f2024i1I1I1l;

        /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
        public int f2025l1IIi1;
        public int l1Lll;

        /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
        public int f2026lIIiIlL;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public int f2027lIiI;

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public int f2028lIII;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public int f2029lIlii;

        /* JADX INFO: renamed from: lL */
        public int f24lL;
        public int llI;
        public int llliI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public int f2030llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2031lLi1LL;

        /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
        public float f2032lliiI1;

        /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
        public float f2033li11;

        /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
        public boolean f2034i11i;

        /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
        public int f2035i11LL;

        /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
        public int f2036iILLl;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int f2037il;

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public float f2038lL;

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public int f2039l;

        /* JADX INFO: renamed from: 丨丨 */
        public int f25;

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public int f2040LLlI1;

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public float f20411;

        /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
        public int f2042;

        public ILil() {
            this.f4546IL1Iii = false;
            this.f4548Ilil = -1;
            this.f2031lLi1LL = -1;
            this.f2019iILLL1 = -1.0f;
            this.f2005IiL = -1;
            this.f2014L11I = -1;
            this.f2037il = -1;
            this.ILL = -1;
            this.f2012Ll1 = -1;
            this.f2027lIiI = -1;
            this.f2002ILl = -1;
            this.Lil = -1;
            this.LlLI1 = -1;
            this.f2030llL1ii = -1;
            this.f2029lIlii = -1;
            this.iIi1 = -1;
            this.iIlLiL = -1;
            this.I11li1 = 0.5f;
            this.f2038lL = 0.5f;
            this.I11L = null;
            this.llliI = -1;
            this.f2039l = 0;
            this.f20411 = 0.0f;
            this.f2015LlLLL = -1;
            this.f2028lIII = -1;
            this.LL1IL = -1;
            this.f2007L111 = -1;
            this.f2040LLlI1 = -1;
            this.f25 = -1;
            this.llI = -1;
            this.f2025l1IIi1 = -1;
            this.f2013L1l = -1;
            this.f2036iILLl = 0;
            this.f2003IIi = -1;
            this.f2009LIll = -1;
            this.f2023ill = -1;
            this.f2042 = -1;
            this.f2006L11 = -1;
            this.f2010LlIl = -1;
            this.f2000IIiI = 0.0f;
            this.f2032lliiI1 = 0.0f;
            this.LLL = 0;
            this.f2016iI1iI = 0;
            this.f1999I1L11L = 1.0f;
            this.f2001ILLIi = false;
            this.f2033li11 = 0.0f;
            this.iIilII1 = 0.0f;
            this.f22i1 = 0.0f;
            this.f2022ili11 = 0.0f;
            this.f2008LIl = 1.0f;
            this.f23iI = 1.0f;
            this.f2011LlLiLL = Float.NaN;
            this.f20I = Float.NaN;
            this.f2021iiIIi11 = 0.0f;
            this.f2020iILilI = 0.0f;
            this.f19I1 = 0.0f;
            this.f2034i11i = false;
            this.L1iI1 = false;
            this.f24lL = 0;
            this.l1Lll = 0;
            this.I1IILIIL = -1;
            this.ill1LI1l = -1;
            this.f2026lIIiIlL = -1;
            this.f2035i11LL = -1;
            this.f2017iIl1il = 1.0f;
            this.LI11 = 1.0f;
            this.LiL1 = false;
            this.Liil1L1l = -1;
            this.f21LL = -1;
        }

        public void I1I(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.f2498IL = this.f2005IiL;
            layoutParams.f4934Ilil = this.f2014L11I;
            layoutParams.f2521lLi1LL = this.f2037il;
            layoutParams.f2511iILLL1 = this.ILL;
            layoutParams.f2499IiL = this.f2012Ll1;
            layoutParams.f2508L11I = this.f2027lIiI;
            layoutParams.f2526il = this.f2002ILl;
            layoutParams.ILL = this.Lil;
            layoutParams.f2506Ll1 = this.LlLI1;
            layoutParams.LlLI1 = this.f2030llL1ii;
            layoutParams.f2520llL1ii = this.f2029lIlii;
            layoutParams.f2519lIlii = this.iIi1;
            layoutParams.iIi1 = this.iIlLiL;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f2007L111;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.f2040LLlI1;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.f25;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.llI;
            layoutParams.llliI = this.f2010LlIl;
            layoutParams.f2528l = this.f2006L11;
            layoutParams.f25301 = this.I11li1;
            layoutParams.f2509LlLLL = this.f2038lL;
            layoutParams.f2517lIiI = this.llliI;
            layoutParams.f2496ILl = this.f2039l;
            layoutParams.Lil = this.f20411;
            layoutParams.f2518lIII = this.I11L;
            layoutParams.f2504LlIl = this.f2015LlLLL;
            layoutParams.f2494IIiI = this.f2028lIII;
            layoutParams.f2529LLlI1 = this.f2000IIiI;
            layoutParams.f2501L111 = this.f2032lliiI1;
            layoutParams.llI = this.f2016iI1iI;
            layoutParams.f40 = this.LLL;
            layoutParams.LLL = this.f2034i11i;
            layoutParams.f2510iI1iI = this.L1iI1;
            layoutParams.f2516l1IIi1 = this.f24lL;
            layoutParams.f2507L1l = this.l1Lll;
            layoutParams.f2503LIll = this.I1IILIIL;
            layoutParams.f2515ill = this.ill1LI1l;
            layoutParams.f2525iILLl = this.f2026lIIiIlL;
            layoutParams.f2497IIi = this.f2035i11LL;
            layoutParams.f2531 = this.f2017iIl1il;
            layoutParams.f2500L11 = this.LI11;
            layoutParams.f2522lliiI1 = this.LL1IL;
            layoutParams.f4931I1I = this.f2019iILLL1;
            layoutParams.f4932IL1Iii = this.f4548Ilil;
            layoutParams.f4933ILil = this.f2031lLi1LL;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = this.f4547ILil;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.f4545I1I;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.f2013L1l);
                layoutParams.setMarginEnd(this.f2025l1IIi1);
            }
            layoutParams.IL1Iii();
        }

        public final void Ilil(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f2004IL = i;
            this.f2005IiL = layoutParams.f2498IL;
            this.f2014L11I = layoutParams.f4934Ilil;
            this.f2037il = layoutParams.f2521lLi1LL;
            this.ILL = layoutParams.f2511iILLL1;
            this.f2012Ll1 = layoutParams.f2499IiL;
            this.f2027lIiI = layoutParams.f2508L11I;
            this.f2002ILl = layoutParams.f2526il;
            this.Lil = layoutParams.ILL;
            this.LlLI1 = layoutParams.f2506Ll1;
            this.f2030llL1ii = layoutParams.LlLI1;
            this.f2029lIlii = layoutParams.f2520llL1ii;
            this.iIi1 = layoutParams.f2519lIlii;
            this.iIlLiL = layoutParams.iIi1;
            this.I11li1 = layoutParams.f25301;
            this.f2038lL = layoutParams.f2509LlLLL;
            this.I11L = layoutParams.f2518lIII;
            this.llliI = layoutParams.f2517lIiI;
            this.f2039l = layoutParams.f2496ILl;
            this.f20411 = layoutParams.Lil;
            this.f2015LlLLL = layoutParams.f2504LlIl;
            this.f2028lIII = layoutParams.f2494IIiI;
            this.LL1IL = layoutParams.f2522lliiI1;
            this.f2019iILLL1 = layoutParams.f4931I1I;
            this.f4548Ilil = layoutParams.f4932IL1Iii;
            this.f2031lLi1LL = layoutParams.f4933ILil;
            this.f4547ILil = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            this.f4545I1I = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            this.f2007L111 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            this.f2040LLlI1 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            this.f25 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            this.llI = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            this.f2000IIiI = layoutParams.f2529LLlI1;
            this.f2032lliiI1 = layoutParams.f2501L111;
            this.f2016iI1iI = layoutParams.llI;
            this.LLL = layoutParams.f40;
            boolean z = layoutParams.LLL;
            this.f2034i11i = z;
            this.L1iI1 = layoutParams.f2510iI1iI;
            this.f24lL = layoutParams.f2516l1IIi1;
            this.l1Lll = layoutParams.f2507L1l;
            this.f2034i11i = z;
            this.I1IILIIL = layoutParams.f2503LIll;
            this.ill1LI1l = layoutParams.f2515ill;
            this.f2026lIIiIlL = layoutParams.f2525iILLl;
            this.f2035i11LL = layoutParams.f2497IIi;
            this.f2017iIl1il = layoutParams.f2531;
            this.LI11 = layoutParams.f2500L11;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f2025l1IIi1 = layoutParams.getMarginEnd();
                this.f2013L1l = layoutParams.getMarginStart();
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public ILil clone() {
            ILil iLil = new ILil();
            iLil.f4546IL1Iii = this.f4546IL1Iii;
            iLil.f4547ILil = this.f4547ILil;
            iLil.f4545I1I = this.f4545I1I;
            iLil.f4548Ilil = this.f4548Ilil;
            iLil.f2031lLi1LL = this.f2031lLi1LL;
            iLil.f2019iILLL1 = this.f2019iILLL1;
            iLil.f2005IiL = this.f2005IiL;
            iLil.f2014L11I = this.f2014L11I;
            iLil.f2037il = this.f2037il;
            iLil.ILL = this.ILL;
            iLil.f2012Ll1 = this.f2012Ll1;
            iLil.f2027lIiI = this.f2027lIiI;
            iLil.f2002ILl = this.f2002ILl;
            iLil.Lil = this.Lil;
            iLil.LlLI1 = this.LlLI1;
            iLil.f2030llL1ii = this.f2030llL1ii;
            iLil.f2029lIlii = this.f2029lIlii;
            iLil.iIi1 = this.iIi1;
            iLil.iIlLiL = this.iIlLiL;
            iLil.I11li1 = this.I11li1;
            iLil.f2038lL = this.f2038lL;
            iLil.I11L = this.I11L;
            iLil.f2015LlLLL = this.f2015LlLLL;
            iLil.f2028lIII = this.f2028lIII;
            iLil.I11li1 = this.I11li1;
            iLil.I11li1 = this.I11li1;
            iLil.I11li1 = this.I11li1;
            iLil.I11li1 = this.I11li1;
            iLil.I11li1 = this.I11li1;
            iLil.LL1IL = this.LL1IL;
            iLil.f2007L111 = this.f2007L111;
            iLil.f2040LLlI1 = this.f2040LLlI1;
            iLil.f25 = this.f25;
            iLil.llI = this.llI;
            iLil.f2025l1IIi1 = this.f2025l1IIi1;
            iLil.f2013L1l = this.f2013L1l;
            iLil.f2036iILLl = this.f2036iILLl;
            iLil.f2003IIi = this.f2003IIi;
            iLil.f2009LIll = this.f2009LIll;
            iLil.f2023ill = this.f2023ill;
            iLil.f2042 = this.f2042;
            iLil.f2006L11 = this.f2006L11;
            iLil.f2010LlIl = this.f2010LlIl;
            iLil.f2000IIiI = this.f2000IIiI;
            iLil.f2032lliiI1 = this.f2032lliiI1;
            iLil.LLL = this.LLL;
            iLil.f2016iI1iI = this.f2016iI1iI;
            iLil.f1999I1L11L = this.f1999I1L11L;
            iLil.f2001ILLIi = this.f2001ILLIi;
            iLil.f2033li11 = this.f2033li11;
            iLil.iIilII1 = this.iIilII1;
            iLil.f22i1 = this.f22i1;
            iLil.f2022ili11 = this.f2022ili11;
            iLil.f2008LIl = this.f2008LIl;
            iLil.f23iI = this.f23iI;
            iLil.f2011LlLiLL = this.f2011LlLiLL;
            iLil.f20I = this.f20I;
            iLil.f2021iiIIi11 = this.f2021iiIIi11;
            iLil.f2020iILilI = this.f2020iILilI;
            iLil.f19I1 = this.f19I1;
            iLil.f2034i11i = this.f2034i11i;
            iLil.L1iI1 = this.L1iI1;
            iLil.f24lL = this.f24lL;
            iLil.l1Lll = this.l1Lll;
            iLil.I1IILIIL = this.I1IILIIL;
            iLil.ill1LI1l = this.ill1LI1l;
            iLil.f2026lIIiIlL = this.f2026lIIiIlL;
            iLil.f2035i11LL = this.f2035i11LL;
            iLil.f2017iIl1il = this.f2017iIl1il;
            iLil.LI11 = this.LI11;
            iLil.Liil1L1l = this.Liil1L1l;
            iLil.f21LL = this.f21LL;
            int[] iArr = this.f2024i1I1I1l;
            if (iArr != null) {
                iLil.f2024i1I1I1l = Arrays.copyOf(iArr, iArr.length);
            }
            iLil.llliI = this.llliI;
            iLil.f2039l = this.f2039l;
            iLil.f20411 = this.f20411;
            iLil.LiL1 = this.LiL1;
            return iLil;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final void m2729iILLL1(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            m2730lLi1LL(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.f21LL = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.Liil1L1l = barrier.getType();
                this.f2024i1I1I1l = barrier.getReferencedIds();
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final void m2730lLi1LL(int i, Constraints.LayoutParams layoutParams) {
            Ilil(i, layoutParams);
            this.f1999I1L11L = layoutParams.ill1LI1l;
            this.iIilII1 = layoutParams.f2532iIl1il;
            this.f22i1 = layoutParams.LI11;
            this.f2022ili11 = layoutParams.LiL1;
            this.f2008LIl = layoutParams.Liil1L1l;
            this.f23iI = layoutParams.f41LL;
            this.f2011LlLiLL = layoutParams.f2534i1I1I1l;
            this.f20I = layoutParams.f2533iI1LI;
            this.f2021iiIIi11 = layoutParams.f421;
            this.f2020iILilI = layoutParams.f2535iILiiLl;
            this.f19I1 = layoutParams.ILI1Ll;
            this.f2033li11 = layoutParams.f2537i11LL;
            this.f2001ILLIi = layoutParams.f2536lIIiIlL;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4542I1I = sparseIntArray;
        sparseIntArray.append(I1I.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f4542I1I.append(I1I.ConstraintSet_layout_editor_absoluteX, 6);
        f4542I1I.append(I1I.ConstraintSet_layout_editor_absoluteY, 7);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintGuide_begin, 17);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintGuide_end, 18);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintGuide_percent, 19);
        f4542I1I.append(I1I.ConstraintSet_android_orientation, 27);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f4542I1I.append(I1I.ConstraintSet_layout_goneMarginLeft, 13);
        f4542I1I.append(I1I.ConstraintSet_layout_goneMarginTop, 16);
        f4542I1I.append(I1I.ConstraintSet_layout_goneMarginRight, 14);
        f4542I1I.append(I1I.ConstraintSet_layout_goneMarginBottom, 11);
        f4542I1I.append(I1I.ConstraintSet_layout_goneMarginStart, 15);
        f4542I1I.append(I1I.ConstraintSet_layout_goneMarginEnd, 12);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintVertical_weight, 40);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintVertical_bias, 37);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintDimensionRatio, 5);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintLeft_creator, 75);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintTop_creator, 75);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintRight_creator, 75);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintBottom_creator, 75);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintBaseline_creator, 75);
        f4542I1I.append(I1I.ConstraintSet_android_layout_marginLeft, 24);
        f4542I1I.append(I1I.ConstraintSet_android_layout_marginRight, 28);
        f4542I1I.append(I1I.ConstraintSet_android_layout_marginStart, 31);
        f4542I1I.append(I1I.ConstraintSet_android_layout_marginEnd, 8);
        f4542I1I.append(I1I.ConstraintSet_android_layout_marginTop, 34);
        f4542I1I.append(I1I.ConstraintSet_android_layout_marginBottom, 2);
        f4542I1I.append(I1I.ConstraintSet_android_layout_width, 23);
        f4542I1I.append(I1I.ConstraintSet_android_layout_height, 21);
        f4542I1I.append(I1I.ConstraintSet_android_visibility, 22);
        f4542I1I.append(I1I.ConstraintSet_android_alpha, 43);
        f4542I1I.append(I1I.ConstraintSet_android_elevation, 44);
        f4542I1I.append(I1I.ConstraintSet_android_rotationX, 45);
        f4542I1I.append(I1I.ConstraintSet_android_rotationY, 46);
        f4542I1I.append(I1I.ConstraintSet_android_rotation, 60);
        f4542I1I.append(I1I.ConstraintSet_android_scaleX, 47);
        f4542I1I.append(I1I.ConstraintSet_android_scaleY, 48);
        f4542I1I.append(I1I.ConstraintSet_android_transformPivotX, 49);
        f4542I1I.append(I1I.ConstraintSet_android_transformPivotY, 50);
        f4542I1I.append(I1I.ConstraintSet_android_translationX, 51);
        f4542I1I.append(I1I.ConstraintSet_android_translationY, 52);
        f4542I1I.append(I1I.ConstraintSet_android_translationZ, 53);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintWidth_default, 54);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHeight_default, 55);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintWidth_max, 56);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHeight_max, 57);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintWidth_min, 58);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHeight_min, 59);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintCircle, 61);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintCircleRadius, 62);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintCircleAngle, 63);
        f4542I1I.append(I1I.ConstraintSet_android_id, 38);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintWidth_percent, 69);
        f4542I1I.append(I1I.ConstraintSet_layout_constraintHeight_percent, 70);
        f4542I1I.append(I1I.ConstraintSet_chainUseRtl, 71);
        f4542I1I.append(I1I.ConstraintSet_barrierDirection, 72);
        f4542I1I.append(I1I.ConstraintSet_constraint_referenced_ids, 73);
        f4542I1I.append(I1I.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m2725lLi1LL(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public final int[] I1I(View view, String str) {
        int iIntValue;
        Object objI1I;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            try {
                iIntValue = ILil.p045lLi1LL.ILil.ILil.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objI1I = ((ConstraintLayout) view.getParent()).I1I(0, strTrim)) != null && (objI1I instanceof Integer)) {
                iIntValue = ((Integer) objI1I).intValue();
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public void IL1Iii(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f4544IL1Iii.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f4544IL1Iii.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                ILil iLil = this.f4544IL1Iii.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    iLil.f21LL = 1;
                }
                int i2 = iLil.f21LL;
                if (i2 != -1 && i2 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(iLil.Liil1L1l);
                    barrier.setAllowsGoneWidget(iLil.LiL1);
                    int[] iArr = iLil.f2024i1I1I1l;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str = iLil.f2018iI1LI;
                        if (str != null) {
                            int[] iArrI1I = I1I(barrier, str);
                            iLil.f2024i1I1I1l = iArrI1I;
                            barrier.setReferencedIds(iArrI1I);
                        }
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                iLil.I1I(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(iLil.f2036iILLl);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 17) {
                    childAt.setAlpha(iLil.f1999I1L11L);
                    childAt.setRotation(iLil.iIilII1);
                    childAt.setRotationX(iLil.f22i1);
                    childAt.setRotationY(iLil.f2022ili11);
                    childAt.setScaleX(iLil.f2008LIl);
                    childAt.setScaleY(iLil.f23iI);
                    if (!Float.isNaN(iLil.f2011LlLiLL)) {
                        childAt.setPivotX(iLil.f2011LlLiLL);
                    }
                    if (!Float.isNaN(iLil.f20I)) {
                        childAt.setPivotY(iLil.f20I);
                    }
                    childAt.setTranslationX(iLil.f2021iiIIi11);
                    childAt.setTranslationY(iLil.f2020iILilI);
                    if (i3 >= 21) {
                        childAt.setTranslationZ(iLil.f19I1);
                        if (iLil.f2001ILLIi) {
                            childAt.setElevation(iLil.f2033li11);
                        }
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            ILil iLil2 = this.f4544IL1Iii.get(num);
            int i4 = iLil2.f21LL;
            if (i4 != -1 && i4 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = iLil2.f2024i1I1I1l;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = iLil2.f2018iI1LI;
                    if (str2 != null) {
                        int[] iArrI1I2 = I1I(barrier2, str2);
                        iLil2.f2024i1I1I1l = iArrI1I2;
                        barrier2.setReferencedIds(iArrI1I2);
                    }
                }
                barrier2.setType(iLil2.Liil1L1l);
                ConstraintLayout.LayoutParams layoutParamsIL1Iii = constraintLayout.generateDefaultLayoutParams();
                barrier2.m3136lLi1LL();
                iLil2.I1I(layoutParamsIL1Iii);
                constraintLayout.addView(barrier2, layoutParamsIL1Iii);
            }
            if (iLil2.f4546IL1Iii) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams layoutParamsIL1Iii2 = constraintLayout.generateDefaultLayoutParams();
                iLil2.I1I(layoutParamsIL1Iii2);
                constraintLayout.addView(guideline, layoutParamsIL1Iii2);
            }
        }
    }

    public void ILil(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f4544IL1Iii.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4544IL1Iii.containsKey(Integer.valueOf(id))) {
                this.f4544IL1Iii.put(Integer.valueOf(id), new ILil());
            }
            ILil iLil = this.f4544IL1Iii.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                iLil.m2729iILLL1((ConstraintHelper) childAt, id, layoutParams);
            }
            iLil.m2730lLi1LL(id, layoutParams);
        }
    }

    public void Ilil(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    ILil iLilM2726IL = m2726IL(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        iLilM2726IL.f4546IL1Iii = true;
                    }
                    this.f4544IL1Iii.put(Integer.valueOf(iLilM2726IL.f2004IL), iLilM2726IL);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final ILil m2726IL(Context context, AttributeSet attributeSet) {
        ILil iLil = new ILil();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I1I.ConstraintSet);
        m2727iILLL1(iLil, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return iLil;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2727iILLL1(ILil iLil, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f4542I1I.get(index);
            switch (i2) {
                case 1:
                    iLil.LlLI1 = m2725lLi1LL(typedArray, index, iLil.LlLI1);
                    break;
                case 2:
                    iLil.llI = typedArray.getDimensionPixelSize(index, iLil.llI);
                    break;
                case 3:
                    iLil.Lil = m2725lLi1LL(typedArray, index, iLil.Lil);
                    break;
                case 4:
                    iLil.f2002ILl = m2725lLi1LL(typedArray, index, iLil.f2002ILl);
                    break;
                case 5:
                    iLil.I11L = typedArray.getString(index);
                    break;
                case 6:
                    iLil.f2015LlLLL = typedArray.getDimensionPixelOffset(index, iLil.f2015LlLLL);
                    break;
                case 7:
                    iLil.f2028lIII = typedArray.getDimensionPixelOffset(index, iLil.f2028lIII);
                    break;
                case 8:
                    iLil.f2025l1IIi1 = typedArray.getDimensionPixelSize(index, iLil.f2025l1IIi1);
                    break;
                case 9:
                    iLil.iIlLiL = m2725lLi1LL(typedArray, index, iLil.iIlLiL);
                    break;
                case 10:
                    iLil.iIi1 = m2725lLi1LL(typedArray, index, iLil.iIi1);
                    break;
                case 11:
                    iLil.f2042 = typedArray.getDimensionPixelSize(index, iLil.f2042);
                    break;
                case 12:
                    iLil.f2006L11 = typedArray.getDimensionPixelSize(index, iLil.f2006L11);
                    break;
                case 13:
                    iLil.f2003IIi = typedArray.getDimensionPixelSize(index, iLil.f2003IIi);
                    break;
                case 14:
                    iLil.f2023ill = typedArray.getDimensionPixelSize(index, iLil.f2023ill);
                    break;
                case 15:
                    iLil.f2010LlIl = typedArray.getDimensionPixelSize(index, iLil.f2010LlIl);
                    break;
                case 16:
                    iLil.f2009LIll = typedArray.getDimensionPixelSize(index, iLil.f2009LIll);
                    break;
                case 17:
                    iLil.f4548Ilil = typedArray.getDimensionPixelOffset(index, iLil.f4548Ilil);
                    break;
                case 18:
                    iLil.f2031lLi1LL = typedArray.getDimensionPixelOffset(index, iLil.f2031lLi1LL);
                    break;
                case 19:
                    iLil.f2019iILLL1 = typedArray.getFloat(index, iLil.f2019iILLL1);
                    break;
                case 20:
                    iLil.I11li1 = typedArray.getFloat(index, iLil.I11li1);
                    break;
                case 21:
                    iLil.f4545I1I = typedArray.getLayoutDimension(index, iLil.f4545I1I);
                    break;
                case 22:
                    int i3 = typedArray.getInt(index, iLil.f2036iILLl);
                    iLil.f2036iILLl = i3;
                    iLil.f2036iILLl = f4543ILil[i3];
                    break;
                case 23:
                    iLil.f4547ILil = typedArray.getLayoutDimension(index, iLil.f4547ILil);
                    break;
                case 24:
                    iLil.f2007L111 = typedArray.getDimensionPixelSize(index, iLil.f2007L111);
                    break;
                case 25:
                    iLil.f2005IiL = m2725lLi1LL(typedArray, index, iLil.f2005IiL);
                    break;
                case 26:
                    iLil.f2014L11I = m2725lLi1LL(typedArray, index, iLil.f2014L11I);
                    break;
                case 27:
                    iLil.LL1IL = typedArray.getInt(index, iLil.LL1IL);
                    break;
                case 28:
                    iLil.f2040LLlI1 = typedArray.getDimensionPixelSize(index, iLil.f2040LLlI1);
                    break;
                case 29:
                    iLil.f2037il = m2725lLi1LL(typedArray, index, iLil.f2037il);
                    break;
                case 30:
                    iLil.ILL = m2725lLi1LL(typedArray, index, iLil.ILL);
                    break;
                case 31:
                    iLil.f2013L1l = typedArray.getDimensionPixelSize(index, iLil.f2013L1l);
                    break;
                case 32:
                    iLil.f2030llL1ii = m2725lLi1LL(typedArray, index, iLil.f2030llL1ii);
                    break;
                case 33:
                    iLil.f2029lIlii = m2725lLi1LL(typedArray, index, iLil.f2029lIlii);
                    break;
                case 34:
                    iLil.f25 = typedArray.getDimensionPixelSize(index, iLil.f25);
                    break;
                case 35:
                    iLil.f2027lIiI = m2725lLi1LL(typedArray, index, iLil.f2027lIiI);
                    break;
                case 36:
                    iLil.f2012Ll1 = m2725lLi1LL(typedArray, index, iLil.f2012Ll1);
                    break;
                case 37:
                    iLil.f2038lL = typedArray.getFloat(index, iLil.f2038lL);
                    break;
                case 38:
                    iLil.f2004IL = typedArray.getResourceId(index, iLil.f2004IL);
                    break;
                case 39:
                    iLil.f2032lliiI1 = typedArray.getFloat(index, iLil.f2032lliiI1);
                    break;
                case 40:
                    iLil.f2000IIiI = typedArray.getFloat(index, iLil.f2000IIiI);
                    break;
                case 41:
                    iLil.LLL = typedArray.getInt(index, iLil.LLL);
                    break;
                case 42:
                    iLil.f2016iI1iI = typedArray.getInt(index, iLil.f2016iI1iI);
                    break;
                case 43:
                    iLil.f1999I1L11L = typedArray.getFloat(index, iLil.f1999I1L11L);
                    break;
                case 44:
                    iLil.f2001ILLIi = true;
                    iLil.f2033li11 = typedArray.getDimension(index, iLil.f2033li11);
                    break;
                case 45:
                    iLil.f22i1 = typedArray.getFloat(index, iLil.f22i1);
                    break;
                case 46:
                    iLil.f2022ili11 = typedArray.getFloat(index, iLil.f2022ili11);
                    break;
                case 47:
                    iLil.f2008LIl = typedArray.getFloat(index, iLil.f2008LIl);
                    break;
                case 48:
                    iLil.f23iI = typedArray.getFloat(index, iLil.f23iI);
                    break;
                case 49:
                    iLil.f2011LlLiLL = typedArray.getFloat(index, iLil.f2011LlLiLL);
                    break;
                case 50:
                    iLil.f20I = typedArray.getFloat(index, iLil.f20I);
                    break;
                case 51:
                    iLil.f2021iiIIi11 = typedArray.getDimension(index, iLil.f2021iiIIi11);
                    break;
                case 52:
                    iLil.f2020iILilI = typedArray.getDimension(index, iLil.f2020iILilI);
                    break;
                case 53:
                    iLil.f19I1 = typedArray.getDimension(index, iLil.f19I1);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            iLil.iIilII1 = typedArray.getFloat(index, iLil.iIilII1);
                            break;
                        case 61:
                            iLil.llliI = m2725lLi1LL(typedArray, index, iLil.llliI);
                            break;
                        case 62:
                            iLil.f2039l = typedArray.getDimensionPixelSize(index, iLil.f2039l);
                            break;
                        case 63:
                            iLil.f20411 = typedArray.getFloat(index, iLil.f20411);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    iLil.f2017iIl1il = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    iLil.LI11 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    iLil.Liil1L1l = typedArray.getInt(index, iLil.Liil1L1l);
                                    break;
                                case 73:
                                    iLil.f2018iI1LI = typedArray.getString(index);
                                    break;
                                case 74:
                                    iLil.LiL1 = typedArray.getBoolean(index, iLil.LiL1);
                                    break;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4542I1I.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f4542I1I.get(index));
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
    }
}
