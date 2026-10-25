package com.p000nx.uiauto.accessibility;

import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.LlLI1;
import I1I.I1I.ILil.lliiI1;
import I1I.IL1Iii;
import I1I.p062Ilil.p064Ilil.IL1Iii.ILil;
import I1I.p062Ilil.p064Ilil.IL1Iii.IiL;
import I1I.p062Ilil.p064Ilil.IL1Iii.InterfaceC0614il;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.flexbox.BuildConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p051lLi1LL.ILil.IL1Iii.I1I;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityService extends android.accessibilityservice.AccessibilityService {
    public static final InterfaceC0614il.IL1Iii ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static IiL f2960ILl;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final ReentrantLock f2961IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static boolean f2962Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final Condition f2963L11I;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static final Set<Integer> f2965lIiI;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static AccessibilityService f2967il;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ExecutorService f5422I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public AccessibilityNodeInfo f5424Ilil;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f2966lLi1LL = IL1Iii.IL1Iii(new byte[]{126, 58, 35, 2, 84, 83, 67, 17, 11, 3, 94, 90, 89, 22, 27, 50, 82, 68, 70, 11, 1, 4}, IL1Iii.IL1Iii(new byte[]{7, 83, 85, 84, 7, 6}, IL1Iii.IL1Iii(new byte[]{15, 0, 82, 80, 5, 7}, "81ee57")));

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static final SortedMap<Integer, ILil> f2964iILLL1 = new TreeMap();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public InterfaceC0614il.IL1Iii f5423ILil = new InterfaceC0614il.IL1Iii();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f2968IL = null;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f2961IiL = reentrantLock;
        f2963L11I = reentrantLock.newCondition();
        ILL = new InterfaceC0614il.IL1Iii();
        f2962Ll1 = false;
        f2965lIiI = new HashSet();
        f2960ILl = null;
    }

    public static void IL1Iii(int i, ILil iLil) {
        f2964iILLL1.put(Integer.valueOf(i), iLil);
        Set<Integer> setI1I = iLil.I1I();
        if (setI1I == null) {
            f2962Ll1 = true;
        } else {
            f2965lIiI.addAll(setI1I);
        }
    }

    public static AccessibilityService Ilil() {
        return f2967il;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m3502IiL(IiL iiL) {
        f2960ILl = iiL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public /* synthetic */ void m3505iILLL1(KeyEvent keyEvent) {
        ILL.IL1Iii(keyEvent.getKeyCode(), keyEvent);
        this.f5423ILil.IL1Iii(keyEvent.getKeyCode(), keyEvent);
    }

    public final ActivityInfo I1I(ComponentName componentName) {
        try {
            return getPackageManager().getActivityInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public AccessibilityNodeInfo ILil() {
        return this.f5424Ilil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String m3504IL() {
        return this.f2968IL;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public AccessibilityNodeInfo getRootInActiveWindow() {
        try {
            return super.getRootInActiveWindow();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.v(f2966lLi1LL, IL1Iii.IL1Iii(new byte[]{10, 12, 117, 90, 83, 80, 22, 17, 93, 91, 89, 89, 12, 22, 77, 124, 70, 80, 11, 22, 14, 25}, IL1Iii.IL1Iii(new byte[]{84, 82, 82, 91, 2, 6}, IL1Iii.IL1Iii(new byte[]{87, 86, 3, 7, 10, 0}, "ffee83"))) + accessibilityEvent);
        if (f2962Ll1 || f2965lIiI.contains(Integer.valueOf(accessibilityEvent.getEventType()))) {
            accessibilityEvent.getEventType();
            Iterator<Map.Entry<Integer, ILil>> it = f2964iILLL1.entrySet().iterator();
            while (it.hasNext()) {
                ILil value = it.next().getValue();
                if (value.I1I() == null || value.I1I().contains(Integer.valueOf(accessibilityEvent.getEventType()))) {
                    if (value.IL1Iii(this, accessibilityEvent)) {
                        break;
                    }
                }
            }
            if (accessibilityEvent.getEventType() != 32 || accessibilityEvent.getPackageName() == null || accessibilityEvent.getClassName() == null) {
                return;
            }
            ComponentName componentName = new ComponentName(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString());
            if (I1I(componentName) != null) {
                this.f2968IL = componentName.flattenToShortString();
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        f2967il = null;
        ExecutorService executorService = this.f5422I1I;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        I1I.I1I().ILL(new IIi(103, IL1Iii.IL1Iii(new byte[]{3}, IL1Iii.IL1Iii(new byte[]{2, 87, 12, 6, 87, 14}, IL1Iii.IL1Iii(new byte[]{1, 93, 93, 84, 3, 10}, "09e0e3"))), IL1Iii.IL1Iii(new byte[]{4}, IL1Iii.IL1Iii(new byte[]{87, 8, 82, 10, 9, 84}, IL1Iii.IL1Iii(new byte[]{2, 90, 82, 12, 92, 3}, "acf4d6")))));
        IiL iiL = f2960ILl;
        if (iiL != null) {
            iiL.IL1Iii(null);
        }
        super.onDestroy();
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public boolean onKeyEvent(final KeyEvent keyEvent) {
        if (this.f5422I1I == null) {
            this.f5422I1I = Executors.newSingleThreadExecutor();
        }
        this.f5422I1I.execute(new Runnable() { // from class: I1I.Ilil.Ilil.IL1Iii.IL1Iii
            @Override // java.lang.Runnable
            public final void run() {
                this.f3516ILil.m3505iILLL1(keyEvent);
            }
        });
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 24) {
            if (!((lliiI1) LlLI1.m925IL().Ilil()).m1038lIlii()) {
                I1I.I1I().ILL(new IIi(105, IL1Iii.IL1Iii(new byte[]{4}, IL1Iii.IL1Iii(new byte[]{6, 93, 7, 14, 86, 3}, IL1Iii.IL1Iii(new byte[]{83, 15, 82, 14, 85, 80}, "a747f1"))), BuildConfig.FLAVOR));
            }
        } else if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 25 && !((lliiI1) LlLI1.m925IL().Ilil()).m1038lIlii()) {
            I1I.I1I().ILL(new IIi(105, IL1Iii.IL1Iii(new byte[]{3}, IL1Iii.IL1Iii(new byte[]{3, 7, 83, 11, 86, 85}, IL1Iii.IL1Iii(new byte[]{4, 1, 83, 0, 86, 80}, "501372"))), BuildConfig.FLAVOR));
        }
        return false;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        Log.v(f2966lLi1LL, IL1Iii.IL1Iii(new byte[]{90, 87, 48, 0, 64, 64, 92, 90, 6, 38, 93, 88, 91, 92, 0, 17, 87, 82, 15, 25}, IL1Iii.IL1Iii(new byte[]{87, 1, 91, 80, 3, 15}, IL1Iii.IL1Iii(new byte[]{83, 1, 93, 13, 9, 90}, "19e88c"))) + getServiceInfo().toString());
        f2967il = this;
        super.onServiceConnected();
        ReentrantLock reentrantLock = f2961IiL;
        reentrantLock.lock();
        f2963L11I.signalAll();
        reentrantLock.unlock();
        int i = getServiceInfo().flags;
        I1I.I1I().ILL(new IIi(103, IL1Iii.IL1Iii(new byte[]{80}, IL1Iii.IL1Iii(new byte[]{88, 15, 83, 84, 7, 86}, IL1Iii.IL1Iii(new byte[]{0, 1, 81, 86, 86, 3}, "987334"))), IL1Iii.IL1Iii(new byte[]{7}, IL1Iii.IL1Iii(new byte[]{6, 81, 4, 84, 1, 85}, IL1Iii.IL1Iii(new byte[]{3, 83, 5, 83, 81, 82}, "2d3b4f")))));
        IiL iiL = f2960ILl;
        if (iiL != null) {
            iiL.ILil(this);
        }
    }
}
