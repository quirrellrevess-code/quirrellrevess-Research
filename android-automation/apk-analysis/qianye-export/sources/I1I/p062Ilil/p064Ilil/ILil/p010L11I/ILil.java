package I1I.p062Ilil.p064Ilil.ILil.p010L11I;

/* JADX INFO: compiled from: ScriptInterruptedException.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends IL1Iii {
    public ILil() {
    }

    public static boolean causedByInterrupted(Throwable th) {
        while (th != null) {
            if ((th instanceof ILil) || (th instanceof InterruptedException)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public ILil(Throwable th) {
        super(th);
    }
}
