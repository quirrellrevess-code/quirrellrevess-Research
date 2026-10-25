package ILil.I11li1.I1I;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: AnimateLayoutChangeDetector.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f3589ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public LinearLayoutManager f3590IL1Iii;

    /* JADX INFO: renamed from: ILil.I11li1.I1I.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimateLayoutChangeDetector.java */
    public class C0546IL1Iii implements Comparator<int[]> {
        public C0546IL1Iii(IL1Iii iL1Iii) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f3589ILil = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public IL1Iii(LinearLayoutManager linearLayoutManager) {
        this.f3590IL1Iii = linearLayoutManager;
    }

    public static boolean I1I(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (I1I(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean IL1Iii() {
        int top;
        int i;
        int bottom;
        int i2;
        int childCount = this.f3590IL1Iii.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f3590IL1Iii.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f3590IL1Iii.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f3589ILil;
            int[] iArr2 = iArr[i3];
            if (z) {
                top = childAt.getLeft();
                i = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i;
            int[] iArr3 = iArr[i3];
            if (z) {
                bottom = childAt.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        Arrays.sort(iArr, new C0546IL1Iii(this));
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    public final boolean ILil() {
        int childCount = this.f3590IL1Iii.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (I1I(this.f3590IL1Iii.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1428IL() {
        return (!IL1Iii() || this.f3590IL1Iii.getChildCount() <= 1) && ILil();
    }
}
