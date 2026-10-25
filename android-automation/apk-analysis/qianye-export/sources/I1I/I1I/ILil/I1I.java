package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.text.TextUtils;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: compiled from: AccessibilityEnable.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {
    public static String I1I(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        return str.endsWith("\n") ? str.substring(0, str.length() - 1) : str;
    }

    public static void IL1Iii(String str) throws Throwable {
        String[] strArrSplit;
        String strI1I = I1I(lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{17, 86, 67, 64, 13, 87, 5, 64, 23, 83, 1, 77, 66, 64, 82, 87, 17, 75, 7, 19, 82, 90, 5, 91, 14, 86, 83, 107, 5, 90, 1, 86, 68, 71, 13, 91, 11, 95, 94, 64, 29, 102, 17, 86, 69, 66, 13, 90, 7, 64}, I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 14, 80, 2, 9}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 8, 2, 86, 82}, "771f0b"))), 10000L, true));
        if (TextUtils.isEmpty(strI1I) || (strArrSplit = strI1I.split(I1I.IL1Iii.IL1Iii(new byte[]{88}, I1I.IL1Iii.IL1Iii(new byte[]{0, 91, 80, 84, 92, 83}, I1I.IL1Iii.IL1Iii(new byte[]{86, 1, 80, 84, 94, 3}, "48f7fa"))))) == null) {
            return;
        }
        String strSubstring = BuildConfig.FLAVOR;
        for (String str2 : strArrSplit) {
            if (str2.compareTo(str) != 0) {
                strSubstring = (strSubstring + str) + I1I.IL1Iii.IL1Iii(new byte[]{14}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 90, 5, 3, 92}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 6, 81, 84, 1}, "5bed6d")));
            }
        }
        if (strSubstring.length() > 1 && strSubstring.endsWith(I1I.IL1Iii.IL1Iii(new byte[]{10}, I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 83, 84, 0, 15}, I1I.IL1Iii.IL1Iii(new byte[]{80, 82, 85, 86, 83, 13}, "e77074"))))) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        lIlii.iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{71, 85, 76, 22, 94, 87, 83, 67, 24, 18, 66, 77, 20, 67, 93, 1, 66, 75, 81, 16, 93, 12, 86, 91, 88, 85, 92, 61, 86, 90, 87, 85, 75, 17, 94, 91, 93, 92, 81, 22, 78, 102, 71, 85, 74, 20, 94, 90, 81, 67, 24}, I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 8, 86, 14, 9}, I1I.IL1Iii.IL1Iii(new byte[]{14, 86, 9, 13, 15, 3}, "8b9963"))) + strSubstring, I1I.IL1Iii.IL1Iii(new byte[]{22, 84, 21, 16, 93, 88, 2, 66, 65, 20, 65, 66, 69, 66, 4, 7, 65, 68, 0, 17, 0, 7, 87, 83, 22, 66, 8, 6, 93, 90, 12, 69, 24, 59, 81, 88, 4, 83, 13, 1, 80, 22, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 2, 92, 85, 15}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 7, 14, 5, 93}, "40d6dd"))), null}, 10000L);
    }

    public static void ILil(String str) throws Throwable {
        String strI1I = I1I(lIlii.iIi1(I1I.IL1Iii.IL1Iii(new byte[]{67, 84, 17, 21, 91, 94, 87, 66, 69, 6, 87, 68, 16, 66, 0, 2, 71, 66, 85, 17, 0, 15, 83, 82, 92, 84, 1, 62, 83, 83, 83, 84, 22, 18, 91, 82, 89, 93, 12, 21, 75, 111, 67, 84, 23, 23, 91, 83, 85, 66}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 81, 82, 4, 1}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 13, 1, 4, 83}, "a0922b"))), 10000L, true));
        if (strI1I.contains(str)) {
            str = strI1I;
        } else if (strI1I.length() != 0) {
            str = strI1I + I1I.IL1Iii.IL1Iii(new byte[]{11}, I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 6, 84, 1, 7}, I1I.IL1Iii.IL1Iii(new byte[]{1, 13, 1, 3, 85, 85}, "551bb6"))) + str;
        }
        lIlii.iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{17, 0, 23, 67, 91, 15, 5, 22, 67, 71, 71, 21, 66, 22, 6, 84, 71, 19, 7, 69, 6, 89, 83, 3, 14, 0, 7, 104, 83, 2, 1, 0, 16, 68, 91, 3, 11, 9, 10, 67, 75, 62, 17, 0, 17, 65, 91, 2, 7, 22, 67}, I1I.IL1Iii.IL1Iii(new byte[]{3, 92, 86, 2, 2, 81}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 80, 84, 7, 5}, "68ea75"))) + str, I1I.IL1Iii.IL1Iii(new byte[]{22, 92, 17, 70, 95, 15, 2, 74, 69, 66, 67, 21, 69, 74, 0, 81, 67, 19, 0, 25, 4, 81, 85, 4, 22, 74, 12, 80, 95, 13, 12, 77, 28, 109, 83, 15, 4, 91, 9, 87, 82, 65, 84}, I1I.IL1Iii.IL1Iii(new byte[]{83, 90, 86, 83, 0, 80}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 10, 4, 87, 7}, "e19ea6"))), null}, 10000L);
    }
}
