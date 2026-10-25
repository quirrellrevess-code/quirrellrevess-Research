package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class IterateBlock<T> {
    public DatabaseMetaData.IteratorWithCleanup<T> iteratorWithCleanup;
    public Iterator<T> javaIterator;
    public boolean stopIterating;

    public IterateBlock(DatabaseMetaData.IteratorWithCleanup<T> iteratorWithCleanup) {
        this.stopIterating = false;
        this.iteratorWithCleanup = iteratorWithCleanup;
        this.javaIterator = null;
    }

    public void doForAll() throws SQLException {
        if (this.iteratorWithCleanup == null) {
            while (this.javaIterator.hasNext()) {
                forEach(this.javaIterator.next());
                if (this.stopIterating) {
                    return;
                }
            }
            return;
        }
        while (this.iteratorWithCleanup.hasNext()) {
            try {
                forEach(this.iteratorWithCleanup.next());
                if (this.stopIterating) {
                    break;
                }
            } finally {
                this.iteratorWithCleanup.close();
            }
        }
    }

    public abstract void forEach(T t) throws SQLException;

    public final boolean fullIteration() {
        return !this.stopIterating;
    }

    public IterateBlock(Iterator<T> it) {
        this.stopIterating = false;
        this.javaIterator = it;
        this.iteratorWithCleanup = null;
    }
}
