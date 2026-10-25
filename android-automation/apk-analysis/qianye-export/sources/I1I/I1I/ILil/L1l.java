package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import I1I.p062Ilil.p064Ilil.IL1Iii.iILLL1;
import android.accessibilityservice.AccessibilityService;
import android.content.Context;

/* JADX INFO: renamed from: I1I.I1I.ILil.L丨1l, reason: invalid class name */
/* JADX INFO: compiled from: LocalAccessibilityBridge.java */
/* JADX INFO: loaded from: classes.dex */
public class L1l extends I1I.p062Ilil.p064Ilil.ILil.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public I1I.p062Ilil.p064Ilil.IL1Iii.I1I f3170I1I;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IL1Iii f967IL;

    /* JADX INFO: renamed from: I1I.I1I.ILil.L丨1l$IL1Iii */
    /* JADX INFO: compiled from: LocalAccessibilityBridge.java */
    public interface IL1Iii {
        void IL1Iii();
    }

    public L1l(Context context) {
        this.f3170I1I = new I1I.p062Ilil.p064Ilil.IL1Iii.I1I(context.getPackageManager());
        new iILLL1(context);
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    public void IL1Iii() {
        IL1Iii iL1Iii = this.f967IL;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii();
        }
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    public I1I.p062Ilil.p064Ilil.IL1Iii.I1I ILil() {
        return this.f3170I1I;
    }

    @Override // I1I.p062Ilil.p064Ilil.ILil.IL1Iii
    /* JADX INFO: renamed from: I丨L */
    public AccessibilityService mo856IL() {
        return lIlii.m1145LlLLL();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m930IiL(IL1Iii iL1Iii) {
        this.f967IL = iL1Iii;
    }
}
