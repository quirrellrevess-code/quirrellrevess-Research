package ILil.p028IiL.p029ILl.LL1IL;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: AccessibilityClickableSpanCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class IL1Iii extends ClickableSpan {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final I1I f4053I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final int f4054ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f1625IL;

    public IL1Iii(int i, I1I i1i, int i2) {
        this.f4054ILil = i;
        this.f4053I1I = i1i;
        this.f1625IL = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4054ILil);
        this.f4053I1I.m2058LlIl(this.f1625IL, bundle);
    }
}
