package androidx.lifecycle;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.InterfaceC0642il;
import ILil.p042lIiI.L11I;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IL1Iii f5042ILil;

    public interface IL1Iii {
        void IL1Iii();

        void ILil();

        void onResume();
    }

    public static void Ilil(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void I1I(IL1Iii iL1Iii) {
        if (iL1Iii != null) {
            iL1Iii.onResume();
        }
    }

    public final void IL1Iii(IL.IL1Iii iL1Iii) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof InterfaceC0642il) {
            ((InterfaceC0642il) activity).getLifecycle().m2507L11I(iL1Iii);
        } else if (activity instanceof IiL) {
            IL lifecycle = ((IiL) activity).getLifecycle();
            if (lifecycle instanceof L11I) {
                ((L11I) lifecycle).m2507L11I(iL1Iii);
            }
        }
    }

    public final void ILil(IL1Iii iL1Iii) {
        if (iL1Iii != null) {
            iL1Iii.IL1Iii();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3231IL(IL1Iii iL1Iii) {
        if (iL1Iii != null) {
            iL1Iii.ILil();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ILil(this.f5042ILil);
        IL1Iii(IL.IL1Iii.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IL1Iii(IL.IL1Iii.ON_DESTROY);
        this.f5042ILil = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        IL1Iii(IL.IL1Iii.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        I1I(this.f5042ILil);
        IL1Iii(IL.IL1Iii.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m3231IL(this.f5042ILil);
        IL1Iii(IL.IL1Iii.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        IL1Iii(IL.IL1Iii.ON_STOP);
    }
}
