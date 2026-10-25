package androidx.core.app;

import ILil.iIi1.IL1Iii;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(IL1Iii iL1Iii) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f4966IL1Iii = (IconCompat) iL1Iii.m2474lL(remoteActionCompat.f4966IL1Iii, 1);
        remoteActionCompat.f4967ILil = iL1Iii.m2460Ll1(remoteActionCompat.f4967ILil, 2);
        remoteActionCompat.f4965I1I = iL1Iii.m2460Ll1(remoteActionCompat.f4965I1I, 3);
        remoteActionCompat.f2557IL = (PendingIntent) iL1Iii.m2469lIlii(remoteActionCompat.f2557IL, 4);
        remoteActionCompat.f4968Ilil = iL1Iii.m2457IiL(remoteActionCompat.f4968Ilil, 5);
        remoteActionCompat.f2558lLi1LL = iL1Iii.m2457IiL(remoteActionCompat.f2558lLi1LL, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, IL1Iii iL1Iii) {
        iL1Iii.llliI(false, false);
        iL1Iii.m2465ill(remoteActionCompat.f4966IL1Iii, 1);
        iL1Iii.m2458L111(remoteActionCompat.f4967ILil, 2);
        iL1Iii.m2458L111(remoteActionCompat.f4965I1I, 3);
        iL1Iii.m2466l1IIi1(remoteActionCompat.f2557IL, 4);
        iL1Iii.m24771(remoteActionCompat.f4968Ilil, 5);
        iL1Iii.m24771(remoteActionCompat.f2558lLi1LL, 6);
    }
}
