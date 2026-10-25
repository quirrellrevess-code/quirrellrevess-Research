package com.mysql.jdbc;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.profiler.ProfilerEventHandler;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class ProfilerEventHandlerFactory {
    public Log log;
    private Connection ownerConnection;

    private ProfilerEventHandlerFactory(Connection connection) {
        this.ownerConnection = null;
        this.log = null;
        this.ownerConnection = connection;
        try {
            this.log = connection.getLog();
        } catch (SQLException unused) {
            throw new RuntimeException("Unable to get logger from connection");
        }
    }

    public static synchronized ProfilerEventHandler getInstance(MySQLConnection mySQLConnection) throws SQLException {
        ProfilerEventHandler profilerEventHandlerInstance;
        profilerEventHandlerInstance = mySQLConnection.getProfilerEventHandlerInstance();
        if (profilerEventHandlerInstance == null) {
            profilerEventHandlerInstance = (ProfilerEventHandler) Util.getInstance(mySQLConnection.getProfilerEventHandler(), new Class[0], new Object[0], mySQLConnection.getExceptionInterceptor());
            mySQLConnection.initializeExtension(profilerEventHandlerInstance);
            mySQLConnection.setProfilerEventHandlerInstance(profilerEventHandlerInstance);
        }
        return profilerEventHandlerInstance;
    }

    public static synchronized void removeInstance(MySQLConnection mySQLConnection) {
        ProfilerEventHandler profilerEventHandlerInstance = mySQLConnection.getProfilerEventHandlerInstance();
        if (profilerEventHandlerInstance != null) {
            profilerEventHandlerInstance.destroy();
        }
    }
}
