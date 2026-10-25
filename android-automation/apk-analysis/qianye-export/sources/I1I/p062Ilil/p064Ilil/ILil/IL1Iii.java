package I1I.p062Ilil.p064Ilil.ILil;

import I1I.I1I.p008IL.lIlii;
import I1I.p062Ilil.p064Ilil.IL1Iii.I1I;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: AccessibilityBridge.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f3533IL1Iii = false;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3534ILil = 0;

    public AccessibilityNodeInfo I1I() {
        AccessibilityService accessibilityServiceMo856IL = mo856IL();
        if (accessibilityServiceMo856IL == null) {
            return null;
        }
        return (this.f3534ILil == 1 && (accessibilityServiceMo856IL instanceof com.p000nx.uiauto.accessibility.AccessibilityService)) ? ((com.p000nx.uiauto.accessibility.AccessibilityService) accessibilityServiceMo856IL).ILil() : accessibilityServiceMo856IL.getRootInActiveWindow();
    }

    public abstract void IL1Iii();

    public abstract I1I ILil();

    public boolean Ilil() {
        return this.f3533IL1Iii;
    }

    /* JADX INFO: renamed from: I丨L */
    public abstract AccessibilityService mo856IL();

    /* JADX INFO: renamed from: iI丨LLL1 */
    public List<AccessibilityNodeInfo> mo858iILLL1() {
        AccessibilityService accessibilityServiceMo856IL = mo856IL();
        if (accessibilityServiceMo856IL == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            Iterator<AccessibilityWindowInfo> it = accessibilityServiceMo856IL.getWindows().iterator();
            while (it.hasNext()) {
                AccessibilityNodeInfo root = it.next().getRoot();
                if (root != null) {
                    arrayList.add(root);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(I1I());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: l丨Li1LL */
    public int mo859lLi1LL(int i) {
        if (i < 0) {
            return 0;
        }
        try {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 107}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 3, 84, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 3, 85, 90, 3}, "612495"))), I1I.IL1Iii.IL1Iii(new byte[]{69, 1, 70, 127, 88, 0, 83, 41, 93, 85, 82, 89, 11, 90}, I1I.IL1Iii.IL1Iii(new byte[]{14, 86, 86, 84, 2, 6}, I1I.IL1Iii.IL1Iii(new byte[]{89, 86, 93, 80, 3, 3}, "ad956a"))) + i);
            int i2 = ((-65536) & i) >> 16;
            if (i2 == 1) {
                this.f3533IL1Iii = true;
            } else {
                this.f3533IL1Iii = false;
            }
            int i3 = i & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{120, 60}, I1I.IL1Iii.IL1Iii(new byte[]{5, 92, 5, 14, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{85, 92, 5, 0, 86, 2}, "fdd6c1"))), I1I.IL1Iii.IL1Iii(new byte[]{75, 7, 65, 47, 93, 92, 93, 47, 90, 5, 87, 9, 5, 95, 11}, I1I.IL1Iii.IL1Iii(new byte[]{15, 81, 83, 0, 2, 91}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 85, 83, 8, 83}, "303280"))) + i3 + I1I.IL1Iii.IL1Iii(new byte[]{73}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 6, 6, 0, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 6, 12, 92, 87}, "ddc89b"))) + i2);
            AccessibilityService accessibilityServiceM1145LlLLL = lIlii.m1145LlLLL();
            if (accessibilityServiceM1145LlLLL != null) {
                if ((accessibilityServiceM1145LlLLL.getServiceInfo().flags & 2) == 2) {
                    if (i3 == 1) {
                        AccessibilityServiceInfo serviceInfo = accessibilityServiceM1145LlLLL.getServiceInfo();
                        serviceInfo.flags &= -3;
                        accessibilityServiceM1145LlLLL.setServiceInfo(serviceInfo);
                        return 1;
                    }
                } else if (i3 == 0) {
                    AccessibilityServiceInfo serviceInfo2 = accessibilityServiceM1145LlLLL.getServiceInfo();
                    serviceInfo2.flags = 2 | serviceInfo2.flags;
                    accessibilityServiceM1145LlLLL.setServiceInfo(serviceInfo2);
                    return 1;
                }
                accessibilityServiceM1145LlLLL.setServiceInfo(accessibilityServiceM1145LlLLL.getServiceInfo());
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
