package com.sun.mail.iap;

import com.mysql.jdbc.StatementImpl;
import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class Argument {
    public Vector items = new Vector(1);

    private void astring(byte[] bArr, Protocol protocol) throws ProtocolException, IOException {
        int i;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        int length = bArr.length;
        if (length > 1024) {
            literal(bArr, protocol);
            return;
        }
        boolean z = length == 0;
        boolean z2 = false;
        for (byte b : bArr) {
            if (b == 0 || b == 13 || b == 10 || (i = b & StatementImpl.USES_VARIABLES_UNKNOWN) > 127) {
                literal(bArr, protocol);
                return;
            }
            if (b == 42 || b == 37 || b == 40 || b == 41 || b == 123 || b == 34 || b == 92 || i <= 32) {
                if (b == 34 || b == 92) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                }
            }
        }
        if (z) {
            dataOutputStream.write(34);
        }
        if (z2) {
            for (byte b2 : bArr) {
                if (b2 == 34 || b2 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b2);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z) {
            dataOutputStream.write(34);
        }
    }

    private void literal(byte[] bArr, Protocol protocol) throws ProtocolException, IOException {
        startLiteral(protocol, bArr.length).write(bArr);
    }

    private OutputStream startLiteral(Protocol protocol, int i) throws ProtocolException, IOException {
        Response response;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        boolean zSupportsNonSyncLiterals = protocol.supportsNonSyncLiterals();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i));
        if (zSupportsNonSyncLiterals) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!zSupportsNonSyncLiterals) {
            do {
                response = protocol.readResponse();
                if (response.isContinuation()) {
                }
            } while (!response.isTagged());
            throw new LiteralException(response);
        }
        return dataOutputStream;
    }

    public void append(Argument argument) {
        Vector vector = this.items;
        vector.ensureCapacity(vector.size() + argument.items.size());
        for (int i = 0; i < argument.items.size(); i++) {
            this.items.addElement(argument.items.elementAt(i));
        }
    }

    public void write(Protocol protocol) throws ProtocolException, IOException {
        Vector vector = this.items;
        int size = vector != null ? vector.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                dataOutputStream.write(32);
            }
            Object objElementAt = this.items.elementAt(i);
            if (objElementAt instanceof Atom) {
                dataOutputStream.writeBytes(((Atom) objElementAt).string);
            } else if (objElementAt instanceof Number) {
                dataOutputStream.writeBytes(((Number) objElementAt).toString());
            } else if (objElementAt instanceof AString) {
                astring(((AString) objElementAt).bytes, protocol);
            } else if (objElementAt instanceof byte[]) {
                literal((byte[]) objElementAt, protocol);
            } else if (objElementAt instanceof ByteArrayOutputStream) {
                literal((ByteArrayOutputStream) objElementAt, protocol);
            } else if (objElementAt instanceof Literal) {
                literal((Literal) objElementAt, protocol);
            } else if (objElementAt instanceof Argument) {
                dataOutputStream.write(40);
                ((Argument) objElementAt).write(protocol);
                dataOutputStream.write(41);
            }
        }
    }

    public void writeArgument(Argument argument) {
        this.items.addElement(argument);
    }

    public void writeAtom(String str) {
        this.items.addElement(new Atom(str));
    }

    public void writeBytes(byte[] bArr) {
        this.items.addElement(bArr);
    }

    public void writeNumber(int i) {
        this.items.addElement(new Integer(i));
    }

    public void writeString(String str) {
        this.items.addElement(new AString(ASCIIUtility.getBytes(str)));
    }

    private void literal(ByteArrayOutputStream byteArrayOutputStream, Protocol protocol) throws ProtocolException, IOException {
        byteArrayOutputStream.writeTo(startLiteral(protocol, byteArrayOutputStream.size()));
    }

    public void writeBytes(ByteArrayOutputStream byteArrayOutputStream) {
        this.items.addElement(byteArrayOutputStream);
    }

    public void writeNumber(long j) {
        this.items.addElement(new Long(j));
    }

    public void writeString(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            writeString(str);
        } else {
            this.items.addElement(new AString(str.getBytes(str2)));
        }
    }

    private void literal(Literal literal, Protocol protocol) throws ProtocolException, IOException {
        literal.writeTo(startLiteral(protocol, literal.size()));
    }

    public void writeBytes(Literal literal) {
        this.items.addElement(literal);
    }
}
