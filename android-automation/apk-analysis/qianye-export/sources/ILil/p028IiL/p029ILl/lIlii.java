package ILil.p028IiL.p029ILl;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: PointerIconCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Object f4072IL1Iii;

    public lIlii(Object obj) {
        this.f4072IL1Iii = obj;
    }

    public static lIlii ILil(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new lIlii(PointerIcon.getSystemIcon(context, i)) : new lIlii(null);
    }

    public Object IL1Iii() {
        return this.f4072IL1Iii;
    }
}
