package androidx.appcompat.widget;

import ILil.ILil.IL1Iii;
import ILil.ILil.p023lIlii.IL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.lIiI;
import ILil.p028IiL.Lil.C0636il;
import ILil.p028IiL.Lil.ILil;
import ILil.p028IiL.p029ILl.iIi1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements iIi1, ILil {
    private final IL mBackgroundTintHelper;
    private final lIiI mTextHelper;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (ILil.f4129IL1Iii) {
            return super.getAutoSizeMaxTextSize();
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            return liii.Ilil();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (ILil.f4129IL1Iii) {
            return super.getAutoSizeMinTextSize();
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            return liii.m1810lLi1LL();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (ILil.f4129IL1Iii) {
            return super.getAutoSizeStepGranularity();
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            return liii.m1805iILLL1();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (ILil.f4129IL1Iii) {
            return super.getAutoSizeTextAvailableSizes();
        }
        lIiI liii = this.mTextHelper;
        return liii != null ? liii.m1801IiL() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (ILil.f4129IL1Iii) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            return liii.m1803L11I();
        }
        return 0;
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.m1800ILl(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        lIiI liii = this.mTextHelper;
        if (liii == null || ILil.f4129IL1Iii || !liii.m1802Ll1()) {
            return;
        }
        this.mTextHelper.I1I();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (ILil.f4129IL1Iii) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.iIi1(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (ILil.f4129IL1Iii) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.iIlLiL(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (ILil.f4129IL1Iii) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.I11li1(i);
        }
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0636il.iIi1(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.m1808lIlii(z);
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.LlLI1(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (ILil.f4129IL1Iii) {
            super.setTextSize(i, f);
            return;
        }
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.m18141(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, IL1Iii.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        IL il = new IL(this);
        this.mBackgroundTintHelper = il;
        il.Ilil(attributeSet, i);
        lIiI liii = new lIiI(this);
        this.mTextHelper = liii;
        liii.m1806lIiI(attributeSet, i);
        liii.ILil();
    }
}
