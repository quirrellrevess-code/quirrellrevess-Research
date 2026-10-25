package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.r */
/* JADX INFO: loaded from: classes.dex */
public class C0424r extends FrameLayout implements MediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a */
    private Object f611a;

    /* JADX INFO: renamed from: b */
    private C0430t f612b;

    /* JADX INFO: renamed from: c */
    private VideoView f613c;

    /* JADX INFO: renamed from: d */
    private Context f614d;

    /* JADX INFO: renamed from: e */
    private String f615e;

    public C0424r(Context context) {
        super(context.getApplicationContext());
        this.f614d = null;
        this.f614d = context;
    }

    /* JADX INFO: renamed from: b */
    private void m482b(Bundle bundle, Object obj) {
        boolean zM529a;
        m483a();
        if (m487b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            zM529a = this.f612b.m529a(this.f611a, bundle, this, obj);
        } else {
            zM529a = false;
        }
        if (zM529a) {
            return;
        }
        VideoView videoView = this.f613c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        if (this.f613c == null) {
            this.f613c = new VideoView(getContext());
        }
        String string = bundle.getString("videoUrl");
        this.f615e = string;
        this.f613c.setVideoURI(Uri.parse(string));
        this.f613c.setOnErrorListener(this);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        Context applicationContext = getContext().getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.startActivity(intent);
    }

    /* JADX INFO: renamed from: a */
    public void m483a() {
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        if (this.f612b == null) {
            C0412f.m323a(true).m329a(getContext().getApplicationContext(), false, false);
            C0425s c0425sM328a = C0412f.m323a(true).m328a();
            DexLoader dexLoaderM498c = c0425sM328a != null ? c0425sM328a.m498c() : null;
            if (dexLoaderM498c != null && QbSdk.canLoadVideo(getContext())) {
                this.f612b = new C0430t(dexLoaderM498c);
            }
        }
        C0430t c0430t = this.f612b;
        if (c0430t == null || this.f611a != null) {
            return;
        }
        this.f611a = c0430t.m526a(getContext().getApplicationContext());
    }

    /* JADX INFO: renamed from: a */
    public void m484a(Activity activity) {
        VideoView videoView;
        if (m487b() || (videoView = this.f613c) == null) {
            return;
        }
        if (videoView.getParent() == null) {
            Window window = activity.getWindow();
            FrameLayout frameLayout = (FrameLayout) window.getDecorView();
            window.addFlags(1024);
            window.addFlags(128);
            frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            MediaController mediaController = new MediaController(activity);
            mediaController.setMediaPlayer(this.f613c);
            this.f613c.setMediaController(mediaController);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(this.f613c, layoutParams);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            this.f613c.start();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m485a(Activity activity, int i) {
        VideoView videoView;
        VideoView videoView2;
        if (i == 3 && !m487b() && (videoView2 = this.f613c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.f614d = null;
            if (!m487b() && (videoView = this.f613c) != null) {
                videoView.stopPlayback();
                this.f613c = null;
            }
        }
        if (i == 2 && !m487b()) {
            this.f614d = activity;
            m484a(activity);
        }
        if (m487b()) {
            this.f612b.m528a(this.f611a, activity, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m486a(Bundle bundle, Object obj) {
        m482b(bundle, obj);
    }

    /* JADX INFO: renamed from: b */
    public boolean m487b() {
        return (this.f612b == null || this.f611a == null) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public void m488c() {
        if (m487b()) {
            this.f612b.m527a(this.f611a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            Context context = this.f614d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context2 = getContext();
            if (context2 != null) {
                Toast.makeText(context2, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context2.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
                intent.setDataAndType(Uri.parse(this.f615e), "video/*");
                applicationContext.startActivity(intent);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
