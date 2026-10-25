package com.tencent.smtt.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProxyConfig {
    public static final String MATCH_ALL_SCHEMES = "*";

    /* JADX INFO: renamed from: a */
    private List<ProxyRule> f173a;

    /* JADX INFO: renamed from: b */
    private List<String> f174b;

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private List<ProxyRule> f175a;

        /* JADX INFO: renamed from: b */
        private List<String> f176b;

        public Builder() {
            this.f175a = new ArrayList();
            this.f176b = new ArrayList();
        }

        public Builder(ProxyConfig proxyConfig) {
            this.f175a = proxyConfig.getProxyRules();
            this.f176b = proxyConfig.getBypassRules();
        }

        /* JADX INFO: renamed from: a */
        private List<ProxyRule> m144a() {
            return this.f175a;
        }

        /* JADX INFO: renamed from: b */
        private List<String> m145b() {
            return this.f176b;
        }

        public Builder addBypassRule(String str) {
            this.f176b.add(str);
            return this;
        }

        public Builder addDirect() {
            return addDirect("*");
        }

        public Builder addDirect(String str) {
            this.f175a.add(new ProxyRule(str, "direct://"));
            return this;
        }

        public Builder addProxyRule(String str) {
            this.f175a.add(new ProxyRule(str));
            return this;
        }

        public Builder addProxyRule(String str, String str2) {
            this.f175a.add(new ProxyRule(str2, str));
            return this;
        }

        public ProxyConfig build() {
            return new ProxyConfig(m144a(), m145b());
        }

        public Builder bypassSimpleHostnames() {
            return addBypassRule("<local>");
        }

        public Builder removeImplicitRules() {
            return addBypassRule("<-loopback>");
        }
    }

    public static final class ProxyRule {

        /* JADX INFO: renamed from: a */
        private String f177a;

        /* JADX INFO: renamed from: b */
        private String f178b;

        public ProxyRule(String str) {
            this("*", str);
        }

        public ProxyRule(String str, String str2) {
            this.f177a = str;
            this.f178b = str2;
        }

        public String getSchemeFilter() {
            return this.f177a;
        }

        public String getUrl() {
            return this.f178b;
        }
    }

    public ProxyConfig(List<ProxyRule> list, List<String> list2) {
        this.f173a = list;
        this.f174b = list2;
    }

    public List<String> getBypassRules() {
        return Collections.unmodifiableList(this.f174b);
    }

    public List<ProxyRule> getProxyRules() {
        return Collections.unmodifiableList(this.f173a);
    }
}
