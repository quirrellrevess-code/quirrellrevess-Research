package ILil.p044llL1ii;

import android.view.ViewGroup;

/* JADX INFO: compiled from: Scene.java */
/* JADX INFO: loaded from: classes.dex */
public class iIi1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ViewGroup f4435IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Runnable f4436ILil;

    public static void I1I(ViewGroup viewGroup, iIi1 iii1) {
        viewGroup.setTag(llL1ii.transition_current_scene, iii1);
    }

    public static iIi1 ILil(ViewGroup viewGroup) {
        return (iIi1) viewGroup.getTag(llL1ii.transition_current_scene);
    }

    public void IL1Iii() {
        Runnable runnable;
        if (ILil(this.f4435IL1Iii) != this || (runnable = this.f4436ILil) == null) {
            return;
        }
        runnable.run();
    }
}
