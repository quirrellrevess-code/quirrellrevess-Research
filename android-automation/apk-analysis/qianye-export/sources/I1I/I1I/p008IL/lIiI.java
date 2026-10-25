package I1I.I1I.p008IL;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: I1I.I1I.I丨L.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: ObjectStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Map<Long, Object> f3369IL1Iii = new HashMap();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Long f3368ILil = new Long(1);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final lIiI f3367I1I = new lIiI();

    public static lIiI ILil() {
        return f3367I1I;
    }

    public synchronized Object I1I(long j) {
        return this.f3369IL1Iii.get(Long.valueOf(j));
    }

    public synchronized long IL1Iii(Object obj) {
        long jLongValue;
        jLongValue = f3368ILil.longValue();
        this.f3369IL1Iii.put(Long.valueOf(jLongValue), obj);
        f3368ILil = Long.valueOf(f3368ILil.longValue() + 1);
        return jLongValue;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1111IL(long j) {
        if (this.f3369IL1Iii.get(Long.valueOf(j)) != null) {
            this.f3369IL1Iii.remove(Long.valueOf(j));
        }
    }
}
