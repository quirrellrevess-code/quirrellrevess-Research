package com.main.engine;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JIntent {
    private String action;
    private String classname;
    private String data;
    private String datapart;
    private Map<String, Object> extra;
    private String packageName;
    private String uri;

    public String getAction() {
        return this.action;
    }

    public String getClassname() {
        return this.classname;
    }

    public String getData() {
        return this.data;
    }

    public String getDatapart() {
        return this.datapart;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getUri() {
        return this.uri;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setClassname(String str) {
        this.classname = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDatapart(String str) {
        this.datapart = str;
    }

    public void setExtra(Map<String, Object> map) {
        this.extra = map;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
