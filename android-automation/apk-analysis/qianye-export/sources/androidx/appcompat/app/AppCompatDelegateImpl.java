package androidx.appcompat.app;

import ILil.ILil.C0631il;
import ILil.ILil.p021Ll1.C0622il;
import ILil.ILil.p023lIlii.C0624ill;
import ILil.ILil.p023lIlii.LIll;
import ILil.ILil.p023lIlii.iIi1;
import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl;
import ILil.ILil.p024llL1ii.WindowCallbackC0630il;
import ILil.p028IiL.p029ILl.C0633lIII;
import ILil.p028IiL.p029ILl.C1;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.llliI;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import com.mysql.jdbc.MysqlErrorNumbers;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl extends ILil.ILil.p021Ll1.I1I implements ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: I丨 */
    public static final int[] f28I;

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public static final boolean f2260LlLiLL;

    /* JADX INFO: renamed from: iI */
    public static final Map<Class<?>, Integer> f29iI = new ILil.p065Ilil.Ll1();

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public static final boolean f2261iILilI;

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public static boolean f2262iiIIi11;
    public ViewGroup I11L;
    public boolean I11li1;

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public boolean f2263I1L11L;

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public boolean f2264IIiI;
    public MenuInflater ILL;

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public int f2265ILLIi;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public L11I f2266ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Object f4778Ilil;

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public boolean f2267IIi;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ILL f2268IiL;

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public int f2269L11;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean f2270L111;

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public AppCompatViewInflater f2271LIl;

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public boolean f2272LIll;
    public boolean LL1IL;
    public lIiI LLL;
    public LlLI1 Lil;

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public int f2273LlIl;
    public ILil.ILil.p024llL1ii.ILil LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public CharSequence f2274Ll1;

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public PanelFeatureState f2275L1l;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ILil.ILil.p021Ll1.ILil f2276L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean f2277LlLLL;

    /* JADX INFO: renamed from: i1 */
    public Rect f30i1;

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public lIiI f2278iI1iI;
    public Runnable iIi1;
    public boolean iIilII1;
    public llliI iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Window f2279iILLL1;

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public Rect f2280ili11;

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public boolean f2281ill;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public PanelFeatureState[] f2282l1IIi1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public ILil.ILil.p023lIlii.Lil f2283lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean f2284lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public PopupWindow f2285lIlii;
    public boolean llI;
    public TextView llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public ActionBarContextView f2286llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Context f2287lLi1LL;

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public boolean f2288lliiI1;

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final Runnable f2289li11;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public boolean f2290iILLl;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ActionBar f2291il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f2292lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public View f2293l;

    /* JADX INFO: renamed from: 丨丨 */
    public boolean f31;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public boolean f2294LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean f22951;

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public boolean f2296;

    public class I1I implements ILil.p028IiL.p029ILl.LlLI1 {
        public I1I() {
        }

        @Override // ILil.p028IiL.p029ILl.LlLI1
        public C0633lIII onApplyWindowInsets(View view, C0633lIII c0633lIII) {
            int iIlil = c0633lIII.Ilil();
            int iM3026iil1 = AppCompatDelegateImpl.this.m3026iil1(iIlil);
            if (iIlil != iM3026iil1) {
                c0633lIII = c0633lIII.m2155IiL(c0633lIII.I1I(), iM3026iil1, c0633lIII.m2154IL(), c0633lIII.ILil());
            }
            return iIlLiL.m2127li11(view, c0633lIII);
        }
    }

    public static class IL1Iii implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f4780IL1Iii;

        public IL1Iii(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f4780IL1Iii = uncaughtExceptionHandler;
        }

        public final boolean IL1Iii(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!IL1Iii(th)) {
                this.f4780IL1Iii.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f4780IL1Iii.uncaughtException(thread, notFoundException);
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f2265ILLIi & 1) != 0) {
                appCompatDelegateImpl.m3011IIiI(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f2265ILLIi & 4096) != 0) {
                appCompatDelegateImpl2.m3011IIiI(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f2263I1L11L = false;
            appCompatDelegateImpl3.f2265ILLIi = 0;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$IL丨丨l, reason: invalid class name and case insensitive filesystem */
    public class C0659ILl extends lIiI {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final ILil.ILil.p021Ll1.L11I f4783I1I;

        public C0659ILl(ILil.ILil.p021Ll1.L11I l11i) {
            super();
            this.f4783I1I = l11i;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.lIiI
        public int I1I() {
            return this.f4783I1I.m1655IL() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.lIiI
        public IntentFilter ILil() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.lIiI
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void mo3042IL() {
            AppCompatDelegateImpl.this.LL1IL();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$I丨L, reason: invalid class name */
    public class IL implements iIi1.IL1Iii {
        public IL() {
        }

        @Override // ILil.ILil.lI丨lii.iIi1.IL1Iii
        public void IL1Iii(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.m3026iil1(rect.top);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$I丨iL, reason: invalid class name */
    public class IiL extends C1 {
        public IiL() {
        }

        @Override // ILil.p028IiL.p029ILl.C1, ILil.p028IiL.p029ILl.l
        public void I1I(View view) {
            AppCompatDelegateImpl.this.f2286llL1ii.setVisibility(0);
            AppCompatDelegateImpl.this.f2286llL1ii.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.f2286llL1ii.getParent() instanceof View) {
                iIlLiL.m70I1((View) AppCompatDelegateImpl.this.f2286llL1ii.getParent());
            }
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            AppCompatDelegateImpl.this.f2286llL1ii.setAlpha(1.0f);
            AppCompatDelegateImpl.this.iIlLiL.m2162lLi1LL(null);
            AppCompatDelegateImpl.this.iIlLiL = null;
        }
    }

    public class Lil extends ContentFrameLayout {
        public Lil(Context context) {
            super(context);
        }

        public final boolean I1I(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m3018LlIl(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !I1I((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.m3013IIi(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(getContext(), i));
        }
    }

    public final class LlLI1 implements InterfaceC0628ILl.IL1Iii {
        public LlLI1() {
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public boolean IL1Iii(ILil.ILil.p024llL1ii.ILL.IiL iiL) {
            Window.Callback callbackM3016LIl;
            if (iiL != null) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.f2284lIII || (callbackM3016LIl = appCompatDelegateImpl.m3016LIl()) == null || AppCompatDelegateImpl.this.f2296) {
                return true;
            }
            callbackM3016LIl.onMenuOpened(108, iiL);
            return true;
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public void onCloseMenu(ILil.ILil.p024llL1ii.ILL.IiL iiL, boolean z) {
            ILil.ILil.p024llL1ii.ILL.IiL rootMenu = iiL.getRootMenu();
            boolean z2 = rootMenu != iiL;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                iiL = rootMenu;
            }
            PanelFeatureState panelFeatureStateM3010I1L11L = appCompatDelegateImpl.m3010I1L11L(iiL);
            if (panelFeatureStateM3010I1L11L != null) {
                if (!z2) {
                    AppCompatDelegateImpl.this.m3017LIll(panelFeatureStateM3010I1L11L, z);
                } else {
                    AppCompatDelegateImpl.this.m3031l1IIi1(panelFeatureStateM3010I1L11L.f4790IL1Iii, panelFeatureStateM3010I1L11L, rootMenu);
                    AppCompatDelegateImpl.this.m3017LIll(panelFeatureStateM3010I1L11L, true);
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$Ll丨1, reason: invalid class name */
    public class Ll1 extends lIiI {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final PowerManager f4787I1I;

        public Ll1(Context context) {
            super();
            this.f4787I1I = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.lIiI
        public int I1I() {
            return (Build.VERSION.SDK_INT < 21 || !this.f4787I1I.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.lIiI
        public IntentFilter ILil() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.lIiI
        /* JADX INFO: renamed from: I丨L */
        public void mo3042IL() {
            AppCompatDelegateImpl.this.LL1IL();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$L丨1丨1丨I, reason: invalid class name */
    public final class L11I implements InterfaceC0628ILl.IL1Iii {
        public L11I() {
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public boolean IL1Iii(ILil.ILil.p024llL1ii.ILL.IiL iiL) {
            Window.Callback callbackM3016LIl = AppCompatDelegateImpl.this.m3016LIl();
            if (callbackM3016LIl == null) {
                return true;
            }
            callbackM3016LIl.onMenuOpened(108, iiL);
            return true;
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public void onCloseMenu(ILil.ILil.p024llL1ii.ILL.IiL iiL, boolean z) {
            AppCompatDelegateImpl.this.m3020L1l(iiL);
        }
    }

    public static final class PanelFeatureState {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4789I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4790IL1Iii;
        public ILil.ILil.p024llL1ii.ILL.lLi1LL ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4791ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public boolean f2300ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4792Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2301IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public View f2302IiL;
        public boolean Lil;
        public boolean LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public Context f2303Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public View f2304L11I;
        public Bundle iIi1;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public ViewGroup f2305iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public boolean f2306lIiI;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public boolean f2307lIlii;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public boolean f2308llL1ii = false;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2309lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public ILil.ILil.p024llL1ii.ILL.IiL f2310il;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public boolean f4793I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public int f4794ILil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public Bundle f2311IL;

            public static class IL1Iii implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.IL1Iii(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.IL1Iii(parcel, classLoader);
                }
            }

            public static SavedState IL1Iii(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f4794ILil = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.f4793I1I = z;
                if (z) {
                    savedState.f2311IL = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f4794ILil);
                parcel.writeInt(this.f4793I1I ? 1 : 0);
                if (this.f4793I1I) {
                    parcel.writeBundle(this.f2311IL);
                }
            }
        }

        public PanelFeatureState(int i) {
            this.f4790IL1Iii = i;
        }

        public void I1I(ILil.ILil.p024llL1ii.ILL.IiL iiL) {
            ILil.ILil.p024llL1ii.ILL.lLi1LL lli1ll;
            ILil.ILil.p024llL1ii.ILL.IiL iiL2 = this.f2310il;
            if (iiL == iiL2) {
                return;
            }
            if (iiL2 != null) {
                iiL2.removeMenuPresenter(this.ILL);
            }
            this.f2310il = iiL;
            if (iiL == null || (lli1ll = this.ILL) == null) {
                return;
            }
            iiL.addMenuPresenter(lli1ll);
        }

        public ILil.ILil.p024llL1ii.ILL.Lil IL1Iii(InterfaceC0628ILl.IL1Iii iL1Iii) {
            if (this.f2310il == null) {
                return null;
            }
            if (this.ILL == null) {
                ILil.ILil.p024llL1ii.ILL.lLi1LL lli1ll = new ILil.ILil.p024llL1ii.ILL.lLi1LL(this.f2303Ll1, ILil.ILil.IiL.abc_list_menu_item_layout);
                this.ILL = lli1ll;
                lli1ll.setCallback(iL1Iii);
                this.f2310il.addMenuPresenter(this.ILL);
            }
            return this.ILL.ILil(this.f2305iILLL1);
        }

        public boolean ILil() {
            if (this.f2302IiL == null) {
                return false;
            }
            return this.f2304L11I != null || this.ILL.IL1Iii().getCount() > 0;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3043IL(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(ILil.ILil.IL1Iii.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                themeNewTheme.applyStyle(i, true);
            }
            themeNewTheme.resolveAttribute(ILil.ILil.IL1Iii.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            } else {
                themeNewTheme.applyStyle(C0631il.Theme_AppCompat_CompactMenu, true);
            }
            ILil.ILil.p024llL1ii.IL il = new ILil.ILil.p024llL1ii.IL(context, 0);
            il.getTheme().setTo(themeNewTheme);
            this.f2303Ll1 = il;
            TypedArray typedArrayObtainStyledAttributes = il.obtainStyledAttributes(ILil.ILil.ILL.AppCompatTheme);
            this.f4791ILil = typedArrayObtainStyledAttributes.getResourceId(ILil.ILil.ILL.AppCompatTheme_panelBackground, 0);
            this.f2309lLi1LL = typedArrayObtainStyledAttributes.getResourceId(ILil.ILil.ILL.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements Runnable {

        /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$iI丨LLL1$IL1Iii */
        public class IL1Iii extends C1 {
            public IL1Iii() {
            }

            @Override // ILil.p028IiL.p029ILl.C1, ILil.p028IiL.p029ILl.l
            public void I1I(View view) {
                AppCompatDelegateImpl.this.f2286llL1ii.setVisibility(0);
            }

            @Override // ILil.p028IiL.p029ILl.l
            public void ILil(View view) {
                AppCompatDelegateImpl.this.f2286llL1ii.setAlpha(1.0f);
                AppCompatDelegateImpl.this.iIlLiL.m2162lLi1LL(null);
                AppCompatDelegateImpl.this.iIlLiL = null;
            }
        }

        public iILLL1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f2285lIlii.showAtLocation(appCompatDelegateImpl.f2286llL1ii, 55, 0, 0);
            AppCompatDelegateImpl.this.m3033lliiI1();
            if (!AppCompatDelegateImpl.this.ILI1Ll()) {
                AppCompatDelegateImpl.this.f2286llL1ii.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f2286llL1ii.setVisibility(0);
                return;
            }
            AppCompatDelegateImpl.this.f2286llL1ii.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            llliI llliiI1I = iIlLiL.I1I(appCompatDelegateImpl2.f2286llL1ii);
            llliiI1I.IL1Iii(1.0f);
            appCompatDelegateImpl2.iIlLiL = llliiI1I;
            AppCompatDelegateImpl.this.iIlLiL.m2162lLi1LL(new IL1Iii());
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$lIi丨I, reason: invalid class name */
    public abstract class lIiI {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public BroadcastReceiver f4797IL1Iii;

        /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$lIi丨I$IL1Iii */
        public class IL1Iii extends BroadcastReceiver {
            public IL1Iii() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                lIiI.this.mo3042IL();
            }
        }

        public lIiI() {
        }

        public abstract int I1I();

        public void IL1Iii() {
            BroadcastReceiver broadcastReceiver = this.f4797IL1Iii;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f2287lLi1LL.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f4797IL1Iii = null;
            }
        }

        public abstract IntentFilter ILil();

        public void Ilil() {
            IL1Iii();
            IntentFilter intentFilterILil = ILil();
            if (intentFilterILil == null || intentFilterILil.countActions() == 0) {
                return;
            }
            if (this.f4797IL1Iii == null) {
                this.f4797IL1Iii = new IL1Iii();
            }
            AppCompatDelegateImpl.this.f2287lLi1LL.registerReceiver(this.f4797IL1Iii, intentFilterILil);
        }

        /* JADX INFO: renamed from: I丨L */
        public abstract void mo3042IL();
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements ContentFrameLayout.IL1Iii {
        public lLi1LL() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.IL1Iii
        public void IL1Iii() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.IL1Iii
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.m3014L11();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$丨il, reason: invalid class name and case insensitive filesystem */
    public class C0660il implements ILil.ILil.ll丨L1ii.ILil.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public ILil.ILil.ll丨L1ii.ILil.IL1Iii f4801IL1Iii;

        /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$丨il$IL1Iii */
        public class IL1Iii extends C1 {
            public IL1Iii() {
            }

            @Override // ILil.p028IiL.p029ILl.l
            public void ILil(View view) {
                AppCompatDelegateImpl.this.f2286llL1ii.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f2285lIlii;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f2286llL1ii.getParent() instanceof View) {
                    iIlLiL.m70I1((View) AppCompatDelegateImpl.this.f2286llL1ii.getParent());
                }
                AppCompatDelegateImpl.this.f2286llL1ii.removeAllViews();
                AppCompatDelegateImpl.this.iIlLiL.m2162lLi1LL(null);
                AppCompatDelegateImpl.this.iIlLiL = null;
            }
        }

        public C0660il(ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii) {
            this.f4801IL1Iii = iL1Iii;
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        public boolean I1I(ILil.ILil.p024llL1ii.ILil iLil, Menu menu) {
            return this.f4801IL1Iii.I1I(iLil, menu);
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        public void IL1Iii(ILil.ILil.p024llL1ii.ILil iLil) {
            this.f4801IL1Iii.IL1Iii(iLil);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f2285lIlii != null) {
                appCompatDelegateImpl.f2279iILLL1.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.iIi1);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f2286llL1ii != null) {
                appCompatDelegateImpl2.m3033lliiI1();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                llliI llliiI1I = iIlLiL.I1I(appCompatDelegateImpl3.f2286llL1ii);
                llliiI1I.IL1Iii(0.0f);
                appCompatDelegateImpl3.iIlLiL = llliiI1I;
                AppCompatDelegateImpl.this.iIlLiL.m2162lLi1LL(new IL1Iii());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            ILil.ILil.p021Ll1.ILil iLil2 = appCompatDelegateImpl4.f2276L11I;
            if (iLil2 != null) {
                iLil2.onSupportActionModeFinished(appCompatDelegateImpl4.LlLI1);
            }
            AppCompatDelegateImpl.this.LlLI1 = null;
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        public boolean ILil(ILil.ILil.p024llL1ii.ILil iLil, Menu menu) {
            return this.f4801IL1Iii.ILil(iLil, menu);
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        /* JADX INFO: renamed from: I丨L */
        public boolean mo1918IL(ILil.ILil.p024llL1ii.ILil iLil, MenuItem menuItem) {
            return this.f4801IL1Iii.mo1918IL(iLil, menuItem);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean z2 = i < 21;
        f2260LlLiLL = z2;
        f28I = new int[]{R.attr.windowBackground};
        if (i >= 21 && i <= 25) {
            z = true;
        }
        f2261iILilI = z;
        if (!z2 || f2262iiIIi11) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new IL1Iii(Thread.getDefaultUncaughtExceptionHandler()));
        f2262iiIIi11 = true;
    }

    public AppCompatDelegateImpl(Activity activity, ILil.ILil.p021Ll1.ILil iLil) {
        this(activity, null, iLil, activity);
    }

    /* JADX INFO: renamed from: I1 */
    public final boolean m107I1() {
        if (!this.f2288lliiI1 && (this.f4778Ilil instanceof Activity)) {
            PackageManager packageManager = this.f2287lLi1LL.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f2287lLi1LL, this.f4778Ilil.getClass()), 0);
                this.f2264IIiI = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.f2264IIiI = false;
            }
        }
        this.f2288lliiI1 = true;
        return this.f2264IIiI;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public boolean I11L(int i) {
        int iM3030iILiiLl = m3030iILiiLl(i);
        if (this.f31 && iM3030iILiiLl == 108) {
            return false;
        }
        if (this.f2284lIII && iM3030iILiiLl == 1) {
            this.f2284lIII = false;
        }
        if (iM3030iILiiLl == 1) {
            LIlLi();
            this.f31 = true;
            return true;
        }
        if (iM3030iILiiLl == 2) {
            LIlLi();
            this.f22951 = true;
            return true;
        }
        if (iM3030iILiiLl == 5) {
            LIlLi();
            this.f2277LlLLL = true;
            return true;
        }
        if (iM3030iILiiLl == 10) {
            LIlLi();
            this.f2270L111 = true;
            return true;
        }
        if (iM3030iILiiLl == 108) {
            LIlLi();
            this.f2284lIII = true;
            return true;
        }
        if (iM3030iILiiLl != 109) {
            return this.f2279iILLL1.requestFeature(iM3030iILiiLl);
        }
        LIlLi();
        this.LL1IL = true;
        return true;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void I11li1() {
        this.f2281ill = false;
        ILil.ILil.p021Ll1.I1I.m1640lIiI(this);
        ActionBar actionBarMo1645L11I = mo1645L11I();
        if (actionBarMo1645L11I != null) {
            actionBarMo1645L11I.iIi1(false);
        }
        if (this.f4778Ilil instanceof Dialog) {
            m3039iILLl();
        }
    }

    public final boolean I1IILIIL(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateM110i1 = m110i1(i, true);
        if (panelFeatureStateM110i1.Lil) {
            return false;
        }
        return m3023iI1LI(panelFeatureStateM110i1, keyEvent);
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public PanelFeatureState m3010I1L11L(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f2282l1IIi1;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f2310il == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public void m3011IIiI(int i) {
        PanelFeatureState panelFeatureStateM110i1;
        PanelFeatureState panelFeatureStateM110i2 = m110i1(i, true);
        if (panelFeatureStateM110i2.f2310il != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateM110i2.f2310il.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateM110i2.iIi1 = bundle;
            }
            panelFeatureStateM110i2.f2310il.stopDispatchingItemsChanged();
            panelFeatureStateM110i2.f2310il.clear();
        }
        panelFeatureStateM110i2.f2307lIlii = true;
        panelFeatureStateM110i2.f2308llL1ii = true;
        if ((i != 108 && i != 0) || this.f2283lIiI == null || (panelFeatureStateM110i1 = m110i1(0, false)) == null) {
            return;
        }
        panelFeatureStateM110i1.f2306lIiI = false;
        m3023iI1LI(panelFeatureStateM110i1, null);
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void IL1Iii(View view, ViewGroup.LayoutParams layoutParams) {
        LLL();
        ((ViewGroup) this.I11L.findViewById(R.id.content)).addView(view, layoutParams);
        this.f2268IiL.IL1Iii().onContentChanged();
    }

    public final boolean ILI1Ll() {
        ViewGroup viewGroup;
        return this.f2292lL && (viewGroup = this.I11L) != null && iIlLiL.m2103LlIl(viewGroup);
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void ILL() {
        ActionBar actionBarMo1645L11I = mo1645L11I();
        if (actionBarMo1645L11I == null || !actionBarMo1645L11I.m2987Ll1()) {
            m3024iILilI(0);
        }
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public final Context m3012ILLIi() {
        ActionBar actionBarMo1645L11I = mo1645L11I();
        Context contextILL = actionBarMo1645L11I != null ? actionBarMo1645L11I.ILL() : null;
        return contextILL == null ? this.f2287lLi1LL : contextILL;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void ILil(Context context) {
        m3015L111(false);
        this.f2267IIi = true;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: IL丨丨l */
    public void mo1643ILl(Configuration configuration) {
        ActionBar actionBarMo1645L11I;
        if (this.f2284lIII && this.f2292lL && (actionBarMo1645L11I = mo1645L11I()) != null) {
            actionBarMo1645L11I.mo1668lIiI(configuration);
        }
        ILil.ILil.p023lIlii.iILLL1.ILil().m1783iILLL1(this.f2287lLi1LL);
        m3015L111(false);
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public <T extends View> T Ilil(int i) {
        LLL();
        return (T) this.f2279iILLL1.findViewById(i);
    }

    /* JADX INFO: renamed from: I丨 */
    public final boolean m108I(PanelFeatureState panelFeatureState) {
        panelFeatureState.m3043IL(m3012ILLIi());
        panelFeatureState.f2305iILLL1 = new Lil(panelFeatureState.f2303Ll1);
        panelFeatureState.f4789I1I = 81;
        return true;
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public void m3013IIi(int i) {
        m3017LIll(m110i1(i, true), true);
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: I丨iL */
    public MenuInflater mo1644IiL() {
        if (this.ILL == null) {
            m111iI();
            ActionBar actionBar = this.f2291il;
            this.ILL = new ILil.ILil.p024llL1ii.IiL(actionBar != null ? actionBar.ILL() : this.f2287lLi1LL);
        }
        return this.ILL;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m3014L11() {
        ILil.ILil.p024llL1ii.ILL.IiL iiL;
        ILil.ILil.p023lIlii.Lil lil = this.f2283lIiI;
        if (lil != null) {
            lil.mo1742L11I();
        }
        if (this.f2285lIlii != null) {
            this.f2279iILLL1.getDecorView().removeCallbacks(this.iIi1);
            if (this.f2285lIlii.isShowing()) {
                try {
                    this.f2285lIlii.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f2285lIlii = null;
        }
        m3033lliiI1();
        PanelFeatureState panelFeatureStateM110i1 = m110i1(0, false);
        if (panelFeatureStateM110i1 == null || (iiL = panelFeatureStateM110i1.f2310il) == null) {
            return;
        }
        iiL.close();
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final boolean m3015L111(boolean z) {
        if (this.f2296) {
            return false;
        }
        int iLlI = llI();
        boolean zM113li = m113li(L1iI1(iLlI), z);
        if (iLlI == 0) {
            iIilII1().Ilil();
        } else {
            lIiI liii = this.LLL;
            if (liii != null) {
                liii.IL1Iii();
            }
        }
        if (iLlI == 3) {
            m3034li11().Ilil();
        } else {
            lIiI liii2 = this.f2278iI1iI;
            if (liii2 != null) {
                liii2.IL1Iii();
            }
        }
        return zM113li;
    }

    public int L1iI1(int i) {
        if (i == -100) {
            return -1;
        }
        if (i == -1) {
            return i;
        }
        if (i == 0) {
            if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f2287lLi1LL.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return iIilII1().I1I();
            }
            return -1;
        }
        if (i == 1 || i == 2) {
            return i;
        }
        if (i == 3) {
            return m3034li11().I1I();
        }
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    }

    public void LI11(int i) {
        if (i == 108) {
            ActionBar actionBarMo1645L11I = mo1645L11I();
            if (actionBarMo1645L11I != null) {
                actionBarMo1645L11I.mo1664L11I(false);
                return;
            }
            return;
        }
        if (i == 0) {
            PanelFeatureState panelFeatureStateM110i1 = m110i1(i, true);
            if (panelFeatureStateM110i1.Lil) {
                m3017LIll(panelFeatureStateM110i1, false);
            }
        }
    }

    public ILil.ILil.p024llL1ii.ILil LII(ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii) {
        ILil.ILil.p024llL1ii.ILil iLilOnWindowStartingSupportActionMode;
        Context il;
        ILil.ILil.p021Ll1.ILil iLil;
        m3033lliiI1();
        ILil.ILil.p024llL1ii.ILil iLil2 = this.LlLI1;
        if (iLil2 != null) {
            iLil2.IL1Iii();
        }
        if (!(iL1Iii instanceof C0660il)) {
            iL1Iii = new C0660il(iL1Iii);
        }
        ILil.ILil.p021Ll1.ILil iLil3 = this.f2276L11I;
        if (iLil3 == null || this.f2296) {
            iLilOnWindowStartingSupportActionMode = null;
        } else {
            try {
                iLilOnWindowStartingSupportActionMode = iLil3.onWindowStartingSupportActionMode(iL1Iii);
            } catch (AbstractMethodError unused) {
                iLilOnWindowStartingSupportActionMode = null;
            }
        }
        if (iLilOnWindowStartingSupportActionMode != null) {
            this.LlLI1 = iLilOnWindowStartingSupportActionMode;
        } else {
            if (this.f2286llL1ii == null) {
                if (this.f2294LLlI1) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f2287lLi1LL.getTheme();
                    theme.resolveAttribute(ILil.ILil.IL1Iii.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f2287lLi1LL.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        il = new ILil.ILil.p024llL1ii.IL(this.f2287lLi1LL, 0);
                        il.getTheme().setTo(themeNewTheme);
                    } else {
                        il = this.f2287lLi1LL;
                    }
                    this.f2286llL1ii = new ActionBarContextView(il);
                    PopupWindow popupWindow = new PopupWindow(il, (AttributeSet) null, ILil.ILil.IL1Iii.actionModePopupWindowStyle);
                    this.f2285lIlii = popupWindow;
                    ILil.p028IiL.Lil.L11I.ILil(popupWindow, 2);
                    this.f2285lIlii.setContentView(this.f2286llL1ii);
                    this.f2285lIlii.setWidth(-1);
                    il.getTheme().resolveAttribute(ILil.ILil.IL1Iii.actionBarSize, typedValue, true);
                    this.f2286llL1ii.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, il.getResources().getDisplayMetrics()));
                    this.f2285lIlii.setHeight(-2);
                    this.iIi1 = new iILLL1();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.I11L.findViewById(ILil.ILil.iILLL1.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m3012ILLIi()));
                        this.f2286llL1ii = (ActionBarContextView) viewStubCompat.IL1Iii();
                    }
                }
            }
            if (this.f2286llL1ii != null) {
                m3033lliiI1();
                this.f2286llL1ii.ILL();
                ILil.ILil.p024llL1ii.lLi1LL lli1ll = new ILil.ILil.p024llL1ii.lLi1LL(this.f2286llL1ii.getContext(), this.f2286llL1ii, iL1Iii, this.f2285lIlii == null);
                if (iL1Iii.ILil(lli1ll, lli1ll.I1I())) {
                    lli1ll.mo1680L11I();
                    this.f2286llL1ii.m3047IiL(lli1ll);
                    this.LlLI1 = lli1ll;
                    if (ILI1Ll()) {
                        this.f2286llL1ii.setAlpha(0.0f);
                        llliI llliiI1I = iIlLiL.I1I(this.f2286llL1ii);
                        llliiI1I.IL1Iii(1.0f);
                        this.iIlLiL = llliiI1I;
                        llliiI1I.m2162lLi1LL(new IiL());
                    } else {
                        this.f2286llL1ii.setAlpha(1.0f);
                        this.f2286llL1ii.setVisibility(0);
                        this.f2286llL1ii.sendAccessibilityEvent(32);
                        if (this.f2286llL1ii.getParent() instanceof View) {
                            iIlLiL.m70I1((View) this.f2286llL1ii.getParent());
                        }
                    }
                    if (this.f2285lIlii != null) {
                        this.f2279iILLL1.getDecorView().post(this.iIi1);
                    }
                } else {
                    this.LlLI1 = null;
                }
            }
        }
        ILil.ILil.p024llL1ii.ILil iLil4 = this.LlLI1;
        if (iLil4 != null && (iLil = this.f2276L11I) != null) {
            iLil.onSupportActionModeStarted(iLil4);
        }
        return this.LlLI1;
    }

    public final void LIlLi() {
        if (this.f2292lL) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public final Window.Callback m3016LIl() {
        return this.f2279iILLL1.getCallback();
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public void m3017LIll(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        ILil.ILil.p023lIlii.Lil lil;
        if (z && panelFeatureState.f4790IL1Iii == 0 && (lil = this.f2283lIiI) != null && lil.ILil()) {
            m3020L1l(panelFeatureState.f2310il);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2287lLi1LL.getSystemService("window");
        if (windowManager != null && panelFeatureState.Lil && (viewGroup = panelFeatureState.f2305iILLL1) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                m3031l1IIi1(panelFeatureState.f4790IL1Iii, panelFeatureState, null);
            }
        }
        panelFeatureState.f2306lIiI = false;
        panelFeatureState.f2300ILl = false;
        panelFeatureState.Lil = false;
        panelFeatureState.f2302IiL = null;
        panelFeatureState.f2308llL1ii = true;
        if (this.f2275L1l == panelFeatureState) {
            this.f2275L1l = null;
        }
    }

    /* JADX INFO: renamed from: LL */
    public final ActionBar m109LL() {
        return this.f2291il;
    }

    public boolean LL1IL() {
        return m3015L111(true);
    }

    public final void LLL() {
        if (this.f2292lL) {
            return;
        }
        this.I11L = m3028ill();
        CharSequence charSequenceM3027ili11 = m3027ili11();
        if (!TextUtils.isEmpty(charSequenceM3027ili11)) {
            ILil.ILil.p023lIlii.Lil lil = this.f2283lIiI;
            if (lil != null) {
                lil.setWindowTitle(charSequenceM3027ili11);
            } else if (m109LL() != null) {
                m109LL().iIlLiL(charSequenceM3027ili11);
            } else {
                TextView textView = this.llliI;
                if (textView != null) {
                    textView.setText(charSequenceM3027ili11);
                }
            }
        }
        m3040LLlI1();
        LiL1(this.I11L);
        this.f2292lL = true;
        PanelFeatureState panelFeatureStateM110i1 = m110i1(0, false);
        if (this.f2296) {
            return;
        }
        if (panelFeatureStateM110i1 == null || panelFeatureStateM110i1.f2310il == null) {
            m3024iILilI(108);
        }
    }

    public void LiL1(ViewGroup viewGroup) {
    }

    public final void Liil1L1l(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.Lil || this.f2296) {
            return;
        }
        if (panelFeatureState.f4790IL1Iii == 0) {
            if ((this.f2287lLi1LL.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackM3016LIl = m3016LIl();
        if (callbackM3016LIl != null && !callbackM3016LIl.onMenuOpened(panelFeatureState.f4790IL1Iii, panelFeatureState.f2310il)) {
            m3017LIll(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f2287lLi1LL.getSystemService("window");
        if (windowManager != null && m3023iI1LI(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.f2305iILLL1;
            if (viewGroup != null && !panelFeatureState.f2308llL1ii) {
                View view = panelFeatureState.f2304L11I;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                panelFeatureState.f2300ILl = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f2301IL, panelFeatureState.f4792Ilil, MysqlErrorNumbers.ER_NO, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.f4789I1I;
                layoutParams2.windowAnimations = panelFeatureState.f2309lLi1LL;
                windowManager.addView(panelFeatureState.f2305iILLL1, layoutParams2);
                panelFeatureState.Lil = true;
            }
            if (viewGroup == null) {
                if (!m108I(panelFeatureState) || panelFeatureState.f2305iILLL1 == null) {
                    return;
                }
            } else if (panelFeatureState.f2308llL1ii && viewGroup.getChildCount() > 0) {
                panelFeatureState.f2305iILLL1.removeAllViews();
            }
            if (!m3019LlLiLL(panelFeatureState) || !panelFeatureState.ILil()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f2302IiL.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            panelFeatureState.f2305iILLL1.setBackgroundResource(panelFeatureState.f4791ILil);
            ViewParent parent = panelFeatureState.f2302IiL.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(panelFeatureState.f2302IiL);
            }
            panelFeatureState.f2305iILLL1.addView(panelFeatureState.f2302IiL, layoutParams3);
            if (!panelFeatureState.f2302IiL.hasFocus()) {
                panelFeatureState.f2302IiL.requestFocus();
            }
            i = -2;
            panelFeatureState.f2300ILl = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f2301IL, panelFeatureState.f4792Ilil, MysqlErrorNumbers.ER_NO, 8519680, -3);
            layoutParams4.gravity = panelFeatureState.f4789I1I;
            layoutParams4.windowAnimations = panelFeatureState.f2309lLi1LL;
            windowManager.addView(panelFeatureState.f2305iILLL1, layoutParams4);
            panelFeatureState.Lil = true;
        }
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void Lil(Bundle bundle) {
        this.f2267IIi = true;
        m3015L111(false);
        m3021iI1iI();
        Object obj = this.f4778Ilil;
        if (obj instanceof Activity) {
            String strI1I = null;
            try {
                strI1I = ILil.p028IiL.Ilil.IL.I1I((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strI1I != null) {
                ActionBar actionBarM109LL = m109LL();
                if (actionBarM109LL == null) {
                    this.iIilII1 = true;
                } else {
                    actionBarM109LL.mo1670lIlii(true);
                }
            }
        }
        this.f2272LIll = true;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public boolean m3018LlIl(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f4778Ilil;
        if (((obj instanceof ILil.p028IiL.p029ILl.IL.IL1Iii) || (obj instanceof ILil.ILil.p021Ll1.IL)) && (decorView = this.f2279iILLL1.getDecorView()) != null && ILil.p028IiL.p029ILl.IL.m2039IL(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f2268IiL.IL1Iii().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? l1Lll(keyCode, keyEvent) : m3032lIIiIlL(keyCode, keyEvent);
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void LlLI1() {
        ILil.ILil.p021Ll1.I1I.m1640lIiI(this);
        if (this.f2263I1L11L) {
            this.f2279iILLL1.getDecorView().removeCallbacks(this.f2289li11);
        }
        this.f2281ill = false;
        this.f2296 = true;
        ActionBar actionBar = this.f2291il;
        if (actionBar != null) {
            actionBar.m2986ILl();
        }
        m3039iILLl();
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public final boolean m3019LlLiLL(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f2304L11I;
        if (view != null) {
            panelFeatureState.f2302IiL = view;
            return true;
        }
        if (panelFeatureState.f2310il == null) {
            return false;
        }
        if (this.Lil == null) {
            this.Lil = new LlLI1();
        }
        View view2 = (View) panelFeatureState.IL1Iii(this.Lil);
        panelFeatureState.f2302IiL = view2;
        return view2 != null;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m3020L1l(ILil.ILil.p024llL1ii.ILL.IiL iiL) {
        if (this.llI) {
            return;
        }
        this.llI = true;
        this.f2283lIiI.mo1742L11I();
        Window.Callback callbackM3016LIl = m3016LIl();
        if (callbackM3016LIl != null && !this.f2296) {
            callbackM3016LIl.onPanelClosed(108, iiL);
        }
        this.llI = false;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public ActionBar mo1645L11I() {
        m111iI();
        return this.f2291il;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: L丨lLLL */
    public void mo1646LlLLL(int i) {
        this.f2273LlIl = i;
    }

    /* JADX INFO: renamed from: i1 */
    public PanelFeatureState m110i1(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f2282l1IIi1;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f2282l1IIi1 = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* JADX INFO: renamed from: iI */
    public final void m111iI() {
        LLL();
        if (this.f2284lIII && this.f2291il == null) {
            Object obj = this.f4778Ilil;
            if (obj instanceof Activity) {
                this.f2291il = new C0622il((Activity) this.f4778Ilil, this.LL1IL);
            } else if (obj instanceof Dialog) {
                this.f2291il = new C0622il((Dialog) this.f4778Ilil);
            }
            ActionBar actionBar = this.f2291il;
            if (actionBar != null) {
                actionBar.mo1670lIlii(this.iIilII1);
            }
        }
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public final void m3021iI1iI() {
        if (this.f2279iILLL1 == null) {
            Object obj = this.f4778Ilil;
            if (obj instanceof Activity) {
                m116(((Activity) obj).getWindow());
            }
        }
        if (this.f2279iILLL1 == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void iIi1(Bundle bundle) {
        if (this.f2269L11 != -100) {
            f29iI.put(this.f4778Ilil.getClass(), Integer.valueOf(this.f2269L11));
        }
    }

    public final lIiI iIilII1() {
        if (this.LLL == null) {
            this.LLL = new C0659ILl(ILil.ILil.p021Ll1.L11I.IL1Iii(this.f2287lLi1LL));
        }
        return this.LLL;
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public void m3022iIl1il(int i) {
        ActionBar actionBarMo1645L11I;
        if (i != 108 || (actionBarMo1645L11I = mo1645L11I()) == null) {
            return;
        }
        actionBarMo1645L11I.mo1664L11I(true);
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void iIlLiL() {
        this.f2281ill = true;
        LL1IL();
        ILil.ILil.p021Ll1.I1I.m1639Ll1(this);
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public final boolean m3023iI1LI(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ILil.ILil.p023lIlii.Lil lil;
        ILil.ILil.p023lIlii.Lil lil2;
        ILil.ILil.p023lIlii.Lil lil3;
        ILil.ILil.p023lIlii.Lil lil4;
        if (this.f2296) {
            return false;
        }
        if (panelFeatureState.f2306lIiI) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f2275L1l;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            m3017LIll(panelFeatureState2, false);
        }
        Window.Callback callbackM3016LIl = m3016LIl();
        if (callbackM3016LIl != null) {
            panelFeatureState.f2304L11I = callbackM3016LIl.onCreatePanelView(panelFeatureState.f4790IL1Iii);
        }
        int i = panelFeatureState.f4790IL1Iii;
        boolean z = i == 0 || i == 108;
        if (z && (lil4 = this.f2283lIiI) != null) {
            lil4.I1I();
        }
        if (panelFeatureState.f2304L11I == null) {
            if (z) {
                m109LL();
            }
            ILil.ILil.p024llL1ii.ILL.IiL iiL = panelFeatureState.f2310il;
            if (iiL == null || panelFeatureState.f2307lIlii) {
                if (iiL == null && (!m3025iiIIi11(panelFeatureState) || panelFeatureState.f2310il == null)) {
                    return false;
                }
                if (z && (lil2 = this.f2283lIiI) != null) {
                    if (this.f2266ILl == null) {
                        this.f2266ILl = new L11I();
                    }
                    lil2.IL1Iii(panelFeatureState.f2310il, this.f2266ILl);
                }
                panelFeatureState.f2310il.stopDispatchingItemsChanged();
                if (!callbackM3016LIl.onCreatePanelMenu(panelFeatureState.f4790IL1Iii, panelFeatureState.f2310il)) {
                    panelFeatureState.I1I(null);
                    if (z && (lil = this.f2283lIiI) != null) {
                        lil.IL1Iii(null, this.f2266ILl);
                    }
                    return false;
                }
                panelFeatureState.f2307lIlii = false;
            }
            panelFeatureState.f2310il.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.iIi1;
            if (bundle != null) {
                panelFeatureState.f2310il.restoreActionViewStates(bundle);
                panelFeatureState.iIi1 = null;
            }
            if (!callbackM3016LIl.onPreparePanel(0, panelFeatureState.f2304L11I, panelFeatureState.f2310il)) {
                if (z && (lil3 = this.f2283lIiI) != null) {
                    lil3.IL1Iii(null, this.f2266ILl);
                }
                panelFeatureState.f2310il.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.LlLI1 = z2;
            panelFeatureState.f2310il.setQwertyMode(z2);
            panelFeatureState.f2310il.startDispatchingItemsChanged();
        }
        panelFeatureState.f2306lIiI = true;
        panelFeatureState.f2300ILl = false;
        this.f2275L1l = panelFeatureState;
        return true;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: iI丨LLL1 */
    public int mo1647iILLL1() {
        return this.f2269L11;
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public final void m3024iILilI(int i) {
        this.f2265ILLIi = (1 << i) | this.f2265ILLIi;
        if (this.f2263I1L11L) {
            return;
        }
        iIlLiL.m74iI(this.f2279iILLL1.getDecorView(), this.f2289li11);
        this.f2263I1L11L = true;
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public final boolean m3025iiIIi11(PanelFeatureState panelFeatureState) {
        Context context = this.f2287lLi1LL;
        int i = panelFeatureState.f4790IL1Iii;
        if ((i == 0 || i == 108) && this.f2283lIiI != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(ILil.ILil.IL1Iii.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(ILil.ILil.IL1Iii.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(ILil.ILil.IL1Iii.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                ILil.ILil.p024llL1ii.IL il = new ILil.ILil.p024llL1ii.IL(context, 0);
                il.getTheme().setTo(themeNewTheme);
                context = il;
            }
        }
        ILil.ILil.p024llL1ii.ILL.IiL iiL = new ILil.ILil.p024llL1ii.ILL.IiL(context);
        iiL.setCallback(this);
        panelFeatureState.I1I(iiL);
        return true;
    }

    /* JADX INFO: renamed from: iil1丨, reason: contains not printable characters */
    public int m3026iil1(int i) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.f2286llL1ii;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2286llL1ii.getLayoutParams();
            boolean z3 = true;
            if (this.f2286llL1ii.isShown()) {
                if (this.f30i1 == null) {
                    this.f30i1 = new Rect();
                    this.f2280ili11 = new Rect();
                }
                Rect rect = this.f30i1;
                Rect rect2 = this.f2280ili11;
                rect.set(0, i, 0, 0);
                C0624ill.IL1Iii(this.I11L, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.f2293l;
                    if (view == null) {
                        View view2 = new View(this.f2287lLi1LL);
                        this.f2293l = view2;
                        view2.setBackgroundColor(this.f2287lLi1LL.getResources().getColor(ILil.ILil.I1I.abc_input_method_navigation_guard));
                        this.I11L.addView(this.f2293l, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f2293l.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = this.f2293l != null;
                if (!this.f2270L111 && z3) {
                    i = 0;
                }
                boolean z4 = z3;
                z3 = z2;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.f2286llL1ii.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f2293l;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public final CharSequence m3027ili11() {
        Object obj = this.f4778Ilil;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2274Ll1;
    }

    public boolean ill1LI1l(int i, KeyEvent keyEvent) {
        ActionBar actionBarMo1645L11I = mo1645L11I();
        if (actionBarMo1645L11I != null && actionBarMo1645L11I.Lil(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f2275L1l;
        if (panelFeatureState != null && m3029i1I1I1l(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.f2275L1l;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f2300ILl = true;
            }
            return true;
        }
        if (this.f2275L1l == null) {
            PanelFeatureState panelFeatureStateM110i1 = m110i1(0, true);
            m3023iI1LI(panelFeatureStateM110i1, keyEvent);
            boolean zM3029i1I1I1l = m3029i1I1I1l(panelFeatureStateM110i1, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateM110i1.f2306lIiI = false;
            if (zM3029i1I1I1l) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final ViewGroup m3028ill() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f2287lLi1LL.obtainStyledAttributes(ILil.ILil.ILL.AppCompatTheme);
        int i = ILil.ILil.ILL.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(ILil.ILil.ILL.AppCompatTheme_windowNoTitle, false)) {
            I11L(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i, false)) {
            I11L(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(ILil.ILil.ILL.AppCompatTheme_windowActionBarOverlay, false)) {
            I11L(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(ILil.ILil.ILL.AppCompatTheme_windowActionModeOverlay, false)) {
            I11L(10);
        }
        this.f2294LLlI1 = typedArrayObtainStyledAttributes.getBoolean(ILil.ILil.ILL.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        m3021iI1iI();
        this.f2279iILLL1.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2287lLi1LL);
        if (this.f31) {
            viewGroup = this.f2270L111 ? (ViewGroup) layoutInflaterFrom.inflate(ILil.ILil.IiL.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(ILil.ILil.IiL.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                iIlLiL.m2111iI1LI(viewGroup, new I1I());
            } else {
                ((iIi1) viewGroup).setOnFitSystemWindowsListener(new IL());
            }
        } else if (this.f2294LLlI1) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(ILil.ILil.IiL.abc_dialog_title_material, (ViewGroup) null);
            this.LL1IL = false;
            this.f2284lIII = false;
        } else if (this.f2284lIII) {
            TypedValue typedValue = new TypedValue();
            this.f2287lLi1LL.getTheme().resolveAttribute(ILil.ILil.IL1Iii.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ILil.ILil.p024llL1ii.IL(this.f2287lLi1LL, typedValue.resourceId) : this.f2287lLi1LL).inflate(ILil.ILil.IiL.abc_screen_toolbar, (ViewGroup) null);
            ILil.ILil.p023lIlii.Lil lil = (ILil.ILil.p023lIlii.Lil) viewGroup.findViewById(ILil.ILil.iILLL1.decor_content_parent);
            this.f2283lIiI = lil;
            lil.setWindowCallback(m3016LIl());
            if (this.LL1IL) {
                this.f2283lIiI.mo1741IiL(109);
            }
            if (this.f22951) {
                this.f2283lIiI.mo1741IiL(2);
            }
            if (this.f2277LlLLL) {
                this.f2283lIiI.mo1741IiL(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f2284lIII + ", windowActionBarOverlay: " + this.LL1IL + ", android:windowIsFloating: " + this.f2294LLlI1 + ", windowActionModeOverlay: " + this.f2270L111 + ", windowNoTitle: " + this.f31 + " }");
        }
        if (this.f2283lIiI == null) {
            this.llliI = (TextView) viewGroup.findViewById(ILil.ILil.iILLL1.title);
        }
        C0624ill.I1I(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(ILil.ILil.iILLL1.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2279iILLL1.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2279iILLL1.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new lLi1LL());
        return viewGroup;
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public final boolean m3029i1I1I1l(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        ILil.ILil.p024llL1ii.ILL.IiL iiL;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f2306lIiI || m3023iI1LI(panelFeatureState, keyEvent)) && (iiL = panelFeatureState.f2310il) != null) {
            zPerformShortcut = iiL.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.f2283lIiI == null) {
            m3017LIll(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public final int m3030iILiiLl(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m3031l1IIi1(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f2282l1IIi1;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f2310il;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.Lil) && !this.f2296) {
            this.f2268IiL.IL1Iii().onPanelClosed(i, menu);
        }
    }

    public boolean l1Lll(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f2290iILLl = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            I1IILIIL(0, keyEvent);
            return true;
        }
        return false;
    }

    public final AppCompatActivity lI1I1() {
        for (Context baseContext = this.f2287lLi1LL; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public boolean m3032lIIiIlL(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f2290iILLl;
            this.f2290iILLl = false;
            PanelFeatureState panelFeatureStateM110i1 = m110i1(0, false);
            if (panelFeatureStateM110i1 != null && panelFeatureStateM110i1.Lil) {
                if (!z) {
                    m3017LIll(panelFeatureStateM110i1, true);
                }
                return true;
            }
            if (m112lL()) {
                return true;
            }
        } else if (i == 82) {
            m3038i11LL(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: lI丨II */
    public final void mo1648lIII(CharSequence charSequence) {
        this.f2274Ll1 = charSequence;
        ILil.ILil.p023lIlii.Lil lil = this.f2283lIiI;
        if (lil != null) {
            lil.setWindowTitle(charSequence);
            return;
        }
        if (m109LL() != null) {
            m109LL().iIlLiL(charSequence);
            return;
        }
        TextView textView = this.llliI;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: lI丨lii */
    public void mo1649lIlii() {
        ActionBar actionBarMo1645L11I = mo1645L11I();
        if (actionBarMo1645L11I != null) {
            actionBarMo1645L11I.iIi1(true);
        }
    }

    /* JADX INFO: renamed from: lL */
    public boolean m112lL() {
        ILil.ILil.p024llL1ii.ILil iLil = this.LlLI1;
        if (iLil != null) {
            iLil.IL1Iii();
            return true;
        }
        ActionBar actionBarMo1645L11I = mo1645L11I();
        return actionBarMo1645L11I != null && actionBarMo1645L11I.mo1660IiL();
    }

    /* JADX INFO: renamed from: li */
    public final boolean m113li(int i, boolean z) {
        int i2;
        int i3 = this.f2287lLi1LL.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        if (i != 1) {
            i2 = i != 2 ? i3 : 32;
        } else {
            i2 = 16;
        }
        boolean zM107I1 = m107I1();
        boolean z3 = false;
        if ((f2261iILilI || i2 != i3) && !zM107I1 && Build.VERSION.SDK_INT >= 17 && !this.f2267IIi && (this.f4778Ilil instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i2;
            try {
                ((ContextThemeWrapper) this.f4778Ilil).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException e) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e);
            }
        }
        int i4 = this.f2287lLi1LL.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i4 != i2 && z && !zM107I1 && this.f2267IIi && (Build.VERSION.SDK_INT >= 17 || this.f2272LIll)) {
            Object obj = this.f4778Ilil;
            if (obj instanceof Activity) {
                ILil.p028IiL.Ilil.IL1Iii.m2169il((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i4 == i2) {
            z2 = z3;
        } else {
            m3036IillIi(i2, zM107I1);
        }
        if (z2) {
            Object obj2 = this.f4778Ilil;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).I11L(i);
            }
        }
        return z2;
    }

    public final int llI() {
        int i = this.f2269L11;
        return i != -100 ? i : ILil.ILil.p021Ll1.I1I.m1641lLi1LL();
    }

    @Override // ILil.ILil.p021Ll1.I1I
    public void llliI(int i) {
        LLL();
        ViewGroup viewGroup = (ViewGroup) this.I11L.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2287lLi1LL).inflate(i, viewGroup);
        this.f2268IiL.IL1Iii().onContentChanged();
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: ll丨L1ii */
    public void mo1650llL1ii(Bundle bundle) {
        LLL();
    }

    /* JADX INFO: renamed from: l丨 */
    public final boolean m114l(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f2279iILLL1.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || iIlLiL.m2099L11((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public void m3033lliiI1() {
        llliI lllii = this.iIlLiL;
        if (lllii != null) {
            lllii.ILil();
        }
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final lIiI m3034li11() {
        if (this.f2278iI1iI == null) {
            this.f2278iI1iI = new Ll1(this.f2287lLi1LL);
        }
        return this.f2278iI1iI;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m3041(view, str, context, attributeSet);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
    public boolean onMenuItemSelected(ILil.ILil.p024llL1ii.ILL.IiL iiL, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateM3010I1L11L;
        Window.Callback callbackM3016LIl = m3016LIl();
        if (callbackM3016LIl == null || this.f2296 || (panelFeatureStateM3010I1L11L = m3010I1L11L(iiL.getRootMenu())) == null) {
            return false;
        }
        return callbackM3016LIl.onMenuItemSelected(panelFeatureStateM3010I1L11L.f4790IL1Iii, menuItem);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
    public void onMenuModeChange(ILil.ILil.p024llL1ii.ILL.IiL iiL) {
        m1151(iiL, true);
    }

    /* JADX INFO: renamed from: 丨1 */
    public final void m1151(ILil.ILil.p024llL1ii.ILL.IiL iiL, boolean z) {
        ILil.ILil.p023lIlii.Lil lil = this.f2283lIiI;
        if (lil == null || !lil.mo1740IL() || (ViewConfiguration.get(this.f2287lLi1LL).hasPermanentMenuKey() && !this.f2283lIiI.Ilil())) {
            PanelFeatureState panelFeatureStateM110i1 = m110i1(0, true);
            panelFeatureStateM110i1.f2308llL1ii = true;
            m3017LIll(panelFeatureStateM110i1, false);
            Liil1L1l(panelFeatureStateM110i1, null);
            return;
        }
        Window.Callback callbackM3016LIl = m3016LIl();
        if (this.f2283lIiI.ILil() && z) {
            this.f2283lIiI.mo1744lLi1LL();
            if (this.f2296) {
                return;
            }
            callbackM3016LIl.onPanelClosed(108, m110i1(0, true).f2310il);
            return;
        }
        if (callbackM3016LIl == null || this.f2296) {
            return;
        }
        if (this.f2263I1L11L && (this.f2265ILLIi & 1) != 0) {
            this.f2279iILLL1.getDecorView().removeCallbacks(this.f2289li11);
            this.f2289li11.run();
        }
        PanelFeatureState panelFeatureStateM110i2 = m110i1(0, true);
        ILil.ILil.p024llL1ii.ILL.IiL iiL2 = panelFeatureStateM110i2.f2310il;
        if (iiL2 == null || panelFeatureStateM110i2.f2307lIlii || !callbackM3016LIl.onPreparePanel(0, panelFeatureStateM110i2.f2304L11I, iiL2)) {
            return;
        }
        callbackM3016LIl.onMenuOpened(108, panelFeatureStateM110i2.f2310il);
        this.f2283lIiI.mo1743iILLL1();
    }

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public ILil.ILil.p024llL1ii.ILil m30351iIl(ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii) {
        ILil.ILil.p021Ll1.ILil iLil;
        if (iL1Iii == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        ILil.ILil.p024llL1ii.ILil iLil2 = this.LlLI1;
        if (iLil2 != null) {
            iLil2.IL1Iii();
        }
        C0660il c0660il = new C0660il(iL1Iii);
        ActionBar actionBarMo1645L11I = mo1645L11I();
        if (actionBarMo1645L11I != null) {
            ILil.ILil.p024llL1ii.ILil iLilI11li1 = actionBarMo1645L11I.I11li1(c0660il);
            this.LlLI1 = iLilI11li1;
            if (iLilI11li1 != null && (iLil = this.f2276L11I) != null) {
                iLil.onSupportActionModeStarted(iLilI11li1);
            }
        }
        if (this.LlLI1 == null) {
            this.LlLI1 = LII(c0660il);
        }
        return this.LlLI1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: 丨IillIi, reason: contains not printable characters */
    public final void m3036IillIi(int i, boolean z) {
        Resources resources = this.f2287lLi1LL.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            ILil.ILil.p021Ll1.iILLL1.IL1Iii(resources);
        }
        int i3 = this.f2273LlIl;
        if (i3 != 0) {
            this.f2287lLi1LL.setTheme(i3);
            if (i2 >= 23) {
                this.f2287lLi1LL.getTheme().applyStyle(this.f2273LlIl, true);
            }
        }
        if (z) {
            Object obj = this.f4778Ilil;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof ILil.p042lIiI.IiL) {
                    if (((ILil.p042lIiI.IiL) activity).getLifecycle().ILil().isAtLeast(ILil.p042lIiI.IL.ILil.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.f2281ill) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public boolean m3037i11i() {
        return this.I11li1;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public final boolean m3038i11LL(int i, KeyEvent keyEvent) {
        boolean zM3023iI1LI;
        ILil.ILil.p023lIlii.Lil lil;
        if (this.LlLI1 != null) {
            return false;
        }
        boolean zMo1744lLi1LL = true;
        PanelFeatureState panelFeatureStateM110i1 = m110i1(i, true);
        if (i != 0 || (lil = this.f2283lIiI) == null || !lil.mo1740IL() || ViewConfiguration.get(this.f2287lLi1LL).hasPermanentMenuKey()) {
            boolean z = panelFeatureStateM110i1.Lil;
            if (z || panelFeatureStateM110i1.f2300ILl) {
                m3017LIll(panelFeatureStateM110i1, true);
                zMo1744lLi1LL = z;
            } else if (panelFeatureStateM110i1.f2306lIiI) {
                if (panelFeatureStateM110i1.f2307lIlii) {
                    panelFeatureStateM110i1.f2306lIiI = false;
                    zM3023iI1LI = m3023iI1LI(panelFeatureStateM110i1, keyEvent);
                } else {
                    zM3023iI1LI = true;
                }
                if (zM3023iI1LI) {
                    Liil1L1l(panelFeatureStateM110i1, keyEvent);
                } else {
                    zMo1744lLi1LL = false;
                }
            } else {
                zMo1744lLi1LL = false;
            }
        } else if (this.f2283lIiI.ILil()) {
            zMo1744lLi1LL = this.f2283lIiI.mo1744lLi1LL();
        } else if (this.f2296 || !m3023iI1LI(panelFeatureStateM110i1, keyEvent)) {
            zMo1744lLi1LL = false;
        } else {
            zMo1744lLi1LL = this.f2283lIiI.mo1743iILLL1();
        }
        if (zMo1744lLi1LL) {
            AudioManager audioManager = (AudioManager) this.f2287lLi1LL.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zMo1744lLi1LL;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final void m3039iILLl() {
        lIiI liii = this.LLL;
        if (liii != null) {
            liii.IL1Iii();
        }
        lIiI liii2 = this.f2278iI1iI;
        if (liii2 != null) {
            liii2.IL1Iii();
        }
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: 丨il */
    public void mo1651il() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2287lLi1LL);
        if (layoutInflaterFrom.getFactory() == null) {
            ILil.p028IiL.p029ILl.lLi1LL.ILil(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: 丨l丨 */
    public void mo1652l(View view) {
        LLL();
        ViewGroup viewGroup = (ViewGroup) this.I11L.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2268IiL.IL1Iii().onContentChanged();
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m116(Window window) {
        if (this.f2279iILLL1 != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof ILL) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        ILL ill = new ILL(callback);
        this.f2268IiL = ill;
        window.setCallback(ill);
        llI lliIIlLiL = llI.iIlLiL(this.f2287lLi1LL, null, f28I);
        Drawable drawableM1824IiL = lliIIlLiL.m1824IiL(0);
        if (drawableM1824IiL != null) {
            window.setBackgroundDrawable(drawableM1824IiL);
        }
        lliIIlLiL.m1833lL();
        this.f2279iILLL1 = window;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m3040LLlI1() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.I11L.findViewById(R.id.content);
        View decorView = this.f2279iILLL1.getDecorView();
        contentFrameLayout.ILil(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f2287lLi1LL.obtainStyledAttributes(ILil.ILil.ILL.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(ILil.ILil.ILL.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(ILil.ILil.ILL.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i = ILil.ILil.ILL.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            typedArrayObtainStyledAttributes.getValue(i, contentFrameLayout.getFixedWidthMajor());
        }
        int i2 = ILil.ILil.ILL.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMinor());
        }
        int i3 = ILil.ILil.ILL.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedHeightMajor());
        }
        int i4 = ILil.ILil.ILL.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // ILil.ILil.p021Ll1.I1I
    /* JADX INFO: renamed from: 丨丨丨1丨 */
    public void mo16531(View view, ViewGroup.LayoutParams layoutParams) {
        LLL();
        ViewGroup viewGroup = (ViewGroup) this.I11L.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2268IiL.IL1Iii().onContentChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public View m3041(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zM114l = false;
        if (this.f2271LIl == null) {
            String string = this.f2287lLi1LL.obtainStyledAttributes(ILil.ILil.ILL.AppCompatTheme).getString(ILil.ILil.ILL.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f2271LIl = new AppCompatViewInflater();
            } else {
                try {
                    this.f2271LIl = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f2271LIl = new AppCompatViewInflater();
                }
            }
        }
        boolean z2 = f2260LlLiLL;
        if (z2) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zM114l = m114l((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zM114l = true;
            }
            z = zM114l;
        } else {
            z = false;
        }
        return this.f2271LIl.createView(view, str, context, attributeSet, z, z2, true, LIll.ILil());
    }

    public AppCompatDelegateImpl(Dialog dialog, ILil.ILil.p021Ll1.ILil iLil) {
        this(dialog.getContext(), dialog.getWindow(), iLil, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, ILil.ILil.p021Ll1.ILil iLil, Object obj) {
        Map<Class<?>, Integer> map;
        Integer num;
        AppCompatActivity appCompatActivityLI1I1;
        this.iIlLiL = null;
        this.I11li1 = true;
        this.f2269L11 = -100;
        this.f2289li11 = new ILil();
        this.f2287lLi1LL = context;
        this.f2276L11I = iLil;
        this.f4778Ilil = obj;
        if ((obj instanceof Dialog) && (appCompatActivityLI1I1 = lI1I1()) != null) {
            this.f2269L11 = appCompatActivityLI1I1.iIlLiL().mo1647iILLL1();
        }
        if (this.f2269L11 == -100 && (num = (map = f29iI).get(obj.getClass())) != null) {
            this.f2269L11 = num.intValue();
            map.remove(obj.getClass());
        }
        if (window != null) {
            m116(window);
        }
        ILil.ILil.p023lIlii.iILLL1.m1780IiL();
    }

    public class ILL extends WindowCallbackC0630il {
        public ILL(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode ILil(ActionMode.Callback callback) {
            ILil.ILil.p024llL1ii.iILLL1.IL1Iii iL1Iii = new ILil.ILil.p024llL1ii.iILLL1.IL1Iii(AppCompatDelegateImpl.this.f2287lLi1LL, callback);
            ILil.ILil.p024llL1ii.ILil iLilM30351iIl = AppCompatDelegateImpl.this.m30351iIl(iL1Iii);
            if (iLilM30351iIl != null) {
                return iL1Iii.Ilil(iLilM30351iIl);
            }
            return null;
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m3018LlIl(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.ill1LI1l(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof ILil.ILil.p024llL1ii.ILL.IiL)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.m3022iIl1il(i);
            return true;
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.LI11(i);
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            ILil.ILil.p024llL1ii.ILL.IiL iiL = menu instanceof ILil.ILil.p024llL1ii.ILL.IiL ? (ILil.ILil.p024llL1ii.ILL.IiL) menu : null;
            if (i == 0 && iiL == null) {
                return false;
            }
            if (iiL != null) {
                iiL.setOverrideVisibleItems(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (iiL != null) {
                iiL.setOverrideVisibleItems(false);
            }
            return zOnPreparePanel;
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            ILil.ILil.p024llL1ii.ILL.IiL iiL;
            PanelFeatureState panelFeatureStateM110i1 = AppCompatDelegateImpl.this.m110i1(0, true);
            if (panelFeatureStateM110i1 == null || (iiL = panelFeatureStateM110i1.f2310il) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, iiL, i);
            }
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.m3037i11i() ? ILil(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // ILil.ILil.p024llL1ii.WindowCallbackC0630il, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.m3037i11i() && i == 0) {
                return ILil(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }
}
