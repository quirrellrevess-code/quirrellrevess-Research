package com.mysql.jdbc;

import com.mysql.jdbc.util.Base64Decoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class ExportControlled {
    private static final String SQL_STATE_BAD_SSL_PARAMS = "08000";
    private static final String TLSv1_2 = "TLSv1.2";
    private static final String TLSv1_1 = "TLSv1.1";
    private static final String TLSv1 = "TLSv1";
    private static final String[] TLS_PROTOCOLS = {TLSv1_2, TLSv1_1, TLSv1};

    public static class StandardSSLSocketFactory implements SocketFactory, SocketMetadata {
        private final Socket existingSocket;
        private final SocketFactory existingSocketFactory;
        private SSLSocket rawSocket = null;
        private final SSLSocketFactory sslFact;

        public StandardSSLSocketFactory(SSLSocketFactory sSLSocketFactory, SocketFactory socketFactory, Socket socket) {
            this.sslFact = sSLSocketFactory;
            this.existingSocketFactory = socketFactory;
            this.existingSocket = socket;
        }

        @Override // com.mysql.jdbc.SocketFactory
        public Socket afterHandshake() throws IOException {
            this.existingSocketFactory.afterHandshake();
            return this.rawSocket;
        }

        @Override // com.mysql.jdbc.SocketFactory
        public Socket beforeHandshake() throws IOException {
            return this.rawSocket;
        }

        @Override // com.mysql.jdbc.SocketFactory
        public Socket connect(String str, int i, Properties properties) throws IOException {
            SSLSocket sSLSocket = (SSLSocket) this.sslFact.createSocket(this.existingSocket, str, i, true);
            this.rawSocket = sSLSocket;
            return sSLSocket;
        }

        @Override // com.mysql.jdbc.SocketMetadata
        public boolean isLocallyConnected(ConnectionImpl connectionImpl) throws SQLException {
            return SocketMetadata.Helper.isLocallyConnected(connectionImpl);
        }
    }

    private ExportControlled() {
    }

    public static RSAPublicKey decodeRSAPublicKey(String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            if (str == null) {
                throw new SQLException("key parameter is null");
            }
            int iIndexOf = str.indexOf("\n") + 1;
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Decoder.decode(str.getBytes(), iIndexOf, str.indexOf("-----END PUBLIC KEY-----") - iIndexOf)));
        } catch (Exception e) {
            throw SQLError.createSQLException("Unable to decode public key", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, e, exceptionInterceptor);
        }
    }

    public static boolean enabled() {
        return true;
    }

    public static byte[] encryptWithRSAPublicKey(byte[] bArr, RSAPublicKey rSAPublicKey, String str, ExceptionInterceptor exceptionInterceptor) throws SQLException {
        try {
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            throw SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, e, exceptionInterceptor);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0233  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x01d6: MOVE (r10 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:71:0x01d6 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r3v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v37 */
    private static SSLSocketFactory getSSLSocketFactoryDefaultOrConfigured(MysqlIO mysqlIO) throws Throwable {
        Object obj;
        KeyManager[] keyManagers;
        InputStream inputStreamOpenStream;
        KeyStore keyStore;
        String clientCertificateKeyStoreUrl = mysqlIO.connection.getClientCertificateKeyStoreUrl();
        String clientCertificateKeyStorePassword = mysqlIO.connection.getClientCertificateKeyStorePassword();
        String clientCertificateKeyStoreType = mysqlIO.connection.getClientCertificateKeyStoreType();
        String trustCertificateKeyStoreUrl = mysqlIO.connection.getTrustCertificateKeyStoreUrl();
        String trustCertificateKeyStorePassword = mysqlIO.connection.getTrustCertificateKeyStorePassword();
        String trustCertificateKeyStoreType = mysqlIO.connection.getTrustCertificateKeyStoreType();
        if (StringUtils.isNullOrEmpty(clientCertificateKeyStoreUrl)) {
            clientCertificateKeyStoreUrl = System.getProperty("javax.net.ssl.keyStore");
            clientCertificateKeyStorePassword = System.getProperty("javax.net.ssl.keyStorePassword");
            clientCertificateKeyStoreType = System.getProperty("javax.net.ssl.keyStoreType");
            if (StringUtils.isNullOrEmpty(clientCertificateKeyStoreType)) {
                clientCertificateKeyStoreType = "JKS";
            }
            if (!StringUtils.isNullOrEmpty(clientCertificateKeyStoreUrl)) {
                try {
                    new URL(clientCertificateKeyStoreUrl);
                } catch (MalformedURLException unused) {
                    clientCertificateKeyStoreUrl = "file:" + clientCertificateKeyStoreUrl;
                }
            }
        }
        String str = clientCertificateKeyStorePassword;
        String str2 = clientCertificateKeyStoreUrl;
        if (StringUtils.isNullOrEmpty(trustCertificateKeyStoreUrl)) {
            trustCertificateKeyStoreUrl = System.getProperty("javax.net.ssl.trustStore");
            trustCertificateKeyStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");
            trustCertificateKeyStoreType = System.getProperty("javax.net.ssl.trustStoreType");
            if (StringUtils.isNullOrEmpty(trustCertificateKeyStoreType)) {
                trustCertificateKeyStoreType = "JKS";
            }
            if (!StringUtils.isNullOrEmpty(trustCertificateKeyStoreUrl)) {
                try {
                    new URL(trustCertificateKeyStoreUrl);
                } catch (MalformedURLException unused2) {
                    trustCertificateKeyStoreUrl = "file:" + trustCertificateKeyStoreUrl;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            ArrayList arrayList2 = arrayList;
            ?? r10 = "]";
            try {
                try {
                    if (StringUtils.isNullOrEmpty(str2)) {
                        trustCertificateKeyStorePassword = trustCertificateKeyStorePassword;
                        trustCertificateKeyStoreType = trustCertificateKeyStoreType;
                        keyManagers = null;
                    } else {
                        try {
                            if (StringUtils.isNullOrEmpty(clientCertificateKeyStoreType)) {
                                keyManagers = null;
                                inputStreamOpenStream = null;
                            } else {
                                KeyStore keyStore2 = KeyStore.getInstance(clientCertificateKeyStoreType);
                                URL url = new URL(str2);
                                char[] charArray = str == null ? new char[0] : str.toCharArray();
                                inputStreamOpenStream = url.openStream();
                                try {
                                    keyStore2.load(inputStreamOpenStream, charArray);
                                    keyManagerFactory.init(keyStore2, charArray);
                                    keyManagers = keyManagerFactory.getKeyManagers();
                                } catch (MalformedURLException unused3) {
                                    throw SQLError.createSQLException(str2 + " does not appear to be a valid URL.", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                } catch (IOException e) {
                                    e = e;
                                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException("Cannot open " + str2 + " [" + e.getMessage() + "]", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                    sQLExceptionCreateSQLException.initCause(e);
                                    throw sQLExceptionCreateSQLException;
                                } catch (KeyStoreException e2) {
                                    e = e2;
                                    throw SQLError.createSQLException("Could not create KeyStore instance [" + e.getMessage() + "]", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                } catch (NoSuchAlgorithmException e3) {
                                    e = e3;
                                    throw SQLError.createSQLException("Unsupported keystore algorithm [" + e.getMessage() + "]", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                } catch (UnrecoverableKeyException unused4) {
                                    throw SQLError.createSQLException("Could not recover keys from client keystore.  Check password?", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                } catch (CertificateException unused5) {
                                    throw SQLError.createSQLException("Could not load client" + clientCertificateKeyStoreType + " keystore from " + str2, mysqlIO.getExceptionInterceptor());
                                } catch (Throwable th) {
                                    th = th;
                                    r10 = inputStreamOpenStream;
                                    if (r10 != 0) {
                                        try {
                                            r10.close();
                                        } catch (IOException unused6) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (inputStreamOpenStream != null) {
                                try {
                                    inputStreamOpenStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                        } catch (MalformedURLException unused8) {
                        } catch (IOException e4) {
                            e = e4;
                        } catch (KeyStoreException e5) {
                            e = e5;
                        } catch (NoSuchAlgorithmException e6) {
                            e = e6;
                        } catch (UnrecoverableKeyException unused9) {
                        } catch (CertificateException unused10) {
                        } catch (Throwable th2) {
                            th = th2;
                            r10 = 0;
                        }
                    }
                    try {
                        try {
                            try {
                                ?? IsNullOrEmpty = StringUtils.isNullOrEmpty(trustCertificateKeyStoreUrl);
                                try {
                                    if (IsNullOrEmpty == 0) {
                                        try {
                                            if (StringUtils.isNullOrEmpty(trustCertificateKeyStoreType)) {
                                                IsNullOrEmpty = 0;
                                                keyStore = null;
                                            } else {
                                                InputStream inputStreamOpenStream2 = new URL(trustCertificateKeyStoreUrl).openStream();
                                                char[] charArray2 = trustCertificateKeyStorePassword == null ? new char[0] : trustCertificateKeyStorePassword.toCharArray();
                                                KeyStore keyStore3 = KeyStore.getInstance(trustCertificateKeyStoreType);
                                                keyStore3.load(inputStreamOpenStream2, charArray2);
                                                IsNullOrEmpty = inputStreamOpenStream2;
                                                keyStore = keyStore3;
                                            }
                                        } catch (MalformedURLException unused11) {
                                            throw SQLError.createSQLException(trustCertificateKeyStoreUrl + " does not appear to be a valid URL.", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                        } catch (IOException e7) {
                                            e = e7;
                                            SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException("Cannot open " + trustCertificateKeyStoreType + " [" + e.getMessage() + "]", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                            sQLExceptionCreateSQLException2.initCause(e);
                                            throw sQLExceptionCreateSQLException2;
                                        } catch (KeyStoreException e8) {
                                            e = e8;
                                            throw SQLError.createSQLException("Could not create KeyStore instance [" + e.getMessage() + "]", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                        } catch (NoSuchAlgorithmException e9) {
                                            e = e9;
                                            throw SQLError.createSQLException("Unsupported keystore algorithm [" + e.getMessage() + "]", SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                        } catch (CertificateException unused12) {
                                            throw SQLError.createSQLException("Could not load trust" + trustCertificateKeyStoreType + " keystore from " + trustCertificateKeyStoreUrl, SQL_STATE_BAD_SSL_PARAMS, 0, false, mysqlIO.getExceptionInterceptor());
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r10 = 0;
                                            if (r10 != 0) {
                                                try {
                                                    r10.close();
                                                } catch (IOException unused13) {
                                                }
                                            }
                                            throw th;
                                        }
                                    } else {
                                        IsNullOrEmpty = 0;
                                        keyStore = null;
                                    }
                                    
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0237: INVOKE (r17v0 ?? I:??[OBJECT, ARRAY]), (r4v17 'keyStore' java.security.KeyStore) VIRTUAL call: javax.net.ssl.TrustManagerFactory.init(java.security.KeyStore):void A[Catch: IOException -> 0x02c4, CertificateException -> 0x02c6, NoSuchAlgorithmException -> 0x02ca, KeyStoreException -> 0x02cc, MalformedURLException -> 0x02cf, all -> 0x0370, MD:(java.security.KeyStore):void throws java.security.KeyStoreException (c)] (LINE:51) in method: com.mysql.jdbc.ExportControlled.getSSLSocketFactoryDefaultOrConfigured(com.mysql.jdbc.MysqlIO):javax.net.ssl.SSLSocketFactory, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                        	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r17v0 ??
                                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                        */
                                    /*
                                        Method dump skipped, instruction units count: 929
                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.mysql.jdbc.ExportControlled.getSSLSocketFactoryDefaultOrConfigured(com.mysql.jdbc.MysqlIO):javax.net.ssl.SSLSocketFactory");
                                }

                                public static boolean isSSLEstablished(MysqlIO mysqlIO) {
                                    return SSLSocket.class.isAssignableFrom(mysqlIO.mysqlConnection.getClass());
                                }

                                /* JADX WARN: Code duplicated, block: B:55:0x0104  */
                                public static void transformSocketToSSLSocket(MysqlIO mysqlIO) throws SQLException {
                                    StandardSSLSocketFactory standardSSLSocketFactory = new StandardSSLSocketFactory(getSSLSocketFactoryDefaultOrConfigured(mysqlIO), mysqlIO.socketFactory, mysqlIO.mysqlConnection);
                                    try {
                                        ArrayList arrayList = null;
                                        mysqlIO.mysqlConnection = standardSSLSocketFactory.connect(mysqlIO.host, mysqlIO.port, null);
                                        String enabledTLSProtocols = mysqlIO.connection.getEnabledTLSProtocols();
                                        ArrayList arrayList2 = new ArrayList(Arrays.asList((enabledTLSProtocols == null || enabledTLSProtocols.length() <= 0) ? (mysqlIO.versionMeetsMinimum(8, 0, 4) || (mysqlIO.versionMeetsMinimum(5, 6, 0) && Util.isEnterpriseEdition(mysqlIO.getServerVersion()))) ? TLS_PROTOCOLS : new String[]{TLSv1_1, TLSv1} : enabledTLSProtocols.split("\\s*,\\s*")));
                                        List listAsList = Arrays.asList(((SSLSocket) mysqlIO.mysqlConnection).getSupportedProtocols());
                                        ArrayList arrayList3 = new ArrayList();
                                        for (String str : TLS_PROTOCOLS) {
                                            if (listAsList.contains(str) && arrayList2.contains(str)) {
                                                arrayList3.add(str);
                                            }
                                        }
                                        ((SSLSocket) mysqlIO.mysqlConnection).setEnabledProtocols((String[]) arrayList3.toArray(new String[0]));
                                        String enabledSSLCipherSuites = mysqlIO.connection.getEnabledSSLCipherSuites();
                                        boolean z = true;
                                        if (enabledSSLCipherSuites != null && enabledSSLCipherSuites.length() > 0) {
                                            arrayList = new ArrayList();
                                            List listAsList2 = Arrays.asList(((SSLSocket) mysqlIO.mysqlConnection).getEnabledCipherSuites());
                                            for (String str2 : enabledSSLCipherSuites.split("\\s*,\\s*")) {
                                                if (listAsList2.contains(str2)) {
                                                    arrayList.add(str2);
                                                }
                                            }
                                        } else {
                                            if ((!mysqlIO.versionMeetsMinimum(5, 5, 45) || mysqlIO.versionMeetsMinimum(5, 6, 0)) && ((!mysqlIO.versionMeetsMinimum(5, 6, 26) || mysqlIO.versionMeetsMinimum(5, 7, 0)) && !mysqlIO.versionMeetsMinimum(5, 7, 6))) {
                                                if (Util.getJVMVersion() < 8) {
                                                    z = false;
                                                }
                                            } else if (Util.getJVMVersion() >= 8) {
                                                z = false;
                                            }
                                            if (z) {
                                                arrayList = new ArrayList();
                                                for (String str3 : ((SSLSocket) mysqlIO.mysqlConnection).getEnabledCipherSuites()) {
                                                    if (!z || (str3.indexOf("_DHE_") <= -1 && str3.indexOf("_DH_") <= -1)) {
                                                        arrayList.add(str3);
                                                    }
                                                }
                                            }
                                        }
                                        if (arrayList != null) {
                                            ((SSLSocket) mysqlIO.mysqlConnection).setEnabledCipherSuites((String[]) arrayList.toArray(new String[0]));
                                        }
                                        ((SSLSocket) mysqlIO.mysqlConnection).startHandshake();
                                        if (mysqlIO.connection.getUseUnbufferedInput()) {
                                            mysqlIO.mysqlInput = mysqlIO.mysqlConnection.getInputStream();
                                        } else {
                                            mysqlIO.mysqlInput = new BufferedInputStream(mysqlIO.mysqlConnection.getInputStream(), 16384);
                                        }
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(mysqlIO.mysqlConnection.getOutputStream(), 16384);
                                        mysqlIO.mysqlOutput = bufferedOutputStream;
                                        bufferedOutputStream.flush();
                                        mysqlIO.socketFactory = standardSSLSocketFactory;
                                    } catch (IOException e) {
                                        throw SQLError.createCommunicationsException(mysqlIO.connection, mysqlIO.getLastPacketSentTimeMs(), mysqlIO.getLastPacketReceivedTimeMs(), e, mysqlIO.getExceptionInterceptor());
                                    }
                                }

                                public static class X509TrustManagerWrapper implements X509TrustManager {
                                    private CertificateFactory certFactory;
                                    private X509TrustManager origTm;
                                    private CertPathValidator validator;
                                    private PKIXParameters validatorParams;
                                    private boolean verifyServerCert;

                                    public X509TrustManagerWrapper(X509TrustManager x509TrustManager, boolean z) throws CertificateException {
                                        this.origTm = null;
                                        this.verifyServerCert = false;
                                        this.certFactory = null;
                                        this.validatorParams = null;
                                        this.validator = null;
                                        this.origTm = x509TrustManager;
                                        this.verifyServerCert = z;
                                        if (z) {
                                            try {
                                                HashSet hashSet = new HashSet();
                                                for (X509Certificate x509Certificate : x509TrustManager.getAcceptedIssuers()) {
                                                    hashSet.add(new TrustAnchor(x509Certificate, null));
                                                }
                                                PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
                                                this.validatorParams = pKIXParameters;
                                                pKIXParameters.setRevocationEnabled(false);
                                                this.validator = CertPathValidator.getInstance("PKIX");
                                                this.certFactory = CertificateFactory.getInstance("X.509");
                                            } catch (Exception e) {
                                                throw new CertificateException(e);
                                            }
                                        }
                                    }

                                    @Override // javax.net.ssl.X509TrustManager
                                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                                        this.origTm.checkClientTrusted(x509CertificateArr, str);
                                    }

                                    @Override // javax.net.ssl.X509TrustManager
                                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                                        for (X509Certificate x509Certificate : x509CertificateArr) {
                                            x509Certificate.checkValidity();
                                        }
                                        if (this.validatorParams != null) {
                                            new X509CertSelector().setSerialNumber(x509CertificateArr[0].getSerialNumber());
                                            try {
                                                ((PKIXCertPathValidatorResult) this.validator.validate(this.certFactory.generateCertPath(Arrays.asList(x509CertificateArr)), this.validatorParams)).getTrustAnchor().getTrustedCert().checkValidity();
                                            } catch (InvalidAlgorithmParameterException e) {
                                                throw new CertificateException(e);
                                            } catch (CertPathValidatorException e2) {
                                                throw new CertificateException(e2);
                                            }
                                        }
                                        if (this.verifyServerCert) {
                                            this.origTm.checkServerTrusted(x509CertificateArr, str);
                                        }
                                    }

                                    @Override // javax.net.ssl.X509TrustManager
                                    public X509Certificate[] getAcceptedIssuers() {
                                        X509TrustManager x509TrustManager = this.origTm;
                                        return x509TrustManager != null ? x509TrustManager.getAcceptedIssuers() : new X509Certificate[0];
                                    }

                                    public X509TrustManagerWrapper() {
                                        this.origTm = null;
                                        this.verifyServerCert = false;
                                        this.certFactory = null;
                                        this.validatorParams = null;
                                        this.validator = null;
                                    }
                                }
                            }
