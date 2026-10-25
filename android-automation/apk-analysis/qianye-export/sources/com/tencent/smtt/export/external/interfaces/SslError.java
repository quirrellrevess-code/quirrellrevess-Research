package com.tencent.smtt.export.external.interfaces;

import android.net.http.SslCertificate;

/* JADX INFO: loaded from: classes.dex */
public interface SslError {
    boolean addError(int i);

    SslCertificate getCertificate();

    int getPrimaryError();

    String getUrl();

    boolean hasError(int i);
}
