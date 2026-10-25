package ILil.Lil.p037IL;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: ILil.Lil.I丨L.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0639ILl {
    public static int I1I(RecyclerView.C1 c1, ILL ill, View view, View view2, RecyclerView.LlLI1 llLI1, boolean z) {
        if (llLI1.getChildCount() == 0 || c1.ILil() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c1.ILil();
        }
        return (int) (((ill.mo2354IL(view2) - ill.mo2358iILLL1(view)) / (Math.abs(llLI1.getPosition(view) - llLI1.getPosition(view2)) + 1)) * c1.ILil());
    }

    public static int IL1Iii(RecyclerView.C1 c1, ILL ill, View view, View view2, RecyclerView.LlLI1 llLI1, boolean z) {
        if (llLI1.getChildCount() == 0 || c1.ILil() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(llLI1.getPosition(view) - llLI1.getPosition(view2)) + 1;
        }
        return Math.min(ill.mo2353ILl(), ill.mo2354IL(view2) - ill.mo2358iILLL1(view));
    }

    public static int ILil(RecyclerView.C1 c1, ILL ill, View view, View view2, RecyclerView.LlLI1 llLI1, boolean z, boolean z2) {
        if (llLI1.getChildCount() == 0 || c1.ILil() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (c1.ILil() - Math.max(llLI1.getPosition(view), llLI1.getPosition(view2))) - 1) : Math.max(0, Math.min(llLI1.getPosition(view), llLI1.getPosition(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(ill.mo2354IL(view2) - ill.mo2358iILLL1(view)) / (Math.abs(llLI1.getPosition(view) - llLI1.getPosition(view2)) + 1))) + (ill.mo2359lIiI() - ill.mo2358iILLL1(view)));
        }
        return iMax;
    }
}
