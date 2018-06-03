package application.taufiqrahman.com.ovto.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Taufiq on 5/8/2018.
 * Instance of Retrofit
 */

public class ApiClient {
    // http://10.0.2.2
    public static final String BASE_URL = "https://reqres.in/api/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
