package ILil.p028IiL.p029ILl;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: KeyEventDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4041I1I = false;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static boolean f4042IL1Iii = false;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Method f4043ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Field f1612IL;

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.I丨L$IL1Iii */
    /* JADX INFO: compiled from: KeyEventDispatcher.java */
    public interface IL1Iii {
        /* JADX INFO: renamed from: I丨L */
        boolean mo1654IL(KeyEvent keyEvent);
    }

    public static boolean I1I(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListenerM2040lLi1LL = m2040lLi1LL(dialog);
        if (onKeyListenerM2040lLi1LL != null && onKeyListenerM2040lLi1LL.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (iIlLiL.m2098IiL(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean IL1Iii(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f4042IL1Iii) {
            try {
                f4043ILil = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f4042IL1Iii = true;
        }
        Method method = f4043ILil;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    public static boolean ILil(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && IL1Iii(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (iIlLiL.m2098IiL(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    public static boolean Ilil(IL1Iii iL1Iii, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (iL1Iii == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return iL1Iii.mo1654IL(keyEvent);
        }
        if (callback instanceof Activity) {
            return ILil((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return I1I((Dialog) callback, keyEvent);
        }
        return (view != null && iIlLiL.m2098IiL(view, keyEvent)) || iL1Iii.mo1654IL(keyEvent);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean m2039IL(View view, KeyEvent keyEvent) {
        return iIlLiL.m2107L11I(view, keyEvent);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static DialogInterface.OnKeyListener m2040lLi1LL(Dialog dialog) {
        if (!f4041I1I) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f1612IL = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4041I1I = true;
        }
        Field field = f1612IL;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
