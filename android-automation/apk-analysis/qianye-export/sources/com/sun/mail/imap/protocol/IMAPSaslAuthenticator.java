package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Vector;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.sasl.RealmCallback;
import javax.security.sasl.RealmChoiceCallback;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

/* JADX INFO: loaded from: classes.dex */
public class IMAPSaslAuthenticator implements SaslAuthenticator {
    private boolean debug;
    private String host;
    private String name;
    private PrintStream out;

    /* JADX INFO: renamed from: pr */
    private IMAPProtocol f127pr;
    private Properties props;

    public IMAPSaslAuthenticator(IMAPProtocol iMAPProtocol, String str, Properties properties, boolean z, PrintStream printStream, String str2) {
        this.f127pr = iMAPProtocol;
        this.name = str;
        this.props = properties;
        this.debug = z;
        this.out = printStream;
        this.host = str2;
    }

    @Override // com.sun.mail.imap.protocol.SaslAuthenticator
    public boolean authenticate(String[] strArr, final String str, String str2, final String str3, final String str4) throws ProtocolException {
        String str5;
        byte[] bArrEvaluateChallenge;
        synchronized (this.f127pr) {
            try {
                Vector vector = new Vector();
                if (this.debug) {
                    this.out.print("IMAP SASL DEBUG: Mechanisms:");
                    for (String str6 : strArr) {
                        this.out.print(" " + str6);
                    }
                    this.out.println();
                }
                try {
                    SaslClient saslClientCreateSaslClient = Sasl.createSaslClient(strArr, str2, this.name, this.host, this.props, new CallbackHandler() { // from class: com.sun.mail.imap.protocol.IMAPSaslAuthenticator.1
                        @Override // javax.security.auth.callback.CallbackHandler
                        public void handle(Callback[] callbackArr) {
                            if (IMAPSaslAuthenticator.this.debug) {
                                IMAPSaslAuthenticator.this.out.println("IMAP SASL DEBUG: callback length: " + callbackArr.length);
                            }
                            for (int i = 0; i < callbackArr.length; i++) {
                                if (IMAPSaslAuthenticator.this.debug) {
                                    IMAPSaslAuthenticator.this.out.println("IMAP SASL DEBUG: callback " + i + ": " + callbackArr[i]);
                                }
                                if (callbackArr[i] instanceof NameCallback) {
                                    ((NameCallback) callbackArr[i]).setName(str3);
                                } else if (callbackArr[i] instanceof PasswordCallback) {
                                    ((PasswordCallback) callbackArr[i]).setPassword(str4.toCharArray());
                                } else if (callbackArr[i] instanceof RealmCallback) {
                                    RealmCallback realmCallback = (RealmCallback) callbackArr[i];
                                    String defaultText = str;
                                    if (defaultText == null) {
                                        defaultText = realmCallback.getDefaultText();
                                    }
                                    realmCallback.setText(defaultText);
                                } else if (callbackArr[i] instanceof RealmChoiceCallback) {
                                    RealmChoiceCallback realmChoiceCallback = (RealmChoiceCallback) callbackArr[i];
                                    if (str == null) {
                                        realmChoiceCallback.setSelectedIndex(realmChoiceCallback.getDefaultChoice());
                                    } else {
                                        String[] choices = realmChoiceCallback.getChoices();
                                        for (int i2 = 0; i2 < choices.length; i2++) {
                                            if (choices[i2].equals(str)) {
                                                realmChoiceCallback.setSelectedIndex(i2);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    });
                    if (saslClientCreateSaslClient == null) {
                        if (this.debug) {
                            this.out.println("IMAP SASL DEBUG: No SASL support");
                        }
                        return false;
                    }
                    if (this.debug) {
                        this.out.println("IMAP SASL DEBUG: SASL client " + saslClientCreateSaslClient.getMechanismName());
                    }
                    try {
                        String strWriteCommand = this.f127pr.writeCommand("AUTHENTICATE " + saslClientCreateSaslClient.getMechanismName(), null);
                        OutputStream iMAPOutputStream = this.f127pr.getIMAPOutputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        boolean z = true;
                        byte[] bArr = {13, 10};
                        boolean zEquals = saslClientCreateSaslClient.getMechanismName().equals("XGWTRUSTEDAPP");
                        Response responseByeResponse = null;
                        boolean z2 = false;
                        while (!z2) {
                            try {
                                responseByeResponse = this.f127pr.readResponse();
                                if (responseByeResponse.isContinuation()) {
                                    if (saslClientCreateSaslClient.isComplete()) {
                                        bArrEvaluateChallenge = null;
                                    } else {
                                        byte[] newBytes = responseByeResponse.readByteArray().getNewBytes();
                                        if (newBytes.length > 0) {
                                            newBytes = BASE64DecoderStream.decode(newBytes);
                                        }
                                        if (this.debug) {
                                            this.out.println("IMAP SASL DEBUG: challenge: " + ASCIIUtility.toString(newBytes, 0, newBytes.length) + " :");
                                        }
                                        bArrEvaluateChallenge = saslClientCreateSaslClient.evaluateChallenge(newBytes);
                                    }
                                    if (bArrEvaluateChallenge == null) {
                                        if (this.debug) {
                                            this.out.println("IMAP SASL DEBUG: no response");
                                        }
                                        iMAPOutputStream.write(bArr);
                                        iMAPOutputStream.flush();
                                        byteArrayOutputStream.reset();
                                    } else {
                                        if (this.debug) {
                                            this.out.println("IMAP SASL DEBUG: response: " + ASCIIUtility.toString(bArrEvaluateChallenge, 0, bArrEvaluateChallenge.length) + " :");
                                        }
                                        byte[] bArrEncode = BASE64EncoderStream.encode(bArrEvaluateChallenge);
                                        if (zEquals) {
                                            byteArrayOutputStream.write("XGWTRUSTEDAPP ".getBytes());
                                        }
                                        byteArrayOutputStream.write(bArrEncode);
                                        byteArrayOutputStream.write(bArr);
                                        iMAPOutputStream.write(byteArrayOutputStream.toByteArray());
                                        iMAPOutputStream.flush();
                                        byteArrayOutputStream.reset();
                                    }
                                } else if ((responseByeResponse.isTagged() && responseByeResponse.getTag().equals(strWriteCommand)) || responseByeResponse.isBYE()) {
                                    z2 = true;
                                } else {
                                    vector.addElement(responseByeResponse);
                                }
                            } catch (Exception e) {
                                if (this.debug) {
                                    e.printStackTrace();
                                }
                                responseByeResponse = Response.byeResponse(e);
                            }
                            z = true;
                        }
                        if (saslClientCreateSaslClient.isComplete() && (str5 = (String) saslClientCreateSaslClient.getNegotiatedProperty("javax.security.sasl.qop")) != null && (str5.equalsIgnoreCase("auth-int") || str5.equalsIgnoreCase("auth-conf"))) {
                            if (this.debug) {
                                this.out.println("IMAP SASL DEBUG: Mechanism requires integrity or confidentiality");
                            }
                            return false;
                        }
                        Response[] responseArr = new Response[vector.size()];
                        vector.copyInto(responseArr);
                        this.f127pr.notifyResponseHandlers(responseArr);
                        this.f127pr.handleResult(responseByeResponse);
                        this.f127pr.setCapabilities(responseByeResponse);
                        return z;
                    } catch (Exception e2) {
                        if (this.debug) {
                            this.out.println("IMAP SASL DEBUG: AUTHENTICATE Exception: " + e2);
                        }
                        return false;
                    }
                } catch (SaslException e3) {
                    if (this.debug) {
                        this.out.println("IMAP SASL DEBUG: Failed to create SASL client: " + e3);
                    }
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
