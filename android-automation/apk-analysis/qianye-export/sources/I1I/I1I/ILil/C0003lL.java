package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.graphics.Point;
import com.main.engine.RotateMgr;

/* JADX INFO: renamed from: I1I.I1I.ILil.lL */
/* JADX INFO: compiled from: VirDispMonister.java */
/* JADX INFO: loaded from: classes.dex */
public class C0003lL {

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static C0003lL f1036iILLL1;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f3273IL1Iii = 0;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3274ILil = 0;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3272I1I = 0;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1037IL = 0;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3275Ilil = -1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil f1038lLi1LL = null;

    /* JADX INFO: renamed from: I1I.I1I.ILil.lL$IL1Iii */
    /* JADX INFO: compiled from: VirDispMonister.java */
    public class IL1Iii implements RotateMgr.IL1Iii {
        public IL1Iii() {
        }

        @Override // com.main.engine.RotateMgr.IL1Iii
        public void IL1Iii(int i) {
            C0003lL.this.IL1Iii(i);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.lL$ILil */
    /* JADX INFO: compiled from: VirDispMonister.java */
    public interface ILil {
        void IL1Iii(int i, int i2, int i3, int i4, int i5);
    }

    public static C0003lL I1I() {
        synchronized (C0003lL.class) {
            if (f1036iILLL1 == null) {
                f1036iILLL1 = new C0003lL();
            }
        }
        return f1036iILLL1;
    }

    public synchronized void IL1Iii(int i) {
        ILil iLil = this.f1038lLi1LL;
        if (iLil != null) {
            iLil.IL1Iii(this.f3273IL1Iii, this.f3274ILil, this.f3272I1I, this.f1037IL, i);
        }
        this.f3275Ilil = i;
    }

    public int ILil() {
        return this.f3275Ilil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1031IL(ILil iLil) {
        if (iLil != null && this.f1038lLi1LL == null) {
            this.f1038lLi1LL = iLil;
            Point pointM1180ILI = lIlii.m1180ILI();
            this.f3272I1I = pointM1180ILI.x;
            this.f1037IL = pointM1180ILI.y;
            Point pointILI1Ll = lIlii.ILI1Ll();
            this.f3273IL1Iii = pointILI1Ll.x;
            this.f3274ILil = pointILI1Ll.y;
            try {
                RotateMgr.m3485IL().Ilil(new IL1Iii());
            } catch (Exception unused) {
            }
        }
    }
}
