package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class TbsHandlerThread extends HandlerThread {

    /* JADX INFO: renamed from: a */
    private static TbsHandlerThread f322a;

    public TbsHandlerThread(String str) {
        super(str);
    }

    public static synchronized TbsHandlerThread getInstance() {
        if (f322a == null) {
            TbsHandlerThread tbsHandlerThread = new TbsHandlerThread("TbsHandlerThread");
            f322a = tbsHandlerThread;
            tbsHandlerThread.start();
        }
        return f322a;
    }
}
