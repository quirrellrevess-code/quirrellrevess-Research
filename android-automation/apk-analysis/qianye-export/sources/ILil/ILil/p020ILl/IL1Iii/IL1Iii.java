package ILil.ILil.p020ILl.IL1Iii;

import ILil.ILil.p023lIlii.I11L;
import ILil.p043lIlii.IL1Iii.IL1Iii.L11I;
import ILil.p065Ilil.Lil;
import ILil.p065Ilil.iIi1;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class IL1Iii extends ILil.ILil.p020ILl.IL1Iii.IL implements ILil.p028IiL.p033iILLL1.ILL.ILil {
    public I1I LlLI1;
    public int iIi1;
    public boolean iIlLiL;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public int f1273lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public IiL f1274llL1ii;

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    public static class I1I extends ILil.ILil.p020ILl.IL1Iii.IL.IL1Iii {

        /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
        public Lil<Long> f1275IIi;

        /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
        public iIi1<Integer> f1276LIll;

        public I1I(I1I i1i, IL1Iii iL1Iii, Resources resources) {
            super(i1i, iL1Iii, resources);
            if (i1i != null) {
                this.f1275IIi = i1i.f1275IIi;
                this.f1276LIll = i1i.f1276LIll;
            } else {
                this.f1275IIi = new Lil<>();
                this.f1276LIll = new iIi1<>();
            }
        }

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public static long m1613L111(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        public int LL1IL(int i, int i2, Drawable drawable, boolean z) {
            int iIL1Iii = super.IL1Iii(drawable);
            long jM1613L111 = m1613L111(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = iIL1Iii;
            this.f1275IIi.IL1Iii(jM1613L111, Long.valueOf(j2 | j));
            if (z) {
                this.f1275IIi.IL1Iii(m1613L111(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return iIL1Iii;
        }

        /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
        public boolean m1614L1l(int i, int i2) {
            return (this.f1275IIi.m1945iILLL1(m1613L111(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
        public boolean m1615l1IIi1(int i, int i2) {
            return (this.f1275IIi.m1945iILLL1(m1613L111(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public int m1616lIII(int[] iArr, Drawable drawable, int i) {
            int iM16371 = super.m16371(iArr, drawable);
            this.f1276LIll.ILL(iM16371, Integer.valueOf(i));
            return iM16371;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL.IL1Iii, ILil.ILil.IL丨丨l.IL1Iii.ILil.I1I
        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public void mo1617lIlii() {
            this.f1275IIi = this.f1275IIi.clone();
            this.f1276LIll = this.f1276LIll.clone();
        }

        public int llI(int i, int i2) {
            return (int) this.f1275IIi.m1945iILLL1(m1613L111(i, i2), -1L).longValue();
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL.IL1Iii, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new IL1Iii(this, null);
        }

        /* JADX INFO: renamed from: 丨丨 */
        public int m58(int[] iArr) {
            int iM1636LlLLL = super.m1636LlLLL(iArr);
            return iM1636LlLLL >= 0 ? iM1636LlLLL : super.m1636LlLLL(StateSet.WILD_CARD);
        }

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public int m1618LLlI1(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f1276LIll.m1964lLi1LL(i, 0).intValue();
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL.IL1Iii, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new IL1Iii(this, resources);
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    public static class ILil extends IiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Animatable f3699IL1Iii;

        public ILil(Animatable animatable) {
            super();
            this.f3699IL1Iii = animatable;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        public void I1I() {
            this.f3699IL1Iii.start();
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void mo1619IL() {
            this.f3699IL1Iii.stop();
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.IL1Iii$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    public static class IL extends IiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ILil.p043lIlii.IL1Iii.IL1Iii.ILil f3700IL1Iii;

        public IL(ILil.p043lIlii.IL1Iii.IL1Iii.ILil iLil) {
            super();
            this.f3700IL1Iii = iLil;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        public void I1I() {
            this.f3700IL1Iii.start();
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        /* JADX INFO: renamed from: I丨L */
        public void mo1619IL() {
            this.f3700IL1Iii.stop();
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.IL1Iii$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    public static abstract class IiL {
        public IiL() {
        }

        public abstract void I1I();

        public boolean IL1Iii() {
            return false;
        }

        public void ILil() {
        }

        /* JADX INFO: renamed from: I丨L */
        public abstract void mo1619IL();
    }

    /* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.IL1Iii$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    public static class iILLL1 implements TimeInterpolator {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3701I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int[] f3702IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3703ILil;

        public iILLL1(AnimationDrawable animationDrawable, boolean z) {
            ILil(animationDrawable, z);
        }

        public int IL1Iii() {
            return this.f3701I1I;
        }

        public int ILil(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f3703ILil = numberOfFrames;
            int[] iArr = this.f3702IL1Iii;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f3702IL1Iii = new int[numberOfFrames];
            }
            int[] iArr2 = this.f3702IL1Iii;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f3701I1I = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f3701I1I) + 0.5f);
            int i2 = this.f3703ILil;
            int[] iArr = this.f3702IL1Iii;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f3701I1I : 0.0f);
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.IL丨丨l.IL1Iii.IL1Iii$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    public static class lLi1LL extends IiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ObjectAnimator f3704IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final boolean f3705ILil;

        public lLi1LL(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            iILLL1 iilll1 = new iILLL1(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(iilll1.IL1Iii());
            objectAnimatorOfInt.setInterpolator(iilll1);
            this.f3705ILil = z2;
            this.f3704IL1Iii = objectAnimatorOfInt;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        public void I1I() {
            this.f3704IL1Iii.start();
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        public boolean IL1Iii() {
            return this.f3705ILil;
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        public void ILil() {
            this.f3704IL1Iii.reverse();
        }

        @Override // ILil.ILil.p020ILl.IL1Iii.IL1Iii.IiL
        /* JADX INFO: renamed from: I丨L */
        public void mo1619IL() {
            this.f3704IL1Iii.cancel();
        }
    }

    public IL1Iii() {
        this(null, null);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static IL1Iii m1606lIiI(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            IL1Iii iL1Iii = new IL1Iii();
            iL1Iii.m1607ILl(context, resources, xmlPullParser, attributeSet, theme);
            return iL1Iii;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m1607ILl(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat);
        setVisible(typedArrayILL.getBoolean(ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat_android_visible, true), true);
        iIlLiL(typedArrayILL);
        m1622L11I(resources);
        typedArrayILL.recycle();
        Lil(context, resources, xmlPullParser, attributeSet, theme);
        LlLI1();
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.IL, ILil.ILil.p020ILl.IL1Iii.ILil
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void mo1608IiL(ILil.ILil.IL丨丨l.IL1Iii.ILil.I1I i1i) {
        super.mo1608IiL(i1i);
        if (i1i instanceof I1I) {
            this.LlLI1 = (I1I) i1i;
        }
    }

    public final void Lil(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    m1611llL1ii(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    m1610lIlii(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    public final void LlLI1() {
        onStateChange(getState());
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.IL
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public I1I ILil() {
        return new I1I(this.LlLI1, this, null);
    }

    public final boolean iIi1(int i) {
        int iI1I;
        int iLlI;
        IiL iLil;
        IiL iiL = this.f1274llL1ii;
        if (iiL == null) {
            iI1I = I1I();
        } else {
            if (i == this.f1273lIlii) {
                return true;
            }
            if (i == this.iIi1 && iiL.IL1Iii()) {
                iiL.ILil();
                this.f1273lIlii = this.iIi1;
                this.iIi1 = i;
                return true;
            }
            iI1I = this.f1273lIlii;
            iiL.mo1619IL();
        }
        this.f1274llL1ii = null;
        this.iIi1 = -1;
        this.f1273lIlii = -1;
        I1I i1i = this.LlLI1;
        int iM1618LLlI1 = i1i.m1618LLlI1(iI1I);
        int iM1618LLlI2 = i1i.m1618LLlI1(i);
        if (iM1618LLlI2 == 0 || iM1618LLlI1 == 0 || (iLlI = i1i.llI(iM1618LLlI1, iM1618LLlI2)) < 0) {
            return false;
        }
        boolean zM1614L1l = i1i.m1614L1l(iM1618LLlI1, iM1618LLlI2);
        m1623iILLL1(iLlI);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            iLil = new lLi1LL((AnimationDrawable) current, i1i.m1615l1IIi1(iM1618LLlI1, iM1618LLlI2), zM1614L1l);
        } else {
            if (!(current instanceof ILil.p043lIlii.IL1Iii.IL1Iii.ILil)) {
                if (current instanceof Animatable) {
                    iLil = new ILil((Animatable) current);
                }
                return false;
            }
            iLil = new IL((ILil.p043lIlii.IL1Iii.IL1Iii.ILil) current);
        }
        iLil.I1I();
        this.f1274llL1ii = iLil;
        this.iIi1 = iI1I;
        this.f1273lIlii = i;
        return true;
    }

    public final void iIlLiL(TypedArray typedArray) {
        I1I i1i = this.LlLI1;
        if (Build.VERSION.SDK_INT >= 21) {
            i1i.f1286IL |= typedArray.getChangingConfigurations();
        }
        i1i.llliI(typedArray.getBoolean(ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat_android_variablePadding, i1i.f1291L11I));
        i1i.iIlLiL(typedArray.getBoolean(ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat_android_constantSize, i1i.f1289Ll1));
        i1i.I11li1(typedArray.getInt(ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat_android_enterFadeDuration, i1i.f1292LlLLL));
        i1i.m1634lL(typedArray.getInt(ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat_android_exitFadeDuration, i1i.f1296lIII));
        setDither(typedArray.getBoolean(ILil.ILil.Lil.ILil.AnimatedStateListDrawableCompat_android_dither, i1i.llliI));
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.IL, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        IiL iiL = this.f1274llL1ii;
        if (iiL != null) {
            iiL.mo1619IL();
            this.f1274llL1ii = null;
            m1623iILLL1(this.f1273lIlii);
            this.f1273lIlii = -1;
            this.iIi1 = -1;
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final int m1610lIlii(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.ILil.Lil.ILil.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayILL.getResourceId(ILil.ILil.Lil.ILil.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayILL.getResourceId(ILil.ILil.Lil.ILil.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayILL.getResourceId(ILil.ILil.Lil.ILil.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableM1699il = resourceId3 > 0 ? I11L.m1689IiL().m1699il(context, resourceId3) : null;
        boolean z = typedArrayILL.getBoolean(ILil.ILil.Lil.ILil.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayILL.recycle();
        if (drawableM1699il == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableM1699il = ILil.p043lIlii.IL1Iii.IL1Iii.ILil.IL1Iii(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableM1699il = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableM1699il == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.LlLI1.LL1IL(resourceId, resourceId2, drawableM1699il, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final int m1611llL1ii(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayILL = ILil.p028IiL.p035lLi1LL.I1I.IiL.ILL(resources, theme, attributeSet, ILil.ILil.Lil.ILil.AnimatedStateListDrawableItem);
        int resourceId = typedArrayILL.getResourceId(ILil.ILil.Lil.ILil.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayILL.getResourceId(ILil.ILil.Lil.ILil.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableM1699il = resourceId2 > 0 ? I11L.m1689IiL().m1699il(context, resourceId2) : null;
        typedArrayILL.recycle();
        int[] iArrILL = ILL(attributeSet);
        if (drawableM1699il == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableM1699il = L11I.I1I(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableM1699il = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableM1699il != null) {
            return this.LlLI1.m1616lIII(iArrILL, drawableM1699il, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.IL, ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.iIlLiL) {
            super.mutate();
            if (this == this) {
                this.LlLI1.mo1617lIlii();
                this.iIlLiL = true;
            }
        }
        return this;
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.IL, ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int iM58 = this.LlLI1.m58(iArr);
        boolean z = iM58 != I1I() && (iIi1(iM58) || m1623iILLL1(iM58));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // ILil.ILil.p020ILl.IL1Iii.ILil, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        IiL iiL = this.f1274llL1ii;
        if (iiL != null && (visible || z2)) {
            if (z) {
                iiL.I1I();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public IL1Iii(I1I i1i, Resources resources) {
        super(null);
        this.f1273lIlii = -1;
        this.iIi1 = -1;
        mo1608IiL(new I1I(i1i, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
