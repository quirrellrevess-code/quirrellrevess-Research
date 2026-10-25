package com.main.app;

import I1I.IL1Iii;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import com.qyzs.smn2.R;
import java.io.File;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public final class ProjectActivity {

    public static class ProjectLandsape extends BaseActivity {
        @Override // com.main.app.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            try {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
            } catch (Exception unused) {
            }
            ProjectActivity.IL1Iii(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            setIntent(intent);
            ProjectActivity.IL1Iii(this);
        }
    }

    public static class ProjectPoritrait extends BaseActivity {
        @Override // com.main.app.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            try {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
            } catch (Exception unused) {
            }
            ProjectActivity.IL1Iii(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            setIntent(intent);
            ProjectActivity.IL1Iii(this);
        }
    }

    public static void IL1Iii(Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra(IL1Iii.IL1Iii(new byte[]{73, 5, 18, 89}, IL1Iii.IL1Iii(new byte[]{1, 87, 80, 1, 4, 4}, IL1Iii.IL1Iii(new byte[]{0, 82, 2, 82, 1, 85}, "8a4b53"))));
        activity.setContentView(R.layout.layout_project);
        ((ImageView) activity.findViewById(R.id.project)).setImageURI(Uri.fromFile(new File(stringExtra)));
    }

    public static void ILil(Context context, String str) {
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(Uri.fromFile(new File(str))));
            boolean z = bitmapDecodeStream.getWidth() <= bitmapDecodeStream.getHeight();
            if (!bitmapDecodeStream.isRecycled()) {
                bitmapDecodeStream.recycle();
            }
            Intent intent = z ? new Intent(context, (Class<?>) ProjectPoritrait.class) : new Intent(context, (Class<?>) ProjectLandsape.class);
            intent.putExtra(IL1Iii.IL1Iii(new byte[]{73, 83, 67, 81}, IL1Iii.IL1Iii(new byte[]{8, 87, 7, 13, 6, 87}, IL1Iii.IL1Iii(new byte[]{87, 6, 81, 5, 82, 5}, "fca1d3"))), str);
            intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            PendingIntent.getActivity(context, 0, intent, Videoio.CAP_INTELPERC_IR_GENERATOR).send();
        } catch (Exception unused) {
        }
    }
}
