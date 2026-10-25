package androidx.appcompat.widget;

import ILil.ILil.p023lIlii.iIi1;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements iIi1 {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public iIi1.IL1Iii f4876ILil;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        iIi1.IL1Iii iL1Iii = this.f4876ILil;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // ILil.ILil.p023lIlii.iIi1
    public void setOnFitSystemWindowsListener(iIi1.IL1Iii iL1Iii) {
        this.f4876ILil = iL1Iii;
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
