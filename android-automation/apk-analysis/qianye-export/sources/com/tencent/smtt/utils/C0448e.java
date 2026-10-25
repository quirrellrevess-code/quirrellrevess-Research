package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* JADX INFO: renamed from: com.tencent.smtt.utils.e */
/* JADX INFO: loaded from: classes.dex */
public class C0448e implements Closeable {

    /* JADX INFO: renamed from: a */
    public static final char[] f734a = {127, 'E', 'L', 'F', 0};

    /* JADX INFO: renamed from: b */
    public final char[] f735b;

    /* JADX INFO: renamed from: c */
    public boolean f736c;

    /* JADX INFO: renamed from: d */
    public j[] f737d;

    /* JADX INFO: renamed from: e */
    public l[] f738e;

    /* JADX INFO: renamed from: f */
    public byte[] f739f;

    /* JADX INFO: renamed from: g */
    private final C0446c f740g;

    /* JADX INFO: renamed from: h */
    private final a f741h;

    /* JADX INFO: renamed from: i */
    private final k[] f742i;

    /* JADX INFO: renamed from: j */
    private byte[] f743j;

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$a */
    public static abstract class a {

        /* JADX INFO: renamed from: a */
        public short f744a;

        /* JADX INFO: renamed from: b */
        public short f745b;

        /* JADX INFO: renamed from: c */
        public int f746c;

        /* JADX INFO: renamed from: d */
        public int f747d;

        /* JADX INFO: renamed from: e */
        public short f748e;

        /* JADX INFO: renamed from: f */
        public short f749f;

        /* JADX INFO: renamed from: g */
        public short f750g;

        /* JADX INFO: renamed from: h */
        public short f751h;

        /* JADX INFO: renamed from: i */
        public short f752i;

        /* JADX INFO: renamed from: j */
        public short f753j;

        /* JADX INFO: renamed from: a */
        public abstract long mo734a();

        /* JADX INFO: renamed from: b */
        public abstract long mo735b();
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$b */
    public static class b extends a {

        /* JADX INFO: renamed from: k */
        public int f754k;

        /* JADX INFO: renamed from: l */
        public int f755l;

        /* JADX INFO: renamed from: m */
        public int f756m;

        @Override // com.tencent.smtt.utils.C0448e.a
        /* JADX INFO: renamed from: a */
        public long mo734a() {
            return this.f756m;
        }

