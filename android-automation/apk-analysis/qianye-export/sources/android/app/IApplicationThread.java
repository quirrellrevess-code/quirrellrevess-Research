package android.app;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IApplicationThread extends IInterface {

    public static class Default implements IApplicationThread {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IApplicationThread {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{87, 93, 93, 64, 12, 11, 82, 29, 88, 66, 19, 76, 127, 114, 73, 66, 15, 11, 85, 82, 77, 91, 12, 12, 98, 91, 75, 87, 2, 6}, IL1Iii.IL1Iii(new byte[]{84, 4, 13, 0, 2, 91}, IL1Iii.IL1Iii(new byte[]{81, 86, 12, 83, 81, 15}, "3a8a06")));

        public static class Proxy implements IApplicationThread {
            public static IApplicationThread sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{84, 13, 2, 64, 9, 8, 81, 77, 7, 66, 22, 79, 124, 34, 22, 66, 10, 8, 86, 2, 18, 91, 9, 15, 97, 11, 20, 87, 7, 5}, IL1Iii.IL1Iii(new byte[]{6, 90, 82, 11, 5, 84}, IL1Iii.IL1Iii(new byte[]{2, 9, 7, 90, 2, 1}, "103ca4")));
            }
        }

        public Stub() {
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{2, 15, 92, 19, 12, 12, 7, 79, 89, 17, 19, 75, 42, 32, 72, 17, 15, 12, 0, 0, 76, 8, 12, 11, 55, 9, 74, 4, 2, 1}, IL1Iii.IL1Iii(new byte[]{85, 4, 10, 87, 86, 92}, IL1Iii.IL1Iii(new byte[]{4, 86, 2, 1, 1, 88}, "23074a"))));
        }

        public static IApplicationThread asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IApplicationThread)) ? new Proxy(iBinder) : (IApplicationThread) iInterfaceQueryLocalInterface;
        }

        public static IApplicationThread getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IApplicationThread iApplicationThread) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{23, 81, 64, 34, 93, 85, 5, 65, 88, 18, 113, 94, 20, 88, 28, 79, 24, 80, 5, 88, 88, 3, 92, 19, 16, 67, 93, 5, 93}, IL1Iii.IL1Iii(new byte[]{86, 81, 4, 82, 12, 5}, IL1Iii.IL1Iii(new byte[]{2, 93, 0, 85, 5, 84}, "080a1b"))));
            }
            if (iApplicationThread == null) {
                return false;
            }
            Proxy.sDefaultImpl = iApplicationThread;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(str);
            return true;
        }
    }
}
