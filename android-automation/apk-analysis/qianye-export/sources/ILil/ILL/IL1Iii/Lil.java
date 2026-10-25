package ILil.ILL.IL1Iii;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.L11I;

/* JADX INFO: compiled from: FragmentViewLifecycleOwner.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil implements IiL {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public L11I f3638ILil = null;

    public void I1I() {
        if (this.f3638ILil == null) {
            this.f3638ILil = new L11I(this);
        }
    }

    public void IL1Iii(IL.IL1Iii iL1Iii) {
        this.f3638ILil.m2507L11I(iL1Iii);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1505IL() {
        return this.f3638ILil != null;
    }

    @Override // ILil.p042lIiI.IiL
    public IL getLifecycle() {
        I1I();
        return this.f3638ILil;
    }
}
