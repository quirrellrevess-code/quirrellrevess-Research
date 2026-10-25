package I1I.I1I.ILil;

import I1I.I1I.p008IL.C0610il;
import android.accessibilityservice.AccessibilityService;
import android.app.IAccessibServiceProxy;
import android.app.INXCoreNative;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.flexbox.BuildConfig;
import com.main.app.ImeInput;
import com.main.app.MainService;
import com.main.app.Native;
import com.main.app.NativeService;
import com.main.engine.BinderContainer;
import com.main.engine.SharedMem;
import com.p000nx.assist.UIMgr;
import com.p000nx.assist.log.Console;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: ScriptEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class iIilII1 extends I1I.I1I.ILil.lIlii implements C1, I1I.I1I.ILil.lIiI.I1I {
    public static final iIilII1 LL1IL = new iIilII1();
    public C1 llliI;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object f990IL = new Object();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public I1I.I1I.ILil.ILL f3192Ilil = null;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public INXCoreNative f1000lLi1LL = null;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public INXCoreNative f995iILLL1 = null;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public Intent f991IiL = null;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public L1iI1 f993L11I = null;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public InterfaceC0606LLlI1 f1001il = null;
    public i11i ILL = null;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public I1I.I1I.ILil.lIiI f992Ll1 = null;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public I1I.I1I.ILil.IL1Iii f996lIiI = null;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public I1I.I1I.ILil.ILil f989ILl = null;
    public boolean Lil = false;
    public SharedMem LlLI1 = null;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public File f999llL1ii = null;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public String f998lIlii = BuildConfig.FLAVOR;
    public String iIi1 = BuildConfig.FLAVOR;
    public long iIlLiL = 0;
    public Map<Long, StringBuilder> I11li1 = new ConcurrentHashMap();

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public boolean f1002lL = false;
    public boolean I11L = false;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public Handler f1003l = null;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public InterfaceC0604lIII f10041 = null;

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public Context f994LlLLL = null;

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public ServiceConnection f997lIII = null;

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class I1I implements LlLLL {
        public I1I(iIilII1 iiilii1) {
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void IL1Iii() {
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void ILil() {
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3193I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3194ILil;

        public IL1Iii(String str, int i) {
            this.f3194ILil = str;
            this.f3193I1I = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string;
            long j = 0;
            try {
                JSONObject jSONObject = new JSONObject(this.f3194ILil);
                j = jSONObject.getLong(I1I.IL1Iii.IL1Iii(new byte[]{70, 0, 70, 10, 120, 92}, I1I.IL1Iii.IL1Iii(new byte[]{2, 84, 5, 83, 3, 14}, "050226")));
                string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{7, 75, 84}, I1I.IL1Iii.IL1Iii(new byte[]{82, 15, 4, 80, 6, 14}, "4675c7")));
            } catch (Exception unused) {
                string = BuildConfig.FLAVOR;
            }
            boolean zDispatchGesture = iIilII1.this.f989ILl.dispatchGesture(string);
            Bundle bundle = new Bundle();
            bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{2, 8, 86}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 3, 8, 7, 90}, "b311ac")), this.f3193I1I);
            if (zDispatchGesture) {
                bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{23, 81, 66}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 6, 87, 1, 87}, "3a034e")), 1);
            } else {
                bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{69, 1, 17}, I1I.IL1Iii.IL1Iii(new byte[]{0, 82, 84, 82, 7, 82}, "761c73")), 0);
            }
            try {
                iIilII1.this.f3192Ilil.m873l(this.f3193I1I, j, bundle);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class ILL implements ServiceConnection {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f3195I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public boolean f3196IL1Iii = false;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ C1 f3197ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ Context f1006IL;

        public ILL(C1 c1, String str, Context context) {
            this.f3197ILil = c1;
            this.f3195I1I = str;
            this.f1006IL = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InterfaceC0604lIII interfaceC0604lIIIIL1Iii = InterfaceC0604lIII.IL1Iii.IL1Iii(iBinder);
            iIilII1.this.f10041 = interfaceC0604lIIIIL1Iii;
            iIilII1.this.m981iIl1il();
            I1I.I1I.p008IL.lIlii.m1148iIL(true, 0);
            try {
                C1 c1 = this.f3197ILil;
                int i = ((c1 instanceof I1I.I1I.ILil.IL) || (c1 instanceof I11li1)) ? 1 : 0;
                interfaceC0604lIIIIL1Iii.mo1025IiL(iIilII1.this.f991IiL);
                interfaceC0604lIIIIL1Iii.mo1026lLi1LL(i, this.f3195I1I);
            } catch (Exception e) {
                this.f3196IL1Iii = true;
                I1I.I1I.p008IL.lIlii.m1148iIL(false, 6);
                I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-124, -92, -99, -44, -23, -112, -124, -68, -81, -44, -60, -77, -124, -72, -92, -44, -33, -70, -124, -116, -118, 11}, I1I.IL1Iii.IL1Iii(new byte[]{87, 4, 80, 2, 91, 93}, "60b38e")) + e.toString());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (!this.f3196IL1Iii) {
                this.f3196IL1Iii = true;
                I1I.I1I.p008IL.lIlii.m1148iIL(false, 7);
                I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-114, -74, -1, -44, -8, -97, -128, -82, -24, -41, -18, -110, -127, -119, -10, -44, -7, -84, -128, -92, -56, -41, -40, -77}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 85, 11, 84, 5}, "2b0906")));
            }
            try {
                this.f1006IL.unbindService(this);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class ILil implements I1I.I1I.IL1Iii.IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3199I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ int f3200IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3201ILil;

        public ILil(iIilII1 iiilii1, int i, String str, int i2) {
            this.f3200IL1Iii = i;
            this.f3201ILil = str;
            this.f3199I1I = i2;
        }

        @Override // I1I.I1I.IL1Iii.IL1Iii
        public boolean IL1Iii(ImeInput imeInput, boolean z) {
            int i = 0;
            if (imeInput == null) {
                return false;
            }
            int i2 = this.f3200IL1Iii;
            if (i2 == 37) {
                if (imeInput.m3446IL(this.f3201ILil)) {
                    return true;
                }
            } else {
                if (i2 == 40) {
                    return this.f3199I1I == 0 ? imeInput.IL1Iii() : imeInput.ILil();
                }
                if (i2 == 41) {
                    try {
                        i = Integer.parseInt(this.f3201ILil);
                    } catch (Exception unused) {
                    }
                    return imeInput.m3447lLi1LL(this.f3199I1I, i);
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$IL丨丨l, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class C0601ILl implements I1I.p062Ilil.p064Ilil.IL1Iii.ILil {
        public C0601ILl() {
        }

        @Override // I1I.p062Ilil.p064Ilil.IL1Iii.ILil
        public Set<Integer> I1I() {
            return null;
        }

        @Override // I1I.p062Ilil.p064Ilil.IL1Iii.ILil
        public boolean IL1Iii(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                if (accessibilityEvent.getEventType() != 64) {
                    return false;
                }
                return false;
            }
            CharSequence className = accessibilityEvent.getClassName();
            CharSequence packageName = accessibilityEvent.getPackageName();
            if (TextUtils.isEmpty(className) || TextUtils.isEmpty(packageName) || !iIilII1.this.m980iI1iI(packageName.toString(), className.toString())) {
                return false;
            }
            iIilII1.this.f998lIlii = packageName.toString();
            iIilII1.this.iIi1 = className.toString();
            return false;
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class IL implements Runnable {

        /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$I丨L$IL1Iii */
        /* JADX INFO: compiled from: ScriptEngine.java */
        public class IL1Iii implements LlLLL {
            public IL1Iii() {
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void IL1Iii() {
                I1I.I1I.p008IL.lIlii.lILi1lLl(iIilII1.this.f994LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{-34, -91, -23, -128, -24, -107, -35, -87, -53, -128, -24, -100, -35, -99, -43, -115, -42, -111}, I1I.IL1Iii.IL1Iii(new byte[]{15, 1, 1, 1, 80, 6}, "78ed22")));
            }

            @Override // I1I.I1I.ILil.LlLLL
            public void ILil() {
                I1I.I1I.p008IL.lIlii.lILi1lLl(iIilII1.this.f994LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{-41, -81, -17, -47, -77, -107, -44, -93, -51, -47, -77, -100, -41, -69, -14, -47, -77, -85}, I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 80, 2, 14, 86}, "2b267b")));
            }
        }

        public IL() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I1I.I1I.p008IL.lIlii.lILi1lLl(iIilII1.this.f994LlLLL, I1I.IL1Iii.IL1Iii(new byte[]{-47, -87, -69, -47, -20, -61, -47, -121, -105, -46, -6, -21, -46, -91, -103, -47, -20, -54, -40, -119, -70, -46, -53, -63, -46, -87, -98, -47, -10, -51, -46, -65, -98, -46, -6, -17, -46, -65, -105}, I1I.IL1Iii.IL1Iii(new byte[]{15, 7, 84, 87, 5, 81}, "82bcc3")));
            I1I.I1I.ILil.LlLI1.m925IL().I1I(iIilII1.this.f994LlLLL).ILL(iIilII1.this.f994LlLLL, new IL1Iii());
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class IiL implements IBinder.DeathRecipient {
        public IiL() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            try {
                I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-115, -26, -1, -123, -88, -101, -115, -35, -2, -124, -100, -68, -125, -2, -24, -122, -66, -106, -126, -39, -10, -123, -87, -88, -127, -35, -60, -122, -69, -128}, I1I.IL1Iii.IL1Iii(new byte[]{1, 0, 0, 2, 13, 81}, "dbea9f")));
                try {
                    iIilII1.this.m1029Ll1();
                    I1I.I1I.p008IL.lIlii.m1148iIL(false, 8);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class Lil implements I1I.p062Ilil.p064Ilil.IL1Iii.IiL {
        public Lil() {
        }

        @Override // I1I.p062Ilil.p064Ilil.IL1Iii.IiL
        public void IL1Iii(com.p000nx.uiauto.accessibility.AccessibilityService accessibilityService) {
            try {
                if (iIilII1.this.f993L11I == null || iIilII1.this.f993L11I.m902Ll1() == null) {
                    return;
                }
                iIilII1.this.f993L11I.m902Ll1().mo859lLi1LL(-3);
            } catch (Exception unused) {
            }
        }

        @Override // I1I.p062Ilil.p064Ilil.IL1Iii.IiL
        public void ILil(com.p000nx.uiauto.accessibility.AccessibilityService accessibilityService) {
            try {
                if (iIilII1.this.f993L11I == null || iIilII1.this.f993L11I.m902Ll1() == null) {
                    return;
                }
                iIilII1.this.f993L11I.m902Ll1().mo859lLi1LL(-2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class LlLI1 implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f3207ILil;

        public LlLI1(iIilII1 iiilii1, int i) {
            this.f3207ILil = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3207ILil == 1) {
                I1I.I1I.p008IL.LlLI1.ILil(I1I.I1I.p008IL.lIlii.LL1IL());
            } else {
                I1I.I1I.p008IL.LlLI1.IL1Iii(I1I.I1I.p008IL.lIlii.LL1IL());
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$Ll丨1, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class Ll1 implements LlLLL {
        public Ll1(iIilII1 iiilii1) {
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void IL1Iii() {
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void ILil() {
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$L丨1丨1丨I, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class L11I implements LlLLL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f3208I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Context f3209IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ C1 f3210ILil;

        public L11I(Context context, C1 c1, String str) {
            this.f3209IL1Iii = context;
            this.f3210ILil = c1;
            this.f3208I1I = str;
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void IL1Iii() {
            I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-35, -123, -12, -48, -15, -17, -33, -126, -14, -48, -1, -2, -35, -74, -20, -33, -60, -23}, I1I.IL1Iii.IL1Iii(new byte[]{8, 91, 84, 7, 3, 86}, "0b51a7")));
            I1I.I1I.p008IL.lIlii.m1148iIL(false, 0);
        }

        @Override // I1I.I1I.ILil.LlLLL
        public void ILil() {
            iIilII1.this.m995(this.f3209IL1Iii, this.f3210ILil, this.f3208I1I);
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class iIi1 implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3211I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3212ILil;

        public iIi1(String str, int i) {
            this.f3212ILil = str;
            this.f3211I1I = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            try {
                j = new JSONObject(this.f3212ILil).getLong(I1I.IL1Iii.IL1Iii(new byte[]{21, 85, 22, 83, 126, 6}, I1I.IL1Iii.IL1Iii(new byte[]{80, 87, 0, 13, 83, 3}, "1ce5da")));
            } catch (Exception unused) {
                j = 0;
            }
            iIilII1.this.m10lL(this.f3211I1I, j);
        }
    }

    /* JADX INFO: compiled from: ScriptEngine.java */
    public class iIlLiL implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f3213I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3214ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f1009IL;

        public iIlLiL(String str, int i, int i2) {
            this.f3214ILil = str;
            this.f3213I1I = i;
            this.f1009IL = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            boolean zM983iILilI;
            try {
                j = new JSONObject(this.f3214ILil).getLong(I1I.IL1Iii.IL1Iii(new byte[]{23, 81, 74, 89, 127, 92}, I1I.IL1Iii.IL1Iii(new byte[]{90, 81, 10, 5, 83, 11}, "9a37e3")));
            } catch (Exception unused) {
                j = 0;
            }
            int i = this.f3213I1I;
            if (i <= 1) {
                zM983iILilI = iIilII1.this.m984iiIIi11(i == 1);
            } else {
                zM983iILilI = iIilII1.this.m983iILilI();
            }
            Bundle bundle = new Bundle();
            bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{80, 95, 1}, I1I.IL1Iii.IL1Iii(new byte[]{3, 86, 3, 5, 9, 0}, "0df210")), this.f1009IL);
            if (zM983iILilI) {
                bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{23, 87, 71}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 86, 87, 9, 86}, "6bef0c")), 1);
            } else {
                bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{70, 3, 69}, I1I.IL1Iii.IL1Iii(new byte[]{6, 3, 8, 4, 89, 3}, "2e9681")), 0);
            }
            try {
                iIilII1.this.f3192Ilil.m873l(this.f1009IL, j, bundle);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class iILLL1 implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ BinderContainer f3216IL1Iii;

        public iILLL1(BinderContainer binderContainer) {
            this.f3216IL1Iii = binderContainer;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f3216IL1Iii.binder.unlinkToDeath(this, 0);
            iIilII1.this.f995iILLL1 = null;
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$lIi丨I, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class lIiI implements L1l.IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Context f3218IL1Iii;

        public lIiI(Context context) {
            this.f3218IL1Iii = context;
        }

        @Override // I1I.I1I.ILil.L1l.IL1Iii
        public void IL1Iii() {
            iIilII1.this.m977LlIl(this.f3218IL1Iii);
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$lI丨lii, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class lIlii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ String f3220I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f3221ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ int f1010IL;

        public lIlii(int i, String str, int i2) {
            this.f3221ILil = i;
            this.f3220I1I = str;
            this.f1010IL = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f3221ILil;
            if (i == 43) {
                iIilII1.this.I1IILIIL(i, this.f3220I1I, this.f1010IL, true);
            } else {
                iIilII1.this.I1IILIIL(i, this.f3220I1I, this.f1010IL, false);
            }
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$ll丨L1ii, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class llL1ii implements Callable<String> {
        public llL1ii(iIilII1 iiilii1) {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            return I1I.IL1Iii.IL1Iii(new byte[]{88, 82}, I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 10, 93, 8, 4}, "278e04"));
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class lLi1LL implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ BinderContainer f3223IL1Iii;

        public lLi1LL(BinderContainer binderContainer) {
            this.f3223IL1Iii = binderContainer;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f3223IL1Iii.binder.unlinkToDeath(this, 0);
            iIilII1.this.f1000lLi1LL = null;
        }
    }

    /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$丨il, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScriptEngine.java */
    public class RunnableC0602il implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ C1 f3225I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Context f3226ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ String f1011IL;

        /* JADX INFO: renamed from: I1I.I1I.ILil.iIilII1$丨il$IL1Iii */
        /* JADX INFO: compiled from: ScriptEngine.java */
        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0602il runnableC0602il = RunnableC0602il.this;
                iIilII1.this.m986ill(runnableC0602il.f3226ILil, runnableC0602il.f3225I1I, runnableC0602il.f1011IL);
            }
        }

        public RunnableC0602il(Context context, C1 c1, String str) {
            this.f3226ILil = context;
            this.f3225I1I = c1;
            this.f1011IL = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!I1I.I1I.I1I.I1I.Ilil(this.f3226ILil).I1I(false)) {
                I1I.I1I.p008IL.lIlii.m1148iIL(false, 2);
                I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-121, -91, -106, -46, -77, -53, -121, -67, -92, -46, -98, -24, -121, -71, -81, -46, -99, -46, -118, -127, -100}, I1I.IL1Iii.IL1Iii(new byte[]{80, 83, 12, 6, 12, 7}, "2f515d")));
                return;
            }
            if (I1I.I1I.p008IL.lIlii.Lli(this.f3226ILil) && (this.f3225I1I instanceof lliiI1)) {
                I1I.I1I.p008IL.lIlii.m1148iIL(true, 0);
                if (iIilII1.this.m991li11(this.f3226ILil, this.f1011IL)) {
                    Native.chmod(this.f1011IL);
                    if (TextUtils.isEmpty(this.f3225I1I.Ilil(3, 0, 0, this.f1011IL))) {
                        I1I.I1I.p008IL.lIlii.m1148iIL(false, 4);
                        I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-46, -88, -98, -127, -17, -50, -46, -80, -84, -127, -62, -19, -46, -76, -89, -127, -63, -41, -33, -116, -108, 85}, I1I.IL1Iii.IL1Iii(new byte[]{14, 11, 4, 2, 85, 82}, "935f04")));
                        return;
                    }
                    return;
                }
                return;
            }
            C1 c1 = this.f3225I1I;
            if ((c1 instanceof lliiI1) && TextUtils.isEmpty(c1.Ilil(13, 0, 0, BuildConfig.FLAVOR))) {
                I1I.I1I.p008IL.lIlii.m1148iIL(false, 5);
                I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-35, -95, -104, -128, -69, -112, -35, -71, -86, -128, -106, -77, -35, -67, -95, -128, -107, -119, -48, -123, -110, 87}, I1I.IL1Iii.IL1Iii(new byte[]{93, 85, 83, 3, 8, 91}, "eddf9c")));
                return;
            }
            if (iIilII1.this.f1003l == null) {
                iIilII1.this.f1003l = new Handler(this.f3226ILil.getMainLooper());
            }
            if (iIilII1.this.f1003l != null) {
                iIilII1.this.f1003l.post(new IL1Iii());
            }
        }
    }

    public static iIilII1 LLL() {
        return LL1IL;
    }

    /* JADX INFO: renamed from: I1 */
    public final void m5I1(String str) throws Throwable {
        Throwable th;
        StringBuilder sb;
        String strIL1Iii;
        IOException iOException;
        PrintStream printStream;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (this.f999llL1ii != null) {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(this.f999llL1ii, true));
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.newLine();
                        bufferedWriter = bufferedWriter2;
                    } catch (Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        System.err.println(I1I.IL1Iii.IL1Iii(new byte[]{119, 19, 22, 94, 23, 22, 69, 19, 13, 69, 12, 88, 85, 65, 16, 94, 69, 90, 93, 6, 68, 87, 12, 90, 87, 91, 68}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 83, 82, 83, 14}, "1a7c68")) + e.getMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                                return;
                            } catch (IOException e2) {
                                iOException = e2;
                                printStream = System.err;
                                sb = new StringBuilder();
                                strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{38, 64, 23, 11, 67, 20, 0, 94, 10, 23, 88, 90, 4, 18, 9, 11, 86, 20, 5, 91, 9, 1, 11, 20}, I1I.IL1Iii.IL1Iii(new byte[]{87, 4, 81, 0, 84, 81}, "464dee"));
                                sb.append(strIL1Iii);
                                sb.append(iOException.getMessage());
                                printStream.println(sb.toString());
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter == null) {
                            throw th;
                        }
                        try {
                            bufferedWriter.close();
                            throw th;
                        } catch (IOException e3) {
                            System.err.println(I1I.IL1Iii.IL1Iii(new byte[]{124, 68, 20, 12, 64, 66, 90, 90, 9, 16, 91, 12, 94, 22, 10, 12, 85, 66, 95, 95, 10, 6, 8, 66}, I1I.IL1Iii.IL1Iii(new byte[]{13, 5, 2, 86, 3, 85}, "43d517")) + e3.getMessage());
                            throw th;
                        }
                    }
                }
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e4) {
                        iOException = e4;
                        printStream = System.err;
                        sb = new StringBuilder();
                        strIL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{38, 16, 22, 94, 66, 66, 0, 14, 11, 66, 89, 12, 4, 66, 8, 94, 87, 66, 5, 11, 8, 84, 10, 66}, I1I.IL1Iii.IL1Iii(new byte[]{87, 86, 83, 84, 8, 3}, "447e8a"));
                        sb.append(strIL1Iii);
                        sb.append(iOException.getMessage());
                        printStream.println(sb.toString());
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean I1IILIIL(int i, String str, int i2, boolean z) {
        long j;
        String string;
        try {
            JSONObject jSONObject = new JSONObject(str);
            j = jSONObject.getLong(I1I.IL1Iii.IL1Iii(new byte[]{64, 80, 16, 14, 123, 80}, I1I.IL1Iii.IL1Iii(new byte[]{1, 3, 90, 7, 7, 82}, "529b5f")));
            try {
                string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{80, 71, 5}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 85, 93, 80, 12}, "3679f9")));
            } catch (Exception unused) {
                string = BuildConfig.FLAVOR;
            }
        } catch (Exception unused2) {
            j = 0;
        }
        if (i == 43) {
            if (i2 == 0) {
                this.I11L = true;
            } else {
                this.I11L = false;
            }
        }
        boolean zL1Lll = l1Lll(new ILil(this, i, string, i2), z);
        Bundle bundle = new Bundle();
        bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{80, 11, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 5, 15, 0, 84, 93}, "2c840d")), i);
        if (zL1Lll) {
            bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{22, 3, 69}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 7, 3, 0, 6}, "636040")), 1);
        } else {
            bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{70, 81, 16}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 83, 83, 14, 83}, "fa719b")), 0);
        }
        try {
            this.f3192Ilil.m873l(i, j, bundle);
            return true;
        } catch (Exception unused3) {
            return false;
        }
    }

    /* JADX INFO: renamed from: I1L丨11L, reason: contains not printable characters */
    public boolean m970I1L11L() {
        return this.f991IiL != null;
    }

    /* JADX INFO: renamed from: IIi丨丨I, reason: contains not printable characters */
    public final String m971IIiI(String str, int i) {
        try {
            C1 c1 = this.llliI;
            if (c1 == null || !(c1 instanceof lliiI1)) {
                return null;
            }
            return c1.Ilil(11, 7, i, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.lIiI.I1I
    public byte[] IL1Iii(int i) {
        if (i == 1) {
            String strILL = this.f993L11I.ILL();
            if (strILL != null) {
                return strILL.getBytes();
            }
            return null;
        }
        if (i == 2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                C0004 c0004ILL = ILLIi.m876lLi1LL().ILL();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(c0004ILL);
                objectOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override // I1I.I1I.ILil.C1
    public void ILL(Context context, LlLLL llLLL) {
    }

    /* JADX INFO: renamed from: ILL丨Ii, reason: contains not printable characters */
    public void m972ILLIi(Context context) {
        this.f994LlLLL = context;
        this.f993L11I = L1iI1.m900lIiI();
        this.ILL = i11i.ILL();
        this.f993L11I.m901ILl(context, new lIiI(context));
        this.f989ILl = new I1I.I1I.ILil.ILil(context);
        this.f992Ll1 = new I1I.I1I.ILil.lIiI(this);
        try {
            File file = new File(context.getFilesDir(), I1I.IL1Iii.IL1Iii(new byte[]{90, 85, 7, 86, 87, 22, 91, 89, 20, 84, 86}, I1I.IL1Iii.IL1Iii(new byte[]{4, 15, 0, 2, 86, 6}, "77f3dc")));
            Point pointM1123IIi = I1I.I1I.p008IL.lIlii.m1123IIi(context);
            SharedMem sharedMem = new SharedMem(file.getAbsolutePath(), pointM1123IIi.x * pointM1123IIi.y * 5);
            this.LlLI1 = sharedMem;
            sharedMem.m3486IL();
        } catch (Exception unused) {
        }
        com.p000nx.uiauto.accessibility.AccessibilityService.IL1Iii(0, new C0601ILl());
        com.p000nx.uiauto.accessibility.AccessibilityService.m3502IiL(new Lil());
        m7LL(context);
        this.f996lIiI = new I1I.I1I.ILil.IL1Iii(this.f993L11I.m902Ll1());
    }

    @Override // I1I.I1I.ILil.C1
    public String Ilil(int i, int i2, int i3, String str) {
        try {
            I1I.I1I.ILil.ILL ill = this.f3192Ilil;
            if (ill != null) {
                return ill.I11L(i, i2, i3, str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: I丨 */
    public void m6I() {
        try {
            if (this.llliI != null) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{45, 108}, I1I.IL1Iii.IL1Iii(new byte[]{85, 80, 82, 12, 2, 87}, "6dd5db")), I1I.IL1Iii.IL1Iii(new byte[]{88, 88, 23, 65, 11, 20, 69, 4, 17, 65, 11, 9, 4, 17, 11, 71, 89, 89}, I1I.IL1Iii.IL1Iii(new byte[]{93, 0, 0, 7, 81, 84}, "8ed250")));
                this.llliI.Ilil(22, 0, 0, BuildConfig.FLAVOR);
            }
        } catch (Exception unused) {
        }
        try {
            INXCoreNative iNXCoreNative = this.f1000lLi1LL;
            if (iNXCoreNative != null && iNXCoreNative.asBinder() != null && this.f1000lLi1LL.asBinder().isBinderAlive()) {
                this.f1000lLi1LL.sendCmd(1, 0, 0, BuildConfig.FLAVOR);
            }
        } catch (Exception unused2) {
        }
        try {
            I1I.I1I.ILil.ILL ill = this.f3192Ilil;
            if (ill != null) {
                ill.iIlLiL(4);
            }
        } catch (Exception unused3) {
        }
        try {
            C1 c1 = this.llliI;
            if (c1 != null && (c1 instanceof lliiI1)) {
                c1.Ilil(4, 0, 0, BuildConfig.FLAVOR);
            }
        } catch (Exception unused4) {
        }
        m994iILLl();
    }

    /* JADX INFO: renamed from: I丨Ii, reason: contains not printable characters */
    public final void m973IIi(INXCoreNative iNXCoreNative) {
        if (iNXCoreNative != null) {
            try {
                if (iNXCoreNative.asBinder().isBinderAlive()) {
                    iNXCoreNative.sendCmd(1, 0, 0, BuildConfig.FLAVOR);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // I1I.I1I.ILil.C1
    /* JADX INFO: renamed from: I丨L */
    public void mo848IL(Context context, Bundle bundle) {
        synchronized (this.f990IL) {
            this.f3192Ilil = new I1I.I1I.ILil.ILL(this, bundle, new IiL());
            m976LIll();
            Liil1L1l(context);
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public String m974L11(int i) {
        lliiI1 lliii1 = (lliiI1) I1I.I1I.ILil.LlLI1.m925IL().Ilil();
        if (!I1I.I1I.p008IL.lIlii.m1130LIIlL(this.f994LlLLL) || lliii1 == null || !lliii1.m1038lIlii()) {
            L1iI1 l1iI1 = this.f993L11I;
            if (l1iI1 == null) {
                return null;
            }
            this.Lil = true;
            try {
                l1iI1.setMode(i);
                return this.f993L11I.ILL();
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            INXCoreNative iNXCoreNative = this.f995iILLL1;
            if (iNXCoreNative != null && iNXCoreNative.asBinder() != null && this.f995iILLL1.asBinder().isBinderAlive()) {
                if (iIilII1()) {
                    this.f1001il.setMode(i);
                    return I1I.I1I.p008IL.lIlii.m1167iLl(this.f1001il.obtainXml());
                }
                InterfaceC0606LLlI1 interfaceC0606LLlI1ObtainUiSelectorProxy = this.f995iILLL1.obtainUiSelectorProxy(1);
                this.f1001il = interfaceC0606LLlI1ObtainUiSelectorProxy;
                interfaceC0606LLlI1ObtainUiSelectorProxy.setMode(i);
                return I1I.I1I.p008IL.lIlii.m1167iLl(this.f1001il.obtainXml());
            }
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{119, 97}, I1I.IL1Iii.IL1Iii(new byte[]{0, 91, 14, 84, 82, 10}, "9b91f8")), I1I.IL1Iii.IL1Iii(new byte[]{95, 89, 64, 16, 89, 23, 22, 68, 82, 17, 76, 10, 15, 5, 71, 11, 74, 88, 95}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 2, 87, 9, 85}, "5e1310")));
            lliii1.Ilil(21, 0, 0, BuildConfig.FLAVOR);
            for (int i2 = 0; i2 < 10; i2++) {
                INXCoreNative iNXCoreNative2 = this.f995iILLL1;
                if (iNXCoreNative2 != null && iNXCoreNative2.asBinder() != null && this.f995iILLL1.asBinder().isBinderAlive()) {
                    break;
                }
                Thread.sleep(1000L);
            }
            if (iIilII1()) {
                this.f1001il.setMode(i);
                return I1I.I1I.p008IL.lIlii.m1167iLl(this.f1001il.obtainXml());
            }
            InterfaceC0606LLlI1 interfaceC0606LLlI1ObtainUiSelectorProxy2 = this.f995iILLL1.obtainUiSelectorProxy(1);
            this.f1001il = interfaceC0606LLlI1ObtainUiSelectorProxy2;
            interfaceC0606LLlI1ObtainUiSelectorProxy2.setMode(i);
            return I1I.I1I.p008IL.lIlii.m1167iLl(this.f1001il.obtainXml());
        } catch (Exception unused2) {
            return BuildConfig.FLAVOR;
        }
    }

    public boolean L1iI1() {
        String strIIlLiL;
        try {
            return this.f3192Ilil.m870lLi1LL() && (strIIlLiL = this.f3192Ilil.iIlLiL(25)) != null && strIIlLiL.equals(I1I.IL1Iii.IL1Iii(new byte[]{84}, I1I.IL1Iii.IL1Iii(new byte[]{83, 90, 3, 80, 90, 0}, "6bb48b")));
        } catch (Exception unused) {
        }
    }

    public boolean LI11() {
        String strIIlLiL;
        try {
            return this.f3192Ilil.m870lLi1LL() && (strIIlLiL = this.f3192Ilil.iIlLiL(16)) != null && strIIlLiL.equals(I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 2, 90, 1, 81}, "b22b4f")));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: LI丨l, reason: contains not printable characters */
    public byte[] m975LIl(int i, int i2) throws Throwable {
        Bitmap bitmapM985ili11 = m985ili11(i, i2);
        if (bitmapM985ili11 != null) {
            return I1I.I1I.p008IL.lIlii.m1201Lii(bitmapM985ili11, i, i2);
        }
        return null;
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m976LIll() {
        this.f1002lL = true;
    }

    /* JADX INFO: renamed from: LL */
    public void m7LL(Context context) {
        if (this.f1002lL) {
            I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-121, -6, -24, -121, -69, -105, -124, -18, -8, -121, -106, -67, -124, -22, -13}, I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 4, 83, 80, 80}, "c1a1af")));
        } else {
            I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-113, -76, -17, -123, -92, -128, -128, -112, -30, -123, -121, -69, -128, -81, -17, -122, -72, -111, -128, -85, -51, -122, -94, -106, -114, -116, -14, -117, -109, -68}, I1I.IL1Iii.IL1Iii(new byte[]{4, 0, 82, 90, 87, 1}, "b309e1")));
        }
        if (this.llliI == null) {
            this.llliI = I1I.I1I.ILil.LlLI1.m925IL().I1I(context);
        }
        C1 c1 = this.llliI;
        if (c1 != null) {
            if (!(c1 instanceof lliiI1)) {
                if (c1 instanceof I1I.I1I.ILil.IL) {
                    this.f1002lL = false;
                    ((I1I.I1I.ILil.IL) c1).LlLI1();
                    return;
                }
                return;
            }
            this.f1002lL = false;
            I1I.I1I.p008IL.IiL.I1I(I1I.IL1Iii.IL1Iii(new byte[]{119, 57}, I1I.IL1Iii.IL1Iii(new byte[]{14, 87, 84, 95, 86, 80}, "76a9ba")), I1I.IL1Iii.IL1Iii(new byte[]{65, 0, 90, 13, 91, 17, 18, 68, 18}, I1I.IL1Iii.IL1Iii(new byte[]{87, 84, 3, 2, 2, 81}, "d10a04")));
            lliiI1 lliii1 = (lliiI1) this.llliI;
            if (lliii1.m1038lIlii()) {
                return;
            }
            lliii1.ILL(context, new Ll1(this));
        }
    }

    public synchronized void LiL1(Bundle bundle) {
        IBinder iBinder;
        try {
            bundle.setClassLoader(BinderContainer.class.getClassLoader());
            BinderContainer binderContainer = (BinderContainer) bundle.getParcelable(I1I.I1I.ILil.Ll1.f3169IL1Iii);
            if (binderContainer != null && (iBinder = binderContainer.binder) != null && iBinder.pingBinder()) {
                INXCoreNative iNXCoreNative = this.f995iILLL1;
                this.f995iILLL1 = INXCoreNative.Stub.asInterface(binderContainer.binder);
                if (iNXCoreNative != null) {
                    m973IIi(iNXCoreNative);
                }
                INXCoreNative iNXCoreNative2 = this.f995iILLL1;
                if (iNXCoreNative2 != null) {
                    try {
                        if (iNXCoreNative2.asBinder().isBinderAlive()) {
                            this.f995iILLL1.sendCmd(21, 0, 0, BuildConfig.FLAVOR);
                            Point pointILI1Ll = I1I.I1I.p008IL.lIlii.ILI1Ll();
                            if (pointILI1Ll != null) {
                                this.f995iILLL1.sendCmd(24, pointILI1Ll.x, pointILI1Ll.y, BuildConfig.FLAVOR);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                binderContainer.binder.linkToDeath(new iILLL1(binderContainer), 0);
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 57}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 1, 10, 82, 85}, "3f1334")), I1I.IL1Iii.IL1Iii(new byte[]{83, 93, 87, 23, 71, 67, 69, 81, 77, 68, 86, 67, 66, 15, 7}, I1I.IL1Iii.IL1Iii(new byte[]{0, 11, 14, 85, 5, 1}, "097160")) + e.toString());
        }
    }

    public final void Liil1L1l(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainService.class);
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 64, 11, 90, 90}, I1I.IL1Iii.IL1Iii(new byte[]{12, 92, 85, 81, 83, 87}, "88a3fc")), I1I.IL1Iii.IL1Iii(new byte[]{18, 6, 75, 90, 65, 16}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 92, 82, 82, 0}, "67eacd")));
        context.startService(intent);
    }

    /* JADX INFO: renamed from: LlIl丨, reason: contains not printable characters */
    public final void m977LlIl(Context context) {
        C1 c1Ilil;
        if (this.Lil) {
            this.Lil = false;
            if (I1I.I1I.p008IL.lIlii.Ilil() || (c1Ilil = I1I.I1I.ILil.LlLI1.m925IL().Ilil()) == null || !(c1Ilil instanceof lliiI1)) {
                return;
            }
            try {
                ((lliiI1) c1Ilil).Ilil(11, 19, 1, context.getPackageName() + I1I.IL1Iii.IL1Iii(new byte[]{74}, I1I.IL1Iii.IL1Iii(new byte[]{0, 7, 93, 84, 0, 85}, "efd2d0")) + com.p000nx.uiauto.accessibility.AccessibilityService.class.getName());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: LlLiL丨L丨, reason: contains not printable characters */
    public void m978LlLiLL() {
        Point pointILI1Ll;
        try {
            INXCoreNative iNXCoreNative = this.f995iILLL1;
            if (iNXCoreNative != null && iNXCoreNative.asBinder().isBinderAlive()) {
                this.f995iILLL1.sendCmd(21, 0, 0, BuildConfig.FLAVOR);
                Point pointILI1Ll2 = I1I.I1I.p008IL.lIlii.ILI1Ll();
                if (pointILI1Ll2 != null) {
                    this.f995iILLL1.sendCmd(24, pointILI1Ll2.x, pointILI1Ll2.y, BuildConfig.FLAVOR);
                }
            }
        } catch (Exception unused) {
        }
        try {
            if (this.f3192Ilil == null || (pointILI1Ll = I1I.I1I.p008IL.lIlii.ILI1Ll()) == null) {
                return;
            }
            this.f3192Ilil.I11L(24, pointILI1Ll.x, pointILI1Ll.y, BuildConfig.FLAVOR);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: renamed from: L丨1l, reason: contains not printable characters */
    public boolean m979L1l() {
        String strIIlLiL;
        try {
            return this.f3192Ilil.m870lLi1LL() && (strIIlLiL = this.f3192Ilil.iIlLiL(17)) != null && strIIlLiL.equals(I1I.IL1Iii.IL1Iii(new byte[]{82}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 6, 9, 12, 8}, "74d050")));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: i1 */
    public boolean m8i1() {
        try {
            I1I.I1I.ILil.ILL ill = this.f3192Ilil;
            return ill != null && ill.iIlLiL(5).compareTo(I1I.IL1Iii.IL1Iii(new byte[]{17, 16, 17, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 85, 15, 81, 93}, "d71959"))) == 0;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: iI */
    public String m9iI(int i) {
        if (m988l1IIi1(true)) {
            return m974L11(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: iI1i丨I, reason: contains not printable characters */
    public final boolean m980iI1iI(String str, String str2) {
        try {
            return this.f994LlLLL.getPackageManager().getActivityInfo(new ComponentName(str, str2), 0) != null;
        } catch (Exception unused) {
        }
    }

    public final boolean iIilII1() {
        try {
            InterfaceC0606LLlI1 interfaceC0606LLlI1 = this.f1001il;
            return (interfaceC0606LLlI1 == null || interfaceC0606LLlI1.asBinder() == null || !this.f1001il.asBinder().isBinderAlive()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: iIl1il丨, reason: contains not printable characters */
    public final void m981iIl1il() {
        InterfaceC0604lIII interfaceC0604lIII;
        INXCoreNative iNXCoreNative = this.f1000lLi1LL;
        if (iNXCoreNative == null || (interfaceC0604lIII = this.f10041) == null) {
            return;
        }
        try {
            interfaceC0604lIII.ILil(iNXCoreNative);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: iI丨1LI, reason: contains not printable characters */
    public void m982iI1LI() {
        try {
            I1I.I1I.ILil.ILL ill = this.f3192Ilil;
            if (ill != null) {
                ill.llliI(4, 0, 0, BuildConfig.FLAVOR);
                return;
            }
        } catch (Exception unused) {
        }
        try {
            InterfaceC0604lIII interfaceC0604lIII = this.f10041;
            if (interfaceC0604lIII != null) {
                interfaceC0604lIII.mo1027il(12);
            }
        } catch (Exception unused2) {
        }
        try {
            C1 c1 = this.llliI;
            if (c1 != null) {
                c1.Ilil(4, 0, 0, BuildConfig.FLAVOR);
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: renamed from: iI丨Li丨lI, reason: contains not printable characters */
    public final boolean m983iILilI() {
        C1 c1ILil = I1I.I1I.ILil.LlLI1.m925IL().ILil();
        if (c1ILil == null || !(c1ILil instanceof I11li1)) {
            return false;
        }
        if (m970I1L11L()) {
            return true;
        }
        return ((I11li1) c1ILil).m847ILl(this.f994LlLLL, true);
    }

    /* JADX INFO: renamed from: iiIIi丨11, reason: contains not printable characters */
    public final boolean m984iiIIi11(boolean z) {
        C1 c1Ilil = I1I.I1I.ILil.LlLI1.m925IL().Ilil();
        if (c1Ilil == null || !(c1Ilil instanceof lliiI1) || !((lliiI1) c1Ilil).m1038lIlii()) {
            if (c1Ilil != null) {
                if (!I1I.I1I.p008IL.lIlii.Ilil() && z) {
                    return ((I11li1) I1I.I1I.ILil.LlLI1.m925IL().ILil()).m849lIiI(this.f994LlLLL, true);
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
        try {
            if (I1I.I1I.p008IL.lIlii.Ilil()) {
                ((lliiI1) c1Ilil).Ilil(11, 19, 0, this.f994LlLLL.getPackageName() + I1I.IL1Iii.IL1Iii(new byte[]{77}, I1I.IL1Iii.IL1Iii(new byte[]{90, 13, 84, 80, 81, 4}, "88f4a5")) + com.p000nx.uiauto.accessibility.AccessibilityService.class.getName());
                return true;
            }
            if (!z) {
                return true;
            }
            ((lliiI1) c1Ilil).Ilil(11, 19, 1, this.f994LlLLL.getPackageName() + I1I.IL1Iii.IL1Iii(new byte[]{28}, I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 3, 86, 12, 14}, "c7b287")) + com.p000nx.uiauto.accessibility.AccessibilityService.class.getName());
            for (int i = 0; i < 10; i++) {
                if (I1I.I1I.p008IL.lIlii.Ilil()) {
                    return true;
                }
                Thread.sleep(500L);
            }
            return false;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0139 A[EXC_TOP_SPLITTER, PHI: r3 r4
  0x0139: PHI (r3v9 com.main.engine.SharedMem) = (r3v8 com.main.engine.SharedMem), (r3v12 com.main.engine.SharedMem) binds: [B:30:0x0171, B:21:0x0137] A[DONT_GENERATE, DONT_INLINE]
  0x0139: PHI (r4v3 android.graphics.Bitmap) = (r4v2 android.graphics.Bitmap), (r4v6 android.graphics.Bitmap) binds: [B:30:0x0171, B:21:0x0137] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: ili丨11, reason: contains not printable characters */
    public Bitmap m985ili11(int i, int i2) throws Throwable {
        Bitmap bitmap;
        C0004 c0004ILL;
        SharedMem sharedMem;
        Bitmap bitmapCreateBitmap;
        Bundle bundleObtainData;
        SharedMem sharedMem2 = null;
        if (!m988l1IIi1(false)) {
            return null;
        }
        C1 c1Ilil = I1I.I1I.ILil.LlLI1.m925IL().Ilil();
        if (c1Ilil != null) {
            try {
                try {
                    INXCoreNative iNXCoreNativeObtainScriptProxy = ((INXCoreNative) c1Ilil).obtainScriptProxy(1);
                    if (iNXCoreNativeObtainScriptProxy == null || (bundleObtainData = iNXCoreNativeObtainScriptProxy.obtainData(1)) == null) {
                        sharedMem = null;
                        bitmapCreateBitmap = null;
                    } else {
                        bundleObtainData.setClassLoader(SharedMem.class.getClassLoader());
                        sharedMem = (SharedMem) bundleObtainData.get(I1I.IL1Iii.IL1Iii(new byte[]{81, 15, 80, 94, 6}, I1I.IL1Iii.IL1Iii(new byte[]{94, 81, 8, 8, 86, 87}, "f39152")));
                        try {
                            int i3 = bundleObtainData.getInt(I1I.IL1Iii.IL1Iii(new byte[]{22, 92, 87, 77, 94}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 6, 92, 5, 2}, "fc5e36")));
                            bitmapCreateBitmap = Bitmap.createBitmap(i3 + ((bundleObtainData.getInt(I1I.IL1Iii.IL1Iii(new byte[]{23, 86, 78, 64, 76, 64, 12, 93, 92}, I1I.IL1Iii.IL1Iii(new byte[]{87, 9, 91, 11, 94, 6}, "20b8f4"))) - (i3 * 4)) / 4), bundleObtainData.getInt(I1I.IL1Iii.IL1Iii(new byte[]{89, 0, 80, 85, 89, 69}, I1I.IL1Iii.IL1Iii(new byte[]{84, 86, 14, 83, 9, 9}, "e37a88"))), Bitmap.Config.ARGB_8888);
                            try {
                                sharedMem.m3486IL();
                                ByteBuffer byteBufferI1I = sharedMem.I1I();
                                bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferI1I);
                                byteBufferI1I.flip();
                            } catch (Exception e) {
                                e = e;
                                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 106}, I1I.IL1Iii.IL1Iii(new byte[]{82, 3, 4, 9, 5, 84}, "f12952")), e.toString());
                                if (sharedMem != null) {
                                    try {
                                        sharedMem.IL1Iii();
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bitmapCreateBitmap = null;
                            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{122, 106}, I1I.IL1Iii.IL1Iii(new byte[]{82, 3, 4, 9, 5, 84}, "f12952")), e.toString());
                            if (sharedMem != null) {
                                sharedMem.IL1Iii();
                            }
                            bitmap = bitmapCreateBitmap;
                            return bitmap != null ? bitmap : bitmap;
                        }
                    }
                    if (sharedMem != null) {
                        sharedMem.IL1Iii();
                    }
                } catch (Exception e3) {
                    e = e3;
                    sharedMem = null;
                } catch (Throwable th) {
                    th = th;
                    sharedMem2 = null;
                    if (sharedMem2 != null) {
                        try {
                            sharedMem2.IL1Iii();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
                bitmap = bitmapCreateBitmap;
            } catch (Throwable th2) {
                th = th2;
                if (sharedMem2 != null) {
                    sharedMem2.IL1Iii();
                }
                throw th;
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null && (c0004ILL = ILLIi.m876lLi1LL().ILL()) != null) {
            return c0004ILL.toBitmap();
        }
    }

    public void ill1LI1l(Intent intent) {
        this.f991IiL = intent;
        try {
            ILLIi.m876lLi1LL().m883llL1ii(intent);
            InterfaceC0604lIII interfaceC0604lIII = this.f10041;
            if (interfaceC0604lIII == null || interfaceC0604lIII.asBinder() == null || !this.f10041.asBinder().isBinderAlive()) {
                return;
            }
            this.f10041.mo1025IiL(this.f991IiL);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m986ill(Context context, C1 c1, String str) {
        this.f997lIII = new ILL(c1, str, context);
        context.bindService(new Intent(context, (Class<?>) NativeService.class), this.f997lIII, 3);
    }

    /* JADX INFO: renamed from: i丨1I1I1l, reason: contains not printable characters */
    public void m987i1I1I1l(Context context, String str) {
        this.Lil = true;
        C1 c1I1I = I1I.I1I.ILil.LlLI1.m925IL().I1I(context);
        if (c1I1I != null) {
            this.f999llL1ii = I1I.I1I.p008IL.lIlii.m1195l(context);
            c1I1I.Ilil(6, 0, 0, BuildConfig.FLAVOR);
            this.llliI = c1I1I;
            c1I1I.ILL(context, new L11I(context, c1I1I, str));
        }
    }

    /* JADX INFO: renamed from: l1IIi1丨, reason: contains not printable characters */
    public boolean m988l1IIi1(boolean z) {
        lliiI1 lliii1 = (lliiI1) I1I.I1I.ILil.LlLI1.m925IL().Ilil();
        if (lliii1 != null && lliii1.m1038lIlii()) {
            return true;
        }
        I1I.I1I.ILil.IL il = (I1I.I1I.ILil.IL) I1I.I1I.ILil.LlLI1.m925IL().IL1Iii();
        if (il != null && il.LlLI1() && this.f991IiL != null) {
            return true;
        }
        if (I1I.I1I.p008IL.lIlii.m1160ili11(this.f994LlLLL) != I1I.I1I.ILil.LlLI1.IL1Iii.HANDLE) {
            I1I.I1I.p008IL.lIlii.LIlIlIL(new IL());
            return false;
        }
        I11li1 i11li1 = (I11li1) I1I.I1I.ILil.LlLI1.m925IL().ILil();
        if (z) {
            if (z) {
                if (I1I.I1I.p008IL.lIlii.Ilil()) {
                    return true;
                }
                i11li1.m849lIiI(this.f994LlLLL, false);
            }
        } else {
            if (this.f991IiL != null) {
                return true;
            }
            i11li1.m847ILl(this.f994LlLLL, false);
        }
        return false;
    }

    public final boolean l1Lll(I1I.I1I.IL1Iii.IL1Iii iL1Iii, boolean z) {
        String str;
        String strM1114IIiI = I1I.I1I.p008IL.lIlii.m1114IIiI(I1I.I1I.p008IL.lIlii.LL1IL());
        String strM1169lIIiIlL = I1I.I1I.p008IL.lIlii.m1169lIIiIlL(I1I.I1I.p008IL.lIlii.LL1IL());
        ImeInput imeInputI1I = ImeInput.I1I();
        boolean zIL1Iii = true;
        if ((imeInputI1I == null || !imeInputI1I.Ilil() || (!this.I11L && !TextUtils.isEmpty(strM1169lIIiIlL))) && (!z || this.I11L)) {
            try {
                byte b = 7;
                String string = Settings.Secure.getString(this.f994LlLLL.getContentResolver(), I1I.IL1Iii.IL1Iii(new byte[]{92, 88, 7, 82, 14, 92, 93, 105, 15, 94, 18, 76, 77, 105, 11, 85, 22, 81, 86, 82, 21}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 95, 9, 0, 8}, "9699b1")));
                if (string != null) {
                    String[] strArrSplit = string.split(I1I.IL1Iii.IL1Iii(new byte[]{91}, I1I.IL1Iii.IL1Iii(new byte[]{86, 81, 89, 5, 5, 6}, "728246")));
                    String strSubstring = BuildConfig.FLAVOR;
                    int length = strArrSplit.length;
                    int i = 0;
                    while (i < length) {
                        String str2 = strArrSplit[i];
                        if (str2.compareTo(strM1169lIIiIlL) != 0) {
                            strSubstring = (strSubstring + str2) + I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{9, 6, b, 87, 84, 1}, "17dc2b"));
                        }
                        i++;
                        b = 7;
                    }
                    if (strSubstring.endsWith(I1I.IL1Iii.IL1Iii(new byte[]{92}, I1I.IL1Iii.IL1Iii(new byte[]{84, 10, 6, 91, 4, 83}, "2968fb")))) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                    }
                    str = strM1169lIIiIlL + I1I.IL1Iii.IL1Iii(new byte[]{92}, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 0, 15, 8, 6}, "09c987")) + strSubstring;
                } else {
                    str = strM1169lIIiIlL;
                }
                m971IIiI(I1I.IL1Iii.IL1Iii(new byte[]{22, 82, 65, 69, 95, 92, 2, 68, 21, 65, 67, 70, 69, 68, 80, 82, 67, 64, 0, 23, 80, 95, 87, 80, 9, 82, 81, 110, 95, 92, 21, 66, 65, 110, 91, 87, 17, 95, 90, 85, 69, 18}, I1I.IL1Iii.IL1Iii(new byte[]{93, 84, 7, 83, 2, 84}, "8c2b4f")) + str, 1);
                m971IIiI(I1I.IL1Iii.IL1Iii(new byte[]{68, 86, 64, 70, 81, 86, 80, 64, 20, 66, 77, 76, 23, 64, 81, 81, 77, 74, 82, 19, 80, 87, 94, 89, 66, 95, 64, 109, 81, 86, 71, 70, 64, 109, 85, 93, 67, 91, 91, 86, 24}, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 85, 3, 92, 8}, "daa1d0")) + strM1169lIIiIlL, 0);
            } catch (Exception unused) {
            }
        }
        I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{10, 4, 0, 15, 0, 86}, "9497f2"));
        C1 c1 = this.llliI;
        if (c1 == null || !(c1 instanceof lliiI1)) {
            ImeInput imeInputI1I2 = ImeInput.I1I();
            if (imeInputI1I2 != null) {
                return iL1Iii.IL1Iii(imeInputI1I2, true);
            }
            return false;
        }
        if (!z) {
            int i2 = 0;
            while (true) {
                if (i2 < 20) {
                    ImeInput imeInputI1I3 = ImeInput.I1I();
                    if (imeInputI1I3 != null && imeInputI1I3.Ilil()) {
                        if (iL1Iii != null) {
                            zIL1Iii = iL1Iii.IL1Iii(imeInputI1I3, true);
                            break;
                        }
                    } else {
                        try {
                            Thread.sleep(50L);
                        } catch (Exception unused2) {
                        }
                        i2++;
                    }
                }
                zIL1Iii = false;
                break;
            }
        }
        if (!this.I11L && !TextUtils.isEmpty(strM1114IIiI)) {
            m971IIiI(I1I.IL1Iii.IL1Iii(new byte[]{16, 83, 21, 69, 10, 11, 4, 69, 65, 65, 22, 17, 67, 69, 4, 82, 22, 23, 6, 22, 5, 84, 5, 4, 22, 90, 21, 110, 10, 11, 19, 67, 21, 110, 14, 0, 23, 94, 14, 85, 67}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 87, 6, 5, 82}, "ff67f7")) + strM1114IIiI, 0);
        }
        return zIL1Iii;
    }

    /* JADX INFO: renamed from: lIIiIlL丨, reason: contains not printable characters */
    public void m989lIIiIlL(Bundle bundle) {
        IBinder iBinder;
        try {
            bundle.setClassLoader(BinderContainer.class.getClassLoader());
            BinderContainer binderContainer = (BinderContainer) bundle.getParcelable(I1I.I1I.ILil.Ll1.f3169IL1Iii);
            if (binderContainer == null || (iBinder = binderContainer.binder) == null || !iBinder.pingBinder()) {
                return;
            }
            this.f1000lLi1LL = INXCoreNative.Stub.asInterface(binderContainer.binder);
            binderContainer.binder.linkToDeath(new lLi1LL(binderContainer), 0);
            m981iIl1il();
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 61}, I1I.IL1Iii.IL1Iii(new byte[]{83, 81, 2, 2, 84, 1}, "f4d70d")), I1I.IL1Iii.IL1Iii(new byte[]{82, 94, 89, 23, 76, 75, 68, 82, 67, 68, 93, 75, 67, 12, 9}, I1I.IL1Iii.IL1Iii(new byte[]{5, 3, 14, 82, 94, 93}, "4296fd")) + e.toString());
        }
    }

    /* JADX INFO: renamed from: lL */
    public final void m10lL(int i, long j) {
        L1iI1 l1iI1 = this.f993L11I;
        try {
            this.f3192Ilil.m873l(45, j, l1iI1 != null ? l1iI1.obtainXml() : null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: l丨liiI1, reason: contains not printable characters */
    public final void m990lliiI1(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainService.class);
        intent.setFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{89, 83, 21, 89, 88, 94}, I1I.IL1Iii.IL1Iii(new byte[]{10, 81, 5, 86, 15, 6}, "2adf86")), I1I.IL1Iii.IL1Iii(new byte[]{0, 29, 93, 16}, I1I.IL1Iii.IL1Iii(new byte[]{3, 82, 2, 86, 84, 3}, "f762c7")));
        context.startService(intent);
    }

    /* JADX INFO: renamed from: l丨丨i11, reason: contains not printable characters */
    public synchronized boolean m991li11(Context context, String str) {
        long jILil = I1I.I1I.ILil.llL1ii.IL1Iii().ILil(context);
        if (jILil != 0 && jILil == this.iIlLiL) {
            return true;
        }
        File fileM1016IiL = l1IIi1.I1I().m1016IiL();
        try {
            if (fileM1016IiL.exists()) {
                I1I.I1I.p008IL.lIlii.m1142Ll1(fileM1016IiL);
            }
        } catch (Exception unused) {
        }
        if (!fileM1016IiL.exists()) {
            fileM1016IiL.mkdirs();
        }
        try {
            if (Native.unZip(str, fileM1016IiL.getAbsolutePath()) != 0) {
                throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{71, 10, 27, 94, 67, 21}, I1I.IL1Iii.IL1Iii(new byte[]{84, 6, 86, 15, 2, 1}, "fb7814")) + str + I1I.IL1Iii.IL1Iii(new byte[]{17, 5, 2, 89, 88, 3, 85}, I1I.IL1Iii.IL1Iii(new byte[]{8, 7, 5, 6, 86, 94}, "9df6b8")));
            }
            File file = new File(fileM1016IiL, new JSONObject(I1I.I1I.p008IL.lIlii.l11(new File(fileM1016IiL, I1I.IL1Iii.IL1Iii(new byte[]{0, 89, 16, 69, 31, 29, 15, 68, 11, 89}, I1I.IL1Iii.IL1Iii(new byte[]{92, 2, 7, 81, 87, 85}, "95cf1f"))))).getString(I1I.IL1Iii.IL1Iii(new byte[]{22, 6, 62, 85, 94, 64, 22, 28}, I1I.IL1Iii.IL1Iii(new byte[]{85, 4, 81, 3, 85, 12}, "1a03e8"))));
            if (Native.unZip(file.getAbsolutePath(), file.getParentFile().getAbsolutePath()) == 0) {
                this.iIlLiL = jILil;
                return true;
            }
            throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{67, 87, 24, 93, 18, 68, 68, 90, 66}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 80, 81, 81, 82}, "782e36")) + str + I1I.IL1Iii.IL1Iii(new byte[]{95, 83, 12, 85, 3, 1}, I1I.IL1Iii.IL1Iii(new byte[]{13, 11, 85, 95, 82, 1}, "490f4d")));
        } catch (Exception e) {
            e.printStackTrace();
            I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-121, -103, -67, -48, -105, -25, -118, -77, -82, -34, -88, -50, -121, -117, -74, -35, -116, -38, 88}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 5, 9, 85, 86}, "6211a4")) + e.toString());
            I1I.I1I.p008IL.lIlii.m1148iIL(false, 3);
            return false;
        }
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public llliI obtainAccessibityActionProxy() {
        return this.f989ILl;
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public IAccessibServiceProxy obtainAccessibityService() {
        return this.f996lIiI;
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public Bundle obtainData(int i) {
        C0004 c0004ILL;
        if (i != 1 || (c0004ILL = ILLIi.m876lLi1LL().ILL()) == null || this.LlLI1 == null) {
            return null;
        }
        int width = c0004ILL.getWidth();
        int height = c0004ILL.getHeight();
        int rowStride = c0004ILL.getRowStride();
        c0004ILL.copyPixelsToBuffer(this.LlLI1.I1I());
        Bundle bundle = new Bundle();
        bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{89, 88, 2, 1, 6}, I1I.IL1Iii.IL1Iii(new byte[]{2, 80, 83, 94, 80, 12}, "2e0834")), this.LlLI1);
        bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{22, 15, 82, 70, 11}, I1I.IL1Iii.IL1Iii(new byte[]{86, 5, 14, 81, 83, 83}, "7c8c0d")), width);
        bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{91, 81, 8, 6, 81, 68}, I1I.IL1Iii.IL1Iii(new byte[]{3, 87, 86, 7, 13, 7}, "0c7f47")), height);
        bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{69, 86, 21, 64, 23, 70, 94, 93, 7}, I1I.IL1Iii.IL1Iii(new byte[]{15, 91, 87, 86, 7, 4}, "8b5ed0")), rowStride);
        return bundle;
    }

    @Override // android.app.INXCoreNative
    public l obtainDataTask() {
        return this.f992Ll1;
    }

    @Override // android.app.INXCoreNative
    public INXCoreNative obtainScriptProxy(int i) throws RemoteException {
        if (i == 0) {
            return this.f1000lLi1LL;
        }
        if (this.llliI == null && this.f994LlLLL != null) {
            this.llliI = I1I.I1I.ILil.LlLI1.m925IL().I1I(this.f994LlLLL);
        }
        C1 c1 = this.llliI;
        if (c1 == null) {
            return null;
        }
        if (c1 instanceof lliiI1) {
            lliiI1 lliii1 = (lliiI1) c1;
            if (!lliii1.m1038lIlii()) {
                I1I.I1I.p008IL.lIlii.m1131LII1(I1I.IL1Iii.IL1Iii(new byte[]{-47, -65, -21, -33, -12, -42, -48, -121, -10, -47, -61, -22, -34, -92, -21, -36, -24, -57}, I1I.IL1Iii.IL1Iii(new byte[]{1, 8, 80, 1, 0, 94}, "9068b8")));
                lliii1.ILL(this.f994LlLLL, new I1I(this));
            }
        }
        return ((INXCoreNative) this.llliI).obtainScriptProxy(1);
    }

    @Override // android.app.INXCoreNative
    public L111 obtainUiObjectProxy(int i) throws RemoteException {
        if (i != 1) {
            return this.ILL;
        }
        try {
            INXCoreNative iNXCoreNative = this.f995iILLL1;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                return null;
            }
            return this.f995iILLL1.obtainUiObjectProxy(0);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.app.INXCoreNative
    public InterfaceC0606LLlI1 obtainUiSelectorProxy(int i) throws RemoteException {
        if (i != 1) {
            return this.f993L11I;
        }
        try {
            INXCoreNative iNXCoreNative = this.f995iILLL1;
            if (iNXCoreNative == null || !iNXCoreNative.asBinder().isBinderAlive()) {
                return null;
            }
            return this.f995iILLL1.obtainUiSelectorProxy(0);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.app.INXCoreNative
    public String sendCmd(int i, int i2, int i3, String str) throws RemoteException {
        boolean z;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        String string = BuildConfig.FLAVOR;
        if (i == 8) {
            p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(99, str, BuildConfig.FLAVOR));
            return I1I.IL1Iii.IL1Iii(new byte[]{84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 6, 5, 0, 2}, "a0cd04"));
        }
        if (i != 11) {
            if (i != 10) {
                if (i == 14) {
                    try {
                        return I1I.I1I.p008IL.lIlii.LL1IL().getApplicationInfo().nativeLibraryDir;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                if (i == 18) {
                    return Integer.toString(Process.myPid());
                }
                if (i == 2) {
                    return (String) new C0610il().ILil(new llL1ii(this));
                }
                if (i != 19) {
                    if (i == 20 && I1I.I1I.p008IL.lIlii.m1130LIIlL(this.f994LlLLL)) {
                        return I1I.IL1Iii.IL1Iii(new byte[]{14, 14}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 6, 85, 86, 95}, "ebc6ef"));
                    }
                    return null;
                }
                if (i2 == 37 || i2 == 40 || i2 == 41 || i2 == 43) {
                    new Thread(new lIlii(i2, str, i3)).start();
                    return I1I.IL1Iii.IL1Iii(new byte[]{13, 89}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 92, 1, 93, 83}, "1be791"));
                }
                if (i2 == 45) {
                    new Thread(new iIi1(str, i2)).start();
                    return I1I.IL1Iii.IL1Iii(new byte[]{90, 91}, I1I.IL1Iii.IL1Iii(new byte[]{2, 82, 13, 1, 13, 86}, "7b439e"));
                }
                if (i2 != 46) {
                    if (i2 != 47) {
                        return null;
                    }
                    new Thread(new IL1Iii(str, i2)).start();
                    return I1I.IL1Iii.IL1Iii(new byte[]{94, 14}, I1I.IL1Iii.IL1Iii(new byte[]{85, 3, 2, 7, 87, 4}, "dfd222"));
                }
                if (i3 == 1 || i3 == 0 || i3 == 2) {
                    new Thread(new iIlLiL(str, i3, i2)).start();
                }
                return I1I.IL1Iii.IL1Iii(new byte[]{94, 90}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 1, 86, 84, 6}, "e2b3fe"));
            }
            if (i2 == 1) {
                return BuildConfig.FLAVOR + I1I.I1I.p008IL.lIlii.iIilII1(I1I.I1I.p008IL.lIlii.LL1IL());
            }
            if (i2 == 2) {
                return BuildConfig.FLAVOR + I1I.I1I.p008IL.lIlii.m1177li11(I1I.I1I.p008IL.lIlii.LL1IL());
            }
            if (i2 == 3) {
                return BuildConfig.FLAVOR + I1I.I1I.p008IL.lIlii.m1147iI1iI(I1I.I1I.p008IL.lIlii.LL1IL());
            }
            if (i2 == 4) {
                return BuildConfig.FLAVOR + I1I.I1I.p008IL.lIlii.m1113I1L11L(I1I.I1I.p008IL.lIlii.LL1IL());
            }
            if (i2 >= 5 && i2 <= 7) {
                if (i2 == 5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(BuildConfig.FLAVOR);
                    sb.append(I1I.I1I.p008IL.lIlii.LI1(I1I.I1I.p008IL.lIlii.LL1IL(), i3 == 1));
                    return sb.toString();
                }
                if (i2 == 6) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(BuildConfig.FLAVOR);
                    sb2.append(I1I.I1I.p008IL.lIlii.Li1iLi(I1I.I1I.p008IL.lIlii.LL1IL(), i3 == 1));
                    return sb2.toString();
                }
                if (i2 != 7) {
                    return null;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(BuildConfig.FLAVOR);
                sb3.append(I1I.I1I.p008IL.lIlii.LLii1I(i3 == 1));
                return sb3.toString();
            }
            if (i2 == 8) {
                return BuildConfig.FLAVOR + I1I.I1I.p008IL.lIlii.m1182IillIi(I1I.I1I.p008IL.lIlii.LL1IL());
            }
            if (i2 == 9) {
                I1I.I1I.p008IL.lIlii.m25i(I1I.I1I.p008IL.lIlii.LL1IL(), str);
                return I1I.IL1Iii.IL1Iii(new byte[]{83}, I1I.IL1Iii.IL1Iii(new byte[]{6, 82, 82, 84, 1, 86}, "d4b207"));
            }
            if (i2 == 10) {
                return I1I.I1I.p008IL.lIlii.m1128L111() + BuildConfig.FLAVOR;
            }
            if (i2 == 11) {
                return BuildConfig.FLAVOR + I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().m1249lLi1LL();
            }
            if (i2 == 12) {
                I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().m1246L11I(i3);
                return I1I.IL1Iii.IL1Iii(new byte[]{1}, I1I.IL1Iii.IL1Iii(new byte[]{1, 11, 85, 1, 85, 6}, "0273d3"));
            }
            if (i2 == 13) {
                I1I.I1I.p008IL.lIlii.I1I(i3);
                return null;
            }
            if (i2 == 14) {
                p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(106, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
                return null;
            }
            if (i2 != 15) {
                return null;
            }
            m990lliiI1(I1I.I1I.p008IL.lIlii.LL1IL());
            return null;
        }
        if (i2 == 1 || i2 == 2) {
            return null;
        }
        if (i2 == 3) {
            return I1I.I1I.p008IL.lIlii.LII(I1I.I1I.p008IL.lIlii.LL1IL());
        }
        if (i2 == 4) {
            return I1I.I1I.p008IL.lIlii.m11781iIl(I1I.I1I.p008IL.lIlii.LL1IL());
        }
        if (i2 == 5) {
            return I1I.I1I.p008IL.lIlii.m1176lliiI1(I1I.I1I.p008IL.lIlii.LL1IL());
        }
        if (i2 == 7 || i2 == 8) {
            return null;
        }
        try {
            if (i2 == 9) {
                File fileM1019iILLL1 = l1IIi1.I1I().m1019iILLL1(str);
                if (fileM1019iILLL1.exists()) {
                    iILLl.IL1Iii(fileM1019iILLL1.getAbsolutePath());
                }
            } else {
                if (i2 == 10) {
                    I1I.I1I.p008IL.lIlii.LIlIlIL(new LlLI1(this, i3));
                    return null;
                }
                if (i2 == 11) {
                    if (i3 == 1) {
                        return null;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String string2 = jSONObject.has(I1I.IL1Iii.IL1Iii(new byte[]{22, 14, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 2, 81, 14, 94}, "0fde7f"))) ? jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{69, 8, 5}, I1I.IL1Iii.IL1Iii(new byte[]{86, 90, 80, 84, 7, 87}, "c9251d"))) : BuildConfig.FLAVOR;
                        if (jSONObject.has(I1I.IL1Iii.IL1Iii(new byte[]{87, 92, 17}, I1I.IL1Iii.IL1Iii(new byte[]{12, 8, 80, 1, 4, 14}, "882858")))) {
                            string = jSONObject.getString(I1I.IL1Iii.IL1Iii(new byte[]{20, 9, 82}, I1I.IL1Iii.IL1Iii(new byte[]{2, 85, 0, 86, 85, 13}, "f755b4")));
                        }
                        I1I.I1I.p008IL.lIlii.m1153iL11ll(I1I.I1I.p008IL.lIlii.LL1IL(), string2, string);
                        return I1I.IL1Iii.IL1Iii(new byte[]{6}, I1I.IL1Iii.IL1Iii(new byte[]{14, 87, 0, 9, 7, 11}, "9c2822"));
                    } catch (Exception e) {
                        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{121, 62}, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 6, 91, 1, 86}, "e758ec")), e.toString());
                        return I1I.IL1Iii.IL1Iii(new byte[]{7}, I1I.IL1Iii.IL1Iii(new byte[]{84, 5, 87, 8, 81, 5}, "c749bc"));
                    }
                }
                if (i2 == 12) {
                    I1I.I1I.p008IL.lIlii.m1170lIiILl1(this.f994LlLLL, str);
                    return null;
                }
                if (i2 == 13) {
                    return I1I.I1I.p008IL.lIlii.LL1IL().getPackageName();
                }
                if (i2 == 14) {
                    return I1I.I1I.p008IL.lIlii.m1152iILilI(I1I.I1I.p008IL.lIlii.LL1IL());
                }
                if (i2 == 15) {
                    return this.f998lIlii;
                }
                if (i2 == 16) {
                    return this.iIi1;
                }
                if (i2 == 17) {
                    return BuildConfig.FLAVOR + I1I.I1I.p008IL.lIlii.lI11lLL(I1I.I1I.p008IL.lIlii.LL1IL(), str);
                }
                if (i2 == 18) {
                    return I1I.I1I.p008IL.lIlii.m26(I1I.I1I.p008IL.lIlii.LL1IL());
                }
                if (i2 == 19) {
                    if (!TextUtils.isEmpty(str)) {
                        I1I.I1I.p008IL.lIlii.m1190il(I1I.I1I.p008IL.lIlii.LL1IL(), str);
                    }
                    return I1I.IL1Iii.IL1Iii(new byte[]{0}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 85, 5, 89, 1}, "5ceca3"));
                }
                if (i2 == 20) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    I1I.I1I.p008IL.lIlii.I1i1LL1(jSONObject2.getString(I1I.IL1Iii.IL1Iii(new byte[]{15, 67, 15, 87, 4, 65}, I1I.IL1Iii.IL1Iii(new byte[]{5, 5, 85, 80, 88, 87}, "d37e9d"))), jSONObject2.getString(I1I.IL1Iii.IL1Iii(new byte[]{80, 9, 15, 70, 0, 15, 71}, I1I.IL1Iii.IL1Iii(new byte[]{4, 95, 82, 80, 4, 83}, "793ba2"))));
                } else {
                    if (i2 == 21) {
                        I1I.I1I.p008IL.lIlii.m1171lIiI(I1I.I1I.p008IL.lIlii.LL1IL(), str, i3);
                        return I1I.IL1Iii.IL1Iii(new byte[]{9}, I1I.IL1Iii.IL1Iii(new byte[]{8, 0, 0, 1, 80, 86}, "02f11e"));
                    }
                    if (i2 == 22) {
                        I1I.I1I.p008IL.lIlii.illl(I1I.I1I.p008IL.lIlii.LL1IL(), str);
                        return I1I.IL1Iii.IL1Iii(new byte[]{83}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 9, 7, 3, 85}, "f20f4f"));
                    }
                    if (i2 == 23) {
                        I1I.I1I.p008IL.lIlii.l1L(I1I.I1I.p008IL.lIlii.LL1IL(), str);
                        return I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 1, 82, 82, 2}, "6ac477"));
                    }
                    if (i2 == 24) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(str);
                            I1I.I1I.p008IL.lIlii.m1159il1L(I1I.I1I.p008IL.lIlii.LL1IL(), jSONObject3.getString(I1I.IL1Iii.IL1Iii(new byte[]{21, 6, 29, 65}, I1I.IL1Iii.IL1Iii(new byte[]{85, 1, 81, 5, 86, 1}, "4b4079"))), jSONObject3.getInt(I1I.IL1Iii.IL1Iii(new byte[]{76}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 81, 7, 81, 2}, "b2ac2a"))), jSONObject3.getInt(I1I.IL1Iii.IL1Iii(new byte[]{72}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 10, 3, 9, 0}, "5c8509"))), jSONObject3.getInt(I1I.IL1Iii.IL1Iii(new byte[]{17, 83, 78, 23, 68, 92, 31, 83}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 2, 81, 3, 12}, "554249"))));
                        } catch (Exception unused2) {
                        }
                        return I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{86, 1, 1, 5, 15, 93}, "292298"));
                    }
                    if (i2 == 25) {
                        I1I.I1I.p008IL.lIlii.m1154iLiLI(I1I.I1I.p008IL.lIlii.LL1IL());
                        return null;
                    }
                    if (i2 == 26) {
                        JSONObject jSONObject4 = new JSONObject(str);
                        I1I.p062Ilil.p063IL1Iii.IL1Iii.m1244IiL().m1248lIiI(jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{94, 2}, I1I.IL1Iii.IL1Iii(new byte[]{86, 5, 14, 82, 3, 2}, "ac9dea"))), jSONObject4.getString(I1I.IL1Iii.IL1Iii(new byte[]{22, 82, 26, 77}, I1I.IL1Iii.IL1Iii(new byte[]{85, 14, 6, 90, 92, 0}, "79dc9e"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{69, 90, 66, 81}, I1I.IL1Iii.IL1Iii(new byte[]{80, 85, 89, 82, 5, 1}, "ffaf75"))), jSONObject4.getString(I1I.IL1Iii.IL1Iii(new byte[]{83, 9, 95, 90, 67}, I1I.IL1Iii.IL1Iii(new byte[]{9, 94, 82, 87, 82, 81}, "98abc2"))), jSONObject4.getString(I1I.IL1Iii.IL1Iii(new byte[]{6, 85}, I1I.IL1Iii.IL1Iii(new byte[]{93, 4, 11, 7, 81, 2}, "968f27"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{73, 87, 75}, I1I.IL1Iii.IL1Iii(new byte[]{11, 91, 12, 6, 5, 87}, "2c4c74"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{73}, I1I.IL1Iii.IL1Iii(new byte[]{5, 13, 82, 82, 1, 6}, "45d184"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{72}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 6, 82, 6, 1}, "e576d4"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{19, 12, 92, 70, 13}, I1I.IL1Iii.IL1Iii(new byte[]{92, 93, 93, 11, 86, 80}, "88e932"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{10, 0, 10, 5, 91, 65}, I1I.IL1Iii.IL1Iii(new byte[]{82, 85, 0, 4, 0, 0}, "00cf35"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{17, 87, 85, 90, 3, 7, 21}, I1I.IL1Iii.IL1Iii(new byte[]{89, 7, 3, 85, 7, 0}, "812caa"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{68, 3, 0, 18, 91, 72}, I1I.IL1Iii.IL1Iii(new byte[]{86, 1, 0, 81, 2, 15}, "bcd767"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{73, 5, 80, 16, 93, 81, 81, 16}, I1I.IL1Iii.IL1Iii(new byte[]{13, 0, 2, 0, 12, 6}, "4d6b80"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{20, 87, 87, 3, 90, 21, 16, 89, 94}, I1I.IL1Iii.IL1Iii(new byte[]{92, 2, 1, 4, 83, 81}, "842ef0"))), jSONObject4.getInt(I1I.IL1Iii.IL1Iii(new byte[]{81, 13, 15, 80, 12}, I1I.IL1Iii.IL1Iii(new byte[]{81, 86, 4, 84, 82, 85}, "a7bc04"))));
                    } else {
                        if (i2 == 27) {
                            if (UIMgr.getInstance().show(str)) {
                                return I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 4, 84, 82, 84}, "7d267c"));
                            }
                            return null;
                        }
                        if (i2 == 28) {
                            if (str != null) {
                                try {
                                    z = Boolean.parseBoolean(str);
                                } catch (Exception unused3) {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            return UIMgr.getInstance().close(i3, z) ? I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{93, 92, 9, 84, 1, 4}, "998047")) : I1I.IL1Iii.IL1Iii(new byte[]{2}, I1I.IL1Iii.IL1Iii(new byte[]{11, 81, 83, 2, 3, 91}, "9a51f8"));
                        }
                        if (i2 == 29) {
                            UIMgr.getInstance().setUIValue(i3, str);
                            return null;
                        }
                        if (i2 == 30) {
                            return UIMgr.getInstance().getUIValue(i3, str);
                        }
                        if (i2 == 31) {
                            return i3 == 1 ? UIMgr.getInstance().getUIConfig(str) : UIMgr.getInstance().setUIConfig(str);
                        }
                        if (i2 == 32) {
                            try {
                                return I1I.p062Ilil.ILil.I1I.m1257L1l().m1280(str);
                            } catch (Exception e2) {
                                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{120, 111}, I1I.IL1Iii.IL1Iii(new byte[]{15, 81, 1, 2, 6, 82}, "9f357d")), I1I.IL1Iii.IL1Iii(new byte[]{65, 94, 6, 15, 0, 66, 81, 69, 23, 88}, I1I.IL1Iii.IL1Iii(new byte[]{7, 2, 80, 85, 6, 85}, "3557b7")) + e2.toString());
                                return null;
                            }
                        }
                        if (i2 != 33) {
                            if (i2 == 35) {
                                p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(5, str, BuildConfig.FLAVOR));
                                return null;
                            }
                            if (i2 == 36) {
                                if (i3 == 0) {
                                    p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(6, I1I.IL1Iii.IL1Iii(new byte[]{83, 82, 93, 66, 93}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 7, 82, 13, 6}, "e46c50")), BuildConfig.FLAVOR));
                                    return null;
                                }
                                p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(6, I1I.IL1Iii.IL1Iii(new byte[]{17, 17, 22, 6}, I1I.IL1Iii.IL1Iii(new byte[]{84, 85, 84, 2, 86, 12}, "167af8")), BuildConfig.FLAVOR));
                                return null;
                            }
                            if (i2 == 38) {
                                try {
                                    Context contextLL1IL = I1I.I1I.p008IL.lIlii.LL1IL();
                                    return contextLL1IL.getResources().getString(contextLL1IL.getResources().getIdentifier(str, I1I.IL1Iii.IL1Iii(new byte[]{64, 64, 68, 91, 92, 80}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 1, 4, 84, 7}, "6d76f0")), contextLL1IL.getPackageName()));
                                } catch (Exception unused4) {
                                    return BuildConfig.FLAVOR;
                                }
                            }
                            if (i2 == 48) {
                                return I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 12, 80, 12, 90}, "3d5e48"));
                            }
                            if (i2 == 49) {
                                return I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 3, 80, 1, 86}, "6a15b5"));
                            }
                            if (i2 == 50) {
                                return !Native.checkIsDebug() ? I1I.IL1Iii.IL1Iii(new byte[]{84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 95, 2, 87, 13, 5}, "3f0a52")) : I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 87, 80, 4, 0}, "57dd6a"));
                            }
                            if (i2 != 51) {
                                return null;
                            }
                            if (i3 == 0) {
                                if (I1I.I1I.p008IL.lIlii.Ilil()) {
                                    return I1I.IL1Iii.IL1Iii(new byte[]{9}, I1I.IL1Iii.IL1Iii(new byte[]{91, 5, 80, 3, 80, 81}, "c6623b"));
                                }
                            } else if (i3 == 1 && LLL().m970I1L11L()) {
                                return I1I.IL1Iii.IL1Iii(new byte[]{85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 6, 15, 90, 0, 13}, "a779e9"));
                            }
                            return I1I.IL1Iii.IL1Iii(new byte[]{7}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 4, 81, 95, 13}, "144e99"));
                        }
                        if (i3 == 1) {
                            JSONObject jSONObject5 = new JSONObject(str);
                            int i4 = jSONObject5.getInt(I1I.IL1Iii.IL1Iii(new byte[]{17, 13, 13, 64}, I1I.IL1Iii.IL1Iii(new byte[]{90, 7, 87, 6, 87, 0}, "8b5128")));
                            double d = jSONObject5.getDouble(I1I.IL1Iii.IL1Iii(new byte[]{83, 15, 67, 14, 84}, I1I.IL1Iii.IL1Iii(new byte[]{4, 91, 5, 81, 13, 2}, "686782")));
                            if (i4 == 1) {
                                Console.getInstance().show((float) d);
                            } else {
                                Console.getInstance().hide();
                            }
                        } else {
                            if (i3 == 2) {
                                Console.getInstance().lock(true);
                                return null;
                            }
                            if (i3 == 3) {
                                Console.getInstance().lock(false);
                                return null;
                            }
                            if (i3 == 4) {
                                Console.getInstance().showTitle(true);
                                return null;
                            }
                            if (i3 == 5) {
                                Console.getInstance().showTitle(false);
                                return null;
                            }
                            if (i3 != 8) {
                                if (i3 == 7) {
                                    Console.getInstance().hide();
                                    return null;
                                }
                                if (i3 == 9) {
                                    try {
                                        JSONObject jSONObject6 = new JSONObject(str);
                                        Console.getInstance().setPos(jSONObject6.getInt(I1I.IL1Iii.IL1Iii(new byte[]{76}, I1I.IL1Iii.IL1Iii(new byte[]{87, 80, 6, 82, 7, 2}, "c14a76"))), jSONObject6.getInt(I1I.IL1Iii.IL1Iii(new byte[]{29}, I1I.IL1Iii.IL1Iii(new byte[]{83, 83, 4, 87, 80, 83}, "7e055f"))), jSONObject6.getInt(I1I.IL1Iii.IL1Iii(new byte[]{67}, I1I.IL1Iii.IL1Iii(new byte[]{4, 13, 0, 80, 5, 7}, "04b10a"))), jSONObject6.getInt(I1I.IL1Iii.IL1Iii(new byte[]{95}, I1I.IL1Iii.IL1Iii(new byte[]{85, 15, 87, 87, 91, 94}, "b83188"))));
                                        return null;
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        return null;
                                    }
                                }
                                if (i3 == 10) {
                                    Console.getInstance().clearLog();
                                    return null;
                                }
                                if (i3 != 11) {
                                    return null;
                                }
                                Console.getInstance().setTitle(str);
                                return null;
                            }
                            JSONObject jSONObject7 = new JSONObject(str);
                            Console.getInstance().println(jSONObject7.getInt(I1I.IL1Iii.IL1Iii(new byte[]{15, 92, 66, 87, 14}, I1I.IL1Iii.IL1Iii(new byte[]{91, 91, 12, 10, 6, 84}, "8b88db"))), jSONObject7.getString(I1I.IL1Iii.IL1Iii(new byte[]{87, 87, 15, 64, 4, 8, 64}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 85, 3, 82, 95}, "594739"))));
                        }
                    }
                }
            }
            return null;
        } catch (Exception unused5) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.lIlii, android.app.INXCoreNative
    public void sendLog(int i, String str, String str2, long j, boolean z) throws Throwable {
        String string;
        if (j > 0) {
            try {
                StringBuilder sb = this.I11li1.get(Long.valueOf(j));
                if (sb == null) {
                    sb = new StringBuilder();
                    this.I11li1.put(Long.valueOf(j), sb);
                }
                synchronized (sb) {
                    string = str2;
                    sb.append(string);
                }
                if (z) {
                    synchronized (sb) {
                        string = sb.toString();
                        sb.setLength(0);
                    }
                    this.I11li1.remove(Long.valueOf(j));
                }
            } catch (Exception unused) {
                return;
            }
        } else {
            string = str2;
        }
        if (z) {
            if (I1I.I1I.p008IL.lIlii.m1141LllI11()) {
                String str3 = new SimpleDateFormat(I1I.IL1Iii.IL1Iii(new byte[]{41, 126, 25, 95, 84, 31, 18, 69, 25, 97, 106, 98, 65}, I1I.IL1Iii.IL1Iii(new byte[]{84, 2, 1, 10, 93, 83}, "5468db"))).format(new Date());
                if (I1I.I1I.p008IL.lIlii.m1193li1Ii1i()) {
                    str3 = (((str3 + str) + " ") + i) + I1I.IL1Iii.IL1Iii(new byte[]{-39, -57, -66, 17}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 6, 4, 81, 84}, "f445fd"));
                }
                m5I1(str3 + string);
            }
            Native.sendEvent(2, i, str, string);
        }
    }

    /* JADX INFO: renamed from: 丨1 */
    public boolean m111(String str, String str2) {
        try {
            I1I.I1I.ILil.ILL ill = this.f3192Ilil;
            if (ill == null) {
                return false;
            }
            ill.m869llL1ii(str, str2);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: 丨i1丨1i, reason: contains not printable characters */
    public String m992i11i(String str) {
        try {
            I1I.I1I.ILil.ILL ill = this.f3192Ilil;
            if (ill != null) {
                return ill.LlLI1(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: 丨i1丨1丨LL, reason: contains not printable characters */
    public boolean m993i11LL() {
        String strIIlLiL;
        try {
            return this.f3192Ilil.m870lLi1LL() && (strIIlLiL = this.f3192Ilil.iIlLiL(15)) != null && strIIlLiL.equals(I1I.IL1Iii.IL1Iii(new byte[]{3}, I1I.IL1Iii.IL1Iii(new byte[]{87, 83, 82, 0, 84, 11}, "eb63a2")));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: 丨iI丨丨LLl, reason: contains not printable characters */
    public void m994iILLl() {
        try {
            this.I11li1.clear();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m995(Context context, C1 c1, String str) {
        new Thread(new RunnableC0602il(context, c1, str)).start();
    }
}
