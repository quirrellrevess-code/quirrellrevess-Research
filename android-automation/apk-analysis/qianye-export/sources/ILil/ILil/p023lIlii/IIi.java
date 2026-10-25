package ILil.ILil.p023lIlii;

import ILil.ILil.C0631il;
import ILil.ILil.IL;
import ILil.ILil.IiL;
import ILil.ILil.iILLL1;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.mysql.jdbc.MysqlErrorNumbers;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.I丨Ii, reason: invalid class name */
/* JADX INFO: compiled from: TooltipPopup.java */
/* JADX INFO: loaded from: classes.dex */
public class IIi {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final TextView f3763I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3764IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final View f3765ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Rect f3766Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final WindowManager.LayoutParams f1360IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int[] f1361iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int[] f1362lLi1LL;

    public IIi(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1360IL = layoutParams;
        this.f3766Ilil = new Rect();
        this.f1362lLi1LL = new int[2];
        this.f1361iILLL1 = new int[2];
        this.f3764IL1Iii = context;
        View viewInflate = LayoutInflater.from(context).inflate(IiL.abc_tooltip, (ViewGroup) null);
        this.f3765ILil = viewInflate;
        this.f3763I1I = (TextView) viewInflate.findViewById(iILLL1.message);
        layoutParams.setTitle(IIi.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = MysqlErrorNumbers.ER_NO;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0631il.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public static View ILil(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public void I1I() {
        if (m1733IL()) {
            ((WindowManager) this.f3764IL1Iii.getSystemService("window")).removeView(this.f3765ILil);
        }
    }

    public final void IL1Iii(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f3764IL1Iii.getResources().getDimensionPixelOffset(IL.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f3764IL1Iii.getResources().getDimensionPixelOffset(IL.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f3764IL1Iii.getResources().getDimensionPixelOffset(z ? IL.tooltip_y_offset_touch : IL.tooltip_y_offset_non_touch);
        View viewILil = ILil(view);
        if (viewILil == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewILil.getWindowVisibleDisplayFrame(this.f3766Ilil);
        Rect rect = this.f3766Ilil;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f3764IL1Iii.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f3766Ilil.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewILil.getLocationOnScreen(this.f1361iILLL1);
        view.getLocationOnScreen(this.f1362lLi1LL);
        int[] iArr = this.f1362lLi1LL;
        int i4 = iArr[0];
        int[] iArr2 = this.f1361iILLL1;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (viewILil.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f3765ILil.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f3765ILil.getMeasuredHeight();
        int[] iArr3 = this.f1362lLi1LL;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i5 >= 0) {
                layoutParams.y = i5;
                return;
            } else {
                layoutParams.y = i6;
                return;
            }
        }
        if (measuredHeight + i6 <= this.f3766Ilil.height()) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i5;
        }
    }

    public void Ilil(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m1733IL()) {
            I1I();
        }
        this.f3763I1I.setText(charSequence);
        IL1Iii(view, i, i2, z, this.f1360IL);
        ((WindowManager) this.f3764IL1Iii.getSystemService("window")).addView(this.f3765ILil, this.f1360IL);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1733IL() {
        return this.f3765ILil.getParent() != null;
    }
}
