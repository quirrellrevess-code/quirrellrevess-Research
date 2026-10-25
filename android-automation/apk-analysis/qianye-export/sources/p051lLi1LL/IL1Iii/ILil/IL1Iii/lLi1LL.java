package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.io.IOException;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: FallbackZipEncoding.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL implements lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f5521IL1Iii;

    public lLi1LL() {
        this.f5521IL1Iii = null;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.lIlii
    public String IL1Iii(byte[] bArr) throws IOException {
        return this.f5521IL1Iii == null ? new String(bArr) : new String(bArr, this.f5521IL1Iii);
    }

    public lLi1LL(String str) {
        this.f5521IL1Iii = str;
    }
}
