package com.p000nx.assist.lua;

import I1I.I1I.p008IL.lIlii;
import I1I.p062Ilil.p063IL1Iii.I1I.IL1Iii;
import I1I.p062Ilil.p063IL1Iii.I1I.ILil;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LuaNative {
    public static final int LUAI_MAXSTACK = 1000000;
    public static final int LUA_ERRERR = 6;
    public static final int LUA_ERRGCMM = 5;
    public static final int LUA_ERRMEM = 4;
    public static final int LUA_ERRRUN = 2;
    public static final int LUA_MULTRET = -1;
    public static final int LUA_REGISTRYINDEX = -1001000;
    public static final int LUA_TBOOLEAN = 1;
    public static final int LUA_TFUNCTION = 6;
    public static final int LUA_TLIGHTUSERDATA = 2;
    public static final int LUA_TNIL = 0;
    public static final int LUA_TNONE = -1;
    public static final int LUA_TNUMBER = 3;
    public static final int LUA_TSTRING = 4;
    public static final int LUA_TTABLE = 5;
    public static final int LUA_TTHREAD = 8;
    public static final int LUA_TUSERDATA = 7;
    public static Map<ILil, Integer> mRefList = new HashMap();
    public static Map<IL1Iii, Long> mInvokeList = new HashMap();
    public static Map<String, ArrayList<Method>> mMethodCache = new Hashtable();

    public static native int Lref(long j, int i);

    public static native void LunRef(long j, int i, int i2);

    public static void addInvokeHandleRef(IL1Iii iL1Iii) {
        synchronized (mInvokeList) {
            mInvokeList.put(iL1Iii, 1L);
        }
    }

    public static int callMethod(long j, Object obj, String str) throws Exception {
        boolean z;
        int top = getTop(j);
        Object[] objArr = new Object[top];
        Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append(I1I.IL1Iii.IL1Iii(new byte[]{68}, I1I.IL1Iii.IL1Iii(new byte[]{87, 81, 86, 83, 14, 86}, I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 82, 4, 12, 84}, "5a7a4d"))));
        sb.append(str);
        ArrayList<Method> arrayList = mMethodCache.get(sb.toString());
        Method method = null;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                Class<?>[] parameterTypes = arrayList.get(i).getParameterTypes();
                if (parameterTypes.length == top) {
                    int i2 = 0;
                    while (i2 < parameterTypes.length) {
                        try {
                            int i3 = i2 + 1;
                            objArr[i2] = compareTypes(j, parameterTypes[i2], i3);
                            i2 = i3;
                        } catch (Exception unused) {
                            z = false;
                        }
                    }
                    z = true;
                    if (z) {
                        method = arrayList.get(i);
                        break;
                    }
                }
            }
        }
        if (method == null) {
            StringBuilder sb2 = new StringBuilder();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                sb2.append(arrayList.get(i4).toString());
                sb2.append("\n");
            }
            throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{124, 86, 66, 0, 9, 10, 81, 24, 89, 4, 17, 11, 90, 92, 20, 2, 4, 15, 89, 22, 20, 40, 11, 21, 84, 84, 93, 5, 69, 51, 84, 74, 85, 12, 0, 23, 80, 74, 71, 79, 111}, I1I.IL1Iii.IL1Iii(new byte[]{80, 11, 86, 7, 82, 5}, I1I.IL1Iii.IL1Iii(new byte[]{84, 7, 80, 3, 86, 83}, "142ea5"))) + sb2.toString());
        }
        try {
            if (!Modifier.isPublic(method.getModifiers())) {
                method.setAccessible(true);
            }
            Object objInvoke = method.invoke(obj, objArr);
            if (objInvoke == null && method.getReturnType().equals(Void.TYPE)) {
                return 0;
            }
            return pushObjectValue(j, objInvoke);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int checkClass(long j, Object obj, String str) {
        if (obj instanceof Class) {
            Class<?>[] classes = ((Class) obj).getClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getSimpleName().equals(str)) {
                    return pushJavaObject(j, classes[i]);
                }
            }
        }
        return 0;
    }

    public static int checkField(long j, Object obj, String str) {
        try {
            Field field = (obj instanceof Class ? (Class) obj : obj.getClass()).getField(str);
            if (field == null) {
                return 0;
            }
            return pushObjectValue(j, field.get(obj));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int checkMethod(long j, Object obj, String str) {
        try {
            Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
            String str2 = cls.toString() + I1I.IL1Iii.IL1Iii(new byte[]{68}, I1I.IL1Iii.IL1Iii(new byte[]{82, 2, 84, 80, 3, 1}, I1I.IL1Iii.IL1Iii(new byte[]{3, 1, 1, 87, 90, 2}, "33b584"))) + str;
            if (mMethodCache.get(str2) == null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                HashMap map = new HashMap();
                ArrayList<Method> arrayList = new ArrayList<>();
                for (int i = 0; i < declaredMethods.length; i++) {
                    if (declaredMethods[i].getName().equals(str)) {
                        declaredMethods[i].setAccessible(true);
                        arrayList.add(declaredMethods[i]);
                        map.put(declaredMethods[i], 1);
                    }
                }
                Method[] methods = cls.getMethods();
                for (int i2 = 0; i2 < methods.length; i2++) {
                    if (methods[i2].getName().equals(str) && !map.containsKey(methods[i2])) {
                        methods[i2].setAccessible(true);
                        arrayList.add(methods[i2]);
                    }
                }
                if (arrayList.size() > 0) {
                    mMethodCache.put(str2, arrayList);
                }
                return 0;
            }
            return 1;
        } catch (Exception unused) {
        }
    }

    public static void clear(long j) {
        synchronized (mInvokeList) {
            Iterator<Map.Entry<IL1Iii, Long>> it = mInvokeList.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().IL1Iii();
            }
            mInvokeList.clear();
        }
        synchronized (mRefList) {
            Iterator<Map.Entry<ILil, Integer>> it2 = mRefList.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getKey().finalize();
            }
            mRefList.clear();
        }
        mMethodCache.clear();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0098 A[PHI: r1
  0x0098: PHI (r1v4 java.lang.Object) = (r1v3 java.lang.Object), (r1v0 java.lang.Object), (r1v0 java.lang.Object), (r1v0 java.lang.Object) binds: [B:44:0x00c1, B:36:0x0096, B:33:0x0089, B:21:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    private static Object compareTypes(long j, Class<?> cls, int i) throws Exception {
        int iLuaType = luaType(j, i);
        Object objValueOf = null;
        boolean z = true;
        if (iLuaType != 0) {
            if (iLuaType == 1) {
                if (!cls.isPrimitive() ? !cls.isAssignableFrom(Boolean.class) : cls != Boolean.TYPE) {
                    z = false;
                }
                objValueOf = Boolean.valueOf(toBoolean(j, i));
            } else if (iLuaType == 3) {
                objValueOf = isInteger(j, i) ? convertLuaNumber(new Long(toInteger(j, i)), cls) : convertLuaNumber(new Double(toNumber(j, i)), cls);
                if (objValueOf == null) {
                    z = false;
                }
            } else if (iLuaType != 4) {
                if (iLuaType != 5) {
                    if (iLuaType != 7) {
                        throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{125, 11, 68, 88, 94, 80, 80, 69, 98, 88, 64, 88, 89, 0, 70, 92, 64, 74, 26}, I1I.IL1Iii.IL1Iii(new byte[]{85, 93, 4, 0, 86, 88}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 0, 14, 6, 2}, "d967bc"))));
                    }
                    if (isObject(j, i)) {
                        Object objectFromUserdata = getObjectFromUserdata(j, i);
                        if ((cls.isPrimitive() && Number.class.isAssignableFrom(objectFromUserdata.getClass())) || cls.isAssignableFrom(objectFromUserdata.getClass())) {
                            objValueOf = objectFromUserdata;
                        } else {
                            z = false;
                        }
                    }
                } else if (cls.isArray()) {
                    objValueOf = createArray(j, cls.getComponentType(), i);
                } else if (Map.class.isAssignableFrom(cls)) {
                    objValueOf = createMap(j, cls, i);
                } else if (cls.isInterface()) {
                    objValueOf = createProxyObject(j, cls, i);
                } else {
                    z = false;
                }
            } else if (cls.isAssignableFrom(String.class)) {
                objValueOf = toString(j, i);
            } else {
                z = false;
            }
        }
        if (z) {
            return objValueOf;
        }
        throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{42, 86, 65, 3, 89, 11, 7, 24, 103, 3, 71, 3, 14, 93, 67, 7, 71, 76}, I1I.IL1Iii.IL1Iii(new byte[]{83, 9, 1, 86, 80, 86}, I1I.IL1Iii.IL1Iii(new byte[]{4, 83, 15, 86, 0, 5}, "4b9be1"))));
    }

    public static Number convertLuaNumber(Double d, Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(d.intValue());
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(d.longValue());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(d.floatValue());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(d.doubleValue());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(d.byteValue());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(d.shortValue());
            }
            return null;
        }
        if (!cls.isAssignableFrom(Number.class)) {
            return null;
        }
        if (cls.isAssignableFrom(Integer.class)) {
            return new Integer(d.intValue());
        }
        if (cls.isAssignableFrom(Long.class)) {
            return new Long(d.longValue());
        }
        if (cls.isAssignableFrom(Float.class)) {
            return new Float(d.floatValue());
        }
        if (cls.isAssignableFrom(Double.class)) {
            return d;
        }
        if (cls.isAssignableFrom(Byte.class)) {
            return new Byte(d.byteValue());
        }
        if (cls.isAssignableFrom(Short.class)) {
            return new Short(d.shortValue());
        }
        return null;
    }

    private static int createArray(long j, Class cls) throws Exception {
        pushJavaObject(j, createArray(j, cls, 2));
        return 1;
    }

    private static int createList(long j, Class<?> cls) throws Exception {
        pushJavaObject(j, createList(j, cls, 2));
        return 1;
    }

    private static Object createMap(long j, Class<?> cls, int i) throws Exception {
        try {
            if (cls.equals(Map.class)) {
                cls = HashMap.class;
            }
            Map map = (Map) cls.newInstance();
            pushNil(j);
            while (next(j, i) != 0) {
                map.put(toJavaObject(j, -2), toJavaObject(j, -1));
                pop(j, 1);
            }
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    private static Object createProxyObject(long j, Class cls, int i) throws Exception {
        try {
            return getLuaObject(j, Integer.valueOf(i)).I1I(cls);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int getArrayValue(long j, Object obj, int i) throws Exception {
        Object obj2;
        if (obj.getClass().isArray()) {
            obj2 = Array.get(obj, i);
        } else if (obj instanceof List) {
            obj2 = ((List) obj).get(i);
        } else {
            if (!(obj instanceof Map)) {
                throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{2, 0, 92, 22, 88, 9, 21, 65, 85, 83, 66, 70}, I1I.IL1Iii.IL1Iii(new byte[]{81, 2, 4, 5, 5, 2}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 14, 85, 0, 85}, "048f31"))) + obj.getClass().getName() + I1I.IL1Iii.IL1Iii(new byte[]{65, 65, 89, 84, 71, 7, 65, 94, 86, 24}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 10, 91, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{0, 5, 3, 85, 82, 10}, "af16a9"))) + i);
            }
            obj2 = ((Map) obj).get(Integer.valueOf(i));
        }
        pushObjectValue(j, obj2);
        return 1;
    }

    public static Context getContext() {
        return lIlii.m17i1();
    }

    public static native int getGlobal(long j, String str);

    public static ILil getLuaObject(ILil iLil, String str) throws Exception {
        return new ILil(iLil, str);
    }

    private static int getObjInstance(long j, Class<?> cls) throws Exception {
        boolean z;
        int top = getTop(j);
        if (top == 1) {
            try {
                pushJavaObject(j, cls.newInstance());
                return 1;
            } catch (Exception unused) {
                if (View.class.isAssignableFrom(cls)) {
                    try {
                        pushJavaObject(j, cls.getConstructor(Context.class).newInstance(getContext()));
                        return 1;
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        int i = top - 1;
        Object[] objArr = new Object[i];
        Constructor<?>[] constructors = cls.getConstructors();
        Constructor<?> constructor = null;
        for (int i2 = 0; i2 < constructors.length; i2++) {
            Class<?>[] parameterTypes = constructors[i2].getParameterTypes();
            if (parameterTypes.length == i) {
                for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                    try {
                        objArr[i3] = compareTypes(j, parameterTypes[i3], i3 + 2);
                    } catch (Exception unused3) {
                        z = false;
                    }
                }
                z = true;
                if (z) {
                    constructor = constructors[i2];
                    break;
                }
            }
        }
        if (constructor != null) {
            try {
                Object objNewInstance = constructor.newInstance(objArr);
                if (objNewInstance == null) {
                    throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{116, 11, 17, 13, 0, 92, 16, 16, 68, 8, 10, 65, 67, 5, 10, 21, 13, 83, 67, 1, 68, 11, 5, 68, 86, 68, 43, 3, 14, 87, 84, 16}, I1I.IL1Iii.IL1Iii(new byte[]{1, 7, 7, 82, 86, 87}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 82, 6, 80, 93}, "3315b8"))));
                }
                pushJavaObject(j, objNewInstance);
                return 1;
            } catch (Exception e) {
                throw e;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Constructor<?> constructor2 : constructors) {
            sb.append(constructor2.toString());
            sb.append("\n");
        }
        throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{121, 11, 23, 87, 14, 90, 84, 69, 2, 89, 12, 64, 68, 23, 20, 85, 22, 92, 66, 69, 12, 83, 22, 91, 95, 1, 65, 85, 3, 95, 92, 75, 65, 127, 12, 69, 81, 9, 8, 82, 66, 99, 81, 23, 0, 91, 7, 71, 85, 23, 18, 24, 104}, I1I.IL1Iii.IL1Iii(new byte[]{1, 83, 88, 6, 81, 10}, I1I.IL1Iii.IL1Iii(new byte[]{83, 4, 88, 85, 2, 93}, "b2ae1d"))) + sb.toString());
    }

    public static native Object getObjectFromUserdata(long j, int i);

    public static int getObjectString(long j, Object obj) {
        pushObjectValue(j, obj.toString());
        return 1;
    }

    public static native int getTable(long j, int i);

    public static native int getTop(long j);

    public static native boolean isBoolean(long j, int i);

    public static native boolean isFunction(long j, int i);

    public static native boolean isInteger(long j, int i);

    public static native boolean isNil(long j, int i);

    public static native boolean isNumber(long j, int i);

    public static native boolean isObject(long j, int i);

    public static native boolean isString(long j, int i);

    public static native boolean isTable(long j, int i);

    public static native boolean isUserdata(long j, int i);

    public static int javaCreate(long j, Class<?> cls) throws Exception {
        if (cls.isInterface()) {
            return createProxyObject(j, cls);
        }
        if (List.class.isAssignableFrom(cls)) {
            return createList(j, cls);
        }
        return Map.class.isAssignableFrom(cls) ? createMap(j, cls) : createArray(j, cls);
    }

    public static int javaNew(long j, Class cls) throws Exception {
        return cls.isPrimitive() ? toPrimitive(j, cls, -1) : getObjInstance(j, cls);
    }

    public static int javaSetter(long j, Object obj, String str) throws Exception {
        return 0;
    }

    public static native int luaType(long j, int i);

    public static int newArray(long j, Class<?> cls, int i) throws Exception {
        try {
            pushJavaObject(j, Array.newInstance(cls, i));
            return 1;
        } catch (Exception e) {
            throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{2, 81, 8, 68, 87, 90, 21, 16, 5, 22, 92, 84, 21, 85, 70, 5, 25, 84, 19, 66, 7, 29, 3, 21}, I1I.IL1Iii.IL1Iii(new byte[]{88, 8, 7, 83, 13, 0}, I1I.IL1Iii.IL1Iii(new byte[]{91, 89, 0, 85, 4, 2}, "baab07"))) + e.getMessage());
        }
    }

    public static native void newtable(long j);

    public static native long newthread(long j);

    public static native int next(long j, int i);

    public static native int objLen(long j, int i);

    public static int objectIndex(long j, Object obj, String str) {
        if (checkField(j, obj, str) != 0) {
            return 1;
        }
        if (checkMethod(j, obj, str) != 0) {
            return 2;
        }
        return checkClass(j, obj, str) != 0 ? 1 : 0;
    }

    public static int objectNewIndex(long j, Object obj, String str) throws Exception {
        return (setFieldValue(j, obj, str) == 0 && javaSetter(j, obj, str) == 0) ? 0 : 1;
    }

    public static native int pcall(long j, int i, int i2, int i3);

    public static native void pop(long j, int i);

    public static native int pushBoolean(long j, boolean z);

    public static native int pushInteger(long j, long j2);

    public static native int pushJavaObject(long j, Object obj);

    public static native void pushNil(long j);

    public static native int pushNumber(long j, double d);

    public static int pushObjectValue(long j, Object obj) {
        if (obj == null) {
            pushNil(j);
            return 1;
        }
        if (obj instanceof Boolean) {
            pushBoolean(j, ((Boolean) obj).booleanValue());
            return 1;
        }
        if (obj instanceof Long) {
            pushInteger(j, ((Long) obj).longValue());
            return 1;
        }
        if (obj instanceof Integer) {
            pushInteger(j, ((Integer) obj).intValue());
            return 1;
        }
        if (obj instanceof Short) {
            pushInteger(j, ((Short) obj).shortValue());
            return 1;
        }
        if (obj instanceof Byte) {
            pushInteger(j, ((Byte) obj).byteValue());
            return 1;
        }
        if (obj instanceof Number) {
            pushNumber(j, ((Number) obj).doubleValue());
            return 1;
        }
        if (obj instanceof String) {
            pushString(j, (String) obj);
            return 1;
        }
        pushJavaObject(j, obj);
        return 1;
    }

    public static native int pushString(long j, String str);

    public static native void pushValue(long j, int i);

    public static native int rawGet(long j, int i);

    public static native int rawGetI(long j, int i, long j2);

    public static native void rawSet(long j, int i);

    public static int ref(ILil iLil, int i) {
        int iLref;
        synchronized (mRefList) {
            iLref = Lref(iLil.f3439ILil, i);
            if (iLref >= 0) {
                mRefList.put(iLil, Integer.valueOf(iLref));
            }
        }
        return iLref;
    }

    public static native void remove(long j, int i);

    public static int setArrayValue(long j, Object obj, int i) throws Exception {
        if (obj.getClass().isArray()) {
            try {
                Array.set(obj, i, compareTypes(j, obj.getClass().getComponentType(), 3));
                return 0;
            } catch (Exception e) {
                throw e;
            }
        }
        if (obj instanceof List) {
            ((List) obj).set(i, toJavaObject(j, 3));
            return 0;
        }
        if (obj instanceof Map) {
            ((Map) obj).put(Integer.valueOf(i), toJavaObject(j, 3));
            return 0;
        }
        throw new Exception(I1I.IL1Iii.IL1Iii(new byte[]{5, 7, 13, 17, 91, 10, 18, 70, 16, 84, 65, 69}, I1I.IL1Iii.IL1Iii(new byte[]{7, 7, 81, 84, 81, 83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 87, 2, 81, 6, 80}, "4604bf"))) + obj.getClass().getName() + I1I.IL1Iii.IL1Iii(new byte[]{19, 78, 89, 89, 23, 3, 9, 24}, I1I.IL1Iii.IL1Iii(new byte[]{82, 90, 11, 86, 87, 95}, I1I.IL1Iii.IL1Iii(new byte[]{7, 86, 11, 84, 2, 10}, "f48773"))) + toJavaObject(j, 3) + I1I.IL1Iii.IL1Iii(new byte[]{16, 91, 90, 65}, I1I.IL1Iii.IL1Iii(new byte[]{7, 3, 2, 88, 4, 93}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 84, 93, 81, 9}, "c2bda1"))) + i);
    }

    public static native void setField(long j, int i, String str);

    public static int setFieldValue(long j, Object obj, String str) throws Exception {
        Class<?> cls;
        boolean z;
        Field declaredField;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
            z = true;
        } else {
            cls = obj.getClass();
            z = false;
        }
        try {
            try {
                declaredField = cls.getField(str);
            } catch (Exception unused) {
                return 0;
            }
        } catch (NoSuchFieldException unused2) {
            declaredField = cls.getDeclaredField(str);
        }
        if (declaredField == null) {
            return 0;
        }
        if (z && !Modifier.isStatic(declaredField.getModifiers())) {
            return 0;
        }
        Class<?> type = declaredField.getType();
        try {
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            declaredField.set(obj, compareTypes(j, type, 3));
            return 1;
        } catch (Exception e) {
            throw e;
        }
    }

    public static native void setGlobal(long j, String str);

    public static native void setTable(long j, int i);

    public static native Bitmap snapShotJava(int i, int i2, int i3, int i4);

    public static native boolean toBoolean(long j, int i);

    public static native long toInteger(long j, int i);

    public static Object toJavaObject(long j, int i) throws Exception {
        if (isBoolean(j, i)) {
            return Boolean.valueOf(toBoolean(j, i));
        }
        if (luaType(j, i) == 4) {
            return toString(j, i);
        }
        if (isFunction(j, i)) {
            return getLuaObject(j, Integer.valueOf(i));
        }
        if (isTable(j, i)) {
            return getLuaObject(j, Integer.valueOf(i));
        }
        if (luaType(j, i) == 3) {
            return isInteger(j, i) ? Long.valueOf(toInteger(j, i)) : Double.valueOf(toNumber(j, i));
        }
        if (isUserdata(j, i)) {
            return isObject(j, i) ? getObjectFromUserdata(j, i) : getLuaObject(j, Integer.valueOf(i));
        }
        isNil(j, i);
        return null;
    }

    public static native double toNumber(long j, int i);

    private static int toPrimitive(long j, Class cls, int i) throws Exception {
        Object objValueOf;
        if (cls == Character.TYPE && isString(j, i)) {
            String string = toString(j, i);
            objValueOf = string.length() == 1 ? Character.valueOf(string.charAt(0)) : string.toCharArray();
        } else {
            if (!isNumber(j, i)) {
                throw new Exception(toString(j, i) + I1I.IL1Iii.IL1Iii(new byte[]{67, 8, 66, 17, 93, 87, 23, 65, 95, 68, 94, 90, 6, 19}, I1I.IL1Iii.IL1Iii(new byte[]{81, 4, 84, 84, 82, 15}, I1I.IL1Iii.IL1Iii(new byte[]{86, 6, 93, 83, 86, 3}, "dc8674"))));
            }
            if (cls == Double.TYPE) {
                objValueOf = Double.valueOf(toNumber(j, i));
            } else if (cls == Float.TYPE) {
                objValueOf = Float.valueOf((float) toNumber(j, i));
            } else if (cls == Long.TYPE) {
                objValueOf = Long.valueOf(toInteger(j, i));
            } else if (cls == Integer.TYPE) {
                objValueOf = Integer.valueOf((int) toInteger(j, i));
            } else if (cls == Short.TYPE) {
                objValueOf = Short.valueOf((short) toInteger(j, i));
            } else if (cls == Character.TYPE) {
                objValueOf = Character.valueOf((char) toInteger(j, i));
            } else if (cls == Byte.TYPE) {
                objValueOf = Byte.valueOf((byte) toInteger(j, i));
            } else {
                objValueOf = cls == Boolean.TYPE ? Boolean.valueOf(toBoolean(j, i)) : null;
            }
        }
        pushJavaObject(j, objValueOf);
        return 1;
    }

    public static native String toString(long j, int i);

    public static void unRef(ILil iLil, int i, int i2) {
        synchronized (mRefList) {
            if (mRefList.get(iLil) != null) {
                LunRef(iLil.f3439ILil, i, i2);
                mRefList.remove(iLil);
            }
        }
    }

    private static Object createArray(long j, Class<?> cls, int i) throws Exception {
        try {
            int iObjLen = objLen(j, i);
            Object objNewInstance = Array.newInstance(cls, iObjLen);
            if (cls == String.class) {
                for (int i2 = 1; i2 <= iObjLen; i2++) {
                    pushNumber(j, i2);
                    getTable(j, i);
                    Array.set(objNewInstance, i2 - 1, toString(j, -1));
                    pop(j, 1);
                }
            } else if (cls == Double.TYPE) {
                for (int i3 = 1; i3 <= iObjLen; i3++) {
                    pushNumber(j, i3);
                    getTable(j, i);
                    Array.set(objNewInstance, i3 - 1, Double.valueOf(toNumber(j, -1)));
                    pop(j, 1);
                }
            } else if (cls == Float.TYPE) {
                for (int i4 = 1; i4 <= iObjLen; i4++) {
                    pushNumber(j, i4);
                    getTable(j, i);
                    Array.set(objNewInstance, i4 - 1, Float.valueOf((float) toNumber(j, -1)));
                    pop(j, 1);
                }
            } else if (cls == Long.TYPE) {
                for (int i5 = 1; i5 <= iObjLen; i5++) {
                    pushNumber(j, i5);
                    getTable(j, i);
                    Array.set(objNewInstance, i5 - 1, Long.valueOf(toInteger(j, -1)));
                    pop(j, 1);
                }
            } else if (cls == Integer.TYPE) {
                for (int i6 = 1; i6 <= iObjLen; i6++) {
                    pushNumber(j, i6);
                    getTable(j, i);
                    Array.set(objNewInstance, i6 - 1, Integer.valueOf((int) toInteger(j, -1)));
                    pop(j, 1);
                }
            } else if (cls == Short.TYPE) {
                for (int i7 = 1; i7 <= iObjLen; i7++) {
                    pushNumber(j, i7);
                    getTable(j, i);
                    Array.set(objNewInstance, i7 - 1, Short.valueOf((short) toInteger(j, -1)));
                    pop(j, 1);
                }
            } else if (cls == Character.TYPE) {
                for (int i8 = 1; i8 <= iObjLen; i8++) {
                    pushNumber(j, i8);
                    getTable(j, i);
                    Array.set(objNewInstance, i8 - 1, Character.valueOf((char) toInteger(j, -1)));
                    pop(j, 1);
                }
            } else if (cls == Byte.TYPE) {
                for (int i9 = 1; i9 <= iObjLen; i9++) {
                    pushNumber(j, i9);
                    getTable(j, i);
                    Array.set(objNewInstance, i9 - 1, Byte.valueOf((byte) toInteger(j, -1)));
                    pop(j, 1);
                }
            } else {
                for (int i10 = 1; i10 <= iObjLen; i10++) {
                    pushNumber(j, i10);
                    getTable(j, i);
                    Array.set(objNewInstance, i10 - 1, compareTypes(j, cls, -1));
                    pop(j, 1);
                }
            }
            return objNewInstance;
        } catch (Exception e) {
            throw e;
        }
    }

    private static Object createList(long j, Class<?> cls, int i) throws Exception {
        int iObjLen = objLen(j, i);
        try {
            if (cls.equals(List.class)) {
                cls = ArrayList.class;
            }
            List list = (List) cls.newInstance();
            for (int i2 = 1; i2 <= iObjLen; i2++) {
                pushNumber(j, i2);
                getTable(j, i);
                list.add(toJavaObject(j, -1));
                pop(j, 1);
            }
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ILil getLuaObject(long j, Number number) throws Exception {
        return new ILil(j, number.intValue());
    }

    private static int createProxyObject(long j, String str) throws Exception {
        try {
            pushJavaObject(j, getLuaObject(j, (Number) 2).m1233IL(str));
            return 1;
        } catch (Exception e) {
            throw e;
        }
    }

    private static int createMap(long j, Class<?> cls) throws Exception {
        pushJavaObject(j, createMap(j, cls, 2));
        return 1;
    }

    private static int createProxyObject(long j, Class cls) throws Exception {
        pushJavaObject(j, createProxyObject(j, cls, 2));
        return 1;
    }

    public static Number convertLuaNumber(Long l, Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(l.intValue());
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(l.longValue());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(l.floatValue());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(l.doubleValue());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(l.byteValue());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(l.shortValue());
            }
            return null;
        }
        if (!cls.isAssignableFrom(Number.class)) {
            return null;
        }
        if (cls.isAssignableFrom(Integer.class)) {
            return new Integer(l.intValue());
        }
        if (cls.isAssignableFrom(Long.class)) {
            return new Long(l.longValue());
        }
        if (cls.isAssignableFrom(Float.class)) {
            return new Float(l.floatValue());
        }
        if (cls.isAssignableFrom(Double.class)) {
            return l;
        }
        if (cls.isAssignableFrom(Byte.class)) {
            return new Byte(l.byteValue());
        }
        if (cls.isAssignableFrom(Short.class)) {
            return new Short(l.shortValue());
        }
        return null;
    }
}
