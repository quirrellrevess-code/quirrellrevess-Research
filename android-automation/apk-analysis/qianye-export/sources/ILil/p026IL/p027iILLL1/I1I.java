package ILil.p026IL.p027iILLL1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: CardViewBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I implements lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final RectF f3989IL1Iii = new RectF();

    /* JADX INFO: compiled from: CardViewBaseImpl.java */
    public class IL1Iii implements IiL.IL1Iii {
        public IL1Iii() {
        }

        @Override // ILil.p026IL.p027iILLL1.IiL.IL1Iii
        public void IL1Iii(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float fWidth = (rectF.width() - f2) - 1.0f;
            float fHeight = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                I1I.this.f3989IL1Iii.set(f4, f4, f3, f3);
                int iSave = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(I1I.this.f3989IL1Iii, 180.0f, 90.0f, true, paint);
                canvas.translate(fWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(I1I.this.f3989IL1Iii, 180.0f, 90.0f, true, paint);
                canvas.translate(fHeight, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(I1I.this.f3989IL1Iii, 180.0f, 90.0f, true, paint);
                canvas.translate(fWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(I1I.this.f3989IL1Iii, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(iSave);
                float f5 = (rectF.left + f3) - 1.0f;
                float f6 = rectF.top;
                canvas.drawRect(f5, f6, (rectF.right - f3) + 1.0f, f6 + f3, paint);
                float f7 = (rectF.left + f3) - 1.0f;
                float f8 = rectF.bottom;
                canvas.drawRect(f7, f8 - f3, (rectF.right - f3) + 1.0f, f8, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public float I1I(IL il) {
        return m1991llL1ii(il).m1999Ll1();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void IL1Iii(IL il, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        IiL iiLLlLI1 = LlLI1(context, colorStateList, f, f2, f3);
        iiLLlLI1.m2002lIiI(il.I1I());
        il.ILil(iiLLlLI1);
        mo1988L11I(il);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public float ILL(IL il) {
        return m1991llL1ii(il).m2006il();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void ILil(IL il, float f) {
        m1991llL1ii(il).LlLI1(f);
        mo1988L11I(il);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void mo1984ILl(IL il, ColorStateList colorStateList) {
        m1991llL1ii(il).Lil(colorStateList);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void Ilil(IL il) {
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public float mo1985IL(IL il) {
        return m1991llL1ii(il).m2001iILLL1();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ColorStateList mo1986IiL(IL il) {
        return m1991llL1ii(il).m2005lLi1LL();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    public void Lil(IL il, float f) {
        m1991llL1ii(il).m2004llL1ii(f);
        mo1988L11I(il);
    }

    public final IiL LlLI1(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new IiL(context.getResources(), colorStateList, f, f2, f3);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public float mo1987Ll1(IL il) {
        return m1991llL1ii(il).ILL();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void mo1988L11I(IL il) {
        Rect rect = new Rect();
        m1991llL1ii(il).m1998IiL(rect);
        il.IL1Iii((int) Math.ceil(mo1987Ll1(il)), (int) Math.ceil(ILL(il)));
        il.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public float mo1989iILLL1(IL il) {
        return m1991llL1ii(il).m2000L11I();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void mo1990lIiI(IL il) {
        m1991llL1ii(il).m2002lIiI(il.I1I());
        mo1988L11I(il);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final IiL m1991llL1ii(IL il) {
        return (IiL) il.Ilil();
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void mo1992lLi1LL(IL il, float f) {
        m1991llL1ii(il).m2003lIlii(f);
    }

    @Override // ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void mo1993il() {
        IiL.f1582lIlii = new IL1Iii();
    }
}
