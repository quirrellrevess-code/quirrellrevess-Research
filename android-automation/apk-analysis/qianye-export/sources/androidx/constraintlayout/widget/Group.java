package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void I1I(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.l1Lll.ILI1Ll(0);
        layoutParams.l1Lll.m87iI(0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void ILil(AttributeSet attributeSet) {
        super.ILil(attributeSet);
        this.f2482lLi1LL = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void Ilil(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i = 0; i < this.f4925I1I; i++) {
            View viewIlil = constraintLayout.Ilil(this.f4926ILil[i]);
            if (viewIlil != null) {
                viewIlil.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewIlil.setElevation(elevation);
                }
            }
        }
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
