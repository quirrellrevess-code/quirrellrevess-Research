package javax.mail;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public abstract class Multipart {
    public Part parent;
    public Vector parts = new Vector();
    public String contentType = "multipart/mixed";

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.addElement(bodyPart);
        bodyPart.setParent(this);
    }

    public synchronized BodyPart getBodyPart(int i) throws MessagingException {
        Vector vector;
        vector = this.parts;
        if (vector == null) {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
        return (BodyPart) vector.elementAt(i);
    }

    public String getContentType() {
        return this.contentType;
    }

    public synchronized int getCount() throws MessagingException {
        Vector vector = this.parts;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public synchronized Part getParent() {
        return this.parent;
    }

    public synchronized boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        boolean zRemoveElement;
        Vector vector = this.parts;
        if (vector == null) {
            throw new MessagingException("No such body part");
        }
        zRemoveElement = vector.removeElement(bodyPart);
        bodyPart.setParent(null);
        return zRemoveElement;
    }

    public synchronized void setMultipartDataSource(MultipartDataSource multipartDataSource) throws MessagingException {
        this.contentType = multipartDataSource.getContentType();
        int count = multipartDataSource.getCount();
        for (int i = 0; i < count; i++) {
            addBodyPart(multipartDataSource.getBodyPart(i));
        }
    }

    public synchronized void setParent(Part part) {
        this.parent = part;
    }

    public abstract void writeTo(OutputStream outputStream) throws MessagingException, IOException;

    public synchronized void addBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.insertElementAt(bodyPart, i);
        bodyPart.setParent(this);
    }

    public synchronized void removeBodyPart(int i) throws MessagingException {
        Vector vector = this.parts;
        if (vector != null) {
            BodyPart bodyPart = (BodyPart) vector.elementAt(i);
            this.parts.removeElementAt(i);
            bodyPart.setParent(null);
        } else {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
    }
}
