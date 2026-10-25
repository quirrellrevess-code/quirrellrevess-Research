package ILil.p028IiL.p033iILLL1;

import ILil.p028IiL.ILL.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.I1I;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: TypefaceCompatApi26Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends IL {
    public final Method ILL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final Constructor f1715IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final Method f1716Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final Method f1717L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final Class f1718iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final Method f1719lIiI;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final Method f1720il;

    public iILLL1() throws NoSuchMethodException {
        Method methodLlliI;
        Constructor constructorM22871;
        Method methodM2285lL;
        Method methodI11L;
        Method methodM2282LlLLL;
        Method methodI11li1;
        Class cls = null;
        try {
            Class clsM2286l = m2286l();
            constructorM22871 = m22871(clsM2286l);
            methodM2285lL = m2285lL(clsM2286l);
            methodI11L = I11L(clsM2286l);
            methodM2282LlLLL = m2282LlLLL(clsM2286l);
            methodI11li1 = I11li1(clsM2286l);
            methodLlliI = llliI(clsM2286l);
            cls = clsM2286l;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            methodLlliI = null;
            constructorM22871 = null;
            methodM2285lL = null;
            methodI11L = null;
            methodM2282LlLLL = null;
            methodI11li1 = null;
        }
        this.f1718iILLL1 = cls;
        this.f1715IiL = constructorM22871;
        this.f1717L11I = methodM2285lL;
        this.f1720il = methodI11L;
        this.ILL = methodM2282LlLLL;
        this.f1716Ll1 = methodI11li1;
        this.f1719lIiI = methodLlliI;
    }

    private Object Lil() {
        try {
            return this.f1715IiL.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method I11L(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method I11li1(Class cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    @Override // ILil.p028IiL.p033iILLL1.IL, ILil.p028IiL.p033iILLL1.L11I
    public Typeface I1I(Context context, CancellationSignal cancellationSignal, ILil.iILLL1[] iilll1Arr, int i) {
        Typeface typefaceMo2273Ll1;
        if (iilll1Arr.length < 1) {
            return null;
        }
        if (!iIlLiL()) {
            ILil.iILLL1 iilll1M2277IiL = m2277IiL(iilll1Arr, i);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(iilll1M2277IiL.I1I(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(iilll1M2277IiL.m2020IL()).setItalic(iilll1M2277IiL.Ilil()).build();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapM2017L11I = ILil.m2017L11I(context, iilll1Arr, cancellationSignal);
        Object objLil = Lil();
        if (objLil == null) {
            return null;
        }
        boolean z = false;
        for (ILil.iILLL1 iilll1 : iilll1Arr) {
            ByteBuffer byteBuffer = mapM2017L11I.get(iilll1.I1I());
            if (byteBuffer != null) {
                if (!m2283lIlii(objLil, byteBuffer, iilll1.ILil(), iilll1.m2020IL(), iilll1.Ilil() ? 1 : 0)) {
                    LlLI1(objLil);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            LlLI1(objLil);
            return null;
        }
        if (iIi1(objLil) && (typefaceMo2273Ll1 = mo2273Ll1(objLil)) != null) {
            return Typeface.create(typefaceMo2273Ll1, i);
        }
        return null;
    }

    @Override // ILil.p028IiL.p033iILLL1.IL, ILil.p028IiL.p033iILLL1.L11I
    public Typeface ILil(Context context, I1I.ILil iLil, Resources resources, int i) {
        if (!iIlLiL()) {
            return super.ILil(context, iLil, resources, i);
        }
        Object objLil = Lil();
        if (objLil == null) {
            return null;
        }
        for (I1I.C0573I1I c0573i1i : iLil.IL1Iii()) {
            if (!m2284llL1ii(context, objLil, c0573i1i.IL1Iii(), c0573i1i.I1I(), c0573i1i.Ilil(), c0573i1i.m2301lLi1LL() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0573i1i.m2300IL()))) {
                LlLI1(objLil);
                return null;
            }
        }
        if (iIi1(objLil)) {
            return mo2273Ll1(objLil);
        }
        return null;
    }

    @Override // ILil.p028IiL.p033iILLL1.L11I
    public Typeface Ilil(Context context, Resources resources, int i, String str, int i2) {
        if (!iIlLiL()) {
            return super.Ilil(context, resources, i, str, i2);
        }
        Object objLil = Lil();
        if (objLil == null) {
            return null;
        }
        if (!m2284llL1ii(context, objLil, str, 0, -1, -1, null)) {
            LlLI1(objLil);
            return null;
        }
        if (iIi1(objLil)) {
            return mo2273Ll1(objLil);
        }
        return null;
    }

    public final void LlLI1(Object obj) {
        try {
            this.f1716Ll1.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* JADX INFO: renamed from: Ll丨1 */
    public Typeface mo2273Ll1(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f1718iILLL1, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f1719lIiI.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public Method m2282LlLLL(Class cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    public final boolean iIi1(Object obj) {
        try {
            return ((Boolean) this.ILL.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean iIlLiL() {
        if (this.f1717L11I == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1717L11I != null;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final boolean m2283lIlii(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f1720il.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method llliI(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final boolean m2284llL1ii(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1717L11I.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public Method m2285lL(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public Class m2286l() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public Constructor m22871(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
