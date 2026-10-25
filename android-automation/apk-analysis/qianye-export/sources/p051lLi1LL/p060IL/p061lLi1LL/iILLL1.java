package p051lLi1LL.p060IL.p061lLi1LL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import p051lLi1LL.p060IL.IL1Iii;
import p051lLi1LL.p060IL.ILil;
import p051lLi1LL.p060IL.Ilil.IL;

/* JADX INFO: renamed from: l丨Li1LL.I丨L.l丨Li1LL.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: SubstituteLoggerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 implements IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f5600IL1Iii = false;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Map<String, lLi1LL> f5601ILil = new HashMap();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final LinkedBlockingQueue<IL> f5599I1I = new LinkedBlockingQueue<>();

    public LinkedBlockingQueue<IL> I1I() {
        return this.f5599I1I;
    }

    @Override // p051lLi1LL.p060IL.IL1Iii
    public synchronized ILil IL1Iii(String str) {
        lLi1LL lli1ll;
        lli1ll = this.f5601ILil.get(str);
        if (lli1ll == null) {
            lli1ll = new lLi1LL(str, this.f5599I1I, this.f5600IL1Iii);
            this.f5601ILil.put(str, lli1ll);
        }
        return lli1ll;
    }

    public void ILil() {
        this.f5601ILil.clear();
        this.f5599I1I.clear();
    }

    public void Ilil() {
        this.f5600IL1Iii = true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public List<lLi1LL> m3697IL() {
        return new ArrayList(this.f5601ILil.values());
    }
}
