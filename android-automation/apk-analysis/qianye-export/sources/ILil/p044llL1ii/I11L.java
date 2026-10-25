package ILil.p044llL1ii;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p065Ilil.Ll1;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class I11L {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Transition f4394IL1Iii = new AutoTransition();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static ThreadLocal<WeakReference<Ll1<ViewGroup, ArrayList<Transition>>>> f4395ILil = new ThreadLocal<>();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static ArrayList<ViewGroup> f4393I1I = new ArrayList<>();

    /* JADX INFO: compiled from: TransitionManager.java */
    public static class IL1Iii implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ViewGroup f4396I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Transition f4397ILil;

        /* JADX INFO: renamed from: ILil.ll丨L1ii.I11L$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TransitionManager.java */
        public class C0583IL1Iii extends lL {

            /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
            public final /* synthetic */ Ll1 f4398IL1Iii;

            public C0583IL1Iii(Ll1 ll1) {
                this.f4398IL1Iii = ll1;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.Transition.IiL
            public void I1I(Transition transition) {
                ((ArrayList) this.f4398IL1Iii.get(IL1Iii.this.f4396I1I)).remove(transition);
                transition.removeListener(this);
            }
        }

        public IL1Iii(Transition transition, ViewGroup viewGroup) {
            this.f4397ILil = transition;
            this.f4396I1I = viewGroup;
        }

        public final void IL1Iii() {
            this.f4396I1I.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4396I1I.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IL1Iii();
            if (!I11L.f4393I1I.remove(this.f4396I1I)) {
                return true;
            }
            Ll1<ViewGroup, ArrayList<Transition>> ll1ILil = I11L.ILil();
            ArrayList<Transition> arrayList = ll1ILil.get(this.f4396I1I);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                ll1ILil.put(this.f4396I1I, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4397ILil);
            this.f4397ILil.addListener(new C0583IL1Iii(ll1ILil));
            this.f4397ILil.captureValues(this.f4396I1I, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f4396I1I);
                }
            }
            this.f4397ILil.playTransition(this.f4396I1I);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IL1Iii();
            I11L.f4393I1I.remove(this.f4396I1I);
            ArrayList<Transition> arrayList = I11L.ILil().get(this.f4396I1I);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f4396I1I);
                }
            }
            this.f4397ILil.clearValues(true);
        }
    }

    public static void I1I(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        IL1Iii iL1Iii = new IL1Iii(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(iL1Iii);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(iL1Iii);
    }

    public static void IL1Iii(ViewGroup viewGroup, Transition transition) {
        if (f4393I1I.contains(viewGroup) || !iIlLiL.m2103LlIl(viewGroup)) {
            return;
        }
        f4393I1I.add(viewGroup);
        if (transition == null) {
            transition = f4394IL1Iii;
        }
        Transition transitionMo3370clone = transition.mo3370clone();
        m2545IL(viewGroup, transitionMo3370clone);
        iIi1.I1I(viewGroup, null);
        I1I(viewGroup, transitionMo3370clone);
    }

    public static Ll1<ViewGroup, ArrayList<Transition>> ILil() {
        Ll1<ViewGroup, ArrayList<Transition>> ll1;
        WeakReference<Ll1<ViewGroup, ArrayList<Transition>>> weakReference = f4395ILil.get();
        if (weakReference != null && (ll1 = weakReference.get()) != null) {
            return ll1;
        }
        Ll1<ViewGroup, ArrayList<Transition>> ll2 = new Ll1<>();
        f4395ILil.set(new WeakReference<>(ll2));
        return ll2;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m2545IL(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = ILil().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        iIi1 iii1ILil = iIi1.ILil(viewGroup);
        if (iii1ILil != null) {
            iii1ILil.IL1Iii();
        }
    }
}
