package ILil.ILil.p023lIlii;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨丨 */
/* JADX INFO: compiled from: TintResources.java */
/* JADX INFO: loaded from: classes.dex */
public class C0005 extends llliI {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final WeakReference<Context> f3848ILil;

    public C0005(Context context, Resources resources) {
        super(resources);
        this.f3848ILil = new WeakReference<>(context);
    }

    @Override // ILil.ILil.p023lIlii.llliI, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f3848ILil.get();
        if (drawable != null && context != null) {
            I11L.m1689IiL().llliI(context, i, drawable);
        }
        return drawable;
    }
}
