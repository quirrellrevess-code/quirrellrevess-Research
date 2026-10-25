package retrofit2;

import java.io.IOException;
import p047IL.L1l;
import p066Ilil.lL;

/* JADX INFO: loaded from: classes.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    L1l request();

    lL timeout();
}
