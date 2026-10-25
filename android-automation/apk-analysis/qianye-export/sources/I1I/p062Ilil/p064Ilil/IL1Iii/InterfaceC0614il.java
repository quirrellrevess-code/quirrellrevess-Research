package I1I.p062Ilil.p064Ilil.IL1Iii;

import android.util.Log;
import android.view.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: I1I.Ilil.Ilil.IL1Iii.丨il, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: OnKeyListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0614il {

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.IL1Iii.丨il$IL1Iii */
    /* JADX INFO: compiled from: OnKeyListener.java */
    public static class IL1Iii implements InterfaceC0614il {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final String f3523ILil = I1I.IL1Iii.IL1Iii(new byte[]{122, 15, 41, 87, 78, 46, 92, 18, 22, 87, 89, 7, 71, 46, 0, 65, 82, 16, 67, 4, 16}, I1I.IL1Iii.IL1Iii(new byte[]{7, 0, 83, 2, 4, 3}, I1I.IL1Iii.IL1Iii(new byte[]{11, 82, 6, 2, 85, 7}, "9372ff")));

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public CopyOnWriteArrayList<InterfaceC0614il> f3524IL1Iii = new CopyOnWriteArrayList<>();

        @Override // I1I.p062Ilil.p064Ilil.IL1Iii.InterfaceC0614il
        public void IL1Iii(int i, KeyEvent keyEvent) {
            for (InterfaceC0614il interfaceC0614il : this.f3524IL1Iii) {
                try {
                    interfaceC0614il.IL1Iii(i, keyEvent);
                } catch (Exception e) {
                    Log.e(f3523ILil, I1I.IL1Iii.IL1Iii(new byte[]{114, 69, 17, 10, 22, 19, 120, 89, 40, 0, 29, 118, 65, 82, 13, 17, 94, 19}, I1I.IL1Iii.IL1Iii(new byte[]{6, 15, 7, 84, 83, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 10, 6, 87, 2, 0}, "02bf51"))) + keyEvent + I1I.IL1Iii.IL1Iii(new byte[]{25, 126, 93, 74, 65, 83, 87, 87, 70, 3, 21}, I1I.IL1Iii.IL1Iii(new byte[]{10, 0, 7, 0, 6, 2}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 87, 15, 87, 12}, "f6d6d8"))) + interfaceC0614il, e);
                }
            }
        }
    }

    void IL1Iii(int i, KeyEvent keyEvent);
}
