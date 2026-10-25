package ILil.ILil.p024llL1ii.ILL;

import ILil.p028IiL.p030IiL.IL1Iii.ILil;
import ILil.p065Ilil.Ll1;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: BaseMenuWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I1I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Map<ILil.p028IiL.p030IiL.IL1Iii.I1I, SubMenu> f3866I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3867IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Map<ILil, MenuItem> f3868ILil;

    public I1I(Context context) {
        this.f3867IL1Iii = context;
    }

    public final MenuItem I1I(MenuItem menuItem) {
        if (!(menuItem instanceof ILil)) {
            return menuItem;
        }
        ILil iLil = (ILil) menuItem;
        if (this.f3868ILil == null) {
            this.f3868ILil = new Ll1();
        }
        MenuItem menuItem2 = this.f3868ILil.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        ILL ill = new ILL(this.f3867IL1Iii, iLil);
        this.f3868ILil.put(iLil, ill);
        return ill;
    }

    public final void Ilil() {
        Map<ILil, MenuItem> map = this.f3868ILil;
        if (map != null) {
            map.clear();
        }
        Map<ILil.p028IiL.p030IiL.IL1Iii.I1I, SubMenu> map2 = this.f3866I1I;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final SubMenu m1859IL(SubMenu subMenu) {
        if (!(subMenu instanceof ILil.p028IiL.p030IiL.IL1Iii.I1I)) {
            return subMenu;
        }
        ILil.p028IiL.p030IiL.IL1Iii.I1I i1i = (ILil.p028IiL.p030IiL.IL1Iii.I1I) subMenu;
        if (this.f3866I1I == null) {
            this.f3866I1I = new Ll1();
        }
        SubMenu subMenu2 = this.f3866I1I.get(i1i);
        if (subMenu2 != null) {
            return subMenu2;
        }
        iIlLiL iillil = new iIlLiL(this.f3867IL1Iii, i1i);
        this.f3866I1I.put(i1i, iillil);
        return iillil;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m1860iILLL1(int i) {
        Map<ILil, MenuItem> map = this.f3868ILil;
        if (map == null) {
            return;
        }
        Iterator<ILil> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1861lLi1LL(int i) {
        Map<ILil, MenuItem> map = this.f3868ILil;
        if (map == null) {
            return;
        }
        Iterator<ILil> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }
}
