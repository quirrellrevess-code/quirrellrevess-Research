package ILil.p025ILl.IL1Iii;

import ILil.p042lIiI.IiL;
import ILil.p042lIiI.InterfaceC0641ILl;
import ILil.p042lIiI.LlLI1;
import ILil.p042lIiI.lIiI;
import ILil.p042lIiI.lIlii;
import ILil.p042lIiI.llL1ii;
import ILil.p065Ilil.iIi1;
import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: LoaderManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends ILil.p025ILl.IL1Iii.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f3953I1I = false;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IiL f3954IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final I1I f3955ILil;

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class I1I extends LlLI1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public static final llL1ii.IL1Iii f3956I1I = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public iIi1<IL1Iii> f3957ILil = new iIi1<>();

        /* JADX INFO: compiled from: LoaderManagerImpl.java */
        public static class IL1Iii implements llL1ii.IL1Iii {
            @Override // ILil.p042lIiI.llL1ii.IL1Iii
            public <T extends LlLI1> T IL1Iii(Class<T> cls) {
                return new I1I();
            }
        }

        public static I1I Ilil(lIlii lilii) {
            return (I1I) new llL1ii(lilii, f3956I1I).IL1Iii(I1I.class);
        }

        @Override // ILil.p042lIiI.LlLI1
        public void I1I() {
            super.I1I();
            if (this.f3957ILil.m1963lIiI() <= 0) {
                this.f3957ILil.ILil();
            } else {
                this.f3957ILil.m1958ILl(0).m1934L11I(true);
                throw null;
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m1931IL(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3957ILil.m1963lIiI() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.f3957ILil.m1963lIiI() <= 0) {
                    return;
                }
                IL1Iii iL1IiiM1958ILl = this.f3957ILil.m1958ILl(0);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3957ILil.m1965il(0));
                printWriter.print(": ");
                printWriter.println(iL1IiiM1958ILl.toString());
                iL1IiiM1958ILl.m1937il(str2, fileDescriptor, printWriter, strArr);
                throw null;
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void m1932lLi1LL() {
            int iM1963lIiI = this.f3957ILil.m1963lIiI();
            for (int i = 0; i < iM1963lIiI; i++) {
                this.f3957ILil.m1958ILl(i).ILL();
            }
        }
    }

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<D>] */
    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class IL1Iii<D> extends lIiI<D> {
        public final Bundle ILL;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public C0558ILil<D> f1554ILl;
        public ILil.p025ILl.ILil.IL1Iii<D> Lil;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public final ILil.p025ILl.ILil.IL1Iii<D> f1555Ll1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public IiL f1556lIiI;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public final int f1557il;

        public void ILL() {
            IiL iiL = this.f1556lIiI;
            C0558ILil<D> c0558ILil = this.f1554ILl;
            if (iiL == null || c0558ILil == null) {
                return;
            }
            super.mo1935iILLL1(c0558ILil);
            m3227IL(iiL, c0558ILil);
        }

        @Override // androidx.lifecycle.LiveData
        public void Ilil() {
            if (ILil.f3953I1I) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f1555Ll1.m1938IL();
            throw null;
        }

        @Override // ILil.p042lIiI.lIiI, androidx.lifecycle.LiveData
        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void mo1933IiL(D d) {
            super.mo1933IiL(d);
            ILil.p025ILl.ILil.IL1Iii<D> iL1Iii = this.Lil;
            if (iL1Iii == null) {
                return;
            }
            iL1Iii.I1I();
            throw null;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public ILil.p025ILl.ILil.IL1Iii<D> m1934L11I(boolean z) {
            if (ILil.f3953I1I) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f1555Ll1.IL1Iii();
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void mo1935iILLL1(InterfaceC0641ILl<? super D> interfaceC0641ILl) {
            super.mo1935iILLL1(interfaceC0641ILl);
            this.f1556lIiI = null;
        }

        @Override // androidx.lifecycle.LiveData
        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void mo1936lLi1LL() {
            if (ILil.f3953I1I) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f1555Ll1.Ilil();
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1557il);
            sb.append(" : ");
            ILil.p028IiL.p034lIiI.IL1Iii.IL1Iii(this.f1555Ll1, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void m1937il(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1557il);
            printWriter.print(" mArgs=");
            printWriter.println(this.ILL);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1555Ll1);
            this.f1555Ll1.ILil(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }
    }

    /* JADX INFO: renamed from: ILil.IL丨丨l.IL1Iii.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class C0558ILil<D> implements InterfaceC0641ILl<D> {
    }

    public ILil(IiL iiL, lIlii lilii) {
        this.f3954IL1Iii = iiL;
        this.f3955ILil = I1I.Ilil(lilii);
    }

    @Override // ILil.p025ILl.IL1Iii.IL1Iii
    public void I1I() {
        this.f3955ILil.m1932lLi1LL();
    }

    @Override // ILil.p025ILl.IL1Iii.IL1Iii
    @Deprecated
    public void IL1Iii(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3955ILil.m1931IL(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        ILil.p028IiL.p034lIiI.IL1Iii.IL1Iii(this.f3954IL1Iii, sb);
        sb.append("}}");
        return sb.toString();
    }
}
