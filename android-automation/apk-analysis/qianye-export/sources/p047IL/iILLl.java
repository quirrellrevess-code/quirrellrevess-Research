package p047IL;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import p066Ilil.I11li1;
import p066Ilil.IL;
import p066Ilil.iILLL1;
import p066Ilil.lIiI;

/* JADX INFO: renamed from: I丨L.丨iI丨丨LLl, reason: invalid class name */
/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class iILLl {

    /* JADX INFO: renamed from: I丨L.丨iI丨丨LLl$I1I */
    /* JADX INFO: compiled from: RequestBody.java */
    public class I1I extends iILLl {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ L111 f4689IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ File f4690ILil;

        public I1I(L111 l111, File file) {
            this.f4689IL1Iii = l111;
            this.f4690ILil = file;
        }

        @Override // p047IL.iILLl
        public long contentLength() {
            return this.f4690ILil.length();
        }

        @Override // p047IL.iILLl
        @Nullable
        public L111 contentType() {
            return this.f4689IL1Iii;
        }

        @Override // p047IL.iILLl
        public void writeTo(IL il) throws IOException {
            I11li1 i11li1M2833il = lIiI.m2833il(this.f4690ILil);
            try {
                il.I11li1(i11li1M2833il);
                if (i11li1M2833il != null) {
                    i11li1M2833il.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (i11li1M2833il != null) {
                        try {
                            i11li1M2833il.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: I丨L.丨iI丨丨LLl$IL1Iii */
    /* JADX INFO: compiled from: RequestBody.java */
    public class IL1Iii extends iILLl {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ L111 f4691IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ iILLL1 f4692ILil;

        public IL1Iii(L111 l111, iILLL1 iilll1) {
            this.f4691IL1Iii = l111;
            this.f4692ILil = iilll1;
        }

        @Override // p047IL.iILLl
        public long contentLength() throws IOException {
            return this.f4692ILil.size();
        }

        @Override // p047IL.iILLl
        @Nullable
        public L111 contentType() {
            return this.f4691IL1Iii;
        }

        @Override // p047IL.iILLl
        public void writeTo(IL il) throws IOException {
            il.LL1IL(this.f4692ILil);
        }
    }

    /* JADX INFO: renamed from: I丨L.丨iI丨丨LLl$ILil */
    /* JADX INFO: compiled from: RequestBody.java */
    public class ILil extends iILLl {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ byte[] f4693I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ L111 f4694IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f4695ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f2139IL;

        public ILil(L111 l111, int i, byte[] bArr, int i2) {
            this.f4694IL1Iii = l111;
            this.f4695ILil = i;
            this.f4693I1I = bArr;
            this.f2139IL = i2;
        }

        @Override // p047IL.iILLl
        public long contentLength() {
            return this.f4695ILil;
        }

        @Override // p047IL.iILLl
        @Nullable
        public L111 contentType() {
            return this.f4694IL1Iii;
        }

        @Override // p047IL.iILLl
        public void writeTo(IL il) throws IOException {
            il.iIi1(this.f4693I1I, this.f2139IL, this.f4695ILil);
        }
    }

    public static iILLl create(@Nullable L111 l111, String str) {
        Charset charsetIL1Iii = StandardCharsets.UTF_8;
        if (l111 != null && (charsetIL1Iii = l111.IL1Iii()) == null) {
            charsetIL1Iii = StandardCharsets.UTF_8;
            l111 = L111.m2866IL(l111 + "; charset=utf-8");
        }
        return create(l111, str.getBytes(charsetIL1Iii));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    public abstract L111 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(IL il) throws IOException;

    public static iILLl create(@Nullable L111 l111, iILLL1 iilll1) {
        return new IL1Iii(l111, iilll1);
    }

    public static iILLl create(@Nullable L111 l111, byte[] bArr) {
        return create(l111, bArr, 0, bArr.length);
    }

    public static iILLl create(@Nullable L111 l111, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new ILil(l111, i2, bArr, i);
    }

    public static iILLl create(@Nullable L111 l111, File file) {
        Objects.requireNonNull(file, "file == null");
        return new I1I(l111, file);
    }
}
