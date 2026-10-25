package androidx.appcompat.widget;

import ILil.ILil.IL1Iii;
import ILil.ILil.p023lIlii.IL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.lIiI;
import ILil.ILil.p023lIlii.lLi1LL;
import ILil.p028IiL.Lil.ILL;
import ILil.p028IiL.p029ILl.iIi1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements ILL, iIi1 {
    private final IL mBackgroundTintHelper;
    private final lLi1LL mCompoundButtonHelper;
    private final lIiI mTextHelper;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.ILil();
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.ILil();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        lLi1LL lli1ll = this.mCompoundButtonHelper;
        return lli1ll != null ? lli1ll.ILil(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public ColorStateList getSupportBackgroundTintList() {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            return il.I1I();
        }
        return null;
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            return il.m1734IL();
        }
        return null;
    }

    @Override // ILil.p028IiL.Lil.ILL
    public ColorStateList getSupportButtonTintList() {
        lLi1LL lli1ll = this.mCompoundButtonHelper;
        if (lli1ll != null) {
            return lli1ll.I1I();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        lLi1LL lli1ll = this.mCompoundButtonHelper;
        if (lli1ll != null) {
            return lli1ll.m1835IL();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1738lLi1LL(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1737iILLL1(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        lLi1LL lli1ll = this.mCompoundButtonHelper;
        if (lli1ll != null) {
            lli1ll.m1838lLi1LL();
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1736L11I(colorStateList);
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1739il(mode);
        }
    }

    @Override // ILil.p028IiL.Lil.ILL
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        lLi1LL lli1ll = this.mCompoundButtonHelper;
        if (lli1ll != null) {
            lli1ll.m1837iILLL1(colorStateList);
        }
    }

    @Override // ILil.p028IiL.Lil.ILL
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        lLi1LL lli1ll = this.mCompoundButtonHelper;
        if (lli1ll != null) {
            lli1ll.m1836IiL(mode);
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, IL1Iii.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        lLi1LL lli1ll = new lLi1LL(this);
        this.mCompoundButtonHelper = lli1ll;
        lli1ll.Ilil(attributeSet, i);
        IL il = new IL(this);
        this.mBackgroundTintHelper = il;
        il.Ilil(attributeSet, i);
        lIiI liii = new lIiI(this);
        this.mTextHelper = liii;
        liii.m1806lIiI(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(getContext(), i));
    }
}
