package ILil.ILL.IL1Iii;

import ILil.p042lIiI.IL;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransaction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3619I1I;
    public CharSequence ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f3621ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ArrayList<String> f1203ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f3622Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public int f1204IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public boolean f1205IiL;
    public ArrayList<String> Lil;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int f1206Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public String f1207L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1208iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public CharSequence f1209lIiI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public ArrayList<Runnable> f1210llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1211lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public int f1212il;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ArrayList<IL1Iii> f3620IL1Iii = new ArrayList<>();
    public boolean LlLI1 = false;

    /* JADX INFO: compiled from: FragmentTransaction.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public int f3623I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public int f3624IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public Fragment f3625ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public int f3626Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int f1213IL;

        /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
        public IL.ILil f1214IiL;

        /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
        public IL.ILil f1215iILLL1;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public int f1216lLi1LL;

        public IL1Iii() {
        }

        public IL1Iii(int i, Fragment fragment) {
            this.f3624IL1Iii = i;
            this.f3625ILil = fragment;
            IL.ILil iLil = IL.ILil.RESUMED;
            this.f1215iILLL1 = iLil;
            this.f1214IiL = iLil;
        }
    }

    public ILL I1I(Fragment fragment, String str) {
        ILL(0, fragment, str, 1);
        return this;
    }

    public void ILL(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        m1460IL(new IL1Iii(i2, fragment));
    }

    public ILL ILil(int i, Fragment fragment, String str) {
        ILL(i, fragment, str, 1);
        return this;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public ILL m1459ILl(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        ILL(i, fragment, str, 2);
        return this;
    }

    public ILL Ilil(Fragment fragment) {
        m1460IL(new IL1Iii(7, fragment));
        return this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m1460IL(IL1Iii iL1Iii) {
        this.f3620IL1Iii.add(iL1Iii);
        iL1Iii.f3623I1I = this.f3621ILil;
        iL1Iii.f1213IL = this.f3619I1I;
        iL1Iii.f3626Ilil = this.f1204IL;
        iL1Iii.f1216lLi1LL = this.f3622Ilil;
    }

    /* JADX INFO: renamed from: I丨iL */
    public abstract void mo1448IiL();

    /* JADX INFO: renamed from: Ll丨1 */
    public ILL mo1449Ll1(Fragment fragment) {
        m1460IL(new IL1Iii(3, fragment));
        return this;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I */
    public ILL mo1450L11I(Fragment fragment) {
        m1460IL(new IL1Iii(6, fragment));
        return this;
    }

    /* JADX INFO: renamed from: iI丨LLL1 */
    public abstract int mo1452iILLL1();

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public ILL m1461lIiI(int i, Fragment fragment) {
        m1459ILl(i, fragment, null);
        return this;
    }

    /* JADX INFO: renamed from: l丨Li1LL */
    public abstract int mo1456lLi1LL();

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public ILL m1462il() {
        if (this.f1205IiL) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }
}
