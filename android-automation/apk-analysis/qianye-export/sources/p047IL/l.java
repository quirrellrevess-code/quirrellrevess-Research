package p047IL;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import p066Ilil.I1I;
import p066Ilil.IL;

/* JADX INFO: renamed from: I丨L.丨l丨, reason: invalid class name */
/* JADX INFO: compiled from: FormBody.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends iILLl {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final L111 f4704I1I = L111.I1I("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final List<String> f4705IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final List<String> f4706ILil;

    /* JADX INFO: renamed from: I丨L.丨l丨$IL1Iii */
    /* JADX INFO: compiled from: FormBody.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        @Nullable
        public final Charset f4707I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final List<String> f4708IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final List<String> f4709ILil;

        public IL1Iii() {
            this(null);
        }

        public l I1I() {
            return new l(this.f4708IL1Iii, this.f4709ILil);
        }

        public IL1Iii IL1Iii(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f4708IL1Iii.add(C0656lIII.I1I(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f4707I1I));
            this.f4709ILil.add(C0656lIII.I1I(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f4707I1I));
            return this;
        }

        public IL1Iii ILil(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f4708IL1Iii.add(C0656lIII.I1I(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f4707I1I));
            this.f4709ILil.add(C0656lIII.I1I(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f4707I1I));
            return this;
        }

        public IL1Iii(@Nullable Charset charset) {
            this.f4708IL1Iii = new ArrayList();
            this.f4709ILil = new ArrayList();
            this.f4707I1I = charset;
        }
    }

    public l(List<String> list, List<String> list2) {
        this.f4705IL1Iii = Util.immutableList(list);
        this.f4706ILil = Util.immutableList(list2);
    }

    public final long IL1Iii(@Nullable IL il, boolean z) {
        I1I i1i = z ? new I1I() : il.IL1Iii();
        int size = this.f4705IL1Iii.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                i1i.l1Lll(38);
            }
            i1i.Liil1L1l(this.f4705IL1Iii.get(i));
            i1i.l1Lll(61);
            i1i.Liil1L1l(this.f4706ILil.get(i));
        }
        if (!z) {
            return 0L;
        }
        long jM96I = i1i.m96I();
        i1i.m2811();
        return jM96I;
    }

    @Override // p047IL.iILLl
    public long contentLength() {
        return IL1Iii(null, true);
    }

    @Override // p047IL.iILLl
    public L111 contentType() {
        return f4704I1I;
    }

    @Override // p047IL.iILLl
    public void writeTo(IL il) throws IOException {
        IL1Iii(il, false);
    }
}
