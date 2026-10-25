package org.opencv.imgproc;

import I1I.IL1Iii;

/* JADX INFO: loaded from: classes.dex */
public class Moments {
    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m30;
    public double mu02;
    public double mu03;
    public double mu11;
    public double mu12;
    public double mu20;
    public double mu21;
    public double mu30;
    public double nu02;
    public double nu03;
    public double nu11;
    public double nu12;
    public double nu20;
    public double nu21;
    public double nu30;

    public Moments(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.m00 = d;
        this.m10 = d2;
        this.m01 = d3;
        this.m20 = d4;
        this.m11 = d5;
        this.m02 = d6;
        this.m30 = d7;
        this.m21 = d8;
        this.m12 = d9;
        this.m03 = d10;
        completeState();
    }

    public void completeState() {
        double d;
        double d2;
        double d3 = 0.0d;
        if (Math.abs(this.m00) > 1.0E-8d) {
            double d4 = 1.0d / this.m00;
            double d5 = this.m10 * d4;
            d2 = this.m01 * d4;
            d = d4;
            d3 = d5;
        } else {
            d = 0.0d;
            d2 = 0.0d;
        }
        double d6 = this.m20;
        double d7 = this.m10;
        double d8 = d6 - (d7 * d3);
        double d9 = this.m11 - (d7 * d2);
        double d10 = this.m02;
        double d11 = d;
        double d12 = this.m01;
        double d13 = d10 - (d12 * d2);
        this.mu20 = d8;
        this.mu11 = d9;
        this.mu02 = d13;
        this.mu30 = this.m30 - (((d8 * 3.0d) + (d3 * d7)) * d3);
        double d14 = d9 + d9;
        this.mu21 = (this.m21 - ((d14 + (d3 * d12)) * d3)) - (d8 * d2);
        this.mu12 = (this.m12 - ((d14 + (d7 * d2)) * d2)) - (d3 * d13);
        this.mu03 = this.m03 - (d2 * ((d13 * 3.0d) + (d12 * d2)));
        double d15 = d11 * d11;
        double dSqrt = Math.sqrt(Math.abs(d11)) * d15;
        this.nu20 = this.mu20 * d15;
        this.nu11 = this.mu11 * d15;
        this.nu02 = this.mu02 * d15;
        this.nu30 = this.mu30 * dSqrt;
        this.nu21 = this.mu21 * dSqrt;
        this.nu12 = this.mu12 * dSqrt;
        this.nu03 = this.mu03 * dSqrt;
    }

    public double get_m00() {
        return this.m00;
    }

    public double get_m01() {
        return this.m01;
    }

    public double get_m02() {
        return this.m02;
    }

    public double get_m03() {
        return this.m03;
    }

    public double get_m10() {
        return this.m10;
    }

    public double get_m11() {
        return this.m11;
    }

    public double get_m12() {
        return this.m12;
    }

    public double get_m20() {
        return this.m20;
    }

    public double get_m21() {
        return this.m21;
    }

    public double get_m30() {
        return this.m30;
    }

    public double get_mu02() {
        return this.mu02;
    }

    public double get_mu03() {
        return this.mu03;
    }

    public double get_mu11() {
        return this.mu11;
    }

    public double get_mu12() {
        return this.mu12;
    }

    public double get_mu20() {
        return this.mu20;
    }

    public double get_mu21() {
        return this.mu21;
    }

    public double get_mu30() {
        return this.mu30;
    }

    public double get_nu02() {
        return this.nu02;
    }

    public double get_nu03() {
        return this.nu03;
    }

    public double get_nu11() {
        return this.nu11;
    }

    public double get_nu12() {
        return this.nu12;
    }

    public double get_nu20() {
        return this.nu20;
    }

    public double get_nu21() {
        return this.nu21;
    }

