package android.app;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INXOpenFdEvent extends IInterface {

    public static class Default implements INXOpenFdEvent {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.INXOpenFdEvent
        public boolean onOpend(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements INXOpenFdEvent {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{81, 8, 2, 75, 9, 81, 84, 72, 7, 73, 22, 22, 121, 40, 62, 118, 22, 93, 94, 32, 2, 124, 16, 93, 94, 18}, IL1Iii.IL1Iii(new byte[]{81, 80, 84, 12, 4, 91}, IL1Iii.IL1Iii(new byte[]{5, 0, 0, 81, 1, 91}, "d62dc8")));
        public static final int TRANSACTION_onOpend = 1;

        public static class Proxy implements INXOpenFdEvent {
            public static INXOpenFdEvent sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{85, 95, 1, 75, 94, 88, 80, 31, 4, 73, 65, 31, 125, 127, 61, 118, 65, 84, 90, 119, 1, 124, 71, 84, 90, 69}, IL1Iii.IL1Iii(new byte[]{4, 2, 81, 12, 80, 84}, IL1Iii.IL1Iii(new byte[]{4, 87, 4, 0, 82, 7}, "4d053b")));
            }

            @Override // android.app.INXOpenFdEvent
            public boolean onOpend(ParcelFileDescriptor parcelFileDescriptor) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{2, 92, 82, 71, 87, 80, 7, 28, 87, 69, 72, 23, 42, 124, 110, 122, 72, 92, 13, 116, 82, 112, 78, 92, 13, 70}, IL1Iii.IL1Iii(new byte[]{6, 4, 87, 2, 90, 92}, IL1Iii.IL1Iii(new byte[]{4, 87, 85, 3, 3, 87}, "aa44a2"))));
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zOnOpend = Stub.getDefaultImpl().onOpend(parcelFileDescriptor);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zOnOpend;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{86, 91, 81, 66, 88, 10, 83, 27, 84, 64, 71, 77, 126, 123, 109, 127, 71, 6, 89, 115, 81, 117, 65, 6, 89, 65}, IL1Iii.IL1Iii(new byte[]{84, 81, 13, 7, 1, 91}, IL1Iii.IL1Iii(new byte[]{82, 92, 15, 83, 7, 89}, "187d1a"))));
        }

        public static INXOpenFdEvent asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INXOpenFdEvent)) ? new Proxy(iBinder) : (INXOpenFdEvent) iInterfaceQueryLocalInterface;
        }

        public static INXOpenFdEvent getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INXOpenFdEvent iNXOpenFdEvent) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{16, 7, 64, 32, 93, 0, 2, 23, 88, 16, 113, 11, 19, 14, 28, 77, 24, 5, 2, 14, 88, 1, 92, 70, 23, 21, 93, 7, 93}, IL1Iii.IL1Iii(new byte[]{81, 3, 81, 93, 15, 5}, IL1Iii.IL1Iii(new byte[]{4, 3, 80, 93, 81, 91}, "6b5df8"))));
            }
            if (iNXOpenFdEvent == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNXOpenFdEvent;
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
            boolean zOnOpend = onOpend(parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zOnOpend ? 1 : 0);
            return true;
        }
    }

    boolean onOpend(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;
}
