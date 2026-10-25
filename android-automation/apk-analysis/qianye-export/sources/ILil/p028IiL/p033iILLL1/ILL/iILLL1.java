package ILil.p028IiL.p033iILLL1.ILL;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.ILL.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: WrappedDrawableState.java */
/* JADX INFO: loaded from: classes.dex */
public final class iILLL1 extends Drawable.ConstantState {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ColorStateList f4180I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4181IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Drawable.ConstantState f4182ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public PorterDuff.Mode f1711IL;

    public iILLL1(iILLL1 iilll1) {
        this.f4180I1I = null;
        this.f1711IL = IL.f1707IiL;
        if (iilll1 != null) {
            this.f4181IL1Iii = iilll1.f4181IL1Iii;
            this.f4182ILil = iilll1.f4182ILil;
            this.f4180I1I = iilll1.f4180I1I;
            this.f1711IL = iilll1.f1711IL;
        }
    }

    public boolean IL1Iii() {
        return this.f4182ILil != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f4181IL1Iii;
        Drawable.ConstantState constantState = this.f4182ILil;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new lLi1LL(this, resources) : new IL(this, resources);
    }
}
