package I1I.I1I.ILil;

import I1I.p062Ilil.p064Ilil.IL1Iii.IL;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import com.google.android.flexbox.BuildConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Executors;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: I1I.I1I.ILil.LI丨丨l丨l, reason: invalid class name */
/* JADX INFO: compiled from: NodeDumpByObject.java */
/* JADX INFO: loaded from: classes.dex */
public class LIll {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String[] f3149IL1Iii = {GridView.class.getName(), GridLayout.class.getName(), ListView.class.getName(), TableLayout.class.getName()};

    static {
        Executors.newFixedThreadPool(10);
    }

    public static void I1I(List<AccessibilityNodeInfo> list, IL il, int i, int i2, int i3, int i4, int i5, OutputStream outputStream, boolean z) throws IOException {
        int i6;
        int i7;
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setFeature(I1I.IL1Iii.IL1Iii(new byte[]{95, 76, 71, 71, 11, 30, 24, 64, 94, 91, 65, 68, 91, 84, 29, 88, 67, 86, 24, 78, 2, 24, 85, 94, 84, 23, 85, 82, 80, 69, 66, 74, 86, 68, 31, 89, 67, 85, 95, 20, 88, 95, 83, 93, 93, 67, 28, 94, 66, 76, 67, 66, 69}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 2, 14, 3, 8}, I1I.IL1Iii.IL1Iii(new byte[]{84, 12, 0, 11, 87, 1}, "c512e8"))), true);
        xmlSerializerNewSerializer.setOutput(outputStream, I1I.IL1Iii.IL1Iii(new byte[]{49, 100, 35, 75, 14}, I1I.IL1Iii.IL1Iii(new byte[]{85, 9, 3, 95, 83, 2}, I1I.IL1Iii.IL1Iii(new byte[]{83, 13, 5, 11, 93, 2}, "b4c284"))));
        xmlSerializerNewSerializer.startDocument(I1I.IL1Iii.IL1Iii(new byte[]{52, 101, 117, 29, 0}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 86, 83, 89, 84}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 6, 85, 0, 93}, "dec6a8"))), Boolean.TRUE);
        xmlSerializerNewSerializer.startTag(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{94, 88, 80, 74, 2, 22, 85, 89, 76}, I1I.IL1Iii.IL1Iii(new byte[]{15, 5, 7, 11, 87, 7}, I1I.IL1Iii.IL1Iii(new byte[]{15, 82, 0, 3, 80, 84}, "6f20d7"))));
        xmlSerializerNewSerializer.startTag(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{92, 14, 93, 85}, I1I.IL1Iii.IL1Iii(new byte[]{1, 4, 8, 84, 85, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 82, 1, 87, 95}, "42cecf"))));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{67, 13, 22, 80, 76, 15, 94, 12}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 4, 85, 90, 5}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 95, 87, 90, 81}, "e79382"))), Integer.toString(0));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{89, 94, 6, 3, 64}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 81, 4, 13, 87}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 7, 84, 80, 3}, "f346e7"))), Integer.toString(0));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 69, 77, 95}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 84, 11, 83, 85}, I1I.IL1Iii.IL1Iii(new byte[]{15, 81, 2, 11, 85, 3}, "97c91b"))), Integer.toString(0));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{69, 0, 79, 68}, I1I.IL1Iii.IL1Iii(new byte[]{9, 81, 82, 81, 85, 0}, I1I.IL1Iii.IL1Iii(new byte[]{14, 7, 80, 82, 7, 2}, "6353a5"))), m913IiL(BuildConfig.FLAVOR));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{92, 85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 14, 86, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 2, 15, 3, 4, 4}, "0c8a42"))), m913IiL(BuildConfig.FLAVOR));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{80, 14, 83, 70, 74}, I1I.IL1Iii.IL1Iii(new byte[]{87, 90, 83, 7, 11, 3}, I1I.IL1Iii.IL1Iii(new byte[]{85, 93, 7, 7, 87, 1}, "1ef5e3"))), m913IiL(BuildConfig.FLAVOR));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{22, 83, 2, 14, 80, 94, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 2, 4, 80, 15}, I1I.IL1Iii.IL1Iii(new byte[]{3, 82, 5, 88, 88, 3}, "60f995"))), m913IiL(BuildConfig.FLAVOR));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 23, 81}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 84, 11, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 85, 92, 80, 7}, "bfee3d"))), m913IiL(BuildConfig.FLAVOR));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{86, 12, 86, 7, 92, 81, 87, 8, 86}, I1I.IL1Iii.IL1Iii(new byte[]{12, 6, 11, 87, 7, 7}, I1I.IL1Iii.IL1Iii(new byte[]{11, 3, 0, 11, 1, 15}, "2a8818"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{86, 11, 0, 91, 15, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 82, 9, 2, 93}, I1I.IL1Iii.IL1Iii(new byte[]{88, 2, 83, 6, 4, 88}, "90d7ba"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 80, 7, 8, 3, 80, 88, 92}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 10, 82, 86, 81}, I1I.IL1Iii.IL1Iii(new byte[]{5, 6, 3, 80, 81, 4}, "370fd7"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{7, 89, 88, 0, 89, 92, 6}, I1I.IL1Iii.IL1Iii(new byte[]{6, 86, 0, 1, 12, 88}, I1I.IL1Iii.IL1Iii(new byte[]{92, 80, 1, 82, 93, 89}, "8181d8"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{4, 11, 0, 66, 23, 0, 0, 8, 6}, I1I.IL1Iii.IL1Iii(new byte[]{83, 93, 87, 15, 5, 83}, I1I.IL1Iii.IL1Iii(new byte[]{2, 91, 6, 15, 4, 86}, "3b27ed"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{5, 89, 83, 76, 64, 3, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 4, 88, 80, 81}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 13, 3, 0, 0}, "4e9bc7"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{16, 91, 17, 13, 88, 95, 2, 90, 15, 7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 94, 1, 4, 13, 87}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 90, 3, 8, 86}, "df8e12"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{91, 90, 8, 3, 5, 84, 94, 86, 13, 5, 4, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 3, 83, 83, 12}, I1I.IL1Iii.IL1Iii(new byte[]{90, 84, 92, 4, 2, 1}, "829375"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{66, 80, 69, 17, 67, 12, 64, 85}, I1I.IL1Iii.IL1Iii(new byte[]{84, 85, 82, 84, 6, 85}, I1I.IL1Iii.IL1Iii(new byte[]{82, 6, 7, 0, 83, 84}, "4bc6ab"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{75, 3, 15, 7, 82, 66, 93, 2}, I1I.IL1Iii.IL1Iii(new byte[]{10, 95, 86, 7, 8, 87}, I1I.IL1Iii.IL1Iii(new byte[]{87, 91, 80, 85, 10, 2}, "ebe03c"))), Boolean.toString(false));
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{79, 10, 71, 81, 80, 14, 92}, I1I.IL1Iii.IL1Iii(new byte[]{10, 91, 86, 12, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 4, 12, 83, 9}, "48f878"))), Boolean.toString(true));
        if (i4 == 0 || i5 == 0) {
            i6 = i;
            i7 = i2;
        } else {
            i6 = i4;
            i7 = i5;
        }
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{3, 11, 67, 95, 83, 65}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 82, 83, 82, 87}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 93, 80, 7, 93}, "7692b8"))), new Rect(0, 0, i6, i7).toShortString());
        xmlSerializerNewSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{86, 90, 77, 90, 86, 12, 90, 69, 89, 70, 87, 11, 64}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 90, 87, 2, 85}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 81, 84, 81, 8}, "f537a8"))), new Rect(0, 0, i6, i7).toShortString());
        for (int i8 = 0; i8 < list.size(); i8++) {
            AccessibilityNodeInfo accessibilityNodeInfo = list.get(i8);
            if (z || accessibilityNodeInfo.isVisibleToUser()) {
                ILil(accessibilityNodeInfo, xmlSerializerNewSerializer, i8, i, i2, 1, i4, i5, z);
                accessibilityNodeInfo.recycle();
            } else {
                accessibilityNodeInfo.recycle();
            }
        }
        xmlSerializerNewSerializer.endTag(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{90, 14, 7, 84}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 91, 83, 90, 93}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 89, 6, 13, 87}, "e1ad53"))));
        xmlSerializerNewSerializer.endTag(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{10, 92, 93, 64, 3, 19, 1, 93, 65}, I1I.IL1Iii.IL1Iii(new byte[]{87, 5, 9, 80, 81, 86}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 2, 86, 0, 84}, "cd343c"))));
        xmlSerializerNewSerializer.endDocument();
    }

    public static boolean IL1Iii(AccessibilityNodeInfo accessibilityNodeInfo) {
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child == null) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{120, 107}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 2, 93, 5, 2}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 86, 85, 6, 87}, "d6f144"))), String.format(I1I.IL1Iii.IL1Iii(new byte[]{121, 65, 93, 15, 20, 80, 95, 93, 93, 7, 20, 22, 83, 27, 20, 7, 24, 19, 71, 85, 67, 6, 90, 71, 13, 20, 20, 16}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 5, 82, 6, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 5, 86, 6, 0, 84}, "a0b725"))), Integer.valueOf(i), Integer.valueOf(childCount), accessibilityNodeInfo.toString()));
            } else if (!m913IiL(child.getContentDescription()).isEmpty() || !m913IiL(child.getText()).isEmpty() || IL1Iii(child)) {
                return true;
            }
        }
        return false;
    }

    public static void ILil(AccessibilityNodeInfo accessibilityNodeInfo, XmlSerializer xmlSerializer, int i, int i2, int i3, int i4, int i5, int i6, boolean z) throws IOException {
        String strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{11, 11, 2, 93}, I1I.IL1Iii.IL1Iii(new byte[]{80, 87, 81, 0, 0, 3}, I1I.IL1Iii.IL1Iii(new byte[]{83, 86, 14, 0, 1, 80}, "fe9812")));
        String str = BuildConfig.FLAVOR;
        xmlSerializer.startTag(BuildConfig.FLAVOR, strIL1Iii);
        if (!m915iILLL1(accessibilityNodeInfo) && !m916lLi1LL(accessibilityNodeInfo)) {
            xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{42, 36, 37}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 2, 2, 13, 7}, I1I.IL1Iii.IL1Iii(new byte[]{80, 80, 80, 7, 15, 0}, "6f1077"))), Boolean.toString(true));
        }
        if (Build.VERSION.SDK_INT >= 24) {
            xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{84, 66, 85, 22, 88, 15, 87, 95, 70, 5, 84, 19}, I1I.IL1Iii.IL1Iii(new byte[]{7, 9, 81, 86, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 9, 81, 4, 80, 7}, "3043ee"))), Integer.toString(accessibilityNodeInfo.getDrawingOrder()));
        } else {
            xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{81, 68, 85, 79, 88, 89, 82, 89, 70, 92, 84, 69}, I1I.IL1Iii.IL1Iii(new byte[]{80, 15, 5, 13, 85, 84}, I1I.IL1Iii.IL1Iii(new byte[]{82, 93, 6, 84, 1, 91}, "7d7ae8"))), Integer.toString(0));
        }
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{95, 89, 85, 4, 77}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 6, 0, 12, 3}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 4, 5, 12, 8}, "063d59"))), Integer.toString(i));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{6, 93, 66, 66, 95}, I1I.IL1Iii.IL1Iii(new byte[]{4, 10, 86, 82, 86, 15}, I1I.IL1Iii.IL1Iii(new byte[]{80, 87, 5, 6, 7, 4}, "6eabf3"))), Integer.toString(i4));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{71, 1, 65, 22}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 11, 6, 85, 87}, I1I.IL1Iii.IL1Iii(new byte[]{15, 85, 84, 82, 83, 10}, "9af6c9"))), m913IiL(accessibilityNodeInfo.getText()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{80, 93}, I1I.IL1Iii.IL1Iii(new byte[]{15, 92, 12, 80, 7, 86}, I1I.IL1Iii.IL1Iii(new byte[]{15, 82, 15, 4, 4, 81}, "976e0f"))), m913IiL(accessibilityNodeInfo.getViewIdResourceName()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{6, 15, 85, 18, 74}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 3, 82, 93, 88}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 4, 87, 6, 83}, "d53db2"))), m913IiL(accessibilityNodeInfo.getClassName()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{64, 0, 2, 82, 88, 1, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 81, 90, 10, 83}, I1I.IL1Iii.IL1Iii(new byte[]{3, 92, 81, 83, 86, 7}, "39a0e2"))), m913IiL(accessibilityNodeInfo.getPackageName()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{0, 93, 23, 0}, I1I.IL1Iii.IL1Iii(new byte[]{82, 1, 85, 86, 6, 15}, I1I.IL1Iii.IL1Iii(new byte[]{15, 95, 3, 3, 85, 83}, "9f260e"))), m913IiL(accessibilityNodeInfo.getContentDescription()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{80, 11, 7, 5, 89, 2, 81, 15, 7}, I1I.IL1Iii.IL1Iii(new byte[]{6, 2, 7, 86, 0, 83}, I1I.IL1Iii.IL1Iii(new byte[]{7, 80, 4, 86, 81, 5}, "21afc5"))), Boolean.toString(accessibilityNodeInfo.isCheckable()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 83, 90, 94, 85, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 14, 5, 13, 6, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 4, 87, 7, 86}, "b47c45"))), Boolean.toString(accessibilityNodeInfo.isChecked()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 15, 85, 92, 0, 87, 10, 3}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 2, 5, 83, 87}, I1I.IL1Iii.IL1Iii(new byte[]{83, 5, 0, 4, 82, 0}, "ccd766"))), Boolean.toString(accessibilityNodeInfo.isClickable()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{86, 88, 88, 1, 95, 87, 87}, I1I.IL1Iii.IL1Iii(new byte[]{4, 1, 11, 81, 0, 80}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 5, 80, 1, 83}, "4c7b21"))), Boolean.toString(accessibilityNodeInfo.isEnabled()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{94, 14, 7, 76, 70, 84, 90, 13, 1}, I1I.IL1Iii.IL1Iii(new byte[]{8, 3, 7, 14, 80, 83}, I1I.IL1Iii.IL1Iii(new byte[]{6, 86, 90, 85, 6, 4}, "649bcb"))), Boolean.toString(accessibilityNodeInfo.isFocusable()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{0, 11, 83, 17, 64, 83, 2}, I1I.IL1Iii.IL1Iii(new byte[]{7, 92, 3, 81, 80, 83}, I1I.IL1Iii.IL1Iii(new byte[]{88, 9, 85, 13, 5, 3}, "91f8ff"))), Boolean.toString(accessibilityNodeInfo.isFocused()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{22, 1, 17, 92, 94, 95, 4, 0, 15, 86}, I1I.IL1Iii.IL1Iii(new byte[]{4, 90, 1, 4, 81, 87}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 0, 86, 85, 83}, "e8ba67"))), Boolean.toString(accessibilityNodeInfo.isScrollable()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{95, 95, 10, 85, 82, 94, 90, 83, 15, 83, 83, 94, 86}, I1I.IL1Iii.IL1Iii(new byte[]{10, 6, 7, 84, 9, 0}, I1I.IL1Iii.IL1Iii(new byte[]{90, 4, 87, 94, 92, 11}, "c248d9"))), Boolean.toString(accessibilityNodeInfo.isLongClickable()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{70, 3, 22, 66, 78, 95, 68, 6}, I1I.IL1Iii.IL1Iii(new byte[]{2, 83, 80, 4, 92, 7}, I1I.IL1Iii.IL1Iii(new byte[]{80, 87, 84, 86, 92, 0}, "dfac97"))), Boolean.toString(accessibilityNodeInfo.isPassword()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{66, 87, 93, 6, 1, 23, 84, 86}, I1I.IL1Iii.IL1Iii(new byte[]{82, 10, 0, 5, 1, 90}, I1I.IL1Iii.IL1Iii(new byte[]{81, 9, 1, 86, 7, 1}, "2100d8"))), Boolean.toString(accessibilityNodeInfo.isSelected()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{21, 91, 21, 92, 80, 95, 6}, I1I.IL1Iii.IL1Iii(new byte[]{91, 0, 80, 5, 1, 7}, I1I.IL1Iii.IL1Iii(new byte[]{91, 10, 82, 82, 3, 1}, "c8db05"))), Boolean.toString(accessibilityNodeInfo.isVisibleToUser()));
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{80, 10, 22, 86, 1, 64}, I1I.IL1Iii.IL1Iii(new byte[]{84, 87, 87, 1, 82, 87}, I1I.IL1Iii.IL1Iii(new byte[]{86, 4, 6, 92, 2, 81}, "062e55"))), Ilil(accessibilityNodeInfo, i2, i3, i5, i6).toShortString());
        xmlSerializer.attribute(BuildConfig.FLAVOR, I1I.IL1Iii.IL1Iii(new byte[]{83, 94, 68, 89, 84, 13, 95, 65, 80, 69, 85, 10, 69}, I1I.IL1Iii.IL1Iii(new byte[]{3, 9, 9, 82, 3, 82}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 10, 87, 5, 87}, "a8226a"))), m912IL(accessibilityNodeInfo, i2, i3, i5, i6).toShortString());
        int childCount = accessibilityNodeInfo.getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i7);
            if (child != null) {
                if (z || child.isVisibleToUser()) {
                    ILil(child, xmlSerializer, i7, i2, i3, i4 + 1, i5, i6, z);
                    child.recycle();
                } else {
                    child.recycle();
                }
            }
            i7++;
            childCount = childCount;
            str = str;
        }
        xmlSerializer.endTag(str, I1I.IL1Iii.IL1Iii(new byte[]{87, 14, 0, 4}, I1I.IL1Iii.IL1Iii(new byte[]{10, 4, 92, 85, 3, 83}, I1I.IL1Iii.IL1Iii(new byte[]{86, 7, 8, 2, 4, 0}, "eb0632"))));
    }

    public static Rect Ilil(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2, int i3, int i4) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        Rect rect2 = new Rect();
        rect2.top = 0;
        rect2.left = 0;
        rect2.right = i;
        rect2.bottom = i2;
        rect.intersect(rect2);
        if (i3 > 0 && i4 > 0) {
            rect2.right = i3;
            rect2.bottom = i4;
            float f = (i3 * 1.0f) / i;
            float f2 = (i4 * 1.0f) / i2;
            rect.left = (int) (rect.left * f);
            rect.top = (int) (rect.top * f2);
            rect.right = (int) (rect.right * f);
            rect.bottom = (int) (rect.bottom * f2);
        }
        return rect;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Rect m912IL(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2, int i3, int i4) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect);
        Rect rect2 = new Rect();
        rect2.top = 0;
        rect2.left = 0;
        rect2.right = i;
        rect2.bottom = i2;
        rect.intersect(rect2);
        if (i3 > 0 && i4 > 0) {
            rect2.right = i3;
            rect2.bottom = i4;
            float f = (i3 * 1.0f) / i;
            float f2 = (i4 * 1.0f) / i2;
            rect.left = (int) (rect.left * f);
            rect.top = (int) (rect.top * f2);
            rect.right = (int) (rect.right * f);
            rect.bottom = (int) (rect.bottom * f2);
        }
        return rect;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static String m913IiL(CharSequence charSequence) {
        return charSequence == null ? BuildConfig.FLAVOR : m914L11I(charSequence);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static String m914L11I(CharSequence charSequence) {
        return charSequence.toString().replaceAll(I1I.IL1Iii.IL1Iii(new byte[]{105, 109, 58, 110, 60, 16, 31, -34, -84, -36, -40, -80, -78, 30, -36, -36, -117, -64, -94, -77, -77, 78, -62, -65, -115, -116, 110}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 85, 87, 82, 6}, I1I.IL1Iii.IL1Iii(new byte[]{5, 87, 3, 3, 6, 4}, "76e7b2"))), I1I.IL1Iii.IL1Iii(new byte[]{90}, I1I.IL1Iii.IL1Iii(new byte[]{84, 0, 1, 15, 3, 0}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 1, 92, 84, 1}, "474e11"))));
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static boolean m915iILLL1(AccessibilityNodeInfo accessibilityNodeInfo) {
        String strM913IiL = m913IiL(accessibilityNodeInfo.getClassName());
        for (String str : f3149IL1Iii) {
            if (strM913IiL.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static boolean m916lLi1LL(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled() && m913IiL(accessibilityNodeInfo.getContentDescription()).isEmpty() && m913IiL(accessibilityNodeInfo.getText()).isEmpty()) {
            return IL1Iii(accessibilityNodeInfo);
        }
        return true;
    }
}
