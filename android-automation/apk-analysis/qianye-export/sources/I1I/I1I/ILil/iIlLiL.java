package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.main.app.UIState;
import com.qyzs.smn2.R;

/* JADX INFO: compiled from: FloatControlView.java */
/* JADX INFO: loaded from: classes.dex */
public class iIlLiL extends LinearLayout implements View.OnClickListener {
    public View.OnTouchListener I11L;
    public boolean I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public WindowManager.LayoutParams f3229I1I;
    public TextView ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public WindowManager f3230ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public LinearLayout f1012ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public LinearLayout f3231Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public LinearLayout f1013IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ImageView f1014IiL;
    public LinearLayout Lil;
    public LinearLayout LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public LinearLayout f1015Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ImageView f1016L11I;
    public boolean iIi1;
    public boolean iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public LinearLayout f1017iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public LinearLayout f1018lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public View.OnClickListener f1019lIlii;
    public Runnable llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public LinearLayout f1020llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ImageView f1021lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public TextView f1022il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public CountDownTimer f1023lL;

    /* JADX INFO: compiled from: FloatControlView.java */
    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iIlLiL.this.m1000IiL();
        }
    }

    /* JADX INFO: compiled from: FloatControlView.java */
    public class IL1Iii extends CountDownTimer {
        public IL1Iii(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (j > 3000 || j <= 2000) {
                return;
            }
            iIlLiL.this.f1017iILLL1.setVisibility(8);
            if (iIlLiL.this.iIi1) {
                iIlLiL.this.m1001Ll1();
            }
        }
    }

    /* JADX INFO: compiled from: FloatControlView.java */
    public class ILil implements View.OnTouchListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f3234I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public float f3235ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public float f3236Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public float f1024IL;

        public ILil() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f3235ILil = rawX;
                this.f3234I1I = rawY;
                this.f1024IL = rawX;
                this.f3236Ilil = rawY;
                UIState.getInstance().setFloatWndPos(iIlLiL.this.f3229I1I.x, iIlLiL.this.f3229I1I.y);
                iIlLiL.this.m999ILl();
                return false;
            }
            if (action == 1) {
                float fLLL = (int) (lIlii.LLL(iIlLiL.this.getContext()) * 9.0f);
                if (Math.abs(rawX - this.f3235ILil) <= fLLL && Math.abs(rawY - this.f3234I1I) <= fLLL) {
                    iIlLiL.this.f1023lL.cancel();
                    iIlLiL.this.ILL(rawX, rawY);
                }
                iIlLiL.this.f1023lL.start();
                return false;
            }
            if (action != 2) {
                return false;
            }
            iIlLiL.this.f1023lL.cancel();
            WindowManager.LayoutParams layoutParams = iIlLiL.this.f3229I1I;
            layoutParams.x = (int) ((layoutParams.x + rawX) - this.f1024IL);
            int i = (int) ((iIlLiL.this.f3229I1I.y + rawY) - this.f3236Ilil);
            layoutParams.y = i;
            iIlLiL.this.Lil(layoutParams.x, i);
            this.f1024IL = rawX;
            this.f3236Ilil = rawY;
            return false;
        }
    }

    public iIlLiL(Context context) {
        super(context);
        this.iIi1 = false;
        this.iIlLiL = false;
        this.I11li1 = false;
        this.f1023lL = new IL1Iii(6000L, 1000L);
        this.I11L = new ILil();
        this.llliI = new I1I();
        m1002L11I();
    }

    public final void ILL(float f, float f2) {
        if (this.f1017iILLL1.getVisibility() == 0) {
            this.f1017iILLL1.setVisibility(8);
            return;
        }
        int[] iArr = new int[2];
        this.f3231Ilil.getLocationOnScreen(iArr);
        if (iArr[0] >= (lIlii.m22l(getContext()).x - f) / 2.0f) {
            this.f1013IL.removeView(this.f1017iILLL1);
            this.f1013IL.addView(this.f1017iILLL1, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3231Ilil.getLayoutParams();
            layoutParams.rightMargin = 1;
            layoutParams.leftMargin = 0;
            this.f3231Ilil.setLayoutParams(layoutParams);
        } else {
            this.f1013IL.removeView(this.f1017iILLL1);
            this.f1013IL.addView(this.f1017iILLL1, 1);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3231Ilil.getLayoutParams();
            layoutParams2.rightMargin = 0;
            layoutParams2.leftMargin = 1;
        }
        m1003lIiI();
        this.f1017iILLL1.setVisibility(0);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m999ILl() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3231Ilil.getLayoutParams();
        if (layoutParams.rightMargin < 0 || layoutParams.leftMargin < 0) {
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            this.f3231Ilil.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m1000IiL() {
        synchronized (this) {
            this.I11li1 = false;
        }
        if (this.f1017iILLL1.getVisibility() != 8) {
            m1001Ll1();
            return;
        }
        int width = getWidth();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        Point pointM1123IIi = lIlii.m1123IIi(getContext());
        if (width > 0) {
            int i3 = width / 2;
            if (i + i3 >= lIlii.m22l(getContext()).x / 2) {
                if (LlLI1(pointM1123IIi.x - i3)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3231Ilil.getLayoutParams();
                    layoutParams.rightMargin = (-getWidth()) / 2;
                    layoutParams.leftMargin = 0;
                    this.f3231Ilil.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (LlLI1(0)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3231Ilil.getLayoutParams();
                layoutParams2.rightMargin = 0;
                layoutParams2.leftMargin = (-getWidth()) / 2;
                this.f3231Ilil.setLayoutParams(layoutParams2);
            }
        }
    }

    public void Lil(int i, int i2) {
        if (getParent() != null) {
            WindowManager.LayoutParams layoutParams = this.f3229I1I;
            layoutParams.x = i;
            layoutParams.y = i2;
            this.f3230ILil.updateViewLayout(this, layoutParams);
        }
    }

    public boolean LlLI1(int i) {
        if (getParent() == null) {
            return false;
        }
        WindowManager.LayoutParams layoutParams = this.f3229I1I;
        layoutParams.x = i;
        this.f3230ILil.updateViewLayout(this, layoutParams);
        UIState uIState = UIState.getInstance();
        WindowManager.LayoutParams layoutParams2 = this.f3229I1I;
        uIState.setFloatWndPos(layoutParams2.x, layoutParams2.y);
        return true;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public synchronized void m1001Ll1() {
        if (!this.I11li1) {
            this.I11li1 = true;
            postDelayed(this.llliI, 1000L);
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m1002L11I() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_control, this);
        this.f1013IL = (LinearLayout) findViewById(R.id.container);
        this.f1021lLi1LL = (ImageView) findViewById(R.id.img_control);
        if (getContext().getResources().getInteger(R.integer.control_img_fill) != 0) {
            this.f1021lLi1LL.setScaleX(0.9f);
            this.f1021lLi1LL.setScaleY(0.9f);
        }
        m1004il();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llcontrol);
        this.f3231Ilil = linearLayout;
        linearLayout.setOnClickListener(null);
        this.f3231Ilil.setOnTouchListener(this.I11L);
        this.Lil = (LinearLayout) findViewById(R.id.img_control_mask);
        this.f1017iILLL1 = (LinearLayout) findViewById(R.id.toolbar);
        this.f1014IiL = (ImageView) findViewById(R.id.img_run);
        this.f1016L11I = (ImageView) findViewById(R.id.img_pause);
        this.f1015Ll1 = (LinearLayout) findViewById(R.id.llrun);
        this.f1018lIiI = (LinearLayout) findViewById(R.id.llpause);
        this.f1012ILl = (LinearLayout) findViewById(R.id.llsettings);
        this.LlLI1 = (LinearLayout) findViewById(R.id.llexit);
        this.f1020llL1ii = (LinearLayout) findViewById(R.id.lluserevent);
        if (getResources().getInteger(R.integer.is_add_settings) != 1) {
            this.f1012ILl.setVisibility(8);
        }
        if (getResources().getInteger(R.integer.is_add_pause) != 1) {
            this.f1018lIiI.setVisibility(8);
        }
        if (getResources().getInteger(R.integer.is_add_exit) != 1) {
            this.LlLI1.setVisibility(8);
        }
        if (getResources().getInteger(R.integer.is_add_userevent) != 1) {
            this.f1020llL1ii.setVisibility(8);
        }
        this.f1015Ll1.setOnClickListener(this);
        this.f1018lIiI.setOnClickListener(this);
        this.f1012ILl.setOnClickListener(this);
        this.LlLI1.setOnClickListener(this);
        this.f1020llL1ii.setOnClickListener(this);
        this.f1022il = (TextView) findViewById(R.id.tvrun_or_stop);
        this.ILL = (TextView) findViewById(R.id.tv_pause);
    }

    public boolean getPauseState() {
        return this.iIlLiL;
    }

    public boolean getRunState() {
        return this.iIi1;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final synchronized void m1003lIiI() {
        if (this.I11li1) {
            this.I11li1 = false;
            try {
                removeCallbacks(this.llliI);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f1019lIlii;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m999ILl();
        m1001Ll1();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1019lIlii = onClickListener;
    }

    public void setPauseState(boolean z) {
        this.iIlLiL = z;
        if (z) {
            this.f1016L11I.setImageResource(R.mipmap.img_continue);
            this.ILL.setText(I1I.IL1Iii.IL1Iii(new byte[]{-48, -120, -59, -124, -115, -98}, I1I.IL1Iii.IL1Iii(new byte[]{14, 2, 80, 80, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{1, 5, 10, 0, 6, 3}, "84831a"))));
        } else {
            this.f1016L11I.setImageResource(R.mipmap.img_pause);
            this.ILL.setText(I1I.IL1Iii.IL1Iii(new byte[]{-46, -87, -32, -44, -28, -83}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 82, 3, 92, 84}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 86, 1, 93, 0}, "23f3de"))));
        }
    }

    public void setRunState(boolean z) {
        this.iIi1 = z;
        if (z) {
            this.f1021lLi1LL.setAlpha(0.6f);
            this.Lil.setAlpha(1.0f);
            this.f1014IiL.setImageResource(R.mipmap.img_close);
            this.f1022il.setText(I1I.IL1Iii.IL1Iii(new byte[]{-47, -78, -83, -124, -101, -107}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 85, 3, 14, 3}, I1I.IL1Iii.IL1Iii(new byte[]{5, 85, 84, 87, 1, 3}, "dc0697"))));
            m1001Ll1();
            this.Lil.setBackgroundResource(R.drawable.floatview_imglightview);
            return;
        }
        this.f1021lLi1LL.setAlpha(1.0f);
        this.Lil.setAlpha(1.0f);
        this.Lil.setBackgroundResource(R.drawable.floatview_imgview);
        this.f1014IiL.setImageResource(R.mipmap.img_start);
        this.f1022il.setText(I1I.IL1Iii.IL1Iii(new byte[]{-41, -89, -101, -46, -68, -98}, I1I.IL1Iii.IL1Iii(new byte[]{81, 2, 81, 6, 84, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 1, 83, 86, 13}, "06db48"))));
        setPauseState(false);
        m1003lIiI();
        m999ILl();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m1004il() {
        this.f3230ILil = (WindowManager) getContext().getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{22, 95, 91, 80, 12, 68}, I1I.IL1Iii.IL1Iii(new byte[]{89, 6, 0, 13, 81, 5}, I1I.IL1Iii.IL1Iii(new byte[]{11, 83, 83, 13, 2, 87}, "3cf40a"))));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3229I1I = layoutParams;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.format = 1;
        layoutParams.flags = 262184;
        layoutParams.gravity = 51;
        layoutParams.x = lIlii.m22l(getContext()).x - this.f1013IL.getLayoutParams().width;
        this.f3229I1I.y = lIlii.m22l(getContext()).y / 2;
        this.f3229I1I.width = this.f1013IL.getLayoutParams().width;
        this.f3229I1I.height = this.f1013IL.getLayoutParams().height;
    }

    @Override // android.view.View
    public WindowManager.LayoutParams getLayoutParams() {
        return this.f3229I1I;
    }
}
