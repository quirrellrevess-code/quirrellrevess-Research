package I1I.I1I.ILil;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨l丨, reason: invalid class name */
/* JADX INFO: compiled from: IDataTask.java */
/* JADX INFO: loaded from: classes.dex */
public interface l extends IInterface {

    /* JADX INFO: renamed from: I1I.I1I.ILil.丨l丨$IL1Iii */
    /* JADX INFO: compiled from: IDataTask.java */
    public static abstract class IL1Iii extends Binder implements l {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final String f3312ILil = I1I.IL1Iii.IL1Iii(new byte[]{7, 90, 8, 77, 88, 0, 13, 91, 75, 6, 91, 6, 13, 91, 0, 77, 124, 37, 5, 65, 4, 55, 84, 18, 15}, I1I.IL1Iii.IL1Iii(new byte[]{0, 1, 92, 83, 80, 81}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 95, 8, 85, 85}, "edf80e")));

        /* JADX INFO: renamed from: I1I.I1I.ILil.丨l丨$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDataTask.java */
        public static class C0529IL1Iii implements l {

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public IBinder f3313ILil;

            public C0529IL1Iii(IBinder iBinder) {
                this.f3313ILil = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3313ILil;
            }
        }

        public IL1Iii() {
            attachInterface(this, I1I.IL1Iii.IL1Iii(new byte[]{91, 10, 12, 77, 85, 5, 81, 11, 79, 6, 86, 3, 81, 11, 4, 77, 113, 32, 89, 17, 0, 55, 89, 23, 83}, I1I.IL1Iii.IL1Iii(new byte[]{90, 93, 81, 91, 0, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 13, 83, 10, 0, 14}, "55c289"))));
        }

        public static l IL1Iii(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f3312ILil);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof l)) ? new C0529IL1Iii(iBinder) : (l) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = f3312ILil;
            if (i == 1) {
                parcel.enforceInterface(str);
                Bundle bundleI1I = I1I(parcel.readInt(), parcel.readLong());
                parcel2.writeNoException();
                if (bundleI1I != null) {
                    parcel2.writeInt(1);
                    bundleI1I.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            long jMo1024iILLL1 = mo1024iILLL1();
            parcel2.writeNoException();
            parcel2.writeLong(jMo1024iILLL1);
            return true;
        }
    }

    Bundle I1I(int i, long j) throws RemoteException;

    /* JADX INFO: renamed from: iI丨LLL1 */
    long mo1024iILLL1() throws RemoteException;
}
