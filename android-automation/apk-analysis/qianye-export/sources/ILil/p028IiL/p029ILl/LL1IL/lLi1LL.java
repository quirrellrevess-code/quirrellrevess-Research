package ILil.p028IiL.p029ILl.LL1IL;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.LL1IL.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: AccessibilityRecordCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {
    public static void I1I(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }

    public static void IL1Iii(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void ILil(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }
}
