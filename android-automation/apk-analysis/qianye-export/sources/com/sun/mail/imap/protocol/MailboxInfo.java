package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import javax.mail.Flags;

/* JADX INFO: loaded from: classes.dex */
public class MailboxInfo {
    public Flags availableFlags;
    public int first;
    public int mode;
    public Flags permanentFlags;
    public int recent;
    public int total;
    public long uidnext;
    public long uidvalidity;

    /* JADX WARN: Code duplicated, block: B:48:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00db  */
    public MailboxInfo(Response[] responseArr) throws ParsingException {
        boolean z;
        this.availableFlags = null;
        this.permanentFlags = null;
        this.total = -1;
        this.recent = -1;
        this.first = -1;
        this.uidvalidity = -1L;
        this.uidnext = -1L;
        for (int i = 0; i < responseArr.length; i++) {
            if (responseArr[i] != null && (responseArr[i] instanceof IMAPResponse)) {
                IMAPResponse iMAPResponse = (IMAPResponse) responseArr[i];
                if (iMAPResponse.keyEquals("EXISTS")) {
                    this.total = iMAPResponse.getNumber();
                    responseArr[i] = null;
                } else if (iMAPResponse.keyEquals("RECENT")) {
                    this.recent = iMAPResponse.getNumber();
                    responseArr[i] = null;
                } else if (iMAPResponse.keyEquals("FLAGS")) {
                    this.availableFlags = new FLAGS(iMAPResponse);
                    responseArr[i] = null;
                } else if (iMAPResponse.isUnTagged() && iMAPResponse.isOK()) {
                    iMAPResponse.skipSpaces();
                    if (iMAPResponse.readByte() != 91) {
                        iMAPResponse.reset();
                    } else {
                        String atom = iMAPResponse.readAtom();
                        if (atom.equalsIgnoreCase("UNSEEN")) {
                            this.first = iMAPResponse.readNumber();
                        } else if (atom.equalsIgnoreCase("UIDVALIDITY")) {
                            this.uidvalidity = iMAPResponse.readLong();
                        } else if (atom.equalsIgnoreCase("PERMANENTFLAGS")) {
                            this.permanentFlags = new FLAGS(iMAPResponse);
                        } else {
                            if (atom.equalsIgnoreCase("UIDNEXT")) {
                                this.uidnext = iMAPResponse.readLong();
                            } else {
                                z = false;
                            }
                            if (z) {
                                responseArr[i] = null;
                            } else {
                                iMAPResponse.reset();
                            }
                        }
                        z = true;
                        if (z) {
                            responseArr[i] = null;
                        } else {
                            iMAPResponse.reset();
                        }
                    }
                }
            }
        }
        if (this.permanentFlags == null) {
            Flags flags = this.availableFlags;
            if (flags != null) {
                this.permanentFlags = new Flags(flags);
            } else {
                this.permanentFlags = new Flags();
            }
        }
    }
}
