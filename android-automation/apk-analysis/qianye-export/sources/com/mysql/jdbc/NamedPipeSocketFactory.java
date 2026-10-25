package com.mysql.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class NamedPipeSocketFactory implements SocketFactory, SocketMetadata {
    public static final String NAMED_PIPE_PROP_NAME = "namedPipePath";
    private Socket namedPipeSocket;

    public class NamedPipeSocket extends Socket {
        private boolean isClosed = false;
        private RandomAccessFile namedPipeFile;

        public NamedPipeSocket(String str) throws IOException {
            if (str == null || str.length() == 0) {
                throw new IOException(Messages.getString("NamedPipeSocketFactory.4"));
            }
            this.namedPipeFile = new RandomAccessFile(str, "rw");
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.namedPipeFile.close();
            this.isClosed = true;
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            return NamedPipeSocketFactory.this.new RandomAccessFileInputStream(this.namedPipeFile);
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            return NamedPipeSocketFactory.this.new RandomAccessFileOutputStream(this.namedPipeFile);
        }

        @Override // java.net.Socket
        public boolean isClosed() {
            return this.isClosed;
        }
    }

    public class RandomAccessFileInputStream extends InputStream {
        public RandomAccessFile raFile;

        public RandomAccessFileInputStream(RandomAccessFile randomAccessFile) {
            this.raFile = randomAccessFile;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return -1;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.raFile.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.raFile.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return this.raFile.read(bArr);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return this.raFile.read(bArr, i, i2);
        }
    }

    public class RandomAccessFileOutputStream extends OutputStream {
        public RandomAccessFile raFile;

        public RandomAccessFileOutputStream(RandomAccessFile randomAccessFile) {
            this.raFile = randomAccessFile;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.raFile.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.raFile.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.raFile.write(bArr, i, i2);
        }
    }

    @Override // com.mysql.jdbc.SocketFactory
    public Socket afterHandshake() throws IOException {
        return this.namedPipeSocket;
    }

    @Override // com.mysql.jdbc.SocketFactory
    public Socket beforeHandshake() throws IOException {
        return this.namedPipeSocket;
    }

    @Override // com.mysql.jdbc.SocketFactory
    public Socket connect(String str, int i, Properties properties) throws IOException {
        String property = properties.getProperty(NAMED_PIPE_PROP_NAME);
        if (property == null) {
            property = "\\\\.\\pipe\\MySQL";
        } else if (property.length() == 0) {
            throw new SocketException(Messages.getString("NamedPipeSocketFactory.2") + NAMED_PIPE_PROP_NAME + Messages.getString("NamedPipeSocketFactory.3"));
        }
        NamedPipeSocket namedPipeSocket = new NamedPipeSocket(property);
        this.namedPipeSocket = namedPipeSocket;
        return namedPipeSocket;
    }

    @Override // com.mysql.jdbc.SocketMetadata
    public boolean isLocallyConnected(ConnectionImpl connectionImpl) throws SQLException {
        return true;
    }
}
