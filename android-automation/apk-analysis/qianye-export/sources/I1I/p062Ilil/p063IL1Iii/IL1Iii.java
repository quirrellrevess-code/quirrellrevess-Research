package I1I.p062Ilil.p063IL1Iii;

import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.C0610il;
import I1I.I1I.p008IL.lIlii;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import com.main.app.UIState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: HudMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static IL1Iii f3444Ilil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3446IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Handler f3447ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Map<Integer, TextView> f3445I1I = new HashMap();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public WindowManager f1099IL = null;

    /* JADX INFO: compiled from: HudMgr.java */
    public class I1I implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f3449ILil;

        public I1I(int i) {
            this.f3449ILil = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            UIState.getInstance().hideHud(this.f3449ILil);
            if (IL1Iii.this.f3445I1I.containsKey(Integer.valueOf(this.f3449ILil))) {
                TextView textView = (TextView) IL1Iii.this.f3445I1I.get(Integer.valueOf(this.f3449ILil));
                IL1Iii.this.f3445I1I.remove(Integer.valueOf(this.f3449ILil));
                try {
                    if (textView.getParent() != null) {
                        IL1Iii.this.f1099IL.removeView(textView);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.IL1Iii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HudMgr.java */
    public class CallableC0536IL1Iii implements Callable<Integer> {
        public CallableC0536IL1Iii() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Integer call() throws Exception {
            int baseId = UIState.getInstance().getBaseId();
            try {
                TextView textView = new TextView(IL1Iii.this.f3446IL1Iii);
                textView.setGravity(17);
                IL1Iii.this.m1245Ll1(textView);
                IL1Iii.this.f3445I1I.put(Integer.valueOf(baseId), textView);
                UIState.getInstance().createHud(baseId);
            } catch (Exception unused) {
            }
            return Integer.valueOf(baseId);
        }
    }

    /* JADX INFO: compiled from: HudMgr.java */
    public class ILil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f3451I1I;
        public final /* synthetic */ int ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f3452ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public final /* synthetic */ int f1100ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ String f3453Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f1101IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final /* synthetic */ int f1102IiL;
        public final /* synthetic */ int Lil;
        public final /* synthetic */ int LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public final /* synthetic */ int f1103Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final /* synthetic */ int f1104L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ int f1105iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public final /* synthetic */ int f1106lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ String f1108lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public final /* synthetic */ int f1109il;

        public ILil(int i, String str, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f3452ILil = i;
            this.f3451I1I = str;
            this.f1101IL = i2;
            this.f3453Ilil = str2;
            this.f1108lLi1LL = str3;
            this.f1105iILLL1 = i3;
            this.f1102IiL = i4;
            this.f1104L11I = i5;
            this.f1109il = i6;
            this.ILL = i7;
            this.f1103Ll1 = i8;
            this.f1106lIiI = i9;
            this.f1100ILl = i10;
            this.Lil = i11;
            this.LlLI1 = i12;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (IL1Iii.this.f3445I1I.containsKey(Integer.valueOf(this.f3452ILil))) {
                UIState.getInstance().showHUD(this.f3452ILil, this.f3451I1I, this.f1101IL, this.f3453Ilil, this.f1108lLi1LL, this.f1105iILLL1, this.f1102IiL, this.f1104L11I, this.f1109il, this.ILL, this.f1103Ll1, this.f1106lIiI, this.f1100ILl, this.Lil, this.LlLI1);
                try {
                    TextView textView = (TextView) IL1Iii.this.f3445I1I.get(Integer.valueOf(this.f3452ILil));
                    textView.setTextSize(2, this.f1101IL);
                    int i = this.LlLI1;
                    if (i == 0) {
                        textView.setGravity(51);
                    } else if (i == 1) {
                        textView.setGravity(17);
                    } else if (i == 2) {
                        textView.setGravity(49);
                    } else if (i == 3) {
                        textView.setGravity(19);
                    } else if (i == 4) {
                        textView.setGravity(83);
                    } else if (i == 5) {
                        textView.setGravity(53);
                    } else if (i == 6) {
                        textView.setGravity(21);
                    } else if (i == 7) {
                        textView.setGravity(85);
                    } else if (i == 8) {
                        textView.setGravity(81);
                    }
                    l1IIi1.I1I().m1014ILl(textView, this.f3453Ilil);
                    l1IIi1.I1I().m1020lIiI(textView, this.f1108lLi1LL);
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) textView.getTag();
                    int i2 = this.f1102IiL;
                    int i3 = this.f1104L11I;
                    int i4 = this.f1109il;
                    if (i4 <= 0 && this.ILL <= 0) {
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                    } else if (i4 <= 0 || this.ILL > 0) {
                        int i5 = this.ILL;
                        if (i5 > 0 && i4 <= 0) {
                            layoutParams.height = i5;
                            layoutParams.width = -2;
                        } else if (i4 > 0 && i5 > 0) {
                            layoutParams.width = i4;
                            layoutParams.height = i5;
                        }
                    } else {
                        layoutParams.width = i4;
                        layoutParams.height = -2;
                    }
                    int i6 = this.f1105iILLL1;
                    if (i6 == 0) {
                        layoutParams.x = i2;
                        layoutParams.y = i3;
                        layoutParams.gravity = 51;
                    } else if (i6 == 1) {
                        layoutParams.x = i2;
                        layoutParams.y = i3;
                        layoutParams.gravity = 17;
                    } else if (i6 == 2) {
                        layoutParams.x = i2;
                        layoutParams.y = i3;
                        layoutParams.gravity = 49;
                    } else if (i6 == 3) {
                        layoutParams.x = i2;
                        layoutParams.y = i3;
                        layoutParams.gravity = 19;
                    } else {
                        int i7 = (int) (lIlii.m1123IIi(lIlii.LL1IL()).y * 0.1f);
                        layoutParams.x = 0;
                        layoutParams.y = i7;
                        layoutParams.gravity = 81;
                    }
                    textView.setText(this.f3451I1I);
                    lIlii.m1117ILl(IL1Iii.this.f3446IL1Iii, this.f1103Ll1);
                    lIlii.m1117ILl(IL1Iii.this.f3446IL1Iii, this.f1106lIiI);
                    lIlii.m1117ILl(IL1Iii.this.f3446IL1Iii, this.f1100ILl);
                    lIlii.m1117ILl(IL1Iii.this.f3446IL1Iii, this.Lil);
                    textView.setPadding(this.f1103Ll1, this.f1106lIiI, this.f1100ILl, this.Lil);
                    textView.setVisibility(0);
                    if (textView.getParent() != null) {
                        IL1Iii.this.f1099IL.updateViewLayout(textView, layoutParams);
                    } else {
                        IL1Iii.this.f1099IL.addView(textView, layoutParams);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public IL1Iii() {
        new Semaphore(0);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static IL1Iii m1244IiL() {
        if (f3444Ilil == null) {
            f3444Ilil = new IL1Iii();
        }
        return f3444Ilil;
    }

    public void ILL(Map<Integer, UIState.I1I> map) {
        for (Map.Entry<Integer, UIState.I1I> entry : map.entrySet()) {
            try {
                Integer key = entry.getKey();
                UIState.I1I value = entry.getValue();
                TextView textView = new TextView(this.f3446IL1Iii);
                textView.setGravity(17);
                m1245Ll1(textView);
                this.f3445I1I.put(key, textView);
                if (value.state == 1) {
                    m1248lIiI(key.intValue(), value.text, value.size, value.color, value.f75bg, value.pos, value.f76x, value.f77y, value.width, value.height, value.paddleft, value.paddingtop, value.paddingright, value.paddingbottom, value.align);
                }
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 58}, I1I.IL1Iii.IL1Iii(new byte[]{94, 82, 86, 2, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{81, 0, 4, 87, 2, 5}, "70a4ad"))), I1I.IL1Iii.IL1Iii(new byte[]{82, 20, 17, 11, 15, 12, 9}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 83, 83, 11, 4}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 0, 84, 1, 83}, "7e018f"))) + e.toString());
                e.printStackTrace();
            }
        }
    }

    public synchronized void Ilil() {
        this.f3445I1I.clear();
        UIState.getInstance().clearHud();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m1245Ll1(TextView textView) {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.flags = 408;
            layoutParams.format = -3;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.x = 0;
            layoutParams.y = 0;
            textView.setTag(layoutParams);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 110}, I1I.IL1Iii.IL1Iii(new byte[]{82, 84, 11, 6, 90, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 86, 5, 1, 10, 95}, "346339"))), I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 86, 21, 82, 74, 16, 15}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 84, 87, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 84, 80, 82, 93}, "fd223d"))) + e.toString());
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public synchronized int m1246L11I(int i) {
        this.f3447ILil.post(new I1I(i));
        return 0;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public synchronized void m1247iILLL1() {
        Iterator<Map.Entry<Integer, TextView>> it = this.f3445I1I.entrySet().iterator();
        while (it.hasNext()) {
            TextView value = it.next().getValue();
            try {
                if (value.getParent() != null) {
                    this.f1099IL.removeView(value);
                }
            } catch (Exception unused) {
            }
            it.remove();
        }
        UIState.getInstance().clearHud();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public synchronized int m1248lIiI(int i, String str, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f3447ILil.post(new ILil(i, str, i2, str2, str3, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12));
        return 0;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public synchronized int m1249lLi1LL() {
        return ((Integer) new C0610il().ILil(new CallableC0536IL1Iii())).intValue();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1250il(Context context) {
        this.f3446IL1Iii = context;
        this.f3447ILil = new Handler(Looper.getMainLooper());
        this.f1099IL = (WindowManager) this.f3446IL1Iii.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{67, 12, 13, 83, 86, 22}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 0, 81, 93, 5}, I1I.IL1Iii.IL1Iii(new byte[]{3, 82, 5, 4, 92, 2}, "b1fb8f"))));
    }
}
