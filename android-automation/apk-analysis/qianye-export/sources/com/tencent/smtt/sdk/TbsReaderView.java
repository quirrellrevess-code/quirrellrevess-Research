package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";

    /* JADX INFO: renamed from: f */
    public static boolean f372f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";

    /* JADX INFO: renamed from: a */
    public Context f373a;

    /* JADX INFO: renamed from: b */
    public ReaderWizard f374b;

    /* JADX INFO: renamed from: c */
    public Object f375c;

    /* JADX INFO: renamed from: d */
    public ReaderCallback f376d;

    /* JADX INFO: renamed from: e */
    public ReaderCallback f377e;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) throws RuntimeException {
        super(context.getApplicationContext());
        this.f373a = null;
        this.f374b = null;
        this.f375c = null;
        this.f376d = null;
        this.f377e = null;
        throw new IllegalAccessError("Current SDK not support TbsReaderView.");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m240a(Context context) {
        if (!f372f) {
            C0412f.m323a(true).m329a(context.getApplicationContext(), true, false);
            f372f = C0412f.m323a(false).m331b();
        }
        return f372f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        if (m240a(context)) {
            return ReaderWizard.getResDrawable(i);
        }
        return null;
    }

    public static String getResString(Context context, int i) {
        return m240a(context) ? ReaderWizard.getResString(i) : BuildConfig.FLAVOR;
    }

    public static boolean isSupportExt(Context context, String str) {
        return m240a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str);
    }

    /* JADX INFO: renamed from: a */
    public boolean m241a() {
        try {
            if (this.f374b == null) {
                this.f374b = new ReaderWizard(this.f377e);
            }
            if (this.f375c == null) {
                this.f375c = this.f374b.getTbsReader();
            }
            Object obj = this.f375c;
            if (obj != null) {
                return this.f374b.initTbsReader(obj, this.f373a);
            }
            return false;
        } catch (NullPointerException unused) {
            Log.e(TAG, "Unexpect null object!");
            return false;
        }
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        Object obj3;
        ReaderWizard readerWizard = this.f374b;
        if (readerWizard == null || (obj3 = this.f375c) == null) {
            return;
        }
        readerWizard.doCommand(obj3, num, obj, obj2);
    }

    public boolean downloadPlugin(String str) {
        Object obj = this.f375c;
        if (obj != null) {
            return this.f374b.checkPlugin(obj, this.f373a, str, true);
        }
        Log.e(TAG, "downloadPlugin failed!");
        return false;
    }

    public void onSizeChanged(int i, int i2) {
        Object obj;
        ReaderWizard readerWizard = this.f374b;
        if (readerWizard == null || (obj = this.f375c) == null) {
            return;
        }
        readerWizard.onSizeChanged(obj, i, i2);
    }

    public void onStop() {
        ReaderWizard readerWizard = this.f374b;
        if (readerWizard != null) {
            readerWizard.destroy(this.f375c);
            this.f375c = null;
        }
        this.f373a = null;
        f372f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.f375c == null || bundle == null) {
            Log.e(TAG, "init failed!");
            return;
        }
        bundle.putBoolean("browser6.0", MttLoader.isBrowserInstalledEx(this.f373a) | (!MttLoader.isBrowserInstalled(this.f373a)));
        bundle.putBoolean("browser6.1", MttLoader.isGreatBrowserVer(this.f373a, 6101625L, 610000L) | (!MttLoader.isBrowserInstalled(this.f373a)));
        if (this.f374b.openFile(this.f375c, this.f373a, bundle, this)) {
            return;
        }
        Log.e(TAG, "OpenFile failed!");
    }

    public boolean preOpen(String str, boolean z) {
        if (!isSupportExt(this.f373a, str)) {
            Log.e(TAG, "not supported by:" + str);
            return false;
        }
        boolean zM240a = m240a(this.f373a);
        if (!zM240a) {
            return zM240a;
        }
        boolean zM241a = m241a();
        if (z && zM241a) {
            return this.f374b.checkPlugin(this.f375c, this.f373a, str, Apn.getApnType(this.f373a) == 3);
        }
        return zM241a;
    }

    public void userStatistics(String str) {
        ReaderWizard readerWizard = this.f374b;
        if (readerWizard != null) {
            readerWizard.userStatistics(this.f375c, str);
        }
    }
}
