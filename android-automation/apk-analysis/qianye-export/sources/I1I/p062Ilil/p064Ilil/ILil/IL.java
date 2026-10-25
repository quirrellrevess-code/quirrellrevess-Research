package I1I.p062Ilil.p064Ilil.ILil;

import I1I.p062Ilil.p064Ilil.ILil.p011il.I1I;
import I1I.p062Ilil.p064Ilil.ILil.p011il.ILL;
import I1I.p062Ilil.p064Ilil.ILil.p011il.ILil;
import I1I.p062Ilil.p064Ilil.ILil.p011il.IiL;
import I1I.p062Ilil.p064Ilil.ILil.p011il.L11I;
import I1I.p062Ilil.p064Ilil.ILil.p011il.Ll1;
import I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1;
import I1I.p062Ilil.p064Ilil.ILil.p011il.lIlii;
import I1I.p062Ilil.p064Ilil.ILil.p011il.lLi1LL;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: UiGlobalSelector.java */
/* JADX INFO: loaded from: classes.dex */
public class IL {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public I1I.p062Ilil.p064Ilil.ILil.p011il.IL f3539IL1Iii = new I1I.p062Ilil.p064Ilil.ILil.p011il.IL();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Queue<ILL> f3540ILil = new LinkedList();

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.I丨L$IL1Iii */
    /* JADX INFO: compiled from: UiGlobalSelector.java */
    public class IL1Iii extends iILLL1 {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ int f3541IL1Iii;

        public IL1Iii(IL il, int i) {
            this.f3541IL1Iii = i;
        }

        @Override // I1I.p062Ilil.p064Ilil.ILil.p011il.iILLL1
        public boolean ILil(lLi1LL lli1ll) {
            if (Build.VERSION.SDK_INT >= 24) {
                return lli1ll.m1402lIII() == this.f3541IL1Iii;
            }
            return this.f3541IL1Iii == 0;
        }

