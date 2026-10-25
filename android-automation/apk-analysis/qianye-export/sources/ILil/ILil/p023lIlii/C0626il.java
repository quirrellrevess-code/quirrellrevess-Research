package ILil.ILil.p023lIlii;

import ILil.p028IiL.p033iILLL1.ILL.I1I;
import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatProgressBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0626il {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final int[] f3841I1I = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ProgressBar f3842IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Bitmap f3843ILil;

    public C0626il(ProgressBar progressBar) {
        this.f3842IL1Iii = progressBar;
    }

    public void I1I(AttributeSet attributeSet, int i) {
        llI lliI11li1 = llI.I11li1(this.f3842IL1Iii.getContext(), attributeSet, f3841I1I, i, 0);
        Drawable drawableM1824IiL = lliI11li1.m1824IiL(0);
        if (drawableM1824IiL != null) {
            this.f3842IL1Iii.setIndeterminateDrawable(Ilil(drawableM1824IiL));
        }
        Drawable drawableM1824IiL2 = lliI11li1.m1824IiL(1);
        if (drawableM1824IiL2 != null) {
            this.f3842IL1Iii.setProgressDrawable(m1843IL(drawableM1824IiL2, false));
        }
        lliI11li1.m1833lL();
    }

    public final Shape IL1Iii() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Bitmap ILil() {
        return this.f3843ILil;
    }

    public final Drawable Ilil(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableM1843IL = m1843IL(animationDrawable.getFrame(i), true);
            drawableM1843IL.setLevel(10000);
            animationDrawable2.addFrame(drawableM1843IL, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Drawable m1843IL(Drawable drawable, boolean z) {
        if (drawable instanceof I1I) {
            I1I i1i = (I1I) drawable;
            Drawable drawableILil = i1i.ILil();
            if (drawableILil != null) {
                i1i.IL1Iii(m1843IL(drawableILil, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = m1843IL(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f3843ILil == null) {
                    this.f3843ILil = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(IL1Iii());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }
}
