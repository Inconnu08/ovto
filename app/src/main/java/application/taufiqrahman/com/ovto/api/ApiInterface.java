package application.taufiqrahman.com.ovto.api;

import application.taufiqrahman.com.ovto.DataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Taufiq on 5/8/2018.
 * Interface for API calls
 */

public interface ApiInterface {

    @GET("users")
    Call<DataResponse> getUsers(@Query("page") int page, @Query("per_page") int per_page);

}
