package androidx.constraintlayout.widget;

import ILil.p045lLi1LL.IL1Iii.ILL.ILL;
import ILil.p045lLi1LL.ILil.I1I;
import ILil.p045lLi1LL.ILil.ILil;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4925I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int[] f4926ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ILL f4927Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Context f2480IL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public String f2481iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f2482lLi1LL;

    public ConstraintHelper(Context context) {
        super(context);
        this.f4926ILil = new int[32];
        this.f2482lLi1LL = false;
        this.f2480IL = context;
        ILil(null);
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                IL1Iii(str.substring(i));
                return;
            } else {
                IL1Iii(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void I1I(ConstraintLayout constraintLayout) {
    }

    public final void IL1Iii(String str) {
        int iIntValue;
        Object objI1I;
        if (str == null || this.f2480IL == null) {
            return;
        }
        String strTrim = str.trim();
        try {
            iIntValue = ILil.class.getField(strTrim).getInt(null);
        } catch (Exception unused) {
            iIntValue = 0;
        }
        if (iIntValue == 0) {
            iIntValue = this.f2480IL.getResources().getIdentifier(strTrim, "id", this.f2480IL.getPackageName());
        }
        if (iIntValue == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (objI1I = ((ConstraintLayout) getParent()).I1I(0, strTrim)) != null && (objI1I instanceof Integer)) {
            iIntValue = ((Integer) objI1I).intValue();
        }
        if (iIntValue != 0) {
            setTag(iIntValue, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public void ILil(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, I1I.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == I1I.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2481iILLL1 = string;
                    setIds(string);
                }
            }
        }
    }

    public void Ilil(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f2481iILLL1);
        }
        ILL ill = this.f4927Ilil;
        if (ill == null) {
            return;
        }
        ill.lLIL1();
        for (int i = 0; i < this.f4925I1I; i++) {
            View viewIlil = constraintLayout.Ilil(this.f4926ILil[i]);
            if (viewIlil != null) {
                this.f4927Ilil.m2599ILI(constraintLayout.m3144lLi1LL(viewIlil));
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3135IL(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4926ILil, this.f4925I1I);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m3136lLi1LL() {
        if (this.f4927Ilil == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).l1Lll = this.f4927Ilil;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f2482lLi1LL) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f4925I1I = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.f4925I1I + 1;
        int[] iArr = this.f4926ILil;
        if (i2 > iArr.length) {
            this.f4926ILil = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4926ILil;
        int i3 = this.f4925I1I;
        iArr2[i3] = i;
        this.f4925I1I = i3 + 1;
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4926ILil = new int[32];
        this.f2482lLi1LL = false;
        this.f2480IL = context;
        ILil(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4926ILil = new int[32];
        this.f2482lLi1LL = false;
        this.f2480IL = context;
        ILil(attributeSet);
    }
}
