package com.google.android.material.internal;

import ILil.ILil.p023lIlii.L1l;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.Lil;
import ILil.p028IiL.Lil.C0636il;
import ILil.p028IiL.p029ILl.IL1Iii;
import ILil.p028IiL.p029ILl.LL1IL.I1I;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p035lLi1LL.I1I.iILLL1;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.C0016R;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements Lil.IL1Iii {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private final IL1Iii accessibilityDelegate;
    private FrameLayout actionArea;
    public boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private C0629il itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                this.actionArea.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        FrameLayout frameLayout2 = this.actionArea;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            this.actionArea.setLayoutParams(layoutParams2);
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(ILil.ILil.IL1Iii.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(C0016R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view);
        }
    }

    private boolean shouldExpandActionArea() {
        return this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public C0629il getItemData() {
        return this.itemData;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public void initialize(C0629il c0629il, int i) {
        this.itemData = c0629il;
        setVisibility(c0629il.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            iIlLiL.ill1LI1l(this, createDefaultBackground());
        }
        setCheckable(c0629il.isCheckable());
        setChecked(c0629il.isChecked());
        setEnabled(c0629il.isEnabled());
        setTitle(c0629il.getTitle());
        setIcon(c0629il.getIcon());
        setActionView(c0629il.getActionView());
        setContentDescription(c0629il.getContentDescription());
        L1l.IL1Iii(this, c0629il.getTooltipText());
        adjustAppearance();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        C0629il c0629il = this.itemData;
        if (c0629il != null && c0629il.isCheckable() && this.itemData.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // ILil.ILil.ll丨L1ii.ILL.Lil.IL1Iii
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.actionArea;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.checkable != z) {
            this.checkable = z;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.textView.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = ILil.p028IiL.p033iILLL1.ILL.IL1Iii.m2256lIlii(drawable).mutate();
                ILil.p028IiL.p033iILLL1.ILL.IL1Iii.Lil(drawable, this.iconTintList);
            }
            int i = this.iconSize;
            drawable.setBounds(0, 0, i, i);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                Drawable drawableIL1Iii = iILLL1.IL1Iii(getResources(), C0016R.drawable.navigation_empty_icon, getContext().getTheme());
                this.emptyDrawable = drawableIL1Iii;
                if (drawableIL1Iii != null) {
                    int i2 = this.iconSize;
                    drawableIL1Iii.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.emptyDrawable;
        }
        C0636il.m2223Ll1(this.textView, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.textView.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.iconSize = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.hasIconTintList = colorStateList != null;
        C0629il c0629il = this.itemData;
        if (c0629il != null) {
            setIcon(c0629il.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.textView.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.needsEmptyIcon = z;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i) {
        C0636il.m2228llL1ii(this.textView, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IL1Iii iL1Iii = new IL1Iii() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // ILil.p028IiL.p029ILl.IL1Iii
            public void onInitializeAccessibilityNodeInfo(View view, I1I i1i) {
                super.onInitializeAccessibilityNodeInfo(view, i1i);
                i1i.m64i1(NavigationMenuItemView.this.checkable);
            }
        };
        this.accessibilityDelegate = iL1Iii;
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0016R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(C0016R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(C0016R.id.design_menu_item_text);
        this.textView = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        iIlLiL.m75lL(checkedTextView, iL1Iii);
    }
}
