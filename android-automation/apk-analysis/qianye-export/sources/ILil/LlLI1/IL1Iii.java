package ILil.LlLI1;

import ILil.p042lIiI.IL;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: SavedStateRegistryController.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ILil f4311IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final SavedStateRegistry f4312ILil = new SavedStateRegistry();

    public IL1Iii(ILil iLil) {
        this.f4311IL1Iii = iLil;
    }

    public static IL1Iii IL1Iii(ILil iLil) {
        return new IL1Iii(iLil);
    }

    public void I1I(Bundle bundle) {
        IL lifecycle = this.f4311IL1Iii.getLifecycle();
        if (lifecycle.ILil() != IL.ILil.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.IL1Iii(new Recreator(this.f4311IL1Iii));
        this.f4312ILil.ILil(lifecycle, bundle);
    }

    public SavedStateRegistry ILil() {
        return this.f4312ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m2449IL(Bundle bundle) {
        this.f4312ILil.I1I(bundle);
    }
}
