package android.app;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INXCoreShell extends IInterface {

    public static class Default implements INXCoreShell {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.INXCoreShell
        public ParcelFileDescriptor openFileNew(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreShell
        public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INXCoreShell {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{85, 95, 6, 65, 11, 8, 80, 31, 3, 67, 20, 79, 125, 127, 58, 112, 11, 19, 81, 98, 10, 86, 8, 13}, IL1Iii.IL1Iii(new byte[]{81, 9, 91, 11, 86, 5}, IL1Iii.IL1Iii(new byte[]{85, 15, 90, 11, 11, 2}, "07c39f")));
        public static final int TRANSACTION_openFileNew = 1;
        public static final int TRANSACTION_sendCmd = 2;

        public static class Proxy implements INXCoreShell {
            public static INXCoreShell sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{3, 86, 83, 67, 94, 10, 6, 22, 86, 65, 65, 77, 43, 118, 111, 114, 94, 17, 7, 107, 95, 84, 93, 15}, IL1Iii.IL1Iii(new byte[]{1, 14, 5, 80, 6, 6}, IL1Iii.IL1Iii(new byte[]{90, 0, 10, 81, 82, 82}, "9680e7")));
            }

            @Override // android.app.INXCoreShell
            public ParcelFileDescriptor openFileNew(String str, String str2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{5, 10, 82, 23, 12, 91, 0, 74, 87, 21, 19, 28, 45, 42, 110, 38, 12, 64, 1, 55, 94, 0, 15, 94}, IL1Iii.IL1Iii(new byte[]{93, 93, 6, 6, 81, 10}, IL1Iii.IL1Iii(new byte[]{90, 13, 2, 6, 5, 15}, "c42e77"))));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            ParcelFileDescriptor parcelFileDescriptorOpenFileNew = Stub.getDefaultImpl().openFileNew(str, str2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return parcelFileDescriptorOpenFileNew;
                        }
                        parcelObtain2.readException();
                        ParcelFileDescriptor parcelFileDescriptor = parcelObtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return parcelFileDescriptor;
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

            @Override // android.app.INXCoreShell
            public String sendCmd(int i, int i2, int i3, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{86, 91, 80, 75, 92, 89, 83, 27, 85, 73, 67, 30, 126, 123, 108, 122, 92, 66, 82, 102, 92, 92, 95, 92}, IL1Iii.IL1Iii(new byte[]{84, 3, 4, 1, 82, 8}, IL1Iii.IL1Iii(new byte[]{90, 83, 7, 89, 82, 12}, "9e7a34"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            String strSendCmd = Stub.getDefaultImpl().sendCmd(i, i2, i3, str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strSendCmd;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{84, 8, 93, 20, 11, 10, 81, 72, 88, 22, 20, 77, 124, 40, 97, 37, 11, 17, 80, 53, 81, 3, 8, 15}, IL1Iii.IL1Iii(new byte[]{5, 82, 93, 82, 2, 87}, IL1Iii.IL1Iii(new byte[]{6, 5, 7, 85, 82, 0}, "61ca44"))));
        }

        public static INXCoreShell asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INXCoreShell)) ? new Proxy(iBinder) : (INXCoreShell) iInterfaceQueryLocalInterface;
        }

        public static INXCoreShell getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INXCoreShell iNXCoreShell) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{67, 86, 77, 113, 81, 86, 81, 70, 85, 65, 125, 93, 64, 95, 17, 28, 20, 83, 81, 95, 85, 80, 80, 16, 68, 68, 80, 86, 81}, IL1Iii.IL1Iii(new byte[]{84, 3, 8, 4, 0, 83}, IL1Iii.IL1Iii(new byte[]{2, 9, 4, 4, 4, 87}, "f95504"))));
            }
            if (iNXCoreShell == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNXCoreShell;
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
                ParcelFileDescriptor parcelFileDescriptorOpenFileNew = openFileNew(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (parcelFileDescriptorOpenFileNew != null) {
                    parcel2.writeInt(1);
                    parcelFileDescriptorOpenFileNew.writeToParcel(parcel2, 1);
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
            String strSendCmd = sendCmd(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strSendCmd);
            return true;
        }
    }

    ParcelFileDescriptor openFileNew(String str, String str2) throws RemoteException;

    String sendCmd(int i, int i2, int i3, String str) throws RemoteException;
}
