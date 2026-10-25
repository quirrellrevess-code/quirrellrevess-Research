package androidx.savedstate;

import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;
import android.annotation.SuppressLint;
import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5130I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ILil.I1I.IL1Iii.ILil.ILil<String, ILil> f5131IL1Iii = new ILil.I1I.IL1Iii.ILil.ILil<>();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Bundle f5132ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2736IL;

    public interface IL1Iii {
        void IL1Iii(ILil.LlLI1.ILil iLil);
    }

    public interface ILil {
        Bundle IL1Iii();
    }

    public void I1I(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f5132ILil;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        ILil.I1I.IL1Iii.ILil.ILil<String, ILil>.IL ilM1441IL = this.f5131IL1Iii.m1441IL();
        while (ilM1441IL.hasNext()) {
            Map.Entry next = ilM1441IL.next();
            bundle2.putBundle((String) next.getKey(), ((ILil) next.getValue()).IL1Iii());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public Bundle IL1Iii(String str) {
        if (!this.f5130I1I) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f5132ILil;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f5132ILil.remove(str);
        if (this.f5132ILil.isEmpty()) {
            this.f5132ILil = null;
        }
        return bundle2;
    }

    public void ILil(IL il, Bundle bundle) {
        if (this.f5130I1I) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f5132ILil = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        il.IL1Iii(new lLi1LL() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // ILil.p042lIiI.lLi1LL
            public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
                if (iL1Iii == IL.IL1Iii.ON_START) {
                    SavedStateRegistry.this.f2736IL = true;
                } else if (iL1Iii == IL.IL1Iii.ON_STOP) {
                    SavedStateRegistry.this.f2736IL = false;
                }
            }
        });
        this.f5130I1I = true;
    }
}
