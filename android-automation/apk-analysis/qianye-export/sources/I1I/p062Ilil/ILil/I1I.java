package I1I.p062Ilil.ILil;

import I1I.I1I.ILil.iIilII1;
import I1I.I1I.p008IL.C0610il;
import I1I.I1I.p008IL.lIlii;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.UIMgr;
import com.p000nx.baseui.X5WebView;
import com.qyzs.smn2.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UIManager.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static I1I f1114IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public I1I.p062Ilil.ILil.lLi1LL f1116iILLL1;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3460ILil = 0;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3459I1I = 1;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public I1I.p062Ilil.ILil.iILLL1[] f1115IL = new I1I.p062Ilil.ILil.iILLL1[32];

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public HashMap<String, Integer> f3461Ilil = new HashMap<>();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public HashMap[] f1117lLi1LL = new HashMap[32];

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UIManager.java */
    public class ViewOnClickListenerC0537I1I implements View.OnClickListener {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3463ILil;

        public ViewOnClickListenerC0537I1I(String str) {
            this.f3463ILil = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            I1I i1i = I1I.this;
            String strM1297lLi1LL = i1i.f1115IL[((Integer) i1i.f3461Ilil.get(this.f3463ILil)).intValue()].m1297lLi1LL();
            if (TextUtils.isEmpty(strM1297lLi1LL)) {
                I1I.this.m1260IiL(this.f3463ILil);
            } else {
                UIMgr.getInstance().sendLuaCall(this.f3463ILil, strM1297lLi1LL, 0);
            }
        }
    }

    /* JADX INFO: compiled from: UIManager.java */
    public class IL1Iii implements Callable<String> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f3464IL1Iii;

        public IL1Iii(String str) {
            this.f3464IL1Iii = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            return I1I.this.m27(this.f3464IL1Iii);
        }
    }

    /* JADX INFO: compiled from: UIManager.java */
    public class ILL implements TextWatcher {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public EditText f3466I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public String f3467ILil;

        public ILL(I1I i1i, EditText editText, String str) {
            this.f3467ILil = str;
            this.f3466I1I = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Object tag = this.f3466I1I.getTag(R.id.tagChange);
            if (!TextUtils.isEmpty(this.f3467ILil) || tag == null) {
                return;
            }
            String str = (String) tag;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            UIMgr.getInstance().sendLuaCall(this.f3467ILil, str, 1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: UIManager.java */
    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I1I.this.m1262LIll();
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: UIManager.java */
    public class IL implements View.OnClickListener {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3469ILil;

        public IL(I1I i1i, String str) {
            this.f3469ILil = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UIMgr.getInstance().sendLuaCall(this.f3469ILil, I1I.IL1Iii.IL1Iii(new byte[]{84, 30, 10, 66}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 83, 4, 80, 82}, I1I.IL1Iii.IL1Iii(new byte[]{5, 8, 3, 83, 87, 0}, "683acf"))), 100);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: UIManager.java */
    public class IiL implements RadioGroup.OnCheckedChangeListener {
        public IiL(I1I i1i) {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            Object tag = radioGroup.getTag(R.id.tagChange);
            if (tag != null) {
                String str = (String) tag;
                String str2 = (String) radioGroup.getTag();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                UIMgr.getInstance().sendLuaCall(str2, str, 1);
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$L丨1丨1丨I, reason: invalid class name */
    /* JADX INFO: compiled from: UIManager.java */
    public class L11I implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3470I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Spinner f3471ILil;

        public L11I(I1I i1i, Spinner spinner, int i) {
            this.f3471ILil = spinner;
            this.f3470I1I = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f3471ILil.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f3471ILil.setTag(R.id.tagSpinner, null);
            this.f3471ILil.setSelection(this.f3470I1I);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: UIManager.java */
    public class iILLL1 implements CompoundButton.OnCheckedChangeListener {
        public iILLL1(I1I i1i) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Object tag = compoundButton.getTag(R.id.tagChange);
            if (tag != null) {
                String str = (String) tag;
                String str2 = (String) compoundButton.getTag();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                UIMgr.getInstance().sendLuaCall(str2, str, 1);
            }
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: UIManager.java */
    public class lLi1LL implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3472I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Spinner f3473ILil;

        public lLi1LL(I1I i1i, Spinner spinner, int i) {
            this.f3473ILil = spinner;
            this.f3472I1I = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f3473ILil.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f3473ILil.setTag(R.id.tagSpinner, null);
            this.f3473ILil.setSelection(this.f3472I1I);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.ILil.I1I$丨il, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UIManager.java */
    public static /* synthetic */ class C0613il {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f3474IL1Iii;

        static {
            int[] iArr = new int[I1I.p062Ilil.ILil.L11I.values().length];
            f3474IL1Iii = iArr;
            try {
                iArr[I1I.p062Ilil.ILil.L11I.TEXT_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3474IL1Iii[I1I.p062Ilil.ILil.L11I.EDIT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3474IL1Iii[I1I.p062Ilil.ILil.L11I.BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3474IL1Iii[I1I.p062Ilil.ILil.L11I.CHECK_BOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3474IL1Iii[I1I.p062Ilil.ILil.L11I.RADIIO_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3474IL1Iii[I1I.p062Ilil.ILil.L11I.SPINNER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public I1I() {
        new Handler(Looper.getMainLooper());
        this.f1116iILLL1 = I1I.p062Ilil.ILil.lLi1LL.Lil(lIlii.LL1IL());
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public static I1I m1257L1l() {
        if (f1114IiL == null) {
            f1114IiL = new I1I();
        }
        return f1114IiL;
    }

    public final boolean I11L(I1I.p062Ilil.ILil.IL il) {
        String str;
        View viewIlil;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil((str = il.f3480I1I))) == null) {
            return false;
        }
        I1I.p062Ilil.ILil.L11I l11i = (I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str);
        viewIlil.setTag(R.id.tagChange, il.f1124IL);
        if (l11i == I1I.p062Ilil.ILil.L11I.EDIT_TEXT) {
            return true;
        }
        if (l11i == I1I.p062Ilil.ILil.L11I.CHECK_BOX) {
            ((CheckBox) viewIlil).setOnCheckedChangeListener(new iILLL1(this));
            return true;
        }
        if (l11i == I1I.p062Ilil.ILil.L11I.RADIIO_GROUP) {
            ((RadioGroup) viewIlil).setOnCheckedChangeListener(new IiL(this));
            return true;
        }
        if (l11i != I1I.p062Ilil.ILil.L11I.SPINNER) {
            return true;
        }
        ((Spinner) viewIlil).setOnItemSelectedListener(this);
        return true;
    }

    public final boolean I11li1(String str) {
        if (this.f3461Ilil.get(str) != null || this.f1117lLi1LL[this.f3460ILil].get(str) == null) {
            return false;
        }
        View viewIlil = this.f1115IL[this.f3460ILil].Ilil(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewIlil.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        viewIlil.setLayoutParams(layoutParams);
        return true;
    }

    public final String ILL(I1I.p062Ilil.ILil.IL il) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return BuildConfig.FLAVOR;
        }
        String str = il.f3480I1I;
        if (this.f1117lLi1LL[i].get(str) == null) {
            return BuildConfig.FLAVOR;
        }
        switch (C0613il.f3474IL1Iii[((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str)).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return ((TextView) this.f1115IL[this.f3460ILil].Ilil(str)).getText().toString();
            case 4:
                return ((CheckBox) this.f1115IL[this.f3460ILil].Ilil(str)).getText().toString();
            case 5:
                RadioButton radioButton = (RadioButton) ((RadioGroup) this.f1115IL[this.f3460ILil].Ilil(str)).findViewById(il.f1126Ll1);
                return radioButton != null ? radioButton.getText().toString() : I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 89, 22, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 7, 83, 6, 14}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 84, 84, 84, 94}, "02fbef")));
            case 6:
                Spinner spinner = (Spinner) this.f1115IL[this.f3460ILil].Ilil(str);
                return il.f1126Ll1 < spinner.getCount() ? ((I1I.p062Ilil.ILil.lLi1LL.IL) spinner.getItemAtPosition(il.f1126Ll1)).f3509IL1Iii : BuildConfig.FLAVOR;
            default:
                return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m1258ILl(String str, int i, int i2) {
        int i3 = this.f3460ILil + 1;
        this.f3460ILil = i3;
        this.f1115IL[i3] = this.f1116iILLL1.ILL(str, i, i2);
        this.f3461Ilil.put(str, Integer.valueOf(this.f3460ILil));
        this.f1117lLi1LL[this.f3460ILil] = new HashMap();
        this.f1115IL[this.f3460ILil].m1295lIlii(new ViewOnClickListenerC0537I1I(str));
        this.f1115IL[this.f3460ILil].m1296llL1ii(new IL(this, str));
    }

    public void Ilil() {
        lIlii.LIlIlIL(new ILil());
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final int m1259IIi(int i) {
        return (int) (i * (lIlii.LL1IL().getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final boolean m1260IiL(String str) {
        int i;
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{42, 110}, I1I.IL1Iii.IL1Iii(new byte[]{80, 14, 86, 84, 84, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 10, 81, 8, 91, 86}, "c2f880"))), I1I.IL1Iii.IL1Iii(new byte[]{93, 87, 37, 93, 86, 69, 92, 116, 7, 72, 86, 67, 77, 2}, I1I.IL1Iii.IL1Iii(new byte[]{15, 15, 95, 0, 1, 84}, I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 14, 6, 91, 83}, "9077c1"))) + str);
        if (this.f3461Ilil.get(str) == null || !this.f1115IL[this.f3461Ilil.get(str).intValue()].ILL()) {
            return false;
        }
        this.f1115IL[this.f3461Ilil.get(str).intValue()].m1290IL();
        int iIntValue = this.f3461Ilil.get(str).intValue();
        int i2 = this.f3460ILil;
        if (iIntValue == i2) {
            this.f3460ILil = i2 - 1;
            while (true) {
                i = this.f3460ILil;
                if (i <= 0 || this.f1115IL[i] != null) {
                    break;
                }
                this.f3460ILil = i - 1;
            }
            if (i < 0) {
                this.f3460ILil = 0;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final boolean m1261L111(String str, String str2, int i) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i2 = this.f3460ILil;
        if (iilll1Arr[i2] == null) {
            return false;
        }
        try {
            iilll1Arr[i2].I11L(str, str2, i);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m1262LIll() {
        m1266iILLL1();
        this.f3460ILil = 0;
        this.f3459I1I = 1;
        for (int i = 0; i < 32; i++) {
            this.f1115IL[i] = null;
            HashMap[] mapArr = this.f1117lLi1LL;
            if (mapArr[i] != null) {
                mapArr[i].clear();
            }
        }
    }

    public final boolean LL1IL(I1I.p062Ilil.ILil.IL il) {
        String str;
        View viewIlil;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil((str = il.f3480I1I))) == null) {
            return false;
        }
        int i2 = il.f3481IL1Iii;
        if (i2 == 271) {
            if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.TEXT_VIEW) {
                TextView textView = (TextView) viewIlil;
                textView.setText(il.f1124IL);
                textView.setLayoutParams(new LinearLayout.LayoutParams(il.iIi1, il.iIlLiL));
                return true;
            }
        } else if (i2 == 272) {
            if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.EDIT_TEXT) {
                EditText editText = (EditText) viewIlil;
                editText.setText(il.f1124IL);
                editText.setLayoutParams(new LinearLayout.LayoutParams(il.iIi1, il.iIlLiL));
                return true;
            }
        } else if (i2 == 294) {
            if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.BUTTON) {
                Button button = (Button) viewIlil;
                button.setText(il.f1124IL);
                button.setLayoutParams(new LinearLayout.LayoutParams(il.iIi1, il.iIlLiL));
                return true;
            }
        } else if (i2 == 274) {
            if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.CHECK_BOX) {
                CheckBox checkBox = (CheckBox) viewIlil;
                checkBox.setChecked(il.f1127L11I);
                checkBox.setText(il.f1124IL);
                checkBox.getLayoutParams().width = il.iIi1;
                checkBox.getLayoutParams().height = il.iIlLiL;
                return true;
            }
        } else if (i2 == 270) {
            if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.IMAGE_VIEW) {
                ImageView imageView = (ImageView) viewIlil;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewIlil.getLayoutParams();
                layoutParams.width = il.iIi1;
                layoutParams.height = il.iIlLiL;
                imageView.setLayoutParams(layoutParams);
                imageView.setImageURI(Uri.fromFile(new File(il.f1128iILLL1)));
                return true;
            }
        } else if (i2 != 269) {
            if (i2 == 275) {
                if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.RADIIO_GROUP) {
                    RadioGroup radioGroup = (RadioGroup) viewIlil;
                    if (il.f1127L11I) {
                        radioGroup.setOrientation(0);
                    } else {
                        radioGroup.setOrientation(1);
                    }
                    radioGroup.clearCheck();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewIlil.getLayoutParams();
                    layoutParams2.width = il.iIi1;
                    layoutParams2.height = il.iIlLiL;
                    radioGroup.setLayoutParams(layoutParams2);
                    radioGroup.removeAllViews();
                    List<String> list = il.f1125IiL;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        RadioButton radioButton = (RadioButton) LayoutInflater.from(lIlii.LL1IL()).inflate(R.layout.ui_radio_button, (ViewGroup) null);
                        radioButton.setId(i3);
                        radioButton.setText(list.get(i3));
                        radioButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        radioButton.setPadding(0, m1259IIi(5), 0, m1259IIi(5));
                        Drawable drawable = lIlii.LL1IL().getResources().getDrawable(R.drawable.selector_radio_button);
                        drawable.setBounds(0, 0, 50, 50);
                        radioButton.setCompoundDrawables(drawable, null, null, null);
                        radioGroup.addView(radioButton);
                    }
                    ((RadioButton) radioGroup.findViewById(il.f1126Ll1 < radioGroup.getChildCount() ? il.f1126Ll1 : 0)).setChecked(true);
                    return true;
                }
            } else if (i2 == 273) {
                if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.SPINNER) {
                    Spinner spinner = (Spinner) viewIlil;
                    ViewGroup.LayoutParams layoutParams3 = spinner.getLayoutParams();
                    if (layoutParams3 != null) {
                        int i4 = il.iIi1;
                        int i5 = il.iIlLiL;
                        if (i4 < -2) {
                            i4 = -2;
                        }
                        int i6 = i5 >= -2 ? i5 : -2;
                        layoutParams3.width = i4;
                        layoutParams3.height = i6;
                        spinner.setLayoutParams(layoutParams3);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i7 = 0; i7 < il.f1125IiL.size(); i7++) {
                        I1I.p062Ilil.ILil.lLi1LL.IL il2 = new I1I.p062Ilil.ILil.lLi1LL.IL();
                        il2.f3510ILil = -13421773;
                        il2.f3509IL1Iii = il.f1125IiL.get(i7);
                        arrayList.add(il2);
                    }
                    I1I.p062Ilil.ILil.lLi1LL.I1I i1i = new I1I.p062Ilil.ILil.lLi1LL.I1I(spinner.getContext(), arrayList);
                    spinner.setAdapter((SpinnerAdapter) i1i);
                    i = il.f1126Ll1 < i1i.getCount() ? il.f1126Ll1 : 0;
                    spinner.setTag(R.id.tagSpinner, Integer.valueOf(i));
                    spinner.getViewTreeObserver().addOnGlobalLayoutListener(new L11I(this, spinner, i));
                    return true;
                }
            } else if (i2 != 296) {
                if (i2 == 286) {
                    if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.RADIIO_GROUP) {
                        viewIlil.setEnabled(il.f1133il);
                        RadioGroup radioGroup2 = (RadioGroup) viewIlil;
                        for (int i8 = 0; i8 < radioGroup2.getChildCount(); i8++) {
                            radioGroup2.getChildAt(i8).setEnabled(il.f1133il);
                        }
                        return true;
                    }
                    if (this.f1117lLi1LL[this.f3460ILil].get(str) != I1I.p062Ilil.ILil.L11I.EDIT_TEXT) {
                        viewIlil.setEnabled(il.f1133il);
                        return true;
                    }
                    EditText editText2 = (EditText) viewIlil;
                    editText2.setFocusable(il.f1133il);
                    editText2.setFocusableInTouchMode(il.f1133il);
                    return true;
                }
                if (i2 == 278) {
                    int i9 = il.ILL;
                    if (i9 == 2) {
                        viewIlil.setVisibility(4);
                    } else if (i9 != 3) {
                        viewIlil.setVisibility(0);
                    } else {
                        viewIlil.setVisibility(8);
                    }
                    return true;
                }
            } else if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.LINE) {
                ((LinearLayout) viewIlil).setLayoutParams(new LinearLayout.LayoutParams(il.iIi1, il.iIlLiL));
                return true;
            }
        } else if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.WEB_VIEW) {
            String str2 = il.f1132lLi1LL;
            if (!str2.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{7, 81, 8, 3, 8, 75, 78, 23}, I1I.IL1Iii.IL1Iii(new byte[]{7, 89, 92, 83, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{87, 7, 92, 80, 10, 85}, "1fde84")))) && !str2.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{94, 69, 67, 19, 88, 29, 25}, I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 86, 7, 3, 10}, I1I.IL1Iii.IL1Iii(new byte[]{9, 0, 85, 86, 4, 12}, "8342e4")))) && !str2.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{13, 70, 22, 69, 16, 10, 74, 29}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 84, 7, 81, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 83, 11, 2, 8}, "c4e908"))))) {
                str2 = I1I.IL1Iii.IL1Iii(new byte[]{11, 69, 65, 64, 91, 76, 76}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 0, 0, 88, 0}, I1I.IL1Iii.IL1Iii(new byte[]{83, 4, 84, 86, 13, 84}, "0eaf47"))) + str2;
            }
            try {
                X5WebView x5WebView = (X5WebView) viewIlil;
                x5WebView.loadUrl(str2);
                x5WebView.setLayoutParams(new LinearLayout.LayoutParams(il.iIi1, il.iIlLiL));
            } catch (Exception unused) {
            }
            return true;
        }
        return false;
    }

    public final boolean Lil(String str, int i, boolean z, int i2, int i3) {
        if (this.f3461Ilil.get(str) == null) {
            return false;
        }
        try {
            this.f1115IL[this.f3461Ilil.get(str).intValue()].llliI(i == 1, z, i2, i3);
        } catch (Exception unused) {
        }
        return true;
    }

    public final boolean LlLI1(I1I.p062Ilil.ILil.IL il) {
        if (this.f1115IL[this.f3460ILil] == null) {
            return false;
        }
        String str = il.f3482ILil;
        if (this.f3461Ilil.get(str) != null) {
            try {
                this.f1115IL[this.f3461Ilil.get(il.f3482ILil).intValue()].Lil(lIlii.m1168l1IIi1(il.f3483Ilil));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        View viewIlil = this.f1115IL[this.f3460ILil].Ilil(str);
        if (viewIlil == null) {
            return false;
        }
        int iM1168l1IIi1 = lIlii.m1168l1IIi1(il.f3483Ilil);
        if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.BUTTON) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iM1168l1IIi1);
            gradientDrawable.setCornerRadius(m1259IIi(5));
            viewIlil.setBackground(gradientDrawable);
            return true;
        }
        if (this.f1117lLi1LL[this.f3460ILil].get(str) != I1I.p062Ilil.ILil.L11I.SPINNER) {
            viewIlil.setBackgroundColor(iM1168l1IIi1);
        }
        if (this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.TEXT_VIEW || this.f1117lLi1LL[this.f3460ILil].get(str) == I1I.p062Ilil.ILil.L11I.EDIT_TEXT) {
            viewIlil.setBackgroundColor(iM1168l1IIi1);
        }
        return true;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final int m1263Ll1(I1I.p062Ilil.ILil.IL il) {
        RadioButton radioButton;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return 0;
        }
        String str = il.f3480I1I;
        if (this.f1117lLi1LL[i].get(str) == null) {
            return 0;
        }
        int i2 = C0613il.f3474IL1Iii[((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str)).ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return ((TextView) this.f1115IL[this.f3460ILil].Ilil(str)).getPaint().getColor();
        }
        if (i2 == 4) {
            return ((CheckBox) this.f1115IL[this.f3460ILil].Ilil(str)).getPaint().getColor();
        }
        if (i2 == 5 && (radioButton = (RadioButton) ((RadioGroup) this.f1115IL[this.f3460ILil].Ilil(str)).findViewById(il.f1126Ll1)) != null) {
            return radioButton.getPaint().getColor();
        }
        return 0;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final boolean m1264L11I(I1I.p062Ilil.ILil.IL il) {
        View viewIlil;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil(il.f3480I1I)) == null) {
            return false;
        }
        return this.f1117lLi1LL[this.f3460ILil].get(il.f3480I1I) == I1I.p062Ilil.ILil.L11I.EDIT_TEXT ? ((EditText) viewIlil).isFocusable() : viewIlil.isEnabled();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final boolean m1265LlLLL(I1I.p062Ilil.ILil.IL il) {
        String str = il.f3482ILil;
        String str2 = il.f3483Ilil;
        if (this.f3461Ilil.get(str) == null) {
            return false;
        }
        this.f1115IL[this.f3461Ilil.get(str).intValue()].iIlLiL(lIlii.m1168l1IIi1(str2));
        return true;
    }

    public final boolean iIi1(I1I.p062Ilil.ILil.IL il) {
        String str;
        View viewIlil;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil((str = il.f3480I1I))) == null || this.f1117lLi1LL[this.f3460ILil].get(str) != I1I.p062Ilil.ILil.L11I.EDIT_TEXT) {
            return false;
        }
        ((EditText) viewIlil).setInputType(il.f1126Ll1);
        return true;
    }

    public final boolean iIlLiL(I1I.p062Ilil.ILil.IL il) {
        View viewIlil;
        if (this.f1115IL[this.f3460ILil] == null) {
            return false;
        }
        String str = il.f3480I1I;
        int i = il.f1123ILl;
        if (i < 0) {
            i = 14;
        }
        if ((this.f3461Ilil.get(str) != null && this.f1115IL[this.f3461Ilil.get(str).intValue()] != null) || (viewIlil = this.f1115IL[this.f3460ILil].Ilil(str)) == null || this.f1117lLi1LL[this.f3460ILil].get(str) == null) {
            return false;
        }
        int i2 = C0613il.f3474IL1Iii[((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str)).ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            ((TextView) viewIlil).setTextSize(2, i);
        } else if (i2 == 4) {
            ((CheckBox) viewIlil).setTextSize(2, i);
        } else {
            if (i2 != 5) {
                return false;
            }
            RadioGroup radioGroup = (RadioGroup) viewIlil;
            for (int i3 = 0; i3 < radioGroup.getChildCount(); i3++) {
                ((RadioButton) radioGroup.getChildAt(i3)).setTextSize(2, i);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final void m1266iILLL1() {
        for (int i = 31; i > 0; i--) {
            I1I.p062Ilil.ILil.iILLL1 iilll1 = this.f1115IL[i];
            if (iilll1 != null && iilll1.ILL()) {
                iilll1.m1290IL();
            }
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m1267ill(String str) throws JSONException, IOException {
        Spinner spinner;
        if (this.f1115IL[this.f3460ILil] != null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.f1117lLi1LL[this.f3460ILil].entrySet()) {
                String str2 = (String) entry.getKey();
                int iOrdinal = ((I1I.p062Ilil.ILil.L11I) entry.getValue()).ordinal();
                if (iOrdinal <= I1I.p062Ilil.ILil.L11I.BUTTON.ordinal()) {
                    jSONObject.put(str2, ((TextView) this.f1115IL[this.f3460ILil].Ilil(str2)).getText().toString());
                } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.CHECK_BOX.ordinal()) {
                    jSONObject.put(str2, ((CheckBox) this.f1115IL[this.f3460ILil].Ilil(str2)).isChecked());
                } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.RADIIO_GROUP.ordinal()) {
                    jSONObject.put(str2, ((RadioGroup) this.f1115IL[this.f3460ILil].Ilil(str2)).getCheckedRadioButtonId());
                } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.SPINNER.ordinal() && (spinner = (Spinner) this.f1115IL[this.f3460ILil].Ilil(str2)) != null) {
                    int iIntValue = spinner.getTag(R.id.tagSpinner) != null ? ((Integer) spinner.getTag(R.id.tagSpinner)).intValue() : spinner.getSelectedItemPosition();
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 111}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 2, 87, 86, 0}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 93, 82, 81, 0}, "4c964b"))), I1I.IL1Iii.IL1Iii(new byte[]{21, 10, 21, 15, 14}, I1I.IL1Iii.IL1Iii(new byte[]{80, 82, 81, 11, 82, 10}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 84, 93, 84, 81}, "11cd6c"))) + iIntValue);
                    jSONObject.put(str2, iIntValue);
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{76, 82, 88, 67, 84, 76, 15, 89, 90, 86, 89}, I1I.IL1Iii.IL1Iii(new byte[]{1, 14, 15, 7, 84, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 14, 84, 7, 0}, "b88df0"))))) {
                iIilII1.LLL().m111(str, jSONObject.toString());
            } else {
                p051lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil.m3606il(new File(str), jSONObject.toString());
            }
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final String m1268l1IIi1() throws JSONException, IOException {
        if (this.f1115IL[this.f3460ILil] == null) {
            return BuildConfig.FLAVOR;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : this.f1117lLi1LL[this.f3460ILil].entrySet()) {
            String str = (String) entry.getKey();
            int iOrdinal = ((I1I.p062Ilil.ILil.L11I) entry.getValue()).ordinal();
            if (iOrdinal <= I1I.p062Ilil.ILil.L11I.BUTTON.ordinal()) {
                jSONObject.put(str, ((TextView) this.f1115IL[this.f3460ILil].Ilil(str)).getText().toString());
            } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.CHECK_BOX.ordinal()) {
                jSONObject.put(str, ((CheckBox) this.f1115IL[this.f3460ILil].Ilil(str)).isChecked());
            } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.RADIIO_GROUP.ordinal()) {
                jSONObject.put(str, ((RadioGroup) this.f1115IL[this.f3460ILil].Ilil(str)).getCheckedRadioButtonId());
            } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.SPINNER.ordinal()) {
                Spinner spinner = (Spinner) this.f1115IL[this.f3460ILil].Ilil(str);
                jSONObject.put(str, spinner.getTag(R.id.tagSpinner) != null ? ((Integer) spinner.getTag(R.id.tagSpinner)).intValue() : spinner.getSelectedItemPosition());
            }
        }
        return jSONObject.toString();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final int m1269lIiI(I1I.p062Ilil.ILil.IL il) {
        View viewIlil;
        int visibility;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil(il.f3480I1I)) == null || (visibility = viewIlil.getVisibility()) == 0) {
            return 0;
        }
        if (visibility == 4) {
            return 2;
        }
        return visibility == 8 ? 3 : 0;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final boolean m1270lIII(I1I.p062Ilil.ILil.IL il) {
        if (this.f3461Ilil.get(il.f3482ILil) == null) {
            return false;
        }
        try {
            this.f1115IL[this.f3461Ilil.get(il.f3482ILil).intValue()].I11li1(il.f1124IL);
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final boolean m1271lIlii(String str, String str2) {
        if (this.f3461Ilil.get(str) == null) {
            return false;
        }
        try {
            this.f1115IL[this.f3461Ilil.get(str).intValue()].LlLI1(str2);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public final int llI() {
        int i = this.f3459I1I + 1;
        this.f3459I1I = i;
        return i;
    }

    public final boolean llliI(I1I.p062Ilil.ILil.IL il) {
        View viewIlil;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil(il.f3480I1I)) == null) {
            return false;
        }
        viewIlil.setPadding(il.Lil, il.LlLI1, il.f1131llL1ii, il.f1130lIlii);
        return true;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final boolean m1272llL1ii(I1I.p062Ilil.ILil.IL il) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return false;
        }
        View viewIlil = iilll1Arr[i].Ilil(il.f3480I1I);
        if (viewIlil == null) {
            return false;
        }
        viewIlil.setTag(R.id.tagClick, il.f1124IL);
        viewIlil.setOnClickListener(this);
        return true;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m1273lLi1LL(I1I.p062Ilil.ILil.IL il) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return false;
        }
        View viewIlil = iilll1Arr[i].Ilil(il.f3480I1I);
        if (viewIlil == null) {
            return false;
        }
        if (!(viewIlil instanceof X5WebView)) {
            return true;
        }
        try {
            ((X5WebView) viewIlil).loadUrl(il.f1124IL);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag(R.id.tagClick);
        if (tag != null) {
            try {
                String str = (String) tag;
                String str2 = (String) view.getTag();
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                    return;
                }
                UIMgr.getInstance().sendLuaCall(str2, str, 2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag = adapterView.getTag(R.id.tagChange);
        if (tag != null) {
            String str = (String) tag;
            String str2 = (String) adapterView.getTag();
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            UIMgr.getInstance().sendLuaCall(str2, str, 1);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final void m1274iILLl(String str) throws JSONException, IOException {
        if (this.f1117lLi1LL[this.f3460ILil] == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte b = 0;
            byte b2 = 3;
            char c = 4;
            int i = 6;
            int i2 = 8;
            JSONObject jSONObject = str.startsWith(I1I.IL1Iii.IL1Iii(new byte[]{29, 80, 86, 76, 3, 74, 94, 91, 84, 89, 14}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 83, 91, 81, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 5, 6, 84, 82, 83}, "77b7ac")))) ? new JSONObject(iIilII1.LLL().m992i11i(str)) : new JSONObject(p051lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil.m3604iILLL1(new File(str)));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (this.f1117lLi1LL[this.f3460ILil].get(next) != null) {
                    int iOrdinal = ((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(next)).ordinal();
                    if (iOrdinal <= I1I.p062Ilil.ILil.L11I.BUTTON.ordinal()) {
                        ((TextView) this.f1115IL[this.f3460ILil].Ilil(next)).setText(jSONObject.getString(next));
                    } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.CHECK_BOX.ordinal()) {
                        ((CheckBox) this.f1115IL[this.f3460ILil].Ilil(next)).setChecked(jSONObject.getBoolean(next));
                    } else if (iOrdinal == I1I.p062Ilil.ILil.L11I.RADIIO_GROUP.ordinal()) {
                        RadioGroup radioGroup = (RadioGroup) this.f1115IL[this.f3460ILil].Ilil(next);
                        if (jSONObject.getInt(next) < radioGroup.getChildCount()) {
                            ((RadioButton) radioGroup.findViewById(jSONObject.getInt(next))).setChecked(true);
                        }
                    } else {
                        if (iOrdinal == I1I.p062Ilil.ILil.L11I.SPINNER.ordinal()) {
                            Spinner spinner = (Spinner) this.f1115IL[this.f3460ILil].Ilil(next);
                            byte[] bArr = new byte[2];
                            bArr[b] = 43;
                            bArr[1] = 111;
                            byte[] bArr2 = new byte[i];
                            bArr2[b] = 92;
                            bArr2[1] = 15;
                            bArr2[2] = b;
                            bArr2[b2] = i;
                            bArr2[c] = b2;
                            bArr2[5] = 92;
                            byte[] bArr3 = new byte[i];
                            bArr3[b] = 1;
                            bArr3[1] = 9;
                            bArr3[2] = 15;
                            bArr3[b2] = 85;
                            bArr3[c] = 1;
                            bArr3[5] = 1;
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(bArr3, "81601e")));
                            StringBuilder sb = new StringBuilder();
                            byte[] bArr4 = new byte[i2];
                            bArr4[b] = 67;
                            bArr4[1] = 64;
                            bArr4[2] = 90;
                            bArr4[b2] = 86;
                            bArr4[c] = 91;
                            bArr4[5] = b;
                            bArr4[6] = 66;
                            bArr4[7] = 10;
                            byte[] bArr5 = new byte[6];
                            bArr5[b] = 5;
                            bArr5[1] = 1;
                            bArr5[2] = 86;
                            bArr5[b2] = i2;
                            bArr5[4] = 80;
                            bArr5[5] = 84;
                            byte[] bArr6 = new byte[6];
                            bArr6[b] = 1;
                            bArr6[1] = 5;
                            bArr6[2] = 80;
                            bArr6[3] = 5;
                            bArr6[4] = 86;
                            bArr6[5] = 4;
                            sb.append(I1I.IL1Iii.IL1Iii(bArr4, I1I.IL1Iii.IL1Iii(bArr5, I1I.IL1Iii.IL1Iii(bArr6, "445535"))));
                            sb.append(spinner);
                            byte[] bArr7 = new byte[1];
                            bArr7[b] = 3;
                            byte[] bArr8 = new byte[6];
                            bArr8[b] = 13;
                            bArr8[1] = 3;
                            bArr8[2] = 82;
                            bArr8[3] = 7;
                            bArr8[4] = 86;
                            bArr8[5] = 84;
                            byte[] bArr9 = new byte[6];
                            bArr9[b] = b;
                            bArr9[1] = 7;
                            bArr9[2] = 81;
                            bArr9[3] = 5;
                            bArr9[4] = 4;
                            bArr9[5] = 83;
                            sb.append(I1I.IL1Iii.IL1Iii(bArr7, I1I.IL1Iii.IL1Iii(bArr8, I1I.IL1Iii.IL1Iii(bArr9, "5a0a4a"))));
                            sb.append(next);
                            Log.i(strIL1Iii, sb.toString());
                            if (jSONObject.getInt(next) < spinner.getCount()) {
                                int i3 = jSONObject.getInt(next);
                                spinner.setTag(R.id.tagSpinner, Integer.valueOf(i3));
                                spinner.getViewTreeObserver().addOnGlobalLayoutListener(new lLi1LL(this, spinner, i3));
                            }
                        }
                        b = 0;
                        c = 4;
                        b2 = 3;
                        i = 6;
                        i2 = 8;
                    }
                }
                b = 0;
                c = 4;
                b2 = 3;
                i = 6;
                i2 = 8;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final String m1275il(I1I.p062Ilil.ILil.IL il) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return I1I.IL1Iii.IL1Iii(new byte[]{54}, I1I.IL1Iii.IL1Iii(new byte[]{92, 81, 85, 92, 0, 1}, I1I.IL1Iii.IL1Iii(new byte[]{10, 82, 91, 87, 87, 84}, "31823a")));
        }
        String str = il.f3480I1I;
        if (this.f1117lLi1LL[i].get(str) == null) {
            return I1I.IL1Iii.IL1Iii(new byte[]{106}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 14, 4, 80, 81}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 9, 7, 84, 93}, "8012f8")));
        }
        switch (C0613il.f3474IL1Iii[((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str)).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return I1I.IL1Iii.IL1Iii(new byte[]{97}, I1I.IL1Iii.IL1Iii(new byte[]{84, 0, 88, 5, 87, 84}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 89, 5, 1, 6}, "d480b4"))) + ((TextView) this.f1115IL[this.f3460ILil].Ilil(str)).getText().toString();
            case 4:
                return I1I.IL1Iii.IL1Iii(new byte[]{117}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 1, 95, 82, 91}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 86, 3, 7, 11}, "5d5ef3"))) + Boolean.toString(((CheckBox) this.f1115IL[this.f3460ILil].Ilil(str)).isChecked());
            case 5:
                return I1I.IL1Iii.IL1Iii(new byte[]{125}, I1I.IL1Iii.IL1Iii(new byte[]{7, 7, 7, 3, 87, 81}, I1I.IL1Iii.IL1Iii(new byte[]{3, 2, 10, 12, 2, 0}, "01986f"))) + ((RadioGroup) this.f1115IL[this.f3460ILil].Ilil(str)).getCheckedRadioButtonId();
            case 6:
                Spinner spinner = (Spinner) this.f1115IL[this.f3460ILil].Ilil(str);
                return I1I.IL1Iii.IL1Iii(new byte[]{121}, I1I.IL1Iii.IL1Iii(new byte[]{8, 4, 1, 5, 85, 10}, I1I.IL1Iii.IL1Iii(new byte[]{90, 80, 0, 80, 86, 0}, "bf6ba2"))) + (spinner.getTag(R.id.tagSpinner) != null ? ((Integer) spinner.getTag(R.id.tagSpinner)).intValue() : spinner.getSelectedItemPosition());
            default:
                return I1I.IL1Iii.IL1Iii(new byte[]{103}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 83, 86, 4, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 81, 1, 88, 3}, "a74394")));
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final boolean m1276lL(I1I.p062Ilil.ILil.IL il) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return false;
        }
        View viewIlil = iilll1Arr[i].Ilil(il.f3480I1I);
        if (viewIlil == null) {
            return false;
        }
        if (!(viewIlil instanceof X5WebView)) {
            return true;
        }
        viewIlil.setTag(R.id.tagJsCallLua, il.f1124IL);
        return true;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final boolean m1277l(I1I.p062Ilil.ILil.IL il) {
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null) {
            return false;
        }
        String str = il.f3480I1I;
        String str2 = il.f1124IL;
        View viewIlil = iilll1Arr[i].Ilil(str);
        if (viewIlil == null || this.f1117lLi1LL[this.f3460ILil].get(str) == null) {
            return false;
        }
        switch (C0613il.f3474IL1Iii[((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str)).ordinal()]) {
            case 1:
            case 2:
            case 3:
                ((TextView) viewIlil).setText(str2);
                return true;
            case 4:
                ((CheckBox) viewIlil).setText(str2);
                return true;
            case 5:
                RadioButton radioButton = (RadioButton) ((RadioGroup) viewIlil).findViewById(il.f1126Ll1);
                if (radioButton == null) {
                    return false;
                }
                radioButton.setText(str2);
                return true;
            case 6:
                Spinner spinner = (Spinner) viewIlil;
                if (il.f1126Ll1 >= spinner.getCount()) {
                    return false;
                }
                SpinnerAdapter adapter = spinner.getAdapter();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                    I1I.p062Ilil.ILil.lLi1LL.IL il2 = (I1I.p062Ilil.ILil.lLi1LL.IL) adapter.getItem(i2);
                    if (i2 == il.f1126Ll1) {
                        il2.f3509IL1Iii = str2;
                    }
                    arrayList.add(il2);
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(lIlii.LL1IL(), R.layout.ui_spinner_dropdown_item, arrayList);
                spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: 丨丨 */
    public final String m27(String str) {
        I1I.p062Ilil.ILil.IL ilILil = I1I.p062Ilil.ILil.IL.ILil(str);
        if (ilILil != null) {
            int i = ilILil.f3481IL1Iii;
            if (i == 305) {
                m1261L111(ilILil.f3482ILil, ilILil.f3480I1I, ilILil.ILL);
                return I1I.IL1Iii.IL1Iii(new byte[]{69, 65, 22, 3}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 87, 2, 0, 4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 13, 85, 92, 10, 84}, "b9a89f")));
            }
            if (i == 256) {
                m1258ILl(ilILil.f3482ILil, ilILil.iIi1, ilILil.iIlLiL);
                return I1I.IL1Iii.IL1Iii(new byte[]{76, 67, 22, 92}, I1I.IL1Iii.IL1Iii(new byte[]{93, 6, 87, 12, 94, 3}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 2, 84, 82, 85}, "136a44")));
            }
            if (i == 288) {
                return Boolean.toString(Lil(ilILil.f3482ILil, ilILil.f1126Ll1, ilILil.f1127L11I, ilILil.iIi1, ilILil.iIlLiL));
            }
            if (i == 289) {
                m1260IiL(ilILil.f3482ILil);
                return I1I.IL1Iii.IL1Iii(new byte[]{23, 66, 69, 3}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 86, 84, 89, 80}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 0, 86, 0, 4}, "6cfda0")));
            }
            if (i == 295) {
                return Boolean.toString(m1271lIlii(ilILil.f3482ILil, ilILil.f1124IL));
            }
            if (i == 293) {
                return Boolean.toString(m1272llL1ii(ilILil));
            }
            if (i == 303) {
                return Boolean.toString(I11L(ilILil));
            }
            if (i == 306) {
                return Boolean.toString(m1276lL(ilILil));
            }
            if (i == 307) {
                return Boolean.toString(m1273lLi1LL(ilILil));
            }
            if (i == 257) {
                I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
                int i2 = this.f3460ILil;
                if (iilll1Arr[i2] == null) {
                    return I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 8, 16, 86}, I1I.IL1Iii.IL1Iii(new byte[]{81, 92, 85, 86, 0, 6}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 4, 87, 85, 82}, "e85bf7")));
                }
                iilll1Arr[i2].m1292Ll1(llI(), ilILil.f3480I1I, ilILil.f3482ILil, ilILil.iIi1, ilILil.iIlLiL, ilILil.f1124IL);
                return I1I.IL1Iii.IL1Iii(new byte[]{65, 75, 22, 0}, I1I.IL1Iii.IL1Iii(new byte[]{80, 9, 81, 87, 87, 1}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 84, 80, 0, 0}, "fffb52")));
            }
            if (i == 258) {
                I1I.p062Ilil.ILil.iILLL1[] iilll1Arr2 = this.f1115IL;
                int i3 = this.f3460ILil;
                if (iilll1Arr2[i3] == null) {
                    return I1I.IL1Iii.IL1Iii(new byte[]{95, 86, 90, 22, 1}, I1I.IL1Iii.IL1Iii(new byte[]{90, 1, 14, 80, 80, 82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 87, 91, 6, 12, 7}, "0ac387")));
                }
                iilll1Arr2[i3].m1294lIiI(ilILil.f3480I1I, -1, ilILil.iIlLiL);
                return I1I.IL1Iii.IL1Iii(new byte[]{71, 66, 76, 84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 82, 15, 85, 86, 87}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 15, 82, 0, 84}, "f796bf")));
            }
            if (i == 259) {
                I1I.p062Ilil.ILil.iILLL1[] iilll1Arr3 = this.f1115IL;
                int i4 = this.f3460ILil;
                return iilll1Arr3[i4] != null ? Boolean.toString(iilll1Arr3[i4].ILil(llI(), ilILil.f3480I1I, ilILil.f3482ILil, ilILil.f1124IL)) : I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 84, 21, 86}, I1I.IL1Iii.IL1Iii(new byte[]{85, 5, 1, 87, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 15, 80, 84, 86}, "bb6ae4")));
            }
            if (i != 260) {
                if (i == 261) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 93, 64, 86}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 80, 85, 81, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 3, 81, 83, 0}, "25b71e")));
                    }
                    EditText editTextIlil = this.f1116iILLL1.Ilil(llI(), ilILil.f3480I1I, ilILil.f1124IL, ilILil.iIi1, ilILil.iIlLiL);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.EDIT_TEXT);
                    this.f1115IL[this.f3460ILil].I1I(editTextIlil, ilILil.f3482ILil);
                    editTextIlil.addTextChangedListener(new ILL(this, editTextIlil, ilILil.f3480I1I));
                    return I1I.IL1Iii.IL1Iii(new byte[]{68, 70, 65, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 85, 4, 83, 85}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 85, 1, 84, 84}, "2342ed")));
                }
                if (i == 262) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 94, 71, 7}, I1I.IL1Iii.IL1Iii(new byte[]{82, 2, 2, 80, 90, 86}, I1I.IL1Iii.IL1Iii(new byte[]{82, 4, 9, 87, 94, 5}, "0393ff")));
                    }
                    TextView textViewM1310il = this.f1116iILLL1.m1310il(llI(), ilILil.f3480I1I, ilILil.f1124IL, ilILil.iIi1, ilILil.iIlLiL);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.TEXT_VIEW);
                    this.f1115IL[this.f3460ILil].I1I(textViewM1310il, ilILil.f3482ILil);
                    return I1I.IL1Iii.IL1Iii(new byte[]{65, 74, 77, 93}, I1I.IL1Iii.IL1Iii(new byte[]{84, 8, 13, 1, 80, 6}, I1I.IL1Iii.IL1Iii(new byte[]{86, 86, 13, 14, 80, 2}, "7f87ea")));
                }
                if (i == 263) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{0, 88, 13, 65, 84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 95, 82, 11, 2, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 10, 88, 82, 84}, "509aa6")));
                    }
                    CheckBox checkBoxM1304IL = this.f1116iILLL1.m1304IL(llI(), ilILil.f3480I1I, ilILil.f1124IL, ilILil.iIi1, ilILil.iIlLiL, ilILil.f1127L11I);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.CHECK_BOX);
                    this.f1115IL[this.f3460ILil].I1I(checkBoxM1304IL, ilILil.f3482ILil);
                    return I1I.IL1Iii.IL1Iii(new byte[]{77, 69, 64, 83}, I1I.IL1Iii.IL1Iii(new byte[]{88, 86, 2, 3, 86, 82}, I1I.IL1Iii.IL1Iii(new byte[]{80, 4, 15, 87, 87, 80}, "1e8bea")));
                }
                if (i == 264) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 14, 66, 93}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 83, 87, 90, 83}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 82, 4, 90, 0}, "b4cb81")));
                    }
                    RadioGroup radioGroupM1307iILLL1 = this.f1116iILLL1.m1307iILLL1(llI(), ilILil.f3480I1I, ilILil.f1125IiL, ilILil.f1126Ll1, ilILil.iIi1, ilILil.iIlLiL, ilILil.f1127L11I);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.RADIIO_GROUP);
                    this.f1115IL[this.f3460ILil].I1I(radioGroupM1307iILLL1, ilILil.f3482ILil);
                    return I1I.IL1Iii.IL1Iii(new byte[]{66, 67, 70, 1}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 6, 83, 83, 81}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 4, 0, 81, 2}, "4f1731")));
                }
                if (i == 265) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 10, 18, 0}, I1I.IL1Iii.IL1Iii(new byte[]{94, 1, 5, 85, 4, 14}, I1I.IL1Iii.IL1Iii(new byte[]{93, 80, 87, 3, 87, 15}, "ee4767")));
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < ilILil.f1125IiL.size(); i5++) {
                        I1I.p062Ilil.ILil.lLi1LL.IL il = new I1I.p062Ilil.ILil.lLi1LL.IL();
                        il.f3509IL1Iii = ilILil.f1125IiL.get(i5);
                        il.f3510ILil = -13421773;
                        arrayList.add(il);
                    }
                    Spinner spinnerM1305IiL = this.f1116iILLL1.m1305IiL(llI(), ilILil.f3480I1I, arrayList, ilILil.f1126Ll1, ilILil.iIi1, ilILil.iIlLiL);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.SPINNER);
                    this.f1115IL[this.f3460ILil].I1I(spinnerM1305IiL, ilILil.f3482ILil);
                    spinnerM1305IiL.setOnItemSelectedListener(this);
                    return I1I.IL1Iii.IL1Iii(new byte[]{76, 67, 70, 86}, I1I.IL1Iii.IL1Iii(new byte[]{15, 84, 85, 82, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 3, 0, 1, 84}, "52ea7e")));
                }
                if (i == 266) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 9, 16, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 92, 86, 5, 7, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 8, 81, 7, 84, 86}, "d1baf4")));
                    }
                    LinearLayout linearLayoutM1309lLi1LL = this.f1116iILLL1.m1309lLi1LL(llI(), ilILil.f3480I1I, ilILil.iIi1, ilILil.iIlLiL);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.LINE);
                    this.f1115IL[this.f3460ILil].I1I(linearLayoutM1309lLi1LL, ilILil.f3482ILil);
                    return I1I.IL1Iii.IL1Iii(new byte[]{16, 70, 20, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 4, 85, 6, 6}, I1I.IL1Iii.IL1Iii(new byte[]{86, 87, 0, 2, 82, 83}, "33ea11")));
                }
                if (i == 267) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{3, 3, 92, 75, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 1, 9, 81, 89}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 82, 1, 2, 2}, "45c0fc")));
                    }
                    ImageView imageViewILil = this.f1116iILLL1.ILil(llI(), ilILil.f3480I1I, ilILil.iIi1, ilILil.iIlLiL, ilILil.f1128iILLL1);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.IMAGE_VIEW);
                    imageViewILil.setOnClickListener(this);
                    this.f1115IL[this.f3460ILil].I1I(imageViewILil, ilILil.f3482ILil);
                    return I1I.IL1Iii.IL1Iii(new byte[]{18, 74, 66, 83}, I1I.IL1Iii.IL1Iii(new byte[]{5, 94, 5, 2, 94, 93}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 1, 5, 87, 15}, "433116")));
                }
                if (i == 268) {
                    if (this.f1115IL[this.f3460ILil] == null) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 13, 66, 87}, I1I.IL1Iii.IL1Iii(new byte[]{3, 2, 87, 84, 7, 84}, I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 4, 84, 0, 4}, "fe215f")));
                    }
                    X5WebView x5WebViewM1302Ll1 = I1I.p062Ilil.ILil.lLi1LL.m1302Ll1(lIlii.LL1IL(), llI(), ilILil.f3480I1I, ilILil.iIi1, ilILil.iIlLiL, ilILil.f1132lLi1LL);
                    this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.WEB_VIEW);
                    this.f1115IL[this.f3460ILil].I1I(x5WebViewM1302Ll1, ilILil.f3482ILil);
                    return I1I.IL1Iii.IL1Iii(new byte[]{70, 22, 17, 83}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 1, 87, 80, 80}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 87, 88, 84, 80}, "0329be")));
                }
                if (i == 294 || i == 269 || i == 270 || i == 271 || i == 273 || i == 272 || i == 274 || i == 275 || i == 286 || i == 278 || i == 296) {
                    return LL1IL(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{66, 66, 77, 84}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 1, 9, 81, 12}, I1I.IL1Iii.IL1Iii(new byte[]{11, 85, 1, 12, 85, 9}, "8184a0"))) : I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 93, 18, 93}, I1I.IL1Iii.IL1Iii(new byte[]{5, 7, 0, 4, 0, 3}, I1I.IL1Iii.IL1Iii(new byte[]{95, 82, 87, 81, 12, 80}, "94f44d")));
                }
                if (i == 282) {
                    return I11li1(ilILil.f3482ILil) ? I1I.IL1Iii.IL1Iii(new byte[]{70, 71, 67, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 5, 81, 82, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 10, 1, 84, 82}, "0b950c"))) : I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 93, 65, 4}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 6, 83, 0, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 86, 7, 82, 1}, "0eaf3d")));
                }
                if (i == 285) {
                    return llliI(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{23, 69, 77, 87}, I1I.IL1Iii.IL1Iii(new byte[]{91, 1, 92, 0, 0, 86}, I1I.IL1Iii.IL1Iii(new byte[]{94, 15, 1, 11, 0, 85}, "f9e9ba"))) : I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 10, 71, 4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 5, 81, 87, 82}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 87, 81, 82, 7}, "f244df")));
                }
                if (i == 297) {
                    return iIlLiL(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{67, 67, 77, 81}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 90, 1, 6, 90}, I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 1, 86, 1, 90}, "77cc3c"))) : I1I.IL1Iii.IL1Iii(new byte[]{94, 85, 91, 74, 93}, I1I.IL1Iii.IL1Iii(new byte[]{92, 7, 0, 1, 11, 15}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 2, 14, 82, 95}, "e456af")));
                }
                if (i == 302) {
                    return iIi1(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{16, 69, 68, 82}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 80, 86, 6, 80}, I1I.IL1Iii.IL1Iii(new byte[]{81, 80, 3, 4, 8, 81}, "a6be8d"))) : I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 8, 23, 92}, I1I.IL1Iii.IL1Iii(new byte[]{5, 87, 7, 5, 12, 1}, I1I.IL1Iii.IL1Iii(new byte[]{3, 91, 81, 82, 13, 81}, "58238e")));
                }
                if (i == 277) {
                    return m1277l(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{68, 22, 23, 80}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 4, 3, 80, 82}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 84, 83, 6, 7}, "132eb0"))) : I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 85, 22, 3}, I1I.IL1Iii.IL1Iii(new byte[]{14, 85, 15, 83, 3, 83}, I1I.IL1Iii.IL1Iii(new byte[]{92, 9, 2, 82, 93, 14}, "e94d88")));
                }
                if (i == 279) {
                    return m12791(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{23, 66, 23, 92}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 3, 91, 93, 0}, I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 86, 3, 15, 82}, "e77a70"))) : I1I.IL1Iii.IL1Iii(new byte[]{80, 0, 88, 21, 85}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 81, 0, 5, 93}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 85, 86, 84, 95}, "b100af")));
                }
                if (i == 280) {
                    return m1265LlLLL(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{65, 64, 17, 93}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 2, 94, 86, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 95, 2, 83, 5}, "a09d05"))) : I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 14, 68, 92}, I1I.IL1Iii.IL1Iii(new byte[]{0, 80, 81, 5, 92, 82}, I1I.IL1Iii.IL1Iii(new byte[]{80, 10, 5, 5, 84, 0}, "c9671d")));
                }
                if (i == 283) {
                    return m1278LLlI1(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{18, 19, 65, 92}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 12, 0, 3, 85}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 90, 13, 81, 81}, "c3b4b7"))) : I1I.IL1Iii.IL1Iii(new byte[]{82, 88, 93, 64, 7}, I1I.IL1Iii.IL1Iii(new byte[]{5, 11, 5, 1, 91, 4}, I1I.IL1Iii.IL1Iii(new byte[]{4, 6, 13, 10, 11, 80}, "549826")));
                }
                if (i == 281) {
                    return LlLI1(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{68, 70, 19, 6}, I1I.IL1Iii.IL1Iii(new byte[]{81, 6, 84, 0, 11, 0}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 1, 1, 81, 6}, "563bc1"))) : I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 89, 66, 85}, I1I.IL1Iii.IL1Iii(new byte[]{81, 6, 12, 80, 3, 80}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 0, 82, 87, 4}, "2393d0")));
                }
                if (i == 276) {
                    return m1270lIII(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{77, 71, 16, 4}, I1I.IL1Iii.IL1Iii(new byte[]{15, 84, 7, 85, 92, 90}, I1I.IL1Iii.IL1Iii(new byte[]{14, 85, 6, 3, 10, 91}, "84d729"))) : I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 14, 23, 93}, I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 81, 5, 89, 83}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 0, 86, 83, 85}, "e73723")));
                }
                if (i == 298) {
                    return ILL(ilILil);
                }
                if (i == 300) {
                    return m1264L11I(ilILil) ? I1I.IL1Iii.IL1Iii(new byte[]{70, 22, 19, 82}, I1I.IL1Iii.IL1Iii(new byte[]{11, 86, 5, 6, 7, 0}, I1I.IL1Iii.IL1Iii(new byte[]{93, 84, 91, 9, 0, 13}, "df8839"))) : I1I.IL1Iii.IL1Iii(new byte[]{80, 5, 94, 69, 85}, I1I.IL1Iii.IL1Iii(new byte[]{83, 83, 5, 80, 85, 83}, I1I.IL1Iii.IL1Iii(new byte[]{4, 81, 15, 5, 80, 1}, "af8c50")));
                }
                if (i == 299) {
                    return String.format(I1I.IL1Iii.IL1Iii(new byte[]{19, 72}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 82, 5, 95, 5}, I1I.IL1Iii.IL1Iii(new byte[]{80, 90, 80, 11, 85, 7}, "f8293f"))), Integer.valueOf(m1263Ll1(ilILil)));
                }
                if (i == 301) {
                    return String.format(I1I.IL1Iii.IL1Iii(new byte[]{64, 82}, I1I.IL1Iii.IL1Iii(new byte[]{93, 0, 2, 95, 80, 1}, I1I.IL1Iii.IL1Iii(new byte[]{10, 3, 0, 82, 80, 1}, "2554f2"))), Integer.valueOf(m1269lIiI(ilILil)));
                }
                if (i == 290) {
                    return m1275il(ilILil);
                }
                if (i == 304) {
                    try {
                        return m1268l1IIi1();
                    } catch (Exception unused) {
                    }
                } else {
                    if (i == 291) {
                        try {
                            m1274iILLl(ilILil.f1128iILLL1);
                            return I1I.IL1Iii.IL1Iii(new byte[]{23, 71, 67, 83}, I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 0, 14, 0, 80}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 7, 93, 90, 83}, "371e85")));
                        } catch (Exception e) {
                            String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{94, 83, 93, 17, 7}, I1I.IL1Iii.IL1Iii(new byte[]{10, 1, 7, 3, 86, 7}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 14, 5, 3, 80}, "048d72")));
                            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 111}, I1I.IL1Iii.IL1Iii(new byte[]{13, 83, 0, 2, 85, 91}, I1I.IL1Iii.IL1Iii(new byte[]{10, 80, 80, 7, 93, 81}, "34dd93"))), e.toString());
                            return strIL1Iii;
                        }
                    }
                    if (i == 292) {
                        try {
                            m1267ill(ilILil.f1128iILLL1);
                            return I1I.IL1Iii.IL1Iii(new byte[]{76, 75, 65, 1}, I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 12, 7, 8, 93}, I1I.IL1Iii.IL1Iii(new byte[]{8, 85, 8, 5, 15, 91}, "000f6c")));
                        } catch (Exception unused2) {
                            return I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 89, 68, 1}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 2, 84, 87, 88}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 85, 80, 2, 10}, "c6b313")));
                        }
                    }
                }
            } else if (this.f1115IL[this.f3460ILil] != null) {
                Button buttonI1I = this.f1116iILLL1.I1I(llI(), ilILil.f3480I1I, ilILil.f1124IL, ilILil.iIi1, ilILil.iIlLiL);
                this.f1117lLi1LL[this.f3460ILil].put(ilILil.f3480I1I, I1I.p062Ilil.ILil.L11I.BUTTON);
                buttonI1I.setOnClickListener(this);
                this.f1115IL[this.f3460ILil].I1I(buttonI1I, ilILil.f3482ILil);
                return I1I.IL1Iii.IL1Iii(new byte[]{71, 75, 68, 0}, I1I.IL1Iii.IL1Iii(new byte[]{11, 93, 8, 4, 3, 12}, I1I.IL1Iii.IL1Iii(new byte[]{13, 1, 14, 88, 7, 0}, "5e79e9")));
            }
        }
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final boolean m1278LLlI1(I1I.p062Ilil.ILil.IL il) {
        View viewIlil;
        I1I.p062Ilil.ILil.iILLL1[] iilll1Arr = this.f1115IL;
        int i = this.f3460ILil;
        if (iilll1Arr[i] == null || (viewIlil = iilll1Arr[i].Ilil(il.f3480I1I)) == null) {
            return false;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewIlil.getLayoutParams();
        layoutParams.gravity = il.f1129lIiI;
        viewIlil.setLayoutParams(layoutParams);
        return true;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final boolean m12791(I1I.p062Ilil.ILil.IL il) {
        if (this.f1115IL[this.f3460ILil] == null) {
            return false;
        }
        String str = il.f3480I1I;
        int iM1168l1IIi1 = lIlii.m1168l1IIi1(il.f3483Ilil);
        if (this.f3461Ilil.get(str) != null) {
            this.f1115IL[this.f3461Ilil.get(str).intValue()].m1299lL(iM1168l1IIi1);
            return true;
        }
        View viewIlil = this.f1115IL[this.f3460ILil].Ilil(str);
        if (viewIlil == null) {
            return false;
        }
        switch (C0613il.f3474IL1Iii[((I1I.p062Ilil.ILil.L11I) this.f1117lLi1LL[this.f3460ILil].get(str)).ordinal()]) {
            case 1:
            case 2:
            case 3:
                ((TextView) viewIlil).setTextColor(iM1168l1IIi1);
                return true;
            case 4:
                ((CheckBox) viewIlil).setTextColor(iM1168l1IIi1);
                return true;
            case 5:
                RadioButton radioButton = (RadioButton) ((RadioGroup) viewIlil).findViewById(il.f1126Ll1);
                if (radioButton == null) {
                    return false;
                }
                radioButton.setTextColor(iM1168l1IIi1);
                return true;
            case 6:
                int i = il.f1126Ll1;
                if (i < 0 || i >= ((Spinner) viewIlil).getCount()) {
                    return false;
                }
                try {
                    I1I.p062Ilil.ILil.lLi1LL.I1I i1i = (I1I.p062Ilil.ILil.lLi1LL.I1I) ((Spinner) viewIlil).getAdapter();
                    ((I1I.p062Ilil.ILil.lLi1LL.IL) i1i.getItem(il.f1126Ll1)).f3510ILil = iM1168l1IIi1;
                    i1i.notifyDataSetChanged();
                    break;
                } catch (Exception e) {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 97}, I1I.IL1Iii.IL1Iii(new byte[]{10, 12, 13, 82, 91, 15}, I1I.IL1Iii.IL1Iii(new byte[]{10, 4, 8, 89, 11, 15}, "911839"))), e.toString());
                }
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public String m1280(String str) {
        return (String) new C0610il().ILil(new IL1Iii(str));
    }
}
