package p051lLi1LL.ILil.IL1Iii;

import android.os.Looper;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: MainThreadSupport.java */
/* JADX INFO: loaded from: classes.dex */
public interface L11I {

    /* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.L丨1丨1丨I$IL1Iii */
    /* JADX INFO: compiled from: MainThreadSupport.java */
    public static class IL1Iii implements L11I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Looper f5569IL1Iii;

        public IL1Iii(Looper looper) {
            this.f5569IL1Iii = looper;
        }

        @Override // p051lLi1LL.ILil.IL1Iii.L11I
        public lIiI IL1Iii(I1I i1i) {
            return new iILLL1(i1i, this.f5569IL1Iii, 10);
        }

        @Override // p051lLi1LL.ILil.IL1Iii.L11I
        public boolean ILil() {
            return this.f5569IL1Iii == Looper.myLooper();
        }
    }

    lIiI IL1Iii(I1I i1i);

    boolean ILil();
}
