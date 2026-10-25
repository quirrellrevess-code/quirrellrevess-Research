package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.main.engine.ImageRender;

/* JADX INFO: renamed from: I1I.I1I.ILil.I1L丨11L, reason: invalid class name */
/* JADX INFO: compiled from: ScrcpyNative.java */
/* JADX INFO: loaded from: classes.dex */
public class I1L11L {

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static final I1L11L f923L11I = new I1L11L();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Handler f3090IL1Iii;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ImageReader f925IiL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public C0600Lil f3091ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public IBinder f3089I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f924IL = 1;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f3092Ilil = false;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public C0004 f927lLi1LL = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ImageRender f926iILLL1 = null;

    /* JADX INFO: renamed from: I1I.I1I.ILil.I1L丨11L$IL1Iii */
    /* JADX INFO: compiled from: ScrcpyNative.java */
    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            I1L11L.this.f3090IL1Iii = new Handler();
            while (true) {
                try {
                    I1L11L.ILil(I1L11L.this);
                    throw null;
                } catch (Exception e) {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{43, 111}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 6, 3, 81, 6}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 7, 5, 82, 0}, "63ec31"))), I1I.IL1Iii.IL1Iii(new byte[]{22, 92, 22, 70, 4, 74, 16, 4, 88, 12}, I1I.IL1Iii.IL1Iii(new byte[]{81, 9, 93, 83, 3, 0}, I1I.IL1Iii.IL1Iii(new byte[]{12, 83, 92, 7, 81, 94}, "9cdf7f"))) + e.toString());
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static /* synthetic */ void ILil(I1L11L i1l11l) {
        i1l11l.m854iILLL1();
        throw null;
    }

    public static IBinder Ilil() {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i < 30 || (i == 30 && !I1I.IL1Iii.IL1Iii(new byte[]{55}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 86, 13, 87, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 0, 12, 7, 6}, "c24821"))).equals(Build.VERSION.CODENAME))) {
            z = true;
        }
        return LIl.ILil(lIlii.LiL1() + I1I.IL1Iii.IL1Iii(new byte[]{108, 23, 83, 68, 75}, I1I.IL1Iii.IL1Iii(new byte[]{87, 92, 1, 4, 6, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 89, 3, 84, 6, 12}, "3a2d28"))), z);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static I1L11L m850lLi1LL() {
        return f923L11I;
    }

    public final Bitmap I1I() {
        try {
            return this.f926iILLL1.acquireImage();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 108}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 1, 7, 5, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 3, 3, 87, 14, 3}, "c61a84"))), e.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Image m851IL() {
        try {
            return this.f925IiL.acquireLatestImage();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 109}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 0, 2, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 95, 86, 81, 3}, "a79ccb"))), e.toString());
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0102: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:37:0x0102 */
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public synchronized C0004 m852IiL() {
        Bitmap bitmap;
        Bitmap bitmapI1I;
        Image imageM851IL;
        Bitmap bitmap2 = null;
        Image image = null;
        try {
            try {
                if (this.f926iILLL1 != null) {
                    try {
                        bitmapI1I = I1I();
                        try {
                            if (bitmapI1I == null) {
                                C0004 c0004 = this.f927lLi1LL;
                                if (bitmapI1I != null) {
                                    try {
                                        if (!bitmapI1I.isRecycled()) {
                                            bitmapI1I.recycle();
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                                return c0004;
                            }
                            C0004 c0005 = new C0004(bitmapI1I);
                            this.f927lLi1LL = c0005;
                            if (bitmapI1I != null) {
                                try {
                                    if (!bitmapI1I.isRecycled()) {
                                        bitmapI1I.recycle();
                                    }
                                } catch (Exception unused2) {
                                }
                            }
                            return c0005;
                        } catch (Exception e) {
                            e = e;
                            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 104}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 87, 10, 89, 88}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 81, 85, 89, 81}, "14ef80"))), I1I.IL1Iii.IL1Iii(new byte[]{90, 85, 16, 85, 8, 8, 21, 82, 22, 70, 91}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 93, 0, 81, 85}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 92, 0, 6, 6}, "65e465"))) + e.toString());
                            if (bitmapI1I != null) {
                                if (!bitmapI1I.isRecycled()) {
                                    bitmapI1I.recycle();
                                }
                            }
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bitmapI1I = null;
                    } catch (Throwable th) {
                        th = th;
                        if (bitmap2 != null) {
                            try {
                                if (!bitmap2.isRecycled()) {
                                    bitmap2.recycle();
                                }
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } else if (this.f925IiL != null) {
                    try {
                        imageM851IL = m851IL();
                        if (imageM851IL != null) {
                            try {
                                this.f927lLi1LL = new C0004(imageM851IL);
                            } catch (Exception unused4) {
                                imageM851IL.close();
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                image = imageM851IL;
                                try {
                                    image.close();
                                } catch (Exception unused5) {
                                }
                                throw th;
                            }
                        }
                        C0004 c0006 = this.f927lLi1LL;
                        try {
                            imageM851IL.close();
                        } catch (Exception unused6) {
                        }
                        return c0006;
                    } catch (Exception unused7) {
                        imageM851IL = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Exception unused8) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            bitmap2 = bitmap;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0239 A[Catch: Exception -> 0x0240, all -> 0x0284, TRY_LEAVE, TryCatch #0 {Exception -> 0x0240, blocks: (B:23:0x0235, B:25:0x0239), top: B:43:0x0235 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0243 A[Catch: all -> 0x0284, TRY_ENTER, TryCatch #2 {all -> 0x0284, blocks: (B:3:0x000b, B:9:0x0017, B:11:0x001b, B:12:0x0020, B:14:0x0050, B:23:0x0235, B:25:0x0239, B:29:0x0243, B:35:0x0274, B:32:0x0252, B:34:0x026b, B:33:0x025b, B:17:0x0143, B:19:0x0147, B:21:0x014f), top: B:47:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:30:0x024e  */
    /* JADX WARN: Code duplicated, block: B:33:0x025b A[Catch: all -> 0x0284, TryCatch #2 {all -> 0x0284, blocks: (B:3:0x000b, B:9:0x0017, B:11:0x001b, B:12:0x0020, B:14:0x0050, B:23:0x0235, B:25:0x0239, B:29:0x0243, B:35:0x0274, B:32:0x0252, B:34:0x026b, B:33:0x025b, B:17:0x0143, B:19:0x0147, B:21:0x014f), top: B:47:0x000b }] */
    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m853L11I(IBinder iBinder, int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        boolean z;
        ImageReader imageReader;
        LIl.m908iILLL1();
        try {
            int i5 = 0;
            int i6 = !lIlii.m1122IliLL1i() ? 0 : i;
            try {
                ImageRender imageRender = this.f926iILLL1;
                if (imageRender != null) {
                    imageRender.stop();
                    this.f926iILLL1 = null;
                }
            } catch (Exception unused) {
            }
            ImageRender imageRender2 = new ImageRender();
            this.f926iILLL1 = imageRender2;
            try {
                if (imageRender2.open(rect.width(), rect.height(), i2, i3, i6)) {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 109}, I1I.IL1Iii.IL1Iii(new byte[]{83, 83, 85, 85, 90, 83}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 82, 4, 0, 7}, "d6a4b7"))), I1I.IL1Iii.IL1Iii(new byte[]{75, 86, 17, 124, 93, 70, 72, 95, 4, 65, 103, 64, 74, 85, 4, 91, 81, 21, 87, 88, 95}, I1I.IL1Iii.IL1Iii(new byte[]{11, 87, 0, 9, 1, 80}, I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 83, 82, 84, 0}, "386cae"))) + this.f926iILLL1.getSurface());
                    if (this.f926iILLL1.isSurfaceOk()) {
                        z = true;
                    } else {
                        try {
                            ImageRender imageRender3 = this.f926iILLL1;
                            if (imageRender3 != null) {
                                imageRender3.stop();
                                this.f926iILLL1 = null;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    imageReader = this.f925IiL;
                    if (imageReader != null) {
                        imageReader.close();
                        this.f925IiL = null;
                    }
                    if (z) {
                        LIl.m906Ll1(iBinder, this.f926iILLL1.getSurface());
                        i5 = i6;
                    } else {
                        if (i2 > 0 || i3 <= 0) {
                            this.f925IiL = ImageReader.newInstance(rect.width(), rect.height(), this.f924IL, 3);
                        } else {
                            this.f925IiL = ImageReader.newInstance(i2, i3, this.f924IL, 3);
                        }
                        LIl.m906Ll1(iBinder, this.f925IiL.getSurface());
                    }
                    LIl.ILL(iBinder, i5, rect, rect2);
                    LIl.m907L11I(iBinder, i4);
                }
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 108}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 80, 1, 87, 4}, I1I.IL1Iii.IL1Iii(new byte[]{8, 4, 82, 85, 80, 4}, "1e1050"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 70, 85, 86, 23, 12, 89, 87, 87, 93, 23, 23, 81, 88, 84, 93, 69, 69, 82, 87, 89, 84, 82, 1, 21, 23, 17}, I1I.IL1Iii.IL1Iii(new byte[]{1, 5, 0, 11, 86, 87}, I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 7, 7, 0, 86}, "6b74ad"))));
                imageReader = this.f925IiL;
                if (imageReader != null) {
                    imageReader.close();
                    this.f925IiL = null;
                }
            } catch (Exception unused3) {
            }
            z = false;
            if (z) {
                LIl.m906Ll1(iBinder, this.f926iILLL1.getSurface());
                i5 = i6;
            } else {
                if (i2 > 0) {
                    this.f925IiL = ImageReader.newInstance(rect.width(), rect.height(), this.f924IL, 3);
                } else {
                    this.f925IiL = ImageReader.newInstance(rect.width(), rect.height(), this.f924IL, 3);
                }
                LIl.m906Ll1(iBinder, this.f925IiL.getSurface());
            }
            LIl.ILL(iBinder, i5, rect, rect2);
            LIl.m907L11I(iBinder, i4);
        } finally {
            LIl.IL1Iii();
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 68, insns: 0 */
    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m854iILLL1() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Point pointM1180ILI = lIlii.m1180ILI();
        int i9 = pointM1180ILI.x;
        if (i9 <= 0 || (i8 = pointM1180ILI.y) <= 0) {
            i = 0;
            i2 = 0;
        } else {
            i = i8;
            i2 = i9;
        }
        C0600Lil c0600LilI1I = C0001i1.Ilil().I1I();
        this.f3091ILil = c0600LilI1I;
        C0599ILl c0599ILlIL1Iii = c0600LilI1I.IL1Iii(0);
        this.f3089I1I = Ilil();
        int iILil = c0599ILlIL1Iii.ILil().ILil();
        int iIL1Iii = c0599ILlIL1Iii.ILil().IL1Iii();
        if (i2 <= 0 || i <= 0) {
            i3 = iILil;
            i4 = iIL1Iii;
        } else if (c0599ILlIL1Iii.IL1Iii() % 2 != 0) {
            i3 = i;
            i4 = i2;
        } else {
            i4 = i;
            i3 = i2;
        }
        new Rect(0, 0, i3, i4);
        Rect rect = new Rect(0, 0, c0599ILlIL1Iii.ILil().ILil(), c0599ILlIL1Iii.ILil().IL1Iii());
        C0599ILl c0599ILlIL1Iii2 = this.f3091ILil.IL1Iii(0);
        int iIL1Iii2 = c0599ILlIL1Iii2.IL1Iii();
        int iILil2 = c0599ILlIL1Iii2.ILil().ILil();
        int iIL1Iii3 = c0599ILlIL1Iii2.ILil().IL1Iii();
        if (iIL1Iii2 % 2 != 0) {
            iIL1Iii3 = iILil2;
        }
        m853L11I(this.f3089I1I, iIL1Iii2, i3, i4, rect, rect, 0);
        int i10 = iIL1Iii3;
        while (true) {
            try {
                C0599ILl c0599ILlIL1Iii3 = this.f3091ILil.IL1Iii(0);
                int iIL1Iii4 = c0599ILlIL1Iii3.IL1Iii();
                int iILil3 = iIL1Iii4 % 2 != 0 ? c0599ILlIL1Iii3.ILil().ILil() : c0599ILlIL1Iii3.ILil().IL1Iii();
                boolean z = this.f3092Ilil;
                if (z || iIL1Iii4 != iIL1Iii2 || i10 != iILil3) {
                    if (z) {
                        try {
                            this.f3092Ilil = false;
                        } catch (Exception e) {
                            e = e;
                            i10 = iILil3;
                            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 108}, I1I.IL1Iii.IL1Iii(new byte[]{91, 86, 3, 3, 94, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 80, 0, 85, 10}, "846039"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 14, 87, 21, 25, 86, 69, 19, 2}, I1I.IL1Iii.IL1Iii(new byte[]{15, 2, 14, 85, 95, 0}, I1I.IL1Iii.IL1Iii(new byte[]{12, 2, 5, 9, 86, 87}, "4a390d"))) + e.toString());
                            Thread.sleep(100L);
                        }
                    }
                    try {
                        int iILil4 = c0599ILlIL1Iii3.ILil().ILil();
                        int iIL1Iii5 = c0599ILlIL1Iii3.ILil().IL1Iii();
                        if (i2 <= 0 || i <= 0) {
                            i6 = iILil4;
                            i7 = iIL1Iii5;
                        } else {
                            try {
                                if (c0599ILlIL1Iii3.IL1Iii() % 2 != 0) {
                                    i6 = i;
                                    i7 = i2;
                                } else {
                                    i7 = i;
                                    i6 = i2;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                i10 = iILil3;
                                iIL1Iii2 = iIL1Iii4;
                                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 108}, I1I.IL1Iii.IL1Iii(new byte[]{91, 86, 3, 3, 94, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 80, 0, 85, 10}, "846039"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 14, 87, 21, 25, 86, 69, 19, 2}, I1I.IL1Iii.IL1Iii(new byte[]{15, 2, 14, 85, 95, 0}, I1I.IL1Iii.IL1Iii(new byte[]{12, 2, 5, 9, 86, 87}, "4a390d"))) + e.toString());
                            }
                        }
                        new Rect(0, 0, i6, i7);
                        Rect rect2 = new Rect(0, 0, c0599ILlIL1Iii3.ILil().ILil(), c0599ILlIL1Iii3.ILil().IL1Iii());
                        LIl.I1I(this.f3089I1I);
                        IBinder iBinderIlil = Ilil();
                        this.f3089I1I = iBinderIlil;
                        i5 = iILil3;
                        try {
                            m853L11I(iBinderIlil, iIL1Iii4, i6, i7, rect2, rect2, 0);
                            i10 = i5;
                            iIL1Iii2 = iIL1Iii4;
                        } catch (Exception e3) {
                            e = e3;
                            i10 = i5;
                            iIL1Iii2 = iIL1Iii4;
                            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 108}, I1I.IL1Iii.IL1Iii(new byte[]{91, 86, 3, 3, 94, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 80, 0, 85, 10}, "846039"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 14, 87, 21, 25, 86, 69, 19, 2}, I1I.IL1Iii.IL1Iii(new byte[]{15, 2, 14, 85, 95, 0}, I1I.IL1Iii.IL1Iii(new byte[]{12, 2, 5, 9, 86, 87}, "4a390d"))) + e.toString());
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i5 = iILil3;
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m855il() {
        new Thread(new IL1Iii()).start();
    }
}
