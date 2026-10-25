package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

/* JADX INFO: loaded from: classes.dex */
public class JsError {

    /* JADX INFO: renamed from: a */
    private final IX5JsError f161a;

    public JsError(IX5JsError iX5JsError) {
        this.f161a = iX5JsError;
    }

    public String getMessage() {
        return this.f161a.getMessage();
    }

    public String getStack() {
        return this.f161a.getStack();
    }
}
