package ILil.p044llL1ii;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: renamed from: ILil.ll丨L1ii.L11丨丨丨1, reason: invalid class name */
/* JADX INFO: compiled from: ViewGroupOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
public class L111 implements InterfaceC0648LLlI1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ViewGroupOverlay f4418IL1Iii;

    public L111(ViewGroup viewGroup) {
        this.f4418IL1Iii = viewGroup.getOverlay();
    }

    @Override // ILil.p044llL1ii.InterfaceC0648LLlI1
    public void I1I(View view) {
        this.f4418IL1Iii.add(view);
    }

    @Override // ILil.p044llL1ii.iILLl
    public void IL1Iii(Drawable drawable) {
        this.f4418IL1Iii.add(drawable);
    }

    @Override // ILil.p044llL1ii.iILLl
    public void ILil(Drawable drawable) {
        this.f4418IL1Iii.remove(drawable);
    }

    @Override // ILil.p044llL1ii.InterfaceC0648LLlI1
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void mo2562IL(View view) {
        this.f4418IL1Iii.remove(view);
    }
}
