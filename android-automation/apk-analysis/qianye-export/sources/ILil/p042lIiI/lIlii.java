package ILil.p042lIiI;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: ILil.lIi丨I.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: ViewModelStore.java */
/* JADX INFO: loaded from: classes.dex */
public class lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final HashMap<String, LlLI1> f4354IL1Iii = new HashMap<>();

    public final void I1I(String str, LlLI1 llLI1) {
        LlLI1 llLI1Put = this.f4354IL1Iii.put(str, llLI1);
        if (llLI1Put != null) {
            llLI1Put.I1I();
        }
    }

    public final void IL1Iii() {
        Iterator<LlLI1> it = this.f4354IL1Iii.values().iterator();
        while (it.hasNext()) {
            it.next().IL1Iii();
        }
        this.f4354IL1Iii.clear();
    }

    public final LlLI1 ILil(String str) {
        return this.f4354IL1Iii.get(str);
    }
}
