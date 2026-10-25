package p066Ilil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: Ilil.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: BufferedSink.java */
/* JADX INFO: loaded from: classes.dex */
public interface IL extends iIlLiL, WritableByteChannel {
    long I11li1(I11li1 i11li1) throws IOException;

    IL I1I() throws IOException;

    I1I IL1Iii();

    /* JADX INFO: renamed from: IL丨丨l */
    IL mo2773ILl() throws IOException;

    /* JADX INFO: renamed from: I丨L */
    IL mo2775IL(int i) throws IOException;

    IL LL1IL(iILLL1 iilll1) throws IOException;

    IL LlLI1(String str) throws IOException;

    /* JADX INFO: renamed from: Ll丨1 */
    IL mo2782Ll1(int i) throws IOException;

    /* JADX INFO: renamed from: L丨1l */
    OutputStream mo2783L1l();

    @Override // p066Ilil.iIlLiL, java.io.Flushable
    void flush() throws IOException;

    IL iIi1(byte[] bArr, int i, int i2) throws IOException;

    /* JADX INFO: renamed from: l1IIi1丨 */
    IL mo2794l1IIi1(long j) throws IOException;

    /* JADX INFO: renamed from: lI丨II */
    IL mo2797lIII(byte[] bArr) throws IOException;

    /* JADX INFO: renamed from: l丨Li1LL */
    IL mo2800lLi1LL(int i) throws IOException;

    /* JADX INFO: renamed from: 丨lL */
    IL mo2807lL(long j) throws IOException;
}
