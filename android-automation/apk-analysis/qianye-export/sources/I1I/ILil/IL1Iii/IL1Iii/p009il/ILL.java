package I1I.ILil.IL1Iii.IL1Iii.p009il;

import I1I.IL1Iii;
import I1I.ILil.IL1Iii.IL1Iii.I1I;
import I1I.ILil.IL1Iii.IL1Iii.IL;
import I1I.ILil.IL1Iii.IL1Iii.IiL;
import I1I.ILil.IL1Iii.IL1Iii.iILLL1;
import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: NubiaImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL implements IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3405IL1Iii;

    public ILL(Context context) {
        this.f3405IL1Iii = context;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean IL1Iii() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // I1I.ILil.IL1Iii.IL1Iii.IL
    public void ILil(I1I i1i) {
        if (this.f3405IL1Iii == null || i1i == null) {
            return;
        }
        if (!IL1Iii()) {
            String strIL1Iii = IL1Iii.IL1Iii(new byte[]{45, 8, 13, 27, 16, 67, 23, 22, 17, 13, 66, 68, 17, 70, 32, 12, 84, 66, 13, 15, 5, 66, 1, 0, 76, 86, 65, 3, 94, 84, 66, 7, 3, 13, 70, 85, 66, 0, 14, 16, 16, 126, 23, 4, 8, 3}, IL1Iii.IL1Iii(new byte[]{87, 87, 82, 84, 6, 1}, IL1Iii.IL1Iii(new byte[]{1, 83, 87, 1, 6, 5}, "4bd704")));
            IiL.IL1Iii(strIL1Iii);
            i1i.ILil(new iILLL1(strIL1Iii));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f3405IL1Iii.getContentResolver().acquireContentProviderClient(Uri.parse(IL1Iii.IL1Iii(new byte[]{84, 90, 90, 76, 92, 88, 67, 15, 27, 23, 90, 88, 25, 91, 65, 90, 80, 87, 25, 92, 80, 93, 87, 66, 94, 65, 77, 23, 80, 82, 82, 91, 64, 81, 77, 79}, IL1Iii.IL1Iii(new byte[]{82, 4, 3, 9, 9, 0}, IL1Iii.IL1Iii(new byte[]{86, 5, 81, 1, 6, 82}, "34f06d")))));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call(IL1Iii.IL1Iii(new byte[]{87, 0, 21, 41, 119, 127, 116}, IL1Iii.IL1Iii(new byte[]{4, 93, 89, 7, 85, 83}, IL1Iii.IL1Iii(new byte[]{0, 12, 10, 5, 83, 7}, "442d0b"))), null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new iILLL1(IL1Iii.IL1Iii(new byte[]{121, 121, 124, 39, 19, 16, 67, 93, 71, 26, 19, 7, 87, 81, 89, 6, 87, 91, 22, 90, 64, 13, 87, 13, 83, 24, 92, 16, 19, 15, 67, 84, 89}, IL1Iii.IL1Iii(new byte[]{14, 0, 80, 84, 87, 4}, IL1Iii.IL1Iii(new byte[]{9, 9, 3, 4, 87, 82}, "11f337"))));
            }
            String string = bundleCall.getInt(IL1Iii.IL1Iii(new byte[]{5, 14, 87, 83}, IL1Iii.IL1Iii(new byte[]{87, 85, 86, 85, 91, 0}, IL1Iii.IL1Iii(new byte[]{6, 80, 83, 1, 88, 80}, "7d6bad"))), -1) == 0 ? bundleCall.getString(IL1Iii.IL1Iii(new byte[]{92, 6}, IL1Iii.IL1Iii(new byte[]{84, 0, 91, 81, 0, 83}, IL1Iii.IL1Iii(new byte[]{84, 91, 83, 94, 87, 80}, "5908ab")))) : null;
            if (string == null || string.length() == 0) {
                throw new iILLL1(IL1Iii.IL1Iii(new byte[]{127, 114, 43, 124, 18, 66, 69, 86, 16, 65, 18, 85, 81, 90, 14, 93, 86, 9, 16}, IL1Iii.IL1Iii(new byte[]{8, 80, 90, 10, 4, 80}, IL1Iii.IL1Iii(new byte[]{10, 87, 15, 87, 85, 90}, "247ec9"))) + bundleCall.getString(IL1Iii.IL1Iii(new byte[]{8, 87, 70, 68, 5, 82, 0}, IL1Iii.IL1Iii(new byte[]{1, 10, 3, 5, 2, 2}, IL1Iii.IL1Iii(new byte[]{2, 92, 80, 5, 80, 14}, "fdf769")))));
            }
            IiL.IL1Iii(IL1Iii.IL1Iii(new byte[]{45, 115, 127, 32, 23, 19, 23, 87, 68, 29, 23, 17, 23, 81, 85, 1, 68, 17, 88, 18}, IL1Iii.IL1Iii(new byte[]{85, 86, 0, 85, 6, 83}, IL1Iii.IL1Iii(new byte[]{4, 7, 15, 5, 3, 85}, "3c942d"))) + string);
            i1i.IL1Iii(string);
        } catch (Exception e) {
            IiL.IL1Iii(e);
            i1i.ILil(e);
        }
    }
}
