package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import ILil.p028IiL.Lil.I1I;
import ILil.p028IiL.p033iILLL1.ILL.IL1Iii;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatCompoundButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final CompoundButton f3833IL1Iii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1415lLi1LL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ColorStateList f3834ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public PorterDuff.Mode f3832I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f1414IL = false;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f3835Ilil = false;

    public lLi1LL(CompoundButton compoundButton) {
        this.f3833IL1Iii = compoundButton;
    }

    public ColorStateList I1I() {
        return this.f3834ILil;
    }

    public void IL1Iii() {
        Drawable drawableIL1Iii = I1I.IL1Iii(this.f3833IL1Iii);
        if (drawableIL1Iii != null) {
            if (this.f1414IL || this.f3835Ilil) {
                Drawable drawableMutate = IL1Iii.m2256lIlii(drawableIL1Iii).mutate();
                if (this.f1414IL) {
                    IL1Iii.Lil(drawableMutate, this.f3834ILil);
                }
                if (this.f3835Ilil) {
                    IL1Iii.LlLI1(drawableMutate, this.f3832I1I);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f3833IL1Iii.getDrawableState());
                }
                this.f3833IL1Iii.setButtonDrawable(drawableMutate);
            }
        }
    }

    public int ILil(int i) {
        Drawable drawableIL1Iii;
        return (Build.VERSION.SDK_INT >= 17 || (drawableIL1Iii = I1I.IL1Iii(this.f3833IL1Iii)) == null) ? i : i + drawableIL1Iii.getIntrinsicWidth();
    }

    public void Ilil(AttributeSet attributeSet, int i) {
        boolean z;
        int resourceId;
        int resourceId2;
        TypedArray typedArrayObtainStyledAttributes = this.f3833IL1Iii.getContext().obtainStyledAttributes(attributeSet, ILL.CompoundButton, i, 0);
        try {
            int i2 = ILL.CompoundButton_buttonCompat;
            if (!typedArrayObtainStyledAttributes.hasValue(i2) || (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(i2, 0)) == 0) {
                z = false;
            } else {
                try {
                    CompoundButton compoundButton = this.f3833IL1Iii;
                    compoundButton.setButtonDrawable(ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(compoundButton.getContext(), resourceId2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z) {
                int i3 = ILL.CompoundButton_android_button;
                if (typedArrayObtainStyledAttributes.hasValue(i3) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f3833IL1Iii;
                    compoundButton2.setButtonDrawable(ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(compoundButton2.getContext(), resourceId));
                }
            }
            int i4 = ILL.CompoundButton_buttonTint;
            if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                I1I.I1I(this.f3833IL1Iii, typedArrayObtainStyledAttributes.getColorStateList(i4));
            }
            int i5 = ILL.CompoundButton_buttonTintMode;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                I1I.m2198IL(this.f3833IL1Iii, llL1ii.Ilil(typedArrayObtainStyledAttributes.getInt(i5, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public PorterDuff.Mode m1835IL() {
        return this.f3832I1I;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1836IiL(PorterDuff.Mode mode) {
        this.f3832I1I = mode;
        this.f3835Ilil = true;
        IL1Iii();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1837iILLL1(ColorStateList colorStateList) {
        this.f3834ILil = colorStateList;
        this.f1414IL = true;
        IL1Iii();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1838lLi1LL() {
        if (this.f1415lLi1LL) {
            this.f1415lLi1LL = false;
        } else {
            this.f1415lLi1LL = true;
            IL1Iii();
        }
    }
}
