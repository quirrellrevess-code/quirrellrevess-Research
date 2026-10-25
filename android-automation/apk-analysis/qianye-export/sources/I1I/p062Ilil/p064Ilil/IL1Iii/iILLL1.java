package I1I.p062Ilil.p064Ilil.IL1Iii;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.p000nx.uiauto.notification.Notification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.IL1Iii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: AccessibilityNotificationObserver.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 implements L11I, I1I.p062Ilil.p064Ilil.IL1Iii.ILil {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f3520ILil;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final String f1149lLi1LL = I1I.IL1Iii.IL1Iii(new byte[]{121, 10, 77, 95, 94, 11, 84, 4, 77, 95, 87, 12, 120, 7, 74, 83, 74, 20, 82, 23}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 11, 82, 94, 91}, I1I.IL1Iii.IL1Iii(new byte[]{5, 6, 5, 2, 86, 93}, "637f0d")));

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Set<Integer> f3518Ilil = Collections.singleton(64);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public CopyOnWriteArrayList<L11I> f3519I1I = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public CopyOnWriteArrayList<ILil> f1150IL = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.IL1Iii.iI丨LLL1$IL1Iii */
    /* JADX INFO: compiled from: AccessibilityNotificationObserver.java */
    public class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final List<String> f3521IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final String f3522ILil;

        public IL1Iii(iILLL1 iilll1, String str, List<CharSequence> list) {
            this.f3521IL1Iii = new ArrayList(list.size());
            for (CharSequence charSequence : list) {
                if (charSequence != null) {
                    this.f3521IL1Iii.add(charSequence.toString());
                }
            }
            this.f3522ILil = str;
        }

        public String toString() {
            return I1I.IL1Iii.IL1Iii(new byte[]{108, 10, 89, 70, 70, 77, 76, 0, 64, 65, 65, 11}, I1I.IL1Iii.IL1Iii(new byte[]{9, 80, 94, 81, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 83, 1, 0, 85}, "725e26"))) + this.f3521IL1Iii + I1I.IL1Iii.IL1Iii(new byte[]{77, 66, 67, 81, 2, 90, 0, 5, 86, 126, 0, 92, 4, 95, 20}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 5, 86, 80, 9}, I1I.IL1Iii.IL1Iii(new byte[]{11, 2, 1, 85, 9, 90}, "8a738b"))) + this.f3522ILil + "'}";
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.IL1Iii.iI丨LLL1$ILil */
    /* JADX INFO: compiled from: AccessibilityNotificationObserver.java */
    public interface ILil {
        void IL1Iii(IL1Iii iL1Iii);
    }

    public iILLL1(Context context) {
        this.f3520ILil = context;
    }

    @Override // I1I.p062Ilil.p064Ilil.IL1Iii.ILil
    public Set<Integer> I1I() {
        return f3518Ilil;
    }

    @Override // I1I.p062Ilil.p064Ilil.IL1Iii.ILil
    public boolean IL1Iii(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getParcelableData() instanceof Notification) {
            android.app.Notification notification = (android.app.Notification) accessibilityEvent.getParcelableData();
            Log.d(f1149lLi1LL, I1I.IL1Iii.IL1Iii(new byte[]{14, 10, 118, 87, 18, 92, 7, 13, 91, 89, 18, 92, 14, 10, 2, 24}, I1I.IL1Iii.IL1Iii(new byte[]{84, 93, 10, 90, 84, 12}, I1I.IL1Iii.IL1Iii(new byte[]{0, 92, 81, 90, 10, 93}, "5ec88d"))) + notification + I1I.IL1Iii.IL1Iii(new byte[]{8, 23}, I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 2, 4, 81, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 2, 7, 89, 7}, "77208b"))) + accessibilityEvent);
            ILil(Notification.ILil(notification, accessibilityEvent.getPackageName().toString()));
        } else {
            List<CharSequence> text = accessibilityEvent.getText();
            Log.d(f1149lLi1LL, I1I.IL1Iii.IL1Iii(new byte[]{13, 12, 119, 13, 21, 15, 4, 11, 90, 3, 21, 15, 13, 12, 3, 66}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 91, 3, 87, 83}, I1I.IL1Iii.IL1Iii(new byte[]{95, 84, 87, 2, 87, 4}, "965ca1"))) + text + I1I.IL1Iii.IL1Iii(new byte[]{9, 18}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 7, 2, 83, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 81, 2, 11, 0}, "7cb19f"))) + accessibilityEvent);
            if (!accessibilityEvent.getPackageName().equals(this.f3520ILil.getPackageName()) && text != null) {
                m1312IL(accessibilityEvent, new IL1Iii(this, accessibilityEvent.getPackageName().toString(), text));
            }
        }
        return false;
    }

    @Override // I1I.p062Ilil.p064Ilil.IL1Iii.L11I
    public void ILil(Notification notification) {
        for (L11I l11i : this.f3519I1I) {
            try {
                l11i.ILil(notification);
            } catch (Exception e) {
                Log.e(f1149lLi1LL, I1I.IL1Iii.IL1Iii(new byte[]{113, 22, 68, 10, 23, 16, 91, 10, 120, 10, 17, 89, 82, 13, 85, 4, 17, 89, 91, 10, 12, 69}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 15, 93, 3, 1}, I1I.IL1Iii.IL1Iii(new byte[]{5, 93, 13, 89, 4, 84}, "084abe"))) + notification + I1I.IL1Iii.IL1Iii(new byte[]{23, 125, 91, 17, 16, 85, 89, 84, 64, 88, 68}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 11, 83, 83, 3}, I1I.IL1Iii.IL1Iii(new byte[]{82, 83, 91, 4, 5, 82}, "15b52a"))) + l11i, e);
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m1312IL(AccessibilityEvent accessibilityEvent, IL1Iii iL1Iii) {
        for (ILil iLil : this.f1150IL) {
            try {
                iLil.IL1Iii(iL1Iii);
            } catch (Exception e) {
                Log.e(f1149lLi1LL, I1I.IL1Iii.IL1Iii(new byte[]{39, 65, 65, 86, 19, 18, 13, 93, 125, 86, 21, 91, 4, 90, 80, 88, 21, 91, 13, 93, 9, 25}, I1I.IL1Iii.IL1Iii(new byte[]{91, 81, 80, 1, 85, 84}, I1I.IL1Iii.IL1Iii(new byte[]{14, 3, 7, 0, 0, 3}, "7ad84e"))) + iL1Iii + I1I.IL1Iii.IL1Iii(new byte[]{20, 40, 11, 17, 68, 3, 90, 1, 16, 88, 16}, I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 6, 84, 86, 84}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 82, 15, 2, 3}, "6669d1"))) + iLil, e);
            }
        }
    }
}
