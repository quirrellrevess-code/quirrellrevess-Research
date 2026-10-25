package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.Clipboard;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeClipboard extends Clipboard {
    public static final int OPS_TIMEOUT = 10000;

    public NativeClipboard(String str) {
        super(str);
    }

    public void onRestart() {
    }

    public void onShutdown() {
    }
}
