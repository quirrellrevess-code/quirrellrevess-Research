package androidx.viewpager.widget;

import ILil.p028IiL.p029ILl.C0633lIII;
import ILil.p028IiL.p029ILl.LlLI1;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.opencv.calib3d.Calib3d;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public boolean I11L;
    public boolean I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final ArrayList<iILLL1> f5219I1I;

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public InterfaceC0668il f2803I1L11L;

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public boolean f2804IIiI;
    public Scroller ILL;

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public InterfaceC0668il f2805ILLIi;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5220ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f2806ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Rect f5221Ilil;

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public int f2807IIi;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final iILLL1 f2808IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2809IiL;

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public EdgeEffect f2810L11;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public float f2811L111;

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public ArrayList<View> f2812LIl;

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public int f2813LIll;
    public int LL1IL;
    public int LLL;
    public Drawable Lil;

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public EdgeEffect f2814LlIl;
    public int LlLI1;

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public int f2815LlLiLL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f2816Ll1;

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public VelocityTracker f2817L1l;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Parcelable f2818L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public int f2819LlLLL;

    /* JADX INFO: renamed from: i1 */
    public int f47i1;

    /* JADX INFO: renamed from: iI */
    public final Runnable f48iI;

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public List<InterfaceC0668il> f2820iI1iI;
    public float iIi1;
    public ILL iIilII1;
    public int iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2821iILLL1;

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public int f2822ili11;

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public int f2823ill;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public int f2824l1IIi1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public Ll1 f2825lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public int f2826lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public float f2827lIlii;
    public float llI;
    public int llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f2828llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil.iIlLiL.IL1Iii.IL1Iii f2829lLi1LL;

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public boolean f2830lliiI1;

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public List<L11I> f2831li11;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public int f2832iILLl;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ClassLoader f2833il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f2834lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public boolean f2835l;

    /* JADX INFO: renamed from: 丨丨 */
    public float f49;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public float f2836LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean f28371;

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public boolean f2838;

    /* JADX INFO: renamed from: I丨 */
    public static final int[] f46I = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public static final Comparator<iILLL1> f2802iiIIi11 = new IL1Iii();

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public static final Interpolator f2801iILilI = new ILil();

    /* JADX INFO: renamed from: I1 */
    public static final lIiI f45I1 = new lIiI();

    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.m3413LLlI1();
        }
    }

    public static class IL1Iii implements Comparator<iILLL1> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compare(iILLL1 iilll1, iILLL1 iilll2) {
            return iilll1.f5235ILil - iilll2.f5235ILil;
        }
    }

    public interface ILL {
        void IL1Iii(View view, float f);
    }

    public static class ILil implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$I丨L, reason: invalid class name */
    public class IL implements LlLI1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Rect f5223IL1Iii = new Rect();

        public IL() {
        }

        @Override // ILil.p028IiL.p029ILl.LlLI1
        public C0633lIII onApplyWindowInsets(View view, C0633lIII c0633lIII) {
            C0633lIII c0633lIIIM2127li11 = iIlLiL.m2127li11(view, c0633lIII);
            if (c0633lIIIM2127li11.m2156iILLL1()) {
                return c0633lIIIM2127li11;
            }
            Rect rect = this.f5223IL1Iii;
            rect.left = c0633lIIIM2127li11.I1I();
            rect.top = c0633lIIIM2127li11.Ilil();
            rect.right = c0633lIIIM2127li11.m2154IL();
            rect.bottom = c0633lIIIM2127li11.ILil();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                C0633lIII c0633lIIIM2112iILLL1 = iIlLiL.m2112iILLL1(ViewPager.this.getChildAt(i), c0633lIIIM2127li11);
                rect.left = Math.min(c0633lIIIM2112iILLL1.I1I(), rect.left);
                rect.top = Math.min(c0633lIIIM2112iILLL1.Ilil(), rect.top);
                rect.right = Math.min(c0633lIIIM2112iILLL1.m2154IL(), rect.right);
                rect.bottom = Math.min(c0633lIIIM2112iILLL1.ILil(), rect.bottom);
            }
            return c0633lIIIM2127li11.m2155IiL(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$I丨iL, reason: invalid class name */
    public class IiL extends ILil.p028IiL.p029ILl.IL1Iii {
        public IiL() {
        }

        public final boolean IL1Iii() {
            ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii = ViewPager.this.f2829lLi1LL;
            return iL1Iii != null && iL1Iii.Ilil() > 1;
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(IL1Iii());
            if (accessibilityEvent.getEventType() != 4096 || (iL1Iii = ViewPager.this.f2829lLi1LL) == null) {
                return;
            }
            accessibilityEvent.setItemCount(iL1Iii.Ilil());
            accessibilityEvent.setFromIndex(ViewPager.this.f2821iILLL1);
            accessibilityEvent.setToIndex(ViewPager.this.f2821iILLL1);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityNodeInfo(View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            super.onInitializeAccessibilityNodeInfo(view, i1i);
            i1i.m2056LIl(ViewPager.class.getName());
            i1i.m63LL(IL1Iii());
            if (ViewPager.this.canScrollHorizontally(1)) {
                i1i.IL1Iii(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                i1i.IL1Iii(8192);
            }
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f2821iILLL1 + 1);
                return true;
            }
            if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f2821iILLL1 - 1);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$Ll丨1, reason: invalid class name */
    public class Ll1 extends DataSetObserver {
        public Ll1() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.m3391IiL();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.m3391IiL();
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$L丨1丨1丨I, reason: invalid class name */
    public interface L11I {
        void onAdapterChanged(ViewPager viewPager, ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii, ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public Parcelable f5231I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5232ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public ClassLoader f2841IL;

        public static class IL1Iii implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f5232ILil + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5232ILil);
            parcel.writeParcelable(this.f5231I1I, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f5232ILil = parcel.readInt();
            this.f5231I1I = parcel.readParcelable(classLoader);
            this.f2841IL = classLoader;
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$iI丨LLL1, reason: invalid class name */
    public static class iILLL1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f5233I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Object f5234IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5235ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public float f5236Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public float f2842IL;
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$lIi丨I, reason: invalid class name */
    public static class lIiI implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f5227IL1Iii;
            if (z != layoutParams2.f5227IL1Iii) {
                return z ? 1 : -1;
            }
            return layoutParams.f5229Ilil - layoutParams2.f5229Ilil;
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$l丨Li1LL, reason: invalid class name */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface lLi1LL {
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.ViewPager$丨il, reason: invalid class name and case insensitive filesystem */
    public interface InterfaceC0668il {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public ViewPager(Context context) {
        super(context);
        this.f5219I1I = new ArrayList<>();
        this.f2808IL = new iILLL1();
        this.f5221Ilil = new Rect();
        this.f2809IiL = -1;
        this.f2818L11I = null;
        this.f2833il = null;
        this.f2827lIlii = -3.4028235E38f;
        this.iIi1 = Float.MAX_VALUE;
        this.llliI = 1;
        this.f2824l1IIi1 = -1;
        this.f2804IIiI = true;
        this.f48iI = new I1I();
        this.f2815LlLiLL = 0;
        m3411lL();
    }

    public static boolean I11L(View view) {
        return view.getClass().getAnnotation(lLi1LL.class) != null;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f2834lL != z) {
            this.f2834lL = z;
        }
    }

    public iILLL1 I11li1(int i) {
        for (int i2 = 0; i2 < this.f5219I1I.size(); i2++) {
            iILLL1 iilll1 = this.f5219I1I.get(i2);
            if (iilll1.f5235ILil == i) {
                return iilll1;
            }
        }
        return null;
    }

    public void I1I(InterfaceC0668il interfaceC0668il) {
        if (this.f2820iI1iI == null) {
            this.f2820iI1iI = new ArrayList();
        }
        this.f2820iI1iI.add(interfaceC0668il);
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public InterfaceC0668il m3387IIiI(InterfaceC0668il interfaceC0668il) {
        InterfaceC0668il interfaceC0668il2 = this.f2805ILLIi;
        this.f2805ILLIi = interfaceC0668il;
        return interfaceC0668il2;
    }

    public iILLL1 IL1Iii(int i, int i2) {
        iILLL1 iilll1 = new iILLL1();
        iilll1.f5235ILil = i;
        iilll1.f5234IL1Iii = this.f2829lLi1LL.mo1284il(this, i);
        iilll1.f2842IL = this.f2829lLi1LL.m2481IiL(i);
        if (i2 < 0 || i2 >= this.f5219I1I.size()) {
            this.f5219I1I.add(iilll1);
        } else {
            this.f5219I1I.add(i2, iilll1);
        }
        return iilll1;
    }

    public final void ILL(int i) {
        InterfaceC0668il interfaceC0668il = this.f2803I1L11L;
        if (interfaceC0668il != null) {
            interfaceC0668il.onPageSelected(i);
        }
        List<InterfaceC0668il> list = this.f2820iI1iI;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0668il interfaceC0668il2 = this.f2820iI1iI.get(i2);
                if (interfaceC0668il2 != null) {
                    interfaceC0668il2.onPageSelected(i);
                }
            }
        }
        InterfaceC0668il interfaceC0668il3 = this.f2805ILLIi;
        if (interfaceC0668il3 != null) {
            interfaceC0668il3.onPageSelected(i);
        }
    }

    public void ILil(L11I l11i) {
        if (this.f2831li11 == null) {
            this.f2831li11 = new ArrayList();
        }
        this.f2831li11.add(l11i);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m3388ILl(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.f47i1 : 0, null);
        }
    }

    public final void Ilil(iILLL1 iilll1, int i, iILLL1 iilll2) {
        int i2;
        int i3;
        iILLL1 iilll3;
        iILLL1 iilll4;
        int iIlil = this.f2829lLi1LL.Ilil();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.f2806ILl / clientWidth : 0.0f;
        if (iilll2 != null) {
            int i4 = iilll2.f5235ILil;
            int i5 = iilll1.f5235ILil;
            if (i4 < i5) {
                int i6 = 0;
                float fM2481IiL = iilll2.f5236Ilil + iilll2.f2842IL + f;
                while (true) {
                    i4++;
                    if (i4 > iilll1.f5235ILil || i6 >= this.f5219I1I.size()) {
                        break;
                    }
                    iILLL1 iilll5 = this.f5219I1I.get(i6);
                    while (true) {
                        iilll4 = iilll5;
                        if (i4 <= iilll4.f5235ILil || i6 >= this.f5219I1I.size() - 1) {
                            break;
                        }
                        i6++;
                        iilll5 = this.f5219I1I.get(i6);
                    }
                    while (i4 < iilll4.f5235ILil) {
                        fM2481IiL += this.f2829lLi1LL.m2481IiL(i4) + f;
                        i4++;
                    }
                    iilll4.f5236Ilil = fM2481IiL;
                    fM2481IiL += iilll4.f2842IL + f;
                }
            } else if (i4 > i5) {
                int size = this.f5219I1I.size() - 1;
                float fM2481IiL2 = iilll2.f5236Ilil;
                while (true) {
                    i4--;
                    if (i4 < iilll1.f5235ILil || size < 0) {
                        break;
                    }
                    iILLL1 iilll6 = this.f5219I1I.get(size);
                    while (true) {
                        iilll3 = iilll6;
                        if (i4 >= iilll3.f5235ILil || size <= 0) {
                            break;
                        }
                        size--;
                        iilll6 = this.f5219I1I.get(size);
                    }
                    while (i4 > iilll3.f5235ILil) {
                        fM2481IiL2 -= this.f2829lLi1LL.m2481IiL(i4) + f;
                        i4--;
                    }
                    fM2481IiL2 -= iilll3.f2842IL + f;
                    iilll3.f5236Ilil = fM2481IiL2;
                }
            }
        }
        int size2 = this.f5219I1I.size();
        float fM2481IiL3 = iilll1.f5236Ilil;
        int i7 = iilll1.f5235ILil;
        int i8 = i7 - 1;
        this.f2827lIlii = i7 == 0 ? fM2481IiL3 : -3.4028235E38f;
        int i9 = iIlil - 1;
        this.iIi1 = i7 == i9 ? (iilll1.f2842IL + fM2481IiL3) - 1.0f : Float.MAX_VALUE;
        int i10 = i - 1;
        while (i10 >= 0) {
            iILLL1 iilll7 = this.f5219I1I.get(i10);
            while (true) {
                i3 = iilll7.f5235ILil;
                if (i8 <= i3) {
                    break;
                }
                fM2481IiL3 -= this.f2829lLi1LL.m2481IiL(i8) + f;
                i8--;
            }
            fM2481IiL3 -= iilll7.f2842IL + f;
            iilll7.f5236Ilil = fM2481IiL3;
            if (i3 == 0) {
                this.f2827lIlii = fM2481IiL3;
            }
            i10--;
            i8--;
        }
        float fM2481IiL4 = iilll1.f5236Ilil + iilll1.f2842IL + f;
        int i11 = iilll1.f5235ILil + 1;
        int i12 = i + 1;
        while (i12 < size2) {
            iILLL1 iilll8 = this.f5219I1I.get(i12);
            while (true) {
                i2 = iilll8.f5235ILil;
                if (i11 >= i2) {
                    break;
                }
                fM2481IiL4 += this.f2829lLi1LL.m2481IiL(i11) + f;
                i11++;
            }
            if (i2 == i9) {
                this.iIi1 = (iilll8.f2842IL + fM2481IiL4) - 1.0f;
            }
            iilll8.f5236Ilil = fM2481IiL4;
            fM2481IiL4 += iilll8.f2842IL + f;
            i12++;
            i11++;
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final void m3389IIi(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m3390IL(int i) {
        boolean z;
        boolean zRequestFocus;
        View viewFindFocus = findFocus();
        boolean zM3399LlLLL = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i == 17) {
                zRequestFocus = (viewFindFocus == null || m3406llL1ii(this.f5221Ilil, viewFindNextFocus).left < m3406llL1ii(this.f5221Ilil, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : m3399LlLLL();
            } else if (i == 66) {
                zRequestFocus = (viewFindFocus == null || m3406llL1ii(this.f5221Ilil, viewFindNextFocus).left > m3406llL1ii(this.f5221Ilil, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : m3404lIII();
            }
            zM3399LlLLL = zRequestFocus;
        } else if (i == 17 || i == 1) {
            zM3399LlLLL = m3399LlLLL();
        } else if (i == 66 || i == 2) {
            zM3399LlLLL = m3404lIII();
        }
        if (zM3399LlLLL) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zM3399LlLLL;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m3391IiL() {
        int iIlil = this.f2829lLi1LL.Ilil();
        this.f5220ILil = iIlil;
        boolean z = this.f5219I1I.size() < (this.llliI * 2) + 1 && this.f5219I1I.size() < iIlil;
        int iMax = this.f2821iILLL1;
        int i = 0;
        boolean z2 = false;
        while (i < this.f5219I1I.size()) {
            iILLL1 iilll1 = this.f5219I1I.get(i);
            int iM2487lLi1LL = this.f2829lLi1LL.m2487lLi1LL(iilll1.f5234IL1Iii);
            if (iM2487lLi1LL != -1) {
                if (iM2487lLi1LL == -2) {
                    this.f5219I1I.remove(i);
                    i--;
                    if (!z2) {
                        this.f2829lLi1LL.iIlLiL(this);
                        z2 = true;
                    }
                    this.f2829lLi1LL.ILil(this, iilll1.f5235ILil, iilll1.f5234IL1Iii);
                    int i2 = this.f2821iILLL1;
                    if (i2 == iilll1.f5235ILil) {
                        iMax = Math.max(0, Math.min(i2, iIlil - 1));
                    }
                } else {
                    int i3 = iilll1.f5235ILil;
                    if (i3 != iM2487lLi1LL) {
                        if (i3 == this.f2821iILLL1) {
                            iMax = iM2487lLi1LL;
                        }
                        iilll1.f5235ILil = iM2487lLi1LL;
                    }
                }
                z = true;
            }
            i++;
        }
        if (z2) {
            this.f2829lLi1LL.m2480IL(this);
        }
        Collections.sort(this.f5219I1I, f2802iiIIi11);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                if (!layoutParams.f5227IL1Iii) {
                    layoutParams.f5226I1I = 0.0f;
                }
            }
            m3392L11(iMax, false, true);
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m3392L11(int i, boolean z, boolean z2) {
        m3395LlIl(i, z, z2, 0);
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final boolean m3393L111(float f) {
        boolean z;
        boolean z2;
        float f2 = this.f2811L111 - f;
        this.f2811L111 = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.f2827lIlii * clientWidth;
        float f4 = this.iIi1 * clientWidth;
        boolean z3 = false;
        iILLL1 iilll1 = this.f5219I1I.get(0);
        ArrayList<iILLL1> arrayList = this.f5219I1I;
        iILLL1 iilll2 = arrayList.get(arrayList.size() - 1);
        if (iilll1.f5235ILil != 0) {
            f3 = iilll1.f5236Ilil * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (iilll2.f5235ILil != this.f2829lLi1LL.Ilil() - 1) {
            f4 = iilll2.f5236Ilil * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f2810L11.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f2814LlIl.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f2811L111 += scrollX - i;
        scrollTo(i, getScrollY());
        LL1IL(i);
        return z3;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final boolean m3394LIll() {
        this.f2824l1IIi1 = -1;
        Lil();
        this.f2810L11.onRelease();
        this.f2814LlIl.onRelease();
        return this.f2810L11.isFinished() || this.f2814LlIl.isFinished();
    }

    public final boolean LL1IL(int i) {
        if (this.f5219I1I.size() == 0) {
            if (this.f2804IIiI) {
                return false;
            }
            this.f2830lliiI1 = false;
            m3412l(0, 0.0f, 0);
            if (this.f2830lliiI1) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        iILLL1 iilll1IIlLiL = iIlLiL();
        int clientWidth = getClientWidth();
        int i2 = this.f2806ILl;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = iilll1IIlLiL.f5235ILil;
        float f2 = ((i / f) - iilll1IIlLiL.f5236Ilil) / (iilll1IIlLiL.f2842IL + (i2 / f));
        this.f2830lliiI1 = false;
        m3412l(i4, f2, (int) (i3 * f2));
        if (this.f2830lliiI1) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final void LLL() {
        if (this.f2822ili11 != 0) {
            ArrayList<View> arrayList = this.f2812LIl;
            if (arrayList == null) {
                this.f2812LIl = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f2812LIl.add(getChildAt(i));
            }
            Collections.sort(this.f2812LIl, f45I1);
        }
    }

    public final void Lil() {
        this.f2835l = false;
        this.f28371 = false;
        VelocityTracker velocityTracker = this.f2817L1l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2817L1l = null;
        }
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public void m3395LlIl(int i, boolean z, boolean z2, int i2) {
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii = this.f2829lLi1LL;
        if (iL1Iii == null || iL1Iii.Ilil() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f2821iILLL1 == i && this.f5219I1I.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f2829lLi1LL.Ilil()) {
            i = this.f2829lLi1LL.Ilil() - 1;
        }
        int i3 = this.llliI;
        int i4 = this.f2821iILLL1;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.f5219I1I.size(); i5++) {
                this.f5219I1I.get(i5).f5233I1I = true;
            }
        }
        boolean z3 = this.f2821iILLL1 != i;
        if (!this.f2804IIiI) {
            m123(i);
            m3401ill(i, z, i2, z3);
        } else {
            this.f2821iILLL1 = i;
            if (z3) {
                ILL(i);
            }
            requestLayout();
        }
    }

    public boolean LlLI1(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? m3399LlLLL() : m3390IL(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? m3404lIII() : m3390IL(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return m3390IL(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return m3390IL(1);
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3396Ll1(int i) {
        InterfaceC0668il interfaceC0668il = this.f2803I1L11L;
        if (interfaceC0668il != null) {
            interfaceC0668il.onPageScrollStateChanged(i);
        }
        List<InterfaceC0668il> list = this.f2820iI1iI;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0668il interfaceC0668il2 = this.f2820iI1iI.get(i2);
                if (interfaceC0668il2 != null) {
                    interfaceC0668il2.onPageScrollStateChanged(i);
                }
            }
        }
        InterfaceC0668il interfaceC0668il3 = this.f2805ILLIi;
        if (interfaceC0668il3 != null) {
            interfaceC0668il3.onPageScrollStateChanged(i);
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m3397L1l(L11I l11i) {
        List<L11I> list = this.f2831li11;
        if (list != null) {
            list.remove(l11i);
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final int m3398L11I(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f2813LIll || Math.abs(i2) <= this.f2832iILLl) {
            i += (int) (f + (i >= this.f2821iILLL1 ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f5219I1I.size() <= 0) {
            return i;
        }
        iILLL1 iilll1 = this.f5219I1I.get(0);
        ArrayList<iILLL1> arrayList = this.f5219I1I;
        return Math.max(iilll1.f5235ILil, Math.min(i, arrayList.get(arrayList.size() - 1).f5235ILil));
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m3399LlLLL() {
        int i = this.f2821iILLL1;
        if (i <= 0) {
            return false;
        }
        m3415(i - 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        iILLL1 iilll1IIi1;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (iilll1IIi1 = iIi1(childAt)) != null && iilll1IIi1.f5235ILil == this.f2821iILLL1) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        iILLL1 iilll1IIi1;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (iilll1IIi1 = iIi1(childAt)) != null && iilll1IIi1.f5235ILil == this.f2821iILLL1) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean zI11L = layoutParams2.f5227IL1Iii | I11L(view);
        layoutParams2.f5227IL1Iii = zI11L;
        if (!this.I11li1) {
            super.addView(view, i, layoutParams);
        } else {
            if (layoutParams2 != null && zI11L) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f2839IL = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f2829lLi1LL == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.f2827lIlii));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.iIi1));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f2816Ll1 = true;
        if (this.ILL.isFinished() || !this.ILL.computeScrollOffset()) {
            m3400iILLL1(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.ILL.getCurrX();
        int currY = this.ILL.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!LL1IL(currX)) {
                this.ILL.abortAnimation();
                scrollTo(0, currY);
            }
        }
        iIlLiL.m2101LIl(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || LlLI1(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        iILLL1 iilll1IIi1;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (iilll1IIi1 = iIi1(childAt)) != null && iilll1IIi1.f5235ILil == this.f2821iILLL1 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (iL1Iii = this.f2829lLi1LL) != null && iL1Iii.Ilil() > 1)) {
            if (!this.f2810L11.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f2827lIlii * width);
                this.f2810L11.setSize(height, width);
                zDraw = false | this.f2810L11.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f2814LlIl.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.iIi1 + 1.0f)) * width2);
                this.f2814LlIl.setSize(height2, width2);
                zDraw |= this.f2814LlIl.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f2810L11.finish();
            this.f2814LlIl.finish();
        }
        if (zDraw) {
            iIlLiL.m2101LIl(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.Lil;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ILil.iIlLiL.IL1Iii.IL1Iii getAdapter() {
        return this.f2829lLi1LL;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f2822ili11 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f2812LIl.get(i2).getLayoutParams()).f2840lLi1LL;
    }

    public int getCurrentItem() {
        return this.f2821iILLL1;
    }

    public int getOffscreenPageLimit() {
        return this.llliI;
    }

    public int getPageMargin() {
        return this.f2806ILl;
    }

    public iILLL1 iIi1(View view) {
        for (int i = 0; i < this.f5219I1I.size(); i++) {
            iILLL1 iilll1 = this.f5219I1I.get(i);
            if (this.f2829lLi1LL.ILL(view, iilll1.f5234IL1Iii)) {
                return iilll1;
            }
        }
        return null;
    }

    public final iILLL1 iIlLiL() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.f2806ILl / clientWidth : 0.0f;
        iILLL1 iilll1 = null;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.f5219I1I.size()) {
            iILLL1 iilll2 = this.f5219I1I.get(i3);
            if (!z && iilll2.f5235ILil != (i = i2 + 1)) {
                iilll2 = this.f2808IL;
                iilll2.f5236Ilil = f + f3 + f2;
                iilll2.f5235ILil = i;
                iilll2.f2842IL = this.f2829lLi1LL.m2481IiL(i);
                i3--;
            }
            f = iilll2.f5236Ilil;
            float f4 = iilll2.f2842IL + f + f2;
            if (!z && scrollX < f) {
                return iilll1;
            }
            if (scrollX < f4 || i3 == this.f5219I1I.size() - 1) {
                return iilll2;
            }
            i2 = iilll2.f5235ILil;
            f3 = iilll2.f2842IL;
            i3++;
            iilll1 = iilll2;
            z = false;
        }
        return iilll1;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m3400iILLL1(boolean z) {
        boolean z2 = this.f2815LlLiLL == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.ILL.isFinished()) {
                this.ILL.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.ILL.getCurrX();
                int currY = this.ILL.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        LL1IL(currX);
                    }
                }
            }
        }
        this.I11L = false;
        for (int i = 0; i < this.f5219I1I.size(); i++) {
            iILLL1 iilll1 = this.f5219I1I.get(i);
            if (iilll1.f5233I1I) {
                iilll1.f5233I1I = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                iIlLiL.m74iI(this, this.f48iI);
            } else {
                this.f48iI.run();
            }
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m3401ill(int i, boolean z, int i2, boolean z2) {
        iILLL1 iilll1I11li1 = I11li1(i);
        int clientWidth = iilll1I11li1 != null ? (int) (getClientWidth() * Math.max(this.f2827lIlii, Math.min(iilll1I11li1.f5236Ilil, this.iIi1))) : 0;
        if (z) {
            m3408lliiI1(clientWidth, 0, i2);
            if (z2) {
                ILL(i);
                return;
            }
            return;
        }
        if (z2) {
            ILL(i);
        }
        m3400iILLL1(false);
        scrollTo(clientWidth, 0);
        LL1IL(clientWidth);
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final void m3402l1IIi1() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f5227IL1Iii) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public float m3403lIiI(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean m3404lIII() {
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii = this.f2829lLi1LL;
        if (iL1Iii == null || this.f2821iILLL1 >= iL1Iii.Ilil() - 1) {
            return false;
        }
        m3415(this.f2821iILLL1 + 1, true);
        return true;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public iILLL1 m3405lIlii(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return iIi1(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public final void llI(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f5219I1I.isEmpty()) {
            if (!this.ILL.isFinished()) {
                this.ILL.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        iILLL1 iilll1I11li1 = I11li1(this.f2821iILLL1);
        int iMin = (int) ((iilll1I11li1 != null ? Math.min(iilll1I11li1.f5236Ilil, this.iIi1) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            m3400iILLL1(false);
            scrollTo(iMin, getScrollY());
        }
    }

    public final boolean llliI(float f, float f2) {
        return (f < ((float) this.f2826lIII) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f2826lIII)) && f2 < 0.0f);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final Rect m3406llL1ii(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m3407lLi1LL(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && m3407lLi1LL(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public void m3408lliiI1(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.ILL;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f2816Ll1 ? this.ILL.getCurrX() : this.ILL.getStartX();
            this.ILL.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m3400iILLL1(false);
            m3413LLlI1();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fM3403lIiI = f2 + (m3403lIiI(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM3403lIiI / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.f2829lLi1LL.m2481IiL(this.f2821iILLL1)) + this.f2806ILl)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.f2816Ll1 = false;
        this.ILL.startScroll(i4, scrollY, i5, i6, iMin);
        iIlLiL.m2101LIl(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2804IIiI = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f48iI);
        Scroller scroller = this.ILL;
        if (scroller != null && !scroller.isFinished()) {
            this.ILL.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f;
        super.onDraw(canvas);
        if (this.f2806ILl <= 0 || this.Lil == null || this.f5219I1I.size() <= 0 || this.f2829lLi1LL == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f2 = width;
        float f3 = this.f2806ILl / f2;
        int i2 = 0;
        iILLL1 iilll1 = this.f5219I1I.get(0);
        float f4 = iilll1.f5236Ilil;
        int size = this.f5219I1I.size();
        int i3 = iilll1.f5235ILil;
        int i4 = this.f5219I1I.get(size - 1).f5235ILil;
        while (i3 < i4) {
            while (true) {
                i = iilll1.f5235ILil;
                if (i3 <= i || i2 >= size) {
                    break;
                }
                i2++;
                iilll1 = this.f5219I1I.get(i2);
            }
            if (i3 == i) {
                float f5 = iilll1.f5236Ilil;
                float f6 = iilll1.f2842IL;
                f = (f5 + f6) * f2;
                f4 = f5 + f6 + f3;
            } else {
                float fM2481IiL = this.f2829lLi1LL.m2481IiL(i3);
                f = (f4 + fM2481IiL) * f2;
                f4 += fM2481IiL + f3;
            }
            if (this.f2806ILl + f > scrollX) {
                this.Lil.setBounds(Math.round(f), this.LlLI1, Math.round(this.f2806ILl + f), this.f2828llL1ii);
                this.Lil.draw(canvas);
            }
            if (f > scrollX + width) {
                return;
            }
            i3++;
            f3 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m3394LIll();
            return false;
        }
        if (action != 0) {
            if (this.f2835l) {
                return true;
            }
            if (this.f28371) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f49 = x;
            this.f2811L111 = x;
            float y = motionEvent.getY();
            this.llI = y;
            this.f2836LLlI1 = y;
            this.f2824l1IIi1 = motionEvent.getPointerId(0);
            this.f28371 = false;
            this.f2816Ll1 = true;
            this.ILL.computeScrollOffset();
            if (this.f2815LlLiLL != 2 || Math.abs(this.ILL.getFinalX() - this.ILL.getCurrX()) <= this.f2823ill) {
                m3400iILLL1(false);
                this.f2835l = false;
            } else {
                this.ILL.abortAnimation();
                this.I11L = false;
                m3413LLlI1();
                this.f2835l = true;
                m3389IIi(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f2824l1IIi1;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.f2811L111;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.llI);
                if (f != 0.0f && !llliI(this.f2811L111, f) && m3407lLi1LL(this, false, (int) f, (int) x2, (int) y2)) {
                    this.f2811L111 = x2;
                    this.f2836LLlI1 = y2;
                    this.f28371 = true;
                    return false;
                }
                int i2 = this.LL1IL;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.f2835l = true;
                    m3389IIi(true);
                    setScrollState(1);
                    float f2 = this.f49;
                    float f3 = this.LL1IL;
                    this.f2811L111 = f > 0.0f ? f2 + f3 : f2 - f3;
                    this.f2836LLlI1 = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.f28371 = true;
                }
                if (this.f2835l && m3393L111(x2)) {
                    iIlLiL.m2101LIl(this);
                }
            }
        } else if (action == 6) {
            m34141(motionEvent);
        }
        if (this.f2817L1l == null) {
            this.f2817L1l = VelocityTracker.obtain();
        }
        this.f2817L1l.addMovement(motionEvent);
        return this.f2835l;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        iILLL1 iilll1IIi1;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f5227IL1Iii) {
                    int i9 = layoutParams.f5228ILil;
                    int i10 = i9 & 7;
                    int i11 = i9 & 112;
                    if (i10 != 1) {
                        if (i10 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i10 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i11 != 16) {
                            if (i11 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i11 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i12 = paddingLeft + scrollX;
                            childAt.layout(i12, paddingTop, childAt.getMeasuredWidth() + i12, paddingTop + childAt.getMeasuredHeight());
                            i7++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i13 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i13;
                        int i14 = paddingLeft + scrollX;
                        childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i15 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i15;
                    if (i11 != 16) {
                        if (i11 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i11 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i16 = paddingLeft + scrollX;
                        childAt.layout(i16, paddingTop, childAt.getMeasuredWidth() + i16, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i17 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i17;
                    int i18 = paddingLeft + scrollX;
                    childAt.layout(i18, paddingTop, childAt.getMeasuredWidth() + i18, paddingTop + childAt.getMeasuredHeight());
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i19 = (i5 - paddingLeft) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f5227IL1Iii && (iilll1IIi1 = iIi1(childAt2)) != null) {
                    float f = i19;
                    int i21 = ((int) (iilll1IIi1.f5236Ilil * f)) + paddingLeft;
                    if (layoutParams2.f2839IL) {
                        layoutParams2.f2839IL = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.f5226I1I), Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
                    }
                    childAt2.layout(i21, paddingTop, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.LlLI1 = paddingTop;
        this.f2828llL1ii = i6 - paddingBottom;
        this.LLL = i7;
        if (this.f2804IIiI) {
            z2 = false;
            m3401ill(this.f2821iILLL1, false, 0, false);
        } else {
            z2 = false;
        }
        this.f2804IIiI = z2;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0082 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:42:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af A[SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f2826lIII = Math.min(measuredWidth / 10, this.f2819LlLLL);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z = true;
            int i7 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f5227IL1Iii) {
                int i8 = layoutParams2.f5228ILil;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                boolean z2 = i10 == 48 || i10 == 80;
                if (i9 != 3 && i9 != 5) {
                    z = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z2) {
                    i11 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                } else {
                    i3 = z ? Videoio.CAP_OPENNI_IMAGE_GENERATOR : Integer.MIN_VALUE;
                    i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i4 != -2) {
                        if (i4 == -1) {
                            i4 = paddingLeft;
                        }
                        i11 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                    } else {
                        i4 = paddingLeft;
                    }
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i5 != -2) {
                        i5 = measuredHeight;
                        i7 = i3;
                    } else if (i5 == -1) {
                        i5 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                    if (z2) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i4 != -2) {
                    if (i4 == -1) {
                        i4 = paddingLeft;
                    }
                    i11 = Videoio.CAP_OPENNI_IMAGE_GENERATOR;
                } else {
                    i4 = paddingLeft;
                }
                i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i5 != -2) {
                    i5 = measuredHeight;
                    i7 = i3;
                } else if (i5 == -1) {
                    i5 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        this.iIlLiL = View.MeasureSpec.makeMeasureSpec(measuredHeight, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        this.I11li1 = true;
        m3413LLlI1();
        this.I11li1 = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f5227IL1Iii)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f5226I1I), Videoio.CAP_OPENNI_IMAGE_GENERATOR), this.iIlLiL);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        iILLL1 iilll1IIi1;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (iilll1IIi1 = iIi1(childAt)) != null && iilll1IIi1.f5235ILil == this.f2821iILLL1 && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii = this.f2829lLi1LL;
        if (iL1Iii != null) {
            iL1Iii.m2479ILl(savedState.f5231I1I, savedState.f2841IL);
            m3392L11(savedState.f5232ILil, false, true);
        } else {
            this.f2809IiL = savedState.f5232ILil;
            this.f2818L11I = savedState.f5231I1I;
            this.f2833il = savedState.f2841IL;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5232ILil = this.f2821iILLL1;
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii = this.f2829lLi1LL;
        if (iL1Iii != null) {
            savedState.f5231I1I = iL1Iii.Lil();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.f2806ILl;
            llI(i, i3, i5, i5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00dc  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii;
        if (this.f2838) {
            return true;
        }
        boolean zM3394LIll = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (iL1Iii = this.f2829lLi1LL) == null || iL1Iii.Ilil() == 0) {
            return false;
        }
        if (this.f2817L1l == null) {
            this.f2817L1l = VelocityTracker.obtain();
        }
        this.f2817L1l.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.ILL.abortAnimation();
            this.I11L = false;
            m3413LLlI1();
            float x = motionEvent.getX();
            this.f49 = x;
            this.f2811L111 = x;
            float y = motionEvent.getY();
            this.llI = y;
            this.f2836LLlI1 = y;
            this.f2824l1IIi1 = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f2811L111 = motionEvent.getX(actionIndex);
                        this.f2824l1IIi1 = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        m34141(motionEvent);
                        this.f2811L111 = motionEvent.getX(motionEvent.findPointerIndex(this.f2824l1IIi1));
                    }
                } else if (this.f2835l) {
                    m3401ill(this.f2821iILLL1, true, 0, false);
                    zM3394LIll = m3394LIll();
                }
            } else if (!this.f2835l) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f2824l1IIi1);
                if (iFindPointerIndex == -1) {
                    zM3394LIll = m3394LIll();
                } else {
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x2 - this.f2811L111);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y2 - this.f2836LLlI1);
                    if (fAbs > this.LL1IL && fAbs > fAbs2) {
                        this.f2835l = true;
                        m3389IIi(true);
                        float f = this.f49;
                        this.f2811L111 = x2 - f > 0.0f ? f + this.LL1IL : f - this.LL1IL;
                        this.f2836LLlI1 = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.f2835l) {
                        zM3394LIll = false | m3393L111(motionEvent.getX(motionEvent.findPointerIndex(this.f2824l1IIi1)));
                    }
                }
            } else if (this.f2835l) {
                zM3394LIll = false | m3393L111(motionEvent.getX(motionEvent.findPointerIndex(this.f2824l1IIi1)));
            }
        } else if (this.f2835l) {
            VelocityTracker velocityTracker = this.f2817L1l;
            velocityTracker.computeCurrentVelocity(1000, this.f2807IIi);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f2824l1IIi1);
            this.I11L = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            iILLL1 iilll1IIlLiL = iIlLiL();
            float f2 = clientWidth;
            m3395LlIl(m3398L11I(iilll1IIlLiL.f5235ILil, ((scrollX / f2) - iilll1IIlLiL.f5236Ilil) / (iilll1IIlLiL.f2842IL + (this.f2806ILl / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f2824l1IIi1)) - this.f49)), true, true, xVelocity);
            zM3394LIll = m3394LIll();
        }
        if (zM3394LIll) {
            iIlLiL.m2101LIl(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.I11li1) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii) {
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii2 = this.f2829lLi1LL;
        if (iL1Iii2 != null) {
            iL1Iii2.m2485lIlii(null);
            this.f2829lLi1LL.iIlLiL(this);
            for (int i = 0; i < this.f5219I1I.size(); i++) {
                iILLL1 iilll1 = this.f5219I1I.get(i);
                this.f2829lLi1LL.ILil(this, iilll1.f5235ILil, iilll1.f5234IL1Iii);
            }
            this.f2829lLi1LL.m2480IL(this);
            this.f5219I1I.clear();
            m3402l1IIi1();
            this.f2821iILLL1 = 0;
            scrollTo(0, 0);
        }
        ILil.iIlLiL.IL1Iii.IL1Iii iL1Iii3 = this.f2829lLi1LL;
        this.f2829lLi1LL = iL1Iii;
        this.f5220ILil = 0;
        if (iL1Iii != null) {
            if (this.f2825lIiI == null) {
                this.f2825lIiI = new Ll1();
            }
            this.f2829lLi1LL.m2485lIlii(this.f2825lIiI);
            this.I11L = false;
            boolean z = this.f2804IIiI;
            this.f2804IIiI = true;
            this.f5220ILil = this.f2829lLi1LL.Ilil();
            if (this.f2809IiL >= 0) {
                this.f2829lLi1LL.m2479ILl(this.f2818L11I, this.f2833il);
                m3392L11(this.f2809IiL, false, true);
                this.f2809IiL = -1;
                this.f2818L11I = null;
                this.f2833il = null;
            } else if (z) {
                requestLayout();
            } else {
                m3413LLlI1();
            }
        }
        List<L11I> list = this.f2831li11;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f2831li11.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2831li11.get(i2).onAdapterChanged(this, iL1Iii3, iL1Iii);
        }
    }

    public void setCurrentItem(int i) {
        this.I11L = false;
        m3392L11(i, !this.f2804IIiI, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.llliI) {
            this.llliI = i;
            m3413LLlI1();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC0668il interfaceC0668il) {
        this.f2803I1L11L = interfaceC0668il;
    }

    public void setPageMargin(int i) {
        int i2 = this.f2806ILl;
        this.f2806ILl = i;
        int width = getWidth();
        llI(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.Lil = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.f2815LlLiLL == i) {
            return;
        }
        this.f2815LlLiLL = i;
        if (this.iIilII1 != null) {
            m3388ILl(i != 0);
        }
        m3396Ll1(i);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Lil;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m3409iILLl(InterfaceC0668il interfaceC0668il) {
        List<InterfaceC0668il> list = this.f2820iI1iI;
        if (list != null) {
            list.remove(interfaceC0668il);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m3410il(int i, float f, int i2) {
        InterfaceC0668il interfaceC0668il = this.f2803I1L11L;
        if (interfaceC0668il != null) {
            interfaceC0668il.onPageScrolled(i, f, i2);
        }
        List<InterfaceC0668il> list = this.f2820iI1iI;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                InterfaceC0668il interfaceC0668il2 = this.f2820iI1iI.get(i3);
                if (interfaceC0668il2 != null) {
                    interfaceC0668il2.onPageScrolled(i, f, i2);
                }
            }
        }
        InterfaceC0668il interfaceC0668il3 = this.f2805ILLIi;
        if (interfaceC0668il3 != null) {
            interfaceC0668il3.onPageScrolled(i, f, i2);
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m3411lL() {
        setWillNotDraw(false);
        setDescendantFocusability(Calib3d.CALIB_TILTED_MODEL);
        setFocusable(true);
        Context context = getContext();
        this.ILL = new Scroller(context, f2801iILilI);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.LL1IL = viewConfiguration.getScaledPagingTouchSlop();
        this.f2832iILLl = (int) (400.0f * f);
        this.f2807IIi = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2810L11 = new EdgeEffect(context);
        this.f2814LlIl = new EdgeEffect(context);
        this.f2813LIll = (int) (25.0f * f);
        this.f2823ill = (int) (2.0f * f);
        this.f2819LlLLL = (int) (f * 16.0f);
        iIlLiL.m75lL(this, new IiL());
        if (iIlLiL.I11L(this) == 0) {
            iIlLiL.m72LL(this, 1);
        }
        iIlLiL.m2111iI1LI(this, new IL());
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m3412l(int i, float f, int i2) {
        int iMax;
        int width;
        int left;
        if (this.LLL > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f5227IL1Iii) {
                    int i4 = layoutParams.f5228ILil & 7;
                    if (i4 != 1) {
                        if (i4 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i4 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i5 = iMax;
                    width = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        m3410il(i, f, i2);
        if (this.iIilII1 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((LayoutParams) childAt2.getLayoutParams()).f5227IL1Iii) {
                    this.iIilII1.IL1Iii(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.f2830lliiI1 = true;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f7 A[PHI: r7 r10 r15
  0x00f7: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: 丨丨 */
    public void m123(int i) {
        iILLL1 iilll1I11li1;
        String hexString;
        iILLL1 iilll1IL1Iii;
        iILLL1 iilll1IIi1;
        iILLL1 iilll1;
        int i2 = this.f2821iILLL1;
        if (i2 != i) {
            iilll1I11li1 = I11li1(i2);
            this.f2821iILLL1 = i;
        } else {
            iilll1I11li1 = null;
        }
        if (this.f2829lLi1LL == null) {
            LLL();
            return;
        }
        if (this.I11L) {
            LLL();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f2829lLi1LL.iIlLiL(this);
        int i3 = this.llliI;
        int iMax = Math.max(0, this.f2821iILLL1 - i3);
        int iIlil = this.f2829lLi1LL.Ilil();
        int iMin = Math.min(iIlil - 1, this.f2821iILLL1 + i3);
        if (iIlil != this.f5220ILil) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f5220ILil + ", found: " + iIlil + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f2829lLi1LL.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.f5219I1I.size()) {
                iilll1IL1Iii = this.f5219I1I.get(i4);
                int i5 = iilll1IL1Iii.f5235ILil;
                int i6 = this.f2821iILLL1;
                if (i5 >= i6) {
                    if (i5 != i6) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            iilll1IL1Iii = null;
            break;
        }
        if (iilll1IL1Iii == null && iIlil > 0) {
            iilll1IL1Iii = IL1Iii(this.f2821iILLL1, i4);
        }
        if (iilll1IL1Iii != null) {
            int i7 = i4 - 1;
            iILLL1 iilll2 = i7 >= 0 ? this.f5219I1I.get(i7) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - iilll1IL1Iii.f2842IL) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i8 = this.f2821iILLL1 - 1; i8 >= 0; i8--) {
                if (f < paddingLeft || i8 >= iMax) {
                    if (iilll2 == null || i8 != iilll2.f5235ILil) {
                        f += IL1Iii(i8, i7 + 1).f2842IL;
                        i4++;
                        if (i7 >= 0) {
                            iilll1 = this.f5219I1I.get(i7);
                        } else {
                            iilll1 = null;
                        }
                    } else {
                        f += iilll2.f2842IL;
                        i7--;
                        if (i7 >= 0) {
                            iilll1 = this.f5219I1I.get(i7);
                        } else {
                            iilll1 = null;
                        }
                    }
                    iilll2 = iilll1;
                } else {
                    if (iilll2 == null) {
                        break;
                    }
                    if (i8 == iilll2.f5235ILil && !iilll2.f5233I1I) {
                        this.f5219I1I.remove(i7);
                        this.f2829lLi1LL.ILil(this, i8, iilll2.f5234IL1Iii);
                        i7--;
                        i4--;
                        if (i7 >= 0) {
                            iilll1 = this.f5219I1I.get(i7);
                        } else {
                            iilll1 = null;
                        }
                        iilll2 = iilll1;
                    }
                }
            }
            float f2 = iilll1IL1Iii.f2842IL;
            int i9 = i4 + 1;
            if (f2 < 2.0f) {
                iILLL1 iilll3 = i9 < this.f5219I1I.size() ? this.f5219I1I.get(i9) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i10 = this.f2821iILLL1;
                while (true) {
                    i10++;
                    if (i10 >= iIlil) {
                        break;
                    }
                    if (f2 >= paddingRight && i10 > iMin) {
                        if (iilll3 == null) {
                            break;
                        }
                        if (i10 == iilll3.f5235ILil && !iilll3.f5233I1I) {
                            this.f5219I1I.remove(i9);
                            this.f2829lLi1LL.ILil(this, i10, iilll3.f5234IL1Iii);
                            if (i9 < this.f5219I1I.size()) {
                                iilll3 = this.f5219I1I.get(i9);
                            }
                        }
                    } else if (iilll3 == null || i10 != iilll3.f5235ILil) {
                        iILLL1 iilll1IL1Iii2 = IL1Iii(i10, i9);
                        i9++;
                        f2 += iilll1IL1Iii2.f2842IL;
                        iilll3 = i9 < this.f5219I1I.size() ? this.f5219I1I.get(i9) : null;
                    } else {
                        f2 += iilll3.f2842IL;
                        i9++;
                        if (i9 < this.f5219I1I.size()) {
                            iilll3 = this.f5219I1I.get(i9);
                        }
                    }
                }
            }
            Ilil(iilll1IL1Iii, i4, iilll1I11li1);
            this.f2829lLi1LL.m2486llL1ii(this, this.f2821iILLL1, iilll1IL1Iii.f5234IL1Iii);
        }
        this.f2829lLi1LL.m2480IL(this);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.f2840lLi1LL = i11;
            if (!layoutParams.f5227IL1Iii && layoutParams.f5226I1I == 0.0f && (iilll1IIi1 = iIi1(childAt)) != null) {
                layoutParams.f5226I1I = iilll1IIi1.f2842IL;
                layoutParams.f5229Ilil = iilll1IIi1.f5235ILil;
            }
        }
        LLL();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            iILLL1 iilll1M3405lIlii = viewFindFocus != null ? m3405lIlii(viewFindFocus) : null;
            if (iilll1M3405lIlii == null || iilll1M3405lIlii.f5235ILil != this.f2821iILLL1) {
                for (int i12 = 0; i12 < getChildCount(); i12++) {
                    View childAt2 = getChildAt(i12);
                    iILLL1 iilll1IIi2 = iIi1(childAt2);
                    if (iilll1IIi2 != null && iilll1IIi2.f5235ILil == this.f2821iILLL1 && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m3413LLlI1() {
        m123(this.f2821iILLL1);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final void m34141(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2824l1IIi1) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2811L111 = motionEvent.getX(i);
            this.f2824l1IIi1 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f2817L1l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m3415(int i, boolean z) {
        this.I11L = false;
        m3392L11(i, z, false);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f5226I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5227IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5228ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f5229Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2839IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2840lLi1LL;

        public LayoutParams() {
            super(-1, -1);
            this.f5226I1I = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5226I1I = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f46I);
            this.f5228ILil = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(getContext(), i));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5219I1I = new ArrayList<>();
        this.f2808IL = new iILLL1();
        this.f5221Ilil = new Rect();
        this.f2809IiL = -1;
        this.f2818L11I = null;
        this.f2833il = null;
        this.f2827lIlii = -3.4028235E38f;
        this.iIi1 = Float.MAX_VALUE;
        this.llliI = 1;
        this.f2824l1IIi1 = -1;
        this.f2804IIiI = true;
        this.f48iI = new I1I();
        this.f2815LlLiLL = 0;
        m3411lL();
    }
}
