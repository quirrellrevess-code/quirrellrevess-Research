package com.p000nx.assist;

import I1I.I1I.ILil.iIilII1;
import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.C0610il;
import I1I.I1I.p008IL.lIlii;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.flexbox.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.p000nx.assist.p002ui.ViewOnClickListenerC0318UI;
import com.p000nx.assist.p002ui.Window;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class UIMgr {
    private static final UIMgr sUiMgr = new UIMgr();
    private Context context = null;
    private Map<Integer, Window> mWindows = new HashMap();
    private WindowManager mWindowManager = null;
    private LayoutInflater mInflater = null;

    public class I1I implements Callable<String> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f5390IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5391ILil;

        public I1I(String str, int i) {
            this.f5390IL1Iii = str;
            this.f5391ILil = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            try {
                JSONObject jSONObject = new JSONObject(this.f5390IL1Iii);
                int i = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{73, 2, 86, 80}, I1I.IL1Iii.IL1Iii(new byte[]{95, 81, 82, 0, 13, 82}, I1I.IL1Iii.IL1Iii(new byte[]{95, 86, 82, 13, 6, 5}, "9d1832"))));
                String string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{11, 93}, I1I.IL1Iii.IL1Iii(new byte[]{6, 12, 7, 81, 81, 86}, I1I.IL1Iii.IL1Iii(new byte[]{93, 2, 86, 2, 7, 84}, "974ae1"))));
                String string2 = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{8, 86, 68, 13, 13, 5}, I1I.IL1Iii.IL1Iii(new byte[]{80, 11, 9, 7, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{13, 8, 15, 90, 6, 3}, "8068e7"))));
                Window window = (Window) UIMgr.this.mWindows.get(Integer.valueOf(this.f5391ILil));
                if (window == null || window.getParent() == null) {
                    return null;
                }
                return window.getUI().getUIValue(string2, i, string);
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 96}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 2, 7, 81, 7}, I1I.IL1Iii.IL1Iii(new byte[]{3, 15, 85, 0, 5, 86}, "f7371d"))), e.toString());
                return null;
            }
        }
    }

    public class IL1Iii extends TypeToken<Map<String, Map<String, String>>> {
        public IL1Iii(UIMgr uIMgr) {
        }
    }

    public class ILil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ boolean f5392I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5393ILil;

        public ILil(int i, boolean z) {
            this.f5393ILil = i;
            this.f5392I1I = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{89, 80, 93, 91, 79, 7, 91, 95, 82, 92, 6}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 12, 13, 83, 1}, I1I.IL1Iii.IL1Iii(new byte[]{87, 92, 94, 90, 5, 86}, "a9fb73")));
            Window window = (Window) UIMgr.this.mWindows.get(Integer.valueOf(this.f5393ILil));
            String strIL1Iii2 = BuildConfig.FLAVOR;
            if (window != null && window.getParent() != null) {
                if (this.f5392I1I) {
                    strIL1Iii2 = window.getResult();
                    String configName = window.getConfigName();
                    if (!TextUtils.isEmpty(configName)) {
                        strIL1Iii = configName;
                    }
                }
                UIMgr.this.mWindowManager.removeView(window);
            }
            if (window != null) {
                UIMgr.this.mWindows.remove(window);
            }
            if (TextUtils.isEmpty(strIL1Iii2)) {
                strIL1Iii2 = I1I.IL1Iii.IL1Iii(new byte[]{75, 76}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 84, 7, 84, 81}, I1I.IL1Iii.IL1Iii(new byte[]{82, 84, 81, 87, 5, 3}, "ae2aa6")));
            }
            if (this.f5392I1I) {
                lIlii.I1i(strIL1Iii2, l1IIi1.I1I().m1018L11I(strIL1Iii).getAbsolutePath());
            }
            UIMgr.this.sendEventWithString(this.f5393ILil, 105, strIL1Iii2);
        }
    }

    /* JADX INFO: renamed from: com.nx.assist.UIMgr$I丨L, reason: invalid class name */
    public class IL implements Callable<String> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f5395IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5396ILil;

        public IL(String str, int i) {
            this.f5395IL1Iii = str;
            this.f5396ILil = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            try {
                JSONObject jSONObject = new JSONObject(this.f5395IL1Iii);
                int i = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{22, 87, 95, 93}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 9, 91, 4, 0}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 1, 86, 5, 85}, "5f054c"))));
                String string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{88, 82}, I1I.IL1Iii.IL1Iii(new byte[]{3, 85, 7, 84, 3, 8}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 2, 5, 85, 7}, "d6fcf6"))));
                String string2 = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{89, 4, 65, 81, 88, 93}, I1I.IL1Iii.IL1Iii(new byte[]{5, 89, 3, 90, 2, 14}, I1I.IL1Iii.IL1Iii(new byte[]{6, 9, 14, 82, 13, 1}, "718186"))));
                String string3 = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{66, 86, 90, 19, 4}, I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 4, 95, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{5, 5, 5, 0, 81, 4}, "6c7957"))));
                Window window = (Window) UIMgr.this.mWindows.get(Integer.valueOf(this.f5396ILil));
                if (window != null && window.getParent() != null) {
                    window.getUI().setUIValue(string2, i, string, string3);
                }
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 61}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 82, 4, 15, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 4, 88, 91, 85}, "23e9bc"))), e.toString());
            }
            return I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{13, 3, 86, 83, 12, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 89, 83, 13, 0, 6}, "886851")));
        }
    }

    /* JADX INFO: renamed from: com.nx.assist.UIMgr$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5397I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public View f5398ILil;

        public /* synthetic */ iILLL1(UIMgr uIMgr, int i, View view, IL1Iii iL1Iii) {
            this(i, view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f5398ILil.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((Window) this.f5398ILil).setValOnFlate();
            UIMgr.this.sendEventWithString(this.f5397I1I, 100, BuildConfig.FLAVOR);
        }

        public iILLL1(int i, View view) {
            this.f5398ILil = view;
            this.f5397I1I = i;
        }
    }

    /* JADX INFO: renamed from: com.nx.assist.UIMgr$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f5399I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5400ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ int f5401Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f2938IL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final /* synthetic */ ViewOnClickListenerC0318UI f2940iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ int f2941lLi1LL;

        public lLi1LL(int i, int i2, int i3, int i4, int i5, ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) {
            this.f5400ILil = i;
            this.f5399I1I = i2;
            this.f2938IL = i3;
            this.f5401Ilil = i4;
            this.f2941lLi1LL = i5;
            this.f2940iILLL1 = viewOnClickListenerC0318UI;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                UIMgr.this.showUI(this.f5400ILil, this.f5399I1I, this.f2938IL, this.f5401Ilil, this.f2941lLi1LL, this.f2940iILLL1);
            } catch (Exception unused) {
            }
        }
    }

    public static UIMgr getInstance() {
        return sUiMgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUI(int i, int i2, int i3, int i4, int i5, ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) throws Exception {
        Window window;
        IL1Iii iL1Iii = null;
        try {
            window = (Window) viewOnClickListenerC0318UI.inflateView(lIlii.LL1IL());
        } catch (Exception e) {
            e.printStackTrace();
            window = null;
        }
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.format = 1;
            layoutParams.flags = 32;
            int i6 = 0;
            if (i2 >= 0 || i3 >= 0) {
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i3 < 0) {
                    i3 = 0;
                }
                layoutParams.gravity = 51;
                i6 = i2;
            } else {
                layoutParams.gravity = 17;
                i3 = 0;
            }
            if (i4 == -100 && i5 == -100) {
                i4 = viewOnClickListenerC0318UI.getAttribInt(I1I.IL1Iii.IL1Iii(new byte[]{20, 81, 83, 16, 89}, I1I.IL1Iii.IL1Iii(new byte[]{87, 90, 85, 81, 80, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 91, 86, 81, 80, 82}, "b94d14"))), i4);
                i5 = viewOnClickListenerC0318UI.getAttribInt(I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 15, 2, 81, 65}, I1I.IL1Iii.IL1Iii(new byte[]{10, 81, 82, 6, 12, 83}, I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 82, 81, 1, 81}, "12f247"))), i5);
            }
            Point pointM1123IIi = lIlii.m1123IIi(lIlii.LL1IL());
            if (i4 > pointM1123IIi.x) {
                i4 = -1;
            }
            if (i5 > pointM1123IIi.y) {
                i5 = -1;
            }
            layoutParams.x = i6;
            layoutParams.y = i3;
            layoutParams.width = i4;
            layoutParams.height = i5;
            window.getViewTreeObserver().addOnGlobalLayoutListener(new iILLL1(this, i, window, iL1Iii));
            this.mWindowManager.addView(window, layoutParams);
            this.mWindows.put(Integer.valueOf(i), window);
        }
    }

    public void begin() {
    }

    public boolean close(int i, boolean z) {
        lIlii.LIlIlIL(new ILil(i, z));
        return false;
    }

    public void finish() {
        Iterator<Map.Entry<Integer, Window>> it = this.mWindows.entrySet().iterator();
        while (it.hasNext()) {
            Window value = it.next().getValue();
            if (value != null && value.getParent() != null) {
                this.mWindowManager.removeView(value);
            }
            it.remove();
        }
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public String getUIConfig(String str) {
        try {
            return lIlii.l11(l1IIi1.I1I().m1018L11I(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getUIValue(int i, String str) {
        return (String) new C0610il().ILil(new I1I(str, i));
    }

    public void init(Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mWindowManager = (WindowManager) this.context.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{79, 8, 89, 6, 12, 65}, I1I.IL1Iii.IL1Iii(new byte[]{94, 81, 85, 7, 82, 15}, I1I.IL1Iii.IL1Iii(new byte[]{84, 8, 91, 87, 87, 10}, "2892f3"))));
    }

    public Map<String, Map<String, String>> loadUIConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            str = I1I.IL1Iii.IL1Iii(new byte[]{95, 89, 91, 11, 23, 85, 93, 86, 84, 12, 94}, I1I.IL1Iii.IL1Iii(new byte[]{10, 12, 87, 7, 10, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 86, 80, 6, 82, 0}, "8b5dae")));
        }
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        try {
            File fileM1018L11I = l1IIi1.I1I().m1018L11I(str);
            if (!fileM1018L11I.exists()) {
                return map;
            }
            return (Map) new Gson().fromJson(lIlii.l11(fileM1018L11I), new IL1Iii(this).getType());
        } catch (Exception unused) {
            return map;
        }
    }

    public ViewOnClickListenerC0318UI parseUI(String str, int i) {
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            char c = 0;
            byte b = 21;
            xmlPullParserNewPullParser.setFeature(I1I.IL1Iii.IL1Iii(new byte[]{9, 67, 71, 21, 95, 75, 78, 79, 94, 9, 21, 17, 13, 91, 29, 10, 23, 3, 78, 65, 2, 74, 1, 11, 2, 24, 85, 0, 4, 16, 20, 69, 86, 22, 75, 12, 21, 90, 95, 70, 21, 22, 14, 84, 86, 22, 22, 73, 15, 86, 94, 0, 22, 20, 0, 84, 86, 22}, I1I.IL1Iii.IL1Iii(new byte[]{85, 82, 82, 92, 83, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 0, 1, 5, 93}, "f0a839"))), false);
            byte b2 = 80;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(str.getBytes(I1I.IL1Iii.IL1Iii(new byte[]{98, 97, 112, 72, 13}, I1I.IL1Iii.IL1Iii(new byte[]{83, 87, 14, 81, 87, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 80, 94, 4, 0, 80}, "52f0be"))))), I1I.IL1Iii.IL1Iii(new byte[]{20, 64, 5, 20, 91}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 83, 9, 82, 2}, I1I.IL1Iii.IL1Iii(new byte[]{3, 85, 5, 7, 9, 80}, "105781"))));
            int eventType = xmlPullParserNewPullParser.getEventType();
            ViewOnClickListenerC0318UI parent = null;
            ViewOnClickListenerC0318UI viewOnClickListenerC0318UI = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParserNewPullParser.getName();
                    ViewOnClickListenerC0318UI viewOnClickListenerC0318UI2 = new ViewOnClickListenerC0318UI(xmlPullParserNewPullParser, i);
                    byte[] bArr = new byte[6];
                    bArr[c] = 52;
                    bArr[1] = b2;
                    bArr[2] = 92;
                    bArr[3] = 92;
                    bArr[4] = 90;
                    bArr[5] = b;
                    byte[] bArr2 = new byte[6];
                    bArr2[c] = 2;
                    bArr2[1] = 91;
                    bArr2[2] = 84;
                    bArr2[3] = 1;
                    bArr2[4] = 3;
                    bArr2[5] = 91;
                    byte[] bArr3 = new byte[6];
                    bArr3[c] = 4;
                    bArr3[1] = 1;
                    bArr3[2] = 4;
                    bArr3[3] = 12;
                    bArr3[4] = 15;
                    bArr3[5] = 11;
                    if (name.equals(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "ecb592"))))) {
                        if (viewOnClickListenerC0318UI != null) {
                            break;
                        }
                        parent = viewOnClickListenerC0318UI2;
                        viewOnClickListenerC0318UI = parent;
                    } else if (viewOnClickListenerC0318UI != null) {
                        viewOnClickListenerC0318UI2.setWindow(viewOnClickListenerC0318UI);
                        parent.addChild(viewOnClickListenerC0318UI2);
                        parent = viewOnClickListenerC0318UI2;
                    }
                } else if (eventType == 3 && parent != null) {
                    parent = parent.getParent();
                }
                eventType = xmlPullParserNewPullParser.next();
                c = 0;
                b = 21;
                b2 = 80;
            }
            return viewOnClickListenerC0318UI;
        } catch (Exception unused) {
            return null;
        }
    }

    public String sendEvent(int i, int i2, JSONObject jSONObject) {
        return iIilII1.LLL().Ilil(12, i, i2, jSONObject != null ? jSONObject.toString() : null);
    }

    public String sendEventWithString(int i, int i2, int i3, String str) {
        return sendEvent(i, i2, i3, 0, 0, str);
    }

    public String sendLuaCall(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{89, 93}, I1I.IL1Iii.IL1Iii(new byte[]{0, 9, 7, 4, 80, 3}, I1I.IL1Iii.IL1Iii(new byte[]{8, 6, 83, 5, 81, 6}, "86a7b3"))), str);
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{85, 68, 87, 93, 70}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 0, 81, 7, 4}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 11, 86, 12, 81}, "6e949c"))), str2);
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{64, 27, 69, 86}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 3, 1, 11, 84}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 7, 3, 9, 86}, "a01103"))), i);
            return sendEvent(-1, 106, 0, 0, 0, jSONObject.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public String setUIConfig(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            lIlii.I1i(jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 91, 80, 92, 3}, I1I.IL1Iii.IL1Iii(new byte[]{7, 95, 83, 80, 80, 0}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 83, 5, 7, 93}, "1c5cb9")))), l1IIi1.I1I().m1018L11I(jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 92, 93}, I1I.IL1Iii.IL1Iii(new byte[]{9, 81, 82, 90, 8, 95}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 80, 83, 9, 81}, "163117"))))).getAbsolutePath());
            return I1I.IL1Iii.IL1Iii(new byte[]{87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 83, 7, 80, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 90, 3, 2, 1, 0}, "b8b5b2")));
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{45, 107}, I1I.IL1Iii.IL1Iii(new byte[]{90, 0, 0, 3, 85, 80}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 13, 81, 80, 0}, "708c2f"))), I1I.IL1Iii.IL1Iii(new byte[]{16, 83, 68, 97, 44, 123, 12, 88, 86, 93, 2, 24, 6, 78, 10}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 8, 85, 7, 91}, I1I.IL1Iii.IL1Iii(new byte[]{83, 91, 1, 5, 84, 2}, "299d6a"))) + e.toString());
            e.printStackTrace();
            return I1I.IL1Iii.IL1Iii(new byte[]{9}, I1I.IL1Iii.IL1Iii(new byte[]{13, 8, 7, 3, 90, 81}, I1I.IL1Iii.IL1Iii(new byte[]{7, 93, 85, 82, 83, 82}, "3ecf06")));
        }
    }

    public String setUIValue(int i, String str) {
        return (String) new C0610il().ILil(new IL(str, i));
    }

    public boolean show(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            File fileM1019iILLL1 = l1IIi1.I1I().m1019iILLL1(jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{30, 88, 8}, I1I.IL1Iii.IL1Iii(new byte[]{4, 2, 86, 7, 3, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 80, 81, 5, 84}, "cab35d")))));
            if (fileM1019iILLL1 == null) {
                return false;
            }
            int i = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{75}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 2, 3, 8, 93}, I1I.IL1Iii.IL1Iii(new byte[]{6, 4, 88, 85, 9, 1}, "5b971d"))));
            int i2 = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{26}, I1I.IL1Iii.IL1Iii(new byte[]{91, 12, 81, 1, 1, 1}, I1I.IL1Iii.IL1Iii(new byte[]{94, 10, 86, 7, 83, 8}, "f27e00"))));
            int i3 = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{70}, I1I.IL1Iii.IL1Iii(new byte[]{3, 80, 82, 93, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 8, 83, 3, 6}, "f497e4"))));
            int i4 = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{94}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 81, 7, 5, 83}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 80, 5, 0, 81}, "4add57"))));
            int i5 = jSONObject.getInt(I1I.IL1Iii.IL1Iii(new byte[]{9, 89, 12, 5, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 91, 0, 86, 14, 0}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 7, 0, 3, 4}, "57e756"))));
            try {
                ViewOnClickListenerC0318UI ui = parseUI(lIlii.l11(fileM1019iILLL1), i5);
                if (ui == null) {
                    return false;
                }
                lIlii.LIlIlIL(new lLi1LL(i5, i, i2, i3, i4, ui));
                return true;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return false;
    }

    public String sendEventWithString(int i, int i2, String str) {
        return sendEvent(i, i2, 0, 0, 0, str);
    }

    public String sendEvent(int i, int i2, int i3, int i4, int i5, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{3, 64, 83, 8}, I1I.IL1Iii.IL1Iii(new byte[]{83, 84, 4, 1, 85, 84}, I1I.IL1Iii.IL1Iii(new byte[]{3, 94, 3, 12, 83, 4}, "283414"))), i3);
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{81, 20, 2, 4}, I1I.IL1Iii.IL1Iii(new byte[]{86, 94, 92, 7, 81, 90}, I1I.IL1Iii.IL1Iii(new byte[]{85, 12, 8, 8, 87, 85}, "341947"))), i4);
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{80, 17, 82, 5}, I1I.IL1Iii.IL1Iii(new byte[]{8, 80, 12, 14, 1, 10}, I1I.IL1Iii.IL1Iii(new byte[]{92, 86, 88, 14, 84, 90}, "eea6db"))), i5);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{18, 68, 75}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 1, 6, 80, 0}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 14, 1, 7, 92}, "f3642e"))), str);
            }
        } catch (Exception unused) {
        }
        return sendEvent(i, i2, jSONObject);
    }

    public String sendEvent(int i, int i2, int i3, int i4, int i5) {
        return sendEvent(i, i2, i3, i4, i5, null);
    }

    public String sendEvent(int i, int i2, int i3, int i4) {
        return sendEvent(i, i2, i3, i4, 0);
    }

    public String sendEvent(int i, int i2, int i3) {
        return sendEvent(i, i2, i3, 0);
    }

    public String sendEvent(int i, int i2) {
        return sendEvent(i, i2, 0);
    }
}
