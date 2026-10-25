package I1I.I1I.ILil;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: compiled from: AccessibilityActionProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends llliI.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public I1I.p062Ilil.p064Ilil.ILil.I1I f3111I1I;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Handler f937IL;

    public ILil(Context context) {
        this.f3111I1I = null;
        this.f937IL = null;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f937IL = handler;
        this.f3111I1I = new I1I.p062Ilil.p064Ilil.ILil.I1I(handler);
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean click(int i, int i2, int i3) throws RemoteException {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f3111I1I.Lil(i, i2, i3);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean dispatchGesture(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f3111I1I.I1I(str);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean keyPress(int i) throws RemoteException {
        if (i == 3) {
            return this.f3111I1I.m1315IiL();
        }
        if (i == 4) {
            return this.f3111I1I.ILil();
        }
        if (i == 187) {
            return this.f3111I1I.m1321llL1ii();
        }
        if (i == 26) {
            return this.f3111I1I.m1319lIiI();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean longClick(int i, int i2) throws RemoteException {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f3111I1I.m1317L11I(i, i2);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean swipe(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f3111I1I.iIlLiL(i, i2, i3, i4, i5);
        }
        return false;
    }
}
