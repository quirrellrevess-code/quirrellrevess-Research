package I1I.p014IL.IL1Iii;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.maning.mndialoglibrary.view.MNHudProgressWheel;

/* JADX INFO: compiled from: MProgressDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static RelativeLayout f3576I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static I1I.p014IL.IL1Iii.p017iILLL1.IL1Iii f3577IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static I1I.p014IL.IL1Iii.p015IiL.IL1Iii f3578ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static MNHudProgressWheel f3579Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static RelativeLayout f1165IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static TextView f1166lLi1LL;

    /* JADX INFO: renamed from: I1I.I丨L.IL1Iii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MProgressDialog.java */
    public static class DialogInterfaceOnCancelListenerC0544IL1Iii implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (IL1Iii.f3578ILil != null && IL1Iii.f3578ILil.LlLI1 != null) {
                IL1Iii.f3578ILil.LlLI1.onDismiss();
                IL1Iii.f3578ILil.LlLI1 = null;
            }
            IL1Iii.m1426iILLL1();
        }
    }

    /* JADX INFO: compiled from: MProgressDialog.java */
    public static class ILil implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (IL1Iii.f3578ILil == null || !IL1Iii.f3578ILil.f3582ILil) {
                return;
            }
            IL1Iii.Ilil();
        }
    }

    public static void I1I() {
        if (f3578ILil == null) {
            f3578ILil = new I1I.I丨L.IL1Iii.I丨iL.IL1Iii.ILil().IL1Iii();
        }
    }

    public static void Ilil() {
        I1I.p014IL.IL1Iii.p016L11I.IL1Iii iL1Iii;
        try {
            try {
                I1I.p014IL.IL1Iii.p017iILLL1.IL1Iii iL1Iii2 = f3577IL1Iii;
                if (iL1Iii2 != null && iL1Iii2.isShowing()) {
                    I1I.p014IL.IL1Iii.p015IiL.IL1Iii iL1Iii3 = f3578ILil;
                    if (iL1Iii3 != null && (iL1Iii = iL1Iii3.LlLI1) != null) {
                        iL1Iii.onDismiss();
                        f3578ILil.LlLI1 = null;
                    }
                    f3577IL1Iii.dismiss();
                }
            } catch (Exception e) {
                Log.e(">>>MProgressDialog>>>", "MProgressDialog-dismissProgress异常:" + e.toString());
            }
        } finally {
            m1426iILLL1();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1423IL(Context context) {
        I1I.p014IL.IL1Iii.p015IiL.IL1Iii iL1Iii = f3578ILil;
        if (iL1Iii != null && iL1Iii.f1175llL1ii != 0 && f3577IL1Iii.getWindow() != null) {
            f3577IL1Iii.getWindow().setWindowAnimations(f3578ILil.f1175llL1ii);
        }
        f3577IL1Iii.setCanceledOnTouchOutside(f3578ILil.f3582ILil);
        f3577IL1Iii.setCancelable(f3578ILil.f3580I1I);
        f3576I1I.setBackgroundColor(f3578ILil.f1168IL);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f3578ILil.f3583Ilil);
        gradientDrawable.setStroke(I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.f1169IiL), f3578ILil.f1176lLi1LL);
        gradientDrawable.setCornerRadius(I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.f1172iILLL1));
        if (Build.VERSION.SDK_INT >= 16) {
            f1165IL.setBackground(gradientDrawable);
        } else {
            f1165IL.setBackgroundDrawable(gradientDrawable);
        }
        f1165IL.setPadding(I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.f1174lIlii), I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.iIi1), I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.iIlLiL), I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.I11li1));
        I1I.p014IL.IL1Iii.p015IiL.IL1Iii iL1Iii2 = f3578ILil;
        int i = iL1Iii2.f1178lL;
        if (i > 0 && iL1Iii2.I11L > 0) {
            f1165IL.setMinimumWidth(I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, i));
            f1165IL.setMinimumHeight(I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.I11L));
        }
        f3579Ilil.setBarColor(f3578ILil.f1171L11I);
        f3579Ilil.setBarWidth(I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.f1177il));
        f3579Ilil.setRimColor(f3578ILil.f1170Ll1);
        f3579Ilil.setRimWidth(f3578ILil.f1173lIiI);
        ViewGroup.LayoutParams layoutParams = f3579Ilil.getLayoutParams();
        layoutParams.width = I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.ILL);
        layoutParams.height = I1I.p014IL.IL1Iii.p018il.IL1Iii.IL1Iii(context, f3578ILil.ILL);
        f3579Ilil.setLayoutParams(layoutParams);
        f1166lLi1LL.setTextColor(f3578ILil.f1167ILl);
        f1166lLi1LL.setTextSize(f3578ILil.Lil);
        f3576I1I.setOnClickListener(new ILil());
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m1424IiL(Context context, CharSequence charSequence) {
        m1425L11I(context, charSequence, null);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static void m1425L11I(Context context, CharSequence charSequence, I1I.p014IL.IL1Iii.p015IiL.IL1Iii iL1Iii) {
        Ilil();
        if (iL1Iii == null) {
            try {
                iL1Iii = new I1I.I丨L.IL1Iii.I丨iL.IL1Iii.ILil().IL1Iii();
            } catch (Exception e) {
                Log.e(">>>MProgressDialog>>>", "MProgressDialog-showProgress异常:" + e.toString());
                return;
            }
        }
        f3578ILil = iL1Iii;
        m1427lLi1LL(context);
        if (f3577IL1Iii == null || f1166lLi1LL == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            f1166lLi1LL.setVisibility(8);
        } else {
            f1166lLi1LL.setVisibility(0);
            f1166lLi1LL.setText(charSequence);
        }
        f3577IL1Iii.show();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m1426iILLL1() {
        f3578ILil = null;
        f3577IL1Iii = null;
        f3576I1I = null;
        f1165IL = null;
        f3579Ilil = null;
        f1166lLi1LL = null;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1427lLi1LL(Context context) {
        I1I();
        try {
            View viewInflate = LayoutInflater.from(context).inflate(I1I.mn_progress_dialog_layout, (ViewGroup) null);
            I1I.p014IL.IL1Iii.p017iILLL1.IL1Iii iL1Iii = new I1I.p014IL.IL1Iii.p017iILLL1.IL1Iii(context, IL.MNCustomDialog);
            f3577IL1Iii = iL1Iii;
            iL1Iii.setContentView(viewInflate);
            f3577IL1Iii.ILil(f3578ILil.f3581IL1Iii);
            f3577IL1Iii.setOnCancelListener(new DialogInterfaceOnCancelListenerC0544IL1Iii());
            f3576I1I = (RelativeLayout) viewInflate.findViewById(I1I.p014IL.IL1Iii.ILil.dialog_window_background);
            f1165IL = (RelativeLayout) viewInflate.findViewById(I1I.p014IL.IL1Iii.ILil.dialog_view_bg);
            f3579Ilil = (MNHudProgressWheel) viewInflate.findViewById(I1I.p014IL.IL1Iii.ILil.progress_wheel);
            f1166lLi1LL = (TextView) viewInflate.findViewById(I1I.p014IL.IL1Iii.ILil.tv_show);
            f3579Ilil.m3493iILLL1();
            m1423IL(context);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(">>>MProgressDialog>>>", "MProgressDialog-initDialog异常:" + e.toString());
        }
    }
}
