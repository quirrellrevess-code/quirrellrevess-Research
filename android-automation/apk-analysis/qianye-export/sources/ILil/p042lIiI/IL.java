package ILil.p042lIiI;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: ILil.lIi丨I.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: Lifecycle.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL {

    /* JADX INFO: renamed from: ILil.lIi丨I.I丨L$IL1Iii */
    /* JADX INFO: compiled from: Lifecycle.java */
    public enum IL1Iii {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* JADX INFO: renamed from: ILil.lIi丨I.I丨L$ILil */
    /* JADX INFO: compiled from: Lifecycle.java */
    public enum ILil {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(ILil iLil) {
            return compareTo(iLil) >= 0;
        }
    }

    public IL() {
        new AtomicReference();
    }

    public abstract void I1I(iILLL1 iilll1);

    public abstract void IL1Iii(iILLL1 iilll1);

    public abstract ILil ILil();
}
