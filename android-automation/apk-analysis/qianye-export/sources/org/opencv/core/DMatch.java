package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class DMatch {
    public float distance;
    public int imgIdx;
    public int queryIdx;
    public int trainIdx;

    public DMatch() {
        this(-1, -1, Float.MAX_VALUE);
    }

    public boolean lessThan(DMatch dMatch) {
        return this.distance < dMatch.distance;
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{119, 117, 83, 64, 1, 92, 19, 99, 67, 65, 7, 70, 74, 113, 86, 76, 95}, IL1Iii.IL1Iii(new byte[]{4, 92, 11, 87, 87, 12}, IL1Iii.IL1Iii(new byte[]{81, 87, 0, 82, 6, 10}, "f39132"))) + this.queryIdx + IL1Iii.IL1Iii(new byte[]{20, 25, 23, 71, 81, 91, 86, 112, 7, 77, 13}, IL1Iii.IL1Iii(new byte[]{94, 93, 7, 80, 81, 86}, IL1Iii.IL1Iii(new byte[]{95, 87, 82, 93, 5, 0}, "9368dd"))) + this.trainIdx + IL1Iii.IL1Iii(new byte[]{20, 66, 15, 8, 3, 125, 92, 26, 91}, IL1Iii.IL1Iii(new byte[]{89, 86, 3, 87, 92, 80}, IL1Iii.IL1Iii(new byte[]{83, 0, 80, 3, 8, 82}, "245106"))) + this.imgIdx + IL1Iii.IL1Iii(new byte[]{28, 17, 0, 11, 21, 68, 81, 95, 7, 7, 91}, IL1Iii.IL1Iii(new byte[]{3, 83, 6, 87, 3, 1}, IL1Iii.IL1Iii(new byte[]{4, 82, 0, 1, 6, 3}, "70b4c2"))) + this.distance + IL1Iii.IL1Iii(new byte[]{110}, IL1Iii.IL1Iii(new byte[]{5, 89, 0, 81, 83, 84}, IL1Iii.IL1Iii(new byte[]{6, 2, 5, 5, 94, 4}, "0c0a82")));
    }

    public DMatch(int i, int i2, float f) {
        this.queryIdx = i;
        this.trainIdx = i2;
        this.imgIdx = -1;
        this.distance = f;
    }

    public DMatch(int i, int i2, int i3, float f) {
        this.queryIdx = i;
        this.trainIdx = i2;
        this.imgIdx = i3;
        this.distance = f;
    }
}
