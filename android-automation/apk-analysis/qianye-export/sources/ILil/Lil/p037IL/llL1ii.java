package ILil.Lil.p037IL;

import android.view.View;
import com.mysql.jdbc.MysqlErrorNumbers;

/* JADX INFO: renamed from: ILil.Lil.I丨L.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ILil f4294IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IL1Iii f4295ILil = new IL1Iii();

    /* JADX INFO: renamed from: ILil.Lil.I丨L.ll丨L1ii$IL1Iii */
    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    public static class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4296I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4297IL1Iii = 0;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4298ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4299Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1773IL;

        public int I1I(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public void IL1Iii(int i) {
            this.f4297IL1Iii = i | this.f4297IL1Iii;
        }

        public boolean ILil() {
            int i = this.f4297IL1Iii;
            if ((i & 7) != 0 && (i & (I1I(this.f1773IL, this.f4298ILil) << 0)) == 0) {
                return false;
            }
            int i2 = this.f4297IL1Iii;
            if ((i2 & 112) != 0 && (i2 & (I1I(this.f1773IL, this.f4296I1I) << 4)) == 0) {
                return false;
            }
            int i3 = this.f4297IL1Iii;
            if ((i3 & MysqlErrorNumbers.ER_CANT_EXECUTE_IN_READ_ONLY_TRANSACTION) != 0 && (i3 & (I1I(this.f4299Ilil, this.f4298ILil) << 8)) == 0) {
                return false;
            }
            int i4 = this.f4297IL1Iii;
            return (i4 & 28672) == 0 || (i4 & (I1I(this.f4299Ilil, this.f4296I1I) << 12)) != 0;
        }

        public void Ilil(int i, int i2, int i3, int i4) {
            this.f4298ILil = i;
            this.f4296I1I = i2;
            this.f1773IL = i3;
            this.f4299Ilil = i4;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m2438IL() {
            this.f4297IL1Iii = 0;
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.ll丨L1ii$ILil */
    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    public interface ILil {
        int I1I();

        View IL1Iii(int i);

        int ILil(View view);

        int Ilil(View view);

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        int mo2439IL();
    }

    public llL1ii(ILil iLil) {
        this.f4294IL1Iii = iLil;
    }

    public View IL1Iii(int i, int i2, int i3, int i4) {
        int iI1I = this.f4294IL1Iii.I1I();
        int iMo2439IL = this.f4294IL1Iii.mo2439IL();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewIL1Iii = this.f4294IL1Iii.IL1Iii(i);
            this.f4295ILil.Ilil(iI1I, iMo2439IL, this.f4294IL1Iii.ILil(viewIL1Iii), this.f4294IL1Iii.Ilil(viewIL1Iii));
            if (i3 != 0) {
                this.f4295ILil.m2438IL();
                this.f4295ILil.IL1Iii(i3);
                if (this.f4295ILil.ILil()) {
                    return viewIL1Iii;
                }
            }
            if (i4 != 0) {
                this.f4295ILil.m2438IL();
                this.f4295ILil.IL1Iii(i4);
                if (this.f4295ILil.ILil()) {
                    view = viewIL1Iii;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean ILil(View view, int i) {
        this.f4295ILil.Ilil(this.f4294IL1Iii.I1I(), this.f4294IL1Iii.mo2439IL(), this.f4294IL1Iii.ILil(view), this.f4294IL1Iii.Ilil(view));
        if (i == 0) {
            return false;
        }
        this.f4295ILil.m2438IL();
        this.f4295ILil.IL1Iii(i);
        return this.f4295ILil.ILil();
    }
}
