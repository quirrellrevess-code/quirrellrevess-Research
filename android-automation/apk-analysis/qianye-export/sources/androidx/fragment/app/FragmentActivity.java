package androidx.fragment.app;

import ILil.IL1Iii.I1I;
import ILil.ILL.IL1Iii.IL;
import ILil.ILL.IL1Iii.IiL;
import ILil.ILL.IL1Iii.iILLL1;
import ILil.p042lIiI.L11I;
import ILil.p042lIiI.lIlii;
import ILil.p065Ilil.iIi1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ILil.I丨iL.Ilil.IL1Iii.ILil, ILil.p028IiL.Ilil.IL1Iii.IL {
    public boolean ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2635ILl;
    public boolean Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f2639lIiI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public iIi1<String> f2640llL1ii;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f2641il;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final IL f2636IiL = IL.ILil(new IL1Iii());

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final L11I f2638L11I = new L11I(this);

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f2637Ll1 = true;

    public class IL1Iii extends iILLL1<FragmentActivity> implements ILil.p042lIiI.iIi1, I1I {
        public IL1Iii() {
            super(FragmentActivity.this);
        }

        @Override // ILil.ILL.IL1Iii.iILLL1, ILil.ILL.IL1Iii.I1I
        public View I1I(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        public LayoutInflater ILL() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // ILil.IL1Iii.I1I
        public OnBackPressedDispatcher ILil() {
            return FragmentActivity.this.ILil();
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: IL丨丨l */
        public void mo1587ILl(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.LlLI1(fragment, strArr, i);
        }

        @Override // ILil.ILL.IL1Iii.iILLL1, ILil.ILL.IL1Iii.I1I
        /* JADX INFO: renamed from: I丨L */
        public boolean mo1446IL() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: I丨iL */
        public void mo1588IiL(Fragment fragment) {
            FragmentActivity.this.m3223lIiI(fragment);
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        public boolean Lil(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        public boolean LlLI1(String str) {
            return ILil.p028IiL.Ilil.IL1Iii.m2166Ll1(FragmentActivity.this, str);
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: Ll丨1 */
        public int mo1589Ll1() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo1590L11I(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // ILil.p042lIiI.IiL
        public ILil.p042lIiI.IL getLifecycle() {
            return FragmentActivity.this.f2638L11I;
        }

        @Override // ILil.p042lIiI.iIi1
        public lIlii getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        public void iIi1() {
            FragmentActivity.this.iIi1();
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: iIlLiL, reason: merged with bridge method [inline-methods] */
        public FragmentActivity mo1596il() {
            return FragmentActivity.this;
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: lIi丨I */
        public boolean mo1592lIiI() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: lI丨lii */
        public void mo1593lIlii(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            FragmentActivity.this.m3224lIlii(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        @Override // ILil.ILL.IL1Iii.iILLL1
        /* JADX INFO: renamed from: ll丨L1ii */
        public void mo1594llL1ii(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity.this.m3225llL1ii(fragment, intent, i, bundle);
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m3218IiL(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static boolean m3219Ll1(IiL iiL, ILil.p042lIiI.IL.ILil iLil) {
        boolean zM3219Ll1 = false;
        for (Fragment fragment : iiL.mo1495lLi1LL()) {
            if (fragment != null) {
                if (fragment.getLifecycle().ILil().isAtLeast(ILil.p042lIiI.IL.ILil.STARTED)) {
                    fragment.mLifecycleRegistry.LlLI1(iLil);
                    zM3219Ll1 = true;
                }
                if (fragment.getHost() != null) {
                    zM3219Ll1 |= m3219Ll1(fragment.getChildFragmentManager(), iLil);
                }
            }
        }
        return zM3219Ll1;
    }

    @Override // ILil.p028IiL.Ilil.IL1Iii.IL
    public final void IL1Iii(int i) {
        if (this.f2639lIiI || i == -1) {
            return;
        }
        m3218IiL(i);
    }

    public final void ILL() {
        while (m3219Ll1(m3226il(), ILil.p042lIiI.IL.ILil.CREATED)) {
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m3220ILl(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void Lil() {
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_RESUME);
        this.f2636IiL.LlLI1();
    }

    public void LlLI1(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            ILil.p028IiL.Ilil.IL1Iii.ILL(this, strArr, i);
            return;
        }
        m3218IiL(i);
        try {
            this.f2639lIiI = true;
            ILil.p028IiL.Ilil.IL1Iii.ILL(this, strArr, ((m3222iILLL1(fragment) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
        } finally {
            this.f2639lIiI = false;
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final View m3221L11I(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2636IiL.I11L(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f2641il);
        printWriter.print(" mResumed=");
        printWriter.print(this.ILL);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2637Ll1);
        if (getApplication() != null) {
            ILil.p025ILl.IL1Iii.IL1Iii.ILil(this).IL1Iii(str2, fileDescriptor, printWriter, strArr);
        }
        this.f2636IiL.I11li1().ILil(str, fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    public void iIi1() {
        invalidateOptionsMenu();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final int m3222iILLL1(Fragment fragment) {
        if (this.f2640llL1ii.m1963lIiI() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f2640llL1ii.m1962iILLL1(this.LlLI1) >= 0) {
            this.LlLI1 = (this.LlLI1 + 1) % 65534;
        }
        int i = this.LlLI1;
        this.f2640llL1ii.ILL(i, fragment.mWho);
        this.LlLI1 = (this.LlLI1 + 1) % 65534;
        return i;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3223lIiI(Fragment fragment) {
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m3224lIlii(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f2635ILl = true;
        try {
            if (i == -1) {
                ILil.p028IiL.Ilil.IL1Iii.m2164ILl(this, intentSender, i, intent, i2, i3, i4, bundle);
                this.f2635ILl = false;
            } else {
                m3218IiL(i);
                ILil.p028IiL.Ilil.IL1Iii.m2164ILl(this, intentSender, ((m3222iILLL1(fragment) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE), intent, i2, i3, i4, bundle);
                this.f2635ILl = false;
            }
        } catch (Throwable th) {
            this.f2635ILl = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m3225llL1ii(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.Lil = true;
        try {
            if (i == -1) {
                ILil.p028IiL.Ilil.IL1Iii.m2168lIiI(this, intent, -1, bundle);
                this.Lil = false;
            } else {
                m3218IiL(i);
                ILil.p028IiL.Ilil.IL1Iii.m2168lIiI(this, intent, ((m3222iILLL1(fragment) + 1) << 16) + (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE), bundle);
                this.Lil = false;
            }
        } catch (Throwable th) {
            this.Lil = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f2636IiL.m1489lL();
        int i3 = i >> 16;
        if (i3 == 0) {
            ILil.I丨iL.Ilil.IL1Iii.I1I i1iM2167L11I = ILil.p028IiL.Ilil.IL1Iii.m2167L11I();
            if (i1iM2167L11I == null || !i1iM2167L11I.IL1Iii(this, i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        int i4 = i3 - 1;
        String strIlil = this.f2640llL1ii.Ilil(i4);
        this.f2640llL1ii.m1960Ll1(i4);
        if (strIlil == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment fragmentIIlLiL = this.f2636IiL.iIlLiL(strIlil);
        if (fragmentIIlLiL != null) {
            fragmentIIlLiL.onActivityResult(i & Settings.DEFAULT_INITIAL_WINDOW_SIZE, i2, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strIlil);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2636IiL.m1489lL();
        this.f2636IiL.m1479IL(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f2636IiL.IL1Iii(null);
        if (bundle != null) {
            this.f2636IiL.llliI(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.LlLI1 = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f2640llL1ii = new iIi1<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f2640llL1ii.ILL(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f2640llL1ii == null) {
            this.f2640llL1ii = new iIi1<>();
            this.LlLI1 = 0;
        }
        super.onCreate(bundle);
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_CREATE);
        this.f2636IiL.m1487lLi1LL();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.f2636IiL.m1483iILLL1(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewM3221L11I = m3221L11I(view, str, context, attributeSet);
        return viewM3221L11I == null ? super.onCreateView(view, str, context, attributeSet) : viewM3221L11I;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f2636IiL.m1480IiL();
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f2636IiL.m1482L11I();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.f2636IiL.ILL(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.f2636IiL.Ilil(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f2636IiL.m1488il(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f2636IiL.m1489lL();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f2636IiL.m1481Ll1(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.ILL = false;
        this.f2636IiL.m1484lIiI();
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f2636IiL.m1478ILl(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        Lil();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? m3220ILl(view, menu) | this.f2636IiL.Lil(menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity, ILil.I丨iL.Ilil.IL1Iii.ILil
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f2636IiL.m1489lL();
        int i2 = (i >> 16) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strIlil = this.f2640llL1ii.Ilil(i3);
            this.f2640llL1ii.m1960Ll1(i3);
            if (strIlil == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentIIlLiL = this.f2636IiL.iIlLiL(strIlil);
            if (fragmentIIlLiL != null) {
                fragmentIIlLiL.onRequestPermissionsResult(i & Settings.DEFAULT_INITIAL_WINDOW_SIZE, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strIlil);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.ILL = true;
        this.f2636IiL.m1489lL();
        this.f2636IiL.iIi1();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ILL();
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_STOP);
        Parcelable parcelableM1490l = this.f2636IiL.m1490l();
        if (parcelableM1490l != null) {
            bundle.putParcelable("android:support:fragments", parcelableM1490l);
        }
        if (this.f2640llL1ii.m1963lIiI() > 0) {
            bundle.putInt("android:support:next_request_index", this.LlLI1);
            int[] iArr = new int[this.f2640llL1ii.m1963lIiI()];
            String[] strArr = new String[this.f2640llL1ii.m1963lIiI()];
            for (int i = 0; i < this.f2640llL1ii.m1963lIiI(); i++) {
                iArr[i] = this.f2640llL1ii.m1965il(i);
                strArr[i] = this.f2640llL1ii.m1958ILl(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f2637Ll1 = false;
        if (!this.f2641il) {
            this.f2641il = true;
            this.f2636IiL.I1I();
        }
        this.f2636IiL.m1489lL();
        this.f2636IiL.iIi1();
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_START);
        this.f2636IiL.m1486llL1ii();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f2636IiL.m1489lL();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f2637Ll1 = true;
        ILL();
        this.f2636IiL.m1485lIlii();
        this.f2638L11I.m2507L11I(ILil.p042lIiI.IL.IL1Iii.ON_STOP);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.Lil && i != -1) {
            m3218IiL(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.f2635ILl && i != -1) {
            m3218IiL(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public IiL m3226il() {
        return this.f2636IiL.I11li1();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewM3221L11I = m3221L11I(null, str, context, attributeSet);
        return viewM3221L11I == null ? super.onCreateView(str, context, attributeSet) : viewM3221L11I;
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.Lil && i != -1) {
            m3218IiL(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.f2635ILl && i != -1) {
            m3218IiL(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
