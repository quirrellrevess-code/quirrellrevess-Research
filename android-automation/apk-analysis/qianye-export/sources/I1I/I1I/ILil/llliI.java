package I1I.I1I.ILil;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IAccessibilityActionProxy.java */
/* JADX INFO: loaded from: classes.dex */
public interface llliI extends IInterface {

    /* JADX INFO: compiled from: IAccessibilityActionProxy.java */
    public static abstract class IL1Iii extends Binder implements llliI {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final String f3280ILil = I1I.IL1Iii.IL1Iii(new byte[]{80, 87, 93, 29, 9, 5, 90, 86, 30, 86, 10, 3, 90, 86, 85, 29, 45, 37, 80, 91, 85, 64, 23, 13, 81, 81, 92, 90, 16, 29, 114, 91, 68, 90, 11, 10, 99, 74, 95, 75, 29}, I1I.IL1Iii.IL1Iii(new byte[]{6, 93, 3, 3, 92, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 81, 10, 86, 0, 85}, "c49f80")));

        /* JADX INFO: renamed from: I1I.I1I.ILil.llliI$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IAccessibilityActionProxy.java */
        public static class C0527IL1Iii implements llliI {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public static llliI f3281I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public IBinder f3282ILil;

            public C0527IL1Iii(IBinder iBinder) {
                this.f3282ILil = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3282ILil;
            }

            @Override // I1I.I1I.ILil.llliI
            public boolean click(int i, int i2, int i3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{91, 10, 92, 24, 9, 4, 81, 11, 31, 83, 10, 2, 81, 11, 84, 24, 45, 36, 91, 6, 84, 69, 23, 12, 90, 12, 93, 95, 16, 28, 121, 6, 69, 95, 11, 11, 104, 23, 94, 78, 29}, I1I.IL1Iii.IL1Iii(new byte[]{0, 4, 2, 14, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{91, 83, 80, 91, 80, 81}, "c2cc50"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    try {
                        if (!this.f3282ILil.transact(2, parcelObtain, parcelObtain2, 0) && IL1Iii.m1032IL() != null) {
                            boolean zClick = IL1Iii.m1032IL().click(i, i2, i3);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zClick;
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

            @Override // I1I.I1I.ILil.llliI
            public boolean dispatchGesture(String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 84, 27, 85, 3, 13, 12, 23, 80, 86, 5, 13, 12, 92, 27, 113, 35, 7, 1, 92, 70, 75, 11, 6, 11, 85, 92, 76, 27, 37, 1, 77, 92, 87, 12, 52, 16, 86, 77, 65}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 1, 7, 89, 87}, I1I.IL1Iii.IL1Iii(new byte[]{90, 82, 11, 6, 2, 7}, "8634c2"))));
                    parcelObtain.writeString(str);
                    try {
                        if (!this.f3282ILil.transact(5, parcelObtain, parcelObtain2, 0) && IL1Iii.m1032IL() != null) {
                            boolean zDispatchGesture = IL1Iii.m1032IL().dispatchGesture(str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zDispatchGesture;
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

            @Override // I1I.I1I.ILil.llliI
            public boolean keyPress(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{6, 95, 9, 31, 95, 80, 12, 94, 74, 84, 92, 86, 12, 94, 1, 31, 123, 112, 6, 83, 1, 66, 65, 88, 7, 89, 8, 88, 70, 72, 36, 83, 16, 88, 93, 95, 53, 66, 11, 73, 75}, I1I.IL1Iii.IL1Iii(new byte[]{7, 6, 1, 83, 6, 3}, I1I.IL1Iii.IL1Iii(new byte[]{91, 87, 80, 83, 86, 2}, "9a51b0"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.f3282ILil.transact(1, parcelObtain, parcelObtain2, 0) && IL1Iii.m1032IL() != null) {
                            boolean zKeyPress = IL1Iii.m1032IL().keyPress(i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zKeyPress;
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

            @Override // I1I.I1I.ILil.llliI
            public boolean longClick(int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{5, 12, 14, 22, 85, 0, 15, 13, 77, 93, 86, 6, 15, 13, 6, 22, 113, 32, 5, 0, 6, 75, 75, 8, 4, 10, 15, 81, 76, 24, 39, 0, 23, 81, 87, 15, 54, 17, 12, 64, 65}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 6, 15, 9, 88}, I1I.IL1Iii.IL1Iii(new byte[]{93, 2, 0, 15, 87, 95}, "8ae8ff"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.f3282ILil.transact(3, parcelObtain, parcelObtain2, 0) && IL1Iii.m1032IL() != null) {
                            boolean zLongClick = IL1Iii.m1032IL().longClick(i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zLongClick;
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

            @Override // I1I.I1I.ILil.llliI
            public boolean swipe(int i, int i2, int i3, int i4, int i5) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{1, 13, 94, 25, 84, 3, 11, 12, 29, 82, 87, 5, 11, 12, 86, 25, 112, 35, 1, 1, 86, 68, 74, 11, 0, 11, 95, 94, 77, 27, 35, 1, 71, 94, 86, 12, 50, 16, 92, 79, 64}, I1I.IL1Iii.IL1Iii(new byte[]{90, 83, 82, 14, 90, 87}, I1I.IL1Iii.IL1Iii(new byte[]{91, 9, 82, 10, 83, 3}, "c83306"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    try {
                        if (!this.f3282ILil.transact(4, parcelObtain, parcelObtain2, 0) && IL1Iii.m1032IL() != null) {
                            boolean zSwipe = IL1Iii.m1032IL().swipe(i, i2, i3, i4, i5);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zSwipe;
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

        public IL1Iii() {
            attachInterface(this, I1I.IL1Iii.IL1Iii(new byte[]{90, 92, 11, 27, 12, 7, 80, 93, 72, 80, 15, 1, 80, 93, 3, 27, 40, 39, 90, 80, 3, 70, 18, 15, 91, 90, 10, 92, 21, 31, 120, 80, 18, 92, 14, 8, 105, 65, 9, 77, 24}, I1I.IL1Iii.IL1Iii(new byte[]{92, 82, 81, 2, 80, 0}, I1I.IL1Iii.IL1Iii(new byte[]{83, 7, 82, 0, 4, 3}, "6fe75e"))));
        }

        public static llliI IL1Iii(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f3280ILil);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof llliI)) ? new C0527IL1Iii(iBinder) : (llliI) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static llliI m1032IL() {
            return C0527IL1Iii.f3281I1I;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = f3280ILil;
            if (i == 1) {
                parcel.enforceInterface(str);
                boolean zKeyPress = keyPress(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(zKeyPress ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                boolean zClick = click(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(zClick ? 1 : 0);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(str);
                boolean zLongClick = longClick(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(zLongClick ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(str);
                boolean zSwipe = swipe(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(zSwipe ? 1 : 0);
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
            boolean zDispatchGesture = dispatchGesture(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(zDispatchGesture ? 1 : 0);
            return true;
        }
    }

    boolean click(int i, int i2, int i3) throws RemoteException;

    boolean dispatchGesture(String str) throws RemoteException;

    boolean keyPress(int i) throws RemoteException;

    boolean longClick(int i, int i2) throws RemoteException;

    boolean swipe(int i, int i2, int i3, int i4, int i5) throws RemoteException;
}
