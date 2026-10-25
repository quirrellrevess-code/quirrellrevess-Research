package ILil.ILL.IL1Iii;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IiL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final lLi1LL f3636I1I = new lLi1LL();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public lLi1LL f3637ILil = null;

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: FragmentManager.java */
    public static abstract class IL1Iii {
        public abstract void I1I(IiL iiL, Fragment fragment, Bundle bundle);

        public abstract void IL1Iii(IiL iiL, Fragment fragment, Bundle bundle);

        public abstract void ILL(IiL iiL, Fragment fragment);

        public abstract void ILil(IiL iiL, Fragment fragment, Context context);

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public abstract void m1496ILl(IiL iiL, Fragment fragment);

        public abstract void Ilil(IiL iiL, Fragment fragment);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public abstract void m1497IL(IiL iiL, Fragment fragment);

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public abstract void m1498IiL(IiL iiL, Fragment fragment, Bundle bundle);

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public abstract void m1499Ll1(IiL iiL, Fragment fragment);

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public abstract void m1500L11I(IiL iiL, Fragment fragment);

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public abstract void m1501iILLL1(IiL iiL, Fragment fragment, Context context);

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public abstract void m1502lIiI(IiL iiL, Fragment fragment, View view, Bundle bundle);

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public abstract void m1503lLi1LL(IiL iiL, Fragment fragment);

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public abstract void m1504il(IiL iiL, Fragment fragment, Bundle bundle);
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.I丨iL$ILil */
    /* JADX INFO: compiled from: FragmentManager.java */
    public interface ILil {
        void IL1Iii();
    }

    public abstract boolean I1I();

    public abstract ILL IL1Iii();

    public abstract void ILil(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public lLi1LL Ilil() {
        if (this.f3637ILil == null) {
            this.f3637ILil = f3636I1I;
        }
        return this.f3637ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public abstract Fragment mo1491IL(String str);

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public abstract boolean mo1492IiL();

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1493L11I(lLi1LL lli1ll) {
        this.f3637ILil = lli1ll;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public abstract void mo1494iILLL1(int i, int i2);

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public abstract List<Fragment> mo1495lLi1LL();
}
