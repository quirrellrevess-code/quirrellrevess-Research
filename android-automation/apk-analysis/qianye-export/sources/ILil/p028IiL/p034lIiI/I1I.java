package ILil.p028IiL.p034lIiI;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: ObjectsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {
    public static boolean IL1Iii(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int ILil(Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(objArr) : Arrays.hashCode(objArr);
    }
}
