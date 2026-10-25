package com.main.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsEditText extends AppCompatEditText {

    public class IL1Iii extends NumberKeyListener {
        public IL1Iii() {
        }

        @Override // android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            return AbsEditText.this.getInputFilterAcceptedChars();
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return AbsEditText.this.getEditTextInputType();
        }
    }

    public AbsEditText(Context context) {
        this(context, null, 0);
    }

    public void IL1Iii() {
        setKeyListener(new IL1Iii());
    }

    public void ILil() {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(getMaxLength())});
    }

    public abstract int getEditTextInputType();

    public abstract char[] getInputFilterAcceptedChars();

    public abstract int getMaxLength();

    public AbsEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ILil();
        IL1Iii();
    }
}
