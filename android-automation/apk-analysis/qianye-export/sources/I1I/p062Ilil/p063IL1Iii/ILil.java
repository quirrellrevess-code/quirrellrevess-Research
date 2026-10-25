package I1I.p062Ilil.p063IL1Iii;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qyzs.smn2.R;

/* JADX INFO: compiled from: ToastUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static ILil f1110IiL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f3454I1I;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Handler f1113lLi1LL;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public TextView f3455IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public RelativeLayout f3456ILil = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public WindowManager f1111IL = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public WindowManager.LayoutParams f3457Ilil = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Runnable f1112iILLL1 = new IL1Iii();

    /* JADX INFO: compiled from: ToastUtil.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ILil.this.f3456ILil.getParent() != null) {
                ILil.this.f1111IL.removeView(ILil.this.f3456ILil);
            }
        }
    }

    public ILil(Context context) {
        this.f3454I1I = null;
        this.f1113lLi1LL = null;
        this.f3454I1I = context;
        this.f1113lLi1LL = new Handler(Looper.getMainLooper());
        m1255lLi1LL();
    }

    public static Point I1I(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static ILil m1251IL(Context context) {
        if (f1110IiL == null) {
            f1110IiL = new ILil(context);
        }
        return f1110IiL;
    }

    public void Ilil() {
        this.f1113lLi1LL.post(this.f1112iILLL1);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1252IiL(String str, int i, int i2, int i3) {
        m1253L11I(str, i, i2, i3);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m1253L11I(String str, int i, int i2, int i3) {
        try {
            this.f1113lLi1LL.removeCallbacks(this.f1112iILLL1);
        } catch (Exception unused) {
        }
        if (i3 > 0) {
            this.f3455IL1Iii.setTextSize(2, i3);
        } else {
            this.f3455IL1Iii.setTextSize(2, 12.0f);
        }
        if (i > 0 || i2 > 0) {
            WindowManager.LayoutParams layoutParams = this.f3457Ilil;
            layoutParams.gravity = 51;
            layoutParams.x = i;
            layoutParams.y = i2;
        } else {
            int i4 = (int) (I1I(this.f3454I1I).y * 0.1f);
            WindowManager.LayoutParams layoutParams2 = this.f3457Ilil;
            layoutParams2.gravity = 81;
            layoutParams2.y = i4;
        }
        this.f3455IL1Iii.setText(str);
        if (this.f3456ILil.getParent() == null) {
            this.f1111IL.addView(this.f3456ILil, this.f3457Ilil);
        } else {
            this.f1111IL.updateViewLayout(this.f3456ILil, this.f3457Ilil);
        }
        this.f3455IL1Iii.setVisibility(0);
        this.f1113lLi1LL.postDelayed(this.f1112iILLL1, 3000L);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m1254iILLL1() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f3457Ilil = layoutParams;
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
    public final void m1255lLi1LL() {
        this.f1111IL = (WindowManager) this.f3454I1I.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{68, 94, 12, 86, 89, 18}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 1, 81, 83, 92}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 6, 84, 3, 15}, "2ae7f6"))));
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f3454I1I).inflate(R.layout.toast, (ViewGroup) null);
        this.f3456ILil = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tvText);
        this.f3455IL1Iii = textView;
        textView.setVisibility(8);
        m1254iILLL1();
    }
}
