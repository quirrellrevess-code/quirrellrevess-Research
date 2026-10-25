package ILil.ILil.p024llL1ii.ILL;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuItemWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL extends ILil.ILil.p024llL1ii.ILL.I1I implements MenuItem {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Method f3873Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final ILil.p028IiL.p030IiL.IL1Iii.ILil f1452IL;

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public static class I1I extends FrameLayout implements ILil.ILil.p024llL1ii.I1I {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final CollapsibleActionView f3874ILil;

        /* JADX WARN: Multi-variable type inference failed */
        public I1I(View view) {
            super(view.getContext());
            this.f3874ILil = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // ILil.ILil.p024llL1ii.I1I
        public void I1I() {
            this.f3874ILil.onActionViewCollapsed();
        }

        public View IL1Iii() {
            return (View) this.f3874ILil;
        }

        @Override // ILil.ILil.p024llL1ii.I1I
        public void ILil() {
            this.f3874ILil.onActionViewExpanded();
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class IL1Iii extends ILil.p028IiL.p029ILl.ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final ActionProvider f3875I1I;

        public IL1Iii(Context context, ActionProvider actionProvider) {
            super(context);
            this.f3875I1I = actionProvider;
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        public View I1I() {
            return this.f3875I1I.onCreateActionView();
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        public boolean IL1Iii() {
            return this.f3875I1I.hasSubMenu();
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        public boolean Ilil() {
            return this.f3875I1I.onPerformDefaultAction();
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void mo1865lLi1LL(SubMenu subMenu) {
            this.f3875I1I.onPrepareSubMenu(ILL.this.m1859IL(subMenu));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class ILil extends IL1Iii implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public ILil.p028IiL.p029ILl.ILil.InterfaceC0563ILil f3876Ilil;

        public ILil(ILL ill, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        public boolean ILil() {
            return this.f3875I1I.isVisible();
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public View mo1866IL(MenuItem menuItem) {
            return this.f3875I1I.onCreateActionView(menuItem);
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean mo1867iILLL1() {
            return this.f3875I1I.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ILil.p028IiL.p029ILl.ILil.InterfaceC0563ILil interfaceC0563ILil = this.f3876Ilil;
            if (interfaceC0563ILil != null) {
                interfaceC0563ILil.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // ILil.p028IiL.p029ILl.ILil
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void mo1868il(ILil.p028IiL.p029ILl.ILil.InterfaceC0563ILil interfaceC0563ILil) {
            this.f3876Ilil = interfaceC0563ILil;
            this.f3875I1I.setVisibilityListener(interfaceC0563ILil != null ? this : null);
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.ILL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class IL implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f3877IL1Iii;

        public IL(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f3877IL1Iii = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f3877IL1Iii.onMenuItemActionCollapse(ILL.this.I1I(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f3877IL1Iii.onMenuItemActionExpand(ILL.this.I1I(menuItem));
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.ILL.ILL$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class lLi1LL implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f3879IL1Iii;

        public lLi1LL(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f3879IL1Iii = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f3879IL1Iii.onMenuItemClick(ILL.this.I1I(menuItem));
        }
    }

    public ILL(Context context, ILil.p028IiL.p030IiL.IL1Iii.ILil iLil) {
        super(context);
        if (iLil == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1452IL = iLil;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1864IiL(boolean z) {
        try {
            if (this.f3873Ilil == null) {
                this.f3873Ilil = this.f1452IL.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f3873Ilil.invoke(this.f1452IL, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1452IL.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1452IL.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        ILil.p028IiL.p029ILl.ILil ILil2 = this.f1452IL.ILil();
        if (ILil2 instanceof IL1Iii) {
            return ((IL1Iii) ILil2).f3875I1I;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1452IL.getActionView();
        return actionView instanceof I1I ? ((I1I) actionView).IL1Iii() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1452IL.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1452IL.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1452IL.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1452IL.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1452IL.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1452IL.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1452IL.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1452IL.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1452IL.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1452IL.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1452IL.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1452IL.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1452IL.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m1859IL(this.f1452IL.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1452IL.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1452IL.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1452IL.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1452IL.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1452IL.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1452IL.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1452IL.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1452IL.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1452IL.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ILil.p028IiL.p029ILl.ILil iLil = Build.VERSION.SDK_INT >= 16 ? new ILil(this, this.f3867IL1Iii, actionProvider) : new IL1Iii(this.f3867IL1Iii, actionProvider);
        ILil.p028IiL.p030IiL.IL1Iii.ILil iLil2 = this.f1452IL;
        if (actionProvider == null) {
            iLil = null;
        }
        iLil2.IL1Iii(iLil);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new I1I(view);
        }
        this.f1452IL.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f1452IL.setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f1452IL.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f1452IL.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1452IL.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f1452IL.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1452IL.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1452IL.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1452IL.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1452IL.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f1452IL.setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1452IL.setOnActionExpandListener(onActionExpandListener != null ? new IL(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1452IL.setOnMenuItemClickListener(onMenuItemClickListener != null ? new lLi1LL(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f1452IL.setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f1452IL.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f1452IL.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1452IL.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1452IL.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1452IL.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f1452IL.setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f1452IL.setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1452IL.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f1452IL.setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1452IL.setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f1452IL.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f1452IL.setActionView(i);
        View actionView = this.f1452IL.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1452IL.setActionView(new I1I(actionView));
        }
        return this;
    }
}
