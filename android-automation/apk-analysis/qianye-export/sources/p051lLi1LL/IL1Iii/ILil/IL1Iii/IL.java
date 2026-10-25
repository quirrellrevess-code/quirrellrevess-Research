package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: ExtraFieldUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Map<l, Class<?>> f5492IL1Iii = new ConcurrentHashMap();

    /* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.I丨L$IL1Iii */
    /* JADX INFO: compiled from: ExtraFieldUtils.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final IL1Iii f5493ILil = new IL1Iii(2);

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int f5494IL1Iii;

        public IL1Iii(int i) {
            this.f5494IL1Iii = i;
        }

        public int IL1Iii() {
            return this.f5494IL1Iii;
        }
    }

    static {
        Ilil(ILil.class);
        Ilil(IiL.class);
        Ilil(Ll1.class);
        Ilil(ILL.class);
        Ilil(LlLI1.class);
    }

    public static byte[] I1I(I11li1[] i11li1Arr) {
        boolean z = i11li1Arr.length > 0 && (i11li1Arr[i11li1Arr.length - 1] instanceof lIiI);
        int length = i11li1Arr.length;
        if (z) {
            length--;
        }
        int iI1I = length * 4;
        for (I11li1 i11li1 : i11li1Arr) {
            iI1I += i11li1.ILil().I1I();
        }
        byte[] bArr = new byte[iI1I];
        int length2 = 0;
        for (int i = 0; i < length; i++) {
            System.arraycopy(i11li1Arr[i].IL1Iii().IL1Iii(), 0, bArr, length2, 2);
            System.arraycopy(i11li1Arr[i].ILil().IL1Iii(), 0, bArr, length2 + 2, 2);
            byte[] bArrMo3608IL = i11li1Arr[i].mo3608IL();
            System.arraycopy(bArrMo3608IL, 0, bArr, length2 + 4, bArrMo3608IL.length);
            length2 += bArrMo3608IL.length + 4;
        }
        if (z) {
            byte[] bArrMo3608IL2 = i11li1Arr[i11li1Arr.length - 1].mo3608IL();
            System.arraycopy(bArrMo3608IL2, 0, bArr, length2, bArrMo3608IL2.length);
        }
        return bArr;
    }

    public static I11li1 IL1Iii(l lVar) throws IllegalAccessException, InstantiationException {
        Class<?> cls = f5492IL1Iii.get(lVar);
        if (cls != null) {
            return (I11li1) cls.newInstance();
        }
        C0676ILl c0676ILl = new C0676ILl();
        c0676ILl.m3621L11I(lVar);
        return c0676ILl;
    }

    public static byte[] ILil(I11li1[] i11li1Arr) {
        boolean z = i11li1Arr.length > 0 && (i11li1Arr[i11li1Arr.length - 1] instanceof lIiI);
        int length = i11li1Arr.length;
        if (z) {
            length--;
        }
        int iI1I = length * 4;
        for (I11li1 i11li1 : i11li1Arr) {
            iI1I += i11li1.mo3609lLi1LL().I1I();
        }
        byte[] bArr = new byte[iI1I];
        int length2 = 0;
        for (int i = 0; i < length; i++) {
            System.arraycopy(i11li1Arr[i].IL1Iii().IL1Iii(), 0, bArr, length2, 2);
            System.arraycopy(i11li1Arr[i].mo3609lLi1LL().IL1Iii(), 0, bArr, length2 + 2, 2);
            byte[] bArrIlil = i11li1Arr[i].Ilil();
            System.arraycopy(bArrIlil, 0, bArr, length2 + 4, bArrIlil.length);
            length2 += bArrIlil.length + 4;
        }
        if (z) {
            byte[] bArrIlil2 = i11li1Arr[i11li1Arr.length - 1].Ilil();
            System.arraycopy(bArrIlil2, 0, bArr, length2, bArrIlil2.length);
        }
        return bArr;
    }

    public static void Ilil(Class<?> cls) {
        try {
            f5492IL1Iii.put(((I11li1) cls.newInstance()).IL1Iii(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException unused3) {
            throw new RuntimeException(cls + " is not a concrete class");
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static I11li1[] m3623IL(byte[] bArr, boolean z, IL1Iii iL1Iii) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= bArr.length - 4) {
            l lVar = new l(bArr, i);
            int iI1I = new l(bArr, i + 2).I1I();
            int i2 = i + 4;
            if (i2 + iI1I > bArr.length) {
                int iIL1Iii = iL1Iii.IL1Iii();
                if (iIL1Iii == 0) {
                    StringBuilder sb = new StringBuilder("bad extra field starting at ");
                    sb.append(i);
                    sb.append(".  Block length of ");
                    sb.append(iI1I);
                    sb.append(" bytes exceeds remaining");
                    sb.append(" data of ");
                    sb.append((bArr.length - i) - 4);
                    sb.append(" bytes.");
                    throw new ZipException(sb.toString());
                }
                if (iIL1Iii == 1) {
                    break;
                }
                if (iIL1Iii != 2) {
                    throw new ZipException("unknown UnparseableExtraField key: " + iL1Iii.IL1Iii());
                }
                lIiI liii = new lIiI();
                if (z) {
                    liii.I1I(bArr, i, bArr.length - i);
                } else {
                    liii.mo3610iILLL1(bArr, i, bArr.length - i);
                }
                arrayList.add(liii);
                break;
            }
            try {
                I11li1 i11li1IL1Iii = IL1Iii(lVar);
                if (z || !(i11li1IL1Iii instanceof I1I)) {
                    i11li1IL1Iii.I1I(bArr, i2, iI1I);
                } else {
                    ((I1I) i11li1IL1Iii).mo3610iILLL1(bArr, i2, iI1I);
                }
                arrayList.add(i11li1IL1Iii);
                i += iI1I + 4;
            } catch (IllegalAccessException e) {
                throw new ZipException(e.getMessage());
            } catch (InstantiationException e2) {
                throw new ZipException(e2.getMessage());
            }
        }
        return (I11li1[]) arrayList.toArray(new I11li1[arrayList.size()]);
    }
}
