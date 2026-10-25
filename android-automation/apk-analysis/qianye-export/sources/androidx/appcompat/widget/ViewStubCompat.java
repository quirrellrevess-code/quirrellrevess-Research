package androidx.appcompat.widget;

import ILil.ILil.ILL;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4920I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4921ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public LayoutInflater f4922Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public WeakReference<View> f2475IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public IL1Iii f2476lLi1LL;

    public interface IL1Iii {
        void IL1Iii(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View IL1Iii() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f4921ILil == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f4922Ilil;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f4921ILil, viewGroup, false);
        int i = this.f4920I1I;
        if (i != -1) {
            viewInflate.setId(i);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f2475IL = new WeakReference<>(viewInflate);
        IL1Iii iL1Iii = this.f2476lLi1LL;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(this, viewInflate);
        }
        return viewInflate;
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f4920I1I;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f4922Ilil;
    }

    public int getLayoutResource() {
        return this.f4921ILil;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f4920I1I = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f4922Ilil = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f4921ILil = i;
    }

    public void setOnInflateListener(IL1Iii iL1Iii) {
        this.f2476lLi1LL = iL1Iii;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f2475IL;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            IL1Iii();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4921ILil = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.ViewStubCompat, i, 0);
        this.f4920I1I = typedArrayObtainStyledAttributes.getResourceId(ILL.ViewStubCompat_android_inflatedId, -1);
        this.f4921ILil = typedArrayObtainStyledAttributes.getResourceId(ILL.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(ILL.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
