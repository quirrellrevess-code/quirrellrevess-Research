package ILil.p043lIlii.IL1Iii.IL1Iii;

import ILil.p028IiL.p035lLi1LL.I1I.IiL;
import ILil.p065Ilil.Ll1;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends IiL implements Animatable {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public C0581ILil f4361I1I;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ArgbEvaluator f4362Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Context f1803IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Drawable.Callback f1804lLi1LL;

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    public class IL1Iii implements Drawable.Callback {
        public IL1Iii() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            ILil.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            ILil.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            ILil.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: ILil.lI丨lii.IL1Iii.IL1Iii.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    public static class C0581ILil extends Drawable.ConstantState {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public AnimatorSet f4365I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4366IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public L11I f4367ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Ll1<Animator, String> f4368Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public ArrayList<Animator> f1805IL;

        public C0581ILil(Context context, C0581ILil c0581ILil, Drawable.Callback callback, Resources resources) {
            if (c0581ILil != null) {
                this.f4366IL1Iii = c0581ILil.f4366IL1Iii;
                L11I l11i = c0581ILil.f4367ILil;
                if (l11i != null) {
                    Drawable.ConstantState constantState = l11i.getConstantState();
                    if (resources != null) {
                        this.f4367ILil = (L11I) constantState.newDrawable(resources);
                    } else {
                        this.f4367ILil = (L11I) constantState.newDrawable();
                    }
                    L11I l11i2 = this.f4367ILil;
                    l11i2.mutate();
                    L11I l11i3 = l11i2;
                    this.f4367ILil = l11i3;
                    l11i3.setCallback(callback);
                    this.f4367ILil.setBounds(c0581ILil.f4367ILil.getBounds());
                    this.f4367ILil.m2525IiL(false);
                }
                ArrayList<Animator> arrayList = c0581ILil.f1805IL;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f1805IL = new ArrayList<>(size);
                    this.f4368Ilil = new Ll1<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0581ILil.f1805IL.get(i);
                        Animator animatorClone = animator.clone();
                        String str = c0581ILil.f4368Ilil.get(animator);
                        animatorClone.setTarget(this.f4367ILil.m2524IL(str));
                        this.f1805IL.add(animatorClone);
                        this.f4368Ilil.put(animatorClone, str);
                    }
                    IL1Iii();
                }
            }
        }

        public void IL1Iii() {
            if (this.f4365I1I == null) {
                this.f4365I1I = new AnimatorSet();
            }
            this.f4365I1I.playTogether(this.f1805IL);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4366IL1Iii;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public ILil() {
        this(null, null, null);
    }

    public static ILil IL1Iii(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ILil iLil = new ILil(context);
        iLil.inflate(resources, xmlPullParser, attributeSet, theme);
        return iLil;
    }

    public final void I1I(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                I1I(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4362Ilil == null) {
                    this.f4362Ilil = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4362Ilil);
            }
        }
    }

    public final void ILil(String str, Animator animator) {
        animator.setTarget(this.f4361I1I.f4367ILil.m2524IL(str));
        if (Build.VERSION.SDK_INT < 21) {
            I1I(animator);
        }
        C0581ILil c0581ILil = this.f4361I1I;
        if (c0581ILil.f1805IL == null) {
            c0581ILil.f1805IL = new ArrayList<>();
            this.f4361I1I.f4368Ilil = new Ll1<>();
        }
        this.f4361I1I.f1805IL.add(animator);
        this.f4361I1I.f4368Ilil.put(animator, str);
    }

    @Override // ILil.p043lIlii.IL1Iii.IL1Iii.IiL, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.IL1Iii(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            return ILil.p028IiL.p033iILLL1.ILL.IL1Iii.ILil(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4361I1I.f4367ILil.draw(canvas);
        if (this.f4361I1I.f4365I1I.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2250IL(drawable) : this.f4361I1I.f4367ILil.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4361I1I.f4366IL1Iii;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Ilil(drawable) : this.f4361I1I.f4367ILil.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4370ILil == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new I1I(this.f4370ILil.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f4361I1I.f4367ILil.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f4361I1I.f4367ILil.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.getOpacity() : this.f4361I1I.f4367ILil.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2254iILLL1(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayILL = IiL.ILL(resources, theme, attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f4360Ilil);
                    int resourceId = typedArrayILL.getResourceId(0, 0);
                    if (resourceId != 0) {
                        L11I l11iILil = L11I.ILil(resources, resourceId, theme);
                        l11iILil.m2525IiL(false);
                        l11iILil.setCallback(this.f1804lLi1LL);
                        L11I l11i = this.f4361I1I.f4367ILil;
                        if (l11i != null) {
                            l11i.setCallback(null);
                        }
                        this.f4361I1I.f4367ILil = l11iILil;
                    }
                    typedArrayILL.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, ILil.p043lIlii.IL1Iii.IL1Iii.IL1Iii.f1801lLi1LL);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f1803IL;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        ILil(string, IL.m2516L11I(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f4361I1I.IL1Iii();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2251IiL(drawable) : this.f4361I1I.f4367ILil.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f4361I1I.f4365I1I.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.isStateful() : this.f4361I1I.f4367ILil.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4361I1I.f4367ILil.setBounds(rect);
        }
    }

    @Override // ILil.p043lIlii.IL1Iii.IL1Iii.IiL, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.setLevel(i) : this.f4361I1I.f4367ILil.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4370ILil;
        return drawable != null ? drawable.setState(iArr) : this.f4361I1I.f4367ILil.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f4361I1I.f4367ILil.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2259il(drawable, z);
        } else {
            this.f4361I1I.f4367ILil.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4361I1I.f4367ILil.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTint(int i) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2249ILl(drawable, i);
        } else {
            this.f4361I1I.f4367ILil.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawable, colorStateList);
        } else {
            this.f4361I1I.f4367ILil.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, ILil.p028IiL.p033iILLL1.ILL.ILil
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ILil.p028IiL.p033iILLL1.ILL.IL1Iii.LlLI1(drawable, mode);
        } else {
            this.f4361I1I.f4367ILil.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f4361I1I.f4367ILil.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f4361I1I.f4365I1I.isStarted()) {
                return;
            }
            this.f4361I1I.f4365I1I.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f4370ILil;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4361I1I.f4365I1I.end();
        }
    }

    public ILil(Context context) {
        this(context, null, null);
    }

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    public static class I1I extends Drawable.ConstantState {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Drawable.ConstantState f4363IL1Iii;

        public I1I(Drawable.ConstantState constantState) {
            this.f4363IL1Iii = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4363IL1Iii.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4363IL1Iii.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            ILil iLil = new ILil();
            Drawable drawableNewDrawable = this.f4363IL1Iii.newDrawable();
            iLil.f4370ILil = drawableNewDrawable;
            drawableNewDrawable.setCallback(iLil.f1804lLi1LL);
            return iLil;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            ILil iLil = new ILil();
            Drawable drawableNewDrawable = this.f4363IL1Iii.newDrawable(resources);
            iLil.f4370ILil = drawableNewDrawable;
            drawableNewDrawable.setCallback(iLil.f1804lLi1LL);
            return iLil;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            ILil iLil = new ILil();
            Drawable drawableNewDrawable = this.f4363IL1Iii.newDrawable(resources, theme);
            iLil.f4370ILil = drawableNewDrawable;
            drawableNewDrawable.setCallback(iLil.f1804lLi1LL);
            return iLil;
        }
    }

    public ILil(Context context, C0581ILil c0581ILil, Resources resources) {
        this.f4362Ilil = null;
        IL1Iii iL1Iii = new IL1Iii();
        this.f1804lLi1LL = iL1Iii;
        this.f1803IL = context;
        if (c0581ILil != null) {
            this.f4361I1I = c0581ILil;
        } else {
            this.f4361I1I = new C0581ILil(context, c0581ILil, iL1Iii, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
