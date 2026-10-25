package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.sun.mail.pop3.POP3Message;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static final PorterDuff.Mode f2560il = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Object f4976ILil;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f4975IL1Iii = -1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public byte[] f4974I1I = null;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Parcelable f2561IL = null;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public int f4977Ilil = 0;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f2565lLi1LL = 0;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public ColorStateList f2564iILLL1 = null;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public PorterDuff.Mode f2562IiL = f2560il;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public String f2563L11I = null;

    public static int ILil(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static String m3165IL(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static String m3166iILLL1(int i) {
        if (i == 1) {
            return "BITMAP";
        }
        if (i == 2) {
            return "RESOURCE";
        }
        if (i == 3) {
            return "DATA";
        }
        if (i != 4) {
            return i != 5 ? POP3Message.UNKNOWN : "BITMAP_MASKABLE";
        }
        return "URI";
    }

    public String I1I() {
        int i = this.f4975IL1Iii;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return m3165IL((Icon) this.f4976ILil);
        }
        if (i == 2) {
            return ((String) this.f4976ILil).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int IL1Iii() {
        int i = this.f4975IL1Iii;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return ILil((Icon) this.f4976ILil);
        }
        if (i == 2) {
            return this.f4977Ilil;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public void Ilil() {
        this.f2562IiL = PorterDuff.Mode.valueOf(this.f2563L11I);
        int i = this.f4975IL1Iii;
        if (i == -1) {
            Parcelable parcelable = this.f2561IL;
            if (parcelable == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
            this.f4976ILil = parcelable;
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.f4976ILil = this.f4974I1I;
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                }
            }
            this.f4976ILil = new String(this.f4974I1I, Charset.forName("UTF-16"));
            return;
        }
        Parcelable parcelable2 = this.f2561IL;
        if (parcelable2 != null) {
            this.f4976ILil = parcelable2;
            return;
        }
        byte[] bArr = this.f4974I1I;
        this.f4976ILil = bArr;
        this.f4975IL1Iii = 3;
        this.f4977Ilil = 0;
        this.f2565lLi1LL = bArr.length;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m3167lLi1LL(boolean z) {
        this.f2563L11I = this.f2562IiL.name();
        int i = this.f4975IL1Iii;
        if (i == -1) {
            if (z) {
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            }
            this.f2561IL = (Parcelable) this.f4976ILil;
            return;
        }
        if (i != 1) {
            if (i == 2) {
                this.f4974I1I = ((String) this.f4976ILil).getBytes(Charset.forName("UTF-16"));
                return;
            }
            if (i == 3) {
                this.f4974I1I = (byte[]) this.f4976ILil;
                return;
            } else if (i == 4) {
                this.f4974I1I = this.f4976ILil.toString().getBytes(Charset.forName("UTF-16"));
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (!z) {
            this.f2561IL = (Parcelable) this.f4976ILil;
            return;
        }
        Bitmap bitmap = (Bitmap) this.f4976ILil;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
        this.f4974I1I = byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007a  */
    public String toString() {
        if (this.f4975IL1Iii == -1) {
            return String.valueOf(this.f4976ILil);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m3166iILLL1(this.f4975IL1Iii));
        int i = this.f4975IL1Iii;
        if (i == 1) {
            sb.append(" size=");
            sb.append(((Bitmap) this.f4976ILil).getWidth());
            sb.append("x");
            sb.append(((Bitmap) this.f4976ILil).getHeight());
        } else if (i == 2) {
            sb.append(" pkg=");
            sb.append(I1I());
            sb.append(" id=");
            sb.append(String.format("0x%08x", Integer.valueOf(IL1Iii())));
        } else if (i == 3) {
            sb.append(" len=");
            sb.append(this.f4977Ilil);
            if (this.f2565lLi1LL != 0) {
                sb.append(" off=");
                sb.append(this.f2565lLi1LL);
            }
        } else if (i == 4) {
            sb.append(" uri=");
            sb.append(this.f4976ILil);
        } else if (i == 5) {
            sb.append(" size=");
            sb.append(((Bitmap) this.f4976ILil).getWidth());
            sb.append("x");
            sb.append(((Bitmap) this.f4976ILil).getHeight());
        }
        if (this.f2564iILLL1 != null) {
            sb.append(" tint=");
            sb.append(this.f2564iILLL1);
        }
        if (this.f2562IiL != f2560il) {
            sb.append(" mode=");
            sb.append(this.f2562IiL);
        }
        sb.append(")");
        return sb.toString();
    }
}
