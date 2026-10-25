package com.main.app;

import android.os.Bundle;
import com.qyzs.smn2.R;

/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends BaseSettingActivity {
    @Override // com.main.app.BaseSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        m3441IIi(true);
    }

    @Override // com.main.app.BaseSettingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
