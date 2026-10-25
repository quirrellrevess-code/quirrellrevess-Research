package I1I.I1I.ILil;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: I1I.I1I.ILil.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: DataTaskProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI extends l.IL1Iii {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static lIiI f3261Ilil;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Long f1034lLi1LL = new Long(0);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Map<Long, ILil> f3262I1I = new ConcurrentHashMap();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public I1I f1035IL;

    /* JADX INFO: renamed from: I1I.I1I.ILil.lIi丨I$I1I */
    /* JADX INFO: compiled from: DataTaskProxy.java */
    public interface I1I {
        byte[] IL1Iii(int i);
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.lIi丨I$ILil */
    /* JADX INFO: compiled from: DataTaskProxy.java */
    public class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public byte[] f3263IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3264ILil;

        public ILil(lIiI liii) {
        }
    }

    public lIiI(I1I i1i) {
        this.f1035IL = i1i;
        f3261Ilil = this;
    }

    public static lIiI Ilil() {
        return f3261Ilil;
    }

    @Override // I1I.I1I.ILil.l
    public Bundle I1I(int i, long j) throws RemoteException {
        ILil iLil = this.f3262I1I.get(Long.valueOf(j));
        I1I i1i = this.f1035IL;
        byte[] bArr = null;
        byte b = 0;
        if (i1i == null) {
            return null;
        }
        boolean z = false;
        if (iLil == null) {
            byte[] bArrIL1Iii = i1i.IL1Iii(i);
            if (bArrIL1Iii == null) {
                return null;
            }
            iLil = new ILil();
            iLil.f3263IL1Iii = bArrIL1Iii;
            iLil.f3264ILil = 0;
            this.f3262I1I.put(Long.valueOf(j), iLil);
        }
        int i2 = iLil.f3264ILil;
        int i3 = i2 + 10240;
        byte[] bArr2 = iLil.f3263IL1Iii;
        if (i3 <= bArr2.length) {
            bArr = new byte[10240];
            System.arraycopy(bArr2, i2, bArr, 0, 10240);
            iLil.f3264ILil += 10240;
        } else if (bArr2.length - i2 > 0) {
            bArr = new byte[bArr2.length - i2];
            System.arraycopy(bArr2, i2, bArr, 0, bArr2.length - i2);
            iLil.f3264ILil = iLil.f3263IL1Iii.length;
        } else {
            z = true;
            this.f3262I1I.remove(Long.valueOf(j));
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray(I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 16, 4, 114, 10, 65, 91, 15}, I1I.IL1Iii.IL1Iii(new byte[]{81, 2, 83, 7, 83, 91}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 3, 91, 4, 93}, "0549fd"))), bArr);
        bundle.putBoolean(I1I.IL1Iii.IL1Iii(new byte[]{88, 67, 109, 83, 16, 95, 114, 95, 84, 66, 15, 81, 69, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 9, 10, 84, 12}, I1I.IL1Iii.IL1Iii(new byte[]{13, 5, 0, 1, 82, 12}, "9f09e4"))), z);
        return bundle;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1023IL() {
        this.f3262I1I.clear();
    }

    @Override // I1I.I1I.ILil.l
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public long mo1024iILLL1() {
        long j;
        synchronized (f1034lLi1LL) {
            j = 1;
            long jLongValue = f1034lLi1LL.longValue() + 1;
            if (jLongValue != RecyclerView.FOREVER_NS) {
                j = jLongValue;
            }
            f1034lLi1LL = Long.valueOf(j);
        }
        return j;
    }
}
