package androidx.appcompat.widget;

import ILil.ILil.p023lIlii.C0624ill;
import ILil.ILil.p023lIlii.L1l;
import ILil.ILil.p023lIlii.LlLLL;
import ILil.ILil.p023lIlii.llI;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import com.google.android.flexbox.BuildConfig;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.opencv.calib3d.Calib3d;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements ILil.ILil.p024llL1ii.I1I {

    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public static final Ll1 f2435ili11 = new Ll1();
    public InterfaceC0661ILl I11L;
    public final Intent I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final View f4889I1I;

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public View.OnKeyListener f2436I1L11L;

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public final Runnable f2437IIiI;
    public LlLI1 ILL;

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public final TextView.OnEditorActionListener f2438ILLIi;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final SearchAutoComplete f4890ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public int[] f2439ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final View f4891Ilil;

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public CharSequence f2440IIi;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final View f2441IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final ImageView f2442IiL;

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public SearchableInfo f2443L11;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public ILil.p039L11I.IL1Iii.IL1Iii f2444L111;

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public CharSequence f2445LIll;
    public boolean LL1IL;
    public final WeakHashMap<String, Drawable.ConstantState> LLL;
    public int[] Lil;

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public Bundle f2446LlIl;
    public final ImageView LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Rect f2447Ll1;

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public int f2448L1l;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ImageView f2449L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public View.OnClickListener f2450LlLLL;

    /* JADX INFO: renamed from: i1 */
    public TextWatcher f33i1;

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public final View.OnClickListener f2451iI1iI;
    public final int iIi1;
    public final AdapterView.OnItemSelectedListener iIilII1;
    public final Intent iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final ImageView f2452iILLL1;

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public boolean f2453ill;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public boolean f2454l1IIi1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public Rect f2455lIiI;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public boolean f2456lIII;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final int f2457lIlii;
    public boolean llI;
    public lIiI llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final Drawable f2458llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final ImageView f2459lLi1LL;

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public Runnable f2460lliiI1;

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public final AdapterView.OnItemClickListener f2461li11;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public boolean f2462iILLl;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final View f2463il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final CharSequence f2464lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public View.OnFocusChangeListener f2465l;

    /* JADX INFO: renamed from: 丨丨 */
    public CharSequence f34;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public boolean f2466LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public Lil f24671;

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public int f2468;

    public class I1I implements Runnable {
        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ILil.p039L11I.IL1Iii.IL1Iii iL1Iii = SearchView.this.f2444L111;
            if (iL1Iii instanceof LlLLL) {
                iL1Iii.IL1Iii(null);
            }
        }
    }

    public class IL1Iii implements TextWatcher {
        public IL1Iii() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.m3119LlLLL(charSequence);
        }
    }

    public class ILL implements AdapterView.OnItemSelectedListener {
        public ILL() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.m3130lL(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class ILil implements Runnable {
        public ILil() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.m3122l1IIi1();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$IL丨丨l, reason: invalid class name and case insensitive filesystem */
    public interface InterfaceC0661ILl {
        boolean IL1Iii(String str);

        boolean ILil(String str);
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$I丨L, reason: invalid class name */
    public class IL implements View.OnFocusChangeListener {
        public IL() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f2465l;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$I丨iL, reason: invalid class name */
    public class IiL implements View.OnKeyListener {
        public IiL() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f2443L11 == null) {
                return false;
            }
            if (searchView.f4890ILil.isPopupShowing() && SearchView.this.f4890ILil.getListSelection() != -1) {
                return SearchView.this.m31331(view, i, keyEvent);
            }
            if (SearchView.this.f4890ILil.IL1Iii() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.m3125lIlii(0, null, searchView2.f4890ILil.getText().toString());
            return true;
        }
    }

    public interface Lil {
        boolean IL1Iii(int i);

        boolean ILil(int i);
    }

    public static class LlLI1 extends TouchDelegate {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final Rect f4898I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final View f4899IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final Rect f4900ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final int f4901Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final Rect f2469IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f2470lLi1LL;

        public LlLI1(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f4901Ilil = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f4900ILil = new Rect();
            this.f2469IL = new Rect();
            this.f4898I1I = new Rect();
            IL1Iii(rect, rect2);
            this.f4899IL1Iii = view;
        }

        public void IL1Iii(Rect rect, Rect rect2) {
            this.f4900ILil.set(rect);
            this.f2469IL.set(rect);
            Rect rect3 = this.f2469IL;
            int i = this.f4901Ilil;
            rect3.inset(-i, -i);
            this.f4898I1I.set(rect2);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003d  */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f2470lLi1LL;
                    if (z2 && !this.f2469IL.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else if (action != 3) {
                    z = true;
                    z3 = false;
                } else {
                    z2 = this.f2470lLi1LL;
                    this.f2470lLi1LL = false;
                }
                z3 = z2;
                z = true;
            } else if (this.f4900ILil.contains(x, y)) {
                this.f2470lLi1LL = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.f4898I1I.contains(x, y)) {
                Rect rect = this.f4898I1I;
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(this.f4899IL1Iii.getWidth() / 2, this.f4899IL1Iii.getHeight() / 2);
            }
            return this.f4899IL1Iii.dispatchTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$Ll丨1, reason: invalid class name */
    public static class Ll1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public Method f4902I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Method f4903IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Method f4904ILil;

        public Ll1() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f4903IL1Iii = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f4904ILil = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f4902I1I = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public void I1I(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f4902I1I;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }

        public void IL1Iii(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f4904ILil;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void ILil(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f4903IL1Iii;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$L丨1丨1丨I, reason: invalid class name */
    public class L11I implements TextView.OnEditorActionListener {
        public L11I() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.m3131l();
            return true;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new IL1Iii();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f4906ILil;

        public static class IL1Iii implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: I1I, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f4906ILil + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f4906ILil));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4906ILil = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4907Ilil;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public final Runnable f2471IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f2472iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public SearchView f2473lLi1LL;

        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.ILil();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public boolean IL1Iii() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void ILil() {
            if (this.f2472iILLL1) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2472iILLL1 = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f4907Ilil <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2472iILLL1) {
                removeCallbacks(this.f2471IiL);
                post(this.f2471IiL);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f2473lLi1LL.m3124lIII();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2473lLi1LL.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f2473lLi1LL.hasFocus() && getVisibility() == 0) {
                this.f2472iILLL1 = true;
                if (SearchView.Lil(getContext())) {
                    SearchView.f2435ili11.I1I(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f2472iILLL1 = false;
                removeCallbacks(this.f2471IiL);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f2472iILLL1 = true;
                    return;
                }
                this.f2472iILLL1 = false;
                removeCallbacks(this.f2471IiL);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f2473lLi1LL = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f4907Ilil = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, ILil.ILil.IL1Iii.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2471IiL = new IL1Iii();
            this.f4907Ilil = getThreshold();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements View.OnClickListener {
        public iILLL1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f2459lLi1LL) {
                searchView.llliI();
                return;
            }
            if (view == searchView.f2442IiL) {
                searchView.iIlLiL();
                return;
            }
            if (view == searchView.f2452iILLL1) {
                searchView.m3131l();
            } else if (view == searchView.f2449L11I) {
                searchView.LL1IL();
            } else if (view == searchView.f4890ILil) {
                searchView.m3129il();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$lIi丨I, reason: invalid class name */
    public interface lIiI {
        boolean IL1Iii();
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements View.OnLayoutChangeListener {
        public lLi1LL() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.m3112IL();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.SearchView$丨il, reason: invalid class name and case insensitive filesystem */
    public class C0662il implements AdapterView.OnItemClickListener {
        public C0662il() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.I11li1(i, 0, null);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public static boolean Lil(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(ILil.ILil.IL.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(ILil.ILil.IL.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.f4890ILil.setText(charSequence);
        this.f4890ILil.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void I11L(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public boolean I11li1(int i, int i2, String str) {
        Lil lil = this.f24671;
        if (lil != null && lil.ILil(i)) {
            return false;
        }
        iIi1(i, 0, null);
        this.f4890ILil.setImeVisibility(false);
        m3118L11I();
        return true;
    }

    @Override // ILil.ILil.p024llL1ii.I1I
    public void I1I() {
        m118(BuildConfig.FLAVOR, false);
        clearFocus();
        m3121ill(true);
        this.f4890ILil.setImeOptions(this.f2468);
        this.f2453ill = false;
    }

    public final void ILL(View view, Rect rect) {
        view.getLocationInWindow(this.f2439ILl);
        getLocationInWindow(this.Lil);
        int[] iArr = this.f2439ILl;
        int i = iArr[1];
        int[] iArr2 = this.Lil;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    @Override // ILil.ILil.p024llL1ii.I1I
    public void ILil() {
        if (this.f2453ill) {
            return;
        }
        this.f2453ill = true;
        int imeOptions = this.f4890ILil.getImeOptions();
        this.f2468 = imeOptions;
        this.f4890ILil.setImeOptions(imeOptions | 33554432);
        this.f4890ILil.setText(BuildConfig.FLAVOR);
        setIconified(false);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m3110ILl() {
        return this.LL1IL;
    }

    public final Intent Ilil(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2445LIll);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2446LlIl;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2443L11.getSearchActivity());
        return intent;
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final void m3111IIi() {
        this.f4891Ilil.setVisibility((LlLI1() && (this.f2452iILLL1.getVisibility() == 0 || this.f2449L11I.getVisibility() == 0)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m3112IL() {
        if (this.f2463il.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f2441IL.getPaddingLeft();
            Rect rect = new Rect();
            boolean zILil = C0624ill.ILil(this);
            int dimensionPixelSize = this.f2456lIII ? resources.getDimensionPixelSize(ILil.ILil.IL.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(ILil.ILil.IL.abc_dropdownitem_text_padding_left) : 0;
            this.f4890ILil.getDropDownBackground().getPadding(rect);
            this.f4890ILil.setDropDownHorizontalOffset(zILil ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f4890ILil.setDropDownWidth((((this.f2463il.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final Intent m3113IiL(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public final void m3114L111() {
        post(this.f2437IIiI);
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m3115LIll(boolean z) {
        this.f2452iILLL1.setVisibility((this.f2466LLlI1 && LlLI1() && hasFocus() && (z || !this.f2462iILLl)) ? 0 : 8);
    }

    public void LL1IL() {
        SearchableInfo searchableInfo = this.f2443L11;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(m3113IiL(this.iIlLiL, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m3120iILLL1(this.I11li1, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public final boolean LlLI1() {
        return (this.f2466LLlI1 || this.f2462iILLl) && !m3110ILl();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final CharSequence m3116Ll1(CharSequence charSequence) {
        if (!this.f2456lIII || this.f2458llL1ii == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f4890ILil.getTextSize()) * 1.25d);
        this.f2458llL1ii.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f2458llL1ii), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public final void m3117L1l() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f4890ILil;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(m3116Ll1(queryHint));
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final void m3118L11I() {
        this.f4890ILil.dismissDropDown();
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m3119LlLLL(CharSequence charSequence) {
        Editable text = this.f4890ILil.getText();
        this.f2445LIll = text;
        boolean z = !TextUtils.isEmpty(text);
        m3115LIll(z);
        m3134(!z);
        llI();
        m3111IIi();
        if (this.I11L != null && !TextUtils.equals(charSequence, this.f2440IIi)) {
            this.I11L.IL1Iii(charSequence.toString());
        }
        this.f2440IIi = charSequence.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f2454l1IIi1 = true;
        super.clearFocus();
        this.f4890ILil.clearFocus();
        this.f4890ILil.setImeVisibility(false);
        this.f2454l1IIi1 = false;
    }

    public int getImeOptions() {
        return this.f4890ILil.getImeOptions();
    }

    public int getInputType() {
        return this.f4890ILil.getInputType();
    }

    public int getMaxWidth() {
        return this.f2448L1l;
    }

    public CharSequence getQuery() {
        return this.f4890ILil.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f34;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2443L11;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f2464lL : getContext().getText(this.f2443L11.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.iIi1;
    }

    public int getSuggestionRowLayout() {
        return this.f2457lIlii;
    }

    public ILil.p039L11I.IL1Iii.IL1Iii getSuggestionsAdapter() {
        return this.f2444L111;
    }

    public final boolean iIi1(int i, int i2, String str) {
        Cursor cursorILil = this.f2444L111.ILil();
        if (cursorILil == null || !cursorILil.moveToPosition(i)) {
            return false;
        }
        m3126llL1ii(m3127lLi1LL(cursorILil, i2, str));
        return true;
    }

    public void iIlLiL() {
        if (!TextUtils.isEmpty(this.f4890ILil.getText())) {
            this.f4890ILil.setText(BuildConfig.FLAVOR);
            this.f4890ILil.requestFocus();
            this.f4890ILil.setImeVisibility(true);
        } else if (this.f2456lIII) {
            lIiI liii = this.llliI;
            if (liii == null || !liii.IL1Iii()) {
                clearFocus();
                m3121ill(true);
            }
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final Intent m3120iILLL1(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, Videoio.CAP_OPENNI_IMAGE_GENERATOR);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2446LlIl;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m3121ill(boolean z) {
        this.LL1IL = z;
        int i = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f4890ILil.getText());
        this.f2459lLi1LL.setVisibility(i);
        m3115LIll(z2);
        this.f4889I1I.setVisibility(z ? 8 : 0);
        this.LlLI1.setVisibility((this.LlLI1.getDrawable() == null || this.f2456lIII) ? 8 : 0);
        llI();
        m3134(!z2);
        m3111IIi();
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public void m3122l1IIi1() {
        int[] iArr = this.f4890ILil.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f2441IL.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f4891Ilil.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final boolean m3123lIiI() {
        SearchableInfo searchableInfo = this.f2443L11;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f2443L11.getVoiceSearchLaunchWebSearch()) {
            intent = this.iIlLiL;
        } else if (this.f2443L11.getVoiceSearchLaunchRecognizer()) {
            intent = this.I11li1;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public void m3124lIII() {
        m3121ill(m3110ILl());
        m3114L111();
        if (this.f4890ILil.hasFocus()) {
            m3129il();
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m3125lIlii(int i, String str, String str2) {
        getContext().startActivity(Ilil("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    public final void llI() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f4890ILil.getText());
        if (!z2 && (!this.f2456lIII || this.f2453ill)) {
            z = false;
        }
        this.f2442IiL.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f2442IiL.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void llliI() {
        m3121ill(false);
        this.f4890ILil.requestFocus();
        this.f4890ILil.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f2450LlLLL;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final void m3126llL1ii(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e) {
            Log.e("SearchView", "Failed launch activity: " + intent, e);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Intent m3127lLi1LL(Cursor cursor, int i, String str) {
        int position;
        String strLil;
        try {
            String strLil2 = LlLLL.Lil(cursor, "suggest_intent_action");
            if (strLil2 == null) {
                strLil2 = this.f2443L11.getSuggestIntentAction();
            }
            if (strLil2 == null) {
                strLil2 = "android.intent.action.SEARCH";
            }
            String str2 = strLil2;
            String strLil3 = LlLLL.Lil(cursor, "suggest_intent_data");
            if (strLil3 == null) {
                strLil3 = this.f2443L11.getSuggestIntentData();
            }
            if (strLil3 != null && (strLil = LlLLL.Lil(cursor, "suggest_intent_data_id")) != null) {
                strLil3 = strLil3 + "/" + Uri.encode(strLil);
            }
            return Ilil(str2, strLil3 == null ? null : Uri.parse(strLil3), LlLLL.Lil(cursor, "suggest_intent_extra_data"), LlLLL.Lil(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f2437IIiI);
        post(this.f2460lliiI1);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            ILL(this.f4890ILil, this.f2447Ll1);
            Rect rect = this.f2455lIiI;
            Rect rect2 = this.f2447Ll1;
            rect.set(rect2.left, 0, rect2.right, i4 - i2);
            LlLI1 llLI1 = this.ILL;
            if (llLI1 != null) {
                llLI1.IL1Iii(this.f2455lIiI, this.f2447Ll1);
                return;
            }
            LlLI1 llLI2 = new LlLI1(this.f2455lIiI, this.f2447Ll1, this.f4890ILil);
            this.ILL = llLI2;
            setTouchDelegate(llLI2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (m3110ILl()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f2448L1l;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f2448L1l;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.f2448L1l) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, Videoio.CAP_OPENNI_IMAGE_GENERATOR), View.MeasureSpec.makeMeasureSpec(size2, Videoio.CAP_OPENNI_IMAGE_GENERATOR));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m3121ill(savedState.f4906ILil);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4906ILil = m3110ILl();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3114L111();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f2454l1IIi1 || !isFocusable()) {
            return false;
        }
        if (m3110ILl()) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.f4890ILil.requestFocus(i, rect);
        if (zRequestFocus) {
            m3121ill(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2446LlIl = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            iIlLiL();
        } else {
            llliI();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f2456lIII == z) {
            return;
        }
        this.f2456lIII = z;
        m3121ill(z);
        m3117L1l();
    }

    public void setImeOptions(int i) {
        this.f4890ILil.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f4890ILil.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f2448L1l = i;
        requestLayout();
    }

    public void setOnCloseListener(lIiI liii) {
        this.llliI = liii;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f2465l = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC0661ILl interfaceC0661ILl) {
        this.I11L = interfaceC0661ILl;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2450LlLLL = onClickListener;
    }

    public void setOnSuggestionListener(Lil lil) {
        this.f24671 = lil;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f34 = charSequence;
        m3117L1l();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.llI = z;
        ILil.p039L11I.IL1Iii.IL1Iii iL1Iii = this.f2444L111;
        if (iL1Iii instanceof LlLLL) {
            ((LlLLL) iL1Iii).llliI(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2443L11 = searchableInfo;
        if (searchableInfo != null) {
            m3128iILLl();
            m3117L1l();
        }
        boolean zM3123lIiI = m3123lIiI();
        this.f2462iILLl = zM3123lIiI;
        if (zM3123lIiI) {
            this.f4890ILil.setPrivateImeOptions("nm");
        }
        m3121ill(m3110ILl());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f2466LLlI1 = z;
        m3121ill(m3110ILl());
    }

    public void setSuggestionsAdapter(ILil.p039L11I.IL1Iii.IL1Iii iL1Iii) {
        this.f2444L111 = iL1Iii;
        this.f4890ILil.setAdapter(iL1Iii);
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public final void m3128iILLl() {
        this.f4890ILil.setThreshold(this.f2443L11.getSuggestThreshold());
        this.f4890ILil.setImeOptions(this.f2443L11.getImeOptions());
        int inputType = this.f2443L11.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2443L11.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | Calib3d.CALIB_FIX_TAUX_TAUY;
            }
        }
        this.f4890ILil.setInputType(inputType);
        ILil.p039L11I.IL1Iii.IL1Iii iL1Iii = this.f2444L111;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(null);
        }
        if (this.f2443L11.getSuggestAuthority() != null) {
            LlLLL llLLL = new LlLLL(getContext(), this, this.f2443L11, this.LLL);
            this.f2444L111 = llLLL;
            this.f4890ILil.setAdapter(llLLL);
            ((LlLLL) this.f2444L111).llliI(this.llI ? 2 : 1);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m3129il() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f4890ILil.refreshAutoCompleteResults();
            return;
        }
        Ll1 ll1 = f2435ili11;
        ll1.ILil(this.f4890ILil);
        ll1.IL1Iii(this.f4890ILil);
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean m3130lL(int i) {
        Lil lil = this.f24671;
        if (lil != null && lil.IL1Iii(i)) {
            return false;
        }
        m3132LLlI1(i);
        return true;
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m3131l() {
        Editable text = this.f4890ILil.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        InterfaceC0661ILl interfaceC0661ILl = this.I11L;
        if (interfaceC0661ILl == null || !interfaceC0661ILl.ILil(text.toString())) {
            if (this.f2443L11 != null) {
                m3125lIlii(0, null, text.toString());
            }
            this.f4890ILil.setImeVisibility(false);
            m3118L11I();
        }
    }

    /* JADX INFO: renamed from: 丨丨 */
    public void m118(CharSequence charSequence, boolean z) {
        this.f4890ILil.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f4890ILil;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f2445LIll = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m3131l();
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public final void m3132LLlI1(int i) {
        Editable text = this.f4890ILil.getText();
        Cursor cursorILil = this.f2444L111.ILil();
        if (cursorILil == null) {
            return;
        }
        if (!cursorILil.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceI1I = this.f2444L111.I1I(cursorILil);
        if (charSequenceI1I != null) {
            setQuery(charSequenceI1I);
        } else {
            setQuery(text);
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m31331(View view, int i, KeyEvent keyEvent) {
        if (this.f2443L11 != null && this.f2444L111 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return I11li1(this.f4890ILil.getListSelection(), 0, null);
            }
            if (i == 21 || i == 22) {
                this.f4890ILil.setSelection(i == 21 ? 0 : this.f4890ILil.length());
                this.f4890ILil.setListSelection(0);
                this.f4890ILil.clearListSelection();
                f2435ili11.I1I(this.f4890ILil, true);
                return true;
            }
            if (i != 19 || this.f4890ILil.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m3134(boolean z) {
        int i = 8;
        if (this.f2462iILLl && !m3110ILl() && z) {
            this.f2452iILLL1.setVisibility(8);
            i = 0;
        }
        this.f2449L11I.setVisibility(i);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ILil.ILil.IL1Iii.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2447Ll1 = new Rect();
        this.f2455lIiI = new Rect();
        this.f2439ILl = new int[2];
        this.Lil = new int[2];
        this.f2437IIiI = new ILil();
        this.f2460lliiI1 = new I1I();
        this.LLL = new WeakHashMap<>();
        iILLL1 iilll1 = new iILLL1();
        this.f2451iI1iI = iilll1;
        this.f2436I1L11L = new IiL();
        L11I l11i = new L11I();
        this.f2438ILLIi = l11i;
        C0662il c0662il = new C0662il();
        this.f2461li11 = c0662il;
        ILL ill = new ILL();
        this.iIilII1 = ill;
        this.f33i1 = new IL1Iii();
        llI lliI11li1 = llI.I11li1(context, attributeSet, ILil.ILil.ILL.SearchView, i, 0);
        LayoutInflater.from(context).inflate(lliI11li1.m1822ILl(ILil.ILil.ILL.SearchView_layout, ILil.ILil.IiL.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(ILil.ILil.iILLL1.search_src_text);
        this.f4890ILil = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f4889I1I = findViewById(ILil.ILil.iILLL1.search_edit_frame);
        View viewFindViewById = findViewById(ILil.ILil.iILLL1.search_plate);
        this.f2441IL = viewFindViewById;
        View viewFindViewById2 = findViewById(ILil.ILil.iILLL1.submit_area);
        this.f4891Ilil = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(ILil.ILil.iILLL1.search_button);
        this.f2459lLi1LL = imageView;
        ImageView imageView2 = (ImageView) findViewById(ILil.ILil.iILLL1.search_go_btn);
        this.f2452iILLL1 = imageView2;
        ImageView imageView3 = (ImageView) findViewById(ILil.ILil.iILLL1.search_close_btn);
        this.f2442IiL = imageView3;
        ImageView imageView4 = (ImageView) findViewById(ILil.ILil.iILLL1.search_voice_btn);
        this.f2449L11I = imageView4;
        ImageView imageView5 = (ImageView) findViewById(ILil.ILil.iILLL1.search_mag_icon);
        this.LlLI1 = imageView5;
        iIlLiL.ill1LI1l(viewFindViewById, lliI11li1.m1827iILLL1(ILil.ILil.ILL.SearchView_queryBackground));
        iIlLiL.ill1LI1l(viewFindViewById2, lliI11li1.m1827iILLL1(ILil.ILil.ILL.SearchView_submitBackground));
        int i2 = ILil.ILil.ILL.SearchView_searchIcon;
        imageView.setImageDrawable(lliI11li1.m1827iILLL1(i2));
        imageView2.setImageDrawable(lliI11li1.m1827iILLL1(ILil.ILil.ILL.SearchView_goIcon));
        imageView3.setImageDrawable(lliI11li1.m1827iILLL1(ILil.ILil.ILL.SearchView_closeIcon));
        imageView4.setImageDrawable(lliI11li1.m1827iILLL1(ILil.ILil.ILL.SearchView_voiceIcon));
        imageView5.setImageDrawable(lliI11li1.m1827iILLL1(i2));
        this.f2458llL1ii = lliI11li1.m1827iILLL1(ILil.ILil.ILL.SearchView_searchHintIcon);
        L1l.IL1Iii(imageView, getResources().getString(ILil.ILil.L11I.abc_searchview_description_search));
        this.f2457lIlii = lliI11li1.m1822ILl(ILil.ILil.ILL.SearchView_suggestionRowLayout, ILil.ILil.IiL.abc_search_dropdown_item_icons_2line);
        this.iIi1 = lliI11li1.m1822ILl(ILil.ILil.ILL.SearchView_commitIcon, 0);
        imageView.setOnClickListener(iilll1);
        imageView3.setOnClickListener(iilll1);
        imageView2.setOnClickListener(iilll1);
        imageView4.setOnClickListener(iilll1);
        searchAutoComplete.setOnClickListener(iilll1);
        searchAutoComplete.addTextChangedListener(this.f33i1);
        searchAutoComplete.setOnEditorActionListener(l11i);
        searchAutoComplete.setOnItemClickListener(c0662il);
        searchAutoComplete.setOnItemSelectedListener(ill);
        searchAutoComplete.setOnKeyListener(this.f2436I1L11L);
        searchAutoComplete.setOnFocusChangeListener(new IL());
        setIconifiedByDefault(lliI11li1.IL1Iii(ILil.ILil.ILL.SearchView_iconifiedByDefault, true));
        int iM1831lLi1LL = lliI11li1.m1831lLi1LL(ILil.ILil.ILL.SearchView_android_maxWidth, -1);
        if (iM1831lLi1LL != -1) {
            setMaxWidth(iM1831lLi1LL);
        }
        this.f2464lL = lliI11li1.LlLI1(ILil.ILil.ILL.SearchView_defaultQueryHint);
        this.f34 = lliI11li1.LlLI1(ILil.ILil.ILL.SearchView_queryHint);
        int iILL = lliI11li1.ILL(ILil.ILil.ILL.SearchView_android_imeOptions, -1);
        if (iILL != -1) {
            setImeOptions(iILL);
        }
        int iILL2 = lliI11li1.ILL(ILil.ILil.ILL.SearchView_android_inputType, -1);
        if (iILL2 != -1) {
            setInputType(iILL2);
        }
        setFocusable(lliI11li1.IL1Iii(ILil.ILil.ILL.SearchView_android_focusable, true));
        lliI11li1.m1833lL();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.iIlLiL = intent;
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I11li1 = intent2;
        intent2.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2463il = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new lLi1LL());
        }
        m3121ill(this.f2456lIII);
        m3117L1l();
    }
}
