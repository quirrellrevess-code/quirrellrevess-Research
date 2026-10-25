package com.main.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsEditTextGroup extends LinearLayout implements TextWatcher {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f5368I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public float f5369ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ArrayList<AbsEditText> f2897IL;

    public class IL1Iii implements View.OnKeyListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public AbsEditText f5370I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public AbsEditText f5371ILil;

        public IL1Iii(AbsEditTextGroup absEditTextGroup, AbsEditText absEditText, AbsEditText absEditText2) {
            this.f5370I1I = absEditText;
            this.f5371ILil = absEditText2;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 67 || keyEvent.getAction() != 0 || this.f5371ILil.getSelectionStart() != 0) {
                return false;
            }
            this.f5371ILil.clearFocus();
            this.f5370I1I.requestFocus();
            AbsEditText absEditText = this.f5370I1I;
            absEditText.setSelection(absEditText.getText().toString().trim().length());
            return true;
        }
    }

    public AbsEditTextGroup(Context context) {
        this(context, null, 0);
    }

    public abstract void I1I(TextView textView);

    public void IL1Iii() {
        for (int i = 0; i < getChildCount(); i++) {
            if (i % 2 == 0) {
                AbsEditText absEditTextIlil = Ilil();
                this.f2897IL.add(absEditTextIlil);
                addView(absEditTextIlil);
            } else {
                addView(m3488lLi1LL());
            }
        }
    }

    public abstract void ILil(AbsEditText absEditText);

    public AbsEditText Ilil() {
        AbsEditText absEditText = getAbsEditText();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        absEditText.setLayoutParams(layoutParams);
        absEditText.setTextSize(this.f5369ILil);
        absEditText.setTextColor(-7829368);
        absEditText.setGravity(17);
        int i = this.f5368I1I;
        absEditText.setPadding(i, i, i, i);
        absEditText.setSingleLine();
        absEditText.setHint(I1I.IL1Iii.IL1Iii(new byte[]{5}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 81, 14, 0, 8}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 87, 93, 87, 10}, "434ea3"))));
        absEditText.setFocusableInTouchMode(true);
        absEditText.setBackgroundDrawable(new ColorDrawable(-1));
        ILil(absEditText);
        return absEditText;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3487IL() {
        for (int i = 0; i < this.f2897IL.size(); i++) {
            this.f2897IL.get(i).addTextChangedListener(this);
            if (i != 0) {
                this.f2897IL.get(i).setOnKeyListener(new IL1Iii(this, this.f2897IL.get(i - 1), this.f2897IL.get(i)));
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.toString().length() == getDelMaxLength()) {
            for (int i = 0; i < this.f2897IL.size() - 1; i++) {
                if (this.f2897IL.get(i).hasFocus()) {
                    this.f2897IL.get(i).clearFocus();
                    this.f2897IL.get(i + 1).requestFocus();
                    return;
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public abstract AbsEditText getAbsEditText();

    public byte[] getBytesWithIP() {
        int iIntValue;
        byte[] bArr = new byte[4];
        for (int i = 0; i < this.f2897IL.size(); i++) {
            try {
                iIntValue = Integer.valueOf(this.f2897IL.get(i).getText().toString()).intValue();
            } catch (Exception unused) {
                iIntValue = 0;
            }
            bArr[i] = (byte) iIntValue;
        }
        return bArr;
    }

    public byte[] getBytesWithMac() {
        byte[] bArr = new byte[6];
        for (int i = 0; i < this.f2897IL.size(); i++) {
            bArr[i] = Integer.valueOf(this.f2897IL.get(i).getText().toString(), 16).byteValue();
        }
        return bArr;
    }

    @Override // android.view.ViewGroup
    public abstract int getChildCount();

    public ArrayList<AbsEditText> getChildEditTextViews() {
        return this.f2897IL;
    }

    public abstract int getDelMaxLength();

    public abstract String getSemicolomText();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public TextView m3488lLi1LL() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        textView.setTextSize(this.f5369ILil);
        textView.setTextColor(-12303292);
        textView.setText(getSemicolomText());
        I1I(textView);
        return textView;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public AbsEditTextGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsEditTextGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5369ILil = 16.0f;
        this.f5368I1I = 4;
        this.f2897IL = new ArrayList<>();
        IL1Iii();
        m3487IL();
    }
}
