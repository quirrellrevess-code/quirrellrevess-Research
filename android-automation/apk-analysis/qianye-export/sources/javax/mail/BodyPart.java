package javax.mail;

/* JADX INFO: loaded from: classes.dex */
public abstract class BodyPart implements Part {
    public Multipart parent;

    public Multipart getParent() {
        return this.parent;
    }

    public void setParent(Multipart multipart) {
        this.parent = multipart;
    }
}
