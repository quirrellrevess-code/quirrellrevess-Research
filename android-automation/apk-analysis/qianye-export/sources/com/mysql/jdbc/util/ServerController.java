package com.mysql.jdbc.util;

import com.mysql.jdbc.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class ServerController {
    public static final String BASEDIR_KEY = "basedir";
    public static final String DATADIR_KEY = "datadir";
    public static final String DEFAULTS_FILE_KEY = "defaults-file";
    public static final String EXECUTABLE_NAME_KEY = "executable";
    public static final String EXECUTABLE_PATH_KEY = "executablePath";
    private Process serverProcess = null;
    private Properties serverProps = null;
    private Properties systemProps = null;

    public ServerController(String str) {
        setBaseDir(str);
    }

    private String buildOptionalCommandLine() {
        StringBuilder sb = new StringBuilder();
        Properties properties = this.serverProps;
        if (properties != null) {
            for (String str : properties.keySet()) {
                String property = this.serverProps.getProperty(str);
                if (!isNonCommandLineArgument(str)) {
                    if (property == null || property.length() <= 0) {
                        sb.append(" --");
                        sb.append(str);
                    } else {
                        sb.append(" \"");
                        sb.append("--");
                        sb.append(str);
                        sb.append("=");
                        sb.append(property);
                        sb.append("\"");
                    }
                }
            }
        }
        return sb.toString();
    }

    private String getCommandLine() {
        return getFullExecutablePath() + buildOptionalCommandLine();
    }

    private String getFullExecutablePath() {
        StringBuilder sb = new StringBuilder();
        String property = getServerProps().getProperty(EXECUTABLE_PATH_KEY);
        if (property == null) {
            String property2 = getServerProps().getProperty(BASEDIR_KEY);
            sb.append(property2);
            if (!property2.endsWith(File.separator)) {
                sb.append(File.separatorChar);
            }
            if (runningOnWindows()) {
                sb.append("bin");
            } else {
                sb.append("libexec");
            }
            sb.append(File.separatorChar);
        } else {
            sb.append(property);
            if (!property.endsWith(File.separator)) {
                sb.append(File.separatorChar);
            }
        }
        sb.append(getServerProps().getProperty(EXECUTABLE_NAME_KEY, "mysqld"));
        return sb.toString();
    }

    private synchronized Properties getSystemProperties() {
        if (this.systemProps == null) {
            this.systemProps = System.getProperties();
        }
        return this.systemProps;
    }

    private boolean isNonCommandLineArgument(String str) {
        return str.equals(EXECUTABLE_NAME_KEY) || str.equals(EXECUTABLE_PATH_KEY);
    }

    private boolean runningOnWindows() {
        return StringUtils.indexOfIgnoreCase(getSystemProperties().getProperty("os.name"), "WINDOWS") != -1;
    }

    public void forceStop() {
        Process process = this.serverProcess;
        if (process != null) {
            process.destroy();
            this.serverProcess = null;
        }
    }

    public synchronized Properties getServerProps() {
        if (this.serverProps == null) {
            this.serverProps = new Properties();
        }
        return this.serverProps;
    }

    public void setBaseDir(String str) {
        getServerProps().setProperty(BASEDIR_KEY, str);
    }

    public void setDataDir(String str) {
        getServerProps().setProperty(DATADIR_KEY, str);
    }

    public Process start() throws IOException {
        if (this.serverProcess != null) {
            throw new IllegalArgumentException("Server already started");
        }
        Process processExec = Runtime.getRuntime().exec(getCommandLine());
        this.serverProcess = processExec;
        return processExec;
    }

    public void stop(boolean z) throws IOException {
        if (this.serverProcess != null) {
            String property = getServerProps().getProperty(BASEDIR_KEY);
            StringBuilder sb = new StringBuilder(property);
            String str = File.separator;
            if (!property.endsWith(str)) {
                sb.append(str);
            }
            sb.append("bin");
            sb.append(str);
            sb.append("mysqladmin shutdown");
            System.out.println(sb.toString());
            Process processExec = Runtime.getRuntime().exec(sb.toString());
            int iWaitFor = -1;
            try {
                iWaitFor = processExec.waitFor();
            } catch (InterruptedException unused) {
            }
            if (iWaitFor == 0 || !z) {
                return;
            }
            forceStop();
        }
    }

    public ServerController(String str, String str2) {
    }
}
