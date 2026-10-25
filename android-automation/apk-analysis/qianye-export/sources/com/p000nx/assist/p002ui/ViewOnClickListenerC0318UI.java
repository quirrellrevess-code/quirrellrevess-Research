package com.p000nx.assist.p002ui;

import I1I.I1I.ILil.l1IIi1;
import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import I1I.p062Ilil.ILil.lLi1LL;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.google.gson.Gson;
import com.p000nx.assist.UIMgr;
import com.p000nx.baseui.FlowRadioGroup;
import com.p000nx.baseui.X5WebView;
import com.qyzs.smn2.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: com.nx.assist.ui.UI */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0318UI implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
    private int mHandle;
    private int mIndex;
    private ViewOnClickListenerC0318UI mParent;
    private String mTag;
    private Map<String, Map<String, String>> mValuesRead;
    private View mView;
    private ViewOnClickListenerC0318UI mWindow;
    private List<ViewOnClickListenerC0318UI> mChilds = new ArrayList();
    private Map<String, String> attrib = new HashMap();
    private Map<String, Map<String, String>> mValues = new HashMap();
    private boolean isUserClicked = false;

    public ViewOnClickListenerC0318UI(XmlPullParser xmlPullParser, int i) {
        this.mValuesRead = new HashMap();
        this.mHandle = -1;
        this.mIndex = -1;
        this.mTag = xmlPullParser.getName();
        this.mHandle = i;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            this.attrib.put(xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
        }
        if (TextUtils.isEmpty(this.mTag) || this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{51, 91, 86, 84, 90, 79}, IL1Iii.IL1Iii(new byte[]{1, 2, 92, 8, 86, 12}, IL1Iii.IL1Iii(new byte[]{0, 9, 83, 8, 83, 80}, "e9700d")))) != 0) {
            return;
        }
        this.mIndex = 0;
        this.mValuesRead = UIMgr.getInstance().loadUIConfig(getAttribString(IL1Iii.IL1Iii(new byte[]{87, 13, 88, 86, 90, 84}, IL1Iii.IL1Iii(new byte[]{0, 84, 7, 7, 10, 11}, IL1Iii.IL1Iii(new byte[]{3, 1, 5, 15, 8, 94}, "77481f")))));
    }

    private int getAlign(String str) {
        if (TextUtils.isEmpty(str)) {
            return 19;
        }
        int i = 0;
        for (String str2 : str.split(IL1Iii.IL1Iii(new byte[]{105, 29}, IL1Iii.IL1Iii(new byte[]{0, 5, 81, 9, 84, 85}, IL1Iii.IL1Iii(new byte[]{1, 93, 7, 8, 9, 83}, "49b18d"))))) {
            if (str2.equals(IL1Iii.IL1Iii(new byte[]{87, 0, 87, 18, 84, 23}, IL1Iii.IL1Iii(new byte[]{13, 84, 8, 95, 5, 82}, IL1Iii.IL1Iii(new byte[]{91, 3, 85, 92, 3, 86}, "b2de7a"))))) {
                i = 17;
            } else if (str2.equals(IL1Iii.IL1Iii(new byte[]{1, 80, 87, 76, 86, 22, 61, 67, 92, 74, 71, 13, 1, 84, 85}, IL1Iii.IL1Iii(new byte[]{82, 12, 1, 15, 80, 85}, IL1Iii.IL1Iii(new byte[]{0, 91, 94, 2, 0, 82}, "0bf5cc"))))) {
                i |= 16;
            } else if (str2.equals(IL1Iii.IL1Iii(new byte[]{84, 85, 10, 70, 85, 70, 104, 88, 11, 64, 89, 78, 88, 94, 16, 83, 92}, IL1Iii.IL1Iii(new byte[]{85, 6, 87, 3, 9, 1}, IL1Iii.IL1Iii(new byte[]{4, 15, 82, 80, 90, 7}, "f9aac2"))))) {
                i |= 1;
            } else if (str2.equals(IL1Iii.IL1Iii(new byte[]{93, 0, 81, 23}, IL1Iii.IL1Iii(new byte[]{85, 0, 5, 84, 80, 84}, IL1Iii.IL1Iii(new byte[]{86, 7, 10, 82, 6, 81}, "2b8ed0"))))) {
                i |= 3;
            } else if (str2.equals(IL1Iii.IL1Iii(new byte[]{67, 94, 67}, IL1Iii.IL1Iii(new byte[]{81, 0, 81, 11, 0, 11}, IL1Iii.IL1Iii(new byte[]{81, 84, 6, 0, 93, 94}, "7ed88f"))))) {
                i |= 48;
            } else if (str2.equals(IL1Iii.IL1Iii(new byte[]{22, 94, 83, 13, 65}, IL1Iii.IL1Iii(new byte[]{93, 86, 85, 92, 84, 0}, IL1Iii.IL1Iii(new byte[]{91, 84, 3, 14, 81, 7}, "b5b70e"))))) {
                i |= 5;
            } else if (str2.equals(IL1Iii.IL1Iii(new byte[]{84, 93, 23, 16, 88, 95}, IL1Iii.IL1Iii(new byte[]{83, 5, 82, 85, 3, 3}, IL1Iii.IL1Iii(new byte[]{4, 4, 84, 80, 81, 9}, "a3eae8"))))) {
                i |= 80;
            }
        }
        return i;
    }

    private Rect getRect(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Rect rect = new Rect();
        String[] strArrSplit = str.split(IL1Iii.IL1Iii(new byte[]{29}, IL1Iii.IL1Iii(new byte[]{5, 15, 0, 1, 80, 88}, IL1Iii.IL1Iii(new byte[]{6, 1, 82, 6, 85, 93}, "26e5dd"))));
        if (strArrSplit.length != 4) {
            return rect;
        }
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (Exception unused) {
            }
        }
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = iArr[2];
        rect.bottom = iArr[3];
        return rect;
    }

    /* JADX WARN: Code duplicated, block: B:195:0x0adb  */
    private View inflateViewImp(Context context) throws Throwable {
        int i;
        X5WebView x5WebViewM1303lIiI;
        View view;
        Drawable drawableM1021lLi1LL;
        final int i2;
        View view2;
        Drawable drawableM1021lLi1LL2;
        boolean z;
        RadioGroup radioGroup;
        int i3;
        View view3;
        boolean attribBoolean;
        View view4;
        Drawable drawableM1021lLi1LL3;
        View view5;
        View view6;
        View view7;
        int i4 = 0;
        if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{99, 89, 87, 7, 91, 69}, IL1Iii.IL1Iii(new byte[]{5, 8, 15, 80, 7, 80}, IL1Iii.IL1Iii(new byte[]{1, 92, 7, 85, 6, 82}, "0d1f50")))) == 0) {
            this.mView = new Window(context, this);
            String attribString = getAttribString(IL1Iii.IL1Iii(new byte[]{3, 81, 1, 89, 86, 16, 14, 69, 12, 86}, IL1Iii.IL1Iii(new byte[]{86, 8, 1, 86, 3, 3}, IL1Iii.IL1Iii(new byte[]{5, 11, 80, 80, 84, 82}, "2334f3"))));
            if (TextUtils.isEmpty(attribString)) {
                this.mView.setBackgroundResource(R.drawable.linear_corn_bg);
            } else {
                l1IIi1.I1I().m1020lIiI(this.mView, attribString);
            }
        } else {
            int i5 = 4;
            if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{51, 81, 6, 4}, IL1Iii.IL1Iii(new byte[]{84, 7, 2, 84, 7, 85}, IL1Iii.IL1Iii(new byte[]{81, 86, 81, 3, 10, 86}, "fa2682")))) == 0) {
                UIPage uIPage = new UIPage(context);
                ViewOnClickListenerC0318UI parent = getParent();
                if (parent != null) {
                    View view8 = parent.getView();
                    if (view8 instanceof Window) {
                        ((Window) view8).addTab(getAttribString(IL1Iii.IL1Iii(new byte[]{64, 95, 77, 95, 92}, IL1Iii.IL1Iii(new byte[]{85, 5, 10, 80, 13, 5}, IL1Iii.IL1Iii(new byte[]{5, 11, 6, 6, 85, 83}, "d85ea0")))), uIPage);
                        String attribString2 = getAttribString(IL1Iii.IL1Iii(new byte[]{91, 84, 80, 82, 2, 75, 86, 64, 93, 93}, IL1Iii.IL1Iii(new byte[]{95, 84, 87, 91, 93, 95}, IL1Iii.IL1Iii(new byte[]{84, 86, 2, 3, 14, 4}, "27fa6b"))));
                        this.mView = uIPage;
                        if (!TextUtils.isEmpty(attribString2)) {
                            l1IIi1.I1I().m1020lIiI(this.mView, attribString2);
                        }
                    }
                }
            } else {
                int i6 = 1;
                if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{116, 15, 95, 81, 4, 75, 116, 7, 72, 91, 16, 77}, IL1Iii.IL1Iii(new byte[]{9, 7, 8, 85, 80, 9}, IL1Iii.IL1Iii(new byte[]{2, 7, 8, 5, 0, 7}, "3f1d57")))) == 0) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getAttribInt(IL1Iii.IL1Iii(new byte[]{67, 81, 87, 69, 91}, IL1Iii.IL1Iii(new byte[]{3, 0, 80, 5, 5, 85}, IL1Iii.IL1Iii(new byte[]{14, 91, 85, 3, 83, 82}, "9c67ea"))), -1), getAttribInt(IL1Iii.IL1Iii(new byte[]{81, 92, 90, 6, 80, 17}, IL1Iii.IL1Iii(new byte[]{92, 11, 5, 80, 8, 80}, IL1Iii.IL1Iii(new byte[]{81, 11, 85, 82, 2, 80}, "49cc2e"))), -1));
                    int attribInt = getAttribInt(IL1Iii.IL1Iii(new byte[]{91, 68, 12, 6, 11, 67, 85, 66, 12, 12, 11}, IL1Iii.IL1Iii(new byte[]{5, 80, 80, 1, 0, 0}, IL1Iii.IL1Iii(new byte[]{83, 81, 6, 85, 86, 6}, "b73731"))), 1);
                    if (attribInt != 1) {
                        attribInt = 0;
                    }
                    linearLayout.setOrientation(attribInt);
                    String attribString3 = getAttribString(IL1Iii.IL1Iii(new byte[]{80, 15, 89, 80, 88}, IL1Iii.IL1Iii(new byte[]{85, 6, 85, 81, 7, 86}, IL1Iii.IL1Iii(new byte[]{2, 1, 84, 87, 7, 13}, "fd1169"))));
                    if (!TextUtils.isEmpty(attribString3)) {
                        linearLayout.setGravity(getAlign(attribString3));
                    }
                    setMargin(layoutParams);
                    linearLayout.setLayoutParams(layoutParams);
                    this.mView = linearLayout;
                    String attribString4 = getAttribString(IL1Iii.IL1Iii(new byte[]{86, 82, 82, 83, 6, 67, 91, 70, 95, 92}, IL1Iii.IL1Iii(new byte[]{6, 2, 1, 14, 2, 0}, IL1Iii.IL1Iii(new byte[]{6, 1, 3, 15, 6, 9}, "4039e8"))));
                    if (!TextUtils.isEmpty(attribString4)) {
                        l1IIi1.I1I().m1020lIiI(this.mView, attribString4);
                    }
                    setPadding();
                    layoutView(this.mView);
                    ViewOnClickListenerC0318UI parent2 = getParent();
                    if (parent2 != null) {
                        View view9 = parent2.getView();
                        if (view9 != null && (view9 instanceof UIPage)) {
                            ((UIPage) view9).addChildView(this.mView);
                        } else if (view9 != null && (view9 instanceof LinearLayout)) {
                            ((LinearLayout) view9).addView(this.mView);
                        }
                    }
                } else {
                    if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{49, 0, 72, 17, 48, 15, 0, 18}, IL1Iii.IL1Iii(new byte[]{82, 92, 4, 86, 95, 83}, IL1Iii.IL1Iii(new byte[]{6, 93, 7, 86, 9, 83}, "1d3e0f"))))) {
                        TextView textView = (TextView) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_text_view, (ViewGroup) null);
                        String attribString5 = getAttribString(IL1Iii.IL1Iii(new byte[]{76, 82, 79, 22}, IL1Iii.IL1Iii(new byte[]{14, 1, 83, 83, 8, 1}, IL1Iii.IL1Iii(new byte[]{4, 3, 6, 0, 11, 83}, "25b136"))));
                        int attribInt2 = getAttribInt(IL1Iii.IL1Iii(new byte[]{23, 0, 77, 23, 69, 91, 25, 0}, IL1Iii.IL1Iii(new byte[]{91, 81, 83, 6, 84, 7}, IL1Iii.IL1Iii(new byte[]{0, 13, 83, 92, 4, 80}, "8959fe"))), -1);
                        String attribString6 = getAttribString(IL1Iii.IL1Iii(new byte[]{69, 92, 77, 76, 86, 91, 93, 86, 71}, IL1Iii.IL1Iii(new byte[]{6, 9, 5, 0, 13, 12}, IL1Iii.IL1Iii(new byte[]{2, 8, 0, 15, 0, 0}, "580788"))));
                        if (TextUtils.isEmpty(attribString6)) {
                            textView.setTextColor(context.getResources().getColor(R.color.textcolor));
                        } else {
                            l1IIi1.I1I().m1014ILl(textView, attribString6);
                        }
                        String attribString7 = getAttribString(IL1Iii.IL1Iii(new byte[]{4, 10, 13, 85, 92}, IL1Iii.IL1Iii(new byte[]{0, 95, 5, 83, 0, 6}, IL1Iii.IL1Iii(new byte[]{93, 88, 89, 5, 6, 0}, "8a8d46"))));
                        String attribString8 = getAttribString(IL1Iii.IL1Iii(new byte[]{82, 5, 81, 10, 82, 69, 95, 17, 92, 5}, IL1Iii.IL1Iii(new byte[]{3, 81, 0, 4, 83, 5}, IL1Iii.IL1Iii(new byte[]{5, 83, 11, 82, 94, 87}, "6f978e"))));
                        if (!TextUtils.isEmpty(attribString8)) {
                            l1IIi1.I1I().m1020lIiI(textView, attribString8);
                        }
                        textView.setGravity(getAlign(attribString7));
                        if (attribInt2 > 0) {
                            textView.setTextSize(2, attribInt2);
                        }
                        if (attribString5 != null) {
                            textView.setText(attribString5);
                        }
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getAttribInt(IL1Iii.IL1Iii(new byte[]{64, 90, 81, 77, 88}, IL1Iii.IL1Iii(new byte[]{6, 85, 6, 15, 2, 4}, IL1Iii.IL1Iii(new byte[]{1, 94, 0, 84, 81, 5}, "083bcd"))), -2), getAttribInt(IL1Iii.IL1Iii(new byte[]{80, 83, 13, 86, 81, 68}, IL1Iii.IL1Iii(new byte[]{91, 0, 1, 6, 12, 2}, IL1Iii.IL1Iii(new byte[]{84, 3, 92, 0, 1, 87}, "75974e"))), -2));
                        setMargin(layoutParams2);
                        textView.setLayoutParams(layoutParams2);
                        this.mView = textView;
                        setPadding();
                        layoutView(this.mView);
                        ViewOnClickListenerC0318UI parent3 = getParent();
                        if (parent3 != null && (view7 = parent3.getView()) != null && (view7 instanceof LinearLayout)) {
                            ((LinearLayout) view7).addView(this.mView);
                        }
                        return this.mView;
                    }
                    if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{33, 5, 15, 76, 99, 93, 28, 21}, IL1Iii.IL1Iii(new byte[]{87, 86, 3, 13, 5, 15}, IL1Iii.IL1Iii(new byte[]{0, 85, 1, 12, 4, 4}, "3bd963"))))) {
                        int attribInt3 = getAttribInt(IL1Iii.IL1Iii(new byte[]{91, 90, 70, 23, 16, 21, 75, 68, 83}, IL1Iii.IL1Iii(new byte[]{84, 12, 3, 90, 81, 7}, IL1Iii.IL1Iii(new byte[]{0, 92, 3, 1, 1, 84}, "fd6942"))), 0);
                        EditText editText = attribInt3 == 2 ? (EditText) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_edit_passtext, (ViewGroup) null) : (EditText) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_edit_text, (ViewGroup) null);
                        boolean attribBoolean2 = getAttribBoolean(IL1Iii.IL1Iii(new byte[]{65, 10, 15, 82, 88, 80, 94, 10, 15, 80}, IL1Iii.IL1Iii(new byte[]{87, 84, 3, 3, 6, 6}, IL1Iii.IL1Iii(new byte[]{6, 15, 6, 83, 6, 85}, "c8de4f"))), true);
                        editText.setSingleLine(attribBoolean2);
                        if (!attribBoolean2) {
                            editText.setHorizontalScrollBarEnabled(false);
                            editText.setNextFocusDownId(editText.getId());
                        }
                        try {
                            Log.i(IL1Iii.IL1Iii(new byte[]{127, 96}, IL1Iii.IL1Iii(new byte[]{3, 92, 8, 3, 0, 83}, IL1Iii.IL1Iii(new byte[]{3, 84, 80, 87, 7, 1}, "10a6bd"))), IL1Iii.IL1Iii(new byte[]{13, 95, 17, 64, 64, 48, 29, 65, 4, 15}, IL1Iii.IL1Iii(new byte[]{82, 82, 4, 1, 5, 2}, IL1Iii.IL1Iii(new byte[]{83, 90, 84, 12, 0, 0}, "e9181f"))) + attribInt3);
                            if (attribInt3 == 0) {
                                editText.setInputType(attribBoolean2 ? 1 : 131073);
                            } else if (attribInt3 == 1) {
                                editText.setInputType(!attribBoolean2 ? 131074 : 2);
                            } else if (attribInt3 == 2) {
                                editText.setInputType(attribBoolean2 ? 1 : 131073);
                            }
                        } catch (Exception unused) {
                        }
                        String value = this.mWindow.getValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{80, 0}, IL1Iii.IL1Iii(new byte[]{13, 85, 81, 0, 85, 5}, IL1Iii.IL1Iii(new byte[]{85, 9, 4, 5, 82, 0}, "a80432")))));
                        if (value == null) {
                            value = getAttribString(IL1Iii.IL1Iii(new byte[]{64, 92, 64, 66}, IL1Iii.IL1Iii(new byte[]{13, 91, 12, 15, 7, 87}, IL1Iii.IL1Iii(new byte[]{0, 83, 5, 9, 84, 10}, "911019"))));
                        }
                        int attribInt4 = getAttribInt(IL1Iii.IL1Iii(new byte[]{67, 7, 64, 65, 68, 88, 77, 7}, IL1Iii.IL1Iii(new byte[]{14, 3, 11, 86, 1, 0}, IL1Iii.IL1Iii(new byte[]{12, 82, 7, 6, 87, 7}, "534ea6"))), -1);
                        String attribString9 = getAttribString(IL1Iii.IL1Iii(new byte[]{71, 83, 26, 65, 82, 95, 95, 89, 16}, IL1Iii.IL1Iii(new byte[]{6, 14, 85, 6, 5, 84}, IL1Iii.IL1Iii(new byte[]{6, 0, 14, 6, 87, 86}, "3895c2"))));
                        if (TextUtils.isEmpty(attribString9)) {
                            editText.setTextColor(context.getResources().getColor(R.color.textcolor));
                        } else {
                            l1IIi1.I1I().m1014ILl(editText, attribString9);
                        }
                        String attribString10 = getAttribString(IL1Iii.IL1Iii(new byte[]{89, 8, 95, 1, 11}, IL1Iii.IL1Iii(new byte[]{9, 83, 2, 7, 6, 5}, IL1Iii.IL1Iii(new byte[]{3, 2, 2, 5, 91, 4}, "256d8e"))));
                        String attribString11 = getAttribString(IL1Iii.IL1Iii(new byte[]{85, 89, 84, 94, 86, 74, 88, 77, 89, 81}, IL1Iii.IL1Iii(new byte[]{0, 91, 5, 84, 87, 90}, IL1Iii.IL1Iii(new byte[]{86, 90, 2, 7, 87, 81}, "a90f13"))));
                        if (!TextUtils.isEmpty(attribString11)) {
                            l1IIi1.I1I().m1020lIiI(editText, attribString11);
                        }
                        editText.setGravity(getAlign(attribString10));
                        if (attribInt4 > 0) {
                            editText.setTextSize(2, attribInt4);
                        }
                        if (value != null) {
                            editText.setText(value);
                        }
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getAttribInt(IL1Iii.IL1Iii(new byte[]{67, 12, 82, 18, 11}, IL1Iii.IL1Iii(new byte[]{0, 92, 83, 95, 6, 87}, IL1Iii.IL1Iii(new byte[]{5, 0, 80, 0, 6, 5}, "1959c3"))), -2), getAttribInt(IL1Iii.IL1Iii(new byte[]{13, 81, 92, 87, 80, 17}, IL1Iii.IL1Iii(new byte[]{86, 81, 12, 3, 9, 87}, IL1Iii.IL1Iii(new byte[]{85, 86, 93, 5, 2, 2}, "f3d630"))), -2));
                        setMargin(layoutParams3);
                        editText.setLayoutParams(layoutParams3);
                        this.mView = editText;
                        setPadding();
                        layoutView(this.mView);
                        ViewOnClickListenerC0318UI parent4 = getParent();
                        if (parent4 != null && (view6 = parent4.getView()) != null && (view6 instanceof LinearLayout)) {
                            ((LinearLayout) view6).addView(this.mView);
                        }
                        return this.mView;
                    }
                    if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{36, 68, 70, 71, 86, 15}, IL1Iii.IL1Iii(new byte[]{85, 2, 7, 82, 13, 85}, IL1Iii.IL1Iii(new byte[]{87, 85, 87, 83, 85, 7}, "dfb2a3"))))) {
                        Button button = (Button) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_button, (ViewGroup) null);
                        button.setAllCaps(false);
                        String value2 = this.mWindow.getValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{94, 7}, IL1Iii.IL1Iii(new byte[]{2, 5, 1, 91, 0, 1}, IL1Iii.IL1Iii(new byte[]{3, 94, 82, 89, 81, 2}, "686a4f")))));
                        if (value2 == null) {
                            value2 = getAttribString(IL1Iii.IL1Iii(new byte[]{77, 81, 18, 92, 82}, IL1Iii.IL1Iii(new byte[]{14, 10, 87, 9, 81, 14}, IL1Iii.IL1Iii(new byte[]{2, 83, 6, 1, 95, 14}, "5a7899"))));
                        }
                        int attribInt5 = getAttribInt(IL1Iii.IL1Iii(new byte[]{65, 83, 75, 70, 69, 10, 79, 83}, IL1Iii.IL1Iii(new byte[]{5, 2, 6, 10, 85, 82}, IL1Iii.IL1Iii(new byte[]{2, 0, 7, 0, 90, 85}, "24289d"))), -1);
                        String attribString12 = getAttribString(IL1Iii.IL1Iii(new byte[]{71, 84, 73, 77, 90, 87, 95, 94, 67}, IL1Iii.IL1Iii(new byte[]{7, 85, 83, 92, 93, 10}, IL1Iii.IL1Iii(new byte[]{81, 6, 81, 93, 92, 10}, "eb3888"))));
                        if (!TextUtils.isEmpty(attribString12)) {
                            l1IIi1.I1I().m1014ILl(button, attribString12);
                        }
                        String attribString13 = getAttribString(IL1Iii.IL1Iii(new byte[]{89, 15, 88, 3, 8}, IL1Iii.IL1Iii(new byte[]{8, 2, 85, 1, 7, 5}, IL1Iii.IL1Iii(new byte[]{7, 86, 1, 93, 88, 1}, "77e89e"))));
                        String attribString14 = getAttribString(IL1Iii.IL1Iii(new byte[]{3, 89, 83, 95, 1, 71, 14, 77, 94, 80}, IL1Iii.IL1Iii(new byte[]{5, 15, 6, 1, 5, 6}, IL1Iii.IL1Iii(new byte[]{80, 15, 7, 7, 6, 6}, "4812e5"))));
                        if (!TextUtils.isEmpty(attribString14)) {
                            l1IIi1.I1I().m1020lIiI(button, attribString14);
                        }
                        button.setOnClickListener(this);
                        button.setGravity(TextUtils.isEmpty(attribString13) ? 17 : getAlign(attribString13));
                        if (attribInt5 > 0) {
                            button.setTextSize(2, attribInt5);
                        }
                        if (value2 != null) {
                            button.setText(value2);
                        }
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getAttribInt(IL1Iii.IL1Iii(new byte[]{18, 89, 2, 67, 10}, IL1Iii.IL1Iii(new byte[]{84, 8, 2, 4, 86, 92}, IL1Iii.IL1Iii(new byte[]{4, 91, 5, 87, 6, 1}, "5cad28"))), -2), getAttribInt(IL1Iii.IL1Iii(new byte[]{13, 86, 81, 82, 88, 16}, IL1Iii.IL1Iii(new byte[]{86, 85, 0, 7, 7, 7}, IL1Iii.IL1Iii(new byte[]{85, 86, 11, 10, 3, 0}, "f0384c"))), -2));
                        setMargin(layoutParams4);
                        button.setLayoutParams(layoutParams4);
                        this.mView = button;
                        setPadding();
                        layoutView(this.mView);
                        ViewOnClickListenerC0318UI parent5 = getParent();
                        if (parent5 != null && (view5 = parent5.getView()) != null && (view5 instanceof LinearLayout)) {
                            ((LinearLayout) view5).addView(this.mView);
                        }
                        return this.mView;
                    }
                    if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{116, 14, 6, 90, 83, 39, 88, 30}, IL1Iii.IL1Iii(new byte[]{81, 83, 91, 93, 90, 83}, IL1Iii.IL1Iii(new byte[]{86, 81, 0, 5, 80, 84}, "0d8a2b"))))) {
                        CheckBox checkBox = (CheckBox) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_checkbox, (ViewGroup) null);
                        String attribString15 = getAttribString(IL1Iii.IL1Iii(new byte[]{65, 84, 25, 65}, IL1Iii.IL1Iii(new byte[]{7, 2, 83, 13, 87, 8}, IL1Iii.IL1Iii(new byte[]{86, 2, 2, 94, 90, 4}, "d10f85"))));
                        if (TextUtils.isEmpty(attribString15)) {
                            checkBox.setText(BuildConfig.FLAVOR);
                        } else {
                            checkBox.setText(attribString15);
                        }
                        String value3 = this.mWindow.getValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{8, 0}, IL1Iii.IL1Iii(new byte[]{0, 87, 83, 7, 4, 0}, IL1Iii.IL1Iii(new byte[]{82, 11, 87, 0, 83, 15}, "38fcd8")))));
                        try {
                            attribBoolean = Boolean.parseBoolean(value3);
                        } catch (Exception unused2) {
                            value3 = null;
                            attribBoolean = false;
                        }
                        if (value3 == null) {
                            attribBoolean = getAttribBoolean(IL1Iii.IL1Iii(new byte[]{68, 82, 89, 3, 86, 66, 82, 83}, IL1Iii.IL1Iii(new byte[]{2, 6, 84, 0, 7, 85}, IL1Iii.IL1Iii(new byte[]{0, 85, 7, 3, 2, 2}, "5dfe0a"))), false);
                        }
                        checkBox.setChecked(attribBoolean);
                        String attribString16 = getAttribString(IL1Iii.IL1Iii(new byte[]{66, 1, 64, 70, 1, 10, 90, 11, 74}, IL1Iii.IL1Iii(new byte[]{15, 5, 15, 4, 87, 80}, IL1Iii.IL1Iii(new byte[]{14, 83, 83, 85, 13, 5}, "72dc80"))));
                        if (!TextUtils.isEmpty(attribString16)) {
                            l1IIi1.I1I().m1014ILl(checkBox, attribString16);
                        }
                        int attribInt6 = getAttribInt(IL1Iii.IL1Iii(new byte[]{23, 3, 25, 64, 17, 95, 25, 3}, IL1Iii.IL1Iii(new byte[]{82, 3, 2, 87, 85, 5}, IL1Iii.IL1Iii(new byte[]{1, 80, 83, 87, 85, 7}, "0504b4"))), -1);
                        int attribInt7 = getAttribInt(IL1Iii.IL1Iii(new byte[]{18, 91, 93, 69, 10}, IL1Iii.IL1Iii(new byte[]{85, 84, 12, 83, 6, 14}, IL1Iii.IL1Iii(new byte[]{86, 82, 3, 83, 83, 93}, "f4617e"))), -2);
                        int attribInt8 = getAttribInt(IL1Iii.IL1Iii(new byte[]{13, 3, 81, 4, 80, 21}, IL1Iii.IL1Iii(new byte[]{1, 87, 10, 2, 14, 7}, IL1Iii.IL1Iii(new byte[]{85, 80, 86, 89, 3, 85}, "1ad853"))), -2);
                        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                        setMargin(layoutParams5);
                        checkBox.setLayoutParams(layoutParams5);
                        checkBox.setPadding(0, 0, 0, 0);
                        if (attribInt6 > 0) {
                            checkBox.setTextSize(2, attribInt6);
                        }
                        String attribString17 = getAttribString(IL1Iii.IL1Iii(new byte[]{83, 81, 81, 10, 84, 74, 94, 69, 92, 5}, IL1Iii.IL1Iii(new byte[]{1, 2, 2, 85, 86, 12}, IL1Iii.IL1Iii(new byte[]{84, 7, 1, 4, 92, 12}, "d51098"))));
                        if (TextUtils.isEmpty(attribString17) || (drawableM1021lLi1LL3 = l1IIi1.I1I().m1021lLi1LL(attribString17)) == null) {
                            i6 = 0;
                        } else {
                            if (attribInt7 <= 0 || attribInt8 <= 0) {
                                drawableM1021lLi1LL3.setBounds(0, 0, lIlii.Lil(context, 25), lIlii.Lil(context, 25));
                            } else {
                                drawableM1021lLi1LL3.setBounds(0, 0, lIlii.Lil(context, attribInt7), lIlii.Lil(context, attribInt8));
                            }
                            checkBox.setCompoundDrawables(drawableM1021lLi1LL3, null, null, null);
                        }
                        if (i6 == 0) {
                            Drawable drawable = context.getResources().getDrawable(R.drawable.selector_check_box);
                            if (attribInt7 <= 0 || attribInt8 <= 0) {
                                drawable.setBounds(0, 0, lIlii.Lil(context, 25), lIlii.Lil(context, 25));
                            } else {
                                drawable.setBounds(0, 0, lIlii.Lil(context, attribInt7), lIlii.Lil(context, attribInt8));
                            }
                            checkBox.setCompoundDrawables(drawable, null, null, null);
                        }
                        this.mView = checkBox;
                        layoutView(checkBox);
                        checkBox.setOnCheckedChangeListener(this);
                        ViewOnClickListenerC0318UI parent6 = getParent();
                        if (parent6 != null && (view4 = parent6.getView()) != null && (view4 instanceof LinearLayout)) {
                            ((LinearLayout) view4).addView(this.mView);
                        }
                        return this.mView;
                    }
                    if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{97, 82, 0, 94, 9, 38, 65, 92, 17, 71}, IL1Iii.IL1Iii(new byte[]{82, 11, 7, 83, 7, 0}, IL1Iii.IL1Iii(new byte[]{85, 1, 80, 87, 85, 5}, "49334d"))))) {
                        ViewOnClickListenerC0318UI parent7 = getParent();
                        if (parent7 == null || parent7.getView() == null) {
                            z = false;
                        } else {
                            View view10 = parent7.getView();
                            if ((view10 instanceof LinearLayout) && ((LinearLayout) view10).getOrientation() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        if (z) {
                            radioGroup = new FlowRadioGroup(context);
                            radioGroup.setOrientation(1);
                        } else {
                            radioGroup = new RadioGroup(context);
                            radioGroup.setOrientation(1);
                        }
                        try {
                            i3 = Integer.parseInt(this.mWindow.getValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{13, 5}, IL1Iii.IL1Iii(new byte[]{80, 82, 5, 81, 86, 2}, IL1Iii.IL1Iii(new byte[]{1, 86, 5, 86, 7, 3}, "5e4e25"))))));
                        } catch (Exception unused3) {
                            i3 = -1;
                        }
                        if (i3 == -1) {
                            try {
                                String attribString18 = getAttribString(IL1Iii.IL1Iii(new byte[]{75, 1, 89, 86, 82, 18}, IL1Iii.IL1Iii(new byte[]{91, 5, 3, 5, 3, 2}, IL1Iii.IL1Iii(new byte[]{5, 84, 1, 84, 10, 86}, "f57b82"))));
                                if (!TextUtils.isEmpty(attribString18)) {
                                    i3 = Integer.parseInt(attribString18);
                                }
                            } catch (Exception unused4) {
                            }
                        }
                        if (this.mChilds != null) {
                            int i7 = 0;
                            while (i7 < this.mChilds.size()) {
                                ViewOnClickListenerC0318UI viewOnClickListenerC0318UI = this.mChilds.get(i7);
                                if (viewOnClickListenerC0318UI != null && viewOnClickListenerC0318UI.getTag().compareTo(IL1Iii.IL1Iii(new byte[]{123, 64, 67, 11, 93, 15}, IL1Iii.IL1Iii(new byte[]{85, 84, 85, 3, 1, 81}, IL1Iii.IL1Iii(new byte[]{2, 0, 82, 83, 81, 0}, "cd02b0")))) == 0) {
                                    byte[] bArr = new byte[i5];
                                    // fill-array-data instruction
                                    bArr[0] = 65;
                                    bArr[1] = 85;
                                    bArr[2] = 73;
                                    bArr[3] = 65;
                                    String attribString19 = viewOnClickListenerC0318UI.getAttribString(IL1Iii.IL1Iii(bArr, IL1Iii.IL1Iii(new byte[]{4, 4, 7, 80, 86, 5}, IL1Iii.IL1Iii(new byte[]{5, 6, 87, 6, 82, 86}, "42ac35"))));
                                    int attribInt9 = viewOnClickListenerC0318UI.getAttribInt(IL1Iii.IL1Iii(new byte[]{70, 7, 30, 17, 17, 91, 72, 7}, IL1Iii.IL1Iii(new byte[]{10, 91, 0, 81, 86, 84}, IL1Iii.IL1Iii(new byte[]{1, 90, 0, 2, 86, 4}, "9cf6bb"))), -1);
                                    int attribInt10 = viewOnClickListenerC0318UI.getAttribInt(IL1Iii.IL1Iii(new byte[]{22, 90, 80, 69, 81}, IL1Iii.IL1Iii(new byte[]{3, 5, 86, 85, 10, 0}, IL1Iii.IL1Iii(new byte[]{1, 0, 0, 92, 85, 2}, "c6b8fd"))), -2);
                                    int attribInt11 = viewOnClickListenerC0318UI.getAttribInt(IL1Iii.IL1Iii(new byte[]{81, 1, 95, 4, 95, 71}, IL1Iii.IL1Iii(new byte[]{1, 81, 0, 91, 82, 86}, IL1Iii.IL1Iii(new byte[]{0, 7, 6, 11, 7, 93}, "8203b8"))), -2);
                                    RadioButton radioButton = (RadioButton) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_radio_button, (ViewGroup) null);
                                    radioButton.setId(i7);
                                    if (attribInt9 > 0) {
                                        radioButton.setTextSize(2, attribInt9);
                                    }
                                    String attribString20 = viewOnClickListenerC0318UI.getAttribString(IL1Iii.IL1Iii(new byte[]{22, 82, 72, 76, 7, 95, 14, 88, 66}, IL1Iii.IL1Iii(new byte[]{87, 2, 8, 1, 93, 82}, IL1Iii.IL1Iii(new byte[]{80, 12, 10, 90, 14, 85}, "e92c77"))));
                                    if (!TextUtils.isEmpty(attribString20)) {
                                        l1IIi1.I1I().m1014ILl(radioButton, attribString20);
                                    }
                                    if (!TextUtils.isEmpty(attribString19)) {
                                        radioButton.setText(attribString19);
                                    }
                                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                                    setMargin(layoutParams6);
                                    radioButton.setLayoutParams(layoutParams6);
                                    radioButton.setPadding(0, lIlii.m1157ii1(context, 5), 0, lIlii.m1157ii1(context, 5));
                                    String attribString21 = getAttribString(IL1Iii.IL1Iii(new byte[]{3, 80, 87, 93, 84, 66, 14, 68, 90, 82}, IL1Iii.IL1Iii(new byte[]{88, 5, 2, 80, 81, 5}, IL1Iii.IL1Iii(new byte[]{11, 81, 3, 83, 7, 0}, "2e55e5"))));
                                    Drawable drawableM1021lLi1LL4 = !TextUtils.isEmpty(attribString21) ? l1IIi1.I1I().m1021lLi1LL(attribString21) : null;
                                    if (drawableM1021lLi1LL4 == null) {
                                        drawableM1021lLi1LL4 = context.getResources().getDrawable(R.drawable.selector_radio_button);
                                    }
                                    if (attribInt10 <= 0 || attribInt11 <= 0) {
                                        drawableM1021lLi1LL4.setBounds(0, 0, lIlii.Lil(context, 25), lIlii.Lil(context, 25));
                                    } else {
                                        drawableM1021lLi1LL4.setBounds(0, 0, lIlii.Lil(context, attribInt10), lIlii.Lil(context, attribInt11));
                                    }
                                    radioButton.setCompoundDrawables(drawableM1021lLi1LL4, null, null, null);
                                    radioGroup.addView(radioButton);
                                }
                                i7++;
                                i5 = 4;
                            }
                            radioGroup.clearCheck();
                            if (i3 < 0 || i3 >= this.mChilds.size()) {
                                radioGroup.check(0);
                            } else {
                                radioGroup.check(i3);
                            }
                        }
                        this.mView = radioGroup;
                        layoutView(radioGroup);
                        radioGroup.setOnCheckedChangeListener(this);
                        ViewOnClickListenerC0318UI parent8 = getParent();
                        if (parent8 != null && (view3 = parent8.getView()) != null && (view3 instanceof LinearLayout)) {
                            ((LinearLayout) view3).addView(this.mView);
                        }
                        return radioGroup;
                    }
                    if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{123, 12, 12, 87, 91, 117, 87, 27}, IL1Iii.IL1Iii(new byte[]{9, 1, 84, 81, 81, 85}, IL1Iii.IL1Iii(new byte[]{84, 85, 2, 84, 92, 81}, "e77093")))) == 0) {
                        final Spinner spinner = (Spinner) UIMgr.getInstance().getLayoutInflater().inflate(R.layout.ui_spinner, (ViewGroup) null);
                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(getAttribInt(IL1Iii.IL1Iii(new byte[]{71, 8, 81, 18, 13}, IL1Iii.IL1Iii(new byte[]{4, 4, 5, 94, 82, 5}, IL1Iii.IL1Iii(new byte[]{82, 92, 5, 15, 82, 8}, "f957e9"))), -2), getAttribInt(IL1Iii.IL1Iii(new byte[]{9, 85, 80, 82, 80, 68}, IL1Iii.IL1Iii(new byte[]{0, 86, 93, 2, 11, 3}, IL1Iii.IL1Iii(new byte[]{81, 2, 5, 0, 3, 81}, "0da70b"))), -2));
                        setMargin(layoutParams7);
                        spinner.setLayoutParams(layoutParams7);
                        String attribString22 = getAttribString(IL1Iii.IL1Iii(new byte[]{85, 82, 85, 93, 5, 65, 88, 70, 88, 82}, IL1Iii.IL1Iii(new byte[]{7, 3, 82, 82, 4, 81}, IL1Iii.IL1Iii(new byte[]{5, 2, 5, 93, 84, 81}, "52a923"))));
                        if (!TextUtils.isEmpty(attribString22) && (drawableM1021lLi1LL2 = l1IIi1.I1I().m1021lLi1LL(attribString22)) != null) {
                            spinner.setPopupBackgroundDrawable(drawableM1021lLi1LL2);
                        }
                        try {
                            i2 = Integer.parseInt(this.mWindow.getValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{13, 93}, IL1Iii.IL1Iii(new byte[]{80, 88, 81, 0, 1, 87}, IL1Iii.IL1Iii(new byte[]{12, 85, 3, 8, 15, 2}, "840877"))))));
                        } catch (Exception unused5) {
                            i2 = -1;
                        }
                        if (i2 == -1) {
                            try {
                                String attribString23 = getAttribString(IL1Iii.IL1Iii(new byte[]{22, 86, 94, 84, 7, 65}, IL1Iii.IL1Iii(new byte[]{3, 86, 11, 9, 1, 86}, IL1Iii.IL1Iii(new byte[]{0, 80, 8, 9, 6, 5}, "f511cf"))));
                                if (!TextUtils.isEmpty(attribString23)) {
                                    i2 = Integer.parseInt(attribString23);
                                }
                            } catch (Exception unused6) {
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        if (this.mChilds != null) {
                            for (int i8 = 0; i8 < this.mChilds.size(); i8++) {
                                ViewOnClickListenerC0318UI viewOnClickListenerC0318UI2 = this.mChilds.get(i8);
                                if (viewOnClickListenerC0318UI2 != null && viewOnClickListenerC0318UI2.getTag().compareTo(IL1Iii.IL1Iii(new byte[]{125, 72, 21, 91, 92, 92}, IL1Iii.IL1Iii(new byte[]{86, 8, 87, 0, 80, 0}, IL1Iii.IL1Iii(new byte[]{85, 0, 14, 7, 87, 11}, "108549")))) == 0) {
                                    String attribString24 = viewOnClickListenerC0318UI2.getAttribString(IL1Iii.IL1Iii(new byte[]{64, 4, 27, 66}, IL1Iii.IL1Iii(new byte[]{1, 88, 87, 0, 81, 14}, IL1Iii.IL1Iii(new byte[]{84, 15, 82, 85, 0, 4}, "a6fc03"))));
                                    String attribString25 = viewOnClickListenerC0318UI2.getAttribString(IL1Iii.IL1Iii(new byte[]{22, 85, 77, 71, 91, 86, 14, 95, 71}, IL1Iii.IL1Iii(new byte[]{84, 1, 1, 80, 12, 0}, IL1Iii.IL1Iii(new byte[]{15, 3, 12, 2, 82, 15}, "928af6"))));
                                    int attribInt12 = viewOnClickListenerC0318UI2.getAttribInt(IL1Iii.IL1Iii(new byte[]{17, 1, 30, 68, 74, 81, 31, 1}, IL1Iii.IL1Iii(new byte[]{83, 6, 95, 4, 91, 0}, IL1Iii.IL1Iii(new byte[]{5, 87, 9, 80, 84, 0}, "350d68"))), -1);
                                    lLi1LL.IL il = new lLi1LL.IL();
                                    if (TextUtils.isEmpty(attribString25)) {
                                        il.f3510ILil = context.getResources().getColor(R.color.textcolor);
                                    } else {
                                        il.f3510ILil = l1IIi1.I1I().Ilil(attribString25);
                                    }
                                    il.f3509IL1Iii = attribString24;
                                    il.f3508I1I = attribInt12;
                                    arrayList.add(il);
                                }
                            }
                        }
                        spinner.setAdapter((SpinnerAdapter) new lLi1LL.I1I(spinner.getContext(), arrayList));
                        this.mView = spinner;
                        layoutView(spinner);
                        ViewOnClickListenerC0318UI parent9 = getParent();
                        if (parent9 != null && (view2 = parent9.getView()) != null && (view2 instanceof LinearLayout)) {
                            ((LinearLayout) view2).addView(this.mView);
                        }
                        List<ViewOnClickListenerC0318UI> list = this.mChilds;
                        if (list != null && i2 >= 0 && i2 < list.size()) {
                            try {
                                Log.i(IL1Iii.IL1Iii(new byte[]{45, 58}, IL1Iii.IL1Iii(new byte[]{86, 80, 91, 8, 6, 86}, IL1Iii.IL1Iii(new byte[]{13, 3, 93, 15, 4, 90}, "81e728"))), IL1Iii.IL1Iii(new byte[]{54, 104, 45, 126, 123, 124, 55, 8, 89, 13, 11}, IL1Iii.IL1Iii(new byte[]{87, 15, 84, 81, 12, 11}, IL1Iii.IL1Iii(new byte[]{5, 5, 85, 88, 91, 80}, "72e9bb"))) + spinner);
                                spinner.setSelection(i2, false);
                                spinner.setOnTouchListener(new View.OnTouchListener() { // from class: com.nx.assist.ui.UI.1
                                    @Override // android.view.View.OnTouchListener
                                    public boolean onTouch(View view11, MotionEvent motionEvent) {
                                        ViewOnClickListenerC0318UI.this.isUserClicked = true;
                                        view11.performClick();
                                        return false;
                                    }
                                });
                                spinner.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.nx.assist.ui.UI.2
                                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                                    public void onGlobalLayout() {
                                        spinner.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                        spinner.setSelection(i2);
                                    }
                                });
                            } catch (Exception e) {
                                Log.i(IL1Iii.IL1Iii(new byte[]{40, 61}, IL1Iii.IL1Iii(new byte[]{7, 82, 0, 14, 92, 7}, IL1Iii.IL1Iii(new byte[]{84, 1, 85, 91, 87, 82}, "56bb3c"))), e.toString());
                            }
                        }
                        spinner.setOnItemSelectedListener(this);
                        return this.mView;
                    }
                    i4 = 0;
                    if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{96, 80, 7, 55, 81, 6, 64}, IL1Iii.IL1Iii(new byte[]{6, 81, 6, 83, 8, 82}, IL1Iii.IL1Iii(new byte[]{87, 5, 0, 7, 5, 7}, "fac556"))))) {
                        int attribInt13 = getAttribInt(IL1Iii.IL1Iii(new byte[]{79, 91, 1, 70, 89}, IL1Iii.IL1Iii(new byte[]{93, 80, 4, 7, 7, 82}, IL1Iii.IL1Iii(new byte[]{86, 80, 80, 81, 3, 84}, "321d51"))), -2);
                        int attribInt14 = getAttribInt(IL1Iii.IL1Iii(new byte[]{14, 93, 8, 82, 13, 64}, IL1Iii.IL1Iii(new byte[]{82, 11, 89, 4, 0, 81}, IL1Iii.IL1Iii(new byte[]{81, 11, 89, 3, 80, 7}, "e8a25b"))), -2);
                        String attribString26 = getAttribString(IL1Iii.IL1Iii(new byte[]{64, 67, 92}, IL1Iii.IL1Iii(new byte[]{86, 85, 83, 87, 88, 3}, IL1Iii.IL1Iii(new byte[]{7, 85, 82, 87, 14, 87}, "d11d75"))));
                        if (!TextUtils.isEmpty(attribString26)) {
                            File file = new File(l1IIi1.I1I().m1022il(), attribString26);
                            if (file.exists()) {
                                attribString26 = IL1Iii.IL1Iii(new byte[]{80, 12, 84, 85, 15, 22, 25}, IL1Iii.IL1Iii(new byte[]{3, 84, 9, 86, 7, 93}, IL1Iii.IL1Iii(new byte[]{86, 2, 7, 94, 81, 84}, "c368c0"))) + file.getAbsolutePath();
                            }
                        }
                        try {
                            i = 2;
                            try {
                                x5WebViewM1303lIiI = lLi1LL.m1303lIiI(context, 1, UUID.randomUUID().toString(), attribInt13, attribInt14, attribString26, this);
                            } catch (Exception e2) {
                                e = e2;
                                byte[] bArr2 = new byte[i];
                                // fill-array-data instruction
                                bArr2[0] = 42;
                                bArr2[1] = 61;
                                Log.i(IL1Iii.IL1Iii(bArr2, IL1Iii.IL1Iii(new byte[]{7, 81, 90, 80, 11, 14}, IL1Iii.IL1Iii(new byte[]{1, 12, 86, 84, 6, 15}, "b85048"))), e.toString());
                                x5WebViewM1303lIiI = null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i = 2;
                        }
                        if (x5WebViewM1303lIiI != null) {
                            String attribString27 = getAttribString(IL1Iii.IL1Iii(new byte[]{4, 2, 85, 83, 81, 75, 9, 22, 88, 92}, IL1Iii.IL1Iii(new byte[]{80, 82, 83, 89, 82, 9}, IL1Iii.IL1Iii(new byte[]{1, 87, 82, 86, 93, 1}, "7f7791"))));
                            if (!TextUtils.isEmpty(attribString27) && (drawableM1021lLi1LL = l1IIi1.I1I().m1021lLi1LL(attribString27)) != null) {
                                x5WebViewM1303lIiI.setBackground(drawableM1021lLi1LL);
                            }
                            this.mView = x5WebViewM1303lIiI;
                            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(attribInt13, attribInt14);
                            setMargin(layoutParams8);
                            this.mView.setLayoutParams(layoutParams8);
                            layoutView(this.mView);
                            ViewOnClickListenerC0318UI parent10 = getParent();
                            if (parent10 != null && (view = parent10.getView()) != null && (view instanceof LinearLayout)) {
                                ((LinearLayout) view).addView(this.mView);
                            }
                            return this.mView;
                        }
                    }
                }
            }
        }
        if (this.mChilds != null && this.mView != null) {
            while (i4 < this.mChilds.size()) {
                this.mChilds.get(i4).inflateViewImp(context);
                i4++;
            }
        }
        return this.mView;
    }

    private void layoutView(View view) {
        try {
            int attribInt = getAttribInt(IL1Iii.IL1Iii(new byte[]{66, 88, 9, 64, 69, 76, 65, 85}, IL1Iii.IL1Iii(new byte[]{3, 0, 80, 6, 80, 4}, IL1Iii.IL1Iii(new byte[]{3, 86, 5, 84, 0, 6}, "1f3ea7"))), 0);
            if (attribInt == 0 || attribInt == 4 || attribInt == 8) {
                view.setVisibility(attribInt);
            }
        } catch (Exception unused) {
        }
    }

    private void setMargin(LinearLayout.LayoutParams layoutParams) {
        Rect rect;
        String attribString = getAttribString(IL1Iii.IL1Iii(new byte[]{11, 2, 74, 95, 8, 93}, IL1Iii.IL1Iii(new byte[]{95, 7, 93, 94, 0, 5}, IL1Iii.IL1Iii(new byte[]{14, 0, 7, 82, 7, 87}, "7db4fa"))));
        if (!TextUtils.isEmpty(attribString) && (rect = getRect(attribString)) != null) {
            layoutParams.setMargins(rect.left, rect.top, rect.right, rect.bottom);
        }
        boolean z = false;
        ViewOnClickListenerC0318UI parent = getParent();
        if (parent != null && (parent.getTag().equals(IL1Iii.IL1Iii(new byte[]{102, 5, 1, 6}, IL1Iii.IL1Iii(new byte[]{2, 87, 81, 87, 5, 13}, IL1Iii.IL1Iii(new byte[]{82, 3, 84, 81, 93, 85}, "f0ce9a")))) || parent.getAttribInt(IL1Iii.IL1Iii(new byte[]{86, 74, 13, 83, 15, 69, 88, 76, 13, 89, 15}, IL1Iii.IL1Iii(new byte[]{11, 12, 87, 82, 2, 84}, IL1Iii.IL1Iii(new byte[]{1, 80, 2, 84, 80, 86}, "3d1033"))), 1) != 0)) {
            z = true;
        }
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (z) {
            if (i2 == -1) {
                layoutParams.weight = 1.0f;
            }
        } else if (i == -1) {
            layoutParams.weight = 1.0f;
        }
    }

    private void setPadding() {
        Rect rect;
        String attribString = getAttribString(IL1Iii.IL1Iii(new byte[]{70, 87, 86, 86, 94, 95, 81}, IL1Iii.IL1Iii(new byte[]{7, 87, 81, 7, 4, 2}, IL1Iii.IL1Iii(new byte[]{6, 5, 81, 13, 82, 6}, "7d28a5"))));
        if (TextUtils.isEmpty(attribString) || (rect = getRect(attribString)) == null) {
            return;
        }
        this.mView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean addChild(ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) {
        if (viewOnClickListenerC0318UI == null) {
            return false;
        }
        viewOnClickListenerC0318UI.setParent(this);
        String tag = viewOnClickListenerC0318UI.getTag();
        if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{49, 13, 10, 81, 13, 22}, IL1Iii.IL1Iii(new byte[]{5, 87, 84, 83, 7, 84}, IL1Iii.IL1Iii(new byte[]{86, 86, 4, 0, 87, 81}, "5e4f2d")))) != 0 && this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{98, 83, 80, 86}, IL1Iii.IL1Iii(new byte[]{80, 2, 3, 85, 0, 2}, IL1Iii.IL1Iii(new byte[]{84, 8, 82, 0, 86, 0}, "68ff2d")))) != 0) {
            viewOnClickListenerC0318UI.setIndex(this.mIndex);
        }
        if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{101, 93, 93, 81, 92, 17}, IL1Iii.IL1Iii(new byte[]{83, 3, 87, 86, 87, 81}, IL1Iii.IL1Iii(new byte[]{84, 1, 84, 5, 7, 81}, "560fcf")))) == 0) {
            if (tag.compareTo(IL1Iii.IL1Iii(new byte[]{49, 84, 81, 4}, IL1Iii.IL1Iii(new byte[]{5, 4, 80, 82, 84, 2}, IL1Iii.IL1Iii(new byte[]{0, 85, 4, 7, 3, 80}, "ddb4fb")))) != 0) {
                return false;
            }
            viewOnClickListenerC0318UI.setIndex(this.mIndex);
            this.mIndex++;
            this.mChilds.add(viewOnClickListenerC0318UI);
            return true;
        }
        if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{103, 83, 86, 0}, IL1Iii.IL1Iii(new byte[]{84, 2, 83, 1, 82, 80}, IL1Iii.IL1Iii(new byte[]{81, 2, 3, 85, 7, 0}, "22a1e1")))) == 0 || this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{124, 10, 12, 93, 82, 75, 124, 2, 27, 87, 70, 77}, IL1Iii.IL1Iii(new byte[]{83, 5, 80, 11, 87, 8}, IL1Iii.IL1Iii(new byte[]{87, 94, 2, 87, 84, 80}, "480d0a")))) == 0) {
            if (tag.compareTo(IL1Iii.IL1Iii(new byte[]{99, 85, 82, 0}, IL1Iii.IL1Iii(new byte[]{11, 0, 86, 4, 81, 11}, IL1Iii.IL1Iii(new byte[]{11, 13, 82, 86, 2, 13}, "391765")))) == 0 || tag.compareTo(IL1Iii.IL1Iii(new byte[]{97, 94, 92, 80, 14, 18}, IL1Iii.IL1Iii(new byte[]{85, 84, 0, 5, 80, 93}, IL1Iii.IL1Iii(new byte[]{1, 5, 11, 0, 87, 8}, "bf91f0")))) == 0) {
                return false;
            }
            if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{52, 0, 87, 7}, IL1Iii.IL1Iii(new byte[]{80, 89, 5, 82, 7, 5}, IL1Iii.IL1Iii(new byte[]{85, 12, 1, 1, 80, 5}, "a4414f")))) == 0) {
                viewOnClickListenerC0318UI.setIndex(this.mIndex);
            }
            this.mChilds.add(viewOnClickListenerC0318UI);
            return true;
        }
        if ((this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{119, 89, 14, 6, 10, 116, 91, 78}, IL1Iii.IL1Iii(new byte[]{6, 15, 91, 80, 0, 87}, IL1Iii.IL1Iii(new byte[]{6, 8, 9, 6, 0, 4}, "4112ee")))) != 0 && this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{114, 95, 82, 83, 93, 114, 94, 79, 112, 66, 89, 69, 65}, IL1Iii.IL1Iii(new byte[]{80, 15, 81, 2, 6, 4}, IL1Iii.IL1Iii(new byte[]{5, 90, 3, 10, 82, 2}, "dbe8b6")))) != 0 && this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{99, 87, 81, 88, 93, 126, 67, 89, 64, 65}, IL1Iii.IL1Iii(new byte[]{1, 0, 5, 1, 4, 1}, IL1Iii.IL1Iii(new byte[]{86, 15, 7, 2, 6, 94}, "f9720f")))) != 0) || tag.compareTo(IL1Iii.IL1Iii(new byte[]{126, 66, 77, 13, 90, 86}, IL1Iii.IL1Iii(new byte[]{4, 84, 93, 82, 80, 8}, IL1Iii.IL1Iii(new byte[]{12, 5, 2, 83, 92, 0}, "9cfe90")))) != 0) {
            return false;
        }
        this.mChilds.add(viewOnClickListenerC0318UI);
        return true;
    }

    public String checkResult() {
        if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{49, 86, 78, 17, 48, 13, 0, 68}, IL1Iii.IL1Iii(new byte[]{83, 1, 82, 93, 84, 92}, IL1Iii.IL1Iii(new byte[]{3, 6, 7, 89, 4, 15}, "54ca67")))) || this.mTag.equals(IL1Iii.IL1Iii(new byte[]{123, 22, 70, 76, 11, 92}, IL1Iii.IL1Iii(new byte[]{0, 7, 80, 12, 6, 3}, IL1Iii.IL1Iii(new byte[]{8, 7, 80, 7, 7, 8}, "1c23e9")))) || this.mTag.equals(IL1Iii.IL1Iii(new byte[]{35, 1, 88, 77, 48, 87, 30, 17}, IL1Iii.IL1Iii(new byte[]{4, 0, 0, 13, 92, 1}, IL1Iii.IL1Iii(new byte[]{81, 93, 8, 12, 92, 6}, "3898d5"))))) {
            View view = this.mView;
            if (view != null && (view instanceof TextView)) {
                this.mWindow.setValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{88, 2}, IL1Iii.IL1Iii(new byte[]{80, 83, 8, 90, 0, 87}, IL1Iii.IL1Iii(new byte[]{2, 84, 10, 15, 2, 4}, "ca273b")))), ((TextView) view).getText().toString());
            }
            return null;
        }
        if (this.mTag.equals(IL1Iii.IL1Iii(new byte[]{33, 14, 83, 1, 88, 38, 13, 30}, IL1Iii.IL1Iii(new byte[]{0, 84, 4, 86, 10, 86}, IL1Iii.IL1Iii(new byte[]{87, 80, 1, 1, 92, 4}, "5b35e6"))))) {
            View view2 = this.mView;
            if (view2 != null && (view2 instanceof CheckBox)) {
                this.mWindow.setValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{81, 84}, IL1Iii.IL1Iii(new byte[]{10, 6, 82, 2, 1, 90}, IL1Iii.IL1Iii(new byte[]{83, 6, 4, 81, 8, 85}, "a02f17")))), Boolean.toString(((CheckBox) view2).isChecked()));
            }
            return null;
        }
        if (!this.mTag.equals(IL1Iii.IL1Iii(new byte[]{33, 94, 94, 4, 95, 39, 13, 73}, IL1Iii.IL1Iii(new byte[]{85, 4, 11, 3, 84, 82}, IL1Iii.IL1Iii(new byte[]{7, 6, 0, 82, 93, 7}, "038790")))) && !this.mTag.equals(IL1Iii.IL1Iii(new byte[]{55, 80, 1, 94, 14, 113, 23, 94, 16, 71}, IL1Iii.IL1Iii(new byte[]{93, 5, 85, 7, 84, 2}, IL1Iii.IL1Iii(new byte[]{89, 3, 5, 0, 1, 3}, "a75047"))))) {
            if (this.mChilds != null) {
                for (int i = 0; i < this.mChilds.size(); i++) {
                    this.mChilds.get(i).checkResult();
                }
            }
            if (this.mTag.compareTo(IL1Iii.IL1Iii(new byte[]{100, 10, 8, 92, 91, 64}, IL1Iii.IL1Iii(new byte[]{10, 5, 4, 90, 13, 4}, IL1Iii.IL1Iii(new byte[]{1, 86, 84, 81, 15, 80}, "80636c")))) == 0) {
                try {
                    return new Gson().toJson(this.mValues);
                } catch (Exception e) {
                    Log.i(IL1Iii.IL1Iii(new byte[]{42, 108}, IL1Iii.IL1Iii(new byte[]{83, 87, 3, 91, 81, 87}, IL1Iii.IL1Iii(new byte[]{6, 81, 5, 12, 85, 83}, "12d577"))), e.toString());
                }
            }
            return null;
        }
        View view3 = this.mView;
        if (view3 != null && (view3 instanceof RadioGroup)) {
            this.mWindow.setValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{94, 1}, IL1Iii.IL1Iii(new byte[]{81, 7, 10, 10, 90, 90}, IL1Iii.IL1Iii(new byte[]{85, 6, 0, 4, 3, 14}, "3d36a7")))), Integer.toString(((RadioGroup) view3).getCheckedRadioButtonId()));
        }
        View view4 = this.mView;
        if (view4 != null && (view4 instanceof Spinner)) {
            this.mWindow.setValue(this.mIndex, getAttribString(IL1Iii.IL1Iii(new byte[]{11, 6}, IL1Iii.IL1Iii(new byte[]{90, 0, 7, 2, 84, 7}, IL1Iii.IL1Iii(new byte[]{14, 82, 4, 2, 83, 0}, "60f70c")))), Integer.toString(((Spinner) view4).getSelectedItemPosition()));
        }
        return null;
    }

    public boolean getAttribBoolean(String str, boolean z) {
        try {
            String str2 = this.attrib.get(str);
            return !TextUtils.isEmpty(str2) ? Boolean.parseBoolean(str2) : z;
        } catch (Exception unused) {
            return z;
        }
    }

    public int getAttribInt(String str, int i) {
        try {
            String str2 = this.attrib.get(str);
            return !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : i;
        } catch (Exception unused) {
            return i;
        }
    }

    public String getAttribString(String str) {
        return this.attrib.get(str);
    }

    public int getHandle() {
        return this.mHandle;
    }

    public ViewOnClickListenerC0318UI getParent() {
        return this.mParent;
    }

    public String getTag() {
        return this.mTag;
    }

    public String getUIValue(String str, int i, String str2) {
        CharSequence text;
        if (this.mIndex == i) {
            String attribString = getAttribString(IL1Iii.IL1Iii(new byte[]{88, 87}, IL1Iii.IL1Iii(new byte[]{8, 2, 84, 0, 0, 80}, IL1Iii.IL1Iii(new byte[]{12, 8, 87, 92, 4, 1}, "59fd1e"))));
            if (str != null && attribString != null && str2 != null && str2.compareTo(attribString) == 0) {
                if (str.equals(IL1Iii.IL1Iii(new byte[]{85, 81, 65, 66, 11, 64, 87, 76, 65, 84, 13, 88, 93, 70}, IL1Iii.IL1Iii(new byte[]{81, 81, 0, 5, 6, 13}, IL1Iii.IL1Iii(new byte[]{6, 84, 13, 2, 83, 13}, "e18074"))))) {
                    View view = this.mView;
                    if (view != null && (view instanceof TextView)) {
                        return Integer.toHexString(((TextView) view).getCurrentTextColor());
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{5, 4, 71, 77, 12, 82, 12, 0, 81, 84, 0}, IL1Iii.IL1Iii(new byte[]{0, 85, 86, 0, 84, 83}, IL1Iii.IL1Iii(new byte[]{4, 2, 92, 15, 87, 83}, "f697f7"))))) {
                    View view2 = this.mView;
                    if (view2 != null) {
                        return Boolean.toString(view2.isEnabled());
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{5, 92, 66, 69, 13, 71, 11, 74, 95, 82, 8, 84}, IL1Iii.IL1Iii(new byte[]{82, 1, 2, 83, 87, 87}, IL1Iii.IL1Iii(new byte[]{7, 15, 5, 85, 87, 80}, "7716d6"))))) {
                    View view3 = this.mView;
                    if (view3 != null) {
                        return Integer.toString(view3.getVisibility());
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{85, 4, 22, 67, 91, 66, 87, 25, 22}, IL1Iii.IL1Iii(new byte[]{1, 7, 83, 85, 11, 2}, IL1Iii.IL1Iii(new byte[]{5, 84, 85, 90, 91, 2}, "62d9b6"))))) {
                    View view4 = this.mView;
                    if (view4 != null && (view4 instanceof TextView)) {
                        return ((TextView) view4).getText().toString();
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{94, 93, 16, 66, 88, 6, 81, 93, 7, 92, 84, 1}, IL1Iii.IL1Iii(new byte[]{12, 15, 83, 0, 1, 80}, IL1Iii.IL1Iii(new byte[]{87, 14, 86, 1, 83, 0}, "b9a6c5"))))) {
                    View view5 = this.mView;
                    if (view5 != null && (view5 instanceof CheckBox)) {
                        return Boolean.toString(((CheckBox) view5).isChecked());
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{4, 87, 18, 20, 88, 21, 6, 94, 3, 2, 69, 3, 7}, IL1Iii.IL1Iii(new byte[]{81, 0, 0, 87, 82, 85}, IL1Iii.IL1Iii(new byte[]{11, 81, 2, 14, 1, 2}, "9cd8b1"))))) {
                    View view6 = this.mView;
                    if (view6 != null) {
                        if (view6 instanceof RadioGroup) {
                            return Integer.toString(((RadioGroup) view6).getCheckedRadioButtonId());
                        }
                        if (view6 instanceof Spinner) {
                            return Integer.toString(((Spinner) view6).getSelectedItemPosition());
                        }
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{81, 81, 76, 70, 6, 85, 83, 87, 76, 65, 6, 65, 66}, IL1Iii.IL1Iii(new byte[]{85, 82, 92, 5, 91, 10}, IL1Iii.IL1Iii(new byte[]{82, 95, 80, 0, 11, 81}, "19403b"))))) {
                    View view7 = this.mView;
                    if (view7 != null) {
                        if (view7 instanceof RadioGroup) {
                            RadioButton radioButton = (RadioButton) this.mView.findViewById(((RadioGroup) view7).getCheckedRadioButtonId());
                            return (radioButton == null || (text = radioButton.getText()) == null) ? BuildConfig.FLAVOR : text.toString();
                        }
                        if (view7 instanceof Spinner) {
                            Spinner spinner = (Spinner) view7;
                            lLi1LL.IL il = (lLi1LL.IL) spinner.getItemAtPosition(spinner.getSelectedItemPosition());
                            return il != null ? il.f3509IL1Iii : BuildConfig.FLAVOR;
                        }
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{2, 4, 69, 68, 95, 67, 0, 3, 71, 88, 83, 67, 16, 19, 93}, IL1Iii.IL1Iii(new byte[]{87, 81, 0, 5, 6, 7}, IL1Iii.IL1Iii(new byte[]{83, 5, 2, 82, 4, 80}, "a53f4c"))))) {
                    try {
                        View view8 = this.mView;
                        if (view8 instanceof X5WebView) {
                            return ((X5WebView) view8).getUrl();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (this.mChilds == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.mChilds.size(); i2++) {
            String uIValue = this.mChilds.get(i2).getUIValue(str, i, str2);
            if (uIValue != null) {
                return uIValue;
            }
        }
        return null;
    }

    public String getValue(int i, String str) {
        if (i < 0 || this.mValuesRead == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, String> map = this.mValuesRead.get(IL1Iii.IL1Iii(new byte[]{69, 4, 81, 81}, IL1Iii.IL1Iii(new byte[]{84, 82, 4, 6, 82, 84}, IL1Iii.IL1Iii(new byte[]{0, 82, 11, 0, 3, 0}, "ae92ba"))) + i);
        if (map == null || map.get(str) == null) {
            return null;
        }
        return map.get(str);
    }

    public View getView() {
        return this.mView;
    }

    public ViewOnClickListenerC0318UI getWindow() {
        return this.mWindow;
    }

    public View inflateView(Context context) {
        return inflateViewImp(context);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        UIMgr.getInstance().sendEvent(this.mHandle, 103, this.mIndex, z ? 1 : 0, 0, getAttribString(IL1Iii.IL1Iii(new byte[]{89, 82}, IL1Iii.IL1Iii(new byte[]{0, 14, 5, 80, 0, 84}, IL1Iii.IL1Iii(new byte[]{7, 11, 2, 83, 4, 7}, "734bea")))));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UIMgr.getInstance().sendEvent(this.mHandle, 101, this.mIndex, 0, 0, getAttribString(IL1Iii.IL1Iii(new byte[]{12, 81}, IL1Iii.IL1Iii(new byte[]{3, 2, 14, 85, 86, 7}, IL1Iii.IL1Iii(new byte[]{95, 5, 1, 13, 81, 86}, "9289cb")))));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.isUserClicked) {
            UIMgr.getInstance().sendEvent(this.mHandle, 104, this.mIndex, i, 0, getAttribString(IL1Iii.IL1Iii(new byte[]{89, 0}, IL1Iii.IL1Iii(new byte[]{7, 86, 12, 2, 3, 4}, IL1Iii.IL1Iii(new byte[]{5, 7, 8, 84, 6, 5}, "250b32")))));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void sendWebViewJsEvent(String str) {
        String attribString = getAttribString(IL1Iii.IL1Iii(new byte[]{10, 81}, IL1Iii.IL1Iii(new byte[]{90, 87, 0, 7, 6, 1}, IL1Iii.IL1Iii(new byte[]{93, 7, 0, 87, 12, 5}, "ded686"))));
        if (TextUtils.isEmpty(attribString)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IL1Iii.IL1Iii(new byte[]{80, 6}, IL1Iii.IL1Iii(new byte[]{1, 1, 81, 92, 2, 80}, IL1Iii.IL1Iii(new byte[]{10, 91, 0, 82, 4, 7}, "28f62a"))), attribString);
            jSONObject.put(IL1Iii.IL1Iii(new byte[]{89, 75, 5, 20, 84}, IL1Iii.IL1Iii(new byte[]{1, 0, 80, 2, 11, 94}, IL1Iii.IL1Iii(new byte[]{84, 15, 85, 2, 11, 1}, "f7af39"))), str);
            UIMgr.getInstance().sendEvent(this.mHandle, 107, this.mIndex, 0, 0, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public void setAttribString(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.attrib.put(str, BuildConfig.FLAVOR);
        } else {
            this.attrib.put(str, str2);
        }
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setParent(ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) {
        this.mParent = viewOnClickListenerC0318UI;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x022f A[Catch: Exception -> 0x0255, TryCatch #2 {Exception -> 0x0255, blocks: (B:69:0x0225, B:70:0x0229, B:72:0x022f, B:74:0x0233, B:76:0x023b, B:77:0x0240, B:79:0x0244, B:81:0x0248, B:83:0x0250), top: B:104:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0240 A[Catch: Exception -> 0x0255, TryCatch #2 {Exception -> 0x0255, blocks: (B:69:0x0225, B:70:0x0229, B:72:0x022f, B:74:0x0233, B:76:0x023b, B:77:0x0240, B:79:0x0244, B:81:0x0248, B:83:0x0250), top: B:104:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0244 A[Catch: Exception -> 0x0255, TryCatch #2 {Exception -> 0x0255, blocks: (B:69:0x0225, B:70:0x0229, B:72:0x022f, B:74:0x0233, B:76:0x023b, B:77:0x0240, B:79:0x0244, B:81:0x0248, B:83:0x0250), top: B:104:0x0225 }] */
    public void setUIValue(String str, int i, String str2, String str3) {
        View view;
        Spinner spinner;
        RadioGroup radioGroup;
        boolean z = false;
        if (this.mIndex == i) {
            String attribString = getAttribString(IL1Iii.IL1Iii(new byte[]{90, 81}, IL1Iii.IL1Iii(new byte[]{11, 13, 83, 6, 6, 1}, IL1Iii.IL1Iii(new byte[]{91, 1, 83, 7, 6, 81}, "c9f774"))));
            if (str != null && attribString != null && str2 != null && str2.compareTo(attribString) == 0) {
                if (str.equals(IL1Iii.IL1Iii(new byte[]{66, 84, 71, 22, 13, 90, 80, 82, 88, 4, 22, 87, 68, 95, 87}, IL1Iii.IL1Iii(new byte[]{82, 3, 81, 91, 84, 13}, IL1Iii.IL1Iii(new byte[]{80, 2, 3, 15, 81, 86}, "30a7ac"))))) {
                    if (this.mView != null) {
                        l1IIi1.I1I().m1020lIiI(this.mView, str3);
                        return;
                    }
                } else if (str.equals(IL1Iii.IL1Iii(new byte[]{23, 83, 16, 65, 11, 76, 1, 78, 16, 87, 13, 84, 11, 68}, IL1Iii.IL1Iii(new byte[]{5, 1, 87, 5, 80, 94}, IL1Iii.IL1Iii(new byte[]{3, 0, 7, 1, 1, 4}, "b7403b"))))) {
                    Log.i(IL1Iii.IL1Iii(new byte[]{118, 58}, IL1Iii.IL1Iii(new byte[]{90, 85, 84, 4, 14, 82}, IL1Iii.IL1Iii(new byte[]{1, 84, 80, 87, 90, 12}, "ccbbc8"))), IL1Iii.IL1Iii(new byte[]{71, 6, 67, 20, 91, 17, 81, 27, 67, 2, 93, 9, 91, 17, 13}, IL1Iii.IL1Iii(new byte[]{3, 82, 81, 5, 81, 82}, IL1Iii.IL1Iii(new byte[]{85, 3, 4, 84, 80, 5}, "b2b032"))) + this.mView + IL1Iii.IL1Iii(new byte[]{13}, IL1Iii.IL1Iii(new byte[]{80, 2, 84, 8, 10, 87}, IL1Iii.IL1Iii(new byte[]{3, 87, 6, 10, 91, 92}, "ec33c8"))) + str3);
                    View view2 = this.mView;
                    if (view2 != null && (view2 instanceof TextView)) {
                        TextView textView = (TextView) view2;
                        if (str3 != null) {
                            l1IIi1.I1I().m1014ILl(textView, str3);
                            return;
                        }
                        return;
                    }
                } else {
                    try {
                        if (str.equals(IL1Iii.IL1Iii(new byte[]{17, 6, 76, 67, 95, 70, 11, 16, 81, 84, 90, 85}, IL1Iii.IL1Iii(new byte[]{4, 85, 9, 1, 3, 0}, IL1Iii.IL1Iii(new byte[]{5, 4, 7, 1, 80, 3}, "c266e3"))))) {
                            int i2 = Integer.parseInt(str3);
                            View view3 = this.mView;
                            if (view3 != null && (i2 == 0 || i2 == 4 || i2 == 8)) {
                                view3.setVisibility(i2);
                            }
                        } else if (str.equals(IL1Iii.IL1Iii(new byte[]{16, 83, 22, 77, 13, 1, 13, 87, 0, 84, 1}, IL1Iii.IL1Iii(new byte[]{2, 0, 87, 9, 85, 84}, IL1Iii.IL1Iii(new byte[]{85, 14, 86, 85, 9, 81}, "48cd8a"))))) {
                            boolean z2 = Boolean.parseBoolean(str3);
                            View view4 = this.mView;
                            if (view4 != null) {
                                view4.setEnabled(z2);
                            }
                        } else if (str.equals(IL1Iii.IL1Iii(new byte[]{18, 80, 71, 22, 89, 71, 4, 77, 71}, IL1Iii.IL1Iii(new byte[]{80, 6, 4, 84, 84, 86}, IL1Iii.IL1Iii(new byte[]{6, 87, 14, 5, 7, 93}, "7d92c8"))))) {
                            View view5 = this.mView;
                            if (view5 != null && (view5 instanceof TextView)) {
                                TextView textView2 = (TextView) view5;
                                if (str3 != null) {
                                    textView2.setText(str3);
                                    return;
                                }
                                return;
                            }
                        } else if (str.equals(IL1Iii.IL1Iii(new byte[]{71, 92, 22, 76, 8, 80, 92, 92, 1, 82}, IL1Iii.IL1Iii(new byte[]{85, 15, 84, 11, 82, 11}, IL1Iii.IL1Iii(new byte[]{86, 83, 4, 81, 5, 8}, "7e2c60"))))) {
                            View view6 = this.mView;
                            if (view6 != null && (view6 instanceof CheckBox)) {
                                CheckBox checkBox = (CheckBox) view6;
                                if (str3 != null) {
                                    try {
                                        z = Boolean.parseBoolean(str3);
                                    } catch (Exception unused) {
                                    }
                                    checkBox.setChecked(z);
                                    return;
                                }
                                return;
                            }
                        } else if (str.equals(IL1Iii.IL1Iii(new byte[]{18, 86, 64, 17, 92, 17, 4, 95, 81, 7, 65}, IL1Iii.IL1Iii(new byte[]{5, 4, 13, 84, 87, 1}, IL1Iii.IL1Iii(new byte[]{1, 5, 9, 6, 91, 87}, "e20694"))))) {
                            if (this.mView != null) {
                                int i3 = -1;
                                if (str3 != null) {
                                    try {
                                        i3 = Integer.parseInt(str3);
                                        view = this.mView;
                                        if (view instanceof RadioGroup) {
                                            radioGroup = (RadioGroup) view;
                                            if (i3 >= 0 && i3 < this.mChilds.size()) {
                                                radioGroup.check(i3);
                                            }
                                        } else if (view instanceof Spinner) {
                                            spinner = (Spinner) view;
                                            if (i3 >= 0 && i3 < this.mChilds.size()) {
                                                spinner.setSelection(i3);
                                            }
                                        }
                                    } catch (Exception e) {
                                        Log.i(IL1Iii.IL1Iii(new byte[]{40, 57}, IL1Iii.IL1Iii(new byte[]{2, 86, 0, 81, 0, 5}, IL1Iii.IL1Iii(new byte[]{93, 15, 0, 83, 4, 80}, "984f5e"))), IL1Iii.IL1Iii(new byte[]{23, 4, 77, 109, 124, 97, 1, 13, 92, 91, 65, 15, 89, 92, 4, 5, 80, 64, 22, 91}, IL1Iii.IL1Iii(new byte[]{87, 0, 15, 11, 2, 83}, IL1Iii.IL1Iii(new byte[]{5, 83, 87, 86, 82, 85}, "62aee4"))) + e.toString());
                                    }
                                } else {
                                    view = this.mView;
                                    if (view instanceof RadioGroup) {
                                        radioGroup = (RadioGroup) view;
                                        if (i3 >= 0) {
                                            radioGroup.check(i3);
                                        }
                                    } else if (view instanceof Spinner) {
                                        spinner = (Spinner) view;
                                        if (i3 >= 0) {
                                            spinner.setSelection(i3);
                                        }
                                    }
                                }
                            }
                        } else if (str.equals(IL1Iii.IL1Iii(new byte[]{21, 87, 22, 19, 11, 19, 3, 80, 20, 15, 7, 19, 19, 64, 14}, IL1Iii.IL1Iii(new byte[]{87, 87, 7, 83, 4, 87}, IL1Iii.IL1Iii(new byte[]{82, 86, 87, 1, 2, 80}, "c324dc"))))) {
                            if (this.mView instanceof X5WebView) {
                                Log.i(IL1Iii.IL1Iii(new byte[]{122, 62}, IL1Iii.IL1Iii(new byte[]{6, 87, 85, 83, 80, 86}, IL1Iii.IL1Iii(new byte[]{6, 5, 80, 5, 0, 85}, "446dfb"))), IL1Iii.IL1Iii(new byte[]{85, 95, 81, 0, 71, 66, 85, 13, 13, 89, 15, 13, 7}, IL1Iii.IL1Iii(new byte[]{15, 2, 2, 2, 3, 82}, IL1Iii.IL1Iii(new byte[]{0, 4, 1, 4, 8, 81}, "663b93"))) + str3);
                                ((X5WebView) this.mView).loadUrl(str3);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (this.mChilds != null) {
            for (int i4 = 0; i4 < this.mChilds.size(); i4++) {
                this.mChilds.get(i4).setUIValue(str, i, str2, str3);
            }
        }
    }

    public void setValOnFlate() {
    }

    public void setValue(int i, String str, String str2) {
        if (i < 0 || TextUtils.isEmpty(str) || str2 == null || this.mValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = IL1Iii.IL1Iii(new byte[]{70, 0, 94, 84}, IL1Iii.IL1Iii(new byte[]{0, 87, 12, 87, 87, 2}, IL1Iii.IL1Iii(new byte[]{87, 85, 2, 85, 87, 5}, "ac73c4"))) + i;
        Map<String, String> map = this.mValues.get(str3);
        if (map == null) {
            HashMap map2 = new HashMap();
            map2.put(str, str2);
            this.mValues.put(str3, map2);
        } else if (map != null) {
            map.put(str, str2);
        }
    }

    public void setWindow(ViewOnClickListenerC0318UI viewOnClickListenerC0318UI) {
        this.mWindow = viewOnClickListenerC0318UI;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        UIMgr.getInstance().sendEvent(this.mHandle, 104, this.mIndex, i, 0, getAttribString(IL1Iii.IL1Iii(new byte[]{88, 85}, IL1Iii.IL1Iii(new byte[]{1, 9, 7, 91, 5, 90}, IL1Iii.IL1Iii(new byte[]{2, 11, 4, 4, 80, 87}, "230fd5")))));
    }
}
