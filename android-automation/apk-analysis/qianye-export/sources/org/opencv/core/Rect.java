package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class Rect {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f903x;

    /* JADX INFO: renamed from: y */
    public int f904y;

    public Rect(int i, int i2, int i3, int i4) {
        this.f903x = i;
        this.f904y = i2;
        this.width = i3;
        this.height = i4;
    }

    public double area() {
        return this.width * this.height;
    }

    /* JADX INFO: renamed from: br */
    public Point m833br() {
        return new Point(this.f903x + this.width, this.f904y + this.height);
    }

    public boolean contains(Point point) {
        int i = this.f903x;
        double d = i;
        double d2 = point.f898x;
        if (d <= d2 && d2 < i + this.width) {
            int i2 = this.f904y;
            double d3 = i2;
            double d4 = point.f899y;
            if (d3 <= d4 && d4 < i2 + this.height) {
                return true;
            }
        }
        return false;
    }

    public boolean empty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return this.f903x == rect.f903x && this.f904y == rect.f904y && this.width == rect.width && this.height == rect.height;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.height);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.width);
        int i = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f903x);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f904y);
        return (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f903x = dArr.length > 0 ? (int) dArr[0] : 0;
            this.f904y = dArr.length > 1 ? (int) dArr[1] : 0;
            this.width = dArr.length > 2 ? (int) dArr[2] : 0;
            this.height = dArr.length > 3 ? (int) dArr[3] : 0;
            return;
        }
        this.f903x = 0;
        this.f904y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    /* JADX INFO: renamed from: tl */
    public Point m834tl() {
        return new Point(this.f903x, this.f904y);
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{74}, IL1Iii.IL1Iii(new byte[]{83, 93, 6, 1, 95, 0}, IL1Iii.IL1Iii(new byte[]{80, 0, 81, 14, 87, 95}, "2de819"))) + this.f903x + IL1Iii.IL1Iii(new byte[]{26, 24}, IL1Iii.IL1Iii(new byte[]{80, 1, 1, 93, 80, 8}, IL1Iii.IL1Iii(new byte[]{84, 13, 0, 91, 81, 81}, "249bea"))) + this.f904y + IL1Iii.IL1Iii(new byte[]{21, 18}, IL1Iii.IL1Iii(new byte[]{9, 4, 14, 3, 13, 7}, IL1Iii.IL1Iii(new byte[]{85, 84, 0, 83, 91, 4}, "eb6fc6"))) + this.width + IL1Iii.IL1Iii(new byte[]{28}, IL1Iii.IL1Iii(new byte[]{0, 93, 5, 13, 7, 7}, IL1Iii.IL1Iii(new byte[]{5, 1, 4, 86, 2, 0}, "a8ec2a"))) + this.height + IL1Iii.IL1Iii(new byte[]{73}, IL1Iii.IL1Iii(new byte[]{6, 86, 1, 1, 6, 83}, IL1Iii.IL1Iii(new byte[]{11, 14, 15, 0, 81, 94}, "996148")));
    }

    public Rect clone() {
        return new Rect(this.f903x, this.f904y, this.width, this.height);
    }

    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(Point point, Point point2) {
        double d = point.f898x;
        double d2 = point2.f898x;
        int i = (int) (d < d2 ? d : d2);
        this.f903x = i;
        double d3 = point.f899y;
        double d4 = point2.f899y;
        int i2 = (int) (d3 < d4 ? d3 : d4);
        this.f904y = i2;
        this.width = ((int) (d <= d2 ? d2 : d)) - i;
        this.height = ((int) (d3 <= d4 ? d4 : d3)) - i2;
    }

    public Rect(Point point, Size size) {
        this((int) point.f898x, (int) point.f899y, (int) size.width, (int) size.height);
    }

    public Rect(double[] dArr) {
        set(dArr);
    }
}
