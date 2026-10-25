package p051lLi1LL.I1I.p058il;

import com.mysql.jdbc.MysqlErrorNumbers;

/* JADX INFO: renamed from: l丨Li1LL.I1I.丨il.iI丨LLL1, reason: invalid class name */
/* JADX INFO: compiled from: InvalidHandshakeException.java */
/* JADX INFO: loaded from: classes.dex */
public class iILLL1 extends I1I {
    private static final long serialVersionUID = -1426533877490484964L;

    public iILLL1() {
        super(MysqlErrorNumbers.ER_NO);
    }

    public iILLL1(String str, Throwable th) {
        super(MysqlErrorNumbers.ER_NO, str, th);
    }

    public iILLL1(String str) {
        super(MysqlErrorNumbers.ER_NO, str);
    }

    public iILLL1(Throwable th) {
        super(MysqlErrorNumbers.ER_NO, th);
    }
}
