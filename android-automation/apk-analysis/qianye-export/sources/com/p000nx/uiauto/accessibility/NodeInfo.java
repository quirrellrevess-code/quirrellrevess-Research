package com.p000nx.uiauto.accessibility;

import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Keep;
import com.google.android.flexbox.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class NodeInfo {
    public boolean accessibilityFocused;
    public String bounds;
    public boolean checkable;
    public boolean checked;
    public String className;
    public boolean clickable;
    public int column;
    public int columnCount;
    public int columnSpan;
    public boolean contextClickable;
    public int depth;
    public String desc;
    public boolean dismissable;
    public int drawingOrder;
    public boolean editable;
    public boolean enabled;
    public boolean focusable;
    public boolean focused;

    /* JADX INFO: renamed from: id */
    public String f97id;
    public int indexInParent;
    public boolean longClickable;
    public String packageName;
    public NodeInfo parent;
    public int row;
    public int rowCount;
    public int rowSpan;
    public boolean scrollable;
    public boolean selected;
    public String text;
    public boolean visibleToUser;
    private List<NodeInfo> children = new ArrayList();
    private Rect mBoundsInScreen = new Rect();
    private Rect mBoundsInParent = new Rect();

    public NodeInfo(lLi1LL lli1ll, NodeInfo nodeInfo) {
        this.f97id = simplifyId(lli1ll.m1385LIll());
        this.desc = lli1ll.m14141();
        this.className = lli1ll.m1411il();
        this.packageName = lli1ll.m1392iI1iI();
        this.text = lli1ll.Liil1L1l();
        this.depth = lli1ll.m1412l();
        this.drawingOrder = lli1ll.m1402lIII();
        this.row = lli1ll.m42iI();
        this.column = lli1ll.LlLI1();
        this.rowCount = lli1ll.m1387LlLiLL();
        this.columnCount = lli1ll.m1404llL1ii();
        this.rowSpan = lli1ll.m39I();
        this.columnSpan = lli1ll.m1403lIlii();
        this.accessibilityFocused = lli1ll.m1415();
        this.checked = lli1ll.m1405lLi1LL();
        this.checkable = lli1ll.Ilil();
        this.clickable = lli1ll.m1378ILl();
        this.contextClickable = lli1ll.m1382L11();
        this.dismissable = lli1ll.m1386LlIl();
        this.enabled = lli1ll.LL1IL();
        this.editable = lli1ll.m1376IIiI();
        this.focusable = lli1ll.m44();
        this.focused = lli1ll.llI();
        this.longClickable = lli1ll.LLL();
        this.selected = lli1ll.m1400lIIiIlL();
        this.scrollable = lli1ll.I1IILIIL();
        this.visibleToUser = lli1ll.m40LL();
        lli1ll.m1389L1l(this.mBoundsInScreen);
        lli1ll.m1399l1IIi1(this.mBoundsInParent);
        this.bounds = boundsToString(this.mBoundsInScreen);
        this.indexInParent = lli1ll.m1398ill();
        this.parent = nodeInfo;
    }

    public static String boundsToString(Rect rect) {
        return rect.toString().replace('-', ',').replace(" ", BuildConfig.FLAVOR).substring(4);
    }

    public static NodeInfo capture(lLi1LL lli1ll, NodeInfo nodeInfo) {
        NodeInfo nodeInfo2 = new NodeInfo(lli1ll, nodeInfo);
        int iM1381IiL = lli1ll.m1381IiL();
        for (int i = 0; i < iM1381IiL; i++) {
            lLi1LL lli1llM1394iILLL1 = lli1ll.m1394iILLL1(i);
            if (lli1llM1394iILLL1 != null) {
                nodeInfo2.children.add(capture(lli1llM1394iILLL1, nodeInfo2));
            }
        }
        return nodeInfo2;
    }

    private String simplifyId(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.indexOf(47) + 1);
    }

    public Rect getBoundsInParent() {
        return this.mBoundsInParent;
    }

    public Rect getBoundsInScreen() {
        return this.mBoundsInScreen;
    }

    public List<NodeInfo> getChildren() {
        return this.children;
    }

    public String toString() {
        return this.className + IL1Iii.IL1Iii(new byte[]{79, 82, 11, 8, 9, 80, 119, 94, 22, 15, 17, 9}, IL1Iii.IL1Iii(new byte[]{6, 8, 2, 88, 80, 5}, IL1Iii.IL1Iii(new byte[]{11, 15, 85, 1, 13, 6}, "964887"))) + this.children.size() + IL1Iii.IL1Iii(new byte[]{20, 66, 12, 117, 11, 22, 86, 6, 18, 126, 10, 48, 91, 16, 4, 82, 10, 94}, IL1Iii.IL1Iii(new byte[]{13, 80, 0, 83, 7, 87}, IL1Iii.IL1Iii(new byte[]{86, 11, 85, 93, 7, 81}, "c949de"))) + this.mBoundsInScreen + IL1Iii.IL1Iii(new byte[]{31, 66, 89, 112, 92, 22, 93, 6, 71, 123, 93, 51, 82, 16, 81, 92, 71, 94}, IL1Iii.IL1Iii(new byte[]{0, 81, 5, 5, 2, 1}, IL1Iii.IL1Iii(new byte[]{6, 5, 80, 7, 2, 87}, "56a035"))) + this.mBoundsInParent + IL1Iii.IL1Iii(new byte[]{72, 20, 12, 86, 5, 23}, IL1Iii.IL1Iii(new byte[]{5, 6, 83, 10, 15, 2}, IL1Iii.IL1Iii(new byte[]{84, 7, 3, 13, 1, 11}, "555569"))) + this.f97id + '\'' + IL1Iii.IL1Iii(new byte[]{78, 70, 93, 85, 67, 84, 95, 65}, IL1Iii.IL1Iii(new byte[]{6, 5, 15, 8, 85, 85}, IL1Iii.IL1Iii(new byte[]{0, 82, 1, 10, 0, 85}, "d172e7"))) + this.desc + '\'' + IL1Iii.IL1Iii(new byte[]{73, 23, 64, 88, 81, 91, 4, 80, 85, 119, 83, 93, 0, 10, 23}, IL1Iii.IL1Iii(new byte[]{86, 0, 85, 12, 83, 5}, IL1Iii.IL1Iii(new byte[]{10, 1, 80, 87, 83, 3}, "965b26"))) + this.packageName + '\'' + IL1Iii.IL1Iii(new byte[]{30, 19, 18, 86, 29, 69, 15, 20}, IL1Iii.IL1Iii(new byte[]{3, 85, 81, 82, 93, 7}, IL1Iii.IL1Iii(new byte[]{83, 7, 0, 5, 89, 15}, "ba7da9"))) + this.text + '\'' + IL1Iii.IL1Iii(new byte[]{26, 67, 84, 82, 66, 65, 94, 94}, IL1Iii.IL1Iii(new byte[]{2, 80, 84, 85, 3, 0}, IL1Iii.IL1Iii(new byte[]{1, 6, 6, 81, 0, 86}, "55b31c"))) + this.depth + IL1Iii.IL1Iii(new byte[]{25, 16, 80, 70, 85, 21, 92, 94, 83, 123, 70, 6, 80, 66, 9}, IL1Iii.IL1Iii(new byte[]{87, 1, 4, 1, 7, 90}, IL1Iii.IL1Iii(new byte[]{84, 80, 0, 83, 80, 9}, "6a0fc1"))) + this.drawingOrder + IL1Iii.IL1Iii(new byte[]{26, 65, 4, 84, 91, 85, 69, 18, 12, 85, 81, 92, 95, 21, 28, 113, 87, 83, 67, 18, 0, 83, 5}, IL1Iii.IL1Iii(new byte[]{2, 2, 4, 83, 12, 84}, IL1Iii.IL1Iii(new byte[]{13, 83, 86, 81, 12, 5}, "90758a"))) + this.accessibilityFocused + IL1Iii.IL1Iii(new byte[]{27, 25, 0, 90, 7, 81, 92, 92, 7, 15}, IL1Iii.IL1Iii(new byte[]{15, 14, 0, 2, 80, 2}, IL1Iii.IL1Iii(new byte[]{89, 1, 91, 9, 10, 7}, "a68987"))) + this.checked + IL1Iii.IL1Iii(new byte[]{25, 23, 1, 93, 89, 85, 94, 86, 0, 93, 85, 11}, IL1Iii.IL1Iii(new byte[]{83, 2, 1, 6, 82, 15}, IL1Iii.IL1Iii(new byte[]{0, 0, 80, 4, 91, 11}, "f53392"))) + this.clickable + IL1Iii.IL1Iii(new byte[]{25, 16, 84, 92, 93, 22, 80, 72, 67, 112, 95, 11, 86, 91, 86, 81, 95, 7, 8}, IL1Iii.IL1Iii(new byte[]{0, 84, 1, 82, 87, 87}, IL1Iii.IL1Iii(new byte[]{84, 2, 2, 85, 85, 0}, "af4415"))) + this.contextClickable + IL1Iii.IL1Iii(new byte[]{29, 66, 84, 10, 67, 8, 88, 17, 67, 2, 82, 9, 84, 95}, IL1Iii.IL1Iii(new byte[]{0, 4, 4, 84, 6, 80}, IL1Iii.IL1Iii(new byte[]{6, 5, 80, 4, 5, 3}, "7cd336"))) + this.dismissable + IL1Iii.IL1Iii(new byte[]{21, 24, 86, 80, 91, 65, 88, 90, 95, 81, 15}, IL1Iii.IL1Iii(new byte[]{9, 10, 86, 1, 84, 84}, IL1Iii.IL1Iii(new byte[]{3, 0, 92, 6, 5, 5}, "3293cd"))) + this.editable + IL1Iii.IL1Iii(new byte[]{73, 68, 0, 89, 4, 85, 9, 1, 1, 10}, IL1Iii.IL1Iii(new byte[]{87, 5, 81, 84, 80, 1}, IL1Iii.IL1Iii(new byte[]{87, 86, 0, 85, 2, 83}, "e7467e"))) + this.enabled + IL1Iii.IL1Iii(new byte[]{26, 22, 7, 14, 86, 69, 69, 87, 3, 13, 80, 13}, IL1Iii.IL1Iii(new byte[]{85, 2, 81, 2, 80, 1}, IL1Iii.IL1Iii(new byte[]{83, 5, 0, 84, 7, 84}, "0107be"))) + this.focusable + IL1Iii.IL1Iii(new byte[]{73, 23, 95, 13, 91, 94, 38, 91, 90, 1, 94, 88, 7, 91, 86, 95}, IL1Iii.IL1Iii(new byte[]{84, 1, 6, 3, 0, 12}, IL1Iii.IL1Iii(new byte[]{5, 0, 7, 89, 84, 6}, "4628a3"))) + this.longClickable + IL1Iii.IL1Iii(new byte[]{31, 68, 70, 10, 66, 89}, IL1Iii.IL1Iii(new byte[]{0, 83, 85, 1, 5, 92}, IL1Iii.IL1Iii(new byte[]{87, 83, 2, 83, 2, 0}, "ddc728"))) + this.row + IL1Iii.IL1Iii(new byte[]{20, 19, 5, 86, 84, 65, 85, 93, 91}, IL1Iii.IL1Iii(new byte[]{12, 6, 87, 9, 9, 13}, IL1Iii.IL1Iii(new byte[]{87, 3, 87, 4, 80, 10}, "c6f4a3"))) + this.column + IL1Iii.IL1Iii(new byte[]{77, 22, 65, 87, 17, 38, 14, 67, 93, 76, 91}, IL1Iii.IL1Iii(new byte[]{3, 15, 5, 93, 84, 4}, IL1Iii.IL1Iii(new byte[]{85, 1, 82, 93, 4, 85}, "78d864"))) + this.rowCount + IL1Iii.IL1Iii(new byte[]{79, 68, 87, 10, 14, 71, 14, 10, 119, 10, 23, 92, 23, 89}, IL1Iii.IL1Iii(new byte[]{86, 84, 80, 93, 1, 80}, IL1Iii.IL1Iii(new byte[]{2, 85, 6, 94, 7, 6}, "7ebfdd"))) + this.columnCount + IL1Iii.IL1Iii(new byte[]{30, 16, 69, 12, 78, 99, 66, 81, 89, 94}, IL1Iii.IL1Iii(new byte[]{10, 8, 81, 85, 13, 3}, IL1Iii.IL1Iii(new byte[]{91, 11, 87, 1, 87, 6}, "c317c5"))) + this.rowSpan + IL1Iii.IL1Iii(new byte[]{72, 68, 83, 12, 10, 66, 9, 10, 99, 19, 7, 89, 89}, IL1Iii.IL1Iii(new byte[]{6, 83, 84, 5, 82, 82}, IL1Iii.IL1Iii(new byte[]{6, 85, 92, 0, 80, 86}, "db8fd3"))) + this.columnSpan + IL1Iii.IL1Iii(new byte[]{28, 17, 21, 0, 85, 92, 83, 69, 3, 1, 4}, IL1Iii.IL1Iii(new byte[]{4, 1, 94, 3, 95, 14}, IL1Iii.IL1Iii(new byte[]{80, 0, 0, 85, 3, 6}, "d083e1"))) + this.selected + IL1Iii.IL1Iii(new byte[]{21, 65, 71, 90, 65, 87, 85, 13, 85, 91, 95, 93, 4}, IL1Iii.IL1Iii(new byte[]{0, 89, 80, 13, 11, 10}, IL1Iii.IL1Iii(new byte[]{1, 92, 93, 6, 11, 11}, "8d9239"))) + this.scrollable + IL1Iii.IL1Iii(new byte[]{25, 65, 91, 12, 66, 90, 81, 18, 4, 68}, IL1Iii.IL1Iii(new byte[]{81, 84, 95, 7, 82, 81}, IL1Iii.IL1Iii(new byte[]{83, 12, 85, 92, 82, 92}, "793879"))) + this.bounds + '\'' + IL1Iii.IL1Iii(new byte[]{29, 22, 84, 93, 85, 84, 90, 87, 85, 89, 85, 10}, IL1Iii.IL1Iii(new byte[]{6, 15, 2, 0, 83, 85}, IL1Iii.IL1Iii(new byte[]{7, 11, 81, 1, 82, 85}, "02d417"))) + this.checkable + IL1Iii.IL1Iii(new byte[]{31, 66, 83, 10, 91, 23, 64, 7, 81, 88}, IL1Iii.IL1Iii(new byte[]{4, 0, 87, 86, 93, 84}, IL1Iii.IL1Iii(new byte[]{82, 85, 82, 3, 86, 5}, "e70033"))) + this.focused + IL1Iii.IL1Iii(new byte[]{30, 18, 68, 10, 18, 88, 80, 94, 87, 55, 14, 100, 65, 87, 64, 94}, IL1Iii.IL1Iii(new byte[]{5, 2, 5, 87, 89, 0}, IL1Iii.IL1Iii(new byte[]{1, 83, 85, 82, 94, 5}, "6cbff4"))) + this.visibleToUser + IL1Iii.IL1Iii(new byte[]{73, 20, 73, 5, 19, 0, 11, 64, 4}, IL1Iii.IL1Iii(new byte[]{80, 2, 91, 85, 89, 92}, IL1Iii.IL1Iii(new byte[]{84, 7, 85, 3, 93, 11}, "a172e2"))) + this.parent.className + '}';
    }

    public static NodeInfo capture(AccessibilityNodeInfo accessibilityNodeInfo) {
        return capture(lLi1LL.I11li1(accessibilityNodeInfo), null);
    }
}
