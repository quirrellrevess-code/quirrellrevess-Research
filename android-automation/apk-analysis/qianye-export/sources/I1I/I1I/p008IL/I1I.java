package I1I.I1I.p008IL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.main.app.MainService;
import com.qyzs.smn2.R;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: BootManager.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static I1I f1060iILLL1;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3321IL1Iii;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String f3319Ilil = I1I.IL1Iii.IL1Iii(new byte[]{81, 94, 14, 69, 62, 69, 90, 92, 4, 110, 17, 67, 86, 87, 18}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 5, 85, 86, 9}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 7, 82, 7, 90}, "4ec60b")));

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f1061lLi1LL = I1I.IL1Iii.IL1Iii(new byte[]{88, 3, 17, 76, 107, 3, 91, 13, 22, 103, 64, 8, 89, 7}, I1I.IL1Iii.IL1Iii(new byte[]{86, 91, 4, 10, 1, 2}, I1I.IL1Iii.IL1Iii(new byte[]{3, 91, 81, 81, 83, 84}, "ab7cf7")));

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f3322ILil = false;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Intent f1062IL = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Handler f3320I1I = new IL1Iii();

    /* JADX INFO: compiled from: BootManager.java */
    public class IL1Iii extends Handler {
        public IL1Iii() {
        }

        @Override // android.os.Handler
        @SuppressLint({"HandlerLeak"})
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 256) {
                if (I1I.this.f3322ILil) {
                    return;
                }
                I1I i1i = I1I.this;
                i1i.m1059L11I(i1i.f3321IL1Iii);
                return;
            }
            if (i == 257) {
                I1I i1i2 = I1I.this;
                i1i2.m1062il(i1i2.f3321IL1Iii);
            }
        }
    }

    public static synchronized I1I Ilil() {
        if (f1060iILLL1 == null) {
            f1060iILLL1 = new I1I();
        }
        return f1060iILLL1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1057IL() {
        this.f3322ILil = true;
        if (this.f3320I1I.hasMessages(256)) {
            this.f3320I1I.removeMessages(256);
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final long m1058IiL(Context context) {
        return context.getSharedPreferences(f3319Ilil, 0).getLong(f1061lLi1LL, -1L);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m1059L11I(Context context) {
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 62}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 10, 90, 81, 8}, I1I.IL1Iii.IL1Iii(new byte[]{81, 80, 15, 1, 2, 0}, "4b7b71"))), I1I.IL1Iii.IL1Iii(new byte[]{64, 18, 85, 75, 23, 113, 67, 22, 9, 4, 93}, I1I.IL1Iii.IL1Iii(new byte[]{10, 81, 0, 12, 86, 82}, I1I.IL1Iii.IL1Iii(new byte[]{14, 82, 1, 0, 81, 84}, "7e55d6"))) + context + I1I.IL1Iii.IL1Iii(new byte[]{93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 95, 82, 83, 84}, I1I.IL1Iii.IL1Iii(new byte[]{5, 93, 94, 7, 84, 81}, "c88cd3"))) + lIlii.m1173lIlii(context) + I1I.IL1Iii.IL1Iii(new byte[]{13}, I1I.IL1Iii.IL1Iii(new byte[]{5, 8, 83, 86, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{85, 90, 83, 13, 84, 1}, "fc78fb"))) + lIlii.m1188iIIi1(context));
        if (this.f1062IL == null && lIlii.m1188iIIi1(context) && !lIlii.Ll1(context) && lIlii.m1173lIlii(context) && lIlii.m15LL(context, R.id.switch_bootstart, lIlii.m1162ill(context))) {
            Intent intent = new Intent(context, (Class<?>) MainService.class);
            this.f1062IL = intent;
            intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 16, 10, 92, 8}, I1I.IL1Iii.IL1Iii(new byte[]{81, 92, 83, 83, 0, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 9, 7, 5, 85, 3}, "f005ff"))), I1I.IL1Iii.IL1Iii(new byte[]{18, 68, 0, 70, 64}, I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 84, 6, 2, 8}, I1I.IL1Iii.IL1Iii(new byte[]{1, 5, 84, 10, 83, 8}, "b1a8e9"))));
            this.f1062IL.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            context.startService(this.f1062IL);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean m1060iILLL1(Context context) {
        long jM1058IiL = m1058IiL(context);
        if (jM1058IiL == -1 || jM1058IiL > SystemClock.elapsedRealtime()) {
            m1062il(context);
            return true;
        }
        m1062il(context);
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1061lLi1LL(Context context) {
        if (this.f3321IL1Iii == null) {
            this.f3321IL1Iii = context;
            if (m1060iILLL1(context)) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 58}, I1I.IL1Iii.IL1Iii(new byte[]{3, 90, 3, 0, 3, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 91, 7, 8, 83, 91}, "6cb92c"))), I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 9, 23, 67, 9, 88, 4, 91, 93}, I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 82, 81, 87, 85}, I1I.IL1Iii.IL1Iii(new byte[]{81, 12, 0, 83, 6, 3}, "784a20"))) + context);
                this.f3320I1I.sendEmptyMessageDelayed(256, 10000L);
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final void m1062il(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(f3319Ilil, 0).edit();
            editorEdit.putLong(f1061lLi1LL, jElapsedRealtime);
            editorEdit.apply();
            this.f3320I1I.sendEmptyMessageDelayed(Imgcodecs.IMWRITE_TIFF_XDPI, 60000L);
        } catch (Exception unused) {
        }
    }
}
