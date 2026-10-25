package repeackage.com.bun.lib;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface MsaIdInterface extends IInterface {

    public static class Default implements MsaIdInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.bun.lib.MsaIdInterface
        public String getAAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.bun.lib.MsaIdInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.bun.lib.MsaIdInterface
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.bun.lib.MsaIdInterface
        public boolean isDataArrived() throws RemoteException {
            return false;
        }

        @Override // repeackage.com.bun.lib.MsaIdInterface
        public boolean isSupported() throws RemoteException {
            return false;
        }

        @Override // repeackage.com.bun.lib.MsaIdInterface
        public void shutDown() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements MsaIdInterface {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{7, 92, 94, 23, 4, 20, 10, 29, 95, 80, 4, 79, 41, 64, 82, 112, 2, 40, 10, 71, 86, 75, 0, 0, 7, 86}, IL1Iii.IL1Iii(new byte[]{87, 80, 80, 1, 95, 81}, IL1Iii.IL1Iii(new byte[]{3, 82, 84, 8, 95, 1}, "0170f1")));
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isDataArrived = 2;
        public static final int TRANSACTION_isSupported = 1;
        public static final int TRANSACTION_shutDown = 6;

        public static class Proxy implements MsaIdInterface {
            public static MsaIdInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.bun.lib.MsaIdInterface
            public String getAAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{81, 86, 12, 26, 91, 77, 92, 23, 13, 93, 91, 22, 127, 74, 0, 125, 93, 113, 92, 77, 4, 70, 95, 89, 81, 92}, IL1Iii.IL1Iii(new byte[]{7, 15, 7, 87, 88, 14}, IL1Iii.IL1Iii(new byte[]{86, 1, 85, 87, 84, 15}, "c73459"))));
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
                return IL1Iii.IL1Iii(new byte[]{82, 12, 15, 72, 4, 66, 95, 77, 14, 15, 4, 25, 124, 16, 3, 47, 2, 126, 95, 23, 7, 20, 0, 86, 82, 6}, IL1Iii.IL1Iii(new byte[]{82, 91, 81, 81, 81, 85}, IL1Iii.IL1Iii(new byte[]{83, 91, 11, 4, 0, 1}, "0c837c")));
            }

            @Override // repeackage.com.bun.lib.MsaIdInterface
            public String getOAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{90, 10, 95, 25, 87, 19, 87, 75, 94, 94, 87, 72, 116, 22, 83, 126, 81, 47, 87, 17, 87, 69, 83, 7, 90, 0}, IL1Iii.IL1Iii(new byte[]{91, 93, 84, 85, 87, 82}, IL1Iii.IL1Iii(new byte[]{4, 91, 84, 81, 80, 1}, "fc2325"))));
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

            @Override // repeackage.com.bun.lib.MsaIdInterface
            public String getVAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{1, 91, 9, 75, 90, 65, 12, 26, 8, 12, 90, 26, 47, 71, 5, 44, 92, 125, 12, 64, 1, 23, 94, 85, 1, 81}, IL1Iii.IL1Iii(new byte[]{85, 6, 0, 87, 15, 2}, IL1Iii.IL1Iii(new byte[]{2, 7, 83, 7, 84, 0}, "5575c6"))));
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

            @Override // repeackage.com.bun.lib.MsaIdInterface
            public boolean isDataArrived() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{82, 88, 8, 79, 81, 76, 95, 25, 9, 8, 81, 23, 124, 68, 4, 40, 87, 112, 95, 67, 0, 19, 85, 88, 82, 82}, IL1Iii.IL1Iii(new byte[]{3, 85, 93, 4, 11, 8}, IL1Iii.IL1Iii(new byte[]{11, 86, 90, 82, 12, 84}, "94b74e"))));
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zIsDataArrived = Stub.getDefaultImpl().isDataArrived();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zIsDataArrived;
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

            @Override // repeackage.com.bun.lib.MsaIdInterface
            public boolean isSupported() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{81, 9, 8, 72, 90, 71, 92, 72, 9, 15, 90, 28, 127, 21, 4, 47, 92, 123, 92, 18, 0, 20, 94, 83, 81, 3}, IL1Iii.IL1Iii(new byte[]{87, 4, 0, 86, 93, 87}, IL1Iii.IL1Iii(new byte[]{92, 3, 93, 3, 85, 82}, "9a8307"))));
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

            @Override // repeackage.com.bun.lib.MsaIdInterface
            public void shutDown() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{87, 9, 90, 31, 6, 17, 90, 72, 91, 88, 6, 74, 121, 21, 86, 120, 0, 45, 90, 18, 82, 67, 2, 5, 87, 3}, IL1Iii.IL1Iii(new byte[]{3, 94, 7, 85, 85, 83}, IL1Iii.IL1Iii(new byte[]{6, 89, 8, 6, 2, 83}, "1a8b3d"))));
                    try {
                        if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().shutDown();
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{91, 86, 15, 29, 91, 19, 86, 23, 14, 90, 91, 72, 117, 74, 3, 122, 93, 47, 86, 77, 7, 65, 95, 7, 91, 92}, IL1Iii.IL1Iii(new byte[]{93, 12, 7, 86, 88, 83}, IL1Iii.IL1Iii(new byte[]{80, 12, 4, 1, 2, 6}, "59adc3"))));
        }

        public static MsaIdInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof MsaIdInterface)) ? new Proxy(iBinder) : (MsaIdInterface) iInterfaceQueryLocalInterface;
        }

        public static MsaIdInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MsaIdInterface msaIdInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{69, 4, 70, 119, 83, 86, 87, 20, 94, 71, 127, 93, 70, 13, 26, 26, 22, 83, 87, 13, 94, 86, 82, 16, 66, 22, 91, 80, 83}, IL1Iii.IL1Iii(new byte[]{4, 88, 4, 85, 80, 86}, IL1Iii.IL1Iii(new byte[]{10, 14, 4, 2, 80, 81}, "872d67"))));
            }
            if (msaIdInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = msaIdInterface;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    boolean zIsSupported = isSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupported ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    boolean zIsDataArrived = isDataArrived();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDataArrived ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    String vaid = getVAID();
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    String aaid = getAAID();
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    shutDown();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getAAID() throws RemoteException;

    String getOAID() throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isDataArrived() throws RemoteException;

    boolean isSupported() throws RemoteException;

    void shutDown() throws RemoteException;
}
