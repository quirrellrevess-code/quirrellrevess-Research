package repeackage.com.samsung.android.deviceidservice;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdService extends IInterface {

    public static class Default implements IDeviceIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.samsung.android.deviceidservice.IDeviceIdService
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.samsung.android.deviceidservice.IDeviceIdService
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.samsung.android.deviceidservice.IDeviceIdService
        public String getVAID(String str) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdService {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{7, 11, 9, 77, 66, 87, 9, 23, 17, 13, 86, 24, 5, 10, 0, 17, 94, 95, 0, 74, 0, 6, 71, 95, 7, 1, 13, 7, 66, 83, 22, 18, 13, 0, 84, 24, 45, 32, 1, 21, 88, 85, 1, 45, 0, 48, 84, 68, 18, 13, 7, 6}, IL1Iii.IL1Iii(new byte[]{80, 81, 7, 84, 6, 3}, IL1Iii.IL1Iii(new byte[]{80, 0, 85, 2, 7, 81}, "d5650d")));
        public static final int TRANSACTION_getAAID = 3;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getVAID = 2;

        public static class Proxy implements IDeviceIdService {
            public static IDeviceIdService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.samsung.android.deviceidservice.IDeviceIdService
            public String getAAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{86, 91, 12, 76, 70, 0, 88, 71, 20, 12, 82, 79, 84, 90, 5, 16, 90, 8, 81, 26, 5, 7, 67, 8, 86, 81, 8, 6, 70, 4, 71, 66, 8, 1, 80, 79, 124, 112, 4, 20, 92, 2, 80, 125, 5, 49, 80, 19, 67, 93, 2, 7}, IL1Iii.IL1Iii(new byte[]{12, 3, 7, 87, 4, 3}, IL1Iii.IL1Iii(new byte[]{91, 7, 86, 80, 87, 91}, "b00ef9"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String aaid = Stub.getDefaultImpl().getAAID(str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return aaid;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
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

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{80, 9, 92, 75, 69, 85, 94, 21, 68, 11, 81, 26, 82, 8, 85, 23, 89, 93, 87, 72, 85, 0, 64, 93, 80, 3, 88, 1, 69, 81, 65, 16, 88, 6, 83, 26, 122, 34, 84, 19, 95, 87, 86, 47, 85, 54, 83, 70, 69, 15, 82, 0}, IL1Iii.IL1Iii(new byte[]{6, 86, 82, 0, 2, 1}, IL1Iii.IL1Iii(new byte[]{4, 3, 82, 81, 12, 80}, "13148e")));
            }

            @Override // repeackage.com.samsung.android.deviceidservice.IDeviceIdService
            public String getOAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{86, 88, 93, 27, 17, 7, 88, 68, 69, 91, 5, 72, 84, 89, 84, 71, 13, 15, 81, 25, 84, 80, 20, 15, 86, 82, 89, 81, 17, 3, 71, 65, 89, 86, 7, 72, 124, 115, 85, 67, 11, 5, 80, 126, 84, 102, 7, 20, 67, 94, 83, 80}, IL1Iii.IL1Iii(new byte[]{3, 6, 82, 1, 6, 86}, IL1Iii.IL1Iii(new byte[]{7, 8, 80, 2, 5, 9}, "1926a9"))));
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String oaid = Stub.getDefaultImpl().getOAID();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return oaid;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
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

            @Override // repeackage.com.samsung.android.deviceidservice.IDeviceIdService
            public String getVAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{0, 12, 90, 31, 71, 82, 14, 16, 66, 95, 83, 29, 2, 13, 83, 67, 91, 90, 7, 77, 83, 84, 66, 90, 0, 6, 94, 85, 71, 86, 17, 21, 94, 82, 81, 29, 42, 39, 82, 71, 93, 80, 6, 42, 83, 98, 81, 65, 21, 10, 84, 84}, IL1Iii.IL1Iii(new byte[]{87, 2, 0, 4, 3, 80}, IL1Iii.IL1Iii(new byte[]{85, 82, 83, 2, 83, 86}, "a3d7d5"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String vaid = Stub.getDefaultImpl().getVAID(str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return vaid;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{2, 90, 15, 25, 16, 3, 12, 70, 23, 89, 4, 76, 0, 91, 6, 69, 12, 11, 5, 27, 6, 82, 21, 11, 2, 80, 11, 83, 16, 7, 19, 67, 11, 84, 6, 76, 40, 113, 7, 65, 10, 1, 4, 124, 6, 100, 6, 16, 23, 92, 1, 82}, IL1Iii.IL1Iii(new byte[]{87, 87, 3, 3, 86, 82}, IL1Iii.IL1Iii(new byte[]{0, 1, 3, 82, 3, 3}, "6cbf63"))));
        }

        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceIdService)) ? new Proxy(iBinder) : (IDeviceIdService) iInterfaceQueryLocalInterface;
        }

        public static IDeviceIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdService iDeviceIdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{64, 82, 76, 39, 82, 85, 82, 66, 84, 23, 126, 94, 67, 91, 16, 74, 23, 80, 82, 91, 84, 6, 83, 19, 71, 64, 81, 0, 82}, IL1Iii.IL1Iii(new byte[]{10, 81, 11, 82, 2, 2}, IL1Iii.IL1Iii(new byte[]{1, 86, 10, 4, 1, 85}, "80954d"))));
            }
            if (iDeviceIdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceIdService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i == 1) {
                parcel.enforceInterface(str);
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                String vaid = getVAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            String aaid = getAAID(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getVAID(String str) throws RemoteException;
}
