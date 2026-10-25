package androidx.appcompat.view.menu;

import ILil.ILil.IL1Iii;
import ILil.ILil.ILL;
import ILil.ILil.IiL;
import ILil.ILil.iILLL1;
import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.Lil;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements Lil.IL1Iii, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ImageView f4812I1I;
    public Drawable ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public C0629il f4813ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2321ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public TextView f4814Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public RadioButton f2322IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public ImageView f2323IiL;
    public Drawable Lil;
    public boolean LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2324Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ImageView f2325L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public TextView f2326iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public Context f2327lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f2328lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public LayoutInflater f2329llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public CheckBox f2330lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public LinearLayout f2331il;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, IL1Iii.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f2329llL1ii == null) {
            this.f2329llL1ii = LayoutInflater.from(getContext());
        }
        return this.f2329llL1ii;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f2323IiL;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final void I1I() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(IiL.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f2330lLi1LL = checkBox;
        IL1Iii(checkBox);
    }

    public final void IL1Iii(View view) {
        ILil(view, -1);
    }

    public final void ILil(View view, int i) {
        LinearLayout linearLayout = this.f2331il;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public final void Ilil() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(IiL.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f2322IL = radioButton;
        IL1Iii(radioButton);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m3045IL() {
        ImageView imageView = (ImageView) getInflater().inflate(IiL.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f4812I1I = imageView;
        ILil(imageView, 0);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2325L11I;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2325L11I.getLayoutParams();
        rect.top += this.f2325L11I.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public C0629il getItemData() {
        return this.f4813ILil;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public void initialize(C0629il c0629il, int i) {
        this.f4813ILil = c0629il;
        setVisibility(c0629il.isVisible() ? 0 : 8);
        setTitle(c0629il.m1903L11I(this));
        setCheckable(c0629il.isCheckable());
        m3046lLi1LL(c0629il.m1904LlLLL(), c0629il.m1905iILLL1());
        setIcon(c0629il.getIcon());
        setEnabled(c0629il.isEnabled());
        setSubMenuArrowVisible(c0629il.hasSubMenu());
        setContentDescription(c0629il.getContentDescription());
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m3046lLi1LL(boolean z, char c) {
        int i = (z && this.f4813ILil.m1904LlLLL()) ? 0 : 8;
        if (i == 0) {
            this.f2326iILLL1.setText(this.f4813ILil.m1901IiL());
        }
        if (this.f2326iILLL1.getVisibility() != i) {
            this.f2326iILLL1.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        iIlLiL.ill1LI1l(this, this.ILL);
        TextView textView = (TextView) findViewById(iILLL1.title);
        this.f4814Ilil = textView;
        int i = this.f2324Ll1;
        if (i != -1) {
            textView.setTextAppearance(this.f2327lIiI, i);
        }
        this.f2326iILLL1 = (TextView) findViewById(iILLL1.shortcut);
        ImageView imageView = (ImageView) findViewById(iILLL1.submenuarrow);
        this.f2323IiL = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.Lil);
        }
        this.f2325L11I = (ImageView) findViewById(iILLL1.group_divider);
        this.f2331il = (LinearLayout) findViewById(iILLL1.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f4812I1I != null && this.f2321ILl) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f4812I1I.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f2322IL == null && this.f2330lLi1LL == null) {
            return;
        }
        if (this.f4813ILil.m1906lIiI()) {
            if (this.f2322IL == null) {
                Ilil();
            }
            compoundButton = this.f2322IL;
            compoundButton2 = this.f2330lLi1LL;
        } else {
            if (this.f2330lLi1LL == null) {
                I1I();
            }
            compoundButton = this.f2330lLi1LL;
            compoundButton2 = this.f2322IL;
        }
        if (z) {
            compoundButton.setChecked(this.f4813ILil.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f2330lLi1LL;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f2322IL;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f4813ILil.m1906lIiI()) {
            if (this.f2322IL == null) {
                Ilil();
            }
            compoundButton = this.f2322IL;
        } else {
            if (this.f2330lLi1LL == null) {
                I1I();
            }
            compoundButton = this.f2330lLi1LL;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f2328lIlii = z;
        this.f2321ILl = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f2325L11I;
        if (imageView != null) {
            imageView.setVisibility((this.LlLI1 || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f4813ILil.m19141() || this.f2328lIlii;
        if (z || this.f2321ILl) {
            ImageView imageView = this.f4812I1I;
            if (imageView == null && drawable == null && !this.f2321ILl) {
                return;
            }
            if (imageView == null) {
                m3045IL();
            }
            if (drawable == null && !this.f2321ILl) {
                this.f4812I1I.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f4812I1I;
            if (!z) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f4812I1I.getVisibility() != 0) {
                this.f4812I1I.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f4814Ilil.getVisibility() != 8) {
                this.f4814Ilil.setVisibility(8);
            }
        } else {
            this.f4814Ilil.setText(charSequence);
            if (this.f4814Ilil.getVisibility() != 0) {
                this.f4814Ilil.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        llI lliI11li1 = llI.I11li1(getContext(), attributeSet, ILL.MenuView, i, 0);
        this.ILL = lliI11li1.m1827iILLL1(ILL.MenuView_android_itemBackground);
        this.f2324Ll1 = lliI11li1.m1822ILl(ILL.MenuView_android_itemTextAppearance, -1);
        this.f2321ILl = lliI11li1.IL1Iii(ILL.MenuView_preserveIconSpacing, false);
        this.f2327lIiI = context;
        this.Lil = lliI11li1.m1827iILLL1(ILL.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, IL1Iii.dropDownListViewStyle, 0);
        this.LlLI1 = typedArrayObtainStyledAttributes.hasValue(0);
        lliI11li1.m1833lL();
        typedArrayObtainStyledAttributes.recycle();
    }
}
