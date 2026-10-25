package I1I.p062Ilil.p063IL1Iii.I1I;

import I1I.IL1Iii;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.lua.LuaNative;
import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: LuaObject.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public int f3438IL1Iii = -1;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public long f3439ILil;

    public ILil(ILil iLil, String str) throws Exception {
        this.f3439ILil = iLil.m1237iILLL1();
        if (!iLil.m1240llL1ii() && !iLil.m1239lIlii()) {
            throw new Exception(IL1Iii.IL1Iii(new byte[]{45, 4, 88, 1, 85, 66, 66, 22, 83, 22, 83, 88, 22, 70, 65, 12, 89, 67, 14, 2, 18, 6, 83, 22, 3, 70, 70, 5, 84, 90, 7, 70, 93, 22, 22, 67, 17, 3, 64, 0, 87, 66, 3, 70, 28}, IL1Iii.IL1Iii(new byte[]{4, 4, 10, 81, 5, 84}, IL1Iii.IL1Iii(new byte[]{85, 4, 12, 0, 87, 7}, "3f45de"))));
        }
        iLil.iIi1();
        LuaNative.pushString(this.f3439ILil, str);
        LuaNative.getTable(this.f3439ILil, -2);
        LuaNative.remove(this.f3439ILil, -2);
        iIlLiL(-1);
        LuaNative.pop(this.f3439ILil, 1);
    }

    public Object I1I(Class cls) throws Exception {
        if (m1240llL1ii()) {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new IL1Iii(this, cls.toString()));
        }
        throw new Exception(IL1Iii.IL1Iii(new byte[]{120, 10, 20, 80, 91, 94, 85, 68, 45, 83, 93, 82, 82, 16, 76, 17, 122, 66, 66, 16, 66, 83, 82, 23, 101, 5, 0, 93, 82, 25}, IL1Iii.IL1Iii(new byte[]{7, 2, 86, 7, 4, 5}, IL1Iii.IL1Iii(new byte[]{83, 86, 12, 84, 81, 2}, "e08bb0"))));
    }

    public Object IL1Iii(Object... objArr) throws Exception {
        return ILil(objArr, 1)[0];
    }

    public boolean ILL() {
        iIi1();
        boolean zIsBoolean = LuaNative.isBoolean(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsBoolean;
    }

    public Object[] ILil(Object[] objArr, int i) throws Exception {
        int i2;
        String string;
        String str;
        if (!m1235Ll1() && !m1240llL1ii() && !m1239lIlii()) {
            throw new Exception(IL1Iii.IL1Iii(new byte[]{121, 86, 71, 88, 90, 15, 84, 24, 94, 91, 92, 3, 83, 76, 31, 25, 120, 9, 68, 24, 80, 25, 80, 19, 94, 91, 69, 80, 89, 8, 28, 24, 69, 88, 84, 10, 85, 24, 94, 75, 22, 19, 67, 93, 67, 93, 87, 18, 81, 24, 31}, IL1Iii.IL1Iii(new byte[]{5, 1, 4, 11, 84, 81}, IL1Iii.IL1Iii(new byte[]{83, 90, 87, 3, 3, 15}, "fcb1a8"))));
        }
        int top = LuaNative.getTop(this.f3439ILil);
        iIi1();
        if (objArr != null) {
            for (Object obj : objArr) {
                LuaNative.pushObjectValue(this.f3439ILil, obj);
            }
        } else {
            i2 = 0;
        }
        int iPcall = LuaNative.pcall(this.f3439ILil, i2, i, 0);
        if (iPcall == 0) {
            if (i == -1) {
                i = LuaNative.getTop(this.f3439ILil) - top;
            }
            if (LuaNative.getTop(this.f3439ILil) - top < i) {
                throw new Exception(IL1Iii.IL1Iii(new byte[]{123, 88, 16, 3, 94, 80, 86, 22, 40, 23, 95, 91, 87, 68, 70, 13, 84, 25, 96, 83, 21, 23, 94, 77, 65, 22, 72}, IL1Iii.IL1Iii(new byte[]{0, 83, 84, 6, 6, 8}, IL1Iii.IL1Iii(new byte[]{83, 6, 81, 2, 82, 6}, "accff7"))));
            }
            Object[] objArr2 = new Object[i];
            while (i > 0) {
                objArr2[i - 1] = LuaNative.toJavaObject(this.f3439ILil, -1);
                LuaNative.pop(this.f3439ILil, 1);
                i--;
            }
            return objArr2;
        }
        if (LuaNative.isString(this.f3439ILil, -1)) {
            string = LuaNative.toString(this.f3439ILil, -1);
            LuaNative.pop(this.f3439ILil, 1);
        } else {
            string = BuildConfig.FLAVOR;
        }
        if (iPcall == 2) {
            str = IL1Iii.IL1Iii(new byte[]{97, 67, 10, 69, 15, 11, 86, 22, 1, 67, 20, 9, 65, 24, 68}, IL1Iii.IL1Iii(new byte[]{4, 85, 86, 80, 86, 86}, IL1Iii.IL1Iii(new byte[]{82, 5, 80, 81, 82, 5}, "efb0b5"))) + string;
        } else if (iPcall == 4) {
            str = IL1Iii.IL1Iii(new byte[]{43, 1, 12, 13, 67, 73, 70, 5, 13, 14, 94, 83, 7, 16, 8, 13, 95, 16, 3, 22, 19, 13, 67, 30, 70}, IL1Iii.IL1Iii(new byte[]{7, 85, 3, 86, 83, 0}, IL1Iii.IL1Iii(new byte[]{86, 2, 4, 85, 90, 3}, "73fa83"))) + string;
        } else if (iPcall == 6) {
            str = IL1Iii.IL1Iii(new byte[]{36, 64, 23, 91, 67, 20, 22, 90, 12, 88, 84, 20, 19, 71, 11, 90, 88, 90, 6, 18, 17, 92, 84, 20, 4, 64, 23, 91, 67, 20, 9, 83, 11, 80, 93, 81, 19, 18, 3, 65, 95, 87, 21, 91, 10, 90, 31, 20}, IL1Iii.IL1Iii(new byte[]{82, 81, 3, 4, 80, 85}, IL1Iii.IL1Iii(new byte[]{3, 87, 84, 4, 86, 4}, "04247e"))) + string;
        } else {
            str = IL1Iii.IL1Iii(new byte[]{42, 20, 3, 18, 114, 66, 20, 14, 16, 18, 84, 95, 2, 4, 66}, IL1Iii.IL1Iii(new byte[]{86, 80, 7, 11, 15, 85}, IL1Iii.IL1Iii(new byte[]{7, 80, 7, 93, 94, 83}, "7abdf6"))) + iPcall + IL1Iii.IL1Iii(new byte[]{23, 19}, IL1Iii.IL1Iii(new byte[]{91, 6, 2, 93, 0, 11}, IL1Iii.IL1Iii(new byte[]{87, 4, 85, 93, 5, 8}, "514e20"))) + string;
        }
        throw new Exception(str);
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public boolean m1232ILl() {
        iIi1();
        boolean zIsNil = LuaNative.isNil(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsNil;
    }

    public boolean Ilil() {
        iIi1();
        boolean z = LuaNative.toBoolean(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return z;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Object m1233IL(String str) throws Exception {
        if (!m1240llL1ii()) {
            throw new Exception(IL1Iii.IL1Iii(new byte[]{123, 13, 19, 81, 90, 91, 86, 67, 42, 82, 92, 87, 81, 23, 75, 16, 123, 71, 65, 23, 69, 82, 83, 18, 102, 2, 7, 92, 83, 28}, IL1Iii.IL1Iii(new byte[]{3, 86, 85, 7, 1, 81}, IL1Iii.IL1Iii(new byte[]{84, 6, 1, 14, 4, 91}, "e31938"))));
        }
        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(str, IL1Iii.IL1Iii(new byte[]{30}, IL1Iii.IL1Iii(new byte[]{7, 85, 82, 81, 90, 7}, IL1Iii.IL1Iii(new byte[]{7, 82, 83, 85, 80, 3}, "2eef3a"))));
        Class[] clsArr = new Class[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreTokens()) {
            clsArr[i] = Class.forName(stringTokenizer.nextToken());
            i++;
        }
        return Proxy.newProxyInstance(ILil.class.getClassLoader(), clsArr, new IL1Iii(this, str));
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public double m1234IiL() {
        iIi1();
        double number = LuaNative.toNumber(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return number;
    }

    public boolean Lil() {
        iIi1();
        boolean zIsNumber = LuaNative.isNumber(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsNumber;
    }

    public boolean LlLI1() {
        iIi1();
        boolean zIsString = LuaNative.isString(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsString;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public boolean m1235Ll1() {
        iIi1();
        boolean zIsFunction = LuaNative.isFunction(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsFunction;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public Object m1236L11I() throws Exception {
        iIi1();
        Object objectFromUserdata = LuaNative.getObjectFromUserdata(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return objectFromUserdata;
    }

    public synchronized void finalize() {
        int i;
        try {
            if (this.f3439ILil != 0 && (i = this.f3438IL1Iii) >= 0) {
                LuaNative.unRef(this, LuaNative.LUA_REGISTRYINDEX, i);
                this.f3438IL1Iii = -1;
            }
        } catch (Exception unused) {
            System.err.println(IL1Iii.IL1Iii(new byte[]{54, 90, 5, 84, 94, 0, 67, 64, 11, 22, 64, 0, 15, 81, 5, 69, 87, 69, 12, 86, 14, 83, 81, 17, 67}, IL1Iii.IL1Iii(new byte[]{86, 5, 6, 85, 10, 81}, IL1Iii.IL1Iii(new byte[]{7, 6, 80, 7, 93, 12}, "272de8"))) + this.f3438IL1Iii);
        }
    }

    public void iIi1() {
        LuaNative.rawGetI(this.f3439ILil, LuaNative.LUA_REGISTRYINDEX, this.f3438IL1Iii);
    }

    public void iIlLiL(int i) {
        LuaNative.pushValue(this.f3439ILil, i);
        this.f3438IL1Iii = LuaNative.ref(this, LuaNative.LUA_REGISTRYINDEX);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public long m1237iILLL1() {
        return this.f3439ILil;
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public boolean m1238lIiI() {
        iIi1();
        boolean zIsObject = LuaNative.isObject(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsObject;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean m1239lIlii() {
        iIi1();
        boolean zIsUserdata = LuaNative.isUserdata(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsUserdata;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public boolean m1240llL1ii() {
        iIi1();
        boolean zIsTable = LuaNative.isTable(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return zIsTable;
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public ILil m1241lLi1LL(String str) throws Exception {
        return LuaNative.getLuaObject(this, str);
    }

    public String toString() {
        try {
            if (m1232ILl()) {
                return IL1Iii.IL1Iii(new byte[]{10, 91, 14}, IL1Iii.IL1Iii(new byte[]{81, 0, 7, 83, 9, 83}, IL1Iii.IL1Iii(new byte[]{7, 3, 82, 85, 7, 2}, "21777d")));
            }
            if (ILL()) {
                return String.valueOf(Ilil());
            }
            if (Lil()) {
                return String.valueOf(m1234IiL());
            }
            if (LlLI1()) {
                return m1242il();
            }
            if (m1235Ll1()) {
                return IL1Iii.IL1Iii(new byte[]{40, 65, 89, 24, 35, 67, 10, 87, 76, 81, 10, 88}, IL1Iii.IL1Iii(new byte[]{5, 4, 13, 92, 92, 84}, IL1Iii.IL1Iii(new byte[]{7, 81, 3, 82, 91, 87}, "fa66b5")));
            }
            if (m1238lIiI()) {
                return m1236L11I().toString();
            }
            if (m1239lIlii()) {
                return IL1Iii.IL1Iii(new byte[]{98, 69, 84, 64, 86, 4, 67, 87}, IL1Iii.IL1Iii(new byte[]{0, 4, 4, 81, 83, 82}, IL1Iii.IL1Iii(new byte[]{6, 10, 87, 90, 5, 85}, "18b9db")));
            }
            if (m1240llL1ii()) {
                return IL1Iii.IL1Iii(new byte[]{122, 64, 7, 23, 101, 2, 84, 89, 3}, IL1Iii.IL1Iii(new byte[]{0, 4, 7, 4, 3, 2}, IL1Iii.IL1Iii(new byte[]{3, 1, 83, 3, 5, 4}, "50207e")));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public String m1242il() {
        iIi1();
        String string = LuaNative.toString(this.f3439ILil, -1);
        LuaNative.pop(this.f3439ILil, 1);
        return string;
    }

    public ILil(long j, int i) {
        this.f3439ILil = j;
        iIlLiL(i);
    }
}
