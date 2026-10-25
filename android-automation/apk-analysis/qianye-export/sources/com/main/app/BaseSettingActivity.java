package com.main.app;

import I1I.I1I.ILil.I11li1;
import I1I.I1I.ILil.IIi;
import I1I.I1I.ILil.LlLI1;
import I1I.I1I.ILil.LlLLL;
import I1I.I1I.ILil.iIilII1;
import I1I.I1I.ILil.lliiI1;
import I1I.I1I.p008IL.lIlii;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.flexbox.BuildConfig;
import com.qyzs.smn2.R;
import org.greenrobot.eventbus.ThreadMode;
import p051lLi1LL.ILil.IL1Iii.InterfaceC0678ILl;

/* JADX INFO: loaded from: classes.dex */
public class BaseSettingActivity extends AppCompatActivity {
    public LinearLayout I11L;
    public LinearLayout I11li1;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public EditText f2858L111;
    public CheckBox LL1IL;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public CheckBox f2860LlLLL;
    public Button iIlLiL;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public CheckBox f2862lIII;
    public Handler llI;
    public RadioGroup llliI;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public RelativeLayout f2863lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public CheckBox f2864l;

    /* JADX INFO: renamed from: 丨丨 */
    public TextView f74;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public EditText f2865LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public CheckBox f28661;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public boolean f2861l1IIi1 = false;

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public boolean f2859L1l = false;

