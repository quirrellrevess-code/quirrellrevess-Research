package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.app.INXCoreNative;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.main.app.AccRequestActivity;
import com.main.app.RSNativeActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: HandleEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class I11li1 extends lIlii implements C1 {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f922IL;

    /* JADX INFO: compiled from: HandleEngine.java */
    public class IL1Iii implements I11L {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ WeakReference f3087IL1Iii;

        public IL1Iii(I11li1 i11li1, WeakReference weakReference) {
            this.f3087IL1Iii = weakReference;
        }

        @Override // I1I.I1I.ILil.I11L
        public void IL1Iii() {
            boolean[] zArr = (boolean[]) this.f3087IL1Iii.get();
            if (zArr != null) {
                zArr[0] = true;
            }
        }

        @Override // I1I.I1I.ILil.I11L
        public void ILil() {
        }
    }

    /* JADX INFO: compiled from: HandleEngine.java */
    public class ILil implements I11L {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ WeakReference f3088IL1Iii;

        public ILil(I11li1 i11li1, WeakReference weakReference) {
            this.f3088IL1Iii = weakReference;
        }

        @Override // I1I.I1I.ILil.I11L
        public void IL1Iii() {
            boolean[] zArr = (boolean[]) this.f3088IL1Iii.get();
            if (zArr != null) {
                zArr[0] = true;
            }
        }

        @Override // I1I.I1I.ILil.I11L
        public void ILil() {
        }
    }

    @Override // I1I.I1I.ILil.C1
    public void ILL(Context context, LlLLL llLLL) {
        llLLL.ILil();
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m847ILl(Context context, boolean z) {
        if (iIilII1.LLL().m970I1L11L()) {
            return true;
        }
        WeakReference weakReference = new WeakReference(new boolean[]{false});
        RSNativeActivity.ILil(context, new IL1Iii(this, weakReference));
        if (z) {
            for (int i = 0; i < 10; i++) {
                boolean[] zArr = (boolean[]) weakReference.get();
                if (zArr != null && zArr[0]) {
                    return iIilII1.LLL().m970I1L11L();
                }
                if (iIilII1.LLL().m970I1L11L()) {
                    return true;
                }
                try {
                    Thread.sleep(500L);
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    @Override // I1I.I1I.ILil.C1
    public String Ilil(int i, int i2, int i3, String str) {
        return null;
    }

    @Override // I1I.I1I.ILil.C1
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void mo848IL(Context context, Bundle bundle) {
        ILL ill = this.f922IL;
        if (ill != null) {
            ill.I1I();
        }
        this.f922IL = new ILL(this, bundle, null);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m849lIiI(Context context, boolean z) {
        if (lIlii.Ilil()) {
            return true;
        }
        WeakReference weakReference = new WeakReference(new boolean[]{false});
        AccRequestActivity.ILil(context, new ILil(this, weakReference));
        if (z) {
            for (int i = 0; i < 10; i++) {
                boolean[] zArr = (boolean[]) weakReference.get();
                if (zArr != null && zArr[0]) {
                    return lIlii.Ilil();
                }
                if (lIlii.Ilil()) {
                    return true;
                }
                try {
                    Thread.sleep(500L);
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    @Override // android.app.INXCoreNative
    public l obtainDataTask() throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public L111 obtainUiObjectProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
        return null;
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
        return null;
    }
}
