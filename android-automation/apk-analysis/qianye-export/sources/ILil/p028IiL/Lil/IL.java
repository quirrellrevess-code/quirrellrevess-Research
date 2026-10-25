package ILil.p028IiL.Lil;

import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: renamed from: ILil.I丨iL.Lil.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: EdgeEffectCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL {
    public static void IL1Iii(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }
}
