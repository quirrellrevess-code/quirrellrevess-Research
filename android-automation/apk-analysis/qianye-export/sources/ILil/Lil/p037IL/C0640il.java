package ILil.Lil.p037IL;

import java.util.List;

/* JADX INFO: renamed from: ILil.Lil.I丨L.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: OpReorderer.java */
/* JADX INFO: loaded from: classes.dex */
public class C0640il {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IL1Iii f4310IL1Iii;

    /* JADX INFO: renamed from: ILil.Lil.I丨L.丨il$IL1Iii */
    /* JADX INFO: compiled from: OpReorderer.java */
    public interface IL1Iii {
        void IL1Iii(ILil.Lil.I丨L.IL1Iii.ILil iLil);

        ILil.Lil.I丨L.IL1Iii.ILil ILil(int i, int i2, int i3, Object obj);
    }

    public C0640il(IL1Iii iL1Iii) {
        this.f4310IL1Iii = iL1Iii;
    }

    public final void I1I(List<ILil.Lil.I丨L.IL1Iii.ILil> list, int i, ILil.Lil.I丨L.IL1Iii.ILil iLil, int i2, ILil.Lil.I丨L.IL1Iii.ILil iLil2) {
        int i3 = iLil.f1745IL;
        int i4 = iLil2.f4256ILil;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = iLil.f4256ILil;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            iLil.f4256ILil = i6 + iLil2.f1745IL;
        }
        int i7 = iLil2.f4256ILil;
        if (i7 <= i3) {
            iLil.f1745IL = i3 + iLil2.f1745IL;
        }
        iLil2.f4256ILil = i7 + i5;
        list.set(i, iLil2);
        list.set(i2, iLil);
    }

    public final int IL1Iii(List<ILil.Lil.I丨L.IL1Iii.ILil> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f4255IL1Iii != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    public void ILil(List<ILil.Lil.I丨L.IL1Iii.ILil> list) {
        while (true) {
            int iIL1Iii = IL1Iii(list);
            if (iIL1Iii == -1) {
                return;
            } else {
                m2447IL(list, iIL1Iii, iIL1Iii + 1);
            }
        }
    }

    public void Ilil(List<ILil.Lil.I丨L.IL1Iii.ILil> list, int i, ILil.Lil.I丨L.IL1Iii.ILil iLil, int i2, ILil.Lil.I丨L.IL1Iii.ILil iLil2) {
        boolean z;
        int i3 = iLil.f4256ILil;
        int i4 = iLil.f1745IL;
        boolean z2 = false;
        if (i3 < i4) {
            if (iLil2.f4256ILil == i3 && iLil2.f1745IL == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (iLil2.f4256ILil == i4 + 1 && iLil2.f1745IL == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = iLil2.f4256ILil;
        if (i4 < i5) {
            iLil2.f4256ILil = i5 - 1;
        } else {
            int i6 = iLil2.f1745IL;
            if (i4 < i5 + i6) {
                iLil2.f1745IL = i6 - 1;
                iLil.f4255IL1Iii = 2;
                iLil.f1745IL = 1;
                if (iLil2.f1745IL == 0) {
                    list.remove(i2);
                    this.f4310IL1Iii.IL1Iii(iLil2);
                    return;
                }
                return;
            }
        }
        int i7 = iLil.f4256ILil;
        int i8 = iLil2.f4256ILil;
        ILil.Lil.I丨L.IL1Iii.ILil ILil2 = null;
        if (i7 <= i8) {
            iLil2.f4256ILil = i8 + 1;
        } else {
            int i9 = iLil2.f1745IL;
            if (i7 < i8 + i9) {
                ILil2 = this.f4310IL1Iii.ILil(2, i7 + 1, (i8 + i9) - i7, null);
                iLil2.f1745IL = iLil.f4256ILil - iLil2.f4256ILil;
            }
        }
        if (z2) {
            list.set(i, iLil2);
            list.remove(i2);
            this.f4310IL1Iii.IL1Iii(iLil);
            return;
        }
        if (z) {
            if (ILil2 != null) {
                int i10 = iLil.f4256ILil;
                if (i10 > ILil2.f4256ILil) {
                    iLil.f4256ILil = i10 - ILil2.f1745IL;
                }
                int i11 = iLil.f1745IL;
                if (i11 > ILil2.f4256ILil) {
                    iLil.f1745IL = i11 - ILil2.f1745IL;
                }
            }
            int i12 = iLil.f4256ILil;
            if (i12 > iLil2.f4256ILil) {
                iLil.f4256ILil = i12 - iLil2.f1745IL;
            }
            int i13 = iLil.f1745IL;
            if (i13 > iLil2.f4256ILil) {
                iLil.f1745IL = i13 - iLil2.f1745IL;
            }
        } else {
            if (ILil2 != null) {
                int i14 = iLil.f4256ILil;
                if (i14 >= ILil2.f4256ILil) {
                    iLil.f4256ILil = i14 - ILil2.f1745IL;
                }
                int i15 = iLil.f1745IL;
                if (i15 >= ILil2.f4256ILil) {
                    iLil.f1745IL = i15 - ILil2.f1745IL;
                }
            }
            int i16 = iLil.f4256ILil;
            if (i16 >= iLil2.f4256ILil) {
                iLil.f4256ILil = i16 - iLil2.f1745IL;
            }
            int i17 = iLil.f1745IL;
            if (i17 >= iLil2.f4256ILil) {
                iLil.f1745IL = i17 - iLil2.f1745IL;
            }
        }
        list.set(i, iLil2);
        if (iLil.f4256ILil != iLil.f1745IL) {
            list.set(i2, iLil);
        } else {
            list.remove(i2);
        }
        if (ILil2 != null) {
            list.add(i, ILil2);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m2447IL(List<ILil.Lil.I丨L.IL1Iii.ILil> list, int i, int i2) {
        ILil.Lil.I丨L.IL1Iii.ILil iLil = list.get(i);
        ILil.Lil.I丨L.IL1Iii.ILil iLil2 = list.get(i2);
        int i3 = iLil2.f4255IL1Iii;
        if (i3 == 1) {
            I1I(list, i, iLil, i2, iLil2);
        } else if (i3 == 2) {
            Ilil(list, i, iLil, i2, iLil2);
        } else {
            if (i3 != 4) {
                return;
            }
            m2448lLi1LL(list, i, iLil, i2, iLil2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2448lLi1LL(List<ILil.Lil.I丨L.IL1Iii.ILil> list, int i, ILil.Lil.I丨L.IL1Iii.ILil iLil, int i2, ILil.Lil.I丨L.IL1Iii.ILil iLil2) {
        ILil.Lil.I丨L.IL1Iii.ILil ILil2;
        int i3;
        int i4;
        int i5;
        int i6 = iLil.f1745IL;
        int i7 = iLil2.f4256ILil;
        ILil.Lil.I丨L.IL1Iii.ILil ILil3 = null;
        if (i6 >= i7) {
            int i8 = iLil2.f1745IL;
            if (i6 < i7 + i8) {
                iLil2.f1745IL = i8 - 1;
                ILil2 = this.f4310IL1Iii.ILil(4, iLil.f4256ILil, 1, iLil2.f4254I1I);
            }
            i3 = iLil.f4256ILil;
            i4 = iLil2.f4256ILil;
            if (i3 <= i4) {
                iLil2.f4256ILil = i4 + 1;
            } else {
                i5 = iLil2.f1745IL;
                if (i3 < i4 + i5) {
                    int i9 = (i4 + i5) - i3;
                    ILil3 = this.f4310IL1Iii.ILil(4, i3 + 1, i9, iLil2.f4254I1I);
                    iLil2.f1745IL -= i9;
                }
            }
            list.set(i2, iLil);
            if (iLil2.f1745IL > 0) {
                list.set(i, iLil2);
            } else {
                list.remove(i);
                this.f4310IL1Iii.IL1Iii(iLil2);
            }
            if (ILil2 != null) {
                list.add(i, ILil2);
            }
            if (ILil3 != null) {
                list.add(i, ILil3);
            }
        }
        iLil2.f4256ILil = i7 - 1;
        ILil2 = null;
        i3 = iLil.f4256ILil;
        i4 = iLil2.f4256ILil;
        if (i3 <= i4) {
            iLil2.f4256ILil = i4 + 1;
        } else {
            i5 = iLil2.f1745IL;
            if (i3 < i4 + i5) {
                int i10 = (i4 + i5) - i3;
                ILil3 = this.f4310IL1Iii.ILil(4, i3 + 1, i10, iLil2.f4254I1I);
                iLil2.f1745IL -= i10;
            }
        }
        list.set(i2, iLil);
        if (iLil2.f1745IL > 0) {
            list.set(i, iLil2);
        } else {
            list.remove(i);
            this.f4310IL1Iii.IL1Iii(iLil2);
        }
        if (ILil2 != null) {
            list.add(i, ILil2);
        }
        if (ILil3 != null) {
            list.add(i, ILil3);
        }
    }
}
