package I1I.I1I.I1I;

import com.main.request.AdVertRequest;
import com.main.request.CheckRequest;
import com.main.request.CheckResponse;
import java.util.concurrent.TimeUnit;
import p047IL.C0007;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: compiled from: ApiClient.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public static final String f3080IL1Iii = I1I.IL1Iii.IL1Iii(new byte[]{12, 17, 64, 71, 14, 30, 75, 9, 70, 86, 68, 88, 74, 13, 81, 79, 93, 95, 29, 75, 87, 88, 89, 30, 8, 23, 27}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 5, 2, 86, 82}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 82, 2, 6, 0}, "0cc7dc")));

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public static Retrofit f3081ILil;

    /* JADX INFO: compiled from: ApiClient.java */
    public interface IL1Iii {
        @Headers({"Cache-Control: no-cache"})
        @POST("getadvert_enc")
        Call<CheckResponse> IL1Iii(@Body AdVertRequest adVertRequest);

        @Headers({"Cache-Control: no-cache"})
        @POST("checklua_enc")
        Call<CheckResponse> ILil(@Body CheckRequest checkRequest);
    }

    public static Retrofit IL1Iii() {
        if (f3081ILil == null) {
            C0007.ILil iLil = new C0007.ILil();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            iLil.ILil(5L, timeUnit);
            iLil.Ilil(5L, timeUnit);
            f3081ILil = new Retrofit.Builder().baseUrl(f3080IL1Iii).client(iLil.IL1Iii()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return f3081ILil;
    }
}
