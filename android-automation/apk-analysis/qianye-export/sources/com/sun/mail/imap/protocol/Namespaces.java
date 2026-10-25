package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class Namespaces {
    public Namespace[] otherUsers;
    public Namespace[] personal;
    public Namespace[] shared;

    public static class Namespace {
        public char delimiter;
        public String prefix;

        public Namespace(Response response) throws ProtocolException {
            if (response.readByte() != 40) {
                throw new ProtocolException("Missing '(' at start of Namespace");
            }
            this.prefix = BASE64MailboxDecoder.decode(response.readString());
            response.skipSpaces();
            if (response.peekByte() == 34) {
                response.readByte();
                char c = (char) response.readByte();
                this.delimiter = c;
                if (c == '\\') {
                    this.delimiter = (char) response.readByte();
                }
                if (response.readByte() != 34) {
                    throw new ProtocolException("Missing '\"' at end of QUOTED_CHAR");
                }
            } else {
                String atom = response.readAtom();
                if (atom == null) {
                    throw new ProtocolException("Expected NIL, got null");
                }
                if (!atom.equalsIgnoreCase("NIL")) {
                    throw new ProtocolException("Expected NIL, got " + atom);
                }
                this.delimiter = (char) 0;
            }
            if (response.peekByte() != 41) {
                response.skipSpaces();
                response.readString();
                response.skipSpaces();
                response.readStringList();
            }
            if (response.readByte() != 41) {
                throw new ProtocolException("Missing ')' at end of Namespace");
            }
        }
    }

    public Namespaces(Response response) throws ProtocolException {
        this.personal = getNamespaces(response);
        this.otherUsers = getNamespaces(response);
        this.shared = getNamespaces(response);
    }

    private Namespace[] getNamespaces(Response response) throws ProtocolException {
        response.skipSpaces();
        if (response.peekByte() == 40) {
            Vector vector = new Vector();
            response.readByte();
            do {
                vector.addElement(new Namespace(response));
            } while (response.peekByte() != 41);
            response.readByte();
            Namespace[] namespaceArr = new Namespace[vector.size()];
            vector.copyInto(namespaceArr);
            return namespaceArr;
        }
        String atom = response.readAtom();
        if (atom == null) {
            throw new ProtocolException("Expected NIL, got null");
        }
        if (atom.equalsIgnoreCase("NIL")) {
            return null;
        }
        throw new ProtocolException("Expected NIL, got " + atom);
    }
}
