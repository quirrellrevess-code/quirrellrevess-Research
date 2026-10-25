package ILil.ILil.p024llL1ii;

import ILil.ILil.p023lIlii.llI;
import ILil.ILil.p023lIlii.llL1ii;
import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.ILL;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: SupportMenuInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends MenuInflater {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Class<?>[] f3928Ilil;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static final Class<?>[] f1526lLi1LL;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Context f3929I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Object[] f3930IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Object[] f3931ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object f1527IL;

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: SupportMenuInflater.java */
    public static class IL1Iii implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public static final Class<?>[] f3932I1I = {MenuItem.class};

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Object f3933IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Method f3934ILil;

        public IL1Iii(Object obj, String str) {
            this.f3933IL1Iii = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f3934ILil = cls.getMethod(str, f3932I1I);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f3934ILil.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f3934ILil.invoke(this.f3933IL1Iii, menuItem)).booleanValue();
                }
                this.f3934ILil.invoke(this.f3933IL1Iii, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILil.ll丨L1ii.I丨iL$ILil */
    /* JADX INFO: compiled from: SupportMenuInflater.java */
    public class ILil {
        public int I11L;
        public boolean I11li1;

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3935I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public Menu f3936IL1Iii;
        public CharSequence ILL;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public int f3937ILil;

        /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
        public char f1528ILl;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f3938Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1529IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public boolean f1530IiL;
        public CharSequence LL1IL;
        public int Lil;
        public char LlLI1;

        /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
        public CharSequence f1532Ll1;

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public int f1533L11I;

        /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
        public ILil.p028IiL.p029ILl.ILil f1534LlLLL;
        public boolean iIi1;
        public boolean iIlLiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public boolean f1535iILLL1;

        /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
        public int f1536lIiI;

        /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
        public CharSequence f1537lIII;

        /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
        public int f1538lIlii;
        public String llliI;

        /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
        public int f1539llL1ii;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f1540lLi1LL;

        /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
        public int f1541il;

        /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
        public int f1542lL;

        /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
        public String f1543l;

        /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
        public String f15451;

        /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
        public ColorStateList f1531L111 = null;

        /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
        public PorterDuff.Mode f1544LLlI1 = null;

        public ILil(Menu menu) {
            this.f3936IL1Iii = menu;
            m1921IiL();
        }

        public final char I1I(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public void IL1Iii() {
            this.f1530IiL = true;
            m1922L11I(this.f3936IL1Iii.add(this.f3937ILil, this.f1533L11I, this.f1541il, this.ILL));
        }

        public SubMenu ILil() {
            this.f1530IiL = true;
            SubMenu subMenuAddSubMenu = this.f3936IL1Iii.addSubMenu(this.f3937ILil, this.f1533L11I, this.f1541il, this.ILL);
            m1922L11I(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final <T> T Ilil(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, IiL.this.f3929I1I.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public boolean m1920IL() {
            return this.f1530IiL;
        }

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public void m1921IiL() {
            this.f3937ILil = 0;
            this.f3935I1I = 0;
            this.f1529IL = 0;
            this.f3938Ilil = 0;
            this.f1540lLi1LL = true;
            this.f1535iILLL1 = true;
        }

        /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
        public final void m1922L11I(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.iIi1).setVisible(this.iIlLiL).setEnabled(this.I11li1).setCheckable(this.f1538lIlii >= 1).setTitleCondensed(this.f1532Ll1).setIcon(this.f1536lIiI);
            int i = this.f1542lL;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f15451 != null) {
                if (IiL.this.f3929I1I.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new IL1Iii(IiL.this.ILil(), this.f15451));
            }
            boolean z2 = menuItem instanceof C0629il;
            if (z2) {
            }
            if (this.f1538lIlii >= 2) {
                if (z2) {
                    ((C0629il) menuItem).iIlLiL(true);
                } else if (menuItem instanceof ILL) {
                    ((ILL) menuItem).m1864IiL(true);
                }
            }
            String str = this.llliI;
            if (str != null) {
                menuItem.setActionView((View) Ilil(str, IiL.f3928Ilil, IiL.this.f3930IL1Iii));
                z = true;
            }
            int i2 = this.I11L;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            ILil.p028IiL.p029ILl.ILil iLil = this.f1534LlLLL;
            if (iLil != null) {
                ILil.p028IiL.p029ILl.IiL.IL1Iii(menuItem, iLil);
            }
            ILil.p028IiL.p029ILl.IiL.I1I(menuItem, this.f1537lIII);
            ILil.p028IiL.p029ILl.IiL.m2042iILLL1(menuItem, this.LL1IL);
            ILil.p028IiL.p029ILl.IiL.ILil(menuItem, this.f1528ILl, this.Lil);
            ILil.p028IiL.p029ILl.IiL.m2043lLi1LL(menuItem, this.LlLI1, this.f1539llL1ii);
            PorterDuff.Mode mode = this.f1544LLlI1;
            if (mode != null) {
                ILil.p028IiL.p029ILl.IiL.Ilil(menuItem, mode);
            }
            ColorStateList colorStateList = this.f1531L111;
            if (colorStateList != null) {
                ILil.p028IiL.p029ILl.IiL.m2041IL(menuItem, colorStateList);
            }
        }

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public void m1923iILLL1(AttributeSet attributeSet) {
            llI lliIIlLiL = llI.iIlLiL(IiL.this.f3929I1I, attributeSet, ILil.ILil.ILL.MenuItem);
            this.f1533L11I = lliIIlLiL.m1822ILl(ILil.ILil.ILL.MenuItem_android_id, 0);
            this.f1541il = (lliIIlLiL.ILL(ILil.ILil.ILL.MenuItem_android_menuCategory, this.f3935I1I) & (-65536)) | (lliIIlLiL.ILL(ILil.ILil.ILL.MenuItem_android_orderInCategory, this.f1529IL) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.ILL = lliIIlLiL.LlLI1(ILil.ILil.ILL.MenuItem_android_title);
            this.f1532Ll1 = lliIIlLiL.LlLI1(ILil.ILil.ILL.MenuItem_android_titleCondensed);
            this.f1536lIiI = lliIIlLiL.m1822ILl(ILil.ILil.ILL.MenuItem_android_icon, 0);
            this.f1528ILl = I1I(lliIIlLiL.Lil(ILil.ILil.ILL.MenuItem_android_alphabeticShortcut));
            this.Lil = lliIIlLiL.ILL(ILil.ILil.ILL.MenuItem_alphabeticModifiers, 4096);
            this.LlLI1 = I1I(lliIIlLiL.Lil(ILil.ILil.ILL.MenuItem_android_numericShortcut));
            this.f1539llL1ii = lliIIlLiL.ILL(ILil.ILil.ILL.MenuItem_numericModifiers, 4096);
            int i = ILil.ILil.ILL.MenuItem_android_checkable;
            if (lliIIlLiL.m1829lIlii(i)) {
                this.f1538lIlii = lliIIlLiL.IL1Iii(i, false) ? 1 : 0;
            } else {
                this.f1538lIlii = this.f3938Ilil;
            }
            this.iIi1 = lliIIlLiL.IL1Iii(ILil.ILil.ILL.MenuItem_android_checked, false);
            this.iIlLiL = lliIIlLiL.IL1Iii(ILil.ILil.ILL.MenuItem_android_visible, this.f1540lLi1LL);
            this.I11li1 = lliIIlLiL.IL1Iii(ILil.ILil.ILL.MenuItem_android_enabled, this.f1535iILLL1);
            this.f1542lL = lliIIlLiL.ILL(ILil.ILil.ILL.MenuItem_showAsAction, -1);
            this.f15451 = lliIIlLiL.Lil(ILil.ILil.ILL.MenuItem_android_onClick);
            this.I11L = lliIIlLiL.m1822ILl(ILil.ILil.ILL.MenuItem_actionLayout, 0);
            this.llliI = lliIIlLiL.Lil(ILil.ILil.ILL.MenuItem_actionViewClass);
            String strLil = lliIIlLiL.Lil(ILil.ILil.ILL.MenuItem_actionProviderClass);
            this.f1543l = strLil;
            boolean z = strLil != null;
            if (z && this.I11L == 0 && this.llliI == null) {
                this.f1534LlLLL = (ILil.p028IiL.p029ILl.ILil) Ilil(strLil, IiL.f1526lLi1LL, IiL.this.f3931ILil);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1534LlLLL = null;
            }
            this.f1537lIII = lliIIlLiL.LlLI1(ILil.ILil.ILL.MenuItem_contentDescription);
            this.LL1IL = lliIIlLiL.LlLI1(ILil.ILil.ILL.MenuItem_tooltipText);
            int i2 = ILil.ILil.ILL.MenuItem_iconTintMode;
            if (lliIIlLiL.m1829lIlii(i2)) {
                this.f1544LLlI1 = llL1ii.Ilil(lliIIlLiL.ILL(i2, -1), this.f1544LLlI1);
            } else {
                this.f1544LLlI1 = null;
            }
            int i3 = ILil.ILil.ILL.MenuItem_iconTint;
            if (lliIIlLiL.m1829lIlii(i3)) {
                this.f1531L111 = lliIIlLiL.I1I(i3);
            } else {
                this.f1531L111 = null;
            }
            lliIIlLiL.m1833lL();
            this.f1530IiL = false;
        }

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public void m1924lLi1LL(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = IiL.this.f3929I1I.obtainStyledAttributes(attributeSet, ILil.ILil.ILL.MenuGroup);
            this.f3937ILil = typedArrayObtainStyledAttributes.getResourceId(ILil.ILil.ILL.MenuGroup_android_id, 0);
            this.f3935I1I = typedArrayObtainStyledAttributes.getInt(ILil.ILil.ILL.MenuGroup_android_menuCategory, 0);
            this.f1529IL = typedArrayObtainStyledAttributes.getInt(ILil.ILil.ILL.MenuGroup_android_orderInCategory, 0);
            this.f3938Ilil = typedArrayObtainStyledAttributes.getInt(ILil.ILil.ILL.MenuGroup_android_checkableBehavior, 0);
            this.f1540lLi1LL = typedArrayObtainStyledAttributes.getBoolean(ILil.ILil.ILL.MenuGroup_android_visible, true);
            this.f1535iILLL1 = typedArrayObtainStyledAttributes.getBoolean(ILil.ILil.ILL.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f3928Ilil = clsArr;
        f1526lLi1LL = clsArr;
    }

    public IiL(Context context) {
        super(context);
        this.f3929I1I = context;
        Object[] objArr = {context};
        this.f3930IL1Iii = objArr;
        this.f3931ILil = objArr;
    }

    public final void I1I(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ILil iLil = new ILil(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        iLil.m1921IiL();
                    } else if (name2.equals("item")) {
                        if (!iLil.m1920IL()) {
                            ILil.p028IiL.p029ILl.ILil iLil2 = iLil.f1534LlLLL;
                            if (iLil2 == null || !iLil2.IL1Iii()) {
                                iLil.IL1Iii();
                            } else {
                                iLil.ILil();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    iLil.m1924lLi1LL(attributeSet);
                } else if (name3.equals("item")) {
                    iLil.m1923iILLL1(attributeSet);
                } else if (name3.equals("menu")) {
                    I1I(xmlPullParser, attributeSet, iLil.ILil());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public final Object IL1Iii(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? IL1Iii(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object ILil() {
        if (this.f1527IL == null) {
            this.f1527IL = IL1Iii(this.f3929I1I);
        }
        return this.f1527IL;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof ILil.p028IiL.p030IiL.IL1Iii.IL1Iii)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f3929I1I.getResources().getLayout(i);
                    I1I(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
