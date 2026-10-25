package ILil.ILL.IL1Iii;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.llL1ii;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class Ll1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final AbstractC0618ILl f3639I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final int[] f3640IL1Iii = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final AbstractC0618ILl f3641ILil;

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.Ll丨1$I1I */
    /* JADX INFO: compiled from: FragmentTransition.java */
    public static class I1I implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Fragment f3642I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Fragment f3643ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ ILil.p065Ilil.Ll1 f3644Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ boolean f1219IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final /* synthetic */ Rect f1220IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ AbstractC0618ILl f1221iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ View f1222lLi1LL;

        public I1I(Fragment fragment, Fragment fragment2, boolean z, ILil.p065Ilil.Ll1 ll1, View view, AbstractC0618ILl abstractC0618ILl, Rect rect) {
            this.f3643ILil = fragment;
            this.f3642I1I = fragment2;
            this.f1219IL = z;
            this.f3644Ilil = ll1;
            this.f1222lLi1LL = view;
            this.f1221iILLL1 = abstractC0618ILl;
            this.f1220IiL = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ll1.m1517lLi1LL(this.f3643ILil, this.f3642I1I, this.f1219IL, this.f3644Ilil, false);
            View view = this.f1222lLi1LL;
            if (view != null) {
                this.f1221iILLL1.ILL(view, this.f1220IiL);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.Ll丨1$IL1Iii */
    /* JADX INFO: compiled from: FragmentTransition.java */
    public static class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3645ILil;

        public IL1Iii(ArrayList arrayList) {
            this.f3645ILil = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ll1.m1514lIII(this.f3645ILil, 4);
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.Ll丨1$ILil */
    /* JADX INFO: compiled from: FragmentTransition.java */
    public static class ILil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ AbstractC0618ILl f3646I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Object f3647ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ Fragment f3648Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ View f1223IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1224IiL;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final /* synthetic */ Object f1225L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1226iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1227lLi1LL;

        public ILil(Object obj, AbstractC0618ILl abstractC0618ILl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f3647ILil = obj;
            this.f3646I1I = abstractC0618ILl;
            this.f1223IL = view;
            this.f3648Ilil = fragment;
            this.f1227lLi1LL = arrayList;
            this.f1226iILLL1 = arrayList2;
            this.f1224IiL = arrayList3;
            this.f1225L11I = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f3647ILil;
            if (obj != null) {
                this.f3646I1I.LlLI1(obj, this.f1223IL);
                this.f1226iILLL1.addAll(Ll1.ILL(this.f3646I1I, this.f3647ILil, this.f3648Ilil, this.f1227lLi1LL, this.f1223IL));
            }
            if (this.f1224IiL != null) {
                if (this.f1225L11I != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1223IL);
                    this.f3646I1I.mo1472llL1ii(this.f1225L11I, this.f1224IiL, arrayList);
                }
                this.f1224IiL.clear();
                this.f1224IiL.add(this.f1223IL);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.Ll丨1$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentTransition.java */
    public static class IL implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ ILil.p065Ilil.Ll1 f3649I1I;
        public final /* synthetic */ ArrayList ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ AbstractC0618ILl f3650ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ lLi1LL f3651Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ Object f1228IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final /* synthetic */ Fragment f1229IiL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public final /* synthetic */ Object f1230Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final /* synthetic */ Fragment f1231L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ View f1232iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public final /* synthetic */ Rect f1233lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1234lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public final /* synthetic */ boolean f1235il;

        public IL(AbstractC0618ILl abstractC0618ILl, ILil.p065Ilil.Ll1 ll1, Object obj, lLi1LL lli1ll, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f3650ILil = abstractC0618ILl;
            this.f3649I1I = ll1;
            this.f1228IL = obj;
            this.f3651Ilil = lli1ll;
            this.f1234lLi1LL = arrayList;
            this.f1232iILLL1 = view;
            this.f1229IiL = fragment;
            this.f1231L11I = fragment2;
            this.f1235il = z;
            this.ILL = arrayList2;
            this.f1230Ll1 = obj2;
            this.f1233lIiI = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ILil.p065Ilil.Ll1<String, View> ll1M1508IiL = Ll1.m1508IiL(this.f3650ILil, this.f3649I1I, this.f1228IL, this.f3651Ilil);
            if (ll1M1508IiL != null) {
                this.f1234lLi1LL.addAll(ll1M1508IiL.values());
                this.f1234lLi1LL.add(this.f1232iILLL1);
            }
            Ll1.m1517lLi1LL(this.f1229IiL, this.f1231L11I, this.f1235il, ll1M1508IiL, false);
            Object obj = this.f1228IL;
            if (obj != null) {
                this.f3650ILil.mo14771(obj, this.ILL, this.f1234lLi1LL);
                View viewIIlLiL = Ll1.iIlLiL(ll1M1508IiL, this.f3651Ilil, this.f1230Ll1, this.f1235il);
                if (viewIIlLiL != null) {
                    this.f3650ILil.ILL(viewIIlLiL, this.f1233lIiI);
                }
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.Ll丨1$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentTransition.java */
    public static class lLi1LL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ILil.ILL.IL1Iii.IL1Iii f3652I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Fragment f3653IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f3654ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f3655Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public Fragment f1236IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public ILil.ILL.IL1Iii.IL1Iii f1237lLi1LL;
    }

    static {
        f3641ILil = Build.VERSION.SDK_INT >= 21 ? new lIiI() : null;
        f3639I1I = llliI();
    }

    public static void I11L(AbstractC0618ILl abstractC0618ILl, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            abstractC0618ILl.mo1471lIlii(obj, fragment.getView(), arrayList);
            llL1ii.IL1Iii(fragment.mContainer, new IL1Iii(arrayList));
        }
    }

    public static Object I11li1(AbstractC0618ILl abstractC0618ILl, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return abstractC0618ILl.mo1468LlLLL(abstractC0618ILl.mo1469iILLL1(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    public static void I1I(ILil.ILL.IL1Iii.IL1Iii iL1Iii, SparseArray<lLi1LL> sparseArray, boolean z) {
        int size = iL1Iii.f3620IL1Iii.size();
        for (int i = 0; i < size; i++) {
            ILil(iL1Iii, iL1Iii.f3620IL1Iii.get(i), sparseArray, false, z);
        }
    }

    public static void IL1Iii(ArrayList<View> arrayList, ILil.p065Ilil.Ll1<String, View> ll1, Collection<String> collection) {
        for (int size = ll1.size() - 1; size >= 0; size--) {
            View viewM1975lIiI = ll1.m1975lIiI(size);
            if (collection.contains(iIlLiL.llI(viewM1975lIiI))) {
                arrayList.add(viewM1975lIiI);
            }
        }
    }

    public static ArrayList<View> ILL(AbstractC0618ILl abstractC0618ILl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            abstractC0618ILl.m1473lLi1LL(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        abstractC0618ILl.ILil(obj, arrayList2);
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0076  */
    /* JADX WARN: Code duplicated, block: B:57:0x0078  */
    /* JADX WARN: Code duplicated, block: B:64:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0089  */
    /* JADX WARN: Code duplicated, block: B:66:0x008c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0094  */
    /* JADX WARN: Code duplicated, block: B:71:0x0096  */
    public static void ILil(ILil.ILL.IL1Iii.IL1Iii iL1Iii, ILL.IL1Iii iL1Iii2, SparseArray<lLi1LL> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        View view;
        boolean z7;
        Fragment fragment = iL1Iii2.f3625ILil;
        if (fragment == null || (i = fragment.mContainerId) == 0) {
            return;
        }
        int i2 = z ? f3640IL1Iii[iL1Iii2.f3624IL1Iii] : iL1Iii2.f3624IL1Iii;
        boolean z8 = false;
        if (i2 == 1) {
            if (z2) {
                z3 = fragment.mIsNewlyAdded;
            } else if (!fragment.mAdded || fragment.mHidden) {
                z3 = false;
            } else {
                z3 = true;
            }
            z8 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
        } else if (i2 == 3) {
            if (z2 ? !fragment.mAdded || fragment.mHidden : fragment.mAdded || (view = fragment.mView) == null || view.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) {
                z7 = false;
            } else {
                z7 = true;
            }
            z5 = z7;
            z4 = false;
            z6 = true;
        } else if (i2 != 4) {
            if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 != 7) {
                        z4 = false;
                    } else {
                        if (z2) {
                            z3 = fragment.mIsNewlyAdded;
                        } else {
                            if (fragment.mAdded) {
                            }
                            z3 = false;
                        }
                        z8 = z3;
                        z4 = true;
                    }
                }
                if (z2) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                z5 = z7;
                z4 = false;
                z6 = true;
            } else {
                if (!z2) {
                    z3 = fragment.mHidden;
                } else if (fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z8 = z3;
                z4 = true;
            }
            z6 = false;
            z5 = false;
        } else {
            if (!z2 ? !(!fragment.mAdded || fragment.mHidden) : fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) {
                z7 = false;
            } else {
                z7 = true;
            }
            z5 = z7;
            z4 = false;
            z6 = true;
        }
        lLi1LL lli1llLlLI1 = sparseArray.get(i);
        if (z8) {
            lli1llLlLI1 = LlLI1(lli1llLlLI1, sparseArray, i);
            lli1llLlLI1.f3653IL1Iii = fragment;
            lli1llLlLI1.f3654ILil = z;
            lli1llLlLI1.f3652I1I = iL1Iii;
        }
        lLi1LL lli1llLlLI2 = lli1llLlLI1;
        if (!z2 && z4) {
            if (lli1llLlLI2 != null && lli1llLlLI2.f1236IL == fragment) {
                lli1llLlLI2.f1236IL = null;
            }
            L11I l11i = iL1Iii.f1202lIlii;
            if (fragment.mState < 1 && l11i.f1253llL1ii >= 1 && !iL1Iii.LlLI1) {
                l11i.m1546iI1L1Ll(fragment);
                l11i.m1529IL11L(fragment, 1, 0, 0, false);
            }
        }
        if (z5 && (lli1llLlLI2 == null || lli1llLlLI2.f1236IL == null)) {
            lli1llLlLI2 = LlLI1(lli1llLlLI2, sparseArray, i);
            lli1llLlLI2.f1236IL = fragment;
            lli1llLlLI2.f3655Ilil = z;
            lli1llLlLI2.f1237lLi1LL = iL1Iii;
        }
        if (z2 || !z6 || lli1llLlLI2 == null || lli1llLlLI2.f3653IL1Iii != fragment) {
            return;
        }
        lli1llLlLI2.f3653IL1Iii = null;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static void m1506ILl(L11I l11i, int i, lLi1LL lli1ll, View view, ILil.p065Ilil.Ll1<String, String> ll1) {
        Fragment fragment;
        Fragment fragment2;
        AbstractC0618ILl abstractC0618ILlM1518il;
        Object obj;
        ViewGroup viewGroup = l11i.iIi1.mo1446IL() ? (ViewGroup) l11i.iIi1.I1I(i) : null;
        if (viewGroup == null || (abstractC0618ILlM1518il = m1518il((fragment2 = lli1ll.f1236IL), (fragment = lli1ll.f3653IL1Iii))) == null) {
            return;
        }
        boolean z = lli1ll.f3654ILil;
        boolean z2 = lli1ll.f3655Ilil;
        Object objM1515lIlii = m1515lIlii(abstractC0618ILlM1518il, fragment, z);
        Object objIIi1 = iIi1(abstractC0618ILlM1518il, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objM1509Ll1 = m1509Ll1(abstractC0618ILlM1518il, viewGroup, view, ll1, lli1ll, arrayList, arrayList2, objM1515lIlii, objIIi1);
        if (objM1515lIlii == null && objM1509Ll1 == null) {
            obj = objIIi1;
            if (obj == null) {
                return;
            }
        } else {
            obj = objIIi1;
        }
        ArrayList<View> arrayListILL = ILL(abstractC0618ILlM1518il, obj, fragment2, arrayList, view);
        Object obj2 = (arrayListILL == null || arrayListILL.isEmpty()) ? null : obj;
        abstractC0618ILlM1518il.IL1Iii(objM1515lIlii, view);
        Object objM1519lL = m1519lL(abstractC0618ILlM1518il, objM1515lIlii, obj2, objM1509Ll1, fragment, lli1ll.f3654ILil);
        if (objM1519lL != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            abstractC0618ILlM1518il.iIlLiL(objM1519lL, objM1515lIlii, arrayList3, obj2, arrayListILL, objM1509Ll1, arrayList2);
            m15211(abstractC0618ILlM1518il, viewGroup, fragment, view, arrayList2, objM1515lIlii, arrayList3, obj2, arrayListILL);
            abstractC0618ILlM1518il.I11L(viewGroup, arrayList2, ll1);
            abstractC0618ILlM1518il.I1I(viewGroup, objM1519lL);
            abstractC0618ILlM1518il.iIi1(viewGroup, arrayList2, ll1);
        }
    }

    public static void Ilil(ILil.ILL.IL1Iii.IL1Iii iL1Iii, SparseArray<lLi1LL> sparseArray, boolean z) {
        if (iL1Iii.f1202lIlii.iIi1.mo1446IL()) {
            for (int size = iL1Iii.f3620IL1Iii.size() - 1; size >= 0; size--) {
                ILil(iL1Iii, iL1Iii.f3620IL1Iii.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static ILil.p065Ilil.Ll1<String, String> m1507IL(int i, ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ILil.p065Ilil.Ll1<String, String> ll1 = new ILil.p065Ilil.Ll1<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = arrayList.get(i4);
            if (iL1Iii.I11L(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = iL1Iii.f1203ILl;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = iL1Iii.f1203ILl;
                        arrayList4 = iL1Iii.Lil;
                    } else {
                        ArrayList<String> arrayList6 = iL1Iii.f1203ILl;
                        arrayList3 = iL1Iii.Lil;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = ll1.remove(str2);
                        if (strRemove != null) {
                            ll1.put(str, strRemove);
                        } else {
                            ll1.put(str, str2);
                        }
                    }
                }
            }
        }
        return ll1;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static ILil.p065Ilil.Ll1<String, View> m1508IiL(AbstractC0618ILl abstractC0618ILl, ILil.p065Ilil.Ll1<String, String> ll1, Object obj, lLi1LL lli1ll) {
        ILil.p028IiL.Ilil.ILL enterTransitionCallback;
        ArrayList<String> arrayList;
        String strM1516llL1ii;
        Fragment fragment = lli1ll.f3653IL1Iii;
        View view = fragment.getView();
        if (ll1.isEmpty() || obj == null || view == null) {
            ll1.clear();
            return null;
        }
        ILil.p065Ilil.Ll1<String, View> ll2 = new ILil.p065Ilil.Ll1<>();
        abstractC0618ILl.m1474il(ll2, view);
        ILil.ILL.IL1Iii.IL1Iii iL1Iii = lli1ll.f3652I1I;
        if (lli1ll.f3654ILil) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = iL1Iii.f1203ILl;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = iL1Iii.Lil;
        }
        if (arrayList != null) {
            ll2.Lil(arrayList);
            ll2.Lil(ll1.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.IL1Iii(arrayList, ll2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = ll2.get(str);
                if (view2 == null) {
                    String strM1516llL1ii2 = m1516llL1ii(ll1, str);
                    if (strM1516llL1ii2 != null) {
                        ll1.remove(strM1516llL1ii2);
                    }
                } else if (!str.equals(iIlLiL.llI(view2)) && (strM1516llL1ii = m1516llL1ii(ll1, str)) != null) {
                    ll1.put(strM1516llL1ii, iIlLiL.llI(view2));
                }
            }
        } else {
            m1520l(ll1, ll2);
        }
        return ll2;
    }

    public static void LL1IL(L11I l11i, ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (l11i.f1253llL1ii < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                Ilil(iL1Iii, sparseArray, z);
            } else {
                I1I(iL1Iii, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(l11i.f1252lIlii.m1595lLi1LL());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                ILil.p065Ilil.Ll1<String, String> ll1M1507IL = m1507IL(iKeyAt, arrayList, arrayList2, i, i2);
                lLi1LL lli1ll = (lLi1LL) sparseArray.valueAt(i4);
                if (z) {
                    Lil(l11i, iKeyAt, lli1ll, view, ll1M1507IL);
                } else {
                    m1506ILl(l11i, iKeyAt, lli1ll, view, ll1M1507IL);
                }
            }
        }
    }

    public static void Lil(L11I l11i, int i, lLi1LL lli1ll, View view, ILil.p065Ilil.Ll1<String, String> ll1) {
        Fragment fragment;
        Fragment fragment2;
        AbstractC0618ILl abstractC0618ILlM1518il;
        Object obj;
        ViewGroup viewGroup = l11i.iIi1.mo1446IL() ? (ViewGroup) l11i.iIi1.I1I(i) : null;
        if (viewGroup == null || (abstractC0618ILlM1518il = m1518il((fragment2 = lli1ll.f1236IL), (fragment = lli1ll.f3653IL1Iii))) == null) {
            return;
        }
        boolean z = lli1ll.f3654ILil;
        boolean z2 = lli1ll.f3655Ilil;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objM1515lIlii = m1515lIlii(abstractC0618ILlM1518il, fragment, z);
        Object objIIi1 = iIi1(abstractC0618ILlM1518il, fragment2, z2);
        Object objM1513lIiI = m1513lIiI(abstractC0618ILlM1518il, viewGroup, view, ll1, lli1ll, arrayList2, arrayList, objM1515lIlii, objIIi1);
        if (objM1515lIlii == null && objM1513lIiI == null) {
            obj = objIIi1;
            if (obj == null) {
                return;
            }
        } else {
            obj = objIIi1;
        }
        ArrayList<View> arrayListILL = ILL(abstractC0618ILlM1518il, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListILL2 = ILL(abstractC0618ILlM1518il, objM1515lIlii, fragment, arrayList, view);
        m1514lIII(arrayListILL2, 4);
        Object objM1519lL = m1519lL(abstractC0618ILlM1518il, objM1515lIlii, obj, objM1513lIiI, fragment, z);
        if (objM1519lL != null) {
            I11L(abstractC0618ILlM1518il, obj, fragment2, arrayListILL);
            ArrayList<String> arrayListLil = abstractC0618ILlM1518il.Lil(arrayList);
            abstractC0618ILlM1518il.iIlLiL(objM1519lL, objM1515lIlii, arrayListILL2, obj, arrayListILL, objM1513lIiI, arrayList);
            abstractC0618ILlM1518il.I1I(viewGroup, objM1519lL);
            abstractC0618ILlM1518il.llliI(viewGroup, arrayList2, arrayList, arrayListLil, ll1);
            m1514lIII(arrayListILL2, 0);
            abstractC0618ILlM1518il.mo14771(objM1513lIiI, arrayList2, arrayList);
        }
    }

    public static lLi1LL LlLI1(lLi1LL lli1ll, SparseArray<lLi1LL> sparseArray, int i) {
        if (lli1ll != null) {
            return lli1ll;
        }
        lLi1LL lli1ll2 = new lLi1LL();
        sparseArray.put(i, lli1ll2);
        return lli1ll2;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static Object m1509Ll1(AbstractC0618ILl abstractC0618ILl, ViewGroup viewGroup, View view, ILil.p065Ilil.Ll1<String, String> ll1, lLi1LL lli1ll, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        Fragment fragment = lli1ll.f3653IL1Iii;
        Fragment fragment2 = lli1ll.f1236IL;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = lli1ll.f3654ILil;
        Object objI11li1 = ll1.isEmpty() ? null : I11li1(abstractC0618ILl, fragment, fragment2, z);
        ILil.p065Ilil.Ll1<String, View> ll1M1510L11I = m1510L11I(abstractC0618ILl, ll1, objI11li1, lli1ll);
        if (ll1.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(ll1M1510L11I.values());
            obj3 = objI11li1;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m1517lLi1LL(fragment, fragment2, z, ll1M1510L11I, true);
        if (obj3 != null) {
            rect = new Rect();
            abstractC0618ILl.mo1476l(obj3, view, arrayList);
            m1511LlLLL(abstractC0618ILl, obj3, obj2, ll1M1510L11I, lli1ll.f3655Ilil, lli1ll.f1237lLi1LL);
            if (obj != null) {
                abstractC0618ILl.I11li1(obj, rect);
            }
        } else {
            rect = null;
        }
        llL1ii.IL1Iii(viewGroup, new IL(abstractC0618ILl, ll1, obj3, lli1ll, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static ILil.p065Ilil.Ll1<String, View> m1510L11I(AbstractC0618ILl abstractC0618ILl, ILil.p065Ilil.Ll1<String, String> ll1, Object obj, lLi1LL lli1ll) {
        ILil.p028IiL.Ilil.ILL exitTransitionCallback;
        ArrayList<String> arrayList;
        if (ll1.isEmpty() || obj == null) {
            ll1.clear();
            return null;
        }
        Fragment fragment = lli1ll.f1236IL;
        ILil.p065Ilil.Ll1<String, View> ll2 = new ILil.p065Ilil.Ll1<>();
        abstractC0618ILl.m1474il(ll2, fragment.requireView());
        ILil.ILL.IL1Iii.IL1Iii iL1Iii = lli1ll.f1237lLi1LL;
        if (lli1ll.f3655Ilil) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = iL1Iii.Lil;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = iL1Iii.f1203ILl;
        }
        ll2.Lil(arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.IL1Iii(arrayList, ll2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = ll2.get(str);
                if (view == null) {
                    ll1.remove(str);
                } else if (!str.equals(iIlLiL.llI(view))) {
                    ll1.put(iIlLiL.llI(view), ll1.remove(str));
                }
            }
        } else {
            ll1.Lil(ll2.keySet());
        }
        return ll2;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public static void m1511LlLLL(AbstractC0618ILl abstractC0618ILl, Object obj, Object obj2, ILil.p065Ilil.Ll1<String, View> ll1, boolean z, ILil.ILL.IL1Iii.IL1Iii iL1Iii) {
        ArrayList<String> arrayList = iL1Iii.f1203ILl;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = ll1.get(z ? iL1Iii.Lil.get(0) : iL1Iii.f1203ILl.get(0));
        abstractC0618ILl.mo1475lL(obj, view);
        if (obj2 != null) {
            abstractC0618ILl.mo1475lL(obj2, view);
        }
    }

    public static Object iIi1(AbstractC0618ILl abstractC0618ILl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return abstractC0618ILl.mo1469iILLL1(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    public static View iIlLiL(ILil.p065Ilil.Ll1<String, View> ll1, lLi1LL lli1ll, Object obj, boolean z) {
        ArrayList<String> arrayList;
        ILil.ILL.IL1Iii.IL1Iii iL1Iii = lli1ll.f3652I1I;
        if (obj == null || ll1 == null || (arrayList = iL1Iii.f1203ILl) == null || arrayList.isEmpty()) {
            return null;
        }
        return ll1.get(z ? iL1Iii.f1203ILl.get(0) : iL1Iii.Lil.get(0));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m1512iILLL1(AbstractC0618ILl abstractC0618ILl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!abstractC0618ILl.Ilil(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static Object m1513lIiI(AbstractC0618ILl abstractC0618ILl, ViewGroup viewGroup, View view, ILil.p065Ilil.Ll1<String, String> ll1, lLi1LL lli1ll, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = lli1ll.f3653IL1Iii;
        Fragment fragment2 = lli1ll.f1236IL;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = lli1ll.f3654ILil;
        Object objI11li1 = ll1.isEmpty() ? null : I11li1(abstractC0618ILl, fragment, fragment2, z);
        ILil.p065Ilil.Ll1<String, View> ll1M1510L11I = m1510L11I(abstractC0618ILl, ll1, objI11li1, lli1ll);
        ILil.p065Ilil.Ll1<String, View> ll1M1508IiL = m1508IiL(abstractC0618ILl, ll1, objI11li1, lli1ll);
        if (ll1.isEmpty()) {
            if (ll1M1510L11I != null) {
                ll1M1510L11I.clear();
            }
            if (ll1M1508IiL != null) {
                ll1M1508IiL.clear();
            }
            obj3 = null;
        } else {
            IL1Iii(arrayList, ll1M1510L11I, ll1.keySet());
            IL1Iii(arrayList2, ll1M1508IiL, ll1.values());
            obj3 = objI11li1;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m1517lLi1LL(fragment, fragment2, z, ll1M1510L11I, true);
        if (obj3 != null) {
            arrayList2.add(view);
            abstractC0618ILl.mo1476l(obj3, view, arrayList);
            m1511LlLLL(abstractC0618ILl, obj3, obj2, ll1M1510L11I, lli1ll.f3655Ilil, lli1ll.f1237lLi1LL);
            Rect rect2 = new Rect();
            View viewIIlLiL = iIlLiL(ll1M1508IiL, lli1ll, obj, z);
            if (viewIIlLiL != null) {
                abstractC0618ILl.I11li1(obj, rect2);
            }
            rect = rect2;
            view2 = viewIIlLiL;
        } else {
            view2 = null;
            rect = null;
        }
        llL1ii.IL1Iii(viewGroup, new I1I(fragment, fragment2, z, ll1M1508IiL, view2, abstractC0618ILl, rect));
        return obj3;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static void m1514lIII(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static Object m1515lIlii(AbstractC0618ILl abstractC0618ILl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return abstractC0618ILl.mo1469iILLL1(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    public static AbstractC0618ILl llliI() {
        try {
            return (AbstractC0618ILl) Class.forName("ILil.ll丨L1ii.l丨Li1LL").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static String m1516llL1ii(ILil.p065Ilil.Ll1<String, String> ll1, String str) {
        int size = ll1.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(ll1.m1975lIiI(i))) {
                return ll1.m1973L11I(i);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1517lLi1LL(Fragment fragment, Fragment fragment2, boolean z, ILil.p065Ilil.Ll1<String, View> ll1, boolean z2) {
        ILil.p028IiL.Ilil.ILL enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = ll1 == null ? 0 : ll1.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(ll1.m1973L11I(i));
                arrayList.add(ll1.m1975lIiI(i));
            }
            if (z2) {
                enterTransitionCallback.I1I(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.ILil(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static AbstractC0618ILl m1518il(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AbstractC0618ILl abstractC0618ILl = f3641ILil;
        if (abstractC0618ILl != null && m1512iILLL1(abstractC0618ILl, arrayList)) {
            return abstractC0618ILl;
        }
        AbstractC0618ILl abstractC0618ILl2 = f3639I1I;
        if (abstractC0618ILl2 != null && m1512iILLL1(abstractC0618ILl2, arrayList)) {
            return abstractC0618ILl2;
        }
        if (abstractC0618ILl == null && abstractC0618ILl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static Object m1519lL(AbstractC0618ILl abstractC0618ILl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean allowReturnTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowReturnTransitionOverlap = true;
        } else {
            allowReturnTransitionOverlap = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        return allowReturnTransitionOverlap ? abstractC0618ILl.mo1467ILl(obj2, obj, obj3) : abstractC0618ILl.mo1470lIiI(obj2, obj, obj3);
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public static void m1520l(ILil.p065Ilil.Ll1<String, String> ll1, ILil.p065Ilil.Ll1<String, View> ll2) {
        for (int size = ll1.size() - 1; size >= 0; size--) {
            if (!ll2.containsKey(ll1.m1975lIiI(size))) {
                ll1.ILL(size);
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public static void m15211(AbstractC0618ILl abstractC0618ILl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        llL1ii.IL1Iii(viewGroup, new ILil(obj, abstractC0618ILl, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
