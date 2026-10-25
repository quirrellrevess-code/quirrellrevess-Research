package ILil.p028IiL.p033iILLL1;

import android.graphics.Color;

/* JADX INFO: compiled from: ColorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {
    static {
        new ThreadLocal();
    }

    public static int I1I(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int IL1Iii(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int ILil(int i, int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int iIL1Iii = IL1Iii(iAlpha2, iAlpha);
        return Color.argb(iIL1Iii, I1I(Color.red(i), iAlpha2, Color.red(i2), iAlpha, iIL1Iii), I1I(Color.green(i), iAlpha2, Color.green(i2), iAlpha, iIL1Iii), I1I(Color.blue(i), iAlpha2, Color.blue(i2), iAlpha, iIL1Iii));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2248IL(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }
}
