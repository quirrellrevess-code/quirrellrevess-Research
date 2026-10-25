package com.sun.mail.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import myjava.awt.datatransfer.DataFlavor;

/* JADX INFO: loaded from: classes.dex */
public class message_rfc822 implements DataContentHandler {
    public ActivationDataFlavor ourDataFlavor = new ActivationDataFlavor(Message.class, "message/rfc822", "Message");

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new MimeMessage(dataSource instanceof MessageAware ? ((MessageAware) dataSource).getMessageContext().getSession() : Session.getDefaultInstance(new Properties(), null), dataSource.getInputStream());
        } catch (MessagingException e) {
            throw new IOException("Exception creating MimeMessage in message/rfc822 DataContentHandler: " + e.toString());
        }
    }

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws IOException {
        if (this.ourDataFlavor.equals(dataFlavor)) {
            return getContent(dataSource);
        }
        return null;
    }

    @Override // javax.activation.DataContentHandler
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{this.ourDataFlavor};
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (!(obj instanceof Message)) {
            throw new IOException("unsupported object");
        }
        try {
            ((Message) obj).writeTo(outputStream);
        } catch (MessagingException e) {
            throw new IOException(e.toString());
        }
    }
}
