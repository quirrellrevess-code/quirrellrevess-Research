package ILil.p042lIiI;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class LlLI1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Map<String, Object> f4345IL1Iii = new HashMap();

    public static void ILil(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void I1I() {
    }

    public final void IL1Iii() {
        Map<String, Object> map = this.f4345IL1Iii;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f4345IL1Iii.values().iterator();
                while (it.hasNext()) {
                    ILil(it.next());
                }
            }
        }
        I1I();
    }
}
