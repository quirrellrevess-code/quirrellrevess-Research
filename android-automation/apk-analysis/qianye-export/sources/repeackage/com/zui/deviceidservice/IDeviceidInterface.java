package repeackage.com.zui.deviceidservice;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceidInterface extends IInterface {

    public static class Default implements IDeviceidInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
        public String createAAIDForPackageName(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
        public String getVAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
        public boolean isSupport() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceidInterface {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{80, 9, 95, 25, 30, 70, 90, 72, 86, 82, 18, 90, 80, 3, 91, 83, 23, 86, 65, 16, 91, 84, 1, 29, 122, 34, 87, 65, 13, 80, 86, 15, 86, 126, 10, 71, 86, 20, 84, 86, 7, 86}, IL1Iii.IL1Iii(new byte[]{4, 95, 4, 14, 84, 86}, IL1Iii.IL1Iii(new byte[]{81, 0, 6, 9, 4, 82}, "f90047")));
        public static final int TRANSACTION_createAAIDForPackageName = 6;
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 3;

        public static class Proxy implements IDeviceidInterface {
            public static IDeviceidInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
            public String createAAIDForPackageName(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{5, 14, 14, 30, 77, 65, 15, 79, 7, 85, 65, 93, 5, 4, 10, 84, 68, 81, 20, 23, 10, 83, 82, 26, 47, 37, 6, 70, 94, 87, 3, 8, 7, 121, 89, 64, 3, 19, 5, 81, 84, 81}, IL1Iii.IL1Iii(new byte[]{0, 89, 0, 4, 4, 0}, IL1Iii.IL1Iii(new byte[]{86, 0, 1, 2, 6, 80}, "08b65d"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String strCreateAAIDForPackageName = Stub.getDefaultImpl().createAAIDForPackageName(str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strCreateAAIDForPackageName;
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

            @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
            public String getAAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{80, 12, 11, 77, 76, 23, 90, 77, 2, 6, 64, 11, 80, 6, 15, 7, 69, 7, 65, 21, 15, 0, 83, 76, 122, 39, 3, 21, 95, 1, 86, 10, 2, 42, 88, 22, 86, 17, 0, 2, 85, 7}, IL1Iii.IL1Iii(new byte[]{80, 2, 85, 0, 83, 3}, IL1Iii.IL1Iii(new byte[]{81, 85, 2, 2, 85, 81}, "241a00"))));
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
                return IL1Iii.IL1Iii(new byte[]{90, 11, 95, 22, 78, 68, 80, 74, 86, 93, 66, 88, 90, 1, 91, 92, 71, 84, 75, 18, 91, 91, 81, 31, 112, 32, 87, 78, 93, 82, 92, 13, 86, 113, 90, 69, 92, 22, 84, 89, 87, 84}, IL1Iii.IL1Iii(new byte[]{90, 92, 84, 90, 3, 0}, IL1Iii.IL1Iii(new byte[]{82, 9, 80, 85, 15, 80}, "11678a")));
            }

            @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
            public String getOAID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{84, 14, 94, 26, 76, 16, 94, 79, 87, 81, 64, 12, 84, 4, 90, 80, 69, 0, 69, 23, 90, 87, 83, 75, 126, 37, 86, 66, 95, 6, 82, 8, 87, 125, 88, 17, 82, 19, 85, 85, 85, 0}, IL1Iii.IL1Iii(new byte[]{4, 2, 10, 87, 3, 92}, IL1Iii.IL1Iii(new byte[]{11, 90, 12, 5, 81, 90}, "895fdc"))));
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

            @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
            public String getUDID() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{5, 94, 15, 77, 31, 71, 15, 31, 6, 6, 19, 91, 5, 84, 11, 7, 22, 87, 20, 71, 11, 0, 0, 28, 47, 117, 7, 21, 12, 81, 3, 88, 6, 42, 11, 70, 3, 67, 4, 2, 6, 87}, IL1Iii.IL1Iii(new byte[]{94, 7, 84, 5, 6, 7}, IL1Iii.IL1Iii(new byte[]{8, 5, 87, 83, 91, 1}, "03a584"))));
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

            @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
            public String getVAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{87, 9, 88, 72, 25, 70, 93, 72, 81, 3, 21, 90, 87, 3, 92, 2, 16, 86, 70, 16, 92, 5, 6, 29, 125, 34, 80, 16, 10, 80, 81, 15, 81, 47, 13, 71, 81, 20, 83, 7, 0, 86}, IL1Iii.IL1Iii(new byte[]{3, 94, 3, 3, 83, 11}, IL1Iii.IL1Iii(new byte[]{84, 0, 85, 87, 3, 1}, "c8c239"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // repeackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean isSupport() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{6, 10, 90, 27, 79, 23, 12, 75, 83, 80, 67, 11, 6, 0, 94, 81, 70, 7, 23, 19, 94, 86, 80, 76, 44, 33, 82, 67, 92, 1, 0, 12, 83, 124, 91, 22, 0, 23, 81, 84, 86, 7}, IL1Iii.IL1Iii(new byte[]{3, 92, 1, 86, 6, 6}, IL1Iii.IL1Iii(new byte[]{7, 15, 83, 81, 7, 80}, "a6e244"))));
                    try {
                        if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{82, 94, 91, 75, 31, 69, 88, 31, 82, 0, 19, 89, 82, 84, 95, 1, 22, 85, 67, 71, 95, 6, 0, 30, 120, 117, 83, 19, 12, 83, 84, 88, 82, 44, 11, 68, 84, 67, 80, 4, 6, 85}, IL1Iii.IL1Iii(new byte[]{8, 1, 83, 3, 6, 7}, IL1Iii.IL1Iii(new byte[]{88, 85, 87, 94, 86, 6}, "ae2851"))));
        }

        public static IDeviceidInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) iInterfaceQueryLocalInterface;
        }

        public static IDeviceidInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceidInterface iDeviceidInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{18, 85, 23, 119, 7, 83, 0, 69, 15, 71, 43, 88, 17, 92, 75, 26, 66, 86, 0, 92, 15, 86, 6, 21, 21, 71, 10, 80, 7}, IL1Iii.IL1Iii(new byte[]{81, 82, 82, 2, 0, 13}, IL1Iii.IL1Iii(new byte[]{2, 84, 7, 82, 82, 12}, "266c04"))));
            }
            if (iDeviceidInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceidInterface;
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
                    String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    String udid = getUDID();
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    boolean zIsSupport = isSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupport ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    String strCreateAAIDForPackageName = createAAIDForPackageName(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strCreateAAIDForPackageName);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String createAAIDForPackageName(String str) throws RemoteException;

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID(String str) throws RemoteException;

    boolean isSupport() throws RemoteException;
}
