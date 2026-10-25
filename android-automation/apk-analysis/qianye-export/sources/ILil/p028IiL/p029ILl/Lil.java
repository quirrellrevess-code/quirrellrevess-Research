package ILil.p028IiL.p029ILl;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: NestedScrollingParentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4057IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4058ILil;

    public Lil(ViewGroup viewGroup) {
    }

    public void I1I(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f4058ILil = i;
        } else {
            this.f4057IL1Iii = i;
        }
    }

    public int IL1Iii() {
        return this.f4057IL1Iii | this.f4058ILil;
    }

    public void ILil(View view, View view2, int i) {
        I1I(view, view2, i, 0);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2091IL(View view, int i) {
        if (i == 1) {
            this.f4058ILil = 0;
        } else {
            this.f4057IL1Iii = 0;
        }
    }
}
