package p047IL;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import p066Ilil.I1I;
import p066Ilil.iILLL1;
import p066Ilil.lLi1LL;

/* JADX INFO: renamed from: I丨L.LI丨丨l丨l, reason: invalid class name */
/* JADX INFO: compiled from: ResponseBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class LIll implements Closeable {

    @Nullable
    private Reader reader;

    /* JADX INFO: renamed from: I丨L.LI丨丨l丨l$IL1Iii */
    /* JADX INFO: compiled from: ResponseBody.java */
    public class IL1Iii extends LIll {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ long f4627I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ L111 f4628ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ lLi1LL f2090IL;

        public IL1Iii(L111 l111, long j, lLi1LL lli1ll) {
            this.f4628ILil = l111;
            this.f4627I1I = j;
            this.f2090IL = lli1ll;
        }

        @Override // p047IL.LIll
        public long contentLength() {
            return this.f4627I1I;
        }

        @Override // p047IL.LIll
        @Nullable
        public L111 contentType() {
            return this.f4628ILil;
        }

        @Override // p047IL.LIll
        public lLi1LL source() {
            return this.f2090IL;
        }
    }

    /* JADX INFO: renamed from: I丨L.LI丨丨l丨l$ILil */
    /* JADX INFO: compiled from: ResponseBody.java */
    public static final class ILil extends Reader {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Charset f4629I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final lLi1LL f4630ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        @Nullable
        public Reader f4631Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2091IL;

        public ILil(lLi1LL lli1ll, Charset charset) {
            this.f4630ILil = lli1ll;
            this.f4629I1I = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f2091IL = true;
            Reader reader = this.f4631Ilil;
            if (reader != null) {
                reader.close();
            } else {
                this.f4630ILil.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.f2091IL) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f4631Ilil;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f4630ILil.mo2779LIll(), Util.bomAwareCharset(this.f4630ILil, this.f4629I1I));
                this.f4631Ilil = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private Charset charset() {
        L111 l111ContentType = contentType();
        return l111ContentType != null ? l111ContentType.ILil(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static LIll create(@Nullable L111 l111, String str) {
        Charset charsetIL1Iii = StandardCharsets.UTF_8;
        if (l111 != null && (charsetIL1Iii = l111.IL1Iii()) == null) {
            charsetIL1Iii = StandardCharsets.UTF_8;
            l111 = L111.m2866IL(l111 + "; charset=utf-8");
        }
        I1I i1i = new I1I();
        i1i.LiL1(str, charsetIL1Iii);
        return create(l111, i1i.m96I(), i1i);
    }

    public final InputStream byteStream() {
        return source().mo2779LIll();
    }

    public final byte[] bytes() throws Exception {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        lLi1LL lli1llSource = source();
        try {
            byte[] bArrMo2784L11I = lli1llSource.mo2784L11I();
            if (lli1llSource != null) {
                $closeResource(null, lli1llSource);
            }
            if (jContentLength == -1 || jContentLength == bArrMo2784L11I.length) {
                return bArrMo2784L11I;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + bArrMo2784L11I.length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (lli1llSource != null) {
                    $closeResource(th, lli1llSource);
                }
                throw th2;
            }
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        ILil iLil = new ILil(source(), charset());
        this.reader = iLil;
        return iLil;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract L111 contentType();

    public abstract lLi1LL source();

    public final String string() throws Exception {
        lLi1LL lli1llSource = source();
        try {
            String strMo2799llL1ii = lli1llSource.mo2799llL1ii(Util.bomAwareCharset(lli1llSource, charset()));
            if (lli1llSource != null) {
                $closeResource(null, lli1llSource);
            }
            return strMo2799llL1ii;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (lli1llSource != null) {
                    $closeResource(th, lli1llSource);
                }
                throw th2;
            }
        }
    }

    public static LIll create(@Nullable L111 l111, byte[] bArr) {
        I1I i1i = new I1I();
        i1i.L1iI1(bArr);
        return create(l111, bArr.length, i1i);
    }

    public static LIll create(@Nullable L111 l111, iILLL1 iilll1) {
        I1I i1i = new I1I();
        i1i.m2803i11i(iilll1);
        return create(l111, iilll1.size(), i1i);
    }

    public static LIll create(@Nullable L111 l111, long j, lLi1LL lli1ll) {
        Objects.requireNonNull(lli1ll, "source == null");
        return new IL1Iii(l111, j, lli1ll);
    }
}
