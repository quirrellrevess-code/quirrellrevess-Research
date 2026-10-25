package I1I.p062Ilil.p064Ilil.ILil;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GlobalActionAutomator.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public I1I.p062Ilil.p064Ilil.p012IL.IL1Iii f3525IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Handler f3526ILil;

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlobalActionAutomator.java */
    public class C0541I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3527I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Path f3528IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3529ILil;

        public C0541I1I(I1I i1i) {
        }
    }

    /* JADX INFO: compiled from: GlobalActionAutomator.java */
    public class IL1Iii extends AccessibilityService.GestureResultCallback {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ I1I.p062Ilil.p064Ilil.I1I.ILil f3530IL1Iii;

        public IL1Iii(I1I i1i, I1I.p062Ilil.p064Ilil.I1I.ILil iLil) {
            this.f3530IL1Iii = iLil;
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCancelled(GestureDescription gestureDescription) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 96}, I1I.IL1Iii.IL1Iii(new byte[]{11, 13, 85, 13, 14, 1}, I1I.IL1Iii.IL1Iii(new byte[]{81, 12, 82, 0, 83, 4}, "b9b9e0"))), I1I.IL1Iii.IL1Iii(new byte[]{0, 95, 18, 19, 0, 69, 7, 94, 65, 5, 0, 88, 8, 83, 5}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 3, 84, 3, 7}, I1I.IL1Iii.IL1Iii(new byte[]{3, 15, 1, 5, 80, 80}, "09c22f"))));
            this.f3530IL1Iii.ILil(Boolean.FALSE);
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{45, 60}, I1I.IL1Iii.IL1Iii(new byte[]{85, 80, 1, 82, 4, 80}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 87, 80, 85, 83}, "37c171"))), I1I.IL1Iii.IL1Iii(new byte[]{7, 92, 21, 19, 0, 23, 0, 93, 70, 12, 10}, I1I.IL1Iii.IL1Iii(new byte[]{1, 87, 81, 7, 81, 80}, I1I.IL1Iii.IL1Iii(new byte[]{87, 4, 84, 86, 6, 85}, "5fc26f"))));
            this.f3530IL1Iii.ILil(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: GlobalActionAutomator.java */
    public class ILil extends AccessibilityService.GestureResultCallback {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ I1I.p062Ilil.p064Ilil.I1I.IL1Iii f3531IL1Iii;

        public ILil(I1I.p062Ilil.p064Ilil.I1I.IL1Iii iL1Iii) {
            this.f3531IL1Iii = iL1Iii;
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCancelled(GestureDescription gestureDescription) {
            this.f3531IL1Iii.ILil(Boolean.FALSE);
            I1I.this.LlLI1();
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            this.f3531IL1Iii.ILil(Boolean.TRUE);
            I1I.this.LlLI1();
        }
    }

    public I1I(Handler handler) {
        this.f3526ILil = handler;
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v7 */
    public boolean I1I(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            byte b = 4;
            byte b2 = 2;
            byte b3 = 3;
            int i = 6;
            byte b4 = 82;
            int i2 = 5;
            jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{18, 64, 72, 1}, I1I.IL1Iii.IL1Iii(new byte[]{82, 95, 14, 92, 82, 15}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 85, 8, 83, 13}, "1ec075"))));
            JSONArray jSONArray = jSONObject.getJSONArray(I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 18, 83}, I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 83, 0, 11, 3}, I1I.IL1Iii.IL1Iii(new byte[]{5, 87, 5, 86, 13, 80}, "3e0d4c"))));
            if (jSONArray.length() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                C0541I1I c0541i1i = new C0541I1I(this);
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                byte[] bArr = new byte[i2];
                bArr[0] = 81;
                bArr[1] = b4;
                bArr[b2] = 81;
                bArr[b3] = 15;
                bArr[b] = 8;
                byte[] bArr2 = new byte[i];
                bArr2[0] = 81;
                bArr2[1] = 85;
                bArr2[b2] = 84;
                bArr2[b3] = 7;
                bArr2[b] = b;
                bArr2[i2] = 10;
                byte[] bArr3 = new byte[i];
                bArr3[0] = 90;
                bArr3[1] = 84;
                bArr3[b2] = b3;
                bArr3[b3] = 7;
                bArr3[b] = 84;
                bArr3[i2] = b2;
                int i4 = jSONObject2.getInt(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "86af61"))));
                byte[] bArr4 = new byte[i];
                bArr4[0] = 80;
                bArr4[1] = 67;
                bArr4[b2] = 64;
                bArr4[b3] = 91;
                bArr4[b] = 88;
                bArr4[5] = i;
                byte[] bArr5 = new byte[i];
                bArr5[0] = 86;
                bArr5[1] = 7;
                bArr5[b2] = 86;
                bArr5[b3] = 10;
                bArr5[b] = 84;
                bArr5[5] = 7;
                byte[] bArr6 = new byte[i];
                bArr6[0] = i;
                bArr6[1] = b3;
                bArr6[b2] = b2;
                bArr6[b3] = 94;
                bArr6[b] = 82;
                bArr6[5] = 7;
                int i5 = jSONObject2.getInt(I1I.IL1Iii.IL1Iii(bArr4, I1I.IL1Iii.IL1Iii(bArr5, I1I.IL1Iii.IL1Iii(bArr6, "d2ff0a"))));
                byte[] bArr7 = new byte[b];
                bArr7[0] = 65;
                bArr7[1] = 80;
                bArr7[b2] = 77;
                bArr7[b3] = 95;
                byte[] bArr8 = new byte[6];
                bArr8[0] = 87;
                bArr8[1] = 5;
                bArr8[b2] = 9;
                bArr8[b3] = 82;
                bArr8[b] = b3;
                bArr8[5] = b;
                byte[] bArr9 = new byte[6];
                bArr9[0] = b3;
                bArr9[1] = 1;
                bArr9[b2] = 0;
                bArr9[b3] = 92;
                bArr9[4] = 80;
                bArr9[5] = b2;
                JSONArray jSONArray2 = jSONObject2.getJSONArray(I1I.IL1Iii.IL1Iii(bArr7, I1I.IL1Iii.IL1Iii(bArr8, I1I.IL1Iii.IL1Iii(bArr9, "e5095d"))));
                c0541i1i.f3528IL1Iii = new Path();
                c0541i1i.f3529ILil = i4;
                c0541i1i.f3527I1I = i5;
                int i6 = 0;
                while (i6 < jSONArray2.length()) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i6);
                    byte[] bArr10 = new byte[6];
                    bArr10[0] = 7;
                    bArr10[1] = 5;
                    bArr10[b2] = 4;
                    bArr10[b3] = 6;
                    bArr10[4] = 93;
                    bArr10[5] = 81;
                    byte[] bArr11 = new byte[6];
                    bArr11[0] = 83;
                    bArr11[1] = b3;
                    bArr11[b2] = 4;
                    bArr11[b3] = 5;
                    bArr11[4] = 89;
                    bArr11[5] = 81;
                    int i7 = jSONObject3.getInt(I1I.IL1Iii.IL1Iii(new byte[]{73}, I1I.IL1Iii.IL1Iii(bArr10, I1I.IL1Iii.IL1Iii(bArr11, "e4e4a3"))));
                    byte[] bArr12 = new byte[6];
                    bArr12[0] = 9;
                    bArr12[1] = 81;
                    bArr12[b2] = 12;
                    bArr12[b3] = 92;
                    bArr12[4] = b2;
                    bArr12[5] = 84;
                    byte[] bArr13 = new byte[6];
                    bArr13[0] = 94;
                    bArr13[1] = 80;
                    bArr13[b2] = 6;
                    bArr13[3] = 87;
                    bArr13[4] = b2;
                    bArr13[5] = 91;
                    int i8 = jSONObject3.getInt(I1I.IL1Iii.IL1Iii(new byte[]{72}, I1I.IL1Iii.IL1Iii(bArr12, I1I.IL1Iii.IL1Iii(bArr13, "fb3369"))));
                    if (i6 == 0) {
                        float f = i7;
                        float f2 = i8;
                        c0541i1i.f3528IL1Iii.moveTo(f, f2);
                        if (jSONArray2.length() == 1) {
                            c0541i1i.f3528IL1Iii.lineTo(f, f2);
                        }
                    } else {
                        c0541i1i.f3528IL1Iii.lineTo(i7, i8);
                    }
                    i6++;
                    b2 = 2;
                    b3 = 3;
                }
                if (i6 > 0) {
                    arrayList.add(c0541i1i);
                }
                i3++;
                b = 4;
                i2 = 5;
                b2 = 2;
                b3 = 3;
                i = 6;
                b4 = 82;
            }
            if (arrayList.size() <= 0) {
                return false;
            }
            GestureDescription.Builder builder = new GestureDescription.Builder();
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                C0541I1I c0541i1i2 = (C0541I1I) arrayList.get(i9);
                builder = builder.addStroke(new GestureDescription.StrokeDescription(c0541i1i2.f3528IL1Iii, c0541i1i2.f3529ILil, c0541i1i2.f3527I1I));
            }
            return this.f3526ILil == null ? m1318iILLL1(builder.build()) : m1322lLi1LL(builder.build());
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean ILL(int i) {
        AccessibilityService accessibilityServiceM1323il = m1323il();
        if (accessibilityServiceM1323il == null) {
            return false;
        }
        return accessibilityServiceM1323il.performGlobalAction(i);
    }

    public boolean ILil() {
        return ILL(1);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m1313ILl() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
    }

    public boolean Ilil(GestureDescription.StrokeDescription... strokeDescriptionArr) {
        if (m1323il() == null) {
            return false;
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        for (GestureDescription.StrokeDescription strokeDescription : strokeDescriptionArr) {
            builder.addStroke(strokeDescription);
        }
        return this.f3526ILil == null ? m1318iILLL1(builder.build()) : m1322lLi1LL(builder.build());
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1314IL(long j, long j2, int[]... iArr) {
        return Ilil(new GestureDescription.StrokeDescription(m1316Ll1(iArr), j, j2));
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m1315IiL() {
        return ILL(2);
    }

    public boolean Lil(int i, int i2, int i3) {
        return m1314IL(0L, i3, new int[]{i, i2});
    }

    public final void LlLI1() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final Path m1316Ll1(int[][] iArr) {
        Path path = new Path();
        path.moveTo(m1320lIlii(iArr[0][0]), iIi1(iArr[0][1]));
        for (int i = 1; i < iArr.length; i++) {
            int[] iArr2 = iArr[i];
            path.lineTo(m1320lIlii(iArr2[0]), iIi1(iArr2[1]));
        }
        return path;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean m1317L11I(int i, int i2) {
        return m1314IL(0L, ViewConfiguration.getLongPressTimeout() + 200, new int[]{i, i2});
    }

    public final int iIi1(int i) {
        I1I.p062Ilil.p064Ilil.p012IL.IL1Iii iL1Iii = this.f3525IL1Iii;
        return iL1Iii == null ? i : iL1Iii.ILil(i);
    }

    public boolean iIlLiL(int i, int i2, int i3, int i4, int i5) {
        return m1314IL(0L, i5, new int[]{i, i2}, new int[]{i3, i4});
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final boolean m1318iILLL1(GestureDescription gestureDescription) {
        m1313ILl();
        I1I.p062Ilil.p064Ilil.I1I.IL1Iii iL1Iii = new I1I.p062Ilil.p064Ilil.I1I.IL1Iii(Boolean.FALSE);
        Handler handler = new Handler(Looper.myLooper());
        AccessibilityService accessibilityServiceM1323il = m1323il();
        if (accessibilityServiceM1323il == null) {
            return false;
        }
        accessibilityServiceM1323il.dispatchGesture(gestureDescription, new ILil(iL1Iii), handler);
        Looper.loop();
        return ((Boolean) iL1Iii.IL1Iii()).booleanValue();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m1319lIiI() {
        return ILL(6);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final int m1320lIlii(int i) {
        I1I.p062Ilil.p064Ilil.p012IL.IL1Iii iL1Iii = this.f3525IL1Iii;
        return iL1Iii == null ? i : iL1Iii.IL1Iii(i);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m1321llL1ii() {
        return ILL(3);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m1322lLi1LL(GestureDescription gestureDescription) {
        I1I.p062Ilil.p064Ilil.I1I.ILil iLil = new I1I.p062Ilil.p064Ilil.I1I.ILil();
        AccessibilityService accessibilityServiceM1323il = m1323il();
        if (accessibilityServiceM1323il == null) {
            return false;
        }
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 104}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 1, 87, 82, 93}, I1I.IL1Iii.IL1Iii(new byte[]{10, 84, 10, 81, 94, 0}, "8b308e"))), I1I.IL1Iii.IL1Iii(new byte[]{83, 8, 67, 20, 81, 17, 84, 9, 16, 6, 85, 2, 94, 15}, I1I.IL1Iii.IL1Iii(new byte[]{14, 87, 9, 0, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{13, 87, 12, 93, 1, 86}, "4a59ea"))));
        if (accessibilityServiceM1323il.dispatchGesture(gestureDescription, new IL1Iii(this, iLil), this.f3526ILil)) {
            return ((Boolean) iLil.IL1Iii()).booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final AccessibilityService m1323il() {
        return com.p000nx.uiauto.accessibility.AccessibilityService.Ilil();
    }
}
