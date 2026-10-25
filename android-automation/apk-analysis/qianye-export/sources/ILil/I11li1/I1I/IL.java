package ILil.I11li1.I1I;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: renamed from: ILil.I11li1.I1I.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: PageTransformerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL extends ViewPager2.AbstractC0670il {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final LinearLayoutManager f3592IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ViewPager2.Ll1 f3593ILil;

    public IL(LinearLayoutManager linearLayoutManager) {
        this.f3592IL1Iii = linearLayoutManager;
    }

    public ViewPager2.Ll1 IL1Iii() {
        return this.f3593ILil;
    }

    public void ILil(ViewPager2.Ll1 ll1) {
        this.f3593ILil = ll1;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
    public void onPageScrolled(int i, float f, int i2) {
        if (this.f3593ILil == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.f3592IL1Iii.getChildCount(); i3++) {
            View childAt = this.f3592IL1Iii.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f3592IL1Iii.getChildCount())));
            }
            this.f3593ILil.IL1Iii(childAt, (this.f3592IL1Iii.getPosition(childAt) - i) + f2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
    public void onPageSelected(int i) {
    }
}
