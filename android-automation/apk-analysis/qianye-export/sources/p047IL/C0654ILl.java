package p047IL;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: I丨L.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: Challenge.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0654ILl {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f4612IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Map<String, String> f4613ILil;

    public C0654ILl(String str, Map<String, String> map) {
        Objects.requireNonNull(str, "scheme == null");
        Objects.requireNonNull(map, "authParams == null");
        this.f4612IL1Iii = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.f4613ILil = Collections.unmodifiableMap(linkedHashMap);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C0654ILl) {
            C0654ILl c0654ILl = (C0654ILl) obj;
            if (c0654ILl.f4612IL1Iii.equals(this.f4612IL1Iii) && c0654ILl.f4613ILil.equals(this.f4613ILil)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f4612IL1Iii.hashCode()) * 31) + this.f4613ILil.hashCode();
    }

    public String toString() {
        return this.f4612IL1Iii + " authParams=" + this.f4613ILil;
    }
}
