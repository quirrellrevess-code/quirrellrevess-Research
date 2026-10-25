package com.main.request;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class CheckResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private IL1Iii data;

    @SerializedName("msg")
    private String msg;

    public class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        @SerializedName("pkid")
        private String f5360I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        @SerializedName("timestamp")
        private long f5361IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        @SerializedName("sign")
        private String f5362ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        @SerializedName("encryptBizString")
        private String f5363Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        @SerializedName("nonce")
        private String f2891IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        @SerializedName("key")
        private String f2892lLi1LL;

        public String I1I() {
            return this.f5360I1I;
        }

        public String IL1Iii() {
            return this.f5363Ilil;
        }

        public String ILil() {
            return this.f2892lLi1LL;
        }
    }

    public int getCode() {
        return this.code;
    }

    public IL1Iii getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }
}
