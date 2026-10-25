package p051lLi1LL.ILil.IL1Iii.iIi1;

import android.util.Log;
import java.util.logging.Level;
import p051lLi1LL.ILil.IL1Iii.IiL;

/* JADX INFO: compiled from: AndroidLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements IiL {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final boolean f5570ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f5571IL1Iii;

    static {
        boolean z = false;
        try {
            if (Class.forName("android.util.Log") != null) {
                z = true;
            }
        } catch (ClassNotFoundException unused) {
        }
        f5570ILil = z;
    }

    public IL1Iii(String str) {
        this.f5571IL1Iii = str;
    }

    public static boolean I1I() {
        return f5570ILil;
    }

    @Override // p051lLi1LL.ILil.IL1Iii.IiL
    public void IL1Iii(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(m3672IL(level), this.f5571IL1Iii, str);
        }
    }

    @Override // p051lLi1LL.ILil.IL1Iii.IiL
    public void ILil(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            Log.println(m3672IL(level), this.f5571IL1Iii, str + "\n" + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int m3672IL(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }
}
