package com.p000nx.assist.log.standout.p001ui;

import I1I.IL1Iii;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TouchInfo {
    public double dist;
    public double firstHeight;
    public double firstWidth;
    public int firstX;
    public int firstY;
    public int lastX;
    public int lastY;
    public boolean moving;
    public float ratio;
    public double scale;

    public String toString() {
        return String.format(Locale.US, IL1Iii.IL1Iii(new byte[]{98, 8, 94, 92, 9, 70, 97, 14, 69, 91, 14, 120, 91, 7, 95, 24, 29, 17, 83, 8, 66, 75, 18, 105, 8, 68, 84, 20, 70, 87, 92, 19, 67, 76, 63, 12, 16, 5, 28, 84, 7, 66, 65, 57, 13, 29, 2, 29, 21, 13, 81, 75, 18, 104, 8, 68, 84, 20, 70, 87, 92, 19, 67, 76, 49, 88, 81, 21, 88, 5, 67, 85, 25, 65, 86, 81, 20, 66, 65, 41, 85, 81, 1, 89, 65, 92, 21, 92, 70, 76}, IL1Iii.IL1Iii(new byte[]{7, 85, 82, 1, 3, 2}, IL1Iii.IL1Iii(new byte[]{83, 87, 0, 93, 82, 5}, "acbd76"))), Integer.valueOf(this.firstX), Integer.valueOf(this.firstY), Integer.valueOf(this.lastX), Integer.valueOf(this.lastY), Double.valueOf(this.firstWidth), Double.valueOf(this.firstHeight));
    }
}
