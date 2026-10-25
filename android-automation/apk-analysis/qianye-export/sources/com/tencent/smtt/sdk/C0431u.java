package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.u */
/* JADX INFO: loaded from: classes.dex */
public class C0431u {

    /* JADX INFO: renamed from: a */
    private static C0431u f643a;

    /* JADX INFO: renamed from: f */
    private static FileLock f644f;

    /* JADX INFO: renamed from: b */
    private C0433v f645b;

    /* JADX INFO: renamed from: c */
    private boolean f646c;

    /* JADX INFO: renamed from: d */
    private boolean f647d = false;

    /* JADX INFO: renamed from: e */
    private boolean f648e;

    private C0431u() {
    }

    /* JADX INFO: renamed from: a */
    public static C0431u m530a() {
        if (f643a == null) {
            synchronized (C0431u.class) {
                if (f643a == null) {
                    f643a = new C0431u();
                }
            }
        }
        return f643a;
    }

    /* JADX INFO: renamed from: a */
    public C0433v m531a(boolean z) {
        return z ? this.f645b : m535c();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009a A[Catch: all -> 0x022f, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00cf A[Catch: all -> 0x022f, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:53:0x01b6 A[Catch: all -> 0x022f, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01bc A[Catch: all -> 0x022f, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01f8 A[Catch: all -> 0x022f, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x020c A[Catch: all -> 0x022f, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0228 A[Catch: all -> 0x022f, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:10:0x0025, B:13:0x0050, B:15:0x0054, B:24:0x008c, B:26:0x009a, B:27:0x00a1, B:30:0x00b3, B:32:0x00cf, B:48:0x0130, B:50:0x013c, B:51:0x0176, B:60:0x022b, B:52:0x017b, B:47:0x0127, B:53:0x01b6, B:55:0x01bc, B:56:0x01f8, B:57:0x020c, B:59:0x0228, B:21:0x0075, B:22:0x0084, B:28:0x00a4, B:36:0x00e0, B:38:0x00e6, B:39:0x00f2, B:41:0x00f6, B:42:0x0119, B:44:0x011d, B:16:0x0066, B:18:0x006e), top: B:68:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x01bc, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:57:0x020c, please report this as an issue */
    /* JADX INFO: renamed from: a */
    public synchronized void m532a(Context context) {
        Throwable th;
        String str;
        String str2;
        if (this.f647d && !QbSdk.isEnableX5WithoutRestart()) {
            TbsLog.m672w("X5CoreEngine", "coreEngine has init, mCanUseX5=" + this.f646c);
            return;
        }
        TbsLog.m666i("X5CoreEngine", "init", "#1# Start init");
        C0412f c0412fM323a = C0412f.m323a(true);
        c0412fM323a.m329a(context, false, false);
        TbsLog.m666i("X5CoreEngine", "init", "#2# SDKEngine init finish");
        StringBuilder sb = new StringBuilder();
        C0425s c0425sM328a = c0412fM323a.m328a();
        if (c0412fM323a.m331b() && c0425sM328a != null) {
            if (!this.f648e) {
                TbsLog.m666i("X5CoreEngine", "init", "#3-1# X5CoreWizard start to load dex and so");
                C0433v c0433v = new C0433v(c0425sM328a.m498c());
                this.f645b = c0433v;
                try {
                    boolean zM554a = c0433v.m554a();
                    this.f646c = zM554a;
                    if (!zM554a) {
                        sb.append("can not use X5 by x5corewizard return false");
                    }
                } catch (NoSuchMethodException unused) {
                    this.f646c = true;
                    sb.append("NoSuchMethodException");
                } catch (Throwable th2) {
                    th = th2;
                    this.f646c = false;
                    sb.append("can not use x5 by x5corewizard throwable ");
                    sb.append(Log.getStackTraceString(th));
                    sb.append("mCanUseX5 is ");
                    sb.append(this.f646c);
                    if (this.f646c) {
                        CookieManager.getInstance().m129a();
                    }
                    this.f648e = true;
                    TbsLog.m665i("X5CoreEngine", "init  mCanUseX5 is " + this.f646c);
                    if (this.f646c) {
                        TbsLog.m666i("X5CoreEngine", "init", "#5# sTbsCoreLoadFileLock is " + f644f);
                        if (f644f == null) {
                            m533b(context);
                        }
                    } else {
                        TbsLog.m662e("X5CoreEngine", "mCanUseX5 is false --> report");
                        if (!c0412fM323a.m331b()) {
                            if (c0412fM323a.m331b()) {
                                TbsCoreLoadStat.getInstance().m176a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb.toString()));
                                str = "X5CoreEngine";
                                str2 = "[LoadError] details: " + sb.toString();
                            } else {
                                TbsCoreLoadStat.getInstance().m176a(context, 410, new Throwable());
                                str = "X5CoreEngine";
                                str2 = "[LoadError] mCanUseX5=false, available=false";
                            }
                        } else if (c0412fM323a.m331b()) {
                            TbsCoreLoadStat.getInstance().m176a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb.toString()));
                            str = "X5CoreEngine";
                            str2 = "[LoadError] details: " + sb.toString();
                        } else {
                            TbsCoreLoadStat.getInstance().m176a(context, 410, new Throwable());
                            str = "X5CoreEngine";
                            str2 = "[LoadError] mCanUseX5=false, available=false";
                        }
                        TbsLog.m663e(str, "init", str2);
                    }
                    this.f647d = true;
                }
                th = null;
                sb.append("mCanUseX5 is ");
                sb.append(this.f646c);
                if (this.f646c) {
                    CookieManager.getInstance().m129a();
                }
                this.f648e = true;
            }
            TbsLog.m665i("X5CoreEngine", "init  mCanUseX5 is " + this.f646c);
            if (this.f646c) {
                TbsLog.m662e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (!c0412fM323a.m331b() && c0425sM328a != null && th == null) {
                    try {
                        DexLoader dexLoaderM498c = c0425sM328a.m498c();
                        Object objInvokeStaticMethod = dexLoaderM498c != null ? dexLoaderM498c.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]) : null;
                        if (objInvokeStaticMethod instanceof Throwable) {
                            Throwable th3 = (Throwable) objInvokeStaticMethod;
                            sb.append("#");
                            sb.append(th3.getMessage());
                            sb.append("; cause: ");
                            sb.append(th3.getCause());
                            sb.append("; th: ");
                            sb.append(th3);
                        }
                        if (objInvokeStaticMethod instanceof String) {
                            sb.append("failure detail: ");
                            sb.append(objInvokeStaticMethod);
                        }
                    } catch (Throwable th4) {
                        TbsLog.m663e("X5CoreEngine", "init", Log.getStackTraceString(th4));
                    }
                    if (sb.toString().contains("isPreloadX5Disabled:-10000")) {
                        TbsCoreLoadStat.getInstance().m176a(context, 408, new Throwable("Core Crash, details: " + sb.toString()));
                        str = "X5CoreEngine";
                        str2 = "[LoadError] Core Crash, details: " + sb.toString();
                    } else {
                        TbsCoreLoadStat.getInstance().m176a(context, 407, new Throwable("Failed in Core, details: " + sb.toString()));
                        str = "X5CoreEngine";
                        str2 = "[LoadError] Failed in Core, details: " + sb.toString();
                    }
                } else if (c0412fM323a.m331b()) {
                    TbsCoreLoadStat.getInstance().m176a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb.toString()));
                    str = "X5CoreEngine";
                    str2 = "[LoadError] details: " + sb.toString();
                } else {
                    TbsCoreLoadStat.getInstance().m176a(context, 410, new Throwable());
                    str = "X5CoreEngine";
                    str2 = "[LoadError] mCanUseX5=false, available=false";
                }
                TbsLog.m663e(str, "init", str2);
            } else {
                TbsLog.m666i("X5CoreEngine", "init", "#5# sTbsCoreLoadFileLock is " + f644f);
                if (f644f == null) {
                    m533b(context);
                }
            }
            this.f647d = true;
        }
        this.f646c = false;
        TbsLog.m663e("X5CoreEngine", "init", "SDKEngine tbs not available!");
        sb.append("SDKEngine tbs not available_");
        th = null;
        TbsLog.m665i("X5CoreEngine", "init  mCanUseX5 is " + this.f646c);
        if (this.f646c) {
            TbsLog.m662e("X5CoreEngine", "mCanUseX5 is false --> report");
            if (!c0412fM323a.m331b()) {
                if (c0412fM323a.m331b()) {
                    TbsCoreLoadStat.getInstance().m176a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb.toString()));
                    str = "X5CoreEngine";
                    str2 = "[LoadError] details: " + sb.toString();
                } else {
                    TbsCoreLoadStat.getInstance().m176a(context, 410, new Throwable());
                    str = "X5CoreEngine";
                    str2 = "[LoadError] mCanUseX5=false, available=false";
                }
            } else if (c0412fM323a.m331b()) {
                TbsCoreLoadStat.getInstance().m176a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb.toString()));
                str = "X5CoreEngine";
                str2 = "[LoadError] details: " + sb.toString();
            } else {
                TbsCoreLoadStat.getInstance().m176a(context, 410, new Throwable());
                str = "X5CoreEngine";
                str2 = "[LoadError] mCanUseX5=false, available=false";
            }
            TbsLog.m663e(str, "init", str2);
        } else {
            TbsLog.m666i("X5CoreEngine", "init", "#5# sTbsCoreLoadFileLock is " + f644f);
            if (f644f == null) {
                m533b(context);
            }
        }
        this.f647d = true;
    }

    /* JADX INFO: renamed from: b */
    public FileLock m533b(Context context) {
        String str;
        String str2;
        TbsLog.m665i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = f644f;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (C0431u.class) {
            if (f644f == null) {
                FileLock fileLockM652d = FileUtil.m652d(context);
                f644f = fileLockM652d;
                if (fileLockM652d == null) {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock failed!";
                } else {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock succeeded: " + f644f;
                }
                TbsLog.m665i(str, str2);
            }
        }
        return f644f;
    }

    /* JADX INFO: renamed from: b */
    public boolean m534b() {
        if (QbSdk.f196a || QbSdk.getIsSysWebViewForcedByOuter()) {
            return false;
        }
        return this.f646c;
    }

    /* JADX INFO: renamed from: c */
    public C0433v m535c() {
        if (QbSdk.f196a) {
            return null;
        }
        return this.f645b;
    }

    /* JADX INFO: renamed from: d */
    public boolean m536d() {
        return this.f647d;
    }
}
