package I1I.I1I.ILil;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ITsEventListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface LL1IL extends IInterface {

    /* JADX INFO: compiled from: ITsEventListener.java */
    public static abstract class IL1Iii extends Binder implements LL1IL {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final String f3150ILil = I1I.IL1Iii.IL1Iii(new byte[]{85, 13, 89, 26, 88, 7, 95, 12, 26, 81, 91, 1, 95, 12, 81, 26, 124, 50, 69, 39, 66, 81, 91, 18, 122, 11, 71, 64, 80, 8, 83, 16}, I1I.IL1Iii.IL1Iii(new byte[]{14, 82, 7, 5, 86, 85}, I1I.IL1Iii.IL1Iii(new byte[]{89, 85, 81, 0, 80, 82}, "aeb13a")));

        /* JADX INFO: renamed from: I1I.I1I.ILil.LL1IL$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ITsEventListener.java */
        public static class C0524IL1Iii implements LL1IL {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public static LL1IL f3151I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public IBinder f3152ILil;

            public C0524IL1Iii(IBinder iBinder) {
                this.f3152ILil = iBinder;
            }

            @Override // I1I.I1I.ILil.LL1IL
            /* JADX INFO: renamed from: L丨1丨1丨I */
            public void mo917L11I(int i, int i2, int i3, int i4, int i5) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{85, 93, 85, 30, 15, 3, 95, 92, 22, 85, 12, 5, 95, 92, 93, 30, 43, 54, 69, 119, 78, 85, 12, 22, 122, 91, 75, 68, 7, 12, 83, 64}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 15, 9, 87, 82}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 6, 91, 84, 1}, "261ba1"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    try {
                        if (this.f3152ILil.transact(1, parcelObtain, null, 1) || IL1Iii.m918IL() == null) {
                            parcelObtain.recycle();
                        } else {
                            IL1Iii.m918IL().mo917L11I(i, i2, i3, i4, i5);
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3152ILil;
            }
        }

        public IL1Iii() {
            attachInterface(this, I1I.IL1Iii.IL1Iii(new byte[]{86, 92, 90, 72, 12, 82, 92, 93, 25, 3, 15, 84, 92, 93, 82, 72, 40, 103, 70, 118, 65, 3, 15, 71, 121, 90, 68, 18, 4, 93, 80, 65}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 0, 94, 85, 4}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 84, 93, 1, 2}, "2cce55"))));
        }

        public static LL1IL IL1Iii(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f3150ILil);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof LL1IL)) ? new C0524IL1Iii(iBinder) : (LL1IL) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static LL1IL m918IL() {
            return C0524IL1Iii.f3151I1I;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = f3150ILil;
            if (i == 1) {
                parcel.enforceInterface(str);
                mo917L11I(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(str);
            return true;
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    void mo917L11I(int i, int i2, int i3, int i4, int i5) throws RemoteException;
}
