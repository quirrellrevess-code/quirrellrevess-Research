package ILil.ILil.p023lIlii;

import ILil.ILil.ILL;
import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.l;
import ILil.p028IiL.p029ILl.llliI;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: compiled from: AbsActionBarView.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii extends ViewGroup {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Context f3751I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final C0554IL1Iii f3752ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public ActionMenuPresenter f3753Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ActionMenuView f1342IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1343IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public boolean f1344L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public llliI f1345iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1346lLi1LL;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsActionBarView.java */
    public class C0554IL1Iii implements l {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f3755IL1Iii = false;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3756ILil;

        public C0554IL1Iii() {
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void I1I(View view) {
            IL1Iii.super.setVisibility(0);
            this.f3755IL1Iii = false;
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void IL1Iii(View view) {
            this.f3755IL1Iii = true;
        }

        @Override // ILil.p028IiL.p029ILl.l
        public void ILil(View view) {
            if (this.f3755IL1Iii) {
                return;
            }
            IL1Iii iL1Iii = IL1Iii.this;
            iL1Iii.f1345iILLL1 = null;
            IL1Iii.super.setVisibility(this.f3756ILil);
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public C0554IL1Iii m1709IL(llliI lllii, int i) {
            IL1Iii.this.f1345iILLL1 = lllii;
            this.f3756ILil = i;
            return this;
        }
    }

    public IL1Iii(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static int m1707IL(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int I1I(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int Ilil(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return this.f1345iILLL1 != null ? this.f3752ILil.f3756ILil : getVisibility();
    }

    public int getContentHeight() {
        return this.f1346lLi1LL;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public llliI m1708lLi1LL(int i, long j) {
        llliI lllii = this.f1345iILLL1;
        if (lllii != null) {
            lllii.ILil();
        }
        if (i != 0) {
            llliI llliiI1I = iIlLiL.I1I(this);
            llliiI1I.IL1Iii(0.0f);
            llliiI1I.m2158IL(j);
            C0554IL1Iii c0554IL1Iii = this.f3752ILil;
            c0554IL1Iii.m1709IL(llliiI1I, i);
            llliiI1I.m2162lLi1LL(c0554IL1Iii);
            return llliiI1I;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        llliI llliiI1I2 = iIlLiL.I1I(this);
        llliiI1I2.IL1Iii(1.0f);
        llliiI1I2.m2158IL(j);
        C0554IL1Iii c0554IL1Iii2 = this.f3752ILil;
        c0554IL1Iii2.m1709IL(llliiI1I2, i);
        llliiI1I2.m2162lLi1LL(c0554IL1Iii2);
        return llliiI1I2;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, ILL.ActionBar, ILil.ILil.IL1Iii.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(ILL.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f3753Ilil;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.llliI(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1344L11I = false;
        }
        if (!this.f1344L11I) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1344L11I = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1344L11I = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1343IiL = false;
        }
        if (!this.f1343IiL) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1343IiL = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1343IiL = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            llliI lllii = this.f1345iILLL1;
            if (lllii != null) {
                lllii.ILil();
            }
            super.setVisibility(i);
        }
    }

    public IL1Iii(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3752ILil = new C0554IL1Iii();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(ILil.ILil.IL1Iii.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f3751I1I = context;
        } else {
            this.f3751I1I = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
