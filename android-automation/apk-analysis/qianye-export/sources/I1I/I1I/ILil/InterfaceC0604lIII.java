package I1I.I1I.ILil;

import android.app.INXCoreNative;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: I1I.I1I.ILil.lI丨II, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: IScriptProxy.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0604lIII extends IInterface {

    /* JADX INFO: renamed from: I1I.I1I.ILil.lI丨II$IL1Iii */
    /* JADX INFO: compiled from: IScriptProxy.java */
    public static abstract class IL1Iii extends Binder implements InterfaceC0604lIII {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final String f3265ILil = I1I.IL1Iii.IL1Iii(new byte[]{5, 90, 93, 75, 9, 84, 15, 91, 30, 0, 10, 82, 15, 91, 85, 75, 45, 102, 5, 71, 89, 21, 16, 101, 20, 90, 72, 28}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 81, 84, 92, 81}, I1I.IL1Iii.IL1Iii(new byte[]{81, 85, 86, 9, 91, 80}, "2478c4")));

        /* JADX INFO: renamed from: I1I.I1I.ILil.lI丨II$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IScriptProxy.java */
        public static class C0526IL1Iii implements InterfaceC0604lIII {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public static InterfaceC0604lIII f3266I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public IBinder f3267ILil;

            public C0526IL1Iii(IBinder iBinder) {
                this.f3267ILil = iBinder;
            }

            @Override // I1I.I1I.ILil.InterfaceC0604lIII
            public void ILil(INXCoreNative iNXCoreNative) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 11, 76, 85, 2, 90, 87, 72, 7, 86, 4, 90, 87, 3, 76, 113, 48, 80, 75, 15, 18, 76, 51, 65, 86, 30, 27}, I1I.IL1Iii.IL1Iii(new byte[]{80, 88, 2, 87, 12, 86}, I1I.IL1Iii.IL1Iii(new byte[]{85, 84, 2, 87, 0, 3}, "65fb46"))));
                    parcelObtain.writeStrongBinder(iNXCoreNative != null ? iNXCoreNative.asBinder() : null);
                    try {
                        if (this.f3267ILil.transact(3, parcelObtain, parcelObtain2, 0) || IL1Iii.m1028IL() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            IL1Iii.m1028IL().ILil(iNXCoreNative);
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

            @Override // I1I.I1I.ILil.InterfaceC0604lIII
            /* JADX INFO: renamed from: I丨iL */
            public void mo1025IiL(Intent intent) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{5, 94, 88, 29, 88, 87, 15, 95, 27, 86, 91, 81, 15, 95, 80, 29, 124, 101, 5, 67, 92, 67, 65, 102, 20, 94, 77, 74}, I1I.IL1Iii.IL1Iii(new byte[]{7, 5, 0, 6, 80, 1}, I1I.IL1Iii.IL1Iii(new byte[]{89, 82, 80, 80, 81, 86}, "8fee4a"))));
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    try {
                        if (this.f3267ILil.transact(4, parcelObtain, parcelObtain2, 0) || IL1Iii.m1028IL() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            IL1Iii.m1028IL().mo1025IiL(intent);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3267ILil;
            }

            @Override // I1I.I1I.ILil.InterfaceC0604lIII
            /* JADX INFO: renamed from: l丨Li1LL */
            public void mo1026lLi1LL(int i, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{5, 13, 88, 26, 8, 3, 15, 12, 27, 81, 11, 5, 15, 12, 80, 26, 44, 49, 5, 16, 92, 68, 17, 50, 20, 13, 77, 77}, I1I.IL1Iii.IL1Iii(new byte[]{3, 7, 5, 1, 80, 3}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 4, 0, 13, 2}, "b3458c"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    try {
                        if (this.f3267ILil.transact(1, parcelObtain, parcelObtain2, 0) || IL1Iii.m1028IL() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            IL1Iii.m1028IL().mo1026lLi1LL(i, str);
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

            @Override // I1I.I1I.ILil.InterfaceC0604lIII
            /* JADX INFO: renamed from: 丨il */
            public void mo1027il(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{80, 12, 9, 76, 14, 83, 90, 13, 74, 7, 13, 85, 90, 13, 1, 76, 42, 97, 80, 17, 13, 18, 23, 98, 65, 12, 28, 27}, I1I.IL1Iii.IL1Iii(new byte[]{10, 85, 80, 1, 83, 4}, I1I.IL1Iii.IL1Iii(new byte[]{8, 87, 3, 84, 84, 4}, "1a77d2"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (this.f3267ILil.transact(2, parcelObtain, parcelObtain2, 0) || IL1Iii.m1028IL() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            IL1Iii.m1028IL().mo1027il(i);
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

        public IL1Iii() {
            attachInterface(this, I1I.IL1Iii.IL1Iii(new byte[]{5, 9, 11, 76, 91, 88, 15, 8, 72, 7, 88, 94, 15, 8, 3, 76, 127, 106, 5, 20, 15, 18, 66, 105, 20, 9, 30, 27}, I1I.IL1Iii.IL1Iii(new byte[]{86, 0, 5, 6, 84, 88}, I1I.IL1Iii.IL1Iii(new byte[]{6, 4, 80, 5, 81, 0}, "6b3a3a"))));
        }

        public static InterfaceC0604lIII IL1Iii(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f3265ILil);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0604lIII)) ? new C0526IL1Iii(iBinder) : (InterfaceC0604lIII) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static InterfaceC0604lIII m1028IL() {
            return C0526IL1Iii.f3266I1I;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = f3265ILil;
            if (i == 1) {
                parcel.enforceInterface(str);
                mo1026lLi1LL(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                mo1027il(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(str);
                ILil(INXCoreNative.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            mo1025IiL(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void ILil(INXCoreNative iNXCoreNative) throws RemoteException;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    void mo1025IiL(Intent intent) throws RemoteException;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    void mo1026lLi1LL(int i, String str) throws RemoteException;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    void mo1027il(int i) throws RemoteException;
}
