package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: classes.dex */
public interface ConsoleMessage {

    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();
}
