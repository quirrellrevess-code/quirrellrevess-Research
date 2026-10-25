package I1I.p062Ilil.p063IL1Iii.I1I;

import android.os.AsyncTask;
import com.p000nx.assist.lua.IOnMailResult;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* JADX INFO: compiled from: MailManager.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3428IL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{8, 2, 15, 88, 25, 71, 8, 23, 22, 26, 95, 91, 22, 23}, I1I.IL1Iii.IL1Iii(new byte[]{82, 87, 80, 87, 2, 12}, I1I.IL1Iii.IL1Iii(new byte[]{83, 80, 80, 86, 3, 9}, "ddf561")));

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static final String f3429ILil = I1I.IL1Iii.IL1Iii(new byte[]{92, 86, 81, 8, 24, 17, 92, 67, 72, 74, 87, 23, 69, 95}, I1I.IL1Iii.IL1Iii(new byte[]{84, 3, 10, 87, 82, 90}, I1I.IL1Iii.IL1Iii(new byte[]{7, 4, 4, 80, 80, 11}, "b06c43")));

    /* JADX INFO: renamed from: I1I.Ilil.IL1Iii.I1I.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MailManager.java */
    public class AsyncTaskC0535I1I extends AsyncTask<Void, Void, Boolean> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public MimeMessage f3430IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public IOnMailResult f3431ILil;

        public AsyncTaskC0535I1I(I1I i1i, MimeMessage mimeMessage, IOnMailResult iOnMailResult) {
            this.f3431ILil = null;
            this.f3430IL1Iii = mimeMessage;
            this.f3431ILil = iOnMailResult;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                Transport.send(this.f3430IL1Iii);
                IOnMailResult iOnMailResult = this.f3431ILil;
                if (iOnMailResult != null) {
                    iOnMailResult.onSuccess();
                }
                return Boolean.TRUE;
            } catch (MessagingException e) {
                e.printStackTrace();
                IOnMailResult iOnMailResult2 = this.f3431ILil;
                if (iOnMailResult2 != null) {
                    iOnMailResult2.onFailed(e.toString());
                }
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: compiled from: MailManager.java */
    public class IL1Iii extends Authenticator {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f3432IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f3433ILil;

        public IL1Iii(I1I i1i, String str, String str2) {
            this.f3432IL1Iii = str;
            this.f3433ILil = str2;
        }

        @Override // javax.mail.Authenticator
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.f3432IL1Iii, this.f3433ILil);
        }
    }

    /* JADX INFO: compiled from: MailManager.java */
    public static class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static I1I f3434IL1Iii = new I1I(null);
    }

    public /* synthetic */ I1I(IL1Iii iL1Iii) {
        this();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static I1I m1229IL() {
        return ILil.f3434IL1Iii;
    }

    public final MimeMessage I1I(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Properties properties = System.getProperties();
        properties.put(f3428IL1Iii, str4);
        properties.put(f3429ILil, String.valueOf(z));
        MimeMessage mimeMessage = new MimeMessage(Session.getInstance(properties, new IL1Iii(this, str, str2)));
        try {
            mimeMessage.setFrom(new InternetAddress(str));
            mimeMessage.setRecipients(Message.RecipientType.f862TO, new InternetAddress[]{new InternetAddress(str3)});
            mimeMessage.setSubject(str5);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(str6, I1I.IL1Iii.IL1Iii(new byte[]{16, 82, 76, 76, 24, 9, 16, 90, 88, 3, 84, 9, 5, 69, 71, 93, 67, 92, 17, 67, 82, 0}, I1I.IL1Iii.IL1Iii(new byte[]{80, 82, 1, 11, 81, 88}, I1I.IL1Iii.IL1Iii(new byte[]{86, 86, 6, 5, 82, 14}, "b33647"))));
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(mimeBodyPart);
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mimeMessage;
    }

    public final void IL1Iii(MimeMessage mimeMessage, String str) {
        try {
            Multipart multipart = (Multipart) mimeMessage.getContent();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.attachFile(str);
            multipart.addBodyPart(mimeBodyPart);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e2) {
            e2.printStackTrace();
        }
    }

    public final void ILil(MimeMessage mimeMessage, List<String> list) {
        try {
            Multipart multipart = (Multipart) mimeMessage.getContent();
            for (String str : list) {
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.attachFile(str);
                multipart.addBodyPart(mimeBodyPart);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e2) {
            e2.printStackTrace();
        }
    }

    public void Ilil(String str, String str2, String str3, String str4, boolean z, String str5, String str6, IOnMailResult iOnMailResult) {
        new AsyncTaskC0535I1I(this, I1I(str, str2, str3, str4, z, str5, str6), iOnMailResult).execute(new Void[0]);
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m1230iILLL1(String str, String str2, String str3, String str4, boolean z, String str5, String str6, List<String> list, IOnMailResult iOnMailResult) {
        MimeMessage mimeMessageI1I = I1I(str, str2, str3, str4, z, str5, str6);
        ILil(mimeMessageI1I, list);
        new AsyncTaskC0535I1I(this, mimeMessageI1I, iOnMailResult).execute(new Void[0]);
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1231lLi1LL(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, IOnMailResult iOnMailResult) {
        MimeMessage mimeMessageI1I = I1I(str, str2, str3, str4, z, str5, str6);
        IL1Iii(mimeMessageI1I, str7);
        new AsyncTaskC0535I1I(this, mimeMessageI1I, iOnMailResult).execute(new Void[0]);
    }

    public I1I() {
    }
}
