package ILil.ILil.p020ILl.IL1Iii;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: StateListDrawable.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class IL extends ILil {

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public IL1Iii f1305ILl;
    public boolean Lil;

    /* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.I丨L$IL1Iii */
    /* JADX INFO: compiled from: StateListDrawable.java */
    public static class IL1Iii extends ILil.I1I {

        /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
        public int[][] f1306iILLl;

        public IL1Iii(IL1Iii iL1Iii, IL il, Resources resources) {
            super(iL1Iii, il, resources);
            if (iL1Iii != null) {
                this.f1306iILLl = iL1Iii.f1306iILLl;
            } else {
                this.f1306iILLl = new int[m1632lLi1LL()][];
            }
        }

        @Override // ILil.ILil.IL丨丨l.IL1Iii.ILil.I1I
        public void Lil(int i, int i2) {
            super.Lil(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f1306iILLl, 0, iArr, 0, i);
            this.f1306iILLl = iArr;
        }

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public int m1636LlLLL(int[] iArr) {
            int[][] iArr2 = this.f1306iILLl;
            int iM1626IiL = m1626IiL();
            for (int i = 0; i < iM1626IiL; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // ILil.ILil.IL丨丨l.IL1Iii.ILil.I1I
        /* JADX INFO: renamed from: lI丨lii */
        public void mo1617lIlii() {
            int[][] iArr = this.f1306iILLl;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f1306iILLl;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f1306iILLl = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new IL(this, null);
        }

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public int m16371(int[] iArr, Drawable drawable) {
            int iIL1Iii = IL1Iii(drawable);
            this.f1306iILLl[iIL1Iii] = iArr;
            return iIL1Iii;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new IL(this, resources);
        }
    }

    public IL(IL1Iii iL1Iii, Resources resources) {
        mo1608IiL(new IL1Iii(iL1Iii, this, resources));
        onStateChange(getState());
    }

    public int[] ILL(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil
    /* JADX INFO: renamed from: I丨iL */
    public void mo1608IiL(ILil.I1I i1i) {
        super.mo1608IiL(i1i);
        if (i1i instanceof IL1Iii) {
            this.f1305ILl = (IL1Iii) i1i;
        }
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.Lil) {
            super.mutate();
            if (this == this) {
                this.f1305ILl.mo1617lIlii();
                this.Lil = true;
            }
        }
        return this;
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iM1636LlLLL = this.f1305ILl.m1636LlLLL(iArr);
        if (iM1636LlLLL < 0) {
            iM1636LlLLL = this.f1305ILl.m1636LlLLL(StateSet.WILD_CARD);
        }
        return m1623iILLL1(iM1636LlLLL) || zOnStateChange;
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil
    /* JADX INFO: renamed from: 丨il, reason: merged with bridge method [inline-methods] */
    public IL1Iii ILil() {
        return new IL1Iii(this.f1305ILl, this, null);
    }

    public IL(IL1Iii iL1Iii) {
        if (iL1Iii != null) {
            mo1608IiL(iL1Iii);
        }
    }
}
