package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* JADX INFO: renamed from: I1I.I1I.ILil.LlLiL丨L丨, reason: invalid class name */
/* JADX INFO: compiled from: TouchEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLiLL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public long f3166IL1Iii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static LlLiLL f965lLi1LL = new LlLiLL();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static int f964iILLL1 = -1;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Instrumentation f3167ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final LlIl f3165I1I = new LlIl();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final MotionEvent.PointerProperties[] f966IL = new MotionEvent.PointerProperties[10];

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final MotionEvent.PointerCoords[] f3168Ilil = new MotionEvent.PointerCoords[10];

    public static LlLiLL IL1Iii() {
        return f965lLi1LL;
    }

    public boolean I1I(InputEvent inputEvent) {
        return m928IL(inputEvent, 0);
    }

    public void ILil() {
        this.f3167ILil = new Instrumentation();
        for (int i = 0; i < 10; i++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.toolType = 1;
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = 0.0f;
            pointerCoords.size = 1.0f;
            this.f966IL[i] = pointerProperties;
            this.f3168Ilil[i] = pointerCoords;
        }
    }

    public boolean Ilil(int i, int i2) {
        if (!lIlii.m1183IlL1ll1()) {
            return false;
        }
        try {
            if (i2 == 0 || i2 == 1) {
                this.f3167ILil.sendKeySync(new KeyEvent(i2, i));
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            this.f3167ILil.sendKeyDownUpSync(i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m928IL(InputEvent inputEvent, int i) {
        return C0001i1.Ilil().m952IL().ILil(inputEvent, i);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m929lLi1LL(int i, int i2, int i3, int i4) {
        int i5 = i2;
        if (lIlii.m1183IlL1ll1()) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            int iI1I = this.f3165I1I.I1I(i);
            if (iI1I == -1) {
                return false;
            }
            C0531 c0531 = new C0531(i3, i4);
            L11 l11ILil = this.f3165I1I.ILil(iI1I);
            if (i5 != 1 || l11ILil.I1I() == null) {
                l11ILil.m898lLi1LL(c0531);
            }
            l11ILil.m897iILLL1(1.0f);
            l11ILil.m896IiL(i5 == 1);
            int iM923iILLL1 = this.f3165I1I.m923iILLL1(this.f966IL, this.f3168Ilil);
            if (iM923iILLL1 == 1) {
                if (i5 == 0) {
                    this.f3166IL1Iii = jUptimeMillis;
                }
            } else if (i5 == 1) {
                i5 = (iI1I << 8) | 6;
            } else if (i5 == 0) {
                i5 = (iI1I << 8) | 5;
            }
            try {
                return I1I(MotionEvent.obtain(this.f3166IL1Iii, jUptimeMillis, i5, iM923iILLL1, this.f966IL, this.f3168Ilil, 0, 0, 1.0f, 1.0f, f964iILLL1, 0, 4098, 0));
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
