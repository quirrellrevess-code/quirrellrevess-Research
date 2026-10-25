package p051lLi1LL.ILil.IL1Iii;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: Subscription.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIlii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public volatile boolean f5575I1I = true;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object f5576IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final LlLI1 f5577ILil;

    public lIlii(Object obj, LlLI1 llLI1) {
        this.f5576IL1Iii = obj;
        this.f5577ILil = llLI1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof lIlii)) {
            return false;
        }
        lIlii lilii = (lIlii) obj;
        return this.f5576IL1Iii == lilii.f5576IL1Iii && this.f5577ILil.equals(lilii.f5577ILil);
    }

    public int hashCode() {
        return this.f5576IL1Iii.hashCode() + this.f5577ILil.f3058lLi1LL.hashCode();
    }
}
