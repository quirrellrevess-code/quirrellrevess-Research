package I1I.I1I.ILil;

import android.app.IAccessibServiceProxy;
import android.app.INXCoreNative;
import android.app.INXOpenFdEvent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.main.engine.BinderContainer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: CoreServiceProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public long f3096I1I = 0;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public C1 f3097IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public INXCoreNative f3098ILil;

    /* JADX INFO: compiled from: CoreServiceProxy.java */
    public class IL1Iii implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ BinderContainer f3100IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ IBinder.DeathRecipient f3101ILil;

        public IL1Iii(BinderContainer binderContainer, IBinder.DeathRecipient deathRecipient) {
            this.f3100IL1Iii = binderContainer;
            this.f3101ILil = deathRecipient;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (ILL.this.f3098ILil.asBinder() == this.f3100IL1Iii.binder) {
                ILL.this.f3098ILil = null;
            }
            this.f3100IL1Iii.binder.unlinkToDeath(this, 0);
            IBinder.DeathRecipient deathRecipient = this.f3101ILil;
            if (deathRecipient != null) {
                deathRecipient.binderDied();
            }
        }
    }

    /* JADX INFO: compiled from: CoreServiceProxy.java */
    public class ILil extends INXOpenFdEvent.Stub {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3102ILil;

        public ILil(ILL ill, String str) {
            this.f3102ILil = str;
        }

        @Override // android.app.INXOpenFdEvent
        public boolean onOpend(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
            try {
                if (parcelFileDescriptor == null) {
                    return false;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f3102ILil);
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                try {
                                    byte[] bArr = new byte[10240];
                                    while (true) {
                                        int i = bufferedInputStream.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, i);
                                        bufferedOutputStream.flush();
                                        try {
                                            throw th;
                                        } catch (Throwable th) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                            throw th;
                                        }
                                    }
                                    bufferedOutputStream.close();
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                    fileInputStream.close();
                                    if (parcelFileDescriptor != null) {
                                        try {
                                            parcelFileDescriptor.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    return true;
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Throwable th5) {
                                            th3.addSuppressed(th5);
                                        }
                                        throw th4;
                                    }
                                }
                            } catch (Throwable th6) {
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            try {
                                throw th7;
                            } catch (Throwable th8) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th9) {
                                    th7.addSuppressed(th9);
                                }
                                throw th8;
                            }
                        }
                    } catch (Throwable th10) {
                        try {
                            throw th10;
                        } catch (Throwable th11) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th12) {
                                th10.addSuppressed(th12);
                            }
                            throw th11;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th13) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th13;
            }
        }
    }

    public ILL(C1 c1, Bundle bundle, IBinder.DeathRecipient deathRecipient) {
        IBinder iBinder;
        try {
            this.f3097IL1Iii = c1;
            bundle.setClassLoader(BinderContainer.class.getClassLoader());
            BinderContainer binderContainer = (BinderContainer) bundle.getParcelable(I1I.IL1Iii.IL1Iii(new byte[]{85, 95, 9, 77, 95, 73, 24, 83, 11, 17, 84, 31, 65, 66, 5, 19, 65, 84, 68, 67, 74, 10, 95, 69, 83, 94, 16, 77, 84, 73, 66, 66, 5, 77, 115, 120, 120, 116, 33, 49}, I1I.IL1Iii.IL1Iii(new byte[]{14, 84, 85, 1, 83, 0}, I1I.IL1Iii.IL1Iii(new byte[]{10, 86, 4, 82, 87, 84}, "22505e"))));
            if (binderContainer == null || (iBinder = binderContainer.binder) == null || !iBinder.pingBinder()) {
                return;
            }
            this.f3098ILil = INXCoreNative.Stub.asInterface(binderContainer.binder);
            binderContainer.binder.linkToDeath(new IL1Iii(binderContainer, deathRecipient), 0);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 111}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 85, 12, 2, 83}, I1I.IL1Iii.IL1Iii(new byte[]{3, 80, 84, 89, 7, 87}, "6d5a31"))), I1I.IL1Iii.IL1Iii(new byte[]{91, 11, 12, 65, 18, 64, 77, 7, 22, 18, 3, 64, 74, 89, 92}, I1I.IL1Iii.IL1Iii(new byte[]{8, 2, 85, 0, 94, 10}, I1I.IL1Iii.IL1Iii(new byte[]{4, 95, 7, 81, 15, 14}, "490c76"))) + e.toString());
        }
    }

    public String I11L(int i, int i2, int i3, String str) {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            if (iNXCoreNative == null || iNXCoreNative.asBinder() == null || !this.f3098ILil.asBinder().isBinderAlive()) {
                return null;
            }
            return this.f3098ILil.sendCmd(i, i2, i3, str);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 58}, I1I.IL1Iii.IL1Iii(new byte[]{9, 1, 84, 80, 10, 89}, I1I.IL1Iii.IL1Iii(new byte[]{9, 5, 2, 80, 0, 0}, "8f748a"))), I1I.IL1Iii.IL1Iii(new byte[]{65, 83, 93, 85, 114, 95, 86, 22, 118, 67, 67, 93, 64, 12}, I1I.IL1Iii.IL1Iii(new byte[]{11, 82, 81, 8, 9, 80}, I1I.IL1Iii.IL1Iii(new byte[]{91, 7, 83, 92, 12, 91}, "bc1e49"))) + e.toString() + I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{89, 0, 83, 1, 86, 87}, I1I.IL1Iii.IL1Iii(new byte[]{7, 84, 6, 7, 6, 84}, "ff003f"))) + i);
            return null;
        }
    }

    public String I11li1(int i, int i2) {
        return m872lL(i, i2, 0);
    }

    public void I1I() {
        iIlLiL(1);
    }

    public INXCoreNative ILL(int i) {
        try {
            return this.f3098ILil.obtainScriptProxy(i);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m860ILl(String str, INXOpenFdEvent iNXOpenFdEvent) {
        try {
            return this.f3098ILil.openFileNew(str, I1I.IL1Iii.IL1Iii(new byte[]{70}, I1I.IL1Iii.IL1Iii(new byte[]{81, 81, 81, 1, 81, 11}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 0, 4, 87, 92}, "ed7f2e"))), iNXOpenFdEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean Ilil(String str, String str2) {
        try {
            this.f3098ILil.openFileNew(str, I1I.IL1Iii.IL1Iii(new byte[]{67}, I1I.IL1Iii.IL1Iii(new byte[]{1, 82, 86, 93, 90, 83}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 86, 3, 7, 85}, "c02feb"))), new ILil(this, str2));
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 108}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 80, 93, 91, 4}, I1I.IL1Iii.IL1Iii(new byte[]{15, 0, 80, 0, 6, 86}, "9cbde3"))), e.toString());
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x01bc A[Catch: Exception -> 0x01bf, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x01bf, blocks: (B:18:0x0140, B:39:0x01bc), top: B:70:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m861IL(String str, String str2) throws Throwable {
        long jOpenFile;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                try {
                    jOpenFile = this.f3098ILil.openFile(str, 1);
                    try {
                        try {
                            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 109}, I1I.IL1Iii.IL1Iii(new byte[]{13, 12, 93, 7, 80, 6}, I1I.IL1Iii.IL1Iii(new byte[]{7, 93, 87, 3, 0, 2}, "2d31fa"))), I1I.IL1Iii.IL1Iii(new byte[]{92, 66, 87, 92, 35, 95, 95, 87, 18}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 81, 10, 85, 14}, I1I.IL1Iii.IL1Iii(new byte[]{85, 80, 0, 9, 4, 14}, "fac146"))) + str + I1I.IL1Iii.IL1Iii(new byte[]{89}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 5, 87, 1, 2}, I1I.IL1Iii.IL1Iii(new byte[]{80, 2, 1, 0, 0, 81}, "a6517a"))) + jOpenFile);
                            long j = 0;
                            if (jOpenFile == 0) {
                                if (jOpenFile != 0) {
                                    try {
                                        this.f3098ILil.closeFile(jOpenFile);
                                    } catch (Exception unused) {
                                    }
                                }
                                fileOutputStream2.close();
                                return false;
                            }
                            byte[] bArr = new byte[10240];
                            while (true) {
                                long file = this.f3098ILil.readFile(jOpenFile, bArr);
                                if (file > j) {
                                    fileOutputStream2.write(bArr, 0, (int) file);
                                    fileOutputStream2.flush();
                                    j = 0;
                                } else {
                                    try {
                                        break;
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                            fileOutputStream2.getFD().sync();
                            fileOutputStream2.close();
                            this.f3098ILil.closeFile(jOpenFile);
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused3) {
                            }
                            return true;
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            try {
                                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 105}, I1I.IL1Iii.IL1Iii(new byte[]{7, 9, 85, 83, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 9, 0, 83, 0, 87}, "a1c0ea"))), e.toString());
                                if (jOpenFile != 0) {
                                    try {
                                        this.f3098ILil.closeFile(jOpenFile);
                                    } catch (Exception unused4) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (jOpenFile != 0) {
                                    try {
                                        this.f3098ILil.closeFile(jOpenFile);
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (fileOutputStream == null) {
                                    throw th;
                                }
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (jOpenFile != 0) {
                            this.f3098ILil.closeFile(jOpenFile);
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    jOpenFile = 0;
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 105}, I1I.IL1Iii.IL1Iii(new byte[]{7, 9, 85, 83, 84, 82}, I1I.IL1Iii.IL1Iii(new byte[]{87, 9, 0, 83, 0, 87}, "a1c0ea"))), e.toString());
                    if (jOpenFile != 0) {
                        this.f3098ILil.closeFile(jOpenFile);
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    jOpenFile = 0;
                    if (jOpenFile != 0) {
                        this.f3098ILil.closeFile(jOpenFile);
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception unused7) {
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public IAccessibServiceProxy m862IiL() {
        try {
            return this.f3098ILil.obtainAccessibityService();
        } catch (Exception unused) {
            return null;
        }
    }

    public void Lil(int i, String str, String str2) {
        long j;
        try {
            int iMin = 2048;
            if (str2.length() <= 2048) {
                this.f3098ILil.sendLog(i, str, str2, 0L, true);
                return;
            }
            synchronized (this) {
                j = this.f3096I1I + 1;
                this.f3096I1I = j;
            }
            int i2 = 0;
            while (i2 < str2.length()) {
                this.f3098ILil.sendLog(i, str, str2.substring(i2, iMin), j, iMin >= str2.length());
                i2 = iMin;
                iMin = Math.min(iMin + 2048, str2.length());
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{47, 96}, I1I.IL1Iii.IL1Iii(new byte[]{2, 8, 83, 87, 90, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 0, 0, 14, 88}, "4da169"))), e.toString());
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String LlLI1(String str) throws Throwable {
        long jOpenFile;
        try {
            try {
                jOpenFile = this.f3098ILil.openFile(str, 1);
                try {
                    if (jOpenFile == 0) {
                        if (jOpenFile == 0) {
                            return null;
                        }
                        this.f3098ILil.closeFile(jOpenFile);
                        return null;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[10240];
                        while (true) {
                            long file = this.f3098ILil.readFile(jOpenFile, bArr);
                            if (file <= 0) {
                                byteArrayOutputStream.close();
                                this.f3098ILil.closeFile(jOpenFile);
                                return byteArrayOutputStream.toString();
                            }
                            byteArrayOutputStream.write(bArr, 0, (int) file);
                        }
                    } catch (Exception e) {
                        e = e;
                    }
                    this.f3098ILil.closeFile(jOpenFile);
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                jOpenFile = 0;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        this.f3098ILil.closeFile(0L);
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                this.f3098ILil.closeFile(0L);
            }
            throw th;
        }
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 108}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 14, 87, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 84, 4, 0, 5, 82}, "55335b"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 0, 12, 93, 32, 90, 8, 0, 66, 124, 20, 65, 94}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 83, 0, 87, 1}, I1I.IL1Iii.IL1Iii(new byte[]{2, 5, 85, 0, 2, 3}, "03d931"))) + e.toString());
        if (jOpenFile == 0) {
            return null;
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public InterfaceC0606LLlI1 m863Ll1(int i) {
        try {
            return this.f3098ILil.obtainUiSelectorProxy(i);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public INXCoreNative m864L11I() {
        return this.f3098ILil;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public void m865LlLLL(int i, LL1IL ll1il) {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            if (iNXCoreNative != null) {
                iNXCoreNative.setTsEventListener(i, ll1il);
            }
        } catch (Exception unused) {
        }
    }

    public boolean iIi1(int i, int i2) {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            if (iNXCoreNative != null) {
                return iNXCoreNative.sendKeyEvent(i, i2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String iIlLiL(int i) {
        return I11li1(i, 0);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public llliI m866iILLL1() {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            if (iNXCoreNative != null) {
                return iNXCoreNative.obtainAccessibityActionProxy();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public L111 m867lIiI(int i) {
        try {
            return this.f3098ILil.obtainUiObjectProxy(i);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x012c A[EXC_TOP_SPLITTER, PHI: r4
  0x012c: PHI (r4v4 long) = (r4v3 long), (r4v5 long) binds: [B:23:0x0208, B:12:0x012a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m868lIlii(String str, String str2) throws Throwable {
        long jOpenFile;
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                jOpenFile = this.f3098ILil.openFile(str2, 2);
                try {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 97}, I1I.IL1Iii.IL1Iii(new byte[]{90, 90, 86, 89, 81, 81}, I1I.IL1Iii.IL1Iii(new byte[]{0, 6, 81, 4, 7, 84}, "ce4e51"))), I1I.IL1Iii.IL1Iii(new byte[]{9, 66, 82, 90, 119, 80, 10, 87, 13}, I1I.IL1Iii.IL1Iii(new byte[]{82, 0, 83, 2, 8, 8}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 6, 0, 9, 7}, "cfb606"))) + str2 + I1I.IL1Iii.IL1Iii(new byte[]{95}, I1I.IL1Iii.IL1Iii(new byte[]{81, 0, 81, 82, 0, 83}, I1I.IL1Iii.IL1Iii(new byte[]{4, 3, 1, 5, 4, 81}, "12e2ec"))) + jOpenFile);
                    if (jOpenFile != 0) {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                fileInputStream.close();
                                this.f3098ILil.closeFile(jOpenFile);
                                return true;
                            }
                            this.f3098ILil.writeFile(jOpenFile, bArr, 0, i);
                        }
                    } else if (jOpenFile != 0) {
                        try {
                            this.f3098ILil.closeFile(jOpenFile);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{43, 59}, I1I.IL1Iii.IL1Iii(new byte[]{6, 2, 2, 4, 0, 11}, I1I.IL1Iii.IL1Iii(new byte[]{81, 88, 6, 3, 81, 8}, "297fc0"))), I1I.IL1Iii.IL1Iii(new byte[]{70, 87, 15, 84, 117, 13, 89, 87, 65, 117, 65, 22, 15}, I1I.IL1Iii.IL1Iii(new byte[]{12, 3, 84, 9, 7, 83}, I1I.IL1Iii.IL1Iii(new byte[]{15, 3, 13, 90, 80, 6}, "628cd1"))) + e.toString());
                    if (jOpenFile != 0) {
                        this.f3098ILil.closeFile(jOpenFile);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                jOpenFile = 0;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        this.f3098ILil.closeFile(0L);
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                this.f3098ILil.closeFile(0L);
            }
            throw th;
        }
    }

    public String llliI(int i, int i2, int i3, String str) throws Exception {
        INXCoreNative iNXCoreNative = this.f3098ILil;
        if (iNXCoreNative == null || iNXCoreNative.asBinder() == null || !this.f3098ILil.asBinder().isBinderAlive()) {
            return null;
        }
        return this.f3098ILil.sendCmd(i, i2, i3, str);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0143 A[EXC_TOP_SPLITTER, PHI: r3
  0x0143: PHI (r3v5 long) = (r3v4 long), (r3v6 long) binds: [B:22:0x0219, B:11:0x0141] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0225 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m869llL1ii(String str, String str2) {
        long jOpenFile;
        try {
            jOpenFile = this.f3098ILil.openFile(str, 2);
            try {
                try {
                    Log.i(I1I.IL1Iii.IL1Iii(new byte[]{43, 62}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 84, 81, 87, 83}, I1I.IL1Iii.IL1Iii(new byte[]{6, 84, 7, 3, 86, 7}, "765050"))), I1I.IL1Iii.IL1Iii(new byte[]{92, 69, 1, 87, 116, 80, 95, 80, 94}, I1I.IL1Iii.IL1Iii(new byte[]{85, 81, 80, 11, 80, 12}, I1I.IL1Iii.IL1Iii(new byte[]{5, 85, 0, 4, 85, 13}, "c14678"))) + str + I1I.IL1Iii.IL1Iii(new byte[]{15}, I1I.IL1Iii.IL1Iii(new byte[]{5, 85, 0, 4, 6, 82}, I1I.IL1Iii.IL1Iii(new byte[]{8, 0, 81, 88, 81, 84}, "9ac9d6"))) + jOpenFile);
                    if (jOpenFile != 0) {
                        int iMin = Math.min(10240, str2.length() + 0);
                        int i = 0;
                        while (iMin > 0) {
                            int i2 = iMin + i;
                            byte[] bytes = str2.substring(i, i2).getBytes();
                            this.f3098ILil.writeFile(jOpenFile, bytes, 0, bytes.length);
                            i = i2;
                            iMin = Math.min(10240, str2.length() - i2);
                        }
                        this.f3098ILil.closeFile(jOpenFile);
                        return true;
                    }
                    if (jOpenFile != 0) {
                        try {
                            this.f3098ILil.closeFile(jOpenFile);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (jOpenFile != 0) {
                        try {
                            this.f3098ILil.closeFile(jOpenFile);
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{127, 97}, I1I.IL1Iii.IL1Iii(new byte[]{2, 93, 2, 95, 87, 81}, I1I.IL1Iii.IL1Iii(new byte[]{11, 92, 6, 93, 2, 0}, "883df4"))), I1I.IL1Iii.IL1Iii(new byte[]{23, 93, 95, 82, 39, 90, 8, 93, 17, 115, 19, 65, 94}, I1I.IL1Iii.IL1Iii(new byte[]{5, 94, 84, 83, 80, 2}, I1I.IL1Iii.IL1Iii(new byte[]{89, 95, 87, 92, 83, 6}, "8929b7"))) + e.toString());
                if (jOpenFile != 0) {
                    this.f3098ILil.closeFile(jOpenFile);
                }
            }
        } catch (Exception e2) {
            e = e2;
            jOpenFile = 0;
        } catch (Throwable th2) {
            th = th2;
            jOpenFile = 0;
            if (jOpenFile != 0) {
                this.f3098ILil.closeFile(jOpenFile);
            }
            throw th;
        }
        return false;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m870lLi1LL() {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            return iNXCoreNative != null && iNXCoreNative.asBinder().isBinderAlive();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public l m871il() {
        try {
            return this.f3098ILil.obtainDataTask();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public String m872lL(int i, int i2, int i3) {
        return I11L(i, i2, i3, BuildConfig.FLAVOR);
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public void m873l(int i, long j, Bundle bundle) {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            if (iNXCoreNative == null || iNXCoreNative.asBinder() == null || !this.f3098ILil.asBinder().isBinderAlive()) {
                return;
            }
            this.f3098ILil.sendTaskResultBundle(i, j, bundle);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public boolean m8741(int i, int i2, int i3, int i4) {
        try {
            INXCoreNative iNXCoreNative = this.f3098ILil;
            if (iNXCoreNative != null) {
                return iNXCoreNative.sendTouchEvent(i, i2, i3, i4);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
