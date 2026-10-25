package javax.mail.search;

/* JADX INFO: loaded from: classes.dex */
public abstract class ComparisonTerm extends SearchTerm {

    /* JADX INFO: renamed from: EQ */
    public static final int f872EQ = 3;

    /* JADX INFO: renamed from: GE */
    public static final int f873GE = 6;

    /* JADX INFO: renamed from: GT */
    public static final int f874GT = 5;

    /* JADX INFO: renamed from: LE */
    public static final int f875LE = 1;

    /* JADX INFO: renamed from: LT */
    public static final int f876LT = 2;

    /* JADX INFO: renamed from: NE */
    public static final int f877NE = 4;
    private static final long serialVersionUID = 1456646953666474308L;
    public int comparison;

    public boolean equals(Object obj) {
        return (obj instanceof ComparisonTerm) && ((ComparisonTerm) obj).comparison == this.comparison;
    }

    public int hashCode() {
        return this.comparison;
    }
}
