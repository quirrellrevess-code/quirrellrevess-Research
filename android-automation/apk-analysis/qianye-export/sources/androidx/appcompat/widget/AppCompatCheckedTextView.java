package androidx.appcompat.widget;

import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.ILil.p023lIlii.IiL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.lIiI;
import ILil.ILil.p023lIlii.llI;
import ILil.p028IiL.Lil.C0636il;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final int[] f4849I1I = {R.attr.checkMark};

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lIiI f4850ILil;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        lIiI liii = this.f4850ILil;
        if (liii != null) {
            liii.ILil();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        IiL.IL1Iii(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(IL1Iii.m1686IL(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0636il.iIi1(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        lIiI liii = this.f4850ILil;
        if (liii != null) {
            liii.LlLI1(context, i);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        lIiI liii = new lIiI(this);
        this.f4850ILil = liii;
        liii.m1806lIiI(attributeSet, i);
        liii.ILil();
        llI lliI11li1 = llI.I11li1(getContext(), attributeSet, f4849I1I, i, 0);
        setCheckMarkDrawable(lliI11li1.m1827iILLL1(0));
        lliI11li1.m1833lL();
    }
}
