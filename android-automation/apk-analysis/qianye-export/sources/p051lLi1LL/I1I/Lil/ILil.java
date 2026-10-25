package p051lLi1LL.I1I.Lil;

import com.google.android.flexbox.BuildConfig;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Protocol.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil implements IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f5448IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final Pattern f5447ILil = Pattern.compile(" ");

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Pattern f5446I1I = Pattern.compile(",");

    public ILil(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.f5448IL1Iii = str;
    }

    @Override // p051lLi1LL.I1I.Lil.IL1Iii
    public boolean I1I(String str) {
        for (String str2 : f5446I1I.split(f5447ILil.matcher(str).replaceAll(BuildConfig.FLAVOR))) {
            if (this.f5448IL1Iii.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // p051lLi1LL.I1I.Lil.IL1Iii
    public IL1Iii IL1Iii() {
        return new ILil(ILil());
    }

    @Override // p051lLi1LL.I1I.Lil.IL1Iii
    public String ILil() {
        return this.f5448IL1Iii;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ILil.class != obj.getClass()) {
            return false;
        }
        return this.f5448IL1Iii.equals(((ILil) obj).f5448IL1Iii);
    }

    public int hashCode() {
        return this.f5448IL1Iii.hashCode();
    }

    @Override // p051lLi1LL.I1I.Lil.IL1Iii
    public String toString() {
        return ILil();
    }
}
