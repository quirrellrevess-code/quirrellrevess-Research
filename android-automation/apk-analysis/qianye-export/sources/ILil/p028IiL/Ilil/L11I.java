package ILil.p028IiL.Ilil;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: ILil.I丨iL.Ilil.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: NotificationCompatJellybean.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static boolean f4108I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final Object f4109IL1Iii = new Object();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Field f4110ILil;

    public static Bundle I1I(Notification notification) {
        synchronized (f4109IL1Iii) {
            if (f4108I1I) {
                return null;
            }
            try {
                if (f4110ILil == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f4108I1I = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f4110ILil = declaredField;
                }
                Bundle bundle = (Bundle) f4110ILil.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f4110ILil.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f4108I1I = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f4108I1I = true;
                return null;
            }
        }
    }

    public static SparseArray<Bundle> IL1Iii(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle ILil(iILLL1.IL1Iii iL1Iii) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", iL1Iii.Ilil());
        bundle.putCharSequence("title", iL1Iii.m2185L11I());
        bundle.putParcelable("actionIntent", iL1Iii.IL1Iii());
        Bundle bundle2 = iL1Iii.m2183IL() != null ? new Bundle(iL1Iii.m2183IL()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", iL1Iii.ILil());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", Ilil(iL1Iii.m2187lLi1LL()));
        bundle.putBoolean("showsUserInterface", iL1Iii.m2184IiL());
        bundle.putInt("semanticAction", iL1Iii.m2186iILLL1());
        return bundle;
    }

    public static Bundle[] Ilil(C0635il[] c0635ilArr) {
        if (c0635ilArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0635ilArr.length];
        for (int i = 0; i < c0635ilArr.length; i++) {
            bundleArr[i] = m2180IL(c0635ilArr[i]);
        }
        return bundleArr;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Bundle m2180IL(C0635il c0635il) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0635il.m2195IiL());
        bundle.putCharSequence("label", c0635il.m2196iILLL1());
        bundle.putCharSequenceArray("choices", c0635il.Ilil());
        bundle.putBoolean("allowFreeFormInput", c0635il.I1I());
        bundle.putBundle("extras", c0635il.m2197lLi1LL());
        Set<String> setM2194IL = c0635il.m2194IL();
        if (setM2194IL != null && !setM2194IL.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setM2194IL.size());
            Iterator<String> it = setM2194IL.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static Bundle m2181lLi1LL(Notification.Builder builder, iILLL1.IL1Iii iL1Iii) {
        builder.addAction(iL1Iii.Ilil(), iL1Iii.m2185L11I(), iL1Iii.IL1Iii());
        Bundle bundle = new Bundle(iL1Iii.m2183IL());
        if (iL1Iii.m2187lLi1LL() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", Ilil(iL1Iii.m2187lLi1LL()));
        }
        if (iL1Iii.I1I() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", Ilil(iL1Iii.I1I()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", iL1Iii.ILil());
        return bundle;
    }
}
