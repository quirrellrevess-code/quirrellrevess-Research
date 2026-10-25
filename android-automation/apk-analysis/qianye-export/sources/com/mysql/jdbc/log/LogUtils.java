package com.mysql.jdbc.log;

import com.mysql.jdbc.Util;
import com.mysql.jdbc.profiler.ProfilerEvent;
import com.sun.mail.pop3.POP3Message;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    public static final String CALLER_INFORMATION_NOT_AVAILABLE = "Caller information not available";
    private static final String LINE_SEPARATOR;
    private static final int LINE_SEPARATOR_LENGTH;

    static {
        String property = System.getProperty("line.separator");
        LINE_SEPARATOR = property;
        LINE_SEPARATOR_LENGTH = property.length();
    }

    public static Object expandProfilerEventIfNecessary(Object obj) {
        if (!(obj instanceof ProfilerEvent)) {
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        ProfilerEvent profilerEvent = (ProfilerEvent) obj;
        String eventCreationPointAsString = profilerEvent.getEventCreationPointAsString();
        if (eventCreationPointAsString == null) {
            eventCreationPointAsString = Util.stackTraceToString(new Throwable());
        }
        sb.append("Profiler Event: [");
        switch (profilerEvent.getEventType()) {
            case 0:
                sb.append("WARN");
                break;
            case 1:
                sb.append("CONSTRUCT");
                break;
            case 2:
                sb.append("PREPARE");
                break;
            case 3:
                sb.append("QUERY");
                break;
            case 4:
                sb.append("EXECUTE");
                break;
            case 5:
                sb.append("FETCH");
                break;
            case 6:
                sb.append("SLOW QUERY");
                break;
            default:
                sb.append(POP3Message.UNKNOWN);
                break;
        }
        sb.append("] ");
        sb.append(eventCreationPointAsString);
        sb.append(" duration: ");
        sb.append(profilerEvent.getEventDuration());
        sb.append(" ");
        sb.append(profilerEvent.getDurationUnits());
        sb.append(", connection-id: ");
        sb.append(profilerEvent.getConnectionId());
        sb.append(", statement-id: ");
        sb.append(profilerEvent.getStatementId());
        sb.append(", resultset-id: ");
        sb.append(profilerEvent.getResultSetId());
        String message = profilerEvent.getMessage();
        if (message != null) {
            sb.append(", message: ");
            sb.append(message);
        }
        return sb;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    public static String findCallingClassAndMethod(Throwable th) {
        String strSubstring;
        String strStackTraceToString = Util.stackTraceToString(th);
        int iLastIndexOf = strStackTraceToString.lastIndexOf("com.mysql.jdbc");
        if (iLastIndexOf == -1) {
            strSubstring = CALLER_INFORMATION_NOT_AVAILABLE;
        } else {
            int iIndexOf = strStackTraceToString.indexOf("com.mysql.jdbc.compliance", iLastIndexOf);
            int iIndexOf2 = iIndexOf != -1 ? iIndexOf - LINE_SEPARATOR_LENGTH : strStackTraceToString.indexOf(LINE_SEPARATOR, iLastIndexOf);
            if (iIndexOf2 != -1) {
                String str = LINE_SEPARATOR;
                int i = LINE_SEPARATOR_LENGTH;
                int iIndexOf3 = strStackTraceToString.indexOf(str, iIndexOf2 + i);
                strSubstring = iIndexOf3 != -1 ? strStackTraceToString.substring(iIndexOf2 + i, iIndexOf3) : strStackTraceToString.substring(iIndexOf2 + i);
            } else {
                strSubstring = CALLER_INFORMATION_NOT_AVAILABLE;
            }
        }
        if (strSubstring.startsWith("\tat ") || strSubstring.startsWith("at ")) {
            return strSubstring;
        }
        return "at " + strSubstring;
    }
}
