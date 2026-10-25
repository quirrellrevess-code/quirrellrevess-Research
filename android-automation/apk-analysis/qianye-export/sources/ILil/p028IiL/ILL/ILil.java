package ILil.p028IiL.ILL;

import ILil.p028IiL.p033iILLL1.C0637il;
import ILil.p028IiL.p034lIiI.L11I;
import ILil.p065Ilil.LlLI1;
import ILil.p065Ilil.lIlii;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final LlLI1<String, Typeface> f4016IL1Iii = new LlLI1<>(16);

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final ILil.p028IiL.ILL.I1I f4017ILil = new ILil.p028IiL.ILL.I1I("fonts", 10, 10000);

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final Object f4015I1I = new Object();

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final lIlii<String, ArrayList<ILil.p028IiL.ILL.I1I.IL<IiL>>> f1608IL = new lIlii<>();

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final Comparator<byte[]> f4018Ilil = new IL();

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class I1I implements ILil.p028IiL.ILL.I1I.IL<IiL> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f4019IL1Iii;

        public I1I(String str) {
            this.f4019IL1Iii = str;
        }

        @Override // ILil.p028IiL.ILL.I1I.IL
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void IL1Iii(IiL iiL) {
            synchronized (ILil.f4015I1I) {
                lIlii<String, ArrayList<ILil.p028IiL.ILL.I1I.IL<IiL>>> lilii = ILil.f1608IL;
                ArrayList<ILil.p028IiL.ILL.I1I.IL<IiL>> arrayList = lilii.get(this.f4019IL1Iii);
                if (arrayList == null) {
                    return;
                }
                lilii.remove(this.f4019IL1Iii);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).IL1Iii(iiL);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class IL1Iii implements Callable<IiL> {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ int f4020I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Context f4021IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ILil.p028IiL.ILL.IL1Iii f4022ILil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ String f1609IL;

        public IL1Iii(Context context, ILil.p028IiL.ILL.IL1Iii iL1Iii, int i, String str) {
            this.f4021IL1Iii = context;
            this.f4022ILil = iL1Iii;
            this.f4020I1I = i;
            this.f1609IL = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public IiL call() throws Exception {
            IiL iiLM2019lLi1LL = ILil.m2019lLi1LL(this.f4021IL1Iii, this.f4022ILil, this.f4020I1I);
            Typeface typeface = iiLM2019lLi1LL.f4025IL1Iii;
            if (typeface != null) {
                ILil.f4016IL1Iii.m1949IL(this.f1609IL, typeface);
            }
            return iiLM2019lLi1LL;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class C0561ILil implements ILil.p028IiL.ILL.I1I.IL<IiL> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ ILil.p028IiL.p035lLi1LL.I1I.iILLL1.IL1Iii f4023IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ Handler f4024ILil;

        public C0561ILil(ILil.p028IiL.p035lLi1LL.I1I.iILLL1.IL1Iii iL1Iii, Handler handler) {
            this.f4023IL1Iii = iL1Iii;
            this.f4024ILil = handler;
        }

        @Override // ILil.p028IiL.ILL.I1I.IL
        /* JADX INFO: renamed from: ILil, reason: merged with bridge method [inline-methods] */
        public void IL1Iii(IiL iiL) {
            if (iiL == null) {
                this.f4023IL1Iii.callbackFailAsync(1, this.f4024ILil);
                return;
            }
            int i = iiL.f4026ILil;
            if (i == 0) {
                this.f4023IL1Iii.callbackSuccessAsync(iiL.f4025IL1Iii, this.f4024ILil);
            } else {
                this.f4023IL1Iii.callbackFailAsync(i, this.f4024ILil);
            }
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.ILil$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class IL implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        length = bArr[i];
                        length2 = bArr2[i];
                    }
                }
                return 0;
            }
            length = bArr.length;
            length2 = bArr2.length;
            return length - length2;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.ILil$I丨iL, reason: invalid class name */
    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static final class IiL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Typeface f4025IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f4026ILil;

        public IiL(Typeface typeface, int i) {
            this.f4025IL1Iii = typeface;
            this.f4026ILil = i;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.ILil$iI丨LLL1, reason: invalid class name */
    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class iILLL1 {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final int f4027I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final Uri f4028IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f4029ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final int f4030Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final boolean f1610IL;

        public iILLL1(Uri uri, int i, int i2, boolean z, int i3) {
            L11I.m2295IL(uri);
            this.f4028IL1Iii = uri;
            this.f4029ILil = i;
            this.f4027I1I = i2;
            this.f1610IL = z;
            this.f4030Ilil = i3;
        }

        public Uri I1I() {
            return this.f4028IL1Iii;
        }

        public int IL1Iii() {
            return this.f4030Ilil;
        }

        public int ILil() {
            return this.f4029ILil;
        }

        public boolean Ilil() {
            return this.f1610IL;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public int m2020IL() {
            return this.f4027I1I;
        }
    }

    /* JADX INFO: renamed from: ILil.I丨iL.ILL.ILil$l丨Li1LL, reason: invalid class name */
    /* JADX INFO: compiled from: FontsContractCompat.java */
    public static class lLi1LL {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final int f4031IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final iILLL1[] f4032ILil;

        public lLi1LL(int i, iILLL1[] iilll1Arr) {
            this.f4031IL1Iii = i;
            this.f4032ILil = iilll1Arr;
        }

        public iILLL1[] IL1Iii() {
            return this.f4032ILil;
        }

        public int ILil() {
            return this.f4031IL1Iii;
        }
    }

    public static lLi1LL I1I(Context context, CancellationSignal cancellationSignal, ILil.p028IiL.ILL.IL1Iii iL1Iii) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoM2016IiL = m2016IiL(context.getPackageManager(), iL1Iii, context.getResources());
        return providerInfoM2016IiL == null ? new lLi1LL(1, null) : new lLi1LL(0, Ilil(context, iL1Iii, providerInfoM2016IiL.authority, cancellationSignal));
    }

    public static List<byte[]> IL1Iii(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean ILil(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static iILLL1[] Ilil(Context context, ILil.p028IiL.ILL.IL1Iii iL1Iii, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorQuery = null;
        try {
            cursorQuery = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{iL1Iii.m2014lLi1LL()}, null, cancellationSignal) : context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{iL1Iii.m2014lLi1LL()}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    int i = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    arrayList2.add(new iILLL1(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (iILLL1[]) arrayList.toArray(new iILLL1[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static List<List<byte[]>> m2015IL(ILil.p028IiL.ILL.IL1Iii iL1Iii, Resources resources) {
        return iL1Iii.IL1Iii() != null ? iL1Iii.IL1Iii() : ILil.p028IiL.p035lLi1LL.I1I.I1I.I1I(resources, iL1Iii.ILil());
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static ProviderInfo m2016IiL(PackageManager packageManager, ILil.p028IiL.ILL.IL1Iii iL1Iii, Resources resources) throws PackageManager.NameNotFoundException {
        String strM2013IL = iL1Iii.m2013IL();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strM2013IL, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strM2013IL);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(iL1Iii.Ilil())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strM2013IL + ", but package was not " + iL1Iii.Ilil());
        }
        List<byte[]> listIL1Iii = IL1Iii(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listIL1Iii, f4018Ilil);
        List<List<byte[]>> listM2015IL = m2015IL(iL1Iii, resources);
        for (int i = 0; i < listM2015IL.size(); i++) {
            ArrayList arrayList = new ArrayList(listM2015IL.get(i));
            Collections.sort(arrayList, f4018Ilil);
            if (ILil(listIL1Iii, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static Map<Uri, ByteBuffer> m2017L11I(Context context, iILLL1[] iilll1Arr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (iILLL1 iilll1 : iilll1Arr) {
            if (iilll1.IL1Iii() == 0) {
                Uri uriI1I = iilll1.I1I();
                if (!map.containsKey(uriI1I)) {
                    map.put(uriI1I, C0637il.m2293lLi1LL(context, cancellationSignal, uriI1I));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static Typeface m2018iILLL1(Context context, ILil.p028IiL.ILL.IL1Iii iL1Iii, ILil.p028IiL.p035lLi1LL.I1I.iILLL1.IL1Iii iL1Iii2, Handler handler, boolean z, int i, int i2) {
        String str = iL1Iii.I1I() + "-" + i2;
        Typeface typefaceI1I = f4016IL1Iii.I1I(str);
        if (typefaceI1I != null) {
            if (iL1Iii2 != null) {
                iL1Iii2.onFontRetrieved(typefaceI1I);
            }
            return typefaceI1I;
        }
        if (z && i == -1) {
            IiL iiLM2019lLi1LL = m2019lLi1LL(context, iL1Iii, i2);
            if (iL1Iii2 != null) {
                int i3 = iiLM2019lLi1LL.f4026ILil;
                if (i3 == 0) {
                    iL1Iii2.callbackSuccessAsync(iiLM2019lLi1LL.f4025IL1Iii, handler);
                } else {
                    iL1Iii2.callbackFailAsync(i3, handler);
                }
            }
            return iiLM2019lLi1LL.f4025IL1Iii;
        }
        IL1Iii iL1Iii3 = new IL1Iii(context, iL1Iii, i2, str);
        if (z) {
            try {
                return ((IiL) f4017ILil.Ilil(iL1Iii3, i)).f4025IL1Iii;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        C0561ILil c0561ILil = iL1Iii2 == null ? null : new C0561ILil(iL1Iii2, handler);
        synchronized (f4015I1I) {
            lIlii<String, ArrayList<ILil.p028IiL.ILL.I1I.IL<IiL>>> lilii = f1608IL;
            ArrayList<ILil.p028IiL.ILL.I1I.IL<IiL>> arrayList = lilii.get(str);
            if (arrayList != null) {
                if (c0561ILil != null) {
                    arrayList.add(c0561ILil);
                }
                return null;
            }
            if (c0561ILil != null) {
                ArrayList<ILil.p028IiL.ILL.I1I.IL<IiL>> arrayList2 = new ArrayList<>();
                arrayList2.add(c0561ILil);
                lilii.put(str, arrayList2);
            }
            f4017ILil.m2012IL(iL1Iii3, new I1I(str));
            return null;
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public static IiL m2019lLi1LL(Context context, ILil.p028IiL.ILL.IL1Iii iL1Iii, int i) {
        try {
            lLi1LL lli1llI1I = I1I(context, null, iL1Iii);
            if (lli1llI1I.ILil() != 0) {
                return new IiL(null, lli1llI1I.ILil() == 1 ? -2 : -3);
            }
            Typeface typefaceILil = ILil.p028IiL.p033iILLL1.I1I.ILil(context, null, lli1llI1I.IL1Iii(), i);
            return new IiL(typefaceILil, typefaceILil != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new IiL(null, -1);
        }
    }
}
