package com.p000nx.uiauto.accessibility;

import I1I.IL1Iii;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Notification;
import android.content.ComponentName;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class AssistService extends AccessibilityService {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public AccessibilityServiceInfo f5425ILil = null;

    public boolean IL1Iii(String str, String str2) {
        try {
            return getPackageManager().getActivityInfo(new ComponentName(str, str2), 0) != null;
        } catch (Exception unused) {
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.getEventType();
        try {
            if (accessibilityEvent.getEventType() == 32) {
                CharSequence className = accessibilityEvent.getClassName();
                CharSequence packageName = accessibilityEvent.getPackageName();
                if (!TextUtils.isEmpty(className) && !TextUtils.isEmpty(packageName) && IL1Iii(packageName.toString(), className.toString())) {
                    packageName.toString();
                    className.toString();
                }
            } else if (accessibilityEvent.getEventType() == 64) {
                if (!(accessibilityEvent.getParcelableData() instanceof Notification)) {
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        new Handler();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(IL1Iii.IL1Iii(new byte[]{126, 59}, IL1Iii.IL1Iii(new byte[]{84, 86, 83, 81, 2, 1}, IL1Iii.IL1Iii(new byte[]{0, 3, 1, 3, 81, 85}, "d6e4e6"))), IL1Iii.IL1Iii(new byte[]{91, 11, 118, 84, 23, 76, 70, 10, 75}, IL1Iii.IL1Iii(new byte[]{13, 81, 10, 2, 92, 90}, IL1Iii.IL1Iii(new byte[]{0, 1, 89, 1, 1, 85}, "95a297"))) + this);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Log.i(IL1Iii.IL1Iii(new byte[]{125, 111}, IL1Iii.IL1Iii(new byte[]{87, 3, 80, 2, 2, 84}, IL1Iii.IL1Iii(new byte[]{5, 80, 6, 6, 13, 84}, "ad2b8d"))), IL1Iii.IL1Iii(new byte[]{86, 87, 44, 8, 71, 84, 75, 75, 16, 22, 71}, IL1Iii.IL1Iii(new byte[]{95, 95, 80, 3, 4, 6}, IL1Iii.IL1Iii(new byte[]{80, 2, 12, 86, 82, 84}, "6d93ec"))) + this);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public boolean onKeyEvent(KeyEvent keyEvent) {
        keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24) {
            keyCode = 115;
        } else if (keyCode == 25) {
            keyCode = 114;
        }
        Log.i(IL1Iii.IL1Iii(new byte[]{125, 97}, IL1Iii.IL1Iii(new byte[]{2, 10, 91, 83, 0, 10}, IL1Iii.IL1Iii(new byte[]{8, 82, 1, 2, 86, 15}, "9acc46"))), IL1Iii.IL1Iii(new byte[]{91, 92, 121, 92, 31, 118, 66, 87, 92, 77, 92}, IL1Iii.IL1Iii(new byte[]{13, 7, 80, 13, 5, 85}, IL1Iii.IL1Iii(new byte[]{90, 81, 85, 7, 82, 95}, "cd7319"))) + keyCode);
        return super.onKeyEvent(keyEvent);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo serviceInfo = getServiceInfo();
        this.f5425ILil = serviceInfo;
        serviceInfo.notificationTimeout = 100L;
        serviceInfo.eventTypes = -1;
        serviceInfo.flags |= 122;
        setServiceInfo(serviceInfo);
        Log.i(IL1Iii.IL1Iii(new byte[]{47, 57}, IL1Iii.IL1Iii(new byte[]{81, 5, 82, 7, 84, 0}, IL1Iii.IL1Iii(new byte[]{3, 85, 90, 9, 8, 8}, "318980"))), IL1Iii.IL1Iii(new byte[]{83, 93, 92, 12, 85, 84, 68}, IL1Iii.IL1Iii(new byte[]{0, 87, 0, 80, 81, 6}, IL1Iii.IL1Iii(new byte[]{85, 82, 7, 87, 4, 87}, "e75eef"))) + this);
    }
}
