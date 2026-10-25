package ILil.ILil.p024llL1ii.ILL;

import ILil.ILil.L11I;
import ILil.p028IiL.p030IiL.IL1Iii.ILil;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.flexbox.BuildConfig;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: MenuItemImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0629il implements ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int f3917I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final int f3918IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f3919ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public IiL f1507ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public CharSequence f3920Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f1508IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public char f1509IiL;
    public MenuItem.OnActionExpandListener LL1IL;
    public iIi1 Lil;
    public Runnable LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Drawable f1511Ll1;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public View f1513LlLLL;
    public CharSequence iIi1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Intent f1514iILLL1;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public ILil.p028IiL.p029ILl.ILil f1516lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public CharSequence f1517lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public MenuItem.OnMenuItemClickListener f1518llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public CharSequence f1519lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public char f1520il;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public ContextMenu.ContextMenuInfo f1523LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public int f15241;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1512L11I = 4096;
    public int ILL = 4096;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f1515lIiI = 0;
    public ColorStateList iIlLiL = null;
    public PorterDuff.Mode I11li1 = null;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f1521lL = false;
    public boolean I11L = false;
    public boolean llliI = false;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int f1522l = 16;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public boolean f1510L111 = false;

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.丨il$IL1Iii */
    /* JADX INFO: compiled from: MenuItemImpl.java */
    public class IL1Iii implements ILil.p028IiL.p029ILl.ILil.InterfaceC0563ILil {
        public IL1Iii() {
        }

        @Override // ILil.p028IiL.p029ILl.ILil.InterfaceC0563ILil
        public void onActionProviderVisibilityChanged(boolean z) {
            C0629il c0629il = C0629il.this;
            c0629il.f1507ILl.onItemVisibleChanged(c0629il);
        }
    }

    public C0629il(IiL iiL, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f15241 = 0;
        this.f1507ILl = iiL;
        this.f3918IL1Iii = i2;
        this.f3919ILil = i;
        this.f3917I1I = i3;
        this.f1508IL = i4;
        this.f3920Ilil = charSequence;
        this.f15241 = i5;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1899IL(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public ILil I11L(int i) {
        setShowAsAction(i);
        return this;
    }

    public void I11li1(boolean z) {
        if (z) {
            this.f1522l |= 32;
        } else {
            this.f1522l &= -33;
        }
    }

    public void I1I() {
        this.f1507ILl.onItemActionRequestChanged(this);
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil
    public ILil IL1Iii(ILil.p028IiL.p029ILl.ILil iLil) {
        ILil.p028IiL.p029ILl.ILil iLil2 = this.f1516lIII;
        if (iLil2 != null) {
            iLil2.m2037IiL();
        }
        this.f1513LlLLL = null;
        this.f1516lIII = iLil;
        this.f1507ILl.onItemsChanged(true);
        ILil.p028IiL.p029ILl.ILil iLil3 = this.f1516lIII;
        if (iLil3 != null) {
            iLil3.mo1868il(new IL1Iii());
        }
        return this;
    }

    public boolean ILL() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1518llL1ii;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        IiL iiL = this.f1507ILl;
        if (iiL.dispatchMenuItemSelected(iiL, this)) {
            return true;
        }
        Runnable runnable = this.LlLI1;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1514iILLL1 != null) {
            try {
                this.f1507ILl.getContext().startActivity(this.f1514iILLL1);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        ILil.p028IiL.p029ILl.ILil iLil = this.f1516lIII;
        return iLil != null && iLil.Ilil();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil
    public ILil.p028IiL.p029ILl.ILil ILil() {
        return this.f1516lIII;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m1900ILl() {
        return (this.f15241 & 1) == 1;
    }

    public final Drawable Ilil(Drawable drawable) {
        if (drawable != null && this.llliI && (this.f1521lL || this.I11L)) {
            drawable = ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2256lIlii(drawable).mutate();
            if (this.f1521lL) {
                ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawable, this.iIlLiL);
            }
            if (this.I11L) {
                ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(drawable, this.I11li1);
            }
            this.llliI = false;
        }
        return drawable;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public String m1901IiL() {
        char cM1905iILLL1 = m1905iILLL1();
        if (cM1905iILLL1 == 0) {
            return BuildConfig.FLAVOR;
        }
        Resources resources = this.f1507ILl.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1507ILl.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(L11I.abc_prepend_shortcut_label));
        }
        int i = this.f1507ILl.isQwertyMode() ? this.ILL : this.f1512L11I;
        m1899IL(sb, i, 65536, resources.getString(L11I.abc_menu_meta_shortcut_label));
        m1899IL(sb, i, 4096, resources.getString(L11I.abc_menu_ctrl_shortcut_label));
        m1899IL(sb, i, 2, resources.getString(L11I.abc_menu_alt_shortcut_label));
        m1899IL(sb, i, 1, resources.getString(L11I.abc_menu_shift_shortcut_label));
        m1899IL(sb, i, 4, resources.getString(L11I.abc_menu_sym_shortcut_label));
        m1899IL(sb, i, 8, resources.getString(L11I.abc_menu_function_shortcut_label));
        if (cM1905iILLL1 == '\b') {
            sb.append(resources.getString(L11I.abc_menu_delete_shortcut_label));
        } else if (cM1905iILLL1 == '\n') {
            sb.append(resources.getString(L11I.abc_menu_enter_shortcut_label));
        } else if (cM1905iILLL1 != ' ') {
            sb.append(cM1905iILLL1);
        } else {
            sb.append(resources.getString(L11I.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    public boolean Lil() {
        return (this.f15241 & 2) == 2;
    }

    public ILil LlLI1(int i) {
        Context context = this.f1507ILl.getContext();
        m1909llL1ii(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m1902Ll1() {
        return (this.f1522l & 32) == 32;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public CharSequence m1903L11I(Lil.IL1Iii iL1Iii) {
        return (iL1Iii == null || !iL1Iii.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public boolean m1904LlLLL() {
        return this.f1507ILl.isShortcutsVisible() && m1905iILLL1() != 0;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f15241 & 8) == 0) {
            return false;
        }
        if (this.f1513LlLLL == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.LL1IL;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1507ILl.collapseItemActionView(this);
        }
        return false;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public boolean expandActionView() {
        if (!m1911il()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.LL1IL;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1507ILl.expandItemActionView(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public View getActionView() {
        View view = this.f1513LlLLL;
        if (view != null) {
            return view;
        }
        ILil.p028IiL.p029ILl.ILil iLil = this.f1516lIII;
        if (iLil == null) {
            return null;
        }
        View viewMo1866IL = iLil.mo1866IL(this);
        this.f1513LlLLL = viewMo1866IL;
        return viewMo1866IL;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.ILL;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1520il;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1517lIlii;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3919ILil;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1511Ll1;
        if (drawable != null) {
            return Ilil(drawable);
        }
        if (this.f1515lIiI == 0) {
            return null;
        }
        Drawable drawableM1686IL = ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(this.f1507ILl.getContext(), this.f1515lIiI);
        this.f1515lIiI = 0;
        this.f1511Ll1 = drawableM1686IL;
        return Ilil(drawableM1686IL);
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.iIlLiL;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.I11li1;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1514iILLL1;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f3918IL1Iii;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1523LLlI1;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1512L11I;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1509IiL;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3917I1I;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.Lil;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f3920Ilil;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1519lLi1LL;
        if (charSequence == null) {
            charSequence = this.f3920Ilil;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.iIi1;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.Lil != null;
    }

    public void iIi1(boolean z) {
        int i = this.f1522l;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.f1522l = i2;
        if (i != i2) {
            this.f1507ILl.onItemsChanged(false);
        }
    }

    public void iIlLiL(boolean z) {
        this.f1522l = (z ? 4 : 0) | (this.f1522l & (-5));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public char m1905iILLL1() {
        return this.f1507ILl.isQwertyMode() ? this.f1520il : this.f1509IiL;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1510L111;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1522l & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1522l & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1522l & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ILil.p028IiL.p029ILl.ILil iLil = this.f1516lIII;
        if (iLil == null || !iLil.mo1867iILLL1()) {
            return (this.f1522l & 8) == 0;
        }
        return (this.f1522l & 8) == 0 && this.f1516lIII.ILil();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m1906lIiI() {
        return (this.f1522l & 4) != 0;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean m1907lIII() {
        return (this.f15241 & 4) == 4;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m1908lIlii(boolean z) {
        this.f1510L111 = z;
        this.f1507ILl.onItemsChanged(false);
    }

    public void llliI(iIi1 iii1) {
        this.Lil = iii1;
        iii1.setHeaderTitle(getTitle());
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public ILil m1909llL1ii(View view) {
        int i;
        this.f1513LlLLL = view;
        this.f1516lIII = null;
        if (view != null && view.getId() == -1 && (i = this.f3918IL1Iii) > 0) {
            view.setId(i);
        }
        this.f1507ILl.onItemActionRequestChanged(this);
        return this;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1910lLi1LL() {
        return this.f1508IL;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        LlLI1(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1520il == c) {
            return this;
        }
        this.f1520il = Character.toLowerCase(c);
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f1522l;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.f1522l = i2;
        if (i != i2) {
            this.f1507ILl.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f1522l & 4) != 0) {
            this.f1507ILl.setExclusiveItemChecked(this);
        } else {
            iIi1(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1522l |= 16;
        } else {
            this.f1522l &= -17;
        }
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1515lIiI = 0;
        this.f1511Ll1 = drawable;
        this.llliI = true;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.iIlLiL = colorStateList;
        this.f1521lL = true;
        this.llliI = true;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.I11li1 = mode;
        this.I11L = true;
        this.llliI = true;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1514iILLL1 = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f1509IiL == c) {
            return this;
        }
        this.f1509IiL = c;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.LL1IL = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1518llL1ii = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f1509IiL = c;
        this.f1520il = Character.toLowerCase(c2);
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f15241 = i;
        this.f1507ILl.onItemActionRequestChanged(this);
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        I11L(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3920Ilil = charSequence;
        this.f1507ILl.onItemsChanged(false);
        iIi1 iii1 = this.Lil;
        if (iii1 != null) {
            iii1.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1519lLi1LL = charSequence;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m1913l(z)) {
            this.f1507ILl.onItemVisibleChanged(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f3920Ilil;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m1911il() {
        ILil.p028IiL.p029ILl.ILil iLil;
        if ((this.f15241 & 8) == 0) {
            return false;
        }
        if (this.f1513LlLLL == null && (iLil = this.f1516lIII) != null) {
            this.f1513LlLLL = iLil.mo1866IL(this);
        }
        return this.f1513LlLLL != null;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1912lL(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1523LLlI1 = contextMenuInfo;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public boolean m1913l(boolean z) {
        int i = this.f1522l;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.f1522l = i2;
        return i != i2;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m19141() {
        return this.f1507ILl.getOptionalIconsVisible();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        m1909llL1ii(view);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public ILil setContentDescription(CharSequence charSequence) {
        this.f1517lIlii = charSequence;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public ILil setTooltipText(CharSequence charSequence) {
        this.iIi1 = charSequence;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f1520il == c && this.ILL == i) {
            return this;
        }
        this.f1520il = Character.toLowerCase(c);
        this.ILL = KeyEvent.normalizeMetaState(i);
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f1509IiL == c && this.f1512L11I == i) {
            return this;
        }
        this.f1509IiL = c;
        this.f1512L11I = KeyEvent.normalizeMetaState(i);
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1509IiL = c;
        this.f1512L11I = KeyEvent.normalizeMetaState(i);
        this.f1520il = Character.toLowerCase(c2);
        this.ILL = KeyEvent.normalizeMetaState(i2);
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1511Ll1 = null;
        this.f1515lIiI = i;
        this.llliI = true;
        this.f1507ILl.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.f1507ILl.getContext().getString(i));
        return this;
    }
}
