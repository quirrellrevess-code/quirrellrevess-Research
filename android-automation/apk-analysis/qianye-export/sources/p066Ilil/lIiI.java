package p066Ilil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: Ilil.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: Okio.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIiI {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Logger f4586IL1Iii = Logger.getLogger(lIiI.class.getName());

    /* JADX INFO: renamed from: Ilil.lIi丨I$I1I */
    /* JADX INFO: compiled from: Okio.java */
    public class I1I implements iIlLiL {
        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return lL.NONE;
        }

        @Override // p066Ilil.iIlLiL
        public void write(p066Ilil.I1I i1i, long j) throws IOException {
            i1i.I11L(j);
        }
    }

    /* JADX INFO: renamed from: Ilil.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: Okio.java */
    public class IL1Iii implements iIlLiL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ OutputStream f4587I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ lL f4588ILil;

        public IL1Iii(lL lLVar, OutputStream outputStream) {
            this.f4588ILil = lLVar;
            this.f4587I1I = outputStream;
        }

        @Override // p066Ilil.iIlLiL, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f4587I1I.close();
        }

        @Override // p066Ilil.iIlLiL, java.io.Flushable
        public void flush() throws IOException {
            this.f4587I1I.flush();
        }

        @Override // p066Ilil.iIlLiL
        public lL timeout() {
            return this.f4588ILil;
        }

        public String toString() {
            return "sink(" + this.f4587I1I + ")";
        }

        @Override // p066Ilil.iIlLiL
        public void write(p066Ilil.I1I i1i, long j) throws IOException {
            I11L.ILil(i1i.f4559I1I, 0L, j);
            while (j > 0) {
                this.f4588ILil.throwIfReached();
                llL1ii lll1ii = i1i.f4560ILil;
                int iMin = (int) Math.min(j, lll1ii.f4594I1I - lll1ii.f4596ILil);
                this.f4587I1I.write(lll1ii.f4595IL1Iii, lll1ii.f4596ILil, iMin);
                int i = lll1ii.f4596ILil + iMin;
                lll1ii.f4596ILil = i;
                long j2 = iMin;
                j -= j2;
                i1i.f4559I1I -= j2;
                if (i == lll1ii.f4594I1I) {
                    i1i.f4560ILil = lll1ii.ILil();
                    lIlii.IL1Iii(lll1ii);
                }
            }
        }
    }

    /* JADX INFO: renamed from: Ilil.lIi丨I$ILil */
    /* JADX INFO: compiled from: Okio.java */
    public class ILil implements I11li1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ InputStream f4589I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ lL f4590ILil;

        public ILil(lL lLVar, InputStream inputStream) {
            this.f4590ILil = lLVar;
            this.f4589I1I = inputStream;
        }

        @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f4589I1I.close();
        }

        @Override // p066Ilil.I11li1
        public long read(p066Ilil.I1I i1i, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.f4590ILil.throwIfReached();
                llL1ii lll1iiM95I1 = i1i.m95I1(1);
                int i = this.f4589I1I.read(lll1iiM95I1.f4595IL1Iii, lll1iiM95I1.f4594I1I, (int) Math.min(j, 8192 - lll1iiM95I1.f4594I1I));
                if (i == -1) {
                    return -1L;
                }
                lll1iiM95I1.f4594I1I += i;
                long j2 = i;
                i1i.f4559I1I += j2;
                return j2;
            } catch (AssertionError e) {
                if (lIiI.Ilil(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
        public lL timeout() {
            return this.f4590ILil;
        }

        public String toString() {
            return "source(" + this.f4589I1I + ")";
        }
    }

    /* JADX INFO: renamed from: Ilil.lIi丨I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: Okio.java */
    public class IL extends p066Ilil.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Socket f4591IL1Iii;

        public IL(Socket socket) {
            this.f4591IL1Iii = socket;
        }

        @Override // p066Ilil.IL1Iii
        public IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p066Ilil.IL1Iii
        public void timedOut() {
            try {
                this.f4591IL1Iii.close();
            } catch (AssertionError e) {
                if (!lIiI.Ilil(e)) {
                    throw e;
                }
                lIiI.f4586IL1Iii.log(Level.WARNING, "Failed to close timed out socket " + this.f4591IL1Iii, (Throwable) e);
            } catch (Exception e2) {
                lIiI.f4586IL1Iii.log(Level.WARNING, "Failed to close timed out socket " + this.f4591IL1Iii, (Throwable) e2);
            }
        }
    }

    public static p066Ilil.IL I1I(iIlLiL iillil) {
        return new Lil(iillil);
    }

    public static iIlLiL IL1Iii(File file) throws FileNotFoundException {
        if (file != null) {
            return m2830iILLL1(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static I11li1 ILL(InputStream inputStream) {
        return m2828Ll1(inputStream, new lL());
    }

    public static iIlLiL ILil() {
        return new I1I();
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static p066Ilil.IL1Iii m2825ILl(Socket socket) {
        return new IL(socket);
    }

    public static boolean Ilil(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static lLi1LL m2826IL(I11li1 i11li1) {
        return new LlLI1(i11li1);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static iIlLiL m2827IiL(OutputStream outputStream, lL lLVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (lLVar != null) {
            return new IL1Iii(lLVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static I11li1 m2828Ll1(InputStream inputStream, lL lLVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (lLVar != null) {
            return new ILil(lLVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static iIlLiL m2829L11I(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        p066Ilil.IL1Iii iL1IiiM2825ILl = m2825ILl(socket);
        return iL1IiiM2825ILl.sink(m2827IiL(socket.getOutputStream(), iL1IiiM2825ILl));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static iIlLiL m2830iILLL1(OutputStream outputStream) {
        return m2827IiL(outputStream, new lL());
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static I11li1 m2831lIiI(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        p066Ilil.IL1Iii iL1IiiM2825ILl = m2825ILl(socket);
        return iL1IiiM2825ILl.source(m2828Ll1(socket.getInputStream(), iL1IiiM2825ILl));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static iIlLiL m2832lLi1LL(File file) throws FileNotFoundException {
        if (file != null) {
            return m2830iILLL1(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static I11li1 m2833il(File file) throws FileNotFoundException {
        if (file != null) {
            return ILL(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }
}
