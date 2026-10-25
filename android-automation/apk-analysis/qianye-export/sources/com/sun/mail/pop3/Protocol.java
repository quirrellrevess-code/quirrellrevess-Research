package com.sun.mail.pop3;

import com.mysql.jdbc.StatementImpl;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class Protocol {
    private static final String CRLF = "\r\n";
    private static final int POP3_PORT = 110;
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String apopChallenge;
    private boolean debug;
    private DataInputStream input;
    private PrintStream out;
    private PrintWriter output;
    private Socket socket;

    public Protocol(String str, int i, boolean z, PrintStream printStream, Properties properties, String str2, boolean z2) throws IOException {
        boolean z3 = false;
        this.debug = false;
        this.apopChallenge = null;
        this.debug = z;
        this.out = printStream;
        String property = properties.getProperty(String.valueOf(str2) + ".apop.enable");
        if (property != null && property.equalsIgnoreCase("true")) {
            z3 = true;
        }
        i = i == -1 ? 110 : i;
        if (z) {
            try {
                printStream.println("DEBUG POP3: connecting to host \"" + str + "\", port " + i + ", isSSL " + z2);
            } catch (IOException e) {
                try {
                    this.socket.close();
                } catch (Throwable unused) {
                }
                throw e;
            }
        }
        this.socket = SocketFetcher.getSocket(str, i, properties, str2, z2);
        this.input = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
        this.output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(), "iso-8859-1")));
        Response responseSimpleCommand = simpleCommand(null);
        if (!responseSimpleCommand.f129ok) {
            try {
                this.socket.close();
            } catch (Throwable unused2) {
            }
            throw new IOException("Connect failed");
        }
        if (z3) {
            int iIndexOf = responseSimpleCommand.data.indexOf(60);
            int iIndexOf2 = responseSimpleCommand.data.indexOf(62, iIndexOf);
            if (iIndexOf != -1 && iIndexOf2 != -1) {
                this.apopChallenge = responseSimpleCommand.data.substring(iIndexOf, iIndexOf2 + 1);
            }
            if (z) {
                printStream.println("DEBUG POP3: APOP challenge: " + this.apopChallenge);
            }
        }
    }

    private String getDigest(String str) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest((String.valueOf(this.apopChallenge) + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private Response multilineCommand(String str, int i) throws IOException {
        int i2;
        Response responseSimpleCommand = simpleCommand(str);
        if (!responseSimpleCommand.f129ok) {
            return responseSimpleCommand;
        }
        SharedByteArrayOutputStream sharedByteArrayOutputStream = new SharedByteArrayOutputStream(i);
        int i3 = 10;
        while (true) {
            i2 = this.input.read();
            if (i2 < 0) {
                break;
            }
            if (i3 == 10 && i2 == 46) {
                if (this.debug) {
                    this.out.write(i2);
                }
                i3 = this.input.read();
                if (i3 == 13) {
                    if (this.debug) {
                        this.out.write(i3);
                    }
                    i2 = this.input.read();
                    if (!this.debug) {
                        break;
                    }
                    this.out.write(i2);
                    break;
                }
            } else {
                i3 = i2;
            }
            sharedByteArrayOutputStream.write(i3);
            if (this.debug) {
                this.out.write(i3);
            }
        }
        if (i2 < 0) {
            throw new EOFException("EOF on socket");
        }
        responseSimpleCommand.bytes = sharedByteArrayOutputStream.toStream();
        return responseSimpleCommand;
    }

    private Response simpleCommand(String str) throws IOException {
        if (this.socket == null) {
            throw new IOException("Folder is closed");
        }
        if (str != null) {
            if (this.debug) {
                this.out.println("C: " + str);
            }
            this.output.print(String.valueOf(str) + CRLF);
            this.output.flush();
        }
        String line = this.input.readLine();
        if (line == null) {
            if (this.debug) {
                this.out.println("S: EOF");
            }
            throw new EOFException("EOF on socket");
        }
        if (this.debug) {
            this.out.println("S: " + line);
        }
        Response response = new Response();
        if (line.startsWith("+OK")) {
            response.f129ok = true;
        } else {
            if (!line.startsWith("-ERR")) {
                throw new IOException("Unexpected response: " + line);
            }
            response.f129ok = false;
        }
        int iIndexOf = line.indexOf(32);
        if (iIndexOf >= 0) {
            response.data = line.substring(iIndexOf + 1);
        }
        return response;
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & StatementImpl.USES_VARIABLES_UNKNOWN;
            int i3 = i + 1;
            char[] cArr2 = digits;
            cArr[i] = cArr2[i2 >> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public synchronized boolean dele(int i) throws IOException {
        return simpleCommand("DELE " + i).f129ok;
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.socket != null) {
            quit();
        }
    }

    public synchronized int list(int i) throws IOException {
        int i2;
        Response responseSimpleCommand = simpleCommand("LIST " + i);
        i2 = -1;
        if (responseSimpleCommand.f129ok && responseSimpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(responseSimpleCommand.data);
                stringTokenizer.nextToken();
                i2 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    public synchronized String login(String str, String str2) throws IOException {
        Response responseSimpleCommand;
        String digest = this.apopChallenge != null ? getDigest(str2) : null;
        if (this.apopChallenge == null || digest == null) {
            Response responseSimpleCommand2 = simpleCommand("USER " + str);
            if (!responseSimpleCommand2.f129ok) {
                String str3 = responseSimpleCommand2.data;
                if (str3 == null) {
                    str3 = "USER command failed";
                }
                return str3;
            }
            responseSimpleCommand = simpleCommand("PASS " + str2);
        } else {
            responseSimpleCommand = simpleCommand("APOP " + str + " " + digest);
        }
        if (responseSimpleCommand.f129ok) {
            return null;
        }
        String str4 = responseSimpleCommand.data;
        if (str4 == null) {
            str4 = "login failed";
        }
        return str4;
    }

    public synchronized boolean noop() throws IOException {
        return simpleCommand("NOOP").f129ok;
    }

    public synchronized boolean quit() throws IOException {
        boolean z;
        try {
            z = simpleCommand("QUIT").f129ok;
            try {
                this.socket.close();
                this.socket = null;
                this.input = null;
                this.output = null;
            } catch (Throwable th) {
                this.socket = null;
                this.input = null;
                this.output = null;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                this.socket.close();
                throw th2;
            } finally {
                this.socket = null;
                this.input = null;
                this.output = null;
            }
        }
        return z;
    }

    public synchronized InputStream retr(int i, int i2) throws IOException {
        return multilineCommand("RETR " + i, i2).bytes;
    }

    public synchronized boolean rset() throws IOException {
        return simpleCommand("RSET").f129ok;
    }

    public synchronized Status stat() throws IOException {
        Status status;
        Response responseSimpleCommand = simpleCommand("STAT");
        status = new Status();
        if (responseSimpleCommand.f129ok && responseSimpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(responseSimpleCommand.data);
                status.total = Integer.parseInt(stringTokenizer.nextToken());
                status.size = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return status;
    }

    public synchronized InputStream top(int i, int i2) throws IOException {
        return multilineCommand("TOP " + i + " " + i2, 0).bytes;
    }

    public synchronized String uidl(int i) throws IOException {
        Response responseSimpleCommand = simpleCommand("UIDL " + i);
        if (!responseSimpleCommand.f129ok) {
            return null;
        }
        int iIndexOf = responseSimpleCommand.data.indexOf(32);
        if (iIndexOf <= 0) {
            return null;
        }
        return responseSimpleCommand.data.substring(iIndexOf + 1);
    }

    public synchronized InputStream list() throws IOException {
        return multilineCommand("LIST", 128).bytes;
    }

    public synchronized boolean uidl(String[] strArr) throws IOException {
        int i;
        Response responseMultilineCommand = multilineCommand("UIDL", strArr.length * 15);
        if (!responseMultilineCommand.f129ok) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(responseMultilineCommand.bytes);
        while (true) {
            String line = lineInputStream.readLine();
            if (line == null) {
                return true;
            }
            int iIndexOf = line.indexOf(32);
            if (iIndexOf >= 1 && iIndexOf < line.length() && (i = Integer.parseInt(line.substring(0, iIndexOf))) > 0 && i <= strArr.length) {
                strArr[i - 1] = line.substring(iIndexOf + 1);
            }
        }
    }
}
