package I1I.I1I.ILil;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: renamed from: I1I.I1I.ILil.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: FileChangeMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static llL1ii f3283I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String f3285ILil = I1I.IL1Iii.IL1Iii(new byte[]{80, 94, 92, 83, 108, 80, 94, 86, 94, 81, 86, 108, 68, 82, 83, 89, 65, 87, 24, 68, 85, 68}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 2, 5, 5, 7}, I1I.IL1Iii.IL1Iii(new byte[]{15, 5, 87, 81, 87, 7}, "96eba3")));

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3284IL1Iii = llL1ii.class.getSimpleName();

    public static synchronized llL1ii IL1Iii() {
        if (f3283I1I == null) {
            f3283I1I = new llL1ii();
        }
        return f3283I1I;
    }

    public final long I1I(Context context) {
        File file = new File(context.getFilesDir(), f3285ILil);
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    long j = objectInputStream.readLong();
                    objectInputStream.close();
                    fileInputStream.close();
                    return j;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Exception e) {
            Log.e(f3284IL1Iii, I1I.IL1Iii.IL1Iii(new byte[]{127, 3, 11, 91, 4, 5, 25, 22, 13, 23, 19, 4, 88, 6, 66, 69, 4, 2, 86, 16, 6, 23, 7, 8, 85, 7, 88, 23}, I1I.IL1Iii.IL1Iii(new byte[]{9, 86, 4, 85, 88, 88}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 80, 82, 95, 9}, "5060f0"))) + e.getMessage());
            return 0L;
        }
    }

    public long ILil(Context context) {
        return I1I(context);
    }

    public void Ilil(long j, Context context) {
        m1033IL(context, System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1033IL(Context context, long j) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f3285ILil));
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeLong(j);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            objectOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Exception e) {
            Log.e(f3284IL1Iii, I1I.IL1Iii.IL1Iii(new byte[]{35, 4, 89, 84, 7, 81, 69, 17, 95, 24, 17, 84, 19, 0, 16, 74, 7, 86, 10, 23, 84, 24, 4, 92, 9, 0, 10, 24}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 2, 91, 87, 3}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 10, 91, 4, 82}, "63881d"))) + e.getMessage());
        }
    }
}
