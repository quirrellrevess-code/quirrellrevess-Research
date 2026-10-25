package com.google.android.material.animation;

import ILil.p038Ll1.IL1Iii.IL1Iii.I1I;
import ILil.p038Ll1.IL1Iii.IL1Iii.IL1Iii;
import ILil.p038Ll1.IL1Iii.IL1Iii.ILil;
import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class AnimationUtils {
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new ILil();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new IL1Iii();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new I1I();
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int lerp(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }
}