        public String toString() {
            return I1I.IL1Iii.IL1Iii(new byte[]{84, 66, 84, 20, 80, 12, 87, 127, 71, 7, 92, 16, 24}, I1I.IL1Iii.IL1Iii(new byte[]{82, 0, 87, 1, 91, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 91, 81, 83, 9}, "779318"))) + this.f3541IL1Iii + I1I.IL1Iii.IL1Iii(new byte[]{31}, I1I.IL1Iii.IL1Iii(new byte[]{2, 8, 87, 81, 81, 86}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 82, 83, 0, 2}, "46a720")));
        }
    }

    public IL I11L(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1162lLi1LL, z));
        return this;
    }

    public ArrayList<lLi1LL> I11li1(lLi1LL lli1ll, int i) {
        return this.f3539IL1Iii.ILil(lli1ll, this.f3540ILil, i);
    }

    public IL I1I(int i, int i2, int i3, int i4) {
        this.f3540ILil.add(new ILil(new Rect(i, i2, i3, i4), 2));
        return this;
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public IL mo1324IIiI(String str) {
        this.f3540ILil.add(lIlii.Ilil(str));
        return this;
    }

    public IL IL1Iii(ILL ill) {
        this.f3540ILil.add(ill);
        return this;
    }

    public IL ILL(String str) {
        this.f3540ILil.add(I1I.Ilil(str));
        return this;
    }

    public IL ILil(int i, int i2, int i3, int i4) {
        this.f3540ILil.add(new ILil(new Rect(i, i2, i3, i4), 0));
        return this;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public IL m1325ILl(String str) {
        this.f3540ILil.add(lLi1LL.I1I(str));
        return this;
    }

    public IL Ilil(boolean z) {
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 58}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 85, 80, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 89, 0, 4, 80}, "b78d5c"))), I1I.IL1Iii.IL1Iii(new byte[]{85, 11, 4, 83, 15, 84, 84, 15, 4, 13, 89, 8, 11, 94, 95}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 81, 85, 87, 13}, I1I.IL1Iii.IL1Iii(new byte[]{87, 87, 86, 80, 80, 8}, "3cf5c0"))) + z);
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1156IL, z));
        return this;
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public IL m1326IIi(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1161lIiI, z));
        return this;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public IL m1327IL(int i, int i2, int i3, int i4) {
        this.f3540ILil.add(new ILil(new Rect(i, i2, i3, i4), 1));
        return this;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public IL m1328IiL(String str) {
        this.f3540ILil.add(I1I.IL1Iii(str));
        return this;
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public IL m1329L11(String str) {
        this.f3540ILil.add(lIlii.ILil(str));
        return this;
    }

    /* JADX INFO: renamed from: L11丨丨丨1, reason: contains not printable characters */
    public IL m1330L111(int i) {
        this.f3540ILil.add(new L11I(L11I.f1164IL, i));
        return this;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public IL m1331LIll(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1155ILl, z));
        return this;
    }

    public IL LL1IL(String str) {
        this.f3540ILil.add(IiL.m1418lLi1LL(str));
        return this;
    }

    public IL LLL(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1157IiL, z));
        return this;
    }

    public IL Lil(String str) {
        this.f3540ILil.add(lLi1LL.IL1Iii(str));
        return this;
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public IL m1332LlIl(String str) {
        this.f3540ILil.add(lIlii.I1I(str));
        return this;
    }

    public IL LlLI1(String str) {
        this.f3540ILil.add(lLi1LL.ILil(str));
        return this;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public IL m1333Ll1(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1163il, z));
        return this;
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public IL mo1334L1l(String str) {
        this.f3540ILil.add(Ll1.m1419IL(str));
        return this;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public IL m1335L11I(String str) {
        this.f3540ILil.add(I1I.ILil(str));
        return this;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public IL m1336LlLLL(String str) {
        this.f3540ILil.add(IiL.I1I(str));
        return this;
    }

    public IL iIi1(int i) {
        this.f3540ILil.add(new IL1Iii(this, i));
        return this;
    }

    public IL iIlLiL(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1158Ll1, z));
        return this;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public IL m1337iILLL1(String str) {
        this.f3540ILil.add(I1I.I1I(str));
        return this;
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public IL m1338ill(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1159L11I, z));
        return this;
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public IL m1339l1IIi1(String str) {
        this.f3540ILil.add(Ll1.ILil(str));
        return this;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public IL m1340lIiI(int i) {
        this.f3540ILil.add(new L11I(L11I.f3567I1I, i));
        return this;
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public IL mo1341lIII(String str) {
        this.f3540ILil.add(IiL.Ilil(str));
        return this;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public IL m1342lIlii(String str) {
        this.f3540ILil.add(lLi1LL.Ilil(str));
        return this;
    }

    public IL llI(String str) {
        this.f3540ILil.add(Ll1.IL1Iii(str));
        return this;
    }

    public IL llliI(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f1160iILLL1, z));
        return this;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public IL mo1343llL1ii(String str) {
        this.f3540ILil.add(lLi1LL.m1422IL(str));
        return this;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public IL m1344lLi1LL(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.f3554Ilil, z));
        return this;
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public IL m1345lliiI1(String str) {
        this.f3540ILil.add(lIlii.m1421lLi1LL(str));
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<ILL> it = this.f3540ILil.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(I1I.IL1Iii.IL1Iii(new byte[]{26}, I1I.IL1Iii.IL1Iii(new byte[]{12, 4, 4, 83, 85, 80}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 82, 90, 84, 92}, "8cc9e9"))));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public IL m1346iILLl(String str) {
        this.f3540ILil.add(Ll1.Ilil(str));
        return this;
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public IL mo1347il(String str) {
        this.f3540ILil.add(I1I.m1416IL(str));
        return this;
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public iILLL1 m1348lL(lLi1LL lli1ll, int i) {
        return iILLL1.m1371IL(I11li1(lli1ll, i));
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public IL m1349l(String str) {
        this.f3540ILil.add(IiL.m1417IL(str));
        return this;
    }

    /* JADX INFO: renamed from: 丨丨 */
    public IL m28(String str) {
        this.f3540ILil.add(Ll1.I1I(str));
        return this;
    }

    /* JADX INFO: renamed from: 丨丨LLlI1, reason: contains not printable characters */
    public IL m1350LLlI1(boolean z) {
        this.f3540ILil.add(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.I1I(I1I.p062Ilil.p064Ilil.ILil.p011il.IL1Iii.ILL, z));
        return this;
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public IL m13511(String str) {
        this.f3540ILil.add(IiL.ILil(str));
        return this;
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public IL m1352(String str) {
        this.f3540ILil.add(lIlii.m1420IL(str));
        return this;
    }
}
