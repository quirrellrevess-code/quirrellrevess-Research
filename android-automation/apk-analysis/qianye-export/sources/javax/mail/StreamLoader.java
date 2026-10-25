package javax.mail;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: Session.java */
/* JADX INFO: loaded from: classes.dex */
public interface StreamLoader {
    void load(InputStream inputStream) throws IOException;
}
