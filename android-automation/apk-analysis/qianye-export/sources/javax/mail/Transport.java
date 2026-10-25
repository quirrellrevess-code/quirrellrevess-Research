package javax.mail;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transport extends Service {
    private Vector transportListeners;

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
        this.transportListeners = null;
    }

    public static void send(Message message) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients());
    }

    private static void send0(Message message, Address[] addressArr) throws MessagingException {
        Address[] addressArr2;
        Address[] addressArr3;
        if (addressArr == null || addressArr.length == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < addressArr.length; i++) {
            if (hashtable.containsKey(addressArr[i].getType())) {
                ((Vector) hashtable.get(addressArr[i].getType())).addElement(addressArr[i]);
            } else {
                Vector vector4 = new Vector();
                vector4.addElement(addressArr[i]);
                hashtable.put(addressArr[i].getType(), vector4);
            }
        }
        int size = hashtable.size();
        if (size == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Session defaultInstance = message.session;
        Address[] addressArr4 = null;
        if (defaultInstance == null) {
            defaultInstance = Session.getDefaultInstance(System.getProperties(), null);
        }
        if (size == 1) {
            Transport transport = defaultInstance.getTransport(addressArr[0]);
            try {
                transport.connect();
                transport.sendMessage(message, addressArr);
                return;
            } finally {
                transport.close();
            }
        }
        Enumeration enumerationElements = hashtable.elements();
        MessagingException messagingException = null;
        boolean z = false;
        while (enumerationElements.hasMoreElements()) {
            Vector vector5 = (Vector) enumerationElements.nextElement();
            int size2 = vector5.size();
            Address[] addressArr5 = new Address[size2];
            vector5.copyInto(addressArr5);
            Transport transport2 = defaultInstance.getTransport(addressArr5[0]);
            if (transport2 == null) {
                for (int i2 = 0; i2 < size2; i2++) {
                    vector.addElement(addressArr5[i2]);
                }
            } else {
                try {
                    try {
                        transport2.connect();
                        transport2.sendMessage(message, addressArr5);
                        transport2.close();
                    } catch (SendFailedException e) {
                        if (messagingException == null) {
                            messagingException = e;
                        } else {
                            messagingException.setNextException(e);
                        }
                        Address[] invalidAddresses = e.getInvalidAddresses();
                        if (invalidAddresses != null) {
                            for (Address address : invalidAddresses) {
                                vector.addElement(address);
                            }
                        }
                        Address[] validSentAddresses = e.getValidSentAddresses();
                        if (validSentAddresses != null) {
                            for (Address address2 : validSentAddresses) {
                                vector2.addElement(address2);
                            }
                        }
                        Address[] validUnsentAddresses = e.getValidUnsentAddresses();
                        if (validUnsentAddresses != null) {
                            for (Address address3 : validUnsentAddresses) {
                                vector3.addElement(address3);
                            }
                        }
                        transport2.close();
                        z = true;
                    } catch (MessagingException e2) {
                        if (messagingException == null) {
                            messagingException = e2;
                        } else {
                            messagingException.setNextException(e2);
                        }
                        transport2.close();
                        z = true;
                    }
                } catch (Throwable th) {
                    transport2.close();
                    throw th;
                }
            }
        }
        if (!z && vector.size() == 0 && vector3.size() == 0) {
            return;
        }
        if (vector2.size() > 0) {
            Address[] addressArr6 = new Address[vector2.size()];
            vector2.copyInto(addressArr6);
            addressArr2 = addressArr6;
        } else {
            addressArr2 = null;
        }
        if (vector3.size() > 0) {
            Address[] addressArr7 = new Address[vector3.size()];
            vector3.copyInto(addressArr7);
            addressArr3 = addressArr7;
        } else {
            addressArr3 = null;
        }
        if (vector.size() > 0) {
            addressArr4 = new Address[vector.size()];
            vector.copyInto(addressArr4);
        }
        throw new SendFailedException("Sending failed", messagingException, addressArr2, addressArr3, addressArr4);
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        if (this.transportListeners == null) {
            this.transportListeners = new Vector();
        }
        this.transportListeners.addElement(transportListener);
    }

    public void notifyTransportListeners(int i, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners == null) {
            return;
        }
        queueEvent(new TransportEvent(this, i, addressArr, addressArr2, addressArr3, message), this.transportListeners);
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        Vector vector = this.transportListeners;
        if (vector != null) {
            vector.removeElement(transportListener);
        }
    }

    public abstract void sendMessage(Message message, Address[] addressArr) throws MessagingException;

    public static void send(Message message, Address[] addressArr) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr);
    }
}
