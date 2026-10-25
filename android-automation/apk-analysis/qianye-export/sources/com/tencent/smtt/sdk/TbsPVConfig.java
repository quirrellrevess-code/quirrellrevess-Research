package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TbsPVConfig extends TbsBaseConfig {

    /* JADX INFO: renamed from: b */
    private static TbsPVConfig f353b;
    public SharedPreferences mPreferences;

    public interface TbsPVConfigKey {
        public static final String KEY_CFG_REQUEST_INTERVAL = "tbs_cfg_request_interval";
        public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final String KEY_DISABLE_LOAD_PROTECTION = "disable_load_protection";
        public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final String KEY_READ_APK = "read_apk";
        public static final String KEY_REPORT_COOKIE_SWITCH_STAT = "tbs_report_cookie_stat";
        public static final String KEY_REPORT_CORE_LOAD_PERFORMANCE = "tbs_report_core_load_performance";
        public static final String KEY_REPORT_DOWNLOAD_STAT = "tbs_report_download_stat";
        public static final String KEY_REPORT_INSTALL_STAT = "tbs_report_install_stat";
        public static final String KEY_REPORT_LOAD_STAT = "tbs_report_load_stat";
        public static final String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
    }

    private TbsPVConfig() {
    }

    /* JADX INFO: renamed from: a */
    private boolean m232a(String str) {
        if (this.f285a.containsKey(str)) {
            return "true".equals(this.f285a.get(str));
        }
        return false;
    }

    public static synchronized TbsPVConfig getInstance(Context context) {
        if (f353b == null) {
            TbsPVConfig tbsPVConfig = new TbsPVConfig();
            f353b = tbsPVConfig;
            tbsPVConfig.init(context);
        }
        return f353b;
    }

    public static synchronized void releaseInstance() {
        f353b = null;
    }

    public synchronized int getCfgRequestMinInterval() {
        int i;
        i = -1;
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_CFG_REQUEST_INTERVAL);
            if (str != null && !TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
            if (i >= 0) {
                TbsLog.m665i(TbsBaseConfig.TAG, "getCfgRequestInterval: " + i);
            }
        } catch (Exception e) {
            TbsLog.m665i(TbsBaseConfig.TAG, "getCfgRequestIntervalException: " + e);
        }
        return i;
    }

    @Override // com.tencent.smtt.sdk.TbsBaseConfig
    public String getConfigFileName() {
        return "tbs_pv_config";
    }

    public synchronized int getDisabledCoreVersion() {
        int i;
        i = 0;
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
            TbsLog.m665i(TbsBaseConfig.TAG, "getDisabledCoreVersion tmp is " + str);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            TbsLog.m665i(TbsBaseConfig.TAG, "getDisabledCoreVersion stack is " + Log.getStackTraceString(e));
        }
        return i;
    }

    public synchronized int getEmergentCoreVersion() {
        int i;
        i = 0;
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getLocalCoreVersionMoreTimes() {
        int i;
        i = 0;
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized Map<TbsLogReport.EventType, Boolean> getLogReportSwitchMap() {
        HashMap map;
        map = new HashMap();
        map.put(TbsLogReport.EventType.TYPE_DOWNLOAD, Boolean.valueOf(m232a(TbsPVConfigKey.KEY_REPORT_DOWNLOAD_STAT)));
        map.put(TbsLogReport.EventType.TYPE_INSTALL, Boolean.valueOf(m232a(TbsPVConfigKey.KEY_REPORT_INSTALL_STAT)));
        map.put(TbsLogReport.EventType.TYPE_LOAD, Boolean.valueOf(m232a(TbsPVConfigKey.KEY_REPORT_LOAD_STAT)));
        TbsLogReport.EventType eventType = TbsLogReport.EventType.TYPE_CDN_DOWNLOAD_STAT;
        Boolean bool = Boolean.TRUE;
        map.put(eventType, bool);
        map.put(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, Boolean.valueOf(m232a(TbsPVConfigKey.KEY_REPORT_COOKIE_SWITCH_STAT)));
        map.put(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, bool);
        map.put(TbsLogReport.EventType.TYPE_CORE_LOAD_PERFORMANCE, Boolean.valueOf(m232a(TbsPVConfigKey.KEY_REPORT_CORE_LOAD_PERFORMANCE)));
        map.put(TbsLogReport.EventType.TYPE_CORE_PROTECT_RESET, bool);
        return map;
    }

    public synchronized int getReadApk() {
        int i;
        i = 0;
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_READ_APK);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized String getSyncMapValue(String str) {
        return this.f285a.get(str);
    }

    public synchronized boolean getTbsCoreSandboxModeEnable() {
        try {
            if ("true".equals(this.f285a.get(TbsPVConfigKey.KEY_TBS_CORE_SANDBOX_MODE_ENABLE))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized boolean isDisableHostBackupCore() {
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_IS_DISABLE_HOST_BACKUP_CORE);
            if (!TextUtils.isEmpty(str) && str.equals("true")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized boolean isEnableNoCoreGray() {
        try {
            String str = this.f285a.get(TbsPVConfigKey.KEY_ENABLE_NO_SHARE_GRAY);
            if (!TextUtils.isEmpty(str) && str.equals("true")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized boolean isEnableProtection() {
        try {
            if ("false".equals(this.f285a.get(TbsPVConfigKey.KEY_DISABLE_LOAD_PROTECTION))) {
                return false;
            }
        } catch (Exception unused) {
            TbsLog.m665i(TbsBaseConfig.TAG, "enable load protection");
        }
        return true;
    }

    public synchronized void putData(String str, String str2) {
        this.f285a.put(str, str2);
    }
}
