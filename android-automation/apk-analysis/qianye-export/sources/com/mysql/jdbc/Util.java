package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    private static final String MYSQL_JDBC_PACKAGE_ROOT;
    private static Util enclosingInstance = new Util();
    private static final ConcurrentMap<Class<?>, Class<?>[]> implementedInterfacesCache;
    private static boolean isColdFusion;
    private static boolean isJdbc4;
    private static boolean isJdbc42;
    private static final ConcurrentMap<Class<?>, Boolean> isJdbcInterfaceCache;
    private static int jvmUpdateNumber;
    private static int jvmVersion;

    public class RandStructcture {
        public long maxValue;
        public double maxValueDbl;
        public long seed1;
        public long seed2;

        public RandStructcture() {
        }
    }

    static {
        int i;
        int i2;
        int i3;
        jvmVersion = -1;
        jvmUpdateNumber = -1;
        isColdFusion = false;
        try {
            Class.forName("java.sql.NClob");
            isJdbc4 = true;
        } catch (ClassNotFoundException unused) {
            isJdbc4 = false;
        }
        try {
            Class.forName("java.sql.JDBCType");
            isJdbc42 = true;
        } catch (Throwable unused2) {
            isJdbc42 = false;
        }
        String property = System.getProperty("java.version");
        int iIndexOf = property.indexOf(46);
        int i4 = iIndexOf + 1;
        if (iIndexOf != -1) {
            i = i4;
            while (Character.isDigit(property.charAt(i)) && (i = i + 1) < property.length()) {
            }
        } else {
            i = i4;
        }
        if (i > i4) {
            jvmVersion = Integer.parseInt(property.substring(i4, i));
        } else {
            if (isJdbc42) {
                i2 = 8;
            } else {
                i2 = isJdbc4 ? 6 : 5;
            }
            jvmVersion = i2;
        }
        int iIndexOf2 = property.indexOf("_");
        int i5 = iIndexOf2 + 1;
        if (iIndexOf2 != -1) {
            i3 = i5;
            while (Character.isDigit(property.charAt(i3)) && (i3 = i3 + 1) < property.length()) {
            }
        } else {
            i3 = i5;
        }
        if (i3 > i5) {
            jvmUpdateNumber = Integer.parseInt(property.substring(i5, i3));
        }
        String strStackTraceToString = stackTraceToString(new Throwable());
        if (strStackTraceToString != null) {
            isColdFusion = strStackTraceToString.indexOf("coldfusion") != -1;
        } else {
            isColdFusion = false;
        }
        isJdbcInterfaceCache = new ConcurrentHashMap();
        String packageName = getPackageName(MultiHostConnectionProxy.class);
        MYSQL_JDBC_PACKAGE_ROOT = packageName.substring(0, packageName.indexOf("jdbc") + 4);
        implementedInterfacesCache = new ConcurrentHashMap();
    }

    public static Map<Object, Object> calculateDifferences(Map<?, ?> map, Map<?, ?> map2) {
        Number number;
        Number d;
        HashMap map3 = new HashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (entry.getValue() instanceof Number) {
                number = (Number) entry.getValue();
                d = (Number) map2.get(key);
            } else {
                try {
                    Double d2 = new Double(entry.getValue().toString());
                    d = new Double(map2.get(key).toString());
                    number = d2;
                } catch (NumberFormatException unused) {
                }
            }
            if (!number.equals(d)) {
                if (number instanceof Byte) {
                    map3.put(key, Byte.valueOf((byte) (((Byte) d).byteValue() - ((Byte) number).byteValue())));
                } else if (number instanceof Short) {
                    map3.put(key, Short.valueOf((short) (((Short) d).shortValue() - ((Short) number).shortValue())));
                } else if (number instanceof Integer) {
                    map3.put(key, Integer.valueOf(((Integer) d).intValue() - ((Integer) number).intValue()));
                } else if (number instanceof Long) {
                    map3.put(key, Long.valueOf(((Long) d).longValue() - ((Long) number).longValue()));
                } else if (number instanceof Float) {
                    map3.put(key, Float.valueOf(((Float) d).floatValue() - ((Float) number).floatValue()));
                } else if (number instanceof Double) {
                    map3.put(key, Double.valueOf(((Double) d).shortValue() - ((Double) number).shortValue()));
                } else if (number instanceof BigDecimal) {
                    map3.put(key, ((BigDecimal) d).subtract((BigDecimal) number));
                } else if (number instanceof BigInteger) {
                    map3.put(key, ((BigInteger) d).subtract((BigInteger) number));
                }
            }
        }
        return map3;
    }

    public static Class<?>[] getImplementedInterfaces(Class<?> cls) {
        Class<?>[] clsArr = implementedInterfacesCache.get(cls);
        if (clsArr != null) {
            return clsArr;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Class<?> superclass = cls;
        do {
            Collections.addAll(linkedHashSet, superclass.getInterfaces());
            superclass = superclass.getSuperclass();
        } while (superclass != null);
        Class<?>[] clsArr2 = (Class[]) linkedHashSet.toArray(new Class[linkedHashSet.size()]);
        Class<?>[] clsArrPutIfAbsent = implementedInterfacesCache.putIfAbsent(cls, clsArr2);
        return clsArrPutIfAbsent != null ? clsArrPutIfAbsent : clsArr2;
    }

    public static Object getInstance(String str, Class<?>[] clsArr, Object[] objArr, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            return handleNewInstance(Class.forName(str).getConstructor(clsArr), objArr, exceptionInterceptor);
        } catch (ClassNotFoundException e) {
            throw SQLError.createSQLException("Can't instantiate required class", SQLError.SQL_STATE_GENERAL_ERROR, e, exceptionInterceptor);
        } catch (NoSuchMethodException e2) {
            throw SQLError.createSQLException("Can't instantiate required class", SQLError.SQL_STATE_GENERAL_ERROR, e2, exceptionInterceptor);
        } catch (SecurityException e3) {
            throw SQLError.createSQLException("Can't instantiate required class", SQLError.SQL_STATE_GENERAL_ERROR, e3, exceptionInterceptor);
        }
    }

    public static int getJVMUpdateNumber() {
        return jvmUpdateNumber;
    }

    public static int getJVMVersion() {
        return jvmVersion;
    }

    public static String getPackageName(Class<?> cls) {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf > 0 ? name.substring(0, iLastIndexOf) : BuildConfig.FLAVOR;
    }

    public static final Object handleNewInstance(Constructor<?> constructor, Object[] objArr, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw SQLError.createSQLException("Can't instantiate required class", SQLError.SQL_STATE_GENERAL_ERROR, e, exceptionInterceptor);
        } catch (IllegalArgumentException e2) {
            throw SQLError.createSQLException("Can't instantiate required class", SQLError.SQL_STATE_GENERAL_ERROR, e2, exceptionInterceptor);
        } catch (InstantiationException e3) {
            throw SQLError.createSQLException("Can't instantiate required class", SQLError.SQL_STATE_GENERAL_ERROR, e3, exceptionInterceptor);
        } catch (InvocationTargetException e4) {
            Throwable targetException = e4.getTargetException();
            if (targetException instanceof SQLException) {
                throw ((SQLException) targetException);
            }
            if (targetException instanceof ExceptionInInitializerError) {
                targetException = ((ExceptionInInitializerError) targetException).getException();
            }
            throw SQLError.createSQLException(targetException.toString(), SQLError.SQL_STATE_GENERAL_ERROR, targetException, exceptionInterceptor);
        }
    }

    public static long[] hashPre41Password(String str, String str2) {
        try {
            return newHash(str.replaceAll("\\s", BuildConfig.FLAVOR).getBytes(str2));
        } catch (UnsupportedEncodingException unused) {
            return new long[0];
        }
    }

    public static boolean interfaceExists(String str) {
        try {
            Class<?> cls = Class.forName("java.net.NetworkInterface");
            return cls.getMethod("getByName", null).invoke(cls, str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isColdFusion() {
        return isColdFusion;
    }

    public static boolean isCommunityEdition(String str) {
        return !isEnterpriseEdition(str);
    }

    public static boolean isEnterpriseEdition(String str) {
        return str.contains("enterprise") || str.contains("commercial") || str.contains("advanced");
    }

    public static boolean isJdbc4() {
        return isJdbc4;
    }

    public static boolean isJdbc42() {
        return isJdbc42;
    }

    public static boolean isJdbcInterface(Class<?> cls) {
        ConcurrentMap<Class<?>, Boolean> concurrentMap = isJdbcInterfaceCache;
        if (concurrentMap.containsKey(cls)) {
            return concurrentMap.get(cls).booleanValue();
        }
        if (cls.isInterface()) {
            try {
                if (isJdbcPackage(getPackageName(cls))) {
                    concurrentMap.putIfAbsent(cls, Boolean.TRUE);
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (isJdbcInterface(cls2)) {
                isJdbcInterfaceCache.putIfAbsent(cls, Boolean.TRUE);
                return true;
            }
        }
        if (cls.getSuperclass() == null || !isJdbcInterface(cls.getSuperclass())) {
            isJdbcInterfaceCache.putIfAbsent(cls, Boolean.FALSE);
            return false;
        }
        isJdbcInterfaceCache.putIfAbsent(cls, Boolean.TRUE);
        return true;
    }

    public static boolean isJdbcPackage(String str) {
        return str != null && (str.startsWith("java.sql") || str.startsWith("javax.sql") || str.startsWith(MYSQL_JDBC_PACKAGE_ROOT));
    }

    public static boolean jvmMeetsMinimum(int i, int i2) {
        return getJVMVersion() > i || (getJVMVersion() == i && getJVMUpdateNumber() >= i2);
    }

    public static List<Extension> loadExtensions(Connection connection, Properties properties, String str, String str2, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        LinkedList linkedList = new LinkedList();
        List<String> listSplit = StringUtils.split(str, ",", true);
        String str3 = null;
        try {
            int size = listSplit.size();
            int i = 0;
            while (i < size) {
                String str4 = listSplit.get(i);
                try {
                    Extension extension = (Extension) Class.forName(str4).newInstance();
                    extension.init(connection, properties);
                    linkedList.add(extension);
                    i++;
                    str3 = str4;
                } catch (Throwable th) {
                    th = th;
                    str3 = str4;
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(Messages.getString(str2, new Object[]{str3}), exceptionInterceptor);
                    sQLExceptionCreateSQLException.initCause(th);
                    throw sQLExceptionCreateSQLException;
                }
            }
            return linkedList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String newCrypt(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return str;
        }
        long[] jArrNewHash = newHash(str2.getBytes());
        long[] jArrHashPre41Password = hashPre41Password(str, str3);
        long j = (jArrNewHash[0] ^ jArrHashPre41Password[0]) % 1073741823;
        long j2 = (jArrNewHash[1] ^ jArrHashPre41Password[1]) % 1073741823;
        char[] cArr = new char[str2.length()];
        for (int i = 0; i < str2.length(); i++) {
            j = ((j * 3) + j2) % 1073741823;
            j2 = ((j2 + j) + 33) % 1073741823;
            cArr[i] = (char) ((byte) Math.floor(((j / 1073741823) * 31.0d) + 64.0d));
        }
        Long.signum(j);
        long j3 = ((j * 3) + j2) % 1073741823;
        long j4 = ((j2 + j3) + 33) % 1073741823;
        byte bFloor = (byte) Math.floor((j3 / 1073741823) * 31.0d);
        for (int i2 = 0; i2 < str2.length(); i2++) {
            cArr[i2] = (char) (cArr[i2] ^ ((char) bFloor));
        }
        return new String(cArr);
    }

    public static long[] newHash(byte[] bArr) {
        long j = 1345345333;
        long j2 = 7;
        long j3 = 305419889;
        for (byte b : bArr) {
            long j4 = b & StatementImpl.USES_VARIABLES_UNKNOWN;
            j ^= (((63 & j) + j2) * j4) + (j << 8);
            j3 += (j3 << 8) ^ j;
            j2 += j4;
        }
        return new long[]{j & 2147483647L, j3 & 2147483647L};
    }

    public static String oldCrypt(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        long jOldHash = (oldHash(str2) ^ oldHash(str)) % 33554431;
        long j = jOldHash / 2;
        char[] cArr = new char[str2.length()];
        for (int i = 0; i < str2.length(); i++) {
            jOldHash = ((jOldHash * 3) + j) % 33554431;
            j = ((j + jOldHash) + 33) % 33554431;
            cArr[i] = (char) ((byte) Math.floor(((jOldHash / 33554431) * 31.0d) + 64.0d));
        }
        return new String(cArr);
    }

    public static long oldHash(String str) {
        long j = 1345345333;
        long j2 = 7;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '\t') {
                long jCharAt = str.charAt(i);
                j ^= (((63 & j) + j2) * jCharAt) + (j << 8);
                j2 += jCharAt;
            }
        }
        return j & 2147483647L;
    }

    private static RandStructcture randomInit(long j, long j2) {
        Util util = enclosingInstance;
        util.getClass();
        RandStructcture randStructcture = util.new RandStructcture();
        randStructcture.maxValue = 1073741823L;
        randStructcture.maxValueDbl = 1073741823L;
        randStructcture.seed1 = j % 1073741823;
        randStructcture.seed2 = j2 % 1073741823;
        return randStructcture;
    }

    public static Object readObject(ResultSet resultSet, int i) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(resultSet.getBinaryStream(i));
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }

    public static void resultSetToMap(Map map, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            map.put(resultSet.getObject(1), resultSet.getObject(2));
        }
    }

    private static double rnd(RandStructcture randStructcture) {
        long j = randStructcture.seed1 * 3;
        long j2 = randStructcture.seed2;
        long j3 = randStructcture.maxValue;
        long j4 = (j + j2) % j3;
        randStructcture.seed1 = j4;
        randStructcture.seed2 = ((j2 + j4) + 33) % j3;
        return j4 / randStructcture.maxValueDbl;
    }

    public static String scramble(String str, String str2) {
        byte[] bArr = new byte[8];
        String strSubstring = str.substring(0, 8);
        if (str2 == null || str2.length() <= 0) {
            return BuildConfig.FLAVOR;
        }
        long[] jArrHashPre41Password = hashPre41Password(str2);
        long[] jArrNewHash = newHash(strSubstring.getBytes());
        RandStructcture randStructctureRandomInit = randomInit(jArrHashPre41Password[0] ^ jArrNewHash[0], jArrHashPre41Password[1] ^ jArrNewHash[1]);
        int length = strSubstring.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i >= length) {
                break;
            }
            bArr[i2] = (byte) (Math.floor(rnd(randStructctureRandomInit) * 31.0d) + 64.0d);
            i2++;
            i = i3;
        }
        byte bFloor = (byte) Math.floor(rnd(randStructctureRandomInit) * 31.0d);
        for (int i4 = 0; i4 < 8; i4++) {
            bArr[i4] = (byte) (bArr[i4] ^ bFloor);
        }
        return StringUtils.toString(bArr);
    }

    public static long secondsSinceMillis(long j) {
        return (System.currentTimeMillis() - j) / 1000;
    }

    public static String stackTraceToString(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(Messages.getString("Util.1"));
        if (th != null) {
            sb.append(th.getClass().getName());
            String message = th.getMessage();
            if (message != null) {
                sb.append(Messages.getString("Util.2"));
                sb.append(message);
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            sb.append(Messages.getString("Util.3"));
            sb.append(stringWriter.toString());
        }
        sb.append(Messages.getString("Util.4"));
        return sb.toString();
    }

    public static int truncateAndConvertToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int[] truncateAndConvertToInt(long[] jArr) {
        int[] iArr = new int[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            iArr[i] = jArr[i] > 2147483647L ? Integer.MAX_VALUE : jArr[i] < -2147483648L ? Integer.MIN_VALUE : (int) jArr[i];
        }
        return iArr;
    }

    public static long[] hashPre41Password(String str) {
        return hashPre41Password(str, Charset.defaultCharset().name());
    }

    public static void resultSetToMap(Map map, ResultSet resultSet, int i, int i2) throws SQLException {
        while (resultSet.next()) {
            map.put(resultSet.getObject(i), resultSet.getObject(i2));
        }
    }

    public static void resultSetToMap(Map map, ResultSet resultSet, String str, String str2) throws SQLException {
        while (resultSet.next()) {
            map.put(resultSet.getObject(str), resultSet.getObject(str2));
        }
    }
}
