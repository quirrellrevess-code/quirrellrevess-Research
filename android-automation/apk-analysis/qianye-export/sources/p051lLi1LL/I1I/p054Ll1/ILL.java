package p051lLi1LL.I1I.p054Ll1;

import com.mysql.jdbc.MysqlErrorNumbers;
import p051lLi1LL.I1I.p055L11I.I1I;

/* JADX INFO: compiled from: TextFrame.java */
/* JADX INFO: loaded from: classes.dex */
public class ILL extends lLi1LL {
    public ILL() {
        super(I1I.TEXT);
    }

    @Override // p051lLi1LL.I1I.p054Ll1.lLi1LL, p051lLi1LL.I1I.p054Ll1.IiL
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void mo3583IiL() throws p051lLi1LL.I1I.p058il.I1I {
        super.mo3583IiL();
        if (!p051lLi1LL.I1I.LlLI1.I1I.ILil(mo3586lLi1LL())) {
            throw new p051lLi1LL.I1I.p058il.I1I(MysqlErrorNumbers.ER_DB_CREATE_EXISTS, "Received text is no valid utf8 string!");
        }
    }
}