        @Override // com.tencent.smtt.utils.C0448e.a
        /* JADX INFO: renamed from: b */
        public long mo735b() {
            return this.f755l;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$c */
    public static class c extends j {

        /* JADX INFO: renamed from: a */
        public int f757a;

        /* JADX INFO: renamed from: b */
        public int f758b;

        /* JADX INFO: renamed from: c */
        public int f759c;

        /* JADX INFO: renamed from: d */
        public int f760d;

        /* JADX INFO: renamed from: e */
        public int f761e;

        /* JADX INFO: renamed from: f */
        public int f762f;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$d */
    public static class d extends k {

        /* JADX INFO: renamed from: a */
        public int f763a;

        /* JADX INFO: renamed from: b */
        public int f764b;

        /* JADX INFO: renamed from: c */
        public int f765c;

        /* JADX INFO: renamed from: d */
        public int f766d;

        /* JADX INFO: renamed from: e */
        public int f767e;

        /* JADX INFO: renamed from: f */
        public int f768f;

        @Override // com.tencent.smtt.utils.C0448e.k
        /* JADX INFO: renamed from: a */
        public int mo736a() {
            return this.f766d;
        }

        @Override // com.tencent.smtt.utils.C0448e.k
        /* JADX INFO: renamed from: b */
        public long mo737b() {
            return this.f765c;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$e */
    public static class e extends l {

        /* JADX INFO: renamed from: a */
        public int f769a;

        /* JADX INFO: renamed from: b */
        public int f770b;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$f */
    public static class f extends a {

        /* JADX INFO: renamed from: k */
        public long f771k;

        /* JADX INFO: renamed from: l */
        public long f772l;

        /* JADX INFO: renamed from: m */
        public long f773m;

        @Override // com.tencent.smtt.utils.C0448e.a
        /* JADX INFO: renamed from: a */
        public long mo734a() {
            return this.f773m;
        }

        @Override // com.tencent.smtt.utils.C0448e.a
        /* JADX INFO: renamed from: b */
        public long mo735b() {
            return this.f772l;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$g */
    public static class g extends j {

        /* JADX INFO: renamed from: a */
        public long f774a;

        /* JADX INFO: renamed from: b */
        public long f775b;

        /* JADX INFO: renamed from: c */
        public long f776c;

        /* JADX INFO: renamed from: d */
        public long f777d;

        /* JADX INFO: renamed from: e */
        public long f778e;

        /* JADX INFO: renamed from: f */
        public long f779f;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$h */
    public static class h extends k {

        /* JADX INFO: renamed from: a */
        public long f780a;

        /* JADX INFO: renamed from: b */
        public long f781b;

        /* JADX INFO: renamed from: c */
        public long f782c;

        /* JADX INFO: renamed from: d */
        public long f783d;

        /* JADX INFO: renamed from: e */
        public long f784e;

        /* JADX INFO: renamed from: f */
        public long f785f;

        @Override // com.tencent.smtt.utils.C0448e.k
        /* JADX INFO: renamed from: a */
        public int mo736a() {
            return (int) this.f783d;
        }

        @Override // com.tencent.smtt.utils.C0448e.k
        /* JADX INFO: renamed from: b */
        public long mo737b() {
            return this.f782c;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$i */
    public static class i extends l {

        /* JADX INFO: renamed from: a */
        public long f786a;

        /* JADX INFO: renamed from: b */
        public long f787b;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$j */
    public static abstract class j {

        /* JADX INFO: renamed from: g */
        public int f788g;

        /* JADX INFO: renamed from: h */
        public int f789h;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$k */
    public static abstract class k {

        /* JADX INFO: renamed from: g */
        public int f790g;

        /* JADX INFO: renamed from: h */
        public int f791h;

        /* JADX INFO: renamed from: i */
        public int f792i;

        /* JADX INFO: renamed from: j */
        public int f793j;

        /* JADX INFO: renamed from: a */
        public abstract int mo736a();

        /* JADX INFO: renamed from: b */
        public abstract long mo737b();
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$l */
    public static abstract class l {

        /* JADX INFO: renamed from: c */
        public int f794c;

        /* JADX INFO: renamed from: d */
        public char f795d;

        /* JADX INFO: renamed from: e */
        public char f796e;

        /* JADX INFO: renamed from: f */
        public short f797f;
    }

    public C0448e(File file) throws UnknownFormatConversionException, IOException {
        a aVar;
        char[] cArr = new char[16];
        this.f735b = cArr;
        C0446c c0446c = new C0446c(file);
        this.f740g = c0446c;
        c0446c.m709a(cArr);
        if (!m729a()) {
            throw new UnknownFormatConversionException("Invalid elf magic: " + file);
        }
        c0446c.m712a(m733e());
        boolean zM732d = m732d();
        if (zM732d) {
            f fVar = new f();
            fVar.f744a = c0446c.m710a();
            fVar.f745b = c0446c.m710a();
            fVar.f746c = c0446c.m713b();
            fVar.f771k = c0446c.m714c();
            fVar.f772l = c0446c.m714c();
            fVar.f773m = c0446c.m714c();
            aVar = fVar;
        } else {
            b bVar = new b();
            bVar.f744a = c0446c.m710a();
            bVar.f745b = c0446c.m710a();
            bVar.f746c = c0446c.m713b();
            bVar.f754k = c0446c.m713b();
            bVar.f755l = c0446c.m713b();
            bVar.f756m = c0446c.m713b();
            aVar = bVar;
        }
        this.f741h = aVar;
        a aVar2 = this.f741h;
        aVar2.f747d = c0446c.m713b();
        aVar2.f748e = c0446c.m710a();
        aVar2.f749f = c0446c.m710a();
        aVar2.f750g = c0446c.m710a();
        aVar2.f751h = c0446c.m710a();
        aVar2.f752i = c0446c.m710a();
        aVar2.f753j = c0446c.m710a();
        this.f742i = new k[aVar2.f752i];
        for (int i2 = 0; i2 < aVar2.f752i; i2++) {
            c0446c.m711a(aVar2.mo734a() + ((long) (aVar2.f751h * i2)));
            if (zM732d) {
                h hVar = new h();
                hVar.f790g = c0446c.m713b();
                hVar.f791h = c0446c.m713b();
                hVar.f780a = c0446c.m714c();
                hVar.f781b = c0446c.m714c();
                hVar.f782c = c0446c.m714c();
                hVar.f783d = c0446c.m714c();
                hVar.f792i = c0446c.m713b();
                hVar.f793j = c0446c.m713b();
                hVar.f784e = c0446c.m714c();
                hVar.f785f = c0446c.m714c();
                this.f742i[i2] = hVar;
            } else {
                d dVar = new d();
                dVar.f790g = c0446c.m713b();
                dVar.f791h = c0446c.m713b();
                dVar.f763a = c0446c.m713b();
                dVar.f764b = c0446c.m713b();
                dVar.f765c = c0446c.m713b();
                dVar.f766d = c0446c.m713b();
                dVar.f792i = c0446c.m713b();
                dVar.f793j = c0446c.m713b();
                dVar.f767e = c0446c.m713b();
                dVar.f768f = c0446c.m713b();
                this.f742i[i2] = dVar;
            }
        }
        short s = aVar2.f753j;
        if (s > -1) {
            k[] kVarArr = this.f742i;
            if (s < kVarArr.length) {
                k kVar = kVarArr[s];
                if (kVar.f791h != 3) {
                    throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar2.f753j));
                }
                this.f743j = new byte[kVar.mo736a()];
                c0446c.m711a(kVar.mo737b());
                c0446c.m708a(this.f743j);
                if (this.f736c) {
                    m725f();
                    return;
                }
                return;
            }
        }
        throw new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar2.f753j));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m723a(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long j2 = randomAccessFile.readInt();
            randomAccessFile.close();
            return j2 == 2135247942;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m724b(File file) {
        StringBuilder sb;
        String str;
        if (!m726g() || !m723a(file)) {
            return true;
        }
        try {
            new C0448e(file);
            return true;
        } catch (IOException e2) {
            Log.e("ELF", "checkElfFile IOException: " + e2);
            return false;
        } catch (UnknownFormatConversionException e3) {
            e = e3;
            sb = new StringBuilder();
            str = "checkElfFile UnknownFormatConversionException: ";
            sb.append(str);
            sb.append(e);
            Log.e("ELF", sb.toString());
            return true;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "checkElfFile Throwable: ";
            sb.append(str);
            sb.append(e);
            Log.e("ELF", sb.toString());
            return true;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m725f() throws IOException {
        a aVar = this.f741h;
        C0446c c0446c = this.f740g;
        boolean zM732d = m732d();
        k kVarM727a = m727a(".dynsym");
        if (kVarM727a != null) {
            c0446c.m711a(kVarM727a.mo737b());
            int iMo736a = kVarM727a.mo736a() / (zM732d ? 24 : 16);
            this.f738e = new l[iMo736a];
            char[] cArr = new char[1];
            for (int i2 = 0; i2 < iMo736a; i2++) {
                if (zM732d) {
                    i iVar = new i();
                    iVar.f794c = c0446c.m713b();
                    c0446c.m709a(cArr);
                    iVar.f795d = cArr[0];
                    c0446c.m709a(cArr);
                    iVar.f796e = cArr[0];
                    iVar.f786a = c0446c.m714c();
                    iVar.f787b = c0446c.m714c();
                    iVar.f797f = c0446c.m710a();
                    this.f738e[i2] = iVar;
                } else {
                    e eVar = new e();
                    eVar.f794c = c0446c.m713b();
                    eVar.f769a = c0446c.m713b();
                    eVar.f770b = c0446c.m713b();
                    c0446c.m709a(cArr);
                    eVar.f795d = cArr[0];
                    c0446c.m709a(cArr);
                    eVar.f796e = cArr[0];
                    eVar.f797f = c0446c.m710a();
                    this.f738e[i2] = eVar;
                }
            }
            k kVar = this.f742i[kVarM727a.f792i];
            c0446c.m711a(kVar.mo737b());
            byte[] bArr = new byte[kVar.mo736a()];
            this.f739f = bArr;
            c0446c.m708a(bArr);
        }
        this.f737d = new j[aVar.f750g];
        for (int i3 = 0; i3 < aVar.f750g; i3++) {
            c0446c.m711a(aVar.mo735b() + ((long) (aVar.f749f * i3)));
            if (zM732d) {
                g gVar = new g();
                gVar.f788g = c0446c.m713b();
                gVar.f789h = c0446c.m713b();
                gVar.f774a = c0446c.m714c();
                gVar.f775b = c0446c.m714c();
                gVar.f776c = c0446c.m714c();
                gVar.f777d = c0446c.m714c();
                gVar.f778e = c0446c.m714c();
                gVar.f779f = c0446c.m714c();
                this.f737d[i3] = gVar;
            } else {
                c cVar = new c();
                cVar.f788g = c0446c.m713b();
                cVar.f789h = c0446c.m713b();
                cVar.f757a = c0446c.m713b();
                cVar.f758b = c0446c.m713b();
                cVar.f759c = c0446c.m713b();
                cVar.f760d = c0446c.m713b();
                cVar.f761e = c0446c.m713b();
                cVar.f762f = c0446c.m713b();
                this.f737d[i3] = cVar;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private static boolean m726g() {
        String property = System.getProperty("java.vm.version");
        return property != null && property.startsWith("2");
    }

    /* JADX INFO: renamed from: a */
    public final k m727a(String str) {
        for (k kVar : this.f742i) {
            if (str.equals(m728a(kVar.f790g))) {
                return kVar;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final String m728a(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (this.f743j[i3] != 0) {
            i3++;
        }
        return new String(this.f743j, i2, i3 - i2);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m729a() {
        return this.f735b[0] == f734a[0];
    }

    /* JADX INFO: renamed from: b */
    public final char m730b() {
        return this.f735b[4];
    }

    /* JADX INFO: renamed from: c */
    public final char m731c() {
        return this.f735b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f740g.close();
    }

    /* JADX INFO: renamed from: d */
    public final boolean m732d() {
        return m730b() == 2;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m733e() {
        return m731c() == 1;
    }
}
