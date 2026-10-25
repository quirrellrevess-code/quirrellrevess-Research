package p051lLi1LL.I1I.p058il;

import com.mysql.jdbc.MysqlErrorNumbers;

/* JADX INFO: renamed from: l丨Li1LL.I1I.丨il.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: LimitExceededException.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL extends I1I {
    private static final long serialVersionUID = 6908339749836826785L;
    private final int limit;

    public IiL() {
        this(Integer.MAX_VALUE);
    }

    public int getLimit() {
        return this.limit;
    }

    public IiL(int i) {
        super(MysqlErrorNumbers.ER_DB_DROP_DELETE);
        this.limit = i;
    }

    public IiL(String str, int i) {
        super(MysqlErrorNumbers.ER_DB_DROP_DELETE, str);
        this.limit = i;
    }

    public IiL(String str) {
        this(str, Integer.MAX_VALUE);
    }
}
