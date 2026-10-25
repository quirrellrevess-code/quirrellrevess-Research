package ILil.p028IiL.p033iILLL1;

import ILil.p028IiL.ILL.ILil;
import ILil.p028IiL.p035lLi1LL.I1I.I1I;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: TypefaceCompatApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends L11I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Constructor f4187I1I = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Class f4188ILil = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static Method f4189Ilil = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Method f1713IL = null;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean f1714lLi1LL = false;

    public static boolean ILL(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        m2270ILl();
        try {
            return ((Boolean) f1713IL.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static void m2270ILl() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f1714lLi1LL) {
            return;
        }
        f1714lLi1LL = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        f4187I1I = constructor;
        f4188ILil = cls;
        f1713IL = method2;
        f4189Ilil = method;
    }

    public static Object Lil() throws NoSuchMethodException {
        m2270ILl();
        try {
            return f4187I1I.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static Typeface m2271Ll1(Object obj) throws NoSuchMethodException {
        m2270ILl();
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f4188ILil, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f4189Ilil.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // ILil.p028IiL.p033iILLL1.L11I
    public Typeface I1I(Context context, CancellationSignal cancellationSignal, ILil.iILLL1[] iilll1Arr, int i) {
        if (iilll1Arr.length < 1) {
            return null;
        }
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
                File fileM2272lIiI = m2272lIiI(parcelFileDescriptorOpenFileDescriptor);
                if (fileM2272lIiI != null && fileM2272lIiI.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM2272lIiI);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceM2276IL = super.m2276IL(context, fileInputStream);
                    fileInputStream.close();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceM2276IL;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // ILil.p028IiL.p033iILLL1.L11I
    public Typeface ILil(Context context, I1I.ILil iLil, Resources resources, int i) throws NoSuchMethodException {
        Object objLil = Lil();
        for (I1I.C0573I1I c0573i1i : iLil.IL1Iii()) {
            File fileIlil = C0637il.Ilil(context);
            if (fileIlil == null) {
                return null;
            }
            try {
                if (!C0637il.I1I(fileIlil, resources, c0573i1i.ILil())) {
                    return null;
                }
                if (!ILL(objLil, fileIlil.getPath(), c0573i1i.Ilil(), c0573i1i.m2301lLi1LL())) {
                    return null;
                }
                fileIlil.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileIlil.delete();
            }
        }
        return m2271Ll1(objLil);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final File m2272lIiI(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }
}
