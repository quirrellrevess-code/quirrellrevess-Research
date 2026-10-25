package androidx.appcompat.widget;

import ILil.ILil.ILL;
import ILil.ILil.L11I;
import ILil.ILil.p023lIlii.iIlLiL;
import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p024llL1ii.ILL.llL1ii;
import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final IiL f4836I1I;
    public ILil.p028IiL.p029ILl.ILil ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final iILLL1 f4837ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ListPopupWindow f2386ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final Drawable f4838Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final View f2387IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final FrameLayout f2388IiL;
    public PopupWindow.OnDismissListener Lil;
    public boolean LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final DataSetObserver f2389Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ImageView f2390L11I;
    public int iIi1;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final ImageView f2391iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final ViewTreeObserver.OnGlobalLayoutListener f2392lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f2393lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public int f2394llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final FrameLayout f2395lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int f2396il;

    public class I1I extends View.AccessibilityDelegate {
        public I1I(ActivityChooserView activityChooserView) {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            ILil.p028IiL.p029ILl.LL1IL.I1I.LII(accessibilityNodeInfo).iIilII1(true);
        }
    }

    public class IL1Iii extends DataSetObserver {
        public IL1Iii() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f4837ILil.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f4837ILil.notifyDataSetInvalidated();
        }
    }

    public class ILil implements ViewTreeObserver.OnGlobalLayoutListener {
        public ILil() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.ILil()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ILil.p028IiL.p029ILl.ILil iLil = ActivityChooserView.this.ILL;
                if (iLil != null) {
                    iLil.ILL(true);
                }
            }
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final int[] f4841ILil = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            llI lliIIlLiL = llI.iIlLiL(context, attributeSet, f4841ILil);
            setBackgroundDrawable(lliIIlLiL.m1827iILLL1(0));
            lliIIlLiL.m1833lL();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActivityChooserView$I丨L, reason: invalid class name */
    public class IL extends iIlLiL {
        public IL(View view) {
            super(view);
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        public boolean I1I() {
            ActivityChooserView.this.I1I();
            return true;
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        public llL1ii ILil() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // ILil.ILil.p023lIlii.iIlLiL
        /* JADX INFO: renamed from: I丨L */
        public boolean mo1775IL() {
            ActivityChooserView.this.IL1Iii();
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActivityChooserView$I丨iL, reason: invalid class name */
    public class IiL implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public IiL() {
        }

        public final void IL1Iii() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.Lil;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f2388IiL) {
                activityChooserView.IL1Iii();
                ActivityChooserView.this.f4837ILil.I1I();
                throw null;
            }
            if (view != activityChooserView.f2395lLi1LL) {
                throw new IllegalArgumentException();
            }
            activityChooserView.LlLI1 = false;
            activityChooserView.m3080IL(activityChooserView.f2394llL1ii);
            throw null;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IL1Iii();
            ILil.p028IiL.p029ILl.ILil iLil = ActivityChooserView.this.ILL;
            if (iLil != null) {
                iLil.ILL(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((iILLL1) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.m3080IL(Integer.MAX_VALUE);
                throw null;
            }
            ActivityChooserView.this.IL1Iii();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.LlLI1) {
                if (i <= 0) {
                    return;
                }
                activityChooserView.f4837ILil.ILil().Ilil(i);
                throw null;
            }
            if (!activityChooserView.f4837ILil.m3081IL()) {
                i++;
            }
            ActivityChooserView.this.f4837ILil.ILil().IL1Iii(i);
            throw null;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f2388IiL) {
                throw new IllegalArgumentException();
            }
            activityChooserView.f4837ILil.getCount();
            throw null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActivityChooserView$iI丨LLL1, reason: invalid class name */
    public class iILLL1 extends BaseAdapter {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4843I1I = 4;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public ILil.ILil.p023lIlii.I1I f4844ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public boolean f4845Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean f2397IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2399lLi1LL;

        public iILLL1() {
        }

        public ResolveInfo I1I() {
            this.f4844ILil.m1706IL();
            throw null;
        }

        public int IL1Iii() {
            this.f4844ILil.I1I();
            throw null;
        }

        public ILil.ILil.p023lIlii.I1I ILil() {
            return this.f4844ILil;
        }

        public void Ilil(ILil.ILil.p023lIlii.I1I i1i) {
            ILil.ILil.p023lIlii.I1I i1iILil = ActivityChooserView.this.f4837ILil.ILil();
            if (i1iILil != null && ActivityChooserView.this.isShown()) {
                i1iILil.unregisterObserver(ActivityChooserView.this.f2389Ll1);
            }
            if (i1i != null && ActivityChooserView.this.isShown()) {
                i1i.registerObserver(ActivityChooserView.this.f2389Ll1);
            }
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m3081IL() {
            return this.f2397IL;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            this.f4844ILil.I1I();
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (this.f2397IL) {
                this.f4844ILil.ILil(i);
                throw null;
            }
            this.f4844ILil.m1706IL();
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            if (!this.f2399lLi1LL) {
                return 0;
            }
            getCount();
            throw null;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(ILil.ILil.IiL.abc_activity_chooser_view_list_item, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(ILil.ILil.iILLL1.title)).setText(ActivityChooserView.this.getContext().getString(L11I.abc_activity_chooser_view_see_all));
                return viewInflate;
            }
            if (view == null || view.getId() != ILil.ILil.iILLL1.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(ILil.ILil.IiL.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(ILil.ILil.iILLL1.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(ILil.ILil.iILLL1.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f2397IL && i == 0 && this.f4845Ilil) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActivityChooserView$l丨Li1LL, reason: invalid class name */
    public class lLi1LL extends DataSetObserver {
        public lLi1LL() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.Ilil();
            throw null;
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public boolean I1I() {
        if (ILil() || !this.f2393lIlii) {
            return false;
        }
        this.LlLI1 = false;
        m3080IL(this.f2394llL1ii);
        throw null;
    }

    public boolean IL1Iii() {
        if (!ILil()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f2392lIiI);
        return true;
    }

    public boolean ILil() {
        return getListPopupWindow().IL1Iii();
    }

    public void Ilil() {
        this.f4837ILil.getCount();
        throw null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3080IL(int i) {
        if (this.f4837ILil.ILil() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2392lIiI);
        this.f2388IiL.getVisibility();
        this.f4837ILil.IL1Iii();
        throw null;
    }

    public ILil.ILil.p023lIlii.I1I getDataModel() {
        return this.f4837ILil.ILil();
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f2386ILl == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f2386ILl = listPopupWindow;
            listPopupWindow.mo3083ILl(this.f4837ILil);
            this.f2386ILl.llliI(this);
            this.f2386ILl.m3096L111(true);
            this.f2386ILl.m117(this.f4836I1I);
            this.f2386ILl.m3108LLlI1(this.f4836I1I);
        }
        return this.f2386ILl;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ILil.ILil.p023lIlii.I1I i1iILil = this.f4837ILil.ILil();
        if (i1iILil != null) {
            i1iILil.registerObserver(this.f2389Ll1);
        }
        this.f2393lIlii = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ILil.ILil.p023lIlii.I1I i1iILil = this.f4837ILil.ILil();
        if (i1iILil != null) {
            i1iILil.unregisterObserver(this.f2389Ll1);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2392lIiI);
        }
        if (ILil()) {
            IL1Iii();
        }
        this.f2393lIlii = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2387IL.layout(0, 0, i3 - i, i4 - i2);
        if (ILil()) {
            return;
        }
        IL1Iii();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        View view = this.f2387IL;
        if (this.f2388IiL.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ILil.ILil.p023lIlii.I1I i1i) {
        this.f4837ILil.Ilil(i1i);
        if (ILil()) {
            IL1Iii();
            I1I();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.iIi1 = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2391iILLL1.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2391iILLL1.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f2394llL1ii = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.Lil = onDismissListener;
    }

    public void setProvider(ILil.p028IiL.p029ILl.ILil iLil) {
        this.ILL = iLil;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2389Ll1 = new IL1Iii();
        this.f2392lIiI = new ILil();
        this.f2394llL1ii = 4;
        int[] iArr = ILL.ActivityChooserView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        }
        this.f2394llL1ii = typedArrayObtainStyledAttributes.getInt(ILL.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(ILL.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(ILil.ILil.IiL.abc_activity_chooser_view, (ViewGroup) this, true);
        IiL iiL = new IiL();
        this.f4836I1I = iiL;
        View viewFindViewById = findViewById(ILil.ILil.iILLL1.activity_chooser_view_content);
        this.f2387IL = viewFindViewById;
        this.f4838Ilil = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(ILil.ILil.iILLL1.default_activity_button);
        this.f2388IiL = frameLayout;
        frameLayout.setOnClickListener(iiL);
        frameLayout.setOnLongClickListener(iiL);
        int i2 = ILil.ILil.iILLL1.image;
        this.f2390L11I = (ImageView) frameLayout.findViewById(i2);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(ILil.ILil.iILLL1.expand_activities_button);
        frameLayout2.setOnClickListener(iiL);
        frameLayout2.setAccessibilityDelegate(new I1I(this));
        frameLayout2.setOnTouchListener(new IL(frameLayout2));
        this.f2395lLi1LL = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i2);
        this.f2391iILLL1 = imageView;
        imageView.setImageDrawable(drawable);
        iILLL1 iilll1 = new iILLL1();
        this.f4837ILil = iilll1;
        iilll1.registerDataSetObserver(new lLi1LL());
        Resources resources = context.getResources();
        this.f2396il = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(ILil.ILil.IL.abc_config_prefDialogWidth));
    }
}
