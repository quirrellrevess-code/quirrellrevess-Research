package ILil.p028IiL.p033iILLL1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ConcurrentHashMap<Long, ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil> f4190IL1Iii = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.L丨1丨1丨I$I1I */
    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    public interface I1I<T> {
        int IL1Iii(T t);

        boolean ILil(T t);
    }

    /* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    public class IL1Iii implements I1I<ILil.p028IiL.ILL.ILil.iILLL1> {
        public IL1Iii(L11I l11i) {
        }

        @Override // ILil.p028IiL.p033iILLL1.L11I.I1I
        /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
        public int IL1Iii(ILil.p028IiL.ILL.ILil.iILLL1 iilll1) {
            return iilll1.m2020IL();
        }

        @Override // ILil.p028IiL.p033iILLL1.L11I.I1I
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean ILil(ILil.p028IiL.ILL.ILil.iILLL1 iilll1) {
            return iilll1.Ilil();
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.L丨1丨1丨I$ILil */
    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    public class ILil implements I1I<ILil.p028IiL.p035lLi1LL.I1I.I1I.C0573I1I> {
        public ILil(L11I l11i) {
        }

        @Override // ILil.p028IiL.p033iILLL1.L11I.I1I
        /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
        public int IL1Iii(ILil.p028IiL.p035lLi1LL.I1I.I1I.C0573I1I c0573i1i) {
            return c0573i1i.Ilil();
        }

        @Override // ILil.p028IiL.p033iILLL1.L11I.I1I
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean ILil(ILil.p028IiL.p035lLi1LL.I1I.I1I.C0573I1I c0573i1i) {
            return c0573i1i.m2301lLi1LL();
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static <T> T m2274iILLL1(T[] tArr, int i, I1I<T> i1i) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(i1i.IL1Iii(t2) - i2) * 2) + (i1i.ILil(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static long m2275il(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    public Typeface I1I(Context context, CancellationSignal cancellationSignal, ILil.p028IiL.ILL.ILil.iILLL1[] iilll1Arr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (iilll1Arr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(m2277IiL(iilll1Arr, i).I1I());
            try {
                Typeface typefaceM2276IL = m2276IL(context, inputStreamOpenInputStream);
                C0637il.IL1Iii(inputStreamOpenInputStream);
                return typefaceM2276IL;
            } catch (IOException unused) {
                C0637il.IL1Iii(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                C0637il.IL1Iii(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void IL1Iii(Typeface typeface, ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil iLil) {
        long jM2275il = m2275il(typeface);
        if (jM2275il != 0) {
            this.f4190IL1Iii.put(Long.valueOf(jM2275il), iLil);
        }
    }

    public Typeface ILil(Context context, ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil iLil, Resources resources, int i) {
        ILil.p028IiL.p035lLi1LL.I1I.I1I.C0573I1I c0573i1iM2279lLi1LL = m2279lLi1LL(iLil, i);
        if (c0573i1iM2279lLi1LL == null) {
            return null;
        }
        Typeface typefaceM2245IL = ILil.p028IiL.p033iILLL1.I1I.m2245IL(context, resources, c0573i1iM2279lLi1LL.ILil(), c0573i1iM2279lLi1LL.IL1Iii(), i);
        IL1Iii(typefaceM2245IL, iLil);
        return typefaceM2245IL;
    }

    public Typeface Ilil(Context context, Resources resources, int i, String str, int i2) {
        File fileIlil = C0637il.Ilil(context);
        if (fileIlil == null) {
            return null;
        }
        try {
            if (C0637il.I1I(fileIlil, resources, i)) {
                return Typeface.createFromFile(fileIlil.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileIlil.delete();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Typeface m2276IL(Context context, InputStream inputStream) {
        File fileIlil = C0637il.Ilil(context);
        if (fileIlil == null) {
            return null;
        }
        try {
            if (C0637il.m2291IL(fileIlil, inputStream)) {
                return Typeface.createFromFile(fileIlil.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileIlil.delete();
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ILil.p028IiL.ILL.ILil.iILLL1 m2277IiL(ILil.p028IiL.ILL.ILil.iILLL1[] iilll1Arr, int i) {
        return (ILil.p028IiL.ILL.ILil.iILLL1) m2274iILLL1(iilll1Arr, i, new IL1Iii(this));
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil m2278L11I(Typeface typeface) {
        long jM2275il = m2275il(typeface);
        if (jM2275il == 0) {
            return null;
        }
        return this.f4190IL1Iii.get(Long.valueOf(jM2275il));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final ILil.p028IiL.p035lLi1LL.I1I.I1I.C0573I1I m2279lLi1LL(ILil.I丨iL.l丨Li1LL.I1I.I1I.ILil iLil, int i) {
        return (ILil.p028IiL.p035lLi1LL.I1I.I1I.C0573I1I) m2274iILLL1(iLil.IL1Iii(), i, new ILil(this));
    }
}
