package ILil.p028IiL.p033iILLL1;

import ILil.p028IiL.ILL.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.I1I;
import ILil.p065Ilil.lIlii;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: TypefaceCompatApi24Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL extends L11I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Constructor f4191I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final Class f4192ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Method f4193Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Method f1721IL;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f4191I1I = constructor;
        f4192ILil = cls;
        f1721IL = method2;
        f4193Ilil = method;
    }

    public static boolean ILL(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1721IL.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static Object m2288ILl() {
        try {
            return f4191I1I.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static Typeface m2289Ll1(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f4192ILil, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f4193Ilil.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static boolean m2290lIiI() {
        Method method = f1721IL;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    @Override // ILil.p028IiL.p033iILLL1.L11I
    public Typeface I1I(Context context, CancellationSignal cancellationSignal, ILil.iILLL1[] iilll1Arr, int i) {
        Object objM2288ILl = m2288ILl();
        if (objM2288ILl == null) {
            return null;
        }
        lIlii lilii = new lIlii();
        for (ILil.iILLL1 iilll1 : iilll1Arr) {
            Uri uriI1I = iilll1.I1I();
            ByteBuffer byteBufferM2293lLi1LL = (ByteBuffer) lilii.get(uriI1I);
            if (byteBufferM2293lLi1LL == null) {
                byteBufferM2293lLi1LL = C0637il.m2293lLi1LL(context, cancellationSignal, uriI1I);
                lilii.put(uriI1I, byteBufferM2293lLi1LL);
            }
            if (byteBufferM2293lLi1LL == null || !ILL(objM2288ILl, byteBufferM2293lLi1LL, iilll1.ILil(), iilll1.m2020IL(), iilll1.Ilil())) {
                return null;
            }
        }
        Typeface typefaceM2289Ll1 = m2289Ll1(objM2288ILl);
        if (typefaceM2289Ll1 == null) {
            return null;
        }
        return Typeface.create(typefaceM2289Ll1, i);
    }

    @Override // ILil.p028IiL.p033iILLL1.L11I
    public Typeface ILil(Context context, I1I.ILil iLil, Resources resources, int i) {
        Object objM2288ILl = m2288ILl();
        if (objM2288ILl == null) {
            return null;
        }
        for (I1I.C0573I1I c0573i1i : iLil.IL1Iii()) {
            ByteBuffer byteBufferILil = C0637il.ILil(context, resources, c0573i1i.ILil());
            if (byteBufferILil == null || !ILL(objM2288ILl, byteBufferILil, c0573i1i.I1I(), c0573i1i.Ilil(), c0573i1i.m2301lLi1LL())) {
                return null;
            }
        }
        return m2289Ll1(objM2288ILl);
    }
}
