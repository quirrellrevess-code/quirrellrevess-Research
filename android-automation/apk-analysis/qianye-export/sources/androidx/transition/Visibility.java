package androidx.transition;

import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p044llL1ii.C0006;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import ILil.p044llL1ii.IIi;
import ILil.p044llL1ii.l;
import ILil.p044llL1ii.lL;
import ILil.p044llL1ii.llL1ii;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final String[] f5197I1I = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5198ILil;

    public static class I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5199I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5200IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f5201ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public ViewGroup f5202Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2778IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public ViewGroup f2779lLi1LL;
    }

    public class IL1Iii extends lL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f5203I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5204IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f5205ILil;

        public IL1Iii(ViewGroup viewGroup, View view, View view2) {
            this.f5204IL1Iii = viewGroup;
            this.f5205ILil = view;
            this.f5203I1I = view2;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            this.f5203I1I.setTag(llL1ii.save_overlay_view, null);
            C0006.ILil(this.f5204IL1Iii).mo2562IL(this.f5205ILil);
            transition.removeListener(this);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void ILil(Transition transition) {
            C0006.ILil(this.f5204IL1Iii).mo2562IL(this.f5205ILil);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void Ilil(Transition transition) {
            if (this.f5205ILil.getParent() == null) {
                C0006.ILil(this.f5204IL1Iii).I1I(this.f5205ILil);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    public static class ILil extends AnimatorListenerAdapter implements Transition.IiL, ILil.p044llL1ii.IL1Iii.InterfaceC0584IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final ViewGroup f5206I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final View f5207IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f5208ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f5209Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final boolean f2781IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2782lLi1LL = false;

        public ILil(View view, int i, boolean z) {
            this.f5207IL1Iii = view;
            this.f5208ILil = i;
            this.f5206I1I = (ViewGroup) view.getParent();
            this.f2781IL = z;
            m3384iILLL1(true);
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            m3385lLi1LL();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.IiL
        public void IL1Iii(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        public void ILil(Transition transition) {
            m3384iILLL1(false);
        }

        @Override // androidx.transition.Transition.IiL
        public void Ilil(Transition transition) {
            m3384iILLL1(true);
        }

        @Override // androidx.transition.Transition.IiL
        /* JADX INFO: renamed from: I丨L */
        public void mo2573IL(Transition transition) {
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final void m3384iILLL1(boolean z) {
            ViewGroup viewGroup;
            if (!this.f2781IL || this.f5209Ilil == z || (viewGroup = this.f5206I1I) == null) {
                return;
            }
            this.f5209Ilil = z;
            C0006.m2582IL(viewGroup, z);
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final void m3385lLi1LL() {
            if (!this.f2782lLi1LL) {
                IIi.m2555L11I(this.f5207IL1Iii, this.f5208ILil);
                ViewGroup viewGroup = this.f5206I1I;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m3384iILLL1(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2782lLi1LL = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m3385lLi1LL();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, ILil.p044llL1ii.IL1Iii.InterfaceC0584IL1Iii
        public void onAnimationPause(Animator animator) {
            if (this.f2782lLi1LL) {
                return;
            }
            IIi.m2555L11I(this.f5207IL1Iii, this.f5208ILil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, ILil.p044llL1ii.IL1Iii.InterfaceC0584IL1Iii
        public void onAnimationResume(Animator animator) {
            if (this.f2782lLi1LL) {
                return;
            }
            IIi.m2555L11I(this.f5207IL1Iii, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public Visibility() {
        this.f5198ILil = 3;
    }

    public Animator I1I(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        return null;
    }

    public int IL1Iii() {
        return this.f5198ILil;
    }

    public final I1I ILil(C1 c1, C1 c2) {
        I1I i1i = new I1I();
        i1i.f5200IL1Iii = false;
        i1i.f5201ILil = false;
        if (c1 == null || !c1.f4476IL1Iii.containsKey("android:visibility:visibility")) {
            i1i.f5199I1I = -1;
            i1i.f5202Ilil = null;
        } else {
            i1i.f5199I1I = ((Integer) c1.f4476IL1Iii.get("android:visibility:visibility")).intValue();
            i1i.f5202Ilil = (ViewGroup) c1.f4476IL1Iii.get("android:visibility:parent");
        }
        if (c2 == null || !c2.f4476IL1Iii.containsKey("android:visibility:visibility")) {
            i1i.f2778IL = -1;
            i1i.f2779lLi1LL = null;
        } else {
            i1i.f2778IL = ((Integer) c2.f4476IL1Iii.get("android:visibility:visibility")).intValue();
            i1i.f2779lLi1LL = (ViewGroup) c2.f4476IL1Iii.get("android:visibility:parent");
        }
        if (c1 != null && c2 != null) {
            int i = i1i.f5199I1I;
            int i2 = i1i.f2778IL;
            if (i == i2 && i1i.f5202Ilil == i1i.f2779lLi1LL) {
                return i1i;
            }
            if (i != i2) {
                if (i == 0) {
                    i1i.f5201ILil = false;
                    i1i.f5200IL1Iii = true;
                } else if (i2 == 0) {
                    i1i.f5201ILil = true;
                    i1i.f5200IL1Iii = true;
                }
            } else if (i1i.f2779lLi1LL == null) {
                i1i.f5201ILil = false;
                i1i.f5200IL1Iii = true;
            } else if (i1i.f5202Ilil == null) {
                i1i.f5201ILil = true;
                i1i.f5200IL1Iii = true;
            }
        } else if (c1 == null && i1i.f2778IL == 0) {
            i1i.f5201ILil = true;
            i1i.f5200IL1Iii = true;
        } else if (c2 == null && i1i.f5199I1I == 0) {
            i1i.f5201ILil = false;
            i1i.f5200IL1Iii = true;
        }
        return i1i;
    }

    public Animator Ilil(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        return null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Animator m3381IL(ViewGroup viewGroup, C1 c1, int i, C1 c2, int i2) {
        if ((this.f5198ILil & 1) != 1 || c2 == null) {
            return null;
        }
        if (c1 == null) {
            View view = (View) c2.f4477ILil.getParent();
            if (ILil(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f5200IL1Iii) {
                return null;
            }
        }
        return I1I(viewGroup, c2.f4477ILil, c1, c2);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C1 c1) {
        captureValues(c1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        captureValues(c1);
    }

    public final void captureValues(C1 c1) {
        c1.f4476IL1Iii.put("android:visibility:visibility", Integer.valueOf(c1.f4477ILil.getVisibility()));
        c1.f4476IL1Iii.put("android:visibility:parent", c1.f4477ILil.getParent());
        int[] iArr = new int[2];
        c1.f4477ILil.getLocationOnScreen(iArr);
        c1.f4476IL1Iii.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        I1I i1iILil = ILil(c1, c2);
        if (!i1iILil.f5200IL1Iii) {
            return null;
        }
        if (i1iILil.f5202Ilil == null && i1iILil.f2779lLi1LL == null) {
            return null;
        }
        return i1iILil.f5201ILil ? m3381IL(viewGroup, c1, i1iILil.f5199I1I, c2, i1iILil.f2778IL) : m3383lLi1LL(viewGroup, c1, i1iILil.f5199I1I, c2, i1iILil.f2778IL);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f5197I1I;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3382iILLL1(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f5198ILil = i;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(C1 c1, C1 c2) {
        if (c1 == null && c2 == null) {
            return false;
        }
        if (c1 != null && c2 != null && c2.f4476IL1Iii.containsKey("android:visibility:visibility") != c1.f4476IL1Iii.containsKey("android:visibility:visibility")) {
            return false;
        }
        I1I i1iILil = ILil(c1, c2);
        if (i1iILil.f5200IL1Iii) {
            return i1iILil.f5199I1I == 0 || i1iILil.f2778IL == 0;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Animator m3383lLi1LL(ViewGroup viewGroup, C1 c1, int i, C1 c2, int i2) {
        View view;
        boolean z;
        boolean z2;
        View view2;
        if ((this.f5198ILil & 2) != 2 || c1 == null) {
            return null;
        }
        View view3 = c1.f4477ILil;
        View viewIL1Iii = c2 != null ? c2.f4477ILil : null;
        int i3 = llL1ii.save_overlay_view;
        View view4 = (View) view3.getTag(i3);
        if (view4 != null) {
            view2 = null;
            z2 = true;
        } else {
            if (viewIL1Iii == null || viewIL1Iii.getParent() == null) {
                if (viewIL1Iii != null) {
                    view = null;
                    z = false;
                } else {
                    viewIL1Iii = null;
                    view = null;
                    z = true;
                }
            } else if (i2 == 4 || view3 == viewIL1Iii) {
                view = viewIL1Iii;
                z = false;
                viewIL1Iii = null;
            } else {
                viewIL1Iii = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (ILil(getTransitionValues(view5, true), getMatchedTransitionValues(view5, true)).f5200IL1Iii) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.mCanRemoveViews) {
                            }
                        } else {
                            viewIL1Iii = l.IL1Iii(viewGroup, view3, view5);
                        }
                    }
                    z2 = false;
                    View view6 = view;
                    view4 = viewIL1Iii;
                    view2 = view6;
                }
                view2 = view;
                z2 = false;
                view4 = view3;
            } else {
                z2 = false;
                View view7 = view;
                view4 = viewIL1Iii;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            IIi.m2555L11I(view2, 0);
            Animator animatorIlil = Ilil(viewGroup, view2, c1, c2);
            if (animatorIlil != null) {
                ILil iLil = new ILil(view2, i2, true);
                animatorIlil.addListener(iLil);
                ILil.p044llL1ii.IL1Iii.IL1Iii(animatorIlil, iLil);
                addListener(iLil);
            } else {
                IIi.m2555L11I(view2, visibility);
            }
            return animatorIlil;
        }
        if (!z2) {
            int[] iArr = (int[]) c1.f4476IL1Iii.get("android:visibility:screenLocation");
            int i4 = iArr[0];
            int i5 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i4 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i5 - iArr2[1]) - view4.getTop());
            C0006.ILil(viewGroup).I1I(view4);
        }
        Animator animatorIlil2 = Ilil(viewGroup, view4, c1, c2);
        if (!z2) {
            if (animatorIlil2 == null) {
                C0006.ILil(viewGroup).mo2562IL(view4);
            } else {
                view3.setTag(i3, view4);
                addListener(new IL1Iii(viewGroup, view4, view3));
            }
        }
        return animatorIlil2;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5198ILil = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f4400I1I);
        int iM2316iILLL1 = IiL.m2316iILLL1(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iM2316iILLL1 != 0) {
            m3382iILLL1(iM2316iILLL1);
        }
    }
}
