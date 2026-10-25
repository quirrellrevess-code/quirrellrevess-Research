package repeackage.com.google.android.gms.ads.identifier.internal;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IAdvertisingIdService extends IInterface {

    public static class Default implements IAdvertisingIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public String getId() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{80, 86, 89, 28, 85, 86, 92, 94, 88, 87, 28, 88, 93, 93, 70, 93, 91, 93, 29, 94, 89, 65, 28, 88, 87, 74, 26, 91, 86, 92, 93, 77, 93, 84, 91, 92, 65, 23, 93, 92, 70, 92, 65, 87, 85, 94, 28, 112, 114, 93, 66, 87, 64, 77, 90, 74, 93, 92, 85, 112, 87, 106, 81, 64, 68, 80, 80, 92}, IL1Iii.IL1Iii(new byte[]{1, 88, 0, 2, 11, 15}, IL1Iii.IL1Iii(new byte[]{80, 88, 81, 9, 11, 84}, "b9e92b")));
        public static final int TRANSACTION_getId = 1;
        public static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        public static class Proxy implements IAdvertisingIdService {
            public static IAdvertisingIdService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public String getId() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{87, 90, 90, 72, 2, 88, 91, 82, 91, 3, 75, 86, 90, 81, 69, 9, 12, 83, 26, 82, 90, 21, 75, 86, 80, 70, 25, 15, 1, 82, 90, 65, 94, 0, 12, 82, 70, 27, 94, 8, 17, 82, 70, 91, 86, 10, 75, 126, 117, 81, 65, 3, 23, 67, 93, 70, 94, 8, 2, 126, 80, 102, 82, 20, 19, 94, 87, 80}, IL1Iii.IL1Iii(new byte[]{81, 81, 81, 80, 3, 0}, IL1Iii.IL1Iii(new byte[]{3, 83, 0, 14, 4, 5}, "f7f8b2"))));
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String id = Stub.getDefaultImpl().getId();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return id;
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
                return IL1Iii.IL1Iii(new byte[]{6, 11, 11, 76, 87, 12, 10, 3, 10, 7, 30, 2, 11, 0, 20, 13, 89, 7, 75, 3, 11, 17, 30, 2, 1, 23, 72, 11, 84, 6, 11, 16, 15, 4, 89, 6, 23, 74, 15, 12, 68, 6, 23, 10, 7, 14, 30, 42, 36, 0, 16, 7, 66, 23, 12, 23, 15, 12, 87, 42, 1, 55, 3, 16, 70, 10, 6, 1}, IL1Iii.IL1Iii(new byte[]{4, 5, 0, 87, 8, 81}, IL1Iii.IL1Iii(new byte[]{0, 83, 80, 2, 91, 1}, "a267c3")));
            }

            @Override // repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean z) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{80, 11, 11, 77, 84, 10, 92, 3, 10, 6, 29, 4, 93, 0, 20, 12, 90, 1, 29, 3, 11, 16, 29, 4, 87, 23, 72, 10, 87, 0, 93, 16, 15, 5, 90, 0, 65, 74, 15, 13, 71, 0, 65, 10, 7, 15, 29, 44, 114, 0, 16, 6, 65, 17, 90, 23, 15, 13, 84, 44, 87, 55, 3, 17, 69, 12, 80, 1}, IL1Iii.IL1Iii(new byte[]{2, 2, 82, 80, 3, 84}, IL1Iii.IL1Iii(new byte[]{8, 83, 7, 2, 1, 83}, "95311b"))));
                    parcelObtain.writeInt(z ? 1 : 0);
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zIsLimitAdTrackingEnabled = Stub.getDefaultImpl().isLimitAdTrackingEnabled(z);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zIsLimitAdTrackingEnabled;
                        }
                        parcelObtain2.readException();
                        boolean z2 = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z2;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{86, 89, 88, 75, 2, 11, 90, 81, 89, 0, 75, 5, 91, 82, 71, 10, 12, 0, 27, 81, 88, 22, 75, 5, 81, 69, 27, 12, 1, 1, 91, 66, 92, 3, 12, 1, 71, 24, 92, 11, 17, 1, 71, 88, 84, 9, 75, 45, 116, 82, 67, 0, 23, 16, 92, 69, 92, 11, 2, 45, 81, 101, 80, 23, 19, 13, 86, 83}, IL1Iii.IL1Iii(new byte[]{4, 0, 3, 86, 83, 5}, IL1Iii.IL1Iii(new byte[]{5, 14, 87, 5, 0, 4}, "48a66e"))));
        }

        public static IAdvertisingIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdvertisingIdService)) ? new Proxy(iBinder) : (IAdvertisingIdService) iInterfaceQueryLocalInterface;
        }

        public static IAdvertisingIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdvertisingIdService iAdvertisingIdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{17, 84, 64, 117, 82, 4, 3, 68, 88, 69, 126, 15, 18, 93, 28, 24, 23, 1, 3, 93, 88, 84, 83, 66, 22, 70, 93, 82, 82}, IL1Iii.IL1Iii(new byte[]{87, 8, 81, 87, 5, 3}, IL1Iii.IL1Iii(new byte[]{3, 88, 3, 2, 81, 4}, "6afdce"))));
            }
            if (iAdvertisingIdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAdvertisingIdService;
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
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
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
            boolean zIsLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zIsLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException;
}
