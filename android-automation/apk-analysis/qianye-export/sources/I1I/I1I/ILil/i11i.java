package I1I.I1I.ILil;

import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨i1丨1i, reason: invalid class name */
/* JADX INFO: compiled from: UiObjectProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class i11i extends L111.IL1Iii {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final i11i f1047lLi1LL = new i11i();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Object f3301I1I = new Object();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Map<Long, lLi1LL> f1048IL = new ConcurrentHashMap();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public long f3302Ilil = 0;

    public static i11i ILL() {
        return f1047lLi1LL;
    }

    public void Ilil() {
        synchronized (this.f3301I1I) {
            Iterator<Map.Entry<Long, lLi1LL>> it = this.f1048IL.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().m1384LIl();
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public long m1044Ll1(lLi1LL lli1ll) {
        long jLongValue;
        if (lli1ll == null) {
            return 0L;
        }
        synchronized (this.f3301I1I) {
            Long lValueOf = Long.valueOf(this.f3302Ilil + 1);
            if (lValueOf.longValue() == RecyclerView.FOREVER_NS) {
                lValueOf = 1L;
            }
            this.f1048IL.put(lValueOf, lli1ll);
            this.f3302Ilil = lValueOf.longValue();
            jLongValue = lValueOf.longValue();
        }
        return jLongValue;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean accessibilityFocus(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.IL1Iii();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public Rect bounds(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.I1I();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public Rect boundsInParent(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1380IL();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public int childCount(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1381IiL();
        }
        return 0;
    }

    @Override // I1I.I1I.ILil.L111
    public long[] childs(long j) {
        lLi1LL[] lli1llArrM1372iILLL1;
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll == null || (lli1llArrM1372iILLL1 = lli1ll.m1390L11I().m1372iILLL1()) == null || lli1llArrM1372iILLL1.length <= 0) {
            return null;
        }
        long[] jArr = new long[lli1llArrM1372iILLL1.length];
        for (int i = 0; i < lli1llArrM1372iILLL1.length; i++) {
            jArr[i] = m1044Ll1(lli1llArrM1372iILLL1[i]);
        }
        return jArr;
    }

    @Override // I1I.I1I.ILil.L111
    public String className(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1411il();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean clearAccessibilityFocus(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.ILL();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean clearFocus(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1388Ll1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean click(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1401lIiI();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean collapse(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.Lil();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean contextClick(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.iIi1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean copy(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.iIlLiL();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean cut(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.llliI();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public int depth(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1412l();
        }
        return 0;
    }

    @Override // I1I.I1I.ILil.L111
    public String desc(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m14141();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean dismiss(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1391LlLLL();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public int drawingOrder(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1402lIII();
        }
        return 0;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean expand(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1383L111();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean focus(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1413LLlI1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    /* JADX INFO: renamed from: gc */
    public boolean mo0gc(long j) throws RemoteException {
        synchronized (this.f3301I1I) {
            lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
            if (lli1ll != null) {
                this.f1048IL.remove(Long.valueOf(j));
                lli1ll.m1384LIl();
            }
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public String getText(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1379IIi().toString();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    /* JADX INFO: renamed from: id */
    public String mo1id(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1385LIll();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public int index(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1398ill();
        }
        return 0;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean longClick(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1406lliiI1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public String packageName(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1392iI1iI();
        }
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public long parent(long j) {
        lLi1LL lli1llM1375I1L11L;
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll == null || (lli1llM1375I1L11L = lli1ll.m1375I1L11L()) == null) {
            return 0L;
        }
        return m1044Ll1(lli1llM1375I1L11L);
    }

    @Override // I1I.I1I.ILil.L111
    public boolean paste(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1407li11();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean performAction(long j, int i) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.iIilII1(i);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean performActionEx(long j, int i, Bundle bundle) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m41i1(i, bundle);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollBackward(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1396iiIIi11();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollDown(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1395iILilI();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollForward(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m38I1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollLeft(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1408i11i();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollRight(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.L1iI1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollTo(long j, int i, int i2) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m43lL(i, i2);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollUp(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.l1Lll();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean select(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.ill1LI1l();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean setProgress(long j, float f) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1409i11LL(f);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean setSelection(long j, int i, int i2) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.m1393iIl1il(i, i2);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean setText(long j, String str) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.LI11(str);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean show(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.LiL1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public String text(long j) throws RemoteException {
        lLi1LL lli1ll = this.f1048IL.get(Long.valueOf(j));
        if (lli1ll != null) {
            return lli1ll.Liil1L1l();
        }
        return null;
    }
}
