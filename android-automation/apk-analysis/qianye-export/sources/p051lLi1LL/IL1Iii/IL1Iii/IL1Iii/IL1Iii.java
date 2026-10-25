package p051lLi1LL.IL1Iii.IL1Iii.IL1Iii;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: Charsets.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {
    static {
        Charset charset = StandardCharsets.ISO_8859_1;
        Charset charset2 = StandardCharsets.US_ASCII;
        Charset charset3 = StandardCharsets.UTF_16;
        Charset charset4 = StandardCharsets.UTF_16BE;
        Charset charset5 = StandardCharsets.UTF_16LE;
        Charset charset6 = StandardCharsets.UTF_8;
    }

    public static Charset IL1Iii(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    public static Charset ILil(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
