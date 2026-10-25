package androidx.constraintlayout.widget;

import ILil.p045lLi1LL.ILil.I1I;
import ILil.p045lLi1LL.ILil.IL1Iii;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public IL1Iii f4936ILil;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public final void I1I(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public IL1Iii getConstraintSet() {
        if (this.f4936ILil == null) {
            this.f4936ILil = new IL1Iii();
        }
        this.f4936ILil.ILil(this);
        return this.f4936ILil;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        I1I(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        I1I(attributeSet);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float ILI1Ll;
        public float LI11;

        /* JADX INFO: renamed from: LL */
        public float f41LL;
        public float LiL1;
        public float Liil1L1l;

        /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
        public float f2532iIl1il;

        /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
        public float f2533iI1LI;
        public float ill1LI1l;

        /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
        public float f2534i1I1I1l;

        /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
        public float f2535iILiiLl;

        /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
        public boolean f2536lIIiIlL;

        /* JADX INFO: renamed from: 丨1 */
        public float f421;

        /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
        public float f2537i11LL;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.ill1LI1l = 1.0f;
            this.f2536lIIiIlL = false;
            this.f2537i11LL = 0.0f;
            this.f2532iIl1il = 0.0f;
            this.LI11 = 0.0f;
            this.LiL1 = 0.0f;
            this.Liil1L1l = 1.0f;
            this.f41LL = 1.0f;
            this.f2534i1I1I1l = 0.0f;
            this.f2533iI1LI = 0.0f;
            this.f421 = 0.0f;
            this.f2535iILiiLl = 0.0f;
            this.ILI1Ll = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.ill1LI1l = 1.0f;
            this.f2536lIIiIlL = false;
            this.f2537i11LL = 0.0f;
            this.f2532iIl1il = 0.0f;
            this.LI11 = 0.0f;
            this.LiL1 = 0.0f;
            this.Liil1L1l = 1.0f;
            this.f41LL = 1.0f;
            this.f2534i1I1I1l = 0.0f;
            this.f2533iI1LI = 0.0f;
            this.f421 = 0.0f;
            this.f2535iILiiLl = 0.0f;
            this.ILI1Ll = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I1I.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == I1I.ConstraintSet_android_alpha) {
                    this.ill1LI1l = typedArrayObtainStyledAttributes.getFloat(index, this.ill1LI1l);
                } else if (index == I1I.ConstraintSet_android_elevation) {
                    this.f2537i11LL = typedArrayObtainStyledAttributes.getFloat(index, this.f2537i11LL);
                    this.f2536lIIiIlL = true;
                } else if (index == I1I.ConstraintSet_android_rotationX) {
                    this.LI11 = typedArrayObtainStyledAttributes.getFloat(index, this.LI11);
                } else if (index == I1I.ConstraintSet_android_rotationY) {
                    this.LiL1 = typedArrayObtainStyledAttributes.getFloat(index, this.LiL1);
                } else if (index == I1I.ConstraintSet_android_rotation) {
                    this.f2532iIl1il = typedArrayObtainStyledAttributes.getFloat(index, this.f2532iIl1il);
                } else if (index == I1I.ConstraintSet_android_scaleX) {
                    this.Liil1L1l = typedArrayObtainStyledAttributes.getFloat(index, this.Liil1L1l);
                } else if (index == I1I.ConstraintSet_android_scaleY) {
                    this.f41LL = typedArrayObtainStyledAttributes.getFloat(index, this.f41LL);
                } else if (index == I1I.ConstraintSet_android_transformPivotX) {
                    this.f2534i1I1I1l = typedArrayObtainStyledAttributes.getFloat(index, this.f2534i1I1I1l);
                } else if (index == I1I.ConstraintSet_android_transformPivotY) {
                    this.f2533iI1LI = typedArrayObtainStyledAttributes.getFloat(index, this.f2533iI1LI);
                } else if (index == I1I.ConstraintSet_android_translationX) {
                    this.f421 = typedArrayObtainStyledAttributes.getFloat(index, this.f421);
                } else if (index == I1I.ConstraintSet_android_translationY) {
                    this.f2535iILiiLl = typedArrayObtainStyledAttributes.getFloat(index, this.f2535iILiiLl);
                } else if (index == I1I.ConstraintSet_android_translationZ) {
                    this.f421 = typedArrayObtainStyledAttributes.getFloat(index, this.ILI1Ll);
                }
            }
        }
    }
}
