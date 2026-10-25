package ILil.I1I.IL1Iii.IL1Iii;

/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends I1I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static volatile IL1Iii f3601I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public I1I f3602IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I f3603ILil;

    public IL1Iii() {
        ILil iLil = new ILil();
        this.f3603ILil = iLil;
        this.f3602IL1Iii = iLil;
    }

    public static IL1Iii ILil() {
        if (f3601I1I != null) {
            return f3601I1I;
        }
        synchronized (IL1Iii.class) {
            if (f3601I1I == null) {
                f3601I1I = new IL1Iii();
            }
        }
        return f3601I1I;
    }

    @Override // ILil.I1I.IL1Iii.IL1Iii.I1I
    public boolean IL1Iii() {
        return this.f3602IL1Iii.IL1Iii();
    }
}
