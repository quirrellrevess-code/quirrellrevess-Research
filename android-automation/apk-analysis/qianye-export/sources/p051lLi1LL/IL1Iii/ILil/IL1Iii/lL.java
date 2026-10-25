package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import com.mysql.jdbc.MysqlDefs;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨lL, reason: invalid class name */
/* JADX INFO: compiled from: ZipFile.java */
/* JADX INFO: loaded from: classes.dex */
public class lL {

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static final long f3026Ll1 = I11L.m3607IL(llliI.f5517I1I);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final lIlii f5525I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Map<iIlLiL, IL> f5526IL1Iii;
    public final byte[] ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Map<String, iIlLiL> f5527ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final RandomAccessFile f5528Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final String f3027IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final byte[] f3028IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final byte[] f3029L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f3030iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean f3031lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final byte[] f3032il;

    /* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨lL$IL1Iii */
    /* JADX INFO: compiled from: ZipFile.java */
    public class IL1Iii extends InflaterInputStream {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Inflater f5531I1I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IL1Iii(InputStream inputStream, Inflater inflater, Inflater inflater2) {
            super(inputStream, inflater);
            this.f5531I1I = inflater2;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f5531I1I.end();
        }
    }

    public lL(String str) throws IOException {
        this(new File(str), (String) null);
    }

    public Enumeration<iIlLiL> I1I() {
        return Collections.enumeration(this.f5526IL1Iii.keySet());
    }

