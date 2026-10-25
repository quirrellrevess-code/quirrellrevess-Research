package com.p000nx.assist.lua;

import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import I1I.p062Ilil.p063IL1Iii.I1I.IL;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ApkLoader {
    private String mApkPath;
    private AssetManager mAssetManager;
    private ClassLoader mClassLoader;
    private IL mPluginContext;
    private Resources mResource;
    private Class PluginRegistry = null;
    private Method loadDefault = null;
    private Method load = null;

    public ApkLoader(String str, ClassLoader classLoader) {
        this.mClassLoader = null;
        this.mAssetManager = null;
        this.mResource = null;
        this.mPluginContext = null;
        this.mApkPath = str;
        this.mClassLoader = classLoader;
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod(IL1Iii.IL1Iii(new byte[]{88, 86, 85, 113, 23, 71, 92, 70, 97, 81, 16, 92}, IL1Iii.IL1Iii(new byte[]{93, 5, 5, 85, 84, 0}, IL1Iii.IL1Iii(new byte[]{83, 1, 81, 84, 4, 87}, "76e14c"))), String.class).invoke(assetManager, str);
            this.mAssetManager = assetManager;
            Resources resources = lIlii.m17i1().getResources();
            this.mResource = new Resources(this.mAssetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            this.mPluginContext = new IL(lIlii.m17i1(), this);
        } catch (Exception unused) {
        }
        loadAutoJSPluginSdk(str);
    }

    private void loadAutoJSPluginSdk(String str) {
        try {
            this.PluginRegistry = Class.forName(IL1Iii.IL1Iii(new byte[]{13, 74, 85, 72, 82, 71, 22, 87, 88, 21, 29, 66, 14, 77, 85, 15, 93, 28, 17, 92, 89, 72, 99, 94, 23, 95, 91, 8, 97, 87, 5, 81, 65, 18, 65, 75}, IL1Iii.IL1Iii(new byte[]{85, 90, 1, 3, 87, 0}, IL1Iii.IL1Iii(new byte[]{84, 7, 0, 0, 84, 87}, "ce3e0e"))), true, this.mClassLoader);
            String string = lIlii.m17i1().getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.metaData.getString(IL1Iii.IL1Iii(new byte[]{88, 75, 86, 72, 87, 17, 67, 86, 91, 21, 24, 20, 91, 76, 86, 15, 88, 74, 68, 93, 90, 72, 68, 1, 80, 80, 66, 18, 68, 29}, IL1Iii.IL1Iii(new byte[]{84, 13, 8, 83, 80, 80}, IL1Iii.IL1Iii(new byte[]{82, 0, 11, 87, 4, 13}, "142bb9"))));
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Class<?> cls = Class.forName(string, true, this.mClassLoader);
            try {
                cls.getDeclaredMethod(IL1Iii.IL1Iii(new byte[]{89, 11, 116, 17, 77, 89, 85, 13, 80, 1}, IL1Iii.IL1Iii(new byte[]{87, 7, 2, 81, 92, 94}, IL1Iii.IL1Iii(new byte[]{82, 0, 6, 2, 81, 85}, "3b1643"))), new Class[0]).invoke(cls.newInstance(), new Object[0]);
            } catch (Exception unused) {
            }
            this.loadDefault = this.PluginRegistry.getDeclaredMethod(IL1Iii.IL1Iii(new byte[]{89, 94, 0, 85, 32, 86, 83, 80, 20, 93, 16}, IL1Iii.IL1Iii(new byte[]{86, 6, 83, 84, 80, 82}, IL1Iii.IL1Iii(new byte[]{85, 1, 4, 1, 85, 4}, "666dae"))), Context.class, Context.class, Object.class, Object.class);
            this.load = this.PluginRegistry.getDeclaredMethod(IL1Iii.IL1Iii(new byte[]{13, 12, 88, 87}, IL1Iii.IL1Iii(new byte[]{3, 82, 12, 6, 8, 13}, IL1Iii.IL1Iii(new byte[]{91, 84, 80, 12, 14, 90}, "9ee96b"))), String.class, Context.class, Context.class, Object.class, Object.class);
        } catch (Exception unused2) {
        }
    }

    public String getApkPath() {
        return this.mApkPath;
    }

    public AssetManager getAssets() {
        return this.mAssetManager;
    }

    public ClassLoader getPluginLoader() {
        return this.mClassLoader;
    }

    public Resources getResources() {
        return this.mResource;
    }

    public Class<?> loadClass(String str) {
        try {
            return Class.forName(str, true, this.mClassLoader);
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{120, 109}, IL1Iii.IL1Iii(new byte[]{82, 1, 80, 82, 84, 82}, IL1Iii.IL1Iii(new byte[]{93, 6, 8, 7, 6, 8}, "929768"))), e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public Object loadPlugin(String str) {
        try {
            if (this.loadDefault != null && this.load != null) {
                return TextUtils.isEmpty(str) ? this.loadDefault.invoke(null, lIlii.m17i1(), this.mPluginContext, Runtime.getRuntime(), null) : this.load.invoke(null, str, lIlii.m17i1(), this.mPluginContext, Runtime.getRuntime(), null);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
