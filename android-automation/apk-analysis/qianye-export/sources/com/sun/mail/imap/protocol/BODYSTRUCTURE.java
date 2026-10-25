package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.Vector;
import javax.mail.internet.ParameterList;

/* JADX INFO: loaded from: classes.dex */
public class BODYSTRUCTURE implements Item {
    private static boolean parseDebug;
    public String attachment;
    public BODYSTRUCTURE[] bodies;
    public ParameterList cParams;
    public ParameterList dParams;
    public String description;
    public String disposition;
    public String encoding;
    public ENVELOPE envelope;

    /* JADX INFO: renamed from: id */
    public String f123id;
    public String[] language;
    public int lines;
    public String md5;
    public int msgno;
    private int processedType;
    public int size;
    public String subtype;
    public String type;
    public static final char[] name = {'B', 'O', 'D', 'Y', 'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E'};
    private static int SINGLE = 1;
    private static int MULTI = 2;
    private static int NESTED = 3;

    static {
        boolean z = true;
        parseDebug = false;
        try {
            String property = System.getProperty("mail.imap.parse.debug");
            if (property == null || !property.equalsIgnoreCase("true")) {
                z = false;
            }
            parseDebug = z;
        } catch (SecurityException unused) {
        }
    }

    public BODYSTRUCTURE(FetchResponse fetchResponse) throws ParsingException {
        this.lines = -1;
        this.size = -1;
        if (parseDebug) {
            System.out.println("DEBUG IMAP: parsing BODYSTRUCTURE");
        }
        this.msgno = fetchResponse.getNumber();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: msgno " + this.msgno);
        }
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() != 40) {
            throw new ParsingException("BODYSTRUCTURE parse error: missing ``('' at start");
        }
        if (fetchResponse.peekByte() == 40) {
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parsing multipart");
            }
            this.type = "multipart";
            this.processedType = MULTI;
            Vector vector = new Vector(1);
            do {
                vector.addElement(new BODYSTRUCTURE(fetchResponse));
                fetchResponse.skipSpaces();
            } while (fetchResponse.peekByte() == 40);
            BODYSTRUCTURE[] bodystructureArr = new BODYSTRUCTURE[vector.size()];
            this.bodies = bodystructureArr;
            vector.copyInto(bodystructureArr);
            this.subtype = fetchResponse.readString();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: subtype " + this.subtype);
            }
            if (fetchResponse.readByte() == 41) {
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: parse DONE");
                    return;
                }
                return;
            }
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parsing extension data");
            }
            this.cParams = parseParameters(fetchResponse);
            if (fetchResponse.readByte() == 41) {
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: body parameters DONE");
                    return;
                }
                return;
            }
            byte b = fetchResponse.readByte();
            if (b == 40) {
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: parse disposition");
                }
                this.disposition = fetchResponse.readString();
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: disposition " + this.disposition);
                }
                this.dParams = parseParameters(fetchResponse);
                if (fetchResponse.readByte() != 41) {
                    throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition in multipart");
                }
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: disposition DONE");
                }
            } else {
                if (b != 78 && b != 110) {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + "/" + this.subtype + ": bad multipart disposition, b " + ((int) b));
                }
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: disposition NIL");
                }
                fetchResponse.skip(2);
            }
            byte b2 = fetchResponse.readByte();
            if (b2 == 41) {
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: no body-fld-lang");
                    return;
                }
                return;
            }
            if (b2 != 32) {
                throw new ParsingException("BODYSTRUCTURE parse error: missing space after disposition");
            }
            if (fetchResponse.peekByte() == 40) {
                this.language = fetchResponse.readStringList();
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: language len " + this.language.length);
                }
            } else {
                String string = fetchResponse.readString();
                if (string != null) {
                    this.language = new String[]{string};
                    if (parseDebug) {
                        System.out.println("DEBUG IMAP: language " + string);
                    }
                }
            }
            while (fetchResponse.readByte() == 32) {
                parseBodyExtension(fetchResponse);
            }
            return;
        }
        if (parseDebug) {
            System.out.println("DEBUG IMAP: single part");
        }
        this.type = fetchResponse.readString();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: type " + this.type);
        }
        this.processedType = SINGLE;
        this.subtype = fetchResponse.readString();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: subtype " + this.subtype);
        }
        if (this.type == null) {
            this.type = "application";
            this.subtype = "octet-stream";
        }
        this.cParams = parseParameters(fetchResponse);
        if (parseDebug) {
            System.out.println("DEBUG IMAP: cParams " + this.cParams);
        }
        this.f123id = fetchResponse.readString();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: id " + this.f123id);
        }
        this.description = fetchResponse.readString();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: description " + this.description);
        }
        this.encoding = fetchResponse.readString();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: encoding " + this.encoding);
        }
        this.size = fetchResponse.readNumber();
        if (parseDebug) {
            System.out.println("DEBUG IMAP: size " + this.size);
        }
        if (this.size < 0) {
            throw new ParsingException("BODYSTRUCTURE parse error: bad ``size'' element");
        }
        if (this.type.equalsIgnoreCase("text")) {
            this.lines = fetchResponse.readNumber();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: lines " + this.lines);
            }
            if (this.lines < 0) {
                throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
            }
        } else if (this.type.equalsIgnoreCase("message") && this.subtype.equalsIgnoreCase("rfc822")) {
            this.processedType = NESTED;
            this.envelope = new ENVELOPE(fetchResponse);
            this.bodies = new BODYSTRUCTURE[]{new BODYSTRUCTURE(fetchResponse)};
            this.lines = fetchResponse.readNumber();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: lines " + this.lines);
            }
            if (this.lines < 0) {
                throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
            }
        } else {
            fetchResponse.skipSpaces();
            if (Character.isDigit((char) fetchResponse.peekByte())) {
                throw new ParsingException("BODYSTRUCTURE parse error: server erroneously included ``lines'' element with type " + this.type + "/" + this.subtype);
            }
        }
        if (fetchResponse.peekByte() == 41) {
            fetchResponse.readByte();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parse DONE");
                return;
            }
            return;
        }
        this.md5 = fetchResponse.readString();
        if (fetchResponse.readByte() == 41) {
            if (parseDebug) {
                System.out.println("DEBUG IMAP: no MD5 DONE");
                return;
            }
            return;
        }
        byte b3 = fetchResponse.readByte();
        if (b3 == 40) {
            this.disposition = fetchResponse.readString();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: disposition " + this.disposition);
            }
            this.dParams = parseParameters(fetchResponse);
            if (parseDebug) {
                System.out.println("DEBUG IMAP: dParams " + this.dParams);
            }
            if (fetchResponse.readByte() != 41) {
                throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition");
            }
        } else {
            if (b3 != 78 && b3 != 110) {
                throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + "/" + this.subtype + ": bad single part disposition, b " + ((int) b3));
            }
            if (parseDebug) {
                System.out.println("DEBUG IMAP: disposition NIL");
            }
            fetchResponse.skip(2);
        }
        if (fetchResponse.readByte() == 41) {
            if (parseDebug) {
                System.out.println("DEBUG IMAP: disposition DONE");
                return;
            }
            return;
        }
        if (fetchResponse.peekByte() == 40) {
            this.language = fetchResponse.readStringList();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: language len " + this.language.length);
            }
        } else {
            String string2 = fetchResponse.readString();
            if (string2 != null) {
                this.language = new String[]{string2};
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: language " + string2);
                }
            }
        }
        while (fetchResponse.readByte() == 32) {
            parseBodyExtension(fetchResponse);
        }
        if (parseDebug) {
            System.out.println("DEBUG IMAP: all DONE");
        }
    }

    private void parseBodyExtension(Response response) throws ParsingException {
        response.skipSpaces();
        byte bPeekByte = response.peekByte();
        if (bPeekByte == 40) {
            response.skip(1);
            do {
                parseBodyExtension(response);
            } while (response.readByte() != 41);
        } else if (Character.isDigit((char) bPeekByte)) {
            response.readNumber();
        } else {
            response.readString();
        }
    }

    private ParameterList parseParameters(Response response) throws ParsingException {
        response.skipSpaces();
        byte b = response.readByte();
        if (b != 40) {
            if (b != 78 && b != 110) {
                throw new ParsingException("Parameter list parse error");
            }
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parameter list NIL");
            }
            response.skip(2);
            return null;
        }
        ParameterList parameterList = new ParameterList();
        do {
            String string = response.readString();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parameter name " + string);
            }
            if (string == null) {
                throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + "/" + this.subtype + ": null name in parameter list");
            }
            String string2 = response.readString();
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parameter value " + string2);
            }
            parameterList.set(string, string2);
        } while (response.readByte() != 41);
        parameterList.set(null, "DONE");
        return parameterList;
    }

    public boolean isMulti() {
        return this.processedType == MULTI;
    }

    public boolean isNested() {
        return this.processedType == NESTED;
    }

    public boolean isSingle() {
        return this.processedType == SINGLE;
    }
}
