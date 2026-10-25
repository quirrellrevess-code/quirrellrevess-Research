package ILil.p028IiL.p029ILl;

import ILil.p028IiL.I1I;
import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: renamed from: ILil.I丨iL.IL丨丨l.丨lL, reason: invalid class name */
/* JADX INFO: compiled from: ViewGroupCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class lL {
    public static boolean IL1Iii(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(I1I.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && iIlLiL.llI(viewGroup) == null) ? false : true;
    }
}
