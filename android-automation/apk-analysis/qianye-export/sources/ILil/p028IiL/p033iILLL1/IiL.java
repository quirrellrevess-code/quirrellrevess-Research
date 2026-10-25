package ILil.p028IiL.p033iILLL1;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: ILil.I丨iL.iI丨LLL1.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: TypefaceCompatApi28Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends iILLL1 {
    @Override // ILil.p028IiL.p033iILLL1.iILLL1
    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public Typeface mo2273Ll1(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f1718iILLL1, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f1719lIiI.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // ILil.p028IiL.p033iILLL1.iILLL1
    public Method llliI(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
