package ILil.ILil.p024llL1ii;

import ILil.ILil.C0631il;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: ContextThemeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class IL extends ContextWrapper {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public LayoutInflater f3924I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f3925IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Resources.Theme f3926ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Resources f3927Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Configuration f1525IL;

    public IL() {
        super(null);
    }

    public final void I1I() {
        boolean z = this.f3926ILil == null;
        if (z) {
            this.f3926ILil = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f3926ILil.setTo(theme);
            }
        }
        m1919IL(this.f3926ILil, this.f3925IL1Iii, z);
    }

    public final Resources IL1Iii() {
        if (this.f3927Ilil == null) {
            Configuration configuration = this.f1525IL;
            if (configuration == null) {
                this.f3927Ilil = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f3927Ilil = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f3927Ilil;
    }

    public int ILil() {
        return this.f3925IL1Iii;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1919IL(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return IL1Iii();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f3924I1I == null) {
            this.f3924I1I = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f3924I1I;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f3926ILil;
        if (theme != null) {
            return theme;
        }
        if (this.f3925IL1Iii == 0) {
            this.f3925IL1Iii = C0631il.Theme_AppCompat_Light;
        }
        I1I();
        return this.f3926ILil;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f3925IL1Iii != i) {
            this.f3925IL1Iii = i;
            I1I();
        }
    }

    public IL(Context context, int i) {
        super(context);
        this.f3925IL1Iii = i;
    }

    public IL(Context context, Resources.Theme theme) {
        super(context);
        this.f3926ILil = theme;
    }
}
