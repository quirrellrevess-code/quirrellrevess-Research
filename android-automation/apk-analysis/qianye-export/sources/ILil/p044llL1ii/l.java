package ILil.p044llL1ii;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: ILil.ll丨L1ii.丨l丨, reason: invalid class name */
/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final boolean f4466I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final boolean f4467IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final boolean f4468ILil;

    /* JADX INFO: renamed from: ILil.ll丨L1ii.丨l丨$IL1Iii */
    /* JADX INFO: compiled from: TransitionUtils.java */
    public static class IL1Iii implements TypeEvaluator<Matrix> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final float[] f4470IL1Iii = new float[9];

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final float[] f4471ILil = new float[9];

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Matrix f4469I1I = new Matrix();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f4470IL1Iii);
            matrix2.getValues(this.f4471ILil);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f4471ILil;
                float f2 = fArr[i];
                float[] fArr2 = this.f4470IL1Iii;
                fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
            }
            this.f4469I1I.setValues(this.f4471ILil);
            return this.f4469I1I;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f4467IL1Iii = i >= 19;
        f4468ILil = i >= 18;
        f4466I1I = i >= 28;
    }

    public static Animator I1I(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    public static View IL1Iii(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        IIi.m2558il(view, matrix);
        IIi.ILL(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapILil = ILil(view, matrix, rectF, viewGroup);
        if (bitmapILil != null) {
            imageView.setImageBitmap(bitmapILil);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Code duplicated, block: B:23:0x0088  */
    public static Bitmap ILil(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean zIsAttachedToWindow;
        boolean z2;
        Bitmap bitmapCreateBitmap;
        ViewGroup viewGroup2;
        int iIndexOfChild;
        int iRound;
        int iRound2;
        int iRound3;
        int iRound4;
        if (f4467IL1Iii) {
            z = !view.isAttachedToWindow();
            if (viewGroup != null) {
                zIsAttachedToWindow = viewGroup.isAttachedToWindow();
            }
            z2 = f4468ILil;
            bitmapCreateBitmap = null;
            if (z2 || !z) {
                viewGroup2 = null;
                iIndexOfChild = 0;
            } else {
                if (!zIsAttachedToWindow) {
                    return null;
                }
                viewGroup2 = (ViewGroup) view.getParent();
                iIndexOfChild = viewGroup2.indexOfChild(view);
                viewGroup.getOverlay().add(view);
            }
            iRound = Math.round(rectF.width());
            iRound2 = Math.round(rectF.height());
            if (iRound > 0 && iRound2 > 0) {
                float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
                iRound3 = Math.round(iRound * fMin);
                iRound4 = Math.round(iRound2 * fMin);
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(fMin, fMin);
                if (f4466I1I) {
                    Picture picture = new Picture();
                    Canvas canvasBeginRecording = picture.beginRecording(iRound3, iRound4);
                    canvasBeginRecording.concat(matrix);
                    view.draw(canvasBeginRecording);
                    picture.endRecording();
                    bitmapCreateBitmap = Bitmap.createBitmap(picture);
                } else {
                    bitmapCreateBitmap = Bitmap.createBitmap(iRound3, iRound4, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.concat(matrix);
                    view.draw(canvas);
                }
            }
            if (z2 && z) {
                viewGroup.getOverlay().remove(view);
                viewGroup2.addView(view, iIndexOfChild);
            }
            return bitmapCreateBitmap;
        }
        z = false;
        zIsAttachedToWindow = false;
        z2 = f4468ILil;
        bitmapCreateBitmap = null;
        if (z2) {
            viewGroup2 = null;
            iIndexOfChild = 0;
        } else {
            viewGroup2 = null;
            iIndexOfChild = 0;
        }
        iRound = Math.round(rectF.width());
        iRound2 = Math.round(rectF.height());
        if (iRound > 0) {
            float fMin2 = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
            iRound3 = Math.round(iRound * fMin2);
            iRound4 = Math.round(iRound2 * fMin2);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(fMin2, fMin2);
            if (f4466I1I) {
                Picture picture2 = new Picture();
                Canvas canvasBeginRecording2 = picture2.beginRecording(iRound3, iRound4);
                canvasBeginRecording2.concat(matrix);
                view.draw(canvasBeginRecording2);
                picture2.endRecording();
                bitmapCreateBitmap = Bitmap.createBitmap(picture2);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iRound3, iRound4, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                canvas2.concat(matrix);
                view.draw(canvas2);
            }
        }
        if (z2) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, iIndexOfChild);
        }
        return bitmapCreateBitmap;
    }
}
