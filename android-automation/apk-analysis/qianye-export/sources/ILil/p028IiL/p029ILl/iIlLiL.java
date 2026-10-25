package ILil.p028IiL.p029ILl;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class iIlLiL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4059I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Field f4061ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static boolean f4062Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Field f1626IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static Field f1627IiL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static WeakHashMap<View, String> f1630lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static ThreadLocal<Rect> f1631il;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final AtomicInteger f4060IL1Iii = new AtomicInteger(1);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static WeakHashMap<View, llliI> f1629iILLL1 = null;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean f1628L11I = false;

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class I1I extends iILLL1<CharSequence> {
        public I1I(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: ILL, reason: merged with bridge method [inline-methods] */
        public boolean mo2139IiL(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public CharSequence mo2138IL(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void Ilil(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class IL1Iii implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ LlLI1 f4063IL1Iii;

        public IL1Iii(LlLI1 llLI1) {
            this.f4063IL1Iii = llLI1;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) C0633lIII.m2152L11I(this.f4063IL1Iii.onApplyWindowInsets(view, C0633lIII.m2153il(windowInsets)));
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class ILil extends iILLL1<Boolean> {
        public ILil(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: ILL, reason: merged with bridge method [inline-methods] */
        public boolean mo2139IiL(Boolean bool, Boolean bool2) {
            return !IL1Iii(bool, bool2);
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean mo2138IL(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void Ilil(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.iIlLiL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompat.java */
    public static class IL extends iILLL1<Boolean> {
        public IL(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: ILL, reason: merged with bridge method [inline-methods] */
        public boolean mo2139IiL(Boolean bool, Boolean bool2) {
            return !IL1Iii(bool, bool2);
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean mo2138IL(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        @Override // ILil.p028IiL.p029ILl.iIlLiL.iILLL1
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void Ilil(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.iIlLiL$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompat.java */
    public interface IiL {
        boolean IL1Iii(View view, KeyEvent keyEvent);
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.iIlLiL$L丨1丨1丨I, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompat.java */
    public static class L11I {

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static final ArrayList<WeakReference<View>> f1632IL = new ArrayList<>();

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f4065IL1Iii = null;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f4066ILil = null;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public WeakReference<KeyEvent> f4064I1I = null;

        public static L11I IL1Iii(View view) {
            int i = ILil.p028IiL.I1I.tag_unhandled_key_event_manager;
            L11I l11i = (L11I) view.getTag(i);
            if (l11i != null) {
                return l11i;
            }
            L11I l11i2 = new L11I();
            view.setTag(i, l11i2);
            return l11i2;
        }

        public final View I1I(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f4065IL1Iii;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewI1I = I1I(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewI1I != null) {
                            return viewI1I;
                        }
                    }
                }
                if (Ilil(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public boolean ILil(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m2147iILLL1();
            }
            View viewI1I = I1I(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewI1I != null && !KeyEvent.isModifierKey(keyCode)) {
                    m2146IL().put(keyCode, new WeakReference<>(viewI1I));
                }
            }
            return viewI1I != null;
        }

        public final boolean Ilil(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(ILil.p028IiL.I1I.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((IiL) arrayList.get(size)).IL1Iii(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final SparseArray<WeakReference<View>> m2146IL() {
            if (this.f4066ILil == null) {
                this.f4066ILil = new SparseArray<>();
            }
            return this.f4066ILil;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final void m2147iILLL1() {
            WeakHashMap<View, Boolean> weakHashMap = this.f4065IL1Iii;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f1632IL;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f4065IL1Iii == null) {
                    this.f4065IL1Iii = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f1632IL;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f4065IL1Iii.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f4065IL1Iii.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean m2148lLi1LL(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f4064I1I;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f4064I1I = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayM2146IL = m2146IL();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayM2146IL.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayM2146IL.valueAt(iIndexOfKey);
                sparseArrayM2146IL.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayM2146IL.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && iIlLiL.m2099L11(view)) {
                Ilil(view, keyEvent);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.iIlLiL$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompat.java */
    public static abstract class iILLL1<T> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4067I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int f4068IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Class<T> f4069ILil;

        public iILLL1(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        public final boolean I1I() {
            return Build.VERSION.SDK_INT >= this.f4067I1I;
        }

        public boolean IL1Iii(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public final boolean ILil() {
            return Build.VERSION.SDK_INT >= 19;
        }

        public abstract void Ilil(View view, T t);

        /* JADX INFO: renamed from: I丨L */
        public abstract T mo2138IL(View view);

        /* JADX INFO: renamed from: I丨iL */
        public abstract boolean mo2139IiL(T t, T t2);

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m2149iILLL1(View view, T t) {
            if (I1I()) {
                Ilil(view, t);
            } else if (ILil() && mo2139IiL(m2150lLi1LL(view), t)) {
                iIlLiL.LL1IL(view);
                view.setTag(this.f4068IL1Iii, t);
                iIlLiL.m2109iI1iI(view, 0);
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public T m2150lLi1LL(View view) {
            if (I1I()) {
                return mo2138IL(view);
            }
            if (!ILil()) {
                return null;
            }
            T t = (T) view.getTag(this.f4068IL1Iii);
            if (this.f4069ILil.isInstance(t)) {
                return t;
            }
            return null;
        }

        public iILLL1(int i, Class<T> cls, int i2, int i3) {
            this.f4068IL1Iii = i;
            this.f4069ILil = cls;
            this.f4067I1I = i3;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.iIlLiL$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompat.java */
    public static class lLi1LL implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f4070ILil = new WeakHashMap<>();

        public final void IL1Iii(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    iIlLiL.m2109iI1iI(view, 16);
                }
                this.f4070ILil.put(view, Boolean.valueOf(z2));
            }
        }

        public final void ILil(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f4070ILil.entrySet()) {
                IL1Iii(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ILil(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static {
        new lLi1LL();
    }

    /* JADX INFO: renamed from: I1 */
    public static void m70I1(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static int I11L(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static Rect I11li1() {
        if (f1631il == null) {
            f1631il = new ThreadLocal<>();
        }
        Rect rect = f1631il.get();
        if (rect == null) {
            rect = new Rect();
            f1631il.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static llliI I1I(View view) {
        if (f1629iILLL1 == null) {
            f1629iILLL1 = new WeakHashMap<>();
        }
        llliI lllii = f1629iILLL1.get(view);
        if (lllii != null) {
            return lllii;
        }
        llliI lllii2 = new llliI(view);
        f1629iILLL1.put(view, lllii2);
        return lllii2;
    }

    public static void I1IILIIL(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public static void m2092I1L11L(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        if (i2 < 21) {
            Ilil(view, i);
            return;
        }
        Rect rectI11li1 = I11li1();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectI11li1.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectI11li1.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        Ilil(view, i);
        if (z && rectI11li1.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectI11li1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public static boolean m2093IIiI(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof InterfaceC0634il) {
            return ((InterfaceC0634il) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static iILLL1<Boolean> IL1Iii() {
        return new IL(ILil.p028IiL.I1I.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void ILI1Ll(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static ILil.p028IiL.p029ILl.IL1Iii ILL(View view) {
        View.AccessibilityDelegate accessibilityDelegateM2105Ll1 = m2105Ll1(view);
        if (accessibilityDelegateM2105Ll1 == null) {
            return null;
        }
        return accessibilityDelegateM2105Ll1 instanceof ILil.p028IiL.p029ILl.IL1Iii.C0562IL1Iii ? ((ILil.p028IiL.p029ILl.IL1Iii.C0562IL1Iii) accessibilityDelegateM2105Ll1).f4034IL1Iii : new ILil.p028IiL.p029ILl.IL1Iii(accessibilityDelegateM2105Ll1);
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public static void m2094ILLIi(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        if (i2 < 21) {
            m2125lLi1LL(view, i);
            return;
        }
        Rect rectI11li1 = I11li1();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectI11li1.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectI11li1.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        m2125lLi1LL(view, i);
        if (z && rectI11li1.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectI11li1);
        }
    }

    public static void ILil(View view, ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii iL1Iii) {
        if (Build.VERSION.SDK_INT >= 21) {
            LL1IL(view);
            m2114iiIIi11(iL1Iii.ILil(), view);
            Lil(view).add(iL1Iii);
            m2109iI1iI(view, 0);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static CharSequence m2095ILl(View view) {
        return m73i1().m2150lLi1LL(view);
    }

    public static void Ilil(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            LIlLi(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                LIlLi((View) parent);
            }
        }
    }

    /* JADX INFO: renamed from: I丨 */
    public static void m71I(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2114iiIIi11(i, view);
            m2109iI1iI(view, 0);
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public static boolean m2096IIi(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    @Deprecated
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2097IL(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m2098IiL(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return L11I.IL1Iii(view).ILil(view, keyEvent);
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public static boolean m2099L11(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public static int m2100L111(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static iILLL1<Boolean> L1iI1() {
        return new ILil(ILil.p028IiL.I1I.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static void LI11(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void LII(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof InterfaceC0634il) {
            ((InterfaceC0634il) view).stopNestedScroll();
        }
    }

    public static void LIlLi(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public static void m2101LIl(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public static boolean m2102LIll(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    /* JADX INFO: renamed from: LL */
    public static void m72LL(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            view.setImportantForAccessibility(i);
        } else if (i2 >= 16) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    public static ILil.p028IiL.p029ILl.IL1Iii LL1IL(View view) {
        ILil.p028IiL.p029ILl.IL1Iii iL1IiiILL = ILL(view);
        if (iL1IiiILL == null) {
            iL1IiiILL = new ILil.p028IiL.p029ILl.IL1Iii();
        }
        m75lL(view, iL1IiiILL);
        return iL1IiiILL;
    }

    public static boolean LLL(View view) {
        Boolean boolM2150lLi1LL = L1iI1().m2150lLi1LL(view);
        if (boolM2150lLi1LL == null) {
            return false;
        }
        return boolM2150lLi1LL.booleanValue();
    }

    @Deprecated
    public static void LiL1(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void Liil1L1l(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static List<ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii> Lil(View view) {
        int i = ILil.p028IiL.I1I.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i, arrayList2);
        return arrayList2;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public static boolean m2103LlIl(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList LlLI1(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof iIi1) {
            return ((iIi1) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public static void m2104LlLiLL(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static View.AccessibilityDelegate m2105Ll1(View view) {
        if (f1628L11I) {
            return null;
        }
        if (f1627IiL == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1627IiL = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1628L11I = true;
                return null;
            }
        }
        try {
            Object obj = f1627IiL.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1628L11I = true;
            return null;
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public static int m2106L1l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean m2107L11I(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return L11I.IL1Iii(view).m2148lLi1LL(keyEvent);
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public static int m2108LlLLL(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f4062Ilil) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f1626IL = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4062Ilil = true;
        }
        Field field = f1626IL;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: i1 */
    public static iILLL1<CharSequence> m73i1() {
        return new I1I(ILil.p028IiL.I1I.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    /* JADX INFO: renamed from: iI */
    public static void m74iI(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public static void m2109iI1iI(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = m2095ILl(view) != null;
            if (m2121lIiI(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    public static Display iIi1(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (m2099L11(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void iIilII1(View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
        view.onInitializeAccessibilityNodeInfo(i1i.m20811iIl());
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public static void m2110iIl1il(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static float iIlLiL(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public static void m2111iI1LI(View view, LlLI1 llLI1) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (llLI1 == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new IL1Iii(llLI1));
            }
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static C0633lIII m2112iILLL1(View view, C0633lIII c0633lIII) {
        if (Build.VERSION.SDK_INT < 21) {
            return c0633lIII;
        }
        WindowInsets windowInsets = (WindowInsets) C0633lIII.m2152L11I(c0633lIII);
        WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsets)) {
            windowInsets = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
        }
        return C0633lIII.m2153il(windowInsets);
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public static void m2113iILilI(View view, ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii iL1Iii, CharSequence charSequence, ILil.p028IiL.p029ILl.LL1IL.iILLL1 iilll1) {
        ILil(view, iL1Iii.IL1Iii(charSequence, iilll1));
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public static void m2114iiIIi11(int i, View view) {
        List<ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii> listLil = Lil(view);
        for (int i2 = 0; i2 < listLil.size(); i2++) {
            if (listLil.get(i2).ILil() == i) {
                listLil.remove(i2);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public static boolean m2115ili11(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    public static void ill1LI1l(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public static boolean m2116ill(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public static void m2117i1I1I1l(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public static void m2118iILiiLl(View view, lIlii lilii) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (lilii != null ? lilii.IL1Iii() : null));
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public static float m2119l1IIi1(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void l1Lll(View view, boolean z) {
        IL1Iii().m2149iILLL1(view, Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public static void m2120lIIiIlL(View view, ColorStateList colorStateList) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            if (view instanceof iIi1) {
                ((iIi1) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (i == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static int m2121lIiI(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static int m2122lIII(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f4059I1I) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f4061ILil = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4059I1I = true;
        }
        Field field = f4061ILil;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static Rect m2123lIlii(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    /* JADX INFO: renamed from: lL */
    public static void m75lL(View view, ILil.p028IiL.p029ILl.IL1Iii iL1Iii) {
        if (iL1Iii == null && (m2105Ll1(view) instanceof ILil.p028IiL.p029ILl.IL1Iii.C0562IL1Iii)) {
            iL1Iii = new ILil.p028IiL.p029ILl.IL1Iii();
        }
        view.setAccessibilityDelegate(iL1Iii == null ? null : iL1Iii.getBridge());
    }

    public static String llI(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f1630lLi1LL;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    @SuppressLint({"InlinedApi"})
    public static int llliI(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static PorterDuff.Mode m2124llL1ii(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof iIi1) {
            return ((iIi1) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX INFO: renamed from: l丨 */
    public static void m76l(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f1630lLi1LL == null) {
            f1630lLi1LL = new WeakHashMap<>();
        }
        f1630lLi1LL.put(view, str);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2125lLi1LL(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            LIlLi(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                LIlLi((View) parent);
            }
        }
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public static boolean m2126lliiI1(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public static C0633lIII m2127li11(View view, C0633lIII c0633lIII) {
        if (Build.VERSION.SDK_INT < 21) {
            return c0633lIII;
        }
        WindowInsets windowInsets = (WindowInsets) C0633lIII.m2152L11I(c0633lIII);
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (!windowInsetsOnApplyWindowInsets.equals(windowInsets)) {
            windowInsets = new WindowInsets(windowInsetsOnApplyWindowInsets);
        }
        return C0633lIII.m2153il(windowInsets);
    }

    /* JADX INFO: renamed from: 丨1 */
    public static void m771(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public static void m21281iIl(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f);
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public static int m2129i11i(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public static void m2130i11LL(View view, PorterDuff.Mode mode) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            if (view instanceof iIi1) {
                ((iIi1) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (i == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public static float m2131iILLl(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static int m2132il() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f4060IL1Iii;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static boolean m2133lL(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public static int m2134l(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public static ViewParent m78(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public static int m2135LLlI1(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    @Deprecated
    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public static int m21361(View view) {
        return view.getMeasuredState();
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public static boolean m2137(View view) {
        Boolean boolM2150lLi1LL = IL1Iii().m2150lLi1LL(view);
        if (boolM2150lLi1LL == null) {
            return false;
        }
        return boolM2150lLi1LL.booleanValue();
    }
}
