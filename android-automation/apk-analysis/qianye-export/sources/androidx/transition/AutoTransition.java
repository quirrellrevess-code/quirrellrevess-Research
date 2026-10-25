package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        m3360lL();
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final void m3360lL() {
        m3377lIlii(1);
        m3379lLi1LL(new Fade(2));
        m3379lLi1LL(new ChangeBounds());
        m3379lLi1LL(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3360lL();
    }
}
