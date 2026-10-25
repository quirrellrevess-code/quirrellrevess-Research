package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class ListInfo {
    public static final int CHANGED = 1;
    public static final int INDETERMINATE = 3;
    public static final int UNCHANGED = 2;
    public String[] attrs;
    public boolean canOpen;
    public int changeState;
    public boolean hasInferiors;
    public String name;
    public char separator;

    public ListInfo(IMAPResponse iMAPResponse) throws ParsingException {
        this.name = null;
        this.separator = '/';
        this.hasInferiors = true;
        this.canOpen = true;
        this.changeState = 3;
        String[] simpleList = iMAPResponse.readSimpleList();
        Vector vector = new Vector();
        if (simpleList != null) {
            for (int i = 0; i < simpleList.length; i++) {
                if (simpleList[i].equalsIgnoreCase("\\Marked")) {
                    this.changeState = 1;
                } else if (simpleList[i].equalsIgnoreCase("\\Unmarked")) {
                    this.changeState = 2;
                } else if (simpleList[i].equalsIgnoreCase("\\Noselect")) {
                    this.canOpen = false;
                } else if (simpleList[i].equalsIgnoreCase("\\Noinferiors")) {
                    this.hasInferiors = false;
                }
                vector.addElement(simpleList[i]);
            }
        }
        String[] strArr = new String[vector.size()];
        this.attrs = strArr;
        vector.copyInto(strArr);
        iMAPResponse.skipSpaces();
        if (iMAPResponse.readByte() == 34) {
            char c = (char) iMAPResponse.readByte();
            this.separator = c;
            if (c == '\\') {
                this.separator = (char) iMAPResponse.readByte();
            }
            iMAPResponse.skip(1);
        } else {
            iMAPResponse.skip(2);
        }
        iMAPResponse.skipSpaces();
        String atomString = iMAPResponse.readAtomString();
        this.name = atomString;
        this.name = BASE64MailboxDecoder.decode(atomString);
    }
}
