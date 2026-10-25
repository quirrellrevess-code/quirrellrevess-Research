package com.p000nx.assist;

import android.util.Log;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import p051lLi1LL.I1I.p056iILLL1.ILil;
import p051lLi1LL.I1I.p057lIiI.L11I;

/* JADX INFO: loaded from: classes.dex */
public class WebSocketcli extends ILil {
    private long mHandler;

    public static class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zConnectBlocking;
            try {
                zConnectBlocking = WebSocketcli.this.connectBlocking(5000L, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
                zConnectBlocking = false;
            }
            if (zConnectBlocking) {
                return;
            }
            WebSocketcli.this.onError(new Exception(I1I.IL1Iii.IL1Iii(new byte[]{15, 10, 77, 24, 81, 8, 14, 22, 92, 92}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 1, 10, 84, 1}, I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 89, 4, 0, 80}, "08a6f5")))));
        }
    }

    public WebSocketcli(URI uri, long j) {
        super(uri);
        this.mHandler = j;
    }

    public static boolean close(Object obj) {
        try {
            ((WebSocketcli) obj).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Object createWs(long j, String str) {
        try {
            return new WebSocketcli(URI.create(str), j);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 61}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 87, 89, 2, 13}, I1I.IL1Iii.IL1Iii(new byte[]{80, 0, 87, 5, 15, 8}, "cf3d81"))), e.toString());
            return null;
        }
    }

    public static boolean sendMessage(Object obj, String str) {
        try {
            ((WebSocketcli) obj).send(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean start(Object obj) {
        try {
            new Thread(((WebSocketcli) obj).new IL1Iii()).start();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public native int nativeClose(long j);

    public native int nativeError(long j);

    public native int nativeMessage(long j, String str);

    public native int nativeOpen(long j);

    @Override // p051lLi1LL.I1I.p056iILLL1.ILil
    public void onClose(int i, String str, boolean z) {
        nativeClose(this.mHandler);
        this.mHandler = 0L;
    }

    @Override // p051lLi1LL.I1I.p056iILLL1.ILil
    public void onError(Exception exc) {
        nativeError(this.mHandler);
        this.mHandler = 0L;
    }

    @Override // p051lLi1LL.I1I.p056iILLL1.ILil
    public void onMessage(String str) {
        nativeMessage(this.mHandler, str);
    }

    @Override // p051lLi1LL.I1I.p056iILLL1.ILil
    public void onOpen(L11I l11i) {
        nativeOpen(this.mHandler);
    }
}
