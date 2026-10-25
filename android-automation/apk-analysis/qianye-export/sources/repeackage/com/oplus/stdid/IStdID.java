package repeackage.com.oplus.stdid;

import I1I.IL1Iii;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import repeackage.com.heytap.openid.IOpenID;

/* JADX INFO: loaded from: classes.dex */
public interface IStdID extends IOpenID {

    public static abstract class Stub extends IOpenID.Stub {
        private static final String DESCRIPTOR = IL1Iii.IL1Iii(new byte[]{83, 9, 12, 26, 95, 18, 92, 19, 18, 26, 67, 22, 84, 15, 5, 26, 121, 49, 68, 2, 40, 112}, IL1Iii.IL1Iii(new byte[]{86, 81, 2, 87, 4, 82}, IL1Iii.IL1Iii(new byte[]{95, 1, 6, 90, 81, 86}, "96e9ef")));
        public static final int TRANSACTION_getSerID = 1;

        public static class Proxy implements IStdID {
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
                return IL1Iii.IL1Iii(new byte[]{83, 91, 84, 76, 92, 69, 92, 65, 74, 76, 64, 65, 84, 93, 93, 76, 122, 102, 68, 80, 112, 38}, IL1Iii.IL1Iii(new byte[]{82, 86, 14, 85, 85, 12}, IL1Iii.IL1Iii(new byte[]{82, 81, 82, 82, 2, 11}, "03eed2")));
            }

            @Override // repeackage.com.heytap.openid.IOpenID
            public String getSerID(String str, String str2, String str3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IL1Iii.IL1Iii(new byte[]{80, 9, 12, 28, 91, 72, 95, 19, 18, 28, 71, 76, 87, 15, 5, 28, 125, 107, 71, 2, 40, 118}, IL1Iii.IL1Iii(new byte[]{1, 3, 5, 86, 87, 0}, IL1Iii.IL1Iii(new byte[]{84, 6, 2, 93, 2, 92}, "fcf9ad"))));
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
            attachInterface(this, IL1Iii.IL1Iii(new byte[]{87, 88, 14, 25, 11, 20, 88, 66, 16, 25, 23, 16, 80, 94, 7, 25, 45, 55, 64, 83, 42, 115}, IL1Iii.IL1Iii(new byte[]{0, 83, 5, 0, 83, 83}, IL1Iii.IL1Iii(new byte[]{87, 6, 85, 2, 2, 2}, "cb3555"))));
        }

        public static IStdID asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IStdID)) ? new Proxy(iBinder) : (IStdID) iInterfaceQueryLocalInterface;
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
    }
}
