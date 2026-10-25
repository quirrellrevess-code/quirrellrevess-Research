package com.mysql.jdbc.profiler;

import com.mysql.jdbc.Extension;

/* JADX INFO: loaded from: classes.dex */
public interface ProfilerEventHandler extends Extension {
    void consumeEvent(ProfilerEvent profilerEvent);
}
