package ILil.p046il.IL1Iii;

import ILil.p028IiL.p029ILl.I11L;
import ILil.p028IiL.p029ILl.LL1IL.IL;
import ILil.p028IiL.p029ILl.LL1IL.lLi1LL;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p065Ilil.iIi1;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExploreByTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii extends ILil.p028IiL.p029ILl.IL1Iii {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final ILil.丨il.IL1Iii.ILil.IL1Iii<ILil.p028IiL.p029ILl.LL1IL.I1I> NODE_ADAPTER = new C0588IL1Iii();
    private static final ILil.p046il.IL1Iii.ILil.InterfaceC0589ILil<iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I>, ILil.p028IiL.p029ILl.LL1IL.I1I> SPARSE_VALUES_ADAPTER = new ILil();
    private final View mHost;
    private final AccessibilityManager mManager;
    private I1I mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    public int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    public class I1I extends IL {
        public I1I() {
        }

        @Override // ILil.p028IiL.p029ILl.LL1IL.IL
        public ILil.p028IiL.p029ILl.LL1IL.I1I I1I(int i) {
            int i2 = i == 2 ? IL1Iii.this.mAccessibilityFocusedVirtualViewId : IL1Iii.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return IL1Iii(i2);
        }

        @Override // ILil.p028IiL.p029ILl.LL1IL.IL
        public ILil.p028IiL.p029ILl.LL1IL.I1I IL1Iii(int i) {
            return ILil.p028IiL.p029ILl.LL1IL.I1I.m2044L11(IL1Iii.this.obtainAccessibilityNodeInfo(i));
        }

        @Override // ILil.p028IiL.p029ILl.LL1IL.IL
        public boolean Ilil(int i, int i2, Bundle bundle) {
            return IL1Iii.this.performAction(i, i2, bundle);
        }
    }

    /* JADX INFO: renamed from: ILil.丨il.IL1Iii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    public static class C0588IL1Iii implements ILil.丨il.IL1Iii.ILil.IL1Iii<ILil.p028IiL.p029ILl.LL1IL.I1I> {
        @Override // ILil.丨il.IL1Iii.ILil.IL1Iii
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void IL1Iii(ILil.p028IiL.p029ILl.LL1IL.I1I i1i, Rect rect) {
            i1i.m2060Ll1(rect);
        }
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    public static class ILil implements ILil.p046il.IL1Iii.ILil.InterfaceC0589ILil<iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I>, ILil.p028IiL.p029ILl.LL1IL.I1I> {
        @Override // ILil.p046il.IL1Iii.ILil.InterfaceC0589ILil
        /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
        public ILil.p028IiL.p029ILl.LL1IL.I1I IL1Iii(iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I> iii1, int i) {
            return iii1.m1958ILl(i);
        }

        @Override // ILil.p046il.IL1Iii.ILil.InterfaceC0589ILil
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int ILil(iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I> iii1) {
            return iii1.m1963lIiI();
        }
    }

    public IL1Iii(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (iIlLiL.I11L(view) == 0) {
            iIlLiL.m72LL(view, 1);
        }
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null);
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        return i != -1 ? createEventForChild(i, i2) : createEventForHost(i2);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        ILil.p028IiL.p029ILl.LL1IL.I1I i1iObtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        accessibilityEventObtain.getText().add(i1iObtainAccessibilityNodeInfo.m2086lL());
        accessibilityEventObtain.setContentDescription(i1iObtainAccessibilityNodeInfo.m2077llL1ii());
        accessibilityEventObtain.setScrollable(i1iObtainAccessibilityNodeInfo.m2061L1l());
        accessibilityEventObtain.setPassword(i1iObtainAccessibilityNodeInfo.m2072l1IIi1());
        accessibilityEventObtain.setEnabled(i1iObtainAccessibilityNodeInfo.m2055L111());
        accessibilityEventObtain.setChecked(i1iObtainAccessibilityNodeInfo.m2075lIII());
        onPopulateEventForVirtualView(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(i1iObtainAccessibilityNodeInfo.Lil());
        lLi1LL.I1I(accessibilityEventObtain, this.mHost, i);
        accessibilityEventObtain.setPackageName(this.mHost.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private ILil.p028IiL.p029ILl.LL1IL.I1I createNodeForChild(int i) {
        ILil.p028IiL.p029ILl.LL1IL.I1I i1iM2046ill = ILil.p028IiL.p029ILl.LL1IL.I1I.m2046ill();
        i1iM2046ill.m2082i11i(true);
        i1iM2046ill.m66lL(true);
        i1iM2046ill.m2056LIl(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        i1iM2046ill.m2050ILLIi(rect);
        i1iM2046ill.m2080li11(rect);
        i1iM2046ill.LI11(this.mHost);
        onPopulateNodeForVirtualView(i, i1iM2046ill);
        if (i1iM2046ill.m2086lL() == null && i1iM2046ill.m2077llL1ii() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        i1iM2046ill.m2060Ll1(this.mTempParentRect);
        if (this.mTempParentRect.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iM2085il = i1iM2046ill.m2085il();
        if ((iM2085il & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iM2085il & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        i1iM2046ill.m2083i11LL(this.mHost.getContext().getPackageName());
        i1iM2046ill.m2071iILiiLl(this.mHost, i);
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            i1iM2046ill.m2063iI1iI(true);
            i1iM2046ill.IL1Iii(128);
        } else {
            i1iM2046ill.m2063iI1iI(false);
            i1iM2046ill.IL1Iii(64);
        }
        boolean z = this.mKeyboardFocusedVirtualViewId == i;
        if (z) {
            i1iM2046ill.IL1Iii(2);
        } else if (i1iM2046ill.m2088LLlI1()) {
            i1iM2046ill.IL1Iii(1);
        }
        i1iM2046ill.l1Lll(z);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        i1iM2046ill.m2074lIiI(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(rect)) {
            i1iM2046ill.m2060Ll1(this.mTempScreenRect);
            if (i1iM2046ill.f4046ILil != -1) {
                ILil.p028IiL.p029ILl.LL1IL.I1I i1iM2046ill2 = ILil.p028IiL.p029ILl.LL1IL.I1I.m2046ill();
                for (int i2 = i1iM2046ill.f4046ILil; i2 != -1; i2 = i1iM2046ill2.f4046ILil) {
                    i1iM2046ill2.LiL1(this.mHost, -1);
                    i1iM2046ill2.m2050ILLIi(INVALID_PARENT_BOUNDS);
                    onPopulateNodeForVirtualView(i2, i1iM2046ill2);
                    i1iM2046ill2.m2060Ll1(this.mTempParentRect);
                    Rect rect2 = this.mTempScreenRect;
                    Rect rect3 = this.mTempParentRect;
                    rect2.offset(rect3.left, rect3.top);
                }
                i1iM2046ill2.m2049IIiI();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                i1iM2046ill.m2080li11(this.mTempScreenRect);
                if (isVisibleToUser(this.mTempScreenRect)) {
                    i1iM2046ill.m67l(true);
                }
            }
        }
        return i1iM2046ill;
    }

    private ILil.p028IiL.p029ILl.LL1IL.I1I createNodeForHost() {
        ILil.p028IiL.p029ILl.LL1IL.I1I i1iM2047 = ILil.p028IiL.p029ILl.LL1IL.I1I.m2047(this.mHost);
        iIlLiL.iIilII1(this.mHost, i1iM2047);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (i1iM2047.m2051ILl() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            i1iM2047.m2053IL(this.mHost, ((Integer) arrayList.get(i)).intValue());
        }
        return i1iM2047;
    }

    private iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I> iii1 = new iIi1<>();
        for (int i = 0; i < arrayList.size(); i++) {
            iii1.ILL(i, createNodeForChild(i));
        }
        return iii1;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).m2060Ll1(rect);
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int keyToDirection(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean moveFocus(int i, Rect rect) {
        ILil.p028IiL.p029ILl.LL1IL.I1I i1i;
        iIi1<ILil.p028IiL.p029ILl.LL1IL.I1I> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        ILil.p028IiL.p029ILl.LL1IL.I1I i1iIlil = i2 == Integer.MIN_VALUE ? null : allNodes.Ilil(i2);
        if (i == 1 || i == 2) {
            i1i = (ILil.p028IiL.p029ILl.LL1IL.I1I) ILil.p046il.IL1Iii.ILil.m2760IL(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, i1iIlil, i, iIlLiL.m2134l(this.mHost) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                getBoundsInParent(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i, rect2);
            }
            i1i = (ILil.p028IiL.p029ILl.LL1IL.I1I) ILil.p046il.IL1Iii.ILil.I1I(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, i1iIlil, rect2, i);
        }
        return requestKeyboardFocusForVirtualView(i1i != null ? allNodes.m1965il(allNodes.m1961L11I(i1i)) : Integer.MIN_VALUE);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(i);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(i);
        }
        if (i2 != 64) {
            return i2 != 128 ? onPerformActionForVirtualView(i, i2, bundle) : clearAccessibilityFocus(i);
        }
        return requestAccessibilityFocus(i);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return iIlLiL.m2115ili11(this.mHost, i, bundle);
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i2 = this.mAccessibilityFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i2);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.mHoveredVirtualViewId = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            return virtualViewAt != Integer.MIN_VALUE;
        }
        if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
            return false;
        }
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return moveFocus(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iKeyToDirection = keyToDirection(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && moveFocus(iKeyToDirection, null)) {
                        i++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        clickKeyboardFocusedVirtualView();
        return true;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // ILil.p028IiL.p029ILl.IL1Iii
    public IL getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new I1I();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public ILil.p028IiL.p029ILl.LL1IL.I1I obtainAccessibilityNodeInfo(int i) {
        return i == -1 ? createNodeForHost() : createNodeForChild(i);
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    @Override // ILil.p028IiL.p029ILl.IL1Iii
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // ILil.p028IiL.p029ILl.IL1Iii
    public void onInitializeAccessibilityNodeInfo(View view, ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
        super.onInitializeAccessibilityNodeInfo(view, i1i);
        onPopulateNodeForHost(i1i);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(ILil.p028IiL.p029ILl.LL1IL.I1I i1i) {
    }

    public abstract void onPopulateNodeForVirtualView(int i, ILil.p028IiL.p029ILl.LL1IL.I1I i1i);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return i != -1 ? performActionForChild(i, i2, bundle) : performActionForHost(i2, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return I11L.m2022IiL(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(i, 2048);
        ILil.p028IiL.p029ILl.LL1IL.ILil.ILil(accessibilityEventCreateEvent, i2);
        I11L.m2022IiL(parent, this.mHost, accessibilityEventCreateEvent);
    }
}
