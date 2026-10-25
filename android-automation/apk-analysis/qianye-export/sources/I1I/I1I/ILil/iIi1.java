package I1I.I1I.ILil;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class iIi1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Object f3191IL1Iii = new Object();

    public static void IL1Iii(String str, String str2) {
        Throwable th;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        IOException iOException;
        if (str2 == null) {
            return;
        }
        synchronized (f3191IL1Iii) {
            try {
                try {
                    bufferedWriter2 = new BufferedWriter(new FileWriter(str, true));
                    try {
                        bufferedWriter2.write(I1I.IL1Iii.IL1Iii(new byte[]{104}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 1, 10, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 84, 3, 1, 1}, "5cb012"))) + new SimpleDateFormat(I1I.IL1Iii.IL1Iii(new byte[]{77, 78, 72, 74, 27, 44, 121, 26, 85, 87, 22, 41, 124, 13, 92, 94, 12, 18, 71}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 85, 0, 4, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 82, 0, 3, 82}, "0d631b")))).format(new Date()) + I1I.IL1Iii.IL1Iii(new byte[]{65, 70, 91, 2, 8}, I1I.IL1Iii.IL1Iii(new byte[]{89, 0, 10, 86, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 12, 84, 0, 83}, "754d11"))) + Thread.currentThread().getId() + I1I.IL1Iii.IL1Iii(new byte[]{63, 68}, I1I.IL1Iii.IL1Iii(new byte[]{85, 86, 87, 1, 0, 84}, I1I.IL1Iii.IL1Iii(new byte[]{1, 11, 5, 82, 5, 82}, "69f077"))));
                        bufferedWriter2.write(str2);
                        bufferedWriter2.newLine();
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e) {
                            iOException = e;
                            iOException.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 62}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 3, 2, 87, 13}, I1I.IL1Iii.IL1Iii(new byte[]{91, 3, 3, 1, 82, 92}, "8b6ead"))), I1I.IL1Iii.IL1Iii(new byte[]{86, 22, 68, 6, 13, 87, 116, 19, 70, 17, 6, 93, 67, 34, 85, 23, 6, 103, 94, 11, 81, 55, 12, 117, 94, 10, 81, 67, 6, 65, 69, 92}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 12, 82, 84, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 94, 1, 7, 5}, "d0f003"))) + e.toString());
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e3) {
                                iOException = e3;
                                iOException.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedWriter2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = null;
                    if (bufferedWriter == null) {
                        throw th;
                    }
                    try {
                        bufferedWriter.close();
                        throw th;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
            }
        }
    }
}
