package ILil.p028IiL.p034lIiI;

import java.util.Objects;

/* JADX INFO: renamed from: ILil.I丨iL.lIi丨I.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes.dex */
public final class L11I {
    public static int I1I(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static void IL1Iii(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void ILil(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T Ilil(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static <T> T m2295IL(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
