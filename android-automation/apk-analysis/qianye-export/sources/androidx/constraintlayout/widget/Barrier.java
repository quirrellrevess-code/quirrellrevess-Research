package androidx.constraintlayout.widget;

import ILil.p045lLi1LL.IL1Iii.ILL.ILil;
import ILil.p045lLi1LL.ILil.I1I;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public int f2477IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2478L11I;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ILil f2479il;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void ILil(AttributeSet attributeSet) {
        super.ILil(attributeSet);
        this.f2479il = new ILil();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, I1I.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == I1I.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == I1I.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2479il.m2602iI1L1Ll(typedArrayObtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f4927Ilil = this.f2479il;
        m3136lLi1LL();
    }

    public int getType() {
        return this.f2477IiL;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2479il.m2602iI1L1Ll(z);
    }

    public void setType(int i) {
        this.f2477IiL = i;
        this.f2478L11I = i;
        if (Build.VERSION.SDK_INT >= 17) {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i2 = this.f2477IiL;
                if (i2 == 5) {
                    this.f2478L11I = 1;
                } else if (i2 == 6) {
                    this.f2478L11I = 0;
                }
            } else {
                int i3 = this.f2477IiL;
                if (i3 == 5) {
                    this.f2478L11I = 0;
                } else if (i3 == 6) {
                    this.f2478L11I = 1;
                }
            }
        } else if (i == 5) {
            this.f2478L11I = 0;
        } else if (i == 6) {
            this.f2478L11I = 1;
        }
        this.f2479il.m2603iLiLI(this.f2478L11I);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }
}
