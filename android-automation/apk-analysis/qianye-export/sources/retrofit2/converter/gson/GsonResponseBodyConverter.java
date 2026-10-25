package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import p047IL.LIll;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public final class GsonResponseBodyConverter<T> implements Converter<LIll, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    public T convert(LIll lIll) throws IOException {
        JsonReader jsonReaderNewJsonReader = this.gson.newJsonReader(lIll.charStream());
        try {
            T t = this.adapter.read(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            lIll.close();
            return t;
        } catch (Throwable th) {
            lIll.close();
            throw th;
        }
    }
}
