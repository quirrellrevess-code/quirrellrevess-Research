package com.main.widget;

import I1I.I1I.p008IL.lIlii;
import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class UEditText extends EditText {
    private TextView mCopy;
    private TextView mPaste;
    private PopupWindow popupWindow;

    public class IL1Iii implements View.OnLongClickListener {

        /* JADX INFO: renamed from: com.main.widget.UEditText$IL1Iii$IL1Iii, reason: collision with other inner class name */
        public class C0593IL1Iii implements PopupWindow.OnDismissListener {
            public C0593IL1Iii(IL1Iii iL1Iii) {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
            }
        }

        public class ILil implements View.OnClickListener {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final /* synthetic */ String f5376I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ String f5377ILil;

            public ILil(String str, String str2) {
                this.f5377ILil = str;
                this.f5376I1I = str2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.paste) {
                    int selectionStart = UEditText.this.getSelectionStart();
                    try {
                        UEditText.this.getText().insert(selectionStart, BuildConfig.FLAVOR + this.f5377ILil);
                        UEditText.this.setSelection(selectionStart + this.f5377ILil.length());
                    } catch (Exception unused) {
                    }
                } else if (view.getId() == R.id.copy) {
                    lIlii.m1190il(UEditText.this.getContext(), this.f5376I1I);
                }
                UEditText.this.popupWindow.dismiss();
            }
        }

        public IL1Iii() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            String clibboardText;
            try {
                clibboardText = UEditText.this.getClibboardText();
            } catch (Exception unused) {
                clibboardText = BuildConfig.FLAVOR;
            }
            String string = UEditText.this.getText().toString();
            if (TextUtils.isEmpty(clibboardText) && TextUtils.isEmpty(string)) {
                return false;
            }
            lIlii.I1I(100L);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(UEditText.this.getContext()).inflate(R.layout.layout_copy_paste, (ViewGroup) null);
            int width = view.getWidth() / 2;
            int height = (int) (((double) view.getHeight()) * 1.5d);
            UEditText.this.mCopy = (TextView) linearLayout.findViewById(R.id.copy);
            UEditText.this.mPaste = (TextView) linearLayout.findViewById(R.id.paste);
            int iMeasureText = (int) (UEditText.this.mCopy.getPaint().measureText(I1I.IL1Iii.IL1Iii(new byte[]{-45, -105, -66, -46, -72, -121}, "633701")) * 2.0f * 2.0f);
            if (TextUtils.isEmpty(string)) {
                UEditText.this.mCopy.setVisibility(8);
                UEditText.this.popupWindow = new PopupWindow(linearLayout, -2, height);
            } else if (TextUtils.isEmpty(clibboardText)) {
                UEditText.this.mPaste.setVisibility(8);
                UEditText.this.popupWindow = new PopupWindow(linearLayout, -2, height);
            } else {
                UEditText.this.popupWindow = new PopupWindow(linearLayout, -2, height);
            }
            UEditText.this.popupWindow.setOutsideTouchable(true);
            UEditText.this.popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            UEditText.this.popupWindow.setOnDismissListener(new C0593IL1Iii(this));
            ILil iLil = new ILil(clibboardText, string);
            if (UEditText.this.mCopy != null) {
                UEditText.this.mCopy.setOnClickListener(iLil);
            }
            if (UEditText.this.mPaste != null) {
                UEditText.this.mPaste.setOnClickListener(iLil);
            }
            int selectionStart = UEditText.this.getSelectionStart();
            Layout layout = UEditText.this.getLayout();
            if (selectionStart < 0 || selectionStart > UEditText.this.getText().length()) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                UEditText.this.popupWindow.showAtLocation(UEditText.this, 0, iArr[0] + (iMeasureText / 4), iArr[1] + height);
                return false;
            }
            float primaryHorizontal = layout.getPrimaryHorizontal(selectionStart);
            float lineBaseline = layout.getLineBaseline(layout.getLineForOffset(selectionStart));
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            UEditText.this.popupWindow.showAtLocation(UEditText.this, 0, (int) (primaryHorizontal + iArr2[0]), (int) (lineBaseline + iArr2[1]));
            return false;
        }
    }

    public UEditText(Context context) {
        super(context);
        init();
    }

    public String getClibboardText() {
        if (Build.VERSION.SDK_INT < 11) {
            return ((ClipboardManager) getContext().getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 91, 22, 86, 91, 84, 74, 86}, "582f44"))).getText().toString();
        }
        ClipData primaryClip = ((android.content.ClipboardManager) getContext().getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{90, 8, 95, 70, 1, 13, 88, 22, 82}, "9d66cb"))).getPrimaryClip();
        return (primaryClip == null || primaryClip.getItemCount() <= 0) ? BuildConfig.FLAVOR : primaryClip.getItemAt(0).getText().toString();
    }

    public void init() {
        setOnLongClickListener(new IL1Iii());
    }

    public UEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public UEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
