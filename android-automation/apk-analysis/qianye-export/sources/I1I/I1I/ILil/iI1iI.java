package I1I.I1I.ILil;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

/* JADX INFO: renamed from: I1I.I1I.ILil.iI1i丨I, reason: invalid class name */
/* JADX INFO: compiled from: RootUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class iI1iI implements Runnable {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final iI1iI f3187Ilil = new iI1iI();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public DataOutputStream f3189ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public BufferedReader f3188I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Process f988IL = null;

    /* JADX INFO: renamed from: I1I.I1I.ILil.iI1i丨I$IL1Iii */
    /* JADX INFO: compiled from: RootUtils.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public BufferedReader f3190ILil;

        public IL1Iii(iI1iI ii1ii, InputStream inputStream) {
            this.f3190ILil = null;
            try {
                this.f3190ILil = new BufferedReader(new InputStreamReader(inputStream));
            } catch (Exception unused) {
            }
        }

        public void IL1Iii() {
            try {
                this.f3190ILil.close();
            } catch (Exception unused) {
            }
        }

        public void ILil() {
            new Thread(this).start();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    String line = this.f3190ILil.readLine();
                    if (line != null) {
                        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 59}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 82, 90, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 94, 84, 83, 14}, "038729"))), I1I.IL1Iii.IL1Iii(new byte[]{20, 81, 2, 82, 123, 94, 8, 81, 94, 8}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 5, 82, 83, 0}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 7, 81, 1, 14}, "3ba5e9"))) + line);
                    } else {
                        Thread.sleep(50L);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public static iI1iI I1I() {
        return f3187Ilil;
    }

    public final void IL1Iii() {
        try {
            this.f3189ILil.close();
        } catch (Exception unused) {
        }
        try {
            this.f3188I1I.close();
        } catch (Exception unused2) {
        }
        try {
            this.f988IL.destroy();
        } catch (Exception unused3) {
        }
        this.f3188I1I = null;
        this.f3189ILil = null;
        this.f988IL = null;
    }

    public boolean ILil(String str, boolean z) {
        String str2 = str;
        try {
            if (this.f3189ILil == null || this.f3188I1I == null) {
                return false;
            }
            if (!str2.endsWith("\n")) {
                str2 = str2 + "\n";
            }
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 61}, I1I.IL1Iii.IL1Iii(new byte[]{12, 93, 7, 0, 11, 84}, I1I.IL1Iii.IL1Iii(new byte[]{81, 11, 0, 9, 12, 2}, "d32945"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 77, 1, 2, 15, 12}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 86, 86, 5, 7}, I1I.IL1Iii.IL1Iii(new byte[]{14, 5, 10, 84, 4, 87}, "9a8c3b"))) + str2);
            this.f3189ILil.writeBytes(str2);
            this.f3189ILil.flush();
            this.f3189ILil.writeBytes(I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 10, 91, 70}, I1I.IL1Iii.IL1Iii(new byte[]{95, 7, 7, 7, 85, 5}, I1I.IL1Iii.IL1Iii(new byte[]{95, 82, 4, 85, 3, 5}, "f7af02"))) + UUID.randomUUID().toString() + "\n");
            this.f3189ILil.flush();
            return true;
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 58}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 0, 80, 87, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 2, 1, 87, 89}, "3402d8"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 81, 85, 87, 15, 81, 11, 81, 20, 86, 17, 74, 88, 10}, I1I.IL1Iii.IL1Iii(new byte[]{85, 12, 87, 80, 84, 12}, I1I.IL1Iii.IL1Iii(new byte[]{7, 1, 1, 83, 83, 7}, "79b0d3"))) + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public synchronized boolean m958IL() {
        if (this.f988IL != null) {
            return true;
        }
        try {
            this.f988IL = Runtime.getRuntime().exec(I1I.IL1Iii.IL1Iii(new byte[]{67, 68}, I1I.IL1Iii.IL1Iii(new byte[]{6, 80, 6, 8, 12, 4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 14, 13, 0, 5}, "4b9587"))));
            this.f3188I1I = new BufferedReader(new InputStreamReader(this.f988IL.getInputStream()));
            this.f3189ILil = new DataOutputStream(this.f988IL.getOutputStream());
        } catch (Exception unused) {
            IL1Iii();
        }
        if (this.f988IL == null) {
            return false;
        }
        new Thread(this).start();
        return true;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        IL1Iii iL1Iii;
        Throwable th;
        IL1Iii iL1Iii2 = null;
        try {
            try {
                iL1Iii = new IL1Iii(this, this.f988IL.getErrorStream());
                try {
                    IL1Iii iL1Iii3 = new IL1Iii(this, this.f988IL.getInputStream());
                    iL1Iii.ILil();
                    iL1Iii3.ILil();
                    this.f988IL.waitFor();
                    iL1Iii.IL1Iii();
                } catch (Exception unused) {
                    iL1Iii2 = iL1Iii;
                    iL1Iii2.IL1Iii();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        iL1Iii.IL1Iii();
                    } catch (Exception unused2) {
                    }
                    IL1Iii();
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th3) {
                iL1Iii = null;
                th = th3;
            }
        } catch (Exception unused4) {
        }
        IL1Iii();
    }
}
