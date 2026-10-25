package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class Point {

    /* JADX INFO: renamed from: x */
    public double f898x;

    /* JADX INFO: renamed from: y */
    public double f899y;

    public Point(double d, double d2) {
        this.f898x = d;
        this.f899y = d2;
    }

    public double dot(Point point) {
        return (this.f898x * point.f898x) + (this.f899y * point.f899y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.f898x == point.f898x && this.f899y == point.f899y;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f898x);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f899y);
        return (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f898x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f899y = dArr.length > 1 ? dArr[1] : 0.0d;
        } else {
            this.f898x = 0.0d;
            this.f899y = 0.0d;
        }
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{78}, IL1Iii.IL1Iii(new byte[]{4, 84, 86, 4, 7, 80}, IL1Iii.IL1Iii(new byte[]{87, 4, 93, 91, 80, 1}, "fe99f2"))) + this.f898x + IL1Iii.IL1Iii(new byte[]{24, 24}, IL1Iii.IL1Iii(new byte[]{1, 1, 8, 80, 0, 6}, IL1Iii.IL1Iii(new byte[]{84, 95, 6, 84, 85, 7}, "af6a1c"))) + this.f899y + IL1Iii.IL1Iii(new byte[]{69}, IL1Iii.IL1Iii(new byte[]{8, 89, 0, 11, 1, 4}, IL1Iii.IL1Iii(new byte[]{1, 93, 93, 2, 13, 93}, "1ed048")));
    }

    public Point clone() {
        return new Point(this.f898x, this.f899y);
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }
}
