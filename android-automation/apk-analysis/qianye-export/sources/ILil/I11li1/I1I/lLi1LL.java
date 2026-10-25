package ILil.I11li1.I1I;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: renamed from: ILil.I11li1.I1I.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: ScrollEventAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class lLi1LL extends RecyclerView.iIlLiL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final RecyclerView f3594I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ViewPager2.AbstractC0670il f3595IL1Iii;
    public boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ViewPager2 f3596ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3597Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final LinearLayoutManager f1190IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f1191IiL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f1192Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f1193L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public IL1Iii f1194iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean f1195lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1196lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f1197il;

    /* JADX INFO: renamed from: ILil.I11li1.I1I.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: ScrollEventAdapter.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3598I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f3599IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public float f3600ILil;

        public void IL1Iii() {
            this.f3599IL1Iii = -1;
            this.f3600ILil = 0.0f;
            this.f3598I1I = 0;
        }
    }

    public lLi1LL(ViewPager2 viewPager2) {
        this.f3596ILil = viewPager2;
        RecyclerView recyclerView = viewPager2.ILL;
        this.f3594I1I = recyclerView;
        this.f1190IL = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f1194iILLL1 = new IL1Iii();
        m1432Ll1();
    }

    public final void I1I(int i) {
        if ((this.f3597Ilil == 3 && this.f1196lLi1LL == 0) || this.f1196lLi1LL == i) {
            return;
        }
        this.f1196lLi1LL = i;
        ViewPager2.AbstractC0670il abstractC0670il = this.f3595IL1Iii;
        if (abstractC0670il != null) {
            abstractC0670il.onPageScrollStateChanged(i);
        }
    }

    public final void IL1Iii(int i, float f, int i2) {
        ViewPager2.AbstractC0670il abstractC0670il = this.f3595IL1Iii;
        if (abstractC0670il != null) {
            abstractC0670il.onPageScrolled(i, f, i2);
        }
    }

    public void ILL(int i, boolean z) {
        this.f3597Ilil = z ? 2 : 3;
        this.f1195lIiI = false;
        boolean z2 = this.f1193L11I != i;
        this.f1193L11I = i;
        I1I(2);
        if (z2) {
            ILil(i);
        }
    }

    public final void ILil(int i) {
        ViewPager2.AbstractC0670il abstractC0670il = this.f3595IL1Iii;
        if (abstractC0670il != null) {
            abstractC0670il.onPageSelected(i);
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m1429ILl(boolean z) {
        this.f1195lIiI = z;
        this.f3597Ilil = z ? 4 : 1;
        int i = this.f1193L11I;
        if (i != -1) {
            this.f1191IiL = i;
            this.f1193L11I = -1;
        } else if (this.f1191IiL == -1) {
            this.f1191IiL = m1430IL();
        }
        I1I(1);
    }

    public double Ilil() {
        Lil();
        IL1Iii iL1Iii = this.f1194iILLL1;
        return ((double) iL1Iii.f3599IL1Iii) + ((double) iL1Iii.f3600ILil);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int m1430IL() {
        return this.f1190IL.findFirstVisibleItemPosition();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m1431IiL() {
        return this.f1196lLi1LL == 0;
    }

    public final void Lil() {
        int top;
        IL1Iii iL1Iii = this.f1194iILLL1;
        int iFindFirstVisibleItemPosition = this.f1190IL.findFirstVisibleItemPosition();
        iL1Iii.f3599IL1Iii = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            iL1Iii.IL1Iii();
            return;
        }
        View viewFindViewByPosition = this.f1190IL.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            iL1Iii.IL1Iii();
            return;
        }
        int leftDecorationWidth = this.f1190IL.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f1190IL.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f1190IL.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f1190IL.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f1190IL.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f3594I1I.getPaddingLeft();
            if (this.f3596ILil.m3417IL()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f3594I1I.getPaddingTop();
        }
        int i = -top;
        iL1Iii.f3598I1I = i;
        if (i >= 0) {
            iL1Iii.f3600ILil = height == 0 ? 0.0f : i / height;
        } else {
            if (!new ILil.I11li1.I1I.IL1Iii(this.f1190IL).m1428IL()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(iL1Iii.f3598I1I)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m1432Ll1() {
        this.f3597Ilil = 0;
        this.f1196lLi1LL = 0;
        this.f1194iILLL1.IL1Iii();
        this.f1191IiL = -1;
        this.f1193L11I = -1;
        this.f1197il = false;
        this.ILL = false;
        this.f1195lIiI = false;
        this.f1192Ll1 = false;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final boolean m1433L11I() {
        int i = this.f3597Ilil;
        return i == 1 || i == 4;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m1434iILLL1() {
        return this.f1195lIiI;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1435lIiI(ViewPager2.AbstractC0670il abstractC0670il) {
        this.f3595IL1Iii = abstractC0670il;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1436lLi1LL() {
        return this.f1196lLi1LL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.iIlLiL
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.f3597Ilil == 1 && this.f1196lLi1LL == 1) && i == 1) {
            m1429ILl(false);
            return;
        }
        if (m1433L11I() && i == 2) {
            if (this.ILL) {
                I1I(2);
                this.f1197il = true;
                return;
            }
            return;
        }
        if (m1433L11I() && i == 0) {
            Lil();
            if (this.ILL) {
                IL1Iii iL1Iii = this.f1194iILLL1;
                if (iL1Iii.f3598I1I == 0) {
                    int i2 = this.f1191IiL;
                    int i3 = iL1Iii.f3599IL1Iii;
                    if (i2 != i3) {
                        ILil(i3);
                    }
                } else {
                    z = false;
                }
            } else {
                int i4 = this.f1194iILLL1.f3599IL1Iii;
                if (i4 != -1) {
                    IL1Iii(i4, 0.0f, 0);
                }
            }
            if (z) {
                I1I(0);
                m1432Ll1();
            }
        }
        if (this.f3597Ilil == 2 && i == 0 && this.f1192Ll1) {
            Lil();
            IL1Iii iL1Iii2 = this.f1194iILLL1;
            if (iL1Iii2.f3598I1I == 0) {
                int i5 = this.f1193L11I;
                int i6 = iL1Iii2.f3599IL1Iii;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    ILil(i6);
                }
                I1I(0);
                m1432Ll1();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView.iIlLiL
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        this.ILL = true;
        Lil();
        if (this.f1197il) {
            this.f1197il = false;
            if (i2 <= 0) {
                if (i2 == 0) {
                    z = (i < 0) == this.f3596ILil.m3417IL();
                }
            }
            if (z) {
                IL1Iii iL1Iii = this.f1194iILLL1;
                if (iL1Iii.f3598I1I != 0) {
                    i3 = iL1Iii.f3599IL1Iii + 1;
                } else {
                    i3 = this.f1194iILLL1.f3599IL1Iii;
                }
            } else {
                i3 = this.f1194iILLL1.f3599IL1Iii;
            }
            this.f1193L11I = i3;
            if (this.f1191IiL != i3) {
                ILil(i3);
            }
        } else if (this.f3597Ilil == 0) {
            int i4 = this.f1194iILLL1.f3599IL1Iii;
            if (i4 == -1) {
                i4 = 0;
            }
            ILil(i4);
        }
        IL1Iii iL1Iii2 = this.f1194iILLL1;
        int i5 = iL1Iii2.f3599IL1Iii;
        if (i5 == -1) {
            i5 = 0;
        }
        IL1Iii(i5, iL1Iii2.f3600ILil, iL1Iii2.f3598I1I);
        IL1Iii iL1Iii3 = this.f1194iILLL1;
        int i6 = iL1Iii3.f3599IL1Iii;
        int i7 = this.f1193L11I;
        if ((i6 == i7 || i7 == -1) && iL1Iii3.f3598I1I == 0 && this.f1196lLi1LL != 1) {
            I1I(0);
            m1432Ll1();
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1437il() {
        this.f1192Ll1 = true;
    }
}
