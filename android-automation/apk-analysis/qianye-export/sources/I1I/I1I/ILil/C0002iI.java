package I1I.I1I.ILil;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: renamed from: I1I.I1I.ILil.iI */
/* JADX INFO: compiled from: TaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C0002iI {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final AtomicLong f3185IL1Iii = new AtomicLong();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, Bundle> f3186ILil = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Object f3184I1I = new Object();

    public static void I1I() {
        Object obj = f3184I1I;
        synchronized (obj) {
            IL1Iii();
            f3186ILil.clear();
            obj.notifyAll();
        }
    }

    public static void IL1Iii() {
        Iterator<Map.Entry<Long, Bundle>> it = f3186ILil.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Bundle> next = it.next();
            next.getKey();
            Bundle value = next.getValue();
            if (value != null && value.getInt(I1I.IL1Iii.IL1Iii(new byte[]{5, 95, 82}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 7, 84, 14, 5}, I1I.IL1Iii.IL1Iii(new byte[]{83, 7, 5, 83, 1, 82}, "6a4661")))) == 45 && value.getInt(I1I.IL1Iii.IL1Iii(new byte[]{17, 83, 16}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 87, 1, 5, 9}, I1I.IL1Iii.IL1Iii(new byte[]{81, 80, 80, 11, 93, 88}, "efc29a")))) == 1) {
                try {
                    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) value.getParcelable(I1I.IL1Iii.IL1Iii(new byte[]{81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 84, 2, 4, 85}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 83, 2, 86, 4}, "2d0640"))));
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                } catch (Exception unused) {
                }
                it.remove();
            }
        }
    }

    public static long ILil() {
        return f3185IL1Iii.incrementAndGet();
    }

    public static Bundle Ilil(int i, int i2, String str, long j) {
        Bundle bundleM957lLi1LL;
        long jILil = ILil();
        if (i == 45) {
            try {
                IL1Iii();
            } catch (Exception unused) {
                return null;
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (str != null && str.length() > 0) {
            jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{82, 65, 2}, I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 81, 92, 95, 81}, I1I.IL1Iii.IL1Iii(new byte[]{6, 82, 80, 1, 91, 0}, "76ddbb"))), str);
        }
        jSONObject.put(I1I.IL1Iii.IL1Iii(new byte[]{21, 85, 64, 88, 120, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 0, 1, 82, 86}, I1I.IL1Iii.IL1Iii(new byte[]{14, 4, 2, 86, 86, 86}, "8f1d57"))), jILil);
        String strIlil = L11I.I11L().Ilil(19, i, i2, jSONObject.toString());
        if (strIlil == null || !strIlil.equals(I1I.IL1Iii.IL1Iii(new byte[]{10, 14}, I1I.IL1Iii.IL1Iii(new byte[]{83, 1, 6, 3, 85, 80}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 82, 5, 5, 82}, "dce3f4")))) || (bundleM957lLi1LL = m957lLi1LL(jILil, j)) == null) {
            return null;
        }
        return bundleM957lLi1LL;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m956IL(int i, long j, Bundle bundle) {
        f3186ILil.put(Long.valueOf(j), bundle);
        Object obj = f3184I1I;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Bundle m957lLi1LL(long j, long j2) {
        Bundle bundleRemove;
        ConcurrentHashMap<Long, Bundle> concurrentHashMap;
        synchronized (f3184I1I) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jCurrentTimeMillis2 = 0;
                while (true) {
                    concurrentHashMap = f3186ILil;
                    if (concurrentHashMap.containsKey(Long.valueOf(j)) || jCurrentTimeMillis2 >= j2) {
                        break;
                    }
                    f3184I1I.wait(j2 - jCurrentTimeMillis2);
                    jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                }
                bundleRemove = concurrentHashMap.remove(Long.valueOf(j));
            } catch (InterruptedException e) {
                e.printStackTrace();
                bundleRemove = null;
            }
        }
        return bundleRemove;
    }
}
