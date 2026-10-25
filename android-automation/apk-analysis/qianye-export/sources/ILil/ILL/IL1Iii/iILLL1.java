package ILil.ILL.IL1Iii;

import ILil.p028IiL.p034lIiI.L11I;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: FragmentHostCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class iILLL1<E> extends I1I {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Context f3684I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Activity f3685ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final int f3686Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Handler f1264IL;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final L11I f1265lLi1LL;

    public iILLL1(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // ILil.ILL.IL1Iii.I1I
    public View I1I(int i) {
        return null;
    }

    public LayoutInflater ILL() {
        return LayoutInflater.from(this.f3684I1I);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void mo1587ILl(Fragment fragment, String[] strArr, int i) {
    }

    public Activity Ilil() {
        return this.f3685ILil;
    }

    @Override // ILil.ILL.IL1Iii.I1I
    /* JADX INFO: renamed from: I丨L */
    public boolean mo1446IL() {
        return true;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void mo1588IiL(Fragment fragment) {
    }

    public boolean Lil(Fragment fragment) {
        return true;
    }

    public boolean LlLI1(String str) {
        return false;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public int mo1589Ll1() {
        return this.f3686Ilil;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void mo1590L11I(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void iIi1() {
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Handler m1591iILLL1() {
        return this.f1264IL;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean mo1592lIiI() {
        return true;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public void mo1593lIlii(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ILil.p028IiL.Ilil.IL1Iii.m2164ILl(this.f3685ILil, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public void mo1594llL1ii(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f3684I1I.startActivity(intent);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Context m1595lLi1LL() {
        return this.f3684I1I;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public abstract E mo1596il();

    public iILLL1(Activity activity, Context context, Handler handler, int i) {
        this.f1265lLi1LL = new L11I();
        this.f3685ILil = activity;
        L11I.Ilil(context, "context == null");
        this.f3684I1I = context;
        L11I.Ilil(handler, "handler == null");
        this.f1264IL = handler;
        this.f3686Ilil = i;
    }
}
