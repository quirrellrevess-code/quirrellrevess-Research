package I1I.p062Ilil.I1I;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.SurfaceControl;

/* JADX INFO: compiled from: Sdk32.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {
    public static Bitmap IL1Iii(int i, int i2, boolean z) {
        SurfaceControl.ScreenshotHardwareBuffer screenshotHardwareBufferCaptureDisplay = SurfaceControl.captureDisplay(new SurfaceControl.DisplayCaptureArgs.Builder(SurfaceControl.getInternalDisplayToken()).setSourceCrop(new Rect()).setSize(i, i2).setUseIdentityTransform(z).build());
        if (screenshotHardwareBufferCaptureDisplay == null) {
            return null;
        }
        Bitmap bitmapAsBitmap = screenshotHardwareBufferCaptureDisplay.asBitmap();
        if (screenshotHardwareBufferCaptureDisplay.getHardwareBuffer() != null) {
            screenshotHardwareBufferCaptureDisplay.getHardwareBuffer().close();
        }
        return bitmapAsBitmap;
    }
}
