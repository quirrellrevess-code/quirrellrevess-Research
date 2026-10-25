package ILil.p028IiL.Lil;

import android.widget.ListView;

/* JADX INFO: renamed from: ILil.I丨iL.Lil.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: ListViewAutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends IL1Iii {
    public final ListView iIlLiL;

    public iILLL1(ListView listView) {
        super(listView);
        this.iIlLiL = listView;
    }

    @Override // ILil.p028IiL.Lil.IL1Iii
    public boolean IL1Iii(int i) {
        return false;
    }

    @Override // ILil.p028IiL.Lil.IL1Iii
    public boolean ILil(int i) {
        ListView listView = this.iIlLiL;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // ILil.p028IiL.Lil.IL1Iii
    /* JADX INFO: renamed from: 丨il */
    public void mo2209il(int i, int i2) {
        IiL.IL1Iii(this.iIlLiL, i2);
    }
}
