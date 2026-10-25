package ILil.p046il.IL1Iii;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: FocusStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: compiled from: FocusStrategy.java */
    public static class I1I<T> implements Comparator<T> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final boolean f4555I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Rect f4556IL1Iii = new Rect();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Rect f4557ILil = new Rect();

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final IL1Iii<T> f2055IL;

        public I1I(boolean z, IL1Iii<T> iL1Iii) {
            this.f4555I1I = z;
            this.f2055IL = iL1Iii;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            Rect rect = this.f4556IL1Iii;
            Rect rect2 = this.f4557ILil;
            this.f2055IL.IL1Iii(t, rect);
            this.f2055IL.IL1Iii(t2, rect2);
            int i = rect.top;
            int i2 = rect2.top;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            int i3 = rect.left;
            int i4 = rect2.left;
            if (i3 < i4) {
                return this.f4555I1I ? 1 : -1;
            }
            if (i3 > i4) {
                return this.f4555I1I ? -1 : 1;
            }
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.right;
            int i8 = rect2.right;
            if (i7 < i8) {
                return this.f4555I1I ? 1 : -1;
            }
            if (i7 > i8) {
                return this.f4555I1I ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: FocusStrategy.java */
    public interface IL1Iii<T> {
        void IL1Iii(T t, Rect rect);
    }

    /* JADX INFO: renamed from: ILil.丨il.IL1Iii.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FocusStrategy.java */
    public interface InterfaceC0589ILil<T, V> {
        V IL1Iii(T t, int i);

        int ILil(T t);
    }

    public static <L, T> T I1I(L l, InterfaceC0589ILil<L, T> interfaceC0589ILil, IL1Iii<T> iL1Iii, T t, Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        if (i == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        T t2 = null;
        int iILil = interfaceC0589ILil.ILil(l);
        Rect rect3 = new Rect();
        for (int i2 = 0; i2 < iILil; i2++) {
            T tIL1Iii = interfaceC0589ILil.IL1Iii(l, i2);
            if (tIL1Iii != t) {
                iL1Iii.IL1Iii(tIL1Iii, rect3);
                if (m2761IiL(i, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = tIL1Iii;
                }
            }
        }
        return t2;
    }

    public static boolean IL1Iii(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean zILil = ILil(i, rect, rect2);
        if (ILil(i, rect, rect3) || !zILil) {
            return false;
        }
        return !m2767il(i, rect, rect3) || i == 17 || i == 66 || ILL(i, rect, rect2) < m2765lIiI(i, rect, rect3);
    }

    public static int ILL(int i, Rect rect, Rect rect2) {
        return Math.max(0, m2762Ll1(i, rect, rect2));
    }

    public static boolean ILil(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static int m2759ILl(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (i == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.bottom;
            i3 = rect.bottom;
        }
        return i2 - i3;
    }

    public static <T> T Ilil(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int iLastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static <L, T> T m2760IL(L l, InterfaceC0589ILil<L, T> interfaceC0589ILil, IL1Iii<T> iL1Iii, T t, int i, boolean z, boolean z2) {
        int iILil = interfaceC0589ILil.ILil(l);
        ArrayList arrayList = new ArrayList(iILil);
        for (int i2 = 0; i2 < iILil; i2++) {
            arrayList.add(interfaceC0589ILil.IL1Iii(l, i2));
        }
        Collections.sort(arrayList, new I1I(z, iL1Iii));
        if (i == 1) {
            return (T) m2766lLi1LL(t, arrayList, z2);
        }
        if (i == 2) {
            return (T) Ilil(t, arrayList, z2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m2761IiL(int i, Rect rect, Rect rect2, Rect rect3) {
        if (!m2763L11I(rect, rect2, i)) {
            return false;
        }
        if (m2763L11I(rect, rect3, i) && !IL1Iii(i, rect, rect2, rect3)) {
            return !IL1Iii(i, rect, rect3, rect2) && m2764iILLL1(ILL(i, rect, rect2), Lil(i, rect, rect2)) < m2764iILLL1(ILL(i, rect, rect3), Lil(i, rect, rect3));
        }
        return true;
    }

    public static int Lil(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static int m2762Ll1(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.top;
            i3 = rect.bottom;
        }
        return i2 - i3;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean m2763L11I(Rect rect, Rect rect2, int i) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static int m2764iILLL1(int i, int i2) {
        return (i * 13 * i) + (i2 * i2);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static int m2765lIiI(int i, Rect rect, Rect rect2) {
        return Math.max(1, m2759ILl(i, rect, rect2));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static <T> T m2766lLi1LL(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int iIndexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static boolean m2767il(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        }
        if (i == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i == 66) {
            return rect.right <= rect2.left;
        }
        if (i == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
}
