package p051lLi1LL.ILil.IL1Iii;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: HandlerPoster.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends Handler implements lIiI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int f5572I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Ll1 f5573ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f5574Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final I1I f3059IL;

    public iILLL1(I1I i1i, Looper looper, int i) {
        super(looper);
        this.f3059IL = i1i;
        this.f5572I1I = i;
        this.f5573ILil = new Ll1();
    }

    @Override // p051lLi1LL.ILil.IL1Iii.lIiI
    public void IL1Iii(lIlii lilii, Object obj) {
        ILL illIL1Iii = ILL.IL1Iii(lilii, obj);
        synchronized (this) {
            this.f5573ILil.IL1Iii(illIL1Iii);
            if (!this.f5574Ilil) {
                this.f5574Ilil = true;
                if (!sendMessage(obtainMessage())) {
                    throw new lLi1LL("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                ILL illILil = this.f5573ILil.ILil();
                if (illILil == null) {
                    synchronized (this) {
                        illILil = this.f5573ILil.ILil();
                        if (illILil == null) {
                            this.f5574Ilil = false;
                            this.f5574Ilil = false;
                            return;
                        }
                    }
                }
                this.f3059IL.m3667iILLL1(illILil);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f5572I1I);
            if (!sendMessage(obtainMessage())) {
                throw new lLi1LL("Could not send handler message");
            }
            this.f5574Ilil = true;
        } catch (Throwable th) {
            this.f5574Ilil = false;
            throw th;
        }
    }
}
