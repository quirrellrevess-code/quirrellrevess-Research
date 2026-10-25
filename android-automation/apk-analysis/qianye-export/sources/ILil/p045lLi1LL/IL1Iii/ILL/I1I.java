package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.C0651il;
import ILil.p045lLi1LL.IL1Iii.ILil;
import ILil.p045lLi1LL.IL1Iii.lLi1LL;
import java.util.ArrayList;

/* JADX INFO: compiled from: Chain.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {
    public static void IL1Iii(IiL iiL, lLi1LL lli1ll, int i) {
        int i2;
        int i3;
        IL[] ilArr;
        if (i == 0) {
            int i4 = iiL.Liil1L1l;
            ilArr = iiL.f1897iI1LI;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = iiL.f9LL;
            ilArr = iiL.f1898i1I1I1l;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            IL il = ilArr[i5];
            il.IL1Iii();
            if (!iiL.m2609LL(4)) {
                ILil(iiL, lli1ll, i, i2, il);
            } else if (!Ll1.ILil(iiL, lli1ll, i, i2, il)) {
                ILil(iiL, lli1ll, i, i2, il);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:25:0x0042 A[PHI: r14 r15
  0x0042: PHI (r14v3 boolean) = (r14v1 boolean), (r14v28 boolean) binds: [B:24:0x0040, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0042: PHI (r15v3 boolean) = (r15v1 boolean), (r15v36 boolean) binds: [B:24:0x0040, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0044 A[PHI: r14 r15
  0x0044: PHI (r14v26 boolean) = (r14v1 boolean), (r14v28 boolean) binds: [B:24:0x0040, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0044: PHI (r15v34 boolean) = (r15v1 boolean), (r15v36 boolean) binds: [B:24:0x0040, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x0146  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [ILil.l丨Li1LL.IL1Iii.l丨Li1LL] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30, types: [ILil.l丨Li1LL.IL1Iii.丨il] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [ILil.l丨Li1LL.IL1Iii.ILL.iI丨LLL1] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    public static void ILil(IiL iiL, lLi1LL lli1ll, int i, int i2, IL il) {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        int i3;
        int i4;
        C0651il c0651il;
        lLi1LL lli1ll2;
        C0651il c0651il2;
        lLi1LL lli1ll3;
        C0651il c0651il3;
        C0651il c0651il4;
        ?? r5;
        C0651il c0651il5;
        int size;
        int i5;
        int i6;
        iILLL1 iilll1 = il.f4487IL1Iii;
        iILLL1 iilll2 = il.f4486I1I;
        iILLL1 iilll3 = il.f4488ILil;
        iILLL1 iilll4 = il.f1887IL;
        iILLL1 iilll5 = il.f4489Ilil;
        float f = il.ILL;
        iILLL1 iilll6 = il.f1894lLi1LL;
        iILLL1 iilll7 = il.f1891iILLL1;
        boolean z4 = iiL.LL1IL[i] == iILLL1.ILil.WRAP_CONTENT;
        if (i == 0) {
            int i7 = iilll5.f1932iiIIi11;
            z = i7 == 0;
            z2 = i7 == 1;
            if (i7 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            int i8 = iilll5.f1931iILilI;
            z = i8 == 0;
            z2 = i8 == 1;
            if (i8 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        ?? r7 = iilll1;
        boolean z5 = false;
        while (true) {
            obj = null;
            if (z5) {
                break;
            }
            lLi1LL lli1ll4 = r7.f1928LlLLL[i2];
            int i9 = (z4 || z3) ? 1 : 4;
            int iM2681IL = lli1ll4.m2681IL();
            float f2 = f;
            lLi1LL lli1ll5 = lli1ll4.f1959IL;
            if (lli1ll5 != null && r7 != iilll1) {
                iM2681IL += lli1ll5.m2681IL();
            }
            int i10 = iM2681IL;
            if (!z3 || r7 == iilll1 || r7 == iilll3) {
                i5 = (z && z4) ? 4 : i9;
            } else {
                i5 = 6;
            }
            lLi1LL lli1ll6 = lli1ll4.f1959IL;
            if (lli1ll6 != null) {
                if (r7 == iilll3) {
                    lli1ll.m2710L11I(lli1ll4.f1961L11I, lli1ll6.f1961L11I, i10, 5);
                } else {
                    lli1ll.m2710L11I(lli1ll4.f1961L11I, lli1ll6.f1961L11I, i10, 6);
                }
                lli1ll.Ilil(lli1ll4.f1961L11I, lli1ll4.f1959IL.f1961L11I, i10, i5);
            } else {
                iilll5 = iilll5;
                z = z;
            }
            if (z4) {
                if (r7.LL1IL() == 8 || r7.LL1IL[i] != iILLL1.ILil.MATCH_CONSTRAINT) {
                    i6 = 0;
                } else {
                    lLi1LL[] lli1llArr = r7.f1928LlLLL;
                    i6 = 0;
                    lli1ll.m2710L11I(lli1llArr[i2 + 1].f1961L11I, lli1llArr[i2].f1961L11I, 0, 5);
                }
                lli1ll.m2710L11I(r7.f1928LlLLL[i2].f1961L11I, iiL.f1928LlLLL[i2].f1961L11I, i6, 6);
            }
            lLi1LL lli1ll7 = r7.f1928LlLLL[i2 + 1].f1959IL;
            if (lli1ll7 != null) {
                iILLL1 iilll8 = lli1ll7.f4516ILil;
                lLi1LL[] lli1llArr2 = iilll8.f1928LlLLL;
                if (lli1llArr2[i2].f1959IL != null && lli1llArr2[i2].f1959IL.f4516ILil == r7) {
                    obj = iilll8;
                }
            }
            if (obj != null) {
                r7 = obj;
                z5 = z5;
            } else {
                z5 = true;
            }
            z2 = z2;
            f = f2;
            z = z;
            iilll5 = iilll5;
            r7 = r7;
        }
        iILLL1 iilll9 = iilll5;
        float f3 = f;
        boolean z6 = z;
        boolean z7 = z2;
        if (iilll4 != null) {
            lLi1LL[] lli1llArr3 = iilll2.f1928LlLLL;
            int i11 = i2 + 1;
            if (lli1llArr3[i11].f1959IL != null) {
                lLi1LL lli1ll8 = iilll4.f1928LlLLL[i11];
                lli1ll.ILL(lli1ll8.f1961L11I, lli1llArr3[i11].f1959IL.f1961L11I, -lli1ll8.m2681IL(), 5);
            }
        }
        if (z4) {
            int i12 = i2 + 1;
            C0651il c0651il6 = iiL.f1928LlLLL[i12].f1961L11I;
            lLi1LL[] lli1llArr4 = iilll2.f1928LlLLL;
            lli1ll.m2710L11I(c0651il6, lli1llArr4[i12].f1961L11I, lli1llArr4[i12].m2681IL(), 6);
        }
        ArrayList<iILLL1> arrayList = il.f1888IiL;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f4 = (!il.f1886ILl || il.LlLI1) ? f3 : il.f1895il;
            float f5 = 0.0f;
            iILLL1 iilll10 = null;
            int i13 = 0;
            float f6 = 0.0f;
            while (i13 < size) {
                iILLL1 iilll11 = arrayList.get(i13);
                float f7 = iilll11.f14I1[i];
                if (f7 < f5) {
                    if (il.LlLI1) {
                        lLi1LL[] lli1llArr5 = iilll11.f1928LlLLL;
                        lli1ll.Ilil(lli1llArr5[i2 + 1].f1961L11I, lli1llArr5[i2].f1961L11I, 0, 4);
                    } else {
                        f7 = 1.0f;
                        f5 = 0.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i13++;
                    size = size;
                    arrayList = arrayList;
                    f5 = 0.0f;
                }
                if (f7 == f5) {
                    lLi1LL[] lli1llArr6 = iilll11.f1928LlLLL;
                    lli1ll.Ilil(lli1llArr6[i2 + 1].f1961L11I, lli1llArr6[i2].f1961L11I, 0, 6);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (iilll10 != null) {
                        lLi1LL[] lli1llArr7 = iilll10.f1928LlLLL;
                        C0651il c0651il7 = lli1llArr7[i2].f1961L11I;
                        int i14 = i2 + 1;
                        C0651il c0651il8 = lli1llArr7[i14].f1961L11I;
                        lLi1LL[] lli1llArr8 = iilll11.f1928LlLLL;
                        C0651il c0651il9 = lli1llArr8[i2].f1961L11I;
                        C0651il c0651il10 = lli1llArr8[i14].f1961L11I;
                        ILil iLilIIi1 = lli1ll.iIi1();
                        iLilIIi1.ILL(f6, f4, f7, c0651il7, c0651il8, c0651il9, c0651il10);
                        lli1ll.m2706IL(iLilIIi1);
                    }
                    f6 = f7;
                    iilll10 = iilll11;
                }
                i13++;
                size = size;
                arrayList = arrayList;
                f5 = 0.0f;
            }
        }
        if (iilll3 != null && (iilll3 == iilll4 || z3)) {
            lLi1LL[] lli1llArr9 = iilll1.f1928LlLLL;
            lLi1LL lli1ll9 = lli1llArr9[i2];
            lLi1LL[] lli1llArr10 = iilll2.f1928LlLLL;
            int i15 = i2 + 1;
            lLi1LL lli1ll10 = lli1llArr10[i15];
            C0651il c0651il11 = lli1llArr9[i2].f1959IL != null ? lli1llArr9[i2].f1959IL.f1961L11I : null;
            C0651il c0651il12 = lli1llArr10[i15].f1959IL != null ? lli1llArr10[i15].f1959IL.f1961L11I : null;
            if (iilll3 == iilll4) {
                lLi1LL[] lli1llArr11 = iilll3.f1928LlLLL;
                lli1ll9 = lli1llArr11[i2];
                lli1ll10 = lli1llArr11[i15];
            }
            if (c0651il11 != null && c0651il12 != null) {
                lli1ll.I1I(lli1ll9.f1961L11I, c0651il11, lli1ll9.m2681IL(), i == 0 ? iilll9.f1914ILLIi : iilll9.f1942li11, c0651il12, lli1ll10.f1961L11I, lli1ll10.m2681IL(), 5);
            }
        } else if (!z6 || iilll3 == null) {
            int i16 = 8;
            if (z7 && iilll3 != null) {
                int i17 = il.f1895il;
                boolean z8 = i17 > 0 && il.f1890L11I == i17;
                iILLL1 iilll12 = iilll3;
                iILLL1 iilll13 = iilll12;
                while (iilll12 != null) {
                    iILLL1 iilll14 = iilll12.L1iI1[i];
                    while (iilll14 != null && iilll14.LL1IL() == i16) {
                        iilll14 = iilll14.L1iI1[i];
                    }
                    if (iilll12 == iilll3 || iilll12 == iilll4 || iilll14 == null) {
                        iilll13 = iilll13;
                        i4 = 8;
                    } else {
                        iILLL1 iilll15 = iilll14 == iilll4 ? null : iilll14;
                        lLi1LL lli1ll11 = iilll12.f1928LlLLL[i2];
                        C0651il c0651il13 = lli1ll11.f1961L11I;
                        lLi1LL lli1ll12 = lli1ll11.f1959IL;
                        if (lli1ll12 != null) {
                            C0651il c0651il14 = lli1ll12.f1961L11I;
                        }
                        int i18 = i2 + 1;
                        C0651il c0651il15 = iilll13.f1928LlLLL[i18].f1961L11I;
                        int iM2681IL2 = lli1ll11.m2681IL();
                        int iM2681IL3 = iilll12.f1928LlLLL[i18].m2681IL();
                        if (iilll15 != null) {
                            lli1ll2 = iilll15.f1928LlLLL[i2];
                            c0651il2 = lli1ll2.f1961L11I;
                            lLi1LL lli1ll13 = lli1ll2.f1959IL;
                            c0651il = lli1ll13 != null ? lli1ll13.f1961L11I : null;
                        } else {
                            lLi1LL[] lli1llArr12 = iilll12.f1928LlLLL;
                            lLi1LL lli1ll14 = lli1llArr12[i18].f1959IL;
                            C0651il c0651il16 = lli1ll14 != null ? lli1ll14.f1961L11I : null;
                            c0651il = lli1llArr12[i18].f1961L11I;
                            lli1ll2 = lli1ll14;
                            c0651il2 = c0651il16;
                        }
                        if (lli1ll2 != null) {
                            iM2681IL3 += lli1ll2.m2681IL();
                        }
                        int i19 = iM2681IL3;
                        if (iilll13 != null) {
                            iM2681IL2 += iilll13.f1928LlLLL[i18].m2681IL();
                        }
                        int i20 = iM2681IL2;
                        int i21 = z8 ? 6 : 4;
                        if (c0651il13 == null || c0651il15 == null || c0651il2 == null || c0651il == null) {
                            i4 = 8;
                        } else {
                            i4 = 8;
                            lli1ll.I1I(c0651il13, c0651il15, i20, 0.5f, c0651il2, c0651il, i19, i21);
                        }
                        iilll14 = iilll15;
                    }
                    if (iilll12.LL1IL() == i4) {
                        iilll12 = iilll13;
                    }
                    iilll13 = iilll12;
                    i16 = 8;
                    iilll12 = iilll14;
                }
                lLi1LL lli1ll15 = iilll3.f1928LlLLL[i2];
                lLi1LL lli1ll16 = iilll1.f1928LlLLL[i2].f1959IL;
                int i22 = i2 + 1;
                lLi1LL lli1ll17 = iilll4.f1928LlLLL[i22];
                lLi1LL lli1ll18 = iilll2.f1928LlLLL[i22].f1959IL;
                if (lli1ll16 == null) {
                    i3 = 5;
                } else if (iilll3 != iilll4) {
                    i3 = 5;
                    lli1ll.Ilil(lli1ll15.f1961L11I, lli1ll16.f1961L11I, lli1ll15.m2681IL(), 5);
                } else {
                    i3 = 5;
                    if (lli1ll18 != null) {
                        lli1ll.I1I(lli1ll15.f1961L11I, lli1ll16.f1961L11I, lli1ll15.m2681IL(), 0.5f, lli1ll17.f1961L11I, lli1ll18.f1961L11I, lli1ll17.m2681IL(), 5);
                    }
                }
                if (lli1ll18 != null && iilll3 != iilll4) {
                    lli1ll.Ilil(lli1ll17.f1961L11I, lli1ll18.f1961L11I, -lli1ll17.m2681IL(), i3);
                }
            }
        } else {
            int i23 = il.f1895il;
            boolean z9 = i23 > 0 && il.f1890L11I == i23;
            iILLL1 iilll16 = iilll3;
            iILLL1 iilll17 = iilll16;
            while (iilll16 != null) {
                iILLL1 iilll18 = iilll16.L1iI1[i];
                while (iilll18 != null && iilll18.LL1IL() == 8) {
                    iilll18 = iilll18.L1iI1[i];
                }
                if (iilll18 != null || iilll16 == iilll4) {
                    lLi1LL lli1ll19 = iilll16.f1928LlLLL[i2];
                    C0651il c0651il17 = lli1ll19.f1961L11I;
                    lLi1LL lli1ll20 = lli1ll19.f1959IL;
                    C0651il c0651il18 = lli1ll20 != null ? lli1ll20.f1961L11I : null;
                    if (iilll17 != iilll16) {
                        c0651il18 = iilll17.f1928LlLLL[i2 + 1].f1961L11I;
                    } else if (iilll16 == iilll3 && iilll17 == iilll16) {
                        lLi1LL[] lli1llArr13 = iilll1.f1928LlLLL;
                        c0651il18 = lli1llArr13[i2].f1959IL != null ? lli1llArr13[i2].f1959IL.f1961L11I : null;
                    }
                    int iM2681IL4 = lli1ll19.m2681IL();
                    int i24 = i2 + 1;
                    int iM2681IL5 = iilll16.f1928LlLLL[i24].m2681IL();
                    if (iilll18 != null) {
                        lli1ll3 = iilll18.f1928LlLLL[i2];
                        C0651il c0651il19 = lli1ll3.f1961L11I;
                        c0651il4 = iilll16.f1928LlLLL[i24].f1961L11I;
                        c0651il3 = c0651il19;
                    } else {
                        lli1ll3 = iilll2.f1928LlLLL[i24].f1959IL;
                        c0651il3 = lli1ll3 != null ? lli1ll3.f1961L11I : null;
                        c0651il4 = iilll16.f1928LlLLL[i24].f1961L11I;
                    }
                    if (lli1ll3 != null) {
                        iM2681IL5 += lli1ll3.m2681IL();
                    }
                    if (iilll17 != null) {
                        iM2681IL4 += iilll17.f1928LlLLL[i24].m2681IL();
                    }
                    if (c0651il17 != null && c0651il18 != null && c0651il3 != null && c0651il4 != null) {
                        if (iilll16 == iilll3) {
                            iM2681IL4 = iilll3.f1928LlLLL[i2].m2681IL();
                        }
                        lli1ll.I1I(c0651il17, c0651il18, iM2681IL4, 0.5f, c0651il3, c0651il4, iilll16 == iilll4 ? iilll4.f1928LlLLL[i24].m2681IL() : iM2681IL5, z9 ? 6 : 4);
                    }
                }
                if (iilll16.LL1IL() != 8) {
                    iilll17 = iilll16;
                }
                iilll16 = iilll18;
            }
        }
        if ((z6 || z7) && iilll3 != null) {
            lLi1LL[] lli1llArr14 = iilll3.f1928LlLLL;
            lLi1LL lli1ll21 = lli1llArr14[i2];
            int i25 = i2 + 1;
            lLi1LL lli1ll22 = iilll4.f1928LlLLL[i25];
            lLi1LL lli1ll23 = lli1ll21.f1959IL;
            C0651il c0651il20 = lli1ll23 != null ? lli1ll23.f1961L11I : null;
            lLi1LL lli1ll24 = lli1ll22.f1959IL;
            if (lli1ll24 != null) {
                c0651il5 = lli1ll24.f1961L11I;
            } else {
                r5 = 0;
            }
            if (iilll2 != iilll4) {
                lLi1LL lli1ll25 = iilll2.f1928LlLLL[i25].f1959IL;
                if (lli1ll25 != null) {
                    r5 = c0651il5;
                    obj = lli1ll25.f1961L11I;
                }
                r5 = c0651il5;
                r5 = obj;
            }
            if (iilll3 == iilll4) {
                lli1ll21 = lli1llArr14[i2];
                lli1ll22 = lli1llArr14[i25];
            }
            if (c0651il20 == null || r5 == 0) {
                return;
            }
            int iM2681IL6 = lli1ll21.m2681IL();
            if (iilll4 != null) {
                iilll2 = iilll4;
            }
            lli1ll.I1I(lli1ll21.f1961L11I, c0651il20, iM2681IL6, 0.5f, r5, lli1ll22.f1961L11I, iilll2.f1928LlLLL[i25].m2681IL(), 5);
        }
    }
}
