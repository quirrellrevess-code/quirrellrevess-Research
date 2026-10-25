package okhttp3.internal.cache;

import java.io.IOException;
import javax.annotation.Nullable;
import p047IL.IIi;
import p047IL.L1l;

/* JADX INFO: loaded from: classes.dex */
public interface InternalCache {
    @Nullable
    IIi get(L1l l1l) throws IOException;

    @Nullable
    CacheRequest put(IIi iIi) throws IOException;

    void remove(L1l l1l) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy cacheStrategy);

    void update(IIi iIi, IIi iIi2);
}
