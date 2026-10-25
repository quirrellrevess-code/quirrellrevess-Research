package ILil.p026IL.p027iILLL1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: compiled from: CardViewApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil implements lLi1LL {
    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public float I1I(IL il) {
        return il.mo1995lLi1LL().getElevation();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void IL1Iii(IL il, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        il.ILil(new iILLL1(colorStateList, f));
        View viewMo1995lLi1LL = il.mo1995lLi1LL();
        viewMo1995lLi1LL.setClipToOutline(true);
        viewMo1995lLi1LL.setElevation(f2);
        Lil(il, f3);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public float ILL(IL il) {
        return mo1985IL(il) * 2.0f;
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void ILil(IL il, float f) {
        LlLI1(il).m2008IiL(f);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: IL丨丨l */
    public void mo1984ILl(IL il, ColorStateList colorStateList) {
        LlLI1(il).m2011lLi1LL(colorStateList);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void Ilil(IL il) {
        Lil(il, mo1989iILLL1(il));
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: I丨L */
    public float mo1985IL(IL il) {
        return LlLI1(il).m2007IL();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: I丨iL */
    public ColorStateList mo1986IiL(IL il) {
        return LlLI1(il).ILil();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void Lil(IL il, float f) {
        LlLI1(il).m2010iILLL1(f, il.mo1994IL(), il.I1I());
        mo1988L11I(il);
    }

    public final iILLL1 LlLI1(IL il) {
        return (iILLL1) il.Ilil();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: Ll丨1 */
    public float mo1987Ll1(IL il) {
        return mo1985IL(il) * 2.0f;
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo1988L11I(IL il) {
        if (!il.mo1994IL()) {
            il.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float fMo1989iILLL1 = mo1989iILLL1(il);
        float fMo1985IL = mo1985IL(il);
        int iCeil = (int) Math.ceil(IiL.I1I(fMo1989iILLL1, fMo1985IL, il.I1I()));
        int iCeil2 = (int) Math.ceil(IiL.m1996IL(fMo1989iILLL1, fMo1985IL, il.I1I()));
        il.setShadowPadding(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: iI丨LLL1 */
    public float mo1989iILLL1(IL il) {
        return LlLI1(il).I1I();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: lIi丨I */
    public void mo1990lIiI(IL il) {
        Lil(il, mo1989iILLL1(il));
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: l丨Li1LL */
    public void mo1992lLi1LL(IL il, float f) {
        il.mo1995lLi1LL().setElevation(f);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: 丨il */
    public void mo1993il() {
    }
}
