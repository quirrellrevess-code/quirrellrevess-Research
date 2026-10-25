package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import p051lLi1LL.ILil.IL1Iii.I11li1.ILil;
import p051lLi1LL.ILil.IL1Iii.I1I;

/* JADX INFO: loaded from: classes.dex */
public class ErrorDialogManager {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static ILil<?> f5607IL1Iii;

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public I1I f5608ILil;

        @Override // android.app.Fragment
        public void onPause() {
            this.f5608ILil.m3670llL1ii(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            ErrorDialogManager.f5607IL1Iii.f5539IL1Iii.IL1Iii();
            throw null;
        }
    }
}
