package ILil.p028IiL.p029ILl.LL1IL;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.LL1IL.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f4055IL1Iii;

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.LL1IL.I丨L$IL1Iii */
    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    public static class IL1Iii extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final IL f4056IL1Iii;

        public IL1Iii(IL il) {
            this.f4056IL1Iii = il;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            I1I i1iIL1Iii = this.f4056IL1Iii.IL1Iii(i);
            if (i1iIL1Iii == null) {
                return null;
            }
            return i1iIL1Iii.m20811iIl();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<I1I> listILil = this.f4056IL1Iii.ILil(str, i);
            if (listILil == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listILil.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listILil.get(i2).m20811iIl());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f4056IL1Iii.Ilil(i, i2, bundle);
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.LL1IL.I丨L$ILil */
    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    public static class ILil extends IL1Iii {
        public ILil(IL il) {
            super(il);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            I1I I1I2 = this.f4056IL1Iii.I1I(i);
            if (I1I2 == null) {
                return null;
            }
            return I1I2.m20811iIl();
        }
    }

    public IL() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            this.f4055IL1Iii = new ILil(this);
        } else if (i >= 16) {
            this.f4055IL1Iii = new IL1Iii(this);
        } else {
            this.f4055IL1Iii = null;
        }
    }

    public I1I I1I(int i) {
        return null;
    }

    public I1I IL1Iii(int i) {
        return null;
    }

    public List<I1I> ILil(String str, int i) {
        return null;
    }

    public boolean Ilil(int i, int i2, Bundle bundle) {
        return false;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object m2090IL() {
        return this.f4055IL1Iii;
    }

    public IL(Object obj) {
        this.f4055IL1Iii = obj;
    }
}
