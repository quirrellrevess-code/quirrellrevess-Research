package com.main.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.p000nx.baseui.X5WebView;
import com.qyzs.smn2.R;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LogActivity extends AppCompatActivity {
    public X5WebView iIlLiL = null;
    public File I11li1 = null;

    public class I1I implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f5293ILil;

        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogActivity.this.iIlLiL.loadUrl(I1I.this.f5293ILil);
            }
        }

        public I1I(String str) {
            this.f5293ILil = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogActivity.this.iIlLiL.post(new IL1Iii());
        }
    }

    public class IL1Iii implements View.OnClickListener {
        public IL1Iii() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LogActivity.this.I11li1.exists()) {
                LogActivity.this.I11li1.delete();
                LogActivity.this.finish();
            }
        }
    }

    public class ILil implements View.OnClickListener {
        public ILil() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogActivity logActivity = LogActivity.this;
            logActivity.m125(logActivity.I11li1);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log);
        File file = new File(getIntent().getStringExtra(I1I.IL1Iii.IL1Iii(new byte[]{7, 11, 93, 81}, I1I.IL1Iii.IL1Iii(new byte[]{89, 1, 80, 86, 83, 14}, I1I.IL1Iii.IL1Iii(new byte[]{9, 90, 80, 4, 82, 84}, "191fdc")))));
        file.getName();
        this.I11li1 = file;
        ((TextView) findViewById(R.id.detail_tv_title)).setText(file.getName());
        this.iIlLiL = (X5WebView) findViewById(R.id.logweb);
        findViewById(R.id.del).setOnClickListener(new IL1Iii());
        findViewById(R.id.shared).setOnClickListener(new ILil());
        new Thread(new I1I(Uri.fromFile(file).toString())).start();
    }

    /* JADX INFO: renamed from: 丨丨 */
    public void m125(File file) {
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{89, 93, 86, 19, 14, 89, 92, 29, 91, 15, 21, 85, 86, 71, 28, 0, 2, 68, 81, 92, 92, 79, 50, 117, 118, 119}, I1I.IL1Iii.IL1Iii(new byte[]{92, 85, 6, 2, 5, 5}, I1I.IL1Iii.IL1Iii(new byte[]{85, 95, 87, 6, 84, 87}, "19ce0b"))));
        intent.setType(I1I.IL1Iii.IL1Iii(new byte[]{65, 83, 77, 65, 27, 22, 89, 87, 92, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 80, 4, 12, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 1, 11, 4, 80}, "c302fe"))));
        intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{86, 93, 0, 22, 9, 81, 83, 29, 13, 10, 18, 93, 89, 71, 74, 1, 30, 76, 69, 82, 74, 48, 35, 96, 99}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 92, 0, 7, 91}, I1I.IL1Iii.IL1Iii(new byte[]{5, 5, 91, 5, 84, 80}, "07ca53"))), file.getAbsolutePath());
        startActivity(Intent.createChooser(intent, I1I.IL1Iii.IL1Iii(new byte[]{-35, -67, -75, -36, -120, -55, -34, -93, -76, -36, -119, -44}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 5, 8, 11, 85}, I1I.IL1Iii.IL1Iii(new byte[]{13, 83, 85, 84, 13, 5}, "57cd42")))));
    }
}
