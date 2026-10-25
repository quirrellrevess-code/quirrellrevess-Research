package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class Rect2d {
    public double height;
    public double width;

    /* JADX INFO: renamed from: x */
    public double f905x;

    /* JADX INFO: renamed from: y */
    public double f906y;

    public Rect2d(double d, double d2, double d3, double d4) {
        this.f905x = d;
        this.f906y = d2;
        this.width = d3;
        this.height = d4;
    }

    public double area() {
        return this.width * this.height;
    }

    /* JADX INFO: renamed from: br */
    public Point m835br() {
        return new Point(this.f905x + this.width, this.f906y + this.height);
    }

    public boolean contains(Point point) {
        double d = this.f905x;
        double d2 = point.f898x;
        if (d <= d2 && d2 < d + this.width) {
            double d3 = this.f906y;
            double d4 = point.f899y;
            if (d3 <= d4 && d4 < d3 + this.height) {
                return true;
            }
        }
        return false;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        return this.f905x == rect2d.f905x && this.f906y == rect2d.f906y && this.width == rect2d.width && this.height == rect2d.height;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.height);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.width);
        int i = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f905x);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f906y);
        return (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f905x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f906y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.width = dArr.length > 2 ? dArr[2] : 0.0d;
            this.height = dArr.length > 3 ? dArr[3] : 0.0d;
            return;
        }
        this.f905x = 0.0d;
        this.f906y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    /* JADX INFO: renamed from: tl */
    public Point m836tl() {
        return new Point(this.f905x, this.f906y);
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{79}, IL1Iii.IL1Iii(new byte[]{4, 10, 4, 81, 10, 86}, IL1Iii.IL1Iii(new byte[]{7, 92, 0, 7, 1, 80}, "7d7a8e"))) + this.f905x + IL1Iii.IL1Iii(new byte[]{73, 22}, IL1Iii.IL1Iii(new byte[]{85, 82, 11, 83, 4, 81}, IL1Iii.IL1Iii(new byte[]{83, 82, 90, 83, 84, 2}, "c6b716"))) + this.f906y + IL1Iii.IL1Iii(new byte[]{78, 17}, IL1Iii.IL1Iii(new byte[]{3, 7, 87, 5, 2, 80}, IL1Iii.IL1Iii(new byte[]{86, 2, 85, 87, 14, 84}, "74db96"))) + this.width + IL1Iii.IL1Iii(new byte[]{72}, IL1Iii.IL1Iii(new byte[]{86, 5, 9, 83, 89, 3}, IL1Iii.IL1Iii(new byte[]{85, 11, 85, 84, 82, 3}, "39e13b"))) + this.height + IL1Iii.IL1Iii(new byte[]{28}, IL1Iii.IL1Iii(new byte[]{3, 6, 6, 83, 87, 3}, IL1Iii.IL1Iii(new byte[]{83, 13, 5, 83, 10, 5}, "186c97")));
    }

    public Rect2d clone() {
        return new Rect2d(this.f905x, this.f906y, this.width, this.height);
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        double d = point.f898x;
        double d2 = point2.f898x;
        double d3 = d < d2 ? d : d2;
        this.f905x = d3;
        double d4 = point.f899y;
        double d5 = point2.f899y;
        double d6 = d4 < d5 ? d4 : d5;
        this.f906y = d6;
        this.width = (d <= d2 ? d2 : d) - d3;
        this.height = (d4 <= d5 ? d5 : d4) - d6;
    }

    public Rect2d(Point point, Size size) {
        this(point.f898x, point.f899y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }
}
