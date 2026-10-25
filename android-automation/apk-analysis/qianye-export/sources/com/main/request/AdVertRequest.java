package com.main.request;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class AdVertRequest {

    @SerializedName("isapp")
    private int isapp;

    @SerializedName("packageName")
    private String packageName;

    @SerializedName("uphash")
    private String uphash;

    public AdVertRequest(String str, String str2, int i) {
        this.packageName = str;
        this.uphash = str2;
        this.isapp = i;
    }
}
