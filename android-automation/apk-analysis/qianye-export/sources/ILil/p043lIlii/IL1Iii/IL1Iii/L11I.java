package ILil.p043lIlii.IL1Iii.IL1Iii;

import ILil.p065Ilil.Ll1;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I, reason: invalid class name */
/* JADX INFO: compiled from: VectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class L11I extends ILil.p043lIlii.IL1Iii.IL1Iii.IiL {
    public static final PorterDuff.Mode ILL = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public C0582L11I f4371I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ColorFilter f4372Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public PorterDuffColorFilter f1806IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final float[] f1807IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final Matrix f1808L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f1809iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f1810lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final Rect f1811il;

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$ILil */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class ILil extends iILLL1 {
        public ILil() {
        }

        @Override // ILil.p043lIlii.IL1Iii.IL1Iii.L11I.iILLL1
        public boolean I1I() {
            return true;
        }

        public void Ilil(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (ILil.p028IiL.p035lLi1LL.I1I.IiL.m2318il(xmlPullParser, "pathData")) {
                TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1796IL);
                m2532lLi1LL(typedArrayILL, xmlPullParser);
                typedArrayILL.recycle();
            }
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final void m2532lLi1LL(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4388ILil = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4387IL1Iii = ILil.p028IiL.p033iILLL1.ILil.m2263IL(string2);
            }
            this.f4386I1I = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public ILil(ILil iLil) {
            super(iLil);
        }
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$L丨1丨1丨I, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class C0582L11I extends Drawable.ConstantState {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ColorStateList f4382I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4383IL1Iii;
        public boolean ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public IiL f4384ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f4385Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public PorterDuff.Mode f1838IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public PorterDuff.Mode f1839IiL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public Paint f1840Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f1841L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public ColorStateList f1842iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public Bitmap f1843lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public boolean f1844il;

        public C0582L11I(C0582L11I c0582l11i) {
            this.f4382I1I = null;
            this.f1838IL = L11I.ILL;
            if (c0582l11i != null) {
                this.f4383IL1Iii = c0582l11i.f4383IL1Iii;
                IiL iiL = new IiL(c0582l11i.f4384ILil);
                this.f4384ILil = iiL;
                if (c0582l11i.f4384ILil.f4381Ilil != null) {
                    iiL.f4381Ilil = new Paint(c0582l11i.f4384ILil.f4381Ilil);
                }
                if (c0582l11i.f4384ILil.f1830IL != null) {
                    this.f4384ILil.f1830IL = new Paint(c0582l11i.f4384ILil.f1830IL);
                }
                this.f4382I1I = c0582l11i.f4382I1I;
                this.f1838IL = c0582l11i.f1838IL;
                this.f4385Ilil = c0582l11i.f4385Ilil;
            }
        }

        public void I1I(int i, int i2) {
            if (this.f1843lLi1LL == null || !IL1Iii(i, i2)) {
                this.f1843lLi1LL = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.ILL = true;
            }
        }

        public boolean IL1Iii(int i, int i2) {
            return i == this.f1843lLi1LL.getWidth() && i2 == this.f1843lLi1LL.getHeight();
        }

        public boolean ILil() {
            return !this.ILL && this.f1842iILLL1 == this.f4382I1I && this.f1839IiL == this.f1838IL && this.f1844il == this.f4385Ilil && this.f1841L11I == this.f4384ILil.getRootAlpha();
        }

        public Paint Ilil(ColorFilter colorFilter) {
            if (!m2541lLi1LL() && colorFilter == null) {
                return null;
            }
            if (this.f1840Ll1 == null) {
                Paint paint = new Paint();
                this.f1840Ll1 = paint;
                paint.setFilterBitmap(true);
            }
            this.f1840Ll1.setAlpha(this.f4384ILil.getRootAlpha());
            this.f1840Ll1.setColorFilter(colorFilter);
            return this.f1840Ll1;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m2537IL(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f1843lLi1LL, (Rect) null, rect, Ilil(colorFilter));
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public boolean m2538IiL(int[] iArr) {
            boolean zM2535iILLL1 = this.f4384ILil.m2535iILLL1(iArr);
            this.ILL |= zM2535iILLL1;
            return zM2535iILLL1;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void m2539L11I() {
            this.f1842iILLL1 = this.f4382I1I;
            this.f1839IiL = this.f1838IL;
            this.f1841L11I = this.f4384ILil.getRootAlpha();
            this.f1844il = this.f4385Ilil;
            this.ILL = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4383IL1Iii;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean m2540iILLL1() {
            return this.f4384ILil.m2536lLi1LL();
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean m2541lLi1LL() {
            return this.f4384ILil.getRootAlpha() < 255;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new L11I(this);
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void m2542il(int i, int i2) {
            this.f1843lLi1LL.eraseColor(0);
            this.f4384ILil.ILil(new Canvas(this.f1843lLi1LL), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new L11I(this);
        }

        public C0582L11I() {
            this.f4382I1I = null;
            this.f1838IL = L11I.ILL;
            this.f4384ILil = new IiL();
        }
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static abstract class lLi1LL {
        public lLi1LL() {
        }

        public boolean IL1Iii() {
            return false;
        }

        public boolean ILil(int[] iArr) {
            return false;
        }
    }

    public L11I() {
        this.f1809iILLL1 = true;
        this.f1807IiL = new float[9];
        this.f1808L11I = new Matrix();
        this.f1811il = new Rect();
        this.f4371I1I = new C0582L11I();
    }

    public static L11I I1I(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        L11I l11i = new L11I();
        l11i.inflate(resources, xmlPullParser, attributeSet, theme);
        return l11i;
    }

    public static int IL1Iii(int i, float f) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24);
    }

    public static L11I ILil(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            L11I l11i = new L11I();
            l11i.f4370ILil = ILil.p028IiL.p035lLi1LL.I1I.iILLL1.IL1Iii(resources, i, theme);
            new C0643il(l11i.f4370ILil.getConstantState());
            return l11i;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return I1I(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static PorterDuff.Mode m2523iILLL1(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public final void Ilil(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0582L11I c0582l11i = this.f4371I1I;
        IiL iiL = c0582l11i.f4384ILil;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(iiL.f1831IiL);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                IL il = (IL) arrayDeque.peek();
                if ("path".equals(name)) {
                    I1I i1i = new I1I();
                    i1i.m2530iILLL1(resources, attributeSet, theme, xmlPullParser);
                    il.f4376ILil.add(i1i);
                    if (i1i.getPathName() != null) {
                        iiL.LlLI1.put(i1i.getPathName(), i1i);
                    }
                    z = false;
                    c0582l11i.f4383IL1Iii = i1i.f1845IL | c0582l11i.f4383IL1Iii;
                } else if ("clip-path".equals(name)) {
                    ILil iLil = new ILil();
                    iLil.Ilil(resources, attributeSet, theme, xmlPullParser);
                    il.f4376ILil.add(iLil);
                    if (iLil.getPathName() != null) {
                        iiL.LlLI1.put(iLil.getPathName(), iLil);
                    }
                    c0582l11i.f4383IL1Iii = iLil.f1845IL | c0582l11i.f4383IL1Iii;
                } else if ("group".equals(name)) {
                    IL il2 = new IL();
                    il2.I1I(resources, attributeSet, theme, xmlPullParser);
                    il.f4376ILil.add(il2);
                    arrayDeque.push(il2);
                    if (il2.getGroupName() != null) {
                        iiL.LlLI1.put(il2.getGroupName(), il2);
                    }
                    c0582l11i.f4383IL1Iii = il2.ILL | c0582l11i.f4383IL1Iii;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object m2524IL(String str) {
        return this.f4371I1I.f4384ILil.LlLI1.get(str);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m2525IiL(boolean z) {
        this.f1809iILLL1 = z;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m2526L11I(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        C0582L11I c0582l11i = this.f4371I1I;
        IiL iiL = c0582l11i.f4384ILil;
        c0582l11i.f1838IL = m2523iILLL1(ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListI1I = ILil.p028IiL.p035lLi1LL.I1I.IiL.I1I(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListI1I != null) {
            c0582l11i.f4382I1I = colorStateListI1I;
        }
        c0582l11i.f4385Ilil = ILil.p028IiL.p035lLi1LL.I1I.IiL.IL1Iii(typedArray, xmlPullParser, "autoMirrored", 5, c0582l11i.f4385Ilil);
        iiL.ILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "viewportWidth", 7, iiL.ILL);
        float fM2317lLi1LL = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "viewportHeight", 8, iiL.f1832Ll1);
        iiL.f1832Ll1 = fM2317lLi1LL;
        if (iiL.ILL <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fM2317lLi1LL <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        iiL.f1833L11I = typedArray.getDimension(3, iiL.f1833L11I);
        float dimension = typedArray.getDimension(2, iiL.f1837il);
        iiL.f1837il = dimension;
        if (iiL.f1833L11I <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        iiL.setAlpha(ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "alpha", 4, iiL.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            iiL.f1829ILl = string;
            iiL.LlLI1.put(string, iiL);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f4370ILil;
        if (drawable == null) {
            return false;
        }
        ILil.p028IiL.p033iILLL1.ILL.IL1Iii.ILil(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f1811il);
        if (this.f1811il.width() <= 0 || this.f1811il.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f4372Ilil;
        if (colorFilter == null) {
            colorFilter = this.f1806IL;
        }
        canvas.getMatrix(this.f1808L11I);
        this.f1808L11I.getValues(this.f1807IiL);
        float fAbs = Math.abs(this.f1807IiL[0]);
        float fAbs2 = Math.abs(this.f1807IiL[4]);
        float fAbs3 = Math.abs(this.f1807IiL[1]);
        float fAbs4 = Math.abs(this.f1807IiL[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (this.f1811il.width() * fAbs);
        int iHeight = (int) (this.f1811il.height() * fAbs2);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, iHeight);
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f1811il;
        canvas.translate(rect.left, rect.top);
        if (m2527lLi1LL()) {
            canvas.translate(this.f1811il.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f1811il.offsetTo(0, 0);
        this.f4371I1I.I1I(iMin, iMin2);
        if (!this.f1809iILLL1) {
            this.f4371I1I.m2542il(iMin, iMin2);
        } else if (!this.f4371I1I.ILil()) {
            this.f4371I1I.m2542il(iMin, iMin2);
            this.f4371I1I.m2539L11I();
        }
        this.f4371I1I.m2537IL(canvas, colorFilter, this.f1811il);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2250IL(drawable) : this.f4371I1I.f4384ILil.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4371I1I.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Ilil(drawable) : this.f4372Ilil;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4370ILil != null && Build.VERSION.SDK_INT >= 24) {
            return new C0643il(this.f4370ILil.getConstantState());
        }
        this.f4371I1I.f4383IL1Iii = getChangingConfigurations();
        return this.f4371I1I;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f4371I1I.f4384ILil.f1837il;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f4371I1I.f4384ILil.f1833L11I;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2251IiL(drawable) : this.f4371I1I.f4385Ilil;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0582L11I c0582l11i;
        ColorStateList colorStateList;
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((c0582l11i = this.f4371I1I) != null && (c0582l11i.m2540iILLL1() || ((colorStateList = this.f4371I1I.f4382I1I) != null && colorStateList.isStateful())));
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final boolean m2527lLi1LL() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2258lLi1LL(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f1810lLi1LL && super.mutate() == this) {
            this.f4371I1I = new C0582L11I(this.f4371I1I);
            this.f1810lLi1LL = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0582L11I c0582l11i = this.f4371I1I;
        ColorStateList colorStateList = c0582l11i.f4382I1I;
        if (colorStateList != null && (mode = c0582l11i.f1838IL) != null) {
            this.f1806IL = m2528il(this.f1806IL, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!c0582l11i.m2540iILLL1() || !c0582l11i.m2538IiL(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f4371I1I.f4384ILil.getRootAlpha() != i) {
            this.f4371I1I.f4384ILil.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2259il(drawable, z);
        } else {
            this.f4371I1I.f4385Ilil = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4372Ilil = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTint(int i) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2249ILl(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawable, colorStateList);
            return;
        }
        C0582L11I c0582l11i = this.f4371I1I;
        if (c0582l11i.f4382I1I != colorStateList) {
            c0582l11i.f4382I1I = colorStateList;
            this.f1806IL = m2528il(this.f1806IL, colorStateList, c0582l11i.f1838IL);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(drawable, mode);
            return;
        }
        C0582L11I c0582l11i = this.f4371I1I;
        if (c0582l11i.f1838IL != mode) {
            c0582l11i.f1838IL = mode;
            this.f1806IL = m2528il(this.f1806IL, c0582l11i.f4382I1I, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public PorterDuffColorFilter m2528il(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$丨il, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class C0643il extends Drawable.ConstantState {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Drawable.ConstantState f4389IL1Iii;

        public C0643il(Drawable.ConstantState constantState) {
            this.f4389IL1Iii = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4389IL1Iii.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4389IL1Iii.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            L11I l11i = new L11I();
            l11i.f4370ILil = (VectorDrawable) this.f4389IL1Iii.newDrawable();
            return l11i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            L11I l11i = new L11I();
            l11i.f4370ILil = (VectorDrawable) this.f4389IL1Iii.newDrawable(resources);
            return l11i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            L11I l11i = new L11I();
            l11i.f4370ILil = (VectorDrawable) this.f4389IL1Iii.newDrawable(resources, theme);
            return l11i;
        }
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static abstract class iILLL1 extends lLi1LL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4386I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public ILil.p028IiL.p033iILLL1.ILil.C0572ILil[] f4387IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public String f4388ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1845IL;

        public iILLL1() {
            super();
            this.f4387IL1Iii = null;
            this.f4386I1I = 0;
        }

        public boolean I1I() {
            return false;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void m2543IL(Path path) {
            path.reset();
            ILil.p028IiL.p033iILLL1.ILil.C0572ILil[] c0572ILilArr = this.f4387IL1Iii;
            if (c0572ILilArr != null) {
                ILil.p028IiL.p033iILLL1.ILil.C0572ILil.Ilil(c0572ILilArr, path);
            }
        }

        public ILil.p028IiL.p033iILLL1.ILil.C0572ILil[] getPathData() {
            return this.f4387IL1Iii;
        }

        public String getPathName() {
            return this.f4388ILil;
        }

        public void setPathData(ILil.p028IiL.p033iILLL1.ILil.C0572ILil[] c0572ILilArr) {
            if (ILil.p028IiL.p033iILLL1.ILil.ILil(this.f4387IL1Iii, c0572ILilArr)) {
                ILil.p028IiL.p033iILLL1.ILil.m2268il(this.f4387IL1Iii, c0572ILilArr);
            } else {
                this.f4387IL1Iii = ILil.p028IiL.p033iILLL1.ILil.m2267lLi1LL(c0572ILilArr);
            }
        }

        public iILLL1(iILLL1 iilll1) {
            super();
            this.f4387IL1Iii = null;
            this.f4386I1I = 0;
            this.f4388ILil = iilll1.f4388ILil;
            this.f1845IL = iilll1.f1845IL;
            this.f4387IL1Iii = ILil.p028IiL.p033iILLL1.ILil.m2267lLi1LL(iilll1.f4387IL1Iii);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2254iILLL1(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0582L11I c0582l11i = this.f4371I1I;
        c0582l11i.f4384ILil = new IiL();
        TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f4358IL1Iii);
        m2526L11I(typedArrayILL, xmlPullParser, theme);
        typedArrayILL.recycle();
        c0582l11i.f4383IL1Iii = getChangingConfigurations();
        c0582l11i.ILL = true;
        Ilil(resources, xmlPullParser, attributeSet, theme);
        this.f1806IL = m2528il(this.f1806IL, c0582l11i.f4382I1I, c0582l11i.f1838IL);
    }

    public L11I(C0582L11I c0582l11i) {
        this.f1809iILLL1 = true;
        this.f1807IiL = new float[9];
        this.f1808L11I = new Matrix();
        this.f1811il = new Rect();
        this.f4371I1I = c0582l11i;
        this.f1806IL = m2528il(this.f1806IL, c0582l11i.f4382I1I, c0582l11i.f1838IL);
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$I1I */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class I1I extends iILLL1 {
        public float ILL;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public Paint.Cap f1812ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int[] f4373Ilil;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public ILil.p028IiL.p035lLi1LL.I1I.ILil f1813IiL;
        public Paint.Join Lil;
        public float LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public float f1814Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public float f1815L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public float f1816iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public float f1817lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public ILil.p028IiL.p035lLi1LL.I1I.ILil f1818lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public float f1819il;

        public I1I() {
            this.f1816iILLL1 = 0.0f;
            this.f1815L11I = 1.0f;
            this.f1819il = 1.0f;
            this.ILL = 0.0f;
            this.f1814Ll1 = 1.0f;
            this.f1817lIiI = 0.0f;
            this.f1812ILl = Paint.Cap.BUTT;
            this.Lil = Paint.Join.MITER;
            this.LlLI1 = 4.0f;
        }

        @Override // ILil.p043lIlii.IL1Iii.IL1Iii.L11I.lLi1LL
        public boolean IL1Iii() {
            return this.f1813IiL.m2308L11I() || this.f1818lLi1LL.m2308L11I();
        }

        @Override // ILil.p043lIlii.IL1Iii.IL1Iii.L11I.lLi1LL
        public boolean ILil(int[] iArr) {
            return this.f1818lLi1LL.m2310il(iArr) | this.f1813IiL.m2310il(iArr);
        }

        public final Paint.Cap Ilil(int i, Paint.Cap cap) {
            if (i == 0) {
                return Paint.Cap.BUTT;
            }
            if (i != 1) {
                return i != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final void m2529IiL(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f4373Ilil = null;
            if (ILil.p028IiL.p035lLi1LL.I1I.IiL.m2318il(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4388ILil = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4387IL1Iii = ILil.p028IiL.p033iILLL1.ILil.m2263IL(string2);
                }
                this.f1813IiL = ILil.p028IiL.p035lLi1LL.I1I.IiL.Ilil(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f1819il = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "fillAlpha", 12, this.f1819il);
                this.f1812ILl = Ilil(ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f1812ILl);
                this.Lil = m2531lLi1LL(ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.Lil);
                this.LlLI1 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.LlLI1);
                this.f1818lLi1LL = ILil.p028IiL.p035lLi1LL.I1I.IiL.Ilil(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f1815L11I = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "strokeAlpha", 11, this.f1815L11I);
                this.f1816iILLL1 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "strokeWidth", 4, this.f1816iILLL1);
                this.f1814Ll1 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "trimPathEnd", 6, this.f1814Ll1);
                this.f1817lIiI = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "trimPathOffset", 7, this.f1817lIiI);
                this.ILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "trimPathStart", 5, this.ILL);
                this.f4386I1I = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArray, xmlPullParser, "fillType", 13, this.f4386I1I);
            }
        }

        public float getFillAlpha() {
            return this.f1819il;
        }

        public int getFillColor() {
            return this.f1813IiL.Ilil();
        }

        public float getStrokeAlpha() {
            return this.f1815L11I;
        }

        public int getStrokeColor() {
            return this.f1818lLi1LL.Ilil();
        }

        public float getStrokeWidth() {
            return this.f1816iILLL1;
        }

        public float getTrimPathEnd() {
            return this.f1814Ll1;
        }

        public float getTrimPathOffset() {
            return this.f1817lIiI;
        }

        public float getTrimPathStart() {
            return this.ILL;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m2530iILLL1(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f4357I1I);
            m2529IiL(typedArrayILL, xmlPullParser, theme);
            typedArrayILL.recycle();
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final Paint.Join m2531lLi1LL(int i, Paint.Join join) {
            if (i == 0) {
                return Paint.Join.MITER;
            }
            if (i != 1) {
                return i != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void setFillAlpha(float f) {
            this.f1819il = f;
        }

        public void setFillColor(int i) {
            this.f1813IiL.ILL(i);
        }

        public void setStrokeAlpha(float f) {
            this.f1815L11I = f;
        }

        public void setStrokeColor(int i) {
            this.f1818lLi1LL.ILL(i);
        }

        public void setStrokeWidth(float f) {
            this.f1816iILLL1 = f;
        }

        public void setTrimPathEnd(float f) {
            this.f1814Ll1 = f;
        }

        public void setTrimPathOffset(float f) {
            this.f1817lIiI = f;
        }

        public void setTrimPathStart(float f) {
            this.ILL = f;
        }

        public I1I(I1I i1i) {
            super(i1i);
            this.f1816iILLL1 = 0.0f;
            this.f1815L11I = 1.0f;
            this.f1819il = 1.0f;
            this.ILL = 0.0f;
            this.f1814Ll1 = 1.0f;
            this.f1817lIiI = 0.0f;
            this.f1812ILl = Paint.Cap.BUTT;
            this.Lil = Paint.Join.MITER;
            this.LlLI1 = 4.0f;
            this.f4373Ilil = i1i.f4373Ilil;
            this.f1818lLi1LL = i1i.f1818lLi1LL;
            this.f1816iILLL1 = i1i.f1816iILLL1;
            this.f1815L11I = i1i.f1815L11I;
            this.f1813IiL = i1i.f1813IiL;
            this.f4386I1I = i1i.f4386I1I;
            this.f1819il = i1i.f1819il;
            this.ILL = i1i.ILL;
            this.f1814Ll1 = i1i.f1814Ll1;
            this.f1817lIiI = i1i.f1817lIiI;
            this.f1812ILl = i1i.f1812ILl;
            this.Lil = i1i.Lil;
            this.LlLI1 = i1i.LlLI1;
        }
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class IiL {

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public static final Matrix f1828llL1ii = new Matrix();

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Matrix f4378I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Path f4379IL1Iii;
        public float ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Path f4380ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public String f1829ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Paint f4381Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public Paint f1830IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final IL f1831IiL;
        public Boolean Lil;
        public final Ll1<String, Object> LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public float f1832Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public float f1833L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public int f1834iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public int f1835lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public PathMeasure f1836lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public float f1837il;

        public IiL() {
            this.f4378I1I = new Matrix();
            this.f1833L11I = 0.0f;
            this.f1837il = 0.0f;
            this.ILL = 0.0f;
            this.f1832Ll1 = 0.0f;
            this.f1835lIiI = 255;
            this.f1829ILl = null;
            this.Lil = null;
            this.LlLI1 = new Ll1<>();
            this.f1831IiL = new IL();
            this.f4379IL1Iii = new Path();
            this.f4380ILil = new Path();
        }

        public static float IL1Iii(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public final void I1I(IL il, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            il.f4375IL1Iii.set(matrix);
            il.f4375IL1Iii.preConcat(il.f1827il);
            canvas.save();
            for (int i3 = 0; i3 < il.f4376ILil.size(); i3++) {
                lLi1LL lli1ll = il.f4376ILil.get(i3);
                if (lli1ll instanceof IL) {
                    I1I((IL) lli1ll, il.f4375IL1Iii, canvas, i, i2, colorFilter);
                } else if (lli1ll instanceof iILLL1) {
                    m2534IL(il, (iILLL1) lli1ll, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void ILil(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            I1I(this.f1831IiL, f1828llL1ii, canvas, i, i2, colorFilter);
        }

        public final float Ilil(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fIL1Iii = IL1Iii(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fIL1Iii) / fMax;
            }
            return 0.0f;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final void m2534IL(IL il, iILLL1 iilll1, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.ILL;
            float f2 = i2 / this.f1832Ll1;
            float fMin = Math.min(f, f2);
            Matrix matrix = il.f4375IL1Iii;
            this.f4378I1I.set(matrix);
            this.f4378I1I.postScale(f, f2);
            float fIlil = Ilil(matrix);
            if (fIlil == 0.0f) {
                return;
            }
            iilll1.m2543IL(this.f4379IL1Iii);
            Path path = this.f4379IL1Iii;
            this.f4380ILil.reset();
            if (iilll1.I1I()) {
                this.f4380ILil.setFillType(iilll1.f4386I1I == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f4380ILil.addPath(path, this.f4378I1I);
                canvas.clipPath(this.f4380ILil);
                return;
            }
            I1I i1i = (I1I) iilll1;
            float f3 = i1i.ILL;
            if (f3 != 0.0f || i1i.f1814Ll1 != 1.0f) {
                float f4 = i1i.f1817lIiI;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (i1i.f1814Ll1 + f4) % 1.0f;
                if (this.f1836lLi1LL == null) {
                    this.f1836lLi1LL = new PathMeasure();
                }
                this.f1836lLi1LL.setPath(this.f4379IL1Iii, false);
                float length = this.f1836lLi1LL.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.f1836lLi1LL.getSegment(f7, length, path, true);
                    this.f1836lLi1LL.getSegment(0.0f, f8, path, true);
                } else {
                    this.f1836lLi1LL.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f4380ILil.addPath(path, this.f4378I1I);
            if (i1i.f1813IiL.m2307Ll1()) {
                ILil.p028IiL.p035lLi1LL.I1I.ILil iLil = i1i.f1813IiL;
                if (this.f4381Ilil == null) {
                    Paint paint = new Paint(1);
                    this.f4381Ilil = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f4381Ilil;
                if (iLil.m2306IiL()) {
                    Shader shaderM2309lLi1LL = iLil.m2309lLi1LL();
                    shaderM2309lLi1LL.setLocalMatrix(this.f4378I1I);
                    paint2.setShader(shaderM2309lLi1LL);
                    paint2.setAlpha(Math.round(i1i.f1819il * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(L11I.IL1Iii(iLil.Ilil(), i1i.f1819il));
                }
                paint2.setColorFilter(colorFilter);
                this.f4380ILil.setFillType(i1i.f4386I1I == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f4380ILil, paint2);
            }
            if (i1i.f1818lLi1LL.m2307Ll1()) {
                ILil.p028IiL.p035lLi1LL.I1I.ILil iLil2 = i1i.f1818lLi1LL;
                if (this.f1830IL == null) {
                    Paint paint3 = new Paint(1);
                    this.f1830IL = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f1830IL;
                Paint.Join join = i1i.Lil;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = i1i.f1812ILl;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(i1i.LlLI1);
                if (iLil2.m2306IiL()) {
                    Shader shaderM2309lLi1LL2 = iLil2.m2309lLi1LL();
                    shaderM2309lLi1LL2.setLocalMatrix(this.f4378I1I);
                    paint4.setShader(shaderM2309lLi1LL2);
                    paint4.setAlpha(Math.round(i1i.f1815L11I * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(L11I.IL1Iii(iLil2.Ilil(), i1i.f1815L11I));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(i1i.f1816iILLL1 * fMin * fIlil);
                canvas.drawPath(this.f4380ILil, paint4);
            }
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f1835lIiI;
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean m2535iILLL1(int[] iArr) {
            return this.f1831IiL.ILil(iArr);
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean m2536lLi1LL() {
            if (this.Lil == null) {
                this.Lil = Boolean.valueOf(this.f1831IiL.IL1Iii());
            }
            return this.Lil.booleanValue();
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f1835lIiI = i;
        }

        public IiL(IiL iiL) {
            this.f4378I1I = new Matrix();
            this.f1833L11I = 0.0f;
            this.f1837il = 0.0f;
            this.ILL = 0.0f;
            this.f1832Ll1 = 0.0f;
            this.f1835lIiI = 255;
            this.f1829ILl = null;
            this.Lil = null;
            Ll1<String, Object> ll1 = new Ll1<>();
            this.LlLI1 = ll1;
            this.f1831IiL = new IL(iiL.f1831IiL, ll1);
            this.f4379IL1Iii = new Path(iiL.f4379IL1Iii);
            this.f4380ILil = new Path(iiL.f4380ILil);
            this.f1833L11I = iiL.f1833L11I;
            this.f1837il = iiL.f1837il;
            this.ILL = iiL.ILL;
            this.f1832Ll1 = iiL.f1832Ll1;
            this.f1834iILLL1 = iiL.f1834iILLL1;
            this.f1835lIiI = iiL.f1835lIiI;
            this.f1829ILl = iiL.f1829ILl;
            String str = iiL.f1829ILl;
            if (str != null) {
                ll1.put(str, this);
            }
            this.Lil = iiL.Lil;
        }
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.L丨1丨1丨I$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    public static class IL extends lLi1LL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public float f4374I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Matrix f4375IL1Iii;
        public int ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final ArrayList<lLi1LL> f4376ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public float f4377Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public float f1820IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public float f1821IiL;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public int[] f1822Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public float f1823L11I;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public float f1824iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public String f1825lIiI;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public float f1826lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public final Matrix f1827il;

        public IL(IL il, Ll1<String, Object> ll1) {
            iILLL1 iLil;
            super();
            this.f4375IL1Iii = new Matrix();
            this.f4376ILil = new ArrayList<>();
            this.f4374I1I = 0.0f;
            this.f1820IL = 0.0f;
            this.f4377Ilil = 0.0f;
            this.f1826lLi1LL = 1.0f;
            this.f1824iILLL1 = 1.0f;
            this.f1821IiL = 0.0f;
            this.f1823L11I = 0.0f;
            Matrix matrix = new Matrix();
            this.f1827il = matrix;
            this.f1825lIiI = null;
            this.f4374I1I = il.f4374I1I;
            this.f1820IL = il.f1820IL;
            this.f4377Ilil = il.f4377Ilil;
            this.f1826lLi1LL = il.f1826lLi1LL;
            this.f1824iILLL1 = il.f1824iILLL1;
            this.f1821IiL = il.f1821IiL;
            this.f1823L11I = il.f1823L11I;
            this.f1822Ll1 = il.f1822Ll1;
            String str = il.f1825lIiI;
            this.f1825lIiI = str;
            this.ILL = il.ILL;
            if (str != null) {
                ll1.put(str, this);
            }
            matrix.set(il.f1827il);
            ArrayList<lLi1LL> arrayList = il.f4376ILil;
            for (int i = 0; i < arrayList.size(); i++) {
                lLi1LL lli1ll = arrayList.get(i);
                if (lli1ll instanceof IL) {
                    this.f4376ILil.add(new IL((IL) lli1ll, ll1));
                } else {
                    if (lli1ll instanceof I1I) {
                        iLil = new I1I((I1I) lli1ll);
                    } else {
                        if (!(lli1ll instanceof ILil)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        iLil = new ILil((ILil) lli1ll);
                    }
                    this.f4376ILil.add(iLil);
                    String str2 = iLil.f4388ILil;
                    if (str2 != null) {
                        ll1.put(str2, iLil);
                    }
                }
            }
        }

        public void I1I(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f4359ILil);
            Ilil(typedArrayILL, xmlPullParser);
            typedArrayILL.recycle();
        }

        @Override // ILil.p043lIlii.IL1Iii.IL1Iii.L11I.lLi1LL
        public boolean IL1Iii() {
            for (int i = 0; i < this.f4376ILil.size(); i++) {
                if (this.f4376ILil.get(i).IL1Iii()) {
                    return true;
                }
            }
            return false;
        }

        @Override // ILil.p043lIlii.IL1Iii.IL1Iii.L11I.lLi1LL
        public boolean ILil(int[] iArr) {
            boolean zILil = false;
            for (int i = 0; i < this.f4376ILil.size(); i++) {
                zILil |= this.f4376ILil.get(i).ILil(iArr);
            }
            return zILil;
        }

        public final void Ilil(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f1822Ll1 = null;
            this.f4374I1I = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "rotation", 5, this.f4374I1I);
            this.f1820IL = typedArray.getFloat(1, this.f1820IL);
            this.f4377Ilil = typedArray.getFloat(2, this.f4377Ilil);
            this.f1826lLi1LL = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "scaleX", 3, this.f1826lLi1LL);
            this.f1824iILLL1 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "scaleY", 4, this.f1824iILLL1);
            this.f1821IiL = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "translateX", 6, this.f1821IiL);
            this.f1823L11I = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2317lLi1LL(typedArray, xmlPullParser, "translateY", 7, this.f1823L11I);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1825lIiI = string;
            }
            m2533IL();
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final void m2533IL() {
            this.f1827il.reset();
            this.f1827il.postTranslate(-this.f1820IL, -this.f4377Ilil);
            this.f1827il.postScale(this.f1826lLi1LL, this.f1824iILLL1);
            this.f1827il.postRotate(this.f4374I1I, 0.0f, 0.0f);
            this.f1827il.postTranslate(this.f1821IiL + this.f1820IL, this.f1823L11I + this.f4377Ilil);
        }

        public String getGroupName() {
            return this.f1825lIiI;
        }

        public Matrix getLocalMatrix() {
            return this.f1827il;
        }

        public float getPivotX() {
            return this.f1820IL;
        }

        public float getPivotY() {
            return this.f4377Ilil;
        }

        public float getRotation() {
            return this.f4374I1I;
        }

        public float getScaleX() {
            return this.f1826lLi1LL;
        }

        public float getScaleY() {
            return this.f1824iILLL1;
        }

        public float getTranslateX() {
            return this.f1821IiL;
        }

        public float getTranslateY() {
            return this.f1823L11I;
        }

        public void setPivotX(float f) {
            if (f != this.f1820IL) {
                this.f1820IL = f;
                m2533IL();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f4377Ilil) {
                this.f4377Ilil = f;
                m2533IL();
            }
        }

        public void setRotation(float f) {
            if (f != this.f4374I1I) {
                this.f4374I1I = f;
                m2533IL();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f1826lLi1LL) {
                this.f1826lLi1LL = f;
                m2533IL();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f1824iILLL1) {
                this.f1824iILLL1 = f;
                m2533IL();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f1821IiL) {
                this.f1821IiL = f;
                m2533IL();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f1823L11I) {
                this.f1823L11I = f;
                m2533IL();
            }
        }

        public IL() {
            super();
            this.f4375IL1Iii = new Matrix();
            this.f4376ILil = new ArrayList<>();
            this.f4374I1I = 0.0f;
            this.f1820IL = 0.0f;
            this.f4377Ilil = 0.0f;
            this.f1826lLi1LL = 1.0f;
            this.f1824iILLL1 = 1.0f;
            this.f1821IiL = 0.0f;
            this.f1823L11I = 0.0f;
            this.f1827il = new Matrix();
            this.f1825lIiI = null;
        }
    }
}
