package ILil.p044llL1ii;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: renamed from: ILil.ll丨L1ii.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: ObjectAnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0644ILl {
    public static <T> ObjectAnimator IL1Iii(T t, Property<T, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? ObjectAnimator.ofObject(t, property, (TypeConverter) null, path) : ObjectAnimator.ofFloat(t, new Lil(property, path), 0.0f, 1.0f);
    }
}
