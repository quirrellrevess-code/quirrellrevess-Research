package org.opencv.core;

import I1I.IL1Iii;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Scalar {
    public double[] val;

    public Scalar(double d, double d2, double d3, double d4) {
        this.val = new double[]{d, d2, d3, d4};
    }

    public static Scalar all(double d) {
        return new Scalar(d, d, d, d);
    }

    public Scalar conj() {
        double[] dArr = this.val;
        return new Scalar(dArr[0], -dArr[1], -dArr[2], -dArr[3]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Scalar) && Arrays.equals(this.val, ((Scalar) obj).val);
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.val);
    }

    public boolean isReal() {
        double[] dArr = this.val;
        return dArr[1] == 0.0d && dArr[2] == 0.0d && dArr[3] == 0.0d;
    }

    public Scalar mul(Scalar scalar, double d) {
        double[] dArr = this.val;
        double d2 = dArr[0];
        double[] dArr2 = scalar.val;
        return new Scalar(d2 * dArr2[0] * d, dArr[1] * dArr2[1] * d, dArr[2] * dArr2[2] * d, dArr[3] * dArr2[3] * d);
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            double[] dArr2 = this.val;
            dArr2[0] = dArr.length > 0 ? dArr[0] : 0.0d;
            dArr2[1] = dArr.length > 1 ? dArr[1] : 0.0d;
            dArr2[2] = dArr.length > 2 ? dArr[2] : 0.0d;
            dArr2[3] = dArr.length > 3 ? dArr[3] : 0.0d;
            return;
        }
        double[] dArr3 = this.val;
        dArr3[3] = 0.0d;
        dArr3[2] = 0.0d;
        dArr3[1] = 0.0d;
        dArr3[0] = 0.0d;
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{99}, IL1Iii.IL1Iii(new byte[]{90, 83, 83, 85, 82, 85}, IL1Iii.IL1Iii(new byte[]{87, 0, 81, 7, 2, 82}, "51dcaf"))) + this.val[0] + IL1Iii.IL1Iii(new byte[]{30, 23}, IL1Iii.IL1Iii(new byte[]{2, 7, 7, 90, 4, 5}, IL1Iii.IL1Iii(new byte[]{9, 4, 83, 86, 81, 4}, "9424d7"))) + this.val[1] + IL1Iii.IL1Iii(new byte[]{20, 70}, IL1Iii.IL1Iii(new byte[]{15, 85, 82, 3, 7, 14}, IL1Iii.IL1Iii(new byte[]{3, 87, 7, 87, 4, 0}, "4deaf7"))) + this.val[2] + IL1Iii.IL1Iii(new byte[]{73, 68}, IL1Iii.IL1Iii(new byte[]{1, 7, 92, 93, 92, 80}, IL1Iii.IL1Iii(new byte[]{0, 5, 94, 14, 84, 85}, "dff707"))) + this.val[3] + IL1Iii.IL1Iii(new byte[]{62}, IL1Iii.IL1Iii(new byte[]{86, 7, 84, 94, 95, 88}, IL1Iii.IL1Iii(new byte[]{1, 80, 84, 89, 7, 14}, "43aaa7")));
    }

    public Scalar clone() {
        return new Scalar(this.val);
    }

    public Scalar mul(Scalar scalar) {
        return mul(scalar, 1.0d);
    }

    public Scalar(double d, double d2, double d3) {
        this.val = new double[]{d, d2, d3, 0.0d};
    }

    public Scalar(double d, double d2) {
        this.val = new double[]{d, d2, 0.0d, 0.0d};
    }

    public Scalar(double d) {
        this.val = new double[]{d, 0.0d, 0.0d, 0.0d};
    }

    public Scalar(double[] dArr) {
        if (dArr != null && dArr.length == 4) {
            this.val = (double[]) dArr.clone();
        } else {
            this.val = new double[4];
            set(dArr);
        }
    }
}
