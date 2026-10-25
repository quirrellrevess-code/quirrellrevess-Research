package I1I.I1I.p008IL;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qyzs.smn2.R;

/* JADX INFO: renamed from: I1I.I1I.I丨L.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: MyToast.java */
/* JADX INFO: loaded from: classes.dex */
public class Ll1 {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static Ll1 f1067IiL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f3337I1I;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Handler f1070lLi1LL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public TextView f3338IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public LinearLayout f3339ILil = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public WindowManager f1068IL = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public WindowManager.LayoutParams f3340Ilil = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Runnable f1069iILLL1 = new IL1Iii();

    /* JADX INFO: renamed from: I1I.I1I.I丨L.Ll丨1$IL1Iii */
    /* JADX INFO: compiled from: MyToast.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Ll1.this.f3339ILil.getParent() != null) {
                Ll1.this.f1068IL.removeView(Ll1.this.f3339ILil);
            }
        }
    }

    public Ll1(Context context) {
        this.f3337I1I = null;
        this.f1070lLi1LL = null;
        this.f3337I1I = context;
        this.f1070lLi1LL = new Handler(Looper.getMainLooper());
        m1074lLi1LL();
    }

    public static Point I1I(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Ll1 m1071IL(Context context) {
        if (f1067IiL == null) {
            f1067IiL = new Ll1(context);
        }
        return f1067IiL;
    }

    public void Ilil() {
        this.f1070lLi1LL.post(this.f1069iILLL1);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1072IiL(String str) {
        try {
            this.f1070lLi1LL.removeCallbacks(this.f1069iILLL1);
        } catch (Exception unused) {
        }
        try {
            int i = (int) (I1I(this.f3337I1I).y * 0.1f);
            WindowManager.LayoutParams layoutParams = this.f3340Ilil;
            layoutParams.gravity = 81;
            layoutParams.y = i;
            this.f3338IL1Iii.setText(str);
            if (this.f3339ILil.getParent() == null) {
                this.f1068IL.addView(this.f3339ILil, this.f3340Ilil);
            } else {
                this.f1068IL.updateViewLayout(this.f3339ILil, this.f3340Ilil);
            }
            this.f3338IL1Iii.setVisibility(0);
            this.f1070lLi1LL.postDelayed(this.f1069iILLL1, 3000L);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 106}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 90, 9, 7, 13}, I1I.IL1Iii.IL1Iii(new byte[]{11, 6, 90, 80, 7, 91}, "979a0b"))), e.toString());
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m1073iILLL1() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f3340Ilil = layoutParams;
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.flags = 408;
            layoutParams.format = -3;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.x = 0;
            layoutParams.y = 0;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1074lLi1LL() {
        this.f1068IL = (WindowManager) this.f3337I1I.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{22, 11, 89, 7, 89, 18}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 7, 6, 15, 81}, I1I.IL1Iii.IL1Iii(new byte[]{6, 83, 9, 0, 13, 0}, "d69e44"))));
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f3337I1I).inflate(R.layout.mytoast, (ViewGroup) null);
        this.f3339ILil = linearLayout;
        TextView textView = (TextView) linearLayout.findViewById(R.id.tvText);
        this.f3338IL1Iii = textView;
        textView.setVisibility(8);
        m1073iILLL1();
    }
}
