package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import ILil.ILil.L11I;
import ILil.ILil.iILLL1;
import ILil.ILil.lLi1LL;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl;
import ILil.p028IiL.p029ILl.C1;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.llliI;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.l1IIi1丨, reason: invalid class name */
/* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class l1IIi1 implements LlLI1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public View f3798I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Toolbar f3799IL1Iii;
    public CharSequence ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3800ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ActionMenuPresenter f1383ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Drawable f3801Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public View f1384IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1385IiL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Window.Callback f1386Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public CharSequence f1387L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Drawable f1388iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1389lIiI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public Drawable f1390llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Drawable f1391lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public CharSequence f1392il;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.l1IIi1丨$IL1Iii */
    /* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
    public class IL1Iii implements View.OnClickListener {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ILil.ILil.p024llL1ii.ILL.IL1Iii f3803ILil;

        public IL1Iii() {
            this.f3803ILil = new ILil.ILil.p024llL1ii.ILL.IL1Iii(l1IIi1.this.f3799IL1Iii.getContext(), 0, R.id.home, 0, 0, l1IIi1.this.f1387L11I);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l1IIi1 l1iii1 = l1IIi1.this;
            Window.Callback callback = l1iii1.f1386Ll1;
            if (callback == null || !l1iii1.f1389lIiI) {
                return;
            }
            callback.onMenuItemSelected(0, this.f3803ILil);
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.l1IIi1丨$ILil */
    /* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
    public class ILil extends C1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f3805IL1Iii = false;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f3806ILil;

        public ILil(int i) {
            this.f3806ILil = i;
        }

        @Override // ILil.p028IiL.p029ILl.C1, ILil.p028IiL.p029ILl.l
        public void I1I(View view) {
            l1IIi1.this.f3799IL1Iii.setVisibility(0);
        }

        @Override // ILil.p028IiL.p029ILl.C1, ILil.p028IiL.p029ILl.l
        public void IL1Iii(View view) {
            this.f3805IL1Iii = true;
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            if (this.f3805IL1Iii) {
                return;
            }
            l1IIi1.this.f3799IL1Iii.setVisibility(this.f3806ILil);
        }
    }

    public l1IIi1(Toolbar toolbar, boolean z) {
        this(toolbar, z, L11I.abc_action_bar_up_description, lLi1LL.abc_ic_ab_back_material);
    }

    public void I11L(View view) {
        View view2 = this.f1384IL;
        if (view2 != null && (this.f3800ILil & 16) != 0) {
            this.f3799IL1Iii.removeView(view2);
        }
        this.f1384IL = view;
        if (view == null || (this.f3800ILil & 16) == 0) {
            return;
        }
        this.f3799IL1Iii.addView(view);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void I11li1(boolean z) {
        this.f3799IL1Iii.setCollapsible(z);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void I1I() {
        this.f1389lIiI = true;
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void IL1Iii(Menu menu, InterfaceC0628ILl.IL1Iii iL1Iii) {
        if (this.f1383ILl == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f3799IL1Iii.getContext());
            this.f1383ILl = actionMenuPresenter;
            actionMenuPresenter.m1871L11I(iILLL1.action_menu_presenter);
        }
        this.f1383ILl.setCallback(iL1Iii);
        this.f3799IL1Iii.setMenu((IiL) menu, this.f1383ILl);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void ILL(int i) {
        View view;
        int i2 = this.f3800ILil ^ i;
        this.f3800ILil = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m60();
                }
                llI();
            }
            if ((i2 & 3) != 0) {
                m1793l1IIi1();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f3799IL1Iii.setTitle(this.f1387L11I);
                    this.f3799IL1Iii.setSubtitle(this.f1392il);
                } else {
                    this.f3799IL1Iii.setTitle((CharSequence) null);
                    this.f3799IL1Iii.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f1384IL) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f3799IL1Iii.addView(view);
            } else {
                this.f3799IL1Iii.removeView(view);
            }
        }
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public boolean ILil() {
        return this.f3799IL1Iii.isOverflowMenuShowing();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: IL丨丨l */
    public llliI mo1745ILl(int i, long j) {
        llliI llliiI1I = iIlLiL.I1I(this.f3799IL1Iii);
        llliiI1I.IL1Iii(i == 0 ? 1.0f : 0.0f);
        llliiI1I.m2158IL(j);
        llliiI1I.m2162lLi1LL(new ILil(i));
        return llliiI1I;
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public boolean Ilil() {
        return this.f3799IL1Iii.isOverflowMenuShowPending();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: I丨L */
    public boolean mo1746IL() {
        return this.f3799IL1Iii.canShowOverflowMenu();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: I丨iL */
    public void mo1747IiL() {
        this.f3799IL1Iii.dismissPopupMenus();
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public void m1791L111(CharSequence charSequence) {
        this.f1385IiL = true;
        m1797LLlI1(charSequence);
    }

    public void LL1IL(CharSequence charSequence) {
        this.f1392il = charSequence;
        if ((this.f3800ILil & 8) != 0) {
            this.f3799IL1Iii.setSubtitle(charSequence);
        }
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public ViewGroup Lil() {
        return this.f3799IL1Iii;
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void LlLI1(boolean z) {
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: Ll丨1 */
    public void mo1748Ll1(int i) {
        m1796l(i != 0 ? ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(mo1753llL1ii(), i) : null);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: L丨1丨1丨I */
    public void mo1749L11I(C1 c1) {
        View view = this.f3798I1I;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f3799IL1Iii;
            if (parent == toolbar) {
                toolbar.removeView(this.f3798I1I);
            }
        }
        this.f3798I1I = c1;
        if (c1 == null || this.Lil != 2) {
            return;
        }
        this.f3799IL1Iii.addView(c1, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f3798I1I.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.f4748IL1Iii = BadgeDrawable.BOTTOM_START;
        c1.setAllowCollapse(true);
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m1792LlLLL(CharSequence charSequence) {
        this.ILL = charSequence;
        m60();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void collapseActionView() {
        this.f3799IL1Iii.collapseActionView();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public CharSequence getTitle() {
        return this.f3799IL1Iii.getTitle();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void iIi1() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void iIlLiL() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: iI丨LLL1 */
    public boolean mo1750iILLL1() {
        return this.f3799IL1Iii.showOverflowMenu();
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final void m1793l1IIi1() {
        Drawable drawable;
        int i = this.f3800ILil;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f1391lLi1LL) == null) {
            drawable = this.f3801Ilil;
        }
        this.f3799IL1Iii.setLogo(drawable);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: lIi丨I */
    public int mo1751lIiI() {
        return this.Lil;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m1794lIII(Drawable drawable) {
        this.f1388iILLL1 = drawable;
        llI();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: lI丨lii */
    public int mo1752lIlii() {
        return this.f3800ILil;
    }

    public final void llI() {
        if ((this.f3800ILil & 4) == 0) {
            this.f3799IL1Iii.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f3799IL1Iii;
        Drawable drawable = this.f1388iILLL1;
        if (drawable == null) {
            drawable = this.f1390llL1ii;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public void llliI(int i) {
        if (i == this.LlLI1) {
            return;
        }
        this.LlLI1 = i;
        if (TextUtils.isEmpty(this.f3799IL1Iii.getNavigationContentDescription())) {
            m17981(this.LlLI1);
        }
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: ll丨L1ii */
    public Context mo1753llL1ii() {
        return this.f3799IL1Iii.getContext();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: l丨Li1LL */
    public boolean mo1754lLi1LL() {
        return this.f3799IL1Iii.hideOverflowMenu();
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void setIcon(int i) {
        setIcon(i != 0 ? ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(mo1753llL1ii(), i) : null);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void setVisibility(int i) {
        this.f3799IL1Iii.setVisibility(i);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void setWindowCallback(Window.Callback callback) {
        this.f1386Ll1 = callback;
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1385IiL) {
            return;
        }
        m1797LLlI1(charSequence);
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    /* JADX INFO: renamed from: 丨il */
    public boolean mo1755il() {
        return this.f3799IL1Iii.hasExpandedActionView();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final int m1795lL() {
        if (this.f3799IL1Iii.getNavigationIcon() == null) {
            return 11;
        }
        this.f1390llL1ii = this.f3799IL1Iii.getNavigationIcon();
        return 15;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m1796l(Drawable drawable) {
        this.f1391lLi1LL = drawable;
        m1793l1IIi1();
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final void m60() {
        if ((this.f3800ILil & 4) != 0) {
            if (TextUtils.isEmpty(this.ILL)) {
                this.f3799IL1Iii.setNavigationContentDescription(this.LlLI1);
            } else {
                this.f3799IL1Iii.setNavigationContentDescription(this.ILL);
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m1797LLlI1(CharSequence charSequence) {
        this.f1387L11I = charSequence;
        if ((this.f3800ILil & 8) != 0) {
            this.f3799IL1Iii.setTitle(charSequence);
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m17981(int i) {
        m1792LlLLL(i == 0 ? null : mo1753llL1ii().getString(i));
    }

    public l1IIi1(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.Lil = 0;
        this.LlLI1 = 0;
        this.f3799IL1Iii = toolbar;
        this.f1387L11I = toolbar.getTitle();
        this.f1392il = toolbar.getSubtitle();
        this.f1385IiL = this.f1387L11I != null;
        this.f1388iILLL1 = toolbar.getNavigationIcon();
        llI lliI11li1 = llI.I11li1(toolbar.getContext(), null, ILL.ActionBar, ILil.ILil.IL1Iii.actionBarStyle, 0);
        this.f1390llL1ii = lliI11li1.m1827iILLL1(ILL.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceLlLI1 = lliI11li1.LlLI1(ILL.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceLlLI1)) {
                m1791L111(charSequenceLlLI1);
            }
            CharSequence charSequenceLlLI2 = lliI11li1.LlLI1(ILL.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceLlLI2)) {
                LL1IL(charSequenceLlLI2);
            }
            Drawable drawableM1827iILLL1 = lliI11li1.m1827iILLL1(ILL.ActionBar_logo);
            if (drawableM1827iILLL1 != null) {
                m1796l(drawableM1827iILLL1);
            }
            Drawable drawableM1827iILLL2 = lliI11li1.m1827iILLL1(ILL.ActionBar_icon);
            if (drawableM1827iILLL2 != null) {
                setIcon(drawableM1827iILLL2);
            }
            if (this.f1388iILLL1 == null && (drawable = this.f1390llL1ii) != null) {
                m1794lIII(drawable);
            }
            ILL(lliI11li1.ILL(ILL.ActionBar_displayOptions, 0));
            int iM1822ILl = lliI11li1.m1822ILl(ILL.ActionBar_customNavigationLayout, 0);
            if (iM1822ILl != 0) {
                I11L(LayoutInflater.from(this.f3799IL1Iii.getContext()).inflate(iM1822ILl, (ViewGroup) this.f3799IL1Iii, false));
                ILL(this.f3800ILil | 16);
            }
            int iM1828lIiI = lliI11li1.m1828lIiI(ILL.ActionBar_height, 0);
            if (iM1828lIiI > 0) {
                ViewGroup.LayoutParams layoutParams = this.f3799IL1Iii.getLayoutParams();
                layoutParams.height = iM1828lIiI;
                this.f3799IL1Iii.setLayoutParams(layoutParams);
            }
            int iIlil = lliI11li1.Ilil(ILL.ActionBar_contentInsetStart, -1);
            int iIlil2 = lliI11li1.Ilil(ILL.ActionBar_contentInsetEnd, -1);
            if (iIlil >= 0 || iIlil2 >= 0) {
                this.f3799IL1Iii.setContentInsetsRelative(Math.max(iIlil, 0), Math.max(iIlil2, 0));
            }
            int iM1822ILl2 = lliI11li1.m1822ILl(ILL.ActionBar_titleTextStyle, 0);
            if (iM1822ILl2 != 0) {
                Toolbar toolbar2 = this.f3799IL1Iii;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iM1822ILl2);
            }
            int iM1822ILl3 = lliI11li1.m1822ILl(ILL.ActionBar_subtitleTextStyle, 0);
            if (iM1822ILl3 != 0) {
                Toolbar toolbar3 = this.f3799IL1Iii;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iM1822ILl3);
            }
            int iM1822ILl4 = lliI11li1.m1822ILl(ILL.ActionBar_popupTheme, 0);
            if (iM1822ILl4 != 0) {
                this.f3799IL1Iii.setPopupTheme(iM1822ILl4);
            }
        } else {
            this.f3800ILil = m1795lL();
        }
        lliI11li1.m1833lL();
        llliI(i);
        this.ILL = this.f3799IL1Iii.getNavigationContentDescription();
        this.f3799IL1Iii.setNavigationOnClickListener(new IL1Iii());
    }

    @Override // ILil.ILil.p023lIlii.LlLI1
    public void setIcon(Drawable drawable) {
        this.f3801Ilil = drawable;
        m1793l1IIi1();
    }
}
