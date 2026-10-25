package androidx.lifecycle;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.IL1Iii;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f5040IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final IL1Iii.C0580IL1Iii f5041ILil;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f5040IL1Iii = obj;
        this.f5041ILil = IL1Iii.f4335I1I.I1I(obj.getClass());
    }

    @Override // ILil.p042lIiI.lLi1LL
    public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
        this.f5041ILil.IL1Iii(iiL, iL1Iii, this.f5040IL1Iii);
    }
}
