package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import p066Ilil.I11li1;
import p066Ilil.I1I;
import p066Ilil.iILLL1;
import p066Ilil.lL;

/* JADX INFO: loaded from: classes.dex */
public final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    public static final iILLL1 PREFIX_CLEAN = iILLL1.encodeUtf8("OkHttp cache v1\n");
    public static final iILLL1 PREFIX_DIRTY = iILLL1.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    private final iILLL1 metadata;
    public int sourceCount;
    public I11li1 upstream;
    public long upstreamPos;
    public Thread upstreamReader;
    public final I1I upstreamBuffer = new I1I();
    public final I1I buffer = new I1I();

    public class RelaySource implements I11li1 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final lL timeout = new lL();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // p066Ilil.I11li1, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                int i = relay.sourceCount - 1;
                relay.sourceCount = i;
                if (i == 0) {
                    RandomAccessFile randomAccessFile2 = relay.file;
                    relay.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // p066Ilil.I11li1
        public long read(I1I i1i, long j) throws IOException {
            long j2;
            char c;
            Relay relay;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    long j3 = this.sourcePos;
                    Relay relay2 = Relay.this;
                    j2 = relay2.upstreamPos;
                    if (j3 != j2) {
                        long jM96I = j2 - relay2.buffer.m96I();
                        long j4 = this.sourcePos;
                        if (j4 < jM96I) {
                            c = 2;
                            break;
                        }
                        long jMin = Math.min(j, j2 - j4);
                        Relay.this.buffer.m2771IIiI(i1i, this.sourcePos - jM96I, jMin);
                        this.sourcePos += jMin;
                        return jMin;
                    }
                    if (!relay2.complete) {
                        if (relay2.upstreamReader == null) {
                            relay2.upstreamReader = Thread.currentThread();
                            c = 1;
                            break;
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } else {
                        return -1L;
                    }
                }
                if (c == 2) {
                    long jMin2 = Math.min(j, j2 - this.sourcePos);
                    this.fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, i1i, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    Relay relay3 = Relay.this;
                    long j5 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                    if (j5 == -1) {
                        Relay.this.commit(j2);
                        synchronized (Relay.this) {
                            Relay relay4 = Relay.this;
                            relay4.upstreamReader = null;
                            relay4.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j5, j);
                    Relay.this.upstreamBuffer.m2771IIiI(i1i, 0L, jMin3);
                    this.sourcePos += jMin3;
                    this.fileOperator.write(j2 + Relay.FILE_HEADER_SIZE, Relay.this.upstreamBuffer.clone(), j5);
                    synchronized (Relay.this) {
                        Relay relay5 = Relay.this;
                        relay5.buffer.write(relay5.upstreamBuffer, j5);
                        long jM96I2 = Relay.this.buffer.m96I();
                        Relay relay6 = Relay.this;
                        if (jM96I2 > relay6.bufferMaxSize) {
                            I1I i1i2 = relay6.buffer;
                            i1i2.I11L(i1i2.m96I() - Relay.this.bufferMaxSize);
                        }
                        relay = Relay.this;
                        relay.upstreamPos += j5;
                    }
                    synchronized (relay) {
                        Relay relay7 = Relay.this;
                        relay7.upstreamReader = null;
                        relay7.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th) {
                    synchronized (Relay.this) {
                        Relay relay8 = Relay.this;
                        relay8.upstreamReader = null;
                        relay8.notifyAll();
                        throw th;
                    }
                }
            }
        }

        @Override // p066Ilil.I11li1, p066Ilil.iIlLiL
        public lL timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, I11li1 i11li1, long j, iILLL1 iilll1, long j2) {
        this.file = randomAccessFile;
        this.upstream = i11li1;
        this.complete = i11li1 == null;
        this.upstreamPos = j;
        this.metadata = iilll1;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, I11li1 i11li1, iILLL1 iilll1, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, i11li1, 0L, iilll1, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        I1I i1i = new I1I();
        fileOperator.read(0L, i1i, FILE_HEADER_SIZE);
        iILLL1 iilll1 = PREFIX_CLEAN;
        if (!i1i.ILil(iilll1.size()).equals(iilll1)) {
            throw new IOException("unreadable cache file");
        }
        long jMo2788iILLL1 = i1i.mo2788iILLL1();
        long jMo2788iILLL2 = i1i.mo2788iILLL1();
        I1I i1i2 = new I1I();
        fileOperator.read(jMo2788iILLL1 + FILE_HEADER_SIZE, i1i2, jMo2788iILLL2);
        return new Relay(randomAccessFile, null, jMo2788iILLL1, i1i2.m98i1(), 0L);
    }

    private void writeHeader(iILLL1 iilll1, long j, long j2) throws IOException {
        I1I i1i = new I1I();
        i1i.m2803i11i(iilll1);
        i1i.m2804i11LL(j);
        i1i.m2804i11LL(j2);
        if (i1i.m96I() != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, i1i, FILE_HEADER_SIZE);
    }

    private void writeMetadata(long j) throws IOException {
        I1I i1i = new I1I();
        i1i.m2803i11i(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j, i1i, this.metadata.size());
    }

    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public iILLL1 metadata() {
        return this.metadata;
    }

    public I11li1 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
