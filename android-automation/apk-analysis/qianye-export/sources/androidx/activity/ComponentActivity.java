package androidx.activity;

import ILil.IL1Iii.I1I;
import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.L11I;
import ILil.p042lIiI.iIi1;
import ILil.p042lIiI.lIlii;
import ILil.p042lIiI.lLi1LL;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.ReportFragment;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements IiL, iIi1, ILil.LlLI1.ILil, I1I {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public lIlii f4731Ilil;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2193iILLL1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final L11I f4730I1I = new L11I(this);

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final ILil.LlLI1.IL1Iii f2192IL = ILil.LlLI1.IL1Iii.IL1Iii(this);

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final OnBackPressedDispatcher f2194lLi1LL = new OnBackPressedDispatcher(new IL1Iii());

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    public static final class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Object f4735IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public lIlii f4736ILil;
    }

    public ComponentActivity() {
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            getLifecycle().IL1Iii(new lLi1LL() { // from class: androidx.activity.ComponentActivity.2
                @Override // ILil.p042lIiI.lLi1LL
                public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
                    if (iL1Iii == IL.IL1Iii.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().IL1Iii(new lLi1LL() { // from class: androidx.activity.ComponentActivity.3
            @Override // ILil.p042lIiI.lLi1LL
            public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
                if (iL1Iii != IL.IL1Iii.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.getViewModelStore().IL1Iii();
            }
        });
        if (19 > i || i > 23) {
            return;
        }
        getLifecycle().IL1Iii(new ImmLeaksCleaner(this));
    }

    @Override // ILil.IL1Iii.I1I
    public final OnBackPressedDispatcher ILil() {
        return this.f2194lLi1LL;
    }

    @Override // androidx.core.app.ComponentActivity, ILil.p042lIiI.IiL
    public IL getLifecycle() {
        return this.f4730I1I;
    }

    @Override // ILil.LlLI1.ILil
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f2192IL.ILil();
    }

    @Override // ILil.p042lIiI.iIi1
    public lIlii getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f4731Ilil == null) {
            ILil iLil = (ILil) getLastNonConfigurationInstance();
            if (iLil != null) {
                this.f4731Ilil = iLil.f4736ILil;
            }
            if (this.f4731Ilil == null) {
                this.f4731Ilil = new lIlii();
            }
        }
        return this.f4731Ilil;
    }

    @Deprecated
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Object m2984lLi1LL() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f2194lLi1LL.I1I();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2192IL.I1I(bundle);
        ReportFragment.Ilil(this);
        int i = this.f2193iILLL1;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        ILil iLil;
        Object objM2984lLi1LL = m2984lLi1LL();
        lIlii lilii = this.f4731Ilil;
        if (lilii == null && (iLil = (ILil) getLastNonConfigurationInstance()) != null) {
            lilii = iLil.f4736ILil;
        }
        if (lilii == null && objM2984lLi1LL == null) {
            return null;
        }
        ILil iLil2 = new ILil();
        iLil2.f4735IL1Iii = objM2984lLi1LL;
        iLil2.f4736ILil = lilii;
        return iLil2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        IL lifecycle = getLifecycle();
        if (lifecycle instanceof L11I) {
            ((L11I) lifecycle).LlLI1(IL.ILil.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f2192IL.m2449IL(bundle);
    }
}
