package ILil.ILil.p024llL1ii.ILL;

import ILil.p028IiL.p030IiL.IL1Iii.ILil;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: ActionMenuItem.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final int f3869I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final int f3870IL1Iii;
    public Drawable ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f3871ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public CharSequence f1441ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public CharSequence f3872Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public CharSequence f1442IL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Context f1444Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public char f1445L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public char f1446iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public CharSequence f1447lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Intent f1450lLi1LL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1443IiL = 4096;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1451il = 4096;
    public ColorStateList Lil = null;
    public PorterDuff.Mode LlLI1 = null;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean f1449llL1ii = false;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f1448lIlii = false;
    public int iIi1 = 16;

    public IL1Iii(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1444Ll1 = context;
        this.f3870IL1Iii = i2;
        this.f3871ILil = i;
        this.f3869I1I = i4;
        this.f1442IL = charSequence;
    }

    public final void I1I() {
        Drawable drawable = this.ILL;
        if (drawable != null) {
            if (this.f1449llL1ii || this.f1448lIlii) {
                Drawable drawableM2256lIlii = ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2256lIlii(drawable);
                this.ILL = drawableM2256lIlii;
                Drawable drawableMutate = drawableM2256lIlii.mutate();
                this.ILL = drawableMutate;
                if (this.f1449llL1ii) {
                    ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawableMutate, this.Lil);
                }
                if (this.f1448lIlii) {
                    ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(this.ILL, this.LlLI1);
                }
            }
        }
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil
    public ILil IL1Iii(ILil.p028IiL.p029ILl.ILil iLil) {
        throw new UnsupportedOperationException();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil
    public ILil.p028IiL.p029ILl.ILil ILil() {
        return null;
    }

    public ILil Ilil(View view) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILil m1862IL(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1451il;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1445L11I;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1447lIiI;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3871ILil;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.ILL;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.Lil;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.LlLI1;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1450lLi1LL;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3870IL1Iii;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1443IiL;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1446iILLL1;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3869I1I;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1442IL;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3872Ilil;
        return charSequence != null ? charSequence : this.f1442IL;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1441ILl;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.iIi1 & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.iIi1 & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.iIi1 & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.iIi1 & 8) == 0;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil m1863lLi1LL(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        m1862IL(i);
        throw null;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f1445L11I = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.iIi1 = (z ? 1 : 0) | (this.iIi1 & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.iIi1 = (z ? 2 : 0) | (this.iIi1 & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.iIi1 = (z ? 16 : 0) | (this.iIi1 & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.ILL = drawable;
        I1I();
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.Lil = colorStateList;
        this.f1449llL1ii = true;
        I1I();
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.LlLI1 = mode;
        this.f1448lIlii = true;
        I1I();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1450lLi1LL = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f1446iILLL1 = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f1446iILLL1 = c;
        this.f1445L11I = Character.toLowerCase(c2);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        m1863lLi1LL(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1442IL = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3872Ilil = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.iIi1 = (this.iIi1 & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        Ilil(view);
        throw null;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f1445L11I = Character.toLowerCase(c);
        this.f1451il = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public ILil setContentDescription(CharSequence charSequence) {
        this.f1447lIiI = charSequence;
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f1446iILLL1 = c;
        this.f1443IiL = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f1442IL = this.f1444Ll1.getResources().getString(i);
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public ILil setTooltipText(CharSequence charSequence) {
        this.f1441ILl = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.ILL = ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(this.f1444Ll1, i);
        I1I();
        return this;
    }

    @Override // ILil.p028IiL.p030IiL.IL1Iii.ILil, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1446iILLL1 = c;
        this.f1443IiL = KeyEvent.normalizeMetaState(i);
        this.f1445L11I = Character.toLowerCase(c2);
        this.f1451il = KeyEvent.normalizeMetaState(i2);
        return this;
    }
}
