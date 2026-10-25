package androidx.lifecycle;

import ILil.p042lIiI.I1I;
import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.Ll1;
import ILil.p042lIiI.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final I1I[] f5027IL1Iii;

    public CompositeGeneratedAdaptersObserver(I1I[] i1iArr) {
        this.f5027IL1Iii = i1iArr;
    }

    @Override // ILil.p042lIiI.lLi1LL
    public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
        Ll1 ll1 = new Ll1();
        for (I1I i1i : this.f5027IL1Iii) {
            i1i.IL1Iii(iiL, iL1Iii, false, ll1);
        }
        for (I1I i1i2 : this.f5027IL1Iii) {
            i1i2.IL1Iii(iiL, iL1Iii, true, ll1);
        }
    }
}
