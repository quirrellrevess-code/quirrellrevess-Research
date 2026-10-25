package androidx.appcompat.widget;

import ILil.ILil.ILL;
import ILil.ILil.IiL;
import ILil.ILil.p023lIlii.C0624ill;
import ILil.ILil.p023lIlii.LL1IL;
import ILil.ILil.p023lIlii.iIlLiL;
import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.llL1ii;
import ILil.p028IiL.p029ILl.iIi1;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements iIi1 {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {R.attr.spinnerMode};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final ILil.ILil.p023lIlii.IL mBackgroundTintHelper;
    public int mDropDownWidth;
    private iIlLiL mForwardingListener;
    private iILLL1 mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    public final Rect mTempRect;

    public class I1I implements iILLL1, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ListAdapter f4859I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ILil.ILil.p021Ll1.IL1Iii f4860ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public CharSequence f2402IL;

        public I1I() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public boolean IL1Iii() {
            ILil.ILil.p021Ll1.IL1Iii iL1Iii = this.f4860ILil;
            if (iL1Iii != null) {
                return iL1Iii.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public void ILL(int i) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public int ILil() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public void mo3083ILl(ListAdapter listAdapter) {
            this.f4859I1I = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public CharSequence Ilil() {
            return this.f2402IL;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public void mo3084IL(int i) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public void mo3085Ll1(int i, int i2) {
            if (this.f4859I1I == null) {
                return;
            }
            ILil.ILil.p021Ll1.IL1Iii.C0552IL1Iii c0552IL1Iii = new ILil.ILil.p021Ll1.IL1Iii.C0552IL1Iii(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f2402IL;
            if (charSequence != null) {
                c0552IL1Iii.setTitle(charSequence);
            }
            ILil.ILil.p021Ll1.IL1Iii iL1IiiCreate = c0552IL1Iii.setSingleChoiceItems(this.f4859I1I, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.f4860ILil = iL1IiiCreate;
            ListView listViewIL1Iii = iL1IiiCreate.IL1Iii();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewIL1Iii.setTextDirection(i);
                listViewIL1Iii.setTextAlignment(i2);
            }
            this.f4860ILil.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public void mo3086L11I(CharSequence charSequence) {
            this.f2402IL = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public void dismiss() {
            ILil.ILil.p021Ll1.IL1Iii iL1Iii = this.f4860ILil;
            if (iL1Iii != null) {
                iL1Iii.dismiss();
                this.f4860ILil = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public Drawable mo3087iILLL1() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public int mo3088lIiI() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.f4859I1I.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public void setBackgroundDrawable(Drawable drawable) {
            Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public void mo3089il(int i) {
            Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    public class IL1Iii extends iIlLiL {
        public final /* synthetic */ lLi1LL ILL;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IL1Iii(View view, lLi1LL lli1ll) {
            super(view);
            this.ILL = lli1ll;
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        @SuppressLint({"SyntheticAccessor"})
        public boolean I1I() {
            if (AppCompatSpinner.this.getInternalPopup().IL1Iii()) {
                return true;
            }
            AppCompatSpinner.this.showPopup();
            return true;
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        public llL1ii ILil() {
            return this.ILL;
        }
    }

    public class ILil implements ViewTreeObserver.OnGlobalLayoutListener {
        public ILil() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().IL1Iii()) {
                AppCompatSpinner.this.showPopup();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$I丨L, reason: invalid class name */
    public static class IL implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public ListAdapter f4863I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public SpinnerAdapter f4864ILil;

        public IL(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f4864ILil = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f4863I1I = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof LL1IL) {
                    LL1IL ll1il = (LL1IL) spinnerAdapter;
                    if (ll1il.getDropDownViewTheme() == null) {
                        ll1il.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f4863I1I;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f4863I1I;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4864ILil;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f4865ILil;

        public static class IL1Iii implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f4865ILil ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4865ILil = parcel.readByte() != 0;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$iI丨LLL1, reason: invalid class name */
    public interface iILLL1 {
        boolean IL1Iii();

        void ILL(int i);

        int ILil();

        /* JADX INFO: renamed from: IL丨丨l */
        void mo3083ILl(ListAdapter listAdapter);

        CharSequence Ilil();

        /* JADX INFO: renamed from: I丨L */
        void mo3084IL(int i);

        /* JADX INFO: renamed from: Ll丨1 */
        void mo3085Ll1(int i, int i2);

        /* JADX INFO: renamed from: L丨1丨1丨I */
        void mo3086L11I(CharSequence charSequence);

        void dismiss();

        /* JADX INFO: renamed from: iI丨LLL1 */
        Drawable mo3087iILLL1();

        /* JADX INFO: renamed from: lIi丨I */
        int mo3088lIiI();

        void setBackgroundDrawable(Drawable drawable);

        /* JADX INFO: renamed from: 丨il */
        void mo3089il(int i);
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$l丨Li1LL, reason: invalid class name */
    public class lLi1LL extends ListPopupWindow implements iILLL1 {

        /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
        public ListAdapter f2404IIi;

        /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
        public final Rect f2405LIll;

        /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
        public int f2406ill;

        /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
        public CharSequence f2407iILLl;

        /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$l丨Li1LL$I1I */
        public class I1I implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f4867ILil;

            public I1I(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f4867ILil = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f4867ILil);
                }
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$l丨Li1LL$IL1Iii */
        public class IL1Iii implements AdapterView.OnItemClickListener {
            public IL1Iii(AppCompatSpinner appCompatSpinner) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    lLi1LL lli1ll = lLi1LL.this;
                    AppCompatSpinner.this.performItemClick(view, i, lli1ll.f2404IIi.getItemId(i));
                }
                lLi1LL.this.dismiss();
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$l丨Li1LL$ILil */
        public class ILil implements ViewTreeObserver.OnGlobalLayoutListener {
            public ILil() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                lLi1LL lli1ll = lLi1LL.this;
                if (!lli1ll.m3091L11(AppCompatSpinner.this)) {
                    lLi1LL.this.dismiss();
                } else {
                    lLi1LL.this.m3092ill();
                    lLi1LL.super.show();
                }
            }
        }

        public lLi1LL(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2405LIll = new Rect();
            llliI(AppCompatSpinner.this);
            m3096L111(true);
            m3097L1l(0);
            m117(new IL1Iii(AppCompatSpinner.this));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public void ILL(int i) {
            this.f2406ill = i;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: IL丨丨l */
        public void mo3083ILl(ListAdapter listAdapter) {
            super.mo3083ILl(listAdapter);
            this.f2404IIi = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        public CharSequence Ilil() {
            return this.f2407iILLl;
        }

        /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
        public boolean m3091L11(View view) {
            return ILil.p028IiL.p029ILl.iIlLiL.m2099L11(view) && view.getGlobalVisibleRect(this.f2405LIll);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: Ll丨1 */
        public void mo3085Ll1(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean zIL1Iii = IL1Iii();
            m3092ill();
            LL1IL(2);
            super.show();
            ListView listViewMo1876IiL = mo1876IiL();
            listViewMo1876IiL.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewMo1876IiL.setTextDirection(i);
                listViewMo1876IiL.setTextAlignment(i2);
            }
            m3104iILLl(AppCompatSpinner.this.getSelectedItemPosition());
            if (zIL1Iii || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            ILil iLil = new ILil();
            viewTreeObserver.addOnGlobalLayoutListener(iLil);
            m3108LLlI1(new I1I(iLil));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.iILLL1
        /* JADX INFO: renamed from: L丨1丨1丨I */
        public void mo3086L11I(CharSequence charSequence) {
            this.f2407iILLl = charSequence;
        }

        /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
        public void m3092ill() {
            Drawable drawableM3099iILLL1 = m3099iILLL1();
            int i = 0;
            if (drawableM3099iILLL1 != null) {
                drawableM3099iILLL1.getPadding(AppCompatSpinner.this.mTempRect);
                i = C0624ill.ILil(AppCompatSpinner.this) ? AppCompatSpinner.this.mTempRect.right : -AppCompatSpinner.this.mTempRect.left;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i2 = appCompatSpinner.mDropDownWidth;
            if (i2 == -2) {
                int iCompatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((SpinnerAdapter) this.f2404IIi, m3099iILLL1());
                int i3 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.mTempRect;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (iCompatMeasureContentWidth > i4) {
                    iCompatMeasureContentWidth = i4;
                }
                m31091(Math.max(iCompatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                m31091((width - paddingLeft) - paddingRight);
            } else {
                m31091(i2);
            }
            m3095IL(C0624ill.ILil(AppCompatSpinner.this) ? i + (((width - paddingRight) - iIlLiL()) - m3093()) : i + paddingLeft + m3093());
        }

        /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
        public int m3093() {
            return this.f2406ill;
        }
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.mTempRect);
        Rect rect = this.mTempRect;
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.ILil();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            return iilll1.ILil();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            return iilll1.mo3088lIiI();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public final iILLL1 getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            return iilll1.mo3087iILLL1();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        iILLL1 iilll1 = this.mPopup;
        return iilll1 != null ? iilll1.Ilil() : super.getPrompt();
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public ColorStateList getSupportBackgroundTintList() {
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            return il.I1I();
        }
        return null;
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            return il.m1734IL();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 == null || !iilll1.IL1Iii()) {
            return;
        }
        this.mPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f4865ILil || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ILil());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        iILLL1 iilll1 = this.mPopup;
        savedState.f4865ILil = iilll1 != null && iilll1.IL1Iii();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        iIlLiL iillil = this.mForwardingListener;
        if (iillil == null || !iillil.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 == null) {
            return super.performClick();
        }
        if (iilll1.IL1Iii()) {
            return true;
        }
        showPopup();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1738lLi1LL(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1737iILLL1(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            iilll1.ILL(i);
            this.mPopup.mo3084IL(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            iilll1.mo3089il(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            iilll1.setBackgroundDrawable(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(ILil.ILil.p022lIiI.IL1Iii.IL1Iii.m1686IL(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        iILLL1 iilll1 = this.mPopup;
        if (iilll1 != null) {
            iilll1.mo3086L11I(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1736L11I(colorStateList);
        }
    }

    @Override // ILil.p028IiL.p029ILl.iIi1
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ILil.ILil.p023lIlii.IL il = this.mBackgroundTintHelper;
        if (il != null) {
            il.m1739il(mode);
        }
    }

    public void showPopup() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.mPopup.mo3085Ll1(getTextDirection(), getTextAlignment());
        } else {
            this.mPopup.mo3085Ll1(-1, -1);
        }
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, ILil.ILil.IL1Iii.spinnerStyle, i);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.mo3083ILl(new IL(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.ILil.IL1Iii.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004a A[PHI: r10 r11
  0x004a: PHI (r10v2 int) = (r10v0 int), (r10v4 int) binds: [B:24:0x005b, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]
  0x004a: PHI (r11v7 android.content.res.TypedArray) = (r11v6 android.content.res.TypedArray), (r11v9 android.content.res.TypedArray) binds: [B:24:0x005b, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        llI lliI11li1 = llI.I11li1(context, attributeSet, ILL.Spinner, i, 0);
        this.mBackgroundTintHelper = new ILil.ILil.p023lIlii.IL(this);
        if (theme != null) {
            this.mPopupContext = new ILil.ILil.p024llL1ii.IL(context, theme);
        } else {
            int iM1822ILl = lliI11li1.m1822ILl(ILL.Spinner_popupTheme, 0);
            if (iM1822ILl != 0) {
                this.mPopupContext = new ILil.ILil.p024llL1ii.IL(context, iM1822ILl);
            } else {
                this.mPopupContext = context;
            }
        }
        TypedArray typedArray = null;
        if (i2 == -1) {
            try {
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, i, 0);
                try {
                    try {
                        i2 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i2;
                        if (typedArrayObtainStyledAttributes != null) {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        typedArray = typedArrayObtainStyledAttributes;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    Log.i(TAG, "Could not read android:spinnerMode", e);
                    if (typedArrayObtainStyledAttributes != null) {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
            } catch (Exception e2) {
                e = e2;
                typedArrayObtainStyledAttributes = null;
            } catch (Throwable th2) {
                th = th2;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
        }
        if (i2 == 0) {
            I1I i1i = new I1I();
            this.mPopup = i1i;
            i1i.mo3086L11I(lliI11li1.Lil(ILL.Spinner_android_prompt));
        } else if (i2 == 1) {
            lLi1LL lli1ll = new lLi1LL(this.mPopupContext, attributeSet, i);
            llI lliI11li2 = llI.I11li1(this.mPopupContext, attributeSet, ILL.Spinner, i, 0);
            this.mDropDownWidth = lliI11li2.m1828lIiI(ILL.Spinner_android_dropDownWidth, -2);
            lli1ll.setBackgroundDrawable(lliI11li2.m1827iILLL1(ILL.Spinner_android_popupBackground));
            lli1ll.mo3086L11I(lliI11li1.Lil(ILL.Spinner_android_prompt));
            lliI11li2.m1833lL();
            this.mPopup = lli1ll;
            this.mForwardingListener = new IL1Iii(this, lli1ll);
        }
        CharSequence[] charSequenceArrM1830llL1ii = lliI11li1.m1830llL1ii(ILL.Spinner_android_entries);
        if (charSequenceArrM1830llL1ii != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrM1830llL1ii);
            arrayAdapter.setDropDownViewResource(IiL.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        lliI11li1.m1833lL();
        this.mPopupSet = true;
        SpinnerAdapter spinnerAdapter = this.mTempAdapter;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.Ilil(attributeSet, i);
    }
}
