package ILil.Lil.p037IL;

import ILil.p028IiL.p029ILl.iIlLiL;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I extends Lil {
    public static TimeInterpolator iIi1;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ArrayList<RecyclerView.LL1IL> f1725IiL = new ArrayList<>();

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ArrayList<RecyclerView.LL1IL> f1727L11I = new ArrayList<>();

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ArrayList<ILL> f1731il = new ArrayList<>();
    public ArrayList<C0638il> ILL = new ArrayList<>();

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ArrayList<ArrayList<RecyclerView.LL1IL>> f1726Ll1 = new ArrayList<>();

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public ArrayList<ArrayList<ILL>> f1728lIiI = new ArrayList<>();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ArrayList<ArrayList<C0638il>> f1724ILl = new ArrayList<>();
    public ArrayList<RecyclerView.LL1IL> Lil = new ArrayList<>();
    public ArrayList<RecyclerView.LL1IL> LlLI1 = new ArrayList<>();

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public ArrayList<RecyclerView.LL1IL> f1730llL1ii = new ArrayList<>();

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public ArrayList<RecyclerView.LL1IL> f1729lIlii = new ArrayList<>();

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class RunnableC0575I1I implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4221ILil;

        public RunnableC0575I1I(ArrayList arrayList) {
            this.f4221ILil = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4221ILil.iterator();
            while (it.hasNext()) {
                I1I.this.m2325IIiI((RecyclerView.LL1IL) it.next());
            }
            this.f4221ILil.clear();
            I1I.this.f1726Ll1.remove(this.f4221ILil);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4223ILil;

        public IL1Iii(ArrayList arrayList) {
            this.f4223ILil = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ILL ill : this.f4223ILil) {
                I1I.this.LLL(ill.f4225IL1Iii, ill.f4226ILil, ill.f4224I1I, ill.f1732IL, ill.f4227Ilil);
            }
            this.f4223ILil.clear();
            I1I.this.f1728lIiI.remove(this.f4223ILil);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public static class ILL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4224I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public RecyclerView.LL1IL f4225IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4226ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4227Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1732IL;

        public ILL(RecyclerView.LL1IL ll1il, int i, int i2, int i3, int i4) {
            this.f4225IL1Iii = ll1il;
            this.f4226ILil = i;
            this.f4224I1I = i2;
            this.f1732IL = i3;
            this.f4227Ilil = i4;
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class ILil implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4229ILil;

        public ILil(ArrayList arrayList) {
            this.f4229ILil = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4229ILil.iterator();
            while (it.hasNext()) {
                I1I.this.m2330lliiI1((C0638il) it.next());
            }
            this.f4229ILil.clear();
            I1I.this.f1724ILl.remove(this.f4229ILil);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class IL extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f4230I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.LL1IL f4231IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4232ILil;

        public IL(RecyclerView.LL1IL ll1il, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4231IL1Iii = ll1il;
            this.f4232ILil = viewPropertyAnimator;
            this.f4230I1I = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4232ILil.setListener(null);
            this.f4230I1I.setAlpha(1.0f);
            I1I.this.llI(this.f4231IL1Iii);
            I1I.this.f1730llL1ii.remove(this.f4231IL1Iii);
            I1I.this.m2326ILLIi();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            I1I.this.m2406l1IIi1(this.f4231IL1Iii);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class IiL extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f4233I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ C0638il f4234IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4235ILil;

        public IiL(C0638il c0638il, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4234IL1Iii = c0638il;
            this.f4235ILil = viewPropertyAnimator;
            this.f4233I1I = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4235ILil.setListener(null);
            this.f4233I1I.setAlpha(1.0f);
            this.f4233I1I.setTranslationX(0.0f);
            this.f4233I1I.setTranslationY(0.0f);
            I1I.this.LL1IL(this.f4234IL1Iii.f4247IL1Iii, true);
            I1I.this.f1729lIlii.remove(this.f4234IL1Iii.f4247IL1Iii);
            I1I.this.m2326ILLIi();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            I1I.this.m2400L111(this.f4234IL1Iii.f4247IL1Iii, true);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$L丨1丨1丨I, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class L11I extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f4236I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ C0638il f4237IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4238ILil;

        public L11I(C0638il c0638il, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4237IL1Iii = c0638il;
            this.f4238ILil = viewPropertyAnimator;
            this.f4236I1I = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4238ILil.setListener(null);
            this.f4236I1I.setAlpha(1.0f);
            this.f4236I1I.setTranslationX(0.0f);
            this.f4236I1I.setTranslationY(0.0f);
            I1I.this.LL1IL(this.f4237IL1Iii.f4248ILil, false);
            I1I.this.f1729lIlii.remove(this.f4237IL1Iii.f4248ILil);
            I1I.this.m2326ILLIi();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            I1I.this.m2400L111(this.f4237IL1Iii.f4248ILil, false);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class iILLL1 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f4239I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.LL1IL f4240IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f4241ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4242Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f1736IL;

        public iILLL1(RecyclerView.LL1IL ll1il, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f4240IL1Iii = ll1il;
            this.f4241ILil = i;
            this.f4239I1I = view;
            this.f1736IL = i2;
            this.f4242Ilil = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f4241ILil != 0) {
                this.f4239I1I.setTranslationX(0.0f);
            }
            if (this.f1736IL != 0) {
                this.f4239I1I.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4242Ilil.setListener(null);
            I1I.this.m2410LLlI1(this.f4240IL1Iii);
            I1I.this.LlLI1.remove(this.f4240IL1Iii);
            I1I.this.m2326ILLIi();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            I1I.this.m80(this.f4240IL1Iii);
        }
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public class lLi1LL extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f4243I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.LL1IL f4244IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4245ILil;

        public lLi1LL(RecyclerView.LL1IL ll1il, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f4244IL1Iii = ll1il;
            this.f4245ILil = view;
            this.f4243I1I = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4245ILil.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4243I1I.setListener(null);
            I1I.this.m2404LlLLL(this.f4244IL1Iii);
            I1I.this.Lil.remove(this.f4244IL1Iii);
            I1I.this.m2326ILLIi();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            I1I.this.m2407lIII(this.f4244IL1Iii);
        }
    }

    @Override // ILil.Lil.p037IL.Lil
    public boolean I11L(RecyclerView.LL1IL ll1il) {
        m2329ili11(ll1il);
        ll1il.itemView.setAlpha(0.0f);
        this.f1727L11I.add(ll1il);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    public void I11li1() {
        boolean z = !this.f1725IiL.isEmpty();
        boolean z2 = !this.f1731il.isEmpty();
        boolean z3 = !this.ILL.isEmpty();
        boolean z4 = !this.f1727L11I.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.LL1IL> it = this.f1725IiL.iterator();
            while (it.hasNext()) {
                m2327iI1iI(it.next());
            }
            this.f1725IiL.clear();
            if (z2) {
                ArrayList<ILL> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1731il);
                this.f1728lIiI.add(arrayList);
                this.f1731il.clear();
                IL1Iii iL1Iii = new IL1Iii(arrayList);
                if (z) {
                    iIlLiL.m2104LlLiLL(arrayList.get(0).f4225IL1Iii.itemView, iL1Iii, Lil());
                } else {
                    iL1Iii.run();
                }
            }
            if (z3) {
                ArrayList<C0638il> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.ILL);
                this.f1724ILl.add(arrayList2);
                this.ILL.clear();
                ILil iLil = new ILil(arrayList2);
                if (z) {
                    iIlLiL.m2104LlLiLL(arrayList2.get(0).f4247IL1Iii.itemView, iLil, Lil());
                } else {
                    iLil.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.LL1IL> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1727L11I);
                this.f1726Ll1.add(arrayList3);
                this.f1727L11I.clear();
                RunnableC0575I1I runnableC0575I1I = new RunnableC0575I1I(arrayList3);
                if (z || z2 || z3) {
                    iIlLiL.m2104LlLiLL(arrayList3.get(0).itemView, runnableC0575I1I, (z ? Lil() : 0L) + Math.max(z2 ? m3263ILl() : 0L, z3 ? m3267lIiI() : 0L));
                } else {
                    runnableC0575I1I.run();
                }
            }
        }
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public void m2324I1L11L(List<RecyclerView.LL1IL> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public void m2325IIiI(RecyclerView.LL1IL ll1il) {
        View view = ll1il.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.Lil.add(ll1il);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m3265Ll1()).setListener(new lLi1LL(ll1il, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    public void ILL() {
        int size = this.f1731il.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            ILL ill = this.f1731il.get(size);
            View view = ill.f4225IL1Iii.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m2410LLlI1(ill.f4225IL1Iii);
            this.f1731il.remove(size);
        }
        for (int size2 = this.f1725IiL.size() - 1; size2 >= 0; size2--) {
            llI(this.f1725IiL.get(size2));
            this.f1725IiL.remove(size2);
        }
        int size3 = this.f1727L11I.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.LL1IL ll1il = this.f1727L11I.get(size3);
            ll1il.itemView.setAlpha(1.0f);
            m2404LlLLL(ll1il);
            this.f1727L11I.remove(size3);
        }
        for (int size4 = this.ILL.size() - 1; size4 >= 0; size4--) {
            iIilII1(this.ILL.get(size4));
        }
        this.ILL.clear();
        if (LlLI1()) {
            for (int size5 = this.f1728lIiI.size() - 1; size5 >= 0; size5--) {
                ArrayList<ILL> arrayList = this.f1728lIiI.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    ILL ill2 = arrayList.get(size6);
                    View view2 = ill2.f4225IL1Iii.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m2410LLlI1(ill2.f4225IL1Iii);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1728lIiI.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1726Ll1.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.LL1IL> arrayList2 = this.f1726Ll1.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.LL1IL ll1il2 = arrayList2.get(size8);
                    ll1il2.itemView.setAlpha(1.0f);
                    m2404LlLLL(ll1il2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1726Ll1.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1724ILl.size() - 1; size9 >= 0; size9--) {
                ArrayList<C0638il> arrayList3 = this.f1724ILl.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    iIilII1(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1724ILl.remove(arrayList3);
                    }
                }
            }
            m2324I1L11L(this.f1730llL1ii);
            m2324I1L11L(this.LlLI1);
            m2324I1L11L(this.Lil);
            m2324I1L11L(this.f1729lIlii);
            m3266L11I();
        }
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public void m2326ILLIi() {
        if (LlLI1()) {
            return;
        }
        m3266L11I();
    }

    public void LLL(RecyclerView.LL1IL ll1il, int i, int i2, int i3, int i4) {
        View view = ll1il.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.LlLI1.add(ll1il);
        viewPropertyAnimatorAnimate.setDuration(m3263ILl()).setListener(new iILLL1(ll1il, i5, view, i6, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    public boolean LlLI1() {
        return (this.f1727L11I.isEmpty() && this.ILL.isEmpty() && this.f1731il.isEmpty() && this.f1725IiL.isEmpty() && this.LlLI1.isEmpty() && this.f1730llL1ii.isEmpty() && this.Lil.isEmpty() && this.f1729lIlii.isEmpty() && this.f1728lIiI.isEmpty() && this.f1726Ll1.isEmpty() && this.f1724ILl.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: i1 */
    public final boolean m79i1(C0638il c0638il, RecyclerView.LL1IL ll1il) {
        boolean z = false;
        if (c0638il.f4248ILil == ll1il) {
            c0638il.f4248ILil = null;
        } else {
            if (c0638il.f4247IL1Iii != ll1il) {
                return false;
            }
            c0638il.f4247IL1Iii = null;
            z = true;
        }
        ll1il.itemView.setAlpha(1.0f);
        ll1il.itemView.setTranslationX(0.0f);
        ll1il.itemView.setTranslationY(0.0f);
        LL1IL(ll1il, z);
        return true;
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public final void m2327iI1iI(RecyclerView.LL1IL ll1il) {
        View view = ll1il.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1730llL1ii.add(ll1il);
        viewPropertyAnimatorAnimate.setDuration(Lil()).alpha(0.0f).setListener(new IL(ll1il, viewPropertyAnimatorAnimate, view)).start();
    }

    public final void iIilII1(C0638il c0638il) {
        RecyclerView.LL1IL ll1il = c0638il.f4247IL1Iii;
        if (ll1il != null) {
            m79i1(c0638il, ll1il);
        }
        RecyclerView.LL1IL ll1il2 = c0638il.f4248ILil;
        if (ll1il2 != null) {
            m79i1(c0638il, ll1il2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean mo2328iILLL1(RecyclerView.LL1IL ll1il, List<Object> list) {
        return !list.isEmpty() || super.mo2328iILLL1(ll1il, list);
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public final void m2329ili11(RecyclerView.LL1IL ll1il) {
        if (iIi1 == null) {
            iIi1 = new ValueAnimator().getInterpolator();
        }
        ll1il.itemView.animate().setInterpolator(iIi1);
        mo2332il(ll1il);
    }

    @Override // ILil.Lil.p037IL.Lil
    public boolean llliI(RecyclerView.LL1IL ll1il, RecyclerView.LL1IL ll1il2, int i, int i2, int i3, int i4) {
        if (ll1il == ll1il2) {
            return mo2333l(ll1il, i, i2, i3, i4);
        }
        float translationX = ll1il.itemView.getTranslationX();
        float translationY = ll1il.itemView.getTranslationY();
        float alpha = ll1il.itemView.getAlpha();
        m2329ili11(ll1il);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        ll1il.itemView.setTranslationX(translationX);
        ll1il.itemView.setTranslationY(translationY);
        ll1il.itemView.setAlpha(alpha);
        if (ll1il2 != null) {
            m2329ili11(ll1il2);
            ll1il2.itemView.setTranslationX(-i5);
            ll1il2.itemView.setTranslationY(-i6);
            ll1il2.itemView.setAlpha(0.0f);
        }
        this.ILL.add(new C0638il(ll1il, ll1il2, i, i2, i3, i4));
        return true;
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public void m2330lliiI1(C0638il c0638il) {
        RecyclerView.LL1IL ll1il = c0638il.f4247IL1Iii;
        View view = ll1il == null ? null : ll1il.itemView;
        RecyclerView.LL1IL ll1il2 = c0638il.f4248ILil;
        View view2 = ll1il2 != null ? ll1il2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m3267lIiI());
            this.f1729lIlii.add(c0638il.f4247IL1Iii);
            duration.translationX(c0638il.f4249Ilil - c0638il.f4246I1I);
            duration.translationY(c0638il.f1740lLi1LL - c0638il.f1739IL);
            duration.alpha(0.0f).setListener(new IiL(c0638il, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f1729lIlii.add(c0638il.f4248ILil);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m3267lIiI()).alpha(1.0f).setListener(new L11I(c0638il, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final void m2331li11(List<C0638il> list, RecyclerView.LL1IL ll1il) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0638il c0638il = list.get(size);
            if (m79i1(c0638il, ll1il) && c0638il.f4247IL1Iii == null && c0638il.f4248ILil == null) {
                list.remove(c0638il);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.lIiI
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void mo2332il(RecyclerView.LL1IL ll1il) {
        View view = ll1il.itemView;
        view.animate().cancel();
        int size = this.f1731il.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f1731il.get(size).f4225IL1Iii == ll1il) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m2410LLlI1(ll1il);
                this.f1731il.remove(size);
            }
        }
        m2331li11(this.ILL, ll1il);
        if (this.f1725IiL.remove(ll1il)) {
            view.setAlpha(1.0f);
            llI(ll1il);
        }
        if (this.f1727L11I.remove(ll1il)) {
            view.setAlpha(1.0f);
            m2404LlLLL(ll1il);
        }
        for (int size2 = this.f1724ILl.size() - 1; size2 >= 0; size2--) {
            ArrayList<C0638il> arrayList = this.f1724ILl.get(size2);
            m2331li11(arrayList, ll1il);
            if (arrayList.isEmpty()) {
                this.f1724ILl.remove(size2);
            }
        }
        for (int size3 = this.f1728lIiI.size() - 1; size3 >= 0; size3--) {
            ArrayList<ILL> arrayList2 = this.f1728lIiI.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).f4225IL1Iii == ll1il) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m2410LLlI1(ll1il);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.f1728lIiI.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f1726Ll1.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.LL1IL> arrayList3 = this.f1726Ll1.get(size5);
            if (arrayList3.remove(ll1il)) {
                view.setAlpha(1.0f);
                m2404LlLLL(ll1il);
                if (arrayList3.isEmpty()) {
                    this.f1726Ll1.remove(size5);
                }
            }
        }
        this.f1730llL1ii.remove(ll1il);
        this.Lil.remove(ll1il);
        this.f1729lIlii.remove(ll1il);
        this.LlLI1.remove(ll1il);
        m2326ILLIi();
    }

    @Override // ILil.Lil.p037IL.Lil
    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public boolean mo2333l(RecyclerView.LL1IL ll1il, int i, int i2, int i3, int i4) {
        View view = ll1il.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) ll1il.itemView.getTranslationY());
        m2329ili11(ll1il);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m2410LLlI1(ll1il);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f1731il.add(new ILL(ll1il, translationX, translationY, i3, i4));
        return true;
    }

    @Override // ILil.Lil.p037IL.Lil
    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean mo23341(RecyclerView.LL1IL ll1il) {
        m2329ili11(ll1il);
        this.f1725IiL.add(ll1il);
        return true;
    }

    /* JADX INFO: renamed from: ILil.Lil.I丨L.I1I$丨il, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    public static class C0638il {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4246I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public RecyclerView.LL1IL f4247IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public RecyclerView.LL1IL f4248ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4249Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1739IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f1740lLi1LL;

        public C0638il(RecyclerView.LL1IL ll1il, RecyclerView.LL1IL ll1il2) {
            this.f4247IL1Iii = ll1il;
            this.f4248ILil = ll1il2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f4247IL1Iii + ", newHolder=" + this.f4248ILil + ", fromX=" + this.f4246I1I + ", fromY=" + this.f1739IL + ", toX=" + this.f4249Ilil + ", toY=" + this.f1740lLi1LL + '}';
        }

        public C0638il(RecyclerView.LL1IL ll1il, RecyclerView.LL1IL ll1il2, int i, int i2, int i3, int i4) {
            this(ll1il, ll1il2);
            this.f4246I1I = i;
            this.f1739IL = i2;
            this.f4249Ilil = i3;
            this.f1740lLi1LL = i4;
        }
    }
}
