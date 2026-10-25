package com.mysql.jdbc.log;

import com.mysql.jdbc.profiler.ProfilerEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class Jdk14Logger implements Log {
    private static final Level DEBUG = Level.FINE;
    private static final Level ERROR;
    private static final Level FATAL;
    private static final Level INFO;
    private static final Level TRACE;
    private static final Level WARN;
    public Logger jdkLogger;

    static {
        Level level = Level.SEVERE;
        ERROR = level;
        FATAL = level;
        INFO = Level.INFO;
        TRACE = Level.FINEST;
        WARN = Level.WARNING;
    }

    public Jdk14Logger(String str) {
        this.jdkLogger = null;
        this.jdkLogger = Logger.getLogger(str);
    }

    private static final int findCallerStackDepth(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.startsWith("com.mysql.jdbc") || className.startsWith("com.mysql.jdbc.compliance")) {
                return i;
            }
        }
        return 0;
    }

    private void logInternal(Level level, Object obj, Throwable th) {
        String methodName;
        String strValueOf;
        String str;
        String str2;
        if (this.jdkLogger.isLoggable(level)) {
            String className = "N/A";
            if (obj instanceof ProfilerEvent) {
                strValueOf = LogUtils.expandProfilerEventIfNecessary(obj).toString();
                str2 = "N/A";
                str = str2;
            } else {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int iFindCallerStackDepth = findCallerStackDepth(stackTrace);
                if (iFindCallerStackDepth != 0) {
                    className = stackTrace[iFindCallerStackDepth].getClassName();
                    methodName = stackTrace[iFindCallerStackDepth].getMethodName();
                } else {
                    methodName = "N/A";
                }
                strValueOf = String.valueOf(obj);
                str = methodName;
                str2 = className;
            }
            if (th == null) {
                this.jdkLogger.logp(level, str2, str, strValueOf);
            } else {
                this.jdkLogger.logp(level, str2, str, strValueOf, th);
            }
        }
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isDebugEnabled() {
        return this.jdkLogger.isLoggable(Level.FINE);
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isErrorEnabled() {
        return this.jdkLogger.isLoggable(Level.SEVERE);
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isFatalEnabled() {
        return this.jdkLogger.isLoggable(Level.SEVERE);
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isInfoEnabled() {
        return this.jdkLogger.isLoggable(Level.INFO);
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isTraceEnabled() {
        return this.jdkLogger.isLoggable(Level.FINEST);
    }

    @Override // com.mysql.jdbc.log.Log
    public boolean isWarnEnabled() {
        return this.jdkLogger.isLoggable(Level.WARNING);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logDebug(Object obj) {
        logInternal(DEBUG, obj, null);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logError(Object obj) {
        logInternal(ERROR, obj, null);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logFatal(Object obj) {
        logInternal(FATAL, obj, null);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logInfo(Object obj) {
        logInternal(INFO, obj, null);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logTrace(Object obj) {
        logInternal(TRACE, obj, null);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logWarn(Object obj) {
        logInternal(WARN, obj, null);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logDebug(Object obj, Throwable th) {
        logInternal(DEBUG, obj, th);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logError(Object obj, Throwable th) {
        logInternal(ERROR, obj, th);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logFatal(Object obj, Throwable th) {
        logInternal(FATAL, obj, th);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logInfo(Object obj, Throwable th) {
        logInternal(INFO, obj, th);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logTrace(Object obj, Throwable th) {
        logInternal(TRACE, obj, th);
    }

    @Override // com.mysql.jdbc.log.Log
    public void logWarn(Object obj, Throwable th) {
        logInternal(WARN, obj, th);
    }
}
