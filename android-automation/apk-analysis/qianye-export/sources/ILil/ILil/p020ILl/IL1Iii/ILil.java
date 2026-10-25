package ILil.ILil.p020ILl.IL1Iii;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX INFO: compiled from: DrawableContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Rect f3706I1I;
    public long ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I f3707ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Drawable f3708Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Drawable f1277IL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public long f1279Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f1280L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1281iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public C0551ILil f1282lIiI;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Runnable f1284il;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1283lLi1LL = 255;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1278IiL = -1;

    /* JADX INFO: compiled from: DrawableContainer.java */
    public static abstract class I1I extends Drawable.ConstantState {
        public boolean I11L;
        public boolean I11li1;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3709I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ILil f3710IL1Iii;
        public Rect ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Resources f3711ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public int f1285ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f3712Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1286IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int f1287IiL;

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public ColorFilter f1288L111;
        public boolean LL1IL;
        public int Lil;
        public int LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public boolean f1289Ll1;

        /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
        public boolean f1290L1l;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public boolean f1291L11I;

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public int f1292LlLLL;
        public int iIi1;
        public boolean iIlLiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public Drawable[] f1293iILLL1;

        /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
        public boolean f1294l1IIi1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public boolean f1295lIiI;

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public int f1296lIII;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public boolean f1297lIlii;
        public PorterDuff.Mode llI;
        public boolean llliI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public int f1298llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public SparseArray<Drawable.ConstantState> f1299lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean f1300il;

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public boolean f1301lL;

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public boolean f1302l;

        /* JADX INFO: renamed from: 丨丨 */
        public ColorStateList f3;

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public boolean f1303LLlI1;

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public int f13041;

        public I1I(I1I i1i, ILil iLil, Resources resources) {
            this.f3709I1I = 160;
            this.f1291L11I = false;
            this.f1289Ll1 = false;
            this.llliI = true;
            this.f1292LlLLL = 0;
            this.f1296lIII = 0;
            this.f3710IL1Iii = iLil;
            this.f3711ILil = resources != null ? resources : i1i != null ? i1i.f3711ILil : null;
            int iM1620lLi1LL = ILil.m1620lLi1LL(resources, i1i != null ? i1i.f3709I1I : 0);
            this.f3709I1I = iM1620lLi1LL;
            if (i1i == null) {
                this.f1293iILLL1 = new Drawable[10];
                this.f1287IiL = 0;
                return;
            }
            this.f1286IL = i1i.f1286IL;
            this.f3712Ilil = i1i.f3712Ilil;
            this.f1301lL = true;
            this.I11L = true;
            this.f1291L11I = i1i.f1291L11I;
            this.f1289Ll1 = i1i.f1289Ll1;
            this.llliI = i1i.llliI;
            this.f1302l = i1i.f1302l;
            this.f13041 = i1i.f13041;
            this.f1292LlLLL = i1i.f1292LlLLL;
            this.f1296lIII = i1i.f1296lIII;
            this.LL1IL = i1i.LL1IL;
            this.f1288L111 = i1i.f1288L111;
            this.f1303LLlI1 = i1i.f1303LLlI1;
            this.f3 = i1i.f3;
            this.llI = i1i.llI;
            this.f1294l1IIi1 = i1i.f1294l1IIi1;
            this.f1290L1l = i1i.f1290L1l;
            if (i1i.f3709I1I == iM1620lLi1LL) {
                if (i1i.f1300il) {
                    this.ILL = new Rect(i1i.ILL);
                    this.f1300il = true;
                }
                if (i1i.f1295lIiI) {
                    this.f1285ILl = i1i.f1285ILl;
                    this.Lil = i1i.Lil;
                    this.LlLI1 = i1i.LlLI1;
                    this.f1298llL1ii = i1i.f1298llL1ii;
                    this.f1295lIiI = true;
                }
            }
            if (i1i.f1297lIlii) {
                this.iIi1 = i1i.iIi1;
                this.f1297lIlii = true;
            }
            if (i1i.iIlLiL) {
                this.I11li1 = i1i.I11li1;
                this.iIlLiL = true;
            }
            Drawable[] drawableArr = i1i.f1293iILLL1;
            this.f1293iILLL1 = new Drawable[drawableArr.length];
            this.f1287IiL = i1i.f1287IiL;
            SparseArray<Drawable.ConstantState> sparseArray = i1i.f1299lLi1LL;
            if (sparseArray != null) {
                this.f1299lLi1LL = sparseArray.clone();
            } else {
                this.f1299lLi1LL = new SparseArray<>(this.f1287IiL);
            }
            int i = this.f1287IiL;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                    if (constantState != null) {
                        this.f1299lLi1LL.put(i2, constantState);
                    } else {
                        this.f1293iILLL1[i2] = drawableArr[i2];
                    }
                }
            }
        }

        public final boolean I11L(int i, int i2) {
            int i3 = this.f1287IiL;
            Drawable[] drawableArr = this.f1293iILLL1;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f13041 = i;
            return z;
        }

        public final void I11li1(int i) {
            this.f1292LlLLL = i;
        }

        public synchronized boolean I1I() {
            if (this.f1301lL) {
                return this.I11L;
            }
            Ilil();
            this.f1301lL = true;
            int i = this.f1287IiL;
            Drawable[] drawableArr = this.f1293iILLL1;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.I11L = false;
                    return false;
                }
            }
            this.I11L = true;
            return true;
        }

        public final int IL1Iii(Drawable drawable) {
            int i = this.f1287IiL;
            if (i >= this.f1293iILLL1.length) {
                Lil(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f3710IL1Iii);
            this.f1293iILLL1[i] = drawable;
            this.f1287IiL++;
            this.f3712Ilil = drawable.getChangingConfigurations() | this.f3712Ilil;
            LlLI1();
            this.ILL = null;
            this.f1300il = false;
            this.f1295lIiI = false;
            this.f1301lL = false;
            return i;
        }

        public final int ILL() {
            if (!this.f1295lIiI) {
                m1625IL();
            }
            return this.LlLI1;
        }

        public final void ILil(Resources.Theme theme) {
            if (theme != null) {
                Ilil();
                int i = this.f1287IiL;
                Drawable[] drawableArr = this.f1293iILLL1;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f3712Ilil |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                m1635l(theme.getResources());
            }
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public final int m1624ILl() {
            if (this.f1297lIlii) {
                return this.iIi1;
            }
            Ilil();
            int i = this.f1287IiL;
            Drawable[] drawableArr = this.f1293iILLL1;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.iIi1 = opacity;
            this.f1297lIlii = true;
            return opacity;
        }

        public final void Ilil() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1299lLi1LL;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.f1293iILLL1[this.f1299lLi1LL.keyAt(i)] = iIi1(this.f1299lLi1LL.valueAt(i).newDrawable(this.f3711ILil));
                }
                this.f1299lLi1LL = null;
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m1625IL() {
            this.f1295lIiI = true;
            Ilil();
            int i = this.f1287IiL;
            Drawable[] drawableArr = this.f1293iILLL1;
            this.Lil = -1;
            this.f1285ILl = -1;
            this.f1298llL1ii = 0;
            this.LlLI1 = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1285ILl) {
                    this.f1285ILl = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.Lil) {
                    this.Lil = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.LlLI1) {
                    this.LlLI1 = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1298llL1ii) {
                    this.f1298llL1ii = minimumHeight;
                }
            }
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final int m1626IiL() {
            return this.f1287IiL;
        }

        public void Lil(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f1293iILLL1, 0, drawableArr, 0, i);
            this.f1293iILLL1 = drawableArr;
        }

        public void LlLI1() {
            this.f1297lIlii = false;
            this.iIlLiL = false;
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public final Rect m1627Ll1() {
            Rect rect = null;
            if (this.f1291L11I) {
                return null;
            }
            Rect rect2 = this.ILL;
            if (rect2 != null || this.f1300il) {
                return rect2;
            }
            Ilil();
            Rect rect3 = new Rect();
            int i = this.f1287IiL;
            Drawable[] drawableArr = this.f1293iILLL1;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i3 = rect3.left;
                    if (i3 > rect.left) {
                        rect.left = i3;
                    }
                    int i4 = rect3.top;
                    if (i4 > rect.top) {
                        rect.top = i4;
                    }
                    int i5 = rect3.right;
                    if (i5 > rect.right) {
                        rect.right = i5;
                    }
                    int i6 = rect3.bottom;
                    if (i6 > rect.bottom) {
                        rect.bottom = i6;
                    }
                }
            }
            this.f1300il = true;
            this.ILL = rect;
            return rect;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final int m1628L11I() {
            if (!this.f1295lIiI) {
                m1625IL();
            }
            return this.Lil;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.f1287IiL;
            Drawable[] drawableArr = this.f1293iILLL1;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f1299lLi1LL.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1286IL | this.f3712Ilil;
        }

        public final Drawable iIi1(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f13041);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f3710IL1Iii);
            return drawableMutate;
        }

        public final void iIlLiL(boolean z) {
            this.f1289Ll1 = z;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final Drawable m1629iILLL1(int i) {
            int iIndexOfKey;
            Drawable drawable = this.f1293iILLL1[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1299lLi1LL;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableIIi1 = iIi1(this.f1299lLi1LL.valueAt(iIndexOfKey).newDrawable(this.f3711ILil));
            this.f1293iILLL1[i] = drawableIIi1;
            this.f1299lLi1LL.removeAt(iIndexOfKey);
            if (this.f1299lLi1LL.size() == 0) {
                this.f1299lLi1LL = null;
            }
            return drawableIIi1;
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public final int m1630lIiI() {
            if (!this.f1295lIiI) {
                m1625IL();
            }
            return this.f1285ILl;
        }

        /* JADX INFO: renamed from: lI丨lii */
        public abstract void mo1617lIlii();

        public final void llliI(boolean z) {
            this.f1291L11I = z;
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public final boolean m1631llL1ii() {
            return this.f1289Ll1;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final int m1632lLi1LL() {
            return this.f1293iILLL1.length;
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public final int m1633il() {
            if (!this.f1295lIiI) {
                m1625IL();
            }
            return this.f1298llL1ii;
        }

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public final void m1634lL(int i) {
            this.f1296lIII = i;
        }

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public final void m1635l(Resources resources) {
            if (resources != null) {
                this.f3711ILil = resources;
                int iM1620lLi1LL = ILil.m1620lLi1LL(resources, this.f3709I1I);
                int i = this.f3709I1I;
                this.f3709I1I = iM1620lLi1LL;
                if (i != iM1620lLi1LL) {
                    this.f1295lIiI = false;
                    this.f1300il = false;
                }
            }
        }
    }

    /* JADX INFO: compiled from: DrawableContainer.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ILil.this.IL1Iii(true);
            ILil.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableContainer.java */
    public static class C0551ILil implements Drawable.Callback {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Drawable.Callback f3714ILil;

        public Drawable.Callback IL1Iii() {
            Drawable.Callback callback = this.f3714ILil;
            this.f3714ILil = null;
            return callback;
        }

        public C0551ILil ILil(Drawable.Callback callback) {
            this.f3714ILil = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f3714ILil;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f3714ILil;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m1620lLi1LL(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }

    public int I1I() {
        return this.f1278IiL;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void IL1Iii(boolean z) {
        boolean z2;
        Drawable drawable;
        long j;
        boolean z3 = true;
        this.f1281iILLL1 = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f1277IL;
        if (drawable2 != null) {
            long j2 = this.ILL;
            if (j2 != 0) {
                if (j2 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f1283lLi1LL);
                    this.ILL = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j2 - jUptimeMillis) * 255)) / this.f3707ILil.f1292LlLLL)) * this.f1283lLi1LL) / 255);
                    z2 = true;
                }
            }
            drawable = this.f3708Ilil;
            if (drawable != null) {
                j = this.f1279Ll1;
                if (j == 0) {
                    if (j <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f3708Ilil = null;
                        this.f1279Ll1 = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j - jUptimeMillis) * 255)) / this.f3707ILil.f1296lIII) * this.f1283lLi1LL) / 255);
                    }
                }
                if (z || !z3) {
                }
                scheduleSelf(this.f1284il, jUptimeMillis + 16);
                return;
            }
            this.f1279Ll1 = 0L;
            z3 = z2;
            if (z) {
            }
        }
        this.ILL = 0L;
        z2 = false;
        drawable = this.f3708Ilil;
        if (drawable != null) {
            j = this.f1279Ll1;
            if (j == 0) {
                if (j <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f3708Ilil = null;
                    this.f1279Ll1 = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j - jUptimeMillis) * 255)) / this.f3707ILil.f1296lIII) * this.f1283lLi1LL) / 255);
                }
            }
            if (z) {
            }
        }
        this.f1279Ll1 = 0L;
        z3 = z2;
        if (z) {
        }
    }

    public I1I ILil() {
        throw null;
    }

    public final boolean Ilil() {
        return isAutoMirrored() && ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2258lLi1LL(this) == 1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1621IL(Drawable drawable) {
        if (this.f1282lIiI == null) {
            this.f1282lIiI = new C0551ILil();
        }
        C0551ILil c0551ILil = this.f1282lIiI;
        c0551ILil.ILil(drawable.getCallback());
        drawable.setCallback(c0551ILil);
        try {
            if (this.f3707ILil.f1292LlLLL <= 0 && this.f1281iILLL1) {
                drawable.setAlpha(this.f1283lLi1LL);
            }
            I1I i1i = this.f3707ILil;
            if (i1i.f1303LLlI1) {
                drawable.setColorFilter(i1i.f1288L111);
            } else {
                if (i1i.f1294l1IIi1) {
                    ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawable, i1i.f3);
                }
                I1I i1i2 = this.f3707ILil;
                if (i1i2.f1290L1l) {
                    ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(drawable, i1i2.llI);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f3707ILil.llliI);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i >= 19) {
                drawable.setAutoMirrored(this.f3707ILil.LL1IL);
            }
            Rect rect = this.f3706I1I;
            if (i >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f1282lIiI.IL1Iii());
        }
    }

    /* JADX INFO: renamed from: I丨iL */
    public void mo1608IiL(I1I i1i) {
        this.f3707ILil = i1i;
        int i = this.f1278IiL;
        if (i >= 0) {
            Drawable drawableM1629iILLL1 = i1i.m1629iILLL1(i);
            this.f1277IL = drawableM1629iILLL1;
            if (drawableM1629iILLL1 != null) {
                m1621IL(drawableM1629iILLL1);
            }
        }
        this.f3708Ilil = null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m1622L11I(Resources resources) {
        this.f3707ILil.m1635l(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f3707ILil.ILil(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f3707ILil.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f3708Ilil;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1283lLi1LL;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3707ILil.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f3707ILil.I1I()) {
            return null;
        }
        this.f3707ILil.f1286IL = getChangingConfigurations();
        return this.f3707ILil;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1277IL;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f3706I1I;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f3707ILil.m1631llL1ii()) {
            return this.f3707ILil.m1628L11I();
        }
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f3707ILil.m1631llL1ii()) {
            return this.f3707ILil.m1630lIiI();
        }
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f3707ILil.m1631llL1ii()) {
            return this.f3707ILil.m1633il();
        }
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f3707ILil.m1631llL1ii()) {
            return this.f3707ILil.ILL();
        }
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1277IL;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f3707ILil.m1624ILl();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectM1627Ll1 = this.f3707ILil.m1627Ll1();
        if (rectM1627Ll1 != null) {
            rect.set(rectM1627Ll1);
            padding = (rectM1627Ll1.right | ((rectM1627Ll1.left | rectM1627Ll1.top) | rectM1627Ll1.bottom)) != 0;
        } else {
            Drawable drawable = this.f1277IL;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (Ilil()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m1623iILLL1(int i) {
        if (i == this.f1278IiL) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f3707ILil.f1296lIII > 0) {
            Drawable drawable = this.f3708Ilil;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f1277IL;
            if (drawable2 != null) {
                this.f3708Ilil = drawable2;
                this.f1279Ll1 = ((long) this.f3707ILil.f1296lIII) + jUptimeMillis;
            } else {
                this.f3708Ilil = null;
                this.f1279Ll1 = 0L;
            }
        } else {
            Drawable drawable3 = this.f1277IL;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0) {
            I1I i1i = this.f3707ILil;
            if (i < i1i.f1287IiL) {
                Drawable drawableM1629iILLL1 = i1i.m1629iILLL1(i);
                this.f1277IL = drawableM1629iILLL1;
                this.f1278IiL = i;
                if (drawableM1629iILLL1 != null) {
                    int i2 = this.f3707ILil.f1292LlLLL;
                    if (i2 > 0) {
                        this.ILL = jUptimeMillis + ((long) i2);
                    }
                    m1621IL(drawableM1629iILLL1);
                }
            } else {
                this.f1277IL = null;
                this.f1278IiL = -1;
            }
        } else {
            this.f1277IL = null;
            this.f1278IiL = -1;
        }
        if (this.ILL != 0 || this.f1279Ll1 != 0) {
            Runnable runnable = this.f1284il;
            if (runnable == null) {
                this.f1284il = new IL1Iii();
            } else {
                unscheduleSelf(runnable);
            }
            IL1Iii(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        I1I i1i = this.f3707ILil;
        if (i1i != null) {
            i1i.LlLI1();
        }
        if (drawable != this.f1277IL || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f3707ILil.LL1IL;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f3708Ilil;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f3708Ilil = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1277IL;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1281iILLL1) {
                this.f1277IL.setAlpha(this.f1283lLi1LL);
            }
        }
        if (this.f1279Ll1 != 0) {
            this.f1279Ll1 = 0L;
            z = true;
        }
        if (this.ILL != 0) {
            this.ILL = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1280L11I && super.mutate() == this) {
            I1I i1iILil = ILil();
            i1iILil.mo1617lIlii();
            mo1608IiL(i1iILil);
            this.f1280L11I = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3708Ilil;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1277IL;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f3707ILil.I11L(i, I1I());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f3708Ilil;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f1277IL;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3708Ilil;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1277IL;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f1277IL || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f1281iILLL1 && this.f1283lLi1LL == i) {
            return;
        }
        this.f1281iILLL1 = true;
        this.f1283lLi1LL = i;
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            if (this.ILL == 0) {
                drawable.setAlpha(i);
            } else {
                IL1Iii(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        I1I i1i = this.f3707ILil;
        if (i1i.LL1IL != z) {
            i1i.LL1IL = z;
            Drawable drawable = this.f1277IL;
            if (drawable != null) {
                ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2259il(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        I1I i1i = this.f3707ILil;
        i1i.f1303LLlI1 = true;
        if (i1i.f1288L111 != colorFilter) {
            i1i.f1288L111 = colorFilter;
            Drawable drawable = this.f1277IL;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        I1I i1i = this.f3707ILil;
        if (i1i.llliI != z) {
            i1i.llliI = z;
            Drawable drawable = this.f1277IL;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.ILL(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f3706I1I;
        if (rect == null) {
            this.f3706I1I = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f1277IL;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2252Ll1(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        I1I i1i = this.f3707ILil;
        i1i.f1294l1IIi1 = true;
        if (i1i.f3 != colorStateList) {
            i1i.f3 = colorStateList;
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(this.f1277IL, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        I1I i1i = this.f3707ILil;
        i1i.f1290L1l = true;
        if (i1i.llI != mode) {
            i1i.llI = mode;
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(this.f1277IL, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f3708Ilil;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f1277IL;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1277IL || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
