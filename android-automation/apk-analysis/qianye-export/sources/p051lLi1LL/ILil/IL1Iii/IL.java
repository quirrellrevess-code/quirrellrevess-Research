package p051lLi1LL.ILil.IL1Iii;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p051lLi1LL.ILil.IL1Iii.iIi1.IL1Iii;
import p051lLi1LL.ILil.IL1Iii.iIlLiL.ILil;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: EventBusBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static final ExecutorService f3049lIiI = Executors.newCachedThreadPool();
    public IiL ILL;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f5559Ilil;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f3051IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public L11I f3052Ll1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f3054iILLL1;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public List<ILil> f3056il;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f5557IL1Iii = true;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f5558ILil = true;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5556I1I = true;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f3050IL = true;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f3055lLi1LL = true;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ExecutorService f3053L11I = f3049lIiI;

    public static Object IL1Iii() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public L11I I1I() {
        Object objIL1Iii;
        L11I l11i = this.f3052Ll1;
        if (l11i != null) {
            return l11i;
        }
        if (!IL1Iii.I1I() || (objIL1Iii = IL1Iii()) == null) {
            return null;
        }
        return new L11I.IL1Iii((Looper) objIL1Iii);
    }

    public IiL ILil() {
        IiL iiL = this.ILL;
        return iiL != null ? iiL : IiL.IL1Iii.IL1Iii();
    }
}
