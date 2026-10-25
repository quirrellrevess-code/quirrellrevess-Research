package androidx.transition;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p044llL1ii.C0646lIII;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IiL f2774IL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final TimeInterpolator f5184Ilil = new DecelerateInterpolator();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final TimeInterpolator f2772lLi1LL = new AccelerateInterpolator();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final IiL f2771iILLL1 = new IL1Iii();

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final IiL f2768IiL = new ILil();

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final IiL f2770L11I = new I1I();

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final IiL f2773il = new IL();
    public static final IiL ILL = new lLi1LL();

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static final IiL f2769Ll1 = new iILLL1();

    public static class I1I extends AbstractC0667il {
        public I1I() {
            super(null);
        }

        @Override // androidx.transition.Slide.IiL
        public float IL1Iii(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    public static class IL1Iii extends L11I {
        public IL1Iii() {
            super(null);
        }

        @Override // androidx.transition.Slide.IiL
        public float ILil(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    public static class ILil extends L11I {
        public ILil() {
            super(null);
        }

        @Override // androidx.transition.Slide.IiL
        public float ILil(ViewGroup viewGroup, View view) {
            return iIlLiL.m2134l(viewGroup) == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Slide$I丨L, reason: invalid class name */
    public static class IL extends L11I {
        public IL() {
            super(null);
        }

        @Override // androidx.transition.Slide.IiL
        public float ILil(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Slide$I丨iL, reason: invalid class name */
    public interface IiL {
        float IL1Iii(ViewGroup viewGroup, View view);

        float ILil(ViewGroup viewGroup, View view);
    }

    /* JADX INFO: renamed from: androidx.transition.Slide$L丨1丨1丨I, reason: invalid class name */
    public static abstract class L11I implements IiL {
        public L11I() {
        }

        @Override // androidx.transition.Slide.IiL
        public float IL1Iii(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        public /* synthetic */ L11I(IL1Iii iL1Iii) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Slide$iI丨LLL1, reason: invalid class name */
    public static class iILLL1 extends AbstractC0667il {
        public iILLL1() {
            super(null);
        }

        @Override // androidx.transition.Slide.IiL
        public float IL1Iii(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Slide$l丨Li1LL, reason: invalid class name */
    public static class lLi1LL extends L11I {
        public lLi1LL() {
            super(null);
        }

        @Override // androidx.transition.Slide.IiL
        public float ILil(ViewGroup viewGroup, View view) {
            return iIlLiL.m2134l(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Slide$丨il, reason: invalid class name and case insensitive filesystem */
    public static abstract class AbstractC0667il implements IiL {
        public AbstractC0667il() {
        }

        @Override // androidx.transition.Slide.IiL
        public float ILil(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        public /* synthetic */ AbstractC0667il(IL1Iii iL1Iii) {
            this();
        }
    }

    public Slide() {
        this.f2774IL = f2769Ll1;
        m3369L11I(80);
    }

    private void captureValues(C1 c1) {
        int[] iArr = new int[2];
        c1.f4477ILil.getLocationOnScreen(iArr);
        c1.f4476IL1Iii.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility
    public Animator I1I(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        if (c2 == null) {
            return null;
        }
        int[] iArr = (int[]) c2.f4476IL1Iii.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return C0646lIII.IL1Iii(view, c2, iArr[0], iArr[1], this.f2774IL.ILil(viewGroup, view), this.f2774IL.IL1Iii(viewGroup, view), translationX, translationY, f5184Ilil, this);
    }

    @Override // androidx.transition.Visibility
    public Animator Ilil(ViewGroup viewGroup, View view, C1 c1, C1 c2) {
        if (c1 == null) {
            return null;
        }
        int[] iArr = (int[]) c1.f4476IL1Iii.get("android:slide:screenPosition");
        return C0646lIII.IL1Iii(view, c1, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f2774IL.ILil(viewGroup, view), this.f2774IL.IL1Iii(viewGroup, view), f2772lLi1LL, this);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m3369L11I(int i) {
        if (i == 3) {
            this.f2774IL = f2771iILLL1;
        } else if (i == 5) {
            this.f2774IL = f2773il;
        } else if (i == 48) {
            this.f2774IL = f2770L11I;
        } else if (i == 80) {
            this.f2774IL = f2769Ll1;
        } else if (i == 8388611) {
            this.f2774IL = f2768IiL;
        } else {
            if (i != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f2774IL = ILL;
        }
        ILil.p044llL1ii.iIlLiL iillil = new ILil.p044llL1ii.iIlLiL();
        iillil.m2568il(i);
        setPropagation(iillil);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(C1 c1) {
        super.captureEndValues(c1);
        captureValues(c1);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        super.captureStartValues(c1);
        captureValues(c1);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2774IL = f2769Ll1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f1850lLi1LL);
        int iM2316iILLL1 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        m3369L11I(iM2316iILLL1);
    }
}
