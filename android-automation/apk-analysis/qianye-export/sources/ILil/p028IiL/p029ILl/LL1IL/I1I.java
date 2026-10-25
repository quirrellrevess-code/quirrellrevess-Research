package ILil.p028IiL.p029ILl.LL1IL;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.opencv.calib3d.Calib3d;

/* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int f1613IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final AccessibilityNodeInfo f4045IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4046ILil = -1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4044I1I = -1;

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.LL1IL.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class C0564I1I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Object f4047IL1Iii;

        public C0564I1I(Object obj) {
            this.f4047IL1Iii = obj;
        }

        public static C0564I1I IL1Iii(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new C0564I1I(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            return i5 >= 19 ? new C0564I1I(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new C0564I1I(null);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class IL1Iii {
        public static final IL1Iii ILL;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public static final IL1Iii f1614ILl;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public static final IL1Iii f1615IiL;
        public static final IL1Iii Lil;
        public static final IL1Iii LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public static final IL1Iii f1616Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public static final IL1Iii f1617L11I;
        public static final IL1Iii iIi1;
        public static final IL1Iii iIlLiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public static final IL1Iii f1618iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public static final IL1Iii f1619lIiI;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public static final IL1Iii f1620lIlii;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public static final IL1Iii f1621llL1ii;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public static final IL1Iii f1623il;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Class<? extends iILLL1.IL1Iii> f4049I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Object f4050IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f4051ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final iILLL1 f1624IL;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public static final IL1Iii f4048Ilil = new IL1Iii(1, null);

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public static final IL1Iii f1622lLi1LL = new IL1Iii(2, null);

        static {
            new IL1Iii(4, null);
            new IL1Iii(8, null);
            f1618iILLL1 = new IL1Iii(16, null);
            new IL1Iii(32, null);
            new IL1Iii(64, null);
            new IL1Iii(128, null);
            new IL1Iii(256, null, iILLL1.ILil.class);
            new IL1Iii(512, null, iILLL1.ILil.class);
            new IL1Iii(1024, null, iILLL1.I1I.class);
            new IL1Iii(2048, null, iILLL1.I1I.class);
            f1615IiL = new IL1Iii(4096, null);
            f1617L11I = new IL1Iii(8192, null);
            new IL1Iii(16384, null);
            new IL1Iii(32768, null);
            new IL1Iii(65536, null);
            new IL1Iii(131072, null, iILLL1.IiL.class);
            f1623il = new IL1Iii(Calib3d.CALIB_TILTED_MODEL, null);
            ILL = new IL1Iii(Calib3d.CALIB_FIX_TAUX_TAUY, null);
            f1616Ll1 = new IL1Iii(1048576, null);
            new IL1Iii(Calib3d.CALIB_FIX_TANGENT_DIST, null, iILLL1.L11I.class);
            int i = Build.VERSION.SDK_INT;
            f1619lIiI = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            f1614ILl = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, iILLL1.lLi1LL.class);
            Lil = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            LlLI1 = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            f1621llL1ii = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            f1620lIlii = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            iIi1 = new IL1Iii(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            iIlLiL = new IL1Iii(i >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, iILLL1.C0565iILLL1.class);
            new IL1Iii(i >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, iILLL1.IL.class);
            new IL1Iii(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new IL1Iii(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public IL1Iii(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        public boolean I1I(View view, Bundle bundle) {
            if (this.f1624IL == null) {
                return false;
            }
            iILLL1.IL1Iii iL1Iii = null;
            Class<? extends iILLL1.IL1Iii> cls = this.f4049I1I;
            if (cls != null) {
                try {
                    iILLL1.IL1Iii iL1IiiNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        iL1IiiNewInstance.IL1Iii(bundle);
                        iL1Iii = iL1IiiNewInstance;
                    } catch (Exception e) {
                        e = e;
                        iL1Iii = iL1IiiNewInstance;
                        Class<? extends iILLL1.IL1Iii> cls2 = this.f4049I1I;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return this.f1624IL.perform(view, iL1Iii);
        }

        public IL1Iii IL1Iii(CharSequence charSequence, iILLL1 iilll1) {
            return new IL1Iii(null, this.f4051ILil, charSequence, iilll1, this.f4049I1I);
        }

        public int ILil() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f4050IL1Iii).getId();
            }
            return 0;
        }

        public IL1Iii(int i, CharSequence charSequence, Class<? extends iILLL1.IL1Iii> cls) {
            this(null, i, charSequence, null, cls);
        }

        public IL1Iii(Object obj, int i, CharSequence charSequence, iILLL1 iilll1, Class<? extends iILLL1.IL1Iii> cls) {
            this.f4051ILil = i;
            this.f1624IL = iilll1;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f4050IL1Iii = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.f4050IL1Iii = obj;
            }
            this.f4049I1I = cls;
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Object f4052IL1Iii;

        public ILil(Object obj) {
            this.f4052IL1Iii = obj;
        }

        public static ILil IL1Iii(int i, int i2, boolean z) {
            return Build.VERSION.SDK_INT >= 19 ? new ILil(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new ILil(null);
        }

        public static ILil ILil(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return new ILil(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            return i4 >= 19 ? new ILil(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new ILil(null);
        }
    }

    public I1I(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4045IL1Iii = accessibilityNodeInfo;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public static I1I m2044L11(I1I i1i) {
        return LII(AccessibilityNodeInfo.obtain(i1i.f4045IL1Iii));
    }

    public static I1I LII(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new I1I(accessibilityNodeInfo);
    }

    public static ClickableSpan[] LlLI1(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static String m2045L11I(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public static I1I m2046ill() {
        return LII(AccessibilityNodeInfo.obtain());
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public static I1I m2047(View view) {
        return LII(AccessibilityNodeInfo.obtain(view));
    }

    /* JADX INFO: renamed from: I1 */
    public void m61I1(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4045IL1Iii.setDismissable(z);
        }
    }

    public String I11L() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f4045IL1Iii.getViewIdResourceName();
        }
        return null;
    }

    public final SparseArray<WeakReference<ClickableSpan>> I11li1(View view) {
        return (SparseArray) view.getTag(ILil.p028IiL.I1I.tag_accessibility_clickable_spans);
    }

    public void I1I(View view) {
        this.f4045IL1Iii.addChild(view);
    }

    public void I1IILIIL(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4045IL1Iii.setHeading(z);
        } else {
            m2048I1L11L(2, z);
        }
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public final void m2048I1L11L(int i, boolean z) {
        Bundle bundleM2076lIlii = m2076lIlii();
        if (bundleM2076lIlii != null) {
            int i2 = bundleM2076lIlii.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            bundleM2076lIlii.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public void m2049IIiI() {
        this.f4045IL1Iii.recycle();
    }

    public void IL1Iii(int i) {
        this.f4045IL1Iii.addAction(i);
    }

    public void ILI1Ll(CharSequence charSequence) {
        this.f4045IL1Iii.setText(charSequence);
    }

    public final boolean ILL(int i) {
        Bundle bundleM2076lIlii = m2076lIlii();
        return bundleM2076lIlii != null && (bundleM2076lIlii.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public void m2050ILLIi(Rect rect) {
        this.f4045IL1Iii.setBoundsInParent(rect);
    }

    public void ILil(IL1Iii iL1Iii) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4045IL1Iii.addAction((AccessibilityNodeInfo.AccessibilityAction) iL1Iii.f4050IL1Iii);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int m2051ILl() {
        return this.f4045IL1Iii.getChildCount();
    }

    public final void Ilil(ClickableSpan clickableSpan, Spanned spanned, int i) {
        m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: I丨 */
    public void m62I(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4045IL1Iii.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0564I1I) obj).f4047IL1Iii);
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public boolean m2052IIi() {
        return Build.VERSION.SDK_INT >= 26 ? this.f4045IL1Iii.isShowingHintText() : ILL(4);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2053IL(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4045IL1Iii.addChild(view, i);
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final List<Integer> m2054IiL(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f4045IL1Iii.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f4045IL1Iii.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean m2055L111() {
        return this.f4045IL1Iii.isEnabled();
    }

    public void L1iI1(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4045IL1Iii.setError(charSequence);
        }
    }

    public void LI11(View view) {
        this.f4046ILil = -1;
        this.f4045IL1Iii.setParent(view);
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public void m2056LIl(CharSequence charSequence) {
        this.f4045IL1Iii.setClassName(charSequence);
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public boolean m2057LIll() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f4045IL1Iii.isVisibleToUser();
        }
        return false;
    }

    /* JADX INFO: renamed from: LL */
    public void m63LL(boolean z) {
        this.f4045IL1Iii.setScrollable(z);
    }

    public boolean LL1IL() {
        return this.f4045IL1Iii.isClickable();
    }

    public final void LLL(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayI11li1 = I11li1(view);
        if (sparseArrayI11li1 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sparseArrayI11li1.size(); i++) {
                if (sparseArrayI11li1.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayI11li1.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public void LiL1(View view, int i) {
        this.f4046ILil = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4045IL1Iii.setParent(view, i);
        }
    }

    public void Liil1L1l(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4045IL1Iii.setScreenReaderFocusable(z);
        } else {
            m2048I1L11L(1, z);
        }
    }

    public CharSequence Lil() {
        return this.f4045IL1Iii.getClassName();
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public boolean m2058LlIl(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f4045IL1Iii.performAction(i, bundle);
        }
        return false;
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public void m2059LlLiLL(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4045IL1Iii.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((ILil) obj).f4052IL1Iii);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2060Ll1(Rect rect) {
        this.f4045IL1Iii.getBoundsInParent(rect);
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public boolean m2061L1l() {
        return this.f4045IL1Iii.isScrollable();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m2062LlLLL() {
        return this.f4045IL1Iii.isCheckable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || I1I.class != obj.getClass()) {
            return false;
        }
        I1I i1i = (I1I) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4045IL1Iii;
        if (accessibilityNodeInfo == null) {
            if (i1i.f4045IL1Iii != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(i1i.f4045IL1Iii)) {
            return false;
        }
        return this.f4044I1I == i1i.f4044I1I && this.f4046ILil == i1i.f4046ILil;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4045IL1Iii;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* JADX INFO: renamed from: i1 */
    public void m64i1(boolean z) {
        this.f4045IL1Iii.setCheckable(z);
    }

    /* JADX INFO: renamed from: iI */
    public void m65iI(boolean z) {
        this.f4045IL1Iii.setClickable(z);
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public void m2063iI1iI(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4045IL1Iii.setAccessibilityFocused(z);
        }
    }

    public final SparseArray<WeakReference<ClickableSpan>> iIi1(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayI11li1 = I11li1(view);
        if (sparseArrayI11li1 != null) {
            return sparseArrayI11li1;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(ILil.p028IiL.I1I.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void iIilII1(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4045IL1Iii.setCanOpenPopup(z);
        }
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public void m2064iIl1il(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f4045IL1Iii.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f4045IL1Iii.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public CharSequence iIlLiL() {
        return this.f4045IL1Iii.getPackageName();
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public void m2065iI1LI(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4045IL1Iii.setShowingHintText(z);
        } else {
            m2048I1L11L(4, z);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m2066iILLL1() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4045IL1Iii.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f4045IL1Iii.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f4045IL1Iii.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f4045IL1Iii.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public void m2067iILilI(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4045IL1Iii.setContentInvalid(z);
        }
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public void m2068iiIIi11(CharSequence charSequence) {
        this.f4045IL1Iii.setContentDescription(charSequence);
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public void m2069ili11(boolean z) {
        this.f4045IL1Iii.setChecked(z);
    }

    public void ill1LI1l(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f4045IL1Iii.setHintText(charSequence);
        } else if (i >= 19) {
            this.f4045IL1Iii.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public void m2070i1I1I1l(boolean z) {
        this.f4045IL1Iii.setSelected(z);
    }

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public void m2071iILiiLl(View view, int i) {
        this.f4044I1I = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4045IL1Iii.setSource(view, i);
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public boolean m2072l1IIi1() {
        return this.f4045IL1Iii.isPassword();
    }

    public void l1Lll(boolean z) {
        this.f4045IL1Iii.setFocused(z);
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public void m2073lIIiIlL(boolean z) {
        this.f4045IL1Iii.setLongClickable(z);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m2074lIiI(Rect rect) {
        this.f4045IL1Iii.getBoundsInScreen(rect);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean m2075lIII() {
        return this.f4045IL1Iii.isChecked();
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public Bundle m2076lIlii() {
        return Build.VERSION.SDK_INT >= 19 ? this.f4045IL1Iii.getExtras() : new Bundle();
    }

    /* JADX INFO: renamed from: lL */
    public void m66lL(boolean z) {
        this.f4045IL1Iii.setFocusable(z);
    }

    public boolean llI() {
        return this.f4045IL1Iii.isLongClickable();
    }

    public final boolean llliI() {
        return !m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public CharSequence m2077llL1ii() {
        return this.f4045IL1Iii.getContentDescription();
    }

    /* JADX INFO: renamed from: l丨 */
    public void m67l(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f4045IL1Iii.setVisibleToUser(z);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2078lLi1LL(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 26) {
            return;
        }
        m2066iILLL1();
        LLL(view);
        ClickableSpan[] clickableSpanArrLlLI1 = LlLI1(charSequence);
        if (clickableSpanArrLlLI1 == null || clickableSpanArrLlLI1.length <= 0) {
            return;
        }
        m2076lIlii().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", ILil.p028IiL.I1I.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArrayIIi1 = iIi1(view);
        for (int i2 = 0; clickableSpanArrLlLI1 != null && i2 < clickableSpanArrLlLI1.length; i2++) {
            int iM2087l = m2087l(clickableSpanArrLlLI1[i2], sparseArrayIIi1);
            sparseArrayIIi1.put(iM2087l, new WeakReference<>(clickableSpanArrLlLI1[i2]));
            Ilil(clickableSpanArrLlLI1[i2], (Spanned) charSequence, iM2087l);
        }
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public boolean m2079lliiI1(IL1Iii iL1Iii) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f4045IL1Iii.removeAction((AccessibilityNodeInfo.AccessibilityAction) iL1Iii.f4050IL1Iii);
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public void m2080li11(Rect rect) {
        this.f4045IL1Iii.setBoundsInScreen(rect);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m2060Ll1(rect);
        sb.append("; boundsInParent: " + rect);
        m2074lIiI(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(iIlLiL());
        sb.append("; className: ");
        sb.append(Lil());
        sb.append("; text: ");
        sb.append(m2086lL());
        sb.append("; contentDescription: ");
        sb.append(m2077llL1ii());
        sb.append("; viewId: ");
        sb.append(I11L());
        sb.append("; checkable: ");
        sb.append(m2062LlLLL());
        sb.append("; checked: ");
        sb.append(m2075lIII());
        sb.append("; focusable: ");
        sb.append(m2088LLlI1());
        sb.append("; focused: ");
        sb.append(m69());
        sb.append("; selected: ");
        sb.append(m2084iILLl());
        sb.append("; clickable: ");
        sb.append(LL1IL());
        sb.append("; longClickable: ");
        sb.append(llI());
        sb.append("; enabled: ");
        sb.append(m2055L111());
        sb.append("; password: ");
        sb.append(m2072l1IIi1());
        sb.append("; scrollable: " + m2061L1l());
        sb.append("; [");
        int iM2085il = m2085il();
        while (iM2085il != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iM2085il);
            iM2085il &= ~iNumberOfTrailingZeros;
            sb.append(m2045L11I(iNumberOfTrailingZeros));
            if (iM2085il != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨1 */
    public void m681(View view) {
        this.f4044I1I = -1;
        this.f4045IL1Iii.setSource(view);
    }

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public AccessibilityNodeInfo m20811iIl() {
        return this.f4045IL1Iii;
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public void m2082i11i(boolean z) {
        this.f4045IL1Iii.setEnabled(z);
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public void m2083i11LL(CharSequence charSequence) {
        this.f4045IL1Iii.setPackageName(charSequence);
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public boolean m2084iILLl() {
        return this.f4045IL1Iii.isSelected();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m2085il() {
        return this.f4045IL1Iii.getActions();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public CharSequence m2086lL() {
        if (!llliI()) {
            return this.f4045IL1Iii.getText();
        }
        List<Integer> listM2054IiL = m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listM2054IiL2 = m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listM2054IiL3 = m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listM2054IiL4 = m2054IiL("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f4045IL1Iii.getText(), 0, this.f4045IL1Iii.getText().length()));
        for (int i = 0; i < listM2054IiL.size(); i++) {
            spannableString.setSpan(new ILil.p028IiL.p029ILl.LL1IL.IL1Iii(listM2054IiL4.get(i).intValue(), this, m2076lIlii().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listM2054IiL.get(i).intValue(), listM2054IiL2.get(i).intValue(), listM2054IiL3.get(i).intValue());
        }
        return spannableString;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final int m2087l(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f1613IL;
        f1613IL = i2 + 1;
        return i2;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public boolean m69() {
        return this.f4045IL1Iii.isFocused();
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public boolean m2088LLlI1() {
        return this.f4045IL1Iii.isFocusable();
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m20891() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f4045IL1Iii.isAccessibilityFocused();
        }
        return false;
    }
}
