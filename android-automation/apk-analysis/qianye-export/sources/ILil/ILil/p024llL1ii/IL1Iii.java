package ILil.ILil.p024llL1ii;

import ILil.ILil.IL;
import ILil.ILil.ILL;
import ILil.ILil.ILil;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: ActionBarPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3865IL1Iii;

    public IL1Iii(Context context) {
        this.f3865IL1Iii = context;
    }

    public static IL1Iii ILil(Context context) {
        return new IL1Iii(context);
    }

    public int I1I() {
        return this.f3865IL1Iii.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean IL1Iii() {
        return this.f3865IL1Iii.getApplicationInfo().targetSdkVersion < 14;
    }

    public int Ilil() {
        return this.f3865IL1Iii.getResources().getDimensionPixelSize(IL.abc_action_bar_stacked_tab_max_width);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m1855IL() {
        Configuration configuration = this.f3865IL1Iii.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m1856IiL() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f3865IL1Iii).hasPermanentMenuKey();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m1857iILLL1() {
        return this.f3865IL1Iii.getResources().getBoolean(ILil.abc_action_bar_embed_tabs);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1858lLi1LL() {
        TypedArray typedArrayObtainStyledAttributes = this.f3865IL1Iii.obtainStyledAttributes(null, ILL.ActionBar, ILil.ILil.IL1Iii.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(ILL.ActionBar_height, 0);
        Resources resources = this.f3865IL1Iii.getResources();
        if (!m1857iILLL1()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(IL.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }
}
