package com.mysql.jdbc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.SQLXML;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes.dex */
public class JDBC4MysqlSQLXML implements SQLXML {
    private ByteArrayOutputStream asByteArrayOutputStream;
    private DOMResult asDOMResult;
    private SAXResult asSAXResult;
    private StringWriter asStringWriter;
    private int columnIndexOfXml;
    private ExceptionInterceptor exceptionInterceptor;
    private XMLInputFactory inputFactory;
    private XMLOutputFactory outputFactory;
    private ResultSetInternalMethods owningResultSet;
    private SimpleSaxToReader saxToReaderConverter;
    private String stringRep;
    private boolean workingWithResult;
    private boolean isClosed = false;
    private boolean fromResultSet = false;

    public JDBC4MysqlSQLXML(ResultSetInternalMethods resultSetInternalMethods, int i, ExceptionInterceptor exceptionInterceptor) {
        this.owningResultSet = resultSetInternalMethods;
        this.columnIndexOfXml = i;
        this.exceptionInterceptor = exceptionInterceptor;
    }

    private Reader binaryInputStreamStreamToReader(ByteArrayOutputStream byteArrayOutputStream) {
        int next;
        String str = "UTF-8";
        try {
            XMLStreamReader xMLStreamReaderCreateXMLStreamReader = this.inputFactory.createXMLStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            try {
                do {
                    next = xMLStreamReaderCreateXMLStreamReader.next();
                    if (next != 8) {
                    }
                    return new StringReader(new String(byteArrayOutputStream.toByteArray(), str));
                } while (next != 7);
                return new StringReader(new String(byteArrayOutputStream.toByteArray(), str));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            String encoding = xMLStreamReaderCreateXMLStreamReader.getEncoding();
            if (encoding != null) {
                str = encoding;
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void checkClosed() throws SQLException {
        if (this.isClosed) {
            throw SQLError.createSQLException("SQLXMLInstance has been free()d", this.exceptionInterceptor);
        }
    }

    private synchronized void checkWorkingWithResult() throws SQLException {
        if (this.workingWithResult) {
            throw SQLError.createSQLException("Can't perform requested operation after getResult() has been called to write XML data", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
    }

    private synchronized OutputStream setBinaryStreamInternal() throws SQLException {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        this.asByteArrayOutputStream = byteArrayOutputStream;
        return byteArrayOutputStream;
    }

    private synchronized Writer setCharacterStreamInternal() throws SQLException {
        StringWriter stringWriter;
        stringWriter = new StringWriter();
        this.asStringWriter = stringWriter;
        return stringWriter;
    }

    public String domSourceToString() throws SQLException {
        try {
            DOMSource dOMSource = new DOMSource(this.asDOMResult.getNode());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformerNewTransformer.transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Throwable th) {
            SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(th.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            sQLExceptionCreateSQLException.initCause(th);
            throw sQLExceptionCreateSQLException;
        }
    }

    @Override // java.sql.SQLXML
    public synchronized void free() throws SQLException {
        this.stringRep = null;
        this.asDOMResult = null;
        this.asSAXResult = null;
        this.inputFactory = null;
        this.outputFactory = null;
        this.owningResultSet = null;
        this.workingWithResult = false;
        this.isClosed = true;
    }

    @Override // java.sql.SQLXML
    public synchronized InputStream getBinaryStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        return this.owningResultSet.getBinaryStream(this.columnIndexOfXml);
    }

    @Override // java.sql.SQLXML
    public synchronized Reader getCharacterStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        return this.owningResultSet.getCharacterStream(this.columnIndexOfXml);
    }

    @Override // java.sql.SQLXML
    public synchronized <T extends Source> T getSource(Class<T> cls) throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        if (cls != null && !cls.equals(SAXSource.class)) {
            if (cls.equals(DOMSource.class)) {
                try {
                    DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
                    documentBuilderFactoryNewInstance.setNamespaceAware(true);
                    return new DOMSource(documentBuilderFactoryNewInstance.newDocumentBuilder().parse(this.fromResultSet ? new InputSource(this.owningResultSet.getCharacterStream(this.columnIndexOfXml)) : new InputSource(new StringReader(this.stringRep))));
                } catch (Throwable th) {
                    SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(th.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                    sQLExceptionCreateSQLException.initCause(th);
                    throw sQLExceptionCreateSQLException;
                }
            }
            if (cls.equals(StreamSource.class)) {
                return new StreamSource(this.fromResultSet ? this.owningResultSet.getCharacterStream(this.columnIndexOfXml) : new StringReader(this.stringRep));
            }
            if (cls.equals(StAXSource.class)) {
                try {
                    return new StAXSource(this.inputFactory.createXMLStreamReader(this.fromResultSet ? this.owningResultSet.getCharacterStream(this.columnIndexOfXml) : new StringReader(this.stringRep)));
                } catch (XMLStreamException e) {
                    SQLException sQLExceptionCreateSQLException2 = SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                    sQLExceptionCreateSQLException2.initCause(e);
                    throw sQLExceptionCreateSQLException2;
                }
            }
            throw SQLError.createSQLException("XML Source of type \"" + cls.toString() + "\" Not supported.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            throw th;
        }
        return new SAXSource(this.fromResultSet ? new InputSource(this.owningResultSet.getCharacterStream(this.columnIndexOfXml)) : new InputSource(new StringReader(this.stringRep)));
    }

    @Override // java.sql.SQLXML
    public synchronized String getString() throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        if (this.fromResultSet) {
            return this.owningResultSet.getString(this.columnIndexOfXml);
        }
        return this.stringRep;
    }

    public synchronized boolean isEmpty() throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        if (this.fromResultSet) {
            return false;
        }
        String str = this.stringRep;
        return str == null || str.length() == 0;
    }

    public String readerToString(Reader reader) throws SQLException {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[512];
        while (true) {
            try {
                int i = reader.read(cArr);
                if (i == -1) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i);
            } catch (IOException e) {
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                sQLExceptionCreateSQLException.initCause(e);
                throw sQLExceptionCreateSQLException;
            }
        }
    }

    public synchronized Reader serializeAsCharacterStream() throws SQLException {
        checkClosed();
        if (this.workingWithResult) {
            if (this.stringRep != null) {
                return new StringReader(this.stringRep);
            }
            if (this.asDOMResult != null) {
                return new StringReader(domSourceToString());
            }
            if (this.asStringWriter != null) {
                return new StringReader(this.asStringWriter.toString());
            }
            if (this.asSAXResult != null) {
                return this.saxToReaderConverter.toReader();
            }
            ByteArrayOutputStream byteArrayOutputStream = this.asByteArrayOutputStream;
            if (byteArrayOutputStream != null) {
                return binaryInputStreamStreamToReader(byteArrayOutputStream);
            }
        }
        return this.owningResultSet.getCharacterStream(this.columnIndexOfXml);
    }

    public synchronized String serializeAsString() throws SQLException {
        checkClosed();
        if (this.workingWithResult) {
            String str = this.stringRep;
            if (str != null) {
                return str;
            }
            if (this.asDOMResult != null) {
                return domSourceToString();
            }
            StringWriter stringWriter = this.asStringWriter;
            if (stringWriter != null) {
                return stringWriter.toString();
            }
            if (this.asSAXResult != null) {
                return readerToString(this.saxToReaderConverter.toReader());
            }
            ByteArrayOutputStream byteArrayOutputStream = this.asByteArrayOutputStream;
            if (byteArrayOutputStream != null) {
                return readerToString(binaryInputStreamStreamToReader(byteArrayOutputStream));
            }
        }
        return this.owningResultSet.getString(this.columnIndexOfXml);
    }

    @Override // java.sql.SQLXML
    public synchronized OutputStream setBinaryStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        this.workingWithResult = true;
        return setBinaryStreamInternal();
    }

    @Override // java.sql.SQLXML
    public synchronized Writer setCharacterStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        this.workingWithResult = true;
        return setCharacterStreamInternal();
    }

    @Override // java.sql.SQLXML
    public synchronized <T extends Result> T setResult(Class<T> cls) throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        this.workingWithResult = true;
        this.asDOMResult = null;
        this.asSAXResult = null;
        this.saxToReaderConverter = null;
        this.stringRep = null;
        this.asStringWriter = null;
        this.asByteArrayOutputStream = null;
        if (cls != null && !cls.equals(SAXResult.class)) {
            if (cls.equals(DOMResult.class)) {
                DOMResult dOMResult = new DOMResult();
                this.asDOMResult = dOMResult;
                return dOMResult;
            }
            if (cls.equals(StreamResult.class)) {
                return new StreamResult(setCharacterStreamInternal());
            }
            if (!cls.equals(StAXResult.class)) {
                throw SQLError.createSQLException("XML Result of type \"" + cls.toString() + "\" Not supported.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            }
            try {
                if (this.outputFactory == null) {
                    this.outputFactory = XMLOutputFactory.newInstance();
                }
                return new StAXResult(this.outputFactory.createXMLEventWriter(setCharacterStreamInternal()));
            } catch (XMLStreamException e) {
                SQLException sQLExceptionCreateSQLException = SQLError.createSQLException(e.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                sQLExceptionCreateSQLException.initCause(e);
                throw sQLExceptionCreateSQLException;
            }
        }
        this.saxToReaderConverter = new SimpleSaxToReader();
        SAXResult sAXResult = new SAXResult(this.saxToReaderConverter);
        this.asSAXResult = sAXResult;
        return sAXResult;
    }

    @Override // java.sql.SQLXML
    public synchronized void setString(String str) throws SQLException {
        checkClosed();
        checkWorkingWithResult();
        this.stringRep = str;
        this.fromResultSet = false;
    }

    public class SimpleSaxToReader extends DefaultHandler {
        public StringBuilder buf = new StringBuilder();
        private boolean inCDATA = false;

        public SimpleSaxToReader() {
        }

        private void escapeCharsForXml(String str, boolean z) {
            if (str == null) {
                return;
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                escapeCharsForXml(str.charAt(i), z);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (this.inCDATA) {
                this.buf.append(cArr, i, i2);
            } else {
                escapeCharsForXml(cArr, i, i2, false);
            }
        }

        public void comment(char[] cArr, int i, int i2) throws SAXException {
            this.buf.append("<!--");
            for (int i3 = 0; i3 < i2; i3++) {
                this.buf.append(cArr[i + i3]);
            }
            this.buf.append("-->");
        }

        public void endCDATA() throws SAXException {
            this.inCDATA = false;
            this.buf.append("]]>");
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
            characters(cArr, i, i2);
        }

        public void startCDATA() throws SAXException {
            this.buf.append("<![CDATA[");
            this.inCDATA = true;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            this.buf.append("<?xml version='1.0' encoding='UTF-8'?>");
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            this.buf.append("<");
            this.buf.append(str3);
            if (attributes != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    this.buf.append(" ");
                    StringBuilder sb = this.buf;
                    sb.append(attributes.getQName(i));
                    sb.append("=\"");
                    escapeCharsForXml(attributes.getValue(i), true);
                    this.buf.append("\"");
                }
            }
            this.buf.append(">");
        }

        public Reader toReader() {
            return new StringReader(this.buf.toString());
        }

        private void escapeCharsForXml(char[] cArr, int i, int i2, boolean z) {
            if (cArr == null) {
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                escapeCharsForXml(cArr[i + i3], z);
            }
        }

        private void escapeCharsForXml(char c, boolean z) {
            if (c == '\r') {
                this.buf.append("&#xD;");
                return;
            }
            if (c == '\"') {
                if (!z) {
                    this.buf.append("\"");
                    return;
                } else {
                    this.buf.append("&quot;");
                    return;
                }
            }
            if (c == '&') {
                this.buf.append("&amp;");
                return;
            }
            if (c == '<') {
                this.buf.append("&lt;");
                return;
            }
            if (c == '>') {
                this.buf.append("&gt;");
                return;
            }
            if ((c < 1 || c > 31 || c == '\t' || c == '\n') && ((c < 127 || c > 159) && c != 8232 && (!z || (c != '\t' && c != '\n')))) {
                this.buf.append(c);
                return;
            }
            this.buf.append("&#x");
            this.buf.append(Integer.toHexString(c).toUpperCase());
            this.buf.append(";");
        }
    }

    public JDBC4MysqlSQLXML(ExceptionInterceptor exceptionInterceptor) {
        this.exceptionInterceptor = exceptionInterceptor;
    }
}
