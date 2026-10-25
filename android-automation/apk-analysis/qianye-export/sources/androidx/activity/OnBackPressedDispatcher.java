package androidx.activity;

import ILil.IL1Iii.ILil;
import ILil.p042lIiI.IL;
import ILil.p042lIiI.IiL;
import ILil.p042lIiI.lLi1LL;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Runnable f4741IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ArrayDeque<ILil> f4742ILil = new ArrayDeque<>();

    public class IL1Iii implements ILil.IL1Iii.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ILil f4743IL1Iii;

        public IL1Iii(ILil iLil) {
            this.f4743IL1Iii = iLil;
        }

        @Override // ILil.IL1Iii.IL1Iii
        public void cancel() {
            OnBackPressedDispatcher.this.f4742ILil.remove(this.f4743IL1Iii);
            this.f4743IL1Iii.Ilil(this);
        }
    }

    public class LifecycleOnBackPressedCancellable implements lLi1LL, ILil.IL1Iii.IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ILil.IL1Iii.IL1Iii f4745I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final IL f4746IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ILil f4747ILil;

        public LifecycleOnBackPressedCancellable(IL il, ILil iLil) {
            this.f4746IL1Iii = il;
            this.f4747ILil = iLil;
            il.IL1Iii(this);
        }

        @Override // ILil.p042lIiI.lLi1LL
        public void I1I(IiL iiL, IL.IL1Iii iL1Iii) {
            if (iL1Iii == IL.IL1Iii.ON_START) {
                this.f4745I1I = OnBackPressedDispatcher.this.ILil(this.f4747ILil);
                return;
            }
            if (iL1Iii != IL.IL1Iii.ON_STOP) {
                if (iL1Iii == IL.IL1Iii.ON_DESTROY) {
                    cancel();
                }
            } else {
                ILil.IL1Iii.IL1Iii iL1Iii2 = this.f4745I1I;
                if (iL1Iii2 != null) {
                    iL1Iii2.cancel();
                }
            }
        }

        @Override // ILil.IL1Iii.IL1Iii
        public void cancel() {
            this.f4746IL1Iii.I1I(this);
            this.f4747ILil.Ilil(this);
            ILil.IL1Iii.IL1Iii iL1Iii = this.f4745I1I;
            if (iL1Iii != null) {
                iL1Iii.cancel();
                this.f4745I1I = null;
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f4741IL1Iii = runnable;
    }

    public void I1I() {
        Iterator<ILil> itDescendingIterator = this.f4742ILil.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            ILil next = itDescendingIterator.next();
            if (next.I1I()) {
                next.ILil();
                return;
            }
        }
        Runnable runnable = this.f4741IL1Iii;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void IL1Iii(IiL iiL, ILil iLil) {
        IL lifecycle = iiL.getLifecycle();
        if (lifecycle.ILil() == IL.ILil.DESTROYED) {
            return;
        }
        iLil.IL1Iii(new LifecycleOnBackPressedCancellable(lifecycle, iLil));
    }

    public ILil.IL1Iii.IL1Iii ILil(ILil iLil) {
        this.f4742ILil.add(iLil);
        IL1Iii iL1Iii = new IL1Iii(iLil);
        iLil.IL1Iii(iL1Iii);
        return iL1Iii;
    }
}
