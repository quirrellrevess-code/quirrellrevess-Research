package I1I.p062Ilil.p064Ilil.ILil;

import I1I.I1I.ILil.C0003lL;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.IL1Iii.IL;
import ILil.p028IiL.p029ILl.LL1IL.I1I;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.flexbox.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.opencv.calib3d.Calib3d;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: UiObject.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f1153lLi1LL = IL1Iii.IL1Iii(new byte[]{98, 91, 122, 80, 94, 85, 84, 70}, IL1Iii.IL1Iii(new byte[]{6, 10, 80, 83, 13, 7}, IL1Iii.IL1Iii(new byte[]{80, 13, 80, 80, 12, 6}, "a55151")));

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public String f3548I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public AccessibilityNodeInfo f3549IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public List<AccessibilityNodeInfo> f3550ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f3551Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1154IL;

    public lLi1LL(List<AccessibilityNodeInfo> list, IL il, int i, int i2) {
        this.f3549IL1Iii = null;
        this.f3550ILil = null;
        this.f3548I1I = BuildConfig.FLAVOR;
        this.f1154IL = 0;
        this.f3550ILil = list;
        this.f1154IL = i;
        this.f3551Ilil = i2;
    }

    public static lLi1LL I11L(List<AccessibilityNodeInfo> list, IL il) {
        return new lLi1LL(list, il, 0, 0);
    }

    public static lLi1LL I11li1(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new lLi1LL(accessibilityNodeInfo, (IL) null, 0, -1);
    }

    public static Bundle ILil(ILil[] iLilArr) {
        Bundle bundle = new Bundle();
        for (ILil iLil : iLilArr) {
            iLil.IL1Iii(bundle);
        }
        return bundle;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static lLi1LL m1374lL(AccessibilityNodeInfo accessibilityNodeInfo, IL il) {
        return new lLi1LL(accessibilityNodeInfo, il, 0, -1);
    }

    /* JADX INFO: renamed from: I1 */
    public boolean m38I1() {
        return iIilII1(4096);
    }

    public Rect I1I() {
        int i;
        int i2;
        if (this.f3550ILil != null) {
            try {
                Point pointILI1Ll = lIlii.ILI1Ll();
                if (C0003lL.I1I().ILil() % 2 != 0) {
                    i = pointILI1Ll.y;
                    i2 = pointILI1Ll.x;
                } else {
                    i = pointILI1Ll.x;
                    i2 = pointILI1Ll.y;
                }
                Rect rect = new Rect(0, 0, i, i2);
                I1I.p062Ilil.p064Ilil.IL1Iii.lLi1LL.I1I(rect);
                return rect;
            } catch (Exception unused) {
            }
        }
        return I1I.p062Ilil.p064Ilil.IL1Iii.lLi1LL.ILil(this.f3549IL1Iii);
    }

    public boolean I1IILIIL() {
        try {
            return this.f3549IL1Iii.isScrollable();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public lLi1LL m1375I1L11L() {
        AccessibilityNodeInfo parent;
        try {
            if (this.f3550ILil == null && (parent = this.f3549IL1Iii.getParent()) != null) {
                return new lLi1LL(parent, this.f1154IL - 1, -1);
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public boolean m1376IIiI() {
        try {
            return this.f3549IL1Iii.isEditable();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean IL1Iii() {
        return iIilII1(64);
    }

    public boolean ILL() {
        return iIilII1(128);
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public boolean m1377ILLIi() {
        try {
            return this.f3549IL1Iii.isPassword();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m1378ILl() {
        try {
            return this.f3549IL1Iii.isClickable();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean Ilil() {
        try {
            return this.f3549IL1Iii.isCheckable();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: I丨 */
    public int m39I() {
        try {
            if (this.f3549IL1Iii.getCollectionItemInfo() == null) {
                return -1;
            }
            return this.f3549IL1Iii.getCollectionItemInfo().getRowSpan();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public CharSequence m1379IIi() {
        try {
            return this.f3549IL1Iii.isPassword() ? BuildConfig.FLAVOR : this.f3549IL1Iii.getText();
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Rect m1380IL() {
        int i;
        int i2;
        if (this.f3550ILil != null) {
            try {
                Point pointILI1Ll = lIlii.ILI1Ll();
                if (C0003lL.I1I().ILil() % 2 != 0) {
                    i = pointILI1Ll.y;
                    i2 = pointILI1Ll.x;
                } else {
                    i = pointILI1Ll.x;
                    i2 = pointILI1Ll.y;
                }
                Rect rect = new Rect(0, 0, i, i2);
                I1I.p062Ilil.p064Ilil.IL1Iii.lLi1LL.I1I(rect);
                return rect;
            } catch (Exception unused) {
            }
        }
        return I1I.p062Ilil.p064Ilil.IL1Iii.lLi1LL.IL1Iii(this.f3549IL1Iii);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int m1381IiL() {
        try {
            List<AccessibilityNodeInfo> list = this.f3550ILil;
            return list != null ? list.size() : this.f3549IL1Iii.getChildCount();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public boolean m1382L11() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return this.f3549IL1Iii.isContextClickable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean m1383L111() {
        return iIilII1(Calib3d.CALIB_TILTED_MODEL);
    }

    public boolean L1iI1() {
        return iIilII1(I1I.IL1Iii.f1620lIlii.ILil());
    }

    public boolean LI11(String str) {
        return m1397ili11(Calib3d.CALIB_FIX_TANGENT_DIST, new ILil.C0542ILil(IL1Iii.IL1Iii(new byte[]{116, 38, 48, 112, 126, 119, 106, 36, 54, 126, 100, 116, 112, 43, 48, 102, 98, 124, 97, 58, 48, 124, 105, 109, 106, 38, 44, 120, 99, 106, 112, 52, 49, 124, 127, 122, 112}, IL1Iii.IL1Iii(new byte[]{87, 87, 86, 92, 4, 0}, IL1Iii.IL1Iii(new byte[]{1, 11, 6, 86, 83, 13}, "c943f4"))), str));
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public void m1384LIl() {
        try {
            this.f3549IL1Iii.recycle();
        } catch (Exception e) {
            Log.w(f1153lLi1LL, this.f3548I1I, e);
        }
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public String m1385LIll() {
        try {
            return this.f3549IL1Iii.getViewIdResourceName();
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: LL */
    public boolean m40LL() {
        try {
            return this.f3549IL1Iii.isVisibleToUser();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean LL1IL() {
        try {
            return this.f3549IL1Iii.isEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean LLL() {
        try {
            return this.f3549IL1Iii.isLongClickable();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean LiL1() {
        return iIilII1(I1I.IL1Iii.f1619lIiI.ILil());
    }

    public String Liil1L1l() {
        CharSequence text;
        try {
            text = this.f3549IL1Iii.getText();
        } catch (Exception unused) {
            text = null;
        }
        return text == null ? BuildConfig.FLAVOR : text.toString();
    }

    public boolean Lil() {
        return iIilII1(Calib3d.CALIB_FIX_TAUX_TAUY);
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public boolean m1386LlIl() {
        try {
            return this.f3549IL1Iii.isDismissable();
        } catch (Exception unused) {
            return false;
        }
    }

    public int LlLI1() {
        try {
            if (this.f3549IL1Iii.getCollectionItemInfo() == null) {
                return -1;
            }
            return this.f3549IL1Iii.getCollectionItemInfo().getColumnIndex();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public int m1387LlLiLL() {
        try {
            if (this.f3549IL1Iii.getCollectionInfo() == null) {
                return 0;
            }
            return this.f3549IL1Iii.getCollectionInfo().getRowCount();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m1388Ll1() {
        return iIilII1(2);
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m1389L1l(Rect rect) {
        int i;
        int i2;
        try {
            if (this.f3550ILil == null) {
                this.f3549IL1Iii.getBoundsInScreen(rect);
                return;
            }
            Point pointILI1Ll = lIlii.ILI1Ll();
            if (C0003lL.I1I().ILil() % 2 != 0) {
                i = pointILI1Ll.y;
                i2 = pointILI1Ll.x;
            } else {
                i = pointILI1Ll.x;
                i2 = pointILI1Ll.y;
            }
            rect.left = 0;
            rect.top = 0;
            rect.right = i;
            rect.bottom = i2;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public iILLL1 m1390L11I() {
        int iM1381IiL = m1381IiL();
        ArrayList arrayList = new ArrayList(iM1381IiL);
        for (int i = 0; i < iM1381IiL; i++) {
            arrayList.add(m1394iILLL1(i));
        }
        return iILLL1.m1371IL(arrayList);
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m1391LlLLL() {
        return iIilII1(1048576);
    }

    /* JADX INFO: renamed from: i1 */
    public boolean m41i1(int i, Bundle bundle) {
        try {
            return this.f3549IL1Iii.performAction(i, bundle);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: iI */
    public int m42iI() {
        try {
            if (this.f3549IL1Iii.getCollectionItemInfo() == null) {
                return -1;
            }
            return this.f3549IL1Iii.getCollectionItemInfo().getRowIndex();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public String m1392iI1iI() {
        CharSequence packageName;
        try {
            packageName = this.f3549IL1Iii.getPackageName();
        } catch (Exception unused) {
            packageName = null;
        }
        if (packageName == null) {
            return null;
        }
        return packageName.toString();
    }

    public boolean iIi1() {
        return iIilII1(I1I.IL1Iii.iIi1.ILil());
    }

    public boolean iIilII1(int i) {
        try {
            return this.f3549IL1Iii.performAction(i);
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{44, 108}, IL1Iii.IL1Iii(new byte[]{3, 13, 85, 95, 90, 15}, IL1Iii.IL1Iii(new byte[]{89, 92, 4, 85, 82, 12}, "8e3305"))), IL1Iii.IL1Iii(new byte[]{68, 86, 16, 81, 95, 22, 89, 114, 1, 67, 89, 11, 90, 27}, IL1Iii.IL1Iii(new byte[]{81, 7, 90, 15, 5, 81}, IL1Iii.IL1Iii(new byte[]{80, 80, 91, 91, 80, 81}, "5dcced"))) + i + IL1Iii.IL1Iii(new byte[]{77, 24, 92, 65, 71, 92, 89, 6}, IL1Iii.IL1Iii(new byte[]{6, 15, 93, 82, 7, 82}, IL1Iii.IL1Iii(new byte[]{80, 6, 81, 5, 6, 7}, "215d44"))) + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public boolean m1393iIl1il(int i, int i2) {
        return m1397ili11(131072, new ILil.IL(IL1Iii.IL1Iii(new byte[]{114, 113, 98, 44, 118, 122, 108, 115, 100, 34, 108, 121, 118, 124, 98, 58, 106, 113, 127, 119, 117, 49, 112, 123, 125, 109, 101, 49, 120, 102, 103, 109, 127, 43, 109}, IL1Iii.IL1Iii(new byte[]{81, 87, 87, 82, 10, 87}, IL1Iii.IL1Iii(new byte[]{90, 82, 88, 0, 1, 82}, "879721"))), i), new ILil.IL(IL1Iii.IL1Iii(new byte[]{34, 115, 98, 126, 42, 126, 60, 113, 100, 112, 48, 125, 38, 126, 98, 104, 54, 117, 47, 117, 117, 99, 44, 127, 45, 111, 115, 121, 33, 111, 42, 126, 98}, IL1Iii.IL1Iii(new byte[]{83, 4, 15, 81, 84, 5}, IL1Iii.IL1Iii(new byte[]{84, 13, 92, 95, 9, 4}, "d9e981"))), i2));
    }

    public boolean iIlLiL() {
        return iIilII1(16384);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public lLi1LL m1394iILLL1(int i) {
        try {
            List<AccessibilityNodeInfo> list = this.f3550ILil;
            AccessibilityNodeInfo child = list != null ? list.get(i) : this.f3549IL1Iii.getChild(i);
            if (child == null) {
                return null;
            }
            return new lLi1LL(child, this.f1154IL + 1, i);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public boolean m1395iILilI() {
        return iIilII1(I1I.IL1Iii.f1621llL1ii.ILil());
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public boolean m1396iiIIi11() {
        return iIilII1(8192);
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public boolean m1397ili11(int i, ILil... iLilArr) {
        try {
            return this.f3549IL1Iii.performAction(i, ILil(iLilArr));
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean ill1LI1l() {
        return iIilII1(4);
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public int m1398ill() {
        return this.f3551Ilil;
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m1399l1IIi1(Rect rect) {
        try {
            this.f3549IL1Iii.getBoundsInParent(rect);
        } catch (Exception unused) {
        }
    }

    public boolean l1Lll() {
        return iIilII1(I1I.IL1Iii.Lil.ILil());
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public boolean m1400lIIiIlL() {
        try {
            return this.f3549IL1Iii.isSelected();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m1401lIiI() {
        return iIilII1(16);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public int m1402lIII() {
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        try {
            return this.f3549IL1Iii.getDrawingOrder();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int m1403lIlii() {
        try {
            if (this.f3549IL1Iii.getCollectionItemInfo() == null) {
                return -1;
            }
            return this.f3549IL1Iii.getCollectionItemInfo().getColumnSpan();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: lL */
    public boolean m43lL(int i, int i2) {
        return m1397ili11(I1I.IL1Iii.f1614ILl.ILil(), new ILil.IL(IL1Iii.IL1Iii(new byte[]{86, 13, 85, 64, 11, 88, 83, 77, 71, 91, 1, 70, 25, 2, 82, 81, 1, 66, 68, 10, 83, 91, 8, 88, 67, 26, 31, 83, 7, 69, 94, 12, 95, 28, 37, 99, 112, 54, 124, 119, 42, 101, 104, 49, 126, 101, 59, 120, 121, 55}, IL1Iii.IL1Iii(new byte[]{0, 83, 83, 10, 86, 4}, IL1Iii.IL1Iii(new byte[]{7, 84, 81, 91, 81, 6}, "0d3cc3"))), i), new ILil.IL(IL1Iii.IL1Iii(new byte[]{4, 88, 81, 71, 14, 11, 1, 24, 67, 92, 4, 21, 75, 87, 86, 86, 4, 17, 22, 95, 87, 92, 13, 11, 17, 79, 27, 84, 2, 22, 12, 89, 91, 27, 32, 48, 34, 99, 120, 112, 47, 54, 58, 117, 122, 121, 52, 47, 43, 105, 124, 123, 53}, IL1Iii.IL1Iii(new byte[]{7, 83, 80, 4, 5, 90}, IL1Iii.IL1Iii(new byte[]{91, 87, 82, 8, 81, 12}, "927954"))), i2));
    }

    public boolean llI() {
        try {
            return this.f3549IL1Iii.isFocused();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean llliI() {
        return iIilII1(65536);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int m1404llL1ii() {
        try {
            if (this.f3549IL1Iii.getCollectionInfo() == null) {
                return 0;
            }
            return this.f3549IL1Iii.getCollectionInfo().getColumnCount();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m1405lLi1LL() {
        try {
            return this.f3549IL1Iii.isChecked();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public boolean m1406lliiI1() {
        return iIilII1(32);
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public boolean m1407li11() {
        return iIilII1(32768);
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public boolean m1408i11i() {
        return iIilII1(I1I.IL1Iii.LlLI1.ILil());
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public boolean m1409i11LL(float f) {
        return m1397ili11(I1I.IL1Iii.iIlLiL.ILil(), new ILil.I1I(IL1Iii.IL1Iii(new byte[]{82, 89, 80, 20, 13, 94, 87, 25, 66, 15, 7, 64, 29, 86, 87, 5, 7, 68, 64, 94, 86, 15, 14, 94, 71, 78, 26, 7, 1, 67, 90, 88, 90, 72, 35, 101, 116, 98, 121, 35, 44, 99, 108, 103, 102, 41, 37, 101, 118, 100, 103, 57, 52, 118, 127, 98, 113}, IL1Iii.IL1Iii(new byte[]{7, 82, 2, 95, 84, 86}, IL1Iii.IL1Iii(new byte[]{4, 93, 15, 10, 14, 87}, "089386"))), f));
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public AccessibilityNodeInfo m1410iILLl() {
        return this.f3549IL1Iii;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public String m1411il() {
        CharSequence className;
        try {
            className = this.f3549IL1Iii.getClassName();
        } catch (Exception unused) {
            className = null;
        }
        if (className == null) {
            return null;
        }
        return className.toString();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int m1412l() {
        return this.f1154IL;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public boolean m44() {
        try {
            return this.f3549IL1Iii.isFocusable();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public boolean m1413LLlI1() {
        return iIilII1(1);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public String m14141() {
        CharSequence contentDescription;
        try {
            contentDescription = this.f3549IL1Iii.getContentDescription();
        } catch (Exception unused) {
            contentDescription = null;
        }
        if (contentDescription == null) {
            return null;
        }
        return contentDescription.toString();
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public boolean m1415() {
        try {
            return this.f3549IL1Iii.isAccessibilityFocused();
        } catch (Exception unused) {
            return false;
        }
    }

    public lLi1LL(AccessibilityNodeInfo accessibilityNodeInfo, IL il, int i, int i2) {
        this.f3549IL1Iii = null;
        this.f3550ILil = null;
        this.f3548I1I = BuildConfig.FLAVOR;
        this.f1154IL = 0;
        this.f3549IL1Iii = accessibilityNodeInfo;
        this.f1154IL = i;
        this.f3551Ilil = i2;
    }

    public lLi1LL(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        this(accessibilityNodeInfo, (IL) null, i, i2);
    }
}
