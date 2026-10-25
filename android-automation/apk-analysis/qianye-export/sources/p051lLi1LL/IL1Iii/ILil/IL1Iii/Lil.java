package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.util.zip.ZipException;

/* JADX INFO: compiled from: UnsupportedZipFeatureException.java */
/* JADX INFO: loaded from: classes.dex */
public class Lil extends ZipException {
    private static final long serialVersionUID = 4430521921766595597L;
    private final iIlLiL entry;
    private final IL1Iii reason;

    /* JADX INFO: compiled from: UnsupportedZipFeatureException.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final String f5499IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final IL1Iii f5498ILil = new IL1Iii("encryption");

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public static final IL1Iii f5497I1I = new IL1Iii("compression method");

        public IL1Iii(String str) {
            this.f5499IL1Iii = str;
        }

        public String toString() {
            return this.f5499IL1Iii;
        }
    }

    public Lil(IL1Iii iL1Iii, iIlLiL iillil) {
        super("unsupported feature " + iL1Iii + " used in entry " + iillil.getName());
        this.reason = iL1Iii;
        this.entry = iillil;
    }

    public iIlLiL getEntry() {
        return this.entry;
    }

    public IL1Iii getFeature() {
        return this.reason;
    }
}
