package ILil.p028IiL.Lil;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: AutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii implements View.OnTouchListener {
    public static final int iIi1 = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f1676ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Runnable f4123Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final View f1677IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1678IiL;
    public boolean Lil;
    public boolean LlLI1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1680L11I;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1682lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f1683lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean f1684llL1ii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final C0568IL1Iii f4122ILil = new C0568IL1Iii();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Interpolator f4121I1I = new AccelerateInterpolator();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public float[] f1685lLi1LL = {0.0f, 0.0f};

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public float[] f1681iILLL1 = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public float[] f1686il = {0.0f, 0.0f};
    public float[] ILL = {0.0f, 0.0f};

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public float[] f1679Ll1 = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: ILil.I丨iL.Lil.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoScrollHelper.java */
    public static class C0568IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f4124I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4125IL1Iii;
        public int ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4126ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public float f1687IL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public float f1692il;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public long f4127Ilil = Long.MIN_VALUE;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public long f1689L11I = -1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public long f1691lLi1LL = 0;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f1690iILLL1 = 0;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f1688IiL = 0;

        public int I1I() {
            return this.f1688IiL;
        }

        public void IL1Iii() {
            if (this.f1691lLi1LL == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fM2215iILLL1 = m2215iILLL1(Ilil(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.f1691lLi1LL;
            this.f1691lLi1LL = jCurrentAnimationTimeMillis;
            float f = j * fM2215iILLL1;
            this.f1690iILLL1 = (int) (this.f4124I1I * f);
            this.f1688IiL = (int) (f * this.f1687IL);
        }

        public void ILL(int i) {
            this.f4125IL1Iii = i;
        }

        public int ILil() {
            return this.f1690iILLL1;
        }

        public final float Ilil(long j) {
            long j2 = this.f4127Ilil;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.f1689L11I;
            if (j3 < 0 || j < j3) {
                return IL1Iii.Ilil((j - j2) / this.f4125IL1Iii, 0.0f, 1.0f) * 0.5f;
            }
            float f = this.f1692il;
            return (1.0f - f) + (f * IL1Iii.Ilil((j - j3) / this.ILL, 0.0f, 1.0f));
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int m2211IL() {
            float f = this.f4124I1I;
            return (int) (f / Math.abs(f));
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public boolean m2212IiL() {
            return this.f1689L11I > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1689L11I + ((long) this.ILL);
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public void m2213Ll1(float f, float f2) {
            this.f4124I1I = f;
            this.f1687IL = f2;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void m2214L11I() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.ILL = IL1Iii.m2199lLi1LL((int) (jCurrentAnimationTimeMillis - this.f4127Ilil), 0, this.f4126ILil);
            this.f1692il = Ilil(jCurrentAnimationTimeMillis);
            this.f1689L11I = jCurrentAnimationTimeMillis;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final float m2215iILLL1(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public void m2216lIiI() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f4127Ilil = jCurrentAnimationTimeMillis;
            this.f1689L11I = -1L;
            this.f1691lLi1LL = jCurrentAnimationTimeMillis;
            this.f1692il = 0.5f;
            this.f1690iILLL1 = 0;
            this.f1688IiL = 0;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int m2217lLi1LL() {
            float f = this.f1687IL;
            return (int) (f / Math.abs(f));
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void m2218il(int i) {
            this.f4126ILil = i;
        }
    }

    /* JADX INFO: compiled from: AutoScrollHelper.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IL1Iii iL1Iii = IL1Iii.this;
            if (iL1Iii.LlLI1) {
                if (iL1Iii.f1676ILl) {
                    iL1Iii.f1676ILl = false;
                    iL1Iii.f4122ILil.m2216lIiI();
                }
                C0568IL1Iii c0568IL1Iii = IL1Iii.this.f4122ILil;
                if (c0568IL1Iii.m2212IiL() || !IL1Iii.this.I11li1()) {
                    IL1Iii.this.LlLI1 = false;
                    return;
                }
                IL1Iii iL1Iii2 = IL1Iii.this;
                if (iL1Iii2.Lil) {
                    iL1Iii2.Lil = false;
                    iL1Iii2.I1I();
                }
                c0568IL1Iii.IL1Iii();
                IL1Iii.this.mo2209il(c0568IL1Iii.ILil(), c0568IL1Iii.I1I());
                iIlLiL.m74iI(IL1Iii.this.f1677IL, this);
            }
        }
    }

    public IL1Iii(View view) {
        this.f1677IL = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        Lil(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        LlLI1(f3, f3);
        m2203Ll1(1);
        m2200ILl(Float.MAX_VALUE, Float.MAX_VALUE);
        iIi1(0.2f, 0.2f);
        iIlLiL(1.0f, 1.0f);
        ILL(iIi1);
        m2207lIlii(500);
        m2208llL1ii(500);
    }

    public static float Ilil(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m2199lLi1LL(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public boolean I11li1() {
        C0568IL1Iii c0568IL1Iii = this.f4122ILil;
        int iM2217lLi1LL = c0568IL1Iii.m2217lLi1LL();
        int iM2211IL = c0568IL1Iii.m2211IL();
        return (iM2217lLi1LL != 0 && ILil(iM2217lLi1LL)) || (iM2211IL != 0 && IL1Iii(iM2211IL));
    }

    public void I1I() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1677IL.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract boolean IL1Iii(int i);

    public IL1Iii ILL(int i) {
        this.f1680L11I = i;
        return this;
    }

    public abstract boolean ILil(int i);

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public IL1Iii m2200ILl(float f, float f2) {
        float[] fArr = this.f1681iILLL1;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final float m2201IL(int i, float f, float f2, float f3) {
        float fM2202IiL = m2202IiL(this.f1685lLi1LL[i], f2, this.f1681iILLL1[i], f);
        if (fM2202IiL == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1686il[i];
        float f5 = this.ILL[i];
        float f6 = this.f1679Ll1[i];
        float f7 = f4 * f3;
        return fM2202IiL > 0.0f ? Ilil(fM2202IiL * f7, f5, f6) : -Ilil((-fM2202IiL) * f7, f5, f6);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final float m2202IiL(float f, float f2, float f3, float f4) {
        float interpolation;
        float fIlil = Ilil(f * f2, 0.0f, f3);
        float fM2205iILLL1 = m2205iILLL1(f2 - f4, fIlil) - m2205iILLL1(f4, fIlil);
        if (fM2205iILLL1 < 0.0f) {
            interpolation = -this.f4121I1I.getInterpolation(-fM2205iILLL1);
        } else {
            if (fM2205iILLL1 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f4121I1I.getInterpolation(fM2205iILLL1);
        }
        return Ilil(interpolation, -1.0f, 1.0f);
    }

    public IL1Iii Lil(float f, float f2) {
        float[] fArr = this.f1679Ll1;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public IL1Iii LlLI1(float f, float f2) {
        float[] fArr = this.ILL;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public IL1Iii m2203Ll1(int i) {
        this.f1678IiL = i;
        return this;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m2204L11I() {
        if (this.f1676ILl) {
            this.LlLI1 = false;
        } else {
            this.f4122ILil.m2214L11I();
        }
    }

    public IL1Iii iIi1(float f, float f2) {
        float[] fArr = this.f1685lLi1LL;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public IL1Iii iIlLiL(float f, float f2) {
        float[] fArr = this.f1686il;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final float m2205iILLL1(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f1678IiL;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.LlLI1 && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public IL1Iii m2206lIiI(boolean z) {
        if (this.f1684llL1ii && !z) {
            m2204L11I();
        }
        this.f1684llL1ii = z;
        return this;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public IL1Iii m2207lIlii(int i) {
        this.f4122ILil.ILL(i);
        return this;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public IL1Iii m2208llL1ii(int i) {
        this.f4122ILil.m2218il(i);
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f1684llL1ii) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                m2204L11I();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    m2204L11I();
                }
            }
            return this.f1683lIlii && this.LlLI1;
        }
        this.Lil = true;
        this.f1682lIiI = false;
        this.f4122ILil.m2213Ll1(m2201IL(0, motionEvent.getX(), view.getWidth(), this.f1677IL.getWidth()), m2201IL(1, motionEvent.getY(), view.getHeight(), this.f1677IL.getHeight()));
        if (!this.LlLI1 && I11li1()) {
            m2210lL();
        }
        if (this.f1683lIlii) {
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public abstract void mo2209il(int i, int i2);

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final void m2210lL() {
        int i;
        if (this.f4123Ilil == null) {
            this.f4123Ilil = new ILil();
        }
        this.LlLI1 = true;
        this.f1676ILl = true;
        if (this.f1682lIiI || (i = this.f1680L11I) <= 0) {
            this.f4123Ilil.run();
        } else {
            iIlLiL.m2104LlLiLL(this.f1677IL, this.f4123Ilil, i);
        }
        this.f1682lIiI = true;
    }
}
