package I1I.p062Ilil.p064Ilil.IL1Iii;

import I1I.IL1Iii;
import android.accessibilityservice.AccessibilityService;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.flexbox.BuildConfig;
import java.util.Set;

/* JADX INFO: compiled from: AccessibilityInfoProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I implements ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public PackageManager f3513I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public volatile String f3514ILil = BuildConfig.FLAVOR;

    public I1I(PackageManager packageManager) {
        this.f3513I1I = packageManager;
    }

    @Override // I1I.p062Ilil.p064Ilil.IL1Iii.ILil
    public Set<Integer> I1I() {
        return ILil.f3517IL1Iii;
    }

    @Override // I1I.p062Ilil.p064Ilil.IL1Iii.ILil
    public boolean IL1Iii(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return false;
        }
        m1311IL(accessibilityEvent.getPackageName(), accessibilityEvent.getClassName());
        return false;
    }

    public String ILil() {
        return this.f3514ILil;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1311IL(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return;
        }
        String string = charSequence.toString();
        String string2 = charSequence2.toString();
        if (string2.startsWith(IL1Iii.IL1Iii(new byte[]{2, 86, 92, 16, 91, 95, 7, 22, 78, 11, 81, 65, 77}, IL1Iii.IL1Iii(new byte[]{2, 13, 1, 90, 2, 80}, IL1Iii.IL1Iii(new byte[]{87, 7, 14, 10, 82, 94}, "6272d8")))) || string2.startsWith(IL1Iii.IL1Iii(new byte[]{87, 86, 0, 23, 12, 13, 82, 22, 19, 12, 7, 3, 83, 76, 74}, IL1Iii.IL1Iii(new byte[]{4, 15, 2, 85, 85, 1}, IL1Iii.IL1Iii(new byte[]{86, 7, 87, 85, 7, 6}, "d01e1c"))))) {
            return;
        }
        try {
            String str = this.f3513I1I.getActivityInfo(new ComponentName(string, string2), 0).name;
            this.f3514ILil = charSequence.toString();
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
