package ILil.p045lLi1LL.IL1Iii.ILL;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ResolutionNode.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public HashSet<Lil> f4490IL1Iii = new HashSet<>(2);

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4491ILil = 0;

    public void I1I() {
        this.f4491ILil = 0;
        Iterator<Lil> it = this.f4490IL1Iii.iterator();
        while (it.hasNext()) {
            it.next().I1I();
        }
    }

    public void IL1Iii(Lil lil) {
        this.f4490IL1Iii.add(lil);
    }

    public void ILil() {
        this.f4491ILil = 1;
        Iterator<Lil> it = this.f4490IL1Iii.iterator();
        while (it.hasNext()) {
            it.next().mo2619lLi1LL();
        }
    }

    public void Ilil() {
        this.f4491ILil = 0;
        this.f4490IL1Iii.clear();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m2618IL() {
        return this.f4491ILil == 1;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void mo2619lLi1LL() {
    }
}
