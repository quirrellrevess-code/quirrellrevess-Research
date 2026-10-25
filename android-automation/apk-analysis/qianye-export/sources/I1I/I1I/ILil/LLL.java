package I1I.I1I.ILil;

import android.app.INXCoreShell;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.main.app.Native;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: RootShellEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class LLL extends INXCoreShell.Stub {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final LLL f961IL = new LLL();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Object f3154ILil = new Object();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public INXCoreShell f3153I1I = null;

    /* JADX INFO: compiled from: RootShellEngine.java */
    public class IL1Iii implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ IBinder f3155IL1Iii;

        public IL1Iii(IBinder iBinder) {
            this.f3155IL1Iii = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (LLL.this.f3153I1I.asBinder() == this.f3155IL1Iii) {
                LLL.this.f3153I1I = null;
            }
            try {
                this.f3155IL1Iii.unlinkToDeath(this, 0);
            } catch (Exception unused) {
            }
            LLL.this.f3153I1I = null;
        }
    }

    public static LLL ILL() {
        return f961IL;
    }

    public boolean Ilil() {
        try {
            INXCoreShell iNXCoreShell = this.f3153I1I;
            return iNXCoreShell != null && iNXCoreShell.asBinder().pingBinder();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int m920Ll1(Context context, int i, int i2, int i3, int i4, int i5) {
        if (Ilil()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{87, 18, 65, 70, 74, 72, 81}, I1I.IL1Iii.IL1Iii(new byte[]{81, 3, 1, 1, 81, 9}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 87, 0, 80, 8}, "2ab329"))), Native.getNativeType());
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{79, 84, 68, 65, 90, 9, 87}, I1I.IL1Iii.IL1Iii(new byte[]{9, 2, 82, 2, 82, 95}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 82, 7, 2, 12}, "1067c5"))), i);
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{17}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 7, 12, 82, 7}, I1I.IL1Iii.IL1Iii(new byte[]{7, 93, 9, 1, 5, 86}, "d8981d"))), i2);
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{93}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 13, 0, 12, 1}, I1I.IL1Iii.IL1Iii(new byte[]{5, 9, 93, 91, 84, 82}, "19eca7"))), i3);
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{83, 20}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 84, 82, 7, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 7, 82, 3, 80}, "7a1a11"))), i4);
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{92, 90}, I1I.IL1Iii.IL1Iii(new byte[]{89, 2, 86, 84, 83, 94}, I1I.IL1Iii.IL1Iii(new byte[]{89, 4, 9, 9, 11, 0}, "849998"))), i5);
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{86, 18, 15}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 82, 7, 82, 90}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 4, 83, 2, 11}, "fa2e52"))), context.getApplicationInfo().sourceDir);
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{90, 91, 3, 85, 88, 64}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 3, 3, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 4, 80, 80, 7}, "abfb41"))), context.getApplicationInfo().nativeLibraryDir);
                try {
                    if (this.f3153I1I.sendCmd(256, 0, 0, jSONObject.toString()).compareTo(I1I.IL1Iii.IL1Iii(new byte[]{93, 13}, I1I.IL1Iii.IL1Iii(new byte[]{83, 2, 2, 1, 0, 86}, I1I.IL1Iii.IL1Iii(new byte[]{85, 93, 6, 0, 10, 2}, "49543c")))) == 0) {
                        return 1;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m921lIiI(Context context, Bundle bundle) {
        synchronized (this.f3154ILil) {
            try {
                IBinder binder = bundle.getBinder(I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 8, 79, 12, 73, 31, 91, 10, 19, 7, 31, 70, 74, 4, 17, 18, 84, 67, 75, 75, 8, 12, 69, 84, 86, 17, 79, 7, 73, 69, 74, 4, 79, 32, 120, 127, 124, 32, 51}, I1I.IL1Iii.IL1Iii(new byte[]{85, 15, 92, 84, 87, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 0, 1, 87, 2}, "1294bc"))));
                if (binder != null && binder.pingBinder()) {
                    this.f3153I1I = INXCoreShell.Stub.asInterface(binder);
                    binder.linkToDeath(new IL1Iii(binder), 0);
                }
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 57}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 0, 3, 81, 94}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 84, 14, 8, 14}, "3d5986"))), I1I.IL1Iii.IL1Iii(new byte[]{69, 93, 76, 119, 93, 19, 83, 118, 89, 64, 91, 23, 83, 24, 93, 70, 64, 92, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 9, 93, 13, 2, 80}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 84, 92, 6, 9}, "a51e68"))) + e.toString());
            }
        }
    }

    @Override // android.app.INXCoreShell
    public ParcelFileDescriptor openFileNew(String str, String str2) throws RemoteException {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return ParcelFileDescriptor.open(file, ParcelFileDescriptor.parseMode(str2));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.app.INXCoreShell
    public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
        return null;
    }
}
