package com.main.widget;

import I1I.IL1Iii;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class IPView extends AbsEditTextGroup {
    public IPView(Context context) {
        this(context, null, 0);
    }

    @Override // com.main.widget.AbsEditTextGroup
    public void I1I(TextView textView) {
        textView.setPadding(0, 0, 0, 5);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundColor(-1);
        textView.setGravity(80);
    }

    @Override // com.main.widget.AbsEditTextGroup
    public void ILil(AbsEditText absEditText) {
    }

    @Override // com.main.widget.AbsEditTextGroup, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().length() == getDelMaxLength()) {
            for (int i = 0; i < this.f2897IL.size() - 1; i++) {
                if (this.f2897IL.get(i).hasFocus()) {
                    this.f2897IL.get(i).clearFocus();
                    int i2 = i + 1;
                    this.f2897IL.get(i2).requestFocus();
                    String string = this.f2897IL.get(i).getText().toString();
                    if (Integer.parseInt(string) > 255) {
                        this.f2897IL.get(i).setText(string.substring(0, 2));
                        this.f2897IL.get(i2).setText(string.substring(2, 3));
                        this.f2897IL.get(i2).setSelection(1);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.main.widget.AbsEditTextGroup
    public AbsEditText getAbsEditText() {
        return new IPEditText(getContext());
    }

    @Override // com.main.widget.AbsEditTextGroup, android.view.ViewGroup
    public int getChildCount() {
        return 7;
    }

    @Override // com.main.widget.AbsEditTextGroup
    public int getDelMaxLength() {
        return 3;
    }

    @Override // com.main.widget.AbsEditTextGroup
    public String getSemicolomText() {
        return IL1Iii.IL1Iii(new byte[]{72}, IL1Iii.IL1Iii(new byte[]{80, 80, 93, 7, 92, 6}, IL1Iii.IL1Iii(new byte[]{1, 88, 87, 86, 81, 5}, "793442")));
    }

    public void setGatewayText(String[] strArr) {
        if (strArr == null) {
            strArr = new String[]{IL1Iii.IL1Iii(new byte[]{7, 3, 87}, IL1Iii.IL1Iii(new byte[]{4, 0, 82, 86, 1, 15}, IL1Iii.IL1Iii(new byte[]{84, 84, 81, 81, 82, 1}, "eba719"))), IL1Iii.IL1Iii(new byte[]{6, 87, 13}, IL1Iii.IL1Iii(new byte[]{85, 3, 11, 81, 7, 93}, IL1Iii.IL1Iii(new byte[]{2, 89, 87, 7, 83, 82}, "c8d277"))), IL1Iii.IL1Iii(new byte[]{84, 2, 1}, IL1Iii.IL1Iii(new byte[]{7, 5, 4, 6, 4, 86}, IL1Iii.IL1Iii(new byte[]{82, 5, 81, 86, 5, 3}, "37ae4e"))), IL1Iii.IL1Iii(new byte[]{9}, IL1Iii.IL1Iii(new byte[]{13, 10, 6, 82, 0, 83}, IL1Iii.IL1Iii(new byte[]{81, 1, 12, 85, 87, 7}, "e99f40")))};
        }
        for (int i = 0; i < this.f2897IL.size(); i++) {
            this.f2897IL.get(i).setText(strArr[i]);
        }
    }

    public IPView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
