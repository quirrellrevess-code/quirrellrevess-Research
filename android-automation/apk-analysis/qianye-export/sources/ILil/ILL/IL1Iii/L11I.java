package ILil.ILL.IL1Iii;

import ILil.p028IiL.p029ILl.llL1ii;
import ILil.p042lIiI.iIi1;
import ILil.p042lIiI.lIlii;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class L11I extends ILil.ILL.IL1Iii.IiL implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public static boolean f1239L1l = false;
    public boolean I11L;
    public Fragment I11li1;
    public OnBackPressedDispatcher ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ArrayList<Integer> f1241ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f3656Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ArrayList<Ll1> f1242IL;
    public ArrayList<Fragment> LL1IL;
    public ArrayList<ILil.ILL.IL1Iii.IiL.ILil> Lil;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ArrayList<ILil.ILL.IL1Iii.IL1Iii> f1246L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public ArrayList<ILil.ILL.IL1Iii.IL1Iii> f1247LlLLL;
    public ILil.ILL.IL1Iii.I1I iIi1;
    public Fragment iIlLiL;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public ArrayList<ILil.ILL.IL1Iii.IL1Iii> f1250lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public ArrayList<Boolean> f1251lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public ILil.ILL.IL1Iii.iILLL1 f1252lIlii;
    public C0621il llI;
    public boolean llliI;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ArrayList<Fragment> f1255il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f1256lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public boolean f1257l;

    /* JADX INFO: renamed from: 丨丨 */
    public ArrayList<C0619ILl> f2;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean f12591;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public static final Interpolator f1240iILLl = new DecelerateInterpolator(2.5f);

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public static final Interpolator f1238IIi = new DecelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1254lLi1LL = 0;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final ArrayList<Fragment> f1248iILLL1 = new ArrayList<>();

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final HashMap<String, Fragment> f1243IiL = new HashMap<>();

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final ILil.IL1Iii.ILil f1245Ll1 = new IL1Iii(false);
    public final CopyOnWriteArrayList<C0620il> LlLI1 = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f1253llL1ii = 0;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public Bundle f1244L111 = null;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public SparseArray<Parcelable> f1258LLlI1 = null;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public Runnable f1249l1IIi1 = new ILil();

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$I1I */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class I1I implements Animation.AnimationListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3658IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Fragment f3659ILil;

        /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$I1I$IL1Iii */
        /* JADX INFO: compiled from: FragmentManagerImpl.java */
        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (I1I.this.f3659ILil.getAnimatingAway() != null) {
                    I1I.this.f3659ILil.setAnimatingAway(null);
                    I1I i1i = I1I.this;
                    L11I l11i = L11I.this;
                    Fragment fragment = i1i.f3659ILil;
                    l11i.m1529IL11L(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        }

        public I1I(ViewGroup viewGroup, Fragment fragment) {
            this.f3658IL1Iii = viewGroup;
            this.f3659ILil = fragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f3658IL1Iii.post(new IL1Iii());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class IL1Iii extends ILil.IL1Iii.ILil {
        public IL1Iii(boolean z) {
            super(z);
        }

        @Override // ILil.IL1Iii.ILil
        public void ILil() {
            L11I.this.LIlLi();
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$ILL */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public static class ILL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final int[] f3662IL1Iii = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$ILil */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L11I.this.I1IILIIL();
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$IL丨丨l, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public static class C0619ILl implements Fragment.iILLL1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3664I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final boolean f3665IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ILil.ILL.IL1Iii.IL1Iii f3666ILil;

        public C0619ILl(ILil.ILL.IL1Iii.IL1Iii iL1Iii, boolean z) {
            this.f3665IL1Iii = z;
            this.f3666ILil = iL1Iii;
        }

        public void I1I() {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = this.f3666ILil;
            iL1Iii.f1202lIlii.m1578lL(iL1Iii, this.f3665IL1Iii, false, false);
        }

        @Override // androidx.fragment.app.Fragment.iILLL1
        public void IL1Iii() {
            this.f3664I1I++;
        }

        @Override // androidx.fragment.app.Fragment.iILLL1
        public void ILil() {
            int i = this.f3664I1I - 1;
            this.f3664I1I = i;
            if (i != 0) {
                return;
            }
            this.f3666ILil.f1202lIlii.m1583l1L();
        }

        public boolean Ilil() {
            return this.f3664I1I == 0;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m1586IL() {
            boolean z = this.f3664I1I > 0;
            L11I l11i = this.f3666ILil.f1202lIlii;
            int size = l11i.f1248iILLL1.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = l11i.f1248iILLL1.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = this.f3666ILil;
            iL1Iii.f1202lIlii.m1578lL(iL1Iii, this.f3665IL1Iii, !z, true);
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class IL extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Fragment f3667I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3668IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f3669ILil;

        public IL(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f3668IL1Iii = viewGroup;
            this.f3669ILil = view;
            this.f3667I1I = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3668IL1Iii.endViewTransition(this.f3669ILil);
            Animator animator2 = this.f3667I1I.getAnimator();
            this.f3667I1I.setAnimator(null);
            if (animator2 == null || this.f3668IL1Iii.indexOfChild(this.f3669ILil) >= 0) {
                return;
            }
            L11I l11i = L11I.this;
            Fragment fragment = this.f3667I1I;
            l11i.m1529IL11L(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$Ll丨1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public interface Ll1 {
        boolean IL1Iii(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class iILLL1 extends ILil.ILL.IL1Iii.lLi1LL {
        public iILLL1() {
        }

        @Override // ILil.ILL.IL1Iii.lLi1LL
        public Fragment IL1Iii(ClassLoader classLoader, String str) {
            ILil.ILL.IL1Iii.iILLL1 iilll1 = L11I.this.f1252lIlii;
            return iilll1.IL1Iii(iilll1.m1595lLi1LL(), str, null);
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$lIi丨I, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class lIiI implements Ll1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f3676I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final String f3677IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f3678ILil;

        public lIiI(String str, int i, int i2) {
            this.f3677IL1Iii = str;
            this.f3678ILil = i;
            this.f3676I1I = i2;
        }

        @Override // ILil.ILL.IL1Iii.L11I.Ll1
        public boolean IL1Iii(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = L11I.this.I11li1;
            if (fragment == null || this.f3678ILil >= 0 || this.f3677IL1Iii != null || !fragment.getChildFragmentManager().mo1492IiL()) {
                return L11I.this.m1526I11IIi(arrayList, arrayList2, this.f3677IL1Iii, this.f3678ILil, this.f3676I1I);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public class lLi1LL extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Fragment f3679I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3680IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f3681ILil;

        public lLi1LL(L11I l11i, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f3680IL1Iii = viewGroup;
            this.f3681ILil = view;
            this.f3679I1I = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3680IL1Iii.endViewTransition(this.f3681ILil);
            animator.removeListener(this);
            Fragment fragment = this.f3679I1I;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$丨il, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public static final class C0620il {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ILil.ILL.IL1Iii.IiL.IL1Iii f3682IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final boolean f3683ILil;
    }

    /* JADX INFO: renamed from: Il丨iLL1i, reason: contains not printable characters */
    public static int m1522IliLL1i(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    /* JADX INFO: renamed from: Li1丨IL1, reason: contains not printable characters */
    public static IiL m1523Li1IL1(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1240iILLl);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f1238IIi);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new IiL(animationSet);
    }

    public static int Ll1(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: renamed from: iLiLI丨, reason: contains not printable characters */
    public static IiL m1524iLiLI(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f1238IIi);
        alphaAnimation.setDuration(220L);
        return new IiL(alphaAnimation);
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public static void m1525lIIiIlL(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                iL1Iii.Lil(-1);
                iL1Iii.iIlLiL(i == i2 + (-1));
            } else {
                iL1Iii.Lil(1);
                iL1Iii.iIi1();
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: I1 */
    public void m45I1() {
        if (this.f12591) {
            this.f12591 = false;
            m48Li();
        }
    }

    /* JADX INFO: renamed from: I11II丨i, reason: contains not printable characters */
    public boolean m1526I11IIi(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList3 = this.f1246L11I;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1246L11I.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    ILil.ILL.IL1Iii.IL1Iii iL1Iii = this.f1246L11I.get(size2);
                    if ((str != null && str.equals(iL1Iii.m1457lL())) || (i >= 0 && i == iL1Iii.iIlLiL)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        ILil.ILL.IL1Iii.IL1Iii iL1Iii2 = this.f1246L11I.get(size2);
                        if (str == null || !str.equals(iL1Iii2.m1457lL())) {
                            if (i < 0 || i != iL1Iii2.iIlLiL) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.f1246L11I.size() - 1) {
                return false;
            }
            for (int size3 = this.f1246L11I.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f1246L11I.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void I11L(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            IiL iiLLLIL1 = lLIL1(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (iiLLLIL1 == null || (animator = iiLLLIL1.f3671ILil) == null) {
                if (iiLLLIL1 != null) {
                    fragment.mView.startAnimation(iiLLLIL1.f3670IL1Iii);
                    iiLLLIL1.f3670IL1Iii.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    iiLLLIL1.f3671ILil.addListener(new lLi1LL(this, viewGroup, view, fragment));
                }
                iiLLLIL1.f3671ILil.start();
            }
        }
        if (fragment.mAdded && m1570IillIi(fragment)) {
            this.f1256lL = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public final void I11li1() {
        this.f3656Ilil = false;
        this.f1251lIII.clear();
        this.f1247LlLLL.clear();
    }

    @Override // ILil.ILL.IL1Iii.IiL
    public boolean I1I() {
        boolean zI1IILIIL = I1IILIIL();
        m47LL();
        return zI1IILIIL;
    }

    public boolean I1IILIIL() {
        m51lL(true);
        boolean z = false;
        while (m1549iI1LI(this.f1247LlLLL, this.f1251lIII)) {
            this.f3656Ilil = true;
            try {
                lI11lLL(this.f1247LlLLL, this.f1251lIII);
                I11li1();
                z = true;
            } catch (Throwable th) {
                I11li1();
                throw th;
            }
        }
        m55L();
        m45I1();
        m1562lIlii();
        return z;
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public void m1527I1L11L(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1527I1L11L(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1496ILl(this, fragment);
            }
        }
    }

    public void IIi1II(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.f1243IiL.containsKey(fragment.mWho)) {
            if (f1239L1l) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f1253llL1ii + "since it is not added to " + this);
                return;
            }
            return;
        }
        int iMin = this.f1253llL1ii;
        if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, 0);
        }
        m1529IL11L(fragment, iMin, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            Fragment fragmentLiil1L1l = Liil1L1l(fragment);
            if (fragmentLiil1L1l != null) {
                View view = fragmentLiil1L1l.mView;
                ViewGroup viewGroup = fragment.mContainer;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.mView, iIndexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                float f = fragment.mPostponedAlpha;
                if (f > 0.0f) {
                    fragment.mView.setAlpha(f);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                IiL iiLLLIL1 = lLIL1(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (iiLLLIL1 != null) {
                    Animation animation = iiLLLIL1.f3670IL1Iii;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        iiLLLIL1.f3671ILil.setTarget(fragment.mView);
                        iiLLLIL1.f3671ILil.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            I11L(fragment);
        }
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public void m1528IIiI(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1528IIiI(fragment, bundle, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1504il(this, fragment, bundle);
            }
        }
    }

    public void IL1(Parcelable parcelable) {
        FragmentState next;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f5015ILil == null) {
            return;
        }
        for (Fragment fragment : this.llI.m1601IiL()) {
            if (f1239L1l) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<FragmentState> it = fragmentManagerState.f5015ILil.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.f5017I1I.equals(fragment.mWho));
            if (next == null) {
                if (f1239L1l) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f5015ILil);
                }
                m1529IL11L(fragment, 1, 0, 0, false);
                fragment.mRemoving = true;
                m1529IL11L(fragment, 0, 0, 0, false);
            } else {
                next.Lil = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                Fragment fragment2 = fragment.mTarget;
                fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
                fragment.mTarget = null;
                Bundle bundle = next.f2645ILl;
                if (bundle != null) {
                    bundle.setClassLoader(this.f1252lIlii.m1595lLi1LL().getClassLoader());
                    fragment.mSavedViewState = next.f2645ILl.getSparseParcelableArray("android:view_state");
                    fragment.mSavedFragmentState = next.f2645ILl;
                }
            }
        }
        this.f1243IiL.clear();
        for (FragmentState fragmentState : fragmentManagerState.f5015ILil) {
            if (fragmentState != null) {
                Fragment fragmentIL1Iii = fragmentState.IL1Iii(this.f1252lIlii.m1595lLi1LL().getClassLoader(), Ilil());
                fragmentIL1Iii.mFragmentManager = this;
                if (f1239L1l) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentIL1Iii.mWho + "): " + fragmentIL1Iii);
                }
                this.f1243IiL.put(fragmentIL1Iii.mWho, fragmentIL1Iii);
                fragmentState.Lil = null;
            }
        }
        this.f1248iILLL1.clear();
        ArrayList<String> arrayList = fragmentManagerState.f5014I1I;
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment fragment3 = this.f1243IiL.get(str);
                if (fragment3 == null) {
                    m1535LIIlL(new IllegalStateException("No instantiated fragment for (" + str + ")"));
                    throw null;
                }
                fragment3.mAdded = true;
                if (f1239L1l) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragment3);
                }
                if (this.f1248iILLL1.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.f1248iILLL1) {
                    this.f1248iILLL1.add(fragment3);
                }
            }
        }
        if (fragmentManagerState.f2643IL != null) {
            this.f1246L11I = new ArrayList<>(fragmentManagerState.f2643IL.length);
            int i = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f2643IL;
                if (i >= backStackStateArr.length) {
                    break;
                }
                ILil.ILL.IL1Iii.IL1Iii IL1Iii2 = backStackStateArr[i].IL1Iii(this);
                if (f1239L1l) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + IL1Iii2.iIlLiL + "): " + IL1Iii2);
                    PrintWriter printWriter = new PrintWriter(new ILil.p028IiL.p034lIiI.ILil("FragmentManager"));
                    IL1Iii2.m1454lIlii("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1246L11I.add(IL1Iii2);
                int i2 = IL1Iii2.iIlLiL;
                if (i2 >= 0) {
                    m1538LLil(i2, IL1Iii2);
                }
                i++;
            }
        } else {
            this.f1246L11I = null;
        }
        String str2 = fragmentManagerState.f5016Ilil;
        if (str2 != null) {
            Fragment fragment4 = this.f1243IiL.get(str2);
            this.I11li1 = fragment4;
            iIilII1(fragment4);
        }
        this.f1254lLi1LL = fragmentManagerState.f2644lLi1LL;
    }

    /* JADX WARN: Code duplicated, block: B:151:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:156:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:158:0x0303  */
    /* JADX WARN: Code duplicated, block: B:216:0x0405  */
    /* JADX WARN: Code duplicated, block: B:218:0x0409  */
    /* JADX WARN: Code duplicated, block: B:220:0x040f  */
    /* JADX WARN: Code duplicated, block: B:221:0x041a  */
    /* JADX WARN: Code duplicated, block: B:223:0x0420  */
    /* JADX WARN: Code duplicated, block: B:271:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:153:0x02e1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:158:0x0303, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:271:0x04d9, please report this as an issue */
    /* JADX INFO: renamed from: IL11L丨, reason: contains not printable characters */
    public void m1529IL11L(Fragment fragment, int i, int i2, int i3, boolean z) {
        int i4;
        Fragment fragment2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        String resourceName;
        int i5;
        int i6 = 1;
        boolean zIsChangingConfigurations = true;
        if (!fragment.mAdded || fragment.mDetached) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (fragment.mRemoving && i4 > (i5 = fragment.mState)) {
            i4 = (i5 == 0 && fragment.isInBackStack()) ? 1 : fragment.mState;
        }
        if (fragment.mDeferStart && fragment.mState < 3 && i4 > 2) {
            i4 = 2;
        }
        ILil.p042lIiI.IL.ILil iLil = fragment.mMaxState;
        int iMin = iLil == ILil.p042lIiI.IL.ILil.CREATED ? Math.min(i4, 1) : Math.min(i4, iLil.ordinal());
        int i7 = fragment.mState;
        if (i7 > iMin) {
            if (i7 > iMin) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 4) {
                                if (iMin < 4) {
                                    if (f1239L1l) {
                                        Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                                    }
                                    fragment.performPause();
                                    m1555ill(fragment, false);
                                }
                            }
                        }
                        if (iMin < 3) {
                            if (f1239L1l) {
                                Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                            }
                            fragment.performStop();
                            LLL(fragment, false);
                        }
                    }
                    if (iMin < 2) {
                        if (f1239L1l) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.mView != null && this.f1252lIlii.Lil(fragment) && fragment.mSavedViewState == null) {
                            m1574iIIi1(fragment);
                        }
                        fragment.performDestroyView();
                        m1527I1L11L(fragment, false);
                        View view = fragment.mView;
                        if (view != null && (viewGroup = fragment.mContainer) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.mView.clearAnimation();
                            if (fragment.getParentFragment() == null || !fragment.getParentFragment().mRemoving) {
                                IiL iiLLLIL1 = (this.f1253llL1ii <= 0 || this.f1257l || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) ? null : lLIL1(fragment, i2, false, i3);
                                fragment.mPostponedAlpha = 0.0f;
                                if (iiLLLIL1 != null) {
                                    Lil(fragment, iiLLLIL1, iMin);
                                }
                                fragment.mContainer.removeView(fragment.mView);
                            }
                        }
                        fragment.mContainer = null;
                        fragment.mView = null;
                        fragment.mViewLifecycleOwner = null;
                        fragment.mViewLifecycleOwnerLiveData.mo1933IiL(null);
                        fragment.mInnerView = null;
                        fragment.mInLayout = false;
                    }
                    if (iMin >= 1) {
                        if (this.f1257l) {
                            if (fragment.getAnimatingAway() != null) {
                                View animatingAway = fragment.getAnimatingAway();
                                fragment.setAnimatingAway(null);
                                animatingAway.clearAnimation();
                            } else if (fragment.getAnimator() != null) {
                                Animator animator = fragment.getAnimator();
                                fragment.setAnimator(null);
                                animator.cancel();
                            }
                        }
                        if (fragment.getAnimatingAway() == null) {
                        }
                        fragment.setStateAfterAnimating(iMin);
                    }
                } else if (iMin >= 1) {
                    if (this.f1257l) {
                        if (fragment.getAnimatingAway() != null) {
                            View animatingAway2 = fragment.getAnimatingAway();
                            fragment.setAnimatingAway(null);
                            animatingAway2.clearAnimation();
                        } else if (fragment.getAnimator() != null) {
                            Animator animator2 = fragment.getAnimator();
                            fragment.setAnimator(null);
                            animator2.cancel();
                        }
                    }
                    if (fragment.getAnimatingAway() == null || fragment.getAnimator() != null) {
                        fragment.setStateAfterAnimating(iMin);
                    } else {
                        if (f1239L1l) {
                            Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                        }
                        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
                        if (z2 || this.llI.m1602Ll1(fragment)) {
                            ILil.ILL.IL1Iii.iILLL1 iilll1 = this.f1252lIlii;
                            if (iilll1 instanceof iIi1) {
                                zIsChangingConfigurations = this.llI.m1605il();
                            } else if (iilll1.m1595lLi1LL() instanceof Activity) {
                                zIsChangingConfigurations = true ^ ((Activity) this.f1252lIlii.m1595lLi1LL()).isChangingConfigurations();
                            }
                            if (z2 || zIsChangingConfigurations) {
                                this.llI.Ilil(fragment);
                            }
                            fragment.performDestroy();
                            m1532IIi(fragment, false);
                        } else {
                            fragment.mState = 0;
                        }
                        fragment.performDetach();
                        m1537LIll(fragment, false);
                        if (!z) {
                            if (z2 || this.llI.m1602Ll1(fragment)) {
                                m1577ili(fragment);
                            } else {
                                fragment.mHost = null;
                                fragment.mParentFragment = null;
                                fragment.mFragmentManager = null;
                                String str = fragment.mTargetWho;
                                if (str != null && (fragment2 = this.f1243IiL.get(str)) != null && fragment2.getRetainInstance()) {
                                    fragment.mTarget = fragment2;
                                }
                            }
                        }
                    }
                }
            }
            if (fragment.mState != i6) {
                Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i6 + " found " + fragment.mState);
                fragment.mState = i6;
            }
        }
        if (fragment.mFromLayout && !fragment.mInLayout) {
            return;
        }
        if (fragment.getAnimatingAway() != null || fragment.getAnimator() != null) {
            fragment.setAnimatingAway(null);
            fragment.setAnimator(null);
            m1529IL11L(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
        }
        int i8 = fragment.mState;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                    }
                }
                if (iMin > 3) {
                    if (f1239L1l) {
                        Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                    }
                    fragment.performResume();
                    m1540LlIl(fragment, false);
                    fragment.mSavedFragmentState = null;
                    fragment.mSavedViewState = null;
                }
            }
            if (iMin > 2) {
                if (f1239L1l) {
                    Log.v("FragmentManager", "moveto STARTED: " + fragment);
                }
                fragment.performStart();
                m1564lliiI1(fragment, false);
            }
            if (iMin > 3) {
                if (f1239L1l) {
                    Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                }
                fragment.performResume();
                m1540LlIl(fragment, false);
                fragment.mSavedFragmentState = null;
                fragment.mSavedViewState = null;
            }
        } else if (iMin > 0) {
            if (f1239L1l) {
                Log.v("FragmentManager", "moveto CREATED: " + fragment);
            }
            Bundle bundle = fragment.mSavedFragmentState;
            if (bundle != null) {
                bundle.setClassLoader(this.f1252lIlii.m1595lLi1LL().getClassLoader());
                fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                Fragment fragmentILI1Ll = ILI1Ll(fragment.mSavedFragmentState, "android:target_state");
                String str2 = fragmentILI1Ll != null ? fragmentILI1Ll.mWho : null;
                fragment.mTargetWho = str2;
                if (str2 != null) {
                    fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
                }
                Boolean bool = fragment.mSavedUserVisibleHint;
                if (bool != null) {
                    fragment.mUserVisibleHint = bool.booleanValue();
                    fragment.mSavedUserVisibleHint = null;
                } else {
                    fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                }
                if (!fragment.mUserVisibleHint) {
                    fragment.mDeferStart = true;
                    if (iMin > 2) {
                        iMin = 2;
                    }
                }
            }
            ILil.ILL.IL1Iii.iILLL1 iilll2 = this.f1252lIlii;
            fragment.mHost = iilll2;
            Fragment fragment3 = this.iIlLiL;
            fragment.mParentFragment = fragment3;
            fragment.mFragmentManager = fragment3 != null ? fragment3.mChildFragmentManager : iilll2.f1265lLi1LL;
            Fragment fragment4 = fragment.mTarget;
            String str3 = " declared target fragment ";
            String str4 = "Fragment ";
            if (fragment4 != null) {
                Fragment fragment5 = this.f1243IiL.get(fragment4.mWho);
                Fragment fragment6 = fragment.mTarget;
                if (fragment5 != fragment6) {
                    throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                }
                if (fragment6.mState < 1) {
                    m1529IL11L(fragment6, 1, 0, 0, true);
                }
                fragment.mTargetWho = fragment.mTarget.mWho;
                fragment.mTarget = null;
            } else {
                str4 = "Fragment ";
                str3 = " declared target fragment ";
            }
            String str5 = fragment.mTargetWho;
            if (str5 != null) {
                Fragment fragment7 = this.f1243IiL.get(str5);
                if (fragment7 == null) {
                    throw new IllegalStateException(str4 + fragment + str3 + fragment.mTargetWho + " that does not belong to this FragmentManager!");
                }
                if (fragment7.mState < 1) {
                    m1529IL11L(fragment7, 1, 0, 0, true);
                }
            }
            m1585(fragment, this.f1252lIlii.m1595lLi1LL(), false);
            fragment.performAttach();
            Fragment fragment8 = fragment.mParentFragment;
            if (fragment8 == null) {
                this.f1252lIlii.mo1588IiL(fragment);
            } else {
                fragment8.onAttachFragment(fragment);
            }
            m1544L1l(fragment, this.f1252lIlii.m1595lLi1LL(), false);
            if (fragment.mIsCreated) {
                fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
                fragment.mState = 1;
            } else {
                m1533L11(fragment, fragment.mSavedFragmentState, false);
                fragment.performCreate(fragment.mSavedFragmentState);
                m1575iILLl(fragment, fragment.mSavedFragmentState, false);
            }
        }
        if (iMin > 0) {
            l1Lll(fragment);
        }
        if (iMin > 1) {
            if (f1239L1l) {
                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
            }
            if (!fragment.mFromLayout) {
                int i9 = fragment.mContainerId;
                if (i9 == 0) {
                    viewGroup2 = null;
                } else {
                    if (i9 == -1) {
                        m1535LIIlL(new IllegalArgumentException("Cannot create fragment " + fragment + " for a container view with no id"));
                        throw null;
                    }
                    viewGroup2 = (ViewGroup) this.iIi1.I1I(i9);
                    if (viewGroup2 == null && !fragment.mRestored) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        m1535LIIlL(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment));
                        throw null;
                    }
                }
                fragment.mContainer = viewGroup2;
                fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), viewGroup2, fragment.mSavedFragmentState);
                View view2 = fragment.mView;
                if (view2 != null) {
                    fragment.mInnerView = view2;
                    view2.setSaveFromParentEnabled(false);
                    if (viewGroup2 != null) {
                        viewGroup2.addView(fragment.mView);
                    }
                    if (fragment.mHidden) {
                        fragment.mView.setVisibility(8);
                    }
                    fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                    m1547iI1iI(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                    fragment.mIsNewlyAdded = fragment.mView.getVisibility() == 0 && fragment.mContainer != null;
                } else {
                    fragment.mInnerView = null;
                }
            }
            fragment.performActivityCreated(fragment.mSavedFragmentState);
            m1559l1IIi1(fragment, fragment.mSavedFragmentState, false);
            if (fragment.mView != null) {
                fragment.restoreViewState(fragment.mSavedFragmentState);
            }
            fragment.mSavedFragmentState = null;
        }
        if (iMin > 2) {
            if (f1239L1l) {
                Log.v("FragmentManager", "moveto STARTED: " + fragment);
            }
            fragment.performStart();
            m1564lliiI1(fragment, false);
        }
        if (iMin > 3) {
            if (f1239L1l) {
                Log.v("FragmentManager", "moveto RESUMED: " + fragment);
            }
            fragment.performResume();
            m1540LlIl(fragment, false);
            fragment.mSavedFragmentState = null;
            fragment.mSavedViewState = null;
        }
        i6 = iMin;
        if (fragment.mState != i6) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + i6 + " found " + fragment.mState);
            fragment.mState = i6;
        }
    }

    @Override // ILil.ILL.IL1Iii.IiL
    public ILil.ILL.IL1Iii.ILL IL1Iii() {
        return new ILil.ILL.IL1Iii.IL1Iii(this);
    }

    public Fragment ILI1Ll(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f1243IiL.get(string);
        if (fragment != null) {
            return fragment;
        }
        m1535LIIlL(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public void ILL(ILil.ILL.IL1Iii.IL1Iii iL1Iii) {
        if (this.f1246L11I == null) {
            this.f1246L11I = new ArrayList<>();
        }
        this.f1246L11I.add(iL1Iii);
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public boolean m1530ILLIi(MenuItem menuItem) {
        if (this.f1253llL1ii < 1) {
            return false;
        }
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @Override // ILil.ILL.IL1Iii.IiL
    public void ILil(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f1243IiL.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f1243IiL.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f1248iILLL1.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                Fragment fragment2 = this.f1248iILLL1.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f1255il;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                Fragment fragment3 = this.f1255il.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList2 = this.f1246L11I;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                ILil.ILL.IL1Iii.IL1Iii iL1Iii = this.f1246L11I.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(iL1Iii.toString());
                iL1Iii.m1455llL1ii(str2, printWriter);
            }
        }
        synchronized (this) {
            ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList3 = this.f1250lIiI;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj = (ILil.ILL.IL1Iii.IL1Iii) this.f1250lIiI.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            ArrayList<Integer> arrayList4 = this.f1241ILl;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1241ILl.toArray()));
            }
        }
        ArrayList<Ll1> arrayList5 = this.f1242IL;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = (Ll1) this.f1242IL.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1252lIlii);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.iIi1);
        if (this.iIlLiL != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.iIlLiL);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1253llL1ii);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I11L);
        printWriter.print(" mStopped=");
        printWriter.print(this.llliI);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1257l);
        if (this.f1256lL) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1256lL);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int m1531ILl(ILil.ILL.IL1Iii.IL1Iii iL1Iii) {
        synchronized (this) {
            ArrayList<Integer> arrayList = this.f1241ILl;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<Integer> arrayList2 = this.f1241ILl;
                int iIntValue = arrayList2.remove(arrayList2.size() - 1).intValue();
                if (f1239L1l) {
                    Log.v("FragmentManager", "Adding back stack index " + iIntValue + " with " + iL1Iii);
                }
                this.f1250lIiI.set(iIntValue, iL1Iii);
                return iIntValue;
            }
            if (this.f1250lIiI == null) {
                this.f1250lIiI = new ArrayList<>();
            }
            int size = this.f1250lIiI.size();
            if (f1239L1l) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + iL1Iii);
            }
            this.f1250lIiI.add(iL1Iii);
            return size;
        }
    }

    @Override // ILil.ILL.IL1Iii.IiL
    public ILil.ILL.IL1Iii.lLi1LL Ilil() {
        if (super.Ilil() == ILil.ILL.IL1Iii.IiL.f3636I1I) {
            Fragment fragment = this.iIlLiL;
            if (fragment != null) {
                return fragment.mFragmentManager.Ilil();
            }
            m1493L11I(new iILLL1());
        }
        return super.Ilil();
    }

    /* JADX INFO: renamed from: I丨 */
    public void m46I() {
        this.I11L = false;
        this.llliI = false;
        m1551iiIIi11(3);
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public void m1532IIi(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1532IIi(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1497IL(this, fragment);
            }
        }
    }

    @Override // ILil.ILL.IL1Iii.IiL
    /* JADX INFO: renamed from: I丨L */
    public Fragment mo1491IL(String str) {
        if (str != null) {
            for (int size = this.f1248iILLL1.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1248iILLL1.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.f1243IiL.values()) {
            if (fragment2 != null && str.equals(fragment2.mTag)) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // ILil.ILL.IL1Iii.IiL
    /* JADX INFO: renamed from: I丨iL */
    public boolean mo1492IiL() {
        iIlLiL();
        return m1580llI11I(null, -1, 0);
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m1533L11(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1533L11(fragment, bundle, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1498IiL(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public void m1534L111() {
        this.f1257l = true;
        I1IILIIL();
        m1551iiIIi11(0);
        this.f1252lIlii = null;
        this.iIi1 = null;
        this.iIlLiL = null;
        if (this.ILL != null) {
            this.f1245Ll1.m1444IL();
            this.ILL = null;
        }
    }

    public void L1iI1(Ll1 ll1, boolean z) {
        if (!z) {
            iIlLiL();
        }
        synchronized (this) {
            if (!this.f1257l && this.f1252lIlii != null) {
                if (this.f1242IL == null) {
                    this.f1242IL = new ArrayList<>();
                }
                this.f1242IL.add(ll1);
                m1583l1L();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void L1ii1() {
        this.I11L = false;
        this.llliI = false;
        int size = this.f1248iILLL1.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void L1li1(Fragment fragment) {
        m1529IL11L(fragment, this.f1253llL1ii, 0, 0, false);
    }

    public Fragment LI11(int i) {
        for (int size = this.f1248iILLL1.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1248iILLL1.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f1243IiL.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i) {
                return fragment2;
            }
        }
        return null;
    }

    public lIlii LII(Fragment fragment) {
        return this.llI.m1603L11I(fragment);
    }

    /* JADX INFO: renamed from: LIIl丨丨L, reason: contains not printable characters */
    public final void m1535LIIlL(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new ILil.p028IiL.p034lIiI.ILil("FragmentManager"));
        ILil.ILL.IL1Iii.iILLL1 iilll1 = this.f1252lIlii;
        if (iilll1 != null) {
            try {
                iilll1.mo1590L11I("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            ILil("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public Parcelable LIiiILi() {
        ArrayList<String> arrayList;
        int size;
        m47LL();
        m1572i11i();
        I1IILIIL();
        this.I11L = true;
        BackStackState[] backStackStateArr = null;
        if (this.f1243IiL.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.f1243IiL.size());
        boolean z = false;
        for (Fragment fragment : this.f1243IiL.values()) {
            if (fragment != null) {
                if (fragment.mFragmentManager != this) {
                    m1535LIIlL(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                    throw null;
                }
                FragmentState fragmentState = new FragmentState(fragment);
                arrayList2.add(fragmentState);
                if (fragment.mState <= 0 || fragmentState.f2645ILl != null) {
                    fragmentState.f2645ILl = fragment.mSavedFragmentState;
                } else {
                    fragmentState.f2645ILl = lIlIl(fragment);
                    String str = fragment.mTargetWho;
                    if (str != null) {
                        Fragment fragment2 = this.f1243IiL.get(str);
                        if (fragment2 == null) {
                            m1535LIIlL(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTargetWho));
                            throw null;
                        }
                        if (fragmentState.f2645ILl == null) {
                            fragmentState.f2645ILl = new Bundle();
                        }
                        m1567IL1iLI(fragmentState.f2645ILl, "android:target_state", fragment2);
                        int i = fragment.mTargetRequestCode;
                        if (i != 0) {
                            fragmentState.f2645ILl.putInt("android:target_req_state", i);
                        }
                    }
                }
                if (f1239L1l) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f2645ILl);
                }
                z = true;
            }
        }
        if (!z) {
            if (f1239L1l) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f1248iILLL1.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            for (Fragment fragment3 : this.f1248iILLL1) {
                arrayList.add(fragment3.mWho);
                if (fragment3.mFragmentManager != this) {
                    m1535LIIlL(new IllegalStateException("Failure saving state: active " + fragment3 + " was removed from the FragmentManager"));
                    throw null;
                }
                if (f1239L1l) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment3.mWho + "): " + fragment3);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList3 = this.f1246L11I;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f1246L11I.get(i2));
                if (f1239L1l) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1246L11I.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f5015ILil = arrayList2;
        fragmentManagerState.f5014I1I = arrayList;
        fragmentManagerState.f2643IL = backStackStateArr;
        Fragment fragment4 = this.I11li1;
        if (fragment4 != null) {
            fragmentManagerState.f5016Ilil = fragment4.mWho;
        }
        fragmentManagerState.f2644lLi1LL = this.f1254lLi1LL;
        return fragmentManagerState;
    }

    public void LIlLi() {
        I1IILIIL();
        if (this.f1245Ll1.I1I()) {
            mo1492IiL();
        } else {
            this.ILL.I1I();
        }
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public boolean m1536LIl(Menu menu) {
        if (this.f1253llL1ii < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m1537LIll(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1537LIll(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.Ilil(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: LL */
    public final void m47LL() {
        if (this.f2 != null) {
            while (!this.f2.isEmpty()) {
                this.f2.remove(0).m1586IL();
            }
        }
    }

    public boolean LL1IL(Menu menu, MenuInflater menuInflater) {
        if (this.f1253llL1ii < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f1255il != null) {
            for (int i2 = 0; i2 < this.f1255il.size(); i2++) {
                Fragment fragment2 = this.f1255il.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1255il = arrayList;
        return z;
    }

    public void LLL(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).LLL(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1499Ll1(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: LLi丨l, reason: contains not printable characters */
    public void m1538LLil(int i, ILil.ILL.IL1Iii.IL1Iii iL1Iii) {
        synchronized (this) {
            if (this.f1250lIiI == null) {
                this.f1250lIiI = new ArrayList<>();
            }
            int size = this.f1250lIiI.size();
            if (i < size) {
                if (f1239L1l) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + iL1Iii);
                }
                this.f1250lIiI.set(i, iL1Iii);
            } else {
                while (size < i) {
                    this.f1250lIiI.add(null);
                    if (this.f1241ILl == null) {
                        this.f1241ILl = new ArrayList<>();
                    }
                    if (f1239L1l) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1241ILl.add(Integer.valueOf(size));
                    size++;
                }
                if (f1239L1l) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + iL1Iii);
                }
                this.f1250lIiI.add(iL1Iii);
            }
        }
    }

    /* JADX INFO: renamed from: LL丨, reason: contains not printable characters */
    public final int m1539LL(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ILil.p065Ilil.lIiI<Fragment> liii) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (iL1Iii.m14581() && !iL1Iii.llliI(arrayList, i4 + 1, i2)) {
                if (this.f2 == null) {
                    this.f2 = new ArrayList<>();
                }
                C0619ILl c0619ILl = new C0619ILl(iL1Iii, zBooleanValue);
                this.f2.add(c0619ILl);
                iL1Iii.m1453lIII(c0619ILl);
                if (zBooleanValue) {
                    iL1Iii.iIi1();
                } else {
                    iL1Iii.iIlLiL(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, iL1Iii);
                }
                m1576il(liii);
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: Li */
    public void m48Li() {
        for (Fragment fragment : this.f1243IiL.values()) {
            if (fragment != null) {
                Li1l(fragment);
            }
        }
    }

    public void Li1l(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f3656Ilil) {
                this.f12591 = true;
            } else {
                fragment.mDeferStart = false;
                m1529IL11L(fragment, this.f1253llL1ii, 0, 0, false);
            }
        }
    }

    public Fragment LiL1(String str) {
        Fragment fragmentFindFragmentByWho;
        for (Fragment fragment : this.f1243IiL.values()) {
            if (fragment != null && (fragmentFindFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public final Fragment Liil1L1l(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.f1248iILLL1.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                Fragment fragment2 = this.f1248iILLL1.get(iIndexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final void Lil(Fragment fragment, IiL iiL, int i) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        if (iiL.f3670IL1Iii != null) {
            RunnableC0549L11I runnableC0549L11I = new RunnableC0549L11I(iiL.f3670IL1Iii, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            runnableC0549L11I.setAnimationListener(new I1I(viewGroup, fragment));
            fragment.mView.startAnimation(runnableC0549L11I);
            return;
        }
        Animator animator = iiL.f3671ILil;
        fragment.setAnimator(animator);
        animator.addListener(new IL(viewGroup, view, fragment));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public void m1540LlIl(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1540LlIl(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1500L11I(this, fragment);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void LlLI1(ILil.ILL.IL1Iii.iILLL1 iilll1, ILil.ILL.IL1Iii.I1I i1i, Fragment fragment) {
        ILil.p042lIiI.IiL iiL;
        if (this.f1252lIlii != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1252lIlii = iilll1;
        this.iIi1 = i1i;
        this.iIlLiL = fragment;
        if (fragment != null) {
            m55L();
        }
        if (iilll1 instanceof ILil.IL1Iii.I1I) {
            ILil.IL1Iii.I1I i1i2 = (ILil.IL1Iii.I1I) iilll1;
            OnBackPressedDispatcher onBackPressedDispatcherILil = i1i2.ILil();
            this.ILL = onBackPressedDispatcherILil;
            if (fragment != null) {
                iiL = i1i2;
                iiL = fragment;
            }
            iiL = i1i2;
            onBackPressedDispatcherILil.IL1Iii(iiL, this.f1245Ll1);
        }
        if (fragment != null) {
            this.llI = fragment.mFragmentManager.m1557iILiiLl(fragment);
        } else if (iilll1 instanceof iIi1) {
            this.llI = C0621il.m1599iILLL1(((iIi1) iilll1).getViewModelStore());
        } else {
            this.llI = new C0621il(false);
        }
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public void m1541LlLiLL() {
        this.I11L = false;
        this.llliI = false;
        m1551iiIIi11(4);
    }

    public void Lli(Fragment fragment) {
        if (fragment == null || (this.f1243IiL.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.I11li1;
            this.I11li1 = fragment;
            iIilII1(fragment2);
            iIilII1(this.I11li1);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: renamed from: Lll丨I11, reason: contains not printable characters */
    public void m1542LllI11() {
        if (this.Lil != null) {
            for (int i = 0; i < this.Lil.size(); i++) {
                this.Lil.get(i).IL1Iii();
            }
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1543Ll1(Fragment fragment, boolean z) {
        if (f1239L1l) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m1546iI1L1Ll(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.f1248iILLL1.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f1248iILLL1) {
            this.f1248iILLL1.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (m1570IillIi(fragment)) {
            this.f1256lL = true;
        }
        if (z) {
            L1li1(fragment);
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m1544L1l(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1544L1l(fragment, context, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.ILil(this, fragment, context);
            }
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m1545LlLLL(MenuItem menuItem) {
        if (this.f1253llL1ii < 1) {
            return false;
        }
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i1 */
    public void m49i1() {
        m1551iiIIi11(3);
    }

    /* JADX INFO: renamed from: iI */
    public void m50iI() {
        m55L();
        iIilII1(this.I11li1);
    }

    /* JADX INFO: renamed from: iI1L1丨Ll, reason: contains not printable characters */
    public void m1546iI1L1Ll(Fragment fragment) {
        if (this.f1243IiL.get(fragment.mWho) != null) {
            return;
        }
        this.f1243IiL.put(fragment.mWho, fragment);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                m1560lIiI(fragment);
            } else {
                m1558iLI(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (f1239L1l) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public void m1547iI1iI(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1547iI1iI(fragment, view, bundle, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1502lIiI(this, fragment, view, bundle);
            }
        }
    }

    public boolean iIi1() {
        boolean zM1570IillIi = false;
        for (Fragment fragment : this.f1243IiL.values()) {
            if (fragment != null) {
                zM1570IillIi = m1570IillIi(fragment);
            }
            if (zM1570IillIi) {
                return true;
            }
        }
        return false;
    }

    public final void iIilII1(Fragment fragment) {
        if (fragment == null || this.f1243IiL.get(fragment.mWho) != fragment) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public final void m1548iIl1il(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<C0619ILl> arrayList3 = this.f2;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            C0619ILl c0619ILl = this.f2.get(i);
            if (arrayList != null && !c0619ILl.f3665IL1Iii && (iIndexOf2 = arrayList.indexOf(c0619ILl.f3666ILil)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                this.f2.remove(i);
                i--;
                size--;
                c0619ILl.I1I();
            } else if (c0619ILl.Ilil() || (arrayList != null && c0619ILl.f3666ILil.llliI(arrayList, 0, arrayList.size()))) {
                this.f2.remove(i);
                i--;
                size--;
                if (arrayList == null || c0619ILl.f3665IL1Iii || (iIndexOf = arrayList.indexOf(c0619ILl.f3666ILil)) == -1 || !arrayList2.get(iIndexOf).booleanValue()) {
                    c0619ILl.m1586IL();
                } else {
                    c0619ILl.I1I();
                }
            }
            i++;
        }
    }

    public boolean iIlL1(int i) {
        return this.f1253llL1ii >= i;
    }

    public final void iIlLiL() {
        if (m1568ILI()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public final boolean m1549iI1LI(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            ArrayList<Ll1> arrayList3 = this.f1242IL;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size = this.f1242IL.size();
                boolean zIL1Iii = false;
                for (int i = 0; i < size; i++) {
                    zIL1Iii |= this.f1242IL.get(i).IL1Iii(arrayList, arrayList2);
                }
                this.f1242IL.clear();
                this.f1252lIlii.m1591iILLL1().removeCallbacks(this.f1249l1IIi1);
                return zIL1Iii;
            }
            return false;
        }
    }

    @Override // ILil.ILL.IL1Iii.IiL
    /* JADX INFO: renamed from: iI丨LLL1 */
    public void mo1494iILLL1(int i, int i2) {
        if (i >= 0) {
            L1iI1(new lIiI(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public void m1550iILilI() {
        this.llliI = true;
        m1551iiIIi11(2);
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public final void m1551iiIIi11(int i) {
        try {
            this.f3656Ilil = true;
            m56i(i, false);
            this.f3656Ilil = false;
            I1IILIIL();
        } catch (Throwable th) {
            this.f3656Ilil = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: iil1丨, reason: contains not printable characters */
    public boolean m1552iil1(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        L11I l11i = fragment.mFragmentManager;
        return fragment == l11i.m15661iIl() && m1552iil1(l11i.iIlLiL);
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public void m1553ili11(boolean z) {
        for (int size = this.f1248iILLL1.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1248iILLL1.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public void ill1LI1l(Ll1 ll1, boolean z) {
        if (z && (this.f1252lIlii == null || this.f1257l)) {
            return;
        }
        m51lL(z);
        if (ll1.IL1Iii(this.f1247LlLLL, this.f1251lIII)) {
            this.f3656Ilil = true;
            try {
                lI11lLL(this.f1247LlLLL, this.f1251lIII);
                I11li1();
            } catch (Throwable th) {
                I11li1();
                throw th;
            }
        }
        m55L();
        m45I1();
        m1562lIlii();
    }

    /* JADX INFO: renamed from: il丨iiL丨, reason: contains not printable characters */
    public final void m1554iliiL(ILil.p065Ilil.lIiI<Fragment> liii) {
        int size = liii.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentM1967IiL = liii.m1967IiL(i);
            if (!fragmentM1967IiL.mAdded) {
                View viewRequireView = fragmentM1967IiL.requireView();
                fragmentM1967IiL.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public void m1555ill(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1555ill(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1503lLi1LL(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public void m1556i1I1I1l(int i) {
        synchronized (this) {
            this.f1250lIiI.set(i, null);
            if (this.f1241ILl == null) {
                this.f1241ILl = new ArrayList<>();
            }
            if (f1239L1l) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f1241ILl.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public C0621il m1557iILiiLl(Fragment fragment) {
        return this.llI.m1604lLi1LL(fragment);
    }

    /* JADX INFO: renamed from: i丨LI, reason: contains not printable characters */
    public void m1558iLI(Fragment fragment) {
        if (m1568ILI()) {
            if (f1239L1l) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.llI.ILL(fragment) && f1239L1l) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m1559l1IIi1(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1559l1IIi1(fragment, bundle, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.IL1Iii(this, fragment, bundle);
            }
        }
    }

    public void l1Lll(Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view == null) {
            fragment.mInnerView = null;
            return;
        }
        fragment.mInnerView = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.mHidden) {
            fragment.mView.setVisibility(8);
        }
        fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
        m1547iI1iI(fragment, fragment.mView, fragment.mSavedFragmentState, false);
    }

    public final void lI11lLL(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m1548iIl1il(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).LlLI1) {
                if (i2 != i) {
                    m1573i11LL(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).LlLI1) {
                        i2++;
                    }
                }
                m1573i11LL(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            m1573i11LL(arrayList, arrayList2, i2, size);
        }
    }

    public void lI1I1(Fragment fragment) {
        if (f1239L1l) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1560lIiI(Fragment fragment) {
        if (m1568ILI()) {
            if (f1239L1l) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.llI.m1600IL(fragment) && f1239L1l) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public Bundle lIlIl(Fragment fragment) {
        if (this.f1244L111 == null) {
            this.f1244L111 = new Bundle();
        }
        fragment.performSaveInstanceState(this.f1244L111);
        m1528IIiI(fragment, this.f1244L111, false);
        Bundle bundle = null;
        if (!this.f1244L111.isEmpty()) {
            Bundle bundle2 = this.f1244L111;
            this.f1244L111 = null;
            bundle = bundle2;
        }
        if (fragment.mView != null) {
            m1574iIIi1(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m1561lIII() {
        this.I11L = false;
        this.llliI = false;
        m1551iiIIi11(1);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m1562lIlii() {
        this.f1243IiL.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: renamed from: lL */
    public final void m51lL(boolean z) {
        if (this.f3656Ilil) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1252lIlii == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f1252lIlii.m1591iILLL1().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            iIlLiL();
        }
        if (this.f1247LlLLL == null) {
            this.f1247LlLLL = new ArrayList<>();
            this.f1251lIII = new ArrayList<>();
        }
        this.f3656Ilil = true;
        try {
            m1548iIl1il(null, null);
        } finally {
            this.f3656Ilil = false;
        }
    }

    public IiL lLIL1(Fragment fragment, int i, boolean z, int i2) {
        int iM1522IliLL1i;
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new IiL(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new IiL(animatorOnCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(this.f1252lIlii.m1595lLi1LL().getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f1252lIlii.m1595lLi1LL(), nextAnim);
                    if (animationLoadAnimation != null) {
                        return new IiL(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.f1252lIlii.m1595lLi1LL(), nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new IiL(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.f1252lIlii.m1595lLi1LL(), nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new IiL(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (iM1522IliLL1i = m1522IliLL1i(i, z)) < 0) {
            return null;
        }
        switch (iM1522IliLL1i) {
            case 1:
                return m1523Li1IL1(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m1523Li1IL1(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m1523Li1IL1(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m1523Li1IL1(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m1524iLiLI(0.0f, 1.0f);
            case 6:
                return m1524iLiLI(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f1252lIlii.mo1592lIiI()) {
                    i2 = this.f1252lIlii.mo1589Ll1();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* JADX INFO: renamed from: li */
    public boolean m52li() {
        return this.f1257l;
    }

    public void llI(boolean z) {
        for (int size = this.f1248iILLL1.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1248iILLL1.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public void llliI(Fragment fragment) {
        if (f1239L1l) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (f1239L1l) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f1248iILLL1) {
                this.f1248iILLL1.remove(fragment);
            }
            if (m1570IillIi(fragment)) {
                this.f1256lL = true;
            }
            fragment.mAdded = false;
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m1563llL1ii(Fragment fragment) {
        if (f1239L1l) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.f1248iILLL1.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (f1239L1l) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f1248iILLL1) {
                this.f1248iILLL1.add(fragment);
            }
            fragment.mAdded = true;
            if (m1570IillIi(fragment)) {
                this.f1256lL = true;
            }
        }
    }

    /* JADX INFO: renamed from: l丨 */
    public LayoutInflater.Factory2 m53l() {
        return this;
    }

    @Override // ILil.ILL.IL1Iii.IiL
    /* JADX INFO: renamed from: l丨Li1LL */
    public List<Fragment> mo1495lLi1LL() {
        List<Fragment> list;
        if (this.f1248iILLL1.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1248iILLL1) {
            list = (List) this.f1248iILLL1.clone();
        }
        return list;
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public void m1564lliiI1(Fragment fragment, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1564lliiI1(fragment, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.ILL(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public void m1565li11(Menu menu) {
        if (this.f1253llL1ii < 1) {
            return;
        }
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.f3662IL1Iii);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !ILil.ILL.IL1Iii.lLi1LL.ILil(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment fragmentLI11 = resourceId != -1 ? LI11(resourceId) : null;
        if (fragmentLI11 == null && string != null) {
            fragmentLI11 = mo1491IL(string);
        }
        if (fragmentLI11 == null && id != -1) {
            fragmentLI11 = LI11(id);
        }
        if (f1239L1l) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragmentLI11);
        }
        if (fragmentLI11 == null) {
            fragmentLI11 = Ilil().IL1Iii(context.getClassLoader(), str2);
            fragmentLI11.mFromLayout = true;
            fragmentLI11.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentLI11.mContainerId = id;
            fragmentLI11.mTag = string;
            fragmentLI11.mInLayout = true;
            fragmentLI11.mFragmentManager = this;
            ILil.ILL.IL1Iii.iILLL1 iilll1 = this.f1252lIlii;
            fragmentLI11.mHost = iilll1;
            fragmentLI11.onInflate(iilll1.m1595lLi1LL(), attributeSet, fragmentLI11.mSavedFragmentState);
            m1543Ll1(fragmentLI11, true);
        } else {
            if (fragmentLI11.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            fragmentLI11.mInLayout = true;
            ILil.ILL.IL1Iii.iILLL1 iilll2 = this.f1252lIlii;
            fragmentLI11.mHost = iilll2;
            fragmentLI11.onInflate(iilll2.m1595lLi1LL(), attributeSet, fragmentLI11.mSavedFragmentState);
        }
        Fragment fragment = fragmentLI11;
        if (this.f1253llL1ii >= 1 || !fragment.mFromLayout) {
            L1li1(fragment);
        } else {
            m1529IL11L(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.iIlLiL;
        if (fragment != null) {
            ILil.p028IiL.p034lIiI.IL1Iii.IL1Iii(fragment, sb);
        } else {
            ILil.p028IiL.p034lIiI.IL1Iii.IL1Iii(this.f1252lIlii, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨1 */
    public int m541() {
        ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList = this.f1246L11I;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public Fragment m15661iIl() {
        return this.I11li1;
    }

    /* JADX INFO: renamed from: 丨IL1i丨LI, reason: contains not printable characters */
    public void m1567IL1iLI(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
            return;
        }
        m1535LIIlL(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    /* JADX INFO: renamed from: 丨ILI, reason: contains not printable characters */
    public boolean m1568ILI() {
        return this.I11L || this.llliI;
    }

    /* JADX INFO: renamed from: 丨IiIi, reason: contains not printable characters */
    public void m1569IiIi(Fragment fragment) {
        if (f1239L1l) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* JADX INFO: renamed from: 丨IillIi, reason: contains not printable characters */
    public final boolean m1570IillIi(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.iIi1();
    }

    /* JADX INFO: renamed from: 丨IlL1ll1, reason: contains not printable characters */
    public void m1571IlL1ll1(Fragment fragment, ILil.p042lIiI.IL.ILil iLil) {
        if (this.f1243IiL.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = iLil;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: renamed from: 丨L */
    public final void m55L() {
        ArrayList<Ll1> arrayList = this.f1242IL;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f1245Ll1.m1445lLi1LL(m541() > 0 && m1552iil1(this.iIlLiL));
        } else {
            this.f1245Ll1.m1445lLi1LL(true);
        }
    }

    /* JADX INFO: renamed from: 丨i */
    public void m56i(int i, boolean z) {
        ILil.ILL.IL1Iii.iILLL1 iilll1;
        if (this.f1252lIlii == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f1253llL1ii) {
            this.f1253llL1ii = i;
            int size = this.f1248iILLL1.size();
            for (int i2 = 0; i2 < size; i2++) {
                IIi1II(this.f1248iILLL1.get(i2));
            }
            for (Fragment fragment : this.f1243IiL.values()) {
                if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                    if (!fragment.mIsNewlyAdded) {
                        IIi1II(fragment);
                    }
                }
            }
            m48Li();
            if (this.f1256lL && (iilll1 = this.f1252lIlii) != null && this.f1253llL1ii == 4) {
                iilll1.iIi1();
                this.f1256lL = false;
            }
        }
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public final void m1572i11i() {
        for (Fragment fragment : this.f1243IiL.values()) {
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    m1529IL11L(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public final void m1573i11LL(ArrayList<ILil.ILL.IL1Iii.IL1Iii> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).LlLI1;
        ArrayList<Fragment> arrayList3 = this.LL1IL;
        if (arrayList3 == null) {
            this.LL1IL = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.LL1IL.addAll(this.f1248iILLL1);
        Fragment fragmentM15661iIl = m15661iIl();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii = arrayList.get(i6);
            fragmentM15661iIl = !arrayList2.get(i6).booleanValue() ? iL1Iii.I11li1(this.LL1IL, fragmentM15661iIl) : iL1Iii.LL1IL(this.LL1IL, fragmentM15661iIl);
            z2 = z2 || iL1Iii.f1205IiL;
        }
        this.LL1IL.clear();
        if (!z) {
            ILil.ILL.IL1Iii.Ll1.LL1IL(this, arrayList, arrayList2, i, i2, false);
        }
        m1525lIIiIlL(arrayList, arrayList2, i, i2);
        if (z) {
            ILil.p065Ilil.lIiI<Fragment> liii = new ILil.p065Ilil.lIiI<>();
            m1576il(liii);
            int iM1539LL = m1539LL(arrayList, arrayList2, i, i2, liii);
            m1554iliiL(liii);
            i3 = iM1539LL;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            ILil.ILL.IL1Iii.Ll1.LL1IL(this, arrayList, arrayList2, i, i3, true);
            m56i(this.f1253llL1ii, true);
        }
        while (i5 < i2) {
            ILil.ILL.IL1Iii.IL1Iii iL1Iii2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = iL1Iii2.iIlLiL) >= 0) {
                m1556i1I1I1l(i4);
                iL1Iii2.iIlLiL = -1;
            }
            iL1Iii2.m1451LlLLL();
            i5++;
        }
        if (z2) {
            m1542LllI11();
        }
    }

    /* JADX INFO: renamed from: 丨iI丨Ii丨1, reason: contains not printable characters */
    public void m1574iIIi1(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.f1258LLlI1;
        if (sparseArray == null) {
            this.f1258LLlI1 = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.f1258LLlI1);
        if (this.f1258LLlI1.size() > 0) {
            fragment.mSavedViewState = this.f1258LLlI1;
            this.f1258LLlI1 = null;
        }
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m1575iILLl(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1575iILLl(fragment, bundle, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.I1I(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m1576il(ILil.p065Ilil.lIiI<Fragment> liii) {
        int i = this.f1253llL1ii;
        if (i < 1) {
            return;
        }
        int iMin = Math.min(i, 3);
        int size = this.f1248iILLL1.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f1248iILLL1.get(i2);
            if (fragment.mState < iMin) {
                m1529IL11L(fragment, iMin, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    liii.add(fragment);
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨ili丨, reason: contains not printable characters */
    public void m1577ili(Fragment fragment) {
        if (this.f1243IiL.get(fragment.mWho) == null) {
            return;
        }
        if (f1239L1l) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f1243IiL.values()) {
            if (fragment2 != null && fragment.mWho.equals(fragment2.mTargetWho)) {
                fragment2.mTarget = fragment;
                fragment2.mTargetWho = null;
            }
        }
        this.f1243IiL.put(fragment.mWho, null);
        m1558iLI(fragment);
        String str = fragment.mTargetWho;
        if (str != null) {
            fragment.mTarget = this.f1243IiL.get(str);
        }
        fragment.initState();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1578lL(ILil.ILL.IL1Iii.IL1Iii iL1Iii, boolean z, boolean z2, boolean z3) {
        if (z) {
            iL1Iii.iIlLiL(z3);
        } else {
            iL1Iii.iIi1();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(iL1Iii);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            ILil.ILL.IL1Iii.Ll1.LL1IL(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m56i(this.f1253llL1ii, true);
        }
        for (Fragment fragment : this.f1243IiL.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && iL1Iii.I11L(fragment.mContainerId)) {
                float f = fragment.mPostponedAlpha;
                if (f > 0.0f) {
                    fragment.mView.setAlpha(f);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨li1Ii1i, reason: contains not printable characters */
    public void m1579li1Ii1i(Fragment fragment) {
        if (f1239L1l) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.f1248iILLL1) {
                this.f1248iILLL1.remove(fragment);
            }
            if (m1570IillIi(fragment)) {
                this.f1256lL = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    /* JADX INFO: renamed from: 丨ll丨I11I, reason: contains not printable characters */
    public final boolean m1580llI11I(String str, int i, int i2) {
        I1IILIIL();
        m51lL(true);
        Fragment fragment = this.I11li1;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().mo1492IiL()) {
            return true;
        }
        boolean zM1526I11IIi = m1526I11IIi(this.f1247LlLLL, this.f1251lIII, str, i, i2);
        if (zM1526I11IIi) {
            this.f3656Ilil = true;
            try {
                lI11lLL(this.f1247LlLLL, this.f1251lIII);
                I11li1();
            } catch (Throwable th) {
                I11li1();
                throw th;
            }
        }
        m55L();
        m45I1();
        m1562lIlii();
        return zM1526I11IIi;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m1581l() {
        this.I11L = false;
        this.llliI = false;
        m1551iiIIi11(2);
    }

    /* JADX INFO: renamed from: 丨丨 */
    public void m57() {
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m1582LLlI1() {
        m1551iiIIi11(1);
    }

    /* JADX INFO: renamed from: 丨丨l丨1L, reason: contains not printable characters */
    public void m1583l1L() {
        synchronized (this) {
            ArrayList<C0619ILl> arrayList = this.f2;
            boolean z = false;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ArrayList<Ll1> arrayList2 = this.f1242IL;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f1252lIlii.m1591iILLL1().removeCallbacks(this.f1249l1IIi1);
                this.f1252lIlii.m1591iILLL1().post(this.f1249l1IIi1);
                m55L();
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m15841(Configuration configuration) {
        for (int i = 0; i < this.f1248iILLL1.size(); i++) {
            Fragment fragment = this.f1248iILLL1.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public void m1585(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.iIlLiL;
        if (fragment2 != null) {
            ILil.ILL.IL1Iii.IiL fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof L11I) {
                ((L11I) fragmentManager).m1585(fragment, context, true);
            }
        }
        for (C0620il c0620il : this.LlLI1) {
            if (!z || c0620il.f3683ILil) {
                c0620il.f3682IL1Iii.m1501iILLL1(this, fragment, context);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public static class IiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Animation f3670IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Animator f3671ILil;

        public IiL(Animation animation) {
            this.f3670IL1Iii = animation;
            this.f3671ILil = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public IiL(Animator animator) {
            this.f3670IL1Iii = null;
            this.f3671ILil = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.L丨1丨1丨I$L丨1丨1丨I, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    public static class RunnableC0549L11I extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final View f3672I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ViewGroup f3673ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f3674Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f1261IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f1262lLi1LL;

        public RunnableC0549L11I(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1262lLi1LL = true;
            this.f3673ILil = viewGroup;
            this.f3672I1I = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f1262lLi1LL = true;
            if (this.f1261IL) {
                return !this.f3674Ilil;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f1261IL = true;
                llL1ii.IL1Iii(this.f3673ILil, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1261IL || !this.f1262lLi1LL) {
                this.f3673ILil.endViewTransition(this.f3672I1I);
                this.f3674Ilil = true;
            } else {
                this.f1262lLi1LL = false;
                this.f3673ILil.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f1262lLi1LL = true;
            if (this.f1261IL) {
                return !this.f3674Ilil;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f1261IL = true;
                llL1ii.IL1Iii(this.f3673ILil, this);
            }
            return true;
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
