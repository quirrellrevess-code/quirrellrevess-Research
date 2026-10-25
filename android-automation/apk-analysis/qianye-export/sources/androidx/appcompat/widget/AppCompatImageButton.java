package androidx.appcompat.widget;

import ILil.ILil.IL1Iii;
import ILil.ILil.p023lIlii.IL;
import ILil.ILil.p023lIlii.L111;
import ILil.ILil.p023lIlii.L11I;
import ILil.p028IiL.Lil.lIiI;
import ILil.p028IiL.p029ILl.iIi1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements iIi1, lIiI {
    private final IL mBackgroundTintHelper;
    private final L11I mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.ILil();
        }
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            l11i.ILil();
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public ColorStateList getSupportBackgroundTintList() {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            return il.I1I();
        }
        return null;
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            return il.m1734IL();
        }
        return null;
    }

    @Override // ILil.p028IiL.Lil.lIiI
    public ColorStateList getSupportImageTintList() {
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            return l11i.I1I();
        }
        return null;
    }

    @Override // ILil.p028IiL.Lil.lIiI
    public PorterDuff.Mode getSupportImageTintMode() {
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            return l11i.m1756IL();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.Ilil() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1738lLi1LL(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1737iILLL1(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            l11i.ILil();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            l11i.ILil();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mImageHelper.m1759iILLL1(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            l11i.ILil();
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1736L11I(colorStateList);
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1739il(mode);
        }
    }

    @Override // ILil.p028IiL.Lil.lIiI
    public void setSupportImageTintList(ColorStateList colorStateList) {
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            l11i.m1757IiL(colorStateList);
        }
    }

    @Override // ILil.p028IiL.Lil.lIiI
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        L11I l11i = this.mImageHelper;
        if (l11i != null) {
            l11i.m1758L11I(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, IL1Iii.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(L111.ILil(context), attributeSet, i);
        IL il = new IL(this);
        this.mBackgroundTintHelper = il;
        il.Ilil(attributeSet, i);
        L11I l11i = new L11I(this);
        this.mImageHelper = l11i;
        l11i.m1760lLi1LL(attributeSet, i);
    }
}
