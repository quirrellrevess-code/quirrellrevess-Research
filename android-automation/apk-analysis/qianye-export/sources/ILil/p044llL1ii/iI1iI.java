package ILil.p044llL1ii;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: renamed from: ILil.ll丨L1ii.iI1i丨I, reason: invalid class name */
/* JADX INFO: compiled from: WindowIdApi18.java */
/* JADX INFO: loaded from: classes.dex */
public class iI1iI implements I1L11L {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final WindowId f4434IL1Iii;

    public iI1iI(View view) {
        this.f4434IL1Iii = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof iI1iI) && ((iI1iI) obj).f4434IL1Iii.equals(this.f4434IL1Iii);
    }

    public int hashCode() {
        return this.f4434IL1Iii.hashCode();
    }
}
