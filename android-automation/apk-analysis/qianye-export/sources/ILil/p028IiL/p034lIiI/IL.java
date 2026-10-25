package ILil.p028IiL.p034lIiI;

/* JADX INFO: renamed from: ILil.I丨iL.lIi丨I.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public class IL<F, S> {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final F f4196IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final S f4197ILil;

    public IL(F f, S s) {
        this.f4196IL1Iii = f;
        this.f4197ILil = s;
    }

    public static <A, B> IL<A, B> IL1Iii(A a, B b) {
        return new IL<>(a, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IL)) {
            return false;
        }
        IL il = (IL) obj;
        return I1I.IL1Iii(il.f4196IL1Iii, this.f4196IL1Iii) && I1I.IL1Iii(il.f4197ILil, this.f4197ILil);
    }

    public int hashCode() {
        F f = this.f4196IL1Iii;
        int iHashCode = f == null ? 0 : f.hashCode();
        S s = this.f4197ILil;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f4196IL1Iii) + " " + String.valueOf(this.f4197ILil) + "}";
    }
}
