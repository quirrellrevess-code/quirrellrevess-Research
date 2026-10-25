package androidx.appcompat.widget;

import ILil.ILil.p023lIlii.lIiI;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lIiI f4870ILil;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lIiI liii = new lIiI(this);
        this.f4870ILil = liii;
        liii.m1806lIiI(attributeSet, i);
    }
}
