package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: NioZipEncoding.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I implements lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Charset f5504IL1Iii;

    public L11I(Charset charset) {
        this.f5504IL1Iii = charset;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.lIlii
    public String IL1Iii(byte[] bArr) throws IOException {
        return this.f5504IL1Iii.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
    }
}
