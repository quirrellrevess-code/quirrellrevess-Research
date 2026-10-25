package I1I.I1I.ILil;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: I1I.I1I.ILil.LlIl丨, reason: invalid class name */
/* JADX INFO: compiled from: PointersState.java */
/* JADX INFO: loaded from: classes.dex */
public class LlIl {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final List<L11> f3159IL1Iii = new ArrayList();

    public int I1I(long j) {
        int iM922IL = m922IL(j);
        if (iM922IL != -1) {
            return iM922IL;
        }
        if (this.f3159IL1Iii.size() >= 10) {
            return -1;
        }
        int iM924lLi1LL = m924lLi1LL();
        if (iM924lLi1LL == -1) {
            throw new AssertionError(I1I.IL1Iii.IL1Iii(new byte[]{65, 92, 8, 87, 64, 4, 67, 64, 79, 74, 93, 27, 84, 27, 72, 25, 8, 65, 92, 82, 25, 127, 93, 15, 86, 86, 19, 74, 20, 8, 92, 67, 13, 80, 81, 18, 17, 71, 9, 88, 64, 65, 80, 19, 13, 86, 87, 0, 93, 19, 8, 93, 20, 8, 66, 19, 0, 79, 85, 8, 93, 82, 3, 85, 81}, I1I.IL1Iii.IL1Iii(new byte[]{84, 11, 4, 92, 12, 83}, I1I.IL1Iii.IL1Iii(new byte[]{7, 91, 4, 6, 94, 11}, "bcacf9"))));
        }
        this.f3159IL1Iii.add(new L11(j, iM924lLi1LL));
        return this.f3159IL1Iii.size() - 1;
    }

    public final void IL1Iii() {
        for (int size = this.f3159IL1Iii.size() - 1; size >= 0; size--) {
            if (this.f3159IL1Iii.get(size).Ilil()) {
                this.f3159IL1Iii.remove(size);
            }
        }
    }

    public L11 ILil(int i) {
        return this.f3159IL1Iii.get(i);
    }

    public final boolean Ilil(int i) {
        for (int i2 = 0; i2 < this.f3159IL1Iii.size(); i2++) {
            if (this.f3159IL1Iii.get(i2).ILil() == i) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final int m922IL(long j) {
        for (int i = 0; i < this.f3159IL1Iii.size(); i++) {
            if (this.f3159IL1Iii.get(i).IL1Iii() == j) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int m923iILLL1(MotionEvent.PointerProperties[] pointerPropertiesArr, MotionEvent.PointerCoords[] pointerCoordsArr) {
        int size = this.f3159IL1Iii.size();
        for (int i = 0; i < size; i++) {
            L11 l11 = this.f3159IL1Iii.get(i);
            pointerPropertiesArr[i].id = l11.ILil();
            C0531 c0531I1I = l11.I1I();
            pointerCoordsArr[i].x = c0531I1I.IL1Iii();
            pointerCoordsArr[i].y = c0531I1I.ILil();
            pointerCoordsArr[i].pressure = l11.m895IL();
        }
        IL1Iii();
        return size;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final int m924lLi1LL() {
        for (int i = 0; i < 10; i++) {
            if (Ilil(i)) {
                return i;
            }
        }
        return -1;
    }
}
