package com.main.engine;

import I1I.I1I.ILil.RunnableC0091il;
import I1I.I1I.p000IL.lIlii;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Main {
    public static RunnableC0091il mCoreService;

    public static class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f4457ILil;

        public IL1Iii(int i) {
            this.f4457ILil = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            lIlii.ILil();
            RunnableC0091il runnableC0091il = new RunnableC0091il(this.f4457ILil);
            Main.mCoreService = runnableC0091il;
            runnableC0091il.m2221(lIlii.LiL1());
        }
    }

    public static void main(String[] strArr) {
        int i;
        Looper.prepareMainLooper();
        Map<String, String> map = System.getenv();
        int i2 = 0;
        try {
            int i3 = Integer.parseInt(map.get(I1I.IL1Iii.IL1Iii(new byte[]{109, 56, 100, 36}, I1I.IL1Iii.IL1Iii(new byte[]{88, 2, 13, 83, 84, 83}, I1I.IL1Iii.IL1Iii(new byte[]{81, 1, 91, 6, 82, 84}, "0bb46a")))));
            String str = map.get(I1I.IL1Iii.IL1Iii(new byte[]{98, 120, 34}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 1, 4, 7, 88}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 83, 3, 5, 85}, "617754"))));
            String str2 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{113, 53, 114}, I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 95, 14, 2, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 84, 92, 7, 83}, "352d31"))));
            String str3 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{98, 116, 54, 50, 43, 43, 122}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 85, 7, 4, 82}, I1I.IL1Iii.IL1Iii(new byte[]{80, 81, 3, 4, 83, 1}, "ea2b57"))));
            String str4 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{99, 44, 103, 108, 54}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 12, 2, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 13, 2, 1, 81}, "0443e0"))));
            String str5 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{110, 122, 103, 57, 120}, I1I.IL1Iii.IL1Iii(new byte[]{92, 82, 86, 4, 86, 86}, I1I.IL1Iii.IL1Iii(new byte[]{92, 80, 87, 1, 85, 84}, "814c3d"))));
            String str6 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{115, 43, 106, 100, 59, 96}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 11, 87, 6, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 83, 2, 3, 83}, "d0aaac"))));
            String str7 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{117, 126, 98, 98, 62, 45}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 80, 10, 87, 92}, I1I.IL1Iii.IL1Iii(new byte[]{87, 81, 89, 12, 1, 95}, "50847f"))));
            String str8 = map.get(I1I.IL1Iii.IL1Iii(new byte[]{125, 120, 38, 124, 123, 100}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 80, 89, 5, 84}, I1I.IL1Iii.IL1Iii(new byte[]{80, 0, 7, 3, 14, 3}, "c73b9a"))));
            i = Integer.parseInt(str3);
            try {
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                    lIlii.I1LilL(Integer.parseInt(str4), Integer.parseInt(str5));
                }
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                    lIlii.LLlIiil(Integer.parseInt(str6), Integer.parseInt(str7));
                }
            } catch (Exception unused) {
            }
            try {
                lIlii.m371IiL(str2);
                lIlii.l1ILIl(i3);
                lIlii.m372I(str);
                if (TextUtils.isEmpty(str8)) {
                    lIlii.L1li1(null, str, str2, i3);
                } else {
                    lIlii.L1li1(str8, str, str2, i3);
                }
                lIlii.m279I11IIi(str, str2, i3);
                lIlii.LLIIllII(str, str + I1I.IL1Iii.IL1Iii(new byte[]{13, 70, 86, 14, 9, 17, 82}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 1, 85, 84, 93}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 83, 83, 86, 94}, "fcaedf"))));
            } catch (Exception e) {
                e = e;
                i2 = i;
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 62}, I1I.IL1Iii.IL1Iii(new byte[]{12, 7, 11, 14, 9, 87}, I1I.IL1Iii.IL1Iii(new byte[]{80, 82, 85, 15, 10, 3}, "d3f725"))), I1I.IL1Iii.IL1Iii(new byte[]{89, 10, 80, 71, 66, 84, 66, 22, 3}, I1I.IL1Iii.IL1Iii(new byte[]{81, 6, 95, 2, 7, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 81, 83, 87, 86}, "4c7b24"))) + e.toString());
                i = i2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        new Handler().post(new IL1Iii(i));
        Looper.loop();
    }
}
