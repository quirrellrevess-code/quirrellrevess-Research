package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class RotatedRect {
    public double angle;
    public Point center;
    public Size size;

    public RotatedRect() {
        this.center = new Point();
        this.size = new Size();
        this.angle = 0.0d;
    }

    public Rect boundingRect() {
        Point[] pointArr = new Point[4];
        points(pointArr);
        Rect rect = new Rect((int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f898x, pointArr[1].f898x), pointArr[2].f898x), pointArr[3].f898x)), (int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f899y, pointArr[1].f899y), pointArr[2].f899y), pointArr[3].f899y)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f898x, pointArr[1].f898x), pointArr[2].f898x), pointArr[3].f898x)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f899y, pointArr[1].f899y), pointArr[2].f899y), pointArr[3].f899y)));
        rect.width -= rect.f903x - 1;
        rect.height -= rect.f904y - 1;
        return rect;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotatedRect)) {
            return false;
        }
        RotatedRect rotatedRect = (RotatedRect) obj;
        return this.center.equals(rotatedRect.center) && this.size.equals(rotatedRect.size) && this.angle == rotatedRect.angle;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.center.f898x);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.center.f899y);
        int i = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return (i3 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
    }

    public void points(Point[] pointArr) {
        double d = (this.angle * 3.141592653589793d) / 180.0d;
        double dCos = Math.cos(d) * 0.5d;
        double dSin = Math.sin(d) * 0.5d;
        Point point = this.center;
        double d2 = point.f898x;
        Size size = this.size;
        double d3 = size.height;
        double d4 = size.width;
        pointArr[0] = new Point((d2 - (dSin * d3)) - (dCos * d4), (point.f899y + (d3 * dCos)) - (d4 * dSin));
        Point point2 = this.center;
        double d5 = point2.f898x;
        Size size2 = this.size;
        double d6 = size2.height;
        double d7 = size2.width;
        pointArr[1] = new Point((d5 + (dSin * d6)) - (dCos * d7), (point2.f899y - (dCos * d6)) - (dSin * d7));
        Point point3 = this.center;
        pointArr[2] = new Point((point3.f898x * 2.0d) - pointArr[0].f898x, (point3.f899y * 2.0d) - pointArr[0].f899y);
        Point point4 = this.center;
        pointArr[3] = new Point((point4.f898x * 2.0d) - pointArr[1].f898x, (point4.f899y * 2.0d) - pointArr[1].f899y);
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            Point point = this.center;
            point.f898x = dArr.length > 0 ? dArr[0] : 0.0d;
            point.f899y = dArr.length > 1 ? dArr[1] : 0.0d;
            Size size = this.size;
            size.width = dArr.length > 2 ? dArr[2] : 0.0d;
            size.height = dArr.length > 3 ? dArr[3] : 0.0d;
            this.angle = dArr.length > 4 ? dArr[4] : 0.0d;
            return;
        }
        Point point2 = this.center;
        point2.f898x = 0.0d;
        point2.f899y = 0.0d;
        Size size2 = this.size;
        size2.width = 0.0d;
        size2.height = 0.0d;
        this.angle = 0.0d;
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{76, 67}, IL1Iii.IL1Iii(new byte[]{86, 81, 83, 2, 80, 87}, IL1Iii.IL1Iii(new byte[]{80, 5, 92, 86, 6, 1}, "178a0e"))) + this.center + " " + this.size + IL1Iii.IL1Iii(new byte[]{66, 18, 16}, IL1Iii.IL1Iii(new byte[]{1, 10, 8, 4, 91, 0}, IL1Iii.IL1Iii(new byte[]{91, 10, 92, 83, 91, 85}, "88dfc4"))) + this.angle + IL1Iii.IL1Iii(new byte[]{21, 78}, IL1Iii.IL1Iii(new byte[]{2, 4, 15, 3, 82, 5}, IL1Iii.IL1Iii(new byte[]{85, 7, 13, 85, 84, 95}, "b04409")));
    }

    public RotatedRect clone() {
        return new RotatedRect(this.center, this.size, this.angle);
    }

    public RotatedRect(Point point, Size size, double d) {
        this.center = point.clone();
        this.size = size.clone();
        this.angle = d;
    }

    public RotatedRect(double[] dArr) {
        this();
        set(dArr);
    }
}
