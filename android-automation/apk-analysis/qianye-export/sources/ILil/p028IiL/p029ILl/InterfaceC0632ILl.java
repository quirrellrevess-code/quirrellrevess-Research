package ILil.p028IiL.p029ILl;

import android.view.View;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: NestedScrollingParent.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0632ILl {
    boolean onNestedFling(View view, float f, float f2, boolean z);

    boolean onNestedPreFling(View view, float f, float f2);

    void onNestedPreScroll(View view, int i, int i2, int[] iArr);

    void onNestedScroll(View view, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(View view, View view2, int i);

    boolean onStartNestedScroll(View view, View view2, int i);

    void onStopNestedScroll(View view);
}
