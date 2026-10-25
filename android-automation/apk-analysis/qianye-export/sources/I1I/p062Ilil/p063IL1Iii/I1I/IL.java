package I1I.p062Ilil.p063IL1Iii.I1I;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.p000nx.assist.lua.ApkLoader;

/* JADX INFO: renamed from: I1I.Ilil.IL1Iii.I1I.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: PluginContext.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends ContextWrapper {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ApkLoader f3440IL1Iii;

    public IL(Context context, ApkLoader apkLoader) {
        super(context);
        this.f3440IL1Iii = null;
        this.f3440IL1Iii = apkLoader;
    }

    public final Context IL1Iii(Context context) {
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f3440IL1Iii.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return IL1Iii(super.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.f3440IL1Iii.getPluginLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f3440IL1Iii.getResources();
    }
}
