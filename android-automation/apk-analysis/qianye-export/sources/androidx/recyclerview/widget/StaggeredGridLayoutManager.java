package androidx.recyclerview.widget;

import ILil.Lil.p037IL.C0639ILl;
import ILil.Lil.p037IL.ILL;
import ILil.Lil.p037IL.IiL;
import ILil.Lil.p037IL.iILLL1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LlLI1 implements RecyclerView.l.ILil {
    public int[] I11L;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ILL f5107I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I[] f5109ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f5110Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ILL f2712IL;
    public boolean Lil;
    public boolean LlLI1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final iILLL1 f2716iILLL1;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f2718lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public SavedState f2719llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2720lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public BitSet f2721il;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f5108IL1Iii = -1;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f2713IiL = false;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f2715L11I = false;
    public int ILL = -1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2714Ll1 = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public LazySpanLookup f2717lIiI = new LazySpanLookup();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f2711ILl = 2;
    public final Rect iIi1 = new Rect();
    public final ILil iIlLiL = new ILil();
    public boolean I11li1 = false;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f2722lL = true;
    public final Runnable llliI = new IL1Iii();

    public class I1I {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final int f5114Ilil;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public ArrayList<View> f5112IL1Iii = new ArrayList<>();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5113ILil = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5111I1I = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2723IL = 0;

        public I1I(int i) {
            this.f5114Ilil = i;
        }

        public void I11li1(View view) {
            LayoutParams layoutParamsM3335ILl = m3335ILl(view);
            layoutParamsM3335ILl.f5120Ilil = this;
            this.f5112IL1Iii.add(0, view);
            this.f5113ILil = Integer.MIN_VALUE;
            if (this.f5112IL1Iii.size() == 1) {
                this.f5111I1I = Integer.MIN_VALUE;
            }
            if (layoutParamsM3335ILl.I1I() || layoutParamsM3335ILl.ILil()) {
                this.f2723IL += StaggeredGridLayoutManager.this.f5107I1I.Ilil(view);
            }
        }

        public void I1I() {
            LazySpanLookup.FullSpanItem fullSpanItemM3356lLi1LL;
            ArrayList<View> arrayList = this.f5112IL1Iii;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParamsM3335ILl = m3335ILl(view);
            this.f5111I1I = StaggeredGridLayoutManager.this.f5107I1I.mo2354IL(view);
            if (layoutParamsM3335ILl.f2728lLi1LL && (fullSpanItemM3356lLi1LL = StaggeredGridLayoutManager.this.f2717lIiI.m3356lLi1LL(layoutParamsM3335ILl.IL1Iii())) != null && fullSpanItemM3356lLi1LL.f5123I1I == 1) {
                this.f5111I1I += fullSpanItemM3356lLi1LL.IL1Iii(this.f5114Ilil);
            }
        }

        public void IL1Iii(View view) {
            LayoutParams layoutParamsM3335ILl = m3335ILl(view);
            layoutParamsM3335ILl.f5120Ilil = this;
            this.f5112IL1Iii.add(view);
            this.f5111I1I = Integer.MIN_VALUE;
            if (this.f5112IL1Iii.size() == 1) {
                this.f5113ILil = Integer.MIN_VALUE;
            }
            if (layoutParamsM3335ILl.I1I() || layoutParamsM3335ILl.ILil()) {
                this.f2723IL += StaggeredGridLayoutManager.this.f5107I1I.Ilil(view);
            }
        }

        public int ILL() {
            int i = this.f5111I1I;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            I1I();
            return this.f5111I1I;
        }

        public void ILil(boolean z, int i) {
            int iM3338Ll1 = z ? m3338Ll1(Integer.MIN_VALUE) : LlLI1(Integer.MIN_VALUE);
            Ilil();
            if (iM3338Ll1 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iM3338Ll1 >= StaggeredGridLayoutManager.this.f5107I1I.mo2357L11I()) {
                if (z || iM3338Ll1 <= StaggeredGridLayoutManager.this.f5107I1I.mo2359lIiI()) {
                    if (i != Integer.MIN_VALUE) {
                        iM3338Ll1 += i;
                    }
                    this.f5111I1I = iM3338Ll1;
                    this.f5113ILil = iM3338Ll1;
                }
            }
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public LayoutParams m3335ILl(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public void Ilil() {
            this.f5112IL1Iii.clear();
            m3343llL1ii();
            this.f2723IL = 0;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3336IL() {
            LazySpanLookup.FullSpanItem fullSpanItemM3356lLi1LL;
            View view = this.f5112IL1Iii.get(0);
            LayoutParams layoutParamsM3335ILl = m3335ILl(view);
            this.f5113ILil = StaggeredGridLayoutManager.this.f5107I1I.mo2358iILLL1(view);
            if (layoutParamsM3335ILl.f2728lLi1LL && (fullSpanItemM3356lLi1LL = StaggeredGridLayoutManager.this.f2717lIiI.m3356lLi1LL(layoutParamsM3335ILl.IL1Iii())) != null && fullSpanItemM3356lLi1LL.f5123I1I == -1) {
                this.f5113ILil -= fullSpanItemM3356lLi1LL.IL1Iii(this.f5114Ilil);
            }
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int m3337IiL(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iMo2359lIiI = StaggeredGridLayoutManager.this.f5107I1I.mo2359lIiI();
            int iMo2357L11I = StaggeredGridLayoutManager.this.f5107I1I.mo2357L11I();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f5112IL1Iii.get(i);
                int iMo2358iILLL1 = StaggeredGridLayoutManager.this.f5107I1I.mo2358iILLL1(view);
                int iMo2354IL = StaggeredGridLayoutManager.this.f5107I1I.mo2354IL(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iMo2358iILLL1 >= iMo2357L11I : iMo2358iILLL1 > iMo2357L11I;
                if (!z3 ? iMo2354IL > iMo2359lIiI : iMo2354IL >= iMo2359lIiI) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iMo2358iILLL1 >= iMo2359lIiI && iMo2354IL <= iMo2357L11I) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (iMo2358iILLL1 < iMo2359lIiI || iMo2354IL > iMo2357L11I) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        public int Lil() {
            int i = this.f5113ILil;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            m3336IL();
            return this.f5113ILil;
        }

        public int LlLI1(int i) {
            int i2 = this.f5113ILil;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f5112IL1Iii.size() == 0) {
                return i;
            }
            m3336IL();
            return this.f5113ILil;
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public int m3338Ll1(int i) {
            int i2 = this.f5111I1I;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f5112IL1Iii.size() == 0) {
                return i;
            }
            I1I();
            return this.f5111I1I;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int m3339L11I(int i, int i2, boolean z) {
            return m3337IiL(i, i2, false, false, z);
        }

        public void iIi1() {
            int size = this.f5112IL1Iii.size();
            View viewRemove = this.f5112IL1Iii.remove(size - 1);
            LayoutParams layoutParamsM3335ILl = m3335ILl(viewRemove);
            layoutParamsM3335ILl.f5120Ilil = null;
            if (layoutParamsM3335ILl.I1I() || layoutParamsM3335ILl.ILil()) {
                this.f2723IL -= StaggeredGridLayoutManager.this.f5107I1I.Ilil(viewRemove);
            }
            if (size == 1) {
                this.f5113ILil = Integer.MIN_VALUE;
            }
            this.f5111I1I = Integer.MIN_VALUE;
        }

        public void iIlLiL() {
            View viewRemove = this.f5112IL1Iii.remove(0);
            LayoutParams layoutParamsM3335ILl = m3335ILl(viewRemove);
            layoutParamsM3335ILl.f5120Ilil = null;
            if (this.f5112IL1Iii.size() == 0) {
                this.f5111I1I = Integer.MIN_VALUE;
            }
            if (layoutParamsM3335ILl.I1I() || layoutParamsM3335ILl.ILil()) {
                this.f2723IL -= StaggeredGridLayoutManager.this.f5107I1I.Ilil(viewRemove);
            }
            this.f5113ILil = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int m3340iILLL1() {
            return StaggeredGridLayoutManager.this.f2713IiL ? m3339L11I(0, this.f5112IL1Iii.size(), true) : m3339L11I(this.f5112IL1Iii.size() - 1, -1, true);
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public View m3341lIiI(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f5112IL1Iii.size() - 1;
                while (size >= 0) {
                    View view2 = this.f5112IL1Iii.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f2713IiL && staggeredGridLayoutManager.getPosition(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f2713IiL && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f5112IL1Iii.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f5112IL1Iii.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f2713IiL && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f2713IiL && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public void m3342lIlii(int i) {
            int i2 = this.f5113ILil;
            if (i2 != Integer.MIN_VALUE) {
                this.f5113ILil = i2 + i;
            }
            int i3 = this.f5111I1I;
            if (i3 != Integer.MIN_VALUE) {
                this.f5111I1I = i3 + i;
            }
        }

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public void m3343llL1ii() {
            this.f5113ILil = Integer.MIN_VALUE;
            this.f5111I1I = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int m3344lLi1LL() {
            return StaggeredGridLayoutManager.this.f2713IiL ? m3339L11I(this.f5112IL1Iii.size() - 1, -1, true) : m3339L11I(0, this.f5112IL1Iii.size(), true);
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int m3345il() {
            return this.f2723IL;
        }

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public void m3346lL(int i) {
            this.f5113ILil = i;
            this.f5111I1I = i;
        }
    }

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m3318iILLL1();
        }
    }

    public class ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f5116I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f5117IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5118ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f5119Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2725IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int[] f2727lLi1LL;

        public ILil() {
            I1I();
        }

        public void I1I() {
            this.f5117IL1Iii = -1;
            this.f5118ILil = Integer.MIN_VALUE;
            this.f5116I1I = false;
            this.f2725IL = false;
            this.f5119Ilil = false;
            int[] iArr = this.f2727lLi1LL;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void IL1Iii() {
            this.f5118ILil = this.f5116I1I ? StaggeredGridLayoutManager.this.f5107I1I.mo2357L11I() : StaggeredGridLayoutManager.this.f5107I1I.mo2359lIiI();
        }

        public void ILil(int i) {
            if (this.f5116I1I) {
                this.f5118ILil = StaggeredGridLayoutManager.this.f5107I1I.mo2357L11I() - i;
            } else {
                this.f5118ILil = StaggeredGridLayoutManager.this.f5107I1I.mo2359lIiI() + i;
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m3347IL(I1I[] i1iArr) {
            int length = i1iArr.length;
            int[] iArr = this.f2727lLi1LL;
            if (iArr == null || iArr.length < length) {
                this.f2727lLi1LL = new int[StaggeredGridLayoutManager.this.f5109ILil.length];
            }
            for (int i = 0; i < length; i++) {
                this.f2727lLi1LL[i] = i1iArr[i].LlLI1(Integer.MIN_VALUE);
            }
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public I1I f5120Ilil;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2728lLi1LL;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int Ilil() {
            I1I i1i = this.f5120Ilil;
            if (i1i == null) {
                return -1;
            }
            return i1i.f5114Ilil;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean m3348lLi1LL() {
            return this.f2728lLi1LL;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5126I1I;
        public boolean ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5127ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int[] f5128Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f2730IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public List<LazySpanLookup.FullSpanItem> f2731IiL;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public boolean f2732L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int[] f2733iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f2734lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean f2735il;

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

        public void IL1Iii() {
            this.f5128Ilil = null;
            this.f2730IL = 0;
            this.f5127ILil = -1;
            this.f5126I1I = -1;
        }

        public void ILil() {
            this.f5128Ilil = null;
            this.f2730IL = 0;
            this.f2734lLi1LL = 0;
            this.f2733iILLL1 = null;
            this.f2731IiL = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5127ILil);
            parcel.writeInt(this.f5126I1I);
            parcel.writeInt(this.f2730IL);
            if (this.f2730IL > 0) {
                parcel.writeIntArray(this.f5128Ilil);
            }
            parcel.writeInt(this.f2734lLi1LL);
            if (this.f2734lLi1LL > 0) {
                parcel.writeIntArray(this.f2733iILLL1);
            }
            parcel.writeInt(this.f2732L11I ? 1 : 0);
            parcel.writeInt(this.f2735il ? 1 : 0);
            parcel.writeInt(this.ILL ? 1 : 0);
            parcel.writeList(this.f2731IiL);
        }

        public SavedState(Parcel parcel) {
            this.f5127ILil = parcel.readInt();
            this.f5126I1I = parcel.readInt();
            int i = parcel.readInt();
            this.f2730IL = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.f5128Ilil = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.f2734lLi1LL = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.f2733iILLL1 = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f2732L11I = parcel.readInt() == 1;
            this.f2735il = parcel.readInt() == 1;
            this.ILL = parcel.readInt() == 1;
            this.f2731IiL = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f2730IL = savedState.f2730IL;
            this.f5127ILil = savedState.f5127ILil;
            this.f5126I1I = savedState.f5126I1I;
            this.f5128Ilil = savedState.f5128Ilil;
            this.f2734lLi1LL = savedState.f2734lLi1LL;
            this.f2733iILLL1 = savedState.f2733iILLL1;
            this.f2732L11I = savedState.f2732L11I;
            this.f2735il = savedState.f2735il;
            this.ILL = savedState.ILL;
            this.f2731IiL = savedState.f2731IiL;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LlLI1.IL properties = RecyclerView.LlLI1.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f5080IL1Iii);
        m3309L11(properties.f5081ILil);
        setReverseLayout(properties.f5079I1I);
        this.f2716iILLL1 = new iILLL1();
        ILL();
    }

    public final int I11L(int i) {
        int iLlLI1 = this.f5109ILil[0].LlLI1(i);
        for (int i2 = 1; i2 < this.f5108IL1Iii; i2++) {
            int iLlLI2 = this.f5109ILil[i2].LlLI1(i);
            if (iLlLI2 > iLlLI1) {
                iLlLI1 = iLlLI2;
            }
        }
        return iLlLI1;
    }

    public int I11li1() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public boolean I1I() {
        int iM3338Ll1 = this.f5109ILil[0].m3338Ll1(Integer.MIN_VALUE);
        for (int i = 1; i < this.f5108IL1Iii; i++) {
            if (this.f5109ILil[i].m3338Ll1(Integer.MIN_VALUE) != iM3338Ll1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public void m3302I1L11L(int i) {
        this.f2720lLi1LL = i / this.f5108IL1Iii;
        this.f2718lIlii = View.MeasureSpec.makeMeasureSpec(i, this.f2712IL.ILL());
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public final boolean m3303IIiI(RecyclerView.C1 c1, ILil iLil) {
        iLil.f5117IL1Iii = this.Lil ? m3324llL1ii(c1.ILil()) : m3321lIiI(c1.ILil());
        iLil.f5118ILil = Integer.MIN_VALUE;
        return true;
    }

    public final void IL1Iii(View view) {
        for (int i = this.f5108IL1Iii - 1; i >= 0; i--) {
            this.f5109ILil[i].IL1Iii(view);
        }
    }

    public final void ILL() {
        this.f5107I1I = ILL.ILil(this, this.f5110Ilil);
        this.f2712IL = ILL.ILil(this, 1 - this.f5110Ilil);
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public final void m3304ILLIi(I1I i1i, int i, int i2) {
        int iM3345il = i1i.m3345il();
        if (i == -1) {
            if (i1i.Lil() + iM3345il <= i2) {
                this.f2721il.set(i1i.f5114Ilil, false);
            }
        } else if (i1i.ILL() - iM3345il >= i2) {
            this.f2721il.set(i1i.f5114Ilil, false);
        }
    }

    public final void ILil(ILil iLil) {
        SavedState savedState = this.f2719llL1ii;
        int i = savedState.f2730IL;
        if (i > 0) {
            if (i == this.f5108IL1Iii) {
                for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
                    this.f5109ILil[i2].Ilil();
                    SavedState savedState2 = this.f2719llL1ii;
                    int iMo2357L11I = savedState2.f5128Ilil[i2];
                    if (iMo2357L11I != Integer.MIN_VALUE) {
                        iMo2357L11I += savedState2.f2735il ? this.f5107I1I.mo2357L11I() : this.f5107I1I.mo2359lIiI();
                    }
                    this.f5109ILil[i2].m3346lL(iMo2357L11I);
                }
            } else {
                savedState.ILil();
                SavedState savedState3 = this.f2719llL1ii;
                savedState3.f5127ILil = savedState3.f5126I1I;
            }
        }
        SavedState savedState4 = this.f2719llL1ii;
        this.LlLI1 = savedState4.ILL;
        setReverseLayout(savedState4.f2732L11I);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.f2719llL1ii;
        int i3 = savedState5.f5127ILil;
        if (i3 != -1) {
            this.ILL = i3;
            iLil.f5116I1I = savedState5.f2735il;
        } else {
            iLil.f5116I1I = this.f2715L11I;
        }
        if (savedState5.f2734lLi1LL > 1) {
            LazySpanLookup lazySpanLookup = this.f2717lIiI;
            lazySpanLookup.f5121IL1Iii = savedState5.f2733iILLL1;
            lazySpanLookup.f5122ILil = savedState5.f2731IiL;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public View m3305ILl(boolean z) {
        int iMo2359lIiI = this.f5107I1I.mo2359lIiI();
        int iMo2357L11I = this.f5107I1I.mo2357L11I();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iMo2358iILLL1 = this.f5107I1I.mo2358iILLL1(childAt);
            int iMo2354IL = this.f5107I1I.mo2354IL(childAt);
            if (iMo2354IL > iMo2359lIiI && iMo2358iILLL1 < iMo2357L11I) {
                if (iMo2354IL <= iMo2357L11I || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void Ilil(View view, LayoutParams layoutParams, iILLL1 iilll1) {
        if (iilll1.f4286Ilil == 1) {
            if (layoutParams.f2728lLi1LL) {
                IL1Iii(view);
                return;
            } else {
                layoutParams.f5120Ilil.IL1Iii(view);
                return;
            }
        }
        if (layoutParams.f2728lLi1LL) {
            m3314L1l(view);
        } else {
            layoutParams.f5120Ilil.I11li1(view);
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final void m3306IIi(RecyclerView.lL lLVar, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f5107I1I.mo2358iILLL1(childAt) < i || this.f5107I1I.mo2361llL1ii(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f2728lLi1LL) {
                for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
                    if (this.f5109ILil[i2].f5112IL1Iii.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f5108IL1Iii; i3++) {
                    this.f5109ILil[i3].iIi1();
                }
            } else if (layoutParams.f5120Ilil.f5112IL1Iii.size() == 1) {
                return;
            } else {
                layoutParams.f5120Ilil.iIi1();
            }
            removeAndRecycleView(childAt, lLVar);
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m3307IL() {
        int iLlLI1 = this.f5109ILil[0].LlLI1(Integer.MIN_VALUE);
        for (int i = 1; i < this.f5108IL1Iii; i++) {
            if (this.f5109ILil[i].LlLI1(Integer.MIN_VALUE) != iLlLI1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m3308IiL(I1I i1i) {
        if (this.f2715L11I) {
            if (i1i.ILL() < this.f5107I1I.mo2357L11I()) {
                ArrayList<View> arrayList = i1i.f5112IL1Iii;
                return !i1i.m3335ILl(arrayList.get(arrayList.size() - 1)).f2728lLi1LL;
            }
        } else if (i1i.Lil() > this.f5107I1I.mo2359lIiI()) {
            return !i1i.m3335ILl(i1i.f5112IL1Iii.get(0)).f2728lLi1LL;
        }
        return false;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public void m3309L11(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f5108IL1Iii) {
            LL1IL();
            this.f5108IL1Iii = i;
            this.f2721il = new BitSet(this.f5108IL1Iii);
            this.f5109ILil = new I1I[this.f5108IL1Iii];
            for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
                this.f5109ILil[i2] = new I1I(i2);
            }
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m3310L111(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.iIi1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.iIi1;
        int iM3327li11 = m3327li11(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.iIi1;
        int iM3327li12 = m3327li11(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z ? shouldReMeasureChild(view, iM3327li11, iM3327li12, layoutParams) : shouldMeasureChild(view, iM3327li11, iM3327li12, layoutParams)) {
            view.measure(iM3327li11, iM3327li12);
        }
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m3311LIll(RecyclerView.lL lLVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f5107I1I.mo2354IL(childAt) > i || this.f5107I1I.LlLI1(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f2728lLi1LL) {
                for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
                    if (this.f5109ILil[i2].f5112IL1Iii.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f5108IL1Iii; i3++) {
                    this.f5109ILil[i3].iIlLiL();
                }
            } else if (layoutParams.f5120Ilil.f5112IL1Iii.size() == 1) {
                return;
            } else {
                layoutParams.f5120Ilil.iIlLiL();
            }
            removeAndRecycleView(childAt, lLVar);
        }
    }

    public void LL1IL() {
        this.f2717lIiI.ILil();
        requestLayout();
    }

    public void LLL(RecyclerView.C1 c1, ILil iLil) {
        if (m3326lliiI1(c1, iLil) || m3303IIiI(c1, iLil)) {
            return;
        }
        iLil.IL1Iii();
        iLil.f5117IL1Iii = 0;
    }

    public View Lil(boolean z) {
        int iMo2359lIiI = this.f5107I1I.mo2359lIiI();
        int iMo2357L11I = this.f5107I1I.mo2357L11I();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int iMo2358iILLL1 = this.f5107I1I.mo2358iILLL1(childAt);
            if (this.f5107I1I.mo2354IL(childAt) > iMo2359lIiI && iMo2358iILLL1 < iMo2357L11I) {
                if (iMo2358iILLL1 >= iMo2359lIiI || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public final void m3312LlIl(int i, int i2) {
        for (int i3 = 0; i3 < this.f5108IL1Iii; i3++) {
            if (!this.f5109ILil[i3].f5112IL1Iii.isEmpty()) {
                m3304ILLIi(this.f5109ILil[i3], i, i2);
            }
        }
    }

    public int LlLI1() {
        View viewM3305ILl = this.f2715L11I ? m3305ILl(true) : Lil(true);
        if (viewM3305ILl == null) {
            return -1;
        }
        return getPosition(viewM3305ILl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final int m3313Ll1(RecyclerView.lL lLVar, iILLL1 iilll1, RecyclerView.C1 c1) {
        int i;
        int iM3330lL;
        I1I i1iM33331;
        int iIlil;
        int i2;
        int iIlil2;
        int iIlil3;
        ?? r9 = 0;
        this.f2721il.set(0, this.f5108IL1Iii, true);
        if (this.f2716iILLL1.f1769L11I) {
            i = iilll1.f4286Ilil == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i = iilll1.f4286Ilil == 1 ? iilll1.f1770iILLL1 + iilll1.f4285ILil : iilll1.f1771lLi1LL - iilll1.f4285ILil;
        }
        m3312LlIl(iilll1.f4286Ilil, i);
        int iMo2357L11I = this.f2715L11I ? this.f5107I1I.mo2357L11I() : this.f5107I1I.mo2359lIiI();
        boolean z = false;
        while (iilll1.IL1Iii(c1) && (this.f2716iILLL1.f1769L11I || !this.f2721il.isEmpty())) {
            View viewILil = iilll1.ILil(lLVar);
            LayoutParams layoutParams = (LayoutParams) viewILil.getLayoutParams();
            int iIL1Iii = layoutParams.IL1Iii();
            int iM3354iILLL1 = this.f2717lIiI.m3354iILLL1(iIL1Iii);
            boolean z2 = iM3354iILLL1 == -1;
            if (z2) {
                i1iM33331 = layoutParams.f2728lLi1LL ? this.f5109ILil[r9] : m33331(iilll1);
                this.f2717lIiI.m3349ILl(iIL1Iii, i1iM33331);
            } else {
                i1iM33331 = this.f5109ILil[iM3354iILLL1];
            }
            I1I i1i = i1iM33331;
            layoutParams.f5120Ilil = i1i;
            if (iilll1.f4286Ilil == 1) {
                addView(viewILil);
            } else {
                addView(viewILil, r9);
            }
            m3332LLlI1(viewILil, layoutParams, r9);
            if (iilll1.f4286Ilil == 1) {
                int iM3330lL2 = layoutParams.f2728lLi1LL ? m3330lL(iMo2357L11I) : i1i.m3338Ll1(iMo2357L11I);
                int iIlil4 = this.f5107I1I.Ilil(viewILil) + iM3330lL2;
                if (z2 && layoutParams.f2728lLi1LL) {
                    LazySpanLookup.FullSpanItem fullSpanItemM3315L11I = m3315L11I(iM3330lL2);
                    fullSpanItemM3315L11I.f5123I1I = -1;
                    fullSpanItemM3315L11I.f5124ILil = iIL1Iii;
                    this.f2717lIiI.IL1Iii(fullSpanItemM3315L11I);
                }
                i2 = iIlil4;
                iIlil = iM3330lL2;
            } else {
                int iM3331l = layoutParams.f2728lLi1LL ? m3331l(iMo2357L11I) : i1i.LlLI1(iMo2357L11I);
                iIlil = iM3331l - this.f5107I1I.Ilil(viewILil);
                if (z2 && layoutParams.f2728lLi1LL) {
                    LazySpanLookup.FullSpanItem fullSpanItemM3329il = m3329il(iM3331l);
                    fullSpanItemM3329il.f5123I1I = 1;
                    fullSpanItemM3329il.f5124ILil = iIL1Iii;
                    this.f2717lIiI.IL1Iii(fullSpanItemM3329il);
                }
                i2 = iM3331l;
            }
            if (layoutParams.f2728lLi1LL && iilll1.f1767IL == -1) {
                if (z2) {
                    this.I11li1 = true;
                } else {
                    if (!(iilll1.f4286Ilil == 1 ? I1I() : m3307IL())) {
                        LazySpanLookup.FullSpanItem fullSpanItemM3356lLi1LL = this.f2717lIiI.m3356lLi1LL(iIL1Iii);
                        if (fullSpanItemM3356lLi1LL != null) {
                            fullSpanItemM3356lLi1LL.f5125Ilil = true;
                        }
                        this.I11li1 = true;
                    }
                }
            }
            Ilil(viewILil, layoutParams, iilll1);
            if (isLayoutRTL() && this.f5110Ilil == 1) {
                int iMo2357L11I2 = layoutParams.f2728lLi1LL ? this.f2712IL.mo2357L11I() : this.f2712IL.mo2357L11I() - (((this.f5108IL1Iii - 1) - i1i.f5114Ilil) * this.f2720lLi1LL);
                iIlil3 = iMo2357L11I2;
                iIlil2 = iMo2357L11I2 - this.f2712IL.Ilil(viewILil);
            } else {
                int iMo2359lIiI = layoutParams.f2728lLi1LL ? this.f2712IL.mo2359lIiI() : (i1i.f5114Ilil * this.f2720lLi1LL) + this.f2712IL.mo2359lIiI();
                iIlil2 = iMo2359lIiI;
                iIlil3 = this.f2712IL.Ilil(viewILil) + iMo2359lIiI;
            }
            if (this.f5110Ilil == 1) {
                layoutDecoratedWithMargins(viewILil, iIlil2, iIlil, iIlil3, i2);
            } else {
                layoutDecoratedWithMargins(viewILil, iIlil, iIlil2, i2, iIlil3);
            }
            if (layoutParams.f2728lLi1LL) {
                m3312LlIl(this.f2716iILLL1.f4286Ilil, i);
            } else {
                m3304ILLIi(i1i, this.f2716iILLL1.f4286Ilil, i);
            }
            m3328iILLl(lLVar, this.f2716iILLL1);
            if (this.f2716iILLL1.f1768IiL && viewILil.hasFocusable()) {
                if (layoutParams.f2728lLi1LL) {
                    this.f2721il.clear();
                } else {
                    this.f2721il.set(i1i.f5114Ilil, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            m3328iILLl(lLVar, this.f2716iILLL1);
        }
        if (this.f2716iILLL1.f4286Ilil == -1) {
            iM3330lL = this.f5107I1I.mo2359lIiI() - m3331l(this.f5107I1I.mo2359lIiI());
        } else {
            iM3330lL = m3330lL(this.f5107I1I.mo2357L11I()) - this.f5107I1I.mo2357L11I();
        }
        if (iM3330lL > 0) {
            return Math.min(iilll1.f4285ILil, iM3330lL);
        }
        return 0;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public final void m3314L1l(View view) {
        for (int i = this.f5108IL1Iii - 1; i >= 0; i--) {
            this.f5109ILil[i].I11li1(view);
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final LazySpanLookup.FullSpanItem m3315L11I(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2729IL = new int[this.f5108IL1Iii];
        for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
            fullSpanItem.f2729IL[i2] = i - this.f5109ILil[i2].m3338Ll1(i);
        }
        return fullSpanItem;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m3316LlLLL(int i, int i2, int i3) {
        int i4;
        int i5;
        int iI11li1;
        int iI11li2 = this.f2715L11I ? I11li1() : iIlLiL();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            this.f2717lIiI.m3351IiL(i5);
            if (i3 != 1) {
                this.f2717lIiI.m3357il(i, i2);
            } else if (i3 != 2) {
                this.f2717lIiI.ILL(i, i2);
            } else if (i3 == 8) {
                this.f2717lIiI.ILL(i, 1);
                this.f2717lIiI.m3357il(i2, 1);
            }
            if (i4 <= iI11li2) {
                return;
            }
            if (this.f2715L11I) {
                iI11li1 = iIlLiL();
            } else {
                iI11li1 = I11li1();
            }
            if (i5 <= iI11li1) {
                requestLayout();
            }
        }
        i4 = i + i2;
        i5 = i;
        this.f2717lIiI.m3351IiL(i5);
        if (i3 != 1) {
            this.f2717lIiI.m3357il(i, i2);
        } else if (i3 != 2) {
            this.f2717lIiI.ILL(i, i2);
        } else if (i3 == 8) {
            this.f2717lIiI.ILL(i, 1);
            this.f2717lIiI.m3357il(i2, 1);
        }
        if (i4 <= iI11li2) {
            return;
        }
        if (this.f2715L11I) {
            iI11li1 = iIlLiL();
        } else {
            iI11li1 = I11li1();
        }
        if (i5 <= iI11li1) {
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f2719llL1ii == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean canScrollHorizontally() {
        return this.f5110Ilil == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean canScrollVertically() {
        return this.f5110Ilil == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.C1 c1, RecyclerView.LlLI1.I1I i1i) {
        int iM3338Ll1;
        int iLlLI1;
        if (this.f5110Ilil != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        m3320l1IIi1(i, c1);
        int[] iArr = this.I11L;
        if (iArr == null || iArr.length < this.f5108IL1Iii) {
            this.I11L = new int[this.f5108IL1Iii];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5108IL1Iii; i4++) {
            iILLL1 iilll1 = this.f2716iILLL1;
            if (iilll1.f1767IL == -1) {
                iM3338Ll1 = iilll1.f1771lLi1LL;
                iLlLI1 = this.f5109ILil[i4].LlLI1(iM3338Ll1);
            } else {
                iM3338Ll1 = this.f5109ILil[i4].m3338Ll1(iilll1.f1770iILLL1);
                iLlLI1 = this.f2716iILLL1.f1770iILLL1;
            }
            int i5 = iM3338Ll1 - iLlLI1;
            if (i5 >= 0) {
                this.I11L[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.I11L, 0, i3);
        for (int i6 = 0; i6 < i3 && this.f2716iILLL1.IL1Iii(c1); i6++) {
            i1i.IL1Iii(this.f2716iILLL1.f4283I1I, this.I11L[i6]);
            iILLL1 iilll2 = this.f2716iILLL1;
            iilll2.f4283I1I += iilll2.f1767IL;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollExtent(RecyclerView.C1 c1) {
        return computeScrollExtent(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollOffset(RecyclerView.C1 c1) {
        return computeScrollOffset(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeHorizontalScrollRange(RecyclerView.C1 c1) {
        return computeScrollRange(c1);
    }

    public final int computeScrollExtent(RecyclerView.C1 c1) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0639ILl.IL1Iii(c1, this.f5107I1I, Lil(!this.f2722lL), m3305ILl(!this.f2722lL), this, this.f2722lL);
    }

    public final int computeScrollOffset(RecyclerView.C1 c1) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0639ILl.ILil(c1, this.f5107I1I, Lil(!this.f2722lL), m3305ILl(!this.f2722lL), this, this.f2722lL, this.f2715L11I);
    }

    public final int computeScrollRange(RecyclerView.C1 c1) {
        if (getChildCount() == 0) {
            return 0;
        }
        return C0639ILl.I1I(c1, this.f5107I1I, Lil(!this.f2722lL), m3305ILl(!this.f2722lL), this, this.f2722lL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l.ILil
    public PointF computeScrollVectorForPosition(int i) {
        int iM3325lLi1LL = m3325lLi1LL(i);
        PointF pointF = new PointF();
        if (iM3325lLi1LL == 0) {
            return null;
        }
        if (this.f5110Ilil == 0) {
            pointF.x = iM3325lLi1LL;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM3325lLi1LL;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollExtent(RecyclerView.C1 c1) {
        return computeScrollExtent(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollOffset(RecyclerView.C1 c1) {
        return computeScrollOffset(c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int computeVerticalScrollRange(RecyclerView.C1 c1) {
        return computeScrollRange(c1);
    }

    public final int convertFocusDirectionToLayoutDirection(int i) {
        if (i == 1) {
            return (this.f5110Ilil != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.f5110Ilil != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i == 17) {
            return this.f5110Ilil == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.f5110Ilil == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.f5110Ilil == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f5110Ilil == 0 ? 1 : Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.f5110Ilil == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int getColumnCountForAccessibility(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return this.f5110Ilil == 1 ? this.f5108IL1Iii : super.getColumnCountForAccessibility(lLVar, c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int getRowCountForAccessibility(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return this.f5110Ilil == 0 ? this.f5108IL1Iii : super.getRowCountForAccessibility(lLVar, c1);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public final void m3317iI1iI(int i, RecyclerView.C1 c1) {
        int iMo2353ILl;
        int iMo2353ILl2;
        int iI1I;
        iILLL1 iilll1 = this.f2716iILLL1;
        boolean z = false;
        iilll1.f4285ILil = 0;
        iilll1.f4283I1I = i;
        if (isSmoothScrolling() && (iI1I = c1.I1I()) != -1) {
            if (this.f2715L11I == (iI1I < i)) {
                iMo2353ILl = this.f5107I1I.mo2353ILl();
            } else {
                iMo2353ILl2 = this.f5107I1I.mo2353ILl();
                iMo2353ILl = 0;
            }
            if (getClipToPadding()) {
                this.f2716iILLL1.f1771lLi1LL = this.f5107I1I.mo2359lIiI() - iMo2353ILl2;
                this.f2716iILLL1.f1770iILLL1 = this.f5107I1I.mo2357L11I() + iMo2353ILl;
            } else {
                this.f2716iILLL1.f1770iILLL1 = this.f5107I1I.mo2355IiL() + iMo2353ILl;
                this.f2716iILLL1.f1771lLi1LL = -iMo2353ILl2;
            }
            iILLL1 iilll2 = this.f2716iILLL1;
            iilll2.f1768IiL = false;
            iilll2.f4284IL1Iii = true;
            if (this.f5107I1I.ILL() == 0 && this.f5107I1I.mo2355IiL() == 0) {
                z = true;
            }
            iilll2.f1769L11I = z;
        }
        iMo2353ILl = 0;
        iMo2353ILl2 = 0;
        if (getClipToPadding()) {
            this.f2716iILLL1.f1771lLi1LL = this.f5107I1I.mo2359lIiI() - iMo2353ILl2;
            this.f2716iILLL1.f1770iILLL1 = this.f5107I1I.mo2357L11I() + iMo2353ILl;
        } else {
            this.f2716iILLL1.f1770iILLL1 = this.f5107I1I.mo2355IiL() + iMo2353ILl;
            this.f2716iILLL1.f1771lLi1LL = -iMo2353ILl2;
        }
        iILLL1 iilll3 = this.f2716iILLL1;
        iilll3.f1768IiL = false;
        iilll3.f4284IL1Iii = true;
        if (this.f5107I1I.ILL() == 0) {
            z = true;
        }
        iilll3.f1769L11I = z;
    }

    public final void iIi1(RecyclerView.lL lLVar, RecyclerView.C1 c1, boolean z) {
        int iMo2359lIiI;
        int iM3331l = m3331l(Integer.MAX_VALUE);
        if (iM3331l != Integer.MAX_VALUE && (iMo2359lIiI = iM3331l - this.f5107I1I.mo2359lIiI()) > 0) {
            int iScrollBy = iMo2359lIiI - scrollBy(iMo2359lIiI, lLVar, c1);
            if (!z || iScrollBy <= 0) {
                return;
            }
            this.f5107I1I.mo2360lIlii(-iScrollBy);
        }
    }

    public int iIlLiL() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m3318iILLL1() {
        int iIIlLiL;
        int iI11li1;
        if (getChildCount() == 0 || this.f2711ILl == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f2715L11I) {
            iIIlLiL = I11li1();
            iI11li1 = iIlLiL();
        } else {
            iIIlLiL = iIlLiL();
            iI11li1 = I11li1();
        }
        if (iIIlLiL == 0 && m3322lIII() != null) {
            this.f2717lIiI.ILil();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.I11li1) {
            return false;
        }
        int i = this.f2715L11I ? -1 : 1;
        int i2 = iI11li1 + 1;
        LazySpanLookup.FullSpanItem fullSpanItemIlil = this.f2717lIiI.Ilil(iIIlLiL, i2, i, true);
        if (fullSpanItemIlil == null) {
            this.I11li1 = false;
            this.f2717lIiI.m3350IL(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemIlil2 = this.f2717lIiI.Ilil(iIIlLiL, fullSpanItemIlil.f5124ILil, i * (-1), true);
        if (fullSpanItemIlil2 == null) {
            this.f2717lIiI.m3350IL(fullSpanItemIlil.f5124ILil);
        } else {
            this.f2717lIiI.m3350IL(fullSpanItemIlil2.f5124ILil + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m3319ill() {
        if (this.f2712IL.ILL() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float fIlil = this.f2712IL.Ilil(childAt);
            if (fIlil >= fMax) {
                if (((LayoutParams) childAt.getLayoutParams()).m3348lLi1LL()) {
                    fIlil = (fIlil * 1.0f) / this.f5108IL1Iii;
                }
                fMax = Math.max(fMax, fIlil);
            }
        }
        int i2 = this.f2720lLi1LL;
        int iRound = Math.round(fMax * this.f5108IL1Iii);
        if (this.f2712IL.ILL() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f2712IL.mo2353ILl());
        }
        m3302I1L11L(iRound);
        if (this.f2720lLi1LL == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f2728lLi1LL) {
                if (isLayoutRTL() && this.f5110Ilil == 1) {
                    int i4 = this.f5108IL1Iii;
                    int i5 = layoutParams.f5120Ilil.f5114Ilil;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.f2720lLi1LL) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.f5120Ilil.f5114Ilil;
                    int i7 = this.f2720lLi1LL * i6;
                    int i8 = i6 * i2;
                    if (this.f5110Ilil == 1) {
                        childAt2.offsetLeftAndRight(i7 - i8);
                    } else {
                        childAt2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean isAutoMeasureEnabled() {
        return this.f2711ILl != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m3320l1IIi1(int i, RecyclerView.C1 c1) {
        int iIIlLiL;
        int i2;
        if (i > 0) {
            iIIlLiL = I11li1();
            i2 = 1;
        } else {
            iIIlLiL = iIlLiL();
            i2 = -1;
        }
        this.f2716iILLL1.f4284IL1Iii = true;
        m3317iI1iI(iIIlLiL, c1);
        m3334(i2);
        iILLL1 iilll1 = this.f2716iILLL1;
        iilll1.f4283I1I = iIIlLiL + iilll1.f1767IL;
        iilll1.f4285ILil = Math.abs(i);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final int m3321lIiI(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public View m3322lIII() {
        int i;
        int i2;
        boolean z;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.f5108IL1Iii);
        bitSet.set(0, this.f5108IL1Iii, true);
        byte b = (this.f5110Ilil == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.f2715L11I) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i3 = childCount < i ? 1 : -1;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.f5120Ilil.f5114Ilil)) {
                if (m3308IiL(layoutParams.f5120Ilil)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.f5120Ilil.f5114Ilil);
            }
            if (!layoutParams.f2728lLi1LL && (i2 = childCount + i3) != i) {
                View childAt2 = getChildAt(i2);
                if (this.f2715L11I) {
                    int iMo2354IL = this.f5107I1I.mo2354IL(childAt);
                    int iMo2354IL2 = this.f5107I1I.mo2354IL(childAt2);
                    if (iMo2354IL < iMo2354IL2) {
                        return childAt;
                    }
                    if (iMo2354IL == iMo2354IL2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int iMo2358iILLL1 = this.f5107I1I.mo2358iILLL1(childAt);
                    int iMo2358iILLL2 = this.f5107I1I.mo2358iILLL1(childAt2);
                    if (iMo2358iILLL1 > iMo2358iILLL2) {
                        return childAt;
                    }
                    if (iMo2358iILLL1 == iMo2358iILLL2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if ((layoutParams.f5120Ilil.f5114Ilil - ((LayoutParams) childAt2.getLayoutParams()).f5120Ilil.f5114Ilil < 0) != (b < 0)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            childCount += i3;
        }
        return null;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m3323lIlii(RecyclerView.lL lLVar, RecyclerView.C1 c1, boolean z) {
        int iMo2357L11I;
        int iM3330lL = m3330lL(Integer.MIN_VALUE);
        if (iM3330lL != Integer.MIN_VALUE && (iMo2357L11I = this.f5107I1I.mo2357L11I() - iM3330lL) > 0) {
            int i = iMo2357L11I - (-scrollBy(-iMo2357L11I, lLVar, c1));
            if (!z || i <= 0) {
                return;
            }
            this.f5107I1I.mo2360lIlii(i);
        }
    }

    public final boolean llI(int i) {
        if (this.f5110Ilil == 0) {
            return (i == -1) != this.f2715L11I;
        }
        return ((i == -1) == this.f2715L11I) == isLayoutRTL();
    }

    public final int llliI(int i) {
        int iM3338Ll1 = this.f5109ILil[0].m3338Ll1(i);
        for (int i2 = 1; i2 < this.f5108IL1Iii; i2++) {
            int iM3338Ll2 = this.f5109ILil[i2].m3338Ll1(i);
            if (iM3338Ll2 < iM3338Ll1) {
                iM3338Ll1 = iM3338Ll2;
            }
        }
        return iM3338Ll1;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final int m3324llL1ii(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int m3325lLi1LL(int i) {
        if (getChildCount() == 0) {
            return this.f2715L11I ? 1 : -1;
        }
        return (i < iIlLiL()) != this.f2715L11I ? -1 : 1;
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public boolean m3326lliiI1(RecyclerView.C1 c1, ILil iLil) {
        int i;
        if (!c1.Ilil() && (i = this.ILL) != -1) {
            if (i >= 0 && i < c1.ILil()) {
                SavedState savedState = this.f2719llL1ii;
                if (savedState == null || savedState.f5127ILil == -1 || savedState.f2730IL < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.ILL);
                    if (viewFindViewByPosition != null) {
                        iLil.f5117IL1Iii = this.f2715L11I ? I11li1() : iIlLiL();
                        if (this.f2714Ll1 != Integer.MIN_VALUE) {
                            if (iLil.f5116I1I) {
                                iLil.f5118ILil = (this.f5107I1I.mo2357L11I() - this.f2714Ll1) - this.f5107I1I.mo2354IL(viewFindViewByPosition);
                            } else {
                                iLil.f5118ILil = (this.f5107I1I.mo2359lIiI() + this.f2714Ll1) - this.f5107I1I.mo2358iILLL1(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.f5107I1I.Ilil(viewFindViewByPosition) > this.f5107I1I.mo2353ILl()) {
                            iLil.f5118ILil = iLil.f5116I1I ? this.f5107I1I.mo2357L11I() : this.f5107I1I.mo2359lIiI();
                            return true;
                        }
                        int iMo2358iILLL1 = this.f5107I1I.mo2358iILLL1(viewFindViewByPosition) - this.f5107I1I.mo2359lIiI();
                        if (iMo2358iILLL1 < 0) {
                            iLil.f5118ILil = -iMo2358iILLL1;
                            return true;
                        }
                        int iMo2357L11I = this.f5107I1I.mo2357L11I() - this.f5107I1I.mo2354IL(viewFindViewByPosition);
                        if (iMo2357L11I < 0) {
                            iLil.f5118ILil = iMo2357L11I;
                            return true;
                        }
                        iLil.f5118ILil = Integer.MIN_VALUE;
                    } else {
                        int i2 = this.ILL;
                        iLil.f5117IL1Iii = i2;
                        int i3 = this.f2714Ll1;
                        if (i3 == Integer.MIN_VALUE) {
                            iLil.f5116I1I = m3325lLi1LL(i2) == 1;
                            iLil.IL1Iii();
                        } else {
                            iLil.ILil(i3);
                        }
                        iLil.f2725IL = true;
                    }
                } else {
                    iLil.f5118ILil = Integer.MIN_VALUE;
                    iLil.f5117IL1Iii = this.ILL;
                }
                return true;
            }
            this.ILL = -1;
            this.f2714Ll1 = Integer.MIN_VALUE;
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final int m3327li11(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
            this.f5109ILil[i2].m3342lIlii(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
            this.f5109ILil[i2].m3342lIlii(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.lL lLVar) {
        super.onDetachedFromWindow(recyclerView, lLVar);
        removeCallbacks(this.llliI);
        for (int i = 0; i < this.f5108IL1Iii; i++) {
            this.f5109ILil[i].Ilil();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public View onFocusSearchFailed(View view, int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        View viewFindContainingItemView;
        View viewM3341lIiI;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        boolean z = layoutParams.f2728lLi1LL;
        I1I i1i = layoutParams.f5120Ilil;
        int iI11li1 = iConvertFocusDirectionToLayoutDirection == 1 ? I11li1() : iIlLiL();
        m3317iI1iI(iI11li1, c1);
        m3334(iConvertFocusDirectionToLayoutDirection);
        iILLL1 iilll1 = this.f2716iILLL1;
        iilll1.f4283I1I = iilll1.f1767IL + iI11li1;
        iilll1.f4285ILil = (int) (this.f5107I1I.mo2353ILl() * 0.33333334f);
        iILLL1 iilll2 = this.f2716iILLL1;
        iilll2.f1768IiL = true;
        iilll2.f4284IL1Iii = false;
        m3313Ll1(lLVar, iilll2, c1);
        this.Lil = this.f2715L11I;
        if (!z && (viewM3341lIiI = i1i.m3341lIiI(iI11li1, iConvertFocusDirectionToLayoutDirection)) != null && viewM3341lIiI != viewFindContainingItemView) {
            return viewM3341lIiI;
        }
        if (llI(iConvertFocusDirectionToLayoutDirection)) {
            for (int i2 = this.f5108IL1Iii - 1; i2 >= 0; i2--) {
                View viewM3341lIiI2 = this.f5109ILil[i2].m3341lIiI(iI11li1, iConvertFocusDirectionToLayoutDirection);
                if (viewM3341lIiI2 != null && viewM3341lIiI2 != viewFindContainingItemView) {
                    return viewM3341lIiI2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f5108IL1Iii; i3++) {
                View viewM3341lIiI3 = this.f5109ILil[i3].m3341lIiI(iI11li1, iConvertFocusDirectionToLayoutDirection);
                if (viewM3341lIiI3 != null && viewM3341lIiI3 != viewFindContainingItemView) {
                    return viewM3341lIiI3;
                }
            }
        }
        boolean z2 = (this.f2713IiL ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View viewFindViewByPosition = findViewByPosition(z2 ? i1i.m3344lLi1LL() : i1i.m3340iILLL1());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (llI(iConvertFocusDirectionToLayoutDirection)) {
            for (int i4 = this.f5108IL1Iii - 1; i4 >= 0; i4--) {
                if (i4 != i1i.f5114Ilil) {
                    View viewFindViewByPosition2 = findViewByPosition(z2 ? this.f5109ILil[i4].m3344lLi1LL() : this.f5109ILil[i4].m3340iILLL1());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f5108IL1Iii; i5++) {
                View viewFindViewByPosition3 = findViewByPosition(z2 ? this.f5109ILil[i5].m3344lLi1LL() : this.f5109ILil[i5].m3340iILLL1());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewLil = Lil(false);
            View viewM3305ILl = m3305ILl(false);
            if (viewLil == null || viewM3305ILl == null) {
                return;
            }
            int position = getPosition(viewLil);
            int position2 = getPosition(viewM3305ILl);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.lL lLVar, RecyclerView.C1 c1, View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, i1i);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f5110Ilil == 0) {
            i1i.m62I(ILil.p028IiL.p029ILl.LL1IL.I1I.C0564I1I.IL1Iii(layoutParams2.Ilil(), layoutParams2.f2728lLi1LL ? this.f5108IL1Iii : 1, -1, -1, false, false));
        } else {
            i1i.m62I(ILil.p028IiL.p029ILl.LL1IL.I1I.C0564I1I.IL1Iii(-1, -1, layoutParams2.Ilil(), layoutParams2.f2728lLi1LL ? this.f5108IL1Iii : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m3316LlLLL(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f2717lIiI.ILil();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m3316LlLLL(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m3316LlLLL(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3316LlLLL(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onLayoutChildren(RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        m122(lLVar, c1, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onLayoutCompleted(RecyclerView.C1 c1) {
        super.onLayoutCompleted(c1);
        this.ILL = -1;
        this.f2714Ll1 = Integer.MIN_VALUE;
        this.f2719llL1ii = null;
        this.iIlLiL.I1I();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2719llL1ii = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public Parcelable onSaveInstanceState() {
        int iLlLI1;
        int iMo2359lIiI;
        int[] iArr;
        if (this.f2719llL1ii != null) {
            return new SavedState(this.f2719llL1ii);
        }
        SavedState savedState = new SavedState();
        savedState.f2732L11I = this.f2713IiL;
        savedState.f2735il = this.Lil;
        savedState.ILL = this.LlLI1;
        LazySpanLookup lazySpanLookup = this.f2717lIiI;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f5121IL1Iii) == null) {
            savedState.f2734lLi1LL = 0;
        } else {
            savedState.f2733iILLL1 = iArr;
            savedState.f2734lLi1LL = iArr.length;
            savedState.f2731IiL = lazySpanLookup.f5122ILil;
        }
        if (getChildCount() > 0) {
            savedState.f5127ILil = this.Lil ? I11li1() : iIlLiL();
            savedState.f5126I1I = LlLI1();
            int i = this.f5108IL1Iii;
            savedState.f2730IL = i;
            savedState.f5128Ilil = new int[i];
            for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
                if (this.Lil) {
                    iLlLI1 = this.f5109ILil[i2].m3338Ll1(Integer.MIN_VALUE);
                    if (iLlLI1 != Integer.MIN_VALUE) {
                        iMo2359lIiI = this.f5107I1I.mo2357L11I();
                        iLlLI1 -= iMo2359lIiI;
                    }
                } else {
                    iLlLI1 = this.f5109ILil[i2].LlLI1(Integer.MIN_VALUE);
                    if (iLlLI1 != Integer.MIN_VALUE) {
                        iMo2359lIiI = this.f5107I1I.mo2359lIiI();
                        iLlLI1 -= iMo2359lIiI;
                    }
                }
                savedState.f5128Ilil[i2] = iLlLI1;
            }
        } else {
            savedState.f5127ILil = -1;
            savedState.f5126I1I = -1;
            savedState.f2730IL = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m3318iILLL1();
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f5110Ilil == 1 || !isLayoutRTL()) {
            this.f2715L11I = this.f2713IiL;
        } else {
            this.f2715L11I = !this.f2713IiL;
        }
    }

    public int scrollBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m3320l1IIi1(i, c1);
        int iM3313Ll1 = m3313Ll1(lLVar, this.f2716iILLL1, c1);
        if (this.f2716iILLL1.f4285ILil >= iM3313Ll1) {
            i = i < 0 ? -iM3313Ll1 : iM3313Ll1;
        }
        this.f5107I1I.mo2360lIlii(-i);
        this.Lil = this.f2715L11I;
        iILLL1 iilll1 = this.f2716iILLL1;
        iilll1.f4285ILil = 0;
        m3328iILLl(lLVar, iilll1);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int scrollHorizontallyBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return scrollBy(i, lLVar, c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void scrollToPosition(int i) {
        SavedState savedState = this.f2719llL1ii;
        if (savedState != null && savedState.f5127ILil != i) {
            savedState.IL1Iii();
        }
        this.ILL = i;
        this.f2714Ll1 = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public int scrollVerticallyBy(int i, RecyclerView.lL lLVar, RecyclerView.C1 c1) {
        return scrollBy(i, lLVar, c1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f5110Ilil == 1) {
            iChooseSize2 = RecyclerView.LlLI1.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = RecyclerView.LlLI1.chooseSize(i, (this.f2720lLi1LL * this.f5108IL1Iii) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.LlLI1.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = RecyclerView.LlLI1.chooseSize(i2, (this.f2720lLi1LL * this.f5108IL1Iii) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.f5110Ilil) {
            return;
        }
        this.f5110Ilil = i;
        ILL ill = this.f5107I1I;
        this.f5107I1I = this.f2712IL;
        this.f2712IL = ill;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f2719llL1ii;
        if (savedState != null && savedState.f2732L11I != z) {
            savedState.f2732L11I = z;
        }
        this.f2713IiL = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C1 c1, int i) {
        IiL iiL = new IiL(recyclerView.getContext());
        iiL.setTargetPosition(i);
        startSmoothScroll(iiL);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public boolean supportsPredictiveItemAnimations() {
        return this.f2719llL1ii == null;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final void m3328iILLl(RecyclerView.lL lLVar, iILLL1 iilll1) {
        int iMin;
        if (!iilll1.f4284IL1Iii || iilll1.f1769L11I) {
            return;
        }
        if (iilll1.f4285ILil == 0) {
            if (iilll1.f4286Ilil == -1) {
                m3306IIi(lLVar, iilll1.f1770iILLL1);
                return;
            } else {
                m3311LIll(lLVar, iilll1.f1771lLi1LL);
                return;
            }
        }
        if (iilll1.f4286Ilil == -1) {
            int i = iilll1.f1771lLi1LL;
            int iI11L = i - I11L(i);
            m3306IIi(lLVar, iI11L < 0 ? iilll1.f1770iILLL1 : iilll1.f1770iILLL1 - Math.min(iI11L, iilll1.f4285ILil));
        } else {
            int iLlliI = llliI(iilll1.f1770iILLL1) - iilll1.f1770iILLL1;
            if (iLlliI < 0) {
                iMin = iilll1.f1771lLi1LL;
            } else {
                iMin = Math.min(iLlliI, iilll1.f4285ILil) + iilll1.f1771lLi1LL;
            }
            m3311LIll(lLVar, iMin);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final LazySpanLookup.FullSpanItem m3329il(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2729IL = new int[this.f5108IL1Iii];
        for (int i2 = 0; i2 < this.f5108IL1Iii; i2++) {
            fullSpanItem.f2729IL[i2] = this.f5109ILil[i2].LlLI1(i) - i;
        }
        return fullSpanItem;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final int m3330lL(int i) {
        int iM3338Ll1 = this.f5109ILil[0].m3338Ll1(i);
        for (int i2 = 1; i2 < this.f5108IL1Iii; i2++) {
            int iM3338Ll2 = this.f5109ILil[i2].m3338Ll1(i);
            if (iM3338Ll2 > iM3338Ll1) {
                iM3338Ll1 = iM3338Ll2;
            }
        }
        return iM3338Ll1;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final int m3331l(int i) {
        int iLlLI1 = this.f5109ILil[0].LlLI1(i);
        for (int i2 = 1; i2 < this.f5108IL1Iii; i2++) {
            int iLlLI2 = this.f5109ILil[i2].LlLI1(i);
            if (iLlLI2 < iLlLI1) {
                iLlLI1 = iLlLI2;
            }
        }
        return iLlLI1;
    }

    /* JADX WARN: Code duplicated, block: B:89:0x015a  */
    /* JADX INFO: renamed from: 丨丨 */
    public final void m122(RecyclerView.lL lLVar, RecyclerView.C1 c1, boolean z) {
        boolean z2;
        SavedState savedState;
        ILil iLil = this.iIlLiL;
        if (!(this.f2719llL1ii == null && this.ILL == -1) && c1.ILil() == 0) {
            removeAndRecycleAllViews(lLVar);
            iLil.I1I();
            return;
        }
        boolean z3 = (iLil.f5119Ilil && this.ILL == -1 && this.f2719llL1ii == null) ? false : true;
        if (z3) {
            iLil.I1I();
            if (this.f2719llL1ii != null) {
                ILil(iLil);
            } else {
                resolveShouldLayoutReverse();
                iLil.f5116I1I = this.f2715L11I;
            }
            LLL(c1, iLil);
            iLil.f5119Ilil = true;
        }
        if (this.f2719llL1ii == null && this.ILL == -1 && (iLil.f5116I1I != this.Lil || isLayoutRTL() != this.LlLI1)) {
            this.f2717lIiI.ILil();
            iLil.f2725IL = true;
        }
        if (getChildCount() > 0 && ((savedState = this.f2719llL1ii) == null || savedState.f2730IL < 1)) {
            if (iLil.f2725IL) {
                for (int i = 0; i < this.f5108IL1Iii; i++) {
                    this.f5109ILil[i].Ilil();
                    int i2 = iLil.f5118ILil;
                    if (i2 != Integer.MIN_VALUE) {
                        this.f5109ILil[i].m3346lL(i2);
                    }
                }
            } else if (z3 || this.iIlLiL.f2727lLi1LL == null) {
                for (int i3 = 0; i3 < this.f5108IL1Iii; i3++) {
                    this.f5109ILil[i3].ILil(this.f2715L11I, iLil.f5118ILil);
                }
                this.iIlLiL.m3347IL(this.f5109ILil);
            } else {
                for (int i4 = 0; i4 < this.f5108IL1Iii; i4++) {
                    I1I i1i = this.f5109ILil[i4];
                    i1i.Ilil();
                    i1i.m3346lL(this.iIlLiL.f2727lLi1LL[i4]);
                }
            }
        }
        detachAndScrapAttachedViews(lLVar);
        this.f2716iILLL1.f4284IL1Iii = false;
        this.I11li1 = false;
        m3302I1L11L(this.f2712IL.mo2353ILl());
        m3317iI1iI(iLil.f5117IL1Iii, c1);
        if (iLil.f5116I1I) {
            m3334(-1);
            m3313Ll1(lLVar, this.f2716iILLL1, c1);
            m3334(1);
            iILLL1 iilll1 = this.f2716iILLL1;
            iilll1.f4283I1I = iLil.f5117IL1Iii + iilll1.f1767IL;
            m3313Ll1(lLVar, iilll1, c1);
        } else {
            m3334(1);
            m3313Ll1(lLVar, this.f2716iILLL1, c1);
            m3334(-1);
            iILLL1 iilll2 = this.f2716iILLL1;
            iilll2.f4283I1I = iLil.f5117IL1Iii + iilll2.f1767IL;
            m3313Ll1(lLVar, iilll2, c1);
        }
        m3319ill();
        if (getChildCount() > 0) {
            if (this.f2715L11I) {
                m3323lIlii(lLVar, c1, true);
                iIi1(lLVar, c1, false);
            } else {
                iIi1(lLVar, c1, true);
                m3323lIlii(lLVar, c1, false);
            }
        }
        if (z && !c1.Ilil()) {
            if (this.f2711ILl != 0 && getChildCount() > 0 && (this.I11li1 || m3322lIII() != null)) {
                removeCallbacks(this.llliI);
                z2 = m3318iILLL1();
            }
        }
        if (c1.Ilil()) {
            this.iIlLiL.I1I();
        }
        this.Lil = iLil.f5116I1I;
        this.LlLI1 = isLayoutRTL();
        if (z2) {
            this.iIlLiL.I1I();
            m122(lLVar, c1, false);
        }
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m3332LLlI1(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f2728lLi1LL) {
            if (this.f5110Ilil == 1) {
                m3310L111(view, this.f2718lIlii, RecyclerView.LlLI1.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
                return;
            } else {
                m3310L111(view, RecyclerView.LlLI1.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.f2718lIlii, z);
                return;
            }
        }
        if (this.f5110Ilil == 1) {
            m3310L111(view, RecyclerView.LlLI1.getChildMeasureSpec(this.f2720lLi1LL, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LlLI1.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
        } else {
            m3310L111(view, RecyclerView.LlLI1.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LlLI1.getChildMeasureSpec(this.f2720lLi1LL, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final I1I m33331(iILLL1 iilll1) {
        int i;
        int i2;
        int i3 = -1;
        if (llI(iilll1.f4286Ilil)) {
            i = this.f5108IL1Iii - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.f5108IL1Iii;
            i2 = 1;
        }
        I1I i1i = null;
        if (iilll1.f4286Ilil == 1) {
            int i4 = Integer.MAX_VALUE;
            int iMo2359lIiI = this.f5107I1I.mo2359lIiI();
            while (i != i3) {
                I1I i1i2 = this.f5109ILil[i];
                int iM3338Ll1 = i1i2.m3338Ll1(iMo2359lIiI);
                if (iM3338Ll1 < i4) {
                    i1i = i1i2;
                    i4 = iM3338Ll1;
                }
                i += i2;
            }
            return i1i;
        }
        int i5 = Integer.MIN_VALUE;
        int iMo2357L11I = this.f5107I1I.mo2357L11I();
        while (i != i3) {
            I1I i1i3 = this.f5109ILil[i];
            int iLlLI1 = i1i3.LlLI1(iMo2357L11I);
            if (iLlLI1 > i5) {
                i1i = i1i3;
                i5 = iLlLI1;
            }
            i += i2;
        }
        return i1i;
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m3334(int i) {
        iILLL1 iilll1 = this.f2716iILLL1;
        iilll1.f4286Ilil = i;
        iilll1.f1767IL = this.f2715L11I != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LlLI1
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LazySpanLookup {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int[] f5121IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public List<FullSpanItem> f5122ILil;

        public void I1I(int i) {
            int[] iArr = this.f5121IL1Iii;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f5121IL1Iii = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[Lil(i)];
                this.f5121IL1Iii = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f5121IL1Iii;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public void IL1Iii(FullSpanItem fullSpanItem) {
            if (this.f5122ILil == null) {
                this.f5122ILil = new ArrayList();
            }
            int size = this.f5122ILil.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f5122ILil.get(i);
                if (fullSpanItem2.f5124ILil == fullSpanItem.f5124ILil) {
                    this.f5122ILil.remove(i);
                }
                if (fullSpanItem2.f5124ILil >= fullSpanItem.f5124ILil) {
                    this.f5122ILil.add(i, fullSpanItem);
                    return;
                }
            }
            this.f5122ILil.add(fullSpanItem);
        }

        public void ILL(int i, int i2) {
            int[] iArr = this.f5121IL1Iii;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            I1I(i3);
            int[] iArr2 = this.f5121IL1Iii;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f5121IL1Iii;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m3355lIiI(i, i2);
        }

        public void ILil() {
            int[] iArr = this.f5121IL1Iii;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f5122ILil = null;
        }

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public void m3349ILl(int i, I1I i1i) {
            I1I(i);
            this.f5121IL1Iii[i] = i1i.f5114Ilil;
        }

        public FullSpanItem Ilil(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f5122ILil;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f5122ILil.get(i4);
                int i5 = fullSpanItem.f5124ILil;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.f5123I1I == i3 || (z && fullSpanItem.f5125Ilil))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int m3350IL(int i) {
            List<FullSpanItem> list = this.f5122ILil;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f5122ILil.get(size).f5124ILil >= i) {
                        this.f5122ILil.remove(size);
                    }
                }
            }
            return m3351IiL(i);
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public int m3351IiL(int i) {
            int[] iArr = this.f5121IL1Iii;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int iM3353L11I = m3353L11I(i);
            if (iM3353L11I == -1) {
                int[] iArr2 = this.f5121IL1Iii;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f5121IL1Iii.length;
            }
            int i2 = iM3353L11I + 1;
            Arrays.fill(this.f5121IL1Iii, i, i2, -1);
            return i2;
        }

        public int Lil(int i) {
            int length = this.f5121IL1Iii.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public final void m3352Ll1(int i, int i2) {
            List<FullSpanItem> list = this.f5122ILil;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f5122ILil.get(size);
                int i3 = fullSpanItem.f5124ILil;
                if (i3 >= i) {
                    fullSpanItem.f5124ILil = i3 + i2;
                }
            }
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final int m3353L11I(int i) {
            if (this.f5122ILil == null) {
                return -1;
            }
            FullSpanItem fullSpanItemM3356lLi1LL = m3356lLi1LL(i);
            if (fullSpanItemM3356lLi1LL != null) {
                this.f5122ILil.remove(fullSpanItemM3356lLi1LL);
            }
            int size = this.f5122ILil.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f5122ILil.get(i2).f5124ILil >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f5122ILil.get(i2);
            this.f5122ILil.remove(i2);
            return fullSpanItem.f5124ILil;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int m3354iILLL1(int i) {
            int[] iArr = this.f5121IL1Iii;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public final void m3355lIiI(int i, int i2) {
            List<FullSpanItem> list = this.f5122ILil;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f5122ILil.get(size);
                int i4 = fullSpanItem.f5124ILil;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f5122ILil.remove(size);
                    } else {
                        fullSpanItem.f5124ILil = i4 - i2;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public FullSpanItem m3356lLi1LL(int i) {
            List<FullSpanItem> list = this.f5122ILil;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f5122ILil.get(size);
                if (fullSpanItem.f5124ILil == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void m3357il(int i, int i2) {
            int[] iArr = this.f5121IL1Iii;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            I1I(i3);
            int[] iArr2 = this.f5121IL1Iii;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f5121IL1Iii, i, i3, -1);
            m3352Ll1(i, i2);
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new IL1Iii();

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public int f5123I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public int f5124ILil;

            /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
            public boolean f5125Ilil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public int[] f2729IL;

            public static class IL1Iii implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f5124ILil = parcel.readInt();
                this.f5123I1I = parcel.readInt();
                this.f5125Ilil = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.f2729IL = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int IL1Iii(int i) {
                int[] iArr = this.f2729IL;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f5124ILil + ", mGapDir=" + this.f5123I1I + ", mHasUnwantedGapAfter=" + this.f5125Ilil + ", mGapPerSpan=" + Arrays.toString(this.f2729IL) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f5124ILil);
                parcel.writeInt(this.f5123I1I);
                parcel.writeInt(this.f5125Ilil ? 1 : 0);
                int[] iArr = this.f2729IL;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f2729IL);
                }
            }

            public FullSpanItem() {
            }
        }
    }
}
