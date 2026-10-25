package ILil.p044llL1ii;

import ILil.ILL.IL1Iii.AbstractC0618ILl;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ILil.ll丨L1ii.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class lLi1LL extends AbstractC0618ILl {

    /* JADX INFO: renamed from: ILil.ll丨L1ii.l丨Li1LL$I1I */
    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    public class I1I extends lL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Object f4453I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Object f4454IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4455ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ Object f4456Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1871IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1873lLi1LL;

        public I1I(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f4454IL1Iii = obj;
            this.f4455ILil = arrayList;
            this.f4453I1I = obj2;
            this.f1871IL = arrayList2;
            this.f4456Ilil = obj3;
            this.f1873lLi1LL = arrayList3;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            transition.removeListener(this);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void IL1Iii(Transition transition) {
            Object obj = this.f4454IL1Iii;
            if (obj != null) {
                lLi1LL.this.mo1472llL1ii(obj, this.f4455ILil, null);
            }
            Object obj2 = this.f4453I1I;
            if (obj2 != null) {
                lLi1LL.this.mo1472llL1ii(obj2, this.f1871IL, null);
            }
            Object obj3 = this.f4456Ilil;
            if (obj3 != null) {
                lLi1LL.this.mo1472llL1ii(obj3, this.f1873lLi1LL, null);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ll丨L1ii.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    public class IL1Iii extends Transition.iILLL1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Rect f4457IL1Iii;

        public IL1Iii(lLi1LL lli1ll, Rect rect) {
            this.f4457IL1Iii = rect;
        }

        @Override // androidx.transition.Transition.iILLL1
        public Rect IL1Iii(Transition transition) {
            return this.f4457IL1Iii;
        }
    }

    /* JADX INFO: renamed from: ILil.ll丨L1ii.l丨Li1LL$ILil */
    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    public class ILil implements Transition.IiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ View f4458IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4459ILil;

        public ILil(lLi1LL lli1ll, View view, ArrayList arrayList) {
            this.f4458IL1Iii = view;
            this.f4459ILil = arrayList;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            transition.removeListener(this);
            this.f4458IL1Iii.setVisibility(8);
            int size = this.f4459ILil.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f4459ILil.get(i)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.IiL
        public void IL1Iii(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        public void ILil(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        public void Ilil(Transition transition) {
        }

        @Override // androidx.transition.Transition.IiL
        /* JADX INFO: renamed from: I丨L */
        public void mo2573IL(Transition transition) {
        }
    }

    /* JADX INFO: renamed from: ILil.ll丨L1ii.l丨Li1LL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    public class IL extends Transition.iILLL1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Rect f4460IL1Iii;

        public IL(lLi1LL lli1ll, Rect rect) {
            this.f4460IL1Iii = rect;
        }

        @Override // androidx.transition.Transition.iILLL1
        public Rect IL1Iii(Transition transition) {
            Rect rect = this.f4460IL1Iii;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f4460IL1Iii;
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static boolean m2574lIII(Transition transition) {
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
        I11L.IL1Iii(viewGroup, (Transition) obj);
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
            int iM3380il = transitionSet.m3380il();
            while (i < iM3380il) {
                ILil(transitionSet.m3374L11I(i), arrayList);
                i++;
            }
            return;
        }
        if (m2574lIII(transition) || !AbstractC0618ILl.m1465Ll1(transition.getTargets())) {
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
            transitionSet.m3379lLi1LL((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m3379lLi1LL((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m3379lLi1LL((Transition) obj3);
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
        transitionSet.m3379lLi1LL((Transition) obj);
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
            return ((Transition) obj).mo3370clone();
        }
        return null;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: lIi丨I */
    public Object mo1470lIiI(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.m3379lLi1LL(transition);
            transitionSet.m3379lLi1LL(transition2);
            transitionSet.m3377lIlii(1);
            transition = transitionSet;
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition != null) {
            transitionSet2.m3379lLi1LL(transition);
        }
        transitionSet2.m3379lLi1LL(transition3);
        return transitionSet2;
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: lI丨lii */
    public void mo1471lIlii(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new ILil(this, view, arrayList));
    }

    @Override // ILil.ILL.IL1Iii.AbstractC0618ILl
    /* JADX INFO: renamed from: ll丨L1ii */
    public void mo1472llL1ii(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM3380il = transitionSet.m3380il();
            while (i < iM3380il) {
                mo1472llL1ii(transitionSet.m3374L11I(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (m2574lIII(transition)) {
            return;
        }
        List<View> targets = transition.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
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
