package I1I.I1I.p008IL;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.qyzs.smn2.R;

/* JADX INFO: renamed from: I1I.I1I.I丨L.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: DialogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: I1I.I1I.I丨L.l丨Li1LL$I1I */
    /* JADX INFO: compiled from: DialogUtils.java */
    public interface I1I {
        void IL1Iii(IL il);
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: DialogUtils.java */
    public static class IL1Iii implements I1I.I1I.p008IL.IL.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f3385IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3386ILil;

        public IL1Iii(String str, String str2) {
            this.f3385IL1Iii = str;
            this.f3386ILil = str2;
        }

        @Override // I1I.I1I.p008IL.IL.IL1Iii
        public void IL1Iii(Dialog dialog) {
            ((TextView) dialog.findViewById(R.id.title)).setText(this.f3385IL1Iii);
            ((TextView) dialog.findViewById(R.id.dialog_text)).setText(this.f3386ILil);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.l丨Li1LL$ILil */
    /* JADX INFO: compiled from: DialogUtils.java */
    public static class ILil implements I1I.I1I.p008IL.IL.ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ I1I f3387IL1Iii;

        public ILil(I1I i1i) {
            this.f3387IL1Iii = i1i;
        }

        @Override // I1I.I1I.p008IL.IL.ILil
        public void IL1Iii(I1I.I1I.p008IL.IL il, View view) {
            I1I i1i;
            if (view.getId() == R.id.confirm) {
                I1I i1i2 = this.f3387IL1Iii;
                if (i1i2 != null) {
                    i1i2.IL1Iii(IL.f0Ok);
                    return;
                }
                return;
            }
            if (view.getId() != R.id.cancel || (i1i = this.f3387IL1Iii) == null) {
                return;
            }
            i1i.IL1Iii(IL.Cancel);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.l丨Li1LL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: DialogUtils.java */
    public enum IL {
        f0Ok,
        Cancel
    }

    public static Dialog IL1Iii(Activity activity, String str) {
        Dialog dialog = new Dialog(activity, R.style.dialog_custom);
        dialog.setContentView(R.layout.layout_loading);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        ((TextView) dialog.findViewById(R.id.text)).setText(str);
        return dialog;
    }

    public static void ILil(Activity activity, String str, String str2, I1I i1i) {
        I1I.I1I.p008IL.IL il = new I1I.I1I.p008IL.IL(activity, R.layout.msgbox_layout, new int[]{R.id.confirm, R.id.cancel}, new IL1Iii(str2, str));
        il.IL1Iii(new ILil(i1i));
        il.show();
    }
}
