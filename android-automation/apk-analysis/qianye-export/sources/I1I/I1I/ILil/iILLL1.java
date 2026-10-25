package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import android.content.ClipData;
import android.content.IOnPrimaryClipChangedListener;
import android.os.Build;
import android.os.IInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: ClipboardManager.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String f3237Ilil = "I1I.I1I.ILil.iI丨LLL1";

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Method f3238I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IInterface f3239IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Method f3240ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Method f1026IL;

    public iILLL1(IInterface iInterface) {
        this.f3239IL1Iii = iInterface;
    }

    public static void IL1Iii(Method method, IInterface iInterface, IOnPrimaryClipChangedListener iOnPrimaryClipChangedListener) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 29) {
            method.invoke(iInterface, iOnPrimaryClipChangedListener, I1I.IL1Iii.IL1Iii(new byte[]{83, 88, 95, 28, 86, 87, 84, 69, 93, 91, 83, 23, 67, 95, 87, 94, 91}, I1I.IL1Iii.IL1Iii(new byte[]{8, 7, 87, 80, 2, 12}, I1I.IL1Iii.IL1Iii(new byte[]{13, 3, 4, 3, 5, 83}, "53aa0f"))));
        } else {
            method.invoke(iInterface, iOnPrimaryClipChangedListener, I1I.IL1Iii.IL1Iii(new byte[]{1, 14, 90, 26, 4, 13, 6, 19, 88, 93, 1, 77, 17, 9, 82, 88, 9}, I1I.IL1Iii.IL1Iii(new byte[]{81, 0, 15, 85, 0, 7}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 9, 0, 1, 81}, "2b1ad5"))), 0);
        }
    }

    public static ClipData Ilil(Method method, IInterface iInterface) throws IllegalAccessException, InvocationTargetException {
        return Build.VERSION.SDK_INT < 29 ? (ClipData) method.invoke(iInterface, I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 15, 24, 88, 11, 2, 70, 13, 95, 93, 75, 21, 92, 7, 90, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 83, 4, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 2, 2, 84, 83}, "d1302a")))) : (ClipData) method.invoke(iInterface, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 8, 25, 86, 88, 83, 75, 10, 94, 83, 24, 68, 81, 0, 91, 91}, I1I.IL1Iii.IL1Iii(new byte[]{1, 88, 81, 6, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 0, 0, 84, 15}, "334129"))), 0);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m1005IiL(Method method, IInterface iInterface, ClipData clipData) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 29) {
            method.invoke(iInterface, clipData, I1I.IL1Iii.IL1Iii(new byte[]{86, 11, 14, 28, 4, 13, 81, 22, 12, 91, 1, 77, 70, 12, 6, 94, 9}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 5, 80, 1, 90}, I1I.IL1Iii.IL1Iii(new byte[]{4, 4, 86, 3, 82, 92}, "400a6e"))));
        } else {
            method.invoke(iInterface, clipData, I1I.IL1Iii.IL1Iii(new byte[]{0, 14, 12, 26, 7, 15, 7, 19, 14, 93, 2, 79, 16, 9, 4, 88, 10}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 81, 2, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{86, 86, 83, 4, 14, 6}, "dbc270"))), 0);
        }
    }

    public final Method I1I() throws NoSuchMethodException {
        if (this.f1026IL == null) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f1026IL = this.f3239IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{7, 1, 82, 96, 70, 90, 11, 4, 68, 73, 119, 95, 15, 21, 117, 88, 85, 93, 1, 0, 82, 124, 93, 64, 18, 0, 88, 85, 70}, I1I.IL1Iii.IL1Iii(new byte[]{80, 1, 7, 6, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{80, 1, 80, 82, 4, 87}, "feadb2"))), IOnPrimaryClipChangedListener.class, String.class);
            } else {
                this.f1026IL = this.f3239IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{82, 80, 87, 54, 71, 90, 94, 85, 65, 31, 118, 95, 90, 68, 112, 14, 84, 93, 84, 81, 87, 42, 92, 64, 71, 81, 93, 3, 71}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 7, 7, 1, 86}, I1I.IL1Iii.IL1Iii(new byte[]{1, 91, 85, 0, 13, 92}, "59aa99"))), IOnPrimaryClipChangedListener.class, String.class, Integer.TYPE);
            }
        }
        return this.f1026IL;
    }

    public boolean ILil(IOnPrimaryClipChangedListener iOnPrimaryClipChangedListener) {
        try {
            IL1Iii(I1I(), this.f3239IL1Iii, iOnPrimaryClipChangedListener);
            return true;
        } catch (Exception e) {
            IiL.IL1Iii(f3237Ilil, I1I.IL1Iii.IL1Iii(new byte[]{118, 90, 17, 95, 87, 70, 91, 90, 16, 19, 90, 8, 67, 90, 15, 86, 19, 11, 80, 65, 12, 92, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 82, 2, 81, 86}, I1I.IL1Iii.IL1Iii(new byte[]{80, 83, 14, 4, 86, 2}, "bc8542"))) + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Method m1006IL() throws NoSuchMethodException {
        if (this.f3240ILil == null) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f3240ILil = this.f3239IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 64, 101, 19, 80, 8, 7, 70, 76, 34, 85, 12, 22}, I1I.IL1Iii.IL1Iii(new byte[]{93, 83, 1, 80, 7, 0}, I1I.IL1Iii.IL1Iii(new byte[]{14, 2, 1, 83, 3, 15}, "6746e6"))), String.class);
            } else {
                this.f3240ILil = this.f3239IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{94, 1, 64, 50, 19, 88, 84, 5, 70, 27, 34, 93, 80, 20}, I1I.IL1Iii.IL1Iii(new byte[]{88, 80, 1, 91, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 0, 92, 89, 5}, "225e8a"))), String.class, Integer.TYPE);
            }
        }
        return this.f3240ILil;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean m1007L11I(CharSequence charSequence) {
        try {
            m1005IiL(m1009lLi1LL(), this.f3239IL1Iii, ClipData.newPlainText(null, charSequence));
            return true;
        } catch (Exception e) {
            IiL.IL1Iii(f3237Ilil, I1I.IL1Iii.IL1Iii(new byte[]{123, 86, 23, 95, 80, 16, 86, 86, 22, 19, 93, 94, 78, 86, 9, 86, 20, 93, 93, 77, 10, 92, 80}, I1I.IL1Iii.IL1Iii(new byte[]{10, 92, 80, 10, 2, 2}, I1I.IL1Iii.IL1Iii(new byte[]{10, 87, 86, 15, 3, 87}, "82d65e"))) + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public CharSequence m1008iILLL1() {
        try {
            ClipData clipDataIlil = Ilil(m1006IL(), this.f3239IL1Iii);
            if (clipDataIlil != null && clipDataIlil.getItemCount() != 0) {
                return clipDataIlil.getItemAt(0).getText();
            }
            return null;
        } catch (Exception e) {
            IiL.IL1Iii(f3237Ilil, I1I.IL1Iii.IL1Iii(new byte[]{113, 10, 20, 84, 5, 66, 92, 10, 21, 24, 8, 12, 68, 10, 10, 93, 65, 15, 87, 17, 9, 87, 5}, I1I.IL1Iii.IL1Iii(new byte[]{7, 6, 83, 1, 80, 83}, I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 83, 88, 1, 7}, "cdaa06"))) + e.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Method m1009lLi1LL() throws NoSuchMethodException {
        if (this.f3238I1I == null) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f3238I1I = this.f3239IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{17, 84, 65, 96, 23, 13, 15, 80, 71, 73, 38, 8, 11, 65}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 6, 81, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{3, 6, 6, 87, 87, 2}, "03562c"))), ClipData.class, String.class);
            } else {
                this.f3238I1I = this.f3239IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{16, 93, 17, 100, 19, 10, 14, 89, 23, 77, 34, 15, 10, 72}, I1I.IL1Iii.IL1Iii(new byte[]{83, 90, 6, 87, 7, 84}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 80, 82, 87, 1}, "6e3116"))), ClipData.class, String.class, Integer.TYPE);
            }
        }
        return this.f3238I1I;
    }
}
