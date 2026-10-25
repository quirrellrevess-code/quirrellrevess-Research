package I1I.p062Ilil.p063IL1Iii.I1I;

import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.lua.LuaNative;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: LuaInvocationHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii implements InvocationHandler {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public int f3435I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public ILil f3436IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f3437ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String f1098IL;

    public IL1Iii(ILil iLil, String str) {
        this.f1098IL = BuildConfig.FLAVOR;
        this.f3436IL1Iii = iLil;
        this.f3437ILil = LuaNative.newthread(iLil.f3439ILil);
        this.f3435I1I = LuaNative.Lref(iLil.f3439ILil, LuaNative.LUA_REGISTRYINDEX);
        iLil.f3439ILil = this.f3437ILil;
        this.f1098IL = str;
        LuaNative.addInvokeHandleRef(this);
    }

    public void IL1Iii() {
        synchronized (this) {
            ILil iLil = this.f3436IL1Iii;
            if (iLil != null) {
                iLil.finalize();
                this.f3436IL1Iii = null;
                LuaNative.LunRef(this.f3437ILil, LuaNative.LUA_REGISTRYINDEX, this.f3435I1I);
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Exception {
        Object objConvertLuaNumber;
        synchronized (this) {
            if (this.f3436IL1Iii == null) {
                return null;
            }
            String name = method.getName();
            if (name.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{11, 84, 68, 95, 119, 87, 7, 80}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 86, 7, 4, 90}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 89, 85, 1, 84}, "1e8e16")))) == 0) {
                return Integer.valueOf(System.identityHashCode(obj));
            }
            if (name.compareTo(I1I.IL1Iii.IL1Iii(new byte[]{76, 87, 102, 68, 16, 13, 86, 95}, I1I.IL1Iii.IL1Iii(new byte[]{12, 94, 86, 7, 7, 82}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 6, 86, 7, 7}, "3beab1")))) == 0) {
                return this.f1098IL + I1I.IL1Iii.IL1Iii(new byte[]{36}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 83, 84, 86, 83}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 6, 80, 3, 15}, "f74539"))) + System.identityHashCode(obj);
            }
            ILil iLilM1241lLi1LL = this.f3436IL1Iii.m1241lLi1LL(name);
            if (iLilM1241lLi1LL.m1232ILl()) {
                return null;
            }
            Object objIL1Iii = null;
            Class<?> returnType = method.getReturnType();
            try {
                if (!returnType.equals(Void.class) && !returnType.equals(Void.TYPE)) {
                    objIL1Iii = iLilM1241lLi1LL.IL1Iii(objArr);
                    if (objIL1Iii != null && (objIL1Iii instanceof Double)) {
                        objConvertLuaNumber = LuaNative.convertLuaNumber((Double) objIL1Iii, returnType);
                    }
                    iLilM1241lLi1LL.finalize();
                    if (objConvertLuaNumber == null || !(returnType.equals(Boolean.TYPE) || returnType.equals(Boolean.class))) {
                        return objConvertLuaNumber;
                    }
                    return Boolean.FALSE;
                }
                iLilM1241lLi1LL.IL1Iii(objArr);
            } catch (Exception e) {
                Log.i(I1I.IL1Iii.IL1Iii(new byte[]{44, 58}, I1I.IL1Iii.IL1Iii(new byte[]{87, 4, 86, 80, 80, 83}, I1I.IL1Iii.IL1Iii(new byte[]{83, 0, 83, 86, 4, 6}, "ff50ee"))), name + " " + e.getMessage());
            }
            objConvertLuaNumber = objIL1Iii;
            iLilM1241lLi1LL.finalize();
            if (objConvertLuaNumber == null) {
            }
            return objConvertLuaNumber;
        }
    }
}
