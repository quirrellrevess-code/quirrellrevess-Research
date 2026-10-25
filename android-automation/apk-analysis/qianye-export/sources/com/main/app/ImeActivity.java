package com.main.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public class ImeActivity extends Activity {

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) ImeActivity.this.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{13, 15, 69, 77, 68, 108, 9, 4, 65, 80, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{86, 0, 86, 10, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 1, 4, 84, 83}, "77b6d5"))))).showInputMethodPicker();
            ImeActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Handler().postDelayed(new IL1Iii(), 500L);
    }
}
