package androidx.transition;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import ILil.p044llL1ii.IIi;
import ILil.p044llL1ii.ILL;
import ILil.p044llL1ii.LlLI1;
import ILil.p044llL1ii.lIiI;
import ILil.p044llL1ii.lL;
import ILil.p044llL1ii.llL1ii;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final boolean f2753IiL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5162I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f5163ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Matrix f2756IL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String[] f5161Ilil = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Property<lLi1LL, float[]> f2755lLi1LL = new IL1Iii(float[].class, "nonTranslations");

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final Property<lLi1LL, PointF> f2754iILLL1 = new ILil(PointF.class, "translations");

    public class I1I extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ boolean f5164I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5165IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Matrix f5166ILil = new Matrix();

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ View f5167Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ Matrix f2757IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ lLi1LL f2759iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ iILLL1 f2760lLi1LL;

        public I1I(boolean z, Matrix matrix, View view, iILLL1 iilll1, lLi1LL lli1ll) {
            this.f5164I1I = z;
            this.f2757IL = matrix;
            this.f5167Ilil = view;
            this.f2760lLi1LL = iilll1;
            this.f2759iILLL1 = lli1ll;
        }

        public final void IL1Iii(Matrix matrix) {
            this.f5166ILil.set(matrix);
            this.f5167Ilil.setTag(llL1ii.transition_transform, this.f5166ILil);
            this.f2760lLi1LL.IL1Iii(this.f5167Ilil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5165IL1Iii = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f5165IL1Iii) {
                if (this.f5164I1I && ChangeTransform.this.f5163ILil) {
                    IL1Iii(this.f2757IL);
                } else {
                    this.f5167Ilil.setTag(llL1ii.transition_transform, null);
                    this.f5167Ilil.setTag(llL1ii.parent_matrix, null);
                }
            }
            IIi.m2557lLi1LL(this.f5167Ilil, null);
            this.f2760lLi1LL.IL1Iii(this.f5167Ilil);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            IL1Iii(this.f2759iILLL1.IL1Iii());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.m3362IL(this.f5167Ilil);
        }
    }

    public static class IL1Iii extends Property<lLi1LL, float[]> {
        public IL1Iii(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public float[] get(lLi1LL lli1ll) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(lLi1LL lli1ll, float[] fArr) {
            lli1ll.m3364IL(fArr);
        }
    }

    public static class ILil extends Property<lLi1LL, PointF> {
        public ILil(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public PointF get(lLi1LL lli1ll) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(lLi1LL lli1ll, PointF pointF) {
            lli1ll.I1I(pointF);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeTransform$I丨L, reason: invalid class name */
    public static class IL extends lL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public View f5168IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ILil.p044llL1ii.iILLL1 f5169ILil;

        public IL(View view, ILil.p044llL1ii.iILLL1 iilll1) {
            this.f5168IL1Iii = view;
            this.f5169ILil = iilll1;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            transition.removeListener(this);
            ILL.ILil(this.f5168IL1Iii);
            this.f5168IL1Iii.setTag(llL1ii.transition_transform, null);
            this.f5168IL1Iii.setTag(llL1ii.parent_matrix, null);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void ILil(Transition transition) {
            this.f5169ILil.setVisibility(4);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void Ilil(Transition transition) {
            this.f5169ILil.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeTransform$iI丨LLL1, reason: invalid class name */
    public static class iILLL1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final float f5170I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final float f5171IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final float f5172ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final float f5173Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final float f2761IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final float f2762IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final float f2763iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final float f2764lLi1LL;

        public iILLL1(View view) {
            this.f5171IL1Iii = view.getTranslationX();
            this.f5172ILil = view.getTranslationY();
            this.f5170I1I = iIlLiL.m2119l1IIi1(view);
            this.f2761IL = view.getScaleX();
            this.f5173Ilil = view.getScaleY();
            this.f2764lLi1LL = view.getRotationX();
            this.f2763iILLL1 = view.getRotationY();
            this.f2762IiL = view.getRotation();
        }

        public void IL1Iii(View view) {
            ChangeTransform.m3363lLi1LL(view, this.f5171IL1Iii, this.f5172ILil, this.f5170I1I, this.f2761IL, this.f5173Ilil, this.f2764lLi1LL, this.f2763iILLL1, this.f2762IiL);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof iILLL1)) {
                return false;
            }
            iILLL1 iilll1 = (iILLL1) obj;
            return iilll1.f5171IL1Iii == this.f5171IL1Iii && iilll1.f5172ILil == this.f5172ILil && iilll1.f5170I1I == this.f5170I1I && iilll1.f2761IL == this.f2761IL && iilll1.f5173Ilil == this.f5173Ilil && iilll1.f2764lLi1LL == this.f2764lLi1LL && iilll1.f2763iILLL1 == this.f2763iILLL1 && iilll1.f2762IiL == this.f2762IiL;
        }

        public int hashCode() {
            float f = this.f5171IL1Iii;
            int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.f5172ILil;
            int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.f5170I1I;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f2761IL;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f5173Ilil;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f2764lLi1LL;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f2763iILLL1;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f2762IiL;
            return iFloatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ChangeTransform$l丨Li1LL, reason: invalid class name */
    public static class lLi1LL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final float[] f5174I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Matrix f5175IL1Iii = new Matrix();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final View f5176ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public float f5177Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public float f2765IL;

        public lLi1LL(View view, float[] fArr) {
            this.f5176ILil = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f5174I1I = fArr2;
            this.f2765IL = fArr2[2];
            this.f5177Ilil = fArr2[5];
            ILil();
        }

        public void I1I(PointF pointF) {
            this.f2765IL = pointF.x;
            this.f5177Ilil = pointF.y;
            ILil();
        }

        public Matrix IL1Iii() {
            return this.f5175IL1Iii;
        }

        public final void ILil() {
            float[] fArr = this.f5174I1I;
            fArr[2] = this.f2765IL;
            fArr[5] = this.f5177Ilil;
            this.f5175IL1Iii.setValues(fArr);
            IIi.m2557lLi1LL(this.f5176ILil, this.f5175IL1Iii);
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3364IL(float[] fArr) {
            System.arraycopy(fArr, 0, this.f5174I1I, 0, fArr.length);
            ILil();
        }
    }

    static {
        f2753IiL = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.f5163ILil = true;
        this.f5162I1I = true;
        this.f2756IL = new Matrix();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m3362IL(View view) {
        m3363lLi1LL(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m3363lLi1LL(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        iIlLiL.m21281iIl(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001d  */
    public final boolean I1I(ViewGroup viewGroup, ViewGroup viewGroup2) {
        boolean z = true;
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            C1 matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues == null) {
                return false;
            }
            if (viewGroup2 != matchedTransitionValues.f4477ILil) {
                z = false;
            }
        } else if (viewGroup != viewGroup2) {
            z = false;
        }
        return z;
    }

    public final void IL1Iii(ViewGroup viewGroup, C1 c1, C1 c2) {
        View view = c2.f4477ILil;
        Matrix matrix = new Matrix((Matrix) c2.f4476IL1Iii.get("android:changeTransform:parentMatrix"));
        IIi.ILL(viewGroup, matrix);
        ILil.p044llL1ii.iILLL1 iilll1IL1Iii = ILL.IL1Iii(view, viewGroup, matrix);
        if (iilll1IL1Iii == null) {
            return;
        }
        iilll1IL1Iii.IL1Iii((ViewGroup) c1.f4476IL1Iii.get("android:changeTransform:parent"), c1.f4477ILil);
        Transition transition = this;
        while (true) {
            TransitionSet transitionSet = transition.mParent;
            if (transitionSet == null) {
                break;
            } else {
                transition = transitionSet;
            }
        }
        transition.addListener(new IL(view, iilll1IL1Iii));
        if (f2753IiL) {
            View view2 = c1.f4477ILil;
            if (view2 != c2.f4477ILil) {
                IIi.m2554IiL(view2, 0.0f);
            }
            IIi.m2554IiL(view, 1.0f);
        }
    }

    public final ObjectAnimator ILil(C1 c1, C1 c2, boolean z) {
        Matrix matrix = (Matrix) c1.f4476IL1Iii.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) c2.f4476IL1Iii.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = lIiI.f4443IL1Iii;
        }
        if (matrix2 == null) {
            matrix2 = lIiI.f4443IL1Iii;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        iILLL1 iilll1 = (iILLL1) c2.f4476IL1Iii.get("android:changeTransform:transforms");
        View view = c2.f4477ILil;
        m3362IL(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        lLi1LL lli1ll = new lLi1LL(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(lli1ll, PropertyValuesHolder.ofObject(f2755lLi1LL, new ILil.p044llL1ii.IL(new float[9]), fArr, fArr2), LlLI1.IL1Iii(f2754iILLL1, getPathMotion().IL1Iii(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        I1I i1i = new I1I(z, matrix3, view, iilll1, lli1ll);
        objectAnimatorOfPropertyValuesHolder.addListener(i1i);
        ILil.p044llL1ii.IL1Iii.IL1Iii(objectAnimatorOfPropertyValuesHolder, i1i);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public final void Ilil(C1 c1, C1 c2) {
        Matrix matrix = (Matrix) c2.f4476IL1Iii.get("android:changeTransform:parentMatrix");
        c2.f4477ILil.setTag(llL1ii.parent_matrix, matrix);
        Matrix matrix2 = this.f2756IL;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) c1.f4476IL1Iii.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            c1.f4476IL1Iii.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) c1.f4476IL1Iii.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C1 c1) {
        captureValues(c1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        captureValues(c1);
        if (f2753IiL) {
            return;
        }
        ((ViewGroup) c1.f4477ILil.getParent()).startViewTransition(c1.f4477ILil);
    }

    public final void captureValues(C1 c1) {
        View view = c1.f4477ILil;
        if (view.getVisibility() == 8) {
            return;
        }
        c1.f4476IL1Iii.put("android:changeTransform:parent", view.getParent());
        c1.f4476IL1Iii.put("android:changeTransform:transforms", new iILLL1(view));
        Matrix matrix = view.getMatrix();
        c1.f4476IL1Iii.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f5162I1I) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            IIi.m2558il(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            c1.f4476IL1Iii.put("android:changeTransform:parentMatrix", matrix2);
            c1.f4476IL1Iii.put("android:changeTransform:intermediateMatrix", view.getTag(llL1ii.transition_transform));
            c1.f4476IL1Iii.put("android:changeTransform:intermediateParentMatrix", view.getTag(llL1ii.parent_matrix));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        if (c1 == null || c2 == null || !c1.f4476IL1Iii.containsKey("android:changeTransform:parent") || !c2.f4476IL1Iii.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) c1.f4476IL1Iii.get("android:changeTransform:parent");
        boolean z = this.f5162I1I && !I1I(viewGroup2, (ViewGroup) c2.f4476IL1Iii.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) c1.f4476IL1Iii.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            c1.f4476IL1Iii.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) c1.f4476IL1Iii.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            c1.f4476IL1Iii.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            Ilil(c1, c2);
        }
        ObjectAnimator objectAnimatorILil = ILil(c1, c2, z);
        if (z && objectAnimatorILil != null && this.f5163ILil) {
            IL1Iii(viewGroup, c1, c2);
        } else if (!f2753IiL) {
            viewGroup2.endViewTransition(c1.f4477ILil);
        }
        return objectAnimatorILil;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f5161Ilil;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5163ILil = true;
        this.f5162I1I = true;
        this.f2756IL = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f4403Ilil);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f5163ILil = IiL.IL1Iii(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f5162I1I = IiL.IL1Iii(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
