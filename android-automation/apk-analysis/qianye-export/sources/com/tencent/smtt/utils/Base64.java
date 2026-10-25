package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class Base64 {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ boolean f664a = true;

    /* JADX INFO: renamed from: com.tencent.smtt.utils.Base64$a */
    public static abstract class AbstractC0434a {

        /* JADX INFO: renamed from: a */
        public byte[] f665a;

        /* JADX INFO: renamed from: b */
        public int f666b;
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.Base64$b */
    public static class C0435b extends AbstractC0434a {

        /* JADX INFO: renamed from: c */
        private static final int[] f667c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: d */
        private static final int[] f668d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* JADX INFO: renamed from: e */
        private int f669e;

        /* JADX INFO: renamed from: f */
        private int f670f;

        /* JADX INFO: renamed from: g */
        private final int[] f671g;

        public C0435b(int i, byte[] bArr) {
            this.f665a = bArr;
            this.f671g = (i & 8) == 0 ? f667c : f668d;
            this.f669e = 0;
            this.f670f = 0;
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00d6  */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00fe, code lost:
        
            if (r5 != 4) goto L71;
         */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean m617a(byte[] r17, int r18, int r19, boolean r20) {
            /*
                Method dump skipped, instruction units count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.C0435b.m617a(byte[], int, int, boolean):boolean");
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.Base64$c */
    public static class C0436c extends AbstractC0434a {

        /* JADX INFO: renamed from: g */
        public static final /* synthetic */ boolean f672g = true;

        /* JADX INFO: renamed from: h */
        private static final byte[] f673h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* JADX INFO: renamed from: i */
        private static final byte[] f674i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* JADX INFO: renamed from: c */
        public int f675c;

        /* JADX INFO: renamed from: d */
        public final boolean f676d;

        /* JADX INFO: renamed from: e */
        public final boolean f677e;

        /* JADX INFO: renamed from: f */
        public final boolean f678f;

        /* JADX INFO: renamed from: j */
        private final byte[] f679j;

        /* JADX INFO: renamed from: k */
        private int f680k;

        /* JADX INFO: renamed from: l */
        private final byte[] f681l;

        public C0436c(int i, byte[] bArr) {
            this.f665a = bArr;
            this.f676d = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.f677e = z;
            this.f678f = (i & 4) != 0;
            this.f681l = (i & 8) == 0 ? f673h : f674i;
            this.f679j = new byte[2];
            this.f675c = 0;
            this.f680k = z ? 19 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x00d4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:12:0x0050  */
        /* JADX WARN: Code duplicated, block: B:27:0x0094  */
        /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:32:0x00dd A[EDGE_INSN: B:32:0x00dd->B:22:0x008a BREAK  A[LOOP:0: B:25:0x0090->B:33:0x00e4]] */
        /* JADX WARN: Code duplicated, block: B:33:0x00e4 A[LOOP:0: B:25:0x0090->B:33:0x00e4, LOOP_END] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX INFO: renamed from: a */
        public boolean m618a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instruction units count: 513
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.C0436c.m618a(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m612a(String str, int i) {
        return m613a(str.getBytes(), i);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m613a(byte[] bArr, int i) {
        return m614a(bArr, 0, bArr.length, i);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m614a(byte[] bArr, int i, int i2, int i3) {
        C0435b c0435b = new C0435b(i3, new byte[(i2 * 3) / 4]);
        if (!c0435b.m617a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i4 = c0435b.f666b;
        byte[] bArr2 = c0435b.f665a;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m615b(byte[] bArr, int i) {
        return m616b(bArr, 0, bArr.length, i);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m616b(byte[] bArr, int i, int i2, int i3) {
        C0436c c0436c = new C0436c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c0436c.f676d) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c0436c.f677e && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (c0436c.f678f ? 2 : 1);
        }
        c0436c.f665a = new byte[i4];
        c0436c.m618a(bArr, i, i2, true);
        if (f664a || c0436c.f666b == i4) {
            return c0436c.f665a;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(m615b(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
