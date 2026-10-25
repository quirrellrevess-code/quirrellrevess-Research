package ILil.ILil.p023lIlii;

import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.p028IiL.p035lLi1LL.I1I.iILLL1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public class llI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public TypedValue f3825I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f3826IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final TypedArray f3827ILil;

    public llI(Context context, TypedArray typedArray) {
        this.f3826IL1Iii = context;
        this.f3827ILil = typedArray;
    }

    public static llI I11li1(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new llI(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static llI iIi1(Context context, int i, int[] iArr) {
        return new llI(context, context.obtainStyledAttributes(i, iArr));
    }

    public static llI iIlLiL(Context context, AttributeSet attributeSet, int[] iArr) {
        return new llI(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public ColorStateList I1I(int i) {
        int resourceId;
        ColorStateList colorStateListI1I;
        return (!this.f3827ILil.hasValue(i) || (resourceId = this.f3827ILil.getResourceId(i, 0)) == 0 || (colorStateListI1I = IL1Iii.I1I(this.f3826IL1Iii, resourceId)) == null) ? this.f3827ILil.getColorStateList(i) : colorStateListI1I;
    }

    public boolean IL1Iii(int i, boolean z) {
        return this.f3827ILil.getBoolean(i, z);
    }

    public int ILL(int i, int i2) {
        return this.f3827ILil.getInt(i, i2);
    }

    public int ILil(int i, int i2) {
        return this.f3827ILil.getColor(i, i2);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int m1822ILl(int i, int i2) {
        return this.f3827ILil.getResourceId(i, i2);
    }

    public int Ilil(int i, int i2) {
        return this.f3827ILil.getDimensionPixelOffset(i, i2);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public float m1823IL(int i, float f) {
        return this.f3827ILil.getDimension(i, f);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Drawable m1824IiL(int i) {
        int resourceId;
        if (!this.f3827ILil.hasValue(i) || (resourceId = this.f3827ILil.getResourceId(i, 0)) == 0) {
            return null;
        }
        return iILLL1.ILil().m1782IL(this.f3826IL1Iii, resourceId, true);
    }

    public String Lil(int i) {
        return this.f3827ILil.getString(i);
    }

    public CharSequence LlLI1(int i) {
        return this.f3827ILil.getText(i);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int m1825Ll1(int i, int i2) {
        return this.f3827ILil.getInteger(i, i2);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public float m1826L11I(int i, float f) {
        return this.f3827ILil.getFloat(i, f);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Drawable m1827iILLL1(int i) {
        int resourceId;
        return (!this.f3827ILil.hasValue(i) || (resourceId = this.f3827ILil.getResourceId(i, 0)) == 0) ? this.f3827ILil.getDrawable(i) : IL1Iii.m1686IL(this.f3826IL1Iii, resourceId);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int m1828lIiI(int i, int i2) {
        return this.f3827ILil.getLayoutDimension(i, i2);
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m1829lIlii(int i) {
        return this.f3827ILil.hasValue(i);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public CharSequence[] m1830llL1ii(int i) {
        return this.f3827ILil.getTextArray(i);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int m1831lLi1LL(int i, int i2) {
        return this.f3827ILil.getDimensionPixelSize(i, i2);
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Typeface m1832il(int i, int i2, iILLL1.IL1Iii iL1Iii) {
        int resourceId = this.f3827ILil.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f3825I1I == null) {
            this.f3825I1I = new TypedValue();
        }
        return iILLL1.I1I(this.f3826IL1Iii, resourceId, this.f3825I1I, i2, iL1Iii);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public void m1833lL() {
        this.f3827ILil.recycle();
    }
}
