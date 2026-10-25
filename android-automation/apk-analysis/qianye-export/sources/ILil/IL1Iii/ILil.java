package ILil.IL1Iii;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: OnBackPressedCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f3617IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public CopyOnWriteArrayList<IL1Iii> f3618ILil = new CopyOnWriteArrayList<>();

    public ILil(boolean z) {
        this.f3617IL1Iii = z;
    }

    public final boolean I1I() {
        return this.f3617IL1Iii;
    }

    public void IL1Iii(IL1Iii iL1Iii) {
        this.f3618ILil.add(iL1Iii);
    }

    public abstract void ILil();

    public void Ilil(IL1Iii iL1Iii) {
        this.f3618ILil.remove(iL1Iii);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1444IL() {
        Iterator<IL1Iii> it = this.f3618ILil.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1445lLi1LL(boolean z) {
        this.f3617IL1Iii = z;
    }
}
