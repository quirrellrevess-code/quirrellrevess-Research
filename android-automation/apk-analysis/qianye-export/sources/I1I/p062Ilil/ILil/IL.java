package I1I.p062Ilil.ILil;

import I1I.IL1Iii;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: I1I.Ilil.ILil.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: UIMsg.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public String f3480I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f3481IL1Iii;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public String f3482ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int f1123ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public String f3483Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1124IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public List<String> f1125IiL;
    public int Lil;
    public int LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f1126Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f1127L11I;
    public int iIi1;
    public int iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public String f1128iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f1129lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f1130lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f1131llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public String f1132lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean f1133il;

    public static String IL1Iii(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        try {
            return new String(Base64.decode(str.getBytes(), 0));
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static IL ILil(String str) {
        IL il = new IL();
        try {
            JSONObject jSONObject = new JSONObject(str);
            il.f3481IL1Iii = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{6, 89, 84}, IL1Iii.IL1Iii(new byte[]{85, 13, 86, 1, 83, 84}, IL1Iii.IL1Iii(new byte[]{84, 0, 0, 6, 2, 84}, "d9fdf6"))));
            il.ILL = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{23, 95, 17, 93, 90, 13, 4}, IL1Iii.IL1Iii(new byte[]{85, 7, 86, 12, 93, 85}, IL1Iii.IL1Iii(new byte[]{85, 84, 7, 91, 4, 5}, "ae3ca1"))));
            il.f1126Ll1 = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{68, 80, 95, 81, 0, 18}, IL1Iii.IL1Iii(new byte[]{1, 0, 3, 1, 85, 94}, IL1Iii.IL1Iii(new byte[]{14, 7, 8, 86, 14, 92}, "828c8d"))));
            jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{81, 87, 10, 94, 17}, IL1Iii.IL1Iii(new byte[]{5, 15, 81, 6, 85, 0}, IL1Iii.IL1Iii(new byte[]{82, 83, 81, 15, 5, 11}, "edf838"))));
            il.f1129lIiI = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{80, 67, 7, 23, 11, 68, 78}, IL1Iii.IL1Iii(new byte[]{85, 7, 95, 86, 91, 3}, IL1Iii.IL1Iii(new byte[]{81, 14, 13, 82, 15, 2}, "384e61"))));
            jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{64, 11, 7, 81, 66, 3, 65, 12, 23, 79}, IL1Iii.IL1Iii(new byte[]{15, 92, 6, 5, 1, 3}, IL1Iii.IL1Iii(new byte[]{13, 10, 6, 4, 6, 7}, "53c77f"))));
            il.f1123ILl = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{77, 4, 29, 17, 22, 81, 67, 4}, IL1Iii.IL1Iii(new byte[]{88, 80, 6, 0, 92, 8}, IL1Iii.IL1Iii(new byte[]{7, 9, 5, 6, 14, 0}, "f8fc70"))));
            il.Lil = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{8}, IL1Iii.IL1Iii(new byte[]{83, 82, 84, 4, 0, 4}, IL1Iii.IL1Iii(new byte[]{83, 82, 86, 82, 4, 81}, "dd4b33"))));
            il.LlLI1 = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{71}, IL1Iii.IL1Iii(new byte[]{6, 8, 88, 80, 85, 10}, IL1Iii.IL1Iii(new byte[]{7, 81, 5, 6, 83, 12}, "2ade05"))));
            il.f1131llL1ii = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{17}, IL1Iii.IL1Iii(new byte[]{82, 87, 81, 3, 92, 3}, IL1Iii.IL1Iii(new byte[]{6, 13, 84, 9, 15, 10}, "79d979"))));
            il.f1130lIlii = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{81}, IL1Iii.IL1Iii(new byte[]{6, 6, 0, 6, 5, 92}, IL1Iii.IL1Iii(new byte[]{2, 5, 0, 85, 3, 7}, "706b1b"))));
            il.iIi1 = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{22}, IL1Iii.IL1Iii(new byte[]{4, 14, 84, 4, 6, 86}, IL1Iii.IL1Iii(new byte[]{85, 3, 86, 11, 1, 84}, "04d9e7"))));
            il.iIlLiL = jSONObject.getInt(IL1Iii.IL1Iii(new byte[]{90}, IL1Iii.IL1Iii(new byte[]{84, 84, 80, 92, 95, 7}, IL1Iii.IL1Iii(new byte[]{82, 84, 1, 1, 7, 82}, "4709a4"))));
            il.f3483Ilil = IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{1, 3}, IL1Iii.IL1Iii(new byte[]{84, 1, 81, 6, 4, 92}, IL1Iii.IL1Iii(new byte[]{5, 85, 80, 0, 6, 1}, "203dce")))));
            il.f3482ILil = IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{95, 84}, IL1Iii.IL1Iii(new byte[]{15, 4, 83, 7, 10, 86}, IL1Iii.IL1Iii(new byte[]{95, 0, 1, 87, 94, 7}, "f47afa")))));
            il.f3480I1I = IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{83, 93, 2}, IL1Iii.IL1Iii(new byte[]{0, 2, 85, 80, 2, 3}, IL1Iii.IL1Iii(new byte[]{3, 87, 81, 1, 85, 1}, "3ab5e4")))));
            il.f1124IL = IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{21, 0, 79, 21}, IL1Iii.IL1Iii(new byte[]{89, 87, 1, 4, 85, 0}, IL1Iii.IL1Iii(new byte[]{13, 10, 82, 83, 7, 5}, "58d641")))));
            IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{13, 8, 91, 65}, IL1Iii.IL1Iii(new byte[]{80, 4, 1, 6, 91, 1}, IL1Iii.IL1Iii(new byte[]{1, 81, 3, 6, 0, 80}, "4475cb")))));
            il.f1132lLi1LL = IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{68, 66, 88}, IL1Iii.IL1Iii(new byte[]{82, 84, 86, 2, 1, 83}, IL1Iii.IL1Iii(new byte[]{1, 86, 86, 0, 80, 87}, "b243cb")))));
            il.f1128iILLL1 = IL1Iii(jSONObject.getString(IL1Iii.IL1Iii(new byte[]{17, 85, 16, 93}, IL1Iii.IL1Iii(new byte[]{88, 12, 87, 87, 9, 2}, IL1Iii.IL1Iii(new byte[]{1, 0, 10, 80, 3, 2}, "88922c")))));
            JSONArray jSONArray = jSONObject.getJSONArray(IL1Iii.IL1Iii(new byte[]{87, 71, 21, 17}, IL1Iii.IL1Iii(new byte[]{0, 3, 7, 3, 5, 92}, IL1Iii.IL1Iii(new byte[]{8, 81, 95, 87, 6, 89}, "0e962a"))));
            if (jSONArray != null) {
                il.f1125IiL = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    il.f1125IiL.add(IL1Iii(jSONArray.getString(i)));
                }
            }
            il.f1127L11I = jSONObject.getBoolean(IL1Iii.IL1Iii(new byte[]{82, 13, 92, 91, 92, 93, 85}, IL1Iii.IL1Iii(new byte[]{9, 86, 10, 0, 81, 12}, IL1Iii.IL1Iii(new byte[]{93, 6, 81, 91, 3, 81}, "e5bcee"))));
            il.f1133il = jSONObject.getBoolean(IL1Iii.IL1Iii(new byte[]{85, 88, 84, 81, 92, 83}, IL1Iii.IL1Iii(new byte[]{6, 4, 87, 10, 6, 87}, IL1Iii.IL1Iii(new byte[]{3, 87, 90, 88, 87, 82}, "5e8aa3"))));
            jSONObject.getBoolean(IL1Iii.IL1Iii(new byte[]{92, 90, 73, 65, 28, 18, 88, 80, 92}, IL1Iii.IL1Iii(new byte[]{0, 85, 0, 3, 7, 80}, IL1Iii.IL1Iii(new byte[]{11, 4, 0, 1, 90, 6}, "2f9784"))));
            return il;
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{123, 111}, IL1Iii.IL1Iii(new byte[]{12, 81, 87, 92, 86, 10}, IL1Iii.IL1Iii(new byte[]{8, 7, 6, 11, 85, 81}, "1a72ac"))), e.toString());
            return null;
        }
    }
}
