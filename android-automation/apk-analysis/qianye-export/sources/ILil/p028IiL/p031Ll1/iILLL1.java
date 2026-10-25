package ILil.p028IiL.p031Ll1;

import android.os.Build;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;
import java.util.Locale;

/* JADX INFO: renamed from: ILil.I丨iL.Ll丨1.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: TextUtilsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class iILLL1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Locale f4162IL1Iii = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);

    public static int IL1Iii(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int ILil(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f4162IL1Iii)) {
            return 0;
        }
        String strI1I = ILil.I1I(locale);
        if (strI1I == null) {
            return IL1Iii(locale);
        }
        return (strI1I.equalsIgnoreCase("Arab") || strI1I.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
