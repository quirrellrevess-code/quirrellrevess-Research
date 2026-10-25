package com.tencent.smtt.utils;

/* JADX INFO: loaded from: classes.dex */
public class Timer {
    public final int timeOut;

    public Timer(int i) {
        if (i >= 0) {
            this.timeOut = i;
            return;
        }
        throw new IllegalArgumentException("time out can not < 0, current is " + i);
    }

    public void onTimeOut() {
    }
}
