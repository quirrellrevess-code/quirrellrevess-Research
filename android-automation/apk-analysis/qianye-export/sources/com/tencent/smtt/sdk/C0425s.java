package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.C0457n;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.s */
/* JADX INFO: loaded from: classes.dex */
public class C0425s {

    /* JADX INFO: renamed from: a */
    private Context f616a;

    /* JADX INFO: renamed from: b */
    private Context f617b;

    /* JADX INFO: renamed from: c */
    private String f618c;

    /* JADX INFO: renamed from: d */
    private String[] f619d;

    /* JADX INFO: renamed from: e */
    private DexLoader f620e;

    /* JADX INFO: renamed from: f */
    private String f621f;

    /* JADX INFO: renamed from: g */
    private String f622g = null;

    public C0425s(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.f616a = null;
        this.f617b = null;
        this.f618c = null;
        this.f619d = null;
        this.f620e = null;
        this.f621f = "TbsDexOpt";
        TbsLog.m665i("TbsWizard", "construction start...");
        if (context == null || context2 == null || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        this.f616a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.f617b = context2.getApplicationContext();
        } else {
            this.f617b = context2;
        }
        this.f618c = str;
        this.f619d = strArr;
        this.f621f = str2;
        for (int i = 0; i < this.f619d.length; i++) {
            TbsLog.m665i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.f619d[i]);
        }
        TbsLog.m665i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.f616a + " dexOutPutDir is " + str2);
        this.f620e = new DexLoader(str3, this.f616a, this.f619d, str2, QbSdk.f210o);
        System.currentTimeMillis();
        m494a(context);
        libwebp.loadWepLibraryIfNeed(context2, this.f618c);
        Map<String, Object> map = QbSdk.f210o;
        if (map == null || !map.containsKey(TbsCoreSettings.MULTI_PROCESS_ENABLE)) {
            HashMap map2 = new HashMap();
            map2.put(TbsCoreSettings.MULTI_PROCESS_ENABLE, 0);
            QbSdk.initTbsSettings(map2);
            TbsLog.m665i("[MultiProcess]", "default not enable multi process!");
        }
        Map<String, Object> map3 = QbSdk.f210o;
        if (map3 != null) {
            this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, map3);
            m489b(context);
        }
        int iM490c = m490c(context);
        if (iM490c >= 0) {
            TbsLog.m665i("TbsWizard", "construction end...");
            return;
        }
        throw new Exception("TbsWizard init error: " + iM490c + "; msg: " + this.f622g);
    }

    /* JADX INFO: renamed from: b */
    private void m489b(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("tbss", 0).edit();
            Map<String, Object> map = QbSdk.f210o;
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    editorEdit.putString(str, (String) obj);
                    TbsLog.m665i("TbsWizard", "initTbsSettingsBySP key is " + str + " value is " + ((String) obj));
                }
            }
            editorEdit.commit();
        } catch (Throwable th) {
            TbsLog.m665i("TbsWizard", "stack is " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: renamed from: c */
    private int m490c(Context context) {
        int iIntValue;
        String str;
        TbsLog.m665i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.f617b + " mDexLoader is " + this.f620e + " mtbsInstallLocation is " + this.f618c + " mDexOptPath is " + this.f621f);
        DexLoader dexLoader = this.f620e;
        Object objInvokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.f617b, dexLoader, this.f618c, this.f621f, TbsConfig.TBS_SDK_VERSIONNAME, 44286, QbSdk.m148a());
        if (objInvokeStaticMethod == null) {
            m491d();
            m492e();
            DexLoader dexLoader2 = this.f620e;
            objInvokeStaticMethod = dexLoader2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.f617b, dexLoader2, this.f618c, this.f621f);
        }
        if (objInvokeStaticMethod == null) {
            iIntValue = -3;
        } else if (objInvokeStaticMethod instanceof Integer) {
            iIntValue = ((Integer) objInvokeStaticMethod).intValue();
        } else if (objInvokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().m176a(this.f616a, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) objInvokeStaticMethod);
            iIntValue = -5;
        } else {
            iIntValue = -4;
        }
        if (iIntValue < 0) {
            Object objInvokeStaticMethod2 = this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (objInvokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) objInvokeStaticMethod2;
                this.f622g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            str = objInvokeStaticMethod2 instanceof String ? (String) objInvokeStaticMethod2 : null;
            return iIntValue;
        }
        this.f622g = str;
        return iIntValue;
    }

    /* JADX INFO: renamed from: d */
    private void m491d() {
        this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    /* JADX INFO: renamed from: e */
    private void m492e() {
        this.f620e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 44286);
    }

    /* JADX INFO: renamed from: a */
    public String m493a() {
        String str = null;
        Object objInvokeStaticMethod = this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (objInvokeStaticMethod == null) {
            objInvokeStaticMethod = this.f620e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (objInvokeStaticMethod != null) {
            str = String.valueOf(objInvokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX INFO: renamed from: a */
    public void m494a(Context context) {
        boolean zBooleanValue;
        Map<String, Object> map = QbSdk.f210o;
        if (map != null) {
            Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof Boolean) {
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else {
                zBooleanValue = true;
            }
        } else {
            zBooleanValue = true;
        }
        if (zBooleanValue) {
            C0457n.m791b(context);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m495a(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.f616a = context.getApplicationContext();
        if (this.f617b.getApplicationContext() != null) {
            this.f617b = this.f617b.getApplicationContext();
        }
        this.f618c = str;
        this.f619d = strArr;
        this.f621f = str2;
        libwebp.loadWepLibraryIfNeed(context2, str);
        Map<String, Object> map = QbSdk.f210o;
        if (map != null) {
            this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, map);
        }
        int iM490c = m490c(context);
        if (iM490c >= 0) {
            return;
        }
        throw new Exception("continueInit init error: " + iM490c + "; msg: " + this.f622g);
    }

    /* JADX INFO: renamed from: a */
    public boolean m496a(Context context, String str, String str2, Bundle bundle) {
        Object objInvokeStaticMethod = this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) objInvokeStaticMethod).booleanValue();
    }

    /* JADX INFO: renamed from: b */
    public String m497b() {
        String str = null;
        Object objInvokeStaticMethod = this.f620e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraCacheInfo", null, new Object[0]);
        if (objInvokeStaticMethod == null) {
            objInvokeStaticMethod = this.f620e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraCacheInfo", null, new Object[0]);
        }
        if (objInvokeStaticMethod != null) {
            str = String.valueOf(objInvokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get cache nothing..." : str;
    }

    /* JADX INFO: renamed from: c */
    public DexLoader m498c() {
        return this.f620e;
    }
}
