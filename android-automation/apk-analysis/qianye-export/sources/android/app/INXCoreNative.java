package android.app;

import I1I.I1I.ILil.InterfaceC0606LLlI1;
import I1I.I1I.ILil.L111;
import I1I.I1I.ILil.LL1IL;
import I1I.I1I.ILil.l;
import I1I.I1I.ILil.llliI;
import I1I.IL1Iii;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INXCoreNative extends IInterface {

    public static class Default implements INXCoreNative {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.INXCoreNative
        public void closeFile(long j) throws RemoteException {
        }

        @Override // android.app.INXCoreNative
        public llliI obtainAccessibityActionProxy() throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public IAccessibServiceProxy obtainAccessibityService() throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public Bundle obtainData(int i) throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public l obtainDataTask() throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public L111 obtainUiObjectProxy(int i) throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public long openFile(String str, int i) throws RemoteException {
            return 0L;
        }

        @Override // android.app.INXCoreNative
        public boolean openFileNew(String str, String str2, INXOpenFdEvent iNXOpenFdEvent) throws RemoteException {
            return false;
        }

        @Override // android.app.INXCoreNative
        public long readFile(long j, byte[] bArr) throws RemoteException {
            return 0L;
        }

        @Override // android.app.INXCoreNative
        public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
            return null;
        }

        @Override // android.app.INXCoreNative
        public boolean sendKeyEvent(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.app.INXCoreNative
        public void sendLog(int i, String str, String str2, long j, boolean z) throws RemoteException {
        }

        @Override // android.app.INXCoreNative
        public void sendTaskResultBundle(int i, long j, Bundle bundle) throws RemoteException {
        }

        @Override // android.app.INXCoreNative
        public boolean sendTouchEvent(int i, int i2, int i3, int i4) throws RemoteException {
            return false;
        }

        @Override // android.app.INXCoreNative
        public void setTsEventListener(int i, LL1IL ll1il) throws RemoteException {
        }

        @Override // android.app.INXCoreNative
        public long writeFile(long j, byte[] bArr, int i, int i2) throws RemoteException {
            return 0L;
        }
    }

    public static abstract class Stub extends Binder implements INXCoreNative {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{4, 91, 81, 68, 12, 15, 1, 27, 84, 70, 19, 72, 44, 123, 109, 117, 12, 20, 0, 123, 84, 66, 10, 16, 0}, IL1Iii.IL1Iii(new byte[]{4, 6, 7, 6, 7, 95}, IL1Iii.IL1Iii(new byte[]{89, 4, 6, 84, 7, 93}, "874dcd")));
        public static final int TRANSACTION_closeFile = 4;
        public static final int TRANSACTION_obtainAccessibityActionProxy = 13;
        public static final int TRANSACTION_obtainAccessibityService = 14;
        public static final int TRANSACTION_obtainData = 18;
        public static final int TRANSACTION_obtainDataTask = 11;
        public static final int TRANSACTION_obtainScriptProxy = 12;
        public static final int TRANSACTION_obtainUiObjectProxy = 10;
        public static final int TRANSACTION_obtainUiSelectorProxy = 9;
        public static final int TRANSACTION_openFile = 1;
        public static final int TRANSACTION_openFileNew = 5;
        public static final int TRANSACTION_readFile = 3;
        public static final int TRANSACTION_sendCmd = 6;
        public static final int TRANSACTION_sendKeyEvent = 17;
        public static final int TRANSACTION_sendLog = 8;
        public static final int TRANSACTION_sendTaskResultBundle = 7;
        public static final int TRANSACTION_sendTouchEvent = 16;
        public static final int TRANSACTION_setTsEventListener = 15;
        public static final int TRANSACTION_writeFile = 2;

        public static class Proxy implements INXCoreNative {
            public static INXCoreNative sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.app.INXCoreNative
            public void closeFile(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{0, 8, 92, 22, 94, 92, 5, 72, 89, 20, 65, 27, 40, 40, 96, 39, 94, 71, 4, 40, 89, 16, 88, 67, 4}, IL1Iii.IL1Iii(new byte[]{7, 4, 11, 85, 82, 3}, IL1Iii.IL1Iii(new byte[]{87, 82, 4, 3, 86, 80}, "10725f"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().closeFile(j);
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

            public String getInterfaceDescriptor() {
                return IL1Iii.IL1Iii(new byte[]{86, 87, 83, 19, 87, 95, 83, 23, 86, 17, 72, 24, 126, 119, 111, 34, 87, 68, 82, 119, 86, 21, 81, 64, 82}, IL1Iii.IL1Iii(new byte[]{14, 95, 3, 85, 89, 87}, IL1Iii.IL1Iii(new byte[]{1, 81, 3, 13, 83, 86}, "877927")));
            }

            @Override // android.app.INXCoreNative
            public llliI obtainAccessibityActionProxy() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{85, 11, 83, 71, 95, 94, 80, 75, 86, 69, 64, 25, 125, 43, 111, 118, 95, 69, 81, 43, 86, 65, 89, 65, 81}, IL1Iii.IL1Iii(new byte[]{80, 87, 0, 87, 7, 6}, IL1Iii.IL1Iii(new byte[]{2, 80, 6, 3, 81, 9}, "fb1af8"))));
                    try {
                        if (!this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            llliI llliiObtainAccessibityActionProxy = Stub.getDefaultImpl().obtainAccessibityActionProxy();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return llliiObtainAccessibityActionProxy;
                        }
                        parcelObtain2.readException();
                        llliI llliiIL1Iii = llliI.IL1Iii.IL1Iii(parcelObtain2.readStrongBinder());
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return llliiIL1Iii;
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

            @Override // android.app.INXCoreNative
            public IAccessibServiceProxy obtainAccessibityService() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{7, 93, 87, 70, 94, 12, 2, 29, 82, 68, 65, 75, 47, 125, 107, 119, 94, 23, 3, 125, 82, 64, 88, 19, 3}, IL1Iii.IL1Iii(new byte[]{84, 0, 1, 12, 87, 80}, IL1Iii.IL1Iii(new byte[]{86, 86, 3, 11, 3, 1}, "de13e4"))));
                    try {
                        if (!this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            IAccessibServiceProxy iAccessibServiceProxyObtainAccessibityService = Stub.getDefaultImpl().obtainAccessibityService();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return iAccessibServiceProxyObtainAccessibityService;
                        }
                        parcelObtain2.readException();
                        IAccessibServiceProxy iAccessibServiceProxyAsInterface = IAccessibServiceProxy.Stub.asInterface(parcelObtain2.readStrongBinder());
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iAccessibServiceProxyAsInterface;
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

            @Override // android.app.INXCoreNative
            public Bundle obtainData(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{2, 94, 2, 67, 10, 93, 7, 30, 7, 65, 21, 26, 42, 126, 62, 114, 10, 70, 6, 126, 7, 69, 12, 66, 6}, IL1Iii.IL1Iii(new byte[]{87, 9, 84, 83, 0, 3}, IL1Iii.IL1Iii(new byte[]{5, 11, 10, 86, 1, 4}, "1284d3"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            Bundle bundleObtainData = Stub.getDefaultImpl().obtainData(i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return bundleObtainData;
                        }
                        parcelObtain2.readException();
                        Bundle bundle = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundle;
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

            @Override // android.app.INXCoreNative
            public l obtainDataTask() throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{80, 12, 93, 67, 94, 81, 85, 76, 88, 65, 65, 22, 120, 44, 97, 114, 94, 74, 84, 44, 88, 69, 88, 78, 84}, IL1Iii.IL1Iii(new byte[]{7, 6, 91, 85, 5, 91}, IL1Iii.IL1Iii(new byte[]{2, 2, 90, 2, 80, 0}, "4f8fdc"))));
                    try {
                        if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            l lVarObtainDataTask = Stub.getDefaultImpl().obtainDataTask();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return lVarObtainDataTask;
                        }
                        parcelObtain2.readException();
                        l lVarIL1Iii = l.IL1Iii.IL1Iii(parcelObtain2.readStrongBinder());
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return lVarIL1Iii;
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

            @Override // android.app.INXCoreNative
            public INXCoreNative obtainScriptProxy(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{88, 13, 1, 70, 10, 13, 93, 77, 4, 68, 21, 74, 112, 45, 61, 119, 10, 22, 92, 45, 4, 64, 12, 18, 92}, IL1Iii.IL1Iii(new byte[]{13, 90, 1, 6, 3, 5}, IL1Iii.IL1Iii(new byte[]{0, 12, 81, 87, 95, 2}, "455e9c"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            INXCoreNative iNXCoreNativeObtainScriptProxy = Stub.getDefaultImpl().obtainScriptProxy(i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return iNXCoreNativeObtainScriptProxy;
                        }
                        parcelObtain2.readException();
                        INXCoreNative iNXCoreNativeAsInterface = Stub.asInterface(parcelObtain2.readStrongBinder());
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iNXCoreNativeAsInterface;
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

            @Override // android.app.INXCoreNative
            public L111 obtainUiObjectProxy(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{87, 11, 2, 71, 92, 90, 82, 75, 7, 69, 67, 29, 127, 43, 62, 118, 92, 65, 83, 43, 7, 65, 90, 69, 83}, IL1Iii.IL1Iii(new byte[]{1, 92, 2, 4, 81, 80}, IL1Iii.IL1Iii(new byte[]{82, 95, 85, 80, 80, 85}, "ef1a26"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            L111 l111ObtainUiObjectProxy = Stub.getDefaultImpl().obtainUiObjectProxy(i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return l111ObtainUiObjectProxy;
                        }
                        parcelObtain2.readException();
                        L111 l111IL1Iii = L111.IL1Iii.IL1Iii(parcelObtain2.readStrongBinder());
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return l111IL1Iii;
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

            @Override // android.app.INXCoreNative
            public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{3, 95, 5, 66, 89, 10, 6, 31, 0, 64, 70, 77, 43, 127, 57, 115, 89, 17, 7, 127, 0, 68, 95, 21, 7}, IL1Iii.IL1Iii(new byte[]{6, 84, 2, 81, 14, 83}, IL1Iii.IL1Iii(new byte[]{87, 80, 6, 80, 15, 0}, "35e170"))));
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            InterfaceC0606LLlI1 interfaceC0606LLlI1ObtainUiSelectorProxy = Stub.getDefaultImpl().obtainUiSelectorProxy(i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return interfaceC0606LLlI1ObtainUiSelectorProxy;
                        }
                        parcelObtain2.readException();
                        InterfaceC0606LLlI1 interfaceC0606LLlI1IL1Iii = InterfaceC0606LLlI1.IL1Iii.IL1Iii(parcelObtain2.readStrongBinder());
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return interfaceC0606LLlI1IL1Iii;
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

            @Override // android.app.INXCoreNative
            public long openFile(String str, int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{89, 94, 7, 16, 11, 95, 92, 30, 2, 18, 20, 24, 113, 126, 59, 33, 11, 68, 93, 126, 2, 22, 13, 64, 93}, IL1Iii.IL1Iii(new byte[]{13, 5, 83, 90, 85, 85}, IL1Iii.IL1Iii(new byte[]{6, 2, 85, 94, 6, 6}, "37ef7e"))));
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            long jOpenFile = Stub.getDefaultImpl().openFile(str, i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return jOpenFile;
                        }
                        parcelObtain2.readException();
                        long j = parcelObtain2.readLong();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return j;
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

            @Override // android.app.INXCoreNative
            public boolean openFileNew(String str, String str2, INXOpenFdEvent iNXOpenFdEvent) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{0, 94, 2, 74, 11, 89, 5, 30, 7, 72, 20, 30, 40, 126, 62, 123, 11, 66, 4, 126, 7, 76, 13, 70, 4}, IL1Iii.IL1Iii(new byte[]{86, 0, 94, 89, 92, 0}, IL1Iii.IL1Iii(new byte[]{14, 81, 91, 80, 13, 1}, "9ac151"))));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iNXOpenFdEvent != null ? iNXOpenFdEvent.asBinder() : null);
                    try {
                        if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zOpenFileNew = Stub.getDefaultImpl().openFileNew(str, str2, iNXOpenFdEvent);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zOpenFileNew;
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

            @Override // android.app.INXCoreNative
            public long readFile(long j, byte[] bArr) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{82, 94, 84, 19, 88, 92, 87, 30, 81, 17, 71, 27, 122, 126, 104, 34, 88, 71, 86, 126, 81, 21, 94, 67, 86}, IL1Iii.IL1Iii(new byte[]{7, 82, 86, 87, 7, 80}, IL1Iii.IL1Iii(new byte[]{2, 4, 82, 85, 1, 80}, "6f4c15"))));
                    parcelObtain.writeLong(j);
                    if (bArr == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(bArr.length);
                    }
                    try {
                        if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            long file = Stub.getDefaultImpl().readFile(j, bArr);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return file;
                        }
                        parcelObtain2.readException();
                        long j2 = parcelObtain2.readLong();
                        parcelObtain2.readByteArray(bArr);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return j2;
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

            @Override // android.app.INXCoreNative
            public String sendCmd(int i, int i2, int i3, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{89, 13, 83, 22, 93, 95, 92, 77, 86, 20, 66, 24, 113, 45, 111, 39, 93, 68, 93, 45, 86, 16, 91, 64, 93}, IL1Iii.IL1Iii(new byte[]{12, 87, 82, 7, 87, 2}, IL1Iii.IL1Iii(new byte[]{81, 81, 82, 5, 6, 86}, "ee7fcb"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // android.app.INXCoreNative
            public boolean sendKeyEvent(int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{4, 11, 84, 65, 14, 10, 1, 75, 81, 67, 17, 77, 44, 43, 104, 112, 14, 17, 0, 43, 81, 71, 8, 21, 0}, IL1Iii.IL1Iii(new byte[]{92, 7, 0, 80, 87, 85}, IL1Iii.IL1Iii(new byte[]{12, 6, 85, 85, 3, 87}, "5de65a"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zSendKeyEvent = Stub.getDefaultImpl().sendKeyEvent(i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zSendKeyEvent;
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

            @Override // android.app.INXCoreNative
            public void sendLog(int i, String str, String str2, long j, boolean z) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    int i2 = 1;
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{84, 15, 1, 70, 92, 88, 81, 79, 4, 68, 67, 31, 124, 47, 61, 119, 92, 67, 80, 47, 4, 64, 90, 71, 80}, IL1Iii.IL1Iii(new byte[]{4, 5, 3, 4, 0, 83}, IL1Iii.IL1Iii(new byte[]{4, 86, 82, 8, 82, 0}, "5248ab"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    if (!z) {
                        i2 = 0;
                    }
                    parcelObtain.writeInt(i2);
                    try {
                        if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().sendLog(i, str, str2, j, z);
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

            @Override // android.app.INXCoreNative
            public void sendTaskResultBundle(int i, long j, Bundle bundle) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{4, 12, 5, 68, 88, 95, 1, 76, 0, 70, 71, 24, 44, 44, 57, 117, 88, 68, 0, 44, 0, 66, 94, 64, 0}, IL1Iii.IL1Iii(new byte[]{0, 85, 88, 87, 81, 1}, IL1Iii.IL1Iii(new byte[]{80, 85, 15, 3, 3, 83}, "5b6bed"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    try {
                        if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().sendTaskResultBundle(i, j, bundle);
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

            @Override // android.app.INXCoreNative
            public boolean sendTouchEvent(int i, int i2, int i3, int i4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{87, 13, 87, 64, 91, 93, 82, 77, 82, 66, 68, 26, 127, 45, 107, 113, 91, 70, 83, 45, 82, 70, 93, 66, 83}, IL1Iii.IL1Iii(new byte[]{85, 84, 80, 1, 3, 3}, IL1Iii.IL1Iii(new byte[]{90, 7, 83, 1, 14, 5}, "900292"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    try {
                        if (!this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            boolean zSendTouchEvent = Stub.getDefaultImpl().sendTouchEvent(i, i2, i3, i4);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zSendTouchEvent;
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

            @Override // android.app.INXCoreNative
            public void setTsEventListener(int i, LL1IL ll1il) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{0, 86, 83, 20, 90, 95, 5, 22, 86, 22, 69, 24, 40, 118, 111, 37, 90, 68, 4, 118, 86, 18, 92, 64, 4}, IL1Iii.IL1Iii(new byte[]{85, 9, 15, 83, 5, 3}, IL1Iii.IL1Iii(new byte[]{5, 2, 0, 86, 86, 84}, "138cfa"))));
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(ll1il != null ? ll1il.asBinder() : null);
                    try {
                        if (this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().setTsEventListener(i, ll1il);
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

            @Override // android.app.INXCoreNative
            public long writeFile(long j, byte[] bArr, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{7, 10, 93, 23, 87, 90, 2, 74, 88, 21, 72, 29, 47, 42, 97, 38, 87, 65, 3, 42, 88, 17, 81, 69, 3}, IL1Iii.IL1Iii(new byte[]{7, 83, 10, 83, 92, 7}, IL1Iii.IL1Iii(new byte[]{87, 3, 87, 3, 86, 0}, "64d524"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            long jWriteFile = Stub.getDefaultImpl().writeFile(j, bArr, i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return jWriteFile;
                        }
                        parcelObtain2.readException();
                        long j2 = parcelObtain2.readLong();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return j2;
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{80, 86, 0, 64, 10, 90, 85, 22, 5, 66, 21, 29, 120, 118, 60, 113, 10, 65, 84, 118, 5, 70, 12, 69, 84}, IL1Iii.IL1Iii(new byte[]{80, 92, 81, 5, 4, 81}, IL1Iii.IL1Iii(new byte[]{5, 6, 2, 0, 87, 91}, "db7769"))));
        }

        public static INXCoreNative asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INXCoreNative)) ? new Proxy(iBinder) : (INXCoreNative) iInterfaceQueryLocalInterface;
        }

        public static INXCoreNative getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INXCoreNative iNXCoreNative) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{23, 93, 70, 39, 81, 82, 5, 77, 94, 23, 125, 89, 20, 84, 26, 74, 20, 87, 5, 84, 94, 6, 80, 20, 16, 79, 91, 0, 81}, IL1Iii.IL1Iii(new byte[]{80, 15, 11, 90, 80, 13}, IL1Iii.IL1Iii(new byte[]{4, 7, 1, 8, 82, 12}, "008165"))));
            }
            if (iNXCoreNative == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNXCoreNative;
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
                    long jOpenFile = openFile(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jOpenFile);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    long jWriteFile = writeFile(parcel.readLong(), parcel.createByteArray(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jWriteFile);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    long j = parcel.readLong();
                    int i3 = parcel.readInt();
                    byte[] bArr = i3 >= 0 ? new byte[i3] : null;
                    long file = readFile(j, bArr);
                    parcel2.writeNoException();
                    parcel2.writeLong(file);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    closeFile(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    boolean zOpenFileNew = openFileNew(parcel.readString(), parcel.readString(), INXOpenFdEvent.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zOpenFileNew ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    String strSendCmd = sendCmd(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strSendCmd);
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    sendTaskResultBundle(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(str);
                    sendLog(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(str);
                    InterfaceC0606LLlI1 interfaceC0606LLlI1ObtainUiSelectorProxy = obtainUiSelectorProxy(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(interfaceC0606LLlI1ObtainUiSelectorProxy != null ? interfaceC0606LLlI1ObtainUiSelectorProxy.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface(str);
                    L111 l111ObtainUiObjectProxy = obtainUiObjectProxy(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(l111ObtainUiObjectProxy != null ? l111ObtainUiObjectProxy.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface(str);
                    l lVarObtainDataTask = obtainDataTask();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(lVarObtainDataTask != null ? lVarObtainDataTask.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface(str);
                    INXCoreNative iNXCoreNativeObtainScriptProxy = obtainScriptProxy(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iNXCoreNativeObtainScriptProxy != null ? iNXCoreNativeObtainScriptProxy.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface(str);
                    llliI llliiObtainAccessibityActionProxy = obtainAccessibityActionProxy();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(llliiObtainAccessibityActionProxy != null ? llliiObtainAccessibityActionProxy.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface(str);
                    IAccessibServiceProxy iAccessibServiceProxyObtainAccessibityService = obtainAccessibityService();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iAccessibServiceProxyObtainAccessibityService != null ? iAccessibServiceProxyObtainAccessibityService.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface(str);
                    setTsEventListener(parcel.readInt(), LL1IL.IL1Iii.IL1Iii(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(str);
                    boolean zSendTouchEvent = sendTouchEvent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSendTouchEvent ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface(str);
                    boolean zSendKeyEvent = sendKeyEvent(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSendKeyEvent ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(str);
                    Bundle bundleObtainData = obtainData(parcel.readInt());
                    parcel2.writeNoException();
                    if (bundleObtainData != null) {
                        parcel2.writeInt(1);
                        bundleObtainData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void closeFile(long j) throws RemoteException;

    llliI obtainAccessibityActionProxy() throws RemoteException;

    IAccessibServiceProxy obtainAccessibityService() throws RemoteException;

    Bundle obtainData(int i) throws RemoteException;

    l obtainDataTask() throws RemoteException;

    INXCoreNative obtainScriptProxy(int i) throws RemoteException;

    L111 obtainUiObjectProxy(int i) throws RemoteException;

    InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException;

    long openFile(String str, int i) throws RemoteException;

    boolean openFileNew(String str, String str2, INXOpenFdEvent iNXOpenFdEvent) throws RemoteException;

    long readFile(long j, byte[] bArr) throws RemoteException;

    String sendCmd(int i, int i2, int i3, String str) throws RemoteException;

    boolean sendKeyEvent(int i, int i2) throws RemoteException;

    void sendLog(int i, String str, String str2, long j, boolean z) throws RemoteException;

    void sendTaskResultBundle(int i, long j, Bundle bundle) throws RemoteException;

    boolean sendTouchEvent(int i, int i2, int i3, int i4) throws RemoteException;

    void setTsEventListener(int i, LL1IL ll1il) throws RemoteException;

    long writeFile(long j, byte[] bArr, int i, int i2) throws RemoteException;
}
