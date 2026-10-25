package android.view;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IRotationWatcher extends IInterface {

    public static class Default implements IRotationWatcher {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IRotationWatcher
        public void onRotationChanged(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRotationWatcher {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{7, 10, 5, 69, 12, 15, 2, 74, 23, 94, 6, 17, 72, 45, 51, 88, 23, 7, 18, 13, 14, 89, 52, 7, 18, 7, 9, 82, 17}, IL1Iii.IL1Iii(new byte[]{82, 7, 80, 6, 87, 82}, IL1Iii.IL1Iii(new byte[]{0, 91, 8, 0, 86, 87}, "4891bc")));
        public static final int TRANSACTION_onRotationChanged = 1;

        public static class Proxy implements IRotationWatcher {
            public static IRotationWatcher sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{4, 12, 87, 16, 11, 94, 1, 76, 69, 11, 1, 64, 75, 43, 97, 13, 16, 86, 17, 11, 92, 12, 51, 86, 17, 1, 91, 7, 22}, IL1Iii.IL1Iii(new byte[]{3, 0, 7, 87, 93, 83}, IL1Iii.IL1Iii(new byte[]{4, 87, 13, 83, 88, 92}, "b59fa8")));
            }

            @Override // android.view.IRotationWatcher
            public void onRotationChanged(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{4, 10, 82, 20, 14, 81, 1, 74, 64, 15, 4, 79, 75, 45, 100, 9, 21, 89, 17, 13, 89, 8, 54, 89, 17, 7, 94, 3, 19}, IL1Iii.IL1Iii(new byte[]{0, 86, 7, 80, 5, 15}, IL1Iii.IL1Iii(new byte[]{85, 87, 87, 82, 81, 84}, "0efd5c"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().onRotationChanged(i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{84, 12, 84, 66, 10, 92, 81, 76, 70, 89, 0, 66, 27, 43, 98, 95, 17, 84, 65, 11, 95, 94, 50, 84, 65, 1, 88, 85, 23}, IL1Iii.IL1Iii(new byte[]{3, 4, 81, 8, 85, 87}, IL1Iii.IL1Iii(new byte[]{7, 3, 4, 94, 86, 85}, "1eeff7"))));
        }

        public static IRotationWatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRotationWatcher)) ? new Proxy(iBinder) : (IRotationWatcher) iInterfaceQueryLocalInterface;
        }

        public static IRotationWatcher getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRotationWatcher iRotationWatcher) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{68, 80, 18, 117, 83, 82, 86, 64, 10, 69, 127, 89, 71, 89, 78, 24, 22, 87, 86, 89, 10, 84, 82, 20, 67, 66, 15, 82, 83}, IL1Iii.IL1Iii(new byte[]{2, 3, 85, 85, 5, 13}, IL1Iii.IL1Iii(new byte[]{7, 85, 80, 5, 10, 9}, "2cca90"))));
            }
            if (iRotationWatcher == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRotationWatcher;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            onRotationChanged(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onRotationChanged(int i) throws RemoteException;
}
