package p051lLi1LL.IL1Iii.ILil.IL1Iii;

import com.mysql.jdbc.StatementImpl;
import com.sun.mail.imap.IMAPFolder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: Simple8BitZipEncoding.java */
/* JADX INFO: loaded from: classes.dex */
public class C0677il implements lIlii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final char[] f5522IL1Iii;

    /* JADX INFO: renamed from: l丨Li1LL.IL1Iii.ILil.IL1Iii.丨il$IL1Iii */
    /* JADX INFO: compiled from: Simple8BitZipEncoding.java */
    public static final class IL1Iii implements Comparable<IL1Iii> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final byte f5523I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final char f5524ILil;

        public IL1Iii(byte b, char c) {
            this.f5523I1I = b;
            this.f5524ILil = c;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compareTo(IL1Iii iL1Iii) {
            return this.f5524ILil - iL1Iii.f5524ILil;
        }

        public boolean equals(Object obj) {
            if (obj instanceof IL1Iii) {
                IL1Iii iL1Iii = (IL1Iii) obj;
                if (this.f5524ILil == iL1Iii.f5524ILil && this.f5523I1I == iL1Iii.f5523I1I) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f5524ILil;
        }

        public String toString() {
            return "0x" + Integer.toHexString(this.f5524ILil & IMAPFolder.UNKNOWN_SEPARATOR) + "->0x" + Integer.toHexString(this.f5523I1I & StatementImpl.USES_VARIABLES_UNKNOWN);
        }
    }

    public C0677il(char[] cArr) {
        char[] cArr2 = (char[]) cArr.clone();
        this.f5522IL1Iii = cArr2;
        ArrayList arrayList = new ArrayList(cArr2.length);
        byte b = 127;
        int i = 0;
        while (true) {
            char[] cArr3 = this.f5522IL1Iii;
            if (i >= cArr3.length) {
                Collections.sort(arrayList);
                Collections.unmodifiableList(arrayList);
                return;
            } else {
                b = (byte) (b + 1);
                arrayList.add(new IL1Iii(b, cArr3[i]));
                i++;
            }
        }
    }

    @Override // p051lLi1LL.IL1Iii.ILil.IL1Iii.lIlii
    public String IL1Iii(byte[] bArr) throws IOException {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = ILil(bArr[i]);
        }
        return new String(cArr);
    }

    public char ILil(byte b) {
        return b >= 0 ? (char) b : this.f5522IL1Iii[b + 128];
    }
}
