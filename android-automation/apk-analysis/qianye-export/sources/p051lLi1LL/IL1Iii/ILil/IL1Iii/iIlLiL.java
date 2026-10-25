package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: ZipEntry.java */
/* JADX INFO: loaded from: classes.dex */
public class iIlLiL extends ZipEntry implements Cloneable {
    public static final byte[] ILL = new byte[0];

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long f5509I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f5510ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5511Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f3016IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public lIiI f3017IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public String f3018L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public LinkedHashMap<l, I11li1> f3019iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public long f3020lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public iILLL1 f3021il;

    public iIlLiL(String str) {
        super(str);
        this.f5510ILil = -1;
        this.f5509I1I = -1L;
        this.f3016IL = 0;
        this.f5511Ilil = 0;
        this.f3020lLi1LL = 0L;
        this.f3019iILLL1 = null;
        this.f3017IiL = null;
        this.f3018L11I = null;
        this.f3021il = new iILLL1();
        m3636lIlii(str);
    }

    public long I1I() {
        return this.f3020lLi1LL;
    }

    public void IL1Iii(I11li1 i11li1) {
        if (i11li1 instanceof lIiI) {
            this.f3017IiL = (lIiI) i11li1;
        } else {
            if (this.f3019iILLL1 == null) {
                this.f3019iILLL1 = new LinkedHashMap<>();
            }
            this.f3019iILLL1.put(i11li1.IL1Iii(), i11li1);
        }
        m3630ILl();
    }

    public final void ILL(I11li1[] i11li1Arr, boolean z) throws ZipException {
        if (this.f3019iILLL1 == null) {
            Lil(i11li1Arr);
            return;
        }
        for (I11li1 i11li1 : i11li1Arr) {
            I11li1 i11li1M3631IL = i11li1 instanceof lIiI ? this.f3017IiL : m3631IL(i11li1.IL1Iii());
            if (i11li1M3631IL == null) {
                IL1Iii(i11li1);
            } else if (z || !(i11li1M3631IL instanceof I1I)) {
                byte[] bArrMo3608IL = i11li1.mo3608IL();
                i11li1M3631IL.I1I(bArrMo3608IL, 0, bArrMo3608IL.length);
            } else {
                byte[] bArrIlil = i11li1.Ilil();
                ((I1I) i11li1M3631IL).mo3610iILLL1(bArrIlil, 0, bArrIlil.length);
            }
        }
        m3630ILl();
    }

    public byte[] ILil() {
        return IL.ILil(Ilil(true));
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m3630ILl() {
        super.setExtra(IL.I1I(Ilil(true)));
    }

    public I11li1[] Ilil(boolean z) {
        lIiI liii;
        lIiI liii2;
        if (this.f3019iILLL1 == null) {
            return (!z || (liii2 = this.f3017IiL) == null) ? new I11li1[0] : new I11li1[]{liii2};
        }
        ArrayList arrayList = new ArrayList(this.f3019iILLL1.values());
        if (z && (liii = this.f3017IiL) != null) {
            arrayList.add(liii);
        }
        return (I11li1[]) arrayList.toArray(new I11li1[0]);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public I11li1 m3631IL(l lVar) {
        LinkedHashMap<l, I11li1> linkedHashMap = this.f3019iILLL1;
        if (linkedHashMap != null) {
            return linkedHashMap.get(lVar);
        }
        return null;
    }

    public void Lil(I11li1[] i11li1Arr) {
        this.f3019iILLL1 = new LinkedHashMap<>();
        for (I11li1 i11li1 : i11li1Arr) {
            if (i11li1 instanceof lIiI) {
                this.f3017IiL = (lIiI) i11li1;
            } else {
                this.f3019iILLL1.put(i11li1.IL1Iii(), i11li1);
            }
        }
        m3630ILl();
    }

    public void LlLI1(iILLL1 iilll1) {
        this.f3021il = iilll1;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m3632Ll1(byte[] bArr) {
        try {
            ILL(IL.m3623IL(bArr, false, IL.IL1Iii.f5493ILil), false);
        } catch (ZipException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public byte[] m3633L11I() {
        byte[] extra = getExtra();
        return extra != null ? extra : ILL;
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        iIlLiL iillil = (iIlLiL) super.clone();
        iillil.m3637llL1ii(m3634iILLL1());
        iillil.m3635lIiI(I1I());
        iillil.Lil(Ilil(true));
        return iillil;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && iIlLiL.class == obj.getClass()) {
            iIlLiL iillil = (iIlLiL) obj;
            String name = getName();
            String name2 = iillil.getName();
            if (name == null) {
                if (name2 != null) {
                    return false;
                }
            } else if (!name.equals(name2)) {
                return false;
            }
            String comment = getComment();
            String comment2 = iillil.getComment();
            if (comment == null) {
                comment = BuildConfig.FLAVOR;
            }
            if (comment2 == null) {
                comment2 = BuildConfig.FLAVOR;
            }
            if (getTime() == iillil.getTime() && comment.equals(comment2) && m3634iILLL1() == iillil.m3634iILLL1() && m3639il() == iillil.m3639il() && I1I() == iillil.I1I() && getMethod() == iillil.getMethod() && getSize() == iillil.getSize() && getCrc() == iillil.getCrc() && getCompressedSize() == iillil.getCompressedSize() && Arrays.equals(ILil(), iillil.ILil()) && Arrays.equals(m3633L11I(), iillil.m3633L11I()) && this.f3021il.equals(iillil.f3021il)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.f5510ILil;
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String str = this.f3018L11I;
        return str == null ? super.getName() : str;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.f5509I1I;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    public void iIi1(String str, byte[] bArr) {
        m3636lIlii(str);
    }

    public void iIlLiL(int i) {
        this.f5511Ilil = i;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m3634iILLL1() {
        return this.f3016IL;
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith("/");
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3635lIiI(long j) {
        this.f3020lLi1LL = j;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m3636lIlii(String str) {
        if (str != null && m3639il() == 0 && str.indexOf("/") == -1) {
            str = str.replace(StringUtils.WILDCARD_ESCAPE, '/');
        }
        this.f3018L11I = str;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m3637llL1ii(int i) {
        this.f3016IL = i;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public iILLL1 m3638lLi1LL() {
        return this.f3021il;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            ILL(IL.m3623IL(bArr, true, IL.IL1Iii.f5493ILil), true);
        } catch (ZipException e) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i) {
        if (i >= 0) {
            this.f5510ILil = i;
        } else {
            throw new IllegalArgumentException("ZIP compression method can not be negative: " + i);
        }
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid entry size");
        }
        this.f5509I1I = j;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m3639il() {
        return this.f5511Ilil;
    }

    public iIlLiL() {
        this(BuildConfig.FLAVOR);
    }
}
