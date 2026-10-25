package androidx.appcompat.widget;

import ILil.ILil.p023lIlii.L1l;
import ILil.ILil.p023lIlii.iIlLiL;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl;
import ILil.ILil.p024llL1ii.ILL.Lil;
import ILil.ILil.p024llL1ii.ILL.iIi1;
import ILil.ILil.p024llL1ii.ILL.lIiI;
import ILil.ILil.p024llL1ii.ILL.llL1ii;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter extends ILil.ILil.p024llL1ii.ILL.ILil implements ILil.I丨iL.IL丨丨l.ILil.IL1Iii {
    public int I11L;
    public boolean I11li1;
    public IL ILL;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2360ILl;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public int f2361L111;
    public final iILLL1 LL1IL;
    public boolean Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Drawable f2362Ll1;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public I1I f2363LlLLL;
    public boolean iIi1;
    public boolean iIlLiL;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f2364lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public ILil f2365lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2366lIlii;
    public final SparseBooleanArray llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f2367llL1ii;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f2368lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public lLi1LL f2369l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public IL1Iii f23701;

    public class I1I implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public lLi1LL f4826ILil;

        public I1I(lLi1LL lli1ll) {
            this.f4826ILil = lli1ll;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f1454IL != null) {
                ActionMenuPresenter.this.f1454IL.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.f1456L11I;
            if (view != null && view.getWindowToken() != null && this.f4826ILil.m1894lIiI()) {
                ActionMenuPresenter.this.f2369l = this.f4826ILil;
            }
            ActionMenuPresenter.this.f2363LlLLL = null;
        }
    }

    public class IL1Iii extends lIiI {
        public IL1Iii(Context context, iIi1 iii1, View view) {
            super(context, iii1, view, false, ILil.ILil.IL1Iii.actionOverflowMenuStyle);
            if (!((C0629il) iii1.getItem()).m1902Ll1()) {
                View view2 = ActionMenuPresenter.this.ILL;
                m1895lLi1LL(view2 == null ? (View) ActionMenuPresenter.this.f1456L11I : view2);
            }
            m1896il(ActionMenuPresenter.this.LL1IL);
        }

        @Override // ILil.ILil.p024llL1ii.ILL.lIiI
        public void Ilil() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f23701 = null;
            actionMenuPresenter.f2361L111 = 0;
            super.Ilil();
        }
    }

    public class ILil extends ActionMenuItemView.ILil {
        public ILil() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.ILil
        public llL1ii IL1Iii() {
            IL1Iii iL1Iii = ActionMenuPresenter.this.f23701;
            if (iL1Iii != null) {
                return iL1Iii.I1I();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActionMenuPresenter$I丨L, reason: invalid class name */
    public class IL extends AppCompatImageView implements ActionMenuView.IL1Iii {

        /* JADX INFO: renamed from: androidx.appcompat.widget.ActionMenuPresenter$I丨L$IL1Iii */
        public class IL1Iii extends iIlLiL {
            public IL1Iii(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            @Override // ILil.ILil.p023lIlii.iIlLiL
            public boolean I1I() {
                ActionMenuPresenter.this.LL1IL();
                return true;
            }

            @Override // ILil.ILil.p023lIlii.iIlLiL
            public llL1ii ILil() {
                lLi1LL lli1ll = ActionMenuPresenter.this.f2369l;
                if (lli1ll == null) {
                    return null;
                }
                return lli1ll.I1I();
            }

            @Override // ILil.ILil.p023lIlii.iIlLiL
            /* JADX INFO: renamed from: I丨L */
            public boolean mo1775IL() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f2363LlLLL != null) {
                    return false;
                }
                actionMenuPresenter.iIlLiL();
                return true;
            }
        }

        public IL(Context context) {
            super(context, null, ILil.ILil.IL1Iii.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            L1l.IL1Iii(this, getContentDescription());
            setOnTouchListener(new IL1Iii(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.IL1Iii
        public boolean IL1Iii() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.IL1Iii
        public boolean ILil() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.LL1IL();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2252Ll1(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4828ILil;

        public static class IL1Iii implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4828ILil);
        }

        public SavedState(Parcel parcel) {
            this.f4828ILil = parcel.readInt();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActionMenuPresenter$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements InterfaceC0628ILl.IL1Iii {
        public iILLL1() {
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public boolean IL1Iii(IiL iiL) {
            if (iiL == null) {
                return false;
            }
            ActionMenuPresenter.this.f2361L111 = ((iIi1) iiL).getItem().getItemId();
            InterfaceC0628ILl.IL1Iii iL1IiiM1873lLi1LL = ActionMenuPresenter.this.m1873lLi1LL();
            if (iL1IiiM1873lLi1LL != null) {
                return iL1IiiM1873lLi1LL.IL1Iii(iiL);
            }
            return false;
        }

        @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl.IL1Iii
        public void onCloseMenu(IiL iiL, boolean z) {
            if (iiL instanceof iIi1) {
                iiL.getRootMenu().close(false);
            }
            InterfaceC0628ILl.IL1Iii iL1IiiM1873lLi1LL = ActionMenuPresenter.this.m1873lLi1LL();
            if (iL1IiiM1873lLi1LL != null) {
                iL1IiiM1873lLi1LL.onCloseMenu(iiL, z);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActionMenuPresenter$l丨Li1LL, reason: invalid class name */
    public class lLi1LL extends lIiI {
        public lLi1LL(Context context, IiL iiL, View view, boolean z) {
            super(context, iiL, view, z, ILil.ILil.IL1Iii.actionOverflowMenuStyle);
            m1890IiL(8388613);
            m1896il(ActionMenuPresenter.this.LL1IL);
        }

        @Override // ILil.ILil.p024llL1ii.ILL.lIiI
        public void Ilil() {
            if (ActionMenuPresenter.this.f1454IL != null) {
                ActionMenuPresenter.this.f1454IL.close();
            }
            ActionMenuPresenter.this.f2369l = null;
            super.Ilil();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, ILil.ILil.IiL.abc_action_menu_layout, ILil.ILil.IiL.abc_action_menu_item_layout);
        this.llliI = new SparseBooleanArray();
        this.LL1IL = new iILLL1();
    }

    public boolean I11L() {
        lLi1LL lli1ll = this.f2369l;
        return lli1ll != null && lli1ll.m1889IL();
    }

    public boolean I11li1() {
        IL1Iii iL1Iii = this.f23701;
        if (iL1Iii == null) {
            return false;
        }
        iL1Iii.ILil();
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil
    public void I1I(C0629il c0629il, Lil.IL1Iii iL1Iii) {
        iL1Iii.initialize(c0629il, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) iL1Iii;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1456L11I);
        if (this.f2365lIII == null) {
            this.f2365lIII = new ILil();
        }
        actionMenuItemView.setPopupCallback(this.f2365lIII);
    }

    @Override // ILil.I丨iL.IL丨丨l.ILil.IL1Iii
    public void IL1Iii(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        IiL iiL = this.f1454IL;
        if (iiL != null) {
            iiL.close(false);
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil
    public boolean Ilil(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.ILL) {
            return false;
        }
        return super.Ilil(viewGroup, i);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil
    /* JADX INFO: renamed from: I丨iL */
    public Lil mo1870IiL(ViewGroup viewGroup) {
        Lil lil = this.f1456L11I;
        Lil lilMo1870IiL = super.mo1870IiL(viewGroup);
        if (lil != lilMo1870IiL) {
            ((ActionMenuView) lilMo1870IiL).setPresenter(this);
        }
        return lilMo1870IiL;
    }

    public boolean LL1IL() {
        IiL iiL;
        if (!this.f2360ILl || I11L() || (iiL = this.f1454IL) == null || this.f1456L11I == null || this.f2363LlLLL != null || iiL.getNonActionItems().isEmpty()) {
            return false;
        }
        I1I i1i = new I1I(new lLi1LL(this.f3881I1I, this.f1454IL, this.ILL, true));
        this.f2363LlLLL = i1i;
        ((View) this.f1456L11I).post(i1i);
        super.onSubMenuSelected(null);
        return true;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m3062LlLLL(Drawable drawable) {
        IL il = this.ILL;
        if (il != null) {
            il.setImageDrawable(drawable);
        } else {
            this.f2364lIiI = true;
            this.f2362Ll1 = drawable;
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean flagActionItems() {
        ArrayList<C0629il> visibleItems;
        int size;
        int i;
        int iM3069ILl;
        ActionMenuPresenter actionMenuPresenter = this;
        IiL iiL = actionMenuPresenter.f1454IL;
        View view = null;
        int i2 = 0;
        if (iiL != null) {
            visibleItems = iiL.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i3 = actionMenuPresenter.f2366lIlii;
        int i4 = actionMenuPresenter.f2367llL1ii;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1456L11I;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            C0629il c0629il = visibleItems.get(i7);
            if (c0629il.Lil()) {
                i5++;
            } else if (c0629il.m1900ILl()) {
                i6++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.f2368lL && c0629il.isActionViewExpanded()) {
                i3 = 0;
            }
        }
        if (actionMenuPresenter.f2360ILl && (z || i6 + i5 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.llliI;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.iIlLiL) {
            int i9 = actionMenuPresenter.I11L;
            iM3069ILl = i4 / i9;
            i = i9 + ((i4 % i9) / iM3069ILl);
        } else {
            i = 0;
            iM3069ILl = 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            C0629il c0629il2 = visibleItems.get(i10);
            if (c0629il2.Lil()) {
                View viewMo1872iILLL1 = actionMenuPresenter.mo1872iILLL1(c0629il2, view, viewGroup);
                if (actionMenuPresenter.iIlLiL) {
                    iM3069ILl -= ActionMenuView.m3069ILl(viewMo1872iILLL1, i, iM3069ILl, iMakeMeasureSpec, i2);
                } else {
                    viewMo1872iILLL1.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewMo1872iILLL1.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int groupId = c0629il2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                c0629il2.I11li1(true);
            } else {
                if (c0629il2.m1900ILl()) {
                    int groupId2 = c0629il2.getGroupId();
                    boolean z2 = sparseBooleanArray.get(groupId2);
                    boolean z3 = (i8 > 0 || z2) && i4 > 0 && (!actionMenuPresenter.iIlLiL || iM3069ILl > 0);
                    boolean z4 = z3;
                    if (z3) {
                        View viewMo1872iILLL2 = actionMenuPresenter.mo1872iILLL1(c0629il2, null, viewGroup);
                        if (actionMenuPresenter.iIlLiL) {
                            int iM3069ILl2 = ActionMenuView.m3069ILl(viewMo1872iILLL2, i, iM3069ILl, iMakeMeasureSpec, 0);
                            iM3069ILl -= iM3069ILl2;
                            if (iM3069ILl2 == 0) {
                                z4 = false;
                            }
                        } else {
                            viewMo1872iILLL2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        boolean z5 = z4;
                        int measuredWidth2 = viewMo1872iILLL2.getMeasuredWidth();
                        i4 -= measuredWidth2;
                        if (i11 == 0) {
                            i11 = measuredWidth2;
                        }
                        z3 = z5 & (!actionMenuPresenter.iIlLiL ? i4 + i11 <= 0 : i4 < 0);
                    }
                    if (z3 && groupId2 != 0) {
                        sparseBooleanArray.put(groupId2, true);
                    } else if (z2) {
                        sparseBooleanArray.put(groupId2, false);
                        for (int i12 = 0; i12 < i10; i12++) {
                            C0629il c0629il3 = visibleItems.get(i12);
                            if (c0629il3.getGroupId() == groupId2) {
                                if (c0629il3.m1902Ll1()) {
                                    i8++;
                                }
                                c0629il3.I11li1(false);
                            }
                        }
                    }
                    if (z3) {
                        i8--;
                    }
                    c0629il2.I11li1(z3);
                } else {
                    size = size;
                    c0629il2.I11li1(false);
                }
                i10++;
                view = null;
                actionMenuPresenter = this;
                size = size;
                i2 = 0;
            }
            i10++;
            view = null;
            actionMenuPresenter = this;
            size = size;
            i2 = 0;
        }
        return true;
    }

    public Drawable iIi1() {
        IL il = this.ILL;
        if (il != null) {
            return il.getDrawable();
        }
        if (this.f2364lIiI) {
            return this.f2362Ll1;
        }
        return null;
    }

    public boolean iIlLiL() {
        Object obj;
        I1I i1i = this.f2363LlLLL;
        if (i1i != null && (obj = this.f1456L11I) != null) {
            ((View) obj).removeCallbacks(i1i);
            this.f2363LlLLL = null;
            return true;
        }
        lLi1LL lli1ll = this.f2369l;
        if (lli1ll == null) {
            return false;
        }
        lli1ll.ILil();
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil
    /* JADX INFO: renamed from: iI丨LLL1 */
    public View mo1872iILLL1(C0629il c0629il, View view, ViewGroup viewGroup) {
        View actionView = c0629il.getActionView();
        if (actionView == null || c0629il.m1911il()) {
            actionView = super.mo1872iILLL1(c0629il, view, viewGroup);
        }
        actionView.setVisibility(c0629il.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil, ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void initForMenu(Context context, IiL iiL) {
        super.initForMenu(context, iiL);
        Resources resources = context.getResources();
        ILil.ILil.p024llL1ii.IL1Iii iL1IiiILil = ILil.ILil.p024llL1ii.IL1Iii.ILil(context);
        if (!this.Lil) {
            this.f2360ILl = iL1IiiILil.m1856IiL();
        }
        if (!this.I11li1) {
            this.LlLI1 = iL1IiiILil.I1I();
        }
        if (!this.iIi1) {
            this.f2366lIlii = iL1IiiILil.m1855IL();
        }
        int measuredWidth = this.LlLI1;
        if (this.f2360ILl) {
            if (this.ILL == null) {
                IL il = new IL(this.f3882ILil);
                this.ILL = il;
                if (this.f2364lIiI) {
                    il.setImageDrawable(this.f2362Ll1);
                    this.f2362Ll1 = null;
                    this.f2364lIiI = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.ILL.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.ILL.getMeasuredWidth();
        } else {
            this.ILL = null;
        }
        this.f2367llL1ii = measuredWidth;
        this.I11L = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m3063lIII(boolean z) {
        this.f2360ILl = z;
        this.Lil = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final View m3064lIlii(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1456L11I;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof Lil.IL1Iii) && ((Lil.IL1Iii) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void llliI(Configuration configuration) {
        if (!this.iIi1) {
            this.f2366lIlii = ILil.ILil.p024llL1ii.IL1Iii.ILil(this.f3881I1I).m1855IL();
        }
        IiL iiL = this.f1454IL;
        if (iiL != null) {
            iiL.onItemsChanged(true);
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m3065llL1ii() {
        return iIlLiL() | I11li1();
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil, ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onCloseMenu(IiL iiL, boolean z) {
        m3065llL1ii();
        super.onCloseMenu(iiL, z);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).f4828ILil) > 0 && (menuItemFindItem = this.f1454IL.findItem(i)) != null) {
            onSubMenuSelected((iIi1) menuItemFindItem.getSubMenu());
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f4828ILil = this.f2361L111;
        return savedState;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil, ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean onSubMenuSelected(iIi1 iii1) {
        boolean z = false;
        if (!iii1.hasVisibleItems()) {
            return false;
        }
        iIi1 iii2 = iii1;
        while (iii2.getParentMenu() != this.f1454IL) {
            iii2 = (iIi1) iii2.getParentMenu();
        }
        View viewM3064lIlii = m3064lIlii(iii2.getItem());
        if (viewM3064lIlii == null) {
            return false;
        }
        this.f2361L111 = iii1.getItem().getItemId();
        int size = iii1.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = iii1.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        IL1Iii iL1Iii = new IL1Iii(this.f3881I1I, iii1, viewM3064lIlii);
        this.f23701 = iL1Iii;
        iL1Iii.m1893iILLL1(z);
        this.f23701.ILL();
        super.onSubMenuSelected(iii1);
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil, ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.f1456L11I).requestLayout();
        IiL iiL = this.f1454IL;
        boolean z2 = false;
        if (iiL != null) {
            ArrayList<C0629il> actionItems = iiL.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ILil.p028IiL.p029ILl.ILil ILil2 = actionItems.get(i).ILil();
                if (ILil2 != null) {
                    ILil2.m2038L11I(this);
                }
            }
        }
        IiL iiL2 = this.f1454IL;
        ArrayList<C0629il> nonActionItems = iiL2 != null ? iiL2.getNonActionItems() : null;
        if (this.f2360ILl && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.ILL == null) {
                this.ILL = new IL(this.f3882ILil);
            }
            ViewGroup viewGroup = (ViewGroup) this.ILL.getParent();
            if (viewGroup != this.f1456L11I) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.ILL);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1456L11I;
                actionMenuView.addView(this.ILL, actionMenuView.m3071IiL());
            }
        } else {
            IL il = this.ILL;
            if (il != null) {
                Object parent = il.getParent();
                Object obj = this.f1456L11I;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.ILL);
                }
            }
        }
        ((ActionMenuView) this.f1456L11I).setOverflowReserved(this.f2360ILl);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.ILil
    /* JADX INFO: renamed from: 丨il */
    public boolean mo1874il(int i, C0629il c0629il) {
        return c0629il.m1902Ll1();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean m3066lL() {
        return this.f2363LlLLL != null || I11L();
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m3067l(boolean z) {
        this.f2368lL = z;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public void m30681(ActionMenuView actionMenuView) {
        this.f1456L11I = actionMenuView;
        actionMenuView.initialize(this.f1454IL);
    }
}
