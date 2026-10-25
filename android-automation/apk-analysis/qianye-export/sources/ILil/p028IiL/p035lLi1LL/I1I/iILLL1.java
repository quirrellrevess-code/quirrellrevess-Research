package ILil.p028IiL.p035lLi1LL.I1I;

import ILil.p028IiL.p033iILLL1.I1I;
import ILil.p028IiL.p034lIiI.L11I;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class iILLL1 {

    /* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.iI丨LLL1$IL1Iii */
    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static abstract class IL1Iii {

        /* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.iI丨LLL1$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResourcesCompat.java */
        public class RunnableC0574IL1Iii implements Runnable {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ Typeface f4215ILil;

            public RunnableC0574IL1Iii(Typeface typeface) {
                this.f4215ILil = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                IL1Iii.this.onFontRetrieved(this.f4215ILil);
            }
        }

        /* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.iI丨LLL1$IL1Iii$ILil */
        /* JADX INFO: compiled from: ResourcesCompat.java */
        public class ILil implements Runnable {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ int f4217ILil;

            public ILil(int i) {
                this.f4217ILil = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                IL1Iii.this.onFontRetrievalFailed(this.f4217ILil);
            }
        }

        public final void callbackFailAsync(int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new ILil(i));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0574IL1Iii(typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static Typeface I1I(Context context, int i, TypedValue typedValue, int i2, IL1Iii iL1Iii) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return Ilil(context, i, typedValue, i2, iL1Iii, null, true);
    }

    public static Drawable IL1Iii(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Typeface ILil(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return Ilil(context, i, new TypedValue(), 0, null, null, false);
    }

    public static Typeface Ilil(Context context, int i, TypedValue typedValue, int i2, IL1Iii iL1Iii, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceM2320lLi1LL = m2320lLi1LL(context, resources, typedValue, i, i2, iL1Iii, handler, z);
        if (typefaceM2320lLi1LL != null || iL1Iii != null) {
            return typefaceM2320lLi1LL;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2319IL(Context context, int i, IL1Iii iL1Iii, Handler handler) throws Resources.NotFoundException {
        L11I.m2295IL(iL1Iii);
        if (context.isRestricted()) {
            iL1Iii.callbackFailAsync(-4, handler);
        } else {
            Ilil(context, i, new TypedValue(), 0, iL1Iii, handler, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a3  */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Typeface m2320lLi1LL(Context context, Resources resources, TypedValue typedValue, int i, int i2, IL1Iii iL1Iii, Handler handler, boolean z) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (iL1Iii != null) {
                iL1Iii.callbackFailAsync(-3, handler);
            }
            return null;
        }
        Typeface typefaceM2247lLi1LL = I1I.m2247lLi1LL(resources, i, i2);
        if (typefaceM2247lLi1LL != null) {
            if (iL1Iii != null) {
                iL1Iii.callbackSuccessAsync(typefaceM2247lLi1LL, handler);
            }
            return typefaceM2247lLi1LL;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceM2245IL = I1I.m2245IL(context, resources, i, string, i2);
                if (iL1Iii != null) {
                    if (typefaceM2245IL != null) {
                        iL1Iii.callbackSuccessAsync(typefaceM2245IL, handler);
                    } else {
                        iL1Iii.callbackFailAsync(-3, handler);
                    }
                }
                return typefaceM2245IL;
            }
            I1I.IL1Iii iL1IiiILil = I1I.ILil(resources.getXml(i), resources);
            if (iL1IiiILil != null) {
                return I1I.I1I(context, iL1IiiILil, resources, i, i2, iL1Iii, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (iL1Iii != null) {
                iL1Iii.callbackFailAsync(-3, handler);
            }
            return null;
        } catch (IOException e) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + string, e);
            if (iL1Iii != null) {
                iL1Iii.callbackFailAsync(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e2);
            if (iL1Iii != null) {
                iL1Iii.callbackFailAsync(-3, handler);
            }
            return null;
        }
    }
}