    public double get_nu30() {
        return this.nu30;
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.m00 = dArr.length > 0 ? dArr[0] : 0.0d;
            this.m10 = dArr.length > 1 ? dArr[1] : 0.0d;
            this.m01 = dArr.length > 2 ? dArr[2] : 0.0d;
            this.m20 = dArr.length > 3 ? dArr[3] : 0.0d;
            this.m11 = dArr.length > 4 ? dArr[4] : 0.0d;
            this.m02 = dArr.length > 5 ? dArr[5] : 0.0d;
            this.m30 = dArr.length > 6 ? dArr[6] : 0.0d;
            this.m21 = dArr.length > 7 ? dArr[7] : 0.0d;
            this.m12 = dArr.length > 8 ? dArr[8] : 0.0d;
            this.m03 = dArr.length > 9 ? dArr[9] : 0.0d;
            completeState();
            return;
        }
        this.m00 = 0.0d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m20 = 0.0d;
        this.m11 = 0.0d;
        this.m02 = 0.0d;
        this.m30 = 0.0d;
        this.m21 = 0.0d;
        this.m12 = 0.0d;
        this.m03 = 0.0d;
        this.mu20 = 0.0d;
        this.mu11 = 0.0d;
        this.mu02 = 0.0d;
        this.mu30 = 0.0d;
        this.mu21 = 0.0d;
        this.mu12 = 0.0d;
        this.mu03 = 0.0d;
        this.nu20 = 0.0d;
        this.nu11 = 0.0d;
        this.nu02 = 0.0d;
        this.nu30 = 0.0d;
        this.nu21 = 0.0d;
        this.nu12 = 0.0d;
        this.nu03 = 0.0d;
    }

    public void set_m00(double d) {
        this.m00 = d;
    }

    public void set_m01(double d) {
        this.m01 = d;
    }

    public void set_m02(double d) {
        this.m02 = d;
    }

    public void set_m03(double d) {
        this.m03 = d;
    }

    public void set_m10(double d) {
        this.m10 = d;
    }

    public void set_m11(double d) {
        this.m11 = d;
    }

    public void set_m12(double d) {
        this.m12 = d;
    }

    public void set_m20(double d) {
        this.m20 = d;
    }

    public void set_m21(double d) {
        this.m21 = d;
    }

    public void set_m30(double d) {
        this.m30 = d;
    }

    public void set_mu02(double d) {
        this.mu02 = d;
    }

    public void set_mu03(double d) {
        this.mu03 = d;
    }

    public void set_mu11(double d) {
        this.mu11 = d;
    }

    public void set_mu12(double d) {
        this.mu12 = d;
    }

    public void set_mu20(double d) {
        this.mu20 = d;
    }

    public void set_mu21(double d) {
        this.mu21 = d;
    }

    public void set_mu30(double d) {
        this.mu30 = d;
    }

    public void set_nu02(double d) {
        this.nu02 = d;
    }

    public void set_nu03(double d) {
        this.nu03 = d;
    }

    public void set_nu11(double d) {
        this.nu11 = d;
    }

    public void set_nu12(double d) {
        this.nu12 = d;
    }

    public void set_nu20(double d) {
        this.nu20 = d;
    }

    public void set_nu21(double d) {
        this.nu21 = d;
    }

    public void set_nu30(double d) {
        this.nu30 = d;
    }

    public String toString() {
        return IL1Iii.IL1Iii(new byte[]{47, 92, 90, 4, 89, 16, 17, 19, 108, 65, 61, 9, 82, 3, 10}, IL1Iii.IL1Iii(new byte[]{3, 5, 1, 80, 86, 80}, IL1Iii.IL1Iii(new byte[]{84, 85, 84, 85, 86, 12}, "5cbd78"))) + this.m00 + IL1Iii.IL1Iii(new byte[]{73, 21, 105, 95, 85, 85, 88}, IL1Iii.IL1Iii(new byte[]{82, 1, 1, 80, 84, 86}, IL1Iii.IL1Iii(new byte[]{3, 80, 91, 4, 4, 87}, "4d9f4d"))) + this.m10 + IL1Iii.IL1Iii(new byte[]{24, 21, 14, 83, 7, 12}, IL1Iii.IL1Iii(new byte[]{81, 1, 90, 85, 85, 87}, IL1Iii.IL1Iii(new byte[]{80, 13, 13, 15, 1, 2}, "5949bd"))) + this.m01 + IL1Iii.IL1Iii(new byte[]{73, 16, 60, 92, 3, 2, 88}, IL1Iii.IL1Iii(new byte[]{1, 81, 82, 7, 83, 84}, IL1Iii.IL1Iii(new byte[]{7, 80, 92, 84, 6, 83}, "c18bd5"))) + this.m20 + IL1Iii.IL1Iii(new byte[]{73, 66, 90, 7, 5, 12}, IL1Iii.IL1Iii(new byte[]{3, 0, 5, 82, 1, 80}, IL1Iii.IL1Iii(new byte[]{0, 82, 6, 86, 3, 84}, "f04265"))) + this.m11 + IL1Iii.IL1Iii(new byte[]{29, 69, 9, 1, 87, 13}, IL1Iii.IL1Iii(new byte[]{3, 83, 5, 84, 93, 81}, IL1Iii.IL1Iii(new byte[]{1, 84, 88, 0, 15, 4}, "3b9e7e"))) + this.m02 + IL1Iii.IL1Iii(new byte[]{79, 67, 108, 90, 81, 2, 94}, IL1Iii.IL1Iii(new byte[]{90, 87, 81, 0, 4, 87}, IL1Iii.IL1Iii(new byte[]{9, 82, 15, 86, 5, 81}, "0f8ac4"))) + this.m30 + IL1Iii.IL1Iii(new byte[]{31, 21, 94, 6, 0, 10}, IL1Iii.IL1Iii(new byte[]{11, 3, 0, 7, 8, 81}, IL1Iii.IL1Iii(new byte[]{9, 7, 11, 86, 1, 3}, "118e8e"))) + this.m21 + IL1Iii.IL1Iii(new byte[]{31, 20, 8, 87, 81, 89}, IL1Iii.IL1Iii(new byte[]{2, 1, 4, 80, 86, 85}, IL1Iii.IL1Iii(new byte[]{9, 0, 84, 84, 2, 4}, "855b75"))) + this.m12 + IL1Iii.IL1Iii(new byte[]{77, 24, 12, 81, 85, 14}, IL1Iii.IL1Iii(new byte[]{80, 10, 7, 4, 3, 10}, IL1Iii.IL1Iii(new byte[]{5, 81, 84, 0, 7, 93}, "4c2ebd"))) + this.m03 + IL1Iii.IL1Iii(new byte[]{30, 17, 107, 89, 64, 2, 2, 12}, IL1Iii.IL1Iii(new byte[]{84, 8, 81, 7, 86, 83}, IL1Iii.IL1Iii(new byte[]{95, 95, 6, 11, 87, 1}, "9f684b"))) + this.mu20 + IL1Iii.IL1Iii(new byte[]{25, 66, 91, 66, 83, 7, 8}, IL1Iii.IL1Iii(new byte[]{12, 90, 84, 2, 87, 84}, IL1Iii.IL1Iii(new byte[]{12, 13, 80, 0, 83, 90}, "5525f8"))) + this.mu11 + IL1Iii.IL1Iii(new byte[]{20, 18, 92, 65, 82, 10, 5}, IL1Iii.IL1Iii(new byte[]{89, 2, 3, 81, 91, 94}, IL1Iii.IL1Iii(new byte[]{3, 2, 11, 86, 0, 4}, "b2939b"))) + this.mu02 + IL1Iii.IL1Iii(new byte[]{73, 16, 108, 9, 68, 4, 85, 13}, IL1Iii.IL1Iii(new byte[]{84, 9, 82, 92, 4, 2}, IL1Iii.IL1Iii(new byte[]{8, 9, 82, 90, 6, 80}, "90fb3e"))) + this.mu30 + IL1Iii.IL1Iii(new byte[]{24, 20, 85, 64, 4, 87, 9}, IL1Iii.IL1Iii(new byte[]{7, 13, 10, 87, 14, 82}, IL1Iii.IL1Iii(new byte[]{5, 91, 1, 7, 1, 87}, "6b3e9c"))) + this.mu21 + IL1Iii.IL1Iii(new byte[]{78, 22, 95, 70, 5, 81, 95}, IL1Iii.IL1Iii(new byte[]{86, 4, 80, 87, 5, 2}, IL1Iii.IL1Iii(new byte[]{85, 6, 81, 83, 9, 89}, "a43788"))) + this.mu12 + IL1Iii.IL1Iii(new byte[]{78, 65, 11, 17, 5, 0, 95}, IL1Iii.IL1Iii(new byte[]{91, 83, 80, 86, 6, 80}, IL1Iii.IL1Iii(new byte[]{8, 6, 84, 5, 0, 83}, "14b730"))) + this.mu03 + IL1Iii.IL1Iii(new byte[]{78, 16, 50, 92, 66, 7, 82, 13}, IL1Iii.IL1Iii(new byte[]{4, 8, 9, 1, 4, 6}, IL1Iii.IL1Iii(new byte[]{95, 90, 4, 10, 2, 11}, "9b5918"))) + this.nu20 + IL1Iii.IL1Iii(new byte[]{77, 67, 12, 23, 7, 84, 92}, IL1Iii.IL1Iii(new byte[]{87, 90, 91, 81, 1, 0}, IL1Iii.IL1Iii(new byte[]{4, 13, 0, 10, 84, 87}, "2499c2"))) + this.nu11 + IL1Iii.IL1Iii(new byte[]{30, 16, 8, 64, 2, 11, 15}, IL1Iii.IL1Iii(new byte[]{3, 6, 84, 6, 1, 10}, IL1Iii.IL1Iii(new byte[]{7, 3, 3, 80, 7, 4}, "651c47"))) + this.nu02 + IL1Iii.IL1Iii(new byte[]{77, 65, 63, 90, 77, 10, 81, 92}, IL1Iii.IL1Iii(new byte[]{2, 89, 6, 4, 90, 11}, IL1Iii.IL1Iii(new byte[]{85, 12, 5, 1, 83, 81}, "64611c"))) + this.nu30 + IL1Iii.IL1Iii(new byte[]{30, 17, 93, 23, 4, 0, 15}, IL1Iii.IL1Iii(new byte[]{0, 5, 5, 85, 1, 85}, IL1Iii.IL1Iii(new byte[]{87, 82, 15, 1, 86, 86}, "ef96a2"))) + this.nu21 + IL1Iii.IL1Iii(new byte[]{78, 65, 91, 64, 4, 83, 95}, IL1Iii.IL1Iii(new byte[]{7, 7, 1, 84, 2, 81}, IL1Iii.IL1Iii(new byte[]{85, 87, 85, 0, 1, 5}, "01aa65"))) + this.nu12 + IL1Iii.IL1Iii(new byte[]{74, 24, 12, 20, 86, 80, 91}, IL1Iii.IL1Iii(new byte[]{84, 13, 1, 82, 81, 90}, IL1Iii.IL1Iii(new byte[]{87, 6, 85, 2, 81, 90}, "e361fc"))) + this.nu03 + IL1Iii.IL1Iii(new byte[]{79, 24, 50, 100}, IL1Iii.IL1Iii(new byte[]{84, 94, 91, 11, 2, 2}, IL1Iii.IL1Iii(new byte[]{15, 81, 82, 11, 7, 86}, "8719ab")));
    }

    public Moments() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Moments(double[] dArr) {
        set(dArr);
    }
}
