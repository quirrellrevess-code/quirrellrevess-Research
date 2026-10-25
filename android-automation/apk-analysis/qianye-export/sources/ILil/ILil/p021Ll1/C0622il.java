package ILil.ILil.p021Ll1;

import ILil.ILil.ILL;
import ILil.ILil.iILLL1;
import ILil.ILil.p023lIlii.C1;
import ILil.ILil.p023lIlii.LlLI1;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.L11I;
import ILil.p028IiL.p029ILl.LlLLL;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.l;
import ILil.p028IiL.p029ILl.llliI;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ILil.Ll丨1.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public class C0622il extends ActionBar implements ActionBarOverlayLayout.IL {
    public boolean I11L;
    public boolean I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ActionBarOverlayLayout f3734I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3735IL1Iii;
    public ILil.ILil.p024llL1ii.ILil ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f3736ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ArrayList<ActionBar.IL1Iii> f1317ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public LlLI1 f3737Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ActionBarContainer f1318IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public C1 f1319IiL;
    public boolean Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ILil.ILil.ll丨L1ii.ILil.IL1Iii f1320Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f1321L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final LlLLL f1322LlLLL;
    public boolean iIi1;
    public boolean iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public View f1323iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1324lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f1325lIlii;
    public boolean llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean f1326llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ActionBarContextView f1327lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public IL f1328il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public L11I f1329lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final l f1330l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final l f13311;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static final Interpolator f1316lIII = new AccelerateInterpolator();
    public static final Interpolator LL1IL = new DecelerateInterpolator();

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.丨il$I1I */
    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class I1I implements LlLLL {
        public I1I() {
        }

        @Override // ILil.p028IiL.p029ILl.LlLLL
        public void IL1Iii(View view) {
            ((View) C0622il.this.f1318IL.getParent()).invalidate();
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.丨il$IL1Iii */
    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class IL1Iii extends ILil.p028IiL.p029ILl.C1 {
        public IL1Iii() {
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            View view2;
            C0622il c0622il = C0622il.this;
            if (c0622il.f1326llL1ii && (view2 = c0622il.f1323iILLL1) != null) {
                view2.setTranslationY(0.0f);
                C0622il.this.f1318IL.setTranslationY(0.0f);
            }
            C0622il.this.f1318IL.setVisibility(8);
            C0622il.this.f1318IL.setTransitioning(false);
            C0622il c0622il2 = C0622il.this;
            c0622il2.f1329lL = null;
            c0622il2.llliI();
            ActionBarOverlayLayout actionBarOverlayLayout = C0622il.this.f3734I1I;
            if (actionBarOverlayLayout != null) {
                iIlLiL.m70I1(actionBarOverlayLayout);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.丨il$ILil */
    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class ILil extends ILil.p028IiL.p029ILl.C1 {
        public ILil() {
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            C0622il c0622il = C0622il.this;
            c0622il.f1329lL = null;
            c0622il.f1318IL.requestLayout();
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.Ll丨1.丨il$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class IL extends ILil.ILil.p024llL1ii.ILil implements IiL.IL1Iii {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final IiL f3741Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final Context f1332IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public WeakReference<View> f1334iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public ILil.ILil.ll丨L1ii.ILil.IL1Iii f1335lLi1LL;

        public IL(Context context, ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii) {
            this.f1332IL = context;
            this.f1335lLi1LL = iL1Iii;
            IiL defaultShowAsAction = new IiL(context).setDefaultShowAsAction(1);
            this.f3741Ilil = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public Menu I1I() {
            return this.f3741Ilil;
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public void IL1Iii() {
            C0622il c0622il = C0622il.this;
            if (c0622il.f1328il != this) {
                return;
            }
            if (C0622il.I11L(c0622il.f1325lIlii, c0622il.iIi1, false)) {
                this.f1335lLi1LL.IL1Iii(this);
            } else {
                C0622il c0622il2 = C0622il.this;
                c0622il2.ILL = this;
                c0622il2.f1320Ll1 = this.f1335lLi1LL;
            }
            this.f1335lLi1LL = null;
            C0622il.this.m1674lL(false);
            C0622il.this.f1327lLi1LL.m3050iILLL1();
            C0622il.this.f3737Ilil.Lil().sendAccessibilityEvent(32);
            C0622il c0622il3 = C0622il.this;
            c0622il3.f3734I1I.setHideOnContentScrollEnabled(c0622il3.llliI);
            C0622il.this.f1328il = null;
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public void ILL(View view) {
            C0622il.this.f1327lLi1LL.setCustomView(view);
            this.f1334iILLL1 = new WeakReference<>(view);
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public View ILil() {
            WeakReference<View> weakReference = this.f1334iILLL1;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public CharSequence Ilil() {
            return C0622il.this.f1327lLi1LL.getSubtitle();
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public MenuInflater mo1678IL() {
            return new ILil.ILil.p024llL1ii.IiL(this.f1332IL);
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public void Lil(int i) {
            LlLI1(C0622il.this.f3735IL1Iii.getResources().getString(i));
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        public void LlLI1(CharSequence charSequence) {
            C0622il.this.f1327lLi1LL.setTitle(charSequence);
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public void mo1679Ll1(int i) {
            mo1682lIiI(C0622il.this.f3735IL1Iii.getResources().getString(i));
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void mo1680L11I() {
            if (C0622il.this.f1328il != this) {
                return;
            }
            this.f3741Ilil.stopDispatchingItemsChanged();
            try {
                this.f1335lLi1LL.I1I(this, this.f3741Ilil);
            } finally {
                this.f3741Ilil.startDispatchingItemsChanged();
            }
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public CharSequence mo1681iILLL1() {
            return C0622il.this.f1327lLi1LL.getTitle();
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public void mo1682lIiI(CharSequence charSequence) {
            C0622il.this.f1327lLi1LL.setSubtitle(charSequence);
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public boolean m1683lIlii() {
            this.f3741Ilil.stopDispatchingItemsChanged();
            try {
                return this.f1335lLi1LL.ILil(this, this.f3741Ilil);
            } finally {
                this.f3741Ilil.startDispatchingItemsChanged();
            }
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public void mo1684llL1ii(boolean z) {
            super.mo1684llL1ii(z);
            C0622il.this.f1327lLi1LL.setTitleOptional(z);
        }

        @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
        public boolean onMenuItemSelected(IiL iiL, MenuItem menuItem) {
            ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii = this.f1335lLi1LL;
            if (iL1Iii != null) {
                return iL1Iii.mo1918IL(this, menuItem);
            }
            return false;
        }

        @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
        public void onMenuModeChange(IiL iiL) {
            if (this.f1335lLi1LL == null) {
                return;
            }
            mo1680L11I();
            C0622il.this.f1327lLi1LL.m3048Ll1();
        }

        @Override // ILil.ILil.p024llL1ii.ILil
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean mo1685il() {
            return C0622il.this.f1327lLi1LL.m3051il();
        }
    }

    public C0622il(Activity activity, boolean z) {
        new ArrayList();
        this.f1317ILl = new ArrayList<>();
        this.LlLI1 = 0;
        this.f1326llL1ii = true;
        this.I11li1 = true;
        this.f1330l = new IL1Iii();
        this.f13311 = new ILil();
        this.f1322LlLLL = new I1I();
        View decorView = activity.getWindow().getDecorView();
        m1661L111(decorView);
        if (z) {
            return;
        }
        this.f1323iILLL1 = decorView.findViewById(R.id.content);
    }

    public static boolean I11L(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ILil.ILil.p024llL1ii.ILil I11li1(ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii) {
        IL il = this.f1328il;
        if (il != null) {
            il.IL1Iii();
        }
        this.f3734I1I.setHideOnContentScrollEnabled(false);
        this.f1327lLi1LL.ILL();
        IL il2 = new IL(this.f1327lLi1LL.getContext(), iL1Iii);
        if (!il2.m1683lIlii()) {
            return null;
        }
        this.f1328il = il2;
        il2.mo1680L11I();
        this.f1327lLi1LL.m3047IiL(il2);
        m1674lL(true);
        this.f1327lLi1LL.sendAccessibilityEvent(32);
        return il2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.IL
    public void I1I(boolean z) {
        this.f1326llL1ii = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.IL
    public void IL1Iii() {
        if (this.iIi1) {
            this.iIi1 = false;
            m1666ill(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context ILL() {
        if (this.f3736ILil == null) {
            TypedValue typedValue = new TypedValue();
            this.f3735IL1Iii.getTheme().resolveAttribute(ILil.ILil.IL1Iii.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f3736ILil = new ContextThemeWrapper(this.f3735IL1Iii, i);
            } else {
                this.f3736ILil = this.f3735IL1Iii;
            }
        }
        return this.f3736ILil;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.IL
    public void ILil() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.IL
    public void Ilil() {
        L11I l11i = this.f1329lL;
        if (l11i != null) {
            l11i.IL1Iii();
            this.f1329lL = null;
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final boolean m1658IIi() {
        return iIlLiL.m2103LlIl(this.f1318IL);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.IL
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void mo1659IL() {
        if (this.iIi1) {
            return;
        }
        this.iIi1 = true;
        m1666ill(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean mo1660IiL() {
        LlLI1 llLI1 = this.f3737Ilil;
        if (llLI1 == null || !llLI1.mo1755il()) {
            return false;
        }
        this.f3737Ilil.collapseActionView();
        return true;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m1661L111(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(iILLL1.decor_content_parent);
        this.f3734I1I = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f3737Ilil = m1665LlLLL(view.findViewById(iILLL1.action_bar));
        this.f1327lLi1LL = (ActionBarContextView) view.findViewById(iILLL1.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(iILLL1.action_bar_container);
        this.f1318IL = actionBarContainer;
        LlLI1 llLI1 = this.f3737Ilil;
        if (llLI1 == null || this.f1327lLi1LL == null || actionBarContainer == null) {
            throw new IllegalStateException(C0622il.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f3735IL1Iii = llLI1.mo1753llL1ii();
        boolean z = (this.f3737Ilil.mo1752lIlii() & 4) != 0;
        if (z) {
            this.f1321L11I = true;
        }
        ILil.ILil.p024llL1ii.IL1Iii iL1IiiILil = ILil.ILil.p024llL1ii.IL1Iii.ILil(this.f3735IL1Iii);
        m1672iILLl(iL1IiiILil.IL1Iii() || z);
        m1667l1IIi1(iL1IiiILil.m1857iILLL1());
        TypedArray typedArrayObtainStyledAttributes = this.f3735IL1Iii.obtainStyledAttributes(null, ILL.ActionBar, ILil.ILil.IL1Iii.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(ILL.ActionBar_hideOnContentScroll, false)) {
            m1663L1l(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILL.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            llI(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m1662LIll() {
        if (this.iIlLiL) {
            return;
        }
        this.iIlLiL = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3734I1I;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        m1666ill(false);
    }

    public final void LL1IL() {
        if (this.iIlLiL) {
            this.iIlLiL = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f3734I1I;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m1666ill(false);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean Lil(int i, KeyEvent keyEvent) {
        Menu menuI1I;
        IL il = this.f1328il;
        if (il == null || (menuI1I = il.I1I()) == null) {
            return false;
        }
        menuI1I.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuI1I.performShortcut(i, keyEvent, 0);
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public void m1663L1l(boolean z) {
        if (z && !this.f3734I1I.m3056llL1ii()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.llliI = z;
        this.f3734I1I.setHideOnContentScrollEnabled(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void mo1664L11I(boolean z) {
        if (z == this.f1324lIiI) {
            return;
        }
        this.f1324lIiI = z;
        int size = this.f1317ILl.size();
        for (int i = 0; i < size; i++) {
            this.f1317ILl.get(i).IL1Iii(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final LlLI1 m1665LlLLL(View view) {
        if (view instanceof LlLI1) {
            return (LlLI1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void iIi1(boolean z) {
        L11I l11i;
        this.I11L = z;
        if (z || (l11i = this.f1329lL) == null) {
            return;
        }
        l11i.IL1Iii();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void iIlLiL(CharSequence charSequence) {
        this.f3737Ilil.setWindowTitle(charSequence);
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m1666ill(boolean z) {
        if (I11L(this.f1325lIlii, this.iIi1, this.iIlLiL)) {
            if (this.I11li1) {
                return;
            }
            this.I11li1 = true;
            m16771(z);
            return;
        }
        if (this.I11li1) {
            this.I11li1 = false;
            m1675l(z);
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final void m1667l1IIi1(boolean z) {
        this.Lil = z;
        if (z) {
            this.f1318IL.setTabContainer(null);
            this.f3737Ilil.mo1749L11I(this.f1319IiL);
        } else {
            this.f3737Ilil.mo1749L11I(null);
            this.f1318IL.setTabContainer(this.f1319IiL);
        }
        boolean z2 = m1669lIII() == 2;
        C1 c1 = this.f1319IiL;
        if (c1 != null) {
            if (z2) {
                c1.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f3734I1I;
                if (actionBarOverlayLayout != null) {
                    iIlLiL.m70I1(actionBarOverlayLayout);
                }
            } else {
                c1.setVisibility(8);
            }
        }
        this.f3737Ilil.I11li1(!this.Lil && z2);
        this.f3734I1I.setHasNonEmbeddedTabs(!this.Lil && z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void mo1668lIiI(Configuration configuration) {
        m1667l1IIi1(ILil.ILil.p024llL1ii.IL1Iii.ILil(this.f3735IL1Iii).m1857iILLL1());
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public int m1669lIII() {
        return this.f3737Ilil.mo1751lIiI();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void mo1670lIlii(boolean z) {
        if (this.f1321L11I) {
            return;
        }
        m1676LLlI1(z);
    }

    public void llI(float f) {
        iIlLiL.LI11(this.f1318IL, f);
    }

    public void llliI() {
        ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii = this.f1320Ll1;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(this.ILL);
            this.ILL = null;
            this.f1320Ll1 = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.IL
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void mo1671lLi1LL(int i) {
        this.LlLI1 = i;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m1672iILLl(boolean z) {
        this.f3737Ilil.LlLI1(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int mo1673il() {
        return this.f3737Ilil.mo1752lIlii();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1674lL(boolean z) {
        llliI llliiMo1745ILl;
        llliI llliiM1708lLi1LL;
        if (z) {
            m1662LIll();
        } else {
            LL1IL();
        }
        if (!m1658IIi()) {
            if (z) {
                this.f3737Ilil.setVisibility(4);
                this.f1327lLi1LL.setVisibility(0);
                return;
            } else {
                this.f3737Ilil.setVisibility(0);
                this.f1327lLi1LL.setVisibility(8);
                return;
            }
        }
        if (z) {
            llliiM1708lLi1LL = this.f3737Ilil.mo1745ILl(4, 100L);
            llliiMo1745ILl = this.f1327lLi1LL.m1708lLi1LL(0, 200L);
        } else {
            llliiMo1745ILl = this.f3737Ilil.mo1745ILl(0, 200L);
            llliiM1708lLi1LL = this.f1327lLi1LL.m1708lLi1LL(8, 100L);
        }
        L11I l11i = new L11I();
        l11i.m1925IL(llliiM1708lLi1LL, llliiMo1745ILl);
        l11i.m1926IiL();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m1675l(boolean z) {
        View view;
        L11I l11i = this.f1329lL;
        if (l11i != null) {
            l11i.IL1Iii();
        }
        if (this.LlLI1 != 0 || (!this.I11L && !z)) {
            this.f1330l.ILil(null);
            return;
        }
        this.f1318IL.setAlpha(1.0f);
        this.f1318IL.setTransitioning(true);
        L11I l11i2 = new L11I();
        float f = -this.f1318IL.getHeight();
        if (z) {
            int[] iArr = {0, 0};
            this.f1318IL.getLocationInWindow(iArr);
            f -= iArr[1];
        }
        llliI llliiI1I = iIlLiL.I1I(this.f1318IL);
        llliiI1I.ILL(f);
        llliiI1I.m2160L11I(this.f1322LlLLL);
        l11i2.I1I(llliiI1I);
        if (this.f1326llL1ii && (view = this.f1323iILLL1) != null) {
            llliI llliiI1I2 = iIlLiL.I1I(view);
            llliiI1I2.ILL(f);
            l11i2.I1I(llliiI1I2);
        }
        l11i2.m1928lLi1LL(f1316lIII);
        l11i2.Ilil(250L);
        l11i2.m1927iILLL1(this.f1330l);
        this.f1329lL = l11i2;
        l11i2.m1926IiL();
    }

    /* JADX INFO: renamed from: 丨丨 */
    public void m59(int i, int i2) {
        int iMo1752lIlii = this.f3737Ilil.mo1752lIlii();
        if ((i2 & 4) != 0) {
            this.f1321L11I = true;
        }
        this.f3737Ilil.ILL((i & i2) | ((~i2) & iMo1752lIlii));
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public void m1676LLlI1(boolean z) {
        m59(z ? 4 : 0, 4);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m16771(boolean z) {
        View view;
        View view2;
        L11I l11i = this.f1329lL;
        if (l11i != null) {
            l11i.IL1Iii();
        }
        this.f1318IL.setVisibility(0);
        if (this.LlLI1 == 0 && (this.I11L || z)) {
            this.f1318IL.setTranslationY(0.0f);
            float f = -this.f1318IL.getHeight();
            if (z) {
                int[] iArr = {0, 0};
                this.f1318IL.getLocationInWindow(iArr);
                f -= iArr[1];
            }
            this.f1318IL.setTranslationY(f);
            L11I l11i2 = new L11I();
            llliI llliiI1I = iIlLiL.I1I(this.f1318IL);
            llliiI1I.ILL(0.0f);
            llliiI1I.m2160L11I(this.f1322LlLLL);
            l11i2.I1I(llliiI1I);
            if (this.f1326llL1ii && (view2 = this.f1323iILLL1) != null) {
                view2.setTranslationY(f);
                llliI llliiI1I2 = iIlLiL.I1I(this.f1323iILLL1);
                llliiI1I2.ILL(0.0f);
                l11i2.I1I(llliiI1I2);
            }
            l11i2.m1928lLi1LL(LL1IL);
            l11i2.Ilil(250L);
            l11i2.m1927iILLL1(this.f13311);
            this.f1329lL = l11i2;
            l11i2.m1926IiL();
        } else {
            this.f1318IL.setAlpha(1.0f);
            this.f1318IL.setTranslationY(0.0f);
            if (this.f1326llL1ii && (view = this.f1323iILLL1) != null) {
                view.setTranslationY(0.0f);
            }
            this.f13311.ILil(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3734I1I;
        if (actionBarOverlayLayout != null) {
            iIlLiL.m70I1(actionBarOverlayLayout);
        }
    }

    public C0622il(Dialog dialog) {
        new ArrayList();
        this.f1317ILl = new ArrayList<>();
        this.LlLI1 = 0;
        this.f1326llL1ii = true;
        this.I11li1 = true;
        this.f1330l = new IL1Iii();
        this.f13311 = new ILil();
        this.f1322LlLLL = new I1I();
        m1661L111(dialog.getWindow().getDecorView());
    }
}
