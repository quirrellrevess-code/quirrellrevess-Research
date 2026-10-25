package p066Ilil;

import com.mysql.jdbc.StatementImpl;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: Ilil.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0652ILl extends AbstractList<iILLL1> implements RandomAccess {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int[] f4575I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final iILLL1[] f4576ILil;

    public C0652ILl(iILLL1[] iilll1Arr, int[] iArr) {
        this.f4576ILil = iilll1Arr;
        this.f4575I1I = iArr;
    }

    public static int I1I(I1I i1i) {
        return (int) (i1i.m96I() / 4);
    }

    public static void IL1Iii(long j, I1I i1i, int i, List<iILLL1> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6 = i2;
        if (i6 >= i3) {
            throw new AssertionError();
        }
        for (int i7 = i6; i7 < i3; i7++) {
            if (list.get(i7).size() < i) {
                throw new AssertionError();
            }
        }
        iILLL1 iilll1 = list.get(i2);
        iILLL1 iilll2 = list.get(i3 - 1);
        int iIntValue = -1;
        if (i == iilll1.size()) {
            iIntValue = list2.get(i6).intValue();
            i6++;
            iilll1 = list.get(i6);
        }
        int i8 = i6;
        if (iilll1.getByte(i) == iilll2.getByte(i)) {
            int i9 = 0;
            int iMin = Math.min(iilll1.size(), iilll2.size());
            for (int i10 = i; i10 < iMin && iilll1.getByte(i10) == iilll2.getByte(i10); i10++) {
                i9++;
            }
            long jI1I = 1 + j + ((long) I1I(i1i)) + 2 + ((long) i9);
            i1i.m2795lIIiIlL(-i9);
            i1i.m2795lIIiIlL(iIntValue);
            int i11 = i;
            while (true) {
                i4 = i + i9;
                if (i11 >= i4) {
                    break;
                }
                i1i.m2795lIIiIlL(iilll1.getByte(i11) & StatementImpl.USES_VARIABLES_UNKNOWN);
                i11++;
            }
            if (i8 + 1 == i3) {
                if (i4 != list.get(i8).size()) {
                    throw new AssertionError();
                }
                i1i.m2795lIIiIlL(list2.get(i8).intValue());
                return;
            } else {
                I1I i1i2 = new I1I();
                i1i.m2795lIIiIlL((int) ((((long) I1I(i1i2)) + jI1I) * (-1)));
                IL1Iii(jI1I, i1i2, i4, list, i8, i3, list2);
                i1i.write(i1i2, i1i2.m96I());
                return;
            }
        }
        int i12 = 1;
        for (int i13 = i8 + 1; i13 < i3; i13++) {
            if (list.get(i13 - 1).getByte(i) != list.get(i13).getByte(i)) {
                i12++;
            }
        }
        long jI1I2 = j + ((long) I1I(i1i)) + 2 + ((long) (i12 * 2));
        i1i.m2795lIIiIlL(i12);
        i1i.m2795lIIiIlL(iIntValue);
        for (int i14 = i8; i14 < i3; i14++) {
            byte b = list.get(i14).getByte(i);
            if (i14 == i8 || b != list.get(i14 - 1).getByte(i)) {
                i1i.m2795lIIiIlL(b & StatementImpl.USES_VARIABLES_UNKNOWN);
            }
        }
        I1I i1i3 = new I1I();
        int i15 = i8;
        while (i15 < i3) {
            byte b2 = list.get(i15).getByte(i);
            int i16 = i15 + 1;
            int i17 = i16;
            while (true) {
                if (i17 >= i3) {
                    i5 = i3;
                    break;
                } else {
                    if (b2 != list.get(i17).getByte(i)) {
                        i5 = i17;
                        break;
                    }
                    i17++;
                }
            }
            if (i16 == i5 && i + 1 == list.get(i15).size()) {
                i1i.m2795lIIiIlL(list2.get(i15).intValue());
            } else {
                i1i.m2795lIIiIlL((int) ((((long) I1I(i1i3)) + jI1I2) * (-1)));
                IL1Iii(jI1I2, i1i3, i + 1, list, i15, i5, list2);
            }
            i1i3 = i1i3;
            i15 = i5;
        }
        I1I i1i4 = i1i3;
        i1i.write(i1i4, i1i4.m96I());
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static C0652ILl m2819IL(iILLL1... iilll1Arr) {
        if (iilll1Arr.length == 0) {
            return new C0652ILl(new iILLL1[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(iilll1Arr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, iilll1Arr[i2]), Integer.valueOf(i2));
        }
        if (((iILLL1) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            iILLL1 iilll1 = (iILLL1) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                iILLL1 iilll2 = (iILLL1) arrayList.get(i5);
                if (!iilll2.startsWith(iilll1)) {
                    break;
                }
                if (iilll2.size() == iilll1.size()) {
                    throw new IllegalArgumentException("duplicate option: " + iilll2);
                }
                if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        I1I i1i = new I1I();
        IL1Iii(0L, i1i, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iI1I = I1I(i1i);
        int[] iArr = new int[iI1I];
        for (int i6 = 0; i6 < iI1I; i6++) {
            iArr[i6] = i1i.Ilil();
        }
        if (i1i.ILL()) {
            return new C0652ILl((iILLL1[]) iilll1Arr.clone(), iArr);
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public iILLL1 get(int i) {
        return this.f4576ILil[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4576ILil.length;
    }
}
