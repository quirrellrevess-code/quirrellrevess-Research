package p051lLi1LL.ILil.IL1Iii;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PendingPost.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILL {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final List<ILL> f3047IL = new ArrayList();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ILL f5551I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Object f5552IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public lIlii f5553ILil;

    public ILL(Object obj, lIlii lilii) {
        this.f5552IL1Iii = obj;
        this.f5553ILil = lilii;
    }

    public static ILL IL1Iii(lIlii lilii, Object obj) {
        List<ILL> list = f3047IL;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new ILL(obj, lilii);
            }
            ILL illRemove = list.remove(size - 1);
            illRemove.f5552IL1Iii = obj;
            illRemove.f5553ILil = lilii;
            illRemove.f5551I1I = null;
            return illRemove;
        }
    }

    public static void ILil(ILL ill) {
        ill.f5552IL1Iii = null;
        ill.f5553ILil = null;
        ill.f5551I1I = null;
        List<ILL> list = f3047IL;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(ill);
            }
        }
    }
}
