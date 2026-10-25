package androidx.constraintlayout.widget;

import ILil.p045lLi1LL.ILil.I1I;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public View f4937I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4938ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f2538IL;

    public Placeholder(Context context) {
        super(context);
        this.f4938ILil = -1;
        this.f4937I1I = null;
        this.f2538IL = 4;
        IL1Iii(null);
    }

    public void I1I(ConstraintLayout constraintLayout) {
        if (this.f4938ILil == -1 && !isInEditMode()) {
            setVisibility(this.f2538IL);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f4938ILil);
        this.f4937I1I = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.LayoutParams) viewFindViewById.getLayoutParams()).f2514ili11 = true;
            this.f4937I1I.setVisibility(0);
            setVisibility(0);
        }
    }

    public final void IL1Iii(AttributeSet attributeSet) {
        super.setVisibility(this.f2538IL);
        this.f4938ILil = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, I1I.ConstraintLayout_placeholder);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == I1I.ConstraintLayout_placeholder_content) {
                    this.f4938ILil = typedArrayObtainStyledAttributes.getResourceId(index, this.f4938ILil);
                } else if (index == I1I.ConstraintLayout_placeholder_emptyVisibility) {
                    this.f2538IL = typedArrayObtainStyledAttributes.getInt(index, this.f2538IL);
                }
            }
        }
    }

    public void ILil(ConstraintLayout constraintLayout) {
        if (this.f4937I1I == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4937I1I.getLayoutParams();
        layoutParams2.l1Lll.m2648iILiiLl(0);
        layoutParams.l1Lll.ILI1Ll(layoutParams2.l1Lll.m2629L111());
        layoutParams.l1Lll.m87iI(layoutParams2.l1Lll.m2653lIlii());
        layoutParams2.l1Lll.m2648iILiiLl(8);
    }

    public View getContent() {
        return this.f4937I1I;
    }

    public int getEmptyVisibility() {
        return this.f2538IL;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM);
            Paint paint = new Paint();
            paint.setARGB(255, TbsListener.ErrorCode.ROM_NOT_ENOUGH, TbsListener.ErrorCode.ROM_NOT_ENOUGH, TbsListener.ErrorCode.ROM_NOT_ENOUGH);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View viewFindViewById;
        if (this.f4938ILil == i) {
            return;
        }
        View view = this.f4937I1I;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f4937I1I.getLayoutParams()).f2514ili11 = false;
            this.f4937I1I = null;
        }
        this.f4938ILil = i;
        if (i == -1 || (viewFindViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.f2538IL = i;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4938ILil = -1;
        this.f4937I1I = null;
        this.f2538IL = 4;
        IL1Iii(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4938ILil = -1;
        this.f4937I1I = null;
        this.f2538IL = 4;
        IL1Iii(attributeSet);
    }
}
