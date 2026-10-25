package com.sun.mail.iap;

import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class Protocol {
    private static final byte[] CRLF = {13, 10};
    private boolean connected;
    public boolean debug;
    private volatile Vector handlers;
    public String host;
    private volatile ResponseInputStream input;
    public PrintStream out;
    private volatile DataOutputStream output;
    public String prefix;
    public Properties props;
    public boolean quote;
    private Socket socket;
    private int tagCounter;
    private volatile long timestamp;
    private TraceInputStream traceInput;
    private TraceOutputStream traceOutput;

    public Protocol(String str, int i, boolean z, PrintStream printStream, Properties properties, String str2, boolean z2) throws ProtocolException, IOException {
        boolean z3 = false;
        this.connected = false;
        this.tagCounter = 0;
        this.handlers = null;
        try {
            this.host = str;
            this.debug = z;
            this.out = printStream;
            this.props = properties;
            this.prefix = str2;
            this.socket = SocketFetcher.getSocket(str, i, properties, str2, z2);
            String property = properties.getProperty("mail.debug.quote");
            if (property != null && property.equalsIgnoreCase("true")) {
                z3 = true;
            }
            this.quote = z3;
            initStreams(printStream);
            processGreeting(readResponse());
            this.timestamp = System.currentTimeMillis();
            this.connected = true;
        } catch (Throwable th) {
            if (!this.connected) {
                disconnect();
            }
            throw th;
        }
    }

    private void initStreams(PrintStream printStream) throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.socket.getInputStream(), printStream);
        this.traceInput = traceInputStream;
        traceInputStream.setTrace(this.debug);
        this.traceInput.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.socket.getOutputStream(), printStream);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setTrace(this.debug);
        this.traceOutput.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
    }

    public synchronized void addResponseHandler(ResponseHandler responseHandler) {
        if (this.handlers == null) {
            this.handlers = new Vector();
        }
        this.handlers.addElement(responseHandler);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:34:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x004f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0020 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x001f -> B:12:0x0020). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:38:0x004f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public synchronized com.sun.mail.iap.Response[] command(java.lang.String r5, com.sun.mail.iap.Argument r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Vector r0 = new java.util.Vector     // Catch: java.lang.Throwable -> L5a
            r0.<init>()     // Catch: java.lang.Throwable -> L5a
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r2 = r4.writeCommand(r5, r6)     // Catch: java.lang.Exception -> Le com.sun.mail.iap.LiteralException -> L17 java.lang.Throwable -> L5a
            goto L20
        Le:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch: java.lang.Throwable -> L5a
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
            goto L1f
        L17:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = r5.getResponse()     // Catch: java.lang.Throwable -> L5a
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
        L1f:
            r1 = 1
        L20:
            if (r1 == 0) goto L33
            int r5 = r0.size()     // Catch: java.lang.Throwable -> L5a
            com.sun.mail.iap.Response[] r5 = new com.sun.mail.iap.Response[r5]     // Catch: java.lang.Throwable -> L5a
            r0.copyInto(r5)     // Catch: java.lang.Throwable -> L5a
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5a
            r4.timestamp = r0     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r4)
            return r5
        L33:
            com.sun.mail.iap.Response r5 = r4.readResponse()     // Catch: com.sun.mail.iap.ProtocolException -> L38 java.io.IOException -> L3a java.lang.Throwable -> L5a
            goto L3f
        L38:
            goto L20
        L3a:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch: java.lang.Throwable -> L5a
        L3f:
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
            boolean r6 = r5.isBYE()     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L49
            r1 = 1
        L49:
            boolean r6 = r5.isTagged()     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L20
            java.lang.String r5 = r5.getTag()     // Catch: java.lang.Throwable -> L5a
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L20
            goto L1f
        L5a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.Protocol.command(java.lang.String, com.sun.mail.iap.Argument):com.sun.mail.iap.Response[]");
    }

    public synchronized void disconnect() {
        Socket socket = this.socket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            this.socket = null;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        disconnect();
    }

    public ResponseInputStream getInputStream() {
        return this.input;
    }

    public OutputStream getOutputStream() {
        return this.output;
    }

    public ByteArray getResponseBuffer() {
        return null;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void handleResult(Response response) throws ProtocolException {
        if (response.isOK()) {
            return;
        }
        if (response.isNO()) {
            throw new CommandFailedException(response);
        }
        if (response.isBAD()) {
            throw new BadCommandException(response);
        }
        if (response.isBYE()) {
            disconnect();
            throw new ConnectionException(this, response);
        }
    }

    public void notifyResponseHandlers(Response[] responseArr) {
        if (this.handlers == null) {
            return;
        }
        for (Response response : responseArr) {
            if (response != null) {
                int size = this.handlers.size();
                if (size == 0) {
                    return;
                }
                Object[] objArr = new Object[size];
                this.handlers.copyInto(objArr);
                for (int i = 0; i < size; i++) {
                    ((ResponseHandler) objArr[i]).handleResponse(response);
                }
            }
        }
    }

    public void processGreeting(Response response) throws ProtocolException {
        if (response.isBYE()) {
            throw new ConnectionException(this, response);
        }
    }

    public Response readResponse() throws ProtocolException, IOException {
        return new Response(this);
    }

    public synchronized void removeResponseHandler(ResponseHandler responseHandler) {
        if (this.handlers != null) {
            this.handlers.removeElement(responseHandler);
        }
    }

    public void simpleCommand(String str, Argument argument) throws ProtocolException {
        Response[] responseArrCommand = command(str, argument);
        notifyResponseHandlers(responseArrCommand);
        handleResult(responseArrCommand[responseArrCommand.length - 1]);
    }

    public synchronized void startTLS(String str) throws ProtocolException, IOException {
        simpleCommand(str, null);
        this.socket = SocketFetcher.startTLS(this.socket, this.props, this.prefix);
        initStreams(this.out);
    }

    public synchronized boolean supportsNonSyncLiterals() {
        return false;
    }

    public String writeCommand(String str, Argument argument) throws ProtocolException, IOException {
        StringBuilder sb = new StringBuilder("A");
        int i = this.tagCounter;
        this.tagCounter = i + 1;
        sb.append(Integer.toString(i, 10));
        String string = sb.toString();
        this.output.writeBytes(String.valueOf(string) + " " + str);
        if (argument != null) {
            this.output.write(32);
            argument.write(this);
        }
        this.output.write(CRLF);
        this.output.flush();
        return string;
    }

    public Protocol(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        this.connected = false;
        this.tagCounter = 0;
        this.handlers = null;
        this.host = "localhost";
        this.debug = z;
        this.quote = false;
        this.out = System.out;
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, System.out);
        this.traceInput = traceInputStream;
        traceInputStream.setTrace(z);
        this.traceInput.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        TraceOutputStream traceOutputStream = new TraceOutputStream(outputStream, System.out);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setTrace(z);
        this.traceOutput.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
        this.timestamp = System.currentTimeMillis();
    }
}
