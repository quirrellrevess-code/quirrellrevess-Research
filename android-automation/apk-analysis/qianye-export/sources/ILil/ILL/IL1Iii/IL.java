package ILil.ILL.IL1Iii;

import ILil.p028IiL.p034lIiI.L11I;
import ILil.p042lIiI.iIi1;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: FragmentController.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final iILLL1<?> f3635IL1Iii;

    public IL(iILLL1<?> iilll1) {
        this.f3635IL1Iii = iilll1;
    }

    public static IL ILil(iILLL1<?> iilll1) {
        L11I.Ilil(iilll1, "callbacks == null");
        return new IL(iilll1);
    }

    public View I11L(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3635IL1Iii.f1265lLi1LL.onCreateView(view, str, context, attributeSet);
    }

    public IiL I11li1() {
        return this.f3635IL1Iii.f1265lLi1LL;
    }

    public void I1I() {
        this.f3635IL1Iii.f1265lLi1LL.m1581l();
    }

    public void IL1Iii(Fragment fragment) {
        iILLL1<?> iilll1 = this.f3635IL1Iii;
        iilll1.f1265lLi1LL.LlLI1(iilll1, iilll1, fragment);
    }

    public boolean ILL(MenuItem menuItem) {
        return this.f3635IL1Iii.f1265lLi1LL.m1530ILLIi(menuItem);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m1478ILl(boolean z) {
        this.f3635IL1Iii.f1265lLi1LL.m1553ili11(z);
    }

    public boolean Ilil(MenuItem menuItem) {
        return this.f3635IL1Iii.f1265lLi1LL.m1545LlLLL(menuItem);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1479IL(Configuration configuration) {
        this.f3635IL1Iii.f1265lLi1LL.m15841(configuration);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1480IiL() {
        this.f3635IL1Iii.f1265lLi1LL.m1534L111();
    }

    public boolean Lil(Menu menu) {
        return this.f3635IL1Iii.f1265lLi1LL.m1536LIl(menu);
    }

    public void LlLI1() {
        this.f3635IL1Iii.f1265lLi1LL.m1541LlLiLL();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1481Ll1(Menu menu) {
        this.f3635IL1Iii.f1265lLi1LL.m1565li11(menu);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1482L11I() {
        this.f3635IL1Iii.f1265lLi1LL.m57();
    }

    public boolean iIi1() {
        return this.f3635IL1Iii.f1265lLi1LL.I1IILIIL();
    }

    public Fragment iIlLiL(String str) {
        return this.f3635IL1Iii.f1265lLi1LL.LiL1(str);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m1483iILLL1(Menu menu, MenuInflater menuInflater) {
        return this.f3635IL1Iii.f1265lLi1LL.LL1IL(menu, menuInflater);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1484lIiI() {
        this.f3635IL1Iii.f1265lLi1LL.m49i1();
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m1485lIlii() {
        this.f3635IL1Iii.f1265lLi1LL.m1550iILilI();
    }

    public void llliI(Parcelable parcelable) {
        iILLL1<?> iilll1 = this.f3635IL1Iii;
        if (!(iilll1 instanceof iIi1)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        iilll1.f1265lLi1LL.IL1(parcelable);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m1486llL1ii() {
        this.f3635IL1Iii.f1265lLi1LL.m46I();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1487lLi1LL() {
        this.f3635IL1Iii.f1265lLi1LL.m1561lIII();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1488il(boolean z) {
        this.f3635IL1Iii.f1265lLi1LL.llI(z);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1489lL() {
        this.f3635IL1Iii.f1265lLi1LL.L1ii1();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public Parcelable m1490l() {
        return this.f3635IL1Iii.f1265lLi1LL.LIiiILi();
    }
}
