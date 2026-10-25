package p047IL;

import java.io.IOException;
import p066Ilil.lL;

/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes.dex */
public interface ILL extends Cloneable {

    /* JADX INFO: compiled from: Call.java */
    public interface IL1Iii {
        ILL IL1Iii(L1l l1l);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    void mo2842IiL(Ll1 ll1);

    void cancel();

    IIi execute() throws IOException;

    boolean isCanceled();

    L1l request();

    lL timeout();
}
