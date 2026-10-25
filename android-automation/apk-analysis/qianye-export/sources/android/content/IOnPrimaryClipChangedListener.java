package android.content;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IOnPrimaryClipChangedListener extends IInterface {

    public static class Default implements IOnPrimaryClipChangedListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.content.IOnPrimaryClipChangedListener
        public void dispatchPrimaryClipChanged() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnPrimaryClipChangedListener {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{89, 90, 1, 65, 11, 15, 92, 26, 6, 92, 10, 18, 93, 90, 17, 29, 45, 41, 86, 100, 23, 90, 9, 7, 74, 77, 38, 95, 13, 22, 123, 92, 4, 93, 3, 3, 92, 120, 12, 64, 16, 3, 86, 81, 23}, IL1Iii.IL1Iii(new byte[]{91, 3, 82, 80, 82, 4}, IL1Iii.IL1Iii(new byte[]{86, 1, 1, 0, 3, 1}, "566c5c")));
        public static final int TRANSACTION_dispatchPrimaryClipChanged = 1;

        public static class Proxy implements IOnPrimaryClipChangedListener {
            public static IOnPrimaryClipChangedListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.content.IOnPrimaryClipChangedListener
            public void dispatchPrimaryClipChanged() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{88, 93, 0, 75, 13, 93, 93, 29, 7, 86, 12, 64, 92, 93, 16, 23, 43, 123, 87, 99, 22, 80, 15, 85, 75, 74, 39, 85, 11, 68, 122, 91, 5, 87, 5, 81, 93, 127, 13, 74, 22, 81, 87, 86, 22}, IL1Iii.IL1Iii(new byte[]{88, 10, 1, 0, 7, 1}, IL1Iii.IL1Iii(new byte[]{83, 90, 7, 12, 7, 84}, "2cb5ba"))));
                    try {
                        if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().dispatchPrimaryClipChanged();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{4, 93, 6, 64, 93, 89, 1, 29, 1, 93, 92, 68, 0, 93, 22, 28, 123, 127, 11, 99, 16, 91, 95, 81, 23, 74, 33, 94, 91, 64, 38, 91, 3, 92, 85, 85, 1, 127, 11, 65, 70, 85, 11, 86, 16}, IL1Iii.IL1Iii(new byte[]{85, 7, 3, 10, 10, 84}, IL1Iii.IL1Iii(new byte[]{83, 3, 82, 15, 91, 86}, "c737c2")));
            }
        }

        public Stub() {
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{89, 94, 85, 23, 14, 10, 92, 30, 82, 10, 15, 23, 93, 94, 69, 75, 40, 44, 86, 96, 67, 12, 12, 2, 74, 73, 114, 9, 8, 19, 123, 88, 80, 11, 6, 6, 92, 124, 88, 22, 21, 6, 86, 85, 67}, IL1Iii.IL1Iii(new byte[]{93, 8, 5, 92, 84, 80}, IL1Iii.IL1Iii(new byte[]{85, 9, 4, 12, 83, 87}, "0105fd"))));
        }

        public static IOnPrimaryClipChangedListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOnPrimaryClipChangedListener)) ? new Proxy(iBinder) : (IOnPrimaryClipChangedListener) iInterfaceQueryLocalInterface;
        }

        public static IOnPrimaryClipChangedListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOnPrimaryClipChangedListener iOnPrimaryClipChangedListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{66, 82, 16, 118, 84, 81, 80, 66, 8, 70, 120, 90, 65, 91, 76, 27, 17, 84, 80, 91, 8, 87, 85, 23, 69, 64, 13, 81, 84}, IL1Iii.IL1Iii(new byte[]{6, 2, 0, 4, 87, 5}, IL1Iii.IL1Iii(new byte[]{1, 84, 5, 7, 82, 1}, "6aa143"))));
            }
            if (iOnPrimaryClipChangedListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOnPrimaryClipChangedListener;
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
                dispatchPrimaryClipChanged();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(str);
            return true;
        }
    }

    void dispatchPrimaryClipChanged() throws RemoteException;
}