    public class I1I implements RadioGroup.OnCheckedChangeListener {
        public I1I() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.switch_root) {
                lIlii.lILIlI(BaseSettingActivity.this, LlLI1.IL1Iii.ROOT);
            } else if (i == R.id.switch_wza) {
                lIlii.lILIlI(BaseSettingActivity.this, LlLI1.IL1Iii.ACC);
            } else if (i == R.id.switch_byhandle) {
                lIlii.lILIlI(BaseSettingActivity.this, LlLI1.IL1Iii.HANDLE);
            }
        }
    }

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lIlii.lIlIl(BaseSettingActivity.this)) {
                ((InputMethodManager) BaseSettingActivity.this.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{8, 92, 20, 66, 67, 57, 12, 87, 16, 95, 88, 2}, I1I.IL1Iii.IL1Iii(new byte[]{81, 11, 82, 83, 2, 80}, I1I.IL1Iii.IL1Iii(new byte[]{81, 10, 6, 7, 7, 83}, "a30c2e"))))).showInputMethodPicker();
            }
        }
    }

    public class ILL implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f5270ILil;

        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseSettingActivity.this.iIlLiL.setEnabled(true);
            }
        }

        public ILL(String str) {
            this.f5270ILil = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Native.connectService(this.f5270ILil, lIlii.m1163i1I1I1l(BaseSettingActivity.this, R.id.port, 10092), lIlii.Ll1(BaseSettingActivity.this))) {
                lIlii.lILi1lLl(BaseSettingActivity.this, I1I.IL1Iii.IL1Iii(new byte[]{-40, -38, -82, -46, -68, -108, -42, -19, -96, -47, -72, -82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 86, 7, 87, 7, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 4, 2, 85, 6, 0}, "b75632"))));
            } else {
                lIlii.lILi1lLl(BaseSettingActivity.this, I1I.IL1Iii.IL1Iii(new byte[]{-114, -36, -85, -48, -71, -109, -125, -57, -124, -34, -125, -109}, I1I.IL1Iii.IL1Iii(new byte[]{7, 82, 80, 83, 14, 2}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 86, 82, 92, 86}, "6b37eb"))));
            }
            BaseSettingActivity.this.runOnUiThread(new IL1Iii());
        }
    }

    public class ILil implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5273ILil;

        public ILil(int i) {
            this.f5273ILil = i;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int i = this.f5273ILil;
            if (i == R.id.switch_autosavelog) {
                lIlii.m1120IlILil(z);
            } else if (i == R.id.switch_addfileinfo) {
                lIlii.m1202LllL(z);
            }
            lIlii.lLi(BaseSettingActivity.this, this.f5273ILil, z);
        }
    }

    /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$I丨L, reason: invalid class name */
    public class IL implements CompoundButton.OnCheckedChangeListener {
        public IL() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (BaseSettingActivity.this.f2864l.isPressed()) {
                if (lIlii.lIlIl(BaseSettingActivity.this)) {
                    BaseSettingActivity.this.f2864l.setChecked(!z);
                    ((InputMethodManager) BaseSettingActivity.this.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{81, 11, 68, 77, 17, 106, 85, 0, 64, 80, 10, 81}, I1I.IL1Iii.IL1Iii(new byte[]{94, 86, 81, 8, 3, 13}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 84, 7, 0, 1}, "c217f9"))))).showInputMethodPicker();
                } else {
                    BaseSettingActivity baseSettingActivity = BaseSettingActivity.this;
                    baseSettingActivity.f2861l1IIi1 = true;
                    lIlii.m1138LilI(baseSettingActivity);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$I丨iL, reason: invalid class name */
    public class IiL implements CompoundButton.OnCheckedChangeListener {
        public IiL() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (BaseSettingActivity.this.f28661.isPressed()) {
                BaseSettingActivity.this.f28661.setChecked(!z);
                lIlii.m1187iIli1(BaseSettingActivity.this);
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$L丨1丨1丨I, reason: invalid class name */
    public class L11I implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$L丨1丨1丨I$IL1Iii */
        public class IL1Iii implements LlLLL {
            public IL1Iii() {
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void IL1Iii() {
                lIlii.lILi1lLl(BaseSettingActivity.this, I1I.IL1Iii.IL1Iii(new byte[]{-124, -115, -93, -125, -15, -24, -124, -95, -103, -128, -24, -50, -124, -107, -121, -115, -42, -61, 77, -39, -103, -46, -121, -29, -23, -42, -105, -53, -122, -39, -4, -44, -118, -27, -121, -10, -50, 67, 89, 10, 22, -126, -37, -73}, I1I.IL1Iii.IL1Iii(new byte[]{88, 0, 15, 82, 91, 7}, I1I.IL1Iii.IL1Iii(new byte[]{92, 87, 1, 82, 90, 89}, "ef8ec8"))));
                BaseSettingActivity.this.f2859L1l = false;
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void ILil() {
                lIlii.lILi1lLl(BaseSettingActivity.this, I1I.IL1Iii.IL1Iii(new byte[]{102, 46, 118, 53, -47, -116, -95, -121, -86, -17, -47, -96, -101, -124, -77, -55, -47, -98, -72, -121, -79, -15}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 90, 89, 12, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 83, 15, 14, 81}, "b00760"))));
                BaseSettingActivity.this.m3445iILLl();
                BaseSettingActivity.this.f2859L1l = false;
            }
        }

        public L11I() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (lIlii.m1160ili11(BaseSettingActivity.this) == LlLI1.IL1Iii.ROOT && BaseSettingActivity.this.LL1IL.isPressed() && !BaseSettingActivity.this.f2859L1l) {
                BaseSettingActivity.this.f2859L1l = true;
                LlLI1.m925IL().Ilil().ILL(BaseSettingActivity.this, new IL1Iii());
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements CompoundButton.OnCheckedChangeListener {
        public iILLL1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (BaseSettingActivity.this.f2860LlLLL.isPressed()) {
                lIlii.m1158iiLL(BaseSettingActivity.this);
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements CompoundButton.OnCheckedChangeListener {
        public lLi1LL() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (BaseSettingActivity.this.f2862lIII.isPressed()) {
                ((I11li1) LlLI1.m925IL().ILil()).m847ILl(BaseSettingActivity.this, false);
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.BaseSettingActivity$丨il, reason: invalid class name and case insensitive filesystem */
    public class ViewOnClickListenerC0671il implements View.OnClickListener {
        public ViewOnClickListenerC0671il() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseSettingActivity.this.m3442LIll(view);
        }
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public void m3441IIi(boolean z) {
        this.llI = new Handler();
        this.I11li1 = (LinearLayout) findViewById(R.id.engineLayout);
        this.f2863lL = (RelativeLayout) findViewById(R.id.runRootEnvLayout);
        this.I11L = (LinearLayout) findViewById(R.id.localDbgLayout);
        if (!lIlii.Ll1(this) || z) {
            this.I11L.setVisibility(8);
        }
        if (lIlii.m1134LLil(this) || lIlii.m1179IL1iLI(this) || lIlii.IL1(this)) {
            this.I11li1.setVisibility(8);
            if (lIlii.m1134LLil(this)) {
                lIlii.lILIlI(this, LlLI1.IL1Iii.ROOT);
            } else if (lIlii.m1179IL1iLI(this)) {
                lIlii.lILIlI(this, LlLI1.IL1Iii.ACC);
            } else {
                lIlii.lILIlI(this, LlLI1.IL1Iii.HANDLE);
            }
        } else {
            this.I11li1.setVisibility(0);
        }
        this.llliI = (RadioGroup) findViewById(R.id.engineSel);
        if (lIlii.IL1(this)) {
            this.f2863lL.setVisibility(8);
        } else if (lIlii.m1134LLil(this)) {
            if (lIlii.LIiiILi(this)) {
                this.f2863lL.setVisibility(8);
                lIlii.lLi(this, R.id.switch_rootengine, true);
            }
        } else if (lIlii.m1179IL1iLI(this)) {
            this.f2863lL.setVisibility(8);
        }
        ((TextView) findViewById(R.id.version)).setText(String.format(I1I.IL1Iii.IL1Iii(new byte[]{65, 69}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 87, 83, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{8, 81, 81, 1, 81, 1}, "9ee3a7"))), lIlii.iIlL1(this)));
        this.iIlLiL = (Button) findViewById(R.id.connect);
        this.f2860LlLLL = (CheckBox) findViewById(R.id.switch_accessibility);
        this.f2862lIII = (CheckBox) findViewById(R.id.switch_opensnap);
        this.LL1IL = (CheckBox) findViewById(R.id.switch_openrootengine);
        m3443L1l(R.id.switch_bootstart, lIlii.m1162ill(this));
        m3443L1l(R.id.switch_vol, lIlii.m1139LlIl(this));
        m3444l1IIi1(R.id.switch_virbate);
        this.f2864l = (CheckBox) findViewById(R.id.switch_openime);
        this.f74 = (TextView) findViewById(R.id.localipaddr);
        m3443L1l(R.id.switch_rootengine, lIlii.m1205(this));
        m3443L1l(R.id.use_automator, lIlii.m1127L11(this));
        boolean z2 = getResources().getInteger(R.integer.is_autoopen_log) == 1;
        m3443L1l(R.id.switch_autosavelog, z2);
        m3443L1l(R.id.switch_addfileinfo, false);
        this.f28661 = m3443L1l(R.id.switch_openloglist, false);
        m3443L1l(R.id.switch_showonoff, true);
        this.f2865LLlI1 = (EditText) findViewById(R.id.ipaddr);
        EditText editText = (EditText) findViewById(R.id.port);
        this.f2858L111 = editText;
        editText.setText(BuildConfig.FLAVOR + lIlii.m1163i1I1I1l(this, R.id.port, 10092));
        ((TextView) findViewById(R.id.local_port)).setText(BuildConfig.FLAVOR + lIlii.m1133LIll(this));
        String strM1150iI1LI = lIlii.m1150iI1LI(this, R.id.ipaddr, I1I.IL1Iii.IL1Iii(new byte[]{0, 25, 3, 28, 2, 31, 0}, I1I.IL1Iii.IL1Iii(new byte[]{83, 83, 5, 0, 10, 5}, I1I.IL1Iii.IL1Iii(new byte[]{6, 93, 2, 86, 8, 12}, "e94d08"))));
        if (!TextUtils.isEmpty(strM1150iI1LI)) {
            this.f2865LLlI1.setText(strM1150iI1LI);
        }
        String strM1185i11i = lIlii.m1185i11i();
        if (TextUtils.isEmpty(strM1185i11i)) {
            strM1185i11i = I1I.IL1Iii.IL1Iii(new byte[]{4, 30, 0, 29, 85, 29, 4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 2, 1, 4, 81, 5}, I1I.IL1Iii.IL1Iii(new byte[]{3, 83, 6, 7, 82, 83}, "5a70fe")));
        }
        this.f74.setText(strM1185i11i);
        LlLI1.IL1Iii iL1IiiM1160ili11 = lIlii.m1160ili11(this);
        if (iL1IiiM1160ili11 == LlLI1.IL1Iii.ROOT) {
            this.llliI.check(R.id.switch_root);
        } else {
            LlLI1.IL1Iii iL1Iii = LlLI1.IL1Iii.ACC;
            if (iL1IiiM1160ili11 == iL1Iii) {
                this.llliI.check(R.id.switch_wza);
                lIlii.lILIlI(this, iL1Iii);
            } else {
                this.llliI.check(R.id.switch_byhandle);
            }
        }
        this.llliI.setOnCheckedChangeListener(new I1I());
        this.f2864l.setOnCheckedChangeListener(new IL());
        if (iIilII1.LLL().m970I1L11L()) {
            this.f2862lIII.setChecked(true);
        }
        this.f2862lIII.setOnCheckedChangeListener(new lLi1LL());
        this.f2860LlLLL.setOnCheckedChangeListener(new iILLL1());
        this.f28661.setOnCheckedChangeListener(new IiL());
        this.LL1IL.setOnCheckedChangeListener(new L11I());
        this.iIlLiL.setOnClickListener(new ViewOnClickListenerC0671il());
        lIlii.m1120IlILil(lIlii.m15LL(this, R.id.switch_autosavelog, z2));
        lIlii.m1202LllL(lIlii.m15LL(this, R.id.switch_addfileinfo, false));
        p051lLi1LL.ILil.IL1Iii.I1I.I1I().Lil(this);
        m3445iILLl();
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m3442LIll(View view) {
        if (view == this.iIlLiL) {
            String string = this.f2858L111.getText().toString();
            String string2 = this.f2865LLlI1.getText().toString();
            if (TextUtils.isEmpty(string)) {
                lIlii.lILi1lLl(this, I1I.IL1Iii.IL1Iii(new byte[]{-127, -50, -104, -45, -22, -106, -128, -41, -106, -48, -7, -68, -114, -53, -119, -47, -40, -101}, I1I.IL1Iii.IL1Iii(new byte[]{5, 82, 14, 14, 84, 3}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 0, 12, 84, 84}, "fc94eb"))));
                return;
            }
            lIlii.m19il(this, R.id.port, Integer.parseInt(string));
            if (TextUtils.isEmpty(string2)) {
                lIlii.lILi1lLl(this, I1I.IL1Iii.IL1Iii(new byte[]{-35, -39, -33, -45, -7, -116, -36, -3, -44, -48, -8, -74, -33, -45, -59, -45, -7, -65, -47, -49, -38, -46, -40, -104}, I1I.IL1Iii.IL1Iii(new byte[]{91, 84, 81, 83, 80, 5}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 7, 4, 3, 11}, "132b68"))));
                return;
            }
            lIlii.m1137Lii1ii(this, R.id.ipaddr, string2);
            this.iIlLiL.setEnabled(false);
            new Thread(new ILL(string2)).start();
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public final CheckBox m3443L1l(int i, boolean z) {
        CheckBox checkBox = (CheckBox) findViewById(i);
        if (checkBox != null) {
            checkBox.setChecked(lIlii.m15LL(this, i, z));
            checkBox.setOnCheckedChangeListener(new ILil(i));
        }
        return checkBox;
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public final CheckBox m3444l1IIi1(int i) {
        return m3443L1l(i, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @InterfaceC0678ILl(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(IIi iIi) {
        String strIL1Iii;
        if (iIi.I1I() == 103) {
            String strIL1Iii2 = iIi.IL1Iii();
            if (strIL1Iii2 != null) {
                if (strIL1Iii2.equals(I1I.IL1Iii.IL1Iii(new byte[]{8}, I1I.IL1Iii.IL1Iii(new byte[]{91, 2, 10, 13, 83, 84}, I1I.IL1Iii.IL1Iii(new byte[]{90, 3, 80, 2, 82, 5}, "86b603"))))) {
                    this.f2860LlLLL.setChecked(true);
                    return;
                } else {
                    if (strIL1Iii2.equals(I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{2, 88, 8, 85, 1, 7}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 93, 1, 84, 5}, "58d0d2"))))) {
                        this.f2860LlLLL.setChecked(false);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (iIi.I1I() != 104 || (strIL1Iii = iIi.IL1Iii()) == null) {
            return;
        }
        if (strIL1Iii.equals(I1I.IL1Iii.IL1Iii(new byte[]{9}, I1I.IL1Iii.IL1Iii(new byte[]{11, 93, 2, 6, 87, 84}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 87, 83, 83, 5}, "5a4f67"))))) {
            this.f2864l.setChecked(true);
        } else if (strIL1Iii.equals(I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{0, 8, 83, 0, 5, 83}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 86, 90, 83, 2}, "43ccdc"))))) {
            this.f2864l.setChecked(false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (lIlii.Ilil()) {
            this.f2860LlLLL.setChecked(true);
        } else {
            this.f2860LlLLL.setChecked(false);
        }
        if (iIilII1.LLL().m970I1L11L()) {
            this.f2862lIII.setChecked(true);
        } else {
            this.f2862lIII.setChecked(false);
        }
        if (ImeInput.I1I() != null) {
            this.f2864l.setChecked(true);
        } else {
            this.f2864l.setChecked(false);
        }
        if (this.f2861l1IIi1) {
            this.f2861l1IIi1 = false;
            this.llI.postDelayed(new IL1Iii(), 1000L);
        }
        m3445iILLl();
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final void m3445iILLl() {
        try {
            if (((lliiI1) LlLI1.m925IL().Ilil()).m1038lIlii()) {
                this.LL1IL.setChecked(true);
            } else {
                this.LL1IL.setChecked(false);
            }
        } catch (Exception unused) {
        }
    }
}
