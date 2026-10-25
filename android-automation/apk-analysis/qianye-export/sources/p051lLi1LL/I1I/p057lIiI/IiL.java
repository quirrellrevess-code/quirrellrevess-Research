package p051lLi1LL.I1I.p057lIiI;

import com.google.android.flexbox.BuildConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: renamed from: l丨Li1LL.I1I.lIi丨I.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: HandshakedataImpl1.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL implements I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public byte[] f5474IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public TreeMap<String, String> f5475ILil = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // p051lLi1LL.I1I.p057lIiI.I1I
    public void I1I(String str, String str2) {
        this.f5475ILil.put(str, str2);
    }

    @Override // p051lLi1LL.I1I.p057lIiI.iILLL1
    public Iterator<String> ILil() {
        return Collections.unmodifiableSet(this.f5475ILil.keySet()).iterator();
    }

    @Override // p051lLi1LL.I1I.p057lIiI.iILLL1
    public boolean Ilil(String str) {
        return this.f5475ILil.containsKey(str);
    }

    @Override // p051lLi1LL.I1I.p057lIiI.iILLL1
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public String mo3595L11I(String str) {
        String str2 = this.f5475ILil.get(str);
        return str2 == null ? BuildConfig.FLAVOR : str2;
    }

    @Override // p051lLi1LL.I1I.p057lIiI.iILLL1
    public byte[] getContent() {
        return this.f5474IL1Iii;
    }
}
