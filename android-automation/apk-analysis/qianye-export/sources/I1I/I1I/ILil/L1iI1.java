package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import I1I.p062Ilil.p064Ilil.ILil.IiL;
import I1I.p062Ilil.p064Ilil.ILil.lLi1LL;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: UiSelectorProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class L1iI1 extends InterfaceC0606LLlI1.IL1Iii {

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static final L1iI1 f950lIiI = new L1iI1();

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public Context f955iILLL1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public Object f3138I1I = new Object();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final Map<Long, IiL> f951IL = new ConcurrentHashMap();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public long f3139Ilil = 0;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public I1I.p062Ilil.p064Ilil.ILil.IL1Iii f956lLi1LL = null;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public L1l.IL1Iii f952IiL = null;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public int f954L11I = 0;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public long f957il = 0;
    public long ILL = 0;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public ParcelFileDescriptor f953Ll1 = null;

    /* JADX INFO: compiled from: UiSelectorProxy.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String[] f3141ILil;

        public IL1Iii(String[] strArr) {
            this.f3141ILil = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3141ILil[0] = L1iI1.this.ILL();
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public static L1iI1 m900lIiI() {
        return f950lIiI;
    }

    public synchronized String ILL() {
        int i;
        int i2;
        int i3;
        int i4;
        L1l.IL1Iii iL1Iii = this.f952IiL;
        if (iL1Iii != null) {
            iL1Iii.IL1Iii();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                Point pointILI1Ll = lIlii.ILI1Ll();
                Point pointM1180ILI = lIlii.m1180ILI();
                int iILil = C0003lL.I1I().ILil();
                if (iILil % 2 == 0) {
                    i = pointILI1Ll.x;
                    i2 = pointILI1Ll.y;
                    i3 = pointM1180ILI.x;
                    i4 = pointM1180ILI.y;
                } else {
                    i = pointILI1Ll.y;
                    i2 = pointILI1Ll.x;
                    i3 = pointM1180ILI.y;
                    i4 = pointM1180ILI.x;
                }
                int i5 = i2;
                int i6 = i4;
                int i7 = i3;
                int i8 = i;
                List<AccessibilityNodeInfo> listMo858iILLL1 = this.f956lLi1LL.mo858iILLL1();
                if (listMo858iILLL1 != null) {
                    LIll.I1I(listMo858iILLL1, null, i8, i5, iILil, i7, i6, byteArrayOutputStream, this.f956lLi1LL.Ilil());
                    String string = byteArrayOutputStream.toString();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return string;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{45, 60}, I1I.IL1Iii.IL1Iii(new byte[]{90, 2, 85, 83, 4, 1}, I1I.IL1Iii.IL1Iii(new byte[]{88, 4, 0, 4, 8, 14}, "abf688"))), I1I.IL1Iii.IL1Iii(new byte[]{80, 17, 95, 22, 20, 84, 70, 22, 8}, I1I.IL1Iii.IL1Iii(new byte[]{1, 93, 4, 84, 13, 1}, I1I.IL1Iii.IL1Iii(new byte[]{87, 13, 82, 86, 12, 85}, "b4dd5e"))) + e.toString());
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused3) {
        }
        return null;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m901ILl(Context context, L1l.IL1Iii iL1Iii) {
        this.f955iILLL1 = context;
        this.f952IiL = iL1Iii;
        L1l l1l = new L1l(context);
        l1l.m930IiL(iL1Iii);
        this.f956lLi1LL = l1l;
    }

    public void Ilil() {
        synchronized (this.f3138I1I) {
            Iterator<Map.Entry<Long, IiL>> it = this.f951IL.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().m1360iILilI();
                it.remove();
            }
        }
    }

    public void Lil(L1l.IL1Iii iL1Iii) {
        IIiI iIiI = new IIiI();
        iIiI.m857IiL(iL1Iii);
        this.f956lLi1LL = iIiI;
        this.f952IiL = iL1Iii;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public I1I.p062Ilil.p064Ilil.ILil.IL1Iii m902Ll1() {
        return this.f956lLi1LL;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean accessibilityFocus(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1354I1L11L();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void bounds(long j, int i, int i2, int i3, int i4) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.ILil(i, i2, i3, i4);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void boundsContains(long j, int i, int i2, int i3, int i4) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.I1I(i, i2, i3, i4);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void boundsInside(long j, int i, int i2, int i3, int i4) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1327IL(i, i2, i3, i4);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void checkable(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.Ilil(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void checked(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1344lLi1LL(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void className(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1337iILLL1(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void classNameContains(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1328IiL(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void classNameEndsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1335L11I(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void classNameMatches(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.mo1347il(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void classNameStartsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.ILL(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean clearAccessibilityFocus(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1355ILLIi();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean clearFocus(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1366li11();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean click(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.iIilII1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void clickable(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1333Ll1(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean collapse(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m32i1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean contextClick(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1362ili11();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean copy(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m33iI();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean cut(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1357LlLiLL();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void depth(long j, int i) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1340lIiI(i);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void desc(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1325ILl(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void descContains(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.Lil(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void descEndsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.LlLI1(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void descMatches(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.mo1343llL1ii(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void descStartsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1342lIlii(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean dismiss(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m30I();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void drawingOrder(long j, int i) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.iIi1(i);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void enabled(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.iIlLiL(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean expand(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m29I1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public long[] findAll(long j, long j2) throws RemoteException {
        lLi1LL[] lli1llArrL1iI1;
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL == null || (lli1llArrL1iI1 = iiL.L1iI1(j2)) == null || lli1llArrL1iI1.length <= 0) {
            return null;
        }
        int length = lli1llArrL1iI1.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = i11i.ILL().m1044Ll1(lli1llArrL1iI1[i]);
        }
        return jArr;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public long findOnce(long j) throws RemoteException {
        lLi1LL lli1llM34lL;
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL == null || (lli1llM34lL = iiL.m34lL()) == null) {
            return 0L;
        }
        return i11i.ILL().m1044Ll1(lli1llM34lL);
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public long findOnceEx(long j, int i) throws RemoteException {
        lLi1LL lli1llL1Lll;
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL == null || (lli1llL1Lll = iiL.l1Lll(i)) == null) {
            return 0L;
        }
        return i11i.ILL().m1044Ll1(lli1llL1Lll);
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public long findOne(long j) throws RemoteException {
        lLi1LL lli1llI1IILIIL;
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL == null || (lli1llI1IILIIL = iiL.I1IILIIL()) == null) {
            return 0L;
        }
        return i11i.ILL().m1044Ll1(lli1llI1IILIIL);
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public long findOneEx(long j, long j2) throws RemoteException {
        lLi1LL lli1llIll1LI1l;
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL == null || (lli1llIll1LI1l = iiL.ill1LI1l(j2)) == null) {
            return 0L;
        }
        return i11i.ILL().m1044Ll1(lli1llIll1LI1l);
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean focus(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1365lIIiIlL();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void focusable(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.I11L(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void focused(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.llliI(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    /* JADX INFO: renamed from: id */
    public void mo2id(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1370i11LL(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void idContains(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m13511(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void idEndsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1336LlLLL(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void idMatches(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.mo1341lIII(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void idStartsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.LL1IL(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void index(long j, int i) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1330L111(i);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean longClick(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1358iIl1il();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void longClickable(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1350LLlI1(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public long obtain() throws RemoteException {
        long jLongValue;
        synchronized (this.f3138I1I) {
            Long lValueOf = Long.valueOf(this.f3139Ilil + 1);
            if (lValueOf.longValue() == RecyclerView.FOREVER_NS) {
                lValueOf = 1L;
            }
            this.f951IL.put(lValueOf, new IiL(this.f956lLi1LL));
            this.f3139Ilil = lValueOf.longValue();
            jLongValue = lValueOf.longValue();
        }
        return jLongValue;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public Bundle obtainXml() {
        Bundle bundle = new Bundle();
        String[] strArr = new String[1];
        Thread thread = new Thread(new IL1Iii(strArr));
        thread.start();
        try {
            thread.join(30000L);
        } catch (Exception unused) {
        }
        try {
            if (thread.isAlive()) {
                thread.interrupt();
                if (lIlii.m1183IlL1ll1()) {
                    int i = this.f954L11I + 1;
                    this.f954L11I = i;
                    if (i > 5) {
                        lIlii.m24L();
                    }
                }
            }
            if (lIlii.m1183IlL1ll1()) {
                if (strArr[0] == null) {
                    this.ILL++;
                    if (this.f957il == 0) {
                        this.f957il = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - this.f957il > 10000 && this.ILL > 10) {
                        lIlii.m24L();
                    }
                } else {
                    this.ILL = 0L;
                    this.f957il = 0L;
                }
            }
        } catch (Exception unused2) {
        }
        if (strArr[0] != null) {
            this.f954L11I = 0;
            String strM1149iIl1il = lIlii.m1149iIl1il();
            if (strM1149iIl1il != null) {
                try {
                    ParcelFileDescriptor parcelFileDescriptor = this.f953Ll1;
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                } catch (Exception unused3) {
                }
                File file = new File(strM1149iIl1il);
                if (file.exists()) {
                    file.delete();
                }
                lIlii.I1i(strArr[0], file.getAbsolutePath());
                try {
                    try {
                        this.f953Ll1 = ParcelFileDescriptor.open(file, Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
                        bundle.putParcelable(I1I.IL1Iii.IL1Iii(new byte[]{81, 2}, I1I.IL1Iii.IL1Iii(new byte[]{5, 86, 7, 86, 80, 12}, I1I.IL1Iii.IL1Iii(new byte[]{7, 7, 11, 80, 7, 92}, "578dce"))), this.f953Ll1);
                        bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{22, 81, 18}, I1I.IL1Iii.IL1Iii(new byte[]{1, 5, 82, 0, 2, 2}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 86, 80, 86, 0}, "2cbc5d"))), 1);
                    } catch (Exception unused4) {
                        bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{69, 85, 21}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 88, 1, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{1, 89, 91, 2, 92, 88}, "68b1e9"))), 0);
                    }
                } catch (Exception unused5) {
                    ParcelFileDescriptor parcelFileDescriptor2 = this.f953Ll1;
                    if (parcelFileDescriptor2 != null) {
                        parcelFileDescriptor2.close();
                    }
                    bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{69, 85, 21}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 88, 1, 0, 5}, I1I.IL1Iii.IL1Iii(new byte[]{1, 89, 91, 2, 92, 88}, "68b1e9"))), 0);
                    return bundle;
                }
            } else {
                bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{16, 84, 76}, I1I.IL1Iii.IL1Iii(new byte[]{87, 8, 11, 0, 4, 7}, I1I.IL1Iii.IL1Iii(new byte[]{12, 15, 0, 11, 7, 5}, "9632ad"))), 0);
            }
        } else {
            bundle.putInt(I1I.IL1Iii.IL1Iii(new byte[]{69, 6, 70}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 80, 87, 83, 85}, I1I.IL1Iii.IL1Iii(new byte[]{8, 5, 4, 7, 3, 85}, "9cf6bc"))), 0);
        }
        return bundle;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void packageName(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m28(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void packageNameContains(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.llI(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void packageNameEndsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1339l1IIi1(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void packageNameMatches(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.mo1334L1l(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void packageNameStartsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1346iILLl(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void password(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1326IIi(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean paste(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.LI11();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void release(long j) throws RemoteException {
        synchronized (this.f3138I1I) {
            if (this.f951IL.get(Long.valueOf(j)) != null) {
                this.f951IL.remove(Long.valueOf(j));
            }
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollBackward(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.Liil1L1l();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollDown(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m31LL();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollForward(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1363i1I1I1l();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollLeft(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1359iI1LI();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollRight(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m371();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollTo(long j, int i, int i2) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m1364iILiiLl(i, i2);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean scrollUp(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.ILI1Ll();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void scrollable(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1331LIll(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean select(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m36l();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void selected(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1338ill(z);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public int setMode(int i) throws RemoteException {
        I1I.p062Ilil.p064Ilil.ILil.IL1Iii iL1Iii = this.f956lLi1LL;
        if (iL1Iii == null) {
            return 0;
        }
        iL1Iii.mo859lLi1LL(i);
        return 0;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean setProgress(long j, float f) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.m13671iIl(f);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean setSelection(long j, int i, int i2) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.LII(i, i2);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean setText(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.LIlLi(str);
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public boolean show(long j) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            return iiL.lI1I1();
        }
        return false;
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void text(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1352(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void textContains(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1329L11(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void textEndsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1332LlIl(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void textMatches(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.mo1324IIiI(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void textStartsWith(long j, String str) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.m1345lliiI1(str);
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0606LLlI1
    public void visibleToUser(long j, boolean z) throws RemoteException {
        IiL iiL = this.f951IL.get(Long.valueOf(j));
        if (iiL != null) {
            iiL.LLL(z);
        }
    }
}
