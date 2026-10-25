package I1I.I1I.p008IL;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.qyzs.smn2.R;

/* JADX INFO: renamed from: I1I.I1I.I丨L.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: CenterDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3333I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f3334ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public IL1Iii f3335Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int[] f1065IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil f1066lLi1LL;

    /* JADX INFO: renamed from: I1I.I1I.I丨L.I丨L$IL1Iii */
    /* JADX INFO: compiled from: CenterDialog.java */
    public interface IL1Iii {
        void IL1Iii(Dialog dialog);
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.I丨L$ILil */
    /* JADX INFO: compiled from: CenterDialog.java */
    public interface ILil {
        void IL1Iii(IL il, View view);
    }

    public IL(Context context, int i, int[] iArr, IL1Iii iL1Iii) {
        super(context, R.style.dialog_custom);
        this.f3335Ilil = null;
        this.f3335Ilil = iL1Iii;
        this.f3334ILil = context;
        this.f3333I1I = i;
        this.f1065IL = iArr;
    }

    public void IL1Iii(ILil iLil) {
        this.f1066lLi1LL = iLil;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        ILil iLil = this.f1066lLi1LL;
        if (iLil != null) {
            iLil.IL1Iii(this, view);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setGravity(17);
        setContentView(this.f3333I1I);
        Display defaultDisplay = ((Activity) this.f3334ILil).getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (defaultDisplay.getWidth() * 4) / 5;
        getWindow().setAttributes(attributes);
        setCanceledOnTouchOutside(true);
        for (int i : this.f1065IL) {
            findViewById(i).setOnClickListener(this);
        }
        IL1Iii iL1Iii = this.f3335Ilil;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(this);
        }
    }
}
