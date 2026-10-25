package I1I.p062Ilil.p064Ilil.ILil.p011il;

import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.丨il.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: DFS.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {
    public boolean IL1Iii(lLi1LL lli1ll, Queue<ILL> queue) {
        Iterator<ILL> it = queue.iterator();
        while (it.hasNext()) {
            if (!it.next().IL1Iii(lli1ll)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<lLi1LL> ILil(lLi1LL lli1ll, Queue<ILL> queue, int i) {
        ArrayList<lLi1LL> arrayList = new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        linkedList.push(lli1ll);
        while (!linkedList.isEmpty()) {
            lLi1LL lli1ll2 = (lLi1LL) linkedList.pop();
            for (int iM1381IiL = lli1ll2.m1381IiL() - 1; iM1381IiL >= 0; iM1381IiL--) {
                lLi1LL lli1llM1394iILLL1 = lli1ll2.m1394iILLL1(iM1381IiL);
                if (lli1llM1394iILLL1 != null) {
                    linkedList.push(lli1llM1394iILLL1);
                }
            }
            if (IL1Iii(lli1ll2, queue)) {
                arrayList.add(lli1ll2);
                if (arrayList.size() >= i) {
                    break;
                }
            } else if (lli1ll2 != lli1ll) {
                lli1ll2.m1384LIl();
            }
        }
        return arrayList;
    }
}
