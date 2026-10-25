package ILil.ILil.p023lIlii;

import ILil.ILil.I1I;
import ILil.ILil.lLi1LL;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class iILLL1 {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static iILLL1 f3790I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final PorterDuff.Mode f3791ILil = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public I11L f3792IL1Iii;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.iI丨LLL1$IL1Iii */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    public static class IL1Iii implements I11L.lLi1LL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int[] f3794IL1Iii = {lLi1LL.abc_textfield_search_default_mtrl_alpha, lLi1LL.abc_textfield_default_mtrl_alpha, lLi1LL.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int[] f3795ILil = {lLi1LL.abc_ic_commit_search_api_mtrl_alpha, lLi1LL.abc_seekbar_tick_mark_material, lLi1LL.abc_ic_menu_share_mtrl_alpha, lLi1LL.abc_ic_menu_copy_mtrl_am_alpha, lLi1LL.abc_ic_menu_cut_mtrl_alpha, lLi1LL.abc_ic_menu_selectall_mtrl_alpha, lLi1LL.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int[] f3793I1I = {lLi1LL.abc_textfield_activated_mtrl_alpha, lLi1LL.abc_textfield_search_activated_mtrl_alpha, lLi1LL.abc_cab_background_top_mtrl_alpha, lLi1LL.abc_text_cursor_material, lLi1LL.abc_text_select_handle_left_mtrl_dark, lLi1LL.abc_text_select_handle_middle_mtrl_dark, lLi1LL.abc_text_select_handle_right_mtrl_dark, lLi1LL.abc_text_select_handle_left_mtrl_light, lLi1LL.abc_text_select_handle_middle_mtrl_light, lLi1LL.abc_text_select_handle_right_mtrl_light};

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final int[] f1381IL = {lLi1LL.abc_popup_background_mtrl_mult, lLi1LL.abc_cab_background_internal_bg, lLi1LL.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final int[] f3796Ilil = {lLi1LL.abc_tab_indicator_material, lLi1LL.abc_textfield_search_material};

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final int[] f1382lLi1LL = {lLi1LL.abc_btn_check_material, lLi1LL.abc_btn_radio_material, lLi1LL.abc_btn_check_material_anim, lLi1LL.abc_btn_radio_material_anim};

        @Override // ILil.ILil.p023lIlii.I11L.lLi1LL
        public Drawable I1I(I11L i11l, Context context, int i) {
            if (i == lLi1LL.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{i11l.m1699il(context, lLi1LL.abc_cab_background_internal_bg), i11l.m1699il(context, lLi1LL.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0046  */
        /* JADX WARN: Code duplicated, block: B:23:0x004c  */
        /* JADX WARN: Code duplicated, block: B:26:0x005d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0061 A[RETURN] */
        @Override // ILil.ILil.p023lIlii.I11L.lLi1LL
        public boolean IL1Iii(Context context, int i, Drawable drawable) {
            int iRound;
            boolean z;
            PorterDuff.Mode mode = iILLL1.f3791ILil;
            boolean zM1789lLi1LL = m1789lLi1LL(this.f3794IL1Iii, i);
            int i2 = R.attr.colorBackground;
            if (zM1789lLi1LL) {
                i2 = ILil.ILil.IL1Iii.colorControlNormal;
            } else if (m1789lLi1LL(this.f3793I1I, i)) {
                i2 = ILil.ILil.IL1Iii.colorControlActivated;
            } else {
                if (!m1789lLi1LL(this.f1381IL, i)) {
                    if (i == lLi1LL.abc_list_divider_mtrl_alpha) {
                        i2 = R.attr.colorForeground;
                        iRound = Math.round(40.8f);
                        z = true;
                    } else if (i != lLi1LL.abc_dialog_material_background) {
                        iRound = -1;
                        z = false;
                        i2 = 0;
                    }
                    if (z) {
                        return false;
                    }
                    if (llL1ii.IL1Iii(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(iILLL1.Ilil(C0625lIII.ILil(context, i2), mode));
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
                mode = PorterDuff.Mode.MULTIPLY;
            }
            iRound = -1;
            z = true;
            if (z) {
                return false;
            }
            if (llL1ii.IL1Iii(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(iILLL1.Ilil(C0625lIII.ILil(context, i2), mode));
            if (iRound != -1) {
                drawable.setAlpha(iRound);
            }
            return true;
        }

        public final ColorStateList ILL(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i = ILil.ILil.IL1Iii.colorSwitchThumbNormal;
            ColorStateList colorStateListM1815IL = C0625lIII.m1815IL(context, i);
            if (colorStateListM1815IL == null || !colorStateListM1815IL.isStateful()) {
                iArr[0] = C0625lIII.f3818ILil;
                iArr2[0] = C0625lIII.IL1Iii(context, i);
                iArr[1] = C0625lIII.f3819Ilil;
                iArr2[1] = C0625lIII.ILil(context, ILil.ILil.IL1Iii.colorControlActivated);
                iArr[2] = C0625lIII.f1403lLi1LL;
                iArr2[2] = C0625lIII.ILil(context, i);
            } else {
                iArr[0] = C0625lIII.f3818ILil;
                iArr2[0] = colorStateListM1815IL.getColorForState(iArr[0], 0);
                iArr[1] = C0625lIII.f3819Ilil;
                iArr2[1] = C0625lIII.ILil(context, ILil.ILil.IL1Iii.colorControlActivated);
                iArr[2] = C0625lIII.f1403lLi1LL;
                iArr2[2] = colorStateListM1815IL.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        @Override // ILil.ILil.p023lIlii.I11L.lLi1LL
        public PorterDuff.Mode ILil(int i) {
            if (i == lLi1LL.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // ILil.ILil.p023lIlii.I11L.lLi1LL
        public boolean Ilil(Context context, int i, Drawable drawable) {
            if (i == lLi1LL.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i2 = ILil.ILil.IL1Iii.colorControlNormal;
                m1786Ll1(drawableFindDrawableByLayerId, C0625lIII.ILil(context, i2), iILLL1.f3791ILil);
                m1786Ll1(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), C0625lIII.ILil(context, i2), iILLL1.f3791ILil);
                m1786Ll1(layerDrawable.findDrawableByLayerId(R.id.progress), C0625lIII.ILil(context, ILil.ILil.IL1Iii.colorControlActivated), iILLL1.f3791ILil);
                return true;
            }
            if (i != lLi1LL.abc_ratingbar_material && i != lLi1LL.abc_ratingbar_indicator_material && i != lLi1LL.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m1786Ll1(layerDrawable2.findDrawableByLayerId(R.id.background), C0625lIII.IL1Iii(context, ILil.ILil.IL1Iii.colorControlNormal), iILLL1.f3791ILil);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i3 = ILil.ILil.IL1Iii.colorControlActivated;
            m1786Ll1(drawableFindDrawableByLayerId2, C0625lIII.ILil(context, i3), iILLL1.f3791ILil);
            m1786Ll1(layerDrawable2.findDrawableByLayerId(R.id.progress), C0625lIII.ILil(context, i3), iILLL1.f3791ILil);
            return true;
        }

        @Override // ILil.ILil.p023lIlii.I11L.lLi1LL
        /* JADX INFO: renamed from: I丨L */
        public ColorStateList mo1704IL(Context context, int i) {
            if (i == lLi1LL.abc_edit_text_material) {
                return ILil.ILil.p022lIiI.IL1Iii.IL1Iii.I1I(context, I1I.abc_tint_edittext);
            }
            if (i == lLi1LL.abc_switch_track_mtrl_alpha) {
                return ILil.ILil.p022lIiI.IL1Iii.IL1Iii.I1I(context, I1I.abc_tint_switch_track);
            }
            if (i == lLi1LL.abc_switch_thumb_material) {
                return ILL(context);
            }
            if (i == lLi1LL.abc_btn_default_mtrl_shape) {
                return m1790il(context);
            }
            if (i == lLi1LL.abc_btn_borderless_material) {
                return m1788iILLL1(context);
            }
            if (i == lLi1LL.abc_btn_colored_material) {
                return m1787L11I(context);
            }
            if (i == lLi1LL.abc_spinner_mtrl_am_alpha || i == lLi1LL.abc_spinner_textfield_background_material) {
                return ILil.ILil.p022lIiI.IL1Iii.IL1Iii.I1I(context, I1I.abc_tint_spinner);
            }
            if (m1789lLi1LL(this.f3795ILil, i)) {
                return C0625lIII.m1815IL(context, ILil.ILil.IL1Iii.colorControlNormal);
            }
            if (m1789lLi1LL(this.f3796Ilil, i)) {
                return ILil.ILil.p022lIiI.IL1Iii.IL1Iii.I1I(context, I1I.abc_tint_default);
            }
            if (m1789lLi1LL(this.f1382lLi1LL, i)) {
                return ILil.ILil.p022lIiI.IL1Iii.IL1Iii.I1I(context, I1I.abc_tint_btn_checkable);
            }
            if (i == lLi1LL.abc_seekbar_thumb_material) {
                return ILil.ILil.p022lIiI.IL1Iii.IL1Iii.I1I(context, I1I.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final ColorStateList m1785IiL(Context context, int i) {
            int iILil = C0625lIII.ILil(context, ILil.ILil.IL1Iii.colorControlHighlight);
            return new ColorStateList(new int[][]{C0625lIII.f3818ILil, C0625lIII.f1401IL, C0625lIII.f3816I1I, C0625lIII.f1403lLi1LL}, new int[]{C0625lIII.IL1Iii(context, ILil.ILil.IL1Iii.colorButtonNormal), ILil.p028IiL.p033iILLL1.IL1Iii.ILil(iILil, i), ILil.p028IiL.p033iILLL1.IL1Iii.ILil(iILil, i), i});
        }

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public final void m1786Ll1(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (llL1ii.IL1Iii(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = iILLL1.f3791ILil;
            }
            drawable.setColorFilter(iILLL1.Ilil(i, mode));
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final ColorStateList m1787L11I(Context context) {
            return m1785IiL(context, C0625lIII.ILil(context, ILil.ILil.IL1Iii.colorAccent));
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public final ColorStateList m1788iILLL1(Context context) {
            return m1785IiL(context, 0);
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final boolean m1789lLi1LL(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public final ColorStateList m1790il(Context context) {
            return m1785IiL(context, C0625lIII.ILil(context, ILil.ILil.IL1Iii.colorButtonNormal));
        }
    }

    public static synchronized iILLL1 ILil() {
        if (f3790I1I == null) {
            m1780IiL();
        }
        return f3790I1I;
    }

    public static synchronized PorterDuffColorFilter Ilil(int i, PorterDuff.Mode mode) {
        return I11L.m1690Ll1(i, mode);
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static synchronized void m1780IiL() {
        if (f3790I1I == null) {
            iILLL1 iilll1 = new iILLL1();
            f3790I1I = iilll1;
            iilll1.f3792IL1Iii = I11L.m1689IiL();
            f3790I1I.f3792IL1Iii.I11li1(new IL1Iii());
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static void m1781L11I(Drawable drawable, C0627LLlI1 c0627LLlI1, int[] iArr) {
        I11L.I11L(drawable, c0627LLlI1, iArr);
    }

    public synchronized Drawable I1I(Context context, int i) {
        return this.f3792IL1Iii.m1699il(context, i);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public synchronized Drawable m1782IL(Context context, int i, boolean z) {
        return this.f3792IL1Iii.ILL(context, i, z);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public synchronized void m1783iILLL1(Context context) {
        this.f3792IL1Iii.iIi1(context);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public synchronized ColorStateList m1784lLi1LL(Context context, int i) {
        return this.f3792IL1Iii.m1696lIiI(context, i);
    }
}
