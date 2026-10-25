package ILil.p028IiL.Lil;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: renamed from: ILil.I丨iL.Lil.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: ListViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class IiL {
    public static void IL1Iii(ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }
}
