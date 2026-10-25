package androidx.transition;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p044llL1ii.C0006;
import ILil.p044llL1ii.C0644ILl;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import ILil.p044llL1ii.IIi;
import ILil.p044llL1ii.LlLI1;
import ILil.p044llL1ii.l;
import ILil.p044llL1ii.lIlii;
import ILil.p044llL1ii.lL;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5138I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int[] f5139ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2744IL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String[] f5137Ilil = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Property<Drawable, PointF> f2742lLi1LL = new ILil(PointF.class, "boundsOrigin");

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final Property<Ll1, PointF> f2741iILLL1 = new I1I(PointF.class, "topLeft");

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final Property<Ll1, PointF> f2738IiL = new IL(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final Property<View, PointF> f2740L11I = new lLi1LL(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final Property<View, PointF> f2743il = new iILLL1(PointF.class, "topLeft");
    public static final Property<View, PointF> ILL = new IiL(PointF.class, "position");

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static lIlii f2739Ll1 = new lIlii();

    public static class I1I extends Property<Ll1, PointF> {
        public I1I(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(Ll1 ll1) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(Ll1 ll1, PointF pointF) {
            ll1.I1I(pointF);
        }
    }

    public class IL1Iii extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f5140I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5141IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f5142ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ float f2745IL;

        public IL1Iii(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f5141IL1Iii = viewGroup;
            this.f5142ILil = bitmapDrawable;
            this.f5140I1I = view;
            this.f2745IL = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IIi.ILil(this.f5141IL1Iii).ILil(this.f5142ILil);
            IIi.m2554IiL(this.f5140I1I, this.f2745IL);
        }
    }

    public class ILL extends lL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5143IL1Iii = false;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5144ILil;

        public ILL(ChangeBounds changeBounds, ViewGroup viewGroup) {
            this.f5144ILil = viewGroup;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            if (!this.f5143IL1Iii) {
                C0006.m2582IL(this.f5144ILil, false);
            }
            transition.removeListener(this);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void ILil(Transition transition) {
            C0006.m2582IL(this.f5144ILil, false);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void Ilil(Transition transition) {
            C0006.m2582IL(this.f5144ILil, true);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        /* JADX INFO: renamed from: I丨L */
        public void mo2573IL(Transition transition) {
            C0006.m2582IL(this.f5144ILil, false);
            this.f5143IL1Iii = true;
        }
    }

    public static class ILil extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Rect f5145IL1Iii;

        public ILil(Class cls, String str) {
            super(cls, str);
            this.f5145IL1Iii = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f5145IL1Iii);
            Rect rect = this.f5145IL1Iii;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f5145IL1Iii);
            this.f5145IL1Iii.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f5145IL1Iii);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$I丨L, reason: invalid class name */
    public static class IL extends Property<Ll1, PointF> {
        public IL(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(Ll1 ll1) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(Ll1 ll1, PointF pointF) {
            ll1.IL1Iii(pointF);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$I丨iL, reason: invalid class name */
    public static class IiL extends Property<View, PointF> {
        public IiL(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            IIi.m2556iILLL1(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$Ll丨1, reason: invalid class name */
    public static class Ll1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5146I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5147IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5148ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public View f5149Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2746IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f2747iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2748lLi1LL;

        public Ll1(View view) {
            this.f5149Ilil = view;
        }

        public void I1I(PointF pointF) {
            this.f5147IL1Iii = Math.round(pointF.x);
            this.f5148ILil = Math.round(pointF.y);
            int i = this.f2748lLi1LL + 1;
            this.f2748lLi1LL = i;
            if (i == this.f2747iILLL1) {
                ILil();
            }
        }

        public void IL1Iii(PointF pointF) {
            this.f5146I1I = Math.round(pointF.x);
            this.f2746IL = Math.round(pointF.y);
            int i = this.f2747iILLL1 + 1;
            this.f2747iILLL1 = i;
            if (this.f2748lLi1LL == i) {
                ILil();
            }
        }

        public final void ILil() {
            IIi.m2556iILLL1(this.f5149Ilil, this.f5147IL1Iii, this.f5148ILil, this.f5146I1I, this.f2746IL);
            this.f2748lLi1LL = 0;
            this.f2747iILLL1 = 0;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$L丨1丨1丨I, reason: invalid class name */
    public class L11I extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Ll1 f5150IL1Iii;
        private Ll1 mViewBounds;

        public L11I(ChangeBounds changeBounds, Ll1 ll1) {
            this.f5150IL1Iii = ll1;
            this.mViewBounds = ll1;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$iI丨LLL1, reason: invalid class name */
    public static class iILLL1 extends Property<View, PointF> {
        public iILLL1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            IIi.m2556iILLL1(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$l丨Li1LL, reason: invalid class name */
    public static class lLi1LL extends Property<View, PointF> {
        public lLi1LL(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            IIi.m2556iILLL1(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeBounds$丨il, reason: invalid class name and case insensitive filesystem */
    public class C0666il extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Rect f5151I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5152IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f5153ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ int f5154Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f2749IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ int f2750iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ int f2751lLi1LL;

        public C0666il(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f5153ILil = view;
            this.f5151I1I = rect;
            this.f2749IL = i;
            this.f5154Ilil = i2;
            this.f2751lLi1LL = i3;
            this.f2750iILLL1 = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5152IL1Iii = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f5152IL1Iii) {
                return;
            }
            iIlLiL.m2110iIl1il(this.f5153ILil, this.f5151I1I);
            IIi.m2556iILLL1(this.f5153ILil, this.f2749IL, this.f5154Ilil, this.f2751lLi1LL, this.f2750iILLL1);
        }
    }

    public ChangeBounds() {
        this.f5139ILil = new int[2];
        this.f5138I1I = false;
        this.f2744IL = false;
    }

    public final boolean IL1Iii(View view, View view2) {
        if (!this.f2744IL) {
            return true;
        }
        C1 matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f4477ILil) {
            return true;
        }
        return false;
    }

    public void ILil(boolean z) {
        this.f5138I1I = z;
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
        View view = c1.f4477ILil;
        if (!iIlLiL.m2103LlIl(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c1.f4476IL1Iii.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c1.f4476IL1Iii.put("android:changeBounds:parent", c1.f4477ILil.getParent());
        if (this.f2744IL) {
            c1.f4477ILil.getLocationInWindow(this.f5139ILil);
            c1.f4476IL1Iii.put("android:changeBounds:windowX", Integer.valueOf(this.f5139ILil[0]));
            c1.f4476IL1Iii.put("android:changeBounds:windowY", Integer.valueOf(this.f5139ILil[1]));
        }
        if (this.f5138I1I) {
            c1.f4476IL1Iii.put("android:changeBounds:clip", iIlLiL.m2123lIlii(view));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        int i;
        View view;
        ObjectAnimator objectAnimatorIL1Iii;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorI1I;
        if (c1 == null || c2 == null) {
            return null;
        }
        Map<String, Object> map = c1.f4476IL1Iii;
        Map<String, Object> map2 = c2.f4476IL1Iii;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c2.f4477ILil;
        if (!IL1Iii(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) c1.f4476IL1Iii.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) c1.f4476IL1Iii.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) c2.f4476IL1Iii.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) c2.f4476IL1Iii.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f5139ILil);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fI1I = IIi.I1I(view2);
            IIi.m2554IiL(view2, 0.0f);
            IIi.ILil(viewGroup).IL1Iii(bitmapDrawable);
            PathMotion pathMotion = getPathMotion();
            int[] iArr = this.f5139ILil;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, LlLI1.IL1Iii(f2742lLi1LL, pathMotion.IL1Iii(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
            objectAnimatorOfPropertyValuesHolder.addListener(new IL1Iii(this, viewGroup, bitmapDrawable, view2, fI1I));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) c1.f4476IL1Iii.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) c2.f4476IL1Iii.get("android:changeBounds:bounds");
        int i3 = rect2.left;
        int i4 = rect3.left;
        int i5 = rect2.top;
        int i6 = rect3.top;
        int i7 = rect2.right;
        int i8 = rect3.right;
        int i9 = rect2.bottom;
        int i10 = rect3.bottom;
        int i11 = i7 - i3;
        int i12 = i9 - i5;
        int i13 = i8 - i4;
        int i14 = i10 - i6;
        Rect rect4 = (Rect) c1.f4476IL1Iii.get("android:changeBounds:clip");
        Rect rect5 = (Rect) c2.f4476IL1Iii.get("android:changeBounds:clip");
        if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
            i = 0;
        } else {
            i = (i3 == i4 && i5 == i6) ? 0 : 1;
            if (i7 != i8 || i9 != i10) {
                i++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i++;
        }
        if (i <= 0) {
            return null;
        }
        if (this.f5138I1I) {
            IIi.m2556iILLL1(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
            if (i3 == i4 && i5 == i6) {
                objectAnimatorIL1Iii = null;
            } else {
                view = view2;
                objectAnimatorIL1Iii = C0644ILl.IL1Iii(view, ILL, getPathMotion().IL1Iii(i3, i5, i4, i6));
            }
            if (rect4 == null) {
                i2 = 0;
                rect = new Rect(0, 0, i11, i12);
            } else {
                i2 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                iIlLiL.m2110iIl1il(view, rect);
                lIlii lilii = f2739Ll1;
                Object[] objArr = new Object[2];
                objArr[i2] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", lilii, objArr);
                objectAnimatorOfObject.addListener(new C0666il(this, view, rect5, i4, i6, i8, i10));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorI1I = l.I1I(objectAnimatorIL1Iii, objectAnimator);
        } else {
            IIi.m2556iILLL1(view, i3, i5, i7, i9);
            if (i != 2) {
                animatorI1I = (i3 == i4 && i5 == i6) ? C0644ILl.IL1Iii(view, f2740L11I, getPathMotion().IL1Iii(i7, i9, i8, i10)) : C0644ILl.IL1Iii(view, f2743il, getPathMotion().IL1Iii(i3, i5, i4, i6));
            } else if (i11 == i13 && i12 == i14) {
                animatorI1I = C0644ILl.IL1Iii(view, ILL, getPathMotion().IL1Iii(i3, i5, i4, i6));
            } else {
                Ll1 ll1 = new Ll1(view);
                ObjectAnimator objectAnimatorIL1Iii2 = C0644ILl.IL1Iii(ll1, f2741iILLL1, getPathMotion().IL1Iii(i3, i5, i4, i6));
                ObjectAnimator objectAnimatorIL1Iii3 = C0644ILl.IL1Iii(ll1, f2738IiL, getPathMotion().IL1Iii(i7, i9, i8, i10));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorIL1Iii2, objectAnimatorIL1Iii3);
                animatorSet.addListener(new L11I(this, ll1));
                animatorI1I = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            C0006.m2582IL(viewGroup4, true);
            addListener(new ILL(this, viewGroup4));
        }
        return animatorI1I;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f5137Ilil;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5139ILil = new int[2];
        this.f5138I1I = false;
        this.f2744IL = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f4402ILil);
        boolean zIL1Iii = ILil.p028IiL.p035lLi1LL.I1I.IiL.IL1Iii(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        ILil(zIL1Iii);
    }
}
