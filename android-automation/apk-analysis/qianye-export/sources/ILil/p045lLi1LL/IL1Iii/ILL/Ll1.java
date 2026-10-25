package ILil.p045lLi1LL.IL1Iii.ILL;

import ILil.p045lLi1LL.IL1Iii.iILLL1;
import ILil.p045lLi1LL.IL1Iii.lLi1LL;

/* JADX INFO: renamed from: ILil.l丨Li1LL.IL1Iii.ILL.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: Optimizer.java */
/* JADX INFO: loaded from: classes.dex */
public class Ll1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static boolean[] f4500IL1Iii = new boolean[3];

    public static void I1I(IiL iiL, lLi1LL lli1ll, iILLL1 iilll1) {
        iILLL1.ILil iLil = iiL.LL1IL[0];
        iILLL1.ILil iLil2 = iILLL1.ILil.WRAP_CONTENT;
        if (iLil != iLil2 && iilll1.LL1IL[0] == iILLL1.ILil.MATCH_PARENT) {
            int i = iilll1.iIi1.f4517Ilil;
            int iM2629L111 = iiL.m2629L111() - iilll1.I11li1.f4517Ilil;
            lLi1LL lli1ll2 = iilll1.iIi1;
            lli1ll2.f1961L11I = lli1ll.m2715lIlii(lli1ll2);
            lLi1LL lli1ll3 = iilll1.I11li1;
            lli1ll3.f1961L11I = lli1ll.m2715lIlii(lli1ll3);
            lli1ll.m2717lLi1LL(iilll1.iIi1.f1961L11I, i);
            lli1ll.m2717lLi1LL(iilll1.I11li1.f1961L11I, iM2629L111);
            iilll1.f4506IL1Iii = 2;
            iilll1.m2642iILilI(i, iM2629L111);
        }
        if (iiL.LL1IL[1] == iLil2 || iilll1.LL1IL[1] != iILLL1.ILil.MATCH_PARENT) {
            return;
        }
        int i2 = iilll1.iIlLiL.f4517Ilil;
        int iM2653lIlii = iiL.m2653lIlii() - iilll1.f1946lL.f4517Ilil;
        lLi1LL lli1ll4 = iilll1.iIlLiL;
        lli1ll4.f1961L11I = lli1ll.m2715lIlii(lli1ll4);
        lLi1LL lli1ll5 = iilll1.f1946lL;
        lli1ll5.f1961L11I = lli1ll.m2715lIlii(lli1ll5);
        lli1ll.m2717lLi1LL(iilll1.iIlLiL.f1961L11I, i2);
        lli1ll.m2717lLi1LL(iilll1.f1946lL.f1961L11I, iM2653lIlii);
        if (iilll1.f1913IIiI > 0 || iilll1.LL1IL() == 8) {
            lLi1LL lli1ll6 = iilll1.I11L;
            lli1ll6.f1961L11I = lli1ll.m2715lIlii(lli1ll6);
            lli1ll.m2717lLi1LL(iilll1.I11L.f1961L11I, iilll1.f1913IIiI + i2);
        }
        iilll1.f4507ILil = 2;
        iilll1.m85LL(i2, iM2653lIlii);
    }

    public static void IL1Iii(int i, iILLL1 iilll1) {
        iilll1.iIlL1();
        lIiI liiiM2687lLi1LL = iilll1.iIi1.m2687lLi1LL();
        lIiI liiiM2687lLi1LL2 = iilll1.iIlLiL.m2687lLi1LL();
        lIiI liiiM2687lLi1LL3 = iilll1.I11li1.m2687lLi1LL();
        lIiI liiiM2687lLi1LL4 = iilll1.f1946lL.m2687lLi1LL();
        boolean z = (i & 8) == 8;
        iILLL1.ILil iLil = iilll1.LL1IL[0];
        iILLL1.ILil iLil2 = iILLL1.ILil.MATCH_CONSTRAINT;
        boolean z2 = iLil == iLil2 && m2620IL(iilll1, 0);
        if (liiiM2687lLi1LL.f1952IiL != 4 && liiiM2687lLi1LL3.f1952IiL != 4) {
            if (iilll1.LL1IL[0] == iILLL1.ILil.FIXED || (z2 && iilll1.LL1IL() == 8)) {
                lLi1LL lli1ll = iilll1.iIi1.f1959IL;
                if (lli1ll == null && iilll1.I11li1.f1959IL == null) {
                    liiiM2687lLi1LL.LlLI1(1);
                    liiiM2687lLi1LL3.LlLI1(1);
                    if (z) {
                        liiiM2687lLi1LL3.m2676il(liiiM2687lLi1LL, 1, iilll1.llliI());
                    } else {
                        liiiM2687lLi1LL3.m2672L11I(liiiM2687lLi1LL, iilll1.m2629L111());
                    }
                } else if (lli1ll != null && iilll1.I11li1.f1959IL == null) {
                    liiiM2687lLi1LL.LlLI1(1);
                    liiiM2687lLi1LL3.LlLI1(1);
                    if (z) {
                        liiiM2687lLi1LL3.m2676il(liiiM2687lLi1LL, 1, iilll1.llliI());
                    } else {
                        liiiM2687lLi1LL3.m2672L11I(liiiM2687lLi1LL, iilll1.m2629L111());
                    }
                } else if (lli1ll == null && iilll1.I11li1.f1959IL != null) {
                    liiiM2687lLi1LL.LlLI1(1);
                    liiiM2687lLi1LL3.LlLI1(1);
                    liiiM2687lLi1LL.m2672L11I(liiiM2687lLi1LL3, -iilll1.m2629L111());
                    if (z) {
                        liiiM2687lLi1LL.m2676il(liiiM2687lLi1LL3, -1, iilll1.llliI());
                    } else {
                        liiiM2687lLi1LL.m2672L11I(liiiM2687lLi1LL3, -iilll1.m2629L111());
                    }
                } else if (lli1ll != null && iilll1.I11li1.f1959IL != null) {
                    liiiM2687lLi1LL.LlLI1(2);
                    liiiM2687lLi1LL3.LlLI1(2);
                    if (z) {
                        iilll1.llliI().IL1Iii(liiiM2687lLi1LL);
                        iilll1.llliI().IL1Iii(liiiM2687lLi1LL3);
                        liiiM2687lLi1LL.Lil(liiiM2687lLi1LL3, -1, iilll1.llliI());
                        liiiM2687lLi1LL3.Lil(liiiM2687lLi1LL, 1, iilll1.llliI());
                    } else {
                        liiiM2687lLi1LL.m2669ILl(liiiM2687lLi1LL3, -iilll1.m2629L111());
                        liiiM2687lLi1LL3.m2669ILl(liiiM2687lLi1LL, iilll1.m2629L111());
                    }
                }
            } else if (z2) {
                int iM2629L111 = iilll1.m2629L111();
                liiiM2687lLi1LL.LlLI1(1);
                liiiM2687lLi1LL3.LlLI1(1);
                lLi1LL lli1ll2 = iilll1.iIi1.f1959IL;
                if (lli1ll2 == null && iilll1.I11li1.f1959IL == null) {
                    if (z) {
                        liiiM2687lLi1LL3.m2676il(liiiM2687lLi1LL, 1, iilll1.llliI());
                    } else {
                        liiiM2687lLi1LL3.m2672L11I(liiiM2687lLi1LL, iM2629L111);
                    }
                } else if (lli1ll2 == null || iilll1.I11li1.f1959IL != null) {
                    if (lli1ll2 != null || iilll1.I11li1.f1959IL == null) {
                        if (lli1ll2 != null && iilll1.I11li1.f1959IL != null) {
                            if (z) {
                                iilll1.llliI().IL1Iii(liiiM2687lLi1LL);
                                iilll1.llliI().IL1Iii(liiiM2687lLi1LL3);
                            }
                            if (iilll1.llI == 0.0f) {
                                liiiM2687lLi1LL.LlLI1(3);
                                liiiM2687lLi1LL3.LlLI1(3);
                                liiiM2687lLi1LL.m2669ILl(liiiM2687lLi1LL3, 0.0f);
                                liiiM2687lLi1LL3.m2669ILl(liiiM2687lLi1LL, 0.0f);
                            } else {
                                liiiM2687lLi1LL.LlLI1(2);
                                liiiM2687lLi1LL3.LlLI1(2);
                                liiiM2687lLi1LL.m2669ILl(liiiM2687lLi1LL3, -iM2629L111);
                                liiiM2687lLi1LL3.m2669ILl(liiiM2687lLi1LL, iM2629L111);
                                iilll1.ILI1Ll(iM2629L111);
                            }
                        }
                    } else if (z) {
                        liiiM2687lLi1LL.m2676il(liiiM2687lLi1LL3, -1, iilll1.llliI());
                    } else {
                        liiiM2687lLi1LL.m2672L11I(liiiM2687lLi1LL3, -iM2629L111);
                    }
                } else if (z) {
                    liiiM2687lLi1LL3.m2676il(liiiM2687lLi1LL, 1, iilll1.llliI());
                } else {
                    liiiM2687lLi1LL3.m2672L11I(liiiM2687lLi1LL, iM2629L111);
                }
            }
        }
        boolean z3 = iilll1.LL1IL[1] == iLil2 && m2620IL(iilll1, 1);
        if (liiiM2687lLi1LL2.f1952IiL == 4 || liiiM2687lLi1LL4.f1952IiL == 4) {
            return;
        }
        if (iilll1.LL1IL[1] != iILLL1.ILil.FIXED && (!z3 || iilll1.LL1IL() != 8)) {
            if (z3) {
                int iM2653lIlii = iilll1.m2653lIlii();
                liiiM2687lLi1LL2.LlLI1(1);
                liiiM2687lLi1LL4.LlLI1(1);
                lLi1LL lli1ll3 = iilll1.iIlLiL.f1959IL;
                if (lli1ll3 == null && iilll1.f1946lL.f1959IL == null) {
                    if (z) {
                        liiiM2687lLi1LL4.m2676il(liiiM2687lLi1LL2, 1, iilll1.I11L());
                        return;
                    } else {
                        liiiM2687lLi1LL4.m2672L11I(liiiM2687lLi1LL2, iM2653lIlii);
                        return;
                    }
                }
                if (lli1ll3 != null && iilll1.f1946lL.f1959IL == null) {
                    if (z) {
                        liiiM2687lLi1LL4.m2676il(liiiM2687lLi1LL2, 1, iilll1.I11L());
                        return;
                    } else {
                        liiiM2687lLi1LL4.m2672L11I(liiiM2687lLi1LL2, iM2653lIlii);
                        return;
                    }
                }
                if (lli1ll3 == null && iilll1.f1946lL.f1959IL != null) {
                    if (z) {
                        liiiM2687lLi1LL2.m2676il(liiiM2687lLi1LL4, -1, iilll1.I11L());
                        return;
                    } else {
                        liiiM2687lLi1LL2.m2672L11I(liiiM2687lLi1LL4, -iM2653lIlii);
                        return;
                    }
                }
                if (lli1ll3 == null || iilll1.f1946lL.f1959IL == null) {
                    return;
                }
                if (z) {
                    iilll1.I11L().IL1Iii(liiiM2687lLi1LL2);
                    iilll1.llliI().IL1Iii(liiiM2687lLi1LL4);
                }
                if (iilll1.llI == 0.0f) {
                    liiiM2687lLi1LL2.LlLI1(3);
                    liiiM2687lLi1LL4.LlLI1(3);
                    liiiM2687lLi1LL2.m2669ILl(liiiM2687lLi1LL4, 0.0f);
                    liiiM2687lLi1LL4.m2669ILl(liiiM2687lLi1LL2, 0.0f);
                    return;
                }
                liiiM2687lLi1LL2.LlLI1(2);
                liiiM2687lLi1LL4.LlLI1(2);
                liiiM2687lLi1LL2.m2669ILl(liiiM2687lLi1LL4, -iM2653lIlii);
                liiiM2687lLi1LL4.m2669ILl(liiiM2687lLi1LL2, iM2653lIlii);
                iilll1.m87iI(iM2653lIlii);
                if (iilll1.f1913IIiI > 0) {
                    iilll1.I11L.m2687lLi1LL().m2670IiL(1, liiiM2687lLi1LL2, iilll1.f1913IIiI);
                    return;
                }
                return;
            }
            return;
        }
        lLi1LL lli1ll4 = iilll1.iIlLiL.f1959IL;
        if (lli1ll4 == null && iilll1.f1946lL.f1959IL == null) {
            liiiM2687lLi1LL2.LlLI1(1);
            liiiM2687lLi1LL4.LlLI1(1);
            if (z) {
                liiiM2687lLi1LL4.m2676il(liiiM2687lLi1LL2, 1, iilll1.I11L());
            } else {
                liiiM2687lLi1LL4.m2672L11I(liiiM2687lLi1LL2, iilll1.m2653lIlii());
            }
            lLi1LL lli1ll5 = iilll1.I11L;
            if (lli1ll5.f1959IL != null) {
                lli1ll5.m2687lLi1LL().LlLI1(1);
                liiiM2687lLi1LL2.m2670IiL(1, iilll1.I11L.m2687lLi1LL(), -iilll1.f1913IIiI);
                return;
            }
            return;
        }
        if (lli1ll4 != null && iilll1.f1946lL.f1959IL == null) {
            liiiM2687lLi1LL2.LlLI1(1);
            liiiM2687lLi1LL4.LlLI1(1);
            if (z) {
                liiiM2687lLi1LL4.m2676il(liiiM2687lLi1LL2, 1, iilll1.I11L());
            } else {
                liiiM2687lLi1LL4.m2672L11I(liiiM2687lLi1LL2, iilll1.m2653lIlii());
            }
            if (iilll1.f1913IIiI > 0) {
                iilll1.I11L.m2687lLi1LL().m2670IiL(1, liiiM2687lLi1LL2, iilll1.f1913IIiI);
                return;
            }
            return;
        }
        if (lli1ll4 == null && iilll1.f1946lL.f1959IL != null) {
            liiiM2687lLi1LL2.LlLI1(1);
            liiiM2687lLi1LL4.LlLI1(1);
            if (z) {
                liiiM2687lLi1LL2.m2676il(liiiM2687lLi1LL4, -1, iilll1.I11L());
            } else {
                liiiM2687lLi1LL2.m2672L11I(liiiM2687lLi1LL4, -iilll1.m2653lIlii());
            }
            if (iilll1.f1913IIiI > 0) {
                iilll1.I11L.m2687lLi1LL().m2670IiL(1, liiiM2687lLi1LL2, iilll1.f1913IIiI);
                return;
            }
            return;
        }
        if (lli1ll4 == null || iilll1.f1946lL.f1959IL == null) {
            return;
        }
        liiiM2687lLi1LL2.LlLI1(2);
        liiiM2687lLi1LL4.LlLI1(2);
        if (z) {
            liiiM2687lLi1LL2.Lil(liiiM2687lLi1LL4, -1, iilll1.I11L());
            liiiM2687lLi1LL4.Lil(liiiM2687lLi1LL2, 1, iilll1.I11L());
            iilll1.I11L().IL1Iii(liiiM2687lLi1LL2);
            iilll1.llliI().IL1Iii(liiiM2687lLi1LL4);
        } else {
            liiiM2687lLi1LL2.m2669ILl(liiiM2687lLi1LL4, -iilll1.m2653lIlii());
            liiiM2687lLi1LL4.m2669ILl(liiiM2687lLi1LL2, iilll1.m2653lIlii());
        }
        if (iilll1.f1913IIiI > 0) {
            iilll1.I11L.m2687lLi1LL().m2670IiL(1, liiiM2687lLi1LL2, iilll1.f1913IIiI);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030 A[PHI: r11 r12
  0x0030: PHI (r11v17 boolean) = (r11v1 boolean), (r11v19 boolean) binds: [B:21:0x0040, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]
  0x0030: PHI (r12v8 boolean) = (r12v1 boolean), (r12v10 boolean) binds: [B:21:0x0040, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:13:0x0032 A[PHI: r11 r12
  0x0032: PHI (r11v3 boolean) = (r11v1 boolean), (r11v19 boolean) binds: [B:21:0x0040, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]
  0x0032: PHI (r12v3 boolean) = (r12v1 boolean), (r12v10 boolean) binds: [B:21:0x0040, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x00f9  */
    public static boolean ILil(IiL iiL, lLi1LL lli1ll, int i, int i2, IL il) {
        boolean z;
        boolean z2;
        boolean z3;
        lIiI liii;
        float fM2681IL;
        float f;
        iILLL1 iilll1;
        boolean z4;
        iILLL1 iilll2 = il.f4487IL1Iii;
        iILLL1 iilll3 = il.f4486I1I;
        iILLL1 iilll4 = il.f4488ILil;
        iILLL1 iilll5 = il.f1887IL;
        iILLL1 iilll6 = il.f4489Ilil;
        float f2 = il.ILL;
        iILLL1 iilll7 = il.f1894lLi1LL;
        iILLL1 iilll8 = il.f1891iILLL1;
        iILLL1.ILil iLil = iiL.LL1IL[i];
        iILLL1.ILil iLil2 = iILLL1.ILil.WRAP_CONTENT;
        if (i == 0) {
            int i3 = iilll6.f1932iiIIi11;
            z = i3 == 0;
            z2 = i3 == 1;
            if (i3 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            int i4 = iilll6.f1931iILilI;
            z = i4 == 0;
            z2 = i4 == 1;
            if (i4 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        iILLL1 iilll9 = iilll2;
        int i5 = 0;
        boolean z5 = false;
        int i6 = 0;
        float fM2629L111 = 0.0f;
        float fM2681IL2 = 0.0f;
        while (!z5) {
            if (iilll9.LL1IL() != 8) {
                i6++;
                fM2629L111 += i == 0 ? iilll9.m2629L111() : iilll9.m2653lIlii();
                if (iilll9 != iilll4) {
                    fM2629L111 += iilll9.f1928LlLLL[i2].m2681IL();
                }
                if (iilll9 != iilll5) {
                    fM2629L111 += iilll9.f1928LlLLL[i2 + 1].m2681IL();
                }
                fM2681IL2 = fM2681IL2 + iilll9.f1928LlLLL[i2].m2681IL() + iilll9.f1928LlLLL[i2 + 1].m2681IL();
            }
            lLi1LL lli1ll2 = iilll9.f1928LlLLL[i2];
            if (iilll9.LL1IL() != 8 && iilll9.LL1IL[i] == iILLL1.ILil.MATCH_CONSTRAINT) {
                i5++;
                if (i != 0) {
                    z4 = false;
                    if (iilll9.f1940lLi1LL != 0) {
                        return false;
                    }
                    if (iilll9.ILL != 0 || iilll9.f1925Ll1 != 0) {
                    }
                    return z4;
                }
                if (iilll9.f4508Ilil != 0) {
                    return false;
                }
                z4 = false;
                if (iilll9.f1918IiL != 0 || iilll9.f1927L11I != 0) {
                    return false;
                }
                if (iilll9.llI != 0.0f) {
                    return z4;
                }
            }
            lLi1LL lli1ll3 = iilll9.f1928LlLLL[i2 + 1].f1959IL;
            if (lli1ll3 != null) {
                iILLL1 iilll10 = lli1ll3.f4516ILil;
                lLi1LL[] lli1llArr = iilll10.f1928LlLLL;
                if (lli1llArr[i2].f1959IL == null || lli1llArr[i2].f1959IL.f4516ILil != iilll9) {
                    iilll1 = null;
                } else {
                    iilll1 = iilll10;
                }
            } else {
                iilll1 = null;
            }
            if (iilll1 != null) {
                iilll9 = iilll1;
            } else {
                z5 = true;
            }
        }
        lIiI liiiM2687lLi1LL = iilll2.f1928LlLLL[i2].m2687lLi1LL();
        int i7 = i2 + 1;
        lIiI liiiM2687lLi1LL2 = iilll3.f1928LlLLL[i7].m2687lLi1LL();
        lIiI liii2 = liiiM2687lLi1LL.f1951IL;
        if (liii2 == null || (liii = liiiM2687lLi1LL2.f1951IL) == null || liii2.f4491ILil != 1 || liii.f4491ILil != 1) {
            return false;
        }
        if (i5 > 0 && i5 != i6) {
            return false;
        }
        if (z3 || z || z2) {
            fM2681IL = iilll4 != null ? iilll4.f1928LlLLL[i2].m2681IL() : 0.0f;
            if (iilll5 != null) {
                fM2681IL += iilll5.f1928LlLLL[i7].m2681IL();
            }
        } else {
            fM2681IL = 0.0f;
        }
        float f3 = liiiM2687lLi1LL.f1951IL.f1955iILLL1;
        float f4 = liiiM2687lLi1LL2.f1951IL.f1955iILLL1;
        float f5 = (f3 < f4 ? f4 - f3 : f3 - f4) - fM2629L111;
        if (i5 > 0 && i5 == i6) {
            if (iilll9.I11li1() != null && iilll9.I11li1().LL1IL[i] == iILLL1.ILil.WRAP_CONTENT) {
                return false;
            }
            float f6 = (f5 + fM2629L111) - fM2681IL2;
            float fM2681IL3 = f3;
            iILLL1 iilll11 = iilll2;
            while (iilll11 != null) {
                iILLL1 iilll12 = lLi1LL.f1983llL1ii;
                if (iilll12 != null) {
                    iilll12.f19821--;
                    iilll12.f1976lIlii++;
                    iilll12.llliI++;
                }
                iILLL1 iilll13 = iilll11.L1iI1[i];
                if (iilll13 != null || iilll11 == iilll3) {
                    float f7 = f6 / i5;
                    if (f2 > 0.0f) {
                        float[] fArr = iilll11.f14I1;
                        if (fArr[i] == -1.0f) {
                            f = 0.0f;
                        } else {
                            f7 = (fArr[i] * f6) / f2;
                            f = f7;
                        }
                    } else {
                        f = f7;
                    }
                    if (iilll11.LL1IL() == 8) {
                        f = 0.0f;
                    }
                    float fM2681IL4 = fM2681IL3 + iilll11.f1928LlLLL[i2].m2681IL();
                    iilll11.f1928LlLLL[i2].m2687lLi1LL().m2671Ll1(liiiM2687lLi1LL.f1957lLi1LL, fM2681IL4);
                    float f8 = fM2681IL4 + f;
                    iilll11.f1928LlLLL[i7].m2687lLi1LL().m2671Ll1(liiiM2687lLi1LL.f1957lLi1LL, f8);
                    iilll11.f1928LlLLL[i2].m2687lLi1LL().m2673iILLL1(lli1ll);
                    iilll11.f1928LlLLL[i7].m2687lLi1LL().m2673iILLL1(lli1ll);
                    fM2681IL3 = f8 + iilll11.f1928LlLLL[i7].m2681IL();
                }
                iilll11 = iilll13;
            }
            return true;
        }
        if (f5 < 0.0f) {
            z3 = true;
            z = false;
            z2 = false;
        }
        if (z3) {
            iILLL1 iilll14 = iilll2;
            float fILL = f3 + ((f5 - fM2681IL) * iilll14.ILL(i));
            while (true) {
                iILLL1 iilll15 = iilll14;
                if (iilll15 == null) {
                    return true;
                }
                iILLL1 iilll16 = lLi1LL.f1983llL1ii;
                if (iilll16 != null) {
                    iilll16.f19821--;
                    iilll16.f1976lIlii++;
                    iilll16.llliI++;
                }
                iilll14 = iilll15.L1iI1[i];
                if (iilll14 != null || iilll15 == iilll3) {
                    int iM2629L111 = i == 0 ? iilll15.m2629L111() : iilll15.m2653lIlii();
                    float fM2681IL5 = fILL + iilll15.f1928LlLLL[i2].m2681IL();
                    iilll15.f1928LlLLL[i2].m2687lLi1LL().m2671Ll1(liiiM2687lLi1LL.f1957lLi1LL, fM2681IL5);
                    float f9 = fM2681IL5 + iM2629L111;
                    iilll15.f1928LlLLL[i7].m2687lLi1LL().m2671Ll1(liiiM2687lLi1LL.f1957lLi1LL, f9);
                    iilll15.f1928LlLLL[i2].m2687lLi1LL().m2673iILLL1(lli1ll);
                    iilll15.f1928LlLLL[i7].m2687lLi1LL().m2673iILLL1(lli1ll);
                    fILL = f9 + iilll15.f1928LlLLL[i7].m2681IL();
                }
            }
        } else {
            iILLL1 iilll17 = iilll2;
            if (!z && !z2) {
                return true;
            }
            if (z || z2) {
                f5 -= fM2681IL;
            }
            float f10 = f5 / (i6 + 1);
            if (z2) {
                f10 = f5 / (i6 > 1 ? i6 - 1 : 2.0f);
            }
            float fM2681IL6 = iilll17.LL1IL() != 8 ? f3 + f10 : f3;
            if (z2 && i6 > 1) {
                fM2681IL6 = iilll4.f1928LlLLL[i2].m2681IL() + f3;
            }
            if (z && iilll4 != null) {
                fM2681IL6 += iilll4.f1928LlLLL[i2].m2681IL();
            }
            while (true) {
                iILLL1 iilll18 = iilll17;
                if (iilll18 == null) {
                    return true;
                }
                iILLL1 iilll19 = lLi1LL.f1983llL1ii;
                if (iilll19 != null) {
                    iilll19.f19821--;
                    iilll19.f1976lIlii++;
                    iilll19.llliI++;
                }
                iilll17 = iilll18.L1iI1[i];
                if (iilll17 != null || iilll18 == iilll3) {
                    float fM2629L112 = i == 0 ? iilll18.m2629L111() : iilll18.m2653lIlii();
                    if (iilll18 != iilll4) {
                        fM2681IL6 += iilll18.f1928LlLLL[i2].m2681IL();
                    }
                    iilll18.f1928LlLLL[i2].m2687lLi1LL().m2671Ll1(liiiM2687lLi1LL.f1957lLi1LL, fM2681IL6);
                    iilll18.f1928LlLLL[i7].m2687lLi1LL().m2671Ll1(liiiM2687lLi1LL.f1957lLi1LL, fM2681IL6 + fM2629L112);
                    iilll18.f1928LlLLL[i2].m2687lLi1LL().m2673iILLL1(lli1ll);
                    iilll18.f1928LlLLL[i7].m2687lLi1LL().m2673iILLL1(lli1ll);
                    fM2681IL6 += fM2629L112 + iilll18.f1928LlLLL[i7].m2681IL();
                    if (iilll17 != null) {
                        if (iilll17.LL1IL() != 8) {
                            fM2681IL6 += f10;
                        }
                    }
                }
            }
        }
    }

    public static void Ilil(iILLL1 iilll1, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        iilll1.f1928LlLLL[i3].m2687lLi1LL().f1957lLi1LL = iilll1.I11li1().iIi1.m2687lLi1LL();
        iilll1.f1928LlLLL[i3].m2687lLi1LL().f1955iILLL1 = i2;
        iilll1.f1928LlLLL[i3].m2687lLi1LL().f4491ILil = 1;
        iilll1.f1928LlLLL[i4].m2687lLi1LL().f1957lLi1LL = iilll1.f1928LlLLL[i3].m2687lLi1LL();
        iilll1.f1928LlLLL[i4].m2687lLi1LL().f1955iILLL1 = iilll1.iIlLiL(i);
        iilll1.f1928LlLLL[i4].m2687lLi1LL().f4491ILil = 1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean m2620IL(iILLL1 iilll1, int i) {
        iILLL1.ILil[] iLilArr = iilll1.LL1IL;
        iILLL1.ILil iLil = iLilArr[i];
        iILLL1.ILil iLil2 = iILLL1.ILil.MATCH_CONSTRAINT;
        if (iLil != iLil2) {
            return false;
        }
        if (iilll1.llI != 0.0f) {
            if (iLilArr[i != 0 ? (char) 0 : (char) 1] == iLil2) {
            }
            return false;
        }
        if (i == 0) {
            if (iilll1.f4508Ilil != 0 || iilll1.f1918IiL != 0 || iilll1.f1927L11I != 0) {
                return false;
            }
        } else if (iilll1.f1940lLi1LL != 0 || iilll1.ILL != 0 || iilll1.f1925Ll1 != 0) {
            return false;
        }
        return true;
    }
}
