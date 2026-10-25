package android.app;

import I1I.IL1Iii;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAccessibServiceProxy extends IInterface {

    public static class Default implements IAccessibServiceProxy {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.IAccessibServiceProxy
        public AccessibilityNodeInfo getRootInActiveWindow() throws RemoteException {
            return null;
        }

        @Override // android.app.IAccessibServiceProxy
        public List<AccessibilityNodeInfo> getWindows() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAccessibServiceProxy {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{5, 94, 80, 17, 94, 10, 0, 30, 85, 19, 65, 77, 45, 113, 87, 0, 84, 16, 23, 89, 86, 48, 84, 17, 18, 89, 87, 6, 97, 17, 11, 72, 77}, IL1Iii.IL1Iii(new byte[]{6, 86, 86, 6, 0, 80}, IL1Iii.IL1Iii(new byte[]{3, 3, 91, 6, 87, 82}, "ae9cfa")));
        public static final int TRANSACTION_getRootInActiveWindow = 2;
        public static final int TRANSACTION_getWindows = 1;

        public static class Proxy implements IAccessibServiceProxy {
            public static IAccessibServiceProxy sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{89, 13, 5, 23, 93, 10, 92, 77, 0, 21, 66, 77, 113, 34, 2, 6, 87, 16, 75, 10, 3, 54, 87, 17, 78, 10, 2, 0, 98, 17, 87, 27, 24}, IL1Iii.IL1Iii(new byte[]{90, 2, 85, 7, 80, 84}, IL1Iii.IL1Iii(new byte[]{90, 4, 81, 83, 87, 2}, "8ee155")));
            }

            @Override // android.app.IAccessibServiceProxy
            public AccessibilityNodeInfo getRootInActiveWindow() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{84, 87, 85, 17, 93, 15, 81, 23, 80, 19, 66, 72, 124, 120, 82, 0, 87, 21, 70, 80, 83, 48, 87, 20, 67, 80, 82, 6, 98, 20, 90, 65, 72}, IL1Iii.IL1Iii(new byte[]{81, 1, 8, 1, 87, 85}, IL1Iii.IL1Iii(new byte[]{92, 12, 90, 84, 82, 86}, "84c67e"))));
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            AccessibilityNodeInfo rootInActiveWindow = Stub.getDefaultImpl().getRootInActiveWindow();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return rootInActiveWindow;
                        }
                        parcelObtain2.readException();
                        AccessibilityNodeInfo accessibilityNodeInfo = parcelObtain2.readInt() != 0 ? (AccessibilityNodeInfo) AccessibilityNodeInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return accessibilityNodeInfo;
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

            @Override // android.app.IAccessibServiceProxy
            public List<AccessibilityNodeInfo> getWindows() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{80, 15, 82, 23, 94, 11, 85, 79, 87, 21, 65, 76, 120, 32, 85, 6, 84, 17, 66, 8, 84, 54, 84, 16, 71, 8, 85, 0, 97, 16, 94, 25, 79}, IL1Iii.IL1Iii(new byte[]{87, 2, 5, 86, 6, 0}, IL1Iii.IL1Iii(new byte[]{80, 6, 87, 11, 82, 82}, "6ed8e0"))));
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            List<AccessibilityNodeInfo> windows = Stub.getDefaultImpl().getWindows();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return windows;
                        }
                        parcelObtain2.readException();
                        ArrayList arrayListCreateTypedArrayList = parcelObtain2.createTypedArrayList(AccessibilityNodeInfo.CREATOR);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return arrayListCreateTypedArrayList;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{84, 8, 87, 74, 90, 95, 81, 72, 82, 72, 69, 24, 124, 39, 80, 91, 80, 69, 70, 15, 81, 107, 80, 68, 67, 15, 80, 93, 101, 68, 90, 30, 74}, IL1Iii.IL1Iii(new byte[]{87, 2, 85, 11, 4, 83}, IL1Iii.IL1Iii(new byte[]{81, 84, 81, 86, 7, 87}, "307e62"))));
        }

        public static IAccessibServiceProxy asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAccessibServiceProxy)) ? new Proxy(iBinder) : (IAccessibServiceProxy) iInterfaceQueryLocalInterface;
        }

        public static IAccessibServiceProxy getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAccessibServiceProxy iAccessibServiceProxy) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{74, 4, 18, 124, 3, 84, 88, 20, 10, 76, 47, 95, 73, 13, 78, 17, 70, 81, 88, 13, 10, 93, 2, 18, 77, 22, 15, 91, 3}, IL1Iii.IL1Iii(new byte[]{91, 81, 5, 13, 0, 4}, IL1Iii.IL1Iii(new byte[]{87, 5, 82, 87, 2, 82}, "551bdd"))));
            }
            if (iAccessibServiceProxy == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAccessibServiceProxy;
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
                List<AccessibilityNodeInfo> windows = getWindows();
                parcel2.writeNoException();
                parcel2.writeTypedList(windows);
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
            AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
            parcel2.writeNoException();
            if (rootInActiveWindow != null) {
                parcel2.writeInt(1);
                rootInActiveWindow.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    AccessibilityNodeInfo getRootInActiveWindow() throws RemoteException;

    List<AccessibilityNodeInfo> getWindows() throws RemoteException;
}
