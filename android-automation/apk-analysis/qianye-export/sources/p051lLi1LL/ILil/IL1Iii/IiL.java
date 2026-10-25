package p051lLi1LL.ILil.IL1Iii;

import android.os.Looper;
import java.util.logging.Level;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public interface IiL {

    /* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: Logger.java */
    public static class IL1Iii {
        public static IiL IL1Iii() {
            return (!p051lLi1LL.ILil.IL1Iii.iIi1.IL1Iii.I1I() || ILil() == null) ? new ILil() : new p051lLi1LL.ILil.IL1Iii.iIi1.IL1Iii("EventBus");
        }

        public static Object ILil() {
            try {
                return Looper.getMainLooper();
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.I丨iL$ILil */
    /* JADX INFO: compiled from: Logger.java */
    public static class ILil implements IiL {
        @Override // p051lLi1LL.ILil.IL1Iii.IiL
        public void IL1Iii(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // p051lLi1LL.ILil.IL1Iii.IiL
        public void ILil(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void IL1Iii(Level level, String str);

    void ILil(Level level, String str, Throwable th);
}
