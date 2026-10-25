package I1I.I1I.ILil;

import java.util.Objects;

/* JADX INFO: renamed from: I1I.I1I.ILil.ili丨11, reason: invalid class name */
/* JADX INFO: compiled from: Size.java */
/* JADX INFO: loaded from: classes.dex */
public final class ili11 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final int f3250IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f3251ILil;

    public ili11(int i, int i2) {
        this.f3250IL1Iii = i;
        this.f3251ILil = i2;
    }

    public int IL1Iii() {
        return this.f3251ILil;
    }

    public int ILil() {
        return this.f3250IL1Iii;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ili11.class != obj.getClass()) {
            return false;
        }
        ili11 ili11Var = (ili11) obj;
        return this.f3250IL1Iii == ili11Var.f3250IL1Iii && this.f3251ILil == ili11Var.f3251ILil;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3250IL1Iii), Integer.valueOf(this.f3251ILil));
    }

    public String toString() {
        return I1I.IL1Iii.IL1Iii(new byte[]{100, 80, 76, 6, 29, 22, 94, 93, 66, 11, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 8, 5, 84, 2, 89}, I1I.IL1Iii.IL1Iii(new byte[]{85, 84, 86, 85, 6, 91}, "3eebbc"))) + this.f3250IL1Iii + I1I.IL1Iii.IL1Iii(new byte[]{21, 21, 81, 84, 89, 87, 81, 65, 4}, I1I.IL1Iii.IL1Iii(new byte[]{95, 5, 14, 1, 6, 85}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 0, 5, 83, 87}, "4e75e2"))) + this.f3251ILil + '}';
    }
}
