package ILil.p028IiL.p035lLi1LL.I1I;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: FontResourcesParserCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class C0573I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f4201I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final String f4202IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f4203ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4204Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public String f1722IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f1723lLi1LL;

        public C0573I1I(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f4202IL1Iii = str;
            this.f4203ILil = i;
            this.f4201I1I = z;
            this.f1722IL = str2;
            this.f4204Ilil = i2;
            this.f1723lLi1LL = i3;
        }

        public int I1I() {
            return this.f4204Ilil;
        }

        public String IL1Iii() {
            return this.f4202IL1Iii;
        }

        public int ILil() {
            return this.f1723lLi1LL;
        }

        public int Ilil() {
            return this.f4203ILil;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public String m2300IL() {
            return this.f1722IL;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean m2301lLi1LL() {
            return this.f4201I1I;
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public interface IL1Iii {
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class ILil implements IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final C0573I1I[] f4205IL1Iii;

        public ILil(C0573I1I[] c0573i1iArr) {
            this.f4205IL1Iii = c0573i1iArr;
        }

        public C0573I1I[] IL1Iii() {
            return this.f4205IL1Iii;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.l丨Li1LL.I1I.I1I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class IL implements IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4206I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ILil.p028IiL.ILL.IL1Iii f4207IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f4208ILil;

        public IL(ILil.p028IiL.ILL.IL1Iii iL1Iii, int i, int i2) {
            this.f4207IL1Iii = iL1Iii;
            this.f4206I1I = i;
            this.f4208ILil = i2;
        }

        public int I1I() {
            return this.f4208ILil;
        }

        public int IL1Iii() {
            return this.f4206I1I;
        }

        public ILil.p028IiL.ILL.IL1Iii ILil() {
            return this.f4207IL1Iii;
        }
    }

    public static List<List<byte[]>> I1I(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (IL1Iii(typedArrayObtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m2297IiL(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m2297IiL(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static int IL1Iii(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static IL1Iii ILil(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m2296IL(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static IL1Iii Ilil(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), ILil.p028IiL.IL.FontFamily);
        String string = typedArrayObtainAttributes.getString(ILil.p028IiL.IL.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(ILil.p028IiL.IL.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(ILil.p028IiL.IL.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(ILil.p028IiL.IL.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(ILil.p028IiL.IL.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(ILil.p028IiL.IL.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m2298iILLL1(xmlPullParser);
            }
            return new IL(new ILil.p028IiL.ILL.IL1Iii(string, string2, string3, I1I(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m2299lLi1LL(xmlPullParser, resources));
                } else {
                    m2298iILLL1(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new ILil((C0573I1I[]) arrayList.toArray(new C0573I1I[arrayList.size()]));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static IL1Iii m2296IL(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return Ilil(xmlPullParser, resources);
        }
        m2298iILLL1(xmlPullParser);
        return null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static List<byte[]> m2297IiL(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static void m2298iILLL1(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static C0573I1I m2299lLi1LL(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), ILil.p028IiL.IL.FontFamilyFont);
        int i = ILil.p028IiL.IL.FontFamilyFont_fontWeight;
        if (!typedArrayObtainAttributes.hasValue(i)) {
            i = ILil.p028IiL.IL.FontFamilyFont_android_fontWeight;
        }
        int i2 = typedArrayObtainAttributes.getInt(i, 400);
        int i3 = ILil.p028IiL.IL.FontFamilyFont_fontStyle;
        if (!typedArrayObtainAttributes.hasValue(i3)) {
            i3 = ILil.p028IiL.IL.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == typedArrayObtainAttributes.getInt(i3, 0);
        int i4 = ILil.p028IiL.IL.FontFamilyFont_ttcIndex;
        if (!typedArrayObtainAttributes.hasValue(i4)) {
            i4 = ILil.p028IiL.IL.FontFamilyFont_android_ttcIndex;
        }
        int i5 = ILil.p028IiL.IL.FontFamilyFont_fontVariationSettings;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = ILil.p028IiL.IL.FontFamilyFont_android_fontVariationSettings;
        }
        String string = typedArrayObtainAttributes.getString(i5);
        int i6 = typedArrayObtainAttributes.getInt(i4, 0);
        int i7 = ILil.p028IiL.IL.FontFamilyFont_font;
        if (!typedArrayObtainAttributes.hasValue(i7)) {
            i7 = ILil.p028IiL.IL.FontFamilyFont_android_font;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i7, 0);
        String string2 = typedArrayObtainAttributes.getString(i7);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m2298iILLL1(xmlPullParser);
        }
        return new C0573I1I(string2, i2, z, string, i6, resourceId);
    }
}
