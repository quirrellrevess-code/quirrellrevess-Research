package I1I.I1I.p008IL;

import I1I.IL1Iii;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import android.util.Xml;
import com.google.android.flexbox.BuildConfig;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: I1I.I1I.I丨L.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: LookApp.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Context f3342IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static PackageManager f3343ILil;

    public static String I1I() {
        try {
            StringWriter stringWriter = new StringWriter();
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument(IL1Iii.IL1Iii(new byte[]{71, 69, 87, 21, 1}, IL1Iii.IL1Iii(new byte[]{5, 7, 1, 10, 12, 83}, IL1Iii.IL1Iii(new byte[]{14, 80, 0, 2, 83, 4}, "9f00f1"))), Boolean.TRUE);
            xmlSerializerNewSerializer.startTag(null, IL1Iii.IL1Iii(new byte[]{3, 17, 71, 75}, IL1Iii.IL1Iii(new byte[]{81, 85, 81, 11, 7, 10}, IL1Iii.IL1Iii(new byte[]{4, 85, 87, 86, 81, 90}, "7a1e0c"))));
            List<PackageInfo> installedPackages = f3343ILil.getInstalledPackages(0);
            for (int i = 0; i < installedPackages.size(); i++) {
                ILil(xmlSerializerNewSerializer, installedPackages.get(i));
            }
            xmlSerializerNewSerializer.endTag(null, IL1Iii.IL1Iii(new byte[]{82, 64, 69, 74}, IL1Iii.IL1Iii(new byte[]{6, 5, 2, 93, 80, 0}, IL1Iii.IL1Iii(new byte[]{80, 87, 84, 7, 86, 84}, "ebcc5f"))));
            xmlSerializerNewSerializer.endDocument();
            xmlSerializerNewSerializer.setOutput(stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            Log.i(IL1Iii.IL1Iii(new byte[]{43, 58}, IL1Iii.IL1Iii(new byte[]{4, 91, 81, 1, 1, 5}, IL1Iii.IL1Iii(new byte[]{88, 95, 3, 14, 2, 81}, "9fe907"))), IL1Iii.IL1Iii(new byte[]{89, 9, 93, 10, 66, 72, 21, 3, 64, 19, 13}, IL1Iii.IL1Iii(new byte[]{0, 2, 3, 87, 85, 94}, IL1Iii.IL1Iii(new byte[]{2, 82, 8, 1, 86, 81}, "769747"))) + e.toString());
            return null;
        }
    }

    public static void IL1Iii(Context context) {
        f3342IL1Iii = context;
        if (context != null) {
            try {
                f3343ILil = context.getPackageManager();
            } catch (Exception unused) {
            }
        }
    }

    public static void ILil(XmlSerializer xmlSerializer, PackageInfo packageInfo) {
        try {
            String strM1075IL = m1075IL(packageInfo.packageName);
            ActivityInfo[] activityInfoArr = f3343ILil.getPackageInfo(packageInfo.packageName, 1).activities;
            String str = (String) packageInfo.applicationInfo.loadLabel(f3343ILil);
            String str2 = null;
            xmlSerializer.startTag(null, IL1Iii.IL1Iii(new byte[]{2, 22, 22}, IL1Iii.IL1Iii(new byte[]{7, 7, 81, 4, 15, 0}, IL1Iii.IL1Iii(new byte[]{83, 80, 84, 0, 83, 7}, "71c7d7"))));
            xmlSerializer.attribute(null, IL1Iii.IL1Iii(new byte[]{64, 15, 6}, IL1Iii.IL1Iii(new byte[]{1, 92, 83, 80, 84, 2}, IL1Iii.IL1Iii(new byte[]{85, 8, 7, 1, 84, 10}, "d05ea8"))), packageInfo.packageName);
            xmlSerializer.attribute(null, IL1Iii.IL1Iii(new byte[]{12, 5, 11, 4}, IL1Iii.IL1Iii(new byte[]{4, 2, 2, 2, 6, 0}, IL1Iii.IL1Iii(new byte[]{7, 82, 83, 86, 86, 4}, "a475eb"))), str);
            xmlSerializer.attribute(null, IL1Iii.IL1Iii(new byte[]{75, 77, 66, 69, 1, 85}, IL1Iii.IL1Iii(new byte[]{94, 81, 85, 80, 7, 15}, IL1Iii.IL1Iii(new byte[]{83, 87, 0, 81, 86, 0}, "52d057"))), Boolean.toString((packageInfo.applicationInfo.flags & 1) != 0));
            if (activityInfoArr != null) {
                int i = 0;
                while (i < activityInfoArr.length) {
                    try {
                        xmlSerializer.startTag(str2, IL1Iii.IL1Iii(new byte[]{2, 83, 69, 12, 18, 8, 23, 73}, IL1Iii.IL1Iii(new byte[]{85, 81, 7, 85, 0, 7}, IL1Iii.IL1Iii(new byte[]{83, 0, 2, 82, 2, 4}, "ea4bfb"))));
                        xmlSerializer.attribute(str2, IL1Iii.IL1Iii(new byte[]{11, 80, 14, 81}, IL1Iii.IL1Iii(new byte[]{7, 0, 91, 86, 14, 6}, IL1Iii.IL1Iii(new byte[]{85, 9, 93, 0, 11, 0}, "78eb24"))), activityInfoArr[i].name);
                        xmlSerializer.attribute(null, IL1Iii.IL1Iii(new byte[]{90, 76, 12, 81, 89, 1, 68}, IL1Iii.IL1Iii(new byte[]{1, 8, 87, 5, 2, 84}, IL1Iii.IL1Iii(new byte[]{0, 3, 2, 4, 7, 86}, "72734f"))), strM1075IL.equals(activityInfoArr[i].name) ? IL1Iii.IL1Iii(new byte[]{4}, IL1Iii.IL1Iii(new byte[]{0, 86, 6, 5, 3, 93}, IL1Iii.IL1Iii(new byte[]{4, 6, 83, 4, 86, 95}, "16137f"))) : IL1Iii.IL1Iii(new byte[]{82}, IL1Iii.IL1Iii(new byte[]{90, 7, 84, 86, 1, 86}, IL1Iii.IL1Iii(new byte[]{11, 82, 86, 7, 14, 85}, "3cdf6e"))));
                        xmlSerializer.endTag(null, IL1Iii.IL1Iii(new byte[]{83, 7, 21, 81, 67, 94, 70, 29}, IL1Iii.IL1Iii(new byte[]{0, 93, 86, 9, 84, 6}, IL1Iii.IL1Iii(new byte[]{0, 14, 85, 0, 7, 5}, "27b1f4"))));
                        i++;
                        str2 = null;
                    } catch (Exception unused) {
                    }
                }
            }
            xmlSerializer.endTag(null, IL1Iii.IL1Iii(new byte[]{83, 66, 65}, IL1Iii.IL1Iii(new byte[]{0, 0, 87, 14, 82, 86}, IL1Iii.IL1Iii(new byte[]{0, 81, 2, 15, 86, 6}, "2cd8b5"))));
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static String m1075IL(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = f3343ILil.getPackageInfo(str, 0);
        Intent intent = new Intent(IL1Iii.IL1Iii(new byte[]{88, 90, 7, 16, 87, 10, 93, 26, 10, 12, 76, 6, 87, 64, 77, 3, 91, 23, 80, 91, 13, 76, 117, 34, 112, 122}, IL1Iii.IL1Iii(new byte[]{1, 6, 82, 90, 10, 82}, IL1Iii.IL1Iii(new byte[]{15, 4, 80, 9, 0, 0}, "76a121"))), (Uri) null);
        intent.addCategory(IL1Iii.IL1Iii(new byte[]{87, 86, 93, 68, 88, 95, 82, 22, 80, 88, 67, 83, 88, 76, 23, 85, 86, 66, 83, 95, 86, 68, 78, 24, 122, 121, 108, 120, 116, 126, 115, 106}, IL1Iii.IL1Iii(new byte[]{82, 91, 12, 2, 7, 85}, IL1Iii.IL1Iii(new byte[]{93, 1, 87, 7, 6, 91}, "9bb368"))));
        intent.setPackage(packageInfo.packageName);
        Iterator<ResolveInfo> it = f3343ILil.queryIntentActivities(intent, 131072).iterator();
        return it.hasNext() ? it.next().activityInfo.name : BuildConfig.FLAVOR;
    }
}
