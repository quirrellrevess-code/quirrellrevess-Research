package okhttp3.internal.http2;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.StatementImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.iILLL1;
import p066Ilil.lIiI;
import p066Ilil.lLi1LL;

/* JADX INFO: loaded from: classes.dex */
public final class Hpack {
    public static final Map<iILLL1, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    public static final Header[] STATIC_HEADER_TABLE;

    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        public int nextHeaderIndex;
        private final lLi1LL source;

        public Reader(int i, I11li1 i11li1) {
            this(i, i, i11li1);
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        private int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.dynamicTable;
                    i -= headerArr[length].hpackSize;
                    this.dynamicTableByteCount -= headerArr[length].hpackSize;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i2 + 1, headerArr2, i2 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private iILLL1 getName(int i) throws IOException {
            if (isStaticHeader(i)) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i + dynamicTableIndex(i) + iEvictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws IOException {
            return this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
        }

        private void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public iILLL1 readByteString() throws IOException {
            int i = readByte();
            boolean z = (i & 128) == 128;
            int i2 = readInt(i, 127);
            return z ? iILLL1.m103of(Huffman.get().decode(this.source.mo28101(i2))) : this.source.ILil(i2);
        }

        public void readHeaders() throws IOException {
            while (!this.source.ILL()) {
                int iMo2798lIlii = this.source.mo2798lIlii() & StatementImpl.USES_VARIABLES_UNKNOWN;
                if (iMo2798lIlii == 128) {
                    throw new IOException("index == 0");
                }
                if ((iMo2798lIlii & 128) == 128) {
                    readIndexedHeader(readInt(iMo2798lIlii, 127) - 1);
                } else if (iMo2798lIlii == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((iMo2798lIlii & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(iMo2798lIlii, 63) - 1);
                } else if ((iMo2798lIlii & 32) == 32) {
                    int i = readInt(iMo2798lIlii, 31);
                    this.maxDynamicTableByteCount = i;
                    if (i < 0 || i > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (iMo2798lIlii == 16 || iMo2798lIlii == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(iMo2798lIlii, 15) - 1);
                }
            }
        }

        public int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = readByte();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        public Reader(int i, int i2, I11li1 i11li1) {
            this.headerList = new ArrayList();
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = lIiI.m2826IL(i11li1);
        }
    }

    public static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        public int nextHeaderIndex;
        private final I1I out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(I1I i1i) {
            this(4096, true, i1i);
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.dynamicTable;
                    i -= headerArr[length].hpackSize;
                    this.dynamicTableByteCount -= headerArr[length].hpackSize;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i2 + 1, headerArr2, i2 + 1 + i3, this.headerCount);
                Header[] headerArr3 = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                Arrays.fill(headerArr3, i4 + 1, i4 + 1 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public void setHeaderTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public void writeByteString(iILLL1 iilll1) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(iilll1) >= iilll1.size()) {
                writeInt(iilll1.size(), 127, 0);
                this.out.m2803i11i(iilll1);
                return;
            }
            I1I i1i = new I1I();
            Huffman.get().encode(iilll1, i1i);
            iILLL1 iilll1M98i1 = i1i.m98i1();
            writeInt(iilll1M98i1.size(), 127, 128);
            this.out.m2803i11i(iilll1M98i1);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x006a  */
        public void writeHeaders(List<Header> list) throws IOException {
            int length;
            int length2;
            if (this.emitDynamicTableSizeUpdate) {
                int i = this.smallestHeaderTableSizeSetting;
                if (i < this.maxDynamicTableByteCount) {
                    writeInt(i, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header header = list.get(i2);
                iILLL1 asciiLowercase = header.name.toAsciiLowercase();
                iILLL1 iilll1 = header.value;
                Integer num = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Objects.equals(headerArr[length - 1].value, iilll1)) {
                            length2 = length;
                        } else if (Objects.equals(headerArr[length].value, iilll1)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length == -1) {
                    int length3 = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length3; i3++) {
                        if (Objects.equals(this.dynamicTable[i3].name, asciiLowercase)) {
                            if (Objects.equals(this.dynamicTable[i3].value, iilll1)) {
                                length = Hpack.STATIC_HEADER_TABLE.length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i3 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    writeInt(length, 127, 128);
                } else if (length2 == -1) {
                    this.out.l1Lll(64);
                    writeByteString(asciiLowercase);
                    writeByteString(iilll1);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    writeInt(length2, 63, 64);
                    writeByteString(iilll1);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(length2, 15, 0);
                    writeByteString(iilll1);
                }
            }
        }

        public void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.l1Lll(i | i3);
                return;
            }
            this.out.l1Lll(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.l1Lll(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.l1Lll(i4);
        }

        public Writer(int i, boolean z, I1I i1i) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.useCompression = z;
            this.out = i1i;
        }
    }

    static {
        iILLL1 iilll1 = Header.TARGET_METHOD;
        iILLL1 iilll2 = Header.TARGET_PATH;
        iILLL1 iilll3 = Header.TARGET_SCHEME;
        iILLL1 iilll4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, BuildConfig.FLAVOR), new Header(iilll1, "GET"), new Header(iilll1, "POST"), new Header(iilll2, "/"), new Header(iilll2, "/index.html"), new Header(iilll3, "http"), new Header(iilll3, "https"), new Header(iilll4, "200"), new Header(iilll4, "204"), new Header(iilll4, "206"), new Header(iilll4, "304"), new Header(iilll4, "400"), new Header(iilll4, "404"), new Header(iilll4, "500"), new Header("accept-charset", BuildConfig.FLAVOR), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", BuildConfig.FLAVOR), new Header("accept-ranges", BuildConfig.FLAVOR), new Header("accept", BuildConfig.FLAVOR), new Header("access-control-allow-origin", BuildConfig.FLAVOR), new Header("age", BuildConfig.FLAVOR), new Header("allow", BuildConfig.FLAVOR), new Header("authorization", BuildConfig.FLAVOR), new Header("cache-control", BuildConfig.FLAVOR), new Header("content-disposition", BuildConfig.FLAVOR), new Header("content-encoding", BuildConfig.FLAVOR), new Header("content-language", BuildConfig.FLAVOR), new Header("content-length", BuildConfig.FLAVOR), new Header("content-location", BuildConfig.FLAVOR), new Header("content-range", BuildConfig.FLAVOR), new Header("content-type", BuildConfig.FLAVOR), new Header("cookie", BuildConfig.FLAVOR), new Header("date", BuildConfig.FLAVOR), new Header("etag", BuildConfig.FLAVOR), new Header("expect", BuildConfig.FLAVOR), new Header("expires", BuildConfig.FLAVOR), new Header("from", BuildConfig.FLAVOR), new Header("host", BuildConfig.FLAVOR), new Header("if-match", BuildConfig.FLAVOR), new Header("if-modified-since", BuildConfig.FLAVOR), new Header("if-none-match", BuildConfig.FLAVOR), new Header("if-range", BuildConfig.FLAVOR), new Header("if-unmodified-since", BuildConfig.FLAVOR), new Header("last-modified", BuildConfig.FLAVOR), new Header("link", BuildConfig.FLAVOR), new Header("location", BuildConfig.FLAVOR), new Header("max-forwards", BuildConfig.FLAVOR), new Header("proxy-authenticate", BuildConfig.FLAVOR), new Header("proxy-authorization", BuildConfig.FLAVOR), new Header("range", BuildConfig.FLAVOR), new Header("referer", BuildConfig.FLAVOR), new Header("refresh", BuildConfig.FLAVOR), new Header("retry-after", BuildConfig.FLAVOR), new Header("server", BuildConfig.FLAVOR), new Header("set-cookie", BuildConfig.FLAVOR), new Header("strict-transport-security", BuildConfig.FLAVOR), new Header("transfer-encoding", BuildConfig.FLAVOR), new Header("user-agent", BuildConfig.FLAVOR), new Header("vary", BuildConfig.FLAVOR), new Header("via", BuildConfig.FLAVOR), new Header("www-authenticate", BuildConfig.FLAVOR)};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    public static iILLL1 checkLowercase(iILLL1 iilll1) throws IOException {
        int size = iilll1.size();
        for (int i = 0; i < size; i++) {
            byte b = iilll1.getByte(i);
            if (b >= 65 && b <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + iilll1.utf8());
            }
        }
        return iilll1;
    }

    private static Map<iILLL1, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
            i++;
        }
    }
}
