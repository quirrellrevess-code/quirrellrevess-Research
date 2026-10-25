package ILil.p044llL1ii;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
/* JADX INFO: loaded from: classes.dex */
public class llI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4449I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static LayoutTransition f4450IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Field f4451ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static boolean f4452Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Method f1870IL;

    /* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
    public static class IL1Iii extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    public static void IL1Iii(LayoutTransition layoutTransition) {
        if (!f4452Ilil) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f1870IL = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f4452Ilil = true;
        }
        Method method = f1870IL;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    public static void ILil(ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (f4450IL1Iii == null) {
            IL1Iii iL1Iii = new IL1Iii();
            f4450IL1Iii = iL1Iii;
            iL1Iii.setAnimator(2, null);
            f4450IL1Iii.setAnimator(0, null);
            f4450IL1Iii.setAnimator(1, null);
            f4450IL1Iii.setAnimator(3, null);
            f4450IL1Iii.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    IL1Iii(layoutTransition);
                }
                if (layoutTransition != f4450IL1Iii) {
                    viewGroup.setTag(llL1ii.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f4450IL1Iii);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f4449I1I) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f4451ILil = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f4449I1I = true;
        }
        Field field = f4451ILil;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        f4451ILil.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        int i = llL1ii.transition_layout_save;
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(i);
        if (layoutTransition2 != null) {
            viewGroup.setTag(i, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
