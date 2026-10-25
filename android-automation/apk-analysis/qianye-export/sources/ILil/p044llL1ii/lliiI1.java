package ILil.p044llL1ii;

import android.view.View;

/* JADX INFO: renamed from: ILil.ll丨L1ii.l丨liiI1, reason: invalid class name */
/* JADX INFO: compiled from: VisibilityPropagation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class lliiI1 extends llliI {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String[] f4461IL1Iii = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2575IL(C1 c1, int i) {
        int[] iArr;
        if (c1 == null || (iArr = (int[]) c1.f4476IL1Iii.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // ILil.p044llL1ii.llliI
    public void IL1Iii(C1 c1) {
        View view = c1.f4477ILil;
        Integer numValueOf = (Integer) c1.f4476IL1Iii.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        c1.f4476IL1Iii.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        c1.f4476IL1Iii.put("android:visibilityPropagation:center", iArr);
    }

    @Override // ILil.p044llL1ii.llliI
    public String[] ILil() {
        return f4461IL1Iii;
    }

    public int Ilil(C1 c1) {
        Integer num;
        if (c1 == null || (num = (Integer) c1.f4476IL1Iii.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m2576iILLL1(C1 c1) {
        return m2575IL(c1, 1);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m2577lLi1LL(C1 c1) {
        return m2575IL(c1, 0);
    }
}
