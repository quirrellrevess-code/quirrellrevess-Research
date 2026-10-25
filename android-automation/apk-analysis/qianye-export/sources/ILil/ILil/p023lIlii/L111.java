package ILil.ILil.p023lIlii;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.L11丨丨丨1, reason: invalid class name */
/* JADX INFO: compiled from: TintContextWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class L111 extends ContextWrapper {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Object f3771I1I = new Object();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static ArrayList<WeakReference<L111>> f1365IL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Resources f3772IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Resources.Theme f3773ILil;

    public L111(Context context) {
        super(context);
        if (!LIll.ILil()) {
            this.f3772IL1Iii = new C0005(this, context.getResources());
            this.f3773ILil = null;
            return;
        }
        LIll lIll = new LIll(this, context.getResources());
        this.f3772IL1Iii = lIll;
        Resources.Theme themeNewTheme = lIll.newTheme();
        this.f3773ILil = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean IL1Iii(Context context) {
        if ((context instanceof L111) || (context.getResources() instanceof C0005) || (context.getResources() instanceof LIll)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || LIll.ILil();
    }

    public static Context ILil(Context context) {
        if (!IL1Iii(context)) {
            return context;
        }
        synchronized (f3771I1I) {
            ArrayList<WeakReference<L111>> arrayList = f1365IL;
            if (arrayList == null) {
                f1365IL = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<L111> weakReference = f1365IL.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1365IL.remove(size);
                    }
                }
                for (int size2 = f1365IL.size() - 1; size2 >= 0; size2--) {
                    WeakReference<L111> weakReference2 = f1365IL.get(size2);
                    L111 l111 = weakReference2 != null ? weakReference2.get() : null;
                    if (l111 != null && l111.getBaseContext() == context) {
                        return l111;
                    }
                }
            }
            L111 l112 = new L111(context);
            f1365IL.add(new WeakReference<>(l112));
            return l112;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f3772IL1Iii.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f3772IL1Iii;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f3773ILil;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f3773ILil;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
