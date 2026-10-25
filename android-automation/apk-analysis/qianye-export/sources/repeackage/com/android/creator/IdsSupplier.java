package repeackage.com.android.creator;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IdsSupplier extends IInterface {

    public static class Default implements IdsSupplier {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.android.creator.IdsSupplier
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.android.creator.IdsSupplier
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.android.creator.IdsSupplier
        public String getUDID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.android.creator.IdsSupplier
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.android.creator.IdsSupplier
        public boolean isSupported() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IdsSupplier {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{7, 89, 88, 75, 82, 13, 0, 68, 90, 12, 87, 77, 7, 68, 80, 4, 71, 12, 22, 24, 124, 1, 64, 48, 17, 70, 69, 9, 90, 6, 22}, IL1Iii.IL1Iii(new byte[]{80, 82, 80, 92, 11, 6}, IL1Iii.IL1Iii(new byte[]{81, 84, 4, 10, 94, 4}, "e0a3fa")));
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupported = 1;

        public static class Proxy implements IdsSupplier {
            public static IdsSupplier sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.android.creator.IdsSupplier
            public String getAAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{84, 9, 89, 74, 87, 87, 83, 20, 91, 13, 82, 23, 84, 20, 81, 5, 66, 86, 69, 72, 125, 0, 69, 106, 66, 22, 68, 8, 95, 92, 69}, IL1Iii.IL1Iii(new byte[]{81, 95, 85, 80, 87, 12}, IL1Iii.IL1Iii(new byte[]{7, 92, 84, 13, 5, 86}, "ae59dc"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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
                return IL1Iii.IL1Iii(new byte[]{90, 91, 84, 22, 80, 8, 93, 70, 86, 81, 85, 72, 90, 70, 92, 89, 69, 9, 75, 26, 112, 92, 66, 53, 76, 68, 73, 84, 88, 3, 75}, IL1Iii.IL1Iii(new byte[]{13, 81, 11, 14, 0, 5}, IL1Iii.IL1Iii(new byte[]{2, 93, 86, 4, 2, 5}, "68d23f")));
            }

            @Override // repeackage.com.android.creator.IdsSupplier
            public String getOAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{83, 93, 92, 79, 2, 12, 84, 64, 94, 8, 7, 76, 83, 64, 84, 0, 23, 13, 66, 28, 120, 5, 16, 49, 69, 66, 65, 13, 10, 7, 66}, IL1Iii.IL1Iii(new byte[]{8, 83, 82, 3, 90, 86}, IL1Iii.IL1Iii(new byte[]{15, 83, 91, 83, 1, 3}, "728187"))));
                    try {
                        if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // repeackage.com.android.creator.IdsSupplier
            public String getUDID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{90, 92, 90, 75, 2, 94, 93, 65, 88, 12, 7, 30, 90, 65, 82, 4, 23, 95, 75, 29, 126, 1, 16, 99, 76, 67, 71, 9, 10, 85, 75}, IL1Iii.IL1Iii(new byte[]{15, 1, 5, 7, 6, 86}, IL1Iii.IL1Iii(new byte[]{82, 7, 11, 0, 86, 80}, "d59b36"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String udid = Stub.getDefaultImpl().getUDID(str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return udid;
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

            @Override // repeackage.com.android.creator.IdsSupplier
            public String getVAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{7, 91, 93, 28, 5, 13, 0, 70, 95, 91, 0, 77, 7, 70, 85, 83, 16, 12, 22, 26, 121, 86, 23, 48, 17, 68, 64, 94, 13, 6, 22}, IL1Iii.IL1Iii(new byte[]{0, 13, 3, 83, 85, 5}, IL1Iii.IL1Iii(new byte[]{87, 91, 11, 83, 9, 7}, "3b828a"))));
                    try {
                        if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String vaid = Stub.getDefaultImpl().getVAID();
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

            @Override // repeackage.com.android.creator.IdsSupplier
            public boolean isSupported() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{86, 10, 8, 74, 86, 12, 81, 23, 10, 13, 83, 76, 86, 23, 0, 5, 67, 13, 71, 75, 44, 0, 68, 49, 64, 21, 21, 8, 94, 7, 71}, IL1Iii.IL1Iii(new byte[]{4, 92, 87, 6, 83, 3}, IL1Iii.IL1Iii(new byte[]{0, 10, 84, 4, 1, 87}, "13ffe6"))));
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zIsSupported = Stub.getDefaultImpl().isSupported();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zIsSupported;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{87, 92, 92, 79, 82, 11, 80, 65, 94, 8, 87, 75, 87, 65, 84, 0, 71, 10, 70, 29, 120, 5, 64, 54, 65, 67, 65, 13, 90, 0, 70}, IL1Iii.IL1Iii(new byte[]{85, 7, 0, 87, 4, 85}, IL1Iii.IL1Iii(new byte[]{4, 80, 85, 2, 83, 3}, "edd4d3"))));
        }

        public static IdsSupplier asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IdsSupplier)) ? new Proxy(iBinder) : (IdsSupplier) iInterfaceQueryLocalInterface;
        }

        public static IdsSupplier getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IdsSupplier idsSupplier) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{65, 92, 22, 38, 4, 81, 83, 76, 14, 22, 40, 90, 66, 85, 74, 75, 65, 84, 83, 85, 14, 7, 5, 23, 70, 78, 11, 1, 4}, IL1Iii.IL1Iii(new byte[]{10, 90, 90, 3, 0, 2}, IL1Iii.IL1Iii(new byte[]{92, 6, 13, 89, 2, 3}, "de58c6"))));
            }
            if (idsSupplier == null) {
                return false;
            }
            Proxy.sDefaultImpl = idsSupplier;
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
                boolean zIsSupported = isSupported();
                parcel2.writeNoException();
                parcel2.writeInt(zIsSupported ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                String udid = getUDID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(udid);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(str);
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(str);
                String vaid = getVAID();
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 5) {
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

    String getUDID(String str) throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isSupported() throws RemoteException;
}
