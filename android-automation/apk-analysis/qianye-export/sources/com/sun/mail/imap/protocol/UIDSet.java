package com.sun.mail.imap.protocol;

import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class UIDSet {
    public long end;
    public long start;

    public UIDSet() {
    }

    public static UIDSet[] createUIDSets(long[] jArr) {
        Vector vector = new Vector();
        int i = 0;
        while (i < jArr.length) {
            UIDSet uIDSet = new UIDSet();
            uIDSet.start = jArr[i];
            do {
                i++;
                if (i >= jArr.length) {
                    break;
                }
            } while (jArr[i] == jArr[i - 1] + 1);
            int i2 = i - 1;
            uIDSet.end = jArr[i2];
            vector.addElement(uIDSet);
            i = i2 + 1;
        }
        UIDSet[] uIDSetArr = new UIDSet[vector.size()];
        vector.copyInto(uIDSetArr);
        return uIDSetArr;
    }

    public static String toString(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null || uIDSetArr.length == 0) {
            return null;
        }
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = uIDSetArr.length;
        while (true) {
            long j = uIDSetArr[i].start;
            long j2 = uIDSetArr[i].end;
            if (j2 > j) {
                stringBuffer.append(j);
                stringBuffer.append(':');
                stringBuffer.append(j2);
            } else {
                stringBuffer.append(j);
            }
            i++;
            if (i >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
        }
    }

    public long size() {
        return (this.end - this.start) + 1;
    }

    public UIDSet(long j, long j2) {
        this.start = j;
        this.end = j2;
    }

    public static long size(UIDSet[] uIDSetArr) {
        long size = 0;
        if (uIDSetArr == null) {
            return 0L;
        }
        for (UIDSet uIDSet : uIDSetArr) {
            size += uIDSet.size();
        }
        return size;
    }
}
