package p051lLi1LL.I1I.p058il;

import com.mysql.jdbc.MysqlErrorNumbers;

/* JADX INFO: renamed from: l丨Li1LL.I1I.丨il.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: InvalidFrameException.java */
/* JADX INFO: loaded from: classes.dex */
public class lLi1LL extends I1I {
    private static final long serialVersionUID = -9016496369828887591L;

    public lLi1LL() {
        super(MysqlErrorNumbers.ER_NO);
    }

    public lLi1LL(String str) {
        super(MysqlErrorNumbers.ER_NO, str);
    }

    public lLi1LL(Throwable th) {
        super(MysqlErrorNumbers.ER_NO, th);
    }

    public lLi1LL(String str, Throwable th) {
        super(MysqlErrorNumbers.ER_NO, str, th);
    }
}
