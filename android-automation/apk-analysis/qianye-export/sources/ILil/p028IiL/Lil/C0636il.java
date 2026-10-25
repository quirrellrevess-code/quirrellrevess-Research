package ILil.p028IiL.Lil;

import ILil.p028IiL.p031Ll1.I1I;
import ILil.p028IiL.p034lIiI.L11I;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ILil.I丨iL.Lil.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: TextViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0636il {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static Field f4133I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static Field f4134IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static boolean f4135ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static boolean f1694IL;

    /* JADX INFO: renamed from: ILil.I丨iL.Lil.丨il$IL1Iii */
    /* JADX INFO: compiled from: TextViewCompat.java */
    public static class IL1Iii implements ActionMode.Callback {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public Class f4136I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final ActionMode.Callback f4137IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final TextView f4138ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f4139Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public Method f1695IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f1696lLi1LL = false;

        public IL1Iii(ActionMode.Callback callback, TextView textView) {
            this.f4137IL1Iii = callback;
            this.f4138ILil = textView;
        }

        public final List<ResolveInfo> I1I(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(IL1Iii(), 0)) {
                if (Ilil(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        public final Intent IL1Iii() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final Intent ILil(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = IL1Iii().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !m2231IL(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        public final boolean Ilil(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final boolean m2231IL(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final void m2232lLi1LL(Menu menu) {
            Context context = this.f4138ILil.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f1696lLi1LL) {
                this.f1696lLi1LL = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f4136I1I = cls;
                    this.f1695IL = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f4139Ilil = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f4136I1I = null;
                    this.f1695IL = null;
                    this.f4139Ilil = false;
                }
            }
            try {
                Method declaredMethod = (this.f4139Ilil && this.f4136I1I.isInstance(menu)) ? this.f1695IL : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listI1I = I1I(context, packageManager);
                for (int i = 0; i < listI1I.size(); i++) {
                    ResolveInfo resolveInfo = listI1I.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(ILil(resolveInfo, this.f4138ILil)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f4137IL1Iii.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f4137IL1Iii.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f4137IL1Iii.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            m2232lLi1LL(menu);
            return this.f4137IL1Iii.onPrepareActionMode(actionMode, menu);
        }
    }

    public static int I1I(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static Drawable[] IL1Iii(TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z = textView.getLayoutDirection() == 1;
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void ILL(TextView textView, PorterDuff.Mode mode) {
        L11I.m2295IL(textView);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof Ll1) {
            ((Ll1) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static int ILil(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public static void m2220ILl(TextView textView, int i) {
        L11I.I1I(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static int Ilil(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m2221IL(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f1694IL) {
            f4133I1I = m2222IiL("mMaxMode");
            f1694IL = true;
        }
        Field field = f4133I1I;
        if (field == null || m2224L11I(field, textView) != 1) {
            return -1;
        }
        if (!f4135ILil) {
            f4134IL1Iii = m2222IiL("mMaximum");
            f4135ILil = true;
        }
        Field field2 = f4134IL1Iii;
        if (field2 != null) {
            return m2224L11I(field2, textView);
        }
        return -1;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static Field m2222IiL(String str) {
        Field declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Log.e("TextViewCompat", "Could not retrieve " + str + " field.");
            return declaredField;
        }
    }

    public static void Lil(TextView textView, int i) {
        L11I.I1I(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    public static void LlLI1(TextView textView, I1I i1i) {
        if (!m2225iILLL1(textView).IL1Iii(i1i.IL1Iii())) {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
        textView.setText(i1i);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static void m2223Ll1(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        if (i < 17) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        boolean z = textView.getLayoutDirection() == 1;
        Drawable drawable5 = z ? drawable3 : drawable;
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static int m2224L11I(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    public static ActionMode.Callback iIi1(TextView textView, ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof IL1Iii)) ? callback : new IL1Iii(callback, textView);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static I1I.IL1Iii m2225iILLL1(TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new I1I.IL1Iii(textView.getTextMetricsParams());
        }
        I1I.IL1Iii.C0569IL1Iii c0569IL1Iii = new I1I.IL1Iii.C0569IL1Iii(new TextPaint(textView.getPaint()));
        if (i >= 23) {
            c0569IL1Iii.ILil(textView.getBreakStrategy());
            c0569IL1Iii.I1I(textView.getHyphenationFrequency());
        }
        if (i >= 18) {
            c0569IL1Iii.m2234IL(m2229lLi1LL(textView));
        }
        return c0569IL1Iii.IL1Iii();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static void m2226lIiI(TextView textView, int i) {
        L11I.I1I(i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = (i2 < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i - (-i3), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public static void m2227lIlii(TextView textView, I1I.IL1Iii iL1Iii) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            textView.setTextDirection(Ilil(iL1Iii.m2233IL()));
        }
        if (i >= 23) {
            textView.getPaint().set(iL1Iii.Ilil());
            textView.setBreakStrategy(iL1Iii.ILil());
            textView.setHyphenationFrequency(iL1Iii.I1I());
        } else {
            float textScaleX = iL1Iii.Ilil().getTextScaleX();
            textView.getPaint().set(iL1Iii.Ilil());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public static void m2228llL1ii(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static TextDirectionHeuristic m2229lLi1LL(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static void m2230il(TextView textView, ColorStateList colorStateList) {
        L11I.m2295IL(textView);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof Ll1) {
            ((Ll1) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }
}
