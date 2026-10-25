package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class Range {
    public int end;
    public int start;

    public Range(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public static Range all() {
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean empty() {
        return this.end <= this.start;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.start == range.start && this.end == range.end;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.start);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.end);
        return (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public Range intersection(Range range) {
        Range range2 = new Range(Math.max(range.start, this.start), Math.min(range.end, this.end));
        range2.end = Math.max(range2.end, range2.start);
        return range2;
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.start = dArr.length > 0 ? (int) dArr[0] : 0;
            this.end = dArr.length > 1 ? (int) dArr[1] : 0;
        } else {
            this.start = 0;
            this.end = 0;
        }
    }

    public Range shift(int i) {
        return new Range(this.start + i, this.end + i);
    }

    public int size() {
        if (empty()) {
            return 0;
        }
        return this.end - this.start;
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{98}, IL1Iii.IL1Iii(new byte[]{90, 87, 9, 84, 2, 6}, IL1Iii.IL1Iii(new byte[]{5, 85, 13, 5, 86, 7}, "f75d0c"))) + this.start + IL1Iii.IL1Iii(new byte[]{21, 18}, IL1Iii.IL1Iii(new byte[]{10, 2, 87, 83, 80, 87}, IL1Iii.IL1Iii(new byte[]{11, 85, 10, 1, 87, 83}, "8e9dca"))) + this.end + IL1Iii.IL1Iii(new byte[]{76}, IL1Iii.IL1Iii(new byte[]{87, 7, 85, 15, 5, 5}, IL1Iii.IL1Iii(new byte[]{84, 87, 86, 3, 86, 4}, "f154c5")));
    }

    public Range clone() {
        return new Range(this.start, this.end);
    }

    public Range() {
        this(0, 0);
    }

    public Range(double[] dArr) {
        set(dArr);
    }
}
