package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {

    /* JADX INFO: renamed from: a */
    private static final String f396a = "UrlRequestBuilderImpl";

    /* JADX INFO: renamed from: b */
    private final String f397b;

    /* JADX INFO: renamed from: c */
    private final UrlRequest.Callback f398c;

    /* JADX INFO: renamed from: d */
    private final Executor f399d;

    /* JADX INFO: renamed from: e */
    private String f400e;

    /* JADX INFO: renamed from: g */
    private boolean f402g;

    /* JADX INFO: renamed from: i */
    private String f404i;

    /* JADX INFO: renamed from: j */
    private byte[] f405j;

    /* JADX INFO: renamed from: k */
    private String f406k;

    /* JADX INFO: renamed from: l */
    private String f407l;

    /* JADX INFO: renamed from: f */
    private final ArrayList<Pair<String, String>> f401f = new ArrayList<>();

    /* JADX INFO: renamed from: h */
    private int f403h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        Objects.requireNonNull(str, "URL is required.");
        Objects.requireNonNull(callback, "Callback is required.");
        Objects.requireNonNull(executor, "Executor is required.");
        this.f397b = str;
        this.f398c = callback;
        this.f399d = executor;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        Objects.requireNonNull(str, "Invalid header name.");
        Objects.requireNonNull(str2, "Invalid header value.");
        if ("Accept-Encoding".equalsIgnoreCase(str)) {
            return this;
        }
        this.f401f.add(Pair.create(str, str2));
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        int i;
        C0431u c0431uM530a = C0431u.m530a();
        if (c0431uM530a == null || !c0431uM530a.m534b()) {
            return null;
        }
        DexLoader dexLoaderM558b = c0431uM530a.m535c().m558b();
        Class<?> cls = Integer.TYPE;
        Class<?> cls2 = Boolean.TYPE;
        UrlRequest urlRequest = (UrlRequest) dexLoaderM558b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.f397b, Integer.valueOf(this.f403h), this.f398c, this.f399d, Boolean.valueOf(this.f402g), this.f400e, this.f401f, this.f404i, this.f405j, this.f406k, this.f407l);
        if (urlRequest == null) {
            i = 7;
            urlRequest = (UrlRequest) dexLoaderM558b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class}, this.f397b, Integer.valueOf(this.f403h), this.f398c, this.f399d, Boolean.valueOf(this.f402g), this.f400e, this.f401f, this.f404i);
        } else {
            i = 7;
        }
        if (urlRequest == null) {
            Class<?>[] clsArr = new Class[i];
            clsArr[0] = String.class;
            clsArr[1] = cls;
            clsArr[2] = UrlRequest.Callback.class;
            clsArr[3] = Executor.class;
            clsArr[4] = cls2;
            clsArr[5] = String.class;
            clsArr[6] = ArrayList.class;
            Object[] objArr = new Object[i];
            objArr[0] = this.f397b;
            objArr[1] = Integer.valueOf(this.f403h);
            objArr[2] = this.f398c;
            objArr[3] = this.f399d;
            objArr[4] = Boolean.valueOf(this.f402g);
            objArr[5] = this.f400e;
            objArr[6] = this.f401f;
            urlRequest = (UrlRequest) dexLoaderM558b.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", clsArr, objArr);
        }
        if (urlRequest == null) {
            urlRequest = (UrlRequest) dexLoaderM558b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.f397b, Integer.valueOf(this.f403h), this.f398c, this.f399d, Boolean.valueOf(this.f402g), this.f400e, this.f401f, this.f404i, this.f405j, this.f406k, this.f407l);
        }
        Objects.requireNonNull(urlRequest, "UrlRequest build fail");
        return urlRequest;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.f402g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setDns(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("host and address are required.");
        }
        this.f406k = str;
        this.f407l = str2;
        try {
            C0431u c0431uM530a = C0431u.m530a();
            if (c0431uM530a != null && c0431uM530a.m534b()) {
                c0431uM530a.m535c().m558b().invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "setDns", new Class[]{String.class, String.class}, this.f406k, this.f407l);
            }
        } catch (Exception unused) {
        }
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        Objects.requireNonNull(str, "Method is required.");
        this.f400e = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i) {
        this.f403h = i;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBody(String str) {
        Objects.requireNonNull(str, "Body is required.");
        this.f404i = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        Objects.requireNonNull(bArr, "Body is required.");
        this.f405j = bArr;
        return this;
    }
}
