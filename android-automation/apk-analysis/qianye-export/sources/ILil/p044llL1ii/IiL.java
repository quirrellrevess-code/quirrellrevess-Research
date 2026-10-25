package ILil.p044llL1ii;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: renamed from: ILil.ll丨L1ii.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: GhostViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public class IiL extends FrameLayout {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f4416I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ViewGroup f4417ILil;

    public IiL(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f4417ILil = viewGroup;
        viewGroup.setTag(llL1ii.ghost_view_holder, this);
        C0006.ILil(this.f4417ILil).I1I(this);
        this.f4416I1I = true;
    }

    public static IiL ILil(ViewGroup viewGroup) {
        return (IiL) viewGroup.getTag(llL1ii.ghost_view_holder);
    }

    public static boolean Ilil(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(C0006.IL1Iii(viewGroup, i));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2559IL(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            m2559IL((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean m2560lLi1LL(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i = 1; i < iMin; i++) {
            View view = arrayList.get(i);
            View view2 = arrayList2.get(i);
            if (view != view2) {
                return Ilil(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    public final int I1I(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            m2559IL(((C0647il) getChildAt(i2)).f1874IL, arrayList2);
            if (m2560lLi1LL(arrayList, arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    public void IL1Iii(C0647il c0647il) {
        ArrayList<View> arrayList = new ArrayList<>();
        m2559IL(c0647il.f1874IL, arrayList);
        int iI1I = I1I(arrayList);
        if (iI1I < 0 || iI1I >= getChildCount()) {
            addView(c0647il);
        } else {
            addView(c0647il, iI1I);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m2561iILLL1() {
        if (!this.f4416I1I) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        C0006.ILil(this.f4417ILil).mo2562IL(this);
        C0006.ILil(this.f4417ILil).I1I(this);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f4416I1I) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f4417ILil.setTag(llL1ii.ghost_view_holder, null);
            C0006.ILil(this.f4417ILil).mo2562IL(this);
            this.f4416I1I = false;
        }
    }
}
