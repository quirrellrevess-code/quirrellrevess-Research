package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.g */
/* JADX INFO: loaded from: classes.dex */
public class C0413g implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!(th instanceof SQLiteException)) {
            throw new RuntimeException(th);
        }
    }
}
