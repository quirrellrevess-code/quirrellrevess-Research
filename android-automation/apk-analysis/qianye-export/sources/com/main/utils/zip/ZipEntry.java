package com.main.utils.zip;

import I1I.IL1Iii;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ZipEntry implements Cloneable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long f5364I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public String f5365ILil;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public byte[] f2894IiL;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public long f2893IL = -1;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public long f5366Ilil = -1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public long f2896lLi1LL = -1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f2895iILLL1 = -1;

    public ZipEntry(String str) {
        Objects.requireNonNull(str);
        if (str.length() > 65535) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{6, 92, 22, 16, 77, 68, 13, 83, 15, 7, 20, 16, 12, 93, 66, 14, 91, 10, 4}, IL1Iii.IL1Iii(new byte[]{2, 2, 91, 0, 80, 80}, IL1Iii.IL1Iii(new byte[]{84, 8, 8, 85, 5, 12}, "5817a8"))));
        }
        this.f5365ILil = str;
    }

    public void I1I(byte[] bArr) {
        if (bArr != null && bArr.length > 65535) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{93, 86, 78, 83, 94, 10, 80, 24, 93, 74, 70, 17, 85, 24, 94, 91, 87, 15, 80, 24, 84, 87, 92, 4, 64, 80}, IL1Iii.IL1Iii(new byte[]{4, 0, 94, 7, 2, 0}, IL1Iii.IL1Iii(new byte[]{2, 15, 85, 84, 7, 6}, "273a7e"))));
        }
        this.f2894IiL = bArr;
    }

    public String IL1Iii() {
        return this.f5365ILil;
    }

    public boolean ILil() {
        return this.f5365ILil.endsWith(IL1Iii.IL1Iii(new byte[]{74}, IL1Iii.IL1Iii(new byte[]{6, 6, 92, 4, 6, 13}, IL1Iii.IL1Iii(new byte[]{83, 0, 4, 82, 83, 87}, "03a06c"))));
    }

    public Object clone() {
        try {
            ZipEntry zipEntry = (ZipEntry) super.clone();
            byte[] bArr = this.f2894IiL;
            zipEntry.f2894IiL = bArr == null ? null : (byte[]) bArr.clone();
            return zipEntry;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        return this.f5365ILil.hashCode();
    }

    public String toString() {
        return IL1Iii();
    }
}
