package androidx.transition;

import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import ILil.p044llL1ii.LlLLL;
import ILil.p044llL1ii.lL;
import ILil.p044llL1ii.llliI;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f5192I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public ArrayList<Transition> f5193ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f5194Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2776IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2777lLi1LL;

    public class IL1Iii extends lL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Transition f5195IL1Iii;

        public IL1Iii(TransitionSet transitionSet, Transition transition) {
            this.f5195IL1Iii = transition;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            this.f5195IL1Iii.runAnimators();
            transition.removeListener(this);
        }
    }

    public static class ILil extends lL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public TransitionSet f5196IL1Iii;

        public ILil(TransitionSet transitionSet) {
            this.f5196IL1Iii = transitionSet;
        }

        @Override // androidx.transition.Transition.IiL
        public void I1I(Transition transition) {
            TransitionSet transitionSet = this.f5196IL1Iii;
            int i = transitionSet.f2776IL - 1;
            transitionSet.f2776IL = i;
            if (i == 0) {
                transitionSet.f5194Ilil = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // ILil.p044llL1ii.lL, androidx.transition.Transition.IiL
        public void IL1Iii(Transition transition) {
            TransitionSet transitionSet = this.f5196IL1Iii;
            if (transitionSet.f5194Ilil) {
                return;
            }
            transitionSet.start();
            this.f5196IL1Iii.f5194Ilil = true;
        }
    }

    public TransitionSet() {
        this.f5193ILil = new ArrayList<>();
        this.f5192I1I = true;
        this.f5194Ilil = false;
        this.f2777lLi1LL = 0;
    }

    public final void I11li1() {
        ILil iLil = new ILil(this);
        Iterator<Transition> it = this.f5193ILil.iterator();
        while (it.hasNext()) {
            it.next().addListener(iLil);
        }
        this.f2776IL = this.f5193ILil.size();
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(View view) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public TransitionSet addListener(Transition.IiL iiL) {
        return (TransitionSet) super.addListener(iiL);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: ILL, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeListener(Transition.IiL iiL) {
        return (TransitionSet) super.removeListener(iiL);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(int i) {
        for (int i2 = 0; i2 < this.f5193ILil.size(); i2++) {
            this.f5193ILil.get(i2).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(Class<?> cls) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: Ilil, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(String str) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public TransitionSet addTarget(Class<?> cls) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: Lil, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(String str) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    public TransitionSet LlLI1(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.f5193ILil) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f5193ILil.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(int i) {
        for (int i2 = 0; i2 < this.f5193ILil.size(); i2++) {
            this.f5193ILil.get(i2).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Transition m3374L11I(int i) {
        if (i < 0 || i >= this.f5193ILil.size()) {
            return null;
        }
        return this.f5193ILil.get(i);
    }

    @Override // androidx.transition.Transition
    public void cancel() {
        super.cancel();
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C1 c1) {
        if (isValidTarget(c1.f4477ILil)) {
            for (Transition transition : this.f5193ILil) {
                if (transition.isValidTarget(c1.f4477ILil)) {
                    transition.captureEndValues(c1);
                    c1.f4475I1I.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(C1 c1) {
        super.capturePropagationValues(c1);
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).capturePropagationValues(c1);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C1 c1) {
        if (isValidTarget(c1.f4477ILil)) {
            for (Transition transition : this.f5193ILil) {
                if (transition.isValidTarget(c1.f4477ILil)) {
                    transition.captureStartValues(c1);
                    c1.f4475I1I.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup viewGroup, LlLLL llLLL, LlLLL llLLL2, ArrayList<C1> arrayList, ArrayList<C1> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.f5193ILil.get(i);
            if (startDelay > 0 && (this.f5192I1I || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, llLLL, llLLL2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).forceToEnd(viewGroup);
        }
    }

    public TransitionSet iIi1(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: iIlLiL, reason: merged with bridge method [inline-methods] */
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m3375iILLL1(Transition transition) {
        this.f5193ILil.add(transition);
        transition.mParent = this;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(View view) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public TransitionSet m3377lIlii(int i) {
        if (i == 0) {
            this.f5192I1I = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.f5192I1I = false;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.f2777lLi1LL |= 1;
        ArrayList<Transition> arrayList = this.f5193ILil;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f5193ILil.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public TransitionSet m3379lLi1LL(Transition transition) {
        m3375iILLL1(transition);
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.f2777lLi1LL & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.f2777lLi1LL & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.f2777lLi1LL & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.f2777lLi1LL & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.f5193ILil.isEmpty()) {
            start();
            end();
            return;
        }
        I11li1();
        if (this.f5192I1I) {
            Iterator<Transition> it = this.f5193ILil.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
            return;
        }
        for (int i = 1; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i - 1).addListener(new IL1Iii(this, this.f5193ILil.get(i)));
        }
        Transition transition = this.f5193ILil.get(0);
        if (transition != null) {
            transition.runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setDuration(long j) {
        LlLI1(j);
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.iILLL1 iilll1) {
        super.setEpicenterCallback(iilll1);
        this.f2777lLi1LL |= 8;
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).setEpicenterCallback(iilll1);
        }
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f2777lLi1LL |= 4;
        if (this.f5193ILil != null) {
            for (int i = 0; i < this.f5193ILil.size(); i++) {
                this.f5193ILil.get(i).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(llliI lllii) {
        super.setPropagation(lllii);
        this.f2777lLi1LL |= 2;
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            this.f5193ILil.get(i).setPropagation(lllii);
        }
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setSceneRoot(ViewGroup viewGroup) {
        iIi1(viewGroup);
        return this;
    }

    @Override // androidx.transition.Transition
    public String toString(String str) {
        String string = super.toString(str);
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append("\n");
            sb.append(this.f5193ILil.get(i).toString(str + "  "));
            string = sb.toString();
        }
        return string;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int m3380il() {
        return this.f5193ILil.size();
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public Transition mo3370clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo3370clone();
        transitionSet.f5193ILil = new ArrayList<>();
        int size = this.f5193ILil.size();
        for (int i = 0; i < size; i++) {
            transitionSet.m3375iILLL1(this.f5193ILil.get(i).mo3370clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5193ILil = new ArrayList<>();
        this.f5192I1I = true;
        this.f5194Ilil = false;
        this.f2777lLi1LL = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f1849iILLL1);
        m3377lIlii(IiL.m2316iILLL1(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f5193ILil.size(); i2++) {
            this.f5193ILil.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.f5193ILil.size(); i++) {
            this.f5193ILil.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }
}
