package I1I.I1I.p008IL;

import I1I.I1I.ILil.C0001i1;
import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.LIl;
import I1I.I1I.ILil.LlLI1;
import I1I.I1I.ILil.iIi1;
import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.ILil.lL;
import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.ddm.DdmHandleAppName;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.FileProvider;
import com.google.android.flexbox.BuildConfig;
import com.google.gson.Gson;
import com.main.app.ImeInput;
import com.main.app.LogListActivity;
import com.main.app.Native;
import com.main.app.UIState;
import com.main.app.X5ProcessInitService;
import com.main.engine.ImageUtils;
import com.main.engine.JIntent;
import com.main.engine.NativeContext;
import com.mysql.jdbc.StatementImpl;
import com.p000nx.assist.UIMgr;
import com.qyzs.smn2.R;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.Md5Utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opencv.videoio.Videoio;
import p047IL.C0007;
import p047IL.L1l;
import p047IL.l;
import p051lLi1LL.IL1Iii.ILil.IL1Iii.iIlLiL;

/* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii, reason: invalid class name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class lIlii {
    public static String I11L;
    public static Point I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static String f3370I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static String[] f3371IL1Iii;
    public static int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Context f3372ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static boolean f1080ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static int f3373Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static String f1081IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static Handler f1082IiL;
    public static String Lil;
    public static int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static String f1083Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static Class f1084L11I;
    public static int iIi1;
    public static Point iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Context f1085iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static boolean f1086lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static int f1087lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static int f1088llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Context f1089lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static Method f1090il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static String f1091lL;

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$I1I */
    /* JADX INFO: compiled from: Utils.java */
    public static class I1I implements QbSdk.PreInitCallback {
        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onCoreInitFinished() {
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onViewInitFinished(boolean z) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 105}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 3, 2, 14, 90}, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 85, 81, 88, 8}, "12e0a0"))), I1I.IL1Iii.IL1Iii(new byte[]{86, 15, 52, 88, 4, 22, 112, 15, 11, 69, 39, 8, 87, 8, 17, 89, 4, 5, 3, 65}, I1I.IL1Iii.IL1Iii(new byte[]{12, 3, 83, 2, 86, 88}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 9, 0, 81, 9}, "1783f0"))) + z);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$IL1Iii */
    /* JADX INFO: compiled from: Utils.java */
    public static class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Context f3374I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3375ILil;

        public IL1Iii(String str, Context context) {
            this.f3375ILil = str;
            this.f3374I1I = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 61}, I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 5, 83, 4, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 7, 7, 2, 84}, "2b6a3d"))), I1I.IL1Iii.IL1Iii(new byte[]{81, 89, 64, 77, 80, 89, 84, 23, 81, 92, 86, 92, 86, 13}, I1I.IL1Iii.IL1Iii(new byte[]{11, 86, 1, 1, 83, 7}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 0, 8, 82, 7}, "a72005"))) + this.f3375ILil);
            try {
                File file = new File(this.f3375ILil);
                Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{82, 12, 2, 22, 11, 90, 87, 76, 15, 10, 16, 86, 93, 22, 72, 5, 7, 71, 90, 13, 8, 74, 50, 122, 118, 53}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 82, 80, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{86, 5, 12, 2, 82, 84}, "0c867c"))));
                if (Build.VERSION.SDK_INT >= 24) {
                    Uri uriIlil = FileProvider.Ilil(this.f3374I1I, this.f3374I1I.getPackageName() + I1I.IL1Iii.IL1Iii(new byte[]{29, 0, 95, 90, 83, 19, 65, 9, 64, 95, 82, 6, 65}, I1I.IL1Iii.IL1Iii(new byte[]{80, 95, 5, 84, 6, 5}, I1I.IL1Iii.IL1Iii(new byte[]{7, 14, 3, 82, 81, 95}, "d700a9"))), file);
                    intent.addFlags(1);
                    intent.setDataAndType(uriIlil, I1I.IL1Iii.IL1Iii(new byte[]{80, 17, 66, 85, 15, 5, 80, 21, 91, 86, 8, 73, 71, 15, 86, 23, 7, 8, 85, 19, 93, 80, 2, 72, 65, 0, 81, 82, 7, 1, 84, 76, 83, 75, 5, 14, 88, 23, 87}, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 1, 8, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{90, 9, 80, 1, 84, 0}, "99c02d"))));
                } else {
                    intent.setDataAndType(Uri.fromFile(file), I1I.IL1Iii.IL1Iii(new byte[]{0, 73, 17, 89, 91, 90, 0, 77, 8, 90, 92, 22, 23, 87, 5, 27, 83, 87, 5, 75, 14, 92, 86, 23, 17, 88, 2, 94, 83, 94, 4, 20, 0, 71, 81, 81, 8, 79, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 15, 83, 4, 6, 15}, I1I.IL1Iii.IL1Iii(new byte[]{14, 14, 3, 5, 12, 84}, "88148b"))));
                }
                intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
                this.f3374I1I.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$ILL */
    /* JADX INFO: compiled from: Utils.java */
    public static class ILL implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ long f3376I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3377ILil;

        public ILL(String str, long j) {
            this.f3377ILil = str;
            this.f3376I1I = j;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            lIlii.iIlLiL(new String[]{this.f3377ILil}, this.f3376I1I);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$ILil */
    /* JADX INFO: compiled from: Utils.java */
    public static class ILil implements TbsListener {
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 57}, I1I.IL1Iii.IL1Iii(new byte[]{14, 82, 83, 1, 83, 83}, I1I.IL1Iii.IL1Iii(new byte[]{15, 85, 82, 0, 5, 1}, "6fe5a1"))), I1I.IL1Iii.IL1Iii(new byte[]{13, 10, 119, 95, 21, 87, 14, 11, 82, 84, 36, 80, 12, 13, 64, 88, 7, 93, 88, 68}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 2, 84, 1, 9}, I1I.IL1Iii.IL1Iii(new byte[]{15, 81, 0, 81, 82, 85}, "8f151e"))) + i);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{43, 57}, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 87, 14, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{5, 81, 3, 0, 86, 3}, "33b8b4"))), I1I.IL1Iii.IL1Iii(new byte[]{37, 14, 66, 82, 70, 115, 9, 22, 94, 91, 9, 86, 2, 8, 94, 80, 92, 23}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 86, 3, 7, 6}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 4, 85, 4, 8}, "babae9"))) + i);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 111}, I1I.IL1Iii.IL1Iii(new byte[]{4, 15, 2, 1, 0, 4}, I1I.IL1Iii.IL1Iii(new byte[]{11, 94, 7, 10, 84, 87}, "8f632a"))), I1I.IL1Iii.IL1Iii(new byte[]{92, 91, 122, 8, 66, 76, 82, 89, 95, 32, 88, 86, 90, 70, 91, 3, 85, 2, 19}, I1I.IL1Iii.IL1Iii(new byte[]{85, 84, 1, 82, 9, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 88, 86, 6, 89, 11}, "09d2a2"))) + i);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.java */
    public static class IL implements I1I.ILil.IL1Iii.IL1Iii.I1I {
        @Override // I1I.ILil.IL1Iii.IL1Iii.I1I
        public void IL1Iii(String str) {
            String unused = lIlii.Lil = str;
        }

        @Override // I1I.ILil.IL1Iii.IL1Iii.I1I
        public void ILil(Exception exc) {
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.java */
    public static class IiL implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Context f3378ILil;

        public IiL(Context context) {
            this.f3378ILil = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                I1I.p062Ilil.p063IL1Iii.ILil.m1251IL(this.f3378ILil).Ilil();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$L丨1丨1丨I, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.java */
    public static class L11I implements I1I.I1I.p008IL.lLi1LL.I1I {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Activity f3379IL1Iii;

        public L11I(Activity activity) {
            this.f3379IL1Iii = activity;
        }

        @Override // I1I.I1I.p008IL.lLi1LL.I1I
        public void IL1Iii(I1I.I1I.p008IL.lLi1LL.IL il) {
            if (il == I1I.I1I.p008IL.lLi1LL.IL.f0Ok) {
                lIlii.m1146iI1L1Ll(this.f3379IL1Iii);
            } else {
                this.f3379IL1Iii.finish();
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.java */
    public static class iILLL1 implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f3380I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Context f3381ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ int f3382Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f1092IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ int f1093lLi1LL;

        public iILLL1(Context context, String str, int i, int i2, int i3) {
            this.f3381ILil = context;
            this.f3380I1I = str;
            this.f1092IL = i;
            this.f3382Ilil = i2;
            this.f1093lLi1LL = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                I1I.p062Ilil.p063IL1Iii.ILil.m1251IL(this.f3381ILil).m1252IiL(this.f3380I1I, this.f1092IL, this.f3382Ilil, this.f1093lLi1LL);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.java */
    public static class lLi1LL implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            lIlii.m24L();
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.I丨L.lI丨lii$丨il, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Utils.java */
    public static class RunnableC0609il implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f3383I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Context f3384ILil;

        public RunnableC0609il(Context context, String str) {
            this.f3384ILil = context;
            this.f3383I1I = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Ll1.m1071IL(this.f3384ILil).m1072IiL(this.f3383I1I);
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 61}, I1I.IL1Iii.IL1Iii(new byte[]{12, 84, 0, 87, 1, 84}, I1I.IL1Iii.IL1Iii(new byte[]{8, 2, 91, 7, 82, 81}, "13caa3"))), I1I.IL1Iii.IL1Iii(new byte[]{70, 93, 14, 65, 17, 4, 71, 71, 91}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 84, 5, 1, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 93, 80, 2, 4, 2}, "58e140"))) + e.toString());
            }
        }
    }

    static {
        I1I.IL1Iii.IL1Iii(new byte[]{75, 24, 27, 72, 28, 117, 35, 114, 127, 43, 17, 103, 51, 119, 122, 44, 114, 23, 45, 112, 111, 72, 28, 26, 75, 24, 60, 40, 120, 112, 0, 120, 119, 85, 118, 116, 53, 68, 113, 54, 120, 85, 85, 113, 103, 32, 115, 118, 55, 96, 119, 36, 5, 112, 40, 116, 114, 38, 115, 94, 55, 126, 116, 2, 96, 115, 17, 127, 79, 43, 103, 69, 11, 4, 110, 6, 118, 100, 31, 12, 103, 84, 102, 127, 49, 13, 127, 53, 104, 126, 30, 63, 95, 4, 124, 3, 39, 7, 97, 49, 115, 77, 19, 86, 79, 18, 91, 114, 82, 26, 120, 7, 84, 100, 44, 108, 95, 4, 95, 116, 53, 112, 91, 15, 99, 123, 82, 118, 88, 0, 84, 91, 9, 65, 121, 6, 30, 102, 17, 12, 83, 16, 86, 118, 23, 93, 83, 18, 26, 67, 36, 95, 80, 38, 4, 89, 108, 1, 2, 86, 90, 94, 17, 97, 80, 33, 124, 121, 10, 3, 111, 85, 6, 97, 5, 83, 3, 9, 82, 88, 52, 103, 115, 63, 67, 79, 35, 89, 25, 17, 64, 2, 0, 89, 83, 11, 68, 118, 11, 7, 96, 36, 107, 79, 86, 115, 29, 46, 84, 78, 36, 80, 92, 87, 115, 113, 17, 65, 116, 85, 112, 61, 95, 103, 115, 49, 0, 4, 42, 1, 115, 2, 102, 66, 15, 88, 90, 48, 7, 64, 47, 113, 119, 52, 112, 117, 108, 24, 27, 72, 28, 26, 35, 123, 114, 69, 97, 98, 36, 121, 127, 38, 17, 124, 35, 108, 27, 72, 28, 26, 75, 63}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 5, 80, 4, 81}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 7, 84, 3, 7}, "ae4a6a")));
        f3371IL1Iii = new String[]{I1I.IL1Iii.IL1Iii(new byte[]{87, 90, 93, 75, 13, 13, 82, 26, 73, 92, 16, 9, 95, 71, 74, 80, 13, 10, 24, 99, 107, 112, 54, 33, 105, 113, 97, 109, 39, 54, 120, 117, 117, 102, 49, 48, 121, 102, 120, 126, 39}, I1I.IL1Iii.IL1Iii(new byte[]{15, 85, 91, 10, 4, 87}, I1I.IL1Iii.IL1Iii(new byte[]{14, 86, 0, 82, 94, 81}, "77ba8b"))), I1I.IL1Iii.IL1Iii(new byte[]{2, 95, 6, 23, 12, 92, 7, 31, 18, 0, 17, 88, 10, 66, 17, 12, 12, 91, 77, 99, 39, 36, 39, 106, 38, 105, 54, 32, 49, 123, 34, 125, 61, 54, 55, 122, 49, 112, 37, 32}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 87, 4, 87, 84}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 83, 7, 80, 85}, "36ffd4"))), I1I.IL1Iii.IL1Iii(new byte[]{81, 8, 87, 67, 88, 94, 84, 72, 67, 84, 69, 90, 89, 21, 64, 88, 88, 89, 30, 52, 118, 112, 115, 104, 96, 46, 124, 127, 114, 104, 99, 50, 114, 101, 114}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 0, 82, 83, 82}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 5, 87, 2, 80}, "0364f5"))), I1I.IL1Iii.IL1Iii(new byte[]{89, 13, 1, 22, 95, 91, 92, 77, 21, 1, 66, 95, 81, 16, 22, 13, 95, 92, 22, 32, 36, 40, 124, 109, 104, 43, 42, 42, 117}, I1I.IL1Iii.IL1Iii(new byte[]{15, 90, 0, 93, 82, 5}, I1I.IL1Iii.IL1Iii(new byte[]{1, 14, 84, 10, 85, 0}, "671377"))), I1I.IL1Iii.IL1Iii(new byte[]{5, 89, 1, 71, 14, 11, 0, 25, 21, 80, 19, 15, 13, 68, 22, 92, 14, 12, 74, 118, 38, 118, 36, 49, 55, 104, 35, 124, 47, 39, 59, 123, 42, 118, 32, 54, 45, 120, 43}, I1I.IL1Iii.IL1Iii(new byte[]{83, 15, 4, 5, 7, 91}, I1I.IL1Iii.IL1Iii(new byte[]{86, 91, 7, 3, 94, 9}, "acf380"))), I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 81, 74, 14, 93, 6, 22, 69, 93, 19, 89, 11, 75, 70, 81, 14, 90, 76, 121, 118, 123, 36, 103, 49, 103, 118, 119, 32, 102, 49, 125, 106, 116, 46, 119, 35, 108, 124, 119, 47}, I1I.IL1Iii.IL1Iii(new byte[]{87, 12, 12, 12, 3, 13}, I1I.IL1Iii.IL1Iii(new byte[]{3, 13, 88, 85, 83, 88}, "69aa1a"))), I1I.IL1Iii.IL1Iii(new byte[]{88, 95, 0, 74, 95, 88, 93, 31, 20, 93, 66, 92, 80, 66, 23, 81, 95, 95, 23, 112, 39, 123, 117, 98, 106, 110, 42, 125, 100, 102, 118, 99, 47, 103, 99, 101, 120, 101, 33}, I1I.IL1Iii.IL1Iii(new byte[]{90, 1, 5, 92, 86, 80}, I1I.IL1Iii.IL1Iii(new byte[]{91, 84, 86, 87, 82, 0}, "8d734a"))), I1I.IL1Iii.IL1Iii(new byte[]{85, 13, 6, 17, 91, 95, 80, 77, 18, 6, 70, 91, 93, 16, 17, 10, 91, 88, 26, 34, 33, 32, 113, 101, 103, 60, 53, 42, 114, 127, 107, 48, 54, 34, 96, 115}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 4, 83, 0, 1}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 3, 8, 6, 3}, "e7e824"))), I1I.IL1Iii.IL1Iii(new byte[]{4, 90, 1, 16, 14, 94, 1, 26, 21, 7, 19, 90, 12, 71, 22, 11, 14, 89, 75, 103, 32, 44, 37, 104, 54, 121, 54}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 84, 0, 86, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 4, 86, 81, 0}, "6154fb"))), I1I.IL1Iii.IL1Iii(new byte[]{81, 13, 82, 22, 12, 95, 84, 77, 70, 1, 17, 91, 89, 16, 69, 13, 12, 88, 30, 49, 115, 37, 39, 105, 99, 46, 101}, I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 0, 6, 82, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 85, 80, 5, 80}, "77c24e")))};
        f3373Ilil = 0;
        f1082IiL = null;
        ILL = 0;
        f1083Ll1 = null;
        f1086lIiI = false;
        f1080ILl = false;
        Lil = null;
        LlLI1 = 0;
        f1088llL1ii = 0;
        f1087lIlii = 0;
        iIi1 = 0;
        iIlLiL = null;
        I11li1 = null;
        f1091lL = null;
        I11L = null;
    }

    /* JADX INFO: renamed from: I1 */
    public static int m13I1(String str) {
        int i = 0;
        try {
            String upperCase = str.toUpperCase();
            int length = 0;
            for (int length2 = upperCase.length() - 1; length2 >= 0; length2--) {
                try {
                    char cCharAt = upperCase.charAt(length2);
                    length += ((cCharAt < 'A' || cCharAt > 'F') ? (cCharAt < '0' || cCharAt > '9') ? 0 : cCharAt - '0' : (cCharAt - 'A') + 10) << (((upperCase.length() - length2) - 1) * 4);
                } catch (Exception unused) {
                    i = length;
                    return i;
                }
            }
            return length;
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: renamed from: I11II丨i, reason: contains not printable characters */
    public static void m1112I11IIi(String str, String str2, int i) {
        try {
            File file = new File(new File(str2).getParent(), I1I.IL1Iii.IL1Iii(new byte[]{27, 95, 88, 85}, I1I.IL1Iii.IL1Iii(new byte[]{13, 0, 9, 86, 87, 83}, I1I.IL1Iii.IL1Iii(new byte[]{12, 86, 89, 83, 1, 6}, "5ea254"))));
            if (!file.exists()) {
                file.mkdir();
            }
            String strIL1Iii = BuildConfig.FLAVOR;
            if (i == 1 || i == 3) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{94, 12, 91}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 88, 89, 7, 4}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 88, 82, 6, 7}, "db9350")));
            } else if (i == 2) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{90, 10, 3, 15, 7}, I1I.IL1Iii.IL1Iii(new byte[]{82, 90, 4, 93, 6, 86}, I1I.IL1Iii.IL1Iii(new byte[]{5, 95, 1, 83, 0, 7}, "afd75d")));
            }
            String str3 = String.format(I1I.IL1Iii.IL1Iii(new byte[]{22, 69, 27, 64, 16, 3, 84, 25, 71, 64, 75, 10, 80, 84, 15, 86, 0, 15, 88, 105, 8, 93, 13, 72, 74, 89}, I1I.IL1Iii.IL1Iii(new byte[]{11, 6, 87, 5, 0, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 8, 87, 6, 82, 85}, "38b06d"))), strIL1Iii);
            File file2 = new File(file, I1I.IL1Iii.IL1Iii(new byte[]{92, 81, 86, 91, 87, 2, 89, 89, 107, 92, 92, 15, 30, 75, 91}, I1I.IL1Iii.IL1Iii(new byte[]{3, 91, 7, 6, 3, 82}, I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 1, 1, 4, 13}, "0b2159"))));
            File file3 = new File(file, I1I.IL1Iii.IL1Iii(new byte[]{84, 10, 91, 84, 87, 85, 81, 2, 102, 83, 92, 88, 22, 16, 86, 23, 84, 93, 89, 4}, I1I.IL1Iii.IL1Iii(new byte[]{90, 82, 92, 93, 7, 83}, I1I.IL1Iii.IL1Iii(new byte[]{82, 0, 1, 82, 86, 84}, "01d6c6"))));
            if (new File(str3).exists() && Native.createSymbolicLink(str3, file2.getAbsolutePath())) {
                file3.createNewFile();
            }
        } catch (Exception unused) {
        }
    }

    public static String I11L(String str) {
        Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{73, 91, 92, 70, 79, 4, 25, 24, 86, 61, 26, 28, 58, 84, 75, 92, 82, 25, 7, 37, 75, 35, 110, 31, 72}, I1I.IL1Iii.IL1Iii(new byte[]{88, 0, 86, 84, 4, 87}, I1I.IL1Iii.IL1Iii(new byte[]{92, 86, 0, 2, 82, 5}, "e203ef")))).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static void I11li1(Context context, String str, String str2) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str2, 0);
            fileOutputStreamOpenFileOutput.write(bArr);
            fileOutputStreamOpenFileOutput.close();
            inputStreamOpen.close();
        } catch (Exception e) {
            I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{126, 111}, I1I.IL1Iii.IL1Iii(new byte[]{2, 2, 82, 5, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 5, 5, 86, 5}, "baa6e5"))), e.toString());
        }
    }

    public static void I1I(long j) {
        try {
            Vibrator vibrator = (Vibrator) LL1IL().getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{69, 94, 1, 74, 4, 64, 92, 69}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 87, 10, 87, 13}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 13, 2, 10, 90}, "6b908c"))));
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(j);
            }
        } catch (Exception unused) {
        }
    }

    public static String I1IILIIL() {
        byte b;
        NetworkInterface networkInterface;
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Iterator it = list.iterator();
            do {
                byte b2 = 17;
                b = 83;
                byte b3 = 0;
                if (!it.hasNext()) {
                    for (NetworkInterface networkInterface2 : list) {
                        if (networkInterface2.getName().equals(I1I.IL1Iii.IL1Iii(new byte[]{b2, 8, 87, 15, 5}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 3, 80, 5, 82}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 83, 80, 84, 0}, "eafadb"))))) {
                            byte[] hardwareAddress = networkInterface2.getHardwareAddress();
                            if (hardwareAddress == null) {
                                hardwareAddress = new byte[0];
                            }
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            int i = 0;
                            while (i < length) {
                                byte b4 = hardwareAddress[i];
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(Integer.toHexString(b4 & StatementImpl.USES_VARIABLES_UNKNOWN));
                                byte[] bArr = new byte[1];
                                bArr[b3] = 14;
                                byte[] bArr2 = new byte[6];
                                bArr2[b3] = 12;
                                bArr2[1] = 81;
                                bArr2[2] = 81;
                                bArr2[3] = 84;
                                bArr2[4] = b3;
                                bArr2[5] = 83;
                                byte[] bArr3 = new byte[6];
                                bArr3[b3] = 92;
                                bArr3[1] = 83;
                                bArr3[2] = 82;
                                bArr3[3] = 6;
                                bArr3[4] = 90;
                                bArr3[5] = 82;
                                sb2.append(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "dd61be"))));
                                sb.append(sb2.toString());
                                i++;
                                b3 = 0;
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            return sb.toString();
                        }
                        b2 = 17;
                    }
                    return BuildConfig.FLAVOR;
                }
                networkInterface = (NetworkInterface) it.next();
            } while (!networkInterface.getName().equals(I1I.IL1Iii.IL1Iii(new byte[]{3, 17, 91, 82}, I1I.IL1Iii.IL1Iii(new byte[]{85, 84, 87, 83, 87, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 2, 7, 81, 80}, "f1f6e2")))));
            byte[] hardwareAddress2 = networkInterface.getHardwareAddress();
            if (hardwareAddress2 == null) {
                hardwareAddress2 = new byte[0];
            }
            StringBuilder sb3 = new StringBuilder();
            int length2 = hardwareAddress2.length;
            int i2 = 0;
            while (i2 < length2) {
                sb3.append(Integer.toHexString(hardwareAddress2[i2] & StatementImpl.USES_VARIABLES_UNKNOWN) + I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{90, 7, 2, 93, 85, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, b, 82, 89, 1, 81}, "b13a5d"))));
                i2++;
                b = 83;
            }
            if (sb3.length() > 0) {
                sb3.deleteCharAt(sb3.length() - 1);
            }
            return sb3.toString();
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static void I1LilL(int i, int i2) {
        LlLI1 = i;
        f1088llL1ii = i2;
        Point point = I11li1;
        if (point != null) {
            point.set(i, i2);
        } else {
            I11li1 = new Point(LlLI1, f1088llL1ii);
        }
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public static int m1113I1L11L(Context context) {
        try {
            return ((WindowManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{19, 91, 92, 84, 90, 67}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 11, 8, 7, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 14, 1, 0, 81}, "477920"))))).getDefaultDisplay().getRotation();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void I1i(String str, String str2) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str2));
            try {
                bufferedWriter.write(str);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
        }
    }

    public static void I1i1LL1(String str, String str2) {
        SmsManager smsManager = SmsManager.getDefault();
        PendingIntent broadcast = PendingIntent.getBroadcast(LL1IL(), 0, new Intent(I1I.IL1Iii.IL1Iii(new byte[]{106, 116, 126, 98, 106, 96, 116, 98, 111, 119, 118, 103, 112, 126, 126}, I1I.IL1Iii.IL1Iii(new byte[]{15, 8, 0, 80, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 13, 2, 85, 5, 1}, "542316")))), 0);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(LL1IL(), 1, new Intent(I1I.IL1Iii.IL1Iii(new byte[]{119, 117, 116, 40, 103, 36, 97, 111, 107, 44, 98, 62, 114, 115, 108, 40, 126, 47}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 90, 89, 8, 4}, I1I.IL1Iii.IL1Iii(new byte[]{6, 83, 86, 94, 0, 7}, "704f9b")))), 0);
        if (str2.length() > 70) {
            ArrayList<String> arrayListDivideMessage = smsManager.divideMessage(str2);
            ArrayList<PendingIntent> arrayList = new ArrayList<>();
            for (int i = 0; i < arrayListDivideMessage.size(); i++) {
                arrayList.add(broadcast);
            }
            smsManager.sendMultipartTextMessage(str, null, arrayListDivideMessage, arrayList, null);
        } else {
            smsManager.sendTextMessage(str, null, str2, broadcast, broadcast2);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(I1I.IL1Iii.IL1Iii(new byte[]{87, 88, 18, 87}, I1I.IL1Iii.IL1Iii(new byte[]{87, 10, 2, 84, 85, 10}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 82, 0, 86, 5}, "2f6f07"))), Long.valueOf(System.currentTimeMillis()));
        contentValues.put(I1I.IL1Iii.IL1Iii(new byte[]{74, 0, 81, 1}, I1I.IL1Iii.IL1Iii(new byte[]{11, 85, 4, 85, 2, 4}, I1I.IL1Iii.IL1Iii(new byte[]{10, 8, 13, 81, 4, 81}, "989abb"))), (Integer) 1);
        contentValues.put(I1I.IL1Iii.IL1Iii(new byte[]{68, 27, 69, 4}, I1I.IL1Iii.IL1Iii(new byte[]{9, 84, 87, 4, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{90, 82, 82, 0, 90, 4}, "cd0e94"))), (Integer) 2);
        contentValues.put(I1I.IL1Iii.IL1Iii(new byte[]{89, 86, 81, 67, 3, 23, 75}, I1I.IL1Iii.IL1Iii(new byte[]{8, 80, 4, 80, 4, 86}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 87, 82, 0, 7}, "35f3b5"))), str);
        contentValues.put(I1I.IL1Iii.IL1Iii(new byte[]{81, 90, 87, 77}, I1I.IL1Iii.IL1Iii(new byte[]{2, 12, 82, 1, 13, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 93, 86, 83, 86, 80}, "5d7fb5"))), str2);
        LL1IL().getContentResolver().insert(Uri.parse(I1I.IL1Iii.IL1Iii(new byte[]{87, 94, 94, 69, 0, 88, 64, 11, 31, 30, 22, 91, 71}, I1I.IL1Iii.IL1Iii(new byte[]{13, 4, 85, 1, 83, 1}, I1I.IL1Iii.IL1Iii(new byte[]{93, 1, 0, 83, 83, 82}, "d4ecee")))), contentValues);
    }

    public static void IIi1II(Application application) {
        if (LLI(application)) {
            QbSdk.setDownloadWithoutWifi(true);
            QbSdk.setCoreMinVersion(QbSdk.CORE_VER_ENABLE_202112);
            QbSdk.setTbsListener(new ILil());
            QbSdk.initX5Environment(application, new I1I());
        }
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public static String m1114IIiI(Context context) {
        InputMethodInfo next;
        if (!TextUtils.isEmpty(f1083Ll1)) {
            return f1083Ll1;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{90, 88, 18, 22, 22, 62, 94, 83, 22, 11, 13, 5}, I1I.IL1Iii.IL1Iii(new byte[]{10, 82, 0, 83, 3, 4}, I1I.IL1Iii.IL1Iii(new byte[]{8, 92, 6, 83, 5, 93}, "18dcd8"))));
        String string = Settings.Secure.getString(context.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 81, 82, 67, 93, 66, 59, 94, 93, 70, 68, 66, 59, 90, 86, 66, 89, 89, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 2, 3, 10, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 85, 9, 82, 81}, "13a007"))));
        String strM1169lIIiIlL = m1169lIIiIlL(context);
        if (string != null && string.equals(strM1169lIIiIlL)) {
            Iterator<InputMethodInfo> it = inputMethodManager.getEnabledInputMethodList().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (!next.getId().equals(strM1169lIIiIlL)) {
                }
            }
            next = null;
        } else if (string != null) {
            for (InputMethodInfo inputMethodInfo : inputMethodManager.getEnabledInputMethodList()) {
                if (inputMethodInfo.getId().equals(string)) {
                    next = inputMethodInfo;
                }
            }
            next = null;
        } else {
            next = null;
        }
        if (next != null) {
            return next.getId();
        }
        return null;
    }

    public static boolean IL1(Context context) {
        return context.getResources().getInteger(R.integer.is_byhandle_only) != 0;
    }

    /* JADX INFO: renamed from: IL11L丨, reason: contains not printable characters */
    public static String m1115IL11L(String str) {
        File file;
        boolean z;
        String str2 = I1I.IL1Iii.IL1Iii(new byte[]{75, 85, 3, 71, 80, 27, 8, 94, 1, 82, 93, 27, 16, 92, 18, 28}, I1I.IL1Iii.IL1Iii(new byte[]{93, 85, 90, 7, 6, 12}, I1I.IL1Iii.IL1Iii(new byte[]{8, 85, 14, 86, 86, 0}, "116ba8"))) + System.currentTimeMillis() + I1I.IL1Iii.IL1Iii(new byte[]{29, 7, 17, 93}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 4, 87, 82, 80}, I1I.IL1Iii.IL1Iii(new byte[]{14, 83, 81, 85, 82, 5}, "8f44e6")));
        try {
            try {
                if (Build.VERSION.SDK_INT == 22 && m1122IliLL1i()) {
                    str2 = str;
                    z = false;
                } else {
                    z = true;
                }
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 57}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 5, 0, 87, 8}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 89, 89, 13, 12}, "e38a94"))), I1I.IL1Iii.IL1Iii(new byte[]{13, 15, 64, 21, 85, 84, 8, 65, 82, 17, 95, 5, 90}, I1I.IL1Iii.IL1Iii(new byte[]{1, 4, 1, 81, 5, 1}, I1I.IL1Iii.IL1Iii(new byte[]{80, 87, 4, 83, 6, 12}, "526c75"))) + str + I1I.IL1Iii.IL1Iii(new byte[]{79}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 0, 82, 3, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 11, 7, 1, 84, 2}, "48e2df"))) + str2);
                if (!z || m1144L11I(str, str2)) {
                    String strIIlLiL = iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{19, 91, 22, 95, 13, 23, 23, 87, 90, 90, 67, 73, 17, 22}, I1I.IL1Iii.IL1Iii(new byte[]{90, 87, 6, 14, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{88, 83, 7, 9, 82, 0}, "a2716a"))) + str2}, 0L);
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 104}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 81, 4, 83, 4}, I1I.IL1Iii.IL1Iii(new byte[]{12, 91, 87, 80, 1, 3}, "99c1ef"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 91, 74, 66, 83, 93, 85, 21, 75, 83, 70, 12, 7}, I1I.IL1Iii.IL1Iii(new byte[]{90, 83, 93, 80, 0, 9}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 0, 7, 87, 93}, "dcdaee"))) + strIIlLiL);
                    if (strIIlLiL != null && strIIlLiL.contains(I1I.IL1Iii.IL1Iii(new byte[]{96, 71, 82, 90, 82, 23, 64}, I1I.IL1Iii.IL1Iii(new byte[]{7, 80, 80, 93, 0, 86}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 87, 80, 1, 87}, "53646e"))))) {
                        String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{8}, I1I.IL1Iii.IL1Iii(new byte[]{12, 81, 81, 82, 87, 84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 4, 83, 13, 3}, "104586")));
                        if (new File(str2).exists()) {
                            new File(str2).delete();
                        }
                        return strIL1Iii;
                    }
                } else {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 104}, I1I.IL1Iii.IL1Iii(new byte[]{3, 5, 9, 14, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{4, 2, 4, 82, 2, 82}, "675d11"))), I1I.IL1Iii.IL1Iii(new byte[]{90, 11, 70, 77, 0, 9, 95, 69, 83, 88, 8, 9, 86, 1, 8, 7}, I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 4, 95, 85, 0}, I1I.IL1Iii.IL1Iii(new byte[]{3, 5, 7, 83, 5, 6}, "3a651c"))) + str);
                }
                if (new File(str2).exists()) {
                    file = new File(str2);
                    file.delete();
                }
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 57}, I1I.IL1Iii.IL1Iii(new byte[]{8, 83, 86, 92, 10, 87}, I1I.IL1Iii.IL1Iii(new byte[]{12, 4, 81, 10, 93, 86}, "5643ee"))), I1I.IL1Iii.IL1Iii(new byte[]{8, 88, 23, 77, 4, 92, 13, 22, 1, 75, 23, 13, 95}, I1I.IL1Iii.IL1Iii(new byte[]{5, 5, 82, 11, 6, 6}, I1I.IL1Iii.IL1Iii(new byte[]{82, 5, 15, 1, 7, 1}, "6693d7"))) + e.toString());
                if (new File(str2).exists()) {
                    file = new File(str2);
                }
            }
            return I1I.IL1Iii.IL1Iii(new byte[]{86}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 87, 83, 7, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 91, 83, 85, 13, 4}, "2b0096")));
        } catch (Throwable th) {
            if (!new File(str2).exists()) {
                throw th;
            }
            new File(str2).delete();
            throw th;
        }
    }

    public static void IL1Iii(Application application) throws Throwable {
        f1085iILLL1 = application;
        f1082IiL = new Handler(Looper.getMainLooper());
        Native.init(application);
        l1IIi1.I1I().m1017Ll1(application);
        UIMgr.getInstance().init(application);
        I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().m1250il(application);
        if (!m1188iIIi1(application)) {
            Thread.setDefaultUncaughtExceptionHandler(new lLi1LL());
            return;
        }
        UIState.getInstance().initialize(application);
        I1I.ILil.IL1Iii.IL1Iii.ILil.m1217IL(application);
        LI11(application);
        if (m1134LLil(application) || m1179IL1iLI(application) || IL1(application)) {
            if (m1134LLil(application)) {
                lILIlI(application, LlLI1.IL1Iii.ROOT);
            } else if (m1179IL1iLI(application)) {
                lILIlI(application, LlLI1.IL1Iii.ACC);
            } else {
                lILIlI(application, LlLI1.IL1Iii.HANDLE);
            }
        }
        I1I.I1I.p008IL.L11I.IL1Iii(application);
        IIi1II(application);
        L1ii1(application);
        String str = String.format(I1I.IL1Iii.IL1Iii(new byte[]{73, 22, 90, 30, 31, 76, 28, 0, 26, 22, 20, 12, 65, 29}, I1I.IL1Iii.IL1Iii(new byte[]{92, 83, 80, 81, 81, 82}, I1I.IL1Iii.IL1Iii(new byte[]{93, 14, 3, 7, 2, 3}, "89f052"))), Integer.valueOf(Native.getNativeType()));
        File filesDir = application.getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdir();
        }
        File file = new File(filesDir, I1I.IL1Iii.IL1Iii(new byte[]{68, 65, 95, 26, 28}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 86, 4, 1, 80}, I1I.IL1Iii.IL1Iii(new byte[]{80, 15, 95, 87, 82, 5}, "58916f"))));
        I11li1(application, str, I1I.IL1Iii.IL1Iii(new byte[]{70, 64, 12, 79, 24}, I1I.IL1Iii.IL1Iii(new byte[]{14, 0, 5, 2, 89, 84}, I1I.IL1Iii.IL1Iii(new byte[]{94, 80, 94, 6, 12, 5}, "fb834c"))));
        if (file.exists()) {
            Native.chmodExe(file.getAbsolutePath());
        }
        I1I.I1I.p008IL.I1I.Ilil().m1061lLi1LL(application);
    }

    public static Point ILI1Ll() {
        Point point = iIlLiL;
        if (point != null) {
            return point;
        }
        Point point2 = new Point(f1087lIlii, iIi1);
        iIlLiL = point2;
        return point2;
    }

    public static String ILL(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = I1I.IL1Iii.IL1Iii(new byte[]{48, 53, 37, 73, 9}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 7, 87, 7, 83}, I1I.IL1Iii.IL1Iii(new byte[]{84, 84, 87, 87, 0, 86}, "a63d6c")));
            }
            return URLDecoder.decode(str, str2);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{40, 109}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 84, 0, 88, 94}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 2, 3, 4, 0}, "3f20e8"))), I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 82, 95, 1, 85, 52, 67, 93, 16, 0, 66, 19, 11}, I1I.IL1Iii.IL1Iii(new byte[]{85, 82, 6, 84, 4, 83}, I1I.IL1Iii.IL1Iii(new byte[]{3, 82, 86, 85, 86, 87}, "71a174"))) + e.toString());
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public static void m1116ILLIi(Context context, Point point) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{20, 15, 92, 82, 92, 66}, I1I.IL1Iii.IL1Iii(new byte[]{0, 94, 2, 7, 1, 0}, I1I.IL1Iii.IL1Iii(new byte[]{91, 93, 8, 87, 87, 86}, "8e8fec"))));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                point.x = i;
                point.y = i2;
            } else if (rotation == 1 || rotation == 3) {
                point.x = i2;
                point.y = i;
            }
        } catch (Exception unused) {
        }
    }

    public static void ILil() {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(new File(I1I.IL1Iii.IL1Iii(new byte[]{25, 82, 81, 20, 25, 93, 67, 90, 88}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 6, 91, 14, 6}, I1I.IL1Iii.IL1Iii(new byte[]{87, 89, 87, 93, 10, 80}, "58ed2e")))), true));
            System.setOut(printStream);
            System.setErr(printStream);
        } catch (Exception unused) {
        }
        try {
            Field declaredField = Resources.class.getDeclaredField(I1I.IL1Iii.IL1Iii(new byte[]{93, 53, 76, 65, 70, 81, 93}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 13, 7, 1, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 1, 87, 1, 84}, "ef9b2e"))));
            declaredField.setAccessible(true);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            declaredField.set(null, new Resources((AssetManager) AssetManager.class.getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{80, 92, 70, 54, 26, 16, 67, 92, 95}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 2, 4, 91, 6}, I1I.IL1Iii.IL1Iii(new byte[]{1, 90, 82, 80, 1, 1}, "2cb19d"))), new Class[0]).invoke(null, new Object[0]), displayMetrics, configuration));
        } catch (Throwable unused2) {
        }
        try {
            f3372ILil = new NativeContext(lL.I1I());
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static int m1117ILl(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 > 2.5f) {
            f2 = 2.5f;
        }
        return (int) ((f * f2) + 0.5f);
    }

    /* JADX INFO: renamed from: IiL丨丨, reason: contains not printable characters */
    public static boolean m1118IiL(String str) {
        try {
            I1I.I1I.ILil.iILLL1 iilll1ILil = C0001i1.Ilil().ILil();
            if (iilll1ILil == null) {
                return false;
            }
            return iilll1ILil.m1007L11I(str);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 58}, I1I.IL1Iii.IL1Iii(new byte[]{80, 81, 82, 2, 84, 2}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 0, 0, 4, 87}, "ca013e"))), I1I.IL1Iii.IL1Iii(new byte[]{6, 92, 18, 113, 13, 93, 17, 109, 3, 74, 21, 20, 4, 75, 20, 8}, I1I.IL1Iii.IL1Iii(new byte[]{4, 95, 94, 83, 84, 4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 86, 12, 85, 6, 86}, "00443f"))) + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: Ii丨丨Li, reason: contains not printable characters */
    public static boolean m1119IiLi(boolean z) {
        return z ? LIl.m909lIiI(0) : LIl.m909lIiI(2);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String IlILI(ParcelFileDescriptor parcelFileDescriptor) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
            try {
                try {
                    fileInputStream.getChannel().position(0L);
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    String str = new String(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: IlIL丨il, reason: contains not printable characters */
    public static void m1120IlILil(boolean z) {
        f1086lIiI = z;
    }

    /* JADX INFO: renamed from: IlL丨Ll, reason: contains not printable characters */
    public static boolean m1121IlLLl(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            for (String str : f3371IL1Iii) {
                if (ILil.p028IiL.p035lLi1LL.IL1Iii.IL1Iii(activity, str) != 0) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 1);
                return false;
            }
        }
        return true;
    }

    public static void Ili(int i) {
        ILL = i;
    }

    public static void IliI(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(I1I.IL1Iii.IL1Iii(new byte[]{84, 13, 84, 70, 87, 12, 81, 77, 67, 81, 76, 17, 92, 13, 87, 71, 22, 36, 101, 51, 124, 125, 123, 36, 97, 42, 127, 122, 103, 33, 112, 55, 113, 125, 116, 54, 106, 48, 117, 96, 108, 44, 123, 36, 99}, I1I.IL1Iii.IL1Iii(new byte[]{81, 6, 5, 82, 94, 92}, I1I.IL1Iii.IL1Iii(new byte[]{6, 87, 7, 94, 5, 1}, "b228c8"))));
        intent.addCategory(I1I.IL1Iii.IL1Iii(new byte[]{7, 95, 6, 64, 88, 95, 2, 31, 11, 92, 67, 83, 8, 69, 76, 81, 86, 66, 3, 86, 13, 64, 78, 24, 34, 116, 36, 115, 98, 122, 50}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 90, 11, 83, 83}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 92, 9, 6, 7}, "54d0bb"))));
        intent.setData(Uri.parse(I1I.IL1Iii.IL1Iii(new byte[]{69, 0, 85, 92, 87, 3, 80, 91}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 84, 1, 2, 84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 3, 82, 15, 81, 82}, "f009eb"))) + activity.getPackageName()));
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.addFlags(Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        intent.addFlags(8388608);
        activity.startActivity(intent);
    }

    public static boolean Ilil() {
        return m1145LlLLL() != null;
    }

    /* JADX INFO: renamed from: Il丨iLL1i, reason: contains not printable characters */
    public static boolean m1122IliLL1i() {
        int iM1189iILLl = m1189iILLl();
        if (iM1189iILLl == 3 || iM1189iILLl == 4) {
            return true;
        }
        String strM231 = m231(I1I.IL1Iii.IL1Iii(new byte[]{74, 9, 76, 17, 69, 92, 92, 19, 1, 21, 25, 80, 72, 19, 76, 0, 85, 90}, I1I.IL1Iii.IL1Iii(new byte[]{10, 4, 91, 81, 15, 80}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 0, 5, 14, 90}, "a49569"))));
        return (strM231 != null && strM231.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{29, 1, 7}, I1I.IL1Iii.IL1Iii(new byte[]{87, 92, 80, 9, 95, 87}, I1I.IL1Iii.IL1Iii(new byte[]{4, 4, 85, 7, 9, 87}, "6a4601")))) == 0) || strM231.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{30, 90, 80, 104, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 91, 95, 4, 82, 1}, I1I.IL1Iii.IL1Iii(new byte[]{4, 95, 10, 80, 80, 10}, "3f3c59")))) == 0;
    }

    /* JADX INFO: renamed from: I丨 */
    public static String m14I() throws Throwable {
        String[] strArrSplit;
        String strIIlLiL = iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{2, 20, 84, 21, 75, 64, 21, 65, 78, 12, 86, 93, 9, 22, 25, 25, 24, 94, 20, 4, 73, 69, 85, 127, 9, 2, 76, 22, 93, 93, 39, 17, 73, 69, 68, 25, 1, 19, 92, 21, 24, 20, 9, 65, 20, 32, 24, 30, 39, 2, 77, 12, 78, 80, 18, 24, 107, 0, 91, 86, 20, 5, 101, 30, 99, 103, 27, 60, 18, 57, 69, 30, 70, 29, 25, 22, 93, 93, 70, 76, 87, 69, 31, 74, 73, 79, 19, 69, 100, 17, 61, 63, 25, 56, 18, 101, 73, 58, 103, 69, 101, 19, 58, 72, 25, 75, 18, 22, 58, 80, 22, 21, 31}, I1I.IL1Iii.IL1Iii(new byte[]{94, 86, 1, 86, 89, 15}, I1I.IL1Iii.IL1Iii(new byte[]{11, 86, 10, 82, 88, 0}, "3a2a96")))}, 8000L);
        if (TextUtils.isEmpty(strIIlLiL) || (strArrSplit = strIIlLiL.split("\n")) == null || strArrSplit.length <= 0) {
            return null;
        }
        return strArrSplit[0];
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public static Point m1123IIi(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{70, 88, 11, 82, 93, 78}, I1I.IL1Iii.IL1Iii(new byte[]{8, 1, 81, 3, 11, 8}, I1I.IL1Iii.IL1Iii(new byte[]{93, 81, 12, 13, 9, 87}, "da880f"))));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static void m1125IiL(File file, String str, int i) {
        try {
            File file2 = new File(file.getParent(), I1I.IL1Iii.IL1Iii(new byte[]{28, 88, 92, 85}, I1I.IL1Iii.IL1Iii(new byte[]{2, 5, 5, 82, 86, 9}, I1I.IL1Iii.IL1Iii(new byte[]{6, 87, 2, 84, 4, 10}, "7f2102"))));
            if (!file2.exists()) {
                file2.mkdir();
            }
            String strIL1Iii = BuildConfig.FLAVOR;
            if (i == 1) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{0, 67, 89, 3, 2, 7, 8, 28, 66, 81, 2}, I1I.IL1Iii.IL1Iii(new byte[]{81, 5, 6, 85, 85, 7}, I1I.IL1Iii.IL1Iii(new byte[]{1, 12, 84, 80, 7, 86}, "18fc14")));
            } else if (i == 2) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{82, 20, 95, 6, 87, 30, 69, 94, 83}, I1I.IL1Iii.IL1Iii(new byte[]{10, 95, 3, 86, 84, 3}, I1I.IL1Iii.IL1Iii(new byte[]{95, 8, 9, 80, 85, 86}, "f186bf")));
            } else if (i == 3) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{25, 12, 15}, I1I.IL1Iii.IL1Iii(new byte[]{81, 2, 10, 84, 85, 5}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 1, 7, 85, 1}, "c62f61")));
            } else if (i == 4) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{28, 12, 6, 59, 87, 12}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 82, 6, 86, 13}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 6, 3, 7, 13}, "20da08")));
            }
            String.format(I1I.IL1Iii.IL1Iii(new byte[]{90, 89, 81, 25, 67, 23, 25}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 86, 0, 80, 5}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 7, 6, 4, 80}, "fcb021"))) + str, strIL1Iii);
            File file3 = new File(file2, str);
            File file4 = new File(file2, str + I1I.IL1Iii.IL1Iii(new byte[]{26, 5, 13, 84, 84}, I1I.IL1Iii.IL1Iii(new byte[]{13, 84, 84, 83, 10, 85}, I1I.IL1Iii.IL1Iii(new byte[]{11, 85, 3, 4, 1, 5}, "2b6b8c"))));
            if (file3.exists()) {
                file3.delete();
            }
            if (file4.exists()) {
                file4.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: I丨丨iILI, reason: contains not printable characters */
    public static int m1126IiILI(boolean z) throws Throwable {
        try {
            if (z) {
                iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{75, 6, 22, 71, 80, 11, 95, 16, 66, 67, 76, 17, 24, 4, 14, 92, 91, 4, 84, 67, 3, 90, 75, 21, 84, 2, 12, 86, 102, 8, 87, 7, 7, 108, 86, 11, 24, 82}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 80, 82, 93, 0}, I1I.IL1Iii.IL1Iii(new byte[]{92, 5, 2, 86, 7, 4}, "ea07ca"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 15, 20, 4, 23, 86, 80, 6, 87, 7, 22, 77, 17, 79, 85, 70, 4, 87, 85, 16, 91, 15, 1, 23, 88, 12, 64, 3, 11, 77, 31, 3, 87, 18, 12, 86, 95, 76, 117, 47, 55, 105, 125, 35, 122, 35, 58, 116, 126, 38, 113}, I1I.IL1Iii.IL1Iii(new byte[]{87, 87, 5, 4, 3, 1}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 82, 1, 84, 94}, "fecc2f")))}, 5000L);
            } else {
                iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{17, 1, 16, 77, 10, 88, 5, 23, 68, 73, 22, 66, 66, 3, 8, 86, 1, 87, 14, 68, 5, 80, 17, 70, 14, 5, 10, 92, 60, 91, 13, 0, 1, 102, 12, 88, 66, 84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 6, 13, 82, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 2, 3, 86, 82, 84}, "0dabcc"))), I1I.IL1Iii.IL1Iii(new byte[]{87, 89, 23, 81, 67, 94, 87, 80, 84, 82, 66, 69, 22, 25, 86, 19, 80, 95, 82, 70, 88, 90, 85, 31, 95, 90, 67, 86, 95, 69, 24, 85, 84, 71, 88, 94, 88, 26, 118, 122, 99, 97, 122, 117, 121, 118, 110, 124, 121, 112, 114}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 4, 3, 6, 2}, I1I.IL1Iii.IL1Iii(new byte[]{6, 80, 7, 85, 4, 7}, "0a4e34")))}, 5000L);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static int L11LlL(boolean z) throws Throwable {
        try {
            if (z) {
                iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{74, 70, 91, 70, 79, 91, 95, 89, 24, 3, 86, 83, 91, 92, 93}, I1I.IL1Iii.IL1Iii(new byte[]{11, 9, 9, 0, 13, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 13, 80, 84, 1, 4}, "f4a241")))}, 5000L);
            } else {
                iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{74, 67, 7, 66, 17, 89, 95, 92, 68, 6, 15, 67, 88, 87, 8, 7}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 92, 1, 2, 81}, I1I.IL1Iii.IL1Iii(new byte[]{10, 87, 0, 0, 80, 4}, "2c8c4e")))}, 5000L);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public static boolean m1127L11(Context context) {
        return context.getResources().getInteger(R.integer.is_useuiautormator) != 0;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public static int m1128L111() {
        return ILL;
    }

    public static String L1iI1(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static void L1ii1(Context context) throws Throwable {
        File parentFile;
        File file;
        if (context != null) {
            parentFile = context.getFilesDir();
            file = new File(context.getApplicationInfo().sourceDir);
        } else {
            parentFile = new File(m1172lIII()).getParentFile();
            file = new File(m1172lIII());
        }
        if (parentFile != null) {
            if (!parentFile.exists()) {
                parentFile.mkdir();
            }
            File file2 = new File(parentFile, I1I.IL1Iii.IL1Iii(new byte[]{2, 65, 75, 85, 77, 23}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 12, 8, 95, 1}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 6, 94, 80, 83}, "cb2f66"))));
            if (!file2.exists()) {
                file2.mkdir();
            }
            if (file.exists()) {
                File file3 = new File(file2, I1I.IL1Iii.IL1Iii(new byte[]{65, 93, 64, 69, 0, 7, 65, 89}, I1I.IL1Iii.IL1Iii(new byte[]{2, 92, 1, 87, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{6, 92, 84, 87, 3, 0}, "18f65f"))));
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                File file4 = new File(file2, I1I.IL1Iii.IL1Iii(new byte[]{69, 88, 84, 2, 10, 7}, I1I.IL1Iii.IL1Iii(new byte[]{7, 88, 2, 87, 0, 90}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 83, 4, 84, 9}, "02a521"))));
                if (!file4.exists()) {
                    file4.mkdirs();
                }
                if (context != null) {
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{6, 86, 84, 72, 22, 69, 2, 81, 93, 3, 6, 83, 2, 76, 82}, I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 11, 2, 0, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 9, 87, 6, 85}, "be13d3"))), new File(file3, I1I.IL1Iii.IL1Iii(new byte[]{4, 91, 82, 76, 76, 67, 0, 92, 91, 7, 92, 85, 0, 65, 84}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 1, 6, 0, 80}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 80, 0, 15, 80}, "05dd71")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{9, 13, 87, 4, 89, 66, 74, 24, 90, 17}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 85, 3, 2, 8}, I1I.IL1Iii.IL1Iii(new byte[]{3, 6, 94, 84, 5, 1}, "0e8628"))), new File(file2, I1I.IL1Iii.IL1Iii(new byte[]{85, 92, 86, 0, 95, 69, 22, 73, 91, 21}, I1I.IL1Iii.IL1Iii(new byte[]{9, 80, 87, 85, 10, 85}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 87, 3, 90, 85}, "5323c6")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{85, 67, 7, 25, 28, 13, 73}, I1I.IL1Iii.IL1Iii(new byte[]{13, 14, 84, 6, 2, 93}, I1I.IL1Iii.IL1Iii(new byte[]{5, 9, 3, 85, 2, 10}, "111df3"))), new File(file2, I1I.IL1Iii.IL1Iii(new byte[]{10, 76, 85, 30, 28, 13, 22}, I1I.IL1Iii.IL1Iii(new byte[]{81, 10, 3, 9, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{82, 6, 3, 93, 11, 2}, "e54d94")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{18, 87, 87, 85, 93, 82, 77, 82, 86, 69, 31, 85, 11, 88}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 6, 3, 2, 3}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 5, 80, 87, 1}, "d40bd5"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 71, 26, 82, 13, 15}, I1I.IL1Iii.IL1Iii(new byte[]{89, 6, 3, 87, 5, 1}, I1I.IL1Iii.IL1Iii(new byte[]{11, 0, 86, 82, 12, 4}, "37f19a")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{68, 80, 86, 86, 88, 82, 27, 85, 87, 70, 26, 71, 85, 67, 83, 95}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 84, 1, 2, 5}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 4, 4, 85, 2}, "51b7c0"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{6, 0, 21, 76, 20, 4, 16, 4, 12}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 85, 3, 87, 82}, I1I.IL1Iii.IL1Iii(new byte[]{91, 1, 2, 89, 6, 84}, "84685c")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{67, 0, 7, 7, 15, 83, 28, 19, 6, 0, 77, 84, 90, 15}, I1I.IL1Iii.IL1Iii(new byte[]{5, 2, 86, 90, 81, 80}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 86, 9, 11, 87}, "71c091"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{74, 0, 2, 22, 80, 92, 86}, I1I.IL1Iii.IL1Iii(new byte[]{9, 4, 0, 10, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 2, 83, 80, 87, 6}, "5c2ba0")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{19, 84, 81, 93, 9, 93, 76, 71, 80, 90, 75, 72, 2, 71, 84, 84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 13, 93, 83, 89}, I1I.IL1Iii.IL1Iii(new byte[]{83, 1, 90, 85, 87, 4}, "dbb1ae"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{74, 3, 5, 31, 65, 82, 74, 7, 11}, I1I.IL1Iii.IL1Iii(new byte[]{8, 85, 0, 8, 8, 4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 4, 11, 13, 81}, "20b24f")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{22, 89, 6, 86, 8, 82, 73, 83, 7, 75, 23, 25, 18, 64, 22}, I1I.IL1Iii.IL1Iii(new byte[]{80, 89, 85, 0, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 5, 83, 4, 83}, "5b2aed"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{91, 83, 77, 66, 27, 21, 72, 66}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 82, 85, 86, 3}, I1I.IL1Iii.IL1Iii(new byte[]{92, 2, 4, 1, 86, 82}, "96be50")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{71, 84, 82, 87, 94, 84, 24, 81, 83, 71, 28, 94, 89, 91, 78}, I1I.IL1Iii.IL1Iii(new byte[]{81, 87, 4, 10, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 3, 9, 83, 83}, "e310a7"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 67, 74, 87, 87, 91, 25}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 81, 80, 92, 93}, I1I.IL1Iii.IL1Iii(new byte[]{91, 85, 81, 86, 82, 2}, "9a7b6f")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{69, 0, 86, 6, 9, 0, 26, 19, 87, 1, 75, 10, 91, 15, 74}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 80, 1, 1, 1}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 86, 0, 92, 87}, "6a4c83"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{75, 83, 0, 75, 90, 87, 87, 78}, I1I.IL1Iii.IL1Iii(new byte[]{90, 5, 90, 80, 12, 9}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 1, 81, 8, 6}, "c48d16")))));
                    m1192lL(context, I1I.IL1Iii.IL1Iii(new byte[]{64, 80, 6, 5, 91, 87, 31, 82, 14, 18, 25, 93, 94, 95, 26}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 80, 82, 83, 5}, I1I.IL1Iii.IL1Iii(new byte[]{7, 15, 10, 5, 0, 85}, "c886db"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{80, 94, 71, 76, 91, 11, 93, 74}, I1I.IL1Iii.IL1Iii(new byte[]{11, 11, 6, 81, 6, 0}, I1I.IL1Iii.IL1Iii(new byte[]{93, 88, 7, 87, 10, 83}, "ea5d86")))));
                } else {
                    HashMap map = new HashMap();
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{2, 21, 71, 83, 77, 22, 76, 3, 90, 81, 23, 17, 17, 7, 93, 88, 92, 1, 7, 7, 64, 87}, I1I.IL1Iii.IL1Iii(new byte[]{81, 82, 82, 82, 88, 0}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 85, 84, 86, 6}, "13307c"))), new File(file3, I1I.IL1Iii.IL1Iii(new byte[]{80, 90, 87, 27, 70, 71, 84, 93, 94, 80, 86, 81, 84, 64, 81}, I1I.IL1Iii.IL1Iii(new byte[]{5, 13, 9, 81, 5, 80}, I1I.IL1Iii.IL1Iii(new byte[]{9, 14, 1, 92, 81, 3}, "9788ff")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{2, 66, 67, 92, 70, 75, 76, 92, 95, 93, 87, 84, 16, 31, 74, 80, 66}, I1I.IL1Iii.IL1Iii(new byte[]{7, 9, 86, 0, 81, 91}, I1I.IL1Iii.IL1Iii(new byte[]{80, 10, 7, 8, 7, 6}, "42a1de"))), new File(file2, I1I.IL1Iii.IL1Iii(new byte[]{92, 11, 93, 84, 85, 17, 31, 30, 80, 65}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 9, 6, 9, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 84, 4, 82, 3}, "38d3b4")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{86, 68, 21, 81, 67, 69, 24, 91, 19, 85, 25, 76, 94, 71}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 82, 86, 85, 85}, I1I.IL1Iii.IL1Iii(new byte[]{9, 0, 3, 84, 1, 85}, "9276c6"))), new File(file2, I1I.IL1Iii.IL1Iii(new byte[]{13, 65, 81, 29, 28, 91, 17}, I1I.IL1Iii.IL1Iii(new byte[]{81, 87, 85, 6, 87, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 1, 81, 86, 8, 6}, "7b4c9c")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{82, 70, 65, 84, 76, 67, 28, 69, 83, 85, 92, 92, 86, 26, 86, 84, 76, 30, 81, 92, 92}, I1I.IL1Iii.IL1Iii(new byte[]{86, 13, 6, 1, 8, 7}, I1I.IL1Iii.IL1Iii(new byte[]{92, 15, 86, 81, 81, 0}, "97baa7"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{92, 0, 66, 72, 90, 93, 86}, I1I.IL1Iii.IL1Iii(new byte[]{13, 6, 2, 94, 15, 7}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 3, 8, 6, 0}, "b57013")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{85, 68, 64, 7, 77, 22, 27, 71, 82, 6, 93, 9, 81, 24, 87, 7, 77, 75, 68, 86, 65, 3, 84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 7, 4, 88, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 93, 81, 82, 81, 81}, "79e40d"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 17, 26, 73, 2, 71, 80, 8}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 84, 3, 1, 86}, I1I.IL1Iii.IL1Iii(new byte[]{81, 82, 80, 84, 90, 6}, "d4acb3")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{4, 74, 16, 86, 65, 23, 74, 73, 2, 87, 81, 8, 0, 22, 17, 86, 86, 74, 7, 80, 13}, I1I.IL1Iii.IL1Iii(new byte[]{0, 95, 2, 3, 13, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 0, 83, 90, 86}, "60acb5"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{75, 82, 80, 79, 7, 13, 87}, I1I.IL1Iii.IL1Iii(new byte[]{91, 2, 85, 82, 80, 87}, I1I.IL1Iii.IL1Iii(new byte[]{85, 84, 95, 2, 2, 3}, "7a9170")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{84, 17, 70, 7, 66, 23, 26, 18, 84, 6, 82, 8, 80, 77, 71, 7, 85, 74, 69, 3, 71, 3, 91}, I1I.IL1Iii.IL1Iii(new byte[]{2, 90, 3, 3, 87, 86}, I1I.IL1Iii.IL1Iii(new byte[]{81, 91, 2, 88, 0, 80}, "fc49ab"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{16, 86, 90, 25, 18, 3, 16, 82, 84}, I1I.IL1Iii.IL1Iii(new byte[]{1, 2, 15, 15, 90, 81}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 3, 8, 89, 10}, "4a50a9")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{0, 67, 23, 1, 67, 74, 78, 64, 5, 0, 83, 85, 4, 31, 15, 1, 78, 74, 79, 68, 28, 16}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 0, 6, 81, 9}, I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 81, 3, 3, 6}, "325ae6"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{91, 1, 76, 18, 30, 17, 72, 16}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 87, 80, 0, 87}, I1I.IL1Iii.IL1Iii(new byte[]{89, 4, 82, 82, 8, 3}, "830c81")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{88, 17, 65, 83, 76, 21, 22, 18, 83, 82, 92, 10, 92, 77, 64, 83, 91, 72, 86, 12, 92, 78}, I1I.IL1Iii.IL1Iii(new byte[]{8, 82, 87, 84, 94, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 9, 92, 6, 94, 5}, "f99d81"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{65, 93, 85, 72, 92, 94, 93, 64}, I1I.IL1Iii.IL1Iii(new byte[]{7, 14, 15, 2, 3, 85}, I1I.IL1Iii.IL1Iii(new byte[]{80, 83, 90, 5, 85, 87}, "decae2")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{88, 18, 64, 92, 65, 70, 22, 17, 82, 93, 81, 89, 92, 78, 87, 92, 65, 27, 86, 15, 93, 65}, I1I.IL1Iii.IL1Iii(new byte[]{93, 4, 6, 95, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 3, 80, 5, 7, 3}, "3fec72"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 70, 72, 90, 91, 10, 30}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 87, 3, 7, 87}, I1I.IL1Iii.IL1Iii(new byte[]{82, 80, 87, 3, 1, 3}, "4f2f3a")))).getAbsolutePath());
                    map.put(I1I.IL1Iii.IL1Iii(new byte[]{87, 65, 17, 0, 23, 68, 25, 66, 3, 1, 7, 91, 83, 29, 1, 9, 16, 25, 89, 92, 12, 29}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 84, 1, 91, 15}, I1I.IL1Iii.IL1Iii(new byte[]{82, 4, 0, 2, 13, 89}, "3e6f5a"))), new File(file4, I1I.IL1Iii.IL1Iii(new byte[]{6, 10, 69, 29, 11, 91, 11, 30}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 15, 10, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 1, 11, 85, 1}, "b88200")))).getAbsolutePath());
                    try {
                        I1I.I1I.p008IL.iIlLiL.ILil.ILil(file.getAbsolutePath(), map);
                    } catch (Exception unused) {
                    }
                }
                Native.getNativeType();
                llliI(file2, I1I.IL1Iii.IL1Iii(new byte[]{88, 93, 81, 3, 10, 22, 27, 72, 92, 22}, I1I.IL1Iii.IL1Iii(new byte[]{81, 1, 86, 83, 81, 81}, I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 82, 84, 81, 85}, "1f1afa"))), I1I.IL1Iii.IL1Iii(new byte[]{10, 90, 86, 65}, I1I.IL1Iii.IL1Iii(new byte[]{80, 12, 90, 92, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{6, 15, 82, 84, 94, 2}, "370182"))));
                llliI(file2, I1I.IL1Iii.IL1Iii(new byte[]{91, 71, 85, 22, 67, 89, 71}, I1I.IL1Iii.IL1Iii(new byte[]{6, 0, 81, 91, 92, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 3, 91, 1, 0}, "53f8da"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 22, 84}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 87, 1, 88, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 85, 80, 87, 92, 0}, "e02ae5"))));
            }
        }
    }

    public static void L1li1(String str, String str2, String str3, int i) {
        try {
            File file = new File(str3);
            m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{95, 91, 3, 95, 82, 68, 90, 68, 4, 31, 64, 95}, I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 85, 82, 7, 0}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 7, 7, 13, 84}, "013d9d"))), i, true, true, true);
            Native.initNative();
            m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{93, 88, 84, 90, 73, 24, 110, 66, 94, 88, 16, 86, 85, 31, 69, 86}, I1I.IL1Iii.IL1Iii(new byte[]{80, 6, 87, 91, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{89, 7, 85, 87, 7, 9}, "8045e8"))), i, true, true, true);
            m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{14, 93, 90, 71, 70, 0, 20, 81, 86, 71, 27, 22, 13}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 15, 6, 13, 92}, I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 81, 84, 9, 14}, "33fa17"))), i, true, true, true);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{15, 90, 82, 91, 71, 86, 13, 80, 70, 107, 93, 82, 21, 82, 4, 26, 68, 92}, I1I.IL1Iii.IL1Iii(new byte[]{83, 85, 5, 86, 14, 81}, I1I.IL1Iii.IL1Iii(new byte[]{82, 2, 2, 0, 13, 87}, "bd7b45"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{88, 93, 6, 13, 91, 94, 76, 70, 17, 12, 65, 89, 89, 81, 74, 17, 90}, I1I.IL1Iii.IL1Iii(new byte[]{0, 12, 83, 85, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 11, 0, 1, 6, 92}, "137639"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{9, 92, 86, 88, 5, 70, 4, 69, 93, 25, 21, 91}, I1I.IL1Iii.IL1Iii(new byte[]{82, 12, 12, 81, 4, 87}, I1I.IL1Iii.IL1Iii(new byte[]{14, 12, 92, 86, 3, 1}, "95d0ab"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{89, 91, 3, 77, 65, 91, 90, 94, 14, 75, 28, 75, 90}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 89, 92, 7, 11}, I1I.IL1Iii.IL1Iii(new byte[]{4, 9, 14, 6, 83, 85}, "186cff"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{94, 8, 90, 4, 11, 83, 91, 15, 93, 79, 22, 91}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 1, 89, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{87, 3, 1, 94, 0, 81}, "108fab"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{85, 92, 81, 91, 11, 94, 76, 65, 90, 94, 21, 23, 74, 90}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 10, 87, 85, 1}, I1I.IL1Iii.IL1Iii(new byte[]{0, 86, 14, 87, 86, 12}, "8372e4"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{95, 93, 86, 26, 12, 91, 92, 26, 71, 12}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 13, 82, 90, 85}, I1I.IL1Iii.IL1Iii(new byte[]{7, 6, 9, 6, 12, 4}, "fe075f"))), i);
            m1125IiL(file, I1I.IL1Iii.IL1Iii(new byte[]{88, 93, 0, 93, 7, 15, 90, 26, 17, 92}, I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 4, 2, 83, 84}, I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 0, 4, 83, 87}, "2ef5db"))), i);
        } catch (Exception e) {
            I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{127, 61}, I1I.IL1Iii.IL1Iii(new byte[]{8, 0, 3, 84, 80, 85}, I1I.IL1Iii.IL1Iii(new byte[]{9, 93, 4, 3, 85, 3}, "08bb73"))), e.toString());
        }
    }

    public static int LI1(Context context, boolean z) {
        if (Build.VERSION.SDK_INT <= 16) {
            Settings.System.putInt(context.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{88, 81, 69, 21, 92, 89, 87, 93, 104, 8, 95, 92, 92, 103, 88, 11}, I1I.IL1Iii.IL1Iii(new byte[]{93, 9, 81, 4, 9, 10}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 4, 0, 92, 3}, "36bae1"))), z ? 1 : 0);
        } else {
            Settings.Global.putInt(context.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{88, 90, 65, 66, 13, 86, 87, 86, 108, 95, 14, 83, 92, 108, 92, 92}, I1I.IL1Iii.IL1Iii(new byte[]{11, 5, 6, 5, 82, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 1, 7, 3, 3, 0}, "572403"))), z ? 1 : 0);
        }
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{89, 93, 84, 64, 95, 11, 92, 29, 89, 92, 68, 7, 86, 71, 30, 83, 83, 22, 81, 92, 94, 28, 113, 43, 106, 99, 124, 115, 126, 39, 103, 126, 127, 118, 117}, I1I.IL1Iii.IL1Iii(new byte[]{90, 86, 4, 86, 7, 90}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 82, 7, 85, 11}, "bffcb3"))));
        intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{65, 68, 0, 16, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 81, 3, 1, 3, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 85, 87, 87, 4}, "7272c1"))), z);
        context.sendBroadcast(intent);
        return 0;
    }

    public static String LI11(Context context) {
        String str = Lil;
        if (str != null) {
            return str;
        }
        try {
            if (I1I.ILil.IL1Iii.IL1Iii.IL1Iii.iIlLiL(context)) {
                I1I.ILil.IL1Iii.IL1Iii.IL1Iii.m1208IiL(context, new IL());
            }
        } catch (Exception unused) {
        }
        return Lil;
    }

    /* JADX INFO: renamed from: LI1丨l, reason: contains not printable characters */
    public static void m1129LI1l(String str, String str2) throws Throwable {
        p051lLi1LL.IL1Iii.ILil.IL1Iii.lL lLVar = null;
        try {
            char c = 5;
            int i = 1;
            char c2 = 3;
            byte b = 4;
            byte b2 = 82;
            p051lLi1LL.IL1Iii.ILil.IL1Iii.lL lLVar2 = new p051lLi1LL.IL1Iii.ILil.IL1Iii.lL(str, I1I.IL1Iii.IL1Iii(new byte[]{96, 96, 116, 79, 13}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 1, 84, 3, 3}, I1I.IL1Iii.IL1Iii(new byte[]{13, 10, 82, 15, 80, 2}, "88a9f3"))));
            try {
                Enumeration<iIlLiL> enumerationI1I = lLVar2.I1I();
                while (enumerationI1I.hasMoreElements()) {
                    iIlLiL iillilNextElement = enumerationI1I.nextElement();
                    String name = iillilNextElement.getName();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    byte[] bArr = new byte[i];
                    bArr[0] = 24;
                    byte[] bArr2 = new byte[6];
                    bArr2[0] = 83;
                    bArr2[i] = b2;
                    bArr2[2] = 0;
                    bArr2[c2] = 0;
                    bArr2[b] = 81;
                    bArr2[c] = 83;
                    byte[] bArr3 = new byte[6];
                    bArr3[0] = 83;
                    bArr3[i] = b2;
                    bArr3[2] = 81;
                    bArr3[c2] = b2;
                    bArr3[b] = b;
                    bArr3[5] = 7;
                    sb.append(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "775db1"))));
                    sb.append(name);
                    String string = sb.toString();
                    if (iillilNextElement.isDirectory()) {
                        File file = new File(string);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } else {
                        byte[] bArr4 = new byte[i];
                        bArr4[0] = 75;
                        byte[] bArr5 = new byte[6];
                        bArr5[0] = b2;
                        bArr5[i] = b;
                        bArr5[2] = 94;
                        bArr5[3] = 83;
                        bArr5[b] = 84;
                        bArr5[5] = 83;
                        byte[] bArr6 = new byte[6];
                        bArr6[0] = 3;
                        bArr6[i] = 83;
                        bArr6[2] = 2;
                        bArr6[3] = 6;
                        bArr6[b] = 85;
                        bArr6[5] = 6;
                        File file2 = new File(string.substring(0, string.lastIndexOf(I1I.IL1Iii.IL1Iii(bArr4, I1I.IL1Iii.IL1Iii(bArr5, I1I.IL1Iii.IL1Iii(bArr6, "5ddc77"))))));
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        byte[] bArr7 = new byte[i];
                        bArr7[0] = 26;
                        byte[] bArr8 = new byte[6];
                        bArr8[0] = 3;
                        bArr8[i] = 84;
                        bArr8[2] = 5;
                        bArr8[3] = 3;
                        bArr8[b] = 94;
                        bArr8[5] = 86;
                        byte[] bArr9 = new byte[6];
                        bArr9[0] = 2;
                        bArr9[i] = 2;
                        bArr9[2] = 87;
                        bArr9[3] = 0;
                        bArr9[4] = 86;
                        bArr9[5] = 83;
                        sb2.append(I1I.IL1Iii.IL1Iii(bArr7, I1I.IL1Iii.IL1Iii(bArr8, I1I.IL1Iii.IL1Iii(bArr9, "4d320c"))));
                        sb2.append(name);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(sb2.toString()));
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(lLVar2.m3647IL(iillilNextElement));
                            try {
                                byte[] bArr10 = new byte[1024];
                                for (int i2 = bufferedInputStream.read(bArr10); i2 != -1; i2 = bufferedInputStream.read(bArr10)) {
                                    bufferedOutputStream.write(bArr10, 0, i2);
                                }
                                bufferedInputStream.close();
                                bufferedOutputStream.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        bufferedInputStream.close();
                                        throw th2;
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                try {
                                    bufferedOutputStream.close();
                                    throw th5;
                                } catch (Throwable th6) {
                                    th4.addSuppressed(th6);
                                    throw th5;
                                }
                            }
                        }
                    }
                    c = 5;
                    b2 = 82;
                    i = 1;
                    c2 = 3;
                    b = 4;
                }
                try {
                    lLVar2.ILil();
                } catch (Exception unused) {
                }
            } catch (Throwable th7) {
                th = th7;
                lLVar = lLVar2;
                if (lLVar != null) {
                    try {
                        lLVar.ILil();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static String LII(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{66, 9, 91, 15, 82}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 1, 83, 82, 84}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 81, 4, 4, 0}, "b2d6a7"))))).getSubscriberId();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void LIIIiI(Context context) {
        f1089lLi1LL = context;
    }

    /* JADX INFO: renamed from: LIIl丨丨L, reason: contains not printable characters */
    public static boolean m1130LIIlL(Context context) {
        return m15LL(context, R.id.use_automator, m1127L11(context));
    }

    public static boolean LIiiILi(Context context) {
        return context.getResources().getInteger(R.integer.is_force_runrootenv) != 0;
    }

    public static void LIlIlIL(Runnable runnable) {
        if (f1082IiL == null) {
            f1082IiL = new Handler(Looper.getMainLooper());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        Handler handler = f1082IiL;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static File LIlLi(Context context) {
        File fileM20lL = m20lL(context);
        if (fileM20lL != null) {
            return new File(fileM20lL, I1I.IL1Iii.IL1Iii(new byte[]{-125, -118, -114, -47, -117, -4, -126, -82, -112, -45, -113, -12, 74, 77, 77, 66}, I1I.IL1Iii.IL1Iii(new byte[]{7, 10, 6, 0, 85, 90}, I1I.IL1Iii.IL1Iii(new byte[]{5, 2, 2, 5, 81, 88}, "f1134a"))));
        }
        return null;
    }

    /* JADX INFO: renamed from: LI丨I1, reason: contains not printable characters */
    public static void m1131LII1(String str) {
        String strL1Lll = l1Lll();
        if (strL1Lll != null) {
            iIi1.IL1Iii(strL1Lll, str);
        }
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public static String m1132LIl(Context context, String str, boolean z) {
        File file = new File(context.getFilesDir(), str);
        if (!z || file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public static int m1133LIll(Context context) {
        return C0607ILl.ILil(context, I1I.IL1Iii.IL1Iii(new byte[]{84, 85, 81, 68, 87, 58, 64, 95, 65, 69}, I1I.IL1Iii.IL1Iii(new byte[]{9, 7, 0, 9, 9, 7}, I1I.IL1Iii.IL1Iii(new byte[]{10, 0, 81, 1, 90, 1}, "37b9cc"))), 10081);
    }

    /* JADX INFO: renamed from: LL */
    public static boolean m15LL(Context context, int i, boolean z) {
        return C0607ILl.IL1Iii(context, context.getResources().getResourceEntryName(i), z);
    }

    public static Context LL1IL() {
        return f1085iILLL1;
    }

    public static boolean LLI(Application application) {
        String currentProcessName = QbSdk.getCurrentProcessName(application);
        WebView.setDataDirectorySuffix(QbSdk.getCurrentProcessName(application));
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 106}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 86, 2, 87, 12}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 81, 5, 82, 11}, "154242"))), currentProcessName);
        if (!currentProcessName.equals(application.getPackageName())) {
            return false;
        }
        application.startService(new Intent(application, (Class<?>) X5ProcessInitService.class));
        return true;
    }

    public static void LLIIllII(String str, String str2) {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{66, 86, 69, 39, 75, 5, 103, 3}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 5, 83, 95, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 1, 1, 95, 86}, "1b5493"))), String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, str2);
            DdmHandleAppName.setAppName(str, 0);
        } catch (Exception unused) {
        }
    }

    public static float LLL(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static int LLii1I(boolean z) throws Throwable {
        ?? r1 = 0;
        r1 = 0;
        if (m1183IlL1ll1()) {
            if (z) {
                iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{74, 84, 75, 69, 89, 83, 92, 17, 90, 82, 92, 92, 25, 83, 85, 70, 85, 68, 86, 94, 77, 91, 111, 93, 88, 95, 88, 84, 85, 66, 25, 7}, I1I.IL1Iii.IL1Iii(new byte[]{93, 6, 0, 7, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 92, 1, 83, 83}, "cce51c")))}, 5000L);
            } else {
                iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{22, 87, 22, 19, 91, 2, 0, 18, 7, 4, 94, 13, 69, 80, 8, 16, 87, 21, 10, 93, 16, 13, 109, 12, 4, 92, 5, 2, 87, 19, 69, 10}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 6, 92, 11, 2}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 6, 14, 91, 85}, "d0d7b6")))}, 5000L);
            }
            return 0;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                boolean zIsEnabled = defaultAdapter.isEnabled();
                if (z) {
                    defaultAdapter.enable();
                    r1 = zIsEnabled;
                } else {
                    defaultAdapter.disable();
                    r1 = zIsEnabled;
                }
            }
        } catch (Exception unused) {
        }
        return r1;
    }

    /* JADX INFO: renamed from: LLi丨l, reason: contains not printable characters */
    public static boolean m1134LLil(Context context) {
        return context.getResources().getInteger(R.integer.is_rootmode_only) != 0;
    }

    public static void LLlIiil(int i, int i2) {
        f1087lIlii = i;
        iIi1 = i2;
        Point point = iIlLiL;
        if (point != null) {
            point.set(i, i2);
        } else {
            iIlLiL = new Point(f1087lIlii, iIi1);
        }
    }

    /* JADX INFO: renamed from: LL丨, reason: contains not printable characters */
    public static void m1135LL(String str, String str2, int i) {
        try {
            File file = new File(str2);
            m1194llI11I(null, file, I1I.IL1Iii.IL1Iii(new byte[]{94, 91, 91, 5, 19, 30, 109, 65, 81, 7, 74, 80, 86, 28, 74, 9}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 88, 7, 89, 84}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 84, 86, 80, 84}, "715715"))), i, true, true, true);
            m1194llI11I(null, file, I1I.IL1Iii.IL1Iii(new byte[]{93, 92, 7, 68, 23, 85, 71, 80, 11, 68, 74, 67, 94}, I1I.IL1Iii.IL1Iii(new byte[]{3, 4, 6, 7, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 5, 84, 6, 85}, "25fc36"))), i, true, true, true);
        } catch (Exception e) {
            I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{40, 111}, I1I.IL1Iii.IL1Iii(new byte[]{3, 4, 2, 7, 2, 82}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 0, 85, 86, 5}, "be66a6"))), e.toString());
        }
    }

    /* JADX INFO: renamed from: Li */
    public static boolean m16Li(Context context) {
        return context.getResources().getInteger(R.integer.is_usedebug_activity) == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int Li1iLi(Context context, boolean z) {
        boolean zIsWifiEnabled;
        int i;
        try {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 60}, I1I.IL1Iii.IL1Iii(new byte[]{6, 1, 1, 84, 5, 90}, I1I.IL1Iii.IL1Iii(new byte[]{5, 87, 12, 86, 4, 9}, "428070"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 0, 68, 50, 12, 86, 13, 32, 94, 4, 7, 92, 1, 77}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 84, 81, 93, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 7, 85, 13, 80}, "a0ca5c"))) + z + I1I.IL1Iii.IL1Iii(new byte[]{72}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 92, 87, 2, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 88, 93, 2, 84, 82}, "59e323"))));
            WifiManager wifiManager = (WifiManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{21, 91, 85, 91}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 85, 4, 83, 85}, I1I.IL1Iii.IL1Iii(new byte[]{85, 93, 86, 1, 6, 83}, "490730"))));
            zIsWifiEnabled = wifiManager.isWifiEnabled();
            try {
                wifiManager.setWifiEnabled(z);
                i = zIsWifiEnabled;
            } catch (Exception e) {
                e = e;
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 105}, I1I.IL1Iii.IL1Iii(new byte[]{3, 6, 7, 5, 86, 10}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 2, 7, 5, 83}, "ccf26a"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 7, 76, 53, 90, 3, 13, 39, 86, 3, 81, 9, 1, 66, 93, 16, 65, 77}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 9, 7, 86, 84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 87, 3, 6, 87}, "41ffcf"))) + e.toString() + I1I.IL1Iii.IL1Iii(new byte[]{74}, I1I.IL1Iii.IL1Iii(new byte[]{1, 8, 0, 2, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{81, 10, 0, 2, 83, 86}, "33dfe3"))));
                i = zIsWifiEnabled;
            }
        } catch (Exception e2) {
            e = e2;
            zIsWifiEnabled = true;
        }
        return i;
    }

    public static void Li1l(String str, String str2, String str3, int i) {
        try {
            if (m1143L1l() == null) {
                File file = new File(str3);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{90, 95, 87, 86, 87, 70, 95, 64, 80, 22, 69, 93}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 13, 91, 15, 81}, I1I.IL1Iii.IL1Iii(new byte[]{6, 89, 15, 80, 9, 87}, "b87304"))), i, false, true, true);
                Native.initNative();
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{94, 8, 86, 6, 18, 18, 109, 18, 92, 4, 75, 92, 86, 79, 71, 10}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 5, 83, 11, 9}, I1I.IL1Iii.IL1Iii(new byte[]{13, 0, 4, 1, 81, 1}, "8057c1"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{10, 12, 7, 80, 94, 80, 19, 17, 12, 85, 64, 25, 21, 10}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 85, 10, 0, 83}, I1I.IL1Iii.IL1Iii(new byte[]{82, 6, 82, 2, 82, 93}, "a0b1a9"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{88, 8, 86, 11, 66, 0, 90, 2, 66, 59, 88, 4, 66, 0, 0, 74, 65, 10}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 85, 82, 6, 92}, I1I.IL1Iii.IL1Iii(new byte[]{6, 4, 7, 80, 80, 9}, "d1ffd0"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{90, 81, 7, 87, 92, 8, 78, 74, 16, 86, 70, 15, 91, 93, 75, 75, 93}, I1I.IL1Iii.IL1Iii(new byte[]{15, 11, 4, 12, 4, 81}, I1I.IL1Iii.IL1Iii(new byte[]{13, 5, 86, 82, 87, 3}, "467fa4"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{89, 8, 7, 14, 87, 68, 84, 17, 12, 79, 71, 89}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 87, 88, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{81, 87, 4, 14, 9, 1}, "436790"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{95, 94, 4, 70, 65, 84, 92, 91, 9, 64, 28, 68, 92}, I1I.IL1Iii.IL1Iii(new byte[]{2, 15, 94, 7, 87, 82}, I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 89, 81, 83, 3}, "65ad6f"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{13, 93, 1, 70, 67, 93, 23, 81, 13, 70, 30, 75, 14}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 1, 84, 6, 9}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 3, 94, 84, 82}, "c2a8bc"))), i, false, true, true);
                m1194llI11I(str, file, I1I.IL1Iii.IL1Iii(new byte[]{14, 88, 86, 4, 12, 85, 11, 95, 81, 79, 17, 93}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 85, 0, 7, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 81, 7, 6, 81}, "270fc2"))), i, false, true, true);
            } else {
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{80, 27, 79, 103, 17, 81, 82, 66, 1, 92}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 93, 91, 85, 90}, I1I.IL1Iii.IL1Iii(new byte[]{9, 2, 1, 80, 1, 86}, "858365"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{12, 4, 23, 13, 66, 7}, I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 7, 84, 4, 91}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 1, 8, 81, 0}, "31e8a9"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{15, 8, 3, 23, 68, 88, 10, 22}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 2, 4, 1, 8}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 95, 4, 0, 95}, "c49b1f"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{11, 69, 7, 95, 0, 67, 59, 95, 3, 71, 2, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 82, 87, 83, 13}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 2, 95, 4, 91}, "0d294c"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{14, 87, 90, 26, 69, 20, 15, 77, 93, 15, 82}, I1I.IL1Iii.IL1Iii(new byte[]{84, 14, 81, 81, 82, 80}, I1I.IL1Iii.IL1Iii(new byte[]{12, 6, 82, 5, 85, 85}, "91760d"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{95, 2, 19, 5, 17, 94}, I1I.IL1Iii.IL1Iii(new byte[]{7, 80, 81, 2, 87, 81}, I1I.IL1Iii.IL1Iii(new byte[]{5, 8, 7, 2, 3, 4}, "297d5b"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{23, 16, 80, 89, 10, 12, 17}, I1I.IL1Iii.IL1Iii(new byte[]{85, 86, 2, 5, 7, 82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 5, 82, 5, 86, 83}, "e0c67b"))));
                System.loadLibrary(I1I.IL1Iii.IL1Iii(new byte[]{81, 11, 4, 81, 8, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 91, 93, 5, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 14, 7, 87, 84}, "da6b4b"))));
            }
        } catch (Exception e) {
            I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{43, 106}, I1I.IL1Iii.IL1Iii(new byte[]{86, 87, 2, 81, 93, 85}, I1I.IL1Iii.IL1Iii(new byte[]{11, 85, 84, 0, 1, 1}, "800581"))), I1I.IL1Iii.IL1Iii(new byte[]{10, 86, 67, 2, 91, 85, 38, 86, 87, 10, 89, 92, 67, 93, 66, 17, 13}, I1I.IL1Iii.IL1Iii(new byte[]{86, 15, 7, 80, 0, 90}, I1I.IL1Iii.IL1Iii(new byte[]{1, 84, 83, 3, 84, 1}, "4cd0cb"))) + e.toString());
        }
    }

    /* JADX INFO: renamed from: Li1丨IL1, reason: contains not printable characters */
    public static String m1136Li1IL1(String str, Map<String, String> map, Map<String, String> map2, long j) {
        try {
            C0007.ILil iLil = new C0007.ILil();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            iLil.ILil(j, timeUnit);
            iLil.m2981lLi1LL(j, timeUnit);
            iLil.Ilil(j, timeUnit);
            C0007 c0007IL1Iii = iLil.IL1Iii();
            L1l.IL1Iii iL1Iii = new L1l.IL1Iii();
            if (map2 != null && map2.size() > 0) {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    iL1Iii.IL1Iii(entry.getKey(), entry.getValue());
                }
            }
            iL1Iii.m2878L11I(str);
            l.IL1Iii iL1Iii2 = new l.IL1Iii();
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    iL1Iii2.IL1Iii(entry2.getKey(), entry2.getValue());
                }
            }
            iL1Iii.m2880lLi1LL(iL1Iii2.I1I());
            return c0007IL1Iii.IL1Iii(iL1Iii.ILil()).execute().m2846IiL().string();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 105}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 3, 15, 89, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 84, 1, 89, 3}, "5556a6"))), e.toString());
            return null;
        }
    }

    public static String LiL1() {
        return f3370I1I;
    }

    /* JADX INFO: renamed from: Lii1i丨i, reason: contains not printable characters */
    public static void m1137Lii1ii(Context context, int i, String str) {
        C0607ILl.m1066lLi1LL(context, context.getResources().getResourceEntryName(i), str);
    }

    public static String Liil1L1l(Context context) {
        String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{73, 4}, I1I.IL1Iii.IL1Iii(new byte[]{80, 80, 92, 80, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 92, 6, 84, 4}, "aa9e02")));
        if (context == null) {
            return strIL1Iii;
        }
        PackageManager packageManager = context.getPackageManager();
        Signature[] apkContentsSigners = null;
        try {
            apkContentsSigners = Build.VERSION.SDK_INT > 28 ? packageManager.getPackageInfo(context.getPackageName(), Videoio.CAP_INTELPERC_IR_GENERATOR).signingInfo.getApkContentsSigners() : packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (apkContentsSigners == null || apkContentsSigners.length <= 0) ? strIL1Iii : m1174llL1ii(apkContentsSigners[0].toByteArray()).toUpperCase();
    }

    public static int Lil(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    /* JADX INFO: renamed from: Lil丨I丨, reason: contains not printable characters */
    public static void m1138LilI(Context context) {
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{3, 95, 2, 23, 87, 12, 6, 31, 21, 0, 76, 17, 11, 95, 1, 22, 22, 44, 44, 97, 51, 49, 103, 40, 39, 101, 46, 42, 124, 58, 49, 116, 50, 49, 113, 43, 37, 98}, I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 85, 4, 13, 81}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 2, 88, 80, 80}, "7419ed"))));
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        context.startActivity(intent);
    }

    public static boolean Ll1(Context context) {
        return context.getPackageName().compareTo(I1I.IL1Iii.IL1Iii(new byte[]{2, 14, 15, 22, 93, 27, 79, 15, 26, 72, 65, 12, 11, 8, 22}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 7, 11, 85, 84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 1, 10, 3, 83}, "ccd9ed")))) == 0;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public static boolean m1139LlIl(Context context) {
        return context.getResources().getInteger(R.integer.is_use_volctl) != 0;
    }

    public static String LlLI1(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = I1I.IL1Iii.IL1Iii(new byte[]{108, 54, 34, 24, 89}, I1I.IL1Iii.IL1Iii(new byte[]{9, 86, 92, 84, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 8, 82, 6, 7}, "d60310")));
            }
            return URLEncoder.encode(str, str2);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{126, 97}, I1I.IL1Iii.IL1Iii(new byte[]{86, 88, 85, 86, 2, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 6, 6, 0, 87}, "74e6db"))), I1I.IL1Iii.IL1Iii(new byte[]{85, 94, 80, 13, 86, 80, 101, 66, 95, 66, 87, 71, 66, 10}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 87, 82, 81, 84}, I1I.IL1Iii.IL1Iii(new byte[]{3, 6, 86, 9, 82, 83}, "152912"))) + e.toString());
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public static String m1140LlLiLL() throws Throwable {
        try {
            String strM1155iiIIi11 = m1155iiIIi11(0);
            if (strM1155iiIIi11 != null) {
                return strM1155iiIIi11;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean Lli(Context context) {
        return m15LL(context, R.id.switch_rootengine, m1205(context));
    }

    /* JADX INFO: renamed from: Lll丨I11, reason: contains not printable characters */
    public static boolean m1141LllI11() {
        return f1086lIiI;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static void m1142Ll1(File file) throws Exception {
        if (file != null) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    m1142Ll1(file2);
                }
            }
            file.delete();
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public static Context m1143L1l() {
        return f1089lLi1LL;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static boolean m1144L11I(String str, String str2) throws IOException {
        File file = new File(str);
        File file2 = new File(str2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[10240];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i <= 0) {
                                    bufferedOutputStream.close();
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                    fileInputStream.close();
                                    return true;
                                }
                                bufferedOutputStream.write(bArr, 0, i);
                                bufferedOutputStream.flush();
                                try {
                                    throw th;
                                } catch (Throwable th) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th5) {
                                    th3.addSuppressed(th5);
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                } catch (Throwable th7) {
                    try {
                        throw th7;
                    } catch (Throwable th8) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                        throw th8;
                    }
                }
            } catch (Throwable th10) {
                try {
                    throw th10;
                } catch (Throwable th11) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th12) {
                        th10.addSuppressed(th12);
                    }
                    throw th11;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public static AccessibilityService m1145LlLLL() {
        return com.p000nx.uiauto.accessibility.AccessibilityService.Ilil();
    }

    /* JADX INFO: renamed from: i1 */
    public static Context m17i1() {
        Context context = f1089lLi1LL;
        return context != null ? context : f3372ILil;
    }

    public static void i1iL1(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent();
            intent.setAction(I1I.IL1Iii.IL1Iii(new byte[]{86, 11, 5, 22, 91, 94, 83, 75, 18, 1, 64, 67, 94, 11, 6, 23, 26, 101, 114, 52, 52, 33, 103, 99, 104, 44, 38, 42, 123, 101, 114, 58, 35, 37, 96, 99, 114, 55, 56, 59, 123, 103, 99, 44, 44, 45, 110, 118, 99, 44, 46, 42, 103}, I1I.IL1Iii.IL1Iii(new byte[]{83, 87, 7, 85, 13, 86}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 2, 82, 13, 88}, "21dc49"))));
            intent.setData(Uri.parse(I1I.IL1Iii.IL1Iii(new byte[]{22, 86, 84, 90, 3, 86, 3, 13}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 85, 85, 85, 9}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 80, 80, 83, 91}, "3a24dc"))) + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: iI */
    public static String m18iI() throws Throwable {
        String[] strArrSplit;
        String strGroup;
        String[] strArrSplit2;
        try {
            String strM1155iiIIi11 = m1155iiIIi11(1);
            if (strM1155iiIIi11 != null) {
                return strM1155iiIIi11;
            }
        } catch (Exception unused) {
        }
        String strIIlLiL = iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{5, 23, 85, 18, 65, 73, 18, 66, 79, 11, 92, 84, 14, 21, 24, 30, 18, 87, 19, 7, 72, 66, 95, 118, 14, 1, 77, 17, 87, 84, 54, 11, 86, 6, 93, 71}, I1I.IL1Iii.IL1Iii(new byte[]{81, 1, 11, 6, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 80, 85, 11, 83}, "76c18e")))}, 8000L);
        if (!TextUtils.isEmpty(strIIlLiL)) {
            Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{93, 35, 86, 91, 65, 70, 85, 1, 110, 81, 90, 81, 95, 18, 4, 16, 104, 78, 30, 79, 6, 100, 73, 28}, I1I.IL1Iii.IL1Iii(new byte[]{5, 87, 93, 12, 0, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 81, 82, 3, 12, 2}, "3c6786")))).matcher(strIIlLiL);
            if (matcher.find() && (strGroup = matcher.group(1)) != null && (strArrSplit2 = strGroup.split(" ")) != null && strArrSplit2.length >= 3) {
                String[] strArrSplit3 = strArrSplit2[2].split(I1I.IL1Iii.IL1Iii(new byte[]{73}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 90, 5, 15, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 5, 80, 94, 91}, "fdf6f8"))));
                if (strArrSplit3.length == 2) {
                    return strArrSplit3[1];
                }
            }
        }
        String strM14I = m14I();
        if (TextUtils.isEmpty(strM14I) || (strArrSplit = strM14I.split(I1I.IL1Iii.IL1Iii(new byte[]{76}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 6, 86, 86, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 1, 92, 7, 82}, "0de8cb"))))) == null || strArrSplit.length < 2) {
            return null;
        }
        if (!strArrSplit[1].startsWith(I1I.IL1Iii.IL1Iii(new byte[]{27}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 87, 92, 0, 80}, I1I.IL1Iii.IL1Iii(new byte[]{88, 86, 0, 10, 86, 88}, "95f2d9"))))) {
            return strArrSplit[1];
        }
        return strArrSplit[0] + strArrSplit[1];
    }

    /* JADX INFO: renamed from: iI1L1丨Ll, reason: contains not printable characters */
    public static void m1146iI1L1Ll(Context context) {
        try {
            Intent intent = new Intent();
            intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            int i = Build.VERSION.SDK_INT;
            if (i >= 9) {
                intent.setAction(I1I.IL1Iii.IL1Iii(new byte[]{88, 86, 1, 19, 86, 8, 93, 22, 22, 4, 77, 21, 80, 86, 2, 18, 23, 32, 105, 104, 41, 40, 122, 32, 109, 113, 42, 47, 102, 37, 124, 108, 36, 40, 117, 50, 102, 107, 32, 53, 109, 40, 119, 127, 54}, I1I.IL1Iii.IL1Iii(new byte[]{8, 93, 93, 0, 95, 81}, I1I.IL1Iii.IL1Iii(new byte[]{9, 1, 11, 82, 3, 3}, "8d33e3"))));
                intent.setData(Uri.fromParts(I1I.IL1Iii.IL1Iii(new byte[]{19, 81, 85, 13, 88, 6, 6}, I1I.IL1Iii.IL1Iii(new byte[]{82, 8, 85, 5, 91, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 0, 90, 86, 82, 92}, "e89508"))), context.getPackageName(), null));
            } else if (i <= 8) {
                intent.setAction(I1I.IL1Iii.IL1Iii(new byte[]{7, 15, 92, 19, 13, 81, 2, 79, 81, 15, 22, 93, 8, 21, 22, 0, 1, 76, 15, 14, 86, 79, 52, 113, 35, 54}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 12, 85, 81, 93}, I1I.IL1Iii.IL1Iii(new byte[]{91, 0, 86, 0, 3, 83}, "9ab406"))));
                intent.setClassName(I1I.IL1Iii.IL1Iii(new byte[]{0, 91, 14, 31, 80, 11, 7, 70, 12, 88, 85, 75, 16, 81, 23, 69, 88, 11, 4, 71}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 87, 83, 9, 81}, I1I.IL1Iii.IL1Iii(new byte[]{90, 12, 85, 84, 15, 12}, "98a678"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 93, 12, 28, 5, 91, 92, 64, 14, 91, 0, 27, 75, 87, 21, 70, 13, 91, 95, 28, 40, 92, 23, 65, 89, 94, 13, 87, 0, 116, 72, 66, 37, 87, 16, 84, 81, 94, 18}, I1I.IL1Iii.IL1Iii(new byte[]{0, 11, 89, 81, 81, 81}, I1I.IL1Iii.IL1Iii(new byte[]{15, 90, 91, 87, 83, 80}, "7cc4f4"))));
                intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{87, 91, 93, 27, 7, 87, 80, 70, 95, 92, 2, 23, 71, 81, 68, 65, 15, 87, 83, 71, 30, 116, 22, 73, 88, 93, 83, 84, 18, 80, 91, 90, 96, 94, 1, 119, 85, 89, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 81, 86, 84, 93}, I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 89, 83, 86, 6}, "3980db"))), context.getPackageName());
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public static int m1147iI1iI(Context context) {
        try {
            Point point = new Point();
            m1116ILLIi(context, point);
            return point.y;
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 106}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 7, 5, 3, 13}, I1I.IL1Iii.IL1Iii(new byte[]{95, 0, 0, 86, 82, 84}, "9f7dea"))), e.toString());
            return 0;
        }
    }

    /* JADX INFO: renamed from: iIL丨, reason: contains not printable characters */
    public static void m1148iIL(boolean z, int i) {
        if (z) {
            p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(102, BuildConfig.FLAVOR + i, BuildConfig.FLAVOR));
            return;
        }
        p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(101, BuildConfig.FLAVOR + i, BuildConfig.FLAVOR));
    }

    public static String iIi1(String str, long j, boolean z) {
        if (z) {
            return iIlLiL(new String[]{str}, j);
        }
        new Thread(new ILL(str, j)).start();
        return null;
    }

    public static int iIilII1(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{79, 11, 90, 7, 9, 20}, I1I.IL1Iii.IL1Iii(new byte[]{1, 87, 82, 82, 82, 6}, I1I.IL1Iii.IL1Iii(new byte[]{11, 12, 83, 6, 12, 80}, "295785"))));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 57}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 12, 13, 1, 1}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 92, 0, 7, 84}, "e5d43f"))), e.toString());
            return 0;
        }
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public static String m1149iIl1il() {
        String str = I11L;
        if (str != null) {
            return str;
        }
        try {
            if (m1183IlL1ll1()) {
                I11L = I1I.IL1Iii.IL1Iii(new byte[]{74, 81, 2, 70, 86, 27, 9, 90, 0, 83, 91, 27, 17, 88, 19, 29, 91, 70, 18, 90, 17, 89, 24}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 2, 81, 3, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 87, 87, 5, 82}, "24641c"))) + LiL1() + I1I.IL1Iii.IL1Iii(new byte[]{22, 91, 95, 84, 87, 76, 65, 88, 92}, I1I.IL1Iii.IL1Iii(new byte[]{13, 86, 5, 5, 86, 91}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 4, 0, 2, 11}, "df15f2")));
            } else {
                I11L = new File(f1085iILLL1.getFilesDir(), I1I.IL1Iii.IL1Iii(new byte[]{11, 13, 87, 6, 29, 25, 8, 14}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 82, 7, 85, 89}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 88, 7, 4, 93}, "f49cbe")))).getAbsolutePath();
            }
        } catch (Exception unused) {
        }
        return I11L;
    }

    public static String iIlL1(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x020b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0213  */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x014a: MOVE (r6 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:44:0x014a */
    public static String iIlLiL(String[] strArr, long j) throws Throwable {
        String strIL1Iii;
        Process process;
        Process processStart;
        Process process2;
        if (strArr != null) {
            int length = strArr.length;
        }
        final StringBuilder sb = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder(I1I.IL1Iii.IL1Iii(new byte[]{30, 65, 28, 65, 16, 1, 92, 29, 7, 91, 10, 75, 66, 90}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 82, 83, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 4, 82, 1, 93}, "853338"))));
        if ((Process.myUid() == 0 || Process.myUid() == 2000) && (strIL1Iii = llL1ii.IL1Iii()) != null && strIL1Iii.length() > 0 && processBuilder.environment() != null) {
            processBuilder.environment().put(I1I.IL1Iii.IL1Iii(new byte[]{122, 33, 62, 40, 121, 35, 100, 36, 51, 61, 111, 49, 119, 49, 41}, I1I.IL1Iii.IL1Iii(new byte[]{15, 82, 87, 93, 5, 84}, I1I.IL1Iii.IL1Iii(new byte[]{13, 1, 3, 13, 7, 13}, "465428"))), strIL1Iii);
        }
        processBuilder.redirectErrorStream(false);
        try {
            try {
                processStart = processBuilder.start();
                try {
                    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
                    Thread thread = new Thread(new Runnable() { // from class: I1I.I1I.I丨L.IL1Iii
                        @Override // java.lang.Runnable
                        public final void run() {
                            lIlii.m1164i1lL1l(bufferedReader, sb);
                        }
                    });
                    thread.start();
                    DataOutputStream dataOutputStream = new DataOutputStream(processStart.getOutputStream());
                    try {
                        for (String str : strArr) {
                            if (str != null) {
                                dataOutputStream.writeBytes(str + "\n");
                                dataOutputStream.flush();
                            }
                        }
                        dataOutputStream.writeBytes(I1I.IL1Iii.IL1Iii(new byte[]{1, 26, 89, 76, 63}, I1I.IL1Iii.IL1Iii(new byte[]{80, 83, 3, 13, 87, 2}, I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 3, 80, 7, 81}, "700eed"))));
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        if (j > 0) {
                            thread.join(j);
                        } else {
                            processStart.waitFor();
                            thread.join();
                        }
                        if (processStart != null) {
                            processStart.destroy();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                dataOutputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 60}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 81, 1, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{88, 14, 6, 3, 82, 84}, "9922b1"))), I1I.IL1Iii.IL1Iii(new byte[]{6, 79, 3, 7, 65, 87, 17, 69, 92}, I1I.IL1Iii.IL1Iii(new byte[]{6, 15, 82, 0, 87, 10}, I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 7, 86, 5, 10}, "553232"))) + e.toString());
                    if (processStart != null) {
                    }
                    if (strArr != null) {
                        int length2 = strArr.length;
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                e = e2;
                processStart = null;
            } catch (Throwable th4) {
                th = th4;
                process = null;
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
            if (strArr != null) {
                int length3 = strArr.length;
            }
            return sb.toString();
        } catch (Throwable th5) {
            th = th5;
            process = process2;
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public static String m1150iI1LI(Context context, int i, String str) {
        return C0607ILl.I1I(context, context.getResources().getResourceEntryName(i), str);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m1151iILLL1(int i, int[] iArr) {
        if (i != 1) {
            return false;
        }
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public static String m1152iILilI(Context context) {
        int i;
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = context.getPackageManager();
            byte b = 0;
            byte b2 = 6;
            byte b3 = 7;
            Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{4, 92, 2, 68, 94, 12, 1, 28, 15, 88, 69, 0, 11, 70, 72, 87, 82, 17, 12, 93, 8, 24, 124, 36, 44, 124}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 82, 85, 83, 80}, I1I.IL1Iii.IL1Iii(new byte[]{87, 3, 3, 1, 86, 81}, "ce7b4d"))), (Uri) null);
            intent.addCategory(I1I.IL1Iii.IL1Iii(new byte[]{88, 11, 87, 64, 14, 13, 93, 75, 90, 92, 21, 1, 87, 17, 29, 81, 0, 16, 92, 2, 92, 64, 24, 74, 117, 36, 102, 124, 34, 44, 124, 55}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 0, 80, 89, 2}, I1I.IL1Iii.IL1Iii(new byte[]{10, 91, 1, 1, 10, 0}, "282c2f"))));
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 131072);
            Collections.sort(listQueryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            int i2 = 0;
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                JSONObject jSONObject = new JSONObject();
                String str = resolveInfo.activityInfo.packageName;
                try {
                    String str2 = (String) resolveInfo.loadLabel(packageManager);
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, b);
                    byte[] bArr = new byte[3];
                    bArr[b] = 67;
                    bArr[1] = 88;
                    bArr[2] = b2;
                    byte[] bArr2 = new byte[b2];
                    bArr2[b] = 85;
                    bArr2[1] = b3;
                    bArr2[2] = b3;
                    bArr2[3] = 84;
                    bArr2[4] = 84;
                    bArr2[5] = 5;
                    byte[] bArr3 = new byte[b2];
                    bArr3[b] = 86;
                    bArr3[1] = 86;
                    bArr3[2] = 2;
                    bArr3[3] = 5;
                    bArr3[4] = 2;
                    bArr3[5] = 84;
                    jSONObject.put(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "0bdd25"))), str);
                    byte[] bArr4 = new byte[4];
                    bArr4[b] = 93;
                    bArr4[1] = 4;
                    bArr4[2] = 85;
                    bArr4[3] = 81;
                    byte[] bArr5 = new byte[6];
                    bArr5[b] = b;
                    bArr5[1] = 6;
                    bArr5[2] = 92;
                    bArr5[3] = 2;
                    bArr5[4] = 84;
                    bArr5[5] = 86;
                    byte[] bArr6 = new byte[6];
                    bArr6[b] = 86;
                    bArr6[1] = 80;
                    bArr6[2] = 6;
                    bArr6[3] = 80;
                    bArr6[4] = 7;
                    bArr6[5] = 2;
                    jSONObject.put(I1I.IL1Iii.IL1Iii(bArr4, I1I.IL1Iii.IL1Iii(bArr5, I1I.IL1Iii.IL1Iii(bArr6, "e3bfbf"))), str2);
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        try {
                            byte[] bArr7 = new byte[3];
                            bArr7[b] = 68;
                            bArr7[1] = 26;
                            bArr7[2] = 22;
                            byte[] bArr8 = new byte[6];
                            bArr8[b] = 7;
                            bArr8[1] = b;
                            bArr8[2] = 87;
                            bArr8[3] = 83;
                            bArr8[4] = 88;
                            bArr8[5] = 2;
                            byte[] bArr9 = new byte[6];
                            bArr9[b] = 1;
                            bArr9[1] = 85;
                            bArr9[2] = 10;
                            bArr9[3] = 91;
                            bArr9[4] = 8;
                            bArr9[5] = 6;
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(bArr7, I1I.IL1Iii.IL1Iii(bArr8, I1I.IL1Iii.IL1Iii(bArr9, "168914")));
                            byte[] bArr10 = new byte[4];
                            bArr10[b] = 76;
                            bArr10[1] = 69;
                            bArr10[2] = 22;
                            try {
                                bArr10[3] = 92;
                                byte[] bArr11 = new byte[6];
                                bArr11[b] = 8;
                                bArr11[1] = 7;
                                bArr11[2] = 83;
                                bArr11[3] = 90;
                                bArr11[4] = 3;
                                bArr11[5] = 6;
                                byte[] bArr12 = new byte[6];
                                bArr12[b] = 3;
                                bArr12[1] = 84;
                                bArr12[2] = 5;
                                bArr12[3] = 86;
                                bArr12[4] = b;
                                bArr12[5] = 13;
                                jSONObject.put(strIL1Iii, I1I.IL1Iii.IL1Iii(bArr10, I1I.IL1Iii.IL1Iii(bArr11, I1I.IL1Iii.IL1Iii(bArr12, "3d55e9"))));
                            } catch (Exception e) {
                                e = e;
                                i = 4;
                                byte[] bArr13 = new byte[i];
                                bArr13[b] = 123;
                                bArr13[1] = 106;
                                bArr13[2] = 96;
                                bArr13[3] = 47;
                                byte[] bArr14 = new byte[6];
                                bArr14[b] = 4;
                                bArr14[1] = b;
                                bArr14[2] = 12;
                                bArr14[3] = 82;
                                bArr14[4] = 8;
                                bArr14[5] = 4;
                                byte[] bArr15 = new byte[6];
                                bArr15[b] = 82;
                                bArr15[1] = 9;
                                bArr15[2] = 80;
                                bArr15[3] = 80;
                                bArr15[4] = 14;
                                bArr15[5] = 81;
                                Log.i(I1I.IL1Iii.IL1Iii(bArr13, I1I.IL1Iii.IL1Iii(bArr14, I1I.IL1Iii.IL1Iii(bArr15, "a1ef60"))), e.toString());
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } else {
                        try {
                            byte[] bArr16 = new byte[3];
                            bArr16[b] = 22;
                            bArr16[1] = 77;
                            bArr16[2] = 74;
                            byte[] bArr17 = new byte[6];
                            bArr17[b] = 3;
                            bArr17[1] = 86;
                            bArr17[2] = 90;
                            bArr17[3] = 1;
                            bArr17[4] = 5;
                            bArr17[5] = 87;
                            byte[] bArr18 = new byte[6];
                            bArr18[b] = 5;
                            bArr18[1] = 91;
                            bArr18[2] = 84;
                            bArr18[3] = 2;
                            bArr18[4] = 5;
                            bArr18[5] = 85;
                            String strIL1Iii2 = I1I.IL1Iii.IL1Iii(bArr16, I1I.IL1Iii.IL1Iii(bArr17, I1I.IL1Iii.IL1Iii(bArr18, "c973cc")));
                            byte[] bArr19 = new byte[5];
                            bArr19[b] = 5;
                            bArr19[1] = 80;
                            bArr19[2] = 10;
                            bArr19[3] = 75;
                            bArr19[4] = 6;
                            byte[] bArr20 = new byte[6];
                            bArr20[b] = 82;
                            bArr20[1] = 83;
                            bArr20[2] = 86;
                            bArr20[3] = 1;
                            bArr20[4] = b;
                            bArr20[5] = 87;
                            byte[] bArr21 = new byte[6];
                            bArr21[b] = 1;
                            bArr21[1] = 85;
                            bArr21[2] = 4;
                            bArr21[3] = 13;
                            bArr21[4] = 84;
                            try {
                                bArr21[5] = 7;
                                jSONObject.put(strIL1Iii2, I1I.IL1Iii.IL1Iii(bArr19, I1I.IL1Iii.IL1Iii(bArr20, I1I.IL1Iii.IL1Iii(bArr21, "074472"))));
                            } catch (Exception e3) {
                                e = e3;
                                i = 4;
                                byte[] bArr110 = new byte[i];
                                bArr110[b] = 123;
                                bArr110[1] = 106;
                                bArr110[2] = 96;
                                bArr110[3] = 47;
                                byte[] bArr111 = new byte[6];
                                bArr111[b] = 4;
                                bArr111[1] = b;
                                bArr111[2] = 12;
                                bArr111[3] = 82;
                                bArr111[4] = 8;
                                bArr111[5] = 4;
                                byte[] bArr112 = new byte[6];
                                bArr112[b] = 82;
                                bArr112[1] = 9;
                                bArr112[2] = 80;
                                bArr112[3] = 80;
                                bArr112[4] = 14;
                                bArr112[5] = 81;
                                Log.i(I1I.IL1Iii.IL1Iii(bArr110, I1I.IL1Iii.IL1Iii(bArr111, I1I.IL1Iii.IL1Iii(bArr112, "a1ef60"))), e.toString());
                                b = 0;
                                b2 = 6;
                                b3 = 7;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i = 4;
                            byte[] bArr113 = new byte[i];
                            bArr113[b] = 123;
                            bArr113[1] = 106;
                            bArr113[2] = 96;
                            bArr113[3] = 47;
                            byte[] bArr114 = new byte[6];
                            bArr114[b] = 4;
                            bArr114[1] = b;
                            bArr114[2] = 12;
                            bArr114[3] = 82;
                            bArr114[4] = 8;
                            bArr114[5] = 4;
                            byte[] bArr115 = new byte[6];
                            bArr115[b] = 82;
                            bArr115[1] = 9;
                            bArr115[2] = 80;
                            bArr115[3] = 80;
                            bArr115[4] = 14;
                            bArr115[5] = 81;
                            Log.i(I1I.IL1Iii.IL1Iii(bArr113, I1I.IL1Iii.IL1Iii(bArr114, I1I.IL1Iii.IL1Iii(bArr115, "a1ef60"))), e.toString());
                            b = 0;
                            b2 = 6;
                            b3 = 7;
                        }
                    }
                    int i3 = i2 + 1;
                    try {
                        jSONArray.put(i2, jSONObject);
                        i2 = i3;
                    } catch (Exception e5) {
                        e = e5;
                        i2 = i3;
                        i = 4;
                        byte[] bArr116 = new byte[i];
                        bArr116[b] = 123;
                        bArr116[1] = 106;
                        bArr116[2] = 96;
                        bArr116[3] = 47;
                        byte[] bArr117 = new byte[6];
                        bArr117[b] = 4;
                        bArr117[1] = b;
                        bArr117[2] = 12;
                        bArr117[3] = 82;
                        bArr117[4] = 8;
                        bArr117[5] = 4;
                        byte[] bArr118 = new byte[6];
                        bArr118[b] = 82;
                        bArr118[1] = 9;
                        bArr118[2] = 80;
                        bArr118[3] = 80;
                        bArr118[4] = 14;
                        bArr118[5] = 81;
                        Log.i(I1I.IL1Iii.IL1Iii(bArr116, I1I.IL1Iii.IL1Iii(bArr117, I1I.IL1Iii.IL1Iii(bArr118, "a1ef60"))), e.toString());
                    }
                } catch (Exception e6) {
                    e = e6;
                }
                b = 0;
                b2 = 6;
                b3 = 7;
            }
        } catch (Exception unused) {
        }
        return jSONArray.toString();
    }

    /* JADX INFO: renamed from: iL1丨1ll, reason: contains not printable characters */
    public static void m1153iL11ll(Context context, String str, String str2) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str2)) {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
        } else {
            intent.setComponent(new ComponentName(str, str2));
        }
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        context.startActivity(intent);
    }

    /* JADX INFO: renamed from: iLiLI丨, reason: contains not printable characters */
    public static void m1154iLiLI(Context context) {
        LIlIlIL(new IiL(context));
    }

    public static boolean ii1(Context context) {
        return context.getResources().getInteger(R.integer.is_use_hostui) != 0;
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public static String m1155iiIIi11(int i) throws Throwable {
        String strGroup;
        String[] strArrSplit;
        String strIIlLiL = iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{83, 66, 92, 18, 74, 78, 68, 23, 70, 11, 87, 83, 88, 64, 17, 30, 25, 80, 69, 82, 65, 66, 84, 113, 88, 84, 68, 17, 92, 83, 96, 94, 95, 6, 86, 64}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 1, 1, 93, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 6, 86, 93, 7}, "d66594")))}, 8000L);
        if (TextUtils.isEmpty(strIIlLiL)) {
            return null;
        }
        Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{93, 118, 94, 7, 71, 70, 85, 84, 102, 13, 92, 81, 95, 71, 12, 51, 91, 91, 84, 95, 70, 56, 73, 29, 30, 26, 14, 77, 110, 72}, I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 84, 7, 83, 86}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 86, 81, 80, 80}, "f73213")))).matcher(strIIlLiL);
        if (!matcher.find() || (strGroup = matcher.group(1)) == null || (strArrSplit = strGroup.split(" ")) == null || strArrSplit.length < 3) {
            return null;
        }
        String[] strArrSplit2 = strArrSplit[2].trim().split(I1I.IL1Iii.IL1Iii(new byte[]{31}, I1I.IL1Iii.IL1Iii(new byte[]{85, 15, 94, 7, 84, 6}, I1I.IL1Iii.IL1Iii(new byte[]{84, 10, 0, 3, 1, 1}, "13f217"))));
        if (strArrSplit2.length == 2) {
            return strArrSplit2[i];
        }
        if (strArrSplit2.length == 1) {
            return strArrSplit2[0];
        }
        return null;
    }

    /* JADX INFO: renamed from: iil1丨, reason: contains not printable characters */
    public static String m1156iil1(Context context) {
        return String.format(I1I.IL1Iii.IL1Iii(new byte[]{70, 22, 20, 75, -122, -70, -21, -125, -88, -49, 68, 64, 74}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 6, 82, 85, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 87, 84, 13, 5}, "f5ee9c"))), L1iI1(context), iIlL1(context));
    }

    /* JADX INFO: renamed from: ii丨1, reason: contains not printable characters */
    public static int m1157ii1(Context context, int i) {
        return (int) (i * (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    /* JADX INFO: renamed from: ii丨丨LL, reason: contains not printable characters */
    public static void m1158iiLL(Context context) {
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{84, 90, 1, 75, 91, 93, 81, 26, 22, 92, 64, 64, 92, 90, 2, 74, 26, 117, 118, 119, 32, 106, 103, 125, 119, 125, 41, 112, 96, 109, 106, 103, 32, 109, 96, 125, 123, 115, 54}, I1I.IL1Iii.IL1Iii(new byte[]{3, 12, 80, 9, 4, 13}, I1I.IL1Iii.IL1Iii(new byte[]{5, 90, 87, 85, 3, 12}, "3bbe35"))));
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        context.startActivity(intent);
    }

    /* JADX INFO: renamed from: il */
    public static void m19il(Context context, int i, int i2) {
        C0607ILl.Ilil(context, context.getResources().getResourceEntryName(i), i2);
    }

    /* JADX INFO: renamed from: il1L丨, reason: contains not printable characters */
    public static void m1159il1L(Context context, String str, int i, int i2, int i3) {
        LIlIlIL(new iILLL1(context, str, i, i2, i3));
    }

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public static LlLI1.IL1Iii m1160ili11(Context context) {
        String strI1I = C0607ILl.I1I(context, I1I.IL1Iii.IL1Iii(new byte[]{84, 93, 6, 94, 95, 93, 110, 71, 24, 71, 84}, I1I.IL1Iii.IL1Iii(new byte[]{9, 0, 83, 83, 8, 8}, I1I.IL1Iii.IL1Iii(new byte[]{8, 5, 1, 84, 88, 82}, "0630ab"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 95, 12, 71}, I1I.IL1Iii.IL1Iii(new byte[]{81, 86, 82, 80, 3, 84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 2, 7, 80, 9, 2}, "cd6382"))));
        if (strI1I == null) {
            return LlLI1.IL1Iii.ROOT;
        }
        if (strI1I.equals(I1I.IL1Iii.IL1Iii(new byte[]{71, 10, 12, 67}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 90, 1, 80, 3}, I1I.IL1Iii.IL1Iii(new byte[]{86, 86, 0, 0, 2, 3}, "aa961f"))))) {
            return LlLI1.IL1Iii.ROOT;
        }
        return strI1I.equals(I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 2}, I1I.IL1Iii.IL1Iii(new byte[]{86, 1, 83, 1, 1, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 80, 2, 11, 81}, "c4b522")))) ? LlLI1.IL1Iii.ACC : LlLI1.IL1Iii.HANDLE;
    }

    public static Class<?>[] ill1LI1l(Class<?> cls, String str) {
        for (Method method : cls.getDeclaredMethods()) {
            if (str.equals(method.getName())) {
                return method.getParameterTypes();
            }
        }
        return null;
    }

    public static void illl(Context context, String str) {
        Intent intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{87, 94, 5, 23, 87, 15, 82, 30, 8, 11, 76, 3, 88, 68, 79, 4, 91, 18, 95, 95, 15, 75, 117, 35, 114, 121, 32, 58, 107, 37, 119, 126, 47, 32, 106, 57, 101, 115, 32, 43, 103, 32, 127, 124, 36}, I1I.IL1Iii.IL1Iii(new byte[]{14, 1, 89, 1, 15, 94}, I1I.IL1Iii.IL1Iii(new byte[]{91, 80, 89, 84, 83, 91}, "caa0dc"))));
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: il丨iiL丨, reason: contains not printable characters */
    public static void m1161iliiL(Context context) {
        int integer = context.getResources().getInteger(R.integer.vir_width);
        int integer2 = context.getResources().getInteger(R.integer.vir_height);
        if (integer2 > 0 && integer > 0) {
            I1LilL(integer, integer2);
        }
        Point point = new Point();
        m1116ILLIi(context, point);
        LLlIiil(point.x, point.y);
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public static boolean m1162ill(Context context) {
        return context.getResources().getInteger(R.integer.is_boot_run) != 0;
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public static int m1163i1I1I1l(Context context, int i, int i2) {
        return C0607ILl.ILil(context, context.getResources().getResourceEntryName(i), i2);
    }

    /* JADX INFO: renamed from: i丨1lL1l, reason: contains not printable characters */
    public static /* synthetic */ void m1164i1lL1l(BufferedReader bufferedReader, StringBuilder sb) {
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            return;
                        } else {
                            sb.append(line);
                            sb.append("\n");
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bufferedReader.close();
                    return;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: i丨ILiiLl, reason: contains not printable characters */
    public static String m1165iILiiLl(Context context) {
        return m1132LIl(context, I1I.IL1Iii.IL1Iii(new byte[]{66, 22, 92, 30, 27}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 0, 2, 85, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 2, 10, 80, 84, 4}, "cc94cf"))), true);
    }

    /* JADX INFO: renamed from: i丨LI, reason: contains not printable characters */
    public static int m1166iLI(String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        int i = 6;
        sb.append(I1I.IL1Iii.IL1Iii(new byte[]{65, 74, 21, 68, 70, 95, 67, 92, 69, 24}, I1I.IL1Iii.IL1Iii(new byte[]{1, 93, 84, 94, 87, 89}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 0, 81, 82, 83}, "20a7c2"))));
        sb.append(str);
        String strIIlLiL = iIlLiL(new String[]{sb.toString()}, 8000L);
        char c = '\b';
        int i2 = 3;
        if (!TextUtils.isEmpty(strIIlLiL)) {
            String[] strArrSplit = strIIlLiL.split("\n");
            int length = strArrSplit.length;
            int i3 = 0;
            while (i3 < length) {
                byte[] bArr = new byte[i2];
                // fill-array-data instruction
                bArr[0] = 58;
                bArr[1] = 75;
                bArr[2] = 79;
                String[] strArrSplit2 = strArrSplit[i3].split(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(new byte[]{83, 13, 1, 93, 85, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 13, 84, 91, 85, 3}, "f81c6b"))));
                if (strArrSplit2.length >= 9) {
                    String str2 = strArrSplit2[7];
                    String strTrim = strArrSplit2[c].trim();
                    if (str2.compareToIgnoreCase(I1I.IL1Iii.IL1Iii(new byte[]{62}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 3, 85, 11, 87}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 1, 85, 12, 94}, "be0158")))) != 0 && strTrim.compareTo(str) == 0) {
                        return 1;
                    }
                }
                i3++;
                c = '\b';
                i2 = 3;
            }
        }
        String strIIlLiL2 = iIlLiL(new String[]{I1I.IL1Iii.IL1Iii(new byte[]{65, 66, 16, 72, 115, 70, 77, 17, 87, 23, 87, 22, 17}, I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 85, 4, 6, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 7, 84, 13, 3}, "aab590"))) + str}, 8000L);
        if (!TextUtils.isEmpty(strIIlLiL2)) {
            String[] strArrSplit3 = strIIlLiL2.split("\n");
            int length2 = strArrSplit3.length;
            int i4 = 0;
            while (i4 < length2) {
                byte[] bArr2 = new byte[i];
                // fill-array-data instruction
                bArr2[0] = 85;
                bArr2[1] = 1;
                bArr2[2] = 9;
                bArr2[3] = 85;
                bArr2[4] = 4;
                bArr2[5] = 9;
                byte[] bArr3 = new byte[i];
                // fill-array-data instruction
                bArr3[0] = 85;
                bArr3[1] = 4;
                bArr3[2] = 5;
                bArr3[3] = 6;
                bArr3[4] = 2;
                bArr3[5] = 90;
                String[] strArrSplit4 = strArrSplit3[i4].split(I1I.IL1Iii.IL1Iii(new byte[]{109, 66, 19}, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "144b2b"))));
                if (strArrSplit4.length >= 9) {
                    String str3 = strArrSplit4[7];
                    String strTrim2 = strArrSplit4[8].trim();
                    byte[] bArr4 = new byte[i];
                    // fill-array-data instruction
                    bArr4[0] = 2;
                    bArr4[1] = 80;
                    bArr4[2] = 82;
                    bArr4[3] = 81;
                    bArr4[4] = 91;
                    bArr4[5] = 85;
                    byte[] bArr5 = new byte[i];
                    // fill-array-data instruction
                    bArr5[0] = 8;
                    bArr5[1] = 92;
                    bArr5[2] = 0;
                    bArr5[3] = 13;
                    bArr5[4] = 93;
                    bArr5[5] = 5;
                    if (str3.compareToIgnoreCase(I1I.IL1Iii.IL1Iii(new byte[]{105}, I1I.IL1Iii.IL1Iii(bArr4, I1I.IL1Iii.IL1Iii(bArr5, "9879d5")))) != 0 && strTrim2.compareTo(str) == 0) {
                        return 1;
                    }
                }
                i4++;
                i = 6;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b4 A[EXC_TOP_SPLITTER, PHI: r1 r2
  0x00b4: PHI (r1v2 android.os.ParcelFileDescriptor) = (r1v1 android.os.ParcelFileDescriptor), (r1v4 android.os.ParcelFileDescriptor) binds: [B:22:0x00b8, B:19:0x00b2] A[DONT_GENERATE, DONT_INLINE]
  0x00b4: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v0 java.lang.String) binds: [B:22:0x00b8, B:19:0x00b2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: i丨丨Ll, reason: contains not printable characters */
    public static String m1167iLl(Bundle bundle) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptor = null;
        String strIlILI = BuildConfig.FLAVOR;
        if (bundle != null) {
            try {
                if (bundle.getInt(I1I.IL1Iii.IL1Iii(new byte[]{70, 93, 64}, I1I.IL1Iii.IL1Iii(new byte[]{12, 89, 85, 81, 88, 92}, I1I.IL1Iii.IL1Iii(new byte[]{90, 0, 3, 0, 4, 92}, "babde8")))) == 1) {
                    ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) bundle.getParcelable(I1I.IL1Iii.IL1Iii(new byte[]{0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{86, 94, 5, 7, 4, 88}, I1I.IL1Iii.IL1Iii(new byte[]{82, 89, 84, 83, 4, 7}, "ba262f"))));
                    if (parcelFileDescriptor2 != null) {
                        try {
                            strIlILI = IlILI(parcelFileDescriptor2);
                        } catch (Exception unused) {
                            parcelFileDescriptor = parcelFileDescriptor2;
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            parcelFileDescriptor = parcelFileDescriptor2;
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptor = parcelFileDescriptor2;
                }
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (parcelFileDescriptor != null) {
            parcelFileDescriptor.close();
        }
        return strIlILI;
    }

    public static String l11(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            fileInputStream.close();
            return str;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public static int m1168l1IIi1(String str) {
        String strI11L = I11L(str);
        if (TextUtils.isEmpty(strI11L)) {
            return 0;
        }
        return m13I1(strI11L);
    }

    public static void l1ILIl(int i) {
        f3373Ilil = i;
    }

    public static boolean l1L(Context context, String str) {
        Intent intent;
        try {
            if (!TextUtils.isEmpty(str)) {
                JIntent jIntent = (JIntent) new Gson().fromJson(str, JIntent.class);
                if (TextUtils.isEmpty(jIntent.getUri())) {
                    intent = new Intent();
                } else {
                    if (TextUtils.isEmpty(jIntent.getAction())) {
                        return false;
                    }
                    intent = new Intent(jIntent.getAction(), Uri.parse(jIntent.getUri()));
                }
                if (!TextUtils.isEmpty(jIntent.getData())) {
                    intent.setData(Uri.parse(jIntent.getData()));
                }
                if (!TextUtils.isEmpty(jIntent.getPackageName())) {
                    intent.setPackage(jIntent.getPackageName());
                }
                if (!TextUtils.isEmpty(jIntent.getClassname()) && !TextUtils.isEmpty(jIntent.getPackageName())) {
                    intent.setClassName(jIntent.getPackageName(), jIntent.getClassname());
                }
                if (jIntent.getExtra() != null && jIntent.getExtra().size() > 0) {
                    for (Map.Entry<String, Object> entry : jIntent.getExtra().entrySet()) {
                        if (entry.getValue() instanceof String) {
                            intent.putExtra(entry.getKey(), (String) entry.getValue());
                        } else if (entry.getValue() instanceof Integer) {
                            intent.putExtra(entry.getKey(), (Integer) entry.getValue());
                        } else if (entry.getValue() instanceof Float) {
                            intent.putExtra(entry.getKey(), (Float) entry.getValue());
                        } else if (entry.getValue() instanceof Double) {
                            intent.putExtra(entry.getKey(), (Double) entry.getValue());
                        } else if (entry.getValue() instanceof Boolean) {
                            intent.putExtra(entry.getKey(), (Boolean) entry.getValue());
                        }
                    }
                }
                intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 58}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 90, 6, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{7, 1, 6, 0, 82, 81}, "66eece"))), I1I.IL1Iii.IL1Iii(new byte[]{93, 11, 69, 6, 15, 66, 9, 91}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 85, 84, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{83, 1, 82, 86, 3, 7}, "2e6a75"))) + intent);
                PendingIntent.getActivity(context, 0, intent, Videoio.CAP_INTELPERC_IR_GENERATOR).send();
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{40, 58}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 4, 14, 6, 7}, I1I.IL1Iii.IL1Iii(new byte[]{81, 1, 80, 11, 0, 1}, "01234c"))), e.toString());
        }
        return false;
    }

    public static String l1Lll() {
        String str = f1091lL;
        if (str != null) {
            return str;
        }
        File fileLIlLi = LIlLi(LL1IL());
        if (fileLIlLi != null) {
            f1091lL = fileLIlLi.getAbsolutePath();
        }
        return f1091lL;
    }

    public static int lI11lLL(Context context, String str) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 16, 89, 65, 11, 22, 73}, I1I.IL1Iii.IL1Iii(new byte[]{86, 6, 80, 7, 5, 81}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 81, 84, 2, 3}, "d2ec00"))));
        if (activityManager == null) {
            return 0;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
        while (it.hasNext()) {
            if (it.next().processName.equals(str)) {
                return 1;
            }
        }
        return 0;
    }

    public static Context lI1I1() {
        return f3372ILil;
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public static String m1169lIIiIlL(Context context) {
        return context.getPackageName() + I1I.IL1Iii.IL1Iii(new byte[]{74}, I1I.IL1Iii.IL1Iii(new byte[]{92, 85, 0, 82, 4, 80}, I1I.IL1Iii.IL1Iii(new byte[]{14, 2, 0, 4, 3, 87}, "721be5"))) + ImeInput.class.getName();
    }

    public static void lILIlI(Context context, LlLI1.IL1Iii iL1Iii) {
        String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{67, 95, 14, 65}, I1I.IL1Iii.IL1Iii(new byte[]{85, 0, 89, 6, 9, 80}, I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 10, 3, 8, 3}, "4f201a")));
        if (iL1Iii == LlLI1.IL1Iii.ACC) {
            strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{7, 91, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 94, 80, 0, 10, 86}, I1I.IL1Iii.IL1Iii(new byte[]{89, 3, 87, 0, 11, 83}, "8e4d95")));
        } else if (iL1Iii == LlLI1.IL1Iii.HANDLE) {
            strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 12, 92, 91, 84}, I1I.IL1Iii.IL1Iii(new byte[]{92, 82, 1, 91, 84, 1}, I1I.IL1Iii.IL1Iii(new byte[]{80, 83, 5, 83, 84, 86}, "4bf07f")));
        }
        C0607ILl.m1066lLi1LL(context, I1I.IL1Iii.IL1Iii(new byte[]{1, 12, 81, 88, 92, 82, 59, 22, 79, 65, 87}, I1I.IL1Iii.IL1Iii(new byte[]{83, 1, 15, 82, 2, 86}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 95, 5, 81, 89}, "5bffa8"))), strIL1Iii);
    }

    public static void lILi1lLl(Context context, String str) {
        try {
            LIlIlIL(new RunnableC0609il(context, str));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: lIiILl丨1, reason: contains not printable characters */
    public static boolean m1170lIiILl1(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            context.startActivity(launchIntentForPackage);
            Thread.sleep(1000L);
            for (int i = 0; i < 20; i++) {
                com.p000nx.uiauto.accessibility.AccessibilityService accessibilityService = (com.p000nx.uiauto.accessibility.AccessibilityService) m1145LlLLL();
                if (accessibilityService != null) {
                    accessibilityService.performGlobalAction(1);
                }
                Thread.sleep(200L);
                if ((accessibilityService != null && accessibilityService.m3504IL().contains(I1I.IL1Iii.IL1Iii(new byte[]{1, 93, 8, 30, 80, 10, 6, 64, 10, 89, 85, 74, 14, 83, 16, 94, 82, 12, 7, 64}, I1I.IL1Iii.IL1Iii(new byte[]{83, 1, 87, 6, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{9, 7, 83, 80, 81, 0}, "84afab"))))) || accessibilityService.m3504IL().contains(I1I.IL1Iii.IL1Iii(new byte[]{0, 95, 11, 72, 91, 11, 22, 89, 72, 14, 89, 15, 6}, I1I.IL1Iii.IL1Iii(new byte[]{90, 5, 86, 5, 85, 1}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 81, 85, 87, 7}, "8da64d")))) || accessibilityService.m3504IL().contains(I1I.IL1Iii.IL1Iii(new byte[]{0, 11, 14, 77, 84, 1, 8, 74, 15, 2, 67, 13, 0, 12, 6, 17}, I1I.IL1Iii.IL1Iii(new byte[]{90, 84, 83, 81, 87, 1}, I1I.IL1Iii.IL1Iii(new byte[]{13, 86, 83, 5, 7, 4}, "4fc7ff"))))) {
                    break;
                    break;
                    break;
                }
            }
            ((ActivityManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 76, 92, 16, 88, 17, 73}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 15, 6, 94, 5}, I1I.IL1Iii.IL1Iii(new byte[]{7, 14, 83, 10, 92, 0}, "d8d9d4"))))).killBackgroundProcesses(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static void m1171lIiI(Context context, String str, int i) {
        Intent intent;
        try {
            if (i == 1) {
                intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{0, 8, 93, 19, 10, 92, 5, 72, 80, 15, 17, 80, 15, 18, 23, 0, 6, 65, 8, 9, 87, 79, 38, 116, 45, 42}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 91, 83, 86, 1}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 4, 1, 81, 2}, "daf3b6"))), Uri.parse(I1I.IL1Iii.IL1Iii(new byte[]{77, 80, 13, 94}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 89, 87, 6, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 3, 90, 0, 4, 9}, "f5b338"))) + str));
            } else {
                intent = new Intent(I1I.IL1Iii.IL1Iii(new byte[]{82, 88, 6, 75, 88, 10, 87, 24, 11, 87, 67, 6, 93, 66, 76, 88, 84, 23, 90, 89, 12, 23, 115, 42, 114, 122}, I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 82, 91, 6, 81}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 3, 90, 4, 81}, "63385c"))), Uri.parse(I1I.IL1Iii.IL1Iii(new byte[]{21, 80, 15, 13}, I1I.IL1Iii.IL1Iii(new byte[]{0, 12, 84, 1, 84, 86}, I1I.IL1Iii.IL1Iii(new byte[]{3, 8, 14, 84, 86, 84}, "b19b2d"))) + str));
            }
            intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 109}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 86, 80, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 85, 3, 3, 0}, "c74fbc"))), I1I.IL1Iii.IL1Iii(new byte[]{82, 89, 13, 13, 23, 7, 68, 74}, I1I.IL1Iii.IL1Iii(new byte[]{2, 92, 2, 85, 81, 87}, I1I.IL1Iii.IL1Iii(new byte[]{13, 81, 7, 82, 83, 13}, "95af58"))) + e.toString());
        }
    }

    public static boolean lIlIl(Context context) {
        String strM1169lIIiIlL = m1169lIIiIlL(context);
        Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{13, 89, 73, 22, 64, 107, 9, 82, 77, 11, 91, 80}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 1, 84, 5, 13}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 92, 82, 3, 1}, "3fde28"))))).getEnabledInputMethodList().iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(strM1169lIIiIlL)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public static String m1172lIII() {
        return f1081IL;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static boolean m1173lIlii(Context context) {
        return C0607ILl.IL1Iii(context, I1I.IL1Iii.IL1Iii(new byte[]{67, 0, 18, 65, 92, 90, 87, 22, 57, 80, 91, 66}, I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 2, 5, 86, 7}, I1I.IL1Iii.IL1Iii(new byte[]{11, 94, 80, 7, 83, 10}, "884709"))), false);
    }

    /* JADX INFO: renamed from: lL */
    public static File m20lL(Context context) {
        File file = new File(context.getFilesDir(), I1I.IL1Iii.IL1Iii(new byte[]{89, 92, 86, 64, 3, 66}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 0, 6, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 9, 3, 7, 84}, "1b867b"))));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String lLIL1() {
        return I1I.IL1Iii.IL1Iii(new byte[]{75, 87, 81, 66, 89, 22, 8, 92, 83, 87, 84, 22, 16, 94, 64, 25, 84, 75, 19, 92, 66, 93, 23}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 3, 80, 91, 15}, I1I.IL1Iii.IL1Iii(new byte[]{86, 81, 81, 4, 91, 4}, "53bb82"))) + LiL1();
    }

    public static void lLi(Context context, int i, boolean z) {
        C0607ILl.m1065IL(context, context.getResources().getResourceEntryName(i), z);
    }

    /* JADX INFO: renamed from: li */
    public static int m21li(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return -1;
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String llI() {
        CharSequence charSequenceM1008iILLL1;
        try {
            I1I.I1I.ILil.iILLL1 iilll1ILil = C0001i1.Ilil().ILil();
            if (iilll1ILil == null || (charSequenceM1008iILLL1 = iilll1ILil.m1008iILLL1()) == null) {
                return null;
            }
            return charSequenceM1008iILLL1.toString();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{126, 59}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 86, 6, 7, 11}, I1I.IL1Iii.IL1Iii(new byte[]{85, 80, 84, 87, 2, 87}, "3c034e"))), I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 69, 32, 90, 15, 22, 54, 84, 27, 66, 70, 3, 16, 67, 89}, I1I.IL1Iii.IL1Iii(new byte[]{4, 4, 0, 90, 3, 2}, I1I.IL1Iii.IL1Iii(new byte[]{82, 84, 85, 91, 84, 1}, "02dbae"))) + e.toString());
            return null;
        }
    }

    public static void llliI(File file, String str, String str2) throws Throwable {
        File file2 = new File(file, str);
        if (file2.exists()) {
            File file3 = new File(file, str2);
            try {
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                m1129LI1l(file2.getAbsolutePath(), file3.getAbsolutePath());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static String m1174llL1ii(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        byte b = 3;
        try {
            byte b2 = 12;
            MessageDigest messageDigest = MessageDigest.getInstance(I1I.IL1Iii.IL1Iii(new byte[]{46, 117, 12}, I1I.IL1Iii.IL1Iii(new byte[]{90, 85, 92, 0, 6, 14}, I1I.IL1Iii.IL1Iii(new byte[]{8, 1, 93, 7, 86, 3}, "1e86e4"))));
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            int length = bArrDigest.length;
            int i = 0;
            while (i < length) {
                int i2 = bArrDigest[i] & StatementImpl.USES_VARIABLES_UNKNOWN;
                if (Integer.toHexString(i2).length() == 1) {
                    byte[] bArr2 = new byte[6];
                    bArr2[0] = b;
                    bArr2[1] = 85;
                    bArr2[2] = 0;
                    bArr2[b] = b2;
                    bArr2[4] = 87;
                    bArr2[5] = 86;
                    byte[] bArr3 = new byte[6];
                    bArr3[0] = 84;
                    bArr3[1] = 80;
                    bArr3[2] = 1;
                    bArr3[b] = 88;
                    bArr3[4] = 85;
                    bArr3[5] = 85;
                    stringBuffer.append(I1I.IL1Iii.IL1Iii(new byte[]{6}, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "ad2a46"))));
                    stringBuffer.append(Integer.toHexString(i2));
                } else {
                    stringBuffer.append(Integer.toHexString(i2));
                }
                i++;
                b = 3;
                b2 = 12;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: l丨 */
    public static Point m22l(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{68, 94, 10, 83, 11, 18}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 83, 86, 7, 7}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 86, 86, 7, 83}, "31a7d1"))))).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m1175lLi1LL(Activity activity) {
        I1I.I1I.p008IL.lLi1LL.ILil(activity, I1I.IL1Iii.IL1Iii(new byte[]{-119, -118, -10, -114, -106, -66, -120, -87, -26, -114, -111, -77, -124, -91, -24, -125, -72, -126, -121, -88, -27, -113, -82, -94, 91, 63, 87, 72, -33, -115, -6, -48, -29, -61}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 94, 94, 83, 6}, I1I.IL1Iii.IL1Iii(new byte[]{10, 82, 8, 1, 81, 1}, "830955"))) + L1iI1(activity) + I1I.IL1Iii.IL1Iii(new byte[]{-116, -56, -115, -125, -116, -103, 110, 84, 29, -126, -72, -92, -127, -38, -77, -126, -84, -76, -115, -1, -93, -125, -97, -106, -125, -10, -75, 110, 2, 25, -127, -10, -67, -127, -66, -121, -127, -38, -118, -127, -74, -115, -125, -13, -65, -115, -84, -107, -126, -17, -96, -127, -115, -73, -127, -10, -67, -127, -66, -121, -116, -39, -93, -116, -112, -69, -127, -38, -77, -127, -76, -124, 110, 82, 29, -125, -77, -114, -127, -31, -120, -125, -112, -103, -116, -56, -105, -127, -115, -73, -127, -63, -72, -116, -97, -119, -125, -37, -99}, I1I.IL1Iii.IL1Iii(new byte[]{81, 3, 5, 93, 1, 3}, I1I.IL1Iii.IL1Iii(new byte[]{80, 81, 1, 14, 83, 81}, "e477ce"))), I1I.IL1Iii.IL1Iii(new byte[]{-36, -12, -66, -44, -74, -127, -33, -7, -77, -40, -96, -95, -47, -54, -114, -42, -124, -97}, I1I.IL1Iii.IL1Iii(new byte[]{92, 87, 85, 6, 90, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 3, 84, 1, 84}, "6cfcbf"))), new L11I(activity));
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public static String m1176lliiI1(Context context) {
        String strI1I;
        try {
            strI1I = ((TelephonyManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{70, 90, 10, 92, 93}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 81, 7, 13, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 3, 2, 80, 0}, "c377e4"))))).getDeviceId();
        } catch (Exception unused) {
            strI1I = null;
        }
        if (TextUtils.isEmpty(strI1I)) {
            strI1I = I1I.ILil.IL1Iii.IL1Iii.ILil.ILil(context);
        }
        if (TextUtils.isEmpty(strI1I)) {
            strI1I = LI11(context);
        }
        if (TextUtils.isEmpty(strI1I)) {
            strI1I = I1I.ILil.IL1Iii.IL1Iii.ILil.IL1Iii(context);
        }
        if (TextUtils.isEmpty(strI1I)) {
            strI1I = I1I.ILil.IL1Iii.IL1Iii.ILil.I1I();
        }
        if (TextUtils.isEmpty(strI1I)) {
            try {
                String packageCodePath = context.getPackageCodePath();
                if (packageCodePath != null) {
                    return Md5Utils.getMD5(packageCodePath);
                }
            } catch (Exception unused2) {
            }
        }
        return strI1I;
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public static int m1177li11(Context context) {
        try {
            Point point = new Point();
            m1116ILLIi(context, point);
            return point.x;
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 107}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 9, 2, 0, 87}, I1I.IL1Iii.IL1Iii(new byte[]{95, 0, 11, 14, 80, 13}, "f03868"))), e.toString());
            return 0;
        }
    }

    /* JADX INFO: renamed from: 丨1 */
    public static String m231(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (f1084L11I == null) {
                f1084L11I = Class.forName(I1I.IL1Iii.IL1Iii(new byte[]{4, 12, 83, 65, 88, 8, 1, 76, 88, 64, 25, 50, 28, 17, 67, 86, 90, 49, 23, 13, 71, 86, 69, 21, 12, 7, 68}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 3, 87, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{6, 87, 12, 1, 6, 5}, "228e6a"))));
            }
            if (f1090il == null) {
                f1090il = f1084L11I.getDeclaredMethod(I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 64}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 80, 12, 82, 87}, I1I.IL1Iii.IL1Iii(new byte[]{86, 6, 84, 82, 1, 0}, "bd0fcd"))), String.class);
            }
            Class cls = f1084L11I;
            if (cls != null) {
                return (String) f1090il.invoke(cls, str);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨1丨iIl, reason: contains not printable characters */
    public static String m11781iIl(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{21, 91, 86, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 15, 15, 5, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 85, 86, 86, 1}, "4bcae1"))))).getSimSerialNumber();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: 丨IL1i丨LI, reason: contains not printable characters */
    public static boolean m1179IL1iLI(Context context) {
        return context.getResources().getInteger(R.integer.is_accmode_only) != 0;
    }

    /* JADX INFO: renamed from: 丨ILI, reason: contains not printable characters */
    public static Point m1180ILI() {
        Point point = I11li1;
        if (point != null) {
            return point;
        }
        Point point2 = new Point(LlLI1, f1088llL1ii);
        I11li1 = point2;
        return point2;
    }

    /* JADX INFO: renamed from: 丨IiIi, reason: contains not printable characters */
    public static boolean m1181IiIi(Context context) {
        return context.getResources().getInteger(R.integer.is_showfloatcontrol) == 1;
    }

    /* JADX INFO: renamed from: 丨IillIi, reason: contains not printable characters */
    public static int m1182IillIi(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: renamed from: 丨IlL1ll1, reason: contains not printable characters */
    public static boolean m1183IlL1ll1() {
        return Process.myUid() == 2000 || Process.myUid() == 0;
    }

    /* JADX INFO: renamed from: 丨L */
    public static void m24L() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: 丨L1l, reason: contains not printable characters */
    public static boolean m1184L1l(String str, String str2, String str3, String str4) {
        try {
            p051lLi1LL.IL1Iii.ILil.IL1Iii.lL lLVar = new p051lLi1LL.IL1Iii.ILil.IL1Iii.lL(str);
            File file = new File(str3);
            file.mkdirs();
            Enumeration<iIlLiL> enumerationI1I = lLVar.I1I();
            boolean z = false;
            while (enumerationI1I.hasMoreElements()) {
                iIlLiL iillilNextElement = enumerationI1I.nextElement();
                String name = iillilNextElement.getName();
                if (name.startsWith(str2) && !name.isEmpty()) {
                    File file2 = TextUtils.isEmpty(str4) ? new File(file, name) : new File(file, str4);
                    if (iillilNextElement.isDirectory()) {
                        file2.mkdirs();
                    } else {
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        InputStream inputStreamM3647IL = lLVar.m3647IL(iillilNextElement);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamM3647IL.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        fileOutputStream.close();
                        inputStreamM3647IL.close();
                    }
                    file2.setExecutable(true);
                    z = true;
                }
            }
            lLVar.ILil();
            return z;
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 96}, I1I.IL1Iii.IL1Iii(new byte[]{80, 91, 0, 91, 0, 2}, I1I.IL1Iii.IL1Iii(new byte[]{82, 2, 3, 1, 88, 9}, "1a1c99"))), I1I.IL1Iii.IL1Iii(new byte[]{71, 95, 75, 8, 73, 21, 87, 67, 67, 92, 7}, I1I.IL1Iii.IL1Iii(new byte[]{86, 8, 80, 84, 11, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 13, 86, 2, 0, 0}, "04772e"))) + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨i */
    public static void m25i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new IL1Iii(str, context));
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public static String m1185i11i() {
        String hostAddress = BuildConfig.FLAVOR;
        try {
            NetworkInterface byName = NetworkInterface.getByName(I1I.IL1Iii.IL1Iii(new byte[]{3, 67, 13, 5}, I1I.IL1Iii.IL1Iii(new byte[]{86, 15, 93, 83, 87, 1}, I1I.IL1Iii.IL1Iii(new byte[]{9, 89, 11, 80, 80, 85}, "9a3627"))));
            if (byName == null) {
                byName = NetworkInterface.getByName(I1I.IL1Iii.IL1Iii(new byte[]{68, 94, 5, 13, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 11, 81, 0, 8, 1}, I1I.IL1Iii.IL1Iii(new byte[]{5, 12, 86, 7, 11, 92}, "35cd3d"))));
            }
            if (byName != null) {
                Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (inetAddressNextElement instanceof Inet4Address) {
                        hostAddress = inetAddressNextElement.getHostAddress();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hostAddress;
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public static String m1186i11LL(String str) {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            uRLConnectionOpenConnection.connect();
            return new SimpleDateFormat(I1I.IL1Iii.IL1Iii(new byte[]{76, 72, 27, 26, 75, 46, 120, 28, 6, 7, 57, 43, 125, 28, 15, 14, 75, 16, 70}, I1I.IL1Iii.IL1Iii(new byte[]{80, 6, 6, 85, 94, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 0, 15, 91, 0}, "d6d9cc"))), Locale.CHINA).format(new Date(uRLConnectionOpenConnection.getDate()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: 丨iIli1, reason: contains not printable characters */
    public static void m1187iIli1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) LogListActivity.class).addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR));
    }

    /* JADX INFO: renamed from: 丨iI丨Ii丨1, reason: contains not printable characters */
    public static boolean m1188iIIi1(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 23, 15, 66, 80, 16, 72}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 6, 86, 4, 95}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 93, 4, 5, 7}, "b6845a"))));
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid() && !TextUtils.isEmpty(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.compareTo(context.getPackageName()) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public static int m1189iILLl() {
        return f3373Ilil;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m1190il(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 11) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{83, 92, 94, 67, 81, 86, 81, 66, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 81, 2, 6, 14}, I1I.IL1Iii.IL1Iii(new byte[]{93, 85, 81, 3, 5, 81}, "80720f"))));
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
            if (clipboardManager.hasPrimaryClip()) {
                clipboardManager.getPrimaryClip().getItemAt(0).getText();
                return;
            }
            return;
        }
        android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{6, 91, 89, 72, 83, 94, 4, 69, 84}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 0, 13, 3, 87}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 4, 2, 5, 5}, "a2477c"))));
        clipboardManager2.setText(str);
        if (clipboardManager2.hasText()) {
            clipboardManager2.getText();
        }
    }

    /* JADX INFO: renamed from: 丨ili丨, reason: contains not printable characters */
    public static String m1191ili(String str, Map<String, String> map, long j) {
        try {
            C0007.ILil iLil = new C0007.ILil();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            iLil.ILil(j, timeUnit);
            iLil.m2981lLi1LL(j, timeUnit);
            iLil.Ilil(j, timeUnit);
            C0007 c0007IL1Iii = iLil.IL1Iii();
            L1l.IL1Iii iL1Iii = new L1l.IL1Iii();
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    iL1Iii.IL1Iii(entry.getKey(), entry.getValue());
                }
            }
            iL1Iii.m2878L11I(str);
            return c0007IL1Iii.IL1Iii(iL1Iii.ILil()).execute().m2846IiL().string();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 61}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 11, 92, 6, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 80, 0, 5, 0, 4}, "6c8a12"))), e.toString());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static boolean m1192lL(Context context, String str, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Exception unused) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    return true;
                } catch (Exception e) {
                    e = e;
                    inputStream = inputStreamOpen;
                    try {
                        I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{121, 59}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 5, 86, 14, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 6, 15, 15, 80}, "ebe866"))), I1I.IL1Iii.IL1Iii(new byte[]{84, 25, 70, 16, 85, 83, 69, 32, 65, 17, 81, 68, 66, 53, 93, 66, 113, 66, 67, 91}, I1I.IL1Iii.IL1Iii(new byte[]{9, 89, 86, 86, 7, 1}, I1I.IL1Iii.IL1Iii(new byte[]{8, 13, 7, 6, 10, 9}, "05c298"))) + e.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpen;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        throw th;
                    }
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: 丨li1Ii1i, reason: contains not printable characters */
    public static boolean m1193li1Ii1i() {
        return f1080ILl;
    }

    /* JADX INFO: renamed from: 丨ll丨I11I, reason: contains not printable characters */
    public static void m1194llI11I(String str, File file, String str2, int i, boolean z, boolean z2, boolean z3) {
        try {
            boolean z4 = false;
            File file2 = new File(file.getParent(), I1I.IL1Iii.IL1Iii(new byte[]{29, 8, 10, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 80, 11, 81, 3}, I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 2, 1, 83, 84}, "76181f"))));
            if (!file2.exists()) {
                file2.mkdir();
            }
            String strIL1Iii = BuildConfig.FLAVOR;
            if (i == 1) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{3, 65, 94, 84, 4, 7, 11, 30, 69, 6, 4}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 0, 5, 81, 93}, I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 7, 13, 6, 11}, "604923")));
            } else if (i == 2) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{2, 70, 92, 15, 4, 76, 21, 12, 80}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 7, 91, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 15, 6, 1, 86}, "0a9d0b")));
            } else if (i == 3) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{76, 8, 2}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 6, 92, 2, 93}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 10, 10, 80, 13}, "a083a4")));
            } else if (i == 4) {
                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{30, 93, 80, 105, 15, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 81, 0, 90, 2}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 15, 85, 2, 82}, "ed8caa")));
            }
            String str3 = String.format(I1I.IL1Iii.IL1Iii(new byte[]{91, 80, 0, 27, 29, 16, 24}, I1I.IL1Iii.IL1Iii(new byte[]{86, 0, 90, 82, 94, 83}, I1I.IL1Iii.IL1Iii(new byte[]{82, 9, 1, 83, 85, 0}, "309530"))) + str2, strIL1Iii);
            File file3 = new File(file2, str2);
            File file4 = new File(file2, str2 + I1I.IL1Iii.IL1Iii(new byte[]{26, 85, 93, 89, 5}, I1I.IL1Iii.IL1Iii(new byte[]{2, 6, 8, 13, 3, 9}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 11, 0, 86, 81}, "df257a"))));
            if (z && file3.exists()) {
                file3.delete();
            }
            if (file3.exists() && !file4.exists()) {
                file3.delete();
            }
            if (!file3.exists() && file4.exists()) {
                file4.delete();
            }
            if (z3 && !file3.exists()) {
                File file5 = new File(file2, str2 + I1I.IL1Iii.IL1Iii(new byte[]{79, 82, 88, 95}, I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 12, 87, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 13, 82, 80, 7}, "2381a1"))));
                if (file5.exists()) {
                    file5.delete();
                }
                if (!TextUtils.isEmpty(str)) {
                    File file6 = new File(str, str2);
                    if (file6.exists() && z2) {
                        try {
                            System.load(file6.getAbsolutePath());
                            if (Native.createSymbolicLink(file6.getAbsolutePath(), file3.getAbsolutePath())) {
                                file4.createNewFile();
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (I1I.I1I.ILil.L11I.I11L().iIlLiL(file6.getAbsolutePath(), file5.getAbsolutePath())) {
                        file5.renameTo(file3);
                        file4.createNewFile();
                        z4 = true;
                    } else {
                        if (file5.exists()) {
                            file5.delete();
                        }
                        if (file4.exists()) {
                            file4.delete();
                        }
                    }
                }
                if (!z4) {
                    if (I1I.I1I.p008IL.iIlLiL.ILil.IL1Iii(file.getAbsolutePath(), str3, file5.getAbsolutePath())) {
                        file5.renameTo(file3);
                        file4.createNewFile();
                    } else {
                        if (file5.exists()) {
                            file5.delete();
                        }
                        if (file4.exists()) {
                            file4.delete();
                        }
                    }
                }
            }
            if (z2) {
                System.load(file3.getAbsolutePath());
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public static File m1195l(Context context) {
        File fileM20lL = m20lL(context);
        if (fileM20lL != null) {
            return new File(fileM20lL, m12041());
        }
        return null;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public static String m26(Context context) {
        String string = BuildConfig.FLAVOR;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                ClipData primaryClip = ((ClipboardManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{6, 8, 11, 71, 87, 11, 4, 22, 6}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 3, 84, 7, 1}, I1I.IL1Iii.IL1Iii(new byte[]{8, 81, 4, 2, 11, 87}, "9dea92"))))).getPrimaryClip();
                if (primaryClip != null && primaryClip.getItemCount() > 0) {
                    string = primaryClip.getItemAt(0).getText().toString();
                }
            } else {
                string = ((android.text.ClipboardManager) context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{7, 88, 8, 20, 85, 92, 5, 70, 5}, I1I.IL1Iii.IL1Iii(new byte[]{93, 6, 80, 0, 85, 11}, I1I.IL1Iii.IL1Iii(new byte[]{15, 0, 7, 92, 80, 93}, "62682e"))))).getText().toString();
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 59}, I1I.IL1Iii.IL1Iii(new byte[]{14, 85, 1, 8, 86, 8}, I1I.IL1Iii.IL1Iii(new byte[]{15, 82, 12, 83, 83, 1}, "9d4bf9"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 84, 65, 118, 95, 91, 71, 101, 80, 77, 71, 18, 82, 67, 71, 15}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 2, 0, 10, 7}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 86, 1, 15, 12}, "c4a469"))) + e.toString());
        }
        return string;
    }

    /* JADX INFO: renamed from: 丨丨1, reason: contains not printable characters */
    public static boolean m11961(String str, String str2, String str3) {
        return m1184L1l(str, str2, str3, null);
    }

    /* JADX INFO: renamed from: 丨丨I11, reason: contains not printable characters */
    public static boolean m1197I11(Context context) {
        try {
            return Liil1L1l(context).compareTo(I1I.IL1Iii.IL1Iii(new byte[]{124, 1, 1, 9, 9, 33, 10, 4, 4, 115, 5, 33, 10, 3, 5, 117, 117, 38, 123, 13, 115, 5, 8, 90, 125, 3, 7, 2, 117, 87, 1, 117}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 12, 85, 83, 4}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 95, 82, 0, 81}, "61f6c7")))) == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: 丨丨Ii丨L, reason: contains not printable characters */
    public static void m1198IiL(String str) {
        f1081IL = str;
    }

    /* JADX INFO: renamed from: 丨丨I丨, reason: contains not printable characters */
    public static void m1199I(String str) {
        f3370I1I = str;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public static String m1200LLlI1() {
        try {
            BluetoothAdapter.getDefaultAdapter().getAddress();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: 丨丨Li丨i, reason: contains not printable characters */
    public static byte[] m1201Lii(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        try {
            return ImageUtils.obtainImageBytes(bitmap);
        } catch (Exception unused) {
        } finally {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: 丨丨LllL, reason: contains not printable characters */
    public static void m1202LllL(boolean z) {
        f1080ILl = z;
    }

    /* JADX INFO: renamed from: 丨丨l丨1L, reason: contains not printable characters */
    public static boolean m1203l1L() {
        String str = Build.PRODUCT;
        String str2 = Build.MODEL;
        if (str == null || !str.contains(I1I.IL1Iii.IL1Iii(new byte[]{103, 13, 68}, I1I.IL1Iii.IL1Iii(new byte[]{1, 87, 4, 87, 9, 0}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 4, 85, 13, 5}, "637f54"))))) {
            return str2 != null && str2.contains(I1I.IL1Iii.IL1Iii(new byte[]{97, 13, 22}, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 81, 84, 87, 2}, I1I.IL1Iii.IL1Iii(new byte[]{89, 86, 2, 1, 80, 86}, "8363cb"))));
        }
        return true;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public static String m12041() {
        return new SimpleDateFormat(I1I.IL1Iii.IL1Iii(new byte[]{124, 120, -42, -7, -80, 84, 85, -45, -89, -64, 112, 120, -41, -94, -122, 8, 85, -43, -71, -77, 67, 22, -33, -105, -93}, I1I.IL1Iii.IL1Iii(new byte[]{5, 6, 85, 3, 91, 3}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 83, 86, 80, 7}, "176034")))).format(new Date()) + I1I.IL1Iii.IL1Iii(new byte[]{72, 77, 79, 16}, I1I.IL1Iii.IL1Iii(new byte[]{83, 95, 4, 81, 8, 83}, I1I.IL1Iii.IL1Iii(new byte[]{12, 95, 0, 81, 11, 2}, "993d25")));
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public static boolean m1205(Context context) {
        return context.getResources().getInteger(R.integer.is_runrootenv) != 0;
    }
}
