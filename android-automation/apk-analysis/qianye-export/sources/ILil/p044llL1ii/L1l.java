package ILil.p044llL1ii;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: renamed from: ILil.ll丨L1ii.L丨1l, reason: invalid class name */
/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
public class L1l implements iILLl {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ViewOverlay f4427IL1Iii;

    public L1l(View view) {
        this.f4427IL1Iii = view.getOverlay();
    }

    @Override // ILil.p044llL1ii.iILLl
    public void IL1Iii(Drawable drawable) {
        this.f4427IL1Iii.add(drawable);
    }

    @Override // ILil.p044llL1ii.iILLl
    public void ILil(Drawable drawable) {
        this.f4427IL1Iii.remove(drawable);
    }
}
