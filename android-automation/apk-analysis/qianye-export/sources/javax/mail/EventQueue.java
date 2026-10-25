package javax.mail;

import java.util.Vector;
import javax.mail.event.MailEvent;

/* JADX INFO: loaded from: classes.dex */
public class EventQueue implements Runnable {
    private Thread qThread;
    private QueueElement head = null;
    private QueueElement tail = null;

    public static class QueueElement {
        public MailEvent event;
        public QueueElement next = null;
        public QueueElement prev = null;
        public Vector vector;

        public QueueElement(MailEvent mailEvent, Vector vector) {
            this.event = null;
            this.vector = null;
            this.event = mailEvent;
            this.vector = vector;
        }
    }

    public EventQueue() {
        Thread thread = new Thread(this, "JavaMail-EventQueue");
        this.qThread = thread;
        thread.setDaemon(true);
        this.qThread.start();
    }

    private synchronized QueueElement dequeue() throws InterruptedException {
        QueueElement queueElement;
        while (true) {
            queueElement = this.tail;
            if (queueElement != null) {
                break;
            }
            wait();
        }
        QueueElement queueElement2 = queueElement.prev;
        this.tail = queueElement2;
        if (queueElement2 == null) {
            this.head = null;
        } else {
            queueElement2.next = null;
        }
        queueElement.next = null;
        queueElement.prev = null;
        return queueElement;
    }

    public synchronized void enqueue(MailEvent mailEvent, Vector vector) {
        QueueElement queueElement = new QueueElement(mailEvent, vector);
        QueueElement queueElement2 = this.head;
        if (queueElement2 == null) {
            this.head = queueElement;
            this.tail = queueElement;
        } else {
            queueElement.next = queueElement2;
            queueElement2.prev = queueElement;
            this.head = queueElement;
        }
        notifyAll();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                QueueElement queueElementDequeue = dequeue();
                if (queueElementDequeue == null) {
                    return;
                }
                MailEvent mailEvent = queueElementDequeue.event;
                Vector vector = queueElementDequeue.vector;
                for (int i = 0; i < vector.size(); i++) {
                    try {
                        mailEvent.dispatch(vector.elementAt(i));
                    } catch (Throwable th) {
                        if (th instanceof InterruptedException) {
                            return;
                        }
                    }
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public void stop() {
        Thread thread = this.qThread;
        if (thread != null) {
            thread.interrupt();
            this.qThread = null;
        }
    }
}
