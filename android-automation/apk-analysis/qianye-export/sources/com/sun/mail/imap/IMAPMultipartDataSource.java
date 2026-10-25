package com.sun.mail.imap;

import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.Vector;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

/* JADX INFO: loaded from: classes.dex */
public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {
    private Vector parts;

    public IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        this.parts = new Vector(bodystructureArr.length);
        for (int i = 0; i < bodystructureArr.length; i++) {
            this.parts.addElement(new IMAPBodyPart(bodystructureArr[i], str == null ? Integer.toString(i + 1) : String.valueOf(str) + "." + Integer.toString(i + 1), iMAPMessage));
        }
    }

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i) throws MessagingException {
        return (BodyPart) this.parts.elementAt(i);
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.parts.size();
    }
}
