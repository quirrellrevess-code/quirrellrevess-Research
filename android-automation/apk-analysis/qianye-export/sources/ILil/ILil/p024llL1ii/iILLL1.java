package ILil.ILil.p024llL1ii;

import ILil.ILil.p024llL1ii.ILL.ILL;
import ILil.ILil.p024llL1ii.ILL.LlLI1;
import ILil.p028IiL.p030IiL.IL1Iii.ILil;
import ILil.p065Ilil.lIlii;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: SupportActionModeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends ActionMode {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3946IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ILil f3947ILil;

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.iI丨LLL1$IL1Iii */
    /* JADX INFO: compiled from: SupportActionModeWrapper.java */
    public static class IL1Iii implements ILil.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ActionMode.Callback f3949IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Context f3950ILil;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final ArrayList<iILLL1> f3948I1I = new ArrayList<>();

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final lIlii<Menu, Menu> f1548IL = new lIlii<>();

        public IL1Iii(Context context, ActionMode.Callback callback) {
            this.f3950ILil = context;
            this.f3949IL1Iii = callback;
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        public boolean I1I(ILil iLil, Menu menu) {
            return this.f3949IL1Iii.onPrepareActionMode(Ilil(iLil), m1930lLi1LL(menu));
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        public void IL1Iii(ILil iLil) {
            this.f3949IL1Iii.onDestroyActionMode(Ilil(iLil));
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        public boolean ILil(ILil iLil, Menu menu) {
            return this.f3949IL1Iii.onCreateActionMode(Ilil(iLil), m1930lLi1LL(menu));
        }

        public ActionMode Ilil(ILil iLil) {
            int size = this.f3948I1I.size();
            for (int i = 0; i < size; i++) {
                iILLL1 iilll1 = this.f3948I1I.get(i);
                if (iilll1 != null && iilll1.f3947ILil == iLil) {
                    return iilll1;
                }
            }
            iILLL1 iilll2 = new iILLL1(this.f3950ILil, iLil);
            this.f3948I1I.add(iilll2);
            return iilll2;
        }

        @Override // ILil.ILil.ll丨L1ii.ILil.IL1Iii
        /* JADX INFO: renamed from: I丨L */
        public boolean mo1918IL(ILil iLil, MenuItem menuItem) {
            return this.f3949IL1Iii.onActionItemClicked(Ilil(iLil), new ILL(this.f3950ILil, (ILil) menuItem));
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final Menu m1930lLi1LL(Menu menu) {
            Menu menu2 = this.f1548IL.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            LlLI1 llLI1 = new LlLI1(this.f3950ILil, (ILil.p028IiL.p030IiL.IL1Iii.IL1Iii) menu);
            this.f1548IL.put(menu, llLI1);
            return llLI1;
        }
    }

    public iILLL1(Context context, ILil iLil) {
        this.f3946IL1Iii = context;
        this.f3947ILil = iLil;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f3947ILil.IL1Iii();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f3947ILil.ILil();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new LlLI1(this.f3946IL1Iii, (ILil.p028IiL.p030IiL.IL1Iii.IL1Iii) this.f3947ILil.I1I());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f3947ILil.mo1678IL();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f3947ILil.Ilil();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f3947ILil.m1917lLi1LL();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f3947ILil.mo1681iILLL1();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f3947ILil.m1916IiL();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f3947ILil.mo1680L11I();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f3947ILil.mo1685il();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f3947ILil.ILL(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f3947ILil.mo1682lIiI(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f3947ILil.m1915ILl(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f3947ILil.LlLI1(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f3947ILil.mo1684llL1ii(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f3947ILil.mo1679Ll1(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f3947ILil.Lil(i);
    }
}
