package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class JsValue {

    /* JADX INFO: renamed from: a */
    private final JsContext f162a;

    /* JADX INFO: renamed from: b */
    private final IX5JsValue f163b;

    /* JADX INFO: renamed from: com.tencent.smtt.sdk.JsValue$a */
    public static class C0354a implements IX5JsValue.JsValueFactory {
        private C0354a() {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public String getJsValueClassName() {
            return JsValue.class.getName();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public IX5JsValue unwrap(Object obj) {
            if (obj == null || !(obj instanceof JsValue)) {
                return null;
            }
            return ((JsValue) obj).f163b;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public Object wrap(IX5JsValue iX5JsValue) {
            JsContext jsContextCurrent;
            if (iX5JsValue == null || (jsContextCurrent = JsContext.current()) == null) {
                return null;
            }
            return new JsValue(jsContextCurrent, iX5JsValue);
        }
    }

    public JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.f162a = jsContext;
        this.f163b = iX5JsValue;
    }

    /* JADX INFO: renamed from: a */
    public static IX5JsValue.JsValueFactory m135a() {
        return new C0354a();
    }

    /* JADX INFO: renamed from: a */
    private JsValue m137a(IX5JsValue iX5JsValue) {
        if (iX5JsValue == null) {
            return null;
        }
        return new JsValue(this.f162a, iX5JsValue);
    }

    public JsValue call(Object... objArr) {
        return m137a(this.f163b.call(objArr));
    }

    public JsValue construct(Object... objArr) {
        return m137a(this.f163b.construct(objArr));
    }

    public JsContext context() {
        return this.f162a;
    }

    public boolean isArray() {
        return this.f163b.isArray();
    }

    public boolean isArrayBufferOrArrayBufferView() {
        return this.f163b.isArrayBufferOrArrayBufferView();
    }

    public boolean isBoolean() {
        return this.f163b.isBoolean();
    }

    public boolean isFunction() {
        return this.f163b.isFunction();
    }

    public boolean isInteger() {
        return this.f163b.isInteger();
    }

    public boolean isJavascriptInterface() {
        return this.f163b.isJavascriptInterface();
    }

    public boolean isNull() {
        return this.f163b.isNull();
    }

    public boolean isNumber() {
        return this.f163b.isNumber();
    }

    public boolean isObject() {
        return this.f163b.isObject();
    }

    public boolean isPromise() {
        return this.f163b.isPromise();
    }

    public boolean isString() {
        return this.f163b.isString();
    }

    public boolean isUndefined() {
        return this.f163b.isUndefined();
    }

    public void reject(Object obj) {
        this.f163b.resolveOrReject(obj, false);
    }

    public void resolve(Object obj) {
        this.f163b.resolveOrReject(obj, true);
    }

    public boolean toBoolean() {
        return this.f163b.toBoolean();
    }

    public ByteBuffer toByteBuffer() {
        return this.f163b.toByteBuffer();
    }

    public int toInteger() {
        return this.f163b.toInteger();
    }

    public Object toJavascriptInterface() {
        return this.f163b.toJavascriptInterface();
    }

    public Number toNumber() {
        return this.f163b.toNumber();
    }

    public <T> T toObject(Class<T> cls) {
        return (T) this.f163b.toObject(cls);
    }

    public String toString() {
        return this.f163b.toString();
    }
}
