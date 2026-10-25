package I1I.I1I.ILil;

import I1I.I1I.p008IL.lIlii;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.main.engine.NativeContext;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: I1I.I1I.ILil.l1IIi1丨, reason: invalid class name */
/* JADX INFO: compiled from: LResMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class l1IIi1 {

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static l1IIi1 f1030iILLL1 = new l1IIi1();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public File f3255IL1Iii = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public File f3256ILil = null;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public File f3254I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public File f1031IL = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public File f3257Ilil = null;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public File f1032lLi1LL = null;

    public static l1IIi1 I1I() {
        return f1030iILLL1;
    }

    public File IL1Iii() {
        return this.f3256ILil;
    }

    public File ILL() {
        return this.f3257Ilil;
    }

    public Drawable ILil(String str) {
        return null;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m1014ILl(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = I1I.IL1Iii.IL1Iii(new byte[]{8, 64, 7, 6, 83, 86, 8, 8, 7, 6}, I1I.IL1Iii.IL1Iii(new byte[]{8, 0, 81, 87, 90, 82}, I1I.IL1Iii.IL1Iii(new byte[]{4, 10, 83, 0, 95, 86}, "425afb")));
        }
        Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{74, 8, 12, 16, 24, 9, 26, 75, 6, 107, 77, 17, 57, 7, 27, 10, 5, 20, 4, 118, 27, 117, 57, 18, 75}, I1I.IL1Iii.IL1Iii(new byte[]{3, 5, 83, 85, 0, 15}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 83, 87, 81, 14}, "246158")))).matcher(str);
        if (matcher.find()) {
            textView.setTextColor(lIlii.m13I1(matcher.group(1)));
        }
    }

    public int Ilil(String str) {
        if (TextUtils.isEmpty(str)) {
            str = I1I.IL1Iii.IL1Iii(new byte[]{4, 75, 83, 84, 8, 2, 4, 3, 83, 84}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 81, 1, 0, 11}, I1I.IL1Iii.IL1Iii(new byte[]{86, 80, 5, 3, 12, 11}, "517f42")));
        }
        Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{75, 94, 9, 20, 31, 8, 27, 29, 3, 111, 74, 16, 56, 81, 30, 14, 2, 21, 5, 32, 30, 113, 62, 19, 74}, I1I.IL1Iii.IL1Iii(new byte[]{1, 85, 6, 15, 7, 10}, I1I.IL1Iii.IL1Iii(new byte[]{4, 85, 7, 94, 82, 10}, "fa2f68")))).matcher(str);
        if (matcher.find()) {
            return lIlii.m13I1(matcher.group(1));
        }
        return 0;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public File m1015IL() {
        return this.f1032lLi1LL;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public File m1016IiL() {
        return this.f3255IL1Iii;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m1017Ll1(Context context) {
        File parentFile;
        if (context instanceof NativeContext) {
            parentFile = context.getFilesDir().getParentFile();
            this.f1032lLi1LL = new File(parentFile, I1I.IL1Iii.IL1Iii(new byte[]{8, 95, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 0, 7, 87, 2, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 80, 7, 7, 7, 1}, "5f7a01"))));
        } else {
            File filesDir = context.getFilesDir();
            try {
                this.f1032lLi1LL = new File(context.getApplicationInfo().nativeLibraryDir);
            } catch (Exception unused) {
            }
            parentFile = filesDir;
        }
        File file = new File(parentFile, I1I.IL1Iii.IL1Iii(new byte[]{69, 6, 64, 94, 66, 71}, I1I.IL1Iii.IL1Iii(new byte[]{2, 93, 4, 15, 84, 0}, I1I.IL1Iii.IL1Iii(new byte[]{85, 89, 1, 90, 0, 85}, "aa7bff"))));
        File file2 = new File(parentFile, I1I.IL1Iii.IL1Iii(new byte[]{64, 89, 75, 90}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 0, 85, 6, 82}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 0, 7, 5, 15}, "ff9ca8"))));
        this.f3257Ilil = file2;
        if (!file2.exists()) {
            this.f3257Ilil.mkdirs();
        }
        this.f3255IL1Iii = new File(file, I1I.IL1Iii.IL1Iii(new byte[]{84, 90, 8}, I1I.IL1Iii.IL1Iii(new byte[]{4, 10, 4, 80, 90, 4}, I1I.IL1Iii.IL1Iii(new byte[]{2, 10, 3, 84, 9, 5}, "03a101"))));
        this.f3256ILil = new File(this.f3255IL1Iii, I1I.IL1Iii.IL1Iii(new byte[]{-40, -121, -30, -121, -125, -11, 31, 64, 3, 18}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 85, 80, 92, 87}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 1, 87, 84, 81}, "ec2f1c"))));
        this.f3254I1I = new File(this.f3255IL1Iii, I1I.IL1Iii.IL1Iii(new byte[]{-44, -10, -22, -40, -88, -112}, I1I.IL1Iii.IL1Iii(new byte[]{7, 83, 81, 83, 81, 11}, I1I.IL1Iii.IL1Iii(new byte[]{6, 7, 6, 82, 85, 14}, "271017"))));
        File file3 = new File(parentFile, I1I.IL1Iii.IL1Iii(new byte[]{68, 12, 81, 13, 86, 94, 88, 2}, I1I.IL1Iii.IL1Iii(new byte[]{82, 82, 0, 6, 94, 12}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 0, 86, 5, 86}, "aa22cb"))));
        this.f1031IL = file3;
        if (file3.exists()) {
            return;
        }
        this.f1031IL.mkdirs();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public File m1018L11I(String str) {
        return new File(this.f1031IL, str);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public File m1019iILLL1(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file = new File(this.f3256ILil, str);
        }
        if (!file.exists()) {
            file = new File(this.f3254I1I, str);
        }
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m1020lIiI(View view, String str) throws Throwable {
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = I1I.IL1Iii.IL1Iii(new byte[]{86, 25, 86, 82, 85, 9, 86, 81, 86, 82}, I1I.IL1Iii.IL1Iii(new byte[]{86, 83, 95, 86, 3, 8}, I1I.IL1Iii.IL1Iii(new byte[]{4, 80, 95, 13, 86, 8}, "4bf909")));
        }
        Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{24, 89, 94, 17, 78, 83, 72, 26, 84, 106, 27, 75, 107, 86, 73, 11, 83, 78, 86, 39, 73, 116, 111, 72, 25}, I1I.IL1Iii.IL1Iii(new byte[]{83, 7, 1, 5, 0, 81}, I1I.IL1Iii.IL1Iii(new byte[]{84, 89, 7, 3, 2, 4}, "78b406")))).matcher(str);
        if (matcher.find()) {
            view.setBackgroundColor(lIlii.m13I1(matcher.group(1)));
            return;
        }
        File fileM1019iILLL1 = m1019iILLL1(str);
        if (fileM1019iILLL1 == null) {
            view.setBackgroundColor(lIlii.m13I1(I1I.IL1Iii.IL1Iii(new byte[]{6, 30, 83, 7, 84, 8, 6, 86, 83, 7}, I1I.IL1Iii.IL1Iii(new byte[]{83, 87, 5, 5, 85, 1}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 86, 87, 9, 12}, "560e85")))));
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(fileM1019iILLL1);
                try {
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) BitmapDrawable.createFromStream(new FileInputStream(fileM1019iILLL1), null);
                    bitmapDrawable.setGravity(119);
                    view.setBackground(bitmapDrawable);
                    fileInputStream2.close();
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                    } else {
                        fileInputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public Drawable m1021lLi1LL(String str) throws Throwable {
        FileInputStream fileInputStream;
        Matcher matcher = Pattern.compile(I1I.IL1Iii.IL1Iii(new byte[]{17, 14, 13, 64, 68, 83, 65, 77, 7, 59, 17, 75, 98, 1, 26, 90, 89, 78, 95, 112, 26, 37, 101, 72, 16}, I1I.IL1Iii.IL1Iii(new byte[]{95, 83, 0, 81, 8, 82}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 14, 11, 86, 87}, "cf99ff")))).matcher(str);
        if (matcher.find()) {
            return new ColorDrawable(lIlii.m13I1(matcher.group(1)));
        }
        File fileM1019iILLL1 = m1019iILLL1(str);
        FileInputStream fileInputStream2 = null;
        if (fileM1019iILLL1 == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileM1019iILLL1);
            try {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) BitmapDrawable.createFromStream(new FileInputStream(fileM1019iILLL1), null);
                bitmapDrawable.setGravity(119);
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return bitmapDrawable;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public File m1022il() {
        return this.f3254I1I;
    }
}
