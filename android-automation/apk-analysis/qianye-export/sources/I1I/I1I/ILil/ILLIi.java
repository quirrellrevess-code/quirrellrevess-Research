package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: I1I.I1I.ILil.ILL丨Ii, reason: invalid class name */
/* JADX INFO: compiled from: ScreenRec.java */
/* JADX INFO: loaded from: classes.dex */
public class ILLIi extends MediaProjection.Callback {

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static final ILLIi f928ILl = new ILLIi();
    public static C0004 Lil = null;
    public boolean ILL;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f931Ll1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f934lIiI;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Handler f3104IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public WindowManager f3105ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f3103I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public MediaProjection f929IL = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ImageReader f3106Ilil = null;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public VirtualDisplay f935lLi1LL = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public MediaProjectionManager f933iILLL1 = null;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Intent f930IiL = null;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f932L11I = 1;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f936il = false;

    /* JADX INFO: renamed from: I1I.I1I.ILil.ILL丨Ii$I1I */
    /* JADX INFO: compiled from: ScreenRec.java */
    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ILLIi.this.m882lIiI();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.ILL丨Ii$IL1Iii */
    /* JADX INFO: compiled from: ScreenRec.java */
    public class IL1Iii extends MediaProjection.Callback {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ MediaProjection f3108IL1Iii;

        public IL1Iii(MediaProjection mediaProjection) {
            this.f3108IL1Iii = mediaProjection;
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            Log.d(I1I.IL1Iii.IL1Iii(new byte[]{124, 110}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 84, 85, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 0, 87, 6, 95, 5}, "2531f3"))), I1I.IL1Iii.IL1Iii(new byte[]{122, 81, 7, 91, 85, 24, 71, 70, 12, 88, 81, 91, 67, 93, 12, 92, 20, 75, 67, 91, 19, 66, 81, 92, 13, 20, 35}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 1, 10, 0, 94}, I1I.IL1Iii.IL1Iii(new byte[]{82, 3, 82, 92, 86, 86}, "610db0"))) + Integer.toHexString(this.f3108IL1Iii.hashCode()));
            ILLIi.this.ILL = true;
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.ILL丨Ii$ILil */
    /* JADX INFO: compiled from: ScreenRec.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ILLIi.this.Lil();
                ILLIi iLLIi = ILLIi.this;
                iLLIi.LlLI1(iLLIi.f3105ILil.getDefaultDisplay().getRotation());
                ILLIi.this.m882lIiI();
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 110}, I1I.IL1Iii.IL1Iii(new byte[]{14, 1, 84, 10, 84, 94}, I1I.IL1Iii.IL1Iii(new byte[]{85, 82, 4, 11, 86, 4}, "bef3cb"))), e.toString());
            }
        }
    }

    public ILLIi() {
        new AtomicReference();
        this.f931Ll1 = -1;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static ILLIi m876lLi1LL() {
        return f928ILl;
    }

    public synchronized C0004 ILL() {
        try {
            Image imageIlil = Ilil();
            if (imageIlil == null) {
                return Lil;
            }
            Lil = new C0004(imageIlil);
            imageIlil.close();
            return Lil;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m877ILl(Handler handler) {
    }

    public synchronized Image Ilil() {
        try {
        } catch (Exception e) {
            if (this.f936il || !(e instanceof UnsupportedOperationException)) {
                return null;
            }
            this.f936il = true;
            this.f932L11I = 2;
            this.f3104IL1Iii.post(new I1I());
            return null;
        }
        return this.f3106Ilil.acquireLatestImage();
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m878IiL(Context context) {
        try {
            this.f3103I1I = context;
            this.f3104IL1Iii = new Handler();
            this.f3105ILil = (WindowManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{79, 15, 86, 82, 91, 68}, I1I.IL1Iii.IL1Iii(new byte[]{91, 7, 14, 4, 6, 10}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 5, 2, 80, 8}, "bb30b1"))));
            this.f933iILLL1 = (MediaProjectionManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 6, 13, 86, 62, 18, 16, 13, 14, 82, 2, 22, 11, 13, 10}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 6, 7, 81, 88}, I1I.IL1Iii.IL1Iii(new byte[]{5, 7, 84, 81, 81, 92}, "c4027e"))));
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 107}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 4, 13, 80, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 87, 1, 1, 83}, "245977"))), e.toString());
        }
    }

    public final void Lil() {
        if (m884il()) {
            return;
        }
        this.f929IL = m881iILLL1();
    }

    public void LlLI1(int i) {
        if (this.f931Ll1 != i) {
            this.f931Ll1 = i;
            this.f934lIiI = i;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m879Ll1() {
        int rotation;
        if (this.f930IiL == null || this.f934lIiI == (rotation = this.f3105ILil.getDefaultDisplay().getRotation())) {
            return;
        }
        this.f934lIiI = rotation;
        try {
            m882lIiI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"WrongConstant"})
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m880L11I(int i, int i2, int i3) {
        int i4 = 3;
        this.f3106Ilil = ImageReader.newInstance(i, i2, this.f932L11I, 3);
        do {
            try {
                this.f935lLi1LL = this.f929IL.createVirtualDisplay(this.f3103I1I.getPackageName(), i, i2, i3, 16, this.f3106Ilil.getSurface(), null, null);
                return;
            } catch (SecurityException unused) {
                Lil();
                i4--;
            }
        } while (i4 > 0);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final synchronized MediaProjection m881iILLL1() {
        MediaProjection mediaProjection;
        mediaProjection = this.f933iILLL1.getMediaProjection(-1, (Intent) this.f930IiL.clone());
        this.ILL = false;
        mediaProjection.registerCallback(new IL1Iii(mediaProjection), this.f3104IL1Iii);
        return mediaProjection;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final void m882lIiI() {
        if (this.f930IiL == null) {
            return;
        }
        try {
            ImageReader imageReader = this.f3106Ilil;
            if (imageReader != null) {
                imageReader.close();
            }
        } catch (Exception unused) {
        }
        try {
            VirtualDisplay virtualDisplay = this.f935lLi1LL;
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        } catch (Exception unused2) {
        }
        Point pointM1123IIi = lIlii.m1123IIi(this.f3103I1I);
        m880L11I(pointM1123IIi.x, pointM1123IIi.y, Resources.getSystem().getDisplayMetrics().densityDpi);
        m877ILl(this.f3104IL1Iii);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m883llL1ii(Intent intent) {
        this.f930IiL = intent;
        this.f3104IL1Iii.post(new ILil());
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m884il() {
        return (this.f929IL == null || this.ILL) ? false : true;
    }
}
