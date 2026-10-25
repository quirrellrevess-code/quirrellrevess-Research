package I1I.p062Ilil.p064Ilil.IL1Iii;

import I1I.I1I.ILil.C0003lL;
import I1I.I1I.p008IL.lIlii;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.IL1Iii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: AccessibilityNodeInfoHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {
    public static Rect I1I(Rect rect) {
        Point pointILI1Ll = lIlii.ILI1Ll();
        Point pointM1180ILI = lIlii.m1180ILI();
        int i = pointILI1Ll.x;
        int i2 = pointILI1Ll.y;
        int i3 = pointM1180ILI.x;
        int i4 = pointM1180ILI.y;
        if (C0003lL.I1I().ILil() % 2 != 0) {
            i = i2;
            i2 = i;
            i3 = i4;
            i4 = i3;
        }
        if (i > 0 && i2 > 0) {
            Rect rect2 = new Rect();
            if (i3 <= 0 || i4 <= 0) {
                rect2.right = i;
                rect2.bottom = i2;
            } else {
                float f = (i3 * 1.0f) / i;
                float f2 = (i4 * 1.0f) / i2;
                rect2.top = 0;
                rect2.left = 0;
                rect2.right = i3;
                rect2.bottom = i4;
                rect.left = (int) (rect.left * f);
                rect.top = (int) (rect.top * f2);
                rect.right = (int) (rect.right * f);
                rect.bottom = (int) (rect.bottom * f2);
            }
            rect.intersect(rect2);
        }
        return rect;
    }

    public static Rect IL1Iii(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        try {
            accessibilityNodeInfo.getBoundsInParent(rect);
            I1I(rect);
        } catch (Exception unused) {
        }
        return rect;
    }

    public static Rect ILil(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        try {
            accessibilityNodeInfo.getBoundsInScreen(rect);
            Point pointILI1Ll = lIlii.ILI1Ll();
            int i = pointILI1Ll.x;
            int i2 = pointILI1Ll.y;
            if (C0003lL.I1I().ILil() % 2 != 0) {
                i = i2;
                i2 = i;
            }
            Rect rect2 = new Rect();
            rect2.top = 0;
            rect2.left = 0;
            rect2.right = i;
            rect2.bottom = i2;
            rect.intersect(rect2);
            I1I(rect);
        } catch (Exception unused) {
        }
        return rect;
    }
}
