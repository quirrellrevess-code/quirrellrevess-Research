package I1I.I1I.I1I;

import I1I.I1I.p008IL.iILLL1;
import I1I.I1I.p008IL.lIlii;
import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.main.app.Native;
import com.main.request.AdVertRequest;
import com.main.request.CheckRequest;
import com.main.request.CheckResponse;
import com.qyzs.smn2.R;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import p047IL.C0007;
import retrofit2.Response;

/* JADX INFO: compiled from: HxApi.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static volatile I1I f3071Ilil;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Context f3074ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f3073IL1Iii = false;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f3072I1I = false;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f919IL = false;

    /* JADX INFO: compiled from: HxApi.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ILil f3076ILil;

        public IL1Iii(ILil iLil) {
            this.f3076ILil = iLil;
        }

        /* JADX WARN: Code duplicated, block: B:73:0x0430 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            I1I.I1I.I1I.IL1Iii iL1Iii;
            InputStream inputStream;
            if (I1I.this.f3073IL1Iii) {
                this.f3076ILil.IL1Iii();
                return;
            }
            byte b = 82;
            try {
                Response<CheckResponse> responseExecute = ((I1I.I1I.I1I.ILil.IL1Iii) I1I.I1I.I1I.ILil.IL1Iii().create(I1I.I1I.I1I.ILil.IL1Iii.class)).IL1Iii(new AdVertRequest(I1I.this.f3074ILil.getPackageName(), I1I.this.f3074ILil.getResources().getString(R.string.hashcode), 1)).execute();
                if (responseExecute == null) {
                    iL1Iii = null;
                } else {
                    CheckResponse checkResponseBody = responseExecute.body();
                    int code = checkResponseBody.getCode();
                    if (code == 200) {
                        CheckResponse.IL1Iii data = checkResponseBody.getData();
                        String result = Native.getResult(data.I1I(), data.ILil(), data.IL1Iii());
                        if (!TextUtils.isEmpty(result)) {
                            String[] strArrSplit = result.split(I1I.IL1Iii.IL1Iii(new byte[]{68, 23}, I1I.IL1Iii.IL1Iii(new byte[]{1, 6, 2, 15, 83, 15}, "c7f9f8")));
                            HashMap map = new HashMap();
                            int length = strArrSplit.length;
                            int i = 0;
                            while (i < length) {
                                String[] strArrSplit2 = strArrSplit[i].split(I1I.IL1Iii.IL1Iii(new byte[]{12}, I1I.IL1Iii.IL1Iii(new byte[]{6, 11, b, 87, b, 7}, "72dc1d")));
                                if (strArrSplit2.length == 2) {
                                    map.put(strArrSplit2[0], strArrSplit2[1]);
                                }
                                i++;
                                b = 82;
                            }
                            iL1Iii = new I1I.I1I.I1I.IL1Iii();
                            try {
                                iL1Iii.f3077I1I = (String) map.get(I1I.IL1Iii.IL1Iii(new byte[]{85, 84, 78, 109, 10, 15, 90, 84}, I1I.IL1Iii.IL1Iii(new byte[]{5, 85, 90, 83, 7, 82}, "1ebaf4")));
                                iL1Iii.f3078IL1Iii = (String) map.get(I1I.IL1Iii.IL1Iii(new byte[]{64, 89, 0, 60, 88, 8, 94, 91}, I1I.IL1Iii.IL1Iii(new byte[]{6, 81, 86, 2, 82, 4}, "6a5afe")));
                                iL1Iii.f3079ILil = (String) map.get(I1I.IL1Iii.IL1Iii(new byte[]{15, 14, 65, 0}, I1I.IL1Iii.IL1Iii(new byte[]{2, 4, 81, 6, 83, 1}, "cedc17")));
                                iL1Iii.f920IL = (String) map.get(I1I.IL1Iii.IL1Iii(new byte[]{85, 2, 18, 61, 91, 90, 90, 13}, I1I.IL1Iii.IL1Iii(new byte[]{85, 83, 86, 0, 85, 5}, "a52bb6")));
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                            }
                        }
                    } else if (code == 201) {
                        iILLL1.Ilil(I1I.this.f3074ILil).m1108IiL(I1I.IL1Iii.IL1Iii(new byte[]{14, 20, 57, 7, 83, 61, 9, 3, 31}, I1I.IL1Iii.IL1Iii(new byte[]{80, 80, 83, 5, 5, 4}, "265c2f")));
                        this.f3076ILil.IL1Iii();
                        return;
                    }
                    iL1Iii = null;
                }
            } catch (Exception e2) {
                e = e2;
                iL1Iii = null;
            }
            if (iL1Iii == null) {
                Bitmap bitmapI1I = iILLL1.Ilil(I1I.this.f3074ILil).I1I(I1I.IL1Iii.IL1Iii(new byte[]{10, 20, 57, 5, 80, 62, 13, 3, 31}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 85, 80, 7, 84}, "133435")));
                Map<String, String> mapM1110lLi1LL = iILLL1.Ilil(I1I.this.f3074ILil).m1110lLi1LL(I1I.IL1Iii.IL1Iii(new byte[]{10, 69, 62, 0, 93, 58, 13, 82, 24}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 0, 5, 0, 81}, "f4ad94")));
                if (bitmapI1I == null || mapM1110lLi1LL == null) {
                    this.f3076ILil.IL1Iii();
                    return;
                } else {
                    this.f3076ILil.ILil(bitmapI1I, mapM1110lLi1LL.get(I1I.IL1Iii.IL1Iii(new byte[]{91, 90, 15, 89}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 85, 80, 83, 5}, "364bf1"))), mapM1110lLi1LL.get(I1I.IL1Iii.IL1Iii(new byte[]{76, 78, 20, 85}, I1I.IL1Iii.IL1Iii(new byte[]{0, 81, 1, 6, 5, 83}, "8fe620"))), mapM1110lLi1LL.get(I1I.IL1Iii.IL1Iii(new byte[]{13, 89, 16, 93}, I1I.IL1Iii.IL1Iii(new byte[]{91, 5, 0, 91, 85, 84}, "83dc32"))));
                    return;
                }
            }
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(iL1Iii.m841IL()).openConnection();
                    httpURLConnection.setConnectTimeout(TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
                    httpURLConnection.setReadTimeout(TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
                    try {
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream2);
                            if (bitmapDecodeStream != null) {
                                HashMap map2 = new HashMap();
                                map2.put(I1I.IL1Iii.IL1Iii(new byte[]{13, 89, 94, 90}, I1I.IL1Iii.IL1Iii(new byte[]{80, 6, 84, 80, 83, 2}, "16da5f")), iL1Iii.ILil());
                                map2.put(I1I.IL1Iii.IL1Iii(new byte[]{16, 31, 19, 80}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 90, 83, 89, 2}, "0a9f85")), iL1Iii.IL1Iii());
                                map2.put(I1I.IL1Iii.IL1Iii(new byte[]{89, 13, 16, 7}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 0, 87, 4, 4}, "e0d5ab")), iL1Iii.I1I());
                                iILLL1.Ilil(I1I.this.f3074ILil).m1109iILLL1(I1I.IL1Iii.IL1Iii(new byte[]{90, 23, 61, 3, 83, 59, 93, 0, 27}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 86, 6, 1, 86}, "ff4d62")), bitmapDecodeStream, map2);
                                this.f3076ILil.ILil(bitmapDecodeStream, iL1Iii.ILil(), iL1Iii.IL1Iii(), iL1Iii.I1I());
                            } else {
                                this.f3076ILil.IL1Iii();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                        } catch (Exception unused) {
                            inputStream = inputStream2;
                            try {
                                this.f3076ILil.IL1Iii();
                                if (inputStream == null) {
                                } else {
                                    inputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception unused3) {
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (Exception unused4) {
                    this.f3076ILil.IL1Iii();
                }
            } catch (Exception unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: HxApi.java */
    public interface ILil {
        void IL1Iii();

        void ILil(Bitmap bitmap, String str, String str2, String str3);
    }

    static {
        I1I.IL1Iii.IL1Iii(new byte[]{15, 69, 102, 4, 80, 109, 8, 82, 64}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 93, 82, 4, 83}, "e1d70a"));
    }

    public I1I(Context context) {
        new C0007();
        this.f3074ILil = context.getApplicationContext();
    }

    public static I1I Ilil(Context context) {
        if (f3071Ilil == null) {
            synchronized (I1I.class) {
                if (f3071Ilil == null) {
                    f3071Ilil = new I1I(context);
                }
            }
        }
        return f3071Ilil;
    }

    public synchronized boolean I1I(boolean z) {
        if (lIlii.Ll1(this.f3074ILil)) {
            return lIlii.m1197I11(this.f3074ILil);
        }
        I1I.I1I.I1I.ILil.IL1Iii iL1Iii = (I1I.I1I.I1I.ILil.IL1Iii) I1I.I1I.I1I.ILil.IL1Iii().create(I1I.I1I.I1I.ILil.IL1Iii.class);
        String packageName = this.f3074ILil.getPackageName();
        String string = this.f3074ILil.getResources().getString(R.string.hashcode);
        String strM1176lliiI1 = lIlii.m1176lliiI1(this.f3074ILil);
        if (TextUtils.isEmpty(strM1176lliiI1)) {
            strM1176lliiI1 = I1I.IL1Iii.IL1Iii(new byte[]{87, 77, 10, 95}, I1I.IL1Iii.IL1Iii(new byte[]{88, 14, 86, 82, 86, 80}, "a60ab6"));
        }
        try {
            Response<CheckResponse> responseExecute = iL1Iii.ILil(new CheckRequest(packageName, string, strM1176lliiI1)).execute();
            if (responseExecute != null) {
                CheckResponse checkResponseBody = responseExecute.body();
                if (checkResponseBody.getCode() != 200) {
                    return false;
                }
                CheckResponse.IL1Iii data = checkResponseBody.getData();
                String result = Native.getResult(data.I1I(), data.ILil(), data.IL1Iii());
                if (!TextUtils.isEmpty(result)) {
                    byte b = 90;
                    String[] strArrSplit = result.split(I1I.IL1Iii.IL1Iii(new byte[]{30, 21}, I1I.IL1Iii.IL1Iii(new byte[]{90, 5, 92, 82, 3, 1}, "b69e43")));
                    HashMap map = new HashMap();
                    int length = strArrSplit.length;
                    int i = 0;
                    while (i < length) {
                        String[] strArrSplit2 = strArrSplit[i].split(I1I.IL1Iii.IL1Iii(new byte[]{4}, I1I.IL1Iii.IL1Iii(new byte[]{b, 81, 80, 7, 2, 15}, "cea736")));
                        if (strArrSplit2.length == 2) {
                            map.put(strArrSplit2[0], strArrSplit2[1]);
                        }
                        i++;
                        b = 90;
                    }
                    if (map.get(I1I.IL1Iii.IL1Iii(new byte[]{21, 16, 85, 21, 65, 22}, I1I.IL1Iii.IL1Iii(new byte[]{86, 85, 86, 85, 80, 93}, "01b4d8"))) != null && ((String) map.get(I1I.IL1Iii.IL1Iii(new byte[]{65, 69, 2, 68, 77, 23}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 2, 84, 11, 7}, "d3ad3c")))).compareTo(I1I.IL1Iii.IL1Iii(new byte[]{84}, I1I.IL1Iii.IL1Iii(new byte[]{84, 15, 0, 89, 82, 6}, "19d8c4"))) == 0) {
                        this.f919IL = true;
                        this.f3072I1I = true;
                        return true;
                    }
                    if (map.get(I1I.IL1Iii.IL1Iii(new byte[]{16, 22, 84, 22, 69, 16}, I1I.IL1Iii.IL1Iii(new byte[]{85, 91, 84, 85, 86, 87}, "69a7f4"))) != null && ((String) map.get(I1I.IL1Iii.IL1Iii(new byte[]{74, 68, 86, 70, 69, 18}, I1I.IL1Iii.IL1Iii(new byte[]{88, 82, 5, 1, 2, 80}, "ab2321")))).compareTo(I1I.IL1Iii.IL1Iii(new byte[]{86}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 82, 87, 86, 82}, "4cdeb4"))) == 0) {
                        this.f919IL = true;
                        this.f3072I1I = false;
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f919IL) {
            return this.f3072I1I;
        }
        return true;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public void m838IL(String str, String str2, String str3) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setAllowedNetworkTypes(3);
        request.setNotificationVisibility(1);
        String str4 = System.currentTimeMillis() + str2 + I1I.IL1Iii.IL1Iii(new byte[]{31, 89, 64, 82}, I1I.IL1Iii.IL1Iii(new byte[]{1, 9, 1, 11, 80, 80}, "011233"));
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        Uri uriFromFile = Uri.fromFile(new File(externalStoragePublicDirectory, str4));
        request.setDestinationUri(uriFromFile);
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 110}, I1I.IL1Iii.IL1Iii(new byte[]{13, 4, 85, 1, 0, 82}, "82f987")), uriFromFile.toString());
        request.setTitle(str2);
        request.setDescription(str3);
        request.setMimeType(I1I.IL1Iii.IL1Iii(new byte[]{85, 69, 71, 90, 95, 86, 85, 65, 94, 89, 88, 26, 66, 91, 83, 24, 87, 91, 80, 71, 88, 95, 82, 27, 68, 84, 84, 93, 87, 82, 81, 24, 86, 68, 85, 93, 93, 67, 82}, I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 4, 85, 2, 7}, "0f3c42")));
        long jEnqueue = ((DownloadManager) this.f3074ILil.getSystemService(I1I.IL1Iii.IL1Iii(new byte[]{87, 14, 66, 10, 13, 9, 82, 5}, I1I.IL1Iii.IL1Iii(new byte[]{10, 85, 84, 1, 84, 2}, "94ae5d")))).enqueue(request.setVisibleInDownloadsUi(false));
        lIlii.lILi1lLl(this.f3074ILil, I1I.IL1Iii.IL1Iii(new byte[]{-47, -89, -67, -128, -23, -121, -48, -113, -72, -115, -37, -118, -48, -113, -98, 73, -127, -67, -126, -47, -77, -28, -128, -105, -69, -46, -68, -54, -126, -116, -111, -47, -84, -64, -127, -85, -65, -45, -117, -18, -114, -118, -119, -33, -116, -2, -125, -115, -110}, I1I.IL1Iii.IL1Iii(new byte[]{6, 85, 10, 86, 2, 7}, "2b93d0")));
        SharedPreferences.Editor editorEdit = this.f3074ILil.getSharedPreferences(I1I.IL1Iii.IL1Iii(new byte[]{84, 65, 92, 81, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 10, 3, 84, 7}, "9e21f7")), 0).edit();
        editorEdit.putLong(I1I.IL1Iii.IL1Iii(new byte[]{83, 72, 15, 43, 7}, I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 6, 7, 87, 80}, "76be44")), jEnqueue);
        editorEdit.putString(I1I.IL1Iii.IL1Iii(new byte[]{87, 69, 15, 40, 13, 83, 82, 96, 22, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 7, 2, 80, 80, 3}, "12f421")), str4);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m839iILLL1(ILil iLil) {
        new Thread(new IL1Iii(iLil)).start();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m840lLi1LL() {
        this.f3073IL1Iii = true;
    }
}
