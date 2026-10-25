package ILil.p028IiL.p035lLi1LL.I1I;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ComplexColorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class ILil {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f4209I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Shader f4210IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ColorStateList f4211ILil;

    public ILil(Shader shader, ColorStateList colorStateList, int i) {
        this.f4210IL1Iii = shader;
        this.f4211ILil = colorStateList;
        this.f4209I1I = i;
    }

    public static ILil I1I(ColorStateList colorStateList) {
        return new ILil(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static ILil IL1Iii(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return m2304IL(IL.ILil(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return I1I(IL1Iii.ILil(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static ILil ILil(int i) {
        return new ILil(null, null, i);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static ILil m2304IL(Shader shader) {
        return new ILil(shader, null, 0);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static ILil m2305iILLL1(Resources resources, int i, Resources.Theme theme) {
        try {
            return IL1Iii(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    public void ILL(int i) {
        this.f4209I1I = i;
    }

    public int Ilil() {
        return this.f4209I1I;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m2306IiL() {
        return this.f4210IL1Iii != null;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m2307Ll1() {
        return m2306IiL() || this.f4209I1I != 0;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean m2308L11I() {
        ColorStateList colorStateList;
        return this.f4210IL1Iii == null && (colorStateList = this.f4211ILil) != null && colorStateList.isStateful();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Shader m2309lLi1LL() {
        return this.f4210IL1Iii;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public boolean m2310il(int[] iArr) {
        if (m2308L11I()) {
            ColorStateList colorStateList = this.f4211ILil;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f4209I1I) {
                this.f4209I1I = colorForState;
                return true;
            }
        }
        return false;
    }
}
