package com.main.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.flexbox.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UIState {
    private static final String PREFS_FILE_NAME = I1I.IL1Iii.IL1Iii(new byte[]{55, 122, 100, 69, 4, 21, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 85, 86, 87, 1, 7}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 5, 0, 87, 5}, "6edf3c")));
    private static volatile UIState instance;
    private Context mContext;
    private int baseID = 0;
    private Map<Integer, I1I> mMapHudIds = new HashMap();

    public static class I1I {

        @SerializedName("align")
        public int align;

        /* JADX INFO: renamed from: bg */
        @SerializedName("bg")
        public String f75bg;

        @SerializedName("color")
        public String color;

        @SerializedName("height")
        public int height;

        @SerializedName("paddingbottom")
        public int paddingbottom;

        @SerializedName("paddingright")
        public int paddingright;

        @SerializedName("paddingtop")
        public int paddingtop;

        @SerializedName("paddleft")
        public int paddleft;

        @SerializedName("pos")
        public int pos;

        @SerializedName("size")
        public int size;

        @SerializedName("state")
        public int state;

        @SerializedName("text")
        public String text;

        @SerializedName("width")
        public int width;

        /* JADX INFO: renamed from: x */
        @SerializedName("x")
        public int f76x;

        /* JADX INFO: renamed from: y */
        @SerializedName("y")
        public int f77y;
    }

    public class IL1Iii extends TypeToken<Map<Integer, I1I>> {
        public IL1Iii(UIState uIState) {
        }
    }

    public static class ILil {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f5348I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f5349IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f5350ILil;
    }

    private UIState() {
    }

    public static UIState getInstance() {
        if (instance == null) {
            synchronized (UIState.class) {
                if (instance == null) {
                    instance = new UIState();
                }
            }
        }
        return instance;
    }

    private void saveHudState() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREFS_FILE_NAME, 0);
        sharedPreferences.edit().putString(I1I.IL1Iii.IL1Iii(new byte[]{88, 19, 87, 65, 66, 80, 68, 3}, I1I.IL1Iii.IL1Iii(new byte[]{8, 85, 85, 80, 1, 83}, I1I.IL1Iii.IL1Iii(new byte[]{9, 87, 7, 86, 15, 81}, "1da483"))), new Gson().toJson(this.mMapHudIds)).apply();
    }

    public synchronized void clearHud() {
        if (!this.mMapHudIds.isEmpty()) {
            this.mMapHudIds.clear();
            saveHudState();
        }
    }

    public synchronized void createHud(int i) {
        I1I i1i = new I1I();
        i1i.state = 0;
        this.mMapHudIds.put(Integer.valueOf(i), i1i);
        saveHudState();
    }

    public synchronized int getBaseId() {
        try {
            this.baseID++;
        } catch (Exception unused) {
        }
        if (this.baseID == 0) {
            this.baseID = 1;
        }
        this.mContext.getSharedPreferences(PREFS_FILE_NAME, 0).edit().putInt(I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 66, 92, 93, 1}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 82, 14, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 90, 1, 9, 82}, "3c9687"))), this.baseID).apply();
        return this.baseID;
    }

    public synchronized ILil getFloatControlState() {
        ILil iLil;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREFS_FILE_NAME, 0);
        iLil = new ILil();
        iLil.f5349IL1Iii = sharedPreferences.getBoolean(I1I.IL1Iii.IL1Iii(new byte[]{71, 81, 92, 64, 80, 84, 91, 88, 71}, I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 85, 6, 7, 93}, I1I.IL1Iii.IL1Iii(new byte[]{4, 87, 7, 82, 84, 83}, "a6ace6"))), true);
        iLil.f5350ILil = sharedPreferences.getInt(I1I.IL1Iii.IL1Iii(new byte[]{4, 10, 10, 0, 69, 19, 13, 21, 58, 25}, I1I.IL1Iii.IL1Iii(new byte[]{83, 7, 6, 5, 9, 83}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 82, 6, 14, 1}, "751b61"))), 0);
        iLil.f5348I1I = sharedPreferences.getInt(I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 9, 5, 66, 64, 12, 17, 57, 29}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 86, 92, 83, 84}, I1I.IL1Iii.IL1Iii(new byte[]{2, 2, 5, 9, 93, 87}, "a25183"))), 0);
        return iLil;
    }

    public synchronized void hideHud(int i) {
        if (this.mMapHudIds.containsKey(Integer.valueOf(i))) {
            this.mMapHudIds.remove(Integer.valueOf(i));
            saveHudState();
        }
    }

    public synchronized void initialize(Context context) {
        this.mContext = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, 0);
        this.baseID = sharedPreferences.getInt(I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 71, 83, 95, 80}, I1I.IL1Iii.IL1Iii(new byte[]{6, 81, 87, 3, 0, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 85, 1, 6, 4, 3}, "e4b320"))), 0);
        String string = sharedPreferences.getString(I1I.IL1Iii.IL1Iii(new byte[]{13, 70, 86, 18, 65, 2, 17, 86}, I1I.IL1Iii.IL1Iii(new byte[]{84, 10, 86, 88, 0, 0}, I1I.IL1Iii.IL1Iii(new byte[]{7, 15, 7, 12, 6, 86}, "66c535"))), BuildConfig.FLAVOR);
        if (!string.isEmpty()) {
            try {
                this.mMapHudIds = (Map) new Gson().fromJson(string, new IL1Iii(this).getType());
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void onUiShow() {
        I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().ILL(this.mMapHudIds);
    }

    public synchronized void setFloatWndPos(int i, int i2) {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREFS_FILE_NAME, 0);
        sharedPreferences.edit().putInt(I1I.IL1Iii.IL1Iii(new byte[]{7, 85, 13, 80, 69, 68, 14, 74, 61, 73}, I1I.IL1Iii.IL1Iii(new byte[]{80, 88, 81, 7, 7, 85}, I1I.IL1Iii.IL1Iii(new byte[]{4, 2, 4, 15, 84, 0}, "5c79ba"))), i).apply();
        sharedPreferences.edit().putInt(I1I.IL1Iii.IL1Iii(new byte[]{82, 8, 92, 4, 70, 64, 91, 23, 108, 28}, I1I.IL1Iii.IL1Iii(new byte[]{6, 82, 1, 85, 81, 3}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 7, 5, 84, 85}, "eb557f"))), i2).apply();
    }

    public synchronized void showFloatWnd(boolean z) {
        this.mContext.getSharedPreferences(PREFS_FILE_NAME, 0).edit().putBoolean(I1I.IL1Iii.IL1Iii(new byte[]{74, 88, 11, 69, 87, 89, 86, 81, 16}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 1, 6, 87, 83}, I1I.IL1Iii.IL1Iii(new byte[]{13, 2, 3, 81, 82, 0}, "40fe4f"))), z).apply();
    }

    public synchronized void showHUD(int i, String str, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        I1I i1i = this.mMapHudIds.get(Integer.valueOf(i));
        if (i1i != null) {
            i1i.text = str;
            i1i.size = i2;
            i1i.color = str2;
            i1i.f75bg = str3;
            i1i.pos = i3;
            i1i.f76x = i4;
            i1i.f77y = i5;
            i1i.width = i6;
            i1i.height = i7;
            i1i.paddleft = i8;
            i1i.paddingtop = i9;
            i1i.paddingright = i10;
            i1i.paddingbottom = i11;
            i1i.align = i12;
            i1i.state = 1;
            saveHudState();
        }
    }
}
