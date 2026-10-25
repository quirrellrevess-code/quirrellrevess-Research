package ILil.ILil.p021Ll1;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends IL implements DialogInterface {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final AlertController f3718ILil;

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlertDialog.java */
    public static class C0552IL1Iii {

        /* JADX INFO: renamed from: P */
        private final AlertController.iILLL1 f4P;
        private final int mTheme;

        public C0552IL1Iii(Context context) {
            this(context, IL1Iii.ILil(context, 0));
        }

        public IL1Iii create() {
            IL1Iii iL1Iii = new IL1Iii(this.f4P.f4764IL1Iii, this.mTheme);
            this.f4P.IL1Iii(iL1Iii.f3718ILil);
            iL1Iii.setCancelable(this.f4P.f2245lIlii);
            if (this.f4P.f2245lIlii) {
                iL1Iii.setCanceledOnTouchOutside(true);
            }
            iL1Iii.setOnCancelListener(this.f4P.iIi1);
            iL1Iii.setOnDismissListener(this.f4P.iIlLiL);
            DialogInterface.OnKeyListener onKeyListener = this.f4P.I11li1;
            if (onKeyListener != null) {
                iL1Iii.setOnKeyListener(onKeyListener);
            }
            return iL1Iii;
        }

        public Context getContext() {
            return this.f4P.f4764IL1Iii;
        }

        public C0552IL1Iii setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.I11L = listAdapter;
            iilll1.llliI = onClickListener;
            return this;
        }

        public C0552IL1Iii setCancelable(boolean z) {
            this.f4P.f2245lIlii = z;
            return this;
        }

        public C0552IL1Iii setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2229IIi = cursor;
            iilll1.f2234LIll = str;
            iilll1.llliI = onClickListener;
            return this;
        }

        public C0552IL1Iii setCustomTitle(View view) {
            this.f4P.f2240iILLL1 = view;
            return this;
        }

        public C0552IL1Iii setIcon(int i) {
            this.f4P.f4763I1I = i;
            return this;
        }

        public C0552IL1Iii setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f4P.f4764IL1Iii.getTheme().resolveAttribute(i, typedValue, true);
            this.f4P.f4763I1I = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public C0552IL1Iii setInverseBackgroundForced(boolean z) {
            this.f4P.f2254 = z;
            return this;
        }

        public C0552IL1Iii setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2250lL = iilll1.f4764IL1Iii.getResources().getTextArray(i);
            this.f4P.llliI = onClickListener;
            return this;
        }

        public C0552IL1Iii setMessage(int i) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2231IiL = iilll1.f4764IL1Iii.getText(i);
            return this;
        }

        public C0552IL1Iii setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2250lL = iilll1.f4764IL1Iii.getResources().getTextArray(i);
            AlertController.iILLL1 iilll2 = this.f4P;
            iilll2.f2248iILLl = onMultiChoiceClickListener;
            iilll2.f27 = zArr;
            iilll2.llI = true;
            return this;
        }

        public C0552IL1Iii setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2236Ll1 = iilll1.f4764IL1Iii.getText(i);
            this.f4P.f2228ILl = onClickListener;
            return this;
        }

        public C0552IL1Iii setNegativeButtonIcon(Drawable drawable) {
            this.f4P.f2243lIiI = drawable;
            return this;
        }

        public C0552IL1Iii setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.Lil = iilll1.f4764IL1Iii.getText(i);
            this.f4P.f2246llL1ii = onClickListener;
            return this;
        }

        public C0552IL1Iii setNeutralButtonIcon(Drawable drawable) {
            this.f4P.LlLI1 = drawable;
            return this;
        }

        public C0552IL1Iii setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f4P.iIi1 = onCancelListener;
            return this;
        }

        public C0552IL1Iii setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f4P.iIlLiL = onDismissListener;
            return this;
        }

        public C0552IL1Iii setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f4P.f2232L11 = onItemSelectedListener;
            return this;
        }

        public C0552IL1Iii setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f4P.I11li1 = onKeyListener;
            return this;
        }

        public C0552IL1Iii setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2238L11I = iilll1.f4764IL1Iii.getText(i);
            this.f4P.ILL = onClickListener;
            return this;
        }

        public C0552IL1Iii setPositiveButtonIcon(Drawable drawable) {
            this.f4P.f2249il = drawable;
            return this;
        }

        public C0552IL1Iii setRecycleOnMeasureEnabled(boolean z) {
            this.f4P.f2227IIiI = z;
            return this;
        }

        public C0552IL1Iii setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2250lL = iilll1.f4764IL1Iii.getResources().getTextArray(i);
            AlertController.iILLL1 iilll2 = this.f4P;
            iilll2.llliI = onClickListener;
            iilll2.f2237L1l = i2;
            iilll2.f2242l1IIi1 = true;
            return this;
        }

        public C0552IL1Iii setTitle(int i) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2247lLi1LL = iilll1.f4764IL1Iii.getText(i);
            return this;
        }

        public C0552IL1Iii setView(int i) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f22531 = null;
            iilll1.f2251l = i;
            iilll1.f2252LLlI1 = false;
            return this;
        }

        public IL1Iii show() {
            IL1Iii iL1IiiCreate = create();
            iL1IiiCreate.show();
            return iL1IiiCreate;
        }

        public C0552IL1Iii(Context context, int i) {
            this.f4P = new AlertController.iILLL1(new ContextThemeWrapper(context, IL1Iii.ILil(context, i)));
            this.mTheme = i;
        }

        public C0552IL1Iii setIcon(Drawable drawable) {
            this.f4P.f2230IL = drawable;
            return this;
        }

        public C0552IL1Iii setMessage(CharSequence charSequence) {
            this.f4P.f2231IiL = charSequence;
            return this;
        }

        public C0552IL1Iii setTitle(CharSequence charSequence) {
            this.f4P.f2247lLi1LL = charSequence;
            return this;
        }

        public C0552IL1Iii setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2250lL = charSequenceArr;
            iilll1.llliI = onClickListener;
            return this;
        }

        public C0552IL1Iii setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2236Ll1 = charSequence;
            iilll1.f2228ILl = onClickListener;
            return this;
        }

        public C0552IL1Iii setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.Lil = charSequence;
            iilll1.f2246llL1ii = onClickListener;
            return this;
        }

        public C0552IL1Iii setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2238L11I = charSequence;
            iilll1.ILL = onClickListener;
            return this;
        }

        public C0552IL1Iii setView(View view) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f22531 = view;
            iilll1.f2251l = 0;
            iilll1.f2252LLlI1 = false;
            return this;
        }

        public C0552IL1Iii setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2250lL = charSequenceArr;
            iilll1.f2248iILLl = onMultiChoiceClickListener;
            iilll1.f27 = zArr;
            iilll1.llI = true;
            return this;
        }

        public C0552IL1Iii setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2229IIi = cursor;
            iilll1.llliI = onClickListener;
            iilll1.f2237L1l = i;
            iilll1.f2234LIll = str;
            iilll1.f2242l1IIi1 = true;
            return this;
        }

        @Deprecated
        public C0552IL1Iii setView(View view, int i, int i2, int i3, int i4) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f22531 = view;
            iilll1.f2251l = 0;
            iilll1.f2252LLlI1 = true;
            iilll1.f2239LlLLL = i;
            iilll1.f2244lIII = i2;
            iilll1.LL1IL = i3;
            iilll1.f2233L111 = i4;
            return this;
        }

        public C0552IL1Iii setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2229IIi = cursor;
            iilll1.f2248iILLl = onMultiChoiceClickListener;
            iilll1.f2241ill = str;
            iilll1.f2234LIll = str2;
            iilll1.llI = true;
            return this;
        }

        public C0552IL1Iii setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.f2250lL = charSequenceArr;
            iilll1.llliI = onClickListener;
            iilll1.f2237L1l = i;
            iilll1.f2242l1IIi1 = true;
            return this;
        }

        public C0552IL1Iii setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.iILLL1 iilll1 = this.f4P;
            iilll1.I11L = listAdapter;
            iilll1.llliI = onClickListener;
            iilll1.f2237L1l = i;
            iilll1.f2242l1IIi1 = true;
            return this;
        }
    }

    public IL1Iii(Context context, int i) {
        super(context, ILil(context, i));
        this.f3718ILil = new AlertController(getContext(), this, getWindow());
    }

    public static int ILil(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(ILil.ILil.IL1Iii.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView IL1Iii() {
        return this.f3718ILil.m2994IL();
    }

    @Override // ILil.ILil.p021Ll1.IL, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3718ILil.Ilil();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f3718ILil.m2998iILLL1(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f3718ILil.m2995IiL(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // ILil.ILil.p021Ll1.IL, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f3718ILil.m3001llL1ii(charSequence);
    }
}
