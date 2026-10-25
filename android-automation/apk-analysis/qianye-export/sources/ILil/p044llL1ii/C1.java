package ILil.p044llL1ii;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: ILil.ll丨L1ii.丨丨丨1丨, reason: invalid class name */
/* JADX INFO: compiled from: TransitionValues.java */
/* JADX INFO: loaded from: classes.dex */
public class C1 {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public View f4477ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Map<String, Object> f4476IL1Iii = new HashMap();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final ArrayList<Transition> f4475I1I = new ArrayList<>();

    @Deprecated
    public C1() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1)) {
            return false;
        }
        C1 c1 = (C1) obj;
        return this.f4477ILil == c1.f4477ILil && this.f4476IL1Iii.equals(c1.f4476IL1Iii);
    }

    public int hashCode() {
        return (this.f4477ILil.hashCode() * 31) + this.f4476IL1Iii.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f4477ILil + "\n") + "    values:";
        for (String str2 : this.f4476IL1Iii.keySet()) {
            str = str + "    " + str2 + ": " + this.f4476IL1Iii.get(str2) + "\n";
        }
        return str;
    }

    public C1(View view) {
        this.f4477ILil = view;
    }
}
