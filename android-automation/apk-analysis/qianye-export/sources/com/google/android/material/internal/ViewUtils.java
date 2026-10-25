package com.google.android.material.internal;

import ILil.p028IiL.p029ILl.C0633lIII;
import ILil.p028IiL.p029ILl.LlLI1;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        C0633lIII onApplyWindowInsets(View view, C0633lIII c0633lIII, RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static void doOnApplyWindowInsets(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(iIlLiL.m2135LLlI1(view), view.getPaddingTop(), iIlLiL.m2100L111(view), view.getPaddingBottom());
        iIlLiL.m2111iI1LI(view, new LlLI1() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // ILil.p028IiL.p029ILl.LlLI1
            public C0633lIII onApplyWindowInsets(View view2, C0633lIII c0633lIII) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, c0633lIII, new RelativePadding(relativePadding));
            }
        });
        requestApplyInsetsWhenAttached(view);
    }

    public static float dpToPx(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static float getParentAbsoluteElevation(View view) {
        float fIIlLiL = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fIIlLiL += iIlLiL.iIlLiL((View) parent);
        }
        return fIIlLiL;
    }

    public static boolean isLayoutRtl(View view) {
        return iIlLiL.m2134l(view) == 1;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
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

    public static void requestApplyInsetsWhenAttached(View view) {
        if (iIlLiL.m2099L11(view)) {
            iIlLiL.m70I1(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    iIlLiL.m70I1(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static void requestFocusAndShowKeyboard(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public void applyToView(View view) {
            iIlLiL.m771(view, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }
}
