package com.tencent.smtt.sdk;

import I1I.p019lLi1LL.IL1Iii.IL1Iii.IL1Iii.IL1Iii;
import I1I.p019lLi1LL.IL1Iii.IL1Iii.IL1Iii.ILil;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: renamed from: com.tencent.smtt.sdk.p */
/* JADX INFO: loaded from: classes.dex */
public class C0422p {

    /* JADX INFO: renamed from: e */
    private static C0422p f604e;

    /* JADX INFO: renamed from: a */
    public C0424r f605a;

    /* JADX INFO: renamed from: b */
    public Context f606b;

    /* JADX INFO: renamed from: c */
    public ILil f607c;

    /* JADX INFO: renamed from: d */
    public IL1Iii f608d;

    private C0422p(Context context) {
        this.f605a = null;
        this.f606b = context.getApplicationContext();
        this.f605a = new C0424r(this.f606b);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0422p m475a(Context context) {
        if (f604e == null) {
            f604e = new C0422p(context);
        }
        return f604e;
    }

    /* JADX INFO: renamed from: a */
    public void m476a(int i, int i2, Intent intent) {
        ILil iLil = this.f607c;
        if (iLil != null) {
            iLil.ILil(i, i2, intent);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m477a(Activity activity, int i) {
        this.f605a.m485a(activity, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m478a() {
        this.f605a.m483a();
        return this.f605a.m487b();
    }

    /* JADX INFO: renamed from: a */
    public boolean m479a(String str, Bundle bundle, ILil iLil) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (iLil != null) {
            this.f605a.m483a();
            if (!this.f605a.m487b()) {
                return false;
            }
            this.f607c = iLil;
            IL1Iii iL1Iii = new IL1Iii() { // from class: com.tencent.smtt.sdk.p.1
                public void onUserStateChanged() {
                    C0422p.this.f605a.m488c();
                }
            };
            this.f608d = iL1Iii;
            this.f607c.IL1Iii(iL1Iii);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.f605a.m486a(bundle, iLil == null ? null : this);
        return true;
    }
}
