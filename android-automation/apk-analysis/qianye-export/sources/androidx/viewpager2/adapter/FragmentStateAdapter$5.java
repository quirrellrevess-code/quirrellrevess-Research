package androidx.viewpager2.adapter;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$5 implements lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final /* synthetic */ Handler f5239IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final /* synthetic */ Runnable f5240ILil;

    @Override // ILil.p042lIiI.lLi1LL
    public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
        if (iL1Iii == IL.IL1Iii.ON_DESTROY) {
            this.f5239IL1Iii.removeCallbacks(this.f5240ILil);
            iiL.getLifecycle().I1I(this);
        }
    }
}
