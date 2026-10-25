package androidx.savedstate;

import ILil.LlLI1.ILil;
import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;
import android.annotation.SuppressLint;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class Recreator implements lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ILil f5129IL1Iii;

    public Recreator(ILil iLil) {
        this.f5129IL1Iii = iLil;
    }

    @Override // ILil.p042lIiI.lLi1LL
    public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
        if (iL1Iii != IL.IL1Iii.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        iiL.getLifecycle().I1I(this);
        Bundle bundleIL1Iii = this.f5129IL1Iii.getSavedStateRegistry().IL1Iii("androidx.savedstate.Restarter");
        if (bundleIL1Iii == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleIL1Iii.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            m3358IiL(it.next());
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m3358IiL(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.IL1Iii.class);
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.IL1Iii) declaredConstructor.newInstance(new Object[0])).IL1Iii(this.f5129IL1Iii);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }
}
