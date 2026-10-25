package androidx.appcompat.widget;

import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.ILil.p023lIlii.IL;
import ILil.ILil.p023lIlii.IiL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.lIiI;
import ILil.ILil.p023lIlii.llI;
import ILil.p028IiL.p029ILl.iIi1;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements iIi1 {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final int[] f2401IL = {R.attr.popupBackground};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final lIiI f4853I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final IL f4854ILil;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        IL il = this.f4854ILil;
        if (il != null) {
            il.ILil();
        }
        lIiI liii = this.f4853I1I;
        if (liii != null) {
            liii.ILil();
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public ColorStateList getSupportBackgroundTintList() {
        IL il = this.f4854ILil;
        if (il != null) {
            return il.I1I();
        }
        return null;
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        IL il = this.f4854ILil;
        if (il != null) {
            return il.m1734IL();
        }
        return null;
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
        IL il = this.f4854ILil;
        if (il != null) {
            il.m1738lLi1LL(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        IL il = this.f4854ILil;
        if (il != null) {
            il.m1737iILLL1(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(IL1Iii.m1686IL(getContext(), i));
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        IL il = this.f4854ILil;
        if (il != null) {
            il.m1736L11I(colorStateList);
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        IL il = this.f4854ILil;
        if (il != null) {
            il.m1739il(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        lIiI liii = this.f4853I1I;
        if (liii != null) {
            liii.LlLI1(context, i);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.ILil.IL1Iii.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        llI lliI11li1 = llI.I11li1(getContext(), attributeSet, f2401IL, i, 0);
        if (lliI11li1.m1829lIlii(0)) {
            setDropDownBackgroundDrawable(lliI11li1.m1827iILLL1(0));
        }
        lliI11li1.m1833lL();
        IL il = new IL(this);
        this.f4854ILil = il;
        il.Ilil(attributeSet, i);
        lIiI liii = new lIiI(this);
        this.f4853I1I = liii;
        liii.m1806lIiI(attributeSet, i);
        liii.ILil();
    }
}
