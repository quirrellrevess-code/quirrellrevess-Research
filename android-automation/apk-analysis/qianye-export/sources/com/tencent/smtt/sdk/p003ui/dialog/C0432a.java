package com.tencent.smtt.sdk.p003ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.ui.dialog.a */
/* JADX INFO: loaded from: classes.dex */
public class C0432a {

    /* JADX INFO: renamed from: a */
    private static float f649a = -1.0f;

    /* JADX INFO: renamed from: b */
    private static int f650b = -1;

    /* JADX INFO: renamed from: c */
    private static int f651c = -1;

    /* JADX INFO: renamed from: a */
    public static int m537a(Context context, float f) {
        return m539b(context, (f * 160.0f) / 320.0f);
    }

    /* JADX INFO: renamed from: a */
    private static void m538a(Context context) {
        if (f649a < 0.0f) {
            try {
                Field declaredField = Class.forName("com.tencent.mobileqq.app.FontSettingManager").getDeclaredField("customMetrics");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj instanceof DisplayMetrics) {
                    DisplayMetrics displayMetrics = (DisplayMetrics) obj;
                    f649a = displayMetrics.density;
                    f650b = displayMetrics.heightPixels;
                }
            } catch (Exception unused) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                f649a = displayMetrics2.density;
                f650b = displayMetrics2.heightPixels;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m539b(Context context, float f) {
        if (f649a == -1.0f) {
            m538a(context);
        }
        return (int) ((f * f649a) + 0.5f);
    }
}
