package ILil.p028IiL.p029ILl;

import ILil.p028IiL.p030IiL.IL1Iii.ILil;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: MenuItemCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class IiL {
    public static void I1I(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof ILil) {
            ((ILil) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static MenuItem IL1Iii(MenuItem menuItem, ILil iLil) {
        if (menuItem instanceof ILil) {
            return ((ILil) menuItem).IL1Iii(iLil);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void ILil(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof ILil) {
            ((ILil) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void Ilil(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof ILil) {
            ((ILil) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2041IL(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof ILil) {
            ((ILil) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m2042iILLL1(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof ILil) {
            ((ILil) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2043lLi1LL(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof ILil) {
            ((ILil) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }
}
