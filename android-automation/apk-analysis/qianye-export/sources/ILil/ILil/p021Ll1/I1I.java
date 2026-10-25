package ILil.ILil.p021Ll1;

import ILil.p065Ilil.lIiI;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: AppCompatDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I1I {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static int f3717ILil = -100;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final lIiI<WeakReference<I1I>> f3716I1I = new lIiI<>();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final Object f1307IL = new Object();

    public static I1I I1I(Activity activity, ILil iLil) {
        return new AppCompatDelegateImpl(activity, iLil);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static I1I m1638IL(Dialog dialog, ILil iLil) {
        return new AppCompatDelegateImpl(dialog, iLil);
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static void m1639Ll1(I1I i1i) {
        synchronized (f1307IL) {
            m1642lL(i1i);
            f3716I1I.add(new WeakReference<>(i1i));
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static void m1640lIiI(I1I i1i) {
        synchronized (f1307IL) {
            m1642lL(i1i);
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static int m1641lLi1LL() {
        return f3717ILil;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public static void m1642lL(I1I i1i) {
        synchronized (f1307IL) {
            Iterator<WeakReference<I1I>> it = f3716I1I.iterator();
            while (it.hasNext()) {
                I1I i1i2 = it.next().get();
                if (i1i2 == i1i || i1i2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract boolean I11L(int i);

    public abstract void I11li1();

    public abstract void IL1Iii(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void ILL();

    public void ILil(Context context) {
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public abstract void mo1643ILl(Configuration configuration);

    public abstract <T extends View> T Ilil(int i);

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public abstract MenuInflater mo1644IiL();

    public abstract void Lil(Bundle bundle);

    public abstract void LlLI1();

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public abstract ActionBar mo1645L11I();

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void mo1646LlLLL(int i) {
    }

    public abstract void iIi1(Bundle bundle);

    public abstract void iIlLiL();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int mo1647iILLL1() {
        return -100;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public abstract void mo1648lIII(CharSequence charSequence);

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public abstract void mo1649lIlii();

    public abstract void llliI(int i);

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public abstract void mo1650llL1ii(Bundle bundle);

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public abstract void mo1651il();

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public abstract void mo1652l(View view);

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public abstract void mo16531(View view, ViewGroup.LayoutParams layoutParams);
}
