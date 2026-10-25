package I1I.p014IL.IL1Iii.p017iILLL1;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;

/* JADX INFO: compiled from: BaseDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends Dialog {
    public IL1Iii(Context context, int i) {
        super(context, i);
        IL1Iii();
    }

    public void I1I() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = I1I.p014IL.IL1Iii.p018il.IL1Iii.I1I(getContext());
        attributes.height = I1I.p014IL.IL1Iii.p018il.IL1Iii.ILil(getContext());
        attributes.gravity = 17;
        getWindow().setAttributes(attributes);
    }

    public final void IL1Iii() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public void ILil(boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT < 19) {
                getWindow().setFlags(1024, 1024);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(5894);
            }
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        I1I();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
