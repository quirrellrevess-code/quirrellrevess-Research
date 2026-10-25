package androidx.appcompat.widget;

import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.ILil.p023lIlii.IL;
import ILil.ILil.p023lIlii.IiL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.lIiI;
import ILil.p028IiL.Lil.C0636il;
import ILil.p028IiL.Lil.ILil;
import ILil.p028IiL.Lil.Ll1;
import ILil.p028IiL.p029ILl.iIi1;
import ILil.p028IiL.p031Ll1.I1I;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements iIi1, Ll1, ILil {
    private final IL mBackgroundTintHelper;
    private Future<I1I> mPrecomputedTextFuture;
    private final ILil.ILil.p023lIlii.Ll1 mTextClassifierHelper;
    private final lIiI mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<I1I> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                C0636il.LlLI1(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return C0636il.ILil(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return C0636il.I1I(this);
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.m1811il();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.ILL();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        ILil.ILil.p023lIlii.Ll1 ll1;
        return (Build.VERSION.SDK_INT >= 28 || (ll1 = this.mTextClassifierHelper) == null) ? super.getTextClassifier() : ll1.IL1Iii();
    }

    public I1I.IL1Iii getTextMetricsParamsCompat() {
        return C0636il.m2225iILLL1(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        IiL.IL1Iii(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.m1800ILl(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
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
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.Lil();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.Lil();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.Lil();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.Lil();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0636il.iIi1(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            C0636il.m2226lIiI(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            C0636il.m2220ILl(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        C0636il.Lil(this, i);
    }

    public void setPrecomputedText(I1I i1i) {
        C0636il.LlLI1(this, i1i);
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

    @Override // ILil.p028IiL.Lil.Ll1
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.m1812lL(colorStateList);
        this.mTextHelper.ILil();
    }

    @Override // ILil.p028IiL.Lil.Ll1
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.I11L(mode);
        this.mTextHelper.ILil();
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
    public void setTextClassifier(TextClassifier textClassifier) {
        ILil.ILil.p023lIlii.Ll1 ll1;
        if (Build.VERSION.SDK_INT >= 28 || (ll1 = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            ll1.ILil(textClassifier);
        }
    }

    public void setTextFuture(Future<I1I> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(I1I.IL1Iii iL1Iii) {
        C0636il.m2227lIlii(this, iL1Iii);
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

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface typefaceIL1Iii = (typeface == null || i <= 0) ? null : ILil.p028IiL.p033iILLL1.I1I.IL1Iii(getContext(), typeface, i);
        if (typefaceIL1Iii != null) {
            typeface = typefaceIL1Iii;
        }
        super.setTypeface(typeface, i);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        IL il = new IL(this);
        this.mBackgroundTintHelper = il;
        il.Ilil(attributeSet, i);
        lIiI liii = new lIiI(this);
        this.mTextHelper = liii;
        liii.m1806lIiI(attributeSet, i);
        liii.ILil();
        this.mTextClassifierHelper = new ILil.ILil.p023lIlii.Ll1(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? IL1Iii.m1686IL(context, i) : null, i2 != 0 ? IL1Iii.m1686IL(context, i2) : null, i3 != 0 ? IL1Iii.m1686IL(context, i3) : null, i4 != 0 ? IL1Iii.m1686IL(context, i4) : null);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.Lil();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? IL1Iii.m1686IL(context, i) : null, i2 != 0 ? IL1Iii.m1686IL(context, i2) : null, i3 != 0 ? IL1Iii.m1686IL(context, i3) : null, i4 != 0 ? IL1Iii.m1686IL(context, i4) : null);
        lIiI liii = this.mTextHelper;
        if (liii != null) {
            liii.Lil();
        }
    }
}
