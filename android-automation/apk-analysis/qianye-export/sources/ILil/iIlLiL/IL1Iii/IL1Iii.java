package ILil.iIlLiL.IL1Iii;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: PagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final DataSetObservable f4328IL1Iii = new DataSetObservable();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public DataSetObserver f4329ILil;

    public void I11li1(DataSetObserver dataSetObserver) {
        this.f4328IL1Iii.unregisterObserver(dataSetObserver);
    }

    @Deprecated
    public void I1I(View view) {
    }

    @Deprecated
    public void IL1Iii(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public abstract boolean ILL(View view, Object obj);

    public void ILil(ViewGroup viewGroup, int i, Object obj) {
        IL1Iii(viewGroup, i, obj);
        throw null;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2479ILl(Parcelable parcelable, ClassLoader classLoader) {
    }

    public abstract int Ilil();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2480IL(ViewGroup viewGroup) {
        I1I(viewGroup);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public float m2481IiL(int i) {
        return 1.0f;
    }

    public Parcelable Lil() {
        return null;
    }

    @Deprecated
    public void LlLI1(View view, int i, Object obj) {
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2482Ll1() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f4329ILil;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f4328IL1Iii.notifyChanged();
    }

    @Deprecated
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Object m2483L11I(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void iIi1(View view) {
    }

    public void iIlLiL(ViewGroup viewGroup) {
        iIi1(viewGroup);
    }

    /* JADX INFO: renamed from: iI丨LLL1 */
    public CharSequence mo1283iILLL1(int i) {
        return null;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m2484lIiI(DataSetObserver dataSetObserver) {
        this.f4328IL1Iii.registerObserver(dataSetObserver);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m2485lIlii(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f4329ILil = dataSetObserver;
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m2486llL1ii(ViewGroup viewGroup, int i, Object obj) {
        LlLI1(viewGroup, i, obj);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m2487lLi1LL(Object obj) {
        return -1;
    }

    /* JADX INFO: renamed from: 丨il */
    public Object mo1284il(ViewGroup viewGroup, int i) {
        m2483L11I(viewGroup, i);
        throw null;
    }
}
