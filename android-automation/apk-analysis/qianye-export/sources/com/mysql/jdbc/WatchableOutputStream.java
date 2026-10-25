package com.mysql.jdbc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class WatchableOutputStream extends ByteArrayOutputStream {
    private OutputStreamWatcher watcher;

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        OutputStreamWatcher outputStreamWatcher = this.watcher;
        if (outputStreamWatcher != null) {
            outputStreamWatcher.streamClosed(this);
        }
    }

    public void setWatcher(OutputStreamWatcher outputStreamWatcher) {
        this.watcher = outputStreamWatcher;
    }
}
