package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class Point3 {

    /* JADX INFO: renamed from: x */
    public double f900x;

    /* JADX INFO: renamed from: y */
    public double f901y;

    /* JADX INFO: renamed from: z */
    public double f902z;

    public Point3(double d, double d2, double d3) {
        this.f900x = d;
        this.f901y = d2;
        this.f902z = d3;
    }

    public Point3 cross(Point3 point3) {
        double d = this.f901y;
        double d2 = point3.f902z;
        double d3 = this.f902z;
        double d4 = point3.f901y;
        double d5 = (d * d2) - (d3 * d4);
        double d6 = point3.f900x;
        double d7 = this.f900x;
        return new Point3(d5, (d3 * d6) - (d2 * d7), (d7 * d4) - (d * d6));
    }

    public double dot(Point3 point3) {
        return (this.f900x * point3.f900x) + (this.f901y * point3.f901y) + (this.f902z * point3.f902z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }
        Point3 point3 = (Point3) obj;
        return this.f900x == point3.f900x && this.f901y == point3.f901y && this.f902z == point3.f902z;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f900x);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f901y);
        int i = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f902z);
        return (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f900x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f901y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.f902z = dArr.length > 2 ? dArr[2] : 0.0d;
        } else {
            this.f900x = 0.0d;
            this.f901y = 0.0d;
            this.f902z = 0.0d;
        }
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{72}, IL1Iii.IL1Iii(new byte[]{1, 6, 88, 3, 83, 1}, IL1Iii.IL1Iii(new byte[]{7, 82, 4, 7, 5, 4}, "5ae157"))) + this.f900x + IL1Iii.IL1Iii(new byte[]{72, 16}, IL1Iii.IL1Iii(new byte[]{83, 8, 83, 85, 92, 1}, IL1Iii.IL1Iii(new byte[]{7, 94, 6, 82, 14, 0}, "0f476d"))) + this.f901y + IL1Iii.IL1Iii(new byte[]{24, 23}, IL1Iii.IL1Iii(new byte[]{82, 2, 2, 92, 87, 5}, IL1Iii.IL1Iii(new byte[]{87, 83, 87, 82, 93, 4}, "1fb686"))) + this.f902z + IL1Iii.IL1Iii(new byte[]{78}, IL1Iii.IL1Iii(new byte[]{85, 6, 85, 11, 0, 82}, IL1Iii.IL1Iii(new byte[]{3, 0, 87, 8, 9, 87}, "e0519c")));
    }

    public Point3 clone() {
        return new Point3(this.f900x, this.f901y, this.f902z);
    }

    public Point3() {
        this(0.0d, 0.0d, 0.0d);
    }

    public Point3(Point point) {
        this.f900x = point.f898x;
        this.f901y = point.f899y;
        this.f902z = 0.0d;
    }

    public Point3(double[] dArr) {
        this();
        set(dArr);
    }
}
