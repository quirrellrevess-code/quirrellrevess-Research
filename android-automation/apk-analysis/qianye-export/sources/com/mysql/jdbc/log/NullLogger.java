package com.mysql.jdbc.log;

/* JADX INFO: loaded from: classes.dex */
public class NullLogger implements Log {
    public NullLogger(String str) {
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isDebugEnabled() {
        return false;
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isErrorEnabled() {
        return false;
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isFatalEnabled() {
        return false;
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isInfoEnabled() {
        return false;
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isTraceEnabled() {
        return false;
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isWarnEnabled() {
        return false;
    }

    @Override // com.mysql.jdbc.log.Log
    public void logDebug(Object obj) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logDebug(Object obj, Throwable th) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logError(Object obj) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logError(Object obj, Throwable th) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logFatal(Object obj) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logFatal(Object obj, Throwable th) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logInfo(Object obj) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logInfo(Object obj, Throwable th) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logTrace(Object obj) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logTrace(Object obj, Throwable th) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logWarn(Object obj) {
    }

    @Override // com.mysql.jdbc.log.Log
    public void logWarn(Object obj, Throwable th) {
    }
}
