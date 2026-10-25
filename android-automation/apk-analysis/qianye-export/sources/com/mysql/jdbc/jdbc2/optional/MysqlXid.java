package com.mysql.jdbc.jdbc2.optional;

import javax.transaction.xa.Xid;

/* JADX INFO: loaded from: classes.dex */
public class MysqlXid implements Xid {
    public int hash = 0;
    public byte[] myBqual;
    public int myFormatId;
    public byte[] myGtrid;

    public MysqlXid(byte[] bArr, byte[] bArr2, int i) {
        this.myGtrid = bArr;
        this.myBqual = bArr2;
        this.myFormatId = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Xid) {
            Xid xid = (Xid) obj;
            if (this.myFormatId != xid.getFormatId()) {
                return false;
            }
            byte[] branchQualifier = xid.getBranchQualifier();
            byte[] globalTransactionId = xid.getGlobalTransactionId();
            if (globalTransactionId != null && globalTransactionId.length == this.myGtrid.length) {
                int length = globalTransactionId.length;
                for (int i = 0; i < length; i++) {
                    if (globalTransactionId[i] != this.myGtrid[i]) {
                        return false;
                    }
                }
                if (branchQualifier != null && branchQualifier.length == this.myBqual.length) {
                    int length2 = branchQualifier.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (branchQualifier[i2] != this.myBqual[i2]) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public byte[] getBranchQualifier() {
        return this.myBqual;
    }

    public int getFormatId() {
        return this.myFormatId;
    }

    public byte[] getGlobalTransactionId() {
        return this.myGtrid;
    }

    public synchronized int hashCode() {
        if (this.hash == 0) {
            int i = 0;
            while (true) {
                byte[] bArr = this.myGtrid;
                if (i >= bArr.length) {
                    break;
                }
                this.hash = (this.hash * 33) + bArr[i];
                i++;
            }
        }
        return this.hash;
    }
}
