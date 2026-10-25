package ILil.Lil.p037IL;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Rect f4257I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final RecyclerView.LlLI1 f4258IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4259ILil;

    /* JADX INFO: compiled from: OrientationHelper.java */
    public static class IL1Iii extends ILL {
        public IL1Iii(RecyclerView.LlLI1 llLI1) {
            super(llLI1, null);
        }

        @Override // ILil.Lil.p037IL.ILL
        public int ILL() {
            return this.f4258IL1Iii.getWidthMode();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: IL丨丨l */
        public int mo2353ILl() {
            return (this.f4258IL1Iii.getWidth() - this.f4258IL1Iii.getPaddingLeft()) - this.f4258IL1Iii.getPaddingRight();
        }

        @Override // ILil.Lil.p037IL.ILL
        public int Ilil(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4258IL1Iii.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: I丨L */
        public int mo2354IL(View view) {
            return this.f4258IL1Iii.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: I丨iL */
        public int mo2355IiL() {
            return this.f4258IL1Iii.getWidth();
        }

        @Override // ILil.Lil.p037IL.ILL
        public int LlLI1(View view) {
            this.f4258IL1Iii.getTransformedBoundingBox(view, true, this.f4257I1I);
            return this.f4257I1I.right;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: Ll丨1 */
        public int mo2356Ll1() {
            return this.f4258IL1Iii.getHeightMode();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public int mo2357L11I() {
            return this.f4258IL1Iii.getWidth() - this.f4258IL1Iii.getPaddingRight();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: iI丨LLL1 */
        public int mo2358iILLL1(View view) {
            return this.f4258IL1Iii.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: lIi丨I */
        public int mo2359lIiI() {
            return this.f4258IL1Iii.getPaddingLeft();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: lI丨lii */
        public void mo2360lIlii(int i) {
            this.f4258IL1Iii.offsetChildrenHorizontal(i);
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: ll丨L1ii */
        public int mo2361llL1ii(View view) {
            this.f4258IL1Iii.getTransformedBoundingBox(view, true, this.f4257I1I);
            return this.f4257I1I.left;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: l丨Li1LL */
        public int mo2362lLi1LL(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4258IL1Iii.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: 丨il */
        public int mo2363il() {
            return this.f4258IL1Iii.getPaddingRight();
        }
    }

    /* JADX INFO: compiled from: OrientationHelper.java */
    public static class ILil extends ILL {
        public ILil(RecyclerView.LlLI1 llLI1) {
            super(llLI1, null);
        }

        @Override // ILil.Lil.p037IL.ILL
        public int ILL() {
            return this.f4258IL1Iii.getHeightMode();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: IL丨丨l */
        public int mo2353ILl() {
            return (this.f4258IL1Iii.getHeight() - this.f4258IL1Iii.getPaddingTop()) - this.f4258IL1Iii.getPaddingBottom();
        }

        @Override // ILil.Lil.p037IL.ILL
        public int Ilil(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4258IL1Iii.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: I丨L */
        public int mo2354IL(View view) {
            return this.f4258IL1Iii.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: I丨iL */
        public int mo2355IiL() {
            return this.f4258IL1Iii.getHeight();
        }

        @Override // ILil.Lil.p037IL.ILL
        public int LlLI1(View view) {
            this.f4258IL1Iii.getTransformedBoundingBox(view, true, this.f4257I1I);
            return this.f4257I1I.bottom;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: Ll丨1 */
        public int mo2356Ll1() {
            return this.f4258IL1Iii.getWidthMode();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public int mo2357L11I() {
            return this.f4258IL1Iii.getHeight() - this.f4258IL1Iii.getPaddingBottom();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: iI丨LLL1 */
        public int mo2358iILLL1(View view) {
            return this.f4258IL1Iii.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: lIi丨I */
        public int mo2359lIiI() {
            return this.f4258IL1Iii.getPaddingTop();
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: lI丨lii */
        public void mo2360lIlii(int i) {
            this.f4258IL1Iii.offsetChildrenVertical(i);
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: ll丨L1ii */
        public int mo2361llL1ii(View view) {
            this.f4258IL1Iii.getTransformedBoundingBox(view, true, this.f4257I1I);
            return this.f4257I1I.top;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: l丨Li1LL */
        public int mo2362lLi1LL(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f4258IL1Iii.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // ILil.Lil.p037IL.ILL
        /* JADX INFO: renamed from: 丨il */
        public int mo2363il() {
            return this.f4258IL1Iii.getPaddingBottom();
        }
    }

    public /* synthetic */ ILL(RecyclerView.LlLI1 llLI1, IL1Iii iL1Iii) {
        this(llLI1);
    }

    public static ILL I1I(RecyclerView.LlLI1 llLI1) {
        return new ILil(llLI1);
    }

    public static ILL IL1Iii(RecyclerView.LlLI1 llLI1) {
        return new IL1Iii(llLI1);
    }

    public static ILL ILil(RecyclerView.LlLI1 llLI1, int i) {
        if (i == 0) {
            return IL1Iii(llLI1);
        }
        if (i == 1) {
            return I1I(llLI1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int ILL();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public abstract int mo2353ILl();

    public abstract int Ilil(View view);

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public abstract int mo2354IL(View view);

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public abstract int mo2355IiL();

    public int Lil() {
        if (Integer.MIN_VALUE == this.f4259ILil) {
            return 0;
        }
        return mo2353ILl() - this.f4259ILil;
    }

    public abstract int LlLI1(View view);

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public abstract int mo2356Ll1();

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public abstract int mo2357L11I();

    public void iIi1() {
        this.f4259ILil = mo2353ILl();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public abstract int mo2358iILLL1(View view);

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public abstract int mo2359lIiI();

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public abstract void mo2360lIlii(int i);

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public abstract int mo2361llL1ii(View view);

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public abstract int mo2362lLi1LL(View view);

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public abstract int mo2363il();

    public ILL(RecyclerView.LlLI1 llLI1) {
        this.f4259ILil = Integer.MIN_VALUE;
        this.f4257I1I = new Rect();
        this.f4258IL1Iii = llLI1;
    }
}
