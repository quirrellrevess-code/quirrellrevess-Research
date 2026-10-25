package repeackage.com.coolpad.deviceidsupport;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdManager extends IInterface {

    public static class Default implements IDeviceIdManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getCoolOsVersion() throws RemoteException {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getIMEI(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getOAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getUDID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getVAID(String str) throws RemoteException {
            return null;
        }

        @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{1, 9, 14, 29, 0, 86, 13, 10, 19, 82, 7, 23, 6, 3, 21, 90, 0, 92, 11, 2, 16, 70, 19, 73, 13, 20, 23, 29, 42, 125, 7, 16, 10, 80, 6, 112, 6, 43, 2, 93, 2, 94, 7, 20}, IL1Iii.IL1Iii(new byte[]{83, 2, 84, 87, 87, 0}, IL1Iii.IL1Iii(new byte[]{80, 5, 85, 5, 80, 8}, "aabad1")));
        public static final int TRANSACTION_getAAID = 4;
        public static final int TRANSACTION_getCoolOsVersion = 7;
        public static final int TRANSACTION_getIMEI = 5;
        public static final int TRANSACTION_getOAID = 2;
        public static final int TRANSACTION_getUDID = 1;
        public static final int TRANSACTION_getVAID = 3;
        public static final int TRANSACTION_isCoolOs = 6;

        public static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getAAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{87, 12, 11, 24, 6, 92, 91, 15, 22, 87, 1, 29, 80, 6, 16, 95, 6, 86, 93, 7, 21, 67, 21, 67, 91, 17, 18, 24, 44, 119, 81, 21, 15, 85, 0, 122, 80, 46, 7, 88, 4, 84, 81, 17}, IL1Iii.IL1Iii(new byte[]{85, 2, 0, 85, 82, 10}, IL1Iii.IL1Iii(new byte[]{88, 4, 5, 0, 6, 10}, "9ecc13"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{6, 90, 14, 77, 6, 12, 10, 89, 19, 2, 1, 77, 1, 80, 21, 10, 6, 6, 12, 81, 16, 22, 21, 19, 10, 71, 23, 77, 44, 39, 0, 67, 10, 0, 0, 42, 1, 120, 2, 13, 4, 4, 0, 71}, IL1Iii.IL1Iii(new byte[]{93, 12, 7, 6, 87, 6}, IL1Iii.IL1Iii(new byte[]{15, 8, 6, 83, 3, 92}, "71b619"))));
                    try {
                        if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String coolOsVersion = Stub.getDefaultImpl().getCoolOsVersion();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return coolOsVersion;
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

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getIMEI(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{1, 11, 15, 77, 85, 11, 13, 8, 18, 2, 82, 74, 6, 1, 20, 10, 85, 1, 11, 0, 17, 22, 70, 20, 13, 22, 22, 77, 127, 32, 7, 18, 11, 0, 83, 45, 6, 41, 3, 13, 87, 3, 7, 22}, IL1Iii.IL1Iii(new byte[]{85, 81, 84, 85, 5, 81}, IL1Iii.IL1Iii(new byte[]{14, 5, 82, 82, 11, 4}, "90dd81"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String imei = Stub.getDefaultImpl().getIMEI(str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return imei;
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
                return IL1Iii.IL1Iii(new byte[]{0, 86, 90, 27, 0, 89, 12, 85, 71, 84, 7, 24, 7, 92, 65, 92, 0, 83, 10, 93, 68, 64, 19, 70, 12, 75, 67, 27, 42, 114, 6, 79, 94, 86, 6, 127, 7, 116, 86, 91, 2, 81, 6, 75}, IL1Iii.IL1Iii(new byte[]{86, 93, 6, 87, 87, 87}, IL1Iii.IL1Iii(new byte[]{0, 84, 8, 85, 2, 5}, "50976d")));
            }

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{82, 10, 88, 74, 91, 9, 94, 9, 69, 5, 92, 72, 85, 0, 67, 13, 91, 3, 88, 1, 70, 17, 72, 22, 94, 23, 65, 74, 113, 34, 84, 19, 92, 7, 93, 47, 85, 40, 84, 10, 89, 1, 84, 23}, IL1Iii.IL1Iii(new byte[]{3, 92, 6, 92, 15, 85}, IL1Iii.IL1Iii(new byte[]{80, 15, 5, 1, 82, 85}, "b669ef"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String oaid = Stub.getDefaultImpl().getOAID(str);
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

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getUDID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{2, 88, 90, 31, 87, 90, 14, 91, 71, 80, 80, 27, 5, 82, 65, 88, 87, 80, 8, 83, 68, 68, 68, 69, 14, 69, 67, 31, 125, 113, 4, 65, 94, 82, 81, 124, 5, 122, 86, 95, 85, 82, 4, 69}, IL1Iii.IL1Iii(new byte[]{7, 3, 83, 1, 12, 84}, IL1Iii.IL1Iii(new byte[]{81, 80, 86, 83, 90, 83}, "7d2cb2"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getVAID(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{1, 13, 94, 29, 1, 13, 13, 14, 67, 82, 6, 76, 6, 7, 69, 90, 1, 7, 11, 6, 64, 70, 18, 18, 13, 16, 71, 29, 43, 38, 7, 20, 90, 80, 7, 43, 6, 47, 82, 93, 3, 5, 7, 16}, IL1Iii.IL1Iii(new byte[]{91, 87, 11, 10, 3, 87}, IL1Iii.IL1Iii(new byte[]{92, 86, 92, 14, 85, 83}, "ecd74f"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{83, 90, 93, 79, 87, 94, 95, 89, 64, 0, 80, 31, 84, 80, 70, 8, 87, 84, 89, 81, 67, 20, 68, 65, 95, 71, 68, 79, 125, 117, 85, 67, 89, 2, 81, 120, 84, 120, 81, 15, 85, 86, 85, 71}, IL1Iii.IL1Iii(new byte[]{5, 13, 6, 5, 85, 0}, IL1Iii.IL1Iii(new byte[]{86, 93, 15, 92, 81, 6}, "ce9807"))));
                    try {
                        if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zIsCoolOs = Stub.getDefaultImpl().isCoolOs();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zIsCoolOs;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{91, 10, 84, 31, 84, 11, 87, 9, 73, 80, 83, 74, 92, 0, 79, 88, 84, 1, 81, 1, 74, 68, 71, 20, 87, 23, 77, 31, 126, 32, 93, 19, 80, 82, 82, 45, 92, 40, 88, 95, 86, 3, 93, 23}, IL1Iii.IL1Iii(new byte[]{15, 92, 1, 4, 2, 84}, IL1Iii.IL1Iii(new byte[]{3, 12, 14, 4, 84, 8}, "4561a8"))));
        }

        public static IDeviceIdManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceIdManager)) ? new Proxy(iBinder) : (IDeviceIdManager) iInterfaceQueryLocalInterface;
        }

        public static IDeviceIdManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{65, 83, 67, 115, 7, 4, 83, 67, 91, 67, 43, 15, 66, 90, 31, 30, 66, 1, 83, 90, 91, 82, 6, 66, 70, 65, 94, 84, 7}, IL1Iii.IL1Iii(new byte[]{4, 83, 15, 0, 83, 1}, IL1Iii.IL1Iii(new byte[]{1, 93, 8, 81, 0, 1}, "780f1b"))));
            }
            if (iDeviceIdManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceIdManager;
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
                    String udid = getUDID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    String oaid = getOAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    String imei = getIMEI(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(imei);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    boolean zIsCoolOs = isCoolOs();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsCoolOs ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    String coolOsVersion = getCoolOsVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(coolOsVersion);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getAAID(String str) throws RemoteException;

    String getCoolOsVersion() throws RemoteException;

    String getIMEI(String str) throws RemoteException;

    String getOAID(String str) throws RemoteException;

    String getUDID(String str) throws RemoteException;

    String getVAID(String str) throws RemoteException;

    boolean isCoolOs() throws RemoteException;
}
