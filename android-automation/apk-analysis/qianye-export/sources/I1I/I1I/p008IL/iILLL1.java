package I1I.I1I.p008IL;

import I1I.IL1Iii;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.p005io.FileSystem;
import org.json.JSONObject;
import p066Ilil.IL;
import p066Ilil.lIiI;

/* JADX INFO: renamed from: I1I.I1I.I丨L.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: ImageCache.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static iILLL1 f3364I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String f3365ILil = IL1Iii.IL1Iii(new byte[]{127, 14, 83, 81, 82, 112, 87, 0, 90, 83}, IL1Iii.IL1Iii(new byte[]{2, 6, 5, 14, 15, 1}, IL1Iii.IL1Iii(new byte[]{86, 93, 15, 0, 89, 80}, "b888ab")));

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public DiskLruCache f3366IL1Iii;

    static {
        IL1Iii.IL1Iii(new byte[]{13, 93, 82, 3, 3, 103, 7, 81, 80, 12, 3}, IL1Iii.IL1Iii(new byte[]{82, 7, 80, 92, 5, 13}, IL1Iii.IL1Iii(new byte[]{87, 14, 85, 9, 90, 86}, "a9619c")));
    }

    public iILLL1(Context context) {
        this.f3366IL1Iii = DiskLruCache.create(FileSystem.SYSTEM, m1107IL(context, IL1Iii.IL1Iii(new byte[]{89, 93, 87, 87, 85, 57, 83, 81, 85, 88, 85}, IL1Iii.IL1Iii(new byte[]{81, 3, 15, 3, 4, 80}, IL1Iii.IL1Iii(new byte[]{4, 82, 1, 10, 85, 85}, "ea89ac")))), 1, 2, 10485760L);
    }

    public static iILLL1 Ilil(Context context) {
        if (f3364I1I == null) {
            synchronized (iILLL1.class) {
                if (f3364I1I == null) {
                    f3364I1I = new iILLL1(context);
                }
            }
        }
        return f3364I1I;
    }

    public Bitmap I1I(String str) {
        try {
            DiskLruCache.Snapshot snapshot = this.f3366IL1Iii.get(str);
            if (snapshot != null) {
                return BitmapFactory.decodeStream(lIiI.m2826IL(snapshot.getSource(0)).mo2779LIll());
            }
            return null;
        } catch (IOException e) {
            Log.e(f3365ILil, IL1Iii.IL1Iii(new byte[]{112, 23, 69, 12, 70, 23, 82, 0, 67, 23, 93, 89, 82, 69, 85, 10, 64, 90, 84, 21, 23, 5, 70, 88, 88, 69, 84, 2, 87, 95, 80}, IL1Iii.IL1Iii(new byte[]{0, 4, 86, 2, 4, 1}, IL1Iii.IL1Iii(new byte[]{6, 89, 85, 5, 6, 15}, "384d69"))), e);
            return null;
        }
    }

    public final Map<String, String> IL1Iii(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
        } catch (Exception e) {
            Log.e(f3365ILil, IL1Iii.IL1Iii(new byte[]{112, 20, 64, 93, 69, 24, 86, 9, 92, 68, 82, 74, 65, 15, 92, 85, 23, 114, 102, 41, 124, 18, 67, 87, 21, 43, 83, 66}, IL1Iii.IL1Iii(new byte[]{3, 7, 11, 4, 0, 12}, IL1Iii.IL1Iii(new byte[]{83, 3, 10, 6, 14, 85}, "eb309a"))), e);
        }
        return map;
    }

    public final String ILil(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final File m1107IL(Context context, String str) {
        return new File(context.getCacheDir().getPath() + File.separator + str);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m1108IiL(String str) {
        try {
            if (this.f3366IL1Iii.get(str) != null) {
                this.f3366IL1Iii.remove(str);
            }
        } catch (IOException e) {
            Log.e(f3365ILil, IL1Iii.IL1Iii(new byte[]{118, 67, 70, 91, 16, 66, 84, 84, 64, 64, 11, 12, 84, 17, 86, 93, 22, 15, 82, 65, 20, 82, 16, 13, 94, 17, 87, 85, 1, 10, 86}, IL1Iii.IL1Iii(new byte[]{85, 7, 86, 85, 0, 7}, IL1Iii.IL1Iii(new byte[]{95, 84, 81, 88, 86, 87}, "9b3942"))), e);
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1109iILLL1(String str, Bitmap bitmap, Map<String, String> map) {
        DiskLruCache.Editor editorEdit = null;
        try {
            editorEdit = this.f3366IL1Iii.edit(str);
            if (editorEdit != null) {
                IL ilI1I = lIiI.I1I(editorEdit.newSink(0));
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, ilI1I.mo2783L1l());
                ilI1I.flush();
                IL ilI1I2 = lIiI.I1I(editorEdit.newSink(1));
                ilI1I2.LlLI1(ILil(map));
                ilI1I2.flush();
                editorEdit.commit();
            }
        } catch (IOException e) {
            Log.e(f3365ILil, IL1Iii.IL1Iii(new byte[]{32, 20, 19, 10, 70, 70, 21, 19, 21, 17, 93, 8, 2, 70, 3, 12, 64, 11, 4, 22, 65, 17, 91, 70, 6, 7, 2, 13, 81}, IL1Iii.IL1Iii(new byte[]{92, 80, 5, 83, 7, 80}, IL1Iii.IL1Iii(new byte[]{14, 85, 82, 4, 85, 4}, "7c62f2"))), e);
            if (editorEdit != null) {
                try {
                    editorEdit.abort();
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Map<String, String> m1110lLi1LL(String str) {
        try {
            DiskLruCache.Snapshot snapshot = this.f3366IL1Iii.get(str);
            if (snapshot != null) {
                return IL1Iii(lIiI.m2826IL(snapshot.getSource(1)).mo2785LlLLL());
            }
            return null;
        } catch (IOException e) {
            Log.e(f3365ILil, IL1Iii.IL1Iii(new byte[]{33, 16, 67, 14, 71, 65, 3, 7, 69, 21, 92, 15, 3, 66, 90, 4, 76, 76, 18, 3, 93, 20, 80, 65, 20, 3, 88, 19, 70, 65, 2, 16, 94, 12, 21, 2, 5, 1, 89, 4}, IL1Iii.IL1Iii(new byte[]{86, 6, 6, 83, 80, 5}, IL1Iii.IL1Iii(new byte[]{0, 85, 84, 0, 86, 86}, "21c232"))), e);
            return null;
        }
    }
}
