package repeackage.com.asus.msa.SupplementaryDID;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IDidAidlInterface extends IInterface {

    public static class Default implements IDidAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getAAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public boolean isSupport() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{84, 14, 89, 29, 84, 75, 66, 18, 26, 94, 70, 89, 25, 50, 65, 67, 69, 84, 82, 12, 81, 93, 65, 89, 69, 24, 112, 122, 113, 22, 126, 37, 93, 87, 116, 81, 83, 13, 125, 93, 65, 93, 69, 7, 85, 80, 80}, IL1Iii.IL1Iii(new byte[]{5, 3, 2, 0, 83, 90}, IL1Iii.IL1Iii(new byte[]{87, 80, 87, 3, 82, 6}, "e2a04d")));
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 1;

        public static class Proxy implements IDidAidlInterface {
            public static IDidAidlInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getAAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{90, 92, 85, 77, 83, 68, 76, 64, 22, 14, 65, 86, 23, 96, 77, 19, 66, 91, 92, 94, 93, 13, 70, 86, 75, 74, 124, 42, 118, 25, 112, 119, 81, 7, 115, 94, 93, 95, 113, 13, 70, 82, 75, 85, 89, 0, 87}, IL1Iii.IL1Iii(new byte[]{8, 4, 15, 86, 3, 1}, IL1Iii.IL1Iii(new byte[]{83, 82, 0, 80, 87, 0}, "be7ef6"))));
                    try {
                        if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String aaid = Stub.getDefaultImpl().getAAID();
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
                return IL1Iii.IL1Iii(new byte[]{81, 11, 90, 75, 84, 67, 71, 23, 25, 8, 70, 81, 28, 55, 66, 21, 69, 92, 87, 9, 82, 11, 65, 81, 64, 29, 115, 44, 113, 30, 123, 32, 94, 1, 116, 89, 86, 8, 126, 11, 65, 85, 64, 2, 86, 6, 80}, IL1Iii.IL1Iii(new byte[]{11, 2, 14, 1, 5, 85}, IL1Iii.IL1Iii(new byte[]{8, 81, 12, 81, 84, 84}, "1755d1")));
            }

            @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getOAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{86, 13, 90, 74, 5, 16, 64, 17, 25, 9, 23, 2, 27, 49, 66, 20, 20, 15, 80, 15, 82, 10, 16, 2, 71, 27, 115, 45, 32, 77, 124, 38, 94, 0, 37, 10, 81, 14, 126, 10, 16, 6, 71, 4, 86, 7, 1}, IL1Iii.IL1Iii(new byte[]{81, 6, 83, 93, 84, 80}, IL1Iii.IL1Iii(new byte[]{2, 1, 93, 13, 0, 81}, "fe940b"))));
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

            @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getUDID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{80, 12, 92, 26, 83, 66, 70, 16, 31, 89, 65, 80, 29, 48, 68, 68, 66, 93, 86, 14, 84, 90, 70, 80, 65, 26, 117, 125, 118, 31, 122, 39, 88, 80, 115, 88, 87, 15, 120, 90, 70, 84, 65, 5, 80, 87, 87}, IL1Iii.IL1Iii(new byte[]{11, 81, 7, 85, 83, 5}, IL1Iii.IL1Iii(new byte[]{8, 80, 7, 86, 85, 7}, "0b1743"))));
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String udid = Stub.getDefaultImpl().getUDID();
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

            @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getVAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{90, 86, 14, 28, 84, 22, 76, 74, 77, 95, 70, 4, 23, 106, 22, 66, 69, 9, 92, 84, 6, 92, 65, 4, 75, 64, 39, 123, 113, 75, 112, 125, 10, 86, 116, 12, 93, 85, 42, 92, 65, 0, 75, 95, 2, 81, 80}, IL1Iii.IL1Iii(new byte[]{95, 90, 84, 2, 81, 81}, IL1Iii.IL1Iii(new byte[]{82, 0, 83, 8, 81, 13}, "4cd859"))));
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

            @Override // repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public boolean isSupport() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{1, 11, 8, 25, 81, 16, 23, 23, 75, 90, 67, 2, 76, 55, 16, 71, 64, 15, 7, 9, 0, 89, 68, 2, 16, 29, 33, 126, 116, 77, 43, 32, 12, 83, 113, 10, 6, 8, 44, 89, 68, 6, 16, 2, 4, 84, 85}, IL1Iii.IL1Iii(new byte[]{1, 2, 84, 14, 2, 87}, IL1Iii.IL1Iii(new byte[]{90, 82, 6, 10, 81, 12}, "9473c8"))));
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zIsSupport = Stub.getDefaultImpl().isSupport();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zIsSupport;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{80, 91, 91, 23, 86, 16, 70, 71, 24, 84, 68, 2, 29, 103, 67, 73, 71, 15, 86, 89, 83, 87, 67, 2, 65, 77, 114, 112, 115, 77, 122, 112, 95, 93, 118, 10, 87, 88, 127, 87, 67, 6, 65, 82, 87, 90, 82}, IL1Iii.IL1Iii(new byte[]{81, 86, 2, 1, 4, 80}, IL1Iii.IL1Iii(new byte[]{1, 1, 81, 92, 10, 80}, "cced9c"))));
        }

        public static IDidAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDidAidlInterface)) ? new Proxy(iBinder) : (IDidAidlInterface) iInterfaceQueryLocalInterface;
        }

        public static IDidAidlInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDidAidlInterface iDidAidlInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{17, 80, 64, 117, 85, 80, 3, 64, 88, 69, 121, 91, 18, 89, 28, 24, 16, 85, 3, 89, 88, 84, 84, 22, 22, 66, 93, 82, 85}, IL1Iii.IL1Iii(new byte[]{83, 2, 81, 3, 84, 1}, IL1Iii.IL1Iii(new byte[]{6, 2, 81, 10, 82, 81}, "75486f"))));
            }
            if (iDidAidlInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDidAidlInterface;
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
                boolean zIsSupport = isSupport();
                parcel2.writeNoException();
                parcel2.writeInt(zIsSupport ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                String udid = getUDID();
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
            String aaid = getAAID();
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    String getAAID() throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isSupport() throws RemoteException;
}
