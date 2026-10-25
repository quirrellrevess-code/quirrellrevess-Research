package I1I;

/* JADX INFO: compiled from: OooOO0OO.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {
    public static String IL1Iii(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i % length2));
        }
        return new String(bArr);
    }
}
