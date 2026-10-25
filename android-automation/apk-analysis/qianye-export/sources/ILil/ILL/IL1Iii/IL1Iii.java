package ILil.ILL.IL1Iii;

import android.util.Log;
import androidx.fragment.app.Fragment;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackStackRecord.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii extends ILL implements L11I.Ll1 {
    public boolean iIi1;
    public int iIlLiL = -1;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final L11I f1202lIlii;

    public IL1Iii(L11I l11i) {
        this.f1202lIlii = l11i;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public static boolean m1447l(ILL.IL1Iii iL1Iii) {
        Fragment fragment = iL1Iii.f3625ILil;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    public boolean I11L(int i) {
        int size = this.f3620IL1Iii.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f3620IL1Iii.get(i2).f3625ILil;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    public Fragment I11li1(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f3620IL1Iii.size()) {
            ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(i);
            int i2 = iL1Iii.f3624IL1Iii;
            if (i2 == 1) {
                arrayList.add(iL1Iii.f3625ILil);
            } else if (i2 == 2) {
                Fragment fragment3 = iL1Iii.f3625ILil;
                int i3 = fragment3.mContainerId;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.mContainerId == i3) {
                        if (fragment4 == fragment3) {
                            z = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f3620IL1Iii.add(i, new ILL.IL1Iii(9, fragment4));
                                i++;
                                fragment2 = null;
                            }
                            ILL.IL1Iii iL1Iii2 = new ILL.IL1Iii(3, fragment4);
                            iL1Iii2.f3623I1I = iL1Iii.f3623I1I;
                            iL1Iii2.f3626Ilil = iL1Iii.f3626Ilil;
                            iL1Iii2.f1213IL = iL1Iii.f1213IL;
                            iL1Iii2.f1216lLi1LL = iL1Iii.f1216lLi1LL;
                            this.f3620IL1Iii.add(i, iL1Iii2);
                            arrayList.remove(fragment4);
                            i++;
                        }
                    }
                }
                if (z) {
                    this.f3620IL1Iii.remove(i);
                    i--;
                } else {
                    iL1Iii.f3624IL1Iii = 1;
                    arrayList.add(fragment3);
                }
            } else if (i2 == 3 || i2 == 6) {
                arrayList.remove(iL1Iii.f3625ILil);
                Fragment fragment5 = iL1Iii.f3625ILil;
                if (fragment5 == fragment2) {
                    this.f3620IL1Iii.add(i, new ILL.IL1Iii(9, fragment5));
                    i++;
                    fragment2 = null;
                }
            } else if (i2 == 7) {
                arrayList.add(iL1Iii.f3625ILil);
            } else if (i2 == 8) {
                this.f3620IL1Iii.add(i, new ILL.IL1Iii(9, fragment2));
                i++;
                fragment2 = iL1Iii.f3625ILil;
            }
            i++;
        }
        return fragment2;
    }

    @Override // ILil.ILL.IL1Iii.L11I.Ll1
    public boolean IL1Iii(ArrayList<IL1Iii> arrayList, ArrayList<Boolean> arrayList2) {
        if (L11I.f1239L1l) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1205IiL) {
            return true;
        }
        this.f1202lIlii.ILL(this);
        return true;
    }

    @Override // ILil.ILL.IL1Iii.ILL
    public void ILL(int i, Fragment fragment, String str, int i2) {
        super.ILL(i, fragment, str, i2);
        fragment.mFragmentManager = this.f1202lIlii;
    }

    @Override // ILil.ILL.IL1Iii.ILL
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void mo1448IiL() {
        m1462il();
        this.f1202lIlii.ill1LI1l(this, false);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    public Fragment LL1IL(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f3620IL1Iii.size() - 1; size >= 0; size--) {
            ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(size);
            int i = iL1Iii.f3624IL1Iii;
            if (i == 1) {
                arrayList.remove(iL1Iii.f3625ILil);
            } else if (i != 3) {
                switch (i) {
                    case 6:
                        arrayList.add(iL1Iii.f3625ILil);
                        break;
                    case 7:
                        arrayList.remove(iL1Iii.f3625ILil);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = iL1Iii.f3625ILil;
                        break;
                    case 10:
                        iL1Iii.f1214IiL = iL1Iii.f1215iILLL1;
                        break;
                }
            } else {
                arrayList.add(iL1Iii.f3625ILil);
            }
        }
        return fragment;
    }

    public void Lil(int i) {
        if (this.f1205IiL) {
            if (L11I.f1239L1l) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f3620IL1Iii.size();
            for (int i2 = 0; i2 < size; i2++) {
                ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(i2);
                Fragment fragment = iL1Iii.f3625ILil;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (L11I.f1239L1l) {
                        Log.v("FragmentManager", "Bump nesting of " + iL1Iii.f3625ILil + " to " + iL1Iii.f3625ILil.mBackStackNesting);
                    }
                }
            }
        }
    }

    public int LlLI1(boolean z) {
        if (this.iIi1) {
            throw new IllegalStateException("commit already called");
        }
        if (L11I.f1239L1l) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new ILil.p028IiL.p034lIiI.ILil("FragmentManager"));
            m1455llL1ii("  ", printWriter);
            printWriter.close();
        }
        this.iIi1 = true;
        if (this.f1205IiL) {
            this.iIlLiL = this.f1202lIlii.m1531ILl(this);
        } else {
            this.iIlLiL = -1;
        }
        this.f1202lIlii.L1iI1(this, z);
        return this.iIlLiL;
    }

    @Override // ILil.ILL.IL1Iii.ILL
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ILL mo1449Ll1(Fragment fragment) {
        L11I l11i = fragment.mFragmentManager;
        if (l11i == null || l11i == this.f1202lIlii) {
            super.mo1449Ll1(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // ILil.ILL.IL1Iii.ILL
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ILL mo1450L11I(Fragment fragment) {
        L11I l11i = fragment.mFragmentManager;
        if (l11i == null || l11i == this.f1202lIlii) {
            super.mo1450L11I(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m1451LlLLL() {
        if (this.f1210llL1ii != null) {
            for (int i = 0; i < this.f1210llL1ii.size(); i++) {
                this.f1210llL1ii.get(i).run();
            }
            this.f1210llL1ii = null;
        }
    }

    public void iIi1() {
        int size = this.f3620IL1Iii.size();
        for (int i = 0; i < size; i++) {
            ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(i);
            Fragment fragment = iL1Iii.f3625ILil;
            if (fragment != null) {
                fragment.setNextTransition(this.f1211lLi1LL, this.f1208iILLL1);
            }
            switch (iL1Iii.f3624IL1Iii) {
                case 1:
                    fragment.setNextAnim(iL1Iii.f3623I1I);
                    this.f1202lIlii.m1543Ll1(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + iL1Iii.f3624IL1Iii);
                case 3:
                    fragment.setNextAnim(iL1Iii.f1213IL);
                    this.f1202lIlii.m1579li1Ii1i(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(iL1Iii.f1213IL);
                    this.f1202lIlii.lI1I1(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(iL1Iii.f3623I1I);
                    this.f1202lIlii.m1569IiIi(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(iL1Iii.f1213IL);
                    this.f1202lIlii.llliI(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(iL1Iii.f3623I1I);
                    this.f1202lIlii.m1563llL1ii(fragment);
                    break;
                case 8:
                    this.f1202lIlii.Lli(fragment);
                    break;
                case 9:
                    this.f1202lIlii.Lli(null);
                    break;
                case 10:
                    this.f1202lIlii.m1571IlL1ll1(fragment, iL1Iii.f1214IiL);
                    break;
            }
            if (!this.LlLI1 && iL1Iii.f3624IL1Iii != 1 && fragment != null) {
                this.f1202lIlii.IIi1II(fragment);
            }
        }
        if (this.LlLI1) {
            return;
        }
        L11I l11i = this.f1202lIlii;
        l11i.m56i(l11i.f1253llL1ii, true);
    }

    public void iIlLiL(boolean z) {
        for (int size = this.f3620IL1Iii.size() - 1; size >= 0; size--) {
            ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(size);
            Fragment fragment = iL1Iii.f3625ILil;
            if (fragment != null) {
                fragment.setNextTransition(L11I.Ll1(this.f1211lLi1LL), this.f1208iILLL1);
            }
            switch (iL1Iii.f3624IL1Iii) {
                case 1:
                    fragment.setNextAnim(iL1Iii.f1216lLi1LL);
                    this.f1202lIlii.m1579li1Ii1i(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + iL1Iii.f3624IL1Iii);
                case 3:
                    fragment.setNextAnim(iL1Iii.f3626Ilil);
                    this.f1202lIlii.m1543Ll1(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(iL1Iii.f3626Ilil);
                    this.f1202lIlii.m1569IiIi(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(iL1Iii.f1216lLi1LL);
                    this.f1202lIlii.lI1I1(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(iL1Iii.f3626Ilil);
                    this.f1202lIlii.m1563llL1ii(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(iL1Iii.f1216lLi1LL);
                    this.f1202lIlii.llliI(fragment);
                    break;
                case 8:
                    this.f1202lIlii.Lli(null);
                    break;
                case 9:
                    this.f1202lIlii.Lli(fragment);
                    break;
                case 10:
                    this.f1202lIlii.m1571IlL1ll1(fragment, iL1Iii.f1215iILLL1);
                    break;
            }
            if (!this.LlLI1 && iL1Iii.f3624IL1Iii != 3 && fragment != null) {
                this.f1202lIlii.IIi1II(fragment);
            }
        }
        if (this.LlLI1 || !z) {
            return;
        }
        L11I l11i = this.f1202lIlii;
        l11i.m56i(l11i.f1253llL1ii, true);
    }

    @Override // ILil.ILL.IL1Iii.ILL
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int mo1452iILLL1() {
        return LlLI1(true);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m1453lIII(Fragment.iILLL1 iilll1) {
        for (int i = 0; i < this.f3620IL1Iii.size(); i++) {
            ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(i);
            if (m1447l(iL1Iii)) {
                iL1Iii.f3625ILil.setOnStartEnterTransitionListener(iilll1);
            }
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m1454lIlii(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1207L11I);
            printWriter.print(" mIndex=");
            printWriter.print(this.iIlLiL);
            printWriter.print(" mCommitted=");
            printWriter.println(this.iIi1);
            if (this.f1211lLi1LL != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1211lLi1LL));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1208iILLL1));
            }
            if (this.f3621ILil != 0 || this.f3619I1I != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3621ILil));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3619I1I));
            }
            if (this.f1204IL != 0 || this.f3622Ilil != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1204IL));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3622Ilil));
            }
            if (this.f1212il != 0 || this.ILL != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1212il));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.ILL);
            }
            if (this.f1206Ll1 != 0 || this.f1209lIiI != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1206Ll1));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1209lIiI);
            }
        }
        if (this.f3620IL1Iii.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f3620IL1Iii.size();
        for (int i = 0; i < size; i++) {
            ILL.IL1Iii iL1Iii = this.f3620IL1Iii.get(i);
            switch (iL1Iii.f3624IL1Iii) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + iL1Iii.f3624IL1Iii;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(iL1Iii.f3625ILil);
            if (z) {
                if (iL1Iii.f3623I1I != 0 || iL1Iii.f1213IL != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(iL1Iii.f3623I1I));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(iL1Iii.f1213IL));
                }
                if (iL1Iii.f3626Ilil != 0 || iL1Iii.f1216lLi1LL != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(iL1Iii.f3626Ilil));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(iL1Iii.f1216lLi1LL));
                }
            }
        }
    }

    public boolean llliI(ArrayList<IL1Iii> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f3620IL1Iii.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f3620IL1Iii.get(i4).f3625ILil;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    IL1Iii iL1Iii = arrayList.get(i6);
                    int size2 = iL1Iii.f3620IL1Iii.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = iL1Iii.f3620IL1Iii.get(i7).f3625ILil;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m1455llL1ii(String str, PrintWriter printWriter) {
        m1454lIlii(str, printWriter, true);
    }

    @Override // ILil.ILL.IL1Iii.ILL
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int mo1456lLi1LL() {
        return LlLI1(false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.iIlLiL >= 0) {
            sb.append(" #");
            sb.append(this.iIlLiL);
        }
        if (this.f1207L11I != null) {
            sb.append(" ");
            sb.append(this.f1207L11I);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public String m1457lL() {
        return this.f1207L11I;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m14581() {
        for (int i = 0; i < this.f3620IL1Iii.size(); i++) {
            if (m1447l(this.f3620IL1Iii.get(i))) {
                return true;
            }
        }
        return false;
    }
}
