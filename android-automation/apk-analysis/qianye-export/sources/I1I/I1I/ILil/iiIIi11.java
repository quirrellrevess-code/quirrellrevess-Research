package I1I.I1I.ILil;

import android.app.IUiAutomationConnection;
import android.app.UiAutomation;
import android.app.UiAutomationConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.iiIIi丨11, reason: invalid class name */
/* JADX INFO: compiled from: UiAutomationConnector.java */
/* JADX INFO: loaded from: classes.dex */
public class iiIIi11 {

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f1028lLi1LL = I1I.IL1Iii.IL1Iii(new byte[]{108, 94, 117, 77, 22, 11, 84, 86, 64, 87, 16, 44, 88, 89, 80, 84, 7, 22, 109, 95, 70, 93, 3, 0}, I1I.IL1Iii.IL1Iii(new byte[]{88, 7, 0, 0, 82, 93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 87, 13, 3, 95}, "adc53f")));

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Method f3246I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public HandlerThread f3247IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public UiAutomation f3248ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Method f3249Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Method f1029IL;

    public iiIIi11() throws NoSuchMethodException {
        try {
            this.f1029IL = UiAutomation.class.getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{5, 12, 95, 88, 83, 1, 18}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 2, 7, 15, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 85, 9, 14, 85}, "0af871"))), Integer.TYPE);
        } catch (Exception unused) {
        }
        try {
            this.f3249Ilil = UiAutomation.class.getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{1, 93, 93, 88, 0, 90, 22}, I1I.IL1Iii.IL1Iii(new byte[]{91, 10, 11, 15, 3, 88}, I1I.IL1Iii.IL1Iii(new byte[]{1, 93, 14, 91, 85, 80}, "8e6b31"))), new Class[0]);
        } catch (Exception unused2) {
        }
        this.f3246I1I = UiAutomation.class.getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 16, 86, 88, 94, 10, 80, 0, 65}, I1I.IL1Iii.IL1Iii(new byte[]{81, 87, 2, 7, 2, 7}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 88, 86, 2, 6}, "7d9d71"))), new Class[0]);
    }

    public UiAutomation I1I() {
        return this.f3248ILil;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005a A[Catch: Exception -> 0x005e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:6:0x0013, B:16:0x005a, B:10:0x004d), top: B:21:0x0013 }] */
    public boolean IL1Iii() throws Exception {
        boolean z = true;
        if (this.f3247IL1Iii != null) {
            return true;
        }
        HandlerThread handlerThread = new HandlerThread(f1028lLi1LL);
        this.f3247IL1Iii = handlerThread;
        handlerThread.start();
        try {
            UiAutomation uiAutomation = (UiAutomation) UiAutomation.class.getConstructor(Looper.class, IUiAutomationConnection.class).newInstance(this.f3247IL1Iii.getLooper(), new UiAutomationConnection());
            this.f3248ILil = uiAutomation;
            Method method = this.f1029IL;
            try {
                if (method == null) {
                    Method method2 = this.f3249Ilil;
                    if (method2 != null) {
                        method2.invoke(uiAutomation, new Object[0]);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        ILil();
                    }
                    return z;
                }
                method.invoke(uiAutomation, 1);
            } catch (Exception unused) {
            }
            if (!z) {
                ILil();
            }
            return z;
        } catch (Exception unused2) {
            ILil();
            return false;
        }
    }

    public void ILil() {
        if (this.f3247IL1Iii != null) {
            try {
                this.f3246I1I.invoke(this.f3248ILil, new Object[0]);
            } catch (Exception unused) {
            }
            try {
                this.f3247IL1Iii.quit();
            } catch (Exception unused2) {
            }
            this.f3248ILil = null;
            this.f3247IL1Iii = null;
        }
    }
}
