package com.google.android.material.resources;

import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.ILil.p023lIlii.llI;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        int color;
        int resourceId;
        ColorStateList colorStateListI1I;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListI1I = IL1Iii.I1I(context, resourceId)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i, -1)) == -1) ? typedArray.getColorStateList(i) : ColorStateList.valueOf(color);
        }
        return colorStateListI1I;
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableM1686IL;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableM1686IL = IL1Iii.m1686IL(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableM1686IL;
    }

    public static int getIndexWithValue(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static ColorStateList getColorStateList(Context context, llI lli, int i) {
        int iILil;
        int iM1822ILl;
        ColorStateList colorStateListI1I;
        if (lli.m1829lIlii(i) && (iM1822ILl = lli.m1822ILl(i, 0)) != 0 && (colorStateListI1I = IL1Iii.I1I(context, iM1822ILl)) != null) {
            return colorStateListI1I;
        }
        if (Build.VERSION.SDK_INT <= 15 && (iILil = lli.ILil(i, -1)) != -1) {
            return ColorStateList.valueOf(iILil);
        }
        return lli.I1I(i);
    }
}
