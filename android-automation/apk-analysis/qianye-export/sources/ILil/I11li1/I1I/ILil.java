package ILil.I11li1.I1I;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CompositeOnPageChangeCallback.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILil extends ViewPager2.AbstractC0670il {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final List<ViewPager2.AbstractC0670il> f3591IL1Iii;

    public ILil(int i) {
        this.f3591IL1Iii = new ArrayList(i);
    }

    public final void I1I(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    public void IL1Iii(ViewPager2.AbstractC0670il abstractC0670il) {
        this.f3591IL1Iii.add(abstractC0670il);
    }

    public void ILil(ViewPager2.AbstractC0670il abstractC0670il) {
        this.f3591IL1Iii.remove(abstractC0670il);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
    public void onPageScrollStateChanged(int i) {
        try {
            Iterator<ViewPager2.AbstractC0670il> it = this.f3591IL1Iii.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            I1I(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
    public void onPageScrolled(int i, float f, int i2) {
        try {
            Iterator<ViewPager2.AbstractC0670il> it = this.f3591IL1Iii.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            I1I(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0670il
    public void onPageSelected(int i) {
        try {
            Iterator<ViewPager2.AbstractC0670il> it = this.f3591IL1Iii.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            I1I(e);
            throw null;
        }
    }
}
