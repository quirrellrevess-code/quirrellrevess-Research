package ILil.ILil.p023lIlii;

import ILil.p043lIlii.IL1Iii.IL1Iii.L11I;
import ILil.p065Ilil.Lil;
import ILil.p065Ilil.Ll1;
import ILil.p065Ilil.LlLI1;
import ILil.p065Ilil.iIi1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourceManagerInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class I11L {

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static I11L f1337L11I;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public iIi1<String> f3747I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public WeakHashMap<Context, iIi1<ColorStateList>> f3748IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Ll1<String, IL> f3749ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public TypedValue f3750Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final WeakHashMap<Context, Lil<WeakReference<Drawable.ConstantState>>> f1339IL = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public lLi1LL f1340iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1341lLi1LL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final PorterDuff.Mode f1336IiL = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final I1I f1338il = new I1I(6);

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public static class I1I extends LlLI1<Integer, PorterDuffColorFilter> {
        public I1I(int i) {
            super(i);
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public static int m1701IiL(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public PorterDuffColorFilter m1702L11I(int i, PorterDuff.Mode mode) {
            return I1I(Integer.valueOf(m1701IiL(i, mode)));
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public PorterDuffColorFilter m1703il(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return m1949IL(Integer.valueOf(m1701IiL(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public static class IL1Iii implements IL {
        @Override // ILil.ILil.p023lIlii.I11L.IL
        public Drawable IL1Iii(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return ILil.ILil.p020ILl.IL1Iii.IL1Iii.m1606lIiI(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public static class ILil implements IL {
        @Override // ILil.ILil.p023lIlii.I11L.IL
        public Drawable IL1Iii(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return ILil.p043lIlii.IL1Iii.IL1Iii.ILil.IL1Iii(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.I11L$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public interface IL {
        Drawable IL1Iii(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.I11L$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public static class iILLL1 implements IL {
        @Override // ILil.ILil.p023lIlii.I11L.IL
        public Drawable IL1Iii(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return L11I.I1I(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.I11L$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public interface lLi1LL {
        Drawable I1I(I11L i11l, Context context, int i);

        boolean IL1Iii(Context context, int i, Drawable drawable);

        PorterDuff.Mode ILil(int i);

        boolean Ilil(Context context, int i, Drawable drawable);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        ColorStateList mo1704IL(Context context, int i);
    }

    public static void I11L(Drawable drawable, C0627LLlI1 c0627LLlI1, int[] iArr) {
        if (llL1ii.IL1Iii(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = c0627LLlI1.f1431IL;
        if (z || c0627LLlI1.f3849I1I) {
            drawable.setColorFilter(m1691iILLL1(z ? c0627LLlI1.f3850IL1Iii : null, c0627LLlI1.f3849I1I ? c0627LLlI1.f3851ILil : f1336IiL, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static long Ilil(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static synchronized I11L m1689IiL() {
        if (f1337L11I == null) {
            I11L i11l = new I11L();
            f1337L11I = i11l;
            LlLI1(i11l);
        }
        return f1337L11I;
    }

    public static void LlLI1(I11L i11l) {
        if (Build.VERSION.SDK_INT < 24) {
            i11l.IL1Iii("vector", new iILLL1());
            i11l.IL1Iii("animated-vector", new ILil());
            i11l.IL1Iii("animated-selector", new IL1Iii());
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static synchronized PorterDuffColorFilter m1690Ll1(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM1702L11I;
        I1I i1i = f1338il;
        porterDuffColorFilterM1702L11I = i1i.m1702L11I(i, mode);
        if (porterDuffColorFilterM1702L11I == null) {
            porterDuffColorFilterM1702L11I = new PorterDuffColorFilter(i, mode);
            i1i.m1703il(i, mode, porterDuffColorFilterM1702L11I);
        }
        return porterDuffColorFilterM1702L11I;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static PorterDuffColorFilter m1691iILLL1(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m1690Ll1(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static boolean m1692llL1ii(Drawable drawable) {
        return (drawable instanceof L11I) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public synchronized void I11li1(lLi1LL lli1ll) {
        this.f1340iILLL1 = lli1ll;
    }

    public final void I1I(Context context, int i, ColorStateList colorStateList) {
        if (this.f3748IL1Iii == null) {
            this.f3748IL1Iii = new WeakHashMap<>();
        }
        iIi1<ColorStateList> iii1 = this.f3748IL1Iii.get(context);
        if (iii1 == null) {
            iii1 = new iIi1<>();
            this.f3748IL1Iii.put(context, iii1);
        }
        iii1.IL1Iii(i, colorStateList);
    }

    public final void IL1Iii(String str, IL il) {
        if (this.f3749ILil == null) {
            this.f3749ILil = new Ll1<>();
        }
        this.f3749ILil.put(str, il);
    }

    public synchronized Drawable ILL(Context context, int i, boolean z) {
        Drawable drawableM1697lIlii;
        m1694IL(context);
        drawableM1697lIlii = m1697lIlii(context, i);
        if (drawableM1697lIlii == null) {
            drawableM1697lIlii = m1698lLi1LL(context, i);
        }
        if (drawableM1697lIlii == null) {
            drawableM1697lIlii = ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(context, i);
        }
        if (drawableM1697lIlii != null) {
            drawableM1697lIlii = m1700lL(context, i, z, drawableM1697lIlii);
        }
        if (drawableM1697lIlii != null) {
            llL1ii.ILil(drawableM1697lIlii);
        }
        return drawableM1697lIlii;
    }

    public final synchronized boolean ILil(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        Lil<WeakReference<Drawable.ConstantState>> lil = this.f1339IL.get(context);
        if (lil == null) {
            lil = new Lil<>();
            this.f1339IL.put(context, lil);
        }
        lil.ILL(j, new WeakReference<>(constantState));
        return true;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final ColorStateList m1693ILl(Context context, int i) {
        iIi1<ColorStateList> iii1;
        WeakHashMap<Context, iIi1<ColorStateList>> weakHashMap = this.f3748IL1Iii;
        if (weakHashMap == null || (iii1 = weakHashMap.get(context)) == null) {
            return null;
        }
        return iii1.Ilil(i);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1694IL(Context context) {
        if (this.f1341lLi1LL) {
            return;
        }
        this.f1341lLi1LL = true;
        Drawable drawableM1699il = m1699il(context, ILil.ILil.Lil.IL1Iii.abc_vector_test);
        if (drawableM1699il == null || !m1692llL1ii(drawableM1699il)) {
            this.f1341lLi1LL = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public PorterDuff.Mode Lil(int i) {
        lLi1LL lli1ll = this.f1340iILLL1;
        if (lli1ll == null) {
            return null;
        }
        return lli1ll.ILil(i);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final synchronized Drawable m1695L11I(Context context, long j) {
        Lil<WeakReference<Drawable.ConstantState>> lil = this.f1339IL.get(context);
        if (lil == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceM1947lLi1LL = lil.m1947lLi1LL(j);
        if (weakReferenceM1947lLi1LL != null) {
            Drawable.ConstantState constantState = weakReferenceM1947lLi1LL.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            lil.m1942IL(j);
        }
        return null;
    }

    public synchronized void iIi1(Context context) {
        Lil<WeakReference<Drawable.ConstantState>> lil = this.f1339IL.get(context);
        if (lil != null) {
            lil.ILil();
        }
    }

    public synchronized Drawable iIlLiL(Context context, LIll lIll, int i) {
        Drawable drawableM1697lIlii = m1697lIlii(context, i);
        if (drawableM1697lIlii == null) {
            drawableM1697lIlii = lIll.I1I(i);
        }
        if (drawableM1697lIlii == null) {
            return null;
        }
        return m1700lL(context, i, false, drawableM1697lIlii);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public synchronized ColorStateList m1696lIiI(Context context, int i) {
        ColorStateList colorStateListM1693ILl;
        colorStateListM1693ILl = m1693ILl(context, i);
        if (colorStateListM1693ILl == null) {
            lLi1LL lli1ll = this.f1340iILLL1;
            colorStateListM1693ILl = lli1ll == null ? null : lli1ll.mo1704IL(context, i);
            if (colorStateListM1693ILl != null) {
                I1I(context, i, colorStateListM1693ILl);
            }
        }
        return colorStateListM1693ILl;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final Drawable m1697lIlii(Context context, int i) {
        int next;
        Ll1<String, IL> ll1 = this.f3749ILil;
        if (ll1 == null || ll1.isEmpty()) {
            return null;
        }
        iIi1<String> iii1 = this.f3747I1I;
        if (iii1 != null) {
            String strIlil = iii1.Ilil(i);
            if ("appcompat_skip_skip".equals(strIlil) || (strIlil != null && this.f3749ILil.get(strIlil) == null)) {
                return null;
            }
        } else {
            this.f3747I1I = new iIi1<>();
        }
        if (this.f3750Ilil == null) {
            this.f3750Ilil = new TypedValue();
        }
        TypedValue typedValue = this.f3750Ilil;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jIlil = Ilil(typedValue);
        Drawable drawableM1695L11I = m1695L11I(context, jIlil);
        if (drawableM1695L11I != null) {
            return drawableM1695L11I;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f3747I1I.IL1Iii(i, name);
                IL il = this.f3749ILil.get(name);
                if (il != null) {
                    drawableM1695L11I = il.IL1Iii(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM1695L11I != null) {
                    drawableM1695L11I.setChangingConfigurations(typedValue.changingConfigurations);
                    ILil(context, jIlil, drawableM1695L11I);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableM1695L11I == null) {
            this.f3747I1I.IL1Iii(i, "appcompat_skip_skip");
        }
        return drawableM1695L11I;
    }

    public boolean llliI(Context context, int i, Drawable drawable) {
        lLi1LL lli1ll = this.f1340iILLL1;
        return lli1ll != null && lli1ll.IL1Iii(context, i, drawable);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Drawable m1698lLi1LL(Context context, int i) {
        if (this.f3750Ilil == null) {
            this.f3750Ilil = new TypedValue();
        }
        TypedValue typedValue = this.f3750Ilil;
        context.getResources().getValue(i, typedValue, true);
        long jIlil = Ilil(typedValue);
        Drawable drawableM1695L11I = m1695L11I(context, jIlil);
        if (drawableM1695L11I != null) {
            return drawableM1695L11I;
        }
        lLi1LL lli1ll = this.f1340iILLL1;
        Drawable drawableI1I = lli1ll == null ? null : lli1ll.I1I(this, context, i);
        if (drawableI1I != null) {
            drawableI1I.setChangingConfigurations(typedValue.changingConfigurations);
            ILil(context, jIlil, drawableI1I);
        }
        return drawableI1I;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public synchronized Drawable m1699il(Context context, int i) {
        return ILL(context, i, false);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final Drawable m1700lL(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListM1696lIiI = m1696lIiI(context, i);
        if (colorStateListM1696lIiI == null) {
            lLi1LL lli1ll = this.f1340iILLL1;
            if ((lli1ll == null || !lli1ll.Ilil(context, i, drawable)) && !llliI(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (llL1ii.IL1Iii(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableM2256lIlii = ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2256lIlii(drawable);
        ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawableM2256lIlii, colorStateListM1696lIiI);
        PorterDuff.Mode modeLil = Lil(i);
        if (modeLil == null) {
            return drawableM2256lIlii;
        }
        ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(drawableM2256lIlii, modeLil);
        return drawableM2256lIlii;
    }
}
