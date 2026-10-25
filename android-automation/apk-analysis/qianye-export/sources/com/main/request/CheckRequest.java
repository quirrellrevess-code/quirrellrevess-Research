package com.main.request;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class CheckRequest {

    @SerializedName("imei")
    private String imei;

    @SerializedName("packageName")
    private String packageName;

    @SerializedName("uphash")
    private String uphash;

    public CheckRequest(String str, String str2, String str3) {
        this.packageName = str;
        this.uphash = str2;
        this.imei = str3;
    }
}
