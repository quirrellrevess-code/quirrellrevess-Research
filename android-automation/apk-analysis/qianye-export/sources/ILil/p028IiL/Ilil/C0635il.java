package ILil.p028IiL.Ilil;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

/* JADX INFO: renamed from: ILil.I丨iL.Ilil.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: RemoteInput.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0635il {
    public static RemoteInput IL1Iii(C0635il c0635il) {
        return new RemoteInput.Builder(c0635il.m2195IiL()).setLabel(c0635il.m2196iILLL1()).setChoices(c0635il.Ilil()).setAllowFreeFormInput(c0635il.I1I()).addExtras(c0635il.m2197lLi1LL()).build();
    }

    public static RemoteInput[] ILil(C0635il[] c0635ilArr) {
        if (c0635ilArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0635ilArr.length];
        for (int i = 0; i < c0635ilArr.length; i++) {
            remoteInputArr[i] = IL1Iii(c0635ilArr[i]);
        }
        return remoteInputArr;
    }

    public boolean I1I() {
        throw null;
    }

    public CharSequence[] Ilil() {
        throw null;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Set<String> m2194IL() {
        throw null;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public String m2195IiL() {
        throw null;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public CharSequence m2196iILLL1() {
        throw null;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Bundle m2197lLi1LL() {
        throw null;
    }
}
