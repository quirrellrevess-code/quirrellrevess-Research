package com.mysql.jdbc.profiler;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.log.Log;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class LoggingProfilerEventHandler implements ProfilerEventHandler {
    private Log log;

    @Override // com.mysql.jdbc.profiler.ProfilerEventHandler
    public void consumeEvent(ProfilerEvent profilerEvent) {
        if (profilerEvent.eventType == 0) {
            this.log.logWarn(profilerEvent);
        } else {
            this.log.logInfo(profilerEvent);
        }
    }

    @Override // com.mysql.jdbc.Extension
    public void destroy() {
        this.log = null;
    }

    @Override // com.mysql.jdbc.Extension
    public void init(Connection connection, Properties properties) throws SQLException {
        this.log = connection.getLog();
    }
}
