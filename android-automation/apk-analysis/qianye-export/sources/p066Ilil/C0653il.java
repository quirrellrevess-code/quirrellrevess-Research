package p066Ilil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Ilil.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: ForwardingTimeout.java */
/* JADX INFO: loaded from: classes.dex */
public class C0653il extends lL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public lL f4598IL1Iii;

    public C0653il(lL lLVar) {
        if (lLVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4598IL1Iii = lLVar;
    }

    public final lL IL1Iii() {
        return this.f4598IL1Iii;
    }

    public final C0653il ILil(lL lLVar) {
        if (lLVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4598IL1Iii = lLVar;
        return this;
    }

    @Override // p066Ilil.lL
    public lL clearDeadline() {
        return this.f4598IL1Iii.clearDeadline();
    }

    @Override // p066Ilil.lL
    public lL clearTimeout() {
        return this.f4598IL1Iii.clearTimeout();
    }

    @Override // p066Ilil.lL
    public long deadlineNanoTime() {
        return this.f4598IL1Iii.deadlineNanoTime();
    }

    @Override // p066Ilil.lL
    public boolean hasDeadline() {
        return this.f4598IL1Iii.hasDeadline();
    }

    @Override // p066Ilil.lL
    public void throwIfReached() throws IOException {
        this.f4598IL1Iii.throwIfReached();
    }

    @Override // p066Ilil.lL
    public lL timeout(long j, TimeUnit timeUnit) {
        return this.f4598IL1Iii.timeout(j, timeUnit);
    }

    @Override // p066Ilil.lL
    public long timeoutNanos() {
        return this.f4598IL1Iii.timeoutNanos();
    }

    @Override // p066Ilil.lL
    public lL deadlineNanoTime(long j) {
        return this.f4598IL1Iii.deadlineNanoTime(j);
    }
}
