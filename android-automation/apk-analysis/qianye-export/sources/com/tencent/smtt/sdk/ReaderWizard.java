package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.google.android.flexbox.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes.dex */
public class ReaderWizard {

    /* JADX INFO: renamed from: a */
    private DexLoader f231a;

    /* JADX INFO: renamed from: b */
    private TbsReaderView.ReaderCallback f232b;

    public ReaderWizard(TbsReaderView.ReaderCallback readerCallback) {
        this.f231a = null;
        this.f232b = null;
        this.f231a = m169a();
        this.f232b = readerCallback;
    }

    /* JADX INFO: renamed from: a */
    private static DexLoader m169a() {
        C0425s c0425sM333c = C0412f.m323a(true).m333c();
        if (c0425sM333c != null) {
            return c0425sM333c.m498c();
        }
        return null;
    }

    public static Drawable getResDrawable(int i) {
        DexLoader dexLoaderM169a = m169a();
        if (dexLoaderM169a != null) {
            Object objInvokeStaticMethod = dexLoaderM169a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (objInvokeStaticMethod instanceof Drawable) {
                return (Drawable) objInvokeStaticMethod;
            }
        }
        return null;
    }

    public static String getResString(int i) {
        DexLoader dexLoaderM169a = m169a();
        if (dexLoaderM169a != null) {
            Object objInvokeStaticMethod = dexLoaderM169a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
            if (objInvokeStaticMethod instanceof String) {
                return (String) objInvokeStaticMethod;
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static boolean isSupportCurrentPlatform(Context context) {
        DexLoader dexLoaderM169a = m169a();
        if (dexLoaderM169a == null) {
            return false;
        }
        Object objInvokeStaticMethod = dexLoaderM169a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
        if (objInvokeStaticMethod instanceof Boolean) {
            return ((Boolean) objInvokeStaticMethod).booleanValue();
        }
        return false;
    }

    public static boolean isSupportExt(String str) {
        DexLoader dexLoaderM169a = m169a();
        if (dexLoaderM169a == null) {
            return false;
        }
        Object objInvokeStaticMethod = dexLoaderM169a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
        if (objInvokeStaticMethod instanceof Boolean) {
            return ((Boolean) objInvokeStaticMethod).booleanValue();
        }
        return false;
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        String str2;
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null) {
            str2 = "checkPlugin:Unexpect null object!";
        } else {
            Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
            if (objInvokeMethod instanceof Boolean) {
                return ((Boolean) objInvokeMethod).booleanValue();
            }
            str2 = "Unexpect return value type of call checkPlugin!";
        }
        Log.e("ReaderWizard", str2);
        return false;
    }

    public void destroy(Object obj) {
        this.f232b = null;
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null || obj == null) {
            Log.e("ReaderWizard", "destroy:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        }
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "doCommand:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, new Integer(num.intValue()), obj2, obj3);
        }
    }

    public Object getTbsReader() {
        return this.f231a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public boolean initTbsReader(Object obj, Context context) {
        String str;
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null || obj == null) {
            str = "initTbsReader:Unexpect null object!";
        } else {
            Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, context, dexLoader, this);
            if (objInvokeMethod instanceof Boolean) {
                return ((Boolean) objInvokeMethod).booleanValue();
            }
            str = "Unexpect return value type of call initTbsReader!";
        }
        Log.e("ReaderWizard", str);
        return false;
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        TbsReaderView.ReaderCallback readerCallback = this.f232b;
        if (readerCallback != null) {
            readerCallback.onCallBackAction(num, obj, obj2);
        }
    }

    public void onSizeChanged(Object obj, int i, int i2) {
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, new Integer(i), new Integer(i2));
        }
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        String str;
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null) {
            str = "openFile:Unexpect null object!";
        } else {
            Object objInvokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
            if (objInvokeMethod instanceof Boolean) {
                return ((Boolean) objInvokeMethod).booleanValue();
            }
            str = "Unexpect return value type of call openFile!";
        }
        Log.e("ReaderWizard", str);
        return false;
    }

    public void userStatistics(Object obj, String str) {
        DexLoader dexLoader = this.f231a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        }
    }
}
