package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import p047IL.L111;
import p047IL.iILLl;
import p066Ilil.I1I;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class GsonRequestBodyConverter<T> implements Converter<T, iILLl> {
    private static final L111 MEDIA_TYPE = L111.I1I("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // retrofit2.Converter
    public iILLl convert(T t) throws IOException {
        I1I i1i = new I1I();
        JsonWriter jsonWriterNewJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(i1i.mo2783L1l(), UTF_8));
        this.adapter.write(jsonWriterNewJsonWriter, t);
        jsonWriterNewJsonWriter.close();
        return iILLl.create(MEDIA_TYPE, i1i.m98i1());
    }
}
