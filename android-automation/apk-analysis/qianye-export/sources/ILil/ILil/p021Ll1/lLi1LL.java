package ILil.ILil.p021Ll1;

import ILil.ILL.IL1Iii.ILil;
import android.app.Dialog;
import android.os.Bundle;

/* JADX INFO: renamed from: ILil.ILil.Ll丨1.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatDialogFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL extends ILil {
    @Override // ILil.ILL.IL1Iii.ILil
    public Dialog onCreateDialog(Bundle bundle) {
        throw null;
    }

    @Override // ILil.ILL.IL1Iii.ILil
    public void setupDialog(Dialog dialog, int i) {
        if (!(dialog instanceof IL)) {
            super.setupDialog(dialog, i);
            return;
        }
        IL il = (IL) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        il.supportRequestWindowFeature(1);
    }
}
