package androidx.transition;

import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.Ll1;
import ILil.p044llL1ii.l;
import ILil.p044llL1ii.lIiI;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String[] f5158ILil = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final TypeEvaluator<Matrix> f5157I1I = new IL1Iii();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Property<ImageView, Matrix> f2752IL = new ILil(Matrix.class, "animatedTransform");

    public static /* synthetic */ class I1I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f5159IL1Iii;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f5159IL1Iii = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5159IL1Iii[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class IL1Iii implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    public static class ILil extends Property<ImageView, Matrix> {
        public ILil(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            Ll1.IL1Iii(imageView, matrix);
        }
    }

    public ChangeImageTransform() {
    }

    public static Matrix IL1Iii(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f2 = intrinsicHeight;
        float fMax = Math.max(width / f, height / f2);
        int iRound = Math.round((width - (f * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f2 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }

    public static Matrix ILil(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i = I1I.f5159IL1Iii[imageView.getScaleType().ordinal()];
            if (i == 1) {
                return Ilil(imageView);
            }
            if (i == 2) {
                return IL1Iii(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    public static Matrix Ilil(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    public final ObjectAnimator I1I(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f2752IL, (TypeEvaluator) new l.IL1Iii(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final ObjectAnimator m3361IL(ImageView imageView) {
        Property<ImageView, Matrix> property = f2752IL;
        TypeEvaluator<Matrix> typeEvaluator = f5157I1I;
        Matrix matrix = lIiI.f4443IL1Iii;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
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
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = c1.f4476IL1Iii;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", ILil(imageView));
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        if (c1 == null || c2 == null) {
            return null;
        }
        Rect rect = (Rect) c1.f4476IL1Iii.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) c2.f4476IL1Iii.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) c1.f4476IL1Iii.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) c2.f4476IL1Iii.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) c2.f4477ILil;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return m3361IL(imageView);
        }
        if (matrix == null) {
            matrix = lIiI.f4443IL1Iii;
        }
        if (matrix2 == null) {
            matrix2 = lIiI.f4443IL1Iii;
        }
        f2752IL.set(imageView, matrix);
        return I1I(imageView, matrix, matrix2);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f5158ILil;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
