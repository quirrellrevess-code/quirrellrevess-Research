package com.mysql.jdbc;

import java.io.CharArrayWriter;

/* JADX INFO: loaded from: classes.dex */
public class WatchableWriter extends CharArrayWriter {
    private WriterWatcher watcher;

    @Override // java.io.CharArrayWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        WriterWatcher writerWatcher = this.watcher;
        if (writerWatcher != null) {
            writerWatcher.writerClosed(this);
        }
    }

    public void setWatcher(WriterWatcher writerWatcher) {
        this.watcher = writerWatcher;
    }
}
