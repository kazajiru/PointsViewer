package app.daniyar.pointsviewer.server;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IServerAPI {
    @POST("/mobws/json/pointsList")
    @FormUrlEncoded
    Call<ResponseData> loadPoints(@Field("count") Integer count, @Field("version") String version);
}
