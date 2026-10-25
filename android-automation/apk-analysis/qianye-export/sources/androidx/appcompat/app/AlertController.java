package androidx.appcompat.app;

import ILil.ILil.ILL;
import ILil.p028IiL.p029ILl.iIlLiL;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AlertController {
    public Button I11L;
    public Message I11li1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Window f4749I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Context f4750IL1Iii;
    public int ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ILil.ILil.p021Ll1.IL f4751ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public CharSequence f4752Ilil;

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public int f2199IIi;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int f2200IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public View f2201IiL;

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public int f2202L11;

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public ImageView f2203L111;

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public int f2204LIll;
    public Drawable LL1IL;
    public Button Lil;

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public boolean f2205LlIl;
    public CharSequence LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f2206Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f2208L11I;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public NestedScrollView f2209LlLLL;
    public Button iIi1;
    public CharSequence iIlLiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ListView f2210iILLL1;

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public int f2211ill;

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public ListAdapter f2212l1IIi1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public int f2213lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public Drawable f2215lIlii;
    public View llI;
    public CharSequence llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public Message f2216llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public CharSequence f2217lLi1LL;

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public Handler f2218lliiI1;

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public int f2219iILLl;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f2220il;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public Drawable f2221lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public Message f2222l;

    /* JADX INFO: renamed from: 丨丨 */
    public TextView f26;

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public TextView f2223LLlI1;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public Drawable f22241;

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public int f2225;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean f2198ILl = false;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public int f2214lIII = 0;

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public int f2207L1l = -1;

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public int f2197IIiI = 0;
    public final View.OnClickListener LLL = new IL1Iii();

    public class I1I implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f4753I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4754ILil;

        public I1I(View view, View view2) {
            this.f4754ILil = view;
            this.f4753I1I = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.m2991lLi1LL(AlertController.this.f2209LlLLL, this.f4754ILil, this.f4753I1I);
        }
    }

    public class IL1Iii implements View.OnClickListener {
        public IL1Iii() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.Lil && (message3 = alertController.f2216llL1ii) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.iIi1 || (message2 = alertController.I11li1) == null) {
                messageObtain = (view != alertController.I11L || (message = alertController.f2222l) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f2218lliiI1.obtainMessage(1, alertController2.f4751ILil).sendToTarget();
        }
    }

    public class ILil implements NestedScrollView.ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ View f4756IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4757ILil;

        public ILil(AlertController alertController, View view, View view2) {
            this.f4756IL1Iii = view;
            this.f4757ILil = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.ILil
        public void IL1Iii(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            AlertController.m2991lLi1LL(nestedScrollView, this.f4756IL1Iii, this.f4757ILil);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$I丨L, reason: invalid class name */
    public class IL implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ View f4758IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4759ILil;

        public IL(AlertController alertController, View view, View view2) {
            this.f4758IL1Iii = view;
            this.f4759ILil = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.m2991lLi1LL(absListView, this.f4758IL1Iii, this.f4759ILil);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$I丨iL, reason: invalid class name */
    public static final class IiL extends Handler {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public WeakReference<DialogInterface> f4760IL1Iii;

        public IiL(DialogInterface dialogInterface) {
            this.f4760IL1Iii = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f4760IL1Iii.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$L丨1丨1丨I, reason: invalid class name */
    public static class L11I extends ArrayAdapter<CharSequence> {
        public L11I(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4761I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f4762ILil;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void IL1Iii(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f4762ILil, getPaddingRight(), z2 ? getPaddingBottom() : this.f4761I1I);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ILL.RecycleListView);
            this.f4761I1I = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ILL.RecycleListView_paddingBottomNoButtons, -1);
            this.f4762ILil = typedArrayObtainStyledAttributes.getDimensionPixelOffset(ILL.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$iI丨LLL1, reason: invalid class name */
    public static class iILLL1 {
        public ListAdapter I11L;
        public DialogInterface.OnKeyListener I11li1;

        /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
        public boolean f2227IIiI;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Context f4764IL1Iii;
        public DialogInterface.OnClickListener ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final LayoutInflater f4765ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public DialogInterface.OnClickListener f2228ILl;

        /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
        public Cursor f2229IIi;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public Drawable f2230IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public CharSequence f2231IiL;

        /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
        public AdapterView.OnItemSelectedListener f2232L11;

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public int f2233L111;

        /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
        public String f2234LIll;
        public int LL1IL;
        public CharSequence Lil;

        /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
        public lLi1LL f2235LlIl;
        public Drawable LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public CharSequence f2236Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public CharSequence f2238L11I;

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public int f2239LlLLL;
        public DialogInterface.OnCancelListener iIi1;
        public DialogInterface.OnDismissListener iIlLiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public View f2240iILLL1;

        /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
        public String f2241ill;

        /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
        public boolean f2242l1IIi1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public Drawable f2243lIiI;

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public int f2244lIII;
        public boolean llI;
        public DialogInterface.OnClickListener llliI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public DialogInterface.OnClickListener f2246llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public CharSequence f2247lLi1LL;

        /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
        public DialogInterface.OnMultiChoiceClickListener f2248iILLl;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public Drawable f2249il;

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public CharSequence[] f2250lL;

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public int f2251l;

        /* JADX INFO: renamed from: 丨丨 */
        public boolean[] f27;

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public View f22531;

        /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
        public boolean f2254;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f4763I1I = 0;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f4766Ilil = 0;

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public boolean f2252LLlI1 = false;

        /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
        public int f2237L1l = -1;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public boolean f2245lIlii = true;

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$iI丨LLL1$I1I */
        public class I1I implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ AlertController f4768ILil;

            public I1I(AlertController alertController) {
                this.f4768ILil = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                iILLL1.this.llliI.onClick(this.f4768ILil.f4751ILil, i);
                if (iILLL1.this.f2242l1IIi1) {
                    return;
                }
                this.f4768ILil.f4751ILil.dismiss();
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$iI丨LLL1$IL1Iii */
        public class IL1Iii extends ArrayAdapter<CharSequence> {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f4770ILil;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public IL1Iii(Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                this.f4770ILil = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = iILLL1.this.f27;
                if (zArr != null && zArr[i]) {
                    this.f4770ILil.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$iI丨LLL1$ILil */
        public class ILil extends CursorAdapter {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final int f4771I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final int f4772ILil;

            /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
            public final /* synthetic */ AlertController f4773Ilil;

            /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
            public final /* synthetic */ RecycleListView f2255IL;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ILil(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f2255IL = recycleListView;
                this.f4773Ilil = alertController;
                Cursor cursor2 = getCursor();
                this.f4772ILil = cursor2.getColumnIndexOrThrow(iILLL1.this.f2234LIll);
                this.f4771I1I = cursor2.getColumnIndexOrThrow(iILLL1.this.f2241ill);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f4772ILil));
                this.f2255IL.setItemChecked(cursor.getPosition(), cursor.getInt(this.f4771I1I) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return iILLL1.this.f4765ILil.inflate(this.f4773Ilil.f2211ill, viewGroup, false);
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$iI丨LLL1$I丨L, reason: invalid class name */
        public class IL implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public final /* synthetic */ AlertController f4774I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f4775ILil;

            public IL(RecycleListView recycleListView, AlertController alertController) {
                this.f4775ILil = recycleListView;
                this.f4774I1I = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean[] zArr = iILLL1.this.f27;
                if (zArr != null) {
                    zArr[i] = this.f4775ILil.isItemChecked(i);
                }
                iILLL1.this.f2248iILLl.onClick(this.f4774I1I.f4751ILil, i, this.f4775ILil.isItemChecked(i));
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$iI丨LLL1$l丨Li1LL, reason: invalid class name */
        public interface lLi1LL {
            void IL1Iii(ListView listView);
        }

        public iILLL1(Context context) {
            this.f4764IL1Iii = context;
            this.f4765ILil = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void IL1Iii(AlertController alertController) {
            View view = this.f2240iILLL1;
            if (view != null) {
                alertController.m2996Ll1(view);
            } else {
                CharSequence charSequence = this.f2247lLi1LL;
                if (charSequence != null) {
                    alertController.m3001llL1ii(charSequence);
                }
                Drawable drawable = this.f2230IL;
                if (drawable != null) {
                    alertController.m2993ILl(drawable);
                }
                int i = this.f4763I1I;
                if (i != 0) {
                    alertController.m2999lIiI(i);
                }
                int i2 = this.f4766Ilil;
                if (i2 != 0) {
                    alertController.m2999lIiI(alertController.I1I(i2));
                }
            }
            CharSequence charSequence2 = this.f2231IiL;
            if (charSequence2 != null) {
                alertController.Lil(charSequence2);
            }
            CharSequence charSequence3 = this.f2238L11I;
            if (charSequence3 != null || this.f2249il != null) {
                alertController.ILL(-1, charSequence3, this.ILL, null, this.f2249il);
            }
            CharSequence charSequence4 = this.f2236Ll1;
            if (charSequence4 != null || this.f2243lIiI != null) {
                alertController.ILL(-2, charSequence4, this.f2228ILl, null, this.f2243lIiI);
            }
            CharSequence charSequence5 = this.Lil;
            if (charSequence5 != null || this.LlLI1 != null) {
                alertController.ILL(-3, charSequence5, this.f2246llL1ii, null, this.LlLI1);
            }
            if (this.f2250lL != null || this.f2229IIi != null || this.I11L != null) {
                ILil(alertController);
            }
            View view2 = this.f22531;
            if (view2 != null) {
                if (this.f2252LLlI1) {
                    alertController.iIlLiL(view2, this.f2239LlLLL, this.f2244lIII, this.LL1IL, this.f2233L111);
                    return;
                } else {
                    alertController.iIi1(view2);
                    return;
                }
            }
            int i3 = this.f2251l;
            if (i3 != 0) {
                alertController.m3000lIlii(i3);
            }
        }

        public final void ILil(AlertController alertController) {
            ListAdapter l11i;
            RecycleListView recycleListView = (RecycleListView) this.f4765ILil.inflate(alertController.f2204LIll, (ViewGroup) null);
            if (this.llI) {
                l11i = this.f2229IIi == null ? new IL1Iii(this.f4764IL1Iii, alertController.f2211ill, R.id.text1, this.f2250lL, recycleListView) : new ILil(this.f4764IL1Iii, this.f2229IIi, false, recycleListView, alertController);
            } else {
                int i = this.f2242l1IIi1 ? alertController.f2225 : alertController.f2202L11;
                if (this.f2229IIi != null) {
                    l11i = new SimpleCursorAdapter(this.f4764IL1Iii, i, this.f2229IIi, new String[]{this.f2234LIll}, new int[]{R.id.text1});
                } else {
                    l11i = this.I11L;
                    if (l11i == null) {
                        l11i = new L11I(this.f4764IL1Iii, i, R.id.text1, this.f2250lL);
                    }
                }
            }
            lLi1LL lli1ll = this.f2235LlIl;
            if (lli1ll != null) {
                lli1ll.IL1Iii(recycleListView);
            }
            alertController.f2212l1IIi1 = l11i;
            alertController.f2207L1l = this.f2237L1l;
            if (this.llliI != null) {
                recycleListView.setOnItemClickListener(new I1I(alertController));
            } else if (this.f2248iILLl != null) {
                recycleListView.setOnItemClickListener(new IL(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2232L11;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f2242l1IIi1) {
                recycleListView.setChoiceMode(1);
            } else if (this.llI) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f2210iILLL1 = recycleListView;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ View f4776I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ View f4777ILil;

        public lLi1LL(View view, View view2) {
            this.f4777ILil = view;
            this.f4776I1I = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.m2991lLi1LL(AlertController.this.f2210iILLL1, this.f4777ILil, this.f4776I1I);
        }
    }

    public AlertController(Context context, ILil.ILil.p021Ll1.IL il, Window window) {
        this.f4750IL1Iii = context;
        this.f4751ILil = il;
        this.f4749I1I = window;
        this.f2218lliiI1 = new IiL(il);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ILL.AlertDialog, ILil.ILil.IL1Iii.alertDialogStyle, 0);
        this.f2219iILLl = typedArrayObtainStyledAttributes.getResourceId(ILL.AlertDialog_android_layout, 0);
        this.f2199IIi = typedArrayObtainStyledAttributes.getResourceId(ILL.AlertDialog_buttonPanelSideLayout, 0);
        this.f2204LIll = typedArrayObtainStyledAttributes.getResourceId(ILL.AlertDialog_listLayout, 0);
        this.f2211ill = typedArrayObtainStyledAttributes.getResourceId(ILL.AlertDialog_multiChoiceItemLayout, 0);
        this.f2225 = typedArrayObtainStyledAttributes.getResourceId(ILL.AlertDialog_singleChoiceItemLayout, 0);
        this.f2202L11 = typedArrayObtainStyledAttributes.getResourceId(ILL.AlertDialog_listItemLayout, 0);
        this.f2205LlIl = typedArrayObtainStyledAttributes.getBoolean(ILL.AlertDialog_showTitle, true);
        this.f2200IL = typedArrayObtainStyledAttributes.getDimensionPixelSize(ILL.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        il.supportRequestWindowFeature(1);
    }

    public static boolean IL1Iii(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (IL1Iii(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static void m2991lLi1LL(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public static boolean m29921(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(ILil.ILil.IL1Iii.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public final void I11L(ViewGroup viewGroup) {
        View viewInflate = this.f2201IiL;
        if (viewInflate == null) {
            viewInflate = this.f2208L11I != 0 ? LayoutInflater.from(this.f4750IL1Iii).inflate(this.f2208L11I, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !IL1Iii(viewInflate)) {
            this.f4749I1I.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f4749I1I.findViewById(ILil.ILil.iILLL1.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f2198ILl) {
            frameLayout.setPadding(this.f2220il, this.ILL, this.f2206Ll1, this.f2213lIiI);
        }
        if (this.f2210iILLL1 != null) {
            ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f4878IL1Iii = 0.0f;
        }
    }

    public final void I11li1(ViewGroup viewGroup) {
        int i;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.Lil = button;
        button.setOnClickListener(this.LLL);
        if (TextUtils.isEmpty(this.LlLI1) && this.f2215lIlii == null) {
            this.Lil.setVisibility(8);
            i = 0;
        } else {
            this.Lil.setText(this.LlLI1);
            Drawable drawable = this.f2215lIlii;
            if (drawable != null) {
                int i2 = this.f2200IL;
                drawable.setBounds(0, 0, i2, i2);
                this.Lil.setCompoundDrawables(this.f2215lIlii, null, null, null);
            }
            this.Lil.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.iIi1 = button2;
        button2.setOnClickListener(this.LLL);
        if (TextUtils.isEmpty(this.iIlLiL) && this.f2221lL == null) {
            this.iIi1.setVisibility(8);
        } else {
            this.iIi1.setText(this.iIlLiL);
            Drawable drawable2 = this.f2221lL;
            if (drawable2 != null) {
                int i3 = this.f2200IL;
                drawable2.setBounds(0, 0, i3, i3);
                this.iIi1.setCompoundDrawables(this.f2221lL, null, null, null);
            }
            this.iIi1.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.I11L = button3;
        button3.setOnClickListener(this.LLL);
        if (TextUtils.isEmpty(this.llliI) && this.f22241 == null) {
            this.I11L.setVisibility(8);
        } else {
            this.I11L.setText(this.llliI);
            Drawable drawable3 = this.f2215lIlii;
            if (drawable3 != null) {
                int i4 = this.f2200IL;
                drawable3.setBounds(0, 0, i4, i4);
                this.Lil.setCompoundDrawables(this.f2215lIlii, null, null, null);
            }
            this.I11L.setVisibility(0);
            i |= 4;
        }
        if (m29921(this.f4750IL1Iii)) {
            if (i == 1) {
                ILil(this.Lil);
            } else if (i == 2) {
                ILil(this.iIi1);
            } else if (i == 4) {
                ILil(this.I11L);
            }
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public int I1I(int i) {
        TypedValue typedValue = new TypedValue();
        this.f4750IL1Iii.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void ILL(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f2218lliiI1.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.llliI = charSequence;
            this.f2222l = message;
            this.f22241 = drawable;
        } else if (i == -2) {
            this.iIlLiL = charSequence;
            this.I11li1 = message;
            this.f2221lL = drawable;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.LlLI1 = charSequence;
            this.f2216llL1ii = message;
            this.f2215lIlii = drawable;
        }
    }

    public final void ILil(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m2993ILl(Drawable drawable) {
        this.LL1IL = drawable;
        this.f2214lIII = 0;
        ImageView imageView = this.f2203L111;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f2203L111.setImageDrawable(drawable);
            }
        }
    }

    public void Ilil() {
        this.f4751ILil.setContentView(m3002il());
        m3004l();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ListView m2994IL() {
        return this.f2210iILLL1;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean m2995IiL(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2209LlLLL;
        return nestedScrollView != null && nestedScrollView.ILL(keyEvent);
    }

    public void Lil(CharSequence charSequence) {
        this.f2217lLi1LL = charSequence;
        TextView textView = this.f26;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void LlLI1(ViewGroup viewGroup, View view, int i, int i2) {
        View viewFindViewById = this.f4749I1I.findViewById(ILil.ILil.iILLL1.scrollIndicatorUp);
        View viewFindViewById2 = this.f4749I1I.findViewById(ILil.ILil.iILLL1.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            iIlLiL.ILI1Ll(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f2217lLi1LL != null) {
            this.f2209LlLLL.setOnScrollChangeListener(new ILil(this, viewFindViewById, viewFindViewById2));
            this.f2209LlLLL.post(new I1I(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f2210iILLL1;
        if (listView != null) {
            listView.setOnScrollListener(new IL(this, viewFindViewById, viewFindViewById2));
            this.f2210iILLL1.post(new lLi1LL(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m2996Ll1(View view) {
        this.llI = view;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final ViewGroup m2997L11I(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public void iIi1(View view) {
        this.f2201IiL = view;
        this.f2208L11I = 0;
        this.f2198ILl = false;
    }

    public void iIlLiL(View view, int i, int i2, int i3, int i4) {
        this.f2201IiL = view;
        this.f2208L11I = 0;
        this.f2198ILl = true;
        this.f2220il = i;
        this.ILL = i2;
        this.f2206Ll1 = i3;
        this.f2213lIiI = i4;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean m2998iILLL1(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2209LlLLL;
        return nestedScrollView != null && nestedScrollView.ILL(keyEvent);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m2999lIiI(int i) {
        this.LL1IL = null;
        this.f2214lIII = i;
        ImageView imageView = this.f2203L111;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f2203L111.setImageResource(this.f2214lIII);
            }
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void m3000lIlii(int i) {
        this.f2201IiL = null;
        this.f2208L11I = i;
        this.f2198ILl = false;
    }

    public final void llliI(ViewGroup viewGroup) {
        if (this.llI != null) {
            viewGroup.addView(this.llI, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f4749I1I.findViewById(ILil.ILil.iILLL1.title_template).setVisibility(8);
            return;
        }
        this.f2203L111 = (ImageView) this.f4749I1I.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f4752Ilil)) || !this.f2205LlIl) {
            this.f4749I1I.findViewById(ILil.ILil.iILLL1.title_template).setVisibility(8);
            this.f2203L111.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f4749I1I.findViewById(ILil.ILil.iILLL1.alertTitle);
        this.f2223LLlI1 = textView;
        textView.setText(this.f4752Ilil);
        int i = this.f2214lIII;
        if (i != 0) {
            this.f2203L111.setImageResource(i);
            return;
        }
        Drawable drawable = this.LL1IL;
        if (drawable != null) {
            this.f2203L111.setImageDrawable(drawable);
        } else {
            this.f2223LLlI1.setPadding(this.f2203L111.getPaddingLeft(), this.f2203L111.getPaddingTop(), this.f2203L111.getPaddingRight(), this.f2203L111.getPaddingBottom());
            this.f2203L111.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void m3001llL1ii(CharSequence charSequence) {
        this.f4752Ilil = charSequence;
        TextView textView = this.f2223LLlI1;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final int m3002il() {
        int i = this.f2199IIi;
        if (i == 0) {
            return this.f2219iILLl;
        }
        return this.f2197IIiI == 1 ? i : this.f2219iILLl;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public final void m3003lL(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f4749I1I.findViewById(ILil.ILil.iILLL1.scrollView);
        this.f2209LlLLL = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f2209LlLLL.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f26 = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f2217lLi1LL;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f2209LlLLL.removeView(this.f26);
        if (this.f2210iILLL1 == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f2209LlLLL.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f2209LlLLL);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f2210iILLL1, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final void m3004l() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f4749I1I.findViewById(ILil.ILil.iILLL1.parentPanel);
        int i = ILil.ILil.iILLL1.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i);
        int i2 = ILil.ILil.iILLL1.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i2);
        int i3 = ILil.ILil.iILLL1.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i3);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(ILil.ILil.iILLL1.customPanel);
        I11L(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i);
        View viewFindViewById8 = viewGroup.findViewById(i2);
        View viewFindViewById9 = viewGroup.findViewById(i3);
        ViewGroup viewGroupM2997L11I = m2997L11I(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM2997L11I2 = m2997L11I(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM2997L11I3 = m2997L11I(viewFindViewById9, viewFindViewById6);
        m3003lL(viewGroupM2997L11I2);
        I11li1(viewGroupM2997L11I3);
        llliI(viewGroupM2997L11I);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupM2997L11I == null || viewGroupM2997L11I.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupM2997L11I3 == null || viewGroupM2997L11I3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupM2997L11I2 != null && (viewFindViewById2 = viewGroupM2997L11I2.findViewById(ILil.ILil.iILLL1.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.f2209LlLLL;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f2217lLi1LL == null && this.f2210iILLL1 == null) ? null : viewGroupM2997L11I.findViewById(ILil.ILil.iILLL1.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM2997L11I2 != null && (viewFindViewById = viewGroupM2997L11I2.findViewById(ILil.ILil.iILLL1.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f2210iILLL1;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).IL1Iii(z2, z3);
        }
        if (!z) {
            View view = this.f2210iILLL1;
            if (view == null) {
                view = this.f2209LlLLL;
            }
            if (view != null) {
                LlLI1(viewGroupM2997L11I2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f2210iILLL1;
        if (listView2 == null || (listAdapter = this.f2212l1IIi1) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i4 = this.f2207L1l;
        if (i4 > -1) {
            listView2.setItemChecked(i4, true);
            listView2.setSelection(i4);
        }
    }
}
