package org.opencv.android;

import I1I.IL1Iii;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLoaderCallback implements LoaderCallbackInterface {
    private static final String TAG = IL1Iii.IL1Iii(new byte[]{125, 119, 51, 78, 119, 4, 65, 81, 41, 14, 84, 1, 87, 70, 38, 0, 89, 9, 80, 85, 6, 10}, IL1Iii.IL1Iii(new byte[]{10, 87, 93, 86, 7, 0}, IL1Iii.IL1Iii(new byte[]{13, 1, 89, 5, 3, 6}, "5ba21c")));
    public Context mAppContext;

    public BaseLoaderCallback(Context context) {
        this.mAppContext = context;
    }

    public void finish() {
        ((Activity) this.mAppContext).finish();
    }

    @Override // org.opencv.android.LoaderCallbackInterface
    public void onManagerConnected(int i) {
        if (i != 0) {
            if (i == 2) {
                Log.e(TAG, IL1Iii.IL1Iii(new byte[]{100, 82, 85, 92, 88, 82, 81, 19, 95, 89, 74, 65, 85, 95, 90, 86, 77, 92, 91, 93, 22, 81, 88, 92, 88, 86, 82, 22}, IL1Iii.IL1Iii(new byte[]{4, 82, 83, 3, 13, 12}, IL1Iii.IL1Iii(new byte[]{86, 4, 92, 2, 2, 15}, "fe9666"))));
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mAppContext).create();
                alertDialogCreate.setTitle(IL1Iii.IL1Iii(new byte[]{120, 69, 80, 86, 115, 52, 23, 120, 84, 86, 81, 5, 82, 71}, IL1Iii.IL1Iii(new byte[]{1, 81, 83, 13, 5, 82}, IL1Iii.IL1Iii(new byte[]{84, 2, 87, 5, 3, 5}, "bf1065"))));
                alertDialogCreate.setMessage(IL1Iii.IL1Iii(new byte[]{52, 83, 1, 90, 85, 80, 1, 18, 11, 95, 71, 67, 5, 94, 14, 80, 64, 94, 11, 92, 66, 87, 85, 94, 8, 87, 6, 16}, IL1Iii.IL1Iii(new byte[]{84, 2, 81, 1, 5, 2}, IL1Iii.IL1Iii(new byte[]{6, 3, 80, 82, 87, 2}, "63cbf7"))));
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.setButton(-1, IL1Iii.IL1Iii(new byte[]{123, 124}, IL1Iii.IL1Iii(new byte[]{2, 5, 1, 82, 0, 6}, IL1Iii.IL1Iii(new byte[]{84, 83, 5, 87, 81, 87}, "baac03"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                alertDialogCreate.show();
                return;
            }
            if (i == 3) {
                Log.d(TAG, IL1Iii.IL1Iii(new byte[]{123, 73, 93, 88, 34, 55, 20, 85, 81, 84, 19, 0, 70, 64, 24, 95, 15, 18, 64, 88, 84, 90, 0, 21, 93, 86, 86, 22, 22, 0, 71, 25, 91, 87, 15, 2, 81, 85, 93, 82, 65, 3, 77, 25, 77, 69, 4, 19}, IL1Iii.IL1Iii(new byte[]{1, 91, 91, 2, 86, 89}, IL1Iii.IL1Iii(new byte[]{80, 87, 80, 86, 85, 0}, "e53bb8"))));
                finish();
                return;
            }
            if (i != 4) {
                Log.e(TAG, IL1Iii.IL1Iii(new byte[]{43, 65, 87, 12, 123, 103, 68, 93, 93, 3, 92, 88, 10, 86, 18, 4, 89, 88, 8, 84, 86, 67}, IL1Iii.IL1Iii(new byte[]{92, 8, 1, 4, 0, 5}, IL1Iii.IL1Iii(new byte[]{1, 12, 4, 83, 9, 4}, "957510"))));
                AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.mAppContext).create();
                alertDialogCreate2.setTitle(IL1Iii.IL1Iii(new byte[]{43, 70, 3, 13, 123, 48, 68, 83, 20, 17, 87, 20}, IL1Iii.IL1Iii(new byte[]{2, 7, 86, 83, 92, 5}, IL1Iii.IL1Iii(new byte[]{84, 84, 9, 83, 0, 86}, "2e9cd5"))));
                alertDialogCreate2.setMessage(IL1Iii.IL1Iii(new byte[]{119, 72, 0, 87, 33, 53, 24, 79, 4, 74, 66, 13, 87, 76, 69, 80, 12, 10, 76, 81, 4, 85, 11, 16, 93, 92, 69, 90, 13, 17, 74, 93, 6, 77, 14, 26, 22, 24, 36, 73, 18, 15, 81, 91, 4, 77, 11, 12, 86, 24, 18, 80, 14, 15, 24, 90, 0, 25, 17, 11, 77, 76, 69, 93, 13, 20, 86}, IL1Iii.IL1Iii(new byte[]{94, 12, 86, 91, 0, 82}, IL1Iii.IL1Iii(new byte[]{83, 7, 2, 90, 83, 80}, "53181a"))));
                alertDialogCreate2.setCancelable(false);
                alertDialogCreate2.setButton(-1, IL1Iii.IL1Iii(new byte[]{43, 47}, IL1Iii.IL1Iii(new byte[]{1, 82, 90, 9, 6, 2}, IL1Iii.IL1Iii(new byte[]{82, 85, 15, 81, 80, 86}, "7c6a55"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                alertDialogCreate2.show();
                return;
            }
            Log.d(TAG, IL1Iii.IL1Iii(new byte[]{119, 21, 93, 90, 119, 103, 24, 40, 89, 90, 85, 86, 93, 23, 24, 103, 81, 67, 78, 12, 91, 81, 20, 88, 75, 69, 77, 90, 87, 94, 85, 21, 89, 64, 93, 83, 84, 0, 24, 67, 93, 69, 80, 69, 76, 92, 93, 66, 24, 4, 72, 68, 21}, IL1Iii.IL1Iii(new byte[]{89, 80, 14, 1, 85, 2}, IL1Iii.IL1Iii(new byte[]{4, 13, 2, 1, 89, 0}, "e84483"))));
            AlertDialog alertDialogCreate3 = new AlertDialog.Builder(this.mAppContext).create();
            alertDialogCreate3.setTitle(IL1Iii.IL1Iii(new byte[]{120, 19, 83, 94, 116, 98, 23, 46, 87, 94, 86, 83, 82, 17}, IL1Iii.IL1Iii(new byte[]{85, 85, 82, 1, 14, 0}, IL1Iii.IL1Iii(new byte[]{81, 7, 1, 8, 92, 1}, "31e9e5"))));
            alertDialogCreate3.setMessage(IL1Iii.IL1Iii(new byte[]{43, 70, 83, 15, 112, 110, 68, 123, 87, 15, 82, 95, 1, 68, 22, 18, 86, 74, 18, 95, 85, 4, 19, 81, 23, 22, 95, 15, 80, 87, 9, 70, 87, 21, 90, 90, 8, 83, 22, 22, 90, 76, 12, 22, 66, 9, 90, 75, 68, 87, 70, 17, 29, 24, 48, 68, 79, 65, 71, 87, 68, 67, 70, 5, 82, 76, 1, 22, 95, 21, 19, 78, 13, 87, 22, 38, 92, 87, 3, 90, 83, 65, 99, 84, 5, 79, 24}, IL1Iii.IL1Iii(new byte[]{92, 3, 15, 85, 11, 92}, IL1Iii.IL1Iii(new byte[]{13, 12, 92, 12, 94, 2}, "59e8ff"))));
            alertDialogCreate3.setCancelable(false);
            alertDialogCreate3.setButton(-1, IL1Iii.IL1Iii(new byte[]{123, 46}, IL1Iii.IL1Iii(new byte[]{6, 7, 87, 85, 91, 83}, IL1Iii.IL1Iii(new byte[]{7, 84, 4, 5, 91, 95}, "561399"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    BaseLoaderCallback.this.finish();
                }
            });
            alertDialogCreate3.show();
        }
    }

    @Override // org.opencv.android.LoaderCallbackInterface
    public void onPackageInstall(int i, final InstallCallbackInterface installCallbackInterface) {
        if (i != 0) {
            if (i != 1) {
                return;
            }
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mAppContext).create();
            alertDialogCreate.setTitle(IL1Iii.IL1Iii(new byte[]{126, 66, 3, 12, 112, 102, 17, 91, 21, 66, 93, 95, 69, 18, 20, 7, 82, 84, 72}, IL1Iii.IL1Iii(new byte[]{0, 83, 83, 91, 1, 85}, IL1Iii.IL1Iii(new byte[]{8, 5, 3, 11, 84, 85}, "9d62f0"))));
            alertDialogCreate.setMessage(IL1Iii.IL1Iii(new byte[]{123, 89, 65, 23, 5, 88, 94, 86, 70, 10, 11, 90, 18, 94, 65, 67, 13, 90, 18, 71, 64, 12, 3, 70, 87, 68, 65, 77, 68, 99, 83, 94, 70, 67, 11, 70, 18, 82, 74, 10, 16, 11}, IL1Iii.IL1Iii(new byte[]{5, 4, 2, 1, 93, 3}, IL1Iii.IL1Iii(new byte[]{6, 86, 82, 87, 91, 86}, "1eb5ba"))));
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.setButton(-1, IL1Iii.IL1Iii(new byte[]{99, 80, 89, 16}, IL1Iii.IL1Iii(new byte[]{13, 87, 5, 87, 87, 84}, IL1Iii.IL1Iii(new byte[]{11, 82, 81, 10, 84, 87}, "24d91b"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    installCallbackInterface.wait_install();
                }
            });
            alertDialogCreate.setButton(-2, IL1Iii.IL1Iii(new byte[]{38, 77, 11, 65}, IL1Iii.IL1Iii(new byte[]{82, 3, 90, 13, 2, 82}, IL1Iii.IL1Iii(new byte[]{6, 82, 11, 94, 14, 88}, "7d3f99"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    installCallbackInterface.cancel();
                }
            });
            alertDialogCreate.show();
            return;
        }
        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.mAppContext).create();
        alertDialogCreate2.setTitle(IL1Iii.IL1Iii(new byte[]{97, 83, 7, 10, 89, 85, 84, 18, 10, 14, 76, 18, 87, 93, 17, 15, 92}, IL1Iii.IL1Iii(new byte[]{1, 11, 5, 3, 1, 4}, IL1Iii.IL1Iii(new byte[]{84, 95, 0, 90, 0, 83}, "dfa89e"))));
        alertDialogCreate2.setMessage(installCallbackInterface.getPackageName() + IL1Iii.IL1Iii(new byte[]{66, 19, 5, 85, 9, 84, 5, 6, 68, 65, 3, 70, 66, 13, 11, 66, 66, 83, 13, 22, 10, 82, 67, 21, 54, 17, 29, 22, 22, 90, 66, 10, 10, 69, 22, 84, 14, 15, 68, 95, 22, 10}, IL1Iii.IL1Iii(new byte[]{81, 84, 7, 14, 4, 13}, IL1Iii.IL1Iii(new byte[]{7, 5, 1, 94, 80, 15}, "42bf67"))));
        alertDialogCreate2.setCancelable(false);
        alertDialogCreate2.setButton(-1, IL1Iii.IL1Iii(new byte[]{109, 3, 18}, IL1Iii.IL1Iii(new byte[]{13, 82, 4, 4, 91, 80}, IL1Iii.IL1Iii(new byte[]{13, 1, 85, 0, 92, 85}, "450bef"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                installCallbackInterface.install();
            }
        });
        alertDialogCreate2.setButton(-2, IL1Iii.IL1Iii(new byte[]{127, 89}, IL1Iii.IL1Iii(new byte[]{9, 87, 89, 5, 5, 3}, IL1Iii.IL1Iii(new byte[]{89, 80, 90, 87, 4, 7}, "a1b42b"))), new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                installCallbackInterface.cancel();
            }
        });
        alertDialogCreate2.show();
    }
}
