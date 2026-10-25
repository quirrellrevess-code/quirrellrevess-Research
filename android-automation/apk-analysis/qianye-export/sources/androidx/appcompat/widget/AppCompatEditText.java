package androidx.appcompat.widget;

import ILil.ILil.IL1Iii;
import ILil.ILil.p023lIlii.IL;
import ILil.ILil.p023lIlii.IiL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.Ll1;
import ILil.ILil.p023lIlii.lIiI;
import ILil.p028IiL.Lil.C0636il;
import ILil.p028IiL.p029ILl.iIi1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements iIi1 {
    private final IL mBackgroundTintHelper;
    private final Ll1 mTextClassifierHelper;
    private final lIiI mTextHelper;

    public AppCompatEditText(Context context) {
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

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        Ll1 ll1;
        return (Build.VERSION.SDK_INT >= 28 || (ll1 = this.mTextClassifierHelper) == null) ? super.getTextClassifier() : ll1.IL1Iii();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        IiL.IL1Iii(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
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
    public void setTextClassifier(TextClassifier textClassifier) {
        Ll1 ll1;
        if (Build.VERSION.SDK_INT >= 28 || (ll1 = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            ll1.ILil(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, IL1Iii.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        IL il = new IL(this);
        this.mBackgroundTintHelper = il;
        il.Ilil(attributeSet, i);
        lIiI liii = new lIiI(this);
        this.mTextHelper = liii;
        liii.m1806lIiI(attributeSet, i);
        liii.ILil();
        this.mTextClassifierHelper = new Ll1(this);
    }
}
