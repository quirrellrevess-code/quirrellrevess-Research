package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class TermCriteria {
    public static final int COUNT = 1;
    public static final int EPS = 2;
    public static final int MAX_ITER = 1;
    public double epsilon;
    public int maxCount;
    public int type;

    public TermCriteria(int i, int i2, double d) {
        this.type = i;
        this.maxCount = i2;
        this.epsilon = d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermCriteria)) {
            return false;
        }
        TermCriteria termCriteria = (TermCriteria) obj;
        return this.type == termCriteria.type && this.maxCount == termCriteria.maxCount && this.epsilon == termCriteria.epsilon;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.type);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.maxCount);
        int i = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.epsilon);
        return (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.type = dArr.length > 0 ? (int) dArr[0] : 0;
            this.maxCount = dArr.length > 1 ? (int) dArr[1] : 0;
            this.epsilon = dArr.length > 2 ? dArr[2] : 0.0d;
        } else {
            this.type = 0;
            this.maxCount = 0;
            this.epsilon = 0.0d;
        }
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{76, 23, 17, 64, 72, 84, 13, 23}, IL1Iii.IL1Iii(new byte[]{2, 1, 7, 95, 93, 87}, IL1Iii.IL1Iii(new byte[]{0, 82, 84, 95, 82, 0}, "5d697f"))) + this.type + IL1Iii.IL1Iii(new byte[]{77, 18, 84, 5, 73, 34, 14, 71, 87, 16, 11, 65}, IL1Iii.IL1Iii(new byte[]{5, 80, 88, 92, 85, 87}, IL1Iii.IL1Iii(new byte[]{93, 85, 82, 89, 84, 14}, "973a08"))) + this.maxCount + IL1Iii.IL1Iii(new byte[]{31, 65, 3, 68, 66, 94, 95, 14, 8, 14, 17}, IL1Iii.IL1Iii(new byte[]{85, 82, 5, 13, 7, 86}, IL1Iii.IL1Iii(new byte[]{82, 11, 90, 14, 84, 5}, "4897bd"))) + this.epsilon + IL1Iii.IL1Iii(new byte[]{69}, IL1Iii.IL1Iii(new byte[]{1, 1, 6, 82, 82, 80}, IL1Iii.IL1Iii(new byte[]{9, 7, 1, 7, 84, 6}, "011367")));
    }

    public TermCriteria clone() {
        return new TermCriteria(this.type, this.maxCount, this.epsilon);
    }

    public TermCriteria() {
        this(0, 0, 0.0d);
    }

    public TermCriteria(double[] dArr) {
        set(dArr);
    }
}
