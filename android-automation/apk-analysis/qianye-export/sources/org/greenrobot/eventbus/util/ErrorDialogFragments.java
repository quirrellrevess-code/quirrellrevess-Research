package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ErrorDialogFragments {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static int f5605IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Class<?> f5606ILil;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.ILil(dialogInterface, i, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.IL1Iii(getActivity(), getArguments(), this);
        }
    }

    public static Dialog IL1Iii(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i = f5605IL1Iii;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    public static void ILil(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        Class<?> cls = f5606ILil;
        if (cls == null) {
            if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        try {
            cls.newInstance();
            ErrorDialogManager.f5607IL1Iii.f5539IL1Iii.IL1Iii();
            throw null;
        } catch (Exception e) {
            throw new RuntimeException("Event cannot be constructed", e);
        }
    }
}
