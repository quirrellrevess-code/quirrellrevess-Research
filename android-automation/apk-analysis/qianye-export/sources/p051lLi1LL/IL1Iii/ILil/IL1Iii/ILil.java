package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import com.google.android.flexbox.BuildConfig;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: AsiExtraField.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil implements I11li1, Cloneable {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static final l f3006IiL = new l(30062);

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5488ILil = 0;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f5487I1I = 0;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f3007IL = 0;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public String f5489Ilil = BuildConfig.FLAVOR;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f3009lLi1LL = false;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public CRC32 f3008iILLL1 = new CRC32();

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public void I1I(byte[] bArr, int i, int i2) throws ZipException {
        long jIlil = I11L.Ilil(bArr, i);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i + 4, bArr2, 0, i3);
        this.f3008iILLL1.reset();
        this.f3008iILLL1.update(bArr2);
        long value = this.f3008iILLL1.getValue();
        if (jIlil != value) {
            throw new ZipException("bad CRC checksum " + Long.toHexString(jIlil) + " instead of " + Long.toHexString(value));
        }
        int iIlil = l.Ilil(bArr2, 0);
        int iIlil2 = (int) I11L.Ilil(bArr2, 2);
        byte[] bArr3 = new byte[iIlil2];
        this.f5487I1I = l.Ilil(bArr2, 6);
        this.f3007IL = l.Ilil(bArr2, 8);
        if (iIlil2 == 0) {
            this.f5489Ilil = BuildConfig.FLAVOR;
        } else {
            System.arraycopy(bArr2, 10, bArr3, 0, iIlil2);
            this.f5489Ilil = new String(bArr3);
        }
        LlLI1((iIlil & 16384) != 0);
        m3618llL1ii(iIlil);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l IL1Iii() {
        return f3006IiL;
    }

    public int ILL() {
        return this.f5488ILil;
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public l ILil() {
        return new l(m3619il().getBytes().length + 14);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m3614ILl() {
        return this.f3009lLi1LL && !Lil();
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    public byte[] Ilil() {
        return mo3608IL();
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: I丨L */
    public byte[] mo3608IL() {
        int iI1I = ILil().I1I() - 4;
        byte[] bArr = new byte[iI1I];
        System.arraycopy(l.ILil(ILL()), 0, bArr, 0, 2);
        byte[] bytes = m3619il().getBytes();
        System.arraycopy(I11L.ILil(bytes.length), 0, bArr, 2, 4);
        System.arraycopy(l.ILil(m3617lIiI()), 0, bArr, 6, 2);
        System.arraycopy(l.ILil(m3616L11I()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.f3008iILLL1.reset();
        this.f3008iILLL1.update(bArr);
        byte[] bArr2 = new byte[iI1I + 4];
        System.arraycopy(I11L.ILil(this.f3008iILLL1.getValue()), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, iI1I);
        return bArr2;
    }

    public boolean Lil() {
        return m3619il().length() != 0;
    }

    public void LlLI1(boolean z) {
        this.f3009lLi1LL = z;
        this.f5488ILil = m3615Ll1(this.f5488ILil);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int m3615Ll1(int i) {
        int i2;
        if (Lil()) {
            i2 = 40960;
        } else {
            i2 = m3614ILl() ? 16384 : 32768;
        }
        return (i & 4095) | i2;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int m3616L11I() {
        return this.f3007IL;
    }

    public Object clone() {
        try {
            ILil iLil = (ILil) super.clone();
            iLil.f3008iILLL1 = new CRC32();
            return iLil;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int m3617lIiI() {
        return this.f5487I1I;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m3618llL1ii(int i) {
        this.f5488ILil = m3615Ll1(i);
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.I11li1
    /* JADX INFO: renamed from: l丨Li1LL */
    public l mo3609lLi1LL() {
        return ILil();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public String m3619il() {
        return this.f5489Ilil;
    }
}
