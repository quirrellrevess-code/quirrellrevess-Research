package p051lLi1LL.p060IL;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: renamed from: l丨Li1LL.I丨L.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: Marker.java */
/* JADX INFO: loaded from: classes.dex */
public interface IL extends Serializable {
    public static final String ANY_MARKER = "*";
    public static final String ANY_NON_NULL_MARKER = "+";

    void add(IL il);

    boolean contains(String str);

    boolean contains(IL il);

    boolean equals(Object obj);

    String getName();

    boolean hasChildren();

    boolean hasReferences();

    int hashCode();

    Iterator<IL> iterator();

    boolean remove(IL il);
}
