package ILil.ILil.p023lIlii;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.LI丨丨l丨l, reason: invalid class name */
/* JADX INFO: compiled from: VectorEnabledTintResources.java */
/* JADX INFO: loaded from: classes.dex */
public class LIll extends Resources {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f3774ILil = false;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final WeakReference<Context> f3775IL1Iii;

    public LIll(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3775IL1Iii = new WeakReference<>(context);
    }

    public static boolean IL1Iii() {
        return f3774ILil;
    }

    public static boolean ILil() {
        return IL1Iii() && Build.VERSION.SDK_INT <= 20;
    }

    public final Drawable I1I(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.f3775IL1Iii.get();
        return context != null ? I11L.m1689IiL().iIlLiL(context, this, i) : super.getDrawable(i);
    }
}
