package I1I.I1I.ILil;

import java.util.Objects;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨丨丨丨, reason: contains not printable characters */
/* JADX INFO: compiled from: Point.java */
/* JADX INFO: loaded from: classes.dex */
public class C0531 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final int f3317IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f3318ILil;

    public C0531(int i, int i2) {
        this.f3317IL1Iii = i;
        this.f3318ILil = i2;
    }

    public int IL1Iii() {
        return this.f3317IL1Iii;
    }

    public int ILil() {
        return this.f3318ILil;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0531.class != obj.getClass()) {
            return false;
        }
        C0531 c0531 = (C0531) obj;
        return this.f3317IL1Iii == c0531.f3317IL1Iii && this.f3318ILil == c0531.f3318ILil;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3317IL1Iii), Integer.valueOf(this.f3318ILil));
    }

    public String toString() {
        return I1I.IL1Iii.IL1Iii(new byte[]{98, 90, 12, 8, 17, 73, 74, 8}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 92, 86, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 0, 1, 81, 85}, "56914e"))) + this.f3317IL1Iii + I1I.IL1Iii.IL1Iii(new byte[]{73, 22, 26, 91}, I1I.IL1Iii.IL1Iii(new byte[]{93, 83, 1, 3, 89, 4}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 90, 4, 91, 4}, "948ac7"))) + this.f3318ILil + '}';
    }
}
