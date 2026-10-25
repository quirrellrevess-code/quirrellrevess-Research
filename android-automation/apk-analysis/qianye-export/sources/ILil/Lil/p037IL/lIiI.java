package ILil.Lil.p037IL;

import ILil.p028IiL.p029ILl.LL1IL.I1I;
import ILil.p028IiL.p029ILl.LL1IL.IL;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: ILil.Lil.I丨L.lIi丨I, reason: invalid class name */
/* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class lIiI extends ILil.p028IiL.p029ILl.IL1Iii {
    private final IL1Iii mItemDelegate;
    public final RecyclerView mRecyclerView;

    /* JADX INFO: renamed from: ILil.Lil.I丨L.lIi丨I$IL1Iii */
    /* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class IL1Iii extends ILil.p028IiL.p029ILl.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final lIiI f4287IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Map<View, ILil.p028IiL.p029ILl.IL1Iii> f4288ILil = new WeakHashMap();

        public IL1Iii(lIiI liii) {
            this.f4287IL1Iii = liii;
        }

        public ILil.p028IiL.p029ILl.IL1Iii IL1Iii(View view) {
            return this.f4288ILil.remove(view);
        }

        public void ILil(View view) {
            ILil.p028IiL.p029ILl.IL1Iii iL1IiiILL = iIlLiL.ILL(view);
            if (iL1IiiILL == null || iL1IiiILL == this) {
                return;
            }
            this.f4288ILil.put(view, iL1IiiILL);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            return iL1Iii != null ? iL1Iii.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public IL getAccessibilityNodeProvider(View view) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            return iL1Iii != null ? iL1Iii.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            if (iL1Iii != null) {
                iL1Iii.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onInitializeAccessibilityNodeInfo(View view, I1I i1i) {
            if (this.f4287IL1Iii.shouldIgnore() || this.f4287IL1Iii.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, i1i);
                return;
            }
            this.f4287IL1Iii.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, i1i);
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            if (iL1Iii != null) {
                iL1Iii.onInitializeAccessibilityNodeInfo(view, i1i);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, i1i);
            }
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            if (iL1Iii != null) {
                iL1Iii.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(viewGroup);
            return iL1Iii != null ? iL1Iii.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (this.f4287IL1Iii.shouldIgnore() || this.f4287IL1Iii.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            if (iL1Iii != null) {
                if (iL1Iii.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            return this.f4287IL1Iii.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void sendAccessibilityEvent(View view, int i) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            if (iL1Iii != null) {
                iL1Iii.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        @Override // ILil.p028IiL.p029ILl.IL1Iii
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            ILil.p028IiL.p029ILl.IL1Iii iL1Iii = this.f4288ILil.get(view);
            if (iL1Iii != null) {
                iL1Iii.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public lIiI(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        ILil.p028IiL.p029ILl.IL1Iii itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof IL1Iii)) {
            this.mItemDelegate = new IL1Iii(this);
        } else {
            this.mItemDelegate = (IL1Iii) itemDelegate;
        }
    }

    public ILil.p028IiL.p029ILl.IL1Iii getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // ILil.p028IiL.p029ILl.IL1Iii
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // ILil.p028IiL.p029ILl.IL1Iii
    public void onInitializeAccessibilityNodeInfo(View view, I1I i1i) {
        super.onInitializeAccessibilityNodeInfo(view, i1i);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(i1i);
    }

    @Override // ILil.p028IiL.p029ILl.IL1Iii
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
