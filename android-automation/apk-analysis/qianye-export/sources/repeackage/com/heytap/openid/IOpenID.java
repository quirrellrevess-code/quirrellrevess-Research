package repeackage.com.heytap.openid;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IOpenID extends IInterface {

    public static class Default implements IOpenID {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // repeackage.com.heytap.openid.IOpenID
        public String getSerID(String str, String str2, String str3) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOpenID {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{6, 88, 12, 76, 90, 92, 28, 67, 0, 18, 28, 86, 21, 82, 15, 11, 86, 23, 44, 120, 17, 7, 92, 112, 33}, IL1Iii.IL1Iii(new byte[]{7, 5, 80, 7, 2, 0}, IL1Iii.IL1Iii(new byte[]{3, 84, 9, 83, 8, 93}, "af868d")));
        public static final int TRANSACTION_getSerID = 1;

        public static class Proxy implements IOpenID {
            public static IOpenID sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{87, 95, 92, 29, 14, 86, 77, 68, 80, 67, 72, 92, 68, 85, 95, 90, 2, 29, 125, 127, 65, 86, 8, 122, 112}, IL1Iii.IL1Iii(new byte[]{2, 5, 5, 1, 7, 11}, IL1Iii.IL1Iii(new byte[]{5, 0, 12, 6, 89, 92}, "35848d")));
            }

            @Override // repeackage.com.heytap.openid.IOpenID
            public String getSerID(String str, String str2, String str3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{2, 10, 12, 31, 89, 81, 24, 17, 0, 65, 31, 91, 17, 0, 15, 88, 85, 26, 40, 42, 17, 84, 95, 125, 37}, IL1Iii.IL1Iii(new byte[]{87, 7, 87, 87, 2, 3}, IL1Iii.IL1Iii(new byte[]{7, 0, 5, 0, 81, 83}, "1b3fbd"))));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String serID = Stub.getDefaultImpl().getSerID(str, str2, str3);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return serID;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{91, 93, 91, 77, 11, 87, 65, 70, 87, 19, 77, 93, 72, 87, 88, 10, 7, 28, 113, 125, 70, 6, 13, 123, 124}, IL1Iii.IL1Iii(new byte[]{10, 3, 4, 84, 80, 87}, IL1Iii.IL1Iii(new byte[]{81, 87, 87, 86, 7, 81}, "cfea44"))));
        }

        public static IOpenID asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOpenID)) ? new Proxy(iBinder) : (IOpenID) iInterfaceQueryLocalInterface;
        }

        public static IOpenID getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOpenID iOpenID) {
            if (Proxy.sDefaultImpl != null || iOpenID == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOpenID;
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
            String serID = getSerID(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(serID);
            return true;
        }
    }

    String getSerID(String str, String str2, String str3) throws RemoteException;
}
