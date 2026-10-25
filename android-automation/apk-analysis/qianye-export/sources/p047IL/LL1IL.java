package p047IL;

import java.io.IOException;

/* JADX INFO: compiled from: Interceptor.java */
/* JADX INFO: loaded from: classes.dex */
public interface LL1IL {

    /* JADX INFO: compiled from: Interceptor.java */
    public interface IL1Iii {
        int connectTimeoutMillis();

        IIi proceed(L1l l1l) throws IOException;

        int readTimeoutMillis();

        L1l request();

        int writeTimeoutMillis();
    }

    IIi intercept(IL1Iii iL1Iii) throws IOException;
}
