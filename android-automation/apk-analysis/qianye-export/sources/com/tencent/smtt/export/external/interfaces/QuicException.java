package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: classes.dex */
public abstract class QuicException extends NetworkException {
    public QuicException(String str, Throwable th) {
        super(str, th);
    }

    public abstract int getQuicDetailedErrorCode();
}
