package org.opencv.core;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class KeyPoint {
    public float angle;
    public int class_id;
    public int octave;

    /* JADX INFO: renamed from: pt */
    public Point f888pt;
    public float response;
    public float size;

    public KeyPoint(float f, float f2, float f3, float f4, float f5, int i, int i2) {
        this.f888pt = new Point(f, f2);
        this.size = f3;
        this.angle = f4;
        this.response = f5;
        this.octave = i;
        this.class_id = i2;
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{45, 7, 28, 100, 95, 90, 8, 22, 69, 111, 64, 71, 91}, IL1Iii.IL1Iii(new byte[]{94, 82, 80, 12, 83, 80}, IL1Iii.IL1Iii(new byte[]{13, 86, 2, 15, 83, 84}, "5f7707"))) + this.f888pt + IL1Iii.IL1Iii(new byte[]{73, 25, 67, 89, 67, 0, 88}, IL1Iii.IL1Iii(new byte[]{84, 11, 3, 4, 91, 83}, IL1Iii.IL1Iii(new byte[]{1, 10, 1, 86, 3, 0}, "082ba6"))) + this.size + IL1Iii.IL1Iii(new byte[]{31, 21, 88, 92, 86, 9, 86, 8}, IL1Iii.IL1Iii(new byte[]{0, 81, 93, 86, 0, 83}, IL1Iii.IL1Iii(new byte[]{4, 93, 93, 93, 84, 4}, "7999e2"))) + this.angle + IL1Iii.IL1Iii(new byte[]{77, 25, 70, 85, 70, 18, 14, 87, 71, 85, 8}, IL1Iii.IL1Iii(new byte[]{7, 9, 87, 84, 0, 83}, IL1Iii.IL1Iii(new byte[]{3, 84, 81, 87, 81, 8}, "ed23d9"))) + this.response + IL1Iii.IL1Iii(new byte[]{20, 22, 10, 83, 16, 87, 78, 83, 88}, IL1Iii.IL1Iii(new byte[]{94, 2, 80, 1, 82, 2}, IL1Iii.IL1Iii(new byte[]{95, 80, 2, 85, 3, 1}, "9d7d55"))) + this.octave + IL1Iii.IL1Iii(new byte[]{79, 20, 84, 89, 85, 68, 16, 107, 94, 81, 9}, IL1Iii.IL1Iii(new byte[]{86, 6, 4, 4, 85, 1}, IL1Iii.IL1Iii(new byte[]{3, 2, 3, 7, 82, 83}, "60063e"))) + this.class_id + IL1Iii.IL1Iii(new byte[]{62}, IL1Iii.IL1Iii(new byte[]{84, 8, 80, 15, 87, 82}, IL1Iii.IL1Iii(new byte[]{5, 83, 3, 3, 90, 83}, "2b759c")));
    }

    public KeyPoint() {
        this(0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0, -1);
    }

    public KeyPoint(float f, float f2, float f3, float f4, float f5, int i) {
        this(f, f2, f3, f4, f5, i, -1);
    }

    public KeyPoint(float f, float f2, float f3, float f4, float f5) {
        this(f, f2, f3, f4, f5, 0, -1);
    }

    public KeyPoint(float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4, 0.0f, 0, -1);
    }

    public KeyPoint(float f, float f2, float f3) {
        this(f, f2, f3, -1.0f, 0.0f, 0, -1);
    }
}
