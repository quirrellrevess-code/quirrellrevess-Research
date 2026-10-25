package I1I.I1I.ILil;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
import okhttp3.internal.http2.Settings;

/* JADX INFO: renamed from: I1I.I1I.ILil.IIi丨丨I, reason: invalid class name */
/* JADX INFO: compiled from: RemoteAccessibilityBridge.java */
/* JADX INFO: loaded from: classes.dex */
public class IIiI extends I1I.p062Ilil.p064Ilil.ILil.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public L1l.IL1Iii f3094I1I;

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    public AccessibilityNodeInfo I1I() {
        if (iILilI.I1I().m1013lLi1LL()) {
            return iILilI.I1I().m1010IL();
        }
        return null;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    public void IL1Iii() {
        L1l.IL1Iii iL1Iii = this.f3094I1I;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii();
        }
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    public I1I.p062Ilil.p064Ilil.IL1Iii.I1I ILil() {
        return null;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public AccessibilityService mo856IL() {
        return null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m857IiL(L1l.IL1Iii iL1Iii) {
        this.f3094I1I = iL1Iii;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public List<AccessibilityNodeInfo> mo858iILLL1() {
        if (iILilI.I1I().m1013lLi1LL()) {
            return iILilI.I1I().m1011IiL();
        }
        return null;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int mo859lLi1LL(int i) {
        if (i < 0) {
            return 0;
        }
        try {
            if ((((-65536) & i) >> 16) == 1) {
                this.f3533IL1Iii = true;
            } else {
                this.f3533IL1Iii = false;
            }
            int i2 = i & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            iILilI iililiI1I = iILilI.I1I();
            if (iililiI1I != null) {
                return iililiI1I.m1012iILLL1(i2);
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
