package I1I.p062Ilil.p064Ilil.ILil;

import I1I.p062Ilil.p064Ilil.IL1Iii.IL;
import I1I.p062Ilil.p064Ilil.ILil.p010L11I.ILil;
import I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1;
import ILil.p028IiL.p029ILl.LL1IL.I1I;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
import org.opencv.calib3d.Calib3d;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: UiSelector.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends IL {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public IL f3543Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public I1I.p062Ilil.p064Ilil.ILil.IL1Iii f1151IL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f3542I1I = true;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1152lLi1LL = false;

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: UiSelector.java */
    public class IL1Iii extends iILLL1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f3544IL1Iii;

        public IL1Iii(String str) {
            this.f3544IL1Iii = str;
        }

        @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
        public boolean ILil(lLi1LL lli1ll) {
            return (IiL.this.f1151IL.ILil().ILil() + I1I.IL1Iii.IL1Iii(new byte[]{95, 10, 7, 29}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 2, 5, 80, 2}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 84, 0, 86, 86}, "bf573b"))) + this.f3544IL1Iii).equals(lli1ll.m1385LIll());
        }
    }

    static {
        I1I.IL1Iii.IL1Iii(new byte[]{55, 15, 100, 87, 8, 3, 1, 18, 88, 64}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 1, 83, 84, 95}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 83, 3, 84, 95}, "4eebdf")));
    }

    public IiL(I1I.p062Ilil.p064Ilil.ILil.IL1Iii iL1Iii) {
        this.f1151IL = iL1Iii;
    }

    /* JADX INFO: renamed from: I1 */
    public boolean m29I1() {
        return LiL1(Calib3d.CALIB_TILTED_MODEL, new ILil[0]);
    }

    public lLi1LL I1IILIIL() {
        return m1368IillIi();
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public boolean m1354I1L11L() {
        return LiL1(64, new ILil[0]);
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL
    /* JADX INFO: renamed from: IIi丨丨I */
    public IL mo1324IIiI(String str) {
        super.mo1324IIiI(m1356LIl(str));
        return this;
    }

    public boolean ILI1Ll() {
        return LiL1(I1I.IL1Iii.Lil.ILil(), new ILil[0]);
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public boolean m1355ILLIi() {
        return LiL1(128, new ILil[0]);
    }

    /* JADX INFO: renamed from: I丨 */
    public boolean m30I() {
        return LiL1(1048576, new ILil[0]);
    }

    public lLi1LL[] L1iI1(long j) {
        new ArrayList();
        iILLL1 iilll1M1369i11i = m1369i11i(Integer.MAX_VALUE);
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (iilll1M1369i11i.ILil() && !this.f1152lLi1LL) {
            if (Thread.currentThread().isInterrupted()) {
                throw new ILil();
            }
            if (j >= 0 && SystemClock.uptimeMillis() - jUptimeMillis > j) {
                return null;
            }
            try {
                Thread.sleep(50L);
                iilll1M1369i11i = m1369i11i(Integer.MAX_VALUE);
            } catch (InterruptedException unused) {
                throw new ILil();
            }
        }
        if (iilll1M1369i11i != null) {
            return iilll1M1369i11i.m1372iILLL1();
        }
        return null;
    }

    public boolean LI11() {
        return LiL1(32768, new ILil[0]);
    }

    public boolean LII(int i, int i2) {
        return LiL1(131072, new ILil.IL(I1I.IL1Iii.IL1Iii(new byte[]{117, 34, 98, 122, 127, 43, 107, 32, 100, 116, 101, 40, 113, 47, 98, 108, 99, 32, 120, 36, 117, 103, 121, 42, 122, 62, 101, 103, 113, 55, 96, 62, 127, 125, 100}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 83, 3, 83, 86}, I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 6, 1, 86, 5}, "1fc156"))), i), new ILil.IL(I1I.IL1Iii.IL1Iii(new byte[]{115, 39, 49, 124, 43, 126, 109, 37, 55, 114, 49, 125, 119, 42, 49, 106, 55, 117, 126, 33, 38, 97, 45, 127, 124, 59, 32, 123, 32, 111, 123, 42, 49}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 83, 3, 2, 2}, I1I.IL1Iii.IL1Iii(new byte[]{13, 87, 85, 82, 94, 4}, "96cd86"))), i2));
    }

    public boolean LIlLi(String str) {
        return LiL1(Calib3d.CALIB_FIX_TANGENT_DIST, new ILil.C0542ILil(I1I.IL1Iii.IL1Iii(new byte[]{118, 32, 97, 43, 124, 45, 104, 34, 103, 37, 102, 46, 114, 45, 97, 61, 96, 38, 99, 60, 97, 39, 107, 55, 104, 32, 125, 35, 97, 48, 114, 50, 96, 39, 125, 32, 114}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 6, 91, 3, 90}, I1I.IL1Iii.IL1Iii(new byte[]{7, 1, 0, 11, 0, 13}, "513204"))), str));
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public final String m1356LIl(String str) {
        return (str.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{76}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 6, 83, 0, 7}, I1I.IL1Iii.IL1Iii(new byte[]{89, 82, 7, 82, 90, 87}, "8721b5")))) && str.endsWith(I1I.IL1Iii.IL1Iii(new byte[]{26}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 83, 5, 15, 5}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 93, 3, 5, 5}, "30962c")))) && str.length() > 2) ? str.substring(1, str.length() - 1) : str;
    }

    /* JADX INFO: renamed from: LL */
    public boolean m31LL() {
        return LiL1(I1I.IL1Iii.f1621llL1ii.ILil(), new ILil[0]);
    }

    public final boolean LiL1(int i, ILil... iLilArr) {
        return m35li(Integer.MAX_VALUE).Ilil(i, iLilArr);
    }

    public boolean Liil1L1l() {
        return LiL1(8192, new ILil[0]);
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public boolean m1357LlLiLL() {
        return LiL1(65536, new ILil[0]);
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL
    /* JADX INFO: renamed from: L丨1l */
    public IL mo1334L1l(String str) {
        super.mo1334L1l(m1356LIl(str));
        return this;
    }

    /* JADX INFO: renamed from: i1 */
    public boolean m32i1() {
        return LiL1(Calib3d.CALIB_FIX_TAUX_TAUY, new ILil[0]);
    }

    /* JADX INFO: renamed from: iI */
    public boolean m33iI() {
        return LiL1(16384, new ILil[0]);
    }

    public boolean iIilII1() {
        return LiL1(16, new ILil[0]);
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public boolean m1358iIl1il() {
        return LiL1(32, new ILil[0]);
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public boolean m1359iI1LI() {
        return LiL1(I1I.IL1Iii.LlLI1.ILil(), new ILil[0]);
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public void m1360iILilI() {
        this.f1152lLi1LL = true;
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public final void m1361iiIIi11() {
        this.f1151IL.IL1Iii();
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public boolean m1362ili11() {
        return LiL1(I1I.IL1Iii.iIi1.ILil(), new ILil[0]);
    }

    public lLi1LL ill1LI1l(long j) {
        if (j == -1) {
            return m1368IillIi();
        }
        iILLL1 iilll1M1369i11i = m1369i11i(1);
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (iilll1M1369i11i.ILil() && !this.f1152lLi1LL) {
            if (Thread.currentThread().isInterrupted()) {
                throw new ILil();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis > j) {
                return null;
            }
            try {
                Thread.sleep(50L);
                iilll1M1369i11i = m1369i11i(1);
            } catch (InterruptedException unused) {
                throw new ILil();
            }
        }
        return iilll1M1369i11i.I1I(0);
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public boolean m1363i1I1I1l() {
        return LiL1(4096, new ILil[0]);
    }

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public boolean m1364iILiiLl(int i, int i2) {
        return LiL1(I1I.IL1Iii.f1614ILl.ILil(), new ILil.IL(I1I.IL1Iii.IL1Iii(new byte[]{82, 10, 5, 19, 87, 8, 87, 74, 23, 8, 93, 22, 29, 5, 2, 2, 93, 18, 64, 13, 3, 8, 84, 8, 71, 29, 79, 0, 91, 21, 90, 11, 15, 79, 121, 51, 116, 49, 44, 36, 118, 53, 108, 54, 46, 54, 103, 40, 125, 48}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 87, 3, 8, 83}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 83, 0, 6, 7}, "eeeb65"))), i), new ILil.IL(I1I.IL1Iii.IL1Iii(new byte[]{86, 91, 86, 69, 95, 88, 83, 27, 68, 94, 85, 70, 25, 84, 81, 84, 85, 66, 68, 92, 80, 94, 92, 88, 67, 76, 28, 86, 83, 69, 94, 90, 92, 25, 113, 99, 112, 96, 127, 114, 126, 101, 104, 118, 125, 123, 101, 124, 121, 106, 123, 121, 100}, I1I.IL1Iii.IL1Iii(new byte[]{82, 3, 81, 1, 81, 2}, I1I.IL1Iii.IL1Iii(new byte[]{87, 4, 6, 14, 86, 11}, "22e878"))), i2));
    }

    public lLi1LL l1Lll(int i) {
        iILLL1 iilll1M1369i11i = m1369i11i(Integer.MAX_VALUE);
        while (iilll1M1369i11i.ILil() && !this.f1152lLi1LL) {
            if (Thread.currentThread().isInterrupted()) {
                throw new ILil();
            }
            try {
                Thread.sleep(50L);
                iilll1M1369i11i = m1369i11i(Integer.MAX_VALUE);
            } catch (InterruptedException unused) {
                throw new ILil();
            }
        }
        if (i >= iilll1M1369i11i.m1373lLi1LL()) {
            return null;
        }
        return iilll1M1369i11i.I1I(i);
    }

    public boolean lI1I1() {
        return LiL1(I1I.IL1Iii.f1619lIiI.ILil(), new ILil[0]);
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public boolean m1365lIIiIlL() {
        return LiL1(1, new ILil[0]);
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL
    /* JADX INFO: renamed from: lI丨II */
    public IL mo1341lIII(String str) {
        super.mo1341lIII(m1356LIl(str));
        return this;
    }

    /* JADX INFO: renamed from: lL */
    public lLi1LL m34lL() {
        return l1Lll(0);
    }

    /* JADX INFO: renamed from: li */
    public iILLL1 m35li(int i) {
        iILLL1 iilll1M1369i11i = m1369i11i(i);
        while (iilll1M1369i11i.ILil() && !this.f1152lLi1LL) {
            if (Thread.currentThread().isInterrupted()) {
                throw new ILil();
            }
            try {
                Thread.sleep(50L);
                iilll1M1369i11i = m1369i11i(i);
            } catch (InterruptedException unused) {
                throw new ILil();
            }
        }
        return iilll1M1369i11i;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL
    /* JADX INFO: renamed from: ll丨L1ii */
    public IL mo1343llL1ii(String str) {
        super.mo1343llL1ii(m1356LIl(str));
        return this;
    }

    /* JADX INFO: renamed from: l丨 */
    public boolean m36l() {
        return LiL1(4, new ILil[0]);
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public boolean m1366li11() {
        return LiL1(2, new ILil[0]);
    }

    /* JADX INFO: renamed from: 丨1 */
    public boolean m371() {
        return LiL1(I1I.IL1Iii.f1620lIlii.ILil(), new ILil[0]);
    }

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public boolean m13671iIl(float f) {
        return LiL1(I1I.IL1Iii.iIlLiL.ILil(), new ILil.I1I(I1I.IL1Iii.IL1Iii(new byte[]{83, 12, 5, 64, 13, 88, 86, 76, 23, 91, 7, 70, 28, 3, 2, 81, 7, 66, 65, 11, 3, 91, 14, 88, 70, 27, 79, 83, 1, 69, 91, 13, 15, 28, 35, 99, 117, 55, 44, 119, 44, 101, 109, 50, 51, 125, 37, 99, 119, 49, 50, 109, 52, 112, 126, 55, 36}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 80, 87, 80, 2}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 87, 7, 3, 2}, "c5fb11"))), f));
    }

    /* JADX INFO: renamed from: 丨IillIi, reason: contains not printable characters */
    public lLi1LL m1368IillIi() {
        iILLL1 iilll1M35li = m35li(1);
        if (iilll1M35li.ILil()) {
            return null;
        }
        return iilll1M35li.I1I(0);
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public iILLL1 m1369i11i(int i) {
        m1361iiIIi11();
        if (this.f3542I1I) {
            List<AccessibilityNodeInfo> listMo858iILLL1 = this.f1151IL.mo858iILLL1();
            return listMo858iILLL1 == null ? iILLL1.f3546ILil : m1348lL(lLi1LL.I11L(listMo858iILLL1, this.f3543Ilil), i);
        }
        AccessibilityNodeInfo accessibilityNodeInfoI1I = this.f1151IL.I1I();
        return accessibilityNodeInfoI1I == null ? iILLL1.f3546ILil : m1348lL(lLi1LL.m1374lL(accessibilityNodeInfoI1I, this.f3543Ilil), i);
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public IiL m1370i11LL(String str) {
        if (TextUtils.isEmpty(str) || str.contains(I1I.IL1Iii.IL1Iii(new byte[]{14}, I1I.IL1Iii.IL1Iii(new byte[]{13, 1, 3, 92, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{11, 85, 83, 9, 2, 7}, "2aa0f7"))))) {
            super.m1349l(str);
        } else {
            IL1Iii(new IL1Iii(str));
        }
        return this;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL
    /* JADX INFO: renamed from: 丨il */
    public IL mo1347il(String str) {
        super.mo1347il(m1356LIl(str));
        return this;
    }
}
