package com.main.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class IPEditText extends AbsEditText {
    public IPEditText(Context context) {
        this(context, null, 0);
    }

    @Override // com.main.widget.AbsEditText
    public int getEditTextInputType() {
        return 2;
    }

    @Override // com.main.widget.AbsEditText
    public char[] getInputFilterAcceptedChars() {
        return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @Override // com.main.widget.AbsEditText
    public int getMaxLength() {
        return 3;
    }

    public IPEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IPEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
