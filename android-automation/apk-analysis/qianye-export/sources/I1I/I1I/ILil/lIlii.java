package I1I.I1I.ILil;

import android.app.IAccessibServiceProxy;
import android.app.INXCoreNative;
import android.app.INXOpenFdEvent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.main.engine.TsEventNative;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: I1I.I1I.ILil.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: FileProxy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class lIlii extends INXCoreNative.Stub {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Long f3268I1I = 0L;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Map<Long, IL1Iii> f3269ILil = new HashMap();

    /* JADX INFO: renamed from: I1I.I1I.ILil.lI丨lii$IL1Iii */
    /* JADX INFO: compiled from: FileProxy.java */
    public class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public InputStream f3270IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public OutputStream f3271ILil;

        public IL1Iii(lIlii lilii, long j, int i) {
        }

        public OutputStream I1I() {
            return this.f3271ILil;
        }

        public void IL1Iii() {
            try {
                InputStream inputStream = this.f3270IL1Iii;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception unused) {
            }
            try {
                OutputStream outputStream = this.f3271ILil;
                if (outputStream != null && (outputStream instanceof FileOutputStream)) {
                    ((FileOutputStream) outputStream).getFD().sync();
                }
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{126, 97}, I1I.IL1Iii.IL1Iii(new byte[]{84, 92, 80, 86, 6, 90}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 87, 5, 81, 91}, "fff12b"))), I1I.IL1Iii.IL1Iii(new byte[]{64, 28, 15, 80, 21, 93, 65, 23, 91}, I1I.IL1Iii.IL1Iii(new byte[]{86, 86, 4, 7, 12, 1}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 86, 86, 88, 88}, "bf3baa"))) + e.toString());
            }
            try {
                OutputStream outputStream2 = this.f3271ILil;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
            } catch (Exception e2) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 110}, I1I.IL1Iii.IL1Iii(new byte[]{5, 5, 6, 3, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 4, 3, 4, 91, 4}, "e73085"))), I1I.IL1Iii.IL1Iii(new byte[]{7, 90, 13, 21, 3, 17, 1, 68, 16, 92}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 6, 4, 95, 7}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 85, 86, 92, 15}, "2114e9"))) + e2.toString());
            }
            this.f3271ILil = null;
            this.f3270IL1Iii = null;
        }

        public InputStream ILil() {
            return this.f3270IL1Iii;
        }

        public void Ilil(OutputStream outputStream) {
            this.f3271ILil = outputStream;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m1030IL(InputStream inputStream) {
            this.f3270IL1Iii = inputStream;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1029Ll1() {
        synchronized (f3268I1I) {
            Iterator<Map.Entry<Long, IL1Iii>> it = this.f3269ILil.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    it.next().getValue().IL1Iii();
                } catch (Exception unused) {
                }
                it.remove();
            }
        }
    }

    @Override // android.app.INXCoreNative
    public void closeFile(long j) throws RemoteException {
        Map<Long, IL1Iii> map;
        Long lValueOf;
        synchronized (f3268I1I) {
            IL1Iii iL1Iii = this.f3269ILil.get(Long.valueOf(j));
            if (iL1Iii != null) {
                try {
                    try {
                        iL1Iii.IL1Iii();
                    } catch (Throwable th) {
                        this.f3269ILil.remove(Long.valueOf(j));
                        throw th;
                    }
                } catch (Exception e) {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 61}, I1I.IL1Iii.IL1Iii(new byte[]{83, 92, 0, 4, 10, 87}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 4, 89, 6, 80}, "18385d"))), I1I.IL1Iii.IL1Iii(new byte[]{82, 93, 12, 21, 82, 18, 84, 67, 17, 92}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 85, 84, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 12, 3, 10, 1, 6}, "b85844"))) + e.toString());
                    map = this.f3269ILil;
                    lValueOf = Long.valueOf(j);
                }
            }
            map = this.f3269ILil;
            lValueOf = Long.valueOf(j);
            map.remove(lValueOf);
        }
    }

    public llliI obtainAccessibityActionProxy() {
        return null;
    }

    public IAccessibServiceProxy obtainAccessibityService() {
        return null;
    }

    public Bundle obtainData(int i) {
        return null;
    }

    @Override // android.app.INXCoreNative
    public long openFile(String str, int i) throws RemoteException {
        synchronized (f3268I1I) {
            long jLongValue = f3268I1I.longValue() + 1;
            try {
                if (i == 1) {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    IL1Iii iL1Iii = new IL1Iii(this, jLongValue, i);
                    iL1Iii.m1030IL(fileInputStream);
                    this.f3269ILil.put(Long.valueOf(jLongValue), iL1Iii);
                    f3268I1I = Long.valueOf(jLongValue);
                    return jLongValue;
                }
                if (i == 2) {
                    new File(str).createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    IL1Iii iL1Iii2 = new IL1Iii(this, jLongValue, i);
                    iL1Iii2.Ilil(fileOutputStream);
                    this.f3269ILil.put(Long.valueOf(jLongValue), iL1Iii2);
                    f3268I1I = Long.valueOf(jLongValue);
                    return jLongValue;
                }
                return 0L;
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 106}, I1I.IL1Iii.IL1Iii(new byte[]{12, 86, 3, 83, 92, 4}, I1I.IL1Iii.IL1Iii(new byte[]{12, 83, 87, 1, 12, 82}, "47e05f"))), I1I.IL1Iii.IL1Iii(new byte[]{90, 64, 0, 93, 66, 84, 92, 92, 0, 9}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 85, 87, 7, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 6, 87, 87, 0}, "e0632b"))) + str + I1I.IL1Iii.IL1Iii(new byte[]{68, 3, 67, 17, 16}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 9, 81, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 12, 4, 3, 91}, "e04668"))) + e.toString());
            }
        }
    }

    @Override // android.app.INXCoreNative
    public boolean openFileNew(String str, String str2, INXOpenFdEvent iNXOpenFdEvent) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        int mode = ParcelFileDescriptor.parseMode(str2);
        ParcelFileDescriptor parcelFileDescriptorOpen = null;
        try {
            parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, mode);
            return iNXOpenFdEvent.onOpend(parcelFileDescriptorOpen);
        } catch (Exception unused) {
            if (parcelFileDescriptorOpen == null) {
                return false;
            }
            try {
                return false;
            } catch (Exception unused2) {
                return false;
            }
        } finally {
            if (parcelFileDescriptorOpen != null) {
                try {
                    parcelFileDescriptorOpen.close();
                } catch (Exception unused3) {
                }
            }
        }
    }

    @Override // android.app.INXCoreNative
    public long readFile(long j, byte[] bArr) throws RemoteException {
        InputStream inputStreamILil;
        synchronized (f3268I1I) {
            IL1Iii iL1Iii = this.f3269ILil.get(Long.valueOf(j));
            inputStreamILil = iL1Iii != null ? iL1Iii.ILil() : null;
        }
        try {
            return inputStreamILil.read(bArr);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public boolean sendKeyEvent(int i, int i2) {
        return LlLiLL.IL1Iii().Ilil(i, i2);
    }

    public void sendLog(int i, String str, String str2, long j, boolean z) {
    }

    public void sendTaskResultBundle(int i, long j, Bundle bundle) {
    }

    public boolean sendTouchEvent(int i, int i2, int i3, int i4) {
        return LlLiLL.IL1Iii().m929lLi1LL(i, i2, i3, i4);
    }

    @Override // android.app.INXCoreNative
    public void setTsEventListener(int i, LL1IL ll1il) {
        TsEventNative.setITsEventListener(i, ll1il);
    }

    @Override // android.app.INXCoreNative
    public long writeFile(long j, byte[] bArr, int i, int i2) throws RemoteException {
        OutputStream outputStreamI1I;
        synchronized (f3268I1I) {
            IL1Iii iL1Iii = this.f3269ILil.get(Long.valueOf(j));
            outputStreamI1I = iL1Iii != null ? iL1Iii.I1I() : null;
        }
        try {
            outputStreamI1I.write(bArr, i, i2);
            outputStreamI1I.flush();
            return i2;
        } catch (Exception unused) {
            return 0L;
        }
    }
}
