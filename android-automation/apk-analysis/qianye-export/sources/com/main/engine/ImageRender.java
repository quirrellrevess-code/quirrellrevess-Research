package com.main.engine;

import I1I.IL1Iii;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public class ImageRender implements SurfaceTexture.OnFrameAvailableListener {
    private Surface mSurface;
    private SurfaceTexture mTex;
    private long mHandle = 0;
    private boolean isSetBufferSizeFailed = false;

    private native Object nativeAquireImage(long j);

    private native boolean nativeClose(long j);

    private native long nativeOpen(int i, int i2, int i3, int i4, int i5);

    private native boolean nativeUpdate(long j);

    public static void setFrameAvaListener(Object obj, SurfaceTexture surfaceTexture, int i, int i2) {
        if (obj == null) {
            return;
        }
        ((ImageRender) obj).setFrameAvaListenerImp(surfaceTexture, i, i2);
    }

    private void setFrameAvaListenerImp(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
            }
        } catch (Exception unused) {
        }
        try {
            surfaceTexture.setDefaultBufferSize(i, i2);
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{122, 61}, IL1Iii.IL1Iii(new byte[]{12, 84, 81, 6, 81, 86}, IL1Iii.IL1Iii(new byte[]{93, 87, 5, 87, 0, 0}, "eff2e4"))), IL1Iii.IL1Iii(new byte[]{6, 79, 84, 78}, IL1Iii.IL1Iii(new byte[]{87, 7, 84, 0, 0, 86}, IL1Iii.IL1Iii(new byte[]{12, 1, 81, 83, 6, 3}, "81a573"))) + e.toString() + IL1Iii.IL1Iii(new byte[]{31}, IL1Iii.IL1Iii(new byte[]{2, 91, 87, 83, 13, 15}, IL1Iii.IL1Iii(new byte[]{13, 91, 6, 81, 6, 92}, "9c043d"))));
            boolean z = e instanceof SecurityException;
            this.isSetBufferSizeFailed = true;
        }
        try {
            this.mSurface = new Surface(surfaceTexture);
        } catch (Exception e2) {
            Log.i(IL1Iii.IL1Iii(new byte[]{121, 108}, IL1Iii.IL1Iii(new byte[]{15, 81, 87, 80, 82, 2}, IL1Iii.IL1Iii(new byte[]{0, 82, 5, 82, 87, 6}, "8710fb"))), IL1Iii.IL1Iii(new byte[]{82, 77, 80, 31}, IL1Iii.IL1Iii(new byte[]{6, 86, 4, 1, 14, 80}, IL1Iii.IL1Iii(new byte[]{84, 85, 87, 84, 84, 86}, "e62bc2"))) + e2.toString() + IL1Iii.IL1Iii(new byte[]{17}, IL1Iii.IL1Iii(new byte[]{91, 91, 7, 86, 84, 3}, IL1Iii.IL1Iii(new byte[]{7, 4, 1, 6, 6, 7}, "df45b2"))));
        }
        this.mTex = surfaceTexture;
        Log.i(IL1Iii.IL1Iii(new byte[]{120, 61}, IL1Iii.IL1Iii(new byte[]{84, 7, 87, 6, 81, 12}, IL1Iii.IL1Iii(new byte[]{85, 85, 86, 83, 87, 1}, "770f25"))), IL1Iii.IL1Iii(new byte[]{15, 48, 19, 17, 95, 87, 1, 6, 78}, IL1Iii.IL1Iii(new byte[]{80, 5, 0, 81, 14, 1}, IL1Iii.IL1Iii(new byte[]{10, 5, 86, 7, 84, 5}, "8c05c2"))) + this.mSurface + IL1Iii.IL1Iii(new byte[]{75}, IL1Iii.IL1Iii(new byte[]{7, 3, 86, 82, 7, 8}, IL1Iii.IL1Iii(new byte[]{3, 88, 0, 85, 87, 12}, "f90c64"))));
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public Bitmap acquireImage() {
        Object objNativeAquireImage;
        synchronized (this) {
            long j = this.mHandle;
            if (j == 0 || (objNativeAquireImage = nativeAquireImage(j)) == null) {
                return null;
            }
            return (Bitmap) objNativeAquireImage;
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public boolean isSurfaceOk() {
        return !this.isSetBufferSizeFailed;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        nativeUpdate(this.mHandle);
    }

    public boolean open(int i, int i2, int i3, int i4, int i5) {
        long jNativeOpen = nativeOpen(i, i2, i3, i4, i5);
        this.mHandle = jNativeOpen;
        return jNativeOpen != 0;
    }

    public boolean stop() {
        synchronized (this) {
            long j = this.mHandle;
            if (j != 0) {
                nativeClose(j);
            }
            this.mHandle = 0L;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception unused) {
            }
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mTex;
        if (surfaceTexture == null) {
            return false;
        }
        try {
            surfaceTexture.release();
        } catch (Exception unused2) {
        }
        this.mTex = null;
        return false;
    }
}
