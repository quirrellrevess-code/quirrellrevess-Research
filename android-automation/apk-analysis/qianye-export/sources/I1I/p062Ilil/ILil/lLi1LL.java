package I1I.p062Ilil.ILil;

import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.lIlii;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.p000nx.assist.UIMgr;
import com.p000nx.assist.p002ui.ViewOnClickListenerC0318UI;
import com.p000nx.assist.p002ui.Window;
import com.p000nx.baseui.FlowRadioGroup;
import com.p000nx.baseui.X5WebView;
import com.qyzs.smn2.R;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.List;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: UiFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public Context f3498IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public LayoutInflater f3499ILil;

    /* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL$I1I */
    /* JADX INFO: compiled from: UiFactory.java */
    public static class I1I extends BaseAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public Context f3500I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public List<IL> f3501ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public LayoutInflater f1148IL;

        public I1I(Context context, List<IL> list) {
            this.f3501ILil = list;
            this.f3500I1I = context;
            this.f1148IL = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f3501ILil.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f3501ILil.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = (TextView) this.f1148IL.inflate(R.layout.ui_spinner_dropdown_item, (ViewGroup) null);
            }
            TextView textView = (TextView) view;
            IL il = this.f3501ILil.get(i);
            textView.setText(il.f3509IL1Iii);
            textView.setTextColor(il.f3510ILil);
            int i2 = il.f3508I1I;
            if (i2 > 0) {
                textView.setTextSize(2, i2);
            }
            return view;
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL$IL1Iii */
    /* JADX INFO: compiled from: UiFactory.java */
    public class IL1Iii implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3502I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Spinner f3503ILil;

        public IL1Iii(lLi1LL lli1ll, Spinner spinner, int i) {
            this.f3503ILil = spinner;
            this.f3502I1I = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f3503ILil.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f3503ILil.setSelection(this.f3502I1I);
            this.f3503ILil.setTag(R.id.tagSpinner, null);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL$ILil */
    /* JADX INFO: compiled from: UiFactory.java */
    @SuppressLint({"JavascriptInterface"})
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public X5WebView f3504IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ViewOnClickListenerC0318UI f3505ILil;

        /* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL$ILil$IL1Iii */
        /* JADX INFO: compiled from: UiFactory.java */
        public class IL1Iii implements Runnable {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final /* synthetic */ int f3506I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ String f3507ILil;

            public IL1Iii(ILil iLil, String str, int i) {
                this.f3507ILil = str;
                this.f3506I1I = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                I1I.p062Ilil.p063IL1Iii.ILil.m1251IL(lIlii.LL1IL()).m1252IiL(this.f3507ILil, 0, 0, this.f3506I1I);
            }
        }

        /* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL$ILil$ILil, reason: collision with other inner class name */
        /* JADX INFO: compiled from: UiFactory.java */
        public class RunnableC0540ILil implements Runnable {
            public RunnableC0540ILil(ILil iLil) {
            }

            @Override // java.lang.Runnable
            public void run() {
                I1I.p062Ilil.p063IL1Iii.ILil.m1251IL(lIlii.LL1IL()).Ilil();
            }
        }

        public ILil(ViewOnClickListenerC0318UI viewOnClickListenerC0318UI, X5WebView x5WebView, Context context) {
            this.f3505ILil = null;
            this.f3504IL1Iii = x5WebView;
            this.f3505ILil = viewOnClickListenerC0318UI;
        }

        @JavascriptInterface
        public boolean callLua(String str) {
            try {
                String str2 = (String) this.f3504IL1Iii.getTag();
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                    return false;
                }
                UIMgr.getInstance().sendLuaCall(str2, str, 2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @JavascriptInterface
        public boolean checkNodeServicePermission() {
            return false;
        }

        @JavascriptInterface
        public boolean checkSnapServicePermission() {
            return true;
        }

        @JavascriptInterface
        public boolean confirm() {
            ViewOnClickListenerC0318UI window;
            Window window2;
            ViewOnClickListenerC0318UI viewOnClickListenerC0318UI = this.f3505ILil;
            if (viewOnClickListenerC0318UI == null || (window = viewOnClickListenerC0318UI.getWindow()) == null || (window2 = (Window) window.getView()) == null) {
                return false;
            }
            window2.confirm();
            return true;
        }

        @JavascriptInterface
        public String getPackageName() {
            return lIlii.LiL1();
        }

        @JavascriptInterface
        public String getWorkPath() {
            return l1IIi1.I1I().ILL().getAbsolutePath();
        }

        @JavascriptInterface
        public void hidetoast() {
            lIlii.LIlIlIL(new RunnableC0540ILil(this));
        }

        @JavascriptInterface
        public boolean isAccessibilityMode() {
            return true;
        }

        @JavascriptInterface
        public boolean openSettings() {
            String[] strArr = {I1I.IL1Iii.IL1Iii(new byte[]{83, 93, 89, 31, 11, 73, 30, 95, 85, 88, 11, 31, 81, 81, 64, 88, 19, 88, 68, 75, 26, 98, 0, 69, 68, 91, 90, 86, 36, 82, 68, 91, 66, 88, 17, 72}, I1I.IL1Iii.IL1Iii(new byte[]{9, 10, 80, 2, 1, 5}, I1I.IL1Iii.IL1Iii(new byte[]{88, 94, 83, 4, 84, 82}, "af770f"))), I1I.IL1Iii.IL1Iii(new byte[]{85, 13, 90, 25, 88, 64, 24, 12, 79, 71, 68, 87, 92, 76, 86, 84, 66, 81, 64, 11, 67, 78, 24, 107, 83, 22, 67, 94, 88, 95, 119, 1, 67, 94, 64, 81, 66, 27}, I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 0, 82, 87, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 1, 0, 87, 81, 1}, "75720b")))};
            for (int i = 0; i < 2; i++) {
                try {
                    Class<?> cls = Class.forName(strArr[i]);
                    if (cls != null) {
                        Intent intent = new Intent(lIlii.LL1IL(), cls);
                        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
                        lIlii.LL1IL().startActivity(intent);
                        return true;
                    }
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        @JavascriptInterface
        public String readStringFromFile(String str) {
            try {
                return p051lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil.m3602IiL(new File(str), I1I.IL1Iii.IL1Iii(new byte[]{64, 65, 81, 14}, I1I.IL1Iii.IL1Iii(new byte[]{6, 80, 4, 1, 85, 92}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 2, 5, 90, 1}, "cb128d"))));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @JavascriptInterface
        public boolean sendToLua(String str) {
            try {
                ViewOnClickListenerC0318UI viewOnClickListenerC0318UI = this.f3505ILil;
                if (viewOnClickListenerC0318UI == null) {
                    return false;
                }
                viewOnClickListenerC0318UI.sendWebViewJsEvent(str);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        @JavascriptInterface
        public void toast(String str, int i) {
            lIlii.LIlIlIL(new IL1Iii(this, str, i));
        }

        @JavascriptInterface
        public boolean writeStringToFile(String str, String str2) {
            try {
                p051lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil.m3606il(new File(str), str2);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.l丨Li1LL$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: UiFactory.java */
    public static class IL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3508I1I = -2;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public String f3509IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3510ILil;
    }

    public lLi1LL(Context context) {
        this.f3499ILil = null;
        this.f3498IL1Iii = context;
        this.f3499ILil = LayoutInflater.from(context);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static /* synthetic */ void m1301ILl(View view, boolean z) {
        if (z) {
            ((InputMethodManager) lIlii.LL1IL().getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{81, 13, 72, 17, 21, 109, 85, 6, 76, 12, 14, 86}, I1I.IL1Iii.IL1Iii(new byte[]{13, 7, 91, 93, 80, 10}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 81, 92, 9, 92}, "752e8d"))))).showSoftInput(view, 1);
        }
    }

    public static lLi1LL Lil(Context context) {
        return new lLi1LL(context);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static X5WebView m1302Ll1(Context context, int i, String str, int i2, int i3, String str2) {
        return m1303lIiI(context, i, str, i2, i3, str2, null);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static X5WebView m1303lIiI(Context context, int i, String str, int i2, int i3, String str2, ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) {
        if (!str2.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{3, 94, 9, 80, 89, 25, 74, 24}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 93, 12, 5, 15}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 94, 92, 80, 14}, "fcfe67")))) && !str2.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{11, 17, 77, 21, 3, 78, 76}, I1I.IL1Iii.IL1Iii(new byte[]{91, 4, 88, 6, 90, 87}, I1I.IL1Iii.IL1Iii(new byte[]{92, 5, 86, 91, 90, 80}, "dd789f")))) && !str2.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{88, 76, 22, 17, 64, 92, 31, 23}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 87, 88, 11, 2}, I1I.IL1Iii.IL1Iii(new byte[]{87, 13, 0, 13, 89, 85}, "b454a1"))))) {
            str2 = I1I.IL1Iii.IL1Iii(new byte[]{10, 68, 17, 69, 12, 76, 77}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 3, 6, 5, 85}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 95, 85, 3, 6}, "549f00"))) + str2;
        }
        X5WebView x5WebView = new X5WebView(context);
        x5WebView.setTag(str);
        x5WebView.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
        x5WebView.getSettings().setJavaScriptEnabled(true);
        x5WebView.loadUrl(str2);
        x5WebView.addJavascriptInterface(new ILil(viewOnClickListenerC0318UI, x5WebView, context), I1I.IL1Iii.IL1Iii(new byte[]{7, 20, 90, 84, 2, 85}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 3, 6, 93, 8}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 8, 2, 11, 0}, "de8438"))));
        WebSettings settings = x5WebView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        WebSettings.PluginState pluginState = WebSettings.PluginState.ON_DEMAND;
        settings.setPluginState(pluginState);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setSavePassword(false);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setNeedInitialFocus(true);
        settings.setDefaultTextEncodingName(I1I.IL1Iii.IL1Iii(new byte[]{77, 70, 81, 25, 1}, I1I.IL1Iii.IL1Iii(new byte[]{14, 0, 82, 85, 88, 82}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 92, 85, 5, 80}, "b394d5"))));
        settings.setDefaultFontSize(16);
        settings.setMinimumFontSize(12);
        settings.setGeolocationEnabled(true);
        settings.setAppCachePath(context.getDir(I1I.IL1Iii.IL1Iii(new byte[]{0, 65, 71, 80, 80, 80, 9, 84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 83, 85, 4, 81}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 82, 0, 7, 83}, "7c6f21"))), 0).getPath());
        settings.setDatabasePath(context.getDir(I1I.IL1Iii.IL1Iii(new byte[]{87, 89, 70, 88, 87, 87, 64, 93, 65}, I1I.IL1Iii.IL1Iii(new byte[]{10, 90, 11, 95, 3, 6}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 1, 87, 1, 3}, "9a8173"))), 0).getPath());
        settings.setGeolocationDatabasePath(context.getDir(I1I.IL1Iii.IL1Iii(new byte[]{1, 92, 91, 85, 90, 6, 7, 77, 93, 86, 91}, I1I.IL1Iii.IL1Iii(new byte[]{81, 8, 1, 12, 13, 80}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 0, 83, 15, 3}, "aa5f76"))), 0).getPath());
        settings.setPluginState(pluginState);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setAppCacheMaxSize(RecyclerView.FOREVER_NS);
        System.currentTimeMillis();
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().sync();
        return x5WebView;
    }

    public Button I1I(int i, String str, String str2, int i2, int i3) {
        Button button = (Button) this.f3499ILil.inflate(R.layout.ui_button, (ViewGroup) null);
        button.setTag(str);
        button.setText(str2);
        button.setAllCaps(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.setMargins(0, 0, m1308llL1ii(0), 0);
        button.setLayoutParams(layoutParams);
        button.setBackgroundResource(R.drawable.bg_default_button);
        return button;
    }

    public final LinearLayout.LayoutParams IL1Iii(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (i != -2 && i2 != -2) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        layoutParams.setMargins(0, 0, m1308llL1ii(8), 0);
        return layoutParams;
    }

    public iILLL1 ILL(String str, int i, int i2) {
        return new iILLL1(this.f3498IL1Iii, str, i, i2);
    }

    public ImageView ILil(int i, String str, int i2, int i3, String str2) {
        ImageView imageView = new ImageView(this.f3498IL1Iii);
        imageView.setId(i);
        imageView.setTag(str);
        imageView.setLayoutParams(IL1Iii(i2, i3));
        imageView.setImageURI(Uri.fromFile(new File(str2)));
        return imageView;
    }

    public EditText Ilil(int i, String str, String str2, int i2, int i3) {
        EditText editText = (EditText) this.f3499ILil.inflate(R.layout.ui_edit_text, (ViewGroup) null);
        editText.setTag(str);
        editText.setText(str2);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: I1I.Ilil.ILil.IL1Iii
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                lLi1LL.m1301ILl(view, z);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.setMargins(0, 0, m1308llL1ii(8), 0);
        editText.setLayoutParams(layoutParams);
        return editText;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public CheckBox m1304IL(int i, String str, String str2, int i2, int i3, boolean z) {
        CheckBox checkBox = (CheckBox) LayoutInflater.from(this.f3498IL1Iii).inflate(R.layout.ui_checkbox, (ViewGroup) null);
        checkBox.setTag(str);
        checkBox.setText(str2);
        checkBox.setChecked(z);
        checkBox.setLayoutParams(IL1Iii(i2, i3));
        checkBox.setPadding(0, 0, 0, 0);
        Drawable drawable = this.f3498IL1Iii.getResources().getDrawable(R.drawable.selector_check_box);
        drawable.setBounds(0, 0, lIlii.Lil(this.f3498IL1Iii, 25), lIlii.Lil(this.f3498IL1Iii, 25));
        checkBox.setCompoundDrawables(drawable, null, null, null);
        return checkBox;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Spinner m1305IiL(int i, String str, List<IL> list, int i2, int i3, int i4) {
        Spinner spinner = (Spinner) this.f3499ILil.inflate(R.layout.ui_spinner, (ViewGroup) null);
        spinner.setTag(str);
        if (i3 < -2) {
            i3 = -2;
        }
        if (i4 < -2) {
            i4 = -2;
        }
        spinner.setLayoutParams(IL1Iii(i3, i4));
        I1I i1i = new I1I(spinner.getContext(), list);
        spinner.setAdapter((SpinnerAdapter) i1i);
        if (i2 >= i1i.getCount()) {
            i2 = 0;
        }
        spinner.setTag(R.id.tagSpinner, Integer.valueOf(i2));
        spinner.getViewTreeObserver().addOnGlobalLayoutListener(new IL1Iii(this, spinner, i2));
        return spinner;
    }

    public LinearLayout LlLI1(int i, String str, int i2, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f3498IL1Iii).inflate(R.layout.ui_row, (ViewGroup) null);
        linearLayout.setOrientation(0);
        linearLayout.setTag(str);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
        return linearLayout;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public LinearLayout m1306L11I(int i, String str) {
        LinearLayout linearLayout = (LinearLayout) this.f3499ILil.inflate(R.layout.ui_tab_layout, (ViewGroup) null);
        linearLayout.setId(i);
        linearLayout.setTag(str);
        return linearLayout;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public RadioGroup m1307iILLL1(int i, String str, List<String> list, int i2, int i3, int i4, boolean z) {
        RadioGroup flowRadioGroup = z ? new FlowRadioGroup(this.f3498IL1Iii) : new RadioGroup(this.f3498IL1Iii);
        flowRadioGroup.setTag(str);
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{43, 110}, I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 10, 87, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 0, 3, 80, 7}, "4d96bf"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 13, 68, 8}, I1I.IL1Iii.IL1Iii(new byte[]{92, 83, 2, 2, 6, 92}, I1I.IL1Iii.IL1Iii(new byte[]{2, 5, 3, 1, 6, 86}, "f471b3"))) + z);
        if (z) {
            flowRadioGroup.setOrientation(0);
        } else {
            flowRadioGroup.setOrientation(1);
        }
        flowRadioGroup.setLayoutParams(IL1Iii(i3, i4));
        for (int i5 = 0; i5 < list.size(); i5++) {
            RadioButton radioButton = (RadioButton) this.f3499ILil.inflate(R.layout.ui_radio_button, (ViewGroup) null);
            radioButton.setId(i5);
            radioButton.setText(list.get(i5));
            radioButton.setLayoutParams(IL1Iii(-2, -2));
            radioButton.setPadding(0, m1308llL1ii(5), 0, m1308llL1ii(5));
            Drawable drawable = this.f3498IL1Iii.getResources().getDrawable(R.drawable.selector_radio_button);
            drawable.setBounds(0, 0, lIlii.Lil(this.f3498IL1Iii, 25), lIlii.Lil(this.f3498IL1Iii, 25));
            radioButton.setCompoundDrawables(drawable, null, null, null);
            flowRadioGroup.addView(radioButton);
            if (i5 >= 100) {
                break;
            }
        }
        flowRadioGroup.clearCheck();
        if (i2 >= flowRadioGroup.getChildCount()) {
            i2 = 0;
        }
        flowRadioGroup.check(i2);
        return flowRadioGroup;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final int m1308llL1ii(int i) {
        return (int) (i * (this.f3498IL1Iii.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public LinearLayout m1309lLi1LL(int i, String str, int i2, int i3) {
        LinearLayout linearLayout = new LinearLayout(this.f3498IL1Iii);
        linearLayout.setTag(str);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i2, i3));
        return linearLayout;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public TextView m1310il(int i, String str, String str2, int i2, int i3) {
        TextView textView = (TextView) this.f3499ILil.inflate(R.layout.ui_text_view, (ViewGroup) null);
        textView.setTag(str);
        textView.setText(str2);
        textView.setLayoutParams(IL1Iii(i2, i3));
        return textView;
    }
}
