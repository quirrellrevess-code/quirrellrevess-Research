package ILil.p039L11I.IL1Iii;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ResourceCursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I1I extends IL1Iii {
    public int ILL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public LayoutInflater f1779Ll1;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1780il;

    @Deprecated
    public I1I(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.ILL = i;
        this.f1780il = i;
        this.f1779Ll1 = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii
    /* JADX INFO: renamed from: I丨iL */
    public View mo1764IiL(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1779Ll1.inflate(this.f1780il, viewGroup, false);
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public View mo2450iILLL1(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1779Ll1.inflate(this.ILL, viewGroup, false);
    }
}
