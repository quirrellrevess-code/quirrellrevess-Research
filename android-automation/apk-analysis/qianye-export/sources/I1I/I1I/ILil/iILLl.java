package I1I.I1I.ILil;

import android.media.MediaPlayer;
import android.util.Log;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨iI丨丨LLl, reason: invalid class name */
/* JADX INFO: compiled from: MediaUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLl {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static MediaPlayer f3303IL1Iii;

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨iI丨丨LLl$IL1Iii */
    /* JADX INFO: compiled from: MediaUtils.java */
    public static class IL1Iii implements MediaPlayer.OnCompletionListener {
        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            iILLl.ILil();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨iI丨丨LLl$ILil */
    /* JADX INFO: compiled from: MediaUtils.java */
    public static class ILil implements MediaPlayer.OnErrorListener {
        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                iILLl.f3303IL1Iii.reset();
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static void IL1Iii(String str) {
        ILil();
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            f3303IL1Iii = mediaPlayer;
            mediaPlayer.setOnErrorListener(new ILil());
            f3303IL1Iii.setDataSource(str);
            f3303IL1Iii.prepare();
            f3303IL1Iii.start();
            f3303IL1Iii.setOnCompletionListener(new IL1Iii());
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 107}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 2, 89, 4, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 2, 94, 85, 81}, "7ecf4a"))), I1I.IL1Iii.IL1Iii(new byte[]{102, 14, 80, 64, 53, 87, 67, 12, 85, 25, 3, 74, 68, 88}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 84, 14, 2, 91}, I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 84, 7, 7, 85}, "5610c6"))) + e.toString());
        }
    }

    public static void ILil() {
        try {
            MediaPlayer mediaPlayer = f3303IL1Iii;
            if (mediaPlayer == null) {
                return;
            } else {
                mediaPlayer.release();
            }
        } catch (Exception unused) {
        }
        f3303IL1Iii = null;
    }
}
