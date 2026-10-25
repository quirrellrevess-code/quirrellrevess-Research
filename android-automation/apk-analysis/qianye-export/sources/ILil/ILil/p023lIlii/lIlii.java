package ILil.ILil.p023lIlii;

import ILil.ILil.p020ILl.IL1Iii.I1I;
import ILil.p028IiL.Lil.iILLL1;
import ILil.p028IiL.p029ILl.llliI;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: DropDownListView.java */
/* JADX INFO: loaded from: classes.dex */
public class lIlii extends ListView {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3820I1I;
    public boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Rect f3821ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public iILLL1 f1404ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3822Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1405IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Field f1406IiL;
    public ILil Lil;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean f1407Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public IL1Iii f1408L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1409iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public llliI f1410lIiI;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1411lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f1412il;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.lI丨lii$IL1Iii */
    /* JADX INFO: compiled from: DropDownListView.java */
    public static class IL1Iii extends I1I {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f3823ILil;

        public IL1Iii(Drawable drawable) {
            super(drawable);
            this.f3823ILil = true;
        }

        public void IL1Iii(boolean z) {
            this.f3823ILil = z;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.I1I, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f3823ILil) {
                super.draw(canvas);
            }
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.I1I, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f3823ILil) {
                super.setHotspot(f, f2);
            }
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.I1I, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f3823ILil) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.I1I, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f3823ILil) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.I1I, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f3823ILil) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.lI丨lii$ILil */
    /* JADX INFO: compiled from: DropDownListView.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        public void IL1Iii() {
            lIlii lilii = lIlii.this;
            lilii.Lil = null;
            lilii.removeCallbacks(this);
        }

        public void ILil() {
            lIlii.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            lIlii lilii = lIlii.this;
            lilii.Lil = null;
            lilii.drawableStateChanged();
        }
    }

    public lIlii(Context context, boolean z) {
        super(context, null, ILil.ILil.IL1Iii.dropDownListViewStyle);
        this.f3821ILil = new Rect();
        this.f3820I1I = 0;
        this.f1405IL = 0;
        this.f3822Ilil = 0;
        this.f1411lLi1LL = 0;
        this.ILL = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1406IiL = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        IL1Iii iL1Iii = this.f1408L11I;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(z);
        }
    }

    public final void I1I(Canvas canvas) {
        Drawable selector;
        if (this.f3821ILil.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f3821ILil);
        selector.draw(canvas);
    }

    public final void IL1Iii() {
        this.f1407Ll1 = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1409iILLL1 - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        llliI lllii = this.f1410lIiI;
        if (lllii != null) {
            lllii.ILil();
            this.f1410lIiI = null;
        }
    }

    public final void ILL() {
        Drawable selector = getSelector();
        if (selector != null && m1821il() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public final void ILil(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    public boolean Ilil(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        iILLL1 iilll1;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z2 = false;
                    z = true;
                } else {
                    z2 = false;
                    z = false;
                }
                if (z || z2) {
                    IL1Iii();
                }
                if (z) {
                    if (this.f1404ILl == null) {
                        this.f1404ILl = new iILLL1(this);
                    }
                    this.f1404ILl.m2206lIiI(true);
                    this.f1404ILl.onTouch(this, motionEvent);
                } else {
                    iilll1 = this.f1404ILl;
                    if (iilll1 != null) {
                        iilll1.m2206lIiI(false);
                    }
                }
                return z;
            }
            z = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        if (iFindPointerIndex < 0) {
            z2 = false;
            z = false;
        } else {
            int x = (int) motionEvent.getX(iFindPointerIndex);
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x, y);
            if (iPointToPosition == -1) {
                z2 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                m1818L11I(childAt, iPointToPosition, x, y);
                if (actionMasked == 1) {
                    ILil(childAt, iPointToPosition);
                }
                z2 = false;
                z = true;
            }
        }
        if (z) {
            IL1Iii();
        } else {
            IL1Iii();
        }
        if (z) {
            if (this.f1404ILl == null) {
                this.f1404ILl = new iILLL1(this);
            }
            this.f1404ILl.m2206lIiI(true);
            this.f1404ILl.onTouch(this, motionEvent);
        } else {
            iilll1 = this.f1404ILl;
            if (iilll1 != null) {
                iilll1.m2206lIiI(false);
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int m1816IL(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < count) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, Videoio.CAP_OPENNI_IMAGE_GENERATOR) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i6 <= i5 || i8 <= 0 || measuredHeight == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i6 >= i5) {
                i8 = measuredHeight;
            }
            i6++;
        }
        return measuredHeight;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final void m1817IiL(int i, View view, float f, float f2) {
        m1819iILLL1(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        ILil.p028IiL.p033iILLL1.ILL.IL1Iii.ILL(selector, f, f2);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m1818L11I(View view, int i, float f, float f2) {
        View childAt;
        this.f1407Ll1 = true;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f1409iILLL1;
        if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1409iILLL1 = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (i2 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m1817IiL(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        I1I(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.Lil != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        ILL();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.ILL || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.ILL || super.hasWindowFocus();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m1819iILLL1(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m1820lLi1LL(i, view);
        if (z) {
            Rect rect = this.f3821ILil;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.ILL(selector, fExactCenterX, fExactCenterY);
        }
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.ILL || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.ILL && this.f1412il) || super.isInTouchMode();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m1820lLi1LL(int i, View view) {
        Rect rect = this.f3821ILil;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f3820I1I;
        rect.top -= this.f1405IL;
        rect.right += this.f3822Ilil;
        rect.bottom += this.f1411lLi1LL;
        try {
            boolean z = this.f1406IiL.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1406IiL.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.Lil = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.Lil == null) {
            ILil iLil = new ILil();
            this.Lil = iLil;
            iLil.ILil();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                ILL();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1409iILLL1 = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ILil iLil = this.Lil;
        if (iLil != null) {
            iLil.IL1Iii();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f1412il = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        IL1Iii iL1Iii = drawable != null ? new IL1Iii(drawable) : null;
        this.f1408L11I = iL1Iii;
        super.setSelector(iL1Iii);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3820I1I = rect.left;
        this.f1405IL = rect.top;
        this.f3822Ilil = rect.right;
        this.f1411lLi1LL = rect.bottom;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final boolean m1821il() {
        return this.f1407Ll1;
    }
}
