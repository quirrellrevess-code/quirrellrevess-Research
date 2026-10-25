package com.sun.mail.smtp;

import javax.mail.Session;
import javax.mail.URLName;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class SMTPSSLTransport extends SMTPTransport {
    public SMTPSSLTransport(Session session, URLName uRLName) {
        super(session, uRLName, "smtps", Videoio.CAP_PROP_XI_IS_COOLED, true);
    }
}
