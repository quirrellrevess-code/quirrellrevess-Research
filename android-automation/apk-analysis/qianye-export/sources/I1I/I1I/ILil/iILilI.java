package I1I.I1I.ILil;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.UiAutomation;
import android.os.Build;
import android.os.Handler;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: I1I.I1I.ILil.iI丨Li丨lI, reason: invalid class name */
/* JADX INFO: compiled from: UiAutomationService.java */
/* JADX INFO: loaded from: classes.dex */
public class iILilI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f3241I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public UiAutomation f3242IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public iiIIi11 f3243ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3244Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public AccessibilityServiceInfo f1027IL;

    /* JADX INFO: renamed from: I1I.I1I.ILil.iI丨Li丨lI$ILil */
    /* JADX INFO: compiled from: UiAutomationService.java */
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final iILilI f3245IL1Iii = new iILilI();
    }

    public static iILilI I1I() {
        return ILil.f3245IL1Iii;
    }

    public boolean IL1Iii() {
        if (this.f3241I1I) {
            return true;
        }
        try {
            boolean zIlil = Ilil();
            this.f3241I1I = zIlil;
            return zIlil;
        } catch (Exception unused) {
            ILil();
            return false;
        }
    }

    public boolean ILil() {
        try {
            if (this.f3242IL1Iii != null) {
                this.f3243ILil.ILil();
                this.f3242IL1Iii = null;
            }
        } catch (Exception unused) {
        }
        this.f3241I1I = false;
        return true;
    }

    public final boolean Ilil() throws Exception {
        if (this.f3242IL1Iii != null) {
            return false;
        }
        iiIIi11 iiiii11 = new iiIIi11();
        this.f3243ILil = iiiii11;
        try {
            if (!iiiii11.IL1Iii()) {
                return false;
            }
            UiAutomation uiAutomationI1I = this.f3243ILil.I1I();
            this.f3242IL1Iii = uiAutomationI1I;
            if (uiAutomationI1I == null) {
                return false;
            }
            AccessibilityServiceInfo serviceInfo = uiAutomationI1I.getServiceInfo();
            this.f1027IL = serviceInfo;
            serviceInfo.eventTypes |= -1;
            serviceInfo.notificationTimeout = 100L;
            serviceInfo.flags |= 122;
            this.f3242IL1Iii.setServiceInfo(serviceInfo);
            int i = this.f3244Ilil;
            if (i == -1) {
                return true;
            }
            m1012iILLL1(i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public AccessibilityNodeInfo m1010IL() {
        UiAutomation uiAutomation = this.f3242IL1Iii;
        if (uiAutomation != null) {
            return null;
        }
        return uiAutomation.getRootInActiveWindow();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public List<AccessibilityNodeInfo> m1011IiL() {
        if (this.f3242IL1Iii == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            Iterator<AccessibilityWindowInfo> it = this.f3242IL1Iii.getWindows().iterator();
            while (it.hasNext()) {
                AccessibilityNodeInfo root = it.next().getRoot();
                if (root != null) {
                    arrayList.add(root);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(this.f3242IL1Iii.getRootInActiveWindow());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m1012iILLL1(int i) {
        try {
            UiAutomation uiAutomation = this.f3242IL1Iii;
            if (uiAutomation != null) {
                if ((uiAutomation.getServiceInfo().flags & 2) == 2) {
                    if (i == 1) {
                        AccessibilityServiceInfo serviceInfo = this.f3242IL1Iii.getServiceInfo();
                        serviceInfo.flags &= -3;
                        this.f3242IL1Iii.setServiceInfo(serviceInfo);
                        return 1;
                    }
                } else if (i == 0) {
                    AccessibilityServiceInfo serviceInfo2 = this.f3242IL1Iii.getServiceInfo();
                    serviceInfo2.flags |= 2;
                    this.f3242IL1Iii.setServiceInfo(serviceInfo2);
                    return 1;
                }
                this.f3242IL1Iii.setServiceInfo(this.f3242IL1Iii.getServiceInfo());
            } else {
                this.f3244Ilil = i;
            }
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m1013lLi1LL() {
        return this.f3241I1I;
    }

    public iILilI() {
        this.f3241I1I = false;
        this.f1027IL = null;
        this.f3244Ilil = -1;
        new Handler();
    }
}
