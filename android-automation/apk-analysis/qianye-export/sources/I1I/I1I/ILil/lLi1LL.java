package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: I1I.I1I.ILil.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: ActivityManager.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL {

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static final String f3286Ilil = "I1I.I1I.ILil.l丨Li1LL";

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f3287I1I = false;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IInterface f3288IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Method f3289ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Method f1039IL;

    public lLi1LL(IInterface iInterface) {
        this.f3288IL1Iii = iInterface;
    }

    public final Method I1I() throws NoSuchMethodException {
        if (this.f1039IL == null) {
            this.f1039IL = this.f3288IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{69, 81, 94, 11, 18, 84, 116, 91, 93, 16, 1, 95, 67, 100, 65, 11, 18, 88, 83, 81, 65, 33, 28, 69, 82, 70, 93, 5, 8}, I1I.IL1Iii.IL1Iii(new byte[]{7, 6, 10, 6, 2, 0}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 13, 1, 87, 85}, "674c1d"))), String.class, IBinder.class);
        }
        return this.f1039IL;
    }

    public IiL IL1Iii(String str, IBinder iBinder) {
        try {
            Object objInvoke = ILil().invoke(this.f3288IL1Iii, !this.f3287I1I ? new Object[]{str, 0, iBinder, null} : new Object[]{str, 0, iBinder});
            if (objInvoke == null) {
                return null;
            }
            Field declaredField = objInvoke.getClass().getDeclaredField(I1I.IL1Iii.IL1Iii(new byte[]{67, 23, 90, 66, 94, 84, 86, 23}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 4, 12, 5, 4}, I1I.IL1Iii.IL1Iii(new byte[]{85, 86, 5, 94, 6, 13}, "644f49"))));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            if (obj == null) {
                return null;
            }
            return new IiL(this, obj, str, iBinder);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            IiL.IL1Iii(f3286Ilil, I1I.IL1Iii.IL1Iii(new byte[]{33, 87, 22, 15, 87, 19, 12, 87, 23, 67, 90, 93, 20, 87, 8, 6, 19, 94, 7, 76, 11, 12, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 11, 84, 1, 11, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, 3, 86, 87, 93, 0}, "c0a5ed"))) + e.toString());
            return null;
        }
    }

    public final Method ILil() throws NoSuchMethodException {
        if (this.f3289ILil == null) {
            try {
                this.f3289ILil = this.f3288IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{4, 4, 76, 115, 89, 13, 23, 4, 86, 68, 102, 17, 12, 23, 81, 84, 83, 17, 38, 25, 76, 85, 68, 13, 2, 13}, I1I.IL1Iii.IL1Iii(new byte[]{5, 89, 10, 84, 14, 87}, I1I.IL1Iii.IL1Iii(new byte[]{82, 0, 80, 80, 90, 13}, "48b4b9"))), String.class, Integer.TYPE, IBinder.class, String.class);
            } catch (NoSuchMethodException unused) {
                this.f3289ILil = this.f3288IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{87, 6, 71, 114, 87, 93, 68, 6, 93, 69, 104, 65, 95, 21, 90, 85, 93, 65, 117, 27, 71, 84, 74, 93, 81, 15}, I1I.IL1Iii.IL1Iii(new byte[]{9, 2, 86, 8, 1, 80}, I1I.IL1Iii.IL1Iii(new byte[]{95, 7, 0, 10, 0, 2}, "ffe39a"))), String.class, Integer.TYPE, IBinder.class);
                this.f3287I1I = true;
            }
        }
        return this.f3289ILil;
    }

    public void Ilil(String str, IBinder iBinder) {
        try {
            I1I().invoke(this.f3288IL1Iii, str, iBinder);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            IiL.IL1Iii(f3286Ilil, I1I.IL1Iii.IL1Iii(new byte[]{116, 11, 65, 85, 7, 65, 89, 11, 64, 25, 10, 15, 65, 11, 95, 92, 67, 12, 82, 16, 92, 86, 7}, I1I.IL1Iii.IL1Iii(new byte[]{2, 93, 87, 93, 0, 85}, I1I.IL1Iii.IL1Iii(new byte[]{83, 11, 2, 87, 81, 86}, "f2a32b"))) + e.toString());
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m1034IL() {
        IBinder iBinderAsBinder;
        IInterface iInterface = this.f3288IL1Iii;
        return iInterface == null || (iBinderAsBinder = iInterface.asBinder()) == null || !iBinderAsBinder.isBinderAlive();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m1035lLi1LL(String str) {
        ComponentName componentName;
        try {
            Class<?> cls = this.f3288IL1Iii.getClass();
            Intent intent = new Intent();
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString == null) {
                return false;
            }
            intent.setComponent(componentNameUnflattenFromString);
            intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{81, 90, 77, 90, 93, 90}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 92, 80, 5, 3}, I1I.IL1Iii.IL1Iii(new byte[]{3, 0, 3, 87, 6, 15}, "68f418"))), I1I.IL1Iii.IL1Iii(new byte[]{89, 83, 3, 64, 88, 89, 68, 83}, I1I.IL1Iii.IL1Iii(new byte[]{1, 1, 82, 9, 7, 3}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 82, 14, 82, 1}, "63f7a2"))));
            Class<?> cls2 = Class.forName(I1I.IL1Iii.IL1Iii(new byte[]{2, 8, 93, 64, 11, 91, 7, 72, 88, 66, 20, 28, 42, 39, 73, 66, 8, 91, 0, 7, 77, 91, 11, 92, 55, 14, 75, 87, 5, 86}, I1I.IL1Iii.IL1Iii(new byte[]{1, 86, 1, 80, 83, 83}, I1I.IL1Iii.IL1Iii(new byte[]{86, 2, 90, 3, 4, 89}, "42ba38"))));
            try {
                componentName = (ComponentName) cls.getMethod(I1I.IL1Iii.IL1Iii(new byte[]{68, 67, 84, 17, 18, 54, 82, 69, 67, 10, 5, 0}, I1I.IL1Iii.IL1Iii(new byte[]{0, 14, 0, 90, 80, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 93, 1, 95, 3, 2}, "bd4f57"))), cls2, Intent.class, String.class, Boolean.TYPE, String.class, Integer.TYPE).invoke(this.f3288IL1Iii, null, intent, intent.getType(), Boolean.FALSE, I1I.IL1Iii.IL1Iii(new byte[]{82, 91, 89, 72, 0, 12, 85, 70, 91, 15, 5, 76, 66, 92, 81, 10, 13}, I1I.IL1Iii.IL1Iii(new byte[]{85, 6, 3, 82, 2, 85}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 14, 6, 5, 5}, "7292f2"))), -2);
            } catch (NoSuchMethodException unused) {
                int i = 12;
                try {
                    byte[] bArr = new byte[12];
                    try {
                        bArr[0] = 64;
                        bArr[1] = 69;
                        bArr[2] = 4;
                        bArr[3] = 67;
                        bArr[4] = 22;
                        bArr[5] = 97;
                        bArr[6] = 86;
                        bArr[7] = 67;
                        bArr[8] = 19;
                        bArr[9] = 88;
                        bArr[10] = 1;
                        bArr[11] = 87;
                        componentName = (ComponentName) cls.getMethod(I1I.IL1Iii.IL1Iii(bArr, I1I.IL1Iii.IL1Iii(new byte[]{1, 8, 6, 0, 82, 81}, I1I.IL1Iii.IL1Iii(new byte[]{3, 91, 1, 84, 86, 80}, "1bbef3"))), cls2, Intent.class, String.class, String.class, Integer.TYPE).invoke(this.f3288IL1Iii, null, intent, intent.getType(), I1I.IL1Iii.IL1Iii(new byte[]{90, 94, 8, 31, 5, 15, 93, 67, 10, 88, 0, 79, 74, 89, 0, 93, 8}, I1I.IL1Iii.IL1Iii(new byte[]{9, 83, 83, 83, 83, 82}, I1I.IL1Iii.IL1Iii(new byte[]{4, 86, 3, 3, 82, 10}, "445ae9"))), -2);
                    } catch (NoSuchMethodException unused2) {
                        i = 12;
                        byte[] bArr2 = new byte[i];
                        bArr2[0] = 16;
                        bArr2[1] = 65;
                        bArr2[2] = 3;
                        bArr2[3] = 69;
                        bArr2[4] = 23;
                        bArr2[5] = 103;
                        bArr2[6] = 6;
                        bArr2[7] = 71;
                        bArr2[8] = 20;
                        bArr2[9] = 94;
                        bArr2[10] = 0;
                        bArr2[11] = 81;
                        componentName = (ComponentName) cls.getMethod(I1I.IL1Iii.IL1Iii(bArr2, I1I.IL1Iii.IL1Iii(new byte[]{82, 81, 1, 3, 82, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 80, 6, 87, 80, 84}, "04eca7"))), cls2, Intent.class, String.class, Integer.TYPE).invoke(this.f3288IL1Iii, null, intent, intent.getType(), -2);
                    }
                } catch (NoSuchMethodException unused3) {
                }
            }
            return (componentName == null || componentName.getPackageName().equals(I1I.IL1Iii.IL1Iii(new byte[]{67}, I1I.IL1Iii.IL1Iii(new byte[]{3, 6, 0, 6, 7, 80}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 0, 7, 8, 81}, "454797")))) || componentName.getPackageName().equals(I1I.IL1Iii.IL1Iii(new byte[]{71, 18}, I1I.IL1Iii.IL1Iii(new byte[]{94, 80, 87, 0, 93, 4}, I1I.IL1Iii.IL1Iii(new byte[]{12, 5, 80, 80, 81, 85}, "4f2543"))))) ? false : true;
        } catch (Exception unused4) {
            return false;
        }
    }
}
