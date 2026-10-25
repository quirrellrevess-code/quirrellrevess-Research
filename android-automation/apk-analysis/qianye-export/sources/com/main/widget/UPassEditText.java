package com.main.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class UPassEditText extends AppCompatEditText {
    private boolean isMasked;
    private String maskedText;

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) UPassEditText.this.getContext().getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{11, 13, 22, 66, 17, 107, 15, 6, 18, 95, 10, 80}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 81, 82, 83, 81}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 0, 1, 80, 87}, "067df2"))))).toggleSoftInput(0, 2);
        }
    }

    public UPassEditText(Context context) {
        super(context);
        setup();
    }

    private String getMaskedText(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            sb.append(I1I.IL1Iii.IL1Iii(new byte[]{78}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 0, 0, 83, 81}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 88, 13, 1, 7}, "0ea5cd"))));
        }
        return sb.toString();
    }

    private void setup() {
        this.isMasked = true;
        this.maskedText = BuildConfig.FLAVOR;
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
        setCursorVisible(false);
        new Handler().postDelayed(new IL1Iii(), 500L);
    }

    public boolean isMasked() {
        return this.isMasked;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        String maskedText = getMaskedText(this.maskedText);
        if (!this.isMasked) {
            maskedText = getText().toString();
        }
        canvas.drawText(maskedText, getCompoundPaddingLeft(), getBaseline(), getPaint());
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.maskedText = charSequence.toString();
    }

    public void setMasked(boolean z) {
        this.isMasked = z;
        invalidate();
    }

    public UPassEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }

    public UPassEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup();
    }
}