    public final void ILL(Map<iIlLiL, I1I> map) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f5526IL1Iii);
        this.f5526IL1Iii.clear();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            iIlLiL iillil = (iIlLiL) entry.getKey();
            IL il = (IL) entry.getValue();
            long j = il.f5536IL1Iii + 26;
            this.f5528Ilil.seek(j);
            this.f5528Ilil.readFully(this.ILL);
            int iM3657IL = l.m3657IL(this.ILL);
            this.f5528Ilil.readFully(this.ILL);
            int iM3657IL2 = l.m3657IL(this.ILL);
            int i = iM3657IL;
            while (i > 0) {
                int iSkipBytes = this.f5528Ilil.skipBytes(i);
                if (iSkipBytes <= 0) {
                    throw new IOException("failed to skip file name in local file header");
                }
                i -= iSkipBytes;
            }
            byte[] bArr = new byte[iM3657IL2];
            this.f5528Ilil.readFully(bArr);
            iillil.setExtra(bArr);
            il.f5537ILil = j + 2 + 2 + ((long) iM3657IL) + ((long) iM3657IL2);
            if (map.containsKey(iillil)) {
                String name = iillil.getName();
                I1I i1i = map.get(iillil);
                C1.Ilil(iillil, i1i.f5529IL1Iii, i1i.f5530ILil);
                if (!name.equals(iillil.getName())) {
                    this.f5527ILil.remove(name);
                    this.f5527ILil.put(iillil.getName(), iillil);
                }
            }
            this.f5526IL1Iii.put(iillil, il);
        }
    }

    public void ILil() throws IOException {
        this.f3030iILLL1 = true;
        this.f5528Ilil.close();
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final boolean m3646ILl() throws IOException {
        this.f5528Ilil.seek(0L);
        this.f5528Ilil.readFully(this.f3029L11I);
        return Arrays.equals(this.f3029L11I, llliI.f5518ILil);
    }

    public final Map<iIlLiL, I1I> Ilil() throws IOException {
        HashMap map = new HashMap();
        m3653lLi1LL();
        this.f5528Ilil.readFully(this.f3029L11I);
        long jM3607IL = I11L.m3607IL(this.f3029L11I);
        if (jM3607IL != f3026Ll1 && m3646ILl()) {
            throw new IOException("central directory is empty, can't expand corrupt archive.");
        }
        while (jM3607IL == f3026Ll1) {
            m3654il(map);
            this.f5528Ilil.readFully(this.f3029L11I);
            jM3607IL = I11L.m3607IL(this.f3029L11I);
        }
        return map;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public InputStream m3647IL(iIlLiL iillil) throws IOException {
        IL il = this.f5526IL1Iii.get(iillil);
        if (il == null) {
            return null;
        }
        C1.IL1Iii(iillil);
        ILil iLil = new ILil(il.f5537ILil, iillil.getCompressedSize());
        int method = iillil.getMethod();
        if (method == 0) {
            return iLil;
        }
        if (method == 8) {
            iLil.m3655IiL();
            Inflater inflater = new Inflater(true);
            return new IL1Iii(iLil, inflater, inflater);
        }
        throw new ZipException("Found unsupported compression method " + iillil.getMethod());
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3648IiL() throws IOException {
        m3652lIiI(4);
        this.f5528Ilil.readFully(this.f3028IiL);
        this.f5528Ilil.seek(llL1ii.m3643IL(this.f3028IiL));
        this.f5528Ilil.readFully(this.f3029L11I);
        if (!Arrays.equals(this.f3029L11I, llliI.f5519Ilil)) {
            throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
        }
        m3652lIiI(44);
        this.f5528Ilil.readFully(this.f3028IiL);
        this.f5528Ilil.seek(llL1ii.m3643IL(this.f3028IiL));
    }

    public final boolean Lil(long j, long j2, byte[] bArr) throws IOException {
        long length = this.f5528Ilil.length() - j;
        long jMax = Math.max(0L, this.f5528Ilil.length() - j2);
        boolean z = true;
        if (length < 0) {
            z = false;
            break;
        }
        while (true) {
            if (length >= jMax) {
                this.f5528Ilil.seek(length);
                int i = this.f5528Ilil.read();
                if (i != -1) {
                    if (i == bArr[0] && this.f5528Ilil.read() == bArr[1] && this.f5528Ilil.read() == bArr[2] && this.f5528Ilil.read() == bArr[3]) {
                        break;
                    }
                    length--;
                }
            }
            z = false;
            break;
        }
        if (z) {
            this.f5528Ilil.seek(length);
        }
        return z;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3649Ll1(iIlLiL iillil, IL il, int i) throws IOException {
        LlLI1 llLI1 = (LlLI1) iillil.m3631IL(LlLI1.f3013iILLL1);
        if (llLI1 != null) {
            boolean z = iillil.getSize() == MysqlDefs.LENGTH_LONGBLOB;
            boolean z2 = iillil.getCompressedSize() == MysqlDefs.LENGTH_LONGBLOB;
            boolean z3 = il.f5536IL1Iii == MysqlDefs.LENGTH_LONGBLOB;
            llLI1.m3626Ll1(z, z2, z3, i == 65535);
            if (z) {
                iillil.setSize(llLI1.ILL().I1I());
            } else if (z2) {
                llLI1.m3624ILl(new llL1ii(iillil.getSize()));
            }
            if (z2) {
                iillil.setCompressedSize(llLI1.m3627L11I().I1I());
            } else if (z) {
                llLI1.m3628lIiI(new llL1ii(iillil.getCompressedSize()));
            }
            if (z3) {
                il.f5536IL1Iii = llLI1.m3629il().I1I();
            }
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3650L11I() throws IOException {
        if (!Lil(22L, 65557L, llliI.f3024IL)) {
            throw new ZipException("archive is not a ZIP archive");
        }
    }

    public void finalize() throws Throwable {
        try {
            if (!this.f3030iILLL1) {
                System.err.println("Cleaning up unclosed ZipFile for archive " + this.f3027IL);
                ILil();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m3651iILLL1() throws IOException {
        m3652lIiI(16);
        this.f5528Ilil.readFully(this.f3029L11I);
        this.f5528Ilil.seek(I11L.m3607IL(this.f3029L11I));
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final void m3652lIiI(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int iSkipBytes = this.f5528Ilil.skipBytes(i - i2);
            if (iSkipBytes <= 0) {
                throw new EOFException();
            }
            i2 += iSkipBytes;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m3653lLi1LL() throws IOException {
        m3650L11I();
        boolean zEquals = false;
        boolean z = this.f5528Ilil.getFilePointer() > 20;
        if (z) {
            RandomAccessFile randomAccessFile = this.f5528Ilil;
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 20);
            this.f5528Ilil.readFully(this.f3029L11I);
            zEquals = Arrays.equals(llliI.f3025lLi1LL, this.f3029L11I);
        }
        if (zEquals) {
            m3648IiL();
            return;
        }
        if (z) {
            m3652lIiI(16);
        }
        m3651iILLL1();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m3654il(Map<iIlLiL, I1I> map) throws IOException {
        this.f5528Ilil.readFully(this.f3032il);
        iIlLiL iillil = new iIlLiL();
        iillil.iIlLiL((l.Ilil(this.f3032il, 0) >> 8) & 15);
        iILLL1 iilll1IL1Iii = iILLL1.IL1Iii(this.f3032il, 4);
        boolean zM3641iILLL1 = iilll1IL1Iii.m3641iILLL1();
        lIlii lilii = zM3641iILLL1 ? iIi1.f5506ILil : this.f5525I1I;
        iillil.LlLI1(iilll1IL1Iii);
        iillil.setMethod(l.Ilil(this.f3032il, 6));
        iillil.setTime(C1.I1I(I11L.Ilil(this.f3032il, 8)));
        iillil.setCrc(I11L.Ilil(this.f3032il, 12));
        iillil.setCompressedSize(I11L.Ilil(this.f3032il, 16));
        iillil.setSize(I11L.Ilil(this.f3032il, 20));
        int iIlil = l.Ilil(this.f3032il, 24);
        int iIlil2 = l.Ilil(this.f3032il, 26);
        int iIlil3 = l.Ilil(this.f3032il, 28);
        int iIlil4 = l.Ilil(this.f3032il, 30);
        iillil.m3637llL1ii(l.Ilil(this.f3032il, 32));
        iillil.m3635lIiI(I11L.Ilil(this.f3032il, 34));
        byte[] bArr = new byte[iIlil];
        this.f5528Ilil.readFully(bArr);
        iillil.iIi1(lilii.IL1Iii(bArr), bArr);
        byte b = 0;
        IL il = new IL(null);
        il.f5536IL1Iii = I11L.Ilil(this.f3032il, 38);
        this.f5526IL1Iii.put(iillil, il);
        this.f5527ILil.put(iillil.getName(), iillil);
        byte[] bArr2 = new byte[iIlil2];
        this.f5528Ilil.readFully(bArr2);
        iillil.m3632Ll1(bArr2);
        m3649Ll1(iillil, il, iIlil4);
        byte[] bArr3 = new byte[iIlil3];
        this.f5528Ilil.readFully(bArr3);
        iillil.setComment(lilii.IL1Iii(bArr3));
        if (zM3641iILLL1 || !this.f3031lLi1LL) {
            return;
        }
        map.put(iillil, new I1I(bArr, bArr3, b == true ? 1 : 0));
    }

    public lL(String str, String str2) throws IOException {
        this(new File(str), str2, true);
    }

    /* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨lL$I1I */
    /* JADX INFO: compiled from: ZipFile.java */
    public static final class I1I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final byte[] f5529IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final byte[] f5530ILil;

        public I1I(byte[] bArr, byte[] bArr2) {
            this.f5529IL1Iii = bArr;
            this.f5530ILil = bArr2;
        }

        public /* synthetic */ I1I(byte[] bArr, byte[] bArr2, I1I i1i) {
            this(bArr, bArr2);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨lL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ZipFile.java */
    public static final class IL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public long f5536IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public long f5537ILil;

        public IL() {
            this.f5536IL1Iii = -1L;
            this.f5537ILil = -1L;
        }

        public /* synthetic */ IL(IL il) {
            this();
        }
    }

    public lL(File file, String str) throws IOException {
        this(file, str, true);
    }

    public lL(File file, String str, boolean z) throws IOException {
        this.f5526IL1Iii = new LinkedHashMap(509);
        this.f5527ILil = new HashMap(509);
        this.f3028IiL = new byte[8];
        this.f3029L11I = new byte[4];
        this.f3032il = new byte[42];
        this.ILL = new byte[2];
        this.f3027IL = file.getAbsolutePath();
        this.f5525I1I = iIi1.IL1Iii(str);
        this.f3031lLi1LL = z;
        this.f5528Ilil = new RandomAccessFile(file, "r");
        try {
            ILL(Ilil());
        } catch (Throwable th) {
            try {
                this.f3030iILLL1 = true;
                this.f5528Ilil.close();
            } catch (IOException unused) {
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨lL$ILil */
    /* JADX INFO: compiled from: ZipFile.java */
    public class ILil extends InputStream {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public long f5533I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public long f5534ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f3033IL = false;

        public ILil(long j, long j2) {
            this.f5534ILil = j2;
            this.f5533I1I = j;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m3655IiL() {
            this.f3033IL = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i;
            long j = this.f5534ILil;
            this.f5534ILil = j - 1;
            if (j <= 0) {
                if (!this.f3033IL) {
                    return -1;
                }
                this.f3033IL = false;
                return 0;
            }
            synchronized (lL.this.f5528Ilil) {
                RandomAccessFile randomAccessFile = lL.this.f5528Ilil;
                long j2 = this.f5533I1I;
                this.f5533I1I = 1 + j2;
                randomAccessFile.seek(j2);
                i = lL.this.f5528Ilil.read();
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            long j = this.f5534ILil;
            if (j <= 0) {
                if (!this.f3033IL) {
                    return -1;
                }
                this.f3033IL = false;
                bArr[i] = 0;
                return 1;
            }
            if (i2 <= 0) {
                return 0;
            }
            if (i2 > j) {
                i2 = (int) j;
            }
            synchronized (lL.this.f5528Ilil) {
                lL.this.f5528Ilil.seek(this.f5533I1I);
                i3 = lL.this.f5528Ilil.read(bArr, i, i2);
            }
            if (i3 > 0) {
                long j2 = i3;
                this.f5533I1I += j2;
                this.f5534ILil -= j2;
            }
            return i3;
        }
    }
}
