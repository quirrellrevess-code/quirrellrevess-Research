package I1I.p062Ilil.ILil;

import ILil.iIlLiL.IL1Iii.IL1Iii;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qyzs.smn2.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: I1I.Ilil.ILil.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: UiShowPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public List<LinearLayout> f3484I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public List<LinearLayout> f3485Ilil = new ArrayList();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public List<String> f1134IL;

    public IiL(List<LinearLayout> list, List<String> list2) {
        this.f3484I1I = list;
        this.f1134IL = list2;
    }

    public void I11L(View view, String str, String str2) {
        for (LinearLayout linearLayout : this.f3484I1I) {
            if (linearLayout.getTag().equals(str)) {
                ((LinearLayout) linearLayout.findViewWithTag(str2)).addView(view);
            }
        }
    }

    @Override // ILil.iIlLiL.IL1Iii.IL1Iii
    public boolean ILL(View view, Object obj) {
        return view == obj;
    }

    @Override // ILil.iIlLiL.IL1Iii.IL1Iii
    public void ILil(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f3484I1I.get(i));
    }

    @Override // ILil.iIlLiL.IL1Iii.IL1Iii
    public int Ilil() {
        return this.f3484I1I.size();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m1282LlLLL(String str, int i) {
        for (LinearLayout linearLayout : this.f3485Ilil) {
            String str2 = (String) linearLayout.getTag(R.id.tagGroupId);
            if (!TextUtils.isEmpty(str2) && str2.compareTo(str) == 0) {
                linearLayout.setVisibility(i);
            }
        }
    }

    @Override // ILil.iIlLiL.IL1Iii.IL1Iii
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public CharSequence mo1283iILLL1(int i) {
        return this.f1134IL.get(i);
    }

    public View llliI(String str) {
        Iterator<LinearLayout> it = this.f3484I1I.iterator();
        while (it.hasNext()) {
            View viewFindViewWithTag = it.next().findViewWithTag(str);
            if (viewFindViewWithTag != null) {
                return viewFindViewWithTag;
            }
        }
        return null;
    }

    @Override // ILil.iIlLiL.IL1Iii.IL1Iii
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Object mo1284il(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = this.f3484I1I.get(i);
        viewGroup.addView(linearLayout);
        llliI(I1I.IL1Iii.IL1Iii(new byte[]{80, 17, 87, 10, 40, 87, 3}, I1I.IL1Iii.IL1Iii(new byte[]{10, 86, 88, 80, 82, 81}, I1I.IL1Iii.IL1Iii(new byte[]{89, 80, 0, 5, 3, 91}, "aca109"))));
        return linearLayout;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1285lL(LinearLayout linearLayout, String str) {
        this.f3484I1I.add(linearLayout);
        this.f1134IL.add(str);
        m2482Ll1();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public View m1286l(int i) {
        if (this.f3484I1I.size() > 0) {
            return this.f3484I1I.get(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m12871(String str, String str2, int i, int i2, String str3) {
        for (LinearLayout linearLayout : this.f3484I1I) {
            if (linearLayout.getTag().equals(str2)) {
                LinearLayout linearLayoutLlLI1 = lLi1LL.Lil(linearLayout.getContext()).LlLI1(1, str, i, i2);
                if (!TextUtils.isEmpty(str3)) {
                    linearLayoutLlLI1.setTag(R.id.tagGroupId, str3);
                    this.f3485Ilil.add(linearLayoutLlLI1);
                }
                linearLayout.addView(linearLayoutLlLI1);
            }
        }
    }
}
