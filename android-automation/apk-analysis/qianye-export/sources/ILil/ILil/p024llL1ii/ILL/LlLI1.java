package ILil.ILil.p024llL1ii.ILL;

import ILil.p028IiL.p030IiL.IL1Iii.IL1Iii;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: MenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class LlLI1 extends I1I implements Menu {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final IL1Iii f1477IL;

    public LlLI1(Context context, IL1Iii iL1Iii) {
        super(context);
        if (iL1Iii == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1477IL = iL1Iii;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return I1I(this.f1477IL.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f1477IL.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = I1I(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m1859IL(this.f1477IL.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        Ilil();
        this.f1477IL.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f1477IL.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return I1I(this.f1477IL.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return I1I(this.f1477IL.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f1477IL.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f1477IL.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f1477IL.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f1477IL.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        m1861lLi1LL(i);
        this.f1477IL.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m1860iILLL1(i);
        this.f1477IL.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f1477IL.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f1477IL.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f1477IL.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1477IL.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1477IL.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return I1I(this.f1477IL.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return m1859IL(this.f1477IL.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return I1I(this.f1477IL.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m1859IL(this.f1477IL.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return I1I(this.f1477IL.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m1859IL(this.f1477IL.addSubMenu(i, i2, i3, i4));
    }
}
