package com.google.android.material.navigation;

import ILil.ILil.p022lIiI.IL1Iii.IL1Iii;
import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.IiL;
import ILil.p028IiL.p029ILl.C0633lIII;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.C0016R;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    public OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListI1I = IL1Iii.I1I(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(ILil.ILil.IL1Iii.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListI1I.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListI1I.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    private final Drawable createDefaultItemBackground(llI lli) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), lli.m1822ILl(C0016R.styleable.NavigationView_itemShapeAppearance, 0), lli.m1822ILl(C0016R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), lli, C0016R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) materialShapeDrawable, lli.m1831lLi1LL(C0016R.styleable.NavigationView_itemShapeInsetStart, 0), lli.m1831lLi1LL(C0016R.styleable.NavigationView_itemShapeInsetTop, 0), lli.m1831lLi1LL(C0016R.styleable.NavigationView_itemShapeInsetEnd, 0), lli.m1831lLi1LL(C0016R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new IiL(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(llI lli) {
        return lli.m1829lIlii(C0016R.styleable.NavigationView_itemShapeAppearance) || lli.m1829lIlii(C0016R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z = NavigationView.this.tmpLocation[1] == 0;
                NavigationView.this.presenter.setBehindStatusBar(z);
                NavigationView.this.setDrawTopInsetForeground(z);
                Context context = NavigationView.this.getContext();
                if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                Activity activity = (Activity) context;
                NavigationView.this.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i) {
        return this.presenter.getHeaderView(i);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int i) {
        return this.presenter.inflateHeaderView(i);
    }

    public void inflateMenu(int i) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void onInsetsChanged(C0633lIII c0633lIII) {
        this.presenter.dispatchApplyWindowInsets(c0633lIII);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.menu.findItem(i);
        if (menuItemFindItem != null) {
            this.presenter.setCheckedItem((C0629il) menuItemFindItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f);
        }
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        this.presenter.setItemHorizontalPadding(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        this.presenter.setItemIconPadding(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(int i) {
        this.presenter.setItemIconSize(i);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i) {
        this.presenter.setItemMaxLines(i);
    }

    public void setItemTextAppearance(int i) {
        this.presenter.setItemTextAppearance(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0016R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListCreateDefaultColorStateList;
        int iM1822ILl;
        boolean z;
        super(context, attributeSet, i);
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.presenter = navigationMenuPresenter;
        this.tmpLocation = new int[2];
        NavigationMenu navigationMenu = new NavigationMenu(context);
        this.menu = navigationMenu;
        llI lliObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context, attributeSet, C0016R.styleable.NavigationView, i, C0016R.style.Widget_Design_NavigationView, new int[0]);
        int i2 = C0016R.styleable.NavigationView_android_background;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i2)) {
            iIlLiL.ill1LI1l(this, lliObtainTintedStyledAttributes.m1827iILLL1(i2));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context);
            iIlLiL.ill1LI1l(this, materialShapeDrawable);
        }
        int i3 = C0016R.styleable.NavigationView_elevation;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i3)) {
            setElevation(lliObtainTintedStyledAttributes.m1831lLi1LL(i3, 0));
        }
        setFitsSystemWindows(lliObtainTintedStyledAttributes.IL1Iii(C0016R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = lliObtainTintedStyledAttributes.m1831lLi1LL(C0016R.styleable.NavigationView_android_maxWidth, 0);
        int i4 = C0016R.styleable.NavigationView_itemIconTint;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i4)) {
            colorStateListCreateDefaultColorStateList = lliObtainTintedStyledAttributes.I1I(i4);
        } else {
            colorStateListCreateDefaultColorStateList = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        int i5 = C0016R.styleable.NavigationView_itemTextAppearance;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i5)) {
            iM1822ILl = lliObtainTintedStyledAttributes.m1822ILl(i5, 0);
            z = true;
        } else {
            iM1822ILl = 0;
            z = false;
        }
        int i6 = C0016R.styleable.NavigationView_itemIconSize;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i6)) {
            setItemIconSize(lliObtainTintedStyledAttributes.m1831lLi1LL(i6, 0));
        }
        int i7 = C0016R.styleable.NavigationView_itemTextColor;
        ColorStateList colorStateListI1I = lliObtainTintedStyledAttributes.m1829lIlii(i7) ? lliObtainTintedStyledAttributes.I1I(i7) : null;
        if (!z && colorStateListI1I == null) {
            colorStateListI1I = createDefaultColorStateList(R.attr.textColorPrimary);
        }
        Drawable drawableM1827iILLL1 = lliObtainTintedStyledAttributes.m1827iILLL1(C0016R.styleable.NavigationView_itemBackground);
        if (drawableM1827iILLL1 == null && hasShapeAppearance(lliObtainTintedStyledAttributes)) {
            drawableM1827iILLL1 = createDefaultItemBackground(lliObtainTintedStyledAttributes);
        }
        int i8 = C0016R.styleable.NavigationView_itemHorizontalPadding;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i8)) {
            navigationMenuPresenter.setItemHorizontalPadding(lliObtainTintedStyledAttributes.m1831lLi1LL(i8, 0));
        }
        int iM1831lLi1LL = lliObtainTintedStyledAttributes.m1831lLi1LL(C0016R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(lliObtainTintedStyledAttributes.ILL(C0016R.styleable.NavigationView_itemMaxLines, 1));
        navigationMenu.setCallback(new ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
            public boolean onMenuItemSelected(ILil.ILil.p024llL1ii.ILL.IiL iiL, MenuItem menuItem) {
                OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.listener;
                return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.onNavigationItemSelected(menuItem);
            }

            @Override // ILil.ILil.p024llL1ii.ILL.IiL.IL1Iii
            public void onMenuModeChange(ILil.ILil.p024llL1ii.ILL.IiL iiL) {
            }
        });
        navigationMenuPresenter.setId(1);
        navigationMenuPresenter.initForMenu(context, navigationMenu);
        navigationMenuPresenter.setItemIconTintList(colorStateListCreateDefaultColorStateList);
        navigationMenuPresenter.setOverScrollMode(getOverScrollMode());
        if (z) {
            navigationMenuPresenter.setItemTextAppearance(iM1822ILl);
        }
        navigationMenuPresenter.setItemTextColor(colorStateListI1I);
        navigationMenuPresenter.setItemBackground(drawableM1827iILLL1);
        navigationMenuPresenter.setItemIconPadding(iM1831lLi1LL);
        navigationMenu.addMenuPresenter(navigationMenuPresenter);
        addView((View) navigationMenuPresenter.getMenuView(this));
        int i9 = C0016R.styleable.NavigationView_menu;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i9)) {
            inflateMenu(lliObtainTintedStyledAttributes.m1822ILl(i9, 0));
        }
        int i10 = C0016R.styleable.NavigationView_headerLayout;
        if (lliObtainTintedStyledAttributes.m1829lIlii(i10)) {
            inflateHeaderView(lliObtainTintedStyledAttributes.m1822ILl(i10, 0));
        }
        lliObtainTintedStyledAttributes.m1833lL();
        setupInsetScrimsListener();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.menu.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.presenter.setCheckedItem((C0629il) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
