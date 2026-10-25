package androidx.viewpager2.widget;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static boolean f2843lL = true;
    public lLi1LL I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Rect f5242I1I;
    public RecyclerView ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Rect f5243ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ILil.I11li1.I1I.ILil f2844ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5244Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILil.I11li1.I1I.ILil f2845IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public LinearLayoutManager f2846IiL;
    public ILil.I11li1.I1I.I1I Lil;
    public ILil.I11li1.I1I.IL LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ILil.Lil.p037IL.Ll1 f2847Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2848L11I;
    public boolean iIi1;
    public int iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public RecyclerView.AbstractC0665il f2849iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public ILil.I11li1.I1I.lLi1LL f2850lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f2851lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public RecyclerView.lIiI f2852llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f2853lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Parcelable f2854il;

    public class I1I extends AbstractC0670il {
        public I1I() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
        public void onPageSelected(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.ILL.requestFocus(2);
            }
        }
    }

    public class IL1Iii extends IiL {
        public IL1Iii() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f2853lLi1LL = true;
            viewPager2.f2850lIiI.m1437il();
        }
    }

    public class ILL extends lLi1LL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public RecyclerView.AbstractC0665il f5247I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ILil.p028IiL.p029ILl.LL1IL.iILLL1 f5248IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ILil.p028IiL.p029ILl.LL1IL.iILLL1 f5249ILil;

        public class I1I extends IiL {
            public I1I() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
            public void onChanged() {
                ILL.this.I11L();
            }
        }

        public class IL1Iii implements ILil.p028IiL.p029ILl.LL1IL.iILLL1 {
            public IL1Iii() {
            }

            @Override // ILil.p028IiL.p029ILl.LL1IL.iILLL1
            public boolean perform(View view, ILil.p028IiL.p029ILl.LL1IL.iILLL1.IL1Iii iL1Iii) {
                ILL.this.m3433lL(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        public class ILil implements ILil.p028IiL.p029ILl.LL1IL.iILLL1 {
            public ILil() {
            }

            @Override // ILil.p028IiL.p029ILl.LL1IL.iILLL1
            public boolean perform(View view, ILil.p028IiL.p029ILl.LL1IL.iILLL1.IL1Iii iL1Iii) {
                ILL.this.m3433lL(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        public ILL() {
            super(ViewPager2.this, null);
            this.f5248IL1Iii = new IL1Iii();
            this.f5249ILil = new ILil();
        }

        public void I11L() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = R.id.accessibilityActionPageLeft;
            iIlLiL.m71I(viewPager2, R.id.accessibilityActionPageLeft);
            iIlLiL.m71I(viewPager2, R.id.accessibilityActionPageRight);
            iIlLiL.m71I(viewPager2, R.id.accessibilityActionPageUp);
            iIlLiL.m71I(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.Ilil()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f5244Ilil < itemCount - 1) {
                    iIlLiL.m2113iILilI(viewPager2, new ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii(R.id.accessibilityActionPageDown, null), null, this.f5248IL1Iii);
                }
                if (ViewPager2.this.f5244Ilil > 0) {
                    iIlLiL.m2113iILilI(viewPager2, new ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii(R.id.accessibilityActionPageUp, null), null, this.f5249ILil);
                    return;
                }
                return;
            }
            boolean zM3417IL = ViewPager2.this.m3417IL();
            int i2 = zM3417IL ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zM3417IL) {
                i = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f5244Ilil < itemCount - 1) {
                iIlLiL.m2113iILilI(viewPager2, new ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii(i2, null), null, this.f5248IL1Iii);
            }
            if (ViewPager2.this.f5244Ilil > 0) {
                iIlLiL.m2113iILilI(viewPager2, new ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii(i, null), null, this.f5249ILil);
            }
        }

        public final void I11li1(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.IiL adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.Ilil()) {
                return;
            }
            if (ViewPager2.this.f5244Ilil > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f5244Ilil < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public boolean I1I(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public boolean IL1Iii() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public void Ilil(RecyclerView.IiL<?> iiL) {
            I11L();
            if (iiL != null) {
                iiL.registerAdapterDataObserver(this.f5247I1I);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void mo3425IiL(ILil.I11li1.I1I.ILil iLil, RecyclerView recyclerView) {
            iIlLiL.m72LL(recyclerView, 2);
            this.f5247I1I = new I1I();
            if (iIlLiL.I11L(ViewPager2.this) == 0) {
                iIlLiL.m72LL(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public void Lil(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(mo3428iILLL1());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public void LlLI1() {
            I11L();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public boolean mo3426Ll1(int i, Bundle bundle) {
            if (!I1I(i, bundle)) {
                throw new IllegalStateException();
            }
            m3433lL(i == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void mo3427L11I(AccessibilityNodeInfo accessibilityNodeInfo) {
            iIlLiL(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                I11li1(accessibilityNodeInfo);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public void iIi1() {
            I11L();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public final void iIlLiL(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() != null) {
                if (ViewPager2.this.getOrientation() == 1) {
                    itemCount = ViewPager2.this.getAdapter().getItemCount();
                } else {
                    itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                    itemCount = 0;
                }
                ILil.p028IiL.p029ILl.LL1IL.I1I.LII(accessibilityNodeInfo).m2059LlLiLL(ILil.I丨iL.IL丨丨l.LL1IL.I1I.ILil.ILil(itemCount, itemCount2, false, 0));
            }
            itemCount = 0;
            itemCount2 = 0;
            ILil.p028IiL.p029ILl.LL1IL.I1I.LII(accessibilityNodeInfo).m2059LlLiLL(ILil.I丨iL.IL丨丨l.LL1IL.I1I.ILil.ILil(itemCount, itemCount2, false, 0));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public String mo3428iILLL1() {
            if (IL1Iii()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public void mo3429lIiI() {
            I11L();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public void mo3430lIlii() {
            I11L();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public void mo3431llL1ii() {
            I11L();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void mo3432lLi1LL(RecyclerView.IiL<?> iiL) {
            if (iiL != null) {
                iiL.unregisterAdapterDataObserver(this.f5247I1I);
            }
        }

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public void m3433lL(int i) {
            if (ViewPager2.this.Ilil()) {
                ViewPager2.this.ILL(i, true);
            }
        }
    }

    public class ILil extends AbstractC0670il {
        public ILil() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                ViewPager2.this.Lil();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
        public void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f5244Ilil != i) {
                viewPager2.f5244Ilil = i;
                viewPager2.I11li1.mo3431llL1ii();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$IL丨丨l, reason: invalid class name and case insensitive filesystem */
    public class C0669ILl extends RecyclerView {
        public C0669ILl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.I11li1.mo3435IL() ? ViewPager2.this.I11li1.mo3434ILl() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f5244Ilil);
            accessibilityEvent.setToIndex(ViewPager2.this.f5244Ilil);
            ViewPager2.this.I11li1.Lil(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.Ilil() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.Ilil() && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$I丨L, reason: invalid class name */
    public class IL implements RecyclerView.llL1ii {
        public IL(ViewPager2 viewPager2) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.llL1ii
        public void IL1Iii(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.llL1ii
        public void ILil(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$I丨iL, reason: invalid class name */
    public static abstract class IiL extends RecyclerView.AbstractC0665il {
        public IiL() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public /* synthetic */ IiL(IL1Iii iL1Iii) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0665il
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    public static class Lil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final RecyclerView f5255I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f5256ILil;

        public Lil(int i, RecyclerView recyclerView) {
            this.f5256ILil = i;
            this.f5255I1I = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5255I1I.smoothScrollToPosition(this.f5256ILil);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$Ll丨1, reason: invalid class name */
    public interface Ll1 {
        void IL1Iii(View view, float f);
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$L丨1丨1丨I, reason: invalid class name */
    public class L11I extends LinearLayoutManager {
        public L11I(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.C1 c1, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(c1, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
        public void onInitializeAccessibilityNodeInfo(RecyclerView.lL lLVar, RecyclerView.C1 c1, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            super.onInitializeAccessibilityNodeInfo(lLVar, c1, i1i);
            ViewPager2.this.I11li1.mo3436il(i1i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
        public boolean performAccessibilityAction(RecyclerView.lL lLVar, RecyclerView.C1 c1, int i, Bundle bundle) {
            return ViewPager2.this.I11li1.ILil(i) ? ViewPager2.this.I11li1.ILL(i) : super.performAccessibilityAction(lLVar, c1, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$iI丨LLL1, reason: invalid class name */
    public class iILLL1 extends lLi1LL {
        public iILLL1() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public boolean ILL(int i) {
            if (ILil(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        public boolean ILil(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.Ilil();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public CharSequence mo3434ILl() {
            if (mo3435IL()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean mo3435IL() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.lLi1LL
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void mo3436il(ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
            if (ViewPager2.this.Ilil()) {
                return;
            }
            i1i.m2079lliiI1(ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii.f1617L11I);
            i1i.m2079lliiI1(ILil.I丨iL.IL丨丨l.LL1IL.I1I.IL1Iii.f1615IiL);
            i1i.m63LL(false);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$lIi丨I, reason: invalid class name */
    public class lIiI extends ILil.Lil.p037IL.Ll1 {
        public lIiI() {
        }

        @Override // ILil.Lil.p037IL.Ll1, ILil.Lil.p037IL.LlLI1
        /* JADX INFO: renamed from: I丨iL */
        public View mo2413IiL(RecyclerView.LlLI1 llLI1) {
            if (ViewPager2.this.I1I()) {
                return null;
            }
            return super.mo2413IiL(llLI1);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$l丨Li1LL, reason: invalid class name */
    public abstract class lLi1LL {
        public lLi1LL(ViewPager2 viewPager2) {
        }

        public boolean I1I(int i, Bundle bundle) {
            return false;
        }

        public boolean IL1Iii() {
            return false;
        }

        public boolean ILL(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean ILil(int i) {
            return false;
        }

        /* JADX INFO: renamed from: IL丨丨l */
        public CharSequence mo3434ILl() {
            throw new IllegalStateException("Not implemented.");
        }

        public void Ilil(RecyclerView.IiL<?> iiL) {
        }

        /* JADX INFO: renamed from: I丨L */
        public boolean mo3435IL() {
            return false;
        }

        /* JADX INFO: renamed from: I丨iL */
        public void mo3425IiL(ILil.I11li1.I1I.ILil iLil, RecyclerView recyclerView) {
        }

        public void Lil(AccessibilityEvent accessibilityEvent) {
        }

        public void LlLI1() {
        }

        /* JADX INFO: renamed from: Ll丨1 */
        public boolean mo3426Ll1(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo3427L11I(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void iIi1() {
        }

        /* JADX INFO: renamed from: iI丨LLL1 */
        public String mo3428iILLL1() {
            throw new IllegalStateException("Not implemented.");
        }

        /* JADX INFO: renamed from: lIi丨I */
        public void mo3429lIiI() {
        }

        /* JADX INFO: renamed from: lI丨lii */
        public void mo3430lIlii() {
        }

        /* JADX INFO: renamed from: ll丨L1ii */
        public void mo3431llL1ii() {
        }

        /* JADX INFO: renamed from: l丨Li1LL */
        public void mo3432lLi1LL(RecyclerView.IiL<?> iiL) {
        }

        /* JADX INFO: renamed from: 丨il */
        public void mo3436il(ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
        }

        public /* synthetic */ lLi1LL(ViewPager2 viewPager2, IL1Iii iL1Iii) {
            this(viewPager2);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager2.widget.ViewPager2$丨il, reason: invalid class name and case insensitive filesystem */
    public static abstract class AbstractC0670il {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.f5243ILil = new Rect();
        this.f5242I1I = new Rect();
        this.f2845IL = new ILil.I11li1.I1I.ILil(3);
        this.f2853lLi1LL = false;
        this.f2849iILLL1 = new IL1Iii();
        this.f2848L11I = -1;
        this.f2852llL1ii = null;
        this.f2851lIlii = false;
        this.iIi1 = true;
        this.iIlLiL = -1;
        ILil(context, null);
    }

    public boolean I1I() {
        return this.Lil.IL1Iii();
    }

    public final RecyclerView.llL1ii IL1Iii() {
        return new IL(this);
    }

    public void ILL(int i, boolean z) {
        RecyclerView.IiL adapter = getAdapter();
        if (adapter == null) {
            if (this.f2848L11I != -1) {
                this.f2848L11I = Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
        if (iMin == this.f5244Ilil && this.f2850lIiI.m1431IiL()) {
            return;
        }
        int i2 = this.f5244Ilil;
        if (iMin == i2 && z) {
            return;
        }
        double dIlil = i2;
        this.f5244Ilil = iMin;
        this.I11li1.mo3431llL1ii();
        if (!this.f2850lIiI.m1431IiL()) {
            dIlil = this.f2850lIiI.Ilil();
        }
        this.f2850lIiI.ILL(iMin, z);
        if (!z) {
            this.ILL.scrollToPosition(iMin);
            return;
        }
        double d = iMin;
        if (Math.abs(d - dIlil) <= 3.0d) {
            this.ILL.smoothScrollToPosition(iMin);
            return;
        }
        this.ILL.scrollToPosition(d > dIlil ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.ILL;
        recyclerView.post(new Lil(iMin, recyclerView));
    }

    public final void ILil(Context context, AttributeSet attributeSet) {
        this.I11li1 = f2843lL ? new ILL() : new iILLL1();
        C0669ILl c0669ILl = new C0669ILl(context);
        this.ILL = c0669ILl;
        c0669ILl.setId(iIlLiL.m2132il());
        this.ILL.setDescendantFocusability(131072);
        L11I l11i = new L11I(context);
        this.f2846IiL = l11i;
        this.ILL.setLayoutManager(l11i);
        this.ILL.setScrollingTouchSlop(1);
        m3419Ll1(context, attributeSet);
        this.ILL.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ILL.addOnChildAttachStateChangeListener(IL1Iii());
        ILil.I11li1.I1I.lLi1LL lli1ll = new ILil.I11li1.I1I.lLi1LL(this);
        this.f2850lIiI = lli1ll;
        this.Lil = new ILil.I11li1.I1I.I1I(this, lli1ll, this.ILL);
        lIiI liii = new lIiI();
        this.f2847Ll1 = liii;
        liii.ILil(this.ILL);
        this.ILL.addOnScrollListener(this.f2850lIiI);
        ILil.I11li1.I1I.ILil iLil = new ILil.I11li1.I1I.ILil(3);
        this.f2844ILl = iLil;
        this.f2850lIiI.m1435lIiI(iLil);
        ILil iLil2 = new ILil();
        I1I i1i = new I1I();
        this.f2844ILl.IL1Iii(iLil2);
        this.f2844ILl.IL1Iii(i1i);
        this.I11li1.mo3425IiL(this.f2844ILl, this.ILL);
        this.f2844ILl.IL1Iii(this.f2845IL);
        ILil.I11li1.I1I.IL il = new ILil.I11li1.I1I.IL(this.f2846IiL);
        this.LlLI1 = il;
        this.f2844ILl.IL1Iii(il);
        RecyclerView recyclerView = this.ILL;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m3416ILl(AbstractC0670il abstractC0670il) {
        this.f2845IL.ILil(abstractC0670il);
    }

    public boolean Ilil() {
        return this.iIi1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m3417IL() {
        return this.f2846IiL.getLayoutDirection() == 1;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m3418IiL() {
        if (this.LlLI1.IL1Iii() == null) {
            return;
        }
        double dIlil = this.f2850lIiI.Ilil();
        int i = (int) dIlil;
        float f = (float) (dIlil - ((double) i));
        this.LlLI1.onPageScrolled(i, f, Math.round(getPageSize() * f));
    }

    public void Lil() {
        ILil.Lil.p037IL.Ll1 ll1 = this.f2847Ll1;
        if (ll1 == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewMo2413IiL = ll1.mo2413IiL(this.f2846IiL);
        if (viewMo2413IiL == null) {
            return;
        }
        int position = this.f2846IiL.getPosition(viewMo2413IiL);
        if (position != this.f5244Ilil && getScrollState() == 0) {
            this.f2844ILl.onPageSelected(position);
        }
        this.f2853lLi1LL = false;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3419Ll1(Context context, AttributeSet attributeSet) {
        int[] iArr = ILil.I11li1.IL1Iii.ViewPager2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(ILil.I11li1.IL1Iii.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3420L11I() {
        RecyclerView.IiL adapter;
        if (this.f2848L11I == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f2854il;
        if (parcelable != null) {
            if (adapter instanceof ILil.I11li1.ILil.I1I) {
                ((ILil.I11li1.ILil.I1I) adapter).ILil(parcelable);
            }
            this.f2854il = null;
        }
        int iMax = Math.max(0, Math.min(this.f2848L11I, adapter.getItemCount() - 1));
        this.f5244Ilil = iMax;
        this.f2848L11I = -1;
        this.ILL.scrollToPosition(iMax);
        this.I11li1.mo3429lIiI();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.ILL.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.ILL.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).f5259ILil;
            sparseArray.put(this.ILL.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m3420L11I();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.I11li1.IL1Iii() ? this.I11li1.mo3428iILLL1() : super.getAccessibilityClassName();
    }

    public RecyclerView.IiL getAdapter() {
        return this.ILL.getAdapter();
    }

    public int getCurrentItem() {
        return this.f5244Ilil;
    }

    public int getItemDecorationCount() {
        return this.ILL.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.iIlLiL;
    }

    public int getOrientation() {
        return this.f2846IiL.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.ILL;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f2850lIiI.m1436lLi1LL();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3421iILLL1(AbstractC0670il abstractC0670il) {
        this.f2845IL.IL1Iii(abstractC0670il);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final void m3422lIiI(RecyclerView.IiL<?> iiL) {
        if (iiL != null) {
            iiL.unregisterAdapterDataObserver(this.f2849iILLL1);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m3423lLi1LL(RecyclerView.IiL<?> iiL) {
        if (iiL != null) {
            iiL.registerAdapterDataObserver(this.f2849iILLL1);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.I11li1.mo3427L11I(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.ILL.getMeasuredWidth();
        int measuredHeight = this.ILL.getMeasuredHeight();
        this.f5243ILil.left = getPaddingLeft();
        this.f5243ILil.right = (i3 - i) - getPaddingRight();
        this.f5243ILil.top = getPaddingTop();
        this.f5243ILil.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f5243ILil, this.f5242I1I);
        RecyclerView recyclerView = this.ILL;
        Rect rect = this.f5242I1I;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f2853lLi1LL) {
            Lil();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.ILL, i, i2);
        int measuredWidth = this.ILL.getMeasuredWidth();
        int measuredHeight = this.ILL.getMeasuredHeight();
        int measuredState = this.ILL.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2848L11I = savedState.f5258I1I;
        this.f2854il = savedState.f2856IL;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5259ILil = this.ILL.getId();
        int i = this.f2848L11I;
        if (i == -1) {
            i = this.f5244Ilil;
        }
        savedState.f5258I1I = i;
        Parcelable parcelable = this.f2854il;
        if (parcelable != null) {
            savedState.f2856IL = parcelable;
        } else {
            Object adapter = this.ILL.getAdapter();
            if (adapter instanceof ILil.I11li1.ILil.I1I) {
                savedState.f2856IL = ((ILil.I11li1.ILil.I1I) adapter).IL1Iii();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return this.I11li1.I1I(i, bundle) ? this.I11li1.mo3426Ll1(i, bundle) : super.performAccessibilityAction(i, bundle);
    }

    public void setAdapter(RecyclerView.IiL iiL) {
        RecyclerView.IiL adapter = this.ILL.getAdapter();
        this.I11li1.mo3432lLi1LL(adapter);
        m3422lIiI(adapter);
        this.ILL.setAdapter(iiL);
        this.f5244Ilil = 0;
        m3420L11I();
        this.I11li1.Ilil(iiL);
        m3423lLi1LL(iiL);
    }

    public void setCurrentItem(int i) {
        m3424il(i, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.I11li1.LlLI1();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.iIlLiL = i;
        this.ILL.requestLayout();
    }

    public void setOrientation(int i) {
        this.f2846IiL.setOrientation(i);
        this.I11li1.mo3430lIlii();
    }

    public void setPageTransformer(Ll1 ll1) {
        if (ll1 != null) {
            if (!this.f2851lIlii) {
                this.f2852llL1ii = this.ILL.getItemAnimator();
                this.f2851lIlii = true;
            }
            this.ILL.setItemAnimator(null);
        } else if (this.f2851lIlii) {
            this.ILL.setItemAnimator(this.f2852llL1ii);
            this.f2852llL1ii = null;
            this.f2851lIlii = false;
        }
        if (ll1 == this.LlLI1.IL1Iii()) {
            return;
        }
        this.LlLI1.ILil(ll1);
        m3418IiL();
    }

    public void setUserInputEnabled(boolean z) {
        this.iIi1 = z;
        this.I11li1.iIi1();
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m3424il(int i, boolean z) {
        if (I1I()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        ILL(i, z);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5258I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5259ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public Parcelable f2856IL;

        public static class IL1Iii implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            IL1Iii(parcel, classLoader);
        }

        public final void IL1Iii(Parcel parcel, ClassLoader classLoader) {
            this.f5259ILil = parcel.readInt();
            this.f5258I1I = parcel.readInt();
            this.f2856IL = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5259ILil);
            parcel.writeInt(this.f5258I1I);
            parcel.writeParcelable(this.f2856IL, i);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            IL1Iii(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5243ILil = new Rect();
        this.f5242I1I = new Rect();
        this.f2845IL = new ILil.I11li1.I1I.ILil(3);
        this.f2853lLi1LL = false;
        this.f2849iILLL1 = new IL1Iii();
        this.f2848L11I = -1;
        this.f2852llL1ii = null;
        this.f2851lIlii = false;
        this.iIi1 = true;
        this.iIlLiL = -1;
        ILil(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5243ILil = new Rect();
        this.f5242I1I = new Rect();
        this.f2845IL = new ILil.I11li1.I1I.ILil(3);
        this.f2853lLi1LL = false;
        this.f2849iILLL1 = new IL1Iii();
        this.f2848L11I = -1;
        this.f2852llL1ii = null;
        this.f2851lIlii = false;
        this.iIi1 = true;
        this.iIlLiL = -1;
        ILil(context, attributeSet);
    }
}
