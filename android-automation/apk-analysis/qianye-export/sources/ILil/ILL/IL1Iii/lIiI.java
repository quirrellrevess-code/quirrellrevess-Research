package ILil.ILL.IL1Iii;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: FragmentTransitionCompat21.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI extends AbstractC0618ILl {

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.lIi丨I$I1I */
    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    public class I1I implements Transition.TransitionListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Object f3687I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Object f3688IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3689ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ Object f3690Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1266IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1268lLi1LL;

        public I1I(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3688IL1Iii = obj;
            this.f3689ILil = arrayList;
            this.f3687I1I = obj2;
            this.f1266IL = arrayList2;
            this.f3690Ilil = obj3;
            this.f1268lLi1LL = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f3688IL1Iii;
            if (obj != null) {
                lIiI.this.mo1472llL1ii(obj, this.f3689ILil, null);
            }
            Object obj2 = this.f3687I1I;
            if (obj2 != null) {
                lIiI.this.mo1472llL1ii(obj2, this.f1266IL, null);
            }
            Object obj3 = this.f3690Ilil;
            if (obj3 != null) {
                lIiI.this.mo1472llL1ii(obj3, this.f1268lLi1LL, null);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    public class IL1Iii extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Rect f3691IL1Iii;

        public IL1Iii(lIiI liii, Rect rect) {
            this.f3691IL1Iii = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f3691IL1Iii;
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.lIi丨I$ILil */
    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    public class ILil implements Transition.TransitionListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ View f3692IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3693ILil;

        public ILil(lIiI liii, View view, ArrayList arrayList) {
            this.f3692IL1Iii = view;
            this.f3693ILil = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f3692IL1Iii.setVisibility(8);
            int size = this.f3693ILil.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f3693ILil.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.lIi丨I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    public class IL extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Rect f3694IL1Iii;

        public IL(lIiI liii, Rect rect) {
            this.f3694IL1Iii = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f3694IL1Iii;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f3694IL1Iii;
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static boolean m1597lIII(Transition transition) {
        return (AbstractC0618ILl.m1465Ll1(transition.getTargetIds()) && AbstractC0618ILl.m1465Ll1(transition.getTargetNames()) && AbstractC0618ILl.m1465Ll1(transition.getTargetTypes())) ? false : true;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public void I11li1(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new IL(this, rect));
        }
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public void I1I(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public void IL1Iii(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public void ILil(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                ILil(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (m1597lIII(transition) || !AbstractC0618ILl.m1465Ll1(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget(arrayList.get(i));
            i++;
        }
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: IL丨丨l */
    public Object mo1467ILl(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public boolean Ilil(Object obj) {
        return obj instanceof Transition;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public void LlLI1(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: L丨lLLL */
    public Object mo1468LlLLL(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    public void iIlLiL(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new I1I(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: iI丨LLL1 */
    public Object mo1469iILLL1(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: lIi丨I */
    public Object mo1470lIiI(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: lI丨lii */
    public void mo1471lIlii(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new ILil(this, view, arrayList));
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: ll丨L1ii */
    public void mo1472llL1ii(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo1472llL1ii(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (m1597lIII(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget(arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: 丨lL */
    public void mo1475lL(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            ILL(view, rect);
            ((Transition) obj).setEpicenterCallback(new IL1Iii(this, rect));
        }
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: 丨l丨 */
    public void mo1476l(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC0618ILl.m1463IL(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        ILil(transitionSet, arrayList);
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: 丨丨丨1丨 */
    public void mo14771(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            mo1472llL1ii(transitionSet, arrayList, arrayList2);
        }
    }
}
