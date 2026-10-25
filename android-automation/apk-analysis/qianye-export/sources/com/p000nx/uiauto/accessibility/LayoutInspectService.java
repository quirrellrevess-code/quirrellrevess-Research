package com.p000nx.uiauto.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;

/* JADX INFO: loaded from: classes.dex */
public class LayoutInspectService extends AccessibilityService {
    @Override // com.p000nx.uiauto.accessibility.AccessibilityService, android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        AccessibilityServiceInfo serviceInfo = getServiceInfo();
        serviceInfo.flags |= 2;
        setServiceInfo(serviceInfo);
        super.onServiceConnected();
    }
}
