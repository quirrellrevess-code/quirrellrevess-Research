package androidx.appcompat.app;

import ILil.ILil.ILL;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    public interface IL1Iii {
        void IL1Iii(boolean z);
    }

    @Deprecated
    public static abstract class ILil {
        public abstract Drawable I1I();

        public abstract CharSequence IL1Iii();

        public abstract View ILil();

        public abstract void Ilil();

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public abstract CharSequence m2990IL();
    }

    public abstract ILil.ILil.p024llL1ii.ILil I11li1(ILil.ILil.ll丨L1ii.ILil.IL1Iii iL1Iii);

    public abstract Context ILL();

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2986ILl() {
    }

    /* JADX INFO: renamed from: I丨iL */
    public abstract boolean mo1660IiL();

    public abstract boolean Lil(int i, KeyEvent keyEvent);

    public boolean LlLI1(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m2987Ll1() {
        return false;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I */
    public abstract void mo1664L11I(boolean z);

    public abstract void iIi1(boolean z);

    public abstract void iIlLiL(CharSequence charSequence);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m2988iILLL1() {
        return false;
    }

    /* JADX INFO: renamed from: lIi丨I */
    public abstract void mo1668lIiI(Configuration configuration);

    /* JADX INFO: renamed from: lI丨lii */
    public abstract void mo1670lIlii(boolean z);

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m2989llL1ii() {
        return false;
    }

    /* JADX INFO: renamed from: 丨il */
    public abstract int mo1673il();

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f4748IL1Iii;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4748IL1Iii = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.ActionBarLayout);
            this.f4748IL1Iii = typedArrayObtainStyledAttributes.getInt(ILL.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4748IL1Iii = 0;
            this.f4748IL1Iii = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f4748IL1Iii = 0;
            this.f4748IL1Iii = layoutParams.f4748IL1Iii;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4748IL1Iii = 0;
        }
    }
}
